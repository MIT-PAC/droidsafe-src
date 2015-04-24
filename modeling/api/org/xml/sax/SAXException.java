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


package org.xml.sax;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SAXException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.841 -0500", hash_original_field = "2CBC6074DF6BD2C2AC2A7CA4BC170BEC", hash_generated_field = "D119ECBE245114B57E6DAA6B4729E50B")

    // Internal state.
    //////////////////////////////////////////////////////////////////////

    /**
     * @serial The embedded exception if tunnelling, or null.
     */
    private Exception exception;

    /**
     * Create a new SAXException.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.824 -0500", hash_original_method = "D831304643C6F5E396859CE263E8CD25", hash_generated_method = "B7D291EEFF0635366305D2FB3943B22D")
    
public SAXException ()
    {
    this.exception = null;
    }

    /**
     * Create a new SAXException.
     *
     * @param message The error or warning message.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.827 -0500", hash_original_method = "0B6772DEF84C5953639B673A22CD2D87", hash_generated_method = "ED8B68B0FCFC2C7A0FAC4B07EE3A164E")
    
public SAXException (String message) {
    super(message);
    this.exception = null;
    }

    /**
     * Create a new SAXException wrapping an existing exception.
     *
     * <p>The existing exception will be embedded in the new
     * one, and its message will become the default message for
     * the SAXException.</p>
     *
     * @param e The exception to be wrapped in a SAXException.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.830 -0500", hash_original_method = "6C46F13EAE6D974667959E2EC15AB51C", hash_generated_method = "EAE182ADFA1096E87D0B571427DD00B1")
    
public SAXException (Exception e)
    {
    this.exception = e;
    }

    /**
     * Create a new SAXException from an existing exception.
     *
     * <p>The existing exception will be embedded in the new
     * one, but the new exception will have its own message.</p>
     *
     * @param message The detail message.
     * @param e The exception to be wrapped in a SAXException.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.832 -0500", hash_original_method = "DAF90944A95CF29FF719B165EE1D8D20", hash_generated_method = "990FDF776B367C7195C0BB56AF792134")
    
public SAXException (String message, Exception e)
    {
    super(message);
    this.exception = e;
    }

    /**
     * Return a detail message for this exception.
     *
     * <p>If there is an embedded exception, and if the SAXException
     * has no detail message of its own, this method will return
     * the detail message from the embedded exception.</p>
     *
     * @return The error or warning message.
     */
    @DSComment("no input, no suspicious activity and just exception")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.835 -0500", hash_original_method = "7F1A7B3B4DC8BE54F069CECA78CE108B", hash_generated_method = "12DA191F9DBC64AF796DE8AD6D0DE39C")
    
public String getMessage ()
    {
    String message = super.getMessage();

    if (message == null && exception != null) {
        return exception.getMessage();
    } else {
        return message;
    }
    }

    /**
     * Return the embedded exception, if any.
     *
     * @return The embedded exception, or null if there is none.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.837 -0500", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "98F36C2AFC36910DAB242F709A323B7F")
    
public Exception getException ()
    {
    return exception;
    }

    /**
     * Override toString to pick up any embedded exception.
     *
     * @return A string representation of this exception.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.839 -0500", hash_original_method = "0BE493810C06D201F4519F1260F94FAA", hash_generated_method = "6F181929656BA071E37B5E490E472B19")
    
public String toString ()
    {
    if (exception != null) {
        return exception.toString();
    } else {
        return super.toString();
    }
    }
    
}

