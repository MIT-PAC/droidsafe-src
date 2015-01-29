package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import android.util.Log;

import com.android.internal.util.ArrayUtils;

class MeasuredText {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.865 -0500", hash_original_method = "A730A63711FAF2BA11082F3B340B807C", hash_generated_method = "4E6EA45AE978894F4D87BFC28F424B02")
    
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

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.868 -0500", hash_original_method = "1BAFA51CED79ACBA501A721EFAD84840", hash_generated_method = "DAE5FF8228279CA81A7486B6EBB19B06")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.824 -0500", hash_original_field = "7A06C0A50B73200DDC70097F2AFFF800", hash_generated_field = "761D2619615A389BF902F171CC86D6A4")

    private static final boolean localLOGV = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.860 -0500", hash_original_field = "14A59CFC333E208499C98B6D3860ADDD", hash_generated_field = "6FA9B47DB08FC419C50F72FDCF40883C")

    private static final Object[] sLock = new Object[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.862 -0500", hash_original_field = "AB3E4D5A7F78AED2968C08570B2AE9AB", hash_generated_field = "E84B170D94FAA90534173168110EF774")

    private static MeasuredText[] sCached = new MeasuredText[3];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.827 -0500", hash_original_field = "A59BBC07E5E46996D793B2F37E80BD24", hash_generated_field = "A59BBC07E5E46996D793B2F37E80BD24")

    CharSequence mText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.829 -0500", hash_original_field = "56525EE47BD7FA6F8CF4F7593CA30653", hash_generated_field = "56525EE47BD7FA6F8CF4F7593CA30653")

    int mTextStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.832 -0500", hash_original_field = "F268DBF02C69AE56F5D7B811DF02DD71", hash_generated_field = "F268DBF02C69AE56F5D7B811DF02DD71")

    float[] mWidths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.834 -0500", hash_original_field = "221D78AA948575C2C408290E651B0D1C", hash_generated_field = "221D78AA948575C2C408290E651B0D1C")

    char[] mChars;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.837 -0500", hash_original_field = "653966A07B2E0880FE25B3845B58F732", hash_generated_field = "653966A07B2E0880FE25B3845B58F732")

    byte[] mLevels;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.840 -0500", hash_original_field = "1D096AE80A1F47FBC923E53A1E78A2C9", hash_generated_field = "1D096AE80A1F47FBC923E53A1E78A2C9")

    int mDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.846 -0500", hash_original_field = "E7219AC9CF15F6988B4E84BAD92B2CE6", hash_generated_field = "E7219AC9CF15F6988B4E84BAD92B2CE6")

    boolean mEasy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.849 -0500", hash_original_field = "4B68EEB0ED264408F73553B8964D2663", hash_generated_field = "4B68EEB0ED264408F73553B8964D2663")

    int mLen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.851 -0500", hash_original_field = "25A5DEAC26D49039381CEC3AC02D8D8E", hash_generated_field = "649CC94BF1D5A5FECFE4D2F006B35728")

    private int mPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.854 -0500", hash_original_field = "B28AC88C47D899E85CEE0110DCCDCA16", hash_generated_field = "BD23BE48855C3EDD93B6A5A7CA353122")

    private TextPaint mWorkPaint;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.857 -0500", hash_original_method = "D598B3CBC464CFD963CF00BDB269B2BE", hash_generated_method = "AFF644A9C87997303EA454A23F283D57")
    
private MeasuredText() {
        mWorkPaint = new TextPaint();
    }

    /**
     * Analyzes text for bidirectional runs.  Allocates working buffers.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.871 -0500", hash_original_method = "AA7EC2CF46DA02829550CC76130A18E2", hash_generated_method = "AA7EC2CF46DA02829550CC76130A18E2")
    
void setPara(CharSequence text, int start, int end, TextDirectionHeuristic textDir) {
        mText = text;
        mTextStart = start;

        int len = end - start;
        mLen = len;
        mPos = 0;

        if (mWidths == null || mWidths.length < len) {
            mWidths = new float[ArrayUtils.idealFloatArraySize(len)];
        }
        if (mChars == null || mChars.length < len) {
            mChars = new char[ArrayUtils.idealCharArraySize(len)];
        }
        TextUtils.getChars(text, start, end, mChars, 0);

        if (text instanceof Spanned) {
            Spanned spanned = (Spanned) text;
            ReplacementSpan[] spans = spanned.getSpans(start, end,
                    ReplacementSpan.class);

            for (int i = 0; i < spans.length; i++) {
                int startInPara = spanned.getSpanStart(spans[i]) - start;
                int endInPara = spanned.getSpanEnd(spans[i]) - start;
                for (int j = startInPara; j < endInPara; j++) {
                    mChars[j] = '\uFFFC';
                }
            }
        }

        if ((textDir == TextDirectionHeuristics.LTR ||
                textDir == TextDirectionHeuristics.FIRSTSTRONG_LTR ||
                textDir == TextDirectionHeuristics.ANYRTL_LTR) &&
                TextUtils.doesNotNeedBidi(mChars, 0, len)) {
            mDir = Layout.DIR_LEFT_TO_RIGHT;
            mEasy = true;
        } else {
            if (mLevels == null || mLevels.length < len) {
                mLevels = new byte[ArrayUtils.idealByteArraySize(len)];
            }
            int bidiRequest;
            if (textDir == TextDirectionHeuristics.LTR) {
                bidiRequest = Layout.DIR_REQUEST_LTR;
            } else if (textDir == TextDirectionHeuristics.RTL) {
                bidiRequest = Layout.DIR_REQUEST_RTL;
            } else if (textDir == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                bidiRequest = Layout.DIR_REQUEST_DEFAULT_LTR;
            } else if (textDir == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                bidiRequest = Layout.DIR_REQUEST_DEFAULT_RTL;
            } else {
                boolean isRtl = textDir.isRtl(mChars, 0, len);
                bidiRequest = isRtl ? Layout.DIR_REQUEST_RTL : Layout.DIR_REQUEST_LTR;
            }
            mDir = AndroidBidi.bidi(bidiRequest, mChars, mLevels, len, false);
            mEasy = false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.875 -0500", hash_original_method = "DC7A3D7065A333C10C0F305EED7320B6", hash_generated_method = "DC7A3D7065A333C10C0F305EED7320B6")
    
float addStyleRun(TextPaint paint, int len, Paint.FontMetricsInt fm) {
        if (fm != null) {
            paint.getFontMetricsInt(fm);
        }

        int p = mPos;
        mPos = p + len;

        if (mEasy) {
            int flags = mDir == Layout.DIR_LEFT_TO_RIGHT
                ? Canvas.DIRECTION_LTR : Canvas.DIRECTION_RTL;
            return paint.getTextRunAdvances(mChars, p, len, p, len, flags, mWidths, p);
        }

        float totalAdvance = 0;
        int level = mLevels[p];
        for (int q = p, i = p + 1, e = p + len;; ++i) {
            if (i == e || mLevels[i] != level) {
                int flags = (level & 0x1) == 0 ? Canvas.DIRECTION_LTR : Canvas.DIRECTION_RTL;
                totalAdvance +=
                        paint.getTextRunAdvances(mChars, q, i - q, q, i - q, flags, mWidths, q);
                if (i == e) {
                    break;
                }
                q = i;
                level = mLevels[i];
            }
        }
        return totalAdvance;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.878 -0500", hash_original_method = "18B04B5B33F859850D856F2E2DC299C7", hash_generated_method = "CD1CBD9438950B6E7CD602AED538814D")
    
float addStyleRun(TextPaint paint, MetricAffectingSpan[] spans, int len,
            Paint.FontMetricsInt fm) {

        TextPaint workPaint = mWorkPaint;
        workPaint.set(paint);
        // XXX paint should not have a baseline shift, but...
        workPaint.baselineShift = 0;

        ReplacementSpan replacement = null;
        for (int i = 0; i < spans.length; i++) {
            MetricAffectingSpan span = spans[i];
            if (span instanceof ReplacementSpan) {
                replacement = (ReplacementSpan)span;
            } else {
                span.updateMeasureState(workPaint);
            }
        }

        float wid;
        if (replacement == null) {
            wid = addStyleRun(workPaint, len, fm);
        } else {
            // Use original text.  Shouldn't matter.
            wid = replacement.getSize(workPaint, mText, mTextStart + mPos,
                    mTextStart + mPos + len, fm);
            float[] w = mWidths;
            w[mPos] = wid;
            for (int i = mPos + 1, e = mPos + len; i < e; i++)
                w[i] = 0;
            mPos += len;
        }

        if (fm != null) {
            if (workPaint.baselineShift < 0) {
                fm.ascent += workPaint.baselineShift;
                fm.top += workPaint.baselineShift;
            } else {
                fm.descent += workPaint.baselineShift;
                fm.bottom += workPaint.baselineShift;
            }
        }

        return wid;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.881 -0500", hash_original_method = "F30A282CEAB73A5948442153B9251096", hash_generated_method = "F30A282CEAB73A5948442153B9251096")
    
int breakText(int start, int limit, boolean forwards, float width) {
        float[] w = mWidths;
        if (forwards) {
            for (int i = start; i < limit; ++i) {
                if ((width -= w[i]) < 0) {
                    return i - start;
                }
            }
        } else {
            for (int i = limit; --i >= start;) {
                if ((width -= w[i]) < 0) {
                    return limit - i -1;
                }
            }
        }

        return limit - start;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.884 -0500", hash_original_method = "053843F92349BBB89263F41FED96E473", hash_generated_method = "053843F92349BBB89263F41FED96E473")
    
float measure(int start, int limit) {
        float width = 0;
        float[] w = mWidths;
        for (int i = start; i < limit; ++i) {
            width += w[i];
        }
        return width;
    }
}

