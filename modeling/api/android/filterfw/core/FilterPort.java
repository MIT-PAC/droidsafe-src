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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.filterfw.core;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.Filter;
import android.filterfw.core.FrameFormat;
import android.util.Log;

/**
 * @hide
 */
public abstract class FilterPort {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.049 -0400", hash_original_field = "70D3DC0698D5C81D8EA04A61D840E73D", hash_generated_field = "1F609A78CC5909B1A0CDF6FD53A2E922")

    private static final String TAG = "FilterPort";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.031 -0400", hash_original_field = "E9FBEB72F5336AFA25831B1B3CB2A4B4", hash_generated_field = "4B4D5574943584EADF61C129493DF037")

    protected Filter mFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.034 -0400", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "2C47F59AC8EFD74311E5DAB89B4171EA")

    protected String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.036 -0400", hash_original_field = "663DA942E4D073FF945F5A54122866D5", hash_generated_field = "F766266B3C146886214ED41E8117EE4D")

    protected FrameFormat mPortFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.038 -0400", hash_original_field = "ED197F0A9B3F732DAFA499EBE432AF03", hash_generated_field = "2719455879F456A382E57214038BF862")

    protected boolean mIsBlocking = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.041 -0400", hash_original_field = "AD3CE712C06D04FB7CD8D7BEC912AC9E", hash_generated_field = "F1131C33EE62F4B6D74D894DA8983F78")

    protected boolean mIsOpen = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.043 -0400", hash_original_field = "AE4DB807AF5F2EAF392BB1EE97701A6A", hash_generated_field = "2DBA173E467B57CA5E78C113FEAF4774")

    protected boolean mChecksType = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.046 -0400", hash_original_field = "CCFB9E24DC58F9E64BC75A559E0C33FC", hash_generated_field = "29542B7EA5B26DA8ADF116C9866AA3F1")

    private boolean mLogVerbose;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.051 -0400", hash_original_method = "8D76EDBC5990844810BDAA26E5719044", hash_generated_method = "88574F41789F8AC7C61128E5E6D8DA8E")
    
public FilterPort(Filter filter, String name) {
        mName = name;
        mFilter = filter;
        mLogVerbose = Log.isLoggable(TAG, Log.VERBOSE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.054 -0400", hash_original_method = "B340C45211A4AAEA6E05D951C2E9D1C5", hash_generated_method = "2299B4D8BE248A832E87B3FE9DB9AE80")
    
public boolean isAttached() {
        return mFilter != null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.056 -0400", hash_original_method = "A81A5EDAB9C4BEFAAA85A0F0E7923E79", hash_generated_method = "3E2FC54DAC8194E1C45AAC349C81A80E")
    
public FrameFormat getPortFormat() {
        return mPortFormat;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.058 -0400", hash_original_method = "74F9E8A9E3BD9B736D972A5020D1F741", hash_generated_method = "C4D28F6D095A6DCF4C45F7AB5EB4E023")
    
public void setPortFormat(FrameFormat format) {
        mPortFormat = format;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.061 -0400", hash_original_method = "A182F1708C145D57F0135D6BE7F61F0B", hash_generated_method = "F668027EA3D6A22181739B4473EB4541")
    
public Filter getFilter() {
        return mFilter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.064 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "AD920925278DEAFAFBD283F9C2E39E5D")
    
public String getName() {
        return mName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.066 -0400", hash_original_method = "D6FF0BC291FA9FEA40344A231EBFFBD9", hash_generated_method = "9F2E3586C59D231F02F3B77AB2899F88")
    
public void setBlocking(boolean blocking) {
        mIsBlocking = blocking;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.068 -0400", hash_original_method = "599224331A91507A2F4D837A02BFE9C5", hash_generated_method = "062C29B6CE348CB907B482F81CB05DBD")
    
public void setChecksType(boolean checksType) {
        mChecksType = checksType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.071 -0400", hash_original_method = "D17704E27A783512C74E32BF3439DF70", hash_generated_method = "EDEC253754A0C4756A729DD0BB13AD73")
    
public void open() {
        if (!mIsOpen) {
            if (mLogVerbose) Log.v(TAG, "Opening " + this);
        }
        mIsOpen = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.074 -0400", hash_original_method = "E4AEF593E6CE18582D148BE64D8519EE", hash_generated_method = "1931271607D12CCA1F3DBC7420B23134")
    
public void close() {
        if (mIsOpen) {
            if (mLogVerbose) Log.v(TAG, "Closing " + this);
        }
        mIsOpen = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.076 -0400", hash_original_method = "EACA78A34229887BDC52B581B68AD5AF", hash_generated_method = "B6F6B209B3A8BF3F6F8F53B3187C64CA")
    
public boolean isOpen() {
        return mIsOpen;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.078 -0400", hash_original_method = "B9BBFDC6E85F751869484DAF153209D5", hash_generated_method = "AF05FF1352C7A18A16D2DADD9B705A07")
    
public boolean isBlocking() {
        return mIsBlocking;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.081 -0400", hash_original_method = "843F2AAC19232514735AD4D797812CD2", hash_generated_method = "58DB2376BF24DE96A2D1D2297A0FD3D5")
    
public abstract boolean filterMustClose();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.083 -0400", hash_original_method = "F891457B103890ED5F284AC09BE67F96", hash_generated_method = "9813F1E1B5CA2BB0DA2EF65FD3B18B00")
    
public abstract boolean isReady();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.086 -0400", hash_original_method = "FCA9A715438A7142614F4198D00D3B87", hash_generated_method = "55D165A9FF7DEB9B2E0D3A776D5EE3F4")
    
public abstract void pushFrame(Frame frame);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.090 -0400", hash_original_method = "21251D25AC93244403A11E21AB4770C9", hash_generated_method = "A7D17BACA2BCFD81F152382169306F8B")
    
public abstract void setFrame(Frame frame);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.093 -0400", hash_original_method = "849E1E31B31DC5764342C8C6F2BC85AD", hash_generated_method = "A5B598D00378D7CB0A2A0FAD2A4131D5")
    
public abstract Frame pullFrame();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.096 -0400", hash_original_method = "6128AC01F27C83DC2F1325560A663516", hash_generated_method = "CB195B23D37CE72054EEB67F62719FA3")
    
public abstract boolean hasFrame();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.098 -0400", hash_original_method = "AE54BE580B423A6EADBE062E0BDB44C2", hash_generated_method = "FA8481600508CDECD430D025C1C79E58")
    
public abstract void clear();

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.100 -0400", hash_original_method = "9805EE473C61C639FB6CD804C5625727", hash_generated_method = "CC3F62EBA3C78446A1CA4F9E385BEA27")
    
public String toString() {
        return "port '" + mName + "' of " + mFilter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.104 -0400", hash_original_method = "024726FFE7A7EE8C43DC459BB2ECC40C", hash_generated_method = "8250F5916FD893AC5D8D62527CFA7131")
    
protected void assertPortIsOpen() {
        if (!isOpen()) {
            throw new RuntimeException("Illegal operation on closed " + this + "!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.109 -0400", hash_original_method = "DF7C154C19FA1EC510BCFCA3407348B6", hash_generated_method = "DE2916016F78EF99EC491E52650D1E03")
    
protected void checkFrameType(Frame frame, boolean forceCheck) {
        if ((mChecksType || forceCheck)
            && mPortFormat != null
            && !frame.getFormat().isCompatibleWith(mPortFormat)) {
            throw new RuntimeException("Frame passed to " + this + " is of incorrect type! "
                + "Expected " + mPortFormat + " but got " + frame.getFormat());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.111 -0400", hash_original_method = "CB1518689BFD13E9B1F3E1B1499B300D", hash_generated_method = "0105C277945A2E6507EDD042D62AF414")
    
protected void checkFrameManager(Frame frame, FilterContext context) {
        if (frame.getFrameManager() != null
            && frame.getFrameManager() != context.getFrameManager()) {
            throw new RuntimeException("Frame " + frame + " is managed by foreign FrameManager! ");
        }
    }
}

