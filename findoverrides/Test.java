
/**
 * <pre>
 * This program lists jdk classes that are overridded by the methods of
 * an android application.
 *
 * This program links to the verifier, sends bytecode from classes in two
 * lists (CLASS_LIST_1 and CLASS_LISt_2) to verifier, which does NOT verify
 * the bytecode, but adds classes and methods to Visitations.
 * Then for each method-a in CLASS_LIST_2 it ouputs each class
 * from CLASS_LIST_1 that contains a method that method-a overrides.
 *
 * o CLASS_LIST_1 edit to contain the .class and .jar files of the
 *                sdk and android lib.
 *
 * o CLASS_LIST_2 edit to contain the classes of the android application
 *
 * o To build class_relations file in the current directory:
 *   Copy the following two files to the directory that contains Test.java
 *   - verifier_classes.app should list the application class files 
 *   - verifier_classes.jdk.mac should list the android lib .jar files
 *                              and the jdk .jar files
 *   IMPORTANT: Each entry in CLASS_LIST_1 and CLASS_LIST_2 must also
 *              be present in one of these verifier_classes files
 *
 *   cd to dir where Test.java and the verifier_class.xxx files are
 *   export SSHOME=`pwd`
 *   export vibrance_home=`pwd`
 *   .../StaticAnalyzer/buildscript.py // Execute buildscript.py
 *
 * o Create the verifier jar file:
 *   cd to the .../pac/agent/verifier/ directory
 *   "ant jar"
 *
 * o Compile Test.java:      
 *   javac -cp <path/to/asm-debug-all-4.0.jar>:<path/to/verifier.jar> Test.java
 *
 * o Run THIS class:
 *   java -Xmx12g -cp .:<path/to/asm-debug-all-4.0.jar>:<path/to/verifier.jar> Test
 *
 * o In apac/droidsafe/android-apps/src/nfc-demo/project.properties
 *    change: target=android-16 => target=android-15
 * </pre>
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

import pac.agent.verifier.AsmOutput;
import pac.agent.verifier.MsgException;
import pac.agent.verifier.MyClassNode;
import pac.agent.verifier.ParentTree;
import pac.agent.verifier.ParentTree.TreeNode;
import pac.agent.verifier.Tracks;
import pac.agent.verifier.Visitations;

import org.objectweb.asm.tree.MethodNode;

class Test {

  final static int IS_JDK_METHOD = 1;

  // IMPORTANT each entry in CLASS_LIST_1 and CLASS_LIST_2 must also be present
  //          in eiter verifier_classes.app or verifier_classes.jdk.mac

  // Each entry can be a .class file a .jar file or a directory
  // If entry is a directory, is searched recursively for .class and .jar files
  // Each entry here must also be an entry either in verifier_class.jdk.mak
  // or verifier_classes.app
  final static Vector<String> CLASS_LIST_1 = new Vector<String>(Arrays.asList(new String[] {
    "/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Classes/classes.jar",
    "/Library/android-sdk-macosx/platforms/android-4.0.4/android.jar"
  }));


  // Each entry can be a .class file a .jar file or a directory
  // If entry is a directory, is searched recursively for .class and .jar files
  // Each entry here should also be an entry in verifier_classes.app
  final static Vector<String> CLASS_LIST_2 = new Vector<String>(Arrays.asList(new String[] {
    //
    // NO WORK no Makefile "../../android-apps/src/tomdroid/bin"

    // done "../../android-apps/src/recorder-malware/bin"

    // Must add to Makefile.user "export ANDROID_HOME=/Library/android-sdk-macosx"
    // done "../../android-apps/src/recorder/bin"

    // done "../../android-apps/src/nfc-demo/bin"
    // done "../../android-apps/src/intentservice/bin"

    // Needs android-11
    // NO WORK "../../android-apps/src/connectbot/bin"

    // done "../../android-apps/src/cfg/bin"
    // done "../../android-apps/src/async_task/bin"
    // done "../../android-apps/src/Yamba-8/bin"

    // Must add to Makefile.user "export ANDROID_HOME=/Library/android-sdk-macosx"
    // done "../../android-apps/src/SyncMyPix/bin"

    // done "../../android-apps/src/Shelves/bin"
    // done "../../android-apps/src/NotePad-clean/bin"
    // done "../../android-apps/src/HelloAndroid/bin"
    // done "../../android-apps/src/GpsCompass/bin/classes/com/pw/simplegps"
  }));


 /**
  * @parents This method fills parents with parents, grandparent, ... of
  *          the class.method given by treenode, methoname, desc.
  *          parents[parents.size()-1) contains the parent.
  *          parents[0] containts the great-great... grandparent
  */
  private static void get_parents_recurse(final Visitations visitations,
                                          final Vector<String> parents,
                                          final TreeNode treenode,
                                          final String methodname,
                                          final String desc) {

    final Vector<TreeNode> treenode_parents = treenode.get_parents();
    for(TreeNode tnode : treenode_parents) {
      final Visitations.VM vm = visitations.get_VisitedMethod(tnode.get_className(),
                                                              methodname,
                                                              desc);
      if (vm != null && vm.get_mark() == IS_JDK_METHOD) {
        parents.add(tnode.get_className());
      }

      get_parents_recurse(visitations, parents, tnode, methodname, desc);
    }
  }


  static int recursiveCheckAllClassFilesInDir(final File dirPath,
                                                    int class_count,
                                              final int options) throws MsgException {
    if (dirPath.isDirectory()) {
      // CUT AND PASTE from ByteCoeVerify.java
      //
      final File[] files = dirPath.listFiles();
      for (int i = 0; i < files.length; i++) {
        final File file = files[i];
        if (file.isDirectory()) {
          class_count = recursiveCheckAllClassFilesInDir(file,
                                                         class_count,
                                                         options); // MsgException
        } else {
          final String name = file.getName();
          if (name.endsWith(".class")) {
            try {
              final byte[] bytes = MyClassNode.classFileToByteArray(file); // MsgException
              final MyClassNode visitor = MyClassNode.verify(bytes,
                                                             null,
                                                             null,
                                                            -1,
                                                             options,
                                                             AsmOutput.ASM_OUTPUT.OUTPUT_TO_STDOUT);
              final String msg = visitor.getErrorMsg();
              if (msg != null && msg.length() > 0) {
                  System.out.println(msg);
              }
              final boolean success = visitor.success();
              if (success) {
                  class_count++;
              } else {
                  throw new MsgException("error detected");
              }
            } catch (MsgException ex) {
              throw new MsgException (
                      "ERROR while verifying classes in directory:" +
                       file.getParent() +
                      "\nProcessed " + class_count + " .class files\n" +
                      "Error occurred on the last file processed:" +
                       file.getPath()  + "\n" +
                      ex.getMessage());
            }

          } else if (name.endsWith(".jar")) {
            try {
              class_count += MyClassNode.visit_all_classes_of_jar(file,
                                            options); // MssgExcpetion
            } catch (MsgException ex) {
                throw(ex);
            }
          }
        }
      }
    }

    return class_count;
  }


  // Called twice: First call which_list set to CLASS_LIST_1
  //               Second call which_list set to CLASS_LIST_2
  //
  // o Convert each .class file in the list to bytecode
  // o Sends bytecode to verify.
  //   NO_VERIFICATION option is sent so bytecode is not verified and
  //     methods are added to Visitations.
  //     No asmlines are added.
  static void process_list(final Vector<String> which_list) throws MsgException {
    int options = AsmOutput.NO_VERIFICATION;

    int class_count = 0;

    for(String str : which_list) {
      if (str.endsWith(".class")) {
        final File file = new File(str);

        final byte[] bytes = MyClassNode.classFileToByteArray(file); // MsgException
        final MyClassNode visitor = MyClassNode.verify(bytes,
                                    null, // method name
                                    null, // label name
                                   -1,    // traversal number
                                    options, // Bit-or the various options
                                       // Options constants are listed in AsmOutput.java
                                    AsmOutput.ASM_OUTPUT.OUTPUT_TO_STDOUT);
        final String msg = visitor.getErrorMsg();
        if (msg != null) {
          System.out.println(msg);
        }

        if (!visitor.success()) {
          throw new MsgException("Error running verify");
        }

        class_count++;

      } else if (str.endsWith(".jar")) {
        final File file = new File(str);

        // visit_all_class_of_jar parses through .jar file and calls
        // MyClassNode.verify() for each encountered .class
        class_count += MyClassNode.visit_all_classes_of_jar(file,
                                                    options); // MsgException
      } else {
        final File file = new File(str);
        class_count = recursiveCheckAllClassFilesInDir(file,
                                                       class_count,
                                                       options);
      }

    } // loop verfying every .class

    System.out.println((which_list == CLASS_LIST_1 ?
                        "\nCLASS_LIST_1" : "\nCLASS_LIST_2") + 
                       ": Number of classes processed:" + class_count);
  }



  // At this point two groups of classes have been read in.
  // VMs from classes of the first list have mark set to IS_JDK_METHOD
  // VMs from classes of second list have mark 0.
  //
  // For each method-a in each CLASS_LIST_2 .class file:
  // output the names of all CLASS_LIST_1 classes containing
  // methods overriden by method-a
  //
  // Each element of the returned array is an class in CLASS_LIST_1
  // containing a method that is overriden by a class in CLASS_LIST_2
  // 
  static Vector<String> find_overrides() {
    final Vector<String> entry_points = new Vector<String>();

    final Visitations visitations = MyClassNode.visitations;
    final ArrayList<MyClassNode> myclassnodes = visitations.getMyClassNodes();
    int count = 0;
    for (MyClassNode myclassnode : myclassnodes) {
      final Collection<Visitations.VM> vmlist = visitations.get_VMs_of_classnode(myclassnode);
      final Object[] vm_array = vmlist.toArray();
      Visitations.VM vm = (Visitations.VM)vm_array[0];
      if (vm.get_mark() == 0) {
        for (int i = 0; i < vm_array.length; i++) {
          vm = (Visitations.VM)vm_array[i];
          // Vector<String> Is list of parent of child.
          //                Each parent string looks like "path/classname"
          //                Each class in the list has a method that child overrides
          final Vector<String> parents = new Vector<String>();
          final MethodNode methodnode = vm.get_methodnode();

          final MyClassNode cnode = vm.get_classnode();
          final String classname = cnode.name;
          final TreeNode treenode = ParentTree.findClassName(classname);
          if (treenode == null) {
              System.out.println("LIST_2 entry:" + classname + 
                                 " Not found in ParentTree.\n       " +
                                  classname +
                            " is perhaps missing from class_relations file.");
          } else {
              // Collect in parents the classnames of all classes that
              // are parents, grand-parents...etc of treenode and have
              // a method that treenode.methodname desc overrides
              get_parents_recurse(visitations,
                                  parents,
                                  treenode,
                                  methodnode.name,
                                  methodnode.desc);
          }

          if (parents.size() > 0) {
            System.out.println("\nList of classes from which " +
                                myclassnode.name + " inherits\n" + 
                               "and that contain methods overriden by:" +
                                myclassnode.name + "." +
                                methodnode.name + " " +
                                methodnode.desc);

            for (String parent_classnames : parents) {
              System.out.println("  " + parent_classnames);
            }

            count++;

            // Method vm is an android application         - vm.mark is 0
            // vm overrides a jdk or android system method - parents.size > 0
            // The jdk/android system method that vm overrides
            // is parents[parents.size-1]
            // Put the method that vm overrides in the String format
            // required by Tracks.set_entry_points(Vector<String>)
            // Add the Sting to the Vector entry_points
            final String class_name = parents.elementAt(parents.size() - 1);
            final String entry_point = class_name + "." +
                                       methodnode.name + " " +
                                       methodnode.desc;
            entry_points.add(entry_point); 
          }
        }
      }
    }

    if (count == 0) {
      System.out.println("No methods from classes in CLASS_LIST_1 over-ride methods from classes of CLASS_LIST_2");
    }

    return entry_points; 
  }


  static public void main(String[] args) {
    try {
      // Load bytecode of all classes of CLASS_LIST_1 into Visitations.
      // Mark every method wi IS_JDK_METHOD
      Test.process_list(CLASS_LIST_1); // MsgException
      final Visitations visitations = MyClassNode.visitations;
      visitations.mark_all_vms(IS_JDK_METHOD); 

      // Load bytecode of all classes of CLASS_LIST_2 in Visitations.
      Test.process_list(CLASS_LIST_2); // MsgException

      // At this point all VMs from CLASS_LIST_1 have mark set to IS_JDK_METHOD
      // and all VMs from CLASS_LIST_2 have 0 as their mark
      final Vector<String> overrides = Test.find_overrides();

      System.out.println("------------------- ");
      for(String str : overrides) {
        System.out.println(str);
      }

    } catch (MsgException ex) {
        System.out.println("ERROR: " + ex.getMessage());
    }
  }

}