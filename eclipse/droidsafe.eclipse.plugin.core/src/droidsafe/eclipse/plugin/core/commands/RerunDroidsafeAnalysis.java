package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.runner.DroidsafeAnalysisRunner;
import droidsafe.eclipse.plugin.core.view.spec.SecuritySpecOutlineViewPart;

/**
 * Command to rerun the droidsafe analysis directly from the outline view.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class RerunDroidsafeAnalysis extends AbstractHandler {
  private final static Logger logger = LoggerFactory.getLogger(RerunDroidsafeAnalysis.class);

  /**
   * Command implementation. Runs the droidsafe analysis in a separate thread. After the analysis is
   * finished, refreshes the outline view.
   */
  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchPart part = HandlerUtil.getActivePart(event);
    if (part instanceof SecuritySpecOutlineViewPart) {
      final SecuritySpecOutlineViewPart droidsafeView = (SecuritySpecOutlineViewPart) part;
      IProject projectAux = droidsafeView.getProject();
      if (projectAux != null) {
        final IProject project = projectAux;
        final IPath path = project.getLocation();
        logger.debug("Project = " + project + " path = " + path);
        Job job = new Job("Droidsafe") {
          @Override
          protected IStatus run(IProgressMonitor monitor) {
            logger.debug("Project = " + project + " path = " + path);
            IStatus status = Status.OK_STATUS;
            try {
              monitor.beginTask("Droidsafe spec dump", 18);
              DroidsafeAnalysisRunner droidsafeAnalysisRunner =
                  new DroidsafeAnalysisRunner(project);
              monitor.worked(1);
              status = droidsafeAnalysisRunner.run(monitor);
              Display.getDefault().syncExec(new Runnable() {
                public void run() {
                  droidsafeView.refreshSpecAndOutlineView();
                }
              });

            } catch (Exception ex) {
              logger.error("Exception during analysis {}", ex);
              ex.printStackTrace();
            } finally {
              monitor.done();
            }
            return status;
          }
        };
        job.setUser(true);
        job.schedule();
      }


    }
    return null;
  }

}
