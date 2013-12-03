package droidsafe.transforms.objsensclone;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.value.VAResultContainerClassGenerator;
import droidsafe.android.system.API;
import droidsafe.utils.SootUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.jimple.AssignStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.NewExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.util.Chain;
import soot.ValueBox;

/**
 * Introduce selective object sensitivity by cloning certain api classes.  
 * When a new expression of one of the tracked classes is encountered in application code, 
 * a clone is created of the original class (clone contains methods from ancestors), and the
 * new expression (plus constructor call) are changed to reference the new cloned class.  
 * 
 * Does not rely on PTA.
 * 
 * @author mgordon
 *
 */
public class ObjectSensitivityCloner {
    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(ObjectSensitivityCloner.class);

    /** list of classes resolved by VA, some of which should be cloned */
    public static final Set<SootClass> VA_RESOLVED_CLASSES = 
            VAResultContainerClassGenerator.getClassesAndFieldsToModel(false).keySet();

    /** list of class names that should not be cloned */
    public static final Set<String> CLASSES_TO_NOT_CLONE = 
            new HashSet<String>(java.util.Arrays.asList("java.lang.String", 
                "java.lang.Class", 
                "java.lang.CharSequence", 
                    "android.app.Activity"));

    private static AllocGraphNode[] buildAllocationGraph() {
        //we want to keep a consistent numbering across runs of droidsafe for clones
        //so we sort the classes list we go through
        Map<SootClass, AllocGraphNode> allocations = new HashMap<SootClass,AllocGraphNode>();
        SootMethod[] methods = PTABridge.v().getAllReachableMethods().toArray(new SootMethod[0]);

        for (SootMethod method : methods) {

            //if (API.v().isSystemMethod(method))
            //    continue;

            if (method.isAbstract() || !method.isConcrete())
                continue;

            SootClass enclosingClass = method.getDeclaringClass();

            Body body = method.getActiveBody();
            StmtBody stmtBody = (StmtBody)body;
            Chain units = stmtBody.getUnits();
            Iterator stmtIt = units.snapshotIterator();

            while (stmtIt.hasNext()) {
                Stmt stmt = (Stmt)stmtIt.next();

                if (stmt instanceof AssignStmt) {
                    AssignStmt assign = (AssignStmt) stmt;
                    if (assign.getRightOp() instanceof NewExpr) {
                        NewExpr newExpr = (NewExpr)assign.getRightOp();
                        SootClass newClass = newExpr.getBaseType().getSootClass();
                        //is exception?
                        if (!SootUtils.isSubTypeOfIncluding(RefType.v(newClass), RefType.v("java.lang.Throwable"))) {
                            if (!allocations.containsKey(newClass))
                                allocations.put(newClass, new AllocGraphNode(newClass));

                            if (!allocations.containsKey(enclosingClass))
                                allocations.put(enclosingClass, new AllocGraphNode(enclosingClass));

                            AllocGraphNode enclosingNode = allocations.get(enclosingClass);
                            AllocGraphNode allocNode = allocations.get(newClass);
                            allocNode.in.add(enclosingClass);
                            enclosingNode.out.add(newClass);
                        }
                    }
                }
            }
        }

        AllocGraphNode[] sorted = allocations.values().toArray(new AllocGraphNode[0]);
        Arrays.sort(sorted);
/*
        for (AllocGraphNode node : sorted) {
            System.out.printf("->%d  %d-> %s\n", node.in.size(), 
                node.out.size(), node.myClz);
        }
*/
        return sorted;
    }

    static class AllocGraphNode implements Comparable<AllocGraphNode> {
        SootClass myClz;
        List<SootClass> in;
        List<SootClass> out;

        AllocGraphNode(SootClass clz) {
            myClz = clz;
            in = new LinkedList<SootClass>();
            out = new LinkedList<SootClass>();
        }

        @Override
        public int compareTo(AllocGraphNode o) {
            // TODO Auto-generated method stub
            return Integer.compare(o.in.size(), this.in.size());
        }
    }

    /**
     * Run the cloner on all new expression of classes in the list of classes to clone.  Produce clones for each
     * new expression.
     */
    public static void run() {
        int clonedClasses = 0;

        AllocGraphNode[] sortedNodes = buildAllocationGraph();

        //we want to keep a consistent numbering across runs of droidsafe for clones
        //so we sort the classes list we go through
        List<SootMethod> masterMethodList = new LinkedList<SootMethod>();
        masterMethodList.addAll(PTABridge.v().getAllReachableMethods());
        Collections.sort(masterMethodList, new ToStringComparator());
        
        int i = -1;
        
        for (AllocGraphNode currentAllocNode : sortedNodes) {
            i++;
            SootClass currentClass = currentAllocNode.myClz;
            
            if (("java.lang.String".equals(currentClass.getName()) ||
                    "java.lang.StringBuffer".equals(currentClass.getName()) ||
                    "java.lang.StringBuilder".equals(currentClass.getName()) ) )
                    continue;
                
            
            if ( currentAllocNode.in.size() < 2) 
                continue;
            
            //create a list to iterate over that is the current snap shot of the master list
            //because we update the master list for each clone...
            List<SootMethod> iterationList = new LinkedList<SootMethod>();
            iterationList.addAll(masterMethodList);
            
            for (SootMethod method : iterationList) {

                //if (API.v().isSystemMethod(method))
                //    continue;

                if (method.isAbstract() || !method.isConcrete())
                    continue;

                Body body = method.getActiveBody();
                StmtBody stmtBody = (StmtBody)body;
                Chain units = stmtBody.getUnits();
                Iterator stmtIt = units.snapshotIterator();

                while (stmtIt.hasNext()) {
                    Stmt stmt = (Stmt)stmtIt.next();

                    if (stmt instanceof AssignStmt) {
                        AssignStmt assign = (AssignStmt) stmt;
                        if (assign.getRightOp() instanceof NewExpr && assign.getLeftOp() instanceof Local) {
                            NewExpr oldNewExpr = (NewExpr) assign.getRightOp();
                            SootClass base = oldNewExpr.getBaseType().getSootClass();
                            String baseClassName = base.getName();
                            
                            if (!currentClass.equals(base)) 
                                continue;
                            
                            //currently we are cloning any va tracked class, and 
                            //container classes we have mod'ed in user code
                            /*
                            if ((VA_RESOLVED_CLASSES.contains(base) ||
                                    (API.v().isContainerClass(baseClassName) && !API.v().isSystemMethod(method)))
                                    && 
                                    !CLASSES_TO_NOT_CLONE.contains(baseClassName)) {
                                    */
                                logger.info("Found new expr to replace and clone class: {} {}\n",
                                    method, assign);

                                //now change the constructor call after find the appropriate call to change
                                try {
                                    SpecialInvokeExpr special = findConstructorCall(method,
                                        assign);

                                    if (special != null) {
                                        //found an appropriate constructor call

                                        //clone class and install it as an new API class
                                        SootClass cloned = 
                                                ClassCloner.cloneClass(oldNewExpr.getBaseType().getSootClass(), true);
                                        
                                        //add all cloned methods clone to the master list
                                        masterMethodList.addAll(cloned.getMethods());

                                        SootMethodRef origMethodRef = special.getMethodRef();

                                        //replace old constructor call with call to cloned class
                                        special.setMethodRef(Scene.v().makeMethodRef(cloned, 
                                            origMethodRef.name(), 
                                            origMethodRef.parameterTypes(), 
                                            origMethodRef.returnType(), 
                                            origMethodRef.isStatic()));

                                        //replace new expression with new expression of cloned class
                                        NewExpr newNewExpr = Jimple.v().newNewExpr(RefType.v(cloned));
                                        assign.setRightOp(newNewExpr);

                                        clonedClasses++;
                                    } else {
                                        throw new Exception("Special Invoke Not Found!");
                                    }
                                } catch (Exception e) {
                                    logger.error("Error processing constructor call after modifying new expr: {} in {}", 
                                        stmt, method, e);
                                }

                            }
                        }
                    }
                }
            /*}*/
        }
        System.out.printf("Finished cloning: added %d classes.\n", clonedClasses);
    }

    /**
     * Given the assignment statement that includes the new expression, find the associated constructor call
     * that is called on the local value.  This method will search starting from the assignment, and conservatively
     * find the constructor call.  Will return null if a constructor is not found.
     */
    private static SpecialInvokeExpr findConstructorCall(SootMethod method, AssignStmt assignStmt) {
        Local local = (Local)assignStmt.getLeftOp();

        //loop through all instructions in method and find the special invoke on this allocnode
        Body body = method.getActiveBody();
        StmtBody stmtBody = (StmtBody)body;
        Chain units = stmtBody.getUnits();
        Iterator stmtIt = units.iterator();

        boolean beginSearch = false;
        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();

            if (stmt == assignStmt) {
                beginSearch = true;
                continue;
            }

            if (beginSearch) {
                if (stmt.containsInvokeExpr() && stmt.getInvokeExpr() instanceof SpecialInvokeExpr) {
                    SpecialInvokeExpr si = (SpecialInvokeExpr) stmt.getInvokeExpr();
                    if (si.getBase() == local)
                        return si;

                    //value has been redefined before we found a constructor, so we can't find anything!
                    for (ValueBox def : stmt.getDefBoxes()) {
                        if (def.getValue().equals(local)) {
                            //System.out.println("Failed on can contain value: " + stmt);
                            return null;
                        }
                    }

                } else if (!stmt.containsInvokeExpr() && stmt.branches()) {
                    //check for control flow?
                    //System.out.println("Failed on control flow: " + stmt);
                    return null;
                }
            }
        }
        System.out.println("Failed...");
        return null;
    }
}

class ToStringComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        return o1.toString().compareTo(o2.toString());
    }

}