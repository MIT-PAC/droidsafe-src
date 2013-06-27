package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import android.util.Log;
import com.android.internal.util.ArrayUtils;

class MeasuredText {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.299 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "A59BBC07E5E46996D793B2F37E80BD24")

    CharSequence mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.299 -0400", hash_original_field = "356F326DD07BF3C178D92993F42C8258", hash_generated_field = "56525EE47BD7FA6F8CF4F7593CA30653")

    int mTextStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.299 -0400", hash_original_field = "3776CDE0A92BD5E30198555CE9E92337", hash_generated_field = "F268DBF02C69AE56F5D7B811DF02DD71")

    float[] mWidths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.299 -0400", hash_original_field = "7C3722E3CD3CCC07C587A93513F1BB79", hash_generated_field = "221D78AA948575C2C408290E651B0D1C")

    char[] mChars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.299 -0400", hash_original_field = "83F99C72ABCF954424B37B0FFAB0F5BC", hash_generated_field = "653966A07B2E0880FE25B3845B58F732")

    byte[] mLevels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.299 -0400", hash_original_field = "90B0D92F580EFEB979A78726B5A06046", hash_generated_field = "1D096AE80A1F47FBC923E53A1E78A2C9")

    int mDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.299 -0400", hash_original_field = "EB002D02793BF9AC45C93C8B0E0D177A", hash_generated_field = "E7219AC9CF15F6988B4E84BAD92B2CE6")

    boolean mEasy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.300 -0400", hash_original_field = "B74CDC798B150A72FBFBFAE7161611A0", hash_generated_field = "4B68EEB0ED264408F73553B8964D2663")

    int mLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.300 -0400", hash_original_field = "A8470CE6E0050B0E832FDE52720C7250", hash_generated_field = "649CC94BF1D5A5FECFE4D2F006B35728")

    private int mPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.310 -0400", hash_original_field = "B3CE09DC80997D762CCFEE11916EE7B6", hash_generated_field = "BD23BE48855C3EDD93B6A5A7CA353122")

    private TextPaint mWorkPaint;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.312 -0400", hash_original_method = "D598B3CBC464CFD963CF00BDB269B2BE", hash_generated_method = "42783F836CB64369EF4A69ACD2229E3E")
    private  MeasuredText() {
        mWorkPaint = new TextPaint();
        // ---------- Original Method ----------
        //mWorkPaint = new TextPaint();
    }

    
        static MeasuredText obtain() {
        MeasuredText mt;
        synchronized (sLock) {
            for (int i = sCached.length; --i >= 0;) {
                if (sCached[i] != null) {
                    mt = sCached[i];
                    sCached[i] = null;
                    return mt;
                }
            }
        }
        mt = new MeasuredText();
        if (localLOGV) {
            Log.v("MEAS", "new: " + mt);
        }
        return mt;
    }

    
        static MeasuredText recycle(MeasuredText mt) {
        mt.mText = null;
        if (mt.mLen < 1000) {
            synchronized(sLock) {
                for (int i = 0; i < sCached.length; ++i) {
                    if (sCached[i] == null) {
                        sCached[i] = mt;
                        mt.mText = null;
                        break;
                    }
                }
            }
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.315 -0400", hash_original_method = "AA7EC2CF46DA02829550CC76130A18E2", hash_generated_method = "64483FCEE82174117DF3846694DC7EB0")
     void setPara(CharSequence text, int start, int end, TextDirectionHeuristic textDir) {
        mText = text;
        mTextStart = start;
        int len;
        len = end - start;
        mLen = len;
        mPos = 0;
        {
            mWidths = new float[ArrayUtils.idealFloatArraySize(len)];
        } //End block
        {
            mChars = new char[ArrayUtils.idealCharArraySize(len)];
        } //End block
        TextUtils.getChars(text, start, end, mChars, 0);
        {
            Spanned spanned;
            spanned = (Spanned) text;
            ReplacementSpan[] spans;
            spans = spanned.getSpans(start, end,
                    ReplacementSpan.class);
            {
                int i;
                i = 0;
                {
                    int startInPara;
                    startInPara = spanned.getSpanStart(spans[i]) - start;
                    int endInPara;
                    endInPara = spanned.getSpanEnd(spans[i]) - start;
                    {
                        int j;
                        j = startInPara;
                        {
                            mChars[j] = '\uFFFC';
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var82EDE20A06D36920DD87167C8229ACD8_449205131 = ((textDir == TextDirectionHeuristics.LTR ||
                textDir == TextDirectionHeuristics.FIRSTSTRONG_LTR ||
                textDir == TextDirectionHeuristics.ANYRTL_LTR) &&
                TextUtils.doesNotNeedBidi(mChars, 0, len));
            {
                mDir = Layout.DIR_LEFT_TO_RIGHT;
                mEasy = true;
            } //End block
            {
                {
                    mLevels = new byte[ArrayUtils.idealByteArraySize(len)];
                } //End block
                int bidiRequest;
                {
                    bidiRequest = Layout.DIR_REQUEST_LTR;
                } //End block
                {
                    bidiRequest = Layout.DIR_REQUEST_RTL;
                } //End block
                {
                    bidiRequest = Layout.DIR_REQUEST_DEFAULT_LTR;
                } //End block
                {
                    bidiRequest = Layout.DIR_REQUEST_DEFAULT_RTL;
                } //End block
                {
                    boolean isRtl;
                    isRtl = textDir.isRtl(mChars, 0, len);
                    bidiRequest = isRtl ? Layout.DIR_REQUEST_RTL : Layout.DIR_REQUEST_LTR;
                } //End block
                mDir = AndroidBidi.bidi(bidiRequest, mChars, mLevels, len, false);
                mEasy = false;
            } //End block
        } //End collapsed parenthetic
        addTaint(end);
        addTaint(textDir.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.330 -0400", hash_original_method = "DC7A3D7065A333C10C0F305EED7320B6", hash_generated_method = "2C0AB8C3E10B57A03D120AF3AF007F84")
     float addStyleRun(TextPaint paint, int len, Paint.FontMetricsInt fm) {
        {
            paint.getFontMetricsInt(fm);
        } //End block
        int p;
        p = mPos;
        mPos = p + len;
        {
            int flags;
            flags = Canvas.DIRECTION_LTR;
            flags = Canvas.DIRECTION_RTL;
            float varEEDF1E9BF171FF1DF27B67B290C34949_144646467 = (paint.getTextRunAdvances(mChars, p, len, p, len, flags, mWidths, p));
        } //End block
        float totalAdvance;
        totalAdvance = 0;
        int level;
        level = mLevels[p];
        {
            int q, i, e;
            q = p;
            i = p + 1;
            e = p + len;
            {
                {
                    int flags;
                    flags = Canvas.DIRECTION_LTR;
                    flags = Canvas.DIRECTION_RTL;
                    totalAdvance +=
                        paint.getTextRunAdvances(mChars, q, i - q, q, i - q, flags, mWidths, q);
                    q = i;
                    level = mLevels[i];
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(paint.getTaint());
        addTaint(fm.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_852609466 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_852609466;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.336 -0400", hash_original_method = "18B04B5B33F859850D856F2E2DC299C7", hash_generated_method = "6DABE7EC721B423CDE9FA06476509519")
     float addStyleRun(TextPaint paint, MetricAffectingSpan[] spans, int len,
            Paint.FontMetricsInt fm) {
        TextPaint workPaint;
        workPaint = mWorkPaint;
        workPaint.set(paint);
        workPaint.baselineShift = 0;
        ReplacementSpan replacement;
        replacement = null;
        {
            int i;
            i = 0;
            {
                MetricAffectingSpan span;
                span = spans[i];
                {
                    replacement = (ReplacementSpan)span;
                } //End block
                {
                    span.updateMeasureState(workPaint);
                } //End block
            } //End block
        } //End collapsed parenthetic
        float wid;
        {
            wid = addStyleRun(workPaint, len, fm);
        } //End block
        {
            wid = replacement.getSize(workPaint, mText, mTextStart + mPos,
                    mTextStart + mPos + len, fm);
            float[] w;
            w = mWidths;
            w[mPos] = wid;
            {
                int i, e;
                i = mPos + 1;
                e = mPos + len;
                w[i] = 0;
            } //End collapsed parenthetic
            mPos += len;
        } //End block
        {
            {
                fm.ascent += workPaint.baselineShift;
                fm.top += workPaint.baselineShift;
            } //End block
            {
                fm.descent += workPaint.baselineShift;
                fm.bottom += workPaint.baselineShift;
            } //End block
        } //End block
        addTaint(paint.getTaint());
        addTaint(spans[0].getTaint());
        addTaint(fm.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_1823584420 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1823584420;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.357 -0400", hash_original_method = "F30A282CEAB73A5948442153B9251096", hash_generated_method = "0F47072E36DA4040B3849BC257913C87")
     int breakText(int start, int limit, boolean forwards, float width) {
        float[] w;
        w = mWidths;
        {
            {
                int i;
                i = start;
                {
                    {
                        boolean varF1EB4927EB76265507D93088705D8094_695111632 = ((width -= w[i]) < 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = limit;
                {
                    {
                        boolean varF1EB4927EB76265507D93088705D8094_1415381487 = ((width -= w[i]) < 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(start);
        addTaint(limit);
        addTaint(forwards);
        addTaint(width);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1749283468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1749283468;
        // ---------- Original Method ----------
        //float[] w = mWidths;
        //if (forwards) {
            //for (int i = start; i < limit; ++i) {
                //if ((width -= w[i]) < 0) {
                    //return i - start;
                //}
            //}
        //} else {
            //for (int i = limit; --i >= start;) {
                //if ((width -= w[i]) < 0) {
                    //return limit - i -1;
                //}
            //}
        //}
        //return limit - start;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.358 -0400", hash_original_method = "053843F92349BBB89263F41FED96E473", hash_generated_method = "0961A4A60727DBEB89E2DF45503F470B")
     float measure(int start, int limit) {
        float width;
        width = 0;
        float[] w;
        w = mWidths;
        {
            int i;
            i = start;
            {
                width += w[i];
            } //End block
        } //End collapsed parenthetic
        addTaint(start);
        addTaint(limit);
        float var546ADE640B6EDFBC8A086EF31347E768_1284783066 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1284783066;
        // ---------- Original Method ----------
        //float width = 0;
        //float[] w = mWidths;
        //for (int i = start; i < limit; ++i) {
            //width += w[i];
        //}
        //return width;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.358 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.358 -0400", hash_original_field = "FD588D0BA09E2DE573D6AB2267D28AEB", hash_generated_field = "2414935848B92962C171B2E9A09E6A7D")

    private static Object[] sLock = new Object[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.359 -0400", hash_original_field = "9CC83DBD7EC6E0EE354732DB8357A7DA", hash_generated_field = "E84B170D94FAA90534173168110EF774")

    private static MeasuredText[] sCached = new MeasuredText[3];
}

