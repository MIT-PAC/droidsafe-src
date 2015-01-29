package droidsafe.eclipse.plugin.core.wizards;

import org.eclipse.jface.wizard.Wizard;

import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;

/**
 * A wizard for editing the set of filters for the current indicator display.
 * 
 * @author gilham
 *
 */
public class FiltersWizard extends Wizard {

    /** The filters wizard page. */
    private FiltersWizardPage page;
    
    /** The underlying indicator outline view. */
    private IndicatorViewPart view;

    /**
     * Constructs a FiltersWizard.
     */
    public FiltersWizard() {
        setWindowTitle("Filters");
    }

    /**
     * Adds one FiltersWizardPage.
     */
    @Override
    public void addPages() {
        super.addPages();
        page = new FiltersWizardPage(view.getFilters(), view.getFilterFields());
        addPage(page);
    }

    /**
     * Updates the set of filters for the current indicator display to the 
     * edit results.
     */
    @Override
    public boolean performFinish() {
        view.setFilters(page.getNewFilters());
        return true;
    }

    /**
     * Initializes the filters wizard with the given indicator outline view.
     */
    public void init(IndicatorViewPart view) {
        this.view = view;
    }

}
