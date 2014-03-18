package droidsafe.eclipse.plugin.core.view.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.infoflow.SourceSinkPair;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.SecuritySpecModel;

/**
 * Content provider for the tree structure of the points-to outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class JsonTreeElementContentProvider extends DroidsafeInfoTreeElementContentProvider {
    
    public static final String CHILDREN_PROP = "contents";

    /** The object on which the droidsafe analysis info is to be displayed in the outline view */
    protected JsonObject fInput;

    @Override
    public Object[] getElements(Object input) {
        if (input instanceof JsonObject) {
            this.fInput = (JsonObject) input;
            return initializeRoots();
        }
        return NO_CHILDREN;
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        this.fViewer = (TreeViewer) viewer;
        this.fInput = (JsonObject) newInput;
    }

    /**
     * Populate the tree elements of the JSON object outline view. Return the root elements.
     */
    protected Object[] initializeRoots() {
        List<Object> roots = new ArrayList<Object>();
        JsonArray rootArray = Utils.getChildrenArray(fInput, CHILDREN_PROP);
        if (rootArray != null) {
            for (int i = 0; i < rootArray.size(); i++) {
                JsonElement rootElement = rootArray.get(i);
                TreeElement<JsonElement, JsonElement> root = initializeTree(rootElement);
                roots.add(root);
            }
            return roots.toArray();
        }
        return NO_CHILDREN;
    }

    private TreeElement<JsonElement, JsonElement> initializeTree(JsonElement jsonElement) {
        TreeElement<JsonElement, JsonElement> root =
                new TreeElement<JsonElement, JsonElement>(jsonElement.toString(), jsonElement, JsonElement.class);
        JsonArray childrenArray = Utils.getChildrenArray(jsonElement, CHILDREN_PROP);
        if (childrenArray != null) {
            for (int i = 0; i < childrenArray.size(); i++) {
                JsonElement childElement = childrenArray.get(i);
                TreeElement<JsonElement, JsonElement> child = initializeTree(childElement);
                root.addChild(child);
            }
        }
        return root;
    }

    /**
     * Reset the content of this content provider.
     */
    @Override
    protected void reset() {
    }
    
}
