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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.825 -0400", hash_original_field = "5938BF25D075D659DB9277B79B5DE721", hash_generated_field = "C83474F838E540BD5E50F97536CB12F2")

    private OnSeekBarChangeListener mOnSeekBarChangeListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.825 -0400", hash_original_method = "900EA85C51BB335BDEEF50874B73DABB", hash_generated_method = "2BA1FB37CC14A27DAF2A27757981439F")
    public  SeekBar(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.826 -0400", hash_original_method = "CA56E7509993CB1742B0A72C233A6542", hash_generated_method = "0547D781830D232A7606D29CB8692C9C")
    public  SeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.seekBarStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.826 -0400", hash_original_method = "639660E10201BDC61C50CFBB9E628106", hash_generated_method = "24266560E3E1E23800A68057617FFB47")
    public  SeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.826 -0400", hash_original_method = "DD663C8CCC2546E3D6B933CEB65E26BD", hash_generated_method = "F4511466DB3138DC7581BE51226DC790")
    @Override
     void onProgressRefresh(float scale, boolean fromUser) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onProgressRefresh(scale, fromUser);
        {
            mOnSeekBarChangeListener.onProgressChanged(this, getProgress(), fromUser);
        } //End block
        addTaint(scale);
        addTaint(fromUser);
        // ---------- Original Method ----------
        //super.onProgressRefresh(scale, fromUser);
        //if (mOnSeekBarChangeListener != null) {
            //mOnSeekBarChangeListener.onProgressChanged(this, getProgress(), fromUser);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.826 -0400", hash_original_method = "C0517BE28CCF436D86BD6FE3A21CD0CD", hash_generated_method = "2F3443B2AFA5DF0AB8304F3171502F39")
    public void setOnSeekBarChangeListener(OnSeekBarChangeListener l) {
        mOnSeekBarChangeListener = l;
        // ---------- Original Method ----------
        //mOnSeekBarChangeListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.827 -0400", hash_original_method = "2E55538E3CA24475C492828CB72A3527", hash_generated_method = "D5767BE5659587600C5C9EE72883CC70")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.827 -0400", hash_original_method = "C921C0BD5635A2E6E637F17C3D08AF5B", hash_generated_method = "A49F433CA6BD9D2339A0E1D48DD7633A")
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

