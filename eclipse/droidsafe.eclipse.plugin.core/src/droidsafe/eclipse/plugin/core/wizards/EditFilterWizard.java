package droidsafe.eclipse.plugin.core.wizards;

import java.util.List;

import org.eclipse.jface.wizard.Wizard;

import droidsafe.eclipse.plugin.core.filters.Filter;

public class EditFilterWizard extends Wizard {

    private EditFilterWizardPage page;
    private List<Filter> filters;
    private Filter filter;
    private String[] filterFields;

    public EditFilterWizard() {
        setWindowTitle("Edit Filter");
    }

    @Override
    public void addPages() {
        super.addPages();
        page = new EditFilterWizardPage(filter, filterFields);
        addPage(page);
    }

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

    public void init(List<Filter> filters, Filter filter, String[] filterFields) {
        this.filters = filters;
        this.filter = filter;
        this.filterFields = filterFields;
    }

}
