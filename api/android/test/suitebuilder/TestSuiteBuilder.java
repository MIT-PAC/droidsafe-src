package android.test.suitebuilder;

// Droidsafe Imports
import static android.test.suitebuilder.TestGrouping.SORT_BY_FULLY_QUALIFIED_NAME;
import static android.test.suitebuilder.TestPredicates.REJECT_SUPPRESSED;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import android.content.Context;
import android.test.AndroidTestRunner;
import android.test.TestCaseUtil;

import com.android.internal.util.Predicate;
import com.google.android.collect.Lists;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class TestSuiteBuilder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.282 -0400", hash_original_field = "5C18EF72771564B7F43C497DC507AEAB", hash_generated_field = "FFC623C2EA984831A33BAADC181E897E")

    private Context context;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.282 -0400", hash_original_field = "EBA8B2366B183113C3E3A079C6EA4945", hash_generated_field = "56A9B7A488A7615FB6C4D1D2217E1503")

    private final TestGrouping testGrouping = new TestGrouping(SORT_BY_FULLY_QUALIFIED_NAME);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.282 -0400", hash_original_field = "9A66B7CC19E5B6D909445D4272BD5B00", hash_generated_field = "985B70CA3550B01608B83EE3F72168EC")

    private final Set<Predicate<TestMethod>> predicates = new HashSet<Predicate<TestMethod>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.283 -0400", hash_original_field = "1DBDC8928979FF4D3751532297BA7FA7", hash_generated_field = "C089C26A0F05E75588049BAD1F2BEF5A")

    private List<TestCase> testCases;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.283 -0400", hash_original_field = "A22EF42B80DE6C2EB7A80EBD118C1DF1", hash_generated_field = "AC3A2B22FEC9C02F4245743F5AF59C1C")

    private TestSuite rootSuite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.283 -0400", hash_original_field = "2991DB2EC43F7222A298DB93DB6D1AFE", hash_generated_field = "D3496256C20E9CA164F594A66FCB0565")

    private TestSuite suiteForCurrentClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.283 -0400", hash_original_field = "67DE047F4D6E3DBE8A0B26D27CF90237", hash_generated_field = "0621208759121B23881D009E501432EE")

    private String currentClassname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.283 -0400", hash_original_field = "B41A1AAAD669D8B2E46120A2242C98BC", hash_generated_field = "03428D590BDE6503C56EB614336478D2")

    private String suiteName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.283 -0400", hash_original_method = "8DFAA261B116CB95D8F3EE320976E821", hash_generated_method = "4305A767220FFB75ACB9397B534A91E6")
    public  TestSuiteBuilder(Class clazz) {
        this(clazz.getName(), clazz.getClassLoader());
        addTaint(clazz.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.284 -0400", hash_original_method = "9CA7BA6922F108D38C6201808A4CEB3C", hash_generated_method = "2B68C8CF1815DEC346D9B178539BCD51")
    public  TestSuiteBuilder(String name, ClassLoader classLoader) {
        addTaint(classLoader.getTaint());
        this.suiteName = name;
        this.testGrouping.setClassLoader(classLoader);
        this.testCases = Lists.newArrayList();
        addRequirements(REJECT_SUPPRESSED);
        // ---------- Original Method ----------
        //this.suiteName = name;
        //this.testGrouping.setClassLoader(classLoader);
        //this.testCases = Lists.newArrayList();
        //addRequirements(REJECT_SUPPRESSED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.285 -0400", hash_original_method = "48780D5C4E993D5976786FDA7072C865", hash_generated_method = "8E04F60329701C4249A67F36919693CF")
    public TestSuiteBuilder addTestClassByName(String testClassName, String testMethodName,
            Context context) {
        addTaint(context.getTaint());
        addTaint(testMethodName.getTaint());
        addTaint(testClassName.getTaint());
        AndroidTestRunner atr = new AndroidTestRunner();
        atr.setContext(context);
        atr.setTestClassName(testClassName, testMethodName);
        this.testCases.addAll(atr.getTestCases());
TestSuiteBuilder var72A74007B2BE62B849F475C7BDA4658B_402860525 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_402860525.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_402860525;
        // ---------- Original Method ----------
        //AndroidTestRunner atr = new AndroidTestRunner();
        //atr.setContext(context);
        //atr.setTestClassName(testClassName, testMethodName);
        //this.testCases.addAll(atr.getTestCases());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.285 -0400", hash_original_method = "EA702A9DA91338D58DCDCE903BD5BA53", hash_generated_method = "A27280C4F638192973353CC96325ED10")
    public TestSuiteBuilder addTestSuite(TestSuite testSuite) {
        addTaint(testSuite.getTaint());
for(TestCase testCase : (List<TestCase>) TestCaseUtil.getTests(testSuite, true))
        {
            this.testCases.add(testCase);
        } //End block
TestSuiteBuilder var72A74007B2BE62B849F475C7BDA4658B_1888327422 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1888327422.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1888327422;
        // ---------- Original Method ----------
        //for (TestCase testCase : (List<TestCase>) TestCaseUtil.getTests(testSuite, true)) {
            //this.testCases.add(testCase);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.286 -0400", hash_original_method = "F3D792B6EB8BC145BAF2830A3B203CAC", hash_generated_method = "70CCA3E689210F85C933C22486DE52D4")
    public TestSuiteBuilder includePackages(String... packageNames) {
        addTaint(packageNames[0].getTaint());
        testGrouping.addPackagesRecursive(packageNames);
TestSuiteBuilder var72A74007B2BE62B849F475C7BDA4658B_1252574274 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1252574274.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1252574274;
        // ---------- Original Method ----------
        //testGrouping.addPackagesRecursive(packageNames);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.286 -0400", hash_original_method = "ECB1A1FF9D2C5C6048377E0BEB0296EB", hash_generated_method = "F5F1BE46AD94D1CB01EA1842E39F6549")
    public TestSuiteBuilder excludePackages(String... packageNames) {
        addTaint(packageNames[0].getTaint());
        testGrouping.removePackagesRecursive(packageNames);
TestSuiteBuilder var72A74007B2BE62B849F475C7BDA4658B_1319628937 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1319628937.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1319628937;
        // ---------- Original Method ----------
        //testGrouping.removePackagesRecursive(packageNames);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.286 -0400", hash_original_method = "30733A3232BFC83399FAC43965000DCC", hash_generated_method = "49FCDAE0EC2FC503CB41B252A0BFDC04")
    public TestSuiteBuilder addRequirements(List<Predicate<TestMethod>> predicates) {
        addTaint(predicates.getTaint());
        this.predicates.addAll(predicates);
TestSuiteBuilder var72A74007B2BE62B849F475C7BDA4658B_1899552971 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1899552971.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1899552971;
        // ---------- Original Method ----------
        //this.predicates.addAll(predicates);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.287 -0400", hash_original_method = "58145D33150957DD46A1ADD9032FDB9F", hash_generated_method = "8DAA00F7FF3FDC820B71B3A05F2DAA36")
    public final TestSuiteBuilder includeAllPackagesUnderHere() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String callingClassName = null;
        String thisClassName = TestSuiteBuilder.class.getName();
for(int i = 0;i < stackTraceElements.length;i++)
        {
            StackTraceElement element = stackTraceElements[i];
            if(thisClassName.equals(element.getClassName())
                    && "includeAllPackagesUnderHere".equals(element.getMethodName()))            
            {
                callingClassName = stackTraceElements[i + 1].getClassName();
                break;
            } //End block
        } //End block
        String packageName = parsePackageNameFromClassName(callingClassName);
TestSuiteBuilder var4236819713B8F2A439526881855F7860_1267849364 =         includePackages(packageName);
        var4236819713B8F2A439526881855F7860_1267849364.addTaint(taint);
        return var4236819713B8F2A439526881855F7860_1267849364;
        // ---------- Original Method ----------
        //StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        //String callingClassName = null;
        //String thisClassName = TestSuiteBuilder.class.getName();
        //for (int i = 0; i < stackTraceElements.length; i++) {
            //StackTraceElement element = stackTraceElements[i];
            //if (thisClassName.equals(element.getClassName())
                    //&& "includeAllPackagesUnderHere".equals(element.getMethodName())) {
                //callingClassName = stackTraceElements[i + 1].getClassName();
                //break;
            //}
        //}
        //String packageName = parsePackageNameFromClassName(callingClassName);
        //return includePackages(packageName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.287 -0400", hash_original_method = "DE0BA46F9EE52752A0C868D33280E318", hash_generated_method = "3BD4C70B249965EF43E391AFD99F54B3")
    public TestSuiteBuilder named(String newSuiteName) {
        suiteName = newSuiteName;
TestSuiteBuilder var72A74007B2BE62B849F475C7BDA4658B_546268489 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_546268489.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_546268489;
        // ---------- Original Method ----------
        //suiteName = newSuiteName;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.288 -0400", hash_original_method = "C585F9D3DE53AA6116980D3F6C4B8FC9", hash_generated_method = "819A75D519B7DFD5CE7634516E35112E")
    public final TestSuite build() {
        rootSuite = new TestSuite(getSuiteName());
        currentClassname = null;
        try 
        {
for(TestMethod test : testGrouping.getTests())
            {
                if(satisfiesAllPredicates(test))                
                {
                    addTest(test);
                } //End block
            } //End block
            if(testCases.size() > 0)            
            {
for(TestCase testCase : testCases)
                {
                    if(satisfiesAllPredicates(new TestMethod(testCase)))                    
                    {
                        addTest(testCase);
                    } //End block
                } //End block
            } //End block
        } //End block
        catch (Exception exception)
        {
            TestSuite suite = new TestSuite(getSuiteName());
            suite.addTest(new FailedToCreateTests(exception));
TestSuite var43F2DCEC46C8EA8C7BBB5E25ABF048E6_1475659743 =             suite;
            var43F2DCEC46C8EA8C7BBB5E25ABF048E6_1475659743.addTaint(taint);
            return var43F2DCEC46C8EA8C7BBB5E25ABF048E6_1475659743;
        } //End block
TestSuite var68923D4623222795EBF2699ACF0F4B83_1681594889 =         rootSuite;
        var68923D4623222795EBF2699ACF0F4B83_1681594889.addTaint(taint);
        return var68923D4623222795EBF2699ACF0F4B83_1681594889;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.288 -0400", hash_original_method = "FA6CF1B18274415B042FA89686DFBBA8", hash_generated_method = "FB109B5EC5EDFBE32CBAAA42FD7776B3")
    protected String getSuiteName() {
String varD8C9BC94A6E81F246F976FCCA661D48D_1078802815 =         suiteName;
        varD8C9BC94A6E81F246F976FCCA661D48D_1078802815.addTaint(taint);
        return varD8C9BC94A6E81F246F976FCCA661D48D_1078802815;
        // ---------- Original Method ----------
        //return suiteName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.289 -0400", hash_original_method = "6FE9FBC06898098EA0A0DBF770A42526", hash_generated_method = "03E5065A3B93405D8F546305F4812977")
    public final TestSuiteBuilder addRequirements(Predicate<TestMethod>... predicates) {
        addTaint(predicates[0].getTaint());
        ArrayList<Predicate<TestMethod>> list = new ArrayList<Predicate<TestMethod>>();
        Collections.addAll(list, predicates);
TestSuiteBuilder var69B049DE1E09C679D066531AD48DC89D_219125916 =         addRequirements(list);
        var69B049DE1E09C679D066531AD48DC89D_219125916.addTaint(taint);
        return var69B049DE1E09C679D066531AD48DC89D_219125916;
        // ---------- Original Method ----------
        //ArrayList<Predicate<TestMethod>> list = new ArrayList<Predicate<TestMethod>>();
        //Collections.addAll(list, predicates);
        //return addRequirements(list);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.289 -0400", hash_original_method = "95C63968A7356AFE59EE1560EDC6AFD0", hash_generated_method = "385C9FEB740E78FC11B673E862BC8B04")
    protected TestGrouping getTestGrouping() {
TestGrouping var668D3050613E8B26B179F6C37A7EABCF_1209170870 =         testGrouping;
        var668D3050613E8B26B179F6C37A7EABCF_1209170870.addTaint(taint);
        return var668D3050613E8B26B179F6C37A7EABCF_1209170870;
        // ---------- Original Method ----------
        //return testGrouping;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.290 -0400", hash_original_method = "3B7E4DAFF4F4255560B2EF8BCF0CA264", hash_generated_method = "C1CE93CA6A984D24ACA867E83DA2121C")
    private boolean satisfiesAllPredicates(TestMethod test) {
        addTaint(test.getTaint());
for(Predicate<TestMethod> predicate : predicates)
        {
            if(!predicate.apply(test))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1880659385 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1736807668 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1736807668;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_574812185 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1356329520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1356329520;
        // ---------- Original Method ----------
        //for (Predicate<TestMethod> predicate : predicates) {
            //if (!predicate.apply(test)) {
                //return false;
            //}
        //}
        //return true;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.290 -0400", hash_original_method = "9609FD64CC859CF40862383CC61076E6", hash_generated_method = "5C3EB6598C6FD9DF34FFEEBC3127D30B")
    private void addTest(TestMethod testMethod) throws Exception {
        addTaint(testMethod.getTaint());
        addSuiteIfNecessary(testMethod.getEnclosingClassname());
        suiteForCurrentClass.addTest(testMethod.createTest());
        // ---------- Original Method ----------
        //addSuiteIfNecessary(testMethod.getEnclosingClassname());
        //suiteForCurrentClass.addTest(testMethod.createTest());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.290 -0400", hash_original_method = "7027D4F6836EC90288680E369B5B8F5A", hash_generated_method = "E51E6875FA1D02406B31AFFEFAE290F0")
    private void addTest(Test test) {
        addTaint(test.getTaint());
        addSuiteIfNecessary(test.getClass().getName());
        suiteForCurrentClass.addTest(test);
        // ---------- Original Method ----------
        //addSuiteIfNecessary(test.getClass().getName());
        //suiteForCurrentClass.addTest(test);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.291 -0400", hash_original_method = "92951B52D867188410A62009711C9261", hash_generated_method = "DE879BE7D1B7AC9DDB7CC38D0D915EBD")
    private void addSuiteIfNecessary(String parentClassname) {
        if(!parentClassname.equals(currentClassname))        
        {
            currentClassname = parentClassname;
            suiteForCurrentClass = new TestSuite(parentClassname);
            rootSuite.addTest(suiteForCurrentClass);
        } //End block
        // ---------- Original Method ----------
        //if (!parentClassname.equals(currentClassname)) {
            //currentClassname = parentClassname;
            //suiteForCurrentClass = new TestSuite(parentClassname);
            //rootSuite.addTest(suiteForCurrentClass);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    private static String parsePackageNameFromClassName(String className) {
        return className.substring(0, className.lastIndexOf('.'));
    }

    
    public static class FailedToCreateTests extends TestCase {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.291 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

        private Exception exception;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.292 -0400", hash_original_method = "1C0BA3005E48DD2AA9883550E9E56685", hash_generated_method = "56EC8CADC1DAE4B3EE1B39574DE80884")
        public  FailedToCreateTests(Exception exception) {
            super("testSuiteConstructionFailed");
            this.exception = exception;
            // ---------- Original Method ----------
            //this.exception = exception;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.292 -0400", hash_original_method = "1942A289EA540D79C743EE0933FD0258", hash_generated_method = "5D7E1730FE085C4A903CF7CD8A279A06")
        public void testSuiteConstructionFailed() {
            RuntimeException varEA3606177B94E6C5368D72CDFEE8ED30_1269461454 = new RuntimeException("Exception during suite construction", exception);
            varEA3606177B94E6C5368D72CDFEE8ED30_1269461454.addTaint(taint);
            throw varEA3606177B94E6C5368D72CDFEE8ED30_1269461454;
            // ---------- Original Method ----------
            //throw new RuntimeException("Exception during suite construction", exception);
        }

        
    }


    
}

