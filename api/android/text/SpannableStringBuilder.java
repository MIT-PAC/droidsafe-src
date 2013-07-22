package android.text;

// Droidsafe Imports
import java.lang.reflect.Array;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.android.internal.util.ArrayUtils;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SpannableStringBuilder implements CharSequence, GetChars, Spannable, Editable, Appendable, GraphicsOperations {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.003 -0400", hash_original_field = "8EF1F84508C44788B91A5266E4C71739", hash_generated_field = "489605ABB55A73F593690CC2882D1D5E")

    private InputFilter[] mFilters = NO_FILTERS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.003 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "6CB0C9E6186F94D00B15A6B38EEADB93")

    private char[] mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.003 -0400", hash_original_field = "E921ED8427024DA9A4D36EB8F6C8FE82", hash_generated_field = "40EFB69E13F0CDEFCFD23CECDA09F21F")

    private int mGapStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.003 -0400", hash_original_field = "5A93D3E21E60377E98165B3EF2A06465", hash_generated_field = "A295E6D1722C924D1E523308C8F24CB5")

    private int mGapLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.004 -0400", hash_original_field = "B8BD6FDCBEDAFD097A52EBBE1CF0F79A", hash_generated_field = "64DC9467A0917D43133A286556BA813F")

    private Object[] mSpans;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.004 -0400", hash_original_field = "F1D8F8A94BA747744CA1C740BC88AFFE", hash_generated_field = "84CB203FE2C516ED9C3D0BE9F569E2FC")

    private int[] mSpanStarts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.004 -0400", hash_original_field = "644B4FD16A6F71B2ED6EADC13E20FB53", hash_generated_field = "B6B8A934A26F4A20670B5A234A93FAF3")

    private int[] mSpanEnds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.004 -0400", hash_original_field = "E9EBB0640FA76A599FDD30354136C22F", hash_generated_field = "F6EC87D3CD6571312E304AA9452368CA")

    private int[] mSpanFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.004 -0400", hash_original_field = "4FDCC29E70C8591103A1AD2BB2AC7494", hash_generated_field = "BDC8CC3C9B276345952883B6B6FC3B62")

    private int mSpanCount;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.005 -0400", hash_original_method = "FC61BFC3FC94A92F6E91F05B84386B00", hash_generated_method = "803E26A984ACC0C077D94CC677976F62")
    public  SpannableStringBuilder() {
        this("");
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.005 -0400", hash_original_method = "9676D8694A6D1EC55F8FB5E1D9DC6D95", hash_generated_method = "AD8306198DF2DA98740386F2F808A31C")
    public  SpannableStringBuilder(CharSequence text) {
        this(text, 0, text.length());
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.006 -0400", hash_original_method = "D35C3B0425645BAC16D8668E04F8F0BF", hash_generated_method = "07CF4C849CCF3ABB621F32E5FF76EFC7")
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

    
    @DSModeled(DSC.SAFE)
    public static SpannableStringBuilder valueOf(CharSequence source) {
        if (source instanceof SpannableStringBuilder) {
            return (SpannableStringBuilder) source;
        } else {
            return new SpannableStringBuilder(source);
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.007 -0400", hash_original_method = "8A39C40193810117501439EDABBFE6E5", hash_generated_method = "E68FDEC677883A9494F89215BCDB1475")
    public char charAt(int where) {
        addTaint(where);
        int len = length();
        if(where < 0)        
        {
            IndexOutOfBoundsException var54E4BFC74A039A925476102C16B6F562_1568717182 = new IndexOutOfBoundsException("charAt: " + where + " < 0");
            var54E4BFC74A039A925476102C16B6F562_1568717182.addTaint(taint);
            throw var54E4BFC74A039A925476102C16B6F562_1568717182;
        } //End block
        else
        if(where >= len)        
        {
            IndexOutOfBoundsException var43EB56BD312C0E1E6733C37325D3F68F_1129511001 = new IndexOutOfBoundsException("charAt: " + where + " >= length " + len);
            var43EB56BD312C0E1E6733C37325D3F68F_1129511001.addTaint(taint);
            throw var43EB56BD312C0E1E6733C37325D3F68F_1129511001;
        } //End block
        if(where >= mGapStart)        
        {
        char var62FE44C4D973B3BD8881DFFF91E8881A_1473438405 = (mText[where + mGapLength]);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1142417592 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1142417592;
        }
        else
        {
        char varEAAA886097900318CA627D993B2DB070_1733634166 = (mText[where]);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1235761616 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1235761616;
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
    @Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.008 -0400", hash_original_method = "976FC6C6553888C069C4B298C5B14B80", hash_generated_method = "ABC71638C5B05D420D85558094808313")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.017 -0400", hash_original_method = "D9447594759C2324F4C84ED525D8EBA8", hash_generated_method = "D40F08672CD90640C52E04713E74B5BB")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.020 -0400", hash_original_method = "05B349B857A56AE010B814959800B44E", hash_generated_method = "1791FB8C81555E0E240C1A50D609BA6C")
    public SpannableStringBuilder insert(int where, CharSequence tb, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(tb.getTaint());
        addTaint(where);
SpannableStringBuilder var41D242ADE2AD7E7A80DC48DFDCDC3FCC_1233390686 =         replace(where, where, tb, start, end);
        var41D242ADE2AD7E7A80DC48DFDCDC3FCC_1233390686.addTaint(taint);
        return var41D242ADE2AD7E7A80DC48DFDCDC3FCC_1233390686;
        // ---------- Original Method ----------
        //return replace(where, where, tb, start, end);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.030 -0400", hash_original_method = "8FF3D73D08A9AFA2B9C652CF8F4F615D", hash_generated_method = "11A005413B45562247FDEC2B8B016864")
    public SpannableStringBuilder insert(int where, CharSequence tb) {
        addTaint(tb.getTaint());
        addTaint(where);
SpannableStringBuilder var4ED22CF6D7AE5966E4BDA5EEE43B1558_1882898207 =         replace(where, where, tb, 0, tb.length());
        var4ED22CF6D7AE5966E4BDA5EEE43B1558_1882898207.addTaint(taint);
        return var4ED22CF6D7AE5966E4BDA5EEE43B1558_1882898207;
        // ---------- Original Method ----------
        //return replace(where, where, tb, 0, tb.length());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.035 -0400", hash_original_method = "CCAFF8AC74D86E62008C289B374BD199", hash_generated_method = "B3401836EBE6FB7980D2D9F26D916B28")
    public SpannableStringBuilder delete(int start, int end) {
        addTaint(end);
        addTaint(start);
        SpannableStringBuilder ret = replace(start, end, "", 0, 0);
        if(mGapLength > 2 * length())        
        resizeFor(length());
SpannableStringBuilder varEDFF4FBBF053B5DC2B444ADFA049EE0F_1127717916 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_1127717916.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1127717916;
        // ---------- Original Method ----------
        //SpannableStringBuilder ret = replace(start, end, "", 0, 0);
        //if (mGapLength > 2 * length())
            //resizeFor(length());
        //return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @Override
	public void clear() {
		// TODO Auto-generated method stub
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public void clearSpans() {
		// TODO Auto-generated method stub
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public Editable append(CharSequence text) {
		// TODO Auto-generated method stub
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public Editable append(CharSequence text, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public Editable append(char text) {
		// TODO Auto-generated method stub
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.041 -0400", hash_original_method = "3C715BB6E3D7DD6490206A10C6A892D0", hash_generated_method = "C5009371D108C91CECBE90017DA69B70")
    private int change(int start, int end, CharSequence tb, int tbstart, int tbend) {
        addTaint(tbend);
        addTaint(tbstart);
        addTaint(tb.getTaint());
        addTaint(end);
        addTaint(start);
        int var6CABA8E11603F73EDF024BCF4294D2EF_265569261 = (change(true, start, end, tb, tbstart, tbend));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1468011257 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1468011257;
        // ---------- Original Method ----------
        //return change(true, start, end, tb, tbstart, tbend);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.043 -0400", hash_original_method = "84DCE273834998C04B3160C57E76984B", hash_generated_method = "3601D5C46E69C6BA5E3BF8D2122D75DF")
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
            int var2CB9DF9898E55FD0AD829DC202DDBD1C_1455367629 = (ret);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1256766683 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1256766683;
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
        int var2CB9DF9898E55FD0AD829DC202DDBD1C_1100463585 = (ret);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_94227179 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_94227179;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.044 -0400", hash_original_method = "5F40E5580DD9B6C8070DDBE86036D0A0", hash_generated_method = "3904E8CC074BA2395C6B23B8BA449D70")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.045 -0400", hash_original_method = "F007284EC0E266D0B466C6FB60440DED", hash_generated_method = "E77A2668D7BBB5B1C591AE8B6422F886")
    public SpannableStringBuilder replace(int start, int end, CharSequence tb) {
        addTaint(tb.getTaint());
        addTaint(end);
        addTaint(start);
SpannableStringBuilder var165DB2B44C34181CD22FCFB4EE83017A_321488211 =         replace(start, end, tb, 0, tb.length());
        var165DB2B44C34181CD22FCFB4EE83017A_321488211.addTaint(taint);
        return var165DB2B44C34181CD22FCFB4EE83017A_321488211;
        // ---------- Original Method ----------
        //return replace(start, end, tb, 0, tb.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.047 -0400", hash_original_method = "653147CE10EC22F15BE8C423BD65FA32", hash_generated_method = "620615D96DD63FC6AD3A04A78C30624D")
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
SpannableStringBuilder var72A74007B2BE62B849F475C7BDA4658B_530482815 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_530482815.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_530482815;
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
SpannableStringBuilder var72A74007B2BE62B849F475C7BDA4658B_595545462 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_595545462.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_595545462;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @Override
	public void setSpan(Object what, int start, int end, int flags) {
		// TODO Auto-generated method stub
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.049 -0400", hash_original_method = "2D459893E2DC729F5693ABCD511FCC18", hash_generated_method = "0ADC81260E4E3AD704D045ADB56C374F")
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
                RuntimeException var3F7869BA442F6F56F7B20002FDD86347_1712544775 = new RuntimeException("PARAGRAPH span must start at paragraph boundary");
                var3F7869BA442F6F56F7B20002FDD86347_1712544775.addTaint(taint);
                throw var3F7869BA442F6F56F7B20002FDD86347_1712544775;
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
                RuntimeException var5AD33A975DAAB8EDAC93B3A27CD810C1_1789609504 = new RuntimeException("PARAGRAPH span must end at paragraph boundary");
                var5AD33A975DAAB8EDAC93B3A27CD810C1_1789609504.addTaint(taint);
                throw var5AD33A975DAAB8EDAC93B3A27CD810C1_1789609504;
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

    
    @DSModeled(DSC.SAFE)
    @Override
	public void removeSpan(Object what) {
		// TODO Auto-generated method stub
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.050 -0400", hash_original_method = "DD4C166AC7D5C475EE46AC767DBD33EB", hash_generated_method = "4EB282B573FFA72A39499911541FE6BF")
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
                int var567904EFE9E64D9FAF3E41EF402CB568_659972729 = (where);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_423134411 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_423134411;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1584789029 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724519223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724519223;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.051 -0400", hash_original_method = "1CAC5A6045B202B1FC928510B17AEEDD", hash_generated_method = "BA682578536D27BEBA2DC1B273EAFDB6")
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
                int var567904EFE9E64D9FAF3E41EF402CB568_1054182287 = (where);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_106860785 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_106860785;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_317625369 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462407477 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462407477;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.052 -0400", hash_original_method = "DA0589F2510DDCCEED97B90C9189C1B9", hash_generated_method = "20265F8C43AD2F02B588259EB2A7D3B5")
    public int getSpanFlags(Object what) {
        addTaint(what.getTaint());
        int count = mSpanCount;
        Object[] spans = mSpans;
for(int i = count - 1;i >= 0;i--)
        {
            if(spans[i] == what)            
            {
                int varD469AB72FADB5E5CCBCA2CC605A22C75_1149699767 = (mSpanFlags[i]);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_239647282 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_239647282;
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_896617911 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422834381 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422834381;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.053 -0400", hash_original_method = "5CF7F75C8FAF8266A003E04C7C47A211", hash_generated_method = "F368E210A8A158B84C6EA5269A715CDD")
    @SuppressWarnings("unchecked")
    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> kind) {
        addTaint(kind.getTaint());
        addTaint(queryEnd);
        addTaint(queryStart);
        if(kind == null)        
        {
T[] var9D4CC3533B24DD61A73D38EC233FFA92_1168608204 =         ArrayUtils.emptyArray(kind);
        var9D4CC3533B24DD61A73D38EC233FFA92_1168608204.addTaint(taint);
        return var9D4CC3533B24DD61A73D38EC233FFA92_1168608204;
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
T[] var9D4CC3533B24DD61A73D38EC233FFA92_674511624 =             ArrayUtils.emptyArray(kind);
            var9D4CC3533B24DD61A73D38EC233FFA92_674511624.addTaint(taint);
            return var9D4CC3533B24DD61A73D38EC233FFA92_674511624;
        } //End block
        if(count == 1)        
        {
            ret = (T[]) Array.newInstance(kind, 1);
            ret[0] = ret1;
T[] varEDFF4FBBF053B5DC2B444ADFA049EE0F_2021125999 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_2021125999.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_2021125999;
        } //End block
        if(count == ret.length)        
        {
T[] varEDFF4FBBF053B5DC2B444ADFA049EE0F_1094619637 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_1094619637.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1094619637;
        } //End block
        T[] nret = (T[]) Array.newInstance(kind, count);
        System.arraycopy(ret, 0, nret, 0, count);
T[] var785F7C6C4DBBD240B854AFDE8D881E30_290589019 =         nret;
        var785F7C6C4DBBD240B854AFDE8D881E30_290589019.addTaint(taint);
        return var785F7C6C4DBBD240B854AFDE8D881E30_290589019;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.055 -0400", hash_original_method = "AC3B57A902A92307655B10B6A320F4FA", hash_generated_method = "40FF4AD119580F2818E3B2E977E6330A")
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
        int varAA9F73EEA60A006820D0F8768BC8A3FC_1532687111 = (limit);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238791581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238791581;
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

    
    @DSModeled(DSC.SAFE)
    @Override
	public CharSequence subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public void getChars(int start, int end, char[] dest, int destoff) {
		// TODO Auto-generated method stub
	}

    
    @Override
	@DSModeled(DSC.SAFE)
	public String toString() {
		return new String();
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.058 -0400", hash_original_method = "5E2755BFE298194FA4E39DBC872CF6D4", hash_generated_method = "36732AE1987B90C2B2080FD167BB3B97")
    public String substring(int start, int end) {
        addTaint(end);
        addTaint(start);
        char[] buf = new char[end - start];
        getChars(start, end, buf, 0);
String var5B166C4D1D866639CF85033C2F7318C9_1783438894 =         new String(buf);
        var5B166C4D1D866639CF85033C2F7318C9_1783438894.addTaint(taint);
        return var5B166C4D1D866639CF85033C2F7318C9_1783438894;
        // ---------- Original Method ----------
        //char[] buf = new char[end - start];
        //getChars(start, end, buf, 0);
        //return new String(buf);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.058 -0400", hash_original_method = "9EEE5F03C950DBDA8CD631C0E0A3B78A", hash_generated_method = "23D4469D2F04FAD486D58A76155BB802")
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
TextWatcher[] var256861F39217A53394A27A14BAF0B82C_383094911 =         recip;
        var256861F39217A53394A27A14BAF0B82C_383094911.addTaint(taint);
        return var256861F39217A53394A27A14BAF0B82C_383094911;
        // ---------- Original Method ----------
        //TextWatcher[] recip = getSpans(start, start + before, TextWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].beforeTextChanged(this, start, before, after);
        //}
        //return recip;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.059 -0400", hash_original_method = "B0F46C63F0D82B2972BAF2786F5024B6", hash_generated_method = "DA74610A2DF1A86B41528059BD128251")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.059 -0400", hash_original_method = "B7AEF4E180417D3A92FE965B8D29719A", hash_generated_method = "22A67500277FF537588AFC9A67F38B2A")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.060 -0400", hash_original_method = "39DD82D37A3679E95040612AC2A4CD5D", hash_generated_method = "1E35D62C71B86948A786160E0982AF79")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.060 -0400", hash_original_method = "8451F34A8F8537B6F36684962116E358", hash_generated_method = "A8970388E7A3F5075B44A78B96560743")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.061 -0400", hash_original_method = "89C4871AB16E570ACF45A07B8EFEFB25", hash_generated_method = "EF48F9E333CA8CA535DD0D25CC7B92E9")
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

    
    @DSModeled(DSC.SAFE)
    private static String region(int start, int end) {
        return "(" + start + " ... " + end + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.061 -0400", hash_original_method = "70C480F1BBBBF461E174788F8B29326C", hash_generated_method = "022913432A1F74C2286A47B790290993")
    private void checkRange(final String operation, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(operation.getTaint());
        if(end < start)        
        {
            IndexOutOfBoundsException var0A76EA0A48ED6C51950B16720A582CC3_304705242 = new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " has end before start");
            var0A76EA0A48ED6C51950B16720A582CC3_304705242.addTaint(taint);
            throw var0A76EA0A48ED6C51950B16720A582CC3_304705242;
        } //End block
        int len = length();
        if(start > len || end > len)        
        {
            IndexOutOfBoundsException varD58429F37119CB80293875D6807CEE60_926110100 = new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " ends beyond length " + len);
            varD58429F37119CB80293875D6807CEE60_926110100.addTaint(taint);
            throw varD58429F37119CB80293875D6807CEE60_926110100;
        } //End block
        if(start < 0 || end < 0)        
        {
            IndexOutOfBoundsException varD13539DAB1C12D0F1B25FAC18E24F2A0_1537997530 = new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " starts before 0");
            varD13539DAB1C12D0F1B25FAC18E24F2A0_1537997530.addTaint(taint);
            throw varD13539DAB1C12D0F1B25FAC18E24F2A0_1537997530;
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

    
    @DSModeled(DSC.SAFE)
    @Override
	public void drawText(Canvas c, int start, int end, float x, float y, Paint p) {
		// TODO Auto-generated method stub
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public void drawTextRun(Canvas c, int start, int end, int contextStart,
			int contextEnd, float x, float y, int flags, Paint p) {
		// TODO Auto-generated method stub
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public float measureText(int start, int end, Paint p) {
		// TODO Auto-generated method stub
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public int getTextWidths(int start, int end, float[] widths, Paint p) {
		// TODO Auto-generated method stub
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.072 -0400", hash_original_method = "FE2235DDEA2C6A2285ED2D1196CDD9B2", hash_generated_method = "3AAC571D07B0B0A24FFACA005E60140F")
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
        float var2CB9DF9898E55FD0AD829DC202DDBD1C_1612586614 = (ret);
                float var546ADE640B6EDFBC8A086EF31347E768_1814440145 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1814440145;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.072 -0400", hash_original_method = "C231D32FAB37A7BF2DFD000F849A602C", hash_generated_method = "316F2567E52C614B7BF3BEB2BAF65066")
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
        float var2CB9DF9898E55FD0AD829DC202DDBD1C_364554892 = (ret);
                float var546ADE640B6EDFBC8A086EF31347E768_992599261 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_992599261;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @Override
	public int getTextRunCursor(int contextStart, int contextEnd, int flags,
			int offset, int cursorOpt, Paint p) {
		// TODO Auto-generated method stub
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public void setFilters(InputFilter[] filters) {
		// TODO Auto-generated method stub
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public InputFilter[] getFilters() {
		// TODO Auto-generated method stub
		return null;
	}

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.075 -0400", hash_original_field = "A0DA38A5AAD1658278F1D161AF84C1BC", hash_generated_field = "EDD7FE0B7D12EE9C3486272F367681B2")

    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.075 -0400", hash_original_field = "8E25CB8BBC7F057E695EB32AFA1A76C1", hash_generated_field = "C7F2D79B9AFA94FAA8193039FD601611")

    private static final int POINT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.075 -0400", hash_original_field = "01108F1ED53C20D4E3131B788368B220", hash_generated_field = "DAC314A52970829DE920414BCD420813")

    private static final int PARAGRAPH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.075 -0400", hash_original_field = "5CBC27631C132E42BC6EE2620FBE874C", hash_generated_field = "62F477B3AA465E1D6BB9002CA3207142")

    private static final int START_MASK = 0xF0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.075 -0400", hash_original_field = "A6B335A49CDCE8810689E33B5A49F35D", hash_generated_field = "DB23288AE0F2FDCBE5902F7D83D9C129")

    private static final int END_MASK = 0x0F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.075 -0400", hash_original_field = "408D27312BE6845294059D1D121D5FC2", hash_generated_field = "6EE5967CCE475609F69D5553B70E80C8")

    private static final int START_SHIFT = 4;
    
    
}

