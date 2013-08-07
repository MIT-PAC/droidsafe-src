package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.util.AttributeSet;
import android.inputmethodservice.KeyboardView;
public class PasswordEntryKeyboardView extends KeyboardView {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.168 -0400", hash_original_method = "8CAB09693A3A16C4AF4E637E08C8FEC9", hash_generated_method = "6975FCF52D91BE25D6003C4D70850ADE")
    public  PasswordEntryKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.168 -0400", hash_original_method = "2FA89E912EE0E874354BBE9FEE979226", hash_generated_method = "58BC65544F4FD87C115C4DF32E4B9142")
    public  PasswordEntryKeyboardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.169 -0400", hash_original_method = "0A8344B36255A84C9FDACA879DB5B816", hash_generated_method = "6792C209D9C17A3E1AE046E139F74C10")
    @Override
    public boolean setShifted(boolean shifted) {
        addTaint(shifted);
        boolean result = super.setShifted(shifted);
        int[] indices = getKeyboard().getShiftKeyIndices();
for(int index : indices)
        {
invalidateKey(index)
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_692444125 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1552287808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1552287808;
        // ---------- Original Method ----------
        //boolean result = super.setShifted(shifted);
        //int[] indices = getKeyboard().getShiftKeyIndices();
        //for (int index : indices) {
            //invalidateKey(index);
        //}
        //return result;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.169 -0400", hash_original_field = "66D3C06986D0B4BF2AAE5C845700D2C1", hash_generated_field = "88C07B5D1221F6CC9063F769B500BB6B")

    static final int KEYCODE_OPTIONS = -100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.170 -0400", hash_original_field = "D8AAFB699A75C1C043545A15D15CD8AF", hash_generated_field = "F6BDEAE01B262D4040B544FE03D8BD97")

    static final int KEYCODE_SHIFT_LONGPRESS = -101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.170 -0400", hash_original_field = "5DEF03078EC9324E29C0C1D40FDB36A4", hash_generated_field = "759561E07422A5EB30CCA25E82309AE6")

    static final int KEYCODE_VOICE = -102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.170 -0400", hash_original_field = "22DF498028D6E3A0B1916BAB3CC3712A", hash_generated_field = "C17E408A35122F7C38835B4A88C7463F")

    static final int KEYCODE_F1 = -103;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.170 -0400", hash_original_field = "8A32333DE8FA5604899A10ABD5E8A350", hash_generated_field = "F1AB44FB6729E7732A69F48601C9FEFF")

    static final int KEYCODE_NEXT_LANGUAGE = -104;
}

