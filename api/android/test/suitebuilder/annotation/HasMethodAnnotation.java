package android.test.suitebuilder.annotation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.annotation.Annotation;

import android.test.suitebuilder.TestMethod;

import com.android.internal.util.Predicate;



class HasMethodAnnotation implements Predicate<TestMethod> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.827 -0500", hash_original_field = "C2B636B3436AAE938C27736789A704F2", hash_generated_field = "DE2305164AC5A8D49939E7B2C7A8CA75")


    private  Class<? extends Annotation> annotationClass;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.830 -0500", hash_original_method = "5B83FF39DFA831FA6A7CD406ADF7D177", hash_generated_method = "FCC1EE875CEB1969522A4C6C5DC9083C")
    
public HasMethodAnnotation(Class<? extends Annotation> annotationClass) {
        this.annotationClass = annotationClass;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.832 -0500", hash_original_method = "B0E427C0DE73550E3FD588188632FEB8", hash_generated_method = "8D1E7590A30E6E663F44636BDED47A68")
    
public boolean apply(TestMethod testMethod) {
        return testMethod.getAnnotation(annotationClass) != null;
    }

    
}

