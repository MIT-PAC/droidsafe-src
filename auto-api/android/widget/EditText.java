package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.491 -0400", hash_original_method = "3D8BBCF9E8BFADB5EA8354D28833D1D0", hash_generated_method = "9332794AE21D2FB987A60C5D2A69068B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EditText(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.491 -0400", hash_original_method = "13651F89327987238C61359B94395EF4", hash_generated_method = "2E36E657D6F8D6ACAD1CAC9576F9D669")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EditText(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.editTextStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.491 -0400", hash_original_method = "B310470CAC184D932B7E9107B288DF59", hash_generated_method = "C419E9E0DD7DCC1D148882EA01E74113")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.491 -0400", hash_original_method = "78689D8CF0BA47FA74C236553C6AEDBF", hash_generated_method = "0FF800E730D27638BECE082A762D3E20")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean getDefaultEditable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.491 -0400", hash_original_method = "B69FA8267E3DCA70E8EEE3A6942BD033", hash_generated_method = "AA3B1753521D7361BCE52B3668E592C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected MovementMethod getDefaultMovementMethod() {
        MovementMethod varBB618D50364A6E9E793B17C91DE2474A_2053777877 = (ArrowKeyMovementMethod.getInstance());
        return (MovementMethod)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ArrowKeyMovementMethod.getInstance();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.491 -0400", hash_original_method = "7E84A3A8580CD7F3BD2A1E596441D1C1", hash_generated_method = "0195B9948A934FBD28F6D0AB499F1969")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Editable getText() {
        Editable var863152604FE1ED58993A64E1D9EC6E84_1263587647 = ((Editable) super.getText());
        return (Editable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Editable) super.getText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.491 -0400", hash_original_method = "91EEE8E208E2C0AA25FB9684496DF44B", hash_generated_method = "D4795B1F2933D8819A3DA63A17F3615C")
    @DSModeled(DSC.SAFE)
    @Override
    public void setText(CharSequence text, BufferType type) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(type.dsTaint);
        super.setText(text, BufferType.EDITABLE);
        // ---------- Original Method ----------
        //super.setText(text, BufferType.EDITABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.491 -0400", hash_original_method = "F43056F38C29E5CA5FEFE1CD9DA04514", hash_generated_method = "0026B086A5A7C25A6814BAAA10E261F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelection(int start, int stop) {
        dsTaint.addTaint(stop);
        dsTaint.addTaint(start);
        Selection.setSelection(getText(), start, stop);
        // ---------- Original Method ----------
        //Selection.setSelection(getText(), start, stop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.491 -0400", hash_original_method = "A198D78C33BD7BD56EF74E8B7D53E824", hash_generated_method = "7907AA167B2661D39750B31FDEA72D07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelection(int index) {
        dsTaint.addTaint(index);
        Selection.setSelection(getText(), index);
        // ---------- Original Method ----------
        //Selection.setSelection(getText(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.491 -0400", hash_original_method = "49D3F8B7E29E8DF6F83DD071F1ED7D81", hash_generated_method = "7AE7390BAD696BFA4C2071C7DD76896B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void selectAll() {
        Selection.selectAll(getText());
        // ---------- Original Method ----------
        //Selection.selectAll(getText());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.491 -0400", hash_original_method = "673DC4021002F481902DEBB3491C7A8B", hash_generated_method = "3614C94F8F8493A398C9897AAAAFFA18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void extendSelection(int index) {
        dsTaint.addTaint(index);
        Selection.extendSelection(getText(), index);
        // ---------- Original Method ----------
        //Selection.extendSelection(getText(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.492 -0400", hash_original_method = "6149CD37480D13E19ED1369D0EB1259F", hash_generated_method = "279D0B5A285EC787B2059BEA4A998556")
    @DSModeled(DSC.SAFE)
    @Override
    public void setEllipsize(TextUtils.TruncateAt ellipsis) {
        dsTaint.addTaint(ellipsis.dsTaint);
        {
            throw new IllegalArgumentException("EditText cannot use the ellipsize mode "
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


