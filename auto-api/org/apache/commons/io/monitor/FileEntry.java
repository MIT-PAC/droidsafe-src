package org.apache.commons.io.monitor;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.Serializable;

public class FileEntry implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.187 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "AB8F542161143C49D5F1CBC35DA2FB78")

    private FileEntry parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.187 -0400", hash_original_field = "268184C12DF027F536154D099D497B31", hash_generated_field = "61D578E413FC2348E3E1154CB71E41C8")

    private FileEntry[] children;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.187 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "5939D876DBC3E83D21864E039D43CB17")

    private File file;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.187 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.187 -0400", hash_original_field = "E087923EB5DD1310F5F25DDD5AE5B580", hash_generated_field = "505F505B095BB43877BCB3856B231199")

    private boolean exists;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.187 -0400", hash_original_field = "5F8F22B8CDBAEEE8CF857673A9B6BA20", hash_generated_field = "8ECB8B39ECBB42A822DE1CBA9484C0D7")

    private boolean directory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.187 -0400", hash_original_field = "56D4CE3ADDD9E0185B21EB938EA5BC79", hash_generated_field = "7413EEC48F4CDDAF3E1A4FB26C30C26A")

    private long lastModified;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.187 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C62D106264E132930C7955708C9A9CDD")

    private long length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.187 -0400", hash_original_method = "F06723331BD74012E73A257B3AB1A276", hash_generated_method = "39199C50366C024FB0520A08B57434DA")
    public  FileEntry(File file) {
        this((FileEntry)null, file);
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.188 -0400", hash_original_method = "1FCFFF4C4B05283E11E5CDF35E8EF21D", hash_generated_method = "80E51F2A31C364E5756E80F0816A64B9")
    public  FileEntry(FileEntry parent, File file) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("File is missing");
        } //End block
        this.file = file;
        this.parent = parent;
        this.name = file.getName();
        // ---------- Original Method ----------
        //if (file == null) {
            //throw new IllegalArgumentException("File is missing");
        //}
        //this.file = file;
        //this.parent = parent;
        //this.name = file.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.189 -0400", hash_original_method = "0DE464E0982739533C2F4153E8EF2E0E", hash_generated_method = "8CF86B536721758AA1E3700C9F6A5A04")
    public boolean refresh(File file) {
        boolean origExists;
        origExists = exists;
        long origLastModified;
        origLastModified = lastModified;
        boolean origDirectory;
        origDirectory = directory;
        long origLength;
        origLength = length;
        name         = file.getName();
        exists       = file.exists();
        directory    = exists ? file.isDirectory() : false;
        lastModified = exists ? file.lastModified() : 0;
        length       = exists && !directory ? file.length() : 0;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1611106776 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1611106776;
        // ---------- Original Method ----------
        //boolean origExists       = exists;
        //long    origLastModified = lastModified;
        //boolean origDirectory    = directory;
        //long    origLength       = length;
        //name         = file.getName();
        //exists       = file.exists();
        //directory    = exists ? file.isDirectory() : false;
        //lastModified = exists ? file.lastModified() : 0;
        //length       = exists && !directory ? file.length() : 0;
        //return exists != origExists ||
                //lastModified != origLastModified ||
                //directory != origDirectory ||
                //length != origLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.189 -0400", hash_original_method = "C3CF0DDAA6E3B0E070C32CB96AD599A3", hash_generated_method = "DA2F1A664E5B0D452B042FFF9AAD0054")
    public FileEntry newChildInstance(File file) {
        FileEntry varB4EAC82CA7396A68D541C85D26508E83_1978278777 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1978278777 = new FileEntry(this, file);
        addTaint(file.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1978278777.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1978278777;
        // ---------- Original Method ----------
        //return new FileEntry(this, file);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.190 -0400", hash_original_method = "E901EC28060B8CBB43FD892C561AF89D", hash_generated_method = "BE41087DEABD3B0E796201E9ECEF6CF6")
    public FileEntry getParent() {
        FileEntry varB4EAC82CA7396A68D541C85D26508E83_2147322278 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2147322278 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_2147322278.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2147322278;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.190 -0400", hash_original_method = "413C128DCD3997E04683C45E9C65F6CD", hash_generated_method = "5CBB5A9604B8DE4B8C018F38A4F33741")
    public int getLevel() {
        {
            Object var5BDD3AB4EB1FEF49E643AD2E7E01BEFD_1825044220 = (parent.getLevel() + 1);
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_860952030 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_860952030;
        // ---------- Original Method ----------
        //return parent == null ? 0 : parent.getLevel() + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.200 -0400", hash_original_method = "ACDB7EF7822C47BD2D0D3497DD2FEBDF", hash_generated_method = "24006BDB7B36C161307D028DF04FC501")
    public FileEntry[] getChildren() {
        FileEntry[] varB4EAC82CA7396A68D541C85D26508E83_357047911 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_357047911 = children != null ? children : EMPTY_ENTRIES;
        varB4EAC82CA7396A68D541C85D26508E83_357047911.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_357047911;
        // ---------- Original Method ----------
        //return children != null ? children : EMPTY_ENTRIES;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.201 -0400", hash_original_method = "587FA5041C73C3087DE3CB88D2A7F1CB", hash_generated_method = "1B31D5E6D443CA2AAC2829B171768740")
    public void setChildren(FileEntry[] children) {
        this.children = children;
        // ---------- Original Method ----------
        //this.children = children;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.201 -0400", hash_original_method = "254E9EB55B544E07E2A606FED2225F70", hash_generated_method = "73EE276F88DD6FC9B30D1D61AD2E5724")
    public File getFile() {
        File varB4EAC82CA7396A68D541C85D26508E83_1103312666 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1103312666 = file;
        varB4EAC82CA7396A68D541C85D26508E83_1103312666.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1103312666;
        // ---------- Original Method ----------
        //return file;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.202 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "B783DC505B271E353118C4B0B68E55CF")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1807578111 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1807578111 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1807578111.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1807578111;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.202 -0400", hash_original_method = "4E95676967FCA987BCDC250B6108BD3E", hash_generated_method = "AEBF0D0A78042CDDF2090E58AA011167")
    public void setName(String name) {
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.202 -0400", hash_original_method = "48BC8D6785D5FA81609A53C9AB85BFFF", hash_generated_method = "BE58EA96CC81CDCD123B2846D53E688B")
    public long getLastModified() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_461186928 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_461186928;
        // ---------- Original Method ----------
        //return lastModified;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.215 -0400", hash_original_method = "4769525BF69184C943BEA4470C0C150B", hash_generated_method = "3D4B81C900641EACAC75B70F88AC1A1D")
    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
        // ---------- Original Method ----------
        //this.lastModified = lastModified;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.215 -0400", hash_original_method = "6D7E57BF471A54D84FC53DAB447C1A65", hash_generated_method = "07E662BA7F3D43ED5D5C6404592460D8")
    public long getLength() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_329396680 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_329396680;
        // ---------- Original Method ----------
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.215 -0400", hash_original_method = "D2825C543F9D9C1BBCF7888DEA8DC401", hash_generated_method = "89A080F56C7C8A6B19E42832FA196136")
    public void setLength(long length) {
        this.length = length;
        // ---------- Original Method ----------
        //this.length = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.215 -0400", hash_original_method = "6F66D971E54163B78A2414F4E7CCFEB2", hash_generated_method = "539459E872743018602DCD2D1912CD04")
    public boolean isExists() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1442606287 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1442606287;
        // ---------- Original Method ----------
        //return exists;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.216 -0400", hash_original_method = "DBCCE2A0E67E546A8F9C08600E25706B", hash_generated_method = "614929312269B33E99A362B6648D47EE")
    public void setExists(boolean exists) {
        this.exists = exists;
        // ---------- Original Method ----------
        //this.exists = exists;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.216 -0400", hash_original_method = "D7E00245883AF8971102F357EED1C8FA", hash_generated_method = "6CCE9D8D1AD1BD381F77C0FA7630ABAA")
    public boolean isDirectory() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_773748063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_773748063;
        // ---------- Original Method ----------
        //return directory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.216 -0400", hash_original_method = "519AC241C832EFA564E71C1E0C949985", hash_generated_method = "AEF1A4272964B36326D71FAE0DFF162E")
    public void setDirectory(boolean directory) {
        this.directory = directory;
        // ---------- Original Method ----------
        //this.directory = directory;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.216 -0400", hash_original_field = "CFA4A1CD80F3D5A3BEE5D63B8091D361", hash_generated_field = "A6AF0A440ECF8670718DB49C61A89660")

    static FileEntry[] EMPTY_ENTRIES = new FileEntry[0];
}

