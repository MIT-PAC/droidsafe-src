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


package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;

public class PAssertedService extends SIPHeader implements PAssertedServiceHeader, SIPHeaderNamesIms, ExtensionHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.415 -0500", hash_original_field = "DFC659C097418CBB8C1EC0C3D50D53A5", hash_generated_field = "8B30B176BF34BEC26AF3F3FDA86A1827")

    private String subServiceIds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.418 -0500", hash_original_field = "F3C636661E9DFC4BE76EFDD1192193F4", hash_generated_field = "7976ED8892ABC041E4713F4D251EC3B6")

    private String subAppIds;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.422 -0500", hash_original_method = "182ECFD494AF5D51867F4CB3F9E644EB", hash_generated_method = "09CFDC55C90B392B9381E44260A66A2F")
    
protected PAssertedService(String name) {
        super(NAME);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.425 -0500", hash_original_method = "AA5E567A5261831D339C7F3E134619EA", hash_generated_method = "3FC74D34556E6AD4E53A3DA7F74BCDAE")
    
public PAssertedService()
    {
        super(P_ASSERTED_SERVICE);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.429 -0500", hash_original_method = "13CD5B55BBBCA0548D99A959291FFE7D", hash_generated_method = "6B6D27B1CD38111B325EFBAF0BC00AC3")
    
@Override
    protected String encodeBody() {
        StringBuffer retval = new StringBuffer();

         retval.append(ParameterNamesIms.SERVICE_ID);

            if(this.subServiceIds!=null)
            {
                retval.append(ParameterNamesIms.SERVICE_ID_LABEL).append(".");

            retval.append(this.getSubserviceIdentifiers());
            }

            else if(this.subAppIds!=null)
            {
                retval.append(ParameterNamesIms.APPLICATION_ID_LABEL).append(".");
                retval.append(this.getApplicationIdentifiers());
            }

        return retval.toString();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.433 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException {
        throw new ParseException(value,0);

    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.436 -0500", hash_original_method = "C9711D50FDDAB1BC6FA9D8BEA3306598", hash_generated_method = "2842ECCF63E9B5B0D67C0A2BA561F8D8")
    
public String getApplicationIdentifiers() {
        if(this.subAppIds.charAt(0)=='.')
        {
            return this.subAppIds.substring(1);
        }
        return this.subAppIds;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.439 -0500", hash_original_method = "A7D1F6103283AF549702A3BD8A97DA85", hash_generated_method = "27F97AB6043CB4E046CD52AE7285A1C0")
    
public String getSubserviceIdentifiers() {
        if(this.subServiceIds.charAt(0)=='.')
        {
            return this.subServiceIds.substring(1);
        }
        return this.subServiceIds;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.443 -0500", hash_original_method = "0A65ED1D7958A8DC93D54B9D5172FB86", hash_generated_method = "3D8529127ACBC325EB4C6076AAA545EE")
    
public void setApplicationIdentifiers(String appids) {
        this.subAppIds = appids;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.447 -0500", hash_original_method = "D85C3DD3D271FDFF4F350559A8282CAD", hash_generated_method = "B3F61474C66A9562D445B588BC188B75")
    
public void setSubserviceIdentifiers(String subservices) {
        this.subServiceIds = subservices;

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.450 -0500", hash_original_method = "698565353F33C32BACB06EBECCB2189D", hash_generated_method = "D4675B044AE17CCD0B469CDC1735AD2E")
    
public boolean equals(Object other)
    {
        return (other instanceof PAssertedServiceHeader) && super.equals(other);

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.453 -0500", hash_original_method = "3CDC6738E06A7AFD0A34818FC063034A", hash_generated_method = "EC849A5DD26DA0B0853E15F6B153DE3D")
    
public Object clone() {
        PAssertedService retval = (PAssertedService) super.clone();
        return retval;
    }
    
}

