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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.928 -0400", hash_original_method = "299AC39680AC1BE3A17612B5D7B1D330", hash_generated_method = "299AC39680AC1BE3A17612B5D7B1D330")
    public ComposingText ()
    {
        //Synthesized constructor
    }


}

public class BaseInputConnection implements InputConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.929 -0400", hash_original_field = "14E624678D0167A1D4F7B9DAF4BB3911", hash_generated_field = "141F0EFC0D8976518F576600E5590698")

    protected InputMethodManager mIMM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.929 -0400", hash_original_field = "4FDD02795CD9F6B3D3D1A34A14720073", hash_generated_field = "97ACD18EF4B48BDC424981A4C6E55C66")

    View mTargetView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.929 -0400", hash_original_field = "7A74C515F1C024E4A8A2C659CD63F25D", hash_generated_field = "B578BC86523A8ED06C11106F457EA3A1")

    boolean mDummyMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.929 -0400", hash_original_field = "DC2DB2F90A8C23F2FDC026A43D03668D", hash_generated_field = "252704B80FDD4D9B6E86ECF1CBD2B09A")

    private Object[] mDefaultComposingSpans;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.929 -0400", hash_original_field = "03FD58BE1D67B8547AADB1829EF91363", hash_generated_field = "BC747A06F00EC3CB73FDE2D30B84DC2D")

    Editable mEditable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.929 -0400", hash_original_field = "C7BC21409380B9440A2B406EA5A8934C", hash_generated_field = "5553093AC34FB198BC290668CD3A4BD4")

    KeyCharacterMap mKeyCharacterMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.937 -0400", hash_original_method = "1A943D99EC75638EA04879F1FF8F4BB3", hash_generated_method = "D904201E77FBD444E7EC22E5A2FA95EE")
      BaseInputConnection(InputMethodManager mgr, boolean fullEditor) {
        mIMM = mgr;
        mTargetView = null;
        mDummyMode = !fullEditor;
        // ---------- Original Method ----------
        //mIMM = mgr;
        //mTargetView = null;
        //mDummyMode = !fullEditor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.938 -0400", hash_original_method = "8D9F46A02734088C3A101A4C25C68420", hash_generated_method = "7E503C534998A7CE2443D4066DFB4BA4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.940 -0400", hash_original_method = "A97F5DFC2840DF7B5D61C809FDCD4D64", hash_generated_method = "524F37BD386DBD7DC0C10957C6603B2D")
    public Editable getEditable() {
        Editable varB4EAC82CA7396A68D541C85D26508E83_1279569950 = null; //Variable for return #1
        {
            mEditable = Editable.Factory.getInstance().newEditable("");
            Selection.setSelection(mEditable, 0);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1279569950 = mEditable;
        varB4EAC82CA7396A68D541C85D26508E83_1279569950.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1279569950;
        // ---------- Original Method ----------
        //if (mEditable == null) {
            //mEditable = Editable.Factory.getInstance().newEditable("");
            //Selection.setSelection(mEditable, 0);
        //}
        //return mEditable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.940 -0400", hash_original_method = "E28DA299470AFBBB55E3F0E22CB4A567", hash_generated_method = "7DEF46131838EC0D89FD2469A6ED9FC3")
    public boolean beginBatchEdit() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1339562666 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1339562666;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.941 -0400", hash_original_method = "68C20202F4C35ADB2F9CDE7850BF84CC", hash_generated_method = "707B753BDC91B570FBE928923FE265B1")
    public boolean endBatchEdit() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1299933002 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1299933002;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.941 -0400", hash_original_method = "BC6513316EC80C5373FB6263D33C3F52", hash_generated_method = "1445FE3C86298D7E485437CBBA68AABC")
    public boolean clearMetaKeyStates(int states) {
        Editable content;
        content = getEditable();
        MetaKeyKeyListener.clearMetaKeyState(content, states);
        addTaint(states);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1885548054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1885548054;
        // ---------- Original Method ----------
        //final Editable content = getEditable();
        //if (content == null) return false;
        //MetaKeyKeyListener.clearMetaKeyState(content, states);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.941 -0400", hash_original_method = "AA7244FCF81F32F7DEF3D51FAE032B7D", hash_generated_method = "FE068266CF22A9F2AA2338B4910F37FA")
    public boolean commitCompletion(CompletionInfo text) {
        addTaint(text.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1590272345 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1590272345;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.942 -0400", hash_original_method = "8ECFF7D6DBED10855DA2C653047584D7", hash_generated_method = "4E0B7D376E12B38F33E1D5B25A6D05F9")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        addTaint(correctionInfo.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467480404 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467480404;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.956 -0400", hash_original_method = "25125C99E3204B3B6C4C8BDE15E97EE8", hash_generated_method = "2A2DD31200E3A58C6229924898069939")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        replaceText(text, newCursorPosition, false);
        sendCurrentText();
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_909324777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_909324777;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "commitText " + text);
        //replaceText(text, newCursorPosition, false);
        //sendCurrentText();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.957 -0400", hash_original_method = "74B12EE6F294A949F3B11979331384E6", hash_generated_method = "86DCD36127376A504A24176AAE285585")
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
                boolean var1D97357640B2DA5E7AF46CBA2449F06C_1158649342 = (end > content.length());
                end = content.length();
            } //End collapsed parenthetic
            content.delete(b, end);
        } //End block
        endBatchEdit();
        addTaint(leftLength);
        addTaint(rightLength);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1664951044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1664951044;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.958 -0400", hash_original_method = "1CCB9955A4205D39AC8709BDCAB9AF4C", hash_generated_method = "CA4F13DD8560EF8BB8C2AD37AFED2BBE")
    public boolean finishComposingText() {
        Editable content;
        content = getEditable();
        {
            beginBatchEdit();
            removeComposingSpans(content);
            endBatchEdit();
            sendCurrentText();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1558098499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1558098499;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.958 -0400", hash_original_method = "A12ABCD2EB4522E8FE53DB6299A361B5", hash_generated_method = "4E053BFF7FFBA6FE958303890D7ED1C0")
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
        int var4FC7E907996324A6E769D9F7DF7B82C2_1650057011 = (TextUtils.getCapsMode(content, a, reqModes));
        addTaint(reqModes);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_755632390 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_755632390;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.958 -0400", hash_original_method = "A2A8D9B6A3DC6DA18051F8E023FD4A27", hash_generated_method = "1EB51D1AB7E5FB488AB81C7B439D3B6D")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_1521639384 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1521639384 = null;
        addTaint(request.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1521639384.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1521639384;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.959 -0400", hash_original_method = "75E370B84589846A89A63AE625719BF1", hash_generated_method = "9C2806E600209FFC1FD701422701198B")
    public CharSequence getTextBeforeCursor(int length, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_500925356 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1724568107 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_914476889 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1220702727 = null; //Variable for return #4
        Editable content;
        content = getEditable();
        varB4EAC82CA7396A68D541C85D26508E83_500925356 = null;
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
            varB4EAC82CA7396A68D541C85D26508E83_1724568107 = "";
        } //End block
        {
            length = a;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_914476889 = content.subSequence(a - length, a);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1220702727 = TextUtils.substring(content, a - length, a);
        addTaint(length);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_1818044009; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1818044009 = varB4EAC82CA7396A68D541C85D26508E83_500925356;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1818044009 = varB4EAC82CA7396A68D541C85D26508E83_1724568107;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1818044009 = varB4EAC82CA7396A68D541C85D26508E83_914476889;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1818044009 = varB4EAC82CA7396A68D541C85D26508E83_1220702727;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1818044009.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1818044009;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.979 -0400", hash_original_method = "ED9D872BFDE8C5E26AC99155DBA149BF", hash_generated_method = "54F6BB253D0F1FC4FD5B2B75E8577AB0")
    public CharSequence getSelectedText(int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1364604219 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1466662981 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1392722766 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_62469319 = null; //Variable for return #4
        Editable content;
        content = getEditable();
        varB4EAC82CA7396A68D541C85D26508E83_1364604219 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_1466662981 = null;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1392722766 = content.subSequence(a, b);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_62469319 = TextUtils.substring(content, a, b);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_1426949380; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1426949380 = varB4EAC82CA7396A68D541C85D26508E83_1364604219;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1426949380 = varB4EAC82CA7396A68D541C85D26508E83_1466662981;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1426949380 = varB4EAC82CA7396A68D541C85D26508E83_1392722766;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1426949380 = varB4EAC82CA7396A68D541C85D26508E83_62469319;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1426949380.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1426949380;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.989 -0400", hash_original_method = "08096EEE0873EB795CD58B469F10D5B2", hash_generated_method = "B68EDDAA96CBAF748459C19C3BEEFE78")
    public CharSequence getTextAfterCursor(int length, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_774067843 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_35404883 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1506348316 = null; //Variable for return #3
        Editable content;
        content = getEditable();
        varB4EAC82CA7396A68D541C85D26508E83_774067843 = null;
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
            boolean var7ECC0DB8B673AA466FD8BC7FC09E2D15_677069448 = (b + length > content.length());
            {
                length = content.length() - b;
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_35404883 = content.subSequence(b, b + length);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1506348316 = TextUtils.substring(content, b, b + length);
        addTaint(length);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_1084676322; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1084676322 = varB4EAC82CA7396A68D541C85D26508E83_774067843;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1084676322 = varB4EAC82CA7396A68D541C85D26508E83_35404883;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1084676322 = varB4EAC82CA7396A68D541C85D26508E83_1506348316;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1084676322.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1084676322;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.002 -0400", hash_original_method = "F533043312AA12AABEB855D393677CB5", hash_generated_method = "F6CBF0529E378CE9EC5BE664118133BA")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_137297935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_137297935;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.014 -0400", hash_original_method = "CC9943DA76C04BDA8199AB8562F111EF", hash_generated_method = "1B94AAABFA9B2FC690D4FFAD7D78B0C3")
    public boolean performContextMenuAction(int id) {
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1847724858 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1847724858;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.014 -0400", hash_original_method = "E554B360562612AFCC9A87837C58FB1E", hash_generated_method = "892390CBCBC9984938CC93FC41720F09")
    public boolean performPrivateCommand(String action, Bundle data) {
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_377171277 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_377171277;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.014 -0400", hash_original_method = "9F64937BB19F72531BAD6E029A24112C", hash_generated_method = "E28BC129AF15A69AB9A8FA181CBA458D")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        replaceText(text, newCursorPosition, true);
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_556876086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_556876086;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "setComposingText " + text);
        //replaceText(text, newCursorPosition, true);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.015 -0400", hash_original_method = "683D72CF1BBC9E7A391F140A2B9406BC", hash_generated_method = "BF8BFAAF537049FC9ED02425A3DF3F26")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_851980286 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_851980286;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.016 -0400", hash_original_method = "06BE1F921CCFEC5EE49CD2FF18114BBC", hash_generated_method = "7CE0918D9FB7816F27B4FE688C27B4B1")
    public boolean setSelection(int start, int end) {
        Editable content;
        content = getEditable();
        int len;
        len = content.length();
        {
            boolean varA1F7AC2D1C7D9F96E09A09209C846F35_2060780694 = (start == end && MetaKeyKeyListener.getMetaState(content,
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1210603181 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1210603181;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.016 -0400", hash_original_method = "F539697840E1FFDBA9E983D0C0D8D0DD", hash_generated_method = "57E5532E4A5EEAAE5C3A99D0CB5A95AC")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_693554335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_693554335;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.017 -0400", hash_original_method = "FA18FCA0F08D3E4AC2B0D49617508B22", hash_generated_method = "71BF5FACE11EE5D3491CD8961178B4B9")
    public boolean reportFullscreenMode(boolean enabled) {
        mIMM.setFullscreenMode(enabled);
        addTaint(enabled);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1292407779 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1292407779;
        // ---------- Original Method ----------
        //mIMM.setFullscreenMode(enabled);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.030 -0400", hash_original_method = "BDE0428D54DBC47996CEC1E4604D5DEE", hash_generated_method = "300CCF1D880232974841D88E60902B91")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.032 -0400", hash_original_method = "30261E28269E8D45DD173790F761946A", hash_generated_method = "63E65ECC238DC7754FBC19F734575036")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.034 -0400", hash_original_method = "A9689D9BE329300E95AF0BB78D1B0A9D", hash_generated_method = "F53357DCFF724EAD6E925EAA9CC10F5A")
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
            boolean var1E349D85B106544D1972E08C42A1AAA3_874119460 = (newCursorPosition > content.length());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.034 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.034 -0400", hash_original_field = "BAA57012083A507882C8ACD4608B3E53", hash_generated_field = "6C7B4ECE4A75446B54A8C008C249E2DB")

    private static String TAG = "BaseInputConnection";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.034 -0400", hash_original_field = "6A146B7CB527A9187E4E6A97BD4E3C80", hash_generated_field = "C62A98D0BEE930C51B3B0D280544348C")

    static Object COMPOSING = new ComposingText();
}

