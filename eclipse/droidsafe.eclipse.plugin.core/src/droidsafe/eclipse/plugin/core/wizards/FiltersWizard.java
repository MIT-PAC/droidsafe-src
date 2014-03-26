package droidsafe.eclipse.plugin.core.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;

import droidsafe.eclipse.plugin.core.view.json.Filter;
import droidsafe.eclipse.plugin.core.view.json.JsonViewPart;

public class FiltersWizard extends Wizard {

    private FiltersWizardPage page;
    private JsonViewPart view;

    public FiltersWizard() {
        setWindowTitle("Filters");
    }

    @Override
    public void addPages() {
        super.addPages();
        page = new FiltersWizardPage(view.getFilters());
        addPage(page);
    }

    @Override
    public boolean performFinish() {
        view.setFilters(page.getNewFilters());
        return true;
    }

    public void init(JsonViewPart view) {
        this.view = view;
    }

}
