package junit.textui;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintStream;
import java.util.Enumeration;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestFailure;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.runner.BaseTestRunner;

public class ResultPrinter implements TestListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.679 -0500", hash_original_field = "90CE234F29B6C3026D5A6A62F5D28F59", hash_generated_field = "90CE234F29B6C3026D5A6A62F5D28F59")

	PrintStream fWriter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.681 -0500", hash_original_field = "41B8BD414950F06672B969C84CB7657B", hash_generated_field = "41B8BD414950F06672B969C84CB7657B")

	int fColumn= 0;
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.684 -0500", hash_original_method = "0EA3A66C40E65303973CEBB665EF244A", hash_generated_method = "78DB33A1EF70BC2F98104DEAD546847B")
    
public ResultPrinter(PrintStream writer) {
		fWriter= writer;
	}
	
	/* API for use by textui.TestRunner
	 */

	@DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.686 -0500", hash_original_method = "D4B791E5BAEACC439CFB8DF7C803AC90", hash_generated_method = "7B5117346573346A73782586CD3C0FBE")
    
synchronized void print(TestResult result, long runTime) {
		printHeader(runTime);
	    printErrors(result);
	    printFailures(result);
	    printFooter(result);
	}

	@DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.688 -0500", hash_original_method = "6F3036B6BA5666E793DE1D50D1E27410", hash_generated_method = "6F3036B6BA5666E793DE1D50D1E27410")
    
void printWaitPrompt() {
		getWriter().println();
		getWriter().println("<RETURN> to continue");
	}
	
	/* Internal methods 
	 */

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.690 -0500", hash_original_method = "7225C6AAA971FEAFD7E7DE3650CAC213", hash_generated_method = "9422664C52F058854C61781C71D8AFC3")
    
protected void printHeader(long runTime) {
		getWriter().println();
		getWriter().println("Time: "+elapsedTimeAsString(runTime));
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.693 -0500", hash_original_method = "1731EE3B6E41DD199C96E5357C154601", hash_generated_method = "FECCA91810F21E11AE0D22EA5000C5B2")
    
protected void printErrors(TestResult result) {
		printDefects(result.errors(), result.errorCount(), "error");
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.695 -0500", hash_original_method = "F2098A3B42D2D721E86326D008958B54", hash_generated_method = "741E6CA7F156C181F13EF42EBB535F93")
    
protected void printFailures(TestResult result) {
		printDefects(result.failures(), result.failureCount(), "failure");
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.697 -0500", hash_original_method = "B31D175648B1F0BBD9B95DD7611F8EC5", hash_generated_method = "8D50661157B238B309904B2DDD5C00F8")
    
protected void printDefects(Enumeration booBoos, int count, String type) {
		if (count == 0) return;
		if (count == 1)
			getWriter().println("There was " + count + " " + type + ":");
		else
			getWriter().println("There were " + count + " " + type + "s:");
		for (int i= 1; booBoos.hasMoreElements(); i++) {
			printDefect((TestFailure) booBoos.nextElement(), i);
		}
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.700 -0500", hash_original_method = "8F594E1BD06A99868D35353516D32E3A", hash_generated_method = "0DDE0081F18D20423FACC180794B72D8")
    
public void printDefect(TestFailure booBoo, int count) { // only public for testing purposes
		printDefectHeader(booBoo, count);
		printDefectTrace(booBoo);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.702 -0500", hash_original_method = "1947DB161F7BEBD07EBB8FC713F6E38E", hash_generated_method = "D9E7EE620136B0D26DF8AB3CE7A3E522")
    
protected void printDefectHeader(TestFailure booBoo, int count) {
		// I feel like making this a println, then adding a line giving the throwable a chance to print something
		// before we get to the stack trace.
		getWriter().print(count + ") " + booBoo.failedTest());
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.705 -0500", hash_original_method = "540A4B5A8D4E612454C45A1AF7BA14D6", hash_generated_method = "B05F3FA42D4A85910485CD2D16E2BDCC")
    
protected void printDefectTrace(TestFailure booBoo) {
		getWriter().print(BaseTestRunner.getFilteredTrace(booBoo.trace()));
	}

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.707 -0500", hash_original_method = "EE49A8AE172A75BE26948C083027FB54", hash_generated_method = "4F02EA31208E2D2ACDC0DD7ED7F65910")
    
protected void printFooter(TestResult result) {
		if (result.wasSuccessful()) {
			getWriter().println();
			getWriter().print("OK");
			getWriter().println (" (" + result.runCount() + " test" + (result.runCount() == 1 ? "": "s") + ")");

		} else {
			getWriter().println();
			getWriter().println("FAILURES!!!");
			getWriter().println("Tests run: "+result.runCount()+ 
				         ",  Failures: "+result.failureCount()+
				         ",  Errors: "+result.errorCount());
		}
	    getWriter().println();
	}

	/**
	 * Returns the formatted string of the elapsed time.
	 * Duplicated from BaseTestRunner. Fix it.
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.709 -0500", hash_original_method = "0FE324461208CCFE4D6285DE537F7763", hash_generated_method = "3BE473E08D4F05FEC17F97DA1BCD3410")
    
protected String elapsedTimeAsString(long runTime) {
            // The following line was altered for compatibility with
            // Android libraries.
	    return Double.toString((double)runTime/1000);
	}

	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.712 -0500", hash_original_method = "E39F1A78CDD5A4CC126B77217AA8CF1F", hash_generated_method = "5BCCDE690011F2BA809001DBBEE7B089")
    
public PrintStream getWriter() {
		return fWriter;
	}
	/**
	 * @see junit.framework.TestListener#addError(Test, Throwable)
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.714 -0500", hash_original_method = "7FECB2386B3373A34D0BB7141585D52C", hash_generated_method = "55E5CE1D6A08AF76E5863989CBCA774C")
    
public void addError(Test test, Throwable t) {
		getWriter().print("E");
	}

	/**
	 * @see junit.framework.TestListener#addFailure(Test, AssertionFailedError)
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.716 -0500", hash_original_method = "CBE875AE1CC49C40C27CB7367A3CF890", hash_generated_method = "04735FE261F2DE86D6F325AD1E0C5AD7")
    
public void addFailure(Test test, AssertionFailedError t) {
		getWriter().print("F");
	}

	/**
	 * @see junit.framework.TestListener#endTest(Test)
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.718 -0500", hash_original_method = "290F55CBC59AB09188EC6F36DCD12F0B", hash_generated_method = "890FD0E52F5D0FF7A50F9EF0CB493F54")
    
public void endTest(Test test) {
	}

	/**
	 * @see junit.framework.TestListener#startTest(Test)
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.720 -0500", hash_original_method = "49677EED3B6788809859A7BA2623E664", hash_generated_method = "B31239DB26FF367C23400710C3495755")
    
public void startTest(Test test) {
		getWriter().print(".");
		if (fColumn++ >= 40) {
			getWriter().println();
			fColumn= 0;
		}
	}
    
}

