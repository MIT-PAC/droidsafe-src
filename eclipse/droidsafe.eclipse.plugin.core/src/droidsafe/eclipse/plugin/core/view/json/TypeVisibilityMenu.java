package droidsafe.eclipse.plugin.core.view.json;

import java.util.Map;
import java.util.Set;

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

public class TypeVisibilityMenu extends CompoundContributionItem {

    @Override
    protected IContributionItem[] getContributionItems() {
        final JsonViewPart view = getView();
        if (view == null)
            return new IContributionItem[0];

        Map<String, Boolean> visibilityMap = view.getVisibilityMap();

        if (visibilityMap.isEmpty())
            return new IContributionItem[0];
        
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
                 * Return the menu item listener for selection of a filter.
                 * 
                 * @param type
                 * @param view
                 * @return Listener
                 */
                private Listener getMenuItemListener(final String type,
                                                     final JsonViewPart view) {
                    return new Listener() {
                        /*
                         * (non-Javadoc)
                         * 
                         * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
                         */
                        public void handleEvent(Event event) {
                            if (view != null) {
                                view.toggleVisibility(type);
                                view.refresh();
                            }
                        }
                    };
                }
            };
        }

        return items;

    }

    /**
     * Get the view this contribution is working on.
     * 
     * @return JsonViewPart or <code>null</code> if the active view isn't a JsonViewPart
     */
    JsonViewPart getView() {
        IWorkbenchWindow active = PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow();
        if (active == null)
            return null;
        IWorkbenchPage page = active.getActivePage();
        if (page == null)
            return null;
        IWorkbenchPart part = page.getActivePart();
        if (!(part instanceof JsonViewPart))
            return null;

        return (JsonViewPart) part;
    }

}
