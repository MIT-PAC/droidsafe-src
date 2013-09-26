package droidsafe.analyses.value.models.java.net;

import droidsafe.analyses.value.RefVAModel;

import soot.jimple.spark.pag.AllocNode;

public class URI extends RefVAModel {

    public URI(AllocNode allocNode) {
        super(allocNode);
    }
}
