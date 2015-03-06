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
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Point implements Parcelable {
    
    public int x;
    public int y;
    
    public Point(){
    }
    
    @DSModeled(DSC.SAFE)
    public Point(int x, int y){
        addTaint(x);
        addTaint(y);
    }
    
    @DSModeled(DSC.SAFE)
    public Point(Point src){
        addTaint(src.getTaint());
        /*
        this.x = src.x;
        this.y = src.y;
        */
    }
    
    @DSModeled(DSC.SAFE)
    public void set(int x, int y){
        addTaint(x);
        addTaint(y);
        // Original method
        /*
        {
        this.x = x;
        this.y = y;
    }
        */
    }
    
    @DSModeled(DSC.SAFE)
    public final void negate(){
        addTaint(x);
        addTaint(y);
    }
    
    public final void offset(int dx, int dy){
        x += dx;
        y += dy;
        // Original method
        /*
        {
        x += dx;
        y += dy;
    }
        */
    }
    
    public final boolean equals(int x, int y){
        return getTaintBoolean();

        // Original method
        /*
        {
        return this.x == x && this.y == y;
    }
        */
    }
    
    @Override public boolean equals(Object o){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Point p = (Point) o;
        return getTaintBoolean();

        // Original method
        /*
        {
        if (o instanceof Point) {
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }
        return false;
    }
        */
    }
    
    @Override public int hashCode(){
        return getTaintInt();

        // Original method
        /*
        {
        return x * 32713 + y;
    }
        */
    }
    
    @Override public String toString(){
        String str = new String();
        str.addTaint(getTaint());
        return str;

        // Original method
        /*
        {
        return "Point(" + x + ", " + y+ ")";
    }
        */
    }
    
    @Override public int describeContents(){
        return getTaintInt();

        // Original method
        /*
        {
        return 0;
    }
        */
    }
    
    @Override public void writeToParcel(Parcel out, int flags){
        out.writeInt(x);
        out.writeInt(y);
        // Original method
        /*
        {
        out.writeInt(x);
        out.writeInt(y);
    }
        */
    }
    public static final Parcelable.Creator<Point> CREATOR = new Parcelable.Creator<Point>() {
        
        public Point createFromParcel(Parcel in) {
            Point r = new Point();
            r.readFromParcel(in);
            return r;
        }

        
        public Point[] newArray(int size) {
            return new Point[size];
        }
    };
    
    public void readFromParcel(Parcel in){
        // Original method
        /*
        {
        x = in.readInt();
        y = in.readInt();
    }
        */
    }
}

