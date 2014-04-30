package org.bouncycastle.util.encoders;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;

public class Base64Encoder implements Encoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.752 -0500", hash_original_field = "7D8F2FE1CCEB256677F2F8E9B55EA9C3", hash_generated_field = "477367DCA11A991FB18CE4EB6F2C01EF")

    protected final byte[] encodingTable =
        {
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.754 -0500", hash_original_field = "964DEF16619AEC1A1F52C43393D47E4E", hash_generated_field = "6470484C1DBA83A435D7A06D16D20315")

    protected byte    padding = (byte)'=';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.757 -0500", hash_original_field = "7BCD267FFEC083ECBC844975547427DE", hash_generated_field = "C5A9E5FA83A75FCB14FF277263CBAED5")

    protected final byte[] decodingTable = new byte[128];
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.761 -0500", hash_original_method = "680D3875922DD4E67C0EE2E950D928BD", hash_generated_method = "B387633520154ABC53B389F20BADAA16")
    
public Base64Encoder()
    {
        initialiseDecodingTable();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.759 -0500", hash_original_method = "21DA0B3C66110012AEC4B0EF8A985DB1", hash_generated_method = "951194B60192112273282AAFACAAC758")
    
protected void initialiseDecodingTable()
    {
        for (int i = 0; i < encodingTable.length; i++)
        {
            decodingTable[encodingTable[i]] = (byte)i;
        }
    }
    
    /**
     * encode the input data producing a base 64 output stream.
     *
     * @return the number of bytes produced.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.765 -0500", hash_original_method = "9CA1F48AAB7841E0E0CBD16E0BA7D360", hash_generated_method = "C24E5F8DB02F00BA8662CCB70872BDB9")
    
public int encode(
        byte[]                data,
        int                    off,
        int                    length,
        OutputStream    out) 
        throws IOException
    {
        int modulus = length % 3;
        int dataLength = (length - modulus);
        int a1, a2, a3;
        
        for (int i = off; i < off + dataLength; i += 3)
        {
            a1 = data[i] & 0xff;
            a2 = data[i + 1] & 0xff;
            a3 = data[i + 2] & 0xff;

            out.write(encodingTable[(a1 >>> 2) & 0x3f]);
            out.write(encodingTable[((a1 << 4) | (a2 >>> 4)) & 0x3f]);
            out.write(encodingTable[((a2 << 2) | (a3 >>> 6)) & 0x3f]);
            out.write(encodingTable[a3 & 0x3f]);
        }

        /*
         * process the tail end.
         */
        int    b1, b2, b3;
        int    d1, d2;

        switch (modulus)
        {
        case 0:        /* nothing left to do */
            break;
        case 1:
            d1 = data[off + dataLength] & 0xff;
            b1 = (d1 >>> 2) & 0x3f;
            b2 = (d1 << 4) & 0x3f;

            out.write(encodingTable[b1]);
            out.write(encodingTable[b2]);
            out.write(padding);
            out.write(padding);
            break;
        case 2:
            d1 = data[off + dataLength] & 0xff;
            d2 = data[off + dataLength + 1] & 0xff;

            b1 = (d1 >>> 2) & 0x3f;
            b2 = ((d1 << 4) | (d2 >>> 4)) & 0x3f;
            b3 = (d2 << 2) & 0x3f;

            out.write(encodingTable[b1]);
            out.write(encodingTable[b2]);
            out.write(encodingTable[b3]);
            out.write(padding);
            break;
        }

        return (dataLength / 3) * 4 + ((modulus == 0) ? 0 : 4);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.767 -0500", hash_original_method = "1B2A7D609CA1F47FC87AA118398B5C86", hash_generated_method = "60BA6438BF0D7F2A1A9CF731E65332DE")
    
private boolean ignore(
        char    c)
    {
        return (c == '\n' || c =='\r' || c == '\t' || c == ' ');
    }
    
    /**
     * decode the base 64 encoded byte data writing it to the given output stream,
     * whitespace characters will be ignored.
     *
     * @return the number of bytes produced.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.770 -0500", hash_original_method = "211C1414D28F35039504B68D95AB9ED9", hash_generated_method = "E118D82FD0BD87AB0C9285CEF8D7FAF6")
    
public int decode(
        byte[]          data,
        int             off,
        int             length,
        OutputStream    out)
        throws IOException
    {
        byte    b1, b2, b3, b4;
        int     outLen = 0;
        
        int     end = off + length;
        
        while (end > off)
        {
            if (!ignore((char)data[end - 1]))
            {
                break;
            }
            
            end--;
        }
        
        int  i = off;
        int  finish = end - 4;
        
        i = nextI(data, i, finish);

        while (i < finish)
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
        }

        outLen += decodeLastBlock(out, (char)data[end - 4], (char)data[end - 3], (char)data[end - 2], (char)data[end - 1]);
        
        return outLen;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.773 -0500", hash_original_method = "1225BA5A886EEC007862013ADD842450", hash_generated_method = "37957A74CE8A40AAEB855AC2EA497CE3")
    
private int nextI(byte[] data, int i, int finish)
    {
        while ((i < finish) && ignore((char)data[i]))
        {
            i++;
        }
        return i;
    }
    
    /**
     * decode the base 64 encoded String data writing it to the given output stream,
     * whitespace characters will be ignored.
     *
     * @return the number of bytes produced.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.776 -0500", hash_original_method = "304E01512ABEE5D32E29AD105C8F9759", hash_generated_method = "E555224E61F1C778AAEA4DCB3127EC03")
    
public int decode(
        String          data,
        OutputStream    out)
        throws IOException
    {
        byte    b1, b2, b3, b4;
        int     length = 0;
        
        int     end = data.length();
        
        while (end > 0)
        {
            if (!ignore(data.charAt(end - 1)))
            {
                break;
            }
            
            end--;
        }
        
        int  i = 0;
        int  finish = end - 4;
        
        i = nextI(data, i, finish);
        
        while (i < finish)
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
        }

        length += decodeLastBlock(out, data.charAt(end - 4), data.charAt(end - 3), data.charAt(end - 2), data.charAt(end - 1));

        return length;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.779 -0500", hash_original_method = "9E52D5CA91DB497317BE2B1E69827671", hash_generated_method = "B4F5DB34AA16E31D3C680C912806CC93")
    
private int decodeLastBlock(OutputStream out, char c1, char c2, char c3, char c4) 
        throws IOException
    {
        byte    b1, b2, b3, b4;
        
        if (c3 == padding)
        {
            b1 = decodingTable[c1];
            b2 = decodingTable[c2];

            out.write((b1 << 2) | (b2 >> 4));
            
            return 1;
        }
        else if (c4 == padding)
        {
            b1 = decodingTable[c1];
            b2 = decodingTable[c2];
            b3 = decodingTable[c3];

            out.write((b1 << 2) | (b2 >> 4));
            out.write((b2 << 4) | (b3 >> 2));
            
            return 2;
        }
        else
        {
            b1 = decodingTable[c1];
            b2 = decodingTable[c2];
            b3 = decodingTable[c3];
            b4 = decodingTable[c4];

            out.write((b1 << 2) | (b2 >> 4));
            out.write((b2 << 4) | (b3 >> 2));
            out.write((b3 << 6) | b4);
            
            return 3;
        } 
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.781 -0500", hash_original_method = "4A002F2B2C5A42BB007C07A5E9BC2D50", hash_generated_method = "34DC841B1744328FA68084198AF9D2F3")
    
private int nextI(String data, int i, int finish)
    {
        while ((i < finish) && ignore(data.charAt(i)))
        {
            i++;
        }
        return i;
    }
    
}

