package android.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Paint;
import android.text.style.UpdateLayout;
import android.text.style.WrapTogetherSpan;
import java.lang.ref.WeakReference;

public class DynamicLayout extends Layout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.639 -0400", hash_original_field = "70C30248F16505818D6F9EB3DE4F855F", hash_generated_field = "15367B8B2C746CFC484DB8A82189D9A1")

    private CharSequence mBase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.639 -0400", hash_original_field = "D29BCBAAD55DD1B1C5A0A9EB22E25252", hash_generated_field = "D786E4FA619E26D15C3AF77D65AC82C9")

    private CharSequence mDisplay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.639 -0400", hash_original_field = "47CD6CB6B9A4FA63425D0BEAFAF438EE", hash_generated_field = "AF0A8CD0AADCD6558B917FE8D5B77F9C")

    private ChangeWatcher mWatcher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.639 -0400", hash_original_field = "5C7867EDEC78F5A3873DA83596FFE315", hash_generated_field = "D5F745DDCD7E7F8BB6FD2B9B3C8B76DB")

    private boolean mIncludePad;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.639 -0400", hash_original_field = "A6C851B8D237A237217AF4B1A1901277", hash_generated_field = "17C12DE3A8C50D21AE8FD7905F843126")

    private boolean mEllipsize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.639 -0400", hash_original_field = "5713AC9F49879DE1055FA780DFEFDF1C", hash_generated_field = "C354DF48C5764CCC7B8B820C49BF2BBD")

    private int mEllipsizedWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.639 -0400", hash_original_field = "23595B992DF8C4652BDAE896F06DBE1E", hash_generated_field = "669F1DFECFA42485F4E61492CB215143")

    private TextUtils.TruncateAt mEllipsizeAt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.639 -0400", hash_original_field = "268A075DF5CE7F2275707CC0D79AD1E3", hash_generated_field = "F71EEB15D0A10CA360B6D2DAC14050D2")

    private PackedIntVector mInts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.639 -0400", hash_original_field = "EBF544E4173D2D8B065068D8E591BD40", hash_generated_field = "98DE842C94CE85760CB5F06A2EB32DA3")

    private PackedObjectVector<Directions> mObjects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.640 -0400", hash_original_field = "A6796D45932911E4DA1D9D40D1BD23B8", hash_generated_field = "74C5EEEB9113B0F29D66E0A4983A6BC3")

    private int mTopPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.640 -0400", hash_original_field = "097A31AA17188409E251DABE4869FAFE", hash_generated_field = "8A7C981A0C6837E513C477AD1250B374")

    private int mBottomPadding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.640 -0400", hash_original_method = "DB07DE8DB9A02739307D238F9A46C5FB", hash_generated_method = "FA44B837B658169917187694D7917C1E")
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
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.641 -0400", hash_original_method = "BEECDC91516286CCE30494A55398B48A", hash_generated_method = "C80BB7234B4076E4BB34D9FF4B3AFC9B")
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
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.641 -0400", hash_original_method = "F5040E07E9B927EF44F79345AA20F61D", hash_generated_method = "D036986D8EC2A2562B5290B2FF8DEF8F")
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
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.642 -0400", hash_original_method = "E989442183EB5456191B90B4A9B0462E", hash_generated_method = "8374EAFD8EF080448DBCF08920EBF807")
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
        } 
        {
            mInts = new PackedIntVector(COLUMNS_NORMAL);
            mEllipsizedWidth = width;
            mEllipsizeAt = null;
        } 
        mObjects = new PackedObjectVector<Directions>(1);
        mIncludePad = includepad;
        {
            Ellipsizer e = (Ellipsizer) getText();
            e.mLayout = this;
            e.mWidth = ellipsizedWidth;
            e.mMethod = ellipsize;
            mEllipsize = true;
        } 
        int[] start;
        {
            start = new int[COLUMNS_ELLIPSIZE];
            start[ELLIPSIS_START] = ELLIPSIS_UNDEFINED;
        } 
        {
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
        reflow(base, 0, 0, base.length());
        {
            mWatcher = new ChangeWatcher(this);
            Spannable sp = (Spannable) base;
            ChangeWatcher[] spans = sp.getSpans(0, sp.length(), ChangeWatcher.class);
            {
                int i = 0;
                sp.removeSpan(spans[i]);
            } 
            sp.setSpan(mWatcher, 0, base.length(),
                       Spannable.SPAN_INCLUSIVE_INCLUSIVE |
                       (PRIORITY << Spannable.SPAN_PRIORITY_SHIFT));
        } 
        addTaint(paint.getTaint());
        addTaint(align.getTaint());
        addTaint(textDir.getTaint());
        addTaint(spacingmult);
        addTaint(spacingadd);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.644 -0400", hash_original_method = "680F026D747328AC88C64FC8C5845240", hash_generated_method = "C2BFA846C984DFF189210C38817066AF")
    private void reflow(CharSequence s, int where, int before, int after) {
        CharSequence text = mDisplay;
        int len = text.length();
        int find = TextUtils.lastIndexOf(text, '\n', where - 1);
        find = 0;
        find = find + 1;
        {
            int diff = where - find;
            before += diff;
            after += diff;
            where -= diff;
        } 
        int look = TextUtils.indexOf(text, '\n', where + after);
        look = len;
        int change = look - (where + after);
        before += change;
        after += change;
        {
            Spanned sp = (Spanned) text;
            boolean again;
            {
                again = false;
                Object[] force = sp.getSpans(where, where + after,
                                             WrapTogetherSpan.class);
                {
                    int i = 0;
                    {
                        int st = sp.getSpanStart(force[i]);
                        int en = sp.getSpanEnd(force[i]);
                        {
                            again = true;
                            int diff = where - st;
                            before += diff;
                            after += diff;
                            where -= diff;
                        } 
                        {
                            again = true;
                            int diff = en - (where + after);
                            before += diff;
                            after += diff;
                        } 
                    } 
                } 
            } 
        } 
        int startline = getLineForOffset(where);
        int startv = getLineTop(startline);
        int endline = getLineForOffset(where + before);
        endline = getLineCount();
        int endv = getLineTop(endline);
        boolean islast = (endline == getLineCount());
        StaticLayout reflowed;
        {
            reflowed = sStaticLayout;
            sStaticLayout = null;
        } 
        {
            reflowed = new StaticLayout(null);
        } 
        {
            reflowed.prepare();
        } 
        reflowed.generate(text, where, where + after,
                getPaint(), getWidth(), getTextDirectionHeuristic(), getSpacingMultiplier(),
                getSpacingAdd(), false,
                true, mEllipsizedWidth, mEllipsizeAt);
        int n = reflowed.getLineCount();
        {
            boolean varA8F26B230E6C690FEFF73B0BFCB1FB0E_1872541603 = (where + after != len &&
            reflowed.getLineStart(n - 1) == where + after);
        } 
        mInts.deleteAt(startline, endline - startline);
        mObjects.deleteAt(startline, endline - startline);
        int ht = reflowed.getLineTop(n);
        int toppad = 0;
        int botpad = 0;
        {
            toppad = reflowed.getTopPadding();
            mTopPadding = toppad;
            ht -= toppad;
        } 
        {
            botpad = reflowed.getBottomPadding();
            mBottomPadding = botpad;
            ht += botpad;
        } 
        mInts.adjustValuesBelow(startline, START, after - before);
        mInts.adjustValuesBelow(startline, TOP, startv - endv + ht);
        int[] ints;
        {
            ints = new int[COLUMNS_ELLIPSIZE];
            ints[ELLIPSIS_START] = ELLIPSIS_UNDEFINED;
        } 
        {
            ints = new int[COLUMNS_NORMAL];
        } 
        Directions[] objects = new Directions[1];
        {
            int i = 0;
            {
                ints[START] = reflowed.getLineStart(i) |
                          (reflowed.getParagraphDirection(i) << DIR_SHIFT) |
                          (reflowed.getLineContainsTab(i) ? TAB_MASK : 0);
                int top = reflowed.getLineTop(i) + startv;
                top -= toppad;
                ints[TOP] = top;
                int desc = reflowed.getLineDescent(i);
                desc += botpad;
                ints[DESCENT] = desc;
                objects[0] = reflowed.getLineDirections(i);
                {
                    ints[ELLIPSIS_START] = reflowed.getEllipsisStart(i);
                    ints[ELLIPSIS_COUNT] = reflowed.getEllipsisCount(i);
                } 
                mInts.insertAt(startline + i, ints);
                mObjects.insertAt(startline + i, objects);
            } 
        } 
        {
            sStaticLayout = reflowed;
            reflowed.finish();
        } 
        addTaint(s.getTaint());
        addTaint(where);
        addTaint(before);
        addTaint(after);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.645 -0400", hash_original_method = "152FA51B02D5FF2B246CE19D3B6F70D3", hash_generated_method = "E90113A28D82F71B93F8E67D57506EDB")
    @Override
    public int getLineCount() {
        int var5CACA94FC5780744C6E7317B6E5C4CD8_326853381 = (mInts.size() - 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972576910 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972576910;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.645 -0400", hash_original_method = "D6F378A47E9DC69D83D62FCE6E90C326", hash_generated_method = "511CE12C7F7BA2C9283E2D6E21858FDE")
    @Override
    public int getLineTop(int line) {
        int var93A1DB78A00AEEDC2C8FFA797CB1C236_1162431900 = (mInts.getValue(line, TOP));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424391964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424391964;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.645 -0400", hash_original_method = "730DAEEEE356A285055D20F0106F731A", hash_generated_method = "60FC48C1805C37EE1396875845CEE0ED")
    @Override
    public int getLineDescent(int line) {
        int var2F83A1C66F15F4DFFD63244CE36A39E3_1282575956 = (mInts.getValue(line, DESCENT));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675932674 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675932674;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.645 -0400", hash_original_method = "2D0F6CD810E708D2F846F779125A5CEA", hash_generated_method = "1663F040268A95B9EFD3BFE46E9DDDAB")
    @Override
    public int getLineStart(int line) {
        int var2E609AA1AE48CD56C499FC299D542025_1682999530 = (mInts.getValue(line, START) & START_MASK);
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_352425822 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_352425822;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.646 -0400", hash_original_method = "A0EC5BA65111126AB58C28059BDF3DD2", hash_generated_method = "D4DF6A6E359E5BCA391139398CFAC7CE")
    @Override
    public boolean getLineContainsTab(int line) {
        boolean var6812F2F3EF40E71A52EA6BFF67D6C857_1513952354 = ((mInts.getValue(line, TAB) & TAB_MASK) != 0);
        addTaint(line);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_883356861 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_883356861;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.646 -0400", hash_original_method = "54E53FDCC15DB3057A5F7E1DF0F2D93F", hash_generated_method = "41CA030D74BFB73373D7537C4FF48D28")
    @Override
    public int getParagraphDirection(int line) {
        int var70DA67A2D1659A19E3C11C8D9A8D14F9_597637041 = (mInts.getValue(line, DIR) >> DIR_SHIFT);
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199222692 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199222692;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.646 -0400", hash_original_method = "632C7F2120605B5CA7A1A3052A452575", hash_generated_method = "F38D053A727D7AD26A799920A3250665")
    @Override
    public final Directions getLineDirections(int line) {
        Directions varB4EAC82CA7396A68D541C85D26508E83_748509212 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_748509212 = mObjects.getValue(line, 0);
        addTaint(line);
        varB4EAC82CA7396A68D541C85D26508E83_748509212.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_748509212;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.647 -0400", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "AECCC6DBDFCDB72C05F45F2F710584FB")
    @Override
    public int getTopPadding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1069159684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1069159684;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.647 -0400", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "1D7283F22FA7995824E83CB78876AE1B")
    @Override
    public int getBottomPadding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701041634 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701041634;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.647 -0400", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "15C87F6399AE453F5381890EFA9955E2")
    @Override
    public int getEllipsizedWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_596839367 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_596839367;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.647 -0400", hash_original_method = "C2BA24D83CCF8B46DBDB9E42876D7FC0", hash_generated_method = "C08456AE1248183980BC737F79C750F0")
    @Override
    public int getEllipsisStart(int line) {
        int varD7B9ACF21B6113CC7B0610D40B77095D_977699149 = (mInts.getValue(line, ELLIPSIS_START));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31703402 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31703402;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.648 -0400", hash_original_method = "8861D8B0168294A81E05E00D1A35F6B4", hash_generated_method = "D70CCB97F47A2BC6D454CB22011C6A82")
    @Override
    public int getEllipsisCount(int line) {
        int var2F960C4354B27712541F6BCCD9E7C558_202339582 = (mInts.getValue(line, ELLIPSIS_COUNT));
        addTaint(line);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2055574349 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2055574349;
        
        
            
        
        
    }

    
    private static class ChangeWatcher implements TextWatcher, SpanWatcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.648 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "8D1810AB5CD5D0106C47C451BC1214A2")

        private WeakReference<DynamicLayout> mLayout;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.648 -0400", hash_original_method = "5B008785D1A2C7A00F27EBFB90B5E73C", hash_generated_method = "B82CCE3403554F8EA355C68CA40E1262")
        public  ChangeWatcher(DynamicLayout layout) {
            mLayout = new WeakReference<DynamicLayout>(layout);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.648 -0400", hash_original_method = "86BF27AD60282A12928BABF6F115B549", hash_generated_method = "115625DD97B21FA660A68BA34EA1A465")
        private void reflow(CharSequence s, int where, int before, int after) {
            DynamicLayout ml = mLayout.get();
            ml.reflow(s, where, before, after);
            ((Spannable) s).removeSpan(this);
            addTaint(s.getTaint());
            addTaint(where);
            addTaint(before);
            addTaint(after);
            
            
            
                
            
                
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.649 -0400", hash_original_method = "95E45B237E67DBC952009C430C254747", hash_generated_method = "4F775BE1160AA8E838671D141E4576EC")
        public void beforeTextChanged(CharSequence s, int where, int before, int after) {
            addTaint(s.getTaint());
            addTaint(where);
            addTaint(before);
            addTaint(after);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.649 -0400", hash_original_method = "64CFCAB8C5BCD960BA37993088223F2C", hash_generated_method = "F3D86709FA423F741928E6B3E79331A4")
        public void onTextChanged(CharSequence s, int where, int before, int after) {
            
            reflow(s, where, before, after);
            addTaint(s.getTaint());
            addTaint(where);
            addTaint(before);
            addTaint(after);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.649 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "B1E73F6E6A3A9E89AEF9681CB19F89E5")
        public void afterTextChanged(Editable s) {
            addTaint(s.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.649 -0400", hash_original_method = "37363E0323D4735EAF9288F365B55BBF", hash_generated_method = "4C017584AE0F4814C51C5CA62247C632")
        public void onSpanAdded(Spannable s, Object o, int start, int end) {
            
            reflow(s, start, end - start, end - start);
            addTaint(s.getTaint());
            addTaint(o.getTaint());
            addTaint(start);
            addTaint(end);
            
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_method = "A697CB019B21FC660F8DBD66680C7AE1", hash_generated_method = "23B0436D72C3392806FAE1B1375AD190")
        public void onSpanRemoved(Spannable s, Object o, int start, int end) {
            
            reflow(s, start, end - start, end - start);
            addTaint(s.getTaint());
            addTaint(o.getTaint());
            addTaint(start);
            addTaint(end);
            
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_method = "003DE2DC22FE06A8925B46C1AFC5A2FC", hash_generated_method = "6FD5A13FE0605F943B351C77C76985A5")
        public void onSpanChanged(Spannable s, Object o, int start, int end, int nstart, int nend) {
            
            {
                reflow(s, start, end - start, end - start);
                reflow(s, nstart, nend - nstart, nend - nstart);
            } 
            addTaint(s.getTaint());
            addTaint(o.getTaint());
            addTaint(start);
            addTaint(end);
            addTaint(nstart);
            addTaint(nend);
            
            
                
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "3EFDE694331F395874E68C1564D97D01", hash_generated_field = "4411169D7FD82CBF8AA4F3F3F57792B5")

    private static final int PRIORITY = 128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "3E985220B3B2B397EBA733973484F2C1", hash_generated_field = "8547CB2E7AAF865B43A1389F1EFA4F37")

    private static StaticLayout sStaticLayout = new StaticLayout(null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "FD588D0BA09E2DE573D6AB2267D28AEB", hash_generated_field = "6FA9B47DB08FC419C50F72FDCF40883C")

    private static final Object[] sLock = new Object[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "28651E175A74BF99AEB0613FFD9E4311", hash_generated_field = "D858CF53160507E553F41D31EE5B91B4")

    private static final int START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "96C94187E98129DC7ED52B022D56B56E", hash_generated_field = "00A39BB8E63058E1AB6D38D081403510")

    private static final int DIR = START;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "03E7882B92ED9688C792A4DF3CCA212F", hash_generated_field = "F85A3E18A8BF309A20F781E644D5A08F")

    private static final int TAB = START;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "571D16AE4FA766DA4380F84D324027BE", hash_generated_field = "1A855B733EBA6E8672640513C3B16A39")

    private static final int TOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "4DF1087155B53EE865ED8DEFEF0D2F7E", hash_generated_field = "A52FCC4891B5FC0ED83D62A588ACAE05")

    private static final int DESCENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "3AE51DFCA721DA74B9FE7AE826399C5B", hash_generated_field = "CD7507056B56DB550B1D813FB4B3D98B")

    private static final int COLUMNS_NORMAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "11658650D3EBC5004F1DE2593A19D91C", hash_generated_field = "E2BDE677DE1C429BF2BE569E18329E43")

    private static final int ELLIPSIS_START = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "9DEA8A3EF4097355E23BEB471268468C", hash_generated_field = "1B418124A7F291F864D2626D0BD306EC")

    private static final int ELLIPSIS_COUNT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "55DF56DF384DF5793030D40F84610E92", hash_generated_field = "67237E10844A87633E2718F5190772DB")

    private static final int COLUMNS_ELLIPSIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "479F76462347F1E81B6EC92F50573413", hash_generated_field = "E308275B4AE398B992072A6F7EA1A3C0")

    private static final int START_MASK = 0x1FFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "3CE9D0897644F1685651D602FF457A11", hash_generated_field = "B97E7A8E8F664E1C1793F75E8020C7A1")

    private static final int DIR_SHIFT = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "C52FA1DB43D0A9E4AB2D27DC3ED50BD6", hash_generated_field = "8DE592C2FC67BEDD6F7461E40AD4FEE6")

    private static final int TAB_MASK = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.650 -0400", hash_original_field = "89FC1B0F65C5879D4CBF1940D7C8EE5F", hash_generated_field = "5F25A8AF84EF55C73DA55AAF6E9BEDC2")

    private static final int ELLIPSIS_UNDEFINED = 0x80000000;
}

