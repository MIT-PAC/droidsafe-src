package junit.framework;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintWriter;
import java.io.StringWriter;






public class TestFailure extends Object {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.566 -0500", hash_original_field = "8CF5065E29B9C13BB09499C2CFE8B5D0", hash_generated_field = "63E0C2E6C529E77A17593025B7AE1DAA")

    protected Test fFailedTest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.567 -0500", hash_original_field = "EAD2F9350983F144B8C179A00783B18D", hash_generated_field = "8125A5D29833C3F40650F43D68116E5F")

    protected Throwable fThrownException;


    /**
     * Constructs a TestFailure with the given test and exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.568 -0500", hash_original_method = "5E53006C9FF9FBE366053539294E0761", hash_generated_method = "12D474F4EE7FD734B7A6F0F15AC87567")
    public TestFailure(Test failedTest, Throwable thrownException) {
        fFailedTest= failedTest;
        fThrownException= thrownException;
    }
    /**
     * Gets the failed test.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.569 -0500", hash_original_method = "DB6BEFCD0A819B7E57F227596762579B", hash_generated_method = "EE57F0ED37601162F324632CE474EE6B")
    public Test failedTest() {
        return fFailedTest;
    }
    /**
     * Gets the thrown exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.569 -0500", hash_original_method = "A0692C4EAE17C62872816DE26503E51B", hash_generated_method = "F987BF771176871B67EC4970A0CACE0D")
    public Throwable thrownException() {
        return fThrownException;
    }
    /**
     * Returns a short description of the failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.570 -0500", hash_original_method = "2437797492D4FB816280E0DD31B38A08", hash_generated_method = "5993374858CEE161E6BE45EC8066F26B")
    public String toString() {
        StringBuffer buffer= new StringBuffer();
        buffer.append(fFailedTest+": "+fThrownException.getMessage());
        return buffer.toString();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.571 -0500", hash_original_method = "B9501C666454C84725568C14E07C6438", hash_generated_method = "C0B2E99D4713C5CFB9EEB1413CA8835F")
    public String trace() {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        thrownException().printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.572 -0500", hash_original_method = "714D20E6C3C4C52A812F465E8B865B9F", hash_generated_method = "A6CDB60A9063C59D03F2ECCCA5AE9F04")
    public String exceptionMessage() {
        return thrownException().getMessage();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.573 -0500", hash_original_method = "655992A237E3477973E75EA62E8182BB", hash_generated_method = "231DAE6BF33873901ECBDD63EA4765F1")
    public boolean isFailure() {
        return thrownException() instanceof AssertionFailedError;
    }

    
}

