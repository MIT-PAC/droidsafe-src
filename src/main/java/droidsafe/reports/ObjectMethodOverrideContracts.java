package droidsafe.reports;

import static droidsafe.reports.JSONUtils.json_call_graph_header;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import soot.Body;
import soot.MethodOrMethodContext;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.FieldRef;
import soot.jimple.Stmt;
import droidsafe.analyses.CallChainInfo;
import droidsafe.analyses.cg.StmtEdge;
import droidsafe.analyses.cg.collapsedcg.CollaspedCallGraph;
import droidsafe.analyses.cg.collapsedcg.CollaspedCallGraph.CallToTarget;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.system.API;
import droidsafe.android.system.InfoKind;

/**
 * Look for suspicious patterns in toString, hashCode, and equals
 * 
 * No field assignments
 * No calls to methods other than hashcode, equals, getClass, ... ?
 * 
 * @author mgordon
 *
 */
public class ObjectMethodOverrideContracts {

 private final static Logger logger = LoggerFactory.getLogger(ObjectMethodOverrideContracts.class);
    
    private static final String FILE_NAME = "object_overrides_report.json";
    
    private Indicator<ClassTopLevel> indicator;
    private static ObjectMethodOverrideContracts v;
    
    /** Method names that we are checking */
    private static final String[]  METHOD_NAMES = new String[] { "toString", "equals", "hashCode", "finalize", "compareTo" };
    private final Set<String> METHOD_NAMES_SET = new HashSet<String>(Arrays.asList(METHOD_NAMES));
    
    /** List of methods that it is ok to call, meaning they will not show in the report */
    private static final String[]  IGNORE_CALLS = new String[] { "getClass", "<clinit>", "<init>" };
    private Set<String> IGNORE_CALLS_SET = new HashSet<String>(Arrays.asList(IGNORE_CALLS));
    
    private Map<SootClass, ClassTopLevel> classToContent;
    private Map<SootMethod, MethodLevel> methodToContent;
    
    public ObjectMethodOverrideContracts() {
        indicator = new Indicator<ClassTopLevel>("Object Method Overrides");
        classToContent = new HashMap<SootClass, ClassTopLevel>();
        methodToContent = new HashMap<SootMethod, MethodLevel>();
        
        indicator.addDisplay("type");
        indicator.addDisplay("score");
        
        try {
            buildReport();
        } catch (Exception e) {
            logger.warn("Problem with ObjectOverride Indicator", e);
        }
    }

    public static ObjectMethodOverrideContracts v() {
        if (v == null)
            v =  new ObjectMethodOverrideContracts();
        
        return v;
    }
    
    
    private void buildReport() {
        //loop through all src classes
        for (MethodOrMethodContext momc : PTABridge.v().getReachableMethodContexts()) {
            if (API.v().isSystemMethod(momc.method()))
                continue;
            
            SootMethod method = momc.method();

            if (!METHOD_NAMES_SET.contains(method.getName()))
                continue;
            
            //find all field access locals, and see if they are assigned
            findFieldAssignments(method);
                       
            //for each method, see if it calls only the method it should
            findMethodCalls(method);
        }
    }
    
    private void findMethodCalls(SootMethod method)  {
        //api method calls
        for (CallToTarget apiCall : CollaspedCallGraph.v().getAPICallTargets(method)) {             
            if (!IGNORE_CALLS_SET.contains(apiCall.getTarget().getName()) &&
                    !method.getName().equals(apiCall.getTarget().getName())) {
                getCtl(method).addMethodCall(method, apiCall.getStmt(), apiCall.getTarget());
            }
        }
        
        //user method calls
        for (StmtEdge<SootMethod> edge : CollaspedCallGraph.v().getTargetsForMethod(method)) {
            if (!IGNORE_CALLS_SET.contains(edge.getV2().getName()) &&
                    !method.getName().equals(edge.getV2().getName())) {
                getCtl(method).addMethodCall(method, edge.getStmt(), edge.getV2());
            }
        }
    }
    
    
    private void findFieldAssignments(SootMethod method) {
        //loop through stmts and find assignments with rhs is field access expression
        //remember lhs
        Set<Value> fieldLocals = new HashSet<Value>();
        //defining assignments, ignore these in second pass
        Set<Stmt> firstAssigns = new HashSet<Stmt>();
        
        Body body = method.retrieveActiveBody();            
        
        //System.out.println(method);

        Iterator<Unit> units = body.getUnits().iterator();
        while (units.hasNext()) {
            Unit current = units.next();

            //check if current is a call to api call we are interested in
            if (!(current instanceof Stmt)) 
                continue;

            Stmt stmt = (Stmt)current;
         
            if (stmt instanceof AssignStmt) {
                AssignStmt assign = (AssignStmt)stmt;
                if (assign.getRightOp() instanceof FieldRef) {
                    fieldLocals.add(assign.getLeftOp());
                    firstAssigns.add(assign);
                    //System.out.println("found field: " + assign.getLeftOp() + " " + assign);
                }
            }
        }
        
        //loop through statements for assignment to locals found above
        units = body.getUnits().iterator();
        while (units.hasNext()) {
            Unit current = units.next();

            //check if current is a call to api call we are interested in
            if (!(current instanceof Stmt))
                continue;

            Stmt stmt = (Stmt)current;
            
            if (firstAssigns.contains(stmt)) {
                //System.out.println("ignoring: " + stmt);
                continue;
            }
         
            if (stmt instanceof AssignStmt) {
                AssignStmt assign = (AssignStmt)stmt;
                if (assign.getLeftOp() instanceof FieldRef || fieldLocals.contains(assign.getLeftOp())) {
                    getCtl(method).addFieldAssign(method, stmt);
                }
            }
        }        
    }
    
    private ClassTopLevel getCtl(SootMethod method) {
        if (!classToContent.containsKey(method.getDeclaringClass())) {
            ClassTopLevel newctl = new ClassTopLevel(method.getDeclaringClass());
            classToContent.put(method.getDeclaringClass(), newctl);
            indicator.addContents(newctl);
        }
        
        return classToContent.get(method.getDeclaringClass());                
    }
    
    private class ClassTopLevel {
        String label;
        ArrayList<MethodLevel> contents = new ArrayList<MethodLevel>();
        
        public ClassTopLevel(SootClass clz) {
            this.label = clz.getName();
        }
        
        private MethodLevel getML(SootMethod source) {
            if (!methodToContent.containsKey(source)) {
                MethodLevel ml = new MethodLevel(source);
                methodToContent.put(source, ml);
                contents.add(ml);
            }
            
            return methodToContent.get(source);
        }
        
        public void addFieldAssign(SootMethod source, Stmt stmt) {            
           getML(source).addFieldAssign(stmt);
        }
        
        public void addMethodCall(SootMethod source, Stmt getStmt, SootMethod target) {
            getML(source).addMethodCall(getStmt, target);
        }
    }     
    
    private class MethodLevel {
        String signature;
        ArrayList<SourceContent> contents = new ArrayList<SourceContent>();
        String link = "as_entry_point";
        int score = 0;
        
        public MethodLevel(SootMethod method) {
            this.signature = method.getSignature();
        }
        
        public void addFieldAssign(Stmt stmt) {
            contents.add(new FieldAssign(stmt));
            score += 10;
        }
        
        public void addMethodCall(Stmt stmt, SootMethod target) {
            MethodCall probe = new MethodCall(stmt, target); 
            if (!contents.contains(probe)) {
                contents.add(probe);
                score += 10;
            }
            
        }
    }
    
    private class MethodCall extends SourceContent {
        String signature;
        String link = "as_call";
        String type;
        
        public MethodCall(Stmt genStmt, SootMethod target) {
            setSource(genStmt);
            
            signature = target.getSignature();
    
             
            type = API.v().isSystemMethod(target) ? "System Call" : "User Call";                        
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = super.hashCode();
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((link == null) ? 0 : link.hashCode());
            result = prime * result + ((signature == null) ? 0 : signature.hashCode());
            result = prime * result + ((type == null) ? 0 : type.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!super.equals(obj)) return false;
            if (getClass() != obj.getClass()) return false;
            MethodCall other = (MethodCall) obj;
            if (!getOuterType().equals(other.getOuterType())) return false;
            if (link == null) {
                if (other.link != null) return false;
            } else if (!link.equals(other.link)) return false;
            if (signature == null) {
                if (other.signature != null) return false;
            } else if (!signature.equals(other.signature)) return false;
            if (type == null) {
                if (other.type != null) return false;
            } else if (!type.equals(other.type)) return false;
            return true;
        }

        private ObjectMethodOverrideContracts getOuterType() {
            return ObjectMethodOverrideContracts.this;
        }
        
        
    }
    
    private class FieldAssign extends SourceContent {
        String type;
        String label = "Field Assignment";
                
        public FieldAssign(Stmt genStmt) {
            setSource(genStmt);
            type = "Field Assignment";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((type == null) ? 0 : type.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            FieldAssign other = (FieldAssign) obj;
            if (!getOuterType().equals(other.getOuterType())) return false;
            if (type == null) {
                if (other.type != null) return false;
            } else if (!type.equals(other.type)) return false;
            return true;
        }

        private ObjectMethodOverrideContracts getOuterType() {
            return ObjectMethodOverrideContracts.this;
        }
        
        
    }
    
    public void toJSON(String parentDir) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        String output = gson.toJson(indicator);
        FileWriter fw;
        try {
            fw = new FileWriter(parentDir + File.separator + FILE_NAME);
            fw.write(output);
            fw.close();
        } catch (IOException e) {
            logger.warn("Error writing json file.", e);
        }
    }
    
    /*
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((i == null) ? 0 : i.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ObjectMethodOverrideContracts other = (ObjectMethodOverrideContracts) obj;
        if (i == null) {
            if (other.i != null) return false;
        } else if (!i.equals(other.i)) return false;
        return true;
    }
    */
    
    
}
