package android.opengl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL10Ext;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;
import javax.microedition.khronos.opengles.GL11ExtensionPack;




abstract class GLWrapperBase implements GL, GL10, GL10Ext, GL11, GL11Ext, GL11ExtensionPack {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:10.290 -0500", hash_original_field = "C120FEFA1028301888C6B36B6FCBCABD", hash_generated_field = "E6EDB2FCF74C86CBA0CF1495E76DD1BA")


    protected GL10 mgl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:10.292 -0500", hash_original_field = "E25B46B320368B19BB3CF3E5E724D4A0", hash_generated_field = "D0E3CCA149E553447A379FFD4CF9E9C8")

    protected GL10Ext mgl10Ext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:10.295 -0500", hash_original_field = "F03B5AE45658752F0B5EEAA197BF38DA", hash_generated_field = "3E7CA8CF12DD10E2B0A2E24932346826")

    protected GL11 mgl11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:10.297 -0500", hash_original_field = "5B6B5E3C17E31C7981821DCAB50569FB", hash_generated_field = "B4A363E482954361704E7CED2894B2E0")

    protected GL11Ext mgl11Ext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:10.299 -0500", hash_original_field = "E33AAB8352A2BC0D94A35ED959CF7E25", hash_generated_field = "68BFC218C5F71A28138E3BE916161F71")

    protected GL11ExtensionPack mgl11ExtensionPack;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:10.288 -0500", hash_original_method = "B36031ED922ABC4425023B0E6A7BD8D3", hash_generated_method = "40EB1BD7AB5E6850F9CEA9C50D74B360")
    
public GLWrapperBase(GL gl) {
        mgl = (GL10) gl;
        if (gl instanceof GL10Ext) {
            mgl10Ext = (GL10Ext) gl;
        }
        if (gl instanceof GL11) {
            mgl11 = (GL11) gl;
        }
        if (gl instanceof GL11Ext) {
            mgl11Ext = (GL11Ext) gl;
        }
        if (gl instanceof GL11ExtensionPack) {
            mgl11ExtensionPack = (GL11ExtensionPack) gl;
        }
    }

    
}

