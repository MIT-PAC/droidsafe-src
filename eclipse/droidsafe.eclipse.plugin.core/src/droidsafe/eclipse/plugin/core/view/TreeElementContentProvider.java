package droidsafe.eclipse.plugin.core.view;

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

import droidsafe.eclipse.plugin.core.specmodel.CodeLocationModel;
import droidsafe.eclipse.plugin.core.specmodel.IModelChangeSupport;
import droidsafe.eclipse.plugin.core.specmodel.MethodModel;
import droidsafe.eclipse.plugin.core.specmodel.SecuritySpecModel;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;

public class TreeElementContentProvider implements ITreeContentProvider, PropertyChangeListener {

  private static final Logger logger = LoggerFactory.getLogger(TreeElementContentProvider.class);

  /**
   * Auxiliary map from domain model objects to tree element objects. We use this map to keep track
   * of the tree node elements associated with each domain object (methods, and code location).
   * 
   * Once a new tree structure is created, we use this map to update the property change listeners
   * associated with the domain objects.
   */
  private Map<IModelChangeSupport, TreeElement<?, ?>> treeElementMap =
      new HashMap<IModelChangeSupport, TreeElement<?, ?>>();


  private List<TreeElement<?, ?>> treeElementList = new ArrayList<TreeElement<?, ?>>();

  public enum TopLevelParentEntity {
    API_AS_TOP_PARENT, CODE_LOCATION_AS_TOP_PARENT, ENTRY_POINT_AS_TOP_PARENT
  };


  /** Constant to return when there are no children for an object */
  private static final Object[] NO_CHILDREN = new Object[0];

  /** The model for the spec to be displayed in the outline view */
  private SecuritySpecModel model;

  /** Variable to control the structure of spec outline tree view. */
  public TopLevelParentEntity selectedTopLevelParentEntity =
      TopLevelParentEntity.ENTRY_POINT_AS_TOP_PARENT;

  protected TreeViewer viewer;


  public void setContentProviderTopLevelParent(TopLevelParentEntity topLevelParentEntity) {
    this.selectedTopLevelParentEntity = topLevelParentEntity;
  }

  public TopLevelParentEntity getContentProviderTopLevelParent() {
    return this.selectedTopLevelParentEntity;
  }

  @Override
  public void dispose() {}

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    this.viewer = (TreeViewer) viewer;
    if (newInput instanceof SecuritySpecModel) {
      this.model = (SecuritySpecModel) newInput;
    }
  }

  @Override
  public Object[] getElements(Object parent) {
    if (parent instanceof SecuritySpecModel) {
      TreeElement<?, ?> invisibleRoot = initializeRoot();
      // if (logger.isDebugEnabled()) {
      // for (TreeElement<?, ?> child : invisibleRoot.getChildren()) {
      // logger.debug(" Child of root = " + child.getName());
      // }
      // }
      return getChildren(invisibleRoot);
    }
    return NO_CHILDREN;
  }

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
   * @param modelObject The actual domain object we want to dispplay.
   * @param newTreeElement The tree node container for the model object.
   */
  private void updatePropertyChangeListener(IModelChangeSupport modelObject,
      TreeElement<?, ?> newTreeElement) {
    // TreeElement<?, ?> oldTreeElement = this.treeElementMap.get(modelObject);
    // if (oldTreeElement != null) {
    // Object data = oldTreeElement.getData();
    // if (data != modelObject) {
    // logger.debug(
    // "OLD TreeElement {} has Data {} but current model is {}",
    // new String[] {oldTreeElement.toString(), Integer.toString(data.hashCode()),
    // Integer.toString(modelObject.hashCode())});
    // }
    // }
    // this.treeElementMap.put(modelObject, newTreeElement);

    modelObject.addPropertyChangeListener(newTreeElement);
    newTreeElement.addPropertyChangeListener(this);
    treeElementList.add(newTreeElement);
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
  }


  @SuppressWarnings("unused")
  private void printPropertyChangeListenersForTreeElements() {
    // for (TreeElement<?, ?> element : this.treeElementMap.values()) {
    // PropertyChangeListener[] listeners = element.getPropertyChangeListeners();
    // if (listeners == null || listeners.length == 0) {
    // logger.debug("No listeners defined for node " + element);
    // }
    // logger.debug("Listeners for " + element + " == " + listeners);
    // }

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
        this.model.getOutputEventBlocks();
    if (outputEventBlocks != null) {
      for (MethodModel apiMethod : outputEventBlocks.keySet()) {
        TreeElement<Object, MethodModel> apiElement =
            new TreeElement<Object, MethodModel>(apiMethod.getSignature(), apiMethod,
                MethodModel.class);
        root.addChild(apiElement);
        updatePropertyChangeListener(apiMethod, apiElement);
        for (MethodModel inputMethod : outputEventBlocks.get(apiMethod).keySet()) {
          TreeElement<MethodModel, CodeLocationModel> inputElement =
              new TreeElement<MethodModel, CodeLocationModel>(inputMethod.getSignature(),
                  inputMethod, CodeLocationModel.class);
          apiElement.addChild(inputElement);
          updatePropertyChangeListener(inputMethod, inputElement);

          List<CodeLocationModel> locations = outputEventBlocks.get(apiMethod).get(inputMethod);
          if (locations != null) {
            for (CodeLocationModel location : locations) {
              TreeElement<CodeLocationModel, Object> locationElement =
                  new TreeElement<CodeLocationModel, Object>(location.toString(), location,
                      Object.class);
              inputElement.addChild(locationElement);
              updatePropertyChangeListener(location, locationElement);
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
        this.model.getCodeLocationEventBlocks();
    if (codeLocationEventBlocks != null) {
      for (CodeLocationModel location : codeLocationEventBlocks.keySet()) {
        TreeElement<Object, MethodModel> locationElement =
            new TreeElement<Object, MethodModel>(location.toString(), location, MethodModel.class);
        root.addChild(locationElement);
        updatePropertyChangeListener(location, locationElement);

        for (MethodModel inputMethod : codeLocationEventBlocks.get(location).keySet()) {
          TreeElement<MethodModel, MethodModel> inputElement =
              new TreeElement<MethodModel, MethodModel>(inputMethod.getSignature(), inputMethod,
                  MethodModel.class);
          locationElement.addChild(inputElement);
          updatePropertyChangeListener(inputMethod, inputElement);

          List<MethodModel> outputMethods = codeLocationEventBlocks.get(location).get(inputMethod);
          if (outputMethods != null) {
            for (MethodModel outputMethod : outputMethods) {
              TreeElement<MethodModel, Object> outputElement =
                  new TreeElement<MethodModel, Object>(outputMethod.getSignature(), outputMethod,
                      Object.class);
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
    Map<MethodModel, List<MethodModel>> inputEventBlocks = this.model.getInputEventBlocks();
    if (inputEventBlocks != null) {
      for (MethodModel inputMethod : inputEventBlocks.keySet()) {
        TreeElement<Object, MethodModel> inputElement =
            new TreeElement<Object, MethodModel>(inputMethod.getSignature(), inputMethod,
                MethodModel.class);
        root.addChild(inputElement);
        updatePropertyChangeListener(inputMethod, inputElement);

        for (MethodModel outputMethod : inputEventBlocks.get(inputMethod)) {
          TreeElement<MethodModel, CodeLocationModel> outputElement =
              new TreeElement<MethodModel, CodeLocationModel>(outputMethod.getSignature(),
                  outputMethod, CodeLocationModel.class);
          inputElement.addChild(outputElement);
          updatePropertyChangeListener(outputMethod, outputElement);

          List<CodeLocationModel> locations = outputMethod.getLines();
          if (locations != null) {
            for (CodeLocationModel location : locations) {
              TreeElement<CodeLocationModel, Object> locationElement =
                  new TreeElement<CodeLocationModel, Object>(location.toString(), location,
                      Object.class);
              outputElement.addChild(locationElement);
              updatePropertyChangeListener(location, locationElement);
            }
          }
        }
      }
    }
    // printPropertyChangeListenersForTreeElements();
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
        new TreeElement<SecuritySpecModel, Object>("SecuritySpec", this.model, Object.class);
    TreeElement<Object, MethodModel> whitelist =
        new TreeElement<Object, MethodModel>("Whitelist", this.model.getWhitelist(),
            MethodModel.class);
    root.addChild(whitelist);
    for (MethodModel m : this.model.getWhitelist()) {
      TreeElement<MethodModel, Object> mTreeElement =
          new TreeElement<MethodModel, Object>(m.getSignature(), m, Object.class);
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
    //logger.debug("Updating node {}", source);
    if (this.viewer != null) {
      this.viewer.update(source, null);
    }
  }

}
