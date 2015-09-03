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

public interface Response extends Message {
    int TRYING = 100;
    int RINGING = 180;
    int CALL_IS_BEING_FORWARDED = 181;
    int QUEUED = 182;
    int SESSION_PROGRESS = 183;
    int OK = 200;
    int ACCEPTED = 202;
    int MULTIPLE_CHOICES = 300;
    int MOVED_PERMANENTLY = 301;
    int MOVED_TEMPORARILY = 302;
    int USE_PROXY = 305;
    int ALTERNATIVE_SERVICE = 380;
    int BAD_REQUEST = 400;
    int UNAUTHORIZED = 401;
    int PAYMENT_REQUIRED = 402;
    int FORBIDDEN = 403;
    int NOT_FOUND = 404;
    int METHOD_NOT_ALLOWED = 405;
    int NOT_ACCEPTABLE = 406;
    int PROXY_AUTHENTICATION_REQUIRED = 407;
    int REQUEST_TIMEOUT = 408;
    int GONE = 410;
    int CONDITIONAL_REQUEST_FAILED = 412;
    int REQUEST_ENTITY_TOO_LARGE = 413;
    int REQUEST_URI_TOO_LONG = 414;
    int UNSUPPORTED_MEDIA_TYPE = 415;
    int UNSUPPORTED_URI_SCHEME = 416;
    int BAD_EXTENSION = 420;
    int EXTENSION_REQUIRED = 421;
    int INTERVAL_TOO_BRIEF = 423;
    int TEMPORARILY_UNAVAILABLE = 480;
    int CALL_OR_TRANSACTION_DOES_NOT_EXIST = 481;
    int LOOP_DETECTED = 482;
    int TOO_MANY_HOPS = 483;
    int ADDRESS_INCOMPLETE = 484;
    int AMBIGUOUS = 485;
    int BUSY_HERE = 486;
    int REQUEST_TERMINATED = 487;
    int NOT_ACCEPTABLE_HERE = 488;
    int BAD_EVENT = 489;
    int REQUEST_PENDING = 491;
    int UNDECIPHERABLE = 493;
    int SERVER_INTERNAL_ERROR = 500;
    int NOT_IMPLEMENTED = 501;
    int BAD_GATEWAY = 502;
    int SERVICE_UNAVAILABLE = 503;
    int SERVER_TIMEOUT = 504;
    int VERSION_NOT_SUPPORTED = 505;
    int MESSAGE_TOO_LARGE = 513;
    int BUSY_EVERYWHERE = 600;
    int DECLINE = 603;
    int DOES_NOT_EXIST_ANYWHERE = 604;
    int SESSION_NOT_ACCEPTABLE = 606;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getStatusCode();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setStatusCode(int statusCode) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getReasonPhrase();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setReasonPhrase(String reasonPhrase) throws ParseException;
}
