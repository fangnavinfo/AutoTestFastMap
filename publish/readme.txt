1、测试脚本说明如下：

autotest		自动测试脚本，会自动安装apk目录下的FastMap3.0HD-release.apk，之后进行测试。
autotest_no_install 	自动测试脚本，不会自动安装apk目录下的FastMap3.0HD-release.apk
apk目录			用于放置用于测试的最新FastMap包，以及自动化测试框架。
bat目录			用于放置调用的bat脚本
report目录		用于放置测试报告
tools目录		用于放置使用的工具程序，包括adb和mtee

2、测试时使用最新的fastmap3.0安装包替换apk目录下的安装包，运行autotest即可，观察界面打印结果。

3、界面上输出的信息会自动导出到report目录，生成一个以当前时间为名字的.log文件。


4、注意：autotest和autotest_no_install运行时都会清除已有的采集数据。而且autotest将会删除重建整个FastMap3.0目录

  
