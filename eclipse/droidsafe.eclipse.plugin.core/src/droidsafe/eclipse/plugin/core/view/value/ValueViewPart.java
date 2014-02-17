package droidsafe.eclipse.plugin.core.view.value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoViewPart;
import droidsafe.speclang.model.MethodModel;

/**
 * View for displaying droidsafe value analysis info on a given method. 
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class ValueViewPart extends DroidsafeInfoViewPart {

    /** The ID of the view as specified by the extension. */
    public static final String VIEW_ID = "droidsafe.eclipse.plugin.core.view.ValueView";

    /** The text displayed on the empty page. */
    protected static String EMPTY_PAGE_LABEL = "To display the value info, first select a method from the 'Security Spec Outline'";
    
    /** The main tree viewer used to display droidsafe analysis info. */
    protected TextViewer fTextViewer;

    /** Standard Eclipse content provider to populate the tree viewer. */
    protected ITreeContentProvider fContentProvider;

    /** Standard Eclipse label provider to provide images and labels to the different tree nodes. */
    protected IBaseLabelProvider fLabelProvider;

    @Override
    protected String emptyPageText() {
        return EMPTY_PAGE_LABEL;
    }
    
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
     * Clear the content of the outline view. 
     */
    protected void clearViewer() {
        fInputElement = null;
        fTextViewer.getDocument().set("");
    }
    
    protected void resetViewer() {
        methodToValuesText.clear();
    }

    /**
     * Create a tree viewer for the outline view.
     */
    protected void createViewer(Composite parent) {
        fTextViewer = new TextViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        IDocument document = new Document();
        fTextViewer.setDocument(document);
        parent.redraw();
        parent.layout();
    }

    /**
     * Update the content of the outline view.
     */
    protected void updateView() {
        if (fInputElement != null && fParentComposite != null) {
            showPage(PAGE_VIEWER);
            
            String sig = DroidsafePluginUtilities.removeCloneSuffix(fInputElement.getSignature());
            setContentDescription("method " + sig);
            
            String valuesText = getValuesText(fInputElement);
            fTextViewer.getDocument().set(valuesText);
        }        
    }

    static Map<MethodModel, String> methodToValuesText = new HashMap<MethodModel, String>();
    
    private String getValuesText(MethodModel method) {
        if (!method.hasValueInfo()) {
            return "";
        } else {
            String valuesText = methodToValuesText.get(method);
            if (valuesText == null) {
                StringBuffer buf = new StringBuffer();
                String receiverValue = method.getReceiverValue();
                if (receiverValue != null && !receiverValue.isEmpty()) {
                    buf.append("----- receiver: ");
                    buf.append(method.getReceiverType());
                    buf.append(" --------------------\n\n");
                    buf.append(receiverValue);
                }
                List<String> argTypes = method.getMethodArguments();
                for (int i = 0; i < argTypes.size(); i++) {
                    String argValue = method.getArgumentValue(i);
                    if (argValue != null) {
                        if (buf.length() > 0) 
                            buf.append(":\n\n");
                        buf.append("----- argument ");
                        buf.append(i + 1);
                        buf.append(": ");
                        buf.append(argTypes.get(i));
                        buf.append(" --------------------\n\n");
                        buf.append(argValue);
                    }
                }
                valuesText = buf.toString();
                methodToValuesText.put(method, valuesText);
            }
            return DroidsafePluginUtilities.removeCloneSuffix(valuesText);
        } 
    }

    /**
     * Return the current TreeViewer for the outline.
     */
    public TextViewer getViewer() {
        return fTextViewer;
    }

    protected Control getControl() {
        return fTextViewer.getControl();
    }

    /**
     * Open the outline view for the given input element.
     */
    public static void openView(MethodModel inputElement) {
        IWorkbenchPage activePage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
        ValueViewPart view = (ValueViewPart) activePage.findView(VIEW_ID);
        if (view == null) {
            // open the view
            try {
                view = (ValueViewPart) activePage.showView(VIEW_ID);
            } catch (PartInitException e) {
                e.printStackTrace();
            }
        }
        view.setInputElement(inputElement);
        activePage.activate(view);
    }

}
