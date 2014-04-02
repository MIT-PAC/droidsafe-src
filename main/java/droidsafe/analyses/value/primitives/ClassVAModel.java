package droidsafe.analyses.value.primitives;

import soot.SootClass;
import droidsafe.analyses.value.PrimVAModel;

public class ClassVAModel extends PrimVAModel<SootClass> {

    public ClassVAModel() {
        super("class");
    }

}
