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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.872 -0400", hash_original_method = "299AC39680AC1BE3A17612B5D7B1D330", hash_generated_method = "299AC39680AC1BE3A17612B5D7B1D330")
    public ComposingText ()
    {
        //Synthesized constructor
    }


}

public class BaseInputConnection implements InputConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.872 -0400", hash_original_field = "14E624678D0167A1D4F7B9DAF4BB3911", hash_generated_field = "141F0EFC0D8976518F576600E5590698")

    protected InputMethodManager mIMM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.872 -0400", hash_original_field = "4FDD02795CD9F6B3D3D1A34A14720073", hash_generated_field = "97ACD18EF4B48BDC424981A4C6E55C66")

    View mTargetView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.872 -0400", hash_original_field = "7A74C515F1C024E4A8A2C659CD63F25D", hash_generated_field = "B578BC86523A8ED06C11106F457EA3A1")

    boolean mDummyMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.872 -0400", hash_original_field = "DC2DB2F90A8C23F2FDC026A43D03668D", hash_generated_field = "252704B80FDD4D9B6E86ECF1CBD2B09A")

    private Object[] mDefaultComposingSpans;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.872 -0400", hash_original_field = "03FD58BE1D67B8547AADB1829EF91363", hash_generated_field = "BC747A06F00EC3CB73FDE2D30B84DC2D")

    Editable mEditable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.872 -0400", hash_original_field = "C7BC21409380B9440A2B406EA5A8934C", hash_generated_field = "5553093AC34FB198BC290668CD3A4BD4")

    KeyCharacterMap mKeyCharacterMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.872 -0400", hash_original_method = "1A943D99EC75638EA04879F1FF8F4BB3", hash_generated_method = "D904201E77FBD444E7EC22E5A2FA95EE")
      BaseInputConnection(InputMethodManager mgr, boolean fullEditor) {
        mIMM = mgr;
        mTargetView = null;
        mDummyMode = !fullEditor;
        // ---------- Original Method ----------
        //mIMM = mgr;
        //mTargetView = null;
        //mDummyMode = !fullEditor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.873 -0400", hash_original_method = "8D9F46A02734088C3A101A4C25C68420", hash_generated_method = "7E503C534998A7CE2443D4066DFB4BA4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.874 -0400", hash_original_method = "A97F5DFC2840DF7B5D61C809FDCD4D64", hash_generated_method = "D25F916CCDA3333AF3D579CC0CC7B8F3")
    public Editable getEditable() {
        Editable varB4EAC82CA7396A68D541C85D26508E83_1123391365 = null; //Variable for return #1
        {
            mEditable = Editable.Factory.getInstance().newEditable("");
            Selection.setSelection(mEditable, 0);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1123391365 = mEditable;
        varB4EAC82CA7396A68D541C85D26508E83_1123391365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1123391365;
        // ---------- Original Method ----------
        //if (mEditable == null) {
            //mEditable = Editable.Factory.getInstance().newEditable("");
            //Selection.setSelection(mEditable, 0);
        //}
        //return mEditable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.874 -0400", hash_original_method = "E28DA299470AFBBB55E3F0E22CB4A567", hash_generated_method = "765412AD71D84E73F044AF0ABF657988")
    public boolean beginBatchEdit() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1392679672 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1392679672;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.874 -0400", hash_original_method = "68C20202F4C35ADB2F9CDE7850BF84CC", hash_generated_method = "C2272EEDCDEAAB96F13FBD4F475D5C14")
    public boolean endBatchEdit() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_449660029 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_449660029;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.875 -0400", hash_original_method = "BC6513316EC80C5373FB6263D33C3F52", hash_generated_method = "0991E55CD4DD3ED7E03B9144EBEC8523")
    public boolean clearMetaKeyStates(int states) {
        final Editable content = getEditable();
        MetaKeyKeyListener.clearMetaKeyState(content, states);
        addTaint(states);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_883012994 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_883012994;
        // ---------- Original Method ----------
        //final Editable content = getEditable();
        //if (content == null) return false;
        //MetaKeyKeyListener.clearMetaKeyState(content, states);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.876 -0400", hash_original_method = "AA7244FCF81F32F7DEF3D51FAE032B7D", hash_generated_method = "838B9CCC67D5C1F650EA2B1A7E73521A")
    public boolean commitCompletion(CompletionInfo text) {
        addTaint(text.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1598083188 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1598083188;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.876 -0400", hash_original_method = "8ECFF7D6DBED10855DA2C653047584D7", hash_generated_method = "1A03846C5842614BEE9A91CAAD79215F")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        addTaint(correctionInfo.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1043661116 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1043661116;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.876 -0400", hash_original_method = "25125C99E3204B3B6C4C8BDE15E97EE8", hash_generated_method = "391DA6BD6ECA1CE5626F74FFA359A344")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        replaceText(text, newCursorPosition, false);
        sendCurrentText();
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1206017593 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1206017593;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "commitText " + text);
        //replaceText(text, newCursorPosition, false);
        //sendCurrentText();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.877 -0400", hash_original_method = "74B12EE6F294A949F3B11979331384E6", hash_generated_method = "95C61A2079753E7E964D2F288F5A7B42")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        final Editable content = getEditable();
        beginBatchEdit();
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
        {
            int tmp = a;
            a = b;
            b = tmp;
        } //End block
        int ca = getComposingSpanStart(content);
        int cb = getComposingSpanEnd(content);
        {
            int tmp = ca;
            ca = cb;
            cb = tmp;
        } //End block
        {
            a = ca;
            b = cb;
        } //End block
        int deleted = 0;
        {
            int start = a - leftLength;
            start = 0;
            content.delete(start, a);
            deleted = a - start;
        } //End block
        {
            b = b - deleted;
            int end = b + rightLength;
            {
                boolean var1D97357640B2DA5E7AF46CBA2449F06C_1343169474 = (end > content.length());
                end = content.length();
            } //End collapsed parenthetic
            content.delete(b, end);
        } //End block
        endBatchEdit();
        addTaint(leftLength);
        addTaint(rightLength);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1461022041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1461022041;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.878 -0400", hash_original_method = "1CCB9955A4205D39AC8709BDCAB9AF4C", hash_generated_method = "D452B4DD09296C00F534F3251B65CDEA")
    public boolean finishComposingText() {
        final Editable content = getEditable();
        {
            beginBatchEdit();
            removeComposingSpans(content);
            endBatchEdit();
            sendCurrentText();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_184381039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_184381039;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.878 -0400", hash_original_method = "A12ABCD2EB4522E8FE53DB6299A361B5", hash_generated_method = "F4CE7ACACC4C25DA1AADA62BB413A53F")
    public int getCursorCapsMode(int reqModes) {
        final Editable content = getEditable();
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
        {
            int tmp = a;
            a = b;
            b = tmp;
        } //End block
        int var4FC7E907996324A6E769D9F7DF7B82C2_2004472721 = (TextUtils.getCapsMode(content, a, reqModes));
        addTaint(reqModes);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371579060 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371579060;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.879 -0400", hash_original_method = "A2A8D9B6A3DC6DA18051F8E023FD4A27", hash_generated_method = "4392F135681141EE18B3A33E14D4C6C8")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_448878800 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_448878800 = null;
        addTaint(request.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_448878800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_448878800;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.880 -0400", hash_original_method = "75E370B84589846A89A63AE625719BF1", hash_generated_method = "1E5A9402BB2FAB4DE6184F72CAADF39D")
    public CharSequence getTextBeforeCursor(int length, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1254734926 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1898142745 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1016620417 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1561673156 = null; //Variable for return #4
        final Editable content = getEditable();
        varB4EAC82CA7396A68D541C85D26508E83_1254734926 = null;
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
        {
            int tmp = a;
            a = b;
            b = tmp;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1898142745 = "";
        } //End block
        {
            length = a;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1016620417 = content.subSequence(a - length, a);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1561673156 = TextUtils.substring(content, a - length, a);
        addTaint(length);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_812388319; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_812388319 = varB4EAC82CA7396A68D541C85D26508E83_1254734926;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_812388319 = varB4EAC82CA7396A68D541C85D26508E83_1898142745;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_812388319 = varB4EAC82CA7396A68D541C85D26508E83_1016620417;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_812388319 = varB4EAC82CA7396A68D541C85D26508E83_1561673156;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_812388319.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_812388319;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.881 -0400", hash_original_method = "ED9D872BFDE8C5E26AC99155DBA149BF", hash_generated_method = "E76B267C7D1F088B129349169FD10158")
    public CharSequence getSelectedText(int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2073323561 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1540392289 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_892529405 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1979745559 = null; //Variable for return #4
        final Editable content = getEditable();
        varB4EAC82CA7396A68D541C85D26508E83_2073323561 = null;
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
        {
            int tmp = a;
            a = b;
            b = tmp;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1540392289 = null;
        {
            varB4EAC82CA7396A68D541C85D26508E83_892529405 = content.subSequence(a, b);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1979745559 = TextUtils.substring(content, a, b);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_1775682936; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1775682936 = varB4EAC82CA7396A68D541C85D26508E83_2073323561;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1775682936 = varB4EAC82CA7396A68D541C85D26508E83_1540392289;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1775682936 = varB4EAC82CA7396A68D541C85D26508E83_892529405;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1775682936 = varB4EAC82CA7396A68D541C85D26508E83_1979745559;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1775682936.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1775682936;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.881 -0400", hash_original_method = "08096EEE0873EB795CD58B469F10D5B2", hash_generated_method = "5742DEBB45223F21852B71EE5413BADA")
    public CharSequence getTextAfterCursor(int length, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1733123330 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_172246789 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_588201818 = null; //Variable for return #3
        final Editable content = getEditable();
        varB4EAC82CA7396A68D541C85D26508E83_1733123330 = null;
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
        {
            int tmp = a;
            a = b;
            b = tmp;
        } //End block
        {
            b = 0;
        } //End block
        {
            boolean var7ECC0DB8B673AA466FD8BC7FC09E2D15_1240030031 = (b + length > content.length());
            {
                length = content.length() - b;
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_172246789 = content.subSequence(b, b + length);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_588201818 = TextUtils.substring(content, b, b + length);
        addTaint(length);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_1536275023; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1536275023 = varB4EAC82CA7396A68D541C85D26508E83_1733123330;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1536275023 = varB4EAC82CA7396A68D541C85D26508E83_172246789;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1536275023 = varB4EAC82CA7396A68D541C85D26508E83_588201818;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1536275023.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1536275023;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.882 -0400", hash_original_method = "F533043312AA12AABEB855D393677CB5", hash_generated_method = "8058F25287CD0CE08CA6B2D02847BA30")
    public boolean performEditorAction(int actionCode) {
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
        addTaint(actionCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412621657 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412621657;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.882 -0400", hash_original_method = "CC9943DA76C04BDA8199AB8562F111EF", hash_generated_method = "4834E79706D98C737514C64F35630336")
    public boolean performContextMenuAction(int id) {
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25022026 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_25022026;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.883 -0400", hash_original_method = "E554B360562612AFCC9A87837C58FB1E", hash_generated_method = "AE60C859F18A44D2A7B1E8CB306BA6D2")
    public boolean performPrivateCommand(String action, Bundle data) {
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695339375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_695339375;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.883 -0400", hash_original_method = "9F64937BB19F72531BAD6E029A24112C", hash_generated_method = "B7A89C4A391AF748CBFF336370D613A2")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        replaceText(text, newCursorPosition, true);
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_468614114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_468614114;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "setComposingText " + text);
        //replaceText(text, newCursorPosition, true);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.884 -0400", hash_original_method = "683D72CF1BBC9E7A391F140A2B9406BC", hash_generated_method = "C61570752490EF0ABC0F50A63615D3B4")
    public boolean setComposingRegion(int start, int end) {
        final Editable content = getEditable();
        {
            beginBatchEdit();
            removeComposingSpans(content);
            int a = start;
            int b = end;
            {
                int tmp = a;
                a = b;
                b = tmp;
            } //End block
            final int length = content.length();
            a = 0;
            b = 0;
            a = length;
            b = length;
            ensureDefaultComposingSpans();
            {
                {
                    int i = 0;
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197198155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197198155;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.884 -0400", hash_original_method = "06BE1F921CCFEC5EE49CD2FF18114BBC", hash_generated_method = "2149373E929B9EC0799AAAC21A776051")
    public boolean setSelection(int start, int end) {
        final Editable content = getEditable();
        int len = content.length();
        {
            boolean varA1F7AC2D1C7D9F96E09A09209C846F35_1562170199 = (start == end && MetaKeyKeyListener.getMetaState(content,
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1920209201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1920209201;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.885 -0400", hash_original_method = "F539697840E1FFDBA9E983D0C0D8D0DD", hash_generated_method = "87050E003B07D556F5D183BF899A4CE6")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1620908070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1620908070;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.885 -0400", hash_original_method = "FA18FCA0F08D3E4AC2B0D49617508B22", hash_generated_method = "B1A3DA25303A9D2E6E88AF221E2762B1")
    public boolean reportFullscreenMode(boolean enabled) {
        mIMM.setFullscreenMode(enabled);
        addTaint(enabled);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_571505264 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_571505264;
        // ---------- Original Method ----------
        //mIMM.setFullscreenMode(enabled);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.886 -0400", hash_original_method = "BDE0428D54DBC47996CEC1E4604D5DEE", hash_generated_method = "DC403E6471326CC6BD8CC3D8284360CF")
    private void sendCurrentText() {
        Editable content = getEditable();
        {
            final int N = content.length();
            {
                {
                    mKeyCharacterMap = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
                } //End block
                char[] chars = new char[1];
                content.getChars(0, 1, chars, 0);
                KeyEvent[] events = mKeyCharacterMap.getEvents(chars);
                {
                    {
                        int i = 0;
                        {
                            sendKeyEvent(events[i]);
                        } //End block
                    } //End collapsed parenthetic
                    content.clear();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.887 -0400", hash_original_method = "30261E28269E8D45DD173790F761946A", hash_generated_method = "F7255AD76BD2D0642BF627CC6EEB9E0A")
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
                TypedArray ta = context.getTheme()
                        .obtainStyledAttributes(new int[] {
                                com.android.internal.R.attr.candidatesTextStyleSpans
                        });
                CharSequence style = ta.getText(0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.889 -0400", hash_original_method = "A9689D9BE329300E95AF0BB78D1B0A9D", hash_generated_method = "2F75BDC14D970F8EFB0E58C3099D6503")
    private void replaceText(CharSequence text, int newCursorPosition,
            boolean composing) {
        final Editable content = getEditable();
        beginBatchEdit();
        int a = getComposingSpanStart(content);
        int b = getComposingSpanEnd(content);
        {
            int tmp = a;
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
                int tmp = a;
                a = b;
                b = tmp;
            } //End block
        } //End block
        {
            Spannable sp = null;
            {
                sp = new SpannableStringBuilder(text);
                text = sp;
                ensureDefaultComposingSpans();
                {
                    {
                        int i = 0;
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
            LogPrinter lp = new LogPrinter(Log.VERBOSE, TAG);
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
            boolean var1E349D85B106544D1972E08C42A1AAA3_449821229 = (newCursorPosition > content.length());
            newCursorPosition = content.length();
        } //End collapsed parenthetic
        Selection.setSelection(content, newCursorPosition);
        content.replace(a, b, text);
        {
            LogPrinter lp = new LogPrinter(Log.VERBOSE, TAG);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.889 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.889 -0400", hash_original_field = "BAA57012083A507882C8ACD4608B3E53", hash_generated_field = "53A6B0F8E8ED4C9CDAAB0EB974BB44EF")

    private static final String TAG = "BaseInputConnection";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.889 -0400", hash_original_field = "6A146B7CB527A9187E4E6A97BD4E3C80", hash_generated_field = "8705A035FE559B3B54E215D6480E2AFA")

    static final Object COMPOSING = new ComposingText();
}

