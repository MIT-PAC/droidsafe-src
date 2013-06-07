package droidsafe.eclipse.plugin.core.specmodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.speclang.Method;
import droidsafe.utils.SourceLocationTag;

/**
 * Class to model the droidsafe.speclang.Method class. It simplifies the method representation by
 * maintaining only the information relevant to display the method in the Eclipse interface.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class MethodModel extends ModelChangeSupport
    implements
      Comparable<MethodModel>,
      Serializable {
  private static final Logger logger = LoggerFactory.getLogger(MethodModel.class);
  private static final long serialVersionUID = -2110312802230745309L;
  private String methodName;
  private String className;
  private String returnType;
  private String methodSignature;
  private String sootMethodSignature;
  private SourceLocationTag declarationLocation;
  private List<CodeLocationModel> lines = new ArrayList<CodeLocationModel>();

  /**
   * Current status of the code location.
   */
  private DroidsafeIssueResolutionStatus status = DroidsafeIssueResolutionStatus.UNRESOLVED;


  public MethodModel(Method originalMethod) {
    this.methodName = originalMethod.getName();
    this.sootMethodSignature = originalMethod.getSignature();
    this.methodSignature = sootMethodSignature.substring(1, sootMethodSignature.length() - 1);
    this.className = originalMethod.getCname();
    this.returnType = originalMethod.getRtype();
    this.declarationLocation = originalMethod.getDeclSourceLocation();

    for (SourceLocationTag line : originalMethod.getLines()) {
      this.lines.add(new CodeLocationModel(line));
    }
    logger.debug("\n Method Signature {} \n Soot Signature {} \n Soot Sub Signature {}",
        new Object[] {methodSignature, sootMethodSignature, originalMethod.getSubSignature()});
  }

  public String getMethodName() {
    return methodName;
  }

  public String getClassName() {
    return className;
  }

  public String getReturnType() {
    return returnType;
  }

  public String getMethodSignature() {
    return methodSignature;
  }

  public String getSootMethodSignature() {
    return sootMethodSignature;
  }

  public String getSignature() {
    return methodSignature;
  }

  /**
   * Returns the lines that contain calls to this method
   */
  public List<CodeLocationModel> getLines() {
    return this.lines;
  }

  public SourceLocationTag getDeclSourceLocation() {
    return this.declarationLocation;
  }

  /**
   * Sets the value of the status field, and fires a property change event to notify the view. If
   * the current status is the same as the new status, no property change event is triggered.
   * 
   * @param newStatus the new value for the status of the entity.
   */
  public void setStatus(DroidsafeIssueResolutionStatus newStatus) {
    if (newStatus != getStatus()) {
      //logger.debug("Firing propertyChange event for "+this);
      firePropertyChange("status", this.status, this.status = newStatus);
    }
  }

  /**
   * Set the status of this code location to SAFE.
   */
  public void setSafe() {
    setStatus(DroidsafeIssueResolutionStatus.SAFE);
  }

  /**
   * Set the status of this code location to UNSAFE.
   */
  public void setUnsafe() {
    setStatus(DroidsafeIssueResolutionStatus.UNSAFE);
  }

  /**
   * Set the status of this code location to PENDING further decision on safety of issue.
   */
  public void setPending() {
    setStatus(DroidsafeIssueResolutionStatus.PENDING);
  }

  /**
   * Set the status of this code location to UNRESOLVED, meaning that the issue has not yet been
   * considered.
   */
  public void setUnresolved() {
    setStatus(DroidsafeIssueResolutionStatus.UNRESOLVED);
  }

  public DroidsafeIssueResolutionStatus getStatus() {
    return this.status;
  }

  /**
   * Returns true if the status of the location is safe.
   */
  public boolean isSafe() {
    return (this.status == DroidsafeIssueResolutionStatus.SAFE);
  }

  /**
   * Returns true if the status of the location is unsafe, false otherwise.
   */
  public boolean isUnsafe() {
    return (this.status == DroidsafeIssueResolutionStatus.UNSAFE);
  }

  /**
   * Returns true if the status of the location is unresolved, false otherwise.
   */
  public boolean isUnresolved() {
    return (this.status == DroidsafeIssueResolutionStatus.UNRESOLVED);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((lines == null) ? 0 : lines.hashCode());
    result = prime * result + ((methodSignature == null) ? 0 : methodSignature.hashCode());
    result = prime * result + ((declarationLocation == null) ? 0 : declarationLocation.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    MethodModel other = (MethodModel) obj;

    if (lines == null) {
      if (other.lines != null) return false;
    } else if (!lines.equals(other.lines)) return false;
    if (methodSignature == null) {
      if (other.methodSignature != null) return false;
    } else if (!methodSignature.equals(other.methodSignature)) return false;
    if (declarationLocation == null) {
      if (other.declarationLocation != null) return false;
    } else if (!declarationLocation.equals(other.declarationLocation)) return false;
    return true;
  }

  /** Sort by class and method name **/
  public int compareTo(MethodModel m) {
    // if both method have lines, then compare them on lines
    if (!this.lines.isEmpty() && !m.lines.isEmpty()) {
      return this.lines.get(0).compareTo(m.lines.get(0));
    }
    // otherwise, compare them on class name, methodname, and return type
    String str1 = this.className + " " + this.methodName + " " + this.returnType;
    String str2 = m.className + " " + m.methodName + " " + m.returnType;
    return str1.compareTo(str2);
  }


  public String printMethod() {
    StringBuffer sb = new StringBuffer("Droidsafe method ");
    sb.append(this.methodSignature);
    sb.append(" name ").append(methodName);
    sb.append(" class ").append(this.className);
    sb.append(" return type ").append(returnType);
    sb.append(" lines ").append(lines.size());
    return sb.toString();
  }

  public String toString() {
    return this.methodSignature;
  }
}
