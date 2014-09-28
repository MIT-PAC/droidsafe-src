/*
 * Copyright (C) 2012 The Android Open Source Project
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

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.List;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import java.util.ArrayList;

class NotificationCompatJellybean {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:04.107 -0400", hash_original_field = "770F0907A3566ED237FB05616B3A8A7C", hash_generated_field = "94F0A15FD2FBFA1C1B34E35336E249E3")

    private Notification.Builder b;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:04.114 -0400", hash_original_method = "07CE56B821409362BD898C927B4E0990", hash_generated_method = "EC60A4873B40895FEA30EDDD950465CA")
    
public NotificationCompatJellybean(Context context, Notification n,
            CharSequence contentTitle, CharSequence contentText, CharSequence contentInfo,
            RemoteViews tickerView, int number,
            PendingIntent contentIntent, PendingIntent fullScreenIntent, Bitmap largeIcon,
            int mProgressMax, int mProgress, boolean mProgressIndeterminate,
            boolean useChronometer, int priority, CharSequence subText) {
        b = new Notification.Builder(context)
            .setWhen(n.when)
            .setSmallIcon(n.icon, n.iconLevel)
            .setContent(n.contentView)
            .setTicker(n.tickerText, tickerView)
            .setSound(n.sound, n.audioStreamType)
            .setVibrate(n.vibrate)
            .setLights(n.ledARGB, n.ledOnMS, n.ledOffMS)
            .setOngoing((n.flags & Notification.FLAG_ONGOING_EVENT) != 0)
            .setOnlyAlertOnce((n.flags & Notification.FLAG_ONLY_ALERT_ONCE) != 0)
            .setAutoCancel((n.flags & Notification.FLAG_AUTO_CANCEL) != 0)
            .setDefaults(n.defaults)
            .setContentTitle(contentTitle)
            .setContentText(contentText)
            .setSubText(subText)
            .setContentInfo(contentInfo)
            .setContentIntent(contentIntent)
            .setDeleteIntent(n.deleteIntent)
            .setFullScreenIntent(fullScreenIntent,
                    (n.flags & Notification.FLAG_HIGH_PRIORITY) != 0)
            .setLargeIcon(largeIcon)
            .setNumber(number)
            .setUsesChronometer(useChronometer)
            .setPriority(priority)
            .setProgress(mProgressMax, mProgress, mProgressIndeterminate);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:04.117 -0400", hash_original_method = "4C17E7823F728145E0568D1CDB29A948", hash_generated_method = "059C61CE13EA34854C1F6A272DB66EF7")
    
public void addAction(int icon, CharSequence title, PendingIntent intent) {
        b.addAction(icon, title, intent);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:04.121 -0400", hash_original_method = "E87D93B533BFC89A38CD8510C2309D41", hash_generated_method = "A724F49A18426174A48E24CA352489BE")
    
public void addBigTextStyle(CharSequence bigContentTitle, boolean useSummary,
            CharSequence summaryText, CharSequence bigText) {
        Notification.BigTextStyle style = new Notification.BigTextStyle(b)
            .setBigContentTitle(bigContentTitle)
            .bigText(bigText);
        if (useSummary) {
            style.setSummaryText(summaryText);
         }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:04.125 -0400", hash_original_method = "5CE24191D1516E926C11E8E2F7A5E791", hash_generated_method = "6B6E3031FA1E246E6F98BAD2E96FFB38")
    
public void addBigPictureStyle(CharSequence bigContentTitle, boolean useSummary,
            CharSequence summaryText, Bitmap bigPicture, Bitmap bigLargeIcon,
            boolean bigLargeIconSet) {
       Notification.BigPictureStyle style = new Notification.BigPictureStyle(b)
           .setBigContentTitle(bigContentTitle)
           .bigPicture(bigPicture);
       if (bigLargeIconSet) {
           style.bigLargeIcon(bigLargeIcon);
       }
        if (useSummary) {
            style.setSummaryText(summaryText);
         }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:04.130 -0400", hash_original_method = "88414C4DAD292B1522CDAC981BD7CF13", hash_generated_method = "80999561E84D9203F20EBF31D6661D0E")
    
public void addInboxStyle(CharSequence bigContentTitle, boolean useSummary,
            CharSequence summaryText, ArrayList<CharSequence> texts) {
        Notification.InboxStyle style = new Notification.InboxStyle(b)
            .setBigContentTitle(bigContentTitle);
        if (useSummary) {
            style.setSummaryText(summaryText);
        }
        for (CharSequence text: texts) {
            style.addLine(text);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:04.132 -0400", hash_original_method = "22F07EE68ECB4916640A17A865D428D6", hash_generated_method = "7071822E23950265C2AC829C8484F133")
    
public Notification build() {
        return b.build();
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.705 -0400", hash_original_field = "3BD1CAB2DC761C785D68CA819637F73F", hash_generated_field = "EFDA2FA0B7FC0BAC3863B35A6AF8D49E")

    private static final String KEY_ACTION_INTENT = "actionIntent";

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.205 -0400", hash_original_method = "44A2E460CECF97CFEF161CE5AE582A37", hash_generated_method = "BE8D22238C3A8179DBB55F06F8A2EE03")
    
public static NotificationCompatBase.Action getAction(Notification notif, int actionIndex,
            NotificationCompatBase.Action.Factory factory,
            RemoteInputCompatBase.RemoteInput.Factory remoteInputFactory) {
        synchronized (sActionsLock) {
            try {
                Object actionObject = getActionObjectsLocked(notif)[actionIndex];
                Bundle actionExtras = null;
                Bundle extras = getExtras(notif);
                if (extras != null) {
                    SparseArray<Bundle> actionExtrasMap = extras.getSparseParcelableArray(
                            EXTRA_ACTION_EXTRAS);
                    if (actionExtrasMap != null) {
                        actionExtras = actionExtrasMap.get(actionIndex);
                    }
                }
                return readAction(factory, remoteInputFactory,
                        sActionIconField.getInt(actionObject),
                        (CharSequence) sActionTitleField.get(actionObject),
                        (PendingIntent) sActionIntentField.get(actionObject),
                        actionExtras);
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Unable to access notification actions", e);
                sActionsAccessFailed = true;
            }
        }
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.298 -0400", hash_original_method = "AC905B63183A8E9B6CBA47567C09F8BD", hash_generated_method = "DACF2CC1694BAD2E4C54D4CB24BAE493")
    
public static boolean isGroupSummary(Notification n) {
        return getExtras(n).getBoolean(EXTRA_GROUP_SUMMARY);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.793 -0400", hash_original_field = "D1F17240791174DF34CED8BC460A1668", hash_generated_field = "39890FFD90B7C452B52BA6173AB3364A")

    private static Field sActionTitleField;

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.183 -0400", hash_original_method = "AB7BCDE6271FB8DF6B7331CFBBF3EC0D", hash_generated_method = "EBB587B4CEC0841FEDB668E4ADD3E065")
    
public static int getActionCount(Notification notif) {
        synchronized (sActionsLock) {
            Object[] actionObjects = getActionObjectsLocked(notif);
            return actionObjects != null ? actionObjects.length : 0;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.785 -0400", hash_original_field = "D45046288346DD427FFA27875C39C03C", hash_generated_field = "51B0B7EBBDBDB146718DD7C06895EB41")

    private static Field sActionIconField;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.677 -0400", hash_original_field = "F5E0843FC38CACBFF9BE8ACB4D1B4E7D", hash_generated_field = "732C7AE543DC44A4F9B8DA3ADCA31771")

    static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.760 -0400", hash_original_field = "2B97EED9841F9EB6C77783E10B1426F9", hash_generated_field = "9535F4DA1414341134E79985F43F8831")

    private static final Object sActionsLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.695 -0400", hash_original_field = "410CF668052940B709102EA21109C732", hash_generated_field = "BD847CBC6BB92993490AA40E882B0719")

    private static final String KEY_TITLE = "title";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.668 -0400", hash_original_field = "5EE96D362E6926D5B82EE0DA591C46CB", hash_generated_field = "9CB263EB954D7529925C0F8E456FF246")

    static final String EXTRA_SORT_KEY = "android.support.sortKey";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.687 -0400", hash_original_field = "A2556DBA3C06BDDE9ACC83B55752A30D", hash_generated_field = "C48B43BDC8F64F6C8AC15699FA810A44")

    private static final String KEY_ICON = "icon";

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.250 -0400", hash_original_method = "A72C48E630DB549A97975A3F5EFA9195", hash_generated_method = "185CEB719AC7A5F9D7304D1B10B30BA1")
    
private static NotificationCompatBase.Action getActionFromBundle(Bundle bundle,
            NotificationCompatBase.Action.Factory actionFactory,
            RemoteInputCompatBase.RemoteInput.Factory remoteInputFactory) {
        return actionFactory.build(
                bundle.getInt(KEY_ICON),
                bundle.getCharSequence(KEY_TITLE),
                bundle.<PendingIntent>getParcelable(KEY_ACTION_INTENT),
                bundle.getBundle(KEY_EXTRAS),
                RemoteInputCompatJellybean.fromBundleArray(
                        BundleUtil.getBundleArrayFromBundle(bundle, KEY_REMOTE_INPUTS),
                        remoteInputFactory));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.659 -0400", hash_original_field = "03E9581896B28797BFB02D2773A77B3E", hash_generated_field = "0768FEC206E473F42FA60B3E91A6E94E")

    static final String EXTRA_GROUP_SUMMARY = "android.support.isGroupSummary";

    /**
     * Get the extras Bundle from a notification using reflection. Extras were present in
     * Jellybean notifications, but the field was private until KitKat.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.146 -0400", hash_original_method = "A2F60EA0D4C8FD07F735098614FDD565", hash_generated_method = "42528D3711F763FD180F8E398E593ACA")
    
public static Bundle getExtras(Notification notif) {
        synchronized (sExtrasLock) {
            if (sExtrasFieldAccessFailed) {
                return null;
            }
            try {
                if (sExtrasField == null) {
                    Field extrasField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(extrasField.getType())) {
                        Log.e(TAG, "Notification.extras field is not of type Bundle");
                        sExtrasFieldAccessFailed = true;
                        return null;
                    }
                    extrasField.setAccessible(true);
                    sExtrasField = extrasField;
                }
                Bundle extras = (Bundle) sExtrasField.get(notif);
                if (extras == null) {
                    extras = new Bundle();
                    sExtrasField.set(notif, extras);
                }
                return extras;
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Unable to access notification extras", e);
            } catch (NoSuchFieldException e) {
                Log.e(TAG, "Unable to access notification extras", e);
            }
            sExtrasFieldAccessFailed = true;
            return null;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.239 -0400", hash_original_method = "261485DE7D74A10E83227A8D5ECB478A", hash_generated_method = "EC256D80F03A7B5916DC0B2725A8ABCA")
    
public static NotificationCompatBase.Action[] getActionsFromParcelableArrayList(
            ArrayList<Parcelable> parcelables,
            NotificationCompatBase.Action.Factory actionFactory,
            RemoteInputCompatBase.RemoteInput.Factory remoteInputFactory) {
        if (parcelables == null) {
            return null;
        }
        NotificationCompatBase.Action[] actions = actionFactory.newArray(parcelables.size());
        for (int i = 0; i < actions.length; i++) {
            actions[i] = getActionFromBundle((Bundle) parcelables.get(i),
                    actionFactory, remoteInputFactory);
        }
        return actions;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.292 -0400", hash_original_method = "390296A93E8D98307E04E44DAE1BE209", hash_generated_method = "26928F1C50682963002CA5EC9286E037")
    
public static String getGroup(Notification n) {
        return getExtras(n).getString(EXTRA_GROUP_KEY);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.733 -0400", hash_original_field = "832107AAE14DE9AA04E2E6562427671B", hash_generated_field = "5F458D4613E3DB418751213DE2B70751")

    private static final Object sExtrasLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.769 -0400", hash_original_field = "25971A8B6EA764EEB002E2DE42769444", hash_generated_field = "3401ADAA0EBD667D442E418571C477C4")

    private static Class<?> sActionClass;

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.098 -0400", hash_original_method = "C5E602F1D3BE8ADC996D5391233EEC50", hash_generated_method = "43E9DA2AA405253A2FF6646B931467B3")
    
public static void addBigPictureStyle(NotificationBuilderWithBuilderAccessor b,
            CharSequence bigContentTitle, boolean useSummary,
            CharSequence summaryText, Bitmap bigPicture, Bitmap bigLargeIcon,
            boolean bigLargeIconSet) {
        Notification.BigPictureStyle style = new Notification.BigPictureStyle(b.getBuilder())
            .setBigContentTitle(bigContentTitle)
            .bigPicture(bigPicture);
        if (bigLargeIconSet) {
            style.bigLargeIcon(bigLargeIcon);
        }
        if (useSummary) {
            style.setSummaryText(summaryText);
        }
    }

    public static class Builder implements NotificationBuilderWithBuilderAccessor,
            NotificationBuilderWithActions {
        private Notification.Builder b;
        private final Bundle mExtras;
        private List<Bundle> mActionExtrasList = new ArrayList<Bundle>();

        public Builder(Context context, Notification n,
                CharSequence contentTitle, CharSequence contentText, CharSequence contentInfo,
                RemoteViews tickerView, int number,
                PendingIntent contentIntent, PendingIntent fullScreenIntent, Bitmap largeIcon,
                int mProgressMax, int mProgress, boolean mProgressIndeterminate,
                boolean useChronometer, int priority, CharSequence subText, boolean localOnly,
                Bundle extras, String groupKey, boolean groupSummary, String sortKey) {
            b = new Notification.Builder(context)
                .setWhen(n.when)
                .setSmallIcon(n.icon, n.iconLevel)
                .setContent(n.contentView)
                .setTicker(n.tickerText, tickerView)
                .setSound(n.sound, n.audioStreamType)
                .setVibrate(n.vibrate)
                .setLights(n.ledARGB, n.ledOnMS, n.ledOffMS)
                .setOngoing((n.flags & Notification.FLAG_ONGOING_EVENT) != 0)
                .setOnlyAlertOnce((n.flags & Notification.FLAG_ONLY_ALERT_ONCE) != 0)
                .setAutoCancel((n.flags & Notification.FLAG_AUTO_CANCEL) != 0)
                .setDefaults(n.defaults)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSubText(subText)
                .setContentInfo(contentInfo)
                .setContentIntent(contentIntent)
                .setDeleteIntent(n.deleteIntent)
                .setFullScreenIntent(fullScreenIntent,
                        (n.flags & Notification.FLAG_HIGH_PRIORITY) != 0)
                .setLargeIcon(largeIcon)
                .setNumber(number)
                .setUsesChronometer(useChronometer)
                .setPriority(priority)
                .setProgress(mProgressMax, mProgress, mProgressIndeterminate);
            mExtras = new Bundle();
            if (extras != null) {
                mExtras.putAll(extras);
            }
            if (localOnly) {
                mExtras.putBoolean(EXTRA_LOCAL_ONLY, true);
            }
            if (groupKey != null) {
                mExtras.putString(EXTRA_GROUP_KEY, groupKey);
                if (groupSummary) {
                    mExtras.putBoolean(EXTRA_GROUP_SUMMARY, true);
                } else {
                    mExtras.putBoolean(EXTRA_USE_SIDE_CHANNEL, true);
                }
            }
            if (sortKey != null) {
                mExtras.putString(EXTRA_SORT_KEY, sortKey);
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void addAction(NotificationCompatBase.Action action) {
            mActionExtrasList.add(writeActionAndGetExtras(b, action));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Notification.Builder getBuilder() {
            return b;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public Notification build() {
            Notification notif = b.build();
            // Merge in developer provided extras, but let the values already set
            // for keys take precedence.
            Bundle extras = getExtras(notif);
            Bundle mergeBundle = new Bundle(mExtras);
            for (String key : mExtras.keySet()) {
                if (extras.containsKey(key)) {
                    mergeBundle.remove(key);
                }
            }
            extras.putAll(mergeBundle);
            SparseArray<Bundle> actionExtrasMap = buildActionExtrasMap(mActionExtrasList);
            if (actionExtrasMap != null) {
                // Add the action extras sparse array if any action was added with extras.
                getExtras(notif).putSparseParcelableArray(EXTRA_ACTION_EXTRAS, actionExtrasMap);
            }
            return notif;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.608 -0400", hash_original_field = "7CC8817C8CECD43422DB2925FF9076EA", hash_generated_field = "22B1D1199D480295599CA61419338E03")

    static final String EXTRA_LOCAL_ONLY = "android.support.localOnly";

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.276 -0400", hash_original_method = "1442CF7E51F5897352BF3C9DEA4654D0", hash_generated_method = "4C7FA016913AF0C3CC7B3873E49D33A1")
    
private static Bundle getBundleForAction(NotificationCompatBase.Action action) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ICON, action.getIcon());
        bundle.putCharSequence(KEY_TITLE, action.getTitle());
        bundle.putParcelable(KEY_ACTION_INTENT, action.getActionIntent());
        bundle.putBundle(KEY_EXTRAS, action.getExtras());
        bundle.putParcelableArray(KEY_REMOTE_INPUTS, RemoteInputCompatJellybean.toBundleArray(
                action.getRemoteInputs()));
        return bundle;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.228 -0400", hash_original_method = "91B6564DC29214497C27B2EC44551D6E", hash_generated_method = "E326AF3E36977BA044F5592766B8988D")
    
private static boolean ensureActionReflectionReadyLocked() {
        if (sActionsAccessFailed) {
            return false;
        }
        try {
            if (sActionsField == null) {
                sActionClass = Class.forName("android.app.Notification$Action");
                sActionIconField = sActionClass.getDeclaredField("icon");
                sActionTitleField = sActionClass.getDeclaredField("title");
                sActionIntentField = sActionClass.getDeclaredField("actionIntent");
                sActionsField = Notification.class.getDeclaredField("actions");
                sActionsField.setAccessible(true);
            }
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "Unable to access notification actions", e);
            sActionsAccessFailed = true;
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "Unable to access notification actions", e);
            sActionsAccessFailed = true;
        }
        return !sActionsAccessFailed;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.596 -0400", hash_original_field = "E549DCE6AD1CD2DB5A86443472026CD6", hash_generated_field = "D85780A2809322F35D9B5832987ED7BD")

    public static final String TAG = "NotificationCompat";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.263 -0400", hash_original_method = "4F997561A85D84EDC8D59BE1EF9FF56F", hash_generated_method = "3C213256C4885145FBD929CE21CF1994")
    
public static ArrayList<Parcelable> getParcelableArrayListForActions(
            NotificationCompatBase.Action[] actions) {
        if (actions == null) {
            return null;
        }
        ArrayList<Parcelable> parcelables = new ArrayList<Parcelable>(actions.length);
        for (NotificationCompatBase.Action action : actions) {
            parcelables.add(getBundleForAction(action));
        }
        return parcelables;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.115 -0400", hash_original_method = "DC3E6123501FA77A3DCF0B1D09D4994D", hash_generated_method = "9B90D7CF8807E34EA7664B7315E83269")
    
public static void addInboxStyle(NotificationBuilderWithBuilderAccessor b,
            CharSequence bigContentTitle, boolean useSummary,
            CharSequence summaryText, ArrayList<CharSequence> texts) {
        Notification.InboxStyle style = new Notification.InboxStyle(b.getBuilder())
            .setBigContentTitle(bigContentTitle);
        if (useSummary) {
            style.setSummaryText(summaryText);
        }
        for (CharSequence text: texts) {
            style.addLine(text);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.306 -0400", hash_original_method = "070DFD51371A926562DA1461340A16B6", hash_generated_method = "31AEB8399E1FB4045219FB4937B1DEC9")
    
public static String getSortKey(Notification n) {
        return getExtras(n).getString(EXTRA_SORT_KEY);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.216 -0400", hash_original_method = "B18FEE410310D887E7186BBE669BDADD", hash_generated_method = "0B1AFF2CF25F78ADC2E47159A4B07813")
    
private static Object[] getActionObjectsLocked(Notification notif) {
        synchronized (sActionsLock) {
            if (!ensureActionReflectionReadyLocked()) {
                return null;
            }
            try {
                return (Object[]) sActionsField.get(notif);
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Unable to access notification actions", e);
                sActionsAccessFailed = true;
                return null;
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.617 -0400", hash_original_field = "72BA6672199BCD8A8C1A989E614A77A0", hash_generated_field = "09178B80547ED936E1AE477985B002A5")

    static final String EXTRA_ACTION_EXTRAS = "android.support.actionExtras";

    /** Return an SparseArray for action extras or null if none was needed. */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.129 -0400", hash_original_method = "D0B01D5997B64F410F6DB437DA16E0A9", hash_generated_method = "02AEE9EC41D576D596F5FD26993DF478")
    
public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> actionExtrasList) {
        SparseArray<Bundle> actionExtrasMap = null;
        for (int i = 0, count = actionExtrasList.size(); i < count; i++) {
            Bundle actionExtras = actionExtrasList.get(i);
            if (actionExtras != null) {
                if (actionExtrasMap == null) {
                    actionExtrasMap = new SparseArray<Bundle>();
                }
                actionExtrasMap.put(i, actionExtras);
            }
        }
        return actionExtrasMap;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.285 -0400", hash_original_method = "33DD0FF7A2F19381E1BBF125A832E960", hash_generated_method = "73F4A6B710B7FB24CA075C221F2F6B92")
    
public static boolean getLocalOnly(Notification notif) {
        return getExtras(notif).getBoolean(EXTRA_LOCAL_ONLY);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.777 -0400", hash_original_field = "DAE31DFDBF6F476DC565119DFEEA187D", hash_generated_field = "C2F2EC570AC21836BA96AAB7F99D3667")

    private static Field sActionsField;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.713 -0400", hash_original_field = "6E6A07D209C9E9928AC39D4A3091225D", hash_generated_field = "1F93A2120CCA045422063006ABD5F6B9")

    private static final String KEY_EXTRAS = "extras";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.811 -0400", hash_original_field = "783310F192AAA7456268DB6A2CA68100", hash_generated_field = "BD75980C03DD07DA8C4D50A773B84379")

    private static boolean sActionsAccessFailed;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.160 -0400", hash_original_method = "BCBA71ADF7F44E250A202070AAF10FD5", hash_generated_method = "2C83FDEA7BC7F75C10D52147F7198CE6")
    
public static NotificationCompatBase.Action readAction(
            NotificationCompatBase.Action.Factory factory,
            RemoteInputCompatBase.RemoteInput.Factory remoteInputFactory, int icon,
            CharSequence title, PendingIntent actionIntent, Bundle extras) {
        RemoteInputCompatBase.RemoteInput[] remoteInputs = null;
        if (extras != null) {
            remoteInputs = RemoteInputCompatJellybean.fromBundleArray(
                    BundleUtil.getBundleArrayFromBundle(extras, EXTRA_REMOTE_INPUTS),
                    remoteInputFactory);
        }
        return factory.build(icon, title, actionIntent, extras, remoteInputs);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.741 -0400", hash_original_field = "00A1B2687E56D610CFDA3A6DA7BFDB8C", hash_generated_field = "30909FF48BB004C4191D4D5F5F533F6F")

    private static Field sExtrasField;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.802 -0400", hash_original_field = "2D3FF29EB2835236ECEA451B4D161C4C", hash_generated_field = "D5AE9877BC2F157DF46561E9E7A3C9AA")

    private static Field sActionIntentField;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.723 -0400", hash_original_field = "F21288E6D18B6C8483DEB88C3C30F8DF", hash_generated_field = "8452DCB18AF1257F7384E4664EC06664")

    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.637 -0400", hash_original_field = "CD6C880238EB1C5937929FE61A700DC6", hash_generated_field = "AA29A84E41E1F1AA66B3D8CC22891E0F")

    static final String EXTRA_GROUP_KEY = "android.support.groupKey";

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.173 -0400", hash_original_method = "1F946ABCBB73FA07566B1C20F2C04B08", hash_generated_method = "9B5297AE79ABB97367E27B6D9FC96218")
    
public static Bundle writeActionAndGetExtras(
            Notification.Builder builder, NotificationCompatBase.Action action) {
        builder.addAction(action.getIcon(), action.getTitle(), action.getActionIntent());
        Bundle actionExtras = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            actionExtras.putParcelableArray(EXTRA_REMOTE_INPUTS,
                    RemoteInputCompatJellybean.toBundleArray(action.getRemoteInputs()));
        }
        return actionExtras;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.749 -0400", hash_original_field = "11C3E6027236DFC69DA5FE1584DE68C3", hash_generated_field = "56AFBBADF4053B8C7292AE5F08BB37CD")

    private static boolean sExtrasFieldAccessFailed;

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:46.077 -0400", hash_original_method = "DAEA3448DD96537F837E7F732D56D054", hash_generated_method = "BF2D571572EA72DC9D4B99597CDED675")
    
public static void addBigTextStyle(NotificationBuilderWithBuilderAccessor b,
            CharSequence bigContentTitle, boolean useSummary,
            CharSequence summaryText, CharSequence bigText) {
        Notification.BigTextStyle style = new Notification.BigTextStyle(b.getBuilder())
            .setBigContentTitle(bigContentTitle)
            .bigText(bigText);
        if (useSummary) {
            style.setSummaryText(summaryText);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:14:45.627 -0400", hash_original_field = "0BDDB9F6AC377A8E5886EBD18DAB761C", hash_generated_field = "D9091E07A714A47204C190B3FA6389EE")

    static final String EXTRA_REMOTE_INPUTS = "android.support.remoteInputs";}
