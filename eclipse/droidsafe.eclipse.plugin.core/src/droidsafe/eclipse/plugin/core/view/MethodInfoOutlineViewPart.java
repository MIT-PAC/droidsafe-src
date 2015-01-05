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

    /** The text displayed on the empty page. */
    public static String EMPTY_PAGE_LABEL = "Select a spec method from the 'Security Spec Outline', 'Info Flow Summary', or 'Indicator' to show info";
    
    /** The object on which the droidsafe analysis info is to be displayed. */
    protected Object fInputElement;

    /**
     * Sets the input element for the viewer and update the contents of the view.
     */
    protected void setInputElement(Object inputElement) {
        if ((inputElement == null && fInputElement != null) || 
                (inputElement != null && !inputElement.equals(fInputElement))) {
            fInputElement = inputElement;
            updateView();
        }
    }

    /**
     * Returns the input element for this outline.
     */
    public Object getInputElement() {
        return fInputElement;
    }

    /**
     * Resets the content when a different project is selected.
     */
    @Override
    protected void projectSelected() {
        resetViewer();
        setInputElement(null);
     }
    
    /**
     * Returns the method on which the droidsafe analysis info is displayed on this outline.
     */
    protected abstract MethodModel getMethod();

    /**
     * Update the content of the outline view.
     */
    protected void updateView() {
        if (fParentComposite != null) {
            if (fInputElement == null) {
                showPage(PAGE_EMPTY);
            } else {
                showPage(PAGE_VIEWER);

                String sig = DroidsafePluginUtilities.removeCloneSuffix(getMethod().getSignature());
                setContentDescription("method " + sig);

                fTreeViewer.setInput(fInputElement);
            }
        }        
    }

}
