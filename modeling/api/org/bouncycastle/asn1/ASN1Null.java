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

public abstract class ASN1Null extends ASN1Object {
    // BEGIN android-changed
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.933 -0500", hash_original_method = "D0FE59B1A9D3F66BFB745D7E961EAD28", hash_generated_method = "D0FE59B1A9D3F66BFB745D7E961EAD28")
    
ASN1Null()
    {
    }
    // END android-changed

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.936 -0500", hash_original_method = "8B33772CC706A3F76B2A9FE6D8E11F7C", hash_generated_method = "93D13A02B5288CDAB684DD1656C88C55")
    
public int hashCode()
    {
        return -1;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.938 -0500", hash_original_method = "7109287BD38944677651878D40817EF4", hash_generated_method = "7109287BD38944677651878D40817EF4")
    
boolean asn1Equals(
        DERObject o)
    {
        if (!(o instanceof ASN1Null))
        {
            return false;
        }
        
        return true;
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.941 -0500", hash_original_method = "A1E289DFE0364C85836C0C8908499825", hash_generated_method = "877693E84D45EBE13EC3671BCE6F2F0C")
    
abstract void encode(DEROutputStream out)
        throws IOException;

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.943 -0500", hash_original_method = "BBD03FB924B892CEE23A9F439923567F", hash_generated_method = "C0119794FC8A1C45A3C7985F5B42E8C7")
    
public String toString()
    {
         return "NULL";
    }
    
}

