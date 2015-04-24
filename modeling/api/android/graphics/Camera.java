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


package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Camera {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.200 -0500", hash_original_field = "1353DF0D3FEF59358BA81F3F4AC59875", hash_generated_field = "1353DF0D3FEF59358BA81F3F4AC59875")
    
    int native_instance;
    /**
     * Creates a new camera, with empty transformations.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.144 -0500", hash_original_method = "6DBF72AF7766D4EB810EDB03D8391F19", hash_generated_method = "685553C2A5173BA484ADB3CA6336847B")
    
public Camera() {
        nativeConstructor();
    }

    /**
     * Saves the camera state. Each save should be balanced
     * with a call to {@link #restore()}.
     * 
     * @see #save() 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.148 -0500", hash_original_method = "5DCA6946AC737E3FB2C77FDB7C22A4F6", hash_generated_method = "A28BB64ABF7361887AC1B01EFBA07371")
    
    public void save(){
    	//Formerly a native method
    }

    /**
     * Restores the saved state, if any.
     * 
     * @see #restore() 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.152 -0500", hash_original_method = "54E49D501AAC4DB03DE41A5BADEC9468", hash_generated_method = "3E4EB86BA18ABDA53E16A5B357F4B743")
    
    public void restore(){
    	//Formerly a native method
    }

    /**
     * Applies a translation transform on all three axis.
     * 
     * @param x The distance to translate by on the X axis
     * @param y The distance to translate by on the Y axis
     * @param z The distance to translate by on the Z axis
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.156 -0500", hash_original_method = "C7A05AF6A5D2D21D6919D5ED21917266", hash_generated_method = "547CB286ADA112686071CC71595FDC63")
    
    public void translate(float x, float y, float z){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    	addTaint(z);
    }

    /**
     * Applies a rotation transform around the X axis.
     * 
     * @param deg The angle of rotation around the X axis, in degrees
     * 
     * @see #rotateY(float)
     * @see #rotateZ(float)
     * @see #rotate(float, float, float)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.159 -0500", hash_original_method = "70760D1E35F31209F549560E00AD3199", hash_generated_method = "E3D2C99D518F19A180633059B3BB5FD0")
    
    public void rotateX(float deg){
    	//Formerly a native method
    	addTaint(deg);
    }

    /**
     * Applies a rotation transform around the Y axis.
     * 
     * @param deg The angle of rotation around the Y axis, in degrees
     * 
     * @see #rotateX(float)
     * @see #rotateZ(float)
     * @see #rotate(float, float, float) 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.163 -0500", hash_original_method = "05F48791182D352B4D8C184739DC2F5C", hash_generated_method = "21998CBB0B6AA96FDA348ABF97908948")
    
    public void rotateY(float deg){
    	//Formerly a native method
    	addTaint(deg);
    }

    /**
     * Applies a rotation transform around the Z axis.
     * 
     * @param deg The angle of rotation around the Z axis, in degrees
     * 
     * @see #rotateX(float)
     * @see #rotateY(float)
     * @see #rotate(float, float, float)
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.166 -0500", hash_original_method = "3974450583A9023F24B778633D301E40", hash_generated_method = "7AFD4FCB838EC4FF242FA38F36F5CAD1")
    
    public void rotateZ(float deg){
    	//Formerly a native method
    	addTaint(deg);
    }

    /**
     * Applies a rotation transform around all three axis.
     * 
     * @param x The angle of rotation around the X axis, in degrees
     * @param y The angle of rotation around the Y axis, in degrees
     * @param z The angle of rotation around the Z axis, in degrees
     * 
     * @see #rotateX(float)
     * @see #rotateY(float)
     * @see #rotateZ(float)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.170 -0500", hash_original_method = "A07D6B0AFBCC00CEA34DA7A028A542EA", hash_generated_method = "F7AAA2725238842B4BAAE8F843C26F96")
    
    public void rotate(float x, float y, float z){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    	addTaint(z);
    }

    /**
     * Sets the location of the camera. The default location is set at
     * 0, 0, -8.
     * 
     * @param x The x location of the camera
     * @param y The y location of the camera
     * @param z The z location of the camera
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.173 -0500", hash_original_method = "46E0BCB01C5C707B28964C24224D27BF", hash_generated_method = "6082F441CD8E4205792F7699FC8475C6")
    
    public void setLocation(float x, float y, float z){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    	addTaint(z);
    }

    /**
     * Computes the matrix corresponding to the current transformation
     * and copies it to the supplied matrix object.
     * 
     * @param matrix The matrix to copy the current transforms into
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.176 -0500", hash_original_method = "EEC65A3D99E4715BBC5254EBE009F300", hash_generated_method = "90A3153B8C1F07C2E6E7AC8153A377AF")
    
public void getMatrix(Matrix matrix) {
        nativeGetMatrix(matrix.getTaintInt());
    }

    /**
     * Computes the matrix corresponding to the current transformation
     * and applies it to the specified Canvas.
     * 
     * @param canvas The Canvas to set the transform matrix onto
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.178 -0500", hash_original_method = "E58BA8CAEF8D98DCBC5CC423229EB1CE", hash_generated_method = "C4DEA4890144CDDF0582D0EE99D802DA")
    
public void applyToCanvas(Canvas canvas) {
        nativeApplyToCanvas(canvas.mNativeCanvas);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.182 -0500", hash_original_method = "99C03287B9838C14044E9B6E324762A8", hash_generated_method = "87B7083208890A401B0EFF05CB87EA8B")
    
    public float dotWithNormal(float dx, float dy, float dz){
    	//Formerly a native method
    	addTaint(dx);
    	addTaint(dy);
    	addTaint(dz);
    	return getTaintFloat();
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.184 -0500", hash_original_method = "C90BA6E6D8C2FEFD061454BA6E7AF7E1", hash_generated_method = "8A85EA8E6B128F46007DF31045FAB50E")
    
protected void finalize() throws Throwable {
        try {
            nativeDestructor();
        } finally {
            super.finalize();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.187 -0500", hash_original_method = "CB9D9CAF93B6F7C6AC078700B30D5B3A", hash_generated_method = "6EEF3712392D06942F0E7086316BBAB4")
    
    private void nativeConstructor(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.191 -0500", hash_original_method = "28277D643642440FCD7626A94746E337", hash_generated_method = "51EEE50DA274E26FEE517B8295242BAC")
    
    private void nativeDestructor(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.194 -0500", hash_original_method = "8D274BB0506DF92F70FF4552532F47BF", hash_generated_method = "AA83036AF7865EB6ED4CCFECFB9241B5")
    
    private void nativeGetMatrix(int native_matrix){
    	//Formerly a native method
    	addTaint(native_matrix);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.198 -0500", hash_original_method = "969BE384F55540A8E1C5E65A0255064C", hash_generated_method = "A5CAD42A5D0B728F6A4749AB0F69A49E")
    
    private void nativeApplyToCanvas(int native_canvas){
    	//Formerly a native method
    	addTaint(native_canvas);
    }
    
}

