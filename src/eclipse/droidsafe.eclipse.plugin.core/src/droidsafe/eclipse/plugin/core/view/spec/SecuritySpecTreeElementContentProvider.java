/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.eclipse.plugin.core.view.spec;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.DroidsafeInfoTreeElementContentProvider;
import droidsafe.eclipse.plugin.core.view.SpecInfoTreeElementContentProvider;
import droidsafe.speclang.model.CodeLocationModel;
import droidsafe.speclang.model.HotspotModel;
import droidsafe.speclang.model.IModelChangeSupport;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.SecuritySpecModel;

public class SecuritySpecTreeElementContentProvider extends SpecInfoTreeElementContentProvider implements ITreeContentProvider, PropertyChangeListener {

  private static final Logger logger = LoggerFactory.getLogger(SecuritySpecTreeElementContentProvider.class);

  /**
   * Auxiliary map from domain model objects to tree element objects. We use this map to keep track
   * of the tree node elements associated with each domain object (methods, and code location).
   * 
   * Once a new tree structure is created, we use this map to update the property change listeners
   * associated with the domain objects.
   */
  private Map<IModelChangeSupport, TreeElement<?, ?>> treeElementMap =
      new HashMap<IModelChangeSupport, TreeElement<?, ?>>();


  /**
   * Map from the element label to the actual tree node element used to display the node in the
   * outline view. We use this map to avoid duplication of nodes that have the same signature.
   */
  // private Map<String, TreeElement<?, ?>> nodeLabelToTreeElementMap =
  // new HashMap<String, TreeElement<?, ?>>();



  private List<TreeElement<?, ?>> treeElementList = new ArrayList<TreeElement<?, ?>>();

  public enum TopLevelParentEntity {
    API_AS_TOP_PARENT, CODE_LOCATION_AS_TOP_PARENT, ENTRY_POINT_AS_TOP_PARENT
  };


  /** Constant to return when there are no children for an object */
  private static final Object[] NO_CHILDREN = new Object[0];

  /** Variable to control the structure of spec outline tree view. */
  public TopLevelParentEntity selectedTopLevelParentEntity =
      TopLevelParentEntity.ENTRY_POINT_AS_TOP_PARENT;

  protected TreeViewer viewer;



  public void setContentProviderTopLevelParent(TopLevelParentEntity topLevelParentEntity) {
    this.selectedTopLevelParentEntity = topLevelParentEntity;
    resetRootElements();
  }

  public TopLevelParentEntity getContentProviderTopLevelParent() {
    return this.selectedTopLevelParentEntity;
  }

  @Override
  public void dispose() {}

  @Override
  public Object getParent(Object child) {
    if (child instanceof TreeElement<?, ?>) {
      return ((TreeElement<?, ?>) child).getParent();
    }
    return null;
  }

  @Override
  public Object[] getChildren(Object parent) {
    if (parent instanceof TreeElement<?, ?>) {
      TreeElement<?, ?> treeElement = (TreeElement<?, ?>) parent;
      return treeElement.getChildren().toArray();
    }
    return NO_CHILDREN;
  }

  @Override
  public boolean hasChildren(Object parent) {
    if (parent instanceof TreeElement<?, ?>) {
      TreeElement<?, ?> element = (TreeElement<?, ?>) parent;
      return element.hasChildren();
    }
    return false;
  }

  /**
   * Auxiliary method to update the property change listener for each tree element created by this
   * content provider.
   * 
   * The TreeElement is just a container class around the real model object. The TreeElement listens
   * to changes from the model objects, and propagates the changes to this content provider. We need
   * the change to come from the TreeElement object so we can call TreeView.update(TreeElement).
   * 
   * This method removes the property change listener from the old TreeElement, if one exists, and
   * add this content provider as listener to the new TreeElement passed in the newTreeElement
   * parameter.
   * 
   * @param modelObject The actual domain object we want to display.
   * @param newTreeElement The tree node container for the model object.
   */
  private void updatePropertyChangeListener(IModelChangeSupport modelObject,
      TreeElement<?, ?> newTreeElement) {
    modelObject.addPropertyChangeListener(newTreeElement);
    newTreeElement.addPropertyChangeListener(this);
    treeElementList.add(newTreeElement);
    treeElementMap.put(modelObject, newTreeElement);
    // nodeLabelToTreeElementMap.put(newTreeElement.toString(), newTreeElement);
  }

  /**
   * Helper function to make sure all property change listeners are removed when we change the
   * structure of the model.
   */
  private void clearPropertyChangeListeners() {
    for (TreeElement<?, ?> element : this.treeElementList) {
      element.removePropertyChangeListener(this);
      Object data = element.getData();
      if (data instanceof IModelChangeSupport) {
        IModelChangeSupport modelObject = (IModelChangeSupport) data;
        modelObject.removePropertyChangeListener(element);
      }
    }
    this.treeElementList.clear();
    this.treeElementMap.clear();
    // this.nodeLabelToTreeElementMap.clear();
  }


  @SuppressWarnings("unused")
  private void printPropertyChangeListenersForTreeElements() {
    for (TreeElement<?, ?> element : this.treeElementList) {
      PropertyChangeListener[] listeners = element.getPropertyChangeListeners();
      if (listeners == null || listeners.length == 0) {
        logger.debug("No listeners defined for node " + element);
      }
      logger.debug("Listeners for " + element + " == " + listeners.length);
    }
  }



  /**
   * Creates the tree hierarchy for the security specification model using the output method, or API
   * methods, as top level parents.
   * 
   * In this structure we will have the output methods or API calls as top parents, input methods or
   * entry points as the first set of children, and the code location where the APIs are called as
   * the leaf nodes.
   * 
   * @param root The TreeElement corresponding to security spec model.
   */
  private void createModelWithApiAsTopParent(TreeElement<SecuritySpecModel, Object> root) {
    Map<MethodModel, Map<MethodModel, List<CodeLocationModel>>> outputEventBlocks =
        getSpec().getOutputEventBlocks();
//    Map<String, TreeElement<Object, MethodModel>> localNodeLabelToTreeElementMap =
//        new HashMap<String, TreeElement<Object, MethodModel>>();

    if (outputEventBlocks != null) {
      for (MethodModel apiMethod : outputEventBlocks.keySet()) {
        String shortSignature = apiMethod.getShortSignature();
//        TreeElement<Object, MethodModel> apiElement =
//            localNodeLabelToTreeElementMap.get(shortSignature);
//        if (apiElement == null) {
        TreeElement<Object, MethodModel> apiElement =
            new TreeElement<Object, MethodModel>(shortSignature, apiMethod, MethodModel.class);
        root.addChild(apiElement);
        updatePropertyChangeListener(apiMethod, apiElement);
//          localNodeLabelToTreeElementMap.put(shortSignature, apiElement);
//        }

        for (MethodModel inputMethod : outputEventBlocks.get(apiMethod).keySet()) {
          TreeElement<MethodModel, Object> inputElement =
              new TreeElement<MethodModel, Object>(inputMethod.getShortSignature(),
                  inputMethod, Object.class);
          apiElement.addChild(inputElement);
          updatePropertyChangeListener(inputMethod, inputElement);

          List<CodeLocationModel> locations = outputEventBlocks.get(apiMethod).get(inputMethod);
          if (locations != null) {
            if (locations != null) {
              if (locations.size() == 1) {
                CodeLocationModel location = locations.get(0);
                List<HotspotModel> hotspots = location.getHotspots();
                for (HotspotModel hotspot : hotspots) {
                  TreeElement<Object, Object> hotspotElement =
                      new TreeElement<Object, Object>(hotspot.toString(), hotspot, Object.class);
                  inputElement.addChild(hotspotElement);
                  updatePropertyChangeListener(hotspot, hotspotElement);
                }
              } else {
                for (CodeLocationModel location : locations) {
                  TreeElement<Object, HotspotModel> locationElement =
                      new TreeElement<Object, HotspotModel>(location.toString(), location,
                          HotspotModel.class);
                  inputElement.addChild(locationElement);
                  updatePropertyChangeListener(location, locationElement);

                  List<HotspotModel> hotspots = location.getHotspots();
                  for (HotspotModel hotspot : hotspots) {
                    TreeElement<HotspotModel, Object> hotspotElement =
                        new TreeElement<HotspotModel, Object>(hotspot.toString(), hotspot, Object.class);
                    locationElement.addChild(hotspotElement);
                    updatePropertyChangeListener(hotspot, hotspotElement);
                  }
                }
              }
            }
          }
        }
      }
    }
    // printPropertyChangeListenersForTreeElements();
  }



  /**
   * Creates the tree hierarchy for the security specification model using the code locationsas top
   * level parents.
   * 
   * In this structure we will have the code locations (class and line number) as top parents, input
   * methods or entry poins as the first set of children, and the output methods or API calls as the
   * leaf nodes.
   * 
   * @param root The TreeElement corresponding to security spec model.
   */
  private void createModelWithCodeLocationAsTopParent(TreeElement<SecuritySpecModel, Object> root) {
    clearPropertyChangeListeners();
    Map<CodeLocationModel, Map<MethodModel, List<MethodModel>>> codeLocationEventBlocks =
        getSpec().getCodeLocationEventBlocks();
    if (codeLocationEventBlocks != null) {
      for (CodeLocationModel location : codeLocationEventBlocks.keySet()) {
        TreeElement<Object, MethodModel> locationElement =
            new TreeElement<Object, MethodModel>(location.toString(), location, MethodModel.class);
        root.addChild(locationElement);
        updatePropertyChangeListener(location, locationElement);

        for (MethodModel inputMethod : codeLocationEventBlocks.get(location).keySet()) {
          TreeElement<MethodModel, MethodModel> inputElement =
              new TreeElement<MethodModel, MethodModel>(inputMethod.getShortSignature(),
                  inputMethod, MethodModel.class);
          locationElement.addChild(inputElement);
          updatePropertyChangeListener(inputMethod, inputElement);

          List<MethodModel> outputMethods = codeLocationEventBlocks.get(location).get(inputMethod);
          if (outputMethods != null) {
            for (MethodModel outputMethod : outputMethods) {
              TreeElement<MethodModel, Object> outputElement =
                  new TreeElement<MethodModel, Object>(outputMethod.getShortSignature(),
                      outputMethod, Object.class);
              inputElement.addChild(outputElement);
              updatePropertyChangeListener(outputMethod, outputElement);
            }
          }
        }
      }
    }
    // printPropertyChangeListenersForTreeElements();
  }

  /**
   * Creates the tree hierarchy for the security specification model using the entry points, or
   * input methods, as top level parents.
   * 
   * In this structure we will have the input methods as top parents, output methods or APIs as the
   * first set of children, and the code location where the APIs are called as the leaf nodes.
   * 
   * @param root The TreeElement corresponding to security spec model.
   */
  private void createModelWithEntryPointAsTopParent(TreeElement<SecuritySpecModel, Object> root) {
    Map<MethodModel, List<MethodModel>> inputEventBlocks = getSpec().getInputEventBlocks();
    if (inputEventBlocks != null) {

      for (MethodModel inputMethod : inputEventBlocks.keySet()) {
        TreeElement<Object, MethodModel> inputElement =
            new TreeElement<Object, MethodModel>(inputMethod.getShortSignature(), inputMethod,
                MethodModel.class);
        root.addChild(inputElement);
        updatePropertyChangeListener(inputMethod, inputElement);

        for (MethodModel outputMethod : inputEventBlocks.get(inputMethod)) {
          String methodSignature = outputMethod.getShortSignature();
          TreeElement<MethodModel, Object> outputElement =
              new TreeElement<MethodModel, Object>(methodSignature, outputMethod,
                  Object.class);
          inputElement.addChild(outputElement);
          updatePropertyChangeListener(outputMethod, outputElement);

          List<CodeLocationModel> locations = outputMethod.getLines();
          if (locations != null) {
            if (locations.size() == 1) {
              CodeLocationModel location = locations.get(0);
              List<HotspotModel> hotspots = location.getHotspots();
              for (HotspotModel hotspot : hotspots) {
                TreeElement<Object, Object> hotspotElement =
                    new TreeElement<Object, Object>(hotspot.toString(), hotspot, Object.class);
                outputElement.addChild(hotspotElement);
                updatePropertyChangeListener(hotspot, hotspotElement);
              }
            } else {
              for (CodeLocationModel location : locations) {
                TreeElement<Object, HotspotModel> locationElement =
                    new TreeElement<Object, HotspotModel>(location.toString(), location,
                        HotspotModel.class);
                outputElement.addChild(locationElement);
                updatePropertyChangeListener(location, locationElement);

                List<HotspotModel> hotspots = location.getHotspots();
                for (HotspotModel hotspot : hotspots) {
                  TreeElement<HotspotModel, Object> hotspotElement =
                      new TreeElement<HotspotModel, Object>(hotspot.toString(), hotspot, Object.class);
                  locationElement.addChild(hotspotElement);
                  updatePropertyChangeListener(hotspot, hotspotElement);
                }
              }
            }
          }
        }
      }
    }
    // printPropertyChangeListenersForTreeElements();
  }


  @Override
  protected Object[] initializeRoots() {
      TreeElement<?, ?> invisibleRoot = initializeRoot();
      Object[] roots = getChildren(invisibleRoot);
      setRootElements(roots);
      return roots;
  }

  /**
   * Initializes the entire hierarchy of the model tree. It creates TreeElements for each element in
   * the Whitelist, and calls one of the model creation methods to add the model elements in the
   * correct display order.
   * 
   * @return
   */
  public TreeElement<?, ?> initializeRoot() {
    clearPropertyChangeListeners();
    TreeElement<SecuritySpecModel, Object> root =
        new TreeElement<SecuritySpecModel, Object>("SecuritySpec", getSpec(), Object.class);
    TreeElement<Object, MethodModel> whitelist =
        new TreeElement<Object, MethodModel>("Whitelist", getSpec().getWhitelist(),
            MethodModel.class);
    root.addChild(whitelist);
    for (MethodModel m : getSpec().getWhitelist()) {
      TreeElement<MethodModel, Object> mTreeElement =
          new TreeElement<MethodModel, Object>(m.getShortSignature(), m, Object.class);
      whitelist.addChild(mTreeElement);
      updatePropertyChangeListener(m, mTreeElement);
    }

    if (selectedTopLevelParentEntity == TopLevelParentEntity.API_AS_TOP_PARENT) {
      createModelWithApiAsTopParent(root);
    } else if (selectedTopLevelParentEntity == TopLevelParentEntity.CODE_LOCATION_AS_TOP_PARENT) {
      createModelWithCodeLocationAsTopParent(root);
    } else if (selectedTopLevelParentEntity == TopLevelParentEntity.ENTRY_POINT_AS_TOP_PARENT) {
      createModelWithEntryPointAsTopParent(root);
    }
    return root;
  }

  /**
   * Changes in the model will trigger updates of the tree view. We assume the source of the event
   * is a TreeElement object, so we can call update diretcly on the element.
   */
  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    Object source = evt.getSource();
    // logger.debug("Updating node {}", source);
    if (this.viewer != null) {
      this.viewer.update(source, null);
    }
  }

  /**
   * Returns the tree element corresponding to the element model (method or code location).
   * 
   * @param modelObject The method or code location object represented in the outline view.
   * 
   * @return The tree node element wrapping the model object.
   * 
   */
  public TreeElement<?, ?> findTreeElementForModelObject(IModelChangeSupport modelObject) {
    TreeElement<?, ?> result = this.treeElementMap.get(modelObject);
    if (result != null && modelObject.equals(result.getData())) {
      return result;
    } else {
      logger.debug("Could not find tree element for data item {}", modelObject);
      return null;
    }
  }

}
