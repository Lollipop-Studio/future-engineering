@echo off
git add .
echo 请输入 commit 信息：
set /p message=
git commit -m %message%
git push