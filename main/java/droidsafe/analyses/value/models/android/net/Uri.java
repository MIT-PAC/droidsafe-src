package droidsafe.analyses.value.models.android.net;

import droidsafe.analyses.value.RefVAModel;
import java.util.AbstractList;
import soot.jimple.spark.pag.AllocNode;

public class Uri extends RefVAModel {

    public Uri(AllocNode allocNode) {
        super(allocNode);
    }

    private abstract static class AbstractHierarchicalUri extends Uri {

        public AbstractHierarchicalUri(AllocNode allocNode) {
            super(allocNode);
        }
    }

    abstract static class AbstractPart extends RefVAModel {

        public AbstractPart(AllocNode allocNode) {
            super(allocNode);
        }

        static class Representation extends RefVAModel {

            public Representation(AllocNode allocNode) {
                super(allocNode);
            }
        }
    }

    public static final class Builder extends RefVAModel {

        public Builder(AllocNode allocNode) {
            super(allocNode);
        }
    }

    private static class HierarchicalUri extends AbstractHierarchicalUri {

        public HierarchicalUri(AllocNode allocNode) {
            super(allocNode);
        }
    }

    private static class OpaqueUri extends Uri {

        public OpaqueUri(AllocNode allocNode) {
            super(allocNode);
        }
    }

    static class Part extends AbstractPart {

        public Part(AllocNode allocNode) {
            super(allocNode);
        }

        private static class EmptyPart extends Part {

            public EmptyPart(AllocNode allocNode) {
                super(allocNode);
            }
        }
    }

    static class PathPart extends AbstractPart {

        public PathPart(AllocNode allocNode) {
            super(allocNode);
        }
    }

    static class PathSegments extends RefVAModel {

        public PathSegments(AllocNode allocNode) {
            super(allocNode);
        }
    }

    static class PathSegmentsBuilder extends RefVAModel {

        public PathSegmentsBuilder(AllocNode allocNode) {
            super(allocNode);
        }
    }

    private static class StringUri extends AbstractHierarchicalUri {

        public StringUri(AllocNode allocNode) {
            super(allocNode);
        }
    }
}
