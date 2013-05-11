package droidsafe.eclipse.plugin.core.specmodel;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.speclang.Method;
import droidsafe.utils.SourceLocationTag;

/**
 * Class to model the droidsafe.speclang.Method class. It simplifies the method representation by
 * maintaining only the information relevant to display the method in the Eclipse interface.
 */
public class DroidsafeMethodModel implements Comparable<DroidsafeMethodModel>, Serializable {
  private static final Logger logger = LoggerFactory.getLogger(DroidsafeMethodModel.class);
  private static final long serialVersionUID = -2110312802230745309L;
  private String methodName;
  private String className;
  private String returnType;
  private String methodSignature;
  private String sootMethodSignature;
  private SourceLocationTag declarationLocation;
  private List<SourceLocationTag> lines;

  public DroidsafeMethodModel(Method originalMethod) {
    this.methodName = originalMethod.getName();
    // this.methodSignature = originalMethod.toSignatureString();
    this.sootMethodSignature = originalMethod.getSignature();
    this.methodSignature = sootMethodSignature.substring(1, sootMethodSignature.length() - 1);
    this.lines = originalMethod.getLines();
    this.className = originalMethod.getCname();
    this.returnType = originalMethod.getRtype();
    this.declarationLocation = originalMethod.getDeclSourceLocation();
    logger.warn("\n Method Signature {} \n Soot Signature {} \n Soot Sub Signature {}",
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
  public List<SourceLocationTag> getLines() {
    return this.lines;
  }

  public SourceLocationTag getDeclSourceLocation() {
    return this.declarationLocation;
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
    DroidsafeMethodModel other = (DroidsafeMethodModel) obj;

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
  public int compareTo(DroidsafeMethodModel m) {
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
