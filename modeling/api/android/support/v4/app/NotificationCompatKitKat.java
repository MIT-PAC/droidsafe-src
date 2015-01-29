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
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Action;
import android.util.SparseArray;
import android.widget.RemoteViews;

import java.util.ArrayList;
import java.util.List;

class NotificationCompatKitKat {
    public static class Builder implements NotificationBuilderWithBuilderAccessor,
            NotificationBuilderWithActions {
        private Notification.Builder b;
        private Bundle mExtras;
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
                mExtras.putBoolean(NotificationCompatJellybean.EXTRA_LOCAL_ONLY, true);
            }
            if (groupKey != null) {
                mExtras.putString(NotificationCompatJellybean.EXTRA_GROUP_KEY, groupKey);
                if (groupSummary) {
                    mExtras.putBoolean(NotificationCompatJellybean.EXTRA_GROUP_SUMMARY, true);
                } else {
                    mExtras.putBoolean(NotificationCompatJellybean.EXTRA_USE_SIDE_CHANNEL, true);
                }
            }
            if (sortKey != null) {
                mExtras.putString(NotificationCompatJellybean.EXTRA_SORT_KEY, sortKey);
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void addAction(NotificationCompatBase.Action action) {
            mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(b, action));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Notification.Builder getBuilder() {
            return b;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public Notification build() {
            SparseArray<Bundle> actionExtrasMap = NotificationCompatJellybean.buildActionExtrasMap(
                    mActionExtrasList);
            if (actionExtrasMap != null) {
                // Add the action extras sparse array if any action was added with extras.
                mExtras.putSparseParcelableArray(
                        NotificationCompatJellybean.EXTRA_ACTION_EXTRAS, actionExtrasMap);
            }
            b.setExtras(mExtras);
            return b.build();
        }

		@DSSafe(DSCat.SAFE_LIST)
        public void addAction(Action action) {
			// TODO Auto-generated method stub
			
		}
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:49:30.573 -0400", hash_original_method = "E5FE84B916E8CA6982921036BE0348D6", hash_generated_method = "0EF4A3CC5034F5F1DD0D457303F9B978")
    
public static Bundle getExtras(Notification notif) {
        return notif.extras;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:49:30.582 -0400", hash_original_method = "F003A4F1E89732C356AEE51F9A5D5AAA", hash_generated_method = "AE00D31DB2322D1BC51B617EE39D92A3")
    
public static int getActionCount(Notification notif) {
        return notif.actions != null ? notif.actions.length : 0;
    	
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:49:30.595 -0400", hash_original_method = "42D45AB99009C0433B4770EBB959CE3D", hash_generated_method = "9855ED94671035113A13BD69DD2ED453")
    
public static NotificationCompatBase.Action getAction(Notification notif,
            int actionIndex, NotificationCompatBase.Action.Factory factory,
            RemoteInputCompatBase.RemoteInput.Factory remoteInputFactory) {
        Notification.Action action = notif.actions[actionIndex];
        Bundle actionExtras = null;
        SparseArray<Bundle> actionExtrasMap = notif.extras.getSparseParcelableArray(
                NotificationCompatJellybean.EXTRA_ACTION_EXTRAS);
        if (actionExtrasMap != null) {
            actionExtras = actionExtrasMap.get(actionIndex);
        }
        return NotificationCompatJellybean.readAction(factory, remoteInputFactory,
                action.icon, action.title, action.actionIntent, actionExtras);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:49:30.605 -0400", hash_original_method = "0BF4B4B594B05F2D6C04143ADE68A543", hash_generated_method = "F105A21E223D1B72BB1C2C99DA7E620F")
    
public static boolean getLocalOnly(Notification notif) {
        return notif.extras.getBoolean(NotificationCompatJellybean.EXTRA_LOCAL_ONLY);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:49:30.614 -0400", hash_original_method = "E2CEAE72C46926D89760234D6B2D2D7C", hash_generated_method = "86EB95BB6B59EE1FA9A190310200DDFD")
    
public static String getGroup(Notification notif) {
        return notif.extras.getString(NotificationCompatJellybean.EXTRA_GROUP_KEY);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:49:30.622 -0400", hash_original_method = "2F654C2BEC975FDE8CF315B680354C2A", hash_generated_method = "AD054FFBD7ED52FDAC8CA33DD959D61E")
    
public static boolean isGroupSummary(Notification notif) {
        return notif.extras.getBoolean(NotificationCompatJellybean.EXTRA_GROUP_SUMMARY);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:49:30.632 -0400", hash_original_method = "C168C71E6F76F600D741075838BC3BFD", hash_generated_method = "C50A14C9DE23947207F0150A4CF18299")
    
public static String getSortKey(Notification notif) {
        return notif.extras.getString(NotificationCompatJellybean.EXTRA_SORT_KEY);
    }
}
