/*
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

package android.drm;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;

/**
 * A utility class that provides operations for parsing extended metadata embedded in
 * DRM constraint information. If a DRM scheme has specific constraints beyond the standard
 * constraints, the constraints will show up in the
 * {@link DrmStore.ConstraintsColumns#EXTENDED_METADATA} key. You can use
 * {@link DrmUtils.ExtendedMetadataParser} to iterate over those values.
 */
public class DrmUtils {
    /* Should be used when we need to read from local file */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.048 -0400", hash_original_method = "E61ED77E96D4F5C2D7AA0F51DE667AAF", hash_generated_method = "64D60A4E836AB95C1B00938EFFAA11FD")
    
static byte[] readBytes(String path) throws IOException {
        File file = new File(path);
        return readBytes(file);
    }

    /* Should be used when we need to read from local file */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.056 -0400", hash_original_method = "15C058935040ED9488888CB09A9F9981", hash_generated_method = "D868F624DD456F4A4366D7B04F80FFD1")
    
static byte[] readBytes(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);
        byte[] data = null;

        try {
            int length = bufferedStream.available();
            if (length > 0) {
                data = new byte[length];
                // read the entire data
                bufferedStream.read(data);
             }
        } finally {
            quiteDispose(bufferedStream);
            quiteDispose(inputStream);
        }
        return data;
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.063 -0400", hash_original_method = "CAE9A537878C2DCE6F7A8BE28576EC6A", hash_generated_method = "661DA28E02370E8D3FD2E5C476CAC5C1")
    
static void writeToFile(final String path, byte[] data) throws IOException {
        /* check for invalid inputs */
        FileOutputStream outputStream = null;

        if (null != path && null != data) {
            try {
                outputStream = new FileOutputStream(path);
                outputStream.write(data);
            } finally {
                quiteDispose(outputStream);
            }
        }
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.069 -0400", hash_original_method = "79B3800DD6EBBBAC03A661B391B3754D", hash_generated_method = "5813C47959C1CA5D78EC60DC7CF5B019")
    
static void removeFile(String path) throws IOException {
        File file = new File(path);
        file.delete();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.076 -0400", hash_original_method = "FEC745F2142E570C8DAE040ED69A9738", hash_generated_method = "8DDFBA01EC49912D128EC50019049A1C")
    
private static void quiteDispose(InputStream stream) {
        try {
            if (null != stream) {
                stream.close();
            }
        } catch (IOException e) {
            // no need to care, at least as of now
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.082 -0400", hash_original_method = "71D6D0F5450BE0BC9986C389C4116D1B", hash_generated_method = "D9ABB67357CA12DEF686D633F5F2D0CD")
    
private static void quiteDispose(OutputStream stream) {
        try {
            if (null != stream) {
                stream.close();
            }
        } catch (IOException e) {
            // no need to care
        }
    }

    /**
     * Gets an instance of {@link DrmUtils.ExtendedMetadataParser}, which can be used to parse
     * extended metadata embedded in DRM constraint information.
     *
     * @param extendedMetadata Object in which key-value pairs of extended metadata are embedded.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.088 -0400", hash_original_method = "C8C1E5FA6DD3E83C8841537C71706F1D", hash_generated_method = "21CED68B29FBF561F8352E8F53DE3577")
    
public static ExtendedMetadataParser getExtendedMetadataParser(byte[] extendedMetadata) {
        return new ExtendedMetadataParser(extendedMetadata);
    }

    /**
     * Utility that parses extended metadata embedded in DRM constraint information.
     *<p>
     * Usage example:
     *<p>
     * byte[] extendedMetadata<br>
     * &nbsp;&nbsp;&nbsp;&nbsp; =
     *         constraints.getAsByteArray(DrmStore.ConstraintsColumns.EXTENDED_METADATA);<br>
     * ExtendedMetadataParser parser = getExtendedMetadataParser(extendedMetadata);<br>
     * Iterator keyIterator = parser.keyIterator();<br>
     * while (keyIterator.hasNext()) {<br>
     *     &nbsp;&nbsp;&nbsp;&nbsp;String extendedMetadataKey = keyIterator.next();<br>
     *     &nbsp;&nbsp;&nbsp;&nbsp;String extendedMetadataValue =
     *             parser.get(extendedMetadataKey);<br>
     * }
     */
    public static class ExtendedMetadataParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.095 -0400", hash_original_field = "2AF9FF595A86B5B5F25614B590863D61", hash_generated_field = "2AF9FF595A86B5B5F25614B590863D61")

        HashMap<String, String> mMap = new HashMap<String, String>();

        /*
         * This will parse the following format
         * KeyLengthValueLengthKeyValueKeyLength1ValueLength1Key1Value1..\0
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.122 -0400", hash_original_method = "32A158239F64D8DE54FA17667F023524", hash_generated_method = "01F7F1A919C6AE433068D1E4252B151F")
        
private ExtendedMetadataParser(byte[] constraintData) {
            //Extract KeyValue Pair Info, till terminator occurs.
            int index = 0;

            while (index < constraintData.length) {
                //Parse Key Length
                int keyLength = readByte(constraintData, index);
                index++;

                //Parse Value Length
                int valueLength = readByte(constraintData, index);
                index++;

                //Fetch key
                String strKey = readMultipleBytes(constraintData, keyLength, index);
                index += keyLength;

                //Fetch Value
                String strValue = readMultipleBytes(constraintData, valueLength, index);
                if (strValue.equals(" ")) {
                    strValue = "";
                }
                index += valueLength;
                mMap.put(strKey, strValue);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.102 -0400", hash_original_method = "31158B16172ABC4FD834A3CCCDED7D9A", hash_generated_method = "1AC198C1B9B0598CDA5863C9894F7986")
        
private int readByte(byte[] constraintData, int arrayIndex) {
            //Convert byte[] into int.
            return (int)constraintData[arrayIndex];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.110 -0400", hash_original_method = "1C83962E8B3433082188F9C1965D672F", hash_generated_method = "240A33E4EDD476A2175E20FCB6D8DCDF")
        
private String readMultipleBytes(
                byte[] constraintData, int numberOfBytes, int arrayIndex) {
            byte[] returnBytes = new byte[numberOfBytes];
            for (int j = arrayIndex, i = 0; j < arrayIndex + numberOfBytes; j++,i++) {
                returnBytes[i] = constraintData[j];
            }
            return new String(returnBytes);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.128 -0400", hash_original_method = "B7FBD6DD9474F1A1026D7F00079EDB35", hash_generated_method = "89343DE19A2D86E9940E1B4E9F8089D9")
        
public Iterator<String> iterator() {
            return mMap.values().iterator();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.133 -0400", hash_original_method = "646CC8040048B32C1B2C20C16578CA27", hash_generated_method = "53F6AF6DEEBDB0555D255FCD53556649")
        
public Iterator<String> keyIterator() {
            return mMap.keySet().iterator();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.138 -0400", hash_original_method = "4BCD400EF6A3BABD5D1A20005C4F1016", hash_generated_method = "18B107DAE4FFDF7E7BECAC8E7CDF40D9")
        
public String get(String key) {
            return mMap.get(key);
        }
    }
}

