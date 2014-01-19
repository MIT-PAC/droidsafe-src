package com.android.internal.statusbar;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.Notification;
import android.os.Parcel;
import android.os.Parcelable;

public class StatusBarNotification implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.649 -0500", hash_original_field = "C6224E3C9D94042A9DD9B0F771EC88D2", hash_generated_field = "2B49EDD295535B580853723C924CA12C")

    public static int PRIORITY_JIFFY_EXPRESS = -100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.652 -0500", hash_original_field = "3DD173AA0618E432D9BEB724BB17A53C", hash_generated_field = "8D9ABD1C51C38DC0D2C8DDD7CB1C4751")

    public static int PRIORITY_NORMAL        = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.654 -0500", hash_original_field = "B8F8047C50DF1257C576E0BC29DA635F", hash_generated_field = "CC8C4250744D99767687836146798BEF")

    public static int PRIORITY_ONGOING       = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.657 -0500", hash_original_field = "FE3C9E509B5F040C334042482CED8E81", hash_generated_field = "4DE62F1E40BF7FACFAFBB92AB4DC4458")

    public static int PRIORITY_SYSTEM        = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.237 -0400", hash_original_field = "FBC296099DA268D55B818E08436A3005", hash_generated_field = "2645D879048587FE6A50F9198CCFA95B")

    public static final Parcelable.Creator<StatusBarNotification> CREATOR
            = new Parcelable.Creator<StatusBarNotification>()
    {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.692 -0500", hash_original_method = "53E43DF374E573E5EFF47676B4DCAB1C", hash_generated_method = "9FA85F6034B931415E39BA0BAC4049D7")
        
public StatusBarNotification createFromParcel(Parcel parcel)
        {
            return new StatusBarNotification(parcel);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.694 -0500", hash_original_method = "B74D9360912B64B2719C559A16D795D5", hash_generated_method = "7C9D48CA05115559BC03B8532159093A")
        
public StatusBarNotification[] newArray(int size)
        {
            return new StatusBarNotification[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.659 -0500", hash_original_field = "742D0CCB1EAA4E727F9FCD5430AF1837", hash_generated_field = "276A3FDBDB0E5004A69EB76E3522B712")

    public String pkg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.662 -0500", hash_original_field = "53E65FEF28E32C7EDCD1B07B4F5A0DE3", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

    public int id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.664 -0500", hash_original_field = "FFCA994A2F44B678330E924D8C87385D", hash_generated_field = "928ED6D003A1BBA8E668A5F46546830A")

    public String tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.666 -0500", hash_original_field = "12FA9B6FF5DE3157A8BC781F3445534B", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

    public int uid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.668 -0500", hash_original_field = "1ACA953B907E6414EA212BDAB1CF2A9E", hash_generated_field = "AA3DEB4AD3CCDD02574F046F6B41232C")

    public int initialPid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.670 -0500", hash_original_field = "737B414881C339518FFC992865D5A333", hash_generated_field = "A4AEDE3453BB54AA3708EE85BAB11A7C")

    public Notification notification;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.672 -0500", hash_original_field = "FED32C58FF3EC80D7BBFB75D2DE70C79", hash_generated_field = "87C8A49C336BEBF94409DBFE1A6E9513")

    public int priority = PRIORITY_NORMAL;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.675 -0500", hash_original_method = "67871004722566D23E9A988108B7F987", hash_generated_method = "A4C3BAA3205AD5EE64B3A32DD0FBE32F")
    
public StatusBarNotification() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.678 -0500", hash_original_method = "31FFD1296543E6D8D3F8FDDB25CF0B1D", hash_generated_method = "69CD3A98D280EE5503AE0CBB2ABD06C3")
    
public StatusBarNotification(String pkg, int id, String tag,
            int uid, int initialPid, Notification notification) {
        if (pkg == null) throw new NullPointerException();
        if (notification == null) throw new NullPointerException();

        this.pkg = pkg;
        this.id = id;
        this.tag = tag;
        this.uid = uid;
        this.initialPid = initialPid;
        this.notification = notification;

        this.priority = PRIORITY_NORMAL;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.681 -0500", hash_original_method = "88BC9CA5B9D8668DF6500A5DA63636B0", hash_generated_method = "E182EE3A2D8BEDD0832AF21F2ADE0906")
    
public StatusBarNotification(Parcel in) {
        readFromParcel(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.684 -0500", hash_original_method = "1B61FE4141C93529185B88C88AAE7510", hash_generated_method = "E20BA5B78461C4BBE419CCC00B4C2244")
    
public void readFromParcel(Parcel in) {
        this.pkg = in.readString();
        this.id = in.readInt();
        if (in.readInt() != 0) {
            this.tag = in.readString();
        } else {
            this.tag = null;
        }
        this.uid = in.readInt();
        this.initialPid = in.readInt();
        this.priority = in.readInt();
        this.notification = new Notification(in);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.687 -0500", hash_original_method = "E1CEBE0CBC31424403A596077856AB81", hash_generated_method = "5E58725AD437561CE4D0AEEC7340B390")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.pkg);
        out.writeInt(this.id);
        if (this.tag != null) {
            out.writeInt(1);
            out.writeString(this.tag);
        } else {
            out.writeInt(0);
        }
        out.writeInt(this.uid);
        out.writeInt(this.initialPid);
        out.writeInt(this.priority);
        this.notification.writeToParcel(out, flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.689 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.699 -0500", hash_original_method = "D4457BF5780841D42A453C9EF4E52627", hash_generated_method = "B0DF9AC149F7E6955196F1D99A54FDC8")
    
public StatusBarNotification clone() {
        return new StatusBarNotification(this.pkg, this.id, this.tag,
                this.uid, this.initialPid, this.notification.clone());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.701 -0500", hash_original_method = "8CD358CFA5A2F08AEF9168AA24337844", hash_generated_method = "E14803EA7B60A6C308199D848F3645DC")
    
public String toString() {
        return "StatusBarNotification(package=" + pkg + " id=" + id + " tag=" + tag
                + " notification=" + notification + " priority=" + priority + ")";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.704 -0500", hash_original_method = "7CE63774DFBFD9AF881A293653A5D73C", hash_generated_method = "07714C0D296B987D869A628EAEFD4A01")
    
public boolean isOngoing() {
        return (notification.flags & Notification.FLAG_ONGOING_EVENT) != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.706 -0500", hash_original_method = "BD2B0089B2847866F80D96044B172188", hash_generated_method = "7FD67D45B793CF7ABA3F19D0504D3ACD")
    
public boolean isClearable() {
        return ((notification.flags & Notification.FLAG_ONGOING_EVENT) == 0)
                && ((notification.flags & Notification.FLAG_NO_CLEAR) == 0);
    }
    // orphaned legacy method
    public StatusBarNotification createFromParcel(Parcel parcel)
        {
            return new StatusBarNotification(parcel);
        }
    
    // orphaned legacy method
    public StatusBarNotification[] newArray(int size)
        {
            return new StatusBarNotification[size];
        }
    
}

