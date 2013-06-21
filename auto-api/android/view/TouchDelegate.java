package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class TouchDelegate {
    private View mDelegateView;
    private Rect mBounds;
    private Rect mSlopBounds;
    private boolean mDelegateTargeted;
    private int mSlop;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.535 -0400", hash_original_method = "2AE60462A7E1E4F15EA63DC7A4583FF5", hash_generated_method = "1AFD84BECC78C8390BF6887486A68DDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TouchDelegate(Rect bounds, View delegateView) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(delegateView.dsTaint);
        mSlop = ViewConfiguration.get(delegateView.getContext()).getScaledTouchSlop();
        mSlopBounds = new Rect(bounds);
        mSlopBounds.inset(-mSlop, -mSlop);
        // ---------- Original Method ----------
        //mBounds = bounds;
        //mSlop = ViewConfiguration.get(delegateView.getContext()).getScaledTouchSlop();
        //mSlopBounds = new Rect(bounds);
        //mSlopBounds.inset(-mSlop, -mSlop);
        //mDelegateView = delegateView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.535 -0400", hash_original_method = "2299D41C6782643B71D7B9FD20834200", hash_generated_method = "F5A0BF12E6EB6378AD312A8E9C7A1945")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        int x;
        x = (int)event.getX();
        int y;
        y = (int)event.getY();
        boolean sendToDelegate;
        sendToDelegate = false;
        boolean hit;
        hit = true;
        boolean handled;
        handled = false;
        {
            Object var9E1FBD251DF7E53AB77C3A31F15B2B38_2068191865 = (event.getAction());
            //Begin case MotionEvent.ACTION_DOWN 
            Rect bounds;
            bounds = mBounds;
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            {
                boolean varDC2352C669FC09CCD790BAAA9357FEC5_1891690218 = (bounds.contains(x, y));
                {
                    mDelegateTargeted = true;
                    sendToDelegate = true;
                } //End block
            } //End collapsed parenthetic
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_UP MotionEvent.ACTION_MOVE 
            sendToDelegate = mDelegateTargeted;
            //End case MotionEvent.ACTION_UP MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_UP MotionEvent.ACTION_MOVE 
            {
                Rect slopBounds;
                slopBounds = mSlopBounds;
                {
                    boolean var98DAB1B1DECC1E7F75066230092D6563_1249170370 = (!slopBounds.contains(x, y));
                    {
                        hit = false;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case MotionEvent.ACTION_UP MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_CANCEL 
            sendToDelegate = mDelegateTargeted;
            //End case MotionEvent.ACTION_CANCEL 
            //Begin case MotionEvent.ACTION_CANCEL 
            mDelegateTargeted = false;
            //End case MotionEvent.ACTION_CANCEL 
        } //End collapsed parenthetic
        {
            View delegateView;
            delegateView = mDelegateView;
            {
                event.setLocation(delegateView.getWidth() / 2, delegateView.getHeight() / 2);
            } //End block
            {
                int slop;
                slop = mSlop;
                event.setLocation(-(slop * 2), -(slop * 2));
            } //End block
            handled = delegateView.dispatchTouchEvent(event);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static final int ABOVE = 1;
    public static final int BELOW = 2;
    public static final int TO_LEFT = 4;
    public static final int TO_RIGHT = 8;
}

