/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.bouncycastle.util.encoders;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;

public class HexEncoder implements Encoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.937 -0500", hash_original_field = "7FA8FF18999900E041AAF542525E3F2C", hash_generated_field = "A8D4DC408DE84610D910B7400C27CA50")

    protected final byte[] encodingTable =
        {
            (byte)'0', (byte)'1', (byte)'2', (byte)'3', (byte)'4', (byte)'5', (byte)'6', (byte)'7',
            (byte)'8', (byte)'9', (byte)'a', (byte)'b', (byte)'c', (byte)'d', (byte)'e', (byte)'f'
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.939 -0500", hash_original_field = "7BCD267FFEC083ECBC844975547427DE", hash_generated_field = "C5A9E5FA83A75FCB14FF277263CBAED5")

    protected final byte[] decodingTable = new byte[128];
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.945 -0500", hash_original_method = "E555776B59F5150257DBB59B34D3D923", hash_generated_method = "4BEBC431C17C68B71FC7481A9C7B95D9")
    
public HexEncoder()
    {
        initialiseDecodingTable();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.942 -0500", hash_original_method = "7253B636544E47F410015D46451276E0", hash_generated_method = "F64FAEE1C8F3E8AE7560A93A82009A52")
    
protected void initialiseDecodingTable()
    {
        for (int i = 0; i < encodingTable.length; i++)
        {
            decodingTable[encodingTable[i]] = (byte)i;
        }
        
        decodingTable['A'] = decodingTable['a'];
        decodingTable['B'] = decodingTable['b'];
        decodingTable['C'] = decodingTable['c'];
        decodingTable['D'] = decodingTable['d'];
        decodingTable['E'] = decodingTable['e'];
        decodingTable['F'] = decodingTable['f'];
    }
    
    /**
     * encode the input data producing a Hex output stream.
     *
     * @return the number of bytes produced.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.947 -0500", hash_original_method = "BD9F8FC335D977E935DA4351136AEC70", hash_generated_method = "9C66D4F99612AC7286E6B0458CEBF6F8")
    
public int encode(
        byte[]                data,
        int                    off,
        int                    length,
        OutputStream    out) 
        throws IOException
    {        
        for (int i = off; i < (off + length); i++)
        {
            int    v = data[i] & 0xff;

            out.write(encodingTable[(v >>> 4)]);
            out.write(encodingTable[v & 0xf]);
        }

        return length * 2;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.949 -0500", hash_original_method = "1B2A7D609CA1F47FC87AA118398B5C86", hash_generated_method = "60BA6438BF0D7F2A1A9CF731E65332DE")
    
private boolean ignore(
        char    c)
    {
        return (c == '\n' || c =='\r' || c == '\t' || c == ' ');
    }
    
    /**
     * decode the Hex encoded byte data writing it to the given output stream,
     * whitespace characters will be ignored.
     *
     * @return the number of bytes produced.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.952 -0500", hash_original_method = "B7EDB63E53FAEFA939E2D19889BCA5A2", hash_generated_method = "52EDEE112409FFDDBC0C0F57A75C82A9")
    
public int decode(
        byte[]          data,
        int             off,
        int             length,
        OutputStream    out)
        throws IOException
    {
        byte    b1, b2;
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
        
        int i = off;
        while (i < end)
        {
            while (i < end && ignore((char)data[i]))
            {
                i++;
            }
            
            b1 = decodingTable[data[i++]];
            
            while (i < end && ignore((char)data[i]))
            {
                i++;
            }
            
            b2 = decodingTable[data[i++]];

            out.write((b1 << 4) | b2);
            
            outLen++;
        }

        return outLen;
    }
    
    /**
     * decode the Hex encoded String data writing it to the given output stream,
     * whitespace characters will be ignored.
     *
     * @return the number of bytes produced.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.954 -0500", hash_original_method = "6D8A267573E3557F73C2709EF9053C58", hash_generated_method = "FC4362337D902FF475D471C1057CA6D5")
    
public int decode(
        String          data,
        OutputStream    out)
        throws IOException
    {
        byte    b1, b2;
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
        
        int i = 0;
        while (i < end)
        {
            while (i < end && ignore(data.charAt(i)))
            {
                i++;
            }
            
            b1 = decodingTable[data.charAt(i++)];
            
            while (i < end && ignore(data.charAt(i)))
            {
                i++;
            }
            
            b2 = decodingTable[data.charAt(i++)];

            out.write((b1 << 4) | b2);
            
            length++;
        }

        return length;
    }
    
}

