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
