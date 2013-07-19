package junit.textui;

// Droidsafe Imports
import java.io.PrintStream;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;
import junit.runner.StandardTestSuiteLoader;
import junit.runner.TestSuiteLoader;
import junit.runner.Version;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class TestRunner extends BaseTestRunner {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.503 -0400", hash_original_field = "92EFB2FF93CA617868CE9883F7FD9329", hash_generated_field = "4B0543678AD73423AC3560CD1726B815")

    private ResultPrinter fPrinter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.504 -0400", hash_original_method = "3B66BCE498E2DD0699CFFBB4FE4F7076", hash_generated_method = "6C6BAF51F8AC66F8E6CBFAC1C5816A2D")
    public  TestRunner() {
        this(System.out);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.504 -0400", hash_original_method = "D92C5605473C5A0CC5D42CEA0CF2519F", hash_generated_method = "AF91670EF8C2DA3FA174861C791A442A")
    public  TestRunner(PrintStream writer) {
        this(new ResultPrinter(writer));
        addTaint(writer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.505 -0400", hash_original_method = "2848E9F20BA335B73212BD50EFFC0121", hash_generated_method = "DCF090D6D6C1F4472DBC28F1B3033F91")
    public  TestRunner(ResultPrinter printer) {
        fPrinter= printer;
        // ---------- Original Method ----------
        //fPrinter= printer;
    }

    
    static public void run(Class testClass) {
        run(new TestSuite(testClass));
    }

    
    static public TestResult run(Test test) {
        TestRunner runner= new TestRunner();
        return runner.doRun(test);
    }

    
    static public void runAndWait(Test suite) {
        TestRunner aTestRunner= new TestRunner();
        aTestRunner.doRun(suite, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.506 -0400", hash_original_method = "89B5E794AD2EA56EE1C86A7C2EAEECBE", hash_generated_method = "C7D1D1B334ED080EBBE482F354EEE414")
    public TestSuiteLoader getLoader() {
TestSuiteLoader varD4813F3AA8F61C27FF670963E25E8DDB_1963887528 =         new StandardTestSuiteLoader();
        varD4813F3AA8F61C27FF670963E25E8DDB_1963887528.addTaint(taint);
        return varD4813F3AA8F61C27FF670963E25E8DDB_1963887528;
        // ---------- Original Method ----------
        //return new StandardTestSuiteLoader();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.506 -0400", hash_original_method = "3C8F23863ACC349D5F634378B8407602", hash_generated_method = "343C81A91A376A476B6E63854712BD10")
    public void testFailed(int status, Test test, Throwable t) {
        addTaint(t.getTaint());
        addTaint(test.getTaint());
        addTaint(status);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.506 -0400", hash_original_method = "1FEF70E96102D7304D006BBFDC4DE6B7", hash_generated_method = "4FAFD7517E2617F717E5C9E85C0A14FE")
    public void testStarted(String testName) {
        addTaint(testName.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.507 -0400", hash_original_method = "95F90AC078029D49ABA36F5E39CE4989", hash_generated_method = "9E4B00FBBA1794C65D5334E8AFC03502")
    public void testEnded(String testName) {
        addTaint(testName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.507 -0400", hash_original_method = "F1E314C8F9D29ADD33998DDD6715BE9D", hash_generated_method = "B0DAB307B53383C244D460611FBE8B59")
    protected TestResult createTestResult() {
TestResult varB1D52DB2FC7B844B35F46763F5119AF7_2046008519 =         new TestResult();
        varB1D52DB2FC7B844B35F46763F5119AF7_2046008519.addTaint(taint);
        return varB1D52DB2FC7B844B35F46763F5119AF7_2046008519;
        // ---------- Original Method ----------
        //return new TestResult();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.507 -0400", hash_original_method = "E9ED9E1F54A13460645321D92F32FF82", hash_generated_method = "12BBF2E855A014662315377412722E75")
    public TestResult doRun(Test test) {
        addTaint(test.getTaint());
TestResult varAD3C693A58B55E712F6018BE46B06B59_2059490536 =         doRun(test, false);
        varAD3C693A58B55E712F6018BE46B06B59_2059490536.addTaint(taint);
        return varAD3C693A58B55E712F6018BE46B06B59_2059490536;
        // ---------- Original Method ----------
        //return doRun(test, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.508 -0400", hash_original_method = "4199667EF91635F0F91F74C7907DF83D", hash_generated_method = "2B19466D0B07386CCD905F70FB987D0A")
    public TestResult doRun(Test suite, boolean wait) {
        addTaint(wait);
        addTaint(suite.getTaint());
        TestResult result = createTestResult();
        result.addListener(fPrinter);
        long startTime = System.currentTimeMillis();
        suite.run(result);
        long endTime = System.currentTimeMillis();
        long runTime = endTime-startTime;
        fPrinter.print(result, runTime);
        pause(wait);
TestResult varDC838461EE2FA0CA4C9BBB70A15456B0_1754840220 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1754840220.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1754840220;
        // ---------- Original Method ----------
        //TestResult result= createTestResult();
        //result.addListener(fPrinter);
        //long startTime= System.currentTimeMillis();
        //suite.run(result);
        //long endTime= System.currentTimeMillis();
        //long runTime= endTime-startTime;
        //fPrinter.print(result, runTime);
        //pause(wait);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.508 -0400", hash_original_method = "CD82C1B27027E5545D9DEB3E2900D734", hash_generated_method = "001C3C908593985B9C213997E2E8686C")
    protected void pause(boolean wait) {
        addTaint(wait);
        if(!wait)        
        return;
        fPrinter.printWaitPrompt();
        try 
        {
            System.in.read();
        } //End block
        catch (Exception e)
        {
        } //End block
        // ---------- Original Method ----------
        //if (!wait) return;
        //fPrinter.printWaitPrompt();
        //try {
			//System.in.read();
		//}
		//catch(Exception e) {
		//}
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.509 -0400", hash_original_method = "DF871C8C00FF2649781A75B85A334DC6", hash_generated_method = "0AF9DB0D0CC380152B1553C208356B37")
    protected TestResult start(String args[]) throws Exception {
        addTaint(args[0].getTaint());
        String testCase = "";
        boolean wait = false;
for(int i= 0;i < args.length;i++)
        {
            if(args[i].equals("-wait"))            
            wait= true;
            else
            if(args[i].equals("-c"))            
            testCase= extractClassName(args[++i]);
            else
            if(args[i].equals("-v"))            
            System.err.println("JUnit "+Version.id()+" by Kent Beck and Erich Gamma");
            else
            testCase= args[i];
        } //End block
        if(testCase.equals(""))        
        {
        Exception varD873A584DE1991535C16D276A7EF0F2E_751360659 = new Exception("Usage: TestRunner [-wait] testCaseName, where name is the name of the TestCase class");
        varD873A584DE1991535C16D276A7EF0F2E_751360659.addTaint(taint);
        throw varD873A584DE1991535C16D276A7EF0F2E_751360659;
        }
        try 
        {
            Test suite = getTest(testCase);
TestResult var0587DB1BDD70DA1527F4D4358ADF9C9F_792206285 =             doRun(suite, wait);
            var0587DB1BDD70DA1527F4D4358ADF9C9F_792206285.addTaint(taint);
            return var0587DB1BDD70DA1527F4D4358ADF9C9F_792206285;
        } //End block
        catch (Exception e)
        {
            Exception varBC05E7552B20DD6C00E438F2F322883B_1619797170 = new Exception("Could not create and run test suite: "+e);
            varBC05E7552B20DD6C00E438F2F322883B_1619797170.addTaint(taint);
            throw varBC05E7552B20DD6C00E438F2F322883B_1619797170;
        } //End block
        // ---------- Original Method ----------
        //String testCase= "";
        //boolean wait= false;
        //for (int i= 0; i < args.length; i++) {
			//if (args[i].equals("-wait"))
				//wait= true;
			//else if (args[i].equals("-c")) 
				//testCase= extractClassName(args[++i]);
			//else if (args[i].equals("-v"))
				//System.err.println("JUnit "+Version.id()+" by Kent Beck and Erich Gamma");
			//else
				//testCase= args[i];
		//}
        //if (testCase.equals("")) 
			//throw new Exception("Usage: TestRunner [-wait] testCaseName, where name is the name of the TestCase class");
        //try {
			//Test suite= getTest(testCase);
			//return doRun(suite, wait);
		//}
		//catch(Exception e) {
			//throw new Exception("Could not create and run test suite: "+e);
		//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.510 -0400", hash_original_method = "9533BF8CD09A7A30B587DE7EC884AD36", hash_generated_method = "D853A1F4740987A9E3DAAF85139D7E24")
    protected void runFailed(String message) {
        addTaint(message.getTaint());
        System.err.println(message);
        System.exit(FAILURE_EXIT);
        // ---------- Original Method ----------
        //System.err.println(message);
        //System.exit(FAILURE_EXIT);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.511 -0400", hash_original_method = "9253563C68D91F28BA53FF0274CE60A8", hash_generated_method = "291C442331B1EA2F3572AA450FACC064")
    public void setPrinter(ResultPrinter printer) {
        fPrinter= printer;
        // ---------- Original Method ----------
        //fPrinter= printer;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.511 -0400", hash_original_field = "FF130C02D55FA9AC5E9F7147163633AC", hash_generated_field = "F3374AC5F86160580EBE72031726DFFD")

    public static final int SUCCESS_EXIT= 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.511 -0400", hash_original_field = "9F1D058E8C759AA8F8AF54404517952A", hash_generated_field = "2B56C3FDE1B930F748EE23F4669203F3")

    public static final int FAILURE_EXIT= 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.511 -0400", hash_original_field = "25335EF2B2C3B4CF0BB3767355FE3790", hash_generated_field = "E5A0C028305B48E55FB88FA5805B8953")

    public static final int EXCEPTION_EXIT= 2;
}

