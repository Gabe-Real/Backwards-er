@echo off
setlocal

:: Set working directory to the folder of this script
cd /d "%~dp0"

:: Compile the Java file
echo Compiling ReverseInput.java...
javac -encoding UTF-8 ReverseInput.java
if errorlevel 1 (
    echo.
    echo ❌ Compilation failed. Press any key to exit.
    pause >nul
    exit /b
)

:: Run the compiled Java class
echo.
echo Running ReverseInput...
java ReverseInput

echo.
echo Done. Press any key to exit.
pause >nul
