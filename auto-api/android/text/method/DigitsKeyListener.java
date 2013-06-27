package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.InputType;
import android.text.Spanned;
import android.text.SpannableStringBuilder;
import android.view.KeyEvent;

public class DigitsKeyListener extends NumberKeyListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.658 -0400", hash_original_field = "67FFB6CBBC91A7DDA72F7BC62403D295", hash_generated_field = "FBD332757CDFEDE23B2BA55765028B23")

    private char[] mAccepted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.658 -0400", hash_original_field = "87C05CE1C9CC37E62F746EB6D178BB62", hash_generated_field = "DF79E0DF89ACDF64D761C1782A7E912A")

    private boolean mSign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.659 -0400", hash_original_field = "829186412D45611128D017C2F49B0C89", hash_generated_field = "7A06359B1E28700086DF0A30BF482E7C")

    private boolean mDecimal;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.659 -0400", hash_original_method = "6BE6AAF45437494799568EB9C567DA33", hash_generated_method = "96F31F59DAF98D6C6BCAE9A71EA0B101")
    public  DigitsKeyListener() {
        this(false, false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.659 -0400", hash_original_method = "FA23D3FC8F275B4F859DA176A5851F12", hash_generated_method = "29BB84EAA8A60BA04D9CF2E9829C0B16")
    public  DigitsKeyListener(boolean sign, boolean decimal) {
        mSign = sign;
        mDecimal = decimal;
        int kind;
        kind = (sign ? SIGN : 0) | (decimal ? DECIMAL : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
        mAccepted = CHARACTERS[kind];
        // ---------- Original Method ----------
        //mSign = sign;
        //mDecimal = decimal;
        //int kind = (sign ? SIGN : 0) | (decimal ? DECIMAL : 0);
        //mAccepted = CHARACTERS[kind];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.661 -0400", hash_original_method = "699568E4919BD4E82DA190E9B839182F", hash_generated_method = "0CB8D7403334A621DFE8998BDBDE6A0D")
    @Override
    protected char[] getAcceptedChars() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_557882940 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_557882940;
        // ---------- Original Method ----------
        //return mAccepted;
    }

    
        public static DigitsKeyListener getInstance() {
        return getInstance(false, false);
    }

    
        public static DigitsKeyListener getInstance(boolean sign, boolean decimal) {
        int kind = (sign ? SIGN : 0) | (decimal ? DECIMAL : 0);
        if (sInstance[kind] != null)
            return sInstance[kind];
        sInstance[kind] = new DigitsKeyListener(sign, decimal);
        return sInstance[kind];
    }

    
        public static DigitsKeyListener getInstance(String accepted) {
        DigitsKeyListener dim = new DigitsKeyListener();
        dim.mAccepted = new char[accepted.length()];
        accepted.getChars(0, accepted.length(), dim.mAccepted, 0);
        return dim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.675 -0400", hash_original_method = "C58B63A603B7A45CFB1185F323DD143F", hash_generated_method = "F82367C2FFF589C1220FCBFFFEFCF658")
    public int getInputType() {
        int contentType;
        contentType = InputType.TYPE_CLASS_NUMBER;
        {
            contentType |= InputType.TYPE_NUMBER_FLAG_SIGNED;
        } //End block
        {
            contentType |= InputType.TYPE_NUMBER_FLAG_DECIMAL;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178260478 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178260478;
        // ---------- Original Method ----------
        //int contentType = InputType.TYPE_CLASS_NUMBER;
        //if (mSign) {
            //contentType |= InputType.TYPE_NUMBER_FLAG_SIGNED;
        //}
        //if (mDecimal) {
            //contentType |= InputType.TYPE_NUMBER_FLAG_DECIMAL;
        //}
        //return contentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.677 -0400", hash_original_method = "A15A4B8B8366C48B770873BA3926F314", hash_generated_method = "B7E9C76D9ECB75E5DB4FA192D0803A44")
    @Override
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1116419318 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1975717737 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1624488402 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_992756522 = null; //Variable for return #4
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1266007843 = null; //Variable for return #5
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1053743195 = null; //Variable for return #6
        CharSequence out;
        out = super.filter(source, start, end, dest, dstart, dend);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1116419318 = out;
        } //End block
        {
            source = out;
            start = 0;
            end = out.length();
        } //End block
        int sign;
        sign = -1;
        int decimal;
        decimal = -1;
        int dlen;
        dlen = dest.length();
        {
            int i;
            i = 0;
            {
                char c;
                c = dest.charAt(i);
                {
                    sign = i;
                } //End block
                {
                    decimal = i;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = dend;
            {
                char c;
                c = dest.charAt(i);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1975717737 = "";
                } //End block
                {
                    decimal = i;
                } //End block
            } //End block
        } //End collapsed parenthetic
        SpannableStringBuilder stripped;
        stripped = null;
        {
            int i;
            i = end - 1;
            {
                char c;
                c = source.charAt(i);
                boolean strip;
                strip = false;
                {
                    {
                        strip = true;
                    } //End block
                    {
                        strip = true;
                    } //End block
                    {
                        sign = i;
                    } //End block
                } //End block
                {
                    {
                        strip = true;
                    } //End block
                    {
                        decimal = i;
                    } //End block
                } //End block
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1624488402 = "";
                    } //End block
                    {
                        stripped = new SpannableStringBuilder(source, start, end);
                    } //End block
                    stripped.delete(i - start, i + 1 - start);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_992756522 = stripped;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1266007843 = out;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1053743195 = null;
        } //End block
        addTaint(source.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(dest.getTaint());
        addTaint(dstart);
        addTaint(dend);
        CharSequence varA7E53CE21691AB073D9660D615818899_1703917914; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1703917914 = varB4EAC82CA7396A68D541C85D26508E83_1116419318;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1703917914 = varB4EAC82CA7396A68D541C85D26508E83_1975717737;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1703917914 = varB4EAC82CA7396A68D541C85D26508E83_1624488402;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1703917914 = varB4EAC82CA7396A68D541C85D26508E83_992756522;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1703917914 = varB4EAC82CA7396A68D541C85D26508E83_1266007843;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1703917914 = varB4EAC82CA7396A68D541C85D26508E83_1053743195;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1703917914.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1703917914;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.678 -0400", hash_original_field = "54EA717656EB72F80C9A4088611AE54F", hash_generated_field = "155F8B71B198D222816961362007528A")

    private static int SIGN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.679 -0400", hash_original_field = "5115BA8161AF55A848008D20D03C1E0B", hash_generated_field = "31D38620325A1954F6B30738BE95A0D7")

    private static int DECIMAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.679 -0400", hash_original_field = "A7A6F8C933AFE3CE24F9468A50DED8A3", hash_generated_field = "54F14BACC8D846287B15FD740239F27C")

    private static char[][] CHARACTERS = new char[][] {
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '.' },
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.679 -0400", hash_original_field = "A7BDF191A142F8C9C7AC4E7B07715B9B", hash_generated_field = "B8F590F34DFCDBF52CF3AEE279594740")

    private static DigitsKeyListener[] sInstance = new DigitsKeyListener[4];
}

