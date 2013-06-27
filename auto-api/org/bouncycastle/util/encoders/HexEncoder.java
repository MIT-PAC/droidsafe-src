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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.903 -0400", hash_original_field = "9FFAC4C14B6083B206E70065A3584771", hash_generated_field = "E21A5D458FF966DEB66072DF911B0757")

    protected byte[] encodingTable = {
            (byte)'0', (byte)'1', (byte)'2', (byte)'3', (byte)'4', (byte)'5', (byte)'6', (byte)'7',
            (byte)'8', (byte)'9', (byte)'a', (byte)'b', (byte)'c', (byte)'d', (byte)'e', (byte)'f'
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.903 -0400", hash_original_field = "22173E2A74F154E91BA0F39198C1B226", hash_generated_field = "61E8D314E43B3B5F33274C2B5F732032")

    protected byte[] decodingTable = new byte[128];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.903 -0400", hash_original_method = "E555776B59F5150257DBB59B34D3D923", hash_generated_method = "7737B06D97A40AC486E2D8BE989DC087")
    public  HexEncoder() {
        initialiseDecodingTable();
        // ---------- Original Method ----------
        //initialiseDecodingTable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.910 -0400", hash_original_method = "7253B636544E47F410015D46451276E0", hash_generated_method = "4221E1C3E13D49007600E9F1A14D8D18")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.914 -0400", hash_original_method = "BD9F8FC335D977E935DA4351136AEC70", hash_generated_method = "DBC3C10841E00C4F0AA7EC4CDB7258B0")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_413076213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_413076213;
        // ---------- Original Method ----------
        //for (int i = off; i < (off + length); i++)
        //{
            //int    v = data[i] & 0xff;
            //out.write(encodingTable[(v >>> 4)]);
            //out.write(encodingTable[v & 0xf]);
        //}
        //return length * 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.915 -0400", hash_original_method = "1B2A7D609CA1F47FC87AA118398B5C86", hash_generated_method = "1DD7096650CECB97A93C957CC4DBE727")
    private boolean ignore(
        char    c) {
        addTaint(c);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_848319119 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_848319119;
        // ---------- Original Method ----------
        //return (c == '\n' || c =='\r' || c == '\t' || c == ' ');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.916 -0400", hash_original_method = "B7EDB63E53FAEFA939E2D19889BCA5A2", hash_generated_method = "82B8C327DFE7C5D16F098A204365EC69")
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
                boolean var8734AAABA8B2B8BCF029CC1C18593F13_313039201 = (!ignore((char)data[end - 1]));
            } //End collapsed parenthetic
        } //End block
        int i;
        i = off;
        {
            {
                boolean var54C7BE422D589D4EE3EB334BCFD700ED_97834626 = (i < end && ignore((char)data[i]));
            } //End collapsed parenthetic
            b1 = decodingTable[data[i++]];
            {
                boolean var54C7BE422D589D4EE3EB334BCFD700ED_419156044 = (i < end && ignore((char)data[i]));
            } //End collapsed parenthetic
            b2 = decodingTable[data[i++]];
            out.write((b1 << 4) | b2);
        } //End block
        addTaint(data[0]);
        addTaint(off);
        addTaint(length);
        addTaint(out.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552019484 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552019484;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.926 -0400", hash_original_method = "6D8A267573E3557F73C2709EF9053C58", hash_generated_method = "3513EBD1B8C8BC57A8218212768A948B")
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
                boolean varC2A9184A6FDB10F7AA879085E67E2E47_2003467469 = (!ignore(data.charAt(end - 1)));
            } //End collapsed parenthetic
        } //End block
        int i;
        i = 0;
        {
            {
                boolean varF0244F9F9EF55F67FCF89B8CEA49201D_1397588448 = (i < end && ignore(data.charAt(i)));
            } //End collapsed parenthetic
            b1 = decodingTable[data.charAt(i++)];
            {
                boolean varF0244F9F9EF55F67FCF89B8CEA49201D_1399817467 = (i < end && ignore(data.charAt(i)));
            } //End collapsed parenthetic
            b2 = decodingTable[data.charAt(i++)];
            out.write((b1 << 4) | b2);
        } //End block
        addTaint(data.getTaint());
        addTaint(out.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333916000 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333916000;
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

