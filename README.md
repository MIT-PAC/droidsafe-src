Overview
========

The DroidSafe project develops novel program analysis techniques to
diagnose and remove malicious code from Android mobile applications.
The core of our system is a sound static analysis that can prove
important properties of sensitive program behaviors before the
programs appear in an application marketplace.  Our system greatly
improves the guarantees, efficiency, and effectiveness of malware
diagnosis.

Setup
=====

Dependencies
------------
* Java 1.7
* Ant
* Python 2.x
* Android 19 sdk
* PHP 5

Necessary Environment Variables
-------------------------------

* `ANDROID_SDK_HOME` - the root of the android sdk
    * DroidSafe currently requires Android API 19

* `DROIDSAFE_SRC_HOME` - the root of the project

Compiling
---------
Run *ant compile* in the project root.


Running
=======

Refer to [README in /bin](bin/README.md)

Eclipse Plugin 
==============

Refer to [[Wiki Page|wiki/Eclipse-Plugin-Instructions]]



Directory Structure
===================
* android-lib
  * Libraries for applications to use to accomplish particular tasks.
* bin
  * Packages and Executables of DroidSafe tool.
* config-files
  * Configuration files for the main DroidSafe tool including modeling and classification of APIs.
* lib
  * External libraries needed by the main DroidSafe tool.
* src
  * Source code for main DroidSafe analyses
* tools
  * Various non-DroidSafe tools to aid in malware detection and DroidSafe implementation. 
