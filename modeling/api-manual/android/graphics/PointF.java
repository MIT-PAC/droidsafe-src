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

// Droidsafe Imports
import android.os.Parcel;
import android.os.Parcelable;
import android.util.FloatMath;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class PointF implements Parcelable {
    
    public float x;
    public float y;
    
    @DSModeled(DSC.SAFE)
    public PointF(){
    }
    
    @DSModeled(DSC.SAFE)
    public PointF(float x, float y){
        addTaint(x);
        addTaint(y);
    }
    
    @DSModeled(DSC.SAFE)
    public PointF(Point p){
        addTaint(p.getTaint());
        /*
        this.x = p.x;
        this.y = p.y;
        */
    }
    
    @DSModeled(DSC.SAFE)
    public final void set(float x, float y){
        addTaint(x);
        addTaint(y);
    }
    
    
    @DSModeled(DSC.SAFE)
    public final void set(PointF p){
        addTaint(p.getTaint());
    }
    
    @DSModeled(DSC.SAFE)
    public final void negate(){
        addTaint(x);
        addTaint(y);
    }
    
    @DSModeled(DSC.SAFE)
    public final void offset(float dx, float dy){
        addTaint(dx);
        addTaint(dy);
    }
    
    public final boolean equals(float x, float y){
        return getTaintBoolean();

        // Original method
        /*
        { 
        return this.x == x && this.y == y; 
    }
        */
    }
    
    public final float length(){
        return getTaintFloat();

        // Original method
        /*
        { 
        return length(x, y); 
    }
        */
    }
    
    public static float length(float x, float y) {
        return FloatMath.sqrt(x * x + y * y);
    }
    
    @Override public int describeContents(){
        return getTaintInt();
    }
    
    @Override public void writeToParcel(Parcel out, int flags){
        out.writeFloat(x);
        out.writeFloat(y);
    }
    
    /*
    public static final Parcelable.Creator<PointF> CREATOR = new Parcelable.Creator<PointF>() {
        public PointF createFromParcel(Parcel in) {
            PointF r = new PointF();
            r.readFromParcel(in);
            return r;
        }

        public PointF[] newArray(int size) {
            return new PointF[size];
        }
    };
    */
    
    
    public void readFromParcel(Parcel in){
        // Original method
        /*
        {
        x = in.readFloat();
        y = in.readFloat();
    }
        */
    }
}

