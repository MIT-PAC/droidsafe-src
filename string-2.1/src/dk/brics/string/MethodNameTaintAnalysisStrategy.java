package dk.brics.string;

import dk.brics.string.java.TaintAnalysisStrategy;
import soot.jimple.InvokeExpr;

import java.util.List;

/**
 * A taint analysis strategy that decides whether a result is taint based on the method called.
 */
public class MethodNameTaintAnalysisStrategy implements TaintAnalysisStrategy {

	private List<String> taintMethods;

    public MethodNameTaintAnalysisStrategy(List<String> taintMethods) {
        this.taintMethods = taintMethods;
    }

    public boolean isTaint(InvokeExpr s) {
        String signature = s.getMethod().getSignature();
        for (String m : taintMethods) {
            if (signature.equals(m)) {
                return true;
            }
        }
        return false;
    }
}
