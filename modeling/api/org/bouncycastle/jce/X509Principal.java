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


package org.bouncycastle.jce;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.Principal;
import java.util.Hashtable;
import java.util.Vector;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.X509Name;

public class X509Principal extends X509Name implements Principal {
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.906 -0500", hash_original_method = "FF25B788711032BAC2432264078A15A6", hash_generated_method = "C85E6D520322491A08965914F5D7DC41")
    
private static ASN1Sequence readSequence(
        ASN1InputStream aIn)
        throws IOException
    {
        try
        {
            return ASN1Sequence.getInstance(aIn.readObject());
        }
        catch (IllegalArgumentException e)
        {
            throw new IOException("not an ASN.1 Sequence: " + e);
        }
    }

    /**
     * Constructor from an encoded byte array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.908 -0500", hash_original_method = "B0820FF823FE44437CE57E7CCF385599", hash_generated_method = "CA74E8C7D88A42EFBB18A00E67A1D68A")
    
public X509Principal(
        byte[]  bytes)
        throws IOException
    {
        super(readSequence(new ASN1InputStream(bytes)));
    }

    /**
     * Constructor from an X509Name object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.911 -0500", hash_original_method = "0E5AD6E3648EC2E4F0A2CBF76D62FE6E", hash_generated_method = "E78037CFF08527AE2EF495FE4A4B4A98")
    
public X509Principal(
        X509Name  name)
    {
        super((ASN1Sequence)name.getDERObject());
    }

    /**
     * constructor from a table of attributes.
     * <p>
     * it's is assumed the table contains OID/String pairs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.913 -0500", hash_original_method = "D3D6DABF2D2EE8D49403BBA6B447728D", hash_generated_method = "EAC42D76D31BFEE11EC5A8C55BF6085D")
    
public X509Principal(
        Hashtable  attributes)
    {
        super(attributes);
    }

    /**
     * constructor from a table of attributes and a vector giving the
     * specific ordering required for encoding or conversion to a string.
     * <p>
     * it's is assumed the table contains OID/String pairs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.916 -0500", hash_original_method = "33C0081C021F2AA73D8ACD68C98658C4", hash_generated_method = "3A690507D7EFEDE1986EFB1F448A33BA")
    
public X509Principal(
        Vector      ordering,
        Hashtable   attributes)
    {
        super(ordering, attributes);
    }

    /**
     * constructor from a vector of attribute values and a vector of OIDs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.918 -0500", hash_original_method = "3B6A04762F0F16A7BA4938718F609D48", hash_generated_method = "702E61657B9B14A8FDF04FF71D421185")
    
public X509Principal(
        Vector      oids,
        Vector      values)
    {
        super(oids, values);
    }

    /**
     * takes an X509 dir name as a string of the format "C=AU,ST=Victoria", or
     * some such, converting it into an ordered set of name attributes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.922 -0500", hash_original_method = "3167ECA848A59D0FB98E0257E20EB2C0", hash_generated_method = "ACC8505AA35F49E36D783FB341A67AE3")
    
public X509Principal(
        String  dirName)
    {
        super(dirName);
    }

    /**
     * Takes an X509 dir name as a string of the format "C=AU,ST=Victoria", or
     * some such, converting it into an ordered set of name attributes. If reverse
     * is false the dir name will be encoded in the order of the (name, value) pairs 
     * presented, otherwise the encoding will start with the last (name, value) pair
     * and work back.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.924 -0500", hash_original_method = "8E38511E2EC0E52F81E91783DD99493A", hash_generated_method = "39D05B985C35F2EB9E6449B0282F5D02")
    
public X509Principal(
        boolean reverse,
        String  dirName)
    {
        super(reverse, dirName);
    }

    /**
     * Takes an X509 dir name as a string of the format "C=AU, ST=Victoria", or
     * some such, converting it into an ordered set of name attributes. lookUp 
     * should provide a table of lookups, indexed by lowercase only strings and
     * yielding a DERObjectIdentifier, other than that OID. and numeric oids
     * will be processed automatically.
     * <p>
     * If reverse is true, create the encoded version of the sequence starting
     * from the last element in the string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.927 -0500", hash_original_method = "F7CF19656BE8328A59A7894CA6394ACC", hash_generated_method = "0B3728CF8B8DA8C27F7F140B7B7A8341")
    
public X509Principal(
        boolean     reverse,
        Hashtable   lookUp,
        String      dirName)
    {
        super(reverse, lookUp, dirName);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.929 -0500", hash_original_method = "73EC4210941682DD4DF1478421683765", hash_generated_method = "BF6AC6A6C5815BB61FD26F74E679ED31")
    
public String getName()
    {
        return this.toString();
    }

    /**
     * return a DER encoded byte array representing this object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.931 -0500", hash_original_method = "FFCAA10D74329AA15B8FE83335744F82", hash_generated_method = "DCCE93F4D0141431F9D725745B73FBC0")
    
public byte[] getEncoded()
    {
        try
        {
            return this.getEncoded(ASN1Encodable.DER);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.toString());
        }
    }
    
}

