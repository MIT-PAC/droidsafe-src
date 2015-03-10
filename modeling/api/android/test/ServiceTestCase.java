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


package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Random;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.test.mock.MockApplication;





public abstract class ServiceTestCase<T extends Service> extends AndroidTestCase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.719 -0500", hash_original_field = "637B9F6ABC3AC96EB3EB7681C795A33D", hash_generated_field = "637B9F6ABC3AC96EB3EB7681C795A33D")


    Class<T> mServiceClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.721 -0500", hash_original_field = "A498D7B6B951074CC260EAF09122A9CD", hash_generated_field = "F1477828250C5BEBE602BC5EA1713A2E")


    private Context mSystemContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.723 -0500", hash_original_field = "218A10E2C368F2E85F83EE2065C292CD", hash_generated_field = "53FA3553B85F7414D1C5F2C302FDEBF9")

    private Application mApplication;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.728 -0500", hash_original_field = "D5DD3370A40719D6C8921E040B521347", hash_generated_field = "F3295512C5A15A7E1E4BE8A38300F691")


    private T mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.730 -0500", hash_original_field = "1AAEAF813350788F55F485D0196E29B9", hash_generated_field = "BDC91FBBED9ED66C312CB510184D92A5")

    private boolean mServiceAttached = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.732 -0500", hash_original_field = "71B93BCFC2F9BB624E0DA713D6B31FD1", hash_generated_field = "F0F3484542642FB72C170742CF175167")

    private boolean mServiceCreated = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.734 -0500", hash_original_field = "34817A7D2152C87472A77F06846AFCA5", hash_generated_field = "6B66D148B1E37EBE59F99F9D0E5A992C")

    private boolean mServiceStarted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.736 -0500", hash_original_field = "C80AF23627BF972C19DB697F2D1ACDAC", hash_generated_field = "912B0BEA2990419429548895171B2F0A")

    private boolean mServiceBound = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.739 -0500", hash_original_field = "2B79ADB4AEA0A332867DAEC28EC65830", hash_generated_field = "05A1A5A41A6AA7DC7317478E19978B0B")

    private Intent mServiceIntent = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.741 -0500", hash_original_field = "D402B19E1F66ACD65561917C597DE874", hash_generated_field = "A4722B4D674B9B46CA8EAF04E1307521")

    private int mServiceId;

    /**
     * Constructor
     * @param serviceClass The type of the service under test.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.726 -0500", hash_original_method = "1F3B37EA8E1B8B1054B69DFECCE45A51", hash_generated_method = "0292640FE4A888F14DF5A3C2F07067F7")
    
public ServiceTestCase(Class<T> serviceClass) {
        mServiceClass = serviceClass;
    }

    /**
     * @return An instance of the service under test. This instance is created automatically when
     * a test calls {@link #startService} or {@link #bindService}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.743 -0500", hash_original_method = "E1B67BA0E23B118C6146D406450E84BD", hash_generated_method = "D2BE854C197539A382A491CCD9CB443B")
    
public T getService() {
        return mService;
    }

    /**
     * Gets the current system context and stores it.
     *
     * Extend this method to do your own test initialization. If you do so, you
     * must call <code>super.setUp()</code> as the first statement in your override. The method is
     * called before each test method is executed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.745 -0500", hash_original_method = "268090C8258F440561CAD8495BE839CE", hash_generated_method = "6D0C77DF5834722E9A6B7123388BBBB7")
    
@Override
    protected void setUp() throws Exception {
        super.setUp();

        // get the real context, before the individual tests have a chance to muck with it
        mSystemContext = getContext();

    }

    /**
     * Creates the service under test and attaches all injected dependencies
     * (Context, Application) to it.  This is called automatically by {@link #startService} or
     * by {@link #bindService}.
     * If you need to call {@link AndroidTestCase#setContext(Context) setContext()} or
     * {@link #setApplication setApplication()}, do so before calling this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.748 -0500", hash_original_method = "896172C51C066B5F037A8F2C24487B23", hash_generated_method = "9BB432343D030E0D556118988BEB204F")
    
protected void setupService() {
        mService = null;
        try {
            mService = mServiceClass.newInstance();
        } catch (Exception e) {
            assertNotNull(mService);
        }
        if (getApplication() == null) {
            setApplication(new MockApplication());
        }
        mService.attach(
                getContext(),
                null,               // ActivityThread not actually used in Service
                mServiceClass.getName(),
                null,               // token not needed when not talking with the activity manager
                getApplication(),
                null                // mocked services don't talk with the activity manager
                );

        assertNotNull(mService);

        mServiceId = new Random().nextInt();
        mServiceAttached = true;
    }

    /**
     * Starts the service under test, in the same way as if it were started by
     * {@link android.content.Context#startService(Intent) Context.startService(Intent)} with
     * an {@link android.content.Intent} that identifies a service.
     * If you use this method to start the service, it is automatically stopped by
     * {@link #tearDown}.
     *
     * @param intent An Intent that identifies a service, of the same form as the Intent passed to
     * {@link android.content.Context#startService(Intent) Context.startService(Intent)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.751 -0500", hash_original_method = "21E4CB4FCD74533F799D23D47E90F5B7", hash_generated_method = "8217A23948FCB7AE9E6211E346B434AD")
    
protected void startService(Intent intent) {
        if (!mServiceAttached) {
            setupService();
        }
        assertNotNull(mService);

        if (!mServiceCreated) {
            mService.onCreate();
            mServiceCreated = true;
        }
        mService.onStartCommand(intent, 0, mServiceId);

        mServiceStarted = true;
    }

    /**
     * <p>
     *      Starts the service under test, in the same way as if it were started by
     *      {@link android.content.Context#bindService(Intent, ServiceConnection, int)
     *      Context.bindService(Intent, ServiceConnection, flags)} with an
     *      {@link android.content.Intent} that identifies a service.
     * </p>
     * <p>
     *      Notice that the parameters are different. You do not provide a
     *      {@link android.content.ServiceConnection} object or the flags parameter. Instead,
     *      you only provide the Intent. The method returns an object whose type is a
     *      subclass of {@link android.os.IBinder}, or null if the method fails. An IBinder
     *      object refers to a communication channel between the application and
     *      the service. The flag is assumed to be {@link android.content.Context#BIND_AUTO_CREATE}.
     * </p>
     * <p>
     *      See <a href="{@docRoot}guide/developing/tools/aidl.html">Designing a Remote Interface
     *      Using AIDL</a> for more information about the communication channel object returned
     *      by this method.
     * </p>
     * Note:  To be able to use bindService in a test, the service must implement getService()
     * method. An example of this is in the ApiDemos sample application, in the
     * LocalService demo.
     *
     * @param intent An Intent object of the form expected by
     * {@link android.content.Context#bindService}.
     *
     * @return An object whose type is a subclass of IBinder, for making further calls into
     * the service.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.753 -0500", hash_original_method = "9243E940E5DBFB4305A53445C0DB5EAA", hash_generated_method = "A60C0B913FB7CC29AD6CCCB238C387D8")
    
protected IBinder bindService(Intent intent) {
        if (!mServiceAttached) {
            setupService();
        }
        assertNotNull(mService);

        if (!mServiceCreated) {
            mService.onCreate();
            mServiceCreated = true;
        }
        // no extras are expected by unbind
        mServiceIntent = intent.cloneFilter();
        IBinder result = mService.onBind(intent);

        mServiceBound = true;
        return result;
    }

    /**
     * Makes the necessary calls to stop (or unbind) the service under test, and
     * calls onDestroy().  Ordinarily this is called automatically (by {@link #tearDown}, but
     * you can call it directly from your test in order to check for proper shutdown behavior.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.756 -0500", hash_original_method = "7A2B90C413225D42DADFD4030FEDB024", hash_generated_method = "BF624E7A4C800DFA5052B7CB78E42026")
    
protected void shutdownService() {
        if (mServiceStarted) {
            mService.stopSelf();
            mServiceStarted = false;
        } else if (mServiceBound) {
            mService.onUnbind(mServiceIntent);
            mServiceBound = false;
        }
        if (mServiceCreated) {
            mService.onDestroy();
        }
    }

    /**
     * <p>
     *      Shuts down the service under test.  Ensures all resources are cleaned up and
     *      garbage collected before moving on to the next test. This method is called after each
     *      test method.
     * </p>
     * <p>
     *      Subclasses that override this method must call <code>super.tearDown()</code> as their
     *      last statement.
     * </p>
     *
     * @throws Exception
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.758 -0500", hash_original_method = "87D1D2444773B04D6FA2D1565794C0F5", hash_generated_method = "2B5FD71D725A8C7BA746FC6FE649BBBD")
    
@Override
    protected void tearDown() throws Exception {
        shutdownService();
        mService = null;

        // Scrub out members - protects against memory leaks in the case where someone
        // creates a non-static inner class (thus referencing the test case) and gives it to
        // someone else to hold onto
        scrubClass(ServiceTestCase.class);

        super.tearDown();
    }

    /**
     * Sets the application that is used during the test.  If you do not call this method,
     * a new {@link android.test.mock.MockApplication MockApplication} object is used.
     *
     * @param application The Application object that is used by the service under test.
     *
     * @see #getApplication()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.760 -0500", hash_original_method = "3567B69292EF80C03794348A9036011F", hash_generated_method = "64B4492B599B80D70C5BD23FB18CE2CA")
    
public void setApplication(Application application) {
        mApplication = application;
    }

    /**
     * Returns the Application object in use by the service under test.
     *
     * @return The application object.
     *
     * @see #setApplication
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.762 -0500", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "AA8B5B758D7C79A3ABAA1916A3765C04")
    
public Application getApplication() {
        return mApplication;
    }

    /**
     * Returns the real system context that is saved by {@link #setUp()}. Use it to create
     * mock or other types of context objects for the service under test.
     *
     * @return A normal system context.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.764 -0500", hash_original_method = "20F2DC85F18376CDF1A7B2B9DA0C85A8", hash_generated_method = "EDE6FE1DA7D7647283DD2EFD3401C1D3")
    
public Context getSystemContext() {
        return mSystemContext;
    }

    /**
     * Tests that {@link #setupService()} runs correctly and issues an
     * {@link junit.framework.Assert#assertNotNull(String, Object)} if it does.
     * You can override this test method if you wish.
     *
     * @throws Exception
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.766 -0500", hash_original_method = "109B8E506FBC3D7FBEA1E1B742558961", hash_generated_method = "038CE595F8A5B99AF8DF5423ED353DE8")
    
public void testServiceTestCaseSetUpProperly() throws Exception {
        setupService();
        assertNotNull("service should be launched successfully", mService);
    }

    
}

