package com.macro.mall;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.macro.mall.generator.entity.ColumnEntity;
import com.macro.mall.generator.entity.GenConfig;
import com.macro.mall.generator.entity.TableEntity;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Slf4j
public class MybatisPlusCodeGenerator {

    private static final List<Map<String, Object>> logMapList = new ArrayList<>();


    public static void main(String[] args) {
        //配置信息
        Configuration config = getConfig();
        Connection connection = null;
        try {

            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl(config.getString("jdbc.url"));
            dsc.setDriverName(config.getString("jdbc.driver-class-name"));
            dsc.setUsername(config.getString("jdbc.username"));
            dsc.setPassword(config.getString("jdbc.password"));
            connection = dsc.getConn();

            String tableNames = config.getString("tableNames");
            String[] tableNameArr = tableNames.split(";");
            for (String tableName : tableNameArr) {
                if (StringUtils.isBlank(tableName)) {
                    continue;
                }
                addToLogList("表'{}'开始代码生成··· ",tableName);
                generatorOneTableCode(connection,tableName, config);
                addToLogList("表'{}'代码生成完毕!!! ",tableName);
            }
            print();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    private static void generatorOneTableCode(Connection connection, String tableName,Configuration config) {
        //查询表信息
        Map<String, String> table = new HashMap<String, String>();
        //查询列信息
        List<Map<String, String>> columns =new ArrayList<Map<String, String>>();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(
                    "select table_name tableName, engine, table_comment tableComment, create_time createTime from information_schema.tables\n" +
                    "\t\t\twhere table_schema = (select database()) and table_name = ?");
            ps.setString(1,tableName);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                table.put("tableName", resultSet.getString("tableName"));
                table.put("engine", resultSet.getString("engine"));
                table.put("tableComment", resultSet.getString("tableComment"));
                table.put("createTime", resultSet.getString("createTime"));
                break;
            }

            ps = connection.prepareStatement(
                    "select column_name columnName, data_type dataType, column_comment columnComment, column_key columnKey, extra from information_schema.columns\n" +
                            " \t\t\twhere table_name = ? and table_schema = (select database()) order by ordinal_position");
            ps.setString(1,tableName);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Map<String, String> column = new HashMap<String, String>();
                column.put("columnName", resultSet.getString("columnName"));
                column.put("dataType", resultSet.getString("dataType"));
                column.put("columnComment", resultSet.getString("columnComment"));
                column.put("columnKey", resultSet.getString("columnKey"));
                column.put("extra", resultSet.getString("extra"));

                columns.add(column);
            }
            generatorCode(new GenConfig(),config,table,columns);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    /**
     * 生成代码
     */
    public static void generatorCode(GenConfig genConfig,Configuration config, Map<String, String> table,
                                     List<Map<String, String>> columns) {

        boolean hasBigDecimal = false;
        //表信息
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(table.get("tableName"));

        if (StrUtil.isNotBlank(genConfig.getComments())) {
            tableEntity.setComments(genConfig.getComments());
        } else {
            tableEntity.setComments(table.get("tableComment"));
        }

        String tablePrefix;
        if (StrUtil.isNotBlank(genConfig.getTablePrefix())) {
            tablePrefix = genConfig.getTablePrefix();
        } else {
            tablePrefix = config.getString("tablePrefix");
        }

        //表名转换成Java类名
        String className = tableToJava(tableEntity.getTableName(), tablePrefix);
        tableEntity.setCaseClassName(className);
        tableEntity.setLowerClassName(StringUtils.uncapitalize(className));

        //列信息
        List<ColumnEntity> columnList = new ArrayList<ColumnEntity>();
        for (Map<String, String> column : columns) {
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName(column.get("columnName"));
            columnEntity.setDataType(column.get("dataType"));
            columnEntity.setComments(column.get("columnComment"));
            columnEntity.setExtra(column.get("extra"));

            //列名转换成Java属性名
            String attrName = columnToJava(columnEntity.getColumnName());
            columnEntity.setCaseAttrName(attrName);
            columnEntity.setLowerAttrName(StringUtils.uncapitalize(attrName));

            //列的数据类型，转换成Java类型
            String attrType = config.getString(columnEntity.getDataType(), "unknowType");
            columnEntity.setAttrType(attrType);
            if (!hasBigDecimal && "BigDecimal".equals(attrType)) {
                hasBigDecimal = true;
            }
            //是否主键
            if ("PRI".equalsIgnoreCase(column.get("columnKey")) && tableEntity.getPk() == null) {
                tableEntity.setPk(columnEntity);
            }

            columnList.add(columnEntity);
        }
        tableEntity.setColumns(columnList);

        //没主键，则第一个字段为主键
        if (tableEntity.getPk() == null) {
            tableEntity.setPk(tableEntity.getColumns().get(0));
        }

        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);
        //封装模板数据
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("tableName", tableEntity.getTableName());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getCaseClassName());
        map.put("classname", tableEntity.getLowerClassName());
        map.put("pathName", tableEntity.getLowerClassName().toLowerCase());
        map.put("columns", tableEntity.getColumns());
        map.put("hasBigDecimal", hasBigDecimal);
        map.put("datetime", DateUtil.now());

        if (StrUtil.isNotBlank(genConfig.getComments())) {
            map.put("comments", genConfig.getComments());
        } else {
            map.put("comments", tableEntity.getComments());
        }

        if (StrUtil.isNotBlank(genConfig.getAuthor())) {
            map.put("author", genConfig.getAuthor());
        } else {
            map.put("author", config.getString("author"));
        }

        if (StrUtil.isNotBlank(genConfig.getModuleName())) {
            map.put("moduleName", genConfig.getModuleName());
        } else {
            map.put("moduleName", config.getString("moduleName"));
        }

        if (StrUtil.isNotBlank(genConfig.getPackageName())) {
            map.put("package", genConfig.getPackageName());
            map.put("mainPath", genConfig.getPackageName());
        } else {
            map.put("package", config.getString("package"));
            map.put("mainPath", config.getString("mainPath"));
        }
        VelocityContext context = new VelocityContext(map);

        //获取模板列表
        List<String> templates = getTemplates();
        for (String template : templates) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, CharsetUtil.UTF_8);
            tpl.merge(context, sw);
            try {
                File file = new File(
                        getFileName(template, className, map.get("package").toString(), map.get("moduleName").toString()));
                if (file.exists()) {
                    addToLogList("文件'{}'被覆盖重写··· ",file.getPath());
                }else{
                    addToLogList("文件'{}'生成成功··· ",file.getPath());
                }

                FileUtil.touch(file);
                @Cleanup FileOutputStream fos = new FileOutputStream(file);
                //添加到zip
                IoUtil.write(fos, CharsetUtil.UTF_8, false, sw.toString());
                IoUtil.close(sw);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取配置信息
     */
    private static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 表名转换成Java类名
     */
    private static String tableToJava(String tableName, String tablePrefix) {
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "");
        }
        return columnToJava(tableName);
    }
    /**
     * 列名转换成Java属性名
     */
    private static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }
    /**
     * 获取文件名
     * @param template
     * @param className
     * @param packageName
     * @param moduleName
     * @return
     */
    private static String getFileName(String template, String className, String packageName, String moduleName) {
        String back1_packagePath = getConfig().getString("backProjectPath") + File.separator +
                getConfig().getString("bus.moduleName") + File.separator +
                "src" + File.separator + "main" + File.separator + "java" + File.separator +
                packageName.replace(".", File.separator)+ File.separator  + moduleName  + File.separator;
        String back2_packagePath = getConfig().getString("backProjectPath") + File.separator +
                getConfig().getString("model.moduleName") + File.separator +
                "src" + File.separator + "main" + File.separator + "java" + File.separator +
                packageName.replace(".", File.separator)+ File.separator  + moduleName  + File.separator;
        String front_packagePath = getConfig().getString("frontProjectPath") + File.separator + "src" + File.separator ;

        if (template.contains(ENTITY_JAVA_VM)) {
            return back2_packagePath + "model" + File.separator + className + ".java";
        }

        if (template.contains(MAPPER_JAVA_VM)) {
            return back2_packagePath + "mapper" + File.separator + className + "Mapper.java";
        }

        if (template.contains(SERVICE_JAVA_VM)) {
            return back1_packagePath + "service" + File.separator + className + "Service.java";
        }

        if (template.contains(SERVICE_IMPL_JAVA_VM)) {
            return back1_packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }

        if (template.contains(CONTROLLER_JAVA_VM)) {
            return back1_packagePath + "controller" + File.separator + className + "Controller.java";
        }

        if (template.contains(MAPPER_XML_VM)) {
            return getConfig().getString("backProjectPath") + File.separator +
                    getConfig().getString("model.moduleName") + File.separator +
                    "src" + File.separator + "main" + File.separator + "resources" + File.separator +
                    packageName.replace(".", File.separator)+ File.separator + moduleName +File.separator +
                    "mapper" + File.separator + className + "Mapper.xml";
        }

        if (template.contains(MENU_SQL_VM)) {
            return getConfig().getString("backProjectPath") + File.separator +
                    getConfig().getString("model.moduleName") + File.separator +
                    "src" + File.separator + "main" + File.separator + "resources" + File.separator +
                    "menuSql" + File.separator +
                    className.toLowerCase() + "_menu.sql";
        }

        if (template.contains(INDEX_VUE_VM)) {
            return front_packagePath + File.separator + "views" +
                    File.separator + moduleName + File.separator + className.toLowerCase() +
                    File.separator + "index.vue";
        }

        if (template.contains(API_JS_VM)) {
            return front_packagePath + File.separator + "api" + File.separator + moduleName +
                    File.separator + className.toLowerCase() + ".js";
        }
        if (template.contains(CRUD_JS_VM)) {
            return front_packagePath + File.separator + "const" +
                    File.separator + "crud" + File.separator + moduleName + File.separator + className.toLowerCase() + ".js";
        }
        return null;
    }



    private static final String ENTITY_JAVA_VM = "Entity.java.vm";
    private static final String MAPPER_JAVA_VM = "Mapper.java.vm";
    private static final String SERVICE_JAVA_VM = "Service.java.vm";
    private static final String SERVICE_IMPL_JAVA_VM = "ServiceImpl.java.vm";
    private static final String CONTROLLER_JAVA_VM = "Controller.java.vm";
    private static final String MAPPER_XML_VM = "Mapper.xml.vm";
    private static final String MENU_SQL_VM = "menu.sql.vm";
    private static final String INDEX_VUE_VM = "index.vue.vm";
    private static final String API_JS_VM = "api.js.vm";
    private static final String CRUD_JS_VM = "crud.js.vm";

    private static List<String> getTemplates() {
        List<String> templates = new ArrayList<String>();
        templates.add("template/Entity.java.vm");
        templates.add("template/Mapper.java.vm");
        templates.add("template/Mapper.xml.vm");
        templates.add("template/Service.java.vm");
        templates.add("template/ServiceImpl.java.vm");
        templates.add("template/Controller.java.vm");
        templates.add("template/menu.sql.vm");

        templates.add("template/index.vue.vm");
        templates.add("template/api.js.vm");
        templates.add("template/crud.js.vm");
        return templates;
    }

    public static void addToLogList(String msg, Object... param) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("param", param);
        logMapList.add(map);
    }

    public static void print() {
        log.info("########################################################################################");
        log.info("###################################### 输出代码生成结果 ###################################");
        log.info("######################################↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓###################################");
        for (Map<String, Object> map : logMapList) {
            String msg = map.get("msg").toString();
            Object[] params = (Object[]) map.get("param");
            log.info(msg,params);
        }
        log.info("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
        log.info("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
        log.info("###################################### 输出代码生成结果 ###################################");
        log.info("########################################################################################");
    }
}
