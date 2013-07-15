package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.util.AttributeSet;

public class EditText extends TextView {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.183 -0400", hash_original_method = "3D8BBCF9E8BFADB5EA8354D28833D1D0", hash_generated_method = "004227708DFAC48EEFF94D6D5031CBB9")
    public  EditText(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.183 -0400", hash_original_method = "13651F89327987238C61359B94395EF4", hash_generated_method = "3FF0FF407F2CA1CB4EA5D0515F8EEC5E")
    public  EditText(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.editTextStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.183 -0400", hash_original_method = "B310470CAC184D932B7E9107B288DF59", hash_generated_method = "E87959948F5E5A6B16FF5C15C3C9990B")
    public  EditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.183 -0400", hash_original_method = "78689D8CF0BA47FA74C236553C6AEDBF", hash_generated_method = "FF305A4EFE6F6CAFC82FF5FE7F50DAC9")
    @Override
    protected boolean getDefaultEditable() {
        boolean varB326B5062B2F0E69046810717534CB09_822857563 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1647674324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1647674324;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.183 -0400", hash_original_method = "B69FA8267E3DCA70E8EEE3A6942BD033", hash_generated_method = "086BA74C9CAF35749ED95D00CACE4A3B")
    @Override
    protected MovementMethod getDefaultMovementMethod() {
MovementMethod varB9DD7E3298263497125F004EAD4CC7BD_1633209761 =         ArrowKeyMovementMethod.getInstance();
        varB9DD7E3298263497125F004EAD4CC7BD_1633209761.addTaint(taint);
        return varB9DD7E3298263497125F004EAD4CC7BD_1633209761;
        // ---------- Original Method ----------
        //return ArrowKeyMovementMethod.getInstance();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.184 -0400", hash_original_method = "7E84A3A8580CD7F3BD2A1E596441D1C1", hash_generated_method = "60E20901D142DAD535F680BE58566F6D")
    @Override
    public Editable getText() {
Editable varCE395BFEABB3FF1A9551A05D26DCF380_1193940722 =         (Editable) super.getText();
        varCE395BFEABB3FF1A9551A05D26DCF380_1193940722.addTaint(taint);
        return varCE395BFEABB3FF1A9551A05D26DCF380_1193940722;
        // ---------- Original Method ----------
        //return (Editable) super.getText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.184 -0400", hash_original_method = "91EEE8E208E2C0AA25FB9684496DF44B", hash_generated_method = "2D42A95E529D983F0740C56AD7A748FD")
    @Override
    public void setText(CharSequence text, BufferType type) {
        addTaint(type.getTaint());
        addTaint(text.getTaint());
        super.setText(text, BufferType.EDITABLE);
        // ---------- Original Method ----------
        //super.setText(text, BufferType.EDITABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.184 -0400", hash_original_method = "F43056F38C29E5CA5FEFE1CD9DA04514", hash_generated_method = "477930099A210C7BD7E75CB7763A1DE0")
    public void setSelection(int start, int stop) {
        addTaint(stop);
        addTaint(start);
        Selection.setSelection(getText(), start, stop);
        // ---------- Original Method ----------
        //Selection.setSelection(getText(), start, stop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.184 -0400", hash_original_method = "A198D78C33BD7BD56EF74E8B7D53E824", hash_generated_method = "7849FE2D5E16C406C540974B4FB09316")
    public void setSelection(int index) {
        addTaint(index);
        Selection.setSelection(getText(), index);
        // ---------- Original Method ----------
        //Selection.setSelection(getText(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.184 -0400", hash_original_method = "49D3F8B7E29E8DF6F83DD071F1ED7D81", hash_generated_method = "9187CC6366D6115D68A15990FFCCDB01")
    public void selectAll() {
        Selection.selectAll(getText());
        // ---------- Original Method ----------
        //Selection.selectAll(getText());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.184 -0400", hash_original_method = "673DC4021002F481902DEBB3491C7A8B", hash_generated_method = "113BB940A600B9B7FB8B4F6D99635543")
    public void extendSelection(int index) {
        addTaint(index);
        Selection.extendSelection(getText(), index);
        // ---------- Original Method ----------
        //Selection.extendSelection(getText(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.184 -0400", hash_original_method = "6149CD37480D13E19ED1369D0EB1259F", hash_generated_method = "FD328FDEA4C6F92A53FCF49F211C1F65")
    @Override
    public void setEllipsize(TextUtils.TruncateAt ellipsis) {
        addTaint(ellipsis.getTaint());
    if(ellipsis == TextUtils.TruncateAt.MARQUEE)        
        {
            IllegalArgumentException varC2DC157A2F69A245A537D9DBE7256FCB_448726113 = new IllegalArgumentException("EditText cannot use the ellipsize mode "
                    + "TextUtils.TruncateAt.MARQUEE");
            varC2DC157A2F69A245A537D9DBE7256FCB_448726113.addTaint(taint);
            throw varC2DC157A2F69A245A537D9DBE7256FCB_448726113;
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

