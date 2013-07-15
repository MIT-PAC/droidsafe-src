package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public class Point implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.775 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "DC9CDA960147F3D22D20E612AF25CB17")

    public int x;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.775 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "2B3105BD07A59FEFE1F1918C5EDA2B54")

    public int y;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.776 -0400", hash_original_method = "D4552E1315F6D591F9A42261DB9D057B", hash_generated_method = "891355F007EC1345CA8AB753D7DD5962")
    public  Point() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.777 -0400", hash_original_method = "F0C519E838FC36A3F9D598F50DEA0E68", hash_generated_method = "C05134FBB236D1298B22E27D3F645264")
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.778 -0400", hash_original_method = "73184A56659634A9C3B845676739FB93", hash_generated_method = "35E5BF8119462F0CCEC844CE97F7955B")
    public  Point(Point src) {
        this.x = src.x;
        this.y = src.y;
        // ---------- Original Method ----------
        //this.x = src.x;
        //this.y = src.y;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.779 -0400", hash_original_method = "A893C7A3BDAFD0F68044E15122EF7C46", hash_generated_method = "64C0F70A319F472D57B0208C83061342")
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.781 -0400", hash_original_method = "47D8F51D6A8BFCBDB23B0F8D5AF788FE", hash_generated_method = "2BF53EC3544A2E6062446424007D905E")
    public final void negate() {
        x = -x;
        y = -y;
        // ---------- Original Method ----------
        //x = -x;
        //y = -y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.782 -0400", hash_original_method = "2341B98028DF5979D10DDC3712740A20", hash_generated_method = "9985F655CDA621D55D06DF0B151AF4BE")
    public final void offset(int dx, int dy) {
        x += dx;
        y += dy;
        // ---------- Original Method ----------
        //x += dx;
        //y += dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.783 -0400", hash_original_method = "B64FF880BF78A0B3D79FA58471141474", hash_generated_method = "6E1A62939E0083062525CD9E2BF97480")
    public final boolean equals(int x, int y) {
        addTaint(y);
        addTaint(x);
        boolean var03A09ADE700DB3B4FF9A4003E8D78D38_1014155828 = (this.x == x && this.y == y);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1496408258 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1496408258;
        // ---------- Original Method ----------
        //return this.x == x && this.y == y;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.783 -0400", hash_original_method = "DE06142D9B61B02A43CEA21E14E7D027", hash_generated_method = "A31BE29A9D73BAABA390E486A78291B4")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o instanceof Point)        
        {
            Point p = (Point) o;
            boolean var12FAE170B47AE8C6247D5AE4CC627549_2064262541 = (this.x == p.x && this.y == p.y);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1461974892 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1461974892;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_882131300 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1348327832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1348327832;
        // ---------- Original Method ----------
        //if (o instanceof Point) {
            //Point p = (Point) o;
            //return this.x == p.x && this.y == p.y;
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.784 -0400", hash_original_method = "2AEEE1632B8FF7FECD208FC610B72FB6", hash_generated_method = "06FF62C8AC066A7E77551B60EC76FBF9")
    @Override
    public int hashCode() {
        int var714C011E46F34A1DDE3B2ACC0476A971_1578286562 = (x * 32713 + y);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_448628300 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_448628300;
        // ---------- Original Method ----------
        //return x * 32713 + y;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.785 -0400", hash_original_method = "9F61E49C995FA3CEC66850F11B9A08CD", hash_generated_method = "C0C4D53CBA539BF050D4EE5AB7AD89AB")
    @Override
    public String toString() {
String var98609682F4790186030E21B56C8EB153_1300994217 =         "Point(" + x + ", " + y+ ")";
        var98609682F4790186030E21B56C8EB153_1300994217.addTaint(taint);
        return var98609682F4790186030E21B56C8EB153_1300994217;
        // ---------- Original Method ----------
        //return "Point(" + x + ", " + y+ ")";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.785 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8C678D5FD8F83EAED67CC19870EDCAA8")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_865317965 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_585652758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_585652758;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.786 -0400", hash_original_method = "54E86A99E3577FA18F65ED6CED3821E9", hash_generated_method = "CFE12704CF49C064749C9253D6CC0898")
    @Override
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeInt(x);
        out.writeInt(y);
        // ---------- Original Method ----------
        //out.writeInt(x);
        //out.writeInt(y);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.786 -0400", hash_original_method = "AD1ECB5F4974F92B096BCFEAE556C331", hash_generated_method = "7D18C675822037ED05AF6717B3061A57")
    public void readFromParcel(Parcel in) {
        x = in.readInt();
        y = in.readInt();
        // ---------- Original Method ----------
        //x = in.readInt();
        //y = in.readInt();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.787 -0400", hash_original_field = "46894148330232332ACF126C0EBCE04B", hash_generated_field = "FE9330E14C8CDC7168D77A0E0F98818B")

    public static final Parcelable.Creator<Point> CREATOR = new Parcelable.Creator<Point>() {
        
        public Point createFromParcel(Parcel in) {
            Point r = new Point();
            r.readFromParcel(in);
            return r;
        }

        
        public Point[] newArray(int size) {
            return new Point[size];
        }
    };
    // orphaned legacy method
    public Point createFromParcel(Parcel in) {
            Point r = new Point();
            r.readFromParcel(in);
            return r;
        }
    
    // orphaned legacy method
    public Point[] newArray(int size) {
            return new Point[size];
        }
    
}

