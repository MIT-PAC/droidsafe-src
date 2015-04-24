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
import java.io.InputStream;

public class BERTaggedObjectParser implements ASN1TaggedObjectParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.283 -0500", hash_original_field = "4F1C26654B974974351F1EDCF6C06339", hash_generated_field = "FF4CF5F81862B8524694C4DB9DDE635D")

    private boolean _constructed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.285 -0500", hash_original_field = "9981A9A2614293E8212A81751DA506A0", hash_generated_field = "62F1DF151C857CACD0771E182D275DC9")

    private int _tagNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.287 -0500", hash_original_field = "8EE68094F784B2C8EC928CABAEA021F0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;

    /**
     * @deprecated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.290 -0500", hash_original_method = "CEDFC0E6C0BD9B3FF1D771A70B508D94", hash_generated_method = "804464B19848CD6A6E25EFF6A8B39B5B")
    
protected BERTaggedObjectParser(
        int         baseTag,
        int         tagNumber,
        InputStream contentStream)
    {
        this((baseTag & DERTags.CONSTRUCTED) != 0, tagNumber, new ASN1StreamParser(contentStream));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.292 -0500", hash_original_method = "641FC71F34D5E5D1E36A069067B2FFCA", hash_generated_method = "641FC71F34D5E5D1E36A069067B2FFCA")
    
BERTaggedObjectParser(
        boolean             constructed,
        int                 tagNumber,
        ASN1StreamParser    parser)
    {
        _constructed = constructed;
        _tagNumber = tagNumber;
        _parser = parser;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.295 -0500", hash_original_method = "E640F7F01BC858A63ED48B7251E0457D", hash_generated_method = "75AEA0A69C14109A7C0185E302BBB520")
    
public boolean isConstructed()
    {
        return _constructed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.297 -0500", hash_original_method = "B35ABF3B77036668E0072FBBE52EC3E8", hash_generated_method = "2B25292ABF411168D6C66CC102953E29")
    
public int getTagNo()
    {
        return _tagNumber;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.299 -0500", hash_original_method = "4AD739EA93AB775B40026E215844A8E7", hash_generated_method = "203FFE5285123EE6D9388923892AD264")
    
public DEREncodable getObjectParser(
        int     tag,
        boolean isExplicit)
        throws IOException
    {
        if (isExplicit)
        {
            if (!_constructed)
            {
                throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
            }
            return _parser.readObject();
        }

        return _parser.readImplicit(_constructed, tag);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.302 -0500", hash_original_method = "966C66B264046D402E2F3ED8541B4BF3", hash_generated_method = "F7339538B23916162D3B7B2F41690A46")
    
public DERObject getLoadedObject()
        throws IOException
    {
        return _parser.readTaggedObject(_constructed, _tagNumber);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.305 -0500", hash_original_method = "8993E91076953DCCDD0896DB0B3E91BE", hash_generated_method = "5682154552862BB526909198AA97FE3B")
    
public DERObject getDERObject()
    {
        try
        {
            return this.getLoadedObject();
        }
        catch (IOException e)
        {
            throw new ASN1ParsingException(e.getMessage());
        }
    }
    
}

