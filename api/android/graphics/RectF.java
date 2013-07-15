package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.PrintWriter;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.FloatMath;
import com.android.internal.util.FastMath;

public class RectF implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.236 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "F463FF95349F5FFDEBFA1888AA372D7F")

    public float left;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.236 -0400", hash_original_field = "B28354B543375BFA94DABAEDA722927F", hash_generated_field = "F9D622C84E97B0C2CBDBCB618909D322")

    public float top;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.236 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "4A45372E50F3A0CA9B8E80524FE9837C")

    public float right;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.236 -0400", hash_original_field = "71F262D796BED1AB30E8A2D5A8DDEE6F", hash_generated_field = "3601A2C074D2F75BE50976E0F9B684C6")

    public float bottom;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.236 -0400", hash_original_method = "D61F570F41294C50B794115B72F287CF", hash_generated_method = "FB1DA24AD52B1F8131024D12E52691C3")
    public  RectF() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.238 -0400", hash_original_method = "5B128CE85C88A209036C5C9DCC51E26B", hash_generated_method = "3EDBF02BD4BEB5E789B57FE1928F6929")
    public  RectF(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        // ---------- Original Method ----------
        //this.left = left;
        //this.top = top;
        //this.right = right;
        //this.bottom = bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.238 -0400", hash_original_method = "B04E1848489B49A13109B1343E9C5563", hash_generated_method = "468C2DB7F428A4C6C73464452505394B")
    public  RectF(RectF r) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.239 -0400", hash_original_method = "7FD4415AACB98A397DC21B4FD086AC26", hash_generated_method = "50BF0A54EC76D10DA74704D8CEEF9B49")
    public  RectF(Rect r) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.240 -0400", hash_original_method = "FA213D713D9B00A169FC8BD98F160501", hash_generated_method = "C00C547785F80171BE67F3B52904C4C2")
    public String toString() {
String varF3FD9A345E29397D76B73D1546832AFC_71882406 =         "RectF(" + left + ", " + top + ", "
                      + right + ", " + bottom + ")";
        varF3FD9A345E29397D76B73D1546832AFC_71882406.addTaint(taint);
        return varF3FD9A345E29397D76B73D1546832AFC_71882406;
        // ---------- Original Method ----------
        //return "RectF(" + left + ", " + top + ", "
                      //+ right + ", " + bottom + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.240 -0400", hash_original_method = "1840D8CED4FEDA16C265C984A5256101", hash_generated_method = "BD4B3F1D2A2B4319DA1780E2E5CFEAEF")
    public String toShortString() {
String varA3000DD8750FB67E255CCEC66005522D_1978125948 =         toShortString(new StringBuilder(32));
        varA3000DD8750FB67E255CCEC66005522D_1978125948.addTaint(taint);
        return varA3000DD8750FB67E255CCEC66005522D_1978125948;
        // ---------- Original Method ----------
        //return toShortString(new StringBuilder(32));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.240 -0400", hash_original_method = "2BF61B85E091A9DA2C18EB7FC26222B9", hash_generated_method = "5607A4D76B6D13C7209E148C12A1532E")
    public String toShortString(StringBuilder sb) {
        addTaint(sb.getTaint());
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
String var2460B846747F8B22185AD8BE722266A5_3732378 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_3732378.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_3732378;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.241 -0400", hash_original_method = "78960F3D6EA700D282D0F0C0E94AA84C", hash_generated_method = "972617801DE3330D088D24CF209054E4")
    public void printShortString(PrintWriter pw) {
        addTaint(pw.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.241 -0400", hash_original_method = "D667CC92208C0C47552A2E0207FE57FF", hash_generated_method = "3038FB78DB5207B257971B01F35A101E")
    public final boolean isEmpty() {
        boolean var5BA6ADEF85521CC0A2916760814FCF93_1000349687 = (left >= right || top >= bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1940343117 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1940343117;
        // ---------- Original Method ----------
        //return left >= right || top >= bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.241 -0400", hash_original_method = "83288196EAFBF73D3FE580ACE3981D30", hash_generated_method = "1D41DB8FE699D2F564B01835CDB66F38")
    public final float width() {
        float var88F0E5CB3EAA647E9260CF3FB49CC290_1645324477 = (right - left);
                float var546ADE640B6EDFBC8A086EF31347E768_2117207114 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2117207114;
        // ---------- Original Method ----------
        //return right - left;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.242 -0400", hash_original_method = "1451CC0FB907B74D5032AD3E1AFBE720", hash_generated_method = "DF22A4C117DEC68BB8FF09095392E157")
    public final float height() {
        float varF8C4A5D78D17BACD13F5BFF4ECA44EC8_175432514 = (bottom - top);
                float var546ADE640B6EDFBC8A086EF31347E768_1059163799 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1059163799;
        // ---------- Original Method ----------
        //return bottom - top;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.242 -0400", hash_original_method = "7ED8FBEF71AFB3C2D5FC3097D0B688F2", hash_generated_method = "F81935E168AE82C5FB71A42FCD35DFC7")
    public final float centerX() {
        float varA4632249F58E4F4D11727DB1456053B9_242648232 = ((left + right) * 0.5f);
                float var546ADE640B6EDFBC8A086EF31347E768_1898961024 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1898961024;
        // ---------- Original Method ----------
        //return (left + right) * 0.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.242 -0400", hash_original_method = "5D537442DB3A76F3BCD6B0013959D546", hash_generated_method = "EC950211CD799F86A5E68DF951EA7FE2")
    public final float centerY() {
        float var3AE3C0970807829B301DA0A4EED9B2B7_319920167 = ((top + bottom) * 0.5f);
                float var546ADE640B6EDFBC8A086EF31347E768_430506982 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_430506982;
        // ---------- Original Method ----------
        //return (top + bottom) * 0.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.243 -0400", hash_original_method = "86DA251BA391C7524C2010551ABD907E", hash_generated_method = "A534843FC0914524CAF333DFA3D47813")
    public void setEmpty() {
        left = right = top = bottom = 0;
        // ---------- Original Method ----------
        //left = right = top = bottom = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.244 -0400", hash_original_method = "C9CE428718CAD939ED870CC4D06675F8", hash_generated_method = "2A85EE30C4B8864948265082CE411DF6")
    public void set(float left, float top, float right, float bottom) {
        this.left   = left;
        this.top    = top;
        this.right  = right;
        this.bottom = bottom;
        // ---------- Original Method ----------
        //this.left   = left;
        //this.top    = top;
        //this.right  = right;
        //this.bottom = bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.244 -0400", hash_original_method = "A444578B9144FD8B7BC0F962002ECA0D", hash_generated_method = "A2BCF7BFC8C00B0302B6DBD183490028")
    public void set(RectF src) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.245 -0400", hash_original_method = "91C11C9F320DC60DE37EBB0C50768E5F", hash_generated_method = "45CCA2CE8624F5E69CCAB95C4EAC18C1")
    public void set(Rect src) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.246 -0400", hash_original_method = "987CF6DAC95BF2616996F2B7580ECF09", hash_generated_method = "69E19F3AA943EB5750A9E7830A61E539")
    public void offset(float dx, float dy) {
        left    += dx;
        top     += dy;
        right   += dx;
        bottom  += dy;
        // ---------- Original Method ----------
        //left    += dx;
        //top     += dy;
        //right   += dx;
        //bottom  += dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.246 -0400", hash_original_method = "17E8F6A0DA6BEF949708E45EF28FBDEC", hash_generated_method = "84DEB00742BF1B269391B92566372004")
    public void offsetTo(float newLeft, float newTop) {
        right += newLeft - left;
        bottom += newTop - top;
        left = newLeft;
        top = newTop;
        // ---------- Original Method ----------
        //right += newLeft - left;
        //bottom += newTop - top;
        //left = newLeft;
        //top = newTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.247 -0400", hash_original_method = "4ED8FEC7EC4817417CFF539CEB8CD3D5", hash_generated_method = "04F62736CE8F4E9564C2C46286D37109")
    public void inset(float dx, float dy) {
        left    += dx;
        top     += dy;
        right   -= dx;
        bottom  -= dy;
        // ---------- Original Method ----------
        //left    += dx;
        //top     += dy;
        //right   -= dx;
        //bottom  -= dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.248 -0400", hash_original_method = "7C65F21BA78E9C886CB99F3A821D7FC2", hash_generated_method = "73B0D02EE0BD33C1996573F420DCC720")
    public boolean contains(float x, float y) {
        addTaint(y);
        addTaint(x);
        boolean var25BF9CC4752259093CAAA87DDA4C0BD6_119354836 = (left < right && top < bottom  
                && x >= left && x < right && y >= top && y < bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1108411027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1108411027;
        // ---------- Original Method ----------
        //return left < right && top < bottom  
                //&& x >= left && x < right && y >= top && y < bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.248 -0400", hash_original_method = "5736B1A89F8587C3C51B72E5484012E7", hash_generated_method = "FEFE75E07FC784A0C482E73D522B1E7A")
    public boolean contains(float left, float top, float right, float bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean varA66DD9D365F5FD000A7A0453D2434F55_438278886 = (this.left < this.right && this.top < this.bottom
                && this.left <= left && this.top <= top
                && this.right >= right && this.bottom >= bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2001013755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2001013755;
        // ---------- Original Method ----------
        //return this.left < this.right && this.top < this.bottom
                //&& this.left <= left && this.top <= top
                //&& this.right >= right && this.bottom >= bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.249 -0400", hash_original_method = "89862D8BCB63DE9E9B3F12DF7005EDAF", hash_generated_method = "133E6981699DEEDB4302BA26A7FB97EF")
    public boolean contains(RectF r) {
        addTaint(r.getTaint());
        boolean varCB22694901ED7DDFB5C7128EDFABB063_2016651233 = (this.left < this.right && this.top < this.bottom
                && left <= r.left && top <= r.top
                && right >= r.right && bottom >= r.bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_171006318 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_171006318;
        // ---------- Original Method ----------
        //return this.left < this.right && this.top < this.bottom
                //&& left <= r.left && top <= r.top
                //&& right >= r.right && bottom >= r.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.250 -0400", hash_original_method = "B665C4D2FA87DEF248CEB5906A538992", hash_generated_method = "446EC25CEC095D4256A986CC10400E3E")
    public boolean intersect(float left, float top, float right, float bottom) {
    if(this.left < right && left < this.right
                && this.top < bottom && top < this.bottom)        
        {
    if(this.left < left)            
            {
                this.left = left;
            } //End block
    if(this.top < top)            
            {
                this.top = top;
            } //End block
    if(this.right > right)            
            {
                this.right = right;
            } //End block
    if(this.bottom > bottom)            
            {
                this.bottom = bottom;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_779924743 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371666629 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371666629;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1168223006 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1458472081 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1458472081;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.251 -0400", hash_original_method = "F1511D7F30AFB03A76430BC5FB3647DC", hash_generated_method = "E9241F37C7155DBEE1FAA3FCD7FDF002")
    public boolean intersect(RectF r) {
        addTaint(r.getTaint());
        boolean varBDDD5DA93332D9D54ACD4F6F853C3B70_793552703 = (intersect(r.left, r.top, r.right, r.bottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1915969992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1915969992;
        // ---------- Original Method ----------
        //return intersect(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.252 -0400", hash_original_method = "798EF6BEBDE27EE5C0F4552CB6C0BADF", hash_generated_method = "C89867A2BAA9A646E009836EEFA6DFFD")
    public boolean setIntersect(RectF a, RectF b) {
    if(a.left < b.right && b.left < a.right
                && a.top < b.bottom && b.top < a.bottom)        
        {
            left = Math.max(a.left, b.left);
            top = Math.max(a.top, b.top);
            right = Math.min(a.right, b.right);
            bottom = Math.min(a.bottom, b.bottom);
            boolean varB326B5062B2F0E69046810717534CB09_599936097 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_261026688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_261026688;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_210028898 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1155812196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1155812196;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.252 -0400", hash_original_method = "7636A1ABF3E5D698C7B1F582C19267F0", hash_generated_method = "828BAE694B4B7E74C9B47B2537C6C980")
    public boolean intersects(float left, float top, float right,
                              float bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean varF9D0769DA301445206C652D15DD88A78_1038502131 = (this.left < right && left < this.right
                && this.top < bottom && top < this.bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_834722967 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_834722967;
        // ---------- Original Method ----------
        //return this.left < right && left < this.right
                //&& this.top < bottom && top < this.bottom;
    }

    
        public static boolean intersects(RectF a, RectF b) {
        return a.left < b.right && b.left < a.right
                && a.top < b.bottom && b.top < a.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.253 -0400", hash_original_method = "1D9E886326ACAAED42A7320F81B83BDE", hash_generated_method = "3DDC4F376A4EE8E084A0EF39CD957DCB")
    public void round(Rect dst) {
        addTaint(dst.getTaint());
        dst.set(FastMath.round(left), FastMath.round(top),
                FastMath.round(right), FastMath.round(bottom));
        // ---------- Original Method ----------
        //dst.set(FastMath.round(left), FastMath.round(top),
                //FastMath.round(right), FastMath.round(bottom));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.253 -0400", hash_original_method = "5165AD4866DE272C811B07E7C1D571CC", hash_generated_method = "1F275E2CCBC62A047D6A759361926175")
    public void roundOut(Rect dst) {
        addTaint(dst.getTaint());
        dst.set((int) FloatMath.floor(left), (int) FloatMath.floor(top),
                (int) FloatMath.ceil(right), (int) FloatMath.ceil(bottom));
        // ---------- Original Method ----------
        //dst.set((int) FloatMath.floor(left), (int) FloatMath.floor(top),
                //(int) FloatMath.ceil(right), (int) FloatMath.ceil(bottom));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.256 -0400", hash_original_method = "4ED17A6A0BD221C6F562FF187EDE0EC1", hash_generated_method = "0985665CC34BA903BEF0108EFE0E233D")
    public void union(float left, float top, float right, float bottom) {
    if((left < right) && (top < bottom))        
        {
    if((this.left < this.right) && (this.top < this.bottom))            
            {
    if(this.left > left)                
                this.left = left;
    if(this.top > top)                
                this.top = top;
    if(this.right < right)                
                this.right = right;
    if(this.bottom < bottom)                
                this.bottom = bottom;
            } //End block
            else
            {
                this.left = left;
                this.top = top;
                this.right = right;
                this.bottom = bottom;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.257 -0400", hash_original_method = "7333A4F184A018E8DCD665D788936108", hash_generated_method = "488F1849C916BD78F32B6DED7CCA4767")
    public void union(RectF r) {
        addTaint(r.getTaint());
        union(r.left, r.top, r.right, r.bottom);
        // ---------- Original Method ----------
        //union(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.258 -0400", hash_original_method = "5491E96A191FF9AA58559CF28A27B675", hash_generated_method = "CA5B36864605D093C669765F523DEF4A")
    public void union(float x, float y) {
    if(x < left)        
        {
            left = x;
        } //End block
        else
    if(x > right)        
        {
            right = x;
        } //End block
    if(y < top)        
        {
            top = y;
        } //End block
        else
    if(y > bottom)        
        {
            bottom = y;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.260 -0400", hash_original_method = "5E187609DBD260B5F8E2F7AA44836C46", hash_generated_method = "6E8A505939D38FD3959D3E0F9920FADC")
    public void sort() {
    if(left > right)        
        {
            float temp = left;
            left = right;
            right = temp;
        } //End block
    if(top > bottom)        
        {
            float temp = top;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.260 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "63A2D53168F0A330E7C18723B7030155")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_676910314 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737844213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737844213;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.261 -0400", hash_original_method = "5C789B83F9658DFF3AD82091DAFFDD49", hash_generated_method = "8AF90B799398630A2D8FEE2DEEF7185B")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.262 -0400", hash_original_method = "BACCEAD3B6EC38250A4D00D9AA0D9F78", hash_generated_method = "5840D49EC2222CD5F0BDEB5ED8E3F923")
    public void readFromParcel(Parcel in) {
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.262 -0400", hash_original_field = "5E7201C60E05C026DD3550B3101B80A5", hash_generated_field = "C46FA4AE8D434E2146AE8F7264B82507")

    public static final Parcelable.Creator<RectF> CREATOR = new Parcelable.Creator<RectF>() {
        
        public RectF createFromParcel(Parcel in) {
            RectF r = new RectF();
            r.readFromParcel(in);
            return r;
        }
        
        
        public RectF[] newArray(int size) {
            return new RectF[size];
        }
    };
    // orphaned legacy method
    public RectF createFromParcel(Parcel in) {
            RectF r = new RectF();
            r.readFromParcel(in);
            return r;
        }
    
    // orphaned legacy method
    public RectF[] newArray(int size) {
            return new RectF[size];
        }
    
}

