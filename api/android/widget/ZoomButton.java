package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;

public class ZoomButton extends ImageButton implements OnLongClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.840 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private  Handler mHandler;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.848 -0500", hash_original_field = "5BD6A3C6061681A352EBF45CA1064557", hash_generated_field = "EEAD05CCF97EA02687293998A0924A76")
    
    private long mZoomSpeed = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.851 -0500", hash_original_field = "1636CC6174ED0CAD994EA9D89C7D77F0", hash_generated_field = "D784F636C36BABB7864D79722AD46F05")

    private boolean mIsInLongpress;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.853 -0500", hash_original_method = "FE073AFFD3994A95FEC890EBCF528CD3", hash_generated_method = "AFD0D1CDF55A5DA2813185BA6AF8FCCC")
    
public ZoomButton(Context context) {
        this(context, null);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.856 -0500", hash_original_method = "2E206A8DD55CDB4EE0CBFCA63CB6A076", hash_generated_method = "49DF8193C8EBA7BCD3525BBB86756295")
    
public ZoomButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.858 -0500", hash_original_method = "C3304F204963574721B46CA6BEC245F6", hash_generated_method = "2F733D407C2FED559AECD84327BB3A2A")
    
public ZoomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mHandler = new Handler();
        setOnLongClickListener(this);
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.860 -0500", hash_original_method = "6BCA096FD56C8C78BA7791883B013378", hash_generated_method = "23EF65D079E88CCF4F556BC5BAF6FF8E")
    
@Override
    public boolean onTouchEvent(MotionEvent event) {
        if ((event.getAction() == MotionEvent.ACTION_CANCEL)
                || (event.getAction() == MotionEvent.ACTION_UP)) {
            mIsInLongpress = false;
        }
        return super.onTouchEvent(event);
    }
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.862 -0500", hash_original_method = "DEDF5C76C1376B1670A66754E8A8EB41", hash_generated_method = "488241F1FE829310D6E2201807FDA0B9")
    
public void setZoomSpeed(long speed) {
        mZoomSpeed = speed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.864 -0500", hash_original_method = "26BCB5A69421DEBA679FF4C8B6DA9672", hash_generated_method = "B24B4D282A2C42355EE6AB9DC29D57FA")
    
public boolean onLongClick(View v) {
        mIsInLongpress = true;
        mHandler.post(mRunnable);
        return true;
    }
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.867 -0500", hash_original_method = "BFA7CE14F9602D57E8995DEC9C69E7C5", hash_generated_method = "9A886DDBFA834994C165B30F7D9B8610")
    
@Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        mIsInLongpress = false;
        return super.onKeyUp(keyCode, event);
    }
    
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.869 -0500", hash_original_method = "46BB6036120D403ECAC10DF2C7F6C840", hash_generated_method = "90A762EBF729F2A2FBD688B6994E6F19")
    
@Override
    public void setEnabled(boolean enabled) {
        if (!enabled) {
            
            /* If we're being disabled reset the state back to unpressed
             * as disabled views don't get events and therefore we won't
             * get the up event to reset the state.
             */
            setPressed(false);
        }
        super.setEnabled(enabled);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.871 -0500", hash_original_method = "F8B564AE722FC7E23EAA2F8FF5648A4E", hash_generated_method = "2AC0C6080F4F223BC2ED6F95CCAC1BD7")
    
@Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        clearFocus();
        return super.dispatchUnhandledMove(focused, direction);
    }
    
}

