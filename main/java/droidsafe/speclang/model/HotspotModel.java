package droidsafe.speclang.model;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ValueBox;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.analyses.strings.JSAStrings.Hotspot;

public class HotspotModel extends ModelChangeSupport implements Serializable {

  /**
   * Id for serialization.
   */
  private static final long serialVersionUID = -1886935776072935270L;

  /**
   * Standard logger.
   */
  @SuppressWarnings("unused")
  private static final Logger logger = LoggerFactory.getLogger(HotspotModel.class);

  /**
   * The soot method signature of the hotspot.
   */
  private String methodSignature;

  /**
   * The argument position for the object we want to analyze or have analyzed.
   */
  private int argumentPosition;

  /**
   * The class for the location where this string hotspot was called.
   */
  private String valueClass;

  /**
   * The source file for the location where this string hotspot was called.
   */
  private String valueSourceFile;

  /**
   * The number of the line for the location where this string hotspot was called.
   */
  private String valueSourceLine;

  /**
   * The regular expression computed by the string analysis for this location.
   */
  private String valueRegularExpression;

  /**
   * The method for the location where this string hotspot was called.
   */
  private String valueMethodName;


  /**
   * Main constructor.
   * 
   * @param originalHotspot The droidsafe original hotspot we want to model.
   * @param vb The soot value box location for which we have a regex computed.
   */
  public HotspotModel(Hotspot originalHotspot, ValueBox vb) {
    this.methodSignature = originalHotspot.getMethodSignature();
    this.argumentPosition = originalHotspot.getArgumentPosition();
    this.valueClass = JSAStrings.v().getClassName(vb);
    this.valueSourceFile = JSAStrings.v().getSourceFile(vb);
    this.valueSourceLine = JSAStrings.v().getSourceLine(vb);
    this.valueRegularExpression = JSAStrings.v().getRegex(vb.getValue());
    this.valueMethodName = JSAStrings.v().getMetodName(vb);
  }

  /**
   * Constructor used to add a hotspot from the user interface to be used during analysis.
   * 
   * @param methodModel The method for which we want to add as a hotspot.
   * @param argumentPosition The position of the argument in the list of method arguments. 0 is the
   *        first argument. -1 is used if we want to analyze the method return value.
   */
  public HotspotModel(MethodModel method, int argumentPosition) {
    this.methodSignature = method.getSootMethodSignature();
    this.argumentPosition = argumentPosition;
  }

  /**
   * @return the methodSignature
   */
  public String getMethodSignature() {
    return methodSignature;
  }


  /**
   * @return the argumentPosition
   */
  public int getArgumentPosition() {
    return argumentPosition;
  }


  /**
   * @return the valueClass
   */
  public String getValueClass() {
    return valueClass;
  }


  /**
   * @return the valueSourceFile
   */
  public String getValueSourceFile() {
    return valueSourceFile;
  }


  /**
   * @return the valueSourceLine
   */
  public String getValueSourceLine() {
    return valueSourceLine;
  }


  /**
   * @return the valueReguLarExpression
   */
  public String getValueRegularExpression() {
    return valueRegularExpression;
  }


  /**
   * @return the valueMethodName
   */
  public String getValueMethodName() {
    return valueMethodName;
  }

  public String toString() {
    return methodSignature + "[" + argumentPosition + "] = " + valueRegularExpression;
  }
}
