import droidsafe.analyses.value.RefVAModel;

import soot.jimple.spark.pag.AllocNode;

public class Intent extends RefVAModel {

    public Intent(AllocNode allocNode) {
        super(allocNode);
    }
}
