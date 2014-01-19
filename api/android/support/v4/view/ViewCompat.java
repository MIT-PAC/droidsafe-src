package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class ViewCompat {

    /**
     * Check if this view can be scrolled horizontally in a certain direction.
     *
     * @param v The View against which to invoke the method.
     * @param direction Negative to check scrolling left, positive to check scrolling right.
     * @return true if this view can be scrolled in the specified direction, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.231 -0500", hash_original_method = "857005B1ED2030A6958E9EB0D4C8F4E9", hash_generated_method = "1589EB5E74EE7AEADA18B3309A63800A")
    
public static boolean canScrollHorizontally(View v, int direction) {
        return IMPL.canScrollHorizontally(v, direction);
    }

    /**
     * Check if this view can be scrolled vertically in a certain direction.
     *
     * @param v The View against which to invoke the method.
     * @param direction Negative to check scrolling up, positive to check scrolling down.
     * @return true if this view can be scrolled in the specified direction, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.233 -0500", hash_original_method = "2DFFD160E11AA00CE94741E99122C12E", hash_generated_method = "50EBFE12C5079C61D137C632B3083850")
    
public static boolean canScrollVertically(View v, int direction) {
        return IMPL.canScrollVertically(v, direction);
    }

    /**
     * Returns the over-scroll mode for this view. The result will be
     * one of {@link #OVER_SCROLL_ALWAYS} (default), {@link #OVER_SCROLL_IF_CONTENT_SCROLLS}
     * (allow over-scrolling only if the view content is larger than the container),
     * or {@link #OVER_SCROLL_NEVER}.
     *
     * @param v The View against which to invoke the method.
     * @return This view's over-scroll mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.235 -0500", hash_original_method = "7494BE1D565A64230355951115CC2869", hash_generated_method = "7EEDECBD1D9B7CD261970618A310D03F")
    
public static int getOverScrollMode(View v) {
        return IMPL.getOverScrollMode(v);
    }

    /**
     * Set the over-scroll mode for this view. Valid over-scroll modes are
     * {@link #OVER_SCROLL_ALWAYS} (default), {@link #OVER_SCROLL_IF_CONTENT_SCROLLS}
     * (allow over-scrolling only if the view content is larger than the container),
     * or {@link #OVER_SCROLL_NEVER}.
     *
     * Setting the over-scroll mode of a view will have an effect only if the
     * view is capable of scrolling.
     *
     * @param v The View against which to invoke the method.
     * @param overScrollMode The new over-scroll mode for this view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.238 -0500", hash_original_method = "CFB7431DB4F757CDA816E6FEFF5ADAB6", hash_generated_method = "CF3FF226C5879DDABABCC07C72634DEA")
    
public static void setOverScrollMode(View v, int overScrollMode) {
        IMPL.setOverScrollMode(v, overScrollMode);
    }

    /**
     * Called from {@link View#dispatchPopulateAccessibilityEvent(AccessibilityEvent)}
     * giving a chance to this View to populate the accessibility event with its
     * text content. While this method is free to modify event
     * attributes other than text content, doing so should normally be performed in
     * {@link View#onInitializeAccessibilityEvent(AccessibilityEvent)}.
     * <p>
     * Example: Adding formatted date string to an accessibility event in addition
     *          to the text added by the super implementation:
     * <pre> public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
     *     super.onPopulateAccessibilityEvent(event);
     *     final int flags = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_WEEKDAY;
     *     String selectedDateUtterance = DateUtils.formatDateTime(mContext,
     *         mCurrentDate.getTimeInMillis(), flags);
     *     event.getText().add(selectedDateUtterance);
     * }</pre>
     * <p>
     * If an {@link android.view.View.AccessibilityDelegate} has been specified via calling
     * {@link View#setAccessibilityDelegate(android.view.View.AccessibilityDelegate)} its
     * {@link android.view.View.AccessibilityDelegate#onPopulateAccessibilityEvent(View,
     *  AccessibilityEvent)}
     * is responsible for handling this call.
     * </p>
     * <p class="note"><strong>Note:</strong> Always call the super implementation before adding
     * information to the event, in case the default implementation has basic information to add.
     * </p>
     *
     * @param v The View against which to invoke the method.
     * @param event The accessibility event which to populate.
     *
     * @see View#sendAccessibilityEvent(int)
     * @see View#dispatchPopulateAccessibilityEvent(AccessibilityEvent)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.240 -0500", hash_original_method = "F7A6696474DBC18E9559BE63429BF45C", hash_generated_method = "84312CBDA69652B8F39427C8F4ECFAA9")
    
public static void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
        IMPL.onPopulateAccessibilityEvent(v, event);
    }

    /**
     * Initializes an {@link AccessibilityEvent} with information about
     * this View which is the event source. In other words, the source of
     * an accessibility event is the view whose state change triggered firing
     * the event.
     * <p>
     * Example: Setting the password property of an event in addition
     *          to properties set by the super implementation:
     * <pre> public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
     *     super.onInitializeAccessibilityEvent(event);
     *     event.setPassword(true);
     * }</pre>
     * <p>
     * If an {@link android.view.View.AccessibilityDelegate} has been specified via calling
     * {@link View#setAccessibilityDelegate(android.view.View.AccessibilityDelegate)} its
     * {@link android.view.View.AccessibilityDelegate#onInitializeAccessibilityEvent(View,
     *  AccessibilityEvent)}
     * is responsible for handling this call.
     * </p>
     * <p class="note"><strong>Note:</strong> Always call the super implementation before adding
     * information to the event, in case the default implementation has basic information to add.
     * </p>
     *
     * @param v The View against which to invoke the method.
     * @param event The event to initialize.
     *
     * @see View#sendAccessibilityEvent(int)
     * @see View#dispatchPopulateAccessibilityEvent(AccessibilityEvent)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.242 -0500", hash_original_method = "ED19022FEB94C3A5867003FD25E7BFF2", hash_generated_method = "DAA6BC4411CAEFEBE90A13CE6A87A9F3")
    
public static void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
        IMPL.onInitializeAccessibilityEvent(v, event);
    }

    /**
     * Initializes an {@link android.view.accessibility.AccessibilityNodeInfo} with information
     * about this view. The base implementation sets:
     * <ul>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setParent(View)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setBoundsInParent(Rect)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setBoundsInScreen(Rect)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setPackageName(CharSequence)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setClassName(CharSequence)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setContentDescription(CharSequence)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setEnabled(boolean)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setClickable(boolean)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setFocusable(boolean)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setFocused(boolean)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setLongClickable(boolean)},</li>
     * <li>{@link android.view.accessibility.AccessibilityNodeInfo#setSelected(boolean)},</li>
     * </ul>
     * <p>
     * Subclasses should override this method, call the super implementation,
     * and set additional attributes.
     * </p>
     * <p>
     * If an {@link android.view.View.AccessibilityDelegate} has been specified via calling
     * {@link View#setAccessibilityDelegate(android.view.View.AccessibilityDelegate)} its
     * {@link android.view.View.AccessibilityDelegate#onInitializeAccessibilityNodeInfo(View,
     *  android.view.accessibility.AccessibilityNodeInfo)}
     * is responsible for handling this call.
     * </p>
     *
     * @param v The View against which to invoke the method.
     * @param info The instance to initialize.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.244 -0500", hash_original_method = "73AA4AFD15DD1C9DB48D7754FEBFC0EB", hash_generated_method = "FB6FC5466D59E9C530E92CA40A2B6091")
    
public static void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
        IMPL.onInitializeAccessibilityNodeInfo(v, info);
    }

    /**
     * Sets a delegate for implementing accessibility support via compositon as
     * opposed to inheritance. The delegate's primary use is for implementing
     * backwards compatible widgets. For more details see
     * {@link android.view.View.AccessibilityDelegate}.
     *
     * @param v The View against which to invoke the method.
     * @param delegate The delegate instance.
     *
     * @see android.view.View.AccessibilityDelegate
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.247 -0500", hash_original_method = "4280E8CA0A8375D977DD927F0A6FE108", hash_generated_method = "FDC098EF58DE2FA81B05DBE4DBC3A2B4")
    
public static void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
        IMPL.setAccessibilityDelegate(v, delegate);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.170 -0500", hash_original_field = "361BC31D07AD9559F194AE7DCEA363BD", hash_generated_field = "8F276B4C86F06142AEDE0C97A7FE2F68")

    public static final int OVER_SCROLL_ALWAYS = 0;
    
    static class BaseViewCompatImpl implements ViewCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.378 -0400", hash_original_method = "41ADABC234167BF75948986C00D7164F", hash_generated_method = "41ADABC234167BF75948986C00D7164F")
        public BaseViewCompatImpl ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.182 -0500", hash_original_method = "B6398682E53A0553C234AF7A57520A50", hash_generated_method = "EC52BD673A8A1DFB598530FEE02BC621")
        
public boolean canScrollHorizontally(View v, int direction) {
            return false;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.184 -0500", hash_original_method = "503E40CFCA77F79E3DB90A02CF27CB11", hash_generated_method = "EB4457FE31B4CA7CB9E56A0C68DE8CB2")
        
public boolean canScrollVertically(View v, int direction) {
            return false;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.187 -0500", hash_original_method = "FE606A273B3E1C6F88C42FF299410004", hash_generated_method = "890B5796081B46FF597A274F07AF8436")
        
public int getOverScrollMode(View v) {
            return OVER_SCROLL_NEVER;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.189 -0500", hash_original_method = "6EF0161350C522C30619CD84403B6E93", hash_generated_method = "1B9D8A0D63FED987F7D3E7568CF10267")
        
public void setOverScrollMode(View v, int mode) {
            // Do nothing; API doesn't exist
        }
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.191 -0500", hash_original_method = "122EA5B596C8B5B38E62AE02215B1570", hash_generated_method = "6A75086B4569BF9320FFF3DCBB097973")
        
public void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
            // Do nothing; API doesn't exist
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.193 -0500", hash_original_method = "702F7E45C5537D15A13A9B08A18B3D2B", hash_generated_method = "1AAE3B95D65D181D322DC25A382F96F0")
        
public void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
            // Do nothing; API doesn't exist
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.196 -0500", hash_original_method = "9137ED0A1BFDD4FC8792E5A61DC6F04E", hash_generated_method = "0AF026B09E04A57D7822E5EA1882E324")
        
public void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
         // Do nothing; API doesn't exist
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.198 -0500", hash_original_method = "E0BDF5AA116BC42106585B9B041EC074", hash_generated_method = "F84B90D5133E1CA07202C18A7694EC18")
        
public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
            // Do nothing; API doesn't exist
        }
        
    }
    
    static class GBViewCompatImpl extends BaseViewCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.379 -0400", hash_original_method = "B29ABB75D45C38E68F6507295346B5B9", hash_generated_method = "B29ABB75D45C38E68F6507295346B5B9")
        public GBViewCompatImpl ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.203 -0500", hash_original_method = "6AE192D9CDFE24BE71EEBB7861AC5739", hash_generated_method = "0C0ADB431B7100476CC4C6699008B03D")
        
@Override
        public int getOverScrollMode(View v) {
            return ViewCompatGingerbread.getOverScrollMode(v);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.206 -0500", hash_original_method = "652BCFC6DB6C20C8D62EA02A6E673E41", hash_generated_method = "9117A5D7A58C42D1C941C41CE6A38EE4")
        
@Override
        public void setOverScrollMode(View v, int mode) {
            ViewCompatGingerbread.setOverScrollMode(v, mode);
        }
        
    }
    
    static class ICSViewCompatImpl extends GBViewCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.379 -0400", hash_original_method = "F82CC7286340E827BB3F02C5F17E58C8", hash_generated_method = "F82CC7286340E827BB3F02C5F17E58C8")
        public ICSViewCompatImpl ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.211 -0500", hash_original_method = "C9BAAD76CDA8C75C5F08B6168D212799", hash_generated_method = "3CEAC2A53D62D05F05A47A06606C2096")
        
@Override
        public boolean canScrollHorizontally(View v, int direction) {
            return ViewCompatICS.canScrollHorizontally(v, direction);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.213 -0500", hash_original_method = "C0DBA3C69AA17D8232DF13575A7B0094", hash_generated_method = "2E1B647418EEF8C4FA003FCB16348076")
        
@Override
        public boolean canScrollVertically(View v, int direction) {
            return ViewCompatICS.canScrollVertically(v, direction);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.216 -0500", hash_original_method = "30706FC93A804D8A8DC1FCFB98D98BAD", hash_generated_method = "B93FEA14A408EBCD0D48743CB66955C7")
        
@Override
        public void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
            ViewCompatICS.onPopulateAccessibilityEvent(v, event);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.218 -0500", hash_original_method = "D787101BC5F3E4F3C49A8D686CC81288", hash_generated_method = "504A8E205D66CECC86D89B6CD6A7F1A4")
        
@Override
        public void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
            ViewCompatICS.onInitializeAccessibilityEvent(v, event);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.220 -0500", hash_original_method = "766209C343FE76A0076A6D65E22F224A", hash_generated_method = "31C055B075DDB651D68502DBE7220192")
        
@Override
        public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
            ViewCompatICS.onInitializeAccessibilityNodeInfo(v, info.getImpl());
        }
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.224 -0500", hash_original_method = "256253E870D0A3AB828902545E88A8B8", hash_generated_method = "F1CD4EE679299C08237982AF52A9291D")
        
@Override
        public void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate) {
            ViewCompatICS.setAccessibilityDelegate(v, delegate.getBridge());
        }
        
    }
    
    interface ViewCompatImpl {
        public boolean canScrollHorizontally(View v, int direction);
        public boolean canScrollVertically(View v, int direction);
        public int getOverScrollMode(View v);
        public void setOverScrollMode(View v, int mode);
        public void onInitializeAccessibilityEvent(View v, AccessibilityEvent event);
        public void onPopulateAccessibilityEvent(View v, AccessibilityEvent event);
        public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info);
        public void setAccessibilityDelegate(View v, AccessibilityDelegateCompat delegate);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.172 -0500", hash_original_field = "CC647B45C45ACE646CE989AEBDB00745", hash_generated_field = "218BFE0FF46A804B55589DCE0FFD7D0A")

    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.175 -0500", hash_original_field = "F3053BB78DC68F981F29ECFBD3977D87", hash_generated_field = "009B55485034BF3BF55F8691DA9788F7")

    public static final int OVER_SCROLL_NEVER = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.228 -0500", hash_original_field = "8C7B75196624F10657FDCEE6792BBCF8", hash_generated_field = "BBDF66702D3CCA930AA785B97237B8E4")

    static  ViewCompatImpl IMPL;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.357 -0400", hash_original_method = "2D3AD98427119C7C46265965AF02446D", hash_generated_method = "2D3AD98427119C7C46265965AF02446D")
    public ViewCompat ()
    {
        //Synthesized constructor
    }
    static {
        final int version = android.os.Build.VERSION.SDK_INT;
        if (version >= 14) {
            IMPL = new ICSViewCompatImpl();
        } else if (version >= 9) {
            IMPL = new GBViewCompatImpl();
        } else {
            IMPL = new BaseViewCompatImpl();
        }
    }
    
}

