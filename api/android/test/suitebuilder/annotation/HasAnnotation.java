package android.test.suitebuilder.annotation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import static com.android.internal.util.Predicates.or;
import com.android.internal.util.Predicate;
import android.test.suitebuilder.TestMethod;
import java.lang.annotation.Annotation;

public class HasAnnotation implements Predicate<TestMethod> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.302 -0400", hash_original_field = "0A78A2D393858FF997339511150F661A", hash_generated_field = "9E6F9952BC05FDC53E5547217A51C708")

    private Predicate<TestMethod> hasMethodOrClassAnnotation;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.303 -0400", hash_original_method = "72E8E017389BF2244768026E6E63E268", hash_generated_method = "482602C4AF0B9B3BFAF50E3AD323834A")
    public  HasAnnotation(Class<? extends Annotation> annotationClass) {
        this.hasMethodOrClassAnnotation = or(
                new HasMethodAnnotation(annotationClass),
                new HasClassAnnotation(annotationClass));
        // ---------- Original Method ----------
        //this.hasMethodOrClassAnnotation = or(
                //new HasMethodAnnotation(annotationClass),
                //new HasClassAnnotation(annotationClass));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.303 -0400", hash_original_method = "D324EABEE81C4B1F5DB30611ED44077B", hash_generated_method = "5CB8AD97449B9D9E82EA74EC86AE508F")
    public boolean apply(TestMethod testMethod) {
        addTaint(testMethod.getTaint());
        boolean var0B7108EC2BE4CB9286150E7AAF78B3BD_1098605304 = (hasMethodOrClassAnnotation.apply(testMethod));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_820788778 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_820788778;
        // ---------- Original Method ----------
        //return hasMethodOrClassAnnotation.apply(testMethod);
    }

    
}

