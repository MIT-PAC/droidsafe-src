package android.widget;

// Droidsafe Imports
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ZoomButton extends ImageButton implements OnLongClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.268 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.262 -0400", hash_original_field = "65BDCBCF196E90740F940F290BEFAB2D", hash_generated_field = "26FFEDCABD497801FADA41E238F232C4")

    private final Runnable mRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.262 -0400", hash_original_method = "93C4F1AB03EDEC29398EF344D9566441", hash_generated_method = "5D14CBEFC651639CA9AA3FDE1107D5B8")
        public void run() {
            {
                boolean var5A1FF320AD44FFAE161220CEF22196E1_430321525 = (hasOnClickListeners() && mIsInLongpress && isEnabled());
                {
                    callOnClick();
                    mHandler.postDelayed(this, mZoomSpeed);
                } 
            } 
            
            
                
                
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.268 -0400", hash_original_field = "10523967FB2F80A5680451244507ED0E", hash_generated_field = "EEAD05CCF97EA02687293998A0924A76")

    private long mZoomSpeed = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.268 -0400", hash_original_field = "3435F341BF12B5AA17C422C22C3B5E6C", hash_generated_field = "D784F636C36BABB7864D79722AD46F05")

    private boolean mIsInLongpress;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.269 -0400", hash_original_method = "FE073AFFD3994A95FEC890EBCF528CD3", hash_generated_method = "426FFB99417CD80A6D4D96B16656C7ED")
    public  ZoomButton(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.269 -0400", hash_original_method = "2E206A8DD55CDB4EE0CBFCA63CB6A076", hash_generated_method = "DD6E2D69C5B8089F0840782990376BD7")
    public  ZoomButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.270 -0400", hash_original_method = "C3304F204963574721B46CA6BEC245F6", hash_generated_method = "4402B9EEE5D0C33C840FC12D826CB09E")
    public  ZoomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        mHandler = new Handler();
        setOnLongClickListener(this);
        // ---------- Original Method ----------
        //mHandler = new Handler();
        //setOnLongClickListener(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.270 -0400", hash_original_method = "6BCA096FD56C8C78BA7791883B013378", hash_generated_method = "045FA38B7EE96F6A300E919F978FA1C9")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        if((event.getAction() == MotionEvent.ACTION_CANCEL)
                || (event.getAction() == MotionEvent.ACTION_UP))        
        {
            mIsInLongpress = false;
        } //End block
        boolean varB07EB30996A92905DCA4C49613CBAF5F_204299357 = (super.onTouchEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_302366403 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_302366403;
        // ---------- Original Method ----------
        //if ((event.getAction() == MotionEvent.ACTION_CANCEL)
                //|| (event.getAction() == MotionEvent.ACTION_UP)) {
            //mIsInLongpress = false;
        //}
        //return super.onTouchEvent(event);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.271 -0400", hash_original_method = "DEDF5C76C1376B1670A66754E8A8EB41", hash_generated_method = "D68C36E9625129F28B8BB01C9B1C450E")
    public void setZoomSpeed(long speed) {
        mZoomSpeed = speed;
        // ---------- Original Method ----------
        //mZoomSpeed = speed;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.271 -0400", hash_original_method = "26BCB5A69421DEBA679FF4C8B6DA9672", hash_generated_method = "965AB58E0D9C0D5835BCD117200FADA4")
    public boolean onLongClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        mIsInLongpress = true;
        mHandler.post(mRunnable);
        boolean varB326B5062B2F0E69046810717534CB09_1565587119 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1043894212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1043894212;
        // ---------- Original Method ----------
        //mIsInLongpress = true;
        //mHandler.post(mRunnable);
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.272 -0400", hash_original_method = "BFA7CE14F9602D57E8995DEC9C69E7C5", hash_generated_method = "4BBA400A9292021EB918D709E9EA4EEF")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        mIsInLongpress = false;
        boolean varAD33E8F21A74B923C1A24761EAF2F4A9_2057331640 = (super.onKeyUp(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432336429 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432336429;
        // ---------- Original Method ----------
        //mIsInLongpress = false;
        //return super.onKeyUp(keyCode, event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.272 -0400", hash_original_method = "46BB6036120D403ECAC10DF2C7F6C840", hash_generated_method = "925A01D3E053CDD86E95416C9AC1521B")
    @Override
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
        if(!enabled)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.273 -0400", hash_original_method = "F8B564AE722FC7E23EAA2F8FF5648A4E", hash_generated_method = "7F81D80A678B5ACD7AB5E7DA34160683")
    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        addTaint(direction);
        addTaint(focused.getTaint());
        clearFocus();
        boolean var38F03C1502A28A0A57FCF126EB46E15F_2028088403 = (super.dispatchUnhandledMove(focused, direction));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_315350991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_315350991;
        // ---------- Original Method ----------
        //clearFocus();
        //return super.dispatchUnhandledMove(focused, direction);
    }

    
}

