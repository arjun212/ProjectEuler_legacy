
git add .
if [ -n "$1" ]
then
	git commit -m "$1"
	git push
else
	echo "Please add a Git Message"
fi
