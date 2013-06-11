package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.android.internal.util.ArrayUtils;
import java.lang.reflect.Array;

public class SpannableStringBuilder implements CharSequence, GetChars, Spannable, Editable, Appendable, GraphicsOperations {
    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    private InputFilter[] mFilters = NO_FILTERS;
    private char[] mText;
    private int mGapStart;
    private int mGapLength;
    private Object[] mSpans;
    private int[] mSpanStarts;
    private int[] mSpanEnds;
    private int[] mSpanFlags;
    private int mSpanCount;
    private static final int POINT = 2;
    private static final int PARAGRAPH = 3;
    private static final int START_MASK = 0xF0;
    private static final int END_MASK = 0x0F;
    private static final int START_SHIFT = 4;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.204 -0400", hash_original_method = "FC61BFC3FC94A92F6E91F05B84386B00", hash_generated_method = "3B844355E14A2D8F4AF7EC252D5DB304")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannableStringBuilder() {
        this("");
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.204 -0400", hash_original_method = "9676D8694A6D1EC55F8FB5E1D9DC6D95", hash_generated_method = "F29464E3B8CBB8DC0EE7590112206141")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannableStringBuilder(CharSequence text) {
        this(text, 0, text.length());
        dsTaint.addTaint(text);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.205 -0400", hash_original_method = "D35C3B0425645BAC16D8668E04F8F0BF", hash_generated_method = "3CADAC2EE70339A657D890CD7879C1DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannableStringBuilder(CharSequence text, int start, int end) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        int srclen;
        srclen = end - start;
        int len;
        len = ArrayUtils.idealCharArraySize(srclen + 1);
        mText = new char[len];
        mGapStart = srclen;
        mGapLength = len - srclen;
        TextUtils.getChars(text, start, end, mText, 0);
        mSpanCount = 0;
        int alloc;
        alloc = ArrayUtils.idealIntArraySize(0);
        mSpans = new Object[alloc];
        mSpanStarts = new int[alloc];
        mSpanEnds = new int[alloc];
        mSpanFlags = new int[alloc];
        {
            Spanned sp;
            sp = (Spanned) text;
            Object[] spans;
            spans = sp.getSpans(start, end, Object.class);
            {
                int i;
                i = 0;
                {
                    int st;
                    st = sp.getSpanStart(spans[i]) - start;
                    int en;
                    en = sp.getSpanEnd(spans[i]) - start;
                    int fl;
                    fl = sp.getSpanFlags(spans[i]);
                    st = 0;
                    st = end - start;
                    en = 0;
                    en = end - start;
                    setSpan(spans[i], st, en, fl);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.205 -0400", hash_original_method = "6E4B705F56C3BE22100FD14C8AB5330A", hash_generated_method = "83DC34C0333E4CBFD30BDA50C8F21BCD")
    public static SpannableStringBuilder valueOf(CharSequence source) {
        if (source instanceof SpannableStringBuilder) {
            return (SpannableStringBuilder) source;
        } else {
            return new SpannableStringBuilder(source);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.205 -0400", hash_original_method = "8A39C40193810117501439EDABBFE6E5", hash_generated_method = "9CF8D18673CA6DEECDA24964F56FD2F3")
    @DSModeled(DSC.SAFE)
    public char charAt(int where) {
        dsTaint.addTaint(where);
        int len;
        len = length();
        {
            throw new IndexOutOfBoundsException("charAt: " + where + " < 0");
        } //End block
        {
            throw new IndexOutOfBoundsException("charAt: " + where + " >= length " + len);
        } //End block
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //int len = length();
        //if (where < 0) {
            //throw new IndexOutOfBoundsException("charAt: " + where + " < 0");
        //} else if (where >= len) {
            //throw new IndexOutOfBoundsException("charAt: " + where + " >= length " + len);
        //}
        //if (where >= mGapStart)
            //return mText[where + mGapLength];
        //else
            //return mText[where];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.205 -0400", hash_original_method = "9A6AB9CE1EAE128DD9B2405D2B37CA46", hash_generated_method = "74E160BD37CF8E0DB5E502247AF46839")
    @DSModeled(DSC.SAFE)
    public int length() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mText.length - mGapLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.205 -0400", hash_original_method = "976FC6C6553888C069C4B298C5B14B80", hash_generated_method = "1171503D11D73280AF1AF022FCFEC9DD")
    @DSModeled(DSC.SAFE)
    private void resizeFor(int size) {
        dsTaint.addTaint(size);
        int newlen;
        newlen = ArrayUtils.idealCharArraySize(size + 1);
        char[] newtext;
        newtext = new char[newlen];
        int after;
        after = mText.length - (mGapStart + mGapLength);
        System.arraycopy(mText, 0, newtext, 0, mGapStart);
        System.arraycopy(mText, mText.length - after,
                         newtext, newlen - after, after);
        {
            int i;
            i = 0;
            {
                mSpanStarts[i] += newlen - mText.length;
                mSpanEnds[i] += newlen - mText.length;
            } //End block
        } //End collapsed parenthetic
        int oldlen;
        oldlen = mText.length;
        mText = newtext;
        mGapLength += mText.length - oldlen;
        new Exception("mGapLength < 1").printStackTrace();
        // ---------- Original Method ----------
        //int newlen = ArrayUtils.idealCharArraySize(size + 1);
        //char[] newtext = new char[newlen];
        //int after = mText.length - (mGapStart + mGapLength);
        //System.arraycopy(mText, 0, newtext, 0, mGapStart);
        //System.arraycopy(mText, mText.length - after,
                         //newtext, newlen - after, after);
        //for (int i = 0; i < mSpanCount; i++) {
            //if (mSpanStarts[i] > mGapStart)
                //mSpanStarts[i] += newlen - mText.length;
            //if (mSpanEnds[i] > mGapStart)
                //mSpanEnds[i] += newlen - mText.length;
        //}
        //int oldlen = mText.length;
        //mText = newtext;
        //mGapLength += mText.length - oldlen;
        //if (mGapLength < 1)
            //new Exception("mGapLength < 1").printStackTrace();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.206 -0400", hash_original_method = "D9447594759C2324F4C84ED525D8EBA8", hash_generated_method = "DBCBDF14C124CA226B61B5696AE6A345")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void moveGapTo(int where) {
        dsTaint.addTaint(where);
        boolean atend;
        atend = (where == length());
        {
            int overlap;
            overlap = mGapStart - where;
            System.arraycopy(mText, where,
                             mText, mGapStart + mGapLength - overlap, overlap);
        } //End block
        {
            int overlap;
            overlap = where - mGapStart;
            System.arraycopy(mText, where + mGapLength - overlap,
                             mText, mGapStart, overlap);
        } //End block
        {
            int i;
            i = 0;
            {
                int start;
                start = mSpanStarts[i];
                int end;
                end = mSpanEnds[i];
                start -= mGapLength;
                start += mGapLength;
                {
                    int flag;
                    flag = (mSpanFlags[i] & START_MASK) >> START_SHIFT;
                    start += mGapLength;
                } //End block
                end -= mGapLength;
                end += mGapLength;
                {
                    int flag;
                    flag = (mSpanFlags[i] & END_MASK);
                    end += mGapLength;
                } //End block
                mSpanStarts[i] = start;
                mSpanEnds[i] = end;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.206 -0400", hash_original_method = "05B349B857A56AE010B814959800B44E", hash_generated_method = "C1F72AC8DFB438342E416BC4A4D7D540")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannableStringBuilder insert(int where, CharSequence tb, int start, int end) {
        dsTaint.addTaint(tb);
        dsTaint.addTaint(start);
        dsTaint.addTaint(where);
        dsTaint.addTaint(end);
        SpannableStringBuilder var009395547D6C1638B95705C5CECA6DF2_1841519117 = (replace(where, where, tb, start, end));
        return (SpannableStringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return replace(where, where, tb, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.206 -0400", hash_original_method = "8FF3D73D08A9AFA2B9C652CF8F4F615D", hash_generated_method = "CB35B23977528D71DDB787769175E5D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannableStringBuilder insert(int where, CharSequence tb) {
        dsTaint.addTaint(tb);
        dsTaint.addTaint(where);
        SpannableStringBuilder varEE9D727FF40DB80B84405C516F93571A_934028329 = (replace(where, where, tb, 0, tb.length()));
        return (SpannableStringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return replace(where, where, tb, 0, tb.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.206 -0400", hash_original_method = "CCAFF8AC74D86E62008C289B374BD199", hash_generated_method = "D212994E03ED54A9F2FC4357D87F5A4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannableStringBuilder delete(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        SpannableStringBuilder ret;
        ret = replace(start, end, "", 0, 0);
        {
            boolean varCFB5555CC98A8456696144D750C956C3_502824310 = (mGapLength > 2 * length());
            resizeFor(length());
        } //End collapsed parenthetic
        return (SpannableStringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SpannableStringBuilder ret = replace(start, end, "", 0, 0);
        //if (mGapLength > 2 * length())
            //resizeFor(length());
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.206 -0400", hash_original_method = "D18AC1E4EB05736F525932BC47697F9D", hash_generated_method = "3CB78062B92F21263E02690EB0D08E29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        replace(0, length(), "", 0, 0);
        // ---------- Original Method ----------
        //replace(0, length(), "", 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.206 -0400", hash_original_method = "DCA8D2BE237B08ED7EF41B903E9CA024", hash_generated_method = "6EA5A1151F35FCF48E5A8719BCDC8785")
    @DSModeled(DSC.SAFE)
    public void clearSpans() {
        {
            int i;
            i = mSpanCount - 1;
            {
                Object what;
                what = mSpans[i];
                int ostart;
                ostart = mSpanStarts[i];
                int oend;
                oend = mSpanEnds[i];
                ostart -= mGapLength;
                oend -= mGapLength;
                mSpanCount = i;
                mSpans[i] = null;
                sendSpanRemoved(what, ostart, oend);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = mSpanCount - 1; i >= 0; i--) {
            //Object what = mSpans[i];
            //int ostart = mSpanStarts[i];
            //int oend = mSpanEnds[i];
            //if (ostart > mGapStart)
                //ostart -= mGapLength;
            //if (oend > mGapStart)
                //oend -= mGapLength;
            //mSpanCount = i;
            //mSpans[i] = null;
            //sendSpanRemoved(what, ostart, oend);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.206 -0400", hash_original_method = "A87DD944FE6567F6923432E1C1B56712", hash_generated_method = "0E941AC7E2A677B92A0080717EB143B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannableStringBuilder append(CharSequence text) {
        dsTaint.addTaint(text);
        int length;
        length = length();
        SpannableStringBuilder var04B8DBE0CA954EAB7A89D50D6E8DA4C3_1277808787 = (replace(length, length, text, 0, text.length()));
        return (SpannableStringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int length = length();
        //return replace(length, length, text, 0, text.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.206 -0400", hash_original_method = "2E8C7D2887FD28E969B785C3CCFE69E2", hash_generated_method = "90EFFF6863AA85758676DB98DCAEF707")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannableStringBuilder append(CharSequence text, int start, int end) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        int length;
        length = length();
        SpannableStringBuilder varDC622E8DB05801BE912EAAF9CFC15F15_637090176 = (replace(length, length, text, start, end));
        return (SpannableStringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int length = length();
        //return replace(length, length, text, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.206 -0400", hash_original_method = "CAF0941E3E4124F46031A9B624CEE660", hash_generated_method = "240007D0718DB1BE27DA84CDC8D30FFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannableStringBuilder append(char text) {
        dsTaint.addTaint(text);
        SpannableStringBuilder var267B6D0D1FA3B3006B8CA50F2D197E6C_99183729 = (append(String.valueOf(text)));
        return (SpannableStringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return append(String.valueOf(text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.207 -0400", hash_original_method = "3C715BB6E3D7DD6490206A10C6A892D0", hash_generated_method = "C57FCB89F9E3529E78E799AAFE257C54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int change(int start, int end, CharSequence tb, int tbstart, int tbend) {
        dsTaint.addTaint(tb);
        dsTaint.addTaint(start);
        dsTaint.addTaint(tbend);
        dsTaint.addTaint(tbstart);
        dsTaint.addTaint(end);
        int var3016398390FA3B4EF0297C32DD8390A3_667754444 = (change(true, start, end, tb, tbstart, tbend));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return change(true, start, end, tb, tbstart, tbend);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.207 -0400", hash_original_method = "84DCE273834998C04B3160C57E76984B", hash_generated_method = "0DAFE262028C7A8A69E0F156B25C234C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int change(boolean notify, int start, int end,
                       CharSequence tb, int tbstart, int tbend) {
        dsTaint.addTaint(tb);
        dsTaint.addTaint(start);
        dsTaint.addTaint(tbend);
        dsTaint.addTaint(notify);
        dsTaint.addTaint(tbstart);
        dsTaint.addTaint(end);
        checkRange("replace", start, end);
        int ret;
        ret = tbend - tbstart;
        TextWatcher[] recipients;
        recipients = null;
        {
            recipients = sendTextWillChange(start, end - start, tbend - tbstart);
        } //End block
        {
            int i;
            i = mSpanCount - 1;
            {
                {
                    int st;
                    st = mSpanStarts[i];
                    st -= mGapLength;
                    int en;
                    en = mSpanEnds[i];
                    en -= mGapLength;
                    int ost;
                    ost = st;
                    int oen;
                    oen = en;
                    int clen;
                    clen = length();
                    {
                        {
                            st = end;
                            {
                                boolean varBFE60C587C9C6F6C8D150DFF94D33D1A_1229390220 = (st > end && charAt(st - 1) == '\n');
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            en = end;
                            {
                                boolean varB4FE50EC2B1C228FAAAD3CF5EDD3BF5A_1629992900 = (en > end && charAt(en - 1) == '\n');
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                    setSpan(mSpans[i], st, en, mSpanFlags[i]);
                } //End block
            } //End block
        } //End collapsed parenthetic
        moveGapTo(end);
        final int nbNewChars;
        nbNewChars = (tbend - tbstart) - (end - start);
        {
            resizeFor(mText.length + nbNewChars - mGapLength);
        } //End block
        mGapStart += nbNewChars;
        mGapLength -= nbNewChars;
        new Exception("mGapLength < 1").printStackTrace();
        TextUtils.getChars(tb, tbstart, tbend, mText, start);
        {
            Spanned sp;
            sp = (Spanned) tb;
            Object[] spans;
            spans = sp.getSpans(tbstart, tbend, Object.class);
            {
                int i;
                i = 0;
                {
                    int st;
                    st = sp.getSpanStart(spans[i]);
                    int en;
                    en = sp.getSpanEnd(spans[i]);
                    st = tbstart;
                    en = tbend;
                    {
                        boolean varE962BA69F8DD7114748830F1B8735548_1856613210 = (getSpanStart(spans[i]) < 0);
                        {
                            setSpan(false, spans[i],
                            st - tbstart + start,
                            en - tbstart + start,
                            sp.getSpanFlags(spans[i]));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                sendTextChange(recipients, start, end - start, tbend - tbstart);
                sendTextHasChanged(recipients);
            } //End block
        } //End block
        boolean atend;
        atend = (mGapStart + mGapLength == mText.length);
        {
            int i;
            i = mSpanCount - 1;
            {
                {
                    int flag;
                    flag = (mSpanFlags[i] & START_MASK) >> START_SHIFT;
                    mSpanStarts[i] = mGapStart + mGapLength;
                    mSpanStarts[i] = start;
                } //End block
                {
                    int flag;
                    flag = (mSpanFlags[i] & END_MASK);
                    mSpanEnds[i] = mGapStart + mGapLength;
                    mSpanEnds[i] = start;
                } //End block
                {
                    removeSpan(i);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            sendTextChange(recipients, start, end - start, tbend - tbstart);
            sendTextHasChanged(recipients);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.208 -0400", hash_original_method = "5F40E5580DD9B6C8070DDBE86036D0A0", hash_generated_method = "A403F087759EF5904D1F45B06537A649")
    @DSModeled(DSC.SAFE)
    private void removeSpan(int i) {
        dsTaint.addTaint(i);
        Object object;
        object = mSpans[i];
        int start;
        start = mSpanStarts[i];
        int end;
        end = mSpanEnds[i];
        start -= mGapLength;
        end -= mGapLength;
        int count;
        count = mSpanCount - (i + 1);
        System.arraycopy(mSpans, i + 1, mSpans, i, count);
        System.arraycopy(mSpanStarts, i + 1, mSpanStarts, i, count);
        System.arraycopy(mSpanEnds, i + 1, mSpanEnds, i, count);
        System.arraycopy(mSpanFlags, i + 1, mSpanFlags, i, count);
        mSpanCount--;
        mSpans[mSpanCount] = null;
        sendSpanRemoved(object, start, end);
        // ---------- Original Method ----------
        //Object object = mSpans[i];
        //int start = mSpanStarts[i];
        //int end = mSpanEnds[i];
        //if (start > mGapStart) start -= mGapLength;
        //if (end > mGapStart) end -= mGapLength;
        //int count = mSpanCount - (i + 1);
        //System.arraycopy(mSpans, i + 1, mSpans, i, count);
        //System.arraycopy(mSpanStarts, i + 1, mSpanStarts, i, count);
        //System.arraycopy(mSpanEnds, i + 1, mSpanEnds, i, count);
        //System.arraycopy(mSpanFlags, i + 1, mSpanFlags, i, count);
        //mSpanCount--;
        //mSpans[mSpanCount] = null;
        //sendSpanRemoved(object, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.208 -0400", hash_original_method = "F007284EC0E266D0B466C6FB60440DED", hash_generated_method = "16C7629FACEC27D8E52FDB6882C2B9DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannableStringBuilder replace(int start, int end, CharSequence tb) {
        dsTaint.addTaint(tb);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        SpannableStringBuilder var90C2FBB8F16580AA1A82BEAA3A1BFF23_673652105 = (replace(start, end, tb, 0, tb.length()));
        return (SpannableStringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return replace(start, end, tb, 0, tb.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.208 -0400", hash_original_method = "653147CE10EC22F15BE8C423BD65FA32", hash_generated_method = "F5D9FDFAC62D5966B0B77B570D60757E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannableStringBuilder replace(final int start, final int end,
                        CharSequence tb, int tbstart, int tbend) {
        dsTaint.addTaint(tb);
        dsTaint.addTaint(start);
        dsTaint.addTaint(tbend);
        dsTaint.addTaint(tbstart);
        dsTaint.addTaint(end);
        int filtercount;
        filtercount = mFilters.length;
        {
            int i;
            i = 0;
            {
                CharSequence repl;
                repl = mFilters[i].filter(tb, tbstart, tbend,
                                                   this, start, end);
                {
                    tb = repl;
                    tbstart = 0;
                    tbend = repl.length();
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            change(start, end, tb, tbstart, tbend);
        } //End block
        {
            int selstart;
            selstart = Selection.getSelectionStart(this);
            int selend;
            selend = Selection.getSelectionEnd(this);
            checkRange("replace", start, end);
            moveGapTo(end);
            TextWatcher[] recipients;
            int origlen;
            origlen = end - start;
            recipients = sendTextWillChange(start, origlen, tbend - tbstart);
            resizeFor(length() + 1);
            {
                int i;
                i = mSpanCount - 1;
                {
                    mSpanStarts[i]++;
                    mSpanEnds[i]++;
                } //End block
            } //End collapsed parenthetic
            mText[mGapStart] = ' ';
            mGapStart++;
            mGapLength--;
            {
                new Exception("mGapLength < 1").printStackTrace();
            } //End block
            int inserted;
            inserted = change(false, start + 1, start + 1, tb, tbstart, tbend);
            change(false, start, start + 1, "", 0, 0);
            change(false, start + inserted, start + inserted + origlen, "", 0, 0);
            {
                long off;
                off = selstart - start;
                off = off * inserted / (end - start);
                selstart = (int) off + start;
                setSpan(false, Selection.SELECTION_START, selstart, selstart,
                        Spanned.SPAN_POINT_POINT);
            } //End block
            {
                long off;
                off = selend - start;
                off = off * inserted / (end - start);
                selend = (int) off + start;
                setSpan(false, Selection.SELECTION_END, selend, selend, Spanned.SPAN_POINT_POINT);
            } //End block
            sendTextChange(recipients, start, origlen, inserted);
            sendTextHasChanged(recipients);
        } //End block
        return (SpannableStringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.209 -0400", hash_original_method = "69D700DE18AC29DD7D1DA7BDFB6B76AF", hash_generated_method = "F8AB57FBDC6BBF0BB325618E89207F7D")
    @DSModeled(DSC.SAFE)
    public void setSpan(Object what, int start, int end, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        setSpan(true, what, start, end, flags);
        // ---------- Original Method ----------
        //setSpan(true, what, start, end, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.209 -0400", hash_original_method = "2D459893E2DC729F5693ABCD511FCC18", hash_generated_method = "3450F9D8ABA65EC0B6AF3E04EFE6D281")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setSpan(boolean send, Object what, int start, int end, int flags) {
        dsTaint.addTaint(send);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        int nstart;
        nstart = start;
        int nend;
        nend = end;
        checkRange("setSpan", start, end);
        {
            {
                boolean var50D67EA6491FC514B6D92D2E40689E61_310500913 = (start != 0 && start != length());
                {
                    char c;
                    c = charAt(start - 1);
                    throw new RuntimeException("PARAGRAPH span must start at paragraph boundary");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var5B6CF9C5E41E159F793AF4E9C33451FF_1968411913 = (end != 0 && end != length());
                {
                    char c;
                    c = charAt(end - 1);
                    throw new RuntimeException("PARAGRAPH span must end at paragraph boundary");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            start += mGapLength;
        } //End block
        {
            int flag;
            flag = (flags & START_MASK) >> START_SHIFT;
            {
                boolean var178F36AF86CF523AC45E3DA928EB6603_2107957517 = (flag == POINT || (flag == PARAGRAPH && start == length()));
                start += mGapLength;
            } //End collapsed parenthetic
        } //End block
        {
            end += mGapLength;
        } //End block
        {
            int flag;
            flag = (flags & END_MASK);
            {
                boolean var80BFA6A9886ED960BFDD8DFECE7B441C_1724743929 = (flag == POINT || (flag == PARAGRAPH && end == length()));
                end += mGapLength;
            } //End collapsed parenthetic
        } //End block
        int count;
        count = mSpanCount;
        Object[] spans;
        spans = mSpans;
        {
            int i;
            i = 0;
            {
                {
                    int ostart;
                    ostart = mSpanStarts[i];
                    int oend;
                    oend = mSpanEnds[i];
                    ostart -= mGapLength;
                    oend -= mGapLength;
                    mSpanStarts[i] = start;
                    mSpanEnds[i] = end;
                    mSpanFlags[i] = flags;
                    sendSpanChanged(what, ostart, oend, nstart, nend);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            int newsize;
            newsize = ArrayUtils.idealIntArraySize(mSpanCount + 1);
            Object[] newspans;
            newspans = new Object[newsize];
            int[] newspanstarts;
            newspanstarts = new int[newsize];
            int[] newspanends;
            newspanends = new int[newsize];
            int[] newspanflags;
            newspanflags = new int[newsize];
            System.arraycopy(mSpans, 0, newspans, 0, mSpanCount);
            System.arraycopy(mSpanStarts, 0, newspanstarts, 0, mSpanCount);
            System.arraycopy(mSpanEnds, 0, newspanends, 0, mSpanCount);
            System.arraycopy(mSpanFlags, 0, newspanflags, 0, mSpanCount);
            mSpans = newspans;
            mSpanStarts = newspanstarts;
            mSpanEnds = newspanends;
            mSpanFlags = newspanflags;
        } //End block
        mSpans[mSpanCount] = what;
        mSpanStarts[mSpanCount] = start;
        mSpanEnds[mSpanCount] = end;
        mSpanFlags[mSpanCount] = flags;
        mSpanCount++;
        sendSpanAdded(what, nstart, nend);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.209 -0400", hash_original_method = "F7FA44646A47341A9BCB6EBFF8147DB3", hash_generated_method = "065E096EE8A1B78B741B791385E74AC3")
    @DSModeled(DSC.SAFE)
    public void removeSpan(Object what) {
        dsTaint.addTaint(what.dsTaint);
        {
            int i;
            i = mSpanCount - 1;
            {
                {
                    removeSpan(i);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = mSpanCount - 1; i >= 0; i--) {
            //if (mSpans[i] == what) {
                //removeSpan(i);
                //return;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.210 -0400", hash_original_method = "DD4C166AC7D5C475EE46AC767DBD33EB", hash_generated_method = "FD0E9B0A36858881CEF837C2F860ED6E")
    @DSModeled(DSC.SAFE)
    public int getSpanStart(Object what) {
        dsTaint.addTaint(what.dsTaint);
        int count;
        count = mSpanCount;
        Object[] spans;
        spans = mSpans;
        {
            int i;
            i = count - 1;
            {
                {
                    int where;
                    where = mSpanStarts[i];
                    where -= mGapLength;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int count = mSpanCount;
        //Object[] spans = mSpans;
        //for (int i = count - 1; i >= 0; i--) {
            //if (spans[i] == what) {
                //int where = mSpanStarts[i];
                //if (where > mGapStart)
                    //where -= mGapLength;
                //return where;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.210 -0400", hash_original_method = "1CAC5A6045B202B1FC928510B17AEEDD", hash_generated_method = "2A2AF47028231A8506A1FD752A9ACF35")
    @DSModeled(DSC.SAFE)
    public int getSpanEnd(Object what) {
        dsTaint.addTaint(what.dsTaint);
        int count;
        count = mSpanCount;
        Object[] spans;
        spans = mSpans;
        {
            int i;
            i = count - 1;
            {
                {
                    int where;
                    where = mSpanEnds[i];
                    where -= mGapLength;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int count = mSpanCount;
        //Object[] spans = mSpans;
        //for (int i = count - 1; i >= 0; i--) {
            //if (spans[i] == what) {
                //int where = mSpanEnds[i];
                //if (where > mGapStart)
                    //where -= mGapLength;
                //return where;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.210 -0400", hash_original_method = "DA0589F2510DDCCEED97B90C9189C1B9", hash_generated_method = "A5F3DEE4168CA3488319B398A3A0E56F")
    @DSModeled(DSC.SAFE)
    public int getSpanFlags(Object what) {
        dsTaint.addTaint(what.dsTaint);
        int count;
        count = mSpanCount;
        Object[] spans;
        spans = mSpans;
        {
            int i;
            i = count - 1;
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int count = mSpanCount;
        //Object[] spans = mSpans;
        //for (int i = count - 1; i >= 0; i--) {
            //if (spans[i] == what) {
                //return mSpanFlags[i];
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.210 -0400", hash_original_method = "5CF7F75C8FAF8266A003E04C7C47A211", hash_generated_method = "A6044C704099FD176115512822CE7A0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> kind) {
        dsTaint.addTaint(queryStart);
        dsTaint.addTaint(queryEnd);
        dsTaint.addTaint(kind.dsTaint);
        T[] varD9F6CC970229E11E8E4AF1AF88A19F5B_439453124 = (ArrayUtils.emptyArray(kind));
        int spanCount;
        spanCount = mSpanCount;
        Object[] spans;
        spans = mSpans;
        int[] starts;
        starts = mSpanStarts;
        int[] ends;
        ends = mSpanEnds;
        int[] flags;
        flags = mSpanFlags;
        int gapstart;
        gapstart = mGapStart;
        int gaplen;
        gaplen = mGapLength;
        int count;
        count = 0;
        T[] ret;
        ret = null;
        T ret1;
        ret1 = null;
        {
            int i;
            i = 0;
            {
                int spanStart;
                spanStart = starts[i];
                {
                    spanStart -= gaplen;
                } //End block
                int spanEnd;
                spanEnd = ends[i];
                {
                    spanEnd -= gaplen;
                } //End block
                {
                    boolean var4C3968C27883F1B4B4C15526A74C7F41_567898304 = (!kind.isInstance(spans[i]));
                } //End collapsed parenthetic
                {
                    ret1 = (T) spans[i];
                    count++;
                } //End block
                {
                    {
                        ret = (T[]) Array.newInstance(kind, spanCount - i + 1);
                        ret[0] = ret1;
                    } //End block
                    int prio;
                    prio = flags[i] & SPAN_PRIORITY;
                    {
                        int j;
                        {
                            j = 0;
                            {
                                int p;
                                p = getSpanFlags(ret[j]) & SPAN_PRIORITY;
                            } //End block
                        } //End collapsed parenthetic
                        System.arraycopy(ret, j, ret, j + 1, count - j);
                        ret[j] = (T) spans[i];
                        count++;
                    } //End block
                    {
                        ret[count++] = (T) spans[i];
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            T[] var34D8643A779F162A1066EA114575AD7D_1602359693 = (ArrayUtils.emptyArray(kind));
        } //End block
        {
            ret = (T[]) Array.newInstance(kind, 1);
            ret[0] = ret1;
        } //End block
        T[] nret;
        nret = (T[]) Array.newInstance(kind, count);
        System.arraycopy(ret, 0, nret, 0, count);
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.211 -0400", hash_original_method = "AC3B57A902A92307655B10B6A320F4FA", hash_generated_method = "550ACD38B055592274B203D80ABA7F99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int nextSpanTransition(int start, int limit, Class kind) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(start);
        dsTaint.addTaint(kind.dsTaint);
        int count;
        count = mSpanCount;
        Object[] spans;
        spans = mSpans;
        int[] starts;
        starts = mSpanStarts;
        int[] ends;
        ends = mSpanEnds;
        int gapstart;
        gapstart = mGapStart;
        int gaplen;
        gaplen = mGapLength;
        {
            kind = Object.class;
        } //End block
        {
            int i;
            i = 0;
            {
                int st;
                st = starts[i];
                int en;
                en = ends[i];
                st -= gaplen;
                en -= gaplen;
                {
                    boolean varF6D66FD5D17035475727187422C2B841_438851234 = (st > start && st < limit && kind.isInstance(spans[i]));
                    limit = st;
                } //End collapsed parenthetic
                {
                    boolean varDD4114CCD8FA698F5DA31E38C7560428_437901606 = (en > start && en < limit && kind.isInstance(spans[i]));
                    limit = en;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int count = mSpanCount;
        //Object[] spans = mSpans;
        //int[] starts = mSpanStarts;
        //int[] ends = mSpanEnds;
        //int gapstart = mGapStart;
        //int gaplen = mGapLength;
        //if (kind == null) {
            //kind = Object.class;
        //}
        //for (int i = 0; i < count; i++) {
            //int st = starts[i];
            //int en = ends[i];
            //if (st > gapstart)
                //st -= gaplen;
            //if (en > gapstart)
                //en -= gaplen;
            //if (st > start && st < limit && kind.isInstance(spans[i]))
                //limit = st;
            //if (en > start && en < limit && kind.isInstance(spans[i]))
                //limit = en;
        //}
        //return limit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.211 -0400", hash_original_method = "31E22DABAC481CACAF1D07C50FD19E47", hash_generated_method = "030C700ADBD3305ED772C1DD8F4FB253")
    @DSModeled(DSC.SAFE)
    public CharSequence subSequence(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return new SpannableStringBuilder(this, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.211 -0400", hash_original_method = "063174DC666DF3AA6ABCE47B5208FD87", hash_generated_method = "1FB72F6B08F8713A7DB9F19CF8288DE8")
    @DSModeled(DSC.SAFE)
    public void getChars(int start, int end, char[] dest, int destoff) {
        dsTaint.addTaint(dest);
        dsTaint.addTaint(start);
        dsTaint.addTaint(destoff);
        dsTaint.addTaint(end);
        checkRange("getChars", start, end);
        {
            System.arraycopy(mText, start, dest, destoff, end - start);
        } //End block
        {
            System.arraycopy(mText, start + mGapLength,
                             dest, destoff, end - start);
        } //End block
        {
            System.arraycopy(mText, start, dest, destoff, mGapStart - start);
            System.arraycopy(mText, mGapStart + mGapLength,
                             dest, destoff + (mGapStart - start),
                             end - mGapStart);
        } //End block
        // ---------- Original Method ----------
        //checkRange("getChars", start, end);
        //if (end <= mGapStart) {
            //System.arraycopy(mText, start, dest, destoff, end - start);
        //} else if (start >= mGapStart) {
            //System.arraycopy(mText, start + mGapLength,
                             //dest, destoff, end - start);
        //} else {
            //System.arraycopy(mText, start, dest, destoff, mGapStart - start);
            //System.arraycopy(mText, mGapStart + mGapLength,
                             //dest, destoff + (mGapStart - start),
                             //end - mGapStart);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.211 -0400", hash_original_method = "4F74498D478E367DDE05120AE1CE9765", hash_generated_method = "AB269DF4FD52CD75DC48E3D3865A1E02")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        int len;
        len = length();
        char[] buf;
        buf = new char[len];
        getChars(0, len, buf, 0);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int len = length();
        //char[] buf = new char[len];
        //getChars(0, len, buf, 0);
        //return new String(buf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.211 -0400", hash_original_method = "5E2755BFE298194FA4E39DBC872CF6D4", hash_generated_method = "161AB805A7D1D96D8DEACFEA5F27585C")
    @DSModeled(DSC.SAFE)
    public String substring(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        char[] buf;
        buf = new char[end - start];
        getChars(start, end, buf, 0);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //char[] buf = new char[end - start];
        //getChars(start, end, buf, 0);
        //return new String(buf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.211 -0400", hash_original_method = "9EEE5F03C950DBDA8CD631C0E0A3B78A", hash_generated_method = "A43B0D9767B7C4F7222C146F88D2DD4F")
    @DSModeled(DSC.SAFE)
    private TextWatcher[] sendTextWillChange(int start, int before, int after) {
        dsTaint.addTaint(after);
        dsTaint.addTaint(start);
        dsTaint.addTaint(before);
        TextWatcher[] recip;
        recip = getSpans(start, start + before, TextWatcher.class);
        int n;
        n = recip.length;
        {
            int i;
            i = 0;
            {
                recip[i].beforeTextChanged(this, start, before, after);
            } //End block
        } //End collapsed parenthetic
        return (TextWatcher[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //TextWatcher[] recip = getSpans(start, start + before, TextWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].beforeTextChanged(this, start, before, after);
        //}
        //return recip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.212 -0400", hash_original_method = "B0F46C63F0D82B2972BAF2786F5024B6", hash_generated_method = "36DF2D018CD876267D68E795FCD415C2")
    @DSModeled(DSC.SAFE)
    private void sendTextChange(TextWatcher[] recip, int start, int before, int after) {
        dsTaint.addTaint(after);
        dsTaint.addTaint(start);
        dsTaint.addTaint(before);
        dsTaint.addTaint(recip.dsTaint);
        int n;
        n = recip.length;
        {
            int i;
            i = 0;
            {
                recip[i].onTextChanged(this, start, before, after);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onTextChanged(this, start, before, after);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.212 -0400", hash_original_method = "B7AEF4E180417D3A92FE965B8D29719A", hash_generated_method = "18AAFD3BBC5AA41DBF49F9903AC014F0")
    @DSModeled(DSC.SAFE)
    private void sendTextHasChanged(TextWatcher[] recip) {
        dsTaint.addTaint(recip.dsTaint);
        int n;
        n = recip.length;
        {
            int i;
            i = 0;
            {
                recip[i].afterTextChanged(this);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].afterTextChanged(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.212 -0400", hash_original_method = "39DD82D37A3679E95040612AC2A4CD5D", hash_generated_method = "91E76CF9BBCBCAA518821429479569C3")
    @DSModeled(DSC.SAFE)
    private void sendSpanAdded(Object what, int start, int end) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        SpanWatcher[] recip;
        recip = getSpans(start, end, SpanWatcher.class);
        int n;
        n = recip.length;
        {
            int i;
            i = 0;
            {
                recip[i].onSpanAdded(this, what, start, end);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanAdded(this, what, start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.212 -0400", hash_original_method = "8451F34A8F8537B6F36684962116E358", hash_generated_method = "F364463C1DE9B7857FC51E79F490B4BC")
    @DSModeled(DSC.SAFE)
    private void sendSpanRemoved(Object what, int start, int end) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        SpanWatcher[] recip;
        recip = getSpans(start, end, SpanWatcher.class);
        int n;
        n = recip.length;
        {
            int i;
            i = 0;
            {
                recip[i].onSpanRemoved(this, what, start, end);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanRemoved(this, what, start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.212 -0400", hash_original_method = "89C4871AB16E570ACF45A07B8EFEFB25", hash_generated_method = "F81C3A0682347EC67E4B7631785C92B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendSpanChanged(Object what, int s, int e, int st, int en) {
        dsTaint.addTaint(e);
        dsTaint.addTaint(s);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(en);
        dsTaint.addTaint(st);
        SpanWatcher[] recip;
        recip = getSpans(Math.min(s, st), Math.max(e, en), SpanWatcher.class);
        int n;
        n = recip.length;
        {
            int i;
            i = 0;
            {
                recip[i].onSpanChanged(this, what, s, e, st, en);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(Math.min(s, st), Math.max(e, en), SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanChanged(this, what, s, e, st, en);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.212 -0400", hash_original_method = "6B7A1DDF85ADC183B3426DC1B4007521", hash_generated_method = "47901FCF4C66D2137EBF33493DFF4299")
    private static String region(int start, int end) {
        return "(" + start + " ... " + end + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.212 -0400", hash_original_method = "70C480F1BBBBF461E174788F8B29326C", hash_generated_method = "0A8B7BFA47C123FA1496F5B872A225D0")
    @DSModeled(DSC.SAFE)
    private void checkRange(final String operation, int start, int end) {
        dsTaint.addTaint(operation);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " has end before start");
        } //End block
        int len;
        len = length();
        {
            throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " ends beyond length " + len);
        } //End block
        {
            throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " starts before 0");
        } //End block
        // ---------- Original Method ----------
        //if (end < start) {
            //throw new IndexOutOfBoundsException(operation + " " +
                                                //region(start, end) +
                                                //" has end before start");
        //}
        //int len = length();
        //if (start > len || end > len) {
            //throw new IndexOutOfBoundsException(operation + " " +
                                                //region(start, end) +
                                                //" ends beyond length " + len);
        //}
        //if (start < 0 || end < 0) {
            //throw new IndexOutOfBoundsException(operation + " " +
                                                //region(start, end) +
                                                //" starts before 0");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.212 -0400", hash_original_method = "78639A54CC0D16962D9B6A20CA716009", hash_generated_method = "06AB703DCC433E6C8EAE2D8420D2976A")
    @DSModeled(DSC.SAFE)
    public void drawText(Canvas c, int start, int end,
                         float x, float y, Paint p) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(end);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        checkRange("drawText", start, end);
        {
            c.drawText(mText, start, end - start, x, y, p);
        } //End block
        {
            c.drawText(mText, start + mGapLength, end - start, x, y, p);
        } //End block
        {
            char[] buf;
            buf = TextUtils.obtain(end - start);
            getChars(start, end, buf, 0);
            c.drawText(buf, 0, end - start, x, y, p);
            TextUtils.recycle(buf);
        } //End block
        // ---------- Original Method ----------
        //checkRange("drawText", start, end);
        //if (end <= mGapStart) {
            //c.drawText(mText, start, end - start, x, y, p);
        //} else if (start >= mGapStart) {
            //c.drawText(mText, start + mGapLength, end - start, x, y, p);
        //} else {
            //char[] buf = TextUtils.obtain(end - start);
            //getChars(start, end, buf, 0);
            //c.drawText(buf, 0, end - start, x, y, p);
            //TextUtils.recycle(buf);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.213 -0400", hash_original_method = "623CEE9BFDFC43532CC6E8FD83D183BD", hash_generated_method = "E834551E03CA3181DC311E5F620F69D8")
    @DSModeled(DSC.SAFE)
    public void drawTextRun(Canvas c, int start, int end,
            int contextStart, int contextEnd,
            float x, float y, int flags, Paint p) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(end);
        dsTaint.addTaint(y);
        dsTaint.addTaint(contextEnd);
        dsTaint.addTaint(x);
        checkRange("drawTextRun", start, end);
        int contextLen;
        contextLen = contextEnd - contextStart;
        int len;
        len = end - start;
        {
            c.drawTextRun(mText, start, len, contextStart, contextLen, x, y, flags, p);
        } //End block
        {
            c.drawTextRun(mText, start + mGapLength, len, contextStart + mGapLength,
                    contextLen, x, y, flags, p);
        } //End block
        {
            char[] buf;
            buf = TextUtils.obtain(contextLen);
            getChars(contextStart, contextEnd, buf, 0);
            c.drawTextRun(buf, start - contextStart, len, 0, contextLen, x, y, flags, p);
            TextUtils.recycle(buf);
        } //End block
        // ---------- Original Method ----------
        //checkRange("drawTextRun", start, end);
        //int contextLen = contextEnd - contextStart;
        //int len = end - start;
        //if (contextEnd <= mGapStart) {
            //c.drawTextRun(mText, start, len, contextStart, contextLen, x, y, flags, p);
        //} else if (contextStart >= mGapStart) {
            //c.drawTextRun(mText, start + mGapLength, len, contextStart + mGapLength,
                    //contextLen, x, y, flags, p);
        //} else {
            //char[] buf = TextUtils.obtain(contextLen);
            //getChars(contextStart, contextEnd, buf, 0);
            //c.drawTextRun(buf, start - contextStart, len, 0, contextLen, x, y, flags, p);
            //TextUtils.recycle(buf);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.213 -0400", hash_original_method = "5FD711D7C19B78DA72F1C64F29FD53D3", hash_generated_method = "F3B683BFB710228E35C3D2012ED1A7EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float measureText(int start, int end, Paint p) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(end);
        checkRange("measureText", start, end);
        float ret;
        {
            ret = p.measureText(mText, start, end - start);
        } //End block
        {
            ret = p.measureText(mText, start + mGapLength, end - start);
        } //End block
        {
            char[] buf;
            buf = TextUtils.obtain(end - start);
            getChars(start, end, buf, 0);
            ret = p.measureText(buf, 0, end - start);
            TextUtils.recycle(buf);
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //checkRange("measureText", start, end);
        //float ret;
        //if (end <= mGapStart) {
            //ret = p.measureText(mText, start, end - start);
        //} else if (start >= mGapStart) {
            //ret = p.measureText(mText, start + mGapLength, end - start);
        //} else {
            //char[] buf = TextUtils.obtain(end - start);
            //getChars(start, end, buf, 0);
            //ret = p.measureText(buf, 0, end - start);
            //TextUtils.recycle(buf);
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.213 -0400", hash_original_method = "0B996033AABA85CCC99081E62BD26114", hash_generated_method = "6FDB854BCC4E8E0F74E726C0BFF6356E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextWidths(int start, int end, float[] widths, Paint p) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(widths);
        dsTaint.addTaint(end);
        checkRange("getTextWidths", start, end);
        int ret;
        {
            ret = p.getTextWidths(mText, start, end - start, widths);
        } //End block
        {
            ret = p.getTextWidths(mText, start + mGapLength, end - start,
                                  widths);
        } //End block
        {
            char[] buf;
            buf = TextUtils.obtain(end - start);
            getChars(start, end, buf, 0);
            ret = p.getTextWidths(buf, 0, end - start, widths);
            TextUtils.recycle(buf);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkRange("getTextWidths", start, end);
        //int ret;
        //if (end <= mGapStart) {
            //ret = p.getTextWidths(mText, start, end - start, widths);
        //} else if (start >= mGapStart) {
            //ret = p.getTextWidths(mText, start + mGapLength, end - start,
                                  //widths);
        //} else {
            //char[] buf = TextUtils.obtain(end - start);
            //getChars(start, end, buf, 0);
            //ret = p.getTextWidths(buf, 0, end - start, widths);
            //TextUtils.recycle(buf);
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.213 -0400", hash_original_method = "FE2235DDEA2C6A2285ED2D1196CDD9B2", hash_generated_method = "A5ED413C65FACA5B1504C49204EF0A51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextRunAdvances(int start, int end, int contextStart, int contextEnd, int flags,
            float[] advances, int advancesPos, Paint p) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(start);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(advances);
        dsTaint.addTaint(end);
        dsTaint.addTaint(advancesPos);
        dsTaint.addTaint(contextEnd);
        float ret;
        int contextLen;
        contextLen = contextEnd - contextStart;
        int len;
        len = end - start;
        {
            ret = p.getTextRunAdvances(mText, start, len, contextStart, contextLen,
                    flags, advances, advancesPos);
        } //End block
        {
            ret = p.getTextRunAdvances(mText, start + mGapLength, len,
                    contextStart + mGapLength, contextLen, flags, advances, advancesPos);
        } //End block
        {
            char[] buf;
            buf = TextUtils.obtain(contextLen);
            getChars(contextStart, contextEnd, buf, 0);
            ret = p.getTextRunAdvances(buf, start - contextStart, len,
                    0, contextLen, flags, advances, advancesPos);
            TextUtils.recycle(buf);
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //float ret;
        //int contextLen = contextEnd - contextStart;
        //int len = end - start;
        //if (end <= mGapStart) {
            //ret = p.getTextRunAdvances(mText, start, len, contextStart, contextLen,
                    //flags, advances, advancesPos);
        //} else if (start >= mGapStart) {
            //ret = p.getTextRunAdvances(mText, start + mGapLength, len,
                    //contextStart + mGapLength, contextLen, flags, advances, advancesPos);
        //} else {
            //char[] buf = TextUtils.obtain(contextLen);
            //getChars(contextStart, contextEnd, buf, 0);
            //ret = p.getTextRunAdvances(buf, start - contextStart, len,
                    //0, contextLen, flags, advances, advancesPos);
            //TextUtils.recycle(buf);
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.214 -0400", hash_original_method = "C231D32FAB37A7BF2DFD000F849A602C", hash_generated_method = "8377990A2A7EDB6ED0D14EBB0956A924")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextRunAdvances(int start, int end, int contextStart, int contextEnd, int flags,
            float[] advances, int advancesPos, Paint p, int reserved) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(start);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(advances);
        dsTaint.addTaint(reserved);
        dsTaint.addTaint(end);
        dsTaint.addTaint(advancesPos);
        dsTaint.addTaint(contextEnd);
        float ret;
        int contextLen;
        contextLen = contextEnd - contextStart;
        int len;
        len = end - start;
        {
            ret = p.getTextRunAdvances(mText, start, len, contextStart, contextLen,
                    flags, advances, advancesPos, reserved);
        } //End block
        {
            ret = p.getTextRunAdvances(mText, start + mGapLength, len,
                    contextStart + mGapLength, contextLen, flags, advances, advancesPos, reserved);
        } //End block
        {
            char[] buf;
            buf = TextUtils.obtain(contextLen);
            getChars(contextStart, contextEnd, buf, 0);
            ret = p.getTextRunAdvances(buf, start - contextStart, len,
                    0, contextLen, flags, advances, advancesPos, reserved);
            TextUtils.recycle(buf);
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.214 -0400", hash_original_method = "ABDF9C9F21432D98EAA229A3E812D636", hash_generated_method = "BC03370BE18BE52007D60B88A2FD4F68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getTextRunCursor(int contextStart, int contextEnd, int flags, int offset,
            int cursorOpt, Paint p) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(cursorOpt);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(contextEnd);
        int ret;
        int contextLen;
        contextLen = contextEnd - contextStart;
        {
            ret = p.getTextRunCursor(mText, contextStart, contextLen,
                    flags, offset, cursorOpt);
        } //End block
        {
            ret = p.getTextRunCursor(mText, contextStart + mGapLength, contextLen,
                    flags, offset + mGapLength, cursorOpt) - mGapLength;
        } //End block
        {
            char[] buf;
            buf = TextUtils.obtain(contextLen);
            getChars(contextStart, contextEnd, buf, 0);
            ret = p.getTextRunCursor(buf, 0, contextLen,
                    flags, offset - contextStart, cursorOpt) + contextStart;
            TextUtils.recycle(buf);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int ret;
        //int contextLen = contextEnd - contextStart;
        //if (contextEnd <= mGapStart) {
            //ret = p.getTextRunCursor(mText, contextStart, contextLen,
                    //flags, offset, cursorOpt);
        //} else if (contextStart >= mGapStart) {
            //ret = p.getTextRunCursor(mText, contextStart + mGapLength, contextLen,
                    //flags, offset + mGapLength, cursorOpt) - mGapLength;
        //} else {
            //char[] buf = TextUtils.obtain(contextLen);
            //getChars(contextStart, contextEnd, buf, 0);
            //ret = p.getTextRunCursor(buf, 0, contextLen,
                    //flags, offset - contextStart, cursorOpt) + contextStart;
            //TextUtils.recycle(buf);
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.214 -0400", hash_original_method = "43280B91F5BF9A1999DA6A7ED3115D4A", hash_generated_method = "2AF48A17DDAEE97DB016DC8B561086C7")
    @DSModeled(DSC.SAFE)
    public void setFilters(InputFilter[] filters) {
        dsTaint.addTaint(filters.dsTaint);
        {
            throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (filters == null) {
            //throw new IllegalArgumentException();
        //}
        //mFilters = filters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.214 -0400", hash_original_method = "E0010D0DD1DD8F03E408AEE972028B3D", hash_generated_method = "72517622107523BEB7D841862EFB75D0")
    @DSModeled(DSC.SAFE)
    public InputFilter[] getFilters() {
        return (InputFilter[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFilters;
    }

    
}


