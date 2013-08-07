package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;

import com.android.internal.R;






public class ToggleButton extends CompoundButton {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.005 -0400", hash_original_field = "B8D771293243D6B66B9BDFE3767FA658", hash_generated_field = "88910E09C0D7EF0865C6C6AF2A30F920")

    private CharSequence mTextOn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.005 -0400", hash_original_field = "F9730C00EAB435441597544B6A3333AB", hash_generated_field = "46E8A8BDEBA8D39F1C8B9DD255F9FFFF")

    private CharSequence mTextOff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.005 -0400", hash_original_field = "0A38572A49EBAFBFE752D7F90E01736A", hash_generated_field = "449BA91A8DE7F6C81175BD28E091D104")

    private Drawable mIndicatorDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.005 -0400", hash_original_field = "442F8731C67AF26E1E29D47472A461BF", hash_generated_field = "BE45430B4E582ECC76FDAE96B324FF18")

    private float mDisabledAlpha;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.006 -0400", hash_original_method = "BBF2F051F26D6598677E602500518F20", hash_generated_method = "7AEF99D7002AE96D237EDAE067C92B8D")
    public  ToggleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(
                    attrs, com.android.internal.R.styleable.ToggleButton, defStyle, 0);
        mTextOn = a.getText(com.android.internal.R.styleable.ToggleButton_textOn);
        mTextOff = a.getText(com.android.internal.R.styleable.ToggleButton_textOff);
        mDisabledAlpha = a.getFloat(com.android.internal.R.styleable.ToggleButton_disabledAlpha, 0.5f);
        syncTextState();
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a =
            //context.obtainStyledAttributes(
                    //attrs, com.android.internal.R.styleable.ToggleButton, defStyle, 0);
        //mTextOn = a.getText(com.android.internal.R.styleable.ToggleButton_textOn);
        //mTextOff = a.getText(com.android.internal.R.styleable.ToggleButton_textOff);
        //mDisabledAlpha = a.getFloat(com.android.internal.R.styleable.ToggleButton_disabledAlpha, 0.5f);
        //syncTextState();
        //a.recycle();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.007 -0400", hash_original_method = "70ADFAB7EB5D059C66B3BA4B8EE96D3C", hash_generated_method = "4FF12A2121557BCD2306209D8CB77DEE")
    public  ToggleButton(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.buttonStyleToggle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.007 -0400", hash_original_method = "5CB14A1EE33B76662B7844E5CB0658A9", hash_generated_method = "0A589800548C48467163172BD39E3859")
    public  ToggleButton(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.008 -0400", hash_original_method = "114EA4FC41B05DCC13D832240123F1AB", hash_generated_method = "EC8222BA843657A2C395297A27BB45FF")
    @Override
    public void setChecked(boolean checked) {
        addTaint(checked);
        super.setChecked(checked);
        syncTextState();
        // ---------- Original Method ----------
        //super.setChecked(checked);
        //syncTextState();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.008 -0400", hash_original_method = "A3A4B8254A3076C3DF78E3AF06A5BAA7", hash_generated_method = "B654F2B6AF94D87A1B149BC736107006")
    private void syncTextState() {
        boolean checked = isChecked();
        if(checked && mTextOn != null)        
        {
            setText(mTextOn);
        } //End block
        else
        if(!checked && mTextOff != null)        
        {
            setText(mTextOff);
        } //End block
        // ---------- Original Method ----------
        //boolean checked = isChecked();
        //if (checked && mTextOn != null) {
            //setText(mTextOn);
        //} else if (!checked && mTextOff != null) {
            //setText(mTextOff);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.009 -0400", hash_original_method = "5C0E5388314CF71485B1BF56327EECD2", hash_generated_method = "194475195008B38EDAF3D3DDCAB87514")
    public CharSequence getTextOn() {
CharSequence varB717BC0D87EF7CA63EF5B2DADD0E238D_1286768828 =         mTextOn;
        varB717BC0D87EF7CA63EF5B2DADD0E238D_1286768828.addTaint(taint);
        return varB717BC0D87EF7CA63EF5B2DADD0E238D_1286768828;
        // ---------- Original Method ----------
        //return mTextOn;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.009 -0400", hash_original_method = "ACAEE36BE44A4D8B24B7AB5EAF55367A", hash_generated_method = "67CC13008751AF9B4E65B5930EB2969F")
    public void setTextOn(CharSequence textOn) {
        mTextOn = textOn;
        // ---------- Original Method ----------
        //mTextOn = textOn;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.010 -0400", hash_original_method = "EAEA80D56F502C97F845DE2B9DA853EF", hash_generated_method = "106D1FA2CAA420A68EDB1282B2BE8A1F")
    public CharSequence getTextOff() {
CharSequence varAB991E92B38590F8C1DAE21519779556_1943124057 =         mTextOff;
        varAB991E92B38590F8C1DAE21519779556_1943124057.addTaint(taint);
        return varAB991E92B38590F8C1DAE21519779556_1943124057;
        // ---------- Original Method ----------
        //return mTextOff;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.010 -0400", hash_original_method = "60B041A4AF8BC6B9E7C69B28CDF70955", hash_generated_method = "F6CD4645E4AAFA85FDCFCC947F51F705")
    public void setTextOff(CharSequence textOff) {
        mTextOff = textOff;
        // ---------- Original Method ----------
        //mTextOff = textOff;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.011 -0400", hash_original_method = "CD87BB009216C6E394DAEB7F0CACBDC7", hash_generated_method = "81D9C38B61009D24E1CDF52F90536A51")
    @Override
    protected void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishInflate();
        updateReferenceToIndicatorDrawable(getBackground());
        // ---------- Original Method ----------
        //super.onFinishInflate();
        //updateReferenceToIndicatorDrawable(getBackground());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.011 -0400", hash_original_method = "4BCD6E00FF1D8992B4CBE123EFCE4218", hash_generated_method = "427BE4BA2CB70E76A809EA640B4D7951")
    @Override
    public void setBackgroundDrawable(Drawable d) {
        addTaint(d.getTaint());
        super.setBackgroundDrawable(d);
        updateReferenceToIndicatorDrawable(d);
        // ---------- Original Method ----------
        //super.setBackgroundDrawable(d);
        //updateReferenceToIndicatorDrawable(d);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.012 -0400", hash_original_method = "ECF0FA7CF2036753A46FE0C4EF856618", hash_generated_method = "4368DF37D4D4F3BE295B7CF8CA0E4405")
    private void updateReferenceToIndicatorDrawable(Drawable backgroundDrawable) {
        addTaint(backgroundDrawable.getTaint());
        if(backgroundDrawable instanceof LayerDrawable)        
        {
            LayerDrawable layerDrawable = (LayerDrawable) backgroundDrawable;
            mIndicatorDrawable =
                    layerDrawable.findDrawableByLayerId(com.android.internal.R.id.toggle);
        } //End block
        else
        {
            mIndicatorDrawable = null;
        } //End block
        // ---------- Original Method ----------
        //if (backgroundDrawable instanceof LayerDrawable) {
            //LayerDrawable layerDrawable = (LayerDrawable) backgroundDrawable;
            //mIndicatorDrawable =
                    //layerDrawable.findDrawableByLayerId(com.android.internal.R.id.toggle);
        //} else {
            //mIndicatorDrawable = null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.013 -0400", hash_original_method = "ABBA16041C04ACF45B62A6F7D1B99CE2", hash_generated_method = "9AE24279A20F711E193BF2BB1648370F")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(mIndicatorDrawable != null)        
        {
            mIndicatorDrawable.setAlpha(isEnabled() ? NO_ALPHA : (int) (NO_ALPHA * mDisabledAlpha));
        } //End block
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //if (mIndicatorDrawable != null) {
            //mIndicatorDrawable.setAlpha(isEnabled() ? NO_ALPHA : (int) (NO_ALPHA * mDisabledAlpha));
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.014 -0400", hash_original_method = "829A7520B55299EB98890ECCFB9822BF", hash_generated_method = "A6559AD65A1F1E2AA131A5114B922936")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onPopulateAccessibilityEvent(event);
        if(isChecked())        
        {
            event.getText().add(mContext.getString(R.string.togglebutton_pressed));
        } //End block
        else
        {
            event.getText().add(mContext.getString(R.string.togglebutton_not_pressed));
        } //End block
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //if (isChecked()) {
            //event.getText().add(mContext.getString(R.string.togglebutton_pressed));
        //} else {
            //event.getText().add(mContext.getString(R.string.togglebutton_not_pressed));
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.015 -0400", hash_original_field = "B56B6FA624E764C4691175252EBD6A92", hash_generated_field = "0FC0F1E74EFFD499D7E9EC90666C1A5B")

    private static final int NO_ALPHA = 0xFF;
}

