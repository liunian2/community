## 社区  p34
```text
## git命令
#  git add .
#  git status
#  git commit -m "备注"
#  git push
#  git pull 从远程拉取代码
```
```text
## 快捷键
# ctrl e   打开最近的文档
# ctrl alt o  移除没有用的import
# shift shift 快速全局查找
# alt insert get/set
# ctrl alt v 快速生成变量new user()
# ctrl alt shift ?  打开idea配置  例如配置项目运行时自动编译
# ctrl alt 左箭头  快速打开上一次查看的位置
```

## 资料
[github oauth文档](https://developer.github.com/apps/building-oauth-apps/)

## 工具
[visual](https://www.visual-paradigm.com)
[bootstrap](https://v3.bootcss.com/)
[菜鸟教程](https://www.runoob.com/)
[maven仓库](https://mvnrepository.com/)
[springboot文档](https://docs.spring.io/spring-boot/docs/2.0.0.RC2/reference/htmlsingle/)
[spring文档](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#spring-webflux)
[okHttp](https://square.github.io/okhttp/)
[lombok](https://projectlombok.org/)
[alibaba](https://developer.aliyun.com/special/tech-java?spm=a2c41.13037006.0.0%20csdn)
[thymeleaf](https://www.thymeleaf.org/)
[Mybatis Generator](http://mybatis.org/generator/)

[elastic](https://elasticsearch.cn/explore)
[github-community](https://github.com/liunian2/community)

## 脚本
```sql
CREATE TABLE USER(
    ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACCOUNT_ID VARCHAR(100),
    TOKEN CHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT
);
```
# flyway
# mvn flyway:migrate
# mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate

# JRebel 热部署工具(收费)
# spring-boot-devtools 热部署工具

## chrom插件
# onetab
# liveReload

```text
vi ~/.bash_profile
source ~/.bash_profile

#set java environment
export JAVA_HOME=G:/IDEA/jdk8/jdk-8u221
export JRE_HOME=${JAVA_HOME}/jre
export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib:$CLASSPATH
export PATH=$JAVA_HOME/bin:$JRE_HOME/bin:$JAVA_HOME:$PATH

#set maven environment
export MAVEN_HOME=G:/IDEA/IntelliJ IDEA 2018.2.2/plugins/maven/lib/maven3
export PATH=$MAVEN_HOME$/bin:$PATH
```