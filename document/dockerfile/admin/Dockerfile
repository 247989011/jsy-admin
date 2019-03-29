FROM  java:8

#作者
MAINTAINER xuruiwu "1004738870@qq.com"

RUN    /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime &&  echo 'Asia/Shanghai' >/etc/timezone

#将工程代码加入到docker容器中
COPY . /

ENTRYPOINT java -jar -Dspring.profiles.active=prod  /mall-admin-0.0.1-SNAPSHOT.jar


