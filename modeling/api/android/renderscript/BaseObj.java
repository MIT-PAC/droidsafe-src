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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
public class BaseObj {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.592 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "B318151FF40ADE16FE6B3D1CFBCF936A")

    private int mID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.594 -0500", hash_original_field = "708F9D94DA99CD83DBB18AAAFBA8C49F", hash_generated_field = "1C64CB399BFF718CD14799195853AA6E")

    private boolean mDestroyed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.597 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.600 -0500", hash_original_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

    RenderScript mRS;
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.584 -0500", hash_original_method = "C8BB1F812AF2F94B259A1E5D31EF6D41", hash_generated_method = "C8BB1F812AF2F94B259A1E5D31EF6D41")
    
BaseObj(int id, RenderScript rs) {
        rs.validate();
        mRS = rs;
        mID = id;
        mDestroyed = false;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.586 -0500", hash_original_method = "092163F994B2BA343A828C1CA6CB67EF", hash_generated_method = "092163F994B2BA343A828C1CA6CB67EF")
    
void setID(int id) {
        if (mID != 0) {
            throw new RSRuntimeException("Internal Error, reset of object ID.");
        }
        mID = id;
    }

    /**
     * Lookup the native object ID for this object.  Primarily used by the
     * generated reflected code.
     *
     *
     * @return int
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.588 -0500", hash_original_method = "070330937CB15D09BB5E296631EB884D", hash_generated_method = "070330937CB15D09BB5E296631EB884D")
    
int getID() {
        if (mDestroyed) {
            throw new RSInvalidStateException("using a destroyed object.");
        }
        if (mID == 0) {
            throw new RSRuntimeException("Internal error: Object id 0.");
        }
        return mID;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.590 -0500", hash_original_method = "B7F1DAC6FB0A90239CE3626781D0AB2E", hash_generated_method = "B7F1DAC6FB0A90239CE3626781D0AB2E")
    
void checkValid() {
        if (mID == 0) {
            throw new RSIllegalArgumentException("Invalid object.");
        }
    }

    /**
     * setName assigns a name to an object.  This object can later be looked up
     * by this name.  This name will also be retained if the object is written
     * to an A3D file.
     *
     * @param name The name to assign to the object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.602 -0500", hash_original_method = "1123E46F9FC56B053C2DA43752023478", hash_generated_method = "D4A755E3B396C03321547607F95D63DF")
    
public void setName(String name) {
        if (name == null) {
            throw new RSIllegalArgumentException(
                "setName requires a string of non-zero length.");
        }
        if(name.length() < 1) {
            throw new RSIllegalArgumentException(
                "setName does not accept a zero length string.");
        }
        if(mName != null) {
            throw new RSIllegalArgumentException(
                "setName object already has a name.");
        }

        try {
            byte[] bytes = name.getBytes("UTF-8");
            mRS.nAssignName(mID, bytes);
            mName = name;
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return name of the renderscript object
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.605 -0500", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "AD920925278DEAFAFBD283F9C2E39E5D")
    
public String getName() {
        return mName;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.607 -0500", hash_original_method = "FF2533C9D3CAE2C033B0095CDF311C3A", hash_generated_method = "97E99162245CF60BE105276AB1EEC25D")
    
protected void finalize() throws Throwable {
        if (!mDestroyed) {
            if(mID != 0 && mRS.isAlive()) {
                mRS.nObjDestroy(mID);
            }
            mRS = null;
            mID = 0;
            mDestroyed = true;
            //Log.v(RenderScript.LOG_TAG, getClass() +
            // " auto finalizing object without having released the RS reference.");
        }
        super.finalize();
    }

    /**
     * destroy disconnects the object from the native object effectively
     * rendering this java object dead.  The primary use is to force immediate
     * cleanup of resources when it is believed the GC will not respond quickly
     * enough.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.610 -0500", hash_original_method = "48EC2BD0914D5724BE75C18442D4A6A2", hash_generated_method = "7FE30A244080FE3DFA9FBCE6A1C0F05D")
    
synchronized public void destroy() {
        if(mDestroyed) {
            throw new RSInvalidStateException("Object already destroyed.");
        }
        mDestroyed = true;
        mRS.nObjDestroy(mID);
    }

    /**
     * If an object came from an a3d file, java fields need to be
     * created with objects from the native layer
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.612 -0500", hash_original_method = "AB3B4827E233BF1789642230E2C32EC4", hash_generated_method = "AB3B4827E233BF1789642230E2C32EC4")
    
void updateFromNative() {
        mRS.validate();
        mName = mRS.nGetName(getID());
    }

    /**
     * Calculates the hash code value for a BaseObj.
     *
     * @return int
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.614 -0500", hash_original_method = "399A2DDCEE4C827B87F141BE75C58C17", hash_generated_method = "F7736150B11B3F6FB6A6BC4E4FE9CAB4")
    
@Override
    public int hashCode() {
        return mID;
    }

    /**
     * Compare the current BaseObj with another BaseObj for equality.
     *
     * @param obj The object to check equality with.
     *
     * @return boolean
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:04.617 -0500", hash_original_method = "60FC0B8BE57466D21B9D49483A61B23F", hash_generated_method = "F915E46001B4749FC6EB32B77CE142F9")
    
@Override
    public boolean equals(Object obj) {
        // Early-out check to see if both BaseObjs are actually the same
        if (this == obj)
            return true;

        if (getClass() != obj.getClass()) {
            return false;
        }

        BaseObj b = (BaseObj) obj;
        return mID == b.mID;
    }
    
}

