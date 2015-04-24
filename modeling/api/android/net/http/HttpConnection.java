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
 * Copyright (C) 2007 The Android Open Source Project
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
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.Socket;

import org.apache.http.HttpHost;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

import android.content.Context;

class HttpConnection extends Connection {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.413 -0500", hash_original_method = "8B0FF76444F6FD4A7628D73D943DE9DB", hash_generated_method = "8B0FF76444F6FD4A7628D73D943DE9DB")
    
HttpConnection(Context context, HttpHost host,
                   RequestFeeder requestFeeder) {
        super(context, host, requestFeeder);
    }

    /**
     * Opens the connection to a http server
     *
     * @return the opened low level connection
     * @throws IOException if the connection fails for any reason.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.416 -0500", hash_original_method = "EFF3BAA5D0EF7633E7DF2DAA76502E87", hash_generated_method = "376BE25A6A8379FB0723D68DD552DF63")
    
@Override
    AndroidHttpClientConnection openConnection(Request req) throws IOException {

        // Update the certificate info (connection not secure - set to null)
        EventHandler eventHandler = req.getEventHandler();
        mCertificate = null;
        eventHandler.certificate(mCertificate);

        AndroidHttpClientConnection conn = new AndroidHttpClientConnection();
        BasicHttpParams params = new BasicHttpParams();
        Socket sock = new Socket(mHost.getHostName(), mHost.getPort());
        params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
        conn.bind(sock, params);
        return conn;
    }

    /**
     * Closes the low level connection.
     *
     * If an exception is thrown then it is assumed that the
     * connection will have been closed (to the extent possible)
     * anyway and the caller does not need to take any further action.
     *
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.418 -0500", hash_original_method = "28229552049A2A2DB18166A64CE88A0A", hash_generated_method = "28229552049A2A2DB18166A64CE88A0A")
    
void closeConnection() {
        try {
            if (mHttpClientConnection != null && mHttpClientConnection.isOpen()) {
                mHttpClientConnection.close();
            }
        } catch (IOException e) {
            if (HttpLog.LOGV) HttpLog.v(
                    "closeConnection(): failed closing connection " +
                    mHost);
            e.printStackTrace();
        }
    }

    /**
     * Restart a secure connection suspended waiting for user interaction.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.420 -0500", hash_original_method = "F65A3585D6DFE09EE931E3CB8D7B855F", hash_generated_method = "9E9C1487122124AAF78E9A685E07DF05")
    
void restartConnection(boolean abort) {
        // not required for plain http connections
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.421 -0500", hash_original_method = "28A13316B46B35CCB565BDA96B57339B", hash_generated_method = "28A13316B46B35CCB565BDA96B57339B")
    
String getScheme() {
        return "http";
    }
    
}

