package android.test.suitebuilder;

// Droidsafe Imports
import com.android.internal.util.Predicate;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

class AssignableFrom implements Predicate<TestMethod> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.126 -0400", hash_original_field = "63A9F0EA7BB98050796B649E85481845", hash_generated_field = "CD7AA0FB599481FB503A3BD1231F661A")

    private Class root;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.126 -0400", hash_original_method = "E9FCE922FC144032ABCB05F1667FA15F", hash_generated_method = "BF789729FAAADD598702C6C33A287AF6")
      AssignableFrom(Class root) {
        this.root = root;
        // ---------- Original Method ----------
        //this.root = root;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.126 -0400", hash_original_method = "B584575789FDF4D58989771E6FD9B1CC", hash_generated_method = "5512B7546FFFEAA6DBFEF16A9DF4086E")
    public boolean apply(TestMethod testMethod) {
        addTaint(testMethod.getTaint());
        boolean varF4DAC48EC26CA4A7ED9751DEBC02BE71_803023513 = (root.isAssignableFrom(testMethod.getEnclosingClass()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1569740519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1569740519;
        // ---------- Original Method ----------
        //return root.isAssignableFrom(testMethod.getEnclosingClass());
    }

    
}

