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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.982 -0400", hash_original_field = "70C30248F16505818D6F9EB3DE4F855F", hash_generated_field = "15367B8B2C746CFC484DB8A82189D9A1")

    private CharSequence mBase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.989 -0400", hash_original_field = "D29BCBAAD55DD1B1C5A0A9EB22E25252", hash_generated_field = "D786E4FA619E26D15C3AF77D65AC82C9")

    private CharSequence mDisplay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.989 -0400", hash_original_field = "47CD6CB6B9A4FA63425D0BEAFAF438EE", hash_generated_field = "AF0A8CD0AADCD6558B917FE8D5B77F9C")

    private ChangeWatcher mWatcher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.989 -0400", hash_original_field = "5C7867EDEC78F5A3873DA83596FFE315", hash_generated_field = "D5F745DDCD7E7F8BB6FD2B9B3C8B76DB")

    private boolean mIncludePad;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.989 -0400", hash_original_field = "A6C851B8D237A237217AF4B1A1901277", hash_generated_field = "17C12DE3A8C50D21AE8FD7905F843126")

    private boolean mEllipsize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.989 -0400", hash_original_field = "5713AC9F49879DE1055FA780DFEFDF1C", hash_generated_field = "C354DF48C5764CCC7B8B820C49BF2BBD")

    private int mEllipsizedWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.989 -0400", hash_original_field = "23595B992DF8C4652BDAE896F06DBE1E", hash_generated_field = "669F1DFECFA42485F4E61492CB215143")

    private TextUtils.TruncateAt mEllipsizeAt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.989 -0400", hash_original_field = "268A075DF5CE7F2275707CC0D79AD1E3", hash_generated_field = "F71EEB15D0A10CA360B6D2DAC14050D2")

    private PackedIntVector mInts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.989 -0400", hash_original_field = "EBF544E4173D2D8B065068D8E591BD40", hash_generated_field = "98DE842C94CE85760CB5F06A2EB32DA3")

    private PackedObjectVector<Directions> mObjects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.989 -0400", hash_original_field = "A6796D45932911E4DA1D9D40D1BD23B8", hash_generated_field = "74C5EEEB9113B0F29D66E0A4983A6BC3")

    private int mTopPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.989 -0400", hash_original_field = "097A31AA17188409E251DABE4869FAFE", hash_generated_field = "8A7C981A0C6837E513C477AD1250B374")

    private int mBottomPadding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.990 -0400", hash_original_method = "DB07DE8DB9A02739307D238F9A46C5FB", hash_generated_method = "FA44B837B658169917187694D7917C1E")
    public  DynamicLayout(CharSequence base,
                         TextPaint paint,
                         int width, Alignment align,
                         float spacingmult, float spacingadd,
                         boolean includepad) {
        this(base, base, paint, width, align, spacingmult, spacingadd,
             includepad);
        addTaint(base.getTaint());
        addTaint(paint.getTaint());
        addTaint(width);
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(includepad);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.990 -0400", hash_original_method = "BEECDC91516286CCE30494A55398B48A", hash_generated_method = "C80BB7234B4076E4BB34D9FF4B3AFC9B")
    public  DynamicLayout(CharSequence base, CharSequence display,
                         TextPaint paint,
                         int width, Alignment align,
                         float spacingmult, float spacingadd,
                         boolean includepad) {
        this(base, display, paint, width, align, spacingmult, spacingadd,
             includepad, null, 0);
        addTaint(base.getTaint());
        addTaint(display.getTaint());
        addTaint(paint.getTaint());
        addTaint(width);
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(includepad);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.005 -0400", hash_original_method = "F5040E07E9B927EF44F79345AA20F61D", hash_generated_method = "D036986D8EC2A2562B5290B2FF8DEF8F")
    public  DynamicLayout(CharSequence base, CharSequence display,
                         TextPaint paint,
                         int width, Alignment align,
                         float spacingmult, float spacingadd,
                         boolean includepad,
                         TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        this(base, display, paint, width, align, TextDirectionHeuristics.FIRSTSTRONG_LTR,
                spacingmult, spacingadd, includepad, ellipsize, ellipsizedWidth);
        addTaint(base.getTaint());
        addTaint(display.getTaint());
        addTaint(paint.getTaint());
        addTaint(width);
        addTaint(align.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        addTaint(includepad);
        addTaint(ellipsize.getTaint());
        addTaint(ellipsizedWidth);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.008 -0400", hash_original_method = "E989442183EB5456191B90B4A9B0462E", hash_generated_method = "19FB8F83A71C9D003F1AAA577FEC417C")
    public  DynamicLayout(CharSequence base, CharSequence display,
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
        {
            mInts = new PackedIntVector(COLUMNS_ELLIPSIZE);
            mEllipsizedWidth = ellipsizedWidth;
            mEllipsizeAt = ellipsize;
        } //End block
        {
            mInts = new PackedIntVector(COLUMNS_NORMAL);
            mEllipsizedWidth = width;
            mEllipsizeAt = null;
        } //End block
        mObjects = new PackedObjectVector<Directions>(1);
        mIncludePad = includepad;
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
        addTaint(paint.getTaint());
        addTaint(align.getTaint());
        addTaint(textDir.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.038 -0400", hash_original_method = "680F026D747328AC88C64FC8C5845240", hash_generated_method = "8499BF99B3BCAFEBDF35873786A8F0A7")
    private void reflow(CharSequence s, int where, int before, int after) {
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
            boolean varA8F26B230E6C690FEFF73B0BFCB1FB0E_928705075 = (where + after != len &&
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
        addTaint(s.getTaint());
        addTaint(where);
        addTaint(before);
        addTaint(after);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.039 -0400", hash_original_method = "152FA51B02D5FF2B246CE19D3B6F70D3", hash_generated_method = "A19D8BC79DA92111CCB609D04A5F6A25")
    @Override
    public int getLineCount() {
        int var5CACA94FC5780744C6E7317B6E5C4CD8_195453194 = (mInts.size() - 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120021887 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120021887;
        // ---------- Original Method ----------
        //return mInts.size() - 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.039 -0400", hash_original_method = "D6F378A47E9DC69D83D62FCE6E90C326", hash_generated_method = "DF5C792DE009733579E19205FDA08ACC")
    @Override
    public int getLineTop(int line) {
        int var93A1DB78A00AEEDC2C8FFA797CB1C236_246102170 = (mInts.getValue(line, TOP));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1357279950 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1357279950;
        // ---------- Original Method ----------
        //return mInts.getValue(line, TOP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.040 -0400", hash_original_method = "730DAEEEE356A285055D20F0106F731A", hash_generated_method = "5A5846AB47E34E5BE84B1609FFF3841F")
    @Override
    public int getLineDescent(int line) {
        int var2F83A1C66F15F4DFFD63244CE36A39E3_1496256832 = (mInts.getValue(line, DESCENT));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1647236661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1647236661;
        // ---------- Original Method ----------
        //return mInts.getValue(line, DESCENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.040 -0400", hash_original_method = "2D0F6CD810E708D2F846F779125A5CEA", hash_generated_method = "5FCCAF0763C2CA3EF7657E2F5DC5ECAA")
    @Override
    public int getLineStart(int line) {
        int var2E609AA1AE48CD56C499FC299D542025_1103158422 = (mInts.getValue(line, START) & START_MASK);
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764085314 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764085314;
        // ---------- Original Method ----------
        //return mInts.getValue(line, START) & START_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.045 -0400", hash_original_method = "A0EC5BA65111126AB58C28059BDF3DD2", hash_generated_method = "3F3AB376E990FCA89C90CE09AEFB314C")
    @Override
    public boolean getLineContainsTab(int line) {
        boolean var6812F2F3EF40E71A52EA6BFF67D6C857_931312909 = ((mInts.getValue(line, TAB) & TAB_MASK) != 0);
        addTaint(line);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1829377003 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1829377003;
        // ---------- Original Method ----------
        //return (mInts.getValue(line, TAB) & TAB_MASK) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.046 -0400", hash_original_method = "54E53FDCC15DB3057A5F7E1DF0F2D93F", hash_generated_method = "B4C7FC8F422DB2594FE22903E8245CB7")
    @Override
    public int getParagraphDirection(int line) {
        int var70DA67A2D1659A19E3C11C8D9A8D14F9_467281680 = (mInts.getValue(line, DIR) >> DIR_SHIFT);
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1292832201 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1292832201;
        // ---------- Original Method ----------
        //return mInts.getValue(line, DIR) >> DIR_SHIFT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.051 -0400", hash_original_method = "632C7F2120605B5CA7A1A3052A452575", hash_generated_method = "6B9ED8CB1C465626B6004EA72F8AA644")
    @Override
    public final Directions getLineDirections(int line) {
        Directions varB4EAC82CA7396A68D541C85D26508E83_85484985 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_85484985 = mObjects.getValue(line, 0);
        addTaint(line);
        varB4EAC82CA7396A68D541C85D26508E83_85484985.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_85484985;
        // ---------- Original Method ----------
        //return mObjects.getValue(line, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.052 -0400", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "6D035E92F73F9A49DCF2BE22B3963FEC")
    @Override
    public int getTopPadding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836502691 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836502691;
        // ---------- Original Method ----------
        //return mTopPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.052 -0400", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "9BD62BC7D2C2DF4C46E06BB26B9EBFC0")
    @Override
    public int getBottomPadding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231388360 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231388360;
        // ---------- Original Method ----------
        //return mBottomPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.053 -0400", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "45ED898D722E187EEE5C34307989FBA7")
    @Override
    public int getEllipsizedWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971566609 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971566609;
        // ---------- Original Method ----------
        //return mEllipsizedWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.057 -0400", hash_original_method = "C2BA24D83CCF8B46DBDB9E42876D7FC0", hash_generated_method = "D446FD29DF0C6BFD76CB52BDCA594C5E")
    @Override
    public int getEllipsisStart(int line) {
        int varD7B9ACF21B6113CC7B0610D40B77095D_152591830 = (mInts.getValue(line, ELLIPSIS_START));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1708175326 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1708175326;
        // ---------- Original Method ----------
        //if (mEllipsizeAt == null) {
            //return 0;
        //}
        //return mInts.getValue(line, ELLIPSIS_START);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.058 -0400", hash_original_method = "8861D8B0168294A81E05E00D1A35F6B4", hash_generated_method = "4D471AB6ADEAAC5FE4F9D539FBE2B620")
    @Override
    public int getEllipsisCount(int line) {
        int var2F960C4354B27712541F6BCCD9E7C558_237959891 = (mInts.getValue(line, ELLIPSIS_COUNT));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1906183415 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1906183415;
        // ---------- Original Method ----------
        //if (mEllipsizeAt == null) {
            //return 0;
        //}
        //return mInts.getValue(line, ELLIPSIS_COUNT);
    }

    
    private static class ChangeWatcher implements TextWatcher, SpanWatcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.058 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "8D1810AB5CD5D0106C47C451BC1214A2")

        private WeakReference<DynamicLayout> mLayout;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.059 -0400", hash_original_method = "5B008785D1A2C7A00F27EBFB90B5E73C", hash_generated_method = "B82CCE3403554F8EA355C68CA40E1262")
        public  ChangeWatcher(DynamicLayout layout) {
            mLayout = new WeakReference<DynamicLayout>(layout);
            // ---------- Original Method ----------
            //mLayout = new WeakReference<DynamicLayout>(layout);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.070 -0400", hash_original_method = "86BF27AD60282A12928BABF6F115B549", hash_generated_method = "C70E54DCA07EF91059F4849C50632E79")
        private void reflow(CharSequence s, int where, int before, int after) {
            DynamicLayout ml;
            ml = mLayout.get();
            ml.reflow(s, where, before, after);
            ((Spannable) s).removeSpan(this);
            addTaint(s.getTaint());
            addTaint(where);
            addTaint(before);
            addTaint(after);
            // ---------- Original Method ----------
            //DynamicLayout ml = mLayout.get();
            //if (ml != null)
                //ml.reflow(s, where, before, after);
            //else if (s instanceof Spannable)
                //((Spannable) s).removeSpan(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.071 -0400", hash_original_method = "95E45B237E67DBC952009C430C254747", hash_generated_method = "4F775BE1160AA8E838671D141E4576EC")
        public void beforeTextChanged(CharSequence s, int where, int before, int after) {
            addTaint(s.getTaint());
            addTaint(where);
            addTaint(before);
            addTaint(after);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.071 -0400", hash_original_method = "64CFCAB8C5BCD960BA37993088223F2C", hash_generated_method = "F3D86709FA423F741928E6B3E79331A4")
        public void onTextChanged(CharSequence s, int where, int before, int after) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            reflow(s, where, before, after);
            addTaint(s.getTaint());
            addTaint(where);
            addTaint(before);
            addTaint(after);
            // ---------- Original Method ----------
            //reflow(s, where, before, after);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.072 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "B1E73F6E6A3A9E89AEF9681CB19F89E5")
        public void afterTextChanged(Editable s) {
            addTaint(s.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.072 -0400", hash_original_method = "37363E0323D4735EAF9288F365B55BBF", hash_generated_method = "4C017584AE0F4814C51C5CA62247C632")
        public void onSpanAdded(Spannable s, Object o, int start, int end) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            reflow(s, start, end - start, end - start);
            addTaint(s.getTaint());
            addTaint(o.getTaint());
            addTaint(start);
            addTaint(end);
            // ---------- Original Method ----------
            //if (o instanceof UpdateLayout)
                //reflow(s, start, end - start, end - start);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.084 -0400", hash_original_method = "A697CB019B21FC660F8DBD66680C7AE1", hash_generated_method = "23B0436D72C3392806FAE1B1375AD190")
        public void onSpanRemoved(Spannable s, Object o, int start, int end) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            reflow(s, start, end - start, end - start);
            addTaint(s.getTaint());
            addTaint(o.getTaint());
            addTaint(start);
            addTaint(end);
            // ---------- Original Method ----------
            //if (o instanceof UpdateLayout)
                //reflow(s, start, end - start, end - start);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.085 -0400", hash_original_method = "003DE2DC22FE06A8925B46C1AFC5A2FC", hash_generated_method = "6FD5A13FE0605F943B351C77C76985A5")
        public void onSpanChanged(Spannable s, Object o, int start, int end, int nstart, int nend) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                reflow(s, start, end - start, end - start);
                reflow(s, nstart, nend - nstart, nend - nstart);
            } //End block
            addTaint(s.getTaint());
            addTaint(o.getTaint());
            addTaint(start);
            addTaint(end);
            addTaint(nstart);
            addTaint(nend);
            // ---------- Original Method ----------
            //if (o instanceof UpdateLayout) {
                //reflow(s, start, end - start, end - start);
                //reflow(s, nstart, nend - nstart, nend - nstart);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.085 -0400", hash_original_field = "3EFDE694331F395874E68C1564D97D01", hash_generated_field = "B39264F5C3595B9D142990C0F923E905")

    private static int PRIORITY = 128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.085 -0400", hash_original_field = "3E985220B3B2B397EBA733973484F2C1", hash_generated_field = "8547CB2E7AAF865B43A1389F1EFA4F37")

    private static StaticLayout sStaticLayout = new StaticLayout(null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.085 -0400", hash_original_field = "FD588D0BA09E2DE573D6AB2267D28AEB", hash_generated_field = "2414935848B92962C171B2E9A09E6A7D")

    private static Object[] sLock = new Object[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.085 -0400", hash_original_field = "28651E175A74BF99AEB0613FFD9E4311", hash_generated_field = "AE5FE26EA7B9C33A397985D690BEF58C")

    private static int START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.085 -0400", hash_original_field = "96C94187E98129DC7ED52B022D56B56E", hash_generated_field = "6D6C23CE3BFB22BC047670327434A860")

    private static int DIR = START;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.085 -0400", hash_original_field = "03E7882B92ED9688C792A4DF3CCA212F", hash_generated_field = "05A11F5EBF953A33392F393CCDD725E2")

    private static int TAB = START;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.086 -0400", hash_original_field = "571D16AE4FA766DA4380F84D324027BE", hash_generated_field = "84E5B0980A9DB65D83B460DD28EC105D")

    private static int TOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.086 -0400", hash_original_field = "4DF1087155B53EE865ED8DEFEF0D2F7E", hash_generated_field = "BCA811FF720210FC7C8CADA392DE1774")

    private static int DESCENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.086 -0400", hash_original_field = "3AE51DFCA721DA74B9FE7AE826399C5B", hash_generated_field = "82B151F86E6336E7EBABD8B0D2554020")

    private static int COLUMNS_NORMAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.086 -0400", hash_original_field = "11658650D3EBC5004F1DE2593A19D91C", hash_generated_field = "EB2805516F22F0D795546FE4326DA5A9")

    private static int ELLIPSIS_START = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.086 -0400", hash_original_field = "9DEA8A3EF4097355E23BEB471268468C", hash_generated_field = "542C907F634133B97C93B9DB7D8B9BDC")

    private static int ELLIPSIS_COUNT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.086 -0400", hash_original_field = "55DF56DF384DF5793030D40F84610E92", hash_generated_field = "A3A118F5E931345ED3AA870AD0322498")

    private static int COLUMNS_ELLIPSIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.086 -0400", hash_original_field = "479F76462347F1E81B6EC92F50573413", hash_generated_field = "F4AF13B0F41E7915D7A01D78326744F8")

    private static int START_MASK = 0x1FFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.086 -0400", hash_original_field = "3CE9D0897644F1685651D602FF457A11", hash_generated_field = "26F6116498B4B99F247AFFED1D2ADAC3")

    private static int DIR_SHIFT = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.086 -0400", hash_original_field = "C52FA1DB43D0A9E4AB2D27DC3ED50BD6", hash_generated_field = "CE6C698FB46054E82230E9F62AB1B199")

    private static int TAB_MASK = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.086 -0400", hash_original_field = "89FC1B0F65C5879D4CBF1940D7C8EE5F", hash_generated_field = "BBFA86E9FFA8835C9A2649C05E016888")

    private static int ELLIPSIS_UNDEFINED = 0x80000000;
}

