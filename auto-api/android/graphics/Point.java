package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;

public class Point implements Parcelable {
    public int x;
    public int y;
    public static final Parcelable.Creator<Point> CREATOR = new Parcelable.Creator<Point>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.305 -0400", hash_original_method = "B3310D4E2482FAA9B08EEBCB55A9E59A", hash_generated_method = "5D36571D48B468765A556B9DAC34B198")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.306 -0400", hash_original_method = "18DD28AAA16190424D7A39669B473895", hash_generated_method = "65F9EFE5BF6FAF0D0415E1BA3F41FF0C")
        @DSModeled(DSC.SAFE)
        public Point[] newArray(int size) {
            dsTaint.addTaint(size);
            return (Point[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Point[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.306 -0400", hash_original_method = "D4552E1315F6D591F9A42261DB9D057B", hash_generated_method = "F667453EDF2AB011AD9689D72421781C")
    @DSModeled(DSC.SAFE)
    public Point() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.306 -0400", hash_original_method = "F0C519E838FC36A3F9D598F50DEA0E68", hash_generated_method = "BCCAC83EE6D0B45686A9F1A4EA6D50F7")
    @DSModeled(DSC.SAFE)
    public Point(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.306 -0400", hash_original_method = "73184A56659634A9C3B845676739FB93", hash_generated_method = "DC2201303C5A06B4DC335CAF5E446976")
    @DSModeled(DSC.SAFE)
    public Point(Point src) {
        dsTaint.addTaint(src.dsTaint);
        this.x = src.x;
        this.y = src.y;
        // ---------- Original Method ----------
        //this.x = src.x;
        //this.y = src.y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.306 -0400", hash_original_method = "A893C7A3BDAFD0F68044E15122EF7C46", hash_generated_method = "8022A0CD636061496A76D294DE8214D6")
    @DSModeled(DSC.SAFE)
    public void set(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.306 -0400", hash_original_method = "47D8F51D6A8BFCBDB23B0F8D5AF788FE", hash_generated_method = "D148A9C384BCFD18CF430AC88FE4D1C9")
    @DSModeled(DSC.SAFE)
    public final void negate() {
        x = -x;
        y = -y;
        // ---------- Original Method ----------
        //x = -x;
        //y = -y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.306 -0400", hash_original_method = "2341B98028DF5979D10DDC3712740A20", hash_generated_method = "023A4D595A19DA7EF70537CBA09802CD")
    @DSModeled(DSC.SAFE)
    public final void offset(int dx, int dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        // ---------- Original Method ----------
        //x += dx;
        //y += dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.306 -0400", hash_original_method = "B64FF880BF78A0B3D79FA58471141474", hash_generated_method = "219DEA6B8955A188EF0DB87A085D25E5")
    @DSModeled(DSC.SAFE)
    public final boolean equals(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.x == x && this.y == y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.307 -0400", hash_original_method = "DE06142D9B61B02A43CEA21E14E7D027", hash_generated_method = "21F3F5957E813AB372ACDADB14821E10")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.307 -0400", hash_original_method = "2AEEE1632B8FF7FECD208FC610B72FB6", hash_generated_method = "03B4EB8464DC3FEA19849D849904EE7E")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return x * 32713 + y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.307 -0400", hash_original_method = "9F61E49C995FA3CEC66850F11B9A08CD", hash_generated_method = "8DFF895D51F26ED135E364832BA37FC1")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Point(" + x + ", " + y+ ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.307 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "826038BB7EBD5D3C24D01F025676D20A")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.307 -0400", hash_original_method = "54E86A99E3577FA18F65ED6CED3821E9", hash_generated_method = "6EF122BFE51DB4ABD430F97565455D08")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.307 -0400", hash_original_method = "AD1ECB5F4974F92B096BCFEAE556C331", hash_generated_method = "9D66383C45F28ECA19D83E89ADE7170B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        x = in.readInt();
        y = in.readInt();
        // ---------- Original Method ----------
        //x = in.readInt();
        //y = in.readInt();
    }

    
}


