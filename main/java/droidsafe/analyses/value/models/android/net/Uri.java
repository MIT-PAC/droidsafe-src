package droidsafe.analyses.value.models.android.net;

import droidsafe.analyses.value.RefVAModel;

import soot.jimple.spark.pag.AllocNode;

public class Uri extends RefVAModel {

    public Uri(AllocNode allocNode) {
        super(allocNode);
    }
}
