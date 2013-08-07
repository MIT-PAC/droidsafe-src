package android.test;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Random;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.test.mock.MockApplication;





public abstract class ServiceTestCase<T extends Service> extends AndroidTestCase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.871 -0400", hash_original_field = "ABE707345597563360502B5433C70932", hash_generated_field = "637B9F6ABC3AC96EB3EB7681C795A33D")

    Class<T> mServiceClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.871 -0400", hash_original_field = "A0F03383C9D11CB5B436FDD418A9C4FE", hash_generated_field = "F1477828250C5BEBE602BC5EA1713A2E")

    private Context mSystemContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.871 -0400", hash_original_field = "6B35E9B21496C1A77A324DB1577A6395", hash_generated_field = "53FA3553B85F7414D1C5F2C302FDEBF9")

    private Application mApplication;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.872 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "F3295512C5A15A7E1E4BE8A38300F691")

    private T mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.872 -0400", hash_original_field = "00340BEB7C5E3B4E822B30E801E29ABB", hash_generated_field = "BDC91FBBED9ED66C312CB510184D92A5")

    private boolean mServiceAttached = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.872 -0400", hash_original_field = "2A83F589A0EB8FE1589DEC446A463CE2", hash_generated_field = "F0F3484542642FB72C170742CF175167")

    private boolean mServiceCreated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.872 -0400", hash_original_field = "F535E359764397C8365B2A00171D1DB2", hash_generated_field = "6B66D148B1E37EBE59F99F9D0E5A992C")

    private boolean mServiceStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.872 -0400", hash_original_field = "9E4511323F8DCE82F58F6089D1655613", hash_generated_field = "912B0BEA2990419429548895171B2F0A")

    private boolean mServiceBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.872 -0400", hash_original_field = "10B1014B326606E09E39CA12F4E9358B", hash_generated_field = "05A1A5A41A6AA7DC7317478E19978B0B")

    private Intent mServiceIntent = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.872 -0400", hash_original_field = "E5AC35A5BD46D7D9458034CDAA0AA902", hash_generated_field = "A4722B4D674B9B46CA8EAF04E1307521")

    private int mServiceId;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.872 -0400", hash_original_method = "1F3B37EA8E1B8B1054B69DFECCE45A51", hash_generated_method = "85D06AB636C51DA0CBB69DAD45C7DC56")
    public  ServiceTestCase(Class<T> serviceClass) {
        mServiceClass = serviceClass;
        // ---------- Original Method ----------
        //mServiceClass = serviceClass;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.873 -0400", hash_original_method = "E1B67BA0E23B118C6146D406450E84BD", hash_generated_method = "176CC76FEF76413721C2C6514E668491")
    public T getService() {
T var72B03849F9527CD4AC8A54AA9B97A48C_905540191 =         mService;
        var72B03849F9527CD4AC8A54AA9B97A48C_905540191.addTaint(taint);
        return var72B03849F9527CD4AC8A54AA9B97A48C_905540191;
        // ---------- Original Method ----------
        //return mService;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.873 -0400", hash_original_method = "268090C8258F440561CAD8495BE839CE", hash_generated_method = "0B1DFFD09D79A0B8CCFEFA7B01A3D28A")
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mSystemContext = getContext();
        // ---------- Original Method ----------
        //super.setUp();
        //mSystemContext = getContext();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.875 -0400", hash_original_method = "896172C51C066B5F037A8F2C24487B23", hash_generated_method = "3A3FFDB8C7966FAF0BC7DD0D8F96D9C3")
    protected void setupService() {
        mService = null;
        try 
        {
            mService = mServiceClass.newInstance();
        } //End block
        catch (Exception e)
        {
            assertNotNull(mService);
        } //End block
        if(getApplication() == null)        
        {
            setApplication(new MockApplication());
        } //End block
        mService.attach(
                getContext(),
                null,               
                mServiceClass.getName(),
                null,               
                getApplication(),
                null                
                );
        assertNotNull(mService);
        mServiceId = new Random().nextInt();
        mServiceAttached = true;
        // ---------- Original Method ----------
        //mService = null;
        //try {
            //mService = mServiceClass.newInstance();
        //} catch (Exception e) {
            //assertNotNull(mService);
        //}
        //if (getApplication() == null) {
            //setApplication(new MockApplication());
        //}
        //mService.attach(
                //getContext(),
                //null,               
                //mServiceClass.getName(),
                //null,               
                //getApplication(),
                //null                
                //);
        //assertNotNull(mService);
        //mServiceId = new Random().nextInt();
        //mServiceAttached = true;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.876 -0400", hash_original_method = "21E4CB4FCD74533F799D23D47E90F5B7", hash_generated_method = "5A760F06291C41012D1BBC881FFEC8B6")
    protected void startService(Intent intent) {
        addTaint(intent.getTaint());
        if(!mServiceAttached)        
        {
            setupService();
        } //End block
        assertNotNull(mService);
        if(!mServiceCreated)        
        {
            mService.onCreate();
            mServiceCreated = true;
        } //End block
        mService.onStartCommand(intent, 0, mServiceId);
        mServiceStarted = true;
        // ---------- Original Method ----------
        //if (!mServiceAttached) {
            //setupService();
        //}
        //assertNotNull(mService);
        //if (!mServiceCreated) {
            //mService.onCreate();
            //mServiceCreated = true;
        //}
        //mService.onStartCommand(intent, 0, mServiceId);
        //mServiceStarted = true;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.877 -0400", hash_original_method = "9243E940E5DBFB4305A53445C0DB5EAA", hash_generated_method = "926D922E77C563BA323DD662C3095FBD")
    protected IBinder bindService(Intent intent) {
        if(!mServiceAttached)        
        {
            setupService();
        } //End block
        assertNotNull(mService);
        if(!mServiceCreated)        
        {
            mService.onCreate();
            mServiceCreated = true;
        } //End block
        mServiceIntent = intent.cloneFilter();
        IBinder result = mService.onBind(intent);
        mServiceBound = true;
IBinder varDC838461EE2FA0CA4C9BBB70A15456B0_1209587087 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1209587087.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1209587087;
        // ---------- Original Method ----------
        //if (!mServiceAttached) {
            //setupService();
        //}
        //assertNotNull(mService);
        //if (!mServiceCreated) {
            //mService.onCreate();
            //mServiceCreated = true;
        //}
        //mServiceIntent = intent.cloneFilter();
        //IBinder result = mService.onBind(intent);
        //mServiceBound = true;
        //return result;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.878 -0400", hash_original_method = "7A2B90C413225D42DADFD4030FEDB024", hash_generated_method = "FE7C79667A2B4983986594DE8F221D5F")
    protected void shutdownService() {
        if(mServiceStarted)        
        {
            mService.stopSelf();
            mServiceStarted = false;
        } //End block
        else
        if(mServiceBound)        
        {
            mService.onUnbind(mServiceIntent);
            mServiceBound = false;
        } //End block
        if(mServiceCreated)        
        {
            mService.onDestroy();
        } //End block
        // ---------- Original Method ----------
        //if (mServiceStarted) {
            //mService.stopSelf();
            //mServiceStarted = false;
        //} else if (mServiceBound) {
            //mService.onUnbind(mServiceIntent);
            //mServiceBound = false;
        //}
        //if (mServiceCreated) {
            //mService.onDestroy();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.879 -0400", hash_original_method = "87D1D2444773B04D6FA2D1565794C0F5", hash_generated_method = "40ECAA34A3B22375EB9D9CA4239B98D3")
    @Override
    protected void tearDown() throws Exception {
        shutdownService();
        mService = null;
        scrubClass(ServiceTestCase.class);
        super.tearDown();
        // ---------- Original Method ----------
        //shutdownService();
        //mService = null;
        //scrubClass(ServiceTestCase.class);
        //super.tearDown();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.879 -0400", hash_original_method = "3567B69292EF80C03794348A9036011F", hash_generated_method = "4107DD9EC38CBD3CCF4928F6835C3F78")
    public void setApplication(Application application) {
        mApplication = application;
        // ---------- Original Method ----------
        //mApplication = application;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.880 -0400", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "CB7648B59E6FA5743ED2749B077D1AE6")
    public Application getApplication() {
Application varF254F0ADF054F0318B65674CA3670A5E_1028824635 =         mApplication;
        varF254F0ADF054F0318B65674CA3670A5E_1028824635.addTaint(taint);
        return varF254F0ADF054F0318B65674CA3670A5E_1028824635;
        // ---------- Original Method ----------
        //return mApplication;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.880 -0400", hash_original_method = "20F2DC85F18376CDF1A7B2B9DA0C85A8", hash_generated_method = "8863F19988018313A6EF51B701568D3E")
    public Context getSystemContext() {
Context var8C7F00BBFA5D714A8F742FB231BABCE9_328050644 =         mSystemContext;
        var8C7F00BBFA5D714A8F742FB231BABCE9_328050644.addTaint(taint);
        return var8C7F00BBFA5D714A8F742FB231BABCE9_328050644;
        // ---------- Original Method ----------
        //return mSystemContext;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.881 -0400", hash_original_method = "109B8E506FBC3D7FBEA1E1B742558961", hash_generated_method = "9C1732A8190F999B54BCFE6180E9C491")
    public void testServiceTestCaseSetUpProperly() throws Exception {
        setupService();
        assertNotNull("service should be launched successfully", mService);
        // ---------- Original Method ----------
        //setupService();
        //assertNotNull("service should be launched successfully", mService);
    }

    
}

