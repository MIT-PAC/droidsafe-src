#Installation

1. Find your ~/.eclipse directory
2. Navigate to ~/eclipse/org.eclipse.platform_3.7.0_NUMBER/plugins
3. Restart eclipse.
4. There is now a Magpie drop-down menu on the toolbar.

#Additional Setup
1. Locate the PrettyPrinter.xml file.
2. Window->Preferences->Java->Code Style->Formatter
3. Select 'Import..'
4. Navigate to the PrettyPrinter.xml file.
5. Set Active Profile to 'Eclipse-Pretty'
6. Select 'Apply'

#Querying the Web for a file.
1. Select a source file from a project.
2. Select 'Magpie->Search the Web'
3. Let Magpie search the web. This may take a while.
4. The results are stored in MAGPIE-SRC/<PACKAGE PATH>/web

#Analyzing files
1. Select 'Magpie -> Analyze Code Origin'
2. Select 'do not show message again' for the two Sort-Members dialogs.
3. A compare dialog and file window will open. 
4. Browse sources in the file dialog. Click on CompilationUnit node to view diff.

