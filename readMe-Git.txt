Use Windows cmds:
-------------------
cd to change directory
ls -al to list all files
cd.. back
mk create folder

Git:
-----
git config --global user.name "marwa"
git config --global user.email "mrwh.medhat.h@gmail.com"
git init (.git folder will be created in the project folder)
git status

To add on staging:
-------------------
git add filename.ext
git add .
git restore filename.ext

To add on repository:
-------------------
git commit -m "initial commit"

To get log:
-----------
git log
git log --oneline
git log --oneline --author="marwa"

To get the difference between local and staging area:
-------------------------------------------------------
git diff (press enter to get the next diff, and q to quit)

(Create the project on Git Hub, then)
git remote add origin https://xyz.git
git push origin master
git push u- origin name-of-branch

To control branches:
---------------------
git branch
git checkout -b name-of-branch

git pull origin main

*Working on main branch*
git add .
git commit -m "Checking Empty folders with .gitkeep"
git push origin main

To remove cashed files:
-----------------------
git rm --cached -r .
