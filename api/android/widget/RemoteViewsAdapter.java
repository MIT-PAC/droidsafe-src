package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.808 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.808 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.808 -0400", hash_original_field = "905A4BBD5E07D0C7A80D7BBC86A773FE", hash_generated_field = "B6D817E86C2105E427B243C6F2B8620A")

    private int mAppWidgetId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.808 -0400", hash_original_field = "C443A03F92046D0F01F0B3A84FC6B50F", hash_generated_field = "6C3DDC70E78FA863A6FCDBA124DEDF31")

    private LayoutInflater mLayoutInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.808 -0400", hash_original_field = "94CA83B0A5EF3662095068A2D93D4E51", hash_generated_field = "BD40E8C59E7AC3257D3A47F00953ACF9")

    private RemoteViewsAdapterServiceConnection mServiceConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.808 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "2853390AFCDB24EF7B383440520C8195")

    private WeakReference<RemoteAdapterConnectionCallback> mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.808 -0400", hash_original_field = "FA75DB4B1A95A78968F552A9DCC88B0C", hash_generated_field = "6CEEDA92C0B838E0583FA20FED984233")

    private FixedSizeRemoteViewsCache mCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.809 -0400", hash_original_field = "D40837C5C96F2BC6FB8B15E5D5D9A8E4", hash_generated_field = "2CBB88FF54D1CB615E7672C77E0FDC22")

    private boolean mNotifyDataSetChangedAfterOnServiceConnected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.809 -0400", hash_original_field = "48E773D9FF4DCC371E25C83CB3C47074", hash_generated_field = "4BD04F08A083FFC0AD9FAED854002A9F")

    private RemoteViewsFrameLayoutRefSet mRequestedViews;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.809 -0400", hash_original_field = "057DFDF088887624A60064F086C80D70", hash_generated_field = "F80515F1CBDC27AC738FAA2D73C57FAC")

    private HandlerThread mWorkerThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.809 -0400", hash_original_field = "6B46E04E2DA4F6D5AFFCE71F4C5D8248", hash_generated_field = "117A70523E02BF403FE90D6FEB3CF957")

    private Handler mWorkerQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.809 -0400", hash_original_field = "C57F865EFE060D469EE2E4964E3F0FA8", hash_generated_field = "6EC87008C9BC7C9DBF6022010FD5DC7F")

    private Handler mMainQueue;
    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.811 -0400", hash_original_method = "812B134D167B9B4075E3C9A16E9536C3", hash_generated_method = "738DDB18022FED702F1EF565CB9D43E6")
    public  RemoteViewsAdapter(Context context, Intent intent, RemoteAdapterConnectionCallback callback) {
        mContext = context;
        mIntent = intent;
        mAppWidgetId = intent.getIntExtra(RemoteViews.EXTRA_REMOTEADAPTER_APPWIDGET_ID, -1);
        mLayoutInflater = LayoutInflater.from(context);
    if(mIntent == null)        
        {
            IllegalArgumentException varCD200ACC7550FC872CE82265047D75E7_1664282611 = new IllegalArgumentException("Non-null Intent must be specified.");
            varCD200ACC7550FC872CE82265047D75E7_1664282611.addTaint(taint);
            throw varCD200ACC7550FC872CE82265047D75E7_1664282611;
        } //End block
        mRequestedViews = new RemoteViewsFrameLayoutRefSet();
    if(intent.hasExtra(RemoteViews.EXTRA_REMOTEADAPTER_APPWIDGET_ID))        
        {
            intent.removeExtra(RemoteViews.EXTRA_REMOTEADAPTER_APPWIDGET_ID);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.811 -0400", hash_original_method = "448EC732CCF4B62AEFADFAF844C3E610", hash_generated_method = "EBD45D3C3D7CC57726031C1C8395EB38")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
    if(mWorkerThread != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.813 -0400", hash_original_method = "34DA0EC600A8592A38E8BB75F944416C", hash_generated_method = "0DF959B6FB3D089EF926ACC147D63459")
    private void loadNextIndexInBackground() {
        mWorkerQueue.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.813 -0400", hash_original_method = "4CF90A1CB7C420A204E3629193269707", hash_generated_method = "4F8E79260CEDFB83D7C7B20CF954EF60")
        @Override
        public void run() {
    if(mServiceConnection.isConnected())            
            {
                int position = -1;
                boolean isRequested = false;
                synchronized
(mCache)                {
                    int[] res = mCache.getNextIndexToLoad();
                    position = res[0];
                    isRequested = res[1] > 0;
                } //End block
    if(position > -1)                
                {
                    updateRemoteViews(position, isRequested);
                    loadNextIndexInBackground();
                } //End block
                else
                {
                    enqueueDeferredUnbindServiceMessage();
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.814 -0400", hash_original_method = "E1B2571B376275F4805513EEE2D5A305", hash_generated_method = "EEB1EA6ABCB50BED9CA1AFEDF32A8418")
    private void processException(String method, Exception e) {
        addTaint(e.getTaint());
        addTaint(method.getTaint());
        final RemoteViewsMetaData metaData = mCache.getMetaData();
        synchronized
(metaData)        {
            metaData.reset();
        } //End block
        synchronized
(mCache)        {
            mCache.reset();
        } //End block
        mMainQueue.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.814 -0400", hash_original_method = "20780F1316FA6B5AAEF80ABB110F8A58", hash_generated_method = "9658C6127F239982755926B1BF541104")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.815 -0400", hash_original_method = "49F084C42EF1DBBC4522A49655FF79A1", hash_generated_method = "C94DF60BDA17E5A3472086883E948346")
    private void updateTemporaryMetaData() {
        IRemoteViewsFactory factory = mServiceConnection.getRemoteViewsFactory();
        try 
        {
            boolean hasStableIds = factory.hasStableIds();
            int viewTypeCount = factory.getViewTypeCount();
            int count = factory.getCount();
            RemoteViews loadingView = factory.getLoadingView();
            RemoteViews firstView = null;
    if((count > 0) && (loadingView == null))            
            {
                firstView = factory.getViewAt(0);
            } //End block
            final RemoteViewsMetaData tmpMetaData = mCache.getTemporaryMetaData();
            synchronized
(tmpMetaData)            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.816 -0400", hash_original_method = "5FA96F3EFCF6BBECAF668E31FDA609B8", hash_generated_method = "DEFEC5CFC922CE8D82EB4723DB0339DB")
    private void updateRemoteViews(final int position, boolean isRequested) {
        addTaint(isRequested);
        addTaint(position);
    if(!mServiceConnection.isConnected())        
        return;
        IRemoteViewsFactory factory = mServiceConnection.getRemoteViewsFactory();
        RemoteViews remoteViews = null;
        long itemId = 0;
        try 
        {
            remoteViews = factory.getViewAt(position);
            itemId = factory.getItemId(position);
        } //End block
        catch (RemoteException e)
        {
            return;
        } //End block
        catch (RuntimeException e)
        {
            return;
        } //End block
    if(remoteViews == null)        
        {
            return;
        } //End block
        synchronized
(mCache)        {
            mCache.insert(position, remoteViews, itemId, isRequested);
            final RemoteViews rv = remoteViews;
            final int typeId = mCache.getMetaDataAt(position).typeId;
            mMainQueue.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.816 -0400", hash_original_method = "893654825C9F0EE31547B34AB12EB1B2", hash_generated_method = "EC088C820250E0DE41EE3A77F29725DC")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.816 -0400", hash_original_method = "F998EBA4725E32A416A597964901E5AB", hash_generated_method = "632FCEC4D3CC012521B771C3F84724A5")
    public Intent getRemoteViewsServiceIntent() {
Intent var4DCF8E3D75AE0B94CDA94656DCE16BCE_434137577 =         mIntent;
        var4DCF8E3D75AE0B94CDA94656DCE16BCE_434137577.addTaint(taint);
        return var4DCF8E3D75AE0B94CDA94656DCE16BCE_434137577;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.817 -0400", hash_original_method = "BD4FA508848CEC346AF576100841FA5B", hash_generated_method = "82547F73F02C415F48AF1518298378BC")
    public int getCount() {
        final RemoteViewsMetaData metaData = mCache.getMetaData();
        synchronized
(metaData)        {
            int varADF0D97DEFDF3C282CCD2E376CFB1815_1397581358 = (metaData.count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720342835 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720342835;
        } //End block
        // ---------- Original Method ----------
        //final RemoteViewsMetaData metaData = mCache.getMetaData();
        //synchronized (metaData) {
            //return metaData.count;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.817 -0400", hash_original_method = "AE0D3BF5CEF608E0D2B9C47624E8B8EC", hash_generated_method = "CEC4C93E90A6537493188A76073A4F4C")
    public Object getItem(int position) {
        addTaint(position);
Object var540C13E9E156B687226421B24F2DF178_1088898032 =         null;
        var540C13E9E156B687226421B24F2DF178_1088898032.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1088898032;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.817 -0400", hash_original_method = "03B3187C996D144F3BCFDF9DFF16615D", hash_generated_method = "51D00A85FE4DB6D7B14974F093A2EBD2")
    public long getItemId(int position) {
        addTaint(position);
        synchronized
(mCache)        {
    if(mCache.containsMetaDataAt(position))            
            {
                long varAD3999B8114F8EBC087307F2920D831F_860866351 = (mCache.getMetaDataAt(position).itemId);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_300639914 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_300639914;
            } //End block
            long varCFCD208495D565EF66E7DFF9F98764DA_405244968 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_601930416 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_601930416;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mCache) {
            //if (mCache.containsMetaDataAt(position)) {
                //return mCache.getMetaDataAt(position).itemId;
            //}
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.817 -0400", hash_original_method = "BDCE0C462966DEB126F7FB99CEF6A82A", hash_generated_method = "95CB2EE5A6A72688A62492478342FB8B")
    public int getItemViewType(int position) {
        addTaint(position);
        int typeId = 0;
        synchronized
(mCache)        {
    if(mCache.containsMetaDataAt(position))            
            {
                typeId = mCache.getMetaDataAt(position).typeId;
            } //End block
            else
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_301090784 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896464992 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896464992;
            } //End block
        } //End block
        final RemoteViewsMetaData metaData = mCache.getMetaData();
        synchronized
(metaData)        {
            int var9B4BF38F0C072312E913D5E5340E1514_80308710 = (metaData.getMappedViewType(typeId));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067165180 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067165180;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.818 -0400", hash_original_method = "A43180B0154FDAA6CD8755A8245F56F8", hash_generated_method = "3A777DA26CE617401E0C73A71E4D64EE")
    private int getConvertViewTypeId(View convertView) {
        addTaint(convertView.getTaint());
        int typeId = -1;
    if(convertView != null)        
        {
            Object tag = convertView.getTag(com.android.internal.R.id.rowTypeId);
    if(tag != null)            
            {
                typeId = (Integer) tag;
            } //End block
        } //End block
        int var5F694956811487225D15E973CA38FBAB_19129732 = (typeId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316158778 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316158778;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.820 -0400", hash_original_method = "6C789CA1A76BB0C76EA62E1C57E6DD64", hash_generated_method = "C94167E662AAFA3087FE0BCD026DF858")
    public View getView(int position, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
        synchronized
(mCache)        {
            boolean isInCache = mCache.containsRemoteViewAt(position);
            boolean isConnected = mServiceConnection.isConnected();
            boolean hasNewItems = false;
    if(!isInCache && !isConnected)            
            {
                requestBindService();
            } //End block
            else
            {
                hasNewItems = mCache.queuePositionsToBePreloadedFromRequestedPosition(position);
            } //End block
    if(isInCache)            
            {
                View convertViewChild = null;
                int convertViewTypeId = 0;
                RemoteViewsFrameLayout layout = null;
    if(convertView instanceof RemoteViewsFrameLayout)                
                {
                    layout = (RemoteViewsFrameLayout) convertView;
                    convertViewChild = layout.getChildAt(0);
                    convertViewTypeId = getConvertViewTypeId(convertViewChild);
                } //End block
                Context context = parent.getContext();
                RemoteViews rv = mCache.getRemoteViewsAt(position);
                RemoteViewsIndexMetaData indexMetaData = mCache.getMetaDataAt(position);
                indexMetaData.isRequested = true;
                int typeId = indexMetaData.typeId;
                try 
                {
    if(layout != null)                    
                    {
    if(convertViewTypeId == typeId)                        
                        {
                            rv.reapply(context, convertViewChild);
View var6BB281F92ECF603ABC908502047A266C_2074764173 =                             layout;
                            var6BB281F92ECF603ABC908502047A266C_2074764173.addTaint(taint);
                            return var6BB281F92ECF603ABC908502047A266C_2074764173;
                        } //End block
                        layout.removeAllViews();
                    } //End block
                    else
                    {
                        layout = new RemoteViewsFrameLayout(context);
                    } //End block
                    View newView = rv.apply(context, parent);
                    newView.setTagInternal(com.android.internal.R.id.rowTypeId,
                            new Integer(typeId));
                    layout.addView(newView);
View var6BB281F92ECF603ABC908502047A266C_1088673947 =                     layout;
                    var6BB281F92ECF603ABC908502047A266C_1088673947.addTaint(taint);
                    return var6BB281F92ECF603ABC908502047A266C_1088673947;
                } //End block
                catch (Exception e)
                {
                    RemoteViewsFrameLayout loadingView = null;
                    final RemoteViewsMetaData metaData = mCache.getMetaData();
                    synchronized
(metaData)                    {
                        loadingView = metaData.createLoadingView(position, convertView, parent);
                    } //End block
View var1E24B731A35B9B8D5F7D3DE335D90A52_522887549 =                     loadingView;
                    var1E24B731A35B9B8D5F7D3DE335D90A52_522887549.addTaint(taint);
                    return var1E24B731A35B9B8D5F7D3DE335D90A52_522887549;
                } //End block
                finally 
                {
    if(hasNewItems)                    
                    loadNextIndexInBackground();
                } //End block
            } //End block
            else
            {
                RemoteViewsFrameLayout loadingView = null;
                final RemoteViewsMetaData metaData = mCache.getMetaData();
                synchronized
(metaData)                {
                    loadingView = metaData.createLoadingView(position, convertView, parent);
                } //End block
                mRequestedViews.add(position, loadingView);
                mCache.queueRequestedPositionToLoad(position);
                loadNextIndexInBackground();
View var1E24B731A35B9B8D5F7D3DE335D90A52_1832670201 =                 loadingView;
                var1E24B731A35B9B8D5F7D3DE335D90A52_1832670201.addTaint(taint);
                return var1E24B731A35B9B8D5F7D3DE335D90A52_1832670201;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.820 -0400", hash_original_method = "E20153FA245BC3D829E7670B1CF87BF9", hash_generated_method = "AC9B912E9E7330C061688182F34F34BA")
    public int getViewTypeCount() {
        final RemoteViewsMetaData metaData = mCache.getMetaData();
        synchronized
(metaData)        {
            int varC8132AF0C5C1B198CD092E9E07E18117_2124452284 = (metaData.viewTypeCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71589064 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71589064;
        } //End block
        // ---------- Original Method ----------
        //final RemoteViewsMetaData metaData = mCache.getMetaData();
        //synchronized (metaData) {
            //return metaData.viewTypeCount;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.821 -0400", hash_original_method = "30FBD60CD0291FCC8DBBE0ACB800AAAA", hash_generated_method = "6618A019A834EC6C8260A0E7ABBA91BE")
    public boolean hasStableIds() {
        final RemoteViewsMetaData metaData = mCache.getMetaData();
        synchronized
(metaData)        {
            boolean var009BB28B0DB682E659144E38ACC269E1_990702476 = (metaData.hasStableIds);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_147812251 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_147812251;
        } //End block
        // ---------- Original Method ----------
        //final RemoteViewsMetaData metaData = mCache.getMetaData();
        //synchronized (metaData) {
            //return metaData.hasStableIds;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.821 -0400", hash_original_method = "53D7DB97161C41CC976317DC7E27F456", hash_generated_method = "8BB65ED66D3DF5BC9B9A5D0CD92F3DCB")
    public boolean isEmpty() {
        boolean varA16589CB230D710779025FE5755999D8_1554860390 = (getCount() <= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_202884623 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_202884623;
        // ---------- Original Method ----------
        //return getCount() <= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.822 -0400", hash_original_method = "2DAA079F2CA383CBC7C346F3BCA57054", hash_generated_method = "1BBC7D5615669363E0A506731E544803")
    private void onNotifyDataSetChanged() {
        IRemoteViewsFactory factory = mServiceConnection.getRemoteViewsFactory();
        try 
        {
            factory.onDataSetChanged();
        } //End block
        catch (RemoteException e)
        {
            return;
        } //End block
        catch (RuntimeException e)
        {
            return;
        } //End block
        synchronized
(mCache)        {
            mCache.reset();
        } //End block
        updateTemporaryMetaData();
        mMainQueue.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.821 -0400", hash_original_method = "599F6D416D0C87E072E14AB486244C9F", hash_generated_method = "E6817A54A3D5239EFDEB5489BD481077")
        @Override
        public void run() {
            synchronized
(mCache)            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.823 -0400", hash_original_method = "0764FC8C95C069ED9ED094B35DCC527A", hash_generated_method = "FC55705B3C5C2D8E67C2D81EFC289DD5")
    public void notifyDataSetChanged() {
        mMainQueue.removeMessages(sUnbindServiceMessageType);
    if(!mServiceConnection.isConnected())        
        {
    if(mNotifyDataSetChangedAfterOnServiceConnected)            
            {
                return;
            } //End block
            mNotifyDataSetChangedAfterOnServiceConnected = true;
            requestBindService();
            return;
        } //End block
        mWorkerQueue.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.822 -0400", hash_original_method = "041C495048132FF173BFCDF38ABB5707", hash_generated_method = "A0E7FB80DBA0806D596A5B67FD46EBEA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.823 -0400", hash_original_method = "A1EDDF3811A1F9D28CCD28C93269FAD1", hash_generated_method = "13135540CF0C096F7922371AE0301E89")
     void superNotifyDataSetChanged() {
        super.notifyDataSetChanged();
        // ---------- Original Method ----------
        //super.notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.824 -0400", hash_original_method = "96758E0B3254F3B4A777FC060A49CC59", hash_generated_method = "C92161436BB677E7AFDD352AC08DDF73")
    @Override
    public boolean handleMessage(Message msg) {
        addTaint(msg.getTaint());
        boolean result = false;
switch(msg.what){
        case sUnbindServiceMessageType:
    if(mServiceConnection.isConnected())        
        {
            mServiceConnection.unbind(mContext, mAppWidgetId, mIntent);
        } //End block
        result = true;
        break;
        default:
        break;
}        boolean varB4A88417B3D0170D754C647C30B7216A_887648399 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300360902 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_300360902;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.824 -0400", hash_original_method = "D880D88722499DDF7E3D229A00764CBB", hash_generated_method = "8943C3C3F64C9B76CBBF6A8AA4DF52C7")
    private void enqueueDeferredUnbindServiceMessage() {
        mMainQueue.removeMessages(sUnbindServiceMessageType);
        mMainQueue.sendEmptyMessageDelayed(sUnbindServiceMessageType, sUnbindServiceDelay);
        // ---------- Original Method ----------
        //mMainQueue.removeMessages(sUnbindServiceMessageType);
        //mMainQueue.sendEmptyMessageDelayed(sUnbindServiceMessageType, sUnbindServiceDelay);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.824 -0400", hash_original_method = "FD0BDD14354B6205FD4E5E773D9BDB6D", hash_generated_method = "995ABEA89F03B234BE3F130D6C6832F0")
    private boolean requestBindService() {
    if(!mServiceConnection.isConnected())        
        {
            mServiceConnection.bind(mContext, mAppWidgetId, mIntent);
        } //End block
        mMainQueue.removeMessages(sUnbindServiceMessageType);
        boolean varFA613BFDB2C7CD590F74314A66212A91_164619054 = (mServiceConnection.isConnected());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1214820194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1214820194;
        // ---------- Original Method ----------
        //if (!mServiceConnection.isConnected()) {
            //mServiceConnection.bind(mContext, mAppWidgetId, mIntent);
        //}
        //mMainQueue.removeMessages(sUnbindServiceMessageType);
        //return mServiceConnection.isConnected();
    }

    
    private static class RemoteViewsAdapterServiceConnection extends IRemoteViewsAdapterConnection.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.825 -0400", hash_original_field = "CC8BFB84898B22492B7F55096CBDF6CC", hash_generated_field = "76A19B81A43EEDF4AF3BF911EC3960E9")

        private boolean mIsConnected;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.825 -0400", hash_original_field = "0B061825A2BD144F822A600E85C8460D", hash_generated_field = "71FF1B688CE6E1B60B73B36B2E842EB8")

        private boolean mIsConnecting;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.825 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "DF300972716819DE62AFA33FE9FFC280")

        private WeakReference<RemoteViewsAdapter> mAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.825 -0400", hash_original_field = "3259B525D7D221061093A7706AFAA49A", hash_generated_field = "722330FA05DFEF3176A8163BFC4DC620")

        private IRemoteViewsFactory mRemoteViewsFactory;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.826 -0400", hash_original_method = "7E10295116D6DF0B2080F7EEB3B8FF2F", hash_generated_method = "2CBC4DD0E19B00EEE4BD2962CC59C85E")
        public  RemoteViewsAdapterServiceConnection(RemoteViewsAdapter adapter) {
            mAdapter = new WeakReference<RemoteViewsAdapter>(adapter);
            // ---------- Original Method ----------
            //mAdapter = new WeakReference<RemoteViewsAdapter>(adapter);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.827 -0400", hash_original_method = "8522D247C3B96C2C6A0E0A6DFCD61958", hash_generated_method = "8B3BBB5F44E6978ADC93DD4F467AD41B")
        public synchronized void bind(Context context, int appWidgetId, Intent intent) {
            addTaint(intent.getTaint());
            addTaint(appWidgetId);
            addTaint(context.getTaint());
    if(!mIsConnecting)            
            {
                try 
                {
                    final AppWidgetManager mgr = AppWidgetManager.getInstance(context);
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

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.828 -0400", hash_original_method = "21A72C8FC580D8D0E809A3FEE2FDD93D", hash_generated_method = "A29871953EEC9D3275E7EF1E571F5459")
        public synchronized void unbind(Context context, int appWidgetId, Intent intent) {
            addTaint(intent.getTaint());
            addTaint(appWidgetId);
            addTaint(context.getTaint());
            try 
            {
                final AppWidgetManager mgr = AppWidgetManager.getInstance(context);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.830 -0400", hash_original_method = "08CA49D02360F6C2A6BB2EFEF11F092E", hash_generated_method = "B99300D1DB97D1E7C5B006F848170611")
        public synchronized void onServiceConnected(IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mRemoteViewsFactory = IRemoteViewsFactory.Stub.asInterface(service);
            final RemoteViewsAdapter adapter = mAdapter.get();
    if(adapter == null)            
            return;
            adapter.mWorkerQueue.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.829 -0400", hash_original_method = "C9280BFFF3D57DCE91D4B8E9AF737343", hash_generated_method = "D0AC3CDFAAE891D5350470D18D0EC409")
            @Override
            public void run() {
    if(adapter.mNotifyDataSetChangedAfterOnServiceConnected)                
                {
                    adapter.onNotifyDataSetChanged();
                } //End block
                else
                {
                    IRemoteViewsFactory factory = adapter.mServiceConnection.getRemoteViewsFactory();
                    try 
                    {
    if(!factory.isCreated())                        
                        {
                            factory.onDataSetChanged();
                        } //End block
                    } //End block
                    catch (RemoteException e)
                    {
                        return;
                    } //End block
                    catch (RuntimeException e)
                    {
                    } //End block
                    adapter.updateTemporaryMetaData();
                    adapter.mMainQueue.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.829 -0400", hash_original_method = "15183F885AD888FE838F648B256AD495", hash_generated_method = "013EE7FDC19C4B344416CEA2C0C5B1A0")
                @Override
                public void run() {
                    synchronized
(adapter.mCache)                    {
                        adapter.mCache.commitTemporaryMetaData();
                    } //End block
                    final RemoteAdapterConnectionCallback callback = adapter.mCallback.get();
    if(callback != null)                    
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.830 -0400", hash_original_method = "6AD1D56D3A677AEA97BA981AA56DEDEB", hash_generated_method = "CB8DA390D47991A6EF25111352A9359D")
        public synchronized void onServiceDisconnected() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mIsConnected = false;
            mIsConnecting = false;
            mRemoteViewsFactory = null;
            final RemoteViewsAdapter adapter = mAdapter.get();
    if(adapter == null)            
            return;
            adapter.mMainQueue.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.830 -0400", hash_original_method = "5256C3FE0B7F0EC8DBD6E0D8928BE4C4", hash_generated_method = "455E960911DC063566DB4A85069CB4F5")
            @Override
            public void run() {
                adapter.mMainQueue.removeMessages(sUnbindServiceMessageType);
                final RemoteAdapterConnectionCallback callback = adapter.mCallback.get();
    if(callback != null)                
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.831 -0400", hash_original_method = "9AC2F72588B70E9E489A1C9892FF58B7", hash_generated_method = "D3BC84D5A13E1FF819F4F7E9B7F92139")
        public synchronized IRemoteViewsFactory getRemoteViewsFactory() {
IRemoteViewsFactory varAF67D4556746D546103D77FCAD8F9B06_531417945 =             mRemoteViewsFactory;
            varAF67D4556746D546103D77FCAD8F9B06_531417945.addTaint(taint);
            return varAF67D4556746D546103D77FCAD8F9B06_531417945;
            // ---------- Original Method ----------
            //return mRemoteViewsFactory;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.831 -0400", hash_original_method = "EB76BB3DACEAD8AEFFF382088AE69C8F", hash_generated_method = "0C16019A17EC0C7B2D3B4AF8B5F7005A")
        public synchronized boolean isConnected() {
            boolean varCC8BFB84898B22492B7F55096CBDF6CC_648476046 = (mIsConnected);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1657047761 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1657047761;
            // ---------- Original Method ----------
            //return mIsConnected;
        }

        
    }


    
    private class RemoteViewsFrameLayout extends FrameLayout {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.831 -0400", hash_original_method = "15F65CD5E3BE0169B47C7BF19C42CB6A", hash_generated_method = "84BEC92F8166F0087E1C907BC13AD329")
        public  RemoteViewsFrameLayout(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.832 -0400", hash_original_method = "376943697B2A7028E475228F1F5698F0", hash_generated_method = "965322F5E61FD90578F02C19D3641151")
        public void onRemoteViewsLoaded(RemoteViews view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(view.getTaint());
            try 
            {
                removeAllViews();
                addView(view.apply(getContext(), this));
            } //End block
            catch (Exception e)
            {
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.832 -0400", hash_original_field = "49480114F1DA72B3D385F91F28CAB531", hash_generated_field = "0DDDAE295C285660CD7FE8EBB6DC5F4A")

        private HashMap<Integer, LinkedList<RemoteViewsFrameLayout>> mReferences;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.832 -0400", hash_original_method = "6FF139149B49AE6D730172FAFB07DD3B", hash_generated_method = "04F49291A2A41B3FE0D9405505C49E32")
        public  RemoteViewsFrameLayoutRefSet() {
            mReferences = new HashMap<Integer, LinkedList<RemoteViewsFrameLayout>>();
            // ---------- Original Method ----------
            //mReferences = new HashMap<Integer, LinkedList<RemoteViewsFrameLayout>>();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.832 -0400", hash_original_method = "3F0456D57D98DD5B5AAA7D7D24636D4D", hash_generated_method = "E3A2008839D15B2C0631BC59DB4A5F08")
        public void add(int position, RemoteViewsFrameLayout layout) {
            addTaint(layout.getTaint());
            addTaint(position);
            final Integer pos = position;
            LinkedList<RemoteViewsFrameLayout> refs;
    if(mReferences.containsKey(pos))            
            {
                refs = mReferences.get(pos);
            } //End block
            else
            {
                refs = new LinkedList<RemoteViewsFrameLayout>();
                mReferences.put(pos, refs);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.833 -0400", hash_original_method = "B75D35E25E548F04E2C73EAA0A8BAD12", hash_generated_method = "68AB02ECBDB1B65F23E6874480F5F0D2")
        public void notifyOnRemoteViewsLoaded(int position, RemoteViews view, int typeId) {
            addTaint(typeId);
            addTaint(view.getTaint());
            addTaint(position);
    if(view == null)            
            return;
            final Integer pos = position;
    if(mReferences.containsKey(pos))            
            {
                final LinkedList<RemoteViewsFrameLayout> refs = mReferences.get(pos);
for(RemoteViewsFrameLayout ref : refs)
                {
                    ref.onRemoteViewsLoaded(view);
                } //End block
                refs.clear();
                mReferences.remove(pos);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.833 -0400", hash_original_method = "A232CA036EBBA3D167286637450EBE5D", hash_generated_method = "24EBFCA05188B87B49D1A34189D809C7")
        public void clear() {
            mReferences.clear();
            // ---------- Original Method ----------
            //mReferences.clear();
        }

        
    }


    
    private class RemoteViewsMetaData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.833 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "B83BF7ED7F5719DA923E1BC0AC69952B")

        int count;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.833 -0400", hash_original_field = "838BF490B590E83463A4659B060C26FC", hash_generated_field = "C1E9C1B6290BF40ADECDA7DF82FAC94D")

        int viewTypeCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.834 -0400", hash_original_field = "DAF737EDDF98B803755EC84BA73A5E3F", hash_generated_field = "004C2D81765875057DD2D513A7A85CEF")

        boolean hasStableIds;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.834 -0400", hash_original_field = "6EDDEBA4B8B8FD0722D0BB53E14FFC0C", hash_generated_field = "9A49302F66DF2887EFAB714BA0B6B15B")

        RemoteViews mUserLoadingView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.834 -0400", hash_original_field = "41D6ADCC8C59297CD329E31519FD34AA", hash_generated_field = "39C526A78EF58332F9FAD2AD78897B3C")

        RemoteViews mFirstView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.834 -0400", hash_original_field = "308D00B001FC55B7BD96E24977E53940", hash_generated_field = "32C08FC6170C53D3EDBAD53E03B1BB3B")

        int mFirstViewHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.834 -0400", hash_original_field = "F7A46FD11046228C04C0DA5E8752213C", hash_generated_field = "0D244E4CBA0E96257463501C2DF63318")

        private final HashMap<Integer, Integer> mTypeIdIndexMap = new HashMap<Integer, Integer>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.834 -0400", hash_original_method = "A4C124A869EBADBA9AE6D60BBB8A7C9F", hash_generated_method = "3DCD91096CB130F5938CD8D146151676")
        public  RemoteViewsMetaData() {
            reset();
            // ---------- Original Method ----------
            //reset();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.834 -0400", hash_original_method = "90BA893E06B3709572F4D6BD4487FB6C", hash_generated_method = "707F04AB9E070A59A452C861A2233E92")
        public void set(RemoteViewsMetaData d) {
            synchronized
(d)            {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.835 -0400", hash_original_method = "AE7C296E4C5BBC73F59980BD54540BF2", hash_generated_method = "E27E2C57D2D5002944558FDACF04DF1D")
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.836 -0400", hash_original_method = "E784F858D155FE6C94A91B290D47017F", hash_generated_method = "996C18A8F0BEBB2D319EAD8B9E9DDAB6")
        public void setLoadingViewTemplates(RemoteViews loadingView, RemoteViews firstView) {
            mUserLoadingView = loadingView;
    if(firstView != null)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.836 -0400", hash_original_method = "78DD70270396881EC8B9AE912C927B26", hash_generated_method = "957E2B8DF33445450CB12FF19E2C4A0D")
        public int getMappedViewType(int typeId) {
            addTaint(typeId);
    if(mTypeIdIndexMap.containsKey(typeId))            
            {
                int var2C51CE7380EBD7940D26243A0F0E9133_1564249057 = (mTypeIdIndexMap.get(typeId));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129254480 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129254480;
            } //End block
            else
            {
                int incrementalTypeId = mTypeIdIndexMap.size() + 1;
                mTypeIdIndexMap.put(typeId, incrementalTypeId);
                int varCC0537845765F58F5A8E0E117616BC13_2014561710 = (incrementalTypeId);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1030390567 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1030390567;
            } //End block
            // ---------- Original Method ----------
            //if (mTypeIdIndexMap.containsKey(typeId)) {
                //return mTypeIdIndexMap.get(typeId);
            //} else {
                //int incrementalTypeId = mTypeIdIndexMap.size() + 1;
                //mTypeIdIndexMap.put(typeId, incrementalTypeId);
                //return incrementalTypeId;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.837 -0400", hash_original_method = "6B923D58C715B2F45FA359F8E18C8A1F", hash_generated_method = "A5B41E26A5CC2350B582A318D8554CD3")
        private RemoteViewsFrameLayout createLoadingView(int position, View convertView,
                ViewGroup parent) {
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(position);
            final Context context = parent.getContext();
            RemoteViewsFrameLayout layout = new RemoteViewsFrameLayout(context);
            synchronized
(mCache)            {
                boolean customLoadingViewAvailable = false;
    if(mUserLoadingView != null)                
                {
                    try 
                    {
                        View loadingView = mUserLoadingView.apply(parent.getContext(), parent);
                        loadingView.setTagInternal(com.android.internal.R.id.rowTypeId,
                                new Integer(0));
                        layout.addView(loadingView);
                        customLoadingViewAvailable = true;
                    } //End block
                    catch (Exception e)
                    {
                    } //End block
                } //End block
    if(!customLoadingViewAvailable)                
                {
    if(mFirstViewHeight < 0)                    
                    {
                        try 
                        {
                            View firstView = mFirstView.apply(parent.getContext(), parent);
                            firstView.measure(
                                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
                                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                            mFirstViewHeight = firstView.getMeasuredHeight();
                            mFirstView = null;
                        } //End block
                        catch (Exception e)
                        {
                            float density = mContext.getResources().getDisplayMetrics().density;
                            mFirstViewHeight = (int)
                                    Math.round(sDefaultLoadingViewHeight * density);
                            mFirstView = null;
                        } //End block
                    } //End block
                    TextView loadingTextView = (TextView) mLayoutInflater.inflate(
                            com.android.internal.R.layout.remote_views_adapter_default_loading_view,
                            layout, false);
                    loadingTextView.setHeight(mFirstViewHeight);
                    loadingTextView.setTag(new Integer(0));
                    layout.addView(loadingTextView);
                } //End block
            } //End block
RemoteViewsFrameLayout var6BB281F92ECF603ABC908502047A266C_267645710 =             layout;
            var6BB281F92ECF603ABC908502047A266C_267645710.addTaint(taint);
            return var6BB281F92ECF603ABC908502047A266C_267645710;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class RemoteViewsIndexMetaData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.837 -0400", hash_original_field = "5F694956811487225D15E973CA38FBAB", hash_generated_field = "76F76148F5071AE6285A6BC57B0ADE91")

        int typeId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.837 -0400", hash_original_field = "59A814AA020A1B32C4674A5887A35022", hash_generated_field = "90EEB5AA84937AD6A8CE9746B6FECA6A")

        long itemId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.837 -0400", hash_original_field = "1F12075C4184F616A07646739C4342EE", hash_generated_field = "060C657FCDBB17A3289922E65DB8FCC4")

        boolean isRequested;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.838 -0400", hash_original_method = "429CAA99D27E695F91D025FEB15660FB", hash_generated_method = "FB1243FFAB8B5AE6A9A1DC9B23DC1E4C")
        public  RemoteViewsIndexMetaData(RemoteViews v, long itemId, boolean requested) {
            addTaint(requested);
            addTaint(itemId);
            addTaint(v.getTaint());
            set(v, itemId, requested);
            // ---------- Original Method ----------
            //set(v, itemId, requested);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.838 -0400", hash_original_method = "6F36A962FFB607392BC2E34875EB4BD4", hash_generated_method = "E48E04E907EB21F704B8A501D3C21431")
        public void set(RemoteViews v, long id, boolean requested) {
            itemId = id;
    if(v != null)            
            typeId = v.getLayoutId();
            else
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.839 -0400", hash_original_field = "0FCE5B64423E6B04C33CE3468F58DA62", hash_generated_field = "C7BAEA4EAD131C24153F2BC22502F2DA")

        private RemoteViewsMetaData mMetaData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.839 -0400", hash_original_field = "35898A5A614C542A7664A6A85A2DF029", hash_generated_field = "CCFF7299FB9E7ED02A6E6C63B5236D05")

        private RemoteViewsMetaData mTemporaryMetaData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.839 -0400", hash_original_field = "BBD9C074C8BFE7F5F7C066E06D309B25", hash_generated_field = "4D7BFF7687FF3AEB2660E6771DA7A41D")

        private HashMap<Integer, RemoteViewsIndexMetaData> mIndexMetaData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.839 -0400", hash_original_field = "E23925CEBC8CCBD3D31D40082C05C370", hash_generated_field = "622EF405E12F8FB6D80FD7F1E7909760")

        private HashMap<Integer, RemoteViews> mIndexRemoteViews;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.839 -0400", hash_original_field = "585798A32AF4C3DD10344010FF6B9706", hash_generated_field = "534B08E02E91774394FCE7D691C682CB")

        private HashSet<Integer> mRequestedIndices;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.839 -0400", hash_original_field = "461C6567414062E123C02AA45E52645E", hash_generated_field = "EDD6140FE3EFE2A884527802E7502D5E")

        private int mLastRequestedIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.839 -0400", hash_original_field = "E8A3A3187B0CAF3B63074C35EF6D6C3C", hash_generated_field = "7552CCBBABA4C6673CFCAA35306E60E9")

        private HashSet<Integer> mLoadIndices;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.839 -0400", hash_original_field = "65E5D7D551CCC2236163247CBA82EA30", hash_generated_field = "AF3636EC231AD49E7BB961CA0D975BAD")

        private int mPreloadLowerBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.839 -0400", hash_original_field = "5918180AF4002B2A1ADC99DB1B26CFD5", hash_generated_field = "8874B6DBCCBC94897623594595F133DB")

        private int mPreloadUpperBound;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.839 -0400", hash_original_field = "DA6F53F2281C91E02577C5A3C4B75B90", hash_generated_field = "07593739EA51894193F3BFC61924FDA8")

        private int mMaxCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.839 -0400", hash_original_field = "0CFFCC288FFB8495CE255EC76ADE18D2", hash_generated_field = "802409AF8ABEE98E4B589C02F0E51998")

        private int mMaxCountSlack;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.840 -0400", hash_original_method = "AFDF05837CF8EF03047EB57BF9703B63", hash_generated_method = "C06B39B7022755D679EF8EF25E68C287")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.841 -0400", hash_original_method = "3B60FC97D93DDECF59F968EA9F5DCEA5", hash_generated_method = "0D5CFE0E6AE86BCB41754164DCCFF2B4")
        public void insert(int position, RemoteViews v, long itemId, boolean isRequested) {
            addTaint(isRequested);
            addTaint(itemId);
            addTaint(v.getTaint());
            addTaint(position);
    if(mIndexRemoteViews.size() >= mMaxCount)            
            {
                mIndexRemoteViews.remove(getFarthestPositionFrom(position));
            } //End block
            int pruneFromPosition = (mLastRequestedIndex > -1) ? mLastRequestedIndex : position;
            while
(getRemoteViewsBitmapMemoryUsage() >= sMaxMemoryLimitInBytes)            
            {
                mIndexRemoteViews.remove(getFarthestPositionFrom(pruneFromPosition));
            } //End block
    if(mIndexMetaData.containsKey(position))            
            {
                final RemoteViewsIndexMetaData metaData = mIndexMetaData.get(position);
                metaData.set(v, itemId, isRequested);
            } //End block
            else
            {
                mIndexMetaData.put(position, new RemoteViewsIndexMetaData(v, itemId, isRequested));
            } //End block
            mIndexRemoteViews.put(position, v);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.841 -0400", hash_original_method = "CE79B98C6EC29820DC37D3CBF74EA749", hash_generated_method = "5AB91FDF4489229438094A0DF8A71C39")
        public RemoteViewsMetaData getMetaData() {
RemoteViewsMetaData var9D2A3B5F7701188602630E4A3AA72144_2033889586 =             mMetaData;
            var9D2A3B5F7701188602630E4A3AA72144_2033889586.addTaint(taint);
            return var9D2A3B5F7701188602630E4A3AA72144_2033889586;
            // ---------- Original Method ----------
            //return mMetaData;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.842 -0400", hash_original_method = "1D24E06D74C40EECF68D58BAFBBECA77", hash_generated_method = "9334AAA63976210AB4248B3BDE734113")
        public RemoteViewsMetaData getTemporaryMetaData() {
RemoteViewsMetaData var72BECA95754275A213FC731900C43798_798158070 =             mTemporaryMetaData;
            var72BECA95754275A213FC731900C43798_798158070.addTaint(taint);
            return var72BECA95754275A213FC731900C43798_798158070;
            // ---------- Original Method ----------
            //return mTemporaryMetaData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.842 -0400", hash_original_method = "2697DBEF8CDE0991B3151B5A3E03C7EB", hash_generated_method = "53F0AB6079563C776F2E12326855A886")
        public RemoteViews getRemoteViewsAt(int position) {
            addTaint(position);
    if(mIndexRemoteViews.containsKey(position))            
            {
RemoteViews var41F06D658A14D25FF31D2714734A3B7B_1009479106 =                 mIndexRemoteViews.get(position);
                var41F06D658A14D25FF31D2714734A3B7B_1009479106.addTaint(taint);
                return var41F06D658A14D25FF31D2714734A3B7B_1009479106;
            } //End block
RemoteViews var540C13E9E156B687226421B24F2DF178_116494809 =             null;
            var540C13E9E156B687226421B24F2DF178_116494809.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_116494809;
            // ---------- Original Method ----------
            //if (mIndexRemoteViews.containsKey(position)) {
                //return mIndexRemoteViews.get(position);
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.842 -0400", hash_original_method = "1A017214F368969D3B3DFEA7A0D6E60A", hash_generated_method = "89C33F4EF2AC52D418E792272E8398E9")
        public RemoteViewsIndexMetaData getMetaDataAt(int position) {
            addTaint(position);
    if(mIndexMetaData.containsKey(position))            
            {
RemoteViewsIndexMetaData var575E413A51040B3C942670D75B4767CB_1511318802 =                 mIndexMetaData.get(position);
                var575E413A51040B3C942670D75B4767CB_1511318802.addTaint(taint);
                return var575E413A51040B3C942670D75B4767CB_1511318802;
            } //End block
RemoteViewsIndexMetaData var540C13E9E156B687226421B24F2DF178_1754380580 =             null;
            var540C13E9E156B687226421B24F2DF178_1754380580.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1754380580;
            // ---------- Original Method ----------
            //if (mIndexMetaData.containsKey(position)) {
                //return mIndexMetaData.get(position);
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.842 -0400", hash_original_method = "4EDEA047857C8C00C25F35FE7AF06430", hash_generated_method = "EE5F47AFFC39D562DD0AE22AAFF40649")
        public void commitTemporaryMetaData() {
            synchronized
(mTemporaryMetaData)            {
                synchronized
(mMetaData)                {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.843 -0400", hash_original_method = "1379738D9DE8B74BE60C7743F79F9609", hash_generated_method = "77AB580905356D1486487B92B38D774C")
        private int getRemoteViewsBitmapMemoryUsage() {
            int mem = 0;
for(Integer i : mIndexRemoteViews.keySet())
            {
                final RemoteViews v = mIndexRemoteViews.get(i);
    if(v != null)                
                {
                    mem += v.estimateBitmapMemoryUsage();
                } //End block
            } //End block
            int varAFC4FC7E48A0710A1DC94EF3E8BC5764_1576080969 = (mem);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143519674 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143519674;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.843 -0400", hash_original_method = "61B11826B25E039221975DE702D21975", hash_generated_method = "B980E4F8D7996CC7C18317E1A4D0D9E2")
        private int getFarthestPositionFrom(int pos) {
            addTaint(pos);
            int maxDist = 0;
            int maxDistIndex = -1;
            int maxDistNonRequested = 0;
            int maxDistIndexNonRequested = -1;
for(int i : mIndexRemoteViews.keySet())
            {
                int dist = Math.abs(i-pos);
    if(dist > maxDistNonRequested && !mIndexMetaData.get(i).isRequested)                
                {
                    maxDistIndexNonRequested = i;
                    maxDistNonRequested = dist;
                } //End block
    if(dist > maxDist)                
                {
                    maxDistIndex = i;
                    maxDist = dist;
                } //End block
            } //End block
    if(maxDistIndexNonRequested > -1)            
            {
                int varC12DB98CAA427D99B604C7BDEE26CBD2_433941313 = (maxDistIndexNonRequested);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194408317 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194408317;
            } //End block
            int var9E43A0CF6731D9E1442BFF36E775B65E_1702166527 = (maxDistIndex);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1775650678 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1775650678;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.843 -0400", hash_original_method = "FD296F73133B242F283CE39F258C0B72", hash_generated_method = "A0C6ABB844F7AF4641B566F58D7C31B7")
        public void queueRequestedPositionToLoad(int position) {
            mLastRequestedIndex = position;
            synchronized
(mLoadIndices)            {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.844 -0400", hash_original_method = "5E1B16EBD16301761756030AADF8738C", hash_generated_method = "5F264C684FEF6D77C3AEC0F45251CC00")
        public boolean queuePositionsToBePreloadedFromRequestedPosition(int position) {
    if(mPreloadLowerBound <= position && position <= mPreloadUpperBound)            
            {
                int center = (mPreloadUpperBound + mPreloadLowerBound) / 2;
    if(Math.abs(position - center) < mMaxCountSlack)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_528158316 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18068643 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_18068643;
                } //End block
            } //End block
            int count = 0;
            synchronized
(mMetaData)            {
                count = mMetaData.count;
            } //End block
            synchronized
(mLoadIndices)            {
                mLoadIndices.clear();
                mLoadIndices.addAll(mRequestedIndices);
                int halfMaxCount = mMaxCount / 2;
                mPreloadLowerBound = position - halfMaxCount;
                mPreloadUpperBound = position + halfMaxCount;
                int effectiveLowerBound = Math.max(0, mPreloadLowerBound);
                int effectiveUpperBound = Math.min(mPreloadUpperBound, count - 1);
for(int i = effectiveLowerBound;i <= effectiveUpperBound;++i)
                {
                    mLoadIndices.add(i);
                } //End block
                mLoadIndices.removeAll(mIndexRemoteViews.keySet());
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_186336760 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1398182025 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1398182025;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.844 -0400", hash_original_method = "06D7248AE2FAA4148F7714FEE4BB20F2", hash_generated_method = "FFC7C7CE4DF2E7707AE061E56F00C58D")
        public int[] getNextIndexToLoad() {
            synchronized
(mLoadIndices)            {
    if(!mRequestedIndices.isEmpty())                
                {
                    Integer i = mRequestedIndices.iterator().next();
                    mRequestedIndices.remove(i);
                    mLoadIndices.remove(i);
                    int[] var0F0B96631A55AFEDE575F00BE8B35E64_1304901503 = (new int[]{i.intValue(), 1});
                                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_701248080 = {getTaintInt()};
                    return varB4CCCA26F9DB9189C32F33E82D425CFB_701248080;
                } //End block
    if(!mLoadIndices.isEmpty())                
                {
                    Integer i = mLoadIndices.iterator().next();
                    mLoadIndices.remove(i);
                    int[] varAF6664BF1B3E7952D5EE406AE7467346_627452818 = (new int[]{i.intValue(), 0});
                                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_2085285982 = {getTaintInt()};
                    return varB4CCCA26F9DB9189C32F33E82D425CFB_2085285982;
                } //End block
                int[] var9010B87C7D73BB6FE9F7388D0B0798DF_1713750763 = (new int[]{-1, 0});
                                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_649214153 = {getTaintInt()};
                return varB4CCCA26F9DB9189C32F33E82D425CFB_649214153;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.844 -0400", hash_original_method = "BBBDB78E47117BE8689A9C55BD30A227", hash_generated_method = "3B22479940701163507101045468AAAA")
        public boolean containsRemoteViewAt(int position) {
            addTaint(position);
            boolean var50C03CE0AAA9B0A0CAB1DDE734019B8F_1242526045 = (mIndexRemoteViews.containsKey(position));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_96063057 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_96063057;
            // ---------- Original Method ----------
            //return mIndexRemoteViews.containsKey(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.844 -0400", hash_original_method = "97177722E4C5BA4D6397E6B225C059F2", hash_generated_method = "04189395BB9F45E26F80B6BA045914EF")
        public boolean containsMetaDataAt(int position) {
            addTaint(position);
            boolean var301052880A22C4797E996A7194F5223F_436205910 = (mIndexMetaData.containsKey(position));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_550995641 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_550995641;
            // ---------- Original Method ----------
            //return mIndexMetaData.containsKey(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.844 -0400", hash_original_method = "7D514E4141E3BAA67EC2DA2CF01B70A8", hash_generated_method = "A24F69D9CDE95373EDB977B6722CC9F2")
        public void reset() {
            mPreloadLowerBound = 0;
            mPreloadUpperBound = -1;
            mLastRequestedIndex = -1;
            mIndexRemoteViews.clear();
            mIndexMetaData.clear();
            synchronized
(mLoadIndices)            {
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.844 -0400", hash_original_field = "FB81249BF3052258E45C3888EBC350DA", hash_generated_field = "E4C58D7C8C895509DA92BEC5943A1E34")

        private static final String TAG = "FixedSizeRemoteViewsCache";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.844 -0400", hash_original_field = "F9740182F353B90A4BDBE330395C68FF", hash_generated_field = "386965B336D6EC3D60AD83613B46FEC6")

        private static final float sMaxCountSlackPercent = 0.75f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.845 -0400", hash_original_field = "FD1B2A98BB85E0640F1E9C7C18E4BBFA", hash_generated_field = "FC99CB6D04167C2E00EDD95CD8617B9F")

        private static final int sMaxMemoryLimitInBytes = 2 * 1024 * 1024;
    }


    
    public interface RemoteAdapterConnectionCallback {
        
        public boolean onRemoteAdapterConnected();

        public void onRemoteAdapterDisconnected();

        
        public void deferNotifyDataSetChanged();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.845 -0400", hash_original_field = "3F15C32F22D5D28B231422C2ED8DEA65", hash_generated_field = "911EBCEFE4CCEB1A8C54FB61D7AB0AD9")

    private static final String TAG = "RemoteViewsAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.845 -0400", hash_original_field = "9A2599D66205440D0C81070B0087E6C0", hash_generated_field = "7B64BF8061986040376D887000FE60FC")

    private static final int sDefaultCacheSize = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.845 -0400", hash_original_field = "D3029EB3FA6C6D927DC18B448E254A9B", hash_generated_field = "29B284EBC17ABF0E537021A944F5E17B")

    private static final int sUnbindServiceDelay = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.845 -0400", hash_original_field = "5AE9F7C5EEA0C30BF3724A26667822E1", hash_generated_field = "CD7B880CABC800B219D85862AA4BAB3E")

    private static final int sDefaultLoadingViewHeight = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.845 -0400", hash_original_field = "ADA4A5984A61A504209F17405FAE49F5", hash_generated_field = "B4ACA6FFB73AE04B468186CDC32AA932")

    private static final int sDefaultMessageType = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.845 -0400", hash_original_field = "2D292FE9AC86EFA8AB6604D58311922B", hash_generated_field = "3A6B65139510D8443CF01354FDD1924A")

    private static final int sUnbindServiceMessageType = 1;
}

