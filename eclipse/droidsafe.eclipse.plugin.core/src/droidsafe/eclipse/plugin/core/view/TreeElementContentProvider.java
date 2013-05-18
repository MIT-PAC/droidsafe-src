package droidsafe.eclipse.plugin.core.view;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.specmodel.CodeLocationModel;
import droidsafe.eclipse.plugin.core.specmodel.MethodModel;
import droidsafe.eclipse.plugin.core.specmodel.SecuritySpecModel;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.speclang.SecuritySpecification;

public class TreeElementContentProvider implements ITreeContentProvider {

  private static final Logger logger = LoggerFactory.getLogger(TreeElementContentProvider.class);

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
    if (newInput instanceof SecuritySpecification) {
      this.model = new SecuritySpecModel((SecuritySpecification) newInput);
    } else if (newInput instanceof SecuritySpecModel) {
      this.model = (SecuritySpecModel) newInput;
    }
  }

  @Override
  public Object[] getElements(Object parent) {
    if (parent instanceof SecuritySpecModel) {
      TreeElement<?, ?> invisibleRoot = initializeRoot();
      if (logger.isDebugEnabled()) {
        for (TreeElement<?, ?> child : invisibleRoot.getChildren()) {
          logger.debug(" Child of root = " + child.getName());
        }
      }
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

  private void createModelWithApiAsTopParent(TreeElement<SecuritySpecModel, Object> root) {
    Map<MethodModel, Map<MethodModel, List<CodeLocationModel>>> outputEventBlocks =
        this.model.getOutputEventBlocks();
    if (outputEventBlocks != null) {
      for (MethodModel apiMethod : outputEventBlocks.keySet()) {
        TreeElement<Object, MethodModel> apiElement =
            new TreeElement<Object, MethodModel>(apiMethod.getSignature(), apiMethod,
                MethodModel.class);
        root.addChild(apiElement);
        for (MethodModel inputMethod : outputEventBlocks.get(apiMethod).keySet()) {
          TreeElement<MethodModel, CodeLocationModel> inputElement =
              new TreeElement<MethodModel, CodeLocationModel>(inputMethod.getSignature(),
                  inputMethod, CodeLocationModel.class);
          apiElement.addChild(inputElement);
          List<CodeLocationModel> locations = outputEventBlocks.get(apiMethod).get(inputMethod);
          if (locations != null) {
            for (CodeLocationModel location : locations) {
              TreeElement<CodeLocationModel, Object> locationElement =
                  new TreeElement<CodeLocationModel, Object>(location.toString(), location,
                      Object.class);
              inputElement.addChild(locationElement);
            }
          }
        }
      }
    }
  }

  private void createModelWithCodeLocationAsTopParent(
      TreeElement<SecuritySpecModel, Object> root) {
    Map<CodeLocationModel, Map<MethodModel, List<MethodModel>>> codeLocationEventBlocks =
        this.model.getCodeLocationEventBlocks();
    if (codeLocationEventBlocks != null) {
      for (CodeLocationModel location : codeLocationEventBlocks.keySet()) {
        TreeElement<Object, MethodModel> locationElement =
            new TreeElement<Object, MethodModel>(location.toString(), location,
                MethodModel.class);
        root.addChild(locationElement);
        for (MethodModel inputMethod : codeLocationEventBlocks.get(location).keySet()) {
          TreeElement<MethodModel, MethodModel> inputElement =
              new TreeElement<MethodModel, MethodModel>(
                  inputMethod.getSignature(), inputMethod, MethodModel.class);
          locationElement.addChild(inputElement);
          List<MethodModel> outputMethods =
              codeLocationEventBlocks.get(location).get(inputMethod);
          if (outputMethods != null) {
            for (MethodModel outputMethod : outputMethods) {
              TreeElement<MethodModel, Object> outputElement =
                  new TreeElement<MethodModel, Object>(outputMethod.getSignature(),
                      outputMethod, Object.class);
              inputElement.addChild(outputElement);
            }
          }
        }
      }
    }
  }

  private void createModelWithEntryPointAsTopParent(
      TreeElement<SecuritySpecModel, Object> root) {
    Map<MethodModel, List<MethodModel>> inputEventBlocks =
        this.model.getInputEventBlocks();
    if (inputEventBlocks != null) {
      for (MethodModel inputMethod : inputEventBlocks.keySet()) {
        TreeElement<Object, MethodModel> inputElement =
            new TreeElement<Object, MethodModel>(inputMethod.getSignature(), inputMethod,
                MethodModel.class);
        root.addChild(inputElement);
        for (MethodModel outputMethod : inputEventBlocks.get(inputMethod)) {
          TreeElement<MethodModel, CodeLocationModel> outputElement =
              new TreeElement<MethodModel, CodeLocationModel>(outputMethod.getSignature(),
                  outputMethod, CodeLocationModel.class);
          inputElement.addChild(outputElement);
          List<CodeLocationModel> locations = outputMethod.getLines();
          if (locations != null) {
            for (CodeLocationModel location : locations) {
              TreeElement<CodeLocationModel, Object> locationElement =
                  new TreeElement<CodeLocationModel, Object>(location.toString(), location,
                      Object.class);
              outputElement.addChild(locationElement);
            }
          }
        }
      }
    }
  }

  public TreeElement<?, ?> initializeRoot() {
    TreeElement<SecuritySpecModel, Object> root =
        new TreeElement<SecuritySpecModel, Object>("SecuritySpec", this.model,
            Object.class);
    TreeElement<Object, MethodModel> whitelist =
        new TreeElement<Object, MethodModel>("Whitelist", this.model.getWhitelist(),
            MethodModel.class);
    root.addChild(whitelist);
    for (MethodModel m : this.model.getWhitelist()) {
      TreeElement<MethodModel, Object> mTreeElement =
          new TreeElement<MethodModel, Object>(m.getSignature(), m, Object.class);
      whitelist.addChild(mTreeElement);
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

}
