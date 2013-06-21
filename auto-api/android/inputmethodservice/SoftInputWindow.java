package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;

class SoftInputWindow extends Dialog {
    KeyEvent.DispatcherState mDispatcherState;
    private Rect mBounds = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.427 -0400", hash_original_method = "CB2FD50E46BEAA500E1BA02FF1CB309D", hash_generated_method = "41BA149AA9BFD5C19E3C0E12E00FE76F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SoftInputWindow(Context context, int theme,
            KeyEvent.DispatcherState dispatcherState) {
        super(context, theme);
        dsTaint.addTaint(theme);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(dispatcherState.dsTaint);
        initDockWindow();
        // ---------- Original Method ----------
        //mDispatcherState = dispatcherState;
        //initDockWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.427 -0400", hash_original_method = "DE19D8588D226C63B985BFE529D19F5B", hash_generated_method = "17AEE9C91014F9DD099F848C9F0DECDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setToken(IBinder token) {
        dsTaint.addTaint(token.dsTaint);
        WindowManager.LayoutParams lp;
        lp = getWindow().getAttributes();
        lp.token = token;
        getWindow().setAttributes(lp);
        // ---------- Original Method ----------
        //WindowManager.LayoutParams lp = getWindow().getAttributes();
        //lp.token = token;
        //getWindow().setAttributes(lp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.428 -0400", hash_original_method = "948733408C213A09362904F3B801CDB6", hash_generated_method = "ADF4CC7FBA9AF61F1DD7381256815E41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hasFocus);
        super.onWindowFocusChanged(hasFocus);
        mDispatcherState.reset();
        // ---------- Original Method ----------
        //super.onWindowFocusChanged(hasFocus);
        //mDispatcherState.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.428 -0400", hash_original_method = "6F026F4BC5B101183B4B9B4DF989B709", hash_generated_method = "573842A1B337A780C63E13FD024EC2D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        dsTaint.addTaint(ev.dsTaint);
        getWindow().getDecorView().getHitRect(mBounds);
        {
            boolean varE6125949DD9BCF7F5B590BF41FEF9107_1502583196 = (ev.isWithinBoundsNoHistory(mBounds.left, mBounds.top,
                mBounds.right - 1, mBounds.bottom - 1));
            {
                boolean varBD2C793D269E3760D25440F90251F71E_1531427143 = (super.dispatchTouchEvent(ev));
            } //End block
            {
                MotionEvent temp;
                temp = ev.clampNoHistory(mBounds.left, mBounds.top,
                    mBounds.right - 1, mBounds.bottom - 1);
                boolean handled;
                handled = super.dispatchTouchEvent(temp);
                temp.recycle();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //getWindow().getDecorView().getHitRect(mBounds);
        //if (ev.isWithinBoundsNoHistory(mBounds.left, mBounds.top,
                //mBounds.right - 1, mBounds.bottom - 1)) {
            //return super.dispatchTouchEvent(ev);
        //} else {
            //MotionEvent temp = ev.clampNoHistory(mBounds.left, mBounds.top,
                    //mBounds.right - 1, mBounds.bottom - 1);
            //boolean handled = super.dispatchTouchEvent(temp);
            //temp.recycle();
            //return handled;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.428 -0400", hash_original_method = "9B0D08AECE95E0C5A74220E56FAF5BBC", hash_generated_method = "87C2102BA0B2AD9B4E36B6B5D166B4E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSize() {
        WindowManager.LayoutParams lp;
        lp = getWindow().getAttributes();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //WindowManager.LayoutParams lp = getWindow().getAttributes();
        //if (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM) {
            //return lp.height;
        //} else {
            //return lp.width;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.429 -0400", hash_original_method = "32B4C6FEAFD2BF15DEEB55504FF34518", hash_generated_method = "F87B9B55D1319C78D54712BFD0CD0738")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSize(int size) {
        dsTaint.addTaint(size);
        WindowManager.LayoutParams lp;
        lp = getWindow().getAttributes();
        {
            lp.width = -1;
            lp.height = size;
        } //End block
        {
            lp.width = size;
            lp.height = -1;
        } //End block
        getWindow().setAttributes(lp);
        // ---------- Original Method ----------
        //WindowManager.LayoutParams lp = getWindow().getAttributes();
        //if (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM) {
            //lp.width = -1;
            //lp.height = size;
        //} else {
            //lp.width = size;
            //lp.height = -1;
        //}
        //getWindow().setAttributes(lp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.429 -0400", hash_original_method = "E3269318E29BDA61BD7E82E14CD77997", hash_generated_method = "F6E75265445A72E0F00D93704734C3C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGravity(int gravity) {
        dsTaint.addTaint(gravity);
        WindowManager.LayoutParams lp;
        lp = getWindow().getAttributes();
        boolean oldIsVertical;
        oldIsVertical = (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM);
        lp.gravity = gravity;
        boolean newIsVertical;
        newIsVertical = (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM);
        {
            int tmp;
            tmp = lp.width;
            lp.width = lp.height;
            lp.height = tmp;
            getWindow().setAttributes(lp);
        } //End block
        // ---------- Original Method ----------
        //WindowManager.LayoutParams lp = getWindow().getAttributes();
        //boolean oldIsVertical = (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM);
        //lp.gravity = gravity;
        //boolean newIsVertical = (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM);
        //if (oldIsVertical != newIsVertical) {
            //int tmp = lp.width;
            //lp.width = lp.height;
            //lp.height = tmp;
            //getWindow().setAttributes(lp);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.430 -0400", hash_original_method = "F6A5F856FF7B400209C66879FBEA71E5", hash_generated_method = "4AC41C51771A4A810F18DCEEB6129B80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initDockWindow() {
        WindowManager.LayoutParams lp;
        lp = getWindow().getAttributes();
        lp.type = WindowManager.LayoutParams.TYPE_INPUT_METHOD;
        lp.setTitle("InputMethod");
        lp.gravity = Gravity.BOTTOM;
        lp.width = -1;
        getWindow().setAttributes(lp);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        // ---------- Original Method ----------
        //WindowManager.LayoutParams lp = getWindow().getAttributes();
        //lp.type = WindowManager.LayoutParams.TYPE_INPUT_METHOD;
        //lp.setTitle("InputMethod");
        //lp.gravity = Gravity.BOTTOM;
        //lp.width = -1;
        //getWindow().setAttributes(lp);
        //getWindow().setFlags(
                //WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                //WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                //WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                //WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                //WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    
}

