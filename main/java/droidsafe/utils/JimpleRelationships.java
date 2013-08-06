package droidsafe.utils;

import java.util.HashMap;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.RequiredModeling;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.ValueBox;
import soot.jimple.Expr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.util.Chain;

/**
 * This class generates maps of relationships between Jimple objects like
 * expressions, statements, and methods.
 * 
 * @author mgordon
 *
 */
public class JimpleRelationships {
    /** logger field */
    private static final Logger logger = LoggerFactory.getLogger(JimpleRelationships.class);
    /** Map of expr to enclosing statement */
    private HashMap<Expr, Stmt> exprToStmt;
    /** map of statement to enclosing SootMethod */
    private HashMap<Stmt, SootMethod> stmtToMethod;
    /** Static singleton */
    private static JimpleRelationships v;
    
    /** 
     * Return static singleton object.
     */
    public static JimpleRelationships v() {
        if (v == null) {
            v = new JimpleRelationships();
        }
        return v;
    }
    
    /**
     * Regenerate underlying maps.  Used if there has been jimple transforms run.
     */
    public static void reset() {
        v = new JimpleRelationships();
    }
    
    /**
     * Regenerate underlying maps.
     */
    private JimpleRelationships() {
        logger.info("Calculating Jimple relationships...");
        exprToStmt = new HashMap<Expr, Stmt>();
        stmtToMethod = new HashMap<Stmt, SootMethod>();
        //build maps of relationships by iterating over all user classes:
        for (SootClass clz : Scene.v().getClasses()) {
            for (SootMethod method : clz.getMethods()) {
                if (!method.isConcrete()) 
                    continue;
                StmtBody stmtBody = (StmtBody)method.retrieveActiveBody();
                
             // get body's unit as a chain
                Chain units = stmtBody.getUnits();

                Iterator stmtIt = units.iterator(); 
                
                while (stmtIt.hasNext()) {
                    Stmt stmt = (Stmt)stmtIt.next();
                    
                    stmtToMethod.put(stmt, method);
                    for (Object box : stmt.getUseAndDefBoxes()) {
                        if (((ValueBox) box).getValue() instanceof Expr)
                            exprToStmt.put((Expr)((ValueBox) box).getValue(), stmt);
                    }
                }
            }
        }
    } 
    
    /**
     * Given an expr in the Scene, return the enclosing statement.
     */
    public Stmt getEnclosingStmt(Expr expr) {
        return exprToStmt.get(expr);
    }
    
    /** 
     * Given a statement in the Scene, return the enclosing statement.
     */
    public SootMethod getEnclosingMethod(Stmt stmt) {
        return stmtToMethod.get(stmt);
    }
}
