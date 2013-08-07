package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Rect;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.util.AttributeSet;
import android.widget.LinearLayout;
public class LinearLayoutWithDefaultTouchRecepient extends LinearLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.525 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.526 -0400", hash_original_field = "1C1EA1A247F46C22FCF0FDCDD1F75B14", hash_generated_field = "9013D5427373B03358CA3688A21098E3")

    private View mDefaultTouchRecepient;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.526 -0400", hash_original_method = "E188E8AB3661E399A44D50AF9815EEFE", hash_generated_method = "276373CFF04938D0E130F604D859E0EC")
    public  LinearLayoutWithDefaultTouchRecepient(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.527 -0400", hash_original_method = "3540646B733AE63BE737539F6886282F", hash_generated_method = "2A88CA057002003E88A755B67E0096BD")
    public  LinearLayoutWithDefaultTouchRecepient(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.528 -0400", hash_original_method = "748B080B34B17F70D1B458BBDEF2A769", hash_generated_method = "72E65485CEF2FF35AC5604B13C48937C")
    public void setDefaultTouchRecepient(View defaultTouchRecepient) {
        addTaint(defaultTouchRecepient.getTaint());
mDefaultTouchRecepient=defaultTouchRecepient
        // ---------- Original Method ----------
        //mDefaultTouchRecepient = defaultTouchRecepient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.529 -0400", hash_original_method = "2BCD2ADF408352E470479B3FDDE3A575", hash_generated_method = "522A3C060498778A14025AC6F4469DEF")
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        addTaint(ev.getTaint());
        if(mDefaultTouchRecepient==null)        
        {
            boolean var0AC5BA914EBA28873DD435FB4415A279_1643233221 = (super.dispatchTouchEvent(ev));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141672368 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_141672368;
        } //End block
        if(super.dispatchTouchEvent(ev))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1268254230 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1417576482 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1417576482;
        } //End block
mTempRect.set(0, 0, 0, 0)offsetRectIntoDescendantCoords(mDefaultTouchRecepient, mTempRect)ev.setLocation(ev.getX()+mTempRect.left, ev.getY()+mTempRect.top)        boolean varE478D9CEA66177B297A5D232C546F848_1900454623 = (mDefaultTouchRecepient.dispatchTouchEvent(ev));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1429485035 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1429485035;
        // ---------- Original Method ----------
        //if (mDefaultTouchRecepient == null) {
            //return super.dispatchTouchEvent(ev);
        //}
        //if (super.dispatchTouchEvent(ev)) {
            //return true;
        //}
        //mTempRect.set(0, 0, 0, 0);
        //offsetRectIntoDescendantCoords(mDefaultTouchRecepient, mTempRect);
        //ev.setLocation(ev.getX() + mTempRect.left, ev.getY() + mTempRect.top);
        //return mDefaultTouchRecepient.dispatchTouchEvent(ev);
    }

    
}

