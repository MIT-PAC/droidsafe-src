package droidsafe.stats;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.Chain;
import droidsafe.analyses.pta.ContextType;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PTAContext;
import droidsafe.analyses.pta.cg.CGVisitorEntryAnd1CFA;
import droidsafe.analyses.pta.cg.CallGraphTraversal;
import droidsafe.android.system.API;
import droidsafe.utils.SootUtils;

public class PTASetsAvgSize implements CGVisitorEntryAnd1CFA {

    private long numberOfSets = 0;
    private long insensTotalSetSize = 0;
    private long eventContextTotalSetSize = 0;
    private long oneCFATotalSetSize = 0;
    
    public static void run() {
        new PTASetsAvgSize();
    }
    
    private PTASetsAvgSize() {
 
        CallGraphTraversal.acceptEntryContextAnd1CFA(this);
        System.out.println("pta-sets:"+numberOfSets);
        System.out.println("insens:" + insensTotalSetSize);
        System.out.println("1-cfa:" + oneCFATotalSetSize);
        System.out.println("event-context:" + eventContextTotalSetSize);
        System.out.println();
        
    }
    
    private void recordAndLookUpValue(Value v, PTAContext eventContext, PTAContext oneCFAContext) {
        //it is a pointer, record it and its sets
        numberOfSets++;
        int insensSetSize = PTABridge.v().getPTSet(v).size();
        int eventContextSetSize = PTABridge.v().getPTSet(v, eventContext).size();
        int oneCfaSetSize = PTABridge.v().getPTSet(v, oneCFAContext).size();
        
       //System.out.printf("%s: insens = %s, event = %s\n", v, insensSetSize, eventContextSetSize);
        
        insensTotalSetSize += insensSetSize;
        eventContextTotalSetSize += eventContextSetSize;
        oneCFATotalSetSize += oneCfaSetSize;
    }

    public void visitEntryContextAnd1CFA(SootMethod method, PTAContext eventContext, PTAContext oneCFAContext) {
        if (API.v().isSystemMethod(method) || method.isPhantom() || 
                !method.isConcrete() || SootUtils.isRuntimeStubMethod(method))
            return;
        
        
        HashSet<Value> seen = new HashSet<Value>();
        
       //for each instruction value that is a pointer, get its set both ways
        StmtBody stmtBody = (StmtBody)method.retrieveActiveBody();

        // get body's unit as a chain
        Chain<Unit> units = stmtBody.getUnits();

        // get a snapshot iterator of the unit since we are going to
        // mutate the chain when iterating over it.
        Iterator<Unit> stmtIt = units.snapshotIterator();

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();
            for (ValueBox vBox : stmt.getUseBoxes()) {
                if (!seen.contains(vBox.getValue()) && PTABridge.v().isPointer(vBox.getValue())) {
                    recordAndLookUpValue(vBox.getValue(), eventContext, oneCFAContext);
                    seen.add(vBox.getValue());
                }
            }
            
            for (ValueBox vBox : stmt.getDefBoxes()) {
                if (!seen.contains(vBox.getValue()) && PTABridge.v().isPointer(vBox.getValue())) {
                    recordAndLookUpValue(vBox.getValue(), eventContext, oneCFAContext);
                    seen.add(vBox.getValue());
                }
            }
        }
    }
}
