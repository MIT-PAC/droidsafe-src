package android.test.suitebuilder;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.HasAnnotation;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.test.suitebuilder.annotation.Smoke;
import android.test.suitebuilder.annotation.Suppress;

import com.android.internal.util.Predicate;
import com.android.internal.util.Predicates;




public class TestPredicates {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.233 -0500", hash_original_field = "0A64915FB6577E86F8CA4A7848878ED0", hash_generated_field = "0145998528421DE1B82B1666CCF5A917")


    public static final Predicate<TestMethod> SELECT_INSTRUMENTATION =
            new AssignableFrom(InstrumentationTestCase.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.234 -0500", hash_original_field = "FD4FFE7F09E15C74728355F4A1B0F764", hash_generated_field = "321ED201A89BB512C8428A67C61DDCD9")

    public static final Predicate<TestMethod> REJECT_INSTRUMENTATION =
            Predicates.not(SELECT_INSTRUMENTATION);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.236 -0500", hash_original_field = "027291695C4D8055B0E4C11285DD728C", hash_generated_field = "AA13A147D8DECDDC99A121CBD577E359")


    public static final Predicate<TestMethod> SELECT_SMOKE = new HasAnnotation(Smoke.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.237 -0500", hash_original_field = "377F4E6A4FEE1E5129FB82398A58746D", hash_generated_field = "07798F2411DFDA2434B51420ACE2D2BB")

    public static final Predicate<TestMethod> SELECT_SMALL = new HasAnnotation(SmallTest.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.238 -0500", hash_original_field = "F5137FF1813A28AA2D7D6E772C5E97B3", hash_generated_field = "7DAF9F3AEB243EB76D43716F5BAF038F")

    public static final Predicate<TestMethod> SELECT_MEDIUM = new HasAnnotation(MediumTest.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.239 -0500", hash_original_field = "190D4E46ACAF4BE90107D33194714876", hash_generated_field = "12521649C0193480D03D8537B88F82BB")

    public static final Predicate<TestMethod> SELECT_LARGE = new HasAnnotation(LargeTest.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.240 -0500", hash_original_field = "FECF95EF0CCB0B5000CA4CEE85708775", hash_generated_field = "5349C874FBDC284466360C5A278D2BC9")

    public static final Predicate<TestMethod> REJECT_SUPPRESSED =
            Predicates.not(new HasAnnotation(Suppress.class));
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.243 -0400", hash_original_method = "4FB472B861AF10AEED876CF7DD7E397C", hash_generated_method = "4FB472B861AF10AEED876CF7DD7E397C")
    public TestPredicates ()
    {
        //Synthesized constructor
    }
}

