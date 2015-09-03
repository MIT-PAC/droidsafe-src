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
 * Copyright (C) 2011 The Android Open Source Project
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
import android.content.Context;
import android.os.Handler;



class KeyStoreHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.018 -0500", hash_original_field = "57D9472E60143F42931867FB31034239", hash_generated_field = "C9E2CFC610075E6FBB1A3E399A292AA6")

    private static final String LOGTAG = "KeyStoreHandler";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.020 -0500", hash_original_field = "E6EE4FF0DEA62AEFAFF3DBB439BA6E92", hash_generated_field = "C2ADEC4B7675869DD34EF84CA5DC8ADA")


    private final ByteArrayBuilder mDataBuilder = new ByteArrayBuilder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.023 -0500", hash_original_field = "B161F982909610C03B68BAACDD54E076", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")


    private String mMimeType;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.025 -0500", hash_original_method = "587ABBBEDE647D3237F91706DA6610BD", hash_generated_method = "51BD0A331D376AE273376AA53593E8CC")
    
public KeyStoreHandler(String mimeType) {
      mMimeType = mimeType;
    }

    /**
     * Add data to the internal collection of data.
     * @param data A byte array containing the content.
     * @param length The length of data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.027 -0500", hash_original_method = "2DA424A8A87A21D10409F02AA8AEC0E6", hash_generated_method = "3A207DA0834E6BC699C9CF6E0EAC2295")
    
public void didReceiveData(byte[] data, int length) {
        synchronized (mDataBuilder) {
            mDataBuilder.append(data, 0, length);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.030 -0500", hash_original_method = "736EF2EF4199424B0094A77A85DC708B", hash_generated_method = "C5EDB0CCB25C78CFB2DB87C26D662897")
    
public void installCert(Context context) {
        String type = CertTool.getCertType(mMimeType);
        if (type == null) return;

        // This must be synchronized so that no more data can be added
        // after getByteSize returns.
        synchronized (mDataBuilder) {
            // In the case of downloading certificate, we will save it
            // to the KeyStore and stop the current loading so that it
            // will not generate a new history page
            byte[] cert = new byte[mDataBuilder.getByteSize()];
            int offset = 0;
            while (true) {
                ByteArrayBuilder.Chunk c = mDataBuilder.getFirstChunk();
                if (c == null) break;

                if (c.mLength != 0) {
                    System.arraycopy(c.mArray, 0, cert, offset, c.mLength);
                    offset += c.mLength;
                }
                c.release();
            }
            CertTool.addCertificate(context, type, cert);
            return;
        }
    }
}

