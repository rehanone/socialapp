call del /Q /F dist
call mvn clean install
call xcopy app\target\*.jar dist /Y

pause