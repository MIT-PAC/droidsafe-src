package droidsafe.analyses.infoflow;

import java.util.HashSet;
import java.util.Set;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

import droidsafe.main.Config;

class DSUtilsUtils {
    Set<SootMethod> generateTaints;

    DSUtilsUtils() {
        SootClass klass = Scene.v().getSootClass("droidsafe.helpers.DSUtils");
        if (Config.v().strict) {
            assert klass != null;
        }
        generateTaints = new HashSet<SootMethod>();
        for (SootMethod method : klass.getMethods()) {
            if (method.getName().startsWith("dsGenerateTaint")) {
                generateTaints.add(method);
            }
        }
    }

    boolean isGenerateTaint(SootMethod method) {
        return generateTaints.contains(method);
    }
}
