package droidsafe.eclipse.plugin.core.view;

import org.eclipse.jface.viewers.ISelectionChangedListener;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.speclang.model.MethodModel;

/**
 * View for displaying droidsafe analysis info on a given method. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
abstract public class MethodInfoOutlineViewPart extends DroidsafeInfoOutlineViewPart implements ISelectionChangedListener {

    /** The object on which the droidsafe analysis info is to be displayed. */
    protected Object fInputElement;

    /**
     * Set the input element for the viewer and update the contents of the view.
     */
    protected void setInputElement(Object inputElement) {
        if (!inputElement.equals(fInputElement)) {
            fInputElement = inputElement;
            updateView();
        }
    }

    /**
     * Return the input element for this outline.
     */
    public Object getInputElement() {
        return fInputElement;
    }

    protected void projectChanged() {
        resetViewer();
        showPage(PAGE_EMPTY);
    }
    
    /**
     * Return the method on which the droidsafe analysis info is displayed on this outline.
     */
    protected abstract MethodModel getMethod();

    /**
     * Update the content of the outline view.
     */
    protected void updateView() {
        if (fInputElement != null && fParentComposite != null) {
            showPage(PAGE_VIEWER);
            
            String sig = DroidsafePluginUtilities.removeCloneSuffix(getMethod().getSignature());
            setContentDescription("method " + sig);

            fTreeViewer.setInput(fInputElement);
        }        
    }

}
