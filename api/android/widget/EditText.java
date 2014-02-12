package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.util.AttributeSet;

public class EditText extends TextView {
    @DSComment("GUI/EditText, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.035 -0500", hash_original_method = "3D8BBCF9E8BFADB5EA8354D28833D1D0", hash_generated_method = "C75AE58EE7E177481EFAC327F009D2AF")
    
public EditText(Context context) {
        this(context, null);
    }

    @DSComment("GUI/EditText, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.038 -0500", hash_original_method = "13651F89327987238C61359B94395EF4", hash_generated_method = "839BB48F992F6EDC4F6529EB4CFBC279")
    
public EditText(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.editTextStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.040 -0500", hash_original_method = "B310470CAC184D932B7E9107B288DF59", hash_generated_method = "96F551ACA7625DCE5E3C0BAEC552DCDA")
    
public EditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.042 -0500", hash_original_method = "78689D8CF0BA47FA74C236553C6AEDBF", hash_generated_method = "25597A8E2CEB5B7E359C206F209D1756")
    
@Override
    protected boolean getDefaultEditable() {
        return true;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.044 -0500", hash_original_method = "B69FA8267E3DCA70E8EEE3A6942BD033", hash_generated_method = "827C518ACE25A445E808B13E1896D522")
    
@Override
    protected MovementMethod getDefaultMovementMethod() {
        return ArrowKeyMovementMethod.getInstance();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.GUI})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.047 -0500", hash_original_method = "7E84A3A8580CD7F3BD2A1E596441D1C1", hash_generated_method = "8266E1AA5ACD94F6F88AA30EBD01D147")
    
@Override
    public Editable getText() {
        return (Editable) super.getText();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.049 -0500", hash_original_method = "91EEE8E208E2C0AA25FB9684496DF44B", hash_generated_method = "F4CE5E692ED684A96EEE23BA8F4FEFCF")
    
@Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, BufferType.EDITABLE);
    }

    /**
     * Convenience for {@link Selection#setSelection(Spannable, int, int)}.
     */
    @DSComment("GUI/EditText, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.051 -0500", hash_original_method = "F43056F38C29E5CA5FEFE1CD9DA04514", hash_generated_method = "9C182A29414CB267A68687703D8459E4")
    
public void setSelection(int start, int stop) {
        Selection.setSelection(getText(), start, stop);
    }

    /**
     * Convenience for {@link Selection#setSelection(Spannable, int)}.
     */
    @DSComment("GUI/EditText, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.053 -0500", hash_original_method = "A198D78C33BD7BD56EF74E8B7D53E824", hash_generated_method = "3A18037E551DA3E220EF61A1C619D38D")
    
public void setSelection(int index) {
        Selection.setSelection(getText(), index);
    }

    /**
     * Convenience for {@link Selection#selectAll}.
     */
    @DSComment("GUI/EditText, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.056 -0500", hash_original_method = "49D3F8B7E29E8DF6F83DD071F1ED7D81", hash_generated_method = "2A8DBF255241177793079CC07A11E6A1")
    
public void selectAll() {
        Selection.selectAll(getText());
    }

    /**
     * Convenience for {@link Selection#extendSelection}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.058 -0500", hash_original_method = "673DC4021002F481902DEBB3491C7A8B", hash_generated_method = "129866D157F67B037238DC97D96D904C")
    
public void extendSelection(int index) {
        Selection.extendSelection(getText(), index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.060 -0500", hash_original_method = "6149CD37480D13E19ED1369D0EB1259F", hash_generated_method = "B85F62DC494030C28FDECABCDE97C862")
    
@Override
    public void setEllipsize(TextUtils.TruncateAt ellipsis) {
        if (ellipsis == TextUtils.TruncateAt.MARQUEE) {
            throw new IllegalArgumentException("EditText cannot use the ellipsize mode "
                    + "TextUtils.TruncateAt.MARQUEE");
        }
        super.setEllipsize(ellipsis);
    }
    
}

