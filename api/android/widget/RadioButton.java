package android.widget;

// Droidsafe Imports
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;

import com.android.internal.R;

import droidsafe.annotations.DSGenerator;

public class RadioButton extends CompoundButton {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.176 -0400", hash_original_method = "8EA0788A6467FFBB5D903E4298CD9D3F", hash_generated_method = "6A37801247D6AF2DB217E7C76AC6D9FB")
    public  RadioButton(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.176 -0400", hash_original_method = "FCCFFF736372EBE3F690E025A55A3D26", hash_generated_method = "597BFE97A7D17CBE84EB382C477E5D0D")
    public  RadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.radioButtonStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.177 -0400", hash_original_method = "8A4946DCA2378530E5A11522D0746FD0", hash_generated_method = "834FFCB4B9B2B1A9C4432220F2EA1B81")
    public  RadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.177 -0400", hash_original_method = "4F290A4820515377F1C311D5735DB548", hash_generated_method = "CC54BB03A26206AF20F673EEDA1DAB5D")
    @Override
    public void toggle() {
        if(!isChecked())        
        {
            super.toggle();
        } //End block
        // ---------- Original Method ----------
        //if (!isChecked()) {
            //super.toggle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.178 -0400", hash_original_method = "800F92BFA9EDE937B28EAF651D664B90", hash_generated_method = "1777866A2F27E2BFC3BE9BB817580974")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onPopulateAccessibilityEvent(event);
        if(isChecked())        
        {
            event.getText().add(mContext.getString(R.string.radiobutton_selected));
        } //End block
        else
        {
            event.getText().add(mContext.getString(R.string.radiobutton_not_selected));
        } //End block
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //if (isChecked()) {
            //event.getText().add(mContext.getString(R.string.radiobutton_selected));
        //} else {
            //event.getText().add(mContext.getString(R.string.radiobutton_not_selected));
        //}
    }

    
}

