# house
**基于ssm的房屋租赁管理系统**  

## 1.部署相关
[编写Dockerfile定制tomcat8镜像](https://www.yuque.com/shihuangzhedebiji/web-server/dwxivb)

我在pom打包时把war包放在了docker文件夹下   

**Dockerfile** 
```bash
# 直接从docker提供的远程镜像仓库中拉取最新的tomcat组件
FROM tomcat:8.5.51

# 本镜像的制作者的信息
MAINTAINER "eyck.cui" <eyck.cui@foxmail.com>

# 把该容器的时区设置为上海时区
ENV TZ=Asia/Shanghai

# 把当前文件目录下的docker-ssm.war移动到容器中tomcat自动启动的目录下
COPY ./house.war /usr/local/tomcat/webapps/
```
### 1.1 打包

![打包](http://ww1.sinaimg.cn/large/d1db9fd3gy1ga48p0s8dzj212o0jajuc.jpg)

### 1.2 服务器docker库

![服务器docker库](http://ww1.sinaimg.cn/large/d1db9fd3gy1ga48qvpokyj20y50om3zz.jpg)

### 1.3 docker-compose部署 

![docker-compose部署](http://ww1.sinaimg.cn/large/d1db9fd3gy1ga48tuufucj211j0lhju4.jpg)

## 功能介绍

- 房源信息模块 
    - 房源信息展示
    - 房源信息更新 
    - 房源信息增加 
    - 房源信息删除    
- 账户管理模块 
    - 账户登录 
    - 账户绑定 
    - 账户管理   
- 租金结算模块
    - 每月租金信息
    - 租金交付功能
    - 月租金收入总额统计  
- 房屋租赁合同管理模块
    - 房屋租赁合同录入
    - 房屋租赁合同展示
    - 房屋租赁价格修改
    - 房屋租赁合同终止  
- 报障模块
    - 租客报账
    - 管理员报障审核
    - 租客报障统计   
- 日程模块 
    - 收租日程显示
## 框架介绍
原始项目：  
  - Spring 
  - SpringMVC
  - MyBatis
  - MySQL数据库
  - Tomcat服务器  
  
 新增：  
  - Docker部署
  - Maven 项目版本管理工具


## 项目功能部分截图
登录  
- 管理员帐户:`admin` 密码：`12345`  
- 租客帐户：`zyx` 密码：`123456`  
![Alt text](https://github.com/chiuwingyan/house/blob/master/img/1.png)
![Alt text](https://github.com/chiuwingyan/house/blob/master/img/2.png)
![Alt text](https://github.com/chiuwingyan/house/blob/master/img/3.png)
![Alt text](https://github.com/chiuwingyan/house/blob/master/img/4.png)
![Alt text](https://github.com/chiuwingyan/house/blob/master/img/5.png)
![Alt text](https://github.com/chiuwingyan/house/blob/master/img/6.png)

## Demo地址

[Demo在线](http://47.101.145.181:9898/house/login.action)  

个人服务器跑的,请勿瞎搞谢谢
