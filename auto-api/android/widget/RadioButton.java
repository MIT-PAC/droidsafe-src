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

public class RadioButton extends CompoundButton {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.059 -0400", hash_original_method = "8EA0788A6467FFBB5D903E4298CD9D3F", hash_generated_method = "ED8B7DEC0759AA85077BC4FFA4BE0B97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RadioButton(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.059 -0400", hash_original_method = "FCCFFF736372EBE3F690E025A55A3D26", hash_generated_method = "5F22D2308DE858B00BF3ACA945CE0103")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.radioButtonStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.059 -0400", hash_original_method = "8A4946DCA2378530E5A11522D0746FD0", hash_generated_method = "217A4B8670E526425AD3E324A9F48647")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.059 -0400", hash_original_method = "4F290A4820515377F1C311D5735DB548", hash_generated_method = "9C41F1043B28725FC3023A129D8A6B3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void toggle() {
        {
            boolean var7AB0DED7B5B158F799F9F55A9C38731D_2127212850 = (!isChecked());
            {
                super.toggle();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isChecked()) {
            //super.toggle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.059 -0400", hash_original_method = "800F92BFA9EDE937B28EAF651D664B90", hash_generated_method = "6A208946B7A3AC9208630B4A0091363F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onPopulateAccessibilityEvent(event);
        {
            boolean varCEC0E711DC0F7C8E920C6F998438D53D_252867001 = (isChecked());
            {
                event.getText().add(mContext.getString(R.string.radiobutton_selected));
            } //End block
            {
                event.getText().add(mContext.getString(R.string.radiobutton_not_selected));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //if (isChecked()) {
            //event.getText().add(mContext.getString(R.string.radiobutton_selected));
        //} else {
            //event.getText().add(mContext.getString(R.string.radiobutton_not_selected));
        //}
    }

    
}

