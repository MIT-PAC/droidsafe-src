package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public class Point implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.646 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "DC9CDA960147F3D22D20E612AF25CB17")

    public int x;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.646 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "2B3105BD07A59FEFE1F1918C5EDA2B54")

    public int y;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.646 -0400", hash_original_method = "D4552E1315F6D591F9A42261DB9D057B", hash_generated_method = "891355F007EC1345CA8AB753D7DD5962")
    public  Point() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.646 -0400", hash_original_method = "F0C519E838FC36A3F9D598F50DEA0E68", hash_generated_method = "C05134FBB236D1298B22E27D3F645264")
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.647 -0400", hash_original_method = "73184A56659634A9C3B845676739FB93", hash_generated_method = "35E5BF8119462F0CCEC844CE97F7955B")
    public  Point(Point src) {
        this.x = src.x;
        this.y = src.y;
        // ---------- Original Method ----------
        //this.x = src.x;
        //this.y = src.y;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.647 -0400", hash_original_method = "A893C7A3BDAFD0F68044E15122EF7C46", hash_generated_method = "64C0F70A319F472D57B0208C83061342")
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.647 -0400", hash_original_method = "47D8F51D6A8BFCBDB23B0F8D5AF788FE", hash_generated_method = "2BF53EC3544A2E6062446424007D905E")
    public final void negate() {
        x = -x;
        y = -y;
        // ---------- Original Method ----------
        //x = -x;
        //y = -y;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.647 -0400", hash_original_method = "2341B98028DF5979D10DDC3712740A20", hash_generated_method = "9985F655CDA621D55D06DF0B151AF4BE")
    public final void offset(int dx, int dy) {
        x += dx;
        y += dy;
        // ---------- Original Method ----------
        //x += dx;
        //y += dy;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.648 -0400", hash_original_method = "B64FF880BF78A0B3D79FA58471141474", hash_generated_method = "697F9884E1F2C214DE5DACBF8740ABA1")
    public final boolean equals(int x, int y) {
        addTaint(y);
        addTaint(x);
        boolean var03A09ADE700DB3B4FF9A4003E8D78D38_1922455690 = (this.x == x && this.y == y);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1401793038 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1401793038;
        // ---------- Original Method ----------
        //return this.x == x && this.y == y;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.648 -0400", hash_original_method = "DE06142D9B61B02A43CEA21E14E7D027", hash_generated_method = "843CC34743EE37D1BE541349892325DB")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o instanceof Point)        
        {
            Point p = (Point) o;
            boolean var12FAE170B47AE8C6247D5AE4CC627549_796643457 = (this.x == p.x && this.y == p.y);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197601159 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197601159;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_107439697 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101416023 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_101416023;
        // ---------- Original Method ----------
        //if (o instanceof Point) {
            //Point p = (Point) o;
            //return this.x == p.x && this.y == p.y;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.648 -0400", hash_original_method = "2AEEE1632B8FF7FECD208FC610B72FB6", hash_generated_method = "401E576DCB5A1825DF3C2649084BC3C1")
    @Override
    public int hashCode() {
        int var714C011E46F34A1DDE3B2ACC0476A971_1685657389 = (x * 32713 + y);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1016448030 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1016448030;
        // ---------- Original Method ----------
        //return x * 32713 + y;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.648 -0400", hash_original_method = "9F61E49C995FA3CEC66850F11B9A08CD", hash_generated_method = "EF8B8CCE150C0C1AB559BCFC7E9DAC59")
    @Override
    public String toString() {
String var98609682F4790186030E21B56C8EB153_1026060740 =         "Point(" + x + ", " + y+ ")";
        var98609682F4790186030E21B56C8EB153_1026060740.addTaint(taint);
        return var98609682F4790186030E21B56C8EB153_1026060740;
        // ---------- Original Method ----------
        //return "Point(" + x + ", " + y+ ")";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.648 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B7AE24869F665CC0E591158289B641E6")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1272242102 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730228121 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730228121;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.649 -0400", hash_original_method = "54E86A99E3577FA18F65ED6CED3821E9", hash_generated_method = "CFE12704CF49C064749C9253D6CC0898")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.649 -0400", hash_original_method = "AD1ECB5F4974F92B096BCFEAE556C331", hash_generated_method = "7D18C675822037ED05AF6717B3061A57")
    public void readFromParcel(Parcel in) {
        x = in.readInt();
        y = in.readInt();
        // ---------- Original Method ----------
        //x = in.readInt();
        //y = in.readInt();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.649 -0400", hash_original_field = "46894148330232332ACF126C0EBCE04B", hash_generated_field = "FE9330E14C8CDC7168D77A0E0F98818B")

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

