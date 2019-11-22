## 社区  p23 47 time
#2019/11/12

#  git命令
#  git add .
#  git status
#  git commit -m "备注"
#  git push
#  git pull 从远程拉取代码



##资料
[github oauth文档](https://developer.github.com/apps/building-oauth-apps/)

# ctrl e   打开最近的文档
# ctrl alt o  移除没有用的import
# shift shift 快速查找
# alt insert get/set
# ctrl alt v 快速生成变量new user()


## 工具
[visual](https://www.visual-paradigm.com)



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


## flyway

#  mvn flyway:migrate

