package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;

public class SeekBar extends AbsSeekBar {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.977 -0500", hash_original_field = "3CC4BBF74E8555C1C6891B0F08414724", hash_generated_field = "C83474F838E540BD5E50F97536CB12F2")

    private OnSeekBarChangeListener mOnSeekBarChangeListener;
    
    @DSComment("SeekBar")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.980 -0500", hash_original_method = "900EA85C51BB335BDEEF50874B73DABB", hash_generated_method = "364330E930214DB540F99C79E2A1A3EC")
    
public SeekBar(Context context) {
        this(context, null);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.983 -0500", hash_original_method = "CA56E7509993CB1742B0A72C233A6542", hash_generated_method = "C22B818578A9FEC75B80B8D60F2E1184")
    
public SeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.seekBarStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.986 -0500", hash_original_method = "639660E10201BDC61C50CFBB9E628106", hash_generated_method = "6D8D681CB48B72CE9066851C8F9B121F")
    
public SeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    
    @DSComment("This method will be called from View's constructor")
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    @Override public void droidsafeCallbackHook() {
        onProgressRefresh(DSUtils.UNKNOWN_FLOAT, DSUtils.UNKNOWN_BOOLEAN);
        onStartTrackingTouch();
        onStopTrackingTouch();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.988 -0500", hash_original_method = "DD663C8CCC2546E3D6B933CEB65E26BD", hash_generated_method = "5946F245E80E43CEA4DAC9BD328B0E34")
    
@Override
    void onProgressRefresh(float scale, boolean fromUser) {
        super.onProgressRefresh(scale, fromUser);

        if (mOnSeekBarChangeListener != null) {
            mOnSeekBarChangeListener.onProgressChanged(this, getProgress(), fromUser);
        }
    }

    /**
     * Sets a listener to receive notifications of changes to the SeekBar's progress level. Also
     * provides notifications of when the user starts and stops a touch gesture within the SeekBar.
     * 
     * @param l The seek bar notification listener
     * 
     * @see SeekBar.OnSeekBarChangeListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.991 -0500", hash_original_method = "C0517BE28CCF436D86BD6FE3A21CD0CD", hash_generated_method = "665E94AA2A7F661DF7CE9E8B86D1FCE8")
    @DSVerified("Callback registration")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setOnSeekBarChangeListener(OnSeekBarChangeListener l) {
        mOnSeekBarChangeListener = l;
        if (l != null) {
            l.onProgressChanged(this,  DSUtils.FAKE_INT,  DSUtils.UNKNOWN_BOOLEAN);
            l.onStartTrackingTouch(this);
            l.onStopTrackingTouch(this);
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.993 -0500", hash_original_method = "2E55538E3CA24475C492828CB72A3527", hash_generated_method = "20DE66F683C7C9FA49952071E7A0E279")
    
@Override
    void onStartTrackingTouch() {
        super.onStartTrackingTouch();
        if (mOnSeekBarChangeListener != null) {
            mOnSeekBarChangeListener.onStartTrackingTouch(this);
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.995 -0500", hash_original_method = "C921C0BD5635A2E6E637F17C3D08AF5B", hash_generated_method = "ED3D7ACA32FEF80E21A7E878CE2071B4")
    
@Override
    void onStopTrackingTouch() {
        super.onStopTrackingTouch();
        if (mOnSeekBarChangeListener != null) {
            mOnSeekBarChangeListener.onStopTrackingTouch(this);
        }
    }
    
    public interface OnSeekBarChangeListener {
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser);
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onStartTrackingTouch(SeekBar seekBar);
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onStopTrackingTouch(SeekBar seekBar);
    }
    
}

