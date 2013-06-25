/**
 * 
 */
package droidsafe.eclipse.plugin.core.specmodel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ValueBox;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.analyses.strings.JSAStrings.Hotspot;
import droidsafe.android.app.Project;
import droidsafe.speclang.Method;
import droidsafe.speclang.SecuritySpecification;

/**
 * This is a wrapper class around the droidsafe.speclang.SecuritySpecification class. This class
 * provides a model of the spec that can be used by the Eclipse outline view, and simplifies the
 * serialization of the spec representation to be used by this view.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class SecuritySpecModel extends ModelChangeSupport
    implements
      Serializable,
      PropertyChangeListener {
  /**
   * The generated serial version ID.
   */
  private static final long serialVersionUID = -2836030244594131144L;

  /**
   * The logger object for this class.
   */
  @SuppressWarnings("unused")
  private static final Logger logger = LoggerFactory.getLogger(SecuritySpecModel.class);

  /**
   * The name of the file to use to save the serialized version of the spec.
   */
  public static final String SECURITY_SPEC_SERIAL_FILE_NAME = "security_spec.ser";

  /**
   * The path to location of the Android project root folder. We need this information to serialize
   * the spec.
   */
  private String projectRootPath;

  /**
   * Set of methods that are considered safe.
   */
  private Set<MethodModel> whitelist = new LinkedHashSet<MethodModel>();

  /**
   * eventBlocks contains the default security spec hierarchy -- output events map to a list of
   * input events, or APIs, and each API entry maps to a number of source code locations. In this
   * map, the top most parents are the input events.
   * 
   */
  private Map<MethodModel, List<MethodModel>> inputEventBlocks =
      new LinkedHashMap<MethodModel, List<MethodModel>>();


  /**
   * This map contains the same information as the eventBlocks above but in a different
   * organization. This map maps outputEvents to input events, and each intput event to the list of
   * lines in which the parent outputEvent is present. This map is used to display a hierarchical
   * view of the spec rooted at the API nodes.
   */
  private transient Map<MethodModel, Map<MethodModel, List<CodeLocationModel>>> outputEventBlocks =
      new LinkedHashMap<MethodModel, Map<MethodModel, List<CodeLocationModel>>>();



  /**
   * This map contains the same information as the eventBlocks above but in a different
   * organization. This map maps code locations to lists of input events, and each input event to
   * the list of output events in which the parent code location is present. This map is used to
   * display a hierarchical view of the spec rooted at the code location nodes.
   */
  private transient Map<CodeLocationModel, Map<MethodModel, List<MethodModel>>> codeLocationEventBlocks =
      new LinkedHashMap<CodeLocationModel, Map<MethodModel, List<MethodModel>>>();


  /**
   * Map from method soot signature to hotspots.
   */
  Map<String, List<HotspotModel>> methodToHotspotMap = new HashMap<String, List<HotspotModel>>();


  /**
   * Main constructor for the spec model. Translate the original droidsafe spec into a simpler
   * representation that can be used by the eclipse plugin.
   * 
   * @param originalSpec The droidsafe security spec we want to represent in this model.
   */
  public SecuritySpecModel(SecuritySpecification originalSpec, String projectPath) {
    this.projectRootPath = projectPath;
    translateModel(originalSpec);
  }

  public Set<MethodModel> getWhitelist() {
    return this.whitelist;
  }

  public Set<MethodModel> getEntryPoints() {
    return this.inputEventBlocks.keySet();
  }

  public List<MethodModel> getOutputEvents(MethodModel method) {
    return this.inputEventBlocks.get(method);
  }


  public Map<String, List<HotspotModel>> getHotspotMap() {
    return this.methodToHotspotMap;
  }

  /**
   * Auxiliary method to add all previously computed hotspots to the spec.
   * 
   * @param signatureToHotspotMap A map from soot method signature to a list of soot value boxes.
   */
  private void addHotspotsToSpec(Map<String, List<Hotspot>> signatureToHotspotMap) {
    for (String sig : signatureToHotspotMap.keySet()) {
      for (Hotspot hot : signatureToHotspotMap.get(sig)) {
        for (ValueBox vb : hot.getHotspots()) {
          HotspotModel model = new HotspotModel(hot, vb);
          addHotspotToSpec(sig, model);
        }
      }
    }
  }


  private void addHotspotToSpec(String sig, HotspotModel model) {
    List<HotspotModel> hotspotList = this.methodToHotspotMap.get(sig);
    if (hotspotList == null) {
      hotspotList = new ArrayList<HotspotModel>();
      this.methodToHotspotMap.put(sig, hotspotList);
    }
    hotspotList.add(model);
  }

  public void addHotspot(MethodModel method, int argPosition) {
    addHotspotToSpec(method.getSootMethodSignature(), new HotspotModel(method, argPosition));
    serializeSpecToFile(this, this.projectRootPath);
  }


  public void removeHotspot(MethodModel method) {
    this.methodToHotspotMap.remove(method);
    serializeSpecToFile(this, this.projectRootPath);
  }



  private void translateModel(SecuritySpecification originalSpec) {
    for (Method m : originalSpec.getWhitelist()) {
      MethodModel model = new MethodModel(m);
      this.whitelist.add(model);
      model.addPropertyChangeListener(this);
    }
    Map<String, List<Hotspot>> signatureToHotspotMap = JSAStrings.v().getSignatureToHotspotMap();
    addHotspotsToSpec(signatureToHotspotMap);

    for (Map.Entry<Method, List<Method>> entry : originalSpec.getEventBlocks().entrySet()) {
      Method inputEvent = entry.getKey();
      List<Method> outputEvents = entry.getValue();
      ArrayList<MethodModel> modelOutputEvents = new ArrayList<MethodModel>();
      MethodModel model = new MethodModel(inputEvent);
      if (this.inputEventBlocks.get(model) != null) {
        logger.debug("Method {} already in event blocks", model);
      }
      this.inputEventBlocks.put(model, modelOutputEvents);
      model.addPropertyChangeListener(this);

      List<HotspotModel> hotspots = this.methodToHotspotMap.get(model.getSootMethodSignature());
      if (hotspots != null) {
        logger.debug("Hotspot for method {} is in map", model);
        for (HotspotModel hot : hotspots) {
          logger
              .debug(
                  "String analysis \nSignature {}\nArgument Position {}\nClass {} \nSource File {} \nMethodName {} \nSource Line {} \nRegex {}\n",
                  new Object[] {hot.getMethodSignature(), hot.getArgumentPosition(),
                      hot.getValueClass(), hot.getValueSourceFile(), hot.getValueMethodName(),
                      hot.getValueSourceLine(), hot.getValueRegularExpression()});
        }
      }

      for (Method outputEvent : outputEvents) {
        MethodModel methodModel = new MethodModel(outputEvent);
        modelOutputEvents.add(methodModel);
        methodModel.addPropertyChangeListener(this);
        List<HotspotModel> apiHotspots =
            this.methodToHotspotMap.get(methodModel.getSootMethodSignature());

        if (apiHotspots != null) {
          logger.debug("Hotspot for method {} is in map", methodModel);
          for (HotspotModel hot : apiHotspots) {
            logger
                .debug(
                    "String analysis \nSignature {}\nArgument Position {}\nClass {} \nSource File {} \nMethodName {} \nSource Line {} \nRegex {}\n",
                    new Object[] {hot.getMethodSignature(), hot.getArgumentPosition(),
                        hot.getValueClass(), hot.getValueSourceFile(), hot.getValueMethodName(),
                        hot.getValueSourceLine(), hot.getValueRegularExpression()});
          }
        }

        for (CodeLocationModel line : methodModel.getLines()) {
          line.addPropertyChangeListener(this);
          if (apiHotspots != null) {
            logger.debug("Hotspot for method {} is in map", methodModel);
            for (HotspotModel hot : apiHotspots) {
              if (line.getClz().equals(hot.getValueClass())
                  && line.getLine() == Integer.parseInt(hot.getValueSourceLine())) {
                line.addHotspot(hot);
              }
            }
          }
        }
      }
      Collections.sort(modelOutputEvents);
      // logger.debug("Input Method {}", inputEvent);
      // logger.debug(" \n Number of Output Events in original method {}",
      // Integer.toString(outputEvents.size()));
      // logger.debug("\n Number of Events in modelEvents {}",
      // Integer.toString(modelOutputEvents.size()));
    }
    // logger.debug("{}", printSpecModel());
  }

  public String printSpecModel() {
    StringBuffer sb = new StringBuffer("Droidsafe Spec Model");
    sb.append("\nWhitelist\n");
    for (MethodModel m : this.whitelist) {
      sb.append(m.printMethod()).append("\n");
    }
    for (MethodModel im : inputEventBlocks.keySet()) {
      sb.append("InputMethod ").append(im.toString()).append("\n");
      for (MethodModel om : inputEventBlocks.get(im)) {
        sb.append("    OutputMethod ").append(om.printMethod()).append("\n");
      }
    }
    return sb.toString();
  }


  /**
   * Creates a map from output events (API calls) to entry points (input events) to code locations.
   */
  private void computeOutputEventBlocks() {
    if (this.outputEventBlocks == null) {
      this.outputEventBlocks =
          new LinkedHashMap<MethodModel, Map<MethodModel, List<CodeLocationModel>>>();
    }
    for (MethodModel inputEvent : inputEventBlocks.keySet()) {
      if (inputEventBlocks.get(inputEvent) != null) {
        for (MethodModel outputEvent : inputEventBlocks.get(inputEvent)) {
          Map<MethodModel, List<CodeLocationModel>> outputEventMap =
              this.outputEventBlocks.get(outputEvent);
          if (outputEventMap == null) {
            outputEventMap = new LinkedHashMap<MethodModel, List<CodeLocationModel>>();
            this.outputEventBlocks.put(outputEvent, outputEventMap);
          }
          outputEventMap.put(inputEvent, outputEvent.getLines());
        }
      }
    }
  }

  /**
   * Creates a map from code location to entry points (input events) to to output events (API
   * calls).
   */
  private void computeCodeLocationEventBlocks() {
    if (this.codeLocationEventBlocks == null) {
      this.codeLocationEventBlocks =
          new LinkedHashMap<CodeLocationModel, Map<MethodModel, List<MethodModel>>>();
    }
    for (MethodModel inputEvent : inputEventBlocks.keySet()) {
      if (inputEventBlocks.get(inputEvent) != null) {
        for (MethodModel outputEvent : inputEventBlocks.get(inputEvent)) {
          List<CodeLocationModel> lines = outputEvent.getLines();
          if (lines != null) {
            for (CodeLocationModel line : lines) {
              Map<MethodModel, List<MethodModel>> lineEventMap =
                  this.codeLocationEventBlocks.get(line);
              if (lineEventMap == null) {
                lineEventMap = new LinkedHashMap<MethodModel, List<MethodModel>>();
                this.codeLocationEventBlocks.put(line, lineEventMap);
              }
              List<MethodModel> outputMethods = lineEventMap.get(inputEvent);
              if (outputMethods == null) {
                outputMethods = new ArrayList<MethodModel>();
                lineEventMap.put(inputEvent, outputMethods);
              }
              outputMethods.add(outputEvent);
            }
          }
        }
      }
    }
  }

  public Map<MethodModel, List<MethodModel>> getInputEventBlocks() {
    return this.inputEventBlocks;
  }

  public Map<MethodModel, Map<MethodModel, List<CodeLocationModel>>> getOutputEventBlocks() {
    if (this.outputEventBlocks == null || this.outputEventBlocks.isEmpty()) {
      computeOutputEventBlocks();
    }
    return this.outputEventBlocks;
  }

  public Map<CodeLocationModel, Map<MethodModel, List<MethodModel>>> getCodeLocationEventBlocks() {
    if (this.codeLocationEventBlocks == null || this.codeLocationEventBlocks.isEmpty()) {
      computeCodeLocationEventBlocks();
    }
    return this.codeLocationEventBlocks;
  }

  /**
   * Serializes the current version of the spec to a file in the droidsafe folder of the current
   * selected Android app.
   * 
   * @param spec The security specification model.
   * @param androidProjectRootPath The root of the Android App Eclipse project.
   * @return
   */
  public static boolean serializeSpecToFile(SecuritySpecModel spec, String androidProjectRootPath) {
    boolean saved = false;
    String fileName =
        androidProjectRootPath + File.separator + Project.OUTPUT_DIR + File.separator
            + SECURITY_SPEC_SERIAL_FILE_NAME;
    try {
      ObjectOutputStream oos =
          new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
      try {
        oos.writeObject(spec);
        saved = true;
      } finally {
        oos.close();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return saved;
  }

  /**
   * Reads the serialized version of the security specification from a file and creates a spec
   * model.
   * 
   * @param androidProjectRootPath The root location of the Android Eclipse project.
   * @return The security specification for the Android application.
   */
  public static SecuritySpecModel deserializeSpecFromFile(String androidProjectRootPath) {
    SecuritySpecModel spec = null;
    String fileName =
        androidProjectRootPath + File.separator + Project.OUTPUT_DIR + File.separator
            + SECURITY_SPEC_SERIAL_FILE_NAME;
    File file = new File(fileName);
    if (file.exists()) {
      try {
        ObjectInputStream ois =
            new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
          Object obj = ois.readObject();
          if (obj instanceof SecuritySpecModel) {
            spec = (SecuritySpecModel) obj;
          }
        } finally {
          ois.close();
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      // if (spec != null) {
      // logger.debug("{}", spec.printSpecModel());
      // }
    }
    return spec;
  }

  /**
   * Saves the state of the specification model every time something changes in the model.
   */
  @Override
  public void propertyChange(PropertyChangeEvent event) {
    serializeSpecToFile(this, this.projectRootPath);
  }

}
