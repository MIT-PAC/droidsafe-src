package droidsafe.eclipse.plugin.core.specmodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootMethod;
import soot.Type;
import droidsafe.android.system.Permissions;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.speclang.ArgumentValue;
import droidsafe.speclang.ConcreteListArgumentValue;
import droidsafe.speclang.Method;
import droidsafe.utils.SourceLocationTag;

/**
 * Class to model the droidsafe.speclang.Method class. It simplifies the method representation by
 * maintaining only the information relevant to display the method in the Eclipse interface.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
/**
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class MethodModel extends ModelChangeSupport
    implements
      Comparable<MethodModel>,
      Serializable {

  /**
   * Standard logger.
   */
  @SuppressWarnings("unused")
  private static final Logger logger = LoggerFactory.getLogger(MethodModel.class);

  /**
   * Field needed for serialization.
   */
  private static final long serialVersionUID = -2110312802230745309L;

  /**
   * The string for the method name.
   */
  private String methodName;

  /**
   * The fully qualified class name where the method is defined.
   */
  private String className;

  /**
   * The type of value returned by this method.
   */
  private String returnType;

  /**
   * The full method signature.
   */
  private String methodSignature;

  /**
   * The full method signature surrounded by angle brackets.
   */
  private String sootMethodSignature;

  /**
   * The list of arguments for this method. Only the string representing the type or class of the
   * arguments are stored.
   */
  private List<String> methodArgumentTypes = new ArrayList<String>();

  /**
   * List of computed values for method's parameters.
   */
  private List<String> methodArgumentValues = new ArrayList<String>();


  /**
   * The source code location where the method is defined or called.
   */
  private SourceLocationTag declarationLocation;

  /**
   * The lines where this method is called.
   */
  private List<CodeLocationModel> lines = new ArrayList<CodeLocationModel>();

  /**
   * Current status of the method set by the analyst.
   */
  private DroidsafeIssueResolutionStatus status = DroidsafeIssueResolutionStatus.UNRESOLVED;

  /**
   * The short signature of the method with parameter classes replaced by concrete values if
   * available.
   */
  private String methodShortSignature;

  /**
   * Set of permissions a method may need at runtime.
   */
  private Set<String> permissions;

  /**
   * The receiver of the method call.
   */
  private String receiver;



  /**
   * Main constructor.
   * 
   * @param originalMethod The droidsafe method we are modeling.
   */
  public MethodModel(Method originalMethod) {
    this.methodName = originalMethod.getName();
    this.sootMethodSignature = originalMethod.getSignature();
    this.methodSignature = sootMethodSignature.substring(1, sootMethodSignature.length() - 1);
    this.className = originalMethod.getCname();
    this.returnType = originalMethod.getRtype();
    this.declarationLocation = originalMethod.getDeclSourceLocation();
    this.methodShortSignature = computeShortSignature(originalMethod);
    this.permissions = Permissions.v().getPermissions(originalMethod.getSootMethod());
    if (originalMethod.hasReceiver()) {
      Object receiver = originalMethod.getReceiver();
      if (receiver instanceof ConcreteListArgumentValue){
      this.receiver = receiver.toString();
      }
    }
    for (SourceLocationTag line : originalMethod.getLines()) {
      this.lines.add(new CodeLocationModel(line));
    }

    // logger.debug("\n");
    SootMethod sootMethod = originalMethod.getSootMethod();
    for (Type parType : sootMethod.getParameterTypes()) {
      this.methodArgumentTypes.add(parType.toString());
      // logger.debug("Argument for soot method {} is {}", new Object[] {methodSignature,
      // parType.toString()});
    }

    List<ArgumentValue> arguments = Arrays.asList(originalMethod.getArgs());
    for (ArgumentValue arg : arguments) {
      String argValue = arg.toString();
      this.methodArgumentValues.add(argValue);
      // logger.debug("Argument for method {} is {}", new Object[] {methodSignature, argValue});
    }
    // if (originalMethod.getReceiver() != null) {
    // Object receiver = originalMethod.getReceiver();
    // logger.debug("Receiver for method {}", originalMethod.getReceiver().getClass());
    // }
  }

  /**
   * Method name getter. Returns only the method name, and not the method signature that includes
   * the return type, the arguments, and the class where the method is defined.
   * 
   * @return The method name.
   */
  public String getMethodName() {
    return methodName;
  }


  /**
   * Getter for method class.
   * 
   * @return The fully qualified name of the class where the method is defined.
   */
  public String getClassName() {
    return className;
  }

  /**
   * Getter for method return type.
   * 
   * @return The class of the value returned by the method.
   */
  public String getReturnType() {
    return returnType;
  }

  /**
   * Getter for the method soot signature. The method soot signature is the method signature
   * surrounded by angled brackets.
   * 
   * Example output: <java.lang.StringBuilder append(java.lang.String)>
   * 
   * @return The string containing the full signature of the method.
   */
  public String getSootMethodSignature() {
    return sootMethodSignature;
  }

  /**
   * Getter for the method signature. Returns a string with the following elements: <MethodClass>
   * <MethodReturnValue> <MethodName> (<MethodParameterClasses>). Example output:
   * java.lang.StringBuilder append(java.lang.String)
   * 
   * @return The string containing the full signature of the method.
   */
  public String getSignature() {
    return methodSignature;

  }

  /**
   * Getter for the method short signature. Returns a string with the following elements:
   * <UnqualifiedMethodClass> <UnqualifiedMethodReturnValue> <MethodName>
   * (<UnqualifiefMethodParameterClasses or ParameterValue>). Example output:
   * java.lang.StringBuilder append("this string")
   * 
   * @return The string containing the short or simplified signature of the method.
   */
  public String getShortSignature() {
    return this.methodShortSignature;
  }


  /**
   * Getter for the set of permissions needed to run this method at run time.
   * 
   * @return The set of permissions for this method.
   */
  public Set<String> getPermissions() {
    return this.permissions;
  }


  /**
   * @return the receiver object string representation.
   */
  public String getReceiver() {
    return this.receiver;
  }

  /**
   * Returns a simple text version of the short signature (one with unqualified classnames and
   * constant values
   */
  private String computeShortSignature(Method m) {
    StringBuffer out = new StringBuffer();
    out.append(DroidsafePluginUtilities.extractClassname(getClassName()) + " " + getMethodName()
        + " (");
    String delim = "";
    for (ArgumentValue arg : m.getArgs()) {
      out.append(delim);
      if (arg.isType()) {
        out.append(DroidsafePluginUtilities.extractClassname(arg.toString()));
      } else { // constant of some sort
        out.append(arg.toString());
      }
      delim = ", ";
    }

    return out.append(")").toString();
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
      // logger.debug("Firing propertyChange event for "+this);
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

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((lines == null) ? 0 : lines.hashCode());
    result = prime * result + ((methodSignature == null) ? 0 : methodSignature.hashCode());
    result = prime * result + ((declarationLocation == null) ? 0 : declarationLocation.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
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


  /**
   * @return A string with all elements of the method. Used mainly for debug purposed since we want
   *         the toString method to return the method signature.
   */
  public String printMethod() {
    StringBuffer sb = new StringBuffer("Droidsafe method ");
    sb.append(this.methodSignature);
    sb.append(" name ").append(methodName);
    sb.append(" class ").append(this.className);
    sb.append(" return type ").append(returnType);
    sb.append(" lines ").append(lines.size());
    return sb.toString();
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  public String toString() {
    return this.methodShortSignature;
  }

  /**
   * Returns the list of argument types for method.
   * 
   * @return
   */
  public List<String> getMethodArguments() {
    return methodArgumentTypes;
  }
}
