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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.519 -0400", hash_original_field = "70C19B020BEFD5DD40A8FC5A2B69533F", hash_generated_field = "92A1F72A3CA9AFF319E6A33DD1FCF056")

    SortedSet<Class<? extends TestCase>> testCaseClasses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.520 -0400", hash_original_field = "23F9809CC27E9C8679DCF78F85689F51", hash_generated_field = "46A35DF78B071F820EB500E754651053")

    protected String firstIncludedPackage = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.520 -0400", hash_original_field = "23508C9A13E40798812B11A9CFC1E55C", hash_generated_field = "F6BCA95A9F68D069180083A80576157E")

    private ClassLoader classLoader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.520 -0400", hash_original_method = "E97169CD65D986F2307319C325D5D1C7", hash_generated_method = "EE1C01BD0FD2D553FF0674FFD6591BBB")
    public  TestGrouping(Comparator<Class<? extends TestCase>> comparator) {
        testCaseClasses = new TreeSet<Class<? extends TestCase>>(comparator);
        // ---------- Original Method ----------
        //testCaseClasses = new TreeSet<Class<? extends TestCase>>(comparator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.521 -0400", hash_original_method = "680BBB6317C221899395AD16A5E3E2AA", hash_generated_method = "C96C8204009305BF6BEFC28782FD25D6")
    public List<TestMethod> getTests() {
        List<TestMethod> testMethods = new ArrayList<TestMethod>();
for(Class<? extends TestCase> testCase : testCaseClasses)
        {
for(Method testMethod : getTestMethods(testCase))
            {
                testMethods.add(new TestMethod(testMethod, testCase));
            } //End block
        } //End block
List<TestMethod> var24D1ADC4337A1DFDD7EDF48B863FFFFD_1478303335 =         testMethods;
        var24D1ADC4337A1DFDD7EDF48B863FFFFD_1478303335.addTaint(taint);
        return var24D1ADC4337A1DFDD7EDF48B863FFFFD_1478303335;
        // ---------- Original Method ----------
        //List<TestMethod> testMethods = new ArrayList<TestMethod>();
        //for (Class<? extends TestCase> testCase : testCaseClasses) {
            //for (Method testMethod : getTestMethods(testCase)) {
                //testMethods.add(new TestMethod(testMethod, testCase));
            //}
        //}
        //return testMethods;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.521 -0400", hash_original_method = "2AE043142188DFBFC0C6FBA8EE4EFD15", hash_generated_method = "3EC5705A350A3F751C77BA9E959E3027")
    protected List<Method> getTestMethods(Class<? extends TestCase> testCaseClass) {
        addTaint(testCaseClass.getTaint());
        List<Method> methods = Arrays.asList(testCaseClass.getMethods());
List<Method> var625C4BA6F2C797C1B5A159EA338B6BDA_1058908807 =         select(methods, new TestMethodPredicate());
        var625C4BA6F2C797C1B5A159EA338B6BDA_1058908807.addTaint(taint);
        return var625C4BA6F2C797C1B5A159EA338B6BDA_1058908807;
        // ---------- Original Method ----------
        //List<Method> methods = Arrays.asList(testCaseClass.getMethods());
        //return select(methods, new TestMethodPredicate());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.521 -0400", hash_original_method = "33F5ECA31F61AACED3C9710C1D8342FC", hash_generated_method = "49ADF78B6147ED04CE6C5AB423AD711F")
     SortedSet<Class<? extends TestCase>> getTestCaseClasses() {
SortedSet<Class<? extends TestCase>> varE3DDA91219760C874204BD71102F4461_1651822788 =         testCaseClasses;
        varE3DDA91219760C874204BD71102F4461_1651822788.addTaint(taint);
        return varE3DDA91219760C874204BD71102F4461_1651822788;
        // ---------- Original Method ----------
        //return testCaseClasses;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.522 -0400", hash_original_method = "6F62F66C41F8017782EE166F70D0516E", hash_generated_method = "4464ACF7CAE513618706A75E6D5AD950")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1812323882 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_738746916 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_738746916;
        } //End block
    if(o == null || getClass() != o.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1986952286 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_332949807 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_332949807;
        } //End block
        TestGrouping other = (TestGrouping) o;
    if(!this.testCaseClasses.equals(other.testCaseClasses))        
        {
            boolean var68934A3E9455FA72420237EB05902327_982432483 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1821058316 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1821058316;
        } //End block
        boolean varF151829E7A1B54F6289E1B77EC955A5E_1400295823 = (this.testCaseClasses.comparator().equals(other.testCaseClasses.comparator()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_581878386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_581878386;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.522 -0400", hash_original_method = "E7359B0E16100AA2FD7539D694C05DFB", hash_generated_method = "DEEFE5EEB5A1E1B62B68CB681C5346CA")
    public int hashCode() {
        int var2910C1999B304E5C1AE264098CA8555A_1389772461 = (testCaseClasses.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922217575 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922217575;
        // ---------- Original Method ----------
        //return testCaseClasses.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.523 -0400", hash_original_method = "F1ABEC9272D67A731F25021CAE965675", hash_generated_method = "3A0B3C1C26437FF568150D4AEE2BC688")
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
TestGrouping var72A74007B2BE62B849F475C7BDA4658B_836214841 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_836214841.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_836214841;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.523 -0400", hash_original_method = "56956838CAE54304087255CB840E79B1", hash_generated_method = "68A2B016D3012E0786E6B497F17D3513")
    public TestGrouping removePackagesRecursive(String... packageNames) {
        addTaint(packageNames[0].getTaint());
for(String packageName : packageNames)
        {
            testCaseClasses.removeAll(testCaseClassesInPackage(packageName));
        } //End block
TestGrouping var72A74007B2BE62B849F475C7BDA4658B_1098533928 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1098533928.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1098533928;
        // ---------- Original Method ----------
        //for (String packageName : packageNames) {
            //testCaseClasses.removeAll(testCaseClassesInPackage(packageName));
        //}
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.523 -0400", hash_original_method = "C38D4C4BAAACEDDA4FA2C460C27FC791", hash_generated_method = "25E36F10A0E3FFF5D1AA16A8FD4FFD58")
    public String getFirstIncludedPackage() {
String varF8D28C66D98E8F5E93FEBFB5E22AE752_2106810384 =         firstIncludedPackage;
        varF8D28C66D98E8F5E93FEBFB5E22AE752_2106810384.addTaint(taint);
        return varF8D28C66D98E8F5E93FEBFB5E22AE752_2106810384;
        // ---------- Original Method ----------
        //return firstIncludedPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.524 -0400", hash_original_method = "EB0D3DDEC19295079ED9F02F9ADFE3B2", hash_generated_method = "EC4A0A46CBDBD8F41F525F664AD5DA22")
    private List<Class<? extends TestCase>> testCaseClassesInPackage(String packageName) {
        addTaint(packageName.getTaint());
        ClassPathPackageInfoSource source = PackageInfoSources.forClassPath(classLoader);
        ClassPathPackageInfo packageInfo = source.getPackageInfo(packageName);
List<Class<? extends TestCase>> varF30E1B2D05AB96E9BCFDD94FD0B601B7_182580907 =         selectTestClasses(packageInfo.getTopLevelClassesRecursive());
        varF30E1B2D05AB96E9BCFDD94FD0B601B7_182580907.addTaint(taint);
        return varF30E1B2D05AB96E9BCFDD94FD0B601B7_182580907;
        // ---------- Original Method ----------
        //ClassPathPackageInfoSource source = PackageInfoSources.forClassPath(classLoader);
        //ClassPathPackageInfo packageInfo = source.getPackageInfo(packageName);
        //return selectTestClasses(packageInfo.getTopLevelClassesRecursive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.524 -0400", hash_original_method = "9793CFC93A78E03886A5AA31DA3BF499", hash_generated_method = "DE78E7F08AB684A1083BB899AA5B4BCC")
    @SuppressWarnings("unchecked")
    private List<Class<? extends TestCase>> selectTestClasses(Set<Class<?>> allClasses) {
        addTaint(allClasses.getTaint());
        List<Class<? extends TestCase>> testClasses = new ArrayList<Class<? extends TestCase>>();
for(Class<?> testClass : select(allClasses,
                new TestCasePredicate()))
        {
            testClasses.add((Class<? extends TestCase>) testClass);
        } //End block
List<Class<? extends TestCase>> var78BD4D09240C84579A1CCDC63A0C994A_572267352 =         testClasses;
        var78BD4D09240C84579A1CCDC63A0C994A_572267352.addTaint(taint);
        return var78BD4D09240C84579A1CCDC63A0C994A_572267352;
        // ---------- Original Method ----------
        //List<Class<? extends TestCase>> testClasses = new ArrayList<Class<? extends TestCase>>();
        //for (Class<?> testClass : select(allClasses,
                //new TestCasePredicate())) {
            //testClasses.add((Class<? extends TestCase>) testClass);
        //}
        //return testClasses;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.524 -0400", hash_original_method = "181E7204E4D12ACAE7FBA59CCDA56AD6", hash_generated_method = "A824AEB4D135A1614E40099E1A398670")
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
List<T> var7A9FA332A2F68B4B3F12D84C779C06B6_2060467808 =         selectedItems;
        var7A9FA332A2F68B4B3F12D84C779C06B6_2060467808.addTaint(taint);
        return var7A9FA332A2F68B4B3F12D84C779C06B6_2060467808;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.525 -0400", hash_original_method = "EF51D9ADCA3E8F522FB005D173D913A5", hash_generated_method = "278C4AA58E3CC699090BB3856901B327")
    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
        // ---------- Original Method ----------
        //this.classLoader = classLoader;
    }

    
    private static class SortBySimpleName implements Comparator<Class<? extends TestCase>>, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.525 -0400", hash_original_method = "DF47E6BDF91D187CFB898DEC7629CE17", hash_generated_method = "DF47E6BDF91D187CFB898DEC7629CE17")
        public SortBySimpleName ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.525 -0400", hash_original_method = "D443F8BF084E7C4C20680ADEEDC43BF0", hash_generated_method = "F57618D0DA0EB1723E4DF845569715FD")
        public int compare(Class<? extends TestCase> class1,
                Class<? extends TestCase> class2) {
            addTaint(class2.getTaint());
            addTaint(class1.getTaint());
            int result = class1.getSimpleName().compareTo(class2.getSimpleName());
    if(result != 0)            
            {
                int varB4A88417B3D0170D754C647C30B7216A_511835841 = (result);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723273880 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723273880;
            } //End block
            int var317CD1D04BF28C00B38F903790589A67_722736708 = (class1.getName().compareTo(class2.getName()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359868269 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359868269;
            // ---------- Original Method ----------
            //int result = class1.getSimpleName().compareTo(class2.getSimpleName());
            //if (result != 0) {
                //return result;
            //}
            //return class1.getName().compareTo(class2.getName());
        }

        
    }


    
    private static class SortByFullyQualifiedName implements Comparator<Class<? extends TestCase>>, Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.526 -0400", hash_original_method = "E467FE44B8FD2B3FC2F2C02A44638E77", hash_generated_method = "E467FE44B8FD2B3FC2F2C02A44638E77")
        public SortByFullyQualifiedName ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.526 -0400", hash_original_method = "4B1D58D6EFFB49C224C33511FACEBC5F", hash_generated_method = "F42BDE38B0DEF2AD508B1DA31EA0CE00")
        public int compare(Class<? extends TestCase> class1,
                Class<? extends TestCase> class2) {
            addTaint(class2.getTaint());
            addTaint(class1.getTaint());
            int var317CD1D04BF28C00B38F903790589A67_631219536 = (class1.getName().compareTo(class2.getName()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1662847374 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1662847374;
            // ---------- Original Method ----------
            //return class1.getName().compareTo(class2.getName());
        }

        
    }


    
    private static class TestCasePredicate implements Predicate<Class<?>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.526 -0400", hash_original_method = "C51D9C1D123C5970141C72E69FC5E23D", hash_generated_method = "C51D9C1D123C5970141C72E69FC5E23D")
        public TestCasePredicate ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.526 -0400", hash_original_method = "9D9B2E8FB03F4B758E0C890C03F2E5F6", hash_generated_method = "D5312A9123447235CF4A94C4056F6D70")
        public boolean apply(Class aClass) {
            addTaint(aClass.getTaint());
            int modifiers = ((Class<?>) aClass).getModifiers();
            boolean var6E97A260F091A803A3B0B303209DC3FA_598430630 = (TestCase.class.isAssignableFrom((Class<?>) aClass)
                    && Modifier.isPublic(modifiers)
                    && !Modifier.isAbstract(modifiers)
                    && hasValidConstructor((Class<?>) aClass));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_965153760 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_965153760;
            // ---------- Original Method ----------
            //int modifiers = ((Class<?>) aClass).getModifiers();
            //return TestCase.class.isAssignableFrom((Class<?>) aClass)
                    //&& Modifier.isPublic(modifiers)
                    //&& !Modifier.isAbstract(modifiers)
                    //&& hasValidConstructor((Class<?>) aClass);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.527 -0400", hash_original_method = "3C87EFFA5D029BD7C6E8E87D3458D6A6", hash_generated_method = "974C559D9AC7456AC348763FFC043EA6")
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
                        boolean varB326B5062B2F0E69046810717534CB09_1237007747 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1102111821 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1102111821;
                    } //End block
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1215901850 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_980770588 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_980770588;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class TestMethodPredicate implements Predicate<Method> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.527 -0400", hash_original_method = "5644BC516EF6C647F77F88686C681987", hash_generated_method = "5644BC516EF6C647F77F88686C681987")
        public TestMethodPredicate ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.527 -0400", hash_original_method = "D26D55EE6758E6673A4F60E3C2FBF447", hash_generated_method = "984E4CFC77D59BEFDB9F8530002BB994")
        public boolean apply(Method method) {
            addTaint(method.getTaint());
            boolean var94D2EB2CD465FE4C08EAF1A48B27F153_2031149188 = (((method.getParameterTypes().length == 0) &&
                    (method.getName().startsWith("test")) &&
                    (method.getReturnType().getSimpleName().equals("void"))));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1640292772 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1640292772;
            // ---------- Original Method ----------
            //return ((method.getParameterTypes().length == 0) &&
                    //(method.getName().startsWith("test")) &&
                    //(method.getReturnType().getSimpleName().equals("void")));
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.528 -0400", hash_original_field = "91AA6F3ACB166F0766D4336BD5F78193", hash_generated_field = "CE2E1060B46BDBE7E16BF5287A109FDB")

    private static final String LOG_TAG = "TestGrouping";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.528 -0400", hash_original_field = "E34599ED3359EC83A7B58AF4F17BC988", hash_generated_field = "6393FB509BD7B738CA4EC7858735B178")

    public static final Comparator<Class<? extends TestCase>> SORT_BY_SIMPLE_NAME
            = new SortBySimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.528 -0400", hash_original_field = "F4823F18FCDE8B6F0BA8954B6019C31B", hash_generated_field = "88E0DDC4F117766575D8ADA532BFD923")

    public static final Comparator<Class<? extends TestCase>> SORT_BY_FULLY_QUALIFIED_NAME
            = new SortByFullyQualifiedName();
}

