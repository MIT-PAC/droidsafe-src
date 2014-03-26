package droidsafe.eclipse.plugin.core.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;

import droidsafe.eclipse.plugin.core.view.json.Filter;
import droidsafe.eclipse.plugin.core.view.json.JsonViewPart;

public class NewFilterWizard extends Wizard {

    private NewFilterWizardPage page;
    private JsonViewPart view;
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

    public void init(JsonViewPart view, IStructuredSelection selection) {
        this.view = view;
        this.selection = selection;
    }

}
