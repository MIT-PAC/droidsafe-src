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
 * Copyright (C) 2009 The Android Open Source Project
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


package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



class SynchronizedPool<T extends Poolable<T>> implements Pool<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.066 -0500", hash_original_field = "B40E8AE2AA347E5FF2444F94D00B3F93", hash_generated_field = "105D132186E8AA24291EFCF7D115902D")

    private  Pool<T> mPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.068 -0500", hash_original_field = "3526352753B6B6D766C1FB8917CD22F8", hash_generated_field = "7811049C9A4FE55905A497F504D75A1C")

    private  Object mLock;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.070 -0500", hash_original_method = "5C8F49372B1FEAE144C54A4EE1C5257C", hash_generated_method = "652EB4B1D9CAB82326D69D593B4963C0")
    
public SynchronizedPool(Pool<T> pool) {
        mPool = pool;
        mLock = this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.073 -0500", hash_original_method = "3B08DD84C1E94356AB4532B92432A6B9", hash_generated_method = "5B770E06587F9B6BB893D2AF7BC97608")
    
public SynchronizedPool(Pool<T> pool, Object lock) {
        mPool = pool;
        mLock = lock;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.075 -0500", hash_original_method = "33DD110D68F95CA8E21FED144538609A", hash_generated_method = "482F3295434F5696EC17609E50F808D4")
    
public T acquire() {
        synchronized (mLock) {
            return mPool.acquire();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.077 -0500", hash_original_method = "D3A44672BBA01F45A0EA27E869DCFDD8", hash_generated_method = "3BAFE97972290C9AEB7D1564F500EE31")
    
public void release(T element) {
        synchronized (mLock) {
            mPool.release(element);
        }
    }

    
}

