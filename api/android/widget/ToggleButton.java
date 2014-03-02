package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;

import com.android.internal.R;

public class ToggleButton extends CompoundButton {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.753 -0500", hash_original_field = "F40A65A0161E245EB9410D7A796FE9B3", hash_generated_field = "0FC0F1E74EFFD499D7E9EC90666C1A5B")

    private static final int NO_ALPHA = 0xFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.746 -0500", hash_original_field = "769F2C0D0F3768558E3E71BB28929F11", hash_generated_field = "88910E09C0D7EF0865C6C6AF2A30F920")

    private CharSequence mTextOn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.748 -0500", hash_original_field = "A802E7DF1BA0E3577A5B291A79D76CF7", hash_generated_field = "46E8A8BDEBA8D39F1C8B9DD255F9FFFF")

    private CharSequence mTextOff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.750 -0500", hash_original_field = "8C8087D1BF7BFC2034B3FD41A46BB4E1", hash_generated_field = "449BA91A8DE7F6C81175BD28E091D104")
    
    private Drawable mIndicatorDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.755 -0500", hash_original_field = "C7A330BE7142327056539F5ED284903D", hash_generated_field = "BE45430B4E582ECC76FDAE96B324FF18")

    private float mDisabledAlpha;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.757 -0500", hash_original_method = "BBF2F051F26D6598677E602500518F20", hash_generated_method = "820D9B1D6BDC20BE50A104E6B330EA32")
    
public ToggleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        
        TypedArray a =
            context.obtainStyledAttributes(
                    attrs, com.android.internal.R.styleable.ToggleButton, defStyle, 0);
        mTextOn = a.getText(com.android.internal.R.styleable.ToggleButton_textOn);
        mTextOff = a.getText(com.android.internal.R.styleable.ToggleButton_textOff);
        mDisabledAlpha = a.getFloat(com.android.internal.R.styleable.ToggleButton_disabledAlpha, 0.5f);
        syncTextState();
        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.760 -0500", hash_original_method = "70ADFAB7EB5D059C66B3BA4B8EE96D3C", hash_generated_method = "4B21F05FA4E09C0FF3962EDF0733BEDA")
    
public ToggleButton(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.buttonStyleToggle);
    }

    @DSComment("ToggleButton, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.763 -0500", hash_original_method = "5CB14A1EE33B76662B7844E5CB0658A9", hash_generated_method = "A11DD048AF6262095524458032C5CDE2")
    
public ToggleButton(Context context) {
        this(context, null);
    }

    @DSComment("ToggleButton, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.765 -0500", hash_original_method = "114EA4FC41B05DCC13D832240123F1AB", hash_generated_method = "2032E16A48DAE7A8FAA1E2F794EDFD08")
    
@Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        
        syncTextState();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.767 -0500", hash_original_method = "A3A4B8254A3076C3DF78E3AF06A5BAA7", hash_generated_method = "5870BF8FC0457E17723BABBA4E171CE6")
    
private void syncTextState() {
        boolean checked = isChecked();
        if (checked && mTextOn != null) {
            setText(mTextOn);
        } else if (!checked && mTextOff != null) {
            setText(mTextOff);
        }
    }

    /**
     * Returns the text for when the button is in the checked state.
     * 
     * @return The text.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.769 -0500", hash_original_method = "5C0E5388314CF71485B1BF56327EECD2", hash_generated_method = "88C8DD18DC57878BA442223FAB42DEBF")
    
public CharSequence getTextOn() {
        return mTextOn;
    }

    /**
     * Sets the text for when the button is in the checked state.
     *  
     * @param textOn The text.
     */
    @DSComment("ToggleButton, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.771 -0500", hash_original_method = "ACAEE36BE44A4D8B24B7AB5EAF55367A", hash_generated_method = "E688A4165DB1F6ECABE48950BD4DBECB")
    
public void setTextOn(CharSequence textOn) {
        mTextOn = textOn;
    }

    /**
     * Returns the text for when the button is not in the checked state.
     * 
     * @return The text.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.773 -0500", hash_original_method = "EAEA80D56F502C97F845DE2B9DA853EF", hash_generated_method = "849DDC2D49CECB6A57382D582199C99E")
    
public CharSequence getTextOff() {
        return mTextOff;
    }

    /**
     * Sets the text for when the button is not in the checked state.
     * 
     * @param textOff The text.
     */
    @DSComment("ToggleButton, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.775 -0500", hash_original_method = "60B041A4AF8BC6B9E7C69B28CDF70955", hash_generated_method = "45EC2AD392ED2DF9424460B0AC6A1211")
    
public void setTextOff(CharSequence textOff) {
        mTextOff = textOff;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.778 -0500", hash_original_method = "CD87BB009216C6E394DAEB7F0CACBDC7", hash_generated_method = "107CC6583C01286AF3D6BEFD023A060A")
    
@Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        
        updateReferenceToIndicatorDrawable(getBackground());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.781 -0500", hash_original_method = "4BCD6E00FF1D8992B4CBE123EFCE4218", hash_generated_method = "A7CB598DCD8B54B83BCEAA154034CAE7")
    
@Override
    public void setBackgroundDrawable(Drawable d) {
        super.setBackgroundDrawable(d);
        
        updateReferenceToIndicatorDrawable(d);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.783 -0500", hash_original_method = "ECF0FA7CF2036753A46FE0C4EF856618", hash_generated_method = "72EA312AC946199E91902C2723165F53")
    
private void updateReferenceToIndicatorDrawable(Drawable backgroundDrawable) {
        if (backgroundDrawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) backgroundDrawable;
            mIndicatorDrawable =
                    layerDrawable.findDrawableByLayerId(com.android.internal.R.id.toggle);
        } else {
            mIndicatorDrawable = null;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.785 -0500", hash_original_method = "ABBA16041C04ACF45B62A6F7D1B99CE2", hash_generated_method = "566BD1A0B57272FD8BEE91014D09E5B3")
    
@Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        
        if (mIndicatorDrawable != null) {
            mIndicatorDrawable.setAlpha(isEnabled() ? NO_ALPHA : (int) (NO_ALPHA * mDisabledAlpha));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.788 -0500", hash_original_method = "829A7520B55299EB98890ECCFB9822BF", hash_generated_method = "3029A3C9E98BEFAE1577378CB1AB2E75")
    
@Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        if (isChecked()) {
            event.getText().add(mContext.getString(R.string.togglebutton_pressed));
        } else {
            event.getText().add(mContext.getString(R.string.togglebutton_not_pressed));
        }
    }
}

