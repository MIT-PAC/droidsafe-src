/*
 * Copyright (C) 2013 The Android Open Source Project
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

package android.support.v4.print;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.net.Uri;

import java.io.FileNotFoundException;

/**
 * Helper for printing bitmaps.
 */
public final class PrintHelper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.064 -0400", hash_original_field = "EC581CECE128947E18DCFD218DD2C395", hash_generated_field = "2E0C813AAFBD35DDA4ADC0ED05668D81")

    public static final int SCALE_MODE_FIT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.071 -0400", hash_original_field = "126A5D8168251A0695138F358D013C15", hash_generated_field = "0BD5723F66192F11E15E8B462B47FD87")

    public static final int SCALE_MODE_FILL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.081 -0400", hash_original_field = "A6E23E6481BB76DFE32B4E6243122F47", hash_generated_field = "0F6296E909AB9431F6802A4D688C9056")

    public static final int COLOR_MODE_MONOCHROME = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.088 -0400", hash_original_field = "E817685C74DC1AEFE0EC420F5F7231C6", hash_generated_field = "0530007EF3ACFB7C1C4DE84680A83759")

    public static final int COLOR_MODE_COLOR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.108 -0400", hash_original_field = "17FC281DA208D9BB313853F58A359A4C", hash_generated_field = "DA0DB82C6A049A14CD9F760904369736")

    public static final int ORIENTATION_LANDSCAPE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.115 -0400", hash_original_field = "3E17ACCFAF41040F9FC6EEB4C8B9A7BE", hash_generated_field = "DA7BE6D40EAD5D29287A1CC43ACDC832")

    public static final int ORIENTATION_PORTRAIT = 2;

    /**
     * Gets whether the system supports printing.
     *
     * @return True if printing is supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.131 -0400", hash_original_method = "507B8E55BFEC88A5542BE95F01C3DF80", hash_generated_method = "88AFB6FC799C4050D8461190EE6BA5E9")
    
public static boolean systemSupportsPrint() {
        if (Build.VERSION.SDK_INT >= 19) {
            // Supported on Android 4.4 or later.
            return true;
        }
        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.122 -0400", hash_original_field = "1569E048FF58A1A3F740F7EDE6BEBB69", hash_generated_field = "1569E048FF58A1A3F740F7EDE6BEBB69")


    PrintHelperVersionImpl mImpl;

    /**
     * Interface implemented by classes that support printing
     */
    static interface PrintHelperVersionImpl {

        public void setScaleMode(int scaleMode);

        public int getScaleMode();

        public void setColorMode(int colorMode);

        public int getColorMode();

        public void setOrientation(int orientation);

        public int getOrientation();

        public void printBitmap(String jobName, Bitmap bitmap);

        public void printBitmap(String jobName, Uri imageFile)
                throws FileNotFoundException;
    }

    /**
     * Implementation used when we do not support printing
     */
    private static final class PrintHelperStubImpl implements PrintHelperVersionImpl {
        int mScaleMode = SCALE_MODE_FILL;
        int mColorMode = COLOR_MODE_COLOR;
        int mOrientation = ORIENTATION_LANDSCAPE;
        @Override
        public void setScaleMode(int scaleMode) {
            mScaleMode = scaleMode;
        }

        @Override
        public int getColorMode() {
            return mColorMode;
        }

        @Override
        public void setColorMode(int colorMode) {
            mColorMode = colorMode;
        }

        @Override
        public void setOrientation(int orientation) { mOrientation = orientation; }

        @Override
        public int getOrientation() { return mOrientation; }

        @Override
        public int getScaleMode() {
            return mScaleMode;
        }

        @Override
        public void printBitmap(String jobName, Bitmap bitmap) {
        }

        @Override
        public void printBitmap(String jobName, Uri imageFile) {
        }
    }

    /**
     * Implementation used on KitKat (and above)
     */
    private static final class PrintHelperKitkatImpl implements PrintHelperVersionImpl {
        private final PrintHelperKitkat mPrintHelper;

        PrintHelperKitkatImpl(Context context) {
            mPrintHelper = new PrintHelperKitkat(context);
        }

        @Override
        public void setScaleMode(int scaleMode) {
            mPrintHelper.setScaleMode(scaleMode);
        }

        @Override
        public int getScaleMode() {
            return mPrintHelper.getScaleMode();
        }

        @Override
        public void setColorMode(int colorMode) {
            mPrintHelper.setColorMode(colorMode);
        }

        @Override
        public int getColorMode() {
            return mPrintHelper.getColorMode();
        }

        @Override
        public void setOrientation(int orientation) {
            mPrintHelper.setOrientation(orientation);
        }

        @Override
        public int getOrientation() {
            return mPrintHelper.getOrientation();
        }

        @Override
        public void printBitmap(String jobName, Bitmap bitmap) {
            mPrintHelper.printBitmap(jobName, bitmap);
        }

        @Override
        public void printBitmap(String jobName, Uri imageFile) throws FileNotFoundException {
            mPrintHelper.printBitmap(jobName, imageFile);
        }
    }

    /**
     * Returns the PrintHelper that can be used to print images.
     *
     * @param context A context for accessing system resources.
     * @return the <code>PrintHelper</code> to support printing images.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.352 -0400", hash_original_method = "027E81907CCBF690CC05DE7B239AF26A", hash_generated_method = "C97FDD2101186E47E08F9CF1841C7116")
        
public PrintHelper(Context context) {
        if (systemSupportsPrint()) {
            mImpl = new PrintHelperKitkatImpl(context);
        } else {
            mImpl = new PrintHelperStubImpl();
        }
    }

    /**
     * Selects whether the image will fill the paper and be cropped
     * {@link #SCALE_MODE_FIT}
     * or whether the image will be scaled but leave white space
     * {@link #SCALE_MODE_FILL}.
     *
     * @param scaleMode {@link #SCALE_MODE_FIT} or
     *                  {@link #SCALE_MODE_FILL}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.359 -0400", hash_original_method = "9D922B7140A50353B3334C7DBF1B3202", hash_generated_method = "0D1140D96A2842938AEB936149E0F60E")
        
public void setScaleMode(int scaleMode) {
        mImpl.setScaleMode(scaleMode);
    }

    /**
     * Returns the scale mode with which the image will fill the paper.
     *
     * @return The scale Mode: {@link #SCALE_MODE_FIT} or
     * {@link #SCALE_MODE_FILL}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.366 -0400", hash_original_method = "7071DF421A7F46097DD072BB15DD91F4", hash_generated_method = "BFCB19D85E0CF848E91F1231C25FF3E3")
        
public int getScaleMode() {
        return mImpl.getScaleMode();
    }

    /**
     * Sets whether the image will be printed in color (default)
     * {@link #COLOR_MODE_COLOR} or in back and white
     * {@link #COLOR_MODE_MONOCHROME}.
     *
     * @param colorMode The color mode which is one of
     * {@link #COLOR_MODE_COLOR} and {@link #COLOR_MODE_MONOCHROME}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.376 -0400", hash_original_method = "7B716D778CE9A8B130DF71BDF9514281", hash_generated_method = "2F184BEFD51F237FC15B6EA89D94279C")
        
public void setColorMode(int colorMode) {
        mImpl.setColorMode(colorMode);
    }

    /**
     * Gets the color mode with which the image will be printed.
     *
     * @return The color mode which is one of {@link #COLOR_MODE_COLOR}
     * and {@link #COLOR_MODE_MONOCHROME}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.382 -0400", hash_original_method = "E91B9A14161632986F339B8F5E34268D", hash_generated_method = "21364A71107C420AE38D37BCB457F275")
        
public int getColorMode() {
        return mImpl.getColorMode();
    }

    /**
     * Sets whether the image will be printed in landscape {@link #ORIENTATION_LANDSCAPE} (default)
     * or portrait {@link #ORIENTATION_PORTRAIT}.
     *
     * @param orientation The page orientation which is one of
     *                    {@link #ORIENTATION_LANDSCAPE} or {@link #ORIENTATION_PORTRAIT}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.388 -0400", hash_original_method = "F3F2C6EFB7DBD0785ED517D275A0C965", hash_generated_method = "7263E6C7EF5944E66A72EA276550D112")
        
public void setOrientation(int orientation) {
        mImpl.setOrientation(orientation);
    }

    /**
     * Gets whether the image will be printed in landscape or portrait.
     *
     * @return The page orientation which is one of
     * {@link #ORIENTATION_LANDSCAPE} or {@link #ORIENTATION_PORTRAIT}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.394 -0400", hash_original_method = "4D60ACB6D08E2EDC63510B5F72CB9227", hash_generated_method = "58B2D8BCEE3602D894C0AE2D22C5A153")
        
public int getOrientation() {
        return mImpl.getOrientation();
    }

    /**
     * Prints a bitmap.
     *
     * @param jobName The print job name.
     * @param bitmap  The bitmap to print.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.401 -0400", hash_original_method = "74825BE0299DAECE5299F6D6B0BC33ED", hash_generated_method = "C4FB93CC5D8DB40D61B7A311FA0705F9")
        
public void printBitmap(String jobName, Bitmap bitmap) {
        mImpl.printBitmap(jobName, bitmap);
    }

    /**
     * Prints an image located at the Uri. Image types supported are those of
     * {@link android.graphics.BitmapFactory#decodeStream(java.io.InputStream)
     * android.graphics.BitmapFactory.decodeStream(java.io.InputStream)}
     *
     * @param jobName   The print job name.
     * @param imageFile The <code>Uri</code> pointing to an image to print.
     * @throws FileNotFoundException if <code>Uri</code> is not pointing to a valid image.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:17.408 -0400", hash_original_method = "77D42C02A3EF3FE3EB767E14F2541C58", hash_generated_method = "24ADBD2BEBA378571204D8FB142A7915")
        
public void printBitmap(String jobName, Uri imageFile) throws FileNotFoundException {
        mImpl.printBitmap(jobName, imageFile);
    }
}