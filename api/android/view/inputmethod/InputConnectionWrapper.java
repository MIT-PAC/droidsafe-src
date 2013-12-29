package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.view.KeyEvent;


public class InputConnectionWrapper implements InputConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.482 -0500", hash_original_field = "8E3195515492BEAAB35BF3AB9AAAADC5", hash_generated_field = "151AD6A9E57045A4F9C7E4BD9FA7D17C")

    private InputConnection mTarget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.483 -0500", hash_original_field = "899CF99A8BCFC1DC9FF2AE2242A53A1C", hash_generated_field = "899CF99A8BCFC1DC9FF2AE2242A53A1C")

     boolean mMutable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.484 -0500", hash_original_method = "0AE68A627B838EA5D1B587AAFC2A6012", hash_generated_method = "807A120A737872ABBAB79A5B04610B59")
    public InputConnectionWrapper(InputConnection target, boolean mutable) {
        mMutable = mutable;
        mTarget = target;
    }

    /**
     * Change the target of the input connection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.485 -0500", hash_original_method = "B3C6A81D2BBBD36FEBF3ECE06B5CDD0C", hash_generated_method = "23DA4F0C6064BD3E238682C42AF5D824")
    public void setTarget(InputConnection target) {
        if (mTarget != null && !mMutable) {
            throw new SecurityException("not mutable");
        }
        mTarget = target;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.486 -0500", hash_original_method = "70D1E90906EDA66AADA5E9E7AF314024", hash_generated_method = "B461513FD88AC98BE482E876112D5202")
    public CharSequence getTextBeforeCursor(int n, int flags) {
        return mTarget.getTextBeforeCursor(n, flags);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.486 -0500", hash_original_method = "511698C68B38701B7124628C33C2BDC9", hash_generated_method = "7598E78431D4AB1F9FF730CD883FFE61")
    public CharSequence getTextAfterCursor(int n, int flags) {
        return mTarget.getTextAfterCursor(n, flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.487 -0500", hash_original_method = "F94B155A1C8F9C791E6D9828C6F8114B", hash_generated_method = "3DE3851AF3CFFC905685B8AAFDBD7A82")
    public CharSequence getSelectedText(int flags) {
        return mTarget.getSelectedText(flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.488 -0500", hash_original_method = "FFC3D29E68F767E6DE7BA85D50A59F74", hash_generated_method = "0C0CBE9F677ADE2BBE3319D1F79DCAE3")
    public int getCursorCapsMode(int reqModes) {
        return mTarget.getCursorCapsMode(reqModes);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.489 -0500", hash_original_method = "B46A0C14FE8C4BFCAB3863CCE2B487E1", hash_generated_method = "C2B8C6205BC7C225EE03F7B298CF6BC1")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        return mTarget.getExtractedText(request, flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.490 -0500", hash_original_method = "02B0C02DBA209769DC8321464F457D4E", hash_generated_method = "EC7DBFEAFE2B02D5184C88FFD3235E8A")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        return mTarget.deleteSurroundingText(leftLength, rightLength);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.491 -0500", hash_original_method = "C347FD161FDEFFB180258C7A61E86611", hash_generated_method = "36C28CC75410E2460F2D63EB57FCC5F5")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        return mTarget.setComposingText(text, newCursorPosition);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.492 -0500", hash_original_method = "EB3F6672BEE71C12075AAA6BA4DB02F1", hash_generated_method = "6831CD4CB1CA4BCA457784819D25BE93")
    public boolean setComposingRegion(int start, int end) {
        return mTarget.setComposingRegion(start, end);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.492 -0500", hash_original_method = "09C1683C22BFF62FC14B2B11C262ABDF", hash_generated_method = "B681580C9DC68BE46A385F4EF34D6B2A")
    public boolean finishComposingText() {
        return mTarget.finishComposingText();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.493 -0500", hash_original_method = "9F195FFD333D6DD92AB286EC5AB03487", hash_generated_method = "23676FD1890B717C0C3B625397ACEF05")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        return mTarget.commitText(text, newCursorPosition);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.494 -0500", hash_original_method = "947FB54A5439AE99C45577560BDB97CA", hash_generated_method = "628DF4907A2CD93B96684B452B9AE66F")
    public boolean commitCompletion(CompletionInfo text) {
        return mTarget.commitCompletion(text);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.495 -0500", hash_original_method = "57757FD5C0807A7AB2D953AC1AE2D156", hash_generated_method = "27958DBD614D607330537D95C5699209")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        return mTarget.commitCorrection(correctionInfo);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.496 -0500", hash_original_method = "E434BE133364C8C6947501760AA1AA25", hash_generated_method = "73BAC84DD77B212DB9DF8D8A206712C1")
    public boolean setSelection(int start, int end) {
        return mTarget.setSelection(start, end);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.497 -0500", hash_original_method = "557B358548051EB41CD67FF4BAC9B39C", hash_generated_method = "F2DCE21E89D66883ED3205B6E14F9F15")
    public boolean performEditorAction(int editorAction) {
        return mTarget.performEditorAction(editorAction);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.497 -0500", hash_original_method = "7FAFD46A8306525DB41EEE6E5B575235", hash_generated_method = "53A7C69D7D45FBC5EEDAE3424F060D0A")
    public boolean performContextMenuAction(int id) {
        return mTarget.performContextMenuAction(id);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.498 -0500", hash_original_method = "AAA3AB8A2808B740C08D8BCAC6EF593C", hash_generated_method = "CB14BC8C680480BE0F8B9077DD656799")
    public boolean beginBatchEdit() {
        return mTarget.beginBatchEdit();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.499 -0500", hash_original_method = "C936839A69151952786EDD11909238AD", hash_generated_method = "BB4861E645C0E9FD305A3472C7BE098E")
    public boolean endBatchEdit() {
        return mTarget.endBatchEdit();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.500 -0500", hash_original_method = "9D024620F1B53C75FE915B021E654688", hash_generated_method = "420AC69BA51E4382179CE23BC1D8364F")
    public boolean sendKeyEvent(KeyEvent event) {
        return mTarget.sendKeyEvent(event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.500 -0500", hash_original_method = "475264A381587BF32EFFB4A3D00FD07C", hash_generated_method = "CF3474EA16DC5715D83EFF79A5957ACD")
    public boolean clearMetaKeyStates(int states) {
        return mTarget.clearMetaKeyStates(states);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.501 -0500", hash_original_method = "F1C831DAF80FFACCBD0D484BA3C71C5A", hash_generated_method = "DDEB7325B19843D409D7C28F7A5CFF48")
    public boolean reportFullscreenMode(boolean enabled) {
        return mTarget.reportFullscreenMode(enabled);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:15.502 -0500", hash_original_method = "E30515F5F44630827F2EF8B8A6D02C04", hash_generated_method = "813CC442176AC2FCDF5D27D20ECA5D63")
    public boolean performPrivateCommand(String action, Bundle data) {
        return mTarget.performPrivateCommand(action, data);
    }

    
}

