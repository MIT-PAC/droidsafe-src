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


package android.filterfw.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;

import java.util.ArrayList;
import java.util.regex.Pattern;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterFactory;
import android.filterfw.core.FilterGraph;
import android.filterfw.core.KeyValueMap;
import android.filterfw.core.ProtocolException;
import android.filterfw.io.GraphReader;
import android.filterfw.io.GraphIOException;
import android.filterfw.io.PatternScanner;

/**
 * @hide
 */
public class TextGraphReader extends GraphReader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.576 -0400", hash_original_field = "A3AF9BB1A0B89C4E230A4D5D79808A19", hash_generated_field = "51E513ECB45242AFCD3429859A732B21")


    private ArrayList<Command> mCommands = new ArrayList<Command>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.578 -0400", hash_original_field = "CEBE7D0C356363A73E8BD0FAD4BFBE7E", hash_generated_field = "B270F99E78F54280D64D695F48FD62A7")

    private Filter mCurrentFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.580 -0400", hash_original_field = "FC5E2E7559453E7BC4FBB51A715459DB", hash_generated_field = "FF7650709267441059B87DBCAE6105BD")

    private FilterGraph mCurrentGraph;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.582 -0400", hash_original_field = "8FC04267B8503AD8DC789B6D21092D53", hash_generated_field = "5CCD51D21E3F888221F1456D31395DCF")

    private KeyValueMap mBoundReferences;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.584 -0400", hash_original_field = "DEE0DED35CBC1D2FEAF1646B3B8371AE", hash_generated_field = "0B22659094181A2054D4BC7FCFFABE52")

    private KeyValueMap mSettings;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.585 -0400", hash_original_field = "BDA62D2E0A849CFA0BF580B9A3B1B8BC", hash_generated_field = "8A3B0BD6C2E3650756516BB94A3604B2")

    private FilterFactory mFactory;

    private interface Command {
        public void execute(TextGraphReader reader) throws GraphIOException;
    }

    private class ImportPackageCommand implements Command {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.590 -0400", hash_original_field = "7A5990DF4A54BF373C395B6501E20B02", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

        private String mPackageName;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.592 -0400", hash_original_method = "639CC540431F71E91CD6FE207B3F94BC", hash_generated_method = "24BCDA46253104CC744E85A63858A2CF")
        
public ImportPackageCommand(String packageName) {
            mPackageName = packageName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.594 -0400", hash_original_method = "F0B011BBF60A5438CEF8D8B365492E71", hash_generated_method = "DC61F1339751337263ED526FCE9E226C")
        
@Override
        public void execute(TextGraphReader reader) throws GraphIOException {
            try {
                reader.mFactory.addPackage(mPackageName);
            } catch (IllegalArgumentException e) {
                throw new GraphIOException(e.getMessage());
            }
        }
    }

    private class AddLibraryCommand implements Command {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.598 -0400", hash_original_field = "521542007AC3C697654D0E064C2E4FFE", hash_generated_field = "0FF2155315806EEB8AA08EFB829D69CE")

        private String mLibraryName;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.599 -0400", hash_original_method = "37FD30913FFCEE3A7BD6B8A8FE03F6D8", hash_generated_method = "B62A58B593008FE130417CD83D2CB2A5")
        
public AddLibraryCommand(String libraryName) {
            mLibraryName = libraryName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.601 -0400", hash_original_method = "ABC4822494B0DD186E37E38FD3CC04B5", hash_generated_method = "9D477B807EC3BB771D6BB2EA4A44E790")
        
@Override
        public void execute(TextGraphReader reader) {
            reader.mFactory.addFilterLibrary(mLibraryName);
        }
    }

    private class AllocateFilterCommand implements Command {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.604 -0400", hash_original_field = "6BC238A3BDD37BF1CAC26EA2CE45C508", hash_generated_field = "DB6E5647C7C137158D39EAA9BCFFCF3D")

        private String mClassName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.606 -0400", hash_original_field = "D754CE06F2B86A64EB9CE2C2D7720628", hash_generated_field = "1C5AEE954C4F44560B5374B5255B7E34")

        private String mFilterName;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.607 -0400", hash_original_method = "D24F49FE1EBFAF9FAA9F23C97CEE4880", hash_generated_method = "A637271EB4E7FD8D7D1494DF35C0E78C")
        
public AllocateFilterCommand(String className, String filterName) {
            mClassName = className;
            mFilterName = filterName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.609 -0400", hash_original_method = "9FD295758CF515F301CDCA6751DBF784", hash_generated_method = "017E839C0E758754CE79BF76E94549D0")
        
public void execute(TextGraphReader reader) throws GraphIOException {
            // Create the filter
            Filter filter = null;
            try {
                filter = reader.mFactory.createFilterByClassName(mClassName, mFilterName);
            } catch (IllegalArgumentException e) {
                throw new GraphIOException(e.getMessage());
            }

            // Set it as the current filter
            reader.mCurrentFilter = filter;
        }
    }

    private class InitFilterCommand implements Command {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.612 -0400", hash_original_field = "01EC719EE1B187040C9E4F6AEFCE033A", hash_generated_field = "B7C1EB06D64B098907D44A28F2DB19CC")

        private KeyValueMap mParams;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.616 -0400", hash_original_method = "CC8C376A3D84061B0AAED40BD44171CA", hash_generated_method = "120E8D29BDBD02DA32F4F6473A54D26C")
        
public InitFilterCommand(KeyValueMap params) {
            mParams = params;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.618 -0400", hash_original_method = "163CD1E945045173F9173ACF9596A745", hash_generated_method = "E6FE0FE0A755A5E97C2753E0B347CF5A")
        
@Override
        public void execute(TextGraphReader reader) throws GraphIOException {
            Filter filter = reader.mCurrentFilter;
            try {
                filter.initWithValueMap(mParams);
            } catch (ProtocolException e) {
                throw new GraphIOException(e.getMessage());
            }
            reader.mCurrentGraph.addFilter(mCurrentFilter);
        }
    }

    private class ConnectCommand implements Command {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.621 -0400", hash_original_field = "49BDFC1C3154D8D90DAE1F3E33C293FD", hash_generated_field = "EAA53C26DFC2E1CB8BC29145AE6FBD5F")

        private String mSourceFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.623 -0400", hash_original_field = "EAB142ACB448979946981DEDFC73F4CB", hash_generated_field = "A8AEB57826EBDFBC33FD06D761692AA6")

        private String mSourcePort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.625 -0400", hash_original_field = "14CB6A0B73E13C6747AB70C63A6A91BF", hash_generated_field = "AA5B2AA3586C57BE090D3831D393792C")

        private String mTargetFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.627 -0400", hash_original_field = "8A776565B48C2581883A2B99E70266B5", hash_generated_field = "554F0E3D24F103F0A1432881227FF2FE")

        private String mTargetName;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.629 -0400", hash_original_method = "2D45ABC035785BCE431A013D707C671B", hash_generated_method = "88F544AE8CE6A766D2A674B47F6CF8B6")
        
public ConnectCommand(String sourceFilter,
                              String sourcePort,
                              String targetFilter,
                              String targetName) {
            mSourceFilter = sourceFilter;
            mSourcePort = sourcePort;
            mTargetFilter = targetFilter;
            mTargetName = targetName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.630 -0400", hash_original_method = "2C279389EF3DE95B248A87C2AFAFFF03", hash_generated_method = "7D4DC9DD29B43B98D326475582E25664")
        
@Override
        public void execute(TextGraphReader reader) {
            reader.mCurrentGraph.connect(mSourceFilter, mSourcePort, mTargetFilter, mTargetName);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.633 -0400", hash_original_method = "0F5B13ECE0DB893F2F61B0A2EA0FAF1F", hash_generated_method = "281CB201BD86E0A8DE19E94759848043")
    
@Override
    public FilterGraph readGraphString(String graphString) throws GraphIOException {
        FilterGraph result = new FilterGraph();

        reset();
        mCurrentGraph = result;
        parseString(graphString);
        applySettings();
        executeCommands();
        reset();

        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.635 -0400", hash_original_method = "D25E61E5E8289D1984AD494413011630", hash_generated_method = "F207ADAE0D7523484D243EB1877D2409")
    
private void reset() {
        mCurrentGraph = null;
        mCurrentFilter = null;
        mCommands.clear();
        mBoundReferences = new KeyValueMap();
        mSettings = new KeyValueMap();
        mFactory = new FilterFactory();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.640 -0400", hash_original_method = "28CE2CBCFA4A071C2261DDC6687F7C5D", hash_generated_method = "3438722CC8F4312EEF7E74E4E4FDEA35")
    
private void parseString(String graphString) throws GraphIOException {
        final Pattern commandPattern = Pattern.compile("@[a-zA-Z]+");
        final Pattern curlyClosePattern = Pattern.compile("\\}");
        final Pattern curlyOpenPattern = Pattern.compile("\\{");
        final Pattern ignorePattern = Pattern.compile("(\\s+|//[^\\n]*\\n)+");
        final Pattern packageNamePattern = Pattern.compile("[a-zA-Z\\.]+");
        final Pattern libraryNamePattern = Pattern.compile("[a-zA-Z\\./:]+");
        final Pattern portPattern = Pattern.compile("\\[[a-zA-Z0-9\\-_]+\\]");
        final Pattern rightArrowPattern = Pattern.compile("=>");
        final Pattern semicolonPattern = Pattern.compile(";");
        final Pattern wordPattern = Pattern.compile("[a-zA-Z0-9\\-_]+");

        final int STATE_COMMAND           = 0;
        final int STATE_IMPORT_PKG        = 1;
        final int STATE_ADD_LIBRARY       = 2;
        final int STATE_FILTER_CLASS      = 3;
        final int STATE_FILTER_NAME       = 4;
        final int STATE_CURLY_OPEN        = 5;
        final int STATE_PARAMETERS        = 6;
        final int STATE_CURLY_CLOSE       = 7;
        final int STATE_SOURCE_FILTERNAME = 8;
        final int STATE_SOURCE_PORT       = 9;
        final int STATE_RIGHT_ARROW       = 10;
        final int STATE_TARGET_FILTERNAME = 11;
        final int STATE_TARGET_PORT       = 12;
        final int STATE_ASSIGNMENT        = 13;
        final int STATE_EXTERNAL          = 14;
        final int STATE_SETTING           = 15;
        final int STATE_SEMICOLON         = 16;

        int state = STATE_COMMAND;
        PatternScanner scanner = new PatternScanner(graphString, ignorePattern);

        String curClassName = null;
        String curSourceFilterName = null;
        String curSourcePortName = null;
        String curTargetFilterName = null;
        String curTargetPortName = null;

        // State machine main loop
        while (!scanner.atEnd()) {
            switch (state) {
                case STATE_COMMAND: {
                    String curCommand = scanner.eat(commandPattern, "<command>");
                    if (curCommand.equals("@import")) {
                        state = STATE_IMPORT_PKG;
                    } else if (curCommand.equals("@library")) {
                        state = STATE_ADD_LIBRARY;
                    } else if (curCommand.equals("@filter")) {
                        state = STATE_FILTER_CLASS;
                    } else if (curCommand.equals("@connect")) {
                        state = STATE_SOURCE_FILTERNAME;
                    } else if (curCommand.equals("@set")) {
                        state = STATE_ASSIGNMENT;
                    } else if (curCommand.equals("@external")) {
                        state = STATE_EXTERNAL;
                    } else if (curCommand.equals("@setting")) {
                        state = STATE_SETTING;
                    } else {
                        throw new GraphIOException("Unknown command '" + curCommand + "'!");
                    }
                    break;
                }

                case STATE_IMPORT_PKG: {
                    String packageName = scanner.eat(packageNamePattern, "<package-name>");
                    mCommands.add(new ImportPackageCommand(packageName));
                    state = STATE_SEMICOLON;
                    break;
                }

                case STATE_ADD_LIBRARY: {
                    String libraryName = scanner.eat(libraryNamePattern, "<library-name>");
                    mCommands.add(new AddLibraryCommand(libraryName));
                    state = STATE_SEMICOLON;
                    break;
                }

                case STATE_FILTER_CLASS:
                    curClassName = scanner.eat(wordPattern, "<class-name>");
                    state = STATE_FILTER_NAME;
                    break;

                case STATE_FILTER_NAME: {
                    String curFilterName = scanner.eat(wordPattern, "<filter-name>");
                    mCommands.add(new AllocateFilterCommand(curClassName, curFilterName));
                    state = STATE_CURLY_OPEN;
                    break;
                }

                case STATE_CURLY_OPEN:
                    scanner.eat(curlyOpenPattern, "{");
                    state = STATE_PARAMETERS;
                    break;

                case STATE_PARAMETERS: {
                    KeyValueMap params = readKeyValueAssignments(scanner, curlyClosePattern);
                    mCommands.add(new InitFilterCommand(params));
                    state = STATE_CURLY_CLOSE;
                    break;
                }

                case STATE_CURLY_CLOSE:
                    scanner.eat(curlyClosePattern, "}");
                    state = STATE_COMMAND;
                    break;

                case STATE_SOURCE_FILTERNAME:
                    curSourceFilterName = scanner.eat(wordPattern, "<source-filter-name>");
                    state = STATE_SOURCE_PORT;
                    break;

                case STATE_SOURCE_PORT: {
                    String portString = scanner.eat(portPattern, "[<source-port-name>]");
                    curSourcePortName = portString.substring(1, portString.length() - 1);
                    state = STATE_RIGHT_ARROW;
                    break;
                }

                case STATE_RIGHT_ARROW:
                    scanner.eat(rightArrowPattern, "=>");
                    state = STATE_TARGET_FILTERNAME;
                    break;

                case STATE_TARGET_FILTERNAME:
                    curTargetFilterName = scanner.eat(wordPattern, "<target-filter-name>");
                    state = STATE_TARGET_PORT;
                    break;

                case STATE_TARGET_PORT: {
                    String portString = scanner.eat(portPattern, "[<target-port-name>]");
                    curTargetPortName = portString.substring(1, portString.length() - 1);
                    mCommands.add(new ConnectCommand(curSourceFilterName,
                                                     curSourcePortName,
                                                     curTargetFilterName,
                                                     curTargetPortName));
                    state = STATE_SEMICOLON;
                    break;
                }

                case STATE_ASSIGNMENT: {
                    KeyValueMap assignment = readKeyValueAssignments(scanner, semicolonPattern);
                    mBoundReferences.putAll(assignment);
                    state = STATE_SEMICOLON;
                    break;
                }

                case STATE_EXTERNAL: {
                    String externalName = scanner.eat(wordPattern, "<external-identifier>");
                    bindExternal(externalName);
                    state = STATE_SEMICOLON;
                    break;
                }

                case STATE_SETTING: {
                    KeyValueMap setting = readKeyValueAssignments(scanner, semicolonPattern);
                    mSettings.putAll(setting);
                    state = STATE_SEMICOLON;
                    break;
                }

                case STATE_SEMICOLON:
                    scanner.eat(semicolonPattern, ";");
                    state = STATE_COMMAND;
                    break;
            }
        }

        // Make sure end of input was expected
        if (state != STATE_SEMICOLON && state != STATE_COMMAND) {
            throw new GraphIOException("Unexpected end of input!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.642 -0400", hash_original_method = "58EC5340CC7BCC5CDD1FFA02790DAF40", hash_generated_method = "0D7C33F9A8BD8FE775677295F642B233")
    
@Override
    public KeyValueMap readKeyValueAssignments(String assignments) throws GraphIOException {
        final Pattern ignorePattern = Pattern.compile("\\s+");
        PatternScanner scanner = new PatternScanner(assignments, ignorePattern);
        return readKeyValueAssignments(scanner, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.646 -0400", hash_original_method = "FC68664C04AD2A184500B90DD83F203F", hash_generated_method = "3B10E799990A71B1BD9A5154560689AB")
    
private KeyValueMap readKeyValueAssignments(PatternScanner scanner,
                                                Pattern endPattern) throws GraphIOException {
        // Our parser is a state-machine, and these are our states
        final int STATE_IDENTIFIER = 0;
        final int STATE_EQUALS     = 1;
        final int STATE_VALUE      = 2;
        final int STATE_POST_VALUE = 3;

        final Pattern equalsPattern = Pattern.compile("=");
        final Pattern semicolonPattern = Pattern.compile(";");
        final Pattern wordPattern = Pattern.compile("[a-zA-Z]+[a-zA-Z0-9]*");
        final Pattern stringPattern = Pattern.compile("'[^']*'|\\\"[^\\\"]*\\\"");
        final Pattern intPattern = Pattern.compile("[0-9]+");
        final Pattern floatPattern = Pattern.compile("[0-9]*\\.[0-9]+f?");
        final Pattern referencePattern = Pattern.compile("\\$[a-zA-Z]+[a-zA-Z0-9]");
        final Pattern booleanPattern = Pattern.compile("true|false");

        int state = STATE_IDENTIFIER;
        KeyValueMap newVals = new KeyValueMap();
        String curKey = null;
        String curValue = null;

        while (!scanner.atEnd() && !(endPattern != null && scanner.peek(endPattern))) {
            switch (state) {
                case STATE_IDENTIFIER:
                    curKey = scanner.eat(wordPattern, "<identifier>");
                    state = STATE_EQUALS;
                    break;

                case STATE_EQUALS:
                    scanner.eat(equalsPattern, "=");
                    state = STATE_VALUE;
                    break;

                case STATE_VALUE:
                    if ((curValue = scanner.tryEat(stringPattern)) != null) {
                        newVals.put(curKey, curValue.substring(1, curValue.length() - 1));
                    } else if ((curValue = scanner.tryEat(referencePattern)) != null) {
                        String refName = curValue.substring(1, curValue.length());
                        Object referencedObject = mBoundReferences != null
                            ? mBoundReferences.get(refName)
                            : null;
                        if (referencedObject == null) {
                            throw new GraphIOException(
                                "Unknown object reference to '" + refName + "'!");
                        }
                        newVals.put(curKey, referencedObject);
                    } else if ((curValue = scanner.tryEat(booleanPattern)) != null) {
                        newVals.put(curKey, Boolean.parseBoolean(curValue));
                    } else if ((curValue = scanner.tryEat(floatPattern)) != null) {
                        newVals.put(curKey, Float.parseFloat(curValue));
                    } else if ((curValue = scanner.tryEat(intPattern)) != null) {
                        newVals.put(curKey, Integer.parseInt(curValue));
                    } else {
                        throw new GraphIOException(scanner.unexpectedTokenMessage("<value>"));
                    }
                    state = STATE_POST_VALUE;
                    break;

                case STATE_POST_VALUE:
                    scanner.eat(semicolonPattern, ";");
                    state = STATE_IDENTIFIER;
                    break;
            }
        }

        // Make sure end is expected
        if (state != STATE_IDENTIFIER && state != STATE_POST_VALUE) {
            throw new GraphIOException(
                "Unexpected end of assignments on line " + scanner.lineNo() + "!");
        }

        return newVals;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.648 -0400", hash_original_method = "2CAF9AA78A2489E869C4D0D85684A402", hash_generated_method = "B9C4B25F3CC1D9CEC91CC41ACDDBD38B")
    
private void bindExternal(String name) throws GraphIOException {
        if (mReferences.containsKey(name)) {
            Object value = mReferences.get(name);
            mBoundReferences.put(name, value);
        } else {
            throw new GraphIOException("Unknown external variable '" + name + "'! "
                + "You must add a reference to this external in the host program using "
                + "addReference(...)!");
        }
    }

    /**
     * Unused for now: Often you may want to declare references that are NOT in a certain graph,
     * e.g. when reading multiple graphs with the same reader. We could print a warning, but even
     * that may be too much.
     **/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.650 -0400", hash_original_method = "123847FE1B1E795CDB2F4DEA8EA51ED0", hash_generated_method = "82C80C153D7F8DF41947171F6D5F2A19")
    
private void checkReferences() throws GraphIOException {
        for (String reference : mReferences.keySet()) {
            if (!mBoundReferences.containsKey(reference)) {
                throw new GraphIOException(
                    "Host program specifies reference to '" + reference + "', which is not "
                    + "declared @external in graph file!");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.652 -0400", hash_original_method = "C20B71390B8CD6DE8DAE7BED62D14067", hash_generated_method = "EE30A64A7F9CB548948C2A664AF304C7")
    
private void applySettings() throws GraphIOException {
        for (String setting : mSettings.keySet()) {
            Object value = mSettings.get(setting);
            if (setting.equals("autoBranch")) {
                expectSettingClass(setting, value, String.class);
                if (value.equals("synced")) {
                    mCurrentGraph.setAutoBranchMode(FilterGraph.AUTOBRANCH_SYNCED);
                } else if (value.equals("unsynced")) {
                    mCurrentGraph.setAutoBranchMode(FilterGraph.AUTOBRANCH_UNSYNCED);
                } else if (value.equals("off")) {
                    mCurrentGraph.setAutoBranchMode(FilterGraph.AUTOBRANCH_OFF);
                } else {
                    throw new GraphIOException("Unknown autobranch setting: " + value + "!");
                }
            } else if (setting.equals("discardUnconnectedOutputs")) {
                expectSettingClass(setting, value, Boolean.class);
                mCurrentGraph.setDiscardUnconnectedOutputs((Boolean)value);
            } else {
                throw new GraphIOException("Unknown @setting '" + setting + "'!");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.654 -0400", hash_original_method = "A95871BAF27DAF160F81723D9F8949E2", hash_generated_method = "F772DE521F3E1F1276779750E9116244")
    
private void expectSettingClass(String setting,
                                    Object value,
                                    Class expectedClass) throws GraphIOException {
        if (value.getClass() != expectedClass) {
            throw new GraphIOException("Setting '" + setting + "' must have a value of type "
                + expectedClass.getSimpleName() + ", but found a value of type "
                + value.getClass().getSimpleName() + "!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.655 -0400", hash_original_method = "0425AEE2141F32BD76BCF43945DFAA19", hash_generated_method = "CB17203B392E3A7B201BCD9A5212486B")
    
private void executeCommands() throws GraphIOException {
        for (Command command : mCommands) {
            command.execute(this);
        }
    }
}
