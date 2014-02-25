/*
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

package android.support.v13.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Fragment;

/**
 * Helper for accessing features in {@link Fragment} introduced after
 * API level 13 in a backwards compatible fashion.
 */
public class FragmentCompat {
    interface FragmentCompatImpl {
        void setMenuVisibility(Fragment f, boolean visible);
        void setUserVisibleHint(Fragment f, boolean deferStart);
    }

    static class BaseFragmentCompatImpl implements FragmentCompatImpl {
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.062 -0500", hash_original_method = "9F8A95DE14A0524E7FB0C0ECA04E3FAE", hash_generated_method = "A7E1928A87DBDF63A26BDEF7CBAB5636")
        
public void setMenuVisibility(Fragment f, boolean visible) {
        }
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.072 -0500", hash_original_method = "DC2BAF2B3904C7BC33F5325A36E0826A", hash_generated_method = "F3B4355B7F30F56CB4B115FA5C3642BA")
        
public void setUserVisibleHint(Fragment f, boolean deferStart) {
        }
    }
 
    static class ICSFragmentCompatImpl extends BaseFragmentCompatImpl {
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.086 -0500", hash_original_method = "326919093390048EDD9E5A0345C9914C", hash_generated_method = "A4F03F013C4F0B9EF71315888556AD5A")
        
@Override
        public void setMenuVisibility(Fragment f, boolean visible) {
            FragmentCompatICS.setMenuVisibility(f, visible);
        }
    }

    static class ICSMR1FragmentCompatImpl extends ICSFragmentCompatImpl {
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.098 -0500", hash_original_method = "8373BDD38ED54E996F20589432198E56", hash_generated_method = "5D397CCB867830ECDCF75A518B3E2BB6")
        
@Override
        public void setUserVisibleHint(Fragment f, boolean deferStart) {
            FragmentCompatICSMR1.setUserVisibleHint(f, deferStart);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.107 -0500", hash_original_field = "2D47DA7D9F49471D5F1CCBB525A1ADBC", hash_generated_field = "BAB880BB7B30705919FFDB6C331C875E")

    static  FragmentCompatImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 15) {
            IMPL = new ICSMR1FragmentCompatImpl();
        } else if (android.os.Build.VERSION.SDK_INT >= 14) {
            IMPL = new ICSFragmentCompatImpl();
        } else {
            IMPL = new BaseFragmentCompatImpl();
        }
    }
 
    /**
     * Call {@link Fragment#setMenuVisibility(boolean) Fragment.setMenuVisibility(boolean)}
     * if running on an appropriate version of the platform.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.111 -0500", hash_original_method = "505707145B11F2F7A9D476D6C14BDF50", hash_generated_method = "95367289856E946A915913A90DA671F2")
    
public static void setMenuVisibility(Fragment f, boolean visible) {
        IMPL.setMenuVisibility(f, visible);
    }

    /**
     * Call {@link Fragment#setUserVisibleHint(boolean) setUserVisibleHint(boolean)}
     * if running on an appropriate version of the platform.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:55.117 -0500", hash_original_method = "85CA412D8B601293E4563A0A40D2F36E", hash_generated_method = "8AFC8FA0A4016CAFC6AF8C60FDEC44D1")
    
public static void setUserVisibleHint(Fragment f, boolean deferStart) {
        IMPL.setUserVisibleHint(f, deferStart);
    }
}
