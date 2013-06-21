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
    public float x;
    public float y;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.540 -0400", hash_original_method = "AC71EBB0EDB844032A48DF20A80FB47B", hash_generated_method = "80B58F578A9E18CAE61877DE29226528")
    @DSModeled(DSC.SAFE)
    public PointF() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.540 -0400", hash_original_method = "9BF59EFAA8370540E900DAD5DAB0D2CC", hash_generated_method = "492947C0CD57B2355B375A22EEFD346A")
    @DSModeled(DSC.SAFE)
    public PointF(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.542 -0400", hash_original_method = "41FF564220F19615AF5858F564634DDE", hash_generated_method = "8C03439E131DE3385A45058A991A99CB")
    @DSModeled(DSC.SAFE)
    public PointF(Point p) {
        dsTaint.addTaint(p.dsTaint);
        this.x = p.x;
        this.y = p.y;
        // ---------- Original Method ----------
        //this.x = p.x;
        //this.y = p.y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.542 -0400", hash_original_method = "F7BA2399A270106D49FE9F3CEDD1B64C", hash_generated_method = "5DD3F200E664BA9CAD3B710CBE35D60B")
    @DSModeled(DSC.SAFE)
    public final void set(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.542 -0400", hash_original_method = "A2C2BCEEF90AD29E71702879AF68EB5C", hash_generated_method = "5DEB887FFBEBC895FA9A8D81214F49E4")
    @DSModeled(DSC.SAFE)
    public final void set(PointF p) {
        dsTaint.addTaint(p.dsTaint);
        this.x = p.x;
        this.y = p.y;
        // ---------- Original Method ----------
        //this.x = p.x;
        //this.y = p.y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.542 -0400", hash_original_method = "47D8F51D6A8BFCBDB23B0F8D5AF788FE", hash_generated_method = "2BF53EC3544A2E6062446424007D905E")
    @DSModeled(DSC.SAFE)
    public final void negate() {
        x = -x;
        y = -y;
        // ---------- Original Method ----------
        //x = -x;
        //y = -y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.543 -0400", hash_original_method = "21ADDAD001104B37D18E0BE298F2ECD3", hash_generated_method = "5B6782632645B69994888A0DD3EDA7C1")
    @DSModeled(DSC.SAFE)
    public final void offset(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        // ---------- Original Method ----------
        //x += dx;
        //y += dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.543 -0400", hash_original_method = "F82621D2FAA57E05F2C4A4E11E1CB185", hash_generated_method = "37FD30BB30EADBD73C8696C897224750")
    @DSModeled(DSC.SAFE)
    public final boolean equals(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.x == x && this.y == y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.543 -0400", hash_original_method = "892A2B0E26A7F5CA4781A7DDEBBD33D8", hash_generated_method = "5EE6435D00B88FA6F8826E85A1A9BBB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float length() {
        float var21060411D30E39607092FBEE24A1F23B_1319022299 = (length(x, y));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return length(x, y);
    }

    
        public static float length(float x, float y) {
        return FloatMath.sqrt(x * x + y * y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.543 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.544 -0400", hash_original_method = "498F687E010E97B616DAA29FD28A4DFC", hash_generated_method = "CD3B433BBF7636A75DBC3AD5101BA1D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeFloat(x);
        out.writeFloat(y);
        // ---------- Original Method ----------
        //out.writeFloat(x);
        //out.writeFloat(y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.544 -0400", hash_original_method = "1ADDB8AA93A41CBDC98F8DD97BD3942F", hash_generated_method = "C8F6F3F6200A31590462950412493DDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        x = in.readFloat();
        y = in.readFloat();
        // ---------- Original Method ----------
        //x = in.readFloat();
        //y = in.readFloat();
    }

    
    public static final Parcelable.Creator<PointF> CREATOR = new Parcelable.Creator<PointF>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.544 -0400", hash_original_method = "61A0B58FC44A88594A723273F46294F0", hash_generated_method = "EB82FA1C89797EA44C48F807A855C260")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PointF createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            PointF r;
            r = new PointF();
            r.readFromParcel(in);
            return (PointF)dsTaint.getTaint();
            // ---------- Original Method ----------
            //PointF r = new PointF();
            //r.readFromParcel(in);
            //return r;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.545 -0400", hash_original_method = "F83030BA99FDC4DFE01ED7A9F8C375B2", hash_generated_method = "20B3CD59D6CA2B4417B0B60A5EE81318")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PointF[] newArray(int size) {
            dsTaint.addTaint(size);
            PointF[] var765EBFDF085B65FF6F277AA56E0C0CCE_646327045 = (new PointF[size]);
            return (PointF[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PointF[size];
        }

        
}; //Transformed anonymous class
}

