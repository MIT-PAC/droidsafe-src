package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.KeyEvent;
import android.view.KeyCharacterMap.KeyData;
import android.text.InputType;
import android.text.Spannable;

public class DialerKeyListener extends NumberKeyListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.252 -0400", hash_original_method = "84424E2B00FD8045A98B770C9CE373E8", hash_generated_method = "84424E2B00FD8045A98B770C9CE373E8")
        public DialerKeyListener ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.262 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "61C8E7B8858459A83CC3206E283F36CA")
    @DSModeled(DSC.SAFE)
    @Override
    protected char[] getAcceptedChars() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
        public static DialerKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new DialerKeyListener();
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.263 -0400", hash_original_method = "CF04961F3F1B69C39A5779241DF2A6D8", hash_generated_method = "BAFC1385C9983FB01CFFD5A8D6060F69")
    @DSModeled(DSC.SAFE)
    public int getInputType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_PHONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.263 -0400", hash_original_method = "660AADB0BB44A0CB147F8CE16CBE33CA", hash_generated_method = "609E92E785D9A71D04E0F86DCB6F2CD8")
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
                    boolean varC9C84520A17813D16A43F6ADD70CDDCD_1625667772 = (event.getKeyData(kd));
                    {
                        {
                            int i;
                            i = 1;
                            {
                                {
                                    boolean var8F7F4A1842E5DA897EFF4C810945772F_781161489 = (ok(accepted, kd.meta[i]));
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

    
    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '#', '*',
            '+', '-', '(', ')', ',', '/', 'N', '.', ' ', ';'
        };
    private static DialerKeyListener sInstance;
}

