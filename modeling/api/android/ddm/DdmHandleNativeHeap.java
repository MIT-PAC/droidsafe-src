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


package android.ddm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;

public class DdmHandleNativeHeap extends ChunkHandler {

    /**
     * Register for the messages we're interested in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.288 -0500", hash_original_method = "AC12FA6487D63E990405579154753DC4", hash_generated_method = "97855623B053975DBEDC6A959C252650")
    
public static void register() {
        DdmServer.registerHandler(CHUNK_NHGT, mInstance);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.281 -0500", hash_original_field = "A81ED842E1635FFD8B140CC7A9CFCEE0", hash_generated_field = "CEFB92C5F36D65DBFF534DFB7342F93F")

    public static final int CHUNK_NHGT = type("NHGT");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.283 -0500", hash_original_field = "A8DABB7C0D3CC5EB57228683F0C112DD", hash_generated_field = "B5F5FC246460885FEBFA550AE061E53E")

    private static DdmHandleNativeHeap mInstance = new DdmHandleNativeHeap();

    /* singleton, do not instantiate */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.286 -0500", hash_original_method = "ACE04131AFA484CBFE62D5908678C3E3", hash_generated_method = "AD83B9732C87044D6C434CE82EC71597")
    
private DdmHandleNativeHeap() {}

    /**
     * Called when the DDM server connects.  The handler is allowed to
     * send messages to the server.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.290 -0500", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "B371B1A5EBF86980C6290FA035BAE684")
    
public void connected() {}

    /**
     * Called when the DDM server disconnects.  Can be used to disable
     * periodic transmissions or clean up saved state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.292 -0500", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "5061C51BA9AB55A45A330545ECB336D2")
    
public void disconnected() {}

    /**
     * Handle a chunk of data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.295 -0500", hash_original_method = "D29D7720926B3EEAF9F111354569BA63", hash_generated_method = "F12ABD80363D07BFC5312629F5B5BC60")
    
public Chunk handleChunk(Chunk request) {
        Log.i("ddm-nativeheap", "Handling " + name(request.type) + " chunk");
        int type = request.type;

        if (type == CHUNK_NHGT) {
            return handleNHGT(request);
        } else {
            throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        }
    }

    /*
     * Handle a "Native Heap GeT" request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.297 -0500", hash_original_method = "14897B1C078BC71A7C6BA04BAB3CD153", hash_generated_method = "26A3BEF12CA6CB85F6D6B92D79F1EBDA")
    
private Chunk handleNHGT(Chunk request) {
        //ByteBuffer in = wrapChunk(request);

        byte[] data = getLeakInfo();

        if (data != null) {
            // wrap & return
            Log.i("ddm-nativeheap", "Sending " + data.length + " bytes");
            return new Chunk(ChunkHandler.type("NHGT"), data, 0, data.length);
        } else {
            // failed, return a failure error code and message
            return createFailChunk(1, "Something went wrong");
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.301 -0500", hash_original_method = "FB1B192E745D23B5AF3323CB7D32960E", hash_generated_method = "7AFF957A9C1D14636EFC64D11DC855B4")
    
    private byte[] getLeakInfo(){
    	//Formerly a native method
    	return new byte[]{getTaintByte(),};
    }

}

