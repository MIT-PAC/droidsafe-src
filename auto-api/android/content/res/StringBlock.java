package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.*;
import android.text.style.*;
import android.util.Log;
import android.util.SparseArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import com.android.internal.util.XmlUtils;

final class StringBlock {
    private int mNative;
    private boolean mUseSparse;
    private boolean mOwnsNative;
    private CharSequence[] mStrings;
    private SparseArray<CharSequence> mSparseStrings;
    StyleIDs mStyleIDs = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.585 -0400", hash_original_method = "C056884F6217F27ACF2C69899BB237D2", hash_generated_method = "8793F0217122BE0D59B1641B0C9C798D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBlock(byte[] data, boolean useSparse) {
        dsTaint.addTaint(useSparse);
        dsTaint.addTaint(data[0]);
        mNative = nativeCreate(data, 0, data.length);
        mOwnsNative = true;
        // ---------- Original Method ----------
        //mNative = nativeCreate(data, 0, data.length);
        //mUseSparse = useSparse;
        //mOwnsNative = true;
        //if (localLOGV) Log.v(TAG, "Created string block " + this
                //+ ": " + nativeGetSize(mNative));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.585 -0400", hash_original_method = "325B6049E710893083487955374CD75A", hash_generated_method = "D8928D0912BF47F7127587E5BAA2F0BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBlock(byte[] data, int offset, int size, boolean useSparse) {
        dsTaint.addTaint(useSparse);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(size);
        mNative = nativeCreate(data, offset, size);
        mOwnsNative = true;
        // ---------- Original Method ----------
        //mNative = nativeCreate(data, offset, size);
        //mUseSparse = useSparse;
        //mOwnsNative = true;
        //if (localLOGV) Log.v(TAG, "Created string block " + this
                //+ ": " + nativeGetSize(mNative));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.585 -0400", hash_original_method = "451F884D80CF979FA811D85381B93BA8", hash_generated_method = "0A6FFCD311582A121A25FB76FA1550D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     StringBlock(int obj, boolean useSparse) {
        dsTaint.addTaint(useSparse);
        dsTaint.addTaint(obj);
        mOwnsNative = false;
        // ---------- Original Method ----------
        //mNative = obj;
        //mUseSparse = useSparse;
        //mOwnsNative = false;
        //if (localLOGV) Log.v(TAG, "Created string block " + this
                //+ ": " + nativeGetSize(mNative));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.587 -0400", hash_original_method = "CA0D40E41A55E0E3360E62E713B76B88", hash_generated_method = "3044C80BC90EA74E9F9D8A9D207E8291")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence get(int idx) {
        dsTaint.addTaint(idx);
        {
            {
                CharSequence res;
                res = mStrings[idx];
            } //End block
            {
                CharSequence res;
                res = mSparseStrings.get(idx);
            } //End block
            {
                int num;
                num = nativeGetSize(mNative);
                {
                    mSparseStrings = new SparseArray<CharSequence>();
                } //End block
                {
                    mStrings = new CharSequence[num];
                } //End block
            } //End block
            String str;
            str = nativeGetString(mNative, idx);
            CharSequence res;
            res = str;
            int[] style;
            style = nativeGetStyle(mNative, idx);
            {
                {
                    mStyleIDs = new StyleIDs();
                } //End block
                {
                    int styleIndex;
                    styleIndex = 0;
                    styleIndex += 3;
                    {
                        int styleId;
                        styleId = style[styleIndex];
                        String styleTag;
                        styleTag = nativeGetString(mNative, styleId);
                        {
                            boolean varC887F6D4B30EC541E65DBFBDBCDD62AA_177881142 = (styleTag.equals("b"));
                            {
                                mStyleIDs.boldId = styleId;
                            } //End block
                            {
                                boolean varAAA8D27A262C4AA33AA77708C8723E3C_226241316 = (styleTag.equals("i"));
                                {
                                    mStyleIDs.italicId = styleId;
                                } //End block
                                {
                                    boolean var0F276DEC02D5224F8D1A94CEA8B56222_1956170510 = (styleTag.equals("u"));
                                    {
                                        mStyleIDs.underlineId = styleId;
                                    } //End block
                                    {
                                        boolean var65A7CE7F99CEFD7C5E702A02D7375627_1891421926 = (styleTag.equals("tt"));
                                        {
                                            mStyleIDs.ttId = styleId;
                                        } //End block
                                        {
                                            boolean var8E9D24A56B951FD8B4556AC9687B862D_37902607 = (styleTag.equals("big"));
                                            {
                                                mStyleIDs.bigId = styleId;
                                            } //End block
                                            {
                                                boolean var50968B7296438CFFE7941F4277358F12_725684446 = (styleTag.equals("small"));
                                                {
                                                    mStyleIDs.smallId = styleId;
                                                } //End block
                                                {
                                                    boolean var12A2A849B5F8D70ACBACAC923F8AFE6E_223744112 = (styleTag.equals("sup"));
                                                    {
                                                        mStyleIDs.supId = styleId;
                                                    } //End block
                                                    {
                                                        boolean var3F8A168B86441E49333296C71DC57C4E_2129497676 = (styleTag.equals("sub"));
                                                        {
                                                            mStyleIDs.subId = styleId;
                                                        } //End block
                                                        {
                                                            boolean var18AE5CBDC95E4D4C7134523455ADC26F_1033909775 = (styleTag.equals("strike"));
                                                            {
                                                                mStyleIDs.strikeId = styleId;
                                                            } //End block
                                                            {
                                                                boolean var7EBEE9E50CFF4D1C5480F34A4BF58B42_940386444 = (styleTag.equals("li"));
                                                                {
                                                                    mStyleIDs.listItemId = styleId;
                                                                } //End block
                                                                {
                                                                    boolean var46A9EEE2572CA803DC0C183361FDF85A_1689900652 = (styleTag.equals("marquee"));
                                                                    {
                                                                        mStyleIDs.marqueeId = styleId;
                                                                    } //End block
                                                                } //End collapsed parenthetic
                                                            } //End collapsed parenthetic
                                                        } //End collapsed parenthetic
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                res = applyStyles(str, style, mStyleIDs);
            } //End block
            mStrings[idx] = res;
            mSparseStrings.put(idx, res);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.587 -0400", hash_original_method = "0AE42B829C6407A7351435B91C0A8F63", hash_generated_method = "065278051329C532BB29C2C6B986F5B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() throws Throwable {
        {
            nativeDestroy(mNative);
        } //End block
        // ---------- Original Method ----------
        //if (mOwnsNative) {
            //nativeDestroy(mNative);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.590 -0400", hash_original_method = "7157B2241FD2EE4083D0D740C065977B", hash_generated_method = "3009AF27673170D89D4341462CFCDF98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence applyStyles(String str, int[] style, StyleIDs ids) {
        dsTaint.addTaint(style[0]);
        dsTaint.addTaint(str);
        dsTaint.addTaint(ids.dsTaint);
        SpannableString buffer;
        buffer = new SpannableString(str);
        int i;
        i = 0;
        {
            int type;
            type = style[i];
            {
                buffer.setSpan(new StyleSpan(Typeface.BOLD),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            {
                buffer.setSpan(new StyleSpan(Typeface.ITALIC),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            {
                buffer.setSpan(new UnderlineSpan(),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            {
                buffer.setSpan(new TypefaceSpan("monospace"),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            {
                buffer.setSpan(new RelativeSizeSpan(1.25f),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            {
                buffer.setSpan(new RelativeSizeSpan(0.8f),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            {
                buffer.setSpan(new SubscriptSpan(),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            {
                buffer.setSpan(new SuperscriptSpan(),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            {
                buffer.setSpan(new StrikethroughSpan(),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            {
                addParagraphSpan(buffer, new BulletSpan(10),
                                style[i+1], style[i+2]+1);
            } //End block
            {
                buffer.setSpan(TextUtils.TruncateAt.MARQUEE,
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            } //End block
            {
                String tag;
                tag = nativeGetString(mNative, type);
                {
                    boolean var23E0416BE433D3D26629FB0DCAA41E29_951017485 = (tag.startsWith("font;"));
                    {
                        String sub;
                        sub = subtag(tag, ";height=");
                        {
                            int size;
                            size = Integer.parseInt(sub);
                            addParagraphSpan(buffer, new Height(size),
                                       style[i+1], style[i+2]+1);
                        } //End block
                        sub = subtag(tag, ";size=");
                        {
                            int size;
                            size = Integer.parseInt(sub);
                            buffer.setSpan(new AbsoluteSizeSpan(size, true),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        } //End block
                        sub = subtag(tag, ";fgcolor=");
                        {
                            int color;
                            color = XmlUtils.convertValueToUnsignedInt(sub, -1);
                            buffer.setSpan(new ForegroundColorSpan(color),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        } //End block
                        sub = subtag(tag, ";bgcolor=");
                        {
                            int color;
                            color = XmlUtils.convertValueToUnsignedInt(sub, -1);
                            buffer.setSpan(new BackgroundColorSpan(color),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        } //End block
                    } //End block
                    {
                        boolean var72BAF1DD6E2FA7F7405258DE30A10892_1080654802 = (tag.startsWith("a;"));
                        {
                            String sub;
                            sub = subtag(tag, ";href=");
                            {
                                buffer.setSpan(new URLSpan(sub),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            } //End block
                        } //End block
                        {
                            boolean var0CBB4E0FE848A98207331F42BFE74A96_1178261892 = (tag.startsWith("annotation;"));
                            {
                                int len;
                                len = tag.length();
                                int next;
                                {
                                    int t;
                                    t = tag.indexOf(';');
                                    t = next;
                                    {
                                        int eq;
                                        eq = tag.indexOf('=', t);
                                        next = tag.indexOf(';', eq);
                                        {
                                            next = len;
                                        } //End block
                                        String key;
                                        key = tag.substring(t + 1, eq);
                                        String value;
                                        value = tag.substring(eq + 1, next);
                                        buffer.setSpan(new Annotation(key, value),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            i += 3;
        } //End block
        CharSequence varB34AFF2BA4EE65A7D7122A394DAAA0A0_1476211644 = (new SpannedString(buffer));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void addParagraphSpan(Spannable buffer, Object what,
                                         int start, int end) {
        int len = buffer.length();
        if (start != 0 && start != len && buffer.charAt(start - 1) != '\n') {
            for (start--; start > 0; start--) {
                if (buffer.charAt(start - 1) == '\n') {
                    break;
                }
            }
        }
        if (end != 0 && end != len && buffer.charAt(end - 1) != '\n') {
            for (end++; end < len; end++) {
                if (buffer.charAt(end - 1) == '\n') {
                    break;
                }
            }
        }
        buffer.setSpan(what, start, end, Spannable.SPAN_PARAGRAPH);
    }

    
        private static String subtag(String full, String attribute) {
        int start = full.indexOf(attribute);
        if (start < 0) {
            return null;
        }
        start += attribute.length();
        int end = full.indexOf(';', start);
        if (end < 0) {
            return full.substring(start);
        } else {
            return full.substring(start, end);
        }
    }

    
        private static final int nativeCreate(byte[] data,
                                                 int offset,
                                                 int size) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final int nativeGetSize(int obj) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static final String nativeGetString(int obj, int idx) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        private static final int[] nativeGetStyle(int obj, int idx) {
        int[] retVal = {DSUtils.UNKNOWN_INT};
        return retVal;
    }

    
        private static final void nativeDestroy(int obj) {
    }

    
    static final class StyleIDs {
        private int boldId = -1;
        private int italicId = -1;
        private int underlineId = -1;
        private int ttId = -1;
        private int bigId = -1;
        private int smallId = -1;
        private int subId = -1;
        private int supId = -1;
        private int strikeId = -1;
        private int listItemId = -1;
        private int marqueeId = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.592 -0400", hash_original_method = "21309167F8DF68025F347F16725EAEB0", hash_generated_method = "21309167F8DF68025F347F16725EAEB0")
                public StyleIDs ()
        {
        }


    }


    
    private static class Height implements LineHeightSpan.WithDensity {
        private int mSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.592 -0400", hash_original_method = "822F731BB1BA127213FF49F8E178606F", hash_generated_method = "563B277775E2D4342493D8C0E05ADF68")
        @DSModeled(DSC.SAFE)
        public Height(int size) {
            dsTaint.addTaint(size);
            // ---------- Original Method ----------
            //mSize = size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.592 -0400", hash_original_method = "26F622CE8D56F6DE86DA56D7C47E1EF9", hash_generated_method = "47DF16BC8267FE77E344863352FFE7A9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void chooseHeight(CharSequence text, int start, int end,
                                 int spanstartv, int v,
                                 Paint.FontMetricsInt fm) {
            dsTaint.addTaint(v);
            dsTaint.addTaint(fm.dsTaint);
            dsTaint.addTaint(text);
            dsTaint.addTaint(start);
            dsTaint.addTaint(spanstartv);
            dsTaint.addTaint(end);
            chooseHeight(text, start, end, spanstartv, v, fm, null);
            // ---------- Original Method ----------
            //chooseHeight(text, start, end, spanstartv, v, fm, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.593 -0400", hash_original_method = "8C5957365F8EC7EB873EDA19F7109033", hash_generated_method = "9D4BAF7531DA7073D8B315B49C277431")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void chooseHeight(CharSequence text, int start, int end,
                                 int spanstartv, int v,
                                 Paint.FontMetricsInt fm, TextPaint paint) {
            dsTaint.addTaint(v);
            dsTaint.addTaint(fm.dsTaint);
            dsTaint.addTaint(text);
            dsTaint.addTaint(start);
            dsTaint.addTaint(paint.dsTaint);
            dsTaint.addTaint(spanstartv);
            dsTaint.addTaint(end);
            int size;
            size = mSize;
            {
                size *= paint.density;
            } //End block
            {
                fm.top = fm.bottom - size;
                fm.ascent = fm.ascent - size;
            } //End block
            {
                {
                    Paint p;
                    p = new Paint();
                    p.setTextSize(100);
                    Rect r;
                    r = new Rect();
                    p.getTextBounds("ABCDEFG", 0, 7, r);
                    sProportion = (r.top) / p.ascent();
                } //End block
                int need;
                need = (int) Math.ceil(-fm.top * sProportion);
                {
                    fm.top = fm.bottom - size;
                    fm.ascent = fm.descent - size;
                } //End block
                {
                    fm.top = fm.ascent = -need;
                    fm.bottom = fm.descent = fm.top + size;
                } //End block
                {
                    fm.top = fm.ascent = -size;
                    fm.bottom = fm.descent = 0;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static float sProportion = 0;
    }


    
    private static final String TAG = "AssetManager";
    private static final boolean localLOGV = false || false;
}

