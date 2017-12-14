@echo off
set ADBCMD=..\tools\adb
@echo on

for /f %%i in ('%ADBCMD% shell "pm list packages | grep com.fastmap.hd"') do set PackageName=%%i
set PackageName=%PackageName:~8,-1%

%ADBCMD% shell am force-stop %PackageName%
%ADBCMD% uninstall %PackageName%
%ADBCMD% shell rm -rf /sdcard/FastMap*
%ADBCMD% install ../../apk/FastMap3.0HD-release.apk

set downmeta=true
set downnds=true
call autotest_no_install.bat %downmeta%,%downnds%