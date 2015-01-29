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
import static droidsafe.analyses.CallChainBuilder.*;
import static droidsafe.reports.JSONUtils.*;


/** 
 * A call graph structure.  Nested arrays are used to represent the graph.
 * Recursion is not supported (the graph is truncated at a recursive call)
 **/
public class CallChainInfo implements Comparable<CallChainInfo> {
   
    /** Logging field */
    private static final Logger logger = LoggerFactory.getLogger(CallChainInfo.class);
           
    public String type;
    public String link;
    SootMethod method;
    Stmt stmt;
    int syscalls;
    int calls;
    int score;
    CallChainInfo[] contents = new CallChainInfo[0];
        
    /** Creates a call from Stmt s to SootMethod m **/
    public CallChainInfo (SootMethod m, Stmt s, String type) {

        this.type = type;
        this.link = "as_call";
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
    
    /** Calculate the score for each entry in the call chain **/
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
    
    /** Dumps out the call chain in json format **/
    public void dump_json (PrintStream fp, String indent) {
        fp.printf ("%s{ %s,\n", indent, json_field ("type", type));
        fp.printf ("%s  %s,\n", indent, json_field ("link", link));
        fp.printf ("%s  %s,\n", indent, json_field ("signature", method.getSignature()));
        SourceLocationTag slt = (stmt == null) ? SootUtils.getMethodLocation(method) : getSourceLocation(stmt);
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
    
    /** gets the source location for unit (which must be a stmt) **/
    public static SourceLocationTag getSourceLocation (Unit s) {
        return SootUtils.getSourceLocation((Stmt) s);
    }
}

