package android.inputmethodservice;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.931 -0400", hash_original_field = "6161C99CAA240E7F1DA73FC1A16EB6C7", hash_generated_field = "9399A9196ADA53199056D05EEBB238C5")

    KeyEvent.DispatcherState mDispatcherState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.931 -0400", hash_original_field = "6B97A3575489EA5B3E0E3FCBACC05EED", hash_generated_field = "FD1FEF375C4015D208B59BBFA039409F")

    private final Rect mBounds = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.931 -0400", hash_original_method = "CB2FD50E46BEAA500E1BA02FF1CB309D", hash_generated_method = "862830495DEED3270CE4D060E0B3C77E")
    public  SoftInputWindow(Context context, int theme,
            KeyEvent.DispatcherState dispatcherState) {
        super(context, theme);
        mDispatcherState = dispatcherState;
        initDockWindow();
        addTaint(context.getTaint());
        addTaint(theme);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.932 -0400", hash_original_method = "DE19D8588D226C63B985BFE529D19F5B", hash_generated_method = "D0A7E0EE4AA6255A0E6174F311E12FED")
    public void setToken(IBinder token) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.token = token;
        getWindow().setAttributes(lp);
        addTaint(token.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.932 -0400", hash_original_method = "948733408C213A09362904F3B801CDB6", hash_generated_method = "59E933446D859E78A9DFCA3ACB9A1752")
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        
        super.onWindowFocusChanged(hasFocus);
        mDispatcherState.reset();
        addTaint(hasFocus);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.933 -0400", hash_original_method = "6F026F4BC5B101183B4B9B4DF989B709", hash_generated_method = "BF01140BB442053829B15816A5AC6B7E")
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getWindow().getDecorView().getHitRect(mBounds);
        {
            boolean varE6125949DD9BCF7F5B590BF41FEF9107_2111854738 = (ev.isWithinBoundsNoHistory(mBounds.left, mBounds.top,
                mBounds.right - 1, mBounds.bottom - 1));
            {
                boolean varBD2C793D269E3760D25440F90251F71E_641666567 = (super.dispatchTouchEvent(ev));
            } 
            {
                MotionEvent temp = ev.clampNoHistory(mBounds.left, mBounds.top,
                    mBounds.right - 1, mBounds.bottom - 1);
                boolean handled = super.dispatchTouchEvent(temp);
                temp.recycle();
            } 
        } 
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_575162586 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_575162586;
        
        
        
                
            
        
            
                    
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.933 -0400", hash_original_method = "9B0D08AECE95E0C5A74220E56FAF5BBC", hash_generated_method = "DCEF516A44D721B7699617C7252FC38D")
    public int getSize() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401309903 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401309903;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.934 -0400", hash_original_method = "32B4C6FEAFD2BF15DEEB55504FF34518", hash_generated_method = "43349AFDE285C2BA9E322BE2420817EF")
    public void setSize(int size) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        {
            lp.width = -1;
            lp.height = size;
        } 
        {
            lp.width = size;
            lp.height = -1;
        } 
        getWindow().setAttributes(lp);
        addTaint(size);
        
        
        
            
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.934 -0400", hash_original_method = "E3269318E29BDA61BD7E82E14CD77997", hash_generated_method = "BDEC88404F95DA50AC4F5E5D8D0D6B69")
    public void setGravity(int gravity) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        boolean oldIsVertical = (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM);
        lp.gravity = gravity;
        boolean newIsVertical = (lp.gravity == Gravity.TOP || lp.gravity == Gravity.BOTTOM);
        {
            int tmp = lp.width;
            lp.width = lp.height;
            lp.height = tmp;
            getWindow().setAttributes(lp);
        } 
        addTaint(gravity);
        
        
        
        
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.935 -0400", hash_original_method = "F6A5F856FF7B400209C66879FBEA71E5", hash_generated_method = "B05844D7C519B2E8DE79B7249DC21DFD")
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
        
        
        
        
        
        
        
        
                
                
                
                
                
    }

    
}

