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
 * Copyright (C) 2007 The Android Open Source Project
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


package android.graphics;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class PathMeasure {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.998 -0400", hash_original_field = "8217D7F8B3D74FF153486AC0FF0C52EB", hash_generated_field = "179467EFDFE8CDC00B1E8371BDDAD764")

    public static final int POSITION_MATRIX_FLAG = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.001 -0400", hash_original_field = "A32FBAD8012EFAFCC7FAABEF5D30F103", hash_generated_field = "9B771BE80F1A50B2BEBD8811894ACEFF")

    public static final int TANGENT_MATRIX_FLAG  = 0x02;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.012 -0400", hash_original_method = "BA4D5814F4D332C7DE43192A381B12D3", hash_generated_method = "DF06C47B76E499055DD03BA5032B2303")
    
    private static int native_create(int native_path, boolean forceClosed){
    	//Formerly a native method
        return (native_path + ((forceClosed) ? 1 : 0));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.014 -0400", hash_original_method = "567E9E159700565C09C389ECA22B6620", hash_generated_method = "779F001808F5A8EDC28D079AC509A17E")
    
    private static void native_setPath(int native_instance, int native_path, boolean forceClosed){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.017 -0400", hash_original_method = "BF1F3D6A5F98F7A00AD5AEBAD37CD524", hash_generated_method = "F46E2473E95DE6887BA6425B0E745A33")
    
    private static float native_getLength(int native_instance){
    	//Formerly a native method
    	return native_instance;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.020 -0400", hash_original_method = "333B9E524D097F55376C9690776BF663", hash_generated_method = "78BF3FFDAD98195FA8AD26B5B912D3E5")
    
    private static boolean native_getPosTan(int native_instance, float distance, float pos[], float tan[]){
    	//Formerly a native method
        return ((native_instance + distance + pos[0] + tan[0]) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.023 -0400", hash_original_method = "F51A0D8AADC796054F42D603742F12F1", hash_generated_method = "2FE63BAAFFEC9E512F3FEF698240D51A")
    
    private static boolean native_getMatrix(int native_instance, float distance, int native_matrix, int flags){
    	//Formerly a native method
        return ((native_instance + distance + native_matrix + flags) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.025 -0400", hash_original_method = "0F1EE4FA6598637D7ED506721C795C20", hash_generated_method = "B36C3BEA24F9CA069FD47424F517C08B")
    
    private static boolean native_getSegment(int native_instance, float startD, float stopD, int native_path, boolean startWithMoveTo){
    	//Formerly a native method
        return 1 == (native_instance + startD + stopD + native_path + 
                       ((startWithMoveTo) ? 1 : 0));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.028 -0400", hash_original_method = "6BD382F6E956A4FF1CD0495566393FDA", hash_generated_method = "2DA8CC997D225862B165A05DDD4669A7")
    
    private static boolean native_isClosed(int native_instance){
    	//Formerly a native method
    	return ((native_instance) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.030 -0400", hash_original_method = "259080968E75270D13A075C89664E7AA", hash_generated_method = "A1F67F85B1CFADD4380AC2F672C1C68D")
    
    private static boolean native_nextContour(int native_instance){
    	//Formerly a native method
    	return ((native_instance) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.040 -0400", hash_original_method = "B81DF364C933ABCAE1ADD3F423CD055D", hash_generated_method = "3B048B55832076F266ED1A96019CB853")
    
    private static void native_destroy(int native_instance){
    	//Formerly a native method
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.042 -0400", hash_original_field = "1353DF0D3FEF59358BA81F3F4AC59875", hash_generated_field = "7F8F576E4626C874BE9FCD8FF3DA7FA2")
private  int native_instance;

    /**
     * Create an empty PathMeasure object. To uses this to measure the length
     * of a path, and/or to find the position and tangent along it, call
     * setPath.
     *
     * Note that once a path is associated with the measure object, it is
     * undefined if the path is subsequently modified and the the measure object
     * is used. If the path is modified, you must call setPath with the path.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.988 -0400", hash_original_method = "7252BD32CC7657429DF8A7A188F08933", hash_generated_method = "3461AC50EF0367A9F1F25629F9750BDB")
    
public PathMeasure() {
        native_instance = native_create(0, false);
    }
    
    /**
     * Create a PathMeasure object associated with the specified path object
     * (already created and specified). The meansure object can now return the
     * path's length, and the position and tangent of any position along the
     * path.
     *
     * Note that once a path is associated with the measure object, it is
     * undefined if the path is subsequently modified and the the measure object
     * is used. If the path is modified, you must call setPath with the path.
     *
     * @param path The path that will be measured by this object
     * @param forceClosed If true, then the path will be considered as "closed"
     *        even if its contour was not explicitly closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.991 -0400", hash_original_method = "E46B1D208664A69A4587743EEBDE80DC", hash_generated_method = "A2BE8DA1762F86442F74EF349B36F531")
    
public PathMeasure(Path path, boolean forceClosed) {
        // note: the native side makes a copy of path, so we don't need a java
        // reference to it here, since it's fine if it gets GC'd
        native_instance = native_create(path != null ? path.ni() : 0,
                                        forceClosed);
    }

    /**
     * Assign a new path, or null to have none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.993 -0400", hash_original_method = "DE56CC51EB0433AEE24CF0AE5345795D", hash_generated_method = "E6E50228C4A4FB2072F744E1AB6903F4")
    
public void setPath(Path path, boolean forceClosed) {
        // note: the native side makes a copy of path, so we don't need a java
        // reference to it here, since it's fine if it gets GC'd
        native_setPath(native_instance,
                       path != null ? path.ni() : 0,
                       forceClosed);
    }

    /**
     * Return the total length of the current contour, or 0 if no path is
     * associated with this measure object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.994 -0400", hash_original_method = "F16299977FD1E2A978EBAB4C85B92D0E", hash_generated_method = "85267F7023128E6D8FC7871ED8AF5ED2")
    
public float getLength() {
        return native_getLength(native_instance);
    }

    /**
     * Pins distance to 0 <= distance <= getLength(), and then computes the
     * corresponding position and tangent. Returns false if there is no path,
     * or a zero-length path was specified, in which case position and tangent
     * are unchanged.
     *
     * @param distance The distance along the current contour to sample
     * @param pos If not null, eturns the sampled position (x==[0], y==[1])
     * @param tan If not null, returns the sampled tangent (x==[0], y==[1])
     * @return false if there was no path associated with this measure object
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.996 -0400", hash_original_method = "B25EBCDDAAB11BE4042AFB155C4100B9", hash_generated_method = "9149F94D1B77B29882E2B090D2360680")
    
public boolean getPosTan(float distance, float pos[], float tan[]) {
        if (pos != null && pos.length < 2 ||
            tan != null && tan.length < 2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return native_getPosTan(native_instance, distance, pos, tan);
    }    // must match flags in SkPathMeasure.h

    /**
     * Pins distance to 0 <= distance <= getLength(), and then computes the
     * corresponding matrix. Returns false if there is no path, or a zero-length
     * path was specified, in which case matrix is unchanged.
     *
     * @param distance The distance along the associated path
     * @param matrix Allocated by the caller, this is set to the transformation
     *        associated with the position and tangent at the specified distance
     * @param flags Specified what aspects should be returned in the matrix.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.003 -0400", hash_original_method = "37688AB1A34E8D9276F840C9C192965E", hash_generated_method = "74B8EB7A68AE9F00881B03835E5EB45A")
    
public boolean getMatrix(float distance, Matrix matrix, int flags) {
        return native_getMatrix(native_instance, distance, matrix.native_instance, flags);
    }

    /**
     * Given a start and stop distance, return in dst the intervening
     * segment(s). If the segment is zero-length, return false, else return
     * true. startD and stopD are pinned to legal values (0..getLength()).
     * If startD <= stopD then return false (and leave dst untouched).
     * Begin the segment with a moveTo if startWithMoveTo is true
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.005 -0400", hash_original_method = "35FF9015899CD5F7C111B0AC1C5E06D5", hash_generated_method = "993EB40C67DB96AD5A1B5B3D678A03F7")
    
public boolean getSegment(float startD, float stopD, Path dst, boolean startWithMoveTo) {
        return native_getSegment(native_instance, startD, stopD, dst.ni(), startWithMoveTo);
    }

    /**
     * Return true if the current contour is closed()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.006 -0400", hash_original_method = "C5A3BD94A9750CCBAE0B009F3C4F54AC", hash_generated_method = "5CC9DDB97EABA13B9A08D78CA70828BE")
    
public boolean isClosed() {
        return native_isClosed(native_instance);
    }

    /**
     * Move to the next contour in the path. Return true if one exists, or
     * false if we're done with the path.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.008 -0400", hash_original_method = "1945ADB794EAD87742B5282BF8E2C1B9", hash_generated_method = "2173CD235B6FA70D71088252B6164B07")
    
public boolean nextContour() {
        return native_nextContour(native_instance);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.009 -0400", hash_original_method = "DBBBAD6E9BAAD633272A45BC2D13EFB0", hash_generated_method = "65E92602EF069C56D03620CB6E8DC9E6")
    
protected void finalize() throws Throwable {
        native_destroy(native_instance);
    }
}

