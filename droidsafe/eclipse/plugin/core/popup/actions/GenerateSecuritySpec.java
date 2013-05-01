package droidsafe.eclipse.plugin.core.popup.actions;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.runner.DroidsafeAnalysisRunner;

public class GenerateSecuritySpec implements IObjectActionDelegate {
  private final static Logger logger = LoggerFactory.getLogger(GenerateSecuritySpec.class);

  private IWorkbenchPart targetPart;
  private Shell shell;

  /**
   * Constructor for Action1.
   */
  public GenerateSecuritySpec() {
    super();
  }

  /**
   * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
   */
  public void setActivePart(IAction action, IWorkbenchPart targetPart) {
    this.targetPart = targetPart;
    this.shell = targetPart.getSite().getShell();
  }

  /**
   * @see IActionDelegate#run(IAction)
   */
  public void run(IAction action) {
    // MessageDialog.openInformation(shell, "Core",
    // "Generate Security Spec was executed.");
    IStructuredSelection selection =
        (IStructuredSelection) targetPart.getSite().getSelectionProvider().getSelection();
    final IProject project = (IProject) selection.getFirstElement();
    final IPath path = project.getLocation();
    logger.info("Project = " + project + " path = " + path);

    Job job = new Job("Droidsafe") {
      @Override
      protected IStatus run(IProgressMonitor monitor) {
        logger.info("Project = " + project + " path = " + path);
        new DroidsafeAnalysisRunner(project).run();
        monitor.done();
        return Status.OK_STATUS;
      }
    };
    job.setUser(true);
    job.schedule();    
  }

  /**
   * @see IActionDelegate#selectionChanged(IAction, ISelection)
   */
  public void selectionChanged(IAction action, ISelection selection) {}

}
