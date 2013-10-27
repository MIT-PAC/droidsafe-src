package droidsafe.eclipse.plugin.core.view.infoflow;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.MethodInfoTreeElementContentProvider;
import droidsafe.speclang.model.AllocLocationModel;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.MethodArgumentModel;
import droidsafe.speclang.model.MethodModel;

/**
 * Content provider for the tree structure of the info flow outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class InfoFlowDetailsTreeElementContentProvider extends MethodInfoTreeElementContentProvider {

    protected static Map<MethodModel, Object[]> methodToRoots = new HashMap<MethodModel, Object[]>();

    @Override
    public Object[] getElements(Object input) {
        if (input instanceof MethodModel) {
            MethodModel method = (MethodModel) input;
            this.fMethod = method;
            Object[] roots = methodToRoots.get(method);
            if (roots == null) {
                roots = initializeRoots();
                methodToRoots.put(method, roots);
            }
            return roots;
        }
        return NO_CHILDREN;
    }

    /**
     * Populate the tree elements of the info flow outline view. Return the root elements.
     */
    protected Object[] initializeRoots() {
        if (!fMethod.hasInfoFlowInfo())
            return NO_CHILDREN;
        List<MethodArgumentModel> methodArgs = new ArrayList<MethodArgumentModel>();
        for (int i = -1; i < fMethod.getMethodArguments().size(); i++) {
            if (fMethod.getArgumentInfoKinds(i) != null || fMethod.getArgumentSourceInfoUnits(i) != null)
                methodArgs.add(fMethod.getArgumentModel(i));
        }
        List<Object> roots = new ArrayList<Object>();
        if (!methodArgs.isEmpty()) {
            TreeElement<String, MethodArgumentModel> root =
                    new TreeElement<String, MethodArgumentModel>("Sources", "Sources", MethodArgumentModel.class);
            for (int i = 0; i < methodArgs.size(); i++) {
                MethodArgumentModel methodArg = methodArgs.get(i);
                TreeElement<MethodArgumentModel, String> methArgElement =
                        new TreeElement<MethodArgumentModel, String>(methodArg.toString(),
                                methodArg, String.class);
                List<String> infoKinds = methodArg.getInfoKinds();
                if (infoKinds == null) {
                    infoKinds = new ArrayList<String>();
                    infoKinds.add("SENSITIVE_NOCATEGORY");
                }
                String infoKindsStr = infoKinds.toString();
                TreeElement<String, CallLocationModel> infoKindsElement = new TreeElement<String, CallLocationModel>(infoKindsStr, infoKindsStr, CallLocationModel.class);
                methArgElement.addChild(infoKindsElement);
                List<CallLocationModel> locs = methodArg.getSourceInfoUnits();
                if (locs != null) {
                    for (CallLocationModel loc: locs) {
                        TreeElement<CallLocationModel, Object> locElement = new TreeElement<CallLocationModel, Object>(loc.toString(), loc, Object.class);
                        infoKindsElement.addChild(locElement);
                    }
                }
                root.addChild(methArgElement);
            }
            roots.add(root);
        }
        List<String> sinkInfoKinds = fMethod.getSinkInfoKinds();
        if (sinkInfoKinds != null) {
            TreeElement<String, String> root =
                    new TreeElement<String, String>("Sinks", "Sinks", String.class);
            String infoKindsStr = sinkInfoKinds.toString();
            TreeElement<String, Object> infoKindsElement = new TreeElement<String, Object>(infoKindsStr, infoKindsStr, Object.class);
            root.addChild(infoKindsElement);
            roots.add(root);
        }
        return roots.toArray();
    }

    /**
     * Reset the content of this content provider.
     */
    @Override
    protected void reset() {
        methodToRoots.clear();
    }

}