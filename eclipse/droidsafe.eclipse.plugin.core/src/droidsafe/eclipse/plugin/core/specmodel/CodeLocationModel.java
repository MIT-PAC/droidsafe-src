/**
 * 
 */
package droidsafe.eclipse.plugin.core.specmodel;

import droidsafe.utils.SourceLocationTag;

/**
 * Wrapper around the droidsafe.speclang.SourceLineNumberTag to include the status of the issue.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class CodeLocationModel extends SourceLocationTag {

  /**
   * Serialization id for class.
   */
  private static final long serialVersionUID = -8049573443676341282L;

  /**
   * Current status of the code location.
   */
  private DroidsafeIssueResolutionStatus status = DroidsafeIssueResolutionStatus.UNRESOLVED;

  public CodeLocationModel(String clz, int line) {
    super(clz, line);
  }

  public CodeLocationModel(SourceLocationTag line) {
    this(line.getClz(), line.getLine());
  }

  /*
   * Set the status of this code location to SAFE.
   */
  public void setSafe() {
    this.status = DroidsafeIssueResolutionStatus.SAFE;
  }

  /*
   * Set the status of this code location to UNSAFE.
   */
  public void setUnsafe() {
    this.status = DroidsafeIssueResolutionStatus.UNSAFE;
  }

  /*
   * Set the status of this code location to PENDING further decision on safety of issue.
   */
  public void setPending() {
    this.status = DroidsafeIssueResolutionStatus.PENDING;
  }

  /*
   * Set the status of this code location to UNRESOLVED, meaning that the issue has not yet been
   * considered.
   */
  public void setUnresolved() {
    this.status = DroidsafeIssueResolutionStatus.UNRESOLVED;
  }

  public DroidsafeIssueResolutionStatus getStatus() {
    return this.status;
  }

  /*
   * Returns true if the status of the location is safe.
   */
  public boolean isSafe() {
    return (this.status == DroidsafeIssueResolutionStatus.SAFE);
  }

  /*
   * Returns true if the status of the location is unsafe, false otherwise.
   */
  public boolean isUnsafe() {
    return (this.status == DroidsafeIssueResolutionStatus.UNSAFE);
  }

  /*
   * Returns true if the status of the location is unresolved, false otherwise.
   */
  public boolean isUnresolved() {
    return (this.status == DroidsafeIssueResolutionStatus.UNRESOLVED);
  }
  
}
