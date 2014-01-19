package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import junit.framework.TestCase;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

public class InstrumentationTestCase extends TestCase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.649 -0500", hash_original_field = "5CBE0F2EE224A7AD181F35AE16EC5D56", hash_generated_field = "B2267B39A1EB39D35FC793A28FB486AB")

    private Instrumentation mInstrumentation;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.606 -0400", hash_original_method = "F06054A79CB0E1296A7D2CB8684D0A88", hash_generated_method = "F06054A79CB0E1296A7D2CB8684D0A88")
    public InstrumentationTestCase ()
    {
        //Synthesized constructor
    }

    /**
     * Injects instrumentation into this test case. This method is
     * called by the test runner during test setup.
     * 
     * @param instrumentation the instrumentation to use with this instance
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.652 -0500", hash_original_method = "30957576898B0AE27F5837919E36AECD", hash_generated_method = "27BC3CA23290C294456ECA80A96CE2A3")
    
public void injectInstrumentation(Instrumentation instrumentation) {
        mInstrumentation = instrumentation;
    }

    /**
     * Injects instrumentation into this test case. This method is
     * called by the test runner during test setup.
     *
     * @param instrumentation the instrumentation to use with this instance
     *
     * @deprecated Incorrect spelling,
     * use {@link #injectInstrumentation(android.app.Instrumentation)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.655 -0500", hash_original_method = "80E7DE8B78F72228CE1CBFCE791EFB84", hash_generated_method = "B65E30465F363197B705A3C86C2FABCB")
    
@Deprecated
    public void injectInsrumentation(Instrumentation instrumentation) {
        injectInstrumentation(instrumentation);
    }

    /**
     * Inheritors can access the instrumentation using this.
     * @return instrumentation
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.657 -0500", hash_original_method = "84F87CEBEDE5D31C88CD24E066F68A95", hash_generated_method = "952CE09D28EE4A9669353A5E94B20293")
    
public Instrumentation getInstrumentation() {
        return mInstrumentation;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.607 -0400", hash_original_method = "764789E220BD6FE52FAEF894EB0B5A08", hash_generated_method = "710852519DD88120CD28D5D10E1FD0EE")
    public final <T extends Activity> T launchActivity(
            String pkg,
            Class<T> activityCls,
            Bundle extras) {
        addTaint(extras.getTaint());
        addTaint(activityCls.getTaint());
        addTaint(pkg.getTaint());
        Intent intent = new Intent(Intent.ACTION_MAIN);
        if(extras != null)        
        {
            intent.putExtras(extras);
        } //End block
T varE7F6C12080F9D8EF62DC3FF8BA750C63_1561275626 =         launchActivityWithIntent(pkg, activityCls, intent);
        varE7F6C12080F9D8EF62DC3FF8BA750C63_1561275626.addTaint(taint);
        return varE7F6C12080F9D8EF62DC3FF8BA750C63_1561275626;
        // ---------- Original Method ----------
        //Intent intent = new Intent(Intent.ACTION_MAIN);
        //if (extras != null) {
            //intent.putExtras(extras);
        //}
        //return launchActivityWithIntent(pkg, activityCls, intent);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.608 -0400", hash_original_method = "D43C82D18E60F413349E4558A24D84A0", hash_generated_method = "5C16BDB114961A64AC91C4910467BFFD")
    @SuppressWarnings("unchecked")
    public final <T extends Activity> T launchActivityWithIntent(
            String pkg,
            Class<T> activityCls,
            Intent intent) {
        addTaint(intent.getTaint());
        addTaint(activityCls.getTaint());
        addTaint(pkg.getTaint());
        intent.setClassName(pkg, activityCls.getName());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        T activity = (T) getInstrumentation().startActivitySync(intent);
        getInstrumentation().waitForIdleSync();
T var8CEBAC25E19008E785695F06EF11C2CD_232979124 =         activity;
        var8CEBAC25E19008E785695F06EF11C2CD_232979124.addTaint(taint);
        return var8CEBAC25E19008E785695F06EF11C2CD_232979124;
        // ---------- Original Method ----------
        //intent.setClassName(pkg, activityCls.getName());
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //T activity = (T) getInstrumentation().startActivitySync(intent);
        //getInstrumentation().waitForIdleSync();
        //return activity;
    }
    
    /**
     * Helper for running portions of a test on the UI thread.
     * 
     * Note, in most cases it is simpler to annotate the test method with 
     * {@link android.test.UiThreadTest}, which will run the entire test method on the UI thread.
     * Use this method if you need to switch in and out of the UI thread to perform your test.
     * 
     * @param r runnable containing test code in the {@link Runnable#run()} method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.667 -0500", hash_original_method = "F4164F0D843971333C91373781EC7696", hash_generated_method = "FA78C3D82C6F95488BFEC136367D79E7")
    
public void runTestOnUiThread(final Runnable r) throws Throwable {
        final Throwable[] exceptions = new Throwable[1];
        getInstrumentation().runOnMainSync(new Runnable() {
            public void run() {
                try {
                    r.run();
                } catch (Throwable throwable) {
                    exceptions[0] = throwable;
                }
            }
        });
        if (exceptions[0] != null) {
            throw exceptions[0];
        }
    }

    /**
     * Runs the current unit test. If the unit test is annotated with
     * {@link android.test.UiThreadTest}, the test is run on the UI thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.673 -0500", hash_original_method = "58232FB81B29EAE27E4B0E868189E51E", hash_generated_method = "9E354E4A8B85C516A1BC416C3F058180")
    
@Override
    protected void runTest() throws Throwable {
        String fName = getName();
        assertNotNull(fName);
        Method method = null;
        try {
            // use getMethod to get all public inherited
            // methods. getDeclaredMethods returns all
            // methods of this class but excludes the
            // inherited ones.
            method = getClass().getMethod(fName, (Class[]) null);
        } catch (NoSuchMethodException e) {
            fail("Method \""+fName+"\" not found");
        }

        if (!Modifier.isPublic(method.getModifiers())) {
            fail("Method \""+fName+"\" should be public");
        }

        int runCount = 1;
        boolean isRepetitive = false;
        if (method.isAnnotationPresent(FlakyTest.class)) {
            runCount = method.getAnnotation(FlakyTest.class).tolerance();
        } else if (method.isAnnotationPresent(RepetitiveTest.class)) {
            runCount = method.getAnnotation(RepetitiveTest.class).numIterations();
            isRepetitive = true;
        }

        if (method.isAnnotationPresent(UiThreadTest.class)) {
            final int tolerance = runCount;
            final boolean repetitive = isRepetitive;
            final Method testMethod = method;
            final Throwable[] exceptions = new Throwable[1];
            getInstrumentation().runOnMainSync(new Runnable() {
                public void run() {
                    try {
                        runMethod(testMethod, tolerance, repetitive);
                    } catch (Throwable throwable) {
                        exceptions[0] = throwable;
                    }
                }
            });
            if (exceptions[0] != null) {
                throw exceptions[0];
            }
        } else {
            runMethod(method, runCount, isRepetitive);
        }
    }

    // For backwards-compatibility after adding isRepetitive
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.676 -0500", hash_original_method = "73C1718FE30AA12508CCB537F6FDE014", hash_generated_method = "F684732A2DB48884CF3D52D339B7917A")
    
private void runMethod(Method runMethod, int tolerance) throws Throwable {
        runMethod(runMethod, tolerance, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.678 -0500", hash_original_method = "FE4B0FEDC134C5D618CB046880639140", hash_generated_method = "84881099638F5CAC8A41158572946D5F")
    
private void runMethod(Method runMethod, int tolerance, boolean isRepetitive) throws Throwable {
        Throwable exception = null;

        int runCount = 0;
        do {
            try {
                runMethod.invoke(this, (Object[]) null);
                exception = null;
            } catch (InvocationTargetException e) {
                e.fillInStackTrace();
                exception = e.getTargetException();
            } catch (IllegalAccessException e) {
                e.fillInStackTrace();
                exception = e;
            } finally {
                runCount++;
                // Report current iteration number, if test is repetitive
                if (isRepetitive) {
                    Bundle iterations = new Bundle();
                    iterations.putInt("currentiterations", runCount);
                    getInstrumentation().sendStatus(2, iterations);
                }
            }
        } while ((runCount < tolerance) && (isRepetitive || exception != null));

        if (exception != null) {
            throw exception;
        }
    }

    /**
     * Sends a series of key events through instrumentation and waits for idle. The sequence
     * of keys is a string containing the key names as specified in KeyEvent, without the
     * KEYCODE_ prefix. For instance: sendKeys("DPAD_LEFT A B C DPAD_CENTER"). Each key can
     * be repeated by using the N* prefix. For instance, to send two KEYCODE_DPAD_LEFT, use
     * the following: sendKeys("2*DPAD_LEFT").
     *
     * @param keysSequence The sequence of keys.
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.681 -0500", hash_original_method = "F1A2611A7518798734124BE0FA3DC184", hash_generated_method = "2954BED3906FA26E267504074A939ECD")
    
public void sendKeys(String keysSequence) {
        final String[] keys = keysSequence.split(" ");
        final int count = keys.length;

        final Instrumentation instrumentation = getInstrumentation();

        for (int i = 0; i < count; i++) {
            String key = keys[i];
            int repeater = key.indexOf('*');

            int keyCount;
            try {
                keyCount = repeater == -1 ? 1 : Integer.parseInt(key.substring(0, repeater));
            } catch (NumberFormatException e) {
                Log.w("ActivityTestCase", "Invalid repeat count: " + key);
                continue;
            }

            if (repeater != -1) {
                key = key.substring(repeater + 1);
            }

            for (int j = 0; j < keyCount; j++) {
                try {
                    final Field keyCodeField = KeyEvent.class.getField("KEYCODE_" + key);
                    final int keyCode = keyCodeField.getInt(null);
                    try {
                        instrumentation.sendKeyDownUpSync(keyCode);
                    } catch (SecurityException e) {
                        // Ignore security exceptions that are now thrown
                        // when trying to send to another app, to retain
                        // compatibility with existing tests.
                    }
                } catch (NoSuchFieldException e) {
                    Log.w("ActivityTestCase", "Unknown keycode: KEYCODE_" + key);
                    break;
                } catch (IllegalAccessException e) {
                    Log.w("ActivityTestCase", "Unknown keycode: KEYCODE_" + key);
                    break;
                }
            }
        }

        instrumentation.waitForIdleSync();
    }

    /**
     * Sends a series of key events through instrumentation and waits for idle. For instance:
     * sendKeys(KEYCODE_DPAD_LEFT, KEYCODE_DPAD_CENTER).
     *
     * @param keys The series of key codes to send through instrumentation.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.683 -0500", hash_original_method = "25439235D86C904EDC7CD1B76214296A", hash_generated_method = "1C437CDD5C62F5899CF06D0019BF182B")
    
public void sendKeys(int... keys) {
        final int count = keys.length;
        final Instrumentation instrumentation = getInstrumentation();

        for (int i = 0; i < count; i++) {
            try {
                instrumentation.sendKeyDownUpSync(keys[i]);
            } catch (SecurityException e) {
                // Ignore security exceptions that are now thrown
                // when trying to send to another app, to retain
                // compatibility with existing tests.
            }
        }

        instrumentation.waitForIdleSync();
    }

    /**
     * Sends a series of key events through instrumentation and waits for idle. Each key code
     * must be preceded by the number of times the key code must be sent. For instance:
     * sendRepeatedKeys(1, KEYCODE_DPAD_CENTER, 2, KEYCODE_DPAD_LEFT).
     *
     * @param keys The series of key repeats and codes to send through instrumentation.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.686 -0500", hash_original_method = "FBC03E5CDE4AF992F9EAA065B65F23C0", hash_generated_method = "7F19AE149B5B43D49DC16C43F00EF024")
    
public void sendRepeatedKeys(int... keys) {
        final int count = keys.length;
        if ((count & 0x1) == 0x1) {
            throw new IllegalArgumentException("The size of the keys array must "
                    + "be a multiple of 2");
        }

        final Instrumentation instrumentation = getInstrumentation();

        for (int i = 0; i < count; i += 2) {
            final int keyCount = keys[i];
            final int keyCode = keys[i + 1];
            for (int j = 0; j < keyCount; j++) {
                try {
                    instrumentation.sendKeyDownUpSync(keyCode);
                } catch (SecurityException e) {
                    // Ignore security exceptions that are now thrown
                    // when trying to send to another app, to retain
                    // compatibility with existing tests.
                }
            }
        }

        instrumentation.waitForIdleSync();
    }
    
    /**
     * Make sure all resources are cleaned up and garbage collected before moving on to the next
     * test. Subclasses that override this method should make sure they call super.tearDown()
     * at the end of the overriding method.
     * 
     * @throws Exception
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.688 -0500", hash_original_method = "FDD2FC9FD3536A57EA5709C92DDFDA00", hash_generated_method = "25F8972A71AF3F265EBEAA230EB3E829")
    
@Override
    protected void tearDown() throws Exception {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        super.tearDown();
    }
    
}

