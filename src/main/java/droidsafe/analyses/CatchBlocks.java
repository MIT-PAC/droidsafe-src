/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

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

import static droidsafe.analyses.CallChainInfo.*;
import static droidsafe.analyses.CallChainBuilder.*;
import static droidsafe.reports.JSONUtils.*;


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
    	
    	JimpleBody body = null;
    	try {
    		body = (JimpleBody) meth.retrieveActiveBody();
    	}
    	catch (Exception ex) {
    		logger.info("Exception retrieving method body {}", ex);
    		return;
    	}
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
    				    CallChainBuilder ccb = new CallChainBuilder (timeout - (int)timer.getTime(), true);
    					CallChainInfo dcall = ccb.process_call_chain (s, mc);
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
