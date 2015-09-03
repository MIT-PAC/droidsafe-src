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


package android.support.v4.accessibilityservice;

import android.view.View;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;

/**
 * Helper for accessing features in {@link android.accessibilityservice.AccessibilityService}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class AccessibilityServiceInfoCompat {

    static interface AccessibilityServiceInfoVersionImpl {
        public String getId(AccessibilityServiceInfo info);
        public ResolveInfo getResolveInfo(AccessibilityServiceInfo info);
        public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo info);
        public String getDescription(AccessibilityServiceInfo info);
        public String getSettingsActivityName(AccessibilityServiceInfo info);
		public int getCapabilities(AccessibilityServiceInfo info);
    }

    static class AccessibilityServiceInfoStubImpl implements AccessibilityServiceInfoVersionImpl {

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.418 -0500", hash_original_method = "A15FD5B1C8395D8FF95B7562ADDD341F", hash_generated_method = "AD2D5EDD440A08E4F40B0155EF4B3201")
        
public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo info) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.423 -0500", hash_original_method = "986BE1D8C3F61DE0F19F6CBA91B93EEB", hash_generated_method = "29F71E584E9DF16CBA19D305C83FDBFF")
        
public String getDescription(AccessibilityServiceInfo info) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.429 -0500", hash_original_method = "8A91D45B5219E475F16B2DAF30CE548F", hash_generated_method = "C254DF787B47453A1D5E5EB4AC0F9522")
        
public String getId(AccessibilityServiceInfo info) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.435 -0500", hash_original_method = "D18216EFAFF993914311EDA9C00F3631", hash_generated_method = "8E622ADA6D85B225C67DBD1ACEF49958")
        
public ResolveInfo getResolveInfo(AccessibilityServiceInfo info) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.439 -0500", hash_original_method = "21E18BC1D0432717FEBEE4D997C92410", hash_generated_method = "A54D668862D3D25E9ACE5AD675D6349D")
        
public String getSettingsActivityName(AccessibilityServiceInfo info) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.225 -0400", hash_original_method = "EC8A1901225B013B0B3A0DC86A1C167F", hash_generated_method = "19EEC60656AC25E8A6E6B94507F43637")
            
public int getCapabilities(AccessibilityServiceInfo info) {
            return (getTaintInt() + info.getTaintInt() + info.eventTypes + 
            		info.feedbackType + info.flags);
        }}

    static class AccessibilityServiceInfoIcsImpl extends AccessibilityServiceInfoStubImpl {

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.448 -0500", hash_original_method = "497E7E79258DCCB7605C137F8A337AB1", hash_generated_method = "30D0150124FAE46913CDBD3AA9348FC0")
        
@Override
        public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo info) {
            return AccessibilityServiceInfoCompatIcs.getCanRetrieveWindowContent(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.453 -0500", hash_original_method = "C884D364E6E48230AE9C0C798413C87A", hash_generated_method = "7495C58650881275240EA8A0BEBA45A1")
        
@Override
        public String getDescription(AccessibilityServiceInfo info) {
            return AccessibilityServiceInfoCompatIcs.getDescription(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.459 -0500", hash_original_method = "228F0E112D921E596DFB28D4F863406B", hash_generated_method = "C398AFD9DD43336E4632A82ADFAB6CAE")
        
@Override
        public String getId(AccessibilityServiceInfo info) {
            return AccessibilityServiceInfoCompatIcs.getId(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.464 -0500", hash_original_method = "1153DC68C2F32B53E35A362CA48EDB7E", hash_generated_method = "5644DB57AB8187A592784A31E5B7B9A0")
        
@Override
        public ResolveInfo getResolveInfo(AccessibilityServiceInfo info) {
            return AccessibilityServiceInfoCompatIcs.getResolveInfo(info);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.472 -0500", hash_original_method = "230CF3C8DF7D3EF62EB37F35BBC9CA67", hash_generated_method = "114CD468FD4390BCFDFE66C9682C8682")
        
@Override
        public String getSettingsActivityName(AccessibilityServiceInfo info) {
            return AccessibilityServiceInfoCompatIcs.getSettingsActivityName(info);
        }

        @DSVerified
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.337 -0400", hash_original_method = "ACCBB183B6E642285425334B680DB6A9", hash_generated_method = "20062B3E765C817001A85FF27AF4FD70")
            
@Override
        public int getCapabilities(AccessibilityServiceInfo info) {
            if (getCanRetrieveWindowContent(info)) {
                return CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT;
            }
            return 0;
        }}

    static {
        if (Build.VERSION.SDK_INT >= 14) { // ICS
            IMPL = new AccessibilityServiceInfoIcsImpl();
        } else {
            IMPL = new AccessibilityServiceInfoStubImpl();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.482 -0500", hash_original_field = "06E92EBA6EFADAF7E9703BD10F5C0C98", hash_generated_field = "1DC55DFB6E1C100103DCE6F7C5F9F7EF")

    private static  AccessibilityServiceInfoVersionImpl IMPL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.490 -0500", hash_original_field = "31B80D955EEE0256F9A05F7B5AF3D0EE", hash_generated_field = "F30739AC04BDBB3384FC429FE4C84EAD")

    public static final int FEEDBACK_ALL_MASK = 0xFFFFFFFF;

    /**
     * The accessibility service id.
     * <p>
     * <strong>Generated by the system.</strong>
     * </p>
     *
     * @return The id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.498 -0500", hash_original_method = "6DAF3F6C64E825294ECD3955D60E53B4", hash_generated_method = "0FE63D16852B30333156DFDC5BB47C1C")
    
public static String getId(AccessibilityServiceInfo info) {
        return IMPL.getId(info);
    }

    /**
     * The service {@link ResolveInfo}.
     * <p>
     * <strong>Generated by the system.</strong>
     * </p>
     *
     * @return The info.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.503 -0500", hash_original_method = "35784E0E143C84E305DF7AACFE5DCE22", hash_generated_method = "4095F6F754EDB887EE481DFB17055A90")
    
public static ResolveInfo getResolveInfo(AccessibilityServiceInfo info) {
        return IMPL.getResolveInfo(info);
    }

    /**
     * The settings activity name.
     * <p>
     * <strong>Statically set from {@link AccessibilityService#SERVICE_META_DATA
     * meta-data}.</strong>
     * </p>
     *
     * @return The settings activity name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.509 -0500", hash_original_method = "0D7DD92BA0AD6D5F16383DCB6B44098B", hash_generated_method = "D9625487BA97EAA7A82332E45BA00AFA")
    
public static String getSettingsActivityName(AccessibilityServiceInfo info) {
        return IMPL.getSettingsActivityName(info);
    }

    /**
     * Whether this service can retrieve the current window's content.
     * <p>
     * <strong>Statically set from {@link AccessibilityService#SERVICE_META_DATA
     * meta-data}.</strong>
     * </p>
     *
     * @return True window content can be retrieved.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.513 -0500", hash_original_method = "DFFF4903C821B1CDE953C116E3263265", hash_generated_method = "8D9B0FD55EF137B0FAF6B1BD88376623")
    
public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo info) {
        return IMPL.getCanRetrieveWindowContent(info);
    }

    /**
     * Description of the accessibility service.
     * <p>
     * <strong>Statically set from {@link AccessibilityService#SERVICE_META_DATA
     * meta-data}.</strong>
     * </p>
     *
     * @return The description.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.519 -0500", hash_original_method = "1142560551BD0DB62E7F5089BCA645FF", hash_generated_method = "AD788C1FF406F7A71C83D52EA7CF6C11")
    
public static String getDescription(AccessibilityServiceInfo info) {
        return IMPL.getDescription(info);
    }

    /**
     * Returns the string representation of a feedback type. For example,
     * {@link AccessibilityServiceInfo#FEEDBACK_SPOKEN} is represented by the
     * string FEEDBACK_SPOKEN.
     *
     * @param feedbackType The feedback type.
     * @return The string representation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.526 -0500", hash_original_method = "B234758162BC693C5F8A26E31C4C2156", hash_generated_method = "B6E2E4208EDFF1F61F24D507F16B772B")
    
public static String feedbackTypeToString(int feedbackType) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (feedbackType > 0) {
            final int feedbackTypeFlag = 1 << Integer.numberOfTrailingZeros(feedbackType);
            feedbackType &= ~feedbackTypeFlag;
            if (builder.length() > 1) {
                builder.append(", ");
            }
            switch (feedbackTypeFlag) {
                case AccessibilityServiceInfo.FEEDBACK_AUDIBLE:
                    builder.append("FEEDBACK_AUDIBLE");
                    break;
                case AccessibilityServiceInfo.FEEDBACK_HAPTIC:
                    builder.append("FEEDBACK_HAPTIC");
                    break;
                case AccessibilityServiceInfo.FEEDBACK_GENERIC:
                    builder.append("FEEDBACK_GENERIC");
                    break;
                case AccessibilityServiceInfo.FEEDBACK_SPOKEN:
                    builder.append("FEEDBACK_SPOKEN");
                    break;
                case AccessibilityServiceInfo.FEEDBACK_VISUAL:
                    builder.append("FEEDBACK_VISUAL");
                    break;
            }
        }
        builder.append("]");
        return builder.toString();
    }

    /**
     * Returns the string representation of a flag. For example,
     * {@link AccessibilityServiceInfo#DEFAULT} is represented by the
     * string DEFAULT.
     *
     * @param flag The flag.
     * @return The string representation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.618 -0400", hash_original_method = "96B8B553CC88EC0DC0759F644BC937CD", hash_generated_method = "91D3B9453C9D46A024D4ECD4198D83CE")
        
public static String flagToString(int flag) {
        switch (flag) {
            case DEFAULT:
                return "DEFAULT";
            case FLAG_INCLUDE_NOT_IMPORTANT_VIEWS:
                return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
            case FLAG_REQUEST_TOUCH_EXPLORATION_MODE:
                return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
            case FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY:
                return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            case FLAG_REPORT_VIEW_IDS:
                return "FLAG_REPORT_VIEW_IDS";
            case FLAG_REQUEST_FILTER_KEY_EVENTS:
                return "FLAG_REQUEST_FILTER_KEY_EVENTS";
            default:
                return null;
        }
    }

    /*
     * Hide constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.494 -0500", hash_original_method = "D8AB65AF287380F89DD694FBDE44A931", hash_generated_method = "F48AF8F7E07818646539A4B9CB89609E")
    
private AccessibilityServiceInfoCompat() {

    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.450 -0400", hash_original_field = "9D8D4B7DE27E4F9427860421CE4DEB03", hash_generated_field = "FE94292DDD96EE4FAFC2E9E731ACDB22")

    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.428 -0400", hash_original_field = "B259AB48442D40BACED387937394743F", hash_generated_field = "DCE06537B6C8FD31A49E492D27E3374F")

    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.438 -0400", hash_original_field = "21C1DEA63FDC0FCF41D12EAE81BF8AA2", hash_generated_field = "07583BF1B1AA775A3B9D5407EEC3FC66")

    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.556 -0400", hash_original_field = "8D65619BF7E3F3766AD6FC815A4C2053", hash_generated_field = "B34DF4A9762CB815474D6C84E75E3CF5")

    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.461 -0400", hash_original_field = "5E41DA159A6FB996594CBE4EC61373E8", hash_generated_field = "9F2F72BC7E0C6B19AF1E23D564D6599E")

    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.492 -0400", hash_original_field = "97C88284C7FB7A365D3D8A93DB373C8D", hash_generated_field = "4A56EABC83BFE9924F8C0DD07F573D25")

    /**
     * If an {@link AccessibilityService} is the default for a given type.
     * Default service is invoked only if no package specific one exists. In case of
     * more than one package specific service only the earlier registered is notified.
     */
    public static final int DEFAULT = 0x0000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.514 -0400", hash_original_field = "28543D65E80C959C2527EB1C506F60DA", hash_generated_field = "D38C55866ACFE90DBB9FBBE73A92BB80")

    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 0x0000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.471 -0400", hash_original_field = "E67320D5CB5602481239613A6250DBA5", hash_generated_field = "D422D1B6CE9FAD473E7A0F9D87986A96")

    /**
     * Denotes braille feedback.
     */
    public static final int FEEDBACK_BRAILLE = 0x0000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.546 -0400", hash_original_field = "114496861BE1718123DE556BA7C1D35E", hash_generated_field = "2A556F59F73D2B1EF7BB02B27022971A")

    public static final int FLAG_REPORT_VIEW_IDS = 0x00000010;

    /**
     * Returns the string representation of a capability. For example,
     * {@link #CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT} is represented
     * by the string CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT.
     *
     * @param capability The capability.
     * @return The string representation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.633 -0400", hash_original_method = "7FA21CC85C48F4B1A53A8E291ECF34E3", hash_generated_method = "05AE92646636384B077C50E81172D4FF")
        
public static String capabilityToString(int capability) {
        switch (capability) {
            case CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT:
                return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
            case CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION:
                return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
            case CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY:
                return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            case CAPABILITY_CAN_FILTER_KEY_EVENTS:
                return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
            default:
                return "UNKNOWN";
        }
    }

    /**
     * Returns the bit mask of capabilities this accessibility service has such as
     * being able to retrieve the active window content, etc.
     *
     * @param info The service info whose capabilities to get.
     * @return The capability bit mask.
     *
     * @see #CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT
     * @see #CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION
     * @see #CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY
     * @see #CAPABILITY_CAN_FILTER_KEY_EVENTS
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.624 -0400", hash_original_method = "A04AD5275C99D2EF1FD3813151BA5011", hash_generated_method = "5F0CAE2B4C7250D8FB1E79F0653931C9")
        
@DSVerified
@DSSafe
public static int getCapabilities(AccessibilityServiceInfo info) {
        return IMPL.getCapabilities(info);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.503 -0400", hash_original_field = "DCD3F800BE4342F731B4219875BB1E6A", hash_generated_field = "251A50501088BB4DF8F316AF88A200F0")

    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 0x0000002;

    static class AccessibilityServiceInfoJellyBeanMr2 extends AccessibilityServiceInfoIcsImpl {
    	AccessibilityServiceInfoJellyBeanMr2() {
    		super();
    	}
        @Override
        @DSVerified
        @DSSafe(DSCat.SAFE_LIST)
        public int getCapabilities(AccessibilityServiceInfo info) {
            return IMPL.getCapabilities(info);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 09:35:11.524 -0400", hash_original_field = "25F232DD6E2040B7C77EE1A0AB9D14D0", hash_generated_field = "13EF959FC2CD627C6CA7A8AAA2FAFF4C")

    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 0x00000008;}
