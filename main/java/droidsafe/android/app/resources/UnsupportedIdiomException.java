package droidsafe.android.app.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.utils.SootUtils;

import java.lang.reflect.*;

import soot.SootClass;
import soot.SootMethod;

/**
 * Error that is thrown when the code does not follow our required
 * Idioms
 */
public class UnsupportedIdiomException extends Exception {
	private final static Logger logger = LoggerFactory.getLogger(UnsupportedIdiomException.class);	
	
  public UnsupportedIdiomException (SootClass cn, SootMethod m,
                                    String msg) {

    super (String.format ("{} in {}.{} at line %d", msg, cn.getName(), m.getName(),
                          SootUtils.getMethodLocation(m).getLine()));
  }

  public UnsupportedIdiomException (String msg) {
    super (msg);
  }
}
