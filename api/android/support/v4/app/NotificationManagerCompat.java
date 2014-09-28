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
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Compatibility library for NotificationManager with fallbacks for older platforms.
 *
 * <p>To use this class, call the static function {@link #from} to get a
 * {@link NotificationManagerCompat} object, and then call one of its
 * methods to post or cancel notifications.
 */
public class NotificationManagerCompat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:46.949 -0400", hash_original_field = "A7E645954395EF8C3F7D257AF63BADCC", hash_generated_field = "565A050FE13B5DE2D170FEFE90DEADA6")

    private static final String TAG = "NotifManCompat";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:46.952 -0400", hash_original_field = "A76D7FE4D6D9EA4ACA89CF7B8F6B0135", hash_generated_field = "DBA64FC476DA993E004BCD3D6706642B")

    public static final String EXTRA_USE_SIDE_CHANNEL =
            NotificationCompatJellybean.EXTRA_USE_SIDE_CHANNEL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:46.956 -0400", hash_original_field = "2472407C08D1FD2BA080058E14F52529", hash_generated_field = "A5F0BBAC5FE794ACC50A1A47A7CFA213")

    public static final String ACTION_BIND_SIDE_CHANNEL =
            "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:46.960 -0400", hash_original_field = "7BB6601974240CD09DE42EA23F3FC0CF", hash_generated_field = "59142709BE9DEEDF2B58E38D304C2DEE")

    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:46.963 -0400", hash_original_field = "C9F57AC72A35277EB906AF799BE3A451", hash_generated_field = "05D50102A18B5D2FCB3DB99D4BCEA0C8")

    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:46.967 -0400", hash_original_field = "EF6DFC6D8EDC7D39BDEC53AC804A5999", hash_generated_field = "CF634FCBB49C56190CAABABA3C66EE15")

    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS =
            "enabled_notification_listeners";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:46.971 -0400", hash_original_field = "6421064397ABA9202755D94A156D34E4", hash_generated_field = "98A01AEC9B43F5DAC35FD5E8B4BD7D78")

    private static  int SIDE_CHANNEL_BIND_FLAGS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:46.975 -0400", hash_original_field = "EFB1DC5594BAF407D46AD697D228253F", hash_generated_field = "7E96D12BFEAA22692F405C2067D6A8C4")

    private static final Object sEnabledNotificationListenersLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:46.978 -0400", hash_original_field = "3F703A2D9CBCBA26F096A4CCB84F7F3C", hash_generated_field = "1771A46A9437DDF77E3135FB886427E3")

    private static String sEnabledNotificationListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:46.983 -0400", hash_original_field = "0A79A6369A97B3BE56ECA03E2D592500", hash_generated_field = "6B1BE911170F24AE789F08B77D3E5173")

    private static Set<String> sEnabledNotificationListenerPackages = new HashSet<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:46.994 -0400", hash_original_field = "3892ABA92B7F95295E8CFDAE8B79791E", hash_generated_field = "BDCA99E42BC506D141E07BE230771AE3")

    private static final Object sLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:46.997 -0400", hash_original_field = "7165CED62FEFBBB2D36FF3E4B5B2716D", hash_generated_field = "BD5722BCC168AC74A488BEBFB59B5F7D")

    private static SideChannelManager sSideChannelManager;

    /** Get a {@link NotificationManagerCompat} instance for a provided context. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:47.001 -0400", hash_original_method = "889863B72F077B41B4B9226521D5EF3F", hash_generated_method = "0CC07EBA2CBD4E4D8C93CE1890110594")
    
public static NotificationManagerCompat from(Context context) {
        return new NotificationManagerCompat(context);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:47.009 -0400", hash_original_field = "DC1A5D74583665DC62A1881BB90D1EF8", hash_generated_field = "755362C593EC4302394ABAC90C69DA8C")

    private static  Impl IMPL;

    /**
     * Get the set of packages that have an enabled notification listener component within them.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:47.073 -0400", hash_original_method = "45DB7DBDF2A05EC028D50CB51B820256", hash_generated_method = "13790203ECE193A296CAB0EA198F77F1")
        
public static Set<String> getEnabledListenerPackages(Context context) {
        final String enabledNotificationListeners = Settings.Secure.getString(
                context.getContentResolver(),
                SETTING_ENABLED_NOTIFICATION_LISTENERS);
        // Parse the string again if it is different from the last time this method was called.
        if (enabledNotificationListeners != null
                && !enabledNotificationListeners.equals(sEnabledNotificationListeners)) {
            final String[] components = enabledNotificationListeners.split(":");
            Set<String> packageNames = new HashSet<String>(components.length);
            for (String component : components) {
                ComponentName componentName = ComponentName.unflattenFromString(component);
                if (componentName != null) {
                    packageNames.add(componentName.getPackageName());
                }
            }
            synchronized (sEnabledNotificationListenersLock) {
                sEnabledNotificationListenerPackages = packageNames;
                sEnabledNotificationListeners = enabledNotificationListeners;
            }
        }
        return sEnabledNotificationListenerPackages;
    }

    /**
     * Returns true if this notification should use the side channel for delivery.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:47.076 -0400", hash_original_method = "197650DC8E6335EE8245088FF5A63760", hash_generated_method = "C126D1B8A5EA545F717AB5908A31637B")
        
private static boolean useSideChannelForNotification(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:46.986 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;

    interface Impl {
        void cancelNotification(NotificationManager notificationManager, String tag, int id);

        void postNotification(NotificationManager notificationManager, String tag, int id,
                Notification notification);

        int getSideChannelBindFlags();
    }

    static class ImplBase implements Impl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void cancelNotification(NotificationManager notificationManager, String tag,
                int id) {
            notificationManager.cancel(id);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void postNotification(NotificationManager notificationManager, String tag, int id,
                Notification notification) {
            notificationManager.notify(id, notification);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getSideChannelBindFlags() {
            return Service.BIND_AUTO_CREATE;
        }
    }

    static class ImplEclair extends ImplBase {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void cancelNotification(NotificationManager notificationManager, String tag,
                int id) {
            NotificationManagerCompatEclair.cancelNotification(notificationManager, tag, id);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void postNotification(NotificationManager notificationManager, String tag, int id,
                Notification notification) {
            NotificationManagerCompatEclair.postNotification(notificationManager, tag, id,
                    notification);
        }
    }

    static class ImplIceCreamSandwich extends ImplEclair {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getSideChannelBindFlags() {
            //return NotificationManagerCompatIceCreamSandwich.SIDE_CHANNEL_BIND_FLAGS;
        	return DSUtils.FAKE_INT;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new ImplIceCreamSandwich();
        } else if (Build.VERSION.SDK_INT >= 5) {
            IMPL = new ImplEclair();
        } else {
            IMPL = new ImplBase();
        }
        SIDE_CHANNEL_BIND_FLAGS = IMPL.getSideChannelBindFlags();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:46.989 -0400", hash_original_field = "0BD477AD3E0B44CE9C37EC52E33B461A", hash_generated_field = "5CFEE9A480A1FC419A0F05AC148E7A83")

    private  NotificationManager mNotificationManager;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:47.005 -0400", hash_original_method = "2B2CB55D4956713DDE026CD234DC49B7", hash_generated_method = "B23678FC823498D90AD60B819BE85FF0")
    
private NotificationManagerCompat(Context context) {
        mContext = context;
        mNotificationManager = (NotificationManager) mContext.getSystemService(
                Context.NOTIFICATION_SERVICE);
    }

    /**
     * Cancel a previously shown notification.
     * @param id the ID of the notification
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:47.053 -0400", hash_original_method = "C3E2CA3977B6A0DFE40EA0B5D969CEEE", hash_generated_method = "90EF31815973B3B19C436849AC0958EC")
        
public void cancel(int id) {
        cancel(null, id);
    }

    /**
     * Cancel a previously shown notification.
     * @param tag the string identifier of the notification.
     * @param id the ID of the notification
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:47.057 -0400", hash_original_method = "4AF00848EDFC1C3635F203BE01DB98DF", hash_generated_method = "B63F8779E296785CD652DADD25569DF1")
        
public void cancel(String tag, int id) {
        IMPL.cancelNotification(mNotificationManager, tag, id);
        pushSideChannelQueue(new CancelTask(mContext.getPackageName(), id, tag));
    }

    /** Cancel all previously shown notifications. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:47.061 -0400", hash_original_method = "75EA612F9AC01BEB8382121B5920E6C2", hash_generated_method = "761E25F3C180CB9C203BEF2E118C0B90")
        
public void cancelAll() {
        mNotificationManager.cancelAll();
        pushSideChannelQueue(new CancelTask(mContext.getPackageName()));
    }

    /**
     * Post a notification to be shown in the status bar, stream, etc.
     * @param id the ID of the notification
     * @param notification the notification to post to the system
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:47.064 -0400", hash_original_method = "8A4CA4E7E43847BF1836AE50422D1EC2", hash_generated_method = "11BB02842F74EFA0B750E0E2DC061F0E")
        
public void notify(int id, Notification notification) {
        notify(null, id, notification);
    }

    /**
     * Post a notification to be shown in the status bar, stream, etc.
     * @param tag the string identifier for a notification. Can be {@code null}.
     * @param id the ID of the notification. The pair (tag, id) must be unique within your app.
     * @param notification the notification to post to the system
    */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:47.068 -0400", hash_original_method = "F807917222EF5728719EE520E156F9C4", hash_generated_method = "FCC28191678B6305D90A1C10400A5051")
        
public void notify(String tag, int id, Notification notification) {
        if (useSideChannelForNotification(notification)) {
            pushSideChannelQueue(new NotifyTask(mContext.getPackageName(), id, tag, notification));
        } else {
            IMPL.postNotification(mNotificationManager, tag, id, notification);
        }
    }

    /**
     * Push a notification task for distribution to notification side channels.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:47.080 -0400", hash_original_method = "B0DAD8AFD38CB377D0B22A22CF6DB97D", hash_generated_method = "C11D3E77B2E7130F5CEDF7D989A525A2")
        
private void pushSideChannelQueue(Task task) {
        synchronized (sLock) {
            if (sSideChannelManager == null) {
                sSideChannelManager = new SideChannelManager(mContext.getApplicationContext());
            }
        }
        sSideChannelManager.queueTask(task);
    }

    /**
     * Helper class to manage a queue of pending tasks to send to notification side channel
     * listeners.
     */
    private static class SideChannelManager implements Handler.Callback, ServiceConnection {
        private static final int MSG_QUEUE_TASK = 0;
        private static final int MSG_SERVICE_CONNECTED = 1;
        private static final int MSG_SERVICE_DISCONNECTED = 2;
        private static final int MSG_RETRY_LISTENER_QUEUE = 3;

        private static final String KEY_BINDER = "binder";

        private final Context mContext;
        private final HandlerThread mHandlerThread;
        private final Handler mHandler;
        private final Map<ComponentName, ListenerRecord> mRecordMap =
                new HashMap<ComponentName, ListenerRecord>();
        private Set<String> mCachedEnabledPackages = new HashSet<String>();

        public SideChannelManager(Context context) {
            mContext = context;
            mHandlerThread = new HandlerThread("NotificationManagerCompat");
            mHandlerThread.start();
            mHandler = new Handler(mHandlerThread.getLooper(), this);
        }

        /**
         * Queue a new task to be sent to all listeners. This function can be called
         * from any thread.
         */
        @DSSafe(DSCat.SAFE_LIST)
        public void queueTask(Task task) {
            mHandler.obtainMessage(MSG_QUEUE_TASK, task).sendToTarget();
        }

        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_QUEUE_TASK:
                    handleQueueTask((Task) msg.obj);
                    return true;
                case MSG_SERVICE_CONNECTED:
                    ServiceConnectedEvent event = (ServiceConnectedEvent) msg.obj;
                    handleServiceConnected(event.componentName, event.iBinder);
                    return true;
                case MSG_SERVICE_DISCONNECTED:
                    handleServiceDisconnected((ComponentName) msg.obj);
                    return true;
                case MSG_RETRY_LISTENER_QUEUE:
                    handleRetryListenerQueue((ComponentName) msg.obj);
                    return true;
            }
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        private void handleQueueTask(Task task) {
            updateListenerMap();
            for (ListenerRecord record : mRecordMap.values()) {
                record.taskQueue.add(task);
                processListenerQueue(record);
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        private void handleServiceConnected(ComponentName componentName, IBinder iBinder) {
            ListenerRecord record = mRecordMap.get(componentName);
            if (record != null) {
                record.service = INotificationSideChannel.Stub.asInterface(iBinder);
                record.retryCount = 0;
                processListenerQueue(record);
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        private void handleServiceDisconnected(ComponentName componentName) {
            ListenerRecord record = mRecordMap.get(componentName);
            if (record != null) {
                ensureServiceUnbound(record);
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        private void handleRetryListenerQueue(ComponentName componentName) {
            ListenerRecord record = mRecordMap.get(componentName);
            if (record != null) {
                processListenerQueue(record);
            }
        }

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                Log.d(TAG, "Connected to service " + componentName);
            }
            mHandler.obtainMessage(MSG_SERVICE_CONNECTED,
                    new ServiceConnectedEvent(componentName, iBinder))
                    .sendToTarget();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                Log.d(TAG, "Disconnected from service " + componentName);
            }
            mHandler.obtainMessage(MSG_SERVICE_DISCONNECTED, componentName).sendToTarget();
        }

        /**
         * Check the current list of enabled listener packages and update the records map
         * accordingly.
         */
        @DSSafe(DSCat.SAFE_LIST)
        private void updateListenerMap() {
            Set<String> enabledPackages = getEnabledListenerPackages(mContext);
            if (enabledPackages.equals(mCachedEnabledPackages)) {
                // Short-circuit when the list of enabled packages has not changed.
                return;
            }
            mCachedEnabledPackages = enabledPackages;
            List<ResolveInfo> resolveInfos = mContext.getPackageManager().queryIntentServices(
                    new Intent().setAction(ACTION_BIND_SIDE_CHANNEL), PackageManager.GET_SERVICES);
            Set<ComponentName> enabledComponents = new HashSet<ComponentName>();
            for (ResolveInfo resolveInfo : resolveInfos) {
                if (!enabledPackages.contains(resolveInfo.serviceInfo.packageName)) {
                    continue;
                }
                ComponentName componentName = new ComponentName(
                        resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                if (resolveInfo.serviceInfo.permission != null) {
                    Log.w(TAG, "Permission present on component " + componentName
                            + ", not adding listener record.");
                    continue;
                }
                enabledComponents.add(componentName);
            }
            // Ensure all enabled components have a record in the listener map.
            for (ComponentName componentName : enabledComponents) {
                if (!mRecordMap.containsKey(componentName)) {
                    if (Log.isLoggable(TAG, Log.DEBUG)) {
                        Log.d(TAG, "Adding listener record for " + componentName);
                    }
                    mRecordMap.put(componentName, new ListenerRecord(componentName));
                }
            }
            // Remove listener records that are no longer for enabled components.
            Iterator<Map.Entry<ComponentName, ListenerRecord>> it =
                    mRecordMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, ListenerRecord> entry = it.next();
                if (!enabledComponents.contains(entry.getKey())) {
                    if (Log.isLoggable(TAG, Log.DEBUG)) {
                        Log.d(TAG, "Removing listener record for " + entry.getKey());
                    }
                    ensureServiceUnbound(entry.getValue());
                    it.remove();
                }
            }
        }

        /**
         * Ensure we are already attempting to bind to a service, or start a new binding if not.
         * @return Whether the service bind attempt was successful.
         */
        @DSSafe(DSCat.SAFE_LIST)
        private boolean ensureServiceBound(ListenerRecord record) {
            if (record.bound) {
                return true;
            }
            Intent intent = new Intent(ACTION_BIND_SIDE_CHANNEL).setComponent(record.componentName);
            record.bound = mContext.bindService(intent, this, SIDE_CHANNEL_BIND_FLAGS);
            if (record.bound) {
                record.retryCount = 0;
            } else {
                Log.w(TAG, "Unable to bind to listener " + record.componentName);
                mContext.unbindService(this);
            }
            return record.bound;
        }

        /**
         * Ensure we have unbound from a service.
         */
        @DSSafe(DSCat.SAFE_LIST)
        private void ensureServiceUnbound(ListenerRecord record) {
            if (record.bound) {
                mContext.unbindService(this);
                record.bound = false;
            }
            record.service = null;
        }

        /**
         * Schedule a delayed retry to communicate with a listener service.
         * After a maximum number of attempts (with exponential back-off), start
         * dropping pending tasks for this listener.
         */
        @DSSafe(DSCat.SAFE_LIST)
        private void scheduleListenerRetry(ListenerRecord record) {
            if (mHandler.hasMessages(MSG_RETRY_LISTENER_QUEUE, record.componentName)) {
                return;
            }
            record.retryCount++;
            if (record.retryCount > SIDE_CHANNEL_RETRY_MAX_COUNT) {
                Log.w(TAG, "Giving up on delivering " + record.taskQueue.size() + " tasks to "
                        + record.componentName + " after " + record.retryCount + " retries");
                record.taskQueue.clear();
                return;
            }
            int delayMs = SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS * (1 << (record.retryCount - 1));
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                Log.d(TAG, "Scheduling retry for " + delayMs + " ms");
            }
            Message msg = mHandler.obtainMessage(MSG_RETRY_LISTENER_QUEUE, record.componentName);
            mHandler.sendMessageDelayed(msg, delayMs);
        }

        /**
         * Perform a processing step for a listener. First check the bind state, then attempt
         * to flush the task queue, and if an error is encountered, schedule a retry.
         */
        @DSSafe(DSCat.SAFE_LIST)
        private void processListenerQueue(ListenerRecord record) {
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                Log.d(TAG, "Processing component " + record.componentName + ", "
                        + record.taskQueue.size() + " queued tasks");
            }
            if (record.taskQueue.isEmpty()) {
                return;
            }
            if (!ensureServiceBound(record) || record.service == null) {
                // Ensure bind has started and that a service interface is ready to use.
                scheduleListenerRetry(record);
                return;
            }
            // Attempt to flush all items in the task queue.
            while (true) {
                Task task = record.taskQueue.peek();
                if (task == null) {
                    break;
                }
                try {
                    if (Log.isLoggable(TAG, Log.DEBUG)) {
                        Log.d(TAG, "Sending task " + task);
                    }
                    task.send(record.service);
                    record.taskQueue.remove();
                } catch (DeadObjectException e) {
                    if (Log.isLoggable(TAG, Log.DEBUG)) {
                        Log.d(TAG, "Remote service has died: " + record.componentName);
                    }
                    break;
                } catch (RemoteException e) {
                    Log.w(TAG, "RemoteException communicating with " + record.componentName, e);
                    break;
                }
            }
            if (!record.taskQueue.isEmpty()) {
                // Some tasks were not sent, meaning an error was encountered, schedule a retry.
                scheduleListenerRetry(record);
            }
        }

        /** A per-side-channel-service listener state record */
        private static class ListenerRecord {
            public final ComponentName componentName;
            /** Whether the service is currently bound to. */
            public boolean bound = false;
            /** The service stub provided by onServiceConnected */
            public INotificationSideChannel service;
            /** Queue of pending tasks to send to this listener service */
            public LinkedList<Task> taskQueue = new LinkedList<Task>();
            /** Number of retries attempted while connecting to this listener service */
            public int retryCount = 0;

            public ListenerRecord(ComponentName componentName) {
                this.componentName = componentName;
            }
        }
    }

    private static class ServiceConnectedEvent {
        final ComponentName componentName;
        final IBinder iBinder;

        public ServiceConnectedEvent(ComponentName componentName,
                final IBinder iBinder) {
            this.componentName = componentName;
            this.iBinder = iBinder;
        }
    }

    private interface Task {
        public void send(INotificationSideChannel service) throws RemoteException;
    }

    private static class NotifyTask implements Task {
        final String packageName;
        final int id;
        final String tag;
        final Notification notif;

        public NotifyTask(String packageName, int id, String tag, Notification notif) {
            this.packageName = packageName;
            this.id = id;
            this.tag = tag;
            this.notif = notif;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void send(INotificationSideChannel service) throws RemoteException {
            service.notify(packageName, id, tag, notif);
        }

        @DSSafe(DSCat.SAFE_LIST)
        public String toString() {
            StringBuilder sb = new StringBuilder("NotifyTask[");
            sb.append("packageName:").append(packageName);
            sb.append(", id:").append(id);
            sb.append(", tag:").append(tag);
            sb.append("]");
            return sb.toString();
        }
    }

    private static class CancelTask implements Task {
        final String packageName;
        final int id;
        final String tag;
        final boolean all;

        public CancelTask(String packageName) {
            this.packageName = packageName;
            this.id = 0;
            this.tag = null;
            this.all = true;
        }

        public CancelTask(String packageName, int id, String tag) {
            this.packageName = packageName;
            this.id = id;
            this.tag = tag;
            this.all = false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void send(INotificationSideChannel service) throws RemoteException {
            if (all) {
                service.cancelAll(packageName);
            } else {
                service.cancel(packageName, id, tag);
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        public String toString() {
            StringBuilder sb = new StringBuilder("CancelTask[");
            sb.append("packageName:").append(packageName);
            sb.append(", id:").append(id);
            sb.append(", tag:").append(tag);
            sb.append(", all:").append(all);
            sb.append("]");
            return sb.toString();
        }
    }
}
