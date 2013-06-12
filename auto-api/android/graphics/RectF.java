package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.PrintWriter;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.FloatMath;
import com.android.internal.util.FastMath;

public class RectF implements Parcelable {
    public float left;
    public float top;
    public float right;
    public float bottom;
    public static final Parcelable.Creator<RectF> CREATOR = new Parcelable.Creator<RectF>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.445 -0400", hash_original_method = "A6A0C6EE524221145489C3D66C6A94BD", hash_generated_method = "456D719092899FB3D9600B55AB14E1F5")
        @DSModeled(DSC.SAFE)
        public RectF createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            RectF r;
            r = new RectF();
            r.readFromParcel(in);
            return (RectF)dsTaint.getTaint();
            // ---------- Original Method ----------
            //RectF r = new RectF();
            //r.readFromParcel(in);
            //return r;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.446 -0400", hash_original_method = "889447B8D00C814B8B32F8DD32D6D4FC", hash_generated_method = "5C413A65AE0D45BBC98C9A3D2CAB7F6C")
        @DSModeled(DSC.SAFE)
        public RectF[] newArray(int size) {
            dsTaint.addTaint(size);
            return (RectF[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new RectF[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.446 -0400", hash_original_method = "D61F570F41294C50B794115B72F287CF", hash_generated_method = "7599FE274C35911927241997C13A906A")
    @DSModeled(DSC.SAFE)
    public RectF() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.446 -0400", hash_original_method = "5B128CE85C88A209036C5C9DCC51E26B", hash_generated_method = "58399C0041A06CB8BC609D4E50A48FCC")
    @DSModeled(DSC.SAFE)
    public RectF(float left, float top, float right, float bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        // ---------- Original Method ----------
        //this.left = left;
        //this.top = top;
        //this.right = right;
        //this.bottom = bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.446 -0400", hash_original_method = "B04E1848489B49A13109B1343E9C5563", hash_generated_method = "4B22244CA2BE4A746E908F975801815B")
    @DSModeled(DSC.SAFE)
    public RectF(RectF r) {
        dsTaint.addTaint(r.dsTaint);
        left = r.left;
        top = r.top;
        right = r.right;
        bottom = r.bottom;
        // ---------- Original Method ----------
        //left = r.left;
        //top = r.top;
        //right = r.right;
        //bottom = r.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.446 -0400", hash_original_method = "7FD4415AACB98A397DC21B4FD086AC26", hash_generated_method = "B74716F7C622F9A55BA6E1BCA7E0DF99")
    @DSModeled(DSC.SAFE)
    public RectF(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        left = r.left;
        top = r.top;
        right = r.right;
        bottom = r.bottom;
        // ---------- Original Method ----------
        //left = r.left;
        //top = r.top;
        //right = r.right;
        //bottom = r.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.446 -0400", hash_original_method = "FA213D713D9B00A169FC8BD98F160501", hash_generated_method = "0F4E145C064219060A736BF2959E03A9")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "RectF(" + left + ", " + top + ", "
                      //+ right + ", " + bottom + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.446 -0400", hash_original_method = "1840D8CED4FEDA16C265C984A5256101", hash_generated_method = "950B90C98564DE62093D3EEABD10F663")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toShortString() {
        String var0EC9E8761441C3A2F419EB3055FA5FD5_1181206353 = (toShortString(new StringBuilder(32)));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toShortString(new StringBuilder(32));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.446 -0400", hash_original_method = "2BF61B85E091A9DA2C18EB7FC26222B9", hash_generated_method = "710922910501CB28E51C674256EF410A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toShortString(StringBuilder sb) {
        dsTaint.addTaint(sb.dsTaint);
        sb.setLength(0);
        sb.append('[');
        sb.append(left);
        sb.append(',');
        sb.append(top);
        sb.append("][");
        sb.append(right);
        sb.append(',');
        sb.append(bottom);
        sb.append(']');
        String var806458D832AB974D230FEE4CBBDBD390_254586247 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //sb.setLength(0);
        //sb.append('[');
        //sb.append(left);
        //sb.append(',');
        //sb.append(top);
        //sb.append("][");
        //sb.append(right);
        //sb.append(',');
        //sb.append(bottom);
        //sb.append(']');
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.447 -0400", hash_original_method = "78960F3D6EA700D282D0F0C0E94AA84C", hash_generated_method = "03BD660F1DDB3828E3A5F49E9DFA0019")
    @DSModeled(DSC.SAFE)
    public void printShortString(PrintWriter pw) {
        dsTaint.addTaint(pw.dsTaint);
        pw.print('[');
        pw.print(left);
        pw.print(',');
        pw.print(top);
        pw.print("][");
        pw.print(right);
        pw.print(',');
        pw.print(bottom);
        pw.print(']');
        // ---------- Original Method ----------
        //pw.print('[');
        //pw.print(left);
        //pw.print(',');
        //pw.print(top);
        //pw.print("][");
        //pw.print(right);
        //pw.print(',');
        //pw.print(bottom);
        //pw.print(']');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.447 -0400", hash_original_method = "D667CC92208C0C47552A2E0207FE57FF", hash_generated_method = "08F62DE2D06DB3B638122CED65B8703F")
    @DSModeled(DSC.SAFE)
    public final boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return left >= right || top >= bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.447 -0400", hash_original_method = "83288196EAFBF73D3FE580ACE3981D30", hash_generated_method = "72BF7153BC2574DB295E1974E3763D3E")
    @DSModeled(DSC.SAFE)
    public final float width() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return right - left;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.447 -0400", hash_original_method = "1451CC0FB907B74D5032AD3E1AFBE720", hash_generated_method = "99693050FF7C18D4EAE4A13AA93E580D")
    @DSModeled(DSC.SAFE)
    public final float height() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return bottom - top;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.447 -0400", hash_original_method = "7ED8FBEF71AFB3C2D5FC3097D0B688F2", hash_generated_method = "1DCBA0995B7ECB874E1BE9007BB5BA89")
    @DSModeled(DSC.SAFE)
    public final float centerX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (left + right) * 0.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.447 -0400", hash_original_method = "5D537442DB3A76F3BCD6B0013959D546", hash_generated_method = "562050A035ADC9B341DE52F701762A78")
    @DSModeled(DSC.SAFE)
    public final float centerY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (top + bottom) * 0.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.447 -0400", hash_original_method = "86DA251BA391C7524C2010551ABD907E", hash_generated_method = "B326DAE3A43903D892BEA87C06A32045")
    @DSModeled(DSC.SAFE)
    public void setEmpty() {
        left = right = top = bottom = 0;
        // ---------- Original Method ----------
        //left = right = top = bottom = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.447 -0400", hash_original_method = "C9CE428718CAD939ED870CC4D06675F8", hash_generated_method = "6CCDCDA9D57E636A6A62D16AE1E44C9B")
    @DSModeled(DSC.SAFE)
    public void set(float left, float top, float right, float bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        // ---------- Original Method ----------
        //this.left   = left;
        //this.top    = top;
        //this.right  = right;
        //this.bottom = bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.448 -0400", hash_original_method = "A444578B9144FD8B7BC0F962002ECA0D", hash_generated_method = "CDF609CA03418103A2FFCC2593453A82")
    @DSModeled(DSC.SAFE)
    public void set(RectF src) {
        dsTaint.addTaint(src.dsTaint);
        this.left   = src.left;
        this.top    = src.top;
        this.right  = src.right;
        this.bottom = src.bottom;
        // ---------- Original Method ----------
        //this.left   = src.left;
        //this.top    = src.top;
        //this.right  = src.right;
        //this.bottom = src.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.448 -0400", hash_original_method = "91C11C9F320DC60DE37EBB0C50768E5F", hash_generated_method = "82CB74A07F3BF76818BB61D99F6B9E8C")
    @DSModeled(DSC.SAFE)
    public void set(Rect src) {
        dsTaint.addTaint(src.dsTaint);
        this.left   = src.left;
        this.top    = src.top;
        this.right  = src.right;
        this.bottom = src.bottom;
        // ---------- Original Method ----------
        //this.left   = src.left;
        //this.top    = src.top;
        //this.right  = src.right;
        //this.bottom = src.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.448 -0400", hash_original_method = "987CF6DAC95BF2616996F2B7580ECF09", hash_generated_method = "6AC972DC46D8E37497615C5357E964F7")
    @DSModeled(DSC.SAFE)
    public void offset(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        // ---------- Original Method ----------
        //left    += dx;
        //top     += dy;
        //right   += dx;
        //bottom  += dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.448 -0400", hash_original_method = "17E8F6A0DA6BEF949708E45EF28FBDEC", hash_generated_method = "1C2C9A2392AB43F00CD2D3BFB95EF71A")
    @DSModeled(DSC.SAFE)
    public void offsetTo(float newLeft, float newTop) {
        dsTaint.addTaint(newLeft);
        dsTaint.addTaint(newTop);
        right += newLeft - left;
        bottom += newTop - top;
        // ---------- Original Method ----------
        //right += newLeft - left;
        //bottom += newTop - top;
        //left = newLeft;
        //top = newTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.448 -0400", hash_original_method = "4ED8FEC7EC4817417CFF539CEB8CD3D5", hash_generated_method = "68BF072773C575A15F6D58C8F4798EEF")
    @DSModeled(DSC.SAFE)
    public void inset(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        // ---------- Original Method ----------
        //left    += dx;
        //top     += dy;
        //right   -= dx;
        //bottom  -= dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.448 -0400", hash_original_method = "7C65F21BA78E9C886CB99F3A821D7FC2", hash_generated_method = "86E8A77E0E7716FE821B02E33DC0B42B")
    @DSModeled(DSC.SAFE)
    public boolean contains(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return left < right && top < bottom  
                //&& x >= left && x < right && y >= top && y < bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.448 -0400", hash_original_method = "5736B1A89F8587C3C51B72E5484012E7", hash_generated_method = "9BDCBC1B1B52E1B04A4D6A5814EE2300")
    @DSModeled(DSC.SAFE)
    public boolean contains(float left, float top, float right, float bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.left < this.right && this.top < this.bottom
                //&& this.left <= left && this.top <= top
                //&& this.right >= right && this.bottom >= bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.449 -0400", hash_original_method = "89862D8BCB63DE9E9B3F12DF7005EDAF", hash_generated_method = "481743E92B91E23430D0A61061F1A616")
    @DSModeled(DSC.SAFE)
    public boolean contains(RectF r) {
        dsTaint.addTaint(r.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.left < this.right && this.top < this.bottom
                //&& left <= r.left && top <= r.top
                //&& right >= r.right && bottom >= r.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.449 -0400", hash_original_method = "B665C4D2FA87DEF248CEB5906A538992", hash_generated_method = "70CF260FF232EEA59A4BEAA93BE4C151")
    @DSModeled(DSC.SAFE)
    public boolean intersect(float left, float top, float right, float bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this.left < right && left < this.right
                //&& this.top < bottom && top < this.bottom) {
            //if (this.left < left) {
                //this.left = left;
            //}
            //if (this.top < top) {
                //this.top = top;
            //}
            //if (this.right > right) {
                //this.right = right;
            //}
            //if (this.bottom > bottom) {
                //this.bottom = bottom;
            //}
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.449 -0400", hash_original_method = "F1511D7F30AFB03A76430BC5FB3647DC", hash_generated_method = "0C5E754794F603D74EDE6976E956D26E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean intersect(RectF r) {
        dsTaint.addTaint(r.dsTaint);
        boolean var774B7820222CF99C9D397FA2889989AA_1236631277 = (intersect(r.left, r.top, r.right, r.bottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return intersect(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.449 -0400", hash_original_method = "798EF6BEBDE27EE5C0F4552CB6C0BADF", hash_generated_method = "6DE5D26852CF4BE23553F64B41CFD248")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setIntersect(RectF a, RectF b) {
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(a.dsTaint);
        {
            left = Math.max(a.left, b.left);
            top = Math.max(a.top, b.top);
            right = Math.min(a.right, b.right);
            bottom = Math.min(a.bottom, b.bottom);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (a.left < b.right && b.left < a.right
                //&& a.top < b.bottom && b.top < a.bottom) {
            //left = Math.max(a.left, b.left);
            //top = Math.max(a.top, b.top);
            //right = Math.min(a.right, b.right);
            //bottom = Math.min(a.bottom, b.bottom);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.449 -0400", hash_original_method = "7636A1ABF3E5D698C7B1F582C19267F0", hash_generated_method = "11EE0CBF69D933F81C6D00B3D09FFCB6")
    @DSModeled(DSC.SAFE)
    public boolean intersects(float left, float top, float right,
                              float bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.left < right && left < this.right
                //&& this.top < bottom && top < this.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.449 -0400", hash_original_method = "1FAEC0442F27706D6D5F3E840B971AB4", hash_generated_method = "B7ECD36105B38ABAEED5381ABDCCD9B3")
    public static boolean intersects(RectF a, RectF b) {
        return a.left < b.right && b.left < a.right
                && a.top < b.bottom && b.top < a.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.450 -0400", hash_original_method = "1D9E886326ACAAED42A7320F81B83BDE", hash_generated_method = "0D76E976527FE461E386ABBD045E6E46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void round(Rect dst) {
        dsTaint.addTaint(dst.dsTaint);
        dst.set(FastMath.round(left), FastMath.round(top),
                FastMath.round(right), FastMath.round(bottom));
        // ---------- Original Method ----------
        //dst.set(FastMath.round(left), FastMath.round(top),
                //FastMath.round(right), FastMath.round(bottom));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.450 -0400", hash_original_method = "5165AD4866DE272C811B07E7C1D571CC", hash_generated_method = "2C8C9429C65DECADAC0EEAD9494BC8A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void roundOut(Rect dst) {
        dsTaint.addTaint(dst.dsTaint);
        dst.set((int) FloatMath.floor(left), (int) FloatMath.floor(top),
                (int) FloatMath.ceil(right), (int) FloatMath.ceil(bottom));
        // ---------- Original Method ----------
        //dst.set((int) FloatMath.floor(left), (int) FloatMath.floor(top),
                //(int) FloatMath.ceil(right), (int) FloatMath.ceil(bottom));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.450 -0400", hash_original_method = "4ED17A6A0BD221C6F562FF187EDE0EC1", hash_generated_method = "753D1BC259635EE0769E6A25BDC616B3")
    @DSModeled(DSC.SAFE)
    public void union(float left, float top, float right, float bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        // ---------- Original Method ----------
        //if ((left < right) && (top < bottom)) {
            //if ((this.left < this.right) && (this.top < this.bottom)) {
                //if (this.left > left)
                    //this.left = left;
                //if (this.top > top)
                    //this.top = top;
                //if (this.right < right)
                    //this.right = right;
                //if (this.bottom < bottom)
                    //this.bottom = bottom;
            //} else {
                //this.left = left;
                //this.top = top;
                //this.right = right;
                //this.bottom = bottom;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.450 -0400", hash_original_method = "7333A4F184A018E8DCD665D788936108", hash_generated_method = "912ADB9E902D69F1D167ABA95524DAEB")
    @DSModeled(DSC.SAFE)
    public void union(RectF r) {
        dsTaint.addTaint(r.dsTaint);
        union(r.left, r.top, r.right, r.bottom);
        // ---------- Original Method ----------
        //union(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.450 -0400", hash_original_method = "5491E96A191FF9AA58559CF28A27B675", hash_generated_method = "F14D52C5663F9A241832E5B8DD2194D8")
    @DSModeled(DSC.SAFE)
    public void union(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        // ---------- Original Method ----------
        //if (x < left) {
            //left = x;
        //} else if (x > right) {
            //right = x;
        //}
        //if (y < top) {
            //top = y;
        //} else if (y > bottom) {
            //bottom = y;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.450 -0400", hash_original_method = "5E187609DBD260B5F8E2F7AA44836C46", hash_generated_method = "F703DF5CC721C1AA528258402C2441CD")
    @DSModeled(DSC.SAFE)
    public void sort() {
        {
            float temp;
            temp = left;
            left = right;
            right = temp;
        } //End block
        {
            float temp;
            temp = top;
            top = bottom;
            bottom = temp;
        } //End block
        // ---------- Original Method ----------
        //if (left > right) {
            //float temp = left;
            //left = right;
            //right = temp;
        //}
        //if (top > bottom) {
            //float temp = top;
            //top = bottom;
            //bottom = temp;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.450 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.451 -0400", hash_original_method = "5C789B83F9658DFF3AD82091DAFFDD49", hash_generated_method = "920CE1DB4F02C70ADD40C9AD58BAD0AD")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeFloat(left);
        out.writeFloat(top);
        out.writeFloat(right);
        out.writeFloat(bottom);
        // ---------- Original Method ----------
        //out.writeFloat(left);
        //out.writeFloat(top);
        //out.writeFloat(right);
        //out.writeFloat(bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.451 -0400", hash_original_method = "BACCEAD3B6EC38250A4D00D9AA0D9F78", hash_generated_method = "E06C63B986CB8B1715B8570B6E1D6909")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        left = in.readFloat();
        top = in.readFloat();
        right = in.readFloat();
        bottom = in.readFloat();
        // ---------- Original Method ----------
        //left = in.readFloat();
        //top = in.readFloat();
        //right = in.readFloat();
        //bottom = in.readFloat();
    }

    
}


