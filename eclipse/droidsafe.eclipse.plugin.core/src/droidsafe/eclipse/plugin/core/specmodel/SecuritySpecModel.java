/**
 * 
 */
package droidsafe.eclipse.plugin.core.specmodel;

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
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class SecuritySpecModel implements Serializable {
  /**
   * The generated serial version ID.
   */
  private static final long serialVersionUID = -2836030244594131144L;

  /**
   * The logger object for this class.
   */
  private static final Logger logger = LoggerFactory.getLogger(SecuritySpecModel.class);

  /**
   * The name of the file to use to save the serialized version of the spec.
   */
  public static final String SECURITY_SPEC_SERIAL_FILE_NAME = "security_spec.ser";

  /**
   * Set of methods that are considered safe.
   */
  private Set<MethodModel> whitelist = new LinkedHashSet<MethodModel>();

  /**
   * eventBlocks contains the default security spec hierarchy -- output events map to a list of
   * input events, or APIs, and each API entry maps to a number of source code locations. In this
   * map, the top most parents are the input events. The code locations for each output event are in
   * an internal field of class DroidsafeMethodModel
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
   * Main constructor for the spec model. Translate the original droidsafe spec into a simpler
   * representation that can be used by the eclipse plugin.
   * 
   * @param originalSpec The droidsafe security spec we want to represent in this model.
   */
  public SecuritySpecModel(SecuritySpecification originalSpec) {
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

  private void translateModel(SecuritySpecification originalSpec) {
    for (Method m : originalSpec.getWhitelist()) {
      this.whitelist.add(new MethodModel(m));
    }
    for (Map.Entry<Method, List<Method>> entry : originalSpec.getEventBlocks().entrySet()) {
      Method inputEvent = entry.getKey();
      List<Method> outputEvents = entry.getValue();
      ArrayList<MethodModel> modelOutputEvents = new ArrayList<MethodModel>();
      this.inputEventBlocks.put(new MethodModel(inputEvent), modelOutputEvents);

      for (Method outputEvent : outputEvents) {
        modelOutputEvents.add(new MethodModel(outputEvent));
      }
      Collections.sort(modelOutputEvents);
      logger.debug("Input Method {}", inputEvent);
      logger.debug(" \n Number of Output Events in original method {}",
          Integer.toString(outputEvents.size()));
      logger.debug("\n Number of Events in modelEvents {}",
          Integer.toString(modelOutputEvents.size()));
    }
    logger.debug("{}", printSpecModel());
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


  public static SecuritySpecModel deserializeSpecFromFile(String androidProjectRootPath) {
    SecuritySpecModel spec = null;
    String fileName =
        androidProjectRootPath + File.separator + Project.OUTPUT_DIR + File.separator
            + SECURITY_SPEC_SERIAL_FILE_NAME;
    try {
      ObjectInputStream ois =
          new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
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
    if (spec != null) {
      logger.debug("{}", spec.printSpecModel());
    }
    return spec;
  }

}
