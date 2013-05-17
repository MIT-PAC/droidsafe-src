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
import droidsafe.utils.SourceLocationTag;

/**
 * This is a wrapper class around the droidsafe.speclang.SecuritySpecification class. This class
 * provides a model of the spec that can be used by the Eclipse outline view, and simplifies the
 * serialization of the spec representation to be used by this view.
 * 
 * @author becker
 * 
 */
/**
 * @author marcelbecker
 * 
 */
public class DroidsafeSecuritySpecModel implements Serializable {
  /**
   * The generated serial version ID.
   */
  private static final long serialVersionUID = -2836030244594131144L;

  /**
   * The logger object for this class.
   */
  private static final Logger logger = LoggerFactory.getLogger(DroidsafeSecuritySpecModel.class);

  /**
   * The name of the file to use to save the serialized version of the spec.
   */
  public static final String SECURITY_SPEC_SERIAL_FILE_NAME = "security_spec.ser";

  /**
   * Set of methods that are considered safe.
   */
  private Set<DroidsafeMethodModel> whitelist = new LinkedHashSet<DroidsafeMethodModel>();

  /**
   * eventBlocks contains the default security spec hierarchy -- output events map to a list of
   * input events, or APIs, and each API entry maps to a number of source code locations. In this
   * map, the top most parents are the input events. The code locations for each output event are in
   * an internal field of class DroidsafeMethodModel
   */
  private Map<DroidsafeMethodModel, List<DroidsafeMethodModel>> inputEventBlocks =
      new LinkedHashMap<DroidsafeMethodModel, List<DroidsafeMethodModel>>();


  /**
   * This map contains the same information as the eventBlocks above but in a different
   * organization. This map maps outputEvents to input events, and each intput event to the list of
   * lines in which the parent outputEvent is present. This map is used to display a hierarchical
   * view of the spec rooted at the API nodes.
   */
  private transient Map<DroidsafeMethodModel, Map<DroidsafeMethodModel, List<SourceLocationTag>>> outputEventBlocks =
      new LinkedHashMap<DroidsafeMethodModel, Map<DroidsafeMethodModel, List<SourceLocationTag>>>();


  /**
   * This map contains the same information as the eventBlocks above but in a different
   * organization. This map maps code locations to lists of input events, and each input event to
   * the list of output events in which the parent code location is present. This map is used to
   * display a hierarchical view of the spec rooted at the code location nodes.
   */
  private transient Map<SourceLocationTag, Map<DroidsafeMethodModel, List<DroidsafeMethodModel>>> codeLocationEventBlocks =
      new LinkedHashMap<SourceLocationTag, Map<DroidsafeMethodModel, List<DroidsafeMethodModel>>>();



  /**
   * Main constructor for the spec model. Translate the original droidsafe spec into a simpler
   * representation that can be used by the eclipse plugin.
   * 
   * @param originalSpec The droidsafe security spec we want to represent in this model.
   */
  public DroidsafeSecuritySpecModel(SecuritySpecification originalSpec) {
    translateModel(originalSpec);
    // computeOutputEventBlocks();
    // computeCodeLocationEventBlocks();
  }

  public Set<DroidsafeMethodModel> getWhitelist() {
    return this.whitelist;
  }

  public Set<DroidsafeMethodModel> getEntryPoints() {
    return this.inputEventBlocks.keySet();
  }

  public List<DroidsafeMethodModel> getOutputEvents(DroidsafeMethodModel method) {
    return this.inputEventBlocks.get(method);
  }

  private void translateModel(SecuritySpecification originalSpec) {
    for (Method m : originalSpec.getWhitelist()) {
      this.whitelist.add(new DroidsafeMethodModel(m));
    }
    for (Map.Entry<Method, List<Method>> entry : originalSpec.getEventBlocks().entrySet()) {
      Method inputEvent = entry.getKey();
      List<Method> outputEvents = entry.getValue();
      ArrayList<DroidsafeMethodModel> modelOutputEvents = new ArrayList<DroidsafeMethodModel>();
      this.inputEventBlocks.put(new DroidsafeMethodModel(inputEvent), modelOutputEvents);

      for (Method outputEvent : outputEvents) {
        modelOutputEvents.add(new DroidsafeMethodModel(outputEvent));
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
    for (DroidsafeMethodModel m : this.whitelist) {
      sb.append(m.printMethod()).append("\n");
    }
    for (DroidsafeMethodModel im : inputEventBlocks.keySet()) {
      sb.append("InputMethod ").append(im.toString()).append("\n");
      for (DroidsafeMethodModel om : inputEventBlocks.get(im)) {
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
          new LinkedHashMap<DroidsafeMethodModel, Map<DroidsafeMethodModel, List<SourceLocationTag>>>();
    }
    for (DroidsafeMethodModel inputEvent : inputEventBlocks.keySet()) {
      if (inputEventBlocks.get(inputEvent) != null) {
        for (DroidsafeMethodModel outputEvent : inputEventBlocks.get(inputEvent)) {
          Map<DroidsafeMethodModel, List<SourceLocationTag>> outputEventMap =
              this.outputEventBlocks.get(outputEvent);
          if (outputEventMap == null) {
            outputEventMap = new LinkedHashMap<DroidsafeMethodModel, List<SourceLocationTag>>();
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
          new LinkedHashMap<SourceLocationTag, Map<DroidsafeMethodModel, List<DroidsafeMethodModel>>>();
    }
    for (DroidsafeMethodModel inputEvent : inputEventBlocks.keySet()) {
      if (inputEventBlocks.get(inputEvent) != null) {
        for (DroidsafeMethodModel outputEvent : inputEventBlocks.get(inputEvent)) {
          List<SourceLocationTag> lines = outputEvent.getLines();
          if (lines != null) {
            for (SourceLocationTag line : lines) {
              Map<DroidsafeMethodModel, List<DroidsafeMethodModel>> lineEventMap =
                  this.codeLocationEventBlocks.get(line);
              if (lineEventMap == null) {
                lineEventMap =
                    new LinkedHashMap<DroidsafeMethodModel, List<DroidsafeMethodModel>>();
                this.codeLocationEventBlocks.put(line, lineEventMap);
              }
              List<DroidsafeMethodModel> outputMethods = lineEventMap.get(inputEvent);
              if (outputMethods == null) {
                outputMethods = new ArrayList<DroidsafeMethodModel>();
                lineEventMap.put(inputEvent, outputMethods);
              }
              outputMethods.add(outputEvent);
            }
          }
        }
      }
    }
  }

  public Map<DroidsafeMethodModel, List<DroidsafeMethodModel>> getInputEventBlocks() {
    return this.inputEventBlocks;
  }

  public Map<DroidsafeMethodModel, Map<DroidsafeMethodModel, List<SourceLocationTag>>> getOutputEventBlocks() {
    if (this.outputEventBlocks == null || this.outputEventBlocks.isEmpty()) {
      computeOutputEventBlocks();
    }
    return this.outputEventBlocks;
  }

  public Map<SourceLocationTag, Map<DroidsafeMethodModel, List<DroidsafeMethodModel>>> getCodeLocationEventBlocks() {
    if (this.codeLocationEventBlocks == null || this.codeLocationEventBlocks.isEmpty()) {
      computeCodeLocationEventBlocks();
    }
    return this.codeLocationEventBlocks;
  }


  public static boolean serializeSpecToFile(DroidsafeSecuritySpecModel spec,
      String androidProjectRootPath) {
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


  public static DroidsafeSecuritySpecModel deserializeSpecFromFile(String androidProjectRootPath) {
    DroidsafeSecuritySpecModel spec = null;
    String fileName =
        androidProjectRootPath + File.separator + Project.OUTPUT_DIR + File.separator
            + SECURITY_SPEC_SERIAL_FILE_NAME;
    try {
      ObjectInputStream ois =
          new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
      try {
        Object obj = ois.readObject();
        if (obj instanceof DroidsafeSecuritySpecModel) {
          spec = (DroidsafeSecuritySpecModel) obj;
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
