package droidsafe.eclipse.plugin.core.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;

import droidsafe.eclipse.plugin.core.filters.Filter;
import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;

/**
 * A wizard for creating a new filter for the current indicator display.
 * 
 * @author gilham
 *
 */
public class NewFilterWizard extends Wizard {

    /** The new filter wizard page. */
    private NewFilterWizardPage page;
    
    /** The underlying indicator outline view. */
    private IndicatorViewPart view;
    
    /** The selection in the underlying indicator outline view. */
    private IStructuredSelection selection;

    /**
     * Constructs a NewFilterWizard.
     */
    public NewFilterWizard() {
        setWindowTitle("New Filter");
    }

    /**
     * Adds one NewFilterWizardPage.
     */
    @Override
    public void addPages() {
        super.addPages();
        page = new NewFilterWizardPage(selection);
        addPage(page);
    }

    /**
     * Adds the newly constructed filter to the underlying indicator display.
     */
    @Override
    public boolean performFinish() {
        Filter filter = page.getFilter();
        if (filter != null) {
            view.addFilter(filter);
            return true;
        }
        return false;
    }

    /**
     * Initializes the new filter wizard with the given parameter values.
     * 
     * @param view - an indicator outline view
     * @param selection - a selection in the indicator outline view
     */
    public void init(IndicatorViewPart view, IStructuredSelection selection) {
        this.view = view;
        this.selection = selection;
    }

}
