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


/**
 * Catch block indicator. Looks for catch blocks in the application code and
 * emits a description of what occurs in each block. Follow-on analysis can then
 * easily look for actions in exception blocks that are unusual.
 * 
 * @author jhp
 */
public class CatchBlocks {

    /** Logging field */
    private static final Logger logger = LoggerFactory.getLogger(CatchBlocks.class);

    /** timer so we can timeout after a reasonable amount of time **/
    private StopWatch timer = new StopWatch();
    
    /** Timeout (milliseconds).  The output will be incomplete **/
    private int timeout = 5 * 60 * 1000;
    
    /** Enable/Disable the transformation **/
    static boolean enabled = true;
    
    /** Rather than creating normal output, dump the entire call graph **/
    private boolean dump_all_calls = false;
    
    /** debugging flag that only processes specified classes/methods **/
    private boolean filter_source = false;
    
    /** just ignore duplicate methods rather than merging call chains **/
    private boolean ignore_dup_methods = false;
    
    /** Map from unit to line number **/
    private HashMap<Unit,Integer> lnums = null;
    
    PrintStream fp = null;
    private static int call_cnt = 0;
    
    /** Map from processed methods to info about them **/
    private HashMap<SootMethod,MethodInfo> methods 
        = new LinkedHashMap<SootMethod,MethodInfo>();
    
    /** set of method names known not to have callbacks **/
    private static HashSet<String> no_callback_methods = new HashSet<String>();
    
    static {
        no_callback_methods.add ("valueOf");
        no_callback_methods.add ("toString");
    }
    
    /** Class that stores information about each method previously processed **/
    static class MethodInfo {
        static int next_id = 1;
        int subcall_cnt;
        boolean terminal;
        int id;
        MethodInfo(int cnt, boolean terminal) {
            subcall_cnt = cnt;
            this.terminal = terminal;
            id = next_id++;
        }
    }
    
    /** information about each call in the call chain **/
    static class CallChainInfo implements Comparable<CallChainInfo>{
    	String type;
    	SootMethod method;
    	Stmt stmt;
    	int syscalls;
    	int calls;
    	int score;
    	CallChainInfo[] contents = new CallChainInfo[0];
    	public CallChainInfo (SootMethod m, Stmt s, String type) {
    		this.type = type;
    		this.method = m;
    		this.stmt = s;
    		calls = 1;
    		if (type.equals ("syscall"))
    			syscalls = 1;
    	}
    	/** merge multiple call chains from different contexts **/
    	public void merge (CallChainInfo other) {
    	   if (method != other.method) 
    	       throw new RuntimeException ("methods don't match: " 
    	               + method + ", " + other.method + " " + method.equals(other.method)
    	               + " " + method.hashCode() + " " + other.method.hashCode());
    	   if (contents.length == 0) {
    	       contents = other.contents;
    	       return;
    	   } else if (other.contents.length == 0) {
    	       return;
    	   }
    	   List<CallChainInfo> ccis = new ArrayList<CallChainInfo>(Arrays.asList(contents));
    	   Map<SootMethod,CallChainInfo> minfo = new HashMap<SootMethod,CallChainInfo>();
    	   for (CallChainInfo cci : contents) 
    	       minfo.put(cci.method, cci);
    	   for (CallChainInfo other_cci : other.contents) {
    	       CallChainInfo cci = minfo.get(other_cci.method);
    	       if (cci == null)
    	           ccis.add(other_cci);
    	       else
    	           cci.merge (other_cci);
    	   }
    	   if (contents.length == ccis.size())
    	       logger.info ("merge: {} old/new size = {}", method, ccis.size());
    	   else
    	       logger.info ("merge: {} orig {} elems, new {} elems", method, 
    	               contents.length, ccis.size());
    	   contents = ccis.toArray (new CallChainInfo[0]);
    	}
    	/** merge any duplicate method calls **/
    	public void merge_contents() {
    	    if (contents.length == 0)
    	        return;
    	    Arrays.sort (contents);
    	    List<CallChainInfo> unique_calls = new ArrayList<CallChainInfo>();
    	    unique_calls.add (contents[0]);
    	    for (int ii = 1; ii < contents.length; ii++) {
    	        CallChainInfo top = unique_calls.get(unique_calls.size()-1);
    	        if (contents[ii].method == top.method)
    	            top.merge (contents[ii]);
    	        else
    	            unique_calls.add(contents[ii]);
    	    }
    	    logger.info ("merge_contents {}: old {} elems, new {} elems", 
    	            method, contents.length, unique_calls.size());
            contents = unique_calls.toArray(new CallChainInfo[0]);
    	}
    	
    	/** order by signature **/
    	public int compareTo (CallChainInfo other) {
    	    return method.getSignature().compareTo(other.method.getSignature());
    	}
    	public void calculate_scores() {
    	    score = 0;
    	    if (contents.length == 0) {
    	        API api = API.v();
    	        Set<InfoKind> source = api.getSourceInfoKinds(method);
    	        Set<InfoKind> sink = api.getSinkInfoKinds(method);
    	        if (is_system (method)) {
    	            if (api.isSafeMethod(method))
    	                score = 0;
    	            else if (api.isSpecMethod(method))
    	                score = 5;
    	            else if (api.isBannedMethod(method))
    	                score = 6;  
    	            if (!source.isEmpty())
    	                score += 1;
    	            else if (!sink.isEmpty())
    	                score += 2;
    	        }    	            
    	        return;
    	    }
    	    for (CallChainInfo cci : contents) {
    	        cci.calculate_scores();
    	        calls += cci.calls;
    	        syscalls += cci.syscalls;
    	        if (cci.score > score)
    	            score = cci.score;
    	    }
    	    
    	}
    	public void dump_json (PrintStream fp, String indent) {
       		fp.printf ("%s{ %s,\n", indent, json_field ("type", type));
    		fp.printf ("%s  %s,\n", indent, json_field ("signature", method.getSignature()));
    		SourceLocationTag slt = getSourceLocation(stmt);
    		if (slt != null) {
    			fp.printf ("%s  %s", indent, json_field ("src-loc"));
    			fp.printf ("{ %s, %s},\n", json_field ("class", slt.getClz()), 
    					json_field ("line", slt.getLine()));
    		}   
    		fp.printf ("%s  %s,\n", indent, json_field ("syscalls", syscalls));
    		fp.printf ("%s  %s,\n", indent, json_field ("calls", calls));
    		
    		if ((contents != null) && (contents.length > 0)) {
    			fp.printf ("%s  %s,\n", indent, json_field ("score", score));
    			fp.printf ("%s  %s [\n", indent, json_field ("contents"));
    			String delim = "";
    			for (CallChainInfo cci : contents) {
    				fp.print (delim);
    				delim = ",\n";
    				cci.dump_json (fp, indent + "  ");
    			}
    			fp.printf ("\n%s]}", indent);
    		} else {
    			fp.printf ("%s  %s\n", indent, json_field ("score", score));
    			fp.printf ("%s}", indent);
    		}
    	}
    }
    
    /** Find all catch blocks and characterize their contents 
     * @throws FileNotFoundException **/
    public void run() throws FileNotFoundException {

        if (!enabled) return;
        timer.start();
        
        fp = new PrintStream (Project.v().getOutputDir() + "/catch_blocks.json");
        fp.printf("{\n");
        fp.printf("  %s,\n", json_field ("indicator-type", "Catch Blocks"));
        fp.printf("  %s {\n", json_field ("visibility"));
        fp.printf("    %s,\n", json_field ("direct-call", true));
        fp.printf("    %s,\n", json_field ("call-chain", false));
        fp.printf("    %s\n", json_field ("syscall", true));
        fp.printf("  },\n");
        fp.printf("  %s {\n", json_field ("display"));
        fp.printf("    %s,\n", json_field ("calls", false));
        fp.printf("    %s,\n", json_field ("syscalls", false));
        fp.printf("    %s\n", json_field ("score", false));
        fp.printf("  },\n");
        fp.printf (" %s [\n", json_field ("contents"));
        
        // Process each source class (those in app/src)
        for (SootClass clz : Scene.v().getClasses()) {
            if (!Project.v().isSrcClass(clz.toString()))
            	continue;
            logger.info("processing class {}", clz);
        	if (filter_source && !clz.getShortName().equals ("FetchForecast")) {
        		logger.info ("skipping class {}", clz);
        		continue;
        	}

            for (SootMethod method : clz.getMethods()) {
            	if (filter_source && !method.getName().equals ("run")) {
            		logger.info("  skipping method {}", method);
            		continue;
            	}
            	if (method.isConcrete()) {
            		proc_method (method);
            	}
            }
        }
        fp.println ("  {}");
        if (timeout())
            fp.printf ("], %s}\n", json_field ("timeout", true));
        else
            fp.println ("]}");
        fp.close();
        timer.stop();
        
        }

    /**
     * Processes the method looking for catch block information
     * @param meth
     */
    private void proc_method (SootMethod meth) {
    	
    	JimpleBody body = (JimpleBody) meth.retrieveActiveBody();
    	Chain <Unit> insts = body.getUnits();
        // NormalUnitPrinter nup = new NormalUnitPrinter(b);

    	// Build destinations for jumps and keep track of all jump targets
    	lnums = new LinkedHashMap<Unit,Integer>();
    	HashMap<Unit,List<Unit>> jump_dests_to_src 
    	    = new LinkedHashMap<Unit,List<Unit>>();
    	int inst_offset = 0;
        for (Unit src : insts) {
        	lnums.put (src, inst_offset);
        	inst_offset++;
        	Unit target = null;
        	if (src instanceof GotoStmt)
        		target = ((GotoStmt)src).getTarget();
        	else if (src instanceof IfStmt)
        		target = ((IfStmt)src).getTarget();
        	if (target != null) {
        		List<Unit> sources = jump_dests_to_src.get(target);
        		if (sources == null) {
        			sources = new ArrayList<Unit>();
        			jump_dests_to_src.put(target, sources);
        		}
        		sources.add (src);
        	}
        }

        // Dump the code with destinations for jumps/branches
        if (logger.isInfoEnabled()) {
	    	logger.info("  processing method {}", meth);
	        for (Unit unit : insts) {
	        	if (unit instanceof GotoStmt) {
	        		GotoStmt goto_stmt = (GotoStmt) unit;
	        		logger.info ("    {} class {} stmt goto {}", lnums.get(unit),
	        				unit.getClass(), lnums.get(goto_stmt.getTarget()));
	        	} else if (unit instanceof IfStmt) {
	        		IfStmt if_stmt = (IfStmt) unit;
	        		logger.info ("    {} class {} stmt if {} goto {}", lnums.get(unit),
	        				unit.getClass(), if_stmt.getCondition(), 
	        				lnums.get(if_stmt.getTarget()));
	        	} else {
	        		logger.info ("    {}: class {}, stmt {}", lnums.get (unit),
	        				unit.getClass(), unit);
	        	}
	        }
        }

        
        logger.info("  processing traps for {}", meth);
        for (Trap trap : body.getTraps()) {
        	logger.info ("    class {}, trap {}", trap.getClass(), trap);
        	HashSet<Unit> unit_in_trap = new HashSet<Unit>();
        	Unit start = trap.getHandlerUnit();
        	Unit u;
        	for (u = start ; u != null; u = insts.getSuccOf(u)) {
        		unit_in_trap.add(u);
        		if (jump_dests_to_src.containsKey(u)) {
        			for (Unit src : jump_dests_to_src.get(u))
        				logger.info ("      {} is targeted by {}", 
        						toString (u), toString(src));
        			break;
        		}
        		if (u instanceof ReturnStmt)
        			break;
        		if (u instanceof GotoStmt)
        			break;
        		if (u instanceof IfStmt)
        			break;
        	}
        	logger.info ("  begin handler = {}", toString(start));
        	logger.info ("  end handler = {}", toString(u));
        	// print_call (meth, (Stmt)start, "  ", "cblock", true);
        	CallChainInfo cci = extract_calls (fp, meth, insts, start, u);
        	cci.calculate_scores();
        	// fp.println ("  ]},");
        	cci.dump_json (fp, "  ");
        	fp.println (",");
        }
    }
    	
    /**
     * Extracts all of the calls from the instructions between start (inclusive)
     * and end (exclusive).
     * 
     * @param insts		- Chain that contains start and end
     * @param start     - start instruction (inclusive)
     * @param end       - end instruction (exclusive)
     */
    private CallChainInfo extract_calls (PrintStream fp, SootMethod method, Chain<Unit> insts, 
    		Unit start, Unit end) {

    	CallChainInfo cci = new CallChainInfo (method, (Stmt)start, "cblock");
    	List<CallChainInfo> ccis = new ArrayList<CallChainInfo>();
    	Set<SootMethod> processed_methods = new HashSet<SootMethod>();
    	
    	for (Unit u = start; u != end; u = insts.getSuccOf(u)) {
    		Stmt s = (Stmt)u;
    		if (s.containsInvokeExpr()) {
 
       	       	// Get the edges from the method containing the catch block to
       	       	// the statement that includes a method call.  If there are
       	       	// multiple implementations of a virtual/interface method that
       	       	// can be called here, each will be listed.
    			List<Edge> allEdgesForContexts = new LinkedList<Edge>();
    			for (MethodOrMethodContext momc : PTABridge.v().getMethodContexts(method)) {
    			    List<Edge> outgoingEdges = PTABridge.v().outgoingEdges(momc, s);
    			    allEdgesForContexts.addAll(outgoingEdges);
    			}
    			
    			// Loop through each edge to the method
    			for (Edge edge : allEdgesForContexts) {
    				MethodOrMethodContext mc = edge.getTgt();
                    Stack<SootMethod> stack = new Stack<SootMethod>();

    				if (dump_all_calls) {
    				    List<String> calls = get_call_chain (mc, stack, "      ");
    				    fp.printf ("    method %s (%d)\n", mc.method(), calls.size());
    				    for (String call : calls)
    				        fp.println (call);
    				} else {
    					CallChainInfo dcall = process_call_chain (mc, s, stack);
    					dcall.type = "direct-call";
    					if (ignore_dup_methods) {
    					    if (!processed_methods.contains (mc.method())) {
    					        ccis.add(dcall);
    					        processed_methods.add(mc.method());
    					    }
    					} else {
    					    ccis.add(dcall);
    					}
    				}
    			}
    		}
 
    	}
    	cci.contents = ccis.toArray(cci.contents);
    	if (ignore_dup_methods)
    	    Arrays.sort(cci.contents);
    	else
    	    cci.merge_contents();
		return cci;
    }
    
    /**
     * Process the call chain and returns a CallChainInfo that 
     * describes this call and any call that it makes.
     * Ignores any calls that are within the API. Ignores recursive
     * calls and static initializers.  Terminates on system calls
     * that do not contain callbacks.
     * 
     * @param mc      - Method to start at
     * @param s		  - Stmt that called mc
     * @param stack   - Current call chain, used to check for recursion
     */
    private CallChainInfo process_call_chain (MethodOrMethodContext mc, 
            Stmt s, Stack<SootMethod> stack) {
        
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
            	CallChainInfo callee = process_call_chain (e.getTgt(), e.srcStmt(), stack);
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
    
    private void print_call (SootMethod m, Stmt s, String indent, String type, boolean contents) {
        fp.printf ("%s{ %s,\n", indent, json_field ("type", type));
        fp.printf ("%s  %s,\n", indent, json_field ("signature", m.getSignature()));
        SourceLocationTag slt = getSourceLocation(s);
        if (slt != null) {
          fp.printf ("%s  %s", indent, json_field ("src-loc"));
          fp.printf ("{ %s, %s},\n", json_field ("class", slt.getClz()), 
                  json_field ("line", slt.getLine()));
        }
        if (contents) {
            fp.printf ("%s  %s,\n", indent, json_field ("score", 5));
            fp.printf ("%s  %s [\n", indent, json_field ("contents"));
        } else {
            fp.printf ("%s  %s\n", indent, json_field ("score", 5));
            fp.printf ("%s},\n", indent);
        }
    }
    
    private static String json_field (String name) {
        return json_field (name, null);
    }
    private static String json_field (String name, String value) {
        name = "\"" + name + "\"";
        if (value == null)
            return String.format ("%-12s : ", name);
        return String.format ("%-12s : \"%s\"", name, value);
    }
    
    private static String json_field (String name, int value) {
        return String.format ("%-12s : %d", "\"" + name + "\"", value);
    }
          
    private static String json_field (String name, boolean value) {
        return String.format ("%-12s : %b", "\"" + name + "\"", value);
    }
          
    /**
     * Process the call chain and returns a list of strings where the
     * indentation indicates the call chain.  Each call also contains the
     * number of edges beneath it.  Terminates on any recursive calls or
     * static initializers.  
     * .
     * @param mc		- Method to start at
     * @param stack     - Current call chain, used to check for recursion
     * @param indent	- indent for printing (blank string)
     */
    private ArrayList<String> get_call_chain (MethodOrMethodContext mc, 
    		Stack<SootMethod> stack,String indent) {
       	CallGraph cg = PTABridge.v().getCallGraph();
       	ArrayList<String> calls = new ArrayList<String>();
    	for (Iterator<Edge> tit = cg.edgesOutOf(mc); tit.hasNext(); ) {
    		Edge e = tit.next();
    		SootMethod m = e.getTgt().method();
    		if (m.toString().contains ("<clinit>"))
    			continue;
    		call_cnt++;
    		if ((call_cnt % 10000) == 0)
    			fp.printf("stack: %s\n", stack);
    		MethodInfo mi = methods.get(m);
    		if (mi != null) {
    		    calls.add (String.format ("%s%s (%d)", indent, m, mi.subcall_cnt));
    		    logger.info ("  found method {}, call cnt {}", m, mi.subcall_cnt);
    		    continue;
    		}
    		// fp.printf ("%s%s\n", indent, m); fp.flush();
    		if (!stack.contains(m)) {
    			stack.push (m);
    			List<String> subcalls = get_call_chain (e.getTgt(), stack, 
    					indent + "  ");
    			stack.pop();
    			calls.add (String.format ("%s%s (%d)", indent, m, subcalls.size()));
    			calls.addAll (subcalls);
    			methods.put (m, new MethodInfo (subcalls.size(), false));
    		} else { // recursive call
    			calls.add (indent + m + "(recursive)");
    		}
    	}
    	return calls;
    }
    
    /**
     * Returns true if the specified method should terminate the call graph
     * The call graph is terminated on system calls that do not have callbacks
     * into application code.
     * @param m
     * @return
     */
    private boolean is_terminal (MethodOrMethodContext mc) {
    	Stack<SootMethod> stack = new Stack<SootMethod>();
    	boolean result = is_system (mc.method()) && !calls_app_method (mc, stack);
    	logger.info ("  {} terminal = {}", mc.method(), result);
    	return result;
    }
    
    /** Returns true if an app method is called directly or indirectly from mc **/
    private boolean calls_app_method (MethodOrMethodContext mc, Stack<SootMethod> stack) {
    	CallGraph cg = PTABridge.v().getCallGraph();
    	logger.info("  cam: entering iterator, stack = {}", stack);
    	if (no_callback_methods.contains (mc.method().getName()))
    	    return false;
    	if (system_depth (stack) > 5)
    	    return false;
    	int ii = 0;
    	for (Iterator<Edge> tit = cg.edgesOutOf(mc); tit.hasNext(); ) {
    		Edge e = tit.next();
    		SootMethod m = e.getTgt().method();
    		logger.info("  cam: considering method {} ({})", m, ii++);
            MethodInfo mi = methods.get(m);
            if (mi != null) {
                if (mi.terminal) 
                    continue;
                else
                    return true;
            }
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
    			methods.put (m, new MethodInfo(-1, !result));
    			stack.pop();
    			if (result) {
    			    logger.info ("  cam: {} true", m);
    			    return true;
    			}
    		}
    	}
    	logger.info("  cam: {} is terminal", mc.method());
    	return false;
    }
    
    /** Returns the number of calls back to the last non-system call **/
    private int system_depth (Stack<SootMethod> stack) {
        for (int ii = stack.size()-1; ii > 0; ii--) {
            SootMethod m = stack.get(ii);
            if (!is_system(m))
                return stack.size() - ii;
        }
        return stack.size();
    }
    /** Returns true if the specified method is a system (android or java) class **/
    private static boolean is_system (SootMethod m) {
    	Project p = Project.v();
    	SootClass c = m.getDeclaringClass();
    	return !p.isSrcClass(c) && !p.isLibClass(c);
    }
    /** gets the source location for unit (which must be a stmt) **/
    private static SourceLocationTag getSourceLocation (Unit s) {
    	return SootUtils.getSourceLocation((Stmt) s);
    }
    /** 
     * formats an instruction using lnums to fill in branch destinations
     * and offsets in the current method
     * 
     * @param u
     * @param lnums
     * @return
     */
    private  String toString (Unit u) {
    	if (u == null)
    		return "<last instruction>";
       	if (u instanceof GotoStmt) {
    		GotoStmt goto_stmt = (GotoStmt) u;
    		return String.format ("goto %d (line %d)", 
    				lnums.get(goto_stmt.getTarget()), lnums.get(u));
    	} else if (u instanceof IfStmt) {
    		IfStmt if_stmt = (IfStmt) u;
    		return String.format ("if %s goto %d (line %d)",
    				if_stmt.getCondition(), lnums.get(if_stmt.getTarget()), 
    				lnums.get(u));
    	} else 
    		return String.format ("%s (line %d)", u, lnums.get(u));
    }
    
    /**
     * Logs any differences between the original instructions and the new instructions.
     * Does nothing if the instructions are the same.
     * 
     * @param log Logger to use
     * @param orig_chain A copy of the chain of jimple instructions of the method
     * @param meth The method after any transformation
     */
    public static void log_diffs (Logger log, List<Unit> orig_chain, SootMethod meth) {
        
      if (!log.isInfoEnabled()) return;
      
      Chain<Unit> new_chain = meth.getActiveBody().getUnits();
      boolean modified = new_chain.size() != orig_chain.size();
      if (!modified) {
          Iterator<Unit> newit = new_chain.iterator();
          for (Unit orig_u : orig_chain) {
              Unit new_u = newit.next();
              modified = orig_u != new_u;
              if (modified)
                  break;
          }
      }
      if (modified) {
          log.info("Modified method {}", meth.getName());
          log.info("Original Method:");
          for (Unit u : orig_chain)
              log.info ("  {}", u);
          log.info("New Method");
          for (Unit u : new_chain) {
              log.info("  {}", u);
          }
      }
    }
    

    /** 
     * Modifies the specified method body to replace all calls to Uri.parse(String)
     * with new Uri(String).  This ensures that the allocation of the Uri is
     * unique
     */
    protected void internalTransform(Body b, String phaseName, Map options) {
        StmtBody stmtBody = (StmtBody) b;
        Chain<Unit> units = stmtBody.getUnits();

        // need a snapshot iterator since we want to mutate while iterating
        Iterator<Unit> stmtIt = units.snapshotIterator();

        NormalUnitPrinter nup = new NormalUnitPrinter(b);

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt) stmtIt.next();

            // we only care about invoke expressions
            if (!stmt.containsInvokeExpr()) {
                continue;
            }

            InvokeExpr expr = (InvokeExpr) stmt.getInvokeExpr();

            // we're at jimple's level so everything should be an AssignStmt
            AssignStmt assignStmt = null;
            if (stmt instanceof AssignStmt) {
                assignStmt = (AssignStmt) stmt;
            } else {
                continue;
            }

            inspectAndReplaceCalls(units, assignStmt, expr);
        }
    }

    /**
     * Internal method that will inspect the invoke expression to see if it is
     * one of the calls we want to replace. If it is, then perform the
     * replacement.
     */
    protected boolean inspectAndReplaceCalls(Chain<Unit> units, AssignStmt stmt,
            InvokeExpr expr) {

        Jimple jv = Jimple.v();
        Scene sv = Scene.v();

        // Only process calls we want to replace (currently only Uri.parse)
        SootMethodRef smr = expr.getMethodRef();
        if (!smr.getSignature().equals(
                "<android.net.Uri: android.net.Uri parse(java.lang.String)>"))
            return (false);

        // Get the local variable where the result is stored
        Local var = (Local) stmt.getLeftOp();

        // allocate the Uri
        RefType type = RefType.v("android.net.Uri");
        Value alloc_expr = jv.newNewExpr(type);
        AssignStmt alloc_stmt = jv.newAssignStmt(var, alloc_expr);

        // Call the constructor with the string parameter to parse
        SootMethod uri_init_sm = sv
                .getMethod("<android.net.Uri: void <init>(java.lang.String)>");
        Value uri_str_arg = expr.getArgs().get(0);
        SpecialInvokeExpr uri_init_sie = jv.newSpecialInvokeExpr(var,
                uri_init_sm.makeRef(), uri_str_arg);
        InvokeStmt uri_init_stmt = jv.newInvokeStmt(uri_init_sie);
        // logger.info("invoke stmt = {}", uri_init_stmt);

        // Add in the new allocation and call to the constructor and remove the
        // old parse call
        units.insertBefore(alloc_stmt, stmt);
        units.insertBefore(uri_init_stmt, stmt);
        units.remove(stmt);

        return (true);
    }
    
    /** Returns true if we have timed out **/
    public boolean timeout() {
        return (timer.getTime() > timeout);
    }
           
    /** throw an exception if we have timed out **/
    private void check_timeout() {
        if (timeout())
            throw new RuntimeException ("Catch Block Timeout");
    }

}
