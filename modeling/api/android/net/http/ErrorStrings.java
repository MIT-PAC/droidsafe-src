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
 * Copyright (C) 2010 The Android Open Source Project
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
import android.content.Context;
import android.util.Log;

public class ErrorStrings {

    /**
     * Get the localized error message resource for the given error code.
     * If the code is unknown, we'll return a generic error message.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.092 -0500", hash_original_method = "620302E9CD7FB340599AB59B48404262", hash_generated_method = "B3670E43A8B7EF586CE3BC31E856416A")
    
public static String getString(int errorCode, Context context) {
        return context.getText(getResource(errorCode)).toString();
    }

    /**
     * Get the localized error message resource for the given error code.
     * If the code is unknown, we'll return a generic error message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.095 -0500", hash_original_method = "1CA3D2D5C3AEDC68FF3D7D5139845EF1", hash_generated_method = "E11B909B91BD8AFEA2C04C1A43507C1D")
    
public static int getResource(int errorCode) {
        switch(errorCode) {
            case EventHandler.OK:
                return com.android.internal.R.string.httpErrorOk;

            case EventHandler.ERROR:
                return com.android.internal.R.string.httpError;

            case EventHandler.ERROR_LOOKUP:
                return com.android.internal.R.string.httpErrorLookup;

            case EventHandler.ERROR_UNSUPPORTED_AUTH_SCHEME:
                return com.android.internal.R.string.httpErrorUnsupportedAuthScheme;

            case EventHandler.ERROR_AUTH:
                return com.android.internal.R.string.httpErrorAuth;

            case EventHandler.ERROR_PROXYAUTH:
                return com.android.internal.R.string.httpErrorProxyAuth;

            case EventHandler.ERROR_CONNECT:
                return com.android.internal.R.string.httpErrorConnect;

            case EventHandler.ERROR_IO:
                return com.android.internal.R.string.httpErrorIO;

            case EventHandler.ERROR_TIMEOUT:
                return com.android.internal.R.string.httpErrorTimeout;

            case EventHandler.ERROR_REDIRECT_LOOP:
                return com.android.internal.R.string.httpErrorRedirectLoop;

            case EventHandler.ERROR_UNSUPPORTED_SCHEME:
                return com.android.internal.R.string.httpErrorUnsupportedScheme;

            case EventHandler.ERROR_FAILED_SSL_HANDSHAKE:
                return com.android.internal.R.string.httpErrorFailedSslHandshake;

            case EventHandler.ERROR_BAD_URL:
                return com.android.internal.R.string.httpErrorBadUrl;

            case EventHandler.FILE_ERROR:
                return com.android.internal.R.string.httpErrorFile;

            case EventHandler.FILE_NOT_FOUND_ERROR:
                return com.android.internal.R.string.httpErrorFileNotFound;

            case EventHandler.TOO_MANY_REQUESTS_ERROR:
                return com.android.internal.R.string.httpErrorTooManyRequests;

            default:
                Log.w(LOGTAG, "Using generic message for unknown error code: " + errorCode);
                return com.android.internal.R.string.httpError;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.089 -0500", hash_original_field = "7E068549854EC7B659EE876AD356FB52", hash_generated_field = "26F6F5D2EF35FA86B8698978CE2FD0C9")

    private static final String LOGTAG = "Http";
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.087 -0500", hash_original_method = "15196F3BFA8B9637883B8AE296FFF8F2", hash_generated_method = "FDB5E9D3AC187BF874E9B6432C969220")
    
private ErrorStrings() { /* Utility class, don't instantiate. */ }
}

