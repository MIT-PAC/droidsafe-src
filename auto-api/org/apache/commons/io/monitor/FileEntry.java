package org.apache.commons.io.monitor;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.Serializable;

public class FileEntry implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.565 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "AB8F542161143C49D5F1CBC35DA2FB78")

    private FileEntry parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.565 -0400", hash_original_field = "268184C12DF027F536154D099D497B31", hash_generated_field = "61D578E413FC2348E3E1154CB71E41C8")

    private FileEntry[] children;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.565 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "5939D876DBC3E83D21864E039D43CB17")

    private File file;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.565 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.565 -0400", hash_original_field = "E087923EB5DD1310F5F25DDD5AE5B580", hash_generated_field = "505F505B095BB43877BCB3856B231199")

    private boolean exists;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.565 -0400", hash_original_field = "5F8F22B8CDBAEEE8CF857673A9B6BA20", hash_generated_field = "8ECB8B39ECBB42A822DE1CBA9484C0D7")

    private boolean directory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.565 -0400", hash_original_field = "56D4CE3ADDD9E0185B21EB938EA5BC79", hash_generated_field = "7413EEC48F4CDDAF3E1A4FB26C30C26A")

    private long lastModified;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.565 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C62D106264E132930C7955708C9A9CDD")

    private long length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.566 -0400", hash_original_method = "F06723331BD74012E73A257B3AB1A276", hash_generated_method = "39199C50366C024FB0520A08B57434DA")
    public  FileEntry(File file) {
        this((FileEntry)null, file);
        addTaint(file.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.566 -0400", hash_original_method = "1FCFFF4C4B05283E11E5CDF35E8EF21D", hash_generated_method = "80E51F2A31C364E5756E80F0816A64B9")
    public  FileEntry(FileEntry parent, File file) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("File is missing");
        } 
        this.file = file;
        this.parent = parent;
        this.name = file.getName();
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.566 -0400", hash_original_method = "0DE464E0982739533C2F4153E8EF2E0E", hash_generated_method = "76AE421A497A3FB8D3BB3B12469E6530")
    public boolean refresh(File file) {
        boolean origExists = exists;
        long origLastModified = lastModified;
        boolean origDirectory = directory;
        long origLength = length;
        name         = file.getName();
        exists       = file.exists();
        directory    = exists ? file.isDirectory() : false;
        lastModified = exists ? file.lastModified() : 0;
        length       = exists && !directory ? file.length() : 0;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_680619913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_680619913;
        
        
        
        
        
        
        
        
        
        
        
                
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.567 -0400", hash_original_method = "C3CF0DDAA6E3B0E070C32CB96AD599A3", hash_generated_method = "087E680DC1E0CA4778734656D327295A")
    public FileEntry newChildInstance(File file) {
        FileEntry varB4EAC82CA7396A68D541C85D26508E83_1445853363 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1445853363 = new FileEntry(this, file);
        addTaint(file.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1445853363.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1445853363;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.567 -0400", hash_original_method = "E901EC28060B8CBB43FD892C561AF89D", hash_generated_method = "D78BF6947E22E0B8C3C6872538A2C144")
    public FileEntry getParent() {
        FileEntry varB4EAC82CA7396A68D541C85D26508E83_92963894 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_92963894 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_92963894.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_92963894;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.568 -0400", hash_original_method = "413C128DCD3997E04683C45E9C65F6CD", hash_generated_method = "E02BF4DDA9ED80CA51433491DDE1B703")
    public int getLevel() {
        {
            Object var5BDD3AB4EB1FEF49E643AD2E7E01BEFD_1036287960 = (parent.getLevel() + 1);
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1115176128 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1115176128;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.569 -0400", hash_original_method = "ACDB7EF7822C47BD2D0D3497DD2FEBDF", hash_generated_method = "D55993C6AFE11F1E6B06D423382B1F54")
    public FileEntry[] getChildren() {
        FileEntry[] varB4EAC82CA7396A68D541C85D26508E83_2108447624 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2108447624 = children != null ? children : EMPTY_ENTRIES;
        varB4EAC82CA7396A68D541C85D26508E83_2108447624.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2108447624;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.569 -0400", hash_original_method = "587FA5041C73C3087DE3CB88D2A7F1CB", hash_generated_method = "1B31D5E6D443CA2AAC2829B171768740")
    public void setChildren(FileEntry[] children) {
        this.children = children;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.570 -0400", hash_original_method = "254E9EB55B544E07E2A606FED2225F70", hash_generated_method = "DB42B836EAABAB3279D8D59E4324BFB7")
    public File getFile() {
        File varB4EAC82CA7396A68D541C85D26508E83_402063931 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_402063931 = file;
        varB4EAC82CA7396A68D541C85D26508E83_402063931.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_402063931;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.571 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "34CF868D6E1537FE6E460C36E918AC29")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1180399610 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1180399610 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1180399610.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1180399610;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.571 -0400", hash_original_method = "4E95676967FCA987BCDC250B6108BD3E", hash_generated_method = "AEBF0D0A78042CDDF2090E58AA011167")
    public void setName(String name) {
        this.name = name;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.571 -0400", hash_original_method = "48BC8D6785D5FA81609A53C9AB85BFFF", hash_generated_method = "E28B6E9216919AC5F21AF74118AB17FC")
    public long getLastModified() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1708751942 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1708751942;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.572 -0400", hash_original_method = "4769525BF69184C943BEA4470C0C150B", hash_generated_method = "3D4B81C900641EACAC75B70F88AC1A1D")
    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.572 -0400", hash_original_method = "6D7E57BF471A54D84FC53DAB447C1A65", hash_generated_method = "F7A08BA651337F5EBC73FB60C52ADF54")
    public long getLength() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_991344985 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_991344985;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.572 -0400", hash_original_method = "D2825C543F9D9C1BBCF7888DEA8DC401", hash_generated_method = "89A080F56C7C8A6B19E42832FA196136")
    public void setLength(long length) {
        this.length = length;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.573 -0400", hash_original_method = "6F66D971E54163B78A2414F4E7CCFEB2", hash_generated_method = "0A24005E6ACED345D5F434A0F608E475")
    public boolean isExists() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_393276460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_393276460;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.573 -0400", hash_original_method = "DBCCE2A0E67E546A8F9C08600E25706B", hash_generated_method = "614929312269B33E99A362B6648D47EE")
    public void setExists(boolean exists) {
        this.exists = exists;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.573 -0400", hash_original_method = "D7E00245883AF8971102F357EED1C8FA", hash_generated_method = "2E25EF8714F65C0650B9834A7543AF0C")
    public boolean isDirectory() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1035793931 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1035793931;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.574 -0400", hash_original_method = "519AC241C832EFA564E71C1E0C949985", hash_generated_method = "AEF1A4272964B36326D71FAE0DFF162E")
    public void setDirectory(boolean directory) {
        this.directory = directory;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.574 -0400", hash_original_field = "CFA4A1CD80F3D5A3BEE5D63B8091D361", hash_generated_field = "F21C6AADF59E9D671ACBE5D672216EEC")

    static final FileEntry[] EMPTY_ENTRIES = new FileEntry[0];
}

