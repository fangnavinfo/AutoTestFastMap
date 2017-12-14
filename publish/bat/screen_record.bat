@echo off
if "%TIME:~0,1%"==" " (set NewTime=0%TIME:~1,7%) else (set NewTime=%TIME:~0,8%)
set ADBCMD=..\tools\adb
@echo on

%ADBCMD% shell rm -rf /sdcard/autotest/
%ADBCMD% shell mkdir /sdcard/autotest/
%ADBCMD% shell screenrecord /sdcard/autotest/%DATE:~0,4%%DATE:~5,2%%DATE:~8,2%-%NewTime::=%.mp4 
%ADBCMD% shell screenrecord /sdcard/autotest/%DATE:~0,4%%DATE:~5,2%%DATE:~8,2%-%NewTime::=%.mp4