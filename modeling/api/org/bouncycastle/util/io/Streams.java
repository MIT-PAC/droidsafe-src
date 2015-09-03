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


package org.bouncycastle.util.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class Streams {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.756 -0500", hash_original_method = "B652CC7FFE463ED9BB2F1EA52C4B64E0", hash_generated_method = "269D98D0B99CDBE9FDD076841803007C")
    
public static void drain(InputStream inStr)
        throws IOException
    {
        byte[] bs = new byte[BUFFER_SIZE];
        while (inStr.read(bs, 0, bs.length) >= 0)
        {
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.758 -0500", hash_original_method = "2073459F803DF81B173DB2DFE6D0D68D", hash_generated_method = "0ADB0E716B30E1C7F634925756BE3848")
    
public static byte[] readAll(InputStream inStr)
        throws IOException
    {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        pipeAll(inStr, buf);
        return buf.toByteArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.761 -0500", hash_original_method = "5A1F12ABC5C650A54FE8C7454204C2F4", hash_generated_method = "E65C56F91007251195DF2704F48AB41B")
    
public static byte[] readAllLimited(InputStream inStr, int limit)
        throws IOException
    {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        pipeAllLimited(inStr, limit, buf);
        return buf.toByteArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.763 -0500", hash_original_method = "6DA0ABA711AB2E85DAF7983F7ACBF524", hash_generated_method = "D451F035543BE18BBAAE67EBA36D6590")
    
public static int readFully(InputStream inStr, byte[] buf)
        throws IOException
    {
        return readFully(inStr, buf, 0, buf.length);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.765 -0500", hash_original_method = "589CAA22439F2CF8C22C8F9EEBC74A97", hash_generated_method = "6B3C258AEB1893368BBDAE242A0B850A")
    
public static int readFully(InputStream inStr, byte[] buf, int off, int len)
        throws IOException
    {
        int totalRead = 0;
        while (totalRead < len)
        {
            int numRead = inStr.read(buf, off + totalRead, len - totalRead);
            if (numRead < 0)
            {
                break;
            }
            totalRead += numRead;
        }
        return totalRead;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.768 -0500", hash_original_method = "4AA97A5BDB9254BF6F61CE08E939FF60", hash_generated_method = "BAF140A7D3021ADC5CFEDEB5459CFB5C")
    
public static void pipeAll(InputStream inStr, OutputStream outStr)
        throws IOException
    {
        byte[] bs = new byte[BUFFER_SIZE];
        int numRead;
        while ((numRead = inStr.read(bs, 0, bs.length)) >= 0)
        {
            outStr.write(bs, 0, numRead);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.771 -0500", hash_original_method = "2F580BDBC98383E95352A5A31F132FFC", hash_generated_method = "527A8DD38EE6703A8F15A3D0F1674D63")
    
public static long pipeAllLimited(InputStream inStr, long limit, OutputStream outStr)
        throws IOException
    {
        long total = 0;
        byte[] bs = new byte[BUFFER_SIZE];
        int numRead;
        while ((numRead = inStr.read(bs, 0, bs.length)) >= 0)
        {
            total += numRead;
            if (total > limit)
            {
                throw new StreamOverflowException("Data Overflow");
            }
            outStr.write(bs, 0, numRead);
        }
        return total;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.753 -0500", hash_original_field = "DF06FD606E84A338B25CD7BC1E002FCF", hash_generated_field = "750618C8814E79503D809C74376A5474")

    private static int BUFFER_SIZE = 512;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.352 -0400", hash_original_method = "E89EB8DDFA560D5750506701D7919D33", hash_generated_method = "E89EB8DDFA560D5750506701D7919D33")
    public Streams ()
    {
        //Synthesized constructor
    }
}

