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


package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class LinkCapabilities implements Parcelable {

    /**
     * Create the {@code LinkCapabilities} with values depending on role type.
     * @param applicationRole a {@code LinkSocket.Role}
     * @return the {@code LinkCapabilities} associated with the applicationRole, empty if none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.856 -0500", hash_original_method = "EC660E8DCF1E74439F3C9EC2FA6F7AC7", hash_generated_method = "98E2E44001F98BC1DE011135CEE9A8D2")
    
public static LinkCapabilities createNeedsMap(String applicationRole) {
        if (DBG) log("createNeededCapabilities(applicationRole) EX");
        return new LinkCapabilities();
    }

    /**
     * Debug logging
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.895 -0500", hash_original_method = "B9AF8185F4B8412B9E80F317F384108E", hash_generated_method = "9425F6BBE5A615832A85DEB7FCBE8AFE")
    
protected static void log(String s) {
        Log.d(TAG, s);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.787 -0500", hash_original_field = "96313275B16FE10D04766DDC38CA6833", hash_generated_field = "EDE6D4D524232007B357204761FD3C7F")

    private static final String TAG = "LinkCapabilities";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.790 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.047 -0400", hash_original_field = "C032CB84B2CEFE05F1B0EAA754FB9455", hash_generated_field = "844C01C5C8649D904242274D94DCF977")

    public static final Creator<LinkCapabilities> CREATOR =
        new Creator<LinkCapabilities>() {
            @DSSafe(DSCat.SAFE_OTHERS)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.888 -0500", hash_original_method = "EE10B5AF562143A35856727EE7786CE8", hash_generated_method = "907427722BA360BB4F22035161CCA8EF")
        
public LinkCapabilities createFromParcel(Parcel in) {
                LinkCapabilities capabilities = new LinkCapabilities();
                int size = in.readInt();
                while (size-- != 0) {
                    int key = in.readInt();
                    String value = in.readString();
                    capabilities.mCapabilities.put(key, value);
                }
                return capabilities;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.891 -0500", hash_original_method = "DA3D851B4F425B625596A4EBE0CE616D", hash_generated_method = "A0AC2C0AFAB041F396240BA1788E63CA")
        
public LinkCapabilities[] newArray(int size) {
                return new LinkCapabilities[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.792 -0500", hash_original_field = "A4C03366DD376C30FB34DEC0FAFFD071", hash_generated_field = "6D2F490064193A394308FD52EAD2F213")

    private HashMap<Integer, String> mCapabilities;

    /**
     * Constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.852 -0500", hash_original_method = "8AC97A1FCCB5728EBAB2151990B61507", hash_generated_method = "8897901E4D9614E3F7F033A7202C3B9F")
    
public LinkCapabilities() {
        mCapabilities = new HashMap<Integer, String>();
    }

    /**
     * Copy constructor.
     *
     * @param source
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.854 -0500", hash_original_method = "B89651C5D9CFDB434612BD816E092144", hash_generated_method = "F86E9DF4023B3EB7747B0013704B7C65")
    
public LinkCapabilities(LinkCapabilities source) {
        if (source != null) {
            mCapabilities = new HashMap<Integer, String>(source.mCapabilities);
        } else {
            mCapabilities = new HashMap<Integer, String>();
        }
    }

    /**
     * Remove all capabilities
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.858 -0500", hash_original_method = "65569EBD49455AAF0883C4D69A42B604", hash_generated_method = "33D01536F41ABBD8CD10D02B7232AC4D")
    
public void clear() {
        mCapabilities.clear();
    }

    /**
     * Returns whether this map is empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.862 -0500", hash_original_method = "50DA395E2AF302C1CC5EAE713D0D4EBB", hash_generated_method = "4FF6D0FAFA466F42803717B503EB07AB")
    
public boolean isEmpty() {
        return mCapabilities.isEmpty();
    }

    /**
     * Returns the number of elements in this map.
     *
     * @return the number of elements in this map.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.864 -0500", hash_original_method = "32A53E9BB0DE153D2975EBB6ECC5F512", hash_generated_method = "7AD58B097114E94B01E74084695DFF98")
    
public int size() {
        return mCapabilities.size();
    }

    /**
     * Given the key return the capability string
     *
     * @param key
     * @return the capability string
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.866 -0500", hash_original_method = "568005AD4EF2A886FBB9B820A5E2167C", hash_generated_method = "386973CB8BBD5465B8F7B1B19C249AA5")
    
public String get(int key) {
        return mCapabilities.get(key);
    }

    /**
     * Store the key/value capability pair
     *
     * @param key
     * @param value
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.868 -0500", hash_original_method = "126A86B00CA0552F526F15B68A83F2ED", hash_generated_method = "7B3AB6A860409BD4AD0AC35129DC39E7")
    
public void put(int key, String value) {
        mCapabilities.put(key, value);
    }

    /**
     * Returns whether this map contains the specified key.
     *
     * @param key to search for.
     * @return {@code true} if this map contains the specified key,
     *         {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.870 -0500", hash_original_method = "C1A26B01C735E97490E02BBFBAC6A09E", hash_generated_method = "E0C97133E7A6161622C7943AC6D8A283")
    
public boolean containsKey(int key) {
        return mCapabilities.containsKey(key);
    }

    /**
     * Returns whether this map contains the specified value.
     *
     * @param value to search for.
     * @return {@code true} if this map contains the specified value,
     *         {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.872 -0500", hash_original_method = "05E28527AC6BDB7F8BDD1968A304DADF", hash_generated_method = "3A4B45B9D623DCD90191FBF41B3CB3BB")
    
public boolean containsValue(String value) {
        return mCapabilities.containsValue(value);
    }

    /**
     * Returns a set containing all of the mappings in this map. Each mapping is
     * an instance of {@link Map.Entry}. As the set is backed by this map,
     * changes in one will be reflected in the other.
     *
     * @return a set of the mappings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.874 -0500", hash_original_method = "9F2F3F77DD27B21E35B683D345FC2FEC", hash_generated_method = "755707EB1E2137FAFC3B0CF3BE4FFC87")
    
public Set<Entry<Integer, String>> entrySet() {
        return mCapabilities.entrySet();
    }

    /**
     * @return the set of the keys.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.876 -0500", hash_original_method = "9EFA80A4731E36F41CEC9CDBD3C0FD66", hash_generated_method = "4E58C88893314F849A019DF519F27D7A")
    
public Set<Integer> keySet() {
        return mCapabilities.keySet();
    }

    /**
     * @return the set of values
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.878 -0500", hash_original_method = "3BC9717E7FFAE02D41102E4F5DA33838", hash_generated_method = "A3BCBA0C543D546EA56873525C4045A9")
    
public Collection<String> values() {
        return mCapabilities.values();
    }
    
    public static final class Key {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.797 -0500", hash_original_field = "8EECCF3DA1CE88C8CDE1B48E2D2B0766", hash_generated_field = "55E505A35A68C51C32DD8BDD97ADD9B0")

        public final static int RO_NETWORK_TYPE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.800 -0500", hash_original_field = "CA9579D1CFB3410A9A3297056DAC2786", hash_generated_field = "0AC1B312664003BD34F4455A13DBB769")

        public final static int RW_DESIRED_FWD_BW = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.803 -0500", hash_original_field = "704266798C91D9E2DDA1B28AC609C5DC", hash_generated_field = "5A7787D9FED23FFC9069D08E91F0338D")

        public final static int RW_REQUIRED_FWD_BW = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.805 -0500", hash_original_field = "B2D24476BF1909E23A9B066170CB425E", hash_generated_field = "EADE11CE71524B0FCE546A4CC13C6539")

        public final static int RO_AVAILABLE_FWD_BW = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.807 -0500", hash_original_field = "736B50908AB394647CE7B9DDA2238F6E", hash_generated_field = "798ECDF7ACC28C0C80BB118D4F98C9EC")

        public final static int RW_DESIRED_REV_BW = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.810 -0500", hash_original_field = "BBDF3AAF0CC427F51C7478E61378F149", hash_generated_field = "3BF306EE2F96FDA154DD648A809061BD")

        public final static int RW_REQUIRED_REV_BW = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.812 -0500", hash_original_field = "44A971B5F3AC876B0D1CAAA30639DAA2", hash_generated_field = "A720D19B3CCA6FE85AE8128876ACAD59")

        public final static int RO_AVAILABLE_REV_BW = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.815 -0500", hash_original_field = "CF198D66EF513AE094A4839132CA006C", hash_generated_field = "3F33F0C47B54048BC0FC0B3A88D0EEEB")

        public final static int RW_MAX_ALLOWED_LATENCY = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.817 -0500", hash_original_field = "D75CBA1C8CFB0D0C221AC6BC3D800ACB", hash_generated_field = "3477642B3F38F4F32B7F16C1F5E19DC2")

        public final static int RO_BOUND_INTERFACE = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.820 -0500", hash_original_field = "14FEE05E530E3D0156ACFF0EFE2EF692", hash_generated_field = "7C84ACC0DE5244183CCDA7A00856BD83")

        public final static int RO_PHYSICAL_INTERFACE = 10;
        /** No constructor */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.795 -0500", hash_original_method = "63943B74C3B7537BF21BF313857C8294", hash_generated_method = "52B02B1264CE9A8840E58840CFB1B96A")
        
private Key() {}
    }
    
    public static final class Role {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.828 -0500", hash_original_field = "383C7B3696D501394562C4A1D8981CA7", hash_generated_field = "5C22EFDF94B8F9ADD88BC20D2726357A")

        // code these to match

        /** Default Role */
        public static final String DEFAULT = "default";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.831 -0500", hash_original_field = "EFE3601B09015D689C77357897DA05F8", hash_generated_field = "96A741C4F469B69BA10EEB799EC008A3")

        public static final String BULK_DOWNLOAD = "bulk.download";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.833 -0500", hash_original_field = "D7657FC564F8F0DAC6BD4C169D643DA7", hash_generated_field = "34F02A32AB1949293FE186C9597A3656")

        public static final String BULK_UPLOAD = "bulk.upload";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.835 -0500", hash_original_field = "96A9A4B634167969B3C2C91ECA75B42D", hash_generated_field = "9A988D14E1E791EC8457542EBF469B81")

        public static final String VOIP_24KBPS = "voip.24k";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.838 -0500", hash_original_field = "C428217381B0F6CAAF0EF48D3EE66FE0", hash_generated_field = "B7A966A9B689435B48F84A7562F005E9")

        public static final String VOIP_32KBPS = "voip.32k";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.840 -0500", hash_original_field = "2B3BF7D4E12024C649C8CD0E4C9B03F6", hash_generated_field = "0D56ABC4CDA6FD96229C5B44A6DB3E3E")

        public static final String VIDEO_STREAMING_480P = "video.streaming.480p";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.843 -0500", hash_original_field = "E9409C854E812718778A3EAAD08AD36E", hash_generated_field = "01E2D3B0EF6C11725E1E1DCE9732A07A")

        public static final String VIDEO_STREAMING_720I = "video.streaming.720i";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.845 -0500", hash_original_field = "BD20F47AC46841E273AC58F82217B5E9", hash_generated_field = "2BCCE7D924690F2A06AFF84D40F83D67")

        public static final String VIDEO_CHAT_360P = "video.chat.360p";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.848 -0500", hash_original_field = "2B4659EDB4814BE5469950DB6E4FC10B", hash_generated_field = "8DECC40EEE8A771AAC08864DDB2E0C94")

        public static final String VIDEO_CHAT_480P = "video.chat.480i";
        /** No constructor */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.826 -0500", hash_original_method = "B6871343D9E854D112856D815CFF5530", hash_generated_method = "08F14CB6A5FF9E3090926A56C8693A01")
        
private Role() {}
    }

    /**
     * Implement the Parcelable interface
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.880 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /**
     * Convert to string for debugging
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.882 -0500", hash_original_method = "A28D232247661B92586D4FEECBA4E0AF", hash_generated_method = "A2782BC0D194A83092DA7CBB022AC362")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean firstTime = true;
        for (Entry<Integer, String> entry : mCapabilities.entrySet()) {
            if (firstTime) {
                firstTime = false;
            } else {
                sb.append(",");
            }
            sb.append(entry.getKey());
            sb.append(":\"");
            sb.append(entry.getValue());
            sb.append("\"");
            return mCapabilities.toString();
        }
        return sb.toString();
    }

    /**
     * Implement the Parcelable interface.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.885 -0500", hash_original_method = "76DC40F01B1B28CF1F7E32C3EB72CACA", hash_generated_method = "92CF2FE8CC2C838B673167A60F18DE24")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mCapabilities.size());
        for (Entry<Integer, String> entry : mCapabilities.entrySet()) {
            dest.writeInt(entry.getKey().intValue());
            dest.writeString(entry.getValue());
        }
    }
    // orphaned legacy method
    public LinkCapabilities createFromParcel(Parcel in) {
                LinkCapabilities capabilities = new LinkCapabilities();
                int size = in.readInt();
                while (size-- != 0) {
                    int key = in.readInt();
                    String value = in.readString();
                    capabilities.mCapabilities.put(key, value);
                }
                return capabilities;
            }
    
    // orphaned legacy method
    public LinkCapabilities[] newArray(int size) {
                return new LinkCapabilities[size];
            }
    
}

