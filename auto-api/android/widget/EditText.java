package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.util.AttributeSet;

public class EditText extends TextView {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.458 -0400", hash_original_method = "3D8BBCF9E8BFADB5EA8354D28833D1D0", hash_generated_method = "082AED70CDDCF8010B4B5EB4354EE55C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EditText(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.459 -0400", hash_original_method = "13651F89327987238C61359B94395EF4", hash_generated_method = "49A7FB1C2156FC80222D43D8BF6F898A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EditText(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.editTextStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.459 -0400", hash_original_method = "B310470CAC184D932B7E9107B288DF59", hash_generated_method = "4B5E33B36B61B2227C11A4474F4F1542")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.459 -0400", hash_original_method = "78689D8CF0BA47FA74C236553C6AEDBF", hash_generated_method = "1814CA3D5A9D2FD91320BFF78BA8F6A4")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean getDefaultEditable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.459 -0400", hash_original_method = "B69FA8267E3DCA70E8EEE3A6942BD033", hash_generated_method = "0EB88E3BAB8A7C1F5857B19B0D3C48BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected MovementMethod getDefaultMovementMethod() {
        MovementMethod varBB618D50364A6E9E793B17C91DE2474A_2145823767 = (ArrowKeyMovementMethod.getInstance());
        return (MovementMethod)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ArrowKeyMovementMethod.getInstance();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.460 -0400", hash_original_method = "7E84A3A8580CD7F3BD2A1E596441D1C1", hash_generated_method = "3457FE8452A8EA1A80892A48E382EF4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Editable getText() {
        Editable var863152604FE1ED58993A64E1D9EC6E84_1002281326 = ((Editable) super.getText());
        return (Editable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Editable) super.getText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.460 -0400", hash_original_method = "91EEE8E208E2C0AA25FB9684496DF44B", hash_generated_method = "C3807E1C82E4AB51D3C24CA8E9081392")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setText(CharSequence text, BufferType type) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(type.dsTaint);
        super.setText(text, BufferType.EDITABLE);
        // ---------- Original Method ----------
        //super.setText(text, BufferType.EDITABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.460 -0400", hash_original_method = "F43056F38C29E5CA5FEFE1CD9DA04514", hash_generated_method = "C854F86E4DC2338A78F5406950A30A11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelection(int start, int stop) {
        dsTaint.addTaint(stop);
        dsTaint.addTaint(start);
        Selection.setSelection(getText(), start, stop);
        // ---------- Original Method ----------
        //Selection.setSelection(getText(), start, stop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.460 -0400", hash_original_method = "A198D78C33BD7BD56EF74E8B7D53E824", hash_generated_method = "57683C3ED260B6CC7E8CAFFF030A7D2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelection(int index) {
        dsTaint.addTaint(index);
        Selection.setSelection(getText(), index);
        // ---------- Original Method ----------
        //Selection.setSelection(getText(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.460 -0400", hash_original_method = "49D3F8B7E29E8DF6F83DD071F1ED7D81", hash_generated_method = "9187CC6366D6115D68A15990FFCCDB01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void selectAll() {
        Selection.selectAll(getText());
        // ---------- Original Method ----------
        //Selection.selectAll(getText());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.461 -0400", hash_original_method = "673DC4021002F481902DEBB3491C7A8B", hash_generated_method = "6CB50E6DF9240234FCBD73519201120C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void extendSelection(int index) {
        dsTaint.addTaint(index);
        Selection.extendSelection(getText(), index);
        // ---------- Original Method ----------
        //Selection.extendSelection(getText(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.461 -0400", hash_original_method = "6149CD37480D13E19ED1369D0EB1259F", hash_generated_method = "E8674D9694AE7AD28E1AC79D4D4ECB82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEllipsize(TextUtils.TruncateAt ellipsis) {
        dsTaint.addTaint(ellipsis.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("EditText cannot use the ellipsize mode "
                    + "TextUtils.TruncateAt.MARQUEE");
        } //End block
        super.setEllipsize(ellipsis);
        // ---------- Original Method ----------
        //if (ellipsis == TextUtils.TruncateAt.MARQUEE) {
            //throw new IllegalArgumentException("EditText cannot use the ellipsize mode "
                    //+ "TextUtils.TruncateAt.MARQUEE");
        //}
        //super.setEllipsize(ellipsis);
    }

    
}

