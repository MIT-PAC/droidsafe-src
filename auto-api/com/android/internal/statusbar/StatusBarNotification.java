package com.android.internal.statusbar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Notification;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RemoteViews;

public class StatusBarNotification implements Parcelable {
    public String pkg;
    public int id;
    public String tag;
    public int uid;
    public int initialPid;
    public Notification notification;
    public int priority = PRIORITY_NORMAL;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.545 -0400", hash_original_method = "67871004722566D23E9A988108B7F987", hash_generated_method = "95B32D5EFB1398D99186DD6F4B00F4E3")
    @DSModeled(DSC.SAFE)
    public StatusBarNotification() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.546 -0400", hash_original_method = "31FFD1296543E6D8D3F8FDDB25CF0B1D", hash_generated_method = "69D080B77726FCFCD6000E5D24F6595D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StatusBarNotification(String pkg, int id, String tag,
            int uid, int initialPid, Notification notification) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(id);
        dsTaint.addTaint(initialPid);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(notification.dsTaint);
        dsTaint.addTaint(pkg);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        this.priority = PRIORITY_NORMAL;
        // ---------- Original Method ----------
        //if (pkg == null) throw new NullPointerException();
        //if (notification == null) throw new NullPointerException();
        //this.pkg = pkg;
        //this.id = id;
        //this.tag = tag;
        //this.uid = uid;
        //this.initialPid = initialPid;
        //this.notification = notification;
        //this.priority = PRIORITY_NORMAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.546 -0400", hash_original_method = "88BC9CA5B9D8668DF6500A5DA63636B0", hash_generated_method = "5E340DD8533EA1D6423873ACC428A6D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StatusBarNotification(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        readFromParcel(in);
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.546 -0400", hash_original_method = "1B61FE4141C93529185B88C88AAE7510", hash_generated_method = "F4FAA2F474D5BEDA942492732A2629D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        this.pkg = in.readString();
        this.id = in.readInt();
        {
            boolean var25D67F28E4887DDC152DCB9726EAB4D3_757541105 = (in.readInt() != 0);
            {
                this.tag = in.readString();
            } //End block
            {
                this.tag = null;
            } //End block
        } //End collapsed parenthetic
        this.uid = in.readInt();
        this.initialPid = in.readInt();
        this.priority = in.readInt();
        this.notification = new Notification(in);
        // ---------- Original Method ----------
        //this.pkg = in.readString();
        //this.id = in.readInt();
        //if (in.readInt() != 0) {
            //this.tag = in.readString();
        //} else {
            //this.tag = null;
        //}
        //this.uid = in.readInt();
        //this.initialPid = in.readInt();
        //this.priority = in.readInt();
        //this.notification = new Notification(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.547 -0400", hash_original_method = "E1CEBE0CBC31424403A596077856AB81", hash_generated_method = "9478C2A2A3A59EA3D348299A22EDBD3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeString(this.pkg);
        out.writeInt(this.id);
        {
            out.writeInt(1);
            out.writeString(this.tag);
        } //End block
        {
            out.writeInt(0);
        } //End block
        out.writeInt(this.uid);
        out.writeInt(this.initialPid);
        out.writeInt(this.priority);
        this.notification.writeToParcel(out, flags);
        // ---------- Original Method ----------
        //out.writeString(this.pkg);
        //out.writeInt(this.id);
        //if (this.tag != null) {
            //out.writeInt(1);
            //out.writeString(this.tag);
        //} else {
            //out.writeInt(0);
        //}
        //out.writeInt(this.uid);
        //out.writeInt(this.initialPid);
        //out.writeInt(this.priority);
        //this.notification.writeToParcel(out, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.547 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.547 -0400", hash_original_method = "D4457BF5780841D42A453C9EF4E52627", hash_generated_method = "42862164E736250B594AC62C7E3C1092")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StatusBarNotification clone() {
        StatusBarNotification var0E896FCE770E5AB59F493CB4136F3B25_1171690537 = (new StatusBarNotification(this.pkg, this.id, this.tag,
                this.uid, this.initialPid, this.notification.clone()));
        return (StatusBarNotification)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new StatusBarNotification(this.pkg, this.id, this.tag,
                //this.uid, this.initialPid, this.notification.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.547 -0400", hash_original_method = "8CD358CFA5A2F08AEF9168AA24337844", hash_generated_method = "56F3DB6FBB286D50E616AECC2B679933")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "StatusBarNotification(package=" + pkg + " id=" + id + " tag=" + tag
                //+ " notification=" + notification + " priority=" + priority + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.548 -0400", hash_original_method = "7CE63774DFBFD9AF881A293653A5D73C", hash_generated_method = "2E4D72C0141FE959789465C02B57B026")
    @DSModeled(DSC.SAFE)
    public boolean isOngoing() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (notification.flags & Notification.FLAG_ONGOING_EVENT) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.548 -0400", hash_original_method = "BD2B0089B2847866F80D96044B172188", hash_generated_method = "5BBD356EBB72B16D034CA14BA2FA0000")
    @DSModeled(DSC.SAFE)
    public boolean isClearable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((notification.flags & Notification.FLAG_ONGOING_EVENT) == 0)
                //&& ((notification.flags & Notification.FLAG_NO_CLEAR) == 0);
    }

    
    public static int PRIORITY_JIFFY_EXPRESS = -100;
    public static int PRIORITY_NORMAL        = 0;
    public static int PRIORITY_ONGOING       = 100;
    public static int PRIORITY_SYSTEM        = 200;
    public static final Parcelable.Creator<StatusBarNotification> CREATOR = new Parcelable.Creator<StatusBarNotification>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.548 -0400", hash_original_method = "53E43DF374E573E5EFF47676B4DCAB1C", hash_generated_method = "4AF9DFF21E9B153F3FD4F84D272ED1EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StatusBarNotification createFromParcel(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            StatusBarNotification var29334F18ED23B0CF8963EBB5B672C371_361179083 = (new StatusBarNotification(parcel));
            return (StatusBarNotification)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new StatusBarNotification(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.548 -0400", hash_original_method = "B74D9360912B64B2719C559A16D795D5", hash_generated_method = "B04D9AE1D8228B4CF8D1D9E0836D246C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StatusBarNotification[] newArray(int size) {
            dsTaint.addTaint(size);
            StatusBarNotification[] var7CA679E63D0FEFDEF3EE48509BEDF0EC_1023043247 = (new StatusBarNotification[size]);
            return (StatusBarNotification[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new StatusBarNotification[size];
        }

        
}; //Transformed anonymous class
}

