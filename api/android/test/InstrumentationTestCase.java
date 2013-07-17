package android.test;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import junit.framework.TestCase;

public class InstrumentationTestCase extends TestCase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.606 -0400", hash_original_field = "E062CE48CD3AFCDDC19DD9FCF2E119D4", hash_generated_field = "B2267B39A1EB39D35FC793A28FB486AB")

    private Instrumentation mInstrumentation;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.606 -0400", hash_original_method = "F06054A79CB0E1296A7D2CB8684D0A88", hash_generated_method = "F06054A79CB0E1296A7D2CB8684D0A88")
    public InstrumentationTestCase ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.606 -0400", hash_original_method = "30957576898B0AE27F5837919E36AECD", hash_generated_method = "52FC0986A496E063EF447F094F5B0687")
    public void injectInstrumentation(Instrumentation instrumentation) {
        mInstrumentation = instrumentation;
        // ---------- Original Method ----------
        //mInstrumentation = instrumentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.606 -0400", hash_original_method = "80E7DE8B78F72228CE1CBFCE791EFB84", hash_generated_method = "5A6AD4CB7D8865EE3D58DD9D6C618685")
    @Deprecated
    public void injectInsrumentation(Instrumentation instrumentation) {
        addTaint(instrumentation.getTaint());
        injectInstrumentation(instrumentation);
        // ---------- Original Method ----------
        //injectInstrumentation(instrumentation);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.607 -0400", hash_original_method = "84F87CEBEDE5D31C88CD24E066F68A95", hash_generated_method = "78B98383AA558E4E5158799136B94F91")
    public Instrumentation getInstrumentation() {
Instrumentation var0FB7EFFFC0B8CD54E817BBC71710DE88_1917378878 =         mInstrumentation;
        var0FB7EFFFC0B8CD54E817BBC71710DE88_1917378878.addTaint(taint);
        return var0FB7EFFFC0B8CD54E817BBC71710DE88_1917378878;
        // ---------- Original Method ----------
        //return mInstrumentation;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.609 -0400", hash_original_method = "F4164F0D843971333C91373781EC7696", hash_generated_method = "CD5E7B031A9CF6C8039D99954A6F5F8F")
    public void runTestOnUiThread(final Runnable r) throws Throwable {
        addTaint(r.getTaint());
        final Throwable[] exceptions = new Throwable[1];
        getInstrumentation().runOnMainSync(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.609 -0400", hash_original_method = "9BA516EA7E7C66F18D761E409539F223", hash_generated_method = "7A68474A1AEED7AB63E6550AA15CB070")
        public void run() {
            try 
            {
                r.run();
            } //End block
            catch (Throwable throwable)
            {
                exceptions[0] = throwable;
            } //End block
            // ---------- Original Method ----------
            //try {
                    //r.run();
                //} catch (Throwable throwable) {
                    //exceptions[0] = throwable;
                //}
        }
});
        if(exceptions[0] != null)        
        {
            Throwable var296B1984B2B2C37AA52E811D451E8A46_1109201515 = exceptions[0];
            var296B1984B2B2C37AA52E811D451E8A46_1109201515.addTaint(taint);
            throw var296B1984B2B2C37AA52E811D451E8A46_1109201515;
        } //End block
        // ---------- Original Method ----------
        //final Throwable[] exceptions = new Throwable[1];
        //getInstrumentation().runOnMainSync(new Runnable() {
            //public void run() {
                //try {
                    //r.run();
                //} catch (Throwable throwable) {
                    //exceptions[0] = throwable;
                //}
            //}
        //});
        //if (exceptions[0] != null) {
            //throw exceptions[0];
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.612 -0400", hash_original_method = "58232FB81B29EAE27E4B0E868189E51E", hash_generated_method = "AAB97AC8682E651CC6F41728149FB45A")
    @Override
    protected void runTest() throws Throwable {
        String fName = getName();
        assertNotNull(fName);
        Method method = null;
        try 
        {
            method = getClass().getMethod(fName, (Class[]) null);
        } //End block
        catch (NoSuchMethodException e)
        {
            fail("Method \""+fName+"\" not found");
        } //End block
        if(!Modifier.isPublic(method.getModifiers()))        
        {
            fail("Method \""+fName+"\" should be public");
        } //End block
        int runCount = 1;
        boolean isRepetitive = false;
        if(method.isAnnotationPresent(FlakyTest.class))        
        {
            runCount = method.getAnnotation(FlakyTest.class).tolerance();
        } //End block
        else
        if(method.isAnnotationPresent(RepetitiveTest.class))        
        {
            runCount = method.getAnnotation(RepetitiveTest.class).numIterations();
            isRepetitive = true;
        } //End block
        if(method.isAnnotationPresent(UiThreadTest.class))        
        {
            final int tolerance = runCount;
            final boolean repetitive = isRepetitive;
            final Method testMethod = method;
            final Throwable[] exceptions = new Throwable[1];
            getInstrumentation().runOnMainSync(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.611 -0400", hash_original_method = "18AEF0A24287139D18AF6F95A1C9DFBE", hash_generated_method = "BF55256D99C438C4FF15569DF1773FEB")
        public void run() {
            try 
            {
                runMethod(testMethod, tolerance, repetitive);
            } //End block
            catch (Throwable throwable)
            {
                exceptions[0] = throwable;
            } //End block
            // ---------- Original Method ----------
            //try {
                        //runMethod(testMethod, tolerance, repetitive);
                    //} catch (Throwable throwable) {
                        //exceptions[0] = throwable;
                    //}
        }
});
            if(exceptions[0] != null)            
            {
                Throwable var296B1984B2B2C37AA52E811D451E8A46_251358053 = exceptions[0];
                var296B1984B2B2C37AA52E811D451E8A46_251358053.addTaint(taint);
                throw var296B1984B2B2C37AA52E811D451E8A46_251358053;
            } //End block
        } //End block
        else
        {
            runMethod(method, runCount, isRepetitive);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.615 -0400", hash_original_method = "73C1718FE30AA12508CCB537F6FDE014", hash_generated_method = "6FD84F0A28FA93C338CFF549740A23D6")
    private void runMethod(Method runMethod, int tolerance) throws Throwable {
        addTaint(tolerance);
        addTaint(runMethod.getTaint());
        runMethod(runMethod, tolerance, false);
        // ---------- Original Method ----------
        //runMethod(runMethod, tolerance, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.617 -0400", hash_original_method = "FE4B0FEDC134C5D618CB046880639140", hash_generated_method = "A132FD85C25B60D304FD653C5EC05DD7")
    private void runMethod(Method runMethod, int tolerance, boolean isRepetitive) throws Throwable {
        addTaint(isRepetitive);
        addTaint(tolerance);
        addTaint(runMethod.getTaint());
        Throwable exception = null;
        int runCount = 0;
        do {
            {
                try 
                {
                    runMethod.invoke(this, (Object[]) null);
                    exception = null;
                } //End block
                catch (InvocationTargetException e)
                {
                    e.fillInStackTrace();
                    exception = e.getTargetException();
                } //End block
                catch (IllegalAccessException e)
                {
                    e.fillInStackTrace();
                    exception = e;
                } //End block
                finally 
                {
                    runCount++;
                    if(isRepetitive)                    
                    {
                        Bundle iterations = new Bundle();
                        iterations.putInt("currentiterations", runCount);
                        getInstrumentation().sendStatus(2, iterations);
                    } //End block
                } //End block
            } //End block
} while ((runCount < tolerance) && (isRepetitive || exception != null));
        if(exception != null)        
        {
            exception.addTaint(taint);
            throw exception;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.619 -0400", hash_original_method = "F1A2611A7518798734124BE0FA3DC184", hash_generated_method = "877E1BF34F4001EB0BD7B6997E3850F8")
    public void sendKeys(String keysSequence) {
        addTaint(keysSequence.getTaint());
        final String[] keys = keysSequence.split(" ");
        final int count = keys.length;
        final Instrumentation instrumentation = getInstrumentation();
for(int i = 0;i < count;i++)
        {
            String key = keys[i];
            int repeater = key.indexOf('*');
            int keyCount;
            try 
            {
                keyCount = repeater == -1 ? 1 : Integer.parseInt(key.substring(0, repeater));
            } //End block
            catch (NumberFormatException e)
            {
                continue;
            } //End block
            if(repeater != -1)            
            {
                key = key.substring(repeater + 1);
            } //End block
for(int j = 0;j < keyCount;j++)
            {
                try 
                {
                    final Field keyCodeField = KeyEvent.class.getField("KEYCODE_" + key);
                    final int keyCode = keyCodeField.getInt(null);
                    try 
                    {
                        instrumentation.sendKeyDownUpSync(keyCode);
                    } //End block
                    catch (SecurityException e)
                    {
                    } //End block
                } //End block
                catch (NoSuchFieldException e)
                {
                    break;
                } //End block
                catch (IllegalAccessException e)
                {
                    break;
                } //End block
            } //End block
        } //End block
        instrumentation.waitForIdleSync();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.621 -0400", hash_original_method = "25439235D86C904EDC7CD1B76214296A", hash_generated_method = "9EDB6398BEFD71D3422C2B5294C4E7EB")
    public void sendKeys(int... keys) {
        addTaint(keys[0]);
        final int count = keys.length;
        final Instrumentation instrumentation = getInstrumentation();
for(int i = 0;i < count;i++)
        {
            try 
            {
                instrumentation.sendKeyDownUpSync(keys[i]);
            } //End block
            catch (SecurityException e)
            {
            } //End block
        } //End block
        instrumentation.waitForIdleSync();
        // ---------- Original Method ----------
        //final int count = keys.length;
        //final Instrumentation instrumentation = getInstrumentation();
        //for (int i = 0; i < count; i++) {
            //try {
                //instrumentation.sendKeyDownUpSync(keys[i]);
            //} catch (SecurityException e) {
            //}
        //}
        //instrumentation.waitForIdleSync();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.623 -0400", hash_original_method = "FBC03E5CDE4AF992F9EAA065B65F23C0", hash_generated_method = "7D61D50D84DBB19E4ECD145C5D601935")
    public void sendRepeatedKeys(int... keys) {
        addTaint(keys[0]);
        final int count = keys.length;
        if((count & 0x1) == 0x1)        
        {
            IllegalArgumentException var5656FBDBB1C46FC1D6197ED73B4B9310_688836872 = new IllegalArgumentException("The size of the keys array must "
                    + "be a multiple of 2");
            var5656FBDBB1C46FC1D6197ED73B4B9310_688836872.addTaint(taint);
            throw var5656FBDBB1C46FC1D6197ED73B4B9310_688836872;
        } //End block
        final Instrumentation instrumentation = getInstrumentation();
for(int i = 0;i < count;i += 2)
        {
            final int keyCount = keys[i];
            final int keyCode = keys[i + 1];
for(int j = 0;j < keyCount;j++)
            {
                try 
                {
                    instrumentation.sendKeyDownUpSync(keyCode);
                } //End block
                catch (SecurityException e)
                {
                } //End block
            } //End block
        } //End block
        instrumentation.waitForIdleSync();
        // ---------- Original Method ----------
        //final int count = keys.length;
        //if ((count & 0x1) == 0x1) {
            //throw new IllegalArgumentException("The size of the keys array must "
                    //+ "be a multiple of 2");
        //}
        //final Instrumentation instrumentation = getInstrumentation();
        //for (int i = 0; i < count; i += 2) {
            //final int keyCount = keys[i];
            //final int keyCode = keys[i + 1];
            //for (int j = 0; j < keyCount; j++) {
                //try {
                    //instrumentation.sendKeyDownUpSync(keyCode);
                //} catch (SecurityException e) {
                //}
            //}
        //}
        //instrumentation.waitForIdleSync();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.625 -0400", hash_original_method = "FDD2FC9FD3536A57EA5709C92DDFDA00", hash_generated_method = "372A69750FC2736F23FDA80CC31739F7")
    @Override
    protected void tearDown() throws Exception {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        super.tearDown();
        // ---------- Original Method ----------
        //Runtime.getRuntime().gc();
        //Runtime.getRuntime().runFinalization();
        //Runtime.getRuntime().gc();
        //super.tearDown();
    }

    
}

