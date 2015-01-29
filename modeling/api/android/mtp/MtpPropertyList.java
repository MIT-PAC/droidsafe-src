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

package android.mtp;

/**
 * Encapsulates the ObjectPropList dataset used by the GetObjectPropList command.
 * The fields of this class are read by JNI code in android_media_MtpDatabase.cpp
 */

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
class MtpPropertyList {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.173 -0400", hash_original_field = "228E80965D19F3262507FB2E30484C98", hash_generated_field = "C71F96D16C33B34D6BB40030CD898648")

    private int             mCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.175 -0400", hash_original_field = "D7F38B5F52A0797B2EBB6AFB2F40BD92", hash_generated_field = "07593739EA51894193F3BFC61924FDA8")

    private  int       mMaxCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.177 -0400", hash_original_field = "898029569E5207542E445F1B5791BBF2", hash_generated_field = "98989C4E13E8ECB0301B8EFCE2329533")

    public int              mResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.178 -0400", hash_original_field = "2FFF7832951F5F49A3B741C12A5644C9", hash_generated_field = "B9E6872499B48D61D1ABE1705CF2226B")

    public  int[]      mObjectHandles;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.180 -0400", hash_original_field = "30C873D1F0121EE33A00A1059BA70B09", hash_generated_field = "30737F02272B434DE5E7E285E9BBDB25")

    public  int[]      mPropertyCodes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.182 -0400", hash_original_field = "EB9E197DEB1A776164B934F9157D2B32", hash_generated_field = "BA8908F55700524B2C2D2B64ACD328BD")

    public  int[]     mDataTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.183 -0400", hash_original_field = "8FE32227E25ACD9913BA36EF7B8FC95F", hash_generated_field = "DDEC1EDB350C422DC2848A8AB72D4532")

    public long[]     mLongValues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.184 -0400", hash_original_field = "DDDF9B37DEA497C9DF7947387D29338F", hash_generated_field = "F3CF22D1089516D2D87A916F760B7260")

    public String[]   mStringValues;

    // constructor only called from MtpDatabase
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.186 -0400", hash_original_method = "126B72BABB884B65EA227741BF12830F", hash_generated_method = "F3A76A3A6FA62909A7459F870ED2F9F5")
    
public MtpPropertyList(int maxCount, int result) {
        mMaxCount = maxCount;
        mResult = result;
        mObjectHandles = new int[maxCount];
        mPropertyCodes = new int[maxCount];
        mDataTypes = new int[maxCount];
        // mLongValues and mStringValues are created lazily since both might not be necessary
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.188 -0400", hash_original_method = "C1422EC3819F8D72F58479F0FBE1A437", hash_generated_method = "436E81FBBC150B08AC116FE3BB7A8AD1")
    
public void append(int handle, int property, int type, long value) {
        int index = mCount++;
        if (mLongValues == null) {
            mLongValues = new long[mMaxCount];
        }
        mObjectHandles[index] = handle;
        mPropertyCodes[index] = property;
        mDataTypes[index] = type;
        mLongValues[index] = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.190 -0400", hash_original_method = "8D0659C76375CF4AF0ED14B435A77469", hash_generated_method = "81E4B40A704F89E731906B088C5B6F33")
    
public void append(int handle, int property, String value) {
        int index = mCount++;
        if (mStringValues == null) {
            mStringValues = new String[mMaxCount];
        }
        mObjectHandles[index] = handle;
        mPropertyCodes[index] = property;
        mDataTypes[index] = MtpConstants.TYPE_STR;
        mStringValues[index] = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.191 -0400", hash_original_method = "C5FB776C46261ADEAAB7BAFC33ED4CEB", hash_generated_method = "5700F2E4781F15FCE83DF87401F3B06D")
    
public void setResult(int result) {
        mResult = result;
    }
}
