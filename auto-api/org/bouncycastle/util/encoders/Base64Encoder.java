package org.bouncycastle.util.encoders;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

public class Base64Encoder implements Encoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.916 -0400", hash_original_field = "26679137600502689C8A177F50F164AC", hash_generated_field = "28BCCF922B0F85B38A1D57798E42954A")

    protected byte[] encodingTable = {
            (byte)'A', (byte)'B', (byte)'C', (byte)'D', (byte)'E', (byte)'F', (byte)'G',
            (byte)'H', (byte)'I', (byte)'J', (byte)'K', (byte)'L', (byte)'M', (byte)'N',
            (byte)'O', (byte)'P', (byte)'Q', (byte)'R', (byte)'S', (byte)'T', (byte)'U',
            (byte)'V', (byte)'W', (byte)'X', (byte)'Y', (byte)'Z',
            (byte)'a', (byte)'b', (byte)'c', (byte)'d', (byte)'e', (byte)'f', (byte)'g',
            (byte)'h', (byte)'i', (byte)'j', (byte)'k', (byte)'l', (byte)'m', (byte)'n',
            (byte)'o', (byte)'p', (byte)'q', (byte)'r', (byte)'s', (byte)'t', (byte)'u',
            (byte)'v',
            (byte)'w', (byte)'x', (byte)'y', (byte)'z',
            (byte)'0', (byte)'1', (byte)'2', (byte)'3', (byte)'4', (byte)'5', (byte)'6',
            (byte)'7', (byte)'8', (byte)'9',
            (byte)'+', (byte)'/'
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.916 -0400", hash_original_field = "6BFC228E0751465901E4098F8966DFFF", hash_generated_field = "6470484C1DBA83A435D7A06D16D20315")

    protected byte padding = (byte)'=';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.916 -0400", hash_original_field = "22173E2A74F154E91BA0F39198C1B226", hash_generated_field = "61E8D314E43B3B5F33274C2B5F732032")

    protected byte[] decodingTable = new byte[128];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.917 -0400", hash_original_method = "680D3875922DD4E67C0EE2E950D928BD", hash_generated_method = "AABF19D4D0BC5EA370D8438ED4D196CF")
    public  Base64Encoder() {
        initialiseDecodingTable();
        // ---------- Original Method ----------
        //initialiseDecodingTable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.918 -0400", hash_original_method = "21DA0B3C66110012AEC4B0EF8A985DB1", hash_generated_method = "C3C116EAADBCF8F0520183B5BCA12AA5")
    protected void initialiseDecodingTable() {
        {
            int i;
            i = 0;
            {
                decodingTable[encodingTable[i]] = (byte)i;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < encodingTable.length; i++)
        //{
            //decodingTable[encodingTable[i]] = (byte)i;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.926 -0400", hash_original_method = "9CA1F48AAB7841E0E0CBD16E0BA7D360", hash_generated_method = "9E676B13CF1BC91906B3B40F95A7345F")
    public int encode(
        byte[]                data,
        int                    off,
        int                    length,
        OutputStream    out) throws IOException {
        int modulus;
        modulus = length % 3;
        int dataLength;
        dataLength = (length - modulus);
        int a1, a2, a3;
        {
            int i;
            i = off;
            i += 3;
            {
                a1 = data[i] & 0xff;
                a2 = data[i + 1] & 0xff;
                a3 = data[i + 2] & 0xff;
                out.write(encodingTable[(a1 >>> 2) & 0x3f]);
                out.write(encodingTable[((a1 << 4) | (a2 >>> 4)) & 0x3f]);
                out.write(encodingTable[((a2 << 2) | (a3 >>> 6)) & 0x3f]);
                out.write(encodingTable[a3 & 0x3f]);
            } //End block
        } //End collapsed parenthetic
        int b1, b2, b3;
        int d1, d2;
        //Begin case 1 
        d1 = data[off + dataLength] & 0xff;
        //End case 1 
        //Begin case 1 
        b1 = (d1 >>> 2) & 0x3f;
        //End case 1 
        //Begin case 1 
        b2 = (d1 << 4) & 0x3f;
        //End case 1 
        //Begin case 1 
        out.write(encodingTable[b1]);
        //End case 1 
        //Begin case 1 
        out.write(encodingTable[b2]);
        //End case 1 
        //Begin case 1 
        out.write(padding);
        //End case 1 
        //Begin case 1 
        out.write(padding);
        //End case 1 
        //Begin case 2 
        d1 = data[off + dataLength] & 0xff;
        //End case 2 
        //Begin case 2 
        d2 = data[off + dataLength + 1] & 0xff;
        //End case 2 
        //Begin case 2 
        b1 = (d1 >>> 2) & 0x3f;
        //End case 2 
        //Begin case 2 
        b2 = ((d1 << 4) | (d2 >>> 4)) & 0x3f;
        //End case 2 
        //Begin case 2 
        b3 = (d2 << 2) & 0x3f;
        //End case 2 
        //Begin case 2 
        out.write(encodingTable[b1]);
        //End case 2 
        //Begin case 2 
        out.write(encodingTable[b2]);
        //End case 2 
        //Begin case 2 
        out.write(encodingTable[b3]);
        //End case 2 
        //Begin case 2 
        out.write(padding);
        //End case 2 
        addTaint(data[0]);
        addTaint(off);
        addTaint(length);
        addTaint(out.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_247306521 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_247306521;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.927 -0400", hash_original_method = "1B2A7D609CA1F47FC87AA118398B5C86", hash_generated_method = "726AA79E89679B4E4A6BE33AB02ADC77")
    private boolean ignore(
        char    c) {
        addTaint(c);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1177138841 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1177138841;
        // ---------- Original Method ----------
        //return (c == '\n' || c =='\r' || c == '\t' || c == ' ');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.937 -0400", hash_original_method = "211C1414D28F35039504B68D95AB9ED9", hash_generated_method = "88E2B54537A7CA93FEFF483F930C1B2B")
    public int decode(
        byte[]          data,
        int             off,
        int             length,
        OutputStream    out) throws IOException {
        byte b1, b2, b3, b4;
        int outLen;
        outLen = 0;
        int end;
        end = off + length;
        {
            {
                boolean var8734AAABA8B2B8BCF029CC1C18593F13_1739106156 = (!ignore((char)data[end - 1]));
            } //End collapsed parenthetic
        } //End block
        int i;
        i = off;
        int finish;
        finish = end - 4;
        i = nextI(data, i, finish);
        {
            b1 = decodingTable[data[i++]];
            i = nextI(data, i, finish);
            b2 = decodingTable[data[i++]];
            i = nextI(data, i, finish);
            b3 = decodingTable[data[i++]];
            i = nextI(data, i, finish);
            b4 = decodingTable[data[i++]];
            out.write((b1 << 2) | (b2 >> 4));
            out.write((b2 << 4) | (b3 >> 2));
            out.write((b3 << 6) | b4);
            outLen += 3;
            i = nextI(data, i, finish);
        } //End block
        outLen += decodeLastBlock(out, (char)data[end - 4], (char)data[end - 3], (char)data[end - 2], (char)data[end - 1]);
        addTaint(data[0]);
        addTaint(off);
        addTaint(length);
        addTaint(out.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210163239 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210163239;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.944 -0400", hash_original_method = "1225BA5A886EEC007862013ADD842450", hash_generated_method = "160FB5174E4A1586848EBCB39FF8ADAC")
    private int nextI(byte[] data, int i, int finish) {
        {
            boolean var284A5091A1A635AAB256EACDF893A56A_1248927275 = ((i < finish) && ignore((char)data[i]));
        } //End collapsed parenthetic
        addTaint(data[0]);
        addTaint(i);
        addTaint(finish);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_266320396 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_266320396;
        // ---------- Original Method ----------
        //while ((i < finish) && ignore((char)data[i]))
        //{
            //i++;
        //}
        //return i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.948 -0400", hash_original_method = "304E01512ABEE5D32E29AD105C8F9759", hash_generated_method = "91A3256AC55820AB0F51E3D71A61D761")
    public int decode(
        String          data,
        OutputStream    out) throws IOException {
        byte b1, b2, b3, b4;
        int length;
        length = 0;
        int end;
        end = data.length();
        {
            {
                boolean varC2A9184A6FDB10F7AA879085E67E2E47_1163439121 = (!ignore(data.charAt(end - 1)));
            } //End collapsed parenthetic
        } //End block
        int i;
        i = 0;
        int finish;
        finish = end - 4;
        i = nextI(data, i, finish);
        {
            b1 = decodingTable[data.charAt(i++)];
            i = nextI(data, i, finish);
            b2 = decodingTable[data.charAt(i++)];
            i = nextI(data, i, finish);
            b3 = decodingTable[data.charAt(i++)];
            i = nextI(data, i, finish);
            b4 = decodingTable[data.charAt(i++)];
            out.write((b1 << 2) | (b2 >> 4));
            out.write((b2 << 4) | (b3 >> 2));
            out.write((b3 << 6) | b4);
            length += 3;
            i = nextI(data, i, finish);
        } //End block
        length += decodeLastBlock(out, data.charAt(end - 4), data.charAt(end - 3), data.charAt(end - 2), data.charAt(end - 1));
        addTaint(data.getTaint());
        addTaint(out.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_290615622 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_290615622;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.951 -0400", hash_original_method = "9E52D5CA91DB497317BE2B1E69827671", hash_generated_method = "46536B76168BA91FC570703B56A1E7DA")
    private int decodeLastBlock(OutputStream out, char c1, char c2, char c3, char c4) throws IOException {
        byte b1, b2, b3, b4;
        {
            b1 = decodingTable[c1];
            b2 = decodingTable[c2];
            out.write((b1 << 2) | (b2 >> 4));
        } //End block
        {
            b1 = decodingTable[c1];
            b2 = decodingTable[c2];
            b3 = decodingTable[c3];
            out.write((b1 << 2) | (b2 >> 4));
            out.write((b2 << 4) | (b3 >> 2));
        } //End block
        {
            b1 = decodingTable[c1];
            b2 = decodingTable[c2];
            b3 = decodingTable[c3];
            b4 = decodingTable[c4];
            out.write((b1 << 2) | (b2 >> 4));
            out.write((b2 << 4) | (b3 >> 2));
            out.write((b3 << 6) | b4);
        } //End block
        addTaint(out.getTaint());
        addTaint(c1);
        addTaint(c2);
        addTaint(c3);
        addTaint(c4);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1932583749 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1932583749;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.952 -0400", hash_original_method = "4A002F2B2C5A42BB007C07A5E9BC2D50", hash_generated_method = "D1FA005846578C5C362DB5D30FFBAEF9")
    private int nextI(String data, int i, int finish) {
        {
            boolean varA9105DFAE90C03A8F17A10F45775F060_333316659 = ((i < finish) && ignore(data.charAt(i)));
        } //End collapsed parenthetic
        addTaint(data.getTaint());
        addTaint(i);
        addTaint(finish);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202154702 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202154702;
        // ---------- Original Method ----------
        //while ((i < finish) && ignore(data.charAt(i)))
        //{
            //i++;
        //}
        //return i;
    }

    
}

