package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.NumberFormat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RemoteViews;

import com.android.internal.R;

public class Notification implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.239 -0500", hash_original_field = "5BB1F14B760B289DD56199D40503C3B2", hash_generated_field = "493D0EBDAE7097F899550C884AC22A2C")

    public static final int DEFAULT_ALL = ~0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.241 -0500", hash_original_field = "D79104ECE84D6D4275C13967C6005A2E", hash_generated_field = "EBEB29EEA1677186411B0676C7CB6CA8")
 
    public static final int DEFAULT_SOUND = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.243 -0500", hash_original_field = "95B20DBB35ADD5F8D1A6B5695AD65EF9", hash_generated_field = "625958CF78DAC59C5F668018906E7A25")
 
    public static final int DEFAULT_VIBRATE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.246 -0500", hash_original_field = "8A1328AA01C36B0B93081D26982FFB84", hash_generated_field = "08672983F6AA38AE8CB005A3B0951E14")
 
    public static final int DEFAULT_LIGHTS = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.274 -0500", hash_original_field = "2343A4818416EB4EF29D708D4FB72871", hash_generated_field = "03418D428EB9B0647508E7584179BDCC")

    public static final int STREAM_DEFAULT = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.290 -0500", hash_original_field = "0684D63406D7C99A7541248AB6E9C0D0", hash_generated_field = "3EA71E6BEF191625FDE53FA428627FCD")

    public static final int FLAG_SHOW_LIGHTS        = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.292 -0500", hash_original_field = "9DAC33CF709813C30F3B2B60194916AE", hash_generated_field = "4212FDC8E3576C78F889BF1A169268A1")

    public static final int FLAG_ONGOING_EVENT      = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.295 -0500", hash_original_field = "B414B9AEFD0AD0FCC87E9A3CB2DB53C1", hash_generated_field = "5E4C5667DCB9D60C104C3E79AF4A4C18")

    public static final int FLAG_INSISTENT          = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.297 -0500", hash_original_field = "F0E3A1D373D7B22039D7949B0A68B528", hash_generated_field = "500F040419409BB73C946F7E5EAF73E0")

    public static final int FLAG_ONLY_ALERT_ONCE    = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.300 -0500", hash_original_field = "8F195662E2B680AAE53B06D576F2B913", hash_generated_field = "E5EB78F93DFB40825F4ED628FB1B6DFC")

    public static final int FLAG_AUTO_CANCEL        = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.303 -0500", hash_original_field = "A743B955AF96295F560A6C4F23A29FA0", hash_generated_field = "EC8515FDF436BE99F3787638E8918138")

    public static final int FLAG_NO_CLEAR           = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.305 -0500", hash_original_field = "EAE7FBAC18351788C2008C881DE10CF8", hash_generated_field = "4891EB5C3AD9C34A5B31934636D873FF")

    public static final int FLAG_FOREGROUND_SERVICE = 0x00000040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.308 -0500", hash_original_field = "BAD7EC250F31466E61BD0FB6EB820337", hash_generated_field = "922B7B86CB8DA2C0A66A1F85C3129923")

    public static final int FLAG_HIGH_PRIORITY = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.317 -0400", hash_original_field = "50F431254E99137F341327FC6639553A", hash_generated_field = "4FA917F3775D815CA3B6257FE54BF16E")

    public static final Parcelable.Creator<Notification> CREATOR
            = new Parcelable.Creator<Notification>()
    {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.333 -0500", hash_original_method = "640E6F5E88B10B67950DC22B82259969", hash_generated_method = "DBA7908684BF656EA8BA45DF5B36E06D")
        
public Notification createFromParcel(Parcel parcel)
        {
            return new Notification(parcel);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.335 -0500", hash_original_method = "FE58AA31658A96AD26D1C6215FA7714A", hash_generated_method = "4A47C730289FE57DF6D6C93315B6DA2F")
        
public Notification[] newArray(int size)
        {
            return new Notification[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.249 -0500", hash_original_field = "4E7289569777021C55877266ACAD1845", hash_generated_field = "F82DA8012E916756399BAA33930FB695")

    public long when;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.251 -0500", hash_original_field = "107298D9FB7BD66B47A702264D3B04F5", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

    public int icon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.253 -0500", hash_original_field = "F9B43650694732C77D734E3DEABF76D6", hash_generated_field = "0B0F3FF5AB4CD552070A82872F28FB69")

    public int iconLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.255 -0500", hash_original_field = "75B782B0DE9A9BBA8740638F419D560B", hash_generated_field = "54FA7EDC40A989145447D14354DC9F9A")

    public int number;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.257 -0500", hash_original_field = "4A78EA1E007D2E1AB86140EA509159FE", hash_generated_field = "ACC5096DEB0E4E25E88593DF3B444C2B")

    public PendingIntent contentIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.259 -0500", hash_original_field = "8F016DA35B5B1063C3779A582F7F5452", hash_generated_field = "ACCD1DE1BA3D76E49153B8A305B4A364")

    public PendingIntent deleteIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.262 -0500", hash_original_field = "B03D10D9E4BD449BE5BFDA9A69BA730E", hash_generated_field = "C32708A07B582946310828630C843FF1")

    public PendingIntent fullScreenIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.264 -0500", hash_original_field = "6DC420EE34CCC4104C5914011B37B5D4", hash_generated_field = "F8945E83CE6F7B2AC575B630A6341BE3")

    public CharSequence tickerText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.266 -0500", hash_original_field = "E5C4BC8A8E0D47169052DB109E5E3D6B", hash_generated_field = "AF996FFD954333E18222E9A80B0CF291")

    public RemoteViews tickerView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.268 -0500", hash_original_field = "FD7FD9D77F3F582A3CD36061BD487F5A", hash_generated_field = "769785439B75A74E92941436557060A4")

    public RemoteViews contentView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.270 -0500", hash_original_field = "8D43B5A2FD1735E358C32CFF729F82BD", hash_generated_field = "EA93211928C617C6B7C0D0E85008BB42")

    public Bitmap largeIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.272 -0500", hash_original_field = "FB0BA9D9FDF6835B713C56A87A16C2F1", hash_generated_field = "8DB7BA9A074BC98B2BC33FB259A56E89")

    public Uri sound;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.277 -0500", hash_original_field = "CC58BD2530F63FA2C5487A6D19BB0DE6", hash_generated_field = "60DCD6A3318C227AA673545D733ED8B9")

    public int audioStreamType = STREAM_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.279 -0500", hash_original_field = "D33E756C2D5F750C5D34904C059EE8D3", hash_generated_field = "F2FF83B6EA1500EB5B3B8FD769168619")

    public long[] vibrate;
    
    public static class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.347 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.349 -0500", hash_original_field = "DC3C02B3B86774AA049529AB7BA1456D", hash_generated_field = "844ECA1D47A3C505C7DE80048E6071EA")

        private long mWhen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.351 -0500", hash_original_field = "1ECA0A39CA494F6BEDC60572E1607E75", hash_generated_field = "45C49A5EA6EC401F6D3EFC525CE84A58")

        private int mSmallIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.353 -0500", hash_original_field = "263997AA77350A6487A707770AF47AC4", hash_generated_field = "932D936BF624A2B432081D3ADA06CDC3")

        private int mSmallIconLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.356 -0500", hash_original_field = "C02E023E174B50E49705701085BB66D1", hash_generated_field = "848AD153D7087EB88E43698A2BA4D08A")

        private int mNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.358 -0500", hash_original_field = "880293D1CB2F5D4C60729EDF187AA8F8", hash_generated_field = "FFA5757AF4F9418B30896AACC31036BF")

        private CharSequence mContentTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.360 -0500", hash_original_field = "338AB4B5CF81AE908BF4544B3B2F254F", hash_generated_field = "75350C63E0F1B03693385651463FA9C6")

        private CharSequence mContentText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.362 -0500", hash_original_field = "B1E08D65D45DCE89F8C92DFDB628498A", hash_generated_field = "C6399AC62AF77A98346FD207F5167CB9")

        private CharSequence mContentInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.365 -0500", hash_original_field = "D98DCE599CA88EC00FC93FC533751AAF", hash_generated_field = "BEBC996087293B4AD2344506D898D15D")

        private PendingIntent mContentIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.367 -0500", hash_original_field = "58BBF53D1528BA428A44F10051F00D93", hash_generated_field = "08435EE426E232F3FA1E7809E4B4A6F7")

        private RemoteViews mContentView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.369 -0500", hash_original_field = "D5613E1FDE7DBE5D0BC1456E63C61CCE", hash_generated_field = "6F635B2E24C4F500DDDEE0939372307D")

        private PendingIntent mDeleteIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.372 -0500", hash_original_field = "697830524BFDD238CA82220AE09EFD0B", hash_generated_field = "3508300255B3E18B759E79D0ED10AAB9")

        private PendingIntent mFullScreenIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.376 -0500", hash_original_field = "31911831BCAB73D0E21B3633E73E2913", hash_generated_field = "8BD90CF350247B504B56B7A79683065B")

        private CharSequence mTickerText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.378 -0500", hash_original_field = "E928A240FFFEC471639FC2188595645A", hash_generated_field = "9BC35C79903BE74DB4B0AA612E15AD23")

        private RemoteViews mTickerView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.380 -0500", hash_original_field = "6F0581074C4BAF96C76AC7EEDA3527AD", hash_generated_field = "DDB41F55144017DF45CBDFA2BC0F1713")

        private Bitmap mLargeIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.382 -0500", hash_original_field = "241BF092BF37739C4026E319271FF945", hash_generated_field = "6D12A8651BB192C0DAA06F0EA6096966")

        private Uri mSound;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.384 -0500", hash_original_field = "4C5123D9443C43500B1E284E75877100", hash_generated_field = "23E53F8B15727619630BFBDD428C50AC")

        private int mAudioStreamType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.386 -0500", hash_original_field = "0C5731420FBEC843FE260BAFD35E182C", hash_generated_field = "38524ACEC28710443D087CB738771292")

        private long[] mVibrate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.389 -0500", hash_original_field = "2B260E6EECD161326DF24C2834643924", hash_generated_field = "ED378C99206AA366647B210684A2CC69")

        private int mLedArgb;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.391 -0500", hash_original_field = "1A78F6517BD1079FACEF481925F66AC5", hash_generated_field = "9314E809E243E9CA0554D760D1F39C4B")

        private int mLedOnMs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.393 -0500", hash_original_field = "008E66A79BE51EBCA38462E35C4201E2", hash_generated_field = "2086D121F2B6FBE20DA7508EDB1FDF3C")

        private int mLedOffMs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.395 -0500", hash_original_field = "BCFC5D1E55F4342ED08DE21A37F30FFF", hash_generated_field = "50F7E57057E924A8C0F1E34C678F82E8")

        private int mDefaults;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.397 -0500", hash_original_field = "4E5A87EA4636A8ACF68875B877F3A7B8", hash_generated_field = "43F71E9173849705E01112D0229448B4")

        private int mFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.399 -0500", hash_original_field = "154C1AE01E9174D6FCDE2326E257A98A", hash_generated_field = "0A6C968C17C3A6387EAAF7CAC0DD4FF2")

        private int mProgressMax;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.402 -0500", hash_original_field = "7CDF5A45863735DC45D655DB7E365343", hash_generated_field = "1CA7BE0C4831604F244183A43ACB7282")

        private int mProgress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.404 -0500", hash_original_field = "58257670235EC509C908CC6AA18E2BF9", hash_generated_field = "EADFE21BB1EEBFEA55A10670C7D88680")

        private boolean mProgressIndeterminate;

        /**
         * Constructor.
         *
         * Automatically sets the when field to {@link System#currentTimeMillis()
         * System.currentTimeMllis()} and the audio stream to the {@link #STREAM_DEFAULT}.
         *
         * @param context A {@link Context} that will be used to construct the
         *      RemoteViews. The Context will not be held past the lifetime of this
         *      Builder object.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.407 -0500", hash_original_method = "A0705CD8F7169475619B80AC2CAED080", hash_generated_method = "31183F4BFEB771758826DC42A3BB6B50")
        
public Builder(Context context) {
            mContext = context;

            // Set defaults to match the defaults of a Notification
            mWhen = System.currentTimeMillis();
            mAudioStreamType = STREAM_DEFAULT;
        }

        /**
         * Set the time that the event occurred.  Notifications in the panel are
         * sorted by this time.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.409 -0500", hash_original_method = "F33CFE0DDEF1BDE88E81CA07B2B4AF4A", hash_generated_method = "462215F0766F488BA6A62942C8A204F4")
        
public Builder setWhen(long when) {
            mWhen = when;
            return this;
        }

        /**
         * Set the small icon to use in the notification layouts.  Different classes of devices
         * may return different sizes.  See the UX guidelines for more information on how to
         * design these icons.
         *
         * @param icon A resource ID in the application's package of the drawble to use.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.411 -0500", hash_original_method = "76509FA1EC330D1A963F56DC8E00B5D8", hash_generated_method = "0D277F3C63A7802E216A2AFC8D6C9730")
        
public Builder setSmallIcon(int icon) {
            mSmallIcon = icon;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.414 -0500", hash_original_method = "686130331B3575C911C4ACE6437F15B8", hash_generated_method = "7BE460678B06457C86890879443CBA20")
        
public Builder setSmallIcon(int icon, int level) {
            mSmallIcon = icon;
            mSmallIconLevel = level;
            return this;
        }

        /**
         * Set the title (first row) of the notification, in a standard notification.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.416 -0500", hash_original_method = "51D215D9B594EB5434D1A4893B0851B6", hash_generated_method = "A24D5A5914321447B8D2056822EB1FA2")
        
public Builder setContentTitle(CharSequence title) {
            mContentTitle = title;
            return this;
        }

        /**
         * Set the text (second row) of the notification, in a standard notification.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.418 -0500", hash_original_method = "3B85C73BAA4531891B097F4FBFA7845D", hash_generated_method = "9A0C65143F929FA192B834775CCB4487")
        
public Builder setContentText(CharSequence text) {
            mContentText = text;
            return this;
        }

        /**
         * Set the large number at the right-hand side of the notification.  This is
         * equivalent to setContentInfo, although it might show the number in a different
         * font size for readability.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.420 -0500", hash_original_method = "5E0FC1F68404C1057ACE1D67E6ED676A", hash_generated_method = "B3B0FB5B636F91DC142A3DAF8586529B")
        
public Builder setNumber(int number) {
            mNumber = number;
            return this;
        }

        /**
         * Set the large text at the right-hand side of the notification.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.423 -0500", hash_original_method = "52A8AABE54D5BDFE521B8B41861DFCD9", hash_generated_method = "B7861F042965E1F9AD64C19E28002929")
        
public Builder setContentInfo(CharSequence info) {
            mContentInfo = info;
            return this;
        }

        /**
         * Set the progress this notification represents, which may be
         * represented as a {@link ProgressBar}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.425 -0500", hash_original_method = "D0B2BE14A572EFF2EC3981BC799BA989", hash_generated_method = "6E0D3C0BC51827EB7CD05EFAE4B7F4F0")
        
public Builder setProgress(int max, int progress, boolean indeterminate) {
            mProgressMax = max;
            mProgress = progress;
            mProgressIndeterminate = indeterminate;
            return this;
        }

        /**
         * Supply a custom RemoteViews to use instead of the standard one.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.428 -0500", hash_original_method = "0C2B2238CAAAD5F7B913F4DC0C6DE3C5", hash_generated_method = "5B3D68ED2EFD46DD220E26D0592B30A0")
        
public Builder setContent(RemoteViews views) {
            mContentView = views;
            return this;
        }

        /**
         * Supply a {@link PendingIntent} to send when the notification is clicked.
         * If you do not supply an intent, you can now add PendingIntents to individual
         * views to be launched when clicked by calling {@link RemoteViews#setOnClickPendingIntent
         * RemoteViews.setOnClickPendingIntent(int,PendingIntent)}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.430 -0500", hash_original_method = "13AF9850EB916E3E1CD09235309F6318", hash_generated_method = "35B80BF912DA7A0FF8C66DE39967BF3A")
        
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.433 -0500", hash_original_method = "F48B9AE94AA7354563811F0226E4C56E", hash_generated_method = "8D93DDA997FE2AC23B46EB665D4A92D6")
        
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
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.436 -0500", hash_original_method = "CE5C618F1F516DEBBF5EC70FA84B35B1", hash_generated_method = "755C86B6B43CC915477EC577352C1178")
        
public Builder setFullScreenIntent(PendingIntent intent, boolean highPriority) {
            mFullScreenIntent = intent;
            setFlag(FLAG_HIGH_PRIORITY, highPriority);
            return this;
        }

        /**
         * Set the text that is displayed in the status bar when the notification first
         * arrives.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.438 -0500", hash_original_method = "43D2B64A31B6B61BB554BA691C460973", hash_generated_method = "BA5CC1E40ED071B70C559774088DB95D")
        
public Builder setTicker(CharSequence tickerText) {
            mTickerText = tickerText;
            return this;
        }

        /**
         * Set the text that is displayed in the status bar when the notification first
         * arrives, and also a RemoteViews object that may be displayed instead on some
         * devices.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.440 -0500", hash_original_method = "4C6C26DEDB76E0CF44BFBAEE6FBE84BC", hash_generated_method = "EABCCA368461A451025B190C894608A1")
        
public Builder setTicker(CharSequence tickerText, RemoteViews views) {
            mTickerText = tickerText;
            mTickerView = views;
            return this;
        }

        /**
         * Set the large icon that is shown in the ticker and notification.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.443 -0500", hash_original_method = "7DCB1EA67ACA56F0B2754C8E360CAB68", hash_generated_method = "DF7C31C82F00E2DCBBC8B9EA70CE883E")
        
public Builder setLargeIcon(Bitmap icon) {
            mLargeIcon = icon;
            return this;
        }

        /**
         * Set the sound to play.  It will play on the default stream.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.445 -0500", hash_original_method = "E4D966D2AF4F815A75885EB0928B9225", hash_generated_method = "CE1C0A650DF510A9AD918A877BE1399D")
        
public Builder setSound(Uri sound) {
            mSound = sound;
            mAudioStreamType = STREAM_DEFAULT;
            return this;
        }

        /**
         * Set the sound to play.  It will play on the stream you supply.
         *
         * @see #STREAM_DEFAULT
         * @see AudioManager for the <code>STREAM_</code> constants.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.447 -0500", hash_original_method = "2D9F8E95A20AD7FBCF7EC4A8FF50BED5", hash_generated_method = "B9338971A1DDEC2DE784E4EFB4492165")
        
public Builder setSound(Uri sound, int streamType) {
            mSound = sound;
            mAudioStreamType = streamType;
            return this;
        }

        /**
         * Set the vibration pattern to use.
         *
         * @see android.os.Vibrator for a discussion of the <code>pattern</code>
         * parameter.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.449 -0500", hash_original_method = "A86D234FAB504C5B3A4DEC6712517174", hash_generated_method = "5597004A27277A950C64200D68BFB2EF")
        
public Builder setVibrate(long[] pattern) {
            mVibrate = pattern;
            return this;
        }

        /**
         * Set the argb value that you would like the LED on the device to blnk, as well as the
         * rate.  The rate is specified in terms of the number of milliseconds to be on
         * and then the number of milliseconds to be off.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.451 -0500", hash_original_method = "06C76CABA696566E00D48B5A1D10E8B9", hash_generated_method = "E3E4E0641FEBABF496C0AC26F936580C")
        
public Builder setLights(int argb, int onMs, int offMs) {
            mLedArgb = argb;
            mLedOnMs = onMs;
            mLedOffMs = offMs;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.453 -0500", hash_original_method = "4EE6022E7B7D173E4F9ABC4B52771BC1", hash_generated_method = "671AF519B4B27404AF7E78213CF4A007")
        
public Builder setOngoing(boolean ongoing) {
            setFlag(FLAG_ONGOING_EVENT, ongoing);
            return this;
        }

        /**
         * Set this flag if you would only like the sound, vibrate
         * and ticker to be played if the notification is not already showing.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.456 -0500", hash_original_method = "19CD7AC7B316FEB13981077CC28EC4D6", hash_generated_method = "70FF1E8C9918C2B7950EC85FE754295E")
        
public Builder setOnlyAlertOnce(boolean onlyAlertOnce) {
            setFlag(FLAG_ONLY_ALERT_ONCE, onlyAlertOnce);
            return this;
        }

        /**
         * Setting this flag will make it so the notification is automatically
         * canceled when the user clicks it in the panel.  The PendingIntent
         * set with {@link #setDeleteIntent} will be broadcast when the notification
         * is canceled.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.458 -0500", hash_original_method = "65E737424C5371C7C5FE30C163FA340D", hash_generated_method = "B63710FD1ED81D7AB16D9F7832BB4374")
        
public Builder setAutoCancel(boolean autoCancel) {
            setFlag(FLAG_AUTO_CANCEL, autoCancel);
            return this;
        }

        /**
         * Set the default notification options that will be used.
         * <p>
         * The value should be one or more of the following fields combined with
         * bitwise-or:
         * {@link #DEFAULT_SOUND}, {@link #DEFAULT_VIBRATE}, {@link #DEFAULT_LIGHTS}.
         * <p>
         * For all default values, use {@link #DEFAULT_ALL}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.461 -0500", hash_original_method = "413289369D1534DD93CD0DF6E13619C0", hash_generated_method = "B80FCD5DED599909786CAFAB131C81C7")
        
public Builder setDefaults(int defaults) {
            mDefaults = defaults;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.463 -0500", hash_original_method = "100CC04F928443BDDD1350B26299D2DB", hash_generated_method = "0BC7EE29E2E86D930BE9DB77ED7692C9")
        
private void setFlag(int mask, boolean value) {
            if (value) {
                mFlags |= mask;
            } else {
                mFlags &= ~mask;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.466 -0500", hash_original_method = "874AA4550BEDC5FDB0E26F145D0FEF64", hash_generated_method = "0CB4779EF65DCE57119D5376D136EE75")
        
private RemoteViews makeRemoteViews(int resId) {
            RemoteViews contentView = new RemoteViews(mContext.getPackageName(), resId);
            boolean hasLine3 = false;
            if (mSmallIcon != 0) {
                contentView.setImageViewResource(R.id.icon, mSmallIcon);
                contentView.setViewVisibility(R.id.icon, View.VISIBLE);
            } else {
                contentView.setViewVisibility(R.id.icon, View.GONE);
            }
            if (mContentTitle != null) {
                contentView.setTextViewText(R.id.title, mContentTitle);
            }
            if (mContentText != null) {
                contentView.setTextViewText(R.id.text, mContentText);
                hasLine3 = true;
            }
            if (mContentInfo != null) {
                contentView.setTextViewText(R.id.info, mContentInfo);
                contentView.setViewVisibility(R.id.info, View.VISIBLE);
                hasLine3 = true;
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
                hasLine3 = true;
            } else {
                contentView.setViewVisibility(R.id.info, View.GONE);
            }
            if (mProgressMax != 0 || mProgressIndeterminate) {
                contentView.setProgressBar(
                        R.id.progress, mProgressMax, mProgress, mProgressIndeterminate);
                contentView.setViewVisibility(R.id.progress, View.VISIBLE);
            } else {
                contentView.setViewVisibility(R.id.progress, View.GONE);
            }
            if (mWhen != 0) {
                contentView.setLong(R.id.time, "setTime", mWhen);
            }
            contentView.setViewVisibility(R.id.line3, hasLine3 ? View.VISIBLE : View.GONE);
            return contentView;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.469 -0500", hash_original_method = "BA4EC765F0E429DA930DFC57746DA461", hash_generated_method = "E66B8BC37AE19DD3018D557A171B0CCA")
        
private RemoteViews makeContentView() {
            if (mContentView != null) {
                return mContentView;
            } else {
                    return makeRemoteViews(mLargeIcon == null
                            ? R.layout.status_bar_latest_event_content
                        : R.layout.status_bar_latest_event_content_large_icon);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.472 -0500", hash_original_method = "E7ABF10FCA5C3841BF6DB5E454736B56", hash_generated_method = "0AB02F9567C1005F66F74069F084A6F5")
        
private RemoteViews makeTickerView() {
            if (mTickerView != null) {
                return mTickerView;
            } else {
                if (mContentView == null) {
                    return makeRemoteViews(mLargeIcon == null
                            ? R.layout.status_bar_latest_event_ticker
                            : R.layout.status_bar_latest_event_ticker_large_icon);
                } else {
                    return null;
                }
            }
        }

        /**
         * Combine all of the options that have been set and return a new {@link Notification}
         * object.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.475 -0500", hash_original_method = "ACBCD2459BD592E66E9A1B94FF396B6B", hash_generated_method = "9E9159152B42F42893112012D9565859")
        
public Notification getNotification() {
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
            if (mLedOnMs != 0 && mLedOffMs != 0) {
                n.flags |= FLAG_SHOW_LIGHTS;
            }
            if ((mDefaults & DEFAULT_LIGHTS) != 0) {
                n.flags |= FLAG_SHOW_LIGHTS;
            }
            return n;
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.282 -0500", hash_original_field = "128E38791619DBDCD60954601A40EDB1", hash_generated_field = "057E0BFB613A5D660FB5738277981EFF")

    public int ledARGB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.284 -0500", hash_original_field = "BE29BDED8CDF42024CE656623EE78BC7", hash_generated_field = "ECB5054078CA45CCA91A54D58291273A")

    public int ledOnMS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.286 -0500", hash_original_field = "F5DFD15DE0217B704ED3281A99071FF4", hash_generated_field = "757766F0FDC535C47D375ED10B30B12B")

    public int ledOffMS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.288 -0500", hash_original_field = "315D538D8AB67E5836D57CA11C65B223", hash_generated_field = "35E2996A18AD2901CBB69EB78ED2A434")

    public int defaults;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.310 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;

    /**
     * Constructs a Notification object with everything set to 0.
     * You might want to consider using {@link Builder} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.312 -0500", hash_original_method = "1CE373DE78E11DB8401FDC6F724116BB", hash_generated_method = "79DCC7BC767E8F085FFC072842DC4C08")
    
public Notification()
    {
        this.when = System.currentTimeMillis();
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.315 -0500", hash_original_method = "F912A2DECFC167F58680F860007D2BB5", hash_generated_method = "AE6727A684FB35E2A2D80E2578110191")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.317 -0500", hash_original_method = "CC2BF19BEFE3DF69C00F83DC5FB8C9D2", hash_generated_method = "024900C64796E7D706CC036A6F0BE7A3")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.321 -0500", hash_original_method = "B9AE56CCF72BA824A2D5505B37E7A00A", hash_generated_method = "0421A61567333E348954B5AA8383A318")
    
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.324 -0500", hash_original_method = "6AF2D89F1A077EC9692C07FAE6A31E51", hash_generated_method = "1C0484D60BFCB4B0EE0C7F28B8779F4E")
    
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

        return that;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.326 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /**
     * Flatten this notification from a parcel.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.329 -0500", hash_original_method = "2E97C8DA884DBA934FB3E6EBE25C30F5", hash_generated_method = "26BFF04B04901CA06B5B471C37A88912")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.340 -0500", hash_original_method = "15C64B5C143E30BF8DB14A898F7C5E53", hash_generated_method = "D323371ED817368FE42627BAC8C1A842")
    
@Deprecated
    public void setLatestEventInfo(Context context,
            CharSequence contentTitle, CharSequence contentText, PendingIntent contentIntent) {
        RemoteViews contentView = new RemoteViews(context.getPackageName(),
                R.layout.status_bar_latest_event_content);
        if (this.icon != 0) {
            contentView.setImageViewResource(R.id.icon, this.icon);
        }
        if (contentTitle != null) {
            contentView.setTextViewText(R.id.title, contentTitle);
        }
        if (contentText != null) {
            contentView.setTextViewText(R.id.text, contentText);
        }
        if (this.when != 0) {
            contentView.setLong(R.id.time, "setTime", when);
        }

        this.contentView = contentView;
        this.contentIntent = contentIntent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:18.344 -0500", hash_original_method = "12C6B6D4BE06143C5E4298E3E5EDBF7E", hash_generated_method = "BA47C29E1B0DE45235BC5E8A38919DC8")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Notification(contentView=");
        if (contentView != null) {
            sb.append(contentView.getPackage());
            sb.append("/0x");
            sb.append(Integer.toHexString(contentView.getLayoutId()));
        } else {
            sb.append("null");
        }
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
        sb.append(",sound=");
        if (this.sound != null) {
            sb.append(this.sound.toString());
        } else if ((this.defaults & DEFAULT_SOUND) != 0) {
            sb.append("default");
        } else {
            sb.append("null");
        }
        sb.append(",defaults=0x");
        sb.append(Integer.toHexString(this.defaults));
        sb.append(",flags=0x");
        sb.append(Integer.toHexString(this.flags));
        if ((this.flags & FLAG_HIGH_PRIORITY) != 0) {
            sb.append("!!!1!one!");
        }
        sb.append(")");
        return sb.toString();
    }
    // orphaned legacy method
    public Notification createFromParcel(Parcel parcel)
        {
            return new Notification(parcel);
        }
    
    // orphaned legacy method
    public Notification[] newArray(int size)
        {
            return new Notification[size];
        }
    
}

