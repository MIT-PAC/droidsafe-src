To Run DroidSafe:

0. Software Dependencies
* Java 1.6+
* Python 3.2
* Ant
* Graphviz (dot)
* Android SDK ver 4.0.3 installed
  * Set ANDROID_SDK_HOME environment variable to root directory of your android SDK

1. Environment variables
* Set APAC_HOME to point to .. (root of apac repo, .. of this directory)
* Set ANDROID_SDK_HOME environment variable to root directory of your android SDK
* Add APAC_HOME/bin to your path

2. run droidsafe from this directory.

usage: droidsafe [-h] [-o dir] [-r dir] [-a file] [-s file] [pass]

DroidSafe Tools

positional arguments:
  pass                  The pass to run: pegspeccheck, specdump, peg-extract
                        (default: pegspeccheck)

optional arguments:
  -h, --help            show this help message and exit
  -o dir, --outputdir dir
                        Output directory for droidsafe, assumed to be . if not
                        specified
  -r dir, --approot dir
                        Application root directory, used to analyze source
                        when available.
  -a file, --apk file   Apk for android application, if not specified, will
                        search for apk in approot
  -s file, --secspec file
                        Security specification file

For pegspeccheck (check an application against a specification):

To view the output:
1. open work.dir/droidblaze_output/summary.html
2. click on results link for the one successful run
3. Task peg-extract will have the peg, click on [log] and search for "ANALYSIS RESULTS"
4. Task secspecparser will have a dump of the security spec, click on [log] to see it
5. Task pegspeccheck is the conformance check, click on [log] to see the output


For specdump:

This pass will produce a [almost legal] security specification of an
application. 


outputdir is the directory to dump the output of the analysis (it does
not have to exist).  If you have the source code, and it is compiled
(to produce class files and the apk), you can provide the application
root directory.  Providing the -r argument will tell the analysis to
try to resolve resource names (like UI elements) from the xml files
included in the source.

To view the output:

1. open outputdir/droidblaze_output/summary.html
2. click on results link for the one successful run
3. Task specdump will have the specification, click on [log] 
4. The security specification is organized by components.  Search for
"component" to see the start of each component.
5.  Each component has a list of the event handlers, and for each
event handler, the system calls that could be called.

For large applications the security specification will be quite long;
we are currently working on means to make it more concise by grouping
calls.  

Right now, all system calls are reported.  This include (normally
benign) calls like setting up UIs, displaying images, database calls,
etc.  Our next step is to prioritize calls based on their potential
for abuse.

For certain UI handlers, if the application root directory is
provided, we resolve the view ID from the xml file.

For example:

id.ImageButton02 android.view.View$OnClickListener: void onClick(android.view.View)
{
	android.media.MediaRecorder: void release()
	android.media.MediaRecorder: void stop()
	android.view.View: void setEnabled(boolean)
}

id.ImageButton02 was pulled from the xml file that was used to inflate
the layout on which id.ImageButton02 is placed.

Without the approot.dir argument, you will see an integer value
corresponding to the integer constant used in the class file for the
UI element. 



