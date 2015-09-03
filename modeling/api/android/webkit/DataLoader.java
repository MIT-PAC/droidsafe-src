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


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;

import libcore.io.Base64;
import android.net.http.EventHandler;

import com.android.internal.R;

class DataLoader extends StreamLoader {

    /**
     * Constructor uses the dataURL as the source for an InputStream
     * @param dataUrl data: URL string optionally containing a mimetype
     * @param loadListener LoadListener to pass the content to
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.244 -0500", hash_original_method = "973C5174F409BF73FE3F5C468E90899A", hash_generated_method = "973C5174F409BF73FE3F5C468E90899A")
    
DataLoader(String dataUrl, LoadListener loadListener) {
        super(loadListener);

        String url = dataUrl.substring("data:".length());
        byte[] data = null;
        int commaIndex = url.indexOf(',');
        if (commaIndex != -1) {
            String contentType = url.substring(0, commaIndex);
            data = url.substring(commaIndex + 1).getBytes();
            loadListener.parseContentTypeHeader(contentType);
            if ("base64".equals(loadListener.transferEncoding())) {
                data = Base64.decode(data);
            }
        } else {
            data = url.getBytes();
        }
        if (data != null) {
            mDataStream = new ByteArrayInputStream(data);
            mContentLength = data.length;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.246 -0500", hash_original_method = "741CD292254249FEBDFDE203F8AC2D5E", hash_generated_method = "A73B364F77DE34AD223121C6605AF5FF")
    
@Override
    protected boolean setupStreamAndSendStatus() {
        if (mDataStream != null) {
            mLoadListener.status(1, 1, 200, "OK");
            return true;
        } else {
            mLoadListener.error(EventHandler.ERROR,
                    mContext.getString(R.string.httpError));
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:13.248 -0500", hash_original_method = "2B11D339C271386CE83AD39A9189005C", hash_generated_method = "138E19A88952EC3EA1712D8583B9657B")
    
@Override
    protected void buildHeaders(android.net.http.Headers h) {
    }
    
}

