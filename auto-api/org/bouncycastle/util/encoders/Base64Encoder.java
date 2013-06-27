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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.955 -0400", hash_original_field = "26679137600502689C8A177F50F164AC", hash_generated_field = "B73CDCAAA7500E9AD50957BAAEDA281E")

    protected byte[] encodingTable = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.955 -0400", hash_original_field = "6BFC228E0751465901E4098F8966DFFF", hash_generated_field = "6470484C1DBA83A435D7A06D16D20315")

    protected byte padding = (byte)'=';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.955 -0400", hash_original_field = "22173E2A74F154E91BA0F39198C1B226", hash_generated_field = "61E8D314E43B3B5F33274C2B5F732032")

    protected byte[] decodingTable = new byte[128];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.963 -0400", hash_original_method = "680D3875922DD4E67C0EE2E950D928BD", hash_generated_method = "AABF19D4D0BC5EA370D8438ED4D196CF")
    public  Base64Encoder() {
        initialiseDecodingTable();
        // ---------- Original Method ----------
        //initialiseDecodingTable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.964 -0400", hash_original_method = "21DA0B3C66110012AEC4B0EF8A985DB1", hash_generated_method = "C3C116EAADBCF8F0520183B5BCA12AA5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.975 -0400", hash_original_method = "9CA1F48AAB7841E0E0CBD16E0BA7D360", hash_generated_method = "C9BC77857E3EEB884DE50AD315917476")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2119163047 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2119163047;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.988 -0400", hash_original_method = "1B2A7D609CA1F47FC87AA118398B5C86", hash_generated_method = "B20F8D6F790B5439BB5F88DEAC9BFA27")
    private boolean ignore(
        char    c) {
        addTaint(c);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1402066706 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1402066706;
        // ---------- Original Method ----------
        //return (c == '\n' || c =='\r' || c == '\t' || c == ' ');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.991 -0400", hash_original_method = "211C1414D28F35039504B68D95AB9ED9", hash_generated_method = "74536BC3B4C9A194B3654DC981438AFA")
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
                boolean var8734AAABA8B2B8BCF029CC1C18593F13_1230395223 = (!ignore((char)data[end - 1]));
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273426165 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273426165;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.007 -0400", hash_original_method = "1225BA5A886EEC007862013ADD842450", hash_generated_method = "BF1984EBA78A4BFCE2F9C8DDAAB0484A")
    private int nextI(byte[] data, int i, int finish) {
        {
            boolean var284A5091A1A635AAB256EACDF893A56A_451585735 = ((i < finish) && ignore((char)data[i]));
        } //End collapsed parenthetic
        addTaint(data[0]);
        addTaint(i);
        addTaint(finish);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238308103 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238308103;
        // ---------- Original Method ----------
        //while ((i < finish) && ignore((char)data[i]))
        //{
            //i++;
        //}
        //return i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.017 -0400", hash_original_method = "304E01512ABEE5D32E29AD105C8F9759", hash_generated_method = "E950DEE8F8EAE1BC22C39E0F056D170B")
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
                boolean varC2A9184A6FDB10F7AA879085E67E2E47_249188005 = (!ignore(data.charAt(end - 1)));
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_170488517 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_170488517;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.018 -0400", hash_original_method = "9E52D5CA91DB497317BE2B1E69827671", hash_generated_method = "9123DAE215607D8E278B0CFA04B4FDCD")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059509861 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059509861;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.020 -0400", hash_original_method = "4A002F2B2C5A42BB007C07A5E9BC2D50", hash_generated_method = "EE8CA71CE33D91E13E8662D90809AEAF")
    private int nextI(String data, int i, int finish) {
        {
            boolean varA9105DFAE90C03A8F17A10F45775F060_2082844351 = ((i < finish) && ignore(data.charAt(i)));
        } //End collapsed parenthetic
        addTaint(data.getTaint());
        addTaint(i);
        addTaint(finish);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_51386094 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_51386094;
        // ---------- Original Method ----------
        //while ((i < finish) && ignore(data.charAt(i)))
        //{
            //i++;
        //}
        //return i;
    }

    
}

