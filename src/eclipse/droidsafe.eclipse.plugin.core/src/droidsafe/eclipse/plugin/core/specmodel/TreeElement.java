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

package droidsafe.eclipse.plugin.core.specmodel;

/*******************************************************************************
 * Based on Andrei Loskutov Data Hierarchy Plugin.
 * 
 * Copyright (c) 2009 Andrei Loskutov. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html Contributor:
 * Andrei Loskutov - initial API and implementation
 *******************************************************************************/

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.runtime.Assert;

import droidsafe.speclang.model.ModelChangeSupport;


/**
 * A container element for tree elements. Based on the class hierarchy plugin developed by Andrei
 * Lostkutov.
 * 
 * @author Marcel Becker
 * 
 * @param <P> this element type (parent)
 * @param <C> child element type
 */
public class TreeElement<P, C> extends ModelChangeSupport implements PropertyChangeListener {
  private final List<TreeElement<C, ?>> children;
  private final P data;
  private final String name;
  private TreeElement<?, P> parent;
  private final Class<C> childrenType;

  public TreeElement(String name, P data, Class<C> childrenType) {
    this.childrenType = childrenType;
    this.name = name == null ? "?" : name;
    this.data = data;
    this.children = new CopyOnWriteArrayList<TreeElement<C, ?>>();
  }

  public String getName() {
    return this.name;
  }

  public void setParent(TreeElement<?, P> parent) {
    this.parent = parent;
  }

  public TreeElement<?, P> getParent() {
    return this.parent;
  }

  @Override
  public String toString() {
    return getName();
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this;
  }

   @Override
   public int hashCode() {
   return data == null ? super.hashCode() : super.hashCode() * data.hashCode();
   }

  public boolean addChild(TreeElement<C, ?> child) {
    if (!childrenType.isAssignableFrom(child.data.getClass())) {
      return false;
    }
    boolean ok;
    synchronized (children) {
      TreeElement<C, ?> element = find(child.getData());
      if (element != null) {
        return false;
      }
      ok = children.add(child);
      child.setParent(this);
    }
    return ok;
  }

  public void removeChild(TreeElement<?, ?> child) {
    synchronized (children) {
      children.remove(child);
      child.setParent(null);
    }
  }

  public List<TreeElement<C, ?>> getChildren() {
    return this.children;
  }

  public Set<C> getChildrenData() {
    Set<C> set = new HashSet<C>();
    if (children.size() == 0) {
      return set;
    }
    for (TreeElement<C, ?> child : children) {
      set.add(child.getData());
    }
    return set;
  }

  public boolean hasChildren() {
    return children.size() > 0;
  }


  /**
   * @return true if this is a starting point of the visible search tree
   */
  public boolean isVisibleRoot() {
    return getParent() != null && getParent().getParent() == null;
  }


  @SuppressWarnings("unchecked")
  public TreeElement<C, ?> find(C eltData) {
    for (TreeElement<C, ?> obj : children) {
      if (obj.data.equals(eltData)) {
        return obj;
      }
    }
    if (data != null && data.equals(eltData)) {
      return (TreeElement<C, C>) this;
    }
    return null;
  }

  public TreeElement<?, ?> findRecursive(Object eltData) {
    if (data != null && data.equals(eltData)) {
      return this;
    }
    if (parent == null) {
      return null;
    }
    return parent.findRecursive(eltData);
  }

  protected static <V> V assertNotNull(V data) {
    Assert.isNotNull(data, "Attempt to create TreeElement with null data object");
    return data;
  }

  public P getData() {
    return data;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    PropertyChangeEvent newEvent =
        new PropertyChangeEvent(this, evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
    firePropertyChange(newEvent);
  }
}
