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

package android.drm;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * An entity class that wraps the capability of each DRM plug-in (agent),
 * such as the MIME type and file suffix the DRM plug-in can handle.
 *<p>
 * Plug-in developers can expose the capability of their plug-in by passing an instance of this
 * class to an application.
 *
 */
public class DrmSupportInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.235 -0400", hash_original_field = "1F8A084B6E44616F9E275D2EE8962475", hash_generated_field = "9833057718C688CF95BE0EB09250145E")

    private final ArrayList<String> mFileSuffixList = new ArrayList<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.259 -0400", hash_original_field = "40EC1C46BFA536B3AA9D65F379C6E290", hash_generated_field = "F1AD7877E372350BB201B816BDAC18F0")

    private final ArrayList<String> mMimeTypeList = new ArrayList<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.296 -0400", hash_original_field = "461483BD8ADD5611485CEBD36DCD0398", hash_generated_field = "17435AAA0379406E48A342E92C1534B9")

    private String mDescription = "";

    /**
     * Adds the specified MIME type to the list of MIME types this DRM plug-in supports.
     *
     * @param mimeType MIME type that can be handles by this DRM plug-in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.299 -0400", hash_original_method = "CCEBFF7F71B5744B0502DA0F73CE72D0", hash_generated_method = "218E19485147294D1EFF0EB93065B0E0")
    
public void addMimeType(String mimeType) {
        mMimeTypeList.add(mimeType);
    }

    /**
     * Adds the specified file suffix to the list of file suffixes this DRM plug-in supports.
     *
     * @param fileSuffix File suffix that can be handled by this DRM plug-in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.302 -0400", hash_original_method = "4D77A4D18E5F8068BB808BBC9D02F043", hash_generated_method = "ECB4C35609396350B0902950CCC50B79")
    
public void addFileSuffix(String fileSuffix) {
        mFileSuffixList.add(fileSuffix);
    }

    /**
     * Retrieves an iterator object that you can use to iterate over the MIME types that 
     * this DRM plug-in supports.
     *
     * @return The iterator object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.305 -0400", hash_original_method = "D618B99159BA7C3CDDA7C4CD52E323D5", hash_generated_method = "F602036747848037546B1411B158F160")
    
public Iterator<String> getMimeTypeIterator() {
        return mMimeTypeList.iterator();
    }

    /**
     * Retrieves an iterator object that you can use to iterate over the file suffixes that
     * this DRM plug-in supports.
     *
     * @return The iterator object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.308 -0400", hash_original_method = "7EC3C93A9D0D238EF6FC2BB7C507F52A", hash_generated_method = "4579710FFEA39A6E62C23D2C5050C315")
    
public Iterator<String> getFileSuffixIterator() {
        return mFileSuffixList.iterator();
    }

    /**
     * Sets a description for the DRM plug-in (agent).
     *
     * @param description Unique description of plug-in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.311 -0400", hash_original_method = "CCD9ACB14B37C153C6C416DD6B0E3FC1", hash_generated_method = "4264FD984FD51EF7385C7A31E62218B2")
    
public void setDescription(String description) {
        if (null != description) {
            mDescription = description;
        }
    }

    /**
     * Retrieves the DRM plug-in (agent) description.
     *
     * @return The plug-in description.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.314 -0400", hash_original_method = "1CD199C2D2F996A50809F8B2B7FF4F21", hash_generated_method = "44C85C5E4708E732B3F10AE28E1228D5")
    
public String getDescriprition() {
        return mDescription;
    }

    /**
     * Overridden hash code implementation.
     *
     * @return The hash code value.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.317 -0400", hash_original_method = "662784F49B60498DA0511864D5DD2D9D", hash_generated_method = "7BE4589A7C66A92924873A2671D863FA")
    
public int hashCode() {
        return mFileSuffixList.hashCode() + mMimeTypeList.hashCode() + mDescription.hashCode();
    }

    /**
     * Overridden <code>equals</code> implementation.
     *
     * @param object The object to be compared.
     * @return True if equal; false if not equal.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.321 -0400", hash_original_method = "1610CA05F41C29253E59D62C2A59995F", hash_generated_method = "7FD8BC39B742BD433F67325F94E96443")
    
public boolean equals(Object object) {
        boolean result = false;

        if (object instanceof DrmSupportInfo) {
            result = mFileSuffixList.equals(((DrmSupportInfo) object).mFileSuffixList) &&
                    mMimeTypeList.equals(((DrmSupportInfo) object).mMimeTypeList) &&
                    mDescription.equals(((DrmSupportInfo) object).mDescription);
        }
        return result;
    }

    /**
     * Determines whether a given MIME type is supported.
     *
     * @param mimeType MIME type.
     * @return True if Mime type is supported; false if MIME type is not supported.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.324 -0400", hash_original_method = "629CABADADFA0A98A76126E90A02EC8E", hash_generated_method = "629CABADADFA0A98A76126E90A02EC8E")
    
boolean isSupportedMimeType(String mimeType) {
        if (null != mimeType && !mimeType.equals("")) {
            for (int i = 0; i < mMimeTypeList.size(); i++) {
                String completeMimeType = mMimeTypeList.get(i);
                if (completeMimeType.startsWith(mimeType)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines whether a given file suffix is supported.
     *
     * @param fileSuffix File suffix.
     * @return True if file suffix is supported; false if file suffix is not supported.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.327 -0400", hash_original_method = "582FE1D280DC933CD2595A5449ACE973", hash_generated_method = "582FE1D280DC933CD2595A5449ACE973")
    
boolean isSupportedFileSuffix(String fileSuffix) {
        return mFileSuffixList.contains(fileSuffix);
    }
}

