package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.773 -0400", hash_original_method = "D61F570F41294C50B794115B72F287CF", hash_generated_method = "FB1DA24AD52B1F8131024D12E52691C3")
    @DSModeled(DSC.SAFE)
    public RectF() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.773 -0400", hash_original_method = "5B128CE85C88A209036C5C9DCC51E26B", hash_generated_method = "D17598C744E9560119ED0F255EF6BDE4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.774 -0400", hash_original_method = "B04E1848489B49A13109B1343E9C5563", hash_generated_method = "4BAB760EE26525E4185A388B8D061095")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.774 -0400", hash_original_method = "7FD4415AACB98A397DC21B4FD086AC26", hash_generated_method = "05D8D81149BA84AD924024D584CAF6DE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.774 -0400", hash_original_method = "FA213D713D9B00A169FC8BD98F160501", hash_generated_method = "AFF9E0F9F539B7FCFAA49C9E7984F34F")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "RectF(" + left + ", " + top + ", "
                      //+ right + ", " + bottom + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.774 -0400", hash_original_method = "1840D8CED4FEDA16C265C984A5256101", hash_generated_method = "3B06E494085A09A41F9EB622E61FF865")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toShortString() {
        String var0EC9E8761441C3A2F419EB3055FA5FD5_262772793 = (toShortString(new StringBuilder(32)));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toShortString(new StringBuilder(32));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.775 -0400", hash_original_method = "2BF61B85E091A9DA2C18EB7FC26222B9", hash_generated_method = "6C880AA9462C57FD535F1D0A0F7E515D")
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
        String var806458D832AB974D230FEE4CBBDBD390_380519307 = (sb.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.775 -0400", hash_original_method = "78960F3D6EA700D282D0F0C0E94AA84C", hash_generated_method = "CA6976325644E6F9F00A363C8E99CBCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.775 -0400", hash_original_method = "D667CC92208C0C47552A2E0207FE57FF", hash_generated_method = "C0210E5C9447513E4FC4247231DA00F2")
    @DSModeled(DSC.SAFE)
    public final boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return left >= right || top >= bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.775 -0400", hash_original_method = "83288196EAFBF73D3FE580ACE3981D30", hash_generated_method = "F2C01578B4236CFD8CC224D19E601B94")
    @DSModeled(DSC.SAFE)
    public final float width() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return right - left;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.776 -0400", hash_original_method = "1451CC0FB907B74D5032AD3E1AFBE720", hash_generated_method = "90A241DC389CAA0909D88A187518312F")
    @DSModeled(DSC.SAFE)
    public final float height() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return bottom - top;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.776 -0400", hash_original_method = "7ED8FBEF71AFB3C2D5FC3097D0B688F2", hash_generated_method = "EC92A6849747288329837749CF2F5D5B")
    @DSModeled(DSC.SAFE)
    public final float centerX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (left + right) * 0.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.776 -0400", hash_original_method = "5D537442DB3A76F3BCD6B0013959D546", hash_generated_method = "0A6190E9AEBC51B842AFF21742C5D962")
    @DSModeled(DSC.SAFE)
    public final float centerY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (top + bottom) * 0.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.776 -0400", hash_original_method = "86DA251BA391C7524C2010551ABD907E", hash_generated_method = "A534843FC0914524CAF333DFA3D47813")
    @DSModeled(DSC.SAFE)
    public void setEmpty() {
        left = right = top = bottom = 0;
        // ---------- Original Method ----------
        //left = right = top = bottom = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.777 -0400", hash_original_method = "C9CE428718CAD939ED870CC4D06675F8", hash_generated_method = "346813D48D569F4823971C0842B56923")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.777 -0400", hash_original_method = "A444578B9144FD8B7BC0F962002ECA0D", hash_generated_method = "76D0AC940C6AF1636C475644AC477FB3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.777 -0400", hash_original_method = "91C11C9F320DC60DE37EBB0C50768E5F", hash_generated_method = "2161481957620216A7C02A72AB36A466")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.777 -0400", hash_original_method = "987CF6DAC95BF2616996F2B7580ECF09", hash_generated_method = "DA196AFE3D90EB9443FCDFC4B90009B2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.778 -0400", hash_original_method = "17E8F6A0DA6BEF949708E45EF28FBDEC", hash_generated_method = "59F14F079832A0EB4A2756533F3D4DC0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.778 -0400", hash_original_method = "4ED8FEC7EC4817417CFF539CEB8CD3D5", hash_generated_method = "9B043959AAAB9EE1BB211D6E3DBB3A93")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.778 -0400", hash_original_method = "7C65F21BA78E9C886CB99F3A821D7FC2", hash_generated_method = "A6F8E82D8BB3D9669EDFD2082E21D2A0")
    @DSModeled(DSC.SAFE)
    public boolean contains(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return left < right && top < bottom  
                //&& x >= left && x < right && y >= top && y < bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.778 -0400", hash_original_method = "5736B1A89F8587C3C51B72E5484012E7", hash_generated_method = "03E00C6365F64A84660132F69D910A7E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.779 -0400", hash_original_method = "89862D8BCB63DE9E9B3F12DF7005EDAF", hash_generated_method = "1D44BAE796D25C897A140D6BF842EEA4")
    @DSModeled(DSC.SAFE)
    public boolean contains(RectF r) {
        dsTaint.addTaint(r.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.left < this.right && this.top < this.bottom
                //&& left <= r.left && top <= r.top
                //&& right >= r.right && bottom >= r.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.779 -0400", hash_original_method = "B665C4D2FA87DEF248CEB5906A538992", hash_generated_method = "2DE43EF5FAB8691BA0B6BD877F4B1222")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.779 -0400", hash_original_method = "F1511D7F30AFB03A76430BC5FB3647DC", hash_generated_method = "02836E740B3FAB7F00EBFDF2110A26A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean intersect(RectF r) {
        dsTaint.addTaint(r.dsTaint);
        boolean var774B7820222CF99C9D397FA2889989AA_1437483626 = (intersect(r.left, r.top, r.right, r.bottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return intersect(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.780 -0400", hash_original_method = "798EF6BEBDE27EE5C0F4552CB6C0BADF", hash_generated_method = "6B32E21DA1DA4C4D67855FA765530A64")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.780 -0400", hash_original_method = "7636A1ABF3E5D698C7B1F582C19267F0", hash_generated_method = "A201FA43D96778930B825CC62290A7AC")
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

    
        public static boolean intersects(RectF a, RectF b) {
        return a.left < b.right && b.left < a.right
                && a.top < b.bottom && b.top < a.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.780 -0400", hash_original_method = "1D9E886326ACAAED42A7320F81B83BDE", hash_generated_method = "1A583777B3B6DAFB52FC1E894963B2AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void round(Rect dst) {
        dsTaint.addTaint(dst.dsTaint);
        dst.set(FastMath.round(left), FastMath.round(top),
                FastMath.round(right), FastMath.round(bottom));
        // ---------- Original Method ----------
        //dst.set(FastMath.round(left), FastMath.round(top),
                //FastMath.round(right), FastMath.round(bottom));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.781 -0400", hash_original_method = "5165AD4866DE272C811B07E7C1D571CC", hash_generated_method = "B72198A229D53095C4CB515E21781D43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void roundOut(Rect dst) {
        dsTaint.addTaint(dst.dsTaint);
        dst.set((int) FloatMath.floor(left), (int) FloatMath.floor(top),
                (int) FloatMath.ceil(right), (int) FloatMath.ceil(bottom));
        // ---------- Original Method ----------
        //dst.set((int) FloatMath.floor(left), (int) FloatMath.floor(top),
                //(int) FloatMath.ceil(right), (int) FloatMath.ceil(bottom));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.781 -0400", hash_original_method = "4ED17A6A0BD221C6F562FF187EDE0EC1", hash_generated_method = "D9EF88CD98A6FD7E7EAE84C747499E92")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.781 -0400", hash_original_method = "7333A4F184A018E8DCD665D788936108", hash_generated_method = "04335B738AFA77C1E2139E7DA117D8F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void union(RectF r) {
        dsTaint.addTaint(r.dsTaint);
        union(r.left, r.top, r.right, r.bottom);
        // ---------- Original Method ----------
        //union(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.782 -0400", hash_original_method = "5491E96A191FF9AA58559CF28A27B675", hash_generated_method = "F788648B872BC8C804D33978EED63C78")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.782 -0400", hash_original_method = "5E187609DBD260B5F8E2F7AA44836C46", hash_generated_method = "442C16DA530705E8E4D036A737CEFC18")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.782 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.782 -0400", hash_original_method = "5C789B83F9658DFF3AD82091DAFFDD49", hash_generated_method = "3205EF0A85BD5A8E94793C68BD8EA9FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.783 -0400", hash_original_method = "BACCEAD3B6EC38250A4D00D9AA0D9F78", hash_generated_method = "91CC9D1A02C5CDDAE40C781BC73E1624")
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

    
    public static final Parcelable.Creator<RectF> CREATOR = new Parcelable.Creator<RectF>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.783 -0400", hash_original_method = "A6A0C6EE524221145489C3D66C6A94BD", hash_generated_method = "3EF6C5F8296473AF096EA669499BF98C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.783 -0400", hash_original_method = "889447B8D00C814B8B32F8DD32D6D4FC", hash_generated_method = "71B8DCBF636EF8934D1E98B536BA123C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RectF[] newArray(int size) {
            dsTaint.addTaint(size);
            RectF[] varBC89C2709041F51370842C26F8F201BB_801623266 = (new RectF[size]);
            return (RectF[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new RectF[size];
        }

        
}; //Transformed anonymous class
}

