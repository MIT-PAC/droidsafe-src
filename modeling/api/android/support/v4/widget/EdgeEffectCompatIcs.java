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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

class EdgeEffectCompatIcs {
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.517 -0500", hash_original_method = "FE7C168140AD8ADACBA678C699C8B9C7", hash_generated_method = "D8D640B8513DF2E8A431C37EFC64193F")
    
public static Object newEdgeEffect(Context context) {
        return new EdgeEffect(context);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.520 -0500", hash_original_method = "59C32030E05BAB886BB1775F9282077E", hash_generated_method = "33C28CB498571CAC039E443BF30DEBD1")
    
public static void setSize(Object edgeEffect, int width, int height) {
        ((EdgeEffect) edgeEffect).setSize(width, height);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.522 -0500", hash_original_method = "593982B6EBA2858C21D1C7DB5657CA5F", hash_generated_method = "F55B0054671038E500DC177359CB4002")
    
public static boolean isFinished(Object edgeEffect) {
        return ((EdgeEffect) edgeEffect).isFinished();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.524 -0500", hash_original_method = "67DCA11131BB651E8B9035A1E2D374BF", hash_generated_method = "C267026372C02E0FE3F115F370D3FB81")
    
public static void finish(Object edgeEffect) {
        ((EdgeEffect) edgeEffect).finish();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.527 -0500", hash_original_method = "D8A704C631ABBF332EFC414F49B4F211", hash_generated_method = "9213EC7E44B1A71186929529271EA904")
    
public static boolean onPull(Object edgeEffect, float deltaDistance) {
        ((EdgeEffect) edgeEffect).onPull(deltaDistance);
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.529 -0500", hash_original_method = "0554A32293E389373C87B8B19B4178BA", hash_generated_method = "757052350093C9589C97625899739E98")
    
public static boolean onRelease(Object edgeEffect) {
        EdgeEffect eff = (EdgeEffect) edgeEffect;
        eff.onRelease();
        return eff.isFinished();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.532 -0500", hash_original_method = "150888D8CD2DB43A6623CDAEA5B53984", hash_generated_method = "BD454813A85ECDBB85CB0A7DF8AF5CD9")
    
public static boolean onAbsorb(Object edgeEffect, int velocity) {
        ((EdgeEffect) edgeEffect).onAbsorb(velocity);
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.534 -0500", hash_original_method = "917C0F261B66C71B220A35B7D36865A6", hash_generated_method = "1C8AB009284C2C2DF0B7335292981B66")
    
public static boolean draw(Object edgeEffect, Canvas canvas) {
        return ((EdgeEffect) edgeEffect).draw(canvas);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.027 -0400", hash_original_method = "2ED7C9E04D60E9925816E3B452B1FB7F", hash_generated_method = "2ED7C9E04D60E9925816E3B452B1FB7F")
    public EdgeEffectCompatIcs ()
    {
        //Synthesized constructor
    }
    
}

