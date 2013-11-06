package droidsafe.eclipse.plugin.core.view.pointsto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.MethodInfoTreeElementContentProvider;
import droidsafe.speclang.model.AllocLocationModel;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.MethodArgumentModel;
import droidsafe.speclang.model.MethodModel;

/**
 * Content provider for the tree structure of the points-to outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class PointsToTreeElementContentProvider extends MethodInfoTreeElementContentProvider {

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
     * Populate the tree elements of the points-to outline view. Return the root elements.
     */
    protected Object[] initializeRoots() {
        if (!fMethod.hasPointsToInfo())
            return NO_CHILDREN;
        List<MethodArgumentModel> methodArgs = new ArrayList<MethodArgumentModel>();
        for (int i = -1; i < fMethod.getMethodArguments().size(); i++) {
            if (fMethod.getArgumentAllocSources(i) != null)
                methodArgs.add(fMethod.getArgumentModel(i));
        }
        Object[] roots = new Object[methodArgs.size()];
        for (int i = 0; i < methodArgs.size(); i++) {
            MethodArgumentModel methodArg = methodArgs.get(i);
            TreeElement<MethodArgumentModel, AllocLocationModel> root =
                    new TreeElement<MethodArgumentModel, AllocLocationModel>(methodArg.toString(),
                            methodArg, AllocLocationModel.class);
            roots[i] = root;
            List<AllocLocationModel> locs = methodArg.getAllocSources();
            for (AllocLocationModel loc : locs) {
                TreeElement<AllocLocationModel, CallLocationModel> locTreeElement =
                        new TreeElement<AllocLocationModel, CallLocationModel>(loc.toString(), loc, CallLocationModel.class);
                for (CallLocationModel call: loc.getCallsOnAlloc()) {
                    TreeElement<CallLocationModel, Object> callTreeElement =
                            new TreeElement<CallLocationModel, Object>(call.toString(), call, Object.class);
                    locTreeElement.addChild(callTreeElement);
                }
                root.addChild(locTreeElement);
            }
        }
        return roots;
    }

    /**
     * Reset the content of this content provider.
     */
    @Override
    protected void reset() {
        methodToRoots.clear();
    }

}
