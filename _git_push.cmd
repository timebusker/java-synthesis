color 0a
@echo off & setlocal
chcp 65001 > nul
:: 后续代码使用UTF-8编码

:: cd img/top-photo/
:: call 0-rename-jpg.bat
:: cd ..

set var=":sun_with_face::sunflower::palm_tree::house_with_garden::office::octocat::guitar::meat_on_bone:"
set d=%date:~0,10%
set t=%time:~0,8%
git add .
git commit -am"%d% %t% _ 提交代码"
git push  origin master