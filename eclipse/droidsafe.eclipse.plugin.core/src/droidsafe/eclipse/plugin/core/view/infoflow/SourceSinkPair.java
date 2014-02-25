package droidsafe.eclipse.plugin.core.view.infoflow;

import soot.toolkits.scalar.Pair;

public class SourceSinkPair extends Pair<String, String>{

    public SourceSinkPair(String source, String sink) {
        super(source, sink);
    }

    public String toString() {
        return getO1() + "->" + getO2();
    }

}
