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

package android.print;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import com.android.internal.R;

import libcore.io.IoUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Adapter for printing PDF files. This class could be useful if you
 * want to print a file and intercept when the system is ready
 * spooling the data, so you can delete the file if it is a
 * temporary one. To achieve this one must override {@link #onFinish()}
 * and delete the file yourself.
 *
 * @hide
 */
public class PrintFileDocumentAdapter extends PrintDocumentAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.612 -0400", hash_original_field = "5AB41584045BCE8716DF1431B1F42BE8", hash_generated_field = "B97272540E47C98A85FED9F7A5E16CB1")


    private static final String LOG_TAG = "PrintedFileDocumentAdapter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.613 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")


    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.614 -0400", hash_original_field = "03021E7FD9BC2DCB6A1E411C8B6DAF4A", hash_generated_field = "183611C0D8A74A7CE3F1C64EE45173DC")


    private  File mFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.615 -0400", hash_original_field = "6E88F63EE3F087A2B39FCA39D8A4C3AE", hash_generated_field = "B7A9A6BCBCFCDF28805320DA60BD3623")


    private  PrintDocumentInfo mDocumentInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.616 -0400", hash_original_field = "14B92F6C097C84C6E032733D018208A7", hash_generated_field = "CFB77CBECCB1E720E617E71B43B00468")


    private WriteFileAsyncTask mWriteFileAsyncTask;

    /**
     * Constructor.
     *
     * @param context Context for accessing resources.
     * @param file The PDF file to print.
     * @param documentInfo The information about the printed file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.617 -0400", hash_original_method = "CE1FD8CFCA8F75C70411D006E2B5D3EE", hash_generated_method = "129027FE469DE353B7F65A815CF66F79")
    
public PrintFileDocumentAdapter(Context context, File file,
            PrintDocumentInfo documentInfo) {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null!");
        }
        if (documentInfo == null) {
            throw new IllegalArgumentException("documentInfo cannot be null!");
        }
        mContext = context;
        mFile = file;
        mDocumentInfo = documentInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.618 -0400", hash_original_method = "9BADDDD396210C522348409E95B015A9", hash_generated_method = "8FF993C7DAFAEE6537A57F9BC9762622")
    
@Override
    public void onLayout(PrintAttributes oldAttributes, PrintAttributes newAttributes,
            CancellationSignal cancellationSignal, LayoutResultCallback callback,
            Bundle metadata) {
        callback.onLayoutFinished(mDocumentInfo, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.619 -0400", hash_original_method = "76E5A93E08E0937A180B9AC75AB49CCB", hash_generated_method = "33EFE514D58DB443118534AFCC8C01F3")
    
@Override
    public void onWrite(PageRange[] pages, ParcelFileDescriptor destination,
            CancellationSignal cancellationSignal, WriteResultCallback callback) {
        mWriteFileAsyncTask = new WriteFileAsyncTask(destination, cancellationSignal, callback);
        mWriteFileAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                (Void[]) null);
    }

    private final class WriteFileAsyncTask extends AsyncTask<Void, Void, Void> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.620 -0400", hash_original_field = "53062890D34A1B6E8BB0B52A9E463BCC", hash_generated_field = "BE20BABC762A72A5013F9C740C18EA67")


        private  ParcelFileDescriptor mDestination;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.621 -0400", hash_original_field = "D46C22944F0B87D0CEA112A9070BB61D", hash_generated_field = "D551F1AFAC2EABF7862A276D69DDA8C2")


        private  WriteResultCallback mResultCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.622 -0400", hash_original_field = "91B6D9BBFB750A3AFD2BA5D1D90A241A", hash_generated_field = "970CADA0BCDB23F45B08DEDA5C93F3D9")


        private  CancellationSignal mCancellationSignal;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.624 -0400", hash_original_method = "263562AB2843F8D5347718F51B07C692", hash_generated_method = "8C4FF48C6183561396E78A36A731CB04")
        
public WriteFileAsyncTask(ParcelFileDescriptor destination,
                CancellationSignal cancellationSignal, WriteResultCallback callback) {
            mDestination = destination;
            mResultCallback = callback;
            mCancellationSignal = cancellationSignal;
            mCancellationSignal.setOnCancelListener(new OnCancelListener() {
                @Override
                public void onCancel() {
                    cancel(true);
                }
            });
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.626 -0400", hash_original_method = "FA2C8064B67BA18407E210B8683E58F8", hash_generated_method = "2199A6A8E9ED752D58EBC10547B7C126")
        
@Override
        protected Void doInBackground(Void... params) {
            InputStream in = null;
            OutputStream out = new FileOutputStream(mDestination.getFileDescriptor());
            final byte[] buffer = new byte[8192];
            try {
                in = new FileInputStream(mFile);
                while (true) {
                    if (isCancelled()) {
                        break;
                    }
                    final int readByteCount = in.read(buffer);
                    if (readByteCount < 0) {
                        break;
                    }
                    out.write(buffer, 0, readByteCount);
                }
             } catch (IOException ioe) {
                 Log.e(LOG_TAG, "Error writing data!", ioe);
                 mResultCallback.onWriteFailed(mContext.getString(
                         R.string.write_fail_reason_cannot_write));
             } finally {
                IoUtils.closeQuietly(in);
                IoUtils.closeQuietly(out);
            }
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.627 -0400", hash_original_method = "9B54D06F5BCF00C6331DD0264B111609", hash_generated_method = "8DFCDDECF2C943370582C53A1D95E580")
        
@Override
        protected void onPostExecute(Void result) {
            mResultCallback.onWriteFinished(new PageRange[] {PageRange.ALL_PAGES});
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.629 -0400", hash_original_method = "9DE180FF1AD35980B549F8B1F2F022F1", hash_generated_method = "F66DCC1769D3607D1CF39E8F2C55CC78")
        
@Override
        protected void onCancelled(Void result) {
            mResultCallback.onWriteFailed(mContext.getString(
                    R.string.write_fail_reason_cancelled));
        }
    }
}

