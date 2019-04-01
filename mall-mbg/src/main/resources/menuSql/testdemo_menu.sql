-- 该脚本不要执行，请完善 ID 对应关系,注意层级关系 !!!!

-- 一级菜单SQL ：如系统管理

INSERT INTO `mall`.`sys_menu`( `parent_id`, `menu_id`, `name`, `permission`, `path`, `url`, `icon`, `component`, `sort`, `type`)
    VALUES ( -1, '父菜单ID', '管理', '', '/demo', '', '', 'Layout', 5, '0');

-- 菜单SQL  ： 如系统管理下的用户管理

insert into `sys_menu` ( `parent_id`, `component`, `permission`, `type`, `path`, `icon`, `menu_id`, `sort`,  `name`)
    values ( '父菜单ID', 'views/demo/testdemo/index', '', '0', 'testdemo', 'icon-bangzhushouji', '菜单ID', '8', '列表');

-- 菜单对应按钮SQL  ： 用户管理下的按钮组
insert into `sys_menu` ( `parent_id`, `url`,`component`, `permission`, `type`, `path`, `icon`, `menu_id`, `sort`,  `name`)
    values ( '菜单ID','demo:add', null, 'demo_testdemo_add', '1', null, '1', '子按钮ID1' , '0', '新增');
insert into `sys_menu` ( `parent_id`, `component`, `permission`, `type`, `path`, `icon`, `menu_id`, `sort`,  `name`)
    values ( '菜单ID','demo:edit', null, 'demo_testdemo_edit', '1', null, '1', '子按钮ID2' , '1', '修改');
insert into `sys_menu` ( `parent_id`, `component`, `permission`, `type`, `path`, `icon`, `menu_id`, `sort`,  `name`)
    values ( '菜单ID','demo:del', null, 'demo_testdemo_del', '1', null, '1', '子按钮ID3' , '2', '删除');
