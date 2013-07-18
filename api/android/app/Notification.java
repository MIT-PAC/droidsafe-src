package android.app;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Notification implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.252 -0400", hash_original_field = "DF491A4DE50739FA9CFFDBD4E3F4B4BB", hash_generated_field = "F82DA8012E916756399BAA33930FB695")

    public long when;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.253 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

    public int icon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.253 -0400", hash_original_field = "51E274E8C6B26CCAA23AE1525DA7C129", hash_generated_field = "0B0F3FF5AB4CD552070A82872F28FB69")

    public int iconLevel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.253 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "54FA7EDC40A989145447D14354DC9F9A")

    public int number;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.253 -0400", hash_original_field = "174B11944A2B3CEA71B7D4A601E85227", hash_generated_field = "ACC5096DEB0E4E25E88593DF3B444C2B")

    public PendingIntent contentIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.253 -0400", hash_original_field = "F871FEF9AA3F0ED36DB325F61DD50371", hash_generated_field = "ACCD1DE1BA3D76E49153B8A305B4A364")

    public PendingIntent deleteIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.253 -0400", hash_original_field = "861BC1D26B5C558F4D6B76AF2A499649", hash_generated_field = "C32708A07B582946310828630C843FF1")

    public PendingIntent fullScreenIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.253 -0400", hash_original_field = "0AADB38E0408564341E7463F73F580B0", hash_generated_field = "F8945E83CE6F7B2AC575B630A6341BE3")

    public CharSequence tickerText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.253 -0400", hash_original_field = "3AAEDCF9EEA0C073F684C6CF48827CC1", hash_generated_field = "AF996FFD954333E18222E9A80B0CF291")

    public RemoteViews tickerView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.254 -0400", hash_original_field = "594251AB2FA315CFC6F5A8560DC09EF8", hash_generated_field = "769785439B75A74E92941436557060A4")

    public RemoteViews contentView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.254 -0400", hash_original_field = "3157CDED1BC4CD3447C9F5512542C54C", hash_generated_field = "EA93211928C617C6B7C0D0E85008BB42")

    public Bitmap largeIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.254 -0400", hash_original_field = "0B8263D341DE01F741E4DEADFB18F9EB", hash_generated_field = "8DB7BA9A074BC98B2BC33FB259A56E89")

    public Uri sound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.254 -0400", hash_original_field = "BBA1E74DEBF3DAE13AEB41DE2EA01B6D", hash_generated_field = "60DCD6A3318C227AA673545D733ED8B9")

    public int audioStreamType = STREAM_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.254 -0400", hash_original_field = "FEE5781595FD04E19BD18B17AAFAAE5A", hash_generated_field = "F2FF83B6EA1500EB5B3B8FD769168619")

    public long[] vibrate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.254 -0400", hash_original_field = "4E4C71CD7BDEE2042C506AE9F55C8BF8", hash_generated_field = "057E0BFB613A5D660FB5738277981EFF")

    public int ledARGB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.254 -0400", hash_original_field = "3D4B0F5EA455DDBD2089094A243FAAA8", hash_generated_field = "ECB5054078CA45CCA91A54D58291273A")

    public int ledOnMS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.254 -0400", hash_original_field = "4C900D8B190DB8891D38A450B9FD0EF5", hash_generated_field = "757766F0FDC535C47D375ED10B30B12B")

    public int ledOffMS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.254 -0400", hash_original_field = "A4A918A45181164207929D52AEC36AEC", hash_generated_field = "35E2996A18AD2901CBB69EB78ED2A434")

    public int defaults;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.255 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.255 -0400", hash_original_method = "1CE373DE78E11DB8401FDC6F724116BB", hash_generated_method = "3BC0A224E78F0325AA3722F16B15028A")
    public  Notification() {
        this.when = System.currentTimeMillis();
        // ---------- Original Method ----------
        //this.when = System.currentTimeMillis();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.257 -0400", hash_original_method = "F912A2DECFC167F58680F860007D2BB5", hash_generated_method = "3B18C5842AE1AC8C6EE94277514E87EA")
    public  Notification(Context context, int icon, CharSequence tickerText, long when,
            CharSequence contentTitle, CharSequence contentText, Intent contentIntent) {
        addTaint(contentIntent.getTaint());
        addTaint(contentText.getTaint());
        addTaint(contentTitle.getTaint());
        addTaint(context.getTaint());
        this.when = when;
        this.icon = icon;
        this.tickerText = tickerText;
        setLatestEventInfo(context, contentTitle, contentText,
                PendingIntent.getActivity(context, 0, contentIntent, 0));
        // ---------- Original Method ----------
        //this.when = when;
        //this.icon = icon;
        //this.tickerText = tickerText;
        //setLatestEventInfo(context, contentTitle, contentText,
                //PendingIntent.getActivity(context, 0, contentIntent, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.259 -0400", hash_original_method = "CC2BF19BEFE3DF69C00F83DC5FB8C9D2", hash_generated_method = "3CA5211A558752775AF34E21E5235B3B")
    @Deprecated
    public  Notification(int icon, CharSequence tickerText, long when) {
        this.icon = icon;
        this.tickerText = tickerText;
        this.when = when;
        // ---------- Original Method ----------
        //this.icon = icon;
        //this.tickerText = tickerText;
        //this.when = when;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.265 -0400", hash_original_method = "B9AE56CCF72BA824A2D5505B37E7A00A", hash_generated_method = "C638021775703C3CEAB4A1063FDC5136")
    public  Notification(Parcel parcel) {
        int version = parcel.readInt();
        when = parcel.readLong();
        icon = parcel.readInt();
        number = parcel.readInt();
        if(parcel.readInt() != 0)        
        {
            contentIntent = PendingIntent.CREATOR.createFromParcel(parcel);
        } //End block
        if(parcel.readInt() != 0)        
        {
            deleteIntent = PendingIntent.CREATOR.createFromParcel(parcel);
        } //End block
        if(parcel.readInt() != 0)        
        {
            tickerText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        } //End block
        if(parcel.readInt() != 0)        
        {
            tickerView = RemoteViews.CREATOR.createFromParcel(parcel);
        } //End block
        if(parcel.readInt() != 0)        
        {
            contentView = RemoteViews.CREATOR.createFromParcel(parcel);
        } //End block
        if(parcel.readInt() != 0)        
        {
            largeIcon = Bitmap.CREATOR.createFromParcel(parcel);
        } //End block
        defaults = parcel.readInt();
        flags = parcel.readInt();
        if(parcel.readInt() != 0)        
        {
            sound = Uri.CREATOR.createFromParcel(parcel);
        } //End block
        audioStreamType = parcel.readInt();
        vibrate = parcel.createLongArray();
        ledARGB = parcel.readInt();
        ledOnMS = parcel.readInt();
        ledOffMS = parcel.readInt();
        iconLevel = parcel.readInt();
        if(parcel.readInt() != 0)        
        {
            fullScreenIntent = PendingIntent.CREATOR.createFromParcel(parcel);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.271 -0400", hash_original_method = "6AF2D89F1A077EC9692C07FAE6A31E51", hash_generated_method = "8F3CDA2113E190E89B3210761543DBBB")
    @Override
    public Notification clone() {
        Notification that = new Notification();
        that.when = this.when;
        that.icon = this.icon;
        that.number = this.number;
        that.contentIntent = this.contentIntent;
        that.deleteIntent = this.deleteIntent;
        that.fullScreenIntent = this.fullScreenIntent;
        if(this.tickerText != null)        
        {
            that.tickerText = this.tickerText.toString();
        } //End block
        if(this.tickerView != null)        
        {
            that.tickerView = this.tickerView.clone();
        } //End block
        if(this.contentView != null)        
        {
            that.contentView = this.contentView.clone();
        } //End block
        if(this.largeIcon != null)        
        {
            that.largeIcon = Bitmap.createBitmap(this.largeIcon);
        } //End block
        that.iconLevel = this.iconLevel;
        that.sound = this.sound;
        that.audioStreamType = this.audioStreamType;
        final long[] vibrate = this.vibrate;
        if(vibrate != null)        
        {
            final int N = vibrate.length;
            final long[] vib = that.vibrate = new long[N];
            System.arraycopy(vibrate, 0, vib, 0, N);
        } //End block
        that.ledARGB = this.ledARGB;
        that.ledOnMS = this.ledOnMS;
        that.ledOffMS = this.ledOffMS;
        that.defaults = this.defaults;
        that.flags = this.flags;
Notification varF9965B73D80F3C31BC4764828F08696D_1070029900 =         that;
        varF9965B73D80F3C31BC4764828F08696D_1070029900.addTaint(taint);
        return varF9965B73D80F3C31BC4764828F08696D_1070029900;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.272 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "78FF61B2CEBC16199E3DC034286DF726")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_850709058 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2021034072 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2021034072;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.274 -0400", hash_original_method = "2E97C8DA884DBA934FB3E6EBE25C30F5", hash_generated_method = "6E9EEDC14FE058AEB037FD9AA8ABFD77")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        parcel.writeInt(1);
        parcel.writeLong(when);
        parcel.writeInt(icon);
        parcel.writeInt(number);
        if(contentIntent != null)        
        {
            parcel.writeInt(1);
            contentIntent.writeToParcel(parcel, 0);
        } //End block
        else
        {
            parcel.writeInt(0);
        } //End block
        if(deleteIntent != null)        
        {
            parcel.writeInt(1);
            deleteIntent.writeToParcel(parcel, 0);
        } //End block
        else
        {
            parcel.writeInt(0);
        } //End block
        if(tickerText != null)        
        {
            parcel.writeInt(1);
            TextUtils.writeToParcel(tickerText, parcel, flags);
        } //End block
        else
        {
            parcel.writeInt(0);
        } //End block
        if(tickerView != null)        
        {
            parcel.writeInt(1);
            tickerView.writeToParcel(parcel, 0);
        } //End block
        else
        {
            parcel.writeInt(0);
        } //End block
        if(contentView != null)        
        {
            parcel.writeInt(1);
            contentView.writeToParcel(parcel, 0);
        } //End block
        else
        {
            parcel.writeInt(0);
        } //End block
        if(largeIcon != null)        
        {
            parcel.writeInt(1);
            largeIcon.writeToParcel(parcel, 0);
        } //End block
        else
        {
            parcel.writeInt(0);
        } //End block
        parcel.writeInt(defaults);
        parcel.writeInt(this.flags);
        if(sound != null)        
        {
            parcel.writeInt(1);
            sound.writeToParcel(parcel, 0);
        } //End block
        else
        {
            parcel.writeInt(0);
        } //End block
        parcel.writeInt(audioStreamType);
        parcel.writeLongArray(vibrate);
        parcel.writeInt(ledARGB);
        parcel.writeInt(ledOnMS);
        parcel.writeInt(ledOffMS);
        parcel.writeInt(iconLevel);
        if(fullScreenIntent != null)        
        {
            parcel.writeInt(1);
            fullScreenIntent.writeToParcel(parcel, 0);
        } //End block
        else
        {
            parcel.writeInt(0);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.277 -0400", hash_original_method = "15C64B5C143E30BF8DB14A898F7C5E53", hash_generated_method = "B64A396887A5B873E642C0CDD214CA1A")
    @Deprecated
    public void setLatestEventInfo(Context context,
            CharSequence contentTitle, CharSequence contentText, PendingIntent contentIntent) {
        addTaint(contentText.getTaint());
        addTaint(contentTitle.getTaint());
        addTaint(context.getTaint());
        RemoteViews contentView = new RemoteViews(context.getPackageName(),
                R.layout.status_bar_latest_event_content);
        if(this.icon != 0)        
        {
            contentView.setImageViewResource(R.id.icon, this.icon);
        } //End block
        if(contentTitle != null)        
        {
            contentView.setTextViewText(R.id.title, contentTitle);
        } //End block
        if(contentText != null)        
        {
            contentView.setTextViewText(R.id.text, contentText);
        } //End block
        if(this.when != 0)        
        {
            contentView.setLong(R.id.time, "setTime", when);
        } //End block
        this.contentView = contentView;
        this.contentIntent = contentIntent;
        // ---------- Original Method ----------
        //RemoteViews contentView = new RemoteViews(context.getPackageName(),
                //R.layout.status_bar_latest_event_content);
        //if (this.icon != 0) {
            //contentView.setImageViewResource(R.id.icon, this.icon);
        //}
        //if (contentTitle != null) {
            //contentView.setTextViewText(R.id.title, contentTitle);
        //}
        //if (contentText != null) {
            //contentView.setTextViewText(R.id.text, contentText);
        //}
        //if (this.when != 0) {
            //contentView.setLong(R.id.time, "setTime", when);
        //}
        //this.contentView = contentView;
        //this.contentIntent = contentIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.279 -0400", hash_original_method = "12C6B6D4BE06143C5E4298E3E5EDBF7E", hash_generated_method = "F2ADC7F3C609D49451BD37A03AD6055F")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Notification(contentView=");
        if(contentView != null)        
        {
            sb.append(contentView.getPackage());
            sb.append("/0x");
            sb.append(Integer.toHexString(contentView.getLayoutId()));
        } //End block
        else
        {
            sb.append("null");
        } //End block
        sb.append(" vibrate=");
        if(this.vibrate != null)        
        {
            int N = this.vibrate.length-1;
            sb.append("[");
for(int i=0;i<N;i++)
            {
                sb.append(this.vibrate[i]);
                sb.append(',');
            } //End block
            if(N != -1)            
            {
                sb.append(this.vibrate[N]);
            } //End block
            sb.append("]");
        } //End block
        else
        if((this.defaults & DEFAULT_VIBRATE) != 0)        
        {
            sb.append("default");
        } //End block
        else
        {
            sb.append("null");
        } //End block
        sb.append(",sound=");
        if(this.sound != null)        
        {
            sb.append(this.sound.toString());
        } //End block
        else
        if((this.defaults & DEFAULT_SOUND) != 0)        
        {
            sb.append("default");
        } //End block
        else
        {
            sb.append("null");
        } //End block
        sb.append(",defaults=0x");
        sb.append(Integer.toHexString(this.defaults));
        sb.append(",flags=0x");
        sb.append(Integer.toHexString(this.flags));
        if((this.flags & FLAG_HIGH_PRIORITY) != 0)        
        {
            sb.append("!!!1!one!");
        } //End block
        sb.append(")");
String var2460B846747F8B22185AD8BE722266A5_1203820085 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1203820085.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1203820085;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.281 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        private Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.281 -0400", hash_original_field = "D5CACCDE1537334D126F4D2B7DBEDB9E", hash_generated_field = "844ECA1D47A3C505C7DE80048E6071EA")

        private long mWhen;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.281 -0400", hash_original_field = "3FBBB2B37DDA521C38FDD5E6629FC07F", hash_generated_field = "45C49A5EA6EC401F6D3EFC525CE84A58")

        private int mSmallIcon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.282 -0400", hash_original_field = "2D17F8B8D49C11F1F80C9B6B150E1278", hash_generated_field = "932D936BF624A2B432081D3ADA06CDC3")

        private int mSmallIconLevel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.282 -0400", hash_original_field = "66308FF93E70A0A166AFA2E439553759", hash_generated_field = "848AD153D7087EB88E43698A2BA4D08A")

        private int mNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.282 -0400", hash_original_field = "1478E4DB44432A23C329135828471073", hash_generated_field = "FFA5757AF4F9418B30896AACC31036BF")

        private CharSequence mContentTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.282 -0400", hash_original_field = "70707A437C20B08F8876B15297648A17", hash_generated_field = "75350C63E0F1B03693385651463FA9C6")

        private CharSequence mContentText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.282 -0400", hash_original_field = "278F0675D92711270CF2CE55451036F9", hash_generated_field = "C6399AC62AF77A98346FD207F5167CB9")

        private CharSequence mContentInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.282 -0400", hash_original_field = "1D0A14F22B6F1D0F83FCEF3F087C3F34", hash_generated_field = "BEBC996087293B4AD2344506D898D15D")

        private PendingIntent mContentIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.282 -0400", hash_original_field = "9E8FE4D07A56D54AEE159583A4429FE8", hash_generated_field = "08435EE426E232F3FA1E7809E4B4A6F7")

        private RemoteViews mContentView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.282 -0400", hash_original_field = "6AE5515F58B9CCE028EFAECCF1C25532", hash_generated_field = "6F635B2E24C4F500DDDEE0939372307D")

        private PendingIntent mDeleteIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.282 -0400", hash_original_field = "856AE4F353D19D9F85B46005E78CB7B9", hash_generated_field = "3508300255B3E18B759E79D0ED10AAB9")

        private PendingIntent mFullScreenIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.283 -0400", hash_original_field = "E40262CAAFE8EBA1BA0DFCD1FFEA1868", hash_generated_field = "8BD90CF350247B504B56B7A79683065B")

        private CharSequence mTickerText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.283 -0400", hash_original_field = "181A5A397348B2421F7F7D2EC0DB487A", hash_generated_field = "9BC35C79903BE74DB4B0AA612E15AD23")

        private RemoteViews mTickerView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.283 -0400", hash_original_field = "4306C9470995432F0B0797AFA43A92E3", hash_generated_field = "DDB41F55144017DF45CBDFA2BC0F1713")

        private Bitmap mLargeIcon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.283 -0400", hash_original_field = "7D430409E3E2B086DEC5BB8E4E5D9470", hash_generated_field = "6D12A8651BB192C0DAA06F0EA6096966")

        private Uri mSound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.283 -0400", hash_original_field = "6C81BB5AF5DA48188E5F016F2AFBE785", hash_generated_field = "23E53F8B15727619630BFBDD428C50AC")

        private int mAudioStreamType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.283 -0400", hash_original_field = "E7913A720497DDDD0E68DBB5E3B18BAE", hash_generated_field = "38524ACEC28710443D087CB738771292")

        private long[] mVibrate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.283 -0400", hash_original_field = "08CB3E87FE69D4348117BF7A775F59DB", hash_generated_field = "ED378C99206AA366647B210684A2CC69")

        private int mLedArgb;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.283 -0400", hash_original_field = "DE541AF3C38EF513FD2F5230C67C6143", hash_generated_field = "9314E809E243E9CA0554D760D1F39C4B")

        private int mLedOnMs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.284 -0400", hash_original_field = "443107E6295CECC5042F80E763467134", hash_generated_field = "2086D121F2B6FBE20DA7508EDB1FDF3C")

        private int mLedOffMs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.284 -0400", hash_original_field = "C6162EFEF24A3E1EEF66050DD1373DC1", hash_generated_field = "50F7E57057E924A8C0F1E34C678F82E8")

        private int mDefaults;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.284 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

        private int mFlags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.284 -0400", hash_original_field = "02338C0183F6B13B3689CDA36C6F336F", hash_generated_field = "0A6C968C17C3A6387EAAF7CAC0DD4FF2")

        private int mProgressMax;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.284 -0400", hash_original_field = "8E57A1AD458E8C11842F6CF5D7E06883", hash_generated_field = "1CA7BE0C4831604F244183A43ACB7282")

        private int mProgress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.284 -0400", hash_original_field = "1F9240ADF9C47648E327B13EB607DC3F", hash_generated_field = "EADFE21BB1EEBFEA55A10670C7D88680")

        private boolean mProgressIndeterminate;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.285 -0400", hash_original_method = "A0705CD8F7169475619B80AC2CAED080", hash_generated_method = "EB3907D40C1981D4253CDE9383BF135E")
        public  Builder(Context context) {
            mContext = context;
            mWhen = System.currentTimeMillis();
            mAudioStreamType = STREAM_DEFAULT;
            // ---------- Original Method ----------
            //mContext = context;
            //mWhen = System.currentTimeMillis();
            //mAudioStreamType = STREAM_DEFAULT;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.286 -0400", hash_original_method = "F33CFE0DDEF1BDE88E81CA07B2B4AF4A", hash_generated_method = "49E1051CC94C8AB5773F9A887B3FF396")
        public Builder setWhen(long when) {
            mWhen = when;
Builder var72A74007B2BE62B849F475C7BDA4658B_268405710 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_268405710.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_268405710;
            // ---------- Original Method ----------
            //mWhen = when;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.286 -0400", hash_original_method = "76509FA1EC330D1A963F56DC8E00B5D8", hash_generated_method = "350965E57D41F8DE21FD752BA8274FA0")
        public Builder setSmallIcon(int icon) {
            mSmallIcon = icon;
Builder var72A74007B2BE62B849F475C7BDA4658B_359522069 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_359522069.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_359522069;
            // ---------- Original Method ----------
            //mSmallIcon = icon;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.287 -0400", hash_original_method = "686130331B3575C911C4ACE6437F15B8", hash_generated_method = "FC770A3B08F4A5AFF4FF3C905AA8EEE4")
        public Builder setSmallIcon(int icon, int level) {
            mSmallIcon = icon;
            mSmallIconLevel = level;
Builder var72A74007B2BE62B849F475C7BDA4658B_2073873298 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2073873298.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2073873298;
            // ---------- Original Method ----------
            //mSmallIcon = icon;
            //mSmallIconLevel = level;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.288 -0400", hash_original_method = "51D215D9B594EB5434D1A4893B0851B6", hash_generated_method = "0530ABD413A49DC72DEA6E9A9E85C5D9")
        public Builder setContentTitle(CharSequence title) {
            mContentTitle = title;
Builder var72A74007B2BE62B849F475C7BDA4658B_1889303973 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1889303973.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1889303973;
            // ---------- Original Method ----------
            //mContentTitle = title;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.289 -0400", hash_original_method = "3B85C73BAA4531891B097F4FBFA7845D", hash_generated_method = "84A3C6FC264DE9590A08E980BDC04457")
        public Builder setContentText(CharSequence text) {
            mContentText = text;
Builder var72A74007B2BE62B849F475C7BDA4658B_36232506 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_36232506.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_36232506;
            // ---------- Original Method ----------
            //mContentText = text;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.290 -0400", hash_original_method = "5E0FC1F68404C1057ACE1D67E6ED676A", hash_generated_method = "0F0463DE765AFFECE4A45C0797704349")
        public Builder setNumber(int number) {
            mNumber = number;
Builder var72A74007B2BE62B849F475C7BDA4658B_1502644938 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1502644938.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1502644938;
            // ---------- Original Method ----------
            //mNumber = number;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.290 -0400", hash_original_method = "52A8AABE54D5BDFE521B8B41861DFCD9", hash_generated_method = "099E2B92B3BBCBE076ADE1E2C0BBC5D7")
        public Builder setContentInfo(CharSequence info) {
            mContentInfo = info;
Builder var72A74007B2BE62B849F475C7BDA4658B_65260895 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_65260895.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_65260895;
            // ---------- Original Method ----------
            //mContentInfo = info;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.291 -0400", hash_original_method = "D0B2BE14A572EFF2EC3981BC799BA989", hash_generated_method = "36863F845FC43577F5773A29A18B8E4B")
        public Builder setProgress(int max, int progress, boolean indeterminate) {
            mProgressMax = max;
            mProgress = progress;
            mProgressIndeterminate = indeterminate;
Builder var72A74007B2BE62B849F475C7BDA4658B_1829651314 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1829651314.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1829651314;
            // ---------- Original Method ----------
            //mProgressMax = max;
            //mProgress = progress;
            //mProgressIndeterminate = indeterminate;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.292 -0400", hash_original_method = "0C2B2238CAAAD5F7B913F4DC0C6DE3C5", hash_generated_method = "2795D9A064FAF0D377A06DF465DE2F7D")
        public Builder setContent(RemoteViews views) {
            mContentView = views;
Builder var72A74007B2BE62B849F475C7BDA4658B_2059054726 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2059054726.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2059054726;
            // ---------- Original Method ----------
            //mContentView = views;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.293 -0400", hash_original_method = "13AF9850EB916E3E1CD09235309F6318", hash_generated_method = "02888347B6559BDAF0A13C084C73529E")
        public Builder setContentIntent(PendingIntent intent) {
            mContentIntent = intent;
Builder var72A74007B2BE62B849F475C7BDA4658B_1337893120 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1337893120.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1337893120;
            // ---------- Original Method ----------
            //mContentIntent = intent;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.293 -0400", hash_original_method = "F48B9AE94AA7354563811F0226E4C56E", hash_generated_method = "2C4FCE2CC0FFF6C600938A39A03A17DE")
        public Builder setDeleteIntent(PendingIntent intent) {
            mDeleteIntent = intent;
Builder var72A74007B2BE62B849F475C7BDA4658B_288132914 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_288132914.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_288132914;
            // ---------- Original Method ----------
            //mDeleteIntent = intent;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.294 -0400", hash_original_method = "CE5C618F1F516DEBBF5EC70FA84B35B1", hash_generated_method = "0E0466ED3AAAA60B58426A5FFB4FCD01")
        public Builder setFullScreenIntent(PendingIntent intent, boolean highPriority) {
            addTaint(highPriority);
            mFullScreenIntent = intent;
            setFlag(FLAG_HIGH_PRIORITY, highPriority);
Builder var72A74007B2BE62B849F475C7BDA4658B_1012402777 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1012402777.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1012402777;
            // ---------- Original Method ----------
            //mFullScreenIntent = intent;
            //setFlag(FLAG_HIGH_PRIORITY, highPriority);
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.295 -0400", hash_original_method = "43D2B64A31B6B61BB554BA691C460973", hash_generated_method = "97BD993D7C0C71B8B05D95E65E08115D")
        public Builder setTicker(CharSequence tickerText) {
            mTickerText = tickerText;
Builder var72A74007B2BE62B849F475C7BDA4658B_1157226668 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1157226668.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1157226668;
            // ---------- Original Method ----------
            //mTickerText = tickerText;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.298 -0400", hash_original_method = "4C6C26DEDB76E0CF44BFBAEE6FBE84BC", hash_generated_method = "6397549391990654EFF94AF688BF607C")
        public Builder setTicker(CharSequence tickerText, RemoteViews views) {
            mTickerText = tickerText;
            mTickerView = views;
Builder var72A74007B2BE62B849F475C7BDA4658B_1727882360 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1727882360.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1727882360;
            // ---------- Original Method ----------
            //mTickerText = tickerText;
            //mTickerView = views;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.299 -0400", hash_original_method = "7DCB1EA67ACA56F0B2754C8E360CAB68", hash_generated_method = "239367A88B7FC877ED6FB5FFD13049C2")
        public Builder setLargeIcon(Bitmap icon) {
            mLargeIcon = icon;
Builder var72A74007B2BE62B849F475C7BDA4658B_48544505 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_48544505.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_48544505;
            // ---------- Original Method ----------
            //mLargeIcon = icon;
            //return this;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.300 -0400", hash_original_method = "E4D966D2AF4F815A75885EB0928B9225", hash_generated_method = "88F153A2B2E3459C6D480FCE3AEDD299")
        public Builder setSound(Uri sound) {
            mSound = sound;
            mAudioStreamType = STREAM_DEFAULT;
Builder var72A74007B2BE62B849F475C7BDA4658B_350230413 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_350230413.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_350230413;
            // ---------- Original Method ----------
            //mSound = sound;
            //mAudioStreamType = STREAM_DEFAULT;
            //return this;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.301 -0400", hash_original_method = "2D9F8E95A20AD7FBCF7EC4A8FF50BED5", hash_generated_method = "EF89C1207143C84FFBDDF9D3E7210617")
        public Builder setSound(Uri sound, int streamType) {
            mSound = sound;
            mAudioStreamType = streamType;
Builder var72A74007B2BE62B849F475C7BDA4658B_1634197314 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1634197314.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1634197314;
            // ---------- Original Method ----------
            //mSound = sound;
            //mAudioStreamType = streamType;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.302 -0400", hash_original_method = "A86D234FAB504C5B3A4DEC6712517174", hash_generated_method = "BCC32897C0D98FC1416BA73D88B4129D")
        public Builder setVibrate(long[] pattern) {
            mVibrate = pattern;
Builder var72A74007B2BE62B849F475C7BDA4658B_1076788540 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1076788540.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1076788540;
            // ---------- Original Method ----------
            //mVibrate = pattern;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.303 -0400", hash_original_method = "06C76CABA696566E00D48B5A1D10E8B9", hash_generated_method = "6E98470E47B281E8D14EAB8CF157A4D9")
        public Builder setLights(int argb, int onMs, int offMs) {
            mLedArgb = argb;
            mLedOnMs = onMs;
            mLedOffMs = offMs;
Builder var72A74007B2BE62B849F475C7BDA4658B_1268897869 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1268897869.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1268897869;
            // ---------- Original Method ----------
            //mLedArgb = argb;
            //mLedOnMs = onMs;
            //mLedOffMs = offMs;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.304 -0400", hash_original_method = "4EE6022E7B7D173E4F9ABC4B52771BC1", hash_generated_method = "B660940E7AA1A9A4700E7DCC6741CA18")
        public Builder setOngoing(boolean ongoing) {
            addTaint(ongoing);
            setFlag(FLAG_ONGOING_EVENT, ongoing);
Builder var72A74007B2BE62B849F475C7BDA4658B_182979646 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_182979646.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_182979646;
            // ---------- Original Method ----------
            //setFlag(FLAG_ONGOING_EVENT, ongoing);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.304 -0400", hash_original_method = "19CD7AC7B316FEB13981077CC28EC4D6", hash_generated_method = "9C6F7E9663ED0FD09570147D3EEC7CA5")
        public Builder setOnlyAlertOnce(boolean onlyAlertOnce) {
            addTaint(onlyAlertOnce);
            setFlag(FLAG_ONLY_ALERT_ONCE, onlyAlertOnce);
Builder var72A74007B2BE62B849F475C7BDA4658B_405281042 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_405281042.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_405281042;
            // ---------- Original Method ----------
            //setFlag(FLAG_ONLY_ALERT_ONCE, onlyAlertOnce);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.305 -0400", hash_original_method = "65E737424C5371C7C5FE30C163FA340D", hash_generated_method = "8DD80AC6A764825C174760C7255605EC")
        public Builder setAutoCancel(boolean autoCancel) {
            addTaint(autoCancel);
            setFlag(FLAG_AUTO_CANCEL, autoCancel);
Builder var72A74007B2BE62B849F475C7BDA4658B_1144533764 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1144533764.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1144533764;
            // ---------- Original Method ----------
            //setFlag(FLAG_AUTO_CANCEL, autoCancel);
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.306 -0400", hash_original_method = "413289369D1534DD93CD0DF6E13619C0", hash_generated_method = "D3D8C16AD429222CBE5CE1F02D60D1FD")
        public Builder setDefaults(int defaults) {
            mDefaults = defaults;
Builder var72A74007B2BE62B849F475C7BDA4658B_1544423009 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1544423009.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1544423009;
            // ---------- Original Method ----------
            //mDefaults = defaults;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.307 -0400", hash_original_method = "100CC04F928443BDDD1350B26299D2DB", hash_generated_method = "8A7BB69AA36E9A4190E2455BA21998A6")
        private void setFlag(int mask, boolean value) {
            addTaint(value);
            if(value)            
            {
                mFlags |= mask;
            } //End block
            else
            {
                mFlags &= ~mask;
            } //End block
            // ---------- Original Method ----------
            //if (value) {
                //mFlags |= mask;
            //} else {
                //mFlags &= ~mask;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.309 -0400", hash_original_method = "874AA4550BEDC5FDB0E26F145D0FEF64", hash_generated_method = "622CD757E72B07C6EB05AECF9C20BCE9")
        private RemoteViews makeRemoteViews(int resId) {
            addTaint(resId);
            RemoteViews contentView = new RemoteViews(mContext.getPackageName(), resId);
            boolean hasLine3 = false;
            if(mSmallIcon != 0)            
            {
                contentView.setImageViewResource(R.id.icon, mSmallIcon);
                contentView.setViewVisibility(R.id.icon, View.VISIBLE);
            } //End block
            else
            {
                contentView.setViewVisibility(R.id.icon, View.GONE);
            } //End block
            if(mContentTitle != null)            
            {
                contentView.setTextViewText(R.id.title, mContentTitle);
            } //End block
            if(mContentText != null)            
            {
                contentView.setTextViewText(R.id.text, mContentText);
                hasLine3 = true;
            } //End block
            if(mContentInfo != null)            
            {
                contentView.setTextViewText(R.id.info, mContentInfo);
                contentView.setViewVisibility(R.id.info, View.VISIBLE);
                hasLine3 = true;
            } //End block
            else
            if(mNumber > 0)            
            {
                final int tooBig = mContext.getResources().getInteger(
                        R.integer.status_bar_notification_info_maxnum);
                if(mNumber > tooBig)                
                {
                    contentView.setTextViewText(R.id.info, mContext.getResources().getString(
                                R.string.status_bar_notification_info_overflow));
                } //End block
                else
                {
                    NumberFormat f = NumberFormat.getIntegerInstance();
                    contentView.setTextViewText(R.id.info, f.format(mNumber));
                } //End block
                contentView.setViewVisibility(R.id.info, View.VISIBLE);
                hasLine3 = true;
            } //End block
            else
            {
                contentView.setViewVisibility(R.id.info, View.GONE);
            } //End block
            if(mProgressMax != 0 || mProgressIndeterminate)            
            {
                contentView.setProgressBar(
                        R.id.progress, mProgressMax, mProgress, mProgressIndeterminate);
                contentView.setViewVisibility(R.id.progress, View.VISIBLE);
            } //End block
            else
            {
                contentView.setViewVisibility(R.id.progress, View.GONE);
            } //End block
            if(mWhen != 0)            
            {
                contentView.setLong(R.id.time, "setTime", mWhen);
            } //End block
            contentView.setViewVisibility(R.id.line3, hasLine3 ? View.VISIBLE : View.GONE);
RemoteViews var578C70E4622E1015397CF3599897AE7C_757343269 =             contentView;
            var578C70E4622E1015397CF3599897AE7C_757343269.addTaint(taint);
            return var578C70E4622E1015397CF3599897AE7C_757343269;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.310 -0400", hash_original_method = "BA4EC765F0E429DA930DFC57746DA461", hash_generated_method = "DA736A4E06DFC6D2AC738CCB08B010F6")
        private RemoteViews makeContentView() {
            if(mContentView != null)            
            {
RemoteViews var11075ABCE34FC88A4EDC97AAF35631A1_2012254014 =                 mContentView;
                var11075ABCE34FC88A4EDC97AAF35631A1_2012254014.addTaint(taint);
                return var11075ABCE34FC88A4EDC97AAF35631A1_2012254014;
            } //End block
            else
            {
RemoteViews varE91C3C6A4F8F44D79CCAB685A1AAFA87_1115424496 =                 makeRemoteViews(mLargeIcon == null
                            ? R.layout.status_bar_latest_event_content
                        : R.layout.status_bar_latest_event_content_large_icon);
                varE91C3C6A4F8F44D79CCAB685A1AAFA87_1115424496.addTaint(taint);
                return varE91C3C6A4F8F44D79CCAB685A1AAFA87_1115424496;
            } //End block
            // ---------- Original Method ----------
            //if (mContentView != null) {
                //return mContentView;
            //} else {
                    //return makeRemoteViews(mLargeIcon == null
                            //? R.layout.status_bar_latest_event_content
                        //: R.layout.status_bar_latest_event_content_large_icon);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.311 -0400", hash_original_method = "E7ABF10FCA5C3841BF6DB5E454736B56", hash_generated_method = "771CBA880CC16FEE75847E54B0CB3C00")
        private RemoteViews makeTickerView() {
            if(mTickerView != null)            
            {
RemoteViews varAD8480C3025C14A6B708489B7BCFACD5_1346346291 =                 mTickerView;
                varAD8480C3025C14A6B708489B7BCFACD5_1346346291.addTaint(taint);
                return varAD8480C3025C14A6B708489B7BCFACD5_1346346291;
            } //End block
            else
            {
                if(mContentView == null)                
                {
RemoteViews var374C8AFE179D180485698087C83415FE_915146983 =                     makeRemoteViews(mLargeIcon == null
                            ? R.layout.status_bar_latest_event_ticker
                            : R.layout.status_bar_latest_event_ticker_large_icon);
                    var374C8AFE179D180485698087C83415FE_915146983.addTaint(taint);
                    return var374C8AFE179D180485698087C83415FE_915146983;
                } //End block
                else
                {
RemoteViews var540C13E9E156B687226421B24F2DF178_1694393353 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1694393353.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1694393353;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (mTickerView != null) {
                //return mTickerView;
            //} else {
                //if (mContentView == null) {
                    //return makeRemoteViews(mLargeIcon == null
                            //? R.layout.status_bar_latest_event_ticker
                            //: R.layout.status_bar_latest_event_ticker_large_icon);
                //} else {
                    //return null;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.315 -0400", hash_original_method = "ACBCD2459BD592E66E9A1B94FF396B6B", hash_generated_method = "76E27D4038399617D75629C4806725ED")
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
            if(mLedOnMs != 0 && mLedOffMs != 0)            
            {
                n.flags |= FLAG_SHOW_LIGHTS;
            } //End block
            if((mDefaults & DEFAULT_LIGHTS) != 0)            
            {
                n.flags |= FLAG_SHOW_LIGHTS;
            } //End block
Notification var041154653C812B0D1663EC287BE4C757_1580152631 =             n;
            var041154653C812B0D1663EC287BE4C757_1580152631.addTaint(taint);
            return var041154653C812B0D1663EC287BE4C757_1580152631;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.315 -0400", hash_original_field = "A58722960CCC108319DC7C1222FEA5A9", hash_generated_field = "493D0EBDAE7097F899550C884AC22A2C")

    public static final int DEFAULT_ALL = ~0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.315 -0400", hash_original_field = "3ED7F4A94F3A25E7C23E0BD5D0F04E9E", hash_generated_field = "EBEB29EEA1677186411B0676C7CB6CA8")

    public static final int DEFAULT_SOUND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.315 -0400", hash_original_field = "D9A5E31DE76EB62BD642E7D3B8715F0A", hash_generated_field = "625958CF78DAC59C5F668018906E7A25")

    public static final int DEFAULT_VIBRATE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.316 -0400", hash_original_field = "AA58C254EF295598E86C2D29CFB254DD", hash_generated_field = "08672983F6AA38AE8CB005A3B0951E14")

    public static final int DEFAULT_LIGHTS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.316 -0400", hash_original_field = "146CEB05EF1DE3B063ACA546DDC916BE", hash_generated_field = "03418D428EB9B0647508E7584179BDCC")

    public static final int STREAM_DEFAULT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.316 -0400", hash_original_field = "A135016EFA1C41336B58A5C49B7C7E5F", hash_generated_field = "3EA71E6BEF191625FDE53FA428627FCD")

    public static final int FLAG_SHOW_LIGHTS        = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.316 -0400", hash_original_field = "E3EF8F49801BC60F819163B5308BBDDE", hash_generated_field = "4212FDC8E3576C78F889BF1A169268A1")

    public static final int FLAG_ONGOING_EVENT      = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.316 -0400", hash_original_field = "71C74B0E7410FEE495CE02DC62E01C61", hash_generated_field = "5E4C5667DCB9D60C104C3E79AF4A4C18")

    public static final int FLAG_INSISTENT          = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.316 -0400", hash_original_field = "02AF7F064B1F5B6E6B42676ECD491380", hash_generated_field = "500F040419409BB73C946F7E5EAF73E0")

    public static final int FLAG_ONLY_ALERT_ONCE    = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.316 -0400", hash_original_field = "D9D0119AEB98145A13896C2AAECAAAA8", hash_generated_field = "E5EB78F93DFB40825F4ED628FB1B6DFC")

    public static final int FLAG_AUTO_CANCEL        = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.316 -0400", hash_original_field = "52AEFD886A8F3C7313B41B06EAB34822", hash_generated_field = "EC8515FDF436BE99F3787638E8918138")

    public static final int FLAG_NO_CLEAR           = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.316 -0400", hash_original_field = "A817890516698BE4871479105BBE871D", hash_generated_field = "4891EB5C3AD9C34A5B31934636D873FF")

    public static final int FLAG_FOREGROUND_SERVICE = 0x00000040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.317 -0400", hash_original_field = "76F01FB5C067B2101AED125EC1FBF0BA", hash_generated_field = "922B7B86CB8DA2C0A66A1F85C3129923")

    public static final int FLAG_HIGH_PRIORITY = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.317 -0400", hash_original_field = "50F431254E99137F341327FC6639553A", hash_generated_field = "4FA917F3775D815CA3B6257FE54BF16E")

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

