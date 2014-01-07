package droidsafe.speclang.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootMethod;
import soot.Type;
import soot.jimple.Stmt;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.infoflow.InfoKind;
import droidsafe.android.system.Permissions;
import droidsafe.speclang.ArgumentValue;
import droidsafe.speclang.ConcreteListArgumentValue;
import droidsafe.speclang.Method;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;
import droidsafe.utils.Utils;

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
  private List<String> methodArgumentValues;

  /**
   * List of list of lines for new expressions that could reach the method's arguments.
   */
  private List<List<AllocLocationModel>> methodArgumentAllocSources;

  /**
   * List of list of lines for new expressions that could reach the method's arguments.
   */
  private List<List<CallLocationModel>> methodArgumentSourceInfoUnits;

  /**
   * List of high-level information kinds that the the method's arguments could possibly be 
   * tainted with.
   */
  private List<List<String>> methodArgumentInfoKinds;

  /**
   * The source code location where the method is defined or called.
   */
  private SourceLocationTag declarationLocation;

  /**
   * The lines where this method is called.
   */
  private List<CodeLocationModel> lines = new ArrayList<CodeLocationModel>();

  /**
   * List of sink info kinds if the method is a sink method with a high level sink type.
   * Empty list otherwise.
   */
  private List<String> sinkInfoKinds;

  /**
   * Current status of the method set by the analyst.
   */
  private DroidsafeIssueResolutionStatus status = DroidsafeIssueResolutionStatus.UNSAFE;

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
   * The computed value of the receiver of this method call.
   */
  private String receiverValue = "";

  /**
   * The type of the receiver of this method call.
   */
  private String receiverType;

  /**
   * The list of lines for new expressions that could reach the receiver of this method.
   */
  private List<AllocLocationModel> receiverAllocSources;

  /**
   * The list of all api calls in user code that could reach the receiver (or one of its fields).
   */
  private List<CallLocationModel> receiverSourceInfoUnits;

  /**
   * The list of high-level information kinds that the receiver could possibly be 
   * tainted with.
   */
  private List<String> receiverInfoKinds;

  /**
   * If the method is native or not
   */
  private boolean isNative = false;

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
    this.isNative = originalMethod.getSootMethod().isNative();
    this.permissions = Permissions.v().getPermissions(originalMethod.getSootMethod());
    if (originalMethod.hasReceiver()) {
      ArgumentValue receiver = originalMethod.getReceiverValues();
      if (receiver instanceof ConcreteListArgumentValue) {
          this.receiverValue = ((ConcreteListArgumentValue) receiver).toStringPretty().toString();
      }
      this.receiverType = originalMethod.getSootMethod().getDeclaringClass().getName();
      setReceiverAllocSources(originalMethod);
      setReceiverInfoKinds(originalMethod);
      setReceiverSourceInfoUnits(originalMethod);
    }
    for (SourceLocationTag line : originalMethod.getLines()) {
      this.lines.add(new CodeLocationModel(line));
    }
    if (!originalMethod.getSinkInfoKinds().isEmpty())
      this.sinkInfoKinds = new ArrayList<String>();
      for (InfoKind infoKind : originalMethod.getSinkInfoKinds()) {
        this.sinkInfoKinds.add(infoKind.toString());
      }

    logger.debug("\n" + this.sootMethodSignature);
    SootMethod sootMethod = originalMethod.getSootMethod();
    for (Type parType : sootMethod.getParameterTypes()) {
      this.methodArgumentTypes.add(parType.toString());
    }

    if (originalMethod.getArgs().length > 0) {
      setArgumentValues(originalMethod);
      setArgumentAllocSources(originalMethod);
      setArgumentInfoKinds(originalMethod);
      setArgumentSourceInfoUnits(originalMethod);
    }
  }

  /**
   * Compute and set the field methodArgumentSourceInfoUnits.
   */
  private void setArgumentSourceInfoUnits(Method originalMethod) {
    boolean hasInfo = false;
    methodArgumentSourceInfoUnits = new ArrayList<List<CallLocationModel>>();
    for (int i = 0; i < originalMethod.getArgs().length; i++) {
      Set<Stmt> stmts = originalMethod.getArgSourceInfoUnits(i);
      List<CallLocationModel> argSourceInfoUnits = null;
      if (!stmts.isEmpty()) {
        argSourceInfoUnits = new ArrayList<CallLocationModel>();
        for (Stmt stmt : stmts) {
            CallLocationModel line = CallLocationModel.get(stmt);
            if (line != null) {
                argSourceInfoUnits.add(line);
                hasInfo = true;
            }
        }
        Collections.sort(argSourceInfoUnits);
      }
      methodArgumentSourceInfoUnits.add(argSourceInfoUnits);
    }
    if (!hasInfo)
      methodArgumentSourceInfoUnits = null;
  }

  /**
   * Compute and set the field methodArgumentInfoKinds.
   */
  private void setArgumentInfoKinds(Method originalMethod) {
    boolean hasInfo = false;
    methodArgumentInfoKinds = new ArrayList<List<String>>();
    for (int i = 0; i < originalMethod.getArgs().length; i++) {
      Set<InfoKind> infoKinds = originalMethod.getArgInfoKinds(i);
      List<String> argInfoKinds = null;
      if (!infoKinds.isEmpty()) {
        hasInfo = true;
        argInfoKinds = new ArrayList<String>();
        for (InfoKind infoKind : originalMethod.getArgInfoKinds(i)) {
          argInfoKinds.add(infoKind.toString());
        }
        Collections.sort(argInfoKinds);
      }
      methodArgumentInfoKinds.add(argInfoKinds);
    }
    if (!hasInfo)
      methodArgumentInfoKinds = null;
  }


  /**
   * Compute and set the field methodArgumentValues.
   */
  private void setArgumentValues(Method originalMethod) {
    boolean hasInfo = false;
    methodArgumentValues = new ArrayList<String>();
    for (ArgumentValue arg : originalMethod.getArgs()) {
      String argValue = null;
      if (arg instanceof ConcreteListArgumentValue) {
        hasInfo = true;
        argValue = ((ConcreteListArgumentValue) arg).toStringPretty();
      }
      methodArgumentValues.add(argValue);
    }
    if (!hasInfo)
      methodArgumentValues = null;
  }

  /**
   * Compute and set the field methodArgumentAllocSources.
   */
  private void setArgumentAllocSources(Method originalMethod) {
    boolean hasInfo = false;
    methodArgumentAllocSources = new ArrayList<List<AllocLocationModel>>();
    for (int i = 0; i < originalMethod.getArgs().length; i++) {
      Set<? extends IAllocNode> nodes = originalMethod.getArgAllocNodes(i);
      List<AllocLocationModel> argSources = null;
      if (!nodes.isEmpty()) {
        argSources = new ArrayList<AllocLocationModel>();
        for (IAllocNode node : nodes) {
          AllocLocationModel line = AllocLocationModel.get(node);
          if (line != null) argSources.add(line);
        }
        if (!argSources.isEmpty()) {
          hasInfo = true;
          Collections.sort(argSources);
        } else {
          argSources = null;
        }
      }
      methodArgumentAllocSources.add(argSources);
    }
    if (!hasInfo)
      methodArgumentAllocSources = null;
  }

  /**
   * Compute and set the field receiverSourceInfoUnits.
   */
  private void setReceiverSourceInfoUnits(Method originalMethod) {
    boolean hasInfo = false;
    Set<Stmt> stmts = originalMethod.getReceiverSourceInfoUnits();
    if (!stmts.isEmpty()) {
      receiverSourceInfoUnits = new ArrayList<CallLocationModel>();
      for (Stmt stmt : stmts) {
        CallLocationModel line = CallLocationModel.get(stmt);
        if (line != null) {
          hasInfo = true;
          receiverSourceInfoUnits.add(line);
        }
      }
      Collections.sort(receiverSourceInfoUnits);
    }
    if (!hasInfo)
      receiverSourceInfoUnits = null;
  }

  /**
   * Compute and set the field receiverInfoKinds.
   */
  private void setReceiverInfoKinds(Method originalMethod) {
    Set<InfoKind> infoKinds = originalMethod.getRecInfoKinds();
    if (!infoKinds.isEmpty()) {
      receiverInfoKinds = new ArrayList<String>();
      for (InfoKind infoKind : infoKinds) {
        receiverInfoKinds.add(infoKind.toString());
      }
      Collections.sort(receiverInfoKinds);
    }
   }

  /**
   * Compute and set the field receiverAllocSources.
   */
  private void setReceiverAllocSources(Method originalMethod) {
    Set<? extends IAllocNode> allocNodes = originalMethod.getReceiverAllocNodes();
    if (!allocNodes.isEmpty()) {
      receiverAllocSources = new ArrayList<AllocLocationModel>();
      for (IAllocNode allocNode : allocNodes) {
        AllocLocationModel line = AllocLocationModel.get(allocNode);
        if (line != null) receiverAllocSources.add(line);
      }
      if (!receiverAllocSources.isEmpty()) {
        Collections.sort(receiverAllocSources);
      } else {
        receiverAllocSources = null;
      }
    }
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
  public String getReceiverValue() {
    return this.receiverValue;
  }

  /**
   * Returns a simple text version of the short signature (one with unqualified classnames and
   * constant values
   */
  private String computeShortSignature(Method m) {
    StringBuffer out = new StringBuffer();
    out.append(Utils.extractClassname(getClassName()) + " " + getMethodName() + " (");
    String delim = "";
    
    for (int i = 0; i < m.getArgs().length; i++) {
      Type argType = m.getActualArgType(i);
      out.append(delim);
      out.append(Utils.extractClassname(argType.toString()));
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
   * If this method is defined as a sink method with a high level sink type, 
   * return the InfoKinds of this method.  Otherwise, return an empty list. 
   */
  public List<String> getSinkInfoKinds() {
      return sinkInfoKinds;
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

  /**
   * Returns true if the method is native.
   */
  public boolean isNative() {
    return this.isNative;
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
    if ((methodArgumentValues == null) != (other.methodArgumentValues == null)) {
        return false;
    } else if (methodArgumentValues != null) {
        if (!methodArgumentValues.toString().equals(other.methodArgumentValues.toString()))
            return false;
    }
    if (declarationLocation == null) {
      if (other.declarationLocation != null) return false;
    } else if (!declarationLocation.equals(other.declarationLocation)) return false;
    if (!receiverValue.equals(other.receiverValue)) return false;
    return true;
  }

  /** Sort by class and method name **/
  public int compareTo(MethodModel m) {
    // if both method have lines, then compare them on lines
    // if (!this.lines.isEmpty() && !m.lines.isEmpty()) {
    // return this.lines.get(0).compareTo(m.lines.get(0));
    // }
    // // otherwise, compare them on class name, methodname, and return type
    // String str1 = this.className + " " + this.methodName + " " + this.returnType;
    // String str2 = m.className + " " + m.methodName + " " + m.returnType;
    // return str1.compareTo(str2);

    int result = this.getSignature().compareTo(m.getSignature());
    if (result == 0) {
      result = this.receiverValue.compareTo(m.getReceiverValue());
    }
    if (result == 0) {
      if (this.getDeclSourceLocation() != null && m.getDeclSourceLocation() != null) {
        result = this.getDeclSourceLocation().compareTo(m.getDeclSourceLocation());
      }
    }
    if (result == 0) {
      result = Integer.compare(this.getLines().size(), m.getLines().size());
    }
    if (result == 0) {
      for (int i = 0; i < this.getLines().size(); i++) {
        result = this.lines.get(i).compareTo(m.lines.get(i));
        if (result != 0) {
          return result;
        }
      }
    }
    if (result == 0)
        if (methodArgumentValues == null) {
            if (m.methodArgumentValues != null)
                result = 1;
        } else {
            if (m.methodArgumentValues == null) {
                result = -1;
            } else {
                result = methodArgumentValues.toString().compareTo(m.methodArgumentValues.toString());
            }
        }
    return result;
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

  /**
   * Returns computed value for the method's ith arguments.
   * 
   * @return
   */
  public String getArgumentValue(int i) {
    if (methodArgumentValues == null)
      return null;
    return methodArgumentValues.get(i);
  }

  /**
   * Returns the list of lines for new expressions that could reach the method's receiver (i = -1)
   * or the ith arguments.
   * 
   * @return
   */
  public List<AllocLocationModel> getArgumentAllocSources(int i) {
    if (i == -1) 
      return receiverAllocSources;
    if (methodArgumentAllocSources == null)
        return null;
      return methodArgumentAllocSources.get(i);
    }

  /**
   * Returns the list of all api calls in user code that could reach the receiver (i = -1)
   * or the ith argument.
   */
  public List<CallLocationModel> getArgumentSourceInfoUnits(int i) {
    if (i == -1)
      return receiverSourceInfoUnits;
    if (methodArgumentSourceInfoUnits == null)
      return null;
    return methodArgumentSourceInfoUnits.get(i);
  }
  
  /**
   * Returns the list of high level information kinds that the receiver (i = -1) or the ith argument
   * could possibly be tainted with.
   */
  public List<String> getArgumentInfoKinds(int i) {
    if (i == -1)
      return receiverInfoKinds;
    if (methodArgumentInfoKinds == null)
      return null;
    return methodArgumentInfoKinds.get(i);
  }

  /**
   * Cached method argument model for the receiver of this method.
   */
  private transient MethodArgumentModel receiverModel;
  
  /**
   * Cached method argument models for the arguments of this method.
   */
  private transient MethodArgumentModel[] argumentModels;
  
  /**
   * Returns the MethodArgumentModel for the receiver (i = -1) or the ith (i >=0) argument of this method.
   */
  public MethodArgumentModel getArgumentModel(int i) {
    if (i == -1) {
      if (receiverModel == null)
        receiverModel = new MethodArgumentModel(this, -1);
      return receiverModel;
    }
    if (argumentModels == null) {
      argumentModels = new MethodArgumentModel[methodArgumentTypes.size()];
    }
    if (argumentModels[i] == null) {
      argumentModels[i] = new MethodArgumentModel(this, i);
    }
    return argumentModels[i];
  }
  
  /**
   * Returns true if there are computed values info on one of the method arguments.
   */
  public boolean hasValueInfo() {
    return !receiverValue.equals("") || methodArgumentValues != null;
  }

  /**
   * Returns true if there is points-to info on the receiver or one of the method arguments.
   */
  public boolean hasPointsToInfo() {
    return receiverAllocSources != null || methodArgumentAllocSources != null;
  }

  /**
   * Returns true if there is high level sink/source info on the method.
   */
  public boolean hasInfoFlowInfo() {
    return hasHighLevelInfoFlowInfo() || hasLowLevelInfoFlowInfo();
  }

  /**
   * Returns true if there is high level sink/source info on the method.
   */
  public boolean hasHighLevelInfoFlowInfo() {
    return receiverInfoKinds != null || methodArgumentInfoKinds != null || sinkInfoKinds != null;
  }

  /**
   * Returns true if there is low level info flow info on the receiver or one of the method arguments .
   */
  public boolean hasLowLevelInfoFlowInfo() {
    return receiverSourceInfoUnits != null || methodArgumentSourceInfoUnits != null;
  }

  public String getReceiverType() {
    return receiverType;
  }

}
