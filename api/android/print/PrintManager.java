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
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.printservice.PrintServiceInfo;
import android.text.TextUtils;
import java.util.HashMap;
import android.util.Log;

import com.android.internal.os.SomeArgs;

import libcore.io.IoUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * System level service for accessing the printing capabilities of the platform.
 * <p>
 * To obtain a handle to the print manager do the following:
 * </p>
 * 
 * <pre>
 * PrintManager printManager =
 *         (PrintManager) context.getSystemService(Context.PRINT_SERVICE);
 * </pre>
 * 
 * <h3>Print mechanics</h3>
 * <p>
 * The key idea behind printing on the platform is that the content to be printed
 * should be laid out for the currently selected print options resulting in an
 * optimized output and higher user satisfaction. To achieve this goal the platform
 * declares a contract that the printing application has to follow which is defined
 * by the {@link PrintDocumentAdapter} class. At a higher level the contract is that
 * when the user selects some options from the print UI that may affect the way
 * content is laid out, for example page size, the application receives a callback
 * allowing it to layout the content to better fit these new constraints. After a
 * layout pass the system may ask the application to render one or more pages one
 * or more times. For example, an application may produce a single column list for
 * smaller page sizes and a multi-column table for larger page sizes.
 * </p>
 * <h3>Print jobs</h3>
 * <p>
 * Print jobs are started by calling the {@link #print(String, PrintDocumentAdapter,
 * PrintAttributes)} from an activity which results in bringing up the system print
 * UI. Once the print UI is up, when the user changes a selected print option that
 * affects the way content is laid out the system starts to interact with the
 * application following the mechanics described the section above.
 * </p>
 * <p>
 * Print jobs can be in {@link PrintJobInfo#STATE_CREATED created}, {@link
 * PrintJobInfo#STATE_QUEUED queued}, {@link PrintJobInfo#STATE_STARTED started},
 * {@link PrintJobInfo#STATE_BLOCKED blocked}, {@link PrintJobInfo#STATE_COMPLETED
 * completed}, {@link PrintJobInfo#STATE_FAILED failed}, and {@link
 * PrintJobInfo#STATE_CANCELED canceled} state. Print jobs are stored in dedicated
 * system spooler until they are handled which is they are cancelled or completed.
 * Active print jobs, ones that are not cancelled or completed, are considered failed
 * if the device reboots as the new boot may be after a very long time. The user may
 * choose to restart such print jobs. Once a print job is queued all relevant content
 * is stored in the system spooler and its lifecycle becomes detached from this of
 * the application that created it.
 * </p>
 * <p>
 * An applications can query the print spooler for current print jobs it created
 * but not print jobs created by other applications.
 * </p>
 *
 * @see PrintJob
 * @see PrintJobInfo
 */
public final class PrintManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.064 -0400", hash_original_field = "3303122DD7957FD9BE0C49FE43EFA2A5", hash_generated_field = "81FD1B4F22EDAB7A4FB3B2654C162F97")

    private static final String LOG_TAG = "PrintManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.067 -0400", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.070 -0400", hash_original_field = "CA31226F77FC8A38B26C6F8CB4CDB7A5", hash_generated_field = "498E6223AF9A4CD17B2CE3CB1B518D68")

    private static final int MSG_NOTIFY_PRINT_JOB_STATE_CHANGED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.072 -0400", hash_original_field = "18F3FAE9CB7859B974FA75C614D3A44F", hash_generated_field = "344FC53BEB92BFED1F2F09FBBB6339EE")

    public static final String ACTION_PRINT_DIALOG = "android.print.PRINT_DIALOG";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.074 -0400", hash_original_field = "5537E2235FFD6AA760C8401B35E3A0A6", hash_generated_field = "A16C929DD8A67131DBFBB8AD241672C4")

    public static final String EXTRA_PRINT_DIALOG_INTENT =
            "android.print.intent.extra.EXTRA_PRINT_DIALOG_INTENT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.077 -0400", hash_original_field = "DB2019CDEF907227C30297F3FA8FA15A", hash_generated_field = "51D04C742EEFA69ACAFCD40CC2AB1FAD")

    public static final String EXTRA_PRINT_JOB =
            "android.print.intent.extra.EXTRA_PRINT_JOB";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.079 -0400", hash_original_field = "0C11E62A93EDA16CDC6583D5458453F7", hash_generated_field = "37346E8D127B08620FC1C572C3E5FFB9")

    public static final String EXTRA_PRINT_DOCUMENT_ADAPTER =
            "android.print.intent.extra.EXTRA_PRINT_DOCUMENT_ADAPTER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.081 -0400", hash_original_field = "15C130D0BE37F8E34463BBB1ED563CAA", hash_generated_field = "856AA69C76B0A83C0C43D744FE9822CF")

    public static final int APP_ID_ANY = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.083 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.084 -0400", hash_original_field = "B045D51745A204FFFD58FF53707F7F3D", hash_generated_field = "BBDD50582E4AF66F4A10FC3DAC3E8CD6")

    private  IPrintManager mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.087 -0400", hash_original_field = "C1E985FEB03E95A460CF3F00CA1AC469", hash_generated_field = "92E61CD52E3EFA00E014EC0C6AF61282")

    private  int mUserId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.089 -0400", hash_original_field = "54EC6B556ED06A7EEB6FB30D691B2735", hash_generated_field = "8154A56A721671AC1D9ADFD992BBEE15")

    private  int mAppId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.090 -0400", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private  Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.092 -0400", hash_original_field = "09AC7ACE030E4DC2D4791301C7851DD9", hash_generated_field = "568099E4E2A2569CDB4F9453AD628912")

    private Map<PrintJobStateChangeListener, PrintJobStateChangeListenerWrapper> mPrintJobStateChangeListeners;

    /** @hide */
    public interface PrintJobStateChangeListener {

        /**
         * Callback notifying that a print job state changed.
         * 
         * @param printJobId The print job id.
         */
        public void onPrintJobStateChanged(PrintJobId printJobId);
    }
    
    private Map<PrintJobId, PrintJob> jobMap;
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public PrintManager(DSOnlyType dontcare, Context context) {
    	   mContext = context;
    	   jobMap = new HashMap<PrintJobId, PrintJob>();
    }

    /**
     * Creates a new instance.
     * 
     * @param context The current context in which to operate.
     * @param service The backing system service.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.099 -0400", hash_original_method = "AE1B1B72AD19E7224D4D183F82337DA4", hash_generated_method = "E053129B0D23A7C974C953D30A97B5FC")
    
public PrintManager(Context context, IPrintManager service, int userId, int appId) {
        mContext = context;
        mService = service;
        mUserId = userId;
        mAppId = appId;
        mHandler = new Handler(context.getMainLooper(), null) {
            @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-07 03:19:15.645 -0400", hash_original_method = "F3238728FBD12A1652F6EE4EAFFDBE2F", hash_generated_method = "17E696E43501D41BB35B24A4DB8B7855")
                
@Override
            public void handleMessage(Message message) {
                switch (message.what) {
                    case MSG_NOTIFY_PRINT_JOB_STATE_CHANGED: {
                        SomeArgs args = (SomeArgs) message.obj;
                        PrintJobStateChangeListenerWrapper wrapper =
                                (PrintJobStateChangeListenerWrapper) args.arg1;
                        PrintJobStateChangeListener listener = wrapper.getListener();
                        if (listener != null) {
                            PrintJobId printJobId = (PrintJobId) args.arg2;
                            listener.onPrintJobStateChanged(printJobId);
                        }
                        args.recycle();
                    } break;
                }
            }
        };
    }

    /**
     * Creates an instance that can access all print jobs.
     * 
     * @param userId The user id for which to get all print jobs.
     * @return An instance if the caller has the permission to access all print
     *         jobs, null otherwise.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.101 -0400", hash_original_method = "71D93AF16D5C29870A477F74340F0D39", hash_generated_method = "2A86CD325E9D97486F99AA5A17044188")
    
public PrintManager getGlobalPrintManagerForUser(int userId) {
        return new PrintManager(mContext, mService, userId, APP_ID_ANY);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.103 -0400", hash_original_method = "FFE4A196E2B71F9CF8813C2F1A376B67", hash_generated_method = "FFE4A196E2B71F9CF8813C2F1A376B67")
    
PrintJobInfo getPrintJobInfo(PrintJobId printJobId) {
        try {
            return mService.getPrintJobInfo(printJobId, mAppId, mUserId);
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error getting a print job info:" + printJobId, re);
        }
        return null;
    }

    /**
     * Adds a listener for observing the state of print jobs.
     * 
     * @param listener The listener to add.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.105 -0400", hash_original_method = "A0D95B55B01C40DF7B50005BD5C84D0D", hash_generated_method = "FD842393C3074E7C0CE60E789C4B8359")
    
public void addPrintJobStateChangeListener(PrintJobStateChangeListener listener) {
        if (mPrintJobStateChangeListeners == null) {
            mPrintJobStateChangeListeners = new HashMap<PrintJobStateChangeListener,
                    PrintJobStateChangeListenerWrapper>();
        }
        PrintJobStateChangeListenerWrapper wrappedListener =
                new PrintJobStateChangeListenerWrapper(listener, mHandler);

    mPrintJobStateChangeListeners.put(listener, wrappedListener);
    listener.onPrintJobStateChanged(new PrintJobId());
/*        try {
        //    mService.addPrintJobStateChangeListener(wrappedListener, mAppId, mUserId);
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error adding print job state change listener", re);
        }
 */       
    }

    /**
     * Removes a listener for observing the state of print jobs.
     * 
     * @param listener The listener to remove.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.107 -0400", hash_original_method = "C369DC614C7C120493A8882EA260B48D", hash_generated_method = "ABC857225F7AF85A0B2CE7CD6A52F643")
    
public void removePrintJobStateChangeListener(PrintJobStateChangeListener listener) {
        if (mPrintJobStateChangeListeners == null) {
            return;
        }
        PrintJobStateChangeListenerWrapper wrappedListener =
                mPrintJobStateChangeListeners.remove(listener);
        if (wrappedListener == null) {
            return;
        }
        if (mPrintJobStateChangeListeners.isEmpty()) {
            mPrintJobStateChangeListeners = null;
        }
        wrappedListener.destroy();
        try {
            mService.removePrintJobStateChangeListener(wrappedListener, mUserId);
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error removing print job state change listener", re);
        }
    }

    /**
     * Gets a print job given its id.
     * 
     * @return The print job list.
     * @see PrintJob
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.108 -0400", hash_original_method = "DEBC1003EE8077DC81CC275B7161ACDE", hash_generated_method = "CEBFE515A17B218BBC263E19E4FD337A")
    
public PrintJob getPrintJob(PrintJobId printJobId) {
       /* try {
            PrintJobInfo printJob = mService.getPrintJobInfo(printJobId, mAppId, mUserId);
            if (printJob != null) {
                return new PrintJob(printJob, this);
            }
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error getting print job", re);
        }
        return null;*/
    	
    	return jobMap.get(printJobId);
    }

    /**
     * Gets the print jobs for this application.
     * 
     * @return The print job list.
     * @see PrintJob
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.111 -0400", hash_original_method = "32DF55789FF29E71209B7874501CE386", hash_generated_method = "DA46B00A2A0FE39B5C00584A3841BA06")
    
public List<PrintJob> getPrintJobs() {
       /* try {
            List<PrintJobInfo> printJobInfos = mService.getPrintJobInfos(mAppId, mUserId);
            if (printJobInfos == null) {
                return Collections.emptyList();
            }
            final int printJobCount = printJobInfos.size();
            List<PrintJob> printJobs = new ArrayList<PrintJob>(printJobCount);
            for (int i = 0; i < printJobCount; i++) {
                printJobs.add(new PrintJob(printJobInfos.get(i), this));
            }
            return printJobs;
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error getting print jobs", re);
        }
        return Collections.emptyList();*/
    	
    	List<PrintJob> jobs = new LinkedList<PrintJob>();
    	jobs.addAll(jobMap.values());
    	return jobs;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.113 -0400", hash_original_method = "C33185D1CD712232A43737606E7ABC0C", hash_generated_method = "C33185D1CD712232A43737606E7ABC0C")
    
void cancelPrintJob(PrintJobId printJobId) {
       /* try {
            mService.cancelPrintJob(printJobId, mAppId, mUserId);
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error cancleing a print job: " + printJobId, re);
        }*/
    	this.mPrintJobStateChangeListeners.get(printJobId).onPrintJobStateChanged(printJobId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.114 -0400", hash_original_method = "A0F0AAA777D75F08680DA7D2E6A71237", hash_generated_method = "A0F0AAA777D75F08680DA7D2E6A71237")
    
void restartPrintJob(PrintJobId printJobId) {
     /*   try {
            mService.restartPrintJob(printJobId, mAppId, mUserId);
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error restarting a print job: " + printJobId, re);
        }*/

    	this.mPrintJobStateChangeListeners.get(printJobId).onPrintJobStateChanged(printJobId);
    }

    /**
     * Creates a print job for printing a {@link PrintDocumentAdapter} with
     * default print attributes.
     * <p>
     * Calling this method brings the print UI allowing the user to customize
     * the print job and returns a {@link PrintJob} object without waiting for the
     * user to customize or confirm the print job. The returned print job instance
     * is in a {@link PrintJobInfo#STATE_CREATED created} state.
     * <p>
     * This method can be called only from an {@link Activity}. The rationale is that
     * printing from a service will create an inconsistent user experience as the print
     * UI would appear without any context.
     * </p>
     * <p>
     * Also the passed in {@link PrintDocumentAdapter} will be considered invalid if
     * your activity is finished. The rationale is that once the activity that
     * initiated printing is finished, the provided adapter may be in an inconsistent
     * state as it may depend on the UI presented by the activity.
     * </p>
     * <p>
     * The default print attributes are a hint to the system how the data is to
     * be printed. For example, a photo editor may look at the photo aspect ratio
     * to determine the default orientation and provide a hint whether the printing
     * should be in portrait or landscape. The system will do a best effort to
     * selected the hinted options in the print dialog, given the current printer
     * supports them.
     * </p>
     *
     * @param printJobName A name for the new print job which is shown to the user.
     * @param documentAdapter An adapter that emits the document to print.
     * @param attributes The default print job attributes or <code>null</code>.
     * @return The created print job on success or null on failure.
     * @throws IllegalStateException If not called from an {@link Activity}.
     * @throws IllegalArgumentException If the print job name is empty or the
     * document adapter is null.
     *
     * @see PrintJob
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.118 -0400", hash_original_method = "DB76197B791C3360ABCE2D710B34C7EA", hash_generated_method = "C0EB4482F0F19ABDD988F50025182264")
    
public PrintJob print(String printJobName, PrintDocumentAdapter documentAdapter,
            PrintAttributes attributes) {
        if (!(mContext instanceof Activity)) {
            throw new IllegalStateException("Can print only from an activity");
        }
        if (TextUtils.isEmpty(printJobName)) {
            throw new IllegalArgumentException("printJobName cannot be empty");
        }
        if (documentAdapter == null) {
            throw new IllegalArgumentException("documentAdapter cannot be null");
        }
       
        PrintJobInfo jobInfo = new PrintJobInfo();
        PrintJob job = new PrintJob(DSOnlyType.DONTCARE, jobInfo);
        
        jobMap.put(jobInfo.getId(), job);
        
        PrintJobId printJobId = jobInfo.getId();
        
    	this.mPrintJobStateChangeListeners.get(printJobId).onPrintJobStateChanged(printJobId);
        return job;
        
    }

    /**
     * Gets the list of enabled print services.
     * 
     * @return The enabled service list or an empty list.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.119 -0400", hash_original_method = "6A6B8AB49372FF0A6A4667A2DE4152CD", hash_generated_method = "368B34C89E1547C6784CF19847AD92E0")
    
public List<PrintServiceInfo> getEnabledPrintServices() {
        try {
            List<PrintServiceInfo> enabledServices = mService.getEnabledPrintServices(mUserId);
            if (enabledServices != null) {
                return enabledServices;
            }
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error getting the enabled print services", re);
        }
        return Collections.emptyList();
    }

    /**
     * Gets the list of installed print services.
     * 
     * @return The installed service list or an empty list.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.121 -0400", hash_original_method = "FBF53CD3157371B2095A5F0873517FC1", hash_generated_method = "7FBE81EE642706EEBB22D2CB0A8D2F3E")
    
public List<PrintServiceInfo> getInstalledPrintServices() {
        try {
            List<PrintServiceInfo> installedServices = mService.getInstalledPrintServices(mUserId);
            if (installedServices != null) {
                return installedServices;
            }
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error getting the installed print services", re);
        }
        return Collections.emptyList();
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.123 -0400", hash_original_method = "BF834E9E3734A707AEC75B7E48020AEB", hash_generated_method = "068574AB5059B84772481880102A653C")
    
public PrinterDiscoverySession createPrinterDiscoverySession() {
        return new PrinterDiscoverySession(mService, mContext, mUserId);
    }

    private static final class PrintDocumentAdapterDelegate extends IPrintDocumentAdapter.Stub
            implements ActivityLifecycleCallbacks {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.125 -0400", hash_original_field = "83DB9DCBBD2D99A708D9A1934D5CD5AB", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

        private final Object mLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.128 -0400", hash_original_field = "A571C2E1AEEC583FD21439E692148F28", hash_generated_field = "CA4F1A1556FB513286530B03BF33D8EF")

        private CancellationSignal mLayoutOrWriteCancellation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.129 -0400", hash_original_field = "3895D7E6DB5042DA7856DC78E391C7B9", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

        private Activity mActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.131 -0400", hash_original_field = "77002021D46C9D14F7560D58BBEF0059", hash_generated_field = "F5DF6849C2363B0F8B7D0B643F78710B")

        private PrintDocumentAdapter mDocumentAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.133 -0400", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.134 -0400", hash_original_field = "56608A6692CF6070507BFBA2244E5A39", hash_generated_field = "C672C5AC573628EABA3BF75459453214")

        private IPrintDocumentAdapterObserver mObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.136 -0400", hash_original_field = "8FA0491EE0740AA86A41D047A5A17545", hash_generated_field = "DCA09E2392B88E6048206313AF8893B9")

        private LayoutSpec mLastLayoutSpec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.138 -0400", hash_original_field = "52BF92F0930567EB456B61A58B382E4B", hash_generated_field = "0F3C2AAF280E2D19B05A4FAEAAA455CD")

        private WriteSpec mLastWriteSpec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.139 -0400", hash_original_field = "E6E1E3A3EA30E3276AA1B68A54FA1EA3", hash_generated_field = "90FDCFEED11CBBADD23279DDEE83C57C")

        private boolean mStartReqeusted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.141 -0400", hash_original_field = "8C92DC16A5D2F989C0A1D4375841DEF1", hash_generated_field = "651C1B44F0CFBC9CE67518504FC6F4C2")

        private boolean mStarted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.143 -0400", hash_original_field = "B809149A70CACFFC53EE50EA6E8A9BD0", hash_generated_field = "29BD6DB8A6FEA2056FF7B6E1487EA777")

        private boolean mFinishRequested;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.145 -0400", hash_original_field = "10598AB9B4F301B505526794EAE9EAF0", hash_generated_field = "0B1DE3EEB5BF08E36FD9B568D72D59CC")

        private boolean mFinished;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.146 -0400", hash_original_field = "708F9D94DA99CD83DBB18AAAFBA8C49F", hash_generated_field = "1C64CB399BFF718CD14799195853AA6E")

        private boolean mDestroyed;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.148 -0400", hash_original_method = "C68FFEB532124CDFF75F10DB8B5C04E9", hash_generated_method = "B8F17B741D64A281521D15FEDF9988C6")
        
public PrintDocumentAdapterDelegate(Activity activity,
                PrintDocumentAdapter documentAdapter) {
            mActivity = activity;
            mDocumentAdapter = documentAdapter;
            mHandler = new MyHandler(mActivity.getMainLooper());
            mActivity.getApplication().registerActivityLifecycleCallbacks(this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.150 -0400", hash_original_method = "20764D4F3AD9D69FE3FBAF6BE2B01788", hash_generated_method = "B7C821CDB6101BEAEF76940B37156889")
        
@Override
        public void setObserver(IPrintDocumentAdapterObserver observer) {
            final boolean destroyed;
            synchronized (mLock) {
                if (!mDestroyed) {
                    mObserver = observer;
                }
                destroyed = mDestroyed;
            }
            if (destroyed) {
                try {
                    observer.onDestroy();
                } catch (RemoteException re) {
                    Log.e(LOG_TAG, "Error announcing destroyed state", re);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.152 -0400", hash_original_method = "21B04F04060B2EC2BA176CC9CBDBF619", hash_generated_method = "F72BF7B74DC9C6843499604C9367B9B8")
        
@Override
        public void start() {
            synchronized (mLock) {
                // Started called or finish called or destroyed - nothing to do.
                if (mStartReqeusted || mFinishRequested || mDestroyed) {
                    return;
                }

                mStartReqeusted = true;

                doPendingWorkLocked();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.154 -0400", hash_original_method = "DD8ADBF28CF10DC6AB7AF52E087CD435", hash_generated_method = "954A409BBBA1057D7AA39C1AF2F1AB71")
        
@Override
        public void layout(PrintAttributes oldAttributes, PrintAttributes newAttributes,
                ILayoutResultCallback callback, Bundle metadata, int sequence) {
            final boolean destroyed;
            synchronized (mLock) {
                destroyed = mDestroyed;
                // If start called and not finished called and not destroyed - do some work.
                if (mStartReqeusted && !mFinishRequested && !mDestroyed) {
                    // Layout cancels write and overrides layout.
                    if (mLastWriteSpec != null) {
                        //IoUtils.closeQuietly(mLastWriteSpec.fd);
                        mLastWriteSpec = null;
                    }

                    mLastLayoutSpec = new LayoutSpec();
                    mLastLayoutSpec.callback = callback;
                    mLastLayoutSpec.oldAttributes = oldAttributes;
                    mLastLayoutSpec.newAttributes = newAttributes;
                    mLastLayoutSpec.metadata = metadata;
                    mLastLayoutSpec.sequence = sequence;

                    // Cancel the previous cancellable operation.When the
                    // cancellation completes we will do the pending work.
                    if (cancelPreviousCancellableOperationLocked()) {
                        return;
                    }

                    doPendingWorkLocked();
                }
            }
            if (destroyed) {
                try {
                    callback.onLayoutFailed(null, sequence);
                } catch (RemoteException re) {
                    Log.i(LOG_TAG, "Error notifying for cancelled layout", re);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.158 -0400", hash_original_method = "230F024CB8D78161462545C88D9A7C76", hash_generated_method = "E9FF6FBC30034CA20F28E03C37DBE07B")
        
@Override
        public void write(PageRange[] pages, ParcelFileDescriptor fd,
                IWriteResultCallback callback, int sequence) {
            final boolean destroyed;
            synchronized (mLock) {
                destroyed = mDestroyed;
                // If start called and not finished called and not destroyed - do some work.
                if (mStartReqeusted && !mFinishRequested && !mDestroyed) {
                    // Write cancels previous writes.
                    if (mLastWriteSpec != null) {
                        //IoUtils.closeQuietly(mLastWriteSpec.fd);
                        mLastWriteSpec = null;
                    }

                    mLastWriteSpec = new WriteSpec();
                    mLastWriteSpec.callback = callback;
                    mLastWriteSpec.pages = pages;
                    mLastWriteSpec.fd = fd;
                    mLastWriteSpec.sequence = sequence;

                    // Cancel the previous cancellable operation.When the
                    // cancellation completes we will do the pending work.
                    if (cancelPreviousCancellableOperationLocked()) {
                        return;
                    }

                    doPendingWorkLocked();
                }
            }
            if (destroyed) {
                try {
                    callback.onWriteFailed(null, sequence);
                } catch (RemoteException re) {
                    Log.i(LOG_TAG, "Error notifying for cancelled write", re);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.159 -0400", hash_original_method = "1B0931E7A305276564B8C4C6C1A012FA", hash_generated_method = "C0390A54759E44C85CB60132750125D9")
        
@Override
        public void finish() {
            synchronized (mLock) {
                // Start not called or finish called or destroyed - nothing to do.
                if (!mStartReqeusted || mFinishRequested || mDestroyed) {
                    return;
                }

                mFinishRequested = true;

                // When the current write or layout complete we
                // will do the pending work.
                if (mLastLayoutSpec != null || mLastWriteSpec != null) {
                    if (DEBUG) {
                        Log.i(LOG_TAG, "Waiting for current operation");
                    }
                    return;
                }

                doPendingWorkLocked();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.161 -0400", hash_original_method = "11B7C8601F0188C8A81056B59B05278A", hash_generated_method = "C5B5D8A4A497C419CB9AB09DA7335CBF")
        
@Override
        public void cancel() {
            // Start not called or finish called or destroyed - nothing to do.
            if (!mStartReqeusted || mFinishRequested || mDestroyed) {
                return;
            }
            // Request cancellation of pending work if needed.
            synchronized (mLock) {
                cancelPreviousCancellableOperationLocked();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.163 -0400", hash_original_method = "52ADDA1E74A5ED974DBC04E6A0FD697D", hash_generated_method = "1518F2BC81A34C5B9059F932E9E00484")
        
@Override
        public void onActivityPaused(Activity activity) {
            /* do nothing */
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.165 -0400", hash_original_method = "9E41B7F75CBB479EB513D9AA153D7D8B", hash_generated_method = "ABB6034E417C239E83A9EA8F33DD8ED8")
        
@Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            /* do nothing */
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.167 -0400", hash_original_method = "566730DB0B480AE906AFCBEE488E855D", hash_generated_method = "ED3592E99F9A877EB91C5545AA3B7035")
        
@Override
        public void onActivityStarted(Activity activity) {
            /* do nothing */
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.168 -0400", hash_original_method = "C1749821E220825B77D018B7B7244EC6", hash_generated_method = "113B003A3F6BB95629571B49D5559F17")
        
@Override
        public void onActivityResumed(Activity activity) {
            /* do nothing */
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.170 -0400", hash_original_method = "B2562E820F75735385104CDE74899A9F", hash_generated_method = "802FFA9F038EE6A834CC3E046A682C6F")
        
@Override
        public void onActivityStopped(Activity activity) {
            /* do nothing */
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.172 -0400", hash_original_method = "C345D314F79F69AF889DAFE23E360559", hash_generated_method = "D73F934056F1F919662DD24015AC8E30")
        
@Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            /* do nothing */
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.174 -0400", hash_original_method = "5CA784F65696E6D7B1F082F6C1A6FEC1", hash_generated_method = "1B4E26DE842BC09154A1070F0231323A")
        
@Override
        public void onActivityDestroyed(Activity activity) {
            // We really care only if the activity is being destroyed to
            // notify the the print spooler so it can close the print dialog.
            // Note the the spooler has a death recipient that observes if
            // this process gets killed so we cover the case of onDestroy not
            // being called due to this process being killed to reclaim memory.
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.176 -0400", hash_original_method = "9CAEFFF5114D012A90719CBB032054C2", hash_generated_method = "52484FA6CBC73201E85BD35CE61EED63")
        
private boolean isFinished() {
            return mDocumentAdapter == null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.178 -0400", hash_original_method = "EEFEE40FBDB51F89C4E2FEEF721C2000", hash_generated_method = "E163D4402D592A9CBB4E636D6F8B5273")
        
private void clearLocked() {
            mActivity = null;
            mDocumentAdapter = null;
            mHandler = null;
            mLayoutOrWriteCancellation = null;
            mLastLayoutSpec = null;
            if (mLastWriteSpec != null) {
                //IoUtils.closeQuietly(mLastWriteSpec.fd);
                mLastWriteSpec = null;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.179 -0400", hash_original_method = "C5B1AC07777A937D1DAC732B9DCAC8E1", hash_generated_method = "E525AF8F40C276AD8EEAD0823BA8FF1A")
        
private boolean cancelPreviousCancellableOperationLocked() {
            if (mLayoutOrWriteCancellation != null) {
                mLayoutOrWriteCancellation.cancel();
                if (DEBUG) {
                    Log.i(LOG_TAG, "Cancelling previous operation");
                }
                return true;
            }
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.181 -0400", hash_original_method = "7982A39B902426DDFE186ACA99DE5BCB", hash_generated_method = "5E6D358D58A0281DBD8F82CEF53582DA")
        
private void doPendingWorkLocked() {
            if (mStartReqeusted && !mStarted) {
                mStarted = true;
                mHandler.sendEmptyMessage(MyHandler.MSG_START);
            } else if (mLastLayoutSpec != null) {
                mHandler.sendEmptyMessage(MyHandler.MSG_LAYOUT);
            } else if (mLastWriteSpec != null) {
                mHandler.sendEmptyMessage(MyHandler.MSG_WRITE);
            } else if (mFinishRequested && !mFinished) {
                mFinished = true;
                mHandler.sendEmptyMessage(MyHandler.MSG_FINISH);
            }
        }

        private class LayoutSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.183 -0400", hash_original_field = "674A6FFD53BDB43408FFFAA6F4FFC3CA", hash_generated_field = "674A6FFD53BDB43408FFFAA6F4FFC3CA")

            ILayoutResultCallback callback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.185 -0400", hash_original_field = "2D1CAE0DB5B359894DE80D8D14E2818D", hash_generated_field = "2D1CAE0DB5B359894DE80D8D14E2818D")

            PrintAttributes oldAttributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.186 -0400", hash_original_field = "05326C0A25C63D49F536E7ACE9717D5C", hash_generated_field = "05326C0A25C63D49F536E7ACE9717D5C")

            PrintAttributes newAttributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.188 -0400", hash_original_field = "4C6E76B9E911CE538C97DDE25C833A79", hash_generated_field = "4C6E76B9E911CE538C97DDE25C833A79")

            Bundle metadata;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.190 -0400", hash_original_field = "2CA2193047A8E20AE3472C21C95BEDE4", hash_generated_field = "2CA2193047A8E20AE3472C21C95BEDE4")

            int sequence;
        }

        private class WriteSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.194 -0400", hash_original_field = "C050CCBAB877253B3BEF51EA9C92A852", hash_generated_field = "C050CCBAB877253B3BEF51EA9C92A852")

            IWriteResultCallback callback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.195 -0400", hash_original_field = "6CB13D7324ECC8866B4DBF3D6E64DA8A", hash_generated_field = "6CB13D7324ECC8866B4DBF3D6E64DA8A")

            PageRange[] pages;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.197 -0400", hash_original_field = "ED4BCC0409574E6EB5292B0FF005E3EB", hash_generated_field = "ED4BCC0409574E6EB5292B0FF005E3EB")

            ParcelFileDescriptor fd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.198 -0400", hash_original_field = "2CA2193047A8E20AE3472C21C95BEDE4", hash_generated_field = "2CA2193047A8E20AE3472C21C95BEDE4")

            int sequence;
        }

        private final class MyHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.202 -0400", hash_original_field = "9F9E3DE6F4BA368CF437EA798C3D2B94", hash_generated_field = "AE0B4E97D4813BFFEA43DE8D3DEF4205")

            public static final int MSG_START = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.210 -0400", hash_original_field = "1098FA94FF6941D6F8DD788C50EF8625", hash_generated_field = "1D58C914A52138FFE381106D8E94F0FC")

            public static final int MSG_LAYOUT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.212 -0400", hash_original_field = "4CB9FC613C212166E90FA967E88ED665", hash_generated_field = "BCC76F0DB0CBD3B28A0F504F2393EB2F")

            public static final int MSG_WRITE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.214 -0400", hash_original_field = "9D8803ECC9B7125C9DEDCF3F95B2A7B3", hash_generated_field = "4A089EF4CEF94CCE8B3288BD5BABED7B")

            public static final int MSG_FINISH = 4;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.216 -0400", hash_original_method = "411F7D7B0B20BADC8FBBC1FB772AD25C", hash_generated_method = "EA997CB1F968D78B7F8D90193FCC7343")
            
            public MyHandler(Looper looper) {
                super(looper, null);
            }

            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.219 -0400", hash_original_method = "A7ADAA8820AEF634994EA253B9773BC7", hash_generated_method = "2BDA6550ABA1187F39C9C36FF81C62B0")
            
@Override
            public void handleMessage(Message message) {
                if (isFinished()) {
                    return;
                }
                switch (message.what) {
                    case MSG_START: {
                        final PrintDocumentAdapter adapter;
                        synchronized (mLock) {
                            adapter = mDocumentAdapter;
                        }
                        if (adapter != null) {
                            adapter.onStart();
                        }
                    } break;

                    case MSG_LAYOUT: {
                        final PrintDocumentAdapter adapter;
                        final CancellationSignal cancellation;
                        final LayoutSpec layoutSpec;

                        synchronized (mLock) {
                            adapter = mDocumentAdapter;
                            layoutSpec = mLastLayoutSpec;
                            mLastLayoutSpec = null;
                            cancellation = new CancellationSignal();
                            mLayoutOrWriteCancellation = cancellation;
                        }

                        if (layoutSpec != null && adapter != null) {
                            if (DEBUG) {
                                Log.i(LOG_TAG, "Performing layout");
                            }
                            adapter.onLayout(layoutSpec.oldAttributes,
                                    layoutSpec.newAttributes, cancellation,
                                    new MyLayoutResultCallback(layoutSpec.callback,
                                            layoutSpec.sequence), layoutSpec.metadata);
                        }
                    } break;

                    case MSG_WRITE: {
                        final PrintDocumentAdapter adapter;
                        final CancellationSignal cancellation;
                        final WriteSpec writeSpec;

                        synchronized (mLock) {
                            adapter = mDocumentAdapter;
                            writeSpec = mLastWriteSpec;
                            mLastWriteSpec = null;
                            cancellation = new CancellationSignal();
                            mLayoutOrWriteCancellation = cancellation;
                        }

                        if (writeSpec != null && adapter != null) {
                            if (DEBUG) {
                                Log.i(LOG_TAG, "Performing write");
                            }
                            adapter.onWrite(writeSpec.pages, writeSpec.fd,
                                    cancellation, new MyWriteResultCallback(writeSpec.callback,
                                            writeSpec.fd, writeSpec.sequence));
                        }
                    } break;

                    case MSG_FINISH: {
                        if (DEBUG) {
                            Log.i(LOG_TAG, "Performing finish");
                        }
                        final PrintDocumentAdapter adapter;
                        final Activity activity;
                        synchronized (mLock) {
                            adapter = mDocumentAdapter;
                            activity = mActivity;
                            clearLocked();
                        }
                        if (adapter != null) {
                            adapter.onFinish();
                        }
                        if (activity != null) {
                            activity.getApplication().unregisterActivityLifecycleCallbacks(
                                    PrintDocumentAdapterDelegate.this);
                        }
                    } break;

                    default: {
                        throw new IllegalArgumentException("Unknown message: "
                                + message.what);
                    }
                }
            }
        }

        private final class MyLayoutResultCallback extends LayoutResultCallback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.224 -0400", hash_original_field = "C3B8873066B8716936D602EC90E687E8", hash_generated_field = "F9FB3556F4124BC8E4896FF99EFC58D8")

            private ILayoutResultCallback mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.227 -0400", hash_original_field = "C28E864EAE17A45901F02FA70D5B732C", hash_generated_field = "8F50649AA652CE4330E55AC6A68FCB0E")

            private  int mSequence;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.231 -0400", hash_original_method = "8B957BB61D275D406F13FBEBEFB32A6B", hash_generated_method = "DD154B585E0FAF59775C0FA7A678F6EE")
            
public MyLayoutResultCallback(ILayoutResultCallback callback,
                    int sequence) {
                mCallback = callback;
                mSequence = sequence;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.233 -0400", hash_original_method = "DCBB01DA9B11FF2BF44F7377A1C0ECC2", hash_generated_method = "59639AF28EE821BDC70106792823E540")
            
@Override
            public void onLayoutFinished(PrintDocumentInfo info, boolean changed) {
                if (info == null) {
                    throw new NullPointerException("document info cannot be null");
                }
                final ILayoutResultCallback callback;
                synchronized (mLock) {
                    if (mDestroyed) {
                        Log.e(LOG_TAG, "PrintDocumentAdapter is destroyed. Did you "
                                + "finish the printing activity before print completion?");
                        return;
                    }
                    callback = mCallback;
                    clearLocked();
                }
                if (callback != null) {
                    try {
                        callback.onLayoutFinished(info, changed, mSequence);
                    } catch (RemoteException re) {
                        Log.e(LOG_TAG, "Error calling onLayoutFinished", re);
                    }
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.236 -0400", hash_original_method = "D24EA9A6964725B5F63991D09ED4FB76", hash_generated_method = "336E8897874F14CF9B139077F8D8F4B1")
            
@Override
            public void onLayoutFailed(CharSequence error) {
                final ILayoutResultCallback callback;
                synchronized (mLock) {
                    if (mDestroyed) {
                        Log.e(LOG_TAG, "PrintDocumentAdapter is destroyed. Did you "
                                + "finish the printing activity before print completion?");
                        return;
                    }
                    callback = mCallback;
                    clearLocked();
                }
                if (callback != null) {
                    try {
                        callback.onLayoutFailed(error, mSequence);
                    } catch (RemoteException re) {
                        Log.e(LOG_TAG, "Error calling onLayoutFailed", re);
                    }
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.238 -0400", hash_original_method = "B10D77053D86AA29573F53C6B499E0FB", hash_generated_method = "82ACEF5654A940B98BC92BA13C1B12C9")
            
@Override
            public void onLayoutCancelled() {
                synchronized (mLock) {
                    if (mDestroyed) {
                        Log.e(LOG_TAG, "PrintDocumentAdapter is destroyed. Did you "
                                + "finish the printing activity before print completion?");
                        return;
                    }
                    clearLocked();
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.242 -0400", hash_original_method = "FD0B793BEADC35A96FC829EFE933C564", hash_generated_method = "17E6B7B9AEBC495C331177FBB9DF2040")
            
private void clearLocked() {
                mLayoutOrWriteCancellation = null;
                mCallback = null;
                doPendingWorkLocked();
            }
        }

        private final class MyWriteResultCallback extends WriteResultCallback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.252 -0400", hash_original_field = "F15BA4F12003086454C67D56791594A9", hash_generated_field = "AE959CCFA06A07F93FA2A8BEED883021")

            private ParcelFileDescriptor mFd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.258 -0400", hash_original_field = "C28E864EAE17A45901F02FA70D5B732C", hash_generated_field = "8F50649AA652CE4330E55AC6A68FCB0E")

            private int mSequence;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.262 -0400", hash_original_field = "20DE4E5BE5D7A38855442DB448441A80", hash_generated_field = "CF76059C23CE167716218B00079CAA1C")

            private IWriteResultCallback mCallback;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.267 -0400", hash_original_method = "A3C366CE934E9CDA20FBB585BE57726A", hash_generated_method = "3F89861CEDCFA341CC238B5A971CA129")
            
public MyWriteResultCallback(IWriteResultCallback callback,
                    ParcelFileDescriptor fd, int sequence) {
                mFd = fd;
                mSequence = sequence;
                mCallback = callback;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.270 -0400", hash_original_method = "F1B26067997851E085FB9B0D08E55B32", hash_generated_method = "20DA2BBB2B238A480A901B063C5A6830")
            
@Override
            public void onWriteFinished(PageRange[] pages) {
                final IWriteResultCallback callback;
                synchronized (mLock) {
                    if (mDestroyed) {
                        Log.e(LOG_TAG, "PrintDocumentAdapter is destroyed. Did you "
                                + "finish the printing activity before print completion?");
                        return;
                    }
                    callback = mCallback;
                    clearLocked();
                }
                if (pages == null) {
                    throw new IllegalArgumentException("pages cannot be null");
                }
                if (pages.length == 0) {
                    throw new IllegalArgumentException("pages cannot be empty");
                }
                if (callback != null) {
                    try {
                        callback.onWriteFinished(pages, mSequence);
                    } catch (RemoteException re) {
                        Log.e(LOG_TAG, "Error calling onWriteFinished", re);
                    }
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.273 -0400", hash_original_method = "9C19F0A820701829709659C1CBB69573", hash_generated_method = "5F5C0881BC53E78771CF8E50BB891061")
            
@Override
            public void onWriteFailed(CharSequence error) {
                final IWriteResultCallback callback;
                synchronized (mLock) {
                    if (mDestroyed) {
                        Log.e(LOG_TAG, "PrintDocumentAdapter is destroyed. Did you "
                                + "finish the printing activity before print completion?");
                        return;
                    }
                    callback = mCallback;
                    clearLocked();
                }
                if (callback != null) {
                    try {
                        callback.onWriteFailed(error, mSequence);
                    } catch (RemoteException re) {
                        Log.e(LOG_TAG, "Error calling onWriteFailed", re);
                    }
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.274 -0400", hash_original_method = "E68C41C77DB0F1B4A3DE14AF3A582883", hash_generated_method = "589AED4B722F05513B811D07508A7813")
            
@Override
            public void onWriteCancelled() {
                synchronized (mLock) {
                    if (mDestroyed) {
                        Log.e(LOG_TAG, "PrintDocumentAdapter is destroyed. Did you "
                                + "finish the printing activity before print completion?");
                        return;
                    }
                    clearLocked();
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.276 -0400", hash_original_method = "DA47E00D538D46A31A9B11FFD3C6D54C", hash_generated_method = "22734892B222F78FD088226C4121763F")
            
private void clearLocked() {
                mLayoutOrWriteCancellation = null;
                //IoUtils.closeQuietly(mFd);
                mCallback = null;
                mFd = null;
                doPendingWorkLocked();
            }
        }
    }

    private static final class PrintJobStateChangeListenerWrapper extends
            IPrintJobStateChangeListener.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.286 -0400", hash_original_field = "8CB1832797F40606E908364F17FF5B75", hash_generated_field = "0460B7FD1A3347B9A71D67D74FADDA31")

        private  WeakReference<PrintJobStateChangeListener> mWeakListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.287 -0400", hash_original_field = "6790F45A2E44465FE8E2231A2CDE62AE", hash_generated_field = "F14496BC67F8115DEDE32E91F5000D57")

        private  WeakReference<Handler> mWeakHandler;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.289 -0400", hash_original_method = "436F13C74CD5F2F96797E5BF4AB24670", hash_generated_method = "D51F9BC8CB9030094ADB5A5BD0D4A92F")
        
public PrintJobStateChangeListenerWrapper(PrintJobStateChangeListener listener,
                Handler handler) {
            mWeakListener = new WeakReference<PrintJobStateChangeListener>(listener);
            mWeakHandler = new WeakReference<Handler>(handler);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.292 -0400", hash_original_method = "2ACF403CC373C67A0F7C8799CBA7DFC5", hash_generated_method = "8867EDE85544242F4E909D473822E72D")
        
@Override
        public void onPrintJobStateChanged(PrintJobId printJobId) {
            Handler handler = mWeakHandler.get();
            PrintJobStateChangeListener listener = mWeakListener.get();
            if (handler != null && listener != null) {
                SomeArgs args = SomeArgs.obtain();
                args.arg1 = this;
                args.arg2 = printJobId;
                handler.obtainMessage(MSG_NOTIFY_PRINT_JOB_STATE_CHANGED,
                        args).sendToTarget();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.293 -0400", hash_original_method = "1B5252D3271475A675250DA148FFFD32", hash_generated_method = "EC63660AFC008B5C4712665ED58C0219")
        
public void destroy() {
            mWeakListener.clear();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:11.295 -0400", hash_original_method = "FE620D325AAFE35FA4619A5C7F7FEAC0", hash_generated_method = "78CBE9F76FBAFEA13897EB0A7C7225D4")
        
public PrintJobStateChangeListener getListener() {
            return mWeakListener.get();
        }
    }
}
