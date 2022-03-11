#!/usr/bin/python3
# mt pro mano.
import os

# build
os.system("javac -d obj --source-path sauce sauce/Start.java")

# run
os.system("cd obj && java Start")
