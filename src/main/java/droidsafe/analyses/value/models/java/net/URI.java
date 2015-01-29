package droidsafe.analyses.value.models.java.net;

import droidsafe.analyses.value.RefVAModel;
import soot.jimple.toolkits.pta.IAllocNode;

public final class URI extends RefVAModel {

    public URI(IAllocNode allocNode) {
        super(allocNode);
    }

    private static class PartEncoder extends RefVAModel {

        public PartEncoder(IAllocNode allocNode) {
            super(allocNode);
        }
    }
}
