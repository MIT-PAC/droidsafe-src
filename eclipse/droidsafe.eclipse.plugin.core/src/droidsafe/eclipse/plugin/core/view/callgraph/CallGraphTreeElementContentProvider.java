package droidsafe.eclipse.plugin.core.view.callgraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.indicator.Utils;

public class CallGraphTreeElementContentProvider extends DroidsafeInfoTreeElementContentProvider {

    protected Map<Object, Object[]> inputToRoots = new HashMap<Object, Object[]>();

    /** The object on which the droidsafe analysis info is to be displayed in the outline view */
    protected ICallGraph fInput;

    @Override
    public Object[] getElements(Object input) {
        this.fInput = (ICallGraph) input;
        Object[] roots = inputToRoots.get(input);
        if (roots == null) {
            roots = initializeRoots();
            inputToRoots.put(input, roots);
        }
        return roots;
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        this.fViewer = (TreeViewer) viewer;
        this.fInput = (ICallGraph) newInput;
    }

    /**
     * Reset the content of this content provider.
     */
    @Override
    protected void reset() {
        inputToRoots.clear();
    }
    /**
     * Populate the tree elements of the info sources outline view. Return the root elements.
     */
    protected Object[] initializeRoots() {
    	getTreeElementMap().clear();
    	if (fInput instanceof CallGraph)
    		return initializeCallGraphRoots();
    	else
    		return initializeCallerGraphRoots();
    }
    
    private Object[] initializeCallGraphRoots() {
    	List<TreeElement<JsonElement, JsonElement>> roots = new ArrayList<TreeElement<JsonElement, JsonElement>>();
    	CallGraph callGraph = (CallGraph) fInput;
    	Collection<JsonElement> rootNodes = callGraph.getRoots();
    	for (JsonElement rootElement: rootNodes) {
    		if (!Utils.isEmptyJsonObject(rootElement)) {
    			TreeElement<JsonElement, JsonElement> root = initializeCalleeTree(rootElement);
    			roots.add(root);
    		}
    	}
    	return roots.toArray();
    }

    private TreeElement<JsonElement, JsonElement> initializeCalleeTree(JsonElement jsonElement) {
    	TreeElement<JsonElement, JsonElement> element = new TreeElement<JsonElement, JsonElement>(jsonElement.toString(), jsonElement, JsonElement.class);
    	getTreeElementMap().put(jsonElement, element);
    	JsonArray childrenArray = Utils.getChildrenArray(jsonElement);
    	if (childrenArray != null) {
    		for (int i = 0; i < childrenArray.size(); i++) {
    			JsonElement childElement = childrenArray.get(i);
    			if (!Utils.isEmptyJsonObject(childElement)) {
    				TreeElement<JsonElement, JsonElement> child = initializeCalleeTree(childElement);
    				element.addChild(child);
    			}
    		}
    	}
    	return element;
    }

    private Object[] initializeCallerGraphRoots() {
    	List<TreeElement<SourceMethodNode, SourceMethodNode>> roots = new ArrayList<TreeElement<SourceMethodNode, SourceMethodNode>>();
    	CallerGraph callerGraph = (CallerGraph) fInput;
    	SourceMethodNode rootNode = callerGraph.getRoot();
    	TreeElement<SourceMethodNode, SourceMethodNode> root = initializeCallerTree(rootNode);
    	return new Object[]{root};
    }

    private TreeElement<SourceMethodNode, SourceMethodNode> initializeCallerTree(SourceMethodNode methodNode) {
    	TreeElement<SourceMethodNode, SourceMethodNode> element = new TreeElement<SourceMethodNode, SourceMethodNode>(methodNode.toString(), methodNode, SourceMethodNode.class);
    	getTreeElementMap().put(methodNode, element);
    	Map<String, Set<JsonElement>> callers = CallerGraph.callerMap.get(methodNode.signature);
    	if (callers != null) {
    		for (String callerSig: callers.keySet()) {
    			SourceMethodNode callerNode = SourceMethodNode.get(callerSig);
    			TreeElement<SourceMethodNode, SourceMethodNode> caller = initializeCallerTree(callerNode);
    			element.addChild(caller);
    		}
    	}
    	return element;
    }

}
