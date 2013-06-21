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
    CharSequence mText;
    int mTextStart;
    float[] mWidths;
    char[] mChars;
    byte[] mLevels;
    int mDir;
    boolean mEasy;
    int mLen;
    private int mPos;
    private TextPaint mWorkPaint;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.174 -0400", hash_original_method = "D598B3CBC464CFD963CF00BDB269B2BE", hash_generated_method = "42783F836CB64369EF4A69ACD2229E3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private MeasuredText() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.175 -0400", hash_original_method = "AA7EC2CF46DA02829550CC76130A18E2", hash_generated_method = "ABABE0306844CB1EBE15BC7D2BACE79B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setPara(CharSequence text, int start, int end, TextDirectionHeuristic textDir) {
        dsTaint.addTaint(textDir.dsTaint);
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
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
            boolean var82EDE20A06D36920DD87167C8229ACD8_1938543073 = ((textDir == TextDirectionHeuristics.LTR ||
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.176 -0400", hash_original_method = "DC7A3D7065A333C10C0F305EED7320B6", hash_generated_method = "44C783DAE5A1A8E649D4D08B5F840628")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float addStyleRun(TextPaint paint, int len, Paint.FontMetricsInt fm) {
        dsTaint.addTaint(fm.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(len);
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
            float varEEDF1E9BF171FF1DF27B67B290C34949_1348501360 = (paint.getTextRunAdvances(mChars, p, len, p, len, flags, mWidths, p));
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
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.177 -0400", hash_original_method = "18B04B5B33F859850D856F2E2DC299C7", hash_generated_method = "F430B8762FF4B40A232BDA3C53635FC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float addStyleRun(TextPaint paint, MetricAffectingSpan[] spans, int len,
            Paint.FontMetricsInt fm) {
        dsTaint.addTaint(fm.dsTaint);
        dsTaint.addTaint(spans[0].dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(len);
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
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.177 -0400", hash_original_method = "F30A282CEAB73A5948442153B9251096", hash_generated_method = "5C0790B546ADD7190761394B6002A495")
    @DSModeled(DSC.SAFE)
     int breakText(int start, int limit, boolean forwards, float width) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(start);
        dsTaint.addTaint(width);
        dsTaint.addTaint(forwards);
        float[] w;
        w = mWidths;
        {
            {
                int i;
                i = start;
                {
                    {
                        boolean varF1EB4927EB76265507D93088705D8094_331089851 = ((width -= w[i]) < 0);
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
                        boolean varF1EB4927EB76265507D93088705D8094_718385701 = ((width -= w[i]) < 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.178 -0400", hash_original_method = "053843F92349BBB89263F41FED96E473", hash_generated_method = "421B48D0BEE7D1DDE6DD4B9823A7AF0C")
    @DSModeled(DSC.SAFE)
     float measure(int start, int limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(start);
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
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //float width = 0;
        //float[] w = mWidths;
        //for (int i = start; i < limit; ++i) {
            //width += w[i];
        //}
        //return width;
    }

    
    private static final boolean localLOGV = false;
    private static final Object[] sLock = new Object[0];
    private static MeasuredText[] sCached = new MeasuredText[3];
}

