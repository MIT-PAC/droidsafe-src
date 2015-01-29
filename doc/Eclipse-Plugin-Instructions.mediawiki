== How to install the Droidsafe Eclipse Plugin ==


This process uses ant to build and install the plugin. It requires editing a '''build.properties''' file.
* If you have installed a previous version of the Droidsafe plugin using '''HELP > Install new Software > Add ''', uninstall that version first:
** Click on the '''About Eclipse''' menu item. In Windows and Linux this menu item is under '''Help''', in MacOS, it is under the '''Eclipse''' menu.
** Click on the '''Installation Details''' button in the '''About Eclipse''' dialog. 
** Look for the Droidsafe plugin. Select it and click on the '''Uninstall''' button. 
** The plugin will be removed from your Eclipse installation.
* If Eclipse is currently running, exit Eclipse.
* I assume your are using Eclipse 4.2 (Juno) or 4.3 (Kepler). The plugin should also work on previous versions but I have not tested it in any other versions. 
* Build and install the droidsafe plugin using command:
  cd $APAC_HOME; ant clean compile plugin-deploy
* The first time you run this command you will get an error message telling you need to configure an ant property related to paths to eclipse installation.
* Edit file '''APAC_HOME/src/eclipse/build.properties''' and set correct values for '''target.eclipse.platform''' property at the top of the file. The value of this property should be the root of your eclipse installation -- the parent folder of the eclipse '''plugins''' folder.
  target.eclipse.platform=/home/my-eclipse-location/eclipse43/eclipse
* Run '''ant plugin-deploy''' again. 
* If ant succeeds, you should have a new eclipse plugin installed in the '''plugins''' directory of your eclipse installation.
* Start your eclipse.

----

== How to uninstall the Droidsafe Eclipse Plugin ==

* Remove the Droidsafe Eclipse plugin jar file '''droidsafe.eclipse.plugin.core_[version_number].jar''' from the folder '''ECLIPSE_HOME/plugins''', where ECLIPSE_HOME is the place where your eclipse is installed, and [version_number] is the version number Eclipse creates for the plugin when it is packaged. 
----

== How to run the Droidsafe Eclipse Plugin ==
* In Eclipse, open the Droidsafe perspective.
** Click on Window > Open Perspective > Other... > Droidsafe 
* Create a new Android project.
** Click on File > New > Project > Other > Android > Android Project from Existing Code. 
** Select one of the Android apps in the android-apps/engagements/**/apps folder and click finish. 
** The Android project should build in Eclipse without errors. If not, check the Android version of the app. Right click on the app in the project explorer and under the '''Android Tools''' context menu, try using '''Fix Project Properties'''.
* Generate a security spec for the Android app.
** Right click on the Android project, and under the Droidsafe menu you should see a Generate Security Spec command. 
** Run the command. See the progress either on the status bar on the bottom right corner or on the dialog window that opens asking if you want to run the process on the background. 
** Once the process finishes, the generated security spec will be displayed in the view tabbed '''Security Spec Outline''' and the high-level info flow summary will be displayed in the view tabbed '''Info Flow Summary'''.
* Inspect the security spec.
** Click on the tab '''Security Spec Outline''' to open the spec outline view. You can move the window around by clicking on the tab and dragging it into another panel. 
** The Outline view has a drop down menu on the top right corner of the view that allows to sort the view in different ways and to create outlines with different structures. 
** You can switch between *long* and *short* method signatures in the outline view. 
** The "+" and "-" icons on the window expands or collapses the views.
** Clicking on an outline node representing a method (call), will cause three other views to be updated accordingly.
*** '''Info Flow Details''' view shows detailed info flow analysis results computed for this method. Clicking on an outline node with source information opens the corresponding file location in the editor.
*** '''Values''' view shows the value analysis results computed for this method.
*** '''Points To Info''' view shows the pointer analysis results computed for this method. Clicking on an outline node with source information opens the corresponding file location in the editor. 
** Double clicking on the outline nodes opens the file location corresponding to that node in the editor. 
** From the context menu for an outline item, you can set the status of the node to '''SAFE''', or '''UNSAFE'''. The label if the node changes according to the node status.
** You can also add a method as a '''hotspot''' if the method has one or more arguments of type '''java.lang.String.'''  
* Inspect the high-level info flow summary.
** Click on the tab '''Info Flow Summary''' to open the high-level info flow summary view.
** The top level nodes contain source -> sink pairs for the selected Android app.
** Expanding a top level node, you will get a list of method calls with the corresponding source -> sink info flow.
** Clicking on a method call will update the contents of '''Info Flow Details''' view, ''' Values''' view, and '''Points To Info''' view to the corresponding information on the selected method call. The file location for the method call will also be opened in the editor.
* Droidsafe Persistence 
** After you run Droidsafe for the first time, a serialized version of the spec is saved in the droidsafe directory under the application root folder. 
** Hotspots and method status are also persistent.
** The next time you want to inspect the spec, just select the project, and click on the '''Security Spec Outline''' tab or the '''Info Flow Summary''' tab
* Droidsafe Preferences
** Under Windows > Preference > Droidsafe, you can set all of the options available through the command line.
* Remove the saved Droidsafe state for an app. 
** To reset the state of an application spec, just remove the '''droidsafe-gen''' folder in the application root folder and re-run droidsafe for the app. All method status and manually added hotspots will be removed.

----

== How to update the installed Droidsafe Eclipse Plugin ==

When you install the Droidsafe eclipse plugin into Eclipse using the '''ant clean compile plugin-deploy''' menu command described previously, Eclipse copies the droidsafe plugin jar file located in the droidsafe update site into the '''plugins''' folder located under the root of your Eclipse installation folder.

The droidsafe code is packaged as a jar file and placed in the droidsafe plugin jar file located under the '''plugins''' installation folder under Eclipse.

If you are running the installed version of the plugin (as opposed to running the plugin in development mode as explained below), and you are modifying the droidsafe code, you will need to update the plugin every time the droidsafe code changes. 

Updating the plugin usually means:
* Building the droidsafe jar files. 
* Copying the droidsafe jar files to the plugin source directories.
* Packaging the plugin into a jar file and copying this jar file to the plugin update site. 
* Updating or re-installing the droidsafe plugin into your eclipse by copying the plugin jar file to the '''plugins''' installation folder under Eclipse

The process for updating the installed plugin is the same as installing the plugin for the first time. 

* If Eclipse is currently running, exit Eclipse.
* Build and install the droidsafe plugin using command:
  cd $APAC_HOME; ant clean compile plugin-deploy
* If ant succeeds, you should have a new eclipse plugin installed in the '''plugins''' directory of your eclipse installation.
* Start your eclipse.

----
== How to build and develop the Droidsafe Eclipse Plugin ==

* You will need the Eclipse for RCP and RAP developers version of Eclipse, or you will need to install the Eclipse SDK and some of the plugin development tools for Eclipse from the Eclipse update site. 
* Start eclipse and select a workspace. 
* In eclipse, select File > Import > Existing Projects Into Workspace.
* Click Next
* Make sure Select root directory is selected, and click on the Browse button
* Select the eclipse folder under '''$APAC_HOME/src/eclipse'''
* When you click ok on the file browser, you should see a dialog with 3 selected eclipse projects. 
* Just click finish. Do not select any of the other options in the dialog. 
* In Eclipse, set the API baseline: 
** Under windows > Preferences > Plug-In Development > API Baselines, click on the Add Baseline button in the dialog window. 
** Select the root of your eclipse distribution (e.g., '''/home/becker/eclipse43/eclipse'''). 
** Give it any name, and click on the browse button. You will need to click the browse button even if the eclipse root folder is already in the dialog. 
** Click Finish. 
* Now you should be able to run the eclipse plugin. 
* Right click on the droidsafe.eclipse.plugin.core project and select run as an Eclipse Application. 
* A new Eclipse window should open. 
* In this new eclipse, click on File > New > Project > Other > Android > Android Project from Existing Code. 
* Select one of the Android apps in the android-apps/engagements/**/apps folder and click finish. 
* The Android project should build in Eclipse. 
* Right click on the Android project, and under the Droidsafe menu you should see a Generate Security Spec command. 
* Run the command. See the progress either on the status bar on the bottom right corner or on the dialog window that opens asking if you want to run the process on the background. 
* Once the process finishes, go to Window > Show View > Other > Droidsafe > Security Spec Outline and open the spec outline view. You can move the window around by clicking on the tab and dragging it into another panel. 
** The Outline view has a drop down menu on the top right corner of the view that allows to sort the view in different ways and to create outlines with different structures. 
** The "+" and "-" expands or collapses the views. 
** Double clicking on the outline nodes expands (or collapses) the node, and opens the file location corresponding to that node in the editor. 
** The context menu for the outline nodes has some commands that are not yet fully operational. 

* After you run Droidsafe for the first time, a serialized version of the spec is saved in the droidsafe directory under the application root folder. 
* The next time you want to inspect the spec, just select the project, and open the Droidsafe Spec Outline view from Windows > Show View > Other > Droidsafe > Security Spec Outline
* Under Windows > Preference > Droidsafe, you can set some of the options available through the command line. 