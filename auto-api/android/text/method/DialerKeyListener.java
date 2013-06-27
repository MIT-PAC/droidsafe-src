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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.584 -0400", hash_original_method = "DB0B81FF92CA7DAE82B6AED220522587", hash_generated_method = "DB0B81FF92CA7DAE82B6AED220522587")
    public DialerKeyListener ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.585 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "8A06BDA8C1CDB1981E7DA72F63C7A745")
    @Override
    protected char[] getAcceptedChars() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1420375007 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1420375007;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
        public static DialerKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new DialerKeyListener();
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.598 -0400", hash_original_method = "CF04961F3F1B69C39A5779241DF2A6D8", hash_generated_method = "C7122058C5EACD5F43EC4DEBBC816F85")
    public int getInputType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1911522236 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1911522236;
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_PHONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.599 -0400", hash_original_method = "660AADB0BB44A0CB147F8CE16CBE33CA", hash_generated_method = "523F0C7F5AACBA6FFC7CD3B8C25C681B")
    protected int lookup(KeyEvent event, Spannable content) {
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
                    boolean varC9C84520A17813D16A43F6ADD70CDDCD_2031073343 = (event.getKeyData(kd));
                    {
                        {
                            int i;
                            i = 1;
                            {
                                {
                                    boolean var8F7F4A1842E5DA897EFF4C810945772F_1379034455 = (ok(accepted, kd.meta[i]));
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(event.getTaint());
        addTaint(content.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_706088965 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_706088965;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.599 -0400", hash_original_field = "88EFBAD36DBE586BF632B31FDD27DD01", hash_generated_field = "4EF1E1883C2FEAA834D956A6C02634B3")

    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '#', '*',
            '+', '-', '(', ')', ',', '/', 'N', '.', ' ', ';'
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.599 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "056A87FCF20D35A01976664357B66FF4")

    private static DialerKeyListener sInstance;
}

