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


package android.filterfw.format;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.MutableFrameFormat;

/**
 * @hide
 */
public class PrimitiveFormat {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.690 -0400", hash_original_method = "1A757D9C42FF03C53BA5E7E68C54A9C0", hash_generated_method = "E96DA7C83E37120A9BE91F90EA739B33")
    
public static MutableFrameFormat createByteFormat(int count, int target) {
        return createFormat(FrameFormat.TYPE_BYTE, count, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.692 -0400", hash_original_method = "B460AF3407CD58831912B7FBB4EFD53C", hash_generated_method = "C1123F120431CA8BDCD3A2B227484C18")
    
public static MutableFrameFormat createInt16Format(int count, int target) {
        return createFormat(FrameFormat.TYPE_INT16, count, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.694 -0400", hash_original_method = "030A5808C125EBCA398FBA9336828AA9", hash_generated_method = "F952713E7CDB22AEF2AB51EE041E220F")
    
public static MutableFrameFormat createInt32Format(int count, int target) {
        return createFormat(FrameFormat.TYPE_INT32, count, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.696 -0400", hash_original_method = "D17300A9F5D27668B10E4F2D9AB72E61", hash_generated_method = "9A233112BA043D1F17EA0191ED19D546")
    
public static MutableFrameFormat createFloatFormat(int count, int target) {
        return createFormat(FrameFormat.TYPE_FLOAT, count, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.699 -0400", hash_original_method = "ECC09FD39B3C6B30213E8947E1EDD248", hash_generated_method = "A50FB630CE2DA3F147DC8A735C5E0F24")
    
public static MutableFrameFormat createDoubleFormat(int count, int target) {
        return createFormat(FrameFormat.TYPE_DOUBLE, count, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.701 -0400", hash_original_method = "524741FDB0B56BEBB522E6B99614FD2B", hash_generated_method = "B54C486AFC8992337ECB33C4C4658CAE")
    
public static MutableFrameFormat createByteFormat(int target) {
        return createFormat(FrameFormat.TYPE_BYTE, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.703 -0400", hash_original_method = "1B398C0ED65A5ACD57FA7B9348D5FB06", hash_generated_method = "A93C288CA287AA91D8331515723AC1B1")
    
public static MutableFrameFormat createInt16Format(int target) {
        return createFormat(FrameFormat.TYPE_INT16, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.705 -0400", hash_original_method = "EB137D2DCC02D4A2534CC1F549571F5F", hash_generated_method = "72205C33DB15F2128838289BF98F507C")
    
public static MutableFrameFormat createInt32Format(int target) {
        return createFormat(FrameFormat.TYPE_INT32, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.708 -0400", hash_original_method = "07A4119817789C2BCBE0672B158B6812", hash_generated_method = "3C14F4E8B7668F1E32F8F2CFFE4ED825")
    
public static MutableFrameFormat createFloatFormat(int target) {
        return createFormat(FrameFormat.TYPE_FLOAT, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.710 -0400", hash_original_method = "164BBBC025AD10173B033D35A212814D", hash_generated_method = "308FA8DB1404AC480921EFA48030AE7A")
    
public static MutableFrameFormat createDoubleFormat(int target) {
        return createFormat(FrameFormat.TYPE_DOUBLE, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.712 -0400", hash_original_method = "57A57FB2A51BE0BFAF94F545D616265B", hash_generated_method = "AC6D101378D503091AECA945EEE917C1")
    
private static MutableFrameFormat createFormat(int baseType, int count, int target) {
        MutableFrameFormat result = new MutableFrameFormat(baseType, target);
        result.setDimensions(count);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.714 -0400", hash_original_method = "678FBE886413735DA9D0A28F0BA6366F", hash_generated_method = "54CB834327A68A8491396218F3927CD1")
    
private static MutableFrameFormat createFormat(int baseType, int target) {
        MutableFrameFormat result = new MutableFrameFormat(baseType, target);
        result.setDimensionCount(1);
        return result;
    }
}
