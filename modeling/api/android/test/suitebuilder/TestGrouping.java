/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.test.suitebuilder;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
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

import junit.framework.TestCase;
import android.test.ClassPathPackageInfo;
import android.test.ClassPathPackageInfoSource;
import android.test.PackageInfoSources;

import com.android.internal.util.Predicate;

public class TestGrouping {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.296 -0500", hash_original_field = "4BB1C3CE23F79A39D22915266FFB15BD", hash_generated_field = "CE2E1060B46BDBE7E16BF5287A109FDB")

    private static final String LOG_TAG = "TestGrouping";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.300 -0500", hash_original_field = "4FA53D39E3C5EFDC072331C06A976AE4", hash_generated_field = "6393FB509BD7B738CA4EC7858735B178")

    public static final Comparator<Class<? extends TestCase>> SORT_BY_SIMPLE_NAME
            = new SortBySimpleName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.302 -0500", hash_original_field = "0A6475311D0159CC81A7AF1883FA7A87", hash_generated_field = "88E0DDC4F117766575D8ADA532BFD923")

    public static final Comparator<Class<? extends TestCase>> SORT_BY_FULLY_QUALIFIED_NAME
            = new SortByFullyQualifiedName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.298 -0500", hash_original_field = "92A1F72A3CA9AFF319E6A33DD1FCF056", hash_generated_field = "92A1F72A3CA9AFF319E6A33DD1FCF056")

    SortedSet<Class<? extends TestCase>> testCaseClasses;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.304 -0500", hash_original_field = "B4AE6C1BAB00DCF5B38176C50EDD4DC1", hash_generated_field = "46A35DF78B071F820EB500E754651053")

    protected String firstIncludedPackage = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.306 -0500", hash_original_field = "DB93E4DB6045160743AC769A344DA267", hash_generated_field = "F6BCA95A9F68D069180083A80576157E")

    private ClassLoader classLoader;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.309 -0500", hash_original_method = "E97169CD65D986F2307319C325D5D1C7", hash_generated_method = "9358E14B3DC2C015474494B3D928A1D6")
    
public TestGrouping(Comparator<Class<? extends TestCase>> comparator) {
        testCaseClasses = new TreeSet<Class<? extends TestCase>>(comparator);
    }

    /**
     * @return A list of all tests in the package, including small, medium, large,
     *         flaky, and suppressed tests. Includes sub-packages recursively.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.311 -0500", hash_original_method = "680BBB6317C221899395AD16A5E3E2AA", hash_generated_method = "63E7D53AD5A5D08C638F81A633CFECF8")
    
public List<TestMethod> getTests() {
        List<TestMethod> testMethods = new ArrayList<TestMethod>();
        for (Class<? extends TestCase> testCase : testCaseClasses) {
            for (Method testMethod : getTestMethods(testCase)) {
                testMethods.add(new TestMethod(testMethod, testCase));
            }
        }
        return testMethods;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.314 -0500", hash_original_method = "2AE043142188DFBFC0C6FBA8EE4EFD15", hash_generated_method = "B4674C588ACDD25FDAFF8D232C255B06")
    
protected List<Method> getTestMethods(Class<? extends TestCase> testCaseClass) {
        List<Method> methods = Arrays.asList(testCaseClass.getMethods());
        return select(methods, new TestMethodPredicate());
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.316 -0500", hash_original_method = "33F5ECA31F61AACED3C9710C1D8342FC", hash_generated_method = "33F5ECA31F61AACED3C9710C1D8342FC")
    
SortedSet<Class<? extends TestCase>> getTestCaseClasses() {
        return testCaseClasses;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.318 -0500", hash_original_method = "6F62F66C41F8017782EE166F70D0516E", hash_generated_method = "14BB8360F989C83B3FED42D1670ACD0F")
    
public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestGrouping other = (TestGrouping) o;
        if (!this.testCaseClasses.equals(other.testCaseClasses)) {
            return false;
        }
        return this.testCaseClasses.comparator().equals(other.testCaseClasses.comparator());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.320 -0500", hash_original_method = "E7359B0E16100AA2FD7539D694C05DFB", hash_generated_method = "D559DEE6286F02565C4C0BA1F7C60FE2")
    
public int hashCode() {
        return testCaseClasses.hashCode();
    }

    /**
     * Include all tests in the given packages and all their sub-packages, unless otherwise
     * specified. Each of the given packages must contain at least one test class, either directly
     * or in a sub-package.
     *
     * @param packageNames Names of packages to add.
     * @return The {@link TestGrouping} for method chaining.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.323 -0500", hash_original_method = "F1ABEC9272D67A731F25021CAE965675", hash_generated_method = "8DD502AAB7BE6B0225AD791FFB9A887C")
    
public TestGrouping addPackagesRecursive(String... packageNames) {
        for (String packageName : packageNames) {
            List<Class<? extends TestCase>> addedClasses = testCaseClassesInPackage(packageName);
            if (addedClasses.isEmpty()) {
                Log.w(LOG_TAG, "Invalid Package: '" + packageName
                        + "' could not be found or has no tests");
            }
            testCaseClasses.addAll(addedClasses);
            if (firstIncludedPackage == null) {
                firstIncludedPackage = packageName;
            }
        }
        return this;
    }

    /**
     * Exclude all tests in the given packages and all their sub-packages, unless otherwise
     * specified.
     *
     * @param packageNames Names of packages to remove.
     * @return The {@link TestGrouping} for method chaining.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.325 -0500", hash_original_method = "56956838CAE54304087255CB840E79B1", hash_generated_method = "D82620E518F3C5A9651F630088CD1A5F")
    
public TestGrouping removePackagesRecursive(String... packageNames) {
        for (String packageName : packageNames) {
            testCaseClasses.removeAll(testCaseClassesInPackage(packageName));
        }
        return this;
    }

    /**
     * @return The first package name passed to {@link #addPackagesRecursive(String[])}, or null
     *         if that method was never called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.328 -0500", hash_original_method = "C38D4C4BAAACEDDA4FA2C460C27FC791", hash_generated_method = "65DD5F56BE5B71D4A2012D649D033A6A")
    
public String getFirstIncludedPackage() {
        return firstIncludedPackage;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.330 -0500", hash_original_method = "EB0D3DDEC19295079ED9F02F9ADFE3B2", hash_generated_method = "0B8CAF4FA756F6A9BEDE26D8CC487375")
    
private List<Class<? extends TestCase>> testCaseClassesInPackage(String packageName) {
        ClassPathPackageInfoSource source = PackageInfoSources.forClassPath(classLoader);
        ClassPathPackageInfo packageInfo = source.getPackageInfo(packageName);

        return selectTestClasses(packageInfo.getTopLevelClassesRecursive());
    }
    
    private static class SortBySimpleName implements Comparator<Class<? extends TestCase>>, Serializable {
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.182 -0400", hash_original_method = "DF47E6BDF91D187CFB898DEC7629CE17", hash_generated_method = "DF47E6BDF91D187CFB898DEC7629CE17")
        public SortBySimpleName ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.340 -0500", hash_original_method = "D443F8BF084E7C4C20680ADEEDC43BF0", hash_generated_method = "675A098E23EE3D3BDBA4D58835C30ED6")
        @DSSafe(DSCat.SAFE_LIST)
        
public int compare(Class<? extends TestCase> class1,
                Class<? extends TestCase> class2) {
            int result = class1.getSimpleName().compareTo(class2.getSimpleName());
            if (result != 0) {
                return result;
            }
            return class1.getName().compareTo(class2.getName());
        }
        
    }
    
    private static class SortByFullyQualifiedName implements Comparator<Class<? extends TestCase>>, Serializable {
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.183 -0400", hash_original_method = "E467FE44B8FD2B3FC2F2C02A44638E77", hash_generated_method = "E467FE44B8FD2B3FC2F2C02A44638E77")
        public SortByFullyQualifiedName ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.345 -0500", hash_original_method = "4B1D58D6EFFB49C224C33511FACEBC5F", hash_generated_method = "37F1A5E69F8AB7EBC7B50ADB225A6EB7")
        @DSSafe(DSCat.SAFE_LIST)
        
public int compare(Class<? extends TestCase> class1,
                Class<? extends TestCase> class2) {
            return class1.getName().compareTo(class2.getName());
        }
        
    }
    
    private static class TestCasePredicate implements Predicate<Class<?>> {
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.183 -0400", hash_original_method = "C51D9C1D123C5970141C72E69FC5E23D", hash_generated_method = "C51D9C1D123C5970141C72E69FC5E23D")
        public TestCasePredicate ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.349 -0500", hash_original_method = "9D9B2E8FB03F4B758E0C890C03F2E5F6", hash_generated_method = "A53A4FCB10B1FB5AD5E845F3B7FD5A33")
        
public boolean apply(Class aClass) {
            int modifiers = ((Class<?>) aClass).getModifiers();
            return TestCase.class.isAssignableFrom((Class<?>) aClass)
                    && Modifier.isPublic(modifiers)
                    && !Modifier.isAbstract(modifiers)
                    && hasValidConstructor((Class<?>) aClass);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.352 -0500", hash_original_method = "3C87EFFA5D029BD7C6E8E87D3458D6A6", hash_generated_method = "C2B55BDCEA7F38FC81E5E7247F40F14E")
        
@SuppressWarnings("unchecked")
        private boolean hasValidConstructor(java.lang.Class<?> aClass) {
            // The cast below is not necessary with the Java 5 compiler, but necessary with the Java 6 compiler,
            // where the return type of Class.getDeclaredConstructors() was changed
            // from Constructor<T>[] to Constructor<?>[]
            Constructor<? extends TestCase>[] constructors
                    = (Constructor<? extends TestCase>[]) aClass.getConstructors();
            for (Constructor<? extends TestCase> constructor : constructors) {
                if (Modifier.isPublic(constructor.getModifiers())) {
                    java.lang.Class[] parameterTypes = constructor.getParameterTypes();
                    if (parameterTypes.length == 0 ||
                            (parameterTypes.length == 1 && parameterTypes[0] == String.class)) {
                        return true;
                    }
                }
            }
            Log.i(LOG_TAG, String.format(
                    "TestCase class %s is missing a public constructor with no parameters " +
                    "or a single String parameter - skipping",
                    aClass.getName()));
            return false;
        }
        
    }
    
    private static class TestMethodPredicate implements Predicate<Method> {
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.185 -0400", hash_original_method = "5644BC516EF6C647F77F88686C681987", hash_generated_method = "5644BC516EF6C647F77F88686C681987")
        public TestMethodPredicate ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.358 -0500", hash_original_method = "D26D55EE6758E6673A4F60E3C2FBF447", hash_generated_method = "149F12C0C8D410E20EC2296724A9BF1C")
        
public boolean apply(Method method) {
            return ((method.getParameterTypes().length == 0) &&
                    (method.getName().startsWith("test")) &&
                    (method.getReturnType().getSimpleName().equals("void")));
        }
        
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.333 -0500", hash_original_method = "9793CFC93A78E03886A5AA31DA3BF499", hash_generated_method = "C246E0185EC4EBE6271F9AAF975CA328")
    
@SuppressWarnings("unchecked")
    private List<Class<? extends TestCase>> selectTestClasses(Set<Class<?>> allClasses) {
        List<Class<? extends TestCase>> testClasses = new ArrayList<Class<? extends TestCase>>();
        for (Class<?> testClass : select(allClasses,
                new TestCasePredicate())) {
            testClasses.add((Class<? extends TestCase>) testClass);
        }
        return testClasses;
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
        var7A9FA332A2F68B4B3F12D84C779C06B6_962876593.addTaint(getTaint());
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.337 -0500", hash_original_method = "EF51D9ADCA3E8F522FB005D173D913A5", hash_generated_method = "17E56A506DB48401AA8C60783B0C74E5")
    
public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
}

