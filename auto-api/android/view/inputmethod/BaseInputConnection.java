package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.984 -0400", hash_original_method = "299AC39680AC1BE3A17612B5D7B1D330", hash_generated_method = "299AC39680AC1BE3A17612B5D7B1D330")
    public ComposingText ()
    {
        //Synthesized constructor
    }


}

public class BaseInputConnection implements InputConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.994 -0400", hash_original_field = "14E624678D0167A1D4F7B9DAF4BB3911", hash_generated_field = "141F0EFC0D8976518F576600E5590698")

    protected InputMethodManager mIMM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.994 -0400", hash_original_field = "4FDD02795CD9F6B3D3D1A34A14720073", hash_generated_field = "97ACD18EF4B48BDC424981A4C6E55C66")

    View mTargetView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.994 -0400", hash_original_field = "7A74C515F1C024E4A8A2C659CD63F25D", hash_generated_field = "B578BC86523A8ED06C11106F457EA3A1")

    boolean mDummyMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.994 -0400", hash_original_field = "DC2DB2F90A8C23F2FDC026A43D03668D", hash_generated_field = "252704B80FDD4D9B6E86ECF1CBD2B09A")

    private Object[] mDefaultComposingSpans;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.994 -0400", hash_original_field = "03FD58BE1D67B8547AADB1829EF91363", hash_generated_field = "BC747A06F00EC3CB73FDE2D30B84DC2D")

    Editable mEditable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.994 -0400", hash_original_field = "C7BC21409380B9440A2B406EA5A8934C", hash_generated_field = "5553093AC34FB198BC290668CD3A4BD4")

    KeyCharacterMap mKeyCharacterMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.995 -0400", hash_original_method = "1A943D99EC75638EA04879F1FF8F4BB3", hash_generated_method = "D904201E77FBD444E7EC22E5A2FA95EE")
      BaseInputConnection(InputMethodManager mgr, boolean fullEditor) {
        mIMM = mgr;
        mTargetView = null;
        mDummyMode = !fullEditor;
        // ---------- Original Method ----------
        //mIMM = mgr;
        //mTargetView = null;
        //mDummyMode = !fullEditor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.996 -0400", hash_original_method = "8D9F46A02734088C3A101A4C25C68420", hash_generated_method = "7E503C534998A7CE2443D4066DFB4BA4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.009 -0400", hash_original_method = "A97F5DFC2840DF7B5D61C809FDCD4D64", hash_generated_method = "7753DA3769771A87FF902C9F964D642E")
    public Editable getEditable() {
        Editable varB4EAC82CA7396A68D541C85D26508E83_1558531216 = null; //Variable for return #1
        {
            mEditable = Editable.Factory.getInstance().newEditable("");
            Selection.setSelection(mEditable, 0);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1558531216 = mEditable;
        varB4EAC82CA7396A68D541C85D26508E83_1558531216.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1558531216;
        // ---------- Original Method ----------
        //if (mEditable == null) {
            //mEditable = Editable.Factory.getInstance().newEditable("");
            //Selection.setSelection(mEditable, 0);
        //}
        //return mEditable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.010 -0400", hash_original_method = "E28DA299470AFBBB55E3F0E22CB4A567", hash_generated_method = "CFC2B061BFD168F2935CDD51253E6818")
    public boolean beginBatchEdit() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_658423957 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_658423957;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.010 -0400", hash_original_method = "68C20202F4C35ADB2F9CDE7850BF84CC", hash_generated_method = "B285A45F36FC0AA32EA036CD705CECAA")
    public boolean endBatchEdit() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138082464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_138082464;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.010 -0400", hash_original_method = "BC6513316EC80C5373FB6263D33C3F52", hash_generated_method = "F564899B0769086DF137A16FA1AC44B1")
    public boolean clearMetaKeyStates(int states) {
        Editable content;
        content = getEditable();
        MetaKeyKeyListener.clearMetaKeyState(content, states);
        addTaint(states);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_64638767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_64638767;
        // ---------- Original Method ----------
        //final Editable content = getEditable();
        //if (content == null) return false;
        //MetaKeyKeyListener.clearMetaKeyState(content, states);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.011 -0400", hash_original_method = "AA7244FCF81F32F7DEF3D51FAE032B7D", hash_generated_method = "C5AFADB9890F1F9E570BE1BA6F978891")
    public boolean commitCompletion(CompletionInfo text) {
        addTaint(text.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2097109178 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2097109178;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.011 -0400", hash_original_method = "8ECFF7D6DBED10855DA2C653047584D7", hash_generated_method = "BE6ED5E78B88E69FDB215B89F2D3B7B6")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        addTaint(correctionInfo.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_4809016 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_4809016;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.011 -0400", hash_original_method = "25125C99E3204B3B6C4C8BDE15E97EE8", hash_generated_method = "52FFB4FDE91D1310E0183149DA5C1116")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        replaceText(text, newCursorPosition, false);
        sendCurrentText();
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1555718188 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1555718188;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "commitText " + text);
        //replaceText(text, newCursorPosition, false);
        //sendCurrentText();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.029 -0400", hash_original_method = "74B12EE6F294A949F3B11979331384E6", hash_generated_method = "768A509043BCEC2528F7FF12DD698EBB")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        Editable content;
        content = getEditable();
        beginBatchEdit();
        int a;
        a = Selection.getSelectionStart(content);
        int b;
        b = Selection.getSelectionEnd(content);
        {
            int tmp;
            tmp = a;
            a = b;
            b = tmp;
        } //End block
        int ca;
        ca = getComposingSpanStart(content);
        int cb;
        cb = getComposingSpanEnd(content);
        {
            int tmp;
            tmp = ca;
            ca = cb;
            cb = tmp;
        } //End block
        {
            a = ca;
            b = cb;
        } //End block
        int deleted;
        deleted = 0;
        {
            int start;
            start = a - leftLength;
            start = 0;
            content.delete(start, a);
            deleted = a - start;
        } //End block
        {
            b = b - deleted;
            int end;
            end = b + rightLength;
            {
                boolean var1D97357640B2DA5E7AF46CBA2449F06C_411747758 = (end > content.length());
                end = content.length();
            } //End collapsed parenthetic
            content.delete(b, end);
        } //End block
        endBatchEdit();
        addTaint(leftLength);
        addTaint(rightLength);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_315687112 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_315687112;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.030 -0400", hash_original_method = "1CCB9955A4205D39AC8709BDCAB9AF4C", hash_generated_method = "F595A990B9E7ACA9EE8CE9329CC8E941")
    public boolean finishComposingText() {
        Editable content;
        content = getEditable();
        {
            beginBatchEdit();
            removeComposingSpans(content);
            endBatchEdit();
            sendCurrentText();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_617329597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_617329597;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.030 -0400", hash_original_method = "A12ABCD2EB4522E8FE53DB6299A361B5", hash_generated_method = "558D712DB6D8B66C00B78317F751FDD3")
    public int getCursorCapsMode(int reqModes) {
        Editable content;
        content = getEditable();
        int a;
        a = Selection.getSelectionStart(content);
        int b;
        b = Selection.getSelectionEnd(content);
        {
            int tmp;
            tmp = a;
            a = b;
            b = tmp;
        } //End block
        int var4FC7E907996324A6E769D9F7DF7B82C2_1877959686 = (TextUtils.getCapsMode(content, a, reqModes));
        addTaint(reqModes);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1077384459 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1077384459;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.031 -0400", hash_original_method = "A2A8D9B6A3DC6DA18051F8E023FD4A27", hash_generated_method = "62238C46BF28652DB2F1C2510948C4F8")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_1440712181 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1440712181 = null;
        addTaint(request.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1440712181.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1440712181;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.032 -0400", hash_original_method = "75E370B84589846A89A63AE625719BF1", hash_generated_method = "2F4A43FFABD5E53219AF03AFD660CF6A")
    public CharSequence getTextBeforeCursor(int length, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1920129201 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_535247450 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1547948241 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_446700379 = null; //Variable for return #4
        Editable content;
        content = getEditable();
        varB4EAC82CA7396A68D541C85D26508E83_1920129201 = null;
        int a;
        a = Selection.getSelectionStart(content);
        int b;
        b = Selection.getSelectionEnd(content);
        {
            int tmp;
            tmp = a;
            a = b;
            b = tmp;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_535247450 = "";
        } //End block
        {
            length = a;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1547948241 = content.subSequence(a - length, a);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_446700379 = TextUtils.substring(content, a - length, a);
        addTaint(length);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_1114939211; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1114939211 = varB4EAC82CA7396A68D541C85D26508E83_1920129201;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1114939211 = varB4EAC82CA7396A68D541C85D26508E83_535247450;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1114939211 = varB4EAC82CA7396A68D541C85D26508E83_1547948241;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1114939211 = varB4EAC82CA7396A68D541C85D26508E83_446700379;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1114939211.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1114939211;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.053 -0400", hash_original_method = "ED9D872BFDE8C5E26AC99155DBA149BF", hash_generated_method = "41504073E2CBE3275FDE5ED308F71DD1")
    public CharSequence getSelectedText(int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1099152619 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2108807247 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_182847422 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1793794654 = null; //Variable for return #4
        Editable content;
        content = getEditable();
        varB4EAC82CA7396A68D541C85D26508E83_1099152619 = null;
        int a;
        a = Selection.getSelectionStart(content);
        int b;
        b = Selection.getSelectionEnd(content);
        {
            int tmp;
            tmp = a;
            a = b;
            b = tmp;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2108807247 = null;
        {
            varB4EAC82CA7396A68D541C85D26508E83_182847422 = content.subSequence(a, b);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1793794654 = TextUtils.substring(content, a, b);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_1464288793; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1464288793 = varB4EAC82CA7396A68D541C85D26508E83_1099152619;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1464288793 = varB4EAC82CA7396A68D541C85D26508E83_2108807247;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1464288793 = varB4EAC82CA7396A68D541C85D26508E83_182847422;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1464288793 = varB4EAC82CA7396A68D541C85D26508E83_1793794654;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1464288793.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1464288793;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.054 -0400", hash_original_method = "08096EEE0873EB795CD58B469F10D5B2", hash_generated_method = "B76F4E3D4BFA8D3F844AD065AB82B0CA")
    public CharSequence getTextAfterCursor(int length, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_228960447 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2091177720 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1281421233 = null; //Variable for return #3
        Editable content;
        content = getEditable();
        varB4EAC82CA7396A68D541C85D26508E83_228960447 = null;
        int a;
        a = Selection.getSelectionStart(content);
        int b;
        b = Selection.getSelectionEnd(content);
        {
            int tmp;
            tmp = a;
            a = b;
            b = tmp;
        } //End block
        {
            b = 0;
        } //End block
        {
            boolean var7ECC0DB8B673AA466FD8BC7FC09E2D15_1325370534 = (b + length > content.length());
            {
                length = content.length() - b;
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_2091177720 = content.subSequence(b, b + length);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1281421233 = TextUtils.substring(content, b, b + length);
        addTaint(length);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_922459451; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_922459451 = varB4EAC82CA7396A68D541C85D26508E83_228960447;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_922459451 = varB4EAC82CA7396A68D541C85D26508E83_2091177720;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_922459451 = varB4EAC82CA7396A68D541C85D26508E83_1281421233;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_922459451.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_922459451;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.055 -0400", hash_original_method = "F533043312AA12AABEB855D393677CB5", hash_generated_method = "51768625B36D92E8F94709D5982516F5")
    public boolean performEditorAction(int actionCode) {
        long eventTime;
        eventTime = SystemClock.uptimeMillis();
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
        addTaint(actionCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_373553306 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_373553306;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.056 -0400", hash_original_method = "CC9943DA76C04BDA8199AB8562F111EF", hash_generated_method = "5C0972B408076B867A8292BA13A0C4D1")
    public boolean performContextMenuAction(int id) {
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213113695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213113695;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.056 -0400", hash_original_method = "E554B360562612AFCC9A87837C58FB1E", hash_generated_method = "0485EC25E0E6301281A5144B012F7E87")
    public boolean performPrivateCommand(String action, Bundle data) {
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_756006088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_756006088;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.056 -0400", hash_original_method = "9F64937BB19F72531BAD6E029A24112C", hash_generated_method = "433C67C9E6DA22B7EE671874AC0DF27C")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        replaceText(text, newCursorPosition, true);
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913848043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913848043;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "setComposingText " + text);
        //replaceText(text, newCursorPosition, true);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.073 -0400", hash_original_method = "683D72CF1BBC9E7A391F140A2B9406BC", hash_generated_method = "B20394EE510232CCEA379EAFC54547DE")
    public boolean setComposingRegion(int start, int end) {
        Editable content;
        content = getEditable();
        {
            beginBatchEdit();
            removeComposingSpans(content);
            int a;
            a = start;
            int b;
            b = end;
            {
                int tmp;
                tmp = a;
                a = b;
                b = tmp;
            } //End block
            int length;
            length = content.length();
            a = 0;
            b = 0;
            a = length;
            b = length;
            ensureDefaultComposingSpans();
            {
                {
                    int i;
                    i = 0;
                    {
                        content.setSpan(mDefaultComposingSpans[i], a, b,
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE | Spanned.SPAN_COMPOSING);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            content.setSpan(COMPOSING, a, b,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE | Spanned.SPAN_COMPOSING);
            endBatchEdit();
            sendCurrentText();
        } //End block
        addTaint(start);
        addTaint(end);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1525587489 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1525587489;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.073 -0400", hash_original_method = "06BE1F921CCFEC5EE49CD2FF18114BBC", hash_generated_method = "7136015DDE5870790C648D4CAD48D1CC")
    public boolean setSelection(int start, int end) {
        Editable content;
        content = getEditable();
        int len;
        len = content.length();
        {
            boolean varA1F7AC2D1C7D9F96E09A09209C846F35_739847864 = (start == end && MetaKeyKeyListener.getMetaState(content,
                MetaKeyKeyListener.META_SELECTING) != 0);
            {
                Selection.extendSelection(content, start);
            } //End block
            {
                Selection.setSelection(content, start, end);
            } //End block
        } //End collapsed parenthetic
        addTaint(start);
        addTaint(end);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_939174592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_939174592;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.074 -0400", hash_original_method = "F539697840E1FFDBA9E983D0C0D8D0DD", hash_generated_method = "257B60F7D2EE6DA939718BD89C2BC71E")
    public boolean sendKeyEvent(KeyEvent event) {
        {
            Handler h;
            h = mTargetView.getHandler();
            h = null;
            {
                {
                    h = mIMM.mServedView.getHandler();
                } //End block
            } //End block
            {
                h.sendMessage(h.obtainMessage(ViewRootImpl.DISPATCH_KEY_FROM_IME,
                        event));
            } //End block
        } //End block
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107719865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107719865;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.081 -0400", hash_original_method = "FA18FCA0F08D3E4AC2B0D49617508B22", hash_generated_method = "A58B209E5F081E818060BE84E45DC0F3")
    public boolean reportFullscreenMode(boolean enabled) {
        mIMM.setFullscreenMode(enabled);
        addTaint(enabled);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1067609140 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1067609140;
        // ---------- Original Method ----------
        //mIMM.setFullscreenMode(enabled);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.086 -0400", hash_original_method = "BDE0428D54DBC47996CEC1E4604D5DEE", hash_generated_method = "300CCF1D880232974841D88E60902B91")
    private void sendCurrentText() {
        Editable content;
        content = getEditable();
        {
            int N;
            N = content.length();
            {
                {
                    mKeyCharacterMap = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
                } //End block
                char[] chars;
                chars = new char[1];
                content.getChars(0, 1, chars, 0);
                KeyEvent[] events;
                events = mKeyCharacterMap.getEvents(chars);
                {
                    {
                        int i;
                        i = 0;
                        {
                            sendKeyEvent(events[i]);
                        } //End block
                    } //End collapsed parenthetic
                    content.clear();
                } //End block
            } //End block
            KeyEvent event;
            event = new KeyEvent(SystemClock.uptimeMillis(),
                    content.toString(), KeyCharacterMap.VIRTUAL_KEYBOARD, 0);
            sendKeyEvent(event);
            content.clear();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.087 -0400", hash_original_method = "30261E28269E8D45DD173790F761946A", hash_generated_method = "63E65ECC238DC7754FBC19F734575036")
    private void ensureDefaultComposingSpans() {
        {
            Context context;
            {
                context = mTargetView.getContext();
            } //End block
            {
                context = mIMM.mServedView.getContext();
            } //End block
            {
                context = null;
            } //End block
            {
                TypedArray ta;
                ta = context.getTheme()
                        .obtainStyledAttributes(new int[] {
                                com.android.internal.R.attr.candidatesTextStyleSpans
                        });
                CharSequence style;
                style = ta.getText(0);
                ta.recycle();
                {
                    mDefaultComposingSpans = ((Spanned)style).getSpans(
                            0, style.length(), Object.class);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.101 -0400", hash_original_method = "A9689D9BE329300E95AF0BB78D1B0A9D", hash_generated_method = "9BC6660EB6FEEC437C0B7408B25F101E")
    private void replaceText(CharSequence text, int newCursorPosition,
            boolean composing) {
        Editable content;
        content = getEditable();
        beginBatchEdit();
        int a;
        a = getComposingSpanStart(content);
        int b;
        b = getComposingSpanEnd(content);
        {
            int tmp;
            tmp = a;
            a = b;
            b = tmp;
        } //End block
        {
            removeComposingSpans(content);
        } //End block
        {
            a = Selection.getSelectionStart(content);
            b = Selection.getSelectionEnd(content);
            a = 0;
            b = 0;
            {
                int tmp;
                tmp = a;
                a = b;
                b = tmp;
            } //End block
        } //End block
        {
            Spannable sp;
            sp = null;
            {
                sp = new SpannableStringBuilder(text);
                text = sp;
                ensureDefaultComposingSpans();
                {
                    {
                        int i;
                        i = 0;
                        {
                            sp.setSpan(mDefaultComposingSpans[i], 0, sp.length(),
                                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE | Spanned.SPAN_COMPOSING);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                sp = (Spannable)text;
            } //End block
            setComposingSpans(sp);
        } //End block
        {
            LogPrinter lp;
            lp = new LogPrinter(Log.VERBOSE, TAG);
            lp.println("Current text:");
            TextUtils.dumpSpans(content, lp, "  ");
            lp.println("Composing text:");
            TextUtils.dumpSpans(text, lp, "  ");
        } //End block
        {
            newCursorPosition += b - 1;
        } //End block
        {
            newCursorPosition += a;
        } //End block
        newCursorPosition = 0;
        {
            boolean var1E349D85B106544D1972E08C42A1AAA3_99885911 = (newCursorPosition > content.length());
            newCursorPosition = content.length();
        } //End collapsed parenthetic
        Selection.setSelection(content, newCursorPosition);
        content.replace(a, b, text);
        {
            LogPrinter lp;
            lp = new LogPrinter(Log.VERBOSE, TAG);
            lp.println("Final text:");
            TextUtils.dumpSpans(content, lp, "  ");
        } //End block
        endBatchEdit();
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        addTaint(composing);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.102 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.102 -0400", hash_original_field = "BAA57012083A507882C8ACD4608B3E53", hash_generated_field = "6C7B4ECE4A75446B54A8C008C249E2DB")

    private static String TAG = "BaseInputConnection";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.102 -0400", hash_original_field = "6A146B7CB527A9187E4E6A97BD4E3C80", hash_generated_field = "C62A98D0BEE930C51B3B0D280544348C")

    static Object COMPOSING = new ComposingText();
}

