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

package droidsafe.eclipse.plugin.core.view.indicator;

import java.util.Set;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.actions.CompoundContributionItem;

/**
 * A dynamic menu for outline sorting options. The menu contains the fields by
 * which the indicator outline can be sorted.
 * 
 * @author gilham
 *
 */
public class DynamicSortOutlineMenu extends CompoundContributionItem {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.actions.CompoundContributionItem#getContributionItems()
	 */
	protected IContributionItem[] getContributionItems() {
        final IndicatorViewPart view = Utils.getIndicatorView();
        if (view == null)
            return new IContributionItem[0];

        Set<String> sortByFields = view.getSortByFields();

        if (sortByFields.isEmpty())
            return new IContributionItem[0];
        
        final String sortByField = view.getSortByField();
        IContributionItem[] items = new IContributionItem[sortByFields.size()];
        int i = 0;
        for (final String field: sortByFields) {
            items[i++] = new ContributionItem() {

                /*
                 * (non-Javadoc)
                 * 
                 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.Menu,
                 *      int)
                 */
                public void fill(Menu menu, int index) {
                    MenuItem item = new MenuItem(menu, SWT.RADIO);
                    item.setText(field);
                    item.addListener(SWT.Selection, getMenuItemListener(field, view));
                    item.setSelection(field.equals(sortByField));
                }

                /**
                 * Returns the menu item listener for selection of a field to sort by.
                 * 
                 * @param field - a field to sort by
                 * @param view - the indicator outline view
                 * @return the listener
                 */
                private Listener getMenuItemListener(final String field,
                                                     final IndicatorViewPart view) {
                    return new Listener() {
                        /*
                         * (non-Javadoc)
                         * 
                         * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
                         */
                        public void handleEvent(Event event) {
                            if (view != null) {
                                if (!field.equals(view.getSortByField())) {
                                    view.setSortByField(field);
                                    view.sortByField(field);
                                }
                            }
                        }
                    };
                }
            };
        }

        return items;

    }

}
