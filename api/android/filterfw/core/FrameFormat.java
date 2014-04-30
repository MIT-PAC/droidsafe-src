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

package android.filterfw.core;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.KeyValueMap;
import android.filterfw.core.MutableFrameFormat;

import java.util.Arrays;
import java.util.Map.Entry;

/**
 * @hide
 */
public class FrameFormat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.100 -0400", hash_original_field = "7238CCD717BE93B5CF613602AFA78E06", hash_generated_field = "F2E2C410BC71BBDA5079A4E8EEE86DDD")

    public static final int TYPE_UNSPECIFIED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.102 -0400", hash_original_field = "8AFD03C3C7AB96D86519219CCA99152B", hash_generated_field = "0F48A43E665494C72A8C3667B980966C")

    public static final int TYPE_BIT         = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.105 -0400", hash_original_field = "C2946D1EB25615A1C24F1728F591B9DB", hash_generated_field = "C92B977A6BEAE4337700C499F7EDB466")

    public static final int TYPE_BYTE        = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.107 -0400", hash_original_field = "C469C72D472B81642F4029730D63B20A", hash_generated_field = "F07AD5EF66DBDAB2970C18D9DE665FA5")

    public static final int TYPE_INT16       = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.110 -0400", hash_original_field = "8482662FF4406ABB96EDCAAD4B692756", hash_generated_field = "55361188A110BC1A9010F7D8E1DCC791")

    public static final int TYPE_INT32       = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.112 -0400", hash_original_field = "4A721AF6B8B9389123911079E5AFC575", hash_generated_field = "1FA0BA22C1E974D75177246C9553A016")

    public static final int TYPE_FLOAT       = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.115 -0400", hash_original_field = "0F34A4011B3B199A540604612B52990F", hash_generated_field = "C530AECD68FEED55910A50D6042096ED")

    public static final int TYPE_DOUBLE      = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.119 -0400", hash_original_field = "5BD1BA817ABA498BF9E2BEC9ADD8DDE5", hash_generated_field = "7C8D013F4CD9C7E1611FA959B2823A4E")

    public static final int TYPE_POINTER     = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.121 -0400", hash_original_field = "D0073AFFA5EF1B4F862459F7CF0F33B4", hash_generated_field = "96E087865E0D54889B7E1292D9AA6C20")

    public static final int TYPE_OBJECT      = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.124 -0400", hash_original_field = "9A92F81D69A4AE2A934944214A907F8D", hash_generated_field = "200ED2049589639E67A8D67F169736C9")

    public static final int TARGET_UNSPECIFIED  = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.126 -0400", hash_original_field = "453CD4AB29982F3BF5984560F7C19E80", hash_generated_field = "D9B3F9EC92D312930F7E0952598DB0B5")

    public static final int TARGET_SIMPLE       = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.129 -0400", hash_original_field = "490521C76B17FE5E67233763D52E580A", hash_generated_field = "FB4814A1CC899C49DA69164D5416F951")

    public static final int TARGET_NATIVE       = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.132 -0400", hash_original_field = "95B05E97BA21B200283DEF05AE51F18C", hash_generated_field = "04C083D5FAF9BD0D2AC8FE6CE5C19F70")

    public static final int TARGET_GPU          = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.134 -0400", hash_original_field = "C94F1A22CFF4CD2CBF56190E65EFEF50", hash_generated_field = "14E1BD1700237DDCF97C9D394B004014")

    public static final int TARGET_VERTEXBUFFER = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.137 -0400", hash_original_field = "93BF95197B36DE911815C72D76CCB09B", hash_generated_field = "D7C4239B5D5B43EF7D74EBF94495EB47")

    public static final int TARGET_RS           = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.140 -0400", hash_original_field = "E1235BD0F6CB8DED869C38A2746475D9", hash_generated_field = "E5698265451CFAA66DAB5BD4C45A00B7")

    public static final int SIZE_UNSPECIFIED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.143 -0400", hash_original_field = "18B97C1FE372E05C3039F47D35F4D606", hash_generated_field = "F4055516C2BACD4B4606D1B54CA12A9F")

    // intializers use a proper BPS.
    public static final int BYTES_PER_SAMPLE_UNSPECIFIED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.145 -0400", hash_original_field = "0C97CE321F46D940A744BD9E23D0B5CD", hash_generated_field = "A6B207C2E87211FA768435B542D19962")

    protected static final int SIZE_UNKNOWN = -1;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.169 -0400", hash_original_method = "5C46E2441F1B30197999E15B0B4847BD", hash_generated_method = "902C82AF4E96DEFDB94CBBF17331786F")
    
public static FrameFormat unspecified() {
        return new FrameFormat(TYPE_UNSPECIFIED, TARGET_UNSPECIFIED);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.224 -0400", hash_original_method = "E356D200528F2653A727E4590A11C41D", hash_generated_method = "885CB4A807369D3D3BEDF9711DE0A532")
    
public static int bytesPerSampleOf(int baseType) {
        // Defaults based on base-type
        switch (baseType) {
            case TYPE_BIT:
            case TYPE_BYTE:
                return 1;
            case TYPE_INT16:
                return 2;
            case TYPE_INT32:
            case TYPE_FLOAT:
            case TYPE_POINTER:
                return 4;
            case TYPE_DOUBLE:
                return 8;
            default:
                return 1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.227 -0400", hash_original_method = "23A0294697BDF217053C663669256E76", hash_generated_method = "63DA5368A3BCC1A5291DB3F56E7CECC0")
    
public static String dimensionsToString(int[] dimensions) {
        StringBuffer buffer = new StringBuffer();
        if (dimensions != null) {
            int n = dimensions.length;
            for (int i = 0; i < n; ++i) {
                if (dimensions[i] == SIZE_UNSPECIFIED) {
                    buffer.append("[]");
                } else {
                    buffer.append("[" + String.valueOf(dimensions[i]) + "]");
                }
            }
        }
        return buffer.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.230 -0400", hash_original_method = "A7593001F3AFFF4747E559FAA61243DC", hash_generated_method = "80B3ABA3B20CF89C0B3C54A740722E83")
    
public static String baseTypeToString(int baseType) {
        switch (baseType) {
            case TYPE_UNSPECIFIED: return "unspecified";
            case TYPE_BIT:         return "bit";
            case TYPE_BYTE:        return "byte";
            case TYPE_INT16:       return "int";
            case TYPE_INT32:       return "int";
            case TYPE_FLOAT:       return "float";
            case TYPE_DOUBLE:      return "double";
            case TYPE_POINTER:     return "pointer";
            case TYPE_OBJECT:      return "object";
            default:               return "unknown";
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.232 -0400", hash_original_method = "F2527E999F17E58F84BADEDC33C4C8C0", hash_generated_method = "358556FE92689537DF2B04DB4B62E87B")
    
public static String targetToString(int target) {
        switch (target) {
            case TARGET_UNSPECIFIED:  return "unspecified";
            case TARGET_SIMPLE:       return "simple";
            case TARGET_NATIVE:       return "native";
            case TARGET_GPU:          return "gpu";
            case TARGET_VERTEXBUFFER: return "vbo";
            case TARGET_RS:           return "renderscript";
            default:                  return "unknown";
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.236 -0400", hash_original_method = "BF37C56AB048870EADD285C7A93F20C1", hash_generated_method = "EF10A75EA90C512ABEE52F0FD5C98A06")
    
public static String metaDataToString(KeyValueMap metaData) {
        if (metaData == null) {
            return "";
        } else {
            StringBuffer buffer = new StringBuffer();
            buffer.append("{ ");
            for (Entry<String, Object> entry : metaData.entrySet()) {
                buffer.append(entry.getKey() + ": " + entry.getValue() + " ");
            }
            buffer.append("}");
            return buffer.toString();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.239 -0400", hash_original_method = "8F04379187901E422F69DED9FBD70FBC", hash_generated_method = "6476FAC8F7BEC48FC67CB93345E7A8CD")
    
public static int readTargetString(String targetString) {
        if (targetString.equalsIgnoreCase("CPU") || targetString.equalsIgnoreCase("NATIVE")) {
            return FrameFormat.TARGET_NATIVE;
        } else if (targetString.equalsIgnoreCase("GPU")) {
            return FrameFormat.TARGET_GPU;
        } else if (targetString.equalsIgnoreCase("SIMPLE")) {
            return FrameFormat.TARGET_SIMPLE;
        } else if (targetString.equalsIgnoreCase("VERTEXBUFFER")) {
            return FrameFormat.TARGET_VERTEXBUFFER;
        } else if (targetString.equalsIgnoreCase("UNSPECIFIED")) {
            return FrameFormat.TARGET_UNSPECIFIED;
        } else {
            throw new RuntimeException("Unknown target type '" + targetString + "'!");
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.147 -0400", hash_original_field = "61CE6A84987000BFA7AFE7E837F48911", hash_generated_field = "4A4FC639A941091E7FA64DCDA1C3E16C")

    protected int mBaseType = TYPE_UNSPECIFIED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.150 -0400", hash_original_field = "92DA26A93A8B2EB4A0013366199D33F2", hash_generated_field = "C274EA4A86BDB0DFEE2336AC911564CE")

    protected int mBytesPerSample = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.153 -0400", hash_original_field = "EF3489C2F1EB4B60FE03FCB3CD37DF0E", hash_generated_field = "CBBAFC3DA9BBC206981A74C5C508347A")

    protected int mSize = SIZE_UNKNOWN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.155 -0400", hash_original_field = "BDB4891D53C19E4C031F59302B8BB789", hash_generated_field = "9357510D6E80302F67BA8D1612AF3467")

    protected int mTarget = TARGET_UNSPECIFIED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.157 -0400", hash_original_field = "162CF82E01D10E2801F9861DE7FAF63E", hash_generated_field = "78693E7CDAAEB959AFEFAB2497E15AAD")

    protected int[] mDimensions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.159 -0400", hash_original_field = "22B9368DC96444465CB49FC04B3EC176", hash_generated_field = "032FBA39FF3842263FA84FD4B52349AA")

    protected KeyValueMap mMetaData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.162 -0400", hash_original_field = "88EC485339DC299634B15991EB5C2B93", hash_generated_field = "E29B09C758FE13B43BF2FFCACAA8C4F1")

    protected Class mObjectClass;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.164 -0400", hash_original_method = "DFD8E2341B46A94437D34417CB850E27", hash_generated_method = "65FCB1B56EFCF0B413A2249F69F80299")
    
protected FrameFormat() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.166 -0400", hash_original_method = "6D62C9083AD1AD5BD944D3C9FD85D14C", hash_generated_method = "3D39F603AC65340E785D604A37C162AA")
    
public FrameFormat(int baseType, int target) {
        mBaseType = baseType;
        mTarget = target;
        initDefaults();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.171 -0400", hash_original_method = "CF12504C71D31468AAA254CAD38F60E6", hash_generated_method = "3D112640513E32ED68FEC8F34850316E")
    
public int getBaseType() {
        return mBaseType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.173 -0400", hash_original_method = "EE1338F4C0680B5082DF642D8B6C9442", hash_generated_method = "2D0EB780685B06E996BB16460E02C9EC")
    
public boolean isBinaryDataType() {
        return mBaseType >= TYPE_BIT && mBaseType <= TYPE_DOUBLE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.176 -0400", hash_original_method = "EF33CC91BF0D4ABA98EB390D7CE049C2", hash_generated_method = "C019605E737BA00E7D1595FA68F80168")
    
public int getBytesPerSample() {
        return mBytesPerSample;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.178 -0400", hash_original_method = "08FDCC2E4894BEDC6B2923531A0DB8C5", hash_generated_method = "B6D91A846B9809A575C3171F6E867C36")
    
public int getValuesPerSample() {
        return mBytesPerSample / bytesPerSampleOf(mBaseType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.180 -0400", hash_original_method = "FFC1AEB4961BC343241590FAF28BD6CB", hash_generated_method = "67E3844A05F4A3B937CD59F9D9CF6614")
    
public int getTarget() {
        return mTarget;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.182 -0400", hash_original_method = "8C36B21564C96C639885ED8546DB7DF1", hash_generated_method = "947DD23383189FA207D19F94A8761DF5")
    
public int[] getDimensions() {
        return mDimensions;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.184 -0400", hash_original_method = "6707D69382BA20B7C4F3DFF2F4E5D701", hash_generated_method = "A910F5F8FAADD0CF699B3A9CA8335B3B")
    
public int getDimension(int i) {
        return mDimensions[i];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.187 -0400", hash_original_method = "FFE235A6515A10518FE2745774F0A530", hash_generated_method = "D6C43B9B289B48D1CBBFC60CDC6BC711")
    
public int getDimensionCount() {
        return mDimensions == null ? 0 : mDimensions.length;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.189 -0400", hash_original_method = "E1FCE1E931AB78E3465E32E5FB3B893B", hash_generated_method = "878E9E094CE5D731525213048E17444F")
    
public boolean hasMetaKey(String key) {
        return mMetaData != null ? mMetaData.containsKey(key) : false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.191 -0400", hash_original_method = "DBD197CDB2C3459D416B67A7A2322FBA", hash_generated_method = "6E10FF0F651CDFB2EA88BCD15016CEF5")
    
public boolean hasMetaKey(String key, Class expectedClass) {
        if (mMetaData != null && mMetaData.containsKey(key)) {
            if (!expectedClass.isAssignableFrom(mMetaData.get(key).getClass())) {
                throw new RuntimeException(
                    "FrameFormat meta-key '" + key + "' is of type " +
                    mMetaData.get(key).getClass() + " but expected to be of type " +
                    expectedClass + "!");
            }
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.193 -0400", hash_original_method = "C7F6AE79F3EFED9D4395B87E765E0543", hash_generated_method = "8572DA004CCA69B0FB735E64FCD04FBA")
    
public Object getMetaValue(String key) {
        return mMetaData != null ? mMetaData.get(key) : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.196 -0400", hash_original_method = "7527E2912D72FC8E8E2E7922C86B49A8", hash_generated_method = "77D4AE5F2BFE11C5A2B29B0882688F0A")
    
public int getNumberOfDimensions() {
        return mDimensions != null ? mDimensions.length : 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.198 -0400", hash_original_method = "C1BE97C2857D748F002130BCB7EDE7B5", hash_generated_method = "4790A6BAF17C179456087B3C2FE2F097")
    
public int getLength() {
        return (mDimensions != null && mDimensions.length >= 1) ? mDimensions[0] : -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.200 -0400", hash_original_method = "407CA0B95ED2E649FF62427E610177CB", hash_generated_method = "BBB9C4C89AE6B6D3E19EE9933A40B001")
    
public int getWidth() {
        return getLength();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.202 -0400", hash_original_method = "EB1124BCDC1E12D2063310C4F943BA8E", hash_generated_method = "6832E5F4E330A5F55B187C39DB9D036E")
    
public int getHeight() {
        return (mDimensions != null && mDimensions.length >= 2) ? mDimensions[1] : -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.204 -0400", hash_original_method = "17FF0D5039FF6177CE0D107E59EAEF06", hash_generated_method = "47CD4248EFE4305DE230AF3BCE0F2AFA")
    
public int getDepth() {
        return (mDimensions != null && mDimensions.length >= 3) ? mDimensions[2] : -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.206 -0400", hash_original_method = "52F01264EA192A86C1C03DC8C7C7D442", hash_generated_method = "4410EBFDDFFA44B6C8CFD6E7C9A18B5C")
    
public int getSize() {
        if (mSize == SIZE_UNKNOWN) mSize = calcSize(mDimensions);
        return mSize;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.208 -0400", hash_original_method = "00445CB5A0AEBC34F9D565A633441303", hash_generated_method = "30DEA282E15CA84A45DBEBDA9B25B92A")
    
public Class getObjectClass() {
        return mObjectClass;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.212 -0400", hash_original_method = "BE383B84A8EF0B8DEC993FC84E334FAE", hash_generated_method = "4657272EC28DF2422122173150F2A231")
    
public MutableFrameFormat mutableCopy() {
        MutableFrameFormat result = new MutableFrameFormat();
        result.setBaseType(getBaseType());
        result.setTarget(getTarget());
        result.setBytesPerSample(getBytesPerSample());
        result.setDimensions(getDimensions());
        result.setObjectClass(getObjectClass());
        result.mMetaData = mMetaData == null ? null : (KeyValueMap)mMetaData.clone();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.214 -0400", hash_original_method = "E298C663AAA583E0B664950A4EE2E090", hash_generated_method = "79373C3B14CEF0EE89B35C9A93357A80")
    
@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof FrameFormat)) {
            return false;
        }

        FrameFormat format = (FrameFormat)object;
        return format.mBaseType == mBaseType &&
                format.mTarget == mTarget &&
                format.mBytesPerSample == mBytesPerSample &&
                Arrays.equals(format.mDimensions, mDimensions) &&
                format.mMetaData.equals(mMetaData);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.216 -0400", hash_original_method = "A79002FE25ABBFED3127FC65774BD513", hash_generated_method = "F71D9929D5A124CCA47169C19DC53072")
    
@Override
    public int hashCode() {
        return 4211 ^ mBaseType ^ mBytesPerSample ^ getSize();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.219 -0400", hash_original_method = "04AE298B9992062C3E42B3FEFD3B9DDA", hash_generated_method = "4E4599EBEC71CD5948458969D41474FB")
    
public boolean isCompatibleWith(FrameFormat specification) {
        // Check base type
        if (specification.getBaseType() != TYPE_UNSPECIFIED
            && getBaseType() != specification.getBaseType()) {
            return false;
        }

        // Check target
        if (specification.getTarget() != TARGET_UNSPECIFIED
            && getTarget() != specification.getTarget()) {
            return false;
        }

        // Check bytes per sample
        if (specification.getBytesPerSample() != BYTES_PER_SAMPLE_UNSPECIFIED
            && getBytesPerSample() != specification.getBytesPerSample()) {
            return false;
        }

        // Check number of dimensions
        if (specification.getDimensionCount() > 0
            && getDimensionCount() != specification.getDimensionCount()) {
            return false;
        }

        // Check dimensions
        for (int i = 0; i < specification.getDimensionCount(); ++i) {
            int specDim = specification.getDimension(i);
            if (specDim != SIZE_UNSPECIFIED && getDimension(i) != specDim) {
                return false;
            }
        }

        // Check class
        if (specification.getObjectClass() != null) {
            if (getObjectClass() == null
                || !specification.getObjectClass().isAssignableFrom(getObjectClass())) {
                return false;
            }
        }

        // Check meta-data
        if (specification.mMetaData != null) {
            for (String specKey : specification.mMetaData.keySet()) {
                if (mMetaData == null
                || !mMetaData.containsKey(specKey)
                || !mMetaData.get(specKey).equals(specification.mMetaData.get(specKey))) {
                    return false;
                }
            }
        }

        // Passed all the tests
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.222 -0400", hash_original_method = "D71830C8DCB36E80E0266B111BD82A11", hash_generated_method = "C82847859A2BCC47EA865E3F6EC8C0FF")
    
public boolean mayBeCompatibleWith(FrameFormat specification) {
        // Check base type
        if (specification.getBaseType() != TYPE_UNSPECIFIED
            && getBaseType() != TYPE_UNSPECIFIED
            && getBaseType() != specification.getBaseType()) {
            return false;
        }

        // Check target
        if (specification.getTarget() != TARGET_UNSPECIFIED
            && getTarget() != TARGET_UNSPECIFIED
            && getTarget() != specification.getTarget()) {
            return false;
        }

        // Check bytes per sample
        if (specification.getBytesPerSample() != BYTES_PER_SAMPLE_UNSPECIFIED
            && getBytesPerSample() != BYTES_PER_SAMPLE_UNSPECIFIED
            && getBytesPerSample() != specification.getBytesPerSample()) {
            return false;
        }

        // Check number of dimensions
        if (specification.getDimensionCount() > 0
            && getDimensionCount() > 0
            && getDimensionCount() != specification.getDimensionCount()) {
            return false;
        }

        // Check dimensions
        for (int i = 0; i < specification.getDimensionCount(); ++i) {
            int specDim = specification.getDimension(i);
            if (specDim != SIZE_UNSPECIFIED
                && getDimension(i) != SIZE_UNSPECIFIED
                && getDimension(i) != specDim) {
                return false;
            }
        }

        // Check class
        if (specification.getObjectClass() != null && getObjectClass() != null) {
            if (!specification.getObjectClass().isAssignableFrom(getObjectClass())) {
                return false;
            }
        }

        // Check meta-data
        if (specification.mMetaData != null && mMetaData != null) {
            for (String specKey : specification.mMetaData.keySet()) {
                if (mMetaData.containsKey(specKey)
                    && !mMetaData.get(specKey).equals(specification.mMetaData.get(specKey))) {
                    return false;
                }
            }
        }

        // Passed all the tests
        return true;
    }

    // TODO: FromString

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.241 -0400", hash_original_method = "B6FCC89C3BA055112B291D728ED1D4AF", hash_generated_method = "62E5B13AC5D244ABC6541DF84231D678")
    
public String toString() {
        int valuesPerSample = getValuesPerSample();
        String sampleCountString = valuesPerSample == 1 ? "" : String.valueOf(valuesPerSample);
        String targetString = mTarget == TARGET_UNSPECIFIED ? "" : (targetToString(mTarget) + " ");
        String classString = mObjectClass == null
            ? ""
            : (" class(" + mObjectClass.getSimpleName() + ") ");

        return targetString
            + baseTypeToString(mBaseType)
            + sampleCountString
            + dimensionsToString(mDimensions)
            + classString
            + metaDataToString(mMetaData);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.243 -0400", hash_original_method = "2D9170B9F12B5C8B02C601FF6A4E9541", hash_generated_method = "79C9E5BE5F241BCF8D7408D54EADBC45")
    
private void initDefaults() {
        mBytesPerSample = bytesPerSampleOf(mBaseType);
    }

    // Core internal methods ///////////////////////////////////////////////////////////////////////
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.246 -0400", hash_original_method = "B6323D4C8C2E798104E7FD382E3844A6", hash_generated_method = "B6323D4C8C2E798104E7FD382E3844A6")
    
int calcSize(int[] dimensions) {
        if (dimensions != null && dimensions.length > 0) {
            int size = getBytesPerSample();
            for (int dim : dimensions) {
                size *= dim;
            }
            return size;
        }
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.247 -0400", hash_original_method = "ECC1233FAF2C9FF0AC5D3BED436B1F3E", hash_generated_method = "ECC1233FAF2C9FF0AC5D3BED436B1F3E")
    
boolean isReplaceableBy(FrameFormat format) {
        return mTarget == format.mTarget
            && getSize() == format.getSize()
            && Arrays.equals(format.mDimensions, mDimensions);
    }
}
