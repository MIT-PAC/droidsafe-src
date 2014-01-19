package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

import android.emoji.EmojiFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.method.TextKeyListener;
import android.text.style.AlignmentSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LeadingMarginSpan.LeadingMarginSpan2;
import android.text.style.LineBackgroundSpan;
import android.text.style.ParagraphStyle;
import android.text.style.ReplacementSpan;
import android.text.style.TabStopSpan;

import com.android.internal.util.ArrayUtils;

public abstract class Layout {

    /**
     * Return how wide a layout must be in order to display the
     * specified text with one line per paragraph.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.252 -0500", hash_original_method = "1597B0DF539C50975D1094B78D7BA08C", hash_generated_method = "2413E4414C0FEBD348BCD3878230BC25")
    
public static float getDesiredWidth(CharSequence source,
                                        TextPaint paint) {
        return getDesiredWidth(source, 0, source.length(), paint);
    }

    /**
     * Return how wide a layout must be in order to display the
     * specified text slice with one line per paragraph.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.255 -0500", hash_original_method = "70F93B7B36BD9F1CA7DABE2B88F9D9BC", hash_generated_method = "E19698407338714928F82BF4B18339BF")
    
public static float getDesiredWidth(CharSequence source,
                                        int start, int end,
                                        TextPaint paint) {
        float need = 0;
        TextPaint workPaint = new TextPaint();

        int next;
        for (int i = start; i <= end; i = next) {
            next = TextUtils.indexOf(source, '\n', i, end);

            if (next < 0)
                next = end;

            // note, omits trailing paragraph char
            float w = measurePara(paint, workPaint, source, i, next);

            if (w > need)
                need = w;

            next++;
        }

        return need;
    }

    /* package */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.427 -0500", hash_original_method = "7B0A64808977E314E16FC537E6BE92A2", hash_generated_method = "FED1B0E58631CF885CFF2382EE5FAA5C")
    
static float measurePara(TextPaint paint, TextPaint workPaint,
            CharSequence text, int start, int end) {

        MeasuredText mt = MeasuredText.obtain();
        TextLine tl = TextLine.obtain();
        try {
            mt.setPara(text, start, end, TextDirectionHeuristics.LTR);
            Directions directions;
            int dir;
            if (mt.mEasy) {
                directions = DIRS_ALL_LEFT_TO_RIGHT;
                dir = Layout.DIR_LEFT_TO_RIGHT;
            } else {
                directions = AndroidBidi.directions(mt.mDir, mt.mLevels,
                    0, mt.mChars, 0, mt.mLen);
                dir = mt.mDir;
            }
            char[] chars = mt.mChars;
            int len = mt.mLen;
            boolean hasTabs = false;
            TabStops tabStops = null;
            for (int i = 0; i < len; ++i) {
                if (chars[i] == '\t') {
                    hasTabs = true;
                    if (text instanceof Spanned) {
                        Spanned spanned = (Spanned) text;
                        int spanEnd = spanned.nextSpanTransition(start, end,
                                TabStopSpan.class);
                        TabStopSpan[] spans = getParagraphSpans(spanned, start, spanEnd,
                                TabStopSpan.class);
                        if (spans.length > 0) {
                            tabStops = new TabStops(TAB_INCREMENT, spans);
                        }
                    }
                    break;
                }
            }
            tl.set(paint, text, start, end, dir, directions, hasTabs, tabStops);
            return tl.metrics(null);
        } finally {
            TextLine.recycle(tl);
            MeasuredText.recycle(mt);
        }
    }

    /**
     * Returns the position of the next tab stop after h on the line.
     *
     * @param text the text
     * @param start start of the line
     * @param end limit of the line
     * @param h the current horizontal offset
     * @param tabs the tabs, can be null.  If it is null, any tabs in effect
     * on the line will be used.  If there are no tabs, a default offset
     * will be used to compute the tab stop.
     * @return the offset of the next tab stop.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.452 -0500", hash_original_method = "63723EF0B95DB45865B535A7B07F44F6", hash_generated_method = "E35782AC4B0B6B04DFA37943BF4BF52F")
    
static float nextTab(CharSequence text, int start, int end,
                                       float h, Object[] tabs) {
        float nh = Float.MAX_VALUE;
        boolean alltabs = false;

        if (text instanceof Spanned) {
            if (tabs == null) {
                tabs = getParagraphSpans((Spanned) text, start, end, TabStopSpan.class);
                alltabs = true;
            }

            for (int i = 0; i < tabs.length; i++) {
                if (!alltabs) {
                    if (!(tabs[i] instanceof TabStopSpan))
                        continue;
                }

                int where = ((TabStopSpan) tabs[i]).getTabStop();

                if (where < nh && where > h)
                    nh = where;
            }

            if (nh != Float.MAX_VALUE)
                return nh;
        }

        return ((int) ((h + TAB_INCREMENT) / TAB_INCREMENT)) * TAB_INCREMENT;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    static <T> T[] getParagraphSpans(Spanned text, int start, int end, Class<T> type) {
    	T[] retVal;
        if (start == end && start > 0) {
            retVal = (T[]) ArrayUtils.emptyArray(type);
        }
        retVal = text.getSpans(start, end, type);
        retVal.addTaint(text.getTaint());
        retVal.addTaint(start);
        retVal.addTaint(end);
        retVal.addTaint(type.getTaint());
        return retVal;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.244 -0500", hash_original_field = "932CE43DA88AC11362DFCBBD1ACF2606", hash_generated_field = "FE192F2602DC86D3649552171C1E7D82")

    private static final ParagraphStyle[] NO_PARA_SPANS =
        ArrayUtils.emptyArray(ParagraphStyle.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.247 -0500", hash_original_field = "2182FD9B1E42E85784EF7AA0D57C4686", hash_generated_field = "C5396A644D87D3ABF8FF4A210231B117")
 static final EmojiFactory EMOJI_FACTORY =
        EmojiFactory.newAvailableInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.972 -0400", hash_original_field = "471F949A3986C3F4EDFE65343195112B", hash_generated_field = "50981D9CDB8FFE37DD0AD7398C887F29")

    static int MIN_EMOJI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.972 -0400", hash_original_field = "9BA5E1F2A793A8D05CB1371A5403608D", hash_generated_field = "2FF41CCD8E77FA54D79A8CE87AE76CE2")

    static int MAX_EMOJI;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.555 -0500", hash_original_field = "008D661E54BF7ED509AC2785AB7BF6EB", hash_generated_field = "AB6A5E15DD892E72F299B4D5FFE1ACBA")

    private static final Rect sTempRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.562 -0500", hash_original_field = "274988CFFC045452B8896268E0741F10", hash_generated_field = "52D12843713C54C6D6FE037A484C039E")

    public static final int DIR_LEFT_TO_RIGHT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.566 -0500", hash_original_field = "61933AD26617D6849CFAE952C72D8914", hash_generated_field = "E624F93AD27646BB22CB05444CE41FB7")

    public static final int DIR_RIGHT_TO_LEFT = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.568 -0500", hash_original_field = "A1429EAE77EABD2EB8E5C4D967BD9AE9", hash_generated_field = "A0CBE122653FD7E9E2403F87AECC077E")
 static final int DIR_REQUEST_LTR = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.570 -0500", hash_original_field = "3EF9BAA120AB0D1CE69E1CC68129D39C", hash_generated_field = "2F54902E23F337B8398BD9B8867448B7")
 static final int DIR_REQUEST_RTL = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.573 -0500", hash_original_field = "4337E216F623C609AFC5BB37767A7AB4", hash_generated_field = "6BC95B8DA1C0867C5BBC92C545EC37D0")
 static final int DIR_REQUEST_DEFAULT_LTR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.575 -0500", hash_original_field = "FE9935885F94FA59C9FA9323EEEE9B09", hash_generated_field = "A3F4791226177B1A5BF0E7086C062229")
 static final int DIR_REQUEST_DEFAULT_RTL = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.578 -0500", hash_original_field = "49012C8971DD06FAF205C2FBA9AF8F4A", hash_generated_field = "521C40F9C42E64AFA41DE5429A1FE88F")
 static final int RUN_LENGTH_MASK = 0x03ffffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.580 -0500", hash_original_field = "4A10472F3D697F92EB8CA1466CAAE5B3", hash_generated_field = "FA295D4D1A0E6B715FE59ACD221F6ADA")
 static final int RUN_LEVEL_SHIFT = 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.583 -0500", hash_original_field = "7362A8B0CB2DB2FA71BCC4E4017A98F8", hash_generated_field = "94C9571A3583C54E6B7A075300DD0EE5")
 static final int RUN_LEVEL_MASK = 0x3f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.586 -0500", hash_original_field = "6CD5AF4251496E4F57DB2AC43ED61A39", hash_generated_field = "31D3CF26D80AD0E1199B880C73A98D4C")
 static final int RUN_RTL_FLAG = 1 << RUN_LEVEL_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.590 -0500", hash_original_field = "523B437B66E94D47C6D3407D5611D3C9", hash_generated_field = "D5E340FF9F0E2C74F920DF02A6624213")

    private static final int TAB_INCREMENT = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.592 -0500", hash_original_field = "8699269872F199A33E89295A39FFEB1B", hash_generated_field = "C8BA6950A23558C64F9FDDA3186A39D3")
 static final Directions DIRS_ALL_LEFT_TO_RIGHT =
        new Directions(new int[] { 0, RUN_LENGTH_MASK });
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.595 -0500", hash_original_field = "32D864628F20A4F6659228DF35F00938", hash_generated_field = "F0C0143EECF2B25DCBC74C3BF9B92427")
 static final Directions DIRS_ALL_RIGHT_TO_LEFT =
        new Directions(new int[] { 0, RUN_LENGTH_MASK | RUN_RTL_FLAG });
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.538 -0500", hash_original_field = "A59BBC07E5E46996D793B2F37E80BD24", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

    private CharSequence mText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.540 -0500", hash_original_field = "956DBF43153BA67BCB0E9C5A7787D348", hash_generated_field = "B5BC396C7010734D6B4B6ED34A2846AE")

    private TextPaint mPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.543 -0500", hash_original_field = "B28AC88C47D899E85CEE0110DCCDCA16", hash_generated_field = "B28AC88C47D899E85CEE0110DCCDCA16")
 TextPaint mWorkPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.545 -0500", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.547 -0500", hash_original_field = "E5A75855A12AE2E5083C772727973580", hash_generated_field = "A5FBEE576828FD767B418A1715D12197")

    private Alignment mAlignment = Alignment.ALIGN_NORMAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.550 -0500", hash_original_field = "EBA2C53A78B31B6EAA62BF30691EAAD7", hash_generated_field = "0C2C39C12F42C181B35D16CF7D81A703")

    private float mSpacingMult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.552 -0500", hash_original_field = "0C08CDB9A206CD48C2F03C72632F8C5E", hash_generated_field = "733F92CD6EAB2F9CA67542D073A49D69")

    private float mSpacingAdd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.557 -0500", hash_original_field = "6D3F268E06ADF0B0EDB64F30D89ABD7E", hash_generated_field = "9735AD2A3473CB2D7DEA16EAA46F6EFB")

    private boolean mSpannedText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.560 -0500", hash_original_field = "BEA8E5891FFC501B6383D60AC2DCC890", hash_generated_field = "720F1C3BB08BF46839EBBA716D35B07F")

    private TextDirectionHeuristic mTextDir;

    /**
     * Subclasses of Layout use this constructor to set the display text,
     * width, and other standard properties.
     * @param text the text to render
     * @param paint the default paint for the layout.  Styles can override
     * various attributes of the paint.
     * @param width the wrapping width for the text.
     * @param align whether to left, right, or center the text.  Styles can
     * override the alignment.
     * @param spacingMult factor by which to scale the font size to get the
     * default line spacing
     * @param spacingAdd amount to add to the default line spacing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.258 -0500", hash_original_method = "DA432A00E31F4EFC04FE32B9AEC1CEE4", hash_generated_method = "E8525190E49DFD371F81054B27CE4BBC")
    
protected Layout(CharSequence text, TextPaint paint,
                     int width, Alignment align,
                     float spacingMult, float spacingAdd) {
        this(text, paint, width, align, TextDirectionHeuristics.FIRSTSTRONG_LTR,
                spacingMult, spacingAdd);
    }

    /**
     * Subclasses of Layout use this constructor to set the display text,
     * width, and other standard properties.
     * @param text the text to render
     * @param paint the default paint for the layout.  Styles can override
     * various attributes of the paint.
     * @param width the wrapping width for the text.
     * @param align whether to left, right, or center the text.  Styles can
     * override the alignment.
     * @param spacingMult factor by which to scale the font size to get the
     * default line spacing
     * @param spacingAdd amount to add to the default line spacing
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.261 -0500", hash_original_method = "E08E539EEFF1AD274546B85662DC9DCC", hash_generated_method = "ECEEC996AC846B781ED18C214467C750")
    
protected Layout(CharSequence text, TextPaint paint,
                     int width, Alignment align, TextDirectionHeuristic textDir,
                     float spacingMult, float spacingAdd) {

        if (width < 0)
            throw new IllegalArgumentException("Layout: " + width + " < 0");

        // Ensure paint doesn't have baselineShift set.
        // While normally we don't modify the paint the user passed in,
        // we were already doing this in Styled.drawUniformRun with both
        // baselineShift and bgColor.  We probably should reevaluate bgColor.
        if (paint != null) {
            paint.bgColor = 0;
            paint.baselineShift = 0;
        }

        mText = text;
        mPaint = paint;
        mWorkPaint = new TextPaint();
        mWidth = width;
        mAlignment = align;
        mSpacingMult = spacingMult;
        mSpacingAdd = spacingAdd;
        mSpannedText = text instanceof Spanned;
        mTextDir = textDir;
    }

    /**
     * Replace constructor properties of this Layout with new ones.  Be careful.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.264 -0500", hash_original_method = "4BA809AE232557C36D4CE5AE6E36D4D2", hash_generated_method = "4BA809AE232557C36D4CE5AE6E36D4D2")
    
void replaceWith(CharSequence text, TextPaint paint,
                              int width, Alignment align,
                              float spacingmult, float spacingadd) {
        if (width < 0) {
            throw new IllegalArgumentException("Layout: " + width + " < 0");
        }

        mText = text;
        mPaint = paint;
        mWidth = width;
        mAlignment = align;
        mSpacingMult = spacingmult;
        mSpacingAdd = spacingadd;
        mSpannedText = text instanceof Spanned;
    }

    /**
     * Draw this Layout on the specified Canvas.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.266 -0500", hash_original_method = "21986991A7FC788A39082240DAE8B9C3", hash_generated_method = "8EE65159161E744299A4C08E81C8EA55")
    
public void draw(Canvas c) {
        draw(c, null, null, 0);
    }

    /**
     * Draw this Layout on the specified canvas, with the highlight path drawn
     * between the background and the text.
     *
     * @param c the canvas
     * @param highlight the path of the highlight or cursor; can be null
     * @param highlightPaint the paint for the highlight
     * @param cursorOffsetVertical the amount to temporarily translate the
     *        canvas while rendering the highlight
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.273 -0500", hash_original_method = "C63D8686FF6D60F338825542CA174C93", hash_generated_method = "6D6B5D7F8BAC5492A7781593E3D44FE0")
    
public void draw(Canvas c, Path highlight, Paint highlightPaint,
                     int cursorOffsetVertical) {
        int dtop, dbottom;

        synchronized (sTempRect) {
            if (!c.getClipBounds(sTempRect)) {
                return;
            }

            dtop = sTempRect.top;
            dbottom = sTempRect.bottom;
        }

        int top = 0;
        int bottom = getLineTop(getLineCount());

        if (dtop > top) {
            top = dtop;
        }
        if (dbottom < bottom) {
            bottom = dbottom;
        }

        int first = getLineForVertical(top);
        int last = getLineForVertical(bottom);

        int previousLineBottom = getLineTop(first);
        int previousLineEnd = getLineStart(first);

        TextPaint paint = mPaint;
        CharSequence buf = mText;
        int width = mWidth;
        boolean spannedText = mSpannedText;

        ParagraphStyle[] spans = NO_PARA_SPANS;
        int spanEnd = 0;
        int textLength = 0;

        // First, draw LineBackgroundSpans.
        // LineBackgroundSpans know nothing about the alignment, margins, or
        // direction of the layout or line.  XXX: Should they?
        // They are evaluated at each line.
        if (spannedText) {
            Spanned sp = (Spanned) buf;
            textLength = buf.length();
            for (int i = first; i <= last; i++) {
                int start = previousLineEnd;
                int end = getLineStart(i+1);
                previousLineEnd = end;

                int ltop = previousLineBottom;
                int lbottom = getLineTop(i+1);
                previousLineBottom = lbottom;
                int lbaseline = lbottom - getLineDescent(i);

                if (start >= spanEnd) {
                    // These should be infrequent, so we'll use this so that
                    // we don't have to check as often.
                    spanEnd = sp.nextSpanTransition(start, textLength,
                            LineBackgroundSpan.class);
                    // All LineBackgroundSpans on a line contribute to its
                    // background.
                   spans = getParagraphSpans(sp, start, end, LineBackgroundSpan.class);
                }

                for (int n = 0; n < spans.length; n++) {
                    LineBackgroundSpan back = (LineBackgroundSpan) spans[n];

                    back.drawBackground(c, paint, 0, width,
                                       ltop, lbaseline, lbottom,
                                       buf, start, end,
                                       i);
                }
            }
            // reset to their original values
            spanEnd = 0;
            previousLineBottom = getLineTop(first);
            previousLineEnd = getLineStart(first);
            spans = NO_PARA_SPANS;
        }

        // There can be a highlight even without spans if we are drawing
        // a non-spanned transformation of a spanned editing buffer.
        if (highlight != null) {
            if (cursorOffsetVertical != 0) {
                c.translate(0, cursorOffsetVertical);
            }

            c.drawPath(highlight, highlightPaint);

            if (cursorOffsetVertical != 0) {
                c.translate(0, -cursorOffsetVertical);
            }
        }

        Alignment paraAlign = mAlignment;
        TabStops tabStops = null;
        boolean tabStopsIsInitialized = false;

        TextLine tl = TextLine.obtain();

        // Next draw the lines, one at a time.
        // the baseline is the top of the following line minus the current
        // line's descent.
        for (int i = first; i <= last; i++) {
            int start = previousLineEnd;

            previousLineEnd = getLineStart(i+1);
            int end = getLineVisibleEnd(i, start, previousLineEnd);

            int ltop = previousLineBottom;
            int lbottom = getLineTop(i+1);
            previousLineBottom = lbottom;
            int lbaseline = lbottom - getLineDescent(i);

            int dir = getParagraphDirection(i);
            int left = 0;
            int right = mWidth;

            if (spannedText) {
                Spanned sp = (Spanned) buf;
                boolean isFirstParaLine = (start == 0 ||
                        buf.charAt(start - 1) == '\n');

                // New batch of paragraph styles, collect into spans array.
                // Compute the alignment, last alignment style wins.
                // Reset tabStops, we'll rebuild if we encounter a line with
                // tabs.
                // We expect paragraph spans to be relatively infrequent, use
                // spanEnd so that we can check less frequently.  Since
                // paragraph styles ought to apply to entire paragraphs, we can
                // just collect the ones present at the start of the paragraph.
                // If spanEnd is before the end of the paragraph, that's not
                // our problem.
                if (start >= spanEnd && (i == first || isFirstParaLine)) {
                    spanEnd = sp.nextSpanTransition(start, textLength,
                                                    ParagraphStyle.class);
                    spans = getParagraphSpans(sp, start, spanEnd, ParagraphStyle.class);

                    paraAlign = mAlignment;
                    for (int n = spans.length-1; n >= 0; n--) {
                        if (spans[n] instanceof AlignmentSpan) {
                            paraAlign = ((AlignmentSpan) spans[n]).getAlignment();
                            break;
                        }
                    }

                    tabStopsIsInitialized = false;
                }

                // Draw all leading margin spans.  Adjust left or right according
                // to the paragraph direction of the line.
                final int length = spans.length;
                for (int n = 0; n < length; n++) {
                    if (spans[n] instanceof LeadingMarginSpan) {
                        LeadingMarginSpan margin = (LeadingMarginSpan) spans[n];
                        boolean useFirstLineMargin = isFirstParaLine;
                        if (margin instanceof LeadingMarginSpan2) {
                            int count = ((LeadingMarginSpan2) margin).getLeadingMarginLineCount();
                            int startLine = getLineForOffset(sp.getSpanStart(margin));
                            useFirstLineMargin = i < startLine + count;
                        }

                        if (dir == DIR_RIGHT_TO_LEFT) {
                            margin.drawLeadingMargin(c, paint, right, dir, ltop,
                                                     lbaseline, lbottom, buf,
                                                     start, end, isFirstParaLine, this);
                            right -= margin.getLeadingMargin(useFirstLineMargin);
                        } else {
                            margin.drawLeadingMargin(c, paint, left, dir, ltop,
                                                     lbaseline, lbottom, buf,
                                                     start, end, isFirstParaLine, this);
                            left += margin.getLeadingMargin(useFirstLineMargin);
                        }
                    }
                }
            }

            boolean hasTabOrEmoji = getLineContainsTab(i);
            // Can't tell if we have tabs for sure, currently
            if (hasTabOrEmoji && !tabStopsIsInitialized) {
                if (tabStops == null) {
                    tabStops = new TabStops(TAB_INCREMENT, spans);
                } else {
                    tabStops.reset(TAB_INCREMENT, spans);
                }
                tabStopsIsInitialized = true;
            }

            // Determine whether the line aligns to normal, opposite, or center.
            Alignment align = paraAlign;
            if (align == Alignment.ALIGN_LEFT) {
                align = (dir == DIR_LEFT_TO_RIGHT) ?
                    Alignment.ALIGN_NORMAL : Alignment.ALIGN_OPPOSITE;
            } else if (align == Alignment.ALIGN_RIGHT) {
                align = (dir == DIR_LEFT_TO_RIGHT) ?
                    Alignment.ALIGN_OPPOSITE : Alignment.ALIGN_NORMAL;
            }

            int x;
            if (align == Alignment.ALIGN_NORMAL) {
                if (dir == DIR_LEFT_TO_RIGHT) {
                    x = left;
                } else {
                    x = right;
                }
            } else {
                int max = (int)getLineExtent(i, tabStops, false);
                if (align == Alignment.ALIGN_OPPOSITE) {
                    if (dir == DIR_LEFT_TO_RIGHT) {
                        x = right - max;
                    } else {
                        x = left - max;
                    }
                } else { // Alignment.ALIGN_CENTER
                    max = max & ~1;
                    x = (right + left - max) >> 1;
                }
            }

            Directions directions = getLineDirections(i);
            if (directions == DIRS_ALL_LEFT_TO_RIGHT &&
                    !spannedText && !hasTabOrEmoji) {
                // XXX: assumes there's nothing additional to be done
                c.drawText(buf, start, end, x, lbaseline, paint);
            } else {
                tl.set(paint, buf, start, end, dir, directions, hasTabOrEmoji, tabStops);
                tl.draw(c, x, ltop, lbaseline, lbottom);
            }
        }

        TextLine.recycle(tl);
    }

    /**
     * Return the start position of the line, given the left and right bounds
     * of the margins.
     *
     * @param line the line index
     * @param left the left bounds (0, or leading margin if ltr para)
     * @param right the right bounds (width, minus leading margin if rtl para)
     * @return the start position of the line (to right of line if rtl para)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.277 -0500", hash_original_method = "94C8B0A33C8A9972488E17891E7B8BAC", hash_generated_method = "11B6DD88F00DBC5D783B97DC24C1AE9F")
    
private int getLineStartPos(int line, int left, int right) {
        // Adjust the point at which to start rendering depending on the
        // alignment of the paragraph.
        Alignment align = getParagraphAlignment(line);
        int dir = getParagraphDirection(line);

        int x;
        if (align == Alignment.ALIGN_LEFT) {
            x = left;
        } else if (align == Alignment.ALIGN_NORMAL) {
            if (dir == DIR_LEFT_TO_RIGHT) {
                x = left;
            } else {
                x = right;
            }
        } else {
            TabStops tabStops = null;
            if (mSpannedText && getLineContainsTab(line)) {
                Spanned spanned = (Spanned) mText;
                int start = getLineStart(line);
                int spanEnd = spanned.nextSpanTransition(start, spanned.length(),
                        TabStopSpan.class);
                TabStopSpan[] tabSpans = getParagraphSpans(spanned, start, spanEnd, TabStopSpan.class);
                if (tabSpans.length > 0) {
                    tabStops = new TabStops(TAB_INCREMENT, tabSpans);
                }
            }
            int max = (int)getLineExtent(line, tabStops, false);
            if (align == Alignment.ALIGN_RIGHT) {
                x = right - max;
            } else if (align == Alignment.ALIGN_OPPOSITE) {
                if (dir == DIR_LEFT_TO_RIGHT) {
                    x = right - max;
                } else {
                    x = left - max;
                }
            } else { // Alignment.ALIGN_CENTER
                max = max & ~1;
                x = (left + right - max) >> 1;
            }
        }
        return x;
    }

    /**
     * Return the text that is displayed by this Layout.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.280 -0500", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "AD41DE29B1C2DCE99B6C37C431B0FBB9")
    
public final CharSequence getText() {
        return mText;
    }

    /**
     * Return the base Paint properties for this layout.
     * Do NOT change the paint, which may result in funny
     * drawing for this layout.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.282 -0500", hash_original_method = "7064C5093467A23605D5C425E4D25B83", hash_generated_method = "A1B666BE245BAE87971A84F2CF98551B")
    
public final TextPaint getPaint() {
        return mPaint;
    }

    /**
     * Return the width of this layout.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.285 -0500", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "22D52A618BDF0D88616879C17C111A4F")
    
public final int getWidth() {
        return mWidth;
    }

    /**
     * Return the width to which this Layout is ellipsizing, or
     * {@link #getWidth} if it is not doing anything special.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.287 -0500", hash_original_method = "90F96A059D406483E44444E82D555D1F", hash_generated_method = "E7219D99AC51B07E456390F92E1768EC")
    
public int getEllipsizedWidth() {
        return mWidth;
    }

    /**
     * Increase the width of this layout to the specified width.
     * Be careful to use this only when you know it is appropriate&mdash;
     * it does not cause the text to reflow to use the full new width.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.290 -0500", hash_original_method = "461CE12B89AFCA61718D5C5F590357B0", hash_generated_method = "6EEFA7E9C5DE9882F0EDA06E870DF63D")
    
public final void increaseWidthTo(int wid) {
        if (wid < mWidth) {
            throw new RuntimeException("attempted to reduce Layout width");
        }

        mWidth = wid;
    }

    /**
     * Return the total height of this layout.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.292 -0500", hash_original_method = "5212B162F472F11B6A60B5BD891C860A", hash_generated_method = "01D9C5CB97CB8F7EF4A0983825580515")
    
public int getHeight() {
        return getLineTop(getLineCount());
    }

    /**
     * Return the base alignment of this layout.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.294 -0500", hash_original_method = "FB2D4D43E3EFDD971010AB3AFA49B442", hash_generated_method = "FA640E70D6B992C4BEBCC5C17D69AEBD")
    
public final Alignment getAlignment() {
        return mAlignment;
    }

    /**
     * Return what the text height is multiplied by to get the line height.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.296 -0500", hash_original_method = "F861D6694D511E0A8AF4CE2A5552F333", hash_generated_method = "6D96E1ECB0C174A9EDA879AB77379863")
    
public final float getSpacingMultiplier() {
        return mSpacingMult;
    }

    /**
     * Return the number of units of leading that are added to each line.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.299 -0500", hash_original_method = "E15AF37508F3C3C8F31DF2917343152C", hash_generated_method = "2E7B3A64CBB02E47FC166BB25D32A16B")
    
public final float getSpacingAdd() {
        return mSpacingAdd;
    }

    /**
     * Return the heuristic used to determine paragraph text direction.
     * @hide
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.302 -0500", hash_original_method = "CEF29A1F61D81E3972548E19A0D7158C", hash_generated_method = "37EDBC3BC62434E13DFAD301F3A917B2")
    
public final TextDirectionHeuristic getTextDirectionHeuristic() {
        return mTextDir;
    }

    /**
     * Return the number of lines of text in this layout.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.305 -0500", hash_original_method = "C858DDC0C1BAD267278CEAB898350F70", hash_generated_method = "26F9A607A463611061DC3AF5F4989C06")
    
public abstract int getLineCount();

    /**
     * Return the baseline for the specified line (0&hellip;getLineCount() - 1)
     * If bounds is not null, return the top, left, right, bottom extents
     * of the specified line in it.
     * @param line which line to examine (0..getLineCount() - 1)
     * @param bounds Optional. If not null, it returns the extent of the line
     * @return the Y-coordinate of the baseline
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.307 -0500", hash_original_method = "6295516BE4612811C14BD1DCED80BAB8", hash_generated_method = "728D9A8BCD139769BF63031581888C94")
    
public int getLineBounds(int line, Rect bounds) {
        if (bounds != null) {
            bounds.left = 0;     // ???
            bounds.top = getLineTop(line);
            bounds.right = mWidth;   // ???
            bounds.bottom = getLineTop(line + 1);
        }
        return getLineBaseline(line);
    }

    /**
     * Return the vertical position of the top of the specified line
     * (0&hellip;getLineCount()).
     * If the specified line is equal to the line count, returns the
     * bottom of the last line.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.310 -0500", hash_original_method = "A479D88314A093B8C2D849C09BDF783F", hash_generated_method = "D7223F3967A936CA40F1E9C5B7F55E34")
    
public abstract int getLineTop(int line);

    /**
     * Return the descent of the specified line(0&hellip;getLineCount() - 1).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.313 -0500", hash_original_method = "03140D6C234EA23E99CFD1E22FA56375", hash_generated_method = "D7CA1E509DA090D89EFE25AF998BE18E")
    
public abstract int getLineDescent(int line);

    /**
     * Return the text offset of the beginning of the specified line (
     * 0&hellip;getLineCount()). If the specified line is equal to the line
     * count, returns the length of the text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.315 -0500", hash_original_method = "AD4C0CF9A9707EC9B109DA8B3FD4D354", hash_generated_method = "61055093AF86441AE67056D61EBB630B")
    
public abstract int getLineStart(int line);

    /**
     * Returns the primary directionality of the paragraph containing the
     * specified line, either 1 for left-to-right lines, or -1 for right-to-left
     * lines (see {@link #DIR_LEFT_TO_RIGHT}, {@link #DIR_RIGHT_TO_LEFT}).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.318 -0500", hash_original_method = "1F6293537B18553FE2358B8478EBFAEE", hash_generated_method = "69AF98149A08FF9A3435421DE154B7DE")
    
public abstract int getParagraphDirection(int line);

    /**
     * Returns whether the specified line contains one or more
     * characters that need to be handled specially, like tabs
     * or emoji.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.320 -0500", hash_original_method = "2BAA05C8EA3FC25EBF2014880F15841F", hash_generated_method = "626214B760C74C35D95DB221DB2C3B12")
    
public abstract boolean getLineContainsTab(int line);

    /**
     * Returns the directional run information for the specified line.
     * The array alternates counts of characters in left-to-right
     * and right-to-left segments of the line.
     *
     * <p>NOTE: this is inadequate to support bidirectional text, and will change.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.323 -0500", hash_original_method = "210ABB60838D612932495B5E68C265E6", hash_generated_method = "D859D6004F6B3046ABF936118536AFDC")
    
public abstract Directions getLineDirections(int line);

    /**
     * Returns the (negative) number of extra pixels of ascent padding in the
     * top line of the Layout.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.325 -0500", hash_original_method = "203B4D132BED8A34E1E9144178389DA9", hash_generated_method = "64E1A39A214A9F5A5E503B5D5C1841F2")
    
public abstract int getTopPadding();

    /**
     * Returns the number of extra pixels of descent padding in the
     * bottom line of the Layout.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.327 -0500", hash_original_method = "36186ABA54E56DB57B8D8035164D19BC", hash_generated_method = "EF263A3F424EDC36F744E769CE4C50BB")
    
public abstract int getBottomPadding();

    /**
     * Returns true if the character at offset and the preceding character
     * are at different run levels (and thus there's a split caret).
     * @param offset the offset
     * @return true if at a level boundary
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.331 -0500", hash_original_method = "2C3949CE81E6BE871356E85B216A576F", hash_generated_method = "183A814B3D3806E68915D483C8E8871E")
    
public boolean isLevelBoundary(int offset) {
        int line = getLineForOffset(offset);
        Directions dirs = getLineDirections(line);
        if (dirs == DIRS_ALL_LEFT_TO_RIGHT || dirs == DIRS_ALL_RIGHT_TO_LEFT) {
            return false;
        }

        int[] runs = dirs.mDirections;
        int lineStart = getLineStart(line);
        int lineEnd = getLineEnd(line);
        if (offset == lineStart || offset == lineEnd) {
            int paraLevel = getParagraphDirection(line) == 1 ? 0 : 1;
            int runIndex = offset == lineStart ? 0 : runs.length - 2;
            return ((runs[runIndex + 1] >>> RUN_LEVEL_SHIFT) & RUN_LEVEL_MASK) != paraLevel;
        }

        offset -= lineStart;
        for (int i = 0; i < runs.length; i += 2) {
            if (offset == runs[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if the character at offset is right to left (RTL).
     * @param offset the offset
     * @return true if the character is RTL, false if it is LTR
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.333 -0500", hash_original_method = "AF5CCAD1718916CFF1EB4C8EF2E12FAE", hash_generated_method = "95B2033BED91E0E1C361CEFA7C0ED861")
    
public boolean isRtlCharAt(int offset) {
        int line = getLineForOffset(offset);
        Directions dirs = getLineDirections(line);
        if (dirs == DIRS_ALL_LEFT_TO_RIGHT) {
            return false;
        }
        if (dirs == DIRS_ALL_RIGHT_TO_LEFT) {
            return  true;
        }
        int[] runs = dirs.mDirections;
        int lineStart = getLineStart(line);
        for (int i = 0; i < runs.length; i += 2) {
            int start = lineStart + (runs[i] & RUN_LENGTH_MASK);
            // No need to test the end as an offset after the last run should return the value
            // corresponding of the last run
            if (offset >= start) {
                int level = (runs[i+1] >>> RUN_LEVEL_SHIFT) & RUN_LEVEL_MASK;
                return ((level & 1) != 0);
            }
        }
        // Should happen only if the offset is "out of bounds"
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.337 -0500", hash_original_method = "2802B19F8A9E2D0D463FD305FA66136A", hash_generated_method = "50FC3B2D69D294105C536DC818DE545D")
    
private boolean primaryIsTrailingPrevious(int offset) {
        int line = getLineForOffset(offset);
        int lineStart = getLineStart(line);
        int lineEnd = getLineEnd(line);
        int[] runs = getLineDirections(line).mDirections;

        int levelAt = -1;
        for (int i = 0; i < runs.length; i += 2) {
            int start = lineStart + runs[i];
            int limit = start + (runs[i+1] & RUN_LENGTH_MASK);
            if (limit > lineEnd) {
                limit = lineEnd;
            }
            if (offset >= start && offset < limit) {
                if (offset > start) {
                    // Previous character is at same level, so don't use trailing.
                    return false;
                }
                levelAt = (runs[i+1] >>> RUN_LEVEL_SHIFT) & RUN_LEVEL_MASK;
                break;
            }
        }
        if (levelAt == -1) {
            // Offset was limit of line.
            levelAt = getParagraphDirection(line) == 1 ? 0 : 1;
        }

        // At level boundary, check previous level.
        int levelBefore = -1;
        if (offset == lineStart) {
            levelBefore = getParagraphDirection(line) == 1 ? 0 : 1;
        } else {
            offset -= 1;
            for (int i = 0; i < runs.length; i += 2) {
                int start = lineStart + runs[i];
                int limit = start + (runs[i+1] & RUN_LENGTH_MASK);
                if (limit > lineEnd) {
                    limit = lineEnd;
                }
                if (offset >= start && offset < limit) {
                    levelBefore = (runs[i+1] >>> RUN_LEVEL_SHIFT) & RUN_LEVEL_MASK;
                    break;
                }
            }
        }

        return levelBefore < levelAt;
    }

    /**
     * Get the primary horizontal position for the specified text offset.
     * This is the location where a new character would be inserted in
     * the paragraph's primary direction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.340 -0500", hash_original_method = "80ABC300097314837E01431F08FED39C", hash_generated_method = "9B4AE6B1658DB85323FD2387B1068EB8")
    
public float getPrimaryHorizontal(int offset) {
        boolean trailing = primaryIsTrailingPrevious(offset);
        return getHorizontal(offset, trailing);
    }

    /**
     * Get the secondary horizontal position for the specified text offset.
     * This is the location where a new character would be inserted in
     * the direction other than the paragraph's primary direction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.343 -0500", hash_original_method = "5EA78F3566FFC0563802F8455C66332C", hash_generated_method = "0F79438CEB1C5845DC66AA4C325AE230")
    
public float getSecondaryHorizontal(int offset) {
        boolean trailing = primaryIsTrailingPrevious(offset);
        return getHorizontal(offset, !trailing);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.345 -0500", hash_original_method = "A6F47D9472D86FF595A17085495F07A6", hash_generated_method = "E0DF0D7927C49E1B310EECDB2E494565")
    
private float getHorizontal(int offset, boolean trailing) {
        int line = getLineForOffset(offset);

        return getHorizontal(offset, trailing, line);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.348 -0500", hash_original_method = "B47A0ABADD57DE266AAF87A7E699E873", hash_generated_method = "4047DC4C00DF16164DC49AE2D24D687C")
    
private float getHorizontal(int offset, boolean trailing, int line) {
        int start = getLineStart(line);
        int end = getLineEnd(line);
        int dir = getParagraphDirection(line);
        boolean hasTabOrEmoji = getLineContainsTab(line);
        Directions directions = getLineDirections(line);

        TabStops tabStops = null;
        if (hasTabOrEmoji && mText instanceof Spanned) {
            // Just checking this line should be good enough, tabs should be
            // consistent across all lines in a paragraph.
            TabStopSpan[] tabs = getParagraphSpans((Spanned) mText, start, end, TabStopSpan.class);
            if (tabs.length > 0) {
                tabStops = new TabStops(TAB_INCREMENT, tabs); // XXX should reuse
            }
        }

        TextLine tl = TextLine.obtain();
        tl.set(mPaint, mText, start, end, dir, directions, hasTabOrEmoji, tabStops);
        float wid = tl.measure(offset - start, trailing, null);
        TextLine.recycle(tl);

        int left = getParagraphLeft(line);
        int right = getParagraphRight(line);

        return getLineStartPos(line, left, right) + wid;
    }

    /**
     * Get the leftmost position that should be exposed for horizontal
     * scrolling on the specified line.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.351 -0500", hash_original_method = "185391EA60FA7533A9126C3E791BF275", hash_generated_method = "E620055286D6375EB43D2B6D4A244CA1")
    
public float getLineLeft(int line) {
        int dir = getParagraphDirection(line);
        Alignment align = getParagraphAlignment(line);

        if (align == Alignment.ALIGN_LEFT) {
            return 0;
        } else if (align == Alignment.ALIGN_NORMAL) {
            if (dir == DIR_RIGHT_TO_LEFT)
                return getParagraphRight(line) - getLineMax(line);
            else
                return 0;
        } else if (align == Alignment.ALIGN_RIGHT) {
            return mWidth - getLineMax(line);
        } else if (align == Alignment.ALIGN_OPPOSITE) {
            if (dir == DIR_RIGHT_TO_LEFT)
                return 0;
            else
                return mWidth - getLineMax(line);
        } else { /* align == Alignment.ALIGN_CENTER */
            int left = getParagraphLeft(line);
            int right = getParagraphRight(line);
            int max = ((int) getLineMax(line)) & ~1;

            return left + ((right - left) - max) / 2;
        }
    }

    /**
     * Get the rightmost position that should be exposed for horizontal
     * scrolling on the specified line.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.354 -0500", hash_original_method = "D344E3703EA76C4344B547792AB00F8E", hash_generated_method = "46B4D0C776DD5C5CEB17F101A7835895")
    
public float getLineRight(int line) {
        int dir = getParagraphDirection(line);
        Alignment align = getParagraphAlignment(line);

        if (align == Alignment.ALIGN_LEFT) {
            return getParagraphLeft(line) + getLineMax(line);
        } else if (align == Alignment.ALIGN_NORMAL) {
            if (dir == DIR_RIGHT_TO_LEFT)
                return mWidth;
            else
                return getParagraphLeft(line) + getLineMax(line);
        } else if (align == Alignment.ALIGN_RIGHT) {
            return mWidth;
        } else if (align == Alignment.ALIGN_OPPOSITE) {
            if (dir == DIR_RIGHT_TO_LEFT)
                return getLineMax(line);
            else
                return mWidth;
        } else { /* align == Alignment.ALIGN_CENTER */
            int left = getParagraphLeft(line);
            int right = getParagraphRight(line);
            int max = ((int) getLineMax(line)) & ~1;

            return right - ((right - left) - max) / 2;
        }
    }

    /**
     * Gets the unsigned horizontal extent of the specified line, including
     * leading margin indent, but excluding trailing whitespace.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.357 -0500", hash_original_method = "F9A5FD2221E6CC8B07379CD2792C3C3D", hash_generated_method = "B119E3440FEDD3D9F499A55C08208B73")
    
public float getLineMax(int line) {
        float margin = getParagraphLeadingMargin(line);
        float signedExtent = getLineExtent(line, false);
        return margin + signedExtent >= 0 ? signedExtent : -signedExtent;
    }

    /**
     * Gets the unsigned horizontal extent of the specified line, including
     * leading margin indent and trailing whitespace.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.359 -0500", hash_original_method = "71AEB5E1BA96E910342AC0DBF85E1ED1", hash_generated_method = "0F4F8FF2C0501E3545D1A964E3770028")
    
public float getLineWidth(int line) {
        float margin = getParagraphLeadingMargin(line);
        float signedExtent = getLineExtent(line, true);
        return margin + signedExtent >= 0 ? signedExtent : -signedExtent;
    }

    /**
     * Like {@link #getLineExtent(int,TabStops,boolean)} but determines the
     * tab stops instead of using the ones passed in.
     * @param line the index of the line
     * @param full whether to include trailing whitespace
     * @return the extent of the line
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.363 -0500", hash_original_method = "22E5E0C81FE58627900045F7BF4DB10C", hash_generated_method = "BCB47313407AEFF254651F95089AA8F1")
    
private float getLineExtent(int line, boolean full) {
        int start = getLineStart(line);
        int end = full ? getLineEnd(line) : getLineVisibleEnd(line);

        boolean hasTabsOrEmoji = getLineContainsTab(line);
        TabStops tabStops = null;
        if (hasTabsOrEmoji && mText instanceof Spanned) {
            // Just checking this line should be good enough, tabs should be
            // consistent across all lines in a paragraph.
            TabStopSpan[] tabs = getParagraphSpans((Spanned) mText, start, end, TabStopSpan.class);
            if (tabs.length > 0) {
                tabStops = new TabStops(TAB_INCREMENT, tabs); // XXX should reuse
            }
        }
        Directions directions = getLineDirections(line);
        // Returned directions can actually be null
        if (directions == null) {
            return 0f;
        }
        int dir = getParagraphDirection(line);

        TextLine tl = TextLine.obtain();
        tl.set(mPaint, mText, start, end, dir, directions, hasTabsOrEmoji, tabStops);
        float width = tl.metrics(null);
        TextLine.recycle(tl);
        return width;
    }

    /**
     * Returns the signed horizontal extent of the specified line, excluding
     * leading margin.  If full is false, excludes trailing whitespace.
     * @param line the index of the line
     * @param tabStops the tab stops, can be null if we know they're not used.
     * @param full whether to include trailing whitespace
     * @return the extent of the text on this line
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.365 -0500", hash_original_method = "8D693BD7DA670D75D51405BA4AD1D35A", hash_generated_method = "F33F6403EEB579C79AD8C889D277F017")
    
private float getLineExtent(int line, TabStops tabStops, boolean full) {
        int start = getLineStart(line);
        int end = full ? getLineEnd(line) : getLineVisibleEnd(line);
        boolean hasTabsOrEmoji = getLineContainsTab(line);
        Directions directions = getLineDirections(line);
        int dir = getParagraphDirection(line);

        TextLine tl = TextLine.obtain();
        tl.set(mPaint, mText, start, end, dir, directions, hasTabsOrEmoji, tabStops);
        float width = tl.metrics(null);
        TextLine.recycle(tl);
        return width;
    }

    /**
     * Get the line number corresponding to the specified vertical position.
     * If you ask for a position above 0, you get 0; if you ask for a position
     * below the bottom of the text, you get the last line.
     */
    // FIXME: It may be faster to do a linear search for layouts without many lines.
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.368 -0500", hash_original_method = "10EB5BCC671C8F4E5C56CFC3872691D1", hash_generated_method = "03B80EC8F72E3FD463EC8F7A28676827")
    
public int getLineForVertical(int vertical) {
        int high = getLineCount(), low = -1, guess;

        while (high - low > 1) {
            guess = (high + low) / 2;

            if (getLineTop(guess) > vertical)
                high = guess;
            else
                low = guess;
        }

        if (low < 0)
            return 0;
        else
            return low;
    }

    /**
     * Get the line number on which the specified text offset appears.
     * If you ask for a position before 0, you get 0; if you ask for a position
     * beyond the end of the text, you get the last line.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.371 -0500", hash_original_method = "42BF795D8C0B31EF6FC35C1F4CBE0EBA", hash_generated_method = "675029A7C11075C6493BDAB680B9A9A1")
    
public int getLineForOffset(int offset) {
        int high = getLineCount(), low = -1, guess;

        while (high - low > 1) {
            guess = (high + low) / 2;

            if (getLineStart(guess) > offset)
                high = guess;
            else
                low = guess;
        }

        if (low < 0)
            return 0;
        else
            return low;
    }

    /**
     * Get the character offset on the specified line whose position is
     * closest to the specified horizontal position.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.374 -0500", hash_original_method = "C7C29A2E2D90FB22FF824A86EA8883C4", hash_generated_method = "2E4CD0C95026F5FA47AD3EC34C1D28F1")
    
public int getOffsetForHorizontal(int line, float horiz) {
        int max = getLineEnd(line) - 1;
        int min = getLineStart(line);
        Directions dirs = getLineDirections(line);

        if (line == getLineCount() - 1)
            max++;

        int best = min;
        float bestdist = Math.abs(getPrimaryHorizontal(best) - horiz);

        for (int i = 0; i < dirs.mDirections.length; i += 2) {
            int here = min + dirs.mDirections[i];
            int there = here + (dirs.mDirections[i+1] & RUN_LENGTH_MASK);
            int swap = (dirs.mDirections[i+1] & RUN_RTL_FLAG) != 0 ? -1 : 1;

            if (there > max)
                there = max;
            int high = there - 1 + 1, low = here + 1 - 1, guess;

            while (high - low > 1) {
                guess = (high + low) / 2;
                int adguess = getOffsetAtStartOf(guess);

                if (getPrimaryHorizontal(adguess) * swap >= horiz * swap)
                    high = guess;
                else
                    low = guess;
            }

            if (low < here + 1)
                low = here + 1;

            if (low < there) {
                low = getOffsetAtStartOf(low);

                float dist = Math.abs(getPrimaryHorizontal(low) - horiz);

                int aft = TextUtils.getOffsetAfter(mText, low);
                if (aft < there) {
                    float other = Math.abs(getPrimaryHorizontal(aft) - horiz);

                    if (other < dist) {
                        dist = other;
                        low = aft;
                    }
                }

                if (dist < bestdist) {
                    bestdist = dist;
                    best = low;
                }
            }

            float dist = Math.abs(getPrimaryHorizontal(here) - horiz);

            if (dist < bestdist) {
                bestdist = dist;
                best = here;
            }
        }

        float dist = Math.abs(getPrimaryHorizontal(max) - horiz);

        if (dist < bestdist) {
            bestdist = dist;
            best = max;
        }

        return best;
    }

    /**
     * Return the text offset after the last character on the specified line.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.378 -0500", hash_original_method = "AEF50F2FA9A7358F560FC7521C77962F", hash_generated_method = "22CFA665CDFB6F4B3B14333123EEF8CC")
    
public final int getLineEnd(int line) {
        return getLineStart(line + 1);
    }

    /**
     * Return the text offset after the last visible character (so whitespace
     * is not counted) on the specified line.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.380 -0500", hash_original_method = "A5D943CCC73667A904F00DFE82793835", hash_generated_method = "02BF3C4D49F3653C5D7AC1B51F0F0C1F")
    
public int getLineVisibleEnd(int line) {
        return getLineVisibleEnd(line, getLineStart(line), getLineStart(line+1));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.383 -0500", hash_original_method = "2B63DEF38DAE998AFE5301FAAC214E4B", hash_generated_method = "5F3E6CE517AE2C62E59DF75D0E1FEAB0")
    
private int getLineVisibleEnd(int line, int start, int end) {
        CharSequence text = mText;
        char ch;
        if (line == getLineCount() - 1) {
            return end;
        }

        for (; end > start; end--) {
            ch = text.charAt(end - 1);

            if (ch == '\n') {
                return end - 1;
            }

            if (ch != ' ' && ch != '\t') {
                break;
            }

        }

        return end;
    }
    
    static class TabStops {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.446 -0500", hash_original_method = "770DB8A4DEEA87A4BD324D7E61285BEE", hash_generated_method = "FB23D16440FEC713311FAF8CB6A09A6C")
        
public static float nextDefaultStop(float h, int inc) {
            return ((int) ((h + inc) / inc)) * inc;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.430 -0500", hash_original_field = "C19ACF2F944D58CFDC4B4490897545C7", hash_generated_field = "8DF1795EE4BFA46EFF29A588C85F9451")

        private int[] mStops;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.433 -0500", hash_original_field = "4F74EFD7CA3DAB233FA7392B3C212B4C", hash_generated_field = "2A878E7FB3BADF740089FE25D0D2CFB0")

        private int mNumStops;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.435 -0500", hash_original_field = "4546209B3D6906AA48E5E5DB9F677434", hash_generated_field = "1B34C3EF06331C9557133D8E11D29298")

        private int mIncrement;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.438 -0500", hash_original_method = "56D1FFBFF7D6B6649609A0E9FF6888AB", hash_generated_method = "56D1FFBFF7D6B6649609A0E9FF6888AB")
        
TabStops(int increment, Object[] spans) {
            reset(increment, spans);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.441 -0500", hash_original_method = "12BC3A9AA4E5F32DB7C736F6D72E4602", hash_generated_method = "12BC3A9AA4E5F32DB7C736F6D72E4602")
        
void reset(int increment, Object[] spans) {
            this.mIncrement = increment;

            int ns = 0;
            if (spans != null) {
                int[] stops = this.mStops;
                for (Object o : spans) {
                    if (o instanceof TabStopSpan) {
                        if (stops == null) {
                            stops = new int[10];
                        } else if (ns == stops.length) {
                            int[] nstops = new int[ns * 2];
                            for (int i = 0; i < ns; ++i) {
                                nstops[i] = stops[i];
                            }
                            stops = nstops;
                        }
                        stops[ns++] = ((TabStopSpan) o).getTabStop();
                    }
                }
                if (ns > 1) {
                    Arrays.sort(stops, 0, ns);
                }
                if (stops != this.mStops) {
                    this.mStops = stops;
                }
            }
            this.mNumStops = ns;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.443 -0500", hash_original_method = "A46080BC8F3B4D3099E262DAA9B4728B", hash_generated_method = "A46080BC8F3B4D3099E262DAA9B4728B")
        
float nextTab(float h) {
            int ns = this.mNumStops;
            if (ns > 0) {
                int[] stops = this.mStops;
                for (int i = 0; i < ns; ++i) {
                    int stop = stops[i];
                    if (stop > h) {
                        return stop;
                    }
                }
            }
            return nextDefaultStop(h, mIncrement);
        }
        
    }
    
    public static class Directions {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.462 -0500", hash_original_field = "75E76BC0D205B7AB08D04B9BD6A8D5F6", hash_generated_field = "34A5B6DB41500E828BF17A544F4CA0A5")

        // Runs are pairs of ints listed in visual order, starting from the
        // leading margin.  The first int of each pair is the offset from
        // the first character of the line to the start of the run.  The
        // second int represents both the length and level of the run.
        // The length is in the lower bits, accessed by masking with
        // DIR_LENGTH_MASK.  The level is in the higher bits, accessed
        // by shifting by DIR_LEVEL_SHIFT and masking by DIR_LEVEL_MASK.
        // To simply test for an RTL direction, test the bit using
        // DIR_RTL_FLAG, if set then the direction is rtl.

        /* package */ int[] mDirections;
        /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.477 -0500", hash_original_method = "DA94802578AA1A107A88665DAAC4811A", hash_generated_method = "DA94802578AA1A107A88665DAAC4811A")
        
Directions(int[] dirs) {
            mDirections = dirs;
        }
        
    }
    
    static class Ellipsizer implements CharSequence, GetChars {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.486 -0500", hash_original_field = "A59BBC07E5E46996D793B2F37E80BD24", hash_generated_field = "A59BBC07E5E46996D793B2F37E80BD24")
 CharSequence mText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.489 -0500", hash_original_field = "99107F82B615317EF9A2721652F6B828", hash_generated_field = "99107F82B615317EF9A2721652F6B828")
 Layout mLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.491 -0500", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")
 int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.493 -0500", hash_original_field = "1AEFAC3E5E60C9DA6FF9B1E24BF26D63", hash_generated_field = "1AEFAC3E5E60C9DA6FF9B1E24BF26D63")
 TextUtils.TruncateAt mMethod;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.497 -0500", hash_original_method = "991CD3860414493D5159CDEA8946E94D", hash_generated_method = "F49E454D634A475599C2F7ABD639388A")
        
public Ellipsizer(CharSequence s) {
            mText = s;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.500 -0500", hash_original_method = "D253D2AD2D0DACD122596323ACBBAF25", hash_generated_method = "D7EB4ED1B40207CFF86F497A7967BA70")
        
public char charAt(int off) {
            char[] buf = TextUtils.obtain(1);
            getChars(off, off + 1, buf, 0);
            char ret = buf[0];

            TextUtils.recycle(buf);
            return ret;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.502 -0500", hash_original_method = "F2DBD2F3D78F3955B1714BB078A793F8", hash_generated_method = "1E0FCCDBAC01D5172AC21CED438CA2E8")
        
public void getChars(int start, int end, char[] dest, int destoff) {
            int line1 = mLayout.getLineForOffset(start);
            int line2 = mLayout.getLineForOffset(end);

            TextUtils.getChars(mText, start, end, dest, destoff);

            for (int i = line1; i <= line2; i++) {
                mLayout.ellipsize(start, end, i, dest, destoff);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.505 -0500", hash_original_method = "9A68249D01A4FE1CBD4D535668FCEB6F", hash_generated_method = "8958BA6171CC7F46E64433775F1B4CBA")
        
public int length() {
            return mText.length();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.507 -0500", hash_original_method = "019151395F1B77A008AA178A5A5CA402", hash_generated_method = "E0382AAAC4AD6900C61843D9F3FC3F59")
        
public CharSequence subSequence(int start, int end) {
            char[] s = new char[end - start];
            getChars(start, end, s, 0);
            return new String(s);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.510 -0500", hash_original_method = "8ED281151745D3FC40324C23FDF16D10", hash_generated_method = "16E4C4DB57F114FD51428F1C8FA1F678")
        
@Override
        public String toString() {
            char[] s = new char[length()];
            getChars(0, length(), s, 0);
            return new String(s);
        }
        
    }
    
    static class SpannedEllipsizer extends Ellipsizer implements Spanned {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.515 -0500", hash_original_field = "4D9A388EBF42337B3D4B4C24F8CD74B1", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

        private Spanned mSpanned;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.518 -0500", hash_original_method = "F42AC9AEDB79FF2719E5DE12CF0CD85E", hash_generated_method = "14765A4620425108B238A2CBAE3A366C")
        
public SpannedEllipsizer(CharSequence display) {
            super(display);
            mSpanned = (Spanned) display;
        }
                
@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.968 -0400", hash_original_method = "E8AB479016A2E00AFF48AA43F345FA2A", hash_generated_method = "1366812328FC382F5B8FE3423F551FD8")
        public <T> T[] getSpans(int start, int end, Class<T> type) {
            addTaint(type.getTaint());
            addTaint(end);
            addTaint(start);
T[] varF03F51B4D510CEB709FCAEAB771CF011_1441501040 =             mSpanned.getSpans(start, end, type);
            varF03F51B4D510CEB709FCAEAB771CF011_1441501040.addTaint(taint);
            return varF03F51B4D510CEB709FCAEAB771CF011_1441501040;
            // ---------- Original Method ----------
            //return mSpanned.getSpans(start, end, type);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.523 -0500", hash_original_method = "2071284CDE64572D4D3F80F80EB4C823", hash_generated_method = "2F1F23BF4970036AFC2624FBD0A76667")
        
public int getSpanStart(Object tag) {
            return mSpanned.getSpanStart(tag);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.526 -0500", hash_original_method = "B1DC38D90632AE4EB220020E4C5B16DF", hash_generated_method = "352085C78F363920AB38A9623804477C")
        
public int getSpanEnd(Object tag) {
            return mSpanned.getSpanEnd(tag);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.528 -0500", hash_original_method = "A386D5CC8A9C15386840381A75E4D6FD", hash_generated_method = "94AA2E2AFBFE0A83C771FF66CD53D9D5")
        
public int getSpanFlags(Object tag) {
            return mSpanned.getSpanFlags(tag);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.531 -0500", hash_original_method = "AF35DA8DF947D9C1330368703ECE15BE", hash_generated_method = "FF4B8EF383509E38F702AEF611D74B08")
        
public int nextSpanTransition(int start, int limit, Class type) {
            return mSpanned.nextSpanTransition(start, limit, type);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.534 -0500", hash_original_method = "16B37527DFF576A9EB476E4EC2A69F5D", hash_generated_method = "871FD8E52BD4A31A435C938C76D0A330")
        
@Override
        public CharSequence subSequence(int start, int end) {
            char[] s = new char[end - start];
            getChars(start, end, s, 0);

            SpannableString ss = new SpannableString(new String(s));
            TextUtils.copySpansFrom(mSpanned, start, end, Object.class, ss, 0);
            return ss;
        }
        
    }
    
    public enum Alignment {
        ALIGN_NORMAL,
        ALIGN_OPPOSITE,
        ALIGN_CENTER,
        ALIGN_LEFT,
        ALIGN_RIGHT,
    }

    /**
     * Return the vertical position of the bottom of the specified line.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.385 -0500", hash_original_method = "230C56044F8D52E3D0BA17DE5C72A914", hash_generated_method = "5AA61C33C934D24188B590F9EFA8E350")
    
public final int getLineBottom(int line) {
        return getLineTop(line + 1);
    }

    /**
     * Return the vertical position of the baseline of the specified line.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.388 -0500", hash_original_method = "BC6E93964E3CCD0D48881D9F9ABB9170", hash_generated_method = "E006075DD2B455D8358F062B9DB5CA39")
    
public final int getLineBaseline(int line) {
        // getLineTop(line+1) == getLineTop(line)
        return getLineTop(line+1) - getLineDescent(line);
    }

    /**
     * Get the ascent of the text on the specified line.
     * The return value is negative to match the Paint.ascent() convention.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.390 -0500", hash_original_method = "577197C969745092B110831C30EF14E9", hash_generated_method = "7AD521E7EB701309FB90AE02B66B8FDC")
    
public final int getLineAscent(int line) {
        // getLineTop(line+1) - getLineDescent(line) == getLineBaseLine(line)
        return getLineTop(line) - (getLineTop(line+1) - getLineDescent(line));
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.393 -0500", hash_original_method = "AA9B5ECC044BD491182BF4F86B4B2DB2", hash_generated_method = "A5B1C788954A6D00176A51427C30F232")
    
public int getOffsetToLeftOf(int offset) {
        return getOffsetToLeftRightOf(offset, true);
    }
    static {
        if (EMOJI_FACTORY != null) {
            MIN_EMOJI = EMOJI_FACTORY.getMinimumAndroidPua();
            MAX_EMOJI = EMOJI_FACTORY.getMaximumAndroidPua();
        } else {
            MIN_EMOJI = -1;
            MAX_EMOJI = -1;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.395 -0500", hash_original_method = "684E6D0185E1F1B7C4ABCAB8ADBE45B0", hash_generated_method = "3A5E3ABAD545AC94C3EBCA81E4FEFA9C")
    
public int getOffsetToRightOf(int offset) {
        return getOffsetToLeftRightOf(offset, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.399 -0500", hash_original_method = "0024CF60F9AAE9E8C390E55EB92D8B7D", hash_generated_method = "659B0BF074ABD37FCC1298F8FEEACA53")
    
private int getOffsetToLeftRightOf(int caret, boolean toLeft) {
        int line = getLineForOffset(caret);
        int lineStart = getLineStart(line);
        int lineEnd = getLineEnd(line);
        int lineDir = getParagraphDirection(line);

        boolean lineChanged = false;
        boolean advance = toLeft == (lineDir == DIR_RIGHT_TO_LEFT);
        // if walking off line, look at the line we're headed to
        if (advance) {
            if (caret == lineEnd) {
                if (line < getLineCount() - 1) {
                    lineChanged = true;
                    ++line;
                } else {
                    return caret; // at very end, don't move
                }
            }
        } else {
            if (caret == lineStart) {
                if (line > 0) {
                    lineChanged = true;
                    --line;
                } else {
                    return caret; // at very start, don't move
                }
            }
        }

        if (lineChanged) {
            lineStart = getLineStart(line);
            lineEnd = getLineEnd(line);
            int newDir = getParagraphDirection(line);
            if (newDir != lineDir) {
                // unusual case.  we want to walk onto the line, but it runs
                // in a different direction than this one, so we fake movement
                // in the opposite direction.
                toLeft = !toLeft;
                lineDir = newDir;
            }
        }

        Directions directions = getLineDirections(line);

        TextLine tl = TextLine.obtain();
        // XXX: we don't care about tabs
        tl.set(mPaint, mText, lineStart, lineEnd, lineDir, directions, false, null);
        caret = lineStart + tl.getOffsetToLeftRightOf(caret - lineStart, toLeft);
        tl = TextLine.recycle(tl);
        return caret;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.402 -0500", hash_original_method = "F9D5E8173F5C3CA491A1C8A8AE760B93", hash_generated_method = "89783BD78A44BC3704CB607B032D95DF")
    
private int getOffsetAtStartOf(int offset) {
        // XXX this probably should skip local reorderings and
        // zero-width characters, look at callers
        if (offset == 0)
            return 0;

        CharSequence text = mText;
        char c = text.charAt(offset);

        if (c >= '\uDC00' && c <= '\uDFFF') {
            char c1 = text.charAt(offset - 1);

            if (c1 >= '\uD800' && c1 <= '\uDBFF')
                offset -= 1;
        }

        if (mSpannedText) {
            ReplacementSpan[] spans = ((Spanned) text).getSpans(offset, offset,
                                                       ReplacementSpan.class);

            for (int i = 0; i < spans.length; i++) {
                int start = ((Spanned) text).getSpanStart(spans[i]);
                int end = ((Spanned) text).getSpanEnd(spans[i]);

                if (start < offset && end > offset)
                    offset = start;
            }
        }

        return offset;
    }

    /**
     * Fills in the specified Path with a representation of a cursor
     * at the specified offset.  This will often be a vertical line
     * but can be multiple discontinuous lines in text with multiple
     * directionalities.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.406 -0500", hash_original_method = "B9C7ED4514D9377B34881167E2C24E2C", hash_generated_method = "1FA24D84E3B80DB4D7943082439729D7")
    
public void getCursorPath(int point, Path dest,
                              CharSequence editingBuffer) {
        dest.reset();

        int line = getLineForOffset(point);
        int top = getLineTop(line);
        int bottom = getLineTop(line+1);

        float h1 = getPrimaryHorizontal(point) - 0.5f;
        float h2 = isLevelBoundary(point) ? getSecondaryHorizontal(point) - 0.5f : h1;

        int caps = TextKeyListener.getMetaState(editingBuffer, TextKeyListener.META_SHIFT_ON) |
                   TextKeyListener.getMetaState(editingBuffer, TextKeyListener.META_SELECTING);
        int fn = TextKeyListener.getMetaState(editingBuffer, TextKeyListener.META_ALT_ON);
        int dist = 0;

        if (caps != 0 || fn != 0) {
            dist = (bottom - top) >> 2;

            if (fn != 0)
                top += dist;
            if (caps != 0)
                bottom -= dist;
        }

        if (h1 < 0.5f)
            h1 = 0.5f;
        if (h2 < 0.5f)
            h2 = 0.5f;

        if (Float.compare(h1, h2) == 0) {
            dest.moveTo(h1, top);
            dest.lineTo(h1, bottom);
        } else {
            dest.moveTo(h1, top);
            dest.lineTo(h1, (top + bottom) >> 1);

            dest.moveTo(h2, (top + bottom) >> 1);
            dest.lineTo(h2, bottom);
        }

        if (caps == 2) {
            dest.moveTo(h2, bottom);
            dest.lineTo(h2 - dist, bottom + dist);
            dest.lineTo(h2, bottom);
            dest.lineTo(h2 + dist, bottom + dist);
        } else if (caps == 1) {
            dest.moveTo(h2, bottom);
            dest.lineTo(h2 - dist, bottom + dist);

            dest.moveTo(h2 - dist, bottom + dist - 0.5f);
            dest.lineTo(h2 + dist, bottom + dist - 0.5f);

            dest.moveTo(h2 + dist, bottom + dist);
            dest.lineTo(h2, bottom);
        }

        if (fn == 2) {
            dest.moveTo(h1, top);
            dest.lineTo(h1 - dist, top - dist);
            dest.lineTo(h1, top);
            dest.lineTo(h1 + dist, top - dist);
        } else if (fn == 1) {
            dest.moveTo(h1, top);
            dest.lineTo(h1 - dist, top - dist);

            dest.moveTo(h1 - dist, top - dist + 0.5f);
            dest.lineTo(h1 + dist, top - dist + 0.5f);

            dest.moveTo(h1 + dist, top - dist);
            dest.lineTo(h1, top);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.409 -0500", hash_original_method = "12119B0793FEC64A3F791B69831CA1AC", hash_generated_method = "15F61C9F2541D0CC581984C3AE701AF7")
    
private void addSelection(int line, int start, int end,
                              int top, int bottom, Path dest) {
        int linestart = getLineStart(line);
        int lineend = getLineEnd(line);
        Directions dirs = getLineDirections(line);

        if (lineend > linestart && mText.charAt(lineend - 1) == '\n')
            lineend--;

        for (int i = 0; i < dirs.mDirections.length; i += 2) {
            int here = linestart + dirs.mDirections[i];
            int there = here + (dirs.mDirections[i+1] & RUN_LENGTH_MASK);

            if (there > lineend)
                there = lineend;

            if (start <= there && end >= here) {
                int st = Math.max(start, here);
                int en = Math.min(end, there);

                if (st != en) {
                    float h1 = getHorizontal(st, false, line);
                    float h2 = getHorizontal(en, true, line);

                    float left = Math.min(h1, h2);
                    float right = Math.max(h1, h2);

                    dest.addRect(left, top, right, bottom, Path.Direction.CW);
                }
            }
        }
    }

    /**
     * Fills in the specified Path with a representation of a highlight
     * between the specified offsets.  This will often be a rectangle
     * or a potentially discontinuous set of rectangles.  If the start
     * and end are the same, the returned path is empty.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.413 -0500", hash_original_method = "E504AED84523F80835FFB88244A923D5", hash_generated_method = "C2ECEA2506433BADE7235E6563771D35")
    
public void getSelectionPath(int start, int end, Path dest) {
        dest.reset();

        if (start == end)
            return;

        if (end < start) {
            int temp = end;
            end = start;
            start = temp;
        }

        int startline = getLineForOffset(start);
        int endline = getLineForOffset(end);

        int top = getLineTop(startline);
        int bottom = getLineBottom(endline);

        if (startline == endline) {
            addSelection(startline, start, end, top, bottom, dest);
        } else {
            final float width = mWidth;

            addSelection(startline, start, getLineEnd(startline),
                         top, getLineBottom(startline), dest);

            if (getParagraphDirection(startline) == DIR_RIGHT_TO_LEFT)
                dest.addRect(getLineLeft(startline), top,
                              0, getLineBottom(startline), Path.Direction.CW);
            else
                dest.addRect(getLineRight(startline), top,
                              width, getLineBottom(startline), Path.Direction.CW);

            for (int i = startline + 1; i < endline; i++) {
                top = getLineTop(i);
                bottom = getLineBottom(i);
                dest.addRect(0, top, width, bottom, Path.Direction.CW);
            }

            top = getLineTop(endline);
            bottom = getLineBottom(endline);

            addSelection(endline, getLineStart(endline), end,
                         top, bottom, dest);

            if (getParagraphDirection(endline) == DIR_RIGHT_TO_LEFT)
                dest.addRect(width, top, getLineRight(endline), bottom, Path.Direction.CW);
            else
                dest.addRect(0, top, getLineLeft(endline), bottom, Path.Direction.CW);
        }
    }

    /**
     * Get the alignment of the specified paragraph, taking into account
     * markup attached to it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.415 -0500", hash_original_method = "8E26BC9825AB85694FDEA00F755B3420", hash_generated_method = "B135437DED555C9500A6335F89E72495")
    
public final Alignment getParagraphAlignment(int line) {
        Alignment align = mAlignment;

        if (mSpannedText) {
            Spanned sp = (Spanned) mText;
            AlignmentSpan[] spans = getParagraphSpans(sp, getLineStart(line),
                                                getLineEnd(line),
                                                AlignmentSpan.class);

            int spanLength = spans.length;
            if (spanLength > 0) {
                align = spans[spanLength-1].getAlignment();
            }
        }

        return align;
    }

    /**
     * Get the left edge of the specified paragraph, inset by left margins.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.418 -0500", hash_original_method = "D8249C79FD486A8037899C5A02304321", hash_generated_method = "DD14FCDD99E2D75016AA9A63367F42E2")
    
public final int getParagraphLeft(int line) {
        int left = 0;
        int dir = getParagraphDirection(line);
        if (dir == DIR_RIGHT_TO_LEFT || !mSpannedText) {
            return left; // leading margin has no impact, or no styles
        }
        return getParagraphLeadingMargin(line);
    }

    /**
     * Get the right edge of the specified paragraph, inset by right margins.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.421 -0500", hash_original_method = "4AFE65CA85EFF9BA5DD1726E8E021AC9", hash_generated_method = "FE964169DB4009211AF47BA549E9B1DB")
    
public final int getParagraphRight(int line) {
        int right = mWidth;
        int dir = getParagraphDirection(line);
        if (dir == DIR_LEFT_TO_RIGHT || !mSpannedText) {
            return right; // leading margin has no impact, or no styles
        }
        return right - getParagraphLeadingMargin(line);
    }

    /**
     * Returns the effective leading margin (unsigned) for this line,
     * taking into account LeadingMarginSpan and LeadingMarginSpan2.
     * @param line the line index
     * @return the leading margin of this line
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.424 -0500", hash_original_method = "E5BF73D13B43F74BA21E795D809567BE", hash_generated_method = "F95AED36160F907B4EDB633E2CBDBB7A")
    
private int getParagraphLeadingMargin(int line) {
        if (!mSpannedText) {
            return 0;
        }
        Spanned spanned = (Spanned) mText;

        int lineStart = getLineStart(line);
        int lineEnd = getLineEnd(line);
        int spanEnd = spanned.nextSpanTransition(lineStart, lineEnd,
                LeadingMarginSpan.class);
        LeadingMarginSpan[] spans = getParagraphSpans(spanned, lineStart, spanEnd,
                                                LeadingMarginSpan.class);
        if (spans.length == 0) {
            return 0; // no leading margin span;
        }

        int margin = 0;

        boolean isFirstParaLine = lineStart == 0 ||
            spanned.charAt(lineStart - 1) == '\n';

        for (int i = 0; i < spans.length; i++) {
            LeadingMarginSpan span = spans[i];
            boolean useFirstLineMargin = isFirstParaLine;
            if (span instanceof LeadingMarginSpan2) {
                int spStart = spanned.getSpanStart(span);
                int spanLine = getLineForOffset(spStart);
                int count = ((LeadingMarginSpan2)span).getLeadingMarginLineCount();
                useFirstLineMargin = line < spanLine + count;
            }
            margin += span.getLeadingMargin(useFirstLineMargin);
        }

        return margin;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.454 -0500", hash_original_method = "CAFF1C73D2C9EA6C410B2B2D519C8AC7", hash_generated_method = "34CD290405260303BC9C44D5C42674E2")
    
protected final boolean isSpanned() {
        return mSpannedText;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.459 -0500", hash_original_method = "0902B773EC3014719EA37A51347EC9C6", hash_generated_method = "E64D9B7BB3ABFE3B0B5F64655A11DA46")
    
private void ellipsize(int start, int end, int line,
                           char[] dest, int destoff) {
        int ellipsisCount = getEllipsisCount(line);

        if (ellipsisCount == 0) {
            return;
        }

        int ellipsisStart = getEllipsisStart(line);
        int linestart = getLineStart(line);

        for (int i = ellipsisStart; i < ellipsisStart + ellipsisCount; i++) {
            char c;

            if (i == ellipsisStart) {
                c = '\u2026'; // ellipsis
            } else {
                c = '\uFEFF'; // 0-width space
            }

            int a = i + linestart;

            if (a >= start && a < end) {
                dest[destoff + a - start] = c;
            }
        }
    }

    /**
     * Return the offset of the first character to be ellipsized away,
     * relative to the start of the line.  (So 0 if the beginning of the
     * line is ellipsized, not getLineStart().)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.481 -0500", hash_original_method = "152FA8D0FCA56A1E986B9CFF812EF658", hash_generated_method = "730B30A4CE2FEF465DFB3BD4FAA541AE")
    
public abstract int getEllipsisStart(int line);

    /**
     * Returns the number of characters to be ellipsized away, or 0 if
     * no ellipsis is to take place.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:11.483 -0500", hash_original_method = "8B8817BB2BCF9519A11FE01870A20CF8", hash_generated_method = "58CE8DA2B014BCFCBD3C293CB5068B49")
    
public abstract int getEllipsisCount(int line);
}

