package droidsafe.analyses.errorhandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import soot.Hierarchy;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Trap;
import soot.Unit;
import soot.UnitBox;
import soot.jimple.Stmt;
import soot.toolkits.graph.ExceptionalUnitGraph;
import droidsafe.analyses.CatchBlocks;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.main.Main;
import droidsafe.utils.IDroidsafeProgressMonitor;
import droidsafe.utils.SootMethodList;
import droidsafe.utils.SootUtils;

/**
 * 
 * 
 * @author mgordon
 *
 */
public class ErrorHandlingAnalysis {

    private static ErrorHandlingAnalysis v = null;
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandlingAnalysis.class);
    private Map<SootMethod, Set<SootClass>> connectionMethodToException = new HashMap<SootMethod, Set<SootClass>>();
    private SootMethodList connectionMethods = new SootMethodList();
    
    private ErrorHandlingAnalysis() {
        // TODO Auto-generated constructor stub
    }
    
    public static ErrorHandlingAnalysis v() {
        if (v == null)
            v = new ErrorHandlingAnalysis();
        
        return v;
    }
    
    private void loadConnectionCalls() {
        try {
            FileReader fr = new FileReader(Config.v().getApacHome() + File.separator + "config-files" + File.separator +
                "connection-calls.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String line;           
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("#"))
                    continue;
                
                String[] splitLine = line.split("\\|");
                if (splitLine.length != 3)
                    continue;
                
                //class, methodname, exception
                SootClass clz = null;
                SootClass ex = null;
                String methodName = splitLine[1];
                try {
                    clz = Scene.v().getSootClass(splitLine[0]);
                    ex = Scene.v().getSootClass(splitLine[2]);
                } catch (Exception e) {
                    logger.warn("Cannot find soot class for line in connection-calls.txt: {}", line);
                    continue;
                }
                
                //find all name matches in class / interface
                List<SootMethod> nameMatches = new LinkedList<SootMethod>();
                for (SootMethod m : clz.getMethods()) {
                    if (methodName.equals(m.getName())) { 
                        nameMatches.add(m);
                        if (!connectionMethodToException.containsKey(m))
                            connectionMethodToException.put(m, new HashSet<SootClass>());
                        
                        connectionMethodToException.get(m).add(ex);
                        connectionMethods.addMethod(m);
                        logger.info("Adding connection method: {}", m);
                    }
                }
                
                if (nameMatches.isEmpty()) {
                    logger.warn("Could not find method in class/interface: {}", line);
                    continue;
                }
            }
            
        } catch (Exception e)  {
            logger.error("Error loading connection calls", e);            
        }
    }
    
    public void run(IDroidsafeProgressMonitor monitor) {
        System.out.println("Error Handling Analysis...");
        
        //load connection calls
        loadConnectionCalls();
        
        //run pta to build call graph        
        Main.afterTransformPrecise(monitor, false, 1);
        
        
        for (SootClass clz : Scene.v().getClasses()) {

            for (SootMethod method : clz.getMethods()) {
                if (API.v().isSystemMethod(method))
                    continue;

                if (method.isPhantom() || method.isAbstract() || !method.isConcrete())
                    continue;

                if (!PTABridge.v().isReachableMethod(method))
                    continue;


                Body body = method.getActiveBody();                
                Map<Unit, List<Trap>> unitToTraps = getUnitToTrapMap(body);
                
                for (Unit current : unitToTraps.keySet()) {
                    
                    //check if current is a call to api call we are interested in
                    if (!(current instanceof Stmt)) 
                        continue;
                    
                    Stmt stmt = (Stmt)current;
                    
                    if (stmt.containsInvokeExpr()) {
                        Set<SootMethod> targets = PTABridge.v().getTargetsInsNoContext(stmt);

                        logger.info("Found invoke in try block: {}", stmt);
                        for (SootMethod target : targets) {
                            logger.info("\tTarget: {}", target);
                            if (connectionMethods.containsPoly(target)) {
                                logger.info("\tConnection Method");
                                //for each trap, check if the exception is one we are interested in
                                for (Trap trap : unitToTraps.get(current)) {
                                    boolean exceptionMatch = false;
                                    for (SootClass ex : connectionMethodToException.get(connectionMethods.getMethod(target))) {
                                        if (Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(ex, trap.getException())) {
                                            exceptionMatch = true;
                                            break;
                                        }
                                    }

                                    if (!exceptionMatch)
                                        continue;

                                    System.out.printf("** Found connection call catch block: %s %s\n", method, current);

                                    //calculate all handler units
                                    List<Unit> handlerUnits = getAllUnitsForCatch(body, trap.getHandlerUnit());

                                    //see if anything reachable is a gui method or field access?
                                }                            
                            }
                        }
                    }                                        
                }
            }
        }
        
        //for debugging
        writeAllAppClasses();
    }
    
    private Map<Unit, List<Trap>> getUnitToTrapMap(Body body) {
        HashMap<Unit, List<Trap>> map = new HashMap<Unit, List<Trap>>();
        
        for (Trap trap : body.getTraps()) {
            Iterator<Unit> units = body.getUnits().iterator(trap.getBeginUnit());
            while (units.hasNext()) {
                Unit current = units.next();
                if (current == trap.getEndUnit())
                    break;
                
                if (!map.containsKey(current)) 
                    map.put(current, new LinkedList<Trap>());
                
                map.get(current).add(trap);
            }
        }        
        
        return map;
    }
    
    private void writeAllAppClasses() {
        for (SootClass clz : Scene.v().getClasses()) {
            if (clz.isApplicationClass() && Project.v().isSrcClass(clz.toString())) {
                SootUtils.writeByteCodeAndJimple(
                    Project.v().getOutputDir(), clz);
            }
        }
    }

    private List<Unit> getAllUnitsForCatch(Body body, Unit startCatch) {
        ExceptionalUnitGraph cfg = new ExceptionalUnitGraph(body);
        List<Unit> catchBlock = new LinkedList<Unit>();
        catchBlock.add(startCatch);
        
        //calculate reachable units to color instructions
        Set<Unit> reachableUnits = new HashSet<Unit>();
        getReachableUnits(cfg, startCatch, reachableUnits);
        
        for (Unit current : reachableUnits) {
            boolean allColored = true;
            for (Unit pred : cfg.getPredsOf(current)) {
                if (!reachableUnits.contains(pred)) {
                    allColored = false;
                    break;
                }
            }
            if (allColored) {
                catchBlock.add(current);
            }            
        }
        
        return catchBlock;
    }
    
    private void getReachableUnits(ExceptionalUnitGraph cfg, Unit current, Set<Unit> reachable) {
        if (reachable.contains(current)) 
            return;
        
        reachable.add(current);
        
        for (Unit next : cfg.getSuccsOf(current)) {
            getReachableUnits(cfg, next, reachable);
        }
    }
}
