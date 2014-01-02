package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.test.mock.MockContentResolver;
import android.test.mock.MockContext;





public abstract class ProviderTestCase2<T extends ContentProvider> extends AndroidTestCase {

    
    @DSModeled(DSC.BAN)
    public static <T extends ContentProvider> ContentResolver newResolverWithContentProviderFromSql(
            Context targetContext, String filenamePrefix, Class<T> providerClass, String authority,
            String databaseName, int databaseVersion, String sql) throws IllegalAccessException, InstantiationException {
        MockContentResolver resolver = new MockContentResolver();
        RenamingDelegatingContext targetContextWrapper = new RenamingDelegatingContext(
                new MockContext(), 
                targetContext, 
                filenamePrefix);
        Context context = new IsolatedContext(resolver, targetContextWrapper);
        DatabaseUtils.createDbFromSqlStatements(context, databaseName, databaseVersion, sql);
        T provider = providerClass.newInstance();
        provider.attachInfo(context, null);
        resolver.addProvider(authority, provider);
        return resolver;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.146 -0500", hash_original_field = "80508C4473F541BA7DD8E88FF090F868", hash_generated_field = "80508C4473F541BA7DD8E88FF090F868")


    Class<T> mProviderClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.148 -0500", hash_original_field = "BEAD2AEE0CF9657BCDF9A68447530849", hash_generated_field = "BEAD2AEE0CF9657BCDF9A68447530849")

    String mProviderAuthority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.150 -0500", hash_original_field = "6941A905B168EAFA3532C309CAB89195", hash_generated_field = "F2AFD016624F4AFED19D7CDFE10696F8")


    private IsolatedContext mProviderContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.152 -0500", hash_original_field = "ABB64C0A775F1FCF31401F2204FDA343", hash_generated_field = "A1ED7105D6A1F718EA95D4418CEC8FB7")

    private MockContentResolver mResolver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.168 -0500", hash_original_field = "B5F4D4E802603D5E3E4860AA47D21BE9", hash_generated_field = "C18D0C38809D3FB8758A98C7C49BCA8E")


    private T mProvider;
    /**
     * Constructor.
     *
     * @param providerClass The class name of the provider under test
     * @param providerAuthority The provider's authority string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.165 -0500", hash_original_method = "D7BEB1D3C6B8C63774732A352A035F5F", hash_generated_method = "6B73ED48BEA7EF57B08D0A149971C2A0")
    
public ProviderTestCase2(Class<T> providerClass, String providerAuthority) {
        mProviderClass = providerClass;
        mProviderAuthority = providerAuthority;
    }

    /**
     * Returns the content provider created by this class in the {@link #setUp()} method.
     * @return T An instance of the provider class given as a parameter to the test case class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.170 -0500", hash_original_method = "60F9945BF24BB2313DED37AEBA7B6E3A", hash_generated_method = "BD495C9FC202C18082612E2D4CAAFA3E")
    
public T getProvider() {
        return mProvider;
    }

    /**
     * Sets up the environment for the test fixture.
     * <p>
     * Creates a new
     * {@link android.test.mock.MockContentResolver}, a new IsolatedContext
     * that isolates the provider's file operations, and a new instance of
     * the provider under test within the isolated environment.
     * </p>
     *
     * @throws Exception
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.172 -0500", hash_original_method = "DC4B036E4567F890DA30ECA6CEC7275F", hash_generated_method = "33DF5B6CAD17E18FEF17E16B4A07A408")
    
@Override
    protected void setUp() throws Exception {
        super.setUp();

        mResolver = new MockContentResolver();
        final String filenamePrefix = "test.";
        RenamingDelegatingContext targetContextWrapper = new
                RenamingDelegatingContext(
                new MockContext2(), // The context that most methods are
                                    //delegated to
                getContext(), // The context that file methods are delegated to
                filenamePrefix);
        mProviderContext = new IsolatedContext(mResolver, targetContextWrapper);

        mProvider = mProviderClass.newInstance();
        mProvider.attachInfo(mProviderContext, null);
        assertNotNull(mProvider);
        mResolver.addProvider(mProviderAuthority, getProvider());
    }

    /**
     * Tears down the environment for the test fixture.
     * <p>
     * Calls {@link android.content.ContentProvider#shutdown()} on the
     * {@link android.content.ContentProvider} represented by mProvider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.174 -0500", hash_original_method = "A8BAAE3621FF798057A5053A590AB67A", hash_generated_method = "60C32F609DFA781671AF97E1B4DA2D24")
    
@Override
    protected void tearDown() throws Exception {
        mProvider.shutdown();
        super.tearDown();
    }

    /**
     * Gets the {@link MockContentResolver} created by this class during initialization. You
     * must use the methods of this resolver to access the provider under test.
     *
     * @return A {@link MockContentResolver} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.176 -0500", hash_original_method = "47989BC91A04FCD58E7A9B18A55F8AED", hash_generated_method = "3F97F7B9B98C7F29E9D3194C9BEAE3E7")
    
public MockContentResolver getMockContentResolver() {
        return mResolver;
    }

    /**
     * Gets the {@link IsolatedContext} created by this class during initialization.
     * @return The {@link IsolatedContext} instance
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.178 -0500", hash_original_method = "27594498B405F878C6750971BD241F38", hash_generated_method = "EE07D9472D3033B822675A3928C9DA72")
    
public IsolatedContext getMockContext() {
        return mProviderContext;
    }

    
    private class MockContext2 extends MockContext {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.811 -0400", hash_original_method = "33EBD7CE59AA6ED3E2D4F55708ACFF20", hash_generated_method = "33EBD7CE59AA6ED3E2D4F55708ACFF20")
        public MockContext2 ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.156 -0500", hash_original_method = "88D1CAA806B08D33E7F32EE9A221E7DA", hash_generated_method = "4B98C183C69D6FF0559248ACD69DE5F1")
        
@Override
        public Resources getResources() {
            return getContext().getResources();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.158 -0500", hash_original_method = "120657A43EB9D6D937D9C501B663B027", hash_generated_method = "BA59C5874097E8E4D8B24E6593272FF8")
        
@Override
        public File getDir(String name, int mode) {
            // name the directory so the directory will be separated from
            // one created through the regular Context
            return getContext().getDir("mockcontext2_" + name, mode);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.161 -0500", hash_original_method = "5BEB3FA867778B3A9B9AEA4D4C069E55", hash_generated_method = "2F5A703F6C0D3A9FAC13CAF76C439DDA")
        
@Override
        public Context getApplicationContext() {
            return this;
        }

        
    }


    
}

