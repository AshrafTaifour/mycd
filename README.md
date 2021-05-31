# Mycd, an implementation of the linux command "cd"
## Java setup & info:

Compile Mycd.java if you'd like to run it individually. Then run it in this format  "java Mycd src_path dest_path". 
Example: "java Mycd / home" in this example "/" is the src_path and "home" is the dest_path.

In order to run the test cases, first navigate to /src folder and run the following commands:


For compilation: javac -cp "../lib/junit-platform-console-standalone-1.7.0-all.jar" Mycd.java MycdTest.java


Running testcases after compiliation: java -jar ../lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --select-class MycdTest --reports-dir='reports'
