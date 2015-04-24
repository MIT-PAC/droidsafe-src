/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.eclipse.plugin.core.view.callhierarchy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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

/**
 * Content provider for the tree structure of a call hierarchy view.
 * 
 * @author gilham
 *
 */
public class CallHierarchyTreeElementContentProvider extends DroidsafeInfoTreeElementContentProvider {

    /** A map from input objects to the corresponding arrays of root elements. */
    protected Map<Object, Object[]> inputToRoots = new HashMap<Object, Object[]>();

    /** The call hierarchy to be displayed in the outline view */
    protected CallHierarchy fInput;

    @Override
    public Object[] getElements(Object input) {
        this.fInput = (CallHierarchy) input;
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
        this.fInput = (CallHierarchy) newInput;
    }

    /**
     * Resets the content of this content provider.
     */
    @Override
    protected void reset() {
        inputToRoots.clear();
    }

    /**
     * Creates tree elements for the callee/caller hierarchy outline view. Returns the root elements.
     */
    protected Object[] initializeRoots() {
    	getTreeElementMap().clear();
    	if (fInput instanceof CalleeHierarchy)
    		return initializeCalleeHiearchyRoots();
    	else {
    		Map<String, Map<String, Set<JsonElement>>> callerMap = ((CallerHierarchy)fInput).getCallerMap();
    		return initializeCallerHierarchyRoots(callerMap);
    	}
    }
    
    /**
     * Creates tree elements for the call hierarchy outline view. Returns the root elements.
     */
    private Object[] initializeCalleeHiearchyRoots() {
    	List<TreeElement<JsonElement, JsonElement>> roots = new ArrayList<TreeElement<JsonElement, JsonElement>>();
    	CalleeHierarchy calleeHierarchy = (CalleeHierarchy) fInput;
    	Collection<JsonElement> rootNodes = calleeHierarchy.getRoots();
    	for (JsonElement rootElement: rootNodes) {
    		if (!Utils.isEmptyJsonObject(rootElement)) {
    			TreeElement<JsonElement, JsonElement> root = initializeCalleeTree(rootElement);
    			roots.add(root);
    		}
    	}
    	return roots.toArray();
    }

    /**
     * Creates tree elements for the callee hierarchy rooted at the given Json element. Returns the root element.
     */
    private TreeElement<JsonElement, JsonElement> initializeCalleeTree(JsonElement jsonElement) {
    	TreeElement<JsonElement, JsonElement> element = new TreeElement<JsonElement, JsonElement>(jsonElement.toString(), jsonElement, JsonElement.class);
    	getTreeElementMap().put(jsonElement, element);
    	JsonArray childrenArray = Utils.getChildrenArray(jsonElement);
    	if (childrenArray != null) {
    		for (int i = 0; i < childrenArray.size(); i++) {
    			JsonElement childElement = childrenArray.get(i);
    			if (!Utils.isEmptyJsonObject(childElement)) {
    				String sig = Utils.getSignature(childElement);
    				if (sig != null) {
    					String methodName = Utils.signatureMethodName(sig);
    					if (!methodName.matches(".*access\\$\\d+.*")) {
    						TreeElement<JsonElement, JsonElement> child = initializeCalleeTree(childElement);
    						element.addChild(child);
    					}
    				}
    			}
    		}
    	}
    	return element;
    }

    /**
     * Creates tree elements for the caller hierarchy outline view. Returns the root elements.
     * @param callerMap - a map from callee signatures to caller signatures to sets of method calls
     * @return the root elements
     */
    private Object[] initializeCallerHierarchyRoots(Map<String, Map<String, Set<JsonElement>>> callerMap) {
    	List<TreeElement<SourceMethodNode, SourceMethodNode>> roots = new ArrayList<TreeElement<SourceMethodNode, SourceMethodNode>>();
    	CallerHierarchy callerHierarchy = (CallerHierarchy) fInput;
    	SourceMethodNode rootNode = callerHierarchy.getRoot();
    	Set<SourceMethodNode> processedNodes = new HashSet<SourceMethodNode>();
    	TreeElement<SourceMethodNode, SourceMethodNode> root = initializeCallerHierarchy(rootNode, processedNodes, callerMap);
    	return new Object[]{root};
    }

    /**
     * Creates tree elements for the caller hierarchy rooted at the given node. Returns the root element.
     * @param methodNode - a source method node
     * @param processedNodes - a set of source mothod nodes already processed
     * @param callerMap - a map from callee signatures to caller signatures to sets of method calls
     * @return the root element
     */
    private TreeElement<SourceMethodNode, SourceMethodNode> initializeCallerHierarchy(SourceMethodNode methodNode, Set<SourceMethodNode> processedNodes, Map<String, Map<String, Set<JsonElement>>> callerMap) {
    	TreeElement<SourceMethodNode, SourceMethodNode> element = new TreeElement<SourceMethodNode, SourceMethodNode>(methodNode.toString(), methodNode, SourceMethodNode.class);
    	getTreeElementMap().put(methodNode, element);
    	if (!processedNodes.contains(methodNode)) {
    		processedNodes.add(methodNode);
    		Map<String, Set<JsonElement>> callers = callerMap.get(methodNode.signature);
    		if (callers != null) {
    			for (String callerSig: callers.keySet()) {
    				SourceMethodNode callerNode = SourceMethodNode.get(callerSig);
    				TreeElement<SourceMethodNode, SourceMethodNode> caller = initializeCallerHierarchy(callerNode, processedNodes, callerMap);
    				element.addChild(caller);
    			}
    		}
    	}
    	return element;
    }

}
