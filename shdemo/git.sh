#!/bin/bash

if [ -d .git ]; 
	then
	echo 'Podaj komentarz'
	read commit
	
	if [  -e .gitignore ];
	then
		rm .gitignore
		echo 'Usunolem .gitignore'
	fi
	git add *
	git commit -m "$commit"
	git push
	
else
	echo 'Podaj nazwe repo'
	read repo
	git init
	if [  -e .gitignore ];
        then    
                rm .gitignore
                echo 'Usunolem .gitignore'
        fi
        echo 'Podaj komentarz'
        read commit
        git add *
        git commit -m "$commit"
	git remote add origin https://github.com/henio180/$repo.git
        git push origin master
fi
	
echo 'Thank you for using the script. I hope that it turned out to be useful.'
echo '****Copyright (c) 2011 (-:Henio:-). All rights reserved.****'
