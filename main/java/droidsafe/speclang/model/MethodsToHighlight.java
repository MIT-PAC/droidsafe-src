package droidsafe.speclang.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class keeps a set of of methods that should be highlighted in the outline display.
 * 
 * Add the soot signature of any method you want to highlight to the MethodsToHighlighArray below.
 * 
 * @author becker
 * 
 */
public class MethodsToHighlight {

  /**
   * Standard logger.
   */
  @SuppressWarnings("unused")
  private static final Logger logger = LoggerFactory.getLogger(MethodsToHighlight.class);


  /** The list of method signature in soot format that we want to highlight in the outline */
  private static final String[] METHODS_TO_HIGHLIGHT = {
      "<java.io.File: void <init>(java.lang.String)>",
      "<java.net.InetSocketAddress: void <init>(java.lang.String,int,boolean)>",
      "<android.net.Uri: void <init>(java.lang.String)>",
      "<java.net.URL: void <init>(java.lang.String)>",
      "<org.apache.http.client.methods.HttpGet: void <init>(java.lang.String)>",
      "<android.content.Intent: void <init>(java.lang.String)>",
      "<android.app.Activity: android.app.Dialog onCreateDialog(int)>",
      "<com.example.backupHelper.BackupTask: void onProgressUpdate(java.lang.Object[])>",
      "<java.io.Writer: void write(java.lang.String)>"

  };

  /** set of classes for quick lookups */
  private static Set<String> methodsToHighlight = new HashSet<String>(
      Arrays.asList(METHODS_TO_HIGHLIGHT));



  /**
   * Return true if the soot method signature is in the list of methods to highlight.
   */
  public static boolean shouldHighlightMethd(String sootMethodSignature) {
    return methodsToHighlight.contains(sootMethodSignature);
  }

  /**
   * Return true if the soot method signature is in the list of methods to highlight.
   */
  public static boolean shouldHighlightMethd(MethodModel method) {
    boolean result = methodsToHighlight.contains(method.getSootMethodSignature());
    //logger.debug("Size of methods to highlight " + methodsToHighlight.size()
    //    + " soot method signature = " + method.getSootMethodSignature() + "\n contains " + result);
    return result;
  }
}
