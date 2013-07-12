package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class BERApplicationSpecificParser implements ASN1ApplicationSpecificParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.780 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.780 -0400", hash_original_field = "3643B86326B2FFCC0A085B4DD3A4309B", hash_generated_field = "BDA992D1A9789DCE4BA9542117A08206")

    private ASN1StreamParser parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.781 -0400", hash_original_method = "E0609A70F39E6E6F4E13B827D68F5B4C", hash_generated_method = "1CDD23288A33C70CA68843FF735DD782")
      BERApplicationSpecificParser(int tag, ASN1StreamParser parser) {
        this.tag = tag;
        this.parser = parser;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.781 -0400", hash_original_method = "FC19FBA5450B1E3458DF66BAD498F5C7", hash_generated_method = "4183BA1596FC2E195E49D3441464D9B3")
    public DEREncodable readObject() throws IOException {
DEREncodable var09F4702C04B163043983FE2F5378920C_2076986905 =         parser.readObject();
        var09F4702C04B163043983FE2F5378920C_2076986905.addTaint(taint);
        return var09F4702C04B163043983FE2F5378920C_2076986905;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.782 -0400", hash_original_method = "B2A8CB4DD75EA6F990011FAB1A0E301F", hash_generated_method = "E20F28AD93E8E5D696D6B44A67C2208B")
    public DERObject getLoadedObject() throws IOException {
DERObject var49C379AB737313FF79147B13CD4AA097_87601318 =         new BERApplicationSpecific(tag, parser.readVector());
        var49C379AB737313FF79147B13CD4AA097_87601318.addTaint(taint);
        return var49C379AB737313FF79147B13CD4AA097_87601318;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.782 -0400", hash_original_method = "C25B7E6814F316F8AC8F55D830DF862A", hash_generated_method = "0D6A39CD81286665DAF18FA5A5CB9A52")
    public DERObject getDERObject() {
        try 
        {
DERObject var7CA8C38BF885E63AD9395CA9CA98D912_1927673384 =             getLoadedObject();
            var7CA8C38BF885E63AD9395CA9CA98D912_1927673384.addTaint(taint);
            return var7CA8C38BF885E63AD9395CA9CA98D912_1927673384;
        } 
        catch (IOException e)
        {
            ASN1ParsingException var2B5ADF01A3F8BD267A883C161A3838C1_587686333 = new ASN1ParsingException(e.getMessage(), e);
            var2B5ADF01A3F8BD267A883C161A3838C1_587686333.addTaint(taint);
            throw var2B5ADF01A3F8BD267A883C161A3838C1_587686333;
        } 
        
        
        
            
        
        
        
            
        
    }

    
}

