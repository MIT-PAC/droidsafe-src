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
