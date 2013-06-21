package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.android.internal.widget.IRemoteViewsAdapterConnection;
import com.android.internal.widget.IRemoteViewsFactory;

public class RemoteViewsAdapter extends BaseAdapter implements Handler.Callback {
    private Context mContext;
    private Intent mIntent;
    private int mAppWidgetId;
    private LayoutInflater mLayoutInflater;
    private RemoteViewsAdapterServiceConnection mServiceConnection;
    private WeakReference<RemoteAdapterConnectionCallback> mCallback;
    private FixedSizeRemoteViewsCache mCache;
    private boolean mNotifyDataSetChangedAfterOnServiceConnected = false;
    private RemoteViewsFrameLayoutRefSet mRequestedViews;
    private HandlerThread mWorkerThread;
    private Handler mWorkerQueue;
    private Handler mMainQueue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.209 -0400", hash_original_method = "812B134D167B9B4075E3C9A16E9536C3", hash_generated_method = "897ABF5D40165D622F9EE8BBEF3AFE32")
    @DSModeled(DSC.SPEC)
    public RemoteViewsAdapter(Context context, Intent intent, RemoteAdapterConnectionCallback callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        mAppWidgetId = intent.getIntExtra(RemoteViews.EXTRA_REMOTEADAPTER_APPWIDGET_ID, -1);
        mLayoutInflater = LayoutInflater.from(context);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Non-null Intent must be specified.");
        } //End block
        mRequestedViews = new RemoteViewsFrameLayoutRefSet();
        {
            boolean varC25279B3AE4B976D096FE6C4D3EF7578_1882798238 = (intent.hasExtra(RemoteViews.EXTRA_REMOTEADAPTER_APPWIDGET_ID));
            {
                intent.removeExtra(RemoteViews.EXTRA_REMOTEADAPTER_APPWIDGET_ID);
            } //End block
        } //End collapsed parenthetic
        mWorkerThread = new HandlerThread("RemoteViewsCache-loader");
        mWorkerThread.start();
        mWorkerQueue = new Handler(mWorkerThread.getLooper());
        mMainQueue = new Handler(Looper.myLooper(), this);
        mCache = new FixedSizeRemoteViewsCache(sDefaultCacheSize);
        mCallback = new WeakReference<RemoteAdapterConnectionCallback>(callback);
        mServiceConnection = new RemoteViewsAdapterServiceConnection(this);
        requestBindService();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.210 -0400", hash_original_method = "448EC732CCF4B62AEFADFAF844C3E610", hash_generated_method = "F8018D33E104FFE245C3A165F87FBACB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                mWorkerThread.quit();
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (mWorkerThread != null) {
                //mWorkerThread.quit();
            //}
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.211 -0400", hash_original_method = "34DA0EC600A8592A38E8BB75F944416C", hash_generated_method = "FEF02730C9798F954926A2362591CADB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void loadNextIndexInBackground() {
        mWorkerQueue.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.210 -0400", hash_original_method = "4CF90A1CB7C420A204E3629193269707", hash_generated_method = "03FF6581B74AF4F090C9366FF37F5270")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void run() {
                {
                    boolean varC0AB9EB04FA33F4F43E9EE96AC258E59_460256111 = (mServiceConnection.isConnected());
                    {
                        int position;
                        position = -1;
                        boolean isRequested;
                        isRequested = false;
                        {
                            int[] res;
                            res = mCache.getNextIndexToLoad();
                            position = res[0];
                            isRequested = res[1] > 0;
                        } //End block
                        {
                            updateRemoteViews(position, isRequested);
                            loadNextIndexInBackground();
                        } //End block
                        {
                            enqueueDeferredUnbindServiceMessage();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                // ---------- Original Method ----------
                //if (mServiceConnection.isConnected()) {
                    //int position = -1;
                    //boolean isRequested = false;
                    //synchronized (mCache) {
                        //int[] res = mCache.getNextIndexToLoad();
                        //position = res[0];
                        //isRequested = res[1] > 0;
                    //}
                    //if (position > -1) {
                        //updateRemoteViews(position, isRequested);
                        //loadNextIndexInBackground();
                    //} else {
                        //enqueueDeferredUnbindServiceMessage();
                    //}
                //}
            }
});
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.211 -0400", hash_original_method = "E1B2571B376275F4805513EEE2D5A305", hash_generated_method = "CCDE2198219CDC04A523FCFB50B3F4AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void processException(String method, Exception e) {
        dsTaint.addTaint(e.dsTaint);
        dsTaint.addTaint(method);
        RemoteViewsMetaData metaData;
        metaData = mCache.getMetaData();
        {
            metaData.reset();
        } //End block
        {
            mCache.reset();
        } //End block
        mMainQueue.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.211 -0400", hash_original_method = "20780F1316FA6B5AAEF80ABB110F8A58", hash_generated_method = "9658C6127F239982755926B1BF541104")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void run() {
                superNotifyDataSetChanged();
                // ---------- Original Method ----------
                //superNotifyDataSetChanged();
            }
});
        // ---------- Original Method ----------
        //Log.e("RemoteViewsAdapter", "Error in " + method + ": " + e.getMessage());
        //final RemoteViewsMetaData metaData = mCache.getMetaData();
        //synchronized (metaData) {
            //metaData.reset();
        //}
        //synchronized (mCache) {
            //mCache.reset();
        //}
        //mMainQueue.post(new Runnable() {
            //@Override
            //public void run() {
                //superNotifyDataSetChanged();
            //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.211 -0400", hash_original_method = "49F084C42EF1DBBC4522A49655FF79A1", hash_generated_method = "299374A5441EE24A684829B9040C2B8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateTemporaryMetaData() {
        IRemoteViewsFactory factory;
        factory = mServiceConnection.getRemoteViewsFactory();
        try 
        {
            boolean hasStableIds;
            hasStableIds = factory.hasStableIds();
            int viewTypeCount;
            viewTypeCount = factory.getViewTypeCount();
            int count;
            count = factory.getCount();
            RemoteViews loadingView;
            loadingView = factory.getLoadingView();
            RemoteViews firstView;
            firstView = null;
            {
                firstView = factory.getViewAt(0);
            } //End block
            RemoteViewsMetaData tmpMetaData;
            tmpMetaData = mCache.getTemporaryMetaData();
            {
                tmpMetaData.hasStableIds = hasStableIds;
                tmpMetaData.viewTypeCount = viewTypeCount + 1;
                tmpMetaData.count = count;
                tmpMetaData.setLoadingViewTemplates(loadingView, firstView);
            } //End block
        } //End block
        catch (RemoteException e)
        {
            processException("updateMetaData", e);
        } //End block
        catch (RuntimeException e)
        {
            processException("updateMetaData", e);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.212 -0400", hash_original_method = "5FA96F3EFCF6BBECAF668E31FDA609B8", hash_generated_method = "9E59F8684C4F208367E185F22F86FD53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateRemoteViews(final int position, boolean isRequested) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(isRequested);
        {
            boolean varB639375210F642D25B10B2BDC0461609_1403021773 = (!mServiceConnection.isConnected());
        } //End collapsed parenthetic
        IRemoteViewsFactory factory;
        factory = mServiceConnection.getRemoteViewsFactory();
        RemoteViews remoteViews;
        remoteViews = null;
        long itemId;
        itemId = 0;
        try 
        {
            remoteViews = factory.getViewAt(position);
            itemId = factory.getItemId(position);
        } //End block
        catch (RemoteException e)
        { }
        catch (RuntimeException e)
        { }
        {
            mCache.insert(position, remoteViews, itemId, isRequested);
            RemoteViews rv;
            rv = remoteViews;
            int typeId;
            typeId = mCache.getMetaDataAt(position).typeId;
            mMainQueue.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.212 -0400", hash_original_method = "893654825C9F0EE31547B34AB12EB1B2", hash_generated_method = "EC088C820250E0DE41EE3A77F29725DC")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void run() {
                    mRequestedViews.notifyOnRemoteViewsLoaded(position, rv, typeId);
                    // ---------- Original Method ----------
                    //mRequestedViews.notifyOnRemoteViewsLoaded(position, rv, typeId);
                }
});
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.212 -0400", hash_original_method = "F998EBA4725E32A416A597964901E5AB", hash_generated_method = "A88C9721394EB905258D40AD49975D66")
    @DSModeled(DSC.SPEC)
    public Intent getRemoteViewsServiceIntent() {
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.212 -0400", hash_original_method = "BD4FA508848CEC346AF576100841FA5B", hash_generated_method = "C4FBDAED330C51E9FEABED05F0D48FAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCount() {
        RemoteViewsMetaData metaData;
        metaData = mCache.getMetaData();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final RemoteViewsMetaData metaData = mCache.getMetaData();
        //synchronized (metaData) {
            //return metaData.count;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.213 -0400", hash_original_method = "AE0D3BF5CEF608E0D2B9C47624E8B8EC", hash_generated_method = "FBEDEFB98EEB41E7CC08934C2884C822")
    @DSModeled(DSC.SAFE)
    public Object getItem(int position) {
        dsTaint.addTaint(position);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.213 -0400", hash_original_method = "03B3187C996D144F3BCFDF9DFF16615D", hash_generated_method = "68DBCA121C5A31A22CAF48209E430555")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getItemId(int position) {
        dsTaint.addTaint(position);
        {
            {
                boolean varD27C3F53015470E371413C7BF03B06BD_1126355347 = (mCache.containsMetaDataAt(position));
                {
                    long var474C483542D84722B7B45BC8BD1B907D_1946004688 = (mCache.getMetaDataAt(position).itemId);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //synchronized (mCache) {
            //if (mCache.containsMetaDataAt(position)) {
                //return mCache.getMetaDataAt(position).itemId;
            //}
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.213 -0400", hash_original_method = "BDCE0C462966DEB126F7FB99CEF6A82A", hash_generated_method = "FDA61AF0BC0189B5571A1B1C3FDBB2C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getItemViewType(int position) {
        dsTaint.addTaint(position);
        int typeId;
        typeId = 0;
        {
            {
                boolean varD27C3F53015470E371413C7BF03B06BD_1075968214 = (mCache.containsMetaDataAt(position));
                {
                    typeId = mCache.getMetaDataAt(position).typeId;
                } //End block
            } //End collapsed parenthetic
        } //End block
        RemoteViewsMetaData metaData;
        metaData = mCache.getMetaData();
        {
            int var12B2278118B10569F2BCEC86C96FBA64_1210140811 = (metaData.getMappedViewType(typeId));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int typeId = 0;
        //synchronized (mCache) {
            //if (mCache.containsMetaDataAt(position)) {
                //typeId = mCache.getMetaDataAt(position).typeId;
            //} else {
                //return 0;
            //}
        //}
        //final RemoteViewsMetaData metaData = mCache.getMetaData();
        //synchronized (metaData) {
            //return metaData.getMappedViewType(typeId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.213 -0400", hash_original_method = "A43180B0154FDAA6CD8755A8245F56F8", hash_generated_method = "EE42BAC05EC28CB82DF1CA36FCCE3496")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getConvertViewTypeId(View convertView) {
        dsTaint.addTaint(convertView.dsTaint);
        int typeId;
        typeId = -1;
        {
            Object tag;
            tag = convertView.getTag(com.android.internal.R.id.rowTypeId);
            {
                typeId = (Integer) tag;
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int typeId = -1;
        //if (convertView != null) {
            //Object tag = convertView.getTag(com.android.internal.R.id.rowTypeId);
            //if (tag != null) {
                //typeId = (Integer) tag;
            //}
        //}
        //return typeId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.214 -0400", hash_original_method = "6C789CA1A76BB0C76EA62E1C57E6DD64", hash_generated_method = "BF31D78FC634A684D5C1A6B72BEB405F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getView(int position, View convertView, ViewGroup parent) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        {
            boolean isInCache;
            isInCache = mCache.containsRemoteViewAt(position);
            boolean isConnected;
            isConnected = mServiceConnection.isConnected();
            boolean hasNewItems;
            hasNewItems = false;
            {
                requestBindService();
            } //End block
            {
                hasNewItems = mCache.queuePositionsToBePreloadedFromRequestedPosition(position);
            } //End block
            {
                View convertViewChild;
                convertViewChild = null;
                int convertViewTypeId;
                convertViewTypeId = 0;
                RemoteViewsFrameLayout layout;
                layout = null;
                {
                    layout = (RemoteViewsFrameLayout) convertView;
                    convertViewChild = layout.getChildAt(0);
                    convertViewTypeId = getConvertViewTypeId(convertViewChild);
                } //End block
                Context context;
                context = parent.getContext();
                RemoteViews rv;
                rv = mCache.getRemoteViewsAt(position);
                RemoteViewsIndexMetaData indexMetaData;
                indexMetaData = mCache.getMetaDataAt(position);
                indexMetaData.isRequested = true;
                int typeId;
                typeId = indexMetaData.typeId;
                try 
                {
                    {
                        {
                            rv.reapply(context, convertViewChild);
                        } //End block
                        layout.removeAllViews();
                    } //End block
                    {
                        layout = new RemoteViewsFrameLayout(context);
                    } //End block
                    View newView;
                    newView = rv.apply(context, parent);
                    newView.setTagInternal(com.android.internal.R.id.rowTypeId,
                            new Integer(typeId));
                    layout.addView(newView);
                } //End block
                catch (Exception e)
                {
                    RemoteViewsFrameLayout loadingView;
                    loadingView = null;
                    RemoteViewsMetaData metaData;
                    metaData = mCache.getMetaData();
                    {
                        loadingView = metaData.createLoadingView(position, convertView, parent);
                    } //End block
                } //End block
                finally 
                {
                    loadNextIndexInBackground();
                } //End block
            } //End block
            {
                RemoteViewsFrameLayout loadingView;
                loadingView = null;
                RemoteViewsMetaData metaData;
                metaData = mCache.getMetaData();
                {
                    loadingView = metaData.createLoadingView(position, convertView, parent);
                } //End block
                mRequestedViews.add(position, loadingView);
                mCache.queueRequestedPositionToLoad(position);
                loadNextIndexInBackground();
            } //End block
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.214 -0400", hash_original_method = "E20153FA245BC3D829E7670B1CF87BF9", hash_generated_method = "09036DD5FDB5AB42373E75CD34097293")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getViewTypeCount() {
        RemoteViewsMetaData metaData;
        metaData = mCache.getMetaData();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final RemoteViewsMetaData metaData = mCache.getMetaData();
        //synchronized (metaData) {
            //return metaData.viewTypeCount;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.215 -0400", hash_original_method = "30FBD60CD0291FCC8DBBE0ACB800AAAA", hash_generated_method = "80283E1C1B265F1638153BB3E11562D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasStableIds() {
        RemoteViewsMetaData metaData;
        metaData = mCache.getMetaData();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final RemoteViewsMetaData metaData = mCache.getMetaData();
        //synchronized (metaData) {
            //return metaData.hasStableIds;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.215 -0400", hash_original_method = "53D7DB97161C41CC976317DC7E27F456", hash_generated_method = "E5CBF7D54FCAEE863EDF64FCF30158B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var836519EBBA75D474236DD9A735C5C741_1813510879 = (getCount() <= 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getCount() <= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.215 -0400", hash_original_method = "2DAA079F2CA383CBC7C346F3BCA57054", hash_generated_method = "9966B539ADF1D9E456D98799496D5F7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onNotifyDataSetChanged() {
        IRemoteViewsFactory factory;
        factory = mServiceConnection.getRemoteViewsFactory();
        try 
        {
            factory.onDataSetChanged();
        } //End block
        catch (RemoteException e)
        { }
        catch (RuntimeException e)
        { }
        {
            mCache.reset();
        } //End block
        updateTemporaryMetaData();
        mMainQueue.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.215 -0400", hash_original_method = "599F6D416D0C87E072E14AB486244C9F", hash_generated_method = "E2BF2A1BF355FF99011493BBC7818C77")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void run() {
                {
                    mCache.commitTemporaryMetaData();
                } //End block
                superNotifyDataSetChanged();
                enqueueDeferredUnbindServiceMessage();
                // ---------- Original Method ----------
                //synchronized (mCache) {
                    //mCache.commitTemporaryMetaData();
                //}
                //superNotifyDataSetChanged();
                //enqueueDeferredUnbindServiceMessage();
            }
});
        mNotifyDataSetChangedAfterOnServiceConnected = false;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.216 -0400", hash_original_method = "0764FC8C95C069ED9ED094B35DCC527A", hash_generated_method = "66F0D47D7DECA3B307F2A0940FA78468")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyDataSetChanged() {
        mMainQueue.removeMessages(sUnbindServiceMessageType);
        {
            boolean varB639375210F642D25B10B2BDC0461609_1806709501 = (!mServiceConnection.isConnected());
            {
                mNotifyDataSetChangedAfterOnServiceConnected = true;
                requestBindService();
            } //End block
        } //End collapsed parenthetic
        mWorkerQueue.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.216 -0400", hash_original_method = "041C495048132FF173BFCDF38ABB5707", hash_generated_method = "A0E7FB80DBA0806D596A5B67FD46EBEA")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void run() {
                onNotifyDataSetChanged();
                // ---------- Original Method ----------
                //onNotifyDataSetChanged();
            }
});
        // ---------- Original Method ----------
        //mMainQueue.removeMessages(sUnbindServiceMessageType);
        //if (!mServiceConnection.isConnected()) {
            //if (mNotifyDataSetChangedAfterOnServiceConnected) {
                //return;
            //}
            //mNotifyDataSetChangedAfterOnServiceConnected = true;
            //requestBindService();
            //return;
        //}
        //mWorkerQueue.post(new Runnable() {
            //@Override
            //public void run() {
                //onNotifyDataSetChanged();
            //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.216 -0400", hash_original_method = "A1EDDF3811A1F9D28CCD28C93269FAD1", hash_generated_method = "13135540CF0C096F7922371AE0301E89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void superNotifyDataSetChanged() {
        super.notifyDataSetChanged();
        // ---------- Original Method ----------
        //super.notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.216 -0400", hash_original_method = "96758E0B3254F3B4A777FC060A49CC59", hash_generated_method = "410256CF2F38EA63494D53E79B3F2AA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        boolean result;
        result = false;
        //Begin case sUnbindServiceMessageType 
        {
            boolean varAF0014E6961178BB03E6A35A2A9D4C03_798530078 = (mServiceConnection.isConnected());
            {
                mServiceConnection.unbind(mContext, mAppWidgetId, mIntent);
            } //End block
        } //End collapsed parenthetic
        //End case sUnbindServiceMessageType 
        //Begin case sUnbindServiceMessageType 
        result = true;
        //End case sUnbindServiceMessageType 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean result = false;
        //switch (msg.what) {
        //case sUnbindServiceMessageType:
            //if (mServiceConnection.isConnected()) {
                //mServiceConnection.unbind(mContext, mAppWidgetId, mIntent);
            //}
            //result = true;
            //break;
        //default:
            //break;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.216 -0400", hash_original_method = "D880D88722499DDF7E3D229A00764CBB", hash_generated_method = "8943C3C3F64C9B76CBBF6A8AA4DF52C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void enqueueDeferredUnbindServiceMessage() {
        mMainQueue.removeMessages(sUnbindServiceMessageType);
        mMainQueue.sendEmptyMessageDelayed(sUnbindServiceMessageType, sUnbindServiceDelay);
        // ---------- Original Method ----------
        //mMainQueue.removeMessages(sUnbindServiceMessageType);
        //mMainQueue.sendEmptyMessageDelayed(sUnbindServiceMessageType, sUnbindServiceDelay);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.217 -0400", hash_original_method = "FD0BDD14354B6205FD4E5E773D9BDB6D", hash_generated_method = "314A092CF165EC47198BF54471C169F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean requestBindService() {
        {
            boolean varB639375210F642D25B10B2BDC0461609_10938528 = (!mServiceConnection.isConnected());
            {
                mServiceConnection.bind(mContext, mAppWidgetId, mIntent);
            } //End block
        } //End collapsed parenthetic
        mMainQueue.removeMessages(sUnbindServiceMessageType);
        boolean var9194E623990DE28F1BF24202733015EB_30361525 = (mServiceConnection.isConnected());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!mServiceConnection.isConnected()) {
            //mServiceConnection.bind(mContext, mAppWidgetId, mIntent);
        //}
        //mMainQueue.removeMessages(sUnbindServiceMessageType);
        //return mServiceConnection.isConnected();
    }

    
    private static class RemoteViewsAdapterServiceConnection extends IRemoteViewsAdapterConnection.Stub {
        private boolean mIsConnected;
        private boolean mIsConnecting;
        private WeakReference<RemoteViewsAdapter> mAdapter;
        private IRemoteViewsFactory mRemoteViewsFactory;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.217 -0400", hash_original_method = "7E10295116D6DF0B2080F7EEB3B8FF2F", hash_generated_method = "DFA03CBB149457660DD1F3D01396FDA0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RemoteViewsAdapterServiceConnection(RemoteViewsAdapter adapter) {
            dsTaint.addTaint(adapter.dsTaint);
            mAdapter = new WeakReference<RemoteViewsAdapter>(adapter);
            // ---------- Original Method ----------
            //mAdapter = new WeakReference<RemoteViewsAdapter>(adapter);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.217 -0400", hash_original_method = "8522D247C3B96C2C6A0E0A6DFCD61958", hash_generated_method = "ED9118E7F24F20DB020B8E23FAF3B673")
        @DSModeled(DSC.SPEC)
        public synchronized void bind(Context context, int appWidgetId, Intent intent) {
            dsTaint.addTaint(appWidgetId);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            {
                try 
                {
                    AppWidgetManager mgr;
                    mgr = AppWidgetManager.getInstance(context);
                    mgr.bindRemoteViewsService(appWidgetId, intent, asBinder());
                    mIsConnecting = true;
                } //End block
                catch (Exception e)
                {
                    mIsConnecting = false;
                    mIsConnected = false;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (!mIsConnecting) {
                //try {
                    //final AppWidgetManager mgr = AppWidgetManager.getInstance(context);
                    //mgr.bindRemoteViewsService(appWidgetId, intent, asBinder());
                    //mIsConnecting = true;
                //} catch (Exception e) {
                    //Log.e("RemoteViewsAdapterServiceConnection", "bind(): " + e.getMessage());
                    //mIsConnecting = false;
                    //mIsConnected = false;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.217 -0400", hash_original_method = "21A72C8FC580D8D0E809A3FEE2FDD93D", hash_generated_method = "EC65DF8BDA6793C62FD915B80A5670F2")
        @DSModeled(DSC.SPEC)
        public synchronized void unbind(Context context, int appWidgetId, Intent intent) {
            dsTaint.addTaint(appWidgetId);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            try 
            {
                AppWidgetManager mgr;
                mgr = AppWidgetManager.getInstance(context);
                mgr.unbindRemoteViewsService(appWidgetId, intent);
                mIsConnecting = false;
            } //End block
            catch (Exception e)
            {
                mIsConnecting = false;
                mIsConnected = false;
            } //End block
            // ---------- Original Method ----------
            //try {
                //final AppWidgetManager mgr = AppWidgetManager.getInstance(context);
                //mgr.unbindRemoteViewsService(appWidgetId, intent);
                //mIsConnecting = false;
            //} catch (Exception e) {
                //Log.e("RemoteViewsAdapterServiceConnection", "unbind(): " + e.getMessage());
                //mIsConnecting = false;
                //mIsConnected = false;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.219 -0400", hash_original_method = "08CA49D02360F6C2A6BB2EFEF11F092E", hash_generated_method = "CE9B94CE7CD2919D3BE2D2697BD4C760")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized void onServiceConnected(IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(service.dsTaint);
            mRemoteViewsFactory = IRemoteViewsFactory.Stub.asInterface(service);
            RemoteViewsAdapter adapter;
            adapter = mAdapter.get();
            adapter.mWorkerQueue.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.219 -0400", hash_original_method = "C9280BFFF3D57DCE91D4B8E9AF737343", hash_generated_method = "6C8CA1A49D60670F6806A4EB766AD5DB")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void run() {
                    {
                        adapter.onNotifyDataSetChanged();
                    } //End block
                    {
                        IRemoteViewsFactory factory;
                        factory = adapter.mServiceConnection.getRemoteViewsFactory();
                        try 
                        {
                            {
                                boolean varDC9A171480612B8E4508A865A137D536_1506746580 = (!factory.isCreated());
                                {
                                    factory.onDataSetChanged();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        catch (RemoteException e)
                        { }
                        catch (RuntimeException e)
                        { }
                        adapter.updateTemporaryMetaData();
                        adapter.mMainQueue.post(new Runnable() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.219 -0400", hash_original_method = "15183F885AD888FE838F648B256AD495", hash_generated_method = "DC687C66FDC1BCFD542253E403151160")
                            //DSFIXME:  CODE0002: Requires DSC value to be set
                            @Override
                            public void run() {
                                {
                                    adapter.mCache.commitTemporaryMetaData();
                                } //End block
                                RemoteAdapterConnectionCallback callback;
                                callback = adapter.mCallback.get();
                                {
                                    callback.onRemoteAdapterConnected();
                                } //End block
                                // ---------- Original Method ----------
                                //synchronized (adapter.mCache) {
                                    //adapter.mCache.commitTemporaryMetaData();
                                //}
                                //final RemoteAdapterConnectionCallback callback =
                                    //adapter.mCallback.get();
                                //if (callback != null) {
                                    //callback.onRemoteAdapterConnected();
                                //}
                            }
});
                    } //End block
                    adapter.enqueueDeferredUnbindServiceMessage();
                    mIsConnected = true;
                    mIsConnecting = false;
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
});
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.220 -0400", hash_original_method = "6AD1D56D3A677AEA97BA981AA56DEDEB", hash_generated_method = "A1B0367F85AD93B6FFA85F0D1B7CD1DC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized void onServiceDisconnected() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mIsConnected = false;
            mIsConnecting = false;
            mRemoteViewsFactory = null;
            RemoteViewsAdapter adapter;
            adapter = mAdapter.get();
            adapter.mMainQueue.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.220 -0400", hash_original_method = "5256C3FE0B7F0EC8DBD6E0D8928BE4C4", hash_generated_method = "81A8663CC3FB114C9D301586A0FCD2BF")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void run() {
                    adapter.mMainQueue.removeMessages(sUnbindServiceMessageType);
                    RemoteAdapterConnectionCallback callback;
                    callback = adapter.mCallback.get();
                    {
                        callback.onRemoteAdapterDisconnected();
                    } //End block
                    // ---------- Original Method ----------
                    //adapter.mMainQueue.removeMessages(sUnbindServiceMessageType);
                    //final RemoteAdapterConnectionCallback callback = adapter.mCallback.get();
                    //if (callback != null) {
                        //callback.onRemoteAdapterDisconnected();
                    //}
                }
});
            // ---------- Original Method ----------
            //mIsConnected = false;
            //mIsConnecting = false;
            //mRemoteViewsFactory = null;
            //final RemoteViewsAdapter adapter = mAdapter.get();
            //if (adapter == null) return;
            //adapter.mMainQueue.post(new Runnable() {
                //@Override
                //public void run() {
                    //adapter.mMainQueue.removeMessages(sUnbindServiceMessageType);
                    //final RemoteAdapterConnectionCallback callback = adapter.mCallback.get();
                    //if (callback != null) {
                        //callback.onRemoteAdapterDisconnected();
                    //}
                //}
            //});
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.221 -0400", hash_original_method = "9AC2F72588B70E9E489A1C9892FF58B7", hash_generated_method = "4E82D030DDA74EDE8DDE3CE7EE84F106")
        @DSModeled(DSC.SAFE)
        public synchronized IRemoteViewsFactory getRemoteViewsFactory() {
            return (IRemoteViewsFactory)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mRemoteViewsFactory;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.221 -0400", hash_original_method = "EB76BB3DACEAD8AEFFF382088AE69C8F", hash_generated_method = "F2817BC768778B43F3EC3C67A295C643")
        @DSModeled(DSC.SAFE)
        public synchronized boolean isConnected() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mIsConnected;
        }

        
    }


    
    private class RemoteViewsFrameLayout extends FrameLayout {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.221 -0400", hash_original_method = "15F65CD5E3BE0169B47C7BF19C42CB6A", hash_generated_method = "BE1118DA6EDFB28797927C8A61845E67")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RemoteViewsFrameLayout(Context context) {
            super(context);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.221 -0400", hash_original_method = "376943697B2A7028E475228F1F5698F0", hash_generated_method = "9C04F272D0C597F35DBC07AB3E7B2471")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onRemoteViewsLoaded(RemoteViews view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(view.dsTaint);
            try 
            {
                removeAllViews();
                addView(view.apply(getContext(), this));
            } //End block
            catch (Exception e)
            { }
            // ---------- Original Method ----------
            //try {
                //removeAllViews();
                //addView(view.apply(getContext(), this));
            //} catch (Exception e) {
                //Log.e(TAG, "Failed to apply RemoteViews.");
            //}
        }

        
    }


    
    private class RemoteViewsFrameLayoutRefSet {
        private HashMap<Integer, LinkedList<RemoteViewsFrameLayout>> mReferences;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.222 -0400", hash_original_method = "6FF139149B49AE6D730172FAFB07DD3B", hash_generated_method = "04F49291A2A41B3FE0D9405505C49E32")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RemoteViewsFrameLayoutRefSet() {
            mReferences = new HashMap<Integer, LinkedList<RemoteViewsFrameLayout>>();
            // ---------- Original Method ----------
            //mReferences = new HashMap<Integer, LinkedList<RemoteViewsFrameLayout>>();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.222 -0400", hash_original_method = "3F0456D57D98DD5B5AAA7D7D24636D4D", hash_generated_method = "39BA87F8DD721A9FD4FC3F500CDA81B0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void add(int position, RemoteViewsFrameLayout layout) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(layout.dsTaint);
            Integer pos;
            pos = position;
            LinkedList<RemoteViewsFrameLayout> refs;
            {
                boolean var1C724F4D3C0F3C792D0F2FED4BE4566F_993432050 = (mReferences.containsKey(pos));
                {
                    refs = mReferences.get(pos);
                } //End block
                {
                    refs = new LinkedList<RemoteViewsFrameLayout>();
                    mReferences.put(pos, refs);
                } //End block
            } //End collapsed parenthetic
            refs.add(layout);
            // ---------- Original Method ----------
            //final Integer pos = position;
            //LinkedList<RemoteViewsFrameLayout> refs;
            //if (mReferences.containsKey(pos)) {
                //refs = mReferences.get(pos);
            //} else {
                //refs = new LinkedList<RemoteViewsFrameLayout>();
                //mReferences.put(pos, refs);
            //}
            //refs.add(layout);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.228 -0400", hash_original_method = "B75D35E25E548F04E2C73EAA0A8BAD12", hash_generated_method = "C92D39094202595EB0038705B7802C20")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void notifyOnRemoteViewsLoaded(int position, RemoteViews view, int typeId) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(view.dsTaint);
            dsTaint.addTaint(typeId);
            Integer pos;
            pos = position;
            {
                boolean var1C724F4D3C0F3C792D0F2FED4BE4566F_564737339 = (mReferences.containsKey(pos));
                {
                    LinkedList<RemoteViewsFrameLayout> refs;
                    refs = mReferences.get(pos);
                    {
                        Iterator<RemoteViewsFrameLayout> varF330A8C22FC56F2EBE7DC0926BA301AB_1878895515 = (refs).iterator();
                        varF330A8C22FC56F2EBE7DC0926BA301AB_1878895515.hasNext();
                        final RemoteViewsFrameLayout ref = varF330A8C22FC56F2EBE7DC0926BA301AB_1878895515.next();
                        {
                            ref.onRemoteViewsLoaded(view);
                        } //End block
                    } //End collapsed parenthetic
                    refs.clear();
                    mReferences.remove(pos);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (view == null) return;
            //final Integer pos = position;
            //if (mReferences.containsKey(pos)) {
                //final LinkedList<RemoteViewsFrameLayout> refs = mReferences.get(pos);
                //for (final RemoteViewsFrameLayout ref : refs) {
                    //ref.onRemoteViewsLoaded(view);
                //}
                //refs.clear();
                //mReferences.remove(pos);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.229 -0400", hash_original_method = "A232CA036EBBA3D167286637450EBE5D", hash_generated_method = "24EBFCA05188B87B49D1A34189D809C7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clear() {
            mReferences.clear();
            // ---------- Original Method ----------
            //mReferences.clear();
        }

        
    }


    
    private class RemoteViewsMetaData {
        int count;
        int viewTypeCount;
        boolean hasStableIds;
        RemoteViews mUserLoadingView;
        RemoteViews mFirstView;
        int mFirstViewHeight;
        private HashMap<Integer, Integer> mTypeIdIndexMap = new HashMap<Integer, Integer>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.229 -0400", hash_original_method = "A4C124A869EBADBA9AE6D60BBB8A7C9F", hash_generated_method = "3DCD91096CB130F5938CD8D146151676")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RemoteViewsMetaData() {
            reset();
            // ---------- Original Method ----------
            //reset();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.230 -0400", hash_original_method = "90BA893E06B3709572F4D6BD4487FB6C", hash_generated_method = "36831DBAD4F58AA46852BB3688F7FD4B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void set(RemoteViewsMetaData d) {
            dsTaint.addTaint(d.dsTaint);
            {
                count = d.count;
                viewTypeCount = d.viewTypeCount;
                hasStableIds = d.hasStableIds;
                setLoadingViewTemplates(d.mUserLoadingView, d.mFirstView);
            } //End block
            // ---------- Original Method ----------
            //synchronized (d) {
                //count = d.count;
                //viewTypeCount = d.viewTypeCount;
                //hasStableIds = d.hasStableIds;
                //setLoadingViewTemplates(d.mUserLoadingView, d.mFirstView);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.230 -0400", hash_original_method = "AE7C296E4C5BBC73F59980BD54540BF2", hash_generated_method = "E27E2C57D2D5002944558FDACF04DF1D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void reset() {
            count = 0;
            viewTypeCount = 1;
            hasStableIds = true;
            mUserLoadingView = null;
            mFirstView = null;
            mFirstViewHeight = 0;
            mTypeIdIndexMap.clear();
            // ---------- Original Method ----------
            //count = 0;
            //viewTypeCount = 1;
            //hasStableIds = true;
            //mUserLoadingView = null;
            //mFirstView = null;
            //mFirstViewHeight = 0;
            //mTypeIdIndexMap.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.230 -0400", hash_original_method = "E784F858D155FE6C94A91B290D47017F", hash_generated_method = "BB9E8AF892C241ED8AA6F79592EC3E2E")
        @DSModeled(DSC.SAFE)
        public void setLoadingViewTemplates(RemoteViews loadingView, RemoteViews firstView) {
            dsTaint.addTaint(firstView.dsTaint);
            dsTaint.addTaint(loadingView.dsTaint);
            {
                mFirstViewHeight = -1;
            } //End block
            // ---------- Original Method ----------
            //mUserLoadingView = loadingView;
            //if (firstView != null) {
                //mFirstView = firstView;
                //mFirstViewHeight = -1;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.230 -0400", hash_original_method = "78DD70270396881EC8B9AE912C927B26", hash_generated_method = "3845F1309DC81CFF771060093B7FF5EF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getMappedViewType(int typeId) {
            dsTaint.addTaint(typeId);
            {
                boolean varE72D96C2A7631C4D4068420790F0E31A_671365039 = (mTypeIdIndexMap.containsKey(typeId));
                {
                    int varDEAAB1FACE77CC174C29AD8F052D40B4_2079924360 = (mTypeIdIndexMap.get(typeId));
                } //End block
                {
                    int incrementalTypeId;
                    incrementalTypeId = mTypeIdIndexMap.size() + 1;
                    mTypeIdIndexMap.put(typeId, incrementalTypeId);
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (mTypeIdIndexMap.containsKey(typeId)) {
                //return mTypeIdIndexMap.get(typeId);
            //} else {
                //int incrementalTypeId = mTypeIdIndexMap.size() + 1;
                //mTypeIdIndexMap.put(typeId, incrementalTypeId);
                //return incrementalTypeId;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.231 -0400", hash_original_method = "6B923D58C715B2F45FA359F8E18C8A1F", hash_generated_method = "7F582F92D943C6531274487CA41A5ADD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private RemoteViewsFrameLayout createLoadingView(int position, View convertView,
                ViewGroup parent) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(parent.dsTaint);
            dsTaint.addTaint(convertView.dsTaint);
            Context context;
            context = parent.getContext();
            RemoteViewsFrameLayout layout;
            layout = new RemoteViewsFrameLayout(context);
            {
                boolean customLoadingViewAvailable;
                customLoadingViewAvailable = false;
                {
                    try 
                    {
                        View loadingView;
                        loadingView = mUserLoadingView.apply(parent.getContext(), parent);
                        loadingView.setTagInternal(com.android.internal.R.id.rowTypeId,
                                new Integer(0));
                        layout.addView(loadingView);
                        customLoadingViewAvailable = true;
                    } //End block
                    catch (Exception e)
                    { }
                } //End block
                {
                    {
                        try 
                        {
                            View firstView;
                            firstView = mFirstView.apply(parent.getContext(), parent);
                            firstView.measure(
                                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
                                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                            mFirstViewHeight = firstView.getMeasuredHeight();
                            mFirstView = null;
                        } //End block
                        catch (Exception e)
                        {
                            float density;
                            density = mContext.getResources().getDisplayMetrics().density;
                            mFirstViewHeight = (int)
                                    Math.round(sDefaultLoadingViewHeight * density);
                            mFirstView = null;
                        } //End block
                    } //End block
                    TextView loadingTextView;
                    loadingTextView = (TextView) mLayoutInflater.inflate(
                            com.android.internal.R.layout.remote_views_adapter_default_loading_view,
                            layout, false);
                    loadingTextView.setHeight(mFirstViewHeight);
                    loadingTextView.setTag(new Integer(0));
                    layout.addView(loadingTextView);
                } //End block
            } //End block
            return (RemoteViewsFrameLayout)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class RemoteViewsIndexMetaData {
        int typeId;
        long itemId;
        boolean isRequested;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.231 -0400", hash_original_method = "429CAA99D27E695F91D025FEB15660FB", hash_generated_method = "791C9A0D17E92496D015E4B8F65E01F5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RemoteViewsIndexMetaData(RemoteViews v, long itemId, boolean requested) {
            dsTaint.addTaint(requested);
            dsTaint.addTaint(v.dsTaint);
            dsTaint.addTaint(itemId);
            set(v, itemId, requested);
            // ---------- Original Method ----------
            //set(v, itemId, requested);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.231 -0400", hash_original_method = "6F36A962FFB607392BC2E34875EB4BD4", hash_generated_method = "7BEDEB8F6103C13B32EE92363874CAB4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void set(RemoteViews v, long id, boolean requested) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(requested);
            dsTaint.addTaint(v.dsTaint);
            typeId = v.getLayoutId();
            typeId = 0;
            // ---------- Original Method ----------
            //itemId = id;
            //if (v != null)
                //typeId = v.getLayoutId();
            //else
                //typeId = 0;
            //isRequested = requested;
        }

        
    }


    
    private class FixedSizeRemoteViewsCache {
        private RemoteViewsMetaData mMetaData;
        private RemoteViewsMetaData mTemporaryMetaData;
        private HashMap<Integer, RemoteViewsIndexMetaData> mIndexMetaData;
        private HashMap<Integer, RemoteViews> mIndexRemoteViews;
        private HashSet<Integer> mRequestedIndices;
        private int mLastRequestedIndex;
        private HashSet<Integer> mLoadIndices;
        private int mPreloadLowerBound;
        private int mPreloadUpperBound;
        private int mMaxCount;
        private int mMaxCountSlack;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.232 -0400", hash_original_method = "AFDF05837CF8EF03047EB57BF9703B63", hash_generated_method = "3198954DA57445C3360C946C73A69949")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public FixedSizeRemoteViewsCache(int maxCacheSize) {
            dsTaint.addTaint(maxCacheSize);
            mMaxCountSlack = Math.round(sMaxCountSlackPercent * (mMaxCount / 2));
            mPreloadLowerBound = 0;
            mPreloadUpperBound = -1;
            mMetaData = new RemoteViewsMetaData();
            mTemporaryMetaData = new RemoteViewsMetaData();
            mIndexMetaData = new HashMap<Integer, RemoteViewsIndexMetaData>();
            mIndexRemoteViews = new HashMap<Integer, RemoteViews>();
            mRequestedIndices = new HashSet<Integer>();
            mLastRequestedIndex = -1;
            mLoadIndices = new HashSet<Integer>();
            // ---------- Original Method ----------
            //mMaxCount = maxCacheSize;
            //mMaxCountSlack = Math.round(sMaxCountSlackPercent * (mMaxCount / 2));
            //mPreloadLowerBound = 0;
            //mPreloadUpperBound = -1;
            //mMetaData = new RemoteViewsMetaData();
            //mTemporaryMetaData = new RemoteViewsMetaData();
            //mIndexMetaData = new HashMap<Integer, RemoteViewsIndexMetaData>();
            //mIndexRemoteViews = new HashMap<Integer, RemoteViews>();
            //mRequestedIndices = new HashSet<Integer>();
            //mLastRequestedIndex = -1;
            //mLoadIndices = new HashSet<Integer>();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.232 -0400", hash_original_method = "3B60FC97D93DDECF59F968EA9F5DCEA5", hash_generated_method = "6907B54DA53DC301727D21F1CB2D009C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void insert(int position, RemoteViews v, long itemId, boolean isRequested) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(v.dsTaint);
            dsTaint.addTaint(isRequested);
            dsTaint.addTaint(itemId);
            {
                boolean var939008B18DF5E8077A7FBD0DE42BA383_727789035 = (mIndexRemoteViews.size() >= mMaxCount);
                {
                    mIndexRemoteViews.remove(getFarthestPositionFrom(position));
                } //End block
            } //End collapsed parenthetic
            int pruneFromPosition;
            pruneFromPosition = mLastRequestedIndex;
            pruneFromPosition = position;
            {
                boolean varA90EF5BC5B38B66F275CC4234FBC71D6_892524026 = (getRemoteViewsBitmapMemoryUsage() >= sMaxMemoryLimitInBytes);
                {
                    mIndexRemoteViews.remove(getFarthestPositionFrom(pruneFromPosition));
                } //End block
            } //End collapsed parenthetic
            {
                boolean var72540E4749D1AF0B6940B3AE7BC6ED24_164737517 = (mIndexMetaData.containsKey(position));
                {
                    RemoteViewsIndexMetaData metaData;
                    metaData = mIndexMetaData.get(position);
                    metaData.set(v, itemId, isRequested);
                } //End block
                {
                    mIndexMetaData.put(position, new RemoteViewsIndexMetaData(v, itemId, isRequested));
                } //End block
            } //End collapsed parenthetic
            mIndexRemoteViews.put(position, v);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.232 -0400", hash_original_method = "CE79B98C6EC29820DC37D3CBF74EA749", hash_generated_method = "C7A75BBEE0D5247A6081DE598D02BB68")
        @DSModeled(DSC.SAFE)
        public RemoteViewsMetaData getMetaData() {
            return (RemoteViewsMetaData)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mMetaData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.233 -0400", hash_original_method = "1D24E06D74C40EECF68D58BAFBBECA77", hash_generated_method = "04740C471769EFE7AF2804DAA09A9C56")
        @DSModeled(DSC.SAFE)
        public RemoteViewsMetaData getTemporaryMetaData() {
            return (RemoteViewsMetaData)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mTemporaryMetaData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.233 -0400", hash_original_method = "2697DBEF8CDE0991B3151B5A3E03C7EB", hash_generated_method = "91FE3E0825794EF8AF38BFD37935A840")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RemoteViews getRemoteViewsAt(int position) {
            dsTaint.addTaint(position);
            {
                boolean var32A42C87332588C7B746B90566692371_1324128454 = (mIndexRemoteViews.containsKey(position));
                {
                    RemoteViews var5D161914AC9578412FACA9297F56BDAE_1996572850 = (mIndexRemoteViews.get(position));
                } //End block
            } //End collapsed parenthetic
            return (RemoteViews)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mIndexRemoteViews.containsKey(position)) {
                //return mIndexRemoteViews.get(position);
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.233 -0400", hash_original_method = "1A017214F368969D3B3DFEA7A0D6E60A", hash_generated_method = "80D4149BEC04A3FFD7650F382866E756")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RemoteViewsIndexMetaData getMetaDataAt(int position) {
            dsTaint.addTaint(position);
            {
                boolean var72540E4749D1AF0B6940B3AE7BC6ED24_1058051572 = (mIndexMetaData.containsKey(position));
                {
                    RemoteViewsIndexMetaData var7E145E7F210763193C2C0786720ED024_265338867 = (mIndexMetaData.get(position));
                } //End block
            } //End collapsed parenthetic
            return (RemoteViewsIndexMetaData)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mIndexMetaData.containsKey(position)) {
                //return mIndexMetaData.get(position);
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.233 -0400", hash_original_method = "4EDEA047857C8C00C25F35FE7AF06430", hash_generated_method = "1D4CCC8D134AFD2F49BFF6463D69F191")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void commitTemporaryMetaData() {
            {
                {
                    mMetaData.set(mTemporaryMetaData);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (mTemporaryMetaData) {
                //synchronized (mMetaData) {
                    //mMetaData.set(mTemporaryMetaData);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.236 -0400", hash_original_method = "1379738D9DE8B74BE60C7743F79F9609", hash_generated_method = "6B010625AAA0A5A02B8F57F1D3DCC0E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int getRemoteViewsBitmapMemoryUsage() {
            int mem;
            mem = 0;
            {
                Iterator<Integer> varB4A935C4A5ED4E6907A65608913D6FD2_1849456026 = (mIndexRemoteViews.keySet()).iterator();
                varB4A935C4A5ED4E6907A65608913D6FD2_1849456026.hasNext();
                Integer i = varB4A935C4A5ED4E6907A65608913D6FD2_1849456026.next();
                {
                    RemoteViews v;
                    v = mIndexRemoteViews.get(i);
                    {
                        mem += v.estimateBitmapMemoryUsage();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int mem = 0;
            //for (Integer i : mIndexRemoteViews.keySet()) {
                //final RemoteViews v = mIndexRemoteViews.get(i);
                //if (v != null) {
                    //mem += v.estimateBitmapMemoryUsage();
                //}
            //}
            //return mem;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.240 -0400", hash_original_method = "61B11826B25E039221975DE702D21975", hash_generated_method = "42D850DC94C17E6D3075859012405BBC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int getFarthestPositionFrom(int pos) {
            dsTaint.addTaint(pos);
            int maxDist;
            maxDist = 0;
            int maxDistIndex;
            maxDistIndex = -1;
            int maxDistNonRequested;
            maxDistNonRequested = 0;
            int maxDistIndexNonRequested;
            maxDistIndexNonRequested = -1;
            {
                Iterator<Integer> var2A4FD0A1CC1361CFD41095D31F4E5EF1_1823157988 = (mIndexRemoteViews.keySet()).iterator();
                var2A4FD0A1CC1361CFD41095D31F4E5EF1_1823157988.hasNext();
                int i = var2A4FD0A1CC1361CFD41095D31F4E5EF1_1823157988.next();
                {
                    int dist;
                    dist = Math.abs(i-pos);
                    {
                        boolean var6BEEB46AA5DD9DD36399D77D50EBA9AD_1929747308 = (dist > maxDistNonRequested && !mIndexMetaData.get(i).isRequested);
                        {
                            maxDistIndexNonRequested = i;
                            maxDistNonRequested = dist;
                        } //End block
                    } //End collapsed parenthetic
                    {
                        maxDistIndex = i;
                        maxDist = dist;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.241 -0400", hash_original_method = "FD296F73133B242F283CE39F258C0B72", hash_generated_method = "3E485ADF83378FEA0A12498F0492C882")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void queueRequestedPositionToLoad(int position) {
            dsTaint.addTaint(position);
            {
                mRequestedIndices.add(position);
                mLoadIndices.add(position);
            } //End block
            // ---------- Original Method ----------
            //mLastRequestedIndex = position;
            //synchronized (mLoadIndices) {
                //mRequestedIndices.add(position);
                //mLoadIndices.add(position);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.241 -0400", hash_original_method = "5E1B16EBD16301761756030AADF8738C", hash_generated_method = "766AC1905B0270B47065FECF9AF477C9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean queuePositionsToBePreloadedFromRequestedPosition(int position) {
            dsTaint.addTaint(position);
            {
                int center;
                center = (mPreloadUpperBound + mPreloadLowerBound) / 2;
                {
                    boolean var0636EC1C871015A7D4DCFF8D3BC97F2F_634430686 = (Math.abs(position - center) < mMaxCountSlack);
                } //End collapsed parenthetic
            } //End block
            int count;
            count = 0;
            {
                count = mMetaData.count;
            } //End block
            {
                mLoadIndices.clear();
                mLoadIndices.addAll(mRequestedIndices);
                int halfMaxCount;
                halfMaxCount = mMaxCount / 2;
                mPreloadLowerBound = position - halfMaxCount;
                mPreloadUpperBound = position + halfMaxCount;
                int effectiveLowerBound;
                effectiveLowerBound = Math.max(0, mPreloadLowerBound);
                int effectiveUpperBound;
                effectiveUpperBound = Math.min(mPreloadUpperBound, count - 1);
                {
                    int i;
                    i = effectiveLowerBound;
                    {
                        mLoadIndices.add(i);
                    } //End block
                } //End collapsed parenthetic
                mLoadIndices.removeAll(mIndexRemoteViews.keySet());
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.241 -0400", hash_original_method = "06D7248AE2FAA4148F7714FEE4BB20F2", hash_generated_method = "1FE8489AFC80BAD4143AEB3F75009F75")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int[] getNextIndexToLoad() {
            {
                {
                    boolean varBECF22EC8775578383214E68E20C33B3_974456532 = (!mRequestedIndices.isEmpty());
                    {
                        Integer i;
                        i = mRequestedIndices.iterator().next();
                        mRequestedIndices.remove(i);
                        mLoadIndices.remove(i);
                        int[] varC013EB5EEFD0F9EB7779B8A5F2170050_883206624 = (new int[]{i.intValue(), 1});
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var7A0A9A32B15C45A9D3C895959BD665DF_1325841796 = (!mLoadIndices.isEmpty());
                    {
                        Integer i;
                        i = mLoadIndices.iterator().next();
                        mLoadIndices.remove(i);
                        int[] var714C8054CC6177CA3595BC84F9003BF3_2135273703 = (new int[]{i.intValue(), 0});
                    } //End block
                } //End collapsed parenthetic
                int[] varC300C018DCB4F12CE19FE658B052C1CA_1551691126 = (new int[]{-1, 0});
            } //End block
            int[] retVal = new int[1];
            retVal[0] = dsTaint.getTaintInt();
            return retVal;
            // ---------- Original Method ----------
            //synchronized (mLoadIndices) {
                //if (!mRequestedIndices.isEmpty()) {
                    //Integer i = mRequestedIndices.iterator().next();
                    //mRequestedIndices.remove(i);
                    //mLoadIndices.remove(i);
                    //return new int[]{i.intValue(), 1};
                //}
                //if (!mLoadIndices.isEmpty()) {
                    //Integer i = mLoadIndices.iterator().next();
                    //mLoadIndices.remove(i);
                    //return new int[]{i.intValue(), 0};
                //}
                //return new int[]{-1, 0};
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.242 -0400", hash_original_method = "BBBDB78E47117BE8689A9C55BD30A227", hash_generated_method = "DA88236AF15F21C53F0DD100DFAFDE5A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean containsRemoteViewAt(int position) {
            dsTaint.addTaint(position);
            boolean var2B18D7F842F074CBB8C22809C9ED8805_1288296979 = (mIndexRemoteViews.containsKey(position));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mIndexRemoteViews.containsKey(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.242 -0400", hash_original_method = "97177722E4C5BA4D6397E6B225C059F2", hash_generated_method = "468EE29B873D32870909F2F02158D723")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean containsMetaDataAt(int position) {
            dsTaint.addTaint(position);
            boolean var387071935791AAD5E2A4FFC958E81C03_1457330723 = (mIndexMetaData.containsKey(position));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mIndexMetaData.containsKey(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.242 -0400", hash_original_method = "7D514E4141E3BAA67EC2DA2CF01B70A8", hash_generated_method = "8778164A936710645B2123EC88F21BC5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void reset() {
            mPreloadLowerBound = 0;
            mPreloadUpperBound = -1;
            mLastRequestedIndex = -1;
            mIndexRemoteViews.clear();
            mIndexMetaData.clear();
            {
                mRequestedIndices.clear();
                mLoadIndices.clear();
            } //End block
            // ---------- Original Method ----------
            //mPreloadLowerBound = 0;
            //mPreloadUpperBound = -1;
            //mLastRequestedIndex = -1;
            //mIndexRemoteViews.clear();
            //mIndexMetaData.clear();
            //synchronized (mLoadIndices) {
                //mRequestedIndices.clear();
                //mLoadIndices.clear();
            //}
        }

        
        private static final String TAG = "FixedSizeRemoteViewsCache";
        private static final float sMaxCountSlackPercent = 0.75f;
        private static final int sMaxMemoryLimitInBytes = 2 * 1024 * 1024;
    }


    
    public interface RemoteAdapterConnectionCallback {
        
        public boolean onRemoteAdapterConnected();

        public void onRemoteAdapterDisconnected();

        
        public void deferNotifyDataSetChanged();
    }
    
    private static final String TAG = "RemoteViewsAdapter";
    private static final int sDefaultCacheSize = 40;
    private static final int sUnbindServiceDelay = 5000;
    private static final int sDefaultLoadingViewHeight = 50;
    private static final int sDefaultMessageType = 0;
    private static final int sUnbindServiceMessageType = 1;
}

