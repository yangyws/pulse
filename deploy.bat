@echo off
chcp 65001 >nul
powershell.exe -NoProfile -ExecutionPolicy Bypass -File "%~dp0deploy.ps1" %*
if %ERRORLEVEL% NEQ 0 (
    echo.
    echo Deployment failed with error code %ERRORLEVEL%.
)
echo.
pause
