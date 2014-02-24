/*
 * Copyright (C) 2009 The Android Open Source Project
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
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.util.ArrayList;

/**
 * A gesture stroke started on a touch down and ended on a touch up. A stroke
 * consists of a sequence of timed points. One or multiple strokes form a gesture.
 */
public class GestureStroke {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.366 -0500", hash_original_field = "89E0D92964EE9D967D091D7773C7CA8C", hash_generated_field = "0BEB23C4EB28CFC9E3A069E68D857BC1")

    static final float TOUCH_TOLERANCE = 3;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.431 -0500", hash_original_method = "4DE17C29E72E013AC0948B826BABE2D7", hash_generated_method = "9B0D3A461D2037AF18607C9EFC40FCAA")
    
static GestureStroke deserialize(DataInputStream in) throws IOException {
        // Number of points
        final int count = in.readInt();

        final ArrayList<GesturePoint> points = new ArrayList<GesturePoint>(count);
        for (int i = 0; i < count; i++) {
            points.add(GesturePoint.deserialize(in));
        }

        return new GestureStroke(points);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.370 -0500", hash_original_field = "3DFCE262ED1412BB6378832E5F6E2D38", hash_generated_field = "6BB4E451B84B179CB428B3F4CE30A730")


    public  RectF boundingBox;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.375 -0500", hash_original_field = "3D5D2818BBCA705ED2071BBFDBE9AF6E", hash_generated_field = "5C25137370EF4F785D5439489EE9EA0E")


    public  float length;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.379 -0500", hash_original_field = "EAEF1290AA6600A5FE9A1A1FB6829F9C", hash_generated_field = "F830548537398F62620CE8066BEC4F57")

    public  float[] points;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.383 -0500", hash_original_field = "BC63CEFE38721CBECBA3634FE4D1216B", hash_generated_field = "B60A4474091AE7EEF9780E597F52B552")


    private  long[] timestamps;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.387 -0500", hash_original_field = "A4E5CDB743435F42476DBC50C0FA2590", hash_generated_field = "AAC8ED85CAF99DD353936D60A8681828")

    private Path mCachedPath;

    /**
     * A constructor that constructs a gesture stroke from a list of gesture points.
     * 
     * @param points
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.394 -0500", hash_original_method = "D11740C72176E35C02C56EA6D48D6A0F", hash_generated_method = "C5B93CAC117DD816551C55D1629BE0E5")
    
public GestureStroke(ArrayList<GesturePoint> points) {
        final int count = points.size();
        final float[] tmpPoints = new float[count * 2];
        final long[] times = new long[count];

        RectF bx = null;
        float len = 0;
        int index = 0;

        for (int i = 0; i < count; i++) {
            final GesturePoint p = points.get(i);
            tmpPoints[i * 2] = p.x;
            tmpPoints[i * 2 + 1] = p.y;
            times[index] = p.timestamp;

            if (bx == null) {
                bx = new RectF();
                bx.top = p.y;
                bx.left = p.x;
                bx.right = p.x;
                bx.bottom = p.y;
                len = 0;
            } else {
                len += Math.sqrt(Math.pow(p.x - tmpPoints[(i - 1) * 2], 2)
                        + Math.pow(p.y - tmpPoints[(i -1 ) * 2 + 1], 2));
                bx.union(p.x, p.y);
            }
            index++;
        }
        
        timestamps = times;
        this.points = tmpPoints;
        boundingBox = bx;
        length = len;
    }

    /**
     * A faster constructor specially for cloning a stroke.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.399 -0500", hash_original_method = "9FC9227DC93CA731A7221E8F667FB6FD", hash_generated_method = "19F00FC4D73D27D9CBE3EA5B5E341472")
    
private GestureStroke(RectF bbx, float len, float[] pts, long[] times) {
        boundingBox = new RectF(bbx.left, bbx.top, bbx.right, bbx.bottom);
        length = len;
        points = pts.clone();
        timestamps = times.clone();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.403 -0500", hash_original_method = "82D51B5ADFF92CF0533EE73928B096E3", hash_generated_method = "F4C4F2A467B0D1B2282A03B80B09F40D")
    
@Override
    public Object clone() {
        return new GestureStroke(boundingBox, length, points, timestamps);
    }
    
    /**
     * Draws the stroke with a given canvas and paint.
     * 
     * @param canvas
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.407 -0500", hash_original_method = "A5AEC64904918A444A1E291605339382", hash_generated_method = "A5AEC64904918A444A1E291605339382")
    
void draw(Canvas canvas, Paint paint) {
        if (mCachedPath == null) {
            makePath();
        }

        canvas.drawPath(mCachedPath, paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.411 -0500", hash_original_method = "E1608F827D14D502DEC89A9905D1C83D", hash_generated_method = "DADCF0837592E934062044088203A8B4")
    
public Path getPath() {
        if (mCachedPath == null) {
            makePath();
        }

        return mCachedPath;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.416 -0500", hash_original_method = "25C94B78C28C5AD1FD11D58B9B01036D", hash_generated_method = "773548A6452D38DF697DABA41A3D69FA")
    
private void makePath() {
        final float[] localPoints = points;
        final int count = localPoints.length;

        Path path = null;

        float mX = 0;
        float mY = 0;

        for (int i = 0; i < count; i += 2) {
            float x = localPoints[i];
            float y = localPoints[i + 1];
            if (path == null) {
                path = new Path();
                path.moveTo(x, y);
                mX = x;
                mY = y;
            } else {
                float dx = Math.abs(x - mX);
                float dy = Math.abs(y - mY);
                if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
                    path.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
                    mX = x;
                    mY = y;
                }
            }
        }

        mCachedPath = path;
    }

    /**
     * Converts the stroke to a Path of a given number of points.
     * 
     * @param width the width of the bounding box of the target path
     * @param height the height of the bounding box of the target path
     * @param numSample the number of points needed
     * 
     * @return the path
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.421 -0500", hash_original_method = "7D5076FD031C3333366BAA4D8CB3A6E9", hash_generated_method = "EFEE2F3C5813D9D53F3FAAE6E821DF49")
    
public Path toPath(float width, float height, int numSample) {
        final float[] pts = GestureUtils.temporalSampling(this, numSample);
        final RectF rect = boundingBox;

        GestureUtils.translate(pts, -rect.left, -rect.top);
        
        float sx = width / rect.width();
        float sy = height / rect.height();
        float scale = sx > sy ? sy : sx;
        GestureUtils.scale(pts, scale, scale);

        float mX = 0;
        float mY = 0;

        Path path = null;

        final int count = pts.length;

        for (int i = 0; i < count; i += 2) {
            float x = pts[i];
            float y = pts[i + 1];
            if (path == null) {
                path = new Path();
                path.moveTo(x, y);
                mX = x;
                mY = y;
            } else {
                float dx = Math.abs(x - mX);
                float dy = Math.abs(y - mY);
                if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
                    path.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
                    mX = x;
                    mY = y;
                }
            }
        }

        return path;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.426 -0500", hash_original_method = "5D0CFB0240D1242B3DA576CB8DDD4D23", hash_generated_method = "CB64B0B2F8D29A66ECA05404C149C9AE")
    
void serialize(DataOutputStream out) throws IOException {
        final float[] pts = points;
        final long[] times = timestamps;
        final int count = points.length;

        // Write number of points
        out.writeInt(count / 2);

        for (int i = 0; i < count; i += 2) {
            // Write X
            out.writeFloat(pts[i]);
            // Write Y
            out.writeFloat(pts[i + 1]);
            // Write timestamp
            out.writeLong(times[i / 2]);
        }
    }    

    /**
     * Invalidates the cached path that is used to render the stroke.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.435 -0500", hash_original_method = "2F56B6A3D34BA40F73B5A3D4B3835F99", hash_generated_method = "14673EDACAD8BEB8AEFAA19627559880")
    
public void clearPath() {
        if (mCachedPath != null) mCachedPath.rewind();
    }
    
    /**
     * Computes an oriented bounding box of the stroke.
     * 
     * @return OrientedBoundingBox
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:40.439 -0500", hash_original_method = "EFD9495A1C7E86FA87C6E18B7AEF10E0", hash_generated_method = "81482A8F6DCF884684552385CD88BCFE")
    
public OrientedBoundingBox computeOrientedBoundingBox() {
        return GestureUtils.computeOrientedBoundingBox(points);
    }
}
