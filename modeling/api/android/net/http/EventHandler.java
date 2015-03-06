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
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface EventHandler {
    
    public static final int OK = 0;
    
    public static final int ERROR = -1;
    
    public static final int ERROR_LOOKUP = -2;
    
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    
    public static final int ERROR_AUTH = -4;
    
    public static final int ERROR_PROXYAUTH = -5;
    
    public static final int ERROR_CONNECT = -6;
    
    public static final int ERROR_IO = -7;
    
    public static final int ERROR_TIMEOUT = -8;
    
    public static final int ERROR_REDIRECT_LOOP = -9;
    
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    
    public static final int ERROR_BAD_URL = -12;
    
    public static final int FILE_ERROR = -13;
    
    public static final int FILE_NOT_FOUND_ERROR = -14;
    
    public static final int TOO_MANY_REQUESTS_ERROR = -15;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void status(int major_version,
                       int minor_version,
                       int code,
                       String reason_phrase);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void headers(Headers headers);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void data(byte[] data, int len);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void endData();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void certificate(SslCertificate certificate);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void error(int id, String description);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean handleSslErrorRequest(SslError error);

}
