@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
del ACTUAL.TXT

REM compile the code into the bin folder
javac  -cp ..\src\main\java -Xlint:none -d ..\bin ..\src\main\java\bob\*.java
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin bob.Bob < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT

REM Delete bob.txt if it exists, as this will affect the results
if exist "bob.txt" del "bob.txt"

IF ERRORLEVEL 1 (
    echo ********** TEST FAILED **********
    echo The contents of ACTUAL.TXT and EXPECTED.TXT do not match.
    exit /b 1
) ELSE (
    echo ********** TEST PASSED **********
    echo The contents of ACTUAL.TXT and EXPECTED.TXT match.
    exit /b 0
)

