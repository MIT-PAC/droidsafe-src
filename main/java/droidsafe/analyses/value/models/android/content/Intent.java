package droidsafe.analyses.value.models.android.content;

import droidsafe.analyses.value.RefVAModel;
import droidsafe.analyses.value.primitives.IntVAModel;
import soot.jimple.spark.pag.AllocNode;

public class Intent extends RefVAModel {

    public IntVAModel mFlags = new IntVAModel();

    public Intent(AllocNode allocNode) {
        super(allocNode);
    }

    public static final class FilterComparison extends RefVAModel {

        public FilterComparison(AllocNode allocNode) {
            super(allocNode);
        }
    }

    public static class ShortcutIconResource extends RefVAModel {

        public ShortcutIconResource(AllocNode allocNode) {
            super(allocNode);
        }
    }
}
