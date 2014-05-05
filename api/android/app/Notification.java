/*
 * Copyright (C) 2007 The Android Open Source Project
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

package android.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.android.internal.R;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.IntProperty;
import android.util.Log;
import android.util.Slog;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RemoteViews;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * A class that represents how a persistent notification is to be presented to
 * the user using the {@link android.app.NotificationManager}.
 *
 * <p>The {@link Notification.Builder Notification.Builder} has been added to make it
 * easier to construct Notifications.</p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For a guide to creating notifications, read the
 * <a href="{@docRoot}guide/topics/ui/notifiers/notifications.html">Status Bar Notifications</a>
 * developer guide.</p>
 * </div>
 */
public class Notification implements Parcelable
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.685 -0500", hash_original_field = "5BB1F14B760B289DD56199D40503C3B2", hash_generated_field = "493D0EBDAE7097F899550C884AC22A2C")

    public static final int DEFAULT_ALL = ~0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.690 -0500", hash_original_field = "D79104ECE84D6D4275C13967C6005A2E", hash_generated_field = "EBEB29EEA1677186411B0676C7CB6CA8")

    public static final int DEFAULT_SOUND = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.693 -0500", hash_original_field = "95B20DBB35ADD5F8D1A6B5695AD65EF9", hash_generated_field = "625958CF78DAC59C5F668018906E7A25")

    public static final int DEFAULT_VIBRATE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.696 -0500", hash_original_field = "8A1328AA01C36B0B93081D26982FFB84", hash_generated_field = "08672983F6AA38AE8CB005A3B0951E14")

    public static final int DEFAULT_LIGHTS = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.739 -0500", hash_original_field = "2343A4818416EB4EF29D708D4FB72871", hash_generated_field = "03418D428EB9B0647508E7584179BDCC")

    public static final int STREAM_DEFAULT = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.758 -0500", hash_original_field = "0684D63406D7C99A7541248AB6E9C0D0", hash_generated_field = "3EA71E6BEF191625FDE53FA428627FCD")

    public static final int FLAG_SHOW_LIGHTS        = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.761 -0500", hash_original_field = "9DAC33CF709813C30F3B2B60194916AE", hash_generated_field = "4212FDC8E3576C78F889BF1A169268A1")

    public static final int FLAG_ONGOING_EVENT      = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.764 -0500", hash_original_field = "B414B9AEFD0AD0FCC87E9A3CB2DB53C1", hash_generated_field = "5E4C5667DCB9D60C104C3E79AF4A4C18")

    public static final int FLAG_INSISTENT          = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.767 -0500", hash_original_field = "F0E3A1D373D7B22039D7949B0A68B528", hash_generated_field = "500F040419409BB73C946F7E5EAF73E0")

    public static final int FLAG_ONLY_ALERT_ONCE    = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.769 -0500", hash_original_field = "8F195662E2B680AAE53B06D576F2B913", hash_generated_field = "E5EB78F93DFB40825F4ED628FB1B6DFC")

    public static final int FLAG_AUTO_CANCEL        = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.772 -0500", hash_original_field = "A743B955AF96295F560A6C4F23A29FA0", hash_generated_field = "EC8515FDF436BE99F3787638E8918138")

    public static final int FLAG_NO_CLEAR           = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.775 -0500", hash_original_field = "EAE7FBAC18351788C2008C881DE10CF8", hash_generated_field = "4891EB5C3AD9C34A5B31934636D873FF")

    public static final int FLAG_FOREGROUND_SERVICE = 0x00000040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.778 -0500", hash_original_field = "BAD7EC250F31466E61BD0FB6EB820337", hash_generated_field = "922B7B86CB8DA2C0A66A1F85C3129923")

    public static final int FLAG_HIGH_PRIORITY      = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.783 -0500", hash_original_field = "AD84944DFBEF55C856CC80CA8C3A1ACC", hash_generated_field = "043D71D45C74A901A17E1EAB10F043DE")

    public static final int PRIORITY_DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.786 -0500", hash_original_field = "B7B6D873B17E779FD3FA5C897ACCE3D3", hash_generated_field = "3EA2A66E89B12DD331E6BCC204A5764C")

    public static final int PRIORITY_LOW = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.789 -0500", hash_original_field = "DAFA96943E1D8375E3149A42BD83A327", hash_generated_field = "5E0199AA24787AB6F5CB51969CB5447C")

    public static final int PRIORITY_MIN = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.792 -0500", hash_original_field = "BD50DA8090348A3B22444728A37E9056", hash_generated_field = "6FCF0C0774FE88789BB1CCA352CF0A80")

    public static final int PRIORITY_HIGH = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.794 -0500", hash_original_field = "45A6212A5581F6D81B2317023C1238AA", hash_generated_field = "B88288DEB7092EF8C32C20271F3474B0")

    public static final int PRIORITY_MAX = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.800 -0500", hash_original_field = "DDD088F9EC70202884D9C886E3F6966E", hash_generated_field = "9A30E8AD1F88E74AEBD85F82E2AEBC7C")

    public static final String KIND_CALL = "android.call";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.802 -0500", hash_original_field = "3EAF290DE1A3AAA3A43F598D9120C28C", hash_generated_field = "21071F7B9275FD9A61DDB1B4E54EE380")

    public static final String KIND_MESSAGE = "android.message";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.805 -0500", hash_original_field = "044EEC77FF78B0C375DD10646878F2D7", hash_generated_field = "995B38BF537C70BEB36C1CC152528F33")

    public static final String KIND_EMAIL = "android.email";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.808 -0500", hash_original_field = "26241E1C44889CEE6EDB74CE03633B1E", hash_generated_field = "1B924B7AC50A7EA852EAD2161160B99B")

    public static final String KIND_EVENT = "android.event";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.811 -0500", hash_original_field = "A07351EB59AFEB925FCD6B34C3C5318B", hash_generated_field = "8BAFC4EB1F061329DD6E44B2797510E6")

    public static final String KIND_PROMO = "android.promo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.816 -0500", hash_original_field = "6D92EC76C55A43F338C8495134CFFEBB", hash_generated_field = "2F744B614E46DD5E1973208F674DA6B6")

    public static final String EXTRA_PEOPLE = "android.people";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.895 -0500", hash_original_field = "D5184F4291EF20F0776A99ACDAB942DD", hash_generated_field = "4FA917F3775D815CA3B6257FE54BF16E")

    public static final Parcelable.Creator<Notification> CREATOR
            = new Parcelable.Creator<Notification>()
    {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-05-05 09:45:16.269 -0400", hash_original_method = "640E6F5E88B10B67950DC22B82259969", hash_generated_method = "DBA7908684BF656EA8BA45DF5B36E06D")
        
public Notification createFromParcel(Parcel parcel)
        {
            return new Notification(parcel);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-05-05 09:45:16.275 -0400", hash_original_method = "FE58AA31658A96AD26D1C6215FA7714A", hash_generated_method = "4A47C730289FE57DF6D6C93315B6DA2F")
        
public Notification[] newArray(int size)
        {
            return new Notification[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.699 -0500", hash_original_field = "4E7289569777021C55877266ACAD1845", hash_generated_field = "F82DA8012E916756399BAA33930FB695")

    public long when;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.705 -0500", hash_original_field = "107298D9FB7BD66B47A702264D3B04F5", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

    public int icon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.708 -0500", hash_original_field = "F9B43650694732C77D734E3DEABF76D6", hash_generated_field = "0B0F3FF5AB4CD552070A82872F28FB69")

    public int iconLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.711 -0500", hash_original_field = "75B782B0DE9A9BBA8740638F419D560B", hash_generated_field = "54FA7EDC40A989145447D14354DC9F9A")

    public int number;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.714 -0500", hash_original_field = "4A78EA1E007D2E1AB86140EA509159FE", hash_generated_field = "ACC5096DEB0E4E25E88593DF3B444C2B")

    public PendingIntent contentIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.717 -0500", hash_original_field = "8F016DA35B5B1063C3779A582F7F5452", hash_generated_field = "ACCD1DE1BA3D76E49153B8A305B4A364")

    public PendingIntent deleteIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.720 -0500", hash_original_field = "B03D10D9E4BD449BE5BFDA9A69BA730E", hash_generated_field = "C32708A07B582946310828630C843FF1")

    public PendingIntent fullScreenIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.722 -0500", hash_original_field = "6DC420EE34CCC4104C5914011B37B5D4", hash_generated_field = "F8945E83CE6F7B2AC575B630A6341BE3")

    public CharSequence tickerText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.725 -0500", hash_original_field = "E5C4BC8A8E0D47169052DB109E5E3D6B", hash_generated_field = "AF996FFD954333E18222E9A80B0CF291")

    public RemoteViews tickerView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.728 -0500", hash_original_field = "FD7FD9D77F3F582A3CD36061BD487F5A", hash_generated_field = "769785439B75A74E92941436557060A4")

    public RemoteViews contentView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.730 -0500", hash_original_field = "DD7227635C5432EEB5F98AE3BA0DAFE3", hash_generated_field = "9D33EC9094AADF69797FB23ACC5A5F03")

    public RemoteViews bigContentView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.733 -0500", hash_original_field = "8D43B5A2FD1735E358C32CFF729F82BD", hash_generated_field = "EA93211928C617C6B7C0D0E85008BB42")

    public Bitmap largeIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.736 -0500", hash_original_field = "FB0BA9D9FDF6835B713C56A87A16C2F1", hash_generated_field = "8DB7BA9A074BC98B2BC33FB259A56E89")

    public Uri sound;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.742 -0500", hash_original_field = "CC58BD2530F63FA2C5487A6D19BB0DE6", hash_generated_field = "60DCD6A3318C227AA673545D733ED8B9")

    public int audioStreamType = STREAM_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.744 -0500", hash_original_field = "D33E756C2D5F750C5D34904C059EE8D3", hash_generated_field = "F2FF83B6EA1500EB5B3B8FD769168619")

    public long[] vibrate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.746 -0500", hash_original_field = "128E38791619DBDCD60954601A40EDB1", hash_generated_field = "057E0BFB613A5D660FB5738277981EFF")

    public int ledARGB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.749 -0500", hash_original_field = "BE29BDED8CDF42024CE656623EE78BC7", hash_generated_field = "ECB5054078CA45CCA91A54D58291273A")

    public int ledOnMS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.751 -0500", hash_original_field = "F5DFD15DE0217B704ED3281A99071FF4", hash_generated_field = "757766F0FDC535C47D375ED10B30B12B")

    public int ledOffMS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.754 -0500", hash_original_field = "315D538D8AB67E5836D57CA11C65B223", hash_generated_field = "35E2996A18AD2901CBB69EB78ED2A434")

    public int defaults;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.780 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.796 -0500", hash_original_field = "4AD9F2E37B35E313CD211FBAFDADA238", hash_generated_field = "748E38F248BB72B76836AB36AB4B68BF")

    public int priority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.813 -0500", hash_original_field = "2E2EFAEE61716F37FF1A9136CDA3B2F5", hash_generated_field = "DC4D7445BEB458DFFB343CAA06EE1E6C")

    public String[] kind;

    /**
     * Structure to encapsulate an "action", including title and icon, that can be attached to a Notification.
     * @hide
     */
    private static class Action implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.851 -0500", hash_original_field = "C2D1EA0ED2BDB865CA7AAF2EDD085BB3", hash_generated_field = "7D00235E1576E72D5EBB779ACEAE2E6A")

        public static final Parcelable.Creator<Action> CREATOR
        = new Parcelable.Creator<Action>() {
            public Action createFromParcel(Parcel in) {
                return new Action(in);
            }
            public Action[] newArray(int size) {
                return new Action[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.821 -0500", hash_original_field = "107298D9FB7BD66B47A702264D3B04F5", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

        public int icon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.823 -0500", hash_original_field = "EBB523BB554B1588E9D2A3FD4AC43EC2", hash_generated_field = "285EF5A6A116FF608EE0587EA9C0F06D")

        public CharSequence title;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.826 -0500", hash_original_field = "A5B104850ADDC2CB7E39DEDB0C358827", hash_generated_field = "53A38E891AB883E0196D52D1C4FD630F")

        public PendingIntent actionIntent;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.828 -0500", hash_original_method = "72CF35B308D5BFA491A169CB4BB41DEF", hash_generated_method = "0DDF405CBD0EF7159B76F1586F3DE10A")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)  
@SuppressWarnings("unused")
        public Action() { }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.832 -0500", hash_original_method = "712106731DCA508D8A3092C52F1CD0A3", hash_generated_method = "B669851F1C9EF49451A1891F3C427A7A")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private Action(Parcel in) {
            icon = in.readInt();
            title = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            if (in.readInt() == 1) {
                actionIntent = PendingIntent.CREATOR.createFromParcel(in);
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.835 -0500", hash_original_method = "2E266094E59088AED31570E473715FF2", hash_generated_method = "B92AAEFFB26AD19DF6F0FE551D131694")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public Action(int icon_, CharSequence title_, PendingIntent intent_) {
            this.icon = icon_;
            this.title = title_;
            this.actionIntent = intent_;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.837 -0500", hash_original_method = "EA3AC4E8FD9A3A2FB1A1E94FC4289126", hash_generated_method = "EC6DBFF17F5772D0AB3711AD419A01D6")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
@Override
        public Action clone() {
            return new Action(
                this.icon,
                this.title.toString(),
                this.actionIntent // safe to alias
            );
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.840 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
@Override
        public int describeContents() {
            return 0;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.842 -0500", hash_original_method = "9E855F61E99DC0D3CDE384BB47975F2A", hash_generated_method = "9B3EBAE1A78A38826B529F474332E618")
        @DSVerified
        @DSSpec(DSCat.SERIALIZATION)
@Override
        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(icon);
            TextUtils.writeToParcel(title, out, flags);
            if (actionIntent != null) {
                out.writeInt(1);
                actionIntent.writeToParcel(out, flags);
            } else {
                out.writeInt(0);
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.818 -0500", hash_original_field = "6F80A5414A80FF69E92A0BD3C0E073DC", hash_generated_field = "66AEDCB15A5D6889C65226678BC8C2E1")

    private Bundle extras;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.858 -0500", hash_original_field = "EBB91CA3E65CD7BAE0822FB31E602796", hash_generated_field = "96F510E9758A5FC0525EDDB2F0F52D96")

    private Action[] actions;

    /**
     * Constructs a Notification object with default values.
     * You might want to consider using {@link Builder} instead.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.860 -0500", hash_original_method = "DBD6966451714D8E673C9EEAC9EAB15D", hash_generated_method = "E44A4FFE558E13BCA82163D9CE98B816")
    
public Notification()
    {
        this.when = System.currentTimeMillis();
        this.priority = PRIORITY_DEFAULT;
    }

    /**
     * @hide
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.863 -0500", hash_original_method = "F912A2DECFC167F58680F860007D2BB5", hash_generated_method = "AE6727A684FB35E2A2D80E2578110191")
    
public Notification(Context context, int icon, CharSequence tickerText, long when,
            CharSequence contentTitle, CharSequence contentText, Intent contentIntent)
    {
        this.when = when;
        this.icon = icon;
        this.tickerText = tickerText;
        setLatestEventInfo(context, contentTitle, contentText,
                PendingIntent.getActivity(context, 0, contentIntent, 0));
    }

    /**
     * Constructs a Notification object with the information needed to
     * have a status bar icon without the standard expanded view.
     *
     * @param icon          The resource id of the icon to put in the status bar.
     * @param tickerText    The text that flows by in the status bar when the notification first
     *                      activates.
     * @param when          The time to show in the time field.  In the System.currentTimeMillis
     *                      timebase.
     *
     * @deprecated Use {@link Builder} instead.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.866 -0500", hash_original_method = "CC2BF19BEFE3DF69C00F83DC5FB8C9D2", hash_generated_method = "024900C64796E7D706CC036A6F0BE7A3")
    
@Deprecated
    public Notification(int icon, CharSequence tickerText, long when)
    {
        this.icon = icon;
        this.tickerText = tickerText;
        this.when = when;
    }

    /**
     * Unflatten the notification from a parcel.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.872 -0500", hash_original_method = "B871B95F5806993888978965BF530083", hash_generated_method = "C44E7F235C21DC5F5BA24A6529653AAA")
    
public Notification(Parcel parcel)
    {
        int version = parcel.readInt();

        when = parcel.readLong();
        icon = parcel.readInt();
        number = parcel.readInt();
        if (parcel.readInt() != 0) {
            contentIntent = PendingIntent.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            deleteIntent = PendingIntent.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            tickerText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            tickerView = RemoteViews.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            contentView = RemoteViews.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            largeIcon = Bitmap.CREATOR.createFromParcel(parcel);
        }
        defaults = parcel.readInt();
        flags = parcel.readInt();
        if (parcel.readInt() != 0) {
            sound = Uri.CREATOR.createFromParcel(parcel);
        }

        audioStreamType = parcel.readInt();
        vibrate = parcel.createLongArray();
        ledARGB = parcel.readInt();
        ledOnMS = parcel.readInt();
        ledOffMS = parcel.readInt();
        iconLevel = parcel.readInt();

        if (parcel.readInt() != 0) {
            fullScreenIntent = PendingIntent.CREATOR.createFromParcel(parcel);
        }

        priority = parcel.readInt();

        kind = parcel.createStringArray(); // may set kind to null

        if (parcel.readInt() != 0) {
            extras = parcel.readBundle();
        }

        actions = parcel.createTypedArray(Action.CREATOR);
        if (parcel.readInt() != 0) {
            bigContentView = RemoteViews.CREATOR.createFromParcel(parcel);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.879 -0500", hash_original_method = "33AFE123F36310F2B7C5806919DBFE48", hash_generated_method = "87F7B06FD813B97FDC277A205E6D242E")
    
@Override
    public Notification clone() {
        Notification that = new Notification();

        that.when = this.when;
        that.icon = this.icon;
        that.number = this.number;

        // PendingIntents are global, so there's no reason (or way) to clone them.
        that.contentIntent = this.contentIntent;
        that.deleteIntent = this.deleteIntent;
        that.fullScreenIntent = this.fullScreenIntent;

        if (this.tickerText != null) {
            that.tickerText = this.tickerText.toString();
        }
        if (this.tickerView != null) {
            that.tickerView = this.tickerView.clone();
        }
        if (this.contentView != null) {
            that.contentView = this.contentView.clone();
        }
        if (this.largeIcon != null) {
            that.largeIcon = Bitmap.createBitmap(this.largeIcon);
        }
        that.iconLevel = this.iconLevel;
        that.sound = this.sound; // android.net.Uri is immutable
        that.audioStreamType = this.audioStreamType;

        final long[] vibrate = this.vibrate;
        if (vibrate != null) {
            final int N = vibrate.length;
            final long[] vib = that.vibrate = new long[N];
            System.arraycopy(vibrate, 0, vib, 0, N);
        }

        that.ledARGB = this.ledARGB;
        that.ledOnMS = this.ledOnMS;
        that.ledOffMS = this.ledOffMS;
        that.defaults = this.defaults;

        that.flags = this.flags;

        that.priority = this.priority;
        
        final String[] thiskind = this.kind;
        if (thiskind != null) {
            final int N = thiskind.length;
            final String[] thatkind = that.kind = new String[N];
            System.arraycopy(thiskind, 0, thatkind, 0, N);
        }

        if (this.extras != null) {
            that.extras = new Bundle(this.extras);

        }

        that.actions = new Action[this.actions.length];
        for(int i=0; i<this.actions.length; i++) {
            that.actions[i] = this.actions[i].clone();
        }
        if (this.bigContentView != null) {
            that.bigContentView = this.bigContentView.clone();
        }

        return that;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.882 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /**
     * Flatten this notification from a parcel.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.887 -0500", hash_original_method = "5C0DC043738AC4333F4B83B519C04DF0", hash_generated_method = "59AF87A64B36E5B102009AA38D857716")
    
public void writeToParcel(Parcel parcel, int flags)
    {
        parcel.writeInt(1);

        parcel.writeLong(when);
        parcel.writeInt(icon);
        parcel.writeInt(number);
        if (contentIntent != null) {
            parcel.writeInt(1);
            contentIntent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if (deleteIntent != null) {
            parcel.writeInt(1);
            deleteIntent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if (tickerText != null) {
            parcel.writeInt(1);
            TextUtils.writeToParcel(tickerText, parcel, flags);
        } else {
            parcel.writeInt(0);
        }
        if (tickerView != null) {
            parcel.writeInt(1);
            tickerView.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if (contentView != null) {
            parcel.writeInt(1);
            contentView.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if (largeIcon != null) {
            parcel.writeInt(1);
            largeIcon.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }

        parcel.writeInt(defaults);
        parcel.writeInt(this.flags);

        if (sound != null) {
            parcel.writeInt(1);
            sound.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(audioStreamType);
        parcel.writeLongArray(vibrate);
        parcel.writeInt(ledARGB);
        parcel.writeInt(ledOnMS);
        parcel.writeInt(ledOffMS);
        parcel.writeInt(iconLevel);

        if (fullScreenIntent != null) {
            parcel.writeInt(1);
            fullScreenIntent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }

        parcel.writeInt(priority);
        
        parcel.writeStringArray(kind); // ok for null
        
        if (extras != null) {
            parcel.writeInt(1);
            extras.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }

        parcel.writeTypedArray(actions, 0);

        if (bigContentView != null) {
            parcel.writeInt(1);
            bigContentView.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
    }

    /**
     * Sets the {@link #contentView} field to be a view with the standard "Latest Event"
     * layout.
     *
     * <p>Uses the {@link #icon} and {@link #when} fields to set the icon and time fields
     * in the view.</p>
     * @param context       The context for your application / activity.
     * @param contentTitle The title that goes in the expanded entry.
     * @param contentText  The text that goes in the expanded entry.
     * @param contentIntent The intent to launch when the user clicks the expanded notification.
     * If this is an activity, it must include the
     * {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK} flag, which requires
     * that you take care of task management as described in the
     * <a href="{@docRoot}guide/topics/fundamentals/tasks-and-back-stack.html">Tasks and Back
     * Stack</a> document.
     *
     * @deprecated Use {@link Builder} instead.
     */
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.898 -0500", hash_original_method = "C7F28162FFDAA473CE57CDE5740FFAF5", hash_generated_method = "547841A47D76B1E4F7E2B0181CA229EF")
    
@Deprecated
    public void setLatestEventInfo(Context context,
            CharSequence contentTitle, CharSequence contentText, PendingIntent contentIntent) {
        // TODO: rewrite this to use Builder
        RemoteViews contentView = new RemoteViews(context.getPackageName(),
                DSUtils.FAKE_INT);
        this.contentView = contentView;
        this.contentIntent = contentIntent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.902 -0500", hash_original_method = "D1F214F35D23C9DE8CCA4D0E93C87742", hash_generated_method = "2CB1D02F29D176E916524AE0EAD76E83")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Notification(pri=");
        sb.append(priority);
        sb.append(" contentView=");
        if (contentView != null) {
            sb.append(contentView.getPackage());
            sb.append("/0x");
            sb.append(Integer.toHexString(contentView.getLayoutId()));
        } else {
            sb.append("null");
        }
        // TODO(dsandler): defaults take precedence over local values, so reorder the branches below
        sb.append(" vibrate=");
        if (this.vibrate != null) {
            int N = this.vibrate.length-1;
            sb.append("[");
            for (int i=0; i<N; i++) {
                sb.append(this.vibrate[i]);
                sb.append(',');
            }
            if (N != -1) {
                sb.append(this.vibrate[N]);
            }
            sb.append("]");
        } else if ((this.defaults & DEFAULT_VIBRATE) != 0) {
            sb.append("default");
        } else {
            sb.append("null");
        }
        sb.append(" sound=");
        if (this.sound != null) {
            sb.append(this.sound.toString());
        } else if ((this.defaults & DEFAULT_SOUND) != 0) {
            sb.append("default");
        } else {
            sb.append("null");
        }
        sb.append(" defaults=0x");
        sb.append(Integer.toHexString(this.defaults));
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.flags));
        sb.append(" kind=[");
        if (this.kind == null) {
            sb.append("null");
        } else {
            for (int i=0; i<this.kind.length; i++) {
                if (i>0) sb.append(",");
                sb.append(this.kind[i]);
            }
        }
        sb.append("]");
        if (actions != null) {
            sb.append(" ");
            sb.append(actions.length);
            sb.append(" action");
            if (actions.length > 1) sb.append("s");
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Builder class for {@link Notification} objects.
     * 
     * Provides a convenient way to set the various fields of a {@link Notification} and generate
     * content views using the platform's notification layout template. 
     * 
     * Example:
     * 
     * <pre class="prettyprint">
     * Notification noti = new Notification.Builder()
     *         .setContentTitle(&quot;New mail from &quot; + sender.toString())
     *         .setContentText(subject)
     *         .setSmallIcon(R.drawable.new_mail)
     *         .setLargeIcon(aBitmap)
     *         .build();
     * </pre>
     */
    public static class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.905 -0500", hash_original_field = "FAED108AF396D51BC9DCD9229A2852DB", hash_generated_field = "876127185B2F5BEA889021E5E7D45CA6")

        private static final int MAX_ACTION_BUTTONS = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.907 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.909 -0500", hash_original_field = "DC3C02B3B86774AA049529AB7BA1456D", hash_generated_field = "844ECA1D47A3C505C7DE80048E6071EA")

        private long mWhen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.911 -0500", hash_original_field = "1ECA0A39CA494F6BEDC60572E1607E75", hash_generated_field = "45C49A5EA6EC401F6D3EFC525CE84A58")

        private int mSmallIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.913 -0500", hash_original_field = "263997AA77350A6487A707770AF47AC4", hash_generated_field = "932D936BF624A2B432081D3ADA06CDC3")

        private int mSmallIconLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.915 -0500", hash_original_field = "C02E023E174B50E49705701085BB66D1", hash_generated_field = "848AD153D7087EB88E43698A2BA4D08A")

        private int mNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.917 -0500", hash_original_field = "880293D1CB2F5D4C60729EDF187AA8F8", hash_generated_field = "FFA5757AF4F9418B30896AACC31036BF")

        private CharSequence mContentTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.920 -0500", hash_original_field = "338AB4B5CF81AE908BF4544B3B2F254F", hash_generated_field = "75350C63E0F1B03693385651463FA9C6")

        private CharSequence mContentText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.923 -0500", hash_original_field = "B1E08D65D45DCE89F8C92DFDB628498A", hash_generated_field = "C6399AC62AF77A98346FD207F5167CB9")

        private CharSequence mContentInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.925 -0500", hash_original_field = "DA9E2FB86AE6D1B5E8BF83C1E6A12991", hash_generated_field = "D8E25E8ADF8C1E11BB55635BE7072D19")

        private CharSequence mSubText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.927 -0500", hash_original_field = "D98DCE599CA88EC00FC93FC533751AAF", hash_generated_field = "BEBC996087293B4AD2344506D898D15D")

        private PendingIntent mContentIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.929 -0500", hash_original_field = "58BBF53D1528BA428A44F10051F00D93", hash_generated_field = "08435EE426E232F3FA1E7809E4B4A6F7")

        private RemoteViews mContentView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.931 -0500", hash_original_field = "D5613E1FDE7DBE5D0BC1456E63C61CCE", hash_generated_field = "6F635B2E24C4F500DDDEE0939372307D")

        private PendingIntent mDeleteIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.933 -0500", hash_original_field = "697830524BFDD238CA82220AE09EFD0B", hash_generated_field = "3508300255B3E18B759E79D0ED10AAB9")

        private PendingIntent mFullScreenIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.935 -0500", hash_original_field = "31911831BCAB73D0E21B3633E73E2913", hash_generated_field = "8BD90CF350247B504B56B7A79683065B")

        private CharSequence mTickerText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.947 -0500", hash_original_field = "E928A240FFFEC471639FC2188595645A", hash_generated_field = "9BC35C79903BE74DB4B0AA612E15AD23")

        private RemoteViews mTickerView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.949 -0500", hash_original_field = "6F0581074C4BAF96C76AC7EEDA3527AD", hash_generated_field = "DDB41F55144017DF45CBDFA2BC0F1713")

        private Bitmap mLargeIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.952 -0500", hash_original_field = "241BF092BF37739C4026E319271FF945", hash_generated_field = "6D12A8651BB192C0DAA06F0EA6096966")

        private Uri mSound;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.954 -0500", hash_original_field = "4C5123D9443C43500B1E284E75877100", hash_generated_field = "23E53F8B15727619630BFBDD428C50AC")

        private int mAudioStreamType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.955 -0500", hash_original_field = "0C5731420FBEC843FE260BAFD35E182C", hash_generated_field = "38524ACEC28710443D087CB738771292")

        private long[] mVibrate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.957 -0500", hash_original_field = "2B260E6EECD161326DF24C2834643924", hash_generated_field = "ED378C99206AA366647B210684A2CC69")

        private int mLedArgb;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.959 -0500", hash_original_field = "1A78F6517BD1079FACEF481925F66AC5", hash_generated_field = "9314E809E243E9CA0554D760D1F39C4B")

        private int mLedOnMs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.961 -0500", hash_original_field = "008E66A79BE51EBCA38462E35C4201E2", hash_generated_field = "2086D121F2B6FBE20DA7508EDB1FDF3C")

        private int mLedOffMs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.963 -0500", hash_original_field = "BCFC5D1E55F4342ED08DE21A37F30FFF", hash_generated_field = "50F7E57057E924A8C0F1E34C678F82E8")

        private int mDefaults;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.965 -0500", hash_original_field = "4E5A87EA4636A8ACF68875B877F3A7B8", hash_generated_field = "43F71E9173849705E01112D0229448B4")

        private int mFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.967 -0500", hash_original_field = "154C1AE01E9174D6FCDE2326E257A98A", hash_generated_field = "0A6C968C17C3A6387EAAF7CAC0DD4FF2")

        private int mProgressMax;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.969 -0500", hash_original_field = "7CDF5A45863735DC45D655DB7E365343", hash_generated_field = "1CA7BE0C4831604F244183A43ACB7282")

        private int mProgress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.971 -0500", hash_original_field = "58257670235EC509C908CC6AA18E2BF9", hash_generated_field = "EADFE21BB1EEBFEA55A10670C7D88680")

        private boolean mProgressIndeterminate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.974 -0500", hash_original_field = "724E43E35BFDFDBB0F1B182A2CD3E185", hash_generated_field = "D3B03A53A11866B223E845F57CE6E657")

        private ArrayList<String> mKindList = new ArrayList<String>(1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.976 -0500", hash_original_field = "8E33C9E28D87B1286C4160446ABF7B5C", hash_generated_field = "5596C79D633F3A9F64294D3BD6D43156")

        private Bundle mExtras;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.978 -0500", hash_original_field = "1D8CA7654CC48BAF402334392A1619BF", hash_generated_field = "032B46B6D9E42E1E80E269F8E583852A")

        private int mPriority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.980 -0500", hash_original_field = "C774AA94D87CBE3B14EBB6DDDE713AC3", hash_generated_field = "E44BFBE2E092395283B3E85EB151C94D")

        private ArrayList<Action> mActions = new ArrayList<Action>(MAX_ACTION_BUTTONS);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.982 -0500", hash_original_field = "E5AD87F4EB51AC1FD7F0619830E11A22", hash_generated_field = "5C0AE7EF085748F06AFF9CF9732F1F68")

        private boolean mUseChronometer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.984 -0500", hash_original_field = "BF6EEBCC39830720EE9F4EA68F64D795", hash_generated_field = "9E4DD64CD81582FF8CC5E3B414EE2FE9")

        private Style mStyle;

        /**
         * Constructs a new Builder with the defaults:
         *

         * <table>
         * <tr><th align=right>priority</th>
         *     <td>{@link #PRIORITY_DEFAULT}</td></tr>
         * <tr><th align=right>when</th>
         *     <td>now ({@link System#currentTimeMillis()})</td></tr>
         * <tr><th align=right>audio stream</th>
         *     <td>{@link #STREAM_DEFAULT}</td></tr>
         * </table>
         *

         * @param context
         *            A {@link Context} that will be used by the Builder to construct the
         *            RemoteViews. The Context will not be held past the lifetime of this Builder
         *            object.
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.986 -0500", hash_original_method = "8D13ECA788B4551AF81BB4C4463B4695", hash_generated_method = "E58DD9C217F9D6ACD34F127EEFB4AFB1")
        
public Builder(Context context) {
            mContext = context;

            // Set defaults to match the defaults of a Notification
            mWhen = System.currentTimeMillis();
            mAudioStreamType = STREAM_DEFAULT;
            mPriority = PRIORITY_DEFAULT;
        }

        /**
         * Add a timestamp pertaining to the notification (usually the time the event occurred).
         *

         * @see Notification#when
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.988 -0500", hash_original_method = "F33CFE0DDEF1BDE88E81CA07B2B4AF4A", hash_generated_method = "462215F0766F488BA6A62942C8A204F4")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public Builder setWhen(long when) {
            mWhen = when;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.990 -0500", hash_original_method = "4A5E167822B6D75C29D9DB37F3E99418", hash_generated_method = "A5F420386C75A5B918073DA84360DA2A")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public Builder setUsesChronometer(boolean b) {
            mUseChronometer = b;
            return this;
        }

        /**
         * Set the small icon resource, which will be used to represent the notification in the
         * status bar.
         *

         * The platform template for the expanded view will draw this icon in the left, unless a
         * {@link #setLargeIcon(Bitmap) large icon} has also been specified, in which case the small
         * icon will be moved to the right-hand side.
         *

         * @param icon
         *            A resource ID in the application's package of the drawable to use.
         * @see Notification#icon
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.992 -0500", hash_original_method = "76509FA1EC330D1A963F56DC8E00B5D8", hash_generated_method = "0D277F3C63A7802E216A2AFC8D6C9730")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public Builder setSmallIcon(int icon) {
            mSmallIcon = icon;
            return this;
        }

        /**
         * A variant of {@link #setSmallIcon(int) setSmallIcon(int)} that takes an additional
         * level parameter for when the icon is a {@link android.graphics.drawable.LevelListDrawable
         * LevelListDrawable}.
         *
         * @param icon A resource ID in the application's package of the drawable to use.
         * @param level The level to use for the icon.
         *
         * @see Notification#icon
         * @see Notification#iconLevel
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.994 -0500", hash_original_method = "686130331B3575C911C4ACE6437F15B8", hash_generated_method = "7BE460678B06457C86890879443CBA20")
        @DSSafe(DSCat.GUI)
public Builder setSmallIcon(int icon, int level) {
            mSmallIcon = icon;
            mSmallIconLevel = level;
            return this;
        }

        /**
         * Set the first line of text in the platform notification template.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.996 -0500", hash_original_method = "51D215D9B594EB5434D1A4893B0851B6", hash_generated_method = "A24D5A5914321447B8D2056822EB1FA2")
        @DSSafe(DSCat.GUI)
public Builder setContentTitle(CharSequence title) {
            mContentTitle = title;
            return this;
        }

        /**
         * Set the second line of text in the platform notification template.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.998 -0500", hash_original_method = "3B85C73BAA4531891B097F4FBFA7845D", hash_generated_method = "9A0C65143F929FA192B834775CCB4487")
        @DSSafe(DSCat.GUI)
public Builder setContentText(CharSequence text) {
            mContentText = text;
            return this;
        }

        /**
         * Set the third line of text in the platform notification template. 
         * Don't use if you're also using {@link #setProgress(int, int, boolean)}; they occupy the same location in the standard template.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:51.999 -0500", hash_original_method = "C26F306893F3391466019ACD3259C6EA", hash_generated_method = "EFDD1CEF6B67FB9700C23E764FB2F027")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public Builder setSubText(CharSequence text) {
            mSubText = text;
            return this;
        }

        /**
         * Set the large number at the right-hand side of the notification.  This is
         * equivalent to setContentInfo, although it might show the number in a different
         * font size for readability.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.001 -0500", hash_original_method = "5E0FC1F68404C1057ACE1D67E6ED676A", hash_generated_method = "B3B0FB5B636F91DC142A3DAF8586529B")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public Builder setNumber(int number) {
            mNumber = number;
            return this;
        }

        /**
         * A small piece of additional information pertaining to this notification.
         *
         * The platform template will draw this on the last line of the notification, at the far
         * right (to the right of a smallIcon if it has been placed there).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.003 -0500", hash_original_method = "52A8AABE54D5BDFE521B8B41861DFCD9", hash_generated_method = "B7861F042965E1F9AD64C19E28002929")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public Builder setContentInfo(CharSequence info) {
            mContentInfo = info;
            return this;
        }

        /**
         * Set the progress this notification represents.
         *
         * The platform template will represent this using a {@link ProgressBar}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.005 -0500", hash_original_method = "D0B2BE14A572EFF2EC3981BC799BA989", hash_generated_method = "6E0D3C0BC51827EB7CD05EFAE4B7F4F0")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public Builder setProgress(int max, int progress, boolean indeterminate) {
            mProgressMax = max;
            mProgress = progress;
            mProgressIndeterminate = indeterminate;
            return this;
        }

        /**
         * Supply a custom RemoteViews to use instead of the platform template.
         *
         * @see Notification#contentView
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.007 -0500", hash_original_method = "0C2B2238CAAAD5F7B913F4DC0C6DE3C5", hash_generated_method = "5B3D68ED2EFD46DD220E26D0592B30A0")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public Builder setContent(RemoteViews views) {
            mContentView = views;
            return this;
        }

        /**
         * Supply a {@link PendingIntent} to be sent when the notification is clicked.
         *
         * As of {@link android.os.Build.VERSION_CODES#HONEYCOMB}, if this field is unset and you
         * have specified a custom RemoteViews with {@link #setContent(RemoteViews)}, you can use
         * {@link RemoteViews#setOnClickPendingIntent RemoteViews.setOnClickPendingIntent(int,PendingIntent)}
         * to assign PendingIntents to individual views in that custom layout (i.e., to create
         * clickable buttons inside the notification view).
         *
         * @see Notification#contentIntent Notification.contentIntent
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.009 -0500", hash_original_method = "13AF9850EB916E3E1CD09235309F6318", hash_generated_method = "35B80BF912DA7A0FF8C66DE39967BF3A")
        @DSVerified
        @DSSpec(DSCat.INTENT_EXCHANGE)
public Builder setContentIntent(PendingIntent intent) {
            mContentIntent = intent;
            return this;
        }

        /**
         * Supply a {@link PendingIntent} to send when the notification is cleared explicitly by the user.
         *
         * @see Notification#deleteIntent
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.011 -0500", hash_original_method = "F48B9AE94AA7354563811F0226E4C56E", hash_generated_method = "8D93DDA997FE2AC23B46EB665D4A92D6")
        @DSVerified
        @DSSpec(DSCat.INTENT_EXCHANGE)
public Builder setDeleteIntent(PendingIntent intent) {
            mDeleteIntent = intent;
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
         *
         * @see Notification#fullScreenIntent
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.014 -0500", hash_original_method = "CE5C618F1F516DEBBF5EC70FA84B35B1", hash_generated_method = "755C86B6B43CC915477EC577352C1178")
        @DSVerified
        @DSSpec(DSCat.INTENT_EXCHANGE)
public Builder setFullScreenIntent(PendingIntent intent, boolean highPriority) {
            mFullScreenIntent = intent;
            setFlag(FLAG_HIGH_PRIORITY, highPriority);
            return this;
        }

        /**
         * Set the "ticker" text which is displayed in the status bar when the notification first
         * arrives.
         *
         * @see Notification#tickerText
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.016 -0500", hash_original_method = "43D2B64A31B6B61BB554BA691C460973", hash_generated_method = "BA5CC1E40ED071B70C559774088DB95D")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public Builder setTicker(CharSequence tickerText) {
            mTickerText = tickerText;
            return this;
        }

        /**
         * Set the text that is displayed in the status bar when the notification first
         * arrives, and also a RemoteViews object that may be displayed instead on some
         * devices.
         *
         * @see Notification#tickerText
         * @see Notification#tickerView
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.018 -0500", hash_original_method = "4C6C26DEDB76E0CF44BFBAEE6FBE84BC", hash_generated_method = "EABCCA368461A451025B190C894608A1")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public Builder setTicker(CharSequence tickerText, RemoteViews views) {
            mTickerText = tickerText;
            mTickerView = views;
            return this;
        }

        /**
         * Add a large icon to the notification (and the ticker on some devices).
         *
         * In the platform template, this image will be shown on the left of the notification view
         * in place of the {@link #setSmallIcon(int) small icon} (which will move to the right side).
         *
         * @see Notification#largeIcon
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.020 -0500", hash_original_method = "7DCB1EA67ACA56F0B2754C8E360CAB68", hash_generated_method = "DF7C31C82F00E2DCBBC8B9EA70CE883E")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public Builder setLargeIcon(Bitmap icon) {
            mLargeIcon = icon;
            return this;
        }

        /**
         * Set the sound to play.
         *
         * It will be played on the {@link #STREAM_DEFAULT default stream} for notifications.
         *
         * @see Notification#sound
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.022 -0500", hash_original_method = "E4D966D2AF4F815A75885EB0928B9225", hash_generated_method = "CE1C0A650DF510A9AD918A877BE1399D")
        @DSVerified
        @DSSpec(DSCat.URI_EXCHANGE)
public Builder setSound(Uri sound) {
            mSound = sound;
            mAudioStreamType = STREAM_DEFAULT;
            return this;
        }

        /**
         * Set the sound to play, along with a specific stream on which to play it.
         *
         * See {@link android.media.AudioManager} for the <code>STREAM_</code> constants.
         *
         * @see Notification#sound
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.024 -0500", hash_original_method = "2D9F8E95A20AD7FBCF7EC4A8FF50BED5", hash_generated_method = "B9338971A1DDEC2DE784E4EFB4492165")
        @DSVerified
        @DSSpec(DSCat.URI_EXCHANGE)
public Builder setSound(Uri sound, int streamType) {
            mSound = sound;
            mAudioStreamType = streamType;
            return this;
        }

        /**
         * Set the vibration pattern to use.
         *

         * See {@link android.os.Vibrator#vibrate(long[], int)} for a discussion of the
         * <code>pattern</code> parameter.
         *

         * @see Notification#vibrate
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.026 -0500", hash_original_method = "A86D234FAB504C5B3A4DEC6712517174", hash_generated_method = "5597004A27277A950C64200D68BFB2EF")   
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
        
public Builder setVibrate(long[] pattern) {
            mVibrate = pattern;
            return this;
        }

        /**
         * Set the desired color for the indicator LED on the device, as well as the
         * blink duty cycle (specified in milliseconds).
         *

         * Not all devices will honor all (or even any) of these values.
         *

         * @see Notification#ledARGB
         * @see Notification#ledOnMS
         * @see Notification#ledOffMS
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.027 -0500", hash_original_method = "06C76CABA696566E00D48B5A1D10E8B9", hash_generated_method = "E3E4E0641FEBABF496C0AC26F936580C")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public Builder setLights(int argb, int onMs, int offMs) {
            mLedArgb = argb;
            mLedOnMs = onMs;
            mLedOffMs = offMs;
            return this;
        }

        /**
         * Set whether this is an "ongoing" notification.
         *

         * Ongoing notifications cannot be dismissed by the user, so your application or service
         * must take care of canceling them.
         *

         * They are typically used to indicate a background task that the user is actively engaged
         * with (e.g., playing music) or is pending in some way and therefore occupying the device
         * (e.g., a file download, sync operation, active network connection).
         *

         * @see Notification#FLAG_ONGOING_EVENT
         * @see Service#setForeground(boolean)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.029 -0500", hash_original_method = "4EE6022E7B7D173E4F9ABC4B52771BC1", hash_generated_method = "671AF519B4B27404AF7E78213CF4A007")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public Builder setOngoing(boolean ongoing) {
            setFlag(FLAG_ONGOING_EVENT, ongoing);
            return this;
        }

        /**
         * Set this flag if you would only like the sound, vibrate
         * and ticker to be played if the notification is not already showing.
         *
         * @see Notification#FLAG_ONLY_ALERT_ONCE
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.031 -0500", hash_original_method = "19CD7AC7B316FEB13981077CC28EC4D6", hash_generated_method = "70FF1E8C9918C2B7950EC85FE754295E")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public Builder setOnlyAlertOnce(boolean onlyAlertOnce) {
            setFlag(FLAG_ONLY_ALERT_ONCE, onlyAlertOnce);
            return this;
        }

        /**
         * Make this notification automatically dismissed when the user touches it. The
         * PendingIntent set with {@link #setDeleteIntent} will be sent when this happens.
         *
         * @see Notification#FLAG_AUTO_CANCEL
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.033 -0500", hash_original_method = "65E737424C5371C7C5FE30C163FA340D", hash_generated_method = "B63710FD1ED81D7AB16D9F7832BB4374")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public Builder setAutoCancel(boolean autoCancel) {
            setFlag(FLAG_AUTO_CANCEL, autoCancel);
            return this;
        }

        /**
         * Set which notification properties will be inherited from system defaults.
         * <p>
         * The value should be one or more of the following fields combined with
         * bitwise-or:
         * {@link #DEFAULT_SOUND}, {@link #DEFAULT_VIBRATE}, {@link #DEFAULT_LIGHTS}.
         * <p>
         * For all default values, use {@link #DEFAULT_ALL}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.035 -0500", hash_original_method = "413289369D1534DD93CD0DF6E13619C0", hash_generated_method = "B80FCD5DED599909786CAFAB131C81C7")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public Builder setDefaults(int defaults) {
            mDefaults = defaults;
            return this;
        }

        /**
         * Set the priority of this notification.
         *
         * @see Notification#priority
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.037 -0500", hash_original_method = "D6FC2F5B6F218671B1949A4E949DE979", hash_generated_method = "2760D644FDBC0BBE5AF170A7AF2DBC82")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public Builder setPriority(int pri) {
            mPriority = pri;
            return this;
        }
        
        /**
         * @hide
         * 
         * Add a kind (category) to this notification. Optional.
         * 
         * @see Notification#kind
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.039 -0500", hash_original_method = "CD54814FFD21D4F516E48F04C422932C", hash_generated_method = "A6B8A79D5EAA91C2819409B423821CC2")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public Builder addKind(String k) {
            mKindList.add(k);
            return this;
        }

        /**
         * Add metadata to this notification.
         *
         * A reference to the Bundle is held for the lifetime of this Builder, and the Bundle's
         * current contents are copied into the Notification each time {@link #build()} is
         * called.
         *
         * @see Notification#extras
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.041 -0500", hash_original_method = "4868278BD385EF7B0520D99975ABC6AF", hash_generated_method = "54D00924B63F2A5BE168392A9AD39FD2")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public Builder setExtras(Bundle bag) {
            mExtras = bag;
            return this;
        }

        /**
         * Add an action to this notification. Actions are typically displayed by
         * the system as a button adjacent to the notification content.
         *
         * @param icon Resource ID of a drawable that represents the action.
         * @param title Text describing the action.
         * @param intent PendingIntent to be fired when the action is invoked.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.043 -0500", hash_original_method = "C1AEFCF07C54675630502E6755AA07D6", hash_generated_method = "5767BA2A6AF4B610049058360B51B14F")
        @DSVerified
        @DSSpec(DSCat.INTENT_EXCHANGE)
public Builder addAction(int icon, CharSequence title, PendingIntent intent) {
            mActions.add(new Action(icon, title, intent));
            return this;
        }

        /**
         * Add a rich notification style to be applied at build time.
         *
         * @param style Object responsible for modifying the notification style.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.045 -0500", hash_original_method = "406467D1A4DC4F76367925F19B2DC0D5", hash_generated_method = "D91978C69CA35AC51CCC000004D985CD")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public Builder setStyle(Style style) {
            if (mStyle != style) {
                mStyle = style;
                if (mStyle != null) {
                    mStyle.setBuilder(this);
                }
            }
            return this;
        }

        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.047 -0500", hash_original_method = "100CC04F928443BDDD1350B26299D2DB", hash_generated_method = "0BC7EE29E2E86D930BE9DB77ED7692C9")
        
private void setFlag(int mask, boolean value) {
            if (value) {
                mFlags |= mask;
            } else {
                mFlags &= ~mask;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.050 -0500", hash_original_method = "8966732C07D82BFEB0CF968B52428E72", hash_generated_method = "FB61F6A7E49DF467B3A9A724B29FFC6A")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private RemoteViews applyStandardTemplate(int resId, boolean fitIn1U) {
            RemoteViews contentView = new RemoteViews(mContext.getPackageName(), resId);
            boolean showLine3 = false;
            boolean showLine2 = false;
            int smallIconImageViewId = R.id.icon;
            if (mLargeIcon != null) {
                contentView.setImageViewBitmap(R.id.icon, mLargeIcon);
                smallIconImageViewId = R.id.right_icon;
            }
            
            if (mSmallIcon != 0) {
                contentView.setImageViewResource(smallIconImageViewId, mSmallIcon);
                contentView.setViewVisibility(smallIconImageViewId, View.VISIBLE);
            } else {
                contentView.setViewVisibility(smallIconImageViewId, View.GONE);
            }
            if (mContentTitle != null) {
                contentView.setTextViewText(R.id.title, mContentTitle);
            }
            if (mContentText != null) {
                contentView.setTextViewText(R.id.text, mContentText);
                showLine3 = true;
            }
            if (mContentInfo != null) {
                contentView.setTextViewText(R.id.info, mContentInfo);
                contentView.setViewVisibility(R.id.info, View.VISIBLE);
                showLine3 = true;
            } else if (mNumber > 0) {
                final int tooBig = mContext.getResources().getInteger(
                        R.integer.status_bar_notification_info_maxnum);
                if (mNumber > tooBig) {
                    contentView.setTextViewText(R.id.info, mContext.getResources().getString(
                                R.string.status_bar_notification_info_overflow));
                } else {
                    NumberFormat f = NumberFormat.getIntegerInstance();
                    contentView.setTextViewText(R.id.info, f.format(mNumber));
                }
                contentView.setViewVisibility(R.id.info, View.VISIBLE);
                showLine3 = true;
            } else {
                contentView.setViewVisibility(R.id.info, View.GONE);
            }

            // Need to show three lines?
            if (mSubText != null) {
                contentView.setTextViewText(R.id.text, mSubText);
                if (mContentText != null) {
                    contentView.setTextViewText(R.id.text2, mContentText);
                    contentView.setViewVisibility(R.id.text2, View.VISIBLE);
                    showLine2 = true;
                } else {
                    contentView.setViewVisibility(R.id.text2, View.GONE);
                }
            } else {
                contentView.setViewVisibility(R.id.text2, View.GONE);
                if (mProgressMax != 0 || mProgressIndeterminate) {
                    contentView.setProgressBar(
                            R.id.progress, mProgressMax, mProgress, mProgressIndeterminate);
                    contentView.setViewVisibility(R.id.progress, View.VISIBLE);
                    showLine2 = true;
                } else {
                    contentView.setViewVisibility(R.id.progress, View.GONE);
                }
            }
            contentView.setViewVisibility(R.id.line3, showLine3 ? View.VISIBLE : View.GONE);
            return contentView;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.052 -0500", hash_original_method = "873701E16362975B365115C07E74C4B4", hash_generated_method = "F069DEABA5E30CA699258F0F258C70B3")
        
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private RemoteViews applyStandardTemplateWithActions(int layoutId) {
            RemoteViews big = applyStandardTemplate(layoutId, false);

            int N = mActions.size();
            if (N > 0) {
                // Log.d("Notification", "has actions: " + mContentText);
                big.setViewVisibility(DSUtils.FAKE_INT, View.VISIBLE);
                if (N>MAX_ACTION_BUTTONS) N=MAX_ACTION_BUTTONS;
                big.removeAllViews(DSUtils.FAKE_INT);
                for (int i=0; i<N; i++) {
                    final RemoteViews button = generateActionButton(mActions.get(i));
                    //Log.d("Notification", "adding action " + i + ": " + mActions.get(i).title);
                    big.addView(DSUtils.FAKE_INT, button);
                }
            }
            return big;
        }

        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.055 -0500", hash_original_method = "C22AEC1D0FF4C923CEE0913C9CAA4A96", hash_generated_method = "1E50DB92FFD69533D9918EB3C9090118")
        
private RemoteViews makeContentView() {
            if (mContentView != null) {
                return mContentView;
            } else {
                return applyStandardTemplate(DSUtils.FAKE_INT, true); // no more special large_icon flavor
            }
        }

        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.057 -0500", hash_original_method = "D12D80B604E0F5E48AF4948B944489F8", hash_generated_method = "EE7E7EC60CF0F99EDEC9A9FBA709E5E4")
        
private RemoteViews makeTickerView() {
            if (mTickerView != null) {
                return mTickerView;
            } else {
                if (mContentView == null) {
                    return applyStandardTemplate(mLargeIcon == null
                            ? R.layout.status_bar_latest_event_ticker
                            : R.layout.status_bar_latest_event_ticker_large_icon, true);
                } else {
                    return null;
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.059 -0500", hash_original_method = "BED315423D58AECA57C6E2C8A53883C0", hash_generated_method = "C7848C45BEE930B13DAEA3CBACA76181")
        
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private RemoteViews makeBigContentView() {
            if (mActions.size() == 0) return null;

            RemoteViews views = applyStandardTemplateWithActions(DSUtils.FAKE_INT);
            views.addTaint(mActions.size());
            return views;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.061 -0500", hash_original_method = "844D05C6031B677F492F5AA75F21CC3E", hash_generated_method = "B6ACDFC267242CB93669567AB7D7C323")
        
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private RemoteViews generateActionButton(Action action) {
            final boolean tombstone = (action.actionIntent == null);
            RemoteViews button = new RemoteViews(mContext.getPackageName(), DSUtils.FAKE_INT);
            button.setTextViewText(DSUtils.FAKE_INT, action.title);
            if (!tombstone) {
                button.setOnClickPendingIntent(DSUtils.FAKE_INT, action.actionIntent);
            }
            button.setContentDescription(DSUtils.FAKE_INT, action.title);
            return button;
        }

        /**
         * Apply the unstyled operations and return a new {@link Notification} object.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.063 -0500", hash_original_method = "554D755489FA8B11C1C6C72EBE6520E4", hash_generated_method = "B44C188046F620585A69BDAD16EA986B")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private Notification buildUnstyled() {
            Notification n = new Notification();
            n.when = mWhen;
            n.icon = mSmallIcon;
            n.iconLevel = mSmallIconLevel;
            n.number = mNumber;
            n.contentView = makeContentView();
            n.contentIntent = mContentIntent;
            n.deleteIntent = mDeleteIntent;
            n.fullScreenIntent = mFullScreenIntent;
            n.tickerText = mTickerText;
            n.tickerView = makeTickerView();
            n.largeIcon = mLargeIcon;
            n.sound = mSound;
            n.audioStreamType = mAudioStreamType;
            n.vibrate = mVibrate;
            n.ledARGB = mLedArgb;
            n.ledOnMS = mLedOnMs;
            n.ledOffMS = mLedOffMs;
            n.defaults = mDefaults;
            n.flags = mFlags;
            n.bigContentView = makeBigContentView();
            if (mLedOnMs != 0 && mLedOffMs != 0) {
                n.flags |= FLAG_SHOW_LIGHTS;
            }
            if ((mDefaults & DEFAULT_LIGHTS) != 0) {
                n.flags |= FLAG_SHOW_LIGHTS;
            }
            if (mKindList.size() > 0) {
                n.kind = new String[mKindList.size()];
                mKindList.toArray(n.kind);
            } else {
                n.kind = null;
            }
            n.priority = mPriority;
            n.extras = mExtras != null ? new Bundle(mExtras) : null;
            if (mActions.size() > 0) {
                n.actions = new Action[mActions.size()];
                mActions.toArray(n.actions);
            }
            return n;
        }

        /**
         * @deprecated Use {@link #build()} instead.
         */
        @DSSafe(DSCat.UTIL_FUNCTION)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.065 -0500", hash_original_method = "5752A873E7B6FE6901D822366F1E539B", hash_generated_method = "F7D2E55096D0FEE79BDB70A7F86C3B7A")
        
@Deprecated
        public Notification getNotification() {
            return build();
        }

        /**
         * Combine all of the options that have been set and return a new {@link Notification}
         * object.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.067 -0500", hash_original_method = "44CD8AEF566FDE96E19B7F5B8548292B", hash_generated_method = "08C980AD1B7923A4ABD705163FB2485F")
        @DSComment("Result intent is tracked at setContentIntent")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public Notification build() {
            if (mStyle != null) {
                return mStyle.build();
            } else {
                return buildUnstyled();
            }
        }
    }

    /**
     * An object that can apply a rich notification style to a {@link Notification.Builder}
     * object.
     */
    public static abstract class Style
    {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.076 -0500", hash_original_field = "A8763C6869FFC8B14632509B5951CF78", hash_generated_field = "85D5B8D0848FD7F5C1DCDF8039E8DF55")

        private CharSequence mBigContentTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.078 -0500", hash_original_field = "49DB87300FC9A4B8E5C27D30D79DA9CB", hash_generated_field = "D4B41F3678E87356954AA050A3A0C5C1")

        private CharSequence mSummaryText = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.079 -0500", hash_original_field = "15DCEA0D59F8A2D571FFA203A984A6EA", hash_generated_field = "8E5B3E43DD10E76CFF93006E050F04B2")

        private boolean mSummaryTextSet = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.081 -0500", hash_original_field = "3B47D3828F6C58841CAAA5CDF159598A", hash_generated_field = "28C04D2B42C13315666113C88915928C")

        protected Builder mBuilder;

        @DSComment("Explicitly added ")
        @DSSafe(DSCat.SAFE_OTHERS)
        protected Style() {}
        /**
         * Overrides ContentTitle in the big form of the template.
         * This defaults to the value passed to setContentTitle().
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.083 -0500", hash_original_method = "0069D05EF4E07DC2DB6EC9515621E07D", hash_generated_method = "3A78DB14E4810748A6A48616D684D8DB")
        
protected void internalSetBigContentTitle(CharSequence title) {
            mBigContentTitle = title;
        }

        /**
         * Set the first line of text after the detail section in the big form of the template.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.085 -0500", hash_original_method = "A96A9937BB76E0BD27C4FC86C6D11E61", hash_generated_method = "BEE1B6BC2C8A6497765FFD9C2ED881CF")
        
protected void internalSetSummaryText(CharSequence cs) {
            mSummaryText = cs;
            mSummaryTextSet = true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.086 -0500", hash_original_method = "4E1C32047BCF7D8F068B78C0497D3581", hash_generated_method = "081150EA520A397F53CAE43E2D1E4362")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public void setBuilder(Builder builder) {
            if (mBuilder != builder) {
                mBuilder = builder;
                if (mBuilder != null) {
                    mBuilder.setStyle(this);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.089 -0500", hash_original_method = "6F4C3954C5993D592C3BCEDA796BE48A", hash_generated_method = "88440A8B759C791131FB4200CFE2D400")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
protected void checkBuilder() {
            if (mBuilder == null) {
                throw new IllegalArgumentException("Style requires a valid Builder object");
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.091 -0500", hash_original_method = "9236A6B3C6EC711D47EA2069BAC458A1", hash_generated_method = "2A9A6C8424E6217E146ABCB5C2B16781")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS) 
protected RemoteViews getStandardView(int layoutId) {
            checkBuilder();

            if (mBigContentTitle != null) {
                mBuilder.setContentTitle(mBigContentTitle);
            }

            RemoteViews contentView = mBuilder.applyStandardTemplateWithActions(layoutId);

            if (mBigContentTitle != null && mBigContentTitle.equals("")) {
                contentView.setViewVisibility(R.id.line1, View.GONE);
            } else {
                contentView.setViewVisibility(R.id.line1, View.VISIBLE);
            }

            // The last line defaults to the subtext, but can be replaced by mSummaryText
            final CharSequence overflowText =
                    mSummaryTextSet ? mSummaryText
                                    : mBuilder.mSubText;
            if (overflowText != null) {
                contentView.setTextViewText(R.id.text, overflowText);
                contentView.setViewVisibility(R.id.line3, View.VISIBLE);
            } else {
                contentView.setViewVisibility(R.id.line3, View.GONE);
            }

            return contentView;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.093 -0500", hash_original_method = "933B39910D83C4B9AAEA118AAE9F98CD", hash_generated_method = "351AD00B15737531D7F2B87CB4E473A1")
        @DSSpec(DSCat.ABSTRACT_METHOD) 
        public abstract Notification build();
    }

    /**
     * Helper class for generating large-format notifications that include a large image attachment.
     * 
     * This class is a "rebuilder": It consumes a Builder object and modifies its behavior, like so:
     * <pre class="prettyprint">
     * Notification noti = new Notification.BigPictureStyle(
     *      new Notification.Builder()
     *         .setContentTitle(&quot;New photo from &quot; + sender.toString())
     *         .setContentText(subject)
     *         .setSmallIcon(R.drawable.new_post)
     *         .setLargeIcon(aBitmap))
     *      .bigPicture(aBigBitmap)
     *      .build();
     * </pre>
     * 
     * @see Notification#bigContentView
     */
    public static class BigPictureStyle extends Style {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.096 -0500", hash_original_field = "6750422543F06EDF58D4C058AEB2FB0B", hash_generated_field = "E6D6855716AB43E81EA5F8B8C4B043BC")

        private Bitmap mPicture;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.098 -0500", hash_original_field = "EBFCAC2315FBBB7C14F685CAA0679FAF", hash_generated_field = "A4C6C3647F0C1884D11BC1854CCEB3F5")

        private Bitmap mBigLargeIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.101 -0500", hash_original_field = "EAF2CEDF23339261F7D712F7758F7654", hash_generated_field = "B219C09A78C31C05FECF7A9CE3C195AC")

        private boolean mBigLargeIconSet = false;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.102 -0500", hash_original_method = "3B87A1538500BE0C4C4429E052CFAA59", hash_generated_method = "4FDCC0CD821A1D50EE7ABFB7CDF9BF0D")
        @DSComment("Constructor")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public BigPictureStyle() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.104 -0500", hash_original_method = "0498487B5309A9A12671436B756C1E14", hash_generated_method = "6F3C9023FAD5F605D40C31BDFA9E311D")
        @DSComment("Constructor")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }

        /**
         * Overrides ContentTitle in the big form of the template.
         * This defaults to the value passed to setContentTitle().
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.106 -0500", hash_original_method = "E640F2CD5B1AC04D0CC5412EFDD23707", hash_generated_method = "064855196CFC6D554BB8C08DAE6C8407")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public BigPictureStyle setBigContentTitle(CharSequence title) {
            internalSetBigContentTitle(title);
            return this;
        }

        /**
         * Set the first line of text after the detail section in the big form of the template.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.108 -0500", hash_original_method = "1FEBC62DA5C2D9A56CBE7EF0E57933AE", hash_generated_method = "2516FDF60FF8917F75C678D4BFF7F162")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public BigPictureStyle setSummaryText(CharSequence cs) {
            internalSetSummaryText(cs);
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.110 -0500", hash_original_method = "5AF1E04BCC74B8D2EC1A6821C26FF824", hash_generated_method = "A174A09EA1458548215A942B68AB9F96")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public BigPictureStyle bigPicture(Bitmap b) {
            mPicture = b;
            return this;
        }

        /**
         * Override the large icon when the big notification is shown.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.112 -0500", hash_original_method = "2D72AAC387D86E28AC4175663F321330", hash_generated_method = "EB612C60FBC83512F117123AA8F352E7")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public BigPictureStyle bigLargeIcon(Bitmap b) {
            mBigLargeIconSet = true;
            mBigLargeIcon = b;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.113 -0500", hash_original_method = "50B1EB42BE6F3C6216D026D7EEEA3BBD", hash_generated_method = "77C688A6A6113DA637BC54E4FC0B78AC")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
private RemoteViews makeBigContentView() {
            RemoteViews contentView = getStandardView(DSUtils.FAKE_INT);
            contentView.setImageViewBitmap(DSUtils.FAKE_INT, mPicture);

            return contentView;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.115 -0500", hash_original_method = "062FD04A8221789AD50FDA6940601200", hash_generated_method = "969648AE89CA274F7EA2AEFA45B207D5")
        
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
@Override
        public Notification build() {
            checkBuilder();
            Notification wip = mBuilder.buildUnstyled();
            if (mBigLargeIconSet ) {
                mBuilder.mLargeIcon = mBigLargeIcon;
            }
            wip.bigContentView = makeBigContentView();
            return wip;
        }
    }

    /**
     * Helper class for generating large-format notifications that include a lot of text.
     * 
     * This class is a "rebuilder": It consumes a Builder object and modifies its behavior, like so:
     * <pre class="prettyprint">
     * Notification noti = new Notification.BigPictureStyle(
     *      new Notification.Builder()
     *         .setContentTitle(&quot;New mail from &quot; + sender.toString())
     *         .setContentText(subject)
     *         .setSmallIcon(R.drawable.new_mail)
     *         .setLargeIcon(aBitmap))
     *      .bigText(aVeryLongString)
     *      .build();
     * </pre>
     * 
     * @see Notification#bigContentView
     */
    public static class BigTextStyle extends Style {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.119 -0500", hash_original_field = "E500F2A8027C62CBBA6A62AA4FA3AE40", hash_generated_field = "D597AC05EC08A46C183AA39481D1B2BE")

        private CharSequence mBigText;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.121 -0500", hash_original_method = "FC2708C6265D9EFE6897BC23F510F3F6", hash_generated_method = "FE81B60BDDB4B029BF42CF95CA1BDD48")
        @DSVerified("Constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
public BigTextStyle() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.123 -0500", hash_original_method = "73900B5FBB9070B76B44EF3B18688CFC", hash_generated_method = "4420807CCC9D24ED02C6AE6DD2BEA35E")
        @DSVerified("Constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }

        /**
         * Overrides ContentTitle in the big form of the template.
         * This defaults to the value passed to setContentTitle().
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.124 -0500", hash_original_method = "D2F00DD99E8199F7927585A6852C46B7", hash_generated_method = "B1A34A2A82B861AEAA9B1D0E84929C9A")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public BigTextStyle setBigContentTitle(CharSequence title) {
            internalSetBigContentTitle(title);
            return this;
        }

        /**
         * Set the first line of text after the detail section in the big form of the template.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.126 -0500", hash_original_method = "4E7931DFB32ACA38ABEB6070AB9FE046", hash_generated_method = "2B55DDF381A8AA0C48EFE386CFF54A01")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public BigTextStyle setSummaryText(CharSequence cs) {
            internalSetSummaryText(cs);
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.128 -0500", hash_original_method = "C0F673F76D8079C9E17C18062828FDEA", hash_generated_method = "617239A85614B4FE9C6A1DE7636D599F")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)        
public BigTextStyle bigText(CharSequence cs) {
            mBigText = cs;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.131 -0500", hash_original_method = "8EC8C5C26EAC72CD93479A7E779240DF", hash_generated_method = "855363BF5849D2312D880A9AB02432C0")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
private RemoteViews makeBigContentView() {
            // Remove the content text so line3 only shows if you have a summary
            final boolean hadThreeLines = (mBuilder.mContentText != null && mBuilder.mSubText != null);
            mBuilder.mContentText = null;

            RemoteViews contentView = getStandardView(DSUtils.FAKE_INT);
            
            if (hadThreeLines) {
                // vertical centering
            }

            contentView.setTextViewText(DSUtils.FAKE_INT, mBigText);
            contentView.setViewVisibility(DSUtils.FAKE_INT, View.VISIBLE);
            contentView.setViewVisibility(R.id.text2, View.GONE);

            return contentView;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.133 -0500", hash_original_method = "E20005A9004B9B510CA3A007795434A6", hash_generated_method = "F9D80E6A4EC940CD2623DF30097FAC1C")
        @DSVerified
        //@DSSafe(DSCat.DATA_STRUCTURE)
        @DSSpec(DSCat.SPEC_OTHERS)
@Override
        public Notification build() {
            checkBuilder();
            Notification wip = mBuilder.buildUnstyled();
            wip.bigContentView = makeBigContentView();
            return wip;
        }
    }

    /**
     * Helper class for generating large-format notifications that include a list of (up to 5) strings.
     * 
     * This class is a "rebuilder": It consumes a Builder object and modifies its behavior, like so:
     * <pre class="prettyprint">
     * Notification noti = new Notification.InboxStyle(
     *      new Notification.Builder()
     *         .setContentTitle(&quot;5 New mails from &quot; + sender.toString())
     *         .setContentText(subject)
     *         .setSmallIcon(R.drawable.new_mail)
     *         .setLargeIcon(aBitmap))
     *      .addLine(str1)
     *      .addLine(str2)
     *      .setContentTitle("")
     *      .setSummaryText(&quot;+3 more&quot;)
     *      .build();
     * </pre>
     * 
     * @see Notification#bigContentView
     */
    public static class InboxStyle extends Style {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.136 -0500", hash_original_field = "DDA4AB59A466C0A2E22B9749C201C223", hash_generated_field = "499932FA5CE83D467E3DDA7C6E2BE4A8")

        private ArrayList<CharSequence> mTexts = new ArrayList<CharSequence>(5);

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.138 -0500", hash_original_method = "77F8D142994117520A51F39629CB98C2", hash_generated_method = "954D22E14DF17F2BAAE07500DB83F30E")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public InboxStyle() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.140 -0500", hash_original_method = "2627A8164807341FF83179568E6D44EE", hash_generated_method = "19F10E557ADDB0E1149367FF622106CD")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public InboxStyle(Builder builder) {
            setBuilder(builder);
        }

        /**
         * Overrides ContentTitle in the big form of the template.
         * This defaults to the value passed to setContentTitle().
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.142 -0500", hash_original_method = "DED53C6C97CBAC4C2523CA519F3D60D8", hash_generated_method = "644EC6CCE079E178746E2E8E8B23F2FD")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public InboxStyle setBigContentTitle(CharSequence title) {
            internalSetBigContentTitle(title);
            return this;
        }

        /**
         * Set the first line of text after the detail section in the big form of the template.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.143 -0500", hash_original_method = "7E1B18A0E9DC7092B942BFB58DF923CD", hash_generated_method = "4F13CAE2105C1B3583B5E5F82319B352")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public InboxStyle setSummaryText(CharSequence cs) {
            internalSetSummaryText(cs);
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.146 -0500", hash_original_method = "4A24CF50FAD49F68396B9687C7D6208C", hash_generated_method = "5CEAFD8985071C87987A8E6DDC37270E")
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
public InboxStyle addLine(CharSequence cs) {
            mTexts.add(cs);
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.148 -0500", hash_original_method = "D584D52ECEF0D6B357AB1C81F6F0428D", hash_generated_method = "3EFD1E8C798D95CBBAFE000917CF17D6")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
        private RemoteViews makeBigContentView() {
            // Remove the content text so line3 disappears unless you have a summary
            mBuilder.mContentText = null;
            RemoteViews contentView = getStandardView(DSUtils.FAKE_INT);

            contentView.setViewVisibility(R.id.text2, View.GONE);
            
            return contentView;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 23:22:52.150 -0500", hash_original_method = "E20005A9004B9B510CA3A007795434A6", hash_generated_method = "F9D80E6A4EC940CD2623DF30097FAC1C")
        @DSVerified
        //@DSSafe(DSCat.DATA_STRUCTURE)
        @DSSpec(DSCat.SPEC_OTHERS)
@Override
        public Notification build() {
            checkBuilder();
            Notification wip = mBuilder.buildUnstyled();
            wip.bigContentView = makeBigContentView();
            return wip;
        }
    }
}
