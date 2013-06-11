package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.view.KeyEvent;
import android.view.KeyCharacterMap.KeyData;
import android.text.InputType;
import android.text.Spannable;

public class DialerKeyListener extends NumberKeyListener {
    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '#', '*',
            '+', '-', '(', ')', ',', '/', 'N', '.', ' ', ';'
        };
    private static DialerKeyListener sInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.041 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "E6C46870770ED289B98202DA6B510228")
    @DSModeled(DSC.SAFE)
    @Override
    protected char[] getAcceptedChars() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.041 -0400", hash_original_method = "AE7C568B1FC945A3D62D83ECB6AACC3F", hash_generated_method = "0AA2BB67796C4A68DB2BDF94AD1A65E8")
    public static DialerKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new DialerKeyListener();
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.041 -0400", hash_original_method = "CF04961F3F1B69C39A5779241DF2A6D8", hash_generated_method = "6FDF87FC389C2D619445910F3CBC300B")
    @DSModeled(DSC.SAFE)
    public int getInputType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_PHONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.042 -0400", hash_original_method = "660AADB0BB44A0CB147F8CE16CBE33CA", hash_generated_method = "00647336DCE7D9ADA182B18644594EB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int lookup(KeyEvent event, Spannable content) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        int meta;
        meta = event.getMetaState() | getMetaState(content);
        int number;
        number = event.getNumber();
        int match;
        match = super.lookup(event, content);
        {
            {
                KeyData kd;
                kd = new KeyData();
                char[] accepted;
                accepted = getAcceptedChars();
                {
                    boolean varC9C84520A17813D16A43F6ADD70CDDCD_542959018 = (event.getKeyData(kd));
                    {
                        {
                            int i;
                            i = 1;
                            {
                                {
                                    boolean var8F7F4A1842E5DA897EFF4C810945772F_816878553 = (ok(accepted, kd.meta[i]));
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


