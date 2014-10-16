package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;

import droidsafe.eclipse.plugin.core.marker.ProjectMarkerProcessor;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.eclipse.plugin.core.view.infoflow.TaintSourcesViewPart;

public class ShowTaintSources extends AbstractHandler {

    public static final String COMMAND_ID = "droidsafe.eclipse.plugin.core.commands.ShowTaintSources";

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
        IWorkbenchPage activePage = window.getActivePage();
        ISelection selection = HandlerUtil.getActiveSite(event).getSelectionProvider().getSelection();
        IProject project = DroidsafePluginUtilities.getSelectedProject();
        if (project != null && selection instanceof TextSelection) {
            TextSelection textSelection = (TextSelection) selection;
            IEditorPart editor = activePage.getActiveEditor();
            IEditorInput input = editor.getEditorInput();
            if (input instanceof FileEditorInput) {
                IFile file = ((FileEditorInput)input).getFile();
                int offset = textSelection.getOffset();
                int length = textSelection.getLength();
                IMarker taintMarker = ProjectMarkerProcessor.get(project).findTaintMarker(file, offset, length);
                if (taintMarker != null) {
                    TaintSourcesViewPart.openView(taintMarker, textSelection.getText());
                }
            }
        }
        return null;
    }

}
