package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Rect implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.021 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "1DC0B64660F00182FB9FBCCB50A51F92")

    public int left;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.021 -0400", hash_original_field = "B28354B543375BFA94DABAEDA722927F", hash_generated_field = "4FB04C904AA02F82B407995BA570583C")

    public int top;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.021 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "8D8E5E7DA2C11F273C631EF06D16F776")

    public int right;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.021 -0400", hash_original_field = "71F262D796BED1AB30E8A2D5A8DDEE6F", hash_generated_field = "F7035266BD2A20B12FE551C6FAE7D704")

    public int bottom;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.022 -0400", hash_original_method = "2824AA033EB3CD5BF749E2296CB51BE8", hash_generated_method = "88CB725E6D9F946318418A9C095367E7")
    public  Rect() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.023 -0400", hash_original_method = "3DCA7066BD91457D0361C44914AFE94B", hash_generated_method = "9D93B8D0B8A2381D4373463BE736CBD3")
    public  Rect(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.023 -0400", hash_original_method = "824BA1C9E4DCE37E2C6E0AB82C317278", hash_generated_method = "FEFC0E392B8902310E80F76AC868DB50")
    public  Rect(Rect r) {
        left = r.left;
        top = r.top;
        right = r.right;
        bottom = r.bottom;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.024 -0400", hash_original_method = "AE4801E4151B09AB4E729E9F7DAAD949", hash_generated_method = "14DD75B1516E21C4068E096F1EC11BCB")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        Rect r = (Rect) obj;
    if(r != null)        
        {
            boolean var56026D6F96CED8A609181B6E43D0A120_139993192 = (left == r.left && top == r.top && right == r.right
                    && bottom == r.bottom);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1528003112 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1528003112;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1401304129 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_409671427 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_409671427;
        
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.025 -0400", hash_original_method = "377E4026C49F3CEBA3B751597A4FD5E1", hash_generated_method = "F94C104A7BC43363DE1A3D42F823FCCA")
    @Override
    public String toString() {
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
String var2460B846747F8B22185AD8BE722266A5_446459202 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_446459202.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_446459202;
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.025 -0400", hash_original_method = "1840D8CED4FEDA16C265C984A5256101", hash_generated_method = "0068228383BE7AA244A89B12CE7AF92D")
    public String toShortString() {
String varA3000DD8750FB67E255CCEC66005522D_1717115526 =         toShortString(new StringBuilder(32));
        varA3000DD8750FB67E255CCEC66005522D_1717115526.addTaint(taint);
        return varA3000DD8750FB67E255CCEC66005522D_1717115526;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.026 -0400", hash_original_method = "2BF61B85E091A9DA2C18EB7FC26222B9", hash_generated_method = "FC13CD48EDC8CFC9296FB28E20B51A4A")
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
String var2460B846747F8B22185AD8BE722266A5_36800412 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_36800412.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_36800412;
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.026 -0400", hash_original_method = "EE149DE53983156EB3F726A589D5EF54", hash_generated_method = "CE25B5FBCD741EBC928BE3D796A2A94E")
    public String flattenToString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(left);
        sb.append(' ');
        sb.append(top);
        sb.append(' ');
        sb.append(right);
        sb.append(' ');
        sb.append(bottom);
String var2460B846747F8B22185AD8BE722266A5_1328392713 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1328392713.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1328392713;
        
        
        
        
        
        
        
        
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.027 -0400", hash_original_method = "78960F3D6EA700D282D0F0C0E94AA84C", hash_generated_method = "972617801DE3330D088D24CF209054E4")
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
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.027 -0400", hash_original_method = "D667CC92208C0C47552A2E0207FE57FF", hash_generated_method = "E8ACC15DB877B1228DAF2237F5718638")
    public final boolean isEmpty() {
        boolean var5BA6ADEF85521CC0A2916760814FCF93_447970088 = (left >= right || top >= bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_109686048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_109686048;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.028 -0400", hash_original_method = "B5C8F76194FE5E52EC67584A55326566", hash_generated_method = "1F6CCA4E97A67E3492613EE5B28BC0F3")
    public final int width() {
        int var88F0E5CB3EAA647E9260CF3FB49CC290_1866196634 = (right - left);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183362525 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183362525;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.029 -0400", hash_original_method = "D9A224C01D56297419D0F0D6874F94EA", hash_generated_method = "0ED4CCD269437202C94C8148CD6DACC3")
    public final int height() {
        int varF8C4A5D78D17BACD13F5BFF4ECA44EC8_1705342154 = (bottom - top);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2119400926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2119400926;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.029 -0400", hash_original_method = "4477F17CB09FCCCFE520309EAF855087", hash_generated_method = "D08EA01FF7A13B5B19B94FBCB2C4EBEB")
    public final int centerX() {
        int var92EF6AEFD28AA0928BAE4C5CF0995515_1710319619 = ((left + right) >> 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_598316048 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_598316048;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.029 -0400", hash_original_method = "F7808A0BCBFDE1BA24C3C6993963C7E5", hash_generated_method = "C4300090CBA6E6C2C4F811668769953B")
    public final int centerY() {
        int varAF749E2D1EDAEE04450DC215F13A9316_152345323 = ((top + bottom) >> 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915307122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915307122;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.030 -0400", hash_original_method = "5A810E92794653D48F616BBA8E2AA992", hash_generated_method = "2AF8E6C262842E87E070C2970532C49F")
    public final float exactCenterX() {
        float varA4632249F58E4F4D11727DB1456053B9_742315840 = ((left + right) * 0.5f);
                float var546ADE640B6EDFBC8A086EF31347E768_1513579218 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1513579218;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.030 -0400", hash_original_method = "E508041D41FDDDFC9E9DB1768DECEB0F", hash_generated_method = "120E038E35EE2AE576053B4556CEE397")
    public final float exactCenterY() {
        float var3AE3C0970807829B301DA0A4EED9B2B7_2032061014 = ((top + bottom) * 0.5f);
                float var546ADE640B6EDFBC8A086EF31347E768_1093754108 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1093754108;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.030 -0400", hash_original_method = "86DA251BA391C7524C2010551ABD907E", hash_generated_method = "A534843FC0914524CAF333DFA3D47813")
    public void setEmpty() {
        left = right = top = bottom = 0;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.032 -0400", hash_original_method = "8A4FF15661083ACC473F83074A89D6F5", hash_generated_method = "B63489F6650F99BD0728CD3CDF29B804")
    public void set(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.032 -0400", hash_original_method = "91C11C9F320DC60DE37EBB0C50768E5F", hash_generated_method = "45CCA2CE8624F5E69CCAB95C4EAC18C1")
    public void set(Rect src) {
        this.left = src.left;
        this.top = src.top;
        this.right = src.right;
        this.bottom = src.bottom;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.033 -0400", hash_original_method = "5356F6810442AA542632B0339DB7C305", hash_generated_method = "85B76985DADCB0A7983590638C87AF89")
    public void offset(int dx, int dy) {
        left += dx;
        top += dy;
        right += dx;
        bottom += dy;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.036 -0400", hash_original_method = "8125F9BA37E5C002EA31C052E4601FA7", hash_generated_method = "11F610A3D4AAB96200B2606CD0B389C6")
    public void offsetTo(int newLeft, int newTop) {
        right += newLeft - left;
        bottom += newTop - top;
        left = newLeft;
        top = newTop;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.037 -0400", hash_original_method = "17525FCBE008AE0BAFD476B05D2391E6", hash_generated_method = "E9D59EB893ED213C1E58369A5D9B2ED1")
    public void inset(int dx, int dy) {
        left += dx;
        top += dy;
        right -= dx;
        bottom -= dy;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.038 -0400", hash_original_method = "FB3474DF9F8E4515A45B7C6979EE4374", hash_generated_method = "0B9428C38FEF975968081FB7C16DE15E")
    public boolean contains(int x, int y) {
        addTaint(y);
        addTaint(x);
        boolean var263E590DC04AFA9272B7E0CBDF24F78B_1531029405 = (left < right && top < bottom  
               && x >= left && x < right && y >= top && y < bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_86944144 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_86944144;
        
        
               
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.039 -0400", hash_original_method = "8D2675A9B64D6291A491AF0B37B18FE8", hash_generated_method = "BE292A75D66D29FB87C7BA6287E45387")
    public boolean contains(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean varC298003A5C7052F26D32FAD99EF49705_956502766 = (this.left < this.right && this.top < this.bottom
                && this.left <= left && this.top <= top
                && this.right >= right && this.bottom >= bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1360961567 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1360961567;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.040 -0400", hash_original_method = "126108FF3C2D2BC5CF3ED1DC63A4E5F7", hash_generated_method = "F212044D90F5626B15629D9A2491292D")
    public boolean contains(Rect r) {
        addTaint(r.getTaint());
        boolean varDAA05349841D3C3EE223DBF7A07E379C_1052200576 = (this.left < this.right && this.top < this.bottom
               && left <= r.left && top <= r.top
               && right >= r.right && bottom >= r.bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1585687838 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1585687838;
        
        
               
               
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.041 -0400", hash_original_method = "658EB75DC95440C8FB1EDDAF8D29E614", hash_generated_method = "832C1CE43C7622ABEA7B9DA813FE257A")
    public boolean intersect(int left, int top, int right, int bottom) {
    if(this.left < right && left < this.right
                && this.top < bottom && top < this.bottom)        
        {
    if(this.left < left)            
            {
                this.left = left;
            } 
    if(this.top < top)            
            {
                this.top = top;
            } 
    if(this.right > right)            
            {
                this.right = right;
            } 
    if(this.bottom > bottom)            
            {
                this.bottom = bottom;
            } 
            boolean varB326B5062B2F0E69046810717534CB09_227265236 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_480513888 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_480513888;
        } 
        boolean var68934A3E9455FA72420237EB05902327_950619125 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_805900022 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_805900022;
        
        
                
            
                
            
            
                
            
            
                
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.042 -0400", hash_original_method = "4A2C98A9983AAAE4538683164E4E11F1", hash_generated_method = "3C0CF156655DED2975D370C277D3F71D")
    public boolean intersect(Rect r) {
        addTaint(r.getTaint());
        boolean varBDDD5DA93332D9D54ACD4F6F853C3B70_732753077 = (intersect(r.left, r.top, r.right, r.bottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_911201916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_911201916;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.043 -0400", hash_original_method = "6CBE4827BB85E1688F906F31CBC110B1", hash_generated_method = "E9398950344BD749C8E17E3D4F0D11E1")
    public boolean setIntersect(Rect a, Rect b) {
    if(a.left < b.right && b.left < a.right
                && a.top < b.bottom && b.top < a.bottom)        
        {
            left = Math.max(a.left, b.left);
            top = Math.max(a.top, b.top);
            right = Math.min(a.right, b.right);
            bottom = Math.min(a.bottom, b.bottom);
            boolean varB326B5062B2F0E69046810717534CB09_949490222 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698965056 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_698965056;
        } 
        boolean var68934A3E9455FA72420237EB05902327_400193500 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1803266216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1803266216;
        
        
                
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.044 -0400", hash_original_method = "27E106C10E914B3FBF244200C2037DFC", hash_generated_method = "79AA0AAA0D59C753145681A6981B3E16")
    public boolean intersects(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean varC8E85023C3A9C04DF273BA31231F46E7_1852729764 = (this.left < right && left < this.right
               && this.top < bottom && top < this.bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1866505204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1866505204;
        
        
               
    }

    
        @DSModeled(DSC.SAFE)
    public static boolean intersects(Rect a, Rect b) {
        return a.left < b.right && b.left < a.right
               && a.top < b.bottom && b.top < a.bottom;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.047 -0400", hash_original_method = "7C2B05BF5AFBBC7EA864CF62C0597A8B", hash_generated_method = "04084DDDF59E041F2BEE0F95379AD3E6")
    public void union(int left, int top, int right, int bottom) {
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
            } 
            else
            {
                this.left = left;
                this.top = top;
                this.right = right;
                this.bottom = bottom;
            } 
        } 
        
        
            
                
                    
                
                    
                
                    
                
                    
            
                
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.048 -0400", hash_original_method = "02BA37E056209ADFED6D0D921E351CDC", hash_generated_method = "E8A668405EE03200B71731A73B90A194")
    public void union(Rect r) {
        addTaint(r.getTaint());
        union(r.left, r.top, r.right, r.bottom);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.050 -0400", hash_original_method = "D9CAB332D4713CB79486AC2C819BD66A", hash_generated_method = "63262E926696E0196F6086CC13217C77")
    public void union(int x, int y) {
    if(x < left)        
        {
            left = x;
        } 
        else
    if(x > right)        
        {
            right = x;
        } 
    if(y < top)        
        {
            top = y;
        } 
        else
    if(y > bottom)        
        {
            bottom = y;
        } 
        
        
            
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.051 -0400", hash_original_method = "B19A72EC4CF8FCC2B6266E5066EB04CB", hash_generated_method = "923821B6E32CA4A61F8338C287553EE7")
    public void sort() {
    if(left > right)        
        {
            int temp = left;
            left = right;
            right = temp;
        } 
    if(top > bottom)        
        {
            int temp = top;
            top = bottom;
            bottom = temp;
        } 
        
        
            
            
            
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.051 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D8FB80E0A5E29973BA4DC23BCD1470B7")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_628316899 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897888227 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897888227;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.051 -0400", hash_original_method = "548726568B563CCA3AC6BF577DA5CC4D", hash_generated_method = "70BE815957B7B45A5220718B709AD976")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeInt(left);
        out.writeInt(top);
        out.writeInt(right);
        out.writeInt(bottom);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.052 -0400", hash_original_method = "979823E39D5729D9D6A2DACBA85F6F6A", hash_generated_method = "42E1DA753B84F90CC42FB2F09788EE27")
    public void readFromParcel(Parcel in) {
        left = in.readInt();
        top = in.readInt();
        right = in.readInt();
        bottom = in.readInt();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.053 -0400", hash_original_method = "D8CF57D437DDADABC72AE60A50BB50F2", hash_generated_method = "487710C33559B4CC6896FFDFF0AB51D4")
    public void scale(float scale) {
    if(scale != 1.0f)        
        {
            left = (int) (left * scale + 0.5f);
            top = (int) (top * scale + 0.5f);
            right = (int) (right * scale + 0.5f);
            bottom = (int) (bottom * scale + 0.5f);
        } 
        
        
            
            
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.053 -0400", hash_original_field = "CE31B6E0DE512E03F6C313313D82D7EC", hash_generated_field = "22CBDD4FA5AC4D71EB10C39DCFB71CD2")

    private static final Pattern FLATTENED_PATTERN = Pattern.compile(
            "(-?\\d+) (-?\\d+) (-?\\d+) (-?\\d+)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.054 -0400", hash_original_field = "5ACE306FE3CEE5B37C1F91FBA8A509E2", hash_generated_field = "DAC7FA6B311812DA10DF2B09DF991282")

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

