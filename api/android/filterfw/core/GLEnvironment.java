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


package android.filterfw.core;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.NativeAllocatorTag;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.media.MediaRecorder;

/**
 * @hide
 */
public class GLEnvironment {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.658 -0400", hash_original_method = "1FCEF7B108BFE391FB4BC8B6CECB7E8B", hash_generated_method = "E1A963699602D8A833F4C18A5C0A4196")
    
public static boolean isAnyContextActive() {
        return nativeIsAnyContextActive();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.460 -0400", hash_original_method = "7E165335DF678FE191719A49D7F5E9E3", hash_generated_method = "C8D3034C9C23B502815A4D20602D820B")
    
    private static boolean nativeIsAnyContextActive(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }





@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.638 -0400", hash_original_field = "5312F3B11B036D51457E62D19332CB5B", hash_generated_field = "836AF212C39306A6DE9B2DAD8EABBB66")


    private int glEnvId;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.640 -0400", hash_original_method = "6BF09C2B2AC02D6ACF79B3F082CF910E", hash_generated_method = "4F784C38633A25CFD964176E01A19EE7")
    
public GLEnvironment() {
        nativeAllocate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.643 -0400", hash_original_method = "E774A0245A01F31414BEAF92CE237DA7", hash_generated_method = "7BCB47B1B6AC6FE44B5288A5D22767AB")
    
private GLEnvironment(NativeAllocatorTag tag) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.645 -0400", hash_original_method = "4A98176CF70A46DE3389A04080AC575A", hash_generated_method = "22C56FC8AE7AFC2D1B778B2D214733F3")
    
public synchronized void tearDown() {
        if (glEnvId != -1) {
            nativeDeallocate();
            glEnvId = -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.647 -0400", hash_original_method = "1634EBECADA1FE321270115B4A33248F", hash_generated_method = "089C66A5C5C16B1989FEE832F678C8A4")
    
@Override
    protected void finalize() throws Throwable {
        tearDown();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.649 -0400", hash_original_method = "DBA4311C8BEB49D7625023654ECB2564", hash_generated_method = "8D4662FEF5D3754F53EE2B20797AB1B8")
    
public void initWithNewContext() {
        if (!nativeInitWithNewContext()) {
            throw new RuntimeException("Could not initialize GLEnvironment with new context!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.652 -0400", hash_original_method = "3F714784F6FDFF8E7C79ED5E256A0C8A", hash_generated_method = "4C6BE2E9C2E2B805CBA2665ADD862F45")
    
public void initWithCurrentContext() {
        if (!nativeInitWithCurrentContext()) {
            throw new RuntimeException("Could not initialize GLEnvironment with current context!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.654 -0400", hash_original_method = "40F70B43CD990D8E6F924BC24492C478", hash_generated_method = "B0A10BFE6A63D2F15EE137148AB5C02F")
    
public boolean isActive() {
        return nativeIsActive();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.656 -0400", hash_original_method = "B5821792B1F6CD5CA372390DBC83BF8E", hash_generated_method = "58300013EE6F04F87D68226F763DE65B")
    
public boolean isContextActive() {
        return nativeIsContextActive();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.660 -0400", hash_original_method = "A75F1E6FFBEB73935A107A83CA349540", hash_generated_method = "992E30CC12DF036F812E2ABEF6838BE0")
    
public void activate() {
        if (Looper.myLooper() != null && Looper.myLooper().equals(Looper.getMainLooper())) {
            Log.e("FilterFramework", "Activating GL context in UI thread!");
        }
        if (!nativeActivate()) {
            throw new RuntimeException("Could not activate GLEnvironment!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.662 -0400", hash_original_method = "EF0BD8149FED207AD95DDA9C650C9AB0", hash_generated_method = "5A11A2E13D75B85A67EF5ADBA24A6324")
    
public void deactivate() {
        if (!nativeDeactivate()) {
            throw new RuntimeException("Could not deactivate GLEnvironment!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.665 -0400", hash_original_method = "7B09BC2FD30599B151E2E77BC2B45EF3", hash_generated_method = "A58AB82996C45A6E33A865530A2386D1")
    
public void swapBuffers() {
        if (!nativeSwapBuffers()) {
            throw new RuntimeException("Error swapping EGL buffers!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.667 -0400", hash_original_method = "9FDDB1F16B4D13C2E81D7BBDB2FF76CB", hash_generated_method = "BE2A2C7A984F84D513380D1F8ADCE32A")
    
public int registerSurface(Surface surface) {
        int result = nativeAddSurface(surface);
        if (result < 0) {
            throw new RuntimeException("Error registering surface " + surface + "!");
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.669 -0400", hash_original_method = "E4EAF0AE202932A17B9153690990AB13", hash_generated_method = "C1114146EC0C79F4D3DDFB44C0B62638")
    
public int registerSurfaceTexture(SurfaceTexture surfaceTexture, int width, int height) {
        int result = nativeAddSurfaceTexture(surfaceTexture, width, height);
        if (result < 0) {
            throw new RuntimeException("Error registering surfaceTexture " + surfaceTexture + "!");
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.672 -0400", hash_original_method = "370EF558D086DB46FA01A76C72C10B50", hash_generated_method = "311421589503D60B7AC78A83BAA187F5")
    
public int registerSurfaceFromMediaRecorder(MediaRecorder mediaRecorder) {
        int result = nativeAddSurfaceFromMediaRecorder(mediaRecorder);
        if (result < 0) {
            throw new RuntimeException("Error registering surface from "
                                    + "MediaRecorder" + mediaRecorder + "!");
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.674 -0400", hash_original_method = "A155702CFF453083CA4E74B28A861912", hash_generated_method = "490901797E489517A3CC0162B5184180")
    
public void activateSurfaceWithId(int surfaceId) {
        if (!nativeActivateSurfaceId(surfaceId)) {
            throw new RuntimeException("Could not activate surface " + surfaceId + "!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.676 -0400", hash_original_method = "82E691F8E1D7DAE4DF603DCFDF093301", hash_generated_method = "0BBA7A11314FCAE9575192A3457CFFFF")
    
public void unregisterSurfaceId(int surfaceId) {
        if (!nativeRemoveSurfaceId(surfaceId)) {
            throw new RuntimeException("Could not unregister surface " + surfaceId + "!");
        }
    }

    static {
        System.loadLibrary("filterfw");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.678 -0400", hash_original_method = "0860545AC6501C695E7D8AD77E72C93F", hash_generated_method = "58CA36A839B399077D90C6EA5FCF2F6C")
    
public void setSurfaceTimestamp(long timestamp) {
        if (!nativeSetSurfaceTimestamp(timestamp)) {
            throw new RuntimeException("Could not set timestamp for current surface!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.449 -0400", hash_original_method = "164BA1662464D454FF905E81D8586F92", hash_generated_method = "D7C7AC933FE6150680313167A707F79A")
    
    private boolean nativeInitWithNewContext(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.452 -0400", hash_original_method = "27823144E2C3DC027BFB63BA7141BEFA", hash_generated_method = "EEFDAFBA818C390091ACBD91000F6F65")
    
    private boolean nativeInitWithCurrentContext(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.455 -0400", hash_original_method = "8F19BBE56160A05D8AABF421C6AE0D71", hash_generated_method = "99ED90BA556BACB91A59E41431E03057")
    
    private boolean nativeIsActive(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.457 -0400", hash_original_method = "429D16685BCAC565C484E3FE04151D47", hash_generated_method = "C2D2A3DA3AC8F95A0ABD0B8E813C447E")
    
    private boolean nativeIsContextActive(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.463 -0400", hash_original_method = "57D25A50BBF10FA53BB44C7D6DF9FC93", hash_generated_method = "1F9B755D93F5F98E49C7FA9AE1BFF840")
    
    private boolean nativeActivate(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.466 -0400", hash_original_method = "E698B26A12BBCE8DC563A41F7DDD333D", hash_generated_method = "87B74D5717ED71A95C08BA91E285589E")
    
    private boolean nativeDeactivate(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.469 -0400", hash_original_method = "1EF329BDA254D0F92DB2285897276B31", hash_generated_method = "24322855273E2A735603C3B7A3428FD0")
    
    private boolean nativeSwapBuffers(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.471 -0400", hash_original_method = "6301909CA2626FBD0F9D5CE1EA448C05", hash_generated_method = "BCA8B32BD11B1B2D2C036C109DB889BF")
    
    private boolean nativeAllocate(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:42.474 -0400", hash_original_method = "C5D13A7D2DE40061D17A5A19349F9B46", hash_generated_method = "B240A7932BE0CB51D42FA1BDE6059C94")
    
    private boolean nativeDeallocate(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }




    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.182 -0400", hash_original_method = "6B6DE041197588F0ED616D34566A1756", hash_generated_method = "D11BD7811306F9B16B5680082CCC3231")
    
    private int nativeAddSurface(Surface surface){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += surface.getTaintInt();
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.186 -0400", hash_original_method = "63EB4D7192027BD0A7824E00CCA4B45F", hash_generated_method = "1F59E75B993DF69C9160B91A280A9582")
    
    private int nativeAddSurfaceTexture(SurfaceTexture surface, int width, int height){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += surface.getTaintInt();
    	taintDouble += width;
    	taintDouble += height;
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.191 -0400", hash_original_method = "3B3AC83D0E7A1374F6DBFF6D280A1EF2", hash_generated_method = "C16D8CA5E8CBFB8B55005FA575944903")
    
    private int nativeAddSurfaceFromMediaRecorder(MediaRecorder mediaRecorder){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += mediaRecorder.getTaintInt();
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.195 -0400", hash_original_method = "87A12BA53060BB423546F41F38880C6B", hash_generated_method = "4DCCC2DE7133EC84EF8A5A7ACAE7D6F9")
    
    private boolean  nativeDisconnectSurfaceMediaSource(MediaRecorder mediaRecorder){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += mediaRecorder.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.198 -0400", hash_original_method = "5F17AFC2D1F31F7702F1B3326F4F54F4", hash_generated_method = "B1734C22791173017A02857BF102618F")
    
    private boolean nativeActivateSurfaceId(int surfaceId){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += surfaceId;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.202 -0400", hash_original_method = "B15325895F651CA9C5F158C2C8B63A15", hash_generated_method = "3D2FF8D4E55475985C4C2DA8C30A29D0")
    
    private boolean nativeRemoveSurfaceId(int surfaceId){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += surfaceId;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:20.206 -0400", hash_original_method = "660A7742E0B8992B12FFDC85C87113E3", hash_generated_method = "70CBB6019EB959FA49DDC6E9145D0842")
    
    private boolean nativeSetSurfaceTimestamp(long timestamp){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += timestamp;
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }



}
