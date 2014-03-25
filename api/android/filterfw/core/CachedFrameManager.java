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
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.SimpleFrameManager;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @hide
 */
public class CachedFrameManager extends SimpleFrameManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.931 -0400", hash_original_field = "178A8D77F1C6217F355D749D05D1E534", hash_generated_field = "94A5E005B649F10706DA53C2E1182E90")


    private SortedMap<Integer, Frame> mAvailableFrames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.933 -0400", hash_original_field = "A753A93C7B165F825D83F7A3BEFCF70B", hash_generated_field = "78D4B6CCA746325DAA30CEC80A2E3AA5")

    private int mStorageCapacity = 24 * 1024 * 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.936 -0400", hash_original_field = "8439AC1543A7140991793BABC877B5DE", hash_generated_field = "6CFD988F3CAB62BC1F805D3C7D8F114B")

    private int mStorageSize = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.939 -0400", hash_original_field = "E81845F3B02ACC0A7356CEF5638899A2", hash_generated_field = "71CC556CABEB1808DCAEC2C68024BFF4")

    private int mTimeStamp = 0;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.941 -0400", hash_original_method = "F9EC82BCEE4B4C71D07C0F23FA2360EA", hash_generated_method = "CFA6D10B95C7DD8F3D1AAD1A89BAFB7D")
    
public CachedFrameManager() {
        super();
        mAvailableFrames = new TreeMap<Integer, Frame>();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.944 -0400", hash_original_method = "2554B1FEEB4CA16DE5BF91E9978B2E01", hash_generated_method = "D1DFBB82890E81EDD814444158B16D55")
    
@Override
    public Frame newFrame(FrameFormat format) {
        Frame result = findAvailableFrame(format, Frame.NO_BINDING, 0);
        if (result == null) {
            result = super.newFrame(format);
        }
        result.setTimestamp(Frame.TIMESTAMP_NOT_SET);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.947 -0400", hash_original_method = "1ABE063C2BC76BA1B267063187AC0DC3", hash_generated_method = "F7184B04FE456C6A12938120C2A595A2")
    
@Override
    public Frame newBoundFrame(FrameFormat format, int bindingType, long bindingId) {
        Frame result = findAvailableFrame(format, bindingType, bindingId);
        if (result == null) {
            result = super.newBoundFrame(format, bindingType, bindingId);
        }
        result.setTimestamp(Frame.TIMESTAMP_NOT_SET);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.949 -0400", hash_original_method = "03128E1A1CA026DE5AAC49AD34551620", hash_generated_method = "F0695BCB957A499EC75179EF57E1FCFE")
    
@Override
    public Frame retainFrame(Frame frame) {
        return super.retainFrame(frame);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.951 -0400", hash_original_method = "D5ABAA2B819F07BEE039F60144562B4E", hash_generated_method = "CD972A83E97B23F65A58EEAEA59C5B5C")
    
@Override
    public Frame releaseFrame(Frame frame) {
        if (frame.isReusable()) {
            int refCount = frame.decRefCount();
            if (refCount == 0 && frame.hasNativeAllocation()) {
                if (!storeFrame(frame)) {
                    frame.releaseNativeAllocation();
                }
                return null;
            } else if (refCount < 0) {
                throw new RuntimeException("Frame reference count dropped below 0!");
            }
        } else {
            super.releaseFrame(frame);
        }
        return frame;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.954 -0400", hash_original_method = "DBF85748D3DCB115ACBEBD53C5637D80", hash_generated_method = "820E01C66B9B680EE37F0EB6E70933A0")
    
public void clearCache() {
        for (Frame frame : mAvailableFrames.values()) {
            frame.releaseNativeAllocation();
        }
        mAvailableFrames.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.956 -0400", hash_original_method = "E261DAB9EDB1B203230922681B772D20", hash_generated_method = "A183608D636CB67AE59FEFBD6E312B85")
    
@Override
    public void tearDown() {
        clearCache();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.958 -0400", hash_original_method = "D3B2811F3A0C041812B5A2997646E901", hash_generated_method = "3C36B08BFBA1941BEF81907DB8BE661D")
    
private boolean storeFrame(Frame frame) {
        synchronized(mAvailableFrames) {
            // Make sure this frame alone does not exceed capacity
            int frameSize = frame.getFormat().getSize();
            if (frameSize > mStorageCapacity) {
                return false;
            }

            // Drop frames if adding this frame would exceed capacity
            int newStorageSize = mStorageSize + frameSize;
            while (newStorageSize > mStorageCapacity) {
                dropOldestFrame();
                newStorageSize = mStorageSize + frameSize;
            }

            // Store new frame
            frame.onFrameStore();
            mStorageSize = newStorageSize;
            mAvailableFrames.put(mTimeStamp, frame);
            ++mTimeStamp;
            return true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.961 -0400", hash_original_method = "ACAFDD48D8FA31FDF795C11CEBCC5368", hash_generated_method = "65D233B944CA76824675483F8B7E6604")
    
private void dropOldestFrame() {
        int oldest = mAvailableFrames.firstKey();
        Frame frame = mAvailableFrames.get(oldest);
        mStorageSize -= frame.getFormat().getSize();
        frame.releaseNativeAllocation();
        mAvailableFrames.remove(oldest);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.964 -0400", hash_original_method = "CA9E75AD4031BFB03A747CAEA60EC6CC", hash_generated_method = "359845A08533E09999EFA082DDA54479")
    
private Frame findAvailableFrame(FrameFormat format, int bindingType, long bindingId) {
        // Look for a frame that is compatible with the requested format
        synchronized(mAvailableFrames) {
            for (Map.Entry<Integer, Frame> entry : mAvailableFrames.entrySet()) {
                Frame frame = entry.getValue();
                // Check that format is compatible
                if (frame.getFormat().isReplaceableBy(format)) {
                    // Check that binding is compatible (if frame is bound)
                    if ((bindingType == frame.getBindingType())
                        && (bindingType == Frame.NO_BINDING || bindingId == frame.getBindingId())) {
                        // We found one! Take it out of the set of available frames and attach the
                        // requested format to it.
                        super.retainFrame(frame);
                        mAvailableFrames.remove(entry.getKey());
                        frame.onFrameFetch();
                        frame.reset(format);
                        mStorageSize -= format.getSize();
                        return frame;
                    }
                }
            }
        }
        return null;
    }

}
