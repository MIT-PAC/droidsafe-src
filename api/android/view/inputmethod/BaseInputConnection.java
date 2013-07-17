package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.util.Log;
import android.util.LogPrinter;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewRootImpl;

class ComposingText implements NoCopySpan {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.232 -0400", hash_original_method = "299AC39680AC1BE3A17612B5D7B1D330", hash_generated_method = "299AC39680AC1BE3A17612B5D7B1D330")
    public ComposingText ()
    {
        //Synthesized constructor
    }


}

public class BaseInputConnection implements InputConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.233 -0400", hash_original_field = "14E624678D0167A1D4F7B9DAF4BB3911", hash_generated_field = "141F0EFC0D8976518F576600E5590698")

    protected InputMethodManager mIMM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.233 -0400", hash_original_field = "4FDD02795CD9F6B3D3D1A34A14720073", hash_generated_field = "97ACD18EF4B48BDC424981A4C6E55C66")

    View mTargetView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.233 -0400", hash_original_field = "7A74C515F1C024E4A8A2C659CD63F25D", hash_generated_field = "B578BC86523A8ED06C11106F457EA3A1")

    boolean mDummyMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.233 -0400", hash_original_field = "DC2DB2F90A8C23F2FDC026A43D03668D", hash_generated_field = "252704B80FDD4D9B6E86ECF1CBD2B09A")

    private Object[] mDefaultComposingSpans;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.233 -0400", hash_original_field = "03FD58BE1D67B8547AADB1829EF91363", hash_generated_field = "BC747A06F00EC3CB73FDE2D30B84DC2D")

    Editable mEditable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.233 -0400", hash_original_field = "C7BC21409380B9440A2B406EA5A8934C", hash_generated_field = "5553093AC34FB198BC290668CD3A4BD4")

    KeyCharacterMap mKeyCharacterMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.234 -0400", hash_original_method = "1A943D99EC75638EA04879F1FF8F4BB3", hash_generated_method = "D904201E77FBD444E7EC22E5A2FA95EE")
      BaseInputConnection(InputMethodManager mgr, boolean fullEditor) {
        mIMM = mgr;
        mTargetView = null;
        mDummyMode = !fullEditor;
        // ---------- Original Method ----------
        //mIMM = mgr;
        //mTargetView = null;
        //mDummyMode = !fullEditor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.235 -0400", hash_original_method = "8D9F46A02734088C3A101A4C25C68420", hash_generated_method = "7E503C534998A7CE2443D4066DFB4BA4")
    public  BaseInputConnection(View targetView, boolean fullEditor) {
        mIMM = (InputMethodManager)targetView.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        mTargetView = targetView;
        mDummyMode = !fullEditor;
        // ---------- Original Method ----------
        //mIMM = (InputMethodManager)targetView.getContext().getSystemService(
                //Context.INPUT_METHOD_SERVICE);
        //mTargetView = targetView;
        //mDummyMode = !fullEditor;
    }

    
    public static final void removeComposingSpans(Spannable text) {
        text.removeSpan(COMPOSING);
        Object[] sps = text.getSpans(0, text.length(), Object.class);
        if (sps != null) {
            for (int i=sps.length-1; i>=0; i--) {
                Object o = sps[i];
                if ((text.getSpanFlags(o)&Spanned.SPAN_COMPOSING) != 0) {
                    text.removeSpan(o);
                }
            }
        }
    }

    
    public static void setComposingSpans(Spannable text) {
        setComposingSpans(text, 0, text.length());
    }

    
    public static void setComposingSpans(Spannable text, int start, int end) {
        final Object[] sps = text.getSpans(start, end, Object.class);
        if (sps != null) {
            for (int i=sps.length-1; i>=0; i--) {
                final Object o = sps[i];
                if (o == COMPOSING) {
                    text.removeSpan(o);
                    continue;
                }
                final int fl = text.getSpanFlags(o);
                if ((fl&(Spanned.SPAN_COMPOSING|Spanned.SPAN_POINT_MARK_MASK)) 
                        != (Spanned.SPAN_COMPOSING|Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)) {
                    text.setSpan(o, text.getSpanStart(o), text.getSpanEnd(o),
                            (fl & ~Spanned.SPAN_POINT_MARK_MASK)
                                    | Spanned.SPAN_COMPOSING
                                    | Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        }
        text.setSpan(COMPOSING, start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE | Spanned.SPAN_COMPOSING);
    }

    
    public static int getComposingSpanStart(Spannable text) {
        return text.getSpanStart(COMPOSING);
    }

    
    public static int getComposingSpanEnd(Spannable text) {
        return text.getSpanEnd(COMPOSING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.238 -0400", hash_original_method = "A97F5DFC2840DF7B5D61C809FDCD4D64", hash_generated_method = "CC9547E16F7986CFA689FB07297DA4F1")
    public Editable getEditable() {
        if(mEditable == null)        
        {
            mEditable = Editable.Factory.getInstance().newEditable("");
            Selection.setSelection(mEditable, 0);
        } //End block
Editable varCC26BBC33AB90DD8701B3B15E792A870_878396068 =         mEditable;
        varCC26BBC33AB90DD8701B3B15E792A870_878396068.addTaint(taint);
        return varCC26BBC33AB90DD8701B3B15E792A870_878396068;
        // ---------- Original Method ----------
        //if (mEditable == null) {
            //mEditable = Editable.Factory.getInstance().newEditable("");
            //Selection.setSelection(mEditable, 0);
        //}
        //return mEditable;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.238 -0400", hash_original_method = "E28DA299470AFBBB55E3F0E22CB4A567", hash_generated_method = "FCB017FD8A183BFB724C6971C7560B68")
    public boolean beginBatchEdit() {
        boolean var68934A3E9455FA72420237EB05902327_1873063530 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1697199641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1697199641;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.239 -0400", hash_original_method = "68C20202F4C35ADB2F9CDE7850BF84CC", hash_generated_method = "839ADCDC3540873925A3C86A644C340A")
    public boolean endBatchEdit() {
        boolean var68934A3E9455FA72420237EB05902327_1528628529 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1570019829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1570019829;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.239 -0400", hash_original_method = "BC6513316EC80C5373FB6263D33C3F52", hash_generated_method = "FC58B5469A0187086D8084B37131B30F")
    public boolean clearMetaKeyStates(int states) {
        addTaint(states);
        final Editable content = getEditable();
        if(content == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_2025482910 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1491243872 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1491243872;
        }
        MetaKeyKeyListener.clearMetaKeyState(content, states);
        boolean varB326B5062B2F0E69046810717534CB09_1284972944 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676791207 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_676791207;
        // ---------- Original Method ----------
        //final Editable content = getEditable();
        //if (content == null) return false;
        //MetaKeyKeyListener.clearMetaKeyState(content, states);
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.240 -0400", hash_original_method = "AA7244FCF81F32F7DEF3D51FAE032B7D", hash_generated_method = "D1B43280E999C7D2E421A6A4C6A8ADE3")
    public boolean commitCompletion(CompletionInfo text) {
        addTaint(text.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1066854607 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_253441870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_253441870;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.240 -0400", hash_original_method = "8ECFF7D6DBED10855DA2C653047584D7", hash_generated_method = "7F7F57282D2CFC3114FEE117BF37F2BC")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        addTaint(correctionInfo.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_668613806 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_768523615 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_768523615;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.241 -0400", hash_original_method = "25125C99E3204B3B6C4C8BDE15E97EE8", hash_generated_method = "657732E0E6BE7997C5626886B3ED8064")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        if(DEBUG){ }        replaceText(text, newCursorPosition, false);
        sendCurrentText();
        boolean varB326B5062B2F0E69046810717534CB09_299699335 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_246982447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_246982447;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "commitText " + text);
        //replaceText(text, newCursorPosition, false);
        //sendCurrentText();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.242 -0400", hash_original_method = "74B12EE6F294A949F3B11979331384E6", hash_generated_method = "5DF0606A7E98CAA7A8073F476BF8CB40")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        addTaint(rightLength);
        addTaint(leftLength);
        if(DEBUG){ }        final Editable content = getEditable();
        if(content == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1342457996 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_181797196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_181797196;
        }
        beginBatchEdit();
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
        if(a > b)        
        {
            int tmp = a;
            a = b;
            b = tmp;
        } //End block
        int ca = getComposingSpanStart(content);
        int cb = getComposingSpanEnd(content);
        if(cb < ca)        
        {
            int tmp = ca;
            ca = cb;
            cb = tmp;
        } //End block
        if(ca != -1 && cb != -1)        
        {
            if(ca < a)            
            a = ca;
            if(cb > b)            
            b = cb;
        } //End block
        int deleted = 0;
        if(leftLength > 0)        
        {
            int start = a - leftLength;
            if(start < 0)            
            start = 0;
            content.delete(start, a);
            deleted = a - start;
        } //End block
        if(rightLength > 0)        
        {
            b = b - deleted;
            int end = b + rightLength;
            if(end > content.length())            
            end = content.length();
            content.delete(b, end);
        } //End block
        endBatchEdit();
        boolean varB326B5062B2F0E69046810717534CB09_1761907863 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1880914418 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1880914418;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.243 -0400", hash_original_method = "1CCB9955A4205D39AC8709BDCAB9AF4C", hash_generated_method = "83615B64B2DAABC7C13432A0BDC194A3")
    public boolean finishComposingText() {
        if(DEBUG){ }        final Editable content = getEditable();
        if(content != null)        
        {
            beginBatchEdit();
            removeComposingSpans(content);
            endBatchEdit();
            sendCurrentText();
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_649852355 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1991203682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1991203682;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "finishComposingText");
        //final Editable content = getEditable();
        //if (content != null) {
            //beginBatchEdit();
            //removeComposingSpans(content);
            //endBatchEdit();
            //sendCurrentText();
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.244 -0400", hash_original_method = "A12ABCD2EB4522E8FE53DB6299A361B5", hash_generated_method = "2BA70D0F94EADBC485E8EFB280294906")
    public int getCursorCapsMode(int reqModes) {
        addTaint(reqModes);
        if(mDummyMode)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_950511951 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161061317 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161061317;
        }
        final Editable content = getEditable();
        if(content == null)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1764628302 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566164773 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566164773;
        }
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
        if(a > b)        
        {
            int tmp = a;
            a = b;
            b = tmp;
        } //End block
        int varAC1DC7664A2FAF8D24FFCD56574315AA_927925900 = (TextUtils.getCapsMode(content, a, reqModes));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674141172 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674141172;
        // ---------- Original Method ----------
        //if (mDummyMode) return 0;
        //final Editable content = getEditable();
        //if (content == null) return 0;
        //int a = Selection.getSelectionStart(content);
        //int b = Selection.getSelectionEnd(content);
        //if (a > b) {
            //int tmp = a;
            //a = b;
            //b = tmp;
        //}
        //return TextUtils.getCapsMode(content, a, reqModes);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.244 -0400", hash_original_method = "A2A8D9B6A3DC6DA18051F8E023FD4A27", hash_generated_method = "6B979F0795168EAADDEE2CEF23706532")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        addTaint(flags);
        addTaint(request.getTaint());
ExtractedText var540C13E9E156B687226421B24F2DF178_278354610 =         null;
        var540C13E9E156B687226421B24F2DF178_278354610.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_278354610;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.245 -0400", hash_original_method = "75E370B84589846A89A63AE625719BF1", hash_generated_method = "592AB6A9274FFFEBF24721BA962D9AB4")
    public CharSequence getTextBeforeCursor(int length, int flags) {
        addTaint(flags);
        addTaint(length);
        final Editable content = getEditable();
        if(content == null)        
        {
CharSequence var540C13E9E156B687226421B24F2DF178_38272832 =         null;
        var540C13E9E156B687226421B24F2DF178_38272832.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_38272832;
        }
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
        if(a > b)        
        {
            int tmp = a;
            a = b;
            b = tmp;
        } //End block
        if(a <= 0)        
        {
CharSequence var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1315475438 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1315475438.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1315475438;
        } //End block
        if(length > a)        
        {
            length = a;
        } //End block
        if((flags&GET_TEXT_WITH_STYLES) != 0)        
        {
CharSequence var98F4DAC361D2DB9395F44CE0388E2FEB_1514213699 =             content.subSequence(a - length, a);
            var98F4DAC361D2DB9395F44CE0388E2FEB_1514213699.addTaint(taint);
            return var98F4DAC361D2DB9395F44CE0388E2FEB_1514213699;
        } //End block
CharSequence varE0983249B3322D55B8820CF6237DB0C2_852306958 =         TextUtils.substring(content, a - length, a);
        varE0983249B3322D55B8820CF6237DB0C2_852306958.addTaint(taint);
        return varE0983249B3322D55B8820CF6237DB0C2_852306958;
        // ---------- Original Method ----------
        //final Editable content = getEditable();
        //if (content == null) return null;
        //int a = Selection.getSelectionStart(content);
        //int b = Selection.getSelectionEnd(content);
        //if (a > b) {
            //int tmp = a;
            //a = b;
            //b = tmp;
        //}
        //if (a <= 0) {
            //return "";
        //}
        //if (length > a) {
            //length = a;
        //}
        //if ((flags&GET_TEXT_WITH_STYLES) != 0) {
            //return content.subSequence(a - length, a);
        //}
        //return TextUtils.substring(content, a - length, a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.246 -0400", hash_original_method = "ED9D872BFDE8C5E26AC99155DBA149BF", hash_generated_method = "76F917BB877E49962835B91ECF834192")
    public CharSequence getSelectedText(int flags) {
        addTaint(flags);
        final Editable content = getEditable();
        if(content == null)        
        {
CharSequence var540C13E9E156B687226421B24F2DF178_1249202030 =         null;
        var540C13E9E156B687226421B24F2DF178_1249202030.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1249202030;
        }
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
        if(a > b)        
        {
            int tmp = a;
            a = b;
            b = tmp;
        } //End block
        if(a == b)        
        {
CharSequence var540C13E9E156B687226421B24F2DF178_506600541 =         null;
        var540C13E9E156B687226421B24F2DF178_506600541.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_506600541;
        }
        if((flags&GET_TEXT_WITH_STYLES) != 0)        
        {
CharSequence var9FEC3648C14F3AF70D16DE447BDE5069_1643488956 =             content.subSequence(a, b);
            var9FEC3648C14F3AF70D16DE447BDE5069_1643488956.addTaint(taint);
            return var9FEC3648C14F3AF70D16DE447BDE5069_1643488956;
        } //End block
CharSequence var7A2F1FD98731D6CF16BD95DD1582A13C_2114277094 =         TextUtils.substring(content, a, b);
        var7A2F1FD98731D6CF16BD95DD1582A13C_2114277094.addTaint(taint);
        return var7A2F1FD98731D6CF16BD95DD1582A13C_2114277094;
        // ---------- Original Method ----------
        //final Editable content = getEditable();
        //if (content == null) return null;
        //int a = Selection.getSelectionStart(content);
        //int b = Selection.getSelectionEnd(content);
        //if (a > b) {
            //int tmp = a;
            //a = b;
            //b = tmp;
        //}
        //if (a == b) return null;
        //if ((flags&GET_TEXT_WITH_STYLES) != 0) {
            //return content.subSequence(a, b);
        //}
        //return TextUtils.substring(content, a, b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.247 -0400", hash_original_method = "08096EEE0873EB795CD58B469F10D5B2", hash_generated_method = "DF1AC866BE074402059D53B816CEAD8B")
    public CharSequence getTextAfterCursor(int length, int flags) {
        addTaint(flags);
        addTaint(length);
        final Editable content = getEditable();
        if(content == null)        
        {
CharSequence var540C13E9E156B687226421B24F2DF178_1116105621 =         null;
        var540C13E9E156B687226421B24F2DF178_1116105621.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1116105621;
        }
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
        if(a > b)        
        {
            int tmp = a;
            a = b;
            b = tmp;
        } //End block
        if(b < 0)        
        {
            b = 0;
        } //End block
        if(b + length > content.length())        
        {
            length = content.length() - b;
        } //End block
        if((flags&GET_TEXT_WITH_STYLES) != 0)        
        {
CharSequence var4A6E4E8B570A86454B984D76FFE2C8FA_420336988 =             content.subSequence(b, b + length);
            var4A6E4E8B570A86454B984D76FFE2C8FA_420336988.addTaint(taint);
            return var4A6E4E8B570A86454B984D76FFE2C8FA_420336988;
        } //End block
CharSequence var6D90238DD76AA0130EFA44B03DDEEA38_2005331946 =         TextUtils.substring(content, b, b + length);
        var6D90238DD76AA0130EFA44B03DDEEA38_2005331946.addTaint(taint);
        return var6D90238DD76AA0130EFA44B03DDEEA38_2005331946;
        // ---------- Original Method ----------
        //final Editable content = getEditable();
        //if (content == null) return null;
        //int a = Selection.getSelectionStart(content);
        //int b = Selection.getSelectionEnd(content);
        //if (a > b) {
            //int tmp = a;
            //a = b;
            //b = tmp;
        //}
        //if (b < 0) {
            //b = 0;
        //}
        //if (b + length > content.length()) {
            //length = content.length() - b;
        //}
        //if ((flags&GET_TEXT_WITH_STYLES) != 0) {
            //return content.subSequence(b, b + length);
        //}
        //return TextUtils.substring(content, b, b + length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.248 -0400", hash_original_method = "F533043312AA12AABEB855D393677CB5", hash_generated_method = "40681F3D96D5F276708E9F4F2E4D3D9F")
    public boolean performEditorAction(int actionCode) {
        addTaint(actionCode);
        long eventTime = SystemClock.uptimeMillis();
        sendKeyEvent(new KeyEvent(eventTime, eventTime,
                KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER, 0, 0,
                KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                KeyEvent.FLAG_SOFT_KEYBOARD | KeyEvent.FLAG_KEEP_TOUCH_MODE
                | KeyEvent.FLAG_EDITOR_ACTION));
        sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), eventTime,
                KeyEvent.ACTION_UP, KeyEvent.KEYCODE_ENTER, 0, 0,
                KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                KeyEvent.FLAG_SOFT_KEYBOARD | KeyEvent.FLAG_KEEP_TOUCH_MODE
                | KeyEvent.FLAG_EDITOR_ACTION));
        boolean varB326B5062B2F0E69046810717534CB09_1713719377 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1554042723 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1554042723;
        // ---------- Original Method ----------
        //long eventTime = SystemClock.uptimeMillis();
        //sendKeyEvent(new KeyEvent(eventTime, eventTime,
                //KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER, 0, 0,
                //KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                //KeyEvent.FLAG_SOFT_KEYBOARD | KeyEvent.FLAG_KEEP_TOUCH_MODE
                //| KeyEvent.FLAG_EDITOR_ACTION));
        //sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), eventTime,
                //KeyEvent.ACTION_UP, KeyEvent.KEYCODE_ENTER, 0, 0,
                //KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                //KeyEvent.FLAG_SOFT_KEYBOARD | KeyEvent.FLAG_KEEP_TOUCH_MODE
                //| KeyEvent.FLAG_EDITOR_ACTION));
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.248 -0400", hash_original_method = "CC9943DA76C04BDA8199AB8562F111EF", hash_generated_method = "08139D4E5DADA2F5F0D02E623673F459")
    public boolean performContextMenuAction(int id) {
        addTaint(id);
        boolean var68934A3E9455FA72420237EB05902327_1939215275 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_232143940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_232143940;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.249 -0400", hash_original_method = "E554B360562612AFCC9A87837C58FB1E", hash_generated_method = "BD82E7CF28A9B6DF156830E141FA3398")
    public boolean performPrivateCommand(String action, Bundle data) {
        addTaint(data.getTaint());
        addTaint(action.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_580193766 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_326071115 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_326071115;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.249 -0400", hash_original_method = "9F64937BB19F72531BAD6E029A24112C", hash_generated_method = "F5403707CB3A2AD2293A6825D05CF2AC")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        if(DEBUG){ }        replaceText(text, newCursorPosition, true);
        boolean varB326B5062B2F0E69046810717534CB09_423224841 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_299415773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_299415773;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "setComposingText " + text);
        //replaceText(text, newCursorPosition, true);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.251 -0400", hash_original_method = "683D72CF1BBC9E7A391F140A2B9406BC", hash_generated_method = "20933AE91726936FE28F132C12EAD2B3")
    public boolean setComposingRegion(int start, int end) {
        addTaint(end);
        addTaint(start);
        final Editable content = getEditable();
        if(content != null)        
        {
            beginBatchEdit();
            removeComposingSpans(content);
            int a = start;
            int b = end;
            if(a > b)            
            {
                int tmp = a;
                a = b;
                b = tmp;
            } //End block
            final int length = content.length();
            if(a < 0)            
            a = 0;
            if(b < 0)            
            b = 0;
            if(a > length)            
            a = length;
            if(b > length)            
            b = length;
            ensureDefaultComposingSpans();
            if(mDefaultComposingSpans != null)            
            {
for(int i = 0;i < mDefaultComposingSpans.length;++i)
                {
                    content.setSpan(mDefaultComposingSpans[i], a, b,
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE | Spanned.SPAN_COMPOSING);
                } //End block
            } //End block
            content.setSpan(COMPOSING, a, b,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE | Spanned.SPAN_COMPOSING);
            endBatchEdit();
            sendCurrentText();
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_961552416 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_473341473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_473341473;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.251 -0400", hash_original_method = "06BE1F921CCFEC5EE49CD2FF18114BBC", hash_generated_method = "AD664EEAA79236CF2C8F14093852D0FD")
    public boolean setSelection(int start, int end) {
        addTaint(end);
        addTaint(start);
        if(DEBUG){ }        final Editable content = getEditable();
        if(content == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_354250167 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1322494800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1322494800;
        }
        int len = content.length();
        if(start > len || end > len)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_252682798 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_849889773 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_849889773;
        } //End block
        if(start == end && MetaKeyKeyListener.getMetaState(content,
                MetaKeyKeyListener.META_SELECTING) != 0)        
        {
            Selection.extendSelection(content, start);
        } //End block
        else
        {
            Selection.setSelection(content, start, end);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1481249962 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_441568669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_441568669;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "setSelection " + start + ", " + end);
        //final Editable content = getEditable();
        //if (content == null) return false;
        //int len = content.length();
        //if (start > len || end > len) {
            //return true;
        //}
        //if (start == end && MetaKeyKeyListener.getMetaState(content,
                //MetaKeyKeyListener.META_SELECTING) != 0) {
            //Selection.extendSelection(content, start);
        //} else {
            //Selection.setSelection(content, start, end);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.251 -0400", hash_original_method = "F539697840E1FFDBA9E983D0C0D8D0DD", hash_generated_method = "2FD36D6DE9359675B802D34EB0F5F7D7")
    public boolean sendKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        synchronized
(mIMM.mH)        {
            Handler h = mTargetView != null ? mTargetView.getHandler() : null;
            if(h == null)            
            {
                if(mIMM.mServedView != null)                
                {
                    h = mIMM.mServedView.getHandler();
                } //End block
            } //End block
            if(h != null)            
            {
                h.sendMessage(h.obtainMessage(ViewRootImpl.DISPATCH_KEY_FROM_IME,
                        event));
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1507595742 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2141216764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2141216764;
        // ---------- Original Method ----------
        //synchronized (mIMM.mH) {
            //Handler h = mTargetView != null ? mTargetView.getHandler() : null;
            //if (h == null) {
                //if (mIMM.mServedView != null) {
                    //h = mIMM.mServedView.getHandler();
                //}
            //}
            //if (h != null) {
                //h.sendMessage(h.obtainMessage(ViewRootImpl.DISPATCH_KEY_FROM_IME,
                        //event));
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.252 -0400", hash_original_method = "FA18FCA0F08D3E4AC2B0D49617508B22", hash_generated_method = "0AE456B6622128A5F9C06E536379A0F9")
    public boolean reportFullscreenMode(boolean enabled) {
        addTaint(enabled);
        mIMM.setFullscreenMode(enabled);
        boolean varB326B5062B2F0E69046810717534CB09_907328874 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1520459963 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1520459963;
        // ---------- Original Method ----------
        //mIMM.setFullscreenMode(enabled);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.252 -0400", hash_original_method = "BDE0428D54DBC47996CEC1E4604D5DEE", hash_generated_method = "2CC7DECE65CEF9B9F8DD90BD0E709500")
    private void sendCurrentText() {
        if(!mDummyMode)        
        {
            return;
        } //End block
        Editable content = getEditable();
        if(content != null)        
        {
            final int N = content.length();
            if(N == 0)            
            {
                return;
            } //End block
            if(N == 1)            
            {
                if(mKeyCharacterMap == null)                
                {
                    mKeyCharacterMap = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
                } //End block
                char[] chars = new char[1];
                content.getChars(0, 1, chars, 0);
                KeyEvent[] events = mKeyCharacterMap.getEvents(chars);
                if(events != null)                
                {
for(int i=0;i<events.length;i++)
                    {
                        if(DEBUG){ }                        sendKeyEvent(events[i]);
                    } //End block
                    content.clear();
                    return;
                } //End block
            } //End block
            KeyEvent event = new KeyEvent(SystemClock.uptimeMillis(),
                    content.toString(), KeyCharacterMap.VIRTUAL_KEYBOARD, 0);
            sendKeyEvent(event);
            content.clear();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.252 -0400", hash_original_method = "30261E28269E8D45DD173790F761946A", hash_generated_method = "248D883F22823C68A57D8063BAB7D88B")
    private void ensureDefaultComposingSpans() {
        if(mDefaultComposingSpans == null)        
        {
            Context context;
            if(mTargetView != null)            
            {
                context = mTargetView.getContext();
            } //End block
            else
            if(mIMM.mServedView != null)            
            {
                context = mIMM.mServedView.getContext();
            } //End block
            else
            {
                context = null;
            } //End block
            if(context != null)            
            {
                TypedArray ta = context.getTheme()
                        .obtainStyledAttributes(new int[] {
                                com.android.internal.R.attr.candidatesTextStyleSpans
                        });
                CharSequence style = ta.getText(0);
                ta.recycle();
                if(style != null && style instanceof Spanned)                
                {
                    mDefaultComposingSpans = ((Spanned)style).getSpans(
                            0, style.length(), Object.class);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.253 -0400", hash_original_method = "A9689D9BE329300E95AF0BB78D1B0A9D", hash_generated_method = "93444BA3A648A139330CFE8497B05AB9")
    private void replaceText(CharSequence text, int newCursorPosition,
            boolean composing) {
        addTaint(composing);
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        final Editable content = getEditable();
        if(content == null)        
        {
            return;
        } //End block
        beginBatchEdit();
        int a = getComposingSpanStart(content);
        int b = getComposingSpanEnd(content);
        if(DEBUG){ }        if(b < a)        
        {
            int tmp = a;
            a = b;
            b = tmp;
        } //End block
        if(a != -1 && b != -1)        
        {
            removeComposingSpans(content);
        } //End block
        else
        {
            a = Selection.getSelectionStart(content);
            b = Selection.getSelectionEnd(content);
            if(a < 0)            
            a = 0;
            if(b < 0)            
            b = 0;
            if(b < a)            
            {
                int tmp = a;
                a = b;
                b = tmp;
            } //End block
        } //End block
        if(composing)        
        {
            Spannable sp = null;
            if(!(text instanceof Spannable))            
            {
                sp = new SpannableStringBuilder(text);
                text = sp;
                ensureDefaultComposingSpans();
                if(mDefaultComposingSpans != null)                
                {
for(int i = 0;i < mDefaultComposingSpans.length;++i)
                    {
                        sp.setSpan(mDefaultComposingSpans[i], 0, sp.length(),
                                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE | Spanned.SPAN_COMPOSING);
                    } //End block
                } //End block
            } //End block
            else
            {
                sp = (Spannable)text;
            } //End block
            setComposingSpans(sp);
        } //End block
        if(DEBUG){ }        if(DEBUG)        
        {
            LogPrinter lp = new LogPrinter(Log.VERBOSE, TAG);
            lp.println("Current text:");
            TextUtils.dumpSpans(content, lp, "  ");
            lp.println("Composing text:");
            TextUtils.dumpSpans(text, lp, "  ");
        } //End block
        if(newCursorPosition > 0)        
        {
            newCursorPosition += b - 1;
        } //End block
        else
        {
            newCursorPosition += a;
        } //End block
        if(newCursorPosition < 0)        
        newCursorPosition = 0;
        if(newCursorPosition > content.length())        
        newCursorPosition = content.length();
        Selection.setSelection(content, newCursorPosition);
        content.replace(a, b, text);
        if(DEBUG)        
        {
            LogPrinter lp = new LogPrinter(Log.VERBOSE, TAG);
            lp.println("Final text:");
            TextUtils.dumpSpans(content, lp, "  ");
        } //End block
        endBatchEdit();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.253 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.253 -0400", hash_original_field = "BAA57012083A507882C8ACD4608B3E53", hash_generated_field = "53A6B0F8E8ED4C9CDAAB0EB974BB44EF")

    private static final String TAG = "BaseInputConnection";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.254 -0400", hash_original_field = "6A146B7CB527A9187E4E6A97BD4E3C80", hash_generated_field = "8705A035FE559B3B54E215D6480E2AFA")

    static final Object COMPOSING = new ComposingText();
}

