package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;

class SoftInputWindow extends Dialog {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.292 -0500", hash_original_field = "9399A9196ADA53199056D05EEBB238C5", hash_generated_field = "9399A9196ADA53199056D05EEBB238C5")

     KeyEvent.DispatcherState mDispatcherState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.294 -0500", hash_original_field = "811AC12DD4794990F0DFD3FA5A6E3596", hash_generated_field = "FD1FEF375C4015D208B59BBFA039409F")

    private final Rect mBounds = new Rect();
    
    /**
     * Create a SoftInputWindow that uses a custom style.
     * 
     * @param context The Context in which the DockWindow should run. In
     *        particular, it uses the window manager and theme from this context
     *        to present its UI.
     * @param theme A style resource describing the theme to use for the window.
     *        See <a href="{@docRoot}reference/available-resources.html#stylesandthemes">Style
     *        and Theme Resources</a> for more information about defining and
     *        using styles. This theme is applied on top of the current theme in
     *        <var>context</var>. If 0, the default dialog theme will be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.299 -0500", hash_original_method = "CB2FD50E46BEAA500E1BA02FF1CB309D", hash_generated_method = "866E681A0EB1161DFEB42CAAEEE0D322")
    
public SoftInputWindow(Context context, int theme,
            KeyEvent.DispatcherState dispatcherState) {
        super(context, theme);
        mDispatcherState = dispatcherState;
        initDockWindow();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.296 -0500", hash_original_method = "DE19D8588D226C63B985BFE529D19F5B", hash_generated_method = "11804B63B2CE474CFF3B870BDE7A3472")
    
public void setToken(IBinder token) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.token = token;
        getWindow().setAttributes(lp);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.301 -0500", hash_original_method = "948733408C213A09362904F3B801CDB6", hash_generated_method = "C694054C01189B209F9485319EE96FDD")
    
@Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mDispatcherState.reset();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.303 -0500", hash_original_method = "6F026F4BC5B101183B4B9B4DF989B709", hash_generated_method = "6144BFD87538941E1F92436B10165D0F")
    
@Override
@DSSafe(DSCat.SAFE_LIST)
@DSVerified
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getWindow().getDecorView().getHitRect(mBounds);

        if (ev.isWithinBoundsNoHistory(mBounds.left, mBounds.top,
                mBounds.right - 1, mBounds.bottom - 1)) {
            return super.dispatchTouchEvent(ev);
        } else {
            MotionEvent temp = ev.clampNoHistory(mBounds.left, mBounds.top,
                    mBounds.right - 1, mBounds.bottom - 1);
            boolean handled = super.dispatchTouchEvent(temp);
            temp.recycle();
            return handled;
        }
    }

    /**
     * Get the size of the DockWindow.
     * 
     * @return If the DockWindow sticks to the top or bottom of the screen, the
     *         return value is the height of the DockWindow, and its width is
     *         equal to the width of the screen; If the DockWindow sticks to the
     *         left or right of the screen, the return value is the width of the
     *         DockWindow, and its height is equal to the height of the screen.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.306 -0500", hash_original_method = "9B0D08AECE95E0C5A74220E56FAF5BBC", hash_generated_method = "84D9F3DE530E5E1790C30F09F0BAF092")
    
public int getSize() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();

        if (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM) {
            return lp.height;
        } else {
            return lp.width;
        }
    }

    /**
     * Set the size of the DockWindow.
     * 
     * @param size If the DockWindow sticks to the top or bottom of the screen,
     *        <var>size</var> is the height of the DockWindow, and its width is
     *        equal to the width of the screen; If the DockWindow sticks to the
     *        left or right of the screen, <var>size</var> is the width of the
     *        DockWindow, and its height is equal to the height of the screen.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.308 -0500", hash_original_method = "32B4C6FEAFD2BF15DEEB55504FF34518", hash_generated_method = "CE4ACDFC593561B0DC6143C8CA390B37")
    
public void setSize(int size) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();

        if (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM) {
            lp.width = -1;
            lp.height = size;
        } else {
            lp.width = size;
            lp.height = -1;
        }
        getWindow().setAttributes(lp);
    }

    /**
     * Set which boundary of the screen the DockWindow sticks to.
     * 
     * @param gravity The boundary of the screen to stick. See {#link
     *        android.view.Gravity.LEFT}, {#link android.view.Gravity.TOP},
     *        {#link android.view.Gravity.BOTTOM}, {#link
     *        android.view.Gravity.RIGHT}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.310 -0500", hash_original_method = "E3269318E29BDA61BD7E82E14CD77997", hash_generated_method = "744CD09F96B73C6C3E8D64B184A2F315")
    
public void setGravity(int gravity) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();

        boolean oldIsVertical = (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM);

        lp.gravity = gravity;

        boolean newIsVertical = (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM);

        if (oldIsVertical != newIsVertical) {
            int tmp = lp.width;
            lp.width = lp.height;
            lp.height = tmp;
            getWindow().setAttributes(lp);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.313 -0500", hash_original_method = "F6A5F856FF7B400209C66879FBEA71E5", hash_generated_method = "BA5D9FD9FB5F6F4D54CA580065F93831")
    
private void initDockWindow() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();

        lp.type = WindowManager.LayoutParams.TYPE_INPUT_METHOD;
        lp.setTitle("InputMethod");

        lp.gravity = Gravity.BOTTOM;
        lp.width = -1;
        // Let the input method window's orientation follow sensor based rotation
        // Turn this off for now, it is very problematic.
        //lp.screenOrientation = ActivityInfo.SCREEN_ORIENTATION_USER;

        getWindow().setAttributes(lp);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }
    
}

