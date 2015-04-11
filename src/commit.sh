
git status
read -r -p "Would you like to continue (y/n)" inp

case $inp in
	[yY])
		git add .
		if [ -n "$1" ]
		then
			git commit -m "$1"
			git push
		else
			echo "Please add a Git Message"
		fi
		;;
	*)
esac
