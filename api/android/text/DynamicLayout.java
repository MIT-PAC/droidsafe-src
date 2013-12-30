package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;

import android.graphics.Paint;
import android.text.style.UpdateLayout;
import android.text.style.WrapTogetherSpan;





public class DynamicLayout extends Layout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:12.979 -0500", hash_original_field = "DB07E1361BFAFEB6A434A5E2178E432A", hash_generated_field = "4411169D7FD82CBF8AA4F3F3F57792B5")

    private static final int PRIORITY = 128;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.083 -0500", hash_original_field = "DF90238A91F7367C329D091B3F04FA41", hash_generated_field = "8547CB2E7AAF865B43A1389F1EFA4F37")


    private static StaticLayout sStaticLayout = new StaticLayout(null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.086 -0500", hash_original_field = "14A59CFC333E208499C98B6D3860ADDD", hash_generated_field = "6FA9B47DB08FC419C50F72FDCF40883C")


    private static final Object[] sLock = new Object[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.089 -0500", hash_original_field = "27A41ADDFF59BC8B58A601456818918E", hash_generated_field = "D858CF53160507E553F41D31EE5B91B4")


    private static final int START = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.092 -0500", hash_original_field = "A93E36DA171556A9DAC174A6CE0830C7", hash_generated_field = "00A39BB8E63058E1AB6D38D081403510")

    private static final int DIR = START;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.094 -0500", hash_original_field = "858D40657E9E9D49DB24D92DE4881B0D", hash_generated_field = "F85A3E18A8BF309A20F781E644D5A08F")

    private static final int TAB = START;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.097 -0500", hash_original_field = "A9E5EAD368A2540BAA81385F8F37A77E", hash_generated_field = "1A855B733EBA6E8672640513C3B16A39")

    private static final int TOP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.100 -0500", hash_original_field = "142D08D09F2ADDBEAFFE8AF39C3868BD", hash_generated_field = "A52FCC4891B5FC0ED83D62A588ACAE05")

    private static final int DESCENT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.102 -0500", hash_original_field = "E6CE03C5744B90BA483BE6BF0E85AD41", hash_generated_field = "CD7507056B56DB550B1D813FB4B3D98B")

    private static final int COLUMNS_NORMAL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.105 -0500", hash_original_field = "DCAA152E596CCF7D943D5B21A68B86B4", hash_generated_field = "E2BDE677DE1C429BF2BE569E18329E43")


    private static final int ELLIPSIS_START = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.108 -0500", hash_original_field = "664582F8629EEEC6D6294BAB4BA1269C", hash_generated_field = "1B418124A7F291F864D2626D0BD306EC")

    private static final int ELLIPSIS_COUNT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.110 -0500", hash_original_field = "4BC40476543CA50D93E7CE73D5E42064", hash_generated_field = "67237E10844A87633E2718F5190772DB")

    private static final int COLUMNS_ELLIPSIZE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.113 -0500", hash_original_field = "51ABBD2944D24467D63DD23BADE8CD8B", hash_generated_field = "E308275B4AE398B992072A6F7EA1A3C0")


    private static final int START_MASK = 0x1FFFFFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.116 -0500", hash_original_field = "2174DD8845E3505750875CAA65AA1573", hash_generated_field = "B97E7A8E8F664E1C1793F75E8020C7A1")

    private static final int DIR_SHIFT  = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.118 -0500", hash_original_field = "D0EFD515F99E5C7C1D37F987D229A266", hash_generated_field = "8DE592C2FC67BEDD6F7461E40AD4FEE6")

    private static final int TAB_MASK   = 0x20000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.121 -0500", hash_original_field = "E7262C5494D60C26E4431EA6F64A2187", hash_generated_field = "5F25A8AF84EF55C73DA55AAF6E9BEDC2")


    private static final int ELLIPSIS_UNDEFINED = 0x80000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.059 -0500", hash_original_field = "5AA8BCA90D20DE4EA6AD7DD52311E654", hash_generated_field = "15367B8B2C746CFC484DB8A82189D9A1")


    private CharSequence mBase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.061 -0500", hash_original_field = "189B1E7169C8774EF368745574371CB9", hash_generated_field = "D786E4FA619E26D15C3AF77D65AC82C9")

    private CharSequence mDisplay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.064 -0500", hash_original_field = "25B5E11329C5A32CABC3CE678612BCEB", hash_generated_field = "AF0A8CD0AADCD6558B917FE8D5B77F9C")

    private ChangeWatcher mWatcher;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.066 -0500", hash_original_field = "4D18465BEA61E0F3B2E254E94081A19F", hash_generated_field = "D5F745DDCD7E7F8BB6FD2B9B3C8B76DB")

    private boolean mIncludePad;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.068 -0500", hash_original_field = "18FB6BF8D00258024FB5DFA7D01873F2", hash_generated_field = "17C12DE3A8C50D21AE8FD7905F843126")

    private boolean mEllipsize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.071 -0500", hash_original_field = "E93A6A7C15DB787403A51782F6607C39", hash_generated_field = "C354DF48C5764CCC7B8B820C49BF2BBD")

    private int mEllipsizedWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.074 -0500", hash_original_field = "5065FE4467794D302B2F26F70EAAD181", hash_generated_field = "669F1DFECFA42485F4E61492CB215143")

    private TextUtils.TruncateAt mEllipsizeAt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.076 -0500", hash_original_field = "2378F15AEBE8A9C41DDAE9AAFF8C252A", hash_generated_field = "F71EEB15D0A10CA360B6D2DAC14050D2")


    private PackedIntVector mInts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.078 -0500", hash_original_field = "D805E6BC96EF3A5326067E731C769A16", hash_generated_field = "98DE842C94CE85760CB5F06A2EB32DA3")

    private PackedObjectVector<Directions> mObjects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.529 -0400", hash_original_field = "A6796D45932911E4DA1D9D40D1BD23B8", hash_generated_field = "74C5EEEB9113B0F29D66E0A4983A6BC3")

    private int mTopPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.529 -0400", hash_original_field = "097A31AA17188409E251DABE4869FAFE", hash_generated_field = "8A7C981A0C6837E513C477AD1250B374")

    private int mBottomPadding;

    /**
     * Make a layout for the specified text that will be updated as
     * the text is changed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:12.982 -0500", hash_original_method = "DB07DE8DB9A02739307D238F9A46C5FB", hash_generated_method = "D182B88943E9D1831B024BB12CBD1E48")
    
public DynamicLayout(CharSequence base,
                         TextPaint paint,
                         int width, Alignment align,
                         float spacingmult, float spacingadd,
                         boolean includepad) {
        this(base, base, paint, width, align, spacingmult, spacingadd,
             includepad);
    }

    
    private static class ChangeWatcher implements TextWatcher, SpanWatcher {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.049 -0500", hash_original_field = "3F723A8AEB8B508D6DA28FFF8085A253", hash_generated_field = "8D1810AB5CD5D0106C47C451BC1214A2")


        private WeakReference<DynamicLayout> mLayout;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.028 -0500", hash_original_method = "5B008785D1A2C7A00F27EBFB90B5E73C", hash_generated_method = "3D162BC9F486D17A9A8609C8CF801F1A")
        
public ChangeWatcher(DynamicLayout layout) {
            mLayout = new WeakReference<DynamicLayout>(layout);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.031 -0500", hash_original_method = "86BF27AD60282A12928BABF6F115B549", hash_generated_method = "423424869722B4931BA721A1164C1132")
        
private void reflow(CharSequence s, int where, int before, int after) {
            DynamicLayout ml = mLayout.get();

            if (ml != null)
                ml.reflow(s, where, before, after);
            else if (s instanceof Spannable)
                ((Spannable) s).removeSpan(this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.033 -0500", hash_original_method = "95E45B237E67DBC952009C430C254747", hash_generated_method = "11F3F277F5BC25C88EEDCDDEF44FAB8D")
        
public void beforeTextChanged(CharSequence s, int where, int before, int after) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.036 -0500", hash_original_method = "64CFCAB8C5BCD960BA37993088223F2C", hash_generated_method = "7CE220A05661BCB16351929B659CD72C")
        
public void onTextChanged(CharSequence s, int where, int before, int after) {
            reflow(s, where, before, after);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.038 -0500", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "2CA8AA1A2C364C11E3B9B522008CAC9F")
        
public void afterTextChanged(Editable s) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.041 -0500", hash_original_method = "37363E0323D4735EAF9288F365B55BBF", hash_generated_method = "00DE9506BAA1D6F5570C25C0F25203AA")
        
public void onSpanAdded(Spannable s, Object o, int start, int end) {
            if (o instanceof UpdateLayout)
                reflow(s, start, end - start, end - start);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.044 -0500", hash_original_method = "A697CB019B21FC660F8DBD66680C7AE1", hash_generated_method = "F0A717836FC9E4BD2D4C19554686BBFB")
        
public void onSpanRemoved(Spannable s, Object o, int start, int end) {
            if (o instanceof UpdateLayout)
                reflow(s, start, end - start, end - start);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.046 -0500", hash_original_method = "003DE2DC22FE06A8925B46C1AFC5A2FC", hash_generated_method = "66B098D90E6434342F6D789CCF607F2D")
        
public void onSpanChanged(Spannable s, Object o, int start, int end, int nstart, int nend) {
            if (o instanceof UpdateLayout) {
                reflow(s, start, end - start, end - start);
                reflow(s, nstart, nend - nstart, nend - nstart);
            }
        }

        
    }

    /**
     * Make a layout for the transformed text (password transformation
     * being the primary example of a transformation)
     * that will be updated as the base text is changed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:12.985 -0500", hash_original_method = "BEECDC91516286CCE30494A55398B48A", hash_generated_method = "67BEFFC721666B9B08A92F0A726B4D45")
    
public DynamicLayout(CharSequence base, CharSequence display,
                         TextPaint paint,
                         int width, Alignment align,
                         float spacingmult, float spacingadd,
                         boolean includepad) {
        this(base, display, paint, width, align, spacingmult, spacingadd,
             includepad, null, 0);
    }

    /**
     * Make a layout for the transformed text (password transformation
     * being the primary example of a transformation)
     * that will be updated as the base text is changed.
     * If ellipsize is non-null, the Layout will ellipsize the text
     * down to ellipsizedWidth.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:12.987 -0500", hash_original_method = "F5040E07E9B927EF44F79345AA20F61D", hash_generated_method = "8D33E80FC3E9A75B712A1E7DBCB79447")
    
public DynamicLayout(CharSequence base, CharSequence display,
                         TextPaint paint,
                         int width, Alignment align,
                         float spacingmult, float spacingadd,
                         boolean includepad,
                         TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        this(base, display, paint, width, align, TextDirectionHeuristics.FIRSTSTRONG_LTR,
                spacingmult, spacingadd, includepad, ellipsize, ellipsizedWidth);
    }

    /**
     * Make a layout for the transformed text (password transformation
     * being the primary example of a transformation)
     * that will be updated as the base text is changed.
     * If ellipsize is non-null, the Layout will ellipsize the text
     * down to ellipsizedWidth.
     * *
     * *@hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:12.992 -0500", hash_original_method = "E989442183EB5456191B90B4A9B0462E", hash_generated_method = "A0EA92A4BFF13880B7225A9A4A437A95")
    
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

        mBase = base;
        mDisplay = display;

        if (ellipsize != null) {
            mInts = new PackedIntVector(COLUMNS_ELLIPSIZE);
            mEllipsizedWidth = ellipsizedWidth;
            mEllipsizeAt = ellipsize;
        } else {
            mInts = new PackedIntVector(COLUMNS_NORMAL);
            mEllipsizedWidth = width;
            mEllipsizeAt = null;
        }

        mObjects = new PackedObjectVector<Directions>(1);

        mIncludePad = includepad;

        /*
         * This is annoying, but we can't refer to the layout until
         * superclass construction is finished, and the superclass
         * constructor wants the reference to the display text.
         *
         * This will break if the superclass constructor ever actually
         * cares about the content instead of just holding the reference.
         */
        if (ellipsize != null) {
            Ellipsizer e = (Ellipsizer) getText();

            e.mLayout = this;
            e.mWidth = ellipsizedWidth;
            e.mMethod = ellipsize;
            mEllipsize = true;
        }

        // Initial state is a single line with 0 characters (0 to 0),
        // with top at 0 and bottom at whatever is natural, and
        // undefined ellipsis.

        int[] start;

        if (ellipsize != null) {
            start = new int[COLUMNS_ELLIPSIZE];
            start[ELLIPSIS_START] = ELLIPSIS_UNDEFINED;
        } else {
            start = new int[COLUMNS_NORMAL];
        }

        Directions[] dirs = new Directions[] { DIRS_ALL_LEFT_TO_RIGHT };

        Paint.FontMetricsInt fm = paint.getFontMetricsInt();
        int asc = fm.ascent;
        int desc = fm.descent;

        start[DIR] = DIR_LEFT_TO_RIGHT << DIR_SHIFT;
        start[TOP] = 0;
        start[DESCENT] = desc;
        mInts.insertAt(0, start);

        start[TOP] = desc - asc;
        mInts.insertAt(1, start);

        mObjects.insertAt(0, dirs);

        // Update from 0 characters to whatever the real text is

        reflow(base, 0, 0, base.length());

        if (base instanceof Spannable) {
            if (mWatcher == null)
                mWatcher = new ChangeWatcher(this);

            // Strip out any watchers for other DynamicLayouts.
            Spannable sp = (Spannable) base;
            ChangeWatcher[] spans = sp.getSpans(0, sp.length(), ChangeWatcher.class);
            for (int i = 0; i < spans.length; i++)
                sp.removeSpan(spans[i]);

            sp.setSpan(mWatcher, 0, base.length(),
                       Spannable.SPAN_INCLUSIVE_INCLUSIVE |
                       (PRIORITY << Spannable.SPAN_PRIORITY_SHIFT));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:12.998 -0500", hash_original_method = "680F026D747328AC88C64FC8C5845240", hash_generated_method = "C5027D20EAD7997CDB812FBFA53EFCF9")
    
private void reflow(CharSequence s, int where, int before, int after) {
        if (s != mBase)
            return;

        CharSequence text = mDisplay;
        int len = text.length();

        // seek back to the start of the paragraph

        int find = TextUtils.lastIndexOf(text, '\n', where - 1);
        if (find < 0)
            find = 0;
        else
            find = find + 1;

        {
            int diff = where - find;
            before += diff;
            after += diff;
            where -= diff;
        }

        // seek forward to the end of the paragraph

        int look = TextUtils.indexOf(text, '\n', where + after);
        if (look < 0)
            look = len;
        else
            look++; // we want the index after the \n

        int change = look - (where + after);
        before += change;
        after += change;

        // seek further out to cover anything that is forced to wrap together

        if (text instanceof Spanned) {
            Spanned sp = (Spanned) text;
            boolean again;

            do {
                again = false;

                Object[] force = sp.getSpans(where, where + after,
                                             WrapTogetherSpan.class);

                for (int i = 0; i < force.length; i++) {
                    int st = sp.getSpanStart(force[i]);
                    int en = sp.getSpanEnd(force[i]);

                    if (st < where) {
                        again = true;

                        int diff = where - st;
                        before += diff;
                        after += diff;
                        where -= diff;
                    }

                    if (en > where + after) {
                        again = true;

                        int diff = en - (where + after);
                        before += diff;
                        after += diff;
                    }
                }
            } while (again);
        }

        // find affected region of old layout

        int startline = getLineForOffset(where);
        int startv = getLineTop(startline);

        int endline = getLineForOffset(where + before);
        if (where + after == len)
            endline = getLineCount();
        int endv = getLineTop(endline);
        boolean islast = (endline == getLineCount());

        // generate new layout for affected text

        StaticLayout reflowed;

        synchronized (sLock) {
            reflowed = sStaticLayout;
            sStaticLayout = null;
        }

        if (reflowed == null) {
            reflowed = new StaticLayout(null);
        } else {
            reflowed.prepare();
        }

        reflowed.generate(text, where, where + after,
                getPaint(), getWidth(), getTextDirectionHeuristic(), getSpacingMultiplier(),
                getSpacingAdd(), false,
                true, mEllipsizedWidth, mEllipsizeAt);
        int n = reflowed.getLineCount();

        // If the new layout has a blank line at the end, but it is not
        // the very end of the buffer, then we already have a line that
        // starts there, so disregard the blank line.

        if (where + after != len &&
            reflowed.getLineStart(n - 1) == where + after)
            n--;

        // remove affected lines from old layout

        mInts.deleteAt(startline, endline - startline);
        mObjects.deleteAt(startline, endline - startline);

        // adjust offsets in layout for new height and offsets

        int ht = reflowed.getLineTop(n);
        int toppad = 0, botpad = 0;

        if (mIncludePad && startline == 0) {
            toppad = reflowed.getTopPadding();
            mTopPadding = toppad;
            ht -= toppad;
        }
        if (mIncludePad && islast) {
            botpad = reflowed.getBottomPadding();
            mBottomPadding = botpad;
            ht += botpad;
        }

        mInts.adjustValuesBelow(startline, START, after - before);
        mInts.adjustValuesBelow(startline, TOP, startv - endv + ht);

        // insert new layout

        int[] ints;

        if (mEllipsize) {
            ints = new int[COLUMNS_ELLIPSIZE];
            ints[ELLIPSIS_START] = ELLIPSIS_UNDEFINED;
        } else {
            ints = new int[COLUMNS_NORMAL];
        }

        Directions[] objects = new Directions[1];

        for (int i = 0; i < n; i++) {
            ints[START] = reflowed.getLineStart(i) |
                          (reflowed.getParagraphDirection(i) << DIR_SHIFT) |
                          (reflowed.getLineContainsTab(i) ? TAB_MASK : 0);

            int top = reflowed.getLineTop(i) + startv;
            if (i > 0)
                top -= toppad;
            ints[TOP] = top;

            int desc = reflowed.getLineDescent(i);
            if (i == n - 1)
                desc += botpad;

            ints[DESCENT] = desc;
            objects[0] = reflowed.getLineDirections(i);

            if (mEllipsize) {
                ints[ELLIPSIS_START] = reflowed.getEllipsisStart(i);
                ints[ELLIPSIS_COUNT] = reflowed.getEllipsisCount(i);
            }

            mInts.insertAt(startline + i, ints);
            mObjects.insertAt(startline + i, objects);
        }

        synchronized (sLock) {
            sStaticLayout = reflowed;
            reflowed.finish();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.001 -0500", hash_original_method = "152FA51B02D5FF2B246CE19D3B6F70D3", hash_generated_method = "CC1C88D38AFD959022580027F44A131A")
    
@Override
    public int getLineCount() {
        return mInts.size() - 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.004 -0500", hash_original_method = "D6F378A47E9DC69D83D62FCE6E90C326", hash_generated_method = "8C3BE57369149F292E0CDECC247CD2E8")
    
@Override
    public int getLineTop(int line) {
        return mInts.getValue(line, TOP);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.006 -0500", hash_original_method = "730DAEEEE356A285055D20F0106F731A", hash_generated_method = "2754D367D485AD7D05CAD612FD563651")
    
@Override
    public int getLineDescent(int line) {
        return mInts.getValue(line, DESCENT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.009 -0500", hash_original_method = "2D0F6CD810E708D2F846F779125A5CEA", hash_generated_method = "09AB562361EE24C85E8246B466BFA61D")
    
@Override
    public int getLineStart(int line) {
        return mInts.getValue(line, START) & START_MASK;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.011 -0500", hash_original_method = "A0EC5BA65111126AB58C28059BDF3DD2", hash_generated_method = "FD6BADC82DA978D7DCB95F13EB5829B3")
    
@Override
    public boolean getLineContainsTab(int line) {
        return (mInts.getValue(line, TAB) & TAB_MASK) != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.014 -0500", hash_original_method = "54E53FDCC15DB3057A5F7E1DF0F2D93F", hash_generated_method = "DA61D920D7C002B928BB90BBBA526ADE")
    
@Override
    public int getParagraphDirection(int line) {
        return mInts.getValue(line, DIR) >> DIR_SHIFT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.017 -0500", hash_original_method = "632C7F2120605B5CA7A1A3052A452575", hash_generated_method = "1D18FA541C7C62643119EEF20F3CDF78")
    
@Override
    public final Directions getLineDirections(int line) {
        return mObjects.getValue(line, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.019 -0500", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "C9A37F9D7E53BC032BE1989D8B7F43F3")
    
@Override
    public int getTopPadding() {
        return mTopPadding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.022 -0500", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "F0B9D53486F44C4D9B5E36E2D1B1C62A")
    
@Override
    public int getBottomPadding() {
        return mBottomPadding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.024 -0500", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "466A36682DB1C1AD0B2234723777A380")
    
@Override
    public int getEllipsizedWidth() {
        return mEllipsizedWidth;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.053 -0500", hash_original_method = "C2BA24D83CCF8B46DBDB9E42876D7FC0", hash_generated_method = "E1691EFEB29DA3D8A46F947435E4B747")
    
@Override
    public int getEllipsisStart(int line) {
        if (mEllipsizeAt == null) {
            return 0;
        }

        return mInts.getValue(line, ELLIPSIS_START);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.056 -0500", hash_original_method = "8861D8B0168294A81E05E00D1A35F6B4", hash_generated_method = "1C8ED8CB9C6D797E4FFBEFBE4408DFDF")
    
@Override
    public int getEllipsisCount(int line) {
        if (mEllipsizeAt == null) {
            return 0;
        }

        return mInts.getValue(line, ELLIPSIS_COUNT);
    }
}

