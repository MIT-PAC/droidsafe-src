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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.gesture;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A gesture is a hand-drawn shape on a touch screen. It can have one or multiple strokes.
 * Each stroke is a sequence of timed points. A user-defined gesture can be recognized by 
 * a GestureLibrary. 
 */

public class Gesture implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.241 -0500", hash_original_field = "F915CC298AD42E0F5465EB17F3ADBEC5", hash_generated_field = "51F4C1013E6DDBA5A4ED71B36C0D9F8E")

    private static final long GESTURE_ID_BASE = System.currentTimeMillis();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.252 -0500", hash_original_field = "7C779589A1410DE8DA8E8EABAC4F93CC", hash_generated_field = "90C0408E8A5AB402B75AAA3B303237D0")

    private static final int BITMAP_RENDERING_WIDTH = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.260 -0500", hash_original_field = "5BA4E275A4DE9E31469F76AE75C7E9A1", hash_generated_field = "922C5ED1D7A64B6BFAA6BDDE01C3EA59")

    private static final boolean BITMAP_RENDERING_ANTIALIAS = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.269 -0500", hash_original_field = "F6615C20C4FA6299531D545D11D82A2A", hash_generated_field = "EB0244A71FAAB93211FD398D574A5B54")

    private static final boolean BITMAP_RENDERING_DITHER = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.278 -0500", hash_original_field = "5CBB25D2ED9B6FBD70ACC5441BABC613", hash_generated_field = "00C4EC8CD37B12CB146DBC271EC98866")

    private static final AtomicInteger sGestureCount = new AtomicInteger(0);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.473 -0500", hash_original_method = "704348430321167D73BC4B389CB149A4", hash_generated_method = "1F43176B6ECA61DD11333E2F9202077A")
    
static Gesture deserialize(DataInputStream in) throws IOException {
        final Gesture gesture = new Gesture();

        // Gesture ID
        gesture.mGestureID = in.readLong();
        // Number of strokes
        final int count = in.readInt();

        for (int i = 0; i < count; i++) {
            gesture.addStroke(GestureStroke.deserialize(in));
        }

        return gesture;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.506 -0500", hash_original_field = "A7061D7E636EC2E39C59A88912C2604F", hash_generated_field = "62E1536C57E8701BFD2818B7105E7D29")

    public static final Parcelable.Creator<Gesture> CREATOR = new Parcelable.Creator<Gesture>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:36.305 -0500", hash_original_method = "EB993F665DB343ED1E9AF0775BEE74CA", hash_generated_method = "B4CE95667D377DB3029586150EA96CF7")
        
public Gesture createFromParcel(Parcel in) {
            Gesture gesture = null;
            final long gestureID = in.readLong();

            final DataInputStream inStream = new DataInputStream(
                    new ByteArrayInputStream(in.createByteArray()));

            try {
                gesture = deserialize(inStream);
            } catch (IOException e) {
                Log.e(GestureConstants.LOG_TAG, "Error reading Gesture from parcel:", e);
            } finally {
                GestureUtils.closeStream(inStream);
            }

            if (gesture != null) {
                gesture.mGestureID = gestureID;
            }

            return gesture;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:36.317 -0500", hash_original_method = "36E2B629F0792165E116B9E464A18CD8", hash_generated_method = "87D6F661A7084FEE04709701E418FD95")
        
public Gesture[] newArray(int size) {
            return new Gesture[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.298 -0500", hash_original_field = "5FE9FB072EC5AB9D41472CC3ECD64AA1", hash_generated_field = "3D8E981E064D40B31D458007C3410434")

    private final RectF mBoundingBox = new RectF();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.306 -0500", hash_original_field = "53D996EF5C3AC7865B47201F58E2FB48", hash_generated_field = "D3E1AA26AF029A069592AF83B1507112")

    private long mGestureID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.315 -0500", hash_original_field = "4E990228142264618C9982F84FD7A05B", hash_generated_field = "51189B296B288EB557512B8559591D71")

    private final ArrayList<GestureStroke> mStrokes = new ArrayList<GestureStroke>();

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.324 -0500", hash_original_method = "73730C41097D241C4B58E2EF29274F0D", hash_generated_method = "2F03906A7557BEE3E8383505498FECDA")
    
public Gesture() {
        mGestureID = GESTURE_ID_BASE + sGestureCount.incrementAndGet();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.337 -0500", hash_original_method = "6E72D283E1810648FD4479A36353F2CA", hash_generated_method = "DF2C9945F497D4458064DA81DA32D2AC")
    
@Override
    public Object clone() {
        Gesture gesture = new Gesture();
        gesture.mBoundingBox.set(mBoundingBox.left, mBoundingBox.top, 
                                        mBoundingBox.right, mBoundingBox.bottom);
        final int count = mStrokes.size();
        for (int i = 0; i < count; i++) {
            GestureStroke stroke = mStrokes.get(i);
            gesture.mStrokes.add((GestureStroke)stroke.clone());
        }
        return gesture;
    }
    
    /**
     * @return all the strokes of the gesture
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.344 -0500", hash_original_method = "55EC16B100A3DCADBFF1FC13FB91F87C", hash_generated_method = "0F5D951FB520E8DB2EDA8DA3045BE384")
    
public ArrayList<GestureStroke> getStrokes() {
        return mStrokes;
    }

    /**
     * @return the number of strokes included by this gesture
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.351 -0500", hash_original_method = "77EA2FF822274CD8EA95D06327974CFB", hash_generated_method = "ABF78BCE54A56A56E511C86E2AE29644")
    
public int getStrokesCount() {
        return mStrokes.size();
    }

    /**
     * Adds a stroke to the gesture.
     * 
     * @param stroke
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.359 -0500", hash_original_method = "331041DCF96E441D5D9D656234CC8B8B", hash_generated_method = "27730FD3E32C56D5BFFCC44197D688DA")
    
public void addStroke(GestureStroke stroke) {
        mStrokes.add(stroke);
        mBoundingBox.union(stroke.boundingBox);
    }

    /**
     * Calculates the total length of the gesture. When there are multiple strokes in
     * the gesture, this returns the sum of the lengths of all the strokes.
     * 
     * @return the length of the gesture
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.368 -0500", hash_original_method = "C9AAB3B0295E530D07D42E533A347055", hash_generated_method = "3E12BD2D1C974DDCA7C8144DEA56FC4B")
    
public float getLength() {
        int len = 0;
        final ArrayList<GestureStroke> strokes = mStrokes;
        final int count = strokes.size();

        for (int i = 0; i < count; i++) {
            len += strokes.get(i).length;
        }

        return len;
    }

    /**
     * @return the bounding box of the gesture
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.375 -0500", hash_original_method = "BFBE6CCA0ADEDD10E3942AFF3D0B1961", hash_generated_method = "61C7541D4826AA213D72EF7AA3E1F6CE")
    
public RectF getBoundingBox() {
        return mBoundingBox;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.383 -0500", hash_original_method = "DFBDD1C804A3C80B433D778E08AE779F", hash_generated_method = "3759AE44F621ACF81886370F1BAAC626")
    
public Path toPath() {
        return toPath(null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.391 -0500", hash_original_method = "9FF6E92B4C535E12B5C5B797E88F445F", hash_generated_method = "9A3254EAD2A6FE4291071EFFBE2C275B")
    
public Path toPath(Path path) {
        if (path == null) path = new Path();

        final ArrayList<GestureStroke> strokes = mStrokes;
        final int count = strokes.size();

        for (int i = 0; i < count; i++) {
            path.addPath(strokes.get(i).getPath());
        }

        return path;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.399 -0500", hash_original_method = "1BA525525083BDF0AF6E414407CA74EF", hash_generated_method = "E27B7C7255ADC69FC0EDDD4CDA880FB1")
    
public Path toPath(int width, int height, int edge, int numSample) {
        return toPath(null, width, height, edge, numSample);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.408 -0500", hash_original_method = "B8884857D1D70B7827E1B11ED8A8C686", hash_generated_method = "905E469A6F8D87AA2E66154FFCC19723")
    
public Path toPath(Path path, int width, int height, int edge, int numSample) {
        if (path == null) path = new Path();

        final ArrayList<GestureStroke> strokes = mStrokes;
        final int count = strokes.size();

        for (int i = 0; i < count; i++) {
            path.addPath(strokes.get(i).toPath(width - 2 * edge, height - 2 * edge, numSample));
        }

        return path;
    }

    /**
     * Sets the id of the gesture.
     * 
     * @param id
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.416 -0500", hash_original_method = "E8B0C6854BDB6A5B047FE888861ECEF3", hash_generated_method = "E8B0C6854BDB6A5B047FE888861ECEF3")
    
void setID(long id) {
        mGestureID = id;
    }

    /**
     * @return the id of the gesture
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.422 -0500", hash_original_method = "9232EEB75B24CC1C17F8045A486785DF", hash_generated_method = "B4B64208C6A2A835CFA77ECDC62650A6")
    
public long getID() {
        return mGestureID;
    }

    /**
     * Creates a bitmap of the gesture with a transparent background.
     * 
     * @param width width of the target bitmap
     * @param height height of the target bitmap
     * @param edge the edge
     * @param numSample
     * @param color
     * @return the bitmap
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.437 -0500", hash_original_method = "8CF23C63ACF7AC4866C0217994609C5E", hash_generated_method = "151BD594B611C3D0110CF64AFDFBC1A7")
    
public Bitmap toBitmap(int width, int height, int edge, int numSample, int color) {
        final Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);

        canvas.translate(edge, edge);

        final Paint paint = new Paint();
        paint.setAntiAlias(BITMAP_RENDERING_ANTIALIAS);
        paint.setDither(BITMAP_RENDERING_DITHER);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(BITMAP_RENDERING_WIDTH);

        final ArrayList<GestureStroke> strokes = mStrokes;
        final int count = strokes.size();

        for (int i = 0; i < count; i++) {
            Path path = strokes.get(i).toPath(width - 2 * edge, height - 2 * edge, numSample);
            canvas.drawPath(path, paint);
        }

        return bitmap;
    }

    /**
     * Creates a bitmap of the gesture with a transparent background.
     * 
     * @param width
     * @param height
     * @param inset
     * @param color
     * @return the bitmap
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.456 -0500", hash_original_method = "52B76A9CFA81E3C79D701A627A7AE336", hash_generated_method = "1BE14F5073BEF39FCFCE874C7877284B")
    
public Bitmap toBitmap(int width, int height, int inset, int color) {
        final Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);

        final Paint paint = new Paint();
        paint.setAntiAlias(BITMAP_RENDERING_ANTIALIAS);
        paint.setDither(BITMAP_RENDERING_DITHER);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(BITMAP_RENDERING_WIDTH);

        final Path path = toPath();
        final RectF bounds = new RectF();
        path.computeBounds(bounds, true);

        final float sx = (width - 2 * inset) / bounds.width();
        final float sy = (height - 2 * inset) / bounds.height();
        final float scale = sx > sy ? sy : sx;
        paint.setStrokeWidth(2.0f / scale);

        path.offset(-bounds.left + (width - bounds.width() * scale) / 2.0f,
                -bounds.top + (height - bounds.height() * scale) / 2.0f);

        canvas.translate(inset, inset);
        canvas.scale(scale, scale);

        canvas.drawPath(path, paint);

        return bitmap;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.465 -0500", hash_original_method = "C45BA342FBF34DF172C489EF66CAF3F3", hash_generated_method = "E96FA2D779CDCA2A86CD4E875626B173")
    
void serialize(DataOutputStream out) throws IOException {
        final ArrayList<GestureStroke> strokes = mStrokes;
        final int count = strokes.size();

        // Write gesture ID
        out.writeLong(mGestureID);
        // Write number of strokes
        out.writeInt(count);

        for (int i = 0; i < count; i++) {
            strokes.get(i).serialize(out);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.518 -0500", hash_original_method = "DC7198587E9B7D628EE000DDBA145CAA", hash_generated_method = "D839430BFF270D1855A1382F62B662A9")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeLong(mGestureID);

        boolean result = false;
        final ByteArrayOutputStream byteStream =
                new ByteArrayOutputStream(GestureConstants.IO_BUFFER_SIZE);
        final DataOutputStream outStream = new DataOutputStream(byteStream);

        try {
            serialize(outStream);
            result = true;
        } catch (IOException e) {
            Log.e(GestureConstants.LOG_TAG, "Error writing Gesture to parcel:", e);
        } finally {
            GestureUtils.closeStream(outStream);
            GestureUtils.closeStream(byteStream);
        }

        if (result) {
            out.writeByteArray(byteStream.toByteArray());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:24.524 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
}

