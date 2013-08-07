package com.android.internal.statusbar;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.app.Notification;
import android.os.Parcel;
import android.os.Parcelable;





public class StatusBarNotification implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.230 -0400", hash_original_field = "A46A1BCE0B67C45BEC8F435BD5390A54", hash_generated_field = "276A3FDBDB0E5004A69EB76E3522B712")

    public String pkg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.230 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

    public int id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.230 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "928ED6D003A1BBA8E668A5F46546830A")

    public String tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.230 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

    public int uid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.230 -0400", hash_original_field = "270860259DC3902598C68BF08750C140", hash_generated_field = "AA3DEB4AD3CCDD02574F046F6B41232C")

    public int initialPid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.230 -0400", hash_original_field = "0CFD653D5D3E1E9FDBB644523D77971D", hash_generated_field = "A4AEDE3453BB54AA3708EE85BAB11A7C")

    public Notification notification;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.230 -0400", hash_original_field = "388D5BF0DC9FBD42D062CD499FA9987B", hash_generated_field = "87C8A49C336BEBF94409DBFE1A6E9513")

    public int priority = PRIORITY_NORMAL;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.231 -0400", hash_original_method = "67871004722566D23E9A988108B7F987", hash_generated_method = "95B32D5EFB1398D99186DD6F4B00F4E3")
    public  StatusBarNotification() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.232 -0400", hash_original_method = "31FFD1296543E6D8D3F8FDDB25CF0B1D", hash_generated_method = "C7F037A8552B66542EDB576C5CA6BE99")
    public  StatusBarNotification(String pkg, int id, String tag,
            int uid, int initialPid, Notification notification) {
        if(pkg == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1073585908 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1073585908.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1073585908;
        }
        if(notification == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_399545529 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_399545529.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_399545529;
        }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.232 -0400", hash_original_method = "88BC9CA5B9D8668DF6500A5DA63636B0", hash_generated_method = "3FD6C4800D9FE62BE9B17F58F02E543E")
    public  StatusBarNotification(Parcel in) {
        addTaint(in.getTaint());
        readFromParcel(in);
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.233 -0400", hash_original_method = "1B61FE4141C93529185B88C88AAE7510", hash_generated_method = "93175BE4B7B10FDDCC527574FF75BF8A")
    public void readFromParcel(Parcel in) {
        this.pkg = in.readString();
        this.id = in.readInt();
        if(in.readInt() != 0)        
        {
            this.tag = in.readString();
        } //End block
        else
        {
            this.tag = null;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.234 -0400", hash_original_method = "E1CEBE0CBC31424403A596077856AB81", hash_generated_method = "6E4983ECD864CC400A04DD1F18D0BC2A")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeString(this.pkg);
        out.writeInt(this.id);
        if(this.tag != null)        
        {
            out.writeInt(1);
            out.writeString(this.tag);
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.234 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2DEDB1CC54D37CE5576AD5CFCD943C8F")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1190566707 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_168763054 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_168763054;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.235 -0400", hash_original_method = "D4457BF5780841D42A453C9EF4E52627", hash_generated_method = "8BF31EFF3F3CC93B393E7CC4A8155913")
    public StatusBarNotification clone() {
StatusBarNotification varB772A3535461487A1581A4E8A6C22135_1453442249 =         new StatusBarNotification(this.pkg, this.id, this.tag,
                this.uid, this.initialPid, this.notification.clone());
        varB772A3535461487A1581A4E8A6C22135_1453442249.addTaint(taint);
        return varB772A3535461487A1581A4E8A6C22135_1453442249;
        // ---------- Original Method ----------
        //return new StatusBarNotification(this.pkg, this.id, this.tag,
                //this.uid, this.initialPid, this.notification.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.235 -0400", hash_original_method = "8CD358CFA5A2F08AEF9168AA24337844", hash_generated_method = "290B704E50A3B68C343528F8CA39DB95")
    public String toString() {
String var2D40DE0DA00F138A6FA942140A54F410_1158396944 =         "StatusBarNotification(package=" + pkg + " id=" + id + " tag=" + tag
                + " notification=" + notification + " priority=" + priority + ")";
        var2D40DE0DA00F138A6FA942140A54F410_1158396944.addTaint(taint);
        return var2D40DE0DA00F138A6FA942140A54F410_1158396944;
        // ---------- Original Method ----------
        //return "StatusBarNotification(package=" + pkg + " id=" + id + " tag=" + tag
                //+ " notification=" + notification + " priority=" + priority + ")";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.236 -0400", hash_original_method = "7CE63774DFBFD9AF881A293653A5D73C", hash_generated_method = "620595865BD12CED1BD4284A39DA443C")
    public boolean isOngoing() {
        boolean varA7DB388CF2655EEFDF0FA3B708F854F4_1274991629 = ((notification.flags & Notification.FLAG_ONGOING_EVENT) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1378910560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1378910560;
        // ---------- Original Method ----------
        //return (notification.flags & Notification.FLAG_ONGOING_EVENT) != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.236 -0400", hash_original_method = "BD2B0089B2847866F80D96044B172188", hash_generated_method = "C2CF7FE020B682AAF0D2AC84442502AF")
    public boolean isClearable() {
        boolean var270673DEF703226A6485427B1963D306_1736029575 = (((notification.flags & Notification.FLAG_ONGOING_EVENT) == 0)
                && ((notification.flags & Notification.FLAG_NO_CLEAR) == 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_484382956 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_484382956;
        // ---------- Original Method ----------
        //return ((notification.flags & Notification.FLAG_ONGOING_EVENT) == 0)
                //&& ((notification.flags & Notification.FLAG_NO_CLEAR) == 0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.236 -0400", hash_original_field = "53D79D31AA1CC0EBC51B9BF7B18664A0", hash_generated_field = "2B49EDD295535B580853723C924CA12C")

    public static int PRIORITY_JIFFY_EXPRESS = -100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.237 -0400", hash_original_field = "31FBA1159F26FEE81B61D03C65F2279B", hash_generated_field = "8D9ABD1C51C38DC0D2C8DDD7CB1C4751")

    public static int PRIORITY_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.237 -0400", hash_original_field = "729D82A6CD3F32459ECE3ED46298C5B0", hash_generated_field = "CC8C4250744D99767687836146798BEF")

    public static int PRIORITY_ONGOING = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.237 -0400", hash_original_field = "B9E8FF119F755DB76180BFFAC12F3868", hash_generated_field = "4DE62F1E40BF7FACFAFBB92AB4DC4458")

    public static int PRIORITY_SYSTEM = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.237 -0400", hash_original_field = "FBC296099DA268D55B818E08436A3005", hash_generated_field = "2645D879048587FE6A50F9198CCFA95B")

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

