package droidsafe.eclipse.plugin.core.view;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.specmodel.DroidsafeMethodModel;
import droidsafe.eclipse.plugin.core.specmodel.DroidsafeSecuritySpecModel;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.utils.SourceLocationTag;

public class TreeElementContentProvider implements ITreeContentProvider {

  private static final Logger logger = LoggerFactory.getLogger(TreeElementContentProvider.class);

  public enum TopLevelParentEntity {
    API_AS_TOP_PARENT, CODE_LOCATION_AS_TOP_PARENT, ENTRY_POINT_AS_TOP_PARENT
  };


  /** Constant to return when there are no children for an object */
  private static final Object[] NO_CHILDREN = new Object[0];

  /** The model for the spec to be displayed in the outline view */
  private DroidsafeSecuritySpecModel model;

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
      this.model = new DroidsafeSecuritySpecModel((SecuritySpecification) newInput);
    } else if (newInput instanceof DroidsafeSecuritySpecModel) {
      this.model = (DroidsafeSecuritySpecModel) newInput;
    }
  }

  @Override
  public Object[] getElements(Object parent) {
    if (parent instanceof DroidsafeSecuritySpecModel) {
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

  private void createModelWithApiAsTopParent(TreeElement<DroidsafeSecuritySpecModel, Object> root) {
    Map<DroidsafeMethodModel, Map<DroidsafeMethodModel, List<SourceLocationTag>>> outputEventBlocks =
        this.model.getOutputEventBlocks();
    if (outputEventBlocks != null) {
      for (DroidsafeMethodModel apiMethod : outputEventBlocks.keySet()) {
        TreeElement<Object, DroidsafeMethodModel> apiElement =
            new TreeElement<Object, DroidsafeMethodModel>(apiMethod.getSignature(), apiMethod,
                DroidsafeMethodModel.class);
        root.addChild(apiElement);
        for (DroidsafeMethodModel inputMethod : outputEventBlocks.get(apiMethod).keySet()) {
          TreeElement<DroidsafeMethodModel, SourceLocationTag> inputElement =
              new TreeElement<DroidsafeMethodModel, SourceLocationTag>(inputMethod.getSignature(),
                  inputMethod, SourceLocationTag.class);
          apiElement.addChild(inputElement);
          List<SourceLocationTag> locations = outputEventBlocks.get(apiMethod).get(inputMethod);
          if (locations != null) {
            for (SourceLocationTag location : locations) {
              TreeElement<SourceLocationTag, Object> locationElement =
                  new TreeElement<SourceLocationTag, Object>(location.toString(), location,
                      Object.class);
              inputElement.addChild(locationElement);
            }
          }
        }
      }
    }
  }

  private void createModelWithCodeLocationAsTopParent(
      TreeElement<DroidsafeSecuritySpecModel, Object> root) {
    Map<SourceLocationTag, Map<DroidsafeMethodModel, List<DroidsafeMethodModel>>> codeLocationEventBlocks =
        this.model.getCodeLocationEventBlocks();
    if (codeLocationEventBlocks != null) {
      for (SourceLocationTag location : codeLocationEventBlocks.keySet()) {
        TreeElement<Object, DroidsafeMethodModel> locationElement =
            new TreeElement<Object, DroidsafeMethodModel>(location.toString(), location,
                DroidsafeMethodModel.class);
        root.addChild(locationElement);
        for (DroidsafeMethodModel inputMethod : codeLocationEventBlocks.get(location).keySet()) {
          TreeElement<DroidsafeMethodModel, DroidsafeMethodModel> inputElement =
              new TreeElement<DroidsafeMethodModel, DroidsafeMethodModel>(
                  inputMethod.getSignature(), inputMethod, DroidsafeMethodModel.class);
          locationElement.addChild(inputElement);
          List<DroidsafeMethodModel> outputMethods =
              codeLocationEventBlocks.get(location).get(inputMethod);
          if (outputMethods != null) {
            for (DroidsafeMethodModel outputMethod : outputMethods) {
              TreeElement<DroidsafeMethodModel, Object> outputElement =
                  new TreeElement<DroidsafeMethodModel, Object>(outputMethod.getSignature(),
                      outputMethod, Object.class);
              inputElement.addChild(outputElement);
            }
          }
        }
      }
    }
  }

  private void createModelWithEntryPointAsTopParent(
      TreeElement<DroidsafeSecuritySpecModel, Object> root) {
    Map<DroidsafeMethodModel, List<DroidsafeMethodModel>> inputEventBlocks =
        this.model.getInputEventBlocks();
    if (inputEventBlocks != null) {
      for (DroidsafeMethodModel inputMethod : inputEventBlocks.keySet()) {
        TreeElement<Object, DroidsafeMethodModel> inputElement =
            new TreeElement<Object, DroidsafeMethodModel>(inputMethod.getSignature(), inputMethod,
                DroidsafeMethodModel.class);
        root.addChild(inputElement);
        for (DroidsafeMethodModel outputMethod : inputEventBlocks.get(inputMethod)) {
          TreeElement<DroidsafeMethodModel, SourceLocationTag> outputElement =
              new TreeElement<DroidsafeMethodModel, SourceLocationTag>(outputMethod.getSignature(),
                  outputMethod, SourceLocationTag.class);
          inputElement.addChild(outputElement);
          List<SourceLocationTag> locations = outputMethod.getLines();
          if (locations != null) {
            for (SourceLocationTag location : locations) {
              TreeElement<SourceLocationTag, Object> locationElement =
                  new TreeElement<SourceLocationTag, Object>(location.toString(), location,
                      Object.class);
              outputElement.addChild(locationElement);
            }
          }
        }
      }
    }
  }

  public TreeElement<?, ?> initializeRoot() {
    TreeElement<DroidsafeSecuritySpecModel, Object> root =
        new TreeElement<DroidsafeSecuritySpecModel, Object>("SecuritySpec", this.model,
            Object.class);
    TreeElement<Object, DroidsafeMethodModel> whitelist =
        new TreeElement<Object, DroidsafeMethodModel>("Whitelist", this.model.getWhitelist(),
            DroidsafeMethodModel.class);
    root.addChild(whitelist);
    for (DroidsafeMethodModel m : this.model.getWhitelist()) {
      TreeElement<DroidsafeMethodModel, Object> mTreeElement =
          new TreeElement<DroidsafeMethodModel, Object>(m.getSignature(), m, Object.class);
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
