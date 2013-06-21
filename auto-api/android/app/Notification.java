package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    public long when;
    public int icon;
    public int iconLevel;
    public int number;
    public PendingIntent contentIntent;
    public PendingIntent deleteIntent;
    public PendingIntent fullScreenIntent;
    public CharSequence tickerText;
    public RemoteViews tickerView;
    public RemoteViews contentView;
    public Bitmap largeIcon;
    public Uri sound;
    public int audioStreamType = STREAM_DEFAULT;
    public long[] vibrate;
    public int ledARGB;
    public int ledOnMS;
    public int ledOffMS;
    public int defaults;
    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.420 -0400", hash_original_method = "1CE373DE78E11DB8401FDC6F724116BB", hash_generated_method = "3BC0A224E78F0325AA3722F16B15028A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Notification() {
        this.when = System.currentTimeMillis();
        // ---------- Original Method ----------
        //this.when = System.currentTimeMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.421 -0400", hash_original_method = "F912A2DECFC167F58680F860007D2BB5", hash_generated_method = "A0A208054C11D5AFE10D210C4CCB82A0")
    @DSModeled(DSC.SPEC)
    public Notification(Context context, int icon, CharSequence tickerText, long when,
            CharSequence contentTitle, CharSequence contentText, Intent contentIntent) {
        dsTaint.addTaint(icon);
        dsTaint.addTaint(tickerText);
        dsTaint.addTaint(contentTitle);
        dsTaint.addTaint(when);
        dsTaint.addTaint(contentIntent.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(contentText);
        setLatestEventInfo(context, contentTitle, contentText,
                PendingIntent.getActivity(context, 0, contentIntent, 0));
        // ---------- Original Method ----------
        //this.when = when;
        //this.icon = icon;
        //this.tickerText = tickerText;
        //setLatestEventInfo(context, contentTitle, contentText,
                //PendingIntent.getActivity(context, 0, contentIntent, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.421 -0400", hash_original_method = "CC2BF19BEFE3DF69C00F83DC5FB8C9D2", hash_generated_method = "1ABBDBBFB3C193CB1AA5ECFF8E327751")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public Notification(int icon, CharSequence tickerText, long when) {
        dsTaint.addTaint(icon);
        dsTaint.addTaint(tickerText);
        dsTaint.addTaint(when);
        // ---------- Original Method ----------
        //this.icon = icon;
        //this.tickerText = tickerText;
        //this.when = when;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.422 -0400", hash_original_method = "B9AE56CCF72BA824A2D5505B37E7A00A", hash_generated_method = "A089D73FF35477DBF0754E0721E93E1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Notification(Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
        int version;
        version = parcel.readInt();
        when = parcel.readLong();
        icon = parcel.readInt();
        number = parcel.readInt();
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_1060414125 = (parcel.readInt() != 0);
            {
                contentIntent = PendingIntent.CREATOR.createFromParcel(parcel);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_515516450 = (parcel.readInt() != 0);
            {
                deleteIntent = PendingIntent.CREATOR.createFromParcel(parcel);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_916154591 = (parcel.readInt() != 0);
            {
                tickerText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_485219032 = (parcel.readInt() != 0);
            {
                tickerView = RemoteViews.CREATOR.createFromParcel(parcel);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_1612579481 = (parcel.readInt() != 0);
            {
                contentView = RemoteViews.CREATOR.createFromParcel(parcel);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_1739701620 = (parcel.readInt() != 0);
            {
                largeIcon = Bitmap.CREATOR.createFromParcel(parcel);
            } //End block
        } //End collapsed parenthetic
        defaults = parcel.readInt();
        flags = parcel.readInt();
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_587776981 = (parcel.readInt() != 0);
            {
                sound = Uri.CREATOR.createFromParcel(parcel);
            } //End block
        } //End collapsed parenthetic
        audioStreamType = parcel.readInt();
        vibrate = parcel.createLongArray();
        ledARGB = parcel.readInt();
        ledOnMS = parcel.readInt();
        ledOffMS = parcel.readInt();
        iconLevel = parcel.readInt();
        {
            boolean var60F8D07B3C0E7118926980924B5BD631_2146414731 = (parcel.readInt() != 0);
            {
                fullScreenIntent = PendingIntent.CREATOR.createFromParcel(parcel);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.423 -0400", hash_original_method = "6AF2D89F1A077EC9692C07FAE6A31E51", hash_generated_method = "123099A6AAD8430F572CC00C740098D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Notification clone() {
        Notification that;
        that = new Notification();
        that.when = this.when;
        that.icon = this.icon;
        that.number = this.number;
        that.contentIntent = this.contentIntent;
        that.deleteIntent = this.deleteIntent;
        that.fullScreenIntent = this.fullScreenIntent;
        {
            that.tickerText = this.tickerText.toString();
        } //End block
        {
            that.tickerView = this.tickerView.clone();
        } //End block
        {
            that.contentView = this.contentView.clone();
        } //End block
        {
            that.largeIcon = Bitmap.createBitmap(this.largeIcon);
        } //End block
        that.iconLevel = this.iconLevel;
        that.sound = this.sound;
        that.audioStreamType = this.audioStreamType;
        long[] vibrate;
        vibrate = this.vibrate;
        {
            int N;
            N = vibrate.length;
            long[] vib;
            vib = that.vibrate = new long[N];
            System.arraycopy(vibrate, 0, vib, 0, N);
        } //End block
        that.ledARGB = this.ledARGB;
        that.ledOnMS = this.ledOnMS;
        that.ledOffMS = this.ledOffMS;
        that.defaults = this.defaults;
        that.flags = this.flags;
        return (Notification)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.424 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.425 -0400", hash_original_method = "2E97C8DA884DBA934FB3E6EBE25C30F5", hash_generated_method = "1917BB16FA472B38EE39E2A6A51BF026")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
        parcel.writeInt(1);
        parcel.writeLong(when);
        parcel.writeInt(icon);
        parcel.writeInt(number);
        {
            parcel.writeInt(1);
            contentIntent.writeToParcel(parcel, 0);
        } //End block
        {
            parcel.writeInt(0);
        } //End block
        {
            parcel.writeInt(1);
            deleteIntent.writeToParcel(parcel, 0);
        } //End block
        {
            parcel.writeInt(0);
        } //End block
        {
            parcel.writeInt(1);
            TextUtils.writeToParcel(tickerText, parcel, flags);
        } //End block
        {
            parcel.writeInt(0);
        } //End block
        {
            parcel.writeInt(1);
            tickerView.writeToParcel(parcel, 0);
        } //End block
        {
            parcel.writeInt(0);
        } //End block
        {
            parcel.writeInt(1);
            contentView.writeToParcel(parcel, 0);
        } //End block
        {
            parcel.writeInt(0);
        } //End block
        {
            parcel.writeInt(1);
            largeIcon.writeToParcel(parcel, 0);
        } //End block
        {
            parcel.writeInt(0);
        } //End block
        parcel.writeInt(defaults);
        parcel.writeInt(this.flags);
        {
            parcel.writeInt(1);
            sound.writeToParcel(parcel, 0);
        } //End block
        {
            parcel.writeInt(0);
        } //End block
        parcel.writeInt(audioStreamType);
        parcel.writeLongArray(vibrate);
        parcel.writeInt(ledARGB);
        parcel.writeInt(ledOnMS);
        parcel.writeInt(ledOffMS);
        parcel.writeInt(iconLevel);
        {
            parcel.writeInt(1);
            fullScreenIntent.writeToParcel(parcel, 0);
        } //End block
        {
            parcel.writeInt(0);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.425 -0400", hash_original_method = "15C64B5C143E30BF8DB14A898F7C5E53", hash_generated_method = "90ED20790C3C22941C9F9806F896B8C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setLatestEventInfo(Context context,
            CharSequence contentTitle, CharSequence contentText, PendingIntent contentIntent) {
        dsTaint.addTaint(contentTitle);
        dsTaint.addTaint(contentIntent.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(contentText);
        RemoteViews contentView;
        contentView = new RemoteViews(context.getPackageName(),
                R.layout.status_bar_latest_event_content);
        {
            contentView.setImageViewResource(R.id.icon, this.icon);
        } //End block
        {
            contentView.setTextViewText(R.id.title, contentTitle);
        } //End block
        {
            contentView.setTextViewText(R.id.text, contentText);
        } //End block
        {
            contentView.setLong(R.id.time, "setTime", when);
        } //End block
        this.contentView = contentView;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.426 -0400", hash_original_method = "12C6B6D4BE06143C5E4298E3E5EDBF7E", hash_generated_method = "5DD1A845621317F301103531B428A77D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Notification(contentView=");
        {
            sb.append(contentView.getPackage());
            sb.append("/0x");
            sb.append(Integer.toHexString(contentView.getLayoutId()));
        } //End block
        {
            sb.append("null");
        } //End block
        sb.append(" vibrate=");
        {
            int N;
            N = this.vibrate.length-1;
            sb.append("[");
            {
                int i;
                i = 0;
                {
                    sb.append(this.vibrate[i]);
                    sb.append(',');
                } //End block
            } //End collapsed parenthetic
            {
                sb.append(this.vibrate[N]);
            } //End block
            sb.append("]");
        } //End block
        {
            sb.append("default");
        } //End block
        {
            sb.append("null");
        } //End block
        sb.append(",sound=");
        {
            sb.append(this.sound.toString());
        } //End block
        {
            sb.append("default");
        } //End block
        {
            sb.append("null");
        } //End block
        sb.append(",defaults=0x");
        sb.append(Integer.toHexString(this.defaults));
        sb.append(",flags=0x");
        sb.append(Integer.toHexString(this.flags));
        {
            sb.append("!!!1!one!");
        } //End block
        sb.append(")");
        String var806458D832AB974D230FEE4CBBDBD390_213697221 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class Builder {
        private Context mContext;
        private long mWhen;
        private int mSmallIcon;
        private int mSmallIconLevel;
        private int mNumber;
        private CharSequence mContentTitle;
        private CharSequence mContentText;
        private CharSequence mContentInfo;
        private PendingIntent mContentIntent;
        private RemoteViews mContentView;
        private PendingIntent mDeleteIntent;
        private PendingIntent mFullScreenIntent;
        private CharSequence mTickerText;
        private RemoteViews mTickerView;
        private Bitmap mLargeIcon;
        private Uri mSound;
        private int mAudioStreamType;
        private long[] mVibrate;
        private int mLedArgb;
        private int mLedOnMs;
        private int mLedOffMs;
        private int mDefaults;
        private int mFlags;
        private int mProgressMax;
        private int mProgress;
        private boolean mProgressIndeterminate;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.427 -0400", hash_original_method = "A0705CD8F7169475619B80AC2CAED080", hash_generated_method = "E32D93CE5C94DC04DF51B1454BBBC764")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder(Context context) {
            dsTaint.addTaint(context.dsTaint);
            mWhen = System.currentTimeMillis();
            mAudioStreamType = STREAM_DEFAULT;
            // ---------- Original Method ----------
            //mContext = context;
            //mWhen = System.currentTimeMillis();
            //mAudioStreamType = STREAM_DEFAULT;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.427 -0400", hash_original_method = "F33CFE0DDEF1BDE88E81CA07B2B4AF4A", hash_generated_method = "41C2D9ED49797A43441525F117E5B37C")
        @DSModeled(DSC.SAFE)
        public Builder setWhen(long when) {
            dsTaint.addTaint(when);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mWhen = when;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.428 -0400", hash_original_method = "76509FA1EC330D1A963F56DC8E00B5D8", hash_generated_method = "D3630F24966998BFCDEE763EA47387FC")
        @DSModeled(DSC.SAFE)
        public Builder setSmallIcon(int icon) {
            dsTaint.addTaint(icon);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mSmallIcon = icon;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.428 -0400", hash_original_method = "686130331B3575C911C4ACE6437F15B8", hash_generated_method = "CACE23D1E967F0D2BA46B167370AD021")
        @DSModeled(DSC.SAFE)
        public Builder setSmallIcon(int icon, int level) {
            dsTaint.addTaint(icon);
            dsTaint.addTaint(level);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mSmallIcon = icon;
            //mSmallIconLevel = level;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.428 -0400", hash_original_method = "51D215D9B594EB5434D1A4893B0851B6", hash_generated_method = "F6F93C04E62C77AB84E883B8CE973628")
        @DSModeled(DSC.SAFE)
        public Builder setContentTitle(CharSequence title) {
            dsTaint.addTaint(title);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mContentTitle = title;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.429 -0400", hash_original_method = "3B85C73BAA4531891B097F4FBFA7845D", hash_generated_method = "1C77856593ED23789E6FAEDAF6A1CA9A")
        @DSModeled(DSC.SAFE)
        public Builder setContentText(CharSequence text) {
            dsTaint.addTaint(text);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mContentText = text;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.438 -0400", hash_original_method = "5E0FC1F68404C1057ACE1D67E6ED676A", hash_generated_method = "704EFBA621815293332DD9241A0EC156")
        @DSModeled(DSC.SAFE)
        public Builder setNumber(int number) {
            dsTaint.addTaint(number);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mNumber = number;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.438 -0400", hash_original_method = "52A8AABE54D5BDFE521B8B41861DFCD9", hash_generated_method = "154A63C0E4F2A7CF02F89F2BF466077B")
        @DSModeled(DSC.SAFE)
        public Builder setContentInfo(CharSequence info) {
            dsTaint.addTaint(info);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mContentInfo = info;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.439 -0400", hash_original_method = "D0B2BE14A572EFF2EC3981BC799BA989", hash_generated_method = "A2174BFBA369B2A41599CFAA94440EA0")
        @DSModeled(DSC.SAFE)
        public Builder setProgress(int max, int progress, boolean indeterminate) {
            dsTaint.addTaint(progress);
            dsTaint.addTaint(max);
            dsTaint.addTaint(indeterminate);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mProgressMax = max;
            //mProgress = progress;
            //mProgressIndeterminate = indeterminate;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.439 -0400", hash_original_method = "0C2B2238CAAAD5F7B913F4DC0C6DE3C5", hash_generated_method = "EE302E764984B3A46487DAEE5A0B0FFB")
        @DSModeled(DSC.SAFE)
        public Builder setContent(RemoteViews views) {
            dsTaint.addTaint(views.dsTaint);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mContentView = views;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.439 -0400", hash_original_method = "13AF9850EB916E3E1CD09235309F6318", hash_generated_method = "93CFC1A421310A1AFD2BD79065F39AF7")
        @DSModeled(DSC.SAFE)
        public Builder setContentIntent(PendingIntent intent) {
            dsTaint.addTaint(intent.dsTaint);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mContentIntent = intent;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.444 -0400", hash_original_method = "F48B9AE94AA7354563811F0226E4C56E", hash_generated_method = "121A5E22FFCBE460F7B6494995A69E0F")
        @DSModeled(DSC.SAFE)
        public Builder setDeleteIntent(PendingIntent intent) {
            dsTaint.addTaint(intent.dsTaint);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mDeleteIntent = intent;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.445 -0400", hash_original_method = "CE5C618F1F516DEBBF5EC70FA84B35B1", hash_generated_method = "D9B7841828D99C557DAADF5241ED29CB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setFullScreenIntent(PendingIntent intent, boolean highPriority) {
            dsTaint.addTaint(intent.dsTaint);
            dsTaint.addTaint(highPriority);
            setFlag(FLAG_HIGH_PRIORITY, highPriority);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mFullScreenIntent = intent;
            //setFlag(FLAG_HIGH_PRIORITY, highPriority);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.448 -0400", hash_original_method = "43D2B64A31B6B61BB554BA691C460973", hash_generated_method = "1A309C90C029E0B5E52BF03539FF07D1")
        @DSModeled(DSC.SAFE)
        public Builder setTicker(CharSequence tickerText) {
            dsTaint.addTaint(tickerText);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mTickerText = tickerText;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.448 -0400", hash_original_method = "4C6C26DEDB76E0CF44BFBAEE6FBE84BC", hash_generated_method = "1088715A2A5E858F7755A04003338D1A")
        @DSModeled(DSC.SAFE)
        public Builder setTicker(CharSequence tickerText, RemoteViews views) {
            dsTaint.addTaint(tickerText);
            dsTaint.addTaint(views.dsTaint);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mTickerText = tickerText;
            //mTickerView = views;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.449 -0400", hash_original_method = "7DCB1EA67ACA56F0B2754C8E360CAB68", hash_generated_method = "2646B9930730DD678F6320EF0526DCA6")
        @DSModeled(DSC.SAFE)
        public Builder setLargeIcon(Bitmap icon) {
            dsTaint.addTaint(icon.dsTaint);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mLargeIcon = icon;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.450 -0400", hash_original_method = "E4D966D2AF4F815A75885EB0928B9225", hash_generated_method = "B2A766E512906E665BBBC425BB571E45")
        @DSModeled(DSC.SPEC)
        public Builder setSound(Uri sound) {
            dsTaint.addTaint(sound.dsTaint);
            mAudioStreamType = STREAM_DEFAULT;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mSound = sound;
            //mAudioStreamType = STREAM_DEFAULT;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.450 -0400", hash_original_method = "2D9F8E95A20AD7FBCF7EC4A8FF50BED5", hash_generated_method = "FA8591B33038768A2FC4E2D44556D709")
        @DSModeled(DSC.SPEC)
        public Builder setSound(Uri sound, int streamType) {
            dsTaint.addTaint(sound.dsTaint);
            dsTaint.addTaint(streamType);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mSound = sound;
            //mAudioStreamType = streamType;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.451 -0400", hash_original_method = "A86D234FAB504C5B3A4DEC6712517174", hash_generated_method = "AD6483108853ECEF4282C49271394EFD")
        @DSModeled(DSC.SAFE)
        public Builder setVibrate(long[] pattern) {
            dsTaint.addTaint(pattern[0]);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mVibrate = pattern;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.452 -0400", hash_original_method = "06C76CABA696566E00D48B5A1D10E8B9", hash_generated_method = "7B4FAED88F986AAAAE6B9B42755CC8C6")
        @DSModeled(DSC.SAFE)
        public Builder setLights(int argb, int onMs, int offMs) {
            dsTaint.addTaint(argb);
            dsTaint.addTaint(offMs);
            dsTaint.addTaint(onMs);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mLedArgb = argb;
            //mLedOnMs = onMs;
            //mLedOffMs = offMs;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.454 -0400", hash_original_method = "4EE6022E7B7D173E4F9ABC4B52771BC1", hash_generated_method = "1B9F42E428000B5BA2C05BCF04F4FD79")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setOngoing(boolean ongoing) {
            dsTaint.addTaint(ongoing);
            setFlag(FLAG_ONGOING_EVENT, ongoing);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //setFlag(FLAG_ONGOING_EVENT, ongoing);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.456 -0400", hash_original_method = "19CD7AC7B316FEB13981077CC28EC4D6", hash_generated_method = "FA8B69A888BC69BFF34B90E49672FD84")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setOnlyAlertOnce(boolean onlyAlertOnce) {
            dsTaint.addTaint(onlyAlertOnce);
            setFlag(FLAG_ONLY_ALERT_ONCE, onlyAlertOnce);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //setFlag(FLAG_ONLY_ALERT_ONCE, onlyAlertOnce);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.458 -0400", hash_original_method = "65E737424C5371C7C5FE30C163FA340D", hash_generated_method = "81B1E8F86DEBAA97A77DAE78F14583FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setAutoCancel(boolean autoCancel) {
            dsTaint.addTaint(autoCancel);
            setFlag(FLAG_AUTO_CANCEL, autoCancel);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //setFlag(FLAG_AUTO_CANCEL, autoCancel);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.458 -0400", hash_original_method = "413289369D1534DD93CD0DF6E13619C0", hash_generated_method = "7A233D77F94DAA326F51FFA3169695DE")
        @DSModeled(DSC.SAFE)
        public Builder setDefaults(int defaults) {
            dsTaint.addTaint(defaults);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mDefaults = defaults;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.459 -0400", hash_original_method = "100CC04F928443BDDD1350B26299D2DB", hash_generated_method = "1FA354DD6E17D1276EC7489F3422DE55")
        @DSModeled(DSC.SAFE)
        private void setFlag(int mask, boolean value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(mask);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.460 -0400", hash_original_method = "874AA4550BEDC5FDB0E26F145D0FEF64", hash_generated_method = "541A8AB3527F6778B76D2D942BEB66BF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private RemoteViews makeRemoteViews(int resId) {
            dsTaint.addTaint(resId);
            RemoteViews contentView;
            contentView = new RemoteViews(mContext.getPackageName(), resId);
            boolean hasLine3;
            hasLine3 = false;
            {
                contentView.setImageViewResource(R.id.icon, mSmallIcon);
                contentView.setViewVisibility(R.id.icon, View.VISIBLE);
            } //End block
            {
                contentView.setViewVisibility(R.id.icon, View.GONE);
            } //End block
            {
                contentView.setTextViewText(R.id.title, mContentTitle);
            } //End block
            {
                contentView.setTextViewText(R.id.text, mContentText);
                hasLine3 = true;
            } //End block
            {
                contentView.setTextViewText(R.id.info, mContentInfo);
                contentView.setViewVisibility(R.id.info, View.VISIBLE);
                hasLine3 = true;
            } //End block
            {
                int tooBig;
                tooBig = mContext.getResources().getInteger(
                        R.integer.status_bar_notification_info_maxnum);
                {
                    contentView.setTextViewText(R.id.info, mContext.getResources().getString(
                                R.string.status_bar_notification_info_overflow));
                } //End block
                {
                    NumberFormat f;
                    f = NumberFormat.getIntegerInstance();
                    contentView.setTextViewText(R.id.info, f.format(mNumber));
                } //End block
                contentView.setViewVisibility(R.id.info, View.VISIBLE);
                hasLine3 = true;
            } //End block
            {
                contentView.setViewVisibility(R.id.info, View.GONE);
            } //End block
            {
                contentView.setProgressBar(
                        R.id.progress, mProgressMax, mProgress, mProgressIndeterminate);
                contentView.setViewVisibility(R.id.progress, View.VISIBLE);
            } //End block
            {
                contentView.setViewVisibility(R.id.progress, View.GONE);
            } //End block
            {
                contentView.setLong(R.id.time, "setTime", mWhen);
            } //End block
            contentView.setViewVisibility(R.id.line3, hasLine3 ? View.VISIBLE : View.GONE);
            return (RemoteViews)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.461 -0400", hash_original_method = "BA4EC765F0E429DA930DFC57746DA461", hash_generated_method = "484962EA9560F93EF06D56B00871631C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private RemoteViews makeContentView() {
            {
                RemoteViews var39E1AB56538B78964E3B779947A007C0_936446926 = (makeRemoteViews(mLargeIcon == null
                            ? R.layout.status_bar_latest_event_content
                        : R.layout.status_bar_latest_event_content_large_icon)); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
            return (RemoteViews)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mContentView != null) {
                //return mContentView;
            //} else {
                    //return makeRemoteViews(mLargeIcon == null
                            //? R.layout.status_bar_latest_event_content
                        //: R.layout.status_bar_latest_event_content_large_icon);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.461 -0400", hash_original_method = "E7ABF10FCA5C3841BF6DB5E454736B56", hash_generated_method = "873834E32EC541B149A5D687B3027B8F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private RemoteViews makeTickerView() {
            {
                {
                    RemoteViews varA1F80245E4F4FA8E160452B0D9FA7281_1474673466 = (makeRemoteViews(mLargeIcon == null
                            ? R.layout.status_bar_latest_event_ticker
                            : R.layout.status_bar_latest_event_ticker_large_icon)); //DSFIXME:  CODE0008: Nested ternary operator in expression
                } //End block
            } //End block
            return (RemoteViews)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.462 -0400", hash_original_method = "ACBCD2459BD592E66E9A1B94FF396B6B", hash_generated_method = "7E660DF3819ADC94ABDFD3FA8C5042C9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Notification getNotification() {
            Notification n;
            n = new Notification();
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
            } //End block
            {
                n.flags |= FLAG_SHOW_LIGHTS;
            } //End block
            return (Notification)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public static final int DEFAULT_ALL = ~0;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int STREAM_DEFAULT = -1;
    public static final int FLAG_SHOW_LIGHTS        = 0x00000001;
    public static final int FLAG_ONGOING_EVENT      = 0x00000002;
    public static final int FLAG_INSISTENT          = 0x00000004;
    public static final int FLAG_ONLY_ALERT_ONCE    = 0x00000008;
    public static final int FLAG_AUTO_CANCEL        = 0x00000010;
    public static final int FLAG_NO_CLEAR           = 0x00000020;
    public static final int FLAG_FOREGROUND_SERVICE = 0x00000040;
    public static final int FLAG_HIGH_PRIORITY = 0x00000080;
    public static final Parcelable.Creator<Notification> CREATOR = new Parcelable.Creator<Notification>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.463 -0400", hash_original_method = "640E6F5E88B10B67950DC22B82259969", hash_generated_method = "F341CAD68BC0DEC144FCD0BFF9F44B75")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Notification createFromParcel(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            Notification var02812A73E59FF232E39151DDC14E3F86_1257329508 = (new Notification(parcel));
            return (Notification)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Notification(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.463 -0400", hash_original_method = "FE58AA31658A96AD26D1C6215FA7714A", hash_generated_method = "9F66D804ECCC424720EB82B5C38B2561")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Notification[] newArray(int size) {
            dsTaint.addTaint(size);
            Notification[] var9A36F8A1BBB4F33B0E5E556CDB4B94FD_928179573 = (new Notification[size]);
            return (Notification[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Notification[size];
        }

        
}; //Transformed anonymous class
}

