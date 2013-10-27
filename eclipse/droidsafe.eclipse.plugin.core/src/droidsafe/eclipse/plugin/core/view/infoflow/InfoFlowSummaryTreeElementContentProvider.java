package droidsafe.eclipse.plugin.core.view.infoflow;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.MethodInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.SpecInfoTreeElementContentProvider;
import droidsafe.speclang.model.AllocLocationModel;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.MethodArgumentModel;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.SecuritySpecModel;

/**
 * Content provider for the tree structure of the info flow outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class InfoFlowSummaryTreeElementContentProvider extends SpecInfoTreeElementContentProvider {

    @Override
    public Object[] getElements(Object input) {
        if (input instanceof SecuritySpecModel) {
            SecuritySpecModel spec = (SecuritySpecModel) input;
            this.fSpec = spec;
            return initializeRoots();
        }
        return NO_CHILDREN;
    }

    /**
     * Populate the tree elements of the info flow outline view. Return the root elements.
     */
    protected Object[] initializeRoots() {
      Map<String, Map<String, Set<MethodModel>>> infoFlowSummaryMap = fSpec.getInfoFlowSummaryMap();
        if (infoFlowSummaryMap.isEmpty())
            return NO_CHILDREN;
        List<Object> roots = new ArrayList<Object>();
        for (String source : infoFlowSummaryMap.keySet()) {
            Map<String, Set<MethodModel>> sinkMap = infoFlowSummaryMap.get(source);
            for (String sink : sinkMap.keySet()) {
                String sourceSinkPair = source + " -> " + sink;
                TreeElement<String, MethodModel> root =
                        new TreeElement<String, MethodModel>(sourceSinkPair, sourceSinkPair, MethodModel.class);
                Set<MethodModel> methods = sinkMap.get(sink);
                for (MethodModel method: methods) {
                    TreeElement<MethodModel, Object> methElement =
                            new TreeElement<MethodModel, Object>(method.toString(), method, Object.class);
                    root.addChild(methElement);
                }
                roots.add(root);
            }
        }
        return roots.toArray();
    }

    /**
     * Reset the content of this content provider.
     */
    @Override
    protected void reset() {
    }

}