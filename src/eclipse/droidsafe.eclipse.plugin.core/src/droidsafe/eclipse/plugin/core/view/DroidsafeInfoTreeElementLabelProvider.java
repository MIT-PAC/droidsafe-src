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

package droidsafe.eclipse.plugin.core.view;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;
import droidsafe.speclang.model.AllocLocationModel;
import droidsafe.speclang.model.CodeLocationModel;
import droidsafe.speclang.model.MethodArgumentModel;

/**
 * Label provider for the nodes of the droidsafe outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class DroidsafeInfoTreeElementLabelProvider extends StyledCellLabelProvider {

    /** The current search string for an outline text search */
    private String searchString;
    
    /** The current search result element for an outline text search */
    private Object searchResultElement;

    /**
     * Sets the current search string to the given string.
     * 
     * @param searchString - a string to search for
     */
    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    /**
     * Sets the current search result element to the given element.
     * 
     * @param searchResultElement - the new search result element 
     */
    public void setSearchResultElement(Object searchResultElement) {
        this.searchResultElement = searchResultElement;
    }

    @Override
    public String getToolTipText(Object obj) {
        return null;
    }

    /**
     * Returns the label for the tree node to display in the tree outline view.
     * 
     * @param element The element to display in the tree node.
     * @return The text for the node label.
     */
    public String getText(Object element) {
        if (element instanceof TreeElement<?, ?>) {
            TreeElement<?, ?> treeElement = (TreeElement<?, ?>) element;
            Object data = treeElement.getData();
            return DroidsafePluginUtilities.removeCloneSuffix(data.toString());
        }
        return DroidsafePluginUtilities.removeCloneSuffix(element.toString());
    }
    
    /**
     * Returns the icon image for the tree node.
     * 
     * @param element The tree node element to display.
     * @return The icon image to display together with the label in the outline view.
     */
    protected Image getImage(Object element) {
        if (element instanceof TreeElement<?, ?>) {
            TreeElement<?, ?> treeElement = (TreeElement<?, ?>) element;
            Object data = treeElement.getData();
            if (data instanceof AllocLocationModel) {
                return DroidsafeImages.ALLOC_NODE_IMAGE;
            } else if (data instanceof CodeLocationModel) {
                return DroidsafeImages.CODE_LOC_IMAGE;
            } else if (data instanceof MethodArgumentModel) {
                MethodArgumentModel methArg = (MethodArgumentModel) data;
                if (methArg.isReceiver())
                    return DroidsafeImages.METHOD_RECEIVER_IMAGE;
                return DroidsafeImages.METHOD_ARG_IMAGE;
            }
        }
        return null;
    }

    /** The color constant for the red color. */
    private static final Color RED = Display.getDefault().getSystemColor(SWT.COLOR_RED);

    /** The color constant for the yellow color. */
    private static final Color YELLOW = Display.getDefault().getSystemColor(SWT.COLOR_YELLOW);

    /**
     * A styler to allow the background of the node to be red.
     */
    private static Styler RED_BACKGROUND = new Styler() {

        @Override
        public void applyStyles(TextStyle textStyle) {
            textStyle.background = RED;
        }
    };

    /**
     * A styler to allow the background of the node to be red.
     */
    private static Styler YELLOW_BACKGROUND = new Styler() {

        @Override
        public void applyStyles(TextStyle textStyle) {
            textStyle.background = YELLOW;
        }
    };
    /**
     * The method that provides the desired style for the Tree node label.
     * 
     * @see org.eclipse.jface.viewers.StyledCellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
     */
    @Override
    public void update(ViewerCell cell) {
      Object element = cell.getElement();
      String text = getText(element);
      StyledString styledString = new StyledString(text);
      cell.setText(styledString.toString());
      if (searchString != null) {
          int pos = StringUtils.indexOfIgnoreCase(text, searchString);
          if (pos >= 0) {
              Styler styler = (element == searchResultElement) ? RED_BACKGROUND : YELLOW_BACKGROUND;
              styledString.setStyle(pos, searchString.length(), styler);
          }
      }
      cell.setStyleRanges(styledString.getStyleRanges());
      cell.setImage(getImage(element));
      super.update(cell);
    }

}
