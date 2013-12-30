package junit.framework;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Enumeration;
import java.util.Vector;






public class TestResult extends Object {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.147 -0500", hash_original_field = "D28932EAA3D4E9DC6FA0C7C2986473AC", hash_generated_field = "3D48F046A221F0C0CA21EE3F7549F095")

    protected Vector fFailures;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.149 -0500", hash_original_field = "291BCD216DE7D0E464B84722ABB41BA1", hash_generated_field = "CB39F2BEBE63A1FE78E2D765CFDAB523")

    protected Vector fErrors;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.151 -0500", hash_original_field = "DDE3E326D4C40F7D4FD31DE6637E8551", hash_generated_field = "75B9096774F248001DC15E9E0240C705")

    protected Vector fListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.153 -0500", hash_original_field = "16A0C63871CCF21E90B8A71DE5319935", hash_generated_field = "875AED0EFC33F81818A45FCF1EA1C295")

    protected int fRunTests;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.156 -0500", hash_original_field = "D9193034D217D0CEE47469688F6A632E", hash_generated_field = "478913F24D71102954C1FE6CB2B345DC")

    private boolean fStop;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.158 -0500", hash_original_method = "8F7D8E869233098F7B3F654359449283", hash_generated_method = "E4464231AE6CEA6479A07037E34A1162")
    
public TestResult() {
        fFailures= new Vector();
        fErrors= new Vector();
        fListeners= new Vector();
        fRunTests= 0;
        fStop= false;
    }
    /**
     * Adds an error to the list of errors. The passed in exception
     * caused the error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.161 -0500", hash_original_method = "B8BD2BCA50B2996F91FE0AB13C346E57", hash_generated_method = "F019354419CB41B8F0204A191CC95BA8")
    
public synchronized void addError(Test test, Throwable t) {
        fErrors.addElement(new TestFailure(test, t));
        for (Enumeration e= cloneListeners().elements(); e.hasMoreElements(); ) {
            ((TestListener)e.nextElement()).addError(test, t);
        }
    }
    /**
     * Adds a failure to the list of failures. The passed in exception
     * caused the failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.163 -0500", hash_original_method = "CE28B7D5A93F674A0286463AAF68C789", hash_generated_method = "4C5D61097E13A407D793E43190510D41")
    
public synchronized void addFailure(Test test, AssertionFailedError t) {
        fFailures.addElement(new TestFailure(test, t));
        for (Enumeration e= cloneListeners().elements(); e.hasMoreElements(); ) {
            ((TestListener)e.nextElement()).addFailure(test, t);
        }
    }
    /**
     * Registers a TestListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.166 -0500", hash_original_method = "FF5754A93EFEC96878F60030305F1AA8", hash_generated_method = "3DE9759C16B1D73B4BB9DB9DB8464A8A")
    
public synchronized void addListener(TestListener listener) {
        fListeners.addElement(listener);
    }
    /**
     * Unregisters a TestListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.168 -0500", hash_original_method = "D8517093E47E932F74FDEA97974509FB", hash_generated_method = "0DB041046358EB5221A511D14A7CAA59")
    
public synchronized void removeListener(TestListener listener) {
        fListeners.removeElement(listener);
    }
    /**
     * Returns a copy of the listeners.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.170 -0500", hash_original_method = "B6A6493DA121BF70308A3AD912C75AC8", hash_generated_method = "4B718B536FEF51FCF5A96AF1688B588F")
    
private synchronized Vector cloneListeners() {
        return (Vector)fListeners.clone();
    }
    /**
     * Informs the result that a test was completed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.172 -0500", hash_original_method = "FC137DB7CC1014A530CE1472E28E1AFA", hash_generated_method = "5C886961AF1342B918C0FDF8BF5045A7")
    
public void endTest(Test test) {
        for (Enumeration e= cloneListeners().elements(); e.hasMoreElements(); ) {
            ((TestListener)e.nextElement()).endTest(test);
        }
    }
    /**
     * Gets the number of detected errors.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.174 -0500", hash_original_method = "4DB7FF1416CFDDE04ED7DBC866AEEF40", hash_generated_method = "5A7235E4B0DC37E990C746EE84AA96F9")
    
public synchronized int errorCount() {
        return fErrors.size();
    }
    /**
     * Returns an Enumeration for the errors
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.177 -0500", hash_original_method = "F86874BC4C4C4E18BB69ECCAB73A2619", hash_generated_method = "15902C2D6696C200DB0695A80696F696")
    
public synchronized Enumeration errors() {
        return fErrors.elements();
    }
    /**
     * Gets the number of detected failures.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.179 -0500", hash_original_method = "24C81F8B6EECD0B079C96068F78E52B2", hash_generated_method = "3730F798B721721ED3FEB273772DED6C")
    
public synchronized int failureCount() {
        return fFailures.size();
    }
    /**
     * Returns an Enumeration for the failures
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.183 -0500", hash_original_method = "5ED608529AAF18DC65BC239874C7ECA6", hash_generated_method = "00C69551D4FC8B009893C78A3C2655F7")
    
public synchronized Enumeration failures() {
        return fFailures.elements();
    }
    /**
     * Runs a TestCase.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.188 -0500", hash_original_method = "5370441BB8A506FBAD652ED7C05E8864", hash_generated_method = "EDBBF9F5B4475BCFFC01A53A6BB76E8E")
    
protected void run(final TestCase test) {
        startTest(test);
        Protectable p= new Protectable() {
            public void protect() throws Throwable {
                test.runBare();
            }
        };
        runProtected(test, p);

        endTest(test);
    }
    /**
     * Gets the number of run tests.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.190 -0500", hash_original_method = "B255F5DC6E019A7B063A4503DC44009F", hash_generated_method = "10DFC2AEEDC3FC67990E5E8E9A4F0AA7")
    
public synchronized int runCount() {
        return fRunTests;
    }
    /**
     * Runs a TestCase.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.193 -0500", hash_original_method = "94AFC9FBE774A81FB25FA734A5EF1C27", hash_generated_method = "2112E36F322B11DC76D68CA6B8FE8379")
    
public void runProtected(final Test test, Protectable p) {
        try {
            p.protect();
        }
        catch (AssertionFailedError e) {
            addFailure(test, e);
        }
        catch (ThreadDeath e) { // don't catch ThreadDeath by accident
            throw e;
        }
        catch (Throwable e) {
            addError(test, e);
        }
    }
    /**
     * Checks whether the test run should stop
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.195 -0500", hash_original_method = "2A4A3BCA46AEDD234384156D1F68427A", hash_generated_method = "3BAC9879A5FBA4BFDDA379AD480B0F37")
    
public synchronized boolean shouldStop() {
        return fStop;
    }
    /**
     * Informs the result that a test will be started.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.197 -0500", hash_original_method = "214B52CD6256D7D6465E310658C00D6D", hash_generated_method = "EEF6520D91E3440168864A15718B79F3")
    
public void startTest(Test test) {
        final int count= test.countTestCases();
        synchronized(this) {
            fRunTests+= count;
        }
        for (Enumeration e= cloneListeners().elements(); e.hasMoreElements(); ) {
            ((TestListener)e.nextElement()).startTest(test);
        }
    }
    /**
     * Marks that the test run should stop.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.200 -0500", hash_original_method = "9AD54EE55D5A75E97AE6A449995157CC", hash_generated_method = "6A077B8794B022F376FBDC9A4703A21D")
    
public synchronized void stop() {
        fStop= true;
    }
    /**
     * Returns whether the entire test was successful or not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.202 -0500", hash_original_method = "0F0C9C72850FB77DD8C966716104A782", hash_generated_method = "FC7B78F042DD91D15FD8F3A702A10342")
    
public synchronized boolean wasSuccessful() {
        return failureCount() == 0 && errorCount() == 0;
    }

    
}

