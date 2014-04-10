package droidsafe.analyses.infoflow;

import java.util.HashSet;
import java.util.Set;

import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import droidsafe.android.system.API;
import droidsafe.main.Config;

public class ObjectUtils {
    private static ObjectUtils v;

    public static void run() {
        v = new ObjectUtils();
    }

    public static ObjectUtils v() {
        return v;
    }

    SootField taint;
    Set<SootMethod> addTaints;
    Set<SootMethod> getTaints;

    private ObjectUtils() {
        addTaints = new HashSet<SootMethod>();
        getTaints = new HashSet<SootMethod>();
        
        //set taint field
        SootClass objClass = Scene.v().getSootClass("java.lang.Object");
        
        taint = objClass.getFieldByName("taint");
        if (Config.v().strict) {
            assert taint != null;
        }
        
        //addTaint and getTaint can appear in any class, so search all classes
        for (SootClass klass : Scene.v().getClasses()) {
            //search for addtaint and gettaint only in system classes
            if (!API.v().isSystemClass(klass))
                continue;
            
            if (Config.v().strict) {
                assert klass != null;
            }
            
            //could be multiple addTaint and getTaint* methods, so loop through all methods
            for (SootMethod method : klass.getMethods()) {
                if (method.getName().startsWith("addTaint")) {
                    addTaints.add(method);
                } else if (method.getName().startsWith("getTaint")) {
                    getTaints.add(method);
                }
            }
        }
    }

    public boolean isAddTaint(SootMethod method) {
        return addTaints.contains(method);
    }

    public boolean isGetTaint(SootMethod method) {
        return getTaints.contains(method);
    }
}
