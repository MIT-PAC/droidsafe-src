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


package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public abstract class SIPHeaderNamesCache {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.007 -0500", hash_original_method = "33ED352FA65DF9495F02E79B54AC6C8B", hash_generated_method = "7BDA4AA0B3380EEBA1F0140C36E7FE2A")
    
public static String toLowerCase(String headerName) {
        String lowerCase = (String) lowercaseMap.get(headerName);
        if (lowerCase == null) {
            return headerName.toLowerCase();
        }
        else {
            return lowerCase;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.003 -0500", hash_original_field = "24E4C15E5A48493C6D507B2DBD2504E4", hash_generated_field = "020672DDF8B640C88D89F337A5ED11A7")

    private static final HashMap lowercaseMap = new HashMap();
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.359 -0400", hash_original_method = "8D520759A4CF14512CFF6A3164E1C68E", hash_generated_method = "8D520759A4CF14512CFF6A3164E1C68E")
    public SIPHeaderNamesCache ()
    {
        //Synthesized constructor
    }
    static {
        Field[] fields = SIPHeaderNames.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.getType().equals(String.class) && Modifier.isStatic(field.getModifiers())) {
                try {
                    String value = (String) field.get(null);
                    String lowerCase = value.toLowerCase();
                    lowercaseMap.put(value, lowerCase);
                    lowercaseMap.put(lowerCase, lowerCase);
                } catch (IllegalAccessException e) {
                }
            }
        }
    }
    
}

