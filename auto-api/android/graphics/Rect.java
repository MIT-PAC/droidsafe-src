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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.288 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "1DC0B64660F00182FB9FBCCB50A51F92")

    public int left;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.288 -0400", hash_original_field = "B28354B543375BFA94DABAEDA722927F", hash_generated_field = "4FB04C904AA02F82B407995BA570583C")

    public int top;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.289 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "8D8E5E7DA2C11F273C631EF06D16F776")

    public int right;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.289 -0400", hash_original_field = "71F262D796BED1AB30E8A2D5A8DDEE6F", hash_generated_field = "F7035266BD2A20B12FE551C6FAE7D704")

    public int bottom;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.289 -0400", hash_original_method = "2824AA033EB3CD5BF749E2296CB51BE8", hash_generated_method = "88CB725E6D9F946318418A9C095367E7")
    public  Rect() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.303 -0400", hash_original_method = "3DCA7066BD91457D0361C44914AFE94B", hash_generated_method = "9D93B8D0B8A2381D4373463BE736CBD3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.305 -0400", hash_original_method = "824BA1C9E4DCE37E2C6E0AB82C317278", hash_generated_method = "FEFC0E392B8902310E80F76AC868DB50")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.308 -0400", hash_original_method = "AE4801E4151B09AB4E729E9F7DAAD949", hash_generated_method = "125F74CC97F474614E1AE72307A0E534")
    @Override
    public boolean equals(Object obj) {
        Rect r;
        r = (Rect) obj;
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2135312725 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2135312725;
        // ---------- Original Method ----------
        //Rect r = (Rect) obj;
        //if (r != null) {
            //return left == r.left && top == r.top && right == r.right
                    //&& bottom == r.bottom;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.316 -0400", hash_original_method = "377E4026C49F3CEBA3B751597A4FD5E1", hash_generated_method = "CED481779DF487A9128D5082B3B696B0")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_540416410 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_540416410 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_540416410.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_540416410;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.333 -0400", hash_original_method = "1840D8CED4FEDA16C265C984A5256101", hash_generated_method = "70F1F3F700C5F3A17CD1A1EE18297E2B")
    public String toShortString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1500513235 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1500513235 = toShortString(new StringBuilder(32));
        varB4EAC82CA7396A68D541C85D26508E83_1500513235.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1500513235;
        // ---------- Original Method ----------
        //return toShortString(new StringBuilder(32));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.334 -0400", hash_original_method = "2BF61B85E091A9DA2C18EB7FC26222B9", hash_generated_method = "DA5552C08CA5F920DB3790E09558353D")
    public String toShortString(StringBuilder sb) {
        String varB4EAC82CA7396A68D541C85D26508E83_868090908 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_868090908 = sb.toString();
        addTaint(sb.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_868090908.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_868090908;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.352 -0400", hash_original_method = "EE149DE53983156EB3F726A589D5EF54", hash_generated_method = "E5F3BB3F472229130BB45804BF6E7A5A")
    public String flattenToString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1965144983 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(32);
        sb.append(left);
        sb.append(' ');
        sb.append(top);
        sb.append(' ');
        sb.append(right);
        sb.append(' ');
        sb.append(bottom);
        varB4EAC82CA7396A68D541C85D26508E83_1965144983 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1965144983.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1965144983;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.354 -0400", hash_original_method = "78960F3D6EA700D282D0F0C0E94AA84C", hash_generated_method = "7CC9973023E2CD924438EDC646D73B58")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.357 -0400", hash_original_method = "D667CC92208C0C47552A2E0207FE57FF", hash_generated_method = "25C867247766A571FF35F8BD6412930B")
    public final boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_380993206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_380993206;
        // ---------- Original Method ----------
        //return left >= right || top >= bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.370 -0400", hash_original_method = "B5C8F76194FE5E52EC67584A55326566", hash_generated_method = "9AD14846098CB5BD746E59A1E88C9CD3")
    public final int width() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649135004 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649135004;
        // ---------- Original Method ----------
        //return right - left;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.372 -0400", hash_original_method = "D9A224C01D56297419D0F0D6874F94EA", hash_generated_method = "3042F7E09E142903001A9A5936A9E5F1")
    public final int height() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148554992 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148554992;
        // ---------- Original Method ----------
        //return bottom - top;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.372 -0400", hash_original_method = "4477F17CB09FCCCFE520309EAF855087", hash_generated_method = "87028A8AE568347C72D2010D3EDCCC86")
    public final int centerX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442741249 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442741249;
        // ---------- Original Method ----------
        //return (left + right) >> 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.373 -0400", hash_original_method = "F7808A0BCBFDE1BA24C3C6993963C7E5", hash_generated_method = "DE520E2D953FDCECF5F456EEDC8E900A")
    public final int centerY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544739173 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544739173;
        // ---------- Original Method ----------
        //return (top + bottom) >> 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.374 -0400", hash_original_method = "5A810E92794653D48F616BBA8E2AA992", hash_generated_method = "D07C1315935A7D317D9238BF762A3A41")
    public final float exactCenterX() {
        float var546ADE640B6EDFBC8A086EF31347E768_1526194457 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1526194457;
        // ---------- Original Method ----------
        //return (left + right) * 0.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.374 -0400", hash_original_method = "E508041D41FDDDFC9E9DB1768DECEB0F", hash_generated_method = "5ACD5CDA59F88687EA19F159CD8B2A30")
    public final float exactCenterY() {
        float var546ADE640B6EDFBC8A086EF31347E768_1793996645 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1793996645;
        // ---------- Original Method ----------
        //return (top + bottom) * 0.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.393 -0400", hash_original_method = "86DA251BA391C7524C2010551ABD907E", hash_generated_method = "A534843FC0914524CAF333DFA3D47813")
    public void setEmpty() {
        left = right = top = bottom = 0;
        // ---------- Original Method ----------
        //left = right = top = bottom = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.394 -0400", hash_original_method = "8A4FF15661083ACC473F83074A89D6F5", hash_generated_method = "B63489F6650F99BD0728CD3CDF29B804")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.402 -0400", hash_original_method = "91C11C9F320DC60DE37EBB0C50768E5F", hash_generated_method = "45CCA2CE8624F5E69CCAB95C4EAC18C1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.420 -0400", hash_original_method = "5356F6810442AA542632B0339DB7C305", hash_generated_method = "85B76985DADCB0A7983590638C87AF89")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.421 -0400", hash_original_method = "8125F9BA37E5C002EA31C052E4601FA7", hash_generated_method = "11F610A3D4AAB96200B2606CD0B389C6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.422 -0400", hash_original_method = "17525FCBE008AE0BAFD476B05D2391E6", hash_generated_method = "E9D59EB893ED213C1E58369A5D9B2ED1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.437 -0400", hash_original_method = "FB3474DF9F8E4515A45B7C6979EE4374", hash_generated_method = "8A46700DA56D6F4FC1868B0BCC04B9EF")
    public boolean contains(int x, int y) {
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2010877096 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2010877096;
        // ---------- Original Method ----------
        //return left < right && top < bottom  
               //&& x >= left && x < right && y >= top && y < bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.438 -0400", hash_original_method = "8D2675A9B64D6291A491AF0B37B18FE8", hash_generated_method = "E4D9B3995ADB3E42D7ABC20766BCD0BE")
    public boolean contains(int left, int top, int right, int bottom) {
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_352941539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_352941539;
        // ---------- Original Method ----------
        //return this.left < this.right && this.top < this.bottom
                //&& this.left <= left && this.top <= top
                //&& this.right >= right && this.bottom >= bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.438 -0400", hash_original_method = "126108FF3C2D2BC5CF3ED1DC63A4E5F7", hash_generated_method = "735F6FFB4EBEFD80EADB9008033427A6")
    public boolean contains(Rect r) {
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1376073406 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1376073406;
        // ---------- Original Method ----------
        //return this.left < this.right && this.top < this.bottom
               //&& left <= r.left && top <= r.top
               //&& right >= r.right && bottom >= r.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.440 -0400", hash_original_method = "658EB75DC95440C8FB1EDDAF8D29E614", hash_generated_method = "6C44372AC056D108A4C08085827B38DA")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1357115412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1357115412;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.441 -0400", hash_original_method = "4A2C98A9983AAAE4538683164E4E11F1", hash_generated_method = "D49A86799DE7D3D1A9430E8A77AB7CAF")
    public boolean intersect(Rect r) {
        boolean var774B7820222CF99C9D397FA2889989AA_1417001389 = (intersect(r.left, r.top, r.right, r.bottom));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_291522792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_291522792;
        // ---------- Original Method ----------
        //return intersect(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.464 -0400", hash_original_method = "6CBE4827BB85E1688F906F31CBC110B1", hash_generated_method = "7FDE00F55FB80C4DABE1E0A5AD1C17C6")
    public boolean setIntersect(Rect a, Rect b) {
        {
            left = Math.max(a.left, b.left);
            top = Math.max(a.top, b.top);
            right = Math.min(a.right, b.right);
            bottom = Math.min(a.bottom, b.bottom);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1757959271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1757959271;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.465 -0400", hash_original_method = "27E106C10E914B3FBF244200C2037DFC", hash_generated_method = "CBE502DBACA7162496D9D40AC249CEA3")
    public boolean intersects(int left, int top, int right, int bottom) {
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_223811047 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_223811047;
        // ---------- Original Method ----------
        //return this.left < right && left < this.right
               //&& this.top < bottom && top < this.bottom;
    }

    
        public static boolean intersects(Rect a, Rect b) {
        return a.left < b.right && b.left < a.right
               && a.top < b.bottom && b.top < a.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.482 -0400", hash_original_method = "7C2B05BF5AFBBC7EA864CF62C0597A8B", hash_generated_method = "487D42E7934C7ED1627AB5B6A0DC958D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.483 -0400", hash_original_method = "02BA37E056209ADFED6D0D921E351CDC", hash_generated_method = "ECB7B858A50A86AEF3334B3288AED8D3")
    public void union(Rect r) {
        union(r.left, r.top, r.right, r.bottom);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //union(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.499 -0400", hash_original_method = "D9CAB332D4713CB79486AC2C819BD66A", hash_generated_method = "9656ABB612559B27BB41E081BEE83314")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.500 -0400", hash_original_method = "B19A72EC4CF8FCC2B6266E5066EB04CB", hash_generated_method = "32ACB3F194E811B0D00CF9A07606D7C6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.501 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "43FAE3F9946CF46226529925317B6290")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_562968414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_562968414;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.515 -0400", hash_original_method = "548726568B563CCA3AC6BF577DA5CC4D", hash_generated_method = "82240D1638C8FC56ED67E24C00ABD8FF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.518 -0400", hash_original_method = "979823E39D5729D9D6A2DACBA85F6F6A", hash_generated_method = "42E1DA753B84F90CC42FB2F09788EE27")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.529 -0400", hash_original_method = "D8CF57D437DDADABC72AE60A50BB50F2", hash_generated_method = "331F5C6D8E9D078E441F31A1BEFF3C30")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.529 -0400", hash_original_field = "CE31B6E0DE512E03F6C313313D82D7EC", hash_generated_field = "9791A1E5B95A9620CFD32EAEC99CD44A")

    private static Pattern FLATTENED_PATTERN = Pattern.compile(
            "(-?\\d+) (-?\\d+) (-?\\d+) (-?\\d+)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.529 -0400", hash_original_field = "5ACE306FE3CEE5B37C1F91FBA8A509E2", hash_generated_field = "DAC7FA6B311812DA10DF2B09DF991282")

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

