package droidsafe.eclipse.plugin.core.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;

import droidsafe.eclipse.plugin.core.filters.Filter;
import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;

public class NewFilterWizard extends Wizard {

    private NewFilterWizardPage page;
    private IndicatorViewPart view;
    private IStructuredSelection selection;

    public NewFilterWizard() {
        setWindowTitle("New Filter");
    }

    @Override
    public void addPages() {
        super.addPages();
        page = new NewFilterWizardPage(selection);
        addPage(page);
    }

    @Override
    public boolean performFinish() {
        Filter filter = page.getFilter();
        if (filter != null) {
            view.addFilter(filter);
            return true;
        }
        return false;
    }

    public void init(IndicatorViewPart view, IStructuredSelection selection) {
        this.view = view;
        this.selection = selection;
    }

}
