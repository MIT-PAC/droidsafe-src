package android.view.inputmethod;

// Droidsafe Imports
import android.os.Bundle;
import android.view.KeyEvent;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class InputConnectionWrapper implements InputConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.552 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "151AD6A9E57045A4F9C7E4BD9FA7D17C")

    private InputConnection mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.552 -0400", hash_original_field = "8B26166D49D46DD42D28BC31D8611167", hash_generated_field = "899CF99A8BCFC1DC9FF2AE2242A53A1C")

    boolean mMutable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.552 -0400", hash_original_method = "0AE68A627B838EA5D1B587AAFC2A6012", hash_generated_method = "0D40975779983148B7EF1CDAACB54681")
    public  InputConnectionWrapper(InputConnection target, boolean mutable) {
        mMutable = mutable;
        mTarget = target;
        // ---------- Original Method ----------
        //mMutable = mutable;
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.552 -0400", hash_original_method = "B3C6A81D2BBBD36FEBF3ECE06B5CDD0C", hash_generated_method = "4247B6CA7C45A618C07D173ACAA72C6C")
    public void setTarget(InputConnection target) {
        if(mTarget != null && !mMutable)        
        {
            SecurityException varB2C8147036581E1A424B6B9EF3D268CB_442355767 = new SecurityException("not mutable");
            varB2C8147036581E1A424B6B9EF3D268CB_442355767.addTaint(taint);
            throw varB2C8147036581E1A424B6B9EF3D268CB_442355767;
        } //End block
        mTarget = target;
        // ---------- Original Method ----------
        //if (mTarget != null && !mMutable) {
            //throw new SecurityException("not mutable");
        //}
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.552 -0400", hash_original_method = "70D1E90906EDA66AADA5E9E7AF314024", hash_generated_method = "F73D9533D9867A77071B694CEDCBB850")
    public CharSequence getTextBeforeCursor(int n, int flags) {
        addTaint(flags);
        addTaint(n);
CharSequence var96B87C2CE40782AE737B1AF549A6BA9D_252749876 =         mTarget.getTextBeforeCursor(n, flags);
        var96B87C2CE40782AE737B1AF549A6BA9D_252749876.addTaint(taint);
        return var96B87C2CE40782AE737B1AF549A6BA9D_252749876;
        // ---------- Original Method ----------
        //return mTarget.getTextBeforeCursor(n, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.552 -0400", hash_original_method = "511698C68B38701B7124628C33C2BDC9", hash_generated_method = "7B323A4FE83D097FD298F3DFD17CDEB6")
    public CharSequence getTextAfterCursor(int n, int flags) {
        addTaint(flags);
        addTaint(n);
CharSequence var7A97152EE43E119363DC59EFC76018BA_257589604 =         mTarget.getTextAfterCursor(n, flags);
        var7A97152EE43E119363DC59EFC76018BA_257589604.addTaint(taint);
        return var7A97152EE43E119363DC59EFC76018BA_257589604;
        // ---------- Original Method ----------
        //return mTarget.getTextAfterCursor(n, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.552 -0400", hash_original_method = "F94B155A1C8F9C791E6D9828C6F8114B", hash_generated_method = "72542C03273BF75A0888A3E162CADBD6")
    public CharSequence getSelectedText(int flags) {
        addTaint(flags);
CharSequence varE0648B9B32C1F2D9DBB0613161A39A4A_1277713583 =         mTarget.getSelectedText(flags);
        varE0648B9B32C1F2D9DBB0613161A39A4A_1277713583.addTaint(taint);
        return varE0648B9B32C1F2D9DBB0613161A39A4A_1277713583;
        // ---------- Original Method ----------
        //return mTarget.getSelectedText(flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.552 -0400", hash_original_method = "FFC3D29E68F767E6DE7BA85D50A59F74", hash_generated_method = "73D9EDFD93E4F41A0AB9AD219AA13DC1")
    public int getCursorCapsMode(int reqModes) {
        addTaint(reqModes);
        int var9FC17838F3A08458EE9EBBDE9C77C654_969636337 = (mTarget.getCursorCapsMode(reqModes));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287609817 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287609817;
        // ---------- Original Method ----------
        //return mTarget.getCursorCapsMode(reqModes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.553 -0400", hash_original_method = "B46A0C14FE8C4BFCAB3863CCE2B487E1", hash_generated_method = "D5261F884E2A86D5E3F9162BE1A32750")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        addTaint(flags);
        addTaint(request.getTaint());
ExtractedText varD300E0D19816F64B3B9005199AC77447_1541161052 =         mTarget.getExtractedText(request, flags);
        varD300E0D19816F64B3B9005199AC77447_1541161052.addTaint(taint);
        return varD300E0D19816F64B3B9005199AC77447_1541161052;
        // ---------- Original Method ----------
        //return mTarget.getExtractedText(request, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.553 -0400", hash_original_method = "02B0C02DBA209769DC8321464F457D4E", hash_generated_method = "DD1422E3BA7934DA9A67B10C3B3F2255")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        addTaint(rightLength);
        addTaint(leftLength);
        boolean varF47FB3D8A95F64764639FE6403CDEE53_1535372263 = (mTarget.deleteSurroundingText(leftLength, rightLength));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1301506044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1301506044;
        // ---------- Original Method ----------
        //return mTarget.deleteSurroundingText(leftLength, rightLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.553 -0400", hash_original_method = "C347FD161FDEFFB180258C7A61E86611", hash_generated_method = "637AC97B0B727F6D760AF57938446882")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        boolean var0E7405AA93395821257795AFA168FF5B_986319001 = (mTarget.setComposingText(text, newCursorPosition));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_166345350 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_166345350;
        // ---------- Original Method ----------
        //return mTarget.setComposingText(text, newCursorPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.553 -0400", hash_original_method = "EB3F6672BEE71C12075AAA6BA4DB02F1", hash_generated_method = "3C99EA3F15B3DB6A2781E566AC185E4A")
    public boolean setComposingRegion(int start, int end) {
        addTaint(end);
        addTaint(start);
        boolean var450BC7861BD331BA21ED44FE42909224_1877018583 = (mTarget.setComposingRegion(start, end));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1011034616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1011034616;
        // ---------- Original Method ----------
        //return mTarget.setComposingRegion(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.553 -0400", hash_original_method = "09C1683C22BFF62FC14B2B11C262ABDF", hash_generated_method = "7769FCEC71F139E01287FACF7EA2393E")
    public boolean finishComposingText() {
        boolean var3628555D46E319C05B2FC5775B8E8078_1903723883 = (mTarget.finishComposingText());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1362676960 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1362676960;
        // ---------- Original Method ----------
        //return mTarget.finishComposingText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.553 -0400", hash_original_method = "9F195FFD333D6DD92AB286EC5AB03487", hash_generated_method = "86311225D4973ECF78005AF88C972F25")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        boolean varE2CACB4255A2EBC54DEA2A6DC6E5D7E0_1344744060 = (mTarget.commitText(text, newCursorPosition));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_561269494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_561269494;
        // ---------- Original Method ----------
        //return mTarget.commitText(text, newCursorPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.553 -0400", hash_original_method = "947FB54A5439AE99C45577560BDB97CA", hash_generated_method = "8366F18F2B23E4ECBC3F4660947C4AF5")
    public boolean commitCompletion(CompletionInfo text) {
        addTaint(text.getTaint());
        boolean varA7EC751CE9B2CE7301CF32B879120ACF_1953971080 = (mTarget.commitCompletion(text));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_437819600 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_437819600;
        // ---------- Original Method ----------
        //return mTarget.commitCompletion(text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.553 -0400", hash_original_method = "57757FD5C0807A7AB2D953AC1AE2D156", hash_generated_method = "E62DF295AAB596DBC51633130B112D2D")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        addTaint(correctionInfo.getTaint());
        boolean var4ABE7C185CD113281F40511555A2F59E_1655431485 = (mTarget.commitCorrection(correctionInfo));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1755138915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1755138915;
        // ---------- Original Method ----------
        //return mTarget.commitCorrection(correctionInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.553 -0400", hash_original_method = "E434BE133364C8C6947501760AA1AA25", hash_generated_method = "5583740A708F57E9D654B93A2CD2784E")
    public boolean setSelection(int start, int end) {
        addTaint(end);
        addTaint(start);
        boolean var66A8181D4D3FC1B4B272459A34EDDD71_1322885463 = (mTarget.setSelection(start, end));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745787206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_745787206;
        // ---------- Original Method ----------
        //return mTarget.setSelection(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.554 -0400", hash_original_method = "557B358548051EB41CD67FF4BAC9B39C", hash_generated_method = "84EDE916605BEF73ED42AB75D79D2888")
    public boolean performEditorAction(int editorAction) {
        addTaint(editorAction);
        boolean varCBEA2A48C1E14537F48B1F936A5C5707_469178240 = (mTarget.performEditorAction(editorAction));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1439308484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1439308484;
        // ---------- Original Method ----------
        //return mTarget.performEditorAction(editorAction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.554 -0400", hash_original_method = "7FAFD46A8306525DB41EEE6E5B575235", hash_generated_method = "27A762194D4000C5029EC6AD6DD28D53")
    public boolean performContextMenuAction(int id) {
        addTaint(id);
        boolean varB90D6D4C8292A7A77C8B0488103A6AED_166598217 = (mTarget.performContextMenuAction(id));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1450867281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1450867281;
        // ---------- Original Method ----------
        //return mTarget.performContextMenuAction(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.554 -0400", hash_original_method = "AAA3AB8A2808B740C08D8BCAC6EF593C", hash_generated_method = "E83446D1A0249C5887543CCCA90173A1")
    public boolean beginBatchEdit() {
        boolean var6A5D8292BB8C6D7DF5614EEA02F1A27E_1768114759 = (mTarget.beginBatchEdit());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1470146899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1470146899;
        // ---------- Original Method ----------
        //return mTarget.beginBatchEdit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.554 -0400", hash_original_method = "C936839A69151952786EDD11909238AD", hash_generated_method = "91AE4A94066B5ECCAB757B334AD8C8A9")
    public boolean endBatchEdit() {
        boolean varB2F6CEB6E86467F58E548706DFC70F44_158025538 = (mTarget.endBatchEdit());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1088212085 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1088212085;
        // ---------- Original Method ----------
        //return mTarget.endBatchEdit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.554 -0400", hash_original_method = "9D024620F1B53C75FE915B021E654688", hash_generated_method = "835F460A86EF851E1799DEF06302DC0A")
    public boolean sendKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        boolean var0455F970ECE51DCD1EE9789520002940_2052103970 = (mTarget.sendKeyEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_401950206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_401950206;
        // ---------- Original Method ----------
        //return mTarget.sendKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.554 -0400", hash_original_method = "475264A381587BF32EFFB4A3D00FD07C", hash_generated_method = "F0A9C7EDF0852B0580F1648275D65B98")
    public boolean clearMetaKeyStates(int states) {
        addTaint(states);
        boolean varCCCED7002BB65D362378C1146DA9063A_466314873 = (mTarget.clearMetaKeyStates(states));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_453208130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_453208130;
        // ---------- Original Method ----------
        //return mTarget.clearMetaKeyStates(states);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.554 -0400", hash_original_method = "F1C831DAF80FFACCBD0D484BA3C71C5A", hash_generated_method = "9BD9368C4D47408B61289F8D29E0C5D7")
    public boolean reportFullscreenMode(boolean enabled) {
        addTaint(enabled);
        boolean varEC6DD1C6D15280F19E17449AF7B11B11_2069042532 = (mTarget.reportFullscreenMode(enabled));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1813834352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1813834352;
        // ---------- Original Method ----------
        //return mTarget.reportFullscreenMode(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.554 -0400", hash_original_method = "E30515F5F44630827F2EF8B8A6D02C04", hash_generated_method = "401AEF3D8B6205BDD0CCEC4541FA277F")
    public boolean performPrivateCommand(String action, Bundle data) {
        addTaint(data.getTaint());
        addTaint(action.getTaint());
        boolean varC6F8D70C4945426EDD03B973F9B74A63_302867822 = (mTarget.performPrivateCommand(action, data));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1590197106 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1590197106;
        // ---------- Original Method ----------
        //return mTarget.performPrivateCommand(action, data);
    }

    
}

