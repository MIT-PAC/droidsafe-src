This directory contains configuration files that define the model of
android for the droidsafe system.  Please put files in here that are
used by droidsafe as configuration files.

droidActions.txt: Defines the API actions that we support.  Gives the
api action name, arguments and the calls that are enabled by the
action.

system_class_files.txt: All the system classes in the version of
Android we are using.

system_calls.txt: A whitelist of api calls that categorizes calls
according to their safety and their modeling status in our system. If
a system call does not appear in this file, it cannot be called.
