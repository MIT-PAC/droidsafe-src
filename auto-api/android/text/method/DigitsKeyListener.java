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
    private char[] mAccepted;
    private boolean mSign;
    private boolean mDecimal;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.269 -0400", hash_original_method = "6BE6AAF45437494799568EB9C567DA33", hash_generated_method = "96F31F59DAF98D6C6BCAE9A71EA0B101")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DigitsKeyListener() {
        this(false, false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.269 -0400", hash_original_method = "FA23D3FC8F275B4F859DA176A5851F12", hash_generated_method = "12F5CE838C23AED40AD674A5A2B15ABA")
    @DSModeled(DSC.SAFE)
    public DigitsKeyListener(boolean sign, boolean decimal) {
        dsTaint.addTaint(sign);
        dsTaint.addTaint(decimal);
        int kind;
        kind = (sign ? SIGN : 0) | (decimal ? DECIMAL : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
        mAccepted = CHARACTERS[kind];
        // ---------- Original Method ----------
        //mSign = sign;
        //mDecimal = decimal;
        //int kind = (sign ? SIGN : 0) | (decimal ? DECIMAL : 0);
        //mAccepted = CHARACTERS[kind];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.270 -0400", hash_original_method = "699568E4919BD4E82DA190E9B839182F", hash_generated_method = "59DB2118926376E525ADEEB46DC19D69")
    @DSModeled(DSC.SAFE)
    @Override
    protected char[] getAcceptedChars() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.270 -0400", hash_original_method = "C58B63A603B7A45CFB1185F323DD143F", hash_generated_method = "3C22278AB12853453CBEA9B0D6E9B4F1")
    @DSModeled(DSC.SAFE)
    public int getInputType() {
        int contentType;
        contentType = InputType.TYPE_CLASS_NUMBER;
        {
            contentType |= InputType.TYPE_NUMBER_FLAG_SIGNED;
        } //End block
        {
            contentType |= InputType.TYPE_NUMBER_FLAG_DECIMAL;
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.278 -0400", hash_original_method = "A15A4B8B8366C48B770873BA3926F314", hash_generated_method = "9E2501C7835D159E59470EE22421EB05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(dstart);
        dsTaint.addTaint(source);
        dsTaint.addTaint(dend);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        CharSequence out;
        out = super.filter(source, start, end, dest, dstart, dend);
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
                        stripped = new SpannableStringBuilder(source, start, end);
                    } //End block
                    stripped.delete(i - start, i + 1 - start);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final int SIGN = 1;
    private static final int DECIMAL = 2;
    private static final char[][] CHARACTERS = new char[][] {
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.' },
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '.' },
    };
    private static DigitsKeyListener[] sInstance = new DigitsKeyListener[4];
}

