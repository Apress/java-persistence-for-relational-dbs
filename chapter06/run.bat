@ECHO OFF

if ""%JAVA_HOME%""=="""" goto noJavaHome

rem Slurp the command line arguments. This loop allows for an unlimited number
rem of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=%1
if ""%1""=="""" goto doneStart
shift
:setupArgs
if ""%1""=="""" goto doneStart
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto setupArgs
rem This label provides a place for the argument list loop to break out 
rem and for NT handling to skip to.
:doneStart

set LOCALCLASSPATH=classes;%CLASSPATH%
for %%i in (lib\*.jar) do call lcp.bat %%i
for %%i in (lib\ext\*.jar) do call lcp.bat %%i
goto run

:noJavaHome
ECHO JAVA_HOME was not set, please set this environment variable
goto exit

:run
%JAVA_HOME%\bin\java -classpath %LOCALCLASSPATH% %CMD_LINE_ARGS%

:exit