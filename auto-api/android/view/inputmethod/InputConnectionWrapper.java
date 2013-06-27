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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.051 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "151AD6A9E57045A4F9C7E4BD9FA7D17C")

    private InputConnection mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.051 -0400", hash_original_field = "8B26166D49D46DD42D28BC31D8611167", hash_generated_field = "899CF99A8BCFC1DC9FF2AE2242A53A1C")

    boolean mMutable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.060 -0400", hash_original_method = "0AE68A627B838EA5D1B587AAFC2A6012", hash_generated_method = "0D40975779983148B7EF1CDAACB54681")
    public  InputConnectionWrapper(InputConnection target, boolean mutable) {
        mMutable = mutable;
        mTarget = target;
        // ---------- Original Method ----------
        //mMutable = mutable;
        //mTarget = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.061 -0400", hash_original_method = "B3C6A81D2BBBD36FEBF3ECE06B5CDD0C", hash_generated_method = "F82D464B249606601CC725E8AE65402B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.065 -0400", hash_original_method = "70D1E90906EDA66AADA5E9E7AF314024", hash_generated_method = "AA75206707E20F1E4F1BC0F78D2B3C0D")
    public CharSequence getTextBeforeCursor(int n, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1742131499 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1742131499 = mTarget.getTextBeforeCursor(n, flags);
        addTaint(n);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1742131499.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1742131499;
        // ---------- Original Method ----------
        //return mTarget.getTextBeforeCursor(n, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.076 -0400", hash_original_method = "511698C68B38701B7124628C33C2BDC9", hash_generated_method = "AF441FD7A29480336E3D92E7087E6CA7")
    public CharSequence getTextAfterCursor(int n, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_142398930 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_142398930 = mTarget.getTextAfterCursor(n, flags);
        addTaint(n);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_142398930.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_142398930;
        // ---------- Original Method ----------
        //return mTarget.getTextAfterCursor(n, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.078 -0400", hash_original_method = "F94B155A1C8F9C791E6D9828C6F8114B", hash_generated_method = "F85324BD51BAB2D654EE7AF3524C9A30")
    public CharSequence getSelectedText(int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_472784630 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_472784630 = mTarget.getSelectedText(flags);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_472784630.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_472784630;
        // ---------- Original Method ----------
        //return mTarget.getSelectedText(flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.088 -0400", hash_original_method = "FFC3D29E68F767E6DE7BA85D50A59F74", hash_generated_method = "9887D01B5CF98E552171F3A4B12329C4")
    public int getCursorCapsMode(int reqModes) {
        int var9EE55FD6B4FBDC45EA575015179961A6_2141487211 = (mTarget.getCursorCapsMode(reqModes));
        addTaint(reqModes);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1323682117 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1323682117;
        // ---------- Original Method ----------
        //return mTarget.getCursorCapsMode(reqModes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.089 -0400", hash_original_method = "B46A0C14FE8C4BFCAB3863CCE2B487E1", hash_generated_method = "4C402BDCDED7AA8586E440606852C2B1")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_1834609226 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1834609226 = mTarget.getExtractedText(request, flags);
        addTaint(request.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1834609226.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1834609226;
        // ---------- Original Method ----------
        //return mTarget.getExtractedText(request, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.089 -0400", hash_original_method = "02B0C02DBA209769DC8321464F457D4E", hash_generated_method = "1994760F887A43F884D2435BB854D42E")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        boolean var45116ED4C8217487542A34411482CB87_277477582 = (mTarget.deleteSurroundingText(leftLength, rightLength));
        addTaint(leftLength);
        addTaint(rightLength);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213794113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213794113;
        // ---------- Original Method ----------
        //return mTarget.deleteSurroundingText(leftLength, rightLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.090 -0400", hash_original_method = "C347FD161FDEFFB180258C7A61E86611", hash_generated_method = "FCCD2E97ABFB2D52331BB94040480860")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        boolean varA982CA5A0D886EDE7E6BF0FA3AF98FEC_654106369 = (mTarget.setComposingText(text, newCursorPosition));
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1298393731 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1298393731;
        // ---------- Original Method ----------
        //return mTarget.setComposingText(text, newCursorPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.091 -0400", hash_original_method = "EB3F6672BEE71C12075AAA6BA4DB02F1", hash_generated_method = "514F39038799E3EC27AC9154E72EB861")
    public boolean setComposingRegion(int start, int end) {
        boolean var762675F5FAF75E5CED1A54C381C535FF_338028921 = (mTarget.setComposingRegion(start, end));
        addTaint(start);
        addTaint(end);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_486554398 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_486554398;
        // ---------- Original Method ----------
        //return mTarget.setComposingRegion(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.099 -0400", hash_original_method = "09C1683C22BFF62FC14B2B11C262ABDF", hash_generated_method = "84272ADE07667CA73370F718E669C88F")
    public boolean finishComposingText() {
        boolean var2B42F6570BC498400794E28B24E4AD52_1049146759 = (mTarget.finishComposingText());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1329079299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1329079299;
        // ---------- Original Method ----------
        //return mTarget.finishComposingText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.100 -0400", hash_original_method = "9F195FFD333D6DD92AB286EC5AB03487", hash_generated_method = "02ECC8870E620DA73B9BCED353C4427A")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        boolean varAEEF99E9BA25A66965AF36A33AE4448C_945334701 = (mTarget.commitText(text, newCursorPosition));
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1478478928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1478478928;
        // ---------- Original Method ----------
        //return mTarget.commitText(text, newCursorPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.100 -0400", hash_original_method = "947FB54A5439AE99C45577560BDB97CA", hash_generated_method = "BE875E08FF544C5F7981EC5E8C1CBFD1")
    public boolean commitCompletion(CompletionInfo text) {
        boolean var78AF5FC2EB00EA73DF91FACCC2E4C678_451218308 = (mTarget.commitCompletion(text));
        addTaint(text.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1156265879 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1156265879;
        // ---------- Original Method ----------
        //return mTarget.commitCompletion(text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.100 -0400", hash_original_method = "57757FD5C0807A7AB2D953AC1AE2D156", hash_generated_method = "C09FF7883CC04F7BFB05460490360E45")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean var1980FAB352C02C42EB774650FB2B1633_286004633 = (mTarget.commitCorrection(correctionInfo));
        addTaint(correctionInfo.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2118791059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2118791059;
        // ---------- Original Method ----------
        //return mTarget.commitCorrection(correctionInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.100 -0400", hash_original_method = "E434BE133364C8C6947501760AA1AA25", hash_generated_method = "E6FBCA3E9729F9DA2CD20B323662EAB0")
    public boolean setSelection(int start, int end) {
        boolean var4B891C6D551CBDEBD7831B91FD37B5DD_1992420019 = (mTarget.setSelection(start, end));
        addTaint(start);
        addTaint(end);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013204631 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013204631;
        // ---------- Original Method ----------
        //return mTarget.setSelection(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.101 -0400", hash_original_method = "557B358548051EB41CD67FF4BAC9B39C", hash_generated_method = "033FAA8F28BA5BB4B7DCD7D648E6F2BC")
    public boolean performEditorAction(int editorAction) {
        boolean var84EC45BFB502D3BC219C0F7C40BA28B9_599231774 = (mTarget.performEditorAction(editorAction));
        addTaint(editorAction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406094576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406094576;
        // ---------- Original Method ----------
        //return mTarget.performEditorAction(editorAction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.101 -0400", hash_original_method = "7FAFD46A8306525DB41EEE6E5B575235", hash_generated_method = "1EF1BF4F8FDC434EA6AA2C76F8CFBDC4")
    public boolean performContextMenuAction(int id) {
        boolean var62EF000C3F76EBF17D805561970CDB9C_661353047 = (mTarget.performContextMenuAction(id));
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_475816638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_475816638;
        // ---------- Original Method ----------
        //return mTarget.performContextMenuAction(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.101 -0400", hash_original_method = "AAA3AB8A2808B740C08D8BCAC6EF593C", hash_generated_method = "2A2B4096B0A86E60C11D00F18AD1DEC7")
    public boolean beginBatchEdit() {
        boolean var74E174EAB39C2BA33E5196F0BDB608A6_1433974016 = (mTarget.beginBatchEdit());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1418227060 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1418227060;
        // ---------- Original Method ----------
        //return mTarget.beginBatchEdit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.113 -0400", hash_original_method = "C936839A69151952786EDD11909238AD", hash_generated_method = "FECCBF4AFED7C6ED7BB401BD509F8CAB")
    public boolean endBatchEdit() {
        boolean varF32E5DCB095620E3250A82A69A18BDEE_821273968 = (mTarget.endBatchEdit());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1925272088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1925272088;
        // ---------- Original Method ----------
        //return mTarget.endBatchEdit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.113 -0400", hash_original_method = "9D024620F1B53C75FE915B021E654688", hash_generated_method = "203E9AA26B4B50E6D6F8830EE57C722C")
    public boolean sendKeyEvent(KeyEvent event) {
        boolean var2A77D6CA71E1F639C98AEA00E6C6C331_908950338 = (mTarget.sendKeyEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_299954041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_299954041;
        // ---------- Original Method ----------
        //return mTarget.sendKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.114 -0400", hash_original_method = "475264A381587BF32EFFB4A3D00FD07C", hash_generated_method = "BA51E0ED5991A0079998B4516BEE4F27")
    public boolean clearMetaKeyStates(int states) {
        boolean var42AE0461FEEA3AB39F105AD33BC20A8B_1303730819 = (mTarget.clearMetaKeyStates(states));
        addTaint(states);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1352513118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1352513118;
        // ---------- Original Method ----------
        //return mTarget.clearMetaKeyStates(states);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.114 -0400", hash_original_method = "F1C831DAF80FFACCBD0D484BA3C71C5A", hash_generated_method = "9C93A9F182FB8DEC3BE7F3805511CC6F")
    public boolean reportFullscreenMode(boolean enabled) {
        boolean varB3A17CD338DC9698C72C6A034048B387_483366932 = (mTarget.reportFullscreenMode(enabled));
        addTaint(enabled);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_349701480 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_349701480;
        // ---------- Original Method ----------
        //return mTarget.reportFullscreenMode(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.114 -0400", hash_original_method = "E30515F5F44630827F2EF8B8A6D02C04", hash_generated_method = "4FB34F6F319600C0A0FF19C68DC71898")
    public boolean performPrivateCommand(String action, Bundle data) {
        boolean varF5E003B6767EB81A93859360509DE14D_162478164 = (mTarget.performPrivateCommand(action, data));
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_182897427 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_182897427;
        // ---------- Original Method ----------
        //return mTarget.performPrivateCommand(action, data);
    }

    
}

