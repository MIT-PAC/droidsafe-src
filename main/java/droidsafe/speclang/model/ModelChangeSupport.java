package droidsafe.speclang.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
/**
 * Class to provide change support for model updates. 
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 *
 */
public class ModelChangeSupport implements IModelChangeSupport {
  private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

  /* (non-Javadoc)
   * @see droidsafe.eclipse.plugin.core.specmodel.IModelChangeSupport#addPropertyChangeListener(java.beans.PropertyChangeListener)
   */
  @Override
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    changeSupport.addPropertyChangeListener(listener);
  }

  /* (non-Javadoc)
   * @see droidsafe.eclipse.plugin.core.specmodel.IModelChangeSupport#removePropertyChangeListener(java.beans.PropertyChangeListener)
   */
  @Override
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    changeSupport.removePropertyChangeListener(listener);
  }

  /* (non-Javadoc)
   * @see droidsafe.eclipse.plugin.core.specmodel.IModelChangeSupport#addPropertyChangeListener(java.lang.String, java.beans.PropertyChangeListener)
   */
  @Override
  public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
    changeSupport.addPropertyChangeListener(propertyName, listener);
  }
  
  public PropertyChangeListener[] getPropertyChangeListeners() { 
    return changeSupport.getPropertyChangeListeners();
  }

  /* (non-Javadoc)
   * @see droidsafe.eclipse.plugin.core.specmodel.IModelChangeSupport#removePropertyChangeListener(java.lang.String, java.beans.PropertyChangeListener)
   */
  @Override
  public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
    changeSupport.removePropertyChangeListener(propertyName, listener);
  }

  protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
    changeSupport.firePropertyChange(propertyName, oldValue, newValue);    
  }
  
  protected void firePropertyChange(PropertyChangeEvent event) {
    changeSupport.firePropertyChange(event);    
  }
}
