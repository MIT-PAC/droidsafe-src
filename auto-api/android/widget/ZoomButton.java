package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;

public class ZoomButton extends ImageButton implements OnLongClickListener {
    private Handler mHandler;
    private final Runnable mRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.792 -0400", hash_original_method = "93C4F1AB03EDEC29398EF344D9566441", hash_generated_method = "296E1CAB6047B58975A71E2DE7350778")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                boolean var5A1FF320AD44FFAE161220CEF22196E1_1975341151 = (hasOnClickListeners() && mIsInLongpress && isEnabled());
                {
                    callOnClick();
                    mHandler.postDelayed(this, mZoomSpeed);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (hasOnClickListeners() && mIsInLongpress && isEnabled()) {
                //callOnClick();
                //mHandler.postDelayed(this, mZoomSpeed);
            //}
        }

        
}; //Transformed anonymous class
    private long mZoomSpeed = 1000;
    private boolean mIsInLongpress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.792 -0400", hash_original_method = "FE073AFFD3994A95FEC890EBCF528CD3", hash_generated_method = "59706580FEC514756C4487DEE3097FE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ZoomButton(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.792 -0400", hash_original_method = "2E206A8DD55CDB4EE0CBFCA63CB6A076", hash_generated_method = "A93A51AAB78D2B7E324D77514025A6DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ZoomButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.793 -0400", hash_original_method = "C3304F204963574721B46CA6BEC245F6", hash_generated_method = "450BD2A469A98B720D9C6699620C9E42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ZoomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        mHandler = new Handler();
        setOnLongClickListener(this);
        // ---------- Original Method ----------
        //mHandler = new Handler();
        //setOnLongClickListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.793 -0400", hash_original_method = "6BCA096FD56C8C78BA7791883B013378", hash_generated_method = "E330491B9C78918DAD213CEB5FA6F0D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var20894F4854ED8A9DE007EB6B4F2C907D_373393311 = ((event.getAction() == MotionEvent.ACTION_CANCEL)
                || (event.getAction() == MotionEvent.ACTION_UP));
            {
                mIsInLongpress = false;
            } //End block
        } //End collapsed parenthetic
        boolean var5D1E90CB51451ACDF0A3114FBC92AA76_1938107199 = (super.onTouchEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ((event.getAction() == MotionEvent.ACTION_CANCEL)
                //|| (event.getAction() == MotionEvent.ACTION_UP)) {
            //mIsInLongpress = false;
        //}
        //return super.onTouchEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.793 -0400", hash_original_method = "DEDF5C76C1376B1670A66754E8A8EB41", hash_generated_method = "D56F08BE2C9A468792757EEF7D5EF37E")
    @DSModeled(DSC.SAFE)
    public void setZoomSpeed(long speed) {
        dsTaint.addTaint(speed);
        // ---------- Original Method ----------
        //mZoomSpeed = speed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.793 -0400", hash_original_method = "26BCB5A69421DEBA679FF4C8B6DA9672", hash_generated_method = "9BE30F942A6B0DE9C14120D0B34D9386")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onLongClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        mIsInLongpress = true;
        mHandler.post(mRunnable);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mIsInLongpress = true;
        //mHandler.post(mRunnable);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.794 -0400", hash_original_method = "BFA7CE14F9602D57E8995DEC9C69E7C5", hash_generated_method = "3249ACA58FA604774687167023D579BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        mIsInLongpress = false;
        boolean varEDD771EBF66425AD21882AB08CD0EE48_481848561 = (super.onKeyUp(keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mIsInLongpress = false;
        //return super.onKeyUp(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.794 -0400", hash_original_method = "46BB6036120D403ECAC10DF2C7F6C840", hash_generated_method = "F53B3803E89F27C5C687C24FC783FC21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            setPressed(false);
        } //End block
        super.setEnabled(enabled);
        // ---------- Original Method ----------
        //if (!enabled) {
            //setPressed(false);
        //}
        //super.setEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.794 -0400", hash_original_method = "F8B564AE722FC7E23EAA2F8FF5648A4E", hash_generated_method = "7F9DE509D2E4C13FCF44218A1BC21C0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focused.dsTaint);
        clearFocus();
        boolean var7806FDB90C43580BB08977F76E469BBD_1076988759 = (super.dispatchUnhandledMove(focused, direction));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //clearFocus();
        //return super.dispatchUnhandledMove(focused, direction);
    }

    
}

