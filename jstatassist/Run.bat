@echo off
SET curPath=%~dp0
java -Xbootclasspath/a:"%JAVA_HOME%\lib\tools.jar" -jar jstatassist-0.0.1-loadagent.jar %1 %curPath%
pause