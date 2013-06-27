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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.813 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "1DC0B64660F00182FB9FBCCB50A51F92")

    public int left;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.813 -0400", hash_original_field = "B28354B543375BFA94DABAEDA722927F", hash_generated_field = "4FB04C904AA02F82B407995BA570583C")

    public int top;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.813 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "8D8E5E7DA2C11F273C631EF06D16F776")

    public int right;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.813 -0400", hash_original_field = "71F262D796BED1AB30E8A2D5A8DDEE6F", hash_generated_field = "F7035266BD2A20B12FE551C6FAE7D704")

    public int bottom;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.835 -0400", hash_original_method = "2824AA033EB3CD5BF749E2296CB51BE8", hash_generated_method = "88CB725E6D9F946318418A9C095367E7")
    public  Rect() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.837 -0400", hash_original_method = "3DCA7066BD91457D0361C44914AFE94B", hash_generated_method = "9D93B8D0B8A2381D4373463BE736CBD3")
    public  Rect(int left, int top, int right, int bottom) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.857 -0400", hash_original_method = "824BA1C9E4DCE37E2C6E0AB82C317278", hash_generated_method = "FEFC0E392B8902310E80F76AC868DB50")
    public  Rect(Rect r) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.862 -0400", hash_original_method = "AE4801E4151B09AB4E729E9F7DAAD949", hash_generated_method = "1ABC7D0A46C31C869440ACB5CD30E3B1")
    @Override
    public boolean equals(Object obj) {
        Rect r;
        r = (Rect) obj;
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1843478530 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1843478530;
        // ---------- Original Method ----------
        //Rect r = (Rect) obj;
        //if (r != null) {
            //return left == r.left && top == r.top && right == r.right
                    //&& bottom == r.bottom;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.878 -0400", hash_original_method = "377E4026C49F3CEBA3B751597A4FD5E1", hash_generated_method = "9C003D0AD206A7F591D8CAA39BD3EB48")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_48859813 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_48859813 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_48859813.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_48859813;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.883 -0400", hash_original_method = "1840D8CED4FEDA16C265C984A5256101", hash_generated_method = "A19A99270D6294447C0230C17768394B")
    public String toShortString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1448565218 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1448565218 = toShortString(new StringBuilder(32));
        varB4EAC82CA7396A68D541C85D26508E83_1448565218.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1448565218;
        // ---------- Original Method ----------
        //return toShortString(new StringBuilder(32));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.911 -0400", hash_original_method = "2BF61B85E091A9DA2C18EB7FC26222B9", hash_generated_method = "6B38B4B68A895C240FF3BC8986EBCE83")
    public String toShortString(StringBuilder sb) {
        String varB4EAC82CA7396A68D541C85D26508E83_395220463 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_395220463 = sb.toString();
        addTaint(sb.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_395220463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_395220463;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.914 -0400", hash_original_method = "EE149DE53983156EB3F726A589D5EF54", hash_generated_method = "240145EECDC5A8ABD393E86D4D6FE42A")
    public String flattenToString() {
        String varB4EAC82CA7396A68D541C85D26508E83_528269687 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(32);
        sb.append(left);
        sb.append(' ');
        sb.append(top);
        sb.append(' ');
        sb.append(right);
        sb.append(' ');
        sb.append(bottom);
        varB4EAC82CA7396A68D541C85D26508E83_528269687 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_528269687.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_528269687;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.946 -0400", hash_original_method = "78960F3D6EA700D282D0F0C0E94AA84C", hash_generated_method = "7CC9973023E2CD924438EDC646D73B58")
    public void printShortString(PrintWriter pw) {
        pw.print('[');
        pw.print(left);
        pw.print(',');
        pw.print(top);
        pw.print("][");
        pw.print(right);
        pw.print(',');
        pw.print(bottom);
        pw.print(']');
        addTaint(pw.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.947 -0400", hash_original_method = "D667CC92208C0C47552A2E0207FE57FF", hash_generated_method = "B52F61BC31A4051BE15CE6C4B9245CCF")
    public final boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_285299985 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_285299985;
        // ---------- Original Method ----------
        //return left >= right || top >= bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.948 -0400", hash_original_method = "B5C8F76194FE5E52EC67584A55326566", hash_generated_method = "29F8D1CF9C7F4265798772D6D6F6F8B9")
    public final int width() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599231946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599231946;
        // ---------- Original Method ----------
        //return right - left;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.948 -0400", hash_original_method = "D9A224C01D56297419D0F0D6874F94EA", hash_generated_method = "686CF1F4B779A9153AA96176A7FC79B4")
    public final int height() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175419929 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175419929;
        // ---------- Original Method ----------
        //return bottom - top;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.950 -0400", hash_original_method = "4477F17CB09FCCCFE520309EAF855087", hash_generated_method = "33F26D43C7A4C37A054561202CFE93B0")
    public final int centerX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776619354 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776619354;
        // ---------- Original Method ----------
        //return (left + right) >> 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.960 -0400", hash_original_method = "F7808A0BCBFDE1BA24C3C6993963C7E5", hash_generated_method = "0612EA5AED8FE4F4B6221C9BEDA7DC9C")
    public final int centerY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_527451905 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_527451905;
        // ---------- Original Method ----------
        //return (top + bottom) >> 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.960 -0400", hash_original_method = "5A810E92794653D48F616BBA8E2AA992", hash_generated_method = "2F0336836CF265C75E832649B7384286")
    public final float exactCenterX() {
        float var546ADE640B6EDFBC8A086EF31347E768_1310933600 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1310933600;
        // ---------- Original Method ----------
        //return (left + right) * 0.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.962 -0400", hash_original_method = "E508041D41FDDDFC9E9DB1768DECEB0F", hash_generated_method = "6E182CDA8B00D166EAE69ED13A710379")
    public final float exactCenterY() {
        float var546ADE640B6EDFBC8A086EF31347E768_2007409914 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2007409914;
        // ---------- Original Method ----------
        //return (top + bottom) * 0.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.988 -0400", hash_original_method = "86DA251BA391C7524C2010551ABD907E", hash_generated_method = "A534843FC0914524CAF333DFA3D47813")
    public void setEmpty() {
        left = right = top = bottom = 0;
        // ---------- Original Method ----------
        //left = right = top = bottom = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.989 -0400", hash_original_method = "8A4FF15661083ACC473F83074A89D6F5", hash_generated_method = "B63489F6650F99BD0728CD3CDF29B804")
    public void set(int left, int top, int right, int bottom) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.990 -0400", hash_original_method = "91C11C9F320DC60DE37EBB0C50768E5F", hash_generated_method = "45CCA2CE8624F5E69CCAB95C4EAC18C1")
    public void set(Rect src) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.994 -0400", hash_original_method = "5356F6810442AA542632B0339DB7C305", hash_generated_method = "85B76985DADCB0A7983590638C87AF89")
    public void offset(int dx, int dy) {
        left += dx;
        top += dy;
        right += dx;
        bottom += dy;
        // ---------- Original Method ----------
        //left += dx;
        //top += dy;
        //right += dx;
        //bottom += dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.001 -0400", hash_original_method = "8125F9BA37E5C002EA31C052E4601FA7", hash_generated_method = "11F610A3D4AAB96200B2606CD0B389C6")
    public void offsetTo(int newLeft, int newTop) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.018 -0400", hash_original_method = "17525FCBE008AE0BAFD476B05D2391E6", hash_generated_method = "E9D59EB893ED213C1E58369A5D9B2ED1")
    public void inset(int dx, int dy) {
        left += dx;
        top += dy;
        right -= dx;
        bottom -= dy;
        // ---------- Original Method ----------
        //left += dx;
        //top += dy;
        //right -= dx;
        //bottom -= dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.019 -0400", hash_original_method = "FB3474DF9F8E4515A45B7C6979EE4374", hash_generated_method = "946583C8E45EB65E8F789FAC8C98CB02")
    public boolean contains(int x, int y) {
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1232329861 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1232329861;
        // ---------- Original Method ----------
        //return left < right && top < bottom  
               //&& x >= left && x < right && y >= top && y < bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.020 -0400", hash_original_method = "8D2675A9B64D6291A491AF0B37B18FE8", hash_generated_method = "48F56D9311D067E6416602969844B4E2")
    public boolean contains(int left, int top, int right, int bottom) {
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_343728703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_343728703;
        // ---------- Original Method ----------
        //return this.left < this.right && this.top < this.bottom
                //&& this.left <= left && this.top <= top
                //&& this.right >= right && this.bottom >= bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.022 -0400", hash_original_method = "126108FF3C2D2BC5CF3ED1DC63A4E5F7", hash_generated_method = "834308A89D8371E74849450430486628")
    public boolean contains(Rect r) {
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1634373816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1634373816;
        // ---------- Original Method ----------
        //return this.left < this.right && this.top < this.bottom
               //&& left <= r.left && top <= r.top
               //&& right >= r.right && bottom >= r.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.030 -0400", hash_original_method = "658EB75DC95440C8FB1EDDAF8D29E614", hash_generated_method = "2BCA0088A76EAC29876A2B6EFF35A3F3")
    public boolean intersect(int left, int top, int right, int bottom) {
        {
            {
                this.left = left;
            } //End block
            {
                this.top = top;
            } //End block
            {
                this.right = right;
            } //End block
            {
                this.bottom = bottom;
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1239459575 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1239459575;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.032 -0400", hash_original_method = "4A2C98A9983AAAE4538683164E4E11F1", hash_generated_method = "6E667EB0C151083363C7EE47E8034743")
    public boolean intersect(Rect r) {
        boolean var774B7820222CF99C9D397FA2889989AA_1171718980 = (intersect(r.left, r.top, r.right, r.bottom));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1329941717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1329941717;
        // ---------- Original Method ----------
        //return intersect(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.052 -0400", hash_original_method = "6CBE4827BB85E1688F906F31CBC110B1", hash_generated_method = "374986233D973CBCABCE091F030D7C5A")
    public boolean setIntersect(Rect a, Rect b) {
        {
            left = Math.max(a.left, b.left);
            top = Math.max(a.top, b.top);
            right = Math.min(a.right, b.right);
            bottom = Math.min(a.bottom, b.bottom);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_954199768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_954199768;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.053 -0400", hash_original_method = "27E106C10E914B3FBF244200C2037DFC", hash_generated_method = "6CC588C147D2B8B51FAB17F607E063DE")
    public boolean intersects(int left, int top, int right, int bottom) {
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1402107258 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1402107258;
        // ---------- Original Method ----------
        //return this.left < right && left < this.right
               //&& this.top < bottom && top < this.bottom;
    }

    
        public static boolean intersects(Rect a, Rect b) {
        return a.left < b.right && b.left < a.right
               && a.top < b.bottom && b.top < a.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.070 -0400", hash_original_method = "7C2B05BF5AFBBC7EA864CF62C0597A8B", hash_generated_method = "487D42E7934C7ED1627AB5B6A0DC958D")
    public void union(int left, int top, int right, int bottom) {
        {
            {
                this.left = left;
                this.top = top;
                this.right = right;
                this.bottom = bottom;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.072 -0400", hash_original_method = "02BA37E056209ADFED6D0D921E351CDC", hash_generated_method = "ECB7B858A50A86AEF3334B3288AED8D3")
    public void union(Rect r) {
        union(r.left, r.top, r.right, r.bottom);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //union(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.073 -0400", hash_original_method = "D9CAB332D4713CB79486AC2C819BD66A", hash_generated_method = "9656ABB612559B27BB41E081BEE83314")
    public void union(int x, int y) {
        {
            left = x;
        } //End block
        {
            right = x;
        } //End block
        {
            top = y;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.085 -0400", hash_original_method = "B19A72EC4CF8FCC2B6266E5066EB04CB", hash_generated_method = "32ACB3F194E811B0D00CF9A07606D7C6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.094 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "EE31D2F156B6F576FD2AB05DCD38AFE5")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168529414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168529414;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.102 -0400", hash_original_method = "548726568B563CCA3AC6BF577DA5CC4D", hash_generated_method = "82240D1638C8FC56ED67E24C00ABD8FF")
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(left);
        out.writeInt(top);
        out.writeInt(right);
        out.writeInt(bottom);
        addTaint(out.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //out.writeInt(left);
        //out.writeInt(top);
        //out.writeInt(right);
        //out.writeInt(bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.122 -0400", hash_original_method = "979823E39D5729D9D6A2DACBA85F6F6A", hash_generated_method = "42E1DA753B84F90CC42FB2F09788EE27")
    public void readFromParcel(Parcel in) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.134 -0400", hash_original_method = "D8CF57D437DDADABC72AE60A50BB50F2", hash_generated_method = "331F5C6D8E9D078E441F31A1BEFF3C30")
    public void scale(float scale) {
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.134 -0400", hash_original_field = "CE31B6E0DE512E03F6C313313D82D7EC", hash_generated_field = "9791A1E5B95A9620CFD32EAEC99CD44A")

    private static Pattern FLATTENED_PATTERN = Pattern.compile(
            "(-?\\d+) (-?\\d+) (-?\\d+) (-?\\d+)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.134 -0400", hash_original_field = "5ACE306FE3CEE5B37C1F91FBA8A509E2", hash_generated_field = "DAC7FA6B311812DA10DF2B09DF991282")

    public static final Parcelable.Creator<Rect> CREATOR = new Parcelable.Creator<Rect>() {
        
        public Rect createFromParcel(Parcel in) {
            Rect r = new Rect();
            r.readFromParcel(in);
            return r;
        }

        
        public Rect[] newArray(int size) {
            return new Rect[size];
        }
    };
}

