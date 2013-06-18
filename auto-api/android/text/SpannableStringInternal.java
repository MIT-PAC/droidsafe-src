package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;
import java.lang.reflect.Array;

abstract class SpannableStringInternal {
    private String mText;
    private Object[] mSpans;
    private int[] mSpanData;
    private int mSpanCount;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.361 -0400", hash_original_method = "6B8C85BD24C5FB6AAF3EB88754652005", hash_generated_method = "23B0B730F9F49D8A5EC734EEDEDB87F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @DSModeled(DSC.SPEC)
     SpannableStringInternal(CharSequence source,
                                          int start, int end) {
        dsTaint.addTaint(source);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            boolean var4E1087633C042E83FE4F92861C5B2DA8_195614042 = (start == 0 && end == source.length());
            mText = source.toString();
            mText = source.toString().substring(start, end);
        } //End collapsed parenthetic
        int initial;
        initial = ArrayUtils.idealIntArraySize(0);
        mSpans = new Object[initial];
        mSpanData = new int[initial * 3];
        {
            Spanned sp;
            sp = (Spanned) source;
            Object[] spans;
            spans = sp.getSpans(start, end, Object.class);
            {
                int i;
                i = 0;
                {
                    int st;
                    st = sp.getSpanStart(spans[i]);
                    int en;
                    en = sp.getSpanEnd(spans[i]);
                    int fl;
                    fl = sp.getSpanFlags(spans[i]);
                    st = start;
                    en = end;
                    setSpan(spans[i], st - start, en - start, fl);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.406 -0400", hash_original_method = "9A68249D01A4FE1CBD4D535668FCEB6F", hash_generated_method = "9EF56783CE94C00E245FD22F956F6202")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @DSModeled(DSC.SPEC)
    public final int length() {
        int var32A6F8CD5764B26A2339FAB65BD4098F_1901536931 = (mText.length());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mText.length();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.421 -0400", hash_original_method = "9584624FC2131094C464C9F194744C46", hash_generated_method = "A72ED0EF4EA462B35E6D4080FF532602")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @DSModeled(DSC.SPEC)
    public final char charAt(int i) {
        dsTaint.addTaint(i);
        char var2EAE77B7DE41F0E81C3AE4E49B8331B0_1226360723 = (mText.charAt(i));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return mText.charAt(i);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.434 -0400", hash_original_method = "F8827D354B3A7F2AC0C2613E8BEFB45B", hash_generated_method = "F66BC84702C0399331D9E6588C6F0C75")
    @DSModeled(DSC.SAFE)
    public final String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mText;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.494 -0400", hash_original_method = "E3364302A15643D598F9B7C454DC0AA8", hash_generated_method = "FF314B901E04923E83F1C21D971E9E7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @DSModeled(DSC.SPEC)
    public final void getChars(int start, int end, char[] dest, int off) {
        dsTaint.addTaint(dest[0]);
        dsTaint.addTaint(start);
        dsTaint.addTaint(off);
        dsTaint.addTaint(end);
        mText.getChars(start, end, dest, off);
        // ---------- Original Method ----------
        //mText.getChars(start, end, dest, off);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.593 -0400", hash_original_method = "7B198AB61B6B726FF2E2996AF3FF95CD", hash_generated_method = "D5F4077485230AF17EBD311AD0290C74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setSpan(Object what, int start, int end, int flags) {
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
                boolean var50D67EA6491FC514B6D92D2E40689E61_1389253327 = (start != 0 && start != length());
                {
                    char c;
                    c = charAt(start - 1);
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "PARAGRAPH span must start at paragraph boundary" +
                            " (" + start + " follows " + c + ")");
                } //End block
            } //End collapsed parenthetic
            {
                boolean var5B6CF9C5E41E159F793AF4E9C33451FF_171090935 = (end != 0 && end != length());
                {
                    char c;
                    c = charAt(end - 1);
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "PARAGRAPH span must end at paragraph boundary" +
                            " (" + end + " follows " + c + ")");
                } //End block
            } //End collapsed parenthetic
        } //End block
        int count;
        count = mSpanCount;
        Object[] spans;
        spans = mSpans;
        int[] data;
        data = mSpanData;
        {
            int i;
            i = 0;
            {
                {
                    int ostart;
                    ostart = data[i * COLUMNS + START];
                    int oend;
                    oend = data[i * COLUMNS + END];
                    data[i * COLUMNS + START] = start;
                    data[i * COLUMNS + END] = end;
                    data[i * COLUMNS + FLAGS] = flags;
                    sendSpanChanged(what, ostart, oend, nstart, nend);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            int newsize;
            newsize = ArrayUtils.idealIntArraySize(mSpanCount + 1);
            Object[] newtags;
            newtags = new Object[newsize];
            int[] newdata;
            newdata = new int[newsize * 3];
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
        sendSpanAdded(what, nstart, nend);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.639 -0400", hash_original_method = "03C5B870069E116AF35881F1682BF48B", hash_generated_method = "45974FB198D98D55D83354C6CE66C018")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @DSModeled(DSC.SAFE)
     void removeSpan(Object what) {
        dsTaint.addTaint(what.dsTaint);
        int count;
        count = mSpanCount;
        Object[] spans;
        spans = mSpans;
        int[] data;
        data = mSpanData;
        {
            int i;
            i = count - 1;
            {
                {
                    int ostart;
                    ostart = data[i * COLUMNS + START];
                    int oend;
                    oend = data[i * COLUMNS + END];
                    int c;
                    c = count - (i + 1);
                    System.arraycopy(spans, i + 1, spans, i, c);
                    System.arraycopy(data, (i + 1) * COLUMNS,
                                 data, i * COLUMNS, c * COLUMNS);
                    mSpanCount--;
                    sendSpanRemoved(what, ostart, oend);
                } //End block
            } //End block
        } //End collapsed parenthetic
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.690 -0400", hash_original_method = "2C34546685C4DD853C66A09CEFBD0C65", hash_generated_method = "F3A4B65ED5BC888917F93E6F7AF22F9C")
    @DSModeled(DSC.SAFE)
    public int getSpanStart(Object what) {
        dsTaint.addTaint(what.dsTaint);
        int count;
        count = mSpanCount;
        Object[] spans;
        spans = mSpans;
        int[] data;
        data = mSpanData;
        {
            int i;
            i = count - 1;
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.710 -0400", hash_original_method = "D299E1841C6A6AC66FA9181AA7F112ED", hash_generated_method = "66F27705B033FE8482592B4736F84E45")
    @DSModeled(DSC.SAFE)
    public int getSpanEnd(Object what) {
        dsTaint.addTaint(what.dsTaint);
        int count;
        count = mSpanCount;
        Object[] spans;
        spans = mSpans;
        int[] data;
        data = mSpanData;
        {
            int i;
            i = count - 1;
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.730 -0400", hash_original_method = "0BC2A6452DDDFB33D1E74093A43A22EC", hash_generated_method = "6ED4AAFDD8501DD734CE4515AFD35F9E")
    @DSModeled(DSC.SAFE)
    public int getSpanFlags(Object what) {
        dsTaint.addTaint(what.dsTaint);
        int count;
        count = mSpanCount;
        Object[] spans;
        spans = mSpans;
        int[] data;
        data = mSpanData;
        {
            int i;
            i = count - 1;
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.821 -0400", hash_original_method = "A79E5C3938B902091EA5DB757C342E2D", hash_generated_method = "61AD7C61D4160B1124F6A1EF2CECC3F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @DSModeled(DSC.SPEC)
    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> kind) {
        dsTaint.addTaint(queryStart);
        dsTaint.addTaint(queryEnd);
        dsTaint.addTaint(kind.dsTaint);
        int count;
        count = 0;
        int spanCount;
        spanCount = mSpanCount;
        Object[] spans;
        spans = mSpans;
        int[] data;
        data = mSpanData;
        Object[] ret;
        ret = null;
        Object ret1;
        ret1 = null;
        {
            int i;
            i = 0;
            {
                {
                    boolean var5A4064A3325AEA774EE2C4EF95F67A65_1393794319 = (kind != null && !kind.isInstance(spans[i]));
                } //End collapsed parenthetic
                int spanStart;
                spanStart = data[i * COLUMNS + START];
                int spanEnd;
                spanEnd = data[i * COLUMNS + END];
                {
                    ret1 = spans[i];
                    count++;
                } //End block
                {
                    {
                        ret = (Object[]) Array.newInstance(kind, spanCount - i + 1);
                        ret[0] = ret1;
                    } //End block
                    int prio;
                    prio = data[i * COLUMNS + FLAGS] & Spanned.SPAN_PRIORITY;
                    {
                        int j;
                        {
                            j = 0;
                            {
                                int p;
                                p = getSpanFlags(ret[j]) & Spanned.SPAN_PRIORITY;
                            } //End block
                        } //End collapsed parenthetic
                        System.arraycopy(ret, j, ret, j + 1, count - j);
                        ret[j] = spans[i];
                        count++;
                    } //End block
                    {
                        ret[count++] = spans[i];
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            T[] varF5CEA0B9531CC419B1DEECCBE497E47B_1464212288 = ((T[]) ArrayUtils.emptyArray(kind));
        } //End block
        {
            ret = (Object[]) Array.newInstance(kind, 1);
            ret[0] = ret1;
        } //End block
        Object[] nret;
        nret = (Object[]) Array.newInstance(kind, count);
        System.arraycopy(ret, 0, nret, 0, count);
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.891 -0400", hash_original_method = "AE7B5CCE37B25ED0DAD474C110343705", hash_generated_method = "F26B188F0C250E7D711549B85556BEDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @DSModeled(DSC.SPEC)
    public int nextSpanTransition(int start, int limit, Class kind) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(start);
        dsTaint.addTaint(kind.dsTaint);
        int count;
        count = mSpanCount;
        Object[] spans;
        spans = mSpans;
        int[] data;
        data = mSpanData;
        {
            kind = Object.class;
        } //End block
        {
            int i;
            i = 0;
            {
                int st;
                st = data[i * COLUMNS + START];
                int en;
                en = data[i * COLUMNS + END];
                {
                    boolean varF6D66FD5D17035475727187422C2B841_1927268198 = (st > start && st < limit && kind.isInstance(spans[i]));
                    limit = st;
                } //End collapsed parenthetic
                {
                    boolean varDD4114CCD8FA698F5DA31E38C7560428_644146371 = (en > start && en < limit && kind.isInstance(spans[i]));
                    limit = en;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.913 -0400", hash_original_method = "AE5753E793A4485018C5FAB8D6A92DBC", hash_generated_method = "4E83ED673F54F3817AEE27DCD06C4999")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @DSModeled(DSC.SPEC)
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
                recip[i].onSpanAdded((Spannable) this, what, start, end);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanAdded((Spannable) this, what, start, end);
        //}
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.930 -0400", hash_original_method = "60A86A7ABB49125FA35263BF87AB59D6", hash_generated_method = "0B2E052889972D82C7E389426CBA5EF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @DSModeled(DSC.SPEC)
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
                recip[i].onSpanRemoved((Spannable) this, what, start, end);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanRemoved((Spannable) this, what, start, end);
        //}
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.944 -0400", hash_original_method = "859EF27A1BB05860E7E5EF0EAB661D52", hash_generated_method = "55881FD00B2DA3AF9AC1EE84DFC74396")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @DSModeled(DSC.SPEC)
    private void sendSpanChanged(Object what, int s, int e, int st, int en) {
        dsTaint.addTaint(e);
        dsTaint.addTaint(s);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(en);
        dsTaint.addTaint(st);
        SpanWatcher[] recip;
        recip = getSpans(Math.min(s, st), Math.max(e, en),
                                       SpanWatcher.class);
        int n;
        n = recip.length;
        {
            int i;
            i = 0;
            {
                recip[i].onSpanChanged((Spannable) this, what, s, e, st, en);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //SpanWatcher[] recip = getSpans(Math.min(s, st), Math.max(e, en),
                                       //SpanWatcher.class);
        //int n = recip.length;
        //for (int i = 0; i < n; i++) {
            //recip[i].onSpanChanged((Spannable) this, what, s, e, st, en);
        //}
    }


        @DSModeled(DSC.SPEC)
        private static String region(int start, int end) {
        return "(" + start + " ... " + end + ")";
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 13:21:48.996 -0400", hash_original_method = "70C480F1BBBBF461E174788F8B29326C", hash_generated_method = "D0F0C26A22A862B35DBD62996F948D9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @DSModeled(DSC.SPEC)
    private void checkRange(final String operation, int start, int end) {
        dsTaint.addTaint(operation);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " has end before start");
        } //End block
        int len;
        len = length();
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


    static final Object[] EMPTY = new Object[0];
    private static final int START = 0;
    private static final int END = 1;
    private static final int FLAGS = 2;
    private static final int COLUMNS = 3;
}

