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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.012 -0400", hash_original_field = "A46A1BCE0B67C45BEC8F435BD5390A54", hash_generated_field = "276A3FDBDB0E5004A69EB76E3522B712")

    public String pkg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.012 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

    public int id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.012 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "928ED6D003A1BBA8E668A5F46546830A")

    public String tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.012 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

    public int uid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.012 -0400", hash_original_field = "270860259DC3902598C68BF08750C140", hash_generated_field = "AA3DEB4AD3CCDD02574F046F6B41232C")

    public int initialPid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.012 -0400", hash_original_field = "0CFD653D5D3E1E9FDBB644523D77971D", hash_generated_field = "A4AEDE3453BB54AA3708EE85BAB11A7C")

    public Notification notification;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.012 -0400", hash_original_field = "388D5BF0DC9FBD42D062CD499FA9987B", hash_generated_field = "87C8A49C336BEBF94409DBFE1A6E9513")

    public int priority = PRIORITY_NORMAL;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.012 -0400", hash_original_method = "67871004722566D23E9A988108B7F987", hash_generated_method = "95B32D5EFB1398D99186DD6F4B00F4E3")
    public  StatusBarNotification() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.013 -0400", hash_original_method = "31FFD1296543E6D8D3F8FDDB25CF0B1D", hash_generated_method = "8B9D9A8EDE4DD5CEC8ED24AF80E8D438")
    public  StatusBarNotification(String pkg, int id, String tag,
            int uid, int initialPid, Notification notification) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        this.pkg = pkg;
        this.id = id;
        this.tag = tag;
        this.uid = uid;
        this.initialPid = initialPid;
        this.notification = notification;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.013 -0400", hash_original_method = "88BC9CA5B9D8668DF6500A5DA63636B0", hash_generated_method = "378C12ACA952E477CFECA742151DDDF5")
    public  StatusBarNotification(Parcel in) {
        readFromParcel(in);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.014 -0400", hash_original_method = "1B61FE4141C93529185B88C88AAE7510", hash_generated_method = "0CB901892F8F2643B07BB17CE10775E7")
    public void readFromParcel(Parcel in) {
        this.pkg = in.readString();
        this.id = in.readInt();
        {
            boolean var25D67F28E4887DDC152DCB9726EAB4D3_1575334310 = (in.readInt() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.034 -0400", hash_original_method = "E1CEBE0CBC31424403A596077856AB81", hash_generated_method = "3459BF719445A85B3738E6E5F50A08E4")
    public void writeToParcel(Parcel out, int flags) {
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
        addTaint(out.getTaint());
        addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.037 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C67AAE6A73E0E6AC9372B3F90CE43978")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_189466510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_189466510;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.038 -0400", hash_original_method = "D4457BF5780841D42A453C9EF4E52627", hash_generated_method = "A58B1373A979FDF66DDAC658E87976AF")
    public StatusBarNotification clone() {
        StatusBarNotification varB4EAC82CA7396A68D541C85D26508E83_1302175508 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1302175508 = new StatusBarNotification(this.pkg, this.id, this.tag,
                this.uid, this.initialPid, this.notification.clone());
        varB4EAC82CA7396A68D541C85D26508E83_1302175508.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1302175508;
        // ---------- Original Method ----------
        //return new StatusBarNotification(this.pkg, this.id, this.tag,
                //this.uid, this.initialPid, this.notification.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.038 -0400", hash_original_method = "8CD358CFA5A2F08AEF9168AA24337844", hash_generated_method = "E076C24F8D77E008EF753F0B4E3DBD83")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1094018290 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1094018290 = "StatusBarNotification(package=" + pkg + " id=" + id + " tag=" + tag
                + " notification=" + notification + " priority=" + priority + ")";
        varB4EAC82CA7396A68D541C85D26508E83_1094018290.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1094018290;
        // ---------- Original Method ----------
        //return "StatusBarNotification(package=" + pkg + " id=" + id + " tag=" + tag
                //+ " notification=" + notification + " priority=" + priority + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.039 -0400", hash_original_method = "7CE63774DFBFD9AF881A293653A5D73C", hash_generated_method = "57FA58D42BB8D9E5E3B5A04197B899BD")
    public boolean isOngoing() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2077635741 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2077635741;
        // ---------- Original Method ----------
        //return (notification.flags & Notification.FLAG_ONGOING_EVENT) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.039 -0400", hash_original_method = "BD2B0089B2847866F80D96044B172188", hash_generated_method = "647D1040488E7A99D682656BBE1AFEED")
    public boolean isClearable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1193667304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1193667304;
        // ---------- Original Method ----------
        //return ((notification.flags & Notification.FLAG_ONGOING_EVENT) == 0)
                //&& ((notification.flags & Notification.FLAG_NO_CLEAR) == 0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.039 -0400", hash_original_field = "53D79D31AA1CC0EBC51B9BF7B18664A0", hash_generated_field = "2B49EDD295535B580853723C924CA12C")

    public static int PRIORITY_JIFFY_EXPRESS = -100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.039 -0400", hash_original_field = "31FBA1159F26FEE81B61D03C65F2279B", hash_generated_field = "8D9ABD1C51C38DC0D2C8DDD7CB1C4751")

    public static int PRIORITY_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.039 -0400", hash_original_field = "729D82A6CD3F32459ECE3ED46298C5B0", hash_generated_field = "CC8C4250744D99767687836146798BEF")

    public static int PRIORITY_ONGOING = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.039 -0400", hash_original_field = "B9E8FF119F755DB76180BFFAC12F3868", hash_generated_field = "4DE62F1E40BF7FACFAFBB92AB4DC4458")

    public static int PRIORITY_SYSTEM = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.039 -0400", hash_original_field = "FBC296099DA268D55B818E08436A3005", hash_generated_field = "2645D879048587FE6A50F9198CCFA95B")

    public static final Parcelable.Creator<StatusBarNotification> CREATOR
            = new Parcelable.Creator<StatusBarNotification>()
    {
        public StatusBarNotification createFromParcel(Parcel parcel)
        {
            return new StatusBarNotification(parcel);
        }

        public StatusBarNotification[] newArray(int size)
        {
            return new StatusBarNotification[size];
        }
    };
}

