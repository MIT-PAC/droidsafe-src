package android.test.suitebuilder;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.test.ClassPathPackageInfo;
import android.test.ClassPathPackageInfoSource;
import android.test.PackageInfoSources;
import android.util.Log;
import com.android.internal.util.Predicate;
import junit.framework.TestCase;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestGrouping {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.176 -0400", hash_original_field = "70C19B020BEFD5DD40A8FC5A2B69533F", hash_generated_field = "92A1F72A3CA9AFF319E6A33DD1FCF056")

    SortedSet<Class<? extends TestCase>> testCaseClasses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.176 -0400", hash_original_field = "23F9809CC27E9C8679DCF78F85689F51", hash_generated_field = "46A35DF78B071F820EB500E754651053")

    protected String firstIncludedPackage = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.176 -0400", hash_original_field = "23508C9A13E40798812B11A9CFC1E55C", hash_generated_field = "F6BCA95A9F68D069180083A80576157E")

    private ClassLoader classLoader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.176 -0400", hash_original_method = "E97169CD65D986F2307319C325D5D1C7", hash_generated_method = "EE1C01BD0FD2D553FF0674FFD6591BBB")
    public  TestGrouping(Comparator<Class<? extends TestCase>> comparator) {
        testCaseClasses = new TreeSet<Class<? extends TestCase>>(comparator);
        // ---------- Original Method ----------
        //testCaseClasses = new TreeSet<Class<? extends TestCase>>(comparator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.177 -0400", hash_original_method = "680BBB6317C221899395AD16A5E3E2AA", hash_generated_method = "CDFB6379DC1904EAB136D7428E2DF953")
    public List<TestMethod> getTests() {
        List<TestMethod> testMethods = new ArrayList<TestMethod>();
for(Class<? extends TestCase> testCase : testCaseClasses)
        {
for(Method testMethod : getTestMethods(testCase))
            {
                testMethods.add(new TestMethod(testMethod, testCase));
            } //End block
        } //End block
List<TestMethod> var24D1ADC4337A1DFDD7EDF48B863FFFFD_480481699 =         testMethods;
        var24D1ADC4337A1DFDD7EDF48B863FFFFD_480481699.addTaint(taint);
        return var24D1ADC4337A1DFDD7EDF48B863FFFFD_480481699;
        // ---------- Original Method ----------
        //List<TestMethod> testMethods = new ArrayList<TestMethod>();
        //for (Class<? extends TestCase> testCase : testCaseClasses) {
            //for (Method testMethod : getTestMethods(testCase)) {
                //testMethods.add(new TestMethod(testMethod, testCase));
            //}
        //}
        //return testMethods;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.177 -0400", hash_original_method = "2AE043142188DFBFC0C6FBA8EE4EFD15", hash_generated_method = "212E6FF65744DC78A18485594D2D3227")
    protected List<Method> getTestMethods(Class<? extends TestCase> testCaseClass) {
        addTaint(testCaseClass.getTaint());
        List<Method> methods = Arrays.asList(testCaseClass.getMethods());
List<Method> var625C4BA6F2C797C1B5A159EA338B6BDA_1410288328 =         select(methods, new TestMethodPredicate());
        var625C4BA6F2C797C1B5A159EA338B6BDA_1410288328.addTaint(taint);
        return var625C4BA6F2C797C1B5A159EA338B6BDA_1410288328;
        // ---------- Original Method ----------
        //List<Method> methods = Arrays.asList(testCaseClass.getMethods());
        //return select(methods, new TestMethodPredicate());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.177 -0400", hash_original_method = "33F5ECA31F61AACED3C9710C1D8342FC", hash_generated_method = "5105946E0D4A42112EAF1615AFC787FE")
     SortedSet<Class<? extends TestCase>> getTestCaseClasses() {
SortedSet<Class<? extends TestCase>> varE3DDA91219760C874204BD71102F4461_1438815053 =         testCaseClasses;
        varE3DDA91219760C874204BD71102F4461_1438815053.addTaint(taint);
        return varE3DDA91219760C874204BD71102F4461_1438815053;
        // ---------- Original Method ----------
        //return testCaseClasses;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.178 -0400", hash_original_method = "6F62F66C41F8017782EE166F70D0516E", hash_generated_method = "3EA6D76880827FA61D7F27B16653F0DB")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_159637864 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_734179353 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_734179353;
        } //End block
        if(o == null || getClass() != o.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1632356080 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1106255213 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1106255213;
        } //End block
        TestGrouping other = (TestGrouping) o;
        if(!this.testCaseClasses.equals(other.testCaseClasses))        
        {
            boolean var68934A3E9455FA72420237EB05902327_15491303 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1694423383 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1694423383;
        } //End block
        boolean varF151829E7A1B54F6289E1B77EC955A5E_551718986 = (this.testCaseClasses.comparator().equals(other.testCaseClasses.comparator()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672602114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672602114;
        // ---------- Original Method ----------
        //if (this == o) {
            //return true;
        //}
        //if (o == null || getClass() != o.getClass()) {
            //return false;
        //}
        //TestGrouping other = (TestGrouping) o;
        //if (!this.testCaseClasses.equals(other.testCaseClasses)) {
            //return false;
        //}
        //return this.testCaseClasses.comparator().equals(other.testCaseClasses.comparator());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.179 -0400", hash_original_method = "E7359B0E16100AA2FD7539D694C05DFB", hash_generated_method = "616EC52565D594249B762E6F6E1E3BC9")
    public int hashCode() {
        int var2910C1999B304E5C1AE264098CA8555A_917753231 = (testCaseClasses.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1228308837 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1228308837;
        // ---------- Original Method ----------
        //return testCaseClasses.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.179 -0400", hash_original_method = "F1ABEC9272D67A731F25021CAE965675", hash_generated_method = "27FC63CA819E17AE0D663E3A3C55613A")
    public TestGrouping addPackagesRecursive(String... packageNames) {
        addTaint(packageNames[0].getTaint());
for(String packageName : packageNames)
        {
            List<Class<? extends TestCase>> addedClasses = testCaseClassesInPackage(packageName);
            if(addedClasses.isEmpty())            
            {
            } //End block
            testCaseClasses.addAll(addedClasses);
            if(firstIncludedPackage == null)            
            {
                firstIncludedPackage = packageName;
            } //End block
        } //End block
TestGrouping var72A74007B2BE62B849F475C7BDA4658B_235026524 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_235026524.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_235026524;
        // ---------- Original Method ----------
        //for (String packageName : packageNames) {
            //List<Class<? extends TestCase>> addedClasses = testCaseClassesInPackage(packageName);
            //if (addedClasses.isEmpty()) {
                //Log.w(LOG_TAG, "Invalid Package: '" + packageName
                        //+ "' could not be found or has no tests");
            //}
            //testCaseClasses.addAll(addedClasses);
            //if (firstIncludedPackage == null) {
                //firstIncludedPackage = packageName;
            //}
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.180 -0400", hash_original_method = "56956838CAE54304087255CB840E79B1", hash_generated_method = "9925E5AD01B0D53A6F7672B1DF9F7FC1")
    public TestGrouping removePackagesRecursive(String... packageNames) {
        addTaint(packageNames[0].getTaint());
for(String packageName : packageNames)
        {
            testCaseClasses.removeAll(testCaseClassesInPackage(packageName));
        } //End block
TestGrouping var72A74007B2BE62B849F475C7BDA4658B_1370115956 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1370115956.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1370115956;
        // ---------- Original Method ----------
        //for (String packageName : packageNames) {
            //testCaseClasses.removeAll(testCaseClassesInPackage(packageName));
        //}
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.180 -0400", hash_original_method = "C38D4C4BAAACEDDA4FA2C460C27FC791", hash_generated_method = "A5CC7F7D0F8F444FCB7C79726067DEAC")
    public String getFirstIncludedPackage() {
String varF8D28C66D98E8F5E93FEBFB5E22AE752_221520753 =         firstIncludedPackage;
        varF8D28C66D98E8F5E93FEBFB5E22AE752_221520753.addTaint(taint);
        return varF8D28C66D98E8F5E93FEBFB5E22AE752_221520753;
        // ---------- Original Method ----------
        //return firstIncludedPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.180 -0400", hash_original_method = "EB0D3DDEC19295079ED9F02F9ADFE3B2", hash_generated_method = "01F40D8636AF37241CFB8554049ADD99")
    private List<Class<? extends TestCase>> testCaseClassesInPackage(String packageName) {
        addTaint(packageName.getTaint());
        ClassPathPackageInfoSource source = PackageInfoSources.forClassPath(classLoader);
        ClassPathPackageInfo packageInfo = source.getPackageInfo(packageName);
List<Class<? extends TestCase>> varF30E1B2D05AB96E9BCFDD94FD0B601B7_1302633565 =         selectTestClasses(packageInfo.getTopLevelClassesRecursive());
        varF30E1B2D05AB96E9BCFDD94FD0B601B7_1302633565.addTaint(taint);
        return varF30E1B2D05AB96E9BCFDD94FD0B601B7_1302633565;
        // ---------- Original Method ----------
        //ClassPathPackageInfoSource source = PackageInfoSources.forClassPath(classLoader);
        //ClassPathPackageInfo packageInfo = source.getPackageInfo(packageName);
        //return selectTestClasses(packageInfo.getTopLevelClassesRecursive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.181 -0400", hash_original_method = "9793CFC93A78E03886A5AA31DA3BF499", hash_generated_method = "FE765FCBACD67BD11C5F5D343570579E")
    @SuppressWarnings("unchecked")
    private List<Class<? extends TestCase>> selectTestClasses(Set<Class<?>> allClasses) {
        addTaint(allClasses.getTaint());
        List<Class<? extends TestCase>> testClasses = new ArrayList<Class<? extends TestCase>>();
for(Class<?> testClass : select(allClasses,
                new TestCasePredicate()))
        {
            testClasses.add((Class<? extends TestCase>) testClass);
        } //End block
List<Class<? extends TestCase>> var78BD4D09240C84579A1CCDC63A0C994A_415430207 =         testClasses;
        var78BD4D09240C84579A1CCDC63A0C994A_415430207.addTaint(taint);
        return var78BD4D09240C84579A1CCDC63A0C994A_415430207;
        // ---------- Original Method ----------
        //List<Class<? extends TestCase>> testClasses = new ArrayList<Class<? extends TestCase>>();
        //for (Class<?> testClass : select(allClasses,
                //new TestCasePredicate())) {
            //testClasses.add((Class<? extends TestCase>) testClass);
        //}
        //return testClasses;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.181 -0400", hash_original_method = "181E7204E4D12ACAE7FBA59CCDA56AD6", hash_generated_method = "27FB858E3F19FA6819CE6447A72E454B")
    private <T> List<T> select(Collection<T> items, Predicate<T> predicate) {
        addTaint(predicate.getTaint());
        addTaint(items.getTaint());
        ArrayList<T> selectedItems = new ArrayList<T>();
for(T item : items)
        {
            if(predicate.apply(item))            
            {
                selectedItems.add(item);
            } //End block
        } //End block
List<T> var7A9FA332A2F68B4B3F12D84C779C06B6_962876593 =         selectedItems;
        var7A9FA332A2F68B4B3F12D84C779C06B6_962876593.addTaint(taint);
        return var7A9FA332A2F68B4B3F12D84C779C06B6_962876593;
        // ---------- Original Method ----------
        //ArrayList<T> selectedItems = new ArrayList<T>();
        //for (T item : items) {
            //if (predicate.apply(item)) {
                //selectedItems.add(item);
            //}
        //}
        //return selectedItems;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.182 -0400", hash_original_method = "EF51D9ADCA3E8F522FB005D173D913A5", hash_generated_method = "278C4AA58E3CC699090BB3856901B327")
    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
        // ---------- Original Method ----------
        //this.classLoader = classLoader;
    }

    
    private static class SortBySimpleName implements Comparator<Class<? extends TestCase>>, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.182 -0400", hash_original_method = "DF47E6BDF91D187CFB898DEC7629CE17", hash_generated_method = "DF47E6BDF91D187CFB898DEC7629CE17")
        public SortBySimpleName ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.182 -0400", hash_original_method = "D443F8BF084E7C4C20680ADEEDC43BF0", hash_generated_method = "3032904A6F3C259D63F04EE25D9353E2")
        public int compare(Class<? extends TestCase> class1,
                Class<? extends TestCase> class2) {
            addTaint(class2.getTaint());
            addTaint(class1.getTaint());
            int result = class1.getSimpleName().compareTo(class2.getSimpleName());
            if(result != 0)            
            {
                int varB4A88417B3D0170D754C647C30B7216A_956635636 = (result);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546412865 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546412865;
            } //End block
            int var317CD1D04BF28C00B38F903790589A67_332207908 = (class1.getName().compareTo(class2.getName()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25170865 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25170865;
            // ---------- Original Method ----------
            //int result = class1.getSimpleName().compareTo(class2.getSimpleName());
            //if (result != 0) {
                //return result;
            //}
            //return class1.getName().compareTo(class2.getName());
        }

        
    }


    
    private static class SortByFullyQualifiedName implements Comparator<Class<? extends TestCase>>, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.183 -0400", hash_original_method = "E467FE44B8FD2B3FC2F2C02A44638E77", hash_generated_method = "E467FE44B8FD2B3FC2F2C02A44638E77")
        public SortByFullyQualifiedName ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.183 -0400", hash_original_method = "4B1D58D6EFFB49C224C33511FACEBC5F", hash_generated_method = "E6BDE39F828993269003250DBFCAF382")
        public int compare(Class<? extends TestCase> class1,
                Class<? extends TestCase> class2) {
            addTaint(class2.getTaint());
            addTaint(class1.getTaint());
            int var317CD1D04BF28C00B38F903790589A67_206940686 = (class1.getName().compareTo(class2.getName()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487188843 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487188843;
            // ---------- Original Method ----------
            //return class1.getName().compareTo(class2.getName());
        }

        
    }


    
    private static class TestCasePredicate implements Predicate<Class<?>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.183 -0400", hash_original_method = "C51D9C1D123C5970141C72E69FC5E23D", hash_generated_method = "C51D9C1D123C5970141C72E69FC5E23D")
        public TestCasePredicate ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.184 -0400", hash_original_method = "9D9B2E8FB03F4B758E0C890C03F2E5F6", hash_generated_method = "7A462C672AE7815DFBF4E9535985EA3F")
        public boolean apply(Class aClass) {
            addTaint(aClass.getTaint());
            int modifiers = ((Class<?>) aClass).getModifiers();
            boolean var6E97A260F091A803A3B0B303209DC3FA_428152951 = (TestCase.class.isAssignableFrom((Class<?>) aClass)
                    && Modifier.isPublic(modifiers)
                    && !Modifier.isAbstract(modifiers)
                    && hasValidConstructor((Class<?>) aClass));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1189326930 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1189326930;
            // ---------- Original Method ----------
            //int modifiers = ((Class<?>) aClass).getModifiers();
            //return TestCase.class.isAssignableFrom((Class<?>) aClass)
                    //&& Modifier.isPublic(modifiers)
                    //&& !Modifier.isAbstract(modifiers)
                    //&& hasValidConstructor((Class<?>) aClass);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.184 -0400", hash_original_method = "3C87EFFA5D029BD7C6E8E87D3458D6A6", hash_generated_method = "A8B0A3495F512A021CA0A7A81119B16F")
        @SuppressWarnings("unchecked")
        private boolean hasValidConstructor(java.lang.Class<?> aClass) {
            addTaint(aClass.getTaint());
            Constructor<? extends TestCase>[] constructors = (Constructor<? extends TestCase>[]) aClass.getConstructors();
for(Constructor<? extends TestCase> constructor : constructors)
            {
                if(Modifier.isPublic(constructor.getModifiers()))                
                {
                    java.lang.Class[] parameterTypes = constructor.getParameterTypes();
                    if(parameterTypes.length == 0 ||
                            (parameterTypes.length == 1 && parameterTypes[0] == String.class))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_818534549 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_111170493 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_111170493;
                    } //End block
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_900147693 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_462205171 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_462205171;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class TestMethodPredicate implements Predicate<Method> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.185 -0400", hash_original_method = "5644BC516EF6C647F77F88686C681987", hash_generated_method = "5644BC516EF6C647F77F88686C681987")
        public TestMethodPredicate ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.185 -0400", hash_original_method = "D26D55EE6758E6673A4F60E3C2FBF447", hash_generated_method = "D7A7270E5BC8DB259D3F8C0B859F6F72")
        public boolean apply(Method method) {
            addTaint(method.getTaint());
            boolean var94D2EB2CD465FE4C08EAF1A48B27F153_2037341823 = (((method.getParameterTypes().length == 0) &&
                    (method.getName().startsWith("test")) &&
                    (method.getReturnType().getSimpleName().equals("void"))));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_661195652 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_661195652;
            // ---------- Original Method ----------
            //return ((method.getParameterTypes().length == 0) &&
                    //(method.getName().startsWith("test")) &&
                    //(method.getReturnType().getSimpleName().equals("void")));
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.186 -0400", hash_original_field = "91AA6F3ACB166F0766D4336BD5F78193", hash_generated_field = "CE2E1060B46BDBE7E16BF5287A109FDB")

    private static final String LOG_TAG = "TestGrouping";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.186 -0400", hash_original_field = "E34599ED3359EC83A7B58AF4F17BC988", hash_generated_field = "6393FB509BD7B738CA4EC7858735B178")

    public static final Comparator<Class<? extends TestCase>> SORT_BY_SIMPLE_NAME
            = new SortBySimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.186 -0400", hash_original_field = "F4823F18FCDE8B6F0BA8954B6019C31B", hash_generated_field = "88E0DDC4F117766575D8ADA532BFD923")

    public static final Comparator<Class<? extends TestCase>> SORT_BY_FULLY_QUALIFIED_NAME
            = new SortByFullyQualifiedName();
}

