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
import android.net.http.Headers;
import android.text.TextUtils;



class CacheLoader extends StreamLoader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.239 -0500", hash_original_field = "B8E944361CAE1A88801CDDF7F334AC6D", hash_generated_field = "B8E944361CAE1A88801CDDF7F334AC6D")


    CacheManager.CacheResult mCacheResult;  // Content source

    /**
     * Constructs a CacheLoader for use when loading content from the cache.
     *
     * @param loadListener LoadListener to pass the content to
     * @param result CacheResult used as the source for the content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.242 -0500", hash_original_method = "5AF96706DF9FEED69E5A85053239A8E2", hash_generated_method = "5AF96706DF9FEED69E5A85053239A8E2")
    
CacheLoader(LoadListener loadListener, CacheManager.CacheResult result) {
        super(loadListener);

        assert !JniUtil.useChromiumHttpStack();

        mCacheResult = result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.244 -0500", hash_original_method = "5DFC3C12C1D0EBA5023FB5F302EE8813", hash_generated_method = "8155A4832295A69A873F3610F7996631")
    
@Override
    protected boolean setupStreamAndSendStatus() {
        mDataStream = mCacheResult.inStream;
        mContentLength = mCacheResult.contentLength;
        mLoadListener.status(1, 1, mCacheResult.httpStatusCode, "OK");
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.247 -0500", hash_original_method = "09EA95975DEA7D7D43A5B322B32B5DDD", hash_generated_method = "FB0CEC1ED244CF61E2F346A01E142DCD")
    
@Override
    protected void buildHeaders(Headers headers) {
        StringBuilder sb = new StringBuilder(mCacheResult.mimeType);
        if (!TextUtils.isEmpty(mCacheResult.encoding)) {
            sb.append(';');
            sb.append(mCacheResult.encoding);
        }
        headers.setContentType(sb.toString());

        if (!TextUtils.isEmpty(mCacheResult.location)) {
            headers.setLocation(mCacheResult.location);
        }

        if (!TextUtils.isEmpty(mCacheResult.expiresString)) {
            headers.setExpires(mCacheResult.expiresString);
        }

        if (!TextUtils.isEmpty(mCacheResult.contentdisposition)) {
            headers.setContentDisposition(mCacheResult.contentdisposition);
        }

        if (!TextUtils.isEmpty(mCacheResult.crossDomain)) {
            headers.setXPermittedCrossDomainPolicies(mCacheResult.crossDomain);
        }
    }

    
}

