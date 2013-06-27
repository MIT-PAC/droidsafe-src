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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.446 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.447 -0400", hash_original_field = "65BDCBCF196E90740F940F290BEFAB2D", hash_generated_field = "E67A1D40F622C663E7244033629F6440")

    private Runnable mRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.447 -0400", hash_original_method = "93C4F1AB03EDEC29398EF344D9566441", hash_generated_method = "38ED3E205B14079C0DE8612B758474EC")
        public void run() {
            {
                boolean var5A1FF320AD44FFAE161220CEF22196E1_893735133 = (hasOnClickListeners() && mIsInLongpress && isEnabled());
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

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.447 -0400", hash_original_field = "10523967FB2F80A5680451244507ED0E", hash_generated_field = "EEAD05CCF97EA02687293998A0924A76")

    private long mZoomSpeed = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.447 -0400", hash_original_field = "3435F341BF12B5AA17C422C22C3B5E6C", hash_generated_field = "D784F636C36BABB7864D79722AD46F05")

    private boolean mIsInLongpress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.447 -0400", hash_original_method = "FE073AFFD3994A95FEC890EBCF528CD3", hash_generated_method = "426FFB99417CD80A6D4D96B16656C7ED")
    public  ZoomButton(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.448 -0400", hash_original_method = "2E206A8DD55CDB4EE0CBFCA63CB6A076", hash_generated_method = "4934EB9D4FDABAE4504140DD295600E3")
    public  ZoomButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.448 -0400", hash_original_method = "C3304F204963574721B46CA6BEC245F6", hash_generated_method = "8298FBB655E9B9F98D5F0C15D47855D3")
    public  ZoomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mHandler = new Handler();
        setOnLongClickListener(this);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        //mHandler = new Handler();
        //setOnLongClickListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.448 -0400", hash_original_method = "6BCA096FD56C8C78BA7791883B013378", hash_generated_method = "40F8DCCFE441A5A2F77278AF4DDACC78")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var20894F4854ED8A9DE007EB6B4F2C907D_1236049240 = ((event.getAction() == MotionEvent.ACTION_CANCEL)
                || (event.getAction() == MotionEvent.ACTION_UP));
            {
                mIsInLongpress = false;
            } //End block
        } //End collapsed parenthetic
        boolean var5D1E90CB51451ACDF0A3114FBC92AA76_74142894 = (super.onTouchEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1826336168 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1826336168;
        // ---------- Original Method ----------
        //if ((event.getAction() == MotionEvent.ACTION_CANCEL)
                //|| (event.getAction() == MotionEvent.ACTION_UP)) {
            //mIsInLongpress = false;
        //}
        //return super.onTouchEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.449 -0400", hash_original_method = "DEDF5C76C1376B1670A66754E8A8EB41", hash_generated_method = "D68C36E9625129F28B8BB01C9B1C450E")
    public void setZoomSpeed(long speed) {
        mZoomSpeed = speed;
        // ---------- Original Method ----------
        //mZoomSpeed = speed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.449 -0400", hash_original_method = "26BCB5A69421DEBA679FF4C8B6DA9672", hash_generated_method = "FB20C6EA5A51ED411671C1AB400D891D")
    public boolean onLongClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mIsInLongpress = true;
        mHandler.post(mRunnable);
        addTaint(v.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631036643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631036643;
        // ---------- Original Method ----------
        //mIsInLongpress = true;
        //mHandler.post(mRunnable);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.449 -0400", hash_original_method = "BFA7CE14F9602D57E8995DEC9C69E7C5", hash_generated_method = "795D984EE0131529467B3C2A249C4674")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mIsInLongpress = false;
        boolean varEDD771EBF66425AD21882AB08CD0EE48_1096931401 = (super.onKeyUp(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_216593686 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_216593686;
        // ---------- Original Method ----------
        //mIsInLongpress = false;
        //return super.onKeyUp(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.449 -0400", hash_original_method = "46BB6036120D403ECAC10DF2C7F6C840", hash_generated_method = "63657863EBDA51DCCBDA3FB14ECB59E4")
    @Override
    public void setEnabled(boolean enabled) {
        {
            setPressed(false);
        } //End block
        super.setEnabled(enabled);
        addTaint(enabled);
        // ---------- Original Method ----------
        //if (!enabled) {
            //setPressed(false);
        //}
        //super.setEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.465 -0400", hash_original_method = "F8B564AE722FC7E23EAA2F8FF5648A4E", hash_generated_method = "0B6DC67314752F9AABEF7F9478ABA6F4")
    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        clearFocus();
        boolean var7806FDB90C43580BB08977F76E469BBD_969938684 = (super.dispatchUnhandledMove(focused, direction));
        addTaint(focused.getTaint());
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488463705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488463705;
        // ---------- Original Method ----------
        //clearFocus();
        //return super.dispatchUnhandledMove(focused, direction);
    }

    
}

