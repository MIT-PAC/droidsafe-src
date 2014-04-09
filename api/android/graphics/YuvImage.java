/*
 * Copyright (C) 2010 The Android Open Source Project
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

package android.graphics;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.OutputStream;

/**
 * YuvImage contains YUV data and provides a method that compresses a region of
 * the YUV data to a Jpeg. The YUV data should be provided as a single byte
 * array irrespective of the number of image planes in it.
 * Currently only ImageFormat.NV21 and ImageFormat.YUY2 are supported.
 *
 * To compress a rectangle region in the YUV data, users have to specify the
 * region by left, top, width and height.
 */
public class YuvImage {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.174 -0400", hash_original_field = "7B29D9E558DDC2DCAE77682B3E8DE6BE", hash_generated_field = "835CBF2BDF2BE37014A11526CBB54378")

    private final static int WORKING_COMPRESS_STORAGE = 4096;

    //////////// native methods

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:25.313 -0400", hash_original_method = "A203BEDE27AFA914C63DE6E50D05F74E", hash_generated_method = "990130BCE8EACC08A1F98770BD8CE98C")
    
    private static boolean nativeCompressToJpeg(byte[] oriYuv,
                int format, int width, int height, int[] offsets, int[] strides,
                int quality, OutputStream stream, byte[] tempStorage){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += oriYuv[0];
    	taintDouble += format;
    	taintDouble += width;
    	taintDouble += height;
    	taintDouble += offsets[0];
    	taintDouble += strides[0];
    	taintDouble += quality;
    	taintDouble += stream.getTaintInt();
    	taintDouble += tempStorage[0];
    
    	return toTaintBoolean(taintDouble);
    }



@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.176 -0400", hash_original_field = "F274D9A6D075EEEA711AF201B69FCAF4", hash_generated_field = "AB812A232FD99D518B911A3EA9A3816E")

    private int mFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.178 -0400", hash_original_field = "5D97F7C0534662C5183D05D4FFD1A145", hash_generated_field = "04254C7D5555806109D3DE22B9918A82")

    private byte[] mData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.181 -0400", hash_original_field = "F7244512F4602D0D589A6FAB8C37D1E9", hash_generated_field = "996BF8495A6C534FEF622833B99A0DD3")

    private int[] mStrides;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.183 -0400", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.184 -0400", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

    private int mHeight;

    /**
     * Construct an YuvImage.
     *
     * @param yuv     The YUV data. In the case of more than one image plane, all the planes must be
     *                concatenated into a single byte array.
     * @param format  The YUV data format as defined in {@link ImageFormat}.
     * @param width   The width of the YuvImage.
     * @param height  The height of the YuvImage.
     * @param strides (Optional) Row bytes of each image plane. If yuv contains padding, the stride
     *                of each image must be provided. If strides is null, the method assumes no
     *                padding and derives the row bytes by format and width itself.
     * @throws IllegalArgumentException if format is not support; width or height <= 0; or yuv is
     *                null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.187 -0400", hash_original_method = "DB3E1C941A9335F00C3790ED360475B2", hash_generated_method = "669A997AA46BE6BD8344E04E659EA264")
    
public YuvImage(byte[] yuv, int format, int width, int height, int[] strides) {
        if (format != ImageFormat.NV21 &&
                format != ImageFormat.YUY2) {
            throw new IllegalArgumentException(
                    "only support ImageFormat.NV21 " +
                    "and ImageFormat.YUY2 for now");
        }

        if (width <= 0  || height <= 0) {
            throw new IllegalArgumentException(
                    "width and height must large than 0");
        }

        if (yuv == null) {
            throw new IllegalArgumentException("yuv cannot be null");
        }

        if (strides == null) {
            mStrides = calculateStrides(width, format);
        } else {
            mStrides = strides;
        }

        mData = yuv;
        mFormat = format;
        mWidth = width;
        mHeight = height;
    }

    /**
     * Compress a rectangle region in the YuvImage to a jpeg.
     * Only ImageFormat.NV21 and ImageFormat.YUY2
     * are supported for now.
     *
     * @param rectangle The rectangle region to be compressed. The medthod checks if rectangle is
     *                  inside the image. Also, the method modifies rectangle if the chroma pixels
     *                  in it are not matched with the luma pixels in it.
     * @param quality   Hint to the compressor, 0-100. 0 meaning compress for
     *                  small size, 100 meaning compress for max quality.
     * @param stream    OutputStream to write the compressed data.
     * @return          True if the compression is successful.
     * @throws IllegalArgumentException if rectangle is invalid; quality is not within [0,
     *                  100]; or stream is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.189 -0400", hash_original_method = "0CDAF22FE8B926264B2EE50F31A40E4D", hash_generated_method = "1DE1FC7F57EDA183E59ED0084064DA89")
    
public boolean compressToJpeg(Rect rectangle, int quality, OutputStream stream) {
        Rect wholeImage = new Rect(0, 0, mWidth, mHeight);
        if (!wholeImage.contains(rectangle)) {
            throw new IllegalArgumentException(
                    "rectangle is not inside the image");
        }

        if (quality < 0 || quality > 100) {
            throw new IllegalArgumentException("quality must be 0..100");
        }

        if (stream == null) {
            throw new IllegalArgumentException("stream cannot be null");
        }

        adjustRectangle(rectangle);
        int[] offsets = calculateOffsets(rectangle.left, rectangle.top);

        return nativeCompressToJpeg(mData, mFormat, rectangle.width(),
                rectangle.height(), offsets, mStrides, quality, stream,
                new byte[WORKING_COMPRESS_STORAGE]);
    }


   /**
     * @return the YUV data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.190 -0400", hash_original_method = "B1EFA8C171A71253CAAA11C25D72CDF3", hash_generated_method = "247D9CB47D464A0F504043C60DA8626B")
    
public byte[] getYuvData() {
        return mData;
    }

    /**
     * @return the YUV format as defined in {@link ImageFormat}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.192 -0400", hash_original_method = "19C5F9C2540905367F777718FB24AF1C", hash_generated_method = "2DDD6BAE55EC2BD444A6BF9B43490A59")
    
public int getYuvFormat() {
        return mFormat;
    }

    /**
     * @return the number of row bytes in each image plane.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.194 -0400", hash_original_method = "193F2D26362BE05CABBA7B43EBD45A71", hash_generated_method = "20945B8A470BEF1F8BDABE65D12AD0AF")
    
public int[] getStrides() {
        return mStrides;
    }

    /**
     * @return the width of the image.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.195 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "76288D230877FA0A2BAF233CBE4CB19E")
    
public int getWidth() {
        return mWidth;
    }

    /**
     * @return the height of the image.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.197 -0400", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "7B60B7C518DA05BF980E6A0812F1B814")
    
public int getHeight() {
        return mHeight;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.200 -0400", hash_original_method = "0B47921CF4C8E2E252E7BC50D60F5CE6", hash_generated_method = "0B47921CF4C8E2E252E7BC50D60F5CE6")
    
int[] calculateOffsets(int left, int top) {
        int[] offsets = null;
        if (mFormat == ImageFormat.NV21) {
            offsets = new int[] {top * mStrides[0] + left,
                  mHeight * mStrides[0] + top / 2 * mStrides[1]
                  + left / 2 * 2 };
            return offsets;
        }

        if (mFormat == ImageFormat.YUY2) {
            offsets = new int[] {top * mStrides[0] + left / 2 * 4};
            return offsets;
        }

        return offsets;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.202 -0400", hash_original_method = "0843C77890A6125F90E6FF9AEDBA9883", hash_generated_method = "1CA93F17964461F860BA7B0D3A245EE5")
    
private int[] calculateStrides(int width, int format) {
        int[] strides = null;
        if (format == ImageFormat.NV21) {
            strides = new int[] {width, width};
            return strides;
        }

        if (format == ImageFormat.YUY2) {
            strides = new int[] {width * 2};
            return strides;
        }

        return strides;
    }

   @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.204 -0400", hash_original_method = "0D1461947DF224AF8F5EAA8FEEDBC13A", hash_generated_method = "FC94D0678C372EFF15418EF043D1750A")
    
private void adjustRectangle(Rect rect) {
       int width = rect.width();
       int height = rect.height();
       if (mFormat == ImageFormat.NV21) {
           // Make sure left, top, width and height are all even.
           width &= ~1;
           height &= ~1;
           rect.left &= ~1;
           rect.top &= ~1;
           rect.right = rect.left + width;
           rect.bottom = rect.top + height;
        }

        if (mFormat == ImageFormat.YUY2) {
            // Make sure left and width are both even.
            width &= ~1;
            rect.left &= ~1;
            rect.right = rect.left + width;
        }
    }
}
