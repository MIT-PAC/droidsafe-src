package junit.textui;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.PrintStream;
import java.util.Enumeration;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestFailure;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.runner.BaseTestRunner;

public class ResultPrinter implements TestListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.484 -0400", hash_original_field = "EE28240FCFC3A19747E3D5464517BD00", hash_generated_field = "90CE234F29B6C3026D5A6A62F5D28F59")

    PrintStream fWriter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.484 -0400", hash_original_field = "7CEC7A8EA47C9A8A1AD72239D705A645", hash_generated_field = "41B8BD414950F06672B969C84CB7657B")

    int fColumn = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.484 -0400", hash_original_method = "0EA3A66C40E65303973CEBB665EF244A", hash_generated_method = "978016C1B7E60FFF498950E087A58645")
    public  ResultPrinter(PrintStream writer) {
        fWriter= writer;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.485 -0400", hash_original_method = "D4B791E5BAEACC439CFB8DF7C803AC90", hash_generated_method = "1D482A413074E153AE99233AFF7E840A")
    synchronized void print(TestResult result, long runTime) {
        addTaint(runTime);
        addTaint(result.getTaint());
        printHeader(runTime);
        printErrors(result);
        printFailures(result);
        printFooter(result);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.485 -0400", hash_original_method = "6F3036B6BA5666E793DE1D50D1E27410", hash_generated_method = "CEE3EC6F8FEBCAEED982EE54FFDE73B9")
     void printWaitPrompt() {
        getWriter().println();
        getWriter().println("<RETURN> to continue");
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.485 -0400", hash_original_method = "7225C6AAA971FEAFD7E7DE3650CAC213", hash_generated_method = "48133F1CD7A35A7DF4D8372A0399EC50")
    protected void printHeader(long runTime) {
        addTaint(runTime);
        getWriter().println();
        getWriter().println("Time: "+elapsedTimeAsString(runTime));
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.486 -0400", hash_original_method = "1731EE3B6E41DD199C96E5357C154601", hash_generated_method = "D687431AF0619582A0608574B04C8699")
    protected void printErrors(TestResult result) {
        addTaint(result.getTaint());
        printDefects(result.errors(), result.errorCount(), "error");
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.486 -0400", hash_original_method = "F2098A3B42D2D721E86326D008958B54", hash_generated_method = "38218C4AB55AD485915A8730C43862A2")
    protected void printFailures(TestResult result) {
        addTaint(result.getTaint());
        printDefects(result.failures(), result.failureCount(), "failure");
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.486 -0400", hash_original_method = "B31D175648B1F0BBD9B95DD7611F8EC5", hash_generated_method = "F29904A1F6F7D8FE69FFA2F3D2D72E0C")
    protected void printDefects(Enumeration booBoos, int count, String type) {
        addTaint(type.getTaint());
        addTaint(count);
        addTaint(booBoos.getTaint());
    if(count == 0)        
        return;
    if(count == 1)        
        getWriter().println("There was " + count + " " + type + ":");
        else
        getWriter().println("There were " + count + " " + type + "s:");
for(int i= 1;booBoos.hasMoreElements();i++)
        {
            printDefect((TestFailure) booBoos.nextElement(), i);
        } 
        
        
        
			
		
			
        
			
		
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.487 -0400", hash_original_method = "8F594E1BD06A99868D35353516D32E3A", hash_generated_method = "CF47FF37D89C4F27271D8ACAC84D013A")
    public void printDefect(TestFailure booBoo, int count) {
        addTaint(count);
        addTaint(booBoo.getTaint());
        printDefectHeader(booBoo, count);
        printDefectTrace(booBoo);
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.487 -0400", hash_original_method = "1947DB161F7BEBD07EBB8FC713F6E38E", hash_generated_method = "DC349A5EB909F0FA651946E1F18F48B1")
    protected void printDefectHeader(TestFailure booBoo, int count) {
        addTaint(count);
        addTaint(booBoo.getTaint());
        getWriter().print(count + ") " + booBoo.failedTest());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.487 -0400", hash_original_method = "540A4B5A8D4E612454C45A1AF7BA14D6", hash_generated_method = "268A96001146C260E3D7E80090EA5E8F")
    protected void printDefectTrace(TestFailure booBoo) {
        addTaint(booBoo.getTaint());
        getWriter().print(BaseTestRunner.getFilteredTrace(booBoo.trace()));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.488 -0400", hash_original_method = "EE49A8AE172A75BE26948C083027FB54", hash_generated_method = "6DB805DD7D2BDBEE78DB443994104225")
    protected void printFooter(TestResult result) {
        addTaint(result.getTaint());
    if(result.wasSuccessful())        
        {
            getWriter().println();
            getWriter().print("OK");
            getWriter().println (" (" + result.runCount() + " test" + (result.runCount() == 1 ? "": "s") + ")");
        } 
        else
        {
            getWriter().println();
            getWriter().println("FAILURES!!!");
            getWriter().println("Tests run: "+result.runCount()+ 
				         ",  Failures: "+result.failureCount()+
				         ",  Errors: "+result.errorCount());
        } 
        getWriter().println();
        
        
			
			
			
		
			
			
			
				         
				         
		
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.489 -0400", hash_original_method = "0FE324461208CCFE4D6285DE537F7763", hash_generated_method = "AE99DA206692B38FD68065987562F792")
    protected String elapsedTimeAsString(long runTime) {
        addTaint(runTime);
String var782B052027FDBC1BF731D4722FE1CEA6_2137775224 =         Double.toString((double)runTime/1000);
        var782B052027FDBC1BF731D4722FE1CEA6_2137775224.addTaint(taint);
        return var782B052027FDBC1BF731D4722FE1CEA6_2137775224;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.489 -0400", hash_original_method = "E39F1A78CDD5A4CC126B77217AA8CF1F", hash_generated_method = "68974D01644C475FEC66BBA746DDDB75")
    public PrintStream getWriter() {
PrintStream var15EB857739387F1E1116D7F9B05806F0_1394098965 =         fWriter;
        var15EB857739387F1E1116D7F9B05806F0_1394098965.addTaint(taint);
        return var15EB857739387F1E1116D7F9B05806F0_1394098965;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.489 -0400", hash_original_method = "7FECB2386B3373A34D0BB7141585D52C", hash_generated_method = "7CEDB69E11AEF4D5BD1ED0BC8A1D423F")
    public void addError(Test test, Throwable t) {
        addTaint(t.getTaint());
        addTaint(test.getTaint());
        getWriter().print("E");
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.489 -0400", hash_original_method = "CBE875AE1CC49C40C27CB7367A3CF890", hash_generated_method = "1E4A1B85ECBE1BCC1195742497B0AD92")
    public void addFailure(Test test, AssertionFailedError t) {
        addTaint(t.getTaint());
        addTaint(test.getTaint());
        getWriter().print("F");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.490 -0400", hash_original_method = "290F55CBC59AB09188EC6F36DCD12F0B", hash_generated_method = "FC02CD50599BCB5038979A7D0E8D57CB")
    public void endTest(Test test) {
        addTaint(test.getTaint());
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.490 -0400", hash_original_method = "49677EED3B6788809859A7BA2623E664", hash_generated_method = "BF8E8CB8C73007EAD86B36369D9A10D3")
    public void startTest(Test test) {
        addTaint(test.getTaint());
        getWriter().print(".");
    if(fColumn++ >= 40)        
        {
            getWriter().println();
            fColumn= 0;
        } 
        
        
        
			
			
		
    }

    
}

