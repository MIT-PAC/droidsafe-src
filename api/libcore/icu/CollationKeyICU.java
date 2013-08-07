package libcore.icu;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.CollationKey;






public final class CollationKeyICU extends CollationKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.539 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "4E58ABB9D5068B90ACC1157BF07E4EBB")

    private byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.539 -0400", hash_original_field = "550D1CC054A1B23A411DDDA46FD64811", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

    private int hashCode;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.540 -0400", hash_original_method = "FDD367E7E47ED4793DE3731632868D96", hash_generated_method = "A46AF2BB61EEDFD614E5969E9D97A01A")
      CollationKeyICU(String source, byte[] bytes) {
        super(source);
        addTaint(source.getTaint());
        this.bytes = bytes;
        // ---------- Original Method ----------
        //this.bytes = bytes;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.541 -0400", hash_original_method = "2BC5B1EAC391DF0E7068AFC895CE7148", hash_generated_method = "4F5E3B8C73E237782BA3A4113A98482D")
    @Override
    public int compareTo(CollationKey other) {
        addTaint(other.getTaint());
        byte[] rhsBytes;
        if(other instanceof CollationKeyICU)        
        {
            rhsBytes = ((CollationKeyICU) other).bytes;
        } //End block
        else
        {
            rhsBytes = other.toByteArray();
        } //End block
        if(bytes == null || bytes.length == 0)        
        {
            if(rhsBytes == null || rhsBytes.length == 0)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1279416866 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430245717 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430245717;
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1693286513 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_118277750 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_118277750;
        } //End block
        else
        {
            if(rhsBytes == null || rhsBytes.length == 0)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_780697816 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866276744 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866276744;
            } //End block
        } //End block
        int count = Math.min(bytes.length, rhsBytes.length);
for(int i = 0;i < count;++i)
        {
            int s = bytes[i] & 0xff;
            int t = rhsBytes[i] & 0xff;
            if(s < t)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1484161134 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191212711 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191212711;
            } //End block
            if(s > t)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_1652069642 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_130124612 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_130124612;
            } //End block
        } //End block
        if(bytes.length < rhsBytes.length)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1039354259 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1167226926 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1167226926;
        } //End block
        if(bytes.length > rhsBytes.length)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_2100720182 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_392135850 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_392135850;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1350418776 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_442898467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_442898467;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.543 -0400", hash_original_method = "02D4FA820C7658A0385D9CDD7EC5D935", hash_generated_method = "832A3023DF0C77FEFE11C5A0C0F0D44B")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(object == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1994524908 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226745353 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226745353;
        } //End block
        if(!(object instanceof CollationKey))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1299569105 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_28539577 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_28539577;
        } //End block
        boolean varF5A675BF26AB588750C6F1EDB4828A8C_691284278 = (compareTo((CollationKey) object) == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1303583900 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1303583900;
        // ---------- Original Method ----------
        //if (object == this) {
            //return true;
        //}
        //if (!(object instanceof CollationKey)) {
            //return false;
        //}
        //return compareTo((CollationKey) object) == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.544 -0400", hash_original_method = "14EA39361109DCC90111D16D29CE0C8D", hash_generated_method = "7FE49B5450F135FB055F8EB47B0BE298")
    @Override
    public int hashCode() {
        if(hashCode == 0)        
        {
            if(bytes != null && bytes.length != 0)            
            {
                int len = bytes.length;
                int inc = ((len - 32) / 32) + 1;
for(int i = 0;i < len;)
                {
                    hashCode = (hashCode * 37) + bytes[i];
                    i += inc;
                } //End block
            } //End block
            if(hashCode == 0)            
            {
                hashCode = 1;
            } //End block
        } //End block
        int var550D1CC054A1B23A411DDDA46FD64811_1294118174 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110047073 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110047073;
        // ---------- Original Method ----------
        //if (hashCode == 0) {
            //if (bytes != null && bytes.length != 0) {
                //int len = bytes.length;
                //int inc = ((len - 32) / 32) + 1;
                //for (int i = 0; i < len;) {
                    //hashCode = (hashCode * 37) + bytes[i];
                    //i += inc;
                //}
            //}
            //if (hashCode == 0) {
                //hashCode = 1;
            //}
        //}
        //return hashCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.546 -0400", hash_original_method = "6C3C6FF515A6D95256010638A5024205", hash_generated_method = "058E0D14FF37CF563AB1B9F002AA374B")
    @Override
    public byte[] toByteArray() {
        if(bytes == null || bytes.length == 0)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1729182913 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_278301478 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_278301478;
        } //End block
        byte[] var93C13AC1A46225B267C2E61D60802F40_1759177878 = (bytes.clone());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1044747608 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1044747608;
        // ---------- Original Method ----------
        //if (bytes == null || bytes.length == 0) {
            //return null;
        //}
        //return bytes.clone();
    }

    
}

