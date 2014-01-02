package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Log;

import com.google.android.collect.Lists;






public class TestRunner implements PerformanceTestCase.Intermediates {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.610 -0500", hash_original_method = "AD22069B08D63EC743A7576146EA4159", hash_generated_method = "6406C230D8C31AE4E73A75E799AAE9D3")
    
public static Method getChildrenMethod(Class clazz) {
        try {
            return clazz.getMethod("children", (Class[]) null);
        } catch (NoSuchMethodException e) {
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.612 -0500", hash_original_method = "979BCD679623EAAE6A6F65CB445CE309", hash_generated_method = "2A7F4447B455E6167513EA2DC65769F7")
    
public static Method getChildrenMethod(Context c, String className) {
        try {
            return getChildrenMethod(c.getClassLoader().loadClass(className));
        } catch (ClassNotFoundException e) {
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.616 -0500", hash_original_method = "FAD0AA980E6D778DE22E77F64451307A", hash_generated_method = "02D8720928A88D03CCDCEABF9FDC8194")
    
public static String[] getChildren(Context c, String className) {
        Method m = getChildrenMethod(c, className);
        String[] testChildren = getTestChildren(c, className);
        if (m == null & testChildren == null) {
            throw new RuntimeException("couldn't get children method for "
                    + className);
        }
        if (m != null) {
            String[] children = getChildren(m);
            if (testChildren != null) {
                String[] allChildren = new String[testChildren.length + children.length];
                System.arraycopy(children, 0, allChildren, 0, children.length);
                System.arraycopy(testChildren, 0, allChildren, children.length, testChildren.length);
                return allChildren;
            } else {
                return children;
            }
        } else {
            if (testChildren != null) {
                return testChildren;
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.618 -0500", hash_original_method = "5554FB0A3D6500C51F8289F3D0BCD9BA", hash_generated_method = "4A2EACA069992398B498261D45F7FB52")
    
public static String[] getChildren(Method m) {
        try {
            if (!Modifier.isStatic(m.getModifiers())) {
                throw new RuntimeException("children method is not static");
            }
            return (String[]) m.invoke(null, (Object[]) null);
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
        }
        return new String[0];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.621 -0500", hash_original_method = "1BBA68C620758993547458852DFD1B40", hash_generated_method = "05A0A7299C9C456C36E6E4871E7A6224")
    
public static String[] getTestChildren(Context c, String className) {
        try {
            Class clazz = c.getClassLoader().loadClass(className);

            if (mJUnitClass.isAssignableFrom(clazz)) {
                return getTestChildren(clazz);
            }
        } catch (ClassNotFoundException e) {
            Log.e("TestHarness", "No class found", e);
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.623 -0500", hash_original_method = "D395985F202515F4ABB9291054EA2606", hash_generated_method = "C03B5B326498DAD7010E1D0AFB1FBA5E")
    
public static String[] getTestChildren(Class clazz) {
        Method[] methods = getAllTestMethods(clazz);

        String[] onScreenTestNames = new String[methods.length];
        int index = 0;
        for (Method m : methods) {
            onScreenTestNames[index] = clazz.getName() + "$" + m.getName();
            index++;
        }
        return onScreenTestNames;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.626 -0500", hash_original_method = "4DE41A4C419B6BFE208642CF4C286F9C", hash_generated_method = "B23DD494A0C2CE56AFB544F95064AE12")
    
public static Method[] getAllTestMethods(Class clazz) {
        Method[] allMethods = clazz.getDeclaredMethods();
        int numOfMethods = 0;
        for (Method m : allMethods) {
            boolean mTrue = isTestMethod(m);
            if (mTrue) {
                numOfMethods++;
            }
        }
        int index = 0;
        Method[] testMethods = new Method[numOfMethods];
        for (Method m : allMethods) {
            boolean mTrue = isTestMethod(m);
            if (mTrue) {
                testMethods[index] = m;
                index++;
            }
        }
        return testMethods;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.628 -0500", hash_original_method = "D8643B3E6741F04B2E9656D32352984B", hash_generated_method = "02A3EBD1E7DB597F93309935926B1346")
    
private static boolean isTestMethod(Method m) {
        return m.getName().startsWith("test") &&
                m.getReturnType() == void.class &&
                m.getParameterTypes().length == 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.631 -0500", hash_original_method = "7259453677378F8EC4871D558134CA5A", hash_generated_method = "69C701D657502FE0B311D65B59B3C605")
    
public static int countJunitTests(Class clazz) {
        Method[] allTestMethods = getAllTestMethods(clazz);
        int numberofMethods = allTestMethods.length;

        return numberofMethods;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.633 -0500", hash_original_method = "A37461C49E73A8DE6A0A305A75DC6DF0", hash_generated_method = "3950B2BBF843A3CF170253F2863560F2")
    
public static boolean isTestSuite(Context c, String className) {
        boolean childrenMethods = getChildrenMethod(c, className) != null;

        try {
            Class clazz = c.getClassLoader().loadClass(className);
            if (mJUnitClass.isAssignableFrom(clazz)) {
                int numTests = countJunitTests(clazz);
                if (numTests > 0)
                    childrenMethods = true;
            }
        } catch (ClassNotFoundException e) {
        }
        return childrenMethods;
    }

    /**
     * Returns the number of tests that will be run if you try to do this.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.638 -0500", hash_original_method = "D20958E08974A3208EF818D45A4539EB", hash_generated_method = "A322870F4CC7D7F580AC0060A02247E5")
    
public static int countTests(Context c, String className) {
        try {
            Class clazz = c.getClassLoader().loadClass(className);
            Method method = getChildrenMethod(clazz);
            if (method != null) {

                String[] children = getChildren(method);
                int rv = 0;
                for (String child : children) {
                    rv += countTests(c, child);
                }
                return rv;
            } else if (mRunnableClass.isAssignableFrom(clazz)) {
                return 1;
            } else if (mJUnitClass.isAssignableFrom(clazz)) {
                return countJunitTests(clazz);
            }
        } catch (ClassNotFoundException e) {
            return 1; // this gets the count right, because either this test
            // is missing, and it will fail when run or it is a single Junit test to be run.
        }
        return 0;
    }

    /**
     * Returns a title to display given the className of a test.
     * <p/>
     * <p>Currently this function just returns the portion of the
     * class name after the last '.'
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.641 -0500", hash_original_method = "CA695F30BEE579388774EC2E04EA8C4E", hash_generated_method = "C4DCA9CCD14667FDE740F6D51267E215")
    
public static String getTitle(String className) {
        int indexDot = className.lastIndexOf('.');
        int indexDollar = className.lastIndexOf('$');
        int index = indexDot > indexDollar ? indexDot : indexDollar;
        if (index >= 0) {
            className = className.substring(index + 1);
        }
        return className;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.487 -0500", hash_original_field = "A76F0D3E4EE07CC85BC78380286E022C", hash_generated_field = "7A19718D05B190820FC65673780FDFD3")

    public static final int REGRESSION = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.490 -0500", hash_original_field = "D6F8F80859BBD01124EB7CD66789BDA3", hash_generated_field = "A674225858E65D6BA5E8E1F49770AD93")

    public static final int PERFORMANCE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.492 -0500", hash_original_field = "C849F080E7D1837ED98F4E782157BA70", hash_generated_field = "122E6B6086C2B35BF409E41D4BD3F8B6")

    public static final int PROFILING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.495 -0500", hash_original_field = "79860B786A2A92E20FCDB1EFB461CB8C", hash_generated_field = "2B9C658BF3C592304842D1E3DF01DC9B")


    public static final int CLEARSCREEN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.497 -0500", hash_original_field = "0385BE08D0E88821C8E259FAB30ACD7B", hash_generated_field = "104157555C19EFF242C550E6CF8A49FB")

    private static final String TAG = "TestHarness";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.521 -0500", hash_original_field = "A07D468339B9F56E71508AA02AF3174F", hash_generated_field = "08C0FD9F34C8A57F7E692654DC2345AB")


    private static Class mRunnableClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.523 -0500", hash_original_field = "C22B64973BFE68107EA6C1B77A2908E4", hash_generated_field = "55F3A7A57A174853E25B260195B61D60")

    private static Class mJUnitClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.499 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.501 -0500", hash_original_field = "78C6CB4089342DF74EA77B9C70171E1D", hash_generated_field = "80ECCE0FDB54A0C0B71FD5563F9A3BBA")


    private int mMode = REGRESSION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.503 -0500", hash_original_field = "A2F8B68CC372A14E3C105D8DCF2C267F", hash_generated_field = "816900AFC4C5F99896FEFAE236AAAC3D")


    private List<Listener> mListeners = Lists.newArrayList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.505 -0500", hash_original_field = "C82C1A18EFD3F758653B0348AD894A88", hash_generated_field = "9748ECEB0653B84A525176F637D38ECD")

    private int mPassed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.508 -0500", hash_original_field = "75D17C72BB926D9DA8C49ED9797158E9", hash_generated_field = "D2FC3B99B8E5BAFB19EEF8C8952014A9")

    private int mFailed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.510 -0500", hash_original_field = "E41D2F0453F9A25FFB0E870A7DA38D76", hash_generated_field = "3A78B0C220AA631D9D09212ECCBE44E3")


    private int mInternalIterations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.513 -0500", hash_original_field = "3C3A30DDD94D9D47CBB52C3848791CE7", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

    private long mStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.515 -0500", hash_original_field = "70C1C345A39DB06FF39288963005B239", hash_generated_field = "CE198E728D2042BC4D1888DF0457D27B")

    private long mEndTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.517 -0500", hash_original_field = "6BC238A3BDD37BF1CAC26EA2CE45C508", hash_generated_field = "DB6E5647C7C137158D39EAA9BCFFCF3D")


    private String mClassName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.519 -0500", hash_original_field = "2084C12375BBD761F459C848AEF2620C", hash_generated_field = "2084C12375BBD761F459C848AEF2620C")


    List<IntermediateTime> mIntermediates = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.557 -0500", hash_original_method = "8950AB5377F72756EC0D34993CFF0108", hash_generated_method = "1AA70789A87AEC9451285A90CD78B2FF")
    
public TestRunner(Context context) {
        mContext = context;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.559 -0500", hash_original_method = "61C23687EE46D7DD02D0495C15E55FFB", hash_generated_method = "BF4F307085100F7B5093CD978FB051DA")
    
public void addListener(Listener listener) {
        mListeners.add(listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.561 -0500", hash_original_method = "C501B549FBBC2113A15CD58FA347FDD6", hash_generated_method = "C239BB9A4153661CF0E806AC3C5FC812")
    
public void startProfiling() {
        File file = new File("/tmp/trace");
        file.mkdir();
        String base = "/tmp/trace/" + mClassName + ".dmtrace";
        Debug.startMethodTracing(base, 8 * 1024 * 1024);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.563 -0500", hash_original_method = "4696774C6D9FEF3FF4454E20DBB64304", hash_generated_method = "E785D70262FEECFFCC68AB615DA64A5E")
    
public void finishProfiling() {
        Debug.stopMethodTracing();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.565 -0500", hash_original_method = "8C5BFDCF70A85F458A74E20506CDCA9E", hash_generated_method = "115BAB642EB8FE29EEF2CA2B3E419764")
    
private void started(String className) {

        int count = mListeners.size();
        for (int i = 0; i < count; i++) {
            mListeners.get(i).started(className);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.567 -0500", hash_original_method = "9B2F60619B845977C468209ECD59C4E6", hash_generated_method = "166E9BAE2545F7A89219654E7137F654")
    
private void finished(String className) {
        int count = mListeners.size();
        for (int i = 0; i < count; i++) {
            mListeners.get(i).finished(className);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.569 -0500", hash_original_method = "5B73476158BD043DA3960AAE5CE325A6", hash_generated_method = "1A57C063EFE53A36B88515708DAC5701")
    
private void performance(String className,
            long itemTimeNS,
            int iterations,
            List<IntermediateTime> intermediates) {
        int count = mListeners.size();
        for (int i = 0; i < count; i++) {
            mListeners.get(i).performance(className,
                    itemTimeNS,
                    iterations,
                    intermediates);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.572 -0500", hash_original_method = "D08F267184DA26F05ED8D6C7FCFE1B8E", hash_generated_method = "61DB6544483071E748D45FB5F2B52264")
    
public void passed(String className) {
        mPassed++;
        int count = mListeners.size();
        for (int i = 0; i < count; i++) {
            mListeners.get(i).passed(className);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.574 -0500", hash_original_method = "D24139E2E0001F60D0C816A9C2E55057", hash_generated_method = "358D6147306CD099CBB44C2D743AA103")
    
public void failed(String className, Throwable exception) {
        mFailed++;
        int count = mListeners.size();
        for (int i = 0; i < count; i++) {
            mListeners.get(i).failed(className, exception);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.576 -0500", hash_original_method = "0B532C5E5191073233FEF0FB3B24844F", hash_generated_method = "7FDCE0B9A84D0C15054C8AE2E63D4594")
    
public int passedCount() {
        return mPassed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.579 -0500", hash_original_method = "0CCEB79CE1070F202583C9915927C804", hash_generated_method = "FE7A977F43B6592EB652000C6CCA9C84")
    
public int failedCount() {
        return mFailed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.581 -0500", hash_original_method = "EA958BED91E5807BE44C3475743952DB", hash_generated_method = "B6F15E9E3F7DB34D59371ED831334601")
    
public void run(String[] classes) {
        for (String cl : classes) {
            run(cl);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.583 -0500", hash_original_method = "53E84480F070131E858702808FE92767", hash_generated_method = "1563BE64181BD3AC88D45D9821E45D7D")
    
public void setInternalIterations(int count) {
        mInternalIterations = count;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.585 -0500", hash_original_method = "AD98F48B4895306C22AD1BDE79779428", hash_generated_method = "147A8F6E1B2C68C09595991478482FAD")
    
public void startTiming(boolean realTime) {
        if (realTime) {
            mStartTime = System.currentTimeMillis();
        } else {
            mStartTime = SystemClock.currentThreadTimeMillis();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.588 -0500", hash_original_method = "AF5C16E27EBEA087CBAF6BDFC1FB8A45", hash_generated_method = "1A471595F0C944FA6C3C601727E322A4")
    
public void addIntermediate(String name) {
        addIntermediate(name, (System.currentTimeMillis() - mStartTime) * 1000000);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.590 -0500", hash_original_method = "09734AD7C7F83A96723D7181F208AECD", hash_generated_method = "F6FFD48ED57CCBE3C498630BC3B94838")
    
public void addIntermediate(String name, long timeInNS) {
        mIntermediates.add(new IntermediateTime(name, timeInNS));
    }

    
    public class JunitTestSuite extends TestSuite implements TestListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.527 -0500", hash_original_field = "BDA376DC770C8E971D5C7AD1F1FE1B95", hash_generated_field = "BDA376DC770C8E971D5C7AD1F1FE1B95")

        boolean mError = false;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.529 -0500", hash_original_method = "CFFE110BDEA2EF1B39A9BF20964D075D", hash_generated_method = "361A7D30C3365EDE1EAEC9CA0F3F3574")
        
public JunitTestSuite() {
            super();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.532 -0500", hash_original_method = "8428289E0AE15BC8D3D04B7078FF5A2E", hash_generated_method = "398247F6F1788F2E84A94117CD3E985B")
        
@Override
        public void run(TestResult result) {
            result.addListener(this);
            super.run(result);
            result.removeListener(this);
        }

        /**
         * Implemented method of the interface TestListener which will listen for the
         * start of a test.
         *
         * @param test
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.534 -0500", hash_original_method = "9C3D54F0595A1B65649E868CBC4ED418", hash_generated_method = "8087CC459E08AECC6FFBD408BE1350CB")
        
public void startTest(Test test) {
            started(test.toString());
        }

        /**
         * Implemented method of the interface TestListener which will listen for the
         * end of the test.
         *
         * @param test
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.536 -0500", hash_original_method = "5C6758A8D60C0FE4B774FC491E0F7958", hash_generated_method = "2D08EDC8001035013CC035034AA50DBA")
        
public void endTest(Test test) {
            finished(test.toString());
            if (!mError) {
                passed(test.toString());
            }
        }

        /**
         * Implemented method of the interface TestListener which will listen for an
         * mError while running the test.
         *
         * @param test
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.538 -0500", hash_original_method = "0D2F0B914A04C9F7A825DB8C76DB002A", hash_generated_method = "5BA9ABC8D798434B7869D28F860C772D")
        
public void addError(Test test, Throwable t) {
            mError = true;
            failed(test.toString(), t);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.541 -0500", hash_original_method = "E48FFE8D16E4AA897CF5C85DD7DE476B", hash_generated_method = "BE876A8EF11149028A384EAC5DDFCC16")
        
public void addFailure(Test test, junit.framework.AssertionFailedError t) {
            mError = true;
            failed(test.toString(), t);
        }

        
    }


    
    public static class IntermediateTime {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.548 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")


        public String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.550 -0500", hash_original_field = "738CA73B4822964026076DEBF88C5508", hash_generated_field = "FE74B3B074A6BBF26780BB4EDC778464")

        public long timeInNS;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.545 -0500", hash_original_method = "F156F71FB9ADDC03EC513D4C1742F860", hash_generated_method = "8AEABD1253D461C8D42EB503FC45C015")
        
public IntermediateTime(String name, long timeInNS) {
            this.name = name;
            this.timeInNS = timeInNS;
        }

        
    }


    
    public interface Listener {
        void started(String className);
        void finished(String className);
        void performance(String className,
                long itemTimeNS, int iterations,
                List<IntermediateTime> itermediates);
        void passed(String className);
        void failed(String className, Throwable execption);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.592 -0500", hash_original_method = "EAD0F494E7194587949578C1412758D9", hash_generated_method = "2E4172EEA2FBF21F1888BB1829856964")
    
public void finishTiming(boolean realTime) {
        if (realTime) {
            mEndTime = System.currentTimeMillis();
        } else {
            mEndTime = SystemClock.currentThreadTimeMillis();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.594 -0500", hash_original_method = "EC5A911B7459E56F5BCB8B3F76085E8F", hash_generated_method = "B75BC5B0D18441B60274CBA6CC135D0F")
    
public void setPerformanceMode(int mode) {
        mMode = mode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.596 -0500", hash_original_method = "A32FEAB2DFA07740C77FDABE5769E691", hash_generated_method = "191B0C4EBD79B17EE2C4C3CED3CD886C")
    
private void missingTest(String className, Throwable e) {
        started(className);
        finished(className);
        failed(className, e);
    }

    /*
    This class determines if more suites are added to this class then adds all individual
    test classes to a test suite for run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.601 -0500", hash_original_method = "708D6F0A09F91E4686ADAFFE08052780", hash_generated_method = "3AF6FC6F81A944034B8584E4CCC683F5")
    
public void run(String className) {
        try {
            mClassName = className;
            Class clazz = mContext.getClassLoader().loadClass(className);
            Method method = getChildrenMethod(clazz);
            if (method != null) {
                String[] children = getChildren(method);
                run(children);
            } else if (mRunnableClass.isAssignableFrom(clazz)) {
                Runnable test = (Runnable) clazz.newInstance();
                TestCase testcase = null;
                if (test instanceof TestCase) {
                    testcase = (TestCase) test;
                }
                Throwable e = null;
                boolean didSetup = false;
                started(className);
                try {
                    if (testcase != null) {
                        testcase.setUp(mContext);
                        didSetup = true;
                    }
                    if (mMode == PERFORMANCE) {
                        runInPerformanceMode(test, className, false, className);
                    } else if (mMode == PROFILING) {
                        //Need a way to mark a test to be run in profiling mode or not.
                        startProfiling();
                        test.run();
                        finishProfiling();
                    } else {
                        test.run();
                    }
                } catch (Throwable ex) {
                    e = ex;
                }
                if (testcase != null && didSetup) {
                    try {
                        testcase.tearDown();
                    } catch (Throwable ex) {
                        e = ex;
                    }
                }
                finished(className);
                if (e == null) {
                    passed(className);
                } else {
                    failed(className, e);
                }
            } else if (mJUnitClass.isAssignableFrom(clazz)) {
                Throwable e = null;
                //Create a Junit Suite.
                JunitTestSuite suite = new JunitTestSuite();
                Method[] methods = getAllTestMethods(clazz);
                for (Method m : methods) {
                    junit.framework.TestCase test = (junit.framework.TestCase) clazz.newInstance();
                    test.setName(m.getName());

                    if (test instanceof AndroidTestCase) {
                        AndroidTestCase testcase = (AndroidTestCase) test;
                        try {
                            testcase.setContext(mContext);
                            testcase.setTestContext(mContext);
                        } catch (Exception ex) {
                            Log.i("TestHarness", ex.toString());
                        }
                    }
                    suite.addTest(test);
                }
                if (mMode == PERFORMANCE) {
                    final int testCount = suite.testCount();

                    for (int j = 0; j < testCount; j++) {
                        Test test = suite.testAt(j);
                        started(test.toString());
                        try {
                            runInPerformanceMode(test, className, true, test.toString());
                        } catch (Throwable ex) {
                            e = ex;
                        }
                        finished(test.toString());
                        if (e == null) {
                            passed(test.toString());
                        } else {
                            failed(test.toString(), e);
                        }
                    }
                } else if (mMode == PROFILING) {
                    //Need a way to mark a test to be run in profiling mode or not.
                    startProfiling();
                    junit.textui.TestRunner.run(suite);
                    finishProfiling();
                } else {
                    junit.textui.TestRunner.run(suite);
                }
            } else {
                System.out.println("Test wasn't Runnable and didn't have a"
                        + " children method: " + className);
            }
        } catch (ClassNotFoundException e) {
            Log.e("ClassNotFoundException for " + className, e.toString());
            if (isJunitTest(className)) {
                runSingleJunitTest(className);
            } else {
                missingTest(className, e);
            }
        } catch (InstantiationException e) {
            System.out.println("InstantiationException for " + className);
            missingTest(className, e);
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException for " + className);
            missingTest(className, e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.604 -0500", hash_original_method = "AC853D74759560DF742A57C630FB68EF", hash_generated_method = "BA695EAFC03908ED080ECCAF6BA80B9F")
    
public void runInPerformanceMode(Object testCase, String className, boolean junitTest,
            String testNameInDb) throws Exception {
        boolean increaseIterations = true;
        int iterations = 1;
        long duration = 0;
        mIntermediates = null;

        mInternalIterations = 1;
        Class clazz = mContext.getClassLoader().loadClass(className);
        Object perftest = clazz.newInstance();

        PerformanceTestCase perftestcase = null;
        if (perftest instanceof PerformanceTestCase) {
            perftestcase = (PerformanceTestCase) perftest;
            // only run the test if it is not marked as a performance only test
            if (mMode == REGRESSION && perftestcase.isPerformanceOnly()) return;
        }

        // First force GCs, to avoid GCs happening during out
        // test and skewing its time.
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();

        if (perftestcase != null) {
            mIntermediates = new ArrayList<IntermediateTime>();
            iterations = perftestcase.startPerformance(this);
            if (iterations > 0) {
                increaseIterations = false;
            } else {
                iterations = 1;
            }
        }

        // Pause briefly to let things settle down...
        Thread.sleep(1000);
        do {
            mEndTime = 0;
            if (increaseIterations) {
                // Test case does not implement
                // PerformanceTestCase or returned 0 iterations,
                // so we take care of measure the whole test time.
                mStartTime = SystemClock.currentThreadTimeMillis();
            } else {
                // Try to make it obvious if the test case
                // doesn't call startTiming().
                mStartTime = 0;
            }

            if (junitTest) {
                for (int i = 0; i < iterations; i++) {
                    junit.textui.TestRunner.run((junit.framework.Test) testCase);
                }
            } else {
                Runnable test = (Runnable) testCase;
                for (int i = 0; i < iterations; i++) {
                    test.run();
                }
            }

            long endTime = mEndTime;
            if (endTime == 0) {
                endTime = SystemClock.currentThreadTimeMillis();
            }

            duration = endTime - mStartTime;
            if (!increaseIterations) {
                break;
            }
            if (duration <= 1) {
                iterations *= 1000;
            } else if (duration <= 10) {
                iterations *= 100;
            } else if (duration < 100) {
                iterations *= 10;
            } else if (duration < 1000) {
                iterations *= (int) ((1000 / duration) + 2);
            } else {
                break;
            }
        } while (true);

        if (duration != 0) {
            iterations *= mInternalIterations;
            performance(testNameInDb, (duration * 1000000) / iterations,
                    iterations, mIntermediates);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.608 -0500", hash_original_method = "52331F5635218FF0736B4BCBA4AD33A3", hash_generated_method = "C1CEEB3E0167F74A9C140A46AB13C7F0")
    
public void runSingleJunitTest(String className) {
        Throwable excep = null;
        int index = className.lastIndexOf('$');
        String testName = "";
        String originalClassName = className;
        if (index >= 0) {
            className = className.substring(0, index);
            testName = originalClassName.substring(index + 1);
        }
        try {
            Class clazz = mContext.getClassLoader().loadClass(className);
            if (mJUnitClass.isAssignableFrom(clazz)) {
                junit.framework.TestCase test = (junit.framework.TestCase) clazz.newInstance();
                JunitTestSuite newSuite = new JunitTestSuite();
                test.setName(testName);

                if (test instanceof AndroidTestCase) {
                    AndroidTestCase testcase = (AndroidTestCase) test;
                    try {
                        testcase.setContext(mContext);
                    } catch (Exception ex) {
                        Log.w(TAG, "Exception encountered while trying to set the context.", ex);
                    }
                }
                newSuite.addTest(test);

                if (mMode == PERFORMANCE) {
                    try {
                        started(test.toString());
                        runInPerformanceMode(test, className, true, test.toString());
                        finished(test.toString());
                        if (excep == null) {
                            passed(test.toString());
                        } else {
                            failed(test.toString(), excep);
                        }
                    } catch (Throwable ex) {
                        excep = ex;
                    }

                } else if (mMode == PROFILING) {
                    startProfiling();
                    junit.textui.TestRunner.run(newSuite);
                    finishProfiling();
                } else {
                    junit.textui.TestRunner.run(newSuite);
                }
            }
        } catch (ClassNotFoundException e) {
            Log.e("TestHarness", "No test case to run", e);
        } catch (IllegalAccessException e) {
            Log.e("TestHarness", "Illegal Access Exception", e);
        } catch (InstantiationException e) {
            Log.e("TestHarness", "Instantiation Exception", e);
        }
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.635 -0500", hash_original_method = "B693F140B371F7E4D9D6941B4BAAAF7A", hash_generated_method = "9B8A79A01E17735DA0524DA84E523177")
    
public boolean isJunitTest(String className) {
        int index = className.lastIndexOf('$');
        if (index >= 0) {
            className = className.substring(0, index);
        }
        try {
            Class clazz = mContext.getClassLoader().loadClass(className);
            if (mJUnitClass.isAssignableFrom(clazz)) {
                return true;
            }
        } catch (ClassNotFoundException e) {
        }
        return false;
    }
    static {
        try {
            mRunnableClass = Class.forName("java.lang.Runnable", false, null);
            mJUnitClass = Class.forName("junit.framework.TestCase", false, null);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("shouldn't happen", ex);
        }
    }
    
}

