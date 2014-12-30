package droidsafe.eclipse.plugin.core.wizards;

import java.util.List;

import org.eclipse.jface.wizard.Wizard;

import droidsafe.eclipse.plugin.core.filters.Filter;

/**
 * A wizard for editing a filter for the current indicator display.
 * 
 * @author gilham
 *
 */
public class EditFilterWizard extends Wizard {

    /** The edit filter wizard page. */
    private EditFilterWizardPage page;

    /** The list of filters for the current indicator display. */
    private List<Filter> filters;

    /** The filter being edited. */
    private Filter filter;

    /** The array of fields can be used for filtering the current indicator display. */
    private String[] filterFields;

    /**
     * Constructs an EditFilterWizard.
     */
    public EditFilterWizard() {
        setWindowTitle("Edit Filter");
    }

    /**
     * Adds one EditFilterWizardPage.
     */
    @Override
    public void addPages() {
        super.addPages();
        page = new EditFilterWizardPage(filter, filterFields);
        addPage(page);
    }

    /**
     * Updates the filters for the current indicator display by replacing
     * the edited entry with the new value.
     */
    @Override
    public boolean performFinish() {
        Filter newFilter = page.getFilter();
        if (newFilter != null) {
            int index = filters.indexOf(filter);
            filters.set(index, newFilter);
            return true;
        }
        return false;
    }

    /**
     * Initializes the wizard with the given field values.
     * 
     * @param filters - the list of filters for the indicator display
     * @param filter - the filter being edited
     * @param filterFields - the fields can be used for filtering the indicator display
     */
    public void init(List<Filter> filters, Filter filter, String[] filterFields) {
        this.filters = filters;
        this.filter = filter;
        this.filterFields = filterFields;
    }

}
