Description
-----------

objsenspark is a driver for running the 'object sensitive Spark PTA' used by droidsafe on non-android java programs.

Environment setup
-----------------

This tool uses some library jars in the droidsafe lib directory. Before building/running the tool, You need to set the
environment variable APAC_HOME to the droidsafe root directory.

Building the tool
-----------------

To compile/build the tool, run command line

    ant

in this directory. The resulting jar file is 

    objsenspark.jar

Using the tool
--------------

run command line

    ./objsenspark -help

in this directory to print the options for using the tool.
