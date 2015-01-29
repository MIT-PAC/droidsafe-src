/*
 * Copyright (C) 2014 The Android Open Source Project
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

package android.support.v4.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * Abstract service to receive side channel notifications sent from
 * {@link android.support.v4.app.NotificationManagerCompat}.
 *
 * <p>To receive side channel notifications, extend this service and register it in your
 * android manifest with an intent filter for the BIND_NOTIFICATION_SIDE_CHANNEL action.
 * Note: you must also have an enabled
 * {@link android.service.notification.NotificationListenerService} within your package.
 *
 * <p>Example AndroidManifest.xml addition:
 * <pre>
 * &lt;service android:name="com.example.NotificationSideChannelService"&gt;
 *     &lt;intent-filter&gt;
 *         &lt;action android:name="android.support.BIND_NOTIFICATION_SIDE_CHANNEL" /&gt;
 *     &lt;/intent-filter&gt;
 * &lt;/service&gt;</pre>
 *
 */
public abstract class NotificationCompatSideChannelService extends Service {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:05.749 -0400", hash_original_field = "FFAFE20ECA0F6940DC25FF5EA3B6DD09", hash_generated_field = "2957067DBFDE5010FCFAEE7D1EEA92B1")

    private static final int BUILD_VERSION_CODE_KITKAT_WATCH = 20;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:05.753 -0400", hash_original_method = "30B5C7FD48A2E87EEB1EBC7AE504D91C", hash_generated_method = "DA3490AFE32EB994EFABAA4E14A2FA4A")
    
@Override
    public IBinder onBind(Intent intent) {
        if (intent.getAction().equals(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL)) {
            // Group support is the only current reason to use side channel,
            // so disallow clients to bind for side channel on devices past KITKAT_WATCH for now.
            if (Build.VERSION.SDK_INT >= BUILD_VERSION_CODE_KITKAT_WATCH) {
                return null;
            }
            return new NotificationSideChannelStub();
        }
        return null;
    }

    /**
     * Handle a side-channeled notification being posted.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:05.756 -0400", hash_original_method = "B0435BE0D609CA0D1FCA41B8E4C0D8EA", hash_generated_method = "625A200D6E3C6EC58D051D00D027CCED")
    
public abstract void notify(String packageName, int id, String tag, Notification notification);

    /**
     * Handle a side-channelled notification being cancelled.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:05.759 -0400", hash_original_method = "A967718393CE3E50ABEEE5FF29065FA0", hash_generated_method = "C0C9E78AA4578EF08D0E1FE32AB9161E")
    
public abstract void cancel(String packageName, int id, String tag);

    /**
     * Handle the side-channelled cancelling of all notifications for a package.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:05.762 -0400", hash_original_method = "8A34D2AED4D5E6FB780FB102A64F2A6B", hash_generated_method = "146B112961C39D62F039276FD42DCAAE")
    
public abstract void cancelAll(String packageName);

    private class NotificationSideChannelStub extends INotificationSideChannel.Stub {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void notify(String packageName, int id, String tag, Notification notification)
                throws RemoteException {
            checkPermission(getCallingUid(), packageName);
            long idToken = clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.notify(packageName, id, tag, notification);
            } finally {
                restoreCallingIdentity(idToken);
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void cancel(String packageName, int id, String tag) throws RemoteException {
            checkPermission(getCallingUid(), packageName);
            long idToken = clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.cancel(packageName, id, tag);
            } finally {
                restoreCallingIdentity(idToken);
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void cancelAll(String packageName) {
            checkPermission(getCallingUid(), packageName);
            long idToken = clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.cancelAll(packageName);
            } finally {
                restoreCallingIdentity(idToken);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:05.790 -0400", hash_original_method = "4D92E5835C399BAF3643C689E7C16577", hash_generated_method = "B3F78F7D87D5FB4E74E324896C6C821B")
    
private void checkPermission(int callingUid, String packageName) {
        for (String validPackage : getPackageManager().getPackagesForUid(callingUid)) {
            if (validPackage.equals(packageName)) {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + callingUid
                + " is not authorized for package " + packageName);
    }
}
