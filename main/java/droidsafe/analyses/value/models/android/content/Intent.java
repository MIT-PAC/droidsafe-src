package droidsafe.analyses.value.models.android.content;
import droidsafe.analyses.value.models.droidsafe.primitives.IntVAModel;
import droidsafe.analyses.value.models.droidsafe.primitives.StringVAModel;
import droidsafe.analyses.value.RefVAModel;

import java.util.HashSet;
import java.util.Set;

import soot.jimple.spark.pag.AllocNode;

public class Intent extends RefVAModel {

    public StringVAModel mAction = new StringVAModel();
    public IntVAModel mFlags = new IntVAModel();

    public Intent(AllocNode allocNode) {
        super(allocNode);
    }
}
