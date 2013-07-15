package android.test;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import junit.framework.TestCase;
import java.lang.reflect.Field;

public class AndroidTestCase extends TestCase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.761 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.761 -0400", hash_original_field = "45638DC40E95F5734FE84C3936E40B4F", hash_generated_field = "4100C2793C522C9FB77478AD95CF578C")

    private Context mTestContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.761 -0400", hash_original_method = "FA9720D40CDC95CCAA7E59BD6F9C75E3", hash_generated_method = "FA9720D40CDC95CCAA7E59BD6F9C75E3")
    public AndroidTestCase ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.762 -0400", hash_original_method = "C075C1EA684B5A9C947727B1963E4CB2", hash_generated_method = "33B8667659E021345D7AE66A5095EA4B")
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // ---------- Original Method ----------
        //super.setUp();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.762 -0400", hash_original_method = "2BD388E2F32CC4B26827F8032514E9AF", hash_generated_method = "F0A72738E6C6EEAEB8D116968B7166EC")
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        // ---------- Original Method ----------
        //super.tearDown();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.762 -0400", hash_original_method = "A28E17AE7E99D1F277F3747A57A4A95C", hash_generated_method = "7835C711021F03AC3B0467DA037450F8")
    public void testAndroidTestCaseSetupProperly() {
        assertNotNull("Context is null. setContext should be called before tests are run",
                mContext);
        // ---------- Original Method ----------
        //assertNotNull("Context is null. setContext should be called before tests are run",
                //mContext);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.763 -0400", hash_original_method = "79C5FD8850A7FDB4967DBA296D1AB9AD", hash_generated_method = "6F13A8B42448B2C5D39C1B275EFDE141")
    public void setContext(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.763 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "5714452324EFE025684D3ED30960D018")
    public Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_72938778 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_72938778.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_72938778;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.764 -0400", hash_original_method = "3848B0B3D63F14BFB1A8E29618D82C34", hash_generated_method = "B699A63D99510D00DDB5F97C782A1536")
    public void setTestContext(Context context) {
        mTestContext = context;
        // ---------- Original Method ----------
        //mTestContext = context;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.764 -0400", hash_original_method = "0FA51A2375E728630821E2E4824DA56A", hash_generated_method = "D793BE007119A2F6688621F7C2533F08")
    public Context getTestContext() {
Context var76636B45E4D1C87FF9777E5D70C7AB46_1186400631 =         mTestContext;
        var76636B45E4D1C87FF9777E5D70C7AB46_1186400631.addTaint(taint);
        return var76636B45E4D1C87FF9777E5D70C7AB46_1186400631;
        // ---------- Original Method ----------
        //return mTestContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.764 -0400", hash_original_method = "3DE5935B2434BD0D17B624272A135469", hash_generated_method = "2FD0FA3BAC1D659EEAFA092412F4D466")
    public void assertActivityRequiresPermission(
            String packageName, String className, String permission) {
        addTaint(permission.getTaint());
        addTaint(className.getTaint());
        addTaint(packageName.getTaint());
        final Intent intent = new Intent();
        intent.setClassName(packageName, className);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try 
        {
            getContext().startActivity(intent);
            fail("expected security exception for " + permission);
        } //End block
        catch (SecurityException expected)
        {
            assertNotNull("security exception's error message.", expected.getMessage());
            assertTrue("error message should contain " + permission + ".",
                    expected.getMessage().contains(permission));
        } //End block
        // ---------- Original Method ----------
        //final Intent intent = new Intent();
        //intent.setClassName(packageName, className);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //try {
            //getContext().startActivity(intent);
            //fail("expected security exception for " + permission);
        //} catch (SecurityException expected) {
            //assertNotNull("security exception's error message.", expected.getMessage());
            //assertTrue("error message should contain " + permission + ".",
                    //expected.getMessage().contains(permission));
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.765 -0400", hash_original_method = "CB8C127D61BF3BFB6D4AA0767F4C3E81", hash_generated_method = "335B0936AD8373635B60B7798BB1BA92")
    public void assertReadingContentUriRequiresPermission(Uri uri, String permission) {
        addTaint(permission.getTaint());
        addTaint(uri.getTaint());
        try 
        {
            getContext().getContentResolver().query(uri, null, null, null, null);
            fail("expected SecurityException requiring " + permission);
        } //End block
        catch (SecurityException expected)
        {
            assertNotNull("security exception's error message.", expected.getMessage());
            assertTrue("error message should contain " + permission + ".",
                    expected.getMessage().contains(permission));
        } //End block
        // ---------- Original Method ----------
        //try {
            //getContext().getContentResolver().query(uri, null, null, null, null);
            //fail("expected SecurityException requiring " + permission);
        //} catch (SecurityException expected) {
            //assertNotNull("security exception's error message.", expected.getMessage());
            //assertTrue("error message should contain " + permission + ".",
                    //expected.getMessage().contains(permission));
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.765 -0400", hash_original_method = "945434805312A02DD9F6BB0BD9CF6A31", hash_generated_method = "385844784677AB04DD2F4019B1446219")
    public void assertWritingContentUriRequiresPermission(Uri uri, String permission) {
        addTaint(permission.getTaint());
        addTaint(uri.getTaint());
        try 
        {
            getContext().getContentResolver().insert(uri, new ContentValues());
            fail("expected SecurityException requiring " + permission);
        } //End block
        catch (SecurityException expected)
        {
            assertNotNull("security exception's error message.", expected.getMessage());
            assertTrue("error message should contain " + permission + ".",
                    expected.getMessage().contains(permission));
        } //End block
        // ---------- Original Method ----------
        //try {
            //getContext().getContentResolver().insert(uri, new ContentValues());
            //fail("expected SecurityException requiring " + permission);
        //} catch (SecurityException expected) {
            //assertNotNull("security exception's error message.", expected.getMessage());
            //assertTrue("error message should contain " + permission + ".",
                    //expected.getMessage().contains(permission));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.766 -0400", hash_original_method = "A497F47748432DFEA008CEEF9E1905F4", hash_generated_method = "8CDA4FE41F3074A63A3EB90C694B2F0C")
    protected void scrubClass(final Class<?> testCaseClass) throws IllegalAccessException {
        addTaint(testCaseClass.getTaint());
        final Field[] fields = getClass().getDeclaredFields();
for(Field field : fields)
        {
            final Class<?> fieldClass = field.getDeclaringClass();
    if(testCaseClass.isAssignableFrom(fieldClass) && !field.getType().isPrimitive())            
            {
                try 
                {
                    field.setAccessible(true);
                    field.set(this, null);
                } //End block
                catch (Exception e)
                {
                    android.util.Log.d("TestCase", "Error: Could not nullify field!");
                } //End block
    if(field.get(this) != null)                
                {
                    android.util.Log.d("TestCase", "Error: Could not nullify field!");
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final Field[] fields = getClass().getDeclaredFields();
        //for (Field field : fields) {
            //final Class<?> fieldClass = field.getDeclaringClass();
            //if (testCaseClass.isAssignableFrom(fieldClass) && !field.getType().isPrimitive()) {
                //try {
                    //field.setAccessible(true);
                    //field.set(this, null);
                //} catch (Exception e) {
                    //android.util.Log.d("TestCase", "Error: Could not nullify field!");
                //}
                //if (field.get(this) != null) {
                    //android.util.Log.d("TestCase", "Error: Could not nullify field!");
                //}
            //}
        //}
    }

    
}

