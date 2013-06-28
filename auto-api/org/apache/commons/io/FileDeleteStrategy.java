package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.IOException;

public class FileDeleteStrategy {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.318 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.319 -0400", hash_original_method = "B0EB7295797B434E427BAD2BC120E135", hash_generated_method = "D77161C31D1213F45DBAAB3D16CE2AB5")
    protected  FileDeleteStrategy(String name) {
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.319 -0400", hash_original_method = "EFE9EDBED2D379E86C4936EFD5742135", hash_generated_method = "5EE9CC80971E5BEF47F0261BDBA1157F")
    public boolean deleteQuietly(File fileToDelete) {
        {
            boolean varDE4B49B39BFAB9C57684AF9A4B7AE794_969795378 = (fileToDelete == null || fileToDelete.exists() == false);
        } //End collapsed parenthetic
        try 
        {
            boolean varAA9A2E517F70914D98AD971694CF1628_1351383262 = (doDelete(fileToDelete));
        } //End block
        catch (IOException ex)
        { }
        addTaint(fileToDelete.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_757656333 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_757656333;
        // ---------- Original Method ----------
        //if (fileToDelete == null || fileToDelete.exists() == false) {
            //return true;
        //}
        //try {
            //return doDelete(fileToDelete);
        //} catch (IOException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.320 -0400", hash_original_method = "15784F6E602EC7190D496957E6C6E920", hash_generated_method = "3E5F777AE7D4631BB2673C90889BBCBD")
    public void delete(File fileToDelete) throws IOException {
        {
            boolean var025528C79790A0BA5A26CF0C939F33E7_151481727 = (fileToDelete.exists() && doDelete(fileToDelete) == false);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Deletion failed: " + fileToDelete);
            } //End block
        } //End collapsed parenthetic
        addTaint(fileToDelete.getTaint());
        // ---------- Original Method ----------
        //if (fileToDelete.exists() && doDelete(fileToDelete) == false) {
            //throw new IOException("Deletion failed: " + fileToDelete);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.320 -0400", hash_original_method = "57E67E4626031877680FBBC8B7FC5113", hash_generated_method = "8889EC4111D95EA7EFAD5E1F6EF4ACC3")
    protected boolean doDelete(File fileToDelete) throws IOException {
        boolean var595F19F2AF3AB3B3776BF1C0697AF28C_1171681570 = (fileToDelete.delete());
        addTaint(fileToDelete.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1205749479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1205749479;
        // ---------- Original Method ----------
        //return fileToDelete.delete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.321 -0400", hash_original_method = "0D94F3DF71E8C7CC6D64706F8523FAA4", hash_generated_method = "3055CF09032A0BFC73EED449DB5DB194")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1446377859 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1446377859 = "FileDeleteStrategy[" + name + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1446377859.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1446377859;
        // ---------- Original Method ----------
        //return "FileDeleteStrategy[" + name + "]";
    }

    
    static class ForceFileDeleteStrategy extends FileDeleteStrategy {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.321 -0400", hash_original_method = "94D227408D8CEC1DBDAAF9B0F3D58F8D", hash_generated_method = "A6F436711D12454D5EC5336BB309C63E")
          ForceFileDeleteStrategy() {
            super("Force");
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.322 -0400", hash_original_method = "36CC05EFC6FFF5A71EED967857A4B132", hash_generated_method = "68465937560910BB0A38030C8CF1E5CA")
        @Override
        protected boolean doDelete(File fileToDelete) throws IOException {
            FileUtils.forceDelete(fileToDelete);
            addTaint(fileToDelete.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1127881066 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1127881066;
            // ---------- Original Method ----------
            //FileUtils.forceDelete(fileToDelete);
            //return true;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.322 -0400", hash_original_field = "154EC2D6E6D57D3F7156C2A042CF0CC2", hash_generated_field = "FD915F51B853AEB745551E70D65F83D2")

    public static final FileDeleteStrategy NORMAL = new FileDeleteStrategy("Normal");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.322 -0400", hash_original_field = "082D7AE45533CB06E01D387A437B8A86", hash_generated_field = "4CDC2D9057B7D8764CC3724A06FBA2A6")

    public static final FileDeleteStrategy FORCE = new ForceFileDeleteStrategy();
}

