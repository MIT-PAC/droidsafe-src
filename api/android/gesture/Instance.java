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


/**
 * An instance represents a sample if the label is available or a query if the
 * label is null.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
class Instance {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.560 -0500", hash_original_field = "399B81D9B7D7677F16905A204E622401", hash_generated_field = "41005F0ECAAED073A4035AA930AFE143")

    private static final int SEQUENCE_SAMPLE_SIZE = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.564 -0500", hash_original_field = "C1DC964750D77635EEDDE4FF5E63D275", hash_generated_field = "747CF7B3AF1177D3E68BE9607B60A85B")


    private static final int PATCH_SAMPLE_SIZE = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.568 -0500", hash_original_field = "8B3F6DD4776A38991EB9FCC8DF02F3EE", hash_generated_field = "E9584B32166C9208196A00140F67396E")


    private final static float[] ORIENTATIONS = {
            0, (float) (Math.PI / 4), (float) (Math.PI / 2), (float) (Math.PI * 3 / 4),
            (float) Math.PI, -0, (float) (-Math.PI / 4), (float) (-Math.PI / 2),
            (float) (-Math.PI * 3 / 4), (float) -Math.PI
    };

    /**
     * create a learning instance for a single stroke gesture
     * 
     * @param gesture
     * @param label
     * @return the instance
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.591 -0500", hash_original_method = "FA063F91D44E7D4042E286E05194EEE9", hash_generated_method = "669017D820CEDFE100C3C214E1FCE2C7")
    
static Instance createInstance(int sequenceType, int orientationType, Gesture gesture, String label) {
        float[] pts;
        Instance instance;
        if (sequenceType == GestureStore.SEQUENCE_SENSITIVE) {
            pts = temporalSampler(orientationType, gesture);
            instance = new Instance(gesture.getID(), pts, label);
            instance.normalize();
        } else {
            pts = spatialSampler(gesture);
            instance = new Instance(gesture.getID(), pts, label);
        }
        return instance;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.595 -0500", hash_original_method = "76801407CAB0DC6008BD9F4CF1F70919", hash_generated_method = "43973CDAAE25AF2C4B3EDD3055CFA01F")
    
private static float[] spatialSampler(Gesture gesture) {
        return GestureUtils.spatialSampling(gesture, PATCH_SAMPLE_SIZE, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.599 -0500", hash_original_method = "272593BB476388743F7E6E0F5C28C91C", hash_generated_method = "7A2292612F80C0BA9DA4C0FBA553ECD1")
    
private static float[] temporalSampler(int orientationType, Gesture gesture) {
        float[] pts = GestureUtils.temporalSampling(gesture.getStrokes().get(0),
                SEQUENCE_SAMPLE_SIZE);
        float[] center = GestureUtils.computeCentroid(pts);
        float orientation = (float)Math.atan2(pts[1] - center[1], pts[0] - center[0]);

        float adjustment = -orientation;
        if (orientationType != GestureStore.ORIENTATION_INVARIANT) {
            int count = ORIENTATIONS.length;
            for (int i = 0; i < count; i++) {
                float delta = ORIENTATIONS[i] - orientation;
                if (Math.abs(delta) < Math.abs(adjustment)) {
                    adjustment = delta;
                }
            }
        }

        GestureUtils.translate(pts, -center[0], -center[1]);
        GestureUtils.rotate(pts, adjustment);

        return pts;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.572 -0500", hash_original_field = "989BF96B556C82CF130876F5914B0331", hash_generated_field = "989BF96B556C82CF130876F5914B0331")

     float[] vector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.575 -0500", hash_original_field = "70D504428E5C639AB422D258A4592324", hash_generated_field = "70D504428E5C639AB422D258A4592324")

     String label;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.579 -0500", hash_original_field = "FF4AD99D820B36F46F04892B42F122AA", hash_generated_field = "FF4AD99D820B36F46F04892B42F122AA")

     long id;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.582 -0500", hash_original_method = "29F9E6AB23C76D916D306407CBAE0F70", hash_generated_method = "B4066B554CF0134CF8728C3D83EC237D")
    
private Instance(long id, float[] sample, String sampleName) {
        this.id = id;
        vector = sample;
        label = sampleName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.586 -0500", hash_original_method = "918BE99CFB8BAD54CC32B5877DB15697", hash_generated_method = "D68003E15F4E6349B389D638778E8D78")
    
private void normalize() {
        float[] sample = vector;
        float sum = 0;

        int size = sample.length;
        for (int i = 0; i < size; i++) {
            sum += sample[i] * sample[i];
        }

        float magnitude = (float)Math.sqrt(sum);
        for (int i = 0; i < size; i++) {
            sample[i] /= magnitude;
        }
    }

}
