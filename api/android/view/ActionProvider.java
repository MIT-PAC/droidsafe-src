package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;





public abstract class ActionProvider {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.115 -0500", hash_original_field = "0CC45A8F2A3DE3D79B6417F1C5FAF5C0", hash_generated_field = "B0B6D637F5D44582200E582C4D2D6000")

    private SubUiVisibilityListener mSubUiVisibilityListener;

    /**
     * Creates a new instance.
     *
     * @param context Context for accessing resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.118 -0500", hash_original_method = "AD51B37569819E728EA786F52DA39151", hash_generated_method = "01703FE4B54B2BD302FDF7CE9511AF87")
    
public ActionProvider(Context context) {
    }

    /**
     * Factory method for creating new action views.
     *
     * @return A new action view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.121 -0500", hash_original_method = "D34B37B54FEE3A61B3F2EC9EB9350036", hash_generated_method = "A1917FF468BF52201E55304E949C12BA")
    
public abstract View onCreateActionView();

    /**
     * Performs an optional default action.
     * <p>
     * For the case of an action provider placed in a menu item not shown as an action this
     * method is invoked if previous callbacks for processing menu selection has handled
     * the event.
     * </p>
     * <p>
     * A menu item selection is processed in the following order:
     * <ul>
     * <li>
     * Receiving a call to {@link MenuItem.OnMenuItemClickListener#onMenuItemClick
     *  MenuItem.OnMenuItemClickListener.onMenuItemClick}.
     * </li>
     * <li>
     * Receiving a call to {@link android.app.Activity#onOptionsItemSelected(MenuItem)
     *  Activity.onOptionsItemSelected(MenuItem)}
     * </li>
     * <li>
     * Receiving a call to {@link android.app.Fragment#onOptionsItemSelected(MenuItem)
     *  Fragment.onOptionsItemSelected(MenuItem)}
     * </li>
     * <li>
     * Launching the {@link android.content.Intent} set via
     * {@link MenuItem#setIntent(android.content.Intent) MenuItem.setIntent(android.content.Intent)}
     * </li>
     * <li>
     * Invoking this method.
     * </li>
     * </ul>
     * </p>
     * <p>
     * The default implementation does not perform any action and returns false.
     * </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.124 -0500", hash_original_method = "366B075407E0A5F04994070AE9F78DED", hash_generated_method = "8E69AA43F8FD02823DF2F04092FB421C")
    
public boolean onPerformDefaultAction() {
        return false;
    }

    /**
     * Determines if this ActionProvider has a submenu associated with it.
     *
     * <p>Associated submenus will be shown when an action view is not. This
     * provider instance will receive a call to {@link #onPrepareSubMenu(SubMenu)}
     * after the call to {@link #onPerformDefaultAction()} and before a submenu is
     * displayed to the user.
     *
     * @return true if the item backed by this provider should have an associated submenu
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.126 -0500", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "C47A8DBA8C06C24113E67B7BE29255AD")
    
public boolean hasSubMenu() {
        return false;
    }

    /**
     * Called to prepare an associated submenu for the menu item backed by this ActionProvider.
     *
     * <p>if {@link #hasSubMenu()} returns true, this method will be called when the
     * menu item is selected to prepare the submenu for presentation to the user. Apps
     * may use this to create or alter submenu content right before display.
     *
     * @param subMenu Submenu that will be displayed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.129 -0500", hash_original_method = "F59137EC2C0A4379BE18A71AFD20A9D8", hash_generated_method = "50D6E1FB8293636D3A3A82EEB44F6E67")
    
public void onPrepareSubMenu(SubMenu subMenu) {
    }

    /**
     * Notify the system that the visibility of an action view's sub-UI such as
     * an anchored popup has changed. This will affect how other system
     * visibility notifications occur.
     *
     * @hide Pending future API approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.131 -0500", hash_original_method = "486EC9DD7EB4D66CD412B7154F65545B", hash_generated_method = "DB9BE510AE24969A41145DFA8A4FE64E")
    
public void subUiVisibilityChanged(boolean isVisible) {
        if (mSubUiVisibilityListener != null) {
            mSubUiVisibilityListener.onSubUiVisibilityChanged(isVisible);
        }
    }

    /**
     * @hide Internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.133 -0500", hash_original_method = "D36B582FBFECE681E89AD6546A9F8E0B", hash_generated_method = "4AF91025E5612C10D13FC03AB2FFE231")
    
public void setSubUiVisibilityListener(SubUiVisibilityListener listener) {
        mSubUiVisibilityListener = listener;
    }

    
    public interface SubUiVisibilityListener {
        public void onSubUiVisibilityChanged(boolean isVisible);
    }
    
}

