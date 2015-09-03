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


package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import droidsafe.helpers.DSUtils;

public class DecoderCapabilities {

    /**
     * Returns the list of video decoder types
     * @see android.media.DecoderCapabilities.VideoDecoder
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.788 -0500", hash_original_method = "334155FFC3E4A7CB7C7D0CBEA471B4F4", hash_generated_method = "BAEC771B0BCA77724CFD1995660C47BE")
    
public static List<VideoDecoder> getVideoDecoders() {
        List<VideoDecoder> decoderList = new ArrayList<VideoDecoder>();
        int nDecoders = native_get_num_video_decoders();
        for (int i = 0; i < nDecoders; ++i) {
            decoderList.add(VideoDecoder.values()[native_get_video_decoder_type(i)]);
        }
        return decoderList;
    }

    /**
     * Returns the list of audio decoder types
     * @see android.media.DecoderCapabilities.AudioDecoder
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.791 -0500", hash_original_method = "9C119221D85202C4EA1DCEF893071B70", hash_generated_method = "B70CA09FCB71C8BFDB0B87116BDF5A45")
    
public static List<AudioDecoder> getAudioDecoders() {
        List<AudioDecoder> decoderList = new ArrayList<AudioDecoder>();
        int nDecoders = native_get_num_audio_decoders();
        for (int i = 0; i < nDecoders; ++i) {
            decoderList.add(AudioDecoder.values()[native_get_audio_decoder_type(i)]);
        }
        return decoderList;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final void native_init() {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int native_get_num_video_decoders() {
        return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int native_get_video_decoder_type(int index) {
        return index;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int native_get_num_audio_decoders() {
        return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final int native_get_audio_decoder_type(int index) {
        return index;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.793 -0500", hash_original_method = "599AF8A39C7326727CA1A71C57B2EC2D", hash_generated_method = "BFECFE7E67F6E5F2BF2546A8989CB0DE")
    
private DecoderCapabilities() {}
    
    public enum VideoDecoder {
        VIDEO_DECODER_WMV,
    }
    
    public enum AudioDecoder {
        AUDIO_DECODER_WMA,
    }
    
    static {
        System.loadLibrary("media_jni");
        native_init();
    }
    
}

