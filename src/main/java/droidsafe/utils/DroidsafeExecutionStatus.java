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
 * 
 * This is an auxiliary class to allow the main droidsafe method to return a status value that can
 * be used by the eclipse plugin to cancel the execution of the analysis before it finishes.
 * 
 * There are only two execution status, CANCEL_STATUS, meaning the user has requested the
 * cancellation of the execution, and OK_STATUS, meaning the execution finished without problems.
 * 
 * This class is not used to report errors during execution. Problems during execution should throw
 * exceptions.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public enum DroidsafeExecutionStatus {
  CANCEL_STATUS, OK_STATUS
}
