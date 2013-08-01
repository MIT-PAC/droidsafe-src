package android.test.suitebuilder.annotation;

// Droidsafe Imports
import java.lang.annotation.Annotation;

import android.test.suitebuilder.TestMethod;

import com.android.internal.util.Predicate;

import droidsafe.annotations.*;

class HasClassAnnotation implements Predicate<TestMethod> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.309 -0400", hash_original_field = "E8B88437A9E22BF3A8BC15ECF79F99EC", hash_generated_field = "DE2305164AC5A8D49939E7B2C7A8CA75")

    private Class<? extends Annotation> annotationClass;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.309 -0400", hash_original_method = "A8B3157C0F26BC2F3EBE54C11E9286F8", hash_generated_method = "D643D546E8362B14DCA24E57B04EAFC6")
    public  HasClassAnnotation(Class<? extends Annotation> annotationClass) {
        this.annotationClass = annotationClass;
        // ---------- Original Method ----------
        //this.annotationClass = annotationClass;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.309 -0400", hash_original_method = "0892E41EB1EA3A29EC7FB4D97960D3AE", hash_generated_method = "F19F6C20F6D03EDED5F1979A5404ABF5")
    public boolean apply(TestMethod testMethod) {
        addTaint(testMethod.getTaint());
        boolean var65A2DA678C561FC94BB91558C7468F80_1190571338 = (testMethod.getEnclosingClass().getAnnotation(annotationClass) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_207927427 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_207927427;
        // ---------- Original Method ----------
        //return testMethod.getEnclosingClass().getAnnotation(annotationClass) != null;
    }

    
}

