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

/**
 * @hide
 */
public class NativeBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.855 -0400", hash_original_field = "5FB99BDF42073A88CAAFC87A4BC15127", hash_generated_field = "56EA5CFF249390813AD78EC29C49266D")

    private long mDataPointer = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.857 -0400", hash_original_field = "72231B148D10D13D4D9B7A44FF98471B", hash_generated_field = "676AD3061980F4332493AA2132B8DA3C")

    private int mSize = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.859 -0400", hash_original_field = "0659D5A855AFC79C0067D9EF29420CFF", hash_generated_field = "64E186B0E05F11DBFB5049FCBCF08F89")

    private Frame mAttachedFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.861 -0400", hash_original_field = "D124C9F22F4BEE4D8D8728E6606003EF", hash_generated_field = "6F6C1C060CD71338E60C58D9BE845630")

    private boolean mOwnsData = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.863 -0400", hash_original_field = "5E75406CC6A7CE5E4451339FE88A3205", hash_generated_field = "C766A1E7B558DC67EE2FA8C43E3C2E49")

    private int mRefCount = 1;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.865 -0400", hash_original_method = "AE79FD9D9CF58F971A0F1132297DC574", hash_generated_method = "04112FB53BE1369715ABE32EE1C62201")
    
public NativeBuffer() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.867 -0400", hash_original_method = "6606A923BEBB1571CA748F8C7BCC8EC8", hash_generated_method = "92C187AB026A05EEB271A455C3EB8532")
    
public NativeBuffer(int count) {
        allocate(count * getElementSize());
        mOwnsData = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.870 -0400", hash_original_method = "8B33DB40C9145F58C9543A0AC165E903", hash_generated_method = "45FB795D14EB354D809F19B43EE72882")
    
public NativeBuffer mutableCopy() {
        NativeBuffer result = null;
        try {
            Class myClass = getClass();
            result = (NativeBuffer)myClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Unable to allocate a copy of " + getClass() + "! Make " +
                                       "sure the class has a default constructor!");
        }
        if (mSize > 0 && !nativeCopyTo(result)) {
            throw new RuntimeException("Failed to copy NativeBuffer to mutable instance!");
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.872 -0400", hash_original_method = "9550C69BAA91C5298BA75D226127D5FF", hash_generated_method = "D1146B99C52208B28E4F9EC1242180A7")
    
public int size() {
        return mSize;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.874 -0400", hash_original_method = "4BB7DA0222A52AB4822F3928A430EEB3", hash_generated_method = "1C81B74EB9425A70D73691D0D7E83664")
    
public int count() {
        return (mDataPointer != 0) ? mSize / getElementSize() : 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.876 -0400", hash_original_method = "B32DB3F75AB14F074A72A111ABECEB7D", hash_generated_method = "FC193598D067D0FA0B44F6E2386048D9")
    
public int getElementSize() {
        return 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.878 -0400", hash_original_method = "728EE93ADB5497720F9B586E394ADC3A", hash_generated_method = "8D06BFCC2DC1E48575A8EA0AA1D8BA41")
    
public NativeBuffer retain() {
        if (mAttachedFrame != null) {
            mAttachedFrame.retain();
        } else if (mOwnsData) {
            ++mRefCount;
        }
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.880 -0400", hash_original_method = "DB0917A07A7BD77CBD5FF6A868ED74E6", hash_generated_method = "DF5A5E4597D2952E47C02D83BC9DC1E3")
    
public NativeBuffer release() {
        // Decrement refcount
        boolean doDealloc = false;
        if (mAttachedFrame != null) {
            doDealloc = (mAttachedFrame.release() == null);
        } else if (mOwnsData) {
            --mRefCount;
            doDealloc = (mRefCount == 0);
        }

        // Deallocate if necessary
        if (doDealloc) {
            deallocate(mOwnsData);
            return null;
        } else {
            return this;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.882 -0400", hash_original_method = "C0657D02FEEF315B4589808E99091058", hash_generated_method = "E7AD50CF6B38AECD95C102142396DF5F")
    
public boolean isReadOnly() {
        return (mAttachedFrame != null) ? mAttachedFrame.isReadOnly() : false;
    }

    static {
        System.loadLibrary("filterfw");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.884 -0400", hash_original_method = "DFF6F7E324BB4CF4985502E1380CD52E", hash_generated_method = "A98A8C5D62FD9378412712731405BBAD")
    
void attachToFrame(Frame frame) {
        // We do not auto-retain. We expect the user to call retain() if they want to hold on to
        // the frame.
        mAttachedFrame = frame;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.886 -0400", hash_original_method = "D6629D4318DCC9532DADE6B388D43942", hash_generated_method = "B190DCE409F5F4655735C29DCAC488C2")
    
protected void assertReadable() {
        if (mDataPointer == 0 || mSize == 0
        || (mAttachedFrame != null && !mAttachedFrame.hasNativeAllocation())) {
            throw new NullPointerException("Attempting to read from null data frame!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.888 -0400", hash_original_method = "E1217B28DD9AE91261F3AD294DCDE557", hash_generated_method = "F37DA334906B57E31EF73D2BAC5640D4")
    
protected void assertWritable() {
        if (isReadOnly()) {
            throw new RuntimeException("Attempting to modify read-only native (structured) data!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:21.532 -0400", hash_original_method = "9381021CB619018AE3A6BBE4686EF11F", hash_generated_method = "67EF60C1A89DEF3507757575EDCA41C0")
    
    private boolean allocate(int size){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += size;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:53.674 -0400", hash_original_method = "6BF09881E6E6559E458D4F4C5A2986DD", hash_generated_method = "C7EAA34BBF48174348735AE540B65FFF")
    
    private boolean deallocate(boolean ownsData){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ((ownsData) ? 1 : 0);
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:21.540 -0400", hash_original_method = "C03D70BB82D2A03447A2A16734005831", hash_generated_method = "04A6057D33096A64659E52508ED1FB9D")
    
    private boolean nativeCopyTo(NativeBuffer buffer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += buffer.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

}
