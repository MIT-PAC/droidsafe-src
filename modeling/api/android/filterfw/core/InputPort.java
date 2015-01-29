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
public abstract class InputPort extends FilterPort {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.511 -0400", hash_original_field = "8D6F67354C4B375D06C7AB960CD67CF4", hash_generated_field = "AF6D75EEF2415E70AF185F86AD4EAFA6")


    protected OutputPort mSourcePort;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.513 -0400", hash_original_method = "44150E7EB6B59FC3AA0237FF6B187DC2", hash_generated_method = "6976D523CA2A975260611AC290A04564")
    
public InputPort(Filter filter, String name) {
        super(filter, name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.515 -0400", hash_original_method = "EA97896C33A55325F7B489A92A97E8F5", hash_generated_method = "F4881AAFB67703E98019FD45AED3168B")
    
public void setSourcePort(OutputPort source) {
        if (mSourcePort != null) {
            throw new RuntimeException(this + " already connected to " + mSourcePort + "!");
        }
        mSourcePort = source;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.518 -0400", hash_original_method = "5B967006D9D64378BAF7A3593C2DE391", hash_generated_method = "30D049301A364647B799F891A2C18632")
    
public boolean isConnected() {
        return mSourcePort != null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.520 -0400", hash_original_method = "8A0B24CA22E6E3B051C2F1B0956A8B27", hash_generated_method = "71C088E43D89967055BD3413E5668495")
    
public void open() {
        super.open();
        if (mSourcePort != null && !mSourcePort.isOpen()) {
            mSourcePort.open();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.521 -0400", hash_original_method = "0A53043E28F9CF109955096CB60033E6", hash_generated_method = "B331588058A7D9D83FACDC35422BD34B")
    
public void close() {
        if (mSourcePort != null && mSourcePort.isOpen()) {
            mSourcePort.close();
        }
        super.close();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.523 -0400", hash_original_method = "A3A8131F3DC9FE551E86A06658157396", hash_generated_method = "E325B49782045A53D2BBA111A4620A7A")
    
public OutputPort getSourcePort() {
        return mSourcePort;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.525 -0400", hash_original_method = "2A21095431A2AD8B65A211092205B58A", hash_generated_method = "FB3428387A3929FA98B8EC609E4E62D3")
    
public Filter getSourceFilter() {
        return mSourcePort == null ? null : mSourcePort.getFilter();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.527 -0400", hash_original_method = "68153160F88EE0D8CD3BD44F901418F2", hash_generated_method = "B35B2231E75547496D7C0338BB711056")
    
public FrameFormat getSourceFormat() {
        return mSourcePort != null ? mSourcePort.getPortFormat() : getPortFormat();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.529 -0400", hash_original_method = "9127103B543E1176B0E194EA7221FDB9", hash_generated_method = "7688B3B72C78D1A7502EF6CEA2AE06AA")
    
public Object getTarget() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.530 -0400", hash_original_method = "3B712818E9E7333E00770C1109594109", hash_generated_method = "1E5DFCD0829DF569E8B8F22876E2D87E")
    
public boolean filterMustClose() {
        return !isOpen() && isBlocking() && !hasFrame();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.532 -0400", hash_original_method = "03ABE1CEB8F7142E23923BEF32DD184B", hash_generated_method = "6969F308F5961E9307046F730B57AF46")
    
public boolean isReady() {
        return hasFrame() || !isBlocking();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.534 -0400", hash_original_method = "1139634796ACFA5A22F1958678F39F62", hash_generated_method = "E69D19C8F3DD669376E54C3861735267")
    
public boolean acceptsFrame() {
        return !hasFrame();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.536 -0400", hash_original_method = "89BB155CEC2CA144ADA932DFBCF7A803", hash_generated_method = "5D25F951CE6339D94DF24526E5EA06F0")
    
public abstract void transfer(FilterContext context);
}
