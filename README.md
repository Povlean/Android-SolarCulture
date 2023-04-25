# Android-SolarCulture
开发环境：IDEA 后端

安卓前端：BigJobApplication
后端文件：andriod-solar-term

Android-Studio 前端＋移动后端

技术栈：SpringBoot + SSM + MySQL +MyBatis-Plus + Maven + Gradle 

安卓的技术栈不熟悉，不过逻辑简单应该能够看得懂。

大三上期的移动互联网开发课程期末项目。

自己写的安卓开发项目，设计到实践，后端到前端再到构架，一共花了12天，最后也被老师大大地肯定了！

该项目可优化的点：

1. 发送请求接受响应体的操作，可以放到后端做。
2. okHttp类的api可以再优化

-----------------2023年4月25日----------------

一开始这个仓库本身只是用来存储我的这个代码，并没有想过会有很多同学使用这个代码，并且问我一些代码上的问题。

于是我打算把这个项目重新完善了一次，在2023年4月25日这天对这个四个月前的项目进行了一次重整。

主要是对安卓的BigJobApplication文件进行了一次维护，因为上传该代码的时候，这个文件并不是特别健壮，适配性不强，所以我花了一天的时间重启了该文件。

重整之后的项目适配性应该非常强，我希望这次的重新整合能够帮助更多的小伙伴学习Java语言和Android项目，以及使用SSM（SpringBoot）来进行前后端的交互。

更新后的目录文件为
安卓前端：BigJobApplication
后端文件：SolartermBackend

这个Solarterm就是原先的andriod-solar-term，代码中的yml文件有改动，改动处为server.port，将默认的8080端口改为了8082

安卓前端BigJobApplication文件整合了gradle依赖和必要的环境搭建，安卓集成环境使用的是Android Studio，Java环境为JDK11，设备为Pixel 6 Pro API 27
