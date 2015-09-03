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


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.InputStream;

import android.net.http.Headers;

public class WebResourceResponse {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.437 -0500", hash_original_field = "B161F982909610C03B68BAACDD54E076", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

    private String mMimeType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.440 -0500", hash_original_field = "532663CB004FA57020360003BD60B6E5", hash_generated_field = "98F3D6B51351657C10385D44B0C0054D")

    private String mEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.442 -0500", hash_original_field = "514FB88864F91247F240CC01D2ACC68C", hash_generated_field = "2066844AD462D9280C47C6967D4F3E6F")

    private InputStream mInputStream;

    /**
     * Construct a response with the given mime type, encoding, and data.
     * @param mimeType The mime type of the data (i.e. text/html).
     * @param encoding The encoding of the bytes read from data.
     * @param data An InputStream for reading custom data.  The implementation
     *             must implement {@link InputStream#read(byte[])}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.444 -0500", hash_original_method = "4162893AC611CC9D36B64E02A003D671", hash_generated_method = "CCDF140A01AA368F6DDADE96FB661656")
    
public WebResourceResponse(String mimeType, String encoding,
            InputStream data) {
        mMimeType = mimeType;
        mEncoding = encoding;
        mInputStream = data;
    }

    /**
     * Set the mime type of the response data (i.e. text/html).
     * @param mimeType
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.446 -0500", hash_original_method = "1165C88EB0307FF1DFDA0D499F11D5AA", hash_generated_method = "D8F3C879A4900376C616D1EFC962FBBD")
    
public void setMimeType(String mimeType) {
        mMimeType = mimeType;
    }

    /**
     * @see #setMimeType
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.448 -0500", hash_original_method = "FA5F1755E5361266828E073C873270CA", hash_generated_method = "B6BE0B3A83C82DC56DDAFE99F64DCDED")
    
public String getMimeType() {
        return mMimeType;
    }

    /**
     * Set the encoding of the response data (i.e. utf-8).  This will be used to
     * decode the raw bytes from the input stream.
     * @param encoding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.451 -0500", hash_original_method = "6642C41BC98D7E1BDACAB67A1DFBBC4B", hash_generated_method = "724C718AF13E985F1092D8A77FC960D7")
    
public void setEncoding(String encoding) {
        mEncoding = encoding;
    }

    /**
     * @see #setEncoding
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.453 -0500", hash_original_method = "2712105DF2D5EC1ED27B9462D6F15E3A", hash_generated_method = "40A27533369FC876F76059D4CC6AB2EA")
    
public String getEncoding() {
        return mEncoding;
    }

    /**
     * Set the input stream containing the data for this resource.
     * @param data An InputStream for reading custom data.  The implementation
     *             must implement {@link InputStream#read(byte[])}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.455 -0500", hash_original_method = "C26148C30E5EF65B476B7B323E30AB3C", hash_generated_method = "DD966A8FEA19BABFDB742D64BCC4D6FF")
    
public void setData(InputStream data) {
        mInputStream = data;
    }

    /**
     * @see #setData
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.457 -0500", hash_original_method = "70FED193DE86C029473917F94AE9B4C4", hash_generated_method = "9D8190C12BD4710F103E0997EC781AC5")
    
public InputStream getData() {
        return mInputStream;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.460 -0500", hash_original_method = "6FC74C7BC54A6B57AFC291C9E3571AE9", hash_generated_method = "6FC74C7BC54A6B57AFC291C9E3571AE9")
    
StreamLoader loader(LoadListener listener) {
        return new Loader(listener);
    }
    
    private class Loader extends StreamLoader {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.428 -0500", hash_original_method = "FF1E1DBFDB5E8CEAA6F22CFE65A4CDBA", hash_generated_method = "FF1E1DBFDB5E8CEAA6F22CFE65A4CDBA")
        
Loader(LoadListener loadListener) {
            super(loadListener);
            mDataStream = mInputStream;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.430 -0500", hash_original_method = "F11F1CED2E6EEAF3CF48BEFB2475FBE1", hash_generated_method = "16DB1A6F52BDE130BFBB230DAB7C5EFC")
        
@Override
        protected boolean setupStreamAndSendStatus() {
            mLoadListener.status(1, 1, mDataStream != null ? 200 : 404, "");
            return true;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.433 -0500", hash_original_method = "4179DBF067EB1650CA924A33BC327D3E", hash_generated_method = "D41645246AEAD54965F31AD1AE68BAF7")
        
@Override
        protected void buildHeaders(Headers headers) {
            headers.setContentType(mMimeType);
            headers.setContentEncoding(mEncoding);
        }
        
    }
    
}

