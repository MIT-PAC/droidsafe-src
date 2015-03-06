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
 * Copyright (C) 2006 The Android Open Source Project
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


package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.util.Pool;
import android.util.Poolable;
import android.util.PoolableManager;
import android.util.Pools;

import droidsafe.helpers.DSUtils;

public final class VelocityTracker implements Poolable<VelocityTracker> {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeInitialize() {
        return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeDispose(int ptr) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeClear(int ptr) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeAddMovement(int ptr, MotionEvent event) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeComputeCurrentVelocity(int ptr, int units, float maxVelocity) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static float nativeGetXVelocity(int ptr, int id) {
        return (ptr + id);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static float nativeGetYVelocity(int ptr, int id) {
        return (ptr + id);
    }
    
    private static boolean nativeGetEstimator(int ptr, int id,
            int degree, int horizonMillis, Estimator outEstimator) {
        outEstimator.addTaint(ptr + id + degree + horizonMillis);  
        return outEstimator.getTaintBoolean();
    }

    /**
     * Retrieve a new VelocityTracker object to watch the velocity of a
     * motion.  Be sure to call {@link #recycle} when done.  You should
     * generally only maintain an active object while tracking a movement,
     * so that the VelocityTracker can be re-used elsewhere.
     *
     * @return Returns a new VelocityTracker.
     */
    @DSComment("Touch event tracking")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.331 -0500", hash_original_method = "83965EAF73271D6A9CB89F99F2C4B6CA", hash_generated_method = "CA09BFD1026C74084FB63F043FC190B2")
    
static public VelocityTracker obtain() {
        return sPool.acquire();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.287 -0400", hash_original_field = "7D322AC6B02AE1303D1EE66F45C4A4CD", hash_generated_field = "B8A4DDDA4C487415D4255708CB5FC0DF")

    private static final Pool<VelocityTracker> sPool = Pools.synchronizedPool(
            Pools.finitePool(new PoolableManager<VelocityTracker>() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.275 -0500", hash_original_method = "D359C69621BCD5C84F8C774E2AB514A6", hash_generated_method = "043E0702A85EA683E9D59D6246E482A2")
        
public VelocityTracker newInstance() {
                    return new VelocityTracker();
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.278 -0500", hash_original_method = "6256597A5ABD4869A66029FB2A62D9CD", hash_generated_method = "67720C79AE8CE7C51ACD32E3060FFC90")
        
public void onAcquired(VelocityTracker element) {
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.281 -0500", hash_original_method = "C0AFEFEC4FD32FDD15412889678895FF", hash_generated_method = "77BB62D145212A804C99EE9F089E8C42")
        
public void onReleased(VelocityTracker element) {
                    element.clear();
                }
            }, 2));
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.287 -0500", hash_original_field = "A95286ACA8C408D15B5D383D6EEFACF5", hash_generated_field = "FF8FF6E56B8D783C306CE7F0923B38D1")

    private static final int ACTIVE_POINTER_ID = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.289 -0500", hash_original_field = "42C21A18FB5976D4C67962413781C35D", hash_generated_field = "E9A8054C2C57C0CE861FDCA982433D1A")

    private int mPtr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.292 -0500", hash_original_field = "0A4BF458203BDE753039342AAF95A5A1", hash_generated_field = "5B4B8EC4C61CE05CF5BB2F5E71D6C6C3")

    private VelocityTracker mNext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.295 -0500", hash_original_field = "016073DCFA93DD0305C42C8759ED2078", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

    private boolean mIsPooled;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.345 -0500", hash_original_method = "F7334C8DF7CFD0702F8B319FC0AAEBEC", hash_generated_method = "510D34D719DAF5921219F36E622C806A")
    
private VelocityTracker() {
        mPtr = nativeInitialize();
    }

    /**
     * Return a VelocityTracker object back to be re-used by others.  You must
     * not touch the object after calling this function.
     */
    @DSComment("Touch event tracking")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.333 -0500", hash_original_method = "E0F67E3C99A5EE80DA0668A59C0EFAE4", hash_generated_method = "670C7475CA1A8676109F0146EDF2835F")
    
public void recycle() {
        sPool.release(this);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.336 -0500", hash_original_method = "2CC1A1BE49EC62DFF418BB32459396A9", hash_generated_method = "8E256E08BB218894D0194F645493B430")
    
public void setNextPoolable(VelocityTracker element) {
        mNext = element;
    }

    /**
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.338 -0500", hash_original_method = "DEA3C3D2ED346DE60DC91CC9918022D0", hash_generated_method = "42A1357B7A96D732A658235D653E2787")
    
public VelocityTracker getNextPoolable() {
        return mNext;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.340 -0500", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "B6A97050680DD62F0E280740D1E9FA7B")
    
public boolean isPooled() {
        return mIsPooled;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.343 -0500", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "B03D6BD405969AD6559FEB8A8380BDD8")
    
public void setPooled(boolean isPooled) {
        mIsPooled = isPooled;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.348 -0500", hash_original_method = "388B6019F11DE2E32EE5A9A9056EF526", hash_generated_method = "F73C0E000449CBECE02F50B4A7992F7C")
    
@Override
    protected void finalize() throws Throwable {
        try {
            if (mPtr != 0) {
                nativeDispose(mPtr);
                mPtr = 0;
            }
        } finally {
            super.finalize();
        }
    }

    /**
     * Reset the velocity tracker back to its initial state.
     */
    @DSComment("Touch event tracking")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.351 -0500", hash_original_method = "3EB8DC396E0D228312A300339405C305", hash_generated_method = "06F1896A45565DE0EEB2186E14C17B70")
    
public void clear() {
        nativeClear(mPtr);
    }
    
    /**
     * Add a user's movement to the tracker.  You should call this for the
     * initial {@link MotionEvent#ACTION_DOWN}, the following
     * {@link MotionEvent#ACTION_MOVE} events that you receive, and the
     * final {@link MotionEvent#ACTION_UP}.  You can, however, call this
     * for whichever events you desire.
     * 
     * @param event The MotionEvent you received and would like to track.
     */
    @DSComment("Touch event tracking")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.356 -0500", hash_original_method = "47F4DCEEC62F25E97556D9BB3D79B1AA", hash_generated_method = "5DE818E3E8CB4728E4973FF1EEA10BAD")
    
public void addMovement(MotionEvent event) {
        if (event == null) {
            throw new IllegalArgumentException("event must not be null");
        }
        nativeAddMovement(mPtr, event);
    }

    /**
     * Equivalent to invoking {@link #computeCurrentVelocity(int, float)} with a maximum
     * velocity of Float.MAX_VALUE.
     * 
     * @see #computeCurrentVelocity(int, float) 
     */
    @DSComment("Touch event tracking")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.359 -0500", hash_original_method = "2C861C2E66E6C5ED5AC5356AA16D4AE7", hash_generated_method = "822CA4AF8508A5C0866EC9F8560F295B")
    
public void computeCurrentVelocity(int units) {
        nativeComputeCurrentVelocity(mPtr, units, Float.MAX_VALUE);
    }

    /**
     * Compute the current velocity based on the points that have been
     * collected.  Only call this when you actually want to retrieve velocity
     * information, as it is relatively expensive.  You can then retrieve
     * the velocity with {@link #getXVelocity()} and
     * {@link #getYVelocity()}.
     * 
     * @param units The units you would like the velocity in.  A value of 1
     * provides pixels per millisecond, 1000 provides pixels per second, etc.
     * @param maxVelocity The maximum velocity that can be computed by this method.
     * This value must be declared in the same unit as the units parameter. This value
     * must be positive.
     */
    @DSComment("Touch event tracking")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.361 -0500", hash_original_method = "AAC1E150F0714A1C0618591FDBA33AD9", hash_generated_method = "6B3A46916073D4ABA6A4E47C14ECD24E")
    
public void computeCurrentVelocity(int units, float maxVelocity) {
        nativeComputeCurrentVelocity(mPtr, units, maxVelocity);
    }
    
    /**
     * Retrieve the last computed X velocity.  You must first call
     * {@link #computeCurrentVelocity(int)} before calling this function.
     * 
     * @return The previously computed X velocity.
     */
    @DSComment("Touch event tracking")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.364 -0500", hash_original_method = "175B9FF596A60DD4A27A3E2F4F8FB36B", hash_generated_method = "94CCC2DA112CB63C65BA90B4DDA5148C")
    
public float getXVelocity() {
        return nativeGetXVelocity(mPtr, ACTIVE_POINTER_ID);
    }
    
    /**
     * Retrieve the last computed Y velocity.  You must first call
     * {@link #computeCurrentVelocity(int)} before calling this function.
     * 
     * @return The previously computed Y velocity.
     */
    @DSComment("Touch event tracking")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.366 -0500", hash_original_method = "7522D7DB1CC0324C793DB225FECF96EF", hash_generated_method = "80CFA04123F5CBED265101B2C2CBD499")
    
public float getYVelocity() {
        return nativeGetYVelocity(mPtr, ACTIVE_POINTER_ID);
    }
    
    /**
     * Retrieve the last computed X velocity.  You must first call
     * {@link #computeCurrentVelocity(int)} before calling this function.
     * 
     * @param id Which pointer's velocity to return.
     * @return The previously computed X velocity.
     */
    @DSComment("Touch event tracking")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.368 -0500", hash_original_method = "E88E46619158ECDA6CFC39862B1412B8", hash_generated_method = "B748F5D2BE8C4D50D5F5618A39676648")
    
public float getXVelocity(int id) {
        return nativeGetXVelocity(mPtr, id);
    }
    
    public static final class Estimator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.377 -0500", hash_original_field = "1727E1F87535EEC2DDCF786FF13901B9", hash_generated_field = "6B300D0F1610BC31482D34A0922264D0")

        private static final int MAX_DEGREE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.380 -0500", hash_original_field = "85848234A0235054B935D2CDDAB6E2E3", hash_generated_field = "DAF278AF332EC45DD2F6AAB0F51AC500")

        public final float[] xCoeff = new float[MAX_DEGREE + 1];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.382 -0500", hash_original_field = "D47E69F8C8F10AC734D764597A471184", hash_generated_field = "32F2BEFC622B3A8C2EFB2E54B5590144")

        public final float[] yCoeff = new float[MAX_DEGREE + 1];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.385 -0500", hash_original_field = "0B88736F7879D46C0C342CCC1CEE7864", hash_generated_field = "A21FC26B54D92E07E39E10EA3DEF93F3")

        public int degree;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.388 -0500", hash_original_field = "C66B10DF6D083DBF42205ACEC50147A2", hash_generated_field = "9300AFCF844D22EA28DB8E928CFE60EB")

        public float confidence;
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.286 -0400", hash_original_method = "3C04CD9D0E5CF8A244AF16BC346C84B6", hash_generated_method = "3C04CD9D0E5CF8A244AF16BC346C84B6")
        public Estimator ()
        {
            //Synthesized constructor
        }

        /**
         * Gets an estimate of the X position of the pointer at the specified time point.
         * @param time The time point in seconds, 0 is the last recorded time.
         * @return The estimated X coordinate.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.392 -0500", hash_original_method = "EF4145D98D5D09EB61112BFE6D9F064E", hash_generated_method = "AFF442A41B5EB089E4FCD76C4CDDE7F4")
        
public float estimateX(float time) {
            return estimate(time, xCoeff);
        }

        /**
         * Gets an estimate of the Y position of the pointer at the specified time point.
         * @param time The time point in seconds, 0 is the last recorded time.
         * @return The estimated Y coordinate.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.395 -0500", hash_original_method = "4B57BC9609218FF4FD5DA8FDF96C43D9", hash_generated_method = "3C0469096FC52EF9F5C968AFC3A90C3D")
        
public float estimateY(float time) {
            return estimate(time, yCoeff);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.397 -0500", hash_original_method = "17E8AE405780B4520E14D05EC083CF07", hash_generated_method = "C99359A31DBA1DF409DD1CC561819C32")
        
private float estimate(float time, float[] c) {
            float a = 0;
            float scale = 1;
            for (int i = 0; i <= degree; i++) {
                a += c[i] * scale;
                scale *= time;
            }
            return a;
        }
    }
    
    /**
     * Retrieve the last computed Y velocity.  You must first call
     * {@link #computeCurrentVelocity(int)} before calling this function.
     * 
     * @param id Which pointer's velocity to return.
     * @return The previously computed Y velocity.
     */
    @DSComment("Touch event tracking")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.370 -0500", hash_original_method = "3A1681E069274B63F81D41BA2ABBDF60", hash_generated_method = "E7C14CBE4FCD8C82AF134F1984CE7BE0")
    
public float getYVelocity(int id) {
        return nativeGetYVelocity(mPtr, id);
    }

    /**
     * Get an estimator for the movements of a pointer using past movements of the
     * pointer to predict future movements.
     *
     * It is not necessary to call {@link #computeCurrentVelocity(int)} before calling
     * this method.
     *
     * @param id Which pointer's velocity to return.
     * @param degree The desired polynomial degree.  The actual estimator may have
     * a lower degree than what is requested here.  If -1, uses the default degree.
     * @param horizonMillis The maximum age of the oldest sample to consider, in milliseconds.
     * If -1, uses the default horizon.
     * @param outEstimator The estimator to populate.
     * @return True if an estimator was obtained, false if there is no information
     * available about the pointer.
     *
     * @hide For internal use only.  Not a final API.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.373 -0500", hash_original_method = "53182452353A9C74BE3B46A3229E5647", hash_generated_method = "B0FE4BA81A88BF6288ADE7D0EA27F19A")
    
public boolean getEstimator(int id, int degree, int horizonMillis, Estimator outEstimator) {
        if (outEstimator == null) {
            throw new IllegalArgumentException("outEstimator must not be null");
        }
        return nativeGetEstimator(mPtr, id, degree, horizonMillis, outEstimator);
    }
    // orphaned legacy method
    public void onAcquired(VelocityTracker element) {
                }
    
    // orphaned legacy method
    public VelocityTracker newInstance() {
                    return new VelocityTracker();
                }
    
    // orphaned legacy method
    public void onReleased(VelocityTracker element) {
                    element.clear();
                }
    
}

