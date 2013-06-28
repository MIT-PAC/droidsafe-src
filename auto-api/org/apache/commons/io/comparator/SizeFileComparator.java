package org.apache.commons.io.comparator;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.io.FileUtils;

public class SizeFileComparator extends AbstractFileComparator implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.608 -0400", hash_original_field = "0221D6927D571BDA03580E3B8CC0AE21", hash_generated_field = "845FBEEDDFB3BA53245879B7EF870E22")

    private boolean sumDirectoryContents;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.608 -0400", hash_original_method = "31F2290758882FE23943782B8BDBF92D", hash_generated_method = "59EDEB187BC976038BFA4D25D6383E13")
    public  SizeFileComparator() {
        this.sumDirectoryContents = false;
        // ---------- Original Method ----------
        //this.sumDirectoryContents = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.608 -0400", hash_original_method = "49C48E0E4A3E598D19395DF4B3B95A72", hash_generated_method = "681586C7F7A2032A388A56D2524F8ECB")
    public  SizeFileComparator(boolean sumDirectoryContents) {
        this.sumDirectoryContents = sumDirectoryContents;
        // ---------- Original Method ----------
        //this.sumDirectoryContents = sumDirectoryContents;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.609 -0400", hash_original_method = "ABA0E5A2C93CAE7FB231C0521EE3670F", hash_generated_method = "54C7661C74E9786147B56078B9A5225F")
    public int compare(File file1, File file2) {
        long size1 = 0;
        {
            boolean var9AFBD2E3B236F0DA85317385C2578249_1811763972 = (file1.isDirectory());
            {
                size1 = sumDirectoryContents && file1.exists() ? FileUtils.sizeOfDirectory(file1) : 0;
            } //End block
            {
                size1 = file1.length();
            } //End block
        } //End collapsed parenthetic
        long size2 = 0;
        {
            boolean var279EC72867D42A4199613E97C543500A_851092477 = (file2.isDirectory());
            {
                size2 = sumDirectoryContents && file2.exists() ? FileUtils.sizeOfDirectory(file2) : 0;
            } //End block
            {
                size2 = file2.length();
            } //End block
        } //End collapsed parenthetic
        long result = size1 - size2;
        addTaint(file1.getTaint());
        addTaint(file2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_170302490 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_170302490;
        // ---------- Original Method ----------
        //long size1 = 0;
        //if (file1.isDirectory()) {
            //size1 = sumDirectoryContents && file1.exists() ? FileUtils.sizeOfDirectory(file1) : 0;
        //} else {
            //size1 = file1.length();
        //}
        //long size2 = 0;
        //if (file2.isDirectory()) {
            //size2 = sumDirectoryContents && file2.exists() ? FileUtils.sizeOfDirectory(file2) : 0;
        //} else {
            //size2 = file2.length();
        //}
        //long result = size1 - size2;
        //if (result < 0) {
            //return -1;
        //} else if (result > 0) {
            //return 1;
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.609 -0400", hash_original_method = "0C8A6A12A09534244BFD4B982DA5238A", hash_generated_method = "DA2BDEFF4A83E7BBBF454EAD09FAAD1A")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_682971370 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_682971370 = super.toString() + "[sumDirectoryContents=" + sumDirectoryContents + "]";
        varB4EAC82CA7396A68D541C85D26508E83_682971370.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_682971370;
        // ---------- Original Method ----------
        //return super.toString() + "[sumDirectoryContents=" + sumDirectoryContents + "]";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.609 -0400", hash_original_field = "1F51114DEAC590A8208D73D41693C0B1", hash_generated_field = "403A8E24B6733033181D121C8D9B72E9")

    public static final Comparator<File> SIZE_COMPARATOR = new SizeFileComparator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.609 -0400", hash_original_field = "BD43580FD321D68EDE1CAE7646EE2C9B", hash_generated_field = "9D943F43D397E911FF77080FE25827A5")

    public static final Comparator<File> SIZE_REVERSE = new ReverseComparator(SIZE_COMPARATOR);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.609 -0400", hash_original_field = "BBBAE10A37BC545D33A99C2D3F21F192", hash_generated_field = "D80363E469D7433F42AB38B2A5DAE57F")

    public static final Comparator<File> SIZE_SUMDIR_COMPARATOR = new SizeFileComparator(true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.609 -0400", hash_original_field = "EE38BCE14F503CED22EFD619242F58BC", hash_generated_field = "F596E17DA167E1E022FC6B7769071293")

    public static final Comparator<File> SIZE_SUMDIR_REVERSE = new ReverseComparator(SIZE_SUMDIR_COMPARATOR);
}

