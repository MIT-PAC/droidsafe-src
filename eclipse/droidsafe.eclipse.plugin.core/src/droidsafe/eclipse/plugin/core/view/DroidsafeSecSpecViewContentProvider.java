package droidsafe.eclipse.plugin.core.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import droidsafe.eclipse.plugin.core.specmodel.CodeLocationModel;
import droidsafe.eclipse.plugin.core.specmodel.MethodModel;
import droidsafe.eclipse.plugin.core.specmodel.SecuritySpecModel;
import droidsafe.speclang.SecuritySpecification;

public class DroidsafeSecSpecViewContentProvider implements ITreeContentProvider {

  private SecuritySpecModel model;

  // Constant to return when there are no children for an object
  private static final Object[] NO_CHILDREN = new Object[0];

  @Override
  public void dispose() {    
  }

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    if (newInput instanceof SecuritySpecification) {
      this.model = new SecuritySpecModel((SecuritySpecification) newInput);
    } else if (newInput instanceof SecuritySpecModel) {
      this.model = (SecuritySpecModel) newInput;
    }

  }

  @Override
  public Object[] getElements(Object inputElement) {
    List<Object> elements = new ArrayList<Object>();
    elements.add(model.getWhitelist());
    elements.addAll(model.getEntryPoints());
    return elements.toArray();
  }

  @Override
  public Object[] getChildren(Object parentElement) {
    if (parentElement instanceof Set<?>) {
      return model.getWhitelist().toArray();
    } else if (parentElement instanceof MethodModel) {
      MethodModel parentMethod = (MethodModel) parentElement;
      List<MethodModel> methods = model.getOutputEvents(parentMethod);
      if (methods != null && !methods.isEmpty()) {
        return methods.toArray();
      } else {
        List<CodeLocationModel> lines = parentMethod.getLines();
        if (!lines.isEmpty()) {
          return lines.toArray();
        }
      }
    }
    return NO_CHILDREN;
  }

  @Override
  public Object getParent(Object element) {
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    if (element instanceof Set && ((Set<?>) element).size() > 0) {
      return true;
    } else if (element instanceof MethodModel) {
      MethodModel elementMethod = (MethodModel) element;
      List<MethodModel> methods = model.getOutputEvents(elementMethod);
      if (methods != null && !methods.isEmpty()) {
        return true;
      } else if (!elementMethod.getLines().isEmpty()) {
        return true;
      }
    }
    return false;
  }
}
