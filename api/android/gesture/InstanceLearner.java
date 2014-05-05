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
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * An implementation of an instance-based learner
 */

class InstanceLearner extends Learner {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.745 -0500", hash_original_field = "DC32B45211124CAA5FA726248F32C8C0", hash_generated_field = "98E155612385280F98D6C7DF53461FF9")

    private static final Comparator<Prediction> sComparator = new Comparator<Prediction>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-05-05 09:45:23.947 -0400", hash_original_method = "495639D6E51F2F01CB4373EEB2E59774", hash_generated_method = "2B004B74A0350F0975EE7846FEE78642")
        
public int compare(Prediction object1, Prediction object2) {
            double score1 = object1.score;
            double score2 = object2.score;
            if (score1 > score2) {
                return -1;
            } else if (score1 < score2) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.750 -0500", hash_original_method = "DEA228C45E6EB1BCB063B5BBEA15646F", hash_generated_method = "64A4AD0F0EEC059DF54A53AD0665EBF2")
    
@Override
    ArrayList<Prediction> classify(int sequenceType, int orientationType, float[] vector) {
        ArrayList<Prediction> predictions = new ArrayList<Prediction>();
        ArrayList<Instance> instances = getInstances();
        int count = instances.size();
        TreeMap<String, Double> label2score = new TreeMap<String, Double>();
        for (int i = 0; i < count; i++) {
            Instance sample = instances.get(i);
            if (sample.vector.length != vector.length) {
                continue;
            }
            double distance;
            if (sequenceType == GestureStore.SEQUENCE_SENSITIVE) {
                distance = GestureUtils.minimumCosineDistance(sample.vector, vector, orientationType);
            } else {
                distance = GestureUtils.squaredEuclideanDistance(sample.vector, vector);
            }
            double weight;
            if (distance == 0) {
                weight = Double.MAX_VALUE;
            } else {
                weight = 1 / distance;
            }
            Double score = label2score.get(sample.label);
            if (score == null || weight > score) {
                label2score.put(sample.label, weight);
            }
        }

//        double sum = 0;
        for (String name : label2score.keySet()) {
            double score = label2score.get(name);
//            sum += score;
            predictions.add(new Prediction(name, score));
        }

        // normalize
//        for (Prediction prediction : predictions) {
//            prediction.score /= sum;
//        }

        Collections.sort(predictions, sComparator);

        return predictions;
    }
}
