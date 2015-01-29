/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
* @author Alexander Y. Kleymenov
* @version $Revision$
*/

package org.apache.harmony.security.provider.cert;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Arrays;

/**
 * The caching mechanism designed to speed up the process
 * of Certificates/CRLs generation in the case of their repeated
 * generation.
 *
 * It keeps correspondences between Objects (Certificates or CLRs)
 * and arrays of bytes on the base of which the Objects have been generated,
 * and provides the means to determine whether it contains the object built on
 * the base of particular encoded form or not. If there are such
 * objects they are returned from the cache, if not - newly generated
 * objects can be saved in the cache.<br>
 *
 * The process of Certificate/CRL generation
 * (implemented in <code>X509CertFactoryImpl</code>) is accompanied with
 * prereading of the beginning of encoded form. This prefix is used to determine
 * whether provided form is PEM encoding or not.<br>
 *
 * So the use of the prefix is the first point to (approximately)
 * determine whether object to be generated is in the cache or not.
 *
 * The failure of the predetermination process tells us that there were not
 * object generated from the encoded form with such prefix and we should
 * generate (decode) the object. If predetermination is successful,
 * we conduct the accurate search on the base of whole encoded form. <br>
 *
 * So to speed up the object generation process this caching mechanism provides
 * the following functionality:<br>
 *
 *      1. With having of the beginning of the encoded form (prefix)
 * it is possible to predetermine whether object has already been
 * generated on the base of the encoding with the SIMILAR prefix or not.
 * This process is not computationally expensive and takes a little time.
 * But it prevents us from use of expensive full encoding
 * search in the case of its failure.<br>
 *
 *      2. If predetermination ends with success, the whole encoding
 * form should be provided to make the final answer: whether object has
 * already been generated on the base of this PARTICULAR encoded form or not.
 * If it is so - the cached object is returned from the cache,
 * if not - new object should be generated and saved in the cache.<br>
 *
 * Note: The length of the prefixes of the encoded forms should not be
 * less than correspondence (default value is 28).
 */
public class Cache {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.497 -0400", hash_original_field = "80EB1FD86064634931B380600FCDF44F", hash_generated_field = "BA3F0600CA2C4E6626F5791D2C5213CB")

    // where:
    // AA - 2 bytes for prefix hash
    //      value generated on the base of the prefix of encoding
    // BB - 2 bytes for tail hash
    //      value generated on the base of the tail of encoding
    // 00 - 2 reserved bytes equals to 0
    //
    // Note, that it is possible for 2 different arrays to have
    // the similar hash codes.

    // The masks to work with hash codes:
    // the hash code without the reserved bytes
    private static final long HASH_MASK = 0xFFFFFFFFFFFF0000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.498 -0400", hash_original_field = "F2003B80FCCB55ADBD744F18D400466F", hash_generated_field = "1D056C39ACC1673381106277F7ED3B64")

    private static final long PREFIX_HASH_MASK = 0xFFFFFFFF00000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.498 -0400", hash_original_field = "BDD5007DDE25543887F751D08BEB5F0F", hash_generated_field = "89F9F4AA0488EA096001A2AC0A58BFA9")

    private static final int  INDEX_MASK = 0x00FFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.499 -0400", hash_original_field = "EC892F583E85F3A342DBB8E69E42DF99", hash_generated_field = "010D3E16E2050170A47889C55E6F6F42")

    private  int cache_size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.499 -0400", hash_original_field = "41DDEFB80046FF43C3B75D7BEBC1D178", hash_generated_field = "DD9B4BB485DD5016DD3B26456B02F01F")

    private  int prefix_size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.500 -0400", hash_original_field = "BB333EDA36D472490D2EC1FEE46CBF8E", hash_generated_field = "8521FD17F3349F60CB6EB2D96020703B")

    // This information includes: hash of the array, encoded form of the object,
    // and the object itself.
    // The hash-encoding-object correspondence is made by means of index
    // in the particular array. I.e. for index N hash contained in hashes[N]
    // corresponds to the encoding contained in encodings[N] which corresponds
    // to the object cached at cache[N]

    // array containing the hash codes of encodings
    private  long[] hashes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.500 -0400", hash_original_field = "11F8DA967C05D26ED3895C432BDFC9D1", hash_generated_field = "485AC56DF9D2FC40E249340867B62642")

    private  byte[][] encodings;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.501 -0400", hash_original_field = "D36CC1D938096F8D82E7165568D48EAD", hash_generated_field = "C220825F412FCBFBDC70B9C0DB7AEC1E")

    private  Object[] cache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.501 -0400", hash_original_field = "F52B3809091E1B5B17C0164A39BC8DE7", hash_generated_field = "A910AB1FAA62BC1192AC678658603AD8")

    // This is an ordered array of the hash codes from 'hashes' array (described
    // above) with last 2 (reserved) bytes equals to the index of
    // the hash in the 'hashes' array. I.e. hash code ABCD00 with index 10 in
    // the hashes array will be represented in this array as ABCD0A (10==0x0A)
    // So this array contains ordered <hash to index> correspondences.
    // Note, that every item in this array is unique.
    private final long[] hashes_idx;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.502 -0400", hash_original_field = "62E5B8C893540CD1221B3BD587B53A83", hash_generated_field = "5F4300E6A99DEB113CF8C04C323D497F")

    private int last_cached = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.502 -0400", hash_original_field = "28E8F310B4ADEC99381C21544A9E32F9", hash_generated_field = "471CE275EDE07A0519D6E19FC6AE38D6")

    private boolean cache_is_full = false;

    /**
     * Creates the Cache object.
     * @param pref_size specifies how many leading/trailing bytes of object's
     * encoded form will be used for hash computation
     * @param size capacity of the cache to be created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.503 -0400", hash_original_method = "541CE82552DC13E1CD2436EB1FCBF182", hash_generated_method = "E8C3252656A91FE7B34D8999D9623613")
    
public Cache(int pref_size, int size) {
        cache_size = size;
        prefix_size = pref_size;
        hashes = new long[cache_size];
        hashes_idx = new long[cache_size];
        encodings = new byte[cache_size][];
        cache = new Object[cache_size];
    }

    /**
     * Creates the Cache object of size of 9.
     * @param pref_size specifies how many leading/trailing bytes of object's
     * encoded form will be used for hash computation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.503 -0400", hash_original_method = "CDBBF9685B9AF5133139869A227E00AD", hash_generated_method = "9FE49F2CADAD3B7354A88EDBE95D90DD")
    
public Cache(int pref_size) {
        this(pref_size, 9);
    }

    /**
     * Creates the Cache object of size of 9.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.504 -0400", hash_original_method = "1A0B00948441763B793BD010E76AFF12", hash_generated_method = "FADCDE1FA7B5A5823923AE00A5D5E82C")
    
public Cache() {
        this(28, 9);
    }

    /**
     * Returns the hash code for the array. This code is used to
     * predetermine whether the object was built on the base of the
     * similar encoding or not (by means of <code>contains(long)</code> method),
     * to exactly determine whether object is contained in the cache or not,
     * and to put the object in the cache.
     * Note: parameter array should be of length not less than
     * specified by <code>prefix_size</code> (default 28)
     * @param arr the byte array containing at least prefix_size leading bytes
     * of the encoding.
     * @return hash code for specified encoding prefix
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.505 -0400", hash_original_method = "110F01EAE6641F0C661D2541E0D32701", hash_generated_method = "46F0768A5A38CE734236524C276DE677")
    
public long getHash(byte[] arr) {
        long hash = 0;
        for (int i=1; i<prefix_size; i++) {
            hash += (arr[i] & 0xFF);
        } // it takes about 2 bytes for prefix_size == 28

        // shift to the correct place
        hash = hash << 32;
        return hash;
    }

    /**
     * Checks if there are any object in the cache generated
     * on the base of encoding with prefix corresponding
     * to the specified hash code.
     * @param prefix_hash the hash code for the prefix
     * of the encoding (retrieved by method <code>getHash(byte[]))</code>
     * @return false if there were not any object generated
     * on the base of encoding with specified hash code, true
     * otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.505 -0400", hash_original_method = "1E57D02199A66E6ABD30D58D7EA98A70", hash_generated_method = "1B35907AE3AFDCCD65E323B29EDD415E")
    
public boolean contains(long prefix_hash) {
        if (prefix_hash == 0) {
            return false;
        }
        int idx = -1*Arrays.binarySearch(hashes_idx, prefix_hash)-1;
        if (idx == cache_size) {
            return false;
        } else {
            return (hashes_idx[idx] & PREFIX_HASH_MASK) == prefix_hash;
        }
    }

    /**
     * Returns the object built on the base on the specified encoded
     * form if it is contained in the cache and null otherwise.
     * This method is computationally expensive and should be called only if
     * the method <code>contains(long)</code> for the hash code returned true.
     * @param hash the hash code for the prefix of the encoding
     * (retrieved by method <code>getHash(byte[])</code>)
     * @param encoding encoded form of the required object.
     * @return the object corresponding to specified encoding or null if
     * there is no such correspondence.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.506 -0400", hash_original_method = "0EB3B61D8F449BC9B5041D24A894CC47", hash_generated_method = "B310245E2F0664F585E3DC484D904B3E")
    
public Object get(long hash, byte[] encoding) {
        hash |= getSuffHash(encoding);
        if (hash == 0) {
            return null;
        }
        int idx = -1*Arrays.binarySearch(hashes_idx, hash)-1;
        if (idx == cache_size) {
            return null;
        }
        while ((hashes_idx[idx] & HASH_MASK) == hash) {
            int i = (int) (hashes_idx[idx] & INDEX_MASK) - 1;
            if (Arrays.equals(encoding, encodings[i])) {
                return cache[i];
            }
            idx++;
            if (idx == cache_size) {
                return null;
            }
        }
        return null;
    }

    /**
     * Puts the object into the cache.
     * @param hash hash code for the prefix of the encoding
     * @param encoding the encoded form of the object
     * @param object the object to be saved in the cache
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.508 -0400", hash_original_method = "CF116B3452EC0275566D37ECB3727B4E", hash_generated_method = "62F3A28D407886841033EDFC8C5FE565")
    
public void put(long hash, byte[] encoding, Object object) {
        // check for empty space in the cache
        if (last_cached == cache_size) {
            // so cache is full, will erase the first entry in the
            // cache (oldest entry). it could be better to throw out
            // rarely used value instead of oldest one..
            last_cached = 0;
            cache_is_full = true;
        }
        // index pointing to the item of the table to be overwritten
        int index = last_cached++;

        // improve the hash value with info from the tail of encoding
        hash |= getSuffHash(encoding);

        if (cache_is_full) {
            // indexing hash value to be overwritten:
            long idx_hash = (hashes[index] | (index+1));
            int idx = Arrays.binarySearch(hashes_idx, idx_hash);
            if (idx < 0) {
                // it will never happen because we use saved hash value
                // (hashes[index])
                System.out.println("WARNING! "+idx);
                idx = -(idx + 1);
            }
            long new_hash_idx = (hash | (index + 1));
            int new_idx = Arrays.binarySearch(hashes_idx, new_hash_idx);
            if (new_idx >= 0) {
                // it's possible when we write the same hash in the same cell
                if (idx != new_idx) {
                    // it will never happen because we use the same
                    // hash and the same index in hash table
                    System.out.println("WARNING: ");
                    System.out.println(">> idx: "+idx+" new_idx: "+new_idx);
                }
            } else {
                new_idx = -(new_idx + 1);
                // replace in sorted array
                if (new_idx > idx) {
                    System.arraycopy(hashes_idx, idx+1, hashes_idx, idx,
                            new_idx - idx - 1);
                    hashes_idx[new_idx-1] = new_hash_idx;
                } else if (idx > new_idx) {
                    System.arraycopy(hashes_idx, new_idx, hashes_idx, new_idx+1,
                            idx - new_idx);
                    hashes_idx[new_idx] = new_hash_idx;
                } else { // idx == new_idx
                    hashes_idx[new_idx] = new_hash_idx;
                }
            }
        } else {
            long idx_hash = (hash | (index + 1));
            int idx = Arrays.binarySearch(hashes_idx, idx_hash);
            if (idx < 0) {
                // it will always be true because idx_hash depends on index
                idx = -(idx + 1);
            }
            idx = idx - 1;
            if (idx != cache_size - index - 1) {
                // if not in the cell containing 0 (free cell), do copy:
                System.arraycopy(hashes_idx, cache_size - index,
                        hashes_idx, cache_size - index - 1,
                        idx - (cache_size - index) + 1);
            }
            hashes_idx[idx] = idx_hash;
        }
        // overwrite the values in the tables:
        hashes[index] = hash;
        encodings[index] = encoding;
        cache[index] = object;
    }

    // Returns the hash code built on the base of the tail of the encoded form
    // @param arr - the array containing at least prefix_size trailing bytes
    // of encoded form
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.508 -0400", hash_original_method = "82844BD752EA070A2C5BC66963F0CE01", hash_generated_method = "BFE6B4E4793CF0351078C55B70484682")
    
private long getSuffHash(byte[] arr) {
        long hash_addon = 0;
        for (int i=arr.length-1; i>arr.length - prefix_size; i--) {
            hash_addon += (arr[i] & 0xFF);
        }
        return hash_addon << 16;
    }

}
