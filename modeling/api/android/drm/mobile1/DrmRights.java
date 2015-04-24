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


package android.drm.mobile1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class DrmRights {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.939 -0500", hash_original_field = "9BDD951244E4CF6DEE203A9AC46C635C", hash_generated_field = "B09DC62ED5056D05FD7AAC60079335E1")

    public static final int DRM_PERMISSION_PLAY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.942 -0500", hash_original_field = "8BD62DBAE2A01F0434D29FD01723E27A", hash_generated_field = "BDEE5A85AE10A04DAF5DB8B90357B6CE")

    public static final int DRM_PERMISSION_DISPLAY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.945 -0500", hash_original_field = "D4CC1C756287D7E6D1AA3653BC80845F", hash_generated_field = "E9CE3DB78FAB9635A454D0B9C6A455C7")

    public static final int DRM_PERMISSION_EXECUTE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.947 -0500", hash_original_field = "0717EF434639938F5EE3F209C3A9CC57", hash_generated_field = "2BAC2E6BE4A76929371D96DA2E18632F")

    public static final int DRM_PERMISSION_PRINT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.949 -0500", hash_original_field = "FF738810C6AC45A69932287AFA098725", hash_generated_field = "25E0D3E71BAEFA88E14AB25E5D0E168C")

    private static final int JNI_DRM_SUCCESS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.952 -0500", hash_original_field = "37BEA82E28CB1C34F8EBE2B3C4DE18F8", hash_generated_field = "E53DB537690563C59F99436A7DB3F114")

    private static final int JNI_DRM_FAILURE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.954 -0500", hash_original_field = "027A6B61645605C0721BE430683C441F", hash_generated_field = "DA0C8A6494BF372551AC2E66A8F01069")

    private String roId = "";

    /**
     * Construct the DrmRights.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.957 -0500", hash_original_method = "C823F603778B510E6D7C1D7E58C253FF", hash_generated_method = "2A827C56892D4B08767A71820546A180")
    
public DrmRights() {
    }

    /**
     * Get the constraint of the given permission on this rights object.
     *
     * @param permission    the given permission.
     *
     * @return a DrmConstraint instance.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.959 -0500", hash_original_method = "152D385AF6C62DBFBF9806B7902609F0", hash_generated_method = "97530809ED3CB6B37BD2280AD1BC2044")
    
public DrmConstraintInfo getConstraint(int permission) {
        DrmConstraintInfo c = new DrmConstraintInfo();

        /* call native method to get latest constraint information */
        int res = nativeGetConstraintInfo(permission, c);

        if (JNI_DRM_FAILURE == res)
            return null;

        return c;
    }

    /**
     * Consume the rights of the given permission.
     *
     * @param permission    the given permission.
     *
     * @return true if consume success.
     *         false if consume failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.962 -0500", hash_original_method = "C0A81B9ED58B964194A74C6FBD15C07F", hash_generated_method = "513F3F75E0B8462A5939A4F0E901A89D")
    
public boolean consumeRights(int permission) {
        /* call native method to consume and update rights */
        int res = nativeConsumeRights(permission);

        if (JNI_DRM_FAILURE == res)
            return false;

        return true;
    }

    /**
     * native method: get the constraint information of the given permission.
     *
     * @param permission    the given permission.
     * @param constraint    the instance of constraint.
     *
     * @return #JNI_DRM_SUCCESS if succeed.
     *         #JNI_DRM_FAILURE if fail.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.966 -0500", hash_original_method = "38AB17DDC792736F5CB32D23FA6E92BF", hash_generated_method = "AAE1F1A6D49B0552BBB0959168052AB8")
    
    private int nativeGetConstraintInfo(int permission, DrmConstraintInfo constraint){
    	//Formerly a native method
    	addTaint(permission);
    	addTaint(constraint.getTaint());
    	return getTaintInt();
    }

    /**
     * native method: consume the rights of the given permission.
     *
     * @param permission    the given permission.
     *
     * @return #JNI_DRM_SUCCESS if succeed.
     *         #JNI_DRM_FAILURE if fail.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.969 -0500", hash_original_method = "B7050C2592D973CE5B8DCBBE60AC7282", hash_generated_method = "01ADFFC5BADEC6B80A6E2583406912CC")
    
    private int nativeConsumeRights(int permission){
    	//Formerly a native method
    	addTaint(permission);
    	return getTaintInt();
    }

    static {
        try {
            System.loadLibrary("drm1_jni");
        }
        catch (UnsatisfiedLinkError ule) {
            System.err.println("WARNING: Could not load libdrm1_jni.so");
        }
    }
    
}

