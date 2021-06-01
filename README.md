# Mycd, an implementation of the linux command "cd"

## General information:

This program is an implementation of the linux "cd" command without changing into a directory, it prints out valid paths. The program simulates how cd checks for valid paths by ensuring the path contains alphanumeric characters and slashes. This is done by using a stack data structure which allows us to pop items from the stack if ".." is encountered. If a path is formatted in a valid manner it will be displayed, otherwise an error message is printed.

## Java setup & information:

Compile Mycd.java if you'd like to run it individually. Then run it in this format  "java Mycd src_path dest_path". 
Example: "java Mycd / home" in this example "/" is the src_path and "home" is the dest_path.

In order to run the test cases, first navigate to /src folder and run the following commands:


For compilation: javac -cp "../lib/junit-platform-console-standalone-1.7.0-all.jar" Mycd.java MycdTest.java


Running testcases after compiliation: java -jar ../lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --select-class MycdTest --reports-dir='reports'

## Python setup & information:

To run Mycd.py use this format "python3 Mycd.py src_path dest_path".

Example: "python3 Mycd.py /abc/def ghi" in this example "/abc/def" is the src_path and "ghi" is the dest_path.

To run the test cases use the following command: python3 -m unittest test_Mycd.py
