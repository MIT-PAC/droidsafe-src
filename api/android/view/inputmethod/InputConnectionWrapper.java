package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.view.KeyEvent;

public class InputConnectionWrapper implements InputConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.299 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "151AD6A9E57045A4F9C7E4BD9FA7D17C")

    private InputConnection mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.299 -0400", hash_original_field = "8B26166D49D46DD42D28BC31D8611167", hash_generated_field = "899CF99A8BCFC1DC9FF2AE2242A53A1C")

    boolean mMutable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.300 -0400", hash_original_method = "0AE68A627B838EA5D1B587AAFC2A6012", hash_generated_method = "0D40975779983148B7EF1CDAACB54681")
    public  InputConnectionWrapper(InputConnection target, boolean mutable) {
        mMutable = mutable;
        mTarget = target;
        // ---------- Original Method ----------
        //mMutable = mutable;
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.300 -0400", hash_original_method = "B3C6A81D2BBBD36FEBF3ECE06B5CDD0C", hash_generated_method = "0A58A98BF35D16BEAA5197C012DC306B")
    public void setTarget(InputConnection target) {
    if(mTarget != null && !mMutable)        
        {
            SecurityException varB2C8147036581E1A424B6B9EF3D268CB_1527418161 = new SecurityException("not mutable");
            varB2C8147036581E1A424B6B9EF3D268CB_1527418161.addTaint(taint);
            throw varB2C8147036581E1A424B6B9EF3D268CB_1527418161;
        } //End block
        mTarget = target;
        // ---------- Original Method ----------
        //if (mTarget != null && !mMutable) {
            //throw new SecurityException("not mutable");
        //}
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.300 -0400", hash_original_method = "70D1E90906EDA66AADA5E9E7AF314024", hash_generated_method = "B1C44C091988CD6CB474A9D40B3356B8")
    public CharSequence getTextBeforeCursor(int n, int flags) {
        addTaint(flags);
        addTaint(n);
CharSequence var96B87C2CE40782AE737B1AF549A6BA9D_1645849741 =         mTarget.getTextBeforeCursor(n, flags);
        var96B87C2CE40782AE737B1AF549A6BA9D_1645849741.addTaint(taint);
        return var96B87C2CE40782AE737B1AF549A6BA9D_1645849741;
        // ---------- Original Method ----------
        //return mTarget.getTextBeforeCursor(n, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.301 -0400", hash_original_method = "511698C68B38701B7124628C33C2BDC9", hash_generated_method = "835868941965C5C24A58627E78A0865C")
    public CharSequence getTextAfterCursor(int n, int flags) {
        addTaint(flags);
        addTaint(n);
CharSequence var7A97152EE43E119363DC59EFC76018BA_172832869 =         mTarget.getTextAfterCursor(n, flags);
        var7A97152EE43E119363DC59EFC76018BA_172832869.addTaint(taint);
        return var7A97152EE43E119363DC59EFC76018BA_172832869;
        // ---------- Original Method ----------
        //return mTarget.getTextAfterCursor(n, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.301 -0400", hash_original_method = "F94B155A1C8F9C791E6D9828C6F8114B", hash_generated_method = "B522B8928FDAD2AA630BB4FC300CEE9C")
    public CharSequence getSelectedText(int flags) {
        addTaint(flags);
CharSequence varE0648B9B32C1F2D9DBB0613161A39A4A_1960119115 =         mTarget.getSelectedText(flags);
        varE0648B9B32C1F2D9DBB0613161A39A4A_1960119115.addTaint(taint);
        return varE0648B9B32C1F2D9DBB0613161A39A4A_1960119115;
        // ---------- Original Method ----------
        //return mTarget.getSelectedText(flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.301 -0400", hash_original_method = "FFC3D29E68F767E6DE7BA85D50A59F74", hash_generated_method = "FE9C963F5C6A7E7C60822EE1B236287C")
    public int getCursorCapsMode(int reqModes) {
        addTaint(reqModes);
        int var9FC17838F3A08458EE9EBBDE9C77C654_2129889871 = (mTarget.getCursorCapsMode(reqModes));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989715016 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989715016;
        // ---------- Original Method ----------
        //return mTarget.getCursorCapsMode(reqModes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.302 -0400", hash_original_method = "B46A0C14FE8C4BFCAB3863CCE2B487E1", hash_generated_method = "7C9C3326B91E00E124209D66F02F996C")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        addTaint(flags);
        addTaint(request.getTaint());
ExtractedText varD300E0D19816F64B3B9005199AC77447_759769017 =         mTarget.getExtractedText(request, flags);
        varD300E0D19816F64B3B9005199AC77447_759769017.addTaint(taint);
        return varD300E0D19816F64B3B9005199AC77447_759769017;
        // ---------- Original Method ----------
        //return mTarget.getExtractedText(request, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.302 -0400", hash_original_method = "02B0C02DBA209769DC8321464F457D4E", hash_generated_method = "84AE41585DF3F237F959131B2A2B8C27")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        addTaint(rightLength);
        addTaint(leftLength);
        boolean varF47FB3D8A95F64764639FE6403CDEE53_460926686 = (mTarget.deleteSurroundingText(leftLength, rightLength));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046469949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046469949;
        // ---------- Original Method ----------
        //return mTarget.deleteSurroundingText(leftLength, rightLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.302 -0400", hash_original_method = "C347FD161FDEFFB180258C7A61E86611", hash_generated_method = "30DF2DE4BBF32271F498B10656F277DC")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        boolean var0E7405AA93395821257795AFA168FF5B_1171983341 = (mTarget.setComposingText(text, newCursorPosition));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1564698320 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1564698320;
        // ---------- Original Method ----------
        //return mTarget.setComposingText(text, newCursorPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.303 -0400", hash_original_method = "EB3F6672BEE71C12075AAA6BA4DB02F1", hash_generated_method = "D41278AF8AF5FE31B0BCA3ED1E7421C0")
    public boolean setComposingRegion(int start, int end) {
        addTaint(end);
        addTaint(start);
        boolean var450BC7861BD331BA21ED44FE42909224_98000039 = (mTarget.setComposingRegion(start, end));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_466399056 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_466399056;
        // ---------- Original Method ----------
        //return mTarget.setComposingRegion(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.303 -0400", hash_original_method = "09C1683C22BFF62FC14B2B11C262ABDF", hash_generated_method = "DB8021AA70F24AB241F85AF73384FCA9")
    public boolean finishComposingText() {
        boolean var3628555D46E319C05B2FC5775B8E8078_712140774 = (mTarget.finishComposingText());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_219064039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_219064039;
        // ---------- Original Method ----------
        //return mTarget.finishComposingText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.304 -0400", hash_original_method = "9F195FFD333D6DD92AB286EC5AB03487", hash_generated_method = "A13FFC54B411F72A17E7F1554C65E0AA")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        boolean varE2CACB4255A2EBC54DEA2A6DC6E5D7E0_1820777961 = (mTarget.commitText(text, newCursorPosition));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_890149470 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_890149470;
        // ---------- Original Method ----------
        //return mTarget.commitText(text, newCursorPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.304 -0400", hash_original_method = "947FB54A5439AE99C45577560BDB97CA", hash_generated_method = "15490478B31652BEE88DB39B37980E82")
    public boolean commitCompletion(CompletionInfo text) {
        addTaint(text.getTaint());
        boolean varA7EC751CE9B2CE7301CF32B879120ACF_1132684147 = (mTarget.commitCompletion(text));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_215628325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_215628325;
        // ---------- Original Method ----------
        //return mTarget.commitCompletion(text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.304 -0400", hash_original_method = "57757FD5C0807A7AB2D953AC1AE2D156", hash_generated_method = "F6B6B22BBE1681435A1D6A2E64BAF4F4")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        addTaint(correctionInfo.getTaint());
        boolean var4ABE7C185CD113281F40511555A2F59E_1168011994 = (mTarget.commitCorrection(correctionInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_901763187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_901763187;
        // ---------- Original Method ----------
        //return mTarget.commitCorrection(correctionInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.305 -0400", hash_original_method = "E434BE133364C8C6947501760AA1AA25", hash_generated_method = "96CB35CDB134075C16F135014BF833E9")
    public boolean setSelection(int start, int end) {
        addTaint(end);
        addTaint(start);
        boolean var66A8181D4D3FC1B4B272459A34EDDD71_1397130129 = (mTarget.setSelection(start, end));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_709203502 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_709203502;
        // ---------- Original Method ----------
        //return mTarget.setSelection(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.305 -0400", hash_original_method = "557B358548051EB41CD67FF4BAC9B39C", hash_generated_method = "AE9244F8F20D808957FB3D765F9AB095")
    public boolean performEditorAction(int editorAction) {
        addTaint(editorAction);
        boolean varCBEA2A48C1E14537F48B1F936A5C5707_2107706032 = (mTarget.performEditorAction(editorAction));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2129739213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2129739213;
        // ---------- Original Method ----------
        //return mTarget.performEditorAction(editorAction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.306 -0400", hash_original_method = "7FAFD46A8306525DB41EEE6E5B575235", hash_generated_method = "3E5EF8C0A51618E511E1A751FA5B96C3")
    public boolean performContextMenuAction(int id) {
        addTaint(id);
        boolean varB90D6D4C8292A7A77C8B0488103A6AED_2115471047 = (mTarget.performContextMenuAction(id));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1809154939 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1809154939;
        // ---------- Original Method ----------
        //return mTarget.performContextMenuAction(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.306 -0400", hash_original_method = "AAA3AB8A2808B740C08D8BCAC6EF593C", hash_generated_method = "6826361AE4C27B2D58B387BA01D0473A")
    public boolean beginBatchEdit() {
        boolean var6A5D8292BB8C6D7DF5614EEA02F1A27E_1217155485 = (mTarget.beginBatchEdit());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_107692820 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_107692820;
        // ---------- Original Method ----------
        //return mTarget.beginBatchEdit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.306 -0400", hash_original_method = "C936839A69151952786EDD11909238AD", hash_generated_method = "32C34B0B5E421142553EB855C56F24CD")
    public boolean endBatchEdit() {
        boolean varB2F6CEB6E86467F58E548706DFC70F44_627896272 = (mTarget.endBatchEdit());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_37108948 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_37108948;
        // ---------- Original Method ----------
        //return mTarget.endBatchEdit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.307 -0400", hash_original_method = "9D024620F1B53C75FE915B021E654688", hash_generated_method = "6C6D6BA5C61FBA2F3287DA432B647504")
    public boolean sendKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        boolean var0455F970ECE51DCD1EE9789520002940_1203022129 = (mTarget.sendKeyEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_17558696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_17558696;
        // ---------- Original Method ----------
        //return mTarget.sendKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.307 -0400", hash_original_method = "475264A381587BF32EFFB4A3D00FD07C", hash_generated_method = "8D0E97D33BA16D84C920549C7C9D39B2")
    public boolean clearMetaKeyStates(int states) {
        addTaint(states);
        boolean varCCCED7002BB65D362378C1146DA9063A_203653106 = (mTarget.clearMetaKeyStates(states));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1865193419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1865193419;
        // ---------- Original Method ----------
        //return mTarget.clearMetaKeyStates(states);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.307 -0400", hash_original_method = "F1C831DAF80FFACCBD0D484BA3C71C5A", hash_generated_method = "F3A0092DC5805DE7945D7C38B58F4B9C")
    public boolean reportFullscreenMode(boolean enabled) {
        addTaint(enabled);
        boolean varEC6DD1C6D15280F19E17449AF7B11B11_1943486196 = (mTarget.reportFullscreenMode(enabled));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432908978 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432908978;
        // ---------- Original Method ----------
        //return mTarget.reportFullscreenMode(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.308 -0400", hash_original_method = "E30515F5F44630827F2EF8B8A6D02C04", hash_generated_method = "B89F739CA4DC2A7482B1F08D246D783A")
    public boolean performPrivateCommand(String action, Bundle data) {
        addTaint(data.getTaint());
        addTaint(action.getTaint());
        boolean varC6F8D70C4945426EDD03B973F9B74A63_347367922 = (mTarget.performPrivateCommand(action, data));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_450047192 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_450047192;
        // ---------- Original Method ----------
        //return mTarget.performPrivateCommand(action, data);
    }

    
}

