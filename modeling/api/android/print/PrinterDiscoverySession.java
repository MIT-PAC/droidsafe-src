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


package android.print;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.pm.ParceledListSlice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import java.util.HashMap;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @hide
 */
public final class PrinterDiscoverySession {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.256 -0400", hash_original_field = "F213E9B0B15A7F94EB368683ED8C77B1", hash_generated_field = "5582551CC79C4BE561ADB324D3853026")

    private static final String LOG_TAG ="PrinterDiscoverySession";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.257 -0400", hash_original_field = "C93425EC302435009514C2F5B3714403", hash_generated_field = "A50BBBECE3947A00837DB9E56B57EC33")

    private static final int MSG_PRINTERS_ADDED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.258 -0400", hash_original_field = "1D9EE46D79362198A7E1997953B3399E", hash_generated_field = "AE3C75226E2AA21547158C77AE4CAB99")

    private static final int MSG_PRINTERS_REMOVED = 2;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.283 -0400", hash_original_method = "B708A18D934CB406171AFDD9F060C4E5", hash_generated_method = "C55302620447671355A0AB9936CDFF9D")
    
private static void throwIfNotCalledOnMainThread() {
        //if (!Looper.getMainLooper().isCurrentThread()) {
            throw new IllegalAccessError("must be called from the main thread");
            //}
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.259 -0400", hash_original_field = "79C1496B5817E07FB8C4972846B6412D", hash_generated_field = "F0C143CD3E903D6DD14F0379BED36E72")

    private final LinkedHashMap<PrinterId, PrinterInfo> mPrinters =
            new LinkedHashMap<PrinterId, PrinterInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.260 -0400", hash_original_field = "3E0022675B1FC4D16A302D6AB65630C0", hash_generated_field = "03F844E9A67F320205659153BAC1054D")

    private  IPrintManager mPrintManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.260 -0400", hash_original_field = "C1E985FEB03E95A460CF3F00CA1AC469", hash_generated_field = "92E61CD52E3EFA00E014EC0C6AF61282")

    private  int mUserId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.261 -0400", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private  Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.262 -0400", hash_original_field = "943FACF1193851215AB517CCEF11C68A", hash_generated_field = "75C0E28AA239ED722A4AB2324ED0D598")

    private IPrinterDiscoveryObserver mObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.263 -0400", hash_original_field = "DC23B31AE293A84E82CCB2EAE7A13F52", hash_generated_field = "9C0B5ED7B4C18F2A5CFECEA7A8FF6349")

    private OnPrintersChangeListener mListener;

    public static interface OnPrintersChangeListener {
        public void onPrintersChanged();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.264 -0400", hash_original_field = "E4A5433C2277CE89BFC06D05DBDF48A8", hash_generated_field = "CFCE5E3086EFB2C8EE3C3D2D51D844CE")

    private boolean mIsPrinterDiscoveryStarted;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.266 -0400", hash_original_method = "4B612439DC315BAEF1300931B7ADA3AD", hash_generated_method = "4B612439DC315BAEF1300931B7ADA3AD")
    
PrinterDiscoverySession(IPrintManager printManager, Context context, int userId) {
        mPrintManager = printManager;
        mUserId = userId;
        mHandler = new SessionHandler(context.getMainLooper());
        mObserver = new PrinterDiscoveryObserver(this);
        try {
            mPrintManager.createPrinterDiscoverySession(mObserver, mUserId);
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error creating printer discovery session", re);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.267 -0400", hash_original_method = "09CCA7B862CE357D24F7360649872BAB", hash_generated_method = "58FC98DEF03F04F971497F62D4A49502")
    
public final void startPrinterDisovery(List<PrinterId> priorityList) {
        if (isDestroyed()) {
            Log.w(LOG_TAG, "Ignoring start printers dsicovery - session destroyed");
            return;
        }
        if (!mIsPrinterDiscoveryStarted) {
            mIsPrinterDiscoveryStarted = true;
            try {
                mPrintManager.startPrinterDiscovery(mObserver, priorityList, mUserId);
            } catch (RemoteException re) {
                Log.e(LOG_TAG, "Error starting printer discovery", re);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.268 -0400", hash_original_method = "F3E7D875A6B869727E5820D042DD3BA1", hash_generated_method = "C4830D5956FC952AAD6477ED5A93F24A")
    
public final void stopPrinterDiscovery() {
        if (isDestroyed()) {
            Log.w(LOG_TAG, "Ignoring stop printers discovery - session destroyed");
            return;
        }
        if (mIsPrinterDiscoveryStarted) {
            mIsPrinterDiscoveryStarted = false;
            try {
                mPrintManager.stopPrinterDiscovery(mObserver, mUserId);
            } catch (RemoteException re) {
                Log.e(LOG_TAG, "Error stopping printer discovery", re);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.269 -0400", hash_original_method = "B5F66E91D4B755DD8B77833063EFF610", hash_generated_method = "43DDBF364434D1F824A645D7CF36447F")
    
public final void startPrinterStateTracking(PrinterId printerId) {
        if (isDestroyed()) {
            Log.w(LOG_TAG, "Ignoring start printer state tracking - session destroyed");
            return;
        }
        try {
            mPrintManager.startPrinterStateTracking(printerId, mUserId);
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error starting printer state tracking", re);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.270 -0400", hash_original_method = "085F094CE9B360F56064AC417FDD7B1C", hash_generated_method = "19F16ACA9FD0D306D0A576324D389DE3")
    
public final void stopPrinterStateTracking(PrinterId printerId) {
        if (isDestroyed()) {
            Log.w(LOG_TAG, "Ignoring stop printer state tracking - session destroyed");
            return;
        }
        try {
            mPrintManager.stopPrinterStateTracking(printerId, mUserId);
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error stoping printer state tracking", re);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.271 -0400", hash_original_method = "4DBB46FDF7DA5A0FCDDC9C612F311BBA", hash_generated_method = "ABDEA29E66C3B14AD4E4B4D1EC2849C2")
    
public final void validatePrinters(List<PrinterId> printerIds) {
        if (isDestroyed()) {
            Log.w(LOG_TAG, "Ignoring validate printers - session destroyed");
            return;
        }
        try {
            mPrintManager.validatePrinters(printerIds, mUserId);
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error validating printers", re);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.272 -0400", hash_original_method = "836AC8664E7C02791528C4BE81CEB95D", hash_generated_method = "2F43C1B00A271EC2DDAFF7803A1560BF")
    
public final void destroy() {
        if (isDestroyed()) {
            Log.w(LOG_TAG, "Ignoring destroy - session destroyed");
        }
        destroyNoCheck();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.273 -0400", hash_original_method = "A8260463B7B5DA13B3F430D5CEAA3F45", hash_generated_method = "B642871B216ED5803B716C1357CB5684")
    
public final List<PrinterInfo> getPrinters() {
        if (isDestroyed()) {
            Log.w(LOG_TAG, "Ignoring get printers - session destroyed");
            return Collections.emptyList();
        }
        return new ArrayList<PrinterInfo>(mPrinters.values());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.274 -0400", hash_original_method = "6451CD708474E2C6B067ADCB7B84C489", hash_generated_method = "61AF2761DE9E6B920E3341028B1A0DE4")
    
public final boolean isDestroyed() {
        throwIfNotCalledOnMainThread();
        return isDestroyedNoCheck();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.275 -0400", hash_original_method = "027E8695E03E714B8E37425E74C5144C", hash_generated_method = "C6451D3F784566A119F508958B37D277")
    
public final boolean isPrinterDiscoveryStarted() {
        throwIfNotCalledOnMainThread();
        return mIsPrinterDiscoveryStarted;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.276 -0400", hash_original_method = "C27BCB3942D1774087D72E41FE31D224", hash_generated_method = "CF0A1D509E98DC3815A568631BCE7919")
    
public final void setOnPrintersChangeListener(OnPrintersChangeListener listener) {
        throwIfNotCalledOnMainThread();
        mListener = listener;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.277 -0400", hash_original_method = "20B4C52C0388CA3F0A33A206A644475C", hash_generated_method = "FCF4C62479F83F8556FC5B56C49BF421")
    
@Override
    protected final void finalize() throws Throwable {
        if (!isDestroyedNoCheck()) {
            Log.e(LOG_TAG, "Destroying leaked printer discovery session");
            destroyNoCheck();
        }
        super.finalize();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.278 -0400", hash_original_method = "4FA97241EB9CCC0DFAB34DE7BC4A9AFD", hash_generated_method = "97967D3CD9654C8D68AA04144EA1991F")
    
private boolean isDestroyedNoCheck() {
        return (mObserver == null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.279 -0400", hash_original_method = "713A37598701EF02A040DD644329AFA9", hash_generated_method = "2B0DEF47A362BC2E99F05F3C5BBDE92C")
    
private void destroyNoCheck() {
        stopPrinterDiscovery();
        try {
            mPrintManager.destroyPrinterDiscoverySession(mObserver, mUserId);
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error destroying printer discovery session", re);
        } finally {
            mObserver = null;
            mPrinters.clear();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.280 -0400", hash_original_method = "02761DC1042D862423D8116ED3E76DFF", hash_generated_method = "3FC282ED9D9919784383C482F216C2B6")
    
private void handlePrintersAdded(List<PrinterInfo> addedPrinters) {
        if (isDestroyed()) {
            return;
        }

        // No old printers - do not bother keeping their position.
        if (mPrinters.isEmpty()) {
            final int printerCount = addedPrinters.size();
            for (int i = 0; i < printerCount; i++) {
                PrinterInfo printer = addedPrinters.get(i);
                mPrinters.put(printer.getId(), printer);
            }
            notifyOnPrintersChanged();
            return;
        }

        // Add the printers to a map.
        HashMap<PrinterId, PrinterInfo> addedPrintersMap =
                new HashMap<PrinterId, PrinterInfo>();
        final int printerCount = addedPrinters.size();
        for (int i = 0; i < printerCount; i++) {
            PrinterInfo printer = addedPrinters.get(i);
            addedPrintersMap.put(printer.getId(), printer);
        }

        // Update printers we already have.
        for (PrinterId oldPrinterId : mPrinters.keySet()) {
            PrinterInfo updatedPrinter = addedPrintersMap.remove(oldPrinterId);
            if (updatedPrinter != null) {
                mPrinters.put(oldPrinterId, updatedPrinter);
            }
        }

        // Add the new printers, i.e. what is left.
        mPrinters.putAll(addedPrintersMap);

        // Announce the change.
        notifyOnPrintersChanged();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.281 -0400", hash_original_method = "7852DB82311BA126DA89E589499EEB4C", hash_generated_method = "0034AB09F058D4281732C2FD1DC94979")
    
private void handlePrintersRemoved(List<PrinterId> printerIds) {
        if (isDestroyed()) {
            return;
        }
        boolean printersChanged = false;
        final int removedPrinterIdCount = printerIds.size();
        for (int i = 0; i < removedPrinterIdCount; i++) {
            PrinterId removedPrinterId = printerIds.get(i);
            if (mPrinters.remove(removedPrinterId) != null) {
                printersChanged = true;
            }
        }
        if (printersChanged) {
            notifyOnPrintersChanged();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.282 -0400", hash_original_method = "DFD4D10AB5D6994D0F8562426FC12966", hash_generated_method = "97B8C40CC64078E989CCD39B6F20DF1C")
    
private void notifyOnPrintersChanged() {
        if (mListener != null) {
            mListener.onPrintersChanged();
        }
    }

    private final class SessionHandler extends Handler {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.284 -0400", hash_original_method = "4C24BE868EFB63D8844E1C88492ECFAF", hash_generated_method = "9F52F15EECDCF7E24AAF3F69FF9A987C")
        
public SessionHandler(Looper looper) {
            super(looper, null);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.285 -0400", hash_original_method = "E1E5188532CD7B08ACC400506C200269", hash_generated_method = "EA133E80848252E88314CA7C4CF600A9")
        
@Override
        @SuppressWarnings("unchecked")
        public void handleMessage(Message message) {
            switch (message.what) {
                case MSG_PRINTERS_ADDED: {
                    List<PrinterInfo> printers = (List<PrinterInfo>) message.obj;
                    handlePrintersAdded(printers);
                } break;

                case MSG_PRINTERS_REMOVED: {
                    List<PrinterId> printerIds = (List<PrinterId>) message.obj;
                    handlePrintersRemoved(printerIds);
                } break;
            }
        }
    }

    private static final class PrinterDiscoveryObserver extends IPrinterDiscoveryObserver.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.287 -0400", hash_original_field = "A332E5064EC48C61148C5FDA811C9877", hash_generated_field = "E5187D53E0F3582A238F300140E43CDF")

        private  WeakReference<PrinterDiscoverySession> mWeakSession;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.288 -0400", hash_original_method = "A7DA376D07D3F6223CAA1FC2035EDD01", hash_generated_method = "07F4BE03A7CC75E8D994CF2833C11883")
        
public PrinterDiscoveryObserver(PrinterDiscoverySession session) {
            mWeakSession = new WeakReference<PrinterDiscoverySession>(session);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.289 -0400", hash_original_method = "8F644F4DCE4919EB59E73ACCF2160648", hash_generated_method = "C8586D3B01FF5C4C9DFCED2C64F05512")
        
@Override
        @SuppressWarnings("rawtypes")
        public void onPrintersAdded(ParceledListSlice printers) {
            PrinterDiscoverySession session = mWeakSession.get();
            if (session != null) {
                session.mHandler.obtainMessage(MSG_PRINTERS_ADDED,
                        printers.getList()).sendToTarget();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.291 -0400", hash_original_method = "DD06538BCD3D93A3CBDE668352F4CA0F", hash_generated_method = "FEA83D774DA735CE910C1A2A4F4DDF42")
        
@Override
        @SuppressWarnings("rawtypes")
        public void onPrintersRemoved(ParceledListSlice printerIds) {
            PrinterDiscoverySession session = mWeakSession.get();
            if (session != null) {
                session.mHandler.obtainMessage(MSG_PRINTERS_REMOVED,
                        printerIds.getList()).sendToTarget();
            }
        }
    }
}
