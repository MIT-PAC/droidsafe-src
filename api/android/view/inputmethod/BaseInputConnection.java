package android.view.inputmethod;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.076 -0400", hash_original_method = "299AC39680AC1BE3A17612B5D7B1D330", hash_generated_method = "299AC39680AC1BE3A17612B5D7B1D330")
    public ComposingText ()
    {
        
    }


}

public class BaseInputConnection implements InputConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.077 -0400", hash_original_field = "14E624678D0167A1D4F7B9DAF4BB3911", hash_generated_field = "141F0EFC0D8976518F576600E5590698")

    protected InputMethodManager mIMM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.077 -0400", hash_original_field = "4FDD02795CD9F6B3D3D1A34A14720073", hash_generated_field = "97ACD18EF4B48BDC424981A4C6E55C66")

    View mTargetView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.077 -0400", hash_original_field = "7A74C515F1C024E4A8A2C659CD63F25D", hash_generated_field = "B578BC86523A8ED06C11106F457EA3A1")

    boolean mDummyMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.077 -0400", hash_original_field = "DC2DB2F90A8C23F2FDC026A43D03668D", hash_generated_field = "252704B80FDD4D9B6E86ECF1CBD2B09A")

    private Object[] mDefaultComposingSpans;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.077 -0400", hash_original_field = "03FD58BE1D67B8547AADB1829EF91363", hash_generated_field = "BC747A06F00EC3CB73FDE2D30B84DC2D")

    Editable mEditable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.077 -0400", hash_original_field = "C7BC21409380B9440A2B406EA5A8934C", hash_generated_field = "5553093AC34FB198BC290668CD3A4BD4")

    KeyCharacterMap mKeyCharacterMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.078 -0400", hash_original_method = "1A943D99EC75638EA04879F1FF8F4BB3", hash_generated_method = "D904201E77FBD444E7EC22E5A2FA95EE")
      BaseInputConnection(InputMethodManager mgr, boolean fullEditor) {
        mIMM = mgr;
        mTargetView = null;
        mDummyMode = !fullEditor;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.078 -0400", hash_original_method = "8D9F46A02734088C3A101A4C25C68420", hash_generated_method = "7E503C534998A7CE2443D4066DFB4BA4")
    public  BaseInputConnection(View targetView, boolean fullEditor) {
        mIMM = (InputMethodManager)targetView.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        mTargetView = targetView;
        mDummyMode = !fullEditor;
        
        
                
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.080 -0400", hash_original_method = "A97F5DFC2840DF7B5D61C809FDCD4D64", hash_generated_method = "B8840EBCA269A3389375A0215482E74A")
    public Editable getEditable() {
    if(mEditable == null)        
        {
            mEditable = Editable.Factory.getInstance().newEditable("");
            Selection.setSelection(mEditable, 0);
        } 
Editable varCC26BBC33AB90DD8701B3B15E792A870_384425446 =         mEditable;
        varCC26BBC33AB90DD8701B3B15E792A870_384425446.addTaint(taint);
        return varCC26BBC33AB90DD8701B3B15E792A870_384425446;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.080 -0400", hash_original_method = "E28DA299470AFBBB55E3F0E22CB4A567", hash_generated_method = "DB98A8A72401F402057B24EC7C08B714")
    public boolean beginBatchEdit() {
        boolean var68934A3E9455FA72420237EB05902327_104615228 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_202633324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_202633324;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.081 -0400", hash_original_method = "68C20202F4C35ADB2F9CDE7850BF84CC", hash_generated_method = "DB96F0E57C7118FAD0E51A4E209A9A88")
    public boolean endBatchEdit() {
        boolean var68934A3E9455FA72420237EB05902327_1039160252 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1071989843 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1071989843;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.081 -0400", hash_original_method = "BC6513316EC80C5373FB6263D33C3F52", hash_generated_method = "88A0EFEB901158D802D9149A4CBA1A17")
    public boolean clearMetaKeyStates(int states) {
        addTaint(states);
        final Editable content = getEditable();
    if(content == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1777781705 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_824837092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_824837092;
        }
        MetaKeyKeyListener.clearMetaKeyState(content, states);
        boolean varB326B5062B2F0E69046810717534CB09_350655833 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_32090452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_32090452;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.081 -0400", hash_original_method = "AA7244FCF81F32F7DEF3D51FAE032B7D", hash_generated_method = "0D5B813BB093CA31CBA2C0262C1EA745")
    public boolean commitCompletion(CompletionInfo text) {
        addTaint(text.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_824852294 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_19364002 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_19364002;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.082 -0400", hash_original_method = "8ECFF7D6DBED10855DA2C653047584D7", hash_generated_method = "379FF6DE81B2BC298D12E4A7F612EA4F")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        addTaint(correctionInfo.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_473701950 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2034225279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2034225279;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.082 -0400", hash_original_method = "25125C99E3204B3B6C4C8BDE15E97EE8", hash_generated_method = "B1A97309333E0F100CD4848894410BD8")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
    if(DEBUG){ }        replaceText(text, newCursorPosition, false);
        sendCurrentText();
        boolean varB326B5062B2F0E69046810717534CB09_1043406263 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1736587574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1736587574;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.084 -0400", hash_original_method = "74B12EE6F294A949F3B11979331384E6", hash_generated_method = "05C0F2BD9E7FDF9ADB2C346042D6C8B7")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        addTaint(rightLength);
        addTaint(leftLength);
    if(DEBUG){ }        final Editable content = getEditable();
    if(content == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1622870926 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1424820264 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1424820264;
        }
        beginBatchEdit();
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
    if(a > b)        
        {
            int tmp = a;
            a = b;
            b = tmp;
        } 
        int ca = getComposingSpanStart(content);
        int cb = getComposingSpanEnd(content);
    if(cb < ca)        
        {
            int tmp = ca;
            ca = cb;
            cb = tmp;
        } 
    if(ca != -1 && cb != -1)        
        {
    if(ca < a)            
            a = ca;
    if(cb > b)            
            b = cb;
        } 
        int deleted = 0;
    if(leftLength > 0)        
        {
            int start = a - leftLength;
    if(start < 0)            
            start = 0;
            content.delete(start, a);
            deleted = a - start;
        } 
    if(rightLength > 0)        
        {
            b = b - deleted;
            int end = b + rightLength;
    if(end > content.length())            
            end = content.length();
            content.delete(b, end);
        } 
        endBatchEdit();
        boolean varB326B5062B2F0E69046810717534CB09_21079395 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1204424471 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1204424471;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.086 -0400", hash_original_method = "1CCB9955A4205D39AC8709BDCAB9AF4C", hash_generated_method = "A8180311BA76FCA40291AC8EC4A51A00")
    public boolean finishComposingText() {
    if(DEBUG){ }        final Editable content = getEditable();
    if(content != null)        
        {
            beginBatchEdit();
            removeComposingSpans(content);
            endBatchEdit();
            sendCurrentText();
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1698639921 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1405617694 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1405617694;
        
        
        
        
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.086 -0400", hash_original_method = "A12ABCD2EB4522E8FE53DB6299A361B5", hash_generated_method = "4ED6B85246077180229CF83213E650EC")
    public int getCursorCapsMode(int reqModes) {
        addTaint(reqModes);
    if(mDummyMode)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_362640383 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463770712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463770712;
        }
        final Editable content = getEditable();
    if(content == null)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1343291259 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_619791848 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_619791848;
        }
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
    if(a > b)        
        {
            int tmp = a;
            a = b;
            b = tmp;
        } 
        int varAC1DC7664A2FAF8D24FFCD56574315AA_513603299 = (TextUtils.getCapsMode(content, a, reqModes));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126550986 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126550986;
        
        
        
        
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.087 -0400", hash_original_method = "A2A8D9B6A3DC6DA18051F8E023FD4A27", hash_generated_method = "2176D6FFBFB184BF2631512223A4628A")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        addTaint(flags);
        addTaint(request.getTaint());
ExtractedText var540C13E9E156B687226421B24F2DF178_2142871960 =         null;
        var540C13E9E156B687226421B24F2DF178_2142871960.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2142871960;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.088 -0400", hash_original_method = "75E370B84589846A89A63AE625719BF1", hash_generated_method = "6805D994F8BA277753FAC9EA14CA9979")
    public CharSequence getTextBeforeCursor(int length, int flags) {
        addTaint(flags);
        addTaint(length);
        final Editable content = getEditable();
    if(content == null)        
        {
CharSequence var540C13E9E156B687226421B24F2DF178_1734835582 =         null;
        var540C13E9E156B687226421B24F2DF178_1734835582.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1734835582;
        }
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
    if(a > b)        
        {
            int tmp = a;
            a = b;
            b = tmp;
        } 
    if(a <= 0)        
        {
CharSequence var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1455720086 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1455720086.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1455720086;
        } 
    if(length > a)        
        {
            length = a;
        } 
    if((flags&GET_TEXT_WITH_STYLES) != 0)        
        {
CharSequence var98F4DAC361D2DB9395F44CE0388E2FEB_1166177242 =             content.subSequence(a - length, a);
            var98F4DAC361D2DB9395F44CE0388E2FEB_1166177242.addTaint(taint);
            return var98F4DAC361D2DB9395F44CE0388E2FEB_1166177242;
        } 
CharSequence varE0983249B3322D55B8820CF6237DB0C2_883790790 =         TextUtils.substring(content, a - length, a);
        varE0983249B3322D55B8820CF6237DB0C2_883790790.addTaint(taint);
        return varE0983249B3322D55B8820CF6237DB0C2_883790790;
        
        
        
        
        
        
            
            
            
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.089 -0400", hash_original_method = "ED9D872BFDE8C5E26AC99155DBA149BF", hash_generated_method = "F9D962543CB300B34944FB7D3264CCEA")
    public CharSequence getSelectedText(int flags) {
        addTaint(flags);
        final Editable content = getEditable();
    if(content == null)        
        {
CharSequence var540C13E9E156B687226421B24F2DF178_1857486432 =         null;
        var540C13E9E156B687226421B24F2DF178_1857486432.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1857486432;
        }
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
    if(a > b)        
        {
            int tmp = a;
            a = b;
            b = tmp;
        } 
    if(a == b)        
        {
CharSequence var540C13E9E156B687226421B24F2DF178_46999601 =         null;
        var540C13E9E156B687226421B24F2DF178_46999601.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_46999601;
        }
    if((flags&GET_TEXT_WITH_STYLES) != 0)        
        {
CharSequence var9FEC3648C14F3AF70D16DE447BDE5069_133852979 =             content.subSequence(a, b);
            var9FEC3648C14F3AF70D16DE447BDE5069_133852979.addTaint(taint);
            return var9FEC3648C14F3AF70D16DE447BDE5069_133852979;
        } 
CharSequence var7A2F1FD98731D6CF16BD95DD1582A13C_1396024072 =         TextUtils.substring(content, a, b);
        var7A2F1FD98731D6CF16BD95DD1582A13C_1396024072.addTaint(taint);
        return var7A2F1FD98731D6CF16BD95DD1582A13C_1396024072;
        
        
        
        
        
        
            
            
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.089 -0400", hash_original_method = "08096EEE0873EB795CD58B469F10D5B2", hash_generated_method = "9D59A37AB01DEC1CBC930EEAEE178F0D")
    public CharSequence getTextAfterCursor(int length, int flags) {
        addTaint(flags);
        addTaint(length);
        final Editable content = getEditable();
    if(content == null)        
        {
CharSequence var540C13E9E156B687226421B24F2DF178_477662322 =         null;
        var540C13E9E156B687226421B24F2DF178_477662322.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_477662322;
        }
        int a = Selection.getSelectionStart(content);
        int b = Selection.getSelectionEnd(content);
    if(a > b)        
        {
            int tmp = a;
            a = b;
            b = tmp;
        } 
    if(b < 0)        
        {
            b = 0;
        } 
    if(b + length > content.length())        
        {
            length = content.length() - b;
        } 
    if((flags&GET_TEXT_WITH_STYLES) != 0)        
        {
CharSequence var4A6E4E8B570A86454B984D76FFE2C8FA_1734170861 =             content.subSequence(b, b + length);
            var4A6E4E8B570A86454B984D76FFE2C8FA_1734170861.addTaint(taint);
            return var4A6E4E8B570A86454B984D76FFE2C8FA_1734170861;
        } 
CharSequence var6D90238DD76AA0130EFA44B03DDEEA38_1985735670 =         TextUtils.substring(content, b, b + length);
        var6D90238DD76AA0130EFA44B03DDEEA38_1985735670.addTaint(taint);
        return var6D90238DD76AA0130EFA44B03DDEEA38_1985735670;
        
        
        
        
        
        
            
            
            
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.090 -0400", hash_original_method = "F533043312AA12AABEB855D393677CB5", hash_generated_method = "0645102D047799D9F6EB4EFAA7494273")
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
        boolean varB326B5062B2F0E69046810717534CB09_1287054674 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1790359906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1790359906;
        
        
        
                
                
                
                
        
                
                
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.090 -0400", hash_original_method = "CC9943DA76C04BDA8199AB8562F111EF", hash_generated_method = "C3718773EC631C9751D63BE8B19BA7AD")
    public boolean performContextMenuAction(int id) {
        addTaint(id);
        boolean var68934A3E9455FA72420237EB05902327_1284113193 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2020978956 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2020978956;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.091 -0400", hash_original_method = "E554B360562612AFCC9A87837C58FB1E", hash_generated_method = "9F53D70F9ED1677AA23FFE6284AAD7EF")
    public boolean performPrivateCommand(String action, Bundle data) {
        addTaint(data.getTaint());
        addTaint(action.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_589930454 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1016922840 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1016922840;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.091 -0400", hash_original_method = "9F64937BB19F72531BAD6E029A24112C", hash_generated_method = "F4060A2CB8FF6165D9F0D9223290CC2E")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
    if(DEBUG){ }        replaceText(text, newCursorPosition, true);
        boolean varB326B5062B2F0E69046810717534CB09_1235371455 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1539054700 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1539054700;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.092 -0400", hash_original_method = "683D72CF1BBC9E7A391F140A2B9406BC", hash_generated_method = "8DED73BCB07429B55C58AA4B4511DE3F")
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
            } 
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
                } 
            } 
            content.setSpan(COMPOSING, a, b,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE | Spanned.SPAN_COMPOSING);
            endBatchEdit();
            sendCurrentText();
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1400584690 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647369167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_647369167;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.093 -0400", hash_original_method = "06BE1F921CCFEC5EE49CD2FF18114BBC", hash_generated_method = "3FEA1E849DFB7CC7DFC2CD4A9791B2F2")
    public boolean setSelection(int start, int end) {
        addTaint(end);
        addTaint(start);
    if(DEBUG){ }        final Editable content = getEditable();
    if(content == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_601952799 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_143335321 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_143335321;
        }
        int len = content.length();
    if(start > len || end > len)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1528225161 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_421806679 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_421806679;
        } 
    if(start == end && MetaKeyKeyListener.getMetaState(content,
                MetaKeyKeyListener.META_SELECTING) != 0)        
        {
            Selection.extendSelection(content, start);
        } 
        else
        {
            Selection.setSelection(content, start, end);
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1372161644 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_890437522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_890437522;
        
        
        
        
        
        
            
        
        
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.094 -0400", hash_original_method = "F539697840E1FFDBA9E983D0C0D8D0DD", hash_generated_method = "1D2268682FF0CEE66B8E32DC3613B4EB")
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
                } 
            } 
    if(h != null)            
            {
                h.sendMessage(h.obtainMessage(ViewRootImpl.DISPATCH_KEY_FROM_IME,
                        event));
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_2096770441 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1647748932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1647748932;
        
        
            
            
                
                    
                
            
            
                
                        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.094 -0400", hash_original_method = "FA18FCA0F08D3E4AC2B0D49617508B22", hash_generated_method = "728EDAB4C6D05F7A9FD6F000D7B7BA50")
    public boolean reportFullscreenMode(boolean enabled) {
        addTaint(enabled);
        mIMM.setFullscreenMode(enabled);
        boolean varB326B5062B2F0E69046810717534CB09_1414490031 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1492786659 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1492786659;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.095 -0400", hash_original_method = "BDE0428D54DBC47996CEC1E4604D5DEE", hash_generated_method = "2CC7DECE65CEF9B9F8DD90BD0E709500")
    private void sendCurrentText() {
    if(!mDummyMode)        
        {
            return;
        } 
        Editable content = getEditable();
    if(content != null)        
        {
            final int N = content.length();
    if(N == 0)            
            {
                return;
            } 
    if(N == 1)            
            {
    if(mKeyCharacterMap == null)                
                {
                    mKeyCharacterMap = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
                } 
                char[] chars = new char[1];
                content.getChars(0, 1, chars, 0);
                KeyEvent[] events = mKeyCharacterMap.getEvents(chars);
    if(events != null)                
                {
for(int i=0;i<events.length;i++)
                    {
    if(DEBUG){ }                        sendKeyEvent(events[i]);
                    } 
                    content.clear();
                    return;
                } 
            } 
            KeyEvent event = new KeyEvent(SystemClock.uptimeMillis(),
                    content.toString(), KeyCharacterMap.VIRTUAL_KEYBOARD, 0);
            sendKeyEvent(event);
            content.clear();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.096 -0400", hash_original_method = "30261E28269E8D45DD173790F761946A", hash_generated_method = "248D883F22823C68A57D8063BAB7D88B")
    private void ensureDefaultComposingSpans() {
    if(mDefaultComposingSpans == null)        
        {
            Context context;
    if(mTargetView != null)            
            {
                context = mTargetView.getContext();
            } 
            else
    if(mIMM.mServedView != null)            
            {
                context = mIMM.mServedView.getContext();
            } 
            else
            {
                context = null;
            } 
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
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.098 -0400", hash_original_method = "A9689D9BE329300E95AF0BB78D1B0A9D", hash_generated_method = "93444BA3A648A139330CFE8497B05AB9")
    private void replaceText(CharSequence text, int newCursorPosition,
            boolean composing) {
        addTaint(composing);
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        final Editable content = getEditable();
    if(content == null)        
        {
            return;
        } 
        beginBatchEdit();
        int a = getComposingSpanStart(content);
        int b = getComposingSpanEnd(content);
    if(DEBUG){ }    if(b < a)        
        {
            int tmp = a;
            a = b;
            b = tmp;
        } 
    if(a != -1 && b != -1)        
        {
            removeComposingSpans(content);
        } 
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
            } 
        } 
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
                    } 
                } 
            } 
            else
            {
                sp = (Spannable)text;
            } 
            setComposingSpans(sp);
        } 
    if(DEBUG){ }    if(DEBUG)        
        {
            LogPrinter lp = new LogPrinter(Log.VERBOSE, TAG);
            lp.println("Current text:");
            TextUtils.dumpSpans(content, lp, "  ");
            lp.println("Composing text:");
            TextUtils.dumpSpans(text, lp, "  ");
        } 
    if(newCursorPosition > 0)        
        {
            newCursorPosition += b - 1;
        } 
        else
        {
            newCursorPosition += a;
        } 
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
        } 
        endBatchEdit();
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.099 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.099 -0400", hash_original_field = "BAA57012083A507882C8ACD4608B3E53", hash_generated_field = "53A6B0F8E8ED4C9CDAAB0EB974BB44EF")

    private static final String TAG = "BaseInputConnection";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.099 -0400", hash_original_field = "6A146B7CB527A9187E4E6A97BD4E3C80", hash_generated_field = "8705A035FE559B3B54E215D6480E2AFA")

    static final Object COMPOSING = new ComposingText();
}

