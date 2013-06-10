package droidsafe.eclipse.plugin.core.specmodel;

import java.beans.PropertyChangeListener;



public interface IModelChangeSupport {

  public abstract void addPropertyChangeListener(PropertyChangeListener listener);

  public abstract void removePropertyChangeListener(PropertyChangeListener listener);

  public abstract void addPropertyChangeListener(String propertyName,
      PropertyChangeListener listener);

  public abstract void removePropertyChangeListener(String propertyName,
      PropertyChangeListener listener);

}
