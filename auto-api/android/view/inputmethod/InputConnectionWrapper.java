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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.145 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "151AD6A9E57045A4F9C7E4BD9FA7D17C")

    private InputConnection mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.145 -0400", hash_original_field = "8B26166D49D46DD42D28BC31D8611167", hash_generated_field = "899CF99A8BCFC1DC9FF2AE2242A53A1C")

    boolean mMutable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.145 -0400", hash_original_method = "0AE68A627B838EA5D1B587AAFC2A6012", hash_generated_method = "0D40975779983148B7EF1CDAACB54681")
    public  InputConnectionWrapper(InputConnection target, boolean mutable) {
        mMutable = mutable;
        mTarget = target;
        // ---------- Original Method ----------
        //mMutable = mutable;
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.145 -0400", hash_original_method = "B3C6A81D2BBBD36FEBF3ECE06B5CDD0C", hash_generated_method = "F82D464B249606601CC725E8AE65402B")
    public void setTarget(InputConnection target) {
        {
            if (DroidSafeAndroidRuntime.control) throw new SecurityException("not mutable");
        } //End block
        mTarget = target;
        // ---------- Original Method ----------
        //if (mTarget != null && !mMutable) {
            //throw new SecurityException("not mutable");
        //}
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.146 -0400", hash_original_method = "70D1E90906EDA66AADA5E9E7AF314024", hash_generated_method = "D46287BAA982FF8330EB0F9013B1800A")
    public CharSequence getTextBeforeCursor(int n, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2021882317 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2021882317 = mTarget.getTextBeforeCursor(n, flags);
        addTaint(n);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_2021882317.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2021882317;
        // ---------- Original Method ----------
        //return mTarget.getTextBeforeCursor(n, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.147 -0400", hash_original_method = "511698C68B38701B7124628C33C2BDC9", hash_generated_method = "914294EBD95E0CDBCCA8A4CB169AB646")
    public CharSequence getTextAfterCursor(int n, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_461421782 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_461421782 = mTarget.getTextAfterCursor(n, flags);
        addTaint(n);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_461421782.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_461421782;
        // ---------- Original Method ----------
        //return mTarget.getTextAfterCursor(n, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.148 -0400", hash_original_method = "F94B155A1C8F9C791E6D9828C6F8114B", hash_generated_method = "6CB5E113773107543256B27399D82BB0")
    public CharSequence getSelectedText(int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1486083131 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1486083131 = mTarget.getSelectedText(flags);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1486083131.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1486083131;
        // ---------- Original Method ----------
        //return mTarget.getSelectedText(flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.148 -0400", hash_original_method = "FFC3D29E68F767E6DE7BA85D50A59F74", hash_generated_method = "8B442FBDDF67DFC376848A2FD36FC78B")
    public int getCursorCapsMode(int reqModes) {
        int var9EE55FD6B4FBDC45EA575015179961A6_842731263 = (mTarget.getCursorCapsMode(reqModes));
        addTaint(reqModes);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1303445295 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1303445295;
        // ---------- Original Method ----------
        //return mTarget.getCursorCapsMode(reqModes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.149 -0400", hash_original_method = "B46A0C14FE8C4BFCAB3863CCE2B487E1", hash_generated_method = "756EEDBC97BB50FEFEBD1E28F9865E62")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_380664069 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_380664069 = mTarget.getExtractedText(request, flags);
        addTaint(request.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_380664069.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_380664069;
        // ---------- Original Method ----------
        //return mTarget.getExtractedText(request, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.149 -0400", hash_original_method = "02B0C02DBA209769DC8321464F457D4E", hash_generated_method = "8579F8C70D148D21FE9D6CB0D51B05F0")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        boolean var45116ED4C8217487542A34411482CB87_856351670 = (mTarget.deleteSurroundingText(leftLength, rightLength));
        addTaint(leftLength);
        addTaint(rightLength);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1592900194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1592900194;
        // ---------- Original Method ----------
        //return mTarget.deleteSurroundingText(leftLength, rightLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.155 -0400", hash_original_method = "C347FD161FDEFFB180258C7A61E86611", hash_generated_method = "CB912D8CBBAE3A1C7173BE1D0D7A8EF1")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        boolean varA982CA5A0D886EDE7E6BF0FA3AF98FEC_80177831 = (mTarget.setComposingText(text, newCursorPosition));
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1781495592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1781495592;
        // ---------- Original Method ----------
        //return mTarget.setComposingText(text, newCursorPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.160 -0400", hash_original_method = "EB3F6672BEE71C12075AAA6BA4DB02F1", hash_generated_method = "AA0F8C5A97FDC9ABDE404E0B14EDC98A")
    public boolean setComposingRegion(int start, int end) {
        boolean var762675F5FAF75E5CED1A54C381C535FF_1820373467 = (mTarget.setComposingRegion(start, end));
        addTaint(start);
        addTaint(end);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_285289275 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_285289275;
        // ---------- Original Method ----------
        //return mTarget.setComposingRegion(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.161 -0400", hash_original_method = "09C1683C22BFF62FC14B2B11C262ABDF", hash_generated_method = "7419574010F2BCC1F377E2AB64FA708A")
    public boolean finishComposingText() {
        boolean var2B42F6570BC498400794E28B24E4AD52_1651800386 = (mTarget.finishComposingText());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1634316331 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1634316331;
        // ---------- Original Method ----------
        //return mTarget.finishComposingText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.161 -0400", hash_original_method = "9F195FFD333D6DD92AB286EC5AB03487", hash_generated_method = "A9D3CFC2DACDED91B4EC09E1BBBDD01E")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        boolean varAEEF99E9BA25A66965AF36A33AE4448C_1870995912 = (mTarget.commitText(text, newCursorPosition));
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1696767499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1696767499;
        // ---------- Original Method ----------
        //return mTarget.commitText(text, newCursorPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.161 -0400", hash_original_method = "947FB54A5439AE99C45577560BDB97CA", hash_generated_method = "ED6F55A1F59E69B22D6E1AB027E9579C")
    public boolean commitCompletion(CompletionInfo text) {
        boolean var78AF5FC2EB00EA73DF91FACCC2E4C678_1654536412 = (mTarget.commitCompletion(text));
        addTaint(text.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1479633058 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1479633058;
        // ---------- Original Method ----------
        //return mTarget.commitCompletion(text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.161 -0400", hash_original_method = "57757FD5C0807A7AB2D953AC1AE2D156", hash_generated_method = "CF80EB6094BFE5FA83366A0E7B0E061F")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean var1980FAB352C02C42EB774650FB2B1633_903162834 = (mTarget.commitCorrection(correctionInfo));
        addTaint(correctionInfo.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1178677722 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1178677722;
        // ---------- Original Method ----------
        //return mTarget.commitCorrection(correctionInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.162 -0400", hash_original_method = "E434BE133364C8C6947501760AA1AA25", hash_generated_method = "74F5B80ABCC175C305EA608FBADFC8CC")
    public boolean setSelection(int start, int end) {
        boolean var4B891C6D551CBDEBD7831B91FD37B5DD_346904603 = (mTarget.setSelection(start, end));
        addTaint(start);
        addTaint(end);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046363906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046363906;
        // ---------- Original Method ----------
        //return mTarget.setSelection(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.168 -0400", hash_original_method = "557B358548051EB41CD67FF4BAC9B39C", hash_generated_method = "BDD8963309763D6EF7BD6700792242AF")
    public boolean performEditorAction(int editorAction) {
        boolean var84EC45BFB502D3BC219C0F7C40BA28B9_945411730 = (mTarget.performEditorAction(editorAction));
        addTaint(editorAction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_169386093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_169386093;
        // ---------- Original Method ----------
        //return mTarget.performEditorAction(editorAction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.168 -0400", hash_original_method = "7FAFD46A8306525DB41EEE6E5B575235", hash_generated_method = "63422EDD0650C0CB5E8DD2BB6D04C2A6")
    public boolean performContextMenuAction(int id) {
        boolean var62EF000C3F76EBF17D805561970CDB9C_341334819 = (mTarget.performContextMenuAction(id));
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_503966930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_503966930;
        // ---------- Original Method ----------
        //return mTarget.performContextMenuAction(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.181 -0400", hash_original_method = "AAA3AB8A2808B740C08D8BCAC6EF593C", hash_generated_method = "FBD93EE4F50A89A66EED6E71108B4394")
    public boolean beginBatchEdit() {
        boolean var74E174EAB39C2BA33E5196F0BDB608A6_282251612 = (mTarget.beginBatchEdit());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1887550614 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1887550614;
        // ---------- Original Method ----------
        //return mTarget.beginBatchEdit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.181 -0400", hash_original_method = "C936839A69151952786EDD11909238AD", hash_generated_method = "F60B74EF7A728DDDA07581079A50A9BA")
    public boolean endBatchEdit() {
        boolean varF32E5DCB095620E3250A82A69A18BDEE_169756702 = (mTarget.endBatchEdit());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1935282060 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1935282060;
        // ---------- Original Method ----------
        //return mTarget.endBatchEdit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.182 -0400", hash_original_method = "9D024620F1B53C75FE915B021E654688", hash_generated_method = "247114A120043BF36EF33A6D0CD34D05")
    public boolean sendKeyEvent(KeyEvent event) {
        boolean var2A77D6CA71E1F639C98AEA00E6C6C331_1047177980 = (mTarget.sendKeyEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_206137604 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_206137604;
        // ---------- Original Method ----------
        //return mTarget.sendKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.182 -0400", hash_original_method = "475264A381587BF32EFFB4A3D00FD07C", hash_generated_method = "D7D8EC12833BEAB85E5B67FDBA5F07C4")
    public boolean clearMetaKeyStates(int states) {
        boolean var42AE0461FEEA3AB39F105AD33BC20A8B_1030843327 = (mTarget.clearMetaKeyStates(states));
        addTaint(states);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2071245367 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2071245367;
        // ---------- Original Method ----------
        //return mTarget.clearMetaKeyStates(states);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.183 -0400", hash_original_method = "F1C831DAF80FFACCBD0D484BA3C71C5A", hash_generated_method = "74ED5E1A08CE56C4FAAA10F178B90F35")
    public boolean reportFullscreenMode(boolean enabled) {
        boolean varB3A17CD338DC9698C72C6A034048B387_1409808930 = (mTarget.reportFullscreenMode(enabled));
        addTaint(enabled);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_406819683 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_406819683;
        // ---------- Original Method ----------
        //return mTarget.reportFullscreenMode(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.186 -0400", hash_original_method = "E30515F5F44630827F2EF8B8A6D02C04", hash_generated_method = "0CBACD902F3F768752CF00F26C0A9F1A")
    public boolean performPrivateCommand(String action, Bundle data) {
        boolean varF5E003B6767EB81A93859360509DE14D_107752968 = (mTarget.performPrivateCommand(action, data));
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1817742086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1817742086;
        // ---------- Original Method ----------
        //return mTarget.performPrivateCommand(action, data);
    }

    
}

