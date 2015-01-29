package droidsafe.analyses.value.primitives;

import soot.SootClass;
import droidsafe.analyses.value.PrimVAModel;

public class ClassVAModel extends PrimVAModel<SootClass> {
    
    /** string to represent sets of unknown values */
    public static final SootClass UNKNOWN_VALUES = new SootClass("VAUNKNOWNCLASS");

    public ClassVAModel() {
        super("class");
    }

}
