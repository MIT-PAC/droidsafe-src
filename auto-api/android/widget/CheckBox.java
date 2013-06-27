package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import com.android.internal.R;

public class CheckBox extends CompoundButton {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.489 -0400", hash_original_method = "07A60C33F591AF3364367476C757E191", hash_generated_method = "57493A5C7895739BD4734FFF00FA922D")
    public  CheckBox(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.489 -0400", hash_original_method = "8805AB2AC1AEC0E9A85C20D3125221E0", hash_generated_method = "22CECA2D2350C37DCB95FD24269EBC1B")
    public  CheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.checkboxStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.489 -0400", hash_original_method = "DC2D9AD560E05B0AD2F1F269CCCF9F57", hash_generated_method = "BA468869107AAC4B5F2FCD0B5B9787EC")
    public  CheckBox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.490 -0400", hash_original_method = "270C42284D505CD6CA182328DD88ED30", hash_generated_method = "A3EE3CE649E0622A94A60AD3418EF403")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPopulateAccessibilityEvent(event);
        {
            boolean varCEC0E711DC0F7C8E920C6F998438D53D_1125770807 = (isChecked());
            {
                event.getText().add(mContext.getString(R.string.checkbox_checked));
            } //End block
            {
                event.getText().add(mContext.getString(R.string.checkbox_not_checked));
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //if (isChecked()) {
            //event.getText().add(mContext.getString(R.string.checkbox_checked));
        //} else {
            //event.getText().add(mContext.getString(R.string.checkbox_not_checked));
        //}
    }

    
}

