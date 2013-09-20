package droidsafe.analyses.value.models.android.content;

import droidsafe.analyses.value.models.java.lang.String;
import droidsafe.analyses.value.RefVAModel;

import java.util.Set;

import soot.jimple.spark.pag.AllocNode;

public class Intent extends RefVAModel {

    public Intent(AllocNode allocNode) {
        super(allocNode);
    }
}
