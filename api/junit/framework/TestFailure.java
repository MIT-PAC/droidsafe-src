package junit.framework;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.PrintWriter;
import java.io.StringWriter;

public class TestFailure extends Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.272 -0400", hash_original_field = "24764D2C5A9696D0C7717241A3107B28", hash_generated_field = "63E0C2E6C529E77A17593025B7AE1DAA")

    protected Test fFailedTest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.272 -0400", hash_original_field = "C520FC2C662A9919C644B478D6C724AC", hash_generated_field = "8125A5D29833C3F40650F43D68116E5F")

    protected Throwable fThrownException;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.272 -0400", hash_original_method = "5E53006C9FF9FBE366053539294E0761", hash_generated_method = "019011B38156D6EB94834D3FFD52306F")
    public  TestFailure(Test failedTest, Throwable thrownException) {
        fFailedTest= failedTest;
        fThrownException= thrownException;
        // ---------- Original Method ----------
        //fFailedTest= failedTest;
        //fThrownException= thrownException;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.272 -0400", hash_original_method = "DB6BEFCD0A819B7E57F227596762579B", hash_generated_method = "DCA24F52D2EB5E34E1BF069739815A2D")
    public Test failedTest() {
Test varD872FF249646CCD079B3369CB77C861B_2082770226 =         fFailedTest;
        varD872FF249646CCD079B3369CB77C861B_2082770226.addTaint(taint);
        return varD872FF249646CCD079B3369CB77C861B_2082770226;
        // ---------- Original Method ----------
        //return fFailedTest;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.273 -0400", hash_original_method = "A0692C4EAE17C62872816DE26503E51B", hash_generated_method = "B7F529269DD43F81767AFF088B52D65B")
    public Throwable thrownException() {
Throwable var85FD5481228C8E47520848B8A075755F_1863444904 =         fThrownException;
        var85FD5481228C8E47520848B8A075755F_1863444904.addTaint(taint);
        return var85FD5481228C8E47520848B8A075755F_1863444904;
        // ---------- Original Method ----------
        //return fThrownException;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.273 -0400", hash_original_method = "2437797492D4FB816280E0DD31B38A08", hash_generated_method = "F8F52C46663A54155B30392BA28D6DCF")
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(fFailedTest+": "+fThrownException.getMessage());
String varD03843288D33B9E1D3062E25339ECF6D_1596708369 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_1596708369.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_1596708369;
        // ---------- Original Method ----------
        //StringBuffer buffer= new StringBuffer();
        //buffer.append(fFailedTest+": "+fThrownException.getMessage());
        //return buffer.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.273 -0400", hash_original_method = "B9501C666454C84725568C14E07C6438", hash_generated_method = "7952AB2B6381416E3AAC5D987D8EE0E8")
    public String trace() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        thrownException().printStackTrace(writer);
        StringBuffer buffer = stringWriter.getBuffer();
String varD03843288D33B9E1D3062E25339ECF6D_1818707599 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_1818707599.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_1818707599;
        // ---------- Original Method ----------
        //StringWriter stringWriter= new StringWriter();
        //PrintWriter writer= new PrintWriter(stringWriter);
        //thrownException().printStackTrace(writer);
        //StringBuffer buffer= stringWriter.getBuffer();
        //return buffer.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.274 -0400", hash_original_method = "714D20E6C3C4C52A812F465E8B865B9F", hash_generated_method = "D7D2852674615900B523235ADB4FEE71")
    public String exceptionMessage() {
String varCF6E60E81E44D28E9C5DFA07B544AC77_188131312 =         thrownException().getMessage();
        varCF6E60E81E44D28E9C5DFA07B544AC77_188131312.addTaint(taint);
        return varCF6E60E81E44D28E9C5DFA07B544AC77_188131312;
        // ---------- Original Method ----------
        //return thrownException().getMessage();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.274 -0400", hash_original_method = "655992A237E3477973E75EA62E8182BB", hash_generated_method = "19585DA4C63A8860F642D03D83A37E7E")
    public boolean isFailure() {
        boolean varA7BBB1B0084C91904E1822EDFC9CD9A9_1392617303 = (thrownException() instanceof AssertionFailedError);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_418411239 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_418411239;
        // ---------- Original Method ----------
        //return thrownException() instanceof AssertionFailedError;
    }

    
}

