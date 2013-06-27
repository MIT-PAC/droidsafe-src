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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.813 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.813 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.813 -0400", hash_original_field = "905A4BBD5E07D0C7A80D7BBC86A773FE", hash_generated_field = "B6D817E86C2105E427B243C6F2B8620A")

    private int mAppWidgetId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.813 -0400", hash_original_field = "C443A03F92046D0F01F0B3A84FC6B50F", hash_generated_field = "6C3DDC70E78FA863A6FCDBA124DEDF31")

    private LayoutInflater mLayoutInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.813 -0400", hash_original_field = "94CA83B0A5EF3662095068A2D93D4E51", hash_generated_field = "BD40E8C59E7AC3257D3A47F00953ACF9")

    private RemoteViewsAdapterServiceConnection mServiceConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.813 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "2853390AFCDB24EF7B383440520C8195")

    private WeakReference<RemoteAdapterConnectionCallback> mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.813 -0400", hash_original_field = "FA75DB4B1A95A78968F552A9DCC88B0C", hash_generated_field = "6CEEDA92C0B838E0583FA20FED984233")

    private FixedSizeRemoteViewsCache mCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.813 -0400", hash_original_field = "D40837C5C96F2BC6FB8B15E5D5D9A8E4", hash_generated_field = "2CBB88FF54D1CB615E7672C77E0FDC22")

    private boolean mNotifyDataSetChangedAfterOnServiceConnected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.813 -0400", hash_original_field = "48E773D9FF4DCC371E25C83CB3C47074", hash_generated_field = "4BD04F08A083FFC0AD9FAED854002A9F")

    private RemoteViewsFrameLayoutRefSet mRequestedViews;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.813 -0400", hash_original_field = "057DFDF088887624A60064F086C80D70", hash_generated_field = "F80515F1CBDC27AC738FAA2D73C57FAC")

    private HandlerThread mWorkerThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.813 -0400", hash_original_field = "6B46E04E2DA4F6D5AFFCE71F4C5D8248", hash_generated_field = "117A70523E02BF403FE90D6FEB3CF957")

    private Handler mWorkerQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.813 -0400", hash_original_field = "C57F865EFE060D469EE2E4964E3F0FA8", hash_generated_field = "6EC87008C9BC7C9DBF6022010FD5DC7F")

    private Handler mMainQueue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.814 -0400", hash_original_method = "812B134D167B9B4075E3C9A16E9536C3", hash_generated_method = "FF1A421B345FCB113920F1055D256799")
    public  RemoteViewsAdapter(Context context, Intent intent, RemoteAdapterConnectionCallback callback) {
        mContext = context;
        mIntent = intent;
        mAppWidgetId = intent.getIntExtra(RemoteViews.EXTRA_REMOTEADAPTER_APPWIDGET_ID, -1);
        mLayoutInflater = LayoutInflater.from(context);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Non-null Intent must be specified.");
        } //End block
        mRequestedViews = new RemoteViewsFrameLayoutRefSet();
        {
            boolean varC25279B3AE4B976D096FE6C4D3EF7578_908484344 = (intent.hasExtra(RemoteViews.EXTRA_REMOTEADAPTER_APPWIDGET_ID));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.825 -0400", hash_original_method = "448EC732CCF4B62AEFADFAF844C3E610", hash_generated_method = "F8018D33E104FFE245C3A165F87FBACB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.826 -0400", hash_original_method = "34DA0EC600A8592A38E8BB75F944416C", hash_generated_method = "E410594772B1340070FDA4A55B5ABA78")
    private void loadNextIndexInBackground() {
        mWorkerQueue.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.826 -0400", hash_original_method = "4CF90A1CB7C420A204E3629193269707", hash_generated_method = "0F6CFE3FB0A8E4C72E9713ACE4A7BD7B")
            @Override
            public void run() {
                {
                    boolean varC0AB9EB04FA33F4F43E9EE96AC258E59_1289616862 = (mServiceConnection.isConnected());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.836 -0400", hash_original_method = "E1B2571B376275F4805513EEE2D5A305", hash_generated_method = "2384FF76309F62EDD87F96C81901B535")
    private void processException(String method, Exception e) {
        RemoteViewsMetaData metaData;
        metaData = mCache.getMetaData();
        {
            metaData.reset();
        } //End block
        {
            mCache.reset();
        } //End block
        mMainQueue.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.836 -0400", hash_original_method = "20780F1316FA6B5AAEF80ABB110F8A58", hash_generated_method = "9658C6127F239982755926B1BF541104")
            @Override
            public void run() {
                superNotifyDataSetChanged();
                // ---------- Original Method ----------
                //superNotifyDataSetChanged();
            }
});
        addTaint(method.getTaint());
        addTaint(e.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.837 -0400", hash_original_method = "49F084C42EF1DBBC4522A49655FF79A1", hash_generated_method = "299374A5441EE24A684829B9040C2B8A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.838 -0400", hash_original_method = "5FA96F3EFCF6BBECAF668E31FDA609B8", hash_generated_method = "5F31F562719C46C6E23490274F51692B")
    private void updateRemoteViews(final int position, boolean isRequested) {
        {
            boolean varB639375210F642D25B10B2BDC0461609_2074791055 = (!mServiceConnection.isConnected());
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
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.838 -0400", hash_original_method = "893654825C9F0EE31547B34AB12EB1B2", hash_generated_method = "EC088C820250E0DE41EE3A77F29725DC")
                @Override
                public void run() {
                    mRequestedViews.notifyOnRemoteViewsLoaded(position, rv, typeId);
                    // ---------- Original Method ----------
                    //mRequestedViews.notifyOnRemoteViewsLoaded(position, rv, typeId);
                }
});
        } //End block
        addTaint(position);
        addTaint(isRequested);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.851 -0400", hash_original_method = "F998EBA4725E32A416A597964901E5AB", hash_generated_method = "995B86720E5868BB80B7F118FF18037A")
    public Intent getRemoteViewsServiceIntent() {
        Intent varB4EAC82CA7396A68D541C85D26508E83_722840009 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_722840009 = mIntent;
        varB4EAC82CA7396A68D541C85D26508E83_722840009.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_722840009;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.851 -0400", hash_original_method = "BD4FA508848CEC346AF576100841FA5B", hash_generated_method = "62C8A989F4DF69A65F7B361C15D300CF")
    public int getCount() {
        RemoteViewsMetaData metaData;
        metaData = mCache.getMetaData();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_662889278 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_662889278;
        // ---------- Original Method ----------
        //final RemoteViewsMetaData metaData = mCache.getMetaData();
        //synchronized (metaData) {
            //return metaData.count;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.851 -0400", hash_original_method = "AE0D3BF5CEF608E0D2B9C47624E8B8EC", hash_generated_method = "C93AD5AC1020F3A5F44ED47E53288A7F")
    public Object getItem(int position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1311628444 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1311628444 = null;
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_1311628444.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1311628444;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.852 -0400", hash_original_method = "03B3187C996D144F3BCFDF9DFF16615D", hash_generated_method = "DAA18B850F9AC74BA28CCF8A4B1AE933")
    public long getItemId(int position) {
        {
            {
                boolean varD27C3F53015470E371413C7BF03B06BD_163864697 = (mCache.containsMetaDataAt(position));
                {
                    long var474C483542D84722B7B45BC8BD1B907D_167222614 = (mCache.getMetaDataAt(position).itemId);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(position);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1790366583 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1790366583;
        // ---------- Original Method ----------
        //synchronized (mCache) {
            //if (mCache.containsMetaDataAt(position)) {
                //return mCache.getMetaDataAt(position).itemId;
            //}
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.852 -0400", hash_original_method = "BDCE0C462966DEB126F7FB99CEF6A82A", hash_generated_method = "56EB036DBB1F769D1D8A9B079B17A388")
    public int getItemViewType(int position) {
        int typeId;
        typeId = 0;
        {
            {
                boolean varD27C3F53015470E371413C7BF03B06BD_637449626 = (mCache.containsMetaDataAt(position));
                {
                    typeId = mCache.getMetaDataAt(position).typeId;
                } //End block
            } //End collapsed parenthetic
        } //End block
        RemoteViewsMetaData metaData;
        metaData = mCache.getMetaData();
        {
            int var12B2278118B10569F2BCEC86C96FBA64_37489392 = (metaData.getMappedViewType(typeId));
        } //End block
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179089860 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179089860;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.853 -0400", hash_original_method = "A43180B0154FDAA6CD8755A8245F56F8", hash_generated_method = "AB21234B060F7BA4BEF659F1AA1B543B")
    private int getConvertViewTypeId(View convertView) {
        int typeId;
        typeId = -1;
        {
            Object tag;
            tag = convertView.getTag(com.android.internal.R.id.rowTypeId);
            {
                typeId = (Integer) tag;
            } //End block
        } //End block
        addTaint(convertView.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372628515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372628515;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.858 -0400", hash_original_method = "6C789CA1A76BB0C76EA62E1C57E6DD64", hash_generated_method = "C6541589C5BDCE0A0841406470F02953")
    public View getView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_288236872 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_389386209 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_1627509649 = null; //Variable for return #3
        View varB4EAC82CA7396A68D541C85D26508E83_109970589 = null; //Variable for return #4
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
                            varB4EAC82CA7396A68D541C85D26508E83_288236872 = layout;
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
                    varB4EAC82CA7396A68D541C85D26508E83_389386209 = layout;
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
                    varB4EAC82CA7396A68D541C85D26508E83_1627509649 = loadingView;
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
                varB4EAC82CA7396A68D541C85D26508E83_109970589 = loadingView;
            } //End block
        } //End block
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        View varA7E53CE21691AB073D9660D615818899_102595029; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_102595029 = varB4EAC82CA7396A68D541C85D26508E83_288236872;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_102595029 = varB4EAC82CA7396A68D541C85D26508E83_389386209;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_102595029 = varB4EAC82CA7396A68D541C85D26508E83_1627509649;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_102595029 = varB4EAC82CA7396A68D541C85D26508E83_109970589;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_102595029.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_102595029;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.869 -0400", hash_original_method = "E20153FA245BC3D829E7670B1CF87BF9", hash_generated_method = "D436146EE722D5FA3DD88433C157B6A2")
    public int getViewTypeCount() {
        RemoteViewsMetaData metaData;
        metaData = mCache.getMetaData();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495090296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495090296;
        // ---------- Original Method ----------
        //final RemoteViewsMetaData metaData = mCache.getMetaData();
        //synchronized (metaData) {
            //return metaData.viewTypeCount;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.869 -0400", hash_original_method = "30FBD60CD0291FCC8DBBE0ACB800AAAA", hash_generated_method = "312ED37E6D5BC4975667C4283A7C13D7")
    public boolean hasStableIds() {
        RemoteViewsMetaData metaData;
        metaData = mCache.getMetaData();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1586659783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1586659783;
        // ---------- Original Method ----------
        //final RemoteViewsMetaData metaData = mCache.getMetaData();
        //synchronized (metaData) {
            //return metaData.hasStableIds;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.870 -0400", hash_original_method = "53D7DB97161C41CC976317DC7E27F456", hash_generated_method = "9E56F66426C4E43E01D5F1A6C919E62E")
    public boolean isEmpty() {
        boolean var836519EBBA75D474236DD9A735C5C741_892790970 = (getCount() <= 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436949790 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436949790;
        // ---------- Original Method ----------
        //return getCount() <= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.875 -0400", hash_original_method = "2DAA079F2CA383CBC7C346F3BCA57054", hash_generated_method = "22DFD5724942EE709B2295A83249D9A6")
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.875 -0400", hash_original_method = "599F6D416D0C87E072E14AB486244C9F", hash_generated_method = "E2BF2A1BF355FF99011493BBC7818C77")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.876 -0400", hash_original_method = "0764FC8C95C069ED9ED094B35DCC527A", hash_generated_method = "7A9656CCA02CBA6F949EA1ABB8DE95E5")
    public void notifyDataSetChanged() {
        mMainQueue.removeMessages(sUnbindServiceMessageType);
        {
            boolean varB639375210F642D25B10B2BDC0461609_1769617330 = (!mServiceConnection.isConnected());
            {
                mNotifyDataSetChangedAfterOnServiceConnected = true;
                requestBindService();
            } //End block
        } //End collapsed parenthetic
        mWorkerQueue.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.876 -0400", hash_original_method = "041C495048132FF173BFCDF38ABB5707", hash_generated_method = "A0E7FB80DBA0806D596A5B67FD46EBEA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.876 -0400", hash_original_method = "A1EDDF3811A1F9D28CCD28C93269FAD1", hash_generated_method = "13135540CF0C096F7922371AE0301E89")
     void superNotifyDataSetChanged() {
        super.notifyDataSetChanged();
        // ---------- Original Method ----------
        //super.notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.891 -0400", hash_original_method = "96758E0B3254F3B4A777FC060A49CC59", hash_generated_method = "BAE46E362D0C2818A94F8093FFFF73B9")
    @Override
    public boolean handleMessage(Message msg) {
        boolean result;
        result = false;
        //Begin case sUnbindServiceMessageType 
        {
            boolean varAF0014E6961178BB03E6A35A2A9D4C03_1446330690 = (mServiceConnection.isConnected());
            {
                mServiceConnection.unbind(mContext, mAppWidgetId, mIntent);
            } //End block
        } //End collapsed parenthetic
        //End case sUnbindServiceMessageType 
        //Begin case sUnbindServiceMessageType 
        result = true;
        //End case sUnbindServiceMessageType 
        addTaint(msg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_854390460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_854390460;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.891 -0400", hash_original_method = "D880D88722499DDF7E3D229A00764CBB", hash_generated_method = "8943C3C3F64C9B76CBBF6A8AA4DF52C7")
    private void enqueueDeferredUnbindServiceMessage() {
        mMainQueue.removeMessages(sUnbindServiceMessageType);
        mMainQueue.sendEmptyMessageDelayed(sUnbindServiceMessageType, sUnbindServiceDelay);
        // ---------- Original Method ----------
        //mMainQueue.removeMessages(sUnbindServiceMessageType);
        //mMainQueue.sendEmptyMessageDelayed(sUnbindServiceMessageType, sUnbindServiceDelay);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.892 -0400", hash_original_method = "FD0BDD14354B6205FD4E5E773D9BDB6D", hash_generated_method = "D4217590161E1A0670DA601D6522B3A0")
    private boolean requestBindService() {
        {
            boolean varB639375210F642D25B10B2BDC0461609_1383012792 = (!mServiceConnection.isConnected());
            {
                mServiceConnection.bind(mContext, mAppWidgetId, mIntent);
            } //End block
        } //End collapsed parenthetic
        mMainQueue.removeMessages(sUnbindServiceMessageType);
        boolean var9194E623990DE28F1BF24202733015EB_2142454490 = (mServiceConnection.isConnected());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2061383824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2061383824;
        // ---------- Original Method ----------
        //if (!mServiceConnection.isConnected()) {
            //mServiceConnection.bind(mContext, mAppWidgetId, mIntent);
        //}
        //mMainQueue.removeMessages(sUnbindServiceMessageType);
        //return mServiceConnection.isConnected();
    }

    
    private static class RemoteViewsAdapterServiceConnection extends IRemoteViewsAdapterConnection.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.892 -0400", hash_original_field = "CC8BFB84898B22492B7F55096CBDF6CC", hash_generated_field = "76A19B81A43EEDF4AF3BF911EC3960E9")

        private boolean mIsConnected;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.892 -0400", hash_original_field = "0B061825A2BD144F822A600E85C8460D", hash_generated_field = "71FF1B688CE6E1B60B73B36B2E842EB8")

        private boolean mIsConnecting;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.892 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "DF300972716819DE62AFA33FE9FFC280")

        private WeakReference<RemoteViewsAdapter> mAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.892 -0400", hash_original_field = "3259B525D7D221061093A7706AFAA49A", hash_generated_field = "722330FA05DFEF3176A8163BFC4DC620")

        private IRemoteViewsFactory mRemoteViewsFactory;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.893 -0400", hash_original_method = "7E10295116D6DF0B2080F7EEB3B8FF2F", hash_generated_method = "2CBC4DD0E19B00EEE4BD2962CC59C85E")
        public  RemoteViewsAdapterServiceConnection(RemoteViewsAdapter adapter) {
            mAdapter = new WeakReference<RemoteViewsAdapter>(adapter);
            // ---------- Original Method ----------
            //mAdapter = new WeakReference<RemoteViewsAdapter>(adapter);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.894 -0400", hash_original_method = "8522D247C3B96C2C6A0E0A6DFCD61958", hash_generated_method = "F334115F0D1C14DB7E5FD603A5DDAF4F")
        public synchronized void bind(Context context, int appWidgetId, Intent intent) {
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
            addTaint(context.getTaint());
            addTaint(appWidgetId);
            addTaint(intent.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.895 -0400", hash_original_method = "21A72C8FC580D8D0E809A3FEE2FDD93D", hash_generated_method = "76930B53115F475B82D41B72B54B9C00")
        public synchronized void unbind(Context context, int appWidgetId, Intent intent) {
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
            addTaint(context.getTaint());
            addTaint(appWidgetId);
            addTaint(intent.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.897 -0400", hash_original_method = "08CA49D02360F6C2A6BB2EFEF11F092E", hash_generated_method = "9532E773D5DDBCDFC0423EFBDAF6E292")
        public synchronized void onServiceConnected(IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mRemoteViewsFactory = IRemoteViewsFactory.Stub.asInterface(service);
            RemoteViewsAdapter adapter;
            adapter = mAdapter.get();
            adapter.mWorkerQueue.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.896 -0400", hash_original_method = "C9280BFFF3D57DCE91D4B8E9AF737343", hash_generated_method = "6923C94B36440D0C2130B3A26A7B10B5")
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
                                boolean varDC9A171480612B8E4508A865A137D536_502535765 = (!factory.isCreated());
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
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.896 -0400", hash_original_method = "15183F885AD888FE838F648B256AD495", hash_generated_method = "DC687C66FDC1BCFD542253E403151160")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.914 -0400", hash_original_method = "6AD1D56D3A677AEA97BA981AA56DEDEB", hash_generated_method = "449A9DC9C271D8AC233BED7202FA8EA2")
        public synchronized void onServiceDisconnected() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mIsConnected = false;
            mIsConnecting = false;
            mRemoteViewsFactory = null;
            RemoteViewsAdapter adapter;
            adapter = mAdapter.get();
            adapter.mMainQueue.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.914 -0400", hash_original_method = "5256C3FE0B7F0EC8DBD6E0D8928BE4C4", hash_generated_method = "81A8663CC3FB114C9D301586A0FCD2BF")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.915 -0400", hash_original_method = "9AC2F72588B70E9E489A1C9892FF58B7", hash_generated_method = "0062FE688C9BA42C7185EA3A6A477081")
        public synchronized IRemoteViewsFactory getRemoteViewsFactory() {
            IRemoteViewsFactory varB4EAC82CA7396A68D541C85D26508E83_1113592475 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1113592475 = mRemoteViewsFactory;
            varB4EAC82CA7396A68D541C85D26508E83_1113592475.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1113592475;
            // ---------- Original Method ----------
            //return mRemoteViewsFactory;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.915 -0400", hash_original_method = "EB76BB3DACEAD8AEFFF382088AE69C8F", hash_generated_method = "B589C61956083B914BBCAFAE3E1848CF")
        public synchronized boolean isConnected() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1907082483 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1907082483;
            // ---------- Original Method ----------
            //return mIsConnected;
        }

        
    }


    
    private class RemoteViewsFrameLayout extends FrameLayout {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.919 -0400", hash_original_method = "15F65CD5E3BE0169B47C7BF19C42CB6A", hash_generated_method = "84BEC92F8166F0087E1C907BC13AD329")
        public  RemoteViewsFrameLayout(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.919 -0400", hash_original_method = "376943697B2A7028E475228F1F5698F0", hash_generated_method = "EDAD6D0AB639A9F83E8F89D9E6520131")
        public void onRemoteViewsLoaded(RemoteViews view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            try 
            {
                removeAllViews();
                addView(view.apply(getContext(), this));
            } //End block
            catch (Exception e)
            { }
            addTaint(view.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.920 -0400", hash_original_field = "49480114F1DA72B3D385F91F28CAB531", hash_generated_field = "0DDDAE295C285660CD7FE8EBB6DC5F4A")

        private HashMap<Integer, LinkedList<RemoteViewsFrameLayout>> mReferences;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.920 -0400", hash_original_method = "6FF139149B49AE6D730172FAFB07DD3B", hash_generated_method = "04F49291A2A41B3FE0D9405505C49E32")
        public  RemoteViewsFrameLayoutRefSet() {
            mReferences = new HashMap<Integer, LinkedList<RemoteViewsFrameLayout>>();
            // ---------- Original Method ----------
            //mReferences = new HashMap<Integer, LinkedList<RemoteViewsFrameLayout>>();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.933 -0400", hash_original_method = "3F0456D57D98DD5B5AAA7D7D24636D4D", hash_generated_method = "0273E722555688DFD34E7A859DF2B5D2")
        public void add(int position, RemoteViewsFrameLayout layout) {
            Integer pos;
            pos = position;
            LinkedList<RemoteViewsFrameLayout> refs;
            {
                boolean var1C724F4D3C0F3C792D0F2FED4BE4566F_1477091612 = (mReferences.containsKey(pos));
                {
                    refs = mReferences.get(pos);
                } //End block
                {
                    refs = new LinkedList<RemoteViewsFrameLayout>();
                    mReferences.put(pos, refs);
                } //End block
            } //End collapsed parenthetic
            refs.add(layout);
            addTaint(position);
            addTaint(layout.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.955 -0400", hash_original_method = "B75D35E25E548F04E2C73EAA0A8BAD12", hash_generated_method = "E8EBE77B64F2BA6F94222353484A050E")
        public void notifyOnRemoteViewsLoaded(int position, RemoteViews view, int typeId) {
            Integer pos;
            pos = position;
            {
                boolean var1C724F4D3C0F3C792D0F2FED4BE4566F_2130746647 = (mReferences.containsKey(pos));
                {
                    LinkedList<RemoteViewsFrameLayout> refs;
                    refs = mReferences.get(pos);
                    {
                        Iterator<RemoteViewsFrameLayout> varF330A8C22FC56F2EBE7DC0926BA301AB_585765506 = (refs).iterator();
                        varF330A8C22FC56F2EBE7DC0926BA301AB_585765506.hasNext();
                        final RemoteViewsFrameLayout ref = varF330A8C22FC56F2EBE7DC0926BA301AB_585765506.next();
                        {
                            ref.onRemoteViewsLoaded(view);
                        } //End block
                    } //End collapsed parenthetic
                    refs.clear();
                    mReferences.remove(pos);
                } //End block
            } //End collapsed parenthetic
            addTaint(position);
            addTaint(view.getTaint());
            addTaint(typeId);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.967 -0400", hash_original_method = "A232CA036EBBA3D167286637450EBE5D", hash_generated_method = "24EBFCA05188B87B49D1A34189D809C7")
        public void clear() {
            mReferences.clear();
            // ---------- Original Method ----------
            //mReferences.clear();
        }

        
    }


    
    private class RemoteViewsMetaData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.967 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "B83BF7ED7F5719DA923E1BC0AC69952B")

        int count;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.967 -0400", hash_original_field = "838BF490B590E83463A4659B060C26FC", hash_generated_field = "C1E9C1B6290BF40ADECDA7DF82FAC94D")

        int viewTypeCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.967 -0400", hash_original_field = "DAF737EDDF98B803755EC84BA73A5E3F", hash_generated_field = "004C2D81765875057DD2D513A7A85CEF")

        boolean hasStableIds;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.967 -0400", hash_original_field = "6EDDEBA4B8B8FD0722D0BB53E14FFC0C", hash_generated_field = "9A49302F66DF2887EFAB714BA0B6B15B")

        RemoteViews mUserLoadingView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.967 -0400", hash_original_field = "41D6ADCC8C59297CD329E31519FD34AA", hash_generated_field = "39C526A78EF58332F9FAD2AD78897B3C")

        RemoteViews mFirstView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.967 -0400", hash_original_field = "308D00B001FC55B7BD96E24977E53940", hash_generated_field = "32C08FC6170C53D3EDBAD53E03B1BB3B")

        int mFirstViewHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.967 -0400", hash_original_field = "F7A46FD11046228C04C0DA5E8752213C", hash_generated_field = "5C6ABB7C95B7F1C3F63AD546E83D1FDF")

        private HashMap<Integer, Integer> mTypeIdIndexMap = new HashMap<Integer, Integer>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.967 -0400", hash_original_method = "A4C124A869EBADBA9AE6D60BBB8A7C9F", hash_generated_method = "3DCD91096CB130F5938CD8D146151676")
        public  RemoteViewsMetaData() {
            reset();
            // ---------- Original Method ----------
            //reset();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.968 -0400", hash_original_method = "90BA893E06B3709572F4D6BD4487FB6C", hash_generated_method = "69BA8DC418CFDBB9F18004D5C5581793")
        public void set(RemoteViewsMetaData d) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.968 -0400", hash_original_method = "AE7C296E4C5BBC73F59980BD54540BF2", hash_generated_method = "E27E2C57D2D5002944558FDACF04DF1D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.969 -0400", hash_original_method = "E784F858D155FE6C94A91B290D47017F", hash_generated_method = "3F14235CB6E89896EEF4C4E563635AB3")
        public void setLoadingViewTemplates(RemoteViews loadingView, RemoteViews firstView) {
            mUserLoadingView = loadingView;
            {
                mFirstView = firstView;
                mFirstViewHeight = -1;
            } //End block
            // ---------- Original Method ----------
            //mUserLoadingView = loadingView;
            //if (firstView != null) {
                //mFirstView = firstView;
                //mFirstViewHeight = -1;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.974 -0400", hash_original_method = "78DD70270396881EC8B9AE912C927B26", hash_generated_method = "2469049DE295D286ACD4CD8C9E5928AC")
        public int getMappedViewType(int typeId) {
            {
                boolean varE72D96C2A7631C4D4068420790F0E31A_1752312038 = (mTypeIdIndexMap.containsKey(typeId));
                {
                    int varDEAAB1FACE77CC174C29AD8F052D40B4_1614199792 = (mTypeIdIndexMap.get(typeId));
                } //End block
                {
                    int incrementalTypeId;
                    incrementalTypeId = mTypeIdIndexMap.size() + 1;
                    mTypeIdIndexMap.put(typeId, incrementalTypeId);
                } //End block
            } //End collapsed parenthetic
            addTaint(typeId);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139563695 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139563695;
            // ---------- Original Method ----------
            //if (mTypeIdIndexMap.containsKey(typeId)) {
                //return mTypeIdIndexMap.get(typeId);
            //} else {
                //int incrementalTypeId = mTypeIdIndexMap.size() + 1;
                //mTypeIdIndexMap.put(typeId, incrementalTypeId);
                //return incrementalTypeId;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.975 -0400", hash_original_method = "6B923D58C715B2F45FA359F8E18C8A1F", hash_generated_method = "0643988A97CFA9BB4DFA1C179130BAF1")
        private RemoteViewsFrameLayout createLoadingView(int position, View convertView,
                ViewGroup parent) {
            RemoteViewsFrameLayout varB4EAC82CA7396A68D541C85D26508E83_1956300798 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1956300798 = layout;
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1956300798.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1956300798;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class RemoteViewsIndexMetaData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.975 -0400", hash_original_field = "5F694956811487225D15E973CA38FBAB", hash_generated_field = "76F76148F5071AE6285A6BC57B0ADE91")

        int typeId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.975 -0400", hash_original_field = "59A814AA020A1B32C4674A5887A35022", hash_generated_field = "90EEB5AA84937AD6A8CE9746B6FECA6A")

        long itemId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.975 -0400", hash_original_field = "1F12075C4184F616A07646739C4342EE", hash_generated_field = "060C657FCDBB17A3289922E65DB8FCC4")

        boolean isRequested;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.989 -0400", hash_original_method = "429CAA99D27E695F91D025FEB15660FB", hash_generated_method = "D6957189233B5918EAB9F8B56C533263")
        public  RemoteViewsIndexMetaData(RemoteViews v, long itemId, boolean requested) {
            set(v, itemId, requested);
            addTaint(v.getTaint());
            addTaint(itemId);
            addTaint(requested);
            // ---------- Original Method ----------
            //set(v, itemId, requested);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.989 -0400", hash_original_method = "6F36A962FFB607392BC2E34875EB4BD4", hash_generated_method = "92AC2590390DDD2F3D4F82B3C55A4B61")
        public void set(RemoteViews v, long id, boolean requested) {
            itemId = id;
            typeId = v.getLayoutId();
            typeId = 0;
            isRequested = requested;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.990 -0400", hash_original_field = "0FCE5B64423E6B04C33CE3468F58DA62", hash_generated_field = "C7BAEA4EAD131C24153F2BC22502F2DA")

        private RemoteViewsMetaData mMetaData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.990 -0400", hash_original_field = "35898A5A614C542A7664A6A85A2DF029", hash_generated_field = "CCFF7299FB9E7ED02A6E6C63B5236D05")

        private RemoteViewsMetaData mTemporaryMetaData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.990 -0400", hash_original_field = "BBD9C074C8BFE7F5F7C066E06D309B25", hash_generated_field = "4D7BFF7687FF3AEB2660E6771DA7A41D")

        private HashMap<Integer, RemoteViewsIndexMetaData> mIndexMetaData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.990 -0400", hash_original_field = "E23925CEBC8CCBD3D31D40082C05C370", hash_generated_field = "622EF405E12F8FB6D80FD7F1E7909760")

        private HashMap<Integer, RemoteViews> mIndexRemoteViews;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.990 -0400", hash_original_field = "585798A32AF4C3DD10344010FF6B9706", hash_generated_field = "534B08E02E91774394FCE7D691C682CB")

        private HashSet<Integer> mRequestedIndices;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.990 -0400", hash_original_field = "461C6567414062E123C02AA45E52645E", hash_generated_field = "EDD6140FE3EFE2A884527802E7502D5E")

        private int mLastRequestedIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.990 -0400", hash_original_field = "E8A3A3187B0CAF3B63074C35EF6D6C3C", hash_generated_field = "7552CCBBABA4C6673CFCAA35306E60E9")

        private HashSet<Integer> mLoadIndices;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.990 -0400", hash_original_field = "65E5D7D551CCC2236163247CBA82EA30", hash_generated_field = "AF3636EC231AD49E7BB961CA0D975BAD")

        private int mPreloadLowerBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.990 -0400", hash_original_field = "5918180AF4002B2A1ADC99DB1B26CFD5", hash_generated_field = "8874B6DBCCBC94897623594595F133DB")

        private int mPreloadUpperBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.990 -0400", hash_original_field = "DA6F53F2281C91E02577C5A3C4B75B90", hash_generated_field = "07593739EA51894193F3BFC61924FDA8")

        private int mMaxCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.990 -0400", hash_original_field = "0CFFCC288FFB8495CE255EC76ADE18D2", hash_generated_field = "802409AF8ABEE98E4B589C02F0E51998")

        private int mMaxCountSlack;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.991 -0400", hash_original_method = "AFDF05837CF8EF03047EB57BF9703B63", hash_generated_method = "C06B39B7022755D679EF8EF25E68C287")
        public  FixedSizeRemoteViewsCache(int maxCacheSize) {
            mMaxCount = maxCacheSize;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.992 -0400", hash_original_method = "3B60FC97D93DDECF59F968EA9F5DCEA5", hash_generated_method = "A582A73495F15A96B86B94E19B15951B")
        public void insert(int position, RemoteViews v, long itemId, boolean isRequested) {
            {
                boolean var939008B18DF5E8077A7FBD0DE42BA383_291582998 = (mIndexRemoteViews.size() >= mMaxCount);
                {
                    mIndexRemoteViews.remove(getFarthestPositionFrom(position));
                } //End block
            } //End collapsed parenthetic
            int pruneFromPosition;
            pruneFromPosition = mLastRequestedIndex;
            pruneFromPosition = position;
            {
                boolean varA90EF5BC5B38B66F275CC4234FBC71D6_856084309 = (getRemoteViewsBitmapMemoryUsage() >= sMaxMemoryLimitInBytes);
                {
                    mIndexRemoteViews.remove(getFarthestPositionFrom(pruneFromPosition));
                } //End block
            } //End collapsed parenthetic
            {
                boolean var72540E4749D1AF0B6940B3AE7BC6ED24_321213500 = (mIndexMetaData.containsKey(position));
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
            addTaint(position);
            addTaint(v.getTaint());
            addTaint(itemId);
            addTaint(isRequested);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.996 -0400", hash_original_method = "CE79B98C6EC29820DC37D3CBF74EA749", hash_generated_method = "37626FDCF2FC7734B49236BED4D0A869")
        public RemoteViewsMetaData getMetaData() {
            RemoteViewsMetaData varB4EAC82CA7396A68D541C85D26508E83_331361529 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_331361529 = mMetaData;
            varB4EAC82CA7396A68D541C85D26508E83_331361529.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_331361529;
            // ---------- Original Method ----------
            //return mMetaData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.002 -0400", hash_original_method = "1D24E06D74C40EECF68D58BAFBBECA77", hash_generated_method = "E403D4857759620AA1C0526C5263A5EC")
        public RemoteViewsMetaData getTemporaryMetaData() {
            RemoteViewsMetaData varB4EAC82CA7396A68D541C85D26508E83_1350343908 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1350343908 = mTemporaryMetaData;
            varB4EAC82CA7396A68D541C85D26508E83_1350343908.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1350343908;
            // ---------- Original Method ----------
            //return mTemporaryMetaData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.008 -0400", hash_original_method = "2697DBEF8CDE0991B3151B5A3E03C7EB", hash_generated_method = "24198906A2BAF27AA6E2907DD40585FE")
        public RemoteViews getRemoteViewsAt(int position) {
            RemoteViews varB4EAC82CA7396A68D541C85D26508E83_750251035 = null; //Variable for return #1
            RemoteViews varB4EAC82CA7396A68D541C85D26508E83_565002554 = null; //Variable for return #2
            {
                boolean var32A42C87332588C7B746B90566692371_702255158 = (mIndexRemoteViews.containsKey(position));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_750251035 = mIndexRemoteViews.get(position);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_565002554 = null;
            addTaint(position);
            RemoteViews varA7E53CE21691AB073D9660D615818899_1690225456; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1690225456 = varB4EAC82CA7396A68D541C85D26508E83_750251035;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1690225456 = varB4EAC82CA7396A68D541C85D26508E83_565002554;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1690225456.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1690225456;
            // ---------- Original Method ----------
            //if (mIndexRemoteViews.containsKey(position)) {
                //return mIndexRemoteViews.get(position);
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.009 -0400", hash_original_method = "1A017214F368969D3B3DFEA7A0D6E60A", hash_generated_method = "8BF12698503C258406877CAC32DF4FB6")
        public RemoteViewsIndexMetaData getMetaDataAt(int position) {
            RemoteViewsIndexMetaData varB4EAC82CA7396A68D541C85D26508E83_860037702 = null; //Variable for return #1
            RemoteViewsIndexMetaData varB4EAC82CA7396A68D541C85D26508E83_679216563 = null; //Variable for return #2
            {
                boolean var72540E4749D1AF0B6940B3AE7BC6ED24_383650321 = (mIndexMetaData.containsKey(position));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_860037702 = mIndexMetaData.get(position);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_679216563 = null;
            addTaint(position);
            RemoteViewsIndexMetaData varA7E53CE21691AB073D9660D615818899_530338284; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_530338284 = varB4EAC82CA7396A68D541C85D26508E83_860037702;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_530338284 = varB4EAC82CA7396A68D541C85D26508E83_679216563;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_530338284.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_530338284;
            // ---------- Original Method ----------
            //if (mIndexMetaData.containsKey(position)) {
                //return mIndexMetaData.get(position);
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.012 -0400", hash_original_method = "4EDEA047857C8C00C25F35FE7AF06430", hash_generated_method = "1D4CCC8D134AFD2F49BFF6463D69F191")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.079 -0400", hash_original_method = "1379738D9DE8B74BE60C7743F79F9609", hash_generated_method = "43A34A871D735FE54FD7568BD3A77332")
        private int getRemoteViewsBitmapMemoryUsage() {
            int mem;
            mem = 0;
            {
                Iterator<Integer> varB4A935C4A5ED4E6907A65608913D6FD2_515171201 = (mIndexRemoteViews.keySet()).iterator();
                varB4A935C4A5ED4E6907A65608913D6FD2_515171201.hasNext();
                Integer i = varB4A935C4A5ED4E6907A65608913D6FD2_515171201.next();
                {
                    RemoteViews v;
                    v = mIndexRemoteViews.get(i);
                    {
                        mem += v.estimateBitmapMemoryUsage();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675254771 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675254771;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.093 -0400", hash_original_method = "61B11826B25E039221975DE702D21975", hash_generated_method = "5DF3EB80F1698610D38F6EF7D38F3A4C")
        private int getFarthestPositionFrom(int pos) {
            int maxDist;
            maxDist = 0;
            int maxDistIndex;
            maxDistIndex = -1;
            int maxDistNonRequested;
            maxDistNonRequested = 0;
            int maxDistIndexNonRequested;
            maxDistIndexNonRequested = -1;
            {
                Iterator<Integer> var2A4FD0A1CC1361CFD41095D31F4E5EF1_636205774 = (mIndexRemoteViews.keySet()).iterator();
                var2A4FD0A1CC1361CFD41095D31F4E5EF1_636205774.hasNext();
                int i = var2A4FD0A1CC1361CFD41095D31F4E5EF1_636205774.next();
                {
                    int dist;
                    dist = Math.abs(i-pos);
                    {
                        boolean var6BEEB46AA5DD9DD36399D77D50EBA9AD_1866229971 = (dist > maxDistNonRequested && !mIndexMetaData.get(i).isRequested);
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
            addTaint(pos);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746869317 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746869317;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.094 -0400", hash_original_method = "FD296F73133B242F283CE39F258C0B72", hash_generated_method = "154D1254A63D4FFDE2B63BDC85F11006")
        public void queueRequestedPositionToLoad(int position) {
            mLastRequestedIndex = position;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.100 -0400", hash_original_method = "5E1B16EBD16301761756030AADF8738C", hash_generated_method = "ADAA92AC8B7F25F4F1FBD4638F8B8E69")
        public boolean queuePositionsToBePreloadedFromRequestedPosition(int position) {
            {
                int center;
                center = (mPreloadUpperBound + mPreloadLowerBound) / 2;
                {
                    boolean var0636EC1C871015A7D4DCFF8D3BC97F2F_1887628303 = (Math.abs(position - center) < mMaxCountSlack);
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
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_749447132 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_749447132;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.110 -0400", hash_original_method = "06D7248AE2FAA4148F7714FEE4BB20F2", hash_generated_method = "2BD64735EC64090EB9F85B63A8C4A06D")
        public int[] getNextIndexToLoad() {
            {
                {
                    boolean varBECF22EC8775578383214E68E20C33B3_1949709070 = (!mRequestedIndices.isEmpty());
                    {
                        Integer i;
                        i = mRequestedIndices.iterator().next();
                        mRequestedIndices.remove(i);
                        mLoadIndices.remove(i);
                        int[] varC013EB5EEFD0F9EB7779B8A5F2170050_121560710 = (new int[]{i.intValue(), 1});
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var7A0A9A32B15C45A9D3C895959BD665DF_1567604100 = (!mLoadIndices.isEmpty());
                    {
                        Integer i;
                        i = mLoadIndices.iterator().next();
                        mLoadIndices.remove(i);
                        int[] var714C8054CC6177CA3595BC84F9003BF3_667262174 = (new int[]{i.intValue(), 0});
                    } //End block
                } //End collapsed parenthetic
                int[] varC300C018DCB4F12CE19FE658B052C1CA_899142480 = (new int[]{-1, 0});
            } //End block
            int[] varB4CCCA26F9DB9189C32F33E82D425CFB_947527420 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_947527420;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.111 -0400", hash_original_method = "BBBDB78E47117BE8689A9C55BD30A227", hash_generated_method = "092DBA10023E5B079B8B3FEA524D953F")
        public boolean containsRemoteViewAt(int position) {
            boolean var2B18D7F842F074CBB8C22809C9ED8805_1056704298 = (mIndexRemoteViews.containsKey(position));
            addTaint(position);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1742845563 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1742845563;
            // ---------- Original Method ----------
            //return mIndexRemoteViews.containsKey(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.111 -0400", hash_original_method = "97177722E4C5BA4D6397E6B225C059F2", hash_generated_method = "E81A20D588331681A83F0991A57816C8")
        public boolean containsMetaDataAt(int position) {
            boolean var387071935791AAD5E2A4FFC958E81C03_221651158 = (mIndexMetaData.containsKey(position));
            addTaint(position);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_724797472 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_724797472;
            // ---------- Original Method ----------
            //return mIndexMetaData.containsKey(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.115 -0400", hash_original_method = "7D514E4141E3BAA67EC2DA2CF01B70A8", hash_generated_method = "8778164A936710645B2123EC88F21BC5")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.115 -0400", hash_original_field = "FB81249BF3052258E45C3888EBC350DA", hash_generated_field = "84E58F174A84F67D3E26311E89BC00CD")

        private static String TAG = "FixedSizeRemoteViewsCache";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.115 -0400", hash_original_field = "F9740182F353B90A4BDBE330395C68FF", hash_generated_field = "203B4998BF2CA7DA66A9FF0F726C305B")

        private static float sMaxCountSlackPercent = 0.75f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.115 -0400", hash_original_field = "FD1B2A98BB85E0640F1E9C7C18E4BBFA", hash_generated_field = "6D81911A184FF77B41FAEA23D289D93D")

        private static int sMaxMemoryLimitInBytes = 2 * 1024 * 1024;
    }


    
    public interface RemoteAdapterConnectionCallback {
        
        public boolean onRemoteAdapterConnected();

        public void onRemoteAdapterDisconnected();

        
        public void deferNotifyDataSetChanged();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.115 -0400", hash_original_field = "3F15C32F22D5D28B231422C2ED8DEA65", hash_generated_field = "E1DE82EF16B4AE879137A02A2B73FF18")

    private static String TAG = "RemoteViewsAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.115 -0400", hash_original_field = "9A2599D66205440D0C81070B0087E6C0", hash_generated_field = "9AAEA9591A504959ED76B750C880535D")

    private static int sDefaultCacheSize = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.115 -0400", hash_original_field = "D3029EB3FA6C6D927DC18B448E254A9B", hash_generated_field = "F4FA453F0B658C04E9EBA131BA77DE27")

    private static int sUnbindServiceDelay = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.115 -0400", hash_original_field = "5AE9F7C5EEA0C30BF3724A26667822E1", hash_generated_field = "A77E2E16F1F63621534A565EBF4B789F")

    private static int sDefaultLoadingViewHeight = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.115 -0400", hash_original_field = "ADA4A5984A61A504209F17405FAE49F5", hash_generated_field = "6BDB16449DC7B6C24FCBD53905DC1ADA")

    private static int sDefaultMessageType = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.115 -0400", hash_original_field = "2D292FE9AC86EFA8AB6604D58311922B", hash_generated_field = "EB044DBCA3E26DF16B4BAEF887AA2844")

    private static int sUnbindServiceMessageType = 1;
}

