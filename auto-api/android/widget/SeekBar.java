package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.util.AttributeSet;

public class SeekBar extends AbsSeekBar {
    private OnSeekBarChangeListener mOnSeekBarChangeListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.377 -0400", hash_original_method = "900EA85C51BB335BDEEF50874B73DABB", hash_generated_method = "D8D392A9D3003D2005DD5F535E1641D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SeekBar(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.377 -0400", hash_original_method = "CA56E7509993CB1742B0A72C233A6542", hash_generated_method = "C17FB2DD9149229F08CEF846F63A90B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.seekBarStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.377 -0400", hash_original_method = "639660E10201BDC61C50CFBB9E628106", hash_generated_method = "50EB7D58F42FBC11EF77D47DB4A7B7D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.377 -0400", hash_original_method = "DD663C8CCC2546E3D6B933CEB65E26BD", hash_generated_method = "676300341A118B0112AF800931E43007")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void onProgressRefresh(float scale, boolean fromUser) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(scale);
        dsTaint.addTaint(fromUser);
        super.onProgressRefresh(scale, fromUser);
        {
            mOnSeekBarChangeListener.onProgressChanged(this, getProgress(), fromUser);
        } //End block
        // ---------- Original Method ----------
        //super.onProgressRefresh(scale, fromUser);
        //if (mOnSeekBarChangeListener != null) {
            //mOnSeekBarChangeListener.onProgressChanged(this, getProgress(), fromUser);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.377 -0400", hash_original_method = "C0517BE28CCF436D86BD6FE3A21CD0CD", hash_generated_method = "F9E1358F4743A1C51F95BA14E2AADE26")
    @DSModeled(DSC.SAFE)
    public void setOnSeekBarChangeListener(OnSeekBarChangeListener l) {
        dsTaint.addTaint(l.dsTaint);
        // ---------- Original Method ----------
        //mOnSeekBarChangeListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.377 -0400", hash_original_method = "2E55538E3CA24475C492828CB72A3527", hash_generated_method = "AFD9EB27CD08DFB4DAF272C8E2284D30")
    @DSModeled(DSC.SAFE)
    @Override
     void onStartTrackingTouch() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStartTrackingTouch();
        {
            mOnSeekBarChangeListener.onStartTrackingTouch(this);
        } //End block
        // ---------- Original Method ----------
        //super.onStartTrackingTouch();
        //if (mOnSeekBarChangeListener != null) {
            //mOnSeekBarChangeListener.onStartTrackingTouch(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.377 -0400", hash_original_method = "C921C0BD5635A2E6E637F17C3D08AF5B", hash_generated_method = "1743E0A3E922382902407CD1E55DBEEA")
    @DSModeled(DSC.SAFE)
    @Override
     void onStopTrackingTouch() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStopTrackingTouch();
        {
            mOnSeekBarChangeListener.onStopTrackingTouch(this);
        } //End block
        // ---------- Original Method ----------
        //super.onStopTrackingTouch();
        //if (mOnSeekBarChangeListener != null) {
            //mOnSeekBarChangeListener.onStopTrackingTouch(this);
        //}
    }

    
    public interface OnSeekBarChangeListener {
        
        
        void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser);
    
        
        void onStartTrackingTouch(SeekBar seekBar);
        
        
        void onStopTrackingTouch(SeekBar seekBar);
    }
    
}


