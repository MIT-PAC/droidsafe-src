/**
 * 
 */
package droidsafe.eclipse.plugin.core.runner;

import org.eclipse.core.runtime.IProgressMonitor;

import droidsafe.utils.IDroidsafeProgressMonitor;

/**
 * Implementation of the progress monitor to be used by the eclipse plugin version of the droidsafe
 * analysis.
 * 
 * This version delegates all method calls to the eclipse progress monitor that should be specified
 * in the constructor of this class.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class DroidsafeEclipseProgressMonitor implements IDroidsafeProgressMonitor {

  /** The actual eclipse progress monitor this class is wrapping. */
  private IProgressMonitor progressMonitor;

  public DroidsafeEclipseProgressMonitor(IProgressMonitor monitor) {
    this.progressMonitor = monitor;
  }

  /*
   * (non-Javadoc)
   * 
   * @see droidsafe.utils.IDroidsafeProgressMonitor#worked(int)
   */
  @Override
  public void worked(int work) {
    this.progressMonitor.worked(work);
  }

  /*
   * (non-Javadoc)
   * 
   * @see droidsafe.utils.IDroidsafeProgressMonitor#isCancelled()
   */
  @Override
  public boolean isCanceled() {
    return this.progressMonitor.isCanceled();
  }

  /*
   * (non-Javadoc)
   * 
   * @see droidsafe.utils.IDroidsafeProgressMonitor#subTask()
   */
  @Override
  public void subTask(String taskLabel) {
    this.progressMonitor.subTask(taskLabel);
  }

}
