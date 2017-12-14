@echo off
set ADBCMD=..\tools\adb
@echo on

for /f %%i in ('%ADBCMD% shell "pm list packages | grep com.fastmap.hd"') do set PackageName=%%i
set PackageName=%PackageName:~8,-1%

chcp 65001
%ADBCMD% shell am force-stop %PackageName%
%ADBCMD% shell input keyevent 3
%ADBCMD% shell am start -n %PackageName%/com.fastmap.hd.LoginActivity
ping -n 5 127.0.0.1>nul

%ADBCMD% uninstall com.example.fang.autotest.test
%ADBCMD% install ../apk/app-debug.apk>nul
%ADBCMD% install ../apk/app-debug-androidTest-unaligned.apk>nul

for /f %%i in ('%ADBCMD% shell "ls /sdcard/ | grep FastMap"') do set DirName=%%i
echo %DirName%
%ADBCMD% shell mkdir /sdcard/%DirName%/Data/Collect/3655/
%ADBCMD% push ../apk/keyboard.db /sdcard/%DirName%/Data/Collect/3655/
%ADBCMD% shell rm -rf /sdcard/%DirName%/Data/Collect/3655/coremap.*

start screen_record.bat

%ADBCMD% shell am instrument  --user 0 -w -r  -e debug false -e class com.example.fang.autotestfastmap.testFastMap com.example.fang.autotest.test/android.support.test.runner.AndroidJUnitRunner
pause