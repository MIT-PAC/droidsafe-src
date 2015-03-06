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


package javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.InvalidArgumentException;

public interface WarningHeader extends Header {
    String NAME = "Warning";

    int ATTRIBUTE_NOT_UNDERSTOOD = 10;
    int INCOMPATIBLE_BANDWIDTH_UNITS = 20;
    int INCOMPATIBLE_MEDIA_FORMAT = 21;
    int INCOMPATIBLE_NETWORK_ADDRESS_FORMATS = 22;
    int INCOMPATIBLE_NETWORK_PROTOCOL = 23;
    int INCOMPATIBLE_TRANSPORT_PROTOCOL = 24;
    int INSUFFICIENT_BANDWIDTH = 30;
    int MEDIA_TYPE_NOT_AVAILABLE = 40;
    int MISCELLANEOUS_WARNING = 99;
    int MULTICAST_NOT_AVAILABLE = 50;
    int SESSION_DESCRIPTION_PARAMETER_NOT_UNDERSTOOD = 60;
    int UNICAST_NOT_AVAILABLE = 51;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getAgent();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setAgent(String agent) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getCode();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setCode(int code) throws InvalidArgumentException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getText();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setText(String text) throws ParseException;
}
