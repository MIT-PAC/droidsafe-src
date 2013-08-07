package android.text.method;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.text.InputType;
import android.text.SpannableStringBuilder;
import android.text.Spanned;





public class DigitsKeyListener extends NumberKeyListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.229 -0400", hash_original_field = "67FFB6CBBC91A7DDA72F7BC62403D295", hash_generated_field = "FBD332757CDFEDE23B2BA55765028B23")

    private char[] mAccepted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.229 -0400", hash_original_field = "87C05CE1C9CC37E62F746EB6D178BB62", hash_generated_field = "DF79E0DF89ACDF64D761C1782A7E912A")

    private boolean mSign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.229 -0400", hash_original_field = "829186412D45611128D017C2F49B0C89", hash_generated_field = "7A06359B1E28700086DF0A30BF482E7C")

    private boolean mDecimal;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.229 -0400", hash_original_method = "6BE6AAF45437494799568EB9C567DA33", hash_generated_method = "96F31F59DAF98D6C6BCAE9A71EA0B101")
    public  DigitsKeyListener() {
        this(false, false);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.229 -0400", hash_original_method = "FA23D3FC8F275B4F859DA176A5851F12", hash_generated_method = "CC71E0DDF004012087625C769F1BD779")
    public  DigitsKeyListener(boolean sign, boolean decimal) {
        mSign = sign;
        mDecimal = decimal;
        int kind = (sign ? SIGN : 0) | (decimal ? DECIMAL : 0);
        mAccepted = CHARACTERS[kind];
        // ---------- Original Method ----------
        //mSign = sign;
        //mDecimal = decimal;
        //int kind = (sign ? SIGN : 0) | (decimal ? DECIMAL : 0);
        //mAccepted = CHARACTERS[kind];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.229 -0400", hash_original_method = "699568E4919BD4E82DA190E9B839182F", hash_generated_method = "0DB0C6C49CEA4D7AD194661035967493")
    @Override
    protected char[] getAcceptedChars() {
        char[] var67FFB6CBBC91A7DDA72F7BC62403D295_799205174 = (mAccepted);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1745289507 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1745289507;
        // ---------- Original Method ----------
        //return mAccepted;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.229 -0400", hash_original_method = "C58B63A603B7A45CFB1185F323DD143F", hash_generated_method = "317191B4514F83FBE848377C4138884C")
    public int getInputType() {
        int contentType = InputType.TYPE_CLASS_NUMBER;
        if(mSign)        
        {
            contentType |= InputType.TYPE_NUMBER_FLAG_SIGNED;
        } //End block
        if(mDecimal)        
        {
            contentType |= InputType.TYPE_NUMBER_FLAG_DECIMAL;
        } //End block
        int varDF5FEAFAB86601EA0E1E6FE6E20DF6C5_1358747545 = (contentType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_875973510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_875973510;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.230 -0400", hash_original_method = "A15A4B8B8366C48B770873BA3926F314", hash_generated_method = "2EBCB80168F644DB63D7D8ADBA558A11")
    @Override
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        addTaint(dend);
        addTaint(dstart);
        addTaint(dest.getTaint());
        addTaint(end);
        addTaint(start);
        addTaint(source.getTaint());
        CharSequence out = super.filter(source, start, end, dest, dstart, dend);
        if(mSign == false && mDecimal == false)        
        {
CharSequence varFE81D892BE5757A0E16305825903D324_1806188538 =             out;
            varFE81D892BE5757A0E16305825903D324_1806188538.addTaint(taint);
            return varFE81D892BE5757A0E16305825903D324_1806188538;
        } //End block
        if(out != null)        
        {
            source = out;
            start = 0;
            end = out.length();
        } //End block
        int sign = -1;
        int decimal = -1;
        int dlen = dest.length();
for(int i = 0;i < dstart;i++)
        {
            char c = dest.charAt(i);
            if(c == '-')            
            {
                sign = i;
            } //End block
            else
            if(c == '.')            
            {
                decimal = i;
            } //End block
        } //End block
for(int i = dend;i < dlen;i++)
        {
            char c = dest.charAt(i);
            if(c == '-')            
            {
CharSequence var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1519111257 =                 "";
                var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1519111257.addTaint(taint);
                return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1519111257;
            } //End block
            else
            if(c == '.')            
            {
                decimal = i;
            } //End block
        } //End block
        SpannableStringBuilder stripped = null;
for(int i = end - 1;i >= start;i--)
        {
            char c = source.charAt(i);
            boolean strip = false;
            if(c == '-')            
            {
                if(i != start || dstart != 0)                
                {
                    strip = true;
                } //End block
                else
                if(sign >= 0)                
                {
                    strip = true;
                } //End block
                else
                {
                    sign = i;
                } //End block
            } //End block
            else
            if(c == '.')            
            {
                if(decimal >= 0)                
                {
                    strip = true;
                } //End block
                else
                {
                    decimal = i;
                } //End block
            } //End block
            if(strip)            
            {
                if(end == start + 1)                
                {
CharSequence var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1257720330 =                     "";
                    var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1257720330.addTaint(taint);
                    return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1257720330;
                } //End block
                if(stripped == null)                
                {
                    stripped = new SpannableStringBuilder(source, start, end);
                } //End block
                stripped.delete(i - start, i + 1 - start);
            } //End block
        } //End block
        if(stripped != null)        
        {
CharSequence var25E449BBD49C0A469987C92F7B002720_447744876 =             stripped;
            var25E449BBD49C0A469987C92F7B002720_447744876.addTaint(taint);
            return var25E449BBD49C0A469987C92F7B002720_447744876;
        } //End block
        else
        if(out != null)        
        {
CharSequence varFE81D892BE5757A0E16305825903D324_297614165 =             out;
            varFE81D892BE5757A0E16305825903D324_297614165.addTaint(taint);
            return varFE81D892BE5757A0E16305825903D324_297614165;
        } //End block
        else
        {
CharSequence var540C13E9E156B687226421B24F2DF178_2119609149 =             null;
            var540C13E9E156B687226421B24F2DF178_2119609149.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2119609149;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.230 -0400", hash_original_field = "54EA717656EB72F80C9A4088611AE54F", hash_generated_field = "27720FB293DC4FF4123D0C85E570BCB6")

    private static final int SIGN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.230 -0400", hash_original_field = "5115BA8161AF55A848008D20D03C1E0B", hash_generated_field = "8E68DEC11AA5EEACCC41D4855066C73A")

    private static final int DECIMAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.230 -0400", hash_original_field = "A7A6F8C933AFE3CE24F9468A50DED8A3", hash_generated_field = "3BEE3624FE24902AB30D89EA40FAD665")

    private static final char[][] CHARACTERS = new char[][] {
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '.' },
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.231 -0400", hash_original_field = "A7BDF191A142F8C9C7AC4E7B07715B9B", hash_generated_field = "B8F590F34DFCDBF52CF3AEE279594740")

    private static DigitsKeyListener[] sInstance = new DigitsKeyListener[4];
}

