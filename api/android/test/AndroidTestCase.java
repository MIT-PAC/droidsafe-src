package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.lang.reflect.Field;

import junit.framework.TestCase;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class AndroidTestCase extends TestCase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.465 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.467 -0500", hash_original_field = "04AD68CC6EA94CE4EAEB7BB7E922A064", hash_generated_field = "4100C2793C522C9FB77478AD95CF578C")

    private Context mTestContext;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.283 -0400", hash_original_method = "FA9720D40CDC95CCAA7E59BD6F9C75E3", hash_generated_method = "FA9720D40CDC95CCAA7E59BD6F9C75E3")
    public AndroidTestCase ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.469 -0500", hash_original_method = "C075C1EA684B5A9C947727B1963E4CB2", hash_generated_method = "6E282E8121AB714D0FB5A04382A994EF")
    
@Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.471 -0500", hash_original_method = "2BD388E2F32CC4B26827F8032514E9AF", hash_generated_method = "9B7D31DB93ED0ADA2A4FEEE1D209E054")
    
@Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.473 -0500", hash_original_method = "A28E17AE7E99D1F277F3747A57A4A95C", hash_generated_method = "0CEE8D974D99D240157D8FCE9886C47B")
    
public void testAndroidTestCaseSetupProperly() {
        assertNotNull("Context is null. setContext should be called before tests are run",
                mContext);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.475 -0500", hash_original_method = "79C5FD8850A7FDB4967DBA296D1AB9AD", hash_generated_method = "8123FBA4DFA38D2D9EDCDEEE26B6DCB9")
    
public void setContext(Context context) {
        mContext = context;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.478 -0500", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "BA026F6873AF9B17E96AB49AFB6CEE03")
    
public Context getContext() {
        return mContext;
    }

    /**
     * Test context can be used to access resources from the test's own package
     * as opposed to the resources from the test target package. Access to the
     * latter is provided by the context set with the {@link #setContext}
     * method.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.480 -0500", hash_original_method = "3848B0B3D63F14BFB1A8E29618D82C34", hash_generated_method = "752CD0A2A6FCB0882195C04C583A839C")
    
public void setTestContext(Context context) {
        mTestContext = context;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.483 -0500", hash_original_method = "0FA51A2375E728630821E2E4824DA56A", hash_generated_method = "64E6FC98E14FF5627AE394EECA3D86BE")
    
public Context getTestContext() {
        return mTestContext;
    }

    /**
     * Asserts that launching a given activity is protected by a particular permission by
     * attempting to start the activity and validating that a {@link SecurityException}
     * is thrown that mentions the permission in its error message.
     *
     * Note that an instrumentation isn't needed because all we are looking for is a security error
     * and we don't need to wait for the activity to launch and get a handle to the activity.
     *
     * @param packageName The package name of the activity to launch.
     * @param className The class of the activity to launch.
     * @param permission The name of the permission.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.485 -0500", hash_original_method = "3DE5935B2434BD0D17B624272A135469", hash_generated_method = "C760F0306485FADA7DC49EABDCC387BD")
    
public void assertActivityRequiresPermission(
            String packageName, String className, String permission) {
        final Intent intent = new Intent();
        intent.setClassName(packageName, className);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        try {
            getContext().startActivity(intent);
            fail("expected security exception for " + permission);
        } catch (SecurityException expected) {
            assertNotNull("security exception's error message.", expected.getMessage());
            assertTrue("error message should contain " + permission + ".",
                    expected.getMessage().contains(permission));
        }
    }

    /**
     * Asserts that reading from the content uri requires a particular permission by querying the
     * uri and ensuring a {@link SecurityException} is thrown mentioning the particular permission.
     *
     * @param uri The uri that requires a permission to query.
     * @param permission The permission that should be required.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.487 -0500", hash_original_method = "CB8C127D61BF3BFB6D4AA0767F4C3E81", hash_generated_method = "B3667C7485168CE2F0F8D67ADA173960")
    
public void assertReadingContentUriRequiresPermission(Uri uri, String permission) {
        try {
            getContext().getContentResolver().query(uri, null, null, null, null);
            fail("expected SecurityException requiring " + permission);
        } catch (SecurityException expected) {
            assertNotNull("security exception's error message.", expected.getMessage());
            assertTrue("error message should contain " + permission + ".",
                    expected.getMessage().contains(permission));
        }
    }

    /**
     * Asserts that writing to the content uri requires a particular permission by inserting into
     * the uri and ensuring a {@link SecurityException} is thrown mentioning the particular
     * permission.
     *
     * @param uri The uri that requires a permission to query.
     * @param permission The permission that should be required.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.490 -0500", hash_original_method = "945434805312A02DD9F6BB0BD9CF6A31", hash_generated_method = "7713FCED4EA91C274ABE6F4E71A7D728")
    
public void assertWritingContentUriRequiresPermission(Uri uri, String permission) {
        try {
            getContext().getContentResolver().insert(uri, new ContentValues());
            fail("expected SecurityException requiring " + permission);
        } catch (SecurityException expected) {
            assertNotNull("security exception's error message.", expected.getMessage());
            assertTrue("error message should contain " + permission + ".",
                    expected.getMessage().contains(permission));
        }
    }

    /**
     * This function is called by various TestCase implementations, at tearDown() time, in order
     * to scrub out any class variables.  This protects against memory leaks in the case where a
     * test case creates a non-static inner class (thus referencing the test case) and gives it to
     * someone else to hold onto.
     *
     * @param testCaseClass The class of the derived TestCase implementation.
     *
     * @throws IllegalAccessException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.493 -0500", hash_original_method = "A497F47748432DFEA008CEEF9E1905F4", hash_generated_method = "793AE6E5B9D8FE042AF372C3242448F2")
    
protected void scrubClass(final Class<?> testCaseClass)
    throws IllegalAccessException {
        final Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {
            final Class<?> fieldClass = field.getDeclaringClass();
            if (testCaseClass.isAssignableFrom(fieldClass) && !field.getType().isPrimitive()) {
                try {
                    field.setAccessible(true);
                    field.set(this, null);
                } catch (Exception e) {
                    android.util.Log.d("TestCase", "Error: Could not nullify field!");
                }

                if (field.get(this) != null) {
                    android.util.Log.d("TestCase", "Error: Could not nullify field!");
                }
            }
        }
    }
    
}

