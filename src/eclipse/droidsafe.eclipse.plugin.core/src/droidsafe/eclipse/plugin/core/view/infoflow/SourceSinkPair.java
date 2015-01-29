package droidsafe.eclipse.plugin.core.view.infoflow;

import soot.toolkits.scalar.Pair;

/**
 * Represents a pair of source kind and sink kind.
 * @author gilham
 *
 */
public class SourceSinkPair extends Pair<String, String>{

    /**
     * Constructs a SourceSinkPair.
     * 
     * @param source - a source kind
     * @param sink - a sink kind
     */
    public SourceSinkPair(String source, String sink) {
        super(source, sink);
    }

    @Override
    public String toString() {
        return getO1() + "->" + getO2();
    }

}
