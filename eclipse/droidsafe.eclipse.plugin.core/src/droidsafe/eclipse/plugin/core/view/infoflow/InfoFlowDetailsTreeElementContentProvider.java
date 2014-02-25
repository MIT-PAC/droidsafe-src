package droidsafe.eclipse.plugin.core.view.infoflow;

import java.util.ArrayList;
import java.util.List;

import droidsafe.android.system.API;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.MethodInfoTreeElementContentProvider;
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

    /**
     * Populate the tree elements of the info flow outline view. Return the root elements.
     */
    protected Object[] initializeRoots() {
        MethodModel method = null;
        String sourceFilter = null;
        String sinkFilter = null;
        if (fInput instanceof MethodModel) {
            method = (MethodModel) fInput;
        } else if (fInput instanceof MethodWithSourceSinkFilter) {
            MethodWithSourceSinkFilter methodWithSourceSinkFilter = (MethodWithSourceSinkFilter) fInput;
            method = methodWithSourceSinkFilter.getMethod();
            SourceSinkPair sourceSinkFilter = methodWithSourceSinkFilter.getSourceSinkFilter();
            sourceFilter = sourceSinkFilter.getO1();
            sinkFilter = sourceSinkFilter.getO2();
        }
        if (!method.hasInfoFlowInfo())
            return NO_CHILDREN;
        List<MethodArgumentModel> methodArgs = new ArrayList<MethodArgumentModel>();
        List<String> infoKindsStrings = new ArrayList<String>();
        for (int i = -1; i < method.getMethodArguments().size(); i++) {
            List<String> infoKinds = method.getArgumentInfoKinds(i);
            if (infoKinds != null || method.getArgumentSourceInfoUnits(i) != null) {
                if (infoKinds == null) {
                    infoKinds = new ArrayList<String>();
                    infoKinds.add(API.v().SENSITIVE_NOCATEGORY.toString());
                }
                if (sourceFilter == null || infoKinds.contains(sourceFilter)) {
                    methodArgs.add(method.getArgumentModel(i));
                    String infoKindsStr = (sourceFilter != null) ? sourceFilter : infoKinds.toString();
                    infoKindsStrings.add(infoKindsStr);
                }
            }
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
                String infoKindsStr = infoKindsStrings.get(i);
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
        List<String> sinkInfoKinds = method.getSinkInfoKinds();
        if (sinkInfoKinds != null) {
            TreeElement<String, String> root =
                    new TreeElement<String, String>("Sinks", "Sinks", String.class);
            String infoKindsStr = (sinkFilter != null) ? sinkFilter : sinkInfoKinds.toString();
            TreeElement<String, Object> infoKindsElement = new TreeElement<String, Object>(infoKindsStr, infoKindsStr, Object.class);
            root.addChild(infoKindsElement);
            roots.add(root);
        }
        return roots.toArray();
    }

}