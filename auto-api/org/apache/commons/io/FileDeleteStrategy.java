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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.658 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.659 -0400", hash_original_method = "B0EB7295797B434E427BAD2BC120E135", hash_generated_method = "D77161C31D1213F45DBAAB3D16CE2AB5")
    protected  FileDeleteStrategy(String name) {
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.662 -0400", hash_original_method = "EFE9EDBED2D379E86C4936EFD5742135", hash_generated_method = "2FC60FBD257168682E83B35400371249")
    public boolean deleteQuietly(File fileToDelete) {
        {
            boolean varDE4B49B39BFAB9C57684AF9A4B7AE794_1908872130 = (fileToDelete == null || fileToDelete.exists() == false);
        } //End collapsed parenthetic
        try 
        {
            boolean varAA9A2E517F70914D98AD971694CF1628_1196622439 = (doDelete(fileToDelete));
        } //End block
        catch (IOException ex)
        { }
        addTaint(fileToDelete.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1646268599 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1646268599;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.662 -0400", hash_original_method = "15784F6E602EC7190D496957E6C6E920", hash_generated_method = "5B9DD293C2F09F152ED942CF276DE4F9")
    public void delete(File fileToDelete) throws IOException {
        {
            boolean var025528C79790A0BA5A26CF0C939F33E7_1645360443 = (fileToDelete.exists() && doDelete(fileToDelete) == false);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.664 -0400", hash_original_method = "57E67E4626031877680FBBC8B7FC5113", hash_generated_method = "3D8FC04AEF141FD668BD77C5D1A9A57E")
    protected boolean doDelete(File fileToDelete) throws IOException {
        boolean var595F19F2AF3AB3B3776BF1C0697AF28C_1001762275 = (fileToDelete.delete());
        addTaint(fileToDelete.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1305050324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1305050324;
        // ---------- Original Method ----------
        //return fileToDelete.delete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.664 -0400", hash_original_method = "0D94F3DF71E8C7CC6D64706F8523FAA4", hash_generated_method = "2E8FB374D35DDE5F2A33FE59673965D2")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_625560323 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_625560323 = "FileDeleteStrategy[" + name + "]";
        varB4EAC82CA7396A68D541C85D26508E83_625560323.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_625560323;
        // ---------- Original Method ----------
        //return "FileDeleteStrategy[" + name + "]";
    }

    
    static class ForceFileDeleteStrategy extends FileDeleteStrategy {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.673 -0400", hash_original_method = "94D227408D8CEC1DBDAAF9B0F3D58F8D", hash_generated_method = "A6F436711D12454D5EC5336BB309C63E")
          ForceFileDeleteStrategy() {
            super("Force");
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.673 -0400", hash_original_method = "36CC05EFC6FFF5A71EED967857A4B132", hash_generated_method = "4A19535F52D46CB950B626148B7EEB22")
        @Override
        protected boolean doDelete(File fileToDelete) throws IOException {
            FileUtils.forceDelete(fileToDelete);
            addTaint(fileToDelete.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1145832122 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1145832122;
            // ---------- Original Method ----------
            //FileUtils.forceDelete(fileToDelete);
            //return true;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.673 -0400", hash_original_field = "154EC2D6E6D57D3F7156C2A042CF0CC2", hash_generated_field = "FD915F51B853AEB745551E70D65F83D2")

    public static final FileDeleteStrategy NORMAL = new FileDeleteStrategy("Normal");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.673 -0400", hash_original_field = "082D7AE45533CB06E01D387A437B8A86", hash_generated_field = "4CDC2D9057B7D8764CC3724A06FBA2A6")

    public static final FileDeleteStrategy FORCE = new ForceFileDeleteStrategy();
}

