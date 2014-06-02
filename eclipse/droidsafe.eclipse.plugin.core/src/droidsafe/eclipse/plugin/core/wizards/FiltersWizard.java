package droidsafe.eclipse.plugin.core.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;

import droidsafe.eclipse.plugin.core.filters.Filter;
import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;

public class FiltersWizard extends Wizard {

    private FiltersWizardPage page;
    private IndicatorViewPart view;

    public FiltersWizard() {
        setWindowTitle("Filters");
    }

    @Override
    public void addPages() {
        super.addPages();
        page = new FiltersWizardPage(view.getFilters(), view.getFilterFields());
        addPage(page);
    }

    @Override
    public boolean performFinish() {
        view.setFilters(page.getNewFilters());
        return true;
    }

    public void init(IndicatorViewPart view) {
        this.view = view;
    }

}
