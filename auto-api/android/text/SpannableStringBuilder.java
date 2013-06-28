package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.android.internal.util.ArrayUtils;
import java.lang.reflect.Array;

public class SpannableStringBuilder implements CharSequence, GetChars, Spannable, Editable, Appendable, GraphicsOperations {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.365 -0400", hash_original_field = "8EF1F84508C44788B91A5266E4C71739", hash_generated_field = "489605ABB55A73F593690CC2882D1D5E")

    private InputFilter[] mFilters = NO_FILTERS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.365 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "6CB0C9E6186F94D00B15A6B38EEADB93")

    private char[] mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.365 -0400", hash_original_field = "E921ED8427024DA9A4D36EB8F6C8FE82", hash_generated_field = "40EFB69E13F0CDEFCFD23CECDA09F21F")

    private int mGapStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.365 -0400", hash_original_field = "5A93D3E21E60377E98165B3EF2A06465", hash_generated_field = "A295E6D1722C924D1E523308C8F24CB5")

    private int mGapLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.365 -0400", hash_original_field = "B8BD6FDCBEDAFD097A52EBBE1CF0F79A", hash_generated_field = "64DC9467A0917D43133A286556BA813F")

    private Object[] mSpans;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.365 -0400", hash_original_field = "F1D8F8A94BA747744CA1C740BC88AFFE", hash_generated_field = "84CB203FE2C516ED9C3D0BE9F569E2FC")

    private int[] mSpanStarts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.365 -0400", hash_original_field = "644B4FD16A6F71B2ED6EADC13E20FB53", hash_generated_field = "B6B8A934A26F4A20670B5A234A93FAF3")

    private int[] mSpanEnds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.365 -0400", hash_original_field = "E9EBB0640FA76A599FDD30354136C22F", hash_generated_field = "F6EC87D3CD6571312E304AA9452368CA")

    private int[] mSpanFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.365 -0400", hash_original_field = "4FDCC29E70C8591103A1AD2BB2AC7494", hash_generated_field = "BDC8CC3C9B276345952883B6B6FC3B62")

    private int mSpanCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.366 -0400", hash_original_method = "FC61BFC3FC94A92F6E91F05B84386B00", hash_generated_method = "803E26A984ACC0C077D94CC677976F62")
    public  SpannableStringBuilder() {
        this("");
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.366 -0400", hash_original_method = "9676D8694A6D1EC55F8FB5E1D9DC6D95", hash_generated_method = "AD8306198DF2DA98740386F2F808A31C")
    public  SpannableStringBuilder(CharSequence text) {
        this(text, 0, text.length());
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.366 -0400", hash_original_method = "D35C3B0425645BAC16D8668E04F8F0BF", hash_generated_method = "F92F24F065040124725AC50236883848")
    public  SpannableStringBuilder(CharSequence text, int start, int end) {
        int srclen = end - start;
        int len = ArrayUtils.idealCharArraySize(srclen + 1);
        mText = new char[len];
        mGapStart = srclen;
        mGapLength = len - srclen;
        TextUtils.getChars(text, start, end, mText, 0);
        mSpanCount = 0;
        int alloc = ArrayUtils.idealIntArraySize(0);
        mSpans = new Object[alloc];
        mSpanStarts = new int[alloc];
        mSpanEnds = new int[alloc];
        mSpanFlags = new int[alloc];
        {
            Spanned sp = (Spanned) text;
            Object[] spans = sp.getSpans(start, end, Object.class);
            {
                int i = 0;
                {
                    int st = sp.getSpanStart(spans[i]) - start;
                    int en = sp.getSpanEnd(spans[i]) - start;
                    int fl = sp.getSpanFlags(spans[i]);
                    st = 0;
                    st = end - start;
                    en = 0;
                    en = end - start;
                    setSpan(spans[i], st, en, fl);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static SpannableStringBuilder valueOf(CharSequence source) {
        if (source instanceof SpannableStringBuilder) {
            return (SpannableStringBuilder) source;
        } else {
            return new SpannableStringBuilder(source);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.367 -0400", hash_original_method = "8A39C40193810117501439EDABBFE6E5", hash_generated_method = "44B146AD24C8EC023C3FEFAA45B6026A")
    public char charAt(int where) {
        int len = length();
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("charAt: " + where + " < 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("charAt: " + where + " >= length " + len);
        } //End block
        addTaint(where);
        char varA87DEB01C5F539E6BDA34829C8EF2368_858041471 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_858041471;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.368 -0400", hash_original_method = "9A6AB9CE1EAE128DD9B2405D2B37CA46", hash_generated_method = "7604081A1F809AC694C51107424AB097")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989121063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989121063;
        // ---------- Original Method ----------
        //return mText.length - mGapLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.369 -0400", hash_original_method = "976FC6C6553888C069C4B298C5B14B80", hash_generated_method = "456562C81774D56BAA81DFE6FA40ABEF")
    private void resizeFor(int size) {
        int newlen = ArrayUtils.idealCharArraySize(size + 1);
        char[] newtext = new char[newlen];
        int after = mText.length - (mGapStart + mGapLength);
        System.arraycopy(mText, 0, newtext, 0, mGapStart);
        System.arraycopy(mText, mText.length - after,
                         newtext, newlen - after, after);
        {
            int i = 0;
            {
                mSpanStarts[i] += newlen - mText.length;
                mSpanEnds[i] += newlen - mText.length;
            } //End block
        } //End collapsed parenthetic
        int oldlen = mText.length;
        mText = newtext;
        mGapLength += mText.length - oldlen;
        new Exception("mGapLength < 1").printStackTrace();
        addTaint(size);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.369 -0400", hash_original_method = "D9447594759C2324F4C84ED525D8EBA8", hash_generated_method = "03A6959909F142416A944F778B46B412")
    private void moveGapTo(int where) {
        boolean atend = (where == length());
        {
            int overlap = mGapStart - where;
            System.arraycopy(mText, where,
                             mText, mGapStart + mGapLength - overlap, overlap);
        } //End block
        {
            int overlap = where - mGapStart;
            System.arraycopy(mText, where + mGapLength - overlap,
                             mText, mGapStart, overlap);
        } //End block
        {
            int i = 0;
            {
                int start = mSpanStarts[i];
                int end = mSpanEnds[i];
                start -= mGapLength;
                start += mGapLength;
                {
                    int flag = (mSpanFlags[i] & START_MASK) >> START_SHIFT;
                    start += mGapLength;
                } //End block
                end -= mGapLength;
                end += mGapLength;
                {
                    int flag = (mSpanFlags[i] & END_MASK);
                    end += mGapLength;
                } //End block
                mSpanStarts[i] = start;
                mSpanEnds[i] = end;
            } //End block
        } //End collapsed parenthetic
        mGapStart = where;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.370 -0400", hash_original_method = "05B349B857A56AE010B814959800B44E", hash_generated_method = "76CCCB1D8C256A710C7A5E0467457CB6")
    public SpannableStringBuilder insert(int where, CharSequence tb, int start, int end) {
        SpannableStringBuilder varB4EAC82CA7396A68D541C85D26508E83_1760667176 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1760667176 = replace(where, where, tb, start, end);
        addTaint(where);
        addTaint(tb.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1760667176.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1760667176;
        // ---------- Original Method ----------
        //return replace(where, where, tb, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.371 -0400", hash_original_method = "8FF3D73D08A9AFA2B9C652CF8F4F615D", hash_generated_method = "5E5880D1AED5CA5E98B87FDBFBB900EA")
    public SpannableStringBuilder insert(int where, CharSequence tb) {
        SpannableStringBuilder varB4EAC82CA7396A68D541C85D26508E83_848244916 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_848244916 = replace(where, where, tb, 0, tb.length());
        addTaint(where);
        addTaint(tb.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_848244916.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_848244916;
        // ---------- Original Method ----------
        //return replace(where, where, tb, 0, tb.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.371 -0400", hash_original_method = "CCAFF8AC74D86E62008C289B374BD199", hash_generated_method = "A742F37A8792D90346574C2DC20B942E")
    public SpannableStringBuilder delete(int start, int end) {
        SpannableStringBuilder varB4EAC82CA7396A68D541C85D26508E83_878866725 = null; //Variable for return #1
        SpannableStringBuilder ret = replace(start, end, "", 0, 0);
        {
            boolean varCFB5555CC98A8456696144D750C956C3_509170439 = (mGapLength > 2 * length());
            resizeFor(length());
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_878866725 = ret;
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_878866725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_878866725;
        // ---------- Original Method ----------
        //SpannableStringBuilder ret = replace(start, end, "", 0, 0);
        //if (mGapLength > 2 * length())
            //resizeFor(length());
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.371 -0400", hash_original_method = "D18AC1E4EB05736F525932BC47697F9D", hash_generated_method = "2F4BCC7A2ECD16DA4BAF7CFF6AC91F91")
    public void clear() {
        replace(0, length(), "", 0, 0);
        // ---------- Original Method ----------
        //replace(0, length(), "", 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.372 -0400", hash_original_method = "DCA8D2BE237B08ED7EF41B903E9CA024", hash_generated_method = "DABC59551175CA871B2A9B9FC2A76EB8")
    public void clearSpans() {
        {
            int i = mSpanCount - 1;
            {
                Object what = mSpans[i];
                int ostart = mSpanStarts[i];
                int oend = mSpanEnds[i];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.372 -0400", hash_original_method = "A87DD944FE6567F6923432E1C1B56712", hash_generated_method = "E4F29D0E88274D474D69E35FCF7CCD8A")
    public SpannableStringBuilder append(CharSequence text) {
        SpannableStringBuilder varB4EAC82CA7396A68D541C85D26508E83_1284771337 = null; //Variable for return #1
        int length = length();
        varB4EAC82CA7396A68D541C85D26508E83_1284771337 = replace(length, length, text, 0, text.length());
        addTaint(text.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1284771337.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1284771337;
        // ---------- Original Method ----------
        //int length = length();
        //return replace(length, length, text, 0, text.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.373 -0400", hash_original_method = "2E8C7D2887FD28E969B785C3CCFE69E2", hash_generated_method = "D659CD03137B08F29F05A11BB6519308")
    public SpannableStringBuilder append(CharSequence text, int start, int end) {
        SpannableStringBuilder varB4EAC82CA7396A68D541C85D26508E83_1850767627 = null; //Variable for return #1
        int length = length();
        varB4EAC82CA7396A68D541C85D26508E83_1850767627 = replace(length, length, text, start, end);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1850767627.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1850767627;
        // ---------- Original Method ----------
        //int length = length();
        //return replace(length, length, text, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.373 -0400", hash_original_method = "CAF0941E3E4124F46031A9B624CEE660", hash_generated_method = "1194581F2CE76A5D80C37B9BD09C5159")
    public SpannableStringBuilder append(char text) {
        SpannableStringBuilder varB4EAC82CA7396A68D541C85D26508E83_1405766072 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1405766072 = append(String.valueOf(text));
        addTaint(text);
        varB4EAC82CA7396A68D541C85D26508E83_1405766072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1405766072;
        // ---------- Original Method ----------
        //return append(String.valueOf(text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.374 -0400", hash_original_method = "3C715BB6E3D7DD6490206A10C6A892D0", hash_generated_method = "37DFCD1DB6A056053A40525345751C8A")
    private int change(int start, int end, CharSequence tb, int tbstart, int tbend) {
        int var3016398390FA3B4EF0297C32DD8390A3_1489807177 = (change(true, start, end, tb, tbstart, tbend));
        addTaint(start);
        addTaint(end);
        addTaint(tb.getTaint());
        addTaint(tbstart);
        addTaint(tbend);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492018811 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492018811;
        // ---------- Original Method ----------
        //return change(true, start, end, tb, tbstart, tbend);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.375 -0400", hash_original_method = "84DCE273834998C04B3160C57E76984B", hash_generated_method = "3F1032E8B025E20D2919BA3C7F8CE11F")
    private int change(boolean notify, int start, int end,
                       CharSequence tb, int tbstart, int tbend) {
        checkRange("replace", start, end);
        int ret = tbend - tbstart;
        TextWatcher[] recipients = null;
        {
            recipients = sendTextWillChange(start, end - start, tbend - tbstart);
        } //End block
        {
            int i = mSpanCount - 1;
            {
                {
                    int st = mSpanStarts[i];
                    st -= mGapLength;
                    int en = mSpanEnds[i];
                    en -= mGapLength;
                    int ost = st;
                    int oen = en;
                    int clen = length();
                    {
                        {
                            st = end;
                            {
                                boolean varBFE60C587C9C6F6C8D150DFF94D33D1A_1013881760 = (st > end && charAt(st - 1) == '\n');
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            en = end;
                            {
                                boolean varB4FE50EC2B1C228FAAAD3CF5EDD3BF5A_1550783948 = (en > end && charAt(en - 1) == '\n');
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                    setSpan(mSpans[i], st, en, mSpanFlags[i]);
                } //End block
            } //End block
        } //End collapsed parenthetic
        moveGapTo(end);
        final int nbNewChars = (tbend - tbstart) - (end - start);
        {
            resizeFor(mText.length + nbNewChars - mGapLength);
        } //End block
        mGapStart += nbNewChars;
        mGapLength -= nbNewChars;
        new Exception("mGapLength < 1").printStackTrace();
        TextUtils.getChars(tb, tbstart, tbend, mText, start);
        {
            Spanned sp = (Spanned) tb;
            Object[] spans = sp.getSpans(tbstart, tbend, Object.class);
            {
                int i = 0;
                {
                    int st = sp.getSpanStart(spans[i]);
                    int en = sp.getSpanEnd(spans[i]);
                    st = tbstart;
                    en = tbend;
                    {
                        boolean varE962BA69F8DD7114748830F1B8735548_54968181 = (getSpanStart(spans[i]) < 0);
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
        boolean atend = (mGapStart + mGapLength == mText.length);
        {
            int i = mSpanCount - 1;
            {
                {
                    int flag = (mSpanFlags[i] & START_MASK) >> START_SHIFT;
                    mSpanStarts[i] = mGapStart + mGapLength;
                    mSpanStarts[i] = start;
                } //End block
                {
                    int flag = (mSpanFlags[i] & END_MASK);
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
        addTaint(notify);
        addTaint(end);
        addTaint(tb.getTaint());
        addTaint(tbstart);
        addTaint(tbend);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1366563055 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1366563055;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.376 -0400", hash_original_method = "5F40E5580DD9B6C8070DDBE86036D0A0", hash_generated_method = "1B205AB08E6EF8F3348E3672B1DEB752")
    private void removeSpan(int i) {
        Object object = mSpans[i];
        int start = mSpanStarts[i];
        int end = mSpanEnds[i];
        start -= mGapLength;
        end -= mGapLength;
        int count = mSpanCount - (i + 1);
        System.arraycopy(mSpans, i + 1, mSpans, i, count);
        System.arraycopy(mSpanStarts, i + 1, mSpanStarts, i, count);
        System.arraycopy(mSpanEnds, i + 1, mSpanEnds, i, count);
        System.arraycopy(mSpanFlags, i + 1, mSpanFlags, i, count);
        mSpans[mSpanCount] = null;
        sendSpanRemoved(object, start, end);
        addTaint(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.377 -0400", hash_original_method = "F007284EC0E266D0B466C6FB60440DED", hash_generated_method = "B7A397BFC978E75F4553823C969F245A")
    public SpannableStringBuilder replace(int start, int end, CharSequence tb) {
        SpannableStringBuilder varB4EAC82CA7396A68D541C85D26508E83_183422925 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_183422925 = replace(start, end, tb, 0, tb.length());
        addTaint(start);
        addTaint(end);
        addTaint(tb.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_183422925.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_183422925;
        // ---------- Original Method ----------
        //return replace(start, end, tb, 0, tb.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.378 -0400", hash_original_method = "653147CE10EC22F15BE8C423BD65FA32", hash_generated_method = "C0C2A5636333510A1E2CF039CACE347A")
    public SpannableStringBuilder replace(final int start, final int end,
                        CharSequence tb, int tbstart, int tbend) {
        SpannableStringBuilder varB4EAC82CA7396A68D541C85D26508E83_387466459 = null; //Variable for return #1
        SpannableStringBuilder varB4EAC82CA7396A68D541C85D26508E83_559070622 = null; //Variable for return #2
        int filtercount = mFilters.length;
        {
            int i = 0;
            {
                CharSequence repl = mFilters[i].filter(tb, tbstart, tbend,
                                                   this, start, end);
                {
                    tb = repl;
                    tbstart = 0;
                    tbend = repl.length();
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_387466459 = this;
        } //End block
        {
            change(start, end, tb, tbstart, tbend);
        } //End block
        {
            int selstart = Selection.getSelectionStart(this);
            int selend = Selection.getSelectionEnd(this);
            checkRange("replace", start, end);
            moveGapTo(end);
            TextWatcher[] recipients;
            int origlen = end - start;
            recipients = sendTextWillChange(start, origlen, tbend - tbstart);
            resizeFor(length() + 1);
            {
                int i = mSpanCount - 1;
            } //End collapsed parenthetic
            mText[mGapStart] = ' ';
            {
                new Exception("mGapLength < 1").printStackTrace();
            } //End block
            int inserted = change(false, start + 1, start + 1, tb, tbstart, tbend);
            change(false, start, start + 1, "", 0, 0);
            change(false, start + inserted, start + inserted + origlen, "", 0, 0);
            {
                long off = selstart - start;
                off = off * inserted / (end - start);
                selstart = (int) off + start;
                setSpan(false, Selection.SELECTION_START, selstart, selstart,
                        Spanned.SPAN_POINT_POINT);
            } //End block
            {
                long off = selend - start;
                off = off * inserted / (end - start);
                selend = (int) off + start;
                setSpan(false, Selection.SELECTION_END, selend, selend, Spanned.SPAN_POINT_POINT);
            } //End block
            sendTextChange(recipients, start, origlen, inserted);
            sendTextHasChanged(recipients);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_559070622 = this;
        addTaint(start);
        addTaint(end);
        addTaint(tb.getTaint());
        addTaint(tbstart);
        addTaint(tbend);
        SpannableStringBuilder varA7E53CE21691AB073D9660D615818899_579365624; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_579365624 = varB4EAC82CA7396A68D541C85D26508E83_387466459;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_579365624 = varB4EAC82CA7396A68D541C85D26508E83_559070622;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_579365624.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_579365624;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.379 -0400", hash_original_method = "69D700DE18AC29DD7D1DA7BDFB6B76AF", hash_generated_method = "94FF4C102C7FFBA9EBF61F9FC5208E1F")
    public void setSpan(Object what, int start, int end, int flags) {
        setSpan(true, what, start, end, flags);
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(flags);
        // ---------- Original Method ----------
        //setSpan(true, what, start, end, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.381 -0400", hash_original_method = "2D459893E2DC729F5693ABCD511FCC18", hash_generated_method = "DC4D37CC453502B025C71C9F52689D1F")
    private void setSpan(boolean send, Object what, int start, int end, int flags) {
        int nstart = start;
        int nend = end;
        checkRange("setSpan", start, end);
        {
            {
                boolean var50D67EA6491FC514B6D92D2E40689E61_2015607415 = (start != 0 && start != length());
                {
                    char c = charAt(start - 1);
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("PARAGRAPH span must start at paragraph boundary");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var5B6CF9C5E41E159F793AF4E9C33451FF_928597403 = (end != 0 && end != length());
                {
                    char c = charAt(end - 1);
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("PARAGRAPH span must end at paragraph boundary");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            start += mGapLength;
        } //End block
        {
            int flag = (flags & START_MASK) >> START_SHIFT;
            {
                boolean var178F36AF86CF523AC45E3DA928EB6603_296397678 = (flag == POINT || (flag == PARAGRAPH && start == length()));
                start += mGapLength;
            } //End collapsed parenthetic
        } //End block
        {
            end += mGapLength;
        } //End block
        {
            int flag = (flags & END_MASK);
            {
                boolean var80BFA6A9886ED960BFDD8DFECE7B441C_505857059 = (flag == POINT || (flag == PARAGRAPH && end == length()));
                end += mGapLength;
            } //End collapsed parenthetic
        } //End block
        int count = mSpanCount;
        Object[] spans = mSpans;
        {
            int i = 0;
            {
                {
                    int ostart = mSpanStarts[i];
                    int oend = mSpanEnds[i];
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
            int newsize = ArrayUtils.idealIntArraySize(mSpanCount + 1);
            Object[] newspans = new Object[newsize];
            int[] newspanstarts = new int[newsize];
            int[] newspanends = new int[newsize];
            int[] newspanflags = new int[newsize];
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
        sendSpanAdded(what, nstart, nend);
        addTaint(send);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.382 -0400", hash_original_method = "F7FA44646A47341A9BCB6EBFF8147DB3", hash_generated_method = "8728D7EE833A09AFBDF689FB22086DBD")
    public void removeSpan(Object what) {
        {
            int i = mSpanCount - 1;
            {
                {
                    removeSpan(i);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //for (int i = mSpanCount - 1; i >= 0; i--) {
            //if (mSpans[i] == what) {
                //removeSpan(i);
                //return;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.383 -0400", hash_original_method = "DD4C166AC7D5C475EE46AC767DBD33EB", hash_generated_method = "FB42624A0950155131E7E54FBAF3D7DF")
    public int getSpanStart(Object what) {
        int count = mSpanCount;
        Object[] spans = mSpans;
        {
            int i = count - 1;
            {
                {
                    int where = mSpanStarts[i];
                    where -= mGapLength;
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(what.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2060945606 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2060945606;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.383 -0400", hash_original_method = "1CAC5A6045B202B1FC928510B17AEEDD", hash_generated_method = "711EC640B024F2E69F7E38B077AD7F23")
    public int getSpanEnd(Object what) {
        int count = mSpanCount;
        Object[] spans = mSpans;
        {
            int i = count - 1;
            {
                {
                    int where = mSpanEnds[i];
                    where -= mGapLength;
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(what.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972125628 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972125628;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.384 -0400", hash_original_method = "DA0589F2510DDCCEED97B90C9189C1B9", hash_generated_method = "721014F249BA1C0450E9F2C4BC473896")
    public int getSpanFlags(Object what) {
        int count = mSpanCount;
        Object[] spans = mSpans;
        {
            int i = count - 1;
        } //End collapsed parenthetic
        addTaint(what.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818380184 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818380184;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.385 -0400", hash_original_method = "5CF7F75C8FAF8266A003E04C7C47A211", hash_generated_method = "D36FC1EB40684932B132859E500E1B40")
    @SuppressWarnings("unchecked")
    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> kind) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_649577911 = null; //Variable for return #1
        T[] varB4EAC82CA7396A68D541C85D26508E83_1499889893 = null; //Variable for return #2
        T[] varB4EAC82CA7396A68D541C85D26508E83_985376558 = null; //Variable for return #3
        T[] varB4EAC82CA7396A68D541C85D26508E83_2018599506 = null; //Variable for return #4
        T[] varB4EAC82CA7396A68D541C85D26508E83_51973712 = null; //Variable for return #5
        varB4EAC82CA7396A68D541C85D26508E83_649577911 = ArrayUtils.emptyArray(kind);
        int spanCount = mSpanCount;
        Object[] spans = mSpans;
        int[] starts = mSpanStarts;
        int[] ends = mSpanEnds;
        int[] flags = mSpanFlags;
        int gapstart = mGapStart;
        int gaplen = mGapLength;
        int count = 0;
        T[] ret = null;
        T ret1 = null;
        {
            int i = 0;
            {
                int spanStart = starts[i];
                {
                    spanStart -= gaplen;
                } //End block
                int spanEnd = ends[i];
                {
                    spanEnd -= gaplen;
                } //End block
                {
                    boolean var4C3968C27883F1B4B4C15526A74C7F41_810734296 = (!kind.isInstance(spans[i]));
                } //End collapsed parenthetic
                {
                    ret1 = (T) spans[i];
                } //End block
                {
                    {
                        ret = (T[]) Array.newInstance(kind, spanCount - i + 1);
                        ret[0] = ret1;
                    } //End block
                    int prio = flags[i] & SPAN_PRIORITY;
                    {
                        int j;
                        {
                            j = 0;
                            {
                                int p = getSpanFlags(ret[j]) & SPAN_PRIORITY;
                            } //End block
                        } //End collapsed parenthetic
                        System.arraycopy(ret, j, ret, j + 1, count - j);
                        ret[j] = (T) spans[i];
                    } //End block
                    {
                        ret[count++] = (T) spans[i];
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_1499889893 = ArrayUtils.emptyArray(kind);
        } //End block
        {
            ret = (T[]) Array.newInstance(kind, 1);
            ret[0] = ret1;
            varB4EAC82CA7396A68D541C85D26508E83_985376558 = ret;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2018599506 = ret;
        } //End block
        T[] nret = (T[]) Array.newInstance(kind, count);
        System.arraycopy(ret, 0, nret, 0, count);
        varB4EAC82CA7396A68D541C85D26508E83_51973712 = nret;
        addTaint(queryStart);
        addTaint(queryEnd);
        addTaint(kind.getTaint());
        T[] varA7E53CE21691AB073D9660D615818899_1698488120; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1698488120 = varB4EAC82CA7396A68D541C85D26508E83_649577911;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1698488120 = varB4EAC82CA7396A68D541C85D26508E83_1499889893;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1698488120 = varB4EAC82CA7396A68D541C85D26508E83_985376558;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1698488120 = varB4EAC82CA7396A68D541C85D26508E83_2018599506;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1698488120 = varB4EAC82CA7396A68D541C85D26508E83_51973712;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1698488120.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1698488120;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.386 -0400", hash_original_method = "AC3B57A902A92307655B10B6A320F4FA", hash_generated_method = "ABF60B7823A86CA18154764E66C5872F")
    public int nextSpanTransition(int start, int limit, Class kind) {
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] starts = mSpanStarts;
        int[] ends = mSpanEnds;
        int gapstart = mGapStart;
        int gaplen = mGapLength;
        {
            kind = Object.class;
        } //End block
        {
            int i = 0;
            {
                int st = starts[i];
                int en = ends[i];
                st -= gaplen;
                en -= gaplen;
                {
                    boolean varF6D66FD5D17035475727187422C2B841_812214223 = (st > start && st < limit && kind.isInstance(spans[i]));
                    limit = st;
                } //End collapsed parenthetic
                {
                    boolean varDD4114CCD8FA698F5DA31E38C7560428_2135531439 = (en > start && en < limit && kind.isInstance(spans[i]));
                    limit = en;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(start);
        addTaint(limit);
        addTaint(kind.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2056826764 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2056826764;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.387 -0400", hash_original_method = "31E22DABAC481CACAF1D07C50FD19E47", hash_generated_method = "A6F810CE1A190575B55DAF8FF6421307")
    public CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1816976493 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1816976493 = new SpannableStringBuilder(this, start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1816976493.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1816976493;
        // ---------- Original Method ----------
        //return new SpannableStringBuilder(this, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.387 -0400", hash_original_method = "063174DC666DF3AA6ABCE47B5208FD87", hash_generated_method = "2A0D72E210C61D373E7AC9FC6C1C560E")
    public void getChars(int start, int end, char[] dest, int destoff) {
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
        addTaint(start);
        addTaint(end);
        addTaint(dest[0]);
        addTaint(destoff);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.388 -0400", hash_original_method = "4F74498D478E367DDE05120AE1CE9765", hash_generated_method = "EB9BF0125824853BBD0DD7260F875909")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1356898451 = null; //Variable for return #1
        int len = length();
        char[] buf = new char[len];
        getChars(0, len, buf, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1356898451 = new String(buf);
        varB4EAC82CA7396A68D541C85D26508E83_1356898451.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1356898451;
        // ---------- Original Method ----------
        //int len = length();
        //char[] buf = new char[len];
        //getChars(0, len, buf, 0);
        //return new String(buf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.389 -0400", hash_original_method = "5E2755BFE298194FA4E39DBC872CF6D4", hash_generated_method = "91CCDAE4B374C5ACEC5909DA14311C67")
    public String substring(int start, int end) {
        String varB4EAC82CA7396A68D541C85D26508E83_802030505 = null; //Variable for return #1
        char[] buf = new char[end - start];
        getChars(start, end, buf, 0);
        varB4EAC82CA7396A68D541C85D26508E83_802030505 = new String(buf);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_802030505.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_802030505;
        // ---------- Original Method ----------
        //char[] buf = new char[end - start];
        //getChars(start, end, buf, 0);
        //return new String(buf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.391 -0400", hash_original_method = "9EEE5F03C950DBDA8CD631C0E0A3B78A", hash_generated_method = "D37C898C7AB57BEFFEB941F344D6054B")
    private TextWatcher[] sendTextWillChange(int start, int before, int after) {
        TextWatcher[] varB4EAC82CA7396A68D541C85D26508E83_393336738 = null; //Variable for return #1
        TextWatcher[] recip = getSpans(start, start + before, TextWatcher.class);
        int n = recip.length;
        {
            int i = 0;
            {
                recip[i].beforeTextChanged(this, start, before, after);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_393336738 = recip;
        addTaint(start);
        addTaint(before);
        addTaint(after);
        varB4EAC82CA7396A68D541C85D26508E83_393336738.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_393336738;
        // ---------- Original Method ----------
        //TextWatcher[] recip = getSpans(start, start + before, TextWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].beforeTextChanged(this, start, before, after);
        //}
        //return recip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.392 -0400", hash_original_method = "B0F46C63F0D82B2972BAF2786F5024B6", hash_generated_method = "07BBA3D7D319120C4D4E61B7E1045267")
    private void sendTextChange(TextWatcher[] recip, int start, int before, int after) {
        int n = recip.length;
        {
            int i = 0;
            {
                recip[i].onTextChanged(this, start, before, after);
            } //End block
        } //End collapsed parenthetic
        addTaint(recip[0].getTaint());
        addTaint(start);
        addTaint(before);
        addTaint(after);
        // ---------- Original Method ----------
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onTextChanged(this, start, before, after);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.392 -0400", hash_original_method = "B7AEF4E180417D3A92FE965B8D29719A", hash_generated_method = "4CFB6561C088F956D758338A0C0F52DF")
    private void sendTextHasChanged(TextWatcher[] recip) {
        int n = recip.length;
        {
            int i = 0;
            {
                recip[i].afterTextChanged(this);
            } //End block
        } //End collapsed parenthetic
        addTaint(recip[0].getTaint());
        // ---------- Original Method ----------
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].afterTextChanged(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.393 -0400", hash_original_method = "39DD82D37A3679E95040612AC2A4CD5D", hash_generated_method = "B0A8C6CA47CCFBADEF3F04576DCE9891")
    private void sendSpanAdded(Object what, int start, int end) {
        SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        int n = recip.length;
        {
            int i = 0;
            {
                recip[i].onSpanAdded(this, what, start, end);
            } //End block
        } //End collapsed parenthetic
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanAdded(this, what, start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.393 -0400", hash_original_method = "8451F34A8F8537B6F36684962116E358", hash_generated_method = "0E3F7CCC9CA3D1B15CECCC286BEC7A85")
    private void sendSpanRemoved(Object what, int start, int end) {
        SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        int n = recip.length;
        {
            int i = 0;
            {
                recip[i].onSpanRemoved(this, what, start, end);
            } //End block
        } //End collapsed parenthetic
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanRemoved(this, what, start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.394 -0400", hash_original_method = "89C4871AB16E570ACF45A07B8EFEFB25", hash_generated_method = "5252029EB2E43F77698CF09F468AF493")
    private void sendSpanChanged(Object what, int s, int e, int st, int en) {
        SpanWatcher[] recip = getSpans(Math.min(s, st), Math.max(e, en), SpanWatcher.class);
        int n = recip.length;
        {
            int i = 0;
            {
                recip[i].onSpanChanged(this, what, s, e, st, en);
            } //End block
        } //End collapsed parenthetic
        addTaint(what.getTaint());
        addTaint(s);
        addTaint(e);
        addTaint(st);
        addTaint(en);
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(Math.min(s, st), Math.max(e, en), SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanChanged(this, what, s, e, st, en);
        //}
    }

    
    private static String region(int start, int end) {
        return "(" + start + " ... " + end + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.394 -0400", hash_original_method = "70C480F1BBBBF461E174788F8B29326C", hash_generated_method = "64FEF0522E1F30638ACC56806F86611A")
    private void checkRange(final String operation, int start, int end) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " has end before start");
        } //End block
        int len = length();
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " ends beyond length " + len);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " starts before 0");
        } //End block
        addTaint(operation.getTaint());
        addTaint(start);
        addTaint(end);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.395 -0400", hash_original_method = "78639A54CC0D16962D9B6A20CA716009", hash_generated_method = "13BC135EAE38EBF05B21D41E524902A2")
    public void drawText(Canvas c, int start, int end,
                         float x, float y, Paint p) {
        checkRange("drawText", start, end);
        {
            c.drawText(mText, start, end - start, x, y, p);
        } //End block
        {
            c.drawText(mText, start + mGapLength, end - start, x, y, p);
        } //End block
        {
            char[] buf = TextUtils.obtain(end - start);
            getChars(start, end, buf, 0);
            c.drawText(buf, 0, end - start, x, y, p);
            TextUtils.recycle(buf);
        } //End block
        addTaint(c.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(x);
        addTaint(y);
        addTaint(p.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.395 -0400", hash_original_method = "623CEE9BFDFC43532CC6E8FD83D183BD", hash_generated_method = "423947B5FCF404BCE03DE3C956CA4A74")
    public void drawTextRun(Canvas c, int start, int end,
            int contextStart, int contextEnd,
            float x, float y, int flags, Paint p) {
        checkRange("drawTextRun", start, end);
        int contextLen = contextEnd - contextStart;
        int len = end - start;
        {
            c.drawTextRun(mText, start, len, contextStart, contextLen, x, y, flags, p);
        } //End block
        {
            c.drawTextRun(mText, start + mGapLength, len, contextStart + mGapLength,
                    contextLen, x, y, flags, p);
        } //End block
        {
            char[] buf = TextUtils.obtain(contextLen);
            getChars(contextStart, contextEnd, buf, 0);
            c.drawTextRun(buf, start - contextStart, len, 0, contextLen, x, y, flags, p);
            TextUtils.recycle(buf);
        } //End block
        addTaint(c.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(x);
        addTaint(y);
        addTaint(flags);
        addTaint(p.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.396 -0400", hash_original_method = "5FD711D7C19B78DA72F1C64F29FD53D3", hash_generated_method = "A2A428017361F8C158BFF6154C84737A")
    public float measureText(int start, int end, Paint p) {
        checkRange("measureText", start, end);
        float ret;
        {
            ret = p.measureText(mText, start, end - start);
        } //End block
        {
            ret = p.measureText(mText, start + mGapLength, end - start);
        } //End block
        {
            char[] buf = TextUtils.obtain(end - start);
            getChars(start, end, buf, 0);
            ret = p.measureText(buf, 0, end - start);
            TextUtils.recycle(buf);
        } //End block
        addTaint(start);
        addTaint(end);
        addTaint(p.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_1509013576 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1509013576;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.396 -0400", hash_original_method = "0B996033AABA85CCC99081E62BD26114", hash_generated_method = "8F5097C89FD375C059CA53547D0652B2")
    public int getTextWidths(int start, int end, float[] widths, Paint p) {
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
            char[] buf = TextUtils.obtain(end - start);
            getChars(start, end, buf, 0);
            ret = p.getTextWidths(buf, 0, end - start, widths);
            TextUtils.recycle(buf);
        } //End block
        addTaint(start);
        addTaint(end);
        addTaint(widths[0]);
        addTaint(p.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030393034 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030393034;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.397 -0400", hash_original_method = "FE2235DDEA2C6A2285ED2D1196CDD9B2", hash_generated_method = "03CB582FFAB86BE1E878EA2925C19495")
    public float getTextRunAdvances(int start, int end, int contextStart, int contextEnd, int flags,
            float[] advances, int advancesPos, Paint p) {
        float ret;
        int contextLen = contextEnd - contextStart;
        int len = end - start;
        {
            ret = p.getTextRunAdvances(mText, start, len, contextStart, contextLen,
                    flags, advances, advancesPos);
        } //End block
        {
            ret = p.getTextRunAdvances(mText, start + mGapLength, len,
                    contextStart + mGapLength, contextLen, flags, advances, advancesPos);
        } //End block
        {
            char[] buf = TextUtils.obtain(contextLen);
            getChars(contextStart, contextEnd, buf, 0);
            ret = p.getTextRunAdvances(buf, start - contextStart, len,
                    0, contextLen, flags, advances, advancesPos);
            TextUtils.recycle(buf);
        } //End block
        addTaint(start);
        addTaint(end);
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(flags);
        addTaint(advances[0]);
        addTaint(advancesPos);
        addTaint(p.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_844997420 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_844997420;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.398 -0400", hash_original_method = "C231D32FAB37A7BF2DFD000F849A602C", hash_generated_method = "2E5E4469A1CCD8EA7D55E06CC8BF7279")
    public float getTextRunAdvances(int start, int end, int contextStart, int contextEnd, int flags,
            float[] advances, int advancesPos, Paint p, int reserved) {
        float ret;
        int contextLen = contextEnd - contextStart;
        int len = end - start;
        {
            ret = p.getTextRunAdvances(mText, start, len, contextStart, contextLen,
                    flags, advances, advancesPos, reserved);
        } //End block
        {
            ret = p.getTextRunAdvances(mText, start + mGapLength, len,
                    contextStart + mGapLength, contextLen, flags, advances, advancesPos, reserved);
        } //End block
        {
            char[] buf = TextUtils.obtain(contextLen);
            getChars(contextStart, contextEnd, buf, 0);
            ret = p.getTextRunAdvances(buf, start - contextStart, len,
                    0, contextLen, flags, advances, advancesPos, reserved);
            TextUtils.recycle(buf);
        } //End block
        addTaint(start);
        addTaint(end);
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(flags);
        addTaint(advances[0]);
        addTaint(advancesPos);
        addTaint(p.getTaint());
        addTaint(reserved);
        float var546ADE640B6EDFBC8A086EF31347E768_328138367 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_328138367;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.399 -0400", hash_original_method = "ABDF9C9F21432D98EAA229A3E812D636", hash_generated_method = "692A2ACF40D2EE5621C88DBE803B7ECD")
    @Deprecated
    public int getTextRunCursor(int contextStart, int contextEnd, int flags, int offset,
            int cursorOpt, Paint p) {
        int ret;
        int contextLen = contextEnd - contextStart;
        {
            ret = p.getTextRunCursor(mText, contextStart, contextLen,
                    flags, offset, cursorOpt);
        } //End block
        {
            ret = p.getTextRunCursor(mText, contextStart + mGapLength, contextLen,
                    flags, offset + mGapLength, cursorOpt) - mGapLength;
        } //End block
        {
            char[] buf = TextUtils.obtain(contextLen);
            getChars(contextStart, contextEnd, buf, 0);
            ret = p.getTextRunCursor(buf, 0, contextLen,
                    flags, offset - contextStart, cursorOpt) + contextStart;
            TextUtils.recycle(buf);
        } //End block
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(flags);
        addTaint(offset);
        addTaint(cursorOpt);
        addTaint(p.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_996019817 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_996019817;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.399 -0400", hash_original_method = "43280B91F5BF9A1999DA6A7ED3115D4A", hash_generated_method = "744F518B881384CEDE5FE548D9D5EA1F")
    public void setFilters(InputFilter[] filters) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        mFilters = filters;
        // ---------- Original Method ----------
        //if (filters == null) {
            //throw new IllegalArgumentException();
        //}
        //mFilters = filters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.401 -0400", hash_original_method = "E0010D0DD1DD8F03E408AEE972028B3D", hash_generated_method = "CC27201A365D838C62385A79AC8D8F28")
    public InputFilter[] getFilters() {
        InputFilter[] varB4EAC82CA7396A68D541C85D26508E83_1168719714 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1168719714 = mFilters;
        varB4EAC82CA7396A68D541C85D26508E83_1168719714.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1168719714;
        // ---------- Original Method ----------
        //return mFilters;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.401 -0400", hash_original_field = "A0DA38A5AAD1658278F1D161AF84C1BC", hash_generated_field = "EDD7FE0B7D12EE9C3486272F367681B2")

    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.401 -0400", hash_original_field = "8E25CB8BBC7F057E695EB32AFA1A76C1", hash_generated_field = "C7F2D79B9AFA94FAA8193039FD601611")

    private static final int POINT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.401 -0400", hash_original_field = "01108F1ED53C20D4E3131B788368B220", hash_generated_field = "DAC314A52970829DE920414BCD420813")

    private static final int PARAGRAPH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.401 -0400", hash_original_field = "5CBC27631C132E42BC6EE2620FBE874C", hash_generated_field = "62F477B3AA465E1D6BB9002CA3207142")

    private static final int START_MASK = 0xF0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.401 -0400", hash_original_field = "A6B335A49CDCE8810689E33B5A49F35D", hash_generated_field = "DB23288AE0F2FDCBE5902F7D83D9C129")

    private static final int END_MASK = 0x0F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.401 -0400", hash_original_field = "408D27312BE6845294059D1D121D5FC2", hash_generated_field = "6EE5967CCE475609F69D5553B70E80C8")

    private static final int START_SHIFT = 4;
}

