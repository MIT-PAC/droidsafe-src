package android.test;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.test.mock.MockContext;
import android.test.mock.MockContentResolver;
import android.database.DatabaseUtils;
import java.io.File;

public abstract class ProviderTestCase2<T extends ContentProvider> extends AndroidTestCase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.135 -0400", hash_original_field = "F7BB479A5B86348629AE59E109FFC091", hash_generated_field = "80508C4473F541BA7DD8E88FF090F868")

    Class<T> mProviderClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.135 -0400", hash_original_field = "D11E88194BD989F9E91B9934838E75E1", hash_generated_field = "BEAD2AEE0CF9657BCDF9A68447530849")

    String mProviderAuthority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.135 -0400", hash_original_field = "6126F3ADE7D1E4549FE0617BECDD3490", hash_generated_field = "F2AFD016624F4AFED19D7CDFE10696F8")

    private IsolatedContext mProviderContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.135 -0400", hash_original_field = "CF849E3C15214EFD093D4303B542BF44", hash_generated_field = "A1ED7105D6A1F718EA95D4418CEC8FB7")

    private MockContentResolver mResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.135 -0400", hash_original_field = "BD1D19BC6BC3803BE152A977D479AC49", hash_generated_field = "C18D0C38809D3FB8758A98C7C49BCA8E")

    private T mProvider;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.136 -0400", hash_original_method = "D7BEB1D3C6B8C63774732A352A035F5F", hash_generated_method = "6E4CE79349090DAC92B14CF722E694B4")
    public  ProviderTestCase2(Class<T> providerClass, String providerAuthority) {
        mProviderClass = providerClass;
        mProviderAuthority = providerAuthority;
        // ---------- Original Method ----------
        //mProviderClass = providerClass;
        //mProviderAuthority = providerAuthority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.136 -0400", hash_original_method = "60F9945BF24BB2313DED37AEBA7B6E3A", hash_generated_method = "1F61BD2C40461555DD329897A6E95507")
    public T getProvider() {
T var0FBB50B5F14310A28A298A4AC9FE2015_1769435306 =         mProvider;
        var0FBB50B5F14310A28A298A4AC9FE2015_1769435306.addTaint(taint);
        return var0FBB50B5F14310A28A298A4AC9FE2015_1769435306;
        // ---------- Original Method ----------
        //return mProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.137 -0400", hash_original_method = "DC4B036E4567F890DA30ECA6CEC7275F", hash_generated_method = "8859F8C62D4B3CE9D3F13874134265D1")
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mResolver = new MockContentResolver();
        final String filenamePrefix = "test.";
        RenamingDelegatingContext targetContextWrapper = new
                RenamingDelegatingContext(
                new MockContext2(), 
                getContext(), 
                filenamePrefix);
        mProviderContext = new IsolatedContext(mResolver, targetContextWrapper);
        mProvider = mProviderClass.newInstance();
        mProvider.attachInfo(mProviderContext, null);
        assertNotNull(mProvider);
        mResolver.addProvider(mProviderAuthority, getProvider());
        // ---------- Original Method ----------
        //super.setUp();
        //mResolver = new MockContentResolver();
        //final String filenamePrefix = "test.";
        //RenamingDelegatingContext targetContextWrapper = new
                //RenamingDelegatingContext(
                //new MockContext2(), 
                //getContext(), 
                //filenamePrefix);
        //mProviderContext = new IsolatedContext(mResolver, targetContextWrapper);
        //mProvider = mProviderClass.newInstance();
        //mProvider.attachInfo(mProviderContext, null);
        //assertNotNull(mProvider);
        //mResolver.addProvider(mProviderAuthority, getProvider());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.138 -0400", hash_original_method = "A8BAAE3621FF798057A5053A590AB67A", hash_generated_method = "0FEBED9A22A223CA9823A86F232B0722")
    @Override
    protected void tearDown() throws Exception {
        mProvider.shutdown();
        super.tearDown();
        // ---------- Original Method ----------
        //mProvider.shutdown();
        //super.tearDown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.138 -0400", hash_original_method = "47989BC91A04FCD58E7A9B18A55F8AED", hash_generated_method = "C2615A828EC9AB35BDE527A468CF6A1E")
    public MockContentResolver getMockContentResolver() {
MockContentResolver varAB109E9A06CD2C0031B0F4CF098EA9E9_1560767362 =         mResolver;
        varAB109E9A06CD2C0031B0F4CF098EA9E9_1560767362.addTaint(taint);
        return varAB109E9A06CD2C0031B0F4CF098EA9E9_1560767362;
        // ---------- Original Method ----------
        //return mResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.138 -0400", hash_original_method = "27594498B405F878C6750971BD241F38", hash_generated_method = "D72D41D3676141E75D72180F783FD592")
    public IsolatedContext getMockContext() {
IsolatedContext var8DD4DD47675B38CCCB1F8751874E6C34_784508158 =         mProviderContext;
        var8DD4DD47675B38CCCB1F8751874E6C34_784508158.addTaint(taint);
        return var8DD4DD47675B38CCCB1F8751874E6C34_784508158;
        // ---------- Original Method ----------
        //return mProviderContext;
    }

    
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

    
    private class MockContext2 extends MockContext {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.139 -0400", hash_original_method = "33EBD7CE59AA6ED3E2D4F55708ACFF20", hash_generated_method = "33EBD7CE59AA6ED3E2D4F55708ACFF20")
        public MockContext2 ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.140 -0400", hash_original_method = "88D1CAA806B08D33E7F32EE9A221E7DA", hash_generated_method = "F145F2FEB48C443CA550ED8B3638F0CA")
        @Override
        public Resources getResources() {
Resources var300F559A990327567ADA6B2B7540B3AC_1663761733 =             getContext().getResources();
            var300F559A990327567ADA6B2B7540B3AC_1663761733.addTaint(taint);
            return var300F559A990327567ADA6B2B7540B3AC_1663761733;
            // ---------- Original Method ----------
            //return getContext().getResources();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.140 -0400", hash_original_method = "120657A43EB9D6D937D9C501B663B027", hash_generated_method = "F86356DB39470D4BF51E6787E3577D79")
        @Override
        public File getDir(String name, int mode) {
            addTaint(mode);
            addTaint(name.getTaint());
File varF0EE242A1A7DD6772B5AB1383F0A7B57_1988587450 =             getContext().getDir("mockcontext2_" + name, mode);
            varF0EE242A1A7DD6772B5AB1383F0A7B57_1988587450.addTaint(taint);
            return varF0EE242A1A7DD6772B5AB1383F0A7B57_1988587450;
            // ---------- Original Method ----------
            //return getContext().getDir("mockcontext2_" + name, mode);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.140 -0400", hash_original_method = "5BEB3FA867778B3A9B9AEA4D4C069E55", hash_generated_method = "94819F0C201EF0E3E8421AED5E1F8F25")
        @Override
        public Context getApplicationContext() {
Context var72A74007B2BE62B849F475C7BDA4658B_1055802819 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1055802819.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1055802819;
            // ---------- Original Method ----------
            //return this;
        }

        
    }


    
}

