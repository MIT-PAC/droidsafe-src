package objsenspark;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.RefType;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.tagkit.LineNumberTag;
import soot.util.Chain;

/**
 * Class to hold general utility methods that are helpful for Soot.
 * 
 * @author mgordon
 * @author dpetters
 *
 */
public class SootUtils {

    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(SootUtils.class);

    /**
     * Return the source location of a method based on its first statement.
     */
    public static int getMethodLocation(SootMethod method) {
        if (method != null && method.isConcrete()) {
            Chain<Unit> stmts = ((StmtBody)method.retrieveActiveBody()).getUnits();
            Iterator<Unit> stmtIt = stmts.snapshotIterator();

            if (stmtIt.hasNext()) {
                return getSourceLine((Stmt)stmtIt.next());
            }
        }

        return -1;
    }

    /**
     * Return true if this reference is to a String, CharSequence, StringBuffer, or StringBuilder.
     */
    public static boolean isStringOrSimilarType(Type type) {
        if (type instanceof RefType) {
            RefType refType = (RefType)type;

            return refType.equals(RefType.v("java.lang.String")) || 
                    refType.equals(RefType.v("java.lang.CharSequence")) ||
                    refType.equals(RefType.v("java.lang.StringBuffer")) ||
                    refType.equals(RefType.v("java.lang.StringBuilder"));

        }

        return false;
    }
    
    /**
     * Return the source line number of a Jimple statement.
     */
    public static int getSourceLine(Stmt stmt) {
        if (stmt != null) {
            LineNumberTag lineNumberTag = (LineNumberTag) stmt.getTag("LineNumberTag");
            if (lineNumberTag != null) {
                        return lineNumberTag.getLineNumber();
            } 
            logger.debug("Cannot find line number tag for {}", stmt);
        }
        return -1;
    }


    public static int getNumLines(SootMethod method) {
        if (method.isAbstract() || !method.isConcrete()) 
            return 0;

        try {
            int startingLine = getMethodLocation(method);
            
            Body body = method.retrieveActiveBody();

            Chain<Unit> units = body.getUnits();

            Unit curUnit = units.getLast();
            Unit first = units.getFirst();

            while (curUnit != first) {
                Stmt curStmt = (Stmt)curUnit;
                int sl = getSourceLine(curStmt); 
                if (sl >= 0)
                    return sl - startingLine;

                curUnit = units.getPredOf(curUnit);
            }

        } catch (Exception e) {
            return 0;
        }
        
        return 0;
    }


    /**
     * get a list of statements that a method calls the other
     * @param sootMethod
     * @param callee
     * @return
     */
    public static List<Stmt> getInvokeStatements(SootMethod sootMethod, SootMethod callee) {
        List<Stmt> invokeStmtList = new LinkedList<Stmt>();

        if (!sootMethod.isConcrete()) {
            return invokeStmtList;
        }

        Body body;
        try {
            body = sootMethod.retrieveActiveBody();
        }
        catch (Exception ex) {
            logger.warn("execption trying to get ActiveBody: {} ", ex);
            return invokeStmtList;
        }

        Chain<Unit> units = body.getUnits();


        /* Note that locals are named as follows:
         *  r => reference, i=> immediate
         *  $r, $i => true local
         *  r, i => parameter passing, and r0 is for this when it is non-static
         */

        for (Unit unit: units){
            Stmt statement = (Stmt)unit;

            if (statement.containsInvokeExpr())
            {
                InvokeExpr expr = statement.getInvokeExpr();
                SootMethod invokedMethod = expr.getMethod();
                if (invokedMethod == callee)
                    invokeStmtList.add(statement);
            }

        }
        return invokeStmtList;
    }

}


