package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import java.text.NumberFormat;

public class Notification implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.725 -0400", hash_original_field = "DF491A4DE50739FA9CFFDBD4E3F4B4BB", hash_generated_field = "F82DA8012E916756399BAA33930FB695")

    public long when;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.725 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

    public int icon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.725 -0400", hash_original_field = "51E274E8C6B26CCAA23AE1525DA7C129", hash_generated_field = "0B0F3FF5AB4CD552070A82872F28FB69")

    public int iconLevel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "54FA7EDC40A989145447D14354DC9F9A")

    public int number;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "174B11944A2B3CEA71B7D4A601E85227", hash_generated_field = "ACC5096DEB0E4E25E88593DF3B444C2B")

    public PendingIntent contentIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "F871FEF9AA3F0ED36DB325F61DD50371", hash_generated_field = "ACCD1DE1BA3D76E49153B8A305B4A364")

    public PendingIntent deleteIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "861BC1D26B5C558F4D6B76AF2A499649", hash_generated_field = "C32708A07B582946310828630C843FF1")

    public PendingIntent fullScreenIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "0AADB38E0408564341E7463F73F580B0", hash_generated_field = "F8945E83CE6F7B2AC575B630A6341BE3")

    public CharSequence tickerText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "3AAEDCF9EEA0C073F684C6CF48827CC1", hash_generated_field = "AF996FFD954333E18222E9A80B0CF291")

    public RemoteViews tickerView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "594251AB2FA315CFC6F5A8560DC09EF8", hash_generated_field = "769785439B75A74E92941436557060A4")

    public RemoteViews contentView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "3157CDED1BC4CD3447C9F5512542C54C", hash_generated_field = "EA93211928C617C6B7C0D0E85008BB42")

    public Bitmap largeIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "0B8263D341DE01F741E4DEADFB18F9EB", hash_generated_field = "8DB7BA9A074BC98B2BC33FB259A56E89")

    public Uri sound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "BBA1E74DEBF3DAE13AEB41DE2EA01B6D", hash_generated_field = "60DCD6A3318C227AA673545D733ED8B9")

    public int audioStreamType = STREAM_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "FEE5781595FD04E19BD18B17AAFAAE5A", hash_generated_field = "F2FF83B6EA1500EB5B3B8FD769168619")

    public long[] vibrate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "4E4C71CD7BDEE2042C506AE9F55C8BF8", hash_generated_field = "057E0BFB613A5D660FB5738277981EFF")

    public int ledARGB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "3D4B0F5EA455DDBD2089094A243FAAA8", hash_generated_field = "ECB5054078CA45CCA91A54D58291273A")

    public int ledOnMS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "4C900D8B190DB8891D38A450B9FD0EF5", hash_generated_field = "757766F0FDC535C47D375ED10B30B12B")

    public int ledOffMS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "A4A918A45181164207929D52AEC36AEC", hash_generated_field = "35E2996A18AD2901CBB69EB78ED2A434")

    public int defaults;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.726 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.728 -0400", hash_original_method = "1CE373DE78E11DB8401FDC6F724116BB", hash_generated_method = "3BC0A224E78F0325AA3722F16B15028A")
    public  Notification() {
        this.when = System.currentTimeMillis();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.729 -0400", hash_original_method = "F912A2DECFC167F58680F860007D2BB5", hash_generated_method = "4F6F7F94086F15E7F24135CB03FAA04F")
    public  Notification(Context context, int icon, CharSequence tickerText, long when,
            CharSequence contentTitle, CharSequence contentText, Intent contentIntent) {
        this.when = when;
        this.icon = icon;
        this.tickerText = tickerText;
        setLatestEventInfo(context, contentTitle, contentText,
                PendingIntent.getActivity(context, 0, contentIntent, 0));
        addTaint(context.getTaint());
        addTaint(contentTitle.getTaint());
        addTaint(contentText.getTaint());
        addTaint(contentIntent.getTaint());
        
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.731 -0400", hash_original_method = "CC2BF19BEFE3DF69C00F83DC5FB8C9D2", hash_generated_method = "3CA5211A558752775AF34E21E5235B3B")
    @Deprecated
    public  Notification(int icon, CharSequence tickerText, long when) {
        this.icon = icon;
        this.tickerText = tickerText;
        this.when = when;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.733 -0400", hash_original_method = "B9AE56CCF72BA824A2D5505B37E7A00A", hash_generated_method = "498F1FEA911EA1E1D46673DF6E57213B")
    public  Notification(Parcel parcel) {
        int version = parcel.readInt();
        when = parcel.readLong();
        icon = parcel.readInt();
        number = parcel.readInt();
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_1497782107 = (parcel.readInt() != 0);
            {
                contentIntent = PendingIntent.CREATOR.createFromParcel(parcel);
            } 
        } 
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_1468659351 = (parcel.readInt() != 0);
            {
                deleteIntent = PendingIntent.CREATOR.createFromParcel(parcel);
            } 
        } 
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_1469882081 = (parcel.readInt() != 0);
            {
                tickerText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            } 
        } 
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_899235693 = (parcel.readInt() != 0);
            {
                tickerView = RemoteViews.CREATOR.createFromParcel(parcel);
            } 
        } 
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_1261285754 = (parcel.readInt() != 0);
            {
                contentView = RemoteViews.CREATOR.createFromParcel(parcel);
            } 
        } 
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_1964967349 = (parcel.readInt() != 0);
            {
                largeIcon = Bitmap.CREATOR.createFromParcel(parcel);
            } 
        } 
        defaults = parcel.readInt();
        flags = parcel.readInt();
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_86711696 = (parcel.readInt() != 0);
            {
                sound = Uri.CREATOR.createFromParcel(parcel);
            } 
        } 
        audioStreamType = parcel.readInt();
        vibrate = parcel.createLongArray();
        ledARGB = parcel.readInt();
        ledOnMS = parcel.readInt();
        ledOffMS = parcel.readInt();
        iconLevel = parcel.readInt();
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_586860864 = (parcel.readInt() != 0);
            {
                fullScreenIntent = PendingIntent.CREATOR.createFromParcel(parcel);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.737 -0400", hash_original_method = "6AF2D89F1A077EC9692C07FAE6A31E51", hash_generated_method = "AA87BA55B6312D1F82ABAEE0611FD395")
    @Override
    public Notification clone() {
        Notification varB4EAC82CA7396A68D541C85D26508E83_1638965012 = null; 
        Notification that = new Notification();
        that.when = this.when;
        that.icon = this.icon;
        that.number = this.number;
        that.contentIntent = this.contentIntent;
        that.deleteIntent = this.deleteIntent;
        that.fullScreenIntent = this.fullScreenIntent;
        {
            that.tickerText = this.tickerText.toString();
        } 
        {
            that.tickerView = this.tickerView.clone();
        } 
        {
            that.contentView = this.contentView.clone();
        } 
        {
            that.largeIcon = Bitmap.createBitmap(this.largeIcon);
        } 
        that.iconLevel = this.iconLevel;
        that.sound = this.sound;
        that.audioStreamType = this.audioStreamType;
        final long[] vibrate = this.vibrate;
        {
            final int N = vibrate.length;
            final long[] vib = that.vibrate = new long[N];
            System.arraycopy(vibrate, 0, vib, 0, N);
        } 
        that.ledARGB = this.ledARGB;
        that.ledOnMS = this.ledOnMS;
        that.ledOffMS = this.ledOffMS;
        that.defaults = this.defaults;
        that.flags = this.flags;
        varB4EAC82CA7396A68D541C85D26508E83_1638965012 = that;
        varB4EAC82CA7396A68D541C85D26508E83_1638965012.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1638965012;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.739 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "718D6165B19E89C3A0B7A820B9775AC5")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494489106 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494489106;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.743 -0400", hash_original_method = "2E97C8DA884DBA934FB3E6EBE25C30F5", hash_generated_method = "7892EA518F88AC44F30830C58D1C1DE0")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(1);
        parcel.writeLong(when);
        parcel.writeInt(icon);
        parcel.writeInt(number);
        {
            parcel.writeInt(1);
            contentIntent.writeToParcel(parcel, 0);
        } 
        {
            parcel.writeInt(0);
        } 
        {
            parcel.writeInt(1);
            deleteIntent.writeToParcel(parcel, 0);
        } 
        {
            parcel.writeInt(0);
        } 
        {
            parcel.writeInt(1);
            TextUtils.writeToParcel(tickerText, parcel, flags);
        } 
        {
            parcel.writeInt(0);
        } 
        {
            parcel.writeInt(1);
            tickerView.writeToParcel(parcel, 0);
        } 
        {
            parcel.writeInt(0);
        } 
        {
            parcel.writeInt(1);
            contentView.writeToParcel(parcel, 0);
        } 
        {
            parcel.writeInt(0);
        } 
        {
            parcel.writeInt(1);
            largeIcon.writeToParcel(parcel, 0);
        } 
        {
            parcel.writeInt(0);
        } 
        parcel.writeInt(defaults);
        parcel.writeInt(this.flags);
        {
            parcel.writeInt(1);
            sound.writeToParcel(parcel, 0);
        } 
        {
            parcel.writeInt(0);
        } 
        parcel.writeInt(audioStreamType);
        parcel.writeLongArray(vibrate);
        parcel.writeInt(ledARGB);
        parcel.writeInt(ledOnMS);
        parcel.writeInt(ledOffMS);
        parcel.writeInt(iconLevel);
        {
            parcel.writeInt(1);
            fullScreenIntent.writeToParcel(parcel, 0);
        } 
        {
            parcel.writeInt(0);
        } 
        addTaint(parcel.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.744 -0400", hash_original_method = "15C64B5C143E30BF8DB14A898F7C5E53", hash_generated_method = "CBCC7926436C482DD3274B814ADCD5FF")
    @Deprecated
    public void setLatestEventInfo(Context context,
            CharSequence contentTitle, CharSequence contentText, PendingIntent contentIntent) {
        RemoteViews contentView = new RemoteViews(context.getPackageName(),
                R.layout.status_bar_latest_event_content);
        {
            contentView.setImageViewResource(R.id.icon, this.icon);
        } 
        {
            contentView.setTextViewText(R.id.title, contentTitle);
        } 
        {
            contentView.setTextViewText(R.id.text, contentText);
        } 
        {
            contentView.setLong(R.id.time, "setTime", when);
        } 
        this.contentView = contentView;
        this.contentIntent = contentIntent;
        addTaint(context.getTaint());
        addTaint(contentTitle.getTaint());
        addTaint(contentText.getTaint());
        
        
                
        
            
        
        
            
        
        
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.748 -0400", hash_original_method = "12C6B6D4BE06143C5E4298E3E5EDBF7E", hash_generated_method = "440B35E2903A610F7B46538503A56ACA")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1087220864 = null; 
        StringBuilder sb = new StringBuilder();
        sb.append("Notification(contentView=");
        {
            sb.append(contentView.getPackage());
            sb.append("/0x");
            sb.append(Integer.toHexString(contentView.getLayoutId()));
        } 
        {
            sb.append("null");
        } 
        sb.append(" vibrate=");
        {
            int N = this.vibrate.length-1;
            sb.append("[");
            {
                int i = 0;
                {
                    sb.append(this.vibrate[i]);
                    sb.append(',');
                } 
            } 
            {
                sb.append(this.vibrate[N]);
            } 
            sb.append("]");
        } 
        {
            sb.append("default");
        } 
        {
            sb.append("null");
        } 
        sb.append(",sound=");
        {
            sb.append(this.sound.toString());
        } 
        {
            sb.append("default");
        } 
        {
            sb.append("null");
        } 
        sb.append(",defaults=0x");
        sb.append(Integer.toHexString(this.defaults));
        sb.append(",flags=0x");
        sb.append(Integer.toHexString(this.flags));
        {
            sb.append("!!!1!one!");
        } 
        sb.append(")");
        varB4EAC82CA7396A68D541C85D26508E83_1087220864 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1087220864.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1087220864;
        
        
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.749 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        private Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.749 -0400", hash_original_field = "D5CACCDE1537334D126F4D2B7DBEDB9E", hash_generated_field = "844ECA1D47A3C505C7DE80048E6071EA")

        private long mWhen;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.749 -0400", hash_original_field = "3FBBB2B37DDA521C38FDD5E6629FC07F", hash_generated_field = "45C49A5EA6EC401F6D3EFC525CE84A58")

        private int mSmallIcon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.749 -0400", hash_original_field = "2D17F8B8D49C11F1F80C9B6B150E1278", hash_generated_field = "932D936BF624A2B432081D3ADA06CDC3")

        private int mSmallIconLevel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.749 -0400", hash_original_field = "66308FF93E70A0A166AFA2E439553759", hash_generated_field = "848AD153D7087EB88E43698A2BA4D08A")

        private int mNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.749 -0400", hash_original_field = "1478E4DB44432A23C329135828471073", hash_generated_field = "FFA5757AF4F9418B30896AACC31036BF")

        private CharSequence mContentTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.749 -0400", hash_original_field = "70707A437C20B08F8876B15297648A17", hash_generated_field = "75350C63E0F1B03693385651463FA9C6")

        private CharSequence mContentText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "278F0675D92711270CF2CE55451036F9", hash_generated_field = "C6399AC62AF77A98346FD207F5167CB9")

        private CharSequence mContentInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "1D0A14F22B6F1D0F83FCEF3F087C3F34", hash_generated_field = "BEBC996087293B4AD2344506D898D15D")

        private PendingIntent mContentIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "9E8FE4D07A56D54AEE159583A4429FE8", hash_generated_field = "08435EE426E232F3FA1E7809E4B4A6F7")

        private RemoteViews mContentView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "6AE5515F58B9CCE028EFAECCF1C25532", hash_generated_field = "6F635B2E24C4F500DDDEE0939372307D")

        private PendingIntent mDeleteIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "856AE4F353D19D9F85B46005E78CB7B9", hash_generated_field = "3508300255B3E18B759E79D0ED10AAB9")

        private PendingIntent mFullScreenIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "E40262CAAFE8EBA1BA0DFCD1FFEA1868", hash_generated_field = "8BD90CF350247B504B56B7A79683065B")

        private CharSequence mTickerText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "181A5A397348B2421F7F7D2EC0DB487A", hash_generated_field = "9BC35C79903BE74DB4B0AA612E15AD23")

        private RemoteViews mTickerView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "4306C9470995432F0B0797AFA43A92E3", hash_generated_field = "DDB41F55144017DF45CBDFA2BC0F1713")

        private Bitmap mLargeIcon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "7D430409E3E2B086DEC5BB8E4E5D9470", hash_generated_field = "6D12A8651BB192C0DAA06F0EA6096966")

        private Uri mSound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "6C81BB5AF5DA48188E5F016F2AFBE785", hash_generated_field = "23E53F8B15727619630BFBDD428C50AC")

        private int mAudioStreamType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "E7913A720497DDDD0E68DBB5E3B18BAE", hash_generated_field = "38524ACEC28710443D087CB738771292")

        private long[] mVibrate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "08CB3E87FE69D4348117BF7A775F59DB", hash_generated_field = "ED378C99206AA366647B210684A2CC69")

        private int mLedArgb;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "DE541AF3C38EF513FD2F5230C67C6143", hash_generated_field = "9314E809E243E9CA0554D760D1F39C4B")

        private int mLedOnMs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "443107E6295CECC5042F80E763467134", hash_generated_field = "2086D121F2B6FBE20DA7508EDB1FDF3C")

        private int mLedOffMs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.750 -0400", hash_original_field = "C6162EFEF24A3E1EEF66050DD1373DC1", hash_generated_field = "50F7E57057E924A8C0F1E34C678F82E8")

        private int mDefaults;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.751 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

        private int mFlags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.751 -0400", hash_original_field = "02338C0183F6B13B3689CDA36C6F336F", hash_generated_field = "0A6C968C17C3A6387EAAF7CAC0DD4FF2")

        private int mProgressMax;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.751 -0400", hash_original_field = "8E57A1AD458E8C11842F6CF5D7E06883", hash_generated_field = "1CA7BE0C4831604F244183A43ACB7282")

        private int mProgress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.751 -0400", hash_original_field = "1F9240ADF9C47648E327B13EB607DC3F", hash_generated_field = "EADFE21BB1EEBFEA55A10670C7D88680")

        private boolean mProgressIndeterminate;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.753 -0400", hash_original_method = "A0705CD8F7169475619B80AC2CAED080", hash_generated_method = "EB3907D40C1981D4253CDE9383BF135E")
        public  Builder(Context context) {
            mContext = context;
            mWhen = System.currentTimeMillis();
            mAudioStreamType = STREAM_DEFAULT;
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.757 -0400", hash_original_method = "F33CFE0DDEF1BDE88E81CA07B2B4AF4A", hash_generated_method = "D21079D9D53A1151A2DC046114D66F2F")
        public Builder setWhen(long when) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_241996922 = null; 
            mWhen = when;
            varB4EAC82CA7396A68D541C85D26508E83_241996922 = this;
            varB4EAC82CA7396A68D541C85D26508E83_241996922.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_241996922;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.763 -0400", hash_original_method = "76509FA1EC330D1A963F56DC8E00B5D8", hash_generated_method = "ADA23C367BFEBED892BE343410DB9106")
        public Builder setSmallIcon(int icon) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1976086283 = null; 
            mSmallIcon = icon;
            varB4EAC82CA7396A68D541C85D26508E83_1976086283 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1976086283.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1976086283;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.767 -0400", hash_original_method = "686130331B3575C911C4ACE6437F15B8", hash_generated_method = "FA65DB93E0EA907FDE2E939D1F929139")
        public Builder setSmallIcon(int icon, int level) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_747061149 = null; 
            mSmallIcon = icon;
            mSmallIconLevel = level;
            varB4EAC82CA7396A68D541C85D26508E83_747061149 = this;
            varB4EAC82CA7396A68D541C85D26508E83_747061149.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_747061149;
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.771 -0400", hash_original_method = "51D215D9B594EB5434D1A4893B0851B6", hash_generated_method = "00D9ED9018A7CA2C599700936F6A9680")
        public Builder setContentTitle(CharSequence title) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1967616580 = null; 
            mContentTitle = title;
            varB4EAC82CA7396A68D541C85D26508E83_1967616580 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1967616580.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1967616580;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.776 -0400", hash_original_method = "3B85C73BAA4531891B097F4FBFA7845D", hash_generated_method = "7576D680CF740BEE2DD447F89A9F4ABF")
        public Builder setContentText(CharSequence text) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_528372050 = null; 
            mContentText = text;
            varB4EAC82CA7396A68D541C85D26508E83_528372050 = this;
            varB4EAC82CA7396A68D541C85D26508E83_528372050.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_528372050;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.780 -0400", hash_original_method = "5E0FC1F68404C1057ACE1D67E6ED676A", hash_generated_method = "229A8A5858CF0AC10791BB2DF03A9477")
        public Builder setNumber(int number) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1828375858 = null; 
            mNumber = number;
            varB4EAC82CA7396A68D541C85D26508E83_1828375858 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1828375858.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1828375858;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.785 -0400", hash_original_method = "52A8AABE54D5BDFE521B8B41861DFCD9", hash_generated_method = "C71D33037A63D95906D256B1E3C12953")
        public Builder setContentInfo(CharSequence info) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_612260578 = null; 
            mContentInfo = info;
            varB4EAC82CA7396A68D541C85D26508E83_612260578 = this;
            varB4EAC82CA7396A68D541C85D26508E83_612260578.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_612260578;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.788 -0400", hash_original_method = "D0B2BE14A572EFF2EC3981BC799BA989", hash_generated_method = "C84D6A2F7155EA8F9A04641A13907CF2")
        public Builder setProgress(int max, int progress, boolean indeterminate) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_999465274 = null; 
            mProgressMax = max;
            mProgress = progress;
            mProgressIndeterminate = indeterminate;
            varB4EAC82CA7396A68D541C85D26508E83_999465274 = this;
            varB4EAC82CA7396A68D541C85D26508E83_999465274.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_999465274;
            
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.792 -0400", hash_original_method = "0C2B2238CAAAD5F7B913F4DC0C6DE3C5", hash_generated_method = "1787BE795E69F71707A26BC664541755")
        public Builder setContent(RemoteViews views) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1361967900 = null; 
            mContentView = views;
            varB4EAC82CA7396A68D541C85D26508E83_1361967900 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1361967900.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1361967900;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.797 -0400", hash_original_method = "13AF9850EB916E3E1CD09235309F6318", hash_generated_method = "B1B439F872C1E19351AE303A946462B8")
        public Builder setContentIntent(PendingIntent intent) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_362147367 = null; 
            mContentIntent = intent;
            varB4EAC82CA7396A68D541C85D26508E83_362147367 = this;
            varB4EAC82CA7396A68D541C85D26508E83_362147367.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_362147367;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.800 -0400", hash_original_method = "F48B9AE94AA7354563811F0226E4C56E", hash_generated_method = "C9F94D3BBCE0A60778509F87F2507741")
        public Builder setDeleteIntent(PendingIntent intent) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1816323067 = null; 
            mDeleteIntent = intent;
            varB4EAC82CA7396A68D541C85D26508E83_1816323067 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1816323067.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1816323067;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.803 -0400", hash_original_method = "CE5C618F1F516DEBBF5EC70FA84B35B1", hash_generated_method = "3132BDB6BEE08CA9722DA4D860D4F9D3")
        public Builder setFullScreenIntent(PendingIntent intent, boolean highPriority) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_550232344 = null; 
            mFullScreenIntent = intent;
            setFlag(FLAG_HIGH_PRIORITY, highPriority);
            varB4EAC82CA7396A68D541C85D26508E83_550232344 = this;
            addTaint(highPriority);
            varB4EAC82CA7396A68D541C85D26508E83_550232344.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_550232344;
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.805 -0400", hash_original_method = "43D2B64A31B6B61BB554BA691C460973", hash_generated_method = "96002492A6C2D8759DFD99C147875D47")
        public Builder setTicker(CharSequence tickerText) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1897919922 = null; 
            mTickerText = tickerText;
            varB4EAC82CA7396A68D541C85D26508E83_1897919922 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1897919922.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1897919922;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.806 -0400", hash_original_method = "4C6C26DEDB76E0CF44BFBAEE6FBE84BC", hash_generated_method = "691C9407C9AFD4AE3DEE8B54E842E605")
        public Builder setTicker(CharSequence tickerText, RemoteViews views) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_2027104404 = null; 
            mTickerText = tickerText;
            mTickerView = views;
            varB4EAC82CA7396A68D541C85D26508E83_2027104404 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2027104404.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2027104404;
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.808 -0400", hash_original_method = "7DCB1EA67ACA56F0B2754C8E360CAB68", hash_generated_method = "47E2B056659AB0E58D926E16F2C23C0E")
        public Builder setLargeIcon(Bitmap icon) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_249465677 = null; 
            mLargeIcon = icon;
            varB4EAC82CA7396A68D541C85D26508E83_249465677 = this;
            varB4EAC82CA7396A68D541C85D26508E83_249465677.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_249465677;
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.809 -0400", hash_original_method = "E4D966D2AF4F815A75885EB0928B9225", hash_generated_method = "7EB04CCDB08B33A36105EFBD82E62012")
        public Builder setSound(Uri sound) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1226635147 = null; 
            mSound = sound;
            mAudioStreamType = STREAM_DEFAULT;
            varB4EAC82CA7396A68D541C85D26508E83_1226635147 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1226635147.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1226635147;
            
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.810 -0400", hash_original_method = "2D9F8E95A20AD7FBCF7EC4A8FF50BED5", hash_generated_method = "F5972504734FF259EC9C32124084A519")
        public Builder setSound(Uri sound, int streamType) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_344822955 = null; 
            mSound = sound;
            mAudioStreamType = streamType;
            varB4EAC82CA7396A68D541C85D26508E83_344822955 = this;
            varB4EAC82CA7396A68D541C85D26508E83_344822955.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_344822955;
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.812 -0400", hash_original_method = "A86D234FAB504C5B3A4DEC6712517174", hash_generated_method = "1D76B18A8C96C159987335F80A942988")
        public Builder setVibrate(long[] pattern) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_450137818 = null; 
            mVibrate = pattern;
            varB4EAC82CA7396A68D541C85D26508E83_450137818 = this;
            varB4EAC82CA7396A68D541C85D26508E83_450137818.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_450137818;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.815 -0400", hash_original_method = "06C76CABA696566E00D48B5A1D10E8B9", hash_generated_method = "8E26CF8962FD33C34B1CCC93DB50E154")
        public Builder setLights(int argb, int onMs, int offMs) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1047937043 = null; 
            mLedArgb = argb;
            mLedOnMs = onMs;
            mLedOffMs = offMs;
            varB4EAC82CA7396A68D541C85D26508E83_1047937043 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1047937043.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1047937043;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.816 -0400", hash_original_method = "4EE6022E7B7D173E4F9ABC4B52771BC1", hash_generated_method = "8BA3C6ACD1BA7CBEAD812C0DDC359D10")
        public Builder setOngoing(boolean ongoing) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_160616392 = null; 
            setFlag(FLAG_ONGOING_EVENT, ongoing);
            varB4EAC82CA7396A68D541C85D26508E83_160616392 = this;
            addTaint(ongoing);
            varB4EAC82CA7396A68D541C85D26508E83_160616392.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_160616392;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.818 -0400", hash_original_method = "19CD7AC7B316FEB13981077CC28EC4D6", hash_generated_method = "B472401C359F81BE67DE4DA93B175C4A")
        public Builder setOnlyAlertOnce(boolean onlyAlertOnce) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_305605856 = null; 
            setFlag(FLAG_ONLY_ALERT_ONCE, onlyAlertOnce);
            varB4EAC82CA7396A68D541C85D26508E83_305605856 = this;
            addTaint(onlyAlertOnce);
            varB4EAC82CA7396A68D541C85D26508E83_305605856.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_305605856;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.819 -0400", hash_original_method = "65E737424C5371C7C5FE30C163FA340D", hash_generated_method = "D81B6E88C3351EC43FB44FE7951AFA70")
        public Builder setAutoCancel(boolean autoCancel) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1205464796 = null; 
            setFlag(FLAG_AUTO_CANCEL, autoCancel);
            varB4EAC82CA7396A68D541C85D26508E83_1205464796 = this;
            addTaint(autoCancel);
            varB4EAC82CA7396A68D541C85D26508E83_1205464796.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1205464796;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.821 -0400", hash_original_method = "413289369D1534DD93CD0DF6E13619C0", hash_generated_method = "90424D2C053A66F56271C486AC909240")
        public Builder setDefaults(int defaults) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1695368254 = null; 
            mDefaults = defaults;
            varB4EAC82CA7396A68D541C85D26508E83_1695368254 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1695368254.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1695368254;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.822 -0400", hash_original_method = "100CC04F928443BDDD1350B26299D2DB", hash_generated_method = "5931F6904132B4A25B60E9C33D9C37BA")
        private void setFlag(int mask, boolean value) {
            {
                mFlags |= mask;
            } 
            {
                mFlags &= ~mask;
            } 
            addTaint(value);
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.825 -0400", hash_original_method = "874AA4550BEDC5FDB0E26F145D0FEF64", hash_generated_method = "D75B2780FD2D30FF83641B804303F85E")
        private RemoteViews makeRemoteViews(int resId) {
            RemoteViews varB4EAC82CA7396A68D541C85D26508E83_1029509569 = null; 
            RemoteViews contentView = new RemoteViews(mContext.getPackageName(), resId);
            boolean hasLine3 = false;
            {
                contentView.setImageViewResource(R.id.icon, mSmallIcon);
                contentView.setViewVisibility(R.id.icon, View.VISIBLE);
            } 
            {
                contentView.setViewVisibility(R.id.icon, View.GONE);
            } 
            {
                contentView.setTextViewText(R.id.title, mContentTitle);
            } 
            {
                contentView.setTextViewText(R.id.text, mContentText);
                hasLine3 = true;
            } 
            {
                contentView.setTextViewText(R.id.info, mContentInfo);
                contentView.setViewVisibility(R.id.info, View.VISIBLE);
                hasLine3 = true;
            } 
            {
                final int tooBig = mContext.getResources().getInteger(
                        R.integer.status_bar_notification_info_maxnum);
                {
                    contentView.setTextViewText(R.id.info, mContext.getResources().getString(
                                R.string.status_bar_notification_info_overflow));
                } 
                {
                    NumberFormat f = NumberFormat.getIntegerInstance();
                    contentView.setTextViewText(R.id.info, f.format(mNumber));
                } 
                contentView.setViewVisibility(R.id.info, View.VISIBLE);
                hasLine3 = true;
            } 
            {
                contentView.setViewVisibility(R.id.info, View.GONE);
            } 
            {
                contentView.setProgressBar(
                        R.id.progress, mProgressMax, mProgress, mProgressIndeterminate);
                contentView.setViewVisibility(R.id.progress, View.VISIBLE);
            } 
            {
                contentView.setViewVisibility(R.id.progress, View.GONE);
            } 
            {
                contentView.setLong(R.id.time, "setTime", mWhen);
            } 
            contentView.setViewVisibility(R.id.line3, hasLine3 ? View.VISIBLE : View.GONE);
            varB4EAC82CA7396A68D541C85D26508E83_1029509569 = contentView;
            addTaint(resId);
            varB4EAC82CA7396A68D541C85D26508E83_1029509569.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1029509569;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.827 -0400", hash_original_method = "BA4EC765F0E429DA930DFC57746DA461", hash_generated_method = "D1A8BE8824CE14F4166DE9443460203D")
        private RemoteViews makeContentView() {
            RemoteViews varB4EAC82CA7396A68D541C85D26508E83_859083156 = null; 
            RemoteViews varB4EAC82CA7396A68D541C85D26508E83_1768508421 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_859083156 = mContentView;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1768508421 = makeRemoteViews(mLargeIcon == null
                            ? R.layout.status_bar_latest_event_content
                        : R.layout.status_bar_latest_event_content_large_icon);
            } 
            RemoteViews varA7E53CE21691AB073D9660D615818899_1684674338; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1684674338 = varB4EAC82CA7396A68D541C85D26508E83_859083156;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1684674338 = varB4EAC82CA7396A68D541C85D26508E83_1768508421;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1684674338.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1684674338;
            
            
                
            
                    
                            
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.828 -0400", hash_original_method = "E7ABF10FCA5C3841BF6DB5E454736B56", hash_generated_method = "F4A932907647DA045036D663E24FDA63")
        private RemoteViews makeTickerView() {
            RemoteViews varB4EAC82CA7396A68D541C85D26508E83_1204001753 = null; 
            RemoteViews varB4EAC82CA7396A68D541C85D26508E83_1233365294 = null; 
            RemoteViews varB4EAC82CA7396A68D541C85D26508E83_391060082 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1204001753 = mTickerView;
            } 
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1233365294 = makeRemoteViews(mLargeIcon == null
                            ? R.layout.status_bar_latest_event_ticker
                            : R.layout.status_bar_latest_event_ticker_large_icon);
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_391060082 = null;
                } 
            } 
            RemoteViews varA7E53CE21691AB073D9660D615818899_1766756802; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1766756802 = varB4EAC82CA7396A68D541C85D26508E83_1204001753;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1766756802 = varB4EAC82CA7396A68D541C85D26508E83_1233365294;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1766756802 = varB4EAC82CA7396A68D541C85D26508E83_391060082;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1766756802.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1766756802;
            
            
                
            
                
                    
                            
                            
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.831 -0400", hash_original_method = "ACBCD2459BD592E66E9A1B94FF396B6B", hash_generated_method = "0B1041B3B05773F5BFE8D97F9134DB23")
        public Notification getNotification() {
            Notification varB4EAC82CA7396A68D541C85D26508E83_2020436569 = null; 
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
            {
                n.flags |= FLAG_SHOW_LIGHTS;
            } 
            {
                n.flags |= FLAG_SHOW_LIGHTS;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2020436569 = n;
            varB4EAC82CA7396A68D541C85D26508E83_2020436569.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2020436569;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.831 -0400", hash_original_field = "A58722960CCC108319DC7C1222FEA5A9", hash_generated_field = "493D0EBDAE7097F899550C884AC22A2C")

    public static final int DEFAULT_ALL = ~0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.831 -0400", hash_original_field = "3ED7F4A94F3A25E7C23E0BD5D0F04E9E", hash_generated_field = "EBEB29EEA1677186411B0676C7CB6CA8")

    public static final int DEFAULT_SOUND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.831 -0400", hash_original_field = "D9A5E31DE76EB62BD642E7D3B8715F0A", hash_generated_field = "625958CF78DAC59C5F668018906E7A25")

    public static final int DEFAULT_VIBRATE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.831 -0400", hash_original_field = "AA58C254EF295598E86C2D29CFB254DD", hash_generated_field = "08672983F6AA38AE8CB005A3B0951E14")

    public static final int DEFAULT_LIGHTS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.832 -0400", hash_original_field = "146CEB05EF1DE3B063ACA546DDC916BE", hash_generated_field = "03418D428EB9B0647508E7584179BDCC")

    public static final int STREAM_DEFAULT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.832 -0400", hash_original_field = "A135016EFA1C41336B58A5C49B7C7E5F", hash_generated_field = "3EA71E6BEF191625FDE53FA428627FCD")

    public static final int FLAG_SHOW_LIGHTS        = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.832 -0400", hash_original_field = "E3EF8F49801BC60F819163B5308BBDDE", hash_generated_field = "4212FDC8E3576C78F889BF1A169268A1")

    public static final int FLAG_ONGOING_EVENT      = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.832 -0400", hash_original_field = "71C74B0E7410FEE495CE02DC62E01C61", hash_generated_field = "5E4C5667DCB9D60C104C3E79AF4A4C18")

    public static final int FLAG_INSISTENT          = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.832 -0400", hash_original_field = "02AF7F064B1F5B6E6B42676ECD491380", hash_generated_field = "500F040419409BB73C946F7E5EAF73E0")

    public static final int FLAG_ONLY_ALERT_ONCE    = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.832 -0400", hash_original_field = "D9D0119AEB98145A13896C2AAECAAAA8", hash_generated_field = "E5EB78F93DFB40825F4ED628FB1B6DFC")

    public static final int FLAG_AUTO_CANCEL        = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.832 -0400", hash_original_field = "52AEFD886A8F3C7313B41B06EAB34822", hash_generated_field = "EC8515FDF436BE99F3787638E8918138")

    public static final int FLAG_NO_CLEAR           = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.832 -0400", hash_original_field = "A817890516698BE4871479105BBE871D", hash_generated_field = "4891EB5C3AD9C34A5B31934636D873FF")

    public static final int FLAG_FOREGROUND_SERVICE = 0x00000040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.832 -0400", hash_original_field = "76F01FB5C067B2101AED125EC1FBF0BA", hash_generated_field = "922B7B86CB8DA2C0A66A1F85C3129923")

    public static final int FLAG_HIGH_PRIORITY = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.833 -0400", hash_original_field = "50F431254E99137F341327FC6639553A", hash_generated_field = "4FA917F3775D815CA3B6257FE54BF16E")

    public static final Parcelable.Creator<Notification> CREATOR
            = new Parcelable.Creator<Notification>()
    {
        public Notification createFromParcel(Parcel parcel)
        {
            return new Notification(parcel);
        }

        public Notification[] newArray(int size)
        {
            return new Notification[size];
        }
    };
    
    public Notification createFromParcel(Parcel parcel)
        {
            return new Notification(parcel);
        }
    
    
    public Notification[] newArray(int size)
        {
            return new Notification[size];
        }
    
}

