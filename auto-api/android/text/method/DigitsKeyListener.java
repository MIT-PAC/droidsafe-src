package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.text.InputType;
import android.text.Spanned;
import android.text.SpannableStringBuilder;
import android.view.KeyEvent;

public class DigitsKeyListener extends NumberKeyListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.121 -0400", hash_original_field = "67FFB6CBBC91A7DDA72F7BC62403D295", hash_generated_field = "FBD332757CDFEDE23B2BA55765028B23")

    private char[] mAccepted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.121 -0400", hash_original_field = "87C05CE1C9CC37E62F746EB6D178BB62", hash_generated_field = "DF79E0DF89ACDF64D761C1782A7E912A")

    private boolean mSign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.121 -0400", hash_original_field = "829186412D45611128D017C2F49B0C89", hash_generated_field = "7A06359B1E28700086DF0A30BF482E7C")

    private boolean mDecimal;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.121 -0400", hash_original_method = "6BE6AAF45437494799568EB9C567DA33", hash_generated_method = "96F31F59DAF98D6C6BCAE9A71EA0B101")
    public  DigitsKeyListener() {
        this(false, false);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.121 -0400", hash_original_method = "FA23D3FC8F275B4F859DA176A5851F12", hash_generated_method = "24F0949F0826B040489951A3398DDD56")
    public  DigitsKeyListener(boolean sign, boolean decimal) {
        mSign = sign;
        mDecimal = decimal;
        int kind = (sign ? SIGN : 0) | (decimal ? DECIMAL : 0);
        mAccepted = CHARACTERS[kind];
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.122 -0400", hash_original_method = "699568E4919BD4E82DA190E9B839182F", hash_generated_method = "5FF11ED5F987FAD97CBDC101B1573B2C")
    @Override
    protected char[] getAcceptedChars() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1620102293 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1620102293;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static DigitsKeyListener getInstance() {
        return getInstance(false, false);
    }

    
    @DSModeled(DSC.SAFE)
    public static DigitsKeyListener getInstance(boolean sign, boolean decimal) {
        int kind = (sign ? SIGN : 0) | (decimal ? DECIMAL : 0);
        if (sInstance[kind] != null)
            return sInstance[kind];
        sInstance[kind] = new DigitsKeyListener(sign, decimal);
        return sInstance[kind];
    }

    
    @DSModeled(DSC.SAFE)
    public static DigitsKeyListener getInstance(String accepted) {
        DigitsKeyListener dim = new DigitsKeyListener();
        dim.mAccepted = new char[accepted.length()];
        accepted.getChars(0, accepted.length(), dim.mAccepted, 0);
        return dim;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.123 -0400", hash_original_method = "C58B63A603B7A45CFB1185F323DD143F", hash_generated_method = "E50153D2DF99DC789095F91091271BA7")
    public int getInputType() {
        int contentType = InputType.TYPE_CLASS_NUMBER;
        {
            contentType |= InputType.TYPE_NUMBER_FLAG_SIGNED;
        } 
        {
            contentType |= InputType.TYPE_NUMBER_FLAG_DECIMAL;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372891366 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372891366;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.124 -0400", hash_original_method = "A15A4B8B8366C48B770873BA3926F314", hash_generated_method = "CFEB1D8BCAD8E5DF8F961CC6AC650F7A")
    @Override
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_412987272 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_231291940 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_618366587 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_585459587 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1526086954 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_622881977 = null; 
        CharSequence out = super.filter(source, start, end, dest, dstart, dend);
        {
            varB4EAC82CA7396A68D541C85D26508E83_412987272 = out;
        } 
        {
            source = out;
            start = 0;
            end = out.length();
        } 
        int sign = -1;
        int decimal = -1;
        int dlen = dest.length();
        {
            int i = 0;
            {
                char c = dest.charAt(i);
                {
                    sign = i;
                } 
                {
                    decimal = i;
                } 
            } 
        } 
        {
            int i = dend;
            {
                char c = dest.charAt(i);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_231291940 = "";
                } 
                {
                    decimal = i;
                } 
            } 
        } 
        SpannableStringBuilder stripped = null;
        {
            int i = end - 1;
            {
                char c = source.charAt(i);
                boolean strip = false;
                {
                    {
                        strip = true;
                    } 
                    {
                        strip = true;
                    } 
                    {
                        sign = i;
                    } 
                } 
                {
                    {
                        strip = true;
                    } 
                    {
                        decimal = i;
                    } 
                } 
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_618366587 = "";
                    } 
                    {
                        stripped = new SpannableStringBuilder(source, start, end);
                    } 
                    stripped.delete(i - start, i + 1 - start);
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_585459587 = stripped;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1526086954 = out;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_622881977 = null;
        } 
        addTaint(source.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(dest.getTaint());
        addTaint(dstart);
        addTaint(dend);
        CharSequence varA7E53CE21691AB073D9660D615818899_502554603; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_502554603 = varB4EAC82CA7396A68D541C85D26508E83_412987272;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_502554603 = varB4EAC82CA7396A68D541C85D26508E83_231291940;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_502554603 = varB4EAC82CA7396A68D541C85D26508E83_618366587;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_502554603 = varB4EAC82CA7396A68D541C85D26508E83_585459587;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_502554603 = varB4EAC82CA7396A68D541C85D26508E83_1526086954;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_502554603 = varB4EAC82CA7396A68D541C85D26508E83_622881977;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_502554603.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_502554603;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.124 -0400", hash_original_field = "54EA717656EB72F80C9A4088611AE54F", hash_generated_field = "27720FB293DC4FF4123D0C85E570BCB6")

    private static final int SIGN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.124 -0400", hash_original_field = "5115BA8161AF55A848008D20D03C1E0B", hash_generated_field = "8E68DEC11AA5EEACCC41D4855066C73A")

    private static final int DECIMAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.124 -0400", hash_original_field = "A7A6F8C933AFE3CE24F9468A50DED8A3", hash_generated_field = "3BEE3624FE24902AB30D89EA40FAD665")

    private static final char[][] CHARACTERS = new char[][] {
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '.' },
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.124 -0400", hash_original_field = "A7BDF191A142F8C9C7AC4E7B07715B9B", hash_generated_field = "B8F590F34DFCDBF52CF3AEE279594740")

    private static DigitsKeyListener[] sInstance = new DigitsKeyListener[4];
}

