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

public class BERSequenceParser implements ASN1SequenceParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.779 -0500", hash_original_field = "8EE68094F784B2C8EC928CABAEA021F0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.782 -0500", hash_original_method = "0FD98DAB53613A9925FD049FC2961E55", hash_generated_method = "0FD98DAB53613A9925FD049FC2961E55")
    
BERSequenceParser(ASN1StreamParser parser)
    {
        this._parser = parser;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.784 -0500", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "7E945A4F85D137716A9450ED5D0C4580")
    
public DEREncodable readObject()
        throws IOException
    {
        return _parser.readObject();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.787 -0500", hash_original_method = "B637F95456A6C0EC98A52773252AB22D", hash_generated_method = "EAE6724EEB3AC359EB5D7FE2FC860A0A")
    
public DERObject getLoadedObject()
        throws IOException
    {
        return new BERSequence(_parser.readVector());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.790 -0500", hash_original_method = "6EDDECA4629CF39F1ED286974E98F21F", hash_generated_method = "F078EE785C827540DC9A78151C43A9E1")
    
public DERObject getDERObject()
    {
        try
        {
            return getLoadedObject();
        }
        catch (IOException e)
        {
            throw new IllegalStateException(e.getMessage());
        }
    }
    
}

