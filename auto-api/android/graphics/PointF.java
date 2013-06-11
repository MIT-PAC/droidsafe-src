package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.FloatMath;

public class PointF implements Parcelable {
    public float x;
    public float y;
    public static final Parcelable.Creator<PointF> CREATOR = new Parcelable.Creator<PointF>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.310 -0400", hash_original_method = "61A0B58FC44A88594A723273F46294F0", hash_generated_method = "FB97B1162DC4B8309F24A1F16374E988")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.310 -0400", hash_original_method = "F83030BA99FDC4DFE01ED7A9F8C375B2", hash_generated_method = "8B9DB575ECA3C0429A370BF1C4733712")
        @DSModeled(DSC.SAFE)
        public PointF[] newArray(int size) {
            dsTaint.addTaint(size);
            return (PointF[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PointF[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.310 -0400", hash_original_method = "AC71EBB0EDB844032A48DF20A80FB47B", hash_generated_method = "979E621D36465BC68EEB2743FAE8ED2E")
    @DSModeled(DSC.SAFE)
    public PointF() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.310 -0400", hash_original_method = "9BF59EFAA8370540E900DAD5DAB0D2CC", hash_generated_method = "A31AF9BD4A5EC90B90E5747525865E89")
    @DSModeled(DSC.SAFE)
    public PointF(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.310 -0400", hash_original_method = "41FF564220F19615AF5858F564634DDE", hash_generated_method = "A87DBBD66E79B4EE90D0DC4A9F741F2C")
    @DSModeled(DSC.SAFE)
    public PointF(Point p) {
        dsTaint.addTaint(p.dsTaint);
        this.x = p.x;
        this.y = p.y;
        // ---------- Original Method ----------
        //this.x = p.x;
        //this.y = p.y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.310 -0400", hash_original_method = "F7BA2399A270106D49FE9F3CEDD1B64C", hash_generated_method = "41A2FB003202B51FE6CB89814EDA5550")
    @DSModeled(DSC.SAFE)
    public final void set(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        // ---------- Original Method ----------
        //this.x = x;
        //this.y = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.310 -0400", hash_original_method = "A2C2BCEEF90AD29E71702879AF68EB5C", hash_generated_method = "9A9DB932D1866F3617D95E6E8A82621D")
    @DSModeled(DSC.SAFE)
    public final void set(PointF p) {
        dsTaint.addTaint(p.dsTaint);
        this.x = p.x;
        this.y = p.y;
        // ---------- Original Method ----------
        //this.x = p.x;
        //this.y = p.y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.311 -0400", hash_original_method = "47D8F51D6A8BFCBDB23B0F8D5AF788FE", hash_generated_method = "D148A9C384BCFD18CF430AC88FE4D1C9")
    @DSModeled(DSC.SAFE)
    public final void negate() {
        x = -x;
        y = -y;
        // ---------- Original Method ----------
        //x = -x;
        //y = -y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.311 -0400", hash_original_method = "21ADDAD001104B37D18E0BE298F2ECD3", hash_generated_method = "35CE13C811AE5D99BBC227E432364E58")
    @DSModeled(DSC.SAFE)
    public final void offset(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        // ---------- Original Method ----------
        //x += dx;
        //y += dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.311 -0400", hash_original_method = "F82621D2FAA57E05F2C4A4E11E1CB185", hash_generated_method = "BD2CFFDE3D4D6053535560FCE1A730CB")
    @DSModeled(DSC.SAFE)
    public final boolean equals(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.x == x && this.y == y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.311 -0400", hash_original_method = "892A2B0E26A7F5CA4781A7DDEBBD33D8", hash_generated_method = "BD128740B4C0144C438F0F18E5F3FB98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float length() {
        float var21060411D30E39607092FBEE24A1F23B_1387189279 = (length(x, y));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return length(x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.311 -0400", hash_original_method = "465129C188D91F5542AA39E43CB0E49D", hash_generated_method = "1D2193BD88EC285E5911F89209C0F412")
    public static float length(float x, float y) {
        return FloatMath.sqrt(x * x + y * y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.311 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "826038BB7EBD5D3C24D01F025676D20A")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.311 -0400", hash_original_method = "498F687E010E97B616DAA29FD28A4DFC", hash_generated_method = "5C5D117E4689589D44487DF9262857EC")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.311 -0400", hash_original_method = "1ADDB8AA93A41CBDC98F8DD97BD3942F", hash_generated_method = "D9F160F07B3E942C8C42726A14C6A948")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        x = in.readFloat();
        y = in.readFloat();
        // ---------- Original Method ----------
        //x = in.readFloat();
        //y = in.readFloat();
    }

    
}


