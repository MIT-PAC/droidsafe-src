package droidsafe.analyses;

import static droidsafe.analyses.CallChainBuilder.is_system;
import static droidsafe.reports.JSONUtils.json_field;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootMethod;
import soot.Unit;
import soot.jimple.Stmt;
import droidsafe.android.system.API;
import droidsafe.android.system.InfoKind;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;


/** 
 * A source call graph structure.  Nested arrays are used to represent the graph.
 * Recursion is not supported (the graph is truncated at a recursive call)
 **/
public class SourceCallChainInfo implements Comparable<SourceCallChainInfo> {
   
    /** Logging field */
    private static final Logger logger = LoggerFactory.getLogger(SourceCallChainInfo.class);
           
    public String type;
    public String link;
    public SootMethod method;
    Stmt stmt;
    int syscalls;
    int calls;
    int score;
    public SourceCallChainInfo[] contents = new SourceCallChainInfo[0];
        
    /** Creates a call from Stmt s to SootMethod m **/
    public SourceCallChainInfo (SootMethod m, Stmt s, String type) {

        this.type = type;
        this.link = "as_call";
        this.method = m;
        this.stmt = s;
        calls = 1;
        if (type.equals ("syscall"))
            syscalls = 1;
    }
    
 
 
    /** merge multiple call chains from different contexts **/
    public void merge (SourceCallChainInfo other) {
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
        List<SourceCallChainInfo> ccis = new ArrayList<SourceCallChainInfo>(Arrays.asList(contents));
        Map<SootMethod,SourceCallChainInfo> minfo = new HashMap<SootMethod,SourceCallChainInfo>();
        for (SourceCallChainInfo cci : contents) 
            minfo.put(cci.method, cci);
        for (SourceCallChainInfo other_cci : other.contents) {
            SourceCallChainInfo cci = minfo.get(other_cci.method);
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
        contents = ccis.toArray (new SourceCallChainInfo[0]);
    }
    
    /** merge any duplicate method calls **/
    public void merge_contents() {
        if (contents.length == 0)
            return;
        Arrays.sort (contents);
        List<SourceCallChainInfo> unique_calls = new ArrayList<SourceCallChainInfo>();
        unique_calls.add (contents[0]);
        for (int ii = 1; ii < contents.length; ii++) {
            SourceCallChainInfo top = unique_calls.get(unique_calls.size()-1);
            if (contents[ii].method == top.method)
                top.merge (contents[ii]);
            else
                unique_calls.add(contents[ii]);
        }
        logger.info ("merge_contents {}: old {} elems, new {} elems", 
                method, contents.length, unique_calls.size());
        contents = unique_calls.toArray(new SourceCallChainInfo[0]);
    }

    /** order by signature **/
    public int compareTo (SourceCallChainInfo other) {
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
        for (SourceCallChainInfo cci : contents) {
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
        String sig = method.getSignature();
        fp.printf ("%s  %s,\n", indent, json_field ("signature", sig));
        if (stmt != null) {
        	SootMethod invoke = stmt.getInvokeExpr().getMethod();
        	String invokeSig = invoke.getSignature();
        	if (!invokeSig.equals(sig)) {
        		fp.printf ("%s  %s,\n", indent, json_field ("source-signature", invokeSig));
        	}
        }
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
            for (SourceCallChainInfo cci : contents) {
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

