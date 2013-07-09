package android.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.util.ArrayUtils;
import java.lang.reflect.Array;

abstract class SpannableStringInternal {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.508 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.508 -0400", hash_original_field = "B8BD6FDCBEDAFD097A52EBBE1CF0F79A", hash_generated_field = "64DC9467A0917D43133A286556BA813F")

    private Object[] mSpans;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.508 -0400", hash_original_field = "39084B7BB41D0E9E280EBBE232CDF089", hash_generated_field = "938E92621B3F4547B2C3C20B887698D5")

    private int[] mSpanData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.508 -0400", hash_original_field = "4FDCC29E70C8591103A1AD2BB2AC7494", hash_generated_field = "BDC8CC3C9B276345952883B6B6FC3B62")

    private int mSpanCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.509 -0400", hash_original_method = "6B8C85BD24C5FB6AAF3EB88754652005", hash_generated_method = "C07D593B2FE62EE899579A4A41C8BF68")
      SpannableStringInternal(CharSequence source,
                                          int start, int end) {
        {
            boolean var4E1087633C042E83FE4F92861C5B2DA8_174601993 = (start == 0 && end == source.length());
            mText = source.toString();
            mText = source.toString().substring(start, end);
        } 
        int initial = ArrayUtils.idealIntArraySize(0);
        mSpans = new Object[initial];
        mSpanData = new int[initial * 3];
        {
            Spanned sp = (Spanned) source;
            Object[] spans = sp.getSpans(start, end, Object.class);
            {
                int i = 0;
                {
                    int st = sp.getSpanStart(spans[i]);
                    int en = sp.getSpanEnd(spans[i]);
                    int fl = sp.getSpanFlags(spans[i]);
                    st = start;
                    en = end;
                    setSpan(spans[i], st - start, en - start, fl);
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.510 -0400", hash_original_method = "9A68249D01A4FE1CBD4D535668FCEB6F", hash_generated_method = "95B60D08A3293F8EFA0C368E932B2A2E")
    public final int length() {
        int var32A6F8CD5764B26A2339FAB65BD4098F_466736999 = (mText.length());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_713291172 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_713291172;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.510 -0400", hash_original_method = "9584624FC2131094C464C9F194744C46", hash_generated_method = "28059434E727589FF83D8A876D7B0A50")
    public final char charAt(int i) {
        char var2EAE77B7DE41F0E81C3AE4E49B8331B0_1957570093 = (mText.charAt(i));
        addTaint(i);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1211900409 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1211900409;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.511 -0400", hash_original_method = "F8827D354B3A7F2AC0C2613E8BEFB45B", hash_generated_method = "00C1E48C35F6D58A058D22132ED32B15")
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_547022905 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_547022905 = mText;
        varB4EAC82CA7396A68D541C85D26508E83_547022905.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_547022905;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.511 -0400", hash_original_method = "E3364302A15643D598F9B7C454DC0AA8", hash_generated_method = "8E7A93EE89948F5862C69A9D99BDDD65")
    public final void getChars(int start, int end, char[] dest, int off) {
        mText.getChars(start, end, dest, off);
        addTaint(start);
        addTaint(end);
        addTaint(dest[0]);
        addTaint(off);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.512 -0400", hash_original_method = "7B198AB61B6B726FF2E2996AF3FF95CD", hash_generated_method = "C58EE48B3ED660EDC5377FC02D97ABD2")
     void setSpan(Object what, int start, int end, int flags) {
        int nstart = start;
        int nend = end;
        checkRange("setSpan", start, end);
        {
            {
                boolean var50D67EA6491FC514B6D92D2E40689E61_1669087554 = (start != 0 && start != length());
                {
                    char c = charAt(start - 1);
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "PARAGRAPH span must start at paragraph boundary" +
                            " (" + start + " follows " + c + ")");
                } 
            } 
            {
                boolean var5B6CF9C5E41E159F793AF4E9C33451FF_234532523 = (end != 0 && end != length());
                {
                    char c = charAt(end - 1);
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "PARAGRAPH span must end at paragraph boundary" +
                            " (" + end + " follows " + c + ")");
                } 
            } 
        } 
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
        {
            int i = 0;
            {
                {
                    int ostart = data[i * COLUMNS + START];
                    int oend = data[i * COLUMNS + END];
                    data[i * COLUMNS + START] = start;
                    data[i * COLUMNS + END] = end;
                    data[i * COLUMNS + FLAGS] = flags;
                    sendSpanChanged(what, ostart, oend, nstart, nend);
                } 
            } 
        } 
        {
            int newsize = ArrayUtils.idealIntArraySize(mSpanCount + 1);
            Object[] newtags = new Object[newsize];
            int[] newdata = new int[newsize * 3];
            System.arraycopy(mSpans, 0, newtags, 0, mSpanCount);
            System.arraycopy(mSpanData, 0, newdata, 0, mSpanCount * 3);
            mSpans = newtags;
            mSpanData = newdata;
        } 
        mSpans[mSpanCount] = what;
        mSpanData[mSpanCount * COLUMNS + START] = start;
        mSpanData[mSpanCount * COLUMNS + END] = end;
        mSpanData[mSpanCount * COLUMNS + FLAGS] = flags;
        sendSpanAdded(what, nstart, nend);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.513 -0400", hash_original_method = "03C5B870069E116AF35881F1682BF48B", hash_generated_method = "D9A4FA4CA9787EE0203E05DA06517731")
     void removeSpan(Object what) {
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
        {
            int i = count - 1;
            {
                {
                    int ostart = data[i * COLUMNS + START];
                    int oend = data[i * COLUMNS + END];
                    int c = count - (i + 1);
                    System.arraycopy(spans, i + 1, spans, i, c);
                    System.arraycopy(data, (i + 1) * COLUMNS,
                                 data, i * COLUMNS, c * COLUMNS);
                    sendSpanRemoved(what, ostart, oend);
                } 
            } 
        } 
        addTaint(what.getTaint());
        
        
        
        
        
            
                
                
                
                
                
                                 
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.513 -0400", hash_original_method = "2C34546685C4DD853C66A09CEFBD0C65", hash_generated_method = "A5A248395CA5AA6D39623F42A8C7B602")
    public int getSpanStart(Object what) {
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
        {
            int i = count - 1;
        } 
        addTaint(what.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753914111 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753914111;
        
        
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.514 -0400", hash_original_method = "D299E1841C6A6AC66FA9181AA7F112ED", hash_generated_method = "2DCB7B0A0AC1063ED793E26668611A6C")
    public int getSpanEnd(Object what) {
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
        {
            int i = count - 1;
        } 
        addTaint(what.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1449645464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1449645464;
        
        
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.514 -0400", hash_original_method = "0BC2A6452DDDFB33D1E74093A43A22EC", hash_generated_method = "47628FF56FE29F7673B004C0FA40BFF7")
    public int getSpanFlags(Object what) {
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
        {
            int i = count - 1;
        } 
        addTaint(what.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215839108 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215839108;
        
        
        
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.516 -0400", hash_original_method = "A79E5C3938B902091EA5DB757C342E2D", hash_generated_method = "B2E71AD9802CCB43E7C69A8FC2F60B40")
    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> kind) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_953826290 = null; 
        T[] varB4EAC82CA7396A68D541C85D26508E83_1359601484 = null; 
        T[] varB4EAC82CA7396A68D541C85D26508E83_434528738 = null; 
        T[] varB4EAC82CA7396A68D541C85D26508E83_1737076893 = null; 
        int count = 0;
        int spanCount = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
        Object[] ret = null;
        Object ret1 = null;
        {
            int i = 0;
            {
                {
                    boolean var5A4064A3325AEA774EE2C4EF95F67A65_1004371108 = (kind != null && !kind.isInstance(spans[i]));
                } 
                int spanStart = data[i * COLUMNS + START];
                int spanEnd = data[i * COLUMNS + END];
                {
                    ret1 = spans[i];
                } 
                {
                    {
                        ret = (Object[]) Array.newInstance(kind, spanCount - i + 1);
                        ret[0] = ret1;
                    } 
                    int prio = data[i * COLUMNS + FLAGS] & Spanned.SPAN_PRIORITY;
                    {
                        int j;
                        {
                            j = 0;
                            {
                                int p = getSpanFlags(ret[j]) & Spanned.SPAN_PRIORITY;
                            } 
                        } 
                        System.arraycopy(ret, j, ret, j + 1, count - j);
                        ret[j] = spans[i];
                    } 
                    {
                        ret[count++] = spans[i];
                    } 
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_953826290 = (T[]) ArrayUtils.emptyArray(kind);
        } 
        {
            ret = (Object[]) Array.newInstance(kind, 1);
            ret[0] = ret1;
            varB4EAC82CA7396A68D541C85D26508E83_1359601484 = (T[]) ret;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_434528738 = (T[]) ret;
        } 
        Object[] nret = (Object[]) Array.newInstance(kind, count);
        System.arraycopy(ret, 0, nret, 0, count);
        varB4EAC82CA7396A68D541C85D26508E83_1737076893 = (T[]) nret;
        addTaint(queryStart);
        addTaint(queryEnd);
        addTaint(kind.getTaint());
        T[] varA7E53CE21691AB073D9660D615818899_1007545045; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1007545045 = varB4EAC82CA7396A68D541C85D26508E83_953826290;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1007545045 = varB4EAC82CA7396A68D541C85D26508E83_1359601484;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1007545045 = varB4EAC82CA7396A68D541C85D26508E83_434528738;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1007545045 = varB4EAC82CA7396A68D541C85D26508E83_1737076893;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1007545045.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1007545045;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.516 -0400", hash_original_method = "AE7B5CCE37B25ED0DAD474C110343705", hash_generated_method = "B55B0A38083A0FBCC18F1FDA689CD3B2")
    public int nextSpanTransition(int start, int limit, Class kind) {
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] data = mSpanData;
        {
            kind = Object.class;
        } 
        {
            int i = 0;
            {
                int st = data[i * COLUMNS + START];
                int en = data[i * COLUMNS + END];
                {
                    boolean varF6D66FD5D17035475727187422C2B841_1608884658 = (st > start && st < limit && kind.isInstance(spans[i]));
                    limit = st;
                } 
                {
                    boolean varDD4114CCD8FA698F5DA31E38C7560428_690123121 = (en > start && en < limit && kind.isInstance(spans[i]));
                    limit = en;
                } 
            } 
        } 
        addTaint(start);
        addTaint(limit);
        addTaint(kind.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696379156 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696379156;
        
        
        
        
        
            
        
        
            
            
            
                
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.517 -0400", hash_original_method = "AE5753E793A4485018C5FAB8D6A92DBC", hash_generated_method = "177FF102A3C0730ABD7BCD8DBD2AB16D")
    private void sendSpanAdded(Object what, int start, int end) {
        SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        int n = recip.length;
        {
            int i = 0;
            {
                recip[i].onSpanAdded((Spannable) this, what, start, end);
            } 
        } 
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.517 -0400", hash_original_method = "60A86A7ABB49125FA35263BF87AB59D6", hash_generated_method = "3CFCBE6D032BDAD4F4305586E2B6FB28")
    private void sendSpanRemoved(Object what, int start, int end) {
        SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        int n = recip.length;
        {
            int i = 0;
            {
                recip[i].onSpanRemoved((Spannable) this, what, start, end);
            } 
        } 
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.518 -0400", hash_original_method = "859EF27A1BB05860E7E5EF0EAB661D52", hash_generated_method = "314AE87D53AD7ACC6B2E249F8488BB2A")
    private void sendSpanChanged(Object what, int s, int e, int st, int en) {
        SpanWatcher[] recip = getSpans(Math.min(s, st), Math.max(e, en),
                                       SpanWatcher.class);
        int n = recip.length;
        {
            int i = 0;
            {
                recip[i].onSpanChanged((Spannable) this, what, s, e, st, en);
            } 
        } 
        addTaint(what.getTaint());
        addTaint(s);
        addTaint(e);
        addTaint(st);
        addTaint(en);
        
        
                                       
        
        
            
        
    }

    
    private static String region(int start, int end) {
        return "(" + start + " ... " + end + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.518 -0400", hash_original_method = "70C480F1BBBBF461E174788F8B29326C", hash_generated_method = "64FEF0522E1F30638ACC56806F86611A")
    private void checkRange(final String operation, int start, int end) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " has end before start");
        } 
        int len = length();
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " ends beyond length " + len);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " starts before 0");
        } 
        addTaint(operation.getTaint());
        addTaint(start);
        addTaint(end);
        
        
            
                                                
                                                
        
        
        
            
                                                
                                                
        
        
            
                                                
                                                
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.518 -0400", hash_original_field = "29B703ACBB9AD25AEF5009A0607792DF", hash_generated_field = "1908F7E294A3EABBA82B230EE13B1975")

    static final Object[] EMPTY = new Object[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.518 -0400", hash_original_field = "28651E175A74BF99AEB0613FFD9E4311", hash_generated_field = "D858CF53160507E553F41D31EE5B91B4")

    private static final int START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.518 -0400", hash_original_field = "94533C6AB91648145477E2B26E6ED259", hash_generated_field = "8419802F1C9707D8A0E8B46456CF017D")

    private static final int END = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.518 -0400", hash_original_field = "05041C87BF53DA30EC8A62B90D97ED7F", hash_generated_field = "AE684057078F2726E006BED2F46F1E81")

    private static final int FLAGS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.518 -0400", hash_original_field = "D8B6305C12C4CA4489AA48A1A8AE97DD", hash_generated_field = "A566B744E87F20E42BDCFABE418BC571")

    private static final int COLUMNS = 3;
}

