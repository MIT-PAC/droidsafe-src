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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.hardware;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Sensor {
    public static final int TYPE_ACCELEROMETER = 1;
    public static final int TYPE_MAGNETIC_FIELD = 2;
    public static final int TYPE_GYROSCOPE = 4;
    public static final int TYPE_LIGHT = 5;
    public static final int TYPE_PRESSURE = 6;
    public static final int TYPE_PROXIMITY = 8;
    public static final int TYPE_GRAVITY = 9;
    public static final int TYPE_LINEAR_ACCELERATION = 10;
    public static final int TYPE_ROTATION_VECTOR = 11;
    public static final int TYPE_RELATIVE_HUMIDITY = 12;
    public static final int TYPE_AMBIENT_TEMPERATURE = 13;
    public static final int TYPE_ALL = -1;
    
    @Deprecated
    public static final int TYPE_TEMPERATURE = 7;
    @Deprecated
    public static final int TYPE_ORIENTATION = 3;

    private String  mName;
    private String  mVendor;
    private int     mVersion;
    private int     mHandle;
    private int     mType;
    private float   mMaxRange;
    private float   mResolution;
    private float   mPower;
    private int     mMinDelay;
    private int     mLegacyType;
    
    // GITI DSModeled - not original to Sensor.java, added to track the type of sensor
    // requested by the application (via SensorManager.java)
    @DSModeled(DSC.BAN)
    public Sensor(int type) {
    	addTaint(type);
    }

    // GITI DSModeled
    @DSModeled(DSC.SAFE)
    Sensor() {
    }

    // GITI DSModeled - just returning a string
    @DSModeled(DSC.SAFE)
    public String getName() {
        String str = new String();
        str.addTaint(getTaint());
        return str;
        //return mName;
    }

    // GITI DSModeled - just returning a string 
    @DSModeled(DSC.SAFE)
    public String getVendor() {
        String str = new String();
        str.addTaint(getTaint());
        return str;
        //return mVendor;
    }

    // GITI DSModeled - just returning an int
    @DSModeled(DSC.SAFE)
    public int getType() {
    	return getTaintInt();
        //return mType;
    }

    // GITI DSModeled - just returning an int
    @DSModeled(DSC.SAFE)
    public int getVersion() {
    	return getTaintInt();
        //return mVersion;
    }

    // GITI DSModeled - just returning a float
    @DSModeled(DSC.SAFE)
    public float getMaximumRange() {
    	return getTaintFloat();
        //return mMaxRange;
    }

    // GITI DSModeled - just returning a float
    @DSModeled(DSC.SAFE)
    public float getResolution() {
    	return getTaintInt();
        //return mResolution;
    }

    // GITI DSModeled - just returning a float
    @DSModeled(DSC.SAFE)
    public float getPower() {
    	return getTaintFloat();
        //return mPower;
    }

    // GITI DSModeled - just returning an int
    @DSModeled(DSC.SAFE)
    public int getMinDelay() {
    	return getTaintInt();
        //return mMinDelay;
    }

    int getHandle() {
    	return getTaintInt();
        //return mHandle;
    }

    void setRange(float max, float res) {
    	addTaint(max);
    	addTaint(res);
    }

    void setLegacyType(int legacyType) {
    	addTaint(legacyType);
    }

    int getLegacyType() {
    	return getTaintInt();
        //return mLegacyType;
    }
}
