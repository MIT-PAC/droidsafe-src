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
import android.util.Log;
import android.os.SystemClock;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

import static android.gesture.GestureConstants.LOG_TAG;

/**
 * GestureLibrary maintains gesture examples and makes predictions on a new
 * gesture
 */
//
//    File format for GestureStore:
//
//                Nb. bytes   Java type   Description
//                -----------------------------------
//    Header
//                2 bytes     short       File format version number
//                4 bytes     int         Number of entries
//    Entry
//                X bytes     UTF String  Entry name
//                4 bytes     int         Number of gestures
//    Gesture
//                8 bytes     long        Gesture ID
//                4 bytes     int         Number of strokes
//    Stroke
//                4 bytes     int         Number of points
//    Point
//                4 bytes     float       X coordinate of the point
//                4 bytes     float       Y coordinate of the point
//                8 bytes     long        Time stamp
//
public class GestureStore {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.745 -0500", hash_original_field = "8E2C7400C7366E2374752DE12BE4C491", hash_generated_field = "F0A473850C4CD331C7EFB2C156BD97C3")

    public static final int SEQUENCE_INVARIANT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.752 -0500", hash_original_field = "758DB0C4F2EC9C32D749F5D62DA84FBB", hash_generated_field = "52B3853FCAF3CF7C140779FA7026CE00")

    public static final int SEQUENCE_SENSITIVE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.757 -0500", hash_original_field = "FD354C02EC09CFCCD5EF9C500B8D8635", hash_generated_field = "A751857FF297DE8208E17244D6E2C93E")

    public static final int ORIENTATION_INVARIANT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.764 -0500", hash_original_field = "F931DF1F0CC2FB86C6A123E0FC519879", hash_generated_field = "10A09469A8437F2C06DA00A6C3E73D20")

    public static final int ORIENTATION_SENSITIVE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.769 -0500", hash_original_field = "4ED45D6831CD2160ABB0A2A40006D0CD", hash_generated_field = "76D466E9AFF78BFE4926156511B20A85")

    static final int ORIENTATION_SENSITIVE_4 = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.776 -0500", hash_original_field = "F23DEFF93309CB3EB557BE647620D658", hash_generated_field = "A2EA23A9422F88DDBC8B27C498668AEA")

    static final int ORIENTATION_SENSITIVE_8 = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.783 -0500", hash_original_field = "9E68DF176A20C2A6C15BA4854FB042DB", hash_generated_field = "8D4E0C641B1DD0FFC89C73E774AAA09F")


    private static final short FILE_FORMAT_VERSION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.789 -0500", hash_original_field = "34F8A4231AE9F15473E313C743283593", hash_generated_field = "E93907938589DAF2F36FFE8BEA861530")


    private static final boolean PROFILE_LOADING_SAVING = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.793 -0500", hash_original_field = "D3B7F2247E481F307324C6381621E171", hash_generated_field = "EB0FADE2CBD0CE9ADEF190FF36F60F55")


    private int mSequenceType = SEQUENCE_SENSITIVE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.798 -0500", hash_original_field = "F83952CD23675F150A9EB0618B68D522", hash_generated_field = "0EF8D3B30CC905D106824AA77D27E948")

    private int mOrientationStyle = ORIENTATION_SENSITIVE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.806 -0500", hash_original_field = "359B39415917E696A664DC44EAAEACDC", hash_generated_field = "F641260C7ECA51BF0B73CABEF65EC6A5")


    private final HashMap<String, ArrayList<Gesture>> mNamedGestures =
            new HashMap<String, ArrayList<Gesture>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.815 -0500", hash_original_field = "FE1C8DF163FBB25E4EC4185FE30A8EA6", hash_generated_field = "1C2992F0AB4BCF48731CE0CABDD3AD64")


    private Learner mClassifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.819 -0500", hash_original_field = "9EFC71A998E071EF3DEE17FEDF3B1CE2", hash_generated_field = "F4B4AF3458A522C6D37D71090AF57699")


    private boolean mChanged = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.824 -0500", hash_original_method = "5531FB549AC0E038D97F4F08F63CA9BD", hash_generated_method = "679BB693BC85FD66BBC23785498F4D48")
    
public GestureStore() {
        mClassifier = new InstanceLearner();
    }

    /**
     * Specify how the gesture library will handle orientation. 
     * Use ORIENTATION_INVARIANT or ORIENTATION_SENSITIVE
     * 
     * @param style
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.830 -0500", hash_original_method = "232A82A9F351A65F2766B9452F3B8742", hash_generated_method = "9210D4DE71FE77A4E423CB7E58A70853")
    
public void setOrientationStyle(int style) {
        mOrientationStyle = style;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.835 -0500", hash_original_method = "B38F68CC1B94F90D5A297ACF64B5E50D", hash_generated_method = "4FB7A520599CB3E9739452851EF33CCF")
    
public int getOrientationStyle() {
        return mOrientationStyle;
    }

    /**
     * @param type SEQUENCE_INVARIANT or SEQUENCE_SENSITIVE
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.839 -0500", hash_original_method = "067042945FAB033317C8160EAD8E0F66", hash_generated_method = "827139E24FCD01468AF39C9F7B5F132D")
    
public void setSequenceType(int type) {
        mSequenceType = type;
    }

    /**
     * @return SEQUENCE_INVARIANT or SEQUENCE_SENSITIVE
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.843 -0500", hash_original_method = "2B1EB3CFB0C11A9627875E336A46D82D", hash_generated_method = "0C8A74BA544948DCB8DAC3357E31B72B")
    
public int getSequenceType() {
        return mSequenceType;
    }

    /**
     * Get all the gesture entry names in the library
     * 
     * @return a set of strings
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.849 -0500", hash_original_method = "1FFFC2E67B0AF3EBCB792AC06A241965", hash_generated_method = "1CE07BC9A40221FE3ECFCA5C798DD7EB")
    
public Set<String> getGestureEntries() {
        return mNamedGestures.keySet();
    }

    /**
     * Recognize a gesture
     * 
     * @param gesture the query
     * @return a list of predictions of possible entries for a given gesture
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.853 -0500", hash_original_method = "22F3ACF33B32552677DA78FC4700055D", hash_generated_method = "0A022108A21F8B8FE3B77E0B9F2CBBD7")
    
public ArrayList<Prediction> recognize(Gesture gesture) {
        Instance instance = Instance.createInstance(mSequenceType,
                mOrientationStyle, gesture, null);
        return mClassifier.classify(mSequenceType, mOrientationStyle, instance.vector);
    }

    /**
     * Add a gesture for the entry
     * 
     * @param entryName entry name
     * @param gesture
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.860 -0500", hash_original_method = "EA9B69B04B091CE31C2FA335B78FBE5D", hash_generated_method = "7FE30655C7379EA539EA4C6666F2EE29")
    
public void addGesture(String entryName, Gesture gesture) {
        if (entryName == null || entryName.length() == 0) {
            return;
        }
        ArrayList<Gesture> gestures = mNamedGestures.get(entryName);
        if (gestures == null) {
            gestures = new ArrayList<Gesture>();
            mNamedGestures.put(entryName, gestures);
        }
        gestures.add(gesture);
        mClassifier.addInstance(
                Instance.createInstance(mSequenceType, mOrientationStyle, gesture, entryName));
        mChanged = true;
    }

    /**
     * Remove a gesture from the library. If there are no more gestures for the
     * given entry, the gesture entry will be removed.
     * 
     * @param entryName entry name
     * @param gesture
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.865 -0500", hash_original_method = "4CBE318B56F1B985563A577FAF49DFF2", hash_generated_method = "5BFD624F16B9244833249DF0E5BD5398")
    
public void removeGesture(String entryName, Gesture gesture) {
        ArrayList<Gesture> gestures = mNamedGestures.get(entryName);
        if (gestures == null) {
            return;
        }

        gestures.remove(gesture);

        // if there are no more samples, remove the entry automatically
        if (gestures.isEmpty()) {
            mNamedGestures.remove(entryName);
        }

        mClassifier.removeInstance(gesture.getID());

        mChanged = true;
    }

    /**
     * Remove a entry of gestures
     * 
     * @param entryName the entry name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.870 -0500", hash_original_method = "89453F92BB4E447EC0C2A9408EB7187A", hash_generated_method = "268DE9DA1BF629AF38FBAE0685B0BC27")
    
public void removeEntry(String entryName) {
        mNamedGestures.remove(entryName);
        mClassifier.removeInstances(entryName);
        mChanged = true;
    }

    /**
     * Get all the gestures of an entry
     * 
     * @param entryName
     * @return the list of gestures that is under this name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.875 -0500", hash_original_method = "E61B29F45CE9E2E6D0BD7D44B77330B7", hash_generated_method = "8835A68D4F5DB87908071F141A273674")
    
public ArrayList<Gesture> getGestures(String entryName) {
        ArrayList<Gesture> gestures = mNamedGestures.get(entryName);
        if (gestures != null) {
            return new ArrayList<Gesture>(gestures);
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.880 -0500", hash_original_method = "2A915DCBEEE5E29E835DBA7991CF5734", hash_generated_method = "30A708ED2D7275B8A176EADEA1312207")
    
public boolean hasChanged() {
        return mChanged;
    }

    /**
     * Save the gesture library
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.885 -0500", hash_original_method = "AB3B67AC2C613250AEA5BEF5DC292179", hash_generated_method = "F36B2CA49B0AE46BFBBD8786458F5BC5")
    
public void save(OutputStream stream) throws IOException {
        save(stream, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.892 -0500", hash_original_method = "2BE69522CA898F0E1F9A3EFB47B2448C", hash_generated_method = "EB224AC87D838C3AE185C6F3E6025DE3")
    
public void save(OutputStream stream, boolean closeStream) throws IOException {
        DataOutputStream out = null;

        try {
            long start;
            if (PROFILE_LOADING_SAVING) {
                start = SystemClock.elapsedRealtime();
            }

            final HashMap<String, ArrayList<Gesture>> maps = mNamedGestures;

            out = new DataOutputStream((stream instanceof BufferedOutputStream) ? stream :
                    new BufferedOutputStream(stream, GestureConstants.IO_BUFFER_SIZE));
            // Write version number
            out.writeShort(FILE_FORMAT_VERSION);
            // Write number of entries
            out.writeInt(maps.size());

            for (Map.Entry<String, ArrayList<Gesture>> entry : maps.entrySet()) {
                final String key = entry.getKey();
                final ArrayList<Gesture> examples = entry.getValue();
                final int count = examples.size();

                // Write entry name
                out.writeUTF(key);
                // Write number of examples for this entry
                out.writeInt(count);

                for (int i = 0; i < count; i++) {
                    examples.get(i).serialize(out);
                }
            }

            out.flush();

            if (PROFILE_LOADING_SAVING) {
                long end = SystemClock.elapsedRealtime();
                Log.d(LOG_TAG, "Saving gestures library = " + (end - start) + " ms");
            }

            mChanged = false;
        } finally {
            if (closeStream) GestureUtils.closeStream(out);
        }
    }

    /**
     * Load the gesture library
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.897 -0500", hash_original_method = "D9B10BD78AF21FE8E9ED306574CD8D66", hash_generated_method = "74AFE05E640A22336D6393FB5F1B6B90")
    
public void load(InputStream stream) throws IOException {
        load(stream, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.903 -0500", hash_original_method = "6551326F7A8BE27256D69FD6DC68113B", hash_generated_method = "A14FDC5C0C9C30BE0FC992D4487FCA6E")
    
public void load(InputStream stream, boolean closeStream) throws IOException {
        DataInputStream in = null;
        try {
            in = new DataInputStream((stream instanceof BufferedInputStream) ? stream :
                    new BufferedInputStream(stream, GestureConstants.IO_BUFFER_SIZE));

            long start;
            if (PROFILE_LOADING_SAVING) {
                start = SystemClock.elapsedRealtime();
            }

            // Read file format version number
            final short versionNumber = in.readShort();
            switch (versionNumber) {
                case 1:
                    readFormatV1(in);
                    break;
            }

            if (PROFILE_LOADING_SAVING) {
                long end = SystemClock.elapsedRealtime();
                Log.d(LOG_TAG, "Loading gestures library = " + (end - start) + " ms");
            }
        } finally {
            if (closeStream) GestureUtils.closeStream(in);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.910 -0500", hash_original_method = "F37D38C0F738795F455049E8C2FB858B", hash_generated_method = "2125312AD07A6141C4AE9289C156D1C2")
    
private void readFormatV1(DataInputStream in) throws IOException {
        final Learner classifier = mClassifier;
        final HashMap<String, ArrayList<Gesture>> namedGestures = mNamedGestures;
        namedGestures.clear();

        // Number of entries in the library
        final int entriesCount = in.readInt();

        for (int i = 0; i < entriesCount; i++) {
            // Entry name
            final String name = in.readUTF();
            // Number of gestures
            final int gestureCount = in.readInt();

            final ArrayList<Gesture> gestures = new ArrayList<Gesture>(gestureCount);
            for (int j = 0; j < gestureCount; j++) {
                final Gesture gesture = Gesture.deserialize(in);
                gestures.add(gesture);
                classifier.addInstance(
                        Instance.createInstance(mSequenceType, mOrientationStyle, gesture, name));
            }

            namedGestures.put(name, gestures);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:39.914 -0500", hash_original_method = "ADC8F46AF11C63477EA1DCF20200E1A7", hash_generated_method = "ADC8F46AF11C63477EA1DCF20200E1A7")
    
Learner getLearner() {
        return mClassifier;
    }
}
