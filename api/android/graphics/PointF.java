package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.FloatMath;

public class PointF implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.658 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "0CC4A8770822EF2A4B3BD536BBF6C113")

    public float x;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.658 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "E8D9A0915E4274087E59C025C4DCDA11")

    public float y;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.658 -0400", hash_original_method = "AC71EBB0EDB844032A48DF20A80FB47B", hash_generated_method = "80B58F578A9E18CAE61877DE29226528")
    public  PointF() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.658 -0400", hash_original_method = "9BF59EFAA8370540E900DAD5DAB0D2CC", hash_generated_method = "025777B23DE5DE112C6936ED28AD52FF")
    public  PointF(float x, float y) {
        this.x = x;
        this.y = y;
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.658 -0400", hash_original_method = "41FF564220F19615AF5858F564634DDE", hash_generated_method = "43B60ECB24E323638CDF17F248D0955A")
    public  PointF(Point p) {
        this.x = p.x;
        this.y = p.y;
        // ---------- Original Method ----------
        //this.x = p.x;
        //this.y = p.y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.658 -0400", hash_original_method = "F7BA2399A270106D49FE9F3CEDD1B64C", hash_generated_method = "B0E694476E38ED79FABC23526B838C6D")
    public final void set(float x, float y) {
        this.x = x;
        this.y = y;
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.659 -0400", hash_original_method = "A2C2BCEEF90AD29E71702879AF68EB5C", hash_generated_method = "96A58945F4EF52A0FB3CB5D99420723A")
    public final void set(PointF p) {
        this.x = p.x;
        this.y = p.y;
        // ---------- Original Method ----------
        //this.x = p.x;
        //this.y = p.y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.659 -0400", hash_original_method = "47D8F51D6A8BFCBDB23B0F8D5AF788FE", hash_generated_method = "2BF53EC3544A2E6062446424007D905E")
    public final void negate() {
        x = -x;
        y = -y;
        // ---------- Original Method ----------
        //x = -x;
        //y = -y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.659 -0400", hash_original_method = "21ADDAD001104B37D18E0BE298F2ECD3", hash_generated_method = "56FA0F865850BB9DC11AE7749279A41D")
    public final void offset(float dx, float dy) {
        x += dx;
        y += dy;
        // ---------- Original Method ----------
        //x += dx;
        //y += dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.659 -0400", hash_original_method = "F82621D2FAA57E05F2C4A4E11E1CB185", hash_generated_method = "0804E605A068C8C62AE08D18EBB10363")
    public final boolean equals(float x, float y) {
        addTaint(y);
        addTaint(x);
        boolean var03A09ADE700DB3B4FF9A4003E8D78D38_1813555908 = (this.x == x && this.y == y);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1729022195 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1729022195;
        // ---------- Original Method ----------
        //return this.x == x && this.y == y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.659 -0400", hash_original_method = "892A2B0E26A7F5CA4781A7DDEBBD33D8", hash_generated_method = "BF5CB70AFAB9EECAC90B150571363E89")
    public final float length() {
        float varC11B68AE7548069FC83496CE2CEF8ED0_1160653047 = (length(x, y));
                float var546ADE640B6EDFBC8A086EF31347E768_1872033629 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1872033629;
        // ---------- Original Method ----------
        //return length(x, y);
    }

    
    @DSModeled(DSC.SAFE)
    public static float length(float x, float y) {
        return FloatMath.sqrt(x * x + y * y);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.660 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "3D68DD3E10C823BEAD2D6AAFD2C575B1")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2007862710 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206083508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206083508;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.660 -0400", hash_original_method = "498F687E010E97B616DAA29FD28A4DFC", hash_generated_method = "A45D20B26148C0903A1696AC7FF266CC")
    @Override
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeFloat(x);
        out.writeFloat(y);
        // ---------- Original Method ----------
        //out.writeFloat(x);
        //out.writeFloat(y);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.660 -0400", hash_original_method = "1ADDB8AA93A41CBDC98F8DD97BD3942F", hash_generated_method = "0BFCD1D65346AFF3FD9BA0C6DFBDDA42")
    public void readFromParcel(Parcel in) {
        x = in.readFloat();
        y = in.readFloat();
        // ---------- Original Method ----------
        //x = in.readFloat();
        //y = in.readFloat();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.660 -0400", hash_original_field = "A8B72BB8FF20DCD3E42E3990C2FB1A2D", hash_generated_field = "290F12F848FCA2A5689B95FB1FE844BB")

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
    // orphaned legacy method
    public PointF createFromParcel(Parcel in) {
            PointF r = new PointF();
            r.readFromParcel(in);
            return r;
        }
    
    // orphaned legacy method
    public PointF[] newArray(int size) {
            return new PointF[size];
        }
    
}

