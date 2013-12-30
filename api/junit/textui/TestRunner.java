package junit.textui;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintStream;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;
import junit.runner.StandardTestSuiteLoader;
import junit.runner.TestSuiteLoader;
import junit.runner.Version;





public class TestRunner extends BaseTestRunner {
	
	/**
	 * Runs a suite extracted from a TestCase subclass.
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.870 -0500", hash_original_method = "6B8DF053C82CA47987420F0F6F09ABCF", hash_generated_method = "8B07584B28CE2352E2A797FBDC920915")
	
static public void run(Class testClass) {
		run(new TestSuite(testClass));
	}

	/**
	 * Runs a single test and collects its results.
	 * This method can be used to start a test run
	 * from your program.
	 * <pre>
	 * public static void main (String[] args) {
	 *     test.textui.TestRunner.run(suite());
	 * }
	 * </pre>
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.873 -0500", hash_original_method = "1E04C144DDE2519A70CC67C5FE71A42F", hash_generated_method = "4B5833A794E031B88B289079A08815DE")
	
static public TestResult run(Test test) {
		TestRunner runner= new TestRunner();
		return runner.doRun(test);
	}

	/**
	 * Runs a single test and waits until the user
	 * types RETURN.
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.881 -0500", hash_original_method = "EFA51A9FDBB21A92ADDA18D4726F0F4C", hash_generated_method = "C329B553BB6D77E6F880C9B4AA68DD08")
	
static public void runAndWait(Test suite) {
		TestRunner aTestRunner= new TestRunner();
		aTestRunner.doRun(suite, true);
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.020 -0500", hash_original_method = "5AF09A6E2E395872107FCC8773EDA769", hash_generated_method = "735AAB9B126D4984B7938D71F76F7FD0")
	
public static void main(String args[]) {
		TestRunner aTestRunner= new TestRunner();
		try {
			TestResult r= aTestRunner.start(args);
			if (!r.wasSuccessful()) 
				System.exit(FAILURE_EXIT);
			System.exit(SUCCESS_EXIT);
		} catch(Exception e) {
			System.err.println(e.getMessage());
			System.exit(EXCEPTION_EXIT);
		}
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.849 -0500", hash_original_field = "4ED33DB27C2E5A74F5EE49C4DB6E231F", hash_generated_field = "F3374AC5F86160580EBE72031726DFFD")

	
	public static final int SUCCESS_EXIT= 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.851 -0500", hash_original_field = "1B2BC5C3F4DBCD29B546FFA6924D21AE", hash_generated_field = "2B56C3FDE1B930F748EE23F4669203F3")

	public static final int FAILURE_EXIT= 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.854 -0500", hash_original_field = "85362639D7E7BB1FBD2A8A83A91A56CF", hash_generated_field = "E5A0C028305B48E55FB88FA5805B8953")

	public static final int EXCEPTION_EXIT= 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.847 -0500", hash_original_field = "B5256E780ED70B97B6D8C71BC09171DA", hash_generated_field = "4B0543678AD73423AC3560CD1726B815")

	private ResultPrinter fPrinter;

	/**
	 * Constructs a TestRunner.
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.856 -0500", hash_original_method = "3B66BCE498E2DD0699CFFBB4FE4F7076", hash_generated_method = "2CFFD26EC90D471349D71F1206290F26")
	
public TestRunner() {
		this(System.out);
	}

	/**
	 * Constructs a TestRunner using the given stream for all the output
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.859 -0500", hash_original_method = "D92C5605473C5A0CC5D42CEA0CF2519F", hash_generated_method = "BCD783C806CC805C067A2537640620F6")
	
public TestRunner(PrintStream writer) {
		this(new ResultPrinter(writer));
	}
	
	/**
	 * Constructs a TestRunner using the given ResultPrinter all the output
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.862 -0500", hash_original_method = "2848E9F20BA335B73212BD50EFFC0121", hash_generated_method = "EB703C257650D4356FE3191AE79E3A16")
	
public TestRunner(ResultPrinter printer) {
		fPrinter= printer;
	}

	/**
	 * Always use the StandardTestSuiteLoader. Overridden from
	 * BaseTestRunner.
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.883 -0500", hash_original_method = "89B5E794AD2EA56EE1C86A7C2EAEECBE", hash_generated_method = "16493004099A9088485768B834317F14")
	
public TestSuiteLoader getLoader() {
		return new StandardTestSuiteLoader();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.886 -0500", hash_original_method = "3C8F23863ACC349D5F634378B8407602", hash_generated_method = "851E95F7B4CF27F0534F12D22C7B0481")
	
public void testFailed(int status, Test test, Throwable t) {
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.888 -0500", hash_original_method = "1FEF70E96102D7304D006BBFDC4DE6B7", hash_generated_method = "04CDBDA0DBAE932D025ABBC9B68B52FD")
	
public void testStarted(String testName) {
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.007 -0500", hash_original_method = "95F90AC078029D49ABA36F5E39CE4989", hash_generated_method = "6660BBE65D150E7BA3CD4924169AA014")
	
public void testEnded(String testName) {
	}

	/**
	 * Creates the TestResult to be used for the test run.
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.010 -0500", hash_original_method = "F1E314C8F9D29ADD33998DDD6715BE9D", hash_generated_method = "A7B1F20FFC94114D5B1D891749AB46CF")
	
protected TestResult createTestResult() {
		return new TestResult();
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.013 -0500", hash_original_method = "E9ED9E1F54A13460645321D92F32FF82", hash_generated_method = "2161B543095AF857623286FA3F369F2B")
	
public TestResult doRun(Test test) {
		return doRun(test, false);
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.015 -0500", hash_original_method = "4199667EF91635F0F91F74C7907DF83D", hash_generated_method = "6A182B986D719C59AF83140BFC73E614")
	
public TestResult doRun(Test suite, boolean wait) {
		TestResult result= createTestResult();
		result.addListener(fPrinter);
		long startTime= System.currentTimeMillis();
		suite.run(result);
		long endTime= System.currentTimeMillis();
		long runTime= endTime-startTime;
		fPrinter.print(result, runTime);

		pause(wait);
		return result;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.017 -0500", hash_original_method = "CD82C1B27027E5545D9DEB3E2900D734", hash_generated_method = "3D894F0F43B995EDFC5D38BEAD32FD10")
	
protected void pause(boolean wait) {
		if (!wait) return;
		fPrinter.printWaitPrompt();
		try {
			System.in.read();
		}
		catch(Exception e) {
		}
	}

	/**
	 * Starts a test run. Analyzes the command line arguments
	 * and runs the given test suite.
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.024 -0500", hash_original_method = "DF871C8C00FF2649781A75B85A334DC6", hash_generated_method = "56CC79A19EB00EEFAF7D9F7DDFAD4D6D")
	
protected TestResult start(String args[]) throws Exception {
		String testCase= "";
		boolean wait= false;
		
		for (int i= 0; i < args.length; i++) {
			if (args[i].equals("-wait"))
				wait= true;
			else if (args[i].equals("-c")) 
				testCase= extractClassName(args[++i]);
			else if (args[i].equals("-v"))
				System.err.println("JUnit "+Version.id()+" by Kent Beck and Erich Gamma");
			else
				testCase= args[i];
		}
		
		if (testCase.equals("")) 
			throw new Exception("Usage: TestRunner [-wait] testCaseName, where name is the name of the TestCase class");

		try {
			Test suite= getTest(testCase);
			return doRun(suite, wait);
		}
		catch(Exception e) {
			throw new Exception("Could not create and run test suite: "+e);
		}
	}
		
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.026 -0500", hash_original_method = "9533BF8CD09A7A30B587DE7EC884AD36", hash_generated_method = "85B8E9E7EEC5B1B429712C516870E05F")
	
protected void runFailed(String message) {
		System.err.println(message);
		System.exit(FAILURE_EXIT);
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.028 -0500", hash_original_method = "9253563C68D91F28BA53FF0274CE60A8", hash_generated_method = "E8B291BE7C8F51474F471ADFF6EE8982")
	
public void setPrinter(ResultPrinter printer) {
		fPrinter= printer;
	}
}

