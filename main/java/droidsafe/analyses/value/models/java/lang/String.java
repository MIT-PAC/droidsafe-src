package droidsafe.analyses.value.models.java.lang;

import droidsafe.analyses.value.RefVAModel;

import soot.jimple.spark.pag.AllocNode;

public class String extends RefVAModel {

    public String(AllocNode allocNode) {
        super(allocNode);
    }
}
