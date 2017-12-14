@echo off
set ADBCMD=..\tools\adb
@echo on

%ADBCMD% shell am force-stop com.example.fang.autotest