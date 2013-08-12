package android.opengl;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL10Ext;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;
import javax.microedition.khronos.opengles.GL11ExtensionPack;




abstract class GLWrapperBase implements GL, GL10, GL10Ext, GL11, GL11Ext, GL11ExtensionPack {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.387 -0400", hash_original_field = "738F144B1775BE154D22E9640CE970EF", hash_generated_field = "E6EDB2FCF74C86CBA0CF1495E76DD1BA")

    protected GL10 mgl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.387 -0400", hash_original_field = "72288D9E1F436990298D15F12EEEDE41", hash_generated_field = "D0E3CCA149E553447A379FFD4CF9E9C8")

    protected GL10Ext mgl10Ext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.387 -0400", hash_original_field = "B143DCD4510165E286842055F735F96D", hash_generated_field = "3E7CA8CF12DD10E2B0A2E24932346826")

    protected GL11 mgl11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.387 -0400", hash_original_field = "B50433D468DB4E3C800B7AA484C2D862", hash_generated_field = "B4A363E482954361704E7CED2894B2E0")

    protected GL11Ext mgl11Ext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.387 -0400", hash_original_field = "B400873EF591D5B42A9A5C384E298319", hash_generated_field = "68BFC218C5F71A28138E3BE916161F71")

    protected GL11ExtensionPack mgl11ExtensionPack;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.388 -0400", hash_original_method = "B36031ED922ABC4425023B0E6A7BD8D3", hash_generated_method = "9BF59016A1EDA3D847EB3E1E7ABF09A0")
    public  GLWrapperBase(GL gl) {
        mgl = (GL10) gl;
        if(gl instanceof GL10Ext)        
        {
            mgl10Ext = (GL10Ext) gl;
        } //End block
        if(gl instanceof GL11)        
        {
            mgl11 = (GL11) gl;
        } //End block
        if(gl instanceof GL11Ext)        
        {
            mgl11Ext = (GL11Ext) gl;
        } //End block
        if(gl instanceof GL11ExtensionPack)        
        {
            mgl11ExtensionPack = (GL11ExtensionPack) gl;
        } //End block
        // ---------- Original Method ----------
        //mgl = (GL10) gl;
        //if (gl instanceof GL10Ext) {
            //mgl10Ext = (GL10Ext) gl;
        //}
        //if (gl instanceof GL11) {
            //mgl11 = (GL11) gl;
        //}
        //if (gl instanceof GL11Ext) {
            //mgl11Ext = (GL11Ext) gl;
        //}
        //if (gl instanceof GL11ExtensionPack) {
            //mgl11ExtensionPack = (GL11ExtensionPack) gl;
        //}
    }

    
}

