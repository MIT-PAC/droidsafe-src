package droidsafe.eclipse.plugin.core.view.infoflow;

import soot.toolkits.scalar.Pair;
import droidsafe.speclang.model.MethodModel;

/**
 * A pair of a method model and a <source kind, sink kind> filter.
 * 
 * @author gilham
 *
 */
public class MethodWithSourceSinkFilter extends Pair<MethodModel, SourceSinkPair>{

    /**
     * Constructs a MethodWithSourceSinkFilter with the given method and the given
     * <source, sink> filter.
     */
    public MethodWithSourceSinkFilter(MethodModel method, SourceSinkPair sourceSinkFilter) {
        super(method, sourceSinkFilter);
    }
    
    /**
     * Returns the method.
     */
    public MethodModel getMethod() {
        return (MethodModel) getO1();
    }
    
    /**
     * Returns the <source, sink> filter.
     */
    public SourceSinkPair getSourceSinkFilter() {
        return (SourceSinkPair) getO2();
    }
    
}
