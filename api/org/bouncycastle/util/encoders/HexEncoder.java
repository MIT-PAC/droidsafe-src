package org.bouncycastle.util.encoders;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.OutputStream;

public class HexEncoder implements Encoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.333 -0400", hash_original_field = "9FFAC4C14B6083B206E70065A3584771", hash_generated_field = "A8D4DC408DE84610D910B7400C27CA50")

    protected final byte[] encodingTable = {
            (byte)'0', (byte)'1', (byte)'2', (byte)'3', (byte)'4', (byte)'5', (byte)'6', (byte)'7',
            (byte)'8', (byte)'9', (byte)'a', (byte)'b', (byte)'c', (byte)'d', (byte)'e', (byte)'f'
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.334 -0400", hash_original_field = "22173E2A74F154E91BA0F39198C1B226", hash_generated_field = "C5A9E5FA83A75FCB14FF277263CBAED5")

    protected final byte[] decodingTable = new byte[128];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.334 -0400", hash_original_method = "E555776B59F5150257DBB59B34D3D923", hash_generated_method = "7737B06D97A40AC486E2D8BE989DC087")
    public  HexEncoder() {
        initialiseDecodingTable();
        // ---------- Original Method ----------
        //initialiseDecodingTable();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.335 -0400", hash_original_method = "7253B636544E47F410015D46451276E0", hash_generated_method = "C89997037354336FB875A889DB6A4DC5")
    protected void initialiseDecodingTable() {
for(int i = 0;i < encodingTable.length;i++)
        {
            decodingTable[encodingTable[i]] = (byte)i;
        } //End block
        decodingTable['A'] = decodingTable['a'];
        decodingTable['B'] = decodingTable['b'];
        decodingTable['C'] = decodingTable['c'];
        decodingTable['D'] = decodingTable['d'];
        decodingTable['E'] = decodingTable['e'];
        decodingTable['F'] = decodingTable['f'];
        // ---------- Original Method ----------
        //for (int i = 0; i < encodingTable.length; i++)
        //{
            //decodingTable[encodingTable[i]] = (byte)i;
        //}
        //decodingTable['A'] = decodingTable['a'];
        //decodingTable['B'] = decodingTable['b'];
        //decodingTable['C'] = decodingTable['c'];
        //decodingTable['D'] = decodingTable['d'];
        //decodingTable['E'] = decodingTable['e'];
        //decodingTable['F'] = decodingTable['f'];
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.336 -0400", hash_original_method = "BD9F8FC335D977E935DA4351136AEC70", hash_generated_method = "147F52D290A55FC291CDC91C2D5A299D")
    public int encode(
        byte[]                data,
        int                    off,
        int                    length,
        OutputStream    out) throws IOException {
        addTaint(out.getTaint());
        addTaint(length);
        addTaint(off);
        addTaint(data[0]);
for(int i = off;i < (off + length);i++)
        {
            int v = data[i] & 0xff;
            out.write(encodingTable[(v >>> 4)]);
            out.write(encodingTable[v & 0xf]);
        } //End block
        int var49E1420DFAE7A1905EA8E340CD939C15_1814854346 = (length * 2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1927783806 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1927783806;
        // ---------- Original Method ----------
        //for (int i = off; i < (off + length); i++)
        //{
            //int    v = data[i] & 0xff;
            //out.write(encodingTable[(v >>> 4)]);
            //out.write(encodingTable[v & 0xf]);
        //}
        //return length * 2;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.336 -0400", hash_original_method = "1B2A7D609CA1F47FC87AA118398B5C86", hash_generated_method = "129DF6EF0FBDE4F8BD371A5BD9C2E345")
    private boolean ignore(
        char    c) {
        addTaint(c);
        boolean var0813D1039B08197476EB8CFDC63ADF39_394509568 = ((c == '\n' || c =='\r' || c == '\t' || c == ' '));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1219697980 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1219697980;
        // ---------- Original Method ----------
        //return (c == '\n' || c =='\r' || c == '\t' || c == ' ');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.337 -0400", hash_original_method = "B7EDB63E53FAEFA939E2D19889BCA5A2", hash_generated_method = "335254B7720B10815E0059A22075B404")
    public int decode(
        byte[]          data,
        int             off,
        int             length,
        OutputStream    out) throws IOException {
        addTaint(out.getTaint());
        addTaint(length);
        addTaint(off);
        addTaint(data[0]);
        byte b1;
        byte b2;
        int outLen = 0;
        int end = off + length;
        while
(end > off)        
        {
            if(!ignore((char)data[end - 1]))            
            {
                break;
            } //End block
            end--;
        } //End block
        int i = off;
        while
(i < end)        
        {
            while
(i < end && ignore((char)data[i]))            
            {
                i++;
            } //End block
            b1 = decodingTable[data[i++]];
            while
(i < end && ignore((char)data[i]))            
            {
                i++;
            } //End block
            b2 = decodingTable[data[i++]];
            out.write((b1 << 4) | b2);
            outLen++;
        } //End block
        int var504BA8911EA515F30CAFCF90C1129E92_1553602561 = (outLen);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796001815 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796001815;
        // ---------- Original Method ----------
        //byte    b1, b2;
        //int     outLen = 0;
        //int     end = off + length;
        //while (end > off)
        //{
            //if (!ignore((char)data[end - 1]))
            //{
                //break;
            //}
            //end--;
        //}
        //int i = off;
        //while (i < end)
        //{
            //while (i < end && ignore((char)data[i]))
            //{
                //i++;
            //}
            //b1 = decodingTable[data[i++]];
            //while (i < end && ignore((char)data[i]))
            //{
                //i++;
            //}
            //b2 = decodingTable[data[i++]];
            //out.write((b1 << 4) | b2);
            //outLen++;
        //}
        //return outLen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.338 -0400", hash_original_method = "6D8A267573E3557F73C2709EF9053C58", hash_generated_method = "84768F170AB9D25198EF5A73F4E1849B")
    public int decode(
        String          data,
        OutputStream    out) throws IOException {
        addTaint(out.getTaint());
        addTaint(data.getTaint());
        byte b1;
        byte b2;
        int length = 0;
        int end = data.length();
        while
(end > 0)        
        {
            if(!ignore(data.charAt(end - 1)))            
            {
                break;
            } //End block
            end--;
        } //End block
        int i = 0;
        while
(i < end)        
        {
            while
(i < end && ignore(data.charAt(i)))            
            {
                i++;
            } //End block
            b1 = decodingTable[data.charAt(i++)];
            while
(i < end && ignore(data.charAt(i)))            
            {
                i++;
            } //End block
            b2 = decodingTable[data.charAt(i++)];
            out.write((b1 << 4) | b2);
            length++;
        } //End block
        int var2FA47F7C65FEC19CC163B195725E3844_2062009710 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724544051 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724544051;
        // ---------- Original Method ----------
        //byte    b1, b2;
        //int     length = 0;
        //int     end = data.length();
        //while (end > 0)
        //{
            //if (!ignore(data.charAt(end - 1)))
            //{
                //break;
            //}
            //end--;
        //}
        //int i = 0;
        //while (i < end)
        //{
            //while (i < end && ignore(data.charAt(i)))
            //{
                //i++;
            //}
            //b1 = decodingTable[data.charAt(i++)];
            //while (i < end && ignore(data.charAt(i)))
            //{
                //i++;
            //}
            //b2 = decodingTable[data.charAt(i++)];
            //out.write((b1 << 4) | b2);
            //length++;
        //}
        //return length;
    }

    
}

