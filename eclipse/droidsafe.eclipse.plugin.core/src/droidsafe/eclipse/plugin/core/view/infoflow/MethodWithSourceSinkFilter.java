package droidsafe.eclipse.plugin.core.view.infoflow;

import soot.toolkits.scalar.Pair;
import droidsafe.speclang.model.MethodModel;

public class MethodWithSourceSinkFilter extends Pair<MethodModel, SourceSinkPair>{

    public MethodWithSourceSinkFilter(MethodModel method, SourceSinkPair sourceSinkFilter) {
        super(method, sourceSinkFilter);
    }
    
    public MethodModel getMethod() {
        return (MethodModel) getO1();
    }
    
    public SourceSinkPair getSourceSinkFilter() {
        return (SourceSinkPair) getO2();
    }
    
}
