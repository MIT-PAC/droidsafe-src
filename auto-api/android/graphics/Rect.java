package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Rect implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.214 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "1DC0B64660F00182FB9FBCCB50A51F92")

    public int left;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.214 -0400", hash_original_field = "B28354B543375BFA94DABAEDA722927F", hash_generated_field = "4FB04C904AA02F82B407995BA570583C")

    public int top;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.214 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "8D8E5E7DA2C11F273C631EF06D16F776")

    public int right;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.214 -0400", hash_original_field = "71F262D796BED1AB30E8A2D5A8DDEE6F", hash_generated_field = "F7035266BD2A20B12FE551C6FAE7D704")

    public int bottom;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.214 -0400", hash_original_method = "2824AA033EB3CD5BF749E2296CB51BE8", hash_generated_method = "88CB725E6D9F946318418A9C095367E7")
    public  Rect() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.215 -0400", hash_original_method = "3DCA7066BD91457D0361C44914AFE94B", hash_generated_method = "9D93B8D0B8A2381D4373463BE736CBD3")
    public  Rect(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.215 -0400", hash_original_method = "824BA1C9E4DCE37E2C6E0AB82C317278", hash_generated_method = "FEFC0E392B8902310E80F76AC868DB50")
    public  Rect(Rect r) {
        left = r.left;
        top = r.top;
        right = r.right;
        bottom = r.bottom;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.216 -0400", hash_original_method = "AE4801E4151B09AB4E729E9F7DAAD949", hash_generated_method = "6645AEBED96ED367D243CD4827FAD25F")
    @Override
    public boolean equals(Object obj) {
        Rect r = (Rect) obj;
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_973804634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_973804634;
        
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.217 -0400", hash_original_method = "377E4026C49F3CEBA3B751597A4FD5E1", hash_generated_method = "DAA1E35FA334FFDD7B269BE3C84D16D8")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1831245587 = null; 
        StringBuilder sb = new StringBuilder(32);
        sb.append("Rect(");
        sb.append(left);
        sb.append(", ");
        sb.append(top);
        sb.append(" - ");
        sb.append(right);
        sb.append(", ");
        sb.append(bottom);
        sb.append(")");
        varB4EAC82CA7396A68D541C85D26508E83_1831245587 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1831245587.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1831245587;
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.218 -0400", hash_original_method = "1840D8CED4FEDA16C265C984A5256101", hash_generated_method = "A5639F0FC9271A6C2A9A75AD53104D45")
    public String toShortString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1834568635 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1834568635 = toShortString(new StringBuilder(32));
        varB4EAC82CA7396A68D541C85D26508E83_1834568635.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1834568635;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.220 -0400", hash_original_method = "2BF61B85E091A9DA2C18EB7FC26222B9", hash_generated_method = "8178C000BB4EBD196B1F933026D7121D")
    public String toShortString(StringBuilder sb) {
        String varB4EAC82CA7396A68D541C85D26508E83_1507649746 = null; 
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
        varB4EAC82CA7396A68D541C85D26508E83_1507649746 = sb.toString();
        addTaint(sb.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1507649746.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1507649746;
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.221 -0400", hash_original_method = "EE149DE53983156EB3F726A589D5EF54", hash_generated_method = "8F3D4C02C1D1CEE61C81D7E6AFD09242")
    public String flattenToString() {
        String varB4EAC82CA7396A68D541C85D26508E83_800540125 = null; 
        StringBuilder sb = new StringBuilder(32);
        sb.append(left);
        sb.append(' ');
        sb.append(top);
        sb.append(' ');
        sb.append(right);
        sb.append(' ');
        sb.append(bottom);
        varB4EAC82CA7396A68D541C85D26508E83_800540125 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_800540125.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_800540125;
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.222 -0400", hash_original_method = "78960F3D6EA700D282D0F0C0E94AA84C", hash_generated_method = "7CC9973023E2CD924438EDC646D73B58")
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
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.222 -0400", hash_original_method = "D667CC92208C0C47552A2E0207FE57FF", hash_generated_method = "D35A31182FF4F8420D9258C26297876C")
    public final boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_861181097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_861181097;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.222 -0400", hash_original_method = "B5C8F76194FE5E52EC67584A55326566", hash_generated_method = "AEE50BA75E3159D77BBC65E68994EA21")
    public final int width() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1449285283 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1449285283;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.223 -0400", hash_original_method = "D9A224C01D56297419D0F0D6874F94EA", hash_generated_method = "E5BD4BBDD58DC63A30D970F8217718CD")
    public final int height() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594172634 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594172634;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.223 -0400", hash_original_method = "4477F17CB09FCCCFE520309EAF855087", hash_generated_method = "83B947080F39CEE081303BE2A11F107E")
    public final int centerX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1670970705 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1670970705;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.224 -0400", hash_original_method = "F7808A0BCBFDE1BA24C3C6993963C7E5", hash_generated_method = "FF1025A6B368A5A8203ACB717BD63460")
    public final int centerY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603856803 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603856803;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.224 -0400", hash_original_method = "5A810E92794653D48F616BBA8E2AA992", hash_generated_method = "CE385DB38710204853D4DEFBB18590B5")
    public final float exactCenterX() {
        float var546ADE640B6EDFBC8A086EF31347E768_389978203 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_389978203;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.224 -0400", hash_original_method = "E508041D41FDDDFC9E9DB1768DECEB0F", hash_generated_method = "B361B2F56A20CD90025B6D61D1CF8D6F")
    public final float exactCenterY() {
        float var546ADE640B6EDFBC8A086EF31347E768_1969199690 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1969199690;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.225 -0400", hash_original_method = "86DA251BA391C7524C2010551ABD907E", hash_generated_method = "A534843FC0914524CAF333DFA3D47813")
    public void setEmpty() {
        left = right = top = bottom = 0;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.225 -0400", hash_original_method = "8A4FF15661083ACC473F83074A89D6F5", hash_generated_method = "B63489F6650F99BD0728CD3CDF29B804")
    public void set(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.226 -0400", hash_original_method = "91C11C9F320DC60DE37EBB0C50768E5F", hash_generated_method = "45CCA2CE8624F5E69CCAB95C4EAC18C1")
    public void set(Rect src) {
        this.left = src.left;
        this.top = src.top;
        this.right = src.right;
        this.bottom = src.bottom;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.226 -0400", hash_original_method = "5356F6810442AA542632B0339DB7C305", hash_generated_method = "85B76985DADCB0A7983590638C87AF89")
    public void offset(int dx, int dy) {
        left += dx;
        top += dy;
        right += dx;
        bottom += dy;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.227 -0400", hash_original_method = "8125F9BA37E5C002EA31C052E4601FA7", hash_generated_method = "11F610A3D4AAB96200B2606CD0B389C6")
    public void offsetTo(int newLeft, int newTop) {
        right += newLeft - left;
        bottom += newTop - top;
        left = newLeft;
        top = newTop;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.228 -0400", hash_original_method = "17525FCBE008AE0BAFD476B05D2391E6", hash_generated_method = "E9D59EB893ED213C1E58369A5D9B2ED1")
    public void inset(int dx, int dy) {
        left += dx;
        top += dy;
        right -= dx;
        bottom -= dy;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.230 -0400", hash_original_method = "FB3474DF9F8E4515A45B7C6979EE4374", hash_generated_method = "40A098CB9DC4BC9E8B5DEF4EE7237278")
    public boolean contains(int x, int y) {
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1671418528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1671418528;
        
        
               
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.231 -0400", hash_original_method = "8D2675A9B64D6291A491AF0B37B18FE8", hash_generated_method = "6D8CBAEEF58BB5CAEDC0FECADB102B4A")
    public boolean contains(int left, int top, int right, int bottom) {
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_193418260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_193418260;
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.231 -0400", hash_original_method = "126108FF3C2D2BC5CF3ED1DC63A4E5F7", hash_generated_method = "23649B50FC2990D00732CD209878AC24")
    public boolean contains(Rect r) {
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_285620795 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_285620795;
        
        
               
               
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.232 -0400", hash_original_method = "658EB75DC95440C8FB1EDDAF8D29E614", hash_generated_method = "22D24FE95442028B4AC5FB3585D01B45")
    public boolean intersect(int left, int top, int right, int bottom) {
        {
            {
                this.left = left;
            } 
            {
                this.top = top;
            } 
            {
                this.right = right;
            } 
            {
                this.bottom = bottom;
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1983467842 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1983467842;
        
        
                
            
                
            
            
                
            
            
                
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.233 -0400", hash_original_method = "4A2C98A9983AAAE4538683164E4E11F1", hash_generated_method = "2B516DFDB035C5ECEB01B65711B35437")
    public boolean intersect(Rect r) {
        boolean var774B7820222CF99C9D397FA2889989AA_1965459201 = (intersect(r.left, r.top, r.right, r.bottom));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1680477639 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1680477639;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.233 -0400", hash_original_method = "6CBE4827BB85E1688F906F31CBC110B1", hash_generated_method = "A6476C9198C00E8D19C81C77CF6EDC0E")
    public boolean setIntersect(Rect a, Rect b) {
        {
            left = Math.max(a.left, b.left);
            top = Math.max(a.top, b.top);
            right = Math.min(a.right, b.right);
            bottom = Math.min(a.bottom, b.bottom);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2034775749 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2034775749;
        
        
                
            
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.234 -0400", hash_original_method = "27E106C10E914B3FBF244200C2037DFC", hash_generated_method = "9A654ACC2A62F056498B9A1608A3DCFE")
    public boolean intersects(int left, int top, int right, int bottom) {
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_932478908 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_932478908;
        
        
               
    }

    
    public static boolean intersects(Rect a, Rect b) {
        return a.left < b.right && b.left < a.right
               && a.top < b.bottom && b.top < a.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.235 -0400", hash_original_method = "7C2B05BF5AFBBC7EA864CF62C0597A8B", hash_generated_method = "487D42E7934C7ED1627AB5B6A0DC958D")
    public void union(int left, int top, int right, int bottom) {
        {
            {
                this.left = left;
                this.top = top;
                this.right = right;
                this.bottom = bottom;
            } 
            {
                this.left = left;
                this.top = top;
                this.right = right;
                this.bottom = bottom;
            } 
        } 
        
        
            
                
                    
                
                    
                
                    
                
                    
            
                
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.236 -0400", hash_original_method = "02BA37E056209ADFED6D0D921E351CDC", hash_generated_method = "ECB7B858A50A86AEF3334B3288AED8D3")
    public void union(Rect r) {
        union(r.left, r.top, r.right, r.bottom);
        addTaint(r.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.236 -0400", hash_original_method = "D9CAB332D4713CB79486AC2C819BD66A", hash_generated_method = "9656ABB612559B27BB41E081BEE83314")
    public void union(int x, int y) {
        {
            left = x;
        } 
        {
            right = x;
        } 
        {
            top = y;
        } 
        {
            bottom = y;
        } 
        
        
            
        
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.237 -0400", hash_original_method = "B19A72EC4CF8FCC2B6266E5066EB04CB", hash_generated_method = "9330732E3C1FC9E97F04A1F64099E090")
    public void sort() {
        {
            int temp = left;
            left = right;
            right = temp;
        } 
        {
            int temp = top;
            top = bottom;
            bottom = temp;
        } 
        
        
            
            
            
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.238 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E637B31C2D22839C8DDB11144F469ECE")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962081949 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962081949;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.239 -0400", hash_original_method = "548726568B563CCA3AC6BF577DA5CC4D", hash_generated_method = "82240D1638C8FC56ED67E24C00ABD8FF")
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(left);
        out.writeInt(top);
        out.writeInt(right);
        out.writeInt(bottom);
        addTaint(out.getTaint());
        addTaint(flags);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.240 -0400", hash_original_method = "979823E39D5729D9D6A2DACBA85F6F6A", hash_generated_method = "42E1DA753B84F90CC42FB2F09788EE27")
    public void readFromParcel(Parcel in) {
        left = in.readInt();
        top = in.readInt();
        right = in.readInt();
        bottom = in.readInt();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.241 -0400", hash_original_method = "D8CF57D437DDADABC72AE60A50BB50F2", hash_generated_method = "331F5C6D8E9D078E441F31A1BEFF3C30")
    public void scale(float scale) {
        {
            left = (int) (left * scale + 0.5f);
            top = (int) (top * scale + 0.5f);
            right = (int) (right * scale + 0.5f);
            bottom = (int) (bottom * scale + 0.5f);
        } 
        
        
            
            
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.242 -0400", hash_original_field = "CE31B6E0DE512E03F6C313313D82D7EC", hash_generated_field = "22CBDD4FA5AC4D71EB10C39DCFB71CD2")

    private static final Pattern FLATTENED_PATTERN = Pattern.compile(
            "(-?\\d+) (-?\\d+) (-?\\d+) (-?\\d+)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.242 -0400", hash_original_field = "5ACE306FE3CEE5B37C1F91FBA8A509E2", hash_generated_field = "DAC7FA6B311812DA10DF2B09DF991282")

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
    
    public Rect createFromParcel(Parcel in) {
            Rect r = new Rect();
            r.readFromParcel(in);
            return r;
        }
    
    
    public Rect[] newArray(int size) {
            return new Rect[size];
        }
    
}

