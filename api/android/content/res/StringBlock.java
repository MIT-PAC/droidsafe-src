package android.content.res;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Annotation;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LineHeightSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;

import com.android.internal.util.XmlUtils;

import droidsafe.helpers.DSUtils;

final class StringBlock {

    /**
     * If a translator has messed up the edges of paragraph-level markup,
     * fix it to actually cover the entire paragraph that it is attached to
     * instead of just whatever range they put it on.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.529 -0500", hash_original_method = "32E394B127D16A29C22D9E79131F0326", hash_generated_method = "D3D0AFA3A0D72548038FAC82CEAAF4E7")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.532 -0500", hash_original_method = "6ED522717506018533C6A8A2153C3F0A", hash_generated_method = "D25DC98184327A86AC35876B170F11FB")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.467 -0500", hash_original_field = "E972EA7E59D95929329EC1DEC67C521E", hash_generated_field = "FDC75AE01ED37E059BA4F54E9509C8D2")

    private static final String TAG = "AssetManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.469 -0500", hash_original_field = "E7B97A2CD2A2512D00373A5F856DE18B", hash_generated_field = "776D75E65C0F716B6889BA4A8C683647")

    private static final boolean localLOGV = false || false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.471 -0500", hash_original_field = "D883352313723F88BD080533FB82D9CF", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private  int mNative;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.474 -0500", hash_original_field = "3036CA71DF377F23E42CCBF8C874A1A6", hash_generated_field = "038BAFF209AC24C690C68705B5282717")

    private  boolean mUseSparse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.476 -0500", hash_original_field = "F09216251E0F4D523A2150EA7ED00244", hash_generated_field = "6595126F0D7DB182D889144E969DE4FE")

    private  boolean mOwnsNative;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.478 -0500", hash_original_field = "05A510662F4572E888F53697F9A365F4", hash_generated_field = "F69AC8135E9EA2A3E547A8754C61F3E8")

    private CharSequence[] mStrings;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.481 -0500", hash_original_field = "C7051D903C2E43E373689FD1EEA23EC4", hash_generated_field = "FDA16845E27F0B9F87DA93CF41FC8E3B")

    private SparseArray<CharSequence> mSparseStrings;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.483 -0500", hash_original_field = "C5DFF8B48B5B047DBBB9D4B2E886F5DF", hash_generated_field = "C5DFF8B48B5B047DBBB9D4B2E886F5DF")

    StyleIDs mStyleIDs = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.485 -0500", hash_original_method = "C056884F6217F27ACF2C69899BB237D2", hash_generated_method = "42AE755E144841AD7B256252DCB30E56")
    
public StringBlock(byte[] data, boolean useSparse) {
        mNative = nativeCreate(data, 0, data.length);
        mUseSparse = useSparse;
        mOwnsNative = true;
        if (localLOGV) Log.v(TAG, "Created string block " + this
                + ": " + nativeGetSize(mNative));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.488 -0500", hash_original_method = "325B6049E710893083487955374CD75A", hash_generated_method = "B04E4F19AB20FCB53EB97A7D4E701743")
    
public StringBlock(byte[] data, int offset, int size, boolean useSparse) {
        mNative = nativeCreate(data, offset, size);
        mUseSparse = useSparse;
        mOwnsNative = true;
        if (localLOGV) Log.v(TAG, "Created string block " + this
                + ": " + nativeGetSize(mNative));
    }

    /**
     * Create from an existing string block native object.  This is
     * -extremely- dangerous -- only use it if you absolutely know what you
     *  are doing!  The given native object must exist for the entire lifetime
     *  of this newly creating StringBlock.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.549 -0500", hash_original_method = "451F884D80CF979FA811D85381B93BA8", hash_generated_method = "451F884D80CF979FA811D85381B93BA8")
    
StringBlock(int obj, boolean useSparse) {
        mNative = obj;
        mUseSparse = useSparse;
        mOwnsNative = false;
        if (localLOGV) Log.v(TAG, "Created string block " + this
                + ": " + nativeGetSize(mNative));
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.492 -0500", hash_original_method = "CA0D40E41A55E0E3360E62E713B76B88", hash_generated_method = "805F196009A2372027DB8FB8150F7D6F")
    
public CharSequence get(int idx) {
        synchronized (this) {
            if (mStrings != null) {
                CharSequence res = mStrings[idx];
                if (res != null) {
                    return res;
                }
            } else if (mSparseStrings != null) {
                CharSequence res = mSparseStrings.get(idx);
                if (res != null) {
                    return res;
                }
            } else {
                final int num = nativeGetSize(mNative);
                if (mUseSparse && num > 250) {
                    mSparseStrings = new SparseArray<CharSequence>();
                } else {
                    mStrings = new CharSequence[num];
                }
            }
            String str = nativeGetString(mNative, idx);
            CharSequence res = str;
            int[] style = nativeGetStyle(mNative, idx);
            if (localLOGV) Log.v(TAG, "Got string: " + str);
            if (localLOGV) Log.v(TAG, "Got styles: " + style);
            if (style != null) {
                if (mStyleIDs == null) {
                    mStyleIDs = new StyleIDs();
                }

                // the style array is a flat array of <type, start, end> hence
                // the magic constant 3.
                for (int styleIndex = 0; styleIndex < style.length; styleIndex += 3) {
                    int styleId = style[styleIndex];

                    if (styleId == mStyleIDs.boldId || styleId == mStyleIDs.italicId
                            || styleId == mStyleIDs.underlineId || styleId == mStyleIDs.ttId
                            || styleId == mStyleIDs.bigId || styleId == mStyleIDs.smallId
                            || styleId == mStyleIDs.subId || styleId == mStyleIDs.supId
                            || styleId == mStyleIDs.strikeId || styleId == mStyleIDs.listItemId
                            || styleId == mStyleIDs.marqueeId) {
                        // id already found skip to next style
                        continue;
                    }

                    String styleTag = nativeGetString(mNative, styleId);

                    if (styleTag.equals("b")) {
                        mStyleIDs.boldId = styleId;
                    } else if (styleTag.equals("i")) {
                        mStyleIDs.italicId = styleId;
                    } else if (styleTag.equals("u")) {
                        mStyleIDs.underlineId = styleId;
                    } else if (styleTag.equals("tt")) {
                        mStyleIDs.ttId = styleId;
                    } else if (styleTag.equals("big")) {
                        mStyleIDs.bigId = styleId;
                    } else if (styleTag.equals("small")) {
                        mStyleIDs.smallId = styleId;
                    } else if (styleTag.equals("sup")) {
                        mStyleIDs.supId = styleId;
                    } else if (styleTag.equals("sub")) {
                        mStyleIDs.subId = styleId;
                    } else if (styleTag.equals("strike")) {
                        mStyleIDs.strikeId = styleId;
                    } else if (styleTag.equals("li")) {
                        mStyleIDs.listItemId = styleId;
                    } else if (styleTag.equals("marquee")) {
                        mStyleIDs.marqueeId = styleId;
                    }
                }

                res = applyStyles(str, style, mStyleIDs);
            }
            if (mStrings != null) mStrings[idx] = res;
            else mSparseStrings.put(idx, res);
            return res;
        }
    }
    
    static final class StyleIDs {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.496 -0500", hash_original_field = "43C921B24D0E41E9F35401176E29BFCF", hash_generated_field = "8BDB7171C09EC9A28241743847C2F13E")

        private int boldId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.499 -0500", hash_original_field = "7BD3B5DF0EC4D7D4183C1466D1BC8D43", hash_generated_field = "74A882A455EB3847986DA18889B12ABD")

        private int italicId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.501 -0500", hash_original_field = "5624CC230B06644D13A7A506CA442553", hash_generated_field = "4B178C0E94E6CB7A9EABABF4E226C358")

        private int underlineId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.503 -0500", hash_original_field = "5A3A52A48AD063D7F5714091D44CF9BF", hash_generated_field = "3B876BCFB315722E8FE854115777283C")

        private int ttId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.505 -0500", hash_original_field = "248EE53A60429E3CCC993E44580AC04D", hash_generated_field = "1662651FF3F5BF94937725EEC1E5E163")

        private int bigId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.508 -0500", hash_original_field = "FCB57AA2BF68F48083B44B822D5399FA", hash_generated_field = "395D60D5C1FC7586ACC1582BFFB1D8F4")

        private int smallId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.510 -0500", hash_original_field = "A530777034AA8EC1115AF463DEA57948", hash_generated_field = "65712315E81AEF1AEECA880461A13F95")

        private int subId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.512 -0500", hash_original_field = "190E2E0A81324E15159911CA1BB5926A", hash_generated_field = "A4D55EF615A83829CB76931E64607871")

        private int supId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.515 -0500", hash_original_field = "1BF4D9E867B01980362465443E3A5D31", hash_generated_field = "0A84E3D5C0D13817A9952A0E4C94005A")

        private int strikeId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.517 -0500", hash_original_field = "04A11023D8EB9F2798A25F52CB2EBA8D", hash_generated_field = "C2D326660DCA6976087926F02A618B65")

        private int listItemId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.519 -0500", hash_original_field = "9EBDA9D1F6712AFF9192872EB8049591", hash_generated_field = "D299C9BAD3B93162970105F1DB7DE1FA")

        private int marqueeId = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.062 -0400", hash_original_method = "4D3750C386AF43C67E7BA6A1E0512626", hash_generated_method = "4D3750C386AF43C67E7BA6A1E0512626")
        public StyleIDs ()
        {
            //Synthesized constructor
        }

    }
    
    private static class Height implements LineHeightSpan.WithDensity {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.537 -0500", hash_original_field = "626C6192DD0D50EA896F3421FCADF714", hash_generated_field = "2D094D2B577DA7C03844DB00B123469C")

        private static float sProportion = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.535 -0500", hash_original_field = "205262C28D2B190751535A4911B3B259", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

        private int mSize;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.539 -0500", hash_original_method = "822F731BB1BA127213FF49F8E178606F", hash_generated_method = "6F9802207CAC184246E53C5AEFF5656C")
        
public Height(int size) {
            mSize = size;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.542 -0500", hash_original_method = "26F622CE8D56F6DE86DA56D7C47E1EF9", hash_generated_method = "77816809EEFE5EE23D7FABA312789477")
        
public void chooseHeight(CharSequence text, int start, int end,
                                 int spanstartv, int v,
                                 Paint.FontMetricsInt fm) {
            // Should not get called, at least not by StaticLayout.
            chooseHeight(text, start, end, spanstartv, v, fm, null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.544 -0500", hash_original_method = "8C5957365F8EC7EB873EDA19F7109033", hash_generated_method = "249E3498060030185B63E2E1ACB53B31")
        
public void chooseHeight(CharSequence text, int start, int end,
                                 int spanstartv, int v,
                                 Paint.FontMetricsInt fm, TextPaint paint) {
            int size = mSize;
            if (paint != null) {
                size *= paint.density;
            }

            if (fm.bottom - fm.top < size) {
                fm.top = fm.bottom - size;
                fm.ascent = fm.ascent - size;
            } else {
                if (sProportion == 0) {
                    /*
                     * Calculate what fraction of the nominal ascent
                     * the height of a capital letter actually is,
                     * so that we won't reduce the ascent to less than
                     * that unless we absolutely have to.
                     */

                    Paint p = new Paint();
                    p.setTextSize(100);
                    Rect r = new Rect();
                    p.getTextBounds("ABCDEFG", 0, 7, r);

                    sProportion = (r.top) / p.ascent();
                }

                int need = (int) Math.ceil(-fm.top * sProportion);

                if (size - fm.descent >= need) {
                    /*
                     * It is safe to shrink the ascent this much.
                     */

                    fm.top = fm.bottom - size;
                    fm.ascent = fm.descent - size;
                } else if (size >= need) {
                    /*
                     * We can't show all the descent, but we can at least
                     * show all the ascent.
                     */

                    fm.top = fm.ascent = -need;
                    fm.bottom = fm.descent = fm.top + size;
                } else {
                    /*
                     * Show as much of the ascent as we can, and no descent.
                     */

                    fm.top = fm.ascent = -size;
                    fm.bottom = fm.descent = 0;
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.494 -0500", hash_original_method = "0AE42B829C6407A7351435B91C0A8F63", hash_generated_method = "ED04AE5CBF07D783428A00831D294D39")
    
protected void finalize() throws Throwable {
        if (mOwnsNative) {
            nativeDestroy(mNative);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:04.526 -0500", hash_original_method = "7157B2241FD2EE4083D0D740C065977B", hash_generated_method = "1CD4A8276530611254DB89B28CA61DFA")
    
private CharSequence applyStyles(String str, int[] style, StyleIDs ids) {
        if (style.length == 0)
            return str;

        SpannableString buffer = new SpannableString(str);
        int i=0;
        while (i < style.length) {
            int type = style[i];
            if (localLOGV) Log.v(TAG, "Applying style span id=" + type
                    + ", start=" + style[i+1] + ", end=" + style[i+2]);

            if (type == ids.boldId) {
                buffer.setSpan(new StyleSpan(Typeface.BOLD),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (type == ids.italicId) {
                buffer.setSpan(new StyleSpan(Typeface.ITALIC),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (type == ids.underlineId) {
                buffer.setSpan(new UnderlineSpan(),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (type == ids.ttId) {
                buffer.setSpan(new TypefaceSpan("monospace"),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (type == ids.bigId) {
                buffer.setSpan(new RelativeSizeSpan(1.25f),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (type == ids.smallId) {
                buffer.setSpan(new RelativeSizeSpan(0.8f),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (type == ids.subId) {
                buffer.setSpan(new SubscriptSpan(),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (type == ids.supId) {
                buffer.setSpan(new SuperscriptSpan(),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (type == ids.strikeId) {
                buffer.setSpan(new StrikethroughSpan(),
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (type == ids.listItemId) {
                addParagraphSpan(buffer, new BulletSpan(10),
                                style[i+1], style[i+2]+1);
            } else if (type == ids.marqueeId) {
                buffer.setSpan(TextUtils.TruncateAt.MARQUEE,
                               style[i+1], style[i+2]+1,
                               Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            } else {
                String tag = nativeGetString(mNative, type);

                if (tag.startsWith("font;")) {
                    String sub;

                    sub = subtag(tag, ";height=");
                    if (sub != null) {
                        int size = Integer.parseInt(sub);
                        addParagraphSpan(buffer, new Height(size),
                                       style[i+1], style[i+2]+1);
                    }

                    sub = subtag(tag, ";size=");
                    if (sub != null) {
                        int size = Integer.parseInt(sub);
                        buffer.setSpan(new AbsoluteSizeSpan(size, true),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }

                    sub = subtag(tag, ";fgcolor=");
                    if (sub != null) {
                        int color = XmlUtils.convertValueToUnsignedInt(sub, -1);
                        buffer.setSpan(new ForegroundColorSpan(color),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }

                    sub = subtag(tag, ";bgcolor=");
                    if (sub != null) {
                        int color = XmlUtils.convertValueToUnsignedInt(sub, -1);
                        buffer.setSpan(new BackgroundColorSpan(color),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                } else if (tag.startsWith("a;")) {
                    String sub;

                    sub = subtag(tag, ";href=");
                    if (sub != null) {
                        buffer.setSpan(new URLSpan(sub),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                } else if (tag.startsWith("annotation;")) {
                    int len = tag.length();
                    int next;

                    for (int t = tag.indexOf(';'); t < len; t = next) {
                        int eq = tag.indexOf('=', t);
                        if (eq < 0) {
                            break;
                        }

                        next = tag.indexOf(';', eq);
                        if (next < 0) {
                            next = len;
                        }

                        String key = tag.substring(t + 1, eq);
                        String value = tag.substring(eq + 1, next);

                        buffer.setSpan(new Annotation(key, value),
                                       style[i+1], style[i+2]+1,
                                       Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                }
            }

            i += 3;
        }
        return new SpannedString(buffer);
    }
}

