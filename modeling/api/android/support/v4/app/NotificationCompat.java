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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RemoteViews;
import java.util.ArrayList;

/**
 * Helper for accessing features in {@link android.app.Notification}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class NotificationCompat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:03.964 -0500", hash_original_field = "BAD7EC250F31466E61BD0FB6EB820337", hash_generated_field = "922B7B86CB8DA2C0A66A1F85C3129923")

    public static final int FLAG_HIGH_PRIORITY = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:03.967 -0500", hash_original_field = "AD84944DFBEF55C856CC80CA8C3A1ACC", hash_generated_field = "043D71D45C74A901A17E1EAB10F043DE")

    public static final int PRIORITY_DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:03.969 -0500", hash_original_field = "B7B6D873B17E779FD3FA5C897ACCE3D3", hash_generated_field = "3EA2A66E89B12DD331E6BCC204A5764C")

    public static final int PRIORITY_LOW = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:03.972 -0500", hash_original_field = "DAFA96943E1D8375E3149A42BD83A327", hash_generated_field = "5E0199AA24787AB6F5CB51969CB5447C")

    public static final int PRIORITY_MIN = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:03.973 -0500", hash_original_field = "BD50DA8090348A3B22444728A37E9056", hash_generated_field = "6FCF0C0774FE88789BB1CCA352CF0A80")

    public static final int PRIORITY_HIGH = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:03.976 -0500", hash_original_field = "45A6212A5581F6D81B2317023C1238AA", hash_generated_field = "B88288DEB7092EF8C32C20271F3474B0")

    public static final int PRIORITY_MAX = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:03.978 -0500", hash_original_field = "4AE7297870DD4E88340580CC7C071192", hash_generated_field = "EFDD110E4A65B545589FF531F677AF83")

    private static  NotificationCompatImpl IMPL;

    interface NotificationCompatImpl {
        public Notification build(Builder b);
        public Bundle getExtras(Notification n);
        public int getActionCount(Notification n);
        public Action getAction(Notification n, int actionIndex);
        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> parcelables);
        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actions);
        public boolean getLocalOnly(Notification n);
        public String getGroup(Notification n);
        public boolean isGroupSummary(Notification n);
        public String getSortKey(Notification n);
    }

    static class NotificationCompatImplBase implements NotificationCompatImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:03.983 -0500", hash_original_method = "5D4FEB2788134BE90B1C212DC752B6F1", hash_generated_method = "23EFE036AADA50F55C9E0D020C533D80")
        
public Notification build(Builder b) {
            Notification result = (Notification) b.mNotification;
            result.setLatestEventInfo(b.mContext, b.mContentTitle,
                    b.mContentText, b.mContentIntent);
            // translate high priority requests into legacy flag
            if (b.mPriority > PRIORITY_DEFAULT) {
                result.flags |= FLAG_HIGH_PRIORITY;
            }
            return result;
        }

		@DSSafe(DSCat.SAFE_LIST)
        @Override
		public Bundle getExtras(Notification n) {
			// TODO Auto-generated method stub
			Bundle b = new Bundle();
			b.addTaint(n.sound.getTaint());
			b.addTaint(n.tickerText.getTaint());
			return b;
		}

		@DSSafe(DSCat.SAFE_LIST)
        @Override
		public int getActionCount(Notification n) {
			// TODO Auto-generated method stub
			return (getTaintInt() + n.getTaintInt() + n.sound.getTaintInt() +
					n.tickerText.getTaintInt());
		}

		@DSSafe(DSCat.SAFE_LIST)
        @Override
		public Action getAction(Notification n, int actionIndex) {
			// TODO Auto-generated method stub
			Action a = new Action(DSOnlyType.DONTCARE);
			a.addTaint(getActionCount(n) + actionIndex);
			return a;
		}

		@DSSafe(DSCat.SAFE_LIST)
        @Override
		public Action[] getActionsFromParcelableArrayList(
				ArrayList<Parcelable> parcelables) {
			// TODO Auto-generated method stub
			Action[] actions = new Action[1];
			actions[0] = (Action)parcelables.get(0);

			actions[0].addTaint(getTaintInt());
					
			return actions;
		}

		@Override
		@DSSafe(DSCat.SAFE_LIST)
		public ArrayList<Parcelable> getParcelableArrayListForActions(
				Action[] actions) {
			// TODO Auto-generated method stub
			return null;
		}

		@DSSafe(DSCat.SAFE_LIST)
        @Override
		public boolean getLocalOnly(Notification n) {
			// TODO Auto-generated method stub
			return 1 == (getActionCount(n));
		}

		@DSSafe(DSCat.SAFE_LIST)
        @Override
		public String getGroup(Notification n) {
			// TODO Auto-generated method stub
			String s = new String();
			s.addTaint(getActionCount(n));
			return s;
        }

		@DSSafe(DSCat.SAFE_LIST)
        @Override
		public boolean isGroupSummary(Notification n) {
			// TODO Auto-generated method stub
			return 1 == (getActionCount(n));
		}

		@DSSafe(DSCat.SAFE_LIST)
        @Override
		public String getSortKey(Notification n) {
			// TODO Auto-generated method stub
			String s = new String();
			s.addTaint(getActionCount(n));
			return s;
		}
    }

    static class NotificationCompatImplHoneycomb extends NotificationCompatImplBase {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.036 -0500", hash_original_method = "67C04373CE66FA99B8198774A5156A6F", hash_generated_method = "FE32B9CD306B441DF5F253E294365B6E")
        
public Notification build(Builder b) {
            return NotificationCompatHoneycomb.add(b.mContext, b.mNotification,
                    b.mContentTitle, b.mContentText, b.mContentInfo, b.mTickerView,
                    b.mNumber, b.mContentIntent, b.mFullScreenIntent, b.mLargeIcon);
        }
    }

    static class NotificationCompatImplIceCreamSandwich extends NotificationCompatImplBase {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.041 -0500", hash_original_method = "DFC79958C39351F890FF4E250FFE701D", hash_generated_method = "10A783334C83A5CD0767ED3C64B63D08")
        
public Notification build(Builder b) {
            return NotificationCompatIceCreamSandwich.add(b.mContext, b.mNotification,
                    b.mContentTitle, b.mContentText, b.mContentInfo, b.mTickerView,
                    b.mNumber, b.mContentIntent, b.mFullScreenIntent, b.mLargeIcon,
                    b.mProgressMax, b.mProgress, b.mProgressIndeterminate);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new NotificationCompatImplIceCreamSandwich();
        } else if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new NotificationCompatImplHoneycomb();
        } else {
            IMPL = new NotificationCompatImplBase();
        }
    }

    /**
     * Builder class for {@link NotificationCompat} objects.  Allows easier control over
     * all the flags, as well as help constructing the typical notification layouts.
     * <p>
     * On platform versions that don't offer expanded notifications, methods that depend on
     * expanded notifications have no effect.
     * </p>
     * <p>
     * For example, action buttons won't appear on platforms prior to Android 4.1. Action
     * buttons depend on expanded notifications, which are only available in Android 4.1
     * and later.
     * <p>
     * For this reason, you should always ensure that UI controls in a notification are also
     * available in an {@link android.app.Activity} in your app, and you should always start that
     * {@link android.app.Activity} when users click the notification. To do this, use the
     * {@link NotificationCompat.Builder#setContentIntent setContentIntent()}
     * method.
     * </p>
     *
     */
    public static class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.045 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

        Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.047 -0500", hash_original_field = "880293D1CB2F5D4C60729EDF187AA8F8", hash_generated_field = "880293D1CB2F5D4C60729EDF187AA8F8")

        CharSequence mContentTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.048 -0500", hash_original_field = "338AB4B5CF81AE908BF4544B3B2F254F", hash_generated_field = "338AB4B5CF81AE908BF4544B3B2F254F")

        CharSequence mContentText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.051 -0500", hash_original_field = "D98DCE599CA88EC00FC93FC533751AAF", hash_generated_field = "D98DCE599CA88EC00FC93FC533751AAF")

        PendingIntent mContentIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.053 -0500", hash_original_field = "697830524BFDD238CA82220AE09EFD0B", hash_generated_field = "697830524BFDD238CA82220AE09EFD0B")

        PendingIntent mFullScreenIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.055 -0500", hash_original_field = "E928A240FFFEC471639FC2188595645A", hash_generated_field = "E928A240FFFEC471639FC2188595645A")

        RemoteViews mTickerView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.056 -0500", hash_original_field = "6F0581074C4BAF96C76AC7EEDA3527AD", hash_generated_field = "6F0581074C4BAF96C76AC7EEDA3527AD")

        Bitmap mLargeIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.058 -0500", hash_original_field = "B1E08D65D45DCE89F8C92DFDB628498A", hash_generated_field = "B1E08D65D45DCE89F8C92DFDB628498A")

        CharSequence mContentInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.061 -0500", hash_original_field = "C02E023E174B50E49705701085BB66D1", hash_generated_field = "C02E023E174B50E49705701085BB66D1")

        int mNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.064 -0500", hash_original_field = "1D8CA7654CC48BAF402334392A1619BF", hash_generated_field = "1D8CA7654CC48BAF402334392A1619BF")

        int mPriority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.067 -0500", hash_original_field = "E5AD87F4EB51AC1FD7F0619830E11A22", hash_generated_field = "E5AD87F4EB51AC1FD7F0619830E11A22")

        boolean mUseChronometer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.068 -0500", hash_original_field = "BF6EEBCC39830720EE9F4EA68F64D795", hash_generated_field = "BF6EEBCC39830720EE9F4EA68F64D795")

        Style mStyle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.070 -0500", hash_original_field = "DA9E2FB86AE6D1B5E8BF83C1E6A12991", hash_generated_field = "DA9E2FB86AE6D1B5E8BF83C1E6A12991")

        CharSequence mSubText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.071 -0500", hash_original_field = "154C1AE01E9174D6FCDE2326E257A98A", hash_generated_field = "154C1AE01E9174D6FCDE2326E257A98A")

        int mProgressMax;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.073 -0500", hash_original_field = "7CDF5A45863735DC45D655DB7E365343", hash_generated_field = "7CDF5A45863735DC45D655DB7E365343")

        int mProgress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.076 -0500", hash_original_field = "58257670235EC509C908CC6AA18E2BF9", hash_generated_field = "58257670235EC509C908CC6AA18E2BF9")

        boolean mProgressIndeterminate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.077 -0500", hash_original_field = "4147B4CADA6E564F7F8196012C08445D", hash_generated_field = "4147B4CADA6E564F7F8196012C08445D")

        ArrayList<Action> mActions = new ArrayList<Action>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.079 -0500", hash_original_field = "15DBBA5CB9F17B25316C96C477594C30", hash_generated_field = "15DBBA5CB9F17B25316C96C477594C30")

        Notification mNotification = new Notification();

        /**
         * Constructor.
         *
         * Automatically sets the when field to {@link System#currentTimeMillis()
         * System.currentTimeMillis()} and the audio stream to the
         * {@link Notification#STREAM_DEFAULT}.
         *
         * @param context A {@link Context} that will be used to construct the
         *      RemoteViews. The Context will not be held past the lifetime of this
         *      Builder object.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.082 -0500", hash_original_method = "F7043780AA2DC36940AE21B2627CEDDF", hash_generated_method = "FD6485DDFD6E58C93479000D36AEC4ED")
        
public Builder(Context context) {
            mContext = context;

            // Set defaults to match the defaults of a Notification
            mNotification.when = System.currentTimeMillis();
            mNotification.audioStreamType = Notification.STREAM_DEFAULT;
            mPriority = PRIORITY_DEFAULT;
        }

        /**
         * Set the time that the event occurred.  Notifications in the panel are
         * sorted by this time.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.084 -0500", hash_original_method = "062DE645B909DF8CEBE652FB9FA3C0DE", hash_generated_method = "9F0306E40303D23A71F2C356A207DD58")
        
public Builder setWhen(long when) {
            mNotification.when = when;
            return this;
        }

        /**
         * Show the {@link Notification#when} field as a stopwatch.
         *
         * Instead of presenting <code>when</code> as a timestamp, the notification will show an
         * automatically updating display of the minutes and seconds since <code>when</code>.
         *
         * Useful when showing an elapsed time (like an ongoing phone call).
         *
         * @see android.widget.Chronometer
         * @see Notification#when
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.085 -0500", hash_original_method = "4A5E167822B6D75C29D9DB37F3E99418", hash_generated_method = "A5F420386C75A5B918073DA84360DA2A")
        
public Builder setUsesChronometer(boolean b) {
            mUseChronometer = b;
            return this;
        }

        /**
         * Set the small icon to use in the notification layouts.  Different classes of devices
         * may return different sizes.  See the UX guidelines for more information on how to
         * design these icons.
         *
         * @param icon A resource ID in the application's package of the drawble to use.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.087 -0500", hash_original_method = "FAFB4ACB08F86EBEED8E9D5D537574CE", hash_generated_method = "F771CB8A0DB101534EAD632FF9B60966")
        
public Builder setSmallIcon(int icon) {
            mNotification.icon = icon;
            return this;
        }

        /**
         * A variant of {@link #setSmallIcon(int) setSmallIcon(int)} that takes an additional
         * level parameter for when the icon is a {@link android.graphics.drawable.LevelListDrawable
         * LevelListDrawable}.
         *
         * @param icon A resource ID in the application's package of the drawble to use.
         * @param level The level to use for the icon.
         *
         * @see android.graphics.drawable.LevelListDrawable
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.089 -0500", hash_original_method = "9B9483551BCCDB68D2A1FB9E38FCAFD8", hash_generated_method = "FE9E4E81D530B350C895080F6935EE38")
        
public Builder setSmallIcon(int icon, int level) {
            mNotification.icon = icon;
            mNotification.iconLevel = level;
            return this;
        }

        /**
         * Set the title (first row) of the notification, in a standard notification.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.092 -0500", hash_original_method = "51D215D9B594EB5434D1A4893B0851B6", hash_generated_method = "A24D5A5914321447B8D2056822EB1FA2")
        
public Builder setContentTitle(CharSequence title) {
            mContentTitle = title;
            return this;
        }

        /**
         * Set the text (second row) of the notification, in a standard notification.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.095 -0500", hash_original_method = "3B85C73BAA4531891B097F4FBFA7845D", hash_generated_method = "9A0C65143F929FA192B834775CCB4487")
        
public Builder setContentText(CharSequence text) {
            mContentText = text;
            return this;
        }

        /**
         * Set the third line of text in the platform notification template.
         * Don't use if you're also using {@link #setProgress(int, int, boolean)};
         * they occupy the same location in the standard template.
         * <br>
         * If the platform does not provide large-format notifications, this method has no effect.
         * The third line of text only appears in expanded view.
         * <br>
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.096 -0500", hash_original_method = "C26F306893F3391466019ACD3259C6EA", hash_generated_method = "EFDD1CEF6B67FB9700C23E764FB2F027")
        
public Builder setSubText(CharSequence text) {
            mSubText = text;
            return this;
        }

        /**
         * Set the large number at the right-hand side of the notification.  This is
         * equivalent to setContentInfo, although it might show the number in a different
         * font size for readability.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.098 -0500", hash_original_method = "5E0FC1F68404C1057ACE1D67E6ED676A", hash_generated_method = "B3B0FB5B636F91DC142A3DAF8586529B")
        
public Builder setNumber(int number) {
            mNumber = number;
            return this;
        }

        /**
         * Set the large text at the right-hand side of the notification.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.100 -0500", hash_original_method = "52A8AABE54D5BDFE521B8B41861DFCD9", hash_generated_method = "B7861F042965E1F9AD64C19E28002929")
        
public Builder setContentInfo(CharSequence info) {
            mContentInfo = info;
            return this;
        }

        /**
         * Set the progress this notification represents, which may be
         * represented as a {@link android.widget.ProgressBar}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.101 -0500", hash_original_method = "D0B2BE14A572EFF2EC3981BC799BA989", hash_generated_method = "6E0D3C0BC51827EB7CD05EFAE4B7F4F0")
        
public Builder setProgress(int max, int progress, boolean indeterminate) {
            mProgressMax = max;
            mProgress = progress;
            mProgressIndeterminate = indeterminate;
            return this;
        }

        /**
         * Supply a custom RemoteViews to use instead of the standard one.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.103 -0500", hash_original_method = "82491D7EB27E2190D00FDE07BBACB384", hash_generated_method = "E73C9E64AB1B8C0E8E2DBEA3FF14C2DC")
        
public Builder setContent(RemoteViews views) {
            mNotification.contentView = views;
            return this;
        }

        /**
         * Supply a {@link PendingIntent} to send when the notification is clicked.
         * If you do not supply an intent, you can now add PendingIntents to individual
         * views to be launched when clicked by calling {@link RemoteViews#setOnClickPendingIntent
         * RemoteViews.setOnClickPendingIntent(int,PendingIntent)}.  Be sure to
         * read {@link Notification#contentIntent Notification.contentIntent} for
         * how to correctly use this.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.106 -0500", hash_original_method = "13AF9850EB916E3E1CD09235309F6318", hash_generated_method = "35B80BF912DA7A0FF8C66DE39967BF3A")
        
public Builder setContentIntent(PendingIntent intent) {
            mContentIntent = intent;
            return this;
        }

        /**
         * Supply a {@link PendingIntent} to send when the notification is cleared by the user
         * directly from the notification panel.  For example, this intent is sent when the user
         * clicks the "Clear all" button, or the individual "X" buttons on notifications.  This
         * intent is not sent when the application calls {@link NotificationManager#cancel
         * NotificationManager.cancel(int)}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.108 -0500", hash_original_method = "76A51A5E9FBB2E4DE0FC71F597089A64", hash_generated_method = "A9B038D64BDB877800A33BA68F4FB606")
        
public Builder setDeleteIntent(PendingIntent intent) {
            mNotification.deleteIntent = intent;
            return this;
        }

        /**
         * An intent to launch instead of posting the notification to the status bar.
         * Only for use with extremely high-priority notifications demanding the user's
         * <strong>immediate</strong> attention, such as an incoming phone call or
         * alarm clock that the user has explicitly set to a particular time.
         * If this facility is used for something else, please give the user an option
         * to turn it off and use a normal notification, as this can be extremely
         * disruptive.
         *
         * @param intent The pending intent to launch.
         * @param highPriority Passing true will cause this notification to be sent
         *          even if other notifications are suppressed.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.111 -0500", hash_original_method = "CE5C618F1F516DEBBF5EC70FA84B35B1", hash_generated_method = "755C86B6B43CC915477EC577352C1178")
        
public Builder setFullScreenIntent(PendingIntent intent, boolean highPriority) {
            mFullScreenIntent = intent;
            setFlag(FLAG_HIGH_PRIORITY, highPriority);
            return this;
        }

        /**
         * Set the text that is displayed in the status bar when the notification first
         * arrives.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.113 -0500", hash_original_method = "7D7467FDA98F62F698826520B3FB20EB", hash_generated_method = "B796E3B19B8574DC1726A0A1D5CFB845")
        
public Builder setTicker(CharSequence tickerText) {
            mNotification.tickerText = tickerText;
            return this;
        }

        /**
         * Set the text that is displayed in the status bar when the notification first
         * arrives, and also a RemoteViews object that may be displayed instead on some
         * devices.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.116 -0500", hash_original_method = "1C02B3A1BC7FBE83CBA0465E112082AA", hash_generated_method = "8DEB22299F2C630503F134EAA3458338")
        
public Builder setTicker(CharSequence tickerText, RemoteViews views) {
            mNotification.tickerText = tickerText;
            mTickerView = views;
            return this;
        }

        /**
         * Set the large icon that is shown in the ticker and notification.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.120 -0500", hash_original_method = "7DCB1EA67ACA56F0B2754C8E360CAB68", hash_generated_method = "DF7C31C82F00E2DCBBC8B9EA70CE883E")
        
public Builder setLargeIcon(Bitmap icon) {
            mLargeIcon = icon;
            return this;
        }

        /**
         * Set the sound to play.  It will play on the default stream.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.122 -0500", hash_original_method = "F716509EA8DBFF85E9610A4884004A7F", hash_generated_method = "5F4A3FB839E96DFA39D7CFA9A4A6010C")
        
public Builder setSound(Uri sound) {
            mNotification.sound = sound;
            mNotification.audioStreamType = Notification.STREAM_DEFAULT;
            return this;
        }

        /**
         * Set the sound to play.  It will play on the stream you supply.
         *
         * @see #STREAM_DEFAULT
         * @see AudioManager for the <code>STREAM_</code> constants.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.124 -0500", hash_original_method = "B4261BE94BF3A9C4D7E8248320DFB065", hash_generated_method = "385F6EE29995D7F6236C01DD349BDDBD")
        
public Builder setSound(Uri sound, int streamType) {
            mNotification.sound = sound;
            mNotification.audioStreamType = streamType;
            return this;
        }

        /**
         * Set the vibration pattern to use.
         *
         * @see android.os.Vibrator for a discussion of the <code>pattern</code>
         * parameter.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.126 -0500", hash_original_method = "9FEF166B1128CB3612A8D0749207FEAC", hash_generated_method = "A4A7AAE69DC72A03C6900F6A0AC27727")
        
public Builder setVibrate(long[] pattern) {
            mNotification.vibrate = pattern;
            return this;
        }

        /**
         * Set the argb value that you would like the LED on the device to blnk, as well as the
         * rate.  The rate is specified in terms of the number of milliseconds to be on
         * and then the number of milliseconds to be off.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.128 -0500", hash_original_method = "241F11AAE13456B41863E106C6EDD78D", hash_generated_method = "08BAA57025962BC79FD885E4865C0EC1")
        
public Builder setLights(int argb, int onMs, int offMs) {
            mNotification.ledARGB = argb;
            mNotification.ledOnMS = onMs;
            mNotification.ledOffMS = offMs;
            boolean showLights = mNotification.ledOnMS != 0 && mNotification.ledOffMS != 0;
            mNotification.flags = (mNotification.flags & ~Notification.FLAG_SHOW_LIGHTS) |
                    (showLights ? Notification.FLAG_SHOW_LIGHTS : 0);
            return this;
        }

        /**
         * Set whether this is an ongoing notification.
         *
         * <p>Ongoing notifications differ from regular notifications in the following ways:
         * <ul>
         *   <li>Ongoing notifications are sorted above the regular notifications in the
         *   notification panel.</li>
         *   <li>Ongoing notifications do not have an 'X' close button, and are not affected
         *   by the "Clear all" button.
         * </ul>
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.131 -0500", hash_original_method = "FB58C69167DC93205775CEA710E3DF58", hash_generated_method = "3004A935E2D93F4B5C786BD2ABD564DE")
        
public Builder setOngoing(boolean ongoing) {
            setFlag(Notification.FLAG_ONGOING_EVENT, ongoing);
            return this;
        }

        /**
         * Set this flag if you would only like the sound, vibrate
         * and ticker to be played if the notification is not already showing.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.134 -0500", hash_original_method = "D5D6EDC811F3BC631E3DF617F3AE5098", hash_generated_method = "2B306C59BFB7882D974A4BD81A064205")
        
public Builder setOnlyAlertOnce(boolean onlyAlertOnce) {
            setFlag(Notification.FLAG_ONLY_ALERT_ONCE, onlyAlertOnce);
            return this;
        }

        /**
         * Setting this flag will make it so the notification is automatically
         * canceled when the user clicks it in the panel.  The PendingIntent
         * set with {@link #setDeleteIntent} will be broadcast when the notification
         * is canceled.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.136 -0500", hash_original_method = "257247F2DC11FC5C55BDB7D552514CB8", hash_generated_method = "806749D00FE837AC05D93A05ACCC4C98")
        
public Builder setAutoCancel(boolean autoCancel) {
            setFlag(Notification.FLAG_AUTO_CANCEL, autoCancel);
            return this;
        }

        /**
         * Set the default notification options that will be used.
         * <p>
         * The value should be one or more of the following fields combined with
         * bitwise-or:
         * {@link Notification#DEFAULT_SOUND}, {@link Notification#DEFAULT_VIBRATE},
         * {@link Notification#DEFAULT_LIGHTS}.
         * <p>
         * For all default values, use {@link Notification#DEFAULT_ALL}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.138 -0500", hash_original_method = "0576C475BE7C95AADC5C9D212B2F9C8D", hash_generated_method = "8604D984A442AF37385EEF1603F7173E")
        
public Builder setDefaults(int defaults) {
            mNotification.defaults = defaults;
            if ((defaults & Notification.DEFAULT_LIGHTS) != 0) {
                mNotification.flags |= Notification.FLAG_SHOW_LIGHTS;
            }
            return this;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.140 -0500", hash_original_method = "A0A3FE19F4004E74ADDA6928E78F09B0", hash_generated_method = "A46F51C29A192F0C1010201B8C7BC827")
        
private void setFlag(int mask, boolean value) {
            if (value) {
                mNotification.flags |= mask;
            } else {
                mNotification.flags &= ~mask;
            }
        }

        /**
         * Set the relative priority for this notification.
         *
         * Priority is an indication of how much of the user's
         * valuable attention should be consumed by this
         * notification. Low-priority notifications may be hidden from
         * the user in certain situations, while the user might be
         * interrupted for a higher-priority notification.
         * The system sets a notification's priority based on various factors including the
         * setPriority value. The effect may differ slightly on different platforms.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.141 -0500", hash_original_method = "D6FC2F5B6F218671B1949A4E949DE979", hash_generated_method = "2760D644FDBC0BBE5AF170A7AF2DBC82")
        
public Builder setPriority(int pri) {
            mPriority = pri;
            return this;
        }

        /**
         * Add an action to this notification. Actions are typically displayed by
         * the system as a button adjacent to the notification content.
         * <br>
         * Action buttons won't appear on platforms prior to Android 4.1. Action
         * buttons depend on expanded notifications, which are only available in Android 4.1
         * and later. To ensure that an action button's functionality is always available, first
         * implement the functionality in the {@link android.app.Activity} that starts when a user
         * clicks the  notification (see {@link #setContentIntent setContentIntent()}), and then
         * enhance the notification by implementing the same functionality with
         * {@link #addAction addAction()}.
         *
         * @param icon Resource ID of a drawable that represents the action.
         * @param title Text describing the action.
         * @param intent {@link android.app.PendingIntent} to be fired when the action is invoked.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.144 -0500", hash_original_method = "C1AEFCF07C54675630502E6755AA07D6", hash_generated_method = "5767BA2A6AF4B610049058360B51B14F")
        
public Builder addAction(int icon, CharSequence title, PendingIntent intent) {
            mActions.add(new Action(icon, title, intent));
            return this;
        }

        /**
         * Add a rich notification style to be applied at build time.
         * <br>
         * If the platform does not provide rich notification styles, this method has no effect. The
         * user will always see the normal notification style.
         *
         * @param style Object responsible for modifying the notification style.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.147 -0500", hash_original_method = "406467D1A4DC4F76367925F19B2DC0D5", hash_generated_method = "D91978C69CA35AC51CCC000004D985CD")
        
public Builder setStyle(Style style) {
            if (mStyle != style) {
                mStyle = style;
                if (mStyle != null) {
                    mStyle.setBuilder(this);
                }
            }
            return this;
        }

        /**
         * @deprecated Use {@link #build()} instead.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.149 -0500", hash_original_method = "15588961BDA1926CBA8261EB675AB085", hash_generated_method = "753F4735B0BCF8452E775FEB97424181")
        
@Deprecated
        public Notification getNotification() {
            return (Notification) IMPL.build(this);
        }

        /**
         * Combine all of the options that have been set and return a new {@link Notification}
         * object.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.151 -0500", hash_original_method = "3A19F0003F1629F770DB1A53DA663D91", hash_generated_method = "E4631F1A36C2C860AC2AB90E40EFABB8")
        
public Notification build() {
            return (Notification) IMPL.build(this);
        }
    }

    /**
     * An object that can apply a rich notification style to a {@link Notification.Builder}
     * object.
     * <br>
     * If the platform does not provide rich notification styles, methods in this class have no
     * effect.
     */
    public static abstract class Style
    {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.326 -0500", hash_original_field = "3B47D3828F6C58841CAAA5CDF159598A", hash_generated_field = "3B47D3828F6C58841CAAA5CDF159598A")

        Builder mBuilder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.327 -0500", hash_original_field = "A8763C6869FFC8B14632509B5951CF78", hash_generated_field = "A8763C6869FFC8B14632509B5951CF78")

        CharSequence mBigContentTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.328 -0500", hash_original_field = "FE5E2C0C1DA13344891A9CC54FF4ABD0", hash_generated_field = "FE5E2C0C1DA13344891A9CC54FF4ABD0")

        CharSequence mSummaryText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.330 -0500", hash_original_field = "15DCEA0D59F8A2D571FFA203A984A6EA", hash_generated_field = "15DCEA0D59F8A2D571FFA203A984A6EA")

        boolean mSummaryTextSet = false;

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.332 -0500", hash_original_method = "4E1C32047BCF7D8F068B78C0497D3581", hash_generated_method = "081150EA520A397F53CAE43E2D1E4362")
        
public void setBuilder(Builder builder) {
            if (mBuilder != builder) {
                mBuilder = builder;
                if (mBuilder != null) {
                    mBuilder.setStyle(this);
                }
            }
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.334 -0500", hash_original_method = "0FEC214F89D6BD743099C9B7F081F5FC", hash_generated_method = "5343CBF8C4B183FE71BC140FE018747F")
        
public Notification build() {
            Notification notification = null;
            if (mBuilder != null) {
                notification = mBuilder.build();
            }
            return notification;
        }
    }

    /**
     * Helper class for generating large-format notifications that include a large image attachment.
     * <br>
     * If the platform does not provide large-format notifications, this method has no effect. The
     * user will always see the normal notification view.
     * <br>
     * This class is a "rebuilder": It attaches to a Builder object and modifies its behavior, like so:
     * <pre class="prettyprint">
     * Notification noti = new Notification.Builder()
     *     .setContentTitle(&quot;New photo from &quot; + sender.toString())
     *     .setContentText(subject)
     *     .setSmallIcon(R.drawable.new_post)
     *     .setLargeIcon(aBitmap)
     *     .setStyle(new Notification.BigPictureStyle()
     *         .bigPicture(aBigBitmap))
     *     .build();
     * </pre>
     *
     * @see Notification#bigContentView
     */
    public static class BigPictureStyle extends Style {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.340 -0500", hash_original_field = "6750422543F06EDF58D4C058AEB2FB0B", hash_generated_field = "6750422543F06EDF58D4C058AEB2FB0B")

        Bitmap mPicture;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.341 -0500", hash_original_field = "EBFCAC2315FBBB7C14F685CAA0679FAF", hash_generated_field = "EBFCAC2315FBBB7C14F685CAA0679FAF")

        Bitmap mBigLargeIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.344 -0500", hash_original_field = "1BCBB9DE6C184B7D17D404354F84885B", hash_generated_field = "1BCBB9DE6C184B7D17D404354F84885B")

        boolean mBigLargeIconSet;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.346 -0500", hash_original_method = "3B87A1538500BE0C4C4429E052CFAA59", hash_generated_method = "4FDCC0CD821A1D50EE7ABFB7CDF9BF0D")
        
public BigPictureStyle() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.348 -0500", hash_original_method = "0498487B5309A9A12671436B756C1E14", hash_generated_method = "6F3C9023FAD5F605D40C31BDFA9E311D")
        
public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }

        /**
         * Overrides ContentTitle in the big form of the template.
         * This defaults to the value passed to setContentTitle().
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.352 -0500", hash_original_method = "FE367484E3DCA50BFF7FACA2258721A4", hash_generated_method = "4161BB45938C6019CF2CE2E36ACE6031")
        
public BigPictureStyle setBigContentTitle(CharSequence title) {
            mBigContentTitle = title;
            return this;
        }

        /**
         * Set the first line of text after the detail section in the big form of the template.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.355 -0500", hash_original_method = "9BCEC0CE654157B5407C038A3BD8FCB1", hash_generated_method = "44D99F2B96C4D5F1B444897C54DB9A10")
        
public BigPictureStyle setSummaryText(CharSequence cs) {
            mSummaryText = cs;
            mSummaryTextSet = true;
            return this;
        }

        /**
         * Provide the bitmap to be used as the payload for the BigPicture notification.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.357 -0500", hash_original_method = "5AF1E04BCC74B8D2EC1A6821C26FF824", hash_generated_method = "A174A09EA1458548215A942B68AB9F96")
        
public BigPictureStyle bigPicture(Bitmap b) {
            mPicture = b;
            return this;
        }

        /**
         * Override the large icon when the big notification is shown.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.358 -0500", hash_original_method = "D8F49E4408F0A46C14DCB29F57F3F7EC", hash_generated_method = "CA327094DB6C68DC4D6763BE2C6E574C")
        
public BigPictureStyle bigLargeIcon(Bitmap b) {
            mBigLargeIcon = b;
            mBigLargeIconSet = true;
            return this;
        }
    }

    /**
     * Helper class for generating large-format notifications that include a lot of text.
     *
     * <br>
     * If the platform does not provide large-format notifications, this method has no effect. The
     * user will always see the normal notification view.
     * <br>
     * This class is a "rebuilder": It attaches to a Builder object and modifies its behavior, like so:
     * <pre class="prettyprint">
     * Notification noti = new Notification.Builder()
     *     .setContentTitle(&quot;New mail from &quot; + sender.toString())
     *     .setContentText(subject)
     *     .setSmallIcon(R.drawable.new_mail)
     *     .setLargeIcon(aBitmap)
     *     .setStyle(new Notification.BigTextStyle()
     *         .bigText(aVeryLongString))
     *     .build();
     * </pre>
     *
     * @see Notification#bigContentView
     */
    public static class BigTextStyle extends Style {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.362 -0500", hash_original_field = "E500F2A8027C62CBBA6A62AA4FA3AE40", hash_generated_field = "E500F2A8027C62CBBA6A62AA4FA3AE40")

        CharSequence mBigText;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.364 -0500", hash_original_method = "FC2708C6265D9EFE6897BC23F510F3F6", hash_generated_method = "FE81B60BDDB4B029BF42CF95CA1BDD48")
        
public BigTextStyle() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.367 -0500", hash_original_method = "73900B5FBB9070B76B44EF3B18688CFC", hash_generated_method = "4420807CCC9D24ED02C6AE6DD2BEA35E")
        
public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }

        /**
         * Overrides ContentTitle in the big form of the template.
         * This defaults to the value passed to setContentTitle().
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.369 -0500", hash_original_method = "3EC75696F154B985C8C911B49B85B403", hash_generated_method = "22CD7D68CBBD615AADCB8BFCE0E13445")
        
public BigTextStyle setBigContentTitle(CharSequence title) {
            mBigContentTitle = title;
            return this;
        }

        /**
         * Set the first line of text after the detail section in the big form of the template.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.372 -0500", hash_original_method = "B0A68C8F773C01420893CD5F6C44873F", hash_generated_method = "26C29AE23E6E89BDB2256104AD40DFD7")
        
public BigTextStyle setSummaryText(CharSequence cs) {
            mSummaryText = cs;
            mSummaryTextSet = true;
            return this;
        }

        /**
         * Provide the longer text to be displayed in the big form of the
         * template in place of the content text.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.375 -0500", hash_original_method = "C0F673F76D8079C9E17C18062828FDEA", hash_generated_method = "617239A85614B4FE9C6A1DE7636D599F")
        
public BigTextStyle bigText(CharSequence cs) {
            mBigText = cs;
            return this;
        }
    }

    /**
     * Helper class for generating large-format notifications that include a list of (up to 5) strings.
     *
     * <br>
     * If the platform does not provide large-format notifications, this method has no effect. The
     * user will always see the normal notification view.
     * <br>
     * This class is a "rebuilder": It attaches to a Builder object and modifies its behavior, like so:
     * <pre class="prettyprint">
     * Notification noti = new Notification.Builder()
     *     .setContentTitle(&quot;5 New mails from &quot; + sender.toString())
     *     .setContentText(subject)
     *     .setSmallIcon(R.drawable.new_mail)
     *     .setLargeIcon(aBitmap)
     *     .setStyle(new Notification.InboxStyle()
     *         .addLine(str1)
     *         .addLine(str2)
     *         .setContentTitle(&quot;&quot;)
     *         .setSummaryText(&quot;+3 more&quot;))
     *     .build();
     * </pre>
     *
     * @see Notification#bigContentView
     */
    public static class InboxStyle extends Style {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.381 -0500", hash_original_field = "6DB2EA72CDD18906DCBED6BADDECD099", hash_generated_field = "6DB2EA72CDD18906DCBED6BADDECD099")

        ArrayList<CharSequence> mTexts = new ArrayList<CharSequence>();

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.383 -0500", hash_original_method = "77F8D142994117520A51F39629CB98C2", hash_generated_method = "954D22E14DF17F2BAAE07500DB83F30E")
        
public InboxStyle() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.384 -0500", hash_original_method = "2627A8164807341FF83179568E6D44EE", hash_generated_method = "19F10E557ADDB0E1149367FF622106CD")
        
public InboxStyle(Builder builder) {
            setBuilder(builder);
        }

        /**
         * Overrides ContentTitle in the big form of the template.
         * This defaults to the value passed to setContentTitle().
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.387 -0500", hash_original_method = "205601A0C1A8C02BAE31AF41C5894B0E", hash_generated_method = "4D475A01F6D9E728AEAE36A3BCF4F408")
        
public InboxStyle setBigContentTitle(CharSequence title) {
            mBigContentTitle = title;
            return this;
        }

        /**
         * Set the first line of text after the detail section in the big form of the template.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.389 -0500", hash_original_method = "95C39D28156ECA70CB0D3592561516E8", hash_generated_method = "AA2536A283214964AF668B084CEF4D43")
        
public InboxStyle setSummaryText(CharSequence cs) {
            mSummaryText = cs;
            mSummaryTextSet = true;
            return this;
        }

        /**
         * Append a line to the digest section of the Inbox notification.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.391 -0500", hash_original_method = "4A24CF50FAD49F68396B9687C7D6208C", hash_generated_method = "5CEAFD8985071C87987A8E6DDC37270E")
        
public InboxStyle addLine(CharSequence cs) {
            mTexts.add(cs);
            return this;
        }
    }

    public static class Action {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.395 -0500", hash_original_field = "107298D9FB7BD66B47A702264D3B04F5", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

        public int icon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.397 -0500", hash_original_field = "EBB523BB554B1588E9D2A3FD4AC43EC2", hash_generated_field = "285EF5A6A116FF608EE0587EA9C0F06D")

        public CharSequence title;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.400 -0500", hash_original_field = "A5B104850ADDC2CB7E39DEDB0C358827", hash_generated_field = "53A38E891AB883E0196D52D1C4FD630F")

        public PendingIntent actionIntent;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:04.402 -0500", hash_original_method = "2E266094E59088AED31570E473715FF2", hash_generated_method = "B92AAEFFB26AD19DF6F0FE551D131694")
        
public Action(int icon_, CharSequence title_, PendingIntent intent_) {
            this.icon = icon_;
            this.title = title_;
            this.actionIntent = intent_;
        }
        
        public Action(DSOnlyType dontcare) {
        	 this.icon = DSUtils.FAKE_INT;
             this.title = DSUtils.FAKE_STRING;
             this.actionIntent = new PendingIntent(DSOnlyType.DONTCARE);
        }
    }

    static class NotificationCompatImplJellybean extends NotificationCompatImplBase {
        @DSSafe(DSCat.SAFE_LIST)
        public Notification build(Builder b) {
            NotificationCompatJellybean jbBuilder = new NotificationCompatJellybean(
                    b.mContext, b.mNotification, b.mContentTitle, b.mContentText, b.mContentInfo,
                    b.mTickerView, b.mNumber, b.mContentIntent, b.mFullScreenIntent, b.mLargeIcon,
                    b.mProgressMax, b.mProgress, b.mProgressIndeterminate,
                    b.mUseChronometer, b.mPriority, b.mSubText);
            for (Action action: b.mActions) {
                jbBuilder.addAction(action.icon, action.title, action.actionIntent);
            }
            if (b.mStyle != null) {
                if (b.mStyle instanceof BigTextStyle) {
                    BigTextStyle style = (BigTextStyle) b.mStyle;
                    jbBuilder.addBigTextStyle(style.mBigContentTitle,
                            style.mSummaryTextSet,
                            style.mSummaryText,
                            style.mBigText);
                } else if (b.mStyle instanceof InboxStyle) {
                    InboxStyle style = (InboxStyle) b.mStyle;
                    jbBuilder.addInboxStyle(style.mBigContentTitle,
                            style.mSummaryTextSet,
                            style.mSummaryText,
                            style.mTexts);
                } else if (b.mStyle instanceof BigPictureStyle) {
                    BigPictureStyle style = (BigPictureStyle) b.mStyle;
                    jbBuilder.addBigPictureStyle(style.mBigContentTitle,
                            style.mSummaryTextSet,
                            style.mSummaryText,
                            style.mPicture,
                            style.mBigLargeIcon,
                            style.mBigLargeIconSet);
                }
            }
            return(jbBuilder.build());
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
	public static Bundle getExtras(Notification notification) {
		// TODO Auto-generated method stub
		Bundle b = new Bundle();
		b.addTaint(notification.getTaint());
		return b;
	}}
