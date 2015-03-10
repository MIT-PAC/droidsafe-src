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
 *            http://www.apache.org/licenses/LICENSE-2.0
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
import android.filterfw.core.FilterContext;
import android.filterfw.core.FilterPort;
import android.filterfw.core.KeyValueMap;
import android.filterfw.io.TextGraphReader;
import android.filterfw.io.GraphIOException;
import android.filterfw.format.ObjectFormat;
import android.util.Log;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.Thread;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.LinkedList;
import java.util.Set;

/**
 * @hide
 */
public abstract class Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.442 -0400", hash_original_field = "B793AA425D6640EC3A247AB86B5FEFDC", hash_generated_field = "2B1C162E92BB8ACC4597D974A28EA1E4")

    static final int STATUS_PREINIT               = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.445 -0400", hash_original_field = "68BA8BEFD786EF0FCD3E90CE26CA6325", hash_generated_field = "F904E8F82277AC25F1D3FF9BEC9573B5")

    static final int STATUS_UNPREPARED            = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.447 -0400", hash_original_field = "58A99678E88D34696620D5DBBB0E733B", hash_generated_field = "4F33A7E18019DA980787AF55FB2491B5")

    static final int STATUS_PREPARED              = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.450 -0400", hash_original_field = "82B1261CA2E2297ABD683EF2EC173B75", hash_generated_field = "06621CD775284C62A7BE2E596A8018E5")

    static final int STATUS_PROCESSING            = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.452 -0400", hash_original_field = "290386B35DF4ACF760F51DB78CF40E35", hash_generated_field = "AB22F521B6C5DF2C395ADA6964E7CDFA")

    static final int STATUS_SLEEPING              = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.455 -0400", hash_original_field = "1EC01513FD3ED28B783CDF90B72400E3", hash_generated_field = "8ACD0E3DEE3B9CAED33AF4B4DBFDD308")

    static final int STATUS_FINISHED              = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.458 -0400", hash_original_field = "ED636F94DB023EE87C24DF6C22F9319B", hash_generated_field = "738E03E99182B8A5534DC5817383508A")

    static final int STATUS_ERROR                 = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.460 -0400", hash_original_field = "71283330BBBD80B4CF4DBA48D590330D", hash_generated_field = "163563D45973A2C08C79E83079C520F7")

    static final int STATUS_RELEASED              = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.495 -0400", hash_original_field = "8F3570127F03E38373D613741E36B40A", hash_generated_field = "F0B861A1CF72F1DBBF6E512E1A118674")

    private static final String TAG = "Filter";

    /** Tests to see if a given filter is installed on the system. Requires
     * full filter package name, including filterpack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.501 -0400", hash_original_method = "1E2F99F16E8613F9C4A8B790CD374C23", hash_generated_method = "3282655E476711F41AB3807BC0C55883")
    
public static final boolean isAvailable(String filterName) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Class filterClass;
        // First see if a class of that name exists
        try {
            filterClass = contextClassLoader.loadClass(filterName);
        } catch (ClassNotFoundException e) {
            return false;
        }
        // Then make sure it's a subclass of Filter.
        try {
            filterClass.asSubclass(Filter.class);
        } catch (ClassCastException e) {
            return false;
        }
        return true;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.463 -0400", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.465 -0400", hash_original_field = "0CF0E206DC2344000C67273C8DAA2B6F", hash_generated_field = "2D1303DECB0A3A4C737BBD714FCFC3FE")

    private int mInputCount = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.467 -0400", hash_original_field = "2941BB41DF85FA32328AD9DEC43CA710", hash_generated_field = "ACD2ECA2249CAACA4D674C7BB2610F57")

    private int mOutputCount = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.471 -0400", hash_original_field = "D3A125A0278AA1923563F10E8758F0A9", hash_generated_field = "4D31F175343D69D9A309566E164F1E8B")

    private HashMap<String, InputPort> mInputPorts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.474 -0400", hash_original_field = "B72F7AA0529524A6C78984D7035BA743", hash_generated_field = "3425E3DC68AFF52428798A7427156322")

    private HashMap<String, OutputPort> mOutputPorts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.476 -0400", hash_original_field = "DAE6424CC0A8BBCBD9E5B2D64115DA40", hash_generated_field = "961C1EF536CF73F322C0E6AEB757729D")

    private HashSet<Frame> mFramesToRelease;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.479 -0400", hash_original_field = "58DC4E1A50C12891B9E24A8A7A3D21C2", hash_generated_field = "017FC0E1703380180D3FBBDDA179A849")

    private HashMap<String, Frame> mFramesToSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.482 -0400", hash_original_field = "1326AC174664A8C69AACF1A2354DBADD", hash_generated_field = "E430F313D6FF6DBA08AAF7FD77301967")

    private int mStatus = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.484 -0400", hash_original_field = "AD3CE712C06D04FB7CD8D7BEC912AC9E", hash_generated_field = "01AE6B5BD825BF17AA38794DC308F9A1")

    private boolean mIsOpen = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.487 -0400", hash_original_field = "5A934DCEBD408FDFC91C7C3699494032", hash_generated_field = "790FCA19C65C041C76CB264D7FC59878")

    private int mSleepDelay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.489 -0400", hash_original_field = "29C29C36AD6A6BC3444DC3540D8DE006", hash_generated_field = "7CD577B0AD4FBF594FFE48D5F8BC7689")

    private long mCurrentTimestamp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.492 -0400", hash_original_field = "CCFB9E24DC58F9E64BC75A559E0C33FC", hash_generated_field = "29542B7EA5B26DA8ADF116C9866AA3F1")

    private boolean mLogVerbose;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.497 -0400", hash_original_method = "6EA9BBE4E899EE28C95138B91F974F33", hash_generated_method = "A8468B0FD229486F2982EA5C8A5B23EB")
    
public Filter(String name) {
        mName = name;
        mFramesToRelease = new HashSet<Frame>();
        mFramesToSet = new HashMap<String, Frame>();
        mStatus = STATUS_PREINIT;

        mLogVerbose = Log.isLoggable(TAG, Log.VERBOSE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.503 -0400", hash_original_method = "65CF0EDD00ED033907EB1701F32F1009", hash_generated_method = "24D97B8C976D264C659CA2A7B39AD76C")
    
public final void initWithValueMap(KeyValueMap valueMap) {
        // Initialization
        initFinalPorts(valueMap);

        // Setup remaining ports
        initRemainingPorts(valueMap);

        // This indicates that final ports can no longer be set
        mStatus = STATUS_UNPREPARED;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.506 -0400", hash_original_method = "9990DD61750FE7EE87D561B1A18F69B2", hash_generated_method = "299813098B4AA13ABDE25BE9019D9EF9")
    
public final void initWithAssignmentString(String assignments) {
        try {
            KeyValueMap valueMap = new TextGraphReader().readKeyValueAssignments(assignments);
            initWithValueMap(valueMap);
        } catch (GraphIOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.509 -0400", hash_original_method = "D6878D13F468889324DBFDEF81ED52C8", hash_generated_method = "52F750C2A7C4196A6FBE5F2468F17D34")
    
public final void initWithAssignmentList(Object... keyValues) {
        KeyValueMap valueMap = new KeyValueMap();
        valueMap.setKeyValues(keyValues);
        initWithValueMap(valueMap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.511 -0400", hash_original_method = "49B91E7EB7EF5BBB60D217146797308A", hash_generated_method = "215EBB5CF74532C5CC8512FADA6B7A4B")
    
public final void init() throws ProtocolException {
        KeyValueMap valueMap = new KeyValueMap();
        initWithValueMap(valueMap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.514 -0400", hash_original_method = "FEEB9C879D6E23E010294C8D16401FA2", hash_generated_method = "D52642FC2CC99DB54D56961C9DE53002")
    
public String getFilterClassName() {
        return getClass().getSimpleName();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.517 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "180770248625D86846C6E10AC417237F")
    
public final String getName() {
        return mName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.520 -0400", hash_original_method = "EACA78A34229887BDC52B581B68AD5AF", hash_generated_method = "B6F6B209B3A8BF3F6F8F53B3187C64CA")
    
public boolean isOpen() {
        return mIsOpen;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.522 -0400", hash_original_method = "84449F5912327A27630325013B79C380", hash_generated_method = "6FAF77FB610D2D8C15018D45F398F1ED")
    
public void setInputFrame(String inputName, Frame frame) {
        FilterPort port = getInputPort(inputName);
        if (!port.isOpen()) {
            port.open();
        }
        port.setFrame(frame);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.525 -0400", hash_original_method = "ADB417300801AD71D6FB73FEF2AE8B85", hash_generated_method = "9705A4FD92EEF7CAFCEE490AE4E942DE")
    
public final void setInputValue(String inputName, Object value) {
        setInputFrame(inputName, wrapInputValue(inputName, value));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.528 -0400", hash_original_method = "114D2D3E0CDE4FB6A58E92719C82A516", hash_generated_method = "C5AFFC1708B160E677ACEA2A09D23EB3")
    
protected void prepare(FilterContext context) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.530 -0400", hash_original_method = "E4CEC77F6BDC15D0A00D9ADA12196080", hash_generated_method = "F1F76B0098FA617BD9EDD22ECC47F1BA")
    
protected void parametersUpdated(Set<String> updated) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.532 -0400", hash_original_method = "123492381AD2641813B9E27E94BC37C4", hash_generated_method = "655FF249008176D8B844CECE009C44E1")
    
protected void delayNextProcess(int millisecs) {
        mSleepDelay = millisecs;
        mStatus = STATUS_SLEEPING;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.535 -0400", hash_original_method = "A247AB4F926F6BBBBA79C47523C7696A", hash_generated_method = "25B6014DB2BC3F3631AFF9CAC1594518")
    
public abstract void setupPorts();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.538 -0400", hash_original_method = "26A7B4ECA3B37D10EBF6EAB04DDC0AE7", hash_generated_method = "FEFDBA10359E6523EA3BC18197E4A115")
    
public FrameFormat getOutputFormat(String portName, FrameFormat inputFormat) {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.540 -0400", hash_original_method = "FB7554DB1DA6A04596C3D96AECB12A31", hash_generated_method = "0A3D953323363EAB57F54D271BBDD6A5")
    
public final FrameFormat getInputFormat(String portName) {
        InputPort inputPort = getInputPort(portName);
        return inputPort.getSourceFormat();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.542 -0400", hash_original_method = "C86E5A805512F6BD173C290E3690C685", hash_generated_method = "9B0ACED0C3BB189014C6C840F56BCCB0")
    
public void open(FilterContext context) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.545 -0400", hash_original_method = "4AD2BC290E883CC11CDE2DC99AAB3E13", hash_generated_method = "554A94CCBB223CAEDBC187344D9E3009")
    
public abstract void process(FilterContext context);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.548 -0400", hash_original_method = "43695EA1A40C13F872EAF19832904E90", hash_generated_method = "FF58373BD3EC36869E33A8750B716BE7")
    
public final int getSleepDelay() {
        return 250;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.550 -0400", hash_original_method = "D9C2B422B2E2E4DF1754ABD556301A7F", hash_generated_method = "E2E3A222C7D6AC025B55CF6155E5B3B7")
    
public void close(FilterContext context) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.552 -0400", hash_original_method = "AF12617EACE1A8EBBFD1ACA4A73CAEB3", hash_generated_method = "7BE0CF70374BFA716D28952BB5C98A95")
    
public void tearDown(FilterContext context) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.554 -0400", hash_original_method = "22D565DDB2214269F231701BF8002B2E", hash_generated_method = "C202F646425DD2A52434D3605A8DBA33")
    
public final int getNumberOfConnectedInputs() {
        int c = 0;
        for (InputPort inputPort : mInputPorts.values()) {
            if (inputPort.isConnected()) {
                ++c;
            }
        }
        return c;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.557 -0400", hash_original_method = "345DCDDBDB8C2CB878C1CC52A98A27EF", hash_generated_method = "C72EC45DE1FE4CC405A93259C835D6C8")
    
public final int getNumberOfConnectedOutputs() {
        int c = 0;
        for (OutputPort outputPort : mOutputPorts.values()) {
            if (outputPort.isConnected()) {
                ++c;
            }
        }
        return c;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.560 -0400", hash_original_method = "BC99C76BA6F54D55E77506967515A606", hash_generated_method = "8751AE4710BE7F641BE143DBD50F528B")
    
public final int getNumberOfInputs() {
        return mOutputPorts == null ? 0 : mInputPorts.size();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.562 -0400", hash_original_method = "ABF609ED4C4CABAAB11A20F095920D64", hash_generated_method = "FA9EE907CF1E998C1D63627AA1DEB2D2")
    
public final int getNumberOfOutputs() {
        return mInputPorts == null ? 0 : mOutputPorts.size();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.565 -0400", hash_original_method = "BB09858632B7758D91C15E3469DD8CA9", hash_generated_method = "5D14F017EDF3796F43EC9BE44ACD0E79")
    
public final InputPort getInputPort(String portName) {
        if (mInputPorts == null) {
            throw new NullPointerException("Attempting to access input port '" + portName
                + "' of " + this + " before Filter has been initialized!");
        }
        InputPort result = mInputPorts.get(portName);
        if (result == null) {
            throw new IllegalArgumentException("Unknown input port '" + portName + "' on filter "
                + this + "!");
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.568 -0400", hash_original_method = "519B07D27F78DC82F7B5F32861594911", hash_generated_method = "4D13E78FF24EC21CF39352770A4013C6")
    
public final OutputPort getOutputPort(String portName) {
        if (mInputPorts == null) {
            throw new NullPointerException("Attempting to access output port '" + portName
                + "' of " + this + " before Filter has been initialized!");
        }
        OutputPort result = mOutputPorts.get(portName);
        if (result == null) {
            throw new IllegalArgumentException("Unknown output port '" + portName + "' on filter "
                + this + "!");
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.572 -0400", hash_original_method = "0D1A83FA5006D2646A2483D7195D5B81", hash_generated_method = "8752A489C4832C0D8E00FCBD84D08584")
    
protected final void pushOutput(String name, Frame frame) {
        if (frame.getTimestamp() == Frame.TIMESTAMP_NOT_SET) {
            if (mLogVerbose) Log.v(TAG, "Default-setting output Frame timestamp on port " + name + " to " + mCurrentTimestamp);
            frame.setTimestamp(mCurrentTimestamp);
        }
        getOutputPort(name).pushFrame(frame);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.574 -0400", hash_original_method = "5424E048B7608A699694BF14D19BDD60", hash_generated_method = "6677A13EB71878A4EC1DCC8F0BC4E19D")
    
protected final Frame pullInput(String name) {
        Frame result = getInputPort(name).pullFrame();
        if (mCurrentTimestamp == Frame.TIMESTAMP_UNKNOWN) {
            mCurrentTimestamp = result.getTimestamp();
            if (mLogVerbose) Log.v(TAG, "Default-setting current timestamp from input port " + name + " to " + mCurrentTimestamp);
        }
        // As result is retained, we add it to the release pool here
        mFramesToRelease.add(result);

        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.576 -0400", hash_original_method = "C2A4F5873D838C93C3DD6944BC1B1AE6", hash_generated_method = "AA2F197B60007232E4691D12F4ED8FFA")
    
public void fieldPortValueUpdated(String name, FilterContext context) {
    }

    /**
     * Transfers any frame from an input port to its destination. This is useful to force a
     * transfer from a FieldPort or ProgramPort to its connected target (field or program variable).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.579 -0400", hash_original_method = "2A66B01E58A9504CE61BEBF00366E49C", hash_generated_method = "5FF3E38A8424D671C05210286CFEF933")
    
protected void transferInputPortFrame(String name, FilterContext context) {
        getInputPort(name).transfer(context);
    }

    /**
     * Assigns all program variables to the ports they are connected to. Call this after
     * constructing a Program instance with attached ProgramPorts.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.582 -0400", hash_original_method = "8C7820CFEF4A27F4AF15F9CD56FE7B6C", hash_generated_method = "4FA0891142FA53D28710D6C62DDDC4EA")
    
protected void initProgramInputs(Program program, FilterContext context) {
        if (program != null) {
            for (InputPort inputPort : mInputPorts.values()) {
                if (inputPort.getTarget() == program) {
                    inputPort.transfer(context);
                }
            }
        }
    }

    /**
     * Adds an input port to the filter. You should call this from within setupPorts, if your
     * filter has input ports. No type-checking is performed on the input. If you would like to
     * check against a type mask, use
     * {@link #addMaskedInputPort(String, FrameFormat) addMaskedInputPort} instead.
     *
     * @param name the name of the input port
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.584 -0400", hash_original_method = "EA38E0CDF683DA25F8CA5B32D80C8E46", hash_generated_method = "EB718F7067DF5CEBDED54004683B6B16")
    
protected void addInputPort(String name) {
        addMaskedInputPort(name, null);
    }

    /**
     * Adds an input port to the filter. You should call this from within setupPorts, if your
     * filter has input ports. When type-checking is performed, the input format is
     * checked against the provided format mask. An exception is thrown in case of a conflict.
     *
     * @param name the name of the input port
     * @param formatMask a format mask, which filters the allowable input types
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.587 -0400", hash_original_method = "39C8B4BCB10C7C18EF26B2601830C2CB", hash_generated_method = "8E9A5305BE947E0C2700C72200E273C9")
    
protected void addMaskedInputPort(String name, FrameFormat formatMask) {
        InputPort port = new StreamPort(this, name);
        if (mLogVerbose) Log.v(TAG, "Filter " + this + " adding " + port);
        mInputPorts.put(name, port);
        port.setPortFormat(formatMask);
    }

    /**
     * Adds an output port to the filter with a fixed output format. You should call this from
     * within setupPorts, if your filter has output ports. You cannot use this method, if your
     * output format depends on the input format (e.g. in a pass-through filter). In this case, use
     * {@link #addOutputBasedOnInput(String, String) addOutputBasedOnInput} instead.
     *
     * @param name the name of the output port
     * @param format the fixed output format of this port
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.589 -0400", hash_original_method = "3189BBCBDB36B06E0FD27E3452D6A0EB", hash_generated_method = "E3C6C54C7CF3177C971B89C271B19DBC")
    
protected void addOutputPort(String name, FrameFormat format) {
        OutputPort port = new OutputPort(this, name);
        if (mLogVerbose) Log.v(TAG, "Filter " + this + " adding " + port);
        port.setPortFormat(format);
        mOutputPorts.put(name, port);
    }

    /**
     * Adds an output port to the filter. You should call this from within setupPorts, if your
     * filter has output ports. Using this method indicates that the output format for this
     * particular port, depends on the format of an input port. You MUST also override
     * {@link #getOutputFormat(String, FrameFormat) getOutputFormat} to specify what format your
     * filter will output for a given input. If the output format of your filter port does not
     * depend on the input, use {@link #addOutputPort(String, FrameFormat) addOutputPort} instead.
     *
     * @param outputName the name of the output port
     * @param inputName the name of the input port, that this output depends on
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.592 -0400", hash_original_method = "646224463F0D7CE0B4E9012E99EEE99F", hash_generated_method = "8EC080148C8A950D44EDD3F01C5C6F40")
    
protected void addOutputBasedOnInput(String outputName, String inputName) {
        OutputPort port = new OutputPort(this, outputName);
        if (mLogVerbose) Log.v(TAG, "Filter " + this + " adding " + port);
        port.setBasePort(getInputPort(inputName));
        mOutputPorts.put(outputName, port);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.595 -0400", hash_original_method = "2B569C155A7137F041FB064176D83593", hash_generated_method = "3D24BD8C1DB54E302C766AB6C3E7011A")
    
protected void addFieldPort(String name,
                                Field field,
                                boolean hasDefault,
                                boolean isFinal) {
        // Make sure field is accessible
        field.setAccessible(true);

        // Create port for this input
        InputPort fieldPort = isFinal
            ? new FinalPort(this, name, field, hasDefault)
            : new FieldPort(this, name, field, hasDefault);

        // Create format for this input
        if (mLogVerbose) Log.v(TAG, "Filter " + this + " adding " + fieldPort);
        MutableFrameFormat format = ObjectFormat.fromClass(field.getType(),
                                                           FrameFormat.TARGET_SIMPLE);
        fieldPort.setPortFormat(format);

        // Add port
        mInputPorts.put(name, fieldPort);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.597 -0400", hash_original_method = "D877DF9AAC7EA19AF024766D77710D98", hash_generated_method = "92B87D37E91428F051F3C677695ECF0D")
    
protected void addProgramPort(String name,
                                  String varName,
                                  Field field,
                                  Class varType,
                                  boolean hasDefault) {
        // Make sure field is accessible
        field.setAccessible(true);

        // Create port for this input
        InputPort programPort = new ProgramPort(this, name, varName, field, hasDefault);

        // Create format for this input
        if (mLogVerbose) Log.v(TAG, "Filter " + this + " adding " + programPort);
        MutableFrameFormat format = ObjectFormat.fromClass(varType,
                                                           FrameFormat.TARGET_SIMPLE);
        programPort.setPortFormat(format);

        // Add port
        mInputPorts.put(name, programPort);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.599 -0400", hash_original_method = "27FC9752C4D9C4EF100D2935D98094F5", hash_generated_method = "5AA86D7D9F630D19892759D22C6B44CA")
    
protected void closeOutputPort(String name) {
        getOutputPort(name).close();
    }

    /**
     * Specifies whether the filter should not be scheduled until a frame is available on that
     * input port. Note, that setting this to false, does not block a new frame from coming in
     * (though there is no necessity to pull that frame for processing).
     * @param portName the name of the input port.
     * @param waits true, if the filter should wait for a frame on this port.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.602 -0400", hash_original_method = "4CCE9C5CFD94F9708DE518CD086EB9A4", hash_generated_method = "0474A5A738B558CD33D4A7B5CD71BE59")
    
protected void setWaitsOnInputPort(String portName, boolean waits) {
        getInputPort(portName).setBlocking(waits);
    }

    /**
     * Specifies whether the filter should not be scheduled until the output port is free, i.e.
     * there is no frame waiting on that output.
     * @param portName the name of the output port.
     * @param waits true, if the filter should wait for the port to become free.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.605 -0400", hash_original_method = "FAFB40F6CCB7CB8210B0E0CF44AD8D35", hash_generated_method = "DDA9CEEAD0AB77634A8E6CA260C4B744")
    
protected void setWaitsOnOutputPort(String portName, boolean waits) {
        getOutputPort(portName).setBlocking(waits);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.607 -0400", hash_original_method = "6321C1F6CF93F97F77398A89FAB1CDEC", hash_generated_method = "F968B9921BD006C0E254EA595BF2A1DC")
    
public String toString() {
        return "'" + getName() + "' (" + getFilterClassName() + ")";
    }

    // Core internal methods ///////////////////////////////////////////////////////////////////////
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.609 -0400", hash_original_method = "37B3B53B0B881130CCBAE1FCF388CC63", hash_generated_method = "B57FBB601B73961EACE80F389E238A46")
    
final Collection<InputPort> getInputPorts() {
        return mInputPorts.values();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.612 -0400", hash_original_method = "2FCDC0AD55E07E5E94DAB8F894D26E4D", hash_generated_method = "F8DDAFFD87954C16CD454153F0EC7AEB")
    
final Collection<OutputPort> getOutputPorts() {
        return mOutputPorts.values();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.615 -0400", hash_original_method = "53606EE136895CC7C861B05BDE5B9AD2", hash_generated_method = "8AD834F6140B39FBA083C1AFE196B9FE")
    
final synchronized int getStatus() {
        return mStatus;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.618 -0400", hash_original_method = "6A119C3F983C0C3F607A81D580B032D0", hash_generated_method = "CDA5D325EEAA041CA8993A56370A1734")
    
final synchronized void unsetStatus(int flag) {
        mStatus &= ~flag;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.620 -0400", hash_original_method = "A9017BAE053035B3ECA426498C2063E7", hash_generated_method = "BA7A571CD491CCE573CA2D725C0155E6")
    
final synchronized void performOpen(FilterContext context) {
        if (!mIsOpen) {
            if (mStatus == STATUS_UNPREPARED) {
                if (mLogVerbose) Log.v(TAG, "Preparing " + this);
                prepare(context);
                mStatus = STATUS_PREPARED;
            }
            if (mStatus == STATUS_PREPARED) {
                if (mLogVerbose) Log.v(TAG, "Opening " + this);
                open(context);
                mStatus = STATUS_PROCESSING;
            }
            if (mStatus != STATUS_PROCESSING) {
                throw new RuntimeException("Filter " + this + " was brought into invalid state during "
                    + "opening (state: " + mStatus + ")!");
            }
            mIsOpen = true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.623 -0400", hash_original_method = "E9266E13DA94F654E9E075EFD53F2B0B", hash_generated_method = "B43814430E89E58975FDFF584E21F483")
    
final synchronized void performProcess(FilterContext context) {
        if (mStatus == STATUS_RELEASED) {
            throw new RuntimeException("Filter " + this + " is already torn down!");
        }
        transferInputFrames(context);
        if (mStatus < STATUS_PROCESSING) {
            performOpen(context);
        }
        if (mLogVerbose) Log.v(TAG, "Processing " + this);
        mCurrentTimestamp = Frame.TIMESTAMP_UNKNOWN;
        process(context);
        releasePulledFrames(context);
        if (filterMustClose()) {
            performClose(context);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.626 -0400", hash_original_method = "116A96744D8C3EF1B8023FA2BE3EBFE3", hash_generated_method = "0FFC22013AE677F1E0B46532DB4965D3")
    
final synchronized void performClose(FilterContext context) {
        if (mIsOpen) {
            if (mLogVerbose) Log.v(TAG, "Closing " + this);
            mIsOpen = false;
            mStatus = STATUS_PREPARED;
            close(context);
            closePorts();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.629 -0400", hash_original_method = "1DFC3A5F91F1F97FEE9853FC660E7D50", hash_generated_method = "E4D1D8597E7E8C9085647F447CED9BE7")
    
final synchronized void performTearDown(FilterContext context) {
        performClose(context);
        if (mStatus != STATUS_RELEASED) {
            tearDown(context);
            mStatus = STATUS_RELEASED;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.631 -0400", hash_original_method = "34A4DBD4E029C04040C1F275A418831C", hash_generated_method = "B37131E9C1053E5B2DDF20B9B77053D8")
    
synchronized final boolean canProcess() {
        if (mLogVerbose) Log.v(TAG, "Checking if can process: " + this + " (" + mStatus + ").");
        if (mStatus <= STATUS_PROCESSING) {
            return inputConditionsMet() && outputConditionsMet();
        } else {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.634 -0400", hash_original_method = "BC6E9475E3EEE16CA8B91711AA536F9A", hash_generated_method = "E8136531D071E8E30A52051DE77B6DBE")
    
final void openOutputs() {
        if (mLogVerbose) Log.v(TAG, "Opening all output ports on " + this + "!");
        for (OutputPort outputPort : mOutputPorts.values()) {
            if (!outputPort.isOpen()) {
                outputPort.open();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.636 -0400", hash_original_method = "95E538F54306C3739904D07E1B572109", hash_generated_method = "6CD8A5FDF5973500FE461E0648073EB6")
    
final void clearInputs() {
        for (InputPort inputPort : mInputPorts.values()) {
            inputPort.clear();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.639 -0400", hash_original_method = "2C2E9268121392FC73432668084C0BB3", hash_generated_method = "819B04B70FEE9AF3E1318E79360A8D8E")
    
final void clearOutputs() {
        for (OutputPort outputPort : mOutputPorts.values()) {
            outputPort.clear();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.641 -0400", hash_original_method = "01684E2D0771B2F0CE1D198D5F07DE73", hash_generated_method = "B0B195862B8BC09E62119F1922944F02")
    
final void notifyFieldPortValueUpdated(String name, FilterContext context) {
        if (mStatus == STATUS_PROCESSING || mStatus == STATUS_PREPARED) {
            fieldPortValueUpdated(name, context);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.643 -0400", hash_original_method = "1DE12153B12EB30AFBA1A12417D9A8C6", hash_generated_method = "114BB84B4B7A86137C73B29E9B52DC67")
    
final synchronized void pushInputFrame(String inputName, Frame frame) {
        FilterPort port = getInputPort(inputName);
        if (!port.isOpen()) {
            port.open();
        }
        port.pushFrame(frame);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.646 -0400", hash_original_method = "598CE9C5B58E1C599B2D7224E6F9B40E", hash_generated_method = "AE2D16A775ED956BE2C4420699A561E8")
    
final synchronized void pushInputValue(String inputName, Object value) {
        pushInputFrame(inputName, wrapInputValue(inputName, value));
    }

    // Filter internal methods /////////////////////////////////////////////////////////////////////
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.650 -0400", hash_original_method = "3F4B5ECBA03497DA8C1E071C587EA8C7", hash_generated_method = "55B9B1BF341EB8494803DAE77B450FAD")
    
private final void initFinalPorts(KeyValueMap values) {
        mInputPorts = new HashMap<String, InputPort>();
        mOutputPorts = new HashMap<String, OutputPort>();
        addAndSetFinalPorts(values);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.652 -0400", hash_original_method = "20A05206D77DEA1AB05C8BBB4139DDF1", hash_generated_method = "12C00FD3B3E83AA1A9D36FE3D334752B")
    
private final void initRemainingPorts(KeyValueMap values) {
        addAnnotatedPorts();
        setupPorts();   // TODO: rename to addFilterPorts() ?
        setInitialInputValues(values);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.655 -0400", hash_original_method = "709A6B57C4BE5C7614CFE88C0B4D2BD7", hash_generated_method = "06567E5310ACEE9CFBBA7C4677C14F80")
    
private final void addAndSetFinalPorts(KeyValueMap values) {
        Class filterClass = getClass();
        Annotation annotation;
        for (Field field : filterClass.getDeclaredFields()) {
            if ((annotation = field.getAnnotation(GenerateFinalPort.class)) != null) {
                GenerateFinalPort generator = (GenerateFinalPort)annotation;
                String name = generator.name().isEmpty() ? field.getName() : generator.name();
                boolean hasDefault = generator.hasDefault();
                addFieldPort(name, field, hasDefault, true);
                if (values.containsKey(name)) {
                    setImmediateInputValue(name, values.get(name));
                    values.remove(name);
                } else if (!generator.hasDefault()) {
                    throw new RuntimeException("No value specified for final input port '"
                        + name + "' of filter " + this + "!");
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.660 -0400", hash_original_method = "99E97A6B7996BC97A689C29CDE4FDC00", hash_generated_method = "D4A45D5EB5368D538CDF646C1DBEB72D")
    
private final void addAnnotatedPorts() {
        Class filterClass = getClass();
        Annotation annotation;
        for (Field field : filterClass.getDeclaredFields()) {
            if ((annotation = field.getAnnotation(GenerateFieldPort.class)) != null) {
                GenerateFieldPort generator = (GenerateFieldPort)annotation;
                addFieldGenerator(generator, field);
            } else if ((annotation = field.getAnnotation(GenerateProgramPort.class)) != null) {
                GenerateProgramPort generator = (GenerateProgramPort)annotation;
                addProgramGenerator(generator, field);
            } else if ((annotation = field.getAnnotation(GenerateProgramPorts.class)) != null) {
                GenerateProgramPorts generators = (GenerateProgramPorts)annotation;
                for (GenerateProgramPort generator : generators.value()) {
                    addProgramGenerator(generator, field);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.664 -0400", hash_original_method = "588656C2B6E5A9CA59684727389EDA54", hash_generated_method = "6F52D7298FCE99A85BC96DF5CC5996DC")
    
private final void addFieldGenerator(GenerateFieldPort generator, Field field) {
        String name = generator.name().isEmpty() ? field.getName() : generator.name();
        boolean hasDefault = generator.hasDefault();
        addFieldPort(name, field, hasDefault, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.669 -0400", hash_original_method = "E3AE07C6D46D6C71708BBDD147FBA96B", hash_generated_method = "85E08110C836E4D715579531B0177D94")
    
private final void addProgramGenerator(GenerateProgramPort generator, Field field) {
        String name = generator.name();
        String varName = generator.variableName().isEmpty() ? name
                                                            : generator.variableName();
        Class varType = generator.type();
        boolean hasDefault = generator.hasDefault();
        addProgramPort(name, varName, field, varType, hasDefault);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.673 -0400", hash_original_method = "EF5BCE9B5C98C68AE09B9C4D10C37351", hash_generated_method = "3626853C48DD5C43FB3786F46865DFA8")
    
private final void setInitialInputValues(KeyValueMap values) {
        for (Entry<String, Object> entry : values.entrySet()) {
            setInputValue(entry.getKey(), entry.getValue());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.677 -0400", hash_original_method = "FDFE1361C15E4E070E0400050CA2FFCA", hash_generated_method = "66D8610AC553918770693E394D396274")
    
private final void setImmediateInputValue(String name, Object value) {
        if (mLogVerbose) Log.v(TAG, "Setting immediate value " + value + " for port " + name + "!");
        FilterPort port = getInputPort(name);
        port.open();
        port.setFrame(SimpleFrame.wrapObject(value, null));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.681 -0400", hash_original_method = "86A1DBB9AE10B28982FE776963CE7DAD", hash_generated_method = "A5F14FF322377026FD22E29390D501DC")
    
private final void transferInputFrames(FilterContext context) {
        for (InputPort inputPort : mInputPorts.values()) {
            inputPort.transfer(context);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.684 -0400", hash_original_method = "685833636A8E7CBAFAF45F0D4411B718", hash_generated_method = "B0384F66D12397E43D79D3CD27420E14")
    
private final Frame wrapInputValue(String inputName, Object value) {
        MutableFrameFormat inputFormat = ObjectFormat.fromObject(value, FrameFormat.TARGET_SIMPLE);
        if (value == null) {
            // If the value is null, the format cannot guess the class, so we adjust it to the
            // class of the input port here
            FrameFormat portFormat = getInputPort(inputName).getPortFormat();
            Class portClass = (portFormat == null) ? null : portFormat.getObjectClass();
            inputFormat.setObjectClass(portClass);
        }

        // Serialize if serializable, and type is not an immutable primitive.
        boolean shouldSerialize = !(value instanceof Number)
            && !(value instanceof Boolean)
            && !(value instanceof String)
            && value instanceof Serializable;

        // Create frame wrapper
        Frame frame = shouldSerialize
            ? new SerializedFrame(inputFormat, null)
            : new SimpleFrame(inputFormat, null);
        frame.setObjectValue(value);
        return frame;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.687 -0400", hash_original_method = "2EF85C5F5107E432A37937440D0D994F", hash_generated_method = "C3D059D21FB04CD61DDA827712200C0E")
    
private final void releasePulledFrames(FilterContext context) {
        for (Frame frame : mFramesToRelease) {
            context.getFrameManager().releaseFrame(frame);
        }
        mFramesToRelease.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.689 -0400", hash_original_method = "7964EBC3397852151CD8794C4C891BA9", hash_generated_method = "7CB91FB5F195AEAAF1797E219F39264A")
    
private final boolean inputConditionsMet() {
        for (FilterPort port : mInputPorts.values()) {
            if (!port.isReady()) {
                if (mLogVerbose) Log.v(TAG, "Input condition not met: " + port + "!");
                return false;
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.692 -0400", hash_original_method = "AFA6F93AB10DF46EA51E7548F922D2B7", hash_generated_method = "E0BF208A4C29E33DB47E0C1ED06F8050")
    
private final boolean outputConditionsMet() {
        for (FilterPort port : mOutputPorts.values()) {
            if (!port.isReady()) {
                if (mLogVerbose) Log.v(TAG, "Output condition not met: " + port + "!");
                return false;
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.695 -0400", hash_original_method = "C90744400188868AF66F9482BFC8B7AB", hash_generated_method = "6D7FC9D592E2A41C830A2B1CA5D98E5B")
    
private final void closePorts() {
        if (mLogVerbose) Log.v(TAG, "Closing all ports on " + this + "!");
        for (InputPort inputPort : mInputPorts.values()) {
            inputPort.close();
        }
        for (OutputPort outputPort : mOutputPorts.values()) {
            outputPort.close();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:59.698 -0400", hash_original_method = "EA6FAB992C35C4FA3BCACAAA560AF9AB", hash_generated_method = "4DD7A84990F7DC5870DD9E12E389E583")
    
private final boolean filterMustClose() {
        for (InputPort inputPort : mInputPorts.values()) {
            if (inputPort.filterMustClose()) {
                if (mLogVerbose) Log.v(TAG, "Filter " + this + " must close due to port " + inputPort);
                return true;
            }
        }
        for (OutputPort outputPort : mOutputPorts.values()) {
            if (outputPort.filterMustClose()) {
                if (mLogVerbose) Log.v(TAG, "Filter " + this + " must close due to port " + outputPort);
                return true;
            }
        }
        return false;
    }
}
