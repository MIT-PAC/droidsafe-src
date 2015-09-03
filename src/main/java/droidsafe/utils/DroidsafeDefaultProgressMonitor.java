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
