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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

import android.filterfw.core.FilterContext;
import android.filterfw.core.KeyValueMap;
import android.filterpacks.base.FrameBranch;
import android.filterpacks.base.NullFilter;

import android.util.Log;

/**
 * @hide
 */
public class FilterGraph {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.693 -0400", hash_original_field = "7125DFA043A6D9AA078014FB9DA3F90E", hash_generated_field = "C99065676256306448CF387B87621C10")

    public static final int AUTOBRANCH_OFF      = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.695 -0400", hash_original_field = "5381B9E374FF0A9CF43D52DA7E6C5C09", hash_generated_field = "8B9D86FA2E27968BF23ABC3E9025CED5")

    public static final int AUTOBRANCH_SYNCED   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.698 -0400", hash_original_field = "F86EF08F1AE165DF5027D0EE04A409B6", hash_generated_field = "C1D722E0938F6BE3E3EFB83B5A019957")

    public static final int AUTOBRANCH_UNSYNCED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.702 -0400", hash_original_field = "6BEFC175606F418EC3E694A5B7B42748", hash_generated_field = "EB75A4F042E75E550B08D3DF63F34582")

    public static final int TYPECHECK_OFF       = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.705 -0400", hash_original_field = "7F29334267F3545B577F182AA25BBF94", hash_generated_field = "A1F757B10C8D561B0EE71F9A22083AAD")

    public static final int TYPECHECK_DYNAMIC   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.708 -0400", hash_original_field = "7D3C37E698E6688566DE503BB05ADAE5", hash_generated_field = "A966F2CEDA16C78E7E38690317D4B9C1")

    public static final int TYPECHECK_STRICT    = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.685 -0400", hash_original_field = "BF32CE7B9A3E9B8FB2F502444AA4E62F", hash_generated_field = "47FEE82991933E82A97C571610BA23C3")

    private HashSet<Filter> mFilters = new HashSet<Filter>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.688 -0400", hash_original_field = "8B0F78C6A6C04AF8CFEC48AB65BBF805", hash_generated_field = "79F7B60E2634A4906E5988D39955D8D6")

    private HashMap<String, Filter> mNameMap = new HashMap<String, Filter>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.690 -0400", hash_original_field = "712C5530033596772640ABC407111A5E", hash_generated_field = "84E8E82EE80F95ADEAF0F8BF09CE6CDA")

    private HashMap<OutputPort, LinkedList<InputPort>> mPreconnections = new
            HashMap<OutputPort, LinkedList<InputPort>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.710 -0400", hash_original_field = "17C239AFC6C8089DCC75043C54D5A297", hash_generated_field = "07E85A0ED7BE23248D219CDC62FA19F4")

    private boolean mIsReady = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.713 -0400", hash_original_field = "FD6B2102EBDC90C13F60991560FF6D37", hash_generated_field = "2F85FF93A2F1BA3D39A1191A3CC93108")

    private int mAutoBranchMode = AUTOBRANCH_OFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.715 -0400", hash_original_field = "CEFCD863AD96C71E6F0314A1D52075DD", hash_generated_field = "B324DEDB322D740F08D98D8A5AB5F397")

    private int mTypeCheckMode = TYPECHECK_STRICT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.718 -0400", hash_original_field = "E736D4745003C942E3894462576C35A8", hash_generated_field = "E844980F6E062F3D4E72C408BB95B78C")

    private boolean mDiscardUnconnectedOutputs = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.721 -0400", hash_original_field = "CCFB9E24DC58F9E64BC75A559E0C33FC", hash_generated_field = "29542B7EA5B26DA8ADF116C9866AA3F1")

    private boolean mLogVerbose;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.723 -0400", hash_original_field = "238C8CBA0BD34A77D90E2F550CDB5036", hash_generated_field = "A88ABD9F4B7A5EEF0C26E5BE6B34BC63")

    private String TAG = "FilterGraph";

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.726 -0400", hash_original_method = "8CAF45DFA731D769944D30DF0E9CB2E0", hash_generated_method = "7DCFD6339B5F831653C6C84E0B28DCAE")
    
public FilterGraph() {
        mLogVerbose = Log.isLoggable(TAG, Log.VERBOSE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.728 -0400", hash_original_method = "15B16BE9B92403C161BABE2FEDC4054B", hash_generated_method = "3E434A5BFF2FCC5CE536FDACDFE76314")
    
public boolean addFilter(Filter filter) {
        if (!containsFilter(filter)) {
            mFilters.add(filter);
            mNameMap.put(filter.getName(), filter);
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.731 -0400", hash_original_method = "2DC748D7C0647C38CF6A5CDBB79CE4E3", hash_generated_method = "8AEA4EAF2148C5AFE378C2D7A976DB02")
    
public boolean containsFilter(Filter filter) {
        return mFilters.contains(filter);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.733 -0400", hash_original_method = "D8478E474B3FDB81CE745F77E664F102", hash_generated_method = "01E499CF69D31C21DF21AE8993EC6F35")
    
public Filter getFilter(String name) {
        return mNameMap.get(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.736 -0400", hash_original_method = "1328055B34DD146FA80EB940A90EACFC", hash_generated_method = "78E68779F6C7B16EAF2EB67BE20F7631")
    
public void connect(Filter source,
                        String outputName,
                        Filter target,
                        String inputName) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Passing null Filter in connect()!");
        } else if (!containsFilter(source) || !containsFilter(target)) {
            throw new RuntimeException("Attempting to connect filter not in graph!");
        }

        OutputPort outPort = source.getOutputPort(outputName);
        InputPort inPort = target.getInputPort(inputName);
        if (outPort == null) {
            throw new RuntimeException("Unknown output port '" + outputName + "' on Filter " +
                                       source + "!");
        } else if (inPort == null) {
            throw new RuntimeException("Unknown input port '" + inputName + "' on Filter " +
                                       target + "!");
        }

        preconnect(outPort, inPort);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.739 -0400", hash_original_method = "2063895EC49692B3F4F9D469AB179024", hash_generated_method = "816E47BA09A52AD0C6F086C69B10B52D")
    
public void connect(String sourceName,
                        String outputName,
                        String targetName,
                        String inputName) {
        Filter source = getFilter(sourceName);
        Filter target = getFilter(targetName);
        if (source == null) {
            throw new RuntimeException(
                "Attempting to connect unknown source filter '" + sourceName + "'!");
        } else if (target == null) {
            throw new RuntimeException(
                "Attempting to connect unknown target filter '" + targetName + "'!");
        }
        connect(source, outputName, target, inputName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.741 -0400", hash_original_method = "F17404542BE5A053E16BC35DDBD40E0A", hash_generated_method = "ECD260E1368B52ED6D5E7AC0CCF5080C")
    
public Set<Filter> getFilters() {
        return mFilters;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.743 -0400", hash_original_method = "6D26987CE7359A0385F2819E5CA11CD0", hash_generated_method = "CFFB3331EB874FB8AFC93C42D4D9D4B2")
    
public void beginProcessing() {
        if (mLogVerbose) Log.v(TAG, "Opening all filter connections...");
        for (Filter filter : mFilters) {
            filter.openOutputs();
        }
        mIsReady = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.746 -0400", hash_original_method = "B97DFB68DDAE38B7FBB010FB2CDDD96D", hash_generated_method = "ADDB4252A41144228C2DE401A6519457")
    
public void flushFrames() {
        for (Filter filter : mFilters) {
            filter.clearOutputs();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.749 -0400", hash_original_method = "484E988B1E9C4CDCE88CC980C1D3EA72", hash_generated_method = "D3429CC6CCA5DEF9B2DB9C57F3FEC816")
    
public void closeFilters(FilterContext context) {
        if (mLogVerbose) Log.v(TAG, "Closing all filters...");
        for (Filter filter : mFilters) {
            filter.performClose(context);
        }
        mIsReady = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.751 -0400", hash_original_method = "2C25B4EC8430A5EC40AFE469D2C507CF", hash_generated_method = "EC0780106EBD7D6BBB9980A9D1152943")
    
public boolean isReady() {
        return mIsReady;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.754 -0400", hash_original_method = "1F363677E4A7524D180BC07B8D3CCAA9", hash_generated_method = "DE9CD9E2C10BE0ECE52CEDDAF1EBAF5C")
    
public void setAutoBranchMode(int autoBranchMode) {
        mAutoBranchMode = autoBranchMode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.756 -0400", hash_original_method = "E0EC0ECC34D2BEE50909A04DCE75DDC2", hash_generated_method = "7995BDBE5ECC8559745B570FA5859DD0")
    
public void setDiscardUnconnectedOutputs(boolean discard) {
        mDiscardUnconnectedOutputs = discard;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.758 -0400", hash_original_method = "6A9239DDC4575845D1AFDC494FAB9657", hash_generated_method = "F0CDB96FE6E04686B6040E4D9BB418DC")
    
public void setTypeCheckMode(int typeCheckMode) {
        mTypeCheckMode = typeCheckMode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.761 -0400", hash_original_method = "80E436AC6E267017DFE118774D5640C0", hash_generated_method = "F24429864F7A9077BE8177B00ACEB57A")
    
public void tearDown(FilterContext context) {
        if (!mFilters.isEmpty()) {
            flushFrames();
            for (Filter filter : mFilters) {
                filter.performTearDown(context);
            }
            mFilters.clear();
            mNameMap.clear();
            mIsReady = false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.763 -0400", hash_original_method = "CBE00DFA065DA0405CDB82F19D6D798C", hash_generated_method = "DA721581E90E3F85E2F040F3ED0AA8EC")
    
private boolean readyForProcessing(Filter filter, Set<Filter> processed) {
        // Check if this has been already processed
        if (processed.contains(filter)) {
            return false;
        }

        // Check if all dependencies have been processed
        for (InputPort port : filter.getInputPorts()) {
            Filter dependency = port.getSourceFilter();
            if (dependency != null && !processed.contains(dependency)) {
                return false;
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.767 -0400", hash_original_method = "E72268DE3654C33A4E3BA5E620594D69", hash_generated_method = "05C8F08802EF94E39692891B8E5F1843")
    
private void runTypeCheck() {
        Stack<Filter> filterStack = new Stack<Filter>();
        Set<Filter> processedFilters = new HashSet<Filter>();
        filterStack.addAll(getSourceFilters());

        while (!filterStack.empty()) {
            // Get current filter and mark as processed
            Filter filter = filterStack.pop();
            processedFilters.add(filter);

            // Anchor output formats
            updateOutputs(filter);

            // Perform type check
            if (mLogVerbose) Log.v(TAG, "Running type check on " + filter + "...");
            runTypeCheckOn(filter);

            // Push connected filters onto stack
            for (OutputPort port : filter.getOutputPorts()) {
                Filter target = port.getTargetFilter();
                if (target != null && readyForProcessing(target, processedFilters)) {
                    filterStack.push(target);
                }
            }
        }

        // Make sure all ports were setup
        if (processedFilters.size() != getFilters().size()) {
            throw new RuntimeException("Could not schedule all filters! Is your graph malformed?");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.771 -0400", hash_original_method = "7884211B16D2011FF189E1C77E299912", hash_generated_method = "0CDAC9AF69B47FEBC9760225A86B19A2")
    
private void updateOutputs(Filter filter) {
        for (OutputPort outputPort : filter.getOutputPorts()) {
            InputPort inputPort = outputPort.getBasePort();
            if (inputPort != null) {
                FrameFormat inputFormat = inputPort.getSourceFormat();
                FrameFormat outputFormat = filter.getOutputFormat(outputPort.getName(),
                                                                  inputFormat);
                if (outputFormat == null) {
                    throw new RuntimeException("Filter did not return an output format for "
                        + outputPort + "!");
                }
                outputPort.setPortFormat(outputFormat);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.775 -0400", hash_original_method = "AC74C0E285D9BCBC73B35492AD67505B", hash_generated_method = "1EC4A0E73D730A2A78B19B601D45087B")
    
private void runTypeCheckOn(Filter filter) {
        for (InputPort inputPort : filter.getInputPorts()) {
            if (mLogVerbose) Log.v(TAG, "Type checking port " + inputPort);
            FrameFormat sourceFormat = inputPort.getSourceFormat();
            FrameFormat targetFormat = inputPort.getPortFormat();
            if (sourceFormat != null && targetFormat != null) {
                if (mLogVerbose) Log.v(TAG, "Checking " + sourceFormat + " against " + targetFormat + ".");

                boolean compatible = true;
                switch (mTypeCheckMode) {
                    case TYPECHECK_OFF:
                        inputPort.setChecksType(false);
                        break;
                    case TYPECHECK_DYNAMIC:
                        compatible = sourceFormat.mayBeCompatibleWith(targetFormat);
                        inputPort.setChecksType(true);
                        break;
                    case TYPECHECK_STRICT:
                        compatible = sourceFormat.isCompatibleWith(targetFormat);
                        inputPort.setChecksType(false);
                        break;
                }

                if (!compatible) {
                    throw new RuntimeException("Type mismatch: Filter " + filter + " expects a "
                        + "format of type " + targetFormat + " but got a format of type "
                        + sourceFormat + "!");
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.778 -0400", hash_original_method = "1A0E95B5CD7FB686AEAABC2754DE4E30", hash_generated_method = "5BB25987A6C5E9245FDCDA3C4D3FF3CF")
    
private void checkConnections() {
        // TODO
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.780 -0400", hash_original_method = "38737D222892AC326080A9A2C6CF30A0", hash_generated_method = "BA530D733C58DA53D0C30D722DEBA3DE")
    
private void discardUnconnectedOutputs() {
        // Connect unconnected ports to Null filters
        LinkedList<Filter> addedFilters = new LinkedList<Filter>();
        for (Filter filter : mFilters) {
            int id = 0;
            for (OutputPort port : filter.getOutputPorts()) {
                if (!port.isConnected()) {
                    if (mLogVerbose) Log.v(TAG, "Autoconnecting unconnected " + port + " to Null filter.");
                    NullFilter nullFilter = new NullFilter(filter.getName() + "ToNull" + id);
                    nullFilter.init();
                    addedFilters.add(nullFilter);
                    port.connectTo(nullFilter.getInputPort("frame"));
                    ++id;
                }
            }
        }
        // Add all added filters to this graph
        for (Filter filter : addedFilters) {
            addFilter(filter);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.783 -0400", hash_original_method = "C0B3C1382A8D959C6D1172B649EFA273", hash_generated_method = "E86CD977B68364B388BCC91B228D0775")
    
private void removeFilter(Filter filter) {
        mFilters.remove(filter);
        mNameMap.remove(filter.getName());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.786 -0400", hash_original_method = "D470447DA99F4AF97F9D7A6240206252", hash_generated_method = "DDF6B0FC256BB5BF1B9E91A76D8DB20D")
    
private void preconnect(OutputPort outPort, InputPort inPort) {
        LinkedList<InputPort> targets;
        targets = mPreconnections.get(outPort);
        if (targets == null) {
            targets = new LinkedList<InputPort>();
            mPreconnections.put(outPort, targets);
        }
        targets.add(inPort);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.800 -0400", hash_original_method = "0FCE776236EB342BC627907CEFE64320", hash_generated_method = "8775CCF47AED44B0A123E2F816848908")
    
private void connectPorts() {
        int branchId = 1;
        for (Entry<OutputPort, LinkedList<InputPort>> connection : mPreconnections.entrySet()) {
            OutputPort outputPort = connection.getKey();
            LinkedList<InputPort> inputPorts = connection.getValue();
            if (inputPorts.size() == 1) {
                outputPort.connectTo(inputPorts.get(0));
            } else if (mAutoBranchMode == AUTOBRANCH_OFF) {
                throw new RuntimeException("Attempting to connect " + outputPort + " to multiple "
                                         + "filter ports! Enable auto-branching to allow this.");
            } else {
                if (mLogVerbose) Log.v(TAG, "Creating branch for " + outputPort + "!");
                FrameBranch branch = null;
                if (mAutoBranchMode == AUTOBRANCH_SYNCED) {
                    branch = new FrameBranch("branch" + branchId++);
                } else {
                    throw new RuntimeException("TODO: Unsynced branches not implemented yet!");
                }
                KeyValueMap branchParams = new KeyValueMap();
                branch.initWithAssignmentList("outputs", inputPorts.size());
                addFilter(branch);
                outputPort.connectTo(branch.getInputPort("in"));
                Iterator<InputPort> inputPortIter = inputPorts.iterator();
                for (OutputPort branchOutPort : ((Filter)branch).getOutputPorts()) {
                    branchOutPort.connectTo(inputPortIter.next());
                }
            }
        }
        mPreconnections.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.803 -0400", hash_original_method = "88BE8A37EE36FCDEAF14F4FF580366B9", hash_generated_method = "DBBE17E5AB0DAC38B34E7FD4D8A668A5")
    
private HashSet<Filter> getSourceFilters() {
        HashSet<Filter> sourceFilters = new HashSet<Filter>();
        for (Filter filter : getFilters()) {
            if (filter.getNumberOfConnectedInputs() == 0) {
                if (mLogVerbose) Log.v(TAG, "Found source filter: " + filter);
                sourceFilters.add(filter);
            }
        }
        return sourceFilters;
    }

    // Core internal methods /////////////////////////////////////////////////////////////////////////
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.805 -0400", hash_original_method = "2DE05C7196B1F3DA40F9C58F53A04D67", hash_generated_method = "2DE05C7196B1F3DA40F9C58F53A04D67")
    
void setupFilters() {
        if (mDiscardUnconnectedOutputs) {
            discardUnconnectedOutputs();
        }
        connectPorts();
        checkConnections();
        runTypeCheck();
    }
}
