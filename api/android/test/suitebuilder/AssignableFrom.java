package android.test.suitebuilder;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import com.android.internal.util.Predicate;



class AssignableFrom implements Predicate<TestMethod> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.222 -0500", hash_original_field = "497A6704402071AE6700B86462493C63", hash_generated_field = "CD7AA0FB599481FB503A3BD1231F661A")


    private  Class root;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.223 -0500", hash_original_method = "E9FCE922FC144032ABCB05F1667FA15F", hash_generated_method = "E9FCE922FC144032ABCB05F1667FA15F")
    AssignableFrom(Class root) {
        this.root = root;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.224 -0500", hash_original_method = "B584575789FDF4D58989771E6FD9B1CC", hash_generated_method = "66F8F95C1333CB27606D909C71FB11C3")
    public boolean apply(TestMethod testMethod) {
        return root.isAssignableFrom(testMethod.getEnclosingClass());
    }

    
}

