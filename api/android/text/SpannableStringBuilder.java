package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.android.internal.util.ArrayUtils;
import java.lang.reflect.Array;

public class SpannableStringBuilder implements CharSequence, GetChars, Spannable, Editable, Appendable, GraphicsOperations {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.577 -0400", hash_original_field = "8EF1F84508C44788B91A5266E4C71739", hash_generated_field = "489605ABB55A73F593690CC2882D1D5E")

    private InputFilter[] mFilters = NO_FILTERS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.577 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "6CB0C9E6186F94D00B15A6B38EEADB93")

    private char[] mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.577 -0400", hash_original_field = "E921ED8427024DA9A4D36EB8F6C8FE82", hash_generated_field = "40EFB69E13F0CDEFCFD23CECDA09F21F")

    private int mGapStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.577 -0400", hash_original_field = "5A93D3E21E60377E98165B3EF2A06465", hash_generated_field = "A295E6D1722C924D1E523308C8F24CB5")

    private int mGapLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.577 -0400", hash_original_field = "B8BD6FDCBEDAFD097A52EBBE1CF0F79A", hash_generated_field = "64DC9467A0917D43133A286556BA813F")

    private Object[] mSpans;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.577 -0400", hash_original_field = "F1D8F8A94BA747744CA1C740BC88AFFE", hash_generated_field = "84CB203FE2C516ED9C3D0BE9F569E2FC")

    private int[] mSpanStarts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.577 -0400", hash_original_field = "644B4FD16A6F71B2ED6EADC13E20FB53", hash_generated_field = "B6B8A934A26F4A20670B5A234A93FAF3")

    private int[] mSpanEnds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.577 -0400", hash_original_field = "E9EBB0640FA76A599FDD30354136C22F", hash_generated_field = "F6EC87D3CD6571312E304AA9452368CA")

    private int[] mSpanFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.578 -0400", hash_original_field = "4FDCC29E70C8591103A1AD2BB2AC7494", hash_generated_field = "BDC8CC3C9B276345952883B6B6FC3B62")

    private int mSpanCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.578 -0400", hash_original_method = "FC61BFC3FC94A92F6E91F05B84386B00", hash_generated_method = "803E26A984ACC0C077D94CC677976F62")
    public  SpannableStringBuilder() {
        this("");
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.578 -0400", hash_original_method = "9676D8694A6D1EC55F8FB5E1D9DC6D95", hash_generated_method = "AD8306198DF2DA98740386F2F808A31C")
    public  SpannableStringBuilder(CharSequence text) {
        this(text, 0, text.length());
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.580 -0400", hash_original_method = "D35C3B0425645BAC16D8668E04F8F0BF", hash_generated_method = "07CF4C849CCF3ABB621F32E5FF76EFC7")
    public  SpannableStringBuilder(CharSequence text, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
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
    if(text instanceof Spanned)        
        {
            Spanned sp = (Spanned) text;
            Object[] spans = sp.getSpans(start, end, Object.class);
for(int i = 0;i < spans.length;i++)
            {
    if(spans[i] instanceof NoCopySpan)                
                {
                    continue;
                } //End block
                int st = sp.getSpanStart(spans[i]) - start;
                int en = sp.getSpanEnd(spans[i]) - start;
                int fl = sp.getSpanFlags(spans[i]);
    if(st < 0)                
                st = 0;
    if(st > end - start)                
                st = end - start;
    if(en < 0)                
                en = 0;
    if(en > end - start)                
                en = end - start;
                setSpan(spans[i], st, en, fl);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
    public static SpannableStringBuilder valueOf(CharSequence source) {
        if (source instanceof SpannableStringBuilder) {
            return (SpannableStringBuilder) source;
        } else {
            return new SpannableStringBuilder(source);
        }
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.581 -0400", hash_original_method = "8A39C40193810117501439EDABBFE6E5", hash_generated_method = "C6773A9D88526A9079C93D779B1D42F5")
    public char charAt(int where) {
        addTaint(where);
        int len = length();
    if(where < 0)        
        {
            IndexOutOfBoundsException var54E4BFC74A039A925476102C16B6F562_234947684 = new IndexOutOfBoundsException("charAt: " + where + " < 0");
            var54E4BFC74A039A925476102C16B6F562_234947684.addTaint(taint);
            throw var54E4BFC74A039A925476102C16B6F562_234947684;
        } //End block
        else
    if(where >= len)        
        {
            IndexOutOfBoundsException var43EB56BD312C0E1E6733C37325D3F68F_245520336 = new IndexOutOfBoundsException("charAt: " + where + " >= length " + len);
            var43EB56BD312C0E1E6733C37325D3F68F_245520336.addTaint(taint);
            throw var43EB56BD312C0E1E6733C37325D3F68F_245520336;
        } //End block
    if(where >= mGapStart)        
        {
        char var62FE44C4D973B3BD8881DFFF91E8881A_2144197515 = (mText[where + mGapLength]);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1650766044 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1650766044;
        }
        else
        {
        char varEAAA886097900318CA627D993B2DB070_1723986006 = (mText[where]);
                char varA87DEB01C5F539E6BDA34829C8EF2368_136495943 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_136495943;
        }
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.582 -0400", hash_original_method = "9A6AB9CE1EAE128DD9B2405D2B37CA46", hash_generated_method = "1A64E19C8C3C00062C078CA747F6D592")
    public int length() {
        int var2C4BFBCF410BA2E210B2E0118852F2AF_2060210814 = (mText.length - mGapLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_649594493 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_649594493;
        // ---------- Original Method ----------
        //return mText.length - mGapLength;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.583 -0400", hash_original_method = "976FC6C6553888C069C4B298C5B14B80", hash_generated_method = "ABC71638C5B05D420D85558094808313")
    private void resizeFor(int size) {
        addTaint(size);
        int newlen = ArrayUtils.idealCharArraySize(size + 1);
        char[] newtext = new char[newlen];
        int after = mText.length - (mGapStart + mGapLength);
        System.arraycopy(mText, 0, newtext, 0, mGapStart);
        System.arraycopy(mText, mText.length - after,
                         newtext, newlen - after, after);
for(int i = 0;i < mSpanCount;i++)
        {
    if(mSpanStarts[i] > mGapStart)            
            mSpanStarts[i] += newlen - mText.length;
    if(mSpanEnds[i] > mGapStart)            
            mSpanEnds[i] += newlen - mText.length;
        } //End block
        int oldlen = mText.length;
        mText = newtext;
        mGapLength += mText.length - oldlen;
    if(mGapLength < 1)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.584 -0400", hash_original_method = "D9447594759C2324F4C84ED525D8EBA8", hash_generated_method = "D40F08672CD90640C52E04713E74B5BB")
    private void moveGapTo(int where) {
    if(where == mGapStart)        
        return;
        boolean atend = (where == length());
    if(where < mGapStart)        
        {
            int overlap = mGapStart - where;
            System.arraycopy(mText, where,
                             mText, mGapStart + mGapLength - overlap, overlap);
        } //End block
        else
        {
            int overlap = where - mGapStart;
            System.arraycopy(mText, where + mGapLength - overlap,
                             mText, mGapStart, overlap);
        } //End block
for(int i = 0;i < mSpanCount;i++)
        {
            int start = mSpanStarts[i];
            int end = mSpanEnds[i];
    if(start > mGapStart)            
            start -= mGapLength;
    if(start > where)            
            start += mGapLength;
            else
    if(start == where)            
            {
                int flag = (mSpanFlags[i] & START_MASK) >> START_SHIFT;
    if(flag == POINT || (atend && flag == PARAGRAPH))                
                start += mGapLength;
            } //End block
    if(end > mGapStart)            
            end -= mGapLength;
    if(end > where)            
            end += mGapLength;
            else
    if(end == where)            
            {
                int flag = (mSpanFlags[i] & END_MASK);
    if(flag == POINT || (atend && flag == PARAGRAPH))                
                end += mGapLength;
            } //End block
            mSpanStarts[i] = start;
            mSpanEnds[i] = end;
        } //End block
        mGapStart = where;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.585 -0400", hash_original_method = "05B349B857A56AE010B814959800B44E", hash_generated_method = "EB2AD406DCD76096270CF76BBB96F54D")
    public SpannableStringBuilder insert(int where, CharSequence tb, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(tb.getTaint());
        addTaint(where);
SpannableStringBuilder var41D242ADE2AD7E7A80DC48DFDCDC3FCC_1978254480 =         replace(where, where, tb, start, end);
        var41D242ADE2AD7E7A80DC48DFDCDC3FCC_1978254480.addTaint(taint);
        return var41D242ADE2AD7E7A80DC48DFDCDC3FCC_1978254480;
        // ---------- Original Method ----------
        //return replace(where, where, tb, start, end);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.585 -0400", hash_original_method = "8FF3D73D08A9AFA2B9C652CF8F4F615D", hash_generated_method = "CF37E2E1C6D3A04748F703BB4507ECDE")
    public SpannableStringBuilder insert(int where, CharSequence tb) {
        addTaint(tb.getTaint());
        addTaint(where);
SpannableStringBuilder var4ED22CF6D7AE5966E4BDA5EEE43B1558_175534738 =         replace(where, where, tb, 0, tb.length());
        var4ED22CF6D7AE5966E4BDA5EEE43B1558_175534738.addTaint(taint);
        return var4ED22CF6D7AE5966E4BDA5EEE43B1558_175534738;
        // ---------- Original Method ----------
        //return replace(where, where, tb, 0, tb.length());
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.585 -0400", hash_original_method = "CCAFF8AC74D86E62008C289B374BD199", hash_generated_method = "BA01631F58FAD3343D89EE845C75D16A")
    public SpannableStringBuilder delete(int start, int end) {
        addTaint(end);
        addTaint(start);
        SpannableStringBuilder ret = replace(start, end, "", 0, 0);
    if(mGapLength > 2 * length())        
        resizeFor(length());
SpannableStringBuilder varEDFF4FBBF053B5DC2B444ADFA049EE0F_845614932 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_845614932.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_845614932;
        // ---------- Original Method ----------
        //SpannableStringBuilder ret = replace(start, end, "", 0, 0);
        //if (mGapLength > 2 * length())
            //resizeFor(length());
        //return ret;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.586 -0400", hash_original_method = "D18AC1E4EB05736F525932BC47697F9D", hash_generated_method = "2F4BCC7A2ECD16DA4BAF7CFF6AC91F91")
    public void clear() {
        replace(0, length(), "", 0, 0);
        // ---------- Original Method ----------
        //replace(0, length(), "", 0, 0);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.586 -0400", hash_original_method = "DCA8D2BE237B08ED7EF41B903E9CA024", hash_generated_method = "C1D721A8CEC54C7831D0A6D45FE9E7B8")
    public void clearSpans() {
for(int i = mSpanCount - 1;i >= 0;i--)
        {
            Object what = mSpans[i];
            int ostart = mSpanStarts[i];
            int oend = mSpanEnds[i];
    if(ostart > mGapStart)            
            ostart -= mGapLength;
    if(oend > mGapStart)            
            oend -= mGapLength;
            mSpanCount = i;
            mSpans[i] = null;
            sendSpanRemoved(what, ostart, oend);
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.587 -0400", hash_original_method = "A87DD944FE6567F6923432E1C1B56712", hash_generated_method = "859040533E51CF404EF2058368A753DF")
    public SpannableStringBuilder append(CharSequence text) {
        addTaint(text.getTaint());
        int length = length();
SpannableStringBuilder var2E3C07EA605400A15FA5FC136CF02BA5_1212344968 =         replace(length, length, text, 0, text.length());
        var2E3C07EA605400A15FA5FC136CF02BA5_1212344968.addTaint(taint);
        return var2E3C07EA605400A15FA5FC136CF02BA5_1212344968;
        // ---------- Original Method ----------
        //int length = length();
        //return replace(length, length, text, 0, text.length());
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.587 -0400", hash_original_method = "2E8C7D2887FD28E969B785C3CCFE69E2", hash_generated_method = "9983D2C775683C36B14D7188D451CA87")
    public SpannableStringBuilder append(CharSequence text, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        int length = length();
SpannableStringBuilder var9D6A0D74626153CB90F45DAD7166B52E_1996578004 =         replace(length, length, text, start, end);
        var9D6A0D74626153CB90F45DAD7166B52E_1996578004.addTaint(taint);
        return var9D6A0D74626153CB90F45DAD7166B52E_1996578004;
        // ---------- Original Method ----------
        //int length = length();
        //return replace(length, length, text, start, end);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.587 -0400", hash_original_method = "CAF0941E3E4124F46031A9B624CEE660", hash_generated_method = "7F6E6402803899CB55201A1302F422B6")
    public SpannableStringBuilder append(char text) {
        addTaint(text);
SpannableStringBuilder var948107AEA84D10D28C29B34B70DD7F4A_1394378597 =         append(String.valueOf(text));
        var948107AEA84D10D28C29B34B70DD7F4A_1394378597.addTaint(taint);
        return var948107AEA84D10D28C29B34B70DD7F4A_1394378597;
        // ---------- Original Method ----------
        //return append(String.valueOf(text));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.588 -0400", hash_original_method = "3C715BB6E3D7DD6490206A10C6A892D0", hash_generated_method = "9A8A6FDC86F7F856452C7322FB9514A5")
    private int change(int start, int end, CharSequence tb, int tbstart, int tbend) {
        addTaint(tbend);
        addTaint(tbstart);
        addTaint(tb.getTaint());
        addTaint(end);
        addTaint(start);
        int var6CABA8E11603F73EDF024BCF4294D2EF_1022337031 = (change(true, start, end, tb, tbstart, tbend));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827040211 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827040211;
        // ---------- Original Method ----------
        //return change(true, start, end, tb, tbstart, tbend);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.590 -0400", hash_original_method = "84DCE273834998C04B3160C57E76984B", hash_generated_method = "CF30EF44276170425BA4207AE47F242D")
    private int change(boolean notify, int start, int end,
                       CharSequence tb, int tbstart, int tbend) {
        addTaint(tbend);
        addTaint(tbstart);
        addTaint(tb.getTaint());
        addTaint(end);
        addTaint(notify);
        checkRange("replace", start, end);
        int ret = tbend - tbstart;
        TextWatcher[] recipients = null;
    if(notify)        
        {
            recipients = sendTextWillChange(start, end - start, tbend - tbstart);
        } //End block
for(int i = mSpanCount - 1;i >= 0;i--)
        {
    if((mSpanFlags[i] & SPAN_PARAGRAPH) == SPAN_PARAGRAPH)            
            {
                int st = mSpanStarts[i];
    if(st > mGapStart)                
                st -= mGapLength;
                int en = mSpanEnds[i];
    if(en > mGapStart)                
                en -= mGapLength;
                int ost = st;
                int oen = en;
                int clen = length();
    if(st > start && st <= end)                
                {
for(st = end;st < clen;st++)
    if(st > end && charAt(st - 1) == '\n')                    
                    break;
                } //End block
    if(en > start && en <= end)                
                {
for(en = end;en < clen;en++)
    if(en > end && charAt(en - 1) == '\n')                    
                    break;
                } //End block
    if(st != ost || en != oen)                
                setSpan(mSpans[i], st, en, mSpanFlags[i]);
            } //End block
        } //End block
        moveGapTo(end);
        final int nbNewChars = (tbend - tbstart) - (end - start);
    if(nbNewChars >= mGapLength)        
        {
            resizeFor(mText.length + nbNewChars - mGapLength);
        } //End block
        mGapStart += nbNewChars;
        mGapLength -= nbNewChars;
    if(mGapLength < 1)        
        new Exception("mGapLength < 1").printStackTrace();
        TextUtils.getChars(tb, tbstart, tbend, mText, start);
    if(tb instanceof Spanned)        
        {
            Spanned sp = (Spanned) tb;
            Object[] spans = sp.getSpans(tbstart, tbend, Object.class);
for(int i = 0;i < spans.length;i++)
            {
                int st = sp.getSpanStart(spans[i]);
                int en = sp.getSpanEnd(spans[i]);
    if(st < tbstart)                
                st = tbstart;
    if(en > tbend)                
                en = tbend;
    if(getSpanStart(spans[i]) < 0)                
                {
                    setSpan(false, spans[i],
                            st - tbstart + start,
                            en - tbstart + start,
                            sp.getSpanFlags(spans[i]));
                } //End block
            } //End block
        } //End block
    if(tbend > tbstart && end - start == 0)        
        {
    if(notify)            
            {
                sendTextChange(recipients, start, end - start, tbend - tbstart);
                sendTextHasChanged(recipients);
            } //End block
            int var2CB9DF9898E55FD0AD829DC202DDBD1C_1859434025 = (ret);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288017822 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288017822;
        } //End block
        boolean atend = (mGapStart + mGapLength == mText.length);
for(int i = mSpanCount - 1;i >= 0;i--)
        {
    if(mSpanStarts[i] >= start &&
                mSpanStarts[i] < mGapStart + mGapLength)            
            {
                int flag = (mSpanFlags[i] & START_MASK) >> START_SHIFT;
    if(flag == POINT || (flag == PARAGRAPH && atend))                
                mSpanStarts[i] = mGapStart + mGapLength;
                else
                mSpanStarts[i] = start;
            } //End block
    if(mSpanEnds[i] >= start &&
                mSpanEnds[i] < mGapStart + mGapLength)            
            {
                int flag = (mSpanFlags[i] & END_MASK);
    if(flag == POINT || (flag == PARAGRAPH && atend))                
                mSpanEnds[i] = mGapStart + mGapLength;
                else
                mSpanEnds[i] = start;
            } //End block
    if(mSpanEnds[i] < mSpanStarts[i])            
            {
                removeSpan(i);
            } //End block
        } //End block
    if(notify)        
        {
            sendTextChange(recipients, start, end - start, tbend - tbstart);
            sendTextHasChanged(recipients);
        } //End block
        int var2CB9DF9898E55FD0AD829DC202DDBD1C_250882043 = (ret);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1877717630 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1877717630;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.593 -0400", hash_original_method = "5F40E5580DD9B6C8070DDBE86036D0A0", hash_generated_method = "3904E8CC074BA2395C6B23B8BA449D70")
    private void removeSpan(int i) {
        addTaint(i);
        Object object = mSpans[i];
        int start = mSpanStarts[i];
        int end = mSpanEnds[i];
    if(start > mGapStart)        
        start -= mGapLength;
    if(end > mGapStart)        
        end -= mGapLength;
        int count = mSpanCount - (i + 1);
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.593 -0400", hash_original_method = "F007284EC0E266D0B466C6FB60440DED", hash_generated_method = "A1EA0AC2BFB6A8793BAE7FECBBDA0901")
    public SpannableStringBuilder replace(int start, int end, CharSequence tb) {
        addTaint(tb.getTaint());
        addTaint(end);
        addTaint(start);
SpannableStringBuilder var165DB2B44C34181CD22FCFB4EE83017A_1085088199 =         replace(start, end, tb, 0, tb.length());
        var165DB2B44C34181CD22FCFB4EE83017A_1085088199.addTaint(taint);
        return var165DB2B44C34181CD22FCFB4EE83017A_1085088199;
        // ---------- Original Method ----------
        //return replace(start, end, tb, 0, tb.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.595 -0400", hash_original_method = "653147CE10EC22F15BE8C423BD65FA32", hash_generated_method = "A8113400B0C7A1E6A764A001AFEE491E")
    public SpannableStringBuilder replace(final int start, final int end,
                        CharSequence tb, int tbstart, int tbend) {
        addTaint(tbend);
        addTaint(tbstart);
        addTaint(tb.getTaint());
        addTaint(end);
        addTaint(start);
        int filtercount = mFilters.length;
for(int i = 0;i < filtercount;i++)
        {
            CharSequence repl = mFilters[i].filter(tb, tbstart, tbend,
                                                   this, start, end);
    if(repl != null)            
            {
                tb = repl;
                tbstart = 0;
                tbend = repl.length();
            } //End block
        } //End block
    if(end == start && tbstart == tbend)        
        {
SpannableStringBuilder var72A74007B2BE62B849F475C7BDA4658B_1915363135 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1915363135.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1915363135;
        } //End block
    if(end == start || tbstart == tbend)        
        {
            change(start, end, tb, tbstart, tbend);
        } //End block
        else
        {
            int selstart = Selection.getSelectionStart(this);
            int selend = Selection.getSelectionEnd(this);
            checkRange("replace", start, end);
            moveGapTo(end);
            TextWatcher[] recipients;
            int origlen = end - start;
            recipients = sendTextWillChange(start, origlen, tbend - tbstart);
    if(mGapLength < 2)            
            resizeFor(length() + 1);
for(int i = mSpanCount - 1;i >= 0;i--)
            {
    if(mSpanStarts[i] == mGapStart)                
                mSpanStarts[i]++;
    if(mSpanEnds[i] == mGapStart)                
                mSpanEnds[i]++;
            } //End block
            mText[mGapStart] = ' ';
            mGapStart++;
            mGapLength--;
    if(mGapLength < 1)            
            {
                new Exception("mGapLength < 1").printStackTrace();
            } //End block
            int inserted = change(false, start + 1, start + 1, tb, tbstart, tbend);
            change(false, start, start + 1, "", 0, 0);
            change(false, start + inserted, start + inserted + origlen, "", 0, 0);
    if(selstart > start && selstart < end)            
            {
                long off = selstart - start;
                off = off * inserted / (end - start);
                selstart = (int) off + start;
                setSpan(false, Selection.SELECTION_START, selstart, selstart,
                        Spanned.SPAN_POINT_POINT);
            } //End block
    if(selend > start && selend < end)            
            {
                long off = selend - start;
                off = off * inserted / (end - start);
                selend = (int) off + start;
                setSpan(false, Selection.SELECTION_END, selend, selend, Spanned.SPAN_POINT_POINT);
            } //End block
            sendTextChange(recipients, start, origlen, inserted);
            sendTextHasChanged(recipients);
        } //End block
SpannableStringBuilder var72A74007B2BE62B849F475C7BDA4658B_904647022 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_904647022.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_904647022;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.596 -0400", hash_original_method = "69D700DE18AC29DD7D1DA7BDFB6B76AF", hash_generated_method = "2BA3F074FE8012811B3B9878FF5870AA")
    public void setSpan(Object what, int start, int end, int flags) {
        addTaint(flags);
        addTaint(end);
        addTaint(start);
        addTaint(what.getTaint());
        setSpan(true, what, start, end, flags);
        // ---------- Original Method ----------
        //setSpan(true, what, start, end, flags);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.598 -0400", hash_original_method = "2D459893E2DC729F5693ABCD511FCC18", hash_generated_method = "4AAD4D3B822FCEAFA1FEC267243C201A")
    private void setSpan(boolean send, Object what, int start, int end, int flags) {
        addTaint(send);
        int nstart = start;
        int nend = end;
        checkRange("setSpan", start, end);
    if((flags & START_MASK) == (PARAGRAPH << START_SHIFT))        
        {
    if(start != 0 && start != length())            
            {
                char c = charAt(start - 1);
    if(c != '\n')                
                {
                RuntimeException var3F7869BA442F6F56F7B20002FDD86347_1553609084 = new RuntimeException("PARAGRAPH span must start at paragraph boundary");
                var3F7869BA442F6F56F7B20002FDD86347_1553609084.addTaint(taint);
                throw var3F7869BA442F6F56F7B20002FDD86347_1553609084;
                }
            } //End block
        } //End block
    if((flags & END_MASK) == PARAGRAPH)        
        {
    if(end != 0 && end != length())            
            {
                char c = charAt(end - 1);
    if(c != '\n')                
                {
                RuntimeException var5AD33A975DAAB8EDAC93B3A27CD810C1_1635288757 = new RuntimeException("PARAGRAPH span must end at paragraph boundary");
                var5AD33A975DAAB8EDAC93B3A27CD810C1_1635288757.addTaint(taint);
                throw var5AD33A975DAAB8EDAC93B3A27CD810C1_1635288757;
                }
            } //End block
        } //End block
    if(start > mGapStart)        
        {
            start += mGapLength;
        } //End block
        else
    if(start == mGapStart)        
        {
            int flag = (flags & START_MASK) >> START_SHIFT;
    if(flag == POINT || (flag == PARAGRAPH && start == length()))            
            start += mGapLength;
        } //End block
    if(end > mGapStart)        
        {
            end += mGapLength;
        } //End block
        else
    if(end == mGapStart)        
        {
            int flag = (flags & END_MASK);
    if(flag == POINT || (flag == PARAGRAPH && end == length()))            
            end += mGapLength;
        } //End block
        int count = mSpanCount;
        Object[] spans = mSpans;
for(int i = 0;i < count;i++)
        {
    if(spans[i] == what)            
            {
                int ostart = mSpanStarts[i];
                int oend = mSpanEnds[i];
    if(ostart > mGapStart)                
                ostart -= mGapLength;
    if(oend > mGapStart)                
                oend -= mGapLength;
                mSpanStarts[i] = start;
                mSpanEnds[i] = end;
                mSpanFlags[i] = flags;
    if(send)                
                sendSpanChanged(what, ostart, oend, nstart, nend);
                return;
            } //End block
        } //End block
    if(mSpanCount + 1 >= mSpans.length)        
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
        mSpanCount++;
    if(send)        
        sendSpanAdded(what, nstart, nend);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.599 -0400", hash_original_method = "F7FA44646A47341A9BCB6EBFF8147DB3", hash_generated_method = "98F9C25D87A3EACE18844C813CFD4663")
    public void removeSpan(Object what) {
        addTaint(what.getTaint());
for(int i = mSpanCount - 1;i >= 0;i--)
        {
    if(mSpans[i] == what)            
            {
                removeSpan(i);
                return;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (int i = mSpanCount - 1; i >= 0; i--) {
            //if (mSpans[i] == what) {
                //removeSpan(i);
                //return;
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.600 -0400", hash_original_method = "DD4C166AC7D5C475EE46AC767DBD33EB", hash_generated_method = "09BD0CD0CDBA297D6879614E4519B79B")
    public int getSpanStart(Object what) {
        addTaint(what.getTaint());
        int count = mSpanCount;
        Object[] spans = mSpans;
for(int i = count - 1;i >= 0;i--)
        {
    if(spans[i] == what)            
            {
                int where = mSpanStarts[i];
    if(where > mGapStart)                
                where -= mGapLength;
                int var567904EFE9E64D9FAF3E41EF402CB568_570647236 = (where);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231524575 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231524575;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_519298872 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_784942271 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_784942271;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.600 -0400", hash_original_method = "1CAC5A6045B202B1FC928510B17AEEDD", hash_generated_method = "278352642FF4CF3EBC684CDAC0FA9F50")
    public int getSpanEnd(Object what) {
        addTaint(what.getTaint());
        int count = mSpanCount;
        Object[] spans = mSpans;
for(int i = count - 1;i >= 0;i--)
        {
    if(spans[i] == what)            
            {
                int where = mSpanEnds[i];
    if(where > mGapStart)                
                where -= mGapLength;
                int var567904EFE9E64D9FAF3E41EF402CB568_1330765420 = (where);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1065575544 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1065575544;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1472645347 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052943729 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052943729;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.601 -0400", hash_original_method = "DA0589F2510DDCCEED97B90C9189C1B9", hash_generated_method = "6D660BEA30E112075E900680011542D7")
    public int getSpanFlags(Object what) {
        addTaint(what.getTaint());
        int count = mSpanCount;
        Object[] spans = mSpans;
for(int i = count - 1;i >= 0;i--)
        {
    if(spans[i] == what)            
            {
                int varD469AB72FADB5E5CCBCA2CC605A22C75_753844571 = (mSpanFlags[i]);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1381283364 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1381283364;
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_30450608 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_57418309 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_57418309;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.604 -0400", hash_original_method = "5CF7F75C8FAF8266A003E04C7C47A211", hash_generated_method = "9C9BCFE22E9EE929617CA6ABC6C65E33")
    @SuppressWarnings("unchecked")
    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> kind) {
        addTaint(kind.getTaint());
        addTaint(queryEnd);
        addTaint(queryStart);
    if(kind == null)        
        {
T[] var9D4CC3533B24DD61A73D38EC233FFA92_240934844 =         ArrayUtils.emptyArray(kind);
        var9D4CC3533B24DD61A73D38EC233FFA92_240934844.addTaint(taint);
        return var9D4CC3533B24DD61A73D38EC233FFA92_240934844;
        }
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
for(int i = 0;i < spanCount;i++)
        {
            int spanStart = starts[i];
    if(spanStart > gapstart)            
            {
                spanStart -= gaplen;
            } //End block
    if(spanStart > queryEnd)            
            {
                continue;
            } //End block
            int spanEnd = ends[i];
    if(spanEnd > gapstart)            
            {
                spanEnd -= gaplen;
            } //End block
    if(spanEnd < queryStart)            
            {
                continue;
            } //End block
    if(spanStart != spanEnd && queryStart != queryEnd)            
            {
    if(spanStart == queryEnd)                
                continue;
    if(spanEnd == queryStart)                
                continue;
            } //End block
    if(!kind.isInstance(spans[i]))            
            continue;
    if(count == 0)            
            {
                ret1 = (T) spans[i];
                count++;
            } //End block
            else
            {
    if(count == 1)                
                {
                    ret = (T[]) Array.newInstance(kind, spanCount - i + 1);
                    ret[0] = ret1;
                } //End block
                int prio = flags[i] & SPAN_PRIORITY;
    if(prio != 0)                
                {
                    int j;
for(j = 0;j < count;j++)
                    {
                        int p = getSpanFlags(ret[j]) & SPAN_PRIORITY;
    if(prio > p)                        
                        {
                            break;
                        } //End block
                    } //End block
                    System.arraycopy(ret, j, ret, j + 1, count - j);
                    ret[j] = (T) spans[i];
                    count++;
                } //End block
                else
                {
                    ret[count++] = (T) spans[i];
                } //End block
            } //End block
        } //End block
    if(count == 0)        
        {
T[] var9D4CC3533B24DD61A73D38EC233FFA92_323972894 =             ArrayUtils.emptyArray(kind);
            var9D4CC3533B24DD61A73D38EC233FFA92_323972894.addTaint(taint);
            return var9D4CC3533B24DD61A73D38EC233FFA92_323972894;
        } //End block
    if(count == 1)        
        {
            ret = (T[]) Array.newInstance(kind, 1);
            ret[0] = ret1;
T[] varEDFF4FBBF053B5DC2B444ADFA049EE0F_293656940 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_293656940.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_293656940;
        } //End block
    if(count == ret.length)        
        {
T[] varEDFF4FBBF053B5DC2B444ADFA049EE0F_662030482 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_662030482.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_662030482;
        } //End block
        T[] nret = (T[]) Array.newInstance(kind, count);
        System.arraycopy(ret, 0, nret, 0, count);
T[] var785F7C6C4DBBD240B854AFDE8D881E30_1310711531 =         nret;
        var785F7C6C4DBBD240B854AFDE8D881E30_1310711531.addTaint(taint);
        return var785F7C6C4DBBD240B854AFDE8D881E30_1310711531;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.606 -0400", hash_original_method = "AC3B57A902A92307655B10B6A320F4FA", hash_generated_method = "ABAE5971B05FF1F634AA6A1DBB4BC9B2")
    public int nextSpanTransition(int start, int limit, Class kind) {
        addTaint(kind.getTaint());
        addTaint(limit);
        addTaint(start);
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] starts = mSpanStarts;
        int[] ends = mSpanEnds;
        int gapstart = mGapStart;
        int gaplen = mGapLength;
    if(kind == null)        
        {
            kind = Object.class;
        } //End block
for(int i = 0;i < count;i++)
        {
            int st = starts[i];
            int en = ends[i];
    if(st > gapstart)            
            st -= gaplen;
    if(en > gapstart)            
            en -= gaplen;
    if(st > start && st < limit && kind.isInstance(spans[i]))            
            limit = st;
    if(en > start && en < limit && kind.isInstance(spans[i]))            
            limit = en;
        } //End block
        int varAA9F73EEA60A006820D0F8768BC8A3FC_1926387408 = (limit);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1475945358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1475945358;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.607 -0400", hash_original_method = "31E22DABAC481CACAF1D07C50FD19E47", hash_generated_method = "9BC65AF028149349BF3A654A5A5E7045")
    public CharSequence subSequence(int start, int end) {
        addTaint(end);
        addTaint(start);
CharSequence varE6CF1225998C0A478543DEF9C9DC3DD0_1993080648 =         new SpannableStringBuilder(this, start, end);
        varE6CF1225998C0A478543DEF9C9DC3DD0_1993080648.addTaint(taint);
        return varE6CF1225998C0A478543DEF9C9DC3DD0_1993080648;
        // ---------- Original Method ----------
        //return new SpannableStringBuilder(this, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.607 -0400", hash_original_method = "063174DC666DF3AA6ABCE47B5208FD87", hash_generated_method = "7931FC2500638256E62D8E6CE17449A3")
    public void getChars(int start, int end, char[] dest, int destoff) {
        addTaint(destoff);
        addTaint(dest[0]);
        addTaint(end);
        addTaint(start);
        checkRange("getChars", start, end);
    if(end <= mGapStart)        
        {
            System.arraycopy(mText, start, dest, destoff, end - start);
        } //End block
        else
    if(start >= mGapStart)        
        {
            System.arraycopy(mText, start + mGapLength,
                             dest, destoff, end - start);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.607 -0400", hash_original_method = "4F74498D478E367DDE05120AE1CE9765", hash_generated_method = "2C83246E61F10CC3A116C5503FA9EA33")
    @Override
    public String toString() {
        int len = length();
        char[] buf = new char[len];
        getChars(0, len, buf, 0);
String var5B166C4D1D866639CF85033C2F7318C9_1608047585 =         new String(buf);
        var5B166C4D1D866639CF85033C2F7318C9_1608047585.addTaint(taint);
        return var5B166C4D1D866639CF85033C2F7318C9_1608047585;
        // ---------- Original Method ----------
        //int len = length();
        //char[] buf = new char[len];
        //getChars(0, len, buf, 0);
        //return new String(buf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.608 -0400", hash_original_method = "5E2755BFE298194FA4E39DBC872CF6D4", hash_generated_method = "C76F709B1AFB7E4C3E00807C1712A36C")
    public String substring(int start, int end) {
        addTaint(end);
        addTaint(start);
        char[] buf = new char[end - start];
        getChars(start, end, buf, 0);
String var5B166C4D1D866639CF85033C2F7318C9_1111504759 =         new String(buf);
        var5B166C4D1D866639CF85033C2F7318C9_1111504759.addTaint(taint);
        return var5B166C4D1D866639CF85033C2F7318C9_1111504759;
        // ---------- Original Method ----------
        //char[] buf = new char[end - start];
        //getChars(start, end, buf, 0);
        //return new String(buf);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.608 -0400", hash_original_method = "9EEE5F03C950DBDA8CD631C0E0A3B78A", hash_generated_method = "6EAA954486CE8E97EE7BFF10ED2F8E36")
    private TextWatcher[] sendTextWillChange(int start, int before, int after) {
        addTaint(after);
        addTaint(before);
        addTaint(start);
        TextWatcher[] recip = getSpans(start, start + before, TextWatcher.class);
        int n = recip.length;
for(int i = 0;i < n;i++)
        {
            recip[i].beforeTextChanged(this, start, before, after);
        } //End block
TextWatcher[] var256861F39217A53394A27A14BAF0B82C_757744130 =         recip;
        var256861F39217A53394A27A14BAF0B82C_757744130.addTaint(taint);
        return var256861F39217A53394A27A14BAF0B82C_757744130;
        // ---------- Original Method ----------
        //TextWatcher[] recip = getSpans(start, start + before, TextWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].beforeTextChanged(this, start, before, after);
        //}
        //return recip;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.608 -0400", hash_original_method = "B0F46C63F0D82B2972BAF2786F5024B6", hash_generated_method = "DA74610A2DF1A86B41528059BD128251")
    private void sendTextChange(TextWatcher[] recip, int start, int before, int after) {
        addTaint(after);
        addTaint(before);
        addTaint(start);
        addTaint(recip[0].getTaint());
        int n = recip.length;
for(int i = 0;i < n;i++)
        {
            recip[i].onTextChanged(this, start, before, after);
        } //End block
        // ---------- Original Method ----------
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onTextChanged(this, start, before, after);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.609 -0400", hash_original_method = "B7AEF4E180417D3A92FE965B8D29719A", hash_generated_method = "22A67500277FF537588AFC9A67F38B2A")
    private void sendTextHasChanged(TextWatcher[] recip) {
        addTaint(recip[0].getTaint());
        int n = recip.length;
for(int i = 0;i < n;i++)
        {
            recip[i].afterTextChanged(this);
        } //End block
        // ---------- Original Method ----------
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].afterTextChanged(this);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.609 -0400", hash_original_method = "39DD82D37A3679E95040612AC2A4CD5D", hash_generated_method = "1E35D62C71B86948A786160E0982AF79")
    private void sendSpanAdded(Object what, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(what.getTaint());
        SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        int n = recip.length;
for(int i = 0;i < n;i++)
        {
            recip[i].onSpanAdded(this, what, start, end);
        } //End block
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanAdded(this, what, start, end);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.609 -0400", hash_original_method = "8451F34A8F8537B6F36684962116E358", hash_generated_method = "A8970388E7A3F5075B44A78B96560743")
    private void sendSpanRemoved(Object what, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(what.getTaint());
        SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        int n = recip.length;
for(int i = 0;i < n;i++)
        {
            recip[i].onSpanRemoved(this, what, start, end);
        } //End block
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanRemoved(this, what, start, end);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.610 -0400", hash_original_method = "89C4871AB16E570ACF45A07B8EFEFB25", hash_generated_method = "EF48F9E333CA8CA535DD0D25CC7B92E9")
    private void sendSpanChanged(Object what, int s, int e, int st, int en) {
        addTaint(en);
        addTaint(st);
        addTaint(e);
        addTaint(s);
        addTaint(what.getTaint());
        SpanWatcher[] recip = getSpans(Math.min(s, st), Math.max(e, en), SpanWatcher.class);
        int n = recip.length;
for(int i = 0;i < n;i++)
        {
            recip[i].onSpanChanged(this, what, s, e, st, en);
        } //End block
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(Math.min(s, st), Math.max(e, en), SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanChanged(this, what, s, e, st, en);
        //}
    }

    
        @DSModeled(DSC.SPEC)
    private static String region(int start, int end) {
        return "(" + start + " ... " + end + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.610 -0400", hash_original_method = "70C480F1BBBBF461E174788F8B29326C", hash_generated_method = "2F74F715EA45A8DEF8610678F02C9C57")
    private void checkRange(final String operation, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(operation.getTaint());
    if(end < start)        
        {
            IndexOutOfBoundsException var0A76EA0A48ED6C51950B16720A582CC3_1917372797 = new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " has end before start");
            var0A76EA0A48ED6C51950B16720A582CC3_1917372797.addTaint(taint);
            throw var0A76EA0A48ED6C51950B16720A582CC3_1917372797;
        } //End block
        int len = length();
    if(start > len || end > len)        
        {
            IndexOutOfBoundsException varD58429F37119CB80293875D6807CEE60_1617174897 = new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " ends beyond length " + len);
            varD58429F37119CB80293875D6807CEE60_1617174897.addTaint(taint);
            throw varD58429F37119CB80293875D6807CEE60_1617174897;
        } //End block
    if(start < 0 || end < 0)        
        {
            IndexOutOfBoundsException varD13539DAB1C12D0F1B25FAC18E24F2A0_836815570 = new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " starts before 0");
            varD13539DAB1C12D0F1B25FAC18E24F2A0_836815570.addTaint(taint);
            throw varD13539DAB1C12D0F1B25FAC18E24F2A0_836815570;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.611 -0400", hash_original_method = "78639A54CC0D16962D9B6A20CA716009", hash_generated_method = "ABBE67FB2F20423433399FA26D8DBAEE")
    public void drawText(Canvas c, int start, int end,
                         float x, float y, Paint p) {
        addTaint(p.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(end);
        addTaint(start);
        addTaint(c.getTaint());
        checkRange("drawText", start, end);
    if(end <= mGapStart)        
        {
            c.drawText(mText, start, end - start, x, y, p);
        } //End block
        else
    if(start >= mGapStart)        
        {
            c.drawText(mText, start + mGapLength, end - start, x, y, p);
        } //End block
        else
        {
            char[] buf = TextUtils.obtain(end - start);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.612 -0400", hash_original_method = "623CEE9BFDFC43532CC6E8FD83D183BD", hash_generated_method = "5373101CF4B3DE5E4562A314F3FD0FE3")
    public void drawTextRun(Canvas c, int start, int end,
            int contextStart, int contextEnd,
            float x, float y, int flags, Paint p) {
        addTaint(p.getTaint());
        addTaint(flags);
        addTaint(y);
        addTaint(x);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(end);
        addTaint(start);
        addTaint(c.getTaint());
        checkRange("drawTextRun", start, end);
        int contextLen = contextEnd - contextStart;
        int len = end - start;
    if(contextEnd <= mGapStart)        
        {
            c.drawTextRun(mText, start, len, contextStart, contextLen, x, y, flags, p);
        } //End block
        else
    if(contextStart >= mGapStart)        
        {
            c.drawTextRun(mText, start + mGapLength, len, contextStart + mGapLength,
                    contextLen, x, y, flags, p);
        } //End block
        else
        {
            char[] buf = TextUtils.obtain(contextLen);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.613 -0400", hash_original_method = "5FD711D7C19B78DA72F1C64F29FD53D3", hash_generated_method = "F342EC3611C65805185F47BDB1781713")
    public float measureText(int start, int end, Paint p) {
        addTaint(p.getTaint());
        addTaint(end);
        addTaint(start);
        checkRange("measureText", start, end);
        float ret;
    if(end <= mGapStart)        
        {
            ret = p.measureText(mText, start, end - start);
        } //End block
        else
    if(start >= mGapStart)        
        {
            ret = p.measureText(mText, start + mGapLength, end - start);
        } //End block
        else
        {
            char[] buf = TextUtils.obtain(end - start);
            getChars(start, end, buf, 0);
            ret = p.measureText(buf, 0, end - start);
            TextUtils.recycle(buf);
        } //End block
        float var2CB9DF9898E55FD0AD829DC202DDBD1C_735164484 = (ret);
                float var546ADE640B6EDFBC8A086EF31347E768_1689826646 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1689826646;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.614 -0400", hash_original_method = "0B996033AABA85CCC99081E62BD26114", hash_generated_method = "28270484C47109444920B3FD48311F9E")
    public int getTextWidths(int start, int end, float[] widths, Paint p) {
        addTaint(p.getTaint());
        addTaint(widths[0]);
        addTaint(end);
        addTaint(start);
        checkRange("getTextWidths", start, end);
        int ret;
    if(end <= mGapStart)        
        {
            ret = p.getTextWidths(mText, start, end - start, widths);
        } //End block
        else
    if(start >= mGapStart)        
        {
            ret = p.getTextWidths(mText, start + mGapLength, end - start,
                                  widths);
        } //End block
        else
        {
            char[] buf = TextUtils.obtain(end - start);
            getChars(start, end, buf, 0);
            ret = p.getTextWidths(buf, 0, end - start, widths);
            TextUtils.recycle(buf);
        } //End block
        int var2CB9DF9898E55FD0AD829DC202DDBD1C_249184068 = (ret);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2049420759 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2049420759;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.615 -0400", hash_original_method = "FE2235DDEA2C6A2285ED2D1196CDD9B2", hash_generated_method = "EF0D57A641003E6273E17B28F8C5ADBF")
    public float getTextRunAdvances(int start, int end, int contextStart, int contextEnd, int flags,
            float[] advances, int advancesPos, Paint p) {
        addTaint(p.getTaint());
        addTaint(advancesPos);
        addTaint(advances[0]);
        addTaint(flags);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(end);
        addTaint(start);
        float ret;
        int contextLen = contextEnd - contextStart;
        int len = end - start;
    if(end <= mGapStart)        
        {
            ret = p.getTextRunAdvances(mText, start, len, contextStart, contextLen,
                    flags, advances, advancesPos);
        } //End block
        else
    if(start >= mGapStart)        
        {
            ret = p.getTextRunAdvances(mText, start + mGapLength, len,
                    contextStart + mGapLength, contextLen, flags, advances, advancesPos);
        } //End block
        else
        {
            char[] buf = TextUtils.obtain(contextLen);
            getChars(contextStart, contextEnd, buf, 0);
            ret = p.getTextRunAdvances(buf, start - contextStart, len,
                    0, contextLen, flags, advances, advancesPos);
            TextUtils.recycle(buf);
        } //End block
        float var2CB9DF9898E55FD0AD829DC202DDBD1C_174559719 = (ret);
                float var546ADE640B6EDFBC8A086EF31347E768_1249178781 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1249178781;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.616 -0400", hash_original_method = "C231D32FAB37A7BF2DFD000F849A602C", hash_generated_method = "BBD415CE94F1883544F52F74CF21B787")
    public float getTextRunAdvances(int start, int end, int contextStart, int contextEnd, int flags,
            float[] advances, int advancesPos, Paint p, int reserved) {
        addTaint(reserved);
        addTaint(p.getTaint());
        addTaint(advancesPos);
        addTaint(advances[0]);
        addTaint(flags);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(end);
        addTaint(start);
        float ret;
        int contextLen = contextEnd - contextStart;
        int len = end - start;
    if(end <= mGapStart)        
        {
            ret = p.getTextRunAdvances(mText, start, len, contextStart, contextLen,
                    flags, advances, advancesPos, reserved);
        } //End block
        else
    if(start >= mGapStart)        
        {
            ret = p.getTextRunAdvances(mText, start + mGapLength, len,
                    contextStart + mGapLength, contextLen, flags, advances, advancesPos, reserved);
        } //End block
        else
        {
            char[] buf = TextUtils.obtain(contextLen);
            getChars(contextStart, contextEnd, buf, 0);
            ret = p.getTextRunAdvances(buf, start - contextStart, len,
                    0, contextLen, flags, advances, advancesPos, reserved);
            TextUtils.recycle(buf);
        } //End block
        float var2CB9DF9898E55FD0AD829DC202DDBD1C_892397969 = (ret);
                float var546ADE640B6EDFBC8A086EF31347E768_543603598 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_543603598;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.617 -0400", hash_original_method = "ABDF9C9F21432D98EAA229A3E812D636", hash_generated_method = "9A8BBC4446D23B670C053265AE7CDF1B")
    @Deprecated
    public int getTextRunCursor(int contextStart, int contextEnd, int flags, int offset,
            int cursorOpt, Paint p) {
        addTaint(p.getTaint());
        addTaint(cursorOpt);
        addTaint(offset);
        addTaint(flags);
        addTaint(contextEnd);
        addTaint(contextStart);
        int ret;
        int contextLen = contextEnd - contextStart;
    if(contextEnd <= mGapStart)        
        {
            ret = p.getTextRunCursor(mText, contextStart, contextLen,
                    flags, offset, cursorOpt);
        } //End block
        else
    if(contextStart >= mGapStart)        
        {
            ret = p.getTextRunCursor(mText, contextStart + mGapLength, contextLen,
                    flags, offset + mGapLength, cursorOpt) - mGapLength;
        } //End block
        else
        {
            char[] buf = TextUtils.obtain(contextLen);
            getChars(contextStart, contextEnd, buf, 0);
            ret = p.getTextRunCursor(buf, 0, contextLen,
                    flags, offset - contextStart, cursorOpt) + contextStart;
            TextUtils.recycle(buf);
        } //End block
        int var2CB9DF9898E55FD0AD829DC202DDBD1C_1099133245 = (ret);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954631097 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954631097;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.617 -0400", hash_original_method = "43280B91F5BF9A1999DA6A7ED3115D4A", hash_generated_method = "C56445B149F6CA50A554B0AB7AF16DEA")
    public void setFilters(InputFilter[] filters) {
    if(filters == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_884052573 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_884052573.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_884052573;
        } //End block
        mFilters = filters;
        // ---------- Original Method ----------
        //if (filters == null) {
            //throw new IllegalArgumentException();
        //}
        //mFilters = filters;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.617 -0400", hash_original_method = "E0010D0DD1DD8F03E408AEE972028B3D", hash_generated_method = "D63F838F88C09CB090880F182FEDF357")
    public InputFilter[] getFilters() {
InputFilter[] var316611332C0E9FDC07189D6D7F9B848B_1842388220 =         mFilters;
        var316611332C0E9FDC07189D6D7F9B848B_1842388220.addTaint(taint);
        return var316611332C0E9FDC07189D6D7F9B848B_1842388220;
        // ---------- Original Method ----------
        //return mFilters;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.617 -0400", hash_original_field = "A0DA38A5AAD1658278F1D161AF84C1BC", hash_generated_field = "EDD7FE0B7D12EE9C3486272F367681B2")

    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.617 -0400", hash_original_field = "8E25CB8BBC7F057E695EB32AFA1A76C1", hash_generated_field = "C7F2D79B9AFA94FAA8193039FD601611")

    private static final int POINT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.617 -0400", hash_original_field = "01108F1ED53C20D4E3131B788368B220", hash_generated_field = "DAC314A52970829DE920414BCD420813")

    private static final int PARAGRAPH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.617 -0400", hash_original_field = "5CBC27631C132E42BC6EE2620FBE874C", hash_generated_field = "62F477B3AA465E1D6BB9002CA3207142")

    private static final int START_MASK = 0xF0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.617 -0400", hash_original_field = "A6B335A49CDCE8810689E33B5A49F35D", hash_generated_field = "DB23288AE0F2FDCBE5902F7D83D9C129")

    private static final int END_MASK = 0x0F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.617 -0400", hash_original_field = "408D27312BE6845294059D1D121D5FC2", hash_generated_field = "6EE5967CCE475609F69D5553B70E80C8")

    private static final int START_SHIFT = 4;
}

