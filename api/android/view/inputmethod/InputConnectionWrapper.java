package android.view.inputmethod;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Bundle;
import android.view.KeyEvent;

public class InputConnectionWrapper implements InputConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.045 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "151AD6A9E57045A4F9C7E4BD9FA7D17C")

    private InputConnection mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.045 -0400", hash_original_field = "8B26166D49D46DD42D28BC31D8611167", hash_generated_field = "899CF99A8BCFC1DC9FF2AE2242A53A1C")

    boolean mMutable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.045 -0400", hash_original_method = "0AE68A627B838EA5D1B587AAFC2A6012", hash_generated_method = "0D40975779983148B7EF1CDAACB54681")
    public  InputConnectionWrapper(InputConnection target, boolean mutable) {
        mMutable = mutable;
        mTarget = target;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.045 -0400", hash_original_method = "B3C6A81D2BBBD36FEBF3ECE06B5CDD0C", hash_generated_method = "F82D464B249606601CC725E8AE65402B")
    public void setTarget(InputConnection target) {
        {
            if (DroidSafeAndroidRuntime.control) throw new SecurityException("not mutable");
        } 
        mTarget = target;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.046 -0400", hash_original_method = "70D1E90906EDA66AADA5E9E7AF314024", hash_generated_method = "425AED7BD39427C87F14A068A4B80A87")
    public CharSequence getTextBeforeCursor(int n, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_191958700 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_191958700 = mTarget.getTextBeforeCursor(n, flags);
        addTaint(n);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_191958700.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_191958700;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.046 -0400", hash_original_method = "511698C68B38701B7124628C33C2BDC9", hash_generated_method = "614069F70E1E33C31AA6818CD55F97F5")
    public CharSequence getTextAfterCursor(int n, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_785380885 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_785380885 = mTarget.getTextAfterCursor(n, flags);
        addTaint(n);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_785380885.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_785380885;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.047 -0400", hash_original_method = "F94B155A1C8F9C791E6D9828C6F8114B", hash_generated_method = "AC6F5E48ECC81D0BF8158C7B9DE45637")
    public CharSequence getSelectedText(int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_787618626 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_787618626 = mTarget.getSelectedText(flags);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_787618626.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_787618626;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.047 -0400", hash_original_method = "FFC3D29E68F767E6DE7BA85D50A59F74", hash_generated_method = "09DD35F01B9C9C2DA3298DC4A2C4B899")
    public int getCursorCapsMode(int reqModes) {
        int var9EE55FD6B4FBDC45EA575015179961A6_1964042132 = (mTarget.getCursorCapsMode(reqModes));
        addTaint(reqModes);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1346004322 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1346004322;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.048 -0400", hash_original_method = "B46A0C14FE8C4BFCAB3863CCE2B487E1", hash_generated_method = "D1EFC7B3264038BBD27F0356B6A5B51A")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_1888519423 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1888519423 = mTarget.getExtractedText(request, flags);
        addTaint(request.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1888519423.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1888519423;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.049 -0400", hash_original_method = "02B0C02DBA209769DC8321464F457D4E", hash_generated_method = "0FDDDC89AB2E1FAE0D180DA40F4782C0")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        boolean var45116ED4C8217487542A34411482CB87_1650128975 = (mTarget.deleteSurroundingText(leftLength, rightLength));
        addTaint(leftLength);
        addTaint(rightLength);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1242789167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1242789167;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.049 -0400", hash_original_method = "C347FD161FDEFFB180258C7A61E86611", hash_generated_method = "4B01D0786DC9E745A429834E105CFE83")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        boolean varA982CA5A0D886EDE7E6BF0FA3AF98FEC_1181173347 = (mTarget.setComposingText(text, newCursorPosition));
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913512362 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913512362;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.050 -0400", hash_original_method = "EB3F6672BEE71C12075AAA6BA4DB02F1", hash_generated_method = "759B430FFE14BCE18BC42BDAD0FBE26B")
    public boolean setComposingRegion(int start, int end) {
        boolean var762675F5FAF75E5CED1A54C381C535FF_1051463486 = (mTarget.setComposingRegion(start, end));
        addTaint(start);
        addTaint(end);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_690221709 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_690221709;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.050 -0400", hash_original_method = "09C1683C22BFF62FC14B2B11C262ABDF", hash_generated_method = "9B9660807D5DBF7645379AD82F4AF9D4")
    public boolean finishComposingText() {
        boolean var2B42F6570BC498400794E28B24E4AD52_1351003575 = (mTarget.finishComposingText());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_816285120 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_816285120;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.050 -0400", hash_original_method = "9F195FFD333D6DD92AB286EC5AB03487", hash_generated_method = "A9EC2F65A7F5364089888C36B73EA52B")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        boolean varAEEF99E9BA25A66965AF36A33AE4448C_816134011 = (mTarget.commitText(text, newCursorPosition));
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1633974583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1633974583;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.051 -0400", hash_original_method = "947FB54A5439AE99C45577560BDB97CA", hash_generated_method = "C0E580CFC4FEBD03252566594697677D")
    public boolean commitCompletion(CompletionInfo text) {
        boolean var78AF5FC2EB00EA73DF91FACCC2E4C678_1743635661 = (mTarget.commitCompletion(text));
        addTaint(text.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1434078535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1434078535;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.051 -0400", hash_original_method = "57757FD5C0807A7AB2D953AC1AE2D156", hash_generated_method = "6485D785C0F5446F6F61C5184A5C3F19")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean var1980FAB352C02C42EB774650FB2B1633_56265036 = (mTarget.commitCorrection(correctionInfo));
        addTaint(correctionInfo.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_416874403 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_416874403;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.051 -0400", hash_original_method = "E434BE133364C8C6947501760AA1AA25", hash_generated_method = "AF80FA89CC9C1B1BF56C4FC87B525677")
    public boolean setSelection(int start, int end) {
        boolean var4B891C6D551CBDEBD7831B91FD37B5DD_1910537054 = (mTarget.setSelection(start, end));
        addTaint(start);
        addTaint(end);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1130572736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1130572736;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.052 -0400", hash_original_method = "557B358548051EB41CD67FF4BAC9B39C", hash_generated_method = "6A055BB7DBF8D6449E89AD9EB1F83CDA")
    public boolean performEditorAction(int editorAction) {
        boolean var84EC45BFB502D3BC219C0F7C40BA28B9_448416618 = (mTarget.performEditorAction(editorAction));
        addTaint(editorAction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_879613602 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_879613602;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.052 -0400", hash_original_method = "7FAFD46A8306525DB41EEE6E5B575235", hash_generated_method = "5BED114A52041A542350EB375F32760B")
    public boolean performContextMenuAction(int id) {
        boolean var62EF000C3F76EBF17D805561970CDB9C_1487163842 = (mTarget.performContextMenuAction(id));
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92200346 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_92200346;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.052 -0400", hash_original_method = "AAA3AB8A2808B740C08D8BCAC6EF593C", hash_generated_method = "4E7C749F1313AD3CB8983D5B32560592")
    public boolean beginBatchEdit() {
        boolean var74E174EAB39C2BA33E5196F0BDB608A6_815157291 = (mTarget.beginBatchEdit());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1581880146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1581880146;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.052 -0400", hash_original_method = "C936839A69151952786EDD11909238AD", hash_generated_method = "E089A51CCC1A7E3F2E5AEB59B6C4528D")
    public boolean endBatchEdit() {
        boolean varF32E5DCB095620E3250A82A69A18BDEE_1121544682 = (mTarget.endBatchEdit());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_641581577 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_641581577;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.053 -0400", hash_original_method = "9D024620F1B53C75FE915B021E654688", hash_generated_method = "3D9EB13A93F57ACDFDAAF92AEB484A17")
    public boolean sendKeyEvent(KeyEvent event) {
        boolean var2A77D6CA71E1F639C98AEA00E6C6C331_349455533 = (mTarget.sendKeyEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1890237553 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1890237553;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.053 -0400", hash_original_method = "475264A381587BF32EFFB4A3D00FD07C", hash_generated_method = "AD593E91A7DD04D8ACF449F65622E66C")
    public boolean clearMetaKeyStates(int states) {
        boolean var42AE0461FEEA3AB39F105AD33BC20A8B_1685479257 = (mTarget.clearMetaKeyStates(states));
        addTaint(states);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_245332478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_245332478;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.053 -0400", hash_original_method = "F1C831DAF80FFACCBD0D484BA3C71C5A", hash_generated_method = "395A8E586921A2B781F1915263E0A6B1")
    public boolean reportFullscreenMode(boolean enabled) {
        boolean varB3A17CD338DC9698C72C6A034048B387_195274141 = (mTarget.reportFullscreenMode(enabled));
        addTaint(enabled);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1817073975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1817073975;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.053 -0400", hash_original_method = "E30515F5F44630827F2EF8B8A6D02C04", hash_generated_method = "A016AF15D598C1AE76F49E49D3D439FB")
    public boolean performPrivateCommand(String action, Bundle data) {
        boolean varF5E003B6767EB81A93859360509DE14D_1572683204 = (mTarget.performPrivateCommand(action, data));
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1152796305 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1152796305;
        
        
    }

    
}

