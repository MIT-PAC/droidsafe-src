package droidsafe.eclipse.plugin.core.view;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ISelectionChangedListener;

import droidsafe.speclang.model.SecuritySpecModel;

/**
 * View for displaying droidsafe analysis info on a given method. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
abstract public class SpecInfoOutlineViewPart extends DroidsafeInfoOutlineViewPart implements ISelectionChangedListener {

    /** The security spec on which the droidsafe analysis info is to be displayed. */
    protected SecuritySpecModel fInputElement;

    @Override
    protected String emptyPageText() {
    	IProject project = getProject();
    	if (project == null)
    		return "No Android Project selected. " +
    		"\nSelect an Android project in the Project Explorer.";
    	String projectName = project.getName();
    	return "No security spec found for the selected project " + projectName +
    			"\nYou need to first generate the security spec first from a shell.";
    }
    
    /**
     * Set the input element for the viewer and update the contents of the view.
     */
    protected void setInputElement(SecuritySpecModel inputElement) {
        if (!inputElement.equals(fInputElement)) {
            fInputElement = inputElement;
            updateView();
        }
    }

    /**
     * Return the input element for this outline.
     */
    public SecuritySpecModel getInputElement() {
        return fInputElement;
    }

//    protected void resetViewer() {
//        fInputElement = null;
//        if (fTreeViewer != null)
//            fTreeViewer.setInput(null);
//        ((MethodInfoTreeElementContentProvider) fContentProvider).reset();
//    }

    /**
     * Update the content of the outline view.
     */
    protected void updateView() {
        if (fInputElement != null && fParentComposite != null) {
            showPage(PAGE_VIEWER);
            
//            setContentDescription("project " + getProject().getName());
            
            fTreeViewer.setInput(fInputElement);
        }        
    }

}
