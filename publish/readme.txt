1、win和mac目录放置不同环境下的测试脚本。

2、测试脚本说明如下：

autotest		自动测试脚本，会自动安装apk目录下的FastMap3.0HD-release.apk，之后进行测试。
autotest_no_install 	自动测试脚本，不会自动安装apk目录下的FastMap3.0HD-release.apk
force_stop_autotest	强制终止测试的脚本
screen_record		录屏脚本，autotest.bat和autotest_no_install.bat中会自动调用，不要手工执行。
3、测试时使用最新的fastmap3.0安装包替换apk目录下的安装包，运行autotest即可，观察界面打印结果。

4、注意：autotest和autotest_no_install运行时都会清除已有的采集数据。而且autotest将会删除重建整个FastMap3.0目录
