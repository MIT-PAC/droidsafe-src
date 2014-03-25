/*---------------------------------------------------------------------------*
 *  MicrophoneInputStream.java                                               *
 *                                                                           *
 *  Copyright 2007 Nuance Communciations, Inc.                               *
 *                                                                           *
 *  Licensed under the Apache License, Version 2.0 (the 'License');          *
 *  you may not use this file except in compliance with the License.         *
 *                                                                           *
 *  You may obtain a copy of the License at                                  *
 *      http://www.apache.org/licenses/LICENSE-2.0                           *
 *                                                                           *
 *  Unless required by applicable law or agreed to in writing, software      *
 *  distributed under the License is distributed on an 'AS IS' BASIS,        *
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. *
 *  See the License for the specific language governing permissions and      *
 *  limitations under the License.                                           *
 *                                                                           *
 *---------------------------------------------------------------------------*/


package android.speech.srec;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.IllegalStateException;


/**
 * PCM input stream from the microphone, 16 bits per sample.
 */
public final class MicrophoneInputStream extends InputStream {
    static {
        System.loadLibrary("srec_jni");
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.743 -0400", hash_original_field = "05EDAC4E324E51DB104BC9BCCEFF419E", hash_generated_field = "2DBFFE27BD0D45B13A7068B2E631108C")

    
    private final static String TAG = "MicrophoneInputStream";
    
    //
    // AudioRecord JNI interface
    //
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:39.185 -0400", hash_original_method = "64AF6A38BAF07FD2A7B4505FA4449F00", hash_generated_method = "9C2EF3AA75B74971B5FC36FAA59C6176")
    
    private static int AudioRecordNew(int sampleRate, int fifoDepth){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += sampleRate;
    	taintDouble += fifoDepth;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:39.189 -0400", hash_original_method = "1E3226D0AD724A7CB343465EA7D3475A", hash_generated_method = "CC4BE8950E181B3090D1958BC27B4C3F")
    
    private static int AudioRecordStart(int audioRecord){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += audioRecord;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:39.193 -0400", hash_original_method = "82EFF4B018C026333FB09652FE9B56BA", hash_generated_method = "8011354E208AEDF49C9B98D8BC8B1B5C")
    
    private static int AudioRecordRead(int audioRecord, byte[] b, int offset, int length) throws IOException{
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += audioRecord;
    	taintDouble += b[0];
    	taintDouble += offset;
    	taintDouble += length;
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:07:03.814 -0400", hash_original_method = "A77DE4AAC2F2576DAA0108397051350E", hash_generated_method = "59D355A5AF47503EFEE0FDCD5783E12D")
    
    private static void AudioRecordStop(int audioRecord) throws IOException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:07:03.817 -0400", hash_original_method = "102AE209E6DBD8D31AAFAA181E2ACEAE", hash_generated_method = "BF2D1095E8A82F330FF0D36864F940BF")
    
    private static void AudioRecordDelete(int audioRecord) throws IOException{
    	//Formerly a native method
    }


@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.744 -0400", hash_original_field = "5F013BAAA31E1DF6900F559C8F594142", hash_generated_field = "A368EA2657C9671E29F16BF39CB71192")

    private int mAudioRecord = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.746 -0400", hash_original_field = "F2C0D94F7A8C986534145C29C73EBAF7", hash_generated_field = "87902E16EF92A33F1F2AB80C19566A53")

    private byte[] mOneByte = new byte[1];
    
    /**
     * MicrophoneInputStream constructor.
     * @param sampleRate sample rate of the microphone, typically 11025 or 8000.
     * @param fifoDepth depth of the real time fifo, measured in sampleRate clock ticks.
     * This determines how long an application may delay before losing data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.748 -0400", hash_original_method = "6057183E68FD82390257816F24A28376", hash_generated_method = "8E635C232D43A6C8A79156AC19889C8A")
    
public MicrophoneInputStream(int sampleRate, int fifoDepth) throws IOException {
        mAudioRecord = AudioRecordNew(sampleRate, fifoDepth);
        if (mAudioRecord == 0) throw new IOException("AudioRecord constructor failed - busy?");
        int status = AudioRecordStart(mAudioRecord);
        if (status != 0) {
            close();
            throw new IOException("AudioRecord start failed: " + status);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.749 -0400", hash_original_method = "2E9C6AB3DEFA28751EC7449B68926A5B", hash_generated_method = "FC430BBA4CFEE41B53C3909D7283B40F")
    
@Override
    public int read() throws IOException {
        if (mAudioRecord == 0) throw new IllegalStateException("not open");
        int rtn = AudioRecordRead(mAudioRecord, mOneByte, 0, 1);
        return rtn == 1 ? ((int)mOneByte[0] & 0xff) : -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.751 -0400", hash_original_method = "A8886AC01A191BF4705E453AB0A94419", hash_generated_method = "BBF4A16FCF291496CC21964BA29A9727")
    
@Override
    public int read(byte[] b) throws IOException {
        if (mAudioRecord == 0) throw new IllegalStateException("not open");
        return AudioRecordRead(mAudioRecord, b, 0, b.length);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.752 -0400", hash_original_method = "850DD0E1BDA65448E15AC4D5E89D1DA2", hash_generated_method = "D8B38537DA45EB038B1D8CE9EB619F46")
    
@Override
    public int read(byte[] b, int offset, int length) throws IOException {
        if (mAudioRecord == 0) throw new IllegalStateException("not open");
        // TODO: should we force all reads to be a multiple of the sample size?
        return AudioRecordRead(mAudioRecord, b, offset, length);
    }
    
    /**
     * Closes this stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.754 -0400", hash_original_method = "08D0F54B07D5BDD02D87F89A064DB127", hash_generated_method = "B451B93FC07355C93F3077E905117FAB")
    
@Override
    public void close() throws IOException {
        if (mAudioRecord != 0) {
            try {
                AudioRecordStop(mAudioRecord);
            } finally {
                try {
                    AudioRecordDelete(mAudioRecord);
                } finally {
                    mAudioRecord = 0;
                }
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.755 -0400", hash_original_method = "60E4248B8F63D585A4EFA088F51D9659", hash_generated_method = "3242A55E8AFD8082DAF4EC912B5297E7")
    
@Override
    protected void finalize() throws Throwable {
        if (mAudioRecord != 0) {
            close();
            throw new IOException("someone forgot to close MicrophoneInputStream");
        }
    }
}
