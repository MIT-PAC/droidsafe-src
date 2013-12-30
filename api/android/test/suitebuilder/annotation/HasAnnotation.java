package android.test.suitebuilder.annotation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static com.android.internal.util.Predicates.or;

import java.lang.annotation.Annotation;

import android.test.suitebuilder.TestMethod;

import com.android.internal.util.Predicate;



public class HasAnnotation implements Predicate<TestMethod> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.754 -0500", hash_original_field = "473965BD54F01B70DAE4B7FDECBC5713", hash_generated_field = "9E6F9952BC05FDC53E5547217A51C708")


    private Predicate<TestMethod> hasMethodOrClassAnnotation;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.756 -0500", hash_original_method = "72E8E017389BF2244768026E6E63E268", hash_generated_method = "9DB6B8FE3AAA00BF961F32F52A4BA135")
    
public HasAnnotation(Class<? extends Annotation> annotationClass) {
        this.hasMethodOrClassAnnotation = or(
                new HasMethodAnnotation(annotationClass),
                new HasClassAnnotation(annotationClass));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.759 -0500", hash_original_method = "D324EABEE81C4B1F5DB30611ED44077B", hash_generated_method = "F47932B9A6B60F40512D8CE6E6220265")
    
public boolean apply(TestMethod testMethod) {
        return hasMethodOrClassAnnotation.apply(testMethod);
    }

    
}

