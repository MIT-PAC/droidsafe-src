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
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

public class ExtensionFileComparator extends AbstractFileComparator implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.556 -0400", hash_original_field = "9AE1535F968174A45A688181FD26E8A9", hash_generated_field = "21450A3017D0D6122C0877D57300E67A")

    private IOCase caseSensitivity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.557 -0400", hash_original_method = "3A8CFBD8D9978421723DC262FBD1326A", hash_generated_method = "9F96B0108A63B53B5B64CA583D497F4D")
    public  ExtensionFileComparator() {
        this.caseSensitivity = IOCase.SENSITIVE;
        // ---------- Original Method ----------
        //this.caseSensitivity = IOCase.SENSITIVE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.557 -0400", hash_original_method = "F5D6469F4576D324414C9087777D12E4", hash_generated_method = "968A3F2FFD10D88E4150A74443ABB7BE")
    public  ExtensionFileComparator(IOCase caseSensitivity) {
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
        // ---------- Original Method ----------
        //this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.557 -0400", hash_original_method = "9212C488AEDF56E62CAE314A88D3084B", hash_generated_method = "C9FE5A784A692B27A9F33A78A06AD2F3")
    public int compare(File file1, File file2) {
        String suffix1 = FilenameUtils.getExtension(file1.getName());
        String suffix2 = FilenameUtils.getExtension(file2.getName());
        int var4FCCEE7F3A06B4257140893EE66E8D0B_325400706 = (caseSensitivity.checkCompareTo(suffix1, suffix2));
        addTaint(file1.getTaint());
        addTaint(file2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851537980 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851537980;
        // ---------- Original Method ----------
        //String suffix1 = FilenameUtils.getExtension(file1.getName());
        //String suffix2 = FilenameUtils.getExtension(file2.getName());
        //return caseSensitivity.checkCompareTo(suffix1, suffix2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.558 -0400", hash_original_method = "2C8858F1FEF258A79F4059C0A1CB8058", hash_generated_method = "FD3D9BFFBBAFB241520A38CB83956035")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2035443353 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2035443353 = super.toString() + "[caseSensitivity=" + caseSensitivity + "]";
        varB4EAC82CA7396A68D541C85D26508E83_2035443353.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2035443353;
        // ---------- Original Method ----------
        //return super.toString() + "[caseSensitivity=" + caseSensitivity + "]";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.558 -0400", hash_original_field = "EADA657ECA844EF0FAE8883B91EBDAB9", hash_generated_field = "2EF321651233CD14147E1E4DA1BADAF9")

    public static final Comparator<File> EXTENSION_COMPARATOR = new ExtensionFileComparator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.558 -0400", hash_original_field = "0C309D35C9BC73B319CE669F9A35EC4F", hash_generated_field = "C74952010ADAA08A7313781CC5A9B457")

    public static final Comparator<File> EXTENSION_REVERSE = new ReverseComparator(EXTENSION_COMPARATOR);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.558 -0400", hash_original_field = "F8835649AE2DDDF4A6C8A7F40365D474", hash_generated_field = "47B18B94AA8A054C6FC3FA607B029D79")

    public static final Comparator<File> EXTENSION_INSENSITIVE_COMPARATOR
                                                = new ExtensionFileComparator(IOCase.INSENSITIVE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.558 -0400", hash_original_field = "69411E3E2D19E15A94BCA0493F23ED79", hash_generated_field = "B2E9034FF7DEF5FAC4733E8CCEE4013A")

    public static final Comparator<File> EXTENSION_INSENSITIVE_REVERSE
                                                = new ReverseComparator(EXTENSION_INSENSITIVE_COMPARATOR);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.558 -0400", hash_original_field = "8A5BDA9155A4E5D4606A795FA1E354AA", hash_generated_field = "421A6F7E72C8807D87EF07590FFCF61C")

    public static final Comparator<File> EXTENSION_SYSTEM_COMPARATOR = new ExtensionFileComparator(IOCase.SYSTEM);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.558 -0400", hash_original_field = "B68BFC7EE8B828FF949B7593D0972260", hash_generated_field = "A13CE54151A68982E1C070D10454926E")

    public static final Comparator<File> EXTENSION_SYSTEM_REVERSE = new ReverseComparator(EXTENSION_SYSTEM_COMPARATOR);
}

