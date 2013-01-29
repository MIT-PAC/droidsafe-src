package droidsafe.android.app.resources;

import java.lang.reflect.*;

import soot.SootClass;
import soot.SootMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

/**
 * Error that is thrown when an element (class, method, etc) does not
 * exist.  This is not necessarily indicative of a code error.  For example,
 * a manifest may refer to an activity that does not exist.
 */
public class MissingElementException extends Exception {
	private final static Logger logger = LoggerFactory.getLogger(MissingElementException.class);	

  public MissingElementException (SootClass cn, SootMethod m,
                                  String msg) {

    super (String.format ("{} in {}.{} at line {}", msg, cn.getName(), m.getName(),
                          SootUtils.getMethodLocation(m).getLine()));
  }

  public MissingElementException (String msg) {
    super (msg);
  }
}
