package android.inputmethodservice;

// Droidsafe Imports
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

class SoftInputWindow extends Dialog {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.720 -0400", hash_original_field = "6161C99CAA240E7F1DA73FC1A16EB6C7", hash_generated_field = "9399A9196ADA53199056D05EEBB238C5")

    KeyEvent.DispatcherState mDispatcherState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.720 -0400", hash_original_field = "6B97A3575489EA5B3E0E3FCBACC05EED", hash_generated_field = "FD1FEF375C4015D208B59BBFA039409F")

    private final Rect mBounds = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.721 -0400", hash_original_method = "CB2FD50E46BEAA500E1BA02FF1CB309D", hash_generated_method = "C08CC9CDBFE0CEFADDDDA69BB1196A6E")
    public  SoftInputWindow(Context context, int theme,
            KeyEvent.DispatcherState dispatcherState) {
        super(context, theme);
        addTaint(theme);
        addTaint(context.getTaint());
        mDispatcherState = dispatcherState;
        initDockWindow();
        // ---------- Original Method ----------
        //mDispatcherState = dispatcherState;
        //initDockWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.722 -0400", hash_original_method = "DE19D8588D226C63B985BFE529D19F5B", hash_generated_method = "3DD77546C15F9DBFED14065D727E6BCF")
    public void setToken(IBinder token) {
        addTaint(token.getTaint());
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.token = token;
        getWindow().setAttributes(lp);
        // ---------- Original Method ----------
        //WindowManager.LayoutParams lp = getWindow().getAttributes();
        //lp.token = token;
        //getWindow().setAttributes(lp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.723 -0400", hash_original_method = "948733408C213A09362904F3B801CDB6", hash_generated_method = "B5F2DB3250F2B92BDCA70602F47589FC")
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasFocus);
        super.onWindowFocusChanged(hasFocus);
        mDispatcherState.reset();
        // ---------- Original Method ----------
        //super.onWindowFocusChanged(hasFocus);
        //mDispatcherState.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.724 -0400", hash_original_method = "6F026F4BC5B101183B4B9B4DF989B709", hash_generated_method = "506BA68DD68B2C5F873965BAD39A22B1")
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        addTaint(ev.getTaint());
        getWindow().getDecorView().getHitRect(mBounds);
        if(ev.isWithinBoundsNoHistory(mBounds.left, mBounds.top,
                mBounds.right - 1, mBounds.bottom - 1))        
        {
            boolean var0AC5BA914EBA28873DD435FB4415A279_1967738751 = (super.dispatchTouchEvent(ev));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1452736029 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1452736029;
        } //End block
        else
        {
            MotionEvent temp = ev.clampNoHistory(mBounds.left, mBounds.top,
                    mBounds.right - 1, mBounds.bottom - 1);
            boolean handled = super.dispatchTouchEvent(temp);
            temp.recycle();
            boolean var98F0599AF776A1FE4101C199A40EEB8F_521340710 = (handled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1005568755 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1005568755;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.726 -0400", hash_original_method = "9B0D08AECE95E0C5A74220E56FAF5BBC", hash_generated_method = "EFCB2AF638FF2BBADDA5D21DE70E61A9")
    public int getSize() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        if(lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM)        
        {
            int varA2D6938A1C0A96A8D22F91742A9CC5AF_1769543438 = (lp.height);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1642272412 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1642272412;
        } //End block
        else
        {
            int varB92844C9728F4F6404D40D8D6C824656_1564239172 = (lp.width);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_248511372 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_248511372;
        } //End block
        // ---------- Original Method ----------
        //WindowManager.LayoutParams lp = getWindow().getAttributes();
        //if (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM) {
            //return lp.height;
        //} else {
            //return lp.width;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.728 -0400", hash_original_method = "32B4C6FEAFD2BF15DEEB55504FF34518", hash_generated_method = "4519B4F621BAE688C57F4986952285B9")
    public void setSize(int size) {
        addTaint(size);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        if(lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM)        
        {
            lp.width = -1;
            lp.height = size;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.730 -0400", hash_original_method = "E3269318E29BDA61BD7E82E14CD77997", hash_generated_method = "9E19C0A9422BE2C41D9C8B53D72561B4")
    public void setGravity(int gravity) {
        addTaint(gravity);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        boolean oldIsVertical = (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM);
        lp.gravity = gravity;
        boolean newIsVertical = (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM);
        if(oldIsVertical != newIsVertical)        
        {
            int tmp = lp.width;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.731 -0400", hash_original_method = "F6A5F856FF7B400209C66879FBEA71E5", hash_generated_method = "B05844D7C519B2E8DE79B7249DC21DFD")
    private void initDockWindow() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
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

