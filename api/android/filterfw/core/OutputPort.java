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

/**
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class OutputPort extends FilterPort {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.635 -0400", hash_original_field = "218E55311FF0F9CAEDD353C3BFE7B1DA", hash_generated_field = "8907B6C7C556D003B5DF8286B1313D9C")


    protected InputPort mTargetPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.637 -0400", hash_original_field = "A6CD94207945425346D61980AAA7E3A1", hash_generated_field = "E1D864354ADD571B3B02D27F99ADDFAD")

    protected InputPort mBasePort;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.639 -0400", hash_original_method = "5E04272E427951FD5FEF799DA87D3E90", hash_generated_method = "DA70D3D299BE7B04C1484EEF466D0C3A")
    
public OutputPort(Filter filter, String name) {
        super(filter, name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.640 -0400", hash_original_method = "D53B7F4B4BA9A2262183A029599F3C9E", hash_generated_method = "8CEA91626C93492D55C3126B8CB14195")
    
public void connectTo(InputPort target) {
        if (mTargetPort != null) {
            throw new RuntimeException(this + " already connected to " + mTargetPort + "!");
        }
        mTargetPort = target;
        mTargetPort.setSourcePort(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.642 -0400", hash_original_method = "1881CF95667C0C4358990024A513D4B5", hash_generated_method = "29ED0D81F00CA02DA92540CB7F8EAD63")
    
public boolean isConnected() {
        return mTargetPort != null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.645 -0400", hash_original_method = "0E24EBC7C6CE0A13EF29C5008B014871", hash_generated_method = "B308EC7B8A523792FC2577BEFD855F62")
    
public void open() {
        super.open();
        if (mTargetPort != null && !mTargetPort.isOpen()) {
            mTargetPort.open();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.647 -0400", hash_original_method = "54D035E1A381BFEEE4327E1E978FBAF1", hash_generated_method = "9265CF56294B6D505E0F4556FE22D963")
    
public void close() {
        super.close();
        if (mTargetPort != null && mTargetPort.isOpen()) {
            mTargetPort.close();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.649 -0400", hash_original_method = "F7486EE1EB2C31B0D814C47E7E09A381", hash_generated_method = "ECC70F20002F707D34485A6A0ABEF708")
    
public InputPort getTargetPort() {
        return mTargetPort;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.651 -0400", hash_original_method = "63D0E30DD7F2349B56DA5CC1113BF73D", hash_generated_method = "2B596C3ADB8C128BB3D9D790D7C1D8BE")
    
public Filter getTargetFilter() {
        return mTargetPort == null ? null : mTargetPort.getFilter();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.653 -0400", hash_original_method = "1E4F67C66864C9BC75BF5DF08698E69C", hash_generated_method = "EB861BFFA394C5D282CEA95321F81EA2")
    
public void setBasePort(InputPort basePort) {
        mBasePort = basePort;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.654 -0400", hash_original_method = "E50DA01A9EB2246F48B73FE1EF38AC42", hash_generated_method = "E4F6533A7684C923CDE0DDDE213853F5")
    
public InputPort getBasePort() {
        return mBasePort;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.656 -0400", hash_original_method = "3B1D830FD4387B4AED751A00D6FCBF86", hash_generated_method = "B0765339808F679AB949D30203018E0D")
    
public boolean filterMustClose() {
        return !isOpen() && isBlocking();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.658 -0400", hash_original_method = "6136EFF727C8354810C96AFC68216970", hash_generated_method = "84C40AC79B8B060214EE66AF7C84B15C")
    
public boolean isReady() {
        return (isOpen() && mTargetPort.acceptsFrame()) || !isBlocking();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.660 -0400", hash_original_method = "455F451B78E2BFEB8F46C0C64DA5687B", hash_generated_method = "BBC4D8916A0A18A7B1E96AFBD340E94E")
    
@Override
    public void clear() {
        if (mTargetPort != null) {
            mTargetPort.clear();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.662 -0400", hash_original_method = "69902CF7B6E8D960E1FE07FDE2E93432", hash_generated_method = "0C6A68E2982EDD81918E48E8BD567EC1")
    
@Override
    public void pushFrame(Frame frame) {
        if (mTargetPort == null) {
            throw new RuntimeException(
                "Attempting to push frame on unconnected port: " + this + "!");
        }
        mTargetPort.pushFrame(frame);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.664 -0400", hash_original_method = "B9D6BF0CE31A5667AF622067BAC50B6A", hash_generated_method = "9D433B1A8047BA3CE45483813DBEE236")
    
@Override
    public void setFrame(Frame frame) {
        assertPortIsOpen();
        if (mTargetPort == null) {
            throw new RuntimeException(
                "Attempting to set frame on unconnected port: " + this + "!");
        }
        mTargetPort.setFrame(frame);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.666 -0400", hash_original_method = "90C46603BC756C952F501C76E45FA81A", hash_generated_method = "7F8FEFDE9E73922C139810B15BB3BBB4")
    
@Override
    public Frame pullFrame() {
        throw new RuntimeException("Cannot pull frame on " + this + "!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.667 -0400", hash_original_method = "77D11C4AA833C3CB32441746B85C0DB1", hash_generated_method = "0B1AD286CAC6A437B9A68998DA159107")
    
@Override
    public boolean hasFrame() {
        return mTargetPort == null ? false : mTargetPort.hasFrame();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.670 -0400", hash_original_method = "F0D3E5C1E43C21C75E49F5732E07F55F", hash_generated_method = "57BE17C53E847A1B22F9741E2E135D3E")
    
@Override
    public String toString() {
        return "output " + super.toString();
    }
}
