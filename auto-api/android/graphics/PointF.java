package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.FloatMath;

public class PointF implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.396 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "0CC4A8770822EF2A4B3BD536BBF6C113")

    public float x;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.396 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "E8D9A0915E4274087E59C025C4DCDA11")

    public float y;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.397 -0400", hash_original_method = "AC71EBB0EDB844032A48DF20A80FB47B", hash_generated_method = "80B58F578A9E18CAE61877DE29226528")
    public  PointF() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.398 -0400", hash_original_method = "9BF59EFAA8370540E900DAD5DAB0D2CC", hash_generated_method = "025777B23DE5DE112C6936ED28AD52FF")
    public  PointF(float x, float y) {
        this.x = x;
        this.y = y;
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.415 -0400", hash_original_method = "41FF564220F19615AF5858F564634DDE", hash_generated_method = "43B60ECB24E323638CDF17F248D0955A")
    public  PointF(Point p) {
        this.x = p.x;
        this.y = p.y;
        // ---------- Original Method ----------
        //this.x = p.x;
        //this.y = p.y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.417 -0400", hash_original_method = "F7BA2399A270106D49FE9F3CEDD1B64C", hash_generated_method = "B0E694476E38ED79FABC23526B838C6D")
    public final void set(float x, float y) {
        this.x = x;
        this.y = y;
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.437 -0400", hash_original_method = "A2C2BCEEF90AD29E71702879AF68EB5C", hash_generated_method = "96A58945F4EF52A0FB3CB5D99420723A")
    public final void set(PointF p) {
        this.x = p.x;
        this.y = p.y;
        // ---------- Original Method ----------
        //this.x = p.x;
        //this.y = p.y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.439 -0400", hash_original_method = "47D8F51D6A8BFCBDB23B0F8D5AF788FE", hash_generated_method = "2BF53EC3544A2E6062446424007D905E")
    public final void negate() {
        x = -x;
        y = -y;
        // ---------- Original Method ----------
        //x = -x;
        //y = -y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.440 -0400", hash_original_method = "21ADDAD001104B37D18E0BE298F2ECD3", hash_generated_method = "56FA0F865850BB9DC11AE7749279A41D")
    public final void offset(float dx, float dy) {
        x += dx;
        y += dy;
        // ---------- Original Method ----------
        //x += dx;
        //y += dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.440 -0400", hash_original_method = "F82621D2FAA57E05F2C4A4E11E1CB185", hash_generated_method = "32EE5B1850A6D07031F8759C12FB77B1")
    public final boolean equals(float x, float y) {
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_251563269 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_251563269;
        // ---------- Original Method ----------
        //return this.x == x && this.y == y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.441 -0400", hash_original_method = "892A2B0E26A7F5CA4781A7DDEBBD33D8", hash_generated_method = "8750BEBB6C88DF5EB75029E0FEA3AE2E")
    public final float length() {
        float var21060411D30E39607092FBEE24A1F23B_1704018921 = (length(x, y));
        float var546ADE640B6EDFBC8A086EF31347E768_2024538929 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2024538929;
        // ---------- Original Method ----------
        //return length(x, y);
    }

    
        public static float length(float x, float y) {
        return FloatMath.sqrt(x * x + y * y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.455 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DCE7E73D4E167D4DD77A2240B6D2FF1F")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261252473 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261252473;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.461 -0400", hash_original_method = "498F687E010E97B616DAA29FD28A4DFC", hash_generated_method = "386FAFA8156B4A7A0E33B4DAF4B92EFB")
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeFloat(x);
        out.writeFloat(y);
        addTaint(out.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //out.writeFloat(x);
        //out.writeFloat(y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.462 -0400", hash_original_method = "1ADDB8AA93A41CBDC98F8DD97BD3942F", hash_generated_method = "0BFCD1D65346AFF3FD9BA0C6DFBDDA42")
    public void readFromParcel(Parcel in) {
        x = in.readFloat();
        y = in.readFloat();
        // ---------- Original Method ----------
        //x = in.readFloat();
        //y = in.readFloat();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.462 -0400", hash_original_field = "A8B72BB8FF20DCD3E42E3990C2FB1A2D", hash_generated_field = "290F12F848FCA2A5689B95FB1FE844BB")

    public static final Parcelable.Creator<PointF> CREATOR = new Parcelable.Creator<PointF>() {
        
        public PointF createFromParcel(Parcel in) {
            PointF r = new PointF();
            r.readFromParcel(in);
            return r;
        }

        
        public PointF[] newArray(int size) {
            return new PointF[size];
        }
    };
}

