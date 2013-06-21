package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.util.AttributeSet;

public class SeekBar extends AbsSeekBar {
    private OnSeekBarChangeListener mOnSeekBarChangeListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.529 -0400", hash_original_method = "900EA85C51BB335BDEEF50874B73DABB", hash_generated_method = "A7DAAB89672879AFF7554A07387002DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SeekBar(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.529 -0400", hash_original_method = "CA56E7509993CB1742B0A72C233A6542", hash_generated_method = "711BCF19217CCB6E119E4AF075D0DC14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.seekBarStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.529 -0400", hash_original_method = "639660E10201BDC61C50CFBB9E628106", hash_generated_method = "F4869315FDB390A601760B0E913F9217")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.529 -0400", hash_original_method = "DD663C8CCC2546E3D6B933CEB65E26BD", hash_generated_method = "4E563F66CC9B2682DCC71654D5842F3A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.530 -0400", hash_original_method = "C0517BE28CCF436D86BD6FE3A21CD0CD", hash_generated_method = "2C1D163F9A14CB7F2D0CE0222571F46E")
    @DSModeled(DSC.SAFE)
    public void setOnSeekBarChangeListener(OnSeekBarChangeListener l) {
        dsTaint.addTaint(l.dsTaint);
        // ---------- Original Method ----------
        //mOnSeekBarChangeListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.530 -0400", hash_original_method = "2E55538E3CA24475C492828CB72A3527", hash_generated_method = "D5767BE5659587600C5C9EE72883CC70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.530 -0400", hash_original_method = "C921C0BD5635A2E6E637F17C3D08AF5B", hash_generated_method = "A49F433CA6BD9D2339A0E1D48DD7633A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

