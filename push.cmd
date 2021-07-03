@echo off
git add .
echo "commit message: "
set /p message=
git commit -m %message%
git push