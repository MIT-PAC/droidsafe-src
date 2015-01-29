package droidsafe.eclipse.plugin.core.view.indicator;

import java.util.Map;
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
 * A dynamic menu for type visibility control. The menu contains a check list of
 * element types in the indicator.
 * 
 * @author gilham
 *
 */
public class DynamicTypeVisibilityMenu extends CompoundContributionItem {

    /** The contribution items when there are no visibility control in the project. */
    static IContributionItem[] NO_VISIBILITY_CONTROL;
    
    static {
        NO_VISIBILITY_CONTROL = new IContributionItem[1];
        NO_VISIBILITY_CONTROL[0] = new ContributionItem() {
            public void fill(Menu menu, int index) {
                MenuItem item = new MenuItem(menu, SWT.READ_ONLY);
                item.setText("<No visibility control>");
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

        Map<String, Boolean> visibilityMap = view.getVisibilityMap();

        if (visibilityMap.isEmpty())
            return NO_VISIBILITY_CONTROL;
        
        Set<String> types = visibilityMap.keySet();
        IContributionItem[] items = new IContributionItem[types.size()];
        int i = 0;
        for (final String type: types) {
            items[i++] = new ContributionItem() {

                /*
                 * (non-Javadoc)
                 * 
                 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.Menu,
                 *      int)
                 */
                public void fill(Menu menu, int index) {
                    MenuItem item = new MenuItem(menu, SWT.CHECK);
                    item.setText(type);
                    item.addListener(SWT.Selection, getMenuItemListener(type, view));
                    item.setSelection(view.getVisibility(type));
                }

                /**
                 * Returns the menu item listener for checking/unchecking a type visibility control.
                 * 
                 * @param type - the type
                 * @param view - the indicator outline view
                 * @return the listener
                 */
                private Listener getMenuItemListener(final String type,
                                                     final IndicatorViewPart view) {
                    return new Listener() {
                        /*
                         * (non-Javadoc)
                         * 
                         * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
                         */
                        public void handleEvent(Event event) {
                            if (view != null) {
                                view.toggleVisibility(type);
                                view.refresh(true, false);
                            }
                        }
                    };
                }
            };
        }

        return items;

    }

}
