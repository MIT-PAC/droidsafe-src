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
