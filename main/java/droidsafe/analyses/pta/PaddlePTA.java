package droidsafe.analyses.pta;

import java.io.File;
import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.output.NullOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.G;
import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.paddle.PaddleTransformer;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.PAG;
import soot.options.PaddleOptions;
import soot.util.queue.QueueReader;
import droidsafe.android.app.Project;
import droidsafe.main.Config;
import droidsafe.utils.CannotFindMethodException;

public class PaddlePTA extends PTABridge {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(PaddlePTA.class);

    public PaddlePTA() {
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void releaseInternal() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void runInternal() {
        
        Scene.v().loadDynamicClasses();

        setPaddlePointsToAnalysis();
        
    }
    
    private void setPaddlePointsToAnalysis() {
        logger.info("[spark] Starting analysis ...");

        HashMap<String, String> opt = new HashMap<String, String>();
        
        opt.put("verbose","true");
        opt.put("bdd","true");
        opt.put("backend","buddy");
        opt.put("context","objsens");
        opt.put("k","2");
        opt.put("propagator","auto");
        opt.put("conf","ofcg");
        opt.put("order","32");
        opt.put("q","auto");
        opt.put("set-impl","double");
        opt.put("double-set-old","hybrid");
        opt.put("double-set-new","hybrid");
        opt.put("pre-jimplify","false");
        
        //handle strings with more precision
        opt.put("merge-stringbuffer", "false");
        opt.put("string-constants", "true");
        
        //object sensitive heap?
        opt.put("context-heap", "true");


        PaddleTransformer pt = new PaddleTransformer();
        PaddleOptions paddle_opt = new PaddleOptions(opt);
        pt.setup(paddle_opt);
        pt.solve(paddle_opt);
        soot.jimple.paddle.Results.v().makeStandardSootResults();
        
    }

    @Override
    public boolean isLegalCast(Type objType, Type refType) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public AllocNode getAllocNode(Object newExpr) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<AllocNode> getAllAllocNodes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getNewExpr(AllocNode an) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<SootMethod> getAllReachableMethods() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isReachableMethod(SootMethod method) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isPointer(Value val) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Set<Type> getTypes(Value val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Type> getTypes(Value val, PTAContext context) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<AllocNode> getPTSet(Value val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<AllocNode> getPTSet(AllocNode node, SootField field) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<AllocNode> getPTSet(Value val, PTAContext context) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<AllocNode> getPTSetOfArrayElement(AllocNode nodes) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<SootMethod> resolveInvoke(InvokeExpr invoke) throws CannotFindMethodException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<SootMethod> resolveInvoke(InvokeExpr invoke, PTAContext context)
            throws CannotFindMethodException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<AllocNode, SootMethod> resolveInstanceInvokeMap(InstanceInvokeExpr invoke)
            throws CannotFindMethodException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<AllocNode, SootMethod> resolveInstanceInvokeMap(InstanceInvokeExpr invoke,
            PTAContext context) throws CannotFindMethodException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void dumpPTA() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dumpPTA(String fileName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dumpPTAForContext(PrintStream file, PTAContext sootContext) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dumpCallGraph(String fileStr) {
        // TODO Auto-generated method stub

    }

}
