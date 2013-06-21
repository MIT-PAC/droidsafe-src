package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.view.KeyEvent;

public class InputConnectionWrapper implements InputConnection {
    private InputConnection mTarget;
    boolean mMutable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.315 -0400", hash_original_method = "0AE68A627B838EA5D1B587AAFC2A6012", hash_generated_method = "098F210F12359C98EB6E3F6DE610D2FA")
    @DSModeled(DSC.SAFE)
    public InputConnectionWrapper(InputConnection target, boolean mutable) {
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(mutable);
        // ---------- Original Method ----------
        //mMutable = mutable;
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.316 -0400", hash_original_method = "B3C6A81D2BBBD36FEBF3ECE06B5CDD0C", hash_generated_method = "999E92370D723231C23251EC10E2C97F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTarget(InputConnection target) {
        dsTaint.addTaint(target.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new SecurityException("not mutable");
        } //End block
        // ---------- Original Method ----------
        //if (mTarget != null && !mMutable) {
            //throw new SecurityException("not mutable");
        //}
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.316 -0400", hash_original_method = "70D1E90906EDA66AADA5E9E7AF314024", hash_generated_method = "D00C344CD0C028E8304E53CFD8DAEC71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getTextBeforeCursor(int n, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(n);
        CharSequence varF8A2659018E8989CBFA08D6EE33B6755_1174267600 = (mTarget.getTextBeforeCursor(n, flags));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTarget.getTextBeforeCursor(n, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.316 -0400", hash_original_method = "511698C68B38701B7124628C33C2BDC9", hash_generated_method = "E2AC4D8BEDCB1B2F692BF079EBB5B362")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getTextAfterCursor(int n, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(n);
        CharSequence var7A3E61C5B4DC0F1A17C7FD736AD00182_1556445126 = (mTarget.getTextAfterCursor(n, flags));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTarget.getTextAfterCursor(n, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.316 -0400", hash_original_method = "F94B155A1C8F9C791E6D9828C6F8114B", hash_generated_method = "E4F564024E68F21A323AD87A2C512ED1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getSelectedText(int flags) {
        dsTaint.addTaint(flags);
        CharSequence varBB9E7E88BEACDAC107CD294EF185BE4D_1199863984 = (mTarget.getSelectedText(flags));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTarget.getSelectedText(flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.316 -0400", hash_original_method = "FFC3D29E68F767E6DE7BA85D50A59F74", hash_generated_method = "7A524599F3CB6B74267D93399B54E738")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCursorCapsMode(int reqModes) {
        dsTaint.addTaint(reqModes);
        int var9EE55FD6B4FBDC45EA575015179961A6_1724201979 = (mTarget.getCursorCapsMode(reqModes));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTarget.getCursorCapsMode(reqModes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.317 -0400", hash_original_method = "B46A0C14FE8C4BFCAB3863CCE2B487E1", hash_generated_method = "481A5851FBF601D364F50F3F1CA880FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(request.dsTaint);
        ExtractedText varC7913E14D0A7FB16EECAE945C3A6C7CD_973948933 = (mTarget.getExtractedText(request, flags));
        return (ExtractedText)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTarget.getExtractedText(request, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.317 -0400", hash_original_method = "02B0C02DBA209769DC8321464F457D4E", hash_generated_method = "EC3BD405F783424B321678116F30820B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        dsTaint.addTaint(leftLength);
        dsTaint.addTaint(rightLength);
        boolean var45116ED4C8217487542A34411482CB87_166738536 = (mTarget.deleteSurroundingText(leftLength, rightLength));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.deleteSurroundingText(leftLength, rightLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.317 -0400", hash_original_method = "C347FD161FDEFFB180258C7A61E86611", hash_generated_method = "6E1C9EC83F7C59C09254380AD3518D86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        dsTaint.addTaint(newCursorPosition);
        dsTaint.addTaint(text);
        boolean varA982CA5A0D886EDE7E6BF0FA3AF98FEC_1616200602 = (mTarget.setComposingText(text, newCursorPosition));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.setComposingText(text, newCursorPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.317 -0400", hash_original_method = "EB3F6672BEE71C12075AAA6BA4DB02F1", hash_generated_method = "D6F32B245947E19EC6DB8407EC9547A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setComposingRegion(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        boolean var762675F5FAF75E5CED1A54C381C535FF_1906118204 = (mTarget.setComposingRegion(start, end));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.setComposingRegion(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.317 -0400", hash_original_method = "09C1683C22BFF62FC14B2B11C262ABDF", hash_generated_method = "6E1268A7CE008033947D155322D41AAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean finishComposingText() {
        boolean var2B42F6570BC498400794E28B24E4AD52_850267177 = (mTarget.finishComposingText());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.finishComposingText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.318 -0400", hash_original_method = "9F195FFD333D6DD92AB286EC5AB03487", hash_generated_method = "F3DC03EA1D88706E7DB0C314507041B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean commitText(CharSequence text, int newCursorPosition) {
        dsTaint.addTaint(newCursorPosition);
        dsTaint.addTaint(text);
        boolean varAEEF99E9BA25A66965AF36A33AE4448C_768765954 = (mTarget.commitText(text, newCursorPosition));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.commitText(text, newCursorPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.318 -0400", hash_original_method = "947FB54A5439AE99C45577560BDB97CA", hash_generated_method = "03B30C36C5EB8B758F280AC3754762CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean commitCompletion(CompletionInfo text) {
        dsTaint.addTaint(text.dsTaint);
        boolean var78AF5FC2EB00EA73DF91FACCC2E4C678_287047377 = (mTarget.commitCompletion(text));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.commitCompletion(text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.318 -0400", hash_original_method = "57757FD5C0807A7AB2D953AC1AE2D156", hash_generated_method = "E13C61998218052B90229D7A47360430")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        dsTaint.addTaint(correctionInfo.dsTaint);
        boolean var1980FAB352C02C42EB774650FB2B1633_55020706 = (mTarget.commitCorrection(correctionInfo));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.commitCorrection(correctionInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.318 -0400", hash_original_method = "E434BE133364C8C6947501760AA1AA25", hash_generated_method = "D02343D17930F44BECFF87AFE62D1025")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setSelection(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        boolean var4B891C6D551CBDEBD7831B91FD37B5DD_1309219595 = (mTarget.setSelection(start, end));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.setSelection(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.318 -0400", hash_original_method = "557B358548051EB41CD67FF4BAC9B39C", hash_generated_method = "0EC7ED99B3DD3B4E4595AD9285B43F2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performEditorAction(int editorAction) {
        dsTaint.addTaint(editorAction);
        boolean var84EC45BFB502D3BC219C0F7C40BA28B9_1119190193 = (mTarget.performEditorAction(editorAction));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.performEditorAction(editorAction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.318 -0400", hash_original_method = "7FAFD46A8306525DB41EEE6E5B575235", hash_generated_method = "7231C5EF94E9348C007BEE2118B21BA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performContextMenuAction(int id) {
        dsTaint.addTaint(id);
        boolean var62EF000C3F76EBF17D805561970CDB9C_76933200 = (mTarget.performContextMenuAction(id));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.performContextMenuAction(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.319 -0400", hash_original_method = "AAA3AB8A2808B740C08D8BCAC6EF593C", hash_generated_method = "EE2A1915B519315113C2AAEB9E70CB35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean beginBatchEdit() {
        boolean var74E174EAB39C2BA33E5196F0BDB608A6_592681639 = (mTarget.beginBatchEdit());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.beginBatchEdit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.320 -0400", hash_original_method = "C936839A69151952786EDD11909238AD", hash_generated_method = "0DFCE3B9C36903F7C1C6299782F7E7AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean endBatchEdit() {
        boolean varF32E5DCB095620E3250A82A69A18BDEE_1389853185 = (mTarget.endBatchEdit());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.endBatchEdit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.320 -0400", hash_original_method = "9D024620F1B53C75FE915B021E654688", hash_generated_method = "8D1CC9A25524F989AC52BFEA28CDC395")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean sendKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        boolean var2A77D6CA71E1F639C98AEA00E6C6C331_1660164326 = (mTarget.sendKeyEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.sendKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.321 -0400", hash_original_method = "475264A381587BF32EFFB4A3D00FD07C", hash_generated_method = "38CBA48EC7396827EDEC67EF2005A92E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clearMetaKeyStates(int states) {
        dsTaint.addTaint(states);
        boolean var42AE0461FEEA3AB39F105AD33BC20A8B_1723834417 = (mTarget.clearMetaKeyStates(states));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.clearMetaKeyStates(states);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.321 -0400", hash_original_method = "F1C831DAF80FFACCBD0D484BA3C71C5A", hash_generated_method = "1576FD8C23D6EAFCD239DA42F7945F87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean reportFullscreenMode(boolean enabled) {
        dsTaint.addTaint(enabled);
        boolean varB3A17CD338DC9698C72C6A034048B387_455219251 = (mTarget.reportFullscreenMode(enabled));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.reportFullscreenMode(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.321 -0400", hash_original_method = "E30515F5F44630827F2EF8B8A6D02C04", hash_generated_method = "A05B170100AE2E20011FA996491D6156")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performPrivateCommand(String action, Bundle data) {
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(action);
        boolean varF5E003B6767EB81A93859360509DE14D_1772007463 = (mTarget.performPrivateCommand(action, data));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTarget.performPrivateCommand(action, data);
    }

    
}

