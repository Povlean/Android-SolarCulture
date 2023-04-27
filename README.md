# Android-SolarCulture 
### 二十四节气文化介绍项目
开发环境：IDEA + Android Studio

安卓文件：BigJobApplication
后端文件：andriod-solar-term

Android-Studio 前端＋移动后端

技术栈：SpringBoot + SSM + MySQL +MyBatis-Plus + Maven + Gradle 

安卓的技术栈不熟悉，不过逻辑简单应该能够看得懂。

大三上期的移动互联网开发课程期末项目。

自己写的安卓开发项目，设计到实践，后端到前端再到构架，一共花了12天，最后也被老师大大地肯定了！

该项目可优化的点：

1. 发送请求接受响应体的操作，可以放到后端做。
2. okHttp类的api可以再优化

### -----------------2023年4月25日----------------

一开始这个仓库本身只是用来存储我的这个代码，并没有想过会有很多同学使用这个代码，并且问我一些代码上的问题。

于是我打算把这个项目重新完善了一次，在2023年4月25日这天对这个四个月前的项目进行了一次重整。

主要是对安卓的BigJobApplication文件进行了一次维护，因为上传该代码的时候，这个文件并不是特别健壮，适配性不强，所以我花了一天的时间重启了该文件。

重整之后的项目适配性应该非常强，我希望这次的重新整合能够帮助更多的小伙伴学习Java语言和Android项目，以及使用SSM（SpringBoot）来进行前后端的交互。

更新后的目录文件为
安卓前端：BigJobApplication
后端文件：SolartermBackend

这个Solarterm就是原先的andriod-solar-term，代码中的yml文件有改动，改动处为server.port，将默认的8080端口改为了8082

安卓前端BigJobApplication文件整合了gradle依赖和必要的环境搭建，安卓集成环境使用的是Android Studio，Java环境为JDK11，设备为Pixel 6 Pro API 27

# -----------------完成效果图----------------
### 前后端打通需要修改android中常量的ip地址，将字符串常量修改为自己的ip:端口号。
登录界面：

登录首先需要把sql中原有的数据清空，因为该校验先会在前端的内存数据进行校验的，校验完成之后才会校验后端。

如第一次使用，需要先清空user表的数据，然后注册新的账号即可。

![login](https://github.com/Povlean/Android-SolarCulture/blob/main/image/login.jpg)

注册页面：

![register](https://github.com/Povlean/Android-SolarCulture/blob/main/image/register.jpg)

首页界面：

![main](https://github.com/Povlean/Android-SolarCulture/blob/main/image/main.jpg)

卡片效果：

卡片效果为静态页面的展示，该卡片是冬季的页面效果，其余的三个季节也是可以点开的，如果遇到点开崩溃的情况，请找到对应代码删除图片。

![mainCard](https://github.com/Povlean/Android-SolarCulture/blob/main/image/mainCard.jpg)

发现页卡片：

点击之后，会有几秒的反应时间，因为子线程承担了发送请求的逻辑，线程运行需要阻塞以达到数据同步。

![find](https://github.com/Povlean/Android-SolarCulture/blob/main/image/find.jpg)

卡片编辑：

该处有BUG，按返回键app会崩溃，需要点击手机的返回键。如有可优化的方案，请高人留言。

该卡片不可编辑题目，只能编辑内容，因为题目会作为更新的校验标准。

![card](https://github.com/Povlean/Android-SolarCulture/blob/main/image/card.jpg)

个人信息：

个人信息页面不能更改名称，因为数据库列表中需要根据名称来进行查找数据的操作，用户名具有唯一性。

注册时无法注册用户名相同的用户，也是确保了用户名的唯一性。

年龄，喜欢的食物，出生季节可以进行编辑，编辑完成之后，需要点击修改按钮，当修改完成之后，数据库中的数据就会更新。

![info](https://github.com/Povlean/Android-SolarCulture/blob/main/image/info.jpg)

如有问题，可以添加微信进行询问

![vx](https://github.com/Povlean/Android-SolarCulture/blob/main/image/vx.jpg)

结语：该项目是我大三上学期写的android项目，因为只用了课上的内容和一些较为简单的知识补充做出的项目，可优化的点也有很多，BUG也有地方没有修复。该项目仅供学习交流使用。
