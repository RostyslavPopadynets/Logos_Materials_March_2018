@ECHO off
SET /P port=Enter port: 
FOR /f "tokens=5" %%p in ('netstat -aon ^|find "%port%"') DO IF NOT "%%p"=="0" c:\windows\system32\cmd.exe /c c:\windows\system32\taskkill.exe /PID %%p /F
PAUSE
