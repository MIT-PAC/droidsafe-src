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
 */

package droidsafe.runtime;

import java.util.Random;

import android.app.ContextImpl;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Application;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

/**
 * This class will simulate the android runtime system by making any calls or creating 
 * any globals required.
 * 
 * 
 * @author mgordon
 *
 */
public class DroidSafeAndroidRuntime {
    public static boolean control = new Random().nextBoolean();
    public static int switchControl = new Random().nextInt();
    private static Application mApplication;

    @DSModeled
    /**
     * This method will be called automatically by the droidsafe harness class before all
     * application code.
     * 	
     * @param args
     */
    public static void main() {

    }

    /**
     * create any associated state and call init methods on an activity
     * 
     * call any life cycle events for the activity
     * 
     * @param activity
     */
    @DSModeled(DSC.SPEC)
    public static void modelActivity(android.app.Activity activity) {
        ContextImpl context = new ContextImpl();

        if (mApplication != null)
            activity.setApplication(mApplication);

        Bundle b = new Bundle();
        //onsavedinstancestate(b)
        activity.performCreate(b, context);


        activity.droidsafeOnResume();
        activity.droidsafeOnStop();
        activity.droidsafeOnDestroy();

    }

    @DSModeled(DSC.SPEC)
    public static void modelService(android.app.Service service) {
        if (mApplication != null)
            service.setApplication(mApplication);

    }

    @DSModeled(DSC.SPEC)
    public static void modelContentProvider(android.content.ContentProvider contentProvider) {

    }

    @DSModeled(DSC.SPEC)
    public static void modelBroadCastReceiver(BroadcastReceiver receiver) {
        receiver.onReceive(new ContextImpl(), new Intent());
    }

    @DSModeled(DSC.SPEC)
    public static void modelApplication(android.app.Application app) {
        mApplication = app;

        app.droidsafeOnCreate();
        app.droidsafeOnTerminate();
        app.droidsafeOnEverythingElse();
    }
}
