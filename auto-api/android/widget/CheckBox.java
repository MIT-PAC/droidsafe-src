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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.349 -0400", hash_original_method = "07A60C33F591AF3364367476C757E191", hash_generated_method = "E3255D6B4307A4EAEB0F9F2FC1EDD796")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CheckBox(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.349 -0400", hash_original_method = "8805AB2AC1AEC0E9A85C20D3125221E0", hash_generated_method = "E7BB2BA55A546B4DE81EA6AA59C8593D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.checkboxStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.349 -0400", hash_original_method = "DC2D9AD560E05B0AD2F1F269CCCF9F57", hash_generated_method = "CC38A02A49F9B419C1F6C41FDD967B11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CheckBox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.350 -0400", hash_original_method = "270C42284D505CD6CA182328DD88ED30", hash_generated_method = "4DA9C5C99625A5EF034988149F223EF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onPopulateAccessibilityEvent(event);
        {
            boolean varCEC0E711DC0F7C8E920C6F998438D53D_1970806322 = (isChecked());
            {
                event.getText().add(mContext.getString(R.string.checkbox_checked));
            } //End block
            {
                event.getText().add(mContext.getString(R.string.checkbox_not_checked));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //if (isChecked()) {
            //event.getText().add(mContext.getString(R.string.checkbox_checked));
        //} else {
            //event.getText().add(mContext.getString(R.string.checkbox_not_checked));
        //}
    }

    
}

