package droidsafe.eclipse.plugin.core.view;

import org.eclipse.jface.viewers.ISelectionChangedListener;

import droidsafe.speclang.model.MethodModel;
import droidsafe.transforms.objsensclone.ClassCloner;

/**
 * View for displaying droidsafe analysis info on a given method. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
abstract public class MethodInfoOutlineViewPart extends DroidsafeInfoOutlineViewPart implements ISelectionChangedListener {

    /** The method on which the droidsafe analysis info is to be displayed. */
    protected MethodModel fInputElement;

    /**
     * Set the input element for the viewer and update the contents of the view.
     */
    protected void setInputElement(MethodModel inputElement) {
        if (!inputElement.equals(fInputElement)) {
            fInputElement = inputElement;
            updateView();
        }
    }

    /**
     * Return the input element for this outline.
     */
    public MethodModel getInputElement() {
        return fInputElement;
    }

    protected void projectChanged() {
        resetViewer();
        showPage(PAGE_EMPTY);
    }

    /**
     * Update the content of the outline view.
     */
    protected void updateView() {
        if (fInputElement != null && fParentComposite != null) {
            showPage(PAGE_VIEWER);
            
            String sig = ClassCloner.removeClassCloneSuffix(fInputElement.getSignature());
            setContentDescription("method " + sig);

            fTreeViewer.setInput(fInputElement);
        }        
    }

}
