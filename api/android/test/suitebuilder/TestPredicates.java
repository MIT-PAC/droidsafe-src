package android.test.suitebuilder;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.HasAnnotation;
import android.test.suitebuilder.annotation.Suppress;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.test.suitebuilder.annotation.Smoke;
import com.android.internal.util.Predicate;
import com.android.internal.util.Predicates;

public class TestPredicates {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.576 -0400", hash_original_method = "4FB472B861AF10AEED876CF7DD7E397C", hash_generated_method = "4FB472B861AF10AEED876CF7DD7E397C")
    public TestPredicates ()
    {
        //Synthesized constructor
    }


    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.576 -0400", hash_original_field = "0ED8A666B694904420680E101F99BB28", hash_generated_field = "0145998528421DE1B82B1666CCF5A917")

    public static final Predicate<TestMethod> SELECT_INSTRUMENTATION =
            new AssignableFrom(InstrumentationTestCase.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.576 -0400", hash_original_field = "9D03617A3B0CBD0182BA120B9953C563", hash_generated_field = "321ED201A89BB512C8428A67C61DDCD9")

    public static final Predicate<TestMethod> REJECT_INSTRUMENTATION =
            Predicates.not(SELECT_INSTRUMENTATION);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.577 -0400", hash_original_field = "B5F7CEA38ABEF3B6265E7F9F0B765683", hash_generated_field = "AA13A147D8DECDDC99A121CBD577E359")

    public static final Predicate<TestMethod> SELECT_SMOKE = new HasAnnotation(Smoke.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.577 -0400", hash_original_field = "16F3DC8341F3DA844248CB22E3800361", hash_generated_field = "07798F2411DFDA2434B51420ACE2D2BB")

    public static final Predicate<TestMethod> SELECT_SMALL = new HasAnnotation(SmallTest.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.577 -0400", hash_original_field = "C798DA1FD05F8129D4BE27490B05C4E6", hash_generated_field = "7DAF9F3AEB243EB76D43716F5BAF038F")

    public static final Predicate<TestMethod> SELECT_MEDIUM = new HasAnnotation(MediumTest.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.577 -0400", hash_original_field = "A92257D3564C1EEE52C4278180CF4732", hash_generated_field = "12521649C0193480D03D8537B88F82BB")

    public static final Predicate<TestMethod> SELECT_LARGE = new HasAnnotation(LargeTest.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.577 -0400", hash_original_field = "1DAA6ED7617366FCCE84C5F9DAA1FE00", hash_generated_field = "5349C874FBDC284466360C5A278D2BC9")

    public static final Predicate<TestMethod> REJECT_SUPPRESSED =
            Predicates.not(new HasAnnotation(Suppress.class));
}

