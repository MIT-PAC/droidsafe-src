
-include Makefile.user

export CLASSPATH := .:src:$(ANDROID_SDK_HOME)/platforms/android-15/android.jar

build: 
	cd src && javac -target 1.6 -source 1.6 edu/mit/csail/droidsafe/*.java
	cd src && jar cvf ../droidcalls.jar  edu/mit/csail/droidsafe/*.class

dump-vars:
	echo CLASSPATH = $$CLASSPATH

