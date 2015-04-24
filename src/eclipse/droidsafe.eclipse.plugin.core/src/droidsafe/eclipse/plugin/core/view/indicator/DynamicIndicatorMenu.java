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

import java.io.File;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;

/**
 * A dynamic menu for displaying the indicators in the project
 * other than the one being displayed.
 * 
 * @author gilham
 *
 */
public class DynamicIndicatorMenu extends CompoundContributionItem {

    /** The contribution items when there are no indicators in the project. */
    static IContributionItem[] NO_INDICATOR;

    /** The contribution items when there are no other indicators in the project. */
    static IContributionItem[] NO_OTHER_INDICATOR;
    
    static {
        NO_INDICATOR = new IContributionItem[1];
        NO_INDICATOR[0] = new ContributionItem() {

        	/* (non-Javadoc)
             * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.Menu, int)
             */
            public void fill(Menu menu, int index) {
                MenuItem item = new MenuItem(menu, SWT.READ_ONLY);
                item.setText("<No indicators>");
            }
        };
        
        NO_OTHER_INDICATOR = new IContributionItem[1];
        NO_OTHER_INDICATOR[0] = new ContributionItem() {

        	/* (non-Javadoc)
             * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.Menu, int)
             */
            public void fill(Menu menu, int index) {
                MenuItem item = new MenuItem(menu, SWT.READ_ONLY);
                item.setText("<No other indicators>");
            }
        };
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.ui.actions.CompoundContributionItem#getContributionItems()
     */
    protected IContributionItem[] getContributionItems() {
        final IndicatorViewPart view = Utils.getIndicatorView();
        if (view == null)
            return new IContributionItem[0];

        File[] indicatorFiles = view.getIndicatorFiles();
        File indicatorFile = view.getInputElement();

        if (indicatorFiles == null || indicatorFiles.length == 0)
            return NO_INDICATOR;
        
        if (indicatorFiles.length == 1) {
            return NO_OTHER_INDICATOR;
        }
        IContributionItem[] items = new IContributionItem[indicatorFiles.length - 1];
        int i = 0;
        for (final File file: indicatorFiles) {
            if (!file.equals(indicatorFile))
                items[i++] = new ContributionItem() {

                /*
                 * (non-Javadoc)
                 * 
                 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.Menu,
                 *      int)
                 */
                public void fill(Menu menu, int index) {
                    MenuItem item = new MenuItem(menu, SWT.PUSH);
                    item.setText(file.getName());
                    item.addListener(SWT.Selection, getMenuItemListener(file, view));
                }

                /**
                 * Return the menu item listener for selection of a filter.
                 * 
                 * @param type
                 * @param view
                 * @return Listener
                 */
                private Listener getMenuItemListener(final File file,
                                                     final IndicatorViewPart view) {
                    return new Listener() {
                        /*
                         * (non-Javadoc)
                         * 
                         * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
                         */
                        public void handleEvent(Event event) {
                            if (view != null) {
                                view.setInputElement(file);
                            }
                        }
                    };
                }
            };
        }

        return items;

    }

}
