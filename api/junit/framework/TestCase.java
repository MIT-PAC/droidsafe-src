package junit.framework;

// Droidsafe Imports
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class TestCase extends Assert implements Test {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.246 -0400", hash_original_field = "92C0A4FDDE9C65D69627C13D4397EA3F", hash_generated_field = "44478883D7DC475A853C092E4F2639C3")

    private String fName;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.247 -0400", hash_original_method = "1F809C892F1386C5BCE506B7B9E71577", hash_generated_method = "EFA0774B980C6EAA278AECDBED24A0D4")
    public  TestCase() {
        fName= null;
        // ---------- Original Method ----------
        //fName= null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.248 -0400", hash_original_method = "E2C49012EEA8722F341B549129350038", hash_generated_method = "949661DA74AFDD06CDA8B0AC1CFEFB80")
    public  TestCase(String name) {
        fName= name;
        // ---------- Original Method ----------
        //fName= name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.248 -0400", hash_original_method = "C380EF026EE3B754782A4E35FA9663AC", hash_generated_method = "11AA66D97153466E5F5845BAB14D8536")
    public int countTestCases() {
        int varC4CA4238A0B923820DCC509A6F75849B_905631596 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842807115 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842807115;
        // ---------- Original Method ----------
        //return 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.249 -0400", hash_original_method = "974B8EFFC4FED3C302A251DC7978304A", hash_generated_method = "29B55C75A8E6EE26D2EF99A1807CFA5E")
    protected TestResult createResult() {
TestResult varB1D52DB2FC7B844B35F46763F5119AF7_2113670219 =         new TestResult();
        varB1D52DB2FC7B844B35F46763F5119AF7_2113670219.addTaint(taint);
        return varB1D52DB2FC7B844B35F46763F5119AF7_2113670219;
        // ---------- Original Method ----------
        //return new TestResult();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.249 -0400", hash_original_method = "961A5CFC9275837B3D79C86ECF9A0692", hash_generated_method = "1875022C81232B419BF870002891B0F1")
    public TestResult run() {
        TestResult result = createResult();
        run(result);
TestResult varDC838461EE2FA0CA4C9BBB70A15456B0_2089797740 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2089797740.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2089797740;
        // ---------- Original Method ----------
        //TestResult result= createResult();
        //run(result);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.249 -0400", hash_original_method = "ED2C86C86B2D9BBF3015D425DB337069", hash_generated_method = "77B0F93BFCC1C86E9E5CEF6A2E2DA07C")
    public void run(TestResult result) {
        addTaint(result.getTaint());
        result.run(this);
        // ---------- Original Method ----------
        //result.run(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.250 -0400", hash_original_method = "C8A580F0F00F2E8253C1A0038ADFE159", hash_generated_method = "6939330E21F12E6A7D0A1426D1739B6F")
    public void runBare() throws Throwable {
        setUp();
        try 
        {
            runTest();
        } //End block
        finally 
        {
            tearDown();
        } //End block
        // ---------- Original Method ----------
        //setUp();
        //try {
            //runTest();
        //}
        //finally {
            //tearDown();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.262 -0400", hash_original_method = "224A26155E20D2310F3074B7F0735777", hash_generated_method = "30DE840DF98AE873611401425B859B5E")
    protected void runTest() throws Throwable {
        assertNotNull(fName);
        Method runMethod = null;
        try 
        {
            runMethod= getClass().getMethod(fName, (Class[]) null);
        } //End block
        catch (NoSuchMethodException e)
        {
            fail("Method \""+fName+"\" not found");
        } //End block
        if(!Modifier.isPublic(runMethod.getModifiers()))        
        {
            fail("Method \""+fName+"\" should be public");
        } //End block
        try 
        {
            runMethod.invoke(this, (Object[]) null);
        } //End block
        catch (InvocationTargetException e)
        {
            e.fillInStackTrace();
            java.lang.Throwable var1E3CD87FA3B0B1C506449CA8124F65D4_1969874847 = e.getTargetException();
            var1E3CD87FA3B0B1C506449CA8124F65D4_1969874847.addTaint(taint);
            throw var1E3CD87FA3B0B1C506449CA8124F65D4_1969874847;
        } //End block
        catch (IllegalAccessException e)
        {
            e.fillInStackTrace();
            e.addTaint(taint);
            throw e;
        } //End block
        // ---------- Original Method ----------
        //assertNotNull(fName);
        //Method runMethod= null;
        //try {
            //runMethod= getClass().getMethod(fName, (Class[]) null);
        //} catch (NoSuchMethodException e) {
            //fail("Method \""+fName+"\" not found");
        //}
        //if (!Modifier.isPublic(runMethod.getModifiers())) {
            //fail("Method \""+fName+"\" should be public");
        //}
        //try {
            //runMethod.invoke(this, (Object[]) null);
        //}
        //catch (InvocationTargetException e) {
            //e.fillInStackTrace();
            //throw e.getTargetException();
        //}
        //catch (IllegalAccessException e) {
            //e.fillInStackTrace();
            //throw e;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.262 -0400", hash_original_method = "FFA3FA0A8311363EADFF98B8B84529FB", hash_generated_method = "A81C1C01F5715F5A1A2D88BCAF958BFB")
    protected void setUp() throws Exception {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.263 -0400", hash_original_method = "9DC9991C60DD393D44750907790C62ED", hash_generated_method = "450766BF2369317CA6E6BEF04678E14E")
    protected void tearDown() throws Exception {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.263 -0400", hash_original_method = "25D47A11917433AAC827E07C052136CF", hash_generated_method = "8A140402007BF842CB5DADC86805D8D5")
    public String toString() {
String var1BEFBD354E8229C3240D7A7196078FDB_512723021 =         getName() + "(" + getClass().getName() + ")";
        var1BEFBD354E8229C3240D7A7196078FDB_512723021.addTaint(taint);
        return var1BEFBD354E8229C3240D7A7196078FDB_512723021;
        // ---------- Original Method ----------
        //return getName() + "(" + getClass().getName() + ")";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.263 -0400", hash_original_method = "2EA0F9602490A1D20696A18728516755", hash_generated_method = "5E9219DA4DE776CA4C11E4F96634CB6C")
    public String getName() {
String var7008830BBF5901458C7F9C81D44DB32A_1239594091 =         fName;
        var7008830BBF5901458C7F9C81D44DB32A_1239594091.addTaint(taint);
        return var7008830BBF5901458C7F9C81D44DB32A_1239594091;
        // ---------- Original Method ----------
        //return fName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.264 -0400", hash_original_method = "6B586B3A073E23F7D2AE9C8A9582E34C", hash_generated_method = "61CBF5B9E74EA314A73D0181F1AF068A")
    public void setName(String name) {
        fName= name;
        // ---------- Original Method ----------
        //fName= name;
    }

    
}

