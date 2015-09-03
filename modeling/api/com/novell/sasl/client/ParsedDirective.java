/* **************************************************************************
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
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * $OpenLDAP: /com/novell/sasl/client/ParsedDirective.java,v 1.1 2003/08/21 10:06:26 kkanil Exp $
 *
 * Copyright (C) 2002 Novell, Inc. All Rights Reserved.
 *
 * THIS WORK IS SUBJECT TO U.S. AND INTERNATIONAL COPYRIGHT LAWS AND
 * TREATIES. USE, MODIFICATION, AND REDISTRIBUTION OF THIS WORK IS SUBJECT
 * TO VERSION 2.0.1 OF THE OPENLDAP PUBLIC LICENSE, A COPY OF WHICH IS
 * AVAILABLE AT HTTP://WWW.OPENLDAP.ORG/LICENSE.HTML OR IN THE FILE "LICENSE"
 * IN THE TOP-LEVEL DIRECTORY OF THE DISTRIBUTION. ANY USE OR EXPLOITATION
 * OF THIS WORK OTHER THAN AS AUTHORIZED IN VERSION 2.0.1 OF THE OPENLDAP
 * PUBLIC LICENSE, OR OTHER PRIOR WRITTEN CONSENT FROM NOVELL, COULD SUBJECT
 * THE PERPETRATOR TO CRIMINAL AND CIVIL LIABILITY.
 ******************************************************************************/

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.novell.sasl.client;

/**
 * Implements the ParsedDirective class which will be used in the
 * DigestMD5SaslClient mechanism.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
class ParsedDirective
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.260 -0400", hash_original_field = "517C2D2B1C722B3FD5A0E6A2BDB36A98", hash_generated_field = "08F351EF4B22C2E5CEBDEDC96BDB35B4")

    public static final int  QUOTED_STRING_VALUE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.260 -0400", hash_original_field = "E488C05BEE4D16E7F4CF785600F61210", hash_generated_field = "982BA3C4D8CA28479D9AFD7DCA1F61E8")

    public static final int  TOKEN_VALUE         = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.261 -0400", hash_original_field = "243F181D52E63FECC1FB83CD97D8064D", hash_generated_field = "BE0F00BAE7B5E4F58683DF87B47D8119")


    private int     m_valueType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.261 -0400", hash_original_field = "13AB2398CA36E6A25E8247EE6DFFDE86", hash_generated_field = "C153EEDA14CBB033B58C1E9DADC927A8")

    private String  m_name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.261 -0400", hash_original_field = "554AEF2CE0E90F29C0F0E8FCB7F9B5F1", hash_generated_field = "443FFA3B09C19743C9AFF136DC51E583")

    private String  m_value;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.262 -0400", hash_original_method = "55A5268668477CAD6067BC7D32858821", hash_generated_method = "55A5268668477CAD6067BC7D32858821")
    
ParsedDirective(
        String  name,
        String  value,
        int     type)
    {
        m_name = name;
        m_value = value;
        m_valueType = type;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.262 -0400", hash_original_method = "482580CB8625B895BE13B72AE9178A62", hash_generated_method = "482580CB8625B895BE13B72AE9178A62")
    
String getValue()
    {
        return m_value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.262 -0400", hash_original_method = "6634FDEC7B3B49A74F0FF399FE9B06DF", hash_generated_method = "6634FDEC7B3B49A74F0FF399FE9B06DF")
    
String getName()
    {
        return m_name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.263 -0400", hash_original_method = "958B2C30398A2DA46D5AE9728D30CB31", hash_generated_method = "958B2C30398A2DA46D5AE9728D30CB31")
    
int getValueType()
    {
        return m_valueType;
    }

}

