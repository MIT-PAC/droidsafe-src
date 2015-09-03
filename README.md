Overview
========

The DroidSafe project develops novel program analysis techniques to
diagnose and remove malicious code from Android mobile
applications. The DroidSafe project is developed by MIT's Center for
Resilient Software and the Kestrel Institute. The core of our system
is a static information-flow analysis that operates on either Java
bytecode for an application or an application's APK. The DroidSafe
team co-designed a semantic model of Android runtime behaviors and a
static information-flow analysis to achieve acceptable precision,
accuracy, and scalability for real-world Android applications.

Setup
=====

* [Detailed instructions](https://github.com/MIT-PAC/droidsafe-src/wiki/Requirements)
* [Compiling the Analysis](https://github.com/MIT-PAC/droidsafe-src/wiki/Installing-the-Droidsafe-Analyzer)
* [Installing the Eclipse Plugin](https://github.com/MIT-PAC/droidsafe-src/wiki/Installing-the-Droidsafe-Eclipse-Plugin)
* [Running Analysis](https://github.com/MIT-PAC/droidsafe-src/wiki/Running-the-Droidsafe-Analyzer)
* [Running Eclipse Plugin](https://github.com/MIT-PAC/droidsafe-src/wiki/Running-the-Droidsafe-Eclipse-Plugin)


Directory Structure
===================
* android-apps
  * Example applications and Makefiles to simplify analysis runs
* android-lib
  * Libraries for applications to use to accomplish particular tasks.
* bin
  * Packages and Executables of DroidSafe tool.
* config-files
  * Configuration files for the main DroidSafe tool including logging.
* doc
  * Documents
* lib
  * External libraries needed by the main DroidSafe tool.
* Modeling
  * Current and old source code for Android semantic model.
* src
  * Source code for main DroidSafe analyses
* tools
  * Various non-DroidSafe tools to aid in malware detection and DroidSafe implementation. 
