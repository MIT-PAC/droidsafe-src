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
import org.apache.commons.io.IOCase;

public class PathFileComparator extends AbstractFileComparator implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.416 -0400", hash_original_field = "9AE1535F968174A45A688181FD26E8A9", hash_generated_field = "21450A3017D0D6122C0877D57300E67A")

    private IOCase caseSensitivity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.416 -0400", hash_original_method = "22C4074A2C3937C6AB79C8A7BBF86F43", hash_generated_method = "E85F0465DA173F3B0AC55CAD6A556414")
    public  PathFileComparator() {
        this.caseSensitivity = IOCase.SENSITIVE;
        // ---------- Original Method ----------
        //this.caseSensitivity = IOCase.SENSITIVE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.417 -0400", hash_original_method = "F159246393BC6BD0D887FFAE2708CE6F", hash_generated_method = "2FD040D6865D0DDED6F71614477CBB03")
    public  PathFileComparator(IOCase caseSensitivity) {
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
        // ---------- Original Method ----------
        //this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.418 -0400", hash_original_method = "E52DB31DD4CEA24D40EB558E5E7FE49E", hash_generated_method = "BFF41337789DB852AE877F0B44C2613B")
    public int compare(File file1, File file2) {
        int var11C06985CE1BE059DA2403FF05481B6F_1981810524 = (caseSensitivity.checkCompareTo(file1.getPath(), file2.getPath()));
        addTaint(file1.getTaint());
        addTaint(file2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354057055 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354057055;
        // ---------- Original Method ----------
        //return caseSensitivity.checkCompareTo(file1.getPath(), file2.getPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.418 -0400", hash_original_method = "2C8858F1FEF258A79F4059C0A1CB8058", hash_generated_method = "CD7DE99B9794A48418DB319363DE8957")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_727862909 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_727862909 = super.toString() + "[caseSensitivity=" + caseSensitivity + "]";
        varB4EAC82CA7396A68D541C85D26508E83_727862909.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_727862909;
        // ---------- Original Method ----------
        //return super.toString() + "[caseSensitivity=" + caseSensitivity + "]";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.418 -0400", hash_original_field = "5ABAA5936EF95427C91D4A20EF394774", hash_generated_field = "B08964A0E7C27188446ECA398E4B4E07")

    public static final Comparator<File> PATH_COMPARATOR = new PathFileComparator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.418 -0400", hash_original_field = "BB1101814E9E54ECB749B0BABAEBC993", hash_generated_field = "296D118EC0C72351357689CC8C91D1EA")

    public static final Comparator<File> PATH_REVERSE = new ReverseComparator(PATH_COMPARATOR);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.418 -0400", hash_original_field = "EDB2717EA2AB3BEED05E32B9597EC123", hash_generated_field = "F9249BFC7862694A7572BD0C9A5485F9")

    public static final Comparator<File> PATH_INSENSITIVE_COMPARATOR = new PathFileComparator(IOCase.INSENSITIVE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.418 -0400", hash_original_field = "71C54A2380AB6C108A3F43201F90CD6A", hash_generated_field = "17C9DBD5661F5BA923DD880B8BDB755B")

    public static final Comparator<File> PATH_INSENSITIVE_REVERSE = new ReverseComparator(PATH_INSENSITIVE_COMPARATOR);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.418 -0400", hash_original_field = "B632FE75D147FB3D216372CE1A7E4FC7", hash_generated_field = "2641D8A71F0F7328A2831980F21996D9")

    public static final Comparator<File> PATH_SYSTEM_COMPARATOR = new PathFileComparator(IOCase.SYSTEM);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.418 -0400", hash_original_field = "6D4439E158B69A37FFE5A9FC626BC32F", hash_generated_field = "D4D5E171519FE601C443348BB4E5B546")

    public static final Comparator<File> PATH_SYSTEM_REVERSE = new ReverseComparator(PATH_SYSTEM_COMPARATOR);
}

