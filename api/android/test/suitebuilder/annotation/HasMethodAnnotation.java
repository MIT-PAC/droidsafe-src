package android.test.suitebuilder.annotation;

// Droidsafe Imports
import java.lang.annotation.Annotation;

import android.test.suitebuilder.TestMethod;

import com.android.internal.util.Predicate;

import droidsafe.annotations.*;

class HasMethodAnnotation implements Predicate<TestMethod> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.313 -0400", hash_original_field = "E8B88437A9E22BF3A8BC15ECF79F99EC", hash_generated_field = "DE2305164AC5A8D49939E7B2C7A8CA75")

    private Class<? extends Annotation> annotationClass;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.313 -0400", hash_original_method = "5B83FF39DFA831FA6A7CD406ADF7D177", hash_generated_method = "1A53B43E933F86FCC558C4FFF9B27241")
    public  HasMethodAnnotation(Class<? extends Annotation> annotationClass) {
        this.annotationClass = annotationClass;
        // ---------- Original Method ----------
        //this.annotationClass = annotationClass;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.314 -0400", hash_original_method = "B0E427C0DE73550E3FD588188632FEB8", hash_generated_method = "D4F66A7B5D51A0DF5A5E4259B40287D9")
    public boolean apply(TestMethod testMethod) {
        addTaint(testMethod.getTaint());
        boolean varF8304699C3C64AAE457B2880C69C027D_418787387 = (testMethod.getAnnotation(annotationClass) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1103659655 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1103659655;
        // ---------- Original Method ----------
        //return testMethod.getAnnotation(annotationClass) != null;
    }

    
}

