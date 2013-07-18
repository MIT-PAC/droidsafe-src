package android.text;

// Droidsafe Imports
import java.lang.reflect.Array;

import com.android.internal.util.ArrayUtils;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

abstract class SpannableStringInternal {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.784 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.784 -0400", hash_original_field = "B8BD6FDCBEDAFD097A52EBBE1CF0F79A", hash_generated_field = "64DC9467A0917D43133A286556BA813F")

    private Object[] mSpans;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.784 -0400", hash_original_field = "39084B7BB41D0E9E280EBBE232CDF089", hash_generated_field = "938E92621B3F4547B2C3C20B887698D5")

    private int[] mSpanData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.784 -0400", hash_original_field = "4FDCC29E70C8591103A1AD2BB2AC7494", hash_generated_field = "BDC8CC3C9B276345952883B6B6FC3B62")

    private int mSpanCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.785 -0400", hash_original_method = "6B8C85BD24C5FB6AAF3EB88754652005", hash_generated_method = "84D61665D5A0833C46D38731DB1B431B")
      SpannableStringInternal(CharSequence source,
                                          int start, int end) {
        if(start == 0 && end == source.length())        
        mText = source.toString();
        else
        mText = source.toString().substring(start, end);
        int initial = ArrayUtils.idealIntArraySize(0);
        mSpans = new Object[initial];
        mSpanData = new int[initial * 3];
        if(source instanceof Spanned)        
        {
            Spanned sp = (Spanned) source;
            Object[] spans = sp.getSpans(start, end, Object.class);
for(int i = 0;i < spans.length;i++)
            {
                int st = sp.getSpanStart(spans[i]);
                int en = sp.getSpanEnd(spans[i]);
                int fl = sp.getSpanFlags(spans[i]);
                if(st < start)                
                st = start;
                if(en > end)                
                en = end;
                setSpan(spans[i], st - start, en - start, fl);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.786 -0400", hash_original_method = "9A68249D01A4FE1CBD4D535668FCEB6F", hash_generated_method = "1A0800992B6856F6EB5673E82478F5A3")
    public final int length() {
        int varDC3F5DE2558DF3D25118F6362DE3EB1B_1491542506 = (mText.length());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_46193977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_46193977;
        // ---------- Original Method ----------
        //return mText.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.786 -0400", hash_original_method = "9584624FC2131094C464C9F194744C46", hash_generated_method = "ACB4934BB8FD094DABB437F015D7F024")
    public final char charAt(int i) {
        addTaint(i);
        char varB3CA569F165E0C73B6F01672D61D9642_183898700 = (mText.charAt(i));
                char varA87DEB01C5F539E6BDA34829C8EF2368_322575019 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_322575019;
        // ---------- Original Method ----------
        //return mText.charAt(i);
    }

    
    @DSModeled(DSC.SAFE)
	public final String toString() {
        return new String();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.787 -0400", hash_original_method = "E3364302A15643D598F9B7C454DC0AA8", hash_generated_method = "448040C1AC60C1A51BC220C0CB8E3C75")
    public final void getChars(int start, int end, char[] dest, int off) {
        addTaint(off);
        addTaint(dest[0]);
        addTaint(end);
        addTaint(start);
        mText.getChars(start, end, dest, off);
        // ---------- Original Method ----------
        //mText.getChars(start, end, dest, off);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.788 -0400", hash_original_method = "7B198AB61B6B726FF2E2996AF3FF95CD", hash_generated_method = "2E50A2E2CE91C9AEA665E507982EF6AF")
     void setSpan(Object what, int start, int end, int flags) {
        int nstart = start;
        int nend = end;
        checkRange("setSpan", start, end);
        if((flags & Spannable.SPAN_PARAGRAPH) == Spannable.SPAN_PARAGRAPH)        
        {
            if(start != 0 && start != length())            
            {
                char c = charAt(start - 1);
                if(c != '\n')                
                {
                RuntimeException var2A229F9AFF0C89140BABD24D2D46D889_385633542 = new RuntimeException(
                            "PARAGRAPH span must start at paragraph boundary" +
                            " (" + start + " follows " + c + ")");
                var2A229F9AFF0C89140BABD24D2D46D889_385633542.addTaint(taint);
                throw var2A229F9AFF0C89140BABD24D2D46D889_385633542;
                }
            } //End block
            if(end != 0 && end != length())            
            {
                char c = charAt(end - 1);
                if(c != '\n')                
                {
                RuntimeException var6D56B600862D5EE845FBA75F6411AE65_1283132808 = new RuntimeException(
                            "PARAGRAPH span must end at paragraph boundary" +
                            " (" + end + " follows " + c + ")");
                var6D56B600862D5EE845FBA75F6411AE65_1283132808.addTaint(taint);
                throw var6D56B600862D5EE845FBA75F6411AE65_1283132808;
                }
            } //End block
        } //End block
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
for(int i = 0;i < count;i++)
        {
            if(spans[i] == what)            
            {
                int ostart = data[i * COLUMNS + START];
                int oend = data[i * COLUMNS + END];
                data[i * COLUMNS + START] = start;
                data[i * COLUMNS + END] = end;
                data[i * COLUMNS + FLAGS] = flags;
                sendSpanChanged(what, ostart, oend, nstart, nend);
                return;
            } //End block
        } //End block
        if(mSpanCount + 1 >= mSpans.length)        
        {
            int newsize = ArrayUtils.idealIntArraySize(mSpanCount + 1);
            Object[] newtags = new Object[newsize];
            int[] newdata = new int[newsize * 3];
            System.arraycopy(mSpans, 0, newtags, 0, mSpanCount);
            System.arraycopy(mSpanData, 0, newdata, 0, mSpanCount * 3);
            mSpans = newtags;
            mSpanData = newdata;
        } //End block
        mSpans[mSpanCount] = what;
        mSpanData[mSpanCount * COLUMNS + START] = start;
        mSpanData[mSpanCount * COLUMNS + END] = end;
        mSpanData[mSpanCount * COLUMNS + FLAGS] = flags;
        mSpanCount++;
        if(this instanceof Spannable)        
        sendSpanAdded(what, nstart, nend);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.789 -0400", hash_original_method = "03C5B870069E116AF35881F1682BF48B", hash_generated_method = "E118E8AB7BC3606808A5EA7875B8BCD9")
     void removeSpan(Object what) {
        addTaint(what.getTaint());
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
for(int i = count - 1;i >= 0;i--)
        {
            if(spans[i] == what)            
            {
                int ostart = data[i * COLUMNS + START];
                int oend = data[i * COLUMNS + END];
                int c = count - (i + 1);
                System.arraycopy(spans, i + 1, spans, i, c);
                System.arraycopy(data, (i + 1) * COLUMNS,
                                 data, i * COLUMNS, c * COLUMNS);
                mSpanCount--;
                sendSpanRemoved(what, ostart, oend);
                return;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int count = mSpanCount;
        //Object[] spans = mSpans;
        //int[] data = mSpanData;
        //for (int i = count - 1; i >= 0; i--) {
            //if (spans[i] == what) {
                //int ostart = data[i * COLUMNS + START];
                //int oend = data[i * COLUMNS + END];
                //int c = count - (i + 1);
                //System.arraycopy(spans, i + 1, spans, i, c);
                //System.arraycopy(data, (i + 1) * COLUMNS,
                                 //data, i * COLUMNS, c * COLUMNS);
                //mSpanCount--;
                //sendSpanRemoved(what, ostart, oend);
                //return;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.789 -0400", hash_original_method = "2C34546685C4DD853C66A09CEFBD0C65", hash_generated_method = "89405B0CBDA2316C9697DF83EF470116")
    public int getSpanStart(Object what) {
        addTaint(what.getTaint());
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
for(int i = count - 1;i >= 0;i--)
        {
            if(spans[i] == what)            
            {
                int varF377C9413456093AE12A95281ECCF544_996545488 = (data[i * COLUMNS + START]);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_70811361 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_70811361;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_2026944111 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401445994 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401445994;
        // ---------- Original Method ----------
        //int count = mSpanCount;
        //Object[] spans = mSpans;
        //int[] data = mSpanData;
        //for (int i = count - 1; i >= 0; i--) {
            //if (spans[i] == what) {
                //return data[i * COLUMNS + START];
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.790 -0400", hash_original_method = "D299E1841C6A6AC66FA9181AA7F112ED", hash_generated_method = "0A7D716D73151429D899B79D7A01EDAB")
    public int getSpanEnd(Object what) {
        addTaint(what.getTaint());
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
for(int i = count - 1;i >= 0;i--)
        {
            if(spans[i] == what)            
            {
                int varB6D1E05B77F70E7B90C9A78947A136DB_1044307450 = (data[i * COLUMNS + END]);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_518389237 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_518389237;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_472103978 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076560775 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076560775;
        // ---------- Original Method ----------
        //int count = mSpanCount;
        //Object[] spans = mSpans;
        //int[] data = mSpanData;
        //for (int i = count - 1; i >= 0; i--) {
            //if (spans[i] == what) {
                //return data[i * COLUMNS + END];
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.791 -0400", hash_original_method = "0BC2A6452DDDFB33D1E74093A43A22EC", hash_generated_method = "F731A59B38CFA134671F9E1F0531CA3B")
    public int getSpanFlags(Object what) {
        addTaint(what.getTaint());
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
for(int i = count - 1;i >= 0;i--)
        {
            if(spans[i] == what)            
            {
                int var1EAC940D0BAE97B6358D4CB0A527BAB4_2001861419 = (data[i * COLUMNS + FLAGS]);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_511124851 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_511124851;
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_389742114 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729190150 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729190150;
        // ---------- Original Method ----------
        //int count = mSpanCount;
        //Object[] spans = mSpans;
        //int[] data = mSpanData;
        //for (int i = count - 1; i >= 0; i--) {
            //if (spans[i] == what) {
                //return data[i * COLUMNS + FLAGS];
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.792 -0400", hash_original_method = "A79E5C3938B902091EA5DB757C342E2D", hash_generated_method = "8B11A1D83B40723E850120BF22A1B3F9")
    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> kind) {
        addTaint(kind.getTaint());
        addTaint(queryEnd);
        addTaint(queryStart);
        int count = 0;
        int spanCount = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
        Object[] ret = null;
        Object ret1 = null;
for(int i = 0;i < spanCount;i++)
        {
            if(kind != null && !kind.isInstance(spans[i]))            
            {
                continue;
            } //End block
            int spanStart = data[i * COLUMNS + START];
            int spanEnd = data[i * COLUMNS + END];
            if(spanStart > queryEnd)            
            {
                continue;
            } //End block
            if(spanEnd < queryStart)            
            {
                continue;
            } //End block
            if(spanStart != spanEnd && queryStart != queryEnd)            
            {
                if(spanStart == queryEnd)                
                {
                    continue;
                } //End block
                if(spanEnd == queryStart)                
                {
                    continue;
                } //End block
            } //End block
            if(count == 0)            
            {
                ret1 = spans[i];
                count++;
            } //End block
            else
            {
                if(count == 1)                
                {
                    ret = (Object[]) Array.newInstance(kind, spanCount - i + 1);
                    ret[0] = ret1;
                } //End block
                int prio = data[i * COLUMNS + FLAGS] & Spanned.SPAN_PRIORITY;
                if(prio != 0)                
                {
                    int j;
for(j = 0;j < count;j++)
                    {
                        int p = getSpanFlags(ret[j]) & Spanned.SPAN_PRIORITY;
                        if(prio > p)                        
                        {
                            break;
                        } //End block
                    } //End block
                    System.arraycopy(ret, j, ret, j + 1, count - j);
                    ret[j] = spans[i];
                    count++;
                } //End block
                else
                {
                    ret[count++] = spans[i];
                } //End block
            } //End block
        } //End block
        if(count == 0)        
        {
T[] var2CE1F6B8DBEF82A682E5E21A4D0315D3_1058709778 =             (T[]) ArrayUtils.emptyArray(kind);
            var2CE1F6B8DBEF82A682E5E21A4D0315D3_1058709778.addTaint(taint);
            return var2CE1F6B8DBEF82A682E5E21A4D0315D3_1058709778;
        } //End block
        if(count == 1)        
        {
            ret = (Object[]) Array.newInstance(kind, 1);
            ret[0] = ret1;
T[] var110CDC22E76A3D741F90CE34DAD38798_138378504 =             (T[]) ret;
            var110CDC22E76A3D741F90CE34DAD38798_138378504.addTaint(taint);
            return var110CDC22E76A3D741F90CE34DAD38798_138378504;
        } //End block
        if(count == ret.length)        
        {
T[] var110CDC22E76A3D741F90CE34DAD38798_1848989534 =             (T[]) ret;
            var110CDC22E76A3D741F90CE34DAD38798_1848989534.addTaint(taint);
            return var110CDC22E76A3D741F90CE34DAD38798_1848989534;
        } //End block
        Object[] nret = (Object[]) Array.newInstance(kind, count);
        System.arraycopy(ret, 0, nret, 0, count);
T[] varC2D15B14AC552DB2CA74824AA0037754_1920914000 =         (T[]) nret;
        varC2D15B14AC552DB2CA74824AA0037754_1920914000.addTaint(taint);
        return varC2D15B14AC552DB2CA74824AA0037754_1920914000;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.793 -0400", hash_original_method = "AE7B5CCE37B25ED0DAD474C110343705", hash_generated_method = "FEC1049F6862D4167EB0D60F3453C24B")
    public int nextSpanTransition(int start, int limit, Class kind) {
        addTaint(kind.getTaint());
        addTaint(limit);
        addTaint(start);
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
        if(kind == null)        
        {
            kind = Object.class;
        } //End block
for(int i = 0;i < count;i++)
        {
            int st = data[i * COLUMNS + START];
            int en = data[i * COLUMNS + END];
            if(st > start && st < limit && kind.isInstance(spans[i]))            
            limit = st;
            if(en > start && en < limit && kind.isInstance(spans[i]))            
            limit = en;
        } //End block
        int varAA9F73EEA60A006820D0F8768BC8A3FC_535923271 = (limit);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055000158 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055000158;
        // ---------- Original Method ----------
        //int count = mSpanCount;
        //Object[] spans = mSpans;
        //int[] data = mSpanData;
        //if (kind == null) {
            //kind = Object.class;
        //}
        //for (int i = 0; i < count; i++) {
            //int st = data[i * COLUMNS + START];
            //int en = data[i * COLUMNS + END];
            //if (st > start && st < limit && kind.isInstance(spans[i]))
                //limit = st;
            //if (en > start && en < limit && kind.isInstance(spans[i]))
                //limit = en;
        //}
        //return limit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.793 -0400", hash_original_method = "AE5753E793A4485018C5FAB8D6A92DBC", hash_generated_method = "E3FED9D828B8C60E350C18074421AE2E")
    private void sendSpanAdded(Object what, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(what.getTaint());
        SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        int n = recip.length;
for(int i = 0;i < n;i++)
        {
            recip[i].onSpanAdded((Spannable) this, what, start, end);
        } //End block
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanAdded((Spannable) this, what, start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.793 -0400", hash_original_method = "60A86A7ABB49125FA35263BF87AB59D6", hash_generated_method = "2FA99781654342E619A8954DE98C0A4B")
    private void sendSpanRemoved(Object what, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(what.getTaint());
        SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        int n = recip.length;
for(int i = 0;i < n;i++)
        {
            recip[i].onSpanRemoved((Spannable) this, what, start, end);
        } //End block
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanRemoved((Spannable) this, what, start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.794 -0400", hash_original_method = "859EF27A1BB05860E7E5EF0EAB661D52", hash_generated_method = "18D2923662B1F7267D9A8F9A1863BDD0")
    private void sendSpanChanged(Object what, int s, int e, int st, int en) {
        addTaint(en);
        addTaint(st);
        addTaint(e);
        addTaint(s);
        addTaint(what.getTaint());
        SpanWatcher[] recip = getSpans(Math.min(s, st), Math.max(e, en),
                                       SpanWatcher.class);
        int n = recip.length;
for(int i = 0;i < n;i++)
        {
            recip[i].onSpanChanged((Spannable) this, what, s, e, st, en);
        } //End block
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(Math.min(s, st), Math.max(e, en),
                                       //SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanChanged((Spannable) this, what, s, e, st, en);
        //}
    }

    
    private static String region(int start, int end) {
        return "(" + start + " ... " + end + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.795 -0400", hash_original_method = "70C480F1BBBBF461E174788F8B29326C", hash_generated_method = "F609E9A81979A453320EEBBDA4D93A10")
    private void checkRange(final String operation, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(operation.getTaint());
        if(end < start)        
        {
            IndexOutOfBoundsException var0A76EA0A48ED6C51950B16720A582CC3_538395407 = new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " has end before start");
            var0A76EA0A48ED6C51950B16720A582CC3_538395407.addTaint(taint);
            throw var0A76EA0A48ED6C51950B16720A582CC3_538395407;
        } //End block
        int len = length();
        if(start > len || end > len)        
        {
            IndexOutOfBoundsException varD58429F37119CB80293875D6807CEE60_490060706 = new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " ends beyond length " + len);
            varD58429F37119CB80293875D6807CEE60_490060706.addTaint(taint);
            throw varD58429F37119CB80293875D6807CEE60_490060706;
        } //End block
        if(start < 0 || end < 0)        
        {
            IndexOutOfBoundsException varD13539DAB1C12D0F1B25FAC18E24F2A0_11918020 = new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " starts before 0");
            varD13539DAB1C12D0F1B25FAC18E24F2A0_11918020.addTaint(taint);
            throw varD13539DAB1C12D0F1B25FAC18E24F2A0_11918020;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.795 -0400", hash_original_field = "29B703ACBB9AD25AEF5009A0607792DF", hash_generated_field = "1908F7E294A3EABBA82B230EE13B1975")

    static final Object[] EMPTY = new Object[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.795 -0400", hash_original_field = "28651E175A74BF99AEB0613FFD9E4311", hash_generated_field = "D858CF53160507E553F41D31EE5B91B4")

    private static final int START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.795 -0400", hash_original_field = "94533C6AB91648145477E2B26E6ED259", hash_generated_field = "8419802F1C9707D8A0E8B46456CF017D")

    private static final int END = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.795 -0400", hash_original_field = "05041C87BF53DA30EC8A62B90D97ED7F", hash_generated_field = "AE684057078F2726E006BED2F46F1E81")

    private static final int FLAGS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:37.795 -0400", hash_original_field = "D8B6305C12C4CA4489AA48A1A8AE97DD", hash_generated_field = "A566B744E87F20E42BDCFABE418BC571")

    private static final int COLUMNS = 3;
}

