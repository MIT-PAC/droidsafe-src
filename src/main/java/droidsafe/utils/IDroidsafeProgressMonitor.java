/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

/**
 * 
 */
package droidsafe.utils;

/**
 * This is an interface to define a wrapper class for eclipse progress monitor.
 * 
 * When running droidsafe from the eclipse plugin, a progress bar shows the amount of work already
 * performed, the current task being executed, and allows the cancellation of the analysis.
 * 
 * Since we also want to run droidsafe standalone, and do not want droidsafe to depend on eclipse
 * classes, we define this interface with a default implementation to be used by the standalone
 * version of droidsafe. The default implementation is basically a no-op since cancellation of the
 * analysis would kill the entire process.
 * 
 * In the plugin, we implement this interface in a class wrapping the actual eclipse progress
 * monitor so we can get the desired status bar update, and the ability of cancelling the execution
 * of the analysis.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public interface IDroidsafeProgressMonitor {

  /**
   * Method to report the amount of work that has been completed or performed since the last call to
   * this method. Every time this method is called, the progress bar in the eclipse interface is
   * incremented based on the amount of work completed so far.
   * 
   * @param work An integer representing the units of work that has been completed.
   */
  public void worked(int work);



  /**
   * In the eclipse plugin, tells the executing method if the user has requested the cancellation of
   * the on-going computation. Notice that we need to check this condition at each point we want to
   * allow the computation to be cancelled.
   * 
   * @return TRUE if the user has requested the cancellation of the analysis.
   */
  public boolean isCanceled();

  /**
   * In the eclipse plugin, prints the label of the task currently being performed on the progress
   * bar pSanel.
   *
   * @param taskLabel The label to display close to the eclipse progress bar.
   */
  public void subTask(String taskLabel);
}
