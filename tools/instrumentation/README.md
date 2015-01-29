Overview
========
The instrumention tool set consists of library, code, scripts to assist with android runtime instrumentation 
on the target devices.   It allows analyst to have better insight to the application as it runs.

Droidsafe instrumention tool consists of 5 pieces:

* Instrumentation code injection to the app
* Injected code library
* Associated build scripts
* Log collection 
* Log analysis/display

Setup:

1. Android `build-tools` and `platform-tools` should be in your path.

Instrumentation Code Injection
------------------------------
The instrumentation code injection process involves injecting instrumentation code at the points of interest.  
At this point we are injecting the instrumentation code before and after each method invocation.  Remember to build
the code injection jar before you do other pieces.

Injected Code
-------------
Injected code is provide as a library/hook so that they can be called at the points of interested.  Currently,
we provide logging functionality so that we can trace executation path of an application.

Build Scripts/Toos:
------------------
To automate the instrumentation process, a few scripts were added to the working environment.
* $APAC_HOME/android-apps/instr-setup.sh
  * This is kind of a single instruction that does most of the work.  Namely, it will do the following:
    ** create custom_rules.xml that android's build will pickup automatically
    ** perform application build
    ** perform code injection on .class files from bin/classes and save them under bin/classes.mod
    ** perform APK generation 
    ** update the APK to the device if adb connection has been already setup before.
* $APAC_HOME/toosl/instrumentation/bin/droidsafe-instr-insert
  * This is a wrapper script for instrumentation injection code
* $APAC_HOME/toosl/instrumentation/bin/logcat-capture.sh
  * This script perfoms a logcat capturing.  The output of this process is stored to a file for later analysis by call tree viewer.
* $APAC_HOME/tools/instrumentation/bin/droidsafe-trace-viewer: 
  * This is the wrapper script to invoke the GUI to view logcat trace.  It allows the analyst to view runtime execution call graph with possible parameter values.  Currently if there is an exception in the callgraph, the tool may misguide you.

Log Analysis/Display:
--------------------
There is standalone tool under gui directory that will help with displaying the calltree.  It's written on netbean
IDE.  It may need a little tweak to run on the VM.

How to Run:
===========
Let's start with PickContacts as an example.  
1. Go to PickContacts application folder
2. Connect to the target device via adb command:
  * `adb connect <device_ip>`
  * this step should only be done once.  After which an adb daemon is running in the background and device
  can be controlled via `adb` command.
3. Run instr-setup.sh script 
  * `$APAC_HOME/android-apps/instr-setup.sh .`
  * This process should build the API with proper injection libary code injected.
4. Collect log:
  * `ant logcat`
  * This will keep the log to file 'logcat.txt' in the app directory
5. Launch the application from the target device & interfact with the app
6. Once Step 5 is done, hit Ctrl-C to stop logcat collection.  
7. The file logcat.txt can be analyzed by the GUI tool or human should be able to read it as well.
8. To invoke the GUI, type `ant trace-viewer` to invoke the GUI.  When the GUI is open, you need to load 2 files (classification and logcat.txt).  The classification for engangement 3b is located under APAC_HOME/android-apps/classification.  The locagat file  is the one generated from step 4.  Once both of the load, you should see the calltree.  When an API is in one of the SPEC/SINK/BAN, then it is displayed in RED.

If you would like to rerun instrumentation again do:
  * `ant instr`   

This will rerun step 3. without copying setup files again

Once the instrumentation is done and you do not want the instrumentation code to be part of the app, do:
  * `ant instr-remove` to remove the instrumention from a normal build process.

Hopefully, this will bring some values...

  
