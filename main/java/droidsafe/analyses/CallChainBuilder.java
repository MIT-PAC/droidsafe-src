package droidsafe.analyses;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.BodyTransformer;
import soot.Local;
import soot.MethodOrMethodContext;
import soot.NormalUnitPrinter;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Trap;
import soot.Unit;
import soot.UnitBox;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.GotoStmt;
import soot.jimple.IfStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.ReturnStmt;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;
import soot.util.Chain;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.android.system.InfoKind;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

import static droidsafe.analyses.CatchBlocks.*;
public class CallChainBuilder {
    
    /** Logging field */
    private static final Logger logger = LoggerFactory.getLogger(CallChainBuilder.class);

    /** timer so we can timeout after a reasonable amount of time **/
    private StopWatch timer = new StopWatch();
    
    /** Timeout (milliseconds).  The output will be incomplete **/
    private int timeout;
    
    /** True if we should look for callbacks through system calls **/
    private boolean process_callbacks;
    
    /** Rather than creating normal output, dump the entire call graph **/
    private  boolean dump_all_calls = false;  
    
    /** just ignore duplicate methods rather than merging call chains **/
    private boolean ignore_dup_methods = false;
        
    /** Call stack to detect recursion **/
    Stack<SootMethod> stack = new Stack<SootMethod>();
 
    /** set of method names known not to have callbacks **/
    private static HashSet<String> no_callback_methods = new HashSet<String>();
    
    static {
        no_callback_methods.add ("valueOf");
        no_callback_methods.add ("toString");
    }
    
    public CallChainBuilder (int timeout, boolean process_callbacks) {
        this.timeout = timeout;
        this.process_callbacks = process_callbacks;
    }
 
    /**
     * Process the call chain and returns a CallChainInfo that 
     * describes this call and any call that it makes.
     * Ignores any calls that are within the API. Ignores recursive
     * calls and static initializers.  Terminates on system calls
     * that do not contain callbacks.
     * 
     * @param mc      - Method to start at
     * @param s       - Stmt that called mc
     */
    public  CallChainInfo process_call_chain (Stmt s, MethodOrMethodContext mc) { 
        
        if (is_terminal (mc))
            return new CallChainInfo (mc.method(), s, "syscall");
        
        CallChainInfo cci = new CallChainInfo (mc.method(), s, "call-chain");
        CallGraph cg = PTABridge.v().getCallGraph();
        
        Set<SootMethod> processed_methods = new HashSet<SootMethod>();
        List<CallChainInfo> calls = new ArrayList<CallChainInfo>();
        for (Iterator<Edge> tit = cg.edgesOutOf(mc); tit.hasNext(); ) {
            if (timeout())
                break;
            Edge e = tit.next();
            SootMethod m = e.getTgt().method();
            if (ignore_dup_methods) {
                if (processed_methods.contains(m)) {
                    logger.info ("pcc: method {}, duplicate callee {}", mc.method(), m);
                    continue;
                }
                processed_methods.add (m);
            }
            boolean print_m = !(is_system(mc.method()) && is_system (m));
            if (m.toString().contains ("<clinit>")) {
                continue;
            } else if (stack.contains(m)) {
                // ignore recursive  call
            } else { // normal call 
                stack.push (m);
                CallChainInfo callee = process_call_chain (e.srcStmt(), e.getTgt());
                stack.pop();
                if (print_m) {
                    calls.add (callee);
                } else { // skip callee and just add what it calls
                    if (ignore_dup_methods) {
                        for (CallChainInfo callee_call : callee.contents) {
                            if (!processed_methods.contains (callee_call.method)) {
                                calls.add (callee_call);
                                processed_methods.add(callee_call.method);
                            }
                        }
                    } else {
                        calls.addAll (Arrays.asList(callee.contents));
                    }
                }
            }
        }
        cci.contents = calls.toArray(cci.contents);
        if (ignore_dup_methods)
            Arrays.sort(cci.contents);
        else
            cci.merge_contents();
        return cci;
    }
    /**
     * Returns true if the specified method should terminate the call graph
     * The call graph is terminated on system calls that do not have callbacks
     * into application code.
     * @param m
     * @return
     */
    public static boolean is_terminal (MethodOrMethodContext mc) {
        Stack<SootMethod> stack = new Stack<SootMethod>();
        boolean result = is_system (mc.method()) && !calls_app_method (mc, stack);
        logger.info ("  {} terminal = {}", mc.method(), result);
        return result;
    }
    
    /** Returns true if an app method is called directly or indirectly from mc **/
    private static boolean calls_app_method (MethodOrMethodContext mc, Stack<SootMethod> stack) {
        CallGraph cg = PTABridge.v().getCallGraph();
        logger.info("  cam: entering iterator, stack = {}", stack);
        if (no_callback_methods.contains (mc.method().getName()))
            return false;
        if (system_depth (stack) > 5) {
            no_callback_methods.add (mc.method().getName());
            return false;
        }
        int ii = 0;
        for (Iterator<Edge> tit = cg.edgesOutOf(mc); tit.hasNext(); ) {
            Edge e = tit.next();
            SootMethod m = e.getTgt().method();
            logger.info("  cam: considering method {} ({})", m, ii++);
 
            if (no_callback_methods.contains (m.getName()))
                continue;
            if (m.toString().contains("<clinit>"))
                continue;
            if (!is_system (m)) {
                logger.info ("  cam: {} is not a system call");
                return true;
            }
            if (!stack.contains(m)) {
                stack.push(m);
                boolean result = calls_app_method (e.getTgt(), stack);
                stack.pop();
                if (result) {
                    logger.info ("  cam: {} true", m);
                    return true;
                }
            }
        }
        logger.info("  cam: {} is terminal", mc.method());
        no_callback_methods.add (mc.method().getName());
        return false;
    }
    
 
    /** Returns the number of calls back to the last non-system call **/
    private static int system_depth (Stack<SootMethod> stack) {
        for (int ii = stack.size()-1; ii > 0; ii--) {
            SootMethod m = stack.get(ii);
            if (!is_system(m))
                return stack.size() - ii;
        }
        return stack.size();
    }
    
    /** Returns true if the specified method is a system (android or java) class **/
    public static boolean is_system (SootMethod m) {
        Project p = Project.v();
        SootClass c = m.getDeclaringClass();
        return !p.isSrcClass(c) && !p.isLibClass(c);
    }  
    
    /** Returns true if we have timed out **/
    public boolean timeout() {
        return (timer.getTime() > timeout);
    }
}
