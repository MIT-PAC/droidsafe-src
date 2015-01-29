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

package android.printservice;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.print.PrintDocumentInfo;
import android.print.PrintJobId;
import android.util.Log;

import java.io.IOException;

/**
 * This class represents a printed document from the perspective of a print
 * service. It exposes APIs to query the document and obtain its data.
 * <p>
 * <strong>Note: </strong> All methods of this class must be executed on the
 * main application thread.
 * </p>
 */
public final class PrintDocument {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.387 -0400", hash_original_field = "BB0A5F6FD85AFD70F2A85B8FC4A8D768", hash_generated_field = "FED1C9BEF2FC8134AE64FA0406ACD5A5")


    private static final String LOG_TAG = "PrintDocument";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.387 -0400", hash_original_field = "D370372517F00BD7728D040C339A9626", hash_generated_field = "E0B13E0FEC774016F8800671B6C67481")


    private  PrintJobId mPrintJobId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.388 -0400", hash_original_field = "A52A98A1947BB78D504A417FBBA83B44", hash_generated_field = "909B435CFC9A1FF432407D21F910719A")


    private  IPrintServiceClient mPrintServiceClient;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.389 -0400", hash_original_field = "58C8F1C002992BA0F5800CCDB2F34E28", hash_generated_field = "FD48DFD0875E504B4F6AA5D110CFA94A")


    private  PrintDocumentInfo mInfo;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.390 -0400", hash_original_method = "45900A847073FFCB79E3F2CECCF69725", hash_generated_method = "45900A847073FFCB79E3F2CECCF69725")
    
PrintDocument(PrintJobId printJobId, IPrintServiceClient printServiceClient,
            PrintDocumentInfo info) {
        mPrintJobId = printJobId;
        mPrintServiceClient = printServiceClient;
        mInfo = info;
    }

    /**
     * Gets the {@link PrintDocumentInfo} that describes this document.
     *
     * @return The document info.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.391 -0400", hash_original_method = "5D58E30432F15641BD8AE3D9855C014B", hash_generated_method = "0F81C77DAA377B3469E9BD690D31CE0F")
    
public PrintDocumentInfo getInfo() {
        PrintService.throwIfNotCalledOnMainThread();
        return mInfo;
    }

    /**
     * Gets the data associated with this document.
     * <p>
     * <strong>Note: </strong> It is a responsibility of the client to open a
     * stream to the returned file descriptor, fully read the data, and close
     * the file descriptor.
     * </p>
     *
     * @return A file descriptor for reading the data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.392 -0400", hash_original_method = "001216579A77DBE88BA86C9ABC614F5D", hash_generated_method = "E79765A5761739D0E2C91D847429FCC7")
    
public ParcelFileDescriptor getData() {
        PrintService.throwIfNotCalledOnMainThread();
        ParcelFileDescriptor source = null;
        ParcelFileDescriptor sink = null;
        try {
            ParcelFileDescriptor[] fds = ParcelFileDescriptor.createPipe();
            source = fds[0];
            sink = fds[1];
            mPrintServiceClient.writePrintJobData(sink, mPrintJobId);
            return source;
        } catch (IOException ioe) {
            Log.e(LOG_TAG, "Error calling getting print job data!", ioe);
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error calling getting print job data!", re);
        } finally {
            if (sink != null) {
                try {
                    sink.close();
                } catch (IOException ioe) {
                    /* ignore */
                }
            }
        }
        return null;
    }
}
