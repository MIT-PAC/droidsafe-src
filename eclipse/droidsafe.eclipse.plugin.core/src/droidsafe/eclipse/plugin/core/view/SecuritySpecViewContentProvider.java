package droidsafe.eclipse.plugin.core.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import droidsafe.speclang.Method;
import droidsafe.speclang.SecuritySpecification;

public class SecuritySpecViewContentProvider implements ITreeContentProvider {

  private SecuritySpecification model;

  /** Constant to return when there are no children for an object */
  private static final Object[] NO_CHILDREN = new Object[0];

  @Override
  public void dispose() {}

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    if (newInput instanceof SecuritySpecification) {
      this.model = (SecuritySpecification) newInput;
    }

  }

  @Override
  public Object[] getElements(Object inputElement) {
    List<Object> elements = new ArrayList<Object>();
    elements.add(model.getWhitelist());
    elements.addAll(model.getEventBlocks().keySet());
    return elements.toArray();
  }

  @Override
  public Object[] getChildren(Object parentElement) {
    if (parentElement instanceof Set<?>) {
      return model.getWhitelist().toArray();
    } else if (parentElement instanceof Method) {
      if (model.getEventBlocks().get(parentElement) != null
          && !model.getEventBlocks().get(parentElement).isEmpty()) {
        return model.getEventBlocks().get(parentElement).toArray();
      } else if (!((Method) parentElement).getLines().isEmpty()) {
        return ((Method) parentElement).getLines().toArray();
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
    } else if (element instanceof Method) {
      if (model.getEventBlocks().get(element) != null
          && !model.getEventBlocks().get(element).isEmpty()) {
        return true;
      } else if (!((Method) element).getLines().isEmpty()) {
        return true;
      }
    }
    return false;
  }


}
