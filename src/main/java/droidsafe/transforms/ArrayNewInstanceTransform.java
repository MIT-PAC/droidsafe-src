package droidsafe.transforms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.utils.SootUtils;
import soot.ArrayType;
import soot.Body;
import soot.BodyTransformer;
import soot.IntType;
import soot.Local;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.IntConstant;
import soot.jimple.Jimple;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.util.Chain;

/** 
 * Transform Arrays.newInstance() into new multidim array jimple expression.
 * 
 * Dex translation uses Array.newInstance to allocate multi dim arrays, and we 
 * can replace them for more precision.
 * 
 * @author mgordon
 *
 */
public class ArrayNewInstanceTransform extends BodyTransformer {
    private static final Logger logger = LoggerFactory.getLogger(ArrayNewInstanceTransform.class);
    private static int UNIQUE_ID = 0;
    
    private ArrayNewInstanceTransform()  {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Replace all Array.newInstance calls for all classes
     */
    public static void run() {
        ArrayNewInstanceTransform transformer = new ArrayNewInstanceTransform();
        for (SootClass clz : Scene.v().getClasses()) {
            for (SootMethod meth : clz.getMethods()) {
                if (meth.isConcrete()) {
                    try {
                        transformer.transform(meth.retrieveActiveBody());
                    }
                    catch (Exception ex) {
                        logger.info("Exception retrieving method body {}", ex);
                        continue;
                    }
                    
                }
            }
        }
    }

    @Override
    /**
     * Find stmts of the form 'x = Array.newInstance(type, dims) with a cast after, and replace it with
     * 'x = newMultArray(type) dims[0], dims[1], ...'
     */
    protected void internalTransform(Body b, String arg1, Map<String, String> arg2) {
        StmtBody stmtBody = (StmtBody)b;
        // get body's unit as a chain
        Chain units = stmtBody.getUnits();
        // get a snapshot iterator of the unit since we are going to mutate the chain when iterating over it.
        Iterator stmtIt = units.snapshotIterator();

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();
         
            if (stmt instanceof AssignStmt &&
                stmt.containsInvokeExpr() && stmt.getInvokeExpr() instanceof StaticInvokeExpr) {
                AssignStmt assign = (AssignStmt)stmt;
                SootMethodRef targetRef = stmt.getInvokeExpr().getMethodRef();                               
                Value sizesArg = stmt.getInvokeExpr().getArg(1);
                if ("<java.lang.reflect.Array: java.lang.Object newInstance(java.lang.Class,int[])>".
                        equals(targetRef.getSignature())) {
                    //find cast
                    Type arrayType = SootUtils.findCast(b.getMethod(), stmt, assign.getLeftOp());
                    if (!(arrayType instanceof ArrayType)) 
                        continue;
                    
                    //create list of array size values
                    List<Value> sizes = new LinkedList<Value>();
                    
                    //really the array sizes does not matter, but we will get them accurate                    
                    for (int i = 0; i < ((ArrayType)arrayType).numDimensions; i++) {
                        Local access = Jimple.v().newLocal("_$temparray_" + UNIQUE_ID++, IntType.v());
                        b.getLocals().add(access);
                        Stmt localAssign = 
                                Jimple.v().newAssignStmt(access, Jimple.v().newArrayRef(sizesArg, IntConstant.v(i)));
                        b.getUnits().insertBefore(localAssign, stmt);
                        sizes.add(access);
                        
                    }
                    
                    logger.debug("Replacing: {}", assign.getRightOp());
                    assign.setRightOp(Jimple.v().newNewMultiArrayExpr((ArrayType)arrayType, sizes));
                    logger.debug("With: {}", assign.getRightOp());
                }
            }
         
        }        
    }

}
