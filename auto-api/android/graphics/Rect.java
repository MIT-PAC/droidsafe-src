package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Rect implements Parcelable {
    public int left;
    public int top;
    public int right;
    public int bottom;
    private static final Pattern FLATTENED_PATTERN = Pattern.compile(
            "(-?\\d+) (-?\\d+) (-?\\d+) (-?\\d+)");
    public static final Parcelable.Creator<Rect> CREATOR = new Parcelable.Creator<Rect>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.378 -0400", hash_original_method = "A9B8238B616BE351FF7BBE6405761278", hash_generated_method = "005369A6E30F3AE3DA77D991A568FF97")
        @DSModeled(DSC.SAFE)
        public Rect createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            Rect r;
            r = new Rect();
            r.readFromParcel(in);
            return (Rect)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Rect r = new Rect();
            //r.readFromParcel(in);
            //return r;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.379 -0400", hash_original_method = "6E3A450019A5044B67A49D3D4BD4953E", hash_generated_method = "CDD2F2F53ECA604086A045DFD43E16D0")
        @DSModeled(DSC.SAFE)
        public Rect[] newArray(int size) {
            dsTaint.addTaint(size);
            return (Rect[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Rect[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.379 -0400", hash_original_method = "2824AA033EB3CD5BF749E2296CB51BE8", hash_generated_method = "8EC433725263C9406C2956ED54A03487")
    @DSModeled(DSC.SAFE)
    public Rect() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.379 -0400", hash_original_method = "3DCA7066BD91457D0361C44914AFE94B", hash_generated_method = "1416B8C023267E474940F224443ACD87")
    @DSModeled(DSC.SAFE)
    public Rect(int left, int top, int right, int bottom) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.379 -0400", hash_original_method = "824BA1C9E4DCE37E2C6E0AB82C317278", hash_generated_method = "57ECFA2CA49AF2975894D478BC6023CB")
    @DSModeled(DSC.SAFE)
    public Rect(Rect r) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.379 -0400", hash_original_method = "AE4801E4151B09AB4E729E9F7DAAD949", hash_generated_method = "690E59ACD4472D57478157584721917D")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        Rect r;
        r = (Rect) obj;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Rect r = (Rect) obj;
        //if (r != null) {
            //return left == r.left && top == r.top && right == r.right
                    //&& bottom == r.bottom;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.379 -0400", hash_original_method = "377E4026C49F3CEBA3B751597A4FD5E1", hash_generated_method = "6D858506D331145E44DBA8E51286DB00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(32);
        sb.append("Rect(");
        sb.append(left);
        sb.append(", ");
        sb.append(top);
        sb.append(" - ");
        sb.append(right);
        sb.append(", ");
        sb.append(bottom);
        sb.append(")");
        String var806458D832AB974D230FEE4CBBDBD390_1383409781 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(32);
        //sb.append("Rect(");
        //sb.append(left);
        //sb.append(", ");
        //sb.append(top);
        //sb.append(" - ");
        //sb.append(right);
        //sb.append(", ");
        //sb.append(bottom);
        //sb.append(")");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.379 -0400", hash_original_method = "1840D8CED4FEDA16C265C984A5256101", hash_generated_method = "8F3B7FF9133891D404C170C248ECAFAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toShortString() {
        String var0EC9E8761441C3A2F419EB3055FA5FD5_2048589586 = (toShortString(new StringBuilder(32)));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toShortString(new StringBuilder(32));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.380 -0400", hash_original_method = "2BF61B85E091A9DA2C18EB7FC26222B9", hash_generated_method = "8F29E8676D2F4C0A62E49B156664EFD9")
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
        String var806458D832AB974D230FEE4CBBDBD390_1579512922 = (sb.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.380 -0400", hash_original_method = "EE149DE53983156EB3F726A589D5EF54", hash_generated_method = "CD86F6B3A7DD23CE3DFA8AA0ED65DF17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String flattenToString() {
        StringBuilder sb;
        sb = new StringBuilder(32);
        sb.append(left);
        sb.append(' ');
        sb.append(top);
        sb.append(' ');
        sb.append(right);
        sb.append(' ');
        sb.append(bottom);
        String var806458D832AB974D230FEE4CBBDBD390_1845918039 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(32);
        //sb.append(left);
        //sb.append(' ');
        //sb.append(top);
        //sb.append(' ');
        //sb.append(right);
        //sb.append(' ');
        //sb.append(bottom);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.380 -0400", hash_original_method = "E8AECF80D8D72C58EA857DBBDC4E9523", hash_generated_method = "102CD2BBE59E92676D4B4E2A70BCE737")
    public static Rect unflattenFromString(String str) {
        Matcher matcher = FLATTENED_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        return new Rect(Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2)),
                Integer.parseInt(matcher.group(3)),
                Integer.parseInt(matcher.group(4)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.380 -0400", hash_original_method = "78960F3D6EA700D282D0F0C0E94AA84C", hash_generated_method = "03BD660F1DDB3828E3A5F49E9DFA0019")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.380 -0400", hash_original_method = "D667CC92208C0C47552A2E0207FE57FF", hash_generated_method = "08F62DE2D06DB3B638122CED65B8703F")
    @DSModeled(DSC.SAFE)
    public final boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return left >= right || top >= bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.380 -0400", hash_original_method = "B5C8F76194FE5E52EC67584A55326566", hash_generated_method = "1204658344A490B798BA380DF8C037E0")
    @DSModeled(DSC.SAFE)
    public final int width() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return right - left;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.380 -0400", hash_original_method = "D9A224C01D56297419D0F0D6874F94EA", hash_generated_method = "ABAD4E8F0DDE2FBD0BF748D1B316ACCB")
    @DSModeled(DSC.SAFE)
    public final int height() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return bottom - top;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.380 -0400", hash_original_method = "4477F17CB09FCCCFE520309EAF855087", hash_generated_method = "C9520BCA78DAE3A19A677255DB12869E")
    @DSModeled(DSC.SAFE)
    public final int centerX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (left + right) >> 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.381 -0400", hash_original_method = "F7808A0BCBFDE1BA24C3C6993963C7E5", hash_generated_method = "38AD2246F1CCE9EA57C3C181AAF152F5")
    @DSModeled(DSC.SAFE)
    public final int centerY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (top + bottom) >> 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.381 -0400", hash_original_method = "5A810E92794653D48F616BBA8E2AA992", hash_generated_method = "1BF26337B8BD7E823F530F725FAF44C9")
    @DSModeled(DSC.SAFE)
    public final float exactCenterX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (left + right) * 0.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.381 -0400", hash_original_method = "E508041D41FDDDFC9E9DB1768DECEB0F", hash_generated_method = "D317058A330D100CB7DC50A286DE4456")
    @DSModeled(DSC.SAFE)
    public final float exactCenterY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (top + bottom) * 0.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.381 -0400", hash_original_method = "86DA251BA391C7524C2010551ABD907E", hash_generated_method = "B326DAE3A43903D892BEA87C06A32045")
    @DSModeled(DSC.SAFE)
    public void setEmpty() {
        left = right = top = bottom = 0;
        // ---------- Original Method ----------
        //left = right = top = bottom = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.381 -0400", hash_original_method = "8A4FF15661083ACC473F83074A89D6F5", hash_generated_method = "089716E04FF467700082F3AB04BECCE3")
    @DSModeled(DSC.SAFE)
    public void set(int left, int top, int right, int bottom) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.381 -0400", hash_original_method = "91C11C9F320DC60DE37EBB0C50768E5F", hash_generated_method = "82CB74A07F3BF76818BB61D99F6B9E8C")
    @DSModeled(DSC.SAFE)
    public void set(Rect src) {
        dsTaint.addTaint(src.dsTaint);
        this.left = src.left;
        this.top = src.top;
        this.right = src.right;
        this.bottom = src.bottom;
        // ---------- Original Method ----------
        //this.left = src.left;
        //this.top = src.top;
        //this.right = src.right;
        //this.bottom = src.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.381 -0400", hash_original_method = "5356F6810442AA542632B0339DB7C305", hash_generated_method = "B265625B6067354E6C7F3B54E524DF05")
    @DSModeled(DSC.SAFE)
    public void offset(int dx, int dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        // ---------- Original Method ----------
        //left += dx;
        //top += dy;
        //right += dx;
        //bottom += dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.381 -0400", hash_original_method = "8125F9BA37E5C002EA31C052E4601FA7", hash_generated_method = "D9F449C044F052B5ACCD8EE447421F81")
    @DSModeled(DSC.SAFE)
    public void offsetTo(int newLeft, int newTop) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.381 -0400", hash_original_method = "17525FCBE008AE0BAFD476B05D2391E6", hash_generated_method = "DE98867AF501387796E6964D6632E95E")
    @DSModeled(DSC.SAFE)
    public void inset(int dx, int dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        // ---------- Original Method ----------
        //left += dx;
        //top += dy;
        //right -= dx;
        //bottom -= dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.382 -0400", hash_original_method = "FB3474DF9F8E4515A45B7C6979EE4374", hash_generated_method = "DF8553AF3A1F9C23FF447B4807E86AB4")
    @DSModeled(DSC.SAFE)
    public boolean contains(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return left < right && top < bottom  
               //&& x >= left && x < right && y >= top && y < bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.382 -0400", hash_original_method = "8D2675A9B64D6291A491AF0B37B18FE8", hash_generated_method = "83FA09FB359EB8A41E53104BBE93C677")
    @DSModeled(DSC.SAFE)
    public boolean contains(int left, int top, int right, int bottom) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.382 -0400", hash_original_method = "126108FF3C2D2BC5CF3ED1DC63A4E5F7", hash_generated_method = "048B4F2E42E4280C189AD90AC0930A3C")
    @DSModeled(DSC.SAFE)
    public boolean contains(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.left < this.right && this.top < this.bottom
               //&& left <= r.left && top <= r.top
               //&& right >= r.right && bottom >= r.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.382 -0400", hash_original_method = "658EB75DC95440C8FB1EDDAF8D29E614", hash_generated_method = "6AB6BD7A35C7930BB2322CB6E9281692")
    @DSModeled(DSC.SAFE)
    public boolean intersect(int left, int top, int right, int bottom) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.382 -0400", hash_original_method = "4A2C98A9983AAAE4538683164E4E11F1", hash_generated_method = "4EB1D8E662FBA1610D6459A63D269CA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean intersect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        boolean var774B7820222CF99C9D397FA2889989AA_649203258 = (intersect(r.left, r.top, r.right, r.bottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return intersect(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.383 -0400", hash_original_method = "6CBE4827BB85E1688F906F31CBC110B1", hash_generated_method = "01C16405F42E59EA40213A7BF4CCE84D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setIntersect(Rect a, Rect b) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.383 -0400", hash_original_method = "27E106C10E914B3FBF244200C2037DFC", hash_generated_method = "B2BAFA707D022C466A84215F94A13150")
    @DSModeled(DSC.SAFE)
    public boolean intersects(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.left < right && left < this.right
               //&& this.top < bottom && top < this.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.383 -0400", hash_original_method = "DDB4F2E377B648A35CE705B9BD15F1C7", hash_generated_method = "117D2ED7FB90CE5B4D5E29C989602366")
    public static boolean intersects(Rect a, Rect b) {
        return a.left < b.right && b.left < a.right
               && a.top < b.bottom && b.top < a.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.383 -0400", hash_original_method = "7C2B05BF5AFBBC7EA864CF62C0597A8B", hash_generated_method = "6DCA95E84BC32FD55FC54E2EA3DB232E")
    @DSModeled(DSC.SAFE)
    public void union(int left, int top, int right, int bottom) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.383 -0400", hash_original_method = "02BA37E056209ADFED6D0D921E351CDC", hash_generated_method = "C3E3329E319442D2FF9B429B1D025E35")
    @DSModeled(DSC.SAFE)
    public void union(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        union(r.left, r.top, r.right, r.bottom);
        // ---------- Original Method ----------
        //union(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.383 -0400", hash_original_method = "D9CAB332D4713CB79486AC2C819BD66A", hash_generated_method = "84E2B46D7C5929CC645FD3284A5A71BF")
    @DSModeled(DSC.SAFE)
    public void union(int x, int y) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.383 -0400", hash_original_method = "B19A72EC4CF8FCC2B6266E5066EB04CB", hash_generated_method = "1E23301CBC0D6ED279468F9A51DEED17")
    @DSModeled(DSC.SAFE)
    public void sort() {
        {
            int temp;
            temp = left;
            left = right;
            right = temp;
        } //End block
        {
            int temp;
            temp = top;
            top = bottom;
            bottom = temp;
        } //End block
        // ---------- Original Method ----------
        //if (left > right) {
            //int temp = left;
            //left = right;
            //right = temp;
        //}
        //if (top > bottom) {
            //int temp = top;
            //top = bottom;
            //bottom = temp;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.384 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.384 -0400", hash_original_method = "548726568B563CCA3AC6BF577DA5CC4D", hash_generated_method = "628A589B5ED4244F1EF4F5AFEC0738E3")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeInt(left);
        out.writeInt(top);
        out.writeInt(right);
        out.writeInt(bottom);
        // ---------- Original Method ----------
        //out.writeInt(left);
        //out.writeInt(top);
        //out.writeInt(right);
        //out.writeInt(bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.384 -0400", hash_original_method = "979823E39D5729D9D6A2DACBA85F6F6A", hash_generated_method = "04E45E516393B583F580EE621F5971B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        left = in.readInt();
        top = in.readInt();
        right = in.readInt();
        bottom = in.readInt();
        // ---------- Original Method ----------
        //left = in.readInt();
        //top = in.readInt();
        //right = in.readInt();
        //bottom = in.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.384 -0400", hash_original_method = "D8CF57D437DDADABC72AE60A50BB50F2", hash_generated_method = "AFBE9F2C064FC972C5279682B0C7D97B")
    @DSModeled(DSC.SAFE)
    public void scale(float scale) {
        dsTaint.addTaint(scale);
        {
            left = (int) (left * scale + 0.5f);
            top = (int) (top * scale + 0.5f);
            right = (int) (right * scale + 0.5f);
            bottom = (int) (bottom * scale + 0.5f);
        } //End block
        // ---------- Original Method ----------
        //if (scale != 1.0f) {
            //left = (int) (left * scale + 0.5f);
            //top = (int) (top * scale + 0.5f);
            //right = (int) (right * scale + 0.5f);
            //bottom = (int) (bottom * scale + 0.5f);
        //}
    }

    
}


