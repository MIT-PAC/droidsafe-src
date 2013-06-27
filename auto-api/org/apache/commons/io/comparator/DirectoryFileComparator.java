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

public class DirectoryFileComparator extends AbstractFileComparator implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.340 -0400", hash_original_method = "ECFAACB53A7D646B563721DC828F52F1", hash_generated_method = "ECFAACB53A7D646B563721DC828F52F1")
    public DirectoryFileComparator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.340 -0400", hash_original_method = "8FE74608AE6AFB279889AE18FF2B3850", hash_generated_method = "04800874B96997B2E6C3333360E86DD6")
    public int compare(File file1, File file2) {
        int varFFE1A7B8C4267D8E66024394511CAE60_1056924375 = (getType(file1) - getType(file2));
        addTaint(file1.getTaint());
        addTaint(file2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_131798182 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_131798182;
        // ---------- Original Method ----------
        //return getType(file1) - getType(file2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.341 -0400", hash_original_method = "F734E00AC7C86C91DF2349E696F92B1F", hash_generated_method = "6D798A67D40C9C11EDC32FA5D4D09808")
    private int getType(File file) {
        {
            boolean varB4EF7A82C29897D1EBAB65E15CCB5408_362180877 = (file.isDirectory());
        } //End collapsed parenthetic
        addTaint(file.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1921496145 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1921496145;
        // ---------- Original Method ----------
        //if (file.isDirectory()) {
            //return 1;
        //} else {
            //return 2;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.341 -0400", hash_original_field = "7942D13C2016F9D5BC3837879BAE5E64", hash_generated_field = "E33E6F2595483C0E19B0D4E565CA491E")

    public static final Comparator<File> DIRECTORY_COMPARATOR = new DirectoryFileComparator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.341 -0400", hash_original_field = "BDA4C57A2196B5B79E3F6F0CCDA4BE3A", hash_generated_field = "F126AF8DB82D3604CE3B04EBD827D7FD")

    public static final Comparator<File> DIRECTORY_REVERSE = new ReverseComparator(DIRECTORY_COMPARATOR);
}

