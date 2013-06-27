package org.bouncycastle.util.encoders;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

public class HexEncoder implements Encoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.925 -0400", hash_original_field = "9FFAC4C14B6083B206E70065A3584771", hash_generated_field = "B73CDCAAA7500E9AD50957BAAEDA281E")

    protected byte[] encodingTable = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.925 -0400", hash_original_field = "22173E2A74F154E91BA0F39198C1B226", hash_generated_field = "61E8D314E43B3B5F33274C2B5F732032")

    protected byte[] decodingTable = new byte[128];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.925 -0400", hash_original_method = "E555776B59F5150257DBB59B34D3D923", hash_generated_method = "7737B06D97A40AC486E2D8BE989DC087")
    public  HexEncoder() {
        initialiseDecodingTable();
        // ---------- Original Method ----------
        //initialiseDecodingTable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.926 -0400", hash_original_method = "7253B636544E47F410015D46451276E0", hash_generated_method = "4221E1C3E13D49007600E9F1A14D8D18")
    protected void initialiseDecodingTable() {
        {
            int i;
            i = 0;
            {
                decodingTable[encodingTable[i]] = (byte)i;
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.936 -0400", hash_original_method = "BD9F8FC335D977E935DA4351136AEC70", hash_generated_method = "1B7E1BAA5F3F21F2C0E4AF43FBB86732")
    public int encode(
        byte[]                data,
        int                    off,
        int                    length,
        OutputStream    out) throws IOException {
        {
            int i;
            i = off;
            {
                int v;
                v = data[i] & 0xff;
                out.write(encodingTable[(v >>> 4)]);
                out.write(encodingTable[v & 0xf]);
            } //End block
        } //End collapsed parenthetic
        addTaint(data[0]);
        addTaint(off);
        addTaint(length);
        addTaint(out.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1814454285 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1814454285;
        // ---------- Original Method ----------
        //for (int i = off; i < (off + length); i++)
        //{
            //int    v = data[i] & 0xff;
            //out.write(encodingTable[(v >>> 4)]);
            //out.write(encodingTable[v & 0xf]);
        //}
        //return length * 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.937 -0400", hash_original_method = "1B2A7D609CA1F47FC87AA118398B5C86", hash_generated_method = "D98E29724B7F78694C549D6617AFA9ED")
    private boolean ignore(
        char    c) {
        addTaint(c);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483670461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_483670461;
        // ---------- Original Method ----------
        //return (c == '\n' || c =='\r' || c == '\t' || c == ' ');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.938 -0400", hash_original_method = "B7EDB63E53FAEFA939E2D19889BCA5A2", hash_generated_method = "BED90055AB0D62A905DAA952B2C079A5")
    public int decode(
        byte[]          data,
        int             off,
        int             length,
        OutputStream    out) throws IOException {
        byte b1, b2;
        int outLen;
        outLen = 0;
        int end;
        end = off + length;
        {
            {
                boolean var8734AAABA8B2B8BCF029CC1C18593F13_1511019766 = (!ignore((char)data[end - 1]));
            } //End collapsed parenthetic
        } //End block
        int i;
        i = off;
        {
            {
                boolean var54C7BE422D589D4EE3EB334BCFD700ED_512845731 = (i < end && ignore((char)data[i]));
            } //End collapsed parenthetic
            b1 = decodingTable[data[i++]];
            {
                boolean var54C7BE422D589D4EE3EB334BCFD700ED_2102454800 = (i < end && ignore((char)data[i]));
            } //End collapsed parenthetic
            b2 = decodingTable[data[i++]];
            out.write((b1 << 4) | b2);
        } //End block
        addTaint(data[0]);
        addTaint(off);
        addTaint(length);
        addTaint(out.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064461583 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064461583;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.938 -0400", hash_original_method = "6D8A267573E3557F73C2709EF9053C58", hash_generated_method = "EAFFD6E9B86662F11C0DEAB42B2EE910")
    public int decode(
        String          data,
        OutputStream    out) throws IOException {
        byte b1, b2;
        int length;
        length = 0;
        int end;
        end = data.length();
        {
            {
                boolean varC2A9184A6FDB10F7AA879085E67E2E47_1935511045 = (!ignore(data.charAt(end - 1)));
            } //End collapsed parenthetic
        } //End block
        int i;
        i = 0;
        {
            {
                boolean varF0244F9F9EF55F67FCF89B8CEA49201D_1362841618 = (i < end && ignore(data.charAt(i)));
            } //End collapsed parenthetic
            b1 = decodingTable[data.charAt(i++)];
            {
                boolean varF0244F9F9EF55F67FCF89B8CEA49201D_433361743 = (i < end && ignore(data.charAt(i)));
            } //End collapsed parenthetic
            b2 = decodingTable[data.charAt(i++)];
            out.write((b1 << 4) | b2);
        } //End block
        addTaint(data.getTaint());
        addTaint(out.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1341982132 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1341982132;
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

