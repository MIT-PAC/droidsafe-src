package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.*;
import android.text.style.*;
import android.util.Log;
import android.util.SparseArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import com.android.internal.util.XmlUtils;

final class StringBlock {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.587 -0400", hash_original_field = "8AF77D45DED615EEBE14D961B1D7F7CE", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private int mNative;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.587 -0400", hash_original_field = "2A38A4CCD243A9CE690C2513B39533CA", hash_generated_field = "038BAFF209AC24C690C68705B5282717")

    private boolean mUseSparse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.587 -0400", hash_original_field = "F802401598A8908D003E80718CBFDDBE", hash_generated_field = "6595126F0D7DB182D889144E969DE4FE")

    private boolean mOwnsNative;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.587 -0400", hash_original_field = "DCFA8FC1CFB8B5A5290D25EC1EA3C56B", hash_generated_field = "F69AC8135E9EA2A3E547A8754C61F3E8")

    private CharSequence[] mStrings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.587 -0400", hash_original_field = "64C4D68429588D5D67FADE5F8FD3E8A3", hash_generated_field = "FDA16845E27F0B9F87DA93CF41FC8E3B")

    private SparseArray<CharSequence> mSparseStrings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.587 -0400", hash_original_field = "B5123735AFFF78DF8F617C925BF7C0C0", hash_generated_field = "C5DFF8B48B5B047DBBB9D4B2E886F5DF")

    StyleIDs mStyleIDs = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.588 -0400", hash_original_method = "C056884F6217F27ACF2C69899BB237D2", hash_generated_method = "4F0A9DDDA48150DF375A701C2C6690CC")
    public  StringBlock(byte[] data, boolean useSparse) {
        mNative = nativeCreate(data, 0, data.length);
        mUseSparse = useSparse;
        mOwnsNative = true;
    if(localLOGV){ }
        // ---------- Original Method ----------
        //mNative = nativeCreate(data, 0, data.length);
        //mUseSparse = useSparse;
        //mOwnsNative = true;
        //if (localLOGV) Log.v(TAG, "Created string block " + this
                //+ ": " + nativeGetSize(mNative));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.589 -0400", hash_original_method = "325B6049E710893083487955374CD75A", hash_generated_method = "60AA75B1220799DAD6E9C7057AB84498")
    public  StringBlock(byte[] data, int offset, int size, boolean useSparse) {
        mNative = nativeCreate(data, offset, size);
        mUseSparse = useSparse;
        mOwnsNative = true;
    if(localLOGV){ }
        // ---------- Original Method ----------
        //mNative = nativeCreate(data, offset, size);
        //mUseSparse = useSparse;
        //mOwnsNative = true;
        //if (localLOGV) Log.v(TAG, "Created string block " + this
                //+ ": " + nativeGetSize(mNative));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.589 -0400", hash_original_method = "451F884D80CF979FA811D85381B93BA8", hash_generated_method = "0D1826B2632CB37E2FB55747A0150CA5")
      StringBlock(int obj, boolean useSparse) {
        mNative = obj;
        mUseSparse = useSparse;
        mOwnsNative = false;
    if(localLOGV){ }
        // ---------- Original Method ----------
        //mNative = obj;
        //mUseSparse = useSparse;
        //mOwnsNative = false;
        //if (localLOGV) Log.v(TAG, "Created string block " + this
                //+ ": " + nativeGetSize(mNative));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.592 -0400", hash_original_method = "CA0D40E41A55E0E3360E62E713B76B88", hash_generated_method = "B787B43C3656DA320C550CA2D409769B")
    public CharSequence get(int idx) {
        synchronized
(this)        {
    if(mStrings != null)            
            {
                CharSequence res = mStrings[idx];
    if(res != null)                
                {
CharSequence varB5053E025797B3BF768F5C37934C244D_99379312 =                     res;
                    varB5053E025797B3BF768F5C37934C244D_99379312.addTaint(taint);
                    return varB5053E025797B3BF768F5C37934C244D_99379312;
                } //End block
            } //End block
            else
    if(mSparseStrings != null)            
            {
                CharSequence res = mSparseStrings.get(idx);
    if(res != null)                
                {
CharSequence varB5053E025797B3BF768F5C37934C244D_772556489 =                     res;
                    varB5053E025797B3BF768F5C37934C244D_772556489.addTaint(taint);
                    return varB5053E025797B3BF768F5C37934C244D_772556489;
                } //End block
            } //End block
            else
            {
                final int num = nativeGetSize(mNative);
    if(mUseSparse && num > 250)                
                {
                    mSparseStrings = new SparseArray<CharSequence>();
                } //End block
                else
                {
                    mStrings = new CharSequence[num];
                } //End block
            } //End block
            String str = nativeGetString(mNative, idx);
            CharSequence res = str;
            int[] style = nativeGetStyle(mNative, idx);
    if(localLOGV){ }    if(localLOGV){ }    if(style != null)            
            {
    if(mStyleIDs == null)                
                {
                    mStyleIDs = new StyleIDs();
                } //End block
for(int styleIndex = 0;styleIndex < style.length;styleIndex += 3)
                {
                    int styleId = style[styleIndex];
    if(styleId == mStyleIDs.boldId || styleId == mStyleIDs.italicId
                            || styleId == mStyleIDs.underlineId || styleId == mStyleIDs.ttId
                            || styleId == mStyleIDs.bigId || styleId == mStyleIDs.smallId
                            || styleId == mStyleIDs.subId || styleId == mStyleIDs.supId
                            || styleId == mStyleIDs.strikeId || styleId == mStyleIDs.listItemId
                            || styleId == mStyleIDs.marqueeId)                    
                    {
                        continue;
                    } //End block
                    String styleTag = nativeGetString(mNative, styleId);
    if(styleTag.equals("b"))                    
                    {
                        mStyleIDs.boldId = styleId;
                    } //End block
                    else
    if(styleTag.equals("i"))                    
                    {
                        mStyleIDs.italicId = styleId;
                    } //End block
                    else
    if(styleTag.equals("u"))                    
                    {
                        mStyleIDs.underlineId = styleId;
                    } //End block
                    else
    if(styleTag.equals("tt"))                    
                    {
                        mStyleIDs.ttId = styleId;
                    } //End block
                    else
    if(styleTag.equals("big"))                    
                    {
                        mStyleIDs.bigId = styleId;
                    } //End block
                    else
    if(styleTag.equals("small"))                    
                    {
                        mStyleIDs.smallId = styleId;
                    } //End block
                    else
    if(styleTag.equals("sup"))                    
                    {
                        mStyleIDs.supId = styleId;
                    } //End block
                    else
    if(styleTag.equals("sub"))                    
                    {
                        mStyleIDs.subId = styleId;
                    } //End block
                    else
    if(styleTag.equals("strike"))                    
                    {
                        mStyleIDs.strikeId = styleId;
                    } //End block
                    else
    if(styleTag.equals("li"))                    
                    {
                        mStyleIDs.listItemId = styleId;
                    } //End block
                    else
    if(styleTag.equals("marquee"))                    
                    {
                        mStyleIDs.marqueeId = styleId;
                    } //End block
                } //End block
                res = applyStyles(str, style, mStyleIDs);
            } //End block
    if(mStrings != null)            
            mStrings[idx] = res;
            else
            mSparseStrings.put(idx, res);
CharSequence varB5053E025797B3BF768F5C37934C244D_1899010486 =             res;
            varB5053E025797B3BF768F5C37934C244D_1899010486.addTaint(taint);
            return varB5053E025797B3BF768F5C37934C244D_1899010486;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.594 -0400", hash_original_method = "0AE42B829C6407A7351435B91C0A8F63", hash_generated_method = "9B316FC98E3AB60D004F5D4D4B36377A")
    protected void finalize() throws Throwable {
    if(mOwnsNative)        
        {
            nativeDestroy(mNative);
        } //End block
        // ---------- Original Method ----------
        //if (mOwnsNative) {
            //nativeDestroy(mNative);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.597 -0400", hash_original_method = "7157B2241FD2EE4083D0D740C065977B", hash_generated_method = "C96627CAC0D343B7AD6D8CE3F7CB877B")
    private CharSequence applyStyles(String str, int[] style, StyleIDs ids) {
        addTaint(ids.getTaint());
        addTaint(style[0]);
        addTaint(str.getTaint());
    if(style.length == 0)        
        {
CharSequence var061B89662D09DE43FE2A2D88636258A2_1858025078 =         str;
        var061B89662D09DE43FE2A2D88636258A2_1858025078.addTaint(taint);
        return var061B89662D09DE43FE2A2D88636258A2_1858025078;
        }
        SpannableString buffer = new SpannableString(str);
        int i = 0;
        while
(i < style.length)        
        {
            int type = style[i];
    if(localLOGV){ }    if(type == ids.boldId)            
            {
                buffer.setSpan(new StyleSpan(Typeface.BOLD),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            else
    if(type == ids.italicId)            
            {
                buffer.setSpan(new StyleSpan(Typeface.ITALIC),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            else
    if(type == ids.underlineId)            
            {
                buffer.setSpan(new UnderlineSpan(),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            else
    if(type == ids.ttId)            
            {
                buffer.setSpan(new TypefaceSpan("monospace"),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            else
    if(type == ids.bigId)            
            {
                buffer.setSpan(new RelativeSizeSpan(1.25f),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            else
    if(type == ids.smallId)            
            {
                buffer.setSpan(new RelativeSizeSpan(0.8f),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            else
    if(type == ids.subId)            
            {
                buffer.setSpan(new SubscriptSpan(),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            else
    if(type == ids.supId)            
            {
                buffer.setSpan(new SuperscriptSpan(),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            else
    if(type == ids.strikeId)            
            {
                buffer.setSpan(new StrikethroughSpan(),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            else
    if(type == ids.listItemId)            
            {
                addParagraphSpan(buffer, new BulletSpan(10),
                                style[i+1], style[i+2]+1);
            } //End block
            else
    if(type == ids.marqueeId)            
            {
                buffer.setSpan(TextUtils.TruncateAt.MARQUEE,
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            } //End block
            else
            {
                String tag = nativeGetString(mNative, type);
    if(tag.startsWith("font;"))                
                {
                    String sub;
                    sub = subtag(tag, ";height=");
    if(sub != null)                    
                    {
                        int size = Integer.parseInt(sub);
                        addParagraphSpan(buffer, new Height(size),
                                       style[i+1], style[i+2]+1);
                    } //End block
                    sub = subtag(tag, ";size=");
    if(sub != null)                    
                    {
                        int size = Integer.parseInt(sub);
                        buffer.setSpan(new AbsoluteSizeSpan(size, true),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    } //End block
                    sub = subtag(tag, ";fgcolor=");
    if(sub != null)                    
                    {
                        int color = XmlUtils.convertValueToUnsignedInt(sub, -1);
                        buffer.setSpan(new ForegroundColorSpan(color),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    } //End block
                    sub = subtag(tag, ";bgcolor=");
    if(sub != null)                    
                    {
                        int color = XmlUtils.convertValueToUnsignedInt(sub, -1);
                        buffer.setSpan(new BackgroundColorSpan(color),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    } //End block
                } //End block
                else
    if(tag.startsWith("a;"))                
                {
                    String sub;
                    sub = subtag(tag, ";href=");
    if(sub != null)                    
                    {
                        buffer.setSpan(new URLSpan(sub),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    } //End block
                } //End block
                else
    if(tag.startsWith("annotation;"))                
                {
                    int len = tag.length();
                    int next;
for(int t = tag.indexOf(';');t < len;t = next)
                    {
                        int eq = tag.indexOf('=', t);
    if(eq < 0)                        
                        {
                            break;
                        } //End block
                        next = tag.indexOf(';', eq);
    if(next < 0)                        
                        {
                            next = len;
                        } //End block
                        String key = tag.substring(t + 1, eq);
                        String value = tag.substring(eq + 1, next);
                        buffer.setSpan(new Annotation(key, value),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    } //End block
                } //End block
            } //End block
            i += 3;
        } //End block
CharSequence varAB46AC10AF20400ACC82DD97491C87AF_223871313 =         new SpannedString(buffer);
        varAB46AC10AF20400ACC82DD97491C87AF_223871313.addTaint(taint);
        return varAB46AC10AF20400ACC82DD97491C87AF_223871313;
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
        	String ret = new String();
        	ret.addTaint(obj);
        	ret.addTaint(idx);
        	return ret;
    }

    
    private static final int[] nativeGetStyle(int obj, int idx) {
        int[] ret = {DSUtils.UNKNOWN_INT};
        return ret;
    }

    
    private static final void nativeDestroy(int obj) {
    }

    
    static final class StyleIDs {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.601 -0400", hash_original_field = "8929F60960F20370C15483AF224B1EAF", hash_generated_field = "8BDB7171C09EC9A28241743847C2F13E")

        private int boldId = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.601 -0400", hash_original_field = "FABD409DACB3A477CA91454B83ABCA28", hash_generated_field = "74A882A455EB3847986DA18889B12ABD")

        private int italicId = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.601 -0400", hash_original_field = "191B082733B8400625829E1BF82A5984", hash_generated_field = "4B178C0E94E6CB7A9EABABF4E226C358")

        private int underlineId = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.601 -0400", hash_original_field = "9D75F65BAA96E3876CED4CA073865EAD", hash_generated_field = "3B876BCFB315722E8FE854115777283C")

        private int ttId = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.602 -0400", hash_original_field = "52691BA3827A29F3E79DFB9FE11DB6E7", hash_generated_field = "1662651FF3F5BF94937725EEC1E5E163")

        private int bigId = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.602 -0400", hash_original_field = "3AD8F230B4D50E3AFD2E9CDF97A81BED", hash_generated_field = "395D60D5C1FC7586ACC1582BFFB1D8F4")

        private int smallId = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.602 -0400", hash_original_field = "A38D530972AA77B1D220067D84FC13DE", hash_generated_field = "65712315E81AEF1AEECA880461A13F95")

        private int subId = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.602 -0400", hash_original_field = "2890514472C2EC26FDC158F357C9094D", hash_generated_field = "A4D55EF615A83829CB76931E64607871")

        private int supId = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.602 -0400", hash_original_field = "2277E9A3494373D144CB63240D1A671A", hash_generated_field = "0A84E3D5C0D13817A9952A0E4C94005A")

        private int strikeId = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.602 -0400", hash_original_field = "0EA1254D6779D964DDFE2F1CF27671AA", hash_generated_field = "C2D326660DCA6976087926F02A618B65")

        private int listItemId = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.602 -0400", hash_original_field = "5777998D282E2540236C985B4E76024F", hash_generated_field = "D299C9BAD3B93162970105F1DB7DE1FA")

        private int marqueeId = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.603 -0400", hash_original_method = "4D3750C386AF43C67E7BA6A1E0512626", hash_generated_method = "4D3750C386AF43C67E7BA6A1E0512626")
        public StyleIDs ()
        {
            //Synthesized constructor
        }


    }


    
    private static class Height implements LineHeightSpan.WithDensity {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.603 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

        private int mSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.603 -0400", hash_original_method = "822F731BB1BA127213FF49F8E178606F", hash_generated_method = "8B0CB46E6A2F126B20C4298DCDA8FF8F")
        public  Height(int size) {
            mSize = size;
            // ---------- Original Method ----------
            //mSize = size;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.604 -0400", hash_original_method = "26F622CE8D56F6DE86DA56D7C47E1EF9", hash_generated_method = "04A4564C67D98A641F3E71EA08140F5D")
        public void chooseHeight(CharSequence text, int start, int end,
                                 int spanstartv, int v,
                                 Paint.FontMetricsInt fm) {
            addTaint(fm.getTaint());
            addTaint(v);
            addTaint(spanstartv);
            addTaint(end);
            addTaint(start);
            addTaint(text.getTaint());
            chooseHeight(text, start, end, spanstartv, v, fm, null);
            // ---------- Original Method ----------
            //chooseHeight(text, start, end, spanstartv, v, fm, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.606 -0400", hash_original_method = "8C5957365F8EC7EB873EDA19F7109033", hash_generated_method = "6F3151B972A5840AB031A3BFA4B9204D")
        public void chooseHeight(CharSequence text, int start, int end,
                                 int spanstartv, int v,
                                 Paint.FontMetricsInt fm, TextPaint paint) {
            addTaint(paint.getTaint());
            addTaint(fm.getTaint());
            addTaint(v);
            addTaint(spanstartv);
            addTaint(end);
            addTaint(start);
            addTaint(text.getTaint());
            int size = mSize;
    if(paint != null)            
            {
                size *= paint.density;
            } //End block
    if(fm.bottom - fm.top < size)            
            {
                fm.top = fm.bottom - size;
                fm.ascent = fm.ascent - size;
            } //End block
            else
            {
    if(sProportion == 0)                
                {
                    Paint p = new Paint();
                    p.setTextSize(100);
                    Rect r = new Rect();
                    p.getTextBounds("ABCDEFG", 0, 7, r);
                    sProportion = (r.top) / p.ascent();
                } //End block
                int need = (int) Math.ceil(-fm.top * sProportion);
    if(size - fm.descent >= need)                
                {
                    fm.top = fm.bottom - size;
                    fm.ascent = fm.descent - size;
                } //End block
                else
    if(size >= need)                
                {
                    fm.top = fm.ascent = -need;
                    fm.bottom = fm.descent = fm.top + size;
                } //End block
                else
                {
                    fm.top = fm.ascent = -size;
                    fm.bottom = fm.descent = 0;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.606 -0400", hash_original_field = "D3D4C463ED759C9C5346737D3B29514A", hash_generated_field = "2D094D2B577DA7C03844DB00B123469C")

        private static float sProportion = 0;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.606 -0400", hash_original_field = "D32CE489FB85E2EA1BB422AEDC40B577", hash_generated_field = "FDC75AE01ED37E059BA4F54E9509C8D2")

    private static final String TAG = "AssetManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.606 -0400", hash_original_field = "81A92DF01F23C5A9AD1A3D7A55CE01D7", hash_generated_field = "776D75E65C0F716B6889BA4A8C683647")

    private static final boolean localLOGV = false || false;
}

