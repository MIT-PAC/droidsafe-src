package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Array;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.text.Layout.Directions;
import android.text.Layout.TabStops;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import android.util.Log;

import com.android.internal.util.ArrayUtils;






class TextLine {

    /**
     * Returns a new TextLine from the shared pool.
     *
     * @return an uninitialized TextLine
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.543 -0500", hash_original_method = "94707AFC02D921BFDEDD2070AC4B80C0", hash_generated_method = "32F6F382E99E870FA8001B4ADA028C03")
    
static TextLine obtain() {
        TextLine tl;
        synchronized (sCached) {
            for (int i = sCached.length; --i >= 0;) {
                if (sCached[i] != null) {
                    tl = sCached[i];
                    sCached[i] = null;
                    return tl;
                }
            }
        }
        tl = new TextLine();
        if (DEBUG) {
            Log.v("TLINE", "new: " + tl);
        }
        return tl;
    }

    /**
     * Puts a TextLine back into the shared pool. Do not use this TextLine once
     * it has been returned.
     * @param tl the textLine
     * @return null, as a convenience from clearing references to the provided
     * TextLine
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.545 -0500", hash_original_method = "FC94B7D2EC96B1E145D19814C89754EC", hash_generated_method = "81AB3B8E692922C831C8601B8B7A83B1")
    
static TextLine recycle(TextLine tl) {
        tl.mText = null;
        tl.mPaint = null;
        tl.mDirections = null;

        tl.mMetricAffectingSpanSpanSet.recycle();
        tl.mCharacterStyleSpanSet.recycle();
        tl.mReplacementSpanSpanSet.recycle();

        synchronized(sCached) {
            for (int i = 0; i < sCached.length; ++i) {
                if (sCached[i] == null) {
                    sCached[i] = tl;
                    break;
                }
            }
        }
        return null;
    }

    /**
     * @param wp
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.578 -0500", hash_original_method = "E5BF79BC52817C5BB2C6F834135EC3D7", hash_generated_method = "15E4BAFDFC523AF45E4F995774DB33DC")
    
private static void expandMetricsFromPaint(FontMetricsInt fmi, TextPaint wp) {
        final int previousTop     = fmi.top;
        final int previousAscent  = fmi.ascent;
        final int previousDescent = fmi.descent;
        final int previousBottom  = fmi.bottom;
        final int previousLeading = fmi.leading;

        wp.getFontMetricsInt(fmi);

        updateMetrics(fmi, previousTop, previousAscent, previousDescent, previousBottom,
                previousLeading);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.581 -0500", hash_original_method = "E384C4F61D4CBD856FC4D24CBE08C589", hash_generated_method = "3EFEF07878F3118904DCBD490AA1A333")
    
static void updateMetrics(FontMetricsInt fmi, int previousTop, int previousAscent,
            int previousDescent, int previousBottom, int previousLeading) {
        fmi.top     = Math.min(fmi.top,     previousTop);
        fmi.ascent  = Math.min(fmi.ascent,  previousAscent);
        fmi.descent = Math.max(fmi.descent, previousDescent);
        fmi.bottom  = Math.max(fmi.bottom,  previousBottom);
        fmi.leading = Math.max(fmi.leading, previousLeading);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.498 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.540 -0500", hash_original_field = "E38DEB35EF1EB454117E6E7066E721DE", hash_generated_field = "B787628D86685B4DD27C326E2D91EEE2")


    private static final TextLine[] sCached = new TextLine[3];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.637 -0500", hash_original_field = "523B437B66E94D47C6D3407D5611D3C9", hash_generated_field = "D5E340FF9F0E2C74F920DF02A6624213")


    private static final int TAB_INCREMENT = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.501 -0500", hash_original_field = "956DBF43153BA67BCB0E9C5A7787D348", hash_generated_field = "B5BC396C7010734D6B4B6ED34A2846AE")


    private TextPaint mPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.503 -0500", hash_original_field = "A59BBC07E5E46996D793B2F37E80BD24", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.506 -0500", hash_original_field = "83A19D93B82C07A79F54E265C2077EC6", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

    private int mStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.508 -0500", hash_original_field = "4B68EEB0ED264408F73553B8964D2663", hash_generated_field = "8D921BC08EBCA74A32B1247B1F91B368")

    private int mLen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.512 -0500", hash_original_field = "1D096AE80A1F47FBC923E53A1E78A2C9", hash_generated_field = "9463565EC19B0C28E47B4A05A883AACE")

    private int mDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.514 -0500", hash_original_field = "D1CEB1B8D03E24158539090625B2BFC1", hash_generated_field = "0120B57883F4A0FE4FFD7BC1C988B792")

    private Directions mDirections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.517 -0500", hash_original_field = "4BA55E7E13D0DFAF43A42987317B9DF3", hash_generated_field = "D9EB8682A57605E85FDF7A8921E6278B")

    private boolean mHasTabs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.519 -0500", hash_original_field = "A3D80ECA7EF0B6DAB7001AB9F5C607FD", hash_generated_field = "D70B7E9717C627B10CB1103D367577AF")

    private TabStops mTabs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.521 -0500", hash_original_field = "221D78AA948575C2C408290E651B0D1C", hash_generated_field = "20B8558AB5FD0F0B5A30B95221D68246")

    private char[] mChars;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.523 -0500", hash_original_field = "B31A9BFCB938C87078D26B5EC5313CF1", hash_generated_field = "24C6EE5653AF991EF0187B60742148D2")

    private boolean mCharsValid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.526 -0500", hash_original_field = "4D9A388EBF42337B3D4B4C24F8CD74B1", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

    private Spanned mSpanned;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.529 -0500", hash_original_field = "46D75F0A95C66933FEBE12F112E15EB0", hash_generated_field = "9DF8DC076CC35FCF35EEB176300E0E8D")

    private final TextPaint mWorkPaint = new TextPaint();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.532 -0500", hash_original_field = "BB0924D9FC4A4D89B138FFBA8D4A922B", hash_generated_field = "D3CDAF00A4A19D3D5704E027A0A1B262")

    private final SpanSet<MetricAffectingSpan> mMetricAffectingSpanSpanSet =
            new SpanSet<MetricAffectingSpan>(MetricAffectingSpan.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.535 -0500", hash_original_field = "9B3266AB036BA98A909D8715AE683940", hash_generated_field = "B4D32C7B68371DC6D1D4FF600C409891")

    private final SpanSet<CharacterStyle> mCharacterStyleSpanSet =
            new SpanSet<CharacterStyle>(CharacterStyle.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.537 -0500", hash_original_field = "510937B53F270F025BC73FC45601EEB5", hash_generated_field = "5959D1EA746C40C99B9844CC88D0ADB0")

    private final SpanSet<ReplacementSpan> mReplacementSpanSpanSet =
            new SpanSet<ReplacementSpan>(ReplacementSpan.class);
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.885 -0400", hash_original_method = "2FAB193CBF90842ECB23B93C34526440", hash_generated_method = "2FAB193CBF90842ECB23B93C34526440")
    public TextLine ()
    {
        //Synthesized constructor
    }

    /**
     * Initializes a TextLine and prepares it for use.
     *
     * @param paint the base paint for the line
     * @param text the text, can be Styled
     * @param start the start of the line relative to the text
     * @param limit the limit of the line relative to the text
     * @param dir the paragraph direction of this line
     * @param directions the directions information of this line
     * @param hasTabs true if the line might contain tabs or emoji
     * @param tabStops the tabStops. Can be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.549 -0500", hash_original_method = "38DB7B0D381033DA01F9181167C14361", hash_generated_method = "396C14345403639C03C0286DCF907FC3")
    
void set(TextPaint paint, CharSequence text, int start, int limit, int dir,
            Directions directions, boolean hasTabs, TabStops tabStops) {
        mPaint = paint;
        mText = text;
        mStart = start;
        mLen = limit - start;
        mDir = dir;
        mDirections = directions;
        if (mDirections == null) {
            throw new IllegalArgumentException("Directions cannot be null");
        }
        mHasTabs = hasTabs;
        mSpanned = null;

        boolean hasReplacement = false;
        if (text instanceof Spanned) {
            mSpanned = (Spanned) text;
            mReplacementSpanSpanSet.init(mSpanned, start, limit);
            hasReplacement = mReplacementSpanSpanSet.numberOfSpans > 0;
        }

        mCharsValid = hasReplacement || hasTabs || directions != Layout.DIRS_ALL_LEFT_TO_RIGHT;

        if (mCharsValid) {
            if (mChars == null || mChars.length < mLen) {
                mChars = new char[ArrayUtils.idealCharArraySize(mLen)];
            }
            TextUtils.getChars(text, start, limit, mChars, 0);
            if (hasReplacement) {
                // Handle these all at once so we don't have to do it as we go.
                // Replace the first character of each replacement run with the
                // object-replacement character and the remainder with zero width
                // non-break space aka BOM.  Cursor movement code skips these
                // zero-width characters.
                char[] chars = mChars;
                for (int i = start, inext; i < limit; i = inext) {
                    inext = mReplacementSpanSpanSet.getNextTransition(i, limit);
                    if (mReplacementSpanSpanSet.hasSpansIntersecting(i, inext)) {
                        // transition into a span
                        chars[i - start] = '\ufffc';
                        for (int j = i - start + 1, e = inext - start; j < e; ++j) {
                            chars[j] = '\ufeff'; // used as ZWNBS, marks positions to skip
                        }
                    }
                }
            }
        }
        mTabs = tabStops;
    }

    /**
     * Renders the TextLine.
     *
     * @param c the canvas to render on
     * @param x the leading margin position
     * @param top the top of the line
     * @param y the baseline
     * @param bottom the bottom of the line
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.554 -0500", hash_original_method = "20A60861C26C58A53A0282FABD9ED153", hash_generated_method = "20A60861C26C58A53A0282FABD9ED153")
    
void draw(Canvas c, float x, int top, int y, int bottom) {
        if (!mHasTabs) {
            if (mDirections == Layout.DIRS_ALL_LEFT_TO_RIGHT) {
                drawRun(c, 0, mLen, false, x, top, y, bottom, false);
                return;
            }
            if (mDirections == Layout.DIRS_ALL_RIGHT_TO_LEFT) {
                drawRun(c, 0, mLen, true, x, top, y, bottom, false);
                return;
            }
        }

        float h = 0;
        int[] runs = mDirections.mDirections;
        RectF emojiRect = null;

        int lastRunIndex = runs.length - 2;
        for (int i = 0; i < runs.length; i += 2) {
            int runStart = runs[i];
            int runLimit = runStart + (runs[i+1] & Layout.RUN_LENGTH_MASK);
            if (runLimit > mLen) {
                runLimit = mLen;
            }
            boolean runIsRtl = (runs[i+1] & Layout.RUN_RTL_FLAG) != 0;

            int segstart = runStart;
            for (int j = mHasTabs ? runStart : runLimit; j <= runLimit; j++) {
                int codept = 0;
                Bitmap bm = null;

                if (mHasTabs && j < runLimit) {
                    codept = mChars[j];
                    if (codept >= 0xd800 && codept < 0xdc00 && j + 1 < runLimit) {
                        codept = Character.codePointAt(mChars, j);
                        if (codept >= Layout.MIN_EMOJI && codept <= Layout.MAX_EMOJI) {
                            bm = Layout.EMOJI_FACTORY.getBitmapFromAndroidPua(codept);
                        } else if (codept > 0xffff) {
                            ++j;
                            continue;
                        }
                    }
                }

                if (j == runLimit || codept == '\t' || bm != null) {
                    h += drawRun(c, segstart, j, runIsRtl, x+h, top, y, bottom,
                            i != lastRunIndex || j != mLen);

                    if (codept == '\t') {
                        h = mDir * nextTab(h * mDir);
                    } else if (bm != null) {
                        float bmAscent = ascent(j);
                        float bitmapHeight = bm.getHeight();
                        float scale = -bmAscent / bitmapHeight;
                        float width = bm.getWidth() * scale;

                        if (emojiRect == null) {
                            emojiRect = new RectF();
                        }
                        emojiRect.set(x + h, y + bmAscent,
                                x + h + width, y);
                        c.drawBitmap(bm, null, emojiRect, mPaint);
                        h += width;
                        j++;
                    }
                    segstart = j + 1;
                }
            }
        }
    }

    /**
     * Returns metrics information for the entire line.
     *
     * @param fmi receives font metrics information, can be null
     * @return the signed width of the line
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.556 -0500", hash_original_method = "7F5367E991A6BC7E9EDD55CA9BF0FBE6", hash_generated_method = "7F5367E991A6BC7E9EDD55CA9BF0FBE6")
    
float metrics(FontMetricsInt fmi) {
        return measure(mLen, false, fmi);
    }

    /**
     * Returns information about a position on the line.
     *
     * @param offset the line-relative character offset, between 0 and the
     * line length, inclusive
     * @param trailing true to measure the trailing edge of the character
     * before offset, false to measure the leading edge of the character
     * at offset.
     * @param fmi receives metrics information about the requested
     * character, can be null.
     * @return the signed offset from the leading margin to the requested
     * character edge.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.560 -0500", hash_original_method = "5986320AFF9EF780E7B17B08599A90A9", hash_generated_method = "5986320AFF9EF780E7B17B08599A90A9")
    
float measure(int offset, boolean trailing, FontMetricsInt fmi) {
        int target = trailing ? offset - 1 : offset;
        if (target < 0) {
            return 0;
        }

        float h = 0;

        if (!mHasTabs) {
            if (mDirections == Layout.DIRS_ALL_LEFT_TO_RIGHT) {
                return measureRun(0, offset, mLen, false, fmi);
            }
            if (mDirections == Layout.DIRS_ALL_RIGHT_TO_LEFT) {
                return measureRun(0, offset, mLen, true, fmi);
            }
        }

        char[] chars = mChars;
        int[] runs = mDirections.mDirections;
        for (int i = 0; i < runs.length; i += 2) {
            int runStart = runs[i];
            int runLimit = runStart + (runs[i+1] & Layout.RUN_LENGTH_MASK);
            if (runLimit > mLen) {
                runLimit = mLen;
            }
            boolean runIsRtl = (runs[i+1] & Layout.RUN_RTL_FLAG) != 0;

            int segstart = runStart;
            for (int j = mHasTabs ? runStart : runLimit; j <= runLimit; j++) {
                int codept = 0;
                Bitmap bm = null;

                if (mHasTabs && j < runLimit) {
                    codept = chars[j];
                    if (codept >= 0xd800 && codept < 0xdc00 && j + 1 < runLimit) {
                        codept = Character.codePointAt(chars, j);
                        if (codept >= Layout.MIN_EMOJI && codept <= Layout.MAX_EMOJI) {
                            bm = Layout.EMOJI_FACTORY.getBitmapFromAndroidPua(codept);
                        } else if (codept > 0xffff) {
                            ++j;
                            continue;
                        }
                    }
                }

                if (j == runLimit || codept == '\t' || bm != null) {
                    boolean inSegment = target >= segstart && target < j;

                    boolean advance = (mDir == Layout.DIR_RIGHT_TO_LEFT) == runIsRtl;
                    if (inSegment && advance) {
                        return h += measureRun(segstart, offset, j, runIsRtl, fmi);
                    }

                    float w = measureRun(segstart, j, j, runIsRtl, fmi);
                    h += advance ? w : -w;

                    if (inSegment) {
                        return h += measureRun(segstart, offset, j, runIsRtl, null);
                    }

                    if (codept == '\t') {
                        if (offset == j) {
                            return h;
                        }
                        h = mDir * nextTab(h * mDir);
                        if (target == j) {
                            return h;
                        }
                    }

                    if (bm != null) {
                        float bmAscent = ascent(j);
                        float wid = bm.getWidth() * -bmAscent / bm.getHeight();
                        h += mDir * wid;
                        j++;
                    }

                    segstart = j + 1;
                }
            }
        }

        return h;
    }

    /**
     * Draws a unidirectional (but possibly multi-styled) run of text.
     *
     *
     * @param c the canvas to draw on
     * @param start the line-relative start
     * @param limit the line-relative limit
     * @param runIsRtl true if the run is right-to-left
     * @param x the position of the run that is closest to the leading margin
     * @param top the top of the line
     * @param y the baseline
     * @param bottom the bottom of the line
     * @param needWidth true if the width value is required.
     * @return the signed width of the run, based on the paragraph direction.
     * Only valid if needWidth is true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.563 -0500", hash_original_method = "1E01EF0F20C48DC869D8591ACBCB40DD", hash_generated_method = "71B18765A1186C2AB489F063F2C7351C")
    
private float drawRun(Canvas c, int start,
            int limit, boolean runIsRtl, float x, int top, int y, int bottom,
            boolean needWidth) {

        if ((mDir == Layout.DIR_LEFT_TO_RIGHT) == runIsRtl) {
            float w = -measureRun(start, limit, limit, runIsRtl, null);
            handleRun(start, limit, limit, runIsRtl, c, x + w, top,
                    y, bottom, null, false);
            return w;
        }

        return handleRun(start, limit, limit, runIsRtl, c, x, top,
                y, bottom, null, needWidth);
    }

    /**
     * Measures a unidirectional (but possibly multi-styled) run of text.
     *
     *
     * @param start the line-relative start of the run
     * @param offset the offset to measure to, between start and limit inclusive
     * @param limit the line-relative limit of the run
     * @param runIsRtl true if the run is right-to-left
     * @param fmi receives metrics information about the requested
     * run, can be null.
     * @return the signed width from the start of the run to the leading edge
     * of the character at offset, based on the run (not paragraph) direction
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.565 -0500", hash_original_method = "92FB3641FED625E21CE916EA375B8557", hash_generated_method = "50E48F0F9FC19067DC5965A74F47B2E0")
    
private float measureRun(int start, int offset, int limit, boolean runIsRtl,
            FontMetricsInt fmi) {
        return handleRun(start, offset, limit, runIsRtl, null, 0, 0, 0, 0, fmi, true);
    }

    /**
     * Walk the cursor through this line, skipping conjuncts and
     * zero-width characters.
     *
     * <p>This function cannot properly walk the cursor off the ends of the line
     * since it does not know about any shaping on the previous/following line
     * that might affect the cursor position. Callers must either avoid these
     * situations or handle the result specially.
     *
     * @param cursor the starting position of the cursor, between 0 and the
     * length of the line, inclusive
     * @param toLeft true if the caret is moving to the left.
     * @return the new offset.  If it is less than 0 or greater than the length
     * of the line, the previous/following line should be examined to get the
     * actual offset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.571 -0500", hash_original_method = "4BDB20A2184F91CDB9542314BD3E47CD", hash_generated_method = "07B09DD4B0CCA43FDBD92EC54B6EE973")
    
int getOffsetToLeftRightOf(int cursor, boolean toLeft) {
        // 1) The caret marks the leading edge of a character. The character
        // logically before it might be on a different level, and the active caret
        // position is on the character at the lower level. If that character
        // was the previous character, the caret is on its trailing edge.
        // 2) Take this character/edge and move it in the indicated direction.
        // This gives you a new character and a new edge.
        // 3) This position is between two visually adjacent characters.  One of
        // these might be at a lower level.  The active position is on the
        // character at the lower level.
        // 4) If the active position is on the trailing edge of the character,
        // the new caret position is the following logical character, else it
        // is the character.

        int lineStart = 0;
        int lineEnd = mLen;
        boolean paraIsRtl = mDir == -1;
        int[] runs = mDirections.mDirections;

        int runIndex, runLevel = 0, runStart = lineStart, runLimit = lineEnd, newCaret = -1;
        boolean trailing = false;

        if (cursor == lineStart) {
            runIndex = -2;
        } else if (cursor == lineEnd) {
            runIndex = runs.length;
        } else {
          // First, get information about the run containing the character with
          // the active caret.
          for (runIndex = 0; runIndex < runs.length; runIndex += 2) {
            runStart = lineStart + runs[runIndex];
            if (cursor >= runStart) {
              runLimit = runStart + (runs[runIndex+1] & Layout.RUN_LENGTH_MASK);
              if (runLimit > lineEnd) {
                  runLimit = lineEnd;
              }
              if (cursor < runLimit) {
                runLevel = (runs[runIndex+1] >>> Layout.RUN_LEVEL_SHIFT) &
                    Layout.RUN_LEVEL_MASK;
                if (cursor == runStart) {
                  // The caret is on a run boundary, see if we should
                  // use the position on the trailing edge of the previous
                  // logical character instead.
                  int prevRunIndex, prevRunLevel, prevRunStart, prevRunLimit;
                  int pos = cursor - 1;
                  for (prevRunIndex = 0; prevRunIndex < runs.length; prevRunIndex += 2) {
                    prevRunStart = lineStart + runs[prevRunIndex];
                    if (pos >= prevRunStart) {
                      prevRunLimit = prevRunStart +
                          (runs[prevRunIndex+1] & Layout.RUN_LENGTH_MASK);
                      if (prevRunLimit > lineEnd) {
                          prevRunLimit = lineEnd;
                      }
                      if (pos < prevRunLimit) {
                        prevRunLevel = (runs[prevRunIndex+1] >>> Layout.RUN_LEVEL_SHIFT)
                            & Layout.RUN_LEVEL_MASK;
                        if (prevRunLevel < runLevel) {
                          // Start from logically previous character.
                          runIndex = prevRunIndex;
                          runLevel = prevRunLevel;
                          runStart = prevRunStart;
                          runLimit = prevRunLimit;
                          trailing = true;
                          break;
                        }
                      }
                    }
                  }
                }
                break;
              }
            }
          }

          // caret might be == lineEnd.  This is generally a space or paragraph
          // separator and has an associated run, but might be the end of
          // text, in which case it doesn't.  If that happens, we ran off the
          // end of the run list, and runIndex == runs.length.  In this case,
          // we are at a run boundary so we skip the below test.
          if (runIndex != runs.length) {
              boolean runIsRtl = (runLevel & 0x1) != 0;
              boolean advance = toLeft == runIsRtl;
              if (cursor != (advance ? runLimit : runStart) || advance != trailing) {
                  // Moving within or into the run, so we can move logically.
                  newCaret = getOffsetBeforeAfter(runIndex, runStart, runLimit,
                          runIsRtl, cursor, advance);
                  // If the new position is internal to the run, we're at the strong
                  // position already so we're finished.
                  if (newCaret != (advance ? runLimit : runStart)) {
                      return newCaret;
                  }
              }
          }
        }

        // If newCaret is -1, we're starting at a run boundary and crossing
        // into another run. Otherwise we've arrived at a run boundary, and
        // need to figure out which character to attach to.  Note we might
        // need to run this twice, if we cross a run boundary and end up at
        // another run boundary.
        while (true) {
          boolean advance = toLeft == paraIsRtl;
          int otherRunIndex = runIndex + (advance ? 2 : -2);
          if (otherRunIndex >= 0 && otherRunIndex < runs.length) {
            int otherRunStart = lineStart + runs[otherRunIndex];
            int otherRunLimit = otherRunStart +
            (runs[otherRunIndex+1] & Layout.RUN_LENGTH_MASK);
            if (otherRunLimit > lineEnd) {
                otherRunLimit = lineEnd;
            }
            int otherRunLevel = (runs[otherRunIndex+1] >>> Layout.RUN_LEVEL_SHIFT) &
                Layout.RUN_LEVEL_MASK;
            boolean otherRunIsRtl = (otherRunLevel & 1) != 0;

            advance = toLeft == otherRunIsRtl;
            if (newCaret == -1) {
                newCaret = getOffsetBeforeAfter(otherRunIndex, otherRunStart,
                        otherRunLimit, otherRunIsRtl,
                        advance ? otherRunStart : otherRunLimit, advance);
                if (newCaret == (advance ? otherRunLimit : otherRunStart)) {
                    // Crossed and ended up at a new boundary,
                    // repeat a second and final time.
                    runIndex = otherRunIndex;
                    runLevel = otherRunLevel;
                    continue;
                }
                break;
            }

            // The new caret is at a boundary.
            if (otherRunLevel < runLevel) {
              // The strong character is in the other run.
              newCaret = advance ? otherRunStart : otherRunLimit;
            }
            break;
          }

          if (newCaret == -1) {
              // We're walking off the end of the line.  The paragraph
              // level is always equal to or lower than any internal level, so
              // the boundaries get the strong caret.
              newCaret = advance ? mLen + 1 : -1;
              break;
          }

          // Else we've arrived at the end of the line.  That's a strong position.
          // We might have arrived here by crossing over a run with no internal
          // breaks and dropping out of the above loop before advancing one final
          // time, so reset the caret.
          // Note, we use '<=' below to handle a situation where the only run
          // on the line is a counter-directional run.  If we're not advancing,
          // we can end up at the 'lineEnd' position but the caret we want is at
          // the lineStart.
          if (newCaret <= lineEnd) {
              newCaret = advance ? lineEnd : lineStart;
          }
          break;
        }

        return newCaret;
    }

    /**
     * Returns the next valid offset within this directional run, skipping
     * conjuncts and zero-width characters.  This should not be called to walk
     * off the end of the line, since the returned values might not be valid
     * on neighboring lines.  If the returned offset is less than zero or
     * greater than the line length, the offset should be recomputed on the
     * preceding or following line, respectively.
     *
     * @param runIndex the run index
     * @param runStart the start of the run
     * @param runLimit the limit of the run
     * @param runIsRtl true if the run is right-to-left
     * @param offset the offset
     * @param after true if the new offset should logically follow the provided
     * offset
     * @return the new offset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.575 -0500", hash_original_method = "31252F4808C2C77A1E467D2963FB3AD5", hash_generated_method = "3B29DCE9CCF68B664A34E6FC9DCA8B3C")
    
private int getOffsetBeforeAfter(int runIndex, int runStart, int runLimit,
            boolean runIsRtl, int offset, boolean after) {

        if (runIndex < 0 || offset == (after ? mLen : 0)) {
            // Walking off end of line.  Since we don't know
            // what cursor positions are available on other lines, we can't
            // return accurate values.  These are a guess.
            if (after) {
                return TextUtils.getOffsetAfter(mText, offset + mStart) - mStart;
            }
            return TextUtils.getOffsetBefore(mText, offset + mStart) - mStart;
        }

        TextPaint wp = mWorkPaint;
        wp.set(mPaint);

        int spanStart = runStart;
        int spanLimit;
        if (mSpanned == null) {
            spanLimit = runLimit;
        } else {
            int target = after ? offset + 1 : offset;
            int limit = mStart + runLimit;
            while (true) {
                spanLimit = mSpanned.nextSpanTransition(mStart + spanStart, limit,
                        MetricAffectingSpan.class) - mStart;
                if (spanLimit >= target) {
                    break;
                }
                spanStart = spanLimit;
            }

            MetricAffectingSpan[] spans = mSpanned.getSpans(mStart + spanStart,
                    mStart + spanLimit, MetricAffectingSpan.class);
            spans = TextUtils.removeEmptySpans(spans, mSpanned, MetricAffectingSpan.class);

            if (spans.length > 0) {
                ReplacementSpan replacement = null;
                for (int j = 0; j < spans.length; j++) {
                    MetricAffectingSpan span = spans[j];
                    if (span instanceof ReplacementSpan) {
                        replacement = (ReplacementSpan)span;
                    } else {
                        span.updateMeasureState(wp);
                    }
                }

                if (replacement != null) {
                    // If we have a replacement span, we're moving either to
                    // the start or end of this span.
                    return after ? spanLimit : spanStart;
                }
            }
        }

        int flags = runIsRtl ? Paint.DIRECTION_RTL : Paint.DIRECTION_LTR;
        int cursorOpt = after ? Paint.CURSOR_AFTER : Paint.CURSOR_BEFORE;
        if (mCharsValid) {
            return wp.getTextRunCursor(mChars, spanStart, spanLimit - spanStart,
                    flags, offset, cursorOpt);
        } else {
            return wp.getTextRunCursor(mText, mStart + spanStart,
                    mStart + spanLimit, flags, mStart + offset, cursorOpt) - mStart;
        }
    }

    /**
     * Utility function for measuring and rendering text.  The text must
     * not include a tab or emoji.
     *
     * @param wp the working paint
     * @param start the start of the text
     * @param end the end of the text
     * @param runIsRtl true if the run is right-to-left
     * @param c the canvas, can be null if rendering is not needed
     * @param x the edge of the run closest to the leading margin
     * @param top the top of the line
     * @param y the baseline
     * @param bottom the bottom of the line
     * @param fmi receives metrics information, can be null
     * @param needWidth true if the width of the run is needed
     * @return the signed width of the run based on the run direction; only
     * valid if needWidth is true
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.585 -0500", hash_original_method = "F8AC228F4E44CF9CD673B1404700AC77", hash_generated_method = "A35033C75A0CA6CDA8C6841148E74AFE")
    
private float handleText(TextPaint wp, int start, int end,
            int contextStart, int contextEnd, boolean runIsRtl,
            Canvas c, float x, int top, int y, int bottom,
            FontMetricsInt fmi, boolean needWidth) {

        // Get metrics first (even for empty strings or "0" width runs)
        if (fmi != null) {
            expandMetricsFromPaint(fmi, wp);
        }

        int runLen = end - start;
        // No need to do anything if the run width is "0"
        if (runLen == 0) {
            return 0f;
        }

        float ret = 0;

        int contextLen = contextEnd - contextStart;
        if (needWidth || (c != null && (wp.bgColor != 0 || wp.underlineColor != 0 || runIsRtl))) {
            int flags = runIsRtl ? Paint.DIRECTION_RTL : Paint.DIRECTION_LTR;
            if (mCharsValid) {
                ret = wp.getTextRunAdvances(mChars, start, runLen,
                        contextStart, contextLen, flags, null, 0);
            } else {
                int delta = mStart;
                ret = wp.getTextRunAdvances(mText, delta + start,
                        delta + end, delta + contextStart, delta + contextEnd,
                        flags, null, 0);
            }
        }

        if (c != null) {
            if (runIsRtl) {
                x -= ret;
            }

            if (wp.bgColor != 0) {
                int previousColor = wp.getColor();
                Paint.Style previousStyle = wp.getStyle();

                wp.setColor(wp.bgColor);
                wp.setStyle(Paint.Style.FILL);
                c.drawRect(x, top, x + ret, bottom, wp);

                wp.setStyle(previousStyle);
                wp.setColor(previousColor);
            }

            if (wp.underlineColor != 0) {
                // kStdUnderline_Offset = 1/9, defined in SkTextFormatParams.h
                float underlineTop = y + wp.baselineShift + (1.0f / 9.0f) * wp.getTextSize();

                int previousColor = wp.getColor();
                Paint.Style previousStyle = wp.getStyle();
                boolean previousAntiAlias = wp.isAntiAlias();

                wp.setStyle(Paint.Style.FILL);
                wp.setAntiAlias(true);

                wp.setColor(wp.underlineColor);
                c.drawRect(x, underlineTop, x + ret, underlineTop + wp.underlineThickness, wp);

                wp.setStyle(previousStyle);
                wp.setColor(previousColor);
                wp.setAntiAlias(previousAntiAlias);
            }

            drawTextRun(c, wp, start, end, contextStart, contextEnd, runIsRtl,
                    x, y + wp.baselineShift);
        }

        return runIsRtl ? -ret : ret;
    }

    /**
     * Utility function for measuring and rendering a replacement.
     *
     *
     * @param replacement the replacement
     * @param wp the work paint
     * @param start the start of the run
     * @param limit the limit of the run
     * @param runIsRtl true if the run is right-to-left
     * @param c the canvas, can be null if not rendering
     * @param x the edge of the replacement closest to the leading margin
     * @param top the top of the line
     * @param y the baseline
     * @param bottom the bottom of the line
     * @param fmi receives metrics information, can be null
     * @param needWidth true if the width of the replacement is needed
     * @return the signed width of the run based on the run direction; only
     * valid if needWidth is true
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.588 -0500", hash_original_method = "5BB6CBCB4177EDC48B270A42A6989FB0", hash_generated_method = "33DE32FBBCA6278A4F902767B055B176")
    
private float handleReplacement(ReplacementSpan replacement, TextPaint wp,
            int start, int limit, boolean runIsRtl, Canvas c,
            float x, int top, int y, int bottom, FontMetricsInt fmi,
            boolean needWidth) {

        float ret = 0;

        int textStart = mStart + start;
        int textLimit = mStart + limit;

        if (needWidth || (c != null && runIsRtl)) {
            int previousTop = 0;
            int previousAscent = 0;
            int previousDescent = 0;
            int previousBottom = 0;
            int previousLeading = 0;

            boolean needUpdateMetrics = (fmi != null);

            if (needUpdateMetrics) {
                previousTop     = fmi.top;
                previousAscent  = fmi.ascent;
                previousDescent = fmi.descent;
                previousBottom  = fmi.bottom;
                previousLeading = fmi.leading;
            }

            ret = replacement.getSize(wp, mText, textStart, textLimit, fmi);

            if (needUpdateMetrics) {
                updateMetrics(fmi, previousTop, previousAscent, previousDescent, previousBottom,
                        previousLeading);
            }
        }

        if (c != null) {
            if (runIsRtl) {
                x -= ret;
            }
            replacement.draw(c, mText, textStart, textLimit,
                    x, top, y, bottom, wp);
        }

        return runIsRtl ? -ret : ret;
    }

    /**
     * Utility function for handling a unidirectional run.  The run must not
     * contain tabs or emoji but can contain styles.
     *
     *
     * @param start the line-relative start of the run
     * @param measureLimit the offset to measure to, between start and limit inclusive
     * @param limit the limit of the run
     * @param runIsRtl true if the run is right-to-left
     * @param c the canvas, can be null
     * @param x the end of the run closest to the leading margin
     * @param top the top of the line
     * @param y the baseline
     * @param bottom the bottom of the line
     * @param fmi receives metrics information, can be null
     * @param needWidth true if the width is required
     * @return the signed width of the run based on the run direction; only
     * valid if needWidth is true
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.626 -0500", hash_original_method = "5FABB9B94E4E730AC35956B01320E35B", hash_generated_method = "647C09E9150E1DF7A08C2A55E51473BF")
    
private float handleRun(int start, int measureLimit,
            int limit, boolean runIsRtl, Canvas c, float x, int top, int y,
            int bottom, FontMetricsInt fmi, boolean needWidth) {

        // Case of an empty line, make sure we update fmi according to mPaint
        if (start == measureLimit) {
            TextPaint wp = mWorkPaint;
            wp.set(mPaint);
            if (fmi != null) {
                expandMetricsFromPaint(fmi, wp);
            }
            return 0f;
        }

        if (mSpanned == null) {
            TextPaint wp = mWorkPaint;
            wp.set(mPaint);
            final int mlimit = measureLimit;
            return handleText(wp, start, mlimit, start, limit, runIsRtl, c, x, top,
                    y, bottom, fmi, needWidth || mlimit < measureLimit);
        }

        mMetricAffectingSpanSpanSet.init(mSpanned, mStart + start, mStart + limit);
        mCharacterStyleSpanSet.init(mSpanned, mStart + start, mStart + limit);

        // Shaping needs to take into account context up to metric boundaries,
        // but rendering needs to take into account character style boundaries.
        // So we iterate through metric runs to get metric bounds,
        // then within each metric run iterate through character style runs
        // for the run bounds.
        final float originalX = x;
        for (int i = start, inext; i < measureLimit; i = inext) {
            TextPaint wp = mWorkPaint;
            wp.set(mPaint);

            inext = mMetricAffectingSpanSpanSet.getNextTransition(mStart + i, mStart + limit) -
                    mStart;
            int mlimit = Math.min(inext, measureLimit);

            ReplacementSpan replacement = null;

            for (int j = 0; j < mMetricAffectingSpanSpanSet.numberOfSpans; j++) {
                // Both intervals [spanStarts..spanEnds] and [mStart + i..mStart + mlimit] are NOT
                // empty by construction. This special case in getSpans() explains the >= & <= tests
                if ((mMetricAffectingSpanSpanSet.spanStarts[j] >= mStart + mlimit) ||
                        (mMetricAffectingSpanSpanSet.spanEnds[j] <= mStart + i)) continue;
                MetricAffectingSpan span = mMetricAffectingSpanSpanSet.spans[j];
                if (span instanceof ReplacementSpan) {
                    replacement = (ReplacementSpan)span;
                } else {
                    // We might have a replacement that uses the draw
                    // state, otherwise measure state would suffice.
                    span.updateDrawState(wp);
                }
            }

            if (replacement != null) {
                x += handleReplacement(replacement, wp, i, mlimit, runIsRtl, c, x, top, y,
                        bottom, fmi, needWidth || mlimit < measureLimit);
                continue;
            }

            if (c == null) {
                x += handleText(wp, i, mlimit, i, inext, runIsRtl, c, x, top,
                        y, bottom, fmi, needWidth || mlimit < measureLimit);
            } else {
                for (int j = i, jnext; j < mlimit; j = jnext) {
                    jnext = mCharacterStyleSpanSet.getNextTransition(mStart + j, mStart + mlimit) -
                            mStart;

                    wp.set(mPaint);
                    for (int k = 0; k < mCharacterStyleSpanSet.numberOfSpans; k++) {
                        // Intentionally using >= and <= as explained above
                        if ((mCharacterStyleSpanSet.spanStarts[k] >= mStart + jnext) ||
                                (mCharacterStyleSpanSet.spanEnds[k] <= mStart + j)) continue;

                        CharacterStyle span = mCharacterStyleSpanSet.spans[k];
                        span.updateDrawState(wp);
                    }

                    x += handleText(wp, j, jnext, i, inext, runIsRtl, c, x,
                            top, y, bottom, fmi, needWidth || jnext < measureLimit);
                }
            }
        }

        return x - originalX;
    }

    
    private static class SpanSet<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.591 -0500", hash_original_field = "4D016F914E51DC9C3732F557E45EB452", hash_generated_field = "4D016F914E51DC9C3732F557E45EB452")

        int numberOfSpans;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.594 -0500", hash_original_field = "32FCADE2328772A5D81411E0AA303B75", hash_generated_field = "32FCADE2328772A5D81411E0AA303B75")

        E[] spans;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.596 -0500", hash_original_field = "1D3712C585C8808C22172D42F4D7BB90", hash_generated_field = "1D3712C585C8808C22172D42F4D7BB90")

        int[] spanStarts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.599 -0500", hash_original_field = "8ED878CF75FF4569DFB3C4F0CC5B72F1", hash_generated_field = "8ED878CF75FF4569DFB3C4F0CC5B72F1")

        int[] spanEnds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.601 -0500", hash_original_field = "2E2862EF6D4B111BA84644CB0E9CD297", hash_generated_field = "2E2862EF6D4B111BA84644CB0E9CD297")

        int[] spanFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.604 -0500", hash_original_field = "7DE61887E85E1CD432AAA8825CCFB81E", hash_generated_field = "7DE61887E85E1CD432AAA8825CCFB81E")

         Class<? extends E> classType;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.607 -0500", hash_original_method = "08793871E7FAA5C02A5C5115CBB016E1", hash_generated_method = "08793871E7FAA5C02A5C5115CBB016E1")
        
SpanSet(Class<? extends E> type) {
            classType = type;
            numberOfSpans = 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.610 -0500", hash_original_method = "DCBC67B7023E3760B724E28392339389", hash_generated_method = "85BBEFD38B5ADEC0235D79876AF1921B")
        
@SuppressWarnings("unchecked")
        public void init(Spanned spanned, int start, int limit) {
            final E[] allSpans = spanned.getSpans(start, limit, classType);
            final int length = allSpans.length;

            if (length > 0 && (spans == null || spans.length < length)) {
                // These arrays may end up being too large because of empty spans
                spans = (E[]) Array.newInstance(classType, length);
                spanStarts = new int[length];
                spanEnds = new int[length];
                spanFlags = new int[length];
            }

            numberOfSpans = 0;
            for (int i = 0; i < length; i++) {
                final E span = allSpans[i];

                final int spanStart = spanned.getSpanStart(span);
                final int spanEnd = spanned.getSpanEnd(span);
                if (spanStart == spanEnd) continue;

                final int spanFlag = spanned.getSpanFlags(span);

                spans[numberOfSpans] = span;
                spanStarts[numberOfSpans] = spanStart;
                spanEnds[numberOfSpans] = spanEnd;
                spanFlags[numberOfSpans] = spanFlag;

                numberOfSpans++;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.613 -0500", hash_original_method = "14C2C64E52F272A1D061AF5FA0B61C4E", hash_generated_method = "9A7C8BF9006A1EC335D65C6B9DDE7474")
        
public boolean hasSpansIntersecting(int start, int end) {
            for (int i = 0; i < numberOfSpans; i++) {
                // equal test is valid since both intervals are not empty by construction
                if (spanStarts[i] >= end || spanEnds[i] <= start) continue;
                return true;
            }
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.616 -0500", hash_original_method = "70A36A49F9CEFC761501124E36FC2A8C", hash_generated_method = "70A36A49F9CEFC761501124E36FC2A8C")
        
int getNextTransition(int start, int limit) {
            for (int i = 0; i < numberOfSpans; i++) {
                final int spanStart = spanStarts[i];
                final int spanEnd = spanEnds[i];
                if (spanStart > start && spanStart < limit) limit = spanStart;
                if (spanEnd > start && spanEnd < limit) limit = spanEnd;
            }
            return limit;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.619 -0500", hash_original_method = "5E840A260140B15B0CFAF6F2BC649D6A", hash_generated_method = "DDAA6F255E30858B757EEDE4FC3D549D")
        
public void recycle() {
            // The spans array is guaranteed to be not null when numberOfSpans is > 0
            for (int i = 0; i < numberOfSpans; i++) {
                spans[i] = null; // prevent a leak: no reference kept when TextLine is recycled
            }
        }

        
    }

    /**
     * Render a text run with the set-up paint.
     *
     * @param c the canvas
     * @param wp the paint used to render the text
     * @param start the start of the run
     * @param end the end of the run
     * @param contextStart the start of context for the run
     * @param contextEnd the end of the context for the run
     * @param runIsRtl true if the run is right-to-left
     * @param x the x position of the left edge of the run
     * @param y the baseline of the run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.629 -0500", hash_original_method = "C8ABF2DC6B89611B840AEC4DBAADD344", hash_generated_method = "45DD593F42C875F9C50E96BA4C622377")
    
private void drawTextRun(Canvas c, TextPaint wp, int start, int end,
            int contextStart, int contextEnd, boolean runIsRtl, float x, int y) {

        int flags = runIsRtl ? Canvas.DIRECTION_RTL : Canvas.DIRECTION_LTR;
        if (mCharsValid) {
            int count = end - start;
            int contextCount = contextEnd - contextStart;
            c.drawTextRun(mChars, start, count, contextStart, contextCount,
                    x, y, flags, wp);
        } else {
            int delta = mStart;
            c.drawTextRun(mText, delta + start, delta + end,
                    delta + contextStart, delta + contextEnd, x, y, flags, wp);
        }
    }

    /**
     * Returns the ascent of the text at start.  This is used for scaling
     * emoji.
     *
     * @param pos the line-relative position
     * @return the ascent of the text at start
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.632 -0500", hash_original_method = "AC74D3C7A92A1C0DA8A76C86F50D3219", hash_generated_method = "AC74D3C7A92A1C0DA8A76C86F50D3219")
    
float ascent(int pos) {
        if (mSpanned == null) {
            return mPaint.ascent();
        }

        pos += mStart;
        MetricAffectingSpan[] spans = mSpanned.getSpans(pos, pos + 1, MetricAffectingSpan.class);
        if (spans.length == 0) {
            return mPaint.ascent();
        }

        TextPaint wp = mWorkPaint;
        wp.set(mPaint);
        for (MetricAffectingSpan span : spans) {
            span.updateMeasureState(wp);
        }
        return wp.ascent();
    }

    /**
     * Returns the next tab position.
     *
     * @param h the (unsigned) offset from the leading margin
     * @return the (unsigned) tab position after this offset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.634 -0500", hash_original_method = "73134044CD530D6AE99976E01BA5E625", hash_generated_method = "73134044CD530D6AE99976E01BA5E625")
    
float nextTab(float h) {
        if (mTabs != null) {
            return mTabs.nextTab(h);
        }
        return TabStops.nextDefaultStop(h, TAB_INCREMENT);
    }
}

