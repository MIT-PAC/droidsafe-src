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

/**
 * Defines constants that are used by the DRM framework.
 *
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class DrmStore {
    /**
     * Interface definition for the columns that represent DRM constraints.
     */
    public interface ConstraintsColumns {
        /**
         * The maximum repeat count.
         * <p>
         * Type: INTEGER
         */
        public static final String MAX_REPEAT_COUNT = "max_repeat_count";

        /**
         * The remaining repeat count.
         * <p>
         * Type: INTEGER
         */
        public static final String REMAINING_REPEAT_COUNT = "remaining_repeat_count";

        /**
         * The time before which the rights-protected file cannot be played/viewed.
         * <p>
         * Type: TEXT
         */
        public static final String LICENSE_START_TIME = "license_start_time";

        /**
         * The time after which the rights-protected file cannot be played/viewed.
         * <p>
         * Type: TEXT
         */
        public static final String LICENSE_EXPIRY_TIME = "license_expiry_time";

        /**
         * The available time left before the license expires.
         * <p>
         * Type: TEXT
         */
        public static final String LICENSE_AVAILABLE_TIME = "license_available_time";

        /**
         * The data stream for extended metadata.
         * <p>
         * Type: TEXT
         */
        public static final String EXTENDED_METADATA = "extended_metadata";
    }

    /**
     * Defines DRM object types.
     */
    public static class DrmObjectType {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.528 -0400", hash_original_field = "630F261B72BC984474521B3779DBC6EA", hash_generated_field = "D8364C9358DBF2BC4CD4A049D2DF28F8")

        public static final int UNKNOWN = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.533 -0400", hash_original_field = "5F68676063469D9071F909011A954663", hash_generated_field = "500B290DBF176727AE7352C9BE8D3B9C")

        public static final int CONTENT = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.539 -0400", hash_original_field = "ABD174C1A3909047DFE42AAC5C4D7C4F", hash_generated_field = "2079596B0B8DC5DEFA6A2EC931A6E20E")

        public static final int RIGHTS_OBJECT = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.546 -0400", hash_original_field = "AC916C33C7580C089B68C7C5D5834456", hash_generated_field = "023FF4690BA565040B18D0A0F30DBDE0")

        public static final int TRIGGER_OBJECT = 0x03;
    }

    /**
     * Defines playback states for content.
     */
    public static class Playback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.558 -0400", hash_original_field = "04A43EEE058F79CAE4C81E54D0CC1655", hash_generated_field = "40362992925735FC2271D9EA93C6F178")

        public static final int START = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.563 -0400", hash_original_field = "7167E6F75326BB31BD2232FE4B408BE1", hash_generated_field = "FBC727CC01B0AD24D3C78E61AADEE6BE")

        public static final int STOP = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.569 -0400", hash_original_field = "F2AC2DD95F8759BA8EC5FF33A664DB05", hash_generated_field = "A789D06AC69230E21C9AFE72EB9D6D4C")

        public static final int PAUSE = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.574 -0400", hash_original_field = "423CC09782418BDF698B5C9D47DE6C1C", hash_generated_field = "6C043516EE4B36C733FB8BF345048D39")

        public static final int RESUME = 0x03;

        /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.579 -0400", hash_original_method = "CD3A25344A827651B93960123C3D64DF", hash_generated_method = "F174A020B331913AD65FF30BFBEB3DB9")
        
static boolean isValid(int playbackStatus) {
            boolean isValid = false;

            switch (playbackStatus) {
                case START:
                case STOP:
                case PAUSE:
                case RESUME:
                    isValid = true;
            }
            return isValid;
        }
    }

    /**
     * Defines actions that can be performed on rights-protected content.
     */
    public static class Action {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.590 -0400", hash_original_field = "7733FDB23973694B51B5DA9DDBFA76DC", hash_generated_field = "E0BD1DE1292878FB696C6E9C00FF91C6")

        public static final int DEFAULT = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.595 -0400", hash_original_field = "D6A7F81A8CE3681BCE4A4440D7B1DE90", hash_generated_field = "56E460D4DF9958A70A71E843670E4D3E")

        public static final int PLAY = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.600 -0400", hash_original_field = "A3ECDB7236F1E3CC25A9A5C96F536160", hash_generated_field = "58BC6D75267AA546560E8F03E877D524")

        public static final int RINGTONE = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.606 -0400", hash_original_field = "7C5114DA134256E5C4DD8FA70441DD6D", hash_generated_field = "E099887F06B12936B90BF63972F367DA")

        public static final int TRANSFER = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.612 -0400", hash_original_field = "962E69956ED3ED2B292AACA6BB024FBC", hash_generated_field = "8981C68BB8336DDD5E703EB0228860C4")

        public static final int OUTPUT = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.620 -0400", hash_original_field = "EC02F3AA1D3DC1A8981D00DD832B30B6", hash_generated_field = "A8B74A7742246A9E9E4BDBF20ED03F6C")

        public static final int PREVIEW = 0x05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.625 -0400", hash_original_field = "C72B5AC4D85E41E21F1BB4A1222A844B", hash_generated_field = "51399703BC4F0AF901064D16B0AD40C3")

        public static final int EXECUTE = 0x06;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.630 -0400", hash_original_field = "1406F995419102CBF0C99D8D173DC9B6", hash_generated_field = "18326BBD328215E4725B7F5C8EB42BDB")

        public static final int DISPLAY = 0x07;

        /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.634 -0400", hash_original_method = "4958E14D7D057E8BBBC9E43E94BFE7FA", hash_generated_method = "47D4BE9C3D17D975FCDA84A7D3DE7D3D")
        
static boolean isValid(int action) {
            boolean isValid = false;

            switch (action) {
                case DEFAULT:
                case PLAY:
                case RINGTONE:
                case TRANSFER:
                case OUTPUT:
                case PREVIEW:
                case EXECUTE:
                case DISPLAY:
                    isValid = true;
            }
            return isValid;
        }
    }

    /**
     * Defines status notifications for digital rights.
     */
    public static class RightsStatus {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.646 -0400", hash_original_field = "B56E48B6E513BE678E4A86A5761FE799", hash_generated_field = "EEE44F4186F11BC963C706511CCF2586")

        public static final int RIGHTS_VALID = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.651 -0400", hash_original_field = "D12FA3D698A36F59A1C87D02505E06E0", hash_generated_field = "EEE5F1DE8DE299C9CD4504A9D6D85784")

        public static final int RIGHTS_INVALID = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.657 -0400", hash_original_field = "1DADFFEB2FD39485E7CD25292D4B611C", hash_generated_field = "33CD698701196B7901D3A034079414D2")

        public static final int RIGHTS_EXPIRED = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.663 -0400", hash_original_field = "1C592DE99CE438803F5C5C57C7736AEF", hash_generated_field = "3D4491603CD8EF953700D17D5EA65062")

        public static final int RIGHTS_NOT_ACQUIRED = 0x03;
    }
}

