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
 * Copyright (C) 2007 The Android Open Source Project
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


package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class StatFs {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.557 -0500", hash_original_field = "A4A4998D7B0D1DA56BE7F415CF4F3BBD", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")
    
    private int mNativeContext;
    /**
     * Construct a new StatFs for looking at the stats of the
     * filesystem at <var>path</var>.  Upon construction, the stat of
     * the file system will be performed, and the values retrieved available
     * from the methods on this class.
     * 
     * @param path A path in the desired file system to state.
     */
    @DSComment("OS low level")
    @DSSpec(DSCat.OS_LOW_LEVEL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.536 -0500", hash_original_method = "B32C82E8AC66960E05928520E920B8ED", hash_generated_method = "D761477CEF9289FDAFFEFEAA5A4174EF")
    
public StatFs(String path) { native_setup(path); }
    
    /**
     * Perform a restat of the file system referenced by this object.  This
     * is the same as re-constructing the object with the same file system
     * path, and the new stat values are available upon return.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.539 -0500", hash_original_method = "8AF6434E2BA3E41CBFFC05A34FB3A23C", hash_generated_method = "9EE24CFBB8B409AF1FACC1FD06F560DA")
    
public void restat(String path) { native_restat(path); }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.541 -0500", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "B426276F6755268DFF3429CB984C1F76")
    
@Override
    protected void finalize() { native_finalize(); }

    /**
     * The size, in bytes, of a block on the file system.  This corresponds
     * to the Unix statfs.f_bsize field.
     */
    @DSComment("OS low level")
    @DSSpec(DSCat.OS_LOW_LEVEL)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.544 -0500", hash_original_method = "69F794FD342F65559C8B48F7A39B3D6D", hash_generated_method = "8E7CCFFD2FA6E7FB69A5A7BE6844BA60")
    
    public int getBlockSize(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * The total number of blocks on the file system.  This corresponds
     * to the Unix statfs.f_blocks field.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.548 -0500", hash_original_method = "AA8CC1613F4A2D3F7308C06B4F7C4105", hash_generated_method = "5AF378737BF63484FB9003BC51DDFC51")
    
    public int getBlockCount(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * The total number of blocks that are free on the file system, including
     * reserved blocks (that are not available to normal applications).  This
     * corresponds to the Unix statfs.f_bfree field.  Most applications will
     * want to use {@link #getAvailableBlocks()} instead.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.551 -0500", hash_original_method = "F279B1780F1BAD71D18F3CF49F704643", hash_generated_method = "AD228BC1F272084639AC4280257EEE22")
    
    public int getFreeBlocks(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * The number of blocks that are free on the file system and available to
     * applications.  This corresponds to the Unix statfs.f_bavail field.
     */
    @DSComment("OS low level")
    @DSSpec(DSCat.OS_LOW_LEVEL)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.555 -0500", hash_original_method = "39AF4947A221201A3EFDFD20EE46EF90", hash_generated_method = "38BE51800A896E4B2DA019C69D1F4A23")
    
    public int getAvailableBlocks(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.561 -0500", hash_original_method = "59CA121EFB9D79074525B44E468BE4BE", hash_generated_method = "4A4E9E75ACF160A700F69F0459AF485C")
    
    private void native_restat(String path){
    	//Formerly a native method
    	addTaint(path.getTaint());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.564 -0500", hash_original_method = "1E41289F3DA4BBE4A138859E5014C4A0", hash_generated_method = "DEB2CAAAAAEF6869C50299856205FB7F")
    
    private void native_setup(String path){
    	//Formerly a native method
    	addTaint(path.getTaint());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.568 -0500", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "A1A5D53F1ED4FA04B6E0F1659F8C4A39")
    
    private void native_finalize(){
    	//Formerly a native method
    }
    
}

