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





public class OIDTokenizer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.142 -0500", hash_original_field = "9C420410CA5A3136C0764F58D4287A0B", hash_generated_field = "D745B114B0A51171DAD36F87C0CC38B4")

    private String  oid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.145 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int     index;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.148 -0500", hash_original_method = "88D58AFE0405FCD9AB8F5CA4BE2D1534", hash_generated_method = "F9201CCECE94837619BE562993F21309")
    
public OIDTokenizer(
        String oid)
    {
        this.oid = oid;
        this.index = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.150 -0500", hash_original_method = "F35D489C40702BC97B5927032D797DB7", hash_generated_method = "089986D074A3455ED2BCC78F70C2FC5A")
    
public boolean hasMoreTokens()
    {
        return (index != -1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.153 -0500", hash_original_method = "4BAC87A2A9C681CC296BE2241CAA6D87", hash_generated_method = "81407B15D41440E84EB8A71FEB2F7BA4")
    
public String nextToken()
    {
        if (index == -1)
        {
            return null;
        }

        String  token;
        int     end = oid.indexOf('.', index);

        if (end == -1)
        {
            token = oid.substring(index);
            index = -1;
            return token;
        }

        token = oid.substring(index, end);

        index = end + 1;
        return token;
    }

    
}

