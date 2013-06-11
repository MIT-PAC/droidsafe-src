package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    
}

public class BaseInputConnection implements InputConnection {
    private static final boolean DEBUG = false;
    private static final String TAG = "BaseInputConnection";
    static final Object COMPOSING = new ComposingText();
    protected final InputMethodManager mIMM;
    final View mTargetView;
    final boolean mDummyMode;
    private Object[] mDefaultComposingSpans;
    Editable mEditable;
    KeyCharacterMap mKeyCharacterMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.044 -0400", hash_original_method = "1A943D99EC75638EA04879F1FF8F4BB3", hash_generated_method = "0FD5A2CAD5B80323F7647394879B345B")
    @DSModeled(DSC.SAFE)
     BaseInputConnection(InputMethodManager mgr, boolean fullEditor) {
        dsTaint.addTaint(fullEditor);
        dsTaint.addTaint(mgr.dsTaint);
        mTargetView = null;
        mDummyMode = !fullEditor;
        // ---------- Original Method ----------
        //mIMM = mgr;
        //mTargetView = null;
        //mDummyMode = !fullEditor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.044 -0400", hash_original_method = "8D9F46A02734088C3A101A4C25C68420", hash_generated_method = "3661B727479100629E7D1E34B7F21B2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BaseInputConnection(View targetView, boolean fullEditor) {
        dsTaint.addTaint(targetView.dsTaint);
        dsTaint.addTaint(fullEditor);
        mIMM = (InputMethodManager)targetView.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        mDummyMode = !fullEditor;
        // ---------- Original Method ----------
        //mIMM = (InputMethodManager)targetView.getContext().getSystemService(
                //Context.INPUT_METHOD_SERVICE);
        //mTargetView = targetView;
        //mDummyMode = !fullEditor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.044 -0400", hash_original_method = "62C66E7D51985E873C93BC6EE5B2664E", hash_generated_method = "E27089B8FDBBB72B63EBBED497B30100")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.044 -0400", hash_original_method = "149B8DCE1DD4AF251EAA1316EAECD41B", hash_generated_method = "A22A4EEC36BB24573500BE9B042D8909")
    public static void setComposingSpans(Spannable text) {
        setComposingSpans(text, 0, text.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.044 -0400", hash_original_method = "56739913A56341656B894EC8F37C96AC", hash_generated_method = "C226A8F329451972B7ADC82661373BFD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.044 -0400", hash_original_method = "5FB16EEB4B23553D26A4F5C8F80AB33C", hash_generated_method = "96CF70701AA7C42D3F0E282A7C1DD24C")
    public static int getComposingSpanStart(Spannable text) {
        return text.getSpanStart(COMPOSING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.044 -0400", hash_original_method = "7902CE0D5E0A3F946465422AB1EC8829", hash_generated_method = "6DB0E84CAEC5FD9B7584F2C3300AD05D")
    public static int getComposingSpanEnd(Spannable text) {
        return text.getSpanEnd(COMPOSING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.045 -0400", hash_original_method = "A97F5DFC2840DF7B5D61C809FDCD4D64", hash_generated_method = "A850E1E77CD823F0B4FDB265BA531698")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Editable getEditable() {
        {
            mEditable = Editable.Factory.getInstance().newEditable("");
            Selection.setSelection(mEditable, 0);
        } //End block
        return (Editable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mEditable == null) {
            //mEditable = Editable.Factory.getInstance().newEditable("");
            //Selection.setSelection(mEditable, 0);
        //}
        //return mEditable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.045 -0400", hash_original_method = "E28DA299470AFBBB55E3F0E22CB4A567", hash_generated_method = "11FFF3049F061B10D65517BCDBC1307E")
    @DSModeled(DSC.SAFE)
    public boolean beginBatchEdit() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.045 -0400", hash_original_method = "68C20202F4C35ADB2F9CDE7850BF84CC", hash_generated_method = "59CF39A12CF3EDFCD28DB512AA03F040")
    @DSModeled(DSC.SAFE)
    public boolean endBatchEdit() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.045 -0400", hash_original_method = "BC6513316EC80C5373FB6263D33C3F52", hash_generated_method = "9BEB81F95757EB721CB5169AFE0E958F")
    @DSModeled(DSC.SAFE)
    public boolean clearMetaKeyStates(int states) {
        dsTaint.addTaint(states);
        final Editable content;
        content = getEditable();
        MetaKeyKeyListener.clearMetaKeyState(content, states);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Editable content = getEditable();
        //if (content == null) return false;
        //MetaKeyKeyListener.clearMetaKeyState(content, states);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.045 -0400", hash_original_method = "AA7244FCF81F32F7DEF3D51FAE032B7D", hash_generated_method = "E01E87CBD22CCDCAF48D1CE71EC5221B")
    @DSModeled(DSC.SAFE)
    public boolean commitCompletion(CompletionInfo text) {
        dsTaint.addTaint(text.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.045 -0400", hash_original_method = "8ECFF7D6DBED10855DA2C653047584D7", hash_generated_method = "67E3109A8B163FD42E1C637345E52D7D")
    @DSModeled(DSC.SAFE)
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        dsTaint.addTaint(correctionInfo.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.045 -0400", hash_original_method = "25125C99E3204B3B6C4C8BDE15E97EE8", hash_generated_method = "81F185F81754839227BD90F6CED4F031")
    @DSModeled(DSC.SAFE)
    public boolean commitText(CharSequence text, int newCursorPosition) {
        dsTaint.addTaint(newCursorPosition);
        dsTaint.addTaint(text);
        replaceText(text, newCursorPosition, false);
        sendCurrentText();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "commitText " + text);
        //replaceText(text, newCursorPosition, false);
        //sendCurrentText();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.045 -0400", hash_original_method = "74B12EE6F294A949F3B11979331384E6", hash_generated_method = "05BB78AD0CF5AF6014A72FE820C11918")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        dsTaint.addTaint(leftLength);
        dsTaint.addTaint(rightLength);
        final Editable content;
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
                boolean var1D97357640B2DA5E7AF46CBA2449F06C_433363802 = (end > content.length());
                end = content.length();
            } //End collapsed parenthetic
            content.delete(b, end);
        } //End block
        endBatchEdit();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.046 -0400", hash_original_method = "1CCB9955A4205D39AC8709BDCAB9AF4C", hash_generated_method = "6963DDACA4431B636D6FA654F1420484")
    @DSModeled(DSC.SAFE)
    public boolean finishComposingText() {
        final Editable content;
        content = getEditable();
        {
            beginBatchEdit();
            removeComposingSpans(content);
            endBatchEdit();
            sendCurrentText();
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.046 -0400", hash_original_method = "A12ABCD2EB4522E8FE53DB6299A361B5", hash_generated_method = "E683DD3D384127F7790B494525A19A6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCursorCapsMode(int reqModes) {
        dsTaint.addTaint(reqModes);
        final Editable content;
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
        int var4FC7E907996324A6E769D9F7DF7B82C2_745516364 = (TextUtils.getCapsMode(content, a, reqModes));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.046 -0400", hash_original_method = "A2A8D9B6A3DC6DA18051F8E023FD4A27", hash_generated_method = "9BC3322A0618B26631F119FA50BF5339")
    @DSModeled(DSC.SAFE)
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(request.dsTaint);
        return (ExtractedText)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.046 -0400", hash_original_method = "75E370B84589846A89A63AE625719BF1", hash_generated_method = "F19BDB5583BBF848D871DDF1ED911DBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getTextBeforeCursor(int length, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(length);
        final Editable content;
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
        {
            length = a;
        } //End block
        {
            CharSequence var3D09FA9D639A4A42AAC189D37959A2B7_338867540 = (content.subSequence(a - length, a));
        } //End block
        CharSequence varDC25761CF9EACC6A9F636A7BD3D05AFA_1411115330 = (TextUtils.substring(content, a - length, a));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.046 -0400", hash_original_method = "ED9D872BFDE8C5E26AC99155DBA149BF", hash_generated_method = "BE7470675D0E7784E6B9735B0977E19D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getSelectedText(int flags) {
        dsTaint.addTaint(flags);
        final Editable content;
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
        {
            CharSequence var573F585F6C273E0B2BD0E5838B1C288F_1961840374 = (content.subSequence(a, b));
        } //End block
        CharSequence var009D1501F23C55676B44938BE17B5EB2_1425879002 = (TextUtils.substring(content, a, b));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.047 -0400", hash_original_method = "08096EEE0873EB795CD58B469F10D5B2", hash_generated_method = "E76AC71D1481CBEA3F95F6B7EA310EB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getTextAfterCursor(int length, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(length);
        final Editable content;
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
        {
            b = 0;
        } //End block
        {
            boolean var7ECC0DB8B673AA466FD8BC7FC09E2D15_1035586882 = (b + length > content.length());
            {
                length = content.length() - b;
            } //End block
        } //End collapsed parenthetic
        {
            CharSequence var4CBBA902C75BC3529C6A29BD8528F10E_1454089813 = (content.subSequence(b, b + length));
        } //End block
        CharSequence varE5F327044141AC3240ED4893E2C8481B_1961820743 = (TextUtils.substring(content, b, b + length));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.047 -0400", hash_original_method = "F533043312AA12AABEB855D393677CB5", hash_generated_method = "AB5428AC7CBFCBA49135B4FEB825C4B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performEditorAction(int actionCode) {
        dsTaint.addTaint(actionCode);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.047 -0400", hash_original_method = "CC9943DA76C04BDA8199AB8562F111EF", hash_generated_method = "CA3215C4FF46CC9BF2A38380CF6D7E33")
    @DSModeled(DSC.SAFE)
    public boolean performContextMenuAction(int id) {
        dsTaint.addTaint(id);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.047 -0400", hash_original_method = "E554B360562612AFCC9A87837C58FB1E", hash_generated_method = "8E9FDBD77B1539CCA6DC8C2B39E7B276")
    @DSModeled(DSC.SAFE)
    public boolean performPrivateCommand(String action, Bundle data) {
        dsTaint.addTaint(action);
        dsTaint.addTaint(data.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.047 -0400", hash_original_method = "9F64937BB19F72531BAD6E029A24112C", hash_generated_method = "E891419D7EF811F19577F5E434B0548D")
    @DSModeled(DSC.SAFE)
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        dsTaint.addTaint(newCursorPosition);
        dsTaint.addTaint(text);
        replaceText(text, newCursorPosition, true);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "setComposingText " + text);
        //replaceText(text, newCursorPosition, true);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.047 -0400", hash_original_method = "683D72CF1BBC9E7A391F140A2B9406BC", hash_generated_method = "81DE593F67347A4D9B9A7DDAC73D5EEC")
    @DSModeled(DSC.SAFE)
    public boolean setComposingRegion(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        final Editable content;
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
            final int length;
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.048 -0400", hash_original_method = "06BE1F921CCFEC5EE49CD2FF18114BBC", hash_generated_method = "C80C1EA97C1C534F6DD19F8A0E51D7DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setSelection(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        final Editable content;
        content = getEditable();
        int len;
        len = content.length();
        {
            boolean varA1F7AC2D1C7D9F96E09A09209C846F35_1333117330 = (start == end && MetaKeyKeyListener.getMetaState(content,
                MetaKeyKeyListener.META_SELECTING) != 0);
            {
                Selection.extendSelection(content, start);
            } //End block
            {
                Selection.setSelection(content, start, end);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.048 -0400", hash_original_method = "F539697840E1FFDBA9E983D0C0D8D0DD", hash_generated_method = "4F6F37CF294C01A313499FDFFDEA16C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean sendKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.048 -0400", hash_original_method = "FA18FCA0F08D3E4AC2B0D49617508B22", hash_generated_method = "D856359B87C7FA0E0BBBDC7881F2B279")
    @DSModeled(DSC.SAFE)
    public boolean reportFullscreenMode(boolean enabled) {
        dsTaint.addTaint(enabled);
        mIMM.setFullscreenMode(enabled);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mIMM.setFullscreenMode(enabled);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.048 -0400", hash_original_method = "BDE0428D54DBC47996CEC1E4604D5DEE", hash_generated_method = "760D714F9EE9550629352EEA525E924A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendCurrentText() {
        Editable content;
        content = getEditable();
        {
            final int N;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.048 -0400", hash_original_method = "30261E28269E8D45DD173790F761946A", hash_generated_method = "B53DC985B344BBE908ED01CB0D0F4CE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.049 -0400", hash_original_method = "A9689D9BE329300E95AF0BB78D1B0A9D", hash_generated_method = "7E27A48E7DF7730113A1D1839FFABA71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void replaceText(CharSequence text, int newCursorPosition,
            boolean composing) {
        dsTaint.addTaint(newCursorPosition);
        dsTaint.addTaint(text);
        dsTaint.addTaint(composing);
        final Editable content;
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
            boolean var1E349D85B106544D1972E08C42A1AAA3_2009566406 = (newCursorPosition > content.length());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


