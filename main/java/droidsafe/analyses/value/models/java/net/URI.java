package droidsafe.analyses.value.models.java.net;

import droidsafe.analyses.value.models.droidsafe.primitives.StringVAModel;
import droidsafe.analyses.value.RefVAModel;

import soot.jimple.spark.pag.AllocNode;

public class URI extends RefVAModel {

    public StringVAModel string = new StringVAModel();

    public URI(AllocNode allocNode) {
        super(allocNode);
    }
}
