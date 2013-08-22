/**
 * 
 */
package droidsafe.utils;

/**
 * Default implementation for the progress monitor to be used by the standalone version of the droidsafe analysis. 
 * 
 * This version is a no-op and its only purpose is to allow the eclipse plugin to reuse the main droidsafe class and still 
 * be able to provide progress update and cancellation capabilities. 
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 *
 */
public class DroidsafeDefaultProgressMonitor implements IDroidsafeProgressMonitor {

  /* (non-Javadoc)
   * @see droidsafe.utils.IDroidsafeProgressMonitor#worked(int)
   */
  @Override
  public void worked(int work) {
  }

  /* (non-Javadoc)
   * @see droidsafe.utils.IDroidsafeProgressMonitor#isCancelled()
   */
  @Override
  public boolean isCanceled() {
    return false;
  }

  /* (non-Javadoc)
   * @see droidsafe.utils.IDroidsafeProgressMonitor#subTask()
   */
  @Override
  public void subTask(String taskLabel) {
  }

}
