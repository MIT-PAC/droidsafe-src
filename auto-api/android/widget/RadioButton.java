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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.388 -0400", hash_original_method = "8EA0788A6467FFBB5D903E4298CD9D3F", hash_generated_method = "6A37801247D6AF2DB217E7C76AC6D9FB")
    public  RadioButton(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.389 -0400", hash_original_method = "FCCFFF736372EBE3F690E025A55A3D26", hash_generated_method = "98BE49F154AA32D97CC47C04539008D5")
    public  RadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.radioButtonStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.389 -0400", hash_original_method = "8A4946DCA2378530E5A11522D0746FD0", hash_generated_method = "A1248C0739DCB6A1C12CA097F63A41D4")
    public  RadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.389 -0400", hash_original_method = "4F290A4820515377F1C311D5735DB548", hash_generated_method = "F13F5A2ABECB20CD6F8247D8BF4A0FC2")
    @Override
    public void toggle() {
        {
            boolean var7AB0DED7B5B158F799F9F55A9C38731D_2080919314 = (!isChecked());
            {
                super.toggle();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isChecked()) {
            //super.toggle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.390 -0400", hash_original_method = "800F92BFA9EDE937B28EAF651D664B90", hash_generated_method = "71920BB544D25474F4F4999153B4E48E")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPopulateAccessibilityEvent(event);
        {
            boolean varCEC0E711DC0F7C8E920C6F998438D53D_869557952 = (isChecked());
            {
                event.getText().add(mContext.getString(R.string.radiobutton_selected));
            } //End block
            {
                event.getText().add(mContext.getString(R.string.radiobutton_not_selected));
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //if (isChecked()) {
            //event.getText().add(mContext.getString(R.string.radiobutton_selected));
        //} else {
            //event.getText().add(mContext.getString(R.string.radiobutton_not_selected));
        //}
    }

    
}

