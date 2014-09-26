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
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument.Page;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Kitkat specific PrintManager API implementation.
 */
class PrintHelperKitkat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.548 -0400", hash_original_field = "CB0FAB334D5F4903F7272D5F8F6F656F", hash_generated_field = "E3294993D56825E529EAF1534A171307")

    private static final String LOG_TAG = "PrintHelperKitkat";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.555 -0400", hash_original_field = "891E52882C3EED272B7B8E102152DC7F", hash_generated_field = "9E51CCCF4FD07552B4CD14914B2D2F82")

    private final static int MAX_PRINT_SIZE = 3500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.586 -0400", hash_original_field = "EC581CECE128947E18DCFD218DD2C395", hash_generated_field = "2E0C813AAFBD35DDA4ADC0ED05668D81")

    public static final int SCALE_MODE_FIT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.593 -0400", hash_original_field = "126A5D8168251A0695138F358D013C15", hash_generated_field = "0BD5723F66192F11E15E8B462B47FD87")

    public static final int SCALE_MODE_FILL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.599 -0400", hash_original_field = "17FC281DA208D9BB313853F58A359A4C", hash_generated_field = "DA0DB82C6A049A14CD9F760904369736")

    public static final int ORIENTATION_LANDSCAPE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.614 -0400", hash_original_field = "3E17ACCFAF41040F9FC6EEB4C8B9A7BE", hash_generated_field = "DA7BE6D40EAD5D29287A1CC43ACDC832")

    public static final int ORIENTATION_PORTRAIT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.621 -0400", hash_original_field = "A6E23E6481BB76DFE32B4E6243122F47", hash_generated_field = "0F6296E909AB9431F6802A4D688C9056")

    public static final int COLOR_MODE_MONOCHROME = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.629 -0400", hash_original_field = "E817685C74DC1AEFE0EC420F5F7231C6", hash_generated_field = "0530007EF3ACFB7C1C4DE84680A83759")

    public static final int COLOR_MODE_COLOR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.563 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

     Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.572 -0400", hash_original_field = "DBD2B7F9BB1961A50341B4DC2512916B", hash_generated_field = "DBD2B7F9BB1961A50341B4DC2512916B")

    BitmapFactory.Options mDecodeOptions = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.579 -0400", hash_original_field = "83DB9DCBBD2D99A708D9A1934D5CD5AB", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

    private final Object mLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.635 -0400", hash_original_field = "557194F2CD36A9B5304668663A716C82", hash_generated_field = "557194F2CD36A9B5304668663A716C82")

    int mScaleMode = SCALE_MODE_FILL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.642 -0400", hash_original_field = "E84C2151704D3121085830BCF1B69798", hash_generated_field = "E84C2151704D3121085830BCF1B69798")

    int mColorMode = COLOR_MODE_COLOR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.652 -0400", hash_original_field = "6850062C1FBEC9EFAB4E65B09592C25B", hash_generated_field = "6850062C1FBEC9EFAB4E65B09592C25B")

    int mOrientation = ORIENTATION_LANDSCAPE;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.659 -0400", hash_original_method = "6DFB36590E0365951006429B1EADC977", hash_generated_method = "6DFB36590E0365951006429B1EADC977")
    
PrintHelperKitkat(Context context) {
        mContext = context;
    }

    /**
     * Selects whether the image will fill the paper and be cropped
     * <p/>
     * {@link #SCALE_MODE_FIT}
     * or whether the image will be scaled but leave white space
     * {@link #SCALE_MODE_FILL}.
     *
     * @param scaleMode {@link #SCALE_MODE_FIT} or
     *                  {@link #SCALE_MODE_FILL}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.665 -0400", hash_original_method = "34C779008FEF06045E290E16D4422CAE", hash_generated_method = "468FB373A4AF9A30089B2F9EC4E99A8C")
    
public void setScaleMode(int scaleMode) {
        mScaleMode = scaleMode;
    }

    /**
     * Returns the scale mode with which the image will fill the paper.
     *
     * @return The scale Mode: {@link #SCALE_MODE_FIT} or
     * {@link #SCALE_MODE_FILL}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.671 -0400", hash_original_method = "3DE4F4432EF799C5AB82A8AA7CD590FF", hash_generated_method = "94E982ACAE6AA1E5BFFF2B3AF388BECC")
    
public int getScaleMode() {
        return mScaleMode;
    }

    /**
     * Sets whether the image will be printed in color (default)
     * {@link #COLOR_MODE_COLOR} or in back and white
     * {@link #COLOR_MODE_MONOCHROME}.
     *
     * @param colorMode The color mode which is one of
     *                  {@link #COLOR_MODE_COLOR} and {@link #COLOR_MODE_MONOCHROME}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.676 -0400", hash_original_method = "5A543531DAA9FCEC5B365BB94F788213", hash_generated_method = "98072600C00A1A83246B580DD3493D43")
    
public void setColorMode(int colorMode) {
        mColorMode = colorMode;
    }

    /**
     * Sets whether to select landscape (default), {@link #ORIENTATION_LANDSCAPE}
     * or portrait {@link #ORIENTATION_PORTRAIT}
     * @param orientation The page orientation which is one of
     *                    {@link #ORIENTATION_LANDSCAPE} or {@link #ORIENTATION_PORTRAIT}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.682 -0400", hash_original_method = "F059BEA018C060B8AF19EC0186D2EAFF", hash_generated_method = "2A5B54B208BB54C5BBC827439F7666A7")
    
public void setOrientation(int orientation) {
        mOrientation = orientation;
    }

    /**
     * Gets the page orientation with which the image will be printed.
     *
     * @return The preferred orientation which is one of
     * {@link #ORIENTATION_LANDSCAPE} or {@link #ORIENTATION_PORTRAIT}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.687 -0400", hash_original_method = "6BA82D6B625174A8AC80664141F0D361", hash_generated_method = "BD403A9700920A99F22D5BAAE290999D")
    
public int getOrientation() {
        return mOrientation;
    }

    /**
     * Gets the color mode with which the image will be printed.
     *
     * @return The color mode which is one of {@link #COLOR_MODE_COLOR}
     * and {@link #COLOR_MODE_MONOCHROME}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.693 -0400", hash_original_method = "36D12AF97D8587DD3CA677862F4AAD34", hash_generated_method = "994FA1D223BDF2E3402F4149BDD61803")
    
public int getColorMode() {
        return mColorMode;
    }

    /**
     * Prints a bitmap.
     *
     * @param jobName The print job name.
     * @param bitmap  The bitmap to print.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.740 -0400", hash_original_method = "C03CE6C0B4BDE86A0992EDA9C1D12921", hash_generated_method = "6CB0D5F59B6360A2C46A725C72295DDA")
    
public void printBitmap(final String jobName, final Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        final int fittingMode = mScaleMode; // grab the fitting mode at time of call
        PrintManager printManager = (PrintManager) mContext.getSystemService(Context.PRINT_SERVICE);
        PrintAttributes.MediaSize mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
        if (bitmap.getWidth() > bitmap.getHeight()) {
            mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
        }
        PrintAttributes attr = new PrintAttributes.Builder()
                .setMediaSize(mediaSize)
                .setColorMode(mColorMode)
                .build();

        printManager.print(jobName,
                new PrintDocumentAdapter() {
                    private PrintAttributes mAttributes;

                    @Override
                    public void onLayout(PrintAttributes oldPrintAttributes,
                                         PrintAttributes newPrintAttributes,
                                         CancellationSignal cancellationSignal,
                                         LayoutResultCallback layoutResultCallback,
                                         Bundle bundle) {

                        mAttributes = newPrintAttributes;

                        PrintDocumentInfo info = new PrintDocumentInfo.Builder(jobName)
                                .setContentType(PrintDocumentInfo.CONTENT_TYPE_PHOTO)
                                .setPageCount(1)
                                .build();
                        boolean changed = !newPrintAttributes.equals(oldPrintAttributes);
                        layoutResultCallback.onLayoutFinished(info, changed);
                    }

                    @Override
                    public void onWrite(PageRange[] pageRanges, ParcelFileDescriptor fileDescriptor,
                                        CancellationSignal cancellationSignal,
                                        WriteResultCallback writeResultCallback) {
                        PrintedPdfDocument pdfDocument = new PrintedPdfDocument(mContext,
                                mAttributes);
                        try {
                            Page page = pdfDocument.startPage(1);

                            RectF content = new RectF(page.getInfo().getContentRect());

                            Matrix matrix = getMatrix(bitmap.getWidth(), bitmap.getHeight(),
                                    content, fittingMode);

                            // Draw the bitmap.
                            page.getCanvas().drawBitmap(bitmap, matrix, null);

                            // Finish the page.
                            pdfDocument.finishPage(page);

                            try {
                                // Write the document.
                                pdfDocument.writeTo(new FileOutputStream(
                                        fileDescriptor.getFileDescriptor()));
                                // Done.
                                writeResultCallback.onWriteFinished(
                                        new PageRange[]{PageRange.ALL_PAGES});
                            } catch (IOException ioe) {
                                // Failed.
                                Log.e(LOG_TAG, "Error writing printed content", ioe);
                                writeResultCallback.onWriteFailed(null);
                            }
                        } finally {
                            if (pdfDocument != null) {
                                pdfDocument.close();
                            }
                            if (fileDescriptor != null) {
                                try {
                                    fileDescriptor.close();
                                } catch (IOException ioe) {
                                    /* ignore */
                                }
                            }
                        }
                    }
                }, attr);
    }

    /**
     * Calculates the transform the print an Image to fill the page
     *
     * @param imageWidth  with of bitmap
     * @param imageHeight height of bitmap
     * @param content     The output page dimensions
     * @param fittingMode The mode of fitting {@link #SCALE_MODE_FILL} vs {@link #SCALE_MODE_FIT}
     * @return Matrix to be used in canvas.drawBitmap(bitmap, matrix, null) call
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.750 -0400", hash_original_method = "945A952854711429C92EA555514B4F60", hash_generated_method = "614361F1D604EF74823028183B898141")
    
private Matrix getMatrix(int imageWidth, int imageHeight, RectF content, int fittingMode) {
        Matrix matrix = new Matrix();

        // Compute and apply scale to fill the page.
        float scale = content.width() / imageWidth;
        if (fittingMode == SCALE_MODE_FILL) {
            scale = Math.max(scale, content.height() / imageHeight);
        } else {
            scale = Math.min(scale, content.height() / imageHeight);
        }
        matrix.postScale(scale, scale);

        // Center the content.
        final float translateX = (content.width()
                - imageWidth * scale) / 2;
        final float translateY = (content.height()
                - imageHeight * scale) / 2;
        matrix.postTranslate(translateX, translateY);
        return matrix;
    }

    /**
     * Prints an image located at the Uri. Image types supported are those of
     * <code>BitmapFactory.decodeStream</code> (JPEG, GIF, PNG, BMP, WEBP)
     *
     * @param jobName   The print job name.
     * @param imageFile The <code>Uri</code> pointing to an image to print.
     * @throws FileNotFoundException if <code>Uri</code> is not pointing to a valid image.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.871 -0400", hash_original_method = "26AA80910AB549358B100D7C1531A95F", hash_generated_method = "2F887FE87D7F65D69528FB233FF11C96")
    
public void printBitmap(final String jobName, final Uri imageFile)
            throws FileNotFoundException {
        final int fittingMode = mScaleMode;

        PrintDocumentAdapter printDocumentAdapter = new PrintDocumentAdapter() {
            private PrintAttributes mAttributes;
            AsyncTask<Uri, Boolean, Bitmap> loadBitmap;
            Bitmap mBitmap = null;

            @Override
            public void onLayout(final PrintAttributes oldPrintAttributes,
                                 final PrintAttributes newPrintAttributes,
                                 final CancellationSignal cancellationSignal,
                                 final LayoutResultCallback layoutResultCallback,
                                 Bundle bundle) {
                if (cancellationSignal.isCanceled()) {
                    layoutResultCallback.onLayoutCancelled();
                    mAttributes = newPrintAttributes;
                    return;
                }
                // we finished the load
                if (mBitmap != null) {
                    PrintDocumentInfo info = new PrintDocumentInfo.Builder(jobName)
                            .setContentType(PrintDocumentInfo.CONTENT_TYPE_PHOTO)
                            .setPageCount(1)
                            .build();
                    boolean changed = !newPrintAttributes.equals(oldPrintAttributes);
                    layoutResultCallback.onLayoutFinished(info, changed);
                    return;
                }

                loadBitmap = new AsyncTask<Uri, Boolean, Bitmap>() {

                    @DSSafe(DSCat.SAFE_LIST)
            @Override
                    protected void onPreExecute() {
                        // First register for cancellation requests.
                        cancellationSignal.setOnCancelListener(
                                new CancellationSignal.OnCancelListener() {
                                    @Override
                                    public void onCancel() { // on different thread
                                        cancelLoad();
                                        cancel(false);
                                    }
                                });
                    }

                    @Override
                    protected Bitmap doInBackground(Uri... uris) {
                        try {
                            return loadConstrainedBitmap(imageFile, MAX_PRINT_SIZE);
                        } catch (FileNotFoundException e) {
                          /* ignore */
                        }
                        return null;
                    }

                    @DSSafe(DSCat.SAFE_LIST)
            @Override
                    protected void onPostExecute(Bitmap bitmap) {
                        super.onPostExecute(bitmap);
                        mBitmap = bitmap;
                        if (bitmap != null) {
                            PrintDocumentInfo info = new PrintDocumentInfo.Builder(jobName)
                                    .setContentType(PrintDocumentInfo.CONTENT_TYPE_PHOTO)
                                    .setPageCount(1)
                                    .build();
                            boolean changed = !newPrintAttributes.equals(oldPrintAttributes);

                            layoutResultCallback.onLayoutFinished(info, changed);

                        } else {
                            layoutResultCallback.onLayoutFailed(null);
                        }
                    }

                    @DSSafe(DSCat.SAFE_LIST)
            @Override
                    protected void onCancelled(Bitmap result) {
                        // Task was cancelled, report that.
                        layoutResultCallback.onLayoutCancelled();
                    }
                };
                loadBitmap.execute();

                mAttributes = newPrintAttributes;
            }

            private void cancelLoad() {
                synchronized (mLock) { // prevent race with set null below
                    if (mDecodeOptions != null) {
                        mDecodeOptions.requestCancelDecode();
                        mDecodeOptions = null;
                    }
                }
            }

            @Override
            public void onFinish() {
                super.onFinish();
                cancelLoad();
                loadBitmap.cancel(true);
            }

            @Override
            public void onWrite(PageRange[] pageRanges, ParcelFileDescriptor fileDescriptor,
                                CancellationSignal cancellationSignal,
                                WriteResultCallback writeResultCallback) {
                PrintedPdfDocument pdfDocument = new PrintedPdfDocument(mContext,
                        mAttributes);
                try {

                    Page page = pdfDocument.startPage(1);
                    RectF content = new RectF(page.getInfo().getContentRect());

                    // Compute and apply scale to fill the page.
                    Matrix matrix = getMatrix(mBitmap.getWidth(), mBitmap.getHeight(),
                            content, fittingMode);

                    // Draw the bitmap.
                    page.getCanvas().drawBitmap(mBitmap, matrix, null);

                    // Finish the page.
                    pdfDocument.finishPage(page);

                    try {
                        // Write the document.
                        pdfDocument.writeTo(new FileOutputStream(
                                fileDescriptor.getFileDescriptor()));
                        // Done.
                        writeResultCallback.onWriteFinished(
                                new PageRange[]{PageRange.ALL_PAGES});
                    } catch (IOException ioe) {
                        // Failed.
                        Log.e(LOG_TAG, "Error writing printed content", ioe);
                        writeResultCallback.onWriteFailed(null);
                    }
                } finally {
                    if (pdfDocument != null) {
                        pdfDocument.close();
                    }
                    if (fileDescriptor != null) {
                        try {
                            fileDescriptor.close();
                        } catch (IOException ioe) {
                            /* ignore */
                        }
                    }
                }
            }
        };

        PrintManager printManager = (PrintManager) mContext.getSystemService(Context.PRINT_SERVICE);
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(mColorMode);

        if (mOrientation == ORIENTATION_LANDSCAPE) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (mOrientation == ORIENTATION_PORTRAIT) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        PrintAttributes attr = builder.build();

        printManager.print(jobName, printDocumentAdapter, attr);
    }

    /**
     * Loads a bitmap while limiting its size
     *
     * @param uri           location of a valid image
     * @param maxSideLength the maximum length of a size
     * @return the Bitmap
     * @throws FileNotFoundException if the Uri does not point to an image
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.881 -0400", hash_original_method = "E45D810E27DEB8EDDA67451B15978E84", hash_generated_method = "A5B6C243EF046598C8D2E0E941E8B4F5")
    
private Bitmap loadConstrainedBitmap(Uri uri, int maxSideLength) throws FileNotFoundException {
        if (maxSideLength <= 0 || uri == null || mContext == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        // Get width and height of stored bitmap
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inJustDecodeBounds = true;
        loadBitmap(uri, opt);

        int w = opt.outWidth;
        int h = opt.outHeight;

        // If bitmap cannot be decoded, return null
        if (w <= 0 || h <= 0) {
            return null;
        }

        // Find best downsampling size
        int imageSide = Math.max(w, h);

        int sampleSize = 1;
        while (imageSide > maxSideLength) {
            imageSide >>>= 1;
            sampleSize <<= 1;
        }

        // Make sure sample size is reasonable
        if (sampleSize <= 0 || 0 >= (int) (Math.min(w, h) / sampleSize)) {
            return null;
        }
        BitmapFactory.Options decodeOptions = null;
        synchronized (mLock) { // prevent race with set null below
            mDecodeOptions = new BitmapFactory.Options();
            mDecodeOptions.inMutable = true;
            mDecodeOptions.inSampleSize = sampleSize;
            decodeOptions = mDecodeOptions;
        }
        try {
            return loadBitmap(uri, decodeOptions);
        } finally {
            synchronized (mLock) {
                mDecodeOptions = null;
            }
        }
    }

    /**
     * Returns the bitmap from the given uri loaded using the given options.
     * Returns null on failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:18.887 -0400", hash_original_method = "D07BA372213C37876FFC4CE01F67E27E", hash_generated_method = "C7294A02A01D12F8A4E071D78384383D")
    
private Bitmap loadBitmap(Uri uri, BitmapFactory.Options o) throws FileNotFoundException {
        if (uri == null || mContext == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        InputStream is = null;
        try {
            is = mContext.getContentResolver().openInputStream(uri);
            return BitmapFactory.decodeStream(is, null, o);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException t) {
                    Log.w(LOG_TAG, "close fail ", t);
                }
            }
        }
    }
}