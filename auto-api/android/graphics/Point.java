package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class Point implements Parcelable {
    public int x;
    public int y;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.530 -0400", hash_original_method = "D4552E1315F6D591F9A42261DB9D057B", hash_generated_method = "891355F007EC1345CA8AB753D7DD5962")
    @DSModeled(DSC.SAFE)
    public Point() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.531 -0400", hash_original_method = "F0C519E838FC36A3F9D598F50DEA0E68", hash_generated_method = "07BED00B3695B16D5DB6AF459A3AAF7C")
    @DSModeled(DSC.SAFE)
    public Point(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.532 -0400", hash_original_method = "73184A56659634A9C3B845676739FB93", hash_generated_method = "8E78C8887729599AE693CF66118E2BBF")
    @DSModeled(DSC.SAFE)
    public Point(Point src) {
        dsTaint.addTaint(src.dsTaint);
        this.x = src.x;
        this.y = src.y;
        // ---------- Original Method ----------
        //this.x = src.x;
        //this.y = src.y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.533 -0400", hash_original_method = "A893C7A3BDAFD0F68044E15122EF7C46", hash_generated_method = "3496F0E811D420D14FA8F3BB92B7E143")
    @DSModeled(DSC.SAFE)
    public void set(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.534 -0400", hash_original_method = "47D8F51D6A8BFCBDB23B0F8D5AF788FE", hash_generated_method = "2BF53EC3544A2E6062446424007D905E")
    @DSModeled(DSC.SAFE)
    public final void negate() {
        x = -x;
        y = -y;
        // ---------- Original Method ----------
        //x = -x;
        //y = -y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.534 -0400", hash_original_method = "2341B98028DF5979D10DDC3712740A20", hash_generated_method = "EC58C6746CDD398991E6863DB298B10B")
    @DSModeled(DSC.SAFE)
    public final void offset(int dx, int dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        // ---------- Original Method ----------
        //x += dx;
        //y += dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.534 -0400", hash_original_method = "B64FF880BF78A0B3D79FA58471141474", hash_generated_method = "2C87616D42AD62468B1922892E5870EA")
    @DSModeled(DSC.SAFE)
    public final boolean equals(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.x == x && this.y == y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.534 -0400", hash_original_method = "DE06142D9B61B02A43CEA21E14E7D027", hash_generated_method = "64977C47D6AB84E142E907B473209BDD")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            Point p;
            p = (Point) o;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o instanceof Point) {
            //Point p = (Point) o;
            //return this.x == p.x && this.y == p.y;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.535 -0400", hash_original_method = "2AEEE1632B8FF7FECD208FC610B72FB6", hash_generated_method = "05878EB6AC1CA0F6B6D6CCCB525A23B4")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return x * 32713 + y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.535 -0400", hash_original_method = "9F61E49C995FA3CEC66850F11B9A08CD", hash_generated_method = "6D3B5E22EE45E4885EB693933FB1047B")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Point(" + x + ", " + y+ ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.535 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.535 -0400", hash_original_method = "54E86A99E3577FA18F65ED6CED3821E9", hash_generated_method = "4DBBED5613A1650D57DCD5BEE18DC4BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeInt(x);
        out.writeInt(y);
        // ---------- Original Method ----------
        //out.writeInt(x);
        //out.writeInt(y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.536 -0400", hash_original_method = "AD1ECB5F4974F92B096BCFEAE556C331", hash_generated_method = "D0163387D550220303D65667F42BAB0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        x = in.readInt();
        y = in.readInt();
        // ---------- Original Method ----------
        //x = in.readInt();
        //y = in.readInt();
    }

    
    public static final Parcelable.Creator<Point> CREATOR = new Parcelable.Creator<Point>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.536 -0400", hash_original_method = "B3310D4E2482FAA9B08EEBCB55A9E59A", hash_generated_method = "524F05D3522D9808D9D5EAAA95D2B946")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Point createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            Point r;
            r = new Point();
            r.readFromParcel(in);
            return (Point)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Point r = new Point();
            //r.readFromParcel(in);
            //return r;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.536 -0400", hash_original_method = "18DD28AAA16190424D7A39669B473895", hash_generated_method = "7CCDF402414F898C2CE7A7F5BCAB945A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Point[] newArray(int size) {
            dsTaint.addTaint(size);
            Point[] var7BD0D438125D0B50510677B497604EE1_83402509 = (new Point[size]);
            return (Point[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Point[size];
        }

        
}; //Transformed anonymous class
}

