package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;

import com.android.internal.R;



public class CheckBox extends CompoundButton {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:07.125 -0500", hash_original_method = "07A60C33F591AF3364367476C757E191", hash_generated_method = "E6771C4C8CFC6F5CDC28750B50C2D1E4")
    public CheckBox(Context context) {
        this(context, null);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:07.126 -0500", hash_original_method = "8805AB2AC1AEC0E9A85C20D3125221E0", hash_generated_method = "71BC6DBDC707861A63C3CDC0797C5E15")
    public CheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.checkboxStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:07.127 -0500", hash_original_method = "DC2D9AD560E05B0AD2F1F269CCCF9F57", hash_generated_method = "AD2FD894859AA2FF10ABD4A010F667B5")
    public CheckBox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:07.128 -0500", hash_original_method = "270C42284D505CD6CA182328DD88ED30", hash_generated_method = "0AE7313901D0A224234DCDCF680EB599")
    @Override
public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        if (isChecked()) {
            event.getText().add(mContext.getString(R.string.checkbox_checked));
        } else {
            event.getText().add(mContext.getString(R.string.checkbox_not_checked));
        }
    }

    
}

