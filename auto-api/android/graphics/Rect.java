package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.685 -0400", hash_original_method = "2824AA033EB3CD5BF749E2296CB51BE8", hash_generated_method = "88CB725E6D9F946318418A9C095367E7")
    @DSModeled(DSC.SAFE)
    public Rect() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.685 -0400", hash_original_method = "3DCA7066BD91457D0361C44914AFE94B", hash_generated_method = "96024E3FE0F1A91CC22385FBDFCDB1C4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.685 -0400", hash_original_method = "824BA1C9E4DCE37E2C6E0AB82C317278", hash_generated_method = "A48B7DC7D4FEB2FA4BFF53935AB264E5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.686 -0400", hash_original_method = "AE4801E4151B09AB4E729E9F7DAAD949", hash_generated_method = "F79B10EFED1992B31E71D99B4ADF1C29")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.686 -0400", hash_original_method = "377E4026C49F3CEBA3B751597A4FD5E1", hash_generated_method = "C07CA5D1F0E36DB29507D4EA8A9F8605")
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
        String var806458D832AB974D230FEE4CBBDBD390_1017699614 = (sb.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.686 -0400", hash_original_method = "1840D8CED4FEDA16C265C984A5256101", hash_generated_method = "99B44CE81EC6739238C16CE601D5452F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toShortString() {
        String var0EC9E8761441C3A2F419EB3055FA5FD5_1361626392 = (toShortString(new StringBuilder(32)));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toShortString(new StringBuilder(32));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.687 -0400", hash_original_method = "2BF61B85E091A9DA2C18EB7FC26222B9", hash_generated_method = "FBAEA878EDB95B9CBFC0E4B51A88892C")
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
        String var806458D832AB974D230FEE4CBBDBD390_666244786 = (sb.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.687 -0400", hash_original_method = "EE149DE53983156EB3F726A589D5EF54", hash_generated_method = "06F8D2A2CCC784FED383F960417B6610")
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
        String var806458D832AB974D230FEE4CBBDBD390_784341098 = (sb.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.687 -0400", hash_original_method = "78960F3D6EA700D282D0F0C0E94AA84C", hash_generated_method = "CA6976325644E6F9F00A363C8E99CBCB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.688 -0400", hash_original_method = "D667CC92208C0C47552A2E0207FE57FF", hash_generated_method = "C0210E5C9447513E4FC4247231DA00F2")
    @DSModeled(DSC.SAFE)
    public final boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return left >= right || top >= bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.688 -0400", hash_original_method = "B5C8F76194FE5E52EC67584A55326566", hash_generated_method = "77BB27DC2680D0D7D464340042879908")
    @DSModeled(DSC.SAFE)
    public final int width() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return right - left;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.688 -0400", hash_original_method = "D9A224C01D56297419D0F0D6874F94EA", hash_generated_method = "EDF9B4FC55423E9E2199A57E140DB6E5")
    @DSModeled(DSC.SAFE)
    public final int height() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return bottom - top;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.688 -0400", hash_original_method = "4477F17CB09FCCCFE520309EAF855087", hash_generated_method = "EDDCE81B29B28B71341CEAB48F3E4D73")
    @DSModeled(DSC.SAFE)
    public final int centerX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (left + right) >> 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.688 -0400", hash_original_method = "F7808A0BCBFDE1BA24C3C6993963C7E5", hash_generated_method = "41A8D00C627DA3D1A2950B8AA921F933")
    @DSModeled(DSC.SAFE)
    public final int centerY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (top + bottom) >> 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.689 -0400", hash_original_method = "5A810E92794653D48F616BBA8E2AA992", hash_generated_method = "452362AD39DFF3FBCDE20DB7E4A729DE")
    @DSModeled(DSC.SAFE)
    public final float exactCenterX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (left + right) * 0.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.689 -0400", hash_original_method = "E508041D41FDDDFC9E9DB1768DECEB0F", hash_generated_method = "C64A49CB7713A446B58DDAB2571FB4A4")
    @DSModeled(DSC.SAFE)
    public final float exactCenterY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (top + bottom) * 0.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.689 -0400", hash_original_method = "86DA251BA391C7524C2010551ABD907E", hash_generated_method = "A534843FC0914524CAF333DFA3D47813")
    @DSModeled(DSC.SAFE)
    public void setEmpty() {
        left = right = top = bottom = 0;
        // ---------- Original Method ----------
        //left = right = top = bottom = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.689 -0400", hash_original_method = "8A4FF15661083ACC473F83074A89D6F5", hash_generated_method = "C94C217686E5BF08A0D91E72311D74B5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.690 -0400", hash_original_method = "91C11C9F320DC60DE37EBB0C50768E5F", hash_generated_method = "2161481957620216A7C02A72AB36A466")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.690 -0400", hash_original_method = "5356F6810442AA542632B0339DB7C305", hash_generated_method = "75586D77190CECDBB56B7E2CC7E1A29B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.690 -0400", hash_original_method = "8125F9BA37E5C002EA31C052E4601FA7", hash_generated_method = "AFF164EED119D2DAC0BDC073ABB60ADA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.690 -0400", hash_original_method = "17525FCBE008AE0BAFD476B05D2391E6", hash_generated_method = "DCD23A1E1675FD4A7A52E183DF3C5CF8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.691 -0400", hash_original_method = "FB3474DF9F8E4515A45B7C6979EE4374", hash_generated_method = "561C47A64581E6CC074A1AAC00A02DF4")
    @DSModeled(DSC.SAFE)
    public boolean contains(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return left < right && top < bottom  
               //&& x >= left && x < right && y >= top && y < bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.691 -0400", hash_original_method = "8D2675A9B64D6291A491AF0B37B18FE8", hash_generated_method = "0B9599D9D3E9E56BCA57DC738838984C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.691 -0400", hash_original_method = "126108FF3C2D2BC5CF3ED1DC63A4E5F7", hash_generated_method = "6DB6993772F4421D466BB3AD97922F22")
    @DSModeled(DSC.SAFE)
    public boolean contains(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.left < this.right && this.top < this.bottom
               //&& left <= r.left && top <= r.top
               //&& right >= r.right && bottom >= r.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.692 -0400", hash_original_method = "658EB75DC95440C8FB1EDDAF8D29E614", hash_generated_method = "87B4246077B02D5DE7940C5C4F7ECE67")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.692 -0400", hash_original_method = "4A2C98A9983AAAE4538683164E4E11F1", hash_generated_method = "2EBB4F5C8882C85B7711E270AED107E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean intersect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        boolean var774B7820222CF99C9D397FA2889989AA_446863825 = (intersect(r.left, r.top, r.right, r.bottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return intersect(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.692 -0400", hash_original_method = "6CBE4827BB85E1688F906F31CBC110B1", hash_generated_method = "0BD79FC17E955677356EE7AE27AA24A3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.693 -0400", hash_original_method = "27E106C10E914B3FBF244200C2037DFC", hash_generated_method = "B1042399213364664EB8BEEEB1CB11FD")
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

    
        public static boolean intersects(Rect a, Rect b) {
        return a.left < b.right && b.left < a.right
               && a.top < b.bottom && b.top < a.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.693 -0400", hash_original_method = "7C2B05BF5AFBBC7EA864CF62C0597A8B", hash_generated_method = "C83B940C7B460A371BD8ACCE305E287D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.693 -0400", hash_original_method = "02BA37E056209ADFED6D0D921E351CDC", hash_generated_method = "0E0C0E2659F43793AD0A29195CD1E5AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void union(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        union(r.left, r.top, r.right, r.bottom);
        // ---------- Original Method ----------
        //union(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.694 -0400", hash_original_method = "D9CAB332D4713CB79486AC2C819BD66A", hash_generated_method = "E2AD441D1B7768FBD1C5D959D5C9F0D8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.694 -0400", hash_original_method = "B19A72EC4CF8FCC2B6266E5066EB04CB", hash_generated_method = "32ACB3F194E811B0D00CF9A07606D7C6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.694 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.694 -0400", hash_original_method = "548726568B563CCA3AC6BF577DA5CC4D", hash_generated_method = "7A3E4AB5F260AD354BE0DD9D9584B37F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.695 -0400", hash_original_method = "979823E39D5729D9D6A2DACBA85F6F6A", hash_generated_method = "A6B3A321B7E3A44431A32AC156793644")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.695 -0400", hash_original_method = "D8CF57D437DDADABC72AE60A50BB50F2", hash_generated_method = "9A1AB230BDDD2992F5C315C038C79E99")
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

    
    private static final Pattern FLATTENED_PATTERN = Pattern.compile(
            "(-?\\d+) (-?\\d+) (-?\\d+) (-?\\d+)");
    public static final Parcelable.Creator<Rect> CREATOR = new Parcelable.Creator<Rect>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.695 -0400", hash_original_method = "A9B8238B616BE351FF7BBE6405761278", hash_generated_method = "20F813203E69346321083A0E6AD214AD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.695 -0400", hash_original_method = "6E3A450019A5044B67A49D3D4BD4953E", hash_generated_method = "23AD6F6CAF709C0D6E2FA9916B8C5BEB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Rect[] newArray(int size) {
            dsTaint.addTaint(size);
            Rect[] var3018C73D84710416B68190D670882671_1058452489 = (new Rect[size]);
            return (Rect[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Rect[size];
        }

        
}; //Transformed anonymous class
}

