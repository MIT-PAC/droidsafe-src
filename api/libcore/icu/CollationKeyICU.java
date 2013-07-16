package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.CollationKey;

public final class CollationKeyICU extends CollationKey {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.539 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "4E58ABB9D5068B90ACC1157BF07E4EBB")

    private byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.539 -0400", hash_original_field = "550D1CC054A1B23A411DDDA46FD64811", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

    private int hashCode;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.540 -0400", hash_original_method = "FDD367E7E47ED4793DE3731632868D96", hash_generated_method = "A46AF2BB61EEDFD614E5969E9D97A01A")
      CollationKeyICU(String source, byte[] bytes) {
        super(source);
        addTaint(source.getTaint());
        this.bytes = bytes;
        // ---------- Original Method ----------
        //this.bytes = bytes;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.541 -0400", hash_original_method = "2BC5B1EAC391DF0E7068AFC895CE7148", hash_generated_method = "A87610D2B561D3EB8EECB7A1C07FD67E")
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
                int varCFCD208495D565EF66E7DFF9F98764DA_612747322 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1286596992 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1286596992;
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_290705780 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456489946 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456489946;
        } //End block
        else
        {
    if(rhsBytes == null || rhsBytes.length == 0)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_775684583 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_17596266 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_17596266;
            } //End block
        } //End block
        int count = Math.min(bytes.length, rhsBytes.length);
for(int i = 0;i < count;++i)
        {
            int s = bytes[i] & 0xff;
            int t = rhsBytes[i] & 0xff;
    if(s < t)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_667587377 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1276467692 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1276467692;
            } //End block
    if(s > t)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_66435575 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307705898 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307705898;
            } //End block
        } //End block
    if(bytes.length < rhsBytes.length)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_14072989 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694106465 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694106465;
        } //End block
    if(bytes.length > rhsBytes.length)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_262536994 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_912858608 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_912858608;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1178518159 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1197848417 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1197848417;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.542 -0400", hash_original_method = "02D4FA820C7658A0385D9CDD7EC5D935", hash_generated_method = "AB8D2C8A3EFAFE3E7B5F6AA582387044")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(object == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1859209238 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1337791518 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1337791518;
        } //End block
    if(!(object instanceof CollationKey))        
        {
            boolean var68934A3E9455FA72420237EB05902327_834479618 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1990501621 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1990501621;
        } //End block
        boolean varF5A675BF26AB588750C6F1EDB4828A8C_82139518 = (compareTo((CollationKey) object) == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2043434284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2043434284;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.543 -0400", hash_original_method = "14EA39361109DCC90111D16D29CE0C8D", hash_generated_method = "52C33AB7FCE5DEBCB92EBCC52792E7CB")
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
        int var550D1CC054A1B23A411DDDA46FD64811_15865451 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237579059 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237579059;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.543 -0400", hash_original_method = "6C3C6FF515A6D95256010638A5024205", hash_generated_method = "4E603E5626B7FB3447A4CA3DC91C9AE0")
    @Override
    public byte[] toByteArray() {
    if(bytes == null || bytes.length == 0)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_784896419 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2114528806 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_2114528806;
        } //End block
        byte[] var93C13AC1A46225B267C2E61D60802F40_1359903646 = (bytes.clone());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1229838331 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1229838331;
        // ---------- Original Method ----------
        //if (bytes == null || bytes.length == 0) {
            //return null;
        //}
        //return bytes.clone();
    }

    
}

