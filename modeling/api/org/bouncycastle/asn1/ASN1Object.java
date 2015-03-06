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


package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public abstract class ASN1Object extends DERObject {
    /**
     * Create a base ASN.1 object from a byte stream.
     *
     * @param data the byte stream to parse.
     * @return the base ASN.1 object represented by the byte stream.
     * @exception IOException if there is a problem parsing the data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.509 -0500", hash_original_method = "F3F9FDCE1484676B88E382A49EC8877F", hash_generated_method = "E98CBD85708A9D853A0E84BBC5FA6CF1")
    
public static ASN1Object fromByteArray(byte[] data)
        throws IOException
    {
        ASN1InputStream aIn = new ASN1InputStream(data);

        try
        {
            return (ASN1Object)aIn.readObject();
        }
        catch (ClassCastException e)
        {
            throw new IOException("cannot recognise object in stream");    
        }
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.695 -0400", hash_original_method = "79A6503CF02D2BF6CA7C22C7ECE56A0E", hash_generated_method = "79A6503CF02D2BF6CA7C22C7ECE56A0E")
    public ASN1Object ()
    {
        //Synthesized constructor
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.513 -0500", hash_original_method = "DA81A9CF27CE7E2A8EA2EF36D7C19ED4", hash_generated_method = "50FE23521D15EE8C8DA07960EFA62A4B")
    
public final boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        
        return (o instanceof DEREncodable) && asn1Equals(((DEREncodable)o).getDERObject());
    }

    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.515 -0500", hash_original_method = "55C270AB7FB96DF5C59CA61A88D62880", hash_generated_method = "6DC7B39669B69F5C42BF1BAC2411F684")
    
public abstract int hashCode();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.517 -0500", hash_original_method = "A1E289DFE0364C85836C0C8908499825", hash_generated_method = "877693E84D45EBE13EC3671BCE6F2F0C")
    
abstract void encode(DEROutputStream out) throws IOException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.519 -0500", hash_original_method = "9B1584085CB3DA0B43C545974B62199A", hash_generated_method = "80B4EC24E81346A160DD4F33616FE8AD")
    
abstract boolean asn1Equals(DERObject o);
    
}

