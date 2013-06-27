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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.229 -0400", hash_original_method = "3D8BBCF9E8BFADB5EA8354D28833D1D0", hash_generated_method = "004227708DFAC48EEFF94D6D5031CBB9")
    public  EditText(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.229 -0400", hash_original_method = "13651F89327987238C61359B94395EF4", hash_generated_method = "C36FB6884D5F6BD119CC9F10408425F7")
    public  EditText(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.editTextStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.229 -0400", hash_original_method = "B310470CAC184D932B7E9107B288DF59", hash_generated_method = "98C9B8CC2F81B20F7D81251803DD84C8")
    public  EditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.230 -0400", hash_original_method = "78689D8CF0BA47FA74C236553C6AEDBF", hash_generated_method = "766FEAACFF43C7F7CB1DEAE1C798391C")
    @Override
    protected boolean getDefaultEditable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_615004050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_615004050;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.230 -0400", hash_original_method = "B69FA8267E3DCA70E8EEE3A6942BD033", hash_generated_method = "1A2F2A624525A49C1C14E173F4A17374")
    @Override
    protected MovementMethod getDefaultMovementMethod() {
        MovementMethod varB4EAC82CA7396A68D541C85D26508E83_960990070 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_960990070 = ArrowKeyMovementMethod.getInstance();
        varB4EAC82CA7396A68D541C85D26508E83_960990070.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_960990070;
        // ---------- Original Method ----------
        //return ArrowKeyMovementMethod.getInstance();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.230 -0400", hash_original_method = "7E84A3A8580CD7F3BD2A1E596441D1C1", hash_generated_method = "722049F88B52792BB798C32058738C86")
    @Override
    public Editable getText() {
        Editable varB4EAC82CA7396A68D541C85D26508E83_108907476 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_108907476 = (Editable) super.getText();
        varB4EAC82CA7396A68D541C85D26508E83_108907476.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_108907476;
        // ---------- Original Method ----------
        //return (Editable) super.getText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.231 -0400", hash_original_method = "91EEE8E208E2C0AA25FB9684496DF44B", hash_generated_method = "4EEDC90744993F3B4F1896EE297F723A")
    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, BufferType.EDITABLE);
        addTaint(text.getTaint());
        addTaint(type.getTaint());
        // ---------- Original Method ----------
        //super.setText(text, BufferType.EDITABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.231 -0400", hash_original_method = "F43056F38C29E5CA5FEFE1CD9DA04514", hash_generated_method = "CECA43DE323A6677AA02445E31D56446")
    public void setSelection(int start, int stop) {
        Selection.setSelection(getText(), start, stop);
        addTaint(start);
        addTaint(stop);
        // ---------- Original Method ----------
        //Selection.setSelection(getText(), start, stop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.238 -0400", hash_original_method = "A198D78C33BD7BD56EF74E8B7D53E824", hash_generated_method = "C2A80B9E08F0EE489D1AEFA57DCCA648")
    public void setSelection(int index) {
        Selection.setSelection(getText(), index);
        addTaint(index);
        // ---------- Original Method ----------
        //Selection.setSelection(getText(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.258 -0400", hash_original_method = "49D3F8B7E29E8DF6F83DD071F1ED7D81", hash_generated_method = "9187CC6366D6115D68A15990FFCCDB01")
    public void selectAll() {
        Selection.selectAll(getText());
        // ---------- Original Method ----------
        //Selection.selectAll(getText());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.258 -0400", hash_original_method = "673DC4021002F481902DEBB3491C7A8B", hash_generated_method = "CD960D0C9B6BBB19E8EC7A8047C851AB")
    public void extendSelection(int index) {
        Selection.extendSelection(getText(), index);
        addTaint(index);
        // ---------- Original Method ----------
        //Selection.extendSelection(getText(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.258 -0400", hash_original_method = "6149CD37480D13E19ED1369D0EB1259F", hash_generated_method = "F0EFC67AE73C4425FF9DDD30D173F842")
    @Override
    public void setEllipsize(TextUtils.TruncateAt ellipsis) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("EditText cannot use the ellipsize mode "
                    + "TextUtils.TruncateAt.MARQUEE");
        } //End block
        super.setEllipsize(ellipsis);
        addTaint(ellipsis.getTaint());
        // ---------- Original Method ----------
        //if (ellipsis == TextUtils.TruncateAt.MARQUEE) {
            //throw new IllegalArgumentException("EditText cannot use the ellipsize mode "
                    //+ "TextUtils.TruncateAt.MARQUEE");
        //}
        //super.setEllipsize(ellipsis);
    }

    
}

