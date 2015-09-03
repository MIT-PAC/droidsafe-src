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


package javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.address.URI;

public interface Request extends Message {
    String ACK = "ACK";
    String BYE = "BYE";
    String CANCEL = "CANCEL";
    String INVITE = "INVITE";
    String OPTIONS = "OPTIONS";
    String REGISTER = "REGISTER";

    String INFO = "INFO";
    String MESSAGE = "MESSAGE";
    String NOTIFY = "NOTIFY";
    String PRACK = "PRACK";
    String PUBLISH = "PUBLISH";
    String REFER = "REFER";
    String SUBSCRIBE = "SUBSCRIBE";
    String UPDATE = "UPDATE";

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getMethod();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setMethod(String method) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    URI getRequestURI();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setRequestURI(URI requestURI);
}
