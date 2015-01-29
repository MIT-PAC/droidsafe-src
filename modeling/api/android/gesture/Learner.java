/*
 * Copyright (C) 2008-2009 The Android Open Source Project
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

package android.gesture;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.ArrayList;

/**
 * The abstract class of a gesture learner
 */
abstract class Learner {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.826 -0500", hash_original_field = "D761CA78C260A014E52371B1F04D957A", hash_generated_field = "7EB92977A0BA6081CDCCC9971325609B")

    private final ArrayList<Instance> mInstances = new ArrayList<Instance>();

    /**
     * Add an instance to the learner
     * 
     * @param instance
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.831 -0500", hash_original_method = "D94AE6B85AB042361235C800BCD8A706", hash_generated_method = "D94AE6B85AB042361235C800BCD8A706")
    
void addInstance(Instance instance) {
        mInstances.add(instance);
    }

    /**
     * Retrieve all the instances
     * 
     * @return instances
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.834 -0500", hash_original_method = "84787ACC35588752DFD4ACB7D3F2F9DF", hash_generated_method = "84787ACC35588752DFD4ACB7D3F2F9DF")
    
ArrayList<Instance> getInstances() {
        return mInstances;
    }

    /**
     * Remove an instance based on its id
     * 
     * @param id
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.838 -0500", hash_original_method = "FCF72F17712B40C1900B0880A745FF98", hash_generated_method = "FCF72F17712B40C1900B0880A745FF98")
    
void removeInstance(long id) {
        ArrayList<Instance> instances = mInstances;
        int count = instances.size();
        for (int i = 0; i < count; i++) {
            Instance instance = instances.get(i);
            if (id == instance.id) {
                instances.remove(instance);
                return;
            }
        }
    }

    /**
     * Remove all the instances of a category
     * 
     * @param name the category name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.842 -0500", hash_original_method = "147AB1989383F33A022B26EB99E90D7A", hash_generated_method = "B89159961AD874362EC3DC177E123354")
    
void removeInstances(String name) {
        final ArrayList<Instance> toDelete = new ArrayList<Instance>();
        final ArrayList<Instance> instances = mInstances;
        final int count = instances.size();

        for (int i = 0; i < count; i++) {
            final Instance instance = instances.get(i);
            // the label can be null, as specified in Instance
            if ((instance.label == null && name == null)
                    || (instance.label != null && instance.label.equals(name))) {
                toDelete.add(instance);
            }
        }
        instances.removeAll(toDelete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.846 -0500", hash_original_method = "7FF581D2986F9086AF743BDDF51E3BE3", hash_generated_method = "09CC77E39B04012976FCE0E389E1454F")
    
abstract ArrayList<Prediction> classify(int sequenceType, int orientationType, float[] vector);
}
