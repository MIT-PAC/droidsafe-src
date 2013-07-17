package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Paint;
import android.text.style.UpdateLayout;
import android.text.style.WrapTogetherSpan;
import java.lang.ref.WeakReference;

public class DynamicLayout extends Layout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.528 -0400", hash_original_field = "70C30248F16505818D6F9EB3DE4F855F", hash_generated_field = "15367B8B2C746CFC484DB8A82189D9A1")

    private CharSequence mBase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.528 -0400", hash_original_field = "D29BCBAAD55DD1B1C5A0A9EB22E25252", hash_generated_field = "D786E4FA619E26D15C3AF77D65AC82C9")

    private CharSequence mDisplay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.528 -0400", hash_original_field = "47CD6CB6B9A4FA63425D0BEAFAF438EE", hash_generated_field = "AF0A8CD0AADCD6558B917FE8D5B77F9C")

    private ChangeWatcher mWatcher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.528 -0400", hash_original_field = "5C7867EDEC78F5A3873DA83596FFE315", hash_generated_field = "D5F745DDCD7E7F8BB6FD2B9B3C8B76DB")

    private boolean mIncludePad;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.529 -0400", hash_original_field = "A6C851B8D237A237217AF4B1A1901277", hash_generated_field = "17C12DE3A8C50D21AE8FD7905F843126")

    private boolean mEllipsize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.529 -0400", hash_original_field = "5713AC9F49879DE1055FA780DFEFDF1C", hash_generated_field = "C354DF48C5764CCC7B8B820C49BF2BBD")

    private int mEllipsizedWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.529 -0400", hash_original_field = "23595B992DF8C4652BDAE896F06DBE1E", hash_generated_field = "669F1DFECFA42485F4E61492CB215143")

    private TextUtils.TruncateAt mEllipsizeAt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.529 -0400", hash_original_field = "268A075DF5CE7F2275707CC0D79AD1E3", hash_generated_field = "F71EEB15D0A10CA360B6D2DAC14050D2")

    private PackedIntVector mInts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.529 -0400", hash_original_field = "EBF544E4173D2D8B065068D8E591BD40", hash_generated_field = "98DE842C94CE85760CB5F06A2EB32DA3")

    private PackedObjectVector<Directions> mObjects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.529 -0400", hash_original_field = "A6796D45932911E4DA1D9D40D1BD23B8", hash_generated_field = "74C5EEEB9113B0F29D66E0A4983A6BC3")

    private int mTopPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.529 -0400", hash_original_field = "097A31AA17188409E251DABE4869FAFE", hash_generated_field = "8A7C981A0C6837E513C477AD1250B374")

    private int mBottomPadding;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.529 -0400", hash_original_method = "DB07DE8DB9A02739307D238F9A46C5FB", hash_generated_method = "EEA2B5F84A7766858D699FBE69B1ED40")
    public  DynamicLayout(CharSequence base,
                         TextPaint paint,
                         int width, Alignment align,
                         float spacingmult, float spacingadd,
                         boolean includepad) {
        this(base, base, paint, width, align, spacingmult, spacingadd,
             includepad);
        addTaint(includepad);
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(align.getTaint());
        addTaint(width);
        addTaint(paint.getTaint());
        addTaint(base.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.530 -0400", hash_original_method = "BEECDC91516286CCE30494A55398B48A", hash_generated_method = "51699F20F89BE5E4989B54AB6C2169FF")
    public  DynamicLayout(CharSequence base, CharSequence display,
                         TextPaint paint,
                         int width, Alignment align,
                         float spacingmult, float spacingadd,
                         boolean includepad) {
        this(base, display, paint, width, align, spacingmult, spacingadd,
             includepad, null, 0);
        addTaint(includepad);
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(align.getTaint());
        addTaint(width);
        addTaint(paint.getTaint());
        addTaint(display.getTaint());
        addTaint(base.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.530 -0400", hash_original_method = "F5040E07E9B927EF44F79345AA20F61D", hash_generated_method = "218F21935476BD981B333FAA63B2980D")
    public  DynamicLayout(CharSequence base, CharSequence display,
                         TextPaint paint,
                         int width, Alignment align,
                         float spacingmult, float spacingadd,
                         boolean includepad,
                         TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        this(base, display, paint, width, align, TextDirectionHeuristics.FIRSTSTRONG_LTR,
                spacingmult, spacingadd, includepad, ellipsize, ellipsizedWidth);
        addTaint(ellipsizedWidth);
        addTaint(ellipsize.getTaint());
        addTaint(includepad);
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(align.getTaint());
        addTaint(width);
        addTaint(paint.getTaint());
        addTaint(display.getTaint());
        addTaint(base.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.534 -0400", hash_original_method = "E989442183EB5456191B90B4A9B0462E", hash_generated_method = "9207675087389DD33A1BFBC9D2AD4778")
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
        addTaint(spacingadd);
        addTaint(spacingmult);
        addTaint(textDir.getTaint());
        addTaint(align.getTaint());
        addTaint(paint.getTaint());
        mBase = base;
        mDisplay = display;
        if(ellipsize != null)        
        {
            mInts = new PackedIntVector(COLUMNS_ELLIPSIZE);
            mEllipsizedWidth = ellipsizedWidth;
            mEllipsizeAt = ellipsize;
        } //End block
        else
        {
            mInts = new PackedIntVector(COLUMNS_NORMAL);
            mEllipsizedWidth = width;
            mEllipsizeAt = null;
        } //End block
        mObjects = new PackedObjectVector<Directions>(1);
        mIncludePad = includepad;
        if(ellipsize != null)        
        {
            Ellipsizer e = (Ellipsizer) getText();
            e.mLayout = this;
            e.mWidth = ellipsizedWidth;
            e.mMethod = ellipsize;
            mEllipsize = true;
        } //End block
        int[] start;
        if(ellipsize != null)        
        {
            start = new int[COLUMNS_ELLIPSIZE];
            start[ELLIPSIS_START] = ELLIPSIS_UNDEFINED;
        } //End block
        else
        {
            start = new int[COLUMNS_NORMAL];
        } //End block
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
        if(base instanceof Spannable)        
        {
            if(mWatcher == null)            
            mWatcher = new ChangeWatcher(this);
            Spannable sp = (Spannable) base;
            ChangeWatcher[] spans = sp.getSpans(0, sp.length(), ChangeWatcher.class);
for(int i = 0;i < spans.length;i++)
            sp.removeSpan(spans[i]);
            sp.setSpan(mWatcher, 0, base.length(),
                       Spannable.SPAN_INCLUSIVE_INCLUSIVE |
                       (PRIORITY << Spannable.SPAN_PRIORITY_SHIFT));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.537 -0400", hash_original_method = "680F026D747328AC88C64FC8C5845240", hash_generated_method = "939D984A7088BFC70E0A97943BE89E32")
    private void reflow(CharSequence s, int where, int before, int after) {
        addTaint(after);
        addTaint(before);
        addTaint(where);
        addTaint(s.getTaint());
        if(s != mBase)        
        return;
        CharSequence text = mDisplay;
        int len = text.length();
        int find = TextUtils.lastIndexOf(text, '\n', where - 1);
        if(find < 0)        
        find = 0;
        else
        find = find + 1;
        {
            int diff = where - find;
            before += diff;
            after += diff;
            where -= diff;
        } //End block
        int look = TextUtils.indexOf(text, '\n', where + after);
        if(look < 0)        
        look = len;
        else
        look++;
        int change = look - (where + after);
        before += change;
        after += change;
        if(text instanceof Spanned)        
        {
            Spanned sp = (Spanned) text;
            boolean again;
            do {
                {
                    again = false;
                    Object[] force = sp.getSpans(where, where + after,
                                             WrapTogetherSpan.class);
for(int i = 0;i < force.length;i++)
                    {
                        int st = sp.getSpanStart(force[i]);
                        int en = sp.getSpanEnd(force[i]);
                        if(st < where)                        
                        {
                            again = true;
                            int diff = where - st;
                            before += diff;
                            after += diff;
                            where -= diff;
                        } //End block
                        if(en > where + after)                        
                        {
                            again = true;
                            int diff = en - (where + after);
                            before += diff;
                            after += diff;
                        } //End block
                    } //End block
                } //End block
} while (again);
        } //End block
        int startline = getLineForOffset(where);
        int startv = getLineTop(startline);
        int endline = getLineForOffset(where + before);
        if(where + after == len)        
        endline = getLineCount();
        int endv = getLineTop(endline);
        boolean islast = (endline == getLineCount());
        StaticLayout reflowed;
        synchronized
(sLock)        {
            reflowed = sStaticLayout;
            sStaticLayout = null;
        } //End block
        if(reflowed == null)        
        {
            reflowed = new StaticLayout(null);
        } //End block
        else
        {
            reflowed.prepare();
        } //End block
        reflowed.generate(text, where, where + after,
                getPaint(), getWidth(), getTextDirectionHeuristic(), getSpacingMultiplier(),
                getSpacingAdd(), false,
                true, mEllipsizedWidth, mEllipsizeAt);
        int n = reflowed.getLineCount();
        if(where + after != len &&
            reflowed.getLineStart(n - 1) == where + after)        
        n--;
        mInts.deleteAt(startline, endline - startline);
        mObjects.deleteAt(startline, endline - startline);
        int ht = reflowed.getLineTop(n);
        int toppad = 0;
        int botpad = 0;
        if(mIncludePad && startline == 0)        
        {
            toppad = reflowed.getTopPadding();
            mTopPadding = toppad;
            ht -= toppad;
        } //End block
        if(mIncludePad && islast)        
        {
            botpad = reflowed.getBottomPadding();
            mBottomPadding = botpad;
            ht += botpad;
        } //End block
        mInts.adjustValuesBelow(startline, START, after - before);
        mInts.adjustValuesBelow(startline, TOP, startv - endv + ht);
        int[] ints;
        if(mEllipsize)        
        {
            ints = new int[COLUMNS_ELLIPSIZE];
            ints[ELLIPSIS_START] = ELLIPSIS_UNDEFINED;
        } //End block
        else
        {
            ints = new int[COLUMNS_NORMAL];
        } //End block
        Directions[] objects = new Directions[1];
for(int i = 0;i < n;i++)
        {
            ints[START] = reflowed.getLineStart(i) |
                          (reflowed.getParagraphDirection(i) << DIR_SHIFT) |
                          (reflowed.getLineContainsTab(i) ? TAB_MASK : 0);
            int top = reflowed.getLineTop(i) + startv;
            if(i > 0)            
            top -= toppad;
            ints[TOP] = top;
            int desc = reflowed.getLineDescent(i);
            if(i == n - 1)            
            desc += botpad;
            ints[DESCENT] = desc;
            objects[0] = reflowed.getLineDirections(i);
            if(mEllipsize)            
            {
                ints[ELLIPSIS_START] = reflowed.getEllipsisStart(i);
                ints[ELLIPSIS_COUNT] = reflowed.getEllipsisCount(i);
            } //End block
            mInts.insertAt(startline + i, ints);
            mObjects.insertAt(startline + i, objects);
        } //End block
        synchronized
(sLock)        {
            sStaticLayout = reflowed;
            reflowed.finish();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.537 -0400", hash_original_method = "152FA51B02D5FF2B246CE19D3B6F70D3", hash_generated_method = "996817456AE5B30AF8D18A3FA094F90F")
    @Override
    public int getLineCount() {
        int varCE45565D018F36F279F54F131C322DBA_1436393233 = (mInts.size() - 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342588845 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342588845;
        // ---------- Original Method ----------
        //return mInts.size() - 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.537 -0400", hash_original_method = "D6F378A47E9DC69D83D62FCE6E90C326", hash_generated_method = "C3958C7D58ACE8560F12F8B045F541F5")
    @Override
    public int getLineTop(int line) {
        addTaint(line);
        int varAFB242805DFABCBCDCB80602B6C2A06D_655253856 = (mInts.getValue(line, TOP));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1753494750 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1753494750;
        // ---------- Original Method ----------
        //return mInts.getValue(line, TOP);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.537 -0400", hash_original_method = "730DAEEEE356A285055D20F0106F731A", hash_generated_method = "5C3ED6E328E921A69DA7DBA69E077D97")
    @Override
    public int getLineDescent(int line) {
        addTaint(line);
        int var66258E04929504AE8E1F9AF3B7B95EC9_830987047 = (mInts.getValue(line, DESCENT));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_905836255 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_905836255;
        // ---------- Original Method ----------
        //return mInts.getValue(line, DESCENT);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.537 -0400", hash_original_method = "2D0F6CD810E708D2F846F779125A5CEA", hash_generated_method = "3F8449E29F8A140817A5CF6CE3BB2F04")
    @Override
    public int getLineStart(int line) {
        addTaint(line);
        int var8EA63EDF2F54D9571DE7B17B4FA130E0_1014827692 = (mInts.getValue(line, START) & START_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540966339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540966339;
        // ---------- Original Method ----------
        //return mInts.getValue(line, START) & START_MASK;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.538 -0400", hash_original_method = "A0EC5BA65111126AB58C28059BDF3DD2", hash_generated_method = "424C57061763CB0601DEB3C8458047DE")
    @Override
    public boolean getLineContainsTab(int line) {
        addTaint(line);
        boolean varAF1BFF3D7E7FD88925DF0D60C035FD5A_1309027900 = ((mInts.getValue(line, TAB) & TAB_MASK) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_758411074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_758411074;
        // ---------- Original Method ----------
        //return (mInts.getValue(line, TAB) & TAB_MASK) != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.538 -0400", hash_original_method = "54E53FDCC15DB3057A5F7E1DF0F2D93F", hash_generated_method = "59A78CD8B88D5CD238AD42EA7DB0EC05")
    @Override
    public int getParagraphDirection(int line) {
        addTaint(line);
        int varFA8739DB99951E9069289D9282627184_2083765035 = (mInts.getValue(line, DIR) >> DIR_SHIFT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_275030408 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_275030408;
        // ---------- Original Method ----------
        //return mInts.getValue(line, DIR) >> DIR_SHIFT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.538 -0400", hash_original_method = "632C7F2120605B5CA7A1A3052A452575", hash_generated_method = "9C3D85BC31E00CCE593C5EB9C48B5366")
    @Override
    public final Directions getLineDirections(int line) {
        addTaint(line);
Directions var6768B65A7C0556A0B36601923B74AF73_1975399395 =         mObjects.getValue(line, 0);
        var6768B65A7C0556A0B36601923B74AF73_1975399395.addTaint(taint);
        return var6768B65A7C0556A0B36601923B74AF73_1975399395;
        // ---------- Original Method ----------
        //return mObjects.getValue(line, 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.538 -0400", hash_original_method = "0410F05B3F48387C42DB277B8067D4A9", hash_generated_method = "838766EFABECAF4273E8135329EB7D00")
    @Override
    public int getTopPadding() {
        int varA6796D45932911E4DA1D9D40D1BD23B8_554972039 = (mTopPadding);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_441662196 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_441662196;
        // ---------- Original Method ----------
        //return mTopPadding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.538 -0400", hash_original_method = "A7597317BC8A3102F80AD4E9AD038652", hash_generated_method = "C7FD86F1B0671115D3D0DA4030EE0CD5")
    @Override
    public int getBottomPadding() {
        int var097A31AA17188409E251DABE4869FAFE_768408029 = (mBottomPadding);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1875680337 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1875680337;
        // ---------- Original Method ----------
        //return mBottomPadding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.538 -0400", hash_original_method = "5CA9F8625BABB74DD57E485BAAAC3103", hash_generated_method = "56D843C2F435EAB323BF66C83FBBE654")
    @Override
    public int getEllipsizedWidth() {
        int var5713AC9F49879DE1055FA780DFEFDF1C_477621981 = (mEllipsizedWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694599515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694599515;
        // ---------- Original Method ----------
        //return mEllipsizedWidth;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.538 -0400", hash_original_method = "C2BA24D83CCF8B46DBDB9E42876D7FC0", hash_generated_method = "F2AC78EB5C4CC85FBEA922E91C180825")
    @Override
    public int getEllipsisStart(int line) {
        addTaint(line);
        if(mEllipsizeAt == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1426325946 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233274513 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233274513;
        } //End block
        int varD2B5E08C0722D9A3A880FB28E66B3011_1256865990 = (mInts.getValue(line, ELLIPSIS_START));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2059120718 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2059120718;
        // ---------- Original Method ----------
        //if (mEllipsizeAt == null) {
            //return 0;
        //}
        //return mInts.getValue(line, ELLIPSIS_START);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.538 -0400", hash_original_method = "8861D8B0168294A81E05E00D1A35F6B4", hash_generated_method = "8D90D281FEE3A2D6FAA4A969A1D83517")
    @Override
    public int getEllipsisCount(int line) {
        addTaint(line);
        if(mEllipsizeAt == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_719557988 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707339564 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707339564;
        } //End block
        int var26AD22BC1A06C45841DEE37C8A8A8845_2029061935 = (mInts.getValue(line, ELLIPSIS_COUNT));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249422012 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249422012;
        // ---------- Original Method ----------
        //if (mEllipsizeAt == null) {
            //return 0;
        //}
        //return mInts.getValue(line, ELLIPSIS_COUNT);
    }

    
    private static class ChangeWatcher implements TextWatcher, SpanWatcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.539 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "8D1810AB5CD5D0106C47C451BC1214A2")

        private WeakReference<DynamicLayout> mLayout;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.539 -0400", hash_original_method = "5B008785D1A2C7A00F27EBFB90B5E73C", hash_generated_method = "B82CCE3403554F8EA355C68CA40E1262")
        public  ChangeWatcher(DynamicLayout layout) {
            mLayout = new WeakReference<DynamicLayout>(layout);
            // ---------- Original Method ----------
            //mLayout = new WeakReference<DynamicLayout>(layout);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.539 -0400", hash_original_method = "86BF27AD60282A12928BABF6F115B549", hash_generated_method = "36F92D39253E7DA824E28AC9FE3A6464")
        private void reflow(CharSequence s, int where, int before, int after) {
            addTaint(after);
            addTaint(before);
            addTaint(where);
            addTaint(s.getTaint());
            DynamicLayout ml = mLayout.get();
            if(ml != null)            
            ml.reflow(s, where, before, after);
            else
            if(s instanceof Spannable)            
            ((Spannable) s).removeSpan(this);
            // ---------- Original Method ----------
            //DynamicLayout ml = mLayout.get();
            //if (ml != null)
                //ml.reflow(s, where, before, after);
            //else if (s instanceof Spannable)
                //((Spannable) s).removeSpan(this);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.539 -0400", hash_original_method = "95E45B237E67DBC952009C430C254747", hash_generated_method = "12846E2D58F047016FD5A94EDD3F1FEF")
        public void beforeTextChanged(CharSequence s, int where, int before, int after) {
            addTaint(after);
            addTaint(before);
            addTaint(where);
            addTaint(s.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.539 -0400", hash_original_method = "64CFCAB8C5BCD960BA37993088223F2C", hash_generated_method = "A8739152EF2C15946763111B38CA8B59")
        public void onTextChanged(CharSequence s, int where, int before, int after) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(after);
            addTaint(before);
            addTaint(where);
            addTaint(s.getTaint());
            reflow(s, where, before, after);
            // ---------- Original Method ----------
            //reflow(s, where, before, after);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.539 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "B1E73F6E6A3A9E89AEF9681CB19F89E5")
        public void afterTextChanged(Editable s) {
            addTaint(s.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.539 -0400", hash_original_method = "37363E0323D4735EAF9288F365B55BBF", hash_generated_method = "E291F5C71871E8099BDB9AD8176A6AF0")
        public void onSpanAdded(Spannable s, Object o, int start, int end) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(end);
            addTaint(start);
            addTaint(o.getTaint());
            addTaint(s.getTaint());
            if(o instanceof UpdateLayout)            
            reflow(s, start, end - start, end - start);
            // ---------- Original Method ----------
            //if (o instanceof UpdateLayout)
                //reflow(s, start, end - start, end - start);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_method = "A697CB019B21FC660F8DBD66680C7AE1", hash_generated_method = "6DEA0B8A2E4DAE68C14C9D428655CE32")
        public void onSpanRemoved(Spannable s, Object o, int start, int end) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(end);
            addTaint(start);
            addTaint(o.getTaint());
            addTaint(s.getTaint());
            if(o instanceof UpdateLayout)            
            reflow(s, start, end - start, end - start);
            // ---------- Original Method ----------
            //if (o instanceof UpdateLayout)
                //reflow(s, start, end - start, end - start);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_method = "003DE2DC22FE06A8925B46C1AFC5A2FC", hash_generated_method = "5B30F8789C863E965657E3935EDC2B0F")
        public void onSpanChanged(Spannable s, Object o, int start, int end, int nstart, int nend) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(nend);
            addTaint(nstart);
            addTaint(end);
            addTaint(start);
            addTaint(o.getTaint());
            addTaint(s.getTaint());
            if(o instanceof UpdateLayout)            
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "3EFDE694331F395874E68C1564D97D01", hash_generated_field = "4411169D7FD82CBF8AA4F3F3F57792B5")

    private static final int PRIORITY = 128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "3E985220B3B2B397EBA733973484F2C1", hash_generated_field = "8547CB2E7AAF865B43A1389F1EFA4F37")

    private static StaticLayout sStaticLayout = new StaticLayout(null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "FD588D0BA09E2DE573D6AB2267D28AEB", hash_generated_field = "6FA9B47DB08FC419C50F72FDCF40883C")

    private static final Object[] sLock = new Object[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "28651E175A74BF99AEB0613FFD9E4311", hash_generated_field = "D858CF53160507E553F41D31EE5B91B4")

    private static final int START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "96C94187E98129DC7ED52B022D56B56E", hash_generated_field = "00A39BB8E63058E1AB6D38D081403510")

    private static final int DIR = START;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "03E7882B92ED9688C792A4DF3CCA212F", hash_generated_field = "F85A3E18A8BF309A20F781E644D5A08F")

    private static final int TAB = START;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "571D16AE4FA766DA4380F84D324027BE", hash_generated_field = "1A855B733EBA6E8672640513C3B16A39")

    private static final int TOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "4DF1087155B53EE865ED8DEFEF0D2F7E", hash_generated_field = "A52FCC4891B5FC0ED83D62A588ACAE05")

    private static final int DESCENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "3AE51DFCA721DA74B9FE7AE826399C5B", hash_generated_field = "CD7507056B56DB550B1D813FB4B3D98B")

    private static final int COLUMNS_NORMAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "11658650D3EBC5004F1DE2593A19D91C", hash_generated_field = "E2BDE677DE1C429BF2BE569E18329E43")

    private static final int ELLIPSIS_START = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "9DEA8A3EF4097355E23BEB471268468C", hash_generated_field = "1B418124A7F291F864D2626D0BD306EC")

    private static final int ELLIPSIS_COUNT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "55DF56DF384DF5793030D40F84610E92", hash_generated_field = "67237E10844A87633E2718F5190772DB")

    private static final int COLUMNS_ELLIPSIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "479F76462347F1E81B6EC92F50573413", hash_generated_field = "E308275B4AE398B992072A6F7EA1A3C0")

    private static final int START_MASK = 0x1FFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "3CE9D0897644F1685651D602FF457A11", hash_generated_field = "B97E7A8E8F664E1C1793F75E8020C7A1")

    private static final int DIR_SHIFT = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "C52FA1DB43D0A9E4AB2D27DC3ED50BD6", hash_generated_field = "8DE592C2FC67BEDD6F7461E40AD4FEE6")

    private static final int TAB_MASK = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.540 -0400", hash_original_field = "89FC1B0F65C5879D4CBF1940D7C8EE5F", hash_generated_field = "5F25A8AF84EF55C73DA55AAF6E9BEDC2")

    private static final int ELLIPSIS_UNDEFINED = 0x80000000;
}

