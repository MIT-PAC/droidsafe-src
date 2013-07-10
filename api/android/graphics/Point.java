package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class Point implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.061 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "DC9CDA960147F3D22D20E612AF25CB17")

    public int x;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.061 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "2B3105BD07A59FEFE1F1918C5EDA2B54")

    public int y;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.062 -0400", hash_original_method = "D4552E1315F6D591F9A42261DB9D057B", hash_generated_method = "891355F007EC1345CA8AB753D7DD5962")
    public  Point() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.062 -0400", hash_original_method = "F0C519E838FC36A3F9D598F50DEA0E68", hash_generated_method = "C05134FBB236D1298B22E27D3F645264")
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.063 -0400", hash_original_method = "73184A56659634A9C3B845676739FB93", hash_generated_method = "35E5BF8119462F0CCEC844CE97F7955B")
    public  Point(Point src) {
        this.x = src.x;
        this.y = src.y;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.064 -0400", hash_original_method = "A893C7A3BDAFD0F68044E15122EF7C46", hash_generated_method = "64C0F70A319F472D57B0208C83061342")
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.064 -0400", hash_original_method = "47D8F51D6A8BFCBDB23B0F8D5AF788FE", hash_generated_method = "2BF53EC3544A2E6062446424007D905E")
    public final void negate() {
        x = -x;
        y = -y;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.065 -0400", hash_original_method = "2341B98028DF5979D10DDC3712740A20", hash_generated_method = "9985F655CDA621D55D06DF0B151AF4BE")
    public final void offset(int dx, int dy) {
        x += dx;
        y += dy;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.066 -0400", hash_original_method = "B64FF880BF78A0B3D79FA58471141474", hash_generated_method = "A9F124CF4FD8E1CB1F8E906BFA43518E")
    public final boolean equals(int x, int y) {
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1970697720 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1970697720;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.067 -0400", hash_original_method = "DE06142D9B61B02A43CEA21E14E7D027", hash_generated_method = "44343190C6159C98959C9AAAC2FB2E63")
    @Override
    public boolean equals(Object o) {
        {
            Point p = (Point) o;
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_150434302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_150434302;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.067 -0400", hash_original_method = "2AEEE1632B8FF7FECD208FC610B72FB6", hash_generated_method = "D2A2DF9A8D88576A7386C4E2768A4C53")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33006750 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33006750;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.068 -0400", hash_original_method = "9F61E49C995FA3CEC66850F11B9A08CD", hash_generated_method = "9C4B5A37A95533150BFE8260C16348D0")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1569584577 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1569584577 = "Point(" + x + ", " + y+ ")";
        varB4EAC82CA7396A68D541C85D26508E83_1569584577.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1569584577;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.069 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BBBB4EBD7209350E3A58C4B4958BCF5C")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393536511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393536511;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.069 -0400", hash_original_method = "54E86A99E3577FA18F65ED6CED3821E9", hash_generated_method = "50E44C5A133E451E53B0B4E3479576F0")
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(x);
        out.writeInt(y);
        addTaint(out.getTaint());
        addTaint(flags);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.069 -0400", hash_original_method = "AD1ECB5F4974F92B096BCFEAE556C331", hash_generated_method = "7D18C675822037ED05AF6717B3061A57")
    public void readFromParcel(Parcel in) {
        x = in.readInt();
        y = in.readInt();
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.069 -0400", hash_original_field = "46894148330232332ACF126C0EBCE04B", hash_generated_field = "FE9330E14C8CDC7168D77A0E0F98818B")

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
    
    public Point createFromParcel(Parcel in) {
            Point r = new Point();
            r.readFromParcel(in);
            return r;
        }
    
    
    public Point[] newArray(int size) {
            return new Point[size];
        }
    
}

