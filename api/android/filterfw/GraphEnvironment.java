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


package android.filterfw;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.filterfw.core.AsyncRunner;
import android.filterfw.core.FilterGraph;
import android.filterfw.core.FilterContext;
import android.filterfw.core.FrameManager;
import android.filterfw.core.GraphRunner;
import android.filterfw.core.RoundRobinScheduler;
import android.filterfw.core.SyncRunner;
import android.filterfw.io.GraphIOException;
import android.filterfw.io.GraphReader;
import android.filterfw.io.TextGraphReader;

import java.util.ArrayList;

/**
 * A GraphEnvironment provides a simple front-end to filter graph setup and execution using the
 * mobile filter framework. Typically, you use a GraphEnvironment in the following fashion:
 *   1. Instantiate a new GraphEnvironment instance.
 *   2. Perform any configuration, such as adding graph references and setting a GL environment.
 *   3. Load a graph file using loadGraph() or add a graph using addGraph().
 *   4. Obtain a GraphRunner instance using getRunner().
 *   5. Execute the obtained runner.
 * Note that it is possible to add multiple graphs and runners to a single GraphEnvironment.
 *
 * @hide
 */
public class GraphEnvironment extends MffEnvironment {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:56.999 -0400", hash_original_field = "46AC5AD01E31ADAE0332CD75378448C0", hash_generated_field = "CC77BD5CBB1D0C31C1B25951FA40EB4D")


    public static final int MODE_ASYNCHRONOUS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.003 -0400", hash_original_field = "63A849870A2D1DA5DB49865AFBA5218E", hash_generated_field = "DE7E005E8ADB7F8192203AE40552D7DD")

    public static final int MODE_SYNCHRONOUS  = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.007 -0400", hash_original_field = "EBBB2A7741D31DBFB0EE7BC27263EF56", hash_generated_field = "D3DA74FDA0E1BECDF32780C95D76A866")


    private GraphReader mGraphReader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.010 -0400", hash_original_field = "1CDEFECAF79D1EF4E6F7B8472AA35A0F", hash_generated_field = "8B8D23F7B9A6A779A9253E42D3020070")

    private ArrayList<GraphHandle> mGraphs = new ArrayList<GraphHandle>();

    private class GraphHandle {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.014 -0400", hash_original_field = "E3357D6D3E4D428AD86D983CD865711F", hash_generated_field = "9E32B4D3FABC553ED224E39F060C6C8D")

        private FilterGraph mGraph;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.018 -0400", hash_original_field = "C034CA5B1A881AA93A0E584BB15E2382", hash_generated_field = "789E9FEA6CC8BA88710C1BA6503D5C30")

        private AsyncRunner mAsyncRunner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.021 -0400", hash_original_field = "FBE1B48E4F35CD8D061BA22A0862F6A2", hash_generated_field = "94DA3847FDFE385B5AAF977750A404AF")

        private SyncRunner mSyncRunner;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.025 -0400", hash_original_method = "445BB9B96CE38E2EDE7C1345B4005A9B", hash_generated_method = "9F90EF2C4306DEEF56818AB5F6797FAE")
        
public GraphHandle(FilterGraph graph) {
            mGraph = graph;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.028 -0400", hash_original_method = "C7273845EE9D33E9DD5A368F4B5DE174", hash_generated_method = "AC576214E4ED3845B030796D2A62F686")
        
public FilterGraph getGraph() {
            return mGraph;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.031 -0400", hash_original_method = "56B3A9EE3B7A04106885B031E2697C8C", hash_generated_method = "32F5FB142D33B079A0BDB12EF73920EB")
        
public AsyncRunner getAsyncRunner(FilterContext environment) {
            if (mAsyncRunner == null) {
                mAsyncRunner = new AsyncRunner(environment, RoundRobinScheduler.class);
                mAsyncRunner.setGraph(mGraph);
            }
            return mAsyncRunner;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.035 -0400", hash_original_method = "8842C858DEAB07E4BD701AC9B3820A79", hash_generated_method = "D61FABF3A9FEDBF19F5D598E318B4C5A")
        
public GraphRunner getSyncRunner(FilterContext environment) {
            if (mSyncRunner == null) {
                mSyncRunner = new SyncRunner(environment, mGraph, RoundRobinScheduler.class);
            }
            return mSyncRunner;
        }
    }

    /**
     * Create a new GraphEnvironment with default components.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.040 -0400", hash_original_method = "2FE3DF2A181D04B622B627D661DD5F8F", hash_generated_method = "F19E4AF2315240F3614DF3012C7D3968")
    
public GraphEnvironment() {
        super(null);
    }

    /**
     * Create a new GraphEnvironment with a custom FrameManager and GraphReader. Specifying null
     * for either of these, will auto-create a default instance.
     *
     * @param frameManager The FrameManager to use, or null to auto-create one.
     * @param reader        The GraphReader to use for graph loading, or null to auto-create one.
     *                      Note, that the reader will not be created until it is required. Pass
     *                      null if you will not load any graph files.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.044 -0400", hash_original_method = "C7496FA4B2F55724C4380B6C65031DD0", hash_generated_method = "3CCA177989ED5BC8B5BDAEE0BD668B2A")
    
public GraphEnvironment(FrameManager frameManager, GraphReader reader) {
        super(frameManager);
        mGraphReader = reader;
    }

    /**
     * Returns the used graph reader. This will create one, if a reader has not been set already.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.048 -0400", hash_original_method = "C00FA7F79381F8F5ECD442DFEFC26369", hash_generated_method = "D2087B344D913CF55DD7C88F30B30AA5")
    
public GraphReader getGraphReader() {
        if (mGraphReader == null) {
            mGraphReader = new TextGraphReader();
        }
        return mGraphReader;
    }

    /**
     * Add graph references to resolve during graph reading. The references added here are shared
     * among all graphs.
     *
     * @param references An alternating argument list of keys (Strings) and values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.051 -0400", hash_original_method = "01B59D12A999EBD2615E20A2CF278F6C", hash_generated_method = "3256DA922867DBA5BAF04568FA77CDB8")
    
public void addReferences(Object... references) {
        getGraphReader().addReferencesByKeysAndValues(references);
    }

    /**
     * Loads a graph file from the specified resource and adds it to this environment.
     *
     * @param context       The context in which to read the resource.
     * @param resourceId    The ID of the graph resource to load.
     * @return              A unique ID for the graph.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.055 -0400", hash_original_method = "AD713D45F791E4E6A2C9A577BB6C7C99", hash_generated_method = "4B1BB15AE210DB53B570CCC23417FA6B")
    
public int loadGraph(Context context, int resourceId) {
        // Read the file into a graph
        FilterGraph graph = null;
        try {
            graph = getGraphReader().readGraphResource(context, resourceId);
        } catch (GraphIOException e) {
            throw new RuntimeException("Could not read graph: " + e.getMessage());
        }

        // Add graph to our list of graphs
        return addGraph(graph);
    }

    /**
     * Add a graph to the environment. Consider using loadGraph() if you are loading a graph from
     * a graph file.
     *
     * @param graph The graph to add to the environment.
     * @return      A unique ID for the added graph.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.058 -0400", hash_original_method = "7D17F81E638A846F421770650AC3E44B", hash_generated_method = "7C998523724D05B511B4730D6C0D04B6")
    
public int addGraph(FilterGraph graph) {
        GraphHandle graphHandle = new GraphHandle(graph);
        mGraphs.add(graphHandle);
        return mGraphs.size() - 1;
    }

    /**
     * Access a specific graph of this environment given a graph ID (previously returned from
     * loadGraph() or addGraph()). Throws an InvalidArgumentException if no graph with the
     * specified ID could be found.
     *
     * @param graphId   The ID of the graph to get.
     * @return          The graph with the specified ID.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.061 -0400", hash_original_method = "29AA09AC539FE2E2B544AA125C15577A", hash_generated_method = "42E8E3B130621E16BF7250A8EFAD858C")
    
public FilterGraph getGraph(int graphId) {
        if (graphId < 0 || graphId >= mGraphs.size()) {
            throw new IllegalArgumentException(
                "Invalid graph ID " + graphId + " specified in runGraph()!");
        }
        return mGraphs.get(graphId).getGraph();
    }

    /**
     * Get a GraphRunner instance for the graph with the specified ID. The GraphRunner instance can
     * be used to execute the graph. Throws an InvalidArgumentException if no graph with the
     * specified ID could be found.
     *
     * @param graphId       The ID of the graph to get.
     * @param executionMode The mode of graph execution. Currently this can be either
                            MODE_SYNCHRONOUS or MODE_ASYNCHRONOUS.
     * @return              A GraphRunner instance for this graph.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.065 -0400", hash_original_method = "48325F3A488B83569CA1A0F0DF8DCC63", hash_generated_method = "856A3D4260E8FBAFFAC2B11333E12BBE")
    
public GraphRunner getRunner(int graphId, int executionMode) {
        switch (executionMode) {
            case MODE_ASYNCHRONOUS:
                return mGraphs.get(graphId).getAsyncRunner(getContext());

            case MODE_SYNCHRONOUS:
                return mGraphs.get(graphId).getSyncRunner(getContext());

            default:
                throw new RuntimeException(
                    "Invalid execution mode " + executionMode + " specified in getRunner()!");
        }
    }

}
