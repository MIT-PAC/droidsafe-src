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


package android.filterfw.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.filterfw.core.FilterGraph;
import android.filterfw.core.KeyValueMap;
import android.filterfw.io.GraphIOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @hide
 */
public abstract class GraphReader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.232 -0400", hash_original_field = "951CB82E6FCB7FAEE89455848F46E333", hash_generated_field = "7B626ECA2DAE775668D88EFEF7C32B81")


    protected KeyValueMap mReferences = new KeyValueMap();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.234 -0400", hash_original_method = "0BC69507ACB554294CF5A2EEB641682B", hash_generated_method = "22477E20E70787C20459CC3495ABE9E6")
    
public abstract FilterGraph readGraphString(String graphString) throws GraphIOException;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.236 -0400", hash_original_method = "4F90CE271A026512066FB60A90AEC5FB", hash_generated_method = "35C244E086E4BACD1C9B772B6C83882B")
    
public abstract KeyValueMap readKeyValueAssignments(String assignments) throws GraphIOException;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.238 -0400", hash_original_method = "01BA2D5FCFC381484690EF09D0A966EC", hash_generated_method = "68D333C9BD78F103378DCF38FC622BF2")
    
public FilterGraph readGraphResource(Context context, int resourceId) throws GraphIOException {
        InputStream inputStream = context.getResources().openRawResource(resourceId);
        InputStreamReader reader = new InputStreamReader(inputStream);
        StringWriter writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            int bytesRead;
            while ((bytesRead = reader.read(buffer, 0, 1024)) > 0) {
                writer.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read specified resource file!");
        }
        return readGraphString(writer.toString());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.240 -0400", hash_original_method = "FE2888DF1A7F354E87191D464D7FA9FC", hash_generated_method = "E4F08B1CCFEFF37C79ACD8CF2E90C71C")
    
public void addReference(String name, Object object) {
        mReferences.put(name, object);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.243 -0400", hash_original_method = "E3D00CA009B54DC191460085FC82004E", hash_generated_method = "1D55D140D83CB0504E8FAB85F6FAAF5A")
    
public void addReferencesByMap(KeyValueMap refs) {
        mReferences.putAll(refs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.245 -0400", hash_original_method = "A95523AE90EE8F35C5334B109BEB17CF", hash_generated_method = "67F235D8D2568B2890CC9C52BA1C60C9")
    
public void addReferencesByKeysAndValues(Object... references) {
        mReferences.setKeyValues(references);
    }

}
