package droidsafe.analyses.value.models.java.net;

import droidsafe.analyses.value.RefVAModel;
import soot.jimple.spark.pag.AllocNode;

public final class URI extends RefVAModel {

    public URI(AllocNode allocNode) {
        super(allocNode);
    }

    private static class PartEncoder extends RefVAModel {

        public PartEncoder(AllocNode allocNode) {
            super(allocNode);
        }
    }
}
