/*
 * Copyright (C) 2012 The Android Open Source Project
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

package com.android.internal.os;

/**
 * Helper class for passing more arguments though a message
 * and avoiding allocation of a custom class for wrapping the
 * arguments. This class maintains a pool of instances and
 * it is responsibility of the client to recycle and instance
 * once it is no longer used.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class SomeArgs {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.065 -0400", hash_original_field = "3257F81BBFE679E3360141AA5EA9D518", hash_generated_field = "FB8E412EAB46029C42E8E38ED918C6D9")


    private static final int MAX_POOL_SIZE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.066 -0400", hash_original_field = "431887811C60AA064C83A8ADC55970D1", hash_generated_field = "28027F1656D714481ECBA65A21F4AB87")


    private static SomeArgs sPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.067 -0400", hash_original_field = "4147A9532CCAB604E1A40F8F844CAE62", hash_generated_field = "D185458A63BD443FF8514FC9B9E5705B")

    private static int sPoolSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.068 -0400", hash_original_field = "80BD8A730C8BC829BD11E3A3CFC39CA3", hash_generated_field = "D17501A54B3B4439D5926B465D95D3AD")

    private static Object sPoolLock = new Object();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.080 -0400", hash_original_method = "03EE5178F1E79CC11889B959D8E4B20C", hash_generated_method = "E2EBFE393CF8DDA96150DFE133B322B0")
    
public static SomeArgs obtain() {
        synchronized (sPoolLock) {
            if (sPoolSize > 0) {
                SomeArgs args = sPool;
                sPool = sPool.mNext;
                args.mNext = null;
                args.mInPool = false;
                sPoolSize--;
                return args;
            } else {
                return new SomeArgs();
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.069 -0400", hash_original_field = "10DB3D8812253573640BF0D1F91398D4", hash_generated_field = "DA4F0B9DBC6F4431600CE5D0AA462E29")


    private SomeArgs mNext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.070 -0400", hash_original_field = "04FFE5536DE08519A066D81D266DDE16", hash_generated_field = "4048EBE9D28A0D747CFE6CB5C420567A")


    private boolean mInPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.070 -0400", hash_original_field = "524E284308787C3B27AB4CD560A816CF", hash_generated_field = "F8BED0DABC2D7EE357C5667A5634389E")


    public Object arg1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.071 -0400", hash_original_field = "2CC0C93F38D97721E695C73C9F8BA144", hash_generated_field = "1AFBA2F52DF215183028C3B28AF50E99")

    public Object arg2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.072 -0400", hash_original_field = "F56E40D616F19E7BF075AC7D5ACFE7F9", hash_generated_field = "32BD50E19A34192D3D8DCA48249F94D1")

    public Object arg3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.073 -0400", hash_original_field = "110AC7B6C385C5FEFA73505247A775D3", hash_generated_field = "0B72EB80252CC488C537B500CEB079FF")

    public Object arg4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.073 -0400", hash_original_field = "C05E6E249CC11E2BC250C02452526683", hash_generated_field = "C2A1CAC728B22B90103C2DA44E9E548A")

    public Object arg5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.074 -0400", hash_original_field = "7F0B67CAA7215F665771089342F3DFC5", hash_generated_field = "FE0C48289B39F618BBE80AECCEF49180")

    public int argi1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.075 -0400", hash_original_field = "F1422FA73E9868B70AA2963A9422273F", hash_generated_field = "719DADFF01419F95FA55604041F222BD")

    public int argi2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.076 -0400", hash_original_field = "187B483800D059E986583827D0AD5CD5", hash_generated_field = "52D274C1AF69DED7FCB42CCCFE797C8A")

    public int argi3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.077 -0400", hash_original_field = "F11F8BD2887922A46A5D5562E88B306B", hash_generated_field = "D2E6B4388CD4F0A3834E1C138D70FE7A")

    public int argi4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.078 -0400", hash_original_field = "21DD335F5CEAE8AE91485453EDA375BC", hash_generated_field = "6A0B669EF9423FB5FE4F93600C0FAB3B")

    public int argi5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.078 -0400", hash_original_field = "D0688219C3DCED6A5722DDFD8AD664C7", hash_generated_field = "CDD9FE68E7B33662034DE6F2DF8370F4")

    public int argi6;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.079 -0400", hash_original_method = "8C350C034E1DFE6569C0A1A5C6AD0216", hash_generated_method = "07E7C206F9D459B1833CA6167C800669")
    
private SomeArgs() {
        /* do nothing - reduce visibility */
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.081 -0400", hash_original_method = "BADB0077203784BACBFFA04484F042B8", hash_generated_method = "9C04E2A0609B14719C87619DEDC7061B")
    
public void recycle() {
        if (mInPool) {
            throw new IllegalStateException("Already recycled.");
        }
        synchronized (sPoolLock) {
            clear();
            if (sPoolSize < MAX_POOL_SIZE) {
                mNext = sPool;
                mInPool = true;
                sPool = this;
                sPoolSize++;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 13:05:35.082 -0400", hash_original_method = "D0A598046773D6E18F24557CCCC0C987", hash_generated_method = "BCF962F54DD5D62D5DDD2D7982DFBF0D")
    
private void clear() {
        arg1 = null;
        arg2 = null;
        arg3 = null;
        arg4 = null;
        arg5 = null;
        argi1 = 0;
        argi2 = 0;
        argi3 = 0;
        argi4 = 0;
        argi5 = 0;
        argi6 = 0;
    }
}
