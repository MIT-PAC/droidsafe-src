package droidsafe.speclang.model;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootMethod;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.Edge;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

/**
 * A CodeLocationModel that represents the source line of a call edge in the PAG.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 *
 */
public class CallLocationModel extends CodeLocationModel {

    /**
     * Serialization id for class.
     */
    private static final long serialVersionUID = -2677646576088927559L;

    /**
     * Standard logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(CallLocationModel.class);

    /**
     * Signature of the target method for the underlying call edge.
     */
    private String targetMethodSig;

    /**
     * Create a call edge source line model and compute its fields.
     * 
     * @param clz name of the class where the new expression for the AllocNode resides in
     * @param line the line number for the new expression corresponding to the underlying AllocNode
     * @param callEdge the underlying call edge
     */
    public CallLocationModel(String clz, int line, Edge callEdge) {
        super(clz, line);
        SootMethod targetMethod = callEdge.getTgt().method();
        String subSig = targetMethod.getSubSignature();
        int namePos = subSig.indexOf(targetMethod.getName());
        targetMethodSig = targetMethod.getDeclaringClass().getName() + "." + subSig.substring(namePos) + ": " + targetMethod.getReturnType();
    }

    /**
     * Create a call edge source line model and compute its fields.
     * 
     * @param srcLoc the source location tag for the call expression corresponding to the underlying call edge
     * @param callEdge the underlying call edge
     */
    public CallLocationModel(SourceLocationTag srcLoc, Edge callEdge) {
        this(srcLoc.getClz(), srcLoc.getLine(), callEdge);
    }

    /**
     * Return the signature of the target method for the underlying call edge.
     */
    public String getTargetMethodSig() {
        return targetMethodSig;
    }
    
    @Override
    public String toString() {
        String clz = getClz();
        int line = getLine();
        return targetMethodSig + " - " + clz + " line: " + line;
    }

    /**
     * A map from call edges to their associated source line models.
     */
    private static Map<Edge, CallLocationModel> map = new HashMap<Edge, CallLocationModel>();
    
    /**
     * Clear the static map from call edges to their associated source line models.
     */
    public static void reset() {
        map.clear() ;
    }

    /**
     * Return the source line model for the give call edge. Return empty set of any problems.
     */
    public static CallLocationModel get(Edge callEdge) {
        CallLocationModel line = map.get(callEdge);
        if (line == null) {
            Stmt stmt = callEdge.srcStmt() ;

            if (stmt == null) {
                logger.debug("Cannot find source statement for call edge: {}", callEdge);
                return null;
            }

            // LWG
            SourceLocationTag srcLoc =  SootUtils.getSourceLocation(stmt);
            if (srcLoc == null) {
                logger.debug("Cannot find source location for statement: {}", stmt);
                return null;
            }
            line = new CallLocationModel(srcLoc, callEdge);
            map.put(callEdge, line);
        }
        return line;
        
    }
}
