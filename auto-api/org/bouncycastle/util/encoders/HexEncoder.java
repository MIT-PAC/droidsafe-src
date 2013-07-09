package org.bouncycastle.util.encoders;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

public class HexEncoder implements Encoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.324 -0400", hash_original_field = "9FFAC4C14B6083B206E70065A3584771", hash_generated_field = "A8D4DC408DE84610D910B7400C27CA50")

    protected final byte[] encodingTable = {
            (byte)'0', (byte)'1', (byte)'2', (byte)'3', (byte)'4', (byte)'5', (byte)'6', (byte)'7',
            (byte)'8', (byte)'9', (byte)'a', (byte)'b', (byte)'c', (byte)'d', (byte)'e', (byte)'f'
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.324 -0400", hash_original_field = "22173E2A74F154E91BA0F39198C1B226", hash_generated_field = "C5A9E5FA83A75FCB14FF277263CBAED5")

    protected final byte[] decodingTable = new byte[128];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.325 -0400", hash_original_method = "E555776B59F5150257DBB59B34D3D923", hash_generated_method = "7737B06D97A40AC486E2D8BE989DC087")
    public  HexEncoder() {
        initialiseDecodingTable();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.325 -0400", hash_original_method = "7253B636544E47F410015D46451276E0", hash_generated_method = "F4F2ACFF26AE53B01B3E571EB8BEB286")
    protected void initialiseDecodingTable() {
        {
            int i = 0;
            {
                decodingTable[encodingTable[i]] = (byte)i;
            } 
        } 
        decodingTable['A'] = decodingTable['a'];
        decodingTable['B'] = decodingTable['b'];
        decodingTable['C'] = decodingTable['c'];
        decodingTable['D'] = decodingTable['d'];
        decodingTable['E'] = decodingTable['e'];
        decodingTable['F'] = decodingTable['f'];
        
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.326 -0400", hash_original_method = "BD9F8FC335D977E935DA4351136AEC70", hash_generated_method = "D6AF59B169EFD784A9A0561805343F17")
    public int encode(
        byte[]                data,
        int                    off,
        int                    length,
        OutputStream    out) throws IOException {
        {
            int i = off;
            {
                int v = data[i] & 0xff;
                out.write(encodingTable[(v >>> 4)]);
                out.write(encodingTable[v & 0xf]);
            } 
        } 
        addTaint(data[0]);
        addTaint(off);
        addTaint(length);
        addTaint(out.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14344016 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14344016;
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.326 -0400", hash_original_method = "1B2A7D609CA1F47FC87AA118398B5C86", hash_generated_method = "F5F888AEE1E583C027E6C8403C15C245")
    private boolean ignore(
        char    c) {
        addTaint(c);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_926192900 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_926192900;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.327 -0400", hash_original_method = "B7EDB63E53FAEFA939E2D19889BCA5A2", hash_generated_method = "304B8F23C6CCC9785FDE2A61501D292F")
    public int decode(
        byte[]          data,
        int             off,
        int             length,
        OutputStream    out) throws IOException {
        byte b1;
        byte b2;
        int outLen = 0;
        int end = off + length;
        {
            {
                boolean var8734AAABA8B2B8BCF029CC1C18593F13_2140518680 = (!ignore((char)data[end - 1]));
            } 
        } 
        int i = off;
        {
            {
                boolean var54C7BE422D589D4EE3EB334BCFD700ED_234143177 = (i < end && ignore((char)data[i]));
            } 
            b1 = decodingTable[data[i++]];
            {
                boolean var54C7BE422D589D4EE3EB334BCFD700ED_1326116509 = (i < end && ignore((char)data[i]));
            } 
            b2 = decodingTable[data[i++]];
            out.write((b1 << 4) | b2);
        } 
        addTaint(data[0]);
        addTaint(off);
        addTaint(length);
        addTaint(out.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1853508023 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1853508023;
        
        
        
        
        
        
            
            
                
            
            
        
        
        
        
            
            
                
            
            
            
            
                
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.329 -0400", hash_original_method = "6D8A267573E3557F73C2709EF9053C58", hash_generated_method = "C3FB01C435F46C944AC4AD23F6852836")
    public int decode(
        String          data,
        OutputStream    out) throws IOException {
        byte b1;
        byte b2;
        int length = 0;
        int end = data.length();
        {
            {
                boolean varC2A9184A6FDB10F7AA879085E67E2E47_269128251 = (!ignore(data.charAt(end - 1)));
            } 
        } 
        int i = 0;
        {
            {
                boolean varF0244F9F9EF55F67FCF89B8CEA49201D_1524631847 = (i < end && ignore(data.charAt(i)));
            } 
            b1 = decodingTable[data.charAt(i++)];
            {
                boolean varF0244F9F9EF55F67FCF89B8CEA49201D_489885426 = (i < end && ignore(data.charAt(i)));
            } 
            b2 = decodingTable[data.charAt(i++)];
            out.write((b1 << 4) | b2);
        } 
        addTaint(data.getTaint());
        addTaint(out.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1080056334 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1080056334;
        
        
        
        
        
        
            
            
                
            
            
        
        
        
        
            
            
                
            
            
            
            
                
            
            
            
            
        
        
    }

    
}

