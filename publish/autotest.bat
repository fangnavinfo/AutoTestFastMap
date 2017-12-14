@echo off
if "%TIME:~0,1%"==" " (set NewTime=0%TIME:~1,7%) else (set NewTime=%TIME:~0,8%)
@echo on

cd bat
autotest.bat | ..\tools\mtee ..\report\%DATE:~0,4%%DATE:~5,2%%DATE:~8,2%-%NewTime::=%.log