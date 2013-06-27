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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.796 -0400", hash_original_field = "6161C99CAA240E7F1DA73FC1A16EB6C7", hash_generated_field = "9399A9196ADA53199056D05EEBB238C5")

    KeyEvent.DispatcherState mDispatcherState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.796 -0400", hash_original_field = "6B97A3575489EA5B3E0E3FCBACC05EED", hash_generated_field = "E67C945376AAE00DB9440E3399BD8397")

    private Rect mBounds = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.797 -0400", hash_original_method = "CB2FD50E46BEAA500E1BA02FF1CB309D", hash_generated_method = "862830495DEED3270CE4D060E0B3C77E")
    public  SoftInputWindow(Context context, int theme,
            KeyEvent.DispatcherState dispatcherState) {
        super(context, theme);
        mDispatcherState = dispatcherState;
        initDockWindow();
        addTaint(context.getTaint());
        addTaint(theme);
        // ---------- Original Method ----------
        //mDispatcherState = dispatcherState;
        //initDockWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.798 -0400", hash_original_method = "DE19D8588D226C63B985BFE529D19F5B", hash_generated_method = "E26DCFA60127C843E9D6161F280B84E7")
    public void setToken(IBinder token) {
        WindowManager.LayoutParams lp;
        lp = getWindow().getAttributes();
        lp.token = token;
        getWindow().setAttributes(lp);
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //WindowManager.LayoutParams lp = getWindow().getAttributes();
        //lp.token = token;
        //getWindow().setAttributes(lp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.798 -0400", hash_original_method = "948733408C213A09362904F3B801CDB6", hash_generated_method = "59E933446D859E78A9DFCA3ACB9A1752")
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onWindowFocusChanged(hasFocus);
        mDispatcherState.reset();
        addTaint(hasFocus);
        // ---------- Original Method ----------
        //super.onWindowFocusChanged(hasFocus);
        //mDispatcherState.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.818 -0400", hash_original_method = "6F026F4BC5B101183B4B9B4DF989B709", hash_generated_method = "4A98DBFA594AC7882511C8A9FF5576DA")
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getWindow().getDecorView().getHitRect(mBounds);
        {
            boolean varE6125949DD9BCF7F5B590BF41FEF9107_463078856 = (ev.isWithinBoundsNoHistory(mBounds.left, mBounds.top,
                mBounds.right - 1, mBounds.bottom - 1));
            {
                boolean varBD2C793D269E3760D25440F90251F71E_1187224311 = (super.dispatchTouchEvent(ev));
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
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2113440679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2113440679;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.819 -0400", hash_original_method = "9B0D08AECE95E0C5A74220E56FAF5BBC", hash_generated_method = "427BB67E0E118EB3FF0DAF123280D6A7")
    public int getSize() {
        WindowManager.LayoutParams lp;
        lp = getWindow().getAttributes();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923473789 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923473789;
        // ---------- Original Method ----------
        //WindowManager.LayoutParams lp = getWindow().getAttributes();
        //if (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM) {
            //return lp.height;
        //} else {
            //return lp.width;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.820 -0400", hash_original_method = "32B4C6FEAFD2BF15DEEB55504FF34518", hash_generated_method = "98F7B092179709E0DBD3C1C6EA2CBE3B")
    public void setSize(int size) {
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
        addTaint(size);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.840 -0400", hash_original_method = "E3269318E29BDA61BD7E82E14CD77997", hash_generated_method = "1EEFACA54543E36CA925CEBA2A9439D6")
    public void setGravity(int gravity) {
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
        addTaint(gravity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.843 -0400", hash_original_method = "F6A5F856FF7B400209C66879FBEA71E5", hash_generated_method = "4AC41C51771A4A810F18DCEEB6129B80")
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

