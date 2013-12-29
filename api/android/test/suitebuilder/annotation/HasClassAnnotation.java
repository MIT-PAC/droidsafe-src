package android.test.suitebuilder.annotation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.annotation.Annotation;

import android.test.suitebuilder.TestMethod;

import com.android.internal.util.Predicate;



class HasClassAnnotation implements Predicate<TestMethod> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.424 -0500", hash_original_field = "C2B636B3436AAE938C27736789A704F2", hash_generated_field = "DE2305164AC5A8D49939E7B2C7A8CA75")


    private Class<? extends Annotation> annotationClass;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.425 -0500", hash_original_method = "A8B3157C0F26BC2F3EBE54C11E9286F8", hash_generated_method = "BC083D11FBF3B13E047D01E387816AB4")
    public HasClassAnnotation(Class<? extends Annotation> annotationClass) {
        this.annotationClass = annotationClass;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.425 -0500", hash_original_method = "0892E41EB1EA3A29EC7FB4D97960D3AE", hash_generated_method = "CD8817A92C553A289F0CA441E2B16333")
    public boolean apply(TestMethod testMethod) {
        return testMethod.getEnclosingClass().getAnnotation(annotationClass) != null;
    }

    
}

