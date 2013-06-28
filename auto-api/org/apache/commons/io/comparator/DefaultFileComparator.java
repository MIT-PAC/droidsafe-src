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

public class DefaultFileComparator extends AbstractFileComparator implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.541 -0400", hash_original_method = "496160DB0D7617BEF89C72604DD2392A", hash_generated_method = "496160DB0D7617BEF89C72604DD2392A")
    public DefaultFileComparator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.541 -0400", hash_original_method = "66E95E24BE0C08C51B59821FA4A7134C", hash_generated_method = "64679B2A0D15FDCF3DEBA6EAB8C55A7C")
    public int compare(File file1, File file2) {
        int varFD46A6F3AAF44A229471A7D242845885_2059400941 = (file1.compareTo(file2));
        addTaint(file1.getTaint());
        addTaint(file2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218934611 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218934611;
        // ---------- Original Method ----------
        //return file1.compareTo(file2);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.541 -0400", hash_original_field = "BA10130B5521B952744F4165EA88C2B4", hash_generated_field = "BD08CF01AE944331506678C97C8F66A6")

    public static final Comparator<File> DEFAULT_COMPARATOR = new DefaultFileComparator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.541 -0400", hash_original_field = "B1C7AD7FA8AFF5C53110B1A5B44E95FB", hash_generated_field = "DB61B4883E186B99B29B96328A75930B")

    public static final Comparator<File> DEFAULT_REVERSE = new ReverseComparator(DEFAULT_COMPARATOR);
}

