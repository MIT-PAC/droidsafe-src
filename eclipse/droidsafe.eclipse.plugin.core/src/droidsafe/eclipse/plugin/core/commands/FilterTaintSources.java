package droidsafe.eclipse.plugin.core.commands;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.internal.ide.dialogs.SimpleListContentProvider;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import droidsafe.eclipse.plugin.core.marker.ClassTaintMarkerProcessor;
import droidsafe.eclipse.plugin.core.marker.ProjectTaintMarkerProcessor;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.indicator.IndicatorViewPart;
import droidsafe.eclipse.plugin.core.wizards.NewFilterWizard;

public class FilterTaintSources extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IProject project = DroidsafePluginUtilities.getSelectedProject();
        IEditorPart editor = DroidsafePluginUtilities.getActiveEditor();
        if (project != null && editor != null && editor instanceof ITextEditor) {
            ProjectTaintMarkerProcessor taintMarkerProcessor = ProjectTaintMarkerProcessor.get(project);
            List<String> taintKinds = taintMarkerProcessor.getTaintKinds();
            Set<String> filteredTaintKinds = taintMarkerProcessor.getFilteredTaintKinds();
            Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
            ListSelectionDialog dialog =
                    new ListSelectionDialog(
                        shell,
                        taintKinds,
                        ArrayContentProvider.getInstance(),
                        new LabelProvider(),
                        "Select the kinds of taint sources to display:");
            dialog.setInitialSelections(filteredTaintKinds.toArray());
            dialog.setTitle("Filter Taint Sources");
            dialog.open();
            Object[] result = dialog.getResult();
            if (result != null) {
                Set<String> newFilteredTaintKinds = new TreeSet<String>();
                for (Object selected: result) {
                    newFilteredTaintKinds.add((String)selected);
                }
                if (!newFilteredTaintKinds.equals(filteredTaintKinds)) {
                    ITextEditor textEditor = (ITextEditor) editor;
                    taintMarkerProcessor.setFilteredTaintSources(textEditor, newFilteredTaintKinds);
                }
            }
        }
        return null;
    }
}
