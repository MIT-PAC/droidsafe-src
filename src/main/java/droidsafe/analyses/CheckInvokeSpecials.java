package droidsafe.analyses;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.rcfg.RCFG;
import droidsafe.utils.SootUtils;
import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.util.Chain;

/**
 * We change the semantic of the invoke special call in soot.  So we need to check if there are any 
 * uses of special invoke that, with our new semantics, will violate the java execution... 
 * 
 * @author mgordon
 *
 */
public class CheckInvokeSpecials {
    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(CheckInvokeSpecials.class);

    private CheckInvokeSpecials() {
        // TODO Auto-generated constructor stub
    }

    public static void run() {
        for (SootClass clz : Scene.v().getClasses()) {
            for (SootMethod method : clz.getMethods()) {
                if (method.isAbstract() || !method.isConcrete())
                    continue;
                
                try {
                	method.retrieveActiveBody();
                }
                catch (Exception ex) {
                	logger.info("Exception retrieving method body {}", ex);
                	continue;
                }

                Body body = method.getActiveBody();
                StmtBody stmtBody = (StmtBody)body;
                Chain units = stmtBody.getUnits();
                Iterator stmtIt = units.iterator();

                while (stmtIt.hasNext()) {
                    Stmt stmt = (Stmt)stmtIt.next();

                    if (stmt.containsInvokeExpr() && stmt.getInvokeExpr() instanceof SpecialInvokeExpr) {
                        SpecialInvokeExpr si = (SpecialInvokeExpr) stmt.getInvokeExpr();

                        SootMethodRef mRef = si.getMethodRef();
                        //checkdoes not hold for init calls
                        if ("<init>".equals(SootUtils.grabName(mRef.getSignature())))
                            continue;
                        
                        //if the classes on the target and the container are equal, then don't check for our
                        //semantics change
                        SootClass targetClz = Scene.v().getSootClass(SootUtils.grabClass(mRef.getSignature()));
                        if (targetClz == clz)
                            continue;
                        
                        try {
                            
                            
                            boolean safe = SootUtils.findClosetMatch(clz.getSuperclass(), si.getMethodRef()) ==
                                    SootUtils.findClosetMatch(targetClz, si.getMethodRef());
                            
                            if (!safe) 
                                logger.warn("Found invokespecial call that is unsound: {} in {}",
                                    si, method);
                            
                            /*
                            if (targetClz != method.getDeclaringClass() &&  
                                    (!method.getDeclaringClass().hasSuperclass() ||
                                            targetClz != method.getDeclaringClass().getSuperclass())) {
                                logger.warn("Found invokespecial that does not call current or parent: {} in {}",
                                    si, method);
                            } */

                        } catch (Exception e) {
                            //probably can't find the target class
                        }


                    }
                }
            }
        }
    }
}

