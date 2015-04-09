import sys
import os

probNum = sys.argv[1]

folderName = "problem" + probNum
fileName = "Problem" + probNum + ".java"

madeFolder = False

if not (os.path.exists(folderName)):
	os.makedirs(folderName)
	madeFolder = True

if madeFolder:
	os.chdir(folderName)
	with open(fileName, 'w') as fout:
		fout.write("package " + folderName + ";\n")
		fout.write("\n")
		fout.write("public class " + "Problem" + probNum + " {\n")
		fout.write("\n")
		fout.write("}\n")


