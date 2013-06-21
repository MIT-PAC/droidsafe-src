package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Paint;
import android.text.style.UpdateLayout;
import android.text.style.WrapTogetherSpan;
import java.lang.ref.WeakReference;

public class DynamicLayout extends Layout {
    private CharSequence mBase;
    private CharSequence mDisplay;
    private ChangeWatcher mWatcher;
    private boolean mIncludePad;
    private boolean mEllipsize;
    private int mEllipsizedWidth;
    private TextUtils.TruncateAt mEllipsizeAt;
    private PackedIntVector mInts;
    private PackedObjectVector<Directions> mObjects;
    private int mTopPadding, mBottomPadding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.023 -0400", hash_original_method = "DB07DE8DB9A02739307D238F9A46C5FB", hash_generated_method = "9DAFBF591D7F8AC485DDCA6D18C98CA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DynamicLayout(CharSequence base,
                         TextPaint paint,
                         int width, Alignment align,
                         float spacingmult, float spacingadd,
                         boolean includepad) {
        this(base, base, paint, width, align, spacingmult, spacingadd,
             includepad);
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(width);
        dsTaint.addTaint(base);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.024 -0400", hash_original_method = "BEECDC91516286CCE30494A55398B48A", hash_generated_method = "7B516DE2F3BFF3D3D6AF4C6696256F3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DynamicLayout(CharSequence base, CharSequence display,
                         TextPaint paint,
                         int width, Alignment align,
                         float spacingmult, float spacingadd,
                         boolean includepad) {
        this(base, display, paint, width, align, spacingmult, spacingadd,
             includepad, null, 0);
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(width);
        dsTaint.addTaint(base);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(display);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.024 -0400", hash_original_method = "F5040E07E9B927EF44F79345AA20F61D", hash_generated_method = "2F3F788CFF50D261AF7EF132DA44DB2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DynamicLayout(CharSequence base, CharSequence display,
                         TextPaint paint,
                         int width, Alignment align,
                         float spacingmult, float spacingadd,
                         boolean includepad,
                         TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        this(base, display, paint, width, align, TextDirectionHeuristics.FIRSTSTRONG_LTR,
                spacingmult, spacingadd, includepad, ellipsize, ellipsizedWidth);
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(ellipsizedWidth);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(width);
        dsTaint.addTaint(base);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(display);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        dsTaint.addTaint(ellipsize.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.025 -0400", hash_original_method = "E989442183EB5456191B90B4A9B0462E", hash_generated_method = "B1F3C01B607DFE39518952388A08B660")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DynamicLayout(CharSequence base, CharSequence display,
                         TextPaint paint,
                         int width, Alignment align, TextDirectionHeuristic textDir,
                         float spacingmult, float spacingadd,
                         boolean includepad,
                         TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        super((ellipsize == null)
                ? display
                : (display instanceof Spanned)
                    ? new SpannedEllipsizer(display)
                    : new Ellipsizer(display),
              paint, width, align, textDir, spacingmult, spacingadd);
        dsTaint.addTaint(includepad);
        dsTaint.addTaint(textDir.dsTaint);
        dsTaint.addTaint(ellipsizedWidth);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(width);
        dsTaint.addTaint(base);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(display);
        dsTaint.addTaint(spacingadd);
        dsTaint.addTaint(spacingmult);
        dsTaint.addTaint(ellipsize.dsTaint);
        {
            mInts = new PackedIntVector(COLUMNS_ELLIPSIZE);
        } //End block
        {
            mInts = new PackedIntVector(COLUMNS_NORMAL);
            mEllipsizeAt = null;
        } //End block
        mObjects = new PackedObjectVector<Directions>(1);
        {
            Ellipsizer e;
            e = (Ellipsizer) getText();
            e.mLayout = this;
            e.mWidth = ellipsizedWidth;
            e.mMethod = ellipsize;
            mEllipsize = true;
        } //End block
        int[] start;
        {
            start = new int[COLUMNS_ELLIPSIZE];
            start[ELLIPSIS_START] = ELLIPSIS_UNDEFINED;
        } //End block
        {
            start = new int[COLUMNS_NORMAL];
        } //End block
        Directions[] dirs;
        dirs = new Directions[] { DIRS_ALL_LEFT_TO_RIGHT };
        Paint.FontMetricsInt fm;
        fm = paint.getFontMetricsInt();
        int asc;
        asc = fm.ascent;
        int desc;
        desc = fm.descent;
        start[DIR] = DIR_LEFT_TO_RIGHT << DIR_SHIFT;
        start[TOP] = 0;
        start[DESCENT] = desc;
        mInts.insertAt(0, start);
        start[TOP] = desc - asc;
        mInts.insertAt(1, start);
        mObjects.insertAt(0, dirs);
        reflow(base, 0, 0, base.length());
        {
            mWatcher = new ChangeWatcher(this);
            Spannable sp;
            sp = (Spannable) base;
            ChangeWatcher[] spans;
            spans = sp.getSpans(0, sp.length(), ChangeWatcher.class);
            {
                int i;
                i = 0;
                sp.removeSpan(spans[i]);
            } //End collapsed parenthetic
            sp.setSpan(mWatcher, 0, base.length(),
                       Spannable.SPAN_INCLUSIVE_INCLUSIVE |
                       (PRIORITY << Spannable.SPAN_PRIORITY_SHIFT));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.026 -0400", hash_original_method = "680F026D747328AC88C64FC8C5845240", hash_generated_method = "5F2B3BD3F58EE2297986D885E947AFA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void reflow(CharSequence s, int where, int before, int after) {
        dsTaint.addTaint(after);
        dsTaint.addTaint(s);
        dsTaint.addTaint(before);
        dsTaint.addTaint(where);
        CharSequence text;
        text = mDisplay;
        int len;
        len = text.length();
        int find;
        find = TextUtils.lastIndexOf(text, '\n', where - 1);
        find = 0;
        find = find + 1;
        {
            int diff;
            diff = where - find;
            before += diff;
            after += diff;
            where -= diff;
        } //End block
        int look;
        look = TextUtils.indexOf(text, '\n', where + after);
        look = len;
        int change;
        change = look - (where + after);
        before += change;
        after += change;
        {
            Spanned sp;
            sp = (Spanned) text;
            boolean again;
            {
                again = false;
                Object[] force;
                force = sp.getSpans(where, where + after,
                                             WrapTogetherSpan.class);
                {
                    int i;
                    i = 0;
                    {
                        int st;
                        st = sp.getSpanStart(force[i]);
                        int en;
                        en = sp.getSpanEnd(force[i]);
                        {
                            again = true;
                            int diff;
                            diff = where - st;
                            before += diff;
                            after += diff;
                            where -= diff;
                        } //End block
                        {
                            again = true;
                            int diff;
                            diff = en - (where + after);
                            before += diff;
                            after += diff;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        int startline;
        startline = getLineForOffset(where);
        int startv;
        startv = getLineTop(startline);
        int endline;
        endline = getLineForOffset(where + before);
        endline = getLineCount();
        int endv;
        endv = getLineTop(endline);
        boolean islast;
        islast = (endline == getLineCount());
        StaticLayout reflowed;
        {
            reflowed = sStaticLayout;
            sStaticLayout = null;
        } //End block
        {
            reflowed = new StaticLayout(null);
        } //End block
        {
            reflowed.prepare();
        } //End block
        reflowed.generate(text, where, where + after,
                getPaint(), getWidth(), getTextDirectionHeuristic(), getSpacingMultiplier(),
                getSpacingAdd(), false,
                true, mEllipsizedWidth, mEllipsizeAt);
        int n;
        n = reflowed.getLineCount();
        {
            boolean varA8F26B230E6C690FEFF73B0BFCB1FB0E_1278609853 = (where + after != len &&
            reflowed.getLineStart(n - 1) == where + after);
        } //End collapsed parenthetic
        mInts.deleteAt(startline, endline - startline);
        mObjects.deleteAt(startline, endline - startline);
        int ht;
        ht = reflowed.getLineTop(n);
        int toppad, botpad;
        toppad = 0;
        botpad = 0;
        {
            toppad = reflowed.getTopPadding();
            mTopPadding = toppad;
            ht -= toppad;
        } //End block
        {
            botpad = reflowed.getBottomPadding();
            mBottomPadding = botpad;
            ht += botpad;
        } //End block
        mInts.adjustValuesBelow(startline, START, after - before);
        mInts.adjustValuesBelow(startline, TOP, startv - endv + ht);
        int[] ints;
        {
            ints = new int[COLUMNS_ELLIPSIZE];
            ints[ELLIPSIS_START] = ELLIPSIS_UNDEFINED;
        } //End block
        {
            ints = new int[COLUMNS_NORMAL];
        } //End block
        Directions[] objects;
        objects = new Directions[1];
        {
            int i;
            i = 0;
            {
                ints[START] = reflowed.getLineStart(i) |
                          (reflowed.getParagraphDirection(i) << DIR_SHIFT) |
                          (reflowed.getLineContainsTab(i) ? TAB_MASK : 0);
                int top;
                top = reflowed.getLineTop(i) + startv;
                top -= toppad;
                ints[TOP] = top;
                int desc;
                desc = reflowed.getLineDescent(i);
                desc += botpad;
                ints[DESCENT] = desc;
                objects[0] = reflowed.getLineDirections(i);
                {
                    ints[ELLIPSIS_START] = reflowed.getEllipsisStart(i);
                    ints[ELLIPSIS_COUNT] = reflowed.getEllipsisCount(i);
                } //End block
                mInts.insertAt(startline + i, ints);
                mObjects.insertAt(startline + i, objects);
            } //End block
        } //End collapsed parenthetic
        {
            sStaticLayout = reflowed;
            reflowed.finish();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.027 -0400", hash_original_method = "152FA51B02D5FF2B246CE19D3B6F70D3", hash_generated_method = "A3DA7D630250ACB8AF39BDB96D16C826")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLineCount() {
        int var5CACA94FC5780744C6E7317B6E5C4CD8_154518811 = (mInts.size() - 1);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInts.size() - 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.027 -0400", hash_original_method = "D6F378A47E9DC69D83D62FCE6E90C326", hash_generated_method = "0F958FAA991A1E6B04A164C9A8A306C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLineTop(int line) {
        dsTaint.addTaint(line);
        int var93A1DB78A00AEEDC2C8FFA797CB1C236_484123022 = (mInts.getValue(line, TOP));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInts.getValue(line, TOP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.027 -0400", hash_original_method = "730DAEEEE356A285055D20F0106F731A", hash_generated_method = "109772C205153496FB0B5C972E7B883A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLineDescent(int line) {
        dsTaint.addTaint(line);
        int var2F83A1C66F15F4DFFD63244CE36A39E3_2042591348 = (mInts.getValue(line, DESCENT));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInts.getValue(line, DESCENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.027 -0400", hash_original_method = "2D0F6CD810E708D2F846F779125A5CEA", hash_generated_method = "F206EA5706BB03E12D42588724BBE759")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLineStart(int line) {
        dsTaint.addTaint(line);
        int var2E609AA1AE48CD56C499FC299D542025_150682514 = (mInts.getValue(line, START) & START_MASK);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInts.getValue(line, START) & START_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.028 -0400", hash_original_method = "A0EC5BA65111126AB58C28059BDF3DD2", hash_generated_method = "5925A373488BA0AAE23B0146DD7EB807")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getLineContainsTab(int line) {
        dsTaint.addTaint(line);
        boolean var6812F2F3EF40E71A52EA6BFF67D6C857_1472371308 = ((mInts.getValue(line, TAB) & TAB_MASK) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mInts.getValue(line, TAB) & TAB_MASK) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.028 -0400", hash_original_method = "54E53FDCC15DB3057A5F7E1DF0F2D93F", hash_generated_method = "E039E42D952FCEA7014A840F0F7AEA2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getParagraphDirection(int line) {
        dsTaint.addTaint(line);
        int var70DA67A2D1659A19E3C11C8D9A8D14F9_1974832131 = (mInts.getValue(line, DIR) >> DIR_SHIFT);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mInts.getValue(line, DIR) >> DIR_SHIFT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.028 -0400", hash_original_method = "632C7F2120605B5CA7A1A3052A452575", hash_generated_method = "DEAF74EFE29E57FC0CE700DA169BBB22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final Directions getLineDirections(int line) {
        dsTaint.addTaint(line);
        Directions var8693E7DC274E1A774545E81E67386E84_223350478 = (mObjects.getValue(line, 0));
        return (Directions)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mObjects.getValue(line, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.028 -0400", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "FA47B026F2C44A937D9C405114C71495")
    @DSModeled(DSC.SAFE)
    @Override
    public int getTopPadding() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTopPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.028 -0400", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "6889C8E9FBF2C0906C69CE0D62BF8388")
    @DSModeled(DSC.SAFE)
    @Override
    public int getBottomPadding() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBottomPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.029 -0400", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "1883110F0CECE5EEE366F4E7139C3405")
    @DSModeled(DSC.SAFE)
    @Override
    public int getEllipsizedWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEllipsizedWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.029 -0400", hash_original_method = "C2BA24D83CCF8B46DBDB9E42876D7FC0", hash_generated_method = "B9442E049643B65E403AD532A949B5FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getEllipsisStart(int line) {
        dsTaint.addTaint(line);
        int varD7B9ACF21B6113CC7B0610D40B77095D_1954105169 = (mInts.getValue(line, ELLIPSIS_START));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mEllipsizeAt == null) {
            //return 0;
        //}
        //return mInts.getValue(line, ELLIPSIS_START);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.029 -0400", hash_original_method = "8861D8B0168294A81E05E00D1A35F6B4", hash_generated_method = "9D7ABF09C0C22AF498064BB949C151CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getEllipsisCount(int line) {
        dsTaint.addTaint(line);
        int var2F960C4354B27712541F6BCCD9E7C558_1763478064 = (mInts.getValue(line, ELLIPSIS_COUNT));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mEllipsizeAt == null) {
            //return 0;
        //}
        //return mInts.getValue(line, ELLIPSIS_COUNT);
    }

    
    private static class ChangeWatcher implements TextWatcher, SpanWatcher {
        private WeakReference<DynamicLayout> mLayout;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.029 -0400", hash_original_method = "5B008785D1A2C7A00F27EBFB90B5E73C", hash_generated_method = "55C19458D07DAC20982CFF91255AAA1B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ChangeWatcher(DynamicLayout layout) {
            dsTaint.addTaint(layout.dsTaint);
            mLayout = new WeakReference<DynamicLayout>(layout);
            // ---------- Original Method ----------
            //mLayout = new WeakReference<DynamicLayout>(layout);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.030 -0400", hash_original_method = "86BF27AD60282A12928BABF6F115B549", hash_generated_method = "74F09637E4BAFD0CB52EA9D36E40B5D9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void reflow(CharSequence s, int where, int before, int after) {
            dsTaint.addTaint(after);
            dsTaint.addTaint(s);
            dsTaint.addTaint(before);
            dsTaint.addTaint(where);
            DynamicLayout ml;
            ml = mLayout.get();
            ml.reflow(s, where, before, after);
            ((Spannable) s).removeSpan(this);
            // ---------- Original Method ----------
            //DynamicLayout ml = mLayout.get();
            //if (ml != null)
                //ml.reflow(s, where, before, after);
            //else if (s instanceof Spannable)
                //((Spannable) s).removeSpan(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.030 -0400", hash_original_method = "95E45B237E67DBC952009C430C254747", hash_generated_method = "643AF5AB5291FE6E324867AFA035F42F")
        @DSModeled(DSC.SAFE)
        public void beforeTextChanged(CharSequence s, int where, int before, int after) {
            dsTaint.addTaint(after);
            dsTaint.addTaint(s);
            dsTaint.addTaint(before);
            dsTaint.addTaint(where);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.030 -0400", hash_original_method = "64CFCAB8C5BCD960BA37993088223F2C", hash_generated_method = "9CCA3A33D8ACCFBAC0FF1B014FB5FEA0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onTextChanged(CharSequence s, int where, int before, int after) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(after);
            dsTaint.addTaint(s);
            dsTaint.addTaint(before);
            dsTaint.addTaint(where);
            reflow(s, where, before, after);
            // ---------- Original Method ----------
            //reflow(s, where, before, after);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.030 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "E1E9B48623236A758AA5D88D665C2448")
        @DSModeled(DSC.SAFE)
        public void afterTextChanged(Editable s) {
            dsTaint.addTaint(s.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.030 -0400", hash_original_method = "37363E0323D4735EAF9288F365B55BBF", hash_generated_method = "A6AF03853FB3F32313625024FE1166DC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onSpanAdded(Spannable s, Object o, int start, int end) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(s.dsTaint);
            dsTaint.addTaint(start);
            dsTaint.addTaint(o.dsTaint);
            dsTaint.addTaint(end);
            reflow(s, start, end - start, end - start);
            // ---------- Original Method ----------
            //if (o instanceof UpdateLayout)
                //reflow(s, start, end - start, end - start);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.031 -0400", hash_original_method = "A697CB019B21FC660F8DBD66680C7AE1", hash_generated_method = "C0D5150FE7ACEC28BDCD2B28640B742C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onSpanRemoved(Spannable s, Object o, int start, int end) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(s.dsTaint);
            dsTaint.addTaint(start);
            dsTaint.addTaint(o.dsTaint);
            dsTaint.addTaint(end);
            reflow(s, start, end - start, end - start);
            // ---------- Original Method ----------
            //if (o instanceof UpdateLayout)
                //reflow(s, start, end - start, end - start);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.031 -0400", hash_original_method = "003DE2DC22FE06A8925B46C1AFC5A2FC", hash_generated_method = "F16DED5C6F748DA91C3A74C383FD817D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onSpanChanged(Spannable s, Object o, int start, int end, int nstart, int nend) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(nstart);
            dsTaint.addTaint(s.dsTaint);
            dsTaint.addTaint(start);
            dsTaint.addTaint(o.dsTaint);
            dsTaint.addTaint(nend);
            dsTaint.addTaint(end);
            {
                reflow(s, start, end - start, end - start);
                reflow(s, nstart, nend - nstart, nend - nstart);
            } //End block
            // ---------- Original Method ----------
            //if (o instanceof UpdateLayout) {
                //reflow(s, start, end - start, end - start);
                //reflow(s, nstart, nend - nstart, nend - nstart);
            //}
        }

        
    }


    
    private static final int PRIORITY = 128;
    private static StaticLayout sStaticLayout = new StaticLayout(null);
    private static final Object[] sLock = new Object[0];
    private static final int START = 0;
    private static final int DIR = START;
    private static final int TAB = START;
    private static final int TOP = 1;
    private static final int DESCENT = 2;
    private static final int COLUMNS_NORMAL = 3;
    private static final int ELLIPSIS_START = 3;
    private static final int ELLIPSIS_COUNT = 4;
    private static final int COLUMNS_ELLIPSIZE = 5;
    private static final int START_MASK = 0x1FFFFFFF;
    private static final int DIR_SHIFT  = 30;
    private static final int TAB_MASK   = 0x20000000;
    private static final int ELLIPSIS_UNDEFINED = 0x80000000;
}

