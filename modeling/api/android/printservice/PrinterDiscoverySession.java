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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.printservice;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.pm.ParceledListSlice;
import android.os.RemoteException;
import android.print.PrinterCapabilitiesInfo;
import android.print.PrinterId;
import android.print.PrinterInfo;
import java.util.HashMap;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class encapsulates the interaction between a print service and the
 * system during printer discovery. During printer discovery you are responsible
 * for adding discovered printers, removing previously added printers that
 * disappeared, and updating already added printers.
 * <p>
 * During the lifetime of this session you may be asked to start and stop
 * performing printer discovery multiple times. You will receive a call to {@link
 * PrinterDiscoverySession#onStartPrinterDiscovery(List)} to start printer
 * discovery and a call to {@link PrinterDiscoverySession#onStopPrinterDiscovery()}
 * to stop printer discovery. When the system is no longer interested in printers
 * discovered by this session you will receive a call to {@link #onDestroy()} at
 * which point the system will no longer call into the session and all the session
 * methods will do nothing.
 * </p>
 * <p>
 * Discovered printers are added by invoking {@link
 * PrinterDiscoverySession#addPrinters(List)}. Added printers that disappeared are
 * removed by invoking {@link PrinterDiscoverySession#removePrinters(List)}. Added
 * printers whose properties or capabilities changed are updated through a call to
 * {@link PrinterDiscoverySession#addPrinters(List)}. The printers added in this
 * session can be acquired via {@link #getPrinters()} where the returned printers
 * will be an up-to-date snapshot of the printers that you reported during the
 * session. Printers are <strong>not</strong> persisted across sessions.
 * </p>
 * <p>
 * The system will make a call to {@link #onValidatePrinters(List)} if you
 * need to update some printers. It is possible that you add a printer without
 * specifying its capabilities. This enables you to avoid querying all discovered
 * printers for their capabilities, rather querying the capabilities of a printer
 * only if necessary. For example, the system will request that you update a printer
 * if it gets selected by the user. When validating printers you do not need to
 * provide the printers' capabilities but may do so.
 * </p>
 * <p>
 * If the system is interested in being constantly updated for the state of a
 * printer you will receive a call to {@link #onStartPrinterStateTracking(PrinterId)}
 * after which you will have to do a best effort to keep the system updated for
 * changes in the printer state and capabilities. You also <strong>must</strong>
 * update the printer capabilities if you did not provide them when adding it, or
 * the printer will be ignored. When the system is no longer interested in getting
 * updates for a printer you will receive a call to {@link #onStopPrinterStateTracking(
 * PrinterId)}.
 * </p>
 * <p>
 * <strong>Note: </strong> All callbacks in this class are executed on the main
 * application thread. You also have to invoke any method of this class on the main
 * application thread.
 * </p>
 */
public abstract class PrinterDiscoverySession {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.872 -0400", hash_original_field = "F213E9B0B15A7F94EB368683ED8C77B1", hash_generated_field = "5582551CC79C4BE561ADB324D3853026")

    private static final String LOG_TAG = "PrinterDiscoverySession";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.873 -0400", hash_original_field = "CC412B94DF87193A29C55A575AEB6213", hash_generated_field = "C1F242C61A8C91E2A8CF031CB9EBF8A1")


    private static int sIdCounter = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.874 -0400", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")


    private  int mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.875 -0400", hash_original_field = "518A4438BCE648DAF663DD9386C7AE4C", hash_generated_field = "F6ABFA85F60E9DB67D36F5509E9B392E")


    private final HashMap<PrinterId, PrinterInfo> mPrinters =
            new HashMap<PrinterId, PrinterInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.876 -0400", hash_original_field = "FB21865E86A33ED58D28CBB28A1EDD69", hash_generated_field = "66DA58C56504AA62294C8EA9D4B53ABF")


    private final List<PrinterId> mTrackedPrinters =
            new ArrayList<PrinterId>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.877 -0400", hash_original_field = "0CCAAAE02FEB8B3CEF9167F18D915317", hash_generated_field = "2DA5B1992826B760F786D81EF3B5EBB6")


    private HashMap<PrinterId, PrinterInfo> mLastSentPrinters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.878 -0400", hash_original_field = "17061EA997B782C96AD7A356C37CCE62", hash_generated_field = "C99FC062C4E35C65BC6FB38E23AED863")


    private IPrintServiceClient mObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.878 -0400", hash_original_field = "366D7968C5A05C1871E7DC0075AAC007", hash_generated_field = "9F6322706166F1469322EAA683C1EDEE")


    private boolean mIsDestroyed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.879 -0400", hash_original_field = "6CA3AB25786FD10123B8BDF5D68DAEC8", hash_generated_field = "D68247305DCCA18FF9BB746683CAE724")


    private boolean mIsDiscoveryStarted;

    /**
     * Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.881 -0400", hash_original_method = "6902158E2056477F2CDBEFB4DAA306E5", hash_generated_method = "38CBFE4C6F9ABC16D50910D77F08CBEA")
    
public PrinterDiscoverySession() {
        mId = sIdCounter++;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.882 -0400", hash_original_method = "070C52E4D8CA9964C23AE9195F8859CC", hash_generated_method = "C9F942E7152FE6B840711D95D2A40D92")
    
void setObserver(IPrintServiceClient observer) {
        mObserver = observer;
        // If some printers were added in the method that
        // created the session, send them over.
        if (!mPrinters.isEmpty()) {
            try {
                mObserver.onPrintersAdded(new ParceledListSlice<PrinterInfo>(getPrinters()));
            } catch (RemoteException re) {
                Log.e(LOG_TAG, "Error sending added printers", re);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.882 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "849E83C6BA01C72387E236CA4FAA38B9")
    
int getId() {
        return mId;
    }

    /**
     * Gets the printers reported in this session. For example, if you add two
     * printers and remove one of them, the returned list will contain only
     * the printer that was added but not removed.
     * <p>
     * <strong>Note: </strong> Calls to this method after the session is
     * destroyed, that is after the {@link #onDestroy()} callback, will be ignored.
     * </p>
     *
     * @return The printers.
     *
     * @see #addPrinters(List)
     * @see #removePrinters(List)
     * @see #isDestroyed()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.883 -0400", hash_original_method = "1A925D240DD97722A300E4DC3A67FBB4", hash_generated_method = "89E31B17B5220171A9E93FEBDC66B6A3")
    
public final List<PrinterInfo> getPrinters() {
        PrintService.throwIfNotCalledOnMainThread();
        if (mIsDestroyed) {
            return Collections.emptyList();
        }
        return new ArrayList<PrinterInfo>(mPrinters.values());
    }

    /**
     * Adds discovered printers. Adding an already added printer updates it.
     * Removed printers can be added again. You can call this method multiple
     * times during the life of this session. Duplicates will be ignored.
     * <p>
     * <strong>Note: </strong> Calls to this method after the session is
     * destroyed, that is after the {@link #onDestroy()} callback, will be ignored.
     * </p>
     *
     * @param printers The printers to add.
     *
     * @see #removePrinters(List)
     * @see #getPrinters()
     * @see #isDestroyed()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.886 -0400", hash_original_method = "EA98A079FB48B33D035E1375B90EFCB4", hash_generated_method = "39FA08C1E1AF0B13E5FCF801ED1899F0")
    
public final void addPrinters(List<PrinterInfo> printers) {
        PrintService.throwIfNotCalledOnMainThread();

        // If the session is destroyed - nothing do to.
        if (mIsDestroyed) {
            Log.w(LOG_TAG, "Not adding printers - session destroyed.");
            return;
        }

        if (mIsDiscoveryStarted) {
            // If during discovery, add the new printers and send them.
            List<PrinterInfo> addedPrinters = null;
            final int addedPrinterCount = printers.size();
            for (int i = 0; i < addedPrinterCount; i++) {
                PrinterInfo addedPrinter = printers.get(i);
                PrinterInfo oldPrinter = mPrinters.put(addedPrinter.getId(), addedPrinter);
                if (oldPrinter == null || !oldPrinter.equals(addedPrinter)) {
                    if (addedPrinters == null) {
                        addedPrinters = new ArrayList<PrinterInfo>();
                    }
                    addedPrinters.add(addedPrinter);
                }
            }

            // Send the added printers, if such.
            if (addedPrinters != null) {
                try {
                    mObserver.onPrintersAdded(new ParceledListSlice<PrinterInfo>(addedPrinters));
                } catch (RemoteException re) {
                    Log.e(LOG_TAG, "Error sending added printers", re);
                }
            }
        } else {
            // Remember the last sent printers if needed.
            if (mLastSentPrinters == null) {
                mLastSentPrinters = new HashMap<PrinterId, PrinterInfo>(mPrinters);
            }

            // Update the printers.
            final int addedPrinterCount = printers.size();
            for (int i = 0; i < addedPrinterCount; i++) {
                PrinterInfo addedPrinter = printers.get(i);
                if (mPrinters.get(addedPrinter.getId()) == null) {
                    mPrinters.put(addedPrinter.getId(), addedPrinter);
                }
            }
        }
    }

    /**
     * Removes added printers. Removing an already removed or never added
     * printer has no effect. Removed printers can be added again. You can
     * call this method multiple times during the lifetime of this session.
     * <p>
     * <strong>Note: </strong> Calls to this method after the session is
     * destroyed, that is after the {@link #onDestroy()} callback, will be ignored.
     * </p>
     *
     * @param printerIds The ids of the removed printers.
     *
     * @see #addPrinters(List)
     * @see #getPrinters()
     * @see #isDestroyed()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.887 -0400", hash_original_method = "80B743CAA1B9D3D19FA82DE387F241B3", hash_generated_method = "A4A1A7EE3BD3D14E910DAAFC96767A1F")
    
public final void removePrinters(List<PrinterId> printerIds) {
        PrintService.throwIfNotCalledOnMainThread();

        // If the session is destroyed - nothing do to.
        if (mIsDestroyed) {
            Log.w(LOG_TAG, "Not removing printers - session destroyed.");
            return;
        }

        if (mIsDiscoveryStarted) {
            // If during discovery, remove existing printers and send them.
            List<PrinterId> removedPrinterIds = new ArrayList<PrinterId>();
            final int removedPrinterIdCount = printerIds.size();
            for (int i = 0; i < removedPrinterIdCount; i++) {
                PrinterId removedPrinterId = printerIds.get(i);
                if (mPrinters.remove(removedPrinterId) != null) {
                    removedPrinterIds.add(removedPrinterId);
                }
            }

            // Send the removed printers, if such.
            if (!removedPrinterIds.isEmpty()) {
                try {
                    mObserver.onPrintersRemoved(new ParceledListSlice<PrinterId>(
                            removedPrinterIds));
                } catch (RemoteException re) {
                    Log.e(LOG_TAG, "Error sending removed printers", re);
                }
            }
        } else {
            // Remember the last sent printers if needed.
            if (mLastSentPrinters == null) {
                mLastSentPrinters = new HashMap<PrinterId, PrinterInfo>(mPrinters);
            }

            // Update the printers.
            final int removedPrinterIdCount = printerIds.size();
            for (int i = 0; i < removedPrinterIdCount; i++) {
                PrinterId removedPrinterId = printerIds.get(i);
                mPrinters.remove(removedPrinterId);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.889 -0400", hash_original_method = "B5C8F78F310C1CF2B219AAF6F04CD7B1", hash_generated_method = "4802504E72CF2662A01EC9E3B2D349E9")
    
private void sendOutOfDiscoveryPeriodPrinterChanges() {
        // Noting changed since the last discovery period - nothing to do.
        if (mLastSentPrinters == null || mLastSentPrinters.isEmpty()) {
            mLastSentPrinters = null;
            return;
        }

        // Determine the added printers.
        List<PrinterInfo> addedPrinters = null;
        for (PrinterInfo printer : mPrinters.values()) {
            PrinterInfo sentPrinter = mLastSentPrinters.get(printer.getId());
            if (sentPrinter == null || !sentPrinter.equals(printer)) {
                if (addedPrinters == null) {
                    addedPrinters = new ArrayList<PrinterInfo>();
                }
                addedPrinters.add(printer);
            }
        }

        // Send the added printers, if such.
        if (addedPrinters != null) {
            try {
                mObserver.onPrintersAdded(new ParceledListSlice<PrinterInfo>(addedPrinters));
            } catch (RemoteException re) {
                Log.e(LOG_TAG, "Error sending added printers", re);
            }
        }

        // Determine the removed printers.
        List<PrinterId> removedPrinterIds = null;
        for (PrinterInfo sentPrinter : mLastSentPrinters.values()) {
            if (!mPrinters.containsKey(sentPrinter.getId())) {
                if (removedPrinterIds == null) {
                    removedPrinterIds = new ArrayList<PrinterId>();
                }
                removedPrinterIds.add(sentPrinter.getId());
            }
        }

        // Send the removed printers, if such.
        if (removedPrinterIds != null) {
            try {
                mObserver.onPrintersRemoved(new ParceledListSlice<PrinterId>(removedPrinterIds));
            } catch (RemoteException re) {
                Log.e(LOG_TAG, "Error sending removed printers", re);
            }
        }

        mLastSentPrinters = null;
    }

    /**
     * Callback asking you to start printer discovery. Discovered printers should be
     * added via calling {@link #addPrinters(List)}. Added printers that disappeared
     * should be removed via calling {@link #removePrinters(List)}. Added printers
     * whose properties or capabilities changed should be updated via calling {@link
     * #addPrinters(List)}. You will receive a call to {@link #onStopPrinterDiscovery()}
     * when you should stop printer discovery.
     * <p>
     * During the lifetime of this session all printers that are known to your print
     * service have to be added. The system does not retain any printers across sessions.
     * However, if you were asked to start and then stop performing printer discovery
     * in this session, then a subsequent discovering should not re-discover already
     * discovered printers. You can get the printers reported during this session by
     * calling {@link #getPrinters()}.
     * </p>
     * <p>
     * <strong>Note: </strong>You are also given a list of printers whose availability
     * has to be checked first. For example, these printers could be the user's favorite
     * ones, therefore they have to be verified first. You do <strong>not need</strong>
     * to provide the capabilities of the printers, rather verify whether they exist
     * similarly to {@link #onValidatePrinters(List)}.
     * </p>
     *
     * @param priorityList The list of printers to validate first. Never null.
     *
     * @see #onStopPrinterDiscovery()
     * @see #addPrinters(List)
     * @see #removePrinters(List)
     * @see #isPrinterDiscoveryStarted()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.890 -0400", hash_original_method = "4D5B915A3546534CAFF5F64EE0FBF872", hash_generated_method = "C293D1E6123751D9DEE09395C4D0D38F")
    
public abstract void onStartPrinterDiscovery(List<PrinterId> priorityList);

    /**
     * Callback notifying you that you should stop printer discovery.
     *
     * @see #onStartPrinterDiscovery(List)
     * @see #isPrinterDiscoveryStarted()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.891 -0400", hash_original_method = "88D53430D89B2A464C2974BD77DD09D8", hash_generated_method = "2A2CCCD8847EC4665BCD7C8D20001AAE")
    
public abstract void onStopPrinterDiscovery();

    /**
     * Callback asking you to validate that the given printers are valid, that
     * is they exist. You are responsible for checking whether these printers
     * exist and for the ones that do exist notify the system via calling
     * {@link #addPrinters(List)}.
     * <p>
     * <strong>Note: </strong> You are <strong>not required</strong> to provide
     * the printer capabilities when updating the printers that do exist.
     * <p>
     *
     * @param printerIds The printers to validate.
     *
     * @see PrinterInfo.Builder#setCapabilities(PrinterCapabilitiesInfo)
     *      PrinterInfo.Builder.setCapabilities(PrinterCapabilitiesInfo)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.892 -0400", hash_original_method = "C5A2EB899B2EF87051DB7AF7EBFEC323", hash_generated_method = "6FE96B9235876DD0A4307D1C3B1ECB5B")
    
public abstract void onValidatePrinters(List<PrinterId> printerIds);

    /**
     * Callback asking you to start tracking the state of a printer. Tracking
     * the state means that you should do a best effort to observe the state
     * of this printer and notify the system if that state changes via calling
     * {@link #addPrinters(List)}.
     * <p>
     * <strong>Note: </strong> A printer can be initially added without its
     * capabilities to avoid polling printers that the user will not select.
     * However, after this method is called you are expected to update the
     * printer <strong>including</strong> its capabilities. Otherwise, the
     * printer will be ignored.
     * <p>
     * <p>
     * A scenario when you may be requested to track a printer's state is if
     * the user selects that printer and the system has to present print
     * options UI based on the printer's capabilities. In this case the user
     * should be promptly informed if, for example, the printer becomes
     * unavailable.
     * </p>
     *
     * @param printerId The printer to start tracking.
     *
     * @see #onStopPrinterStateTracking(PrinterId)
     * @see PrinterInfo.Builder#setCapabilities(PrinterCapabilitiesInfo)
     *      PrinterInfo.Builder.setCapabilities(PrinterCapabilitiesInfo)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.893 -0400", hash_original_method = "C5A4ECDE73D6C094D432CB8FFC6E911D", hash_generated_method = "9F4CC5C39D7E0EEBBAE5B65BD9C2FD85")
    
public abstract void onStartPrinterStateTracking(PrinterId printerId);

    /**
     * Callback asking you to stop tracking the state of a printer. The passed
     * in printer id is the one for which you received a call to {@link
     * #onStartPrinterStateTracking(PrinterId)}.
     *
     * @param printerId The printer to stop tracking.
     *
     * @see #onStartPrinterStateTracking(PrinterId)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.894 -0400", hash_original_method = "F3DEB30E245DDEFBC63BBCD2E029B7F8", hash_generated_method = "4017F4424C0AC63D21B102A19D8F0835")
    
public abstract void onStopPrinterStateTracking(PrinterId printerId);

    /**
     * Gets the printers that should be tracked. These are printers that are
     * important to the user and for which you received a call to {@link
     * #onStartPrinterStateTracking(PrinterId)} asking you to observer their
     * state and reporting it to the system via {@link #addPrinters(List)}.
     * You will receive a call to {@link #onStopPrinterStateTracking(PrinterId)}
     * if you should stop tracking a printer.
     * <p>
     * <strong>Note: </strong> Calls to this method after the session is
     * destroyed, that is after the {@link #onDestroy()} callback, will be ignored.
     * </p>
     *
     * @return The printers.
     *
     * @see #onStartPrinterStateTracking(PrinterId)
     * @see #onStopPrinterStateTracking(PrinterId)
     * @see #isDestroyed()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.895 -0400", hash_original_method = "DCC7DD41BB2D66B14D2E2AFBADB3529C", hash_generated_method = "ED8A315FC39EA7C2DD6FC98FD8CE8EB5")
    
public final List<PrinterId> getTrackedPrinters() {
        PrintService.throwIfNotCalledOnMainThread();
        if (mIsDestroyed) {
            return Collections.emptyList();
        }
        return new ArrayList<PrinterId>(mTrackedPrinters);
    }

    /**
     * Notifies you that the session is destroyed. After this callback is invoked
     * any calls to the methods of this class will be ignored, {@link #isDestroyed()}
     * will return true and you will also no longer receive callbacks.
     *
     * @see #isDestroyed()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.896 -0400", hash_original_method = "7652BA68F2F95D0B298F4EB3465DFE61", hash_generated_method = "3754EFD6C42A34DFCC356A74A5321908")
    
public abstract void onDestroy();

    /**
     * Gets whether the session is destroyed.
     *
     * @return Whether the session is destroyed.
     *
     * @see #onDestroy()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.897 -0400", hash_original_method = "B1D05E18E98834AE4104C1CCF2458928", hash_generated_method = "B4A78C44FE7A30291A147C9F9F7FC09A")
    
public final boolean isDestroyed() {
        PrintService.throwIfNotCalledOnMainThread();
        return mIsDestroyed;
    }

    /**
     * Gets whether printer discovery is started.
     *
     * @return Whether printer discovery is destroyed.
     *
     * @see #onStartPrinterDiscovery(List)
     * @see #onStopPrinterDiscovery()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.898 -0400", hash_original_method = "35A8D5C1877AB7B2E3BF6FD4263929BC", hash_generated_method = "9768915F2A0AB2E960D0B9147D092C26")
    
public final boolean isPrinterDiscoveryStarted() {
        PrintService.throwIfNotCalledOnMainThread();
        return mIsDiscoveryStarted;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.899 -0400", hash_original_method = "A24BB46F27B81FC719BA8AD6B00338D5", hash_generated_method = "A24BB46F27B81FC719BA8AD6B00338D5")
    
void startPrinterDiscovery(List<PrinterId> priorityList) {
        if (!mIsDestroyed) {
            mIsDiscoveryStarted = true;
            sendOutOfDiscoveryPeriodPrinterChanges();
            if (priorityList == null) {
                priorityList = Collections.emptyList();
            }
            onStartPrinterDiscovery(priorityList);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.900 -0400", hash_original_method = "84A635EF7E2372E8051B8C5A8996A644", hash_generated_method = "84A635EF7E2372E8051B8C5A8996A644")
    
void stopPrinterDiscovery() {
        if (!mIsDestroyed) {
            mIsDiscoveryStarted = false;
            onStopPrinterDiscovery();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.901 -0400", hash_original_method = "4E245E5B4555DCD264523CA68777C91D", hash_generated_method = "4E245E5B4555DCD264523CA68777C91D")
    
void validatePrinters(List<PrinterId> printerIds) {
        if (!mIsDestroyed && mObserver != null) {
            onValidatePrinters(printerIds);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.902 -0400", hash_original_method = "39B0C45B77C2EA75AA57CF3A1E8810D2", hash_generated_method = "39B0C45B77C2EA75AA57CF3A1E8810D2")
    
void startPrinterStateTracking(PrinterId printerId) {
        if (!mIsDestroyed && mObserver != null
                && !mTrackedPrinters.contains(printerId)) {
            mTrackedPrinters.add(printerId);
            onStartPrinterStateTracking(printerId);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.903 -0400", hash_original_method = "8C82159402DC159A0F791463B0CC627D", hash_generated_method = "8C82159402DC159A0F791463B0CC627D")
    
void stopPrinterStateTracking(PrinterId printerId) {
        if (!mIsDestroyed && mObserver != null
                && mTrackedPrinters.remove(printerId)) {
            onStopPrinterStateTracking(printerId);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.904 -0400", hash_original_method = "83AF01371322386AEA0F41521FEB8899", hash_generated_method = "83AF01371322386AEA0F41521FEB8899")
    
void destroy() {
        if (!mIsDestroyed) {
            mIsDestroyed = true;
            mIsDiscoveryStarted = false;
            mPrinters.clear();
            mLastSentPrinters = null;
            mObserver = null;
            onDestroy();
        }
    }
}
