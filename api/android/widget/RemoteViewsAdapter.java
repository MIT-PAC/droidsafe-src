package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

import com.android.internal.widget.IRemoteViewsAdapterConnection;
import com.android.internal.widget.IRemoteViewsFactory;

public class RemoteViewsAdapter extends BaseAdapter implements Handler.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.541 -0500", hash_original_field = "9015949F6F6D68CEB48F73FC8B9DBBF1", hash_generated_field = "911EBCEFE4CCEB1A8C54FB61D7AB0AD9")

    private static final String TAG = "RemoteViewsAdapter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.544 -0500", hash_original_field = "E7BC63F21296D24F2707934CE9E848F9", hash_generated_field = "7B64BF8061986040376D887000FE60FC")

    private static final int sDefaultCacheSize = 40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.546 -0500", hash_original_field = "F2A73CB5294A0F44F41F76484913ED39", hash_generated_field = "BF771CB2EB1487BE1CD8F8C333A3062E")

    // This ensures that we don't stay continually bound to the service and that it can be destroyed
    // if we need the memory elsewhere in the system.
    private static final int sUnbindServiceDelay = 5000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.548 -0500", hash_original_field = "3ACB8FA65DD02D5D16DA738879F6DA7E", hash_generated_field = "CD7B880CABC800B219D85862AA4BAB3E")

    private static final int sDefaultLoadingViewHeight = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.551 -0500", hash_original_field = "54DDDE91F3903D58198A8CE45732DD47", hash_generated_field = "B4ACA6FFB73AE04B468186CDC32AA932")

    private static final int sDefaultMessageType = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.553 -0500", hash_original_field = "B9D4DFC85D54D8D8588BAF1656221187", hash_generated_field = "3A6B65139510D8443CF01354FDD1924A")

    private static final int sUnbindServiceMessageType = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.555 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.557 -0500", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private  Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.559 -0500", hash_original_field = "C187677719C4391D45C59B42615D4AC2", hash_generated_field = "B6D817E86C2105E427B243C6F2B8620A")

    private  int mAppWidgetId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.562 -0500", hash_original_field = "F0BCED03E8DC2B26A7860C39890DB1F4", hash_generated_field = "6C3DDC70E78FA863A6FCDBA124DEDF31")

    private LayoutInflater mLayoutInflater;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.564 -0500", hash_original_field = "023ACC87E27D21D201DC783D8353E8AD", hash_generated_field = "BD40E8C59E7AC3257D3A47F00953ACF9")

    private RemoteViewsAdapterServiceConnection mServiceConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.566 -0500", hash_original_field = "D88BFDCCD09703FFC789C4E54D6C2B3C", hash_generated_field = "2853390AFCDB24EF7B383440520C8195")

    private WeakReference<RemoteAdapterConnectionCallback> mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.568 -0500", hash_original_field = "248678473A958E83408E9323CAE1B35E", hash_generated_field = "6CEEDA92C0B838E0583FA20FED984233")

    private FixedSizeRemoteViewsCache mCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.570 -0500", hash_original_field = "4AAFA5A49457AFEC148686B8F1B1B736", hash_generated_field = "2CBB88FF54D1CB615E7672C77E0FDC22")

    private boolean mNotifyDataSetChangedAfterOnServiceConnected = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.572 -0500", hash_original_field = "6C6539814C30CB54E70990096B7E94EB", hash_generated_field = "837B6838854A47F3C53086E369CD0530")

    // loaded.
    private RemoteViewsFrameLayoutRefSet mRequestedViews;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.575 -0500", hash_original_field = "B475099F40B00216D4FB8409F5914925", hash_generated_field = "F80515F1CBDC27AC738FAA2D73C57FAC")

    private HandlerThread mWorkerThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.577 -0500", hash_original_field = "CDE5657076443D1F482368B4D67E4492", hash_generated_field = "117A70523E02BF403FE90D6FEB3CF957")

    private Handler mWorkerQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.579 -0500", hash_original_field = "C43DB800FAE0295E33A4B9FFD127DCD1", hash_generated_field = "6EC87008C9BC7C9DBF6022010FD5DC7F")

    private Handler mMainQueue;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.774 -0500", hash_original_method = "812B134D167B9B4075E3C9A16E9536C3", hash_generated_method = "38F4874911220085CBC9E5ED8EAE4FED")
    
public RemoteViewsAdapter(Context context, Intent intent, RemoteAdapterConnectionCallback callback) {
        mContext = context;
        mIntent = intent;
        mAppWidgetId = intent.getIntExtra(RemoteViews.EXTRA_REMOTEADAPTER_APPWIDGET_ID, -1);
        mLayoutInflater = LayoutInflater.from(context);
        if (mIntent == null) {
            throw new IllegalArgumentException("Non-null Intent must be specified.");
        }
        mRequestedViews = new RemoteViewsFrameLayoutRefSet();

        // Strip the previously injected app widget id from service intent
        if (intent.hasExtra(RemoteViews.EXTRA_REMOTEADAPTER_APPWIDGET_ID)) {
            intent.removeExtra(RemoteViews.EXTRA_REMOTEADAPTER_APPWIDGET_ID);
        }

        // Initialize the worker thread
        mWorkerThread = new HandlerThread("RemoteViewsCache-loader");
        mWorkerThread.start();
        mWorkerQueue = new Handler(mWorkerThread.getLooper());
        mMainQueue = new Handler(Looper.myLooper(), this);

        // Initialize the cache and the service connection on startup
        mCache = new FixedSizeRemoteViewsCache(sDefaultCacheSize);
        mCallback = new WeakReference<RemoteAdapterConnectionCallback>(callback);
        mServiceConnection = new RemoteViewsAdapterServiceConnection(this);
        requestBindService();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.777 -0500", hash_original_method = "448EC732CCF4B62AEFADFAF844C3E610", hash_generated_method = "B9F27E1AE2C5E521B4D92AFA06DE56D7")
    
@Override
    protected void finalize() throws Throwable {
        try {
            if (mWorkerThread != null) {
                mWorkerThread.quit();
            }
        } finally {
            super.finalize();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.784 -0500", hash_original_method = "34DA0EC600A8592A38E8BB75F944416C", hash_generated_method = "52BF1AD069255F109AED9B1C2ACF231B")
    
private void loadNextIndexInBackground() {
        mWorkerQueue.post(new Runnable() {
            @Override
            public void run() {
                if (mServiceConnection.isConnected()) {
                    // Get the next index to load
                    int position = -1;
                    boolean isRequested = false;
                    synchronized (mCache) {
                        int[] res = mCache.getNextIndexToLoad();
                        position = res[0];
                        isRequested = res[1] > 0;
                    }
                    if (position > -1) {
                        // Load the item, and notify any existing RemoteViewsFrameLayouts
                        updateRemoteViews(position, isRequested);

                        // Queue up for the next one to load
                        loadNextIndexInBackground();
                    } else {
                        // No more items to load, so queue unbind
                        enqueueDeferredUnbindServiceMessage();
                    }
                }
            }
        });
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.789 -0500", hash_original_method = "E1B2571B376275F4805513EEE2D5A305", hash_generated_method = "9D39499690B802221A61BAD23E04C794")
    
private void processException(String method, Exception e) {
        Log.e("RemoteViewsAdapter", "Error in " + method + ": " + e.getMessage());

        // If we encounter a crash when updating, we should reset the metadata & cache and trigger
        // a notifyDataSetChanged to update the widget accordingly
        final RemoteViewsMetaData metaData = mCache.getMetaData();
        synchronized (metaData) {
            metaData.reset();
        }
        synchronized (mCache) {
            mCache.reset();
        }
        mMainQueue.post(new Runnable() {
            @Override
            public void run() {
                superNotifyDataSetChanged();
            }
        });
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.792 -0500", hash_original_method = "49F084C42EF1DBBC4522A49655FF79A1", hash_generated_method = "812225256F26E08DFEE92718825B2DBB")
    
private void updateTemporaryMetaData() {
        IRemoteViewsFactory factory = mServiceConnection.getRemoteViewsFactory();

        try {
            // get the properties/first view (so that we can use it to
            // measure our dummy views)
            boolean hasStableIds = factory.hasStableIds();
            int viewTypeCount = factory.getViewTypeCount();
            int count = factory.getCount();
            RemoteViews loadingView = factory.getLoadingView();
            RemoteViews firstView = null;
            if ((count > 0) && (loadingView == null)) {
                firstView = factory.getViewAt(0);
            }
            final RemoteViewsMetaData tmpMetaData = mCache.getTemporaryMetaData();
            synchronized (tmpMetaData) {
                tmpMetaData.hasStableIds = hasStableIds;
                // We +1 because the base view type is the loading view
                tmpMetaData.viewTypeCount = viewTypeCount + 1;
                tmpMetaData.count = count;
                tmpMetaData.setLoadingViewTemplates(loadingView, firstView);
            }
        } catch(RemoteException e) {
            processException("updateMetaData", e);
        } catch(RuntimeException e) {
            processException("updateMetaData", e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.798 -0500", hash_original_method = "5FA96F3EFCF6BBECAF668E31FDA609B8", hash_generated_method = "5722455ECC2761004F2D7A3C6E3DCFA6")
    
private void updateRemoteViews(final int position, boolean isRequested) {
        if (!mServiceConnection.isConnected()) return;
        IRemoteViewsFactory factory = mServiceConnection.getRemoteViewsFactory();

        // Load the item information from the remote service
        RemoteViews remoteViews = null;
        long itemId = 0;
        try {
            remoteViews = factory.getViewAt(position);
            itemId = factory.getItemId(position);
        } catch (RemoteException e) {
            Log.e(TAG, "Error in updateRemoteViews(" + position + "): " + e.getMessage());

            // Return early to prevent additional work in re-centering the view cache, and
            // swapping from the loading view
            return;
        } catch (RuntimeException e) {
            Log.e(TAG, "Error in updateRemoteViews(" + position + "): " + e.getMessage());
            return;
        }

        if (remoteViews == null) {
            // If a null view was returned, we break early to prevent it from getting
            // into our cache and causing problems later. The effect is that the child  at this
            // position will remain as a loading view until it is updated.
            Log.e(TAG, "Error in updateRemoteViews(" + position + "): " + " null RemoteViews " +
                    "returned from RemoteViewsFactory.");
            return;
        }
        synchronized (mCache) {
            // Cache the RemoteViews we loaded
            mCache.insert(position, remoteViews, itemId, isRequested);

            // Notify all the views that we have previously returned for this index that
            // there is new data for it.
            final RemoteViews rv = remoteViews;
            final int typeId = mCache.getMetaDataAt(position).typeId;
            mMainQueue.post(new Runnable() {
                @Override
                public void run() {
                    mRequestedViews.notifyOnRemoteViewsLoaded(position, rv, typeId);
                }
            });
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.800 -0500", hash_original_method = "F998EBA4725E32A416A597964901E5AB", hash_generated_method = "63A7599C2C6C6EC6808F0DCE287B9FFC")
    
public Intent getRemoteViewsServiceIntent() {
        return mIntent;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.802 -0500", hash_original_method = "BD4FA508848CEC346AF576100841FA5B", hash_generated_method = "7B01FFC912B8670E72D0F21E92BF70CA")
    
public int getCount() {
        final RemoteViewsMetaData metaData = mCache.getMetaData();
        synchronized (metaData) {
            return metaData.count;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.804 -0500", hash_original_method = "AE0D3BF5CEF608E0D2B9C47624E8B8EC", hash_generated_method = "E569AB7B5B0CDAA6E5C890C7128913B7")
    
public Object getItem(int position) {
        // Disallow arbitrary object to be associated with an item for the time being
        return null;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.806 -0500", hash_original_method = "03B3187C996D144F3BCFDF9DFF16615D", hash_generated_method = "B4206B0E296ADAA37479C22D619BA053")
    
public long getItemId(int position) {
        synchronized (mCache) {
            if (mCache.containsMetaDataAt(position)) {
                return mCache.getMetaDataAt(position).itemId;
            }
            return 0;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.808 -0500", hash_original_method = "BDCE0C462966DEB126F7FB99CEF6A82A", hash_generated_method = "7FB499C9BFF1F83EAFC225BD8BE8672A")
    
public int getItemViewType(int position) {
        int typeId = 0;
        synchronized (mCache) {
            if (mCache.containsMetaDataAt(position)) {
                typeId = mCache.getMetaDataAt(position).typeId;
            } else {
                return 0;
            }
        }

        final RemoteViewsMetaData metaData = mCache.getMetaData();
        synchronized (metaData) {
            return metaData.getMappedViewType(typeId);
        }
    }

    /**
     * Returns the item type id for the specified convert view.  Returns -1 if the convert view
     * is invalid.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.811 -0500", hash_original_method = "A43180B0154FDAA6CD8755A8245F56F8", hash_generated_method = "7B777983BAE848A12E9BA05A56262790")
    
private int getConvertViewTypeId(View convertView) {
        int typeId = -1;
        if (convertView != null) {
            Object tag = convertView.getTag(com.android.internal.R.id.rowTypeId);
            if (tag != null) {
                typeId = (Integer) tag;
            }
        }
        return typeId;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.815 -0500", hash_original_method = "6C789CA1A76BB0C76EA62E1C57E6DD64", hash_generated_method = "009CF9883B23FFD201E9ADDF0D31D177")
    
public View getView(int position, View convertView, ViewGroup parent) {
        // "Request" an index so that we can queue it for loading, initiate subsequent
        // preloading, etc.
        synchronized (mCache) {
            boolean isInCache = mCache.containsRemoteViewAt(position);
            boolean isConnected = mServiceConnection.isConnected();
            boolean hasNewItems = false;

            if (!isInCache && !isConnected) {
                // Requesting bind service will trigger a super.notifyDataSetChanged(), which will
                // in turn trigger another request to getView()
                requestBindService();
            } else {
                // Queue up other indices to be preloaded based on this position
                hasNewItems = mCache.queuePositionsToBePreloadedFromRequestedPosition(position);
            }

            if (isInCache) {
                View convertViewChild = null;
                int convertViewTypeId = 0;
                RemoteViewsFrameLayout layout = null;

                if (convertView instanceof RemoteViewsFrameLayout) {
                    layout = (RemoteViewsFrameLayout) convertView;
                    convertViewChild = layout.getChildAt(0);
                    convertViewTypeId = getConvertViewTypeId(convertViewChild);
                }

                // Second, we try and retrieve the RemoteViews from the cache, returning a loading
                // view and queueing it to be loaded if it has not already been loaded.
                Context context = parent.getContext();
                RemoteViews rv = mCache.getRemoteViewsAt(position);
                RemoteViewsIndexMetaData indexMetaData = mCache.getMetaDataAt(position);
                indexMetaData.isRequested = true;
                int typeId = indexMetaData.typeId;

                try {
                    // Reuse the convert view where possible
                    if (layout != null) {
                        if (convertViewTypeId == typeId) {
                            rv.reapply(context, convertViewChild);
                            return layout;
                        }
                        layout.removeAllViews();
                    } else {
                        layout = new RemoteViewsFrameLayout(context);
                    }

                    // Otherwise, create a new view to be returned
                    View newView = rv.apply(context, parent);
                    newView.setTagInternal(com.android.internal.R.id.rowTypeId,
                            new Integer(typeId));
                    layout.addView(newView);
                    return layout;

                } catch (Exception e){
                    // We have to make sure that we successfully inflated the RemoteViews, if not
                    // we return the loading view instead.
                    Log.w(TAG, "Error inflating RemoteViews at position: " + position + ", using" +
                            "loading view instead" + e);

                    RemoteViewsFrameLayout loadingView = null;
                    final RemoteViewsMetaData metaData = mCache.getMetaData();
                    synchronized (metaData) {
                        loadingView = metaData.createLoadingView(position, convertView, parent);
                    }
                    return loadingView;
                } finally {
                    if (hasNewItems) loadNextIndexInBackground();
                }
            } else {
                // If the cache does not have the RemoteViews at this position, then create a
                // loading view and queue the actual position to be loaded in the background
                RemoteViewsFrameLayout loadingView = null;
                final RemoteViewsMetaData metaData = mCache.getMetaData();
                synchronized (metaData) {
                    loadingView = metaData.createLoadingView(position, convertView, parent);
                }

                mRequestedViews.add(position, loadingView);
                mCache.queueRequestedPositionToLoad(position);
                loadNextIndexInBackground();

                return loadingView;
            }
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.818 -0500", hash_original_method = "E20153FA245BC3D829E7670B1CF87BF9", hash_generated_method = "0750C7960BBCEDC584AD0B79AE91AB8D")
    
public int getViewTypeCount() {
        final RemoteViewsMetaData metaData = mCache.getMetaData();
        synchronized (metaData) {
            return metaData.viewTypeCount;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.820 -0500", hash_original_method = "30FBD60CD0291FCC8DBBE0ACB800AAAA", hash_generated_method = "F47140C23AB1A19D5E828B9AB67576C0")
    
public boolean hasStableIds() {
        final RemoteViewsMetaData metaData = mCache.getMetaData();
        synchronized (metaData) {
            return metaData.hasStableIds;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.822 -0500", hash_original_method = "53D7DB97161C41CC976317DC7E27F456", hash_generated_method = "B5A996F6CAD1AF368697CFFC7FD81B30")
    
public boolean isEmpty() {
        return getCount() <= 0;
    }
    
    private static class RemoteViewsAdapterServiceConnection extends IRemoteViewsAdapterConnection.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.585 -0500", hash_original_field = "C55D9286978463BA48249377B65E8F9B", hash_generated_field = "76A19B81A43EEDF4AF3BF911EC3960E9")

        private boolean mIsConnected;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.587 -0500", hash_original_field = "B1C4D25B960993B66CA45F64EFEA50D7", hash_generated_field = "71FF1B688CE6E1B60B73B36B2E842EB8")

        private boolean mIsConnecting;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.589 -0500", hash_original_field = "7324E8FF3E08E74010F50AC6950C96C0", hash_generated_field = "DF300972716819DE62AFA33FE9FFC280")

        private WeakReference<RemoteViewsAdapter> mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.592 -0500", hash_original_field = "A2863C59EF9B73463F69F1583FA8F47C", hash_generated_field = "722330FA05DFEF3176A8163BFC4DC620")

        private IRemoteViewsFactory mRemoteViewsFactory;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.594 -0500", hash_original_method = "7E10295116D6DF0B2080F7EEB3B8FF2F", hash_generated_method = "63ACE39DF33A26BD07B21CC6BD1E235C")
        
public RemoteViewsAdapterServiceConnection(RemoteViewsAdapter adapter) {
            mAdapter = new WeakReference<RemoteViewsAdapter>(adapter);
        }

        @DSSink({DSSinkKind.LOG})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.597 -0500", hash_original_method = "8522D247C3B96C2C6A0E0A6DFCD61958", hash_generated_method = "903EDC1D988BB3540A404E98688F0AF3")
        
public synchronized void bind(Context context, int appWidgetId, Intent intent) {
            if (!mIsConnecting) {
                try {
                    final AppWidgetManager mgr = AppWidgetManager.getInstance(context);
                    mgr.bindRemoteViewsService(appWidgetId, intent, asBinder());
                    mIsConnecting = true;
                } catch (Exception e) {
                    Log.e("RemoteViewsAdapterServiceConnection", "bind(): " + e.getMessage());
                    mIsConnecting = false;
                    mIsConnected = false;
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.599 -0500", hash_original_method = "21A72C8FC580D8D0E809A3FEE2FDD93D", hash_generated_method = "15C8B74CC50AE017D955C5AE8717B708")
        
public synchronized void unbind(Context context, int appWidgetId, Intent intent) {
            try {
                final AppWidgetManager mgr = AppWidgetManager.getInstance(context);
                mgr.unbindRemoteViewsService(appWidgetId, intent);
                mIsConnecting = false;
            } catch (Exception e) {
                Log.e("RemoteViewsAdapterServiceConnection", "unbind(): " + e.getMessage());
                mIsConnecting = false;
                mIsConnected = false;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.611 -0500", hash_original_method = "08CA49D02360F6C2A6BB2EFEF11F092E", hash_generated_method = "50C387288B482527C86D1940B00CF7B3")
        
public synchronized void onServiceConnected(IBinder service) {
            mRemoteViewsFactory = IRemoteViewsFactory.Stub.asInterface(service);

            // Remove any deferred unbind messages
            final RemoteViewsAdapter adapter = mAdapter.get();
            if (adapter == null) return;

            // Queue up work that we need to do for the callback to run
            adapter.mWorkerQueue.post(new Runnable() {
                @Override
                public void run() {
                    if (adapter.mNotifyDataSetChangedAfterOnServiceConnected) {
                        // Handle queued notifyDataSetChanged() if necessary
                        adapter.onNotifyDataSetChanged();
                    } else {
                        IRemoteViewsFactory factory =
                            adapter.mServiceConnection.getRemoteViewsFactory();
                        try {
                            if (!factory.isCreated()) {
                                // We only call onDataSetChanged() if this is the factory was just
                                // create in response to this bind
                                factory.onDataSetChanged();
                            }
                        } catch (RemoteException e) {
                            Log.e(TAG, "Error notifying factory of data set changed in " +
                                        "onServiceConnected(): " + e.getMessage());

                            // Return early to prevent anything further from being notified
                            // (effectively nothing has changed)
                            return;
                        } catch (RuntimeException e) {
                            Log.e(TAG, "Error notifying factory of data set changed in " +
                                    "onServiceConnected(): " + e.getMessage());
                        }

                        // Request meta data so that we have up to date data when calling back to
                        // the remote adapter callback
                        adapter.updateTemporaryMetaData();

                        // Notify the host that we've connected
                        adapter.mMainQueue.post(new Runnable() {
                            @Override
                            public void run() {
                                synchronized (adapter.mCache) {
                                    adapter.mCache.commitTemporaryMetaData();
                                }

                                final RemoteAdapterConnectionCallback callback =
                                    adapter.mCallback.get();
                                if (callback != null) {
                                    callback.onRemoteAdapterConnected();
                                }
                            }
                        });
                    }

                    // Enqueue unbind message
                    adapter.enqueueDeferredUnbindServiceMessage();
                    mIsConnected = true;
                    mIsConnecting = false;
                }
            });
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.618 -0500", hash_original_method = "6AD1D56D3A677AEA97BA981AA56DEDEB", hash_generated_method = "8A712F85DBF05F2D52E487B413F65A65")
        
public synchronized void onServiceDisconnected() {
            mIsConnected = false;
            mIsConnecting = false;
            mRemoteViewsFactory = null;

            // Clear the main/worker queues
            final RemoteViewsAdapter adapter = mAdapter.get();
            if (adapter == null) return;
            
            adapter.mMainQueue.post(new Runnable() {
                @Override
                public void run() {
                    // Dequeue any unbind messages
                    adapter.mMainQueue.removeMessages(sUnbindServiceMessageType);

                    final RemoteAdapterConnectionCallback callback = adapter.mCallback.get();
                    if (callback != null) {
                        callback.onRemoteAdapterDisconnected();
                    }
                }
            });
        }

        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.620 -0500", hash_original_method = "9AC2F72588B70E9E489A1C9892FF58B7", hash_generated_method = "6CC4DC1940AB4F29E9DB83F0CF535A7A")
        
public synchronized IRemoteViewsFactory getRemoteViewsFactory() {
            return mRemoteViewsFactory;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.622 -0500", hash_original_method = "EB76BB3DACEAD8AEFFF382088AE69C8F", hash_generated_method = "D1E25F2EE4FE0ADF70F1001CBF707D7F")
        
public synchronized boolean isConnected() {
            return mIsConnected;
        }
        
    }
    
    private class RemoteViewsFrameLayout extends FrameLayout {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.629 -0500", hash_original_method = "15F65CD5E3BE0169B47C7BF19C42CB6A", hash_generated_method = "ABFCA66BFA93CA4D32BE7A9879BA7490")
        
public RemoteViewsFrameLayout(Context context) {
            super(context);
        }

        /**
         * Updates this RemoteViewsFrameLayout depending on the view that was loaded.
         * @param view the RemoteViews that was loaded. If null, the RemoteViews was not loaded
         *             successfully.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.631 -0500", hash_original_method = "376943697B2A7028E475228F1F5698F0", hash_generated_method = "35E5339EE92626508EDEFE4F38B7E137")
        
public void onRemoteViewsLoaded(RemoteViews view) {
            try {
                // Remove all the children of this layout first
                removeAllViews();
                addView(view.apply(getContext(), this));
            } catch (Exception e) {
                Log.e(TAG, "Failed to apply RemoteViews.");
            }
        }
        
    }
    
    private class RemoteViewsFrameLayoutRefSet {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.635 -0500", hash_original_field = "C91012CBE89A7E6646719176F59C71F4", hash_generated_field = "0DDDAE295C285660CD7FE8EBB6DC5F4A")

        private HashMap<Integer, LinkedList<RemoteViewsFrameLayout>> mReferences;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.638 -0500", hash_original_method = "6FF139149B49AE6D730172FAFB07DD3B", hash_generated_method = "6126AD3CBCD4270E009293C103F19F28")
        
public RemoteViewsFrameLayoutRefSet() {
            mReferences = new HashMap<Integer, LinkedList<RemoteViewsFrameLayout>>();
        }

        /**
         * Adds a new reference to a RemoteViewsFrameLayout returned by the adapter.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.640 -0500", hash_original_method = "3F0456D57D98DD5B5AAA7D7D24636D4D", hash_generated_method = "6E043746E6C17D431B58F16530321006")
        
public void add(int position, RemoteViewsFrameLayout layout) {
            final Integer pos = position;
            LinkedList<RemoteViewsFrameLayout> refs;

            // Create the list if necessary
            if (mReferences.containsKey(pos)) {
                refs = mReferences.get(pos);
            } else {
                refs = new LinkedList<RemoteViewsFrameLayout>();
                mReferences.put(pos, refs);
            }

            // Add the references to the list
            refs.add(layout);
        }

        /**
         * Notifies each of the RemoteViewsFrameLayouts associated with a particular position that
         * the associated RemoteViews has loaded.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.643 -0500", hash_original_method = "B75D35E25E548F04E2C73EAA0A8BAD12", hash_generated_method = "1204A5CAFEA36D3FDC7845C22A09D3B8")
        
public void notifyOnRemoteViewsLoaded(int position, RemoteViews view, int typeId) {
            if (view == null) return;

            final Integer pos = position;
            if (mReferences.containsKey(pos)) {
                // Notify all the references for that position of the newly loaded RemoteViews
                final LinkedList<RemoteViewsFrameLayout> refs = mReferences.get(pos);
                for (final RemoteViewsFrameLayout ref : refs) {
                    ref.onRemoteViewsLoaded(view);
                }
                refs.clear();

                // Remove this set from the original mapping
                mReferences.remove(pos);
            }
        }

        /**
         * Removes all references to all RemoteViewsFrameLayouts returned by the adapter.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.645 -0500", hash_original_method = "A232CA036EBBA3D167286637450EBE5D", hash_generated_method = "A03DAEE5639762EE04C66A10A2482FAB")
        
public void clear() {
            // We currently just clear the references, and leave all the previous layouts returned
            // in their default state of the loading view.
            mReferences.clear();
        }
        
    }
    
    private class RemoteViewsMetaData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.649 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "B83BF7ED7F5719DA923E1BC0AC69952B")

        int count;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.652 -0500", hash_original_field = "C1E9C1B6290BF40ADECDA7DF82FAC94D", hash_generated_field = "C1E9C1B6290BF40ADECDA7DF82FAC94D")

        int viewTypeCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.654 -0500", hash_original_field = "004C2D81765875057DD2D513A7A85CEF", hash_generated_field = "004C2D81765875057DD2D513A7A85CEF")

        boolean hasStableIds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.656 -0500", hash_original_field = "9A49302F66DF2887EFAB714BA0B6B15B", hash_generated_field = "183505E227BCC2FCDE88D0BDF0CDABEE")

        // by the user, then we try and load the first view, and use its height as the height for
        // the default loading view.
        RemoteViews mUserLoadingView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.659 -0500", hash_original_field = "39C526A78EF58332F9FAD2AD78897B3C", hash_generated_field = "39C526A78EF58332F9FAD2AD78897B3C")

        RemoteViews mFirstView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.661 -0500", hash_original_field = "32C08FC6170C53D3EDBAD53E03B1BB3B", hash_generated_field = "32C08FC6170C53D3EDBAD53E03B1BB3B")

        int mFirstViewHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.663 -0500", hash_original_field = "3160A9799114A7B3BC4DCB5322439DAD", hash_generated_field = "0D244E4CBA0E96257463501C2DF63318")

        private final HashMap<Integer, Integer> mTypeIdIndexMap = new HashMap<Integer, Integer>();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.666 -0500", hash_original_method = "A4C124A869EBADBA9AE6D60BBB8A7C9F", hash_generated_method = "4B1DDE4E802B42D2FB2A0A1348AF2A7D")
        
public RemoteViewsMetaData() {
            reset();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.668 -0500", hash_original_method = "90BA893E06B3709572F4D6BD4487FB6C", hash_generated_method = "93C8BF06AAFC2DC3B98B73FAB63BB431")
        
public void set(RemoteViewsMetaData d) {
            synchronized (d) {
                count = d.count;
                viewTypeCount = d.viewTypeCount;
                hasStableIds = d.hasStableIds;
                setLoadingViewTemplates(d.mUserLoadingView, d.mFirstView);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.670 -0500", hash_original_method = "AE7C296E4C5BBC73F59980BD54540BF2", hash_generated_method = "FB0D81DBF8FD441761C80C8E7A712815")
        
public void reset() {
            count = 0;

            // by default there is at least one dummy view type
            viewTypeCount = 1;
            hasStableIds = true;
            mUserLoadingView = null;
            mFirstView = null;
            mFirstViewHeight = 0;
            mTypeIdIndexMap.clear();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.673 -0500", hash_original_method = "E784F858D155FE6C94A91B290D47017F", hash_generated_method = "8B2390B810D8A881474CC61D04EBFD8E")
        
public void setLoadingViewTemplates(RemoteViews loadingView, RemoteViews firstView) {
            mUserLoadingView = loadingView;
            if (firstView != null) {
                mFirstView = firstView;
                mFirstViewHeight = -1;
            }
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.675 -0500", hash_original_method = "78DD70270396881EC8B9AE912C927B26", hash_generated_method = "F047133FFE3A7C4D231A02D80EB10DBE")
        
public int getMappedViewType(int typeId) {
            if (mTypeIdIndexMap.containsKey(typeId)) {
                return mTypeIdIndexMap.get(typeId);
            } else {
                // We +1 because the loading view always has view type id of 0
                int incrementalTypeId = mTypeIdIndexMap.size() + 1;
                mTypeIdIndexMap.put(typeId, incrementalTypeId);
                return incrementalTypeId;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.679 -0500", hash_original_method = "6B923D58C715B2F45FA359F8E18C8A1F", hash_generated_method = "52D1FD8917C0E239147B11BBB779D50C")
        
private RemoteViewsFrameLayout createLoadingView(int position, View convertView,
                ViewGroup parent) {
            // Create and return a new FrameLayout, and setup the references for this position
            final Context context = parent.getContext();
            RemoteViewsFrameLayout layout = new RemoteViewsFrameLayout(context);

            // Create a new loading view
            synchronized (mCache) {
                boolean customLoadingViewAvailable = false;

                if (mUserLoadingView != null) {
                    // Try to inflate user-specified loading view
                    try {
                        View loadingView = mUserLoadingView.apply(parent.getContext(), parent);
                        loadingView.setTagInternal(com.android.internal.R.id.rowTypeId,
                                new Integer(0));
                        layout.addView(loadingView);
                        customLoadingViewAvailable = true;
                    } catch (Exception e) {
                        Log.w(TAG, "Error inflating custom loading view, using default loading" +
                                "view instead", e);
                    }
                }
                if (!customLoadingViewAvailable) {
                    // A default loading view
                    // Use the size of the first row as a guide for the size of the loading view
                    if (mFirstViewHeight < 0) {
                        try {
                            View firstView = mFirstView.apply(parent.getContext(), parent);
                            firstView.measure(
                                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
                                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                            mFirstViewHeight = firstView.getMeasuredHeight();
                            mFirstView = null;
                        } catch (Exception e) {
                            float density = mContext.getResources().getDisplayMetrics().density;
                            mFirstViewHeight = (int)
                                    Math.round(sDefaultLoadingViewHeight * density);
                            mFirstView = null;
                            Log.w(TAG, "Error inflating first RemoteViews" + e);
                        }
                    }

                    // Compose the loading view text
                    TextView loadingTextView = (TextView) mLayoutInflater.inflate(
                            com.android.internal.R.layout.remote_views_adapter_default_loading_view,
                            layout, false);
                    loadingTextView.setHeight(mFirstViewHeight);
                    loadingTextView.setTag(new Integer(0));

                    layout.addView(loadingTextView);
                }
            }

            return layout;
        }
        
    }
    
    private class RemoteViewsIndexMetaData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.684 -0500", hash_original_field = "76F76148F5071AE6285A6BC57B0ADE91", hash_generated_field = "76F76148F5071AE6285A6BC57B0ADE91")

        int typeId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.686 -0500", hash_original_field = "90EEB5AA84937AD6A8CE9746B6FECA6A", hash_generated_field = "90EEB5AA84937AD6A8CE9746B6FECA6A")

        long itemId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.688 -0500", hash_original_field = "060C657FCDBB17A3289922E65DB8FCC4", hash_generated_field = "060C657FCDBB17A3289922E65DB8FCC4")

        boolean isRequested;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.691 -0500", hash_original_method = "429CAA99D27E695F91D025FEB15660FB", hash_generated_method = "6B59AE80858F2DAC17F7189B2F89B781")
        
public RemoteViewsIndexMetaData(RemoteViews v, long itemId, boolean requested) {
            set(v, itemId, requested);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.693 -0500", hash_original_method = "6F36A962FFB607392BC2E34875EB4BD4", hash_generated_method = "D5F03CE80CDEAE3EA1E4483B85099D0D")
        
public void set(RemoteViews v, long id, boolean requested) {
            itemId = id;
            if (v != null)
                typeId = v.getLayoutId();
            else
                typeId = 0;
            isRequested = requested;
        }
        
    }
    
    private class FixedSizeRemoteViewsCache {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.699 -0500", hash_original_field = "A29FD7555FE4F655CC762981664D87C7", hash_generated_field = "E4C58D7C8C895509DA92BEC5943A1E34")

        private static final String TAG = "FixedSizeRemoteViewsCache";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.726 -0500", hash_original_field = "E684F2D84FA7DC3EFBA4928F4825DB34", hash_generated_field = "386965B336D6EC3D60AD83613B46FEC6")

        private static final float sMaxCountSlackPercent = 0.75f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.728 -0500", hash_original_field = "AC946B7CB64AAC6EC238372B8F17CC91", hash_generated_field = "FC99CB6D04167C2E00EDD95CD8617B9F")

        private static final int sMaxMemoryLimitInBytes = 2 * 1024 * 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.701 -0500", hash_original_field = "CB6EAF1824445922D3C4B3C8D6AF8ACD", hash_generated_field = "C7BAEA4EAD131C24153F2BC22502F2DA")

        private RemoteViewsMetaData mMetaData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.703 -0500", hash_original_field = "707414B3F585E459734C592448007803", hash_generated_field = "CCFF7299FB9E7ED02A6E6C63B5236D05")

        private RemoteViewsMetaData mTemporaryMetaData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.705 -0500", hash_original_field = "A096563F5114311517347BE29915A458", hash_generated_field = "753EF3328AAB2345C7802747C9A771C7")

        // greater than or equal to the set of RemoteViews.
        // Note: The reason that we keep this separate from the RemoteViews cache below is that this
        // we still need to be able to access the mapping of position to meta data, without keeping
        // the heavy RemoteViews around.  The RemoteViews cache is trimmed to fixed constraints wrt.
        // memory and size, but this metadata cache will retain information until the data at the
        // position is guaranteed as not being necessary any more (usually on notifyDataSetChanged).
        private HashMap<Integer, RemoteViewsIndexMetaData> mIndexMetaData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.708 -0500", hash_original_field = "88D12761108E2F15CE0CC7A77E6617FE", hash_generated_field = "E0C91D878D27D6D2E9FF3423A3E10934")

        // too much memory.
        private HashMap<Integer, RemoteViews> mIndexRemoteViews;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.710 -0500", hash_original_field = "4051004794F0C90B582066D7C17F8830", hash_generated_field = "534B08E02E91774394FCE7D691C682CB")

        private HashSet<Integer> mRequestedIndices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.712 -0500", hash_original_field = "6C493B3E8987B33A1752F091528E3814", hash_generated_field = "4774F75EA833CCE751EB2DD9476C0BEC")

        // farthest items from when we hit the memory limit
        private int mLastRequestedIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.714 -0500", hash_original_field = "927A07156A680B31183596DB1DDFFD05", hash_generated_field = "37517A26D105BB420B63E2FCF94EB57D")

        // determined by the preloading algorithm to be prefetched
        private HashSet<Integer> mLoadIndices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.716 -0500", hash_original_field = "0F9B5B21B778B01BA7DFA2D9D4555E7A", hash_generated_field = "AF3636EC231AD49E7BB961CA0D975BAD")

        private int mPreloadLowerBound;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.719 -0500", hash_original_field = "DED8D432ED8BAD26134C979B677EF822", hash_generated_field = "8874B6DBCCBC94897623594595F133DB")

        private int mPreloadUpperBound;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.721 -0500", hash_original_field = "D7F38B5F52A0797B2EBB6AFB2F40BD92", hash_generated_field = "02B6EFF7CDEE7A5597425152FD641028")

        // the maxCount number of items, or the maxSize memory usage.
        // The maxCountSlack is used to determine if a new position in the cache to be loaded is
        // sufficiently ouside the old set, prompting a shifting of the "window" of items to be
        // preloaded.
        private int mMaxCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.723 -0500", hash_original_field = "57185E26DC6EA5A111016A32E74C2432", hash_generated_field = "802409AF8ABEE98E4B589C02F0E51998")

        private int mMaxCountSlack;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.731 -0500", hash_original_method = "AFDF05837CF8EF03047EB57BF9703B63", hash_generated_method = "70CFD6B82D8F0C3B2490F21A96C2D9C9")
        
public FixedSizeRemoteViewsCache(int maxCacheSize) {
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
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.734 -0500", hash_original_method = "3B60FC97D93DDECF59F968EA9F5DCEA5", hash_generated_method = "D4AF76873ABB20A68E09AF5976D19028")
        
public void insert(int position, RemoteViews v, long itemId, boolean isRequested) {
            // Trim the cache if we go beyond the count
            if (mIndexRemoteViews.size() >= mMaxCount) {
                mIndexRemoteViews.remove(getFarthestPositionFrom(position));
            }

            // Trim the cache if we go beyond the available memory size constraints
            int pruneFromPosition = (mLastRequestedIndex > -1) ? mLastRequestedIndex : position;
            while (getRemoteViewsBitmapMemoryUsage() >= sMaxMemoryLimitInBytes) {
                // Note: This is currently the most naive mechanism for deciding what to prune when
                // we hit the memory limit.  In the future, we may want to calculate which index to
                // remove based on both its position as well as it's current memory usage, as well
                // as whether it was directly requested vs. whether it was preloaded by our caching
                // mechanism.
                mIndexRemoteViews.remove(getFarthestPositionFrom(pruneFromPosition));
            }

            // Update the metadata cache
            if (mIndexMetaData.containsKey(position)) {
                final RemoteViewsIndexMetaData metaData = mIndexMetaData.get(position);
                metaData.set(v, itemId, isRequested);
            } else {
                mIndexMetaData.put(position, new RemoteViewsIndexMetaData(v, itemId, isRequested));
            }
            mIndexRemoteViews.put(position, v);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.736 -0500", hash_original_method = "CE79B98C6EC29820DC37D3CBF74EA749", hash_generated_method = "4F2A0D462DB125E753F5F16C35A28294")
        
public RemoteViewsMetaData getMetaData() {
            return mMetaData;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.739 -0500", hash_original_method = "1D24E06D74C40EECF68D58BAFBBECA77", hash_generated_method = "404CBB9D8422B7929844E505F7719764")
        
public RemoteViewsMetaData getTemporaryMetaData() {
            return mTemporaryMetaData;
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.742 -0500", hash_original_method = "2697DBEF8CDE0991B3151B5A3E03C7EB", hash_generated_method = "6E5C74D857A5A52221A850556029EF50")
        
public RemoteViews getRemoteViewsAt(int position) {
            if (mIndexRemoteViews.containsKey(position)) {
                return mIndexRemoteViews.get(position);
            }
            return null;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.744 -0500", hash_original_method = "1A017214F368969D3B3DFEA7A0D6E60A", hash_generated_method = "AD6B43FD2477AB00BA3BBCC982E30CE2")
        
public RemoteViewsIndexMetaData getMetaDataAt(int position) {
            if (mIndexMetaData.containsKey(position)) {
                return mIndexMetaData.get(position);
            }
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.747 -0500", hash_original_method = "4EDEA047857C8C00C25F35FE7AF06430", hash_generated_method = "9A887955327899B0A06F4F58047B6D68")
        
public void commitTemporaryMetaData() {
            synchronized (mTemporaryMetaData) {
                synchronized (mMetaData) {
                    mMetaData.set(mTemporaryMetaData);
                }
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.749 -0500", hash_original_method = "1379738D9DE8B74BE60C7743F79F9609", hash_generated_method = "0F52340F651BE5B40F8182343FFAF11E")
        
private int getRemoteViewsBitmapMemoryUsage() {
            // Calculate the memory usage of all the RemoteViews bitmaps being cached
            int mem = 0;
            for (Integer i : mIndexRemoteViews.keySet()) {
                final RemoteViews v = mIndexRemoteViews.get(i);
                if (v != null) {
                    mem += v.estimateBitmapMemoryUsage();
                }
            }
            return mem;
        }
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.752 -0500", hash_original_method = "61B11826B25E039221975DE702D21975", hash_generated_method = "CC6A94417222AAA2AF529317CFEE76F8")
        
private int getFarthestPositionFrom(int pos) {
            // Find the index farthest away and remove that
            int maxDist = 0;
            int maxDistIndex = -1;
            int maxDistNonRequested = 0;
            int maxDistIndexNonRequested = -1;
            for (int i : mIndexRemoteViews.keySet()) {
                int dist = Math.abs(i-pos);
                if (dist > maxDistNonRequested && !mIndexMetaData.get(i).isRequested) {
                    // maxDistNonRequested/maxDistIndexNonRequested will store the index of the
                    // farthest non-requested position
                    maxDistIndexNonRequested = i;
                    maxDistNonRequested = dist;
                }
                if (dist > maxDist) {
                    // maxDist/maxDistIndex will store the index of the farthest position
                    // regardless of whether it was directly requested or not
                    maxDistIndex = i;
                    maxDist = dist;
                }
            }
            if (maxDistIndexNonRequested > -1) {
                return maxDistIndexNonRequested;
            }
            return maxDistIndex;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.754 -0500", hash_original_method = "FD296F73133B242F283CE39F258C0B72", hash_generated_method = "0190E2A27D9DC6017F2677BDCE21CE06")
        
public void queueRequestedPositionToLoad(int position) {
            mLastRequestedIndex = position;
            synchronized (mLoadIndices) {
                mRequestedIndices.add(position);
                mLoadIndices.add(position);
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.757 -0500", hash_original_method = "5E1B16EBD16301761756030AADF8738C", hash_generated_method = "5190469BE2278886D2D725196C08086C")
        
public boolean queuePositionsToBePreloadedFromRequestedPosition(int position) {
            // Check if we need to preload any items
            if (mPreloadLowerBound <= position && position <= mPreloadUpperBound) {
                int center = (mPreloadUpperBound + mPreloadLowerBound) / 2;
                if (Math.abs(position - center) < mMaxCountSlack) {
                    return false;
                }
            }

            int count = 0;
            synchronized (mMetaData) {
                count = mMetaData.count;
            }
            synchronized (mLoadIndices) {
                mLoadIndices.clear();

                // Add all the requested indices
                mLoadIndices.addAll(mRequestedIndices);

                // Add all the preload indices
                int halfMaxCount = mMaxCount / 2;
                mPreloadLowerBound = position - halfMaxCount;
                mPreloadUpperBound = position + halfMaxCount;
                int effectiveLowerBound = Math.max(0, mPreloadLowerBound);
                int effectiveUpperBound = Math.min(mPreloadUpperBound, count - 1);
                for (int i = effectiveLowerBound; i <= effectiveUpperBound; ++i) {
                    mLoadIndices.add(i);
                }

                // But remove all the indices that have already been loaded and are cached
                mLoadIndices.removeAll(mIndexRemoteViews.keySet());
            }
            return true;
        }
        /** Returns the next index to load, and whether that index was directly requested or not */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.759 -0500", hash_original_method = "06D7248AE2FAA4148F7714FEE4BB20F2", hash_generated_method = "08145387FB1EA1258391C3CBA995C2E5")
        
public int[] getNextIndexToLoad() {
            // We try and prioritize items that have been requested directly, instead
            // of items that are loaded as a result of the caching mechanism
            synchronized (mLoadIndices) {
                // Prioritize requested indices to be loaded first
                if (!mRequestedIndices.isEmpty()) {
                    Integer i = mRequestedIndices.iterator().next();
                    mRequestedIndices.remove(i);
                    mLoadIndices.remove(i);
                    return new int[]{i.intValue(), 1};
                }

                // Otherwise, preload other indices as necessary
                if (!mLoadIndices.isEmpty()) {
                    Integer i = mLoadIndices.iterator().next();
                    mLoadIndices.remove(i);
                    return new int[]{i.intValue(), 0};
                }

                return new int[]{-1, 0};
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.762 -0500", hash_original_method = "BBBDB78E47117BE8689A9C55BD30A227", hash_generated_method = "8DDD0D93F11C81581E0240ACECB42D8E")
        
public boolean containsRemoteViewAt(int position) {
            return mIndexRemoteViews.containsKey(position);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.764 -0500", hash_original_method = "97177722E4C5BA4D6397E6B225C059F2", hash_generated_method = "7944256EC15756642CBD500144ADC0F4")
        
public boolean containsMetaDataAt(int position) {
            return mIndexMetaData.containsKey(position);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.767 -0500", hash_original_method = "7D514E4141E3BAA67EC2DA2CF01B70A8", hash_generated_method = "63C304C12A7D6C8B19C50D0D887CE3C6")
        
public void reset() {
            // Note: We do not try and reset the meta data, since that information is still used by
            // collection views to validate it's own contents (and will be re-requested if the data
            // is invalidated through the notifyDataSetChanged() flow).

            mPreloadLowerBound = 0;
            mPreloadUpperBound = -1;
            mLastRequestedIndex = -1;
            mIndexRemoteViews.clear();
            mIndexMetaData.clear();
            synchronized (mLoadIndices) {
                mRequestedIndices.clear();
                mLoadIndices.clear();
            }
        }
    }
    
    public interface RemoteAdapterConnectionCallback {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean onRemoteAdapterConnected();

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onRemoteAdapterDisconnected();
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void deferNotifyDataSetChanged();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.828 -0500", hash_original_method = "2DAA079F2CA383CBC7C346F3BCA57054", hash_generated_method = "40BF1DD2C41F1855A16AF209F239C285")
    
private void onNotifyDataSetChanged() {
        // Complete the actual notifyDataSetChanged() call initiated earlier
        IRemoteViewsFactory factory = mServiceConnection.getRemoteViewsFactory();
        try {
            factory.onDataSetChanged();
        } catch (RemoteException e) {
            Log.e(TAG, "Error in updateNotifyDataSetChanged(): " + e.getMessage());

            // Return early to prevent from further being notified (since nothing has
            // changed)
            return;
        } catch (RuntimeException e) {
            Log.e(TAG, "Error in updateNotifyDataSetChanged(): " + e.getMessage());
            return;
        }

        // Flush the cache so that we can reload new items from the service
        synchronized (mCache) {
            mCache.reset();
        }

        // Re-request the new metadata (only after the notification to the factory)
        updateTemporaryMetaData();

        // Propagate the notification back to the base adapter
        mMainQueue.post(new Runnable() {
            @Override
            public void run() {
                synchronized (mCache) {
                    mCache.commitTemporaryMetaData();
                }

                superNotifyDataSetChanged();
                enqueueDeferredUnbindServiceMessage();
            }
        });

        // Reset the notify flagflag
        mNotifyDataSetChangedAfterOnServiceConnected = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.833 -0500", hash_original_method = "0764FC8C95C069ED9ED094B35DCC527A", hash_generated_method = "4F91F4E720FAE3D08410193811CAC9C6")
    
public void notifyDataSetChanged() {
        // Dequeue any unbind messages
        mMainQueue.removeMessages(sUnbindServiceMessageType);

        // If we are not connected, queue up the notifyDataSetChanged to be handled when we do
        // connect
        if (!mServiceConnection.isConnected()) {
            if (mNotifyDataSetChangedAfterOnServiceConnected) {
                return;
            }

            mNotifyDataSetChangedAfterOnServiceConnected = true;
            requestBindService();
            return;
        }

        mWorkerQueue.post(new Runnable() {
            @Override
            public void run() {
                onNotifyDataSetChanged();
            }
        });
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.835 -0500", hash_original_method = "A1EDDF3811A1F9D28CCD28C93269FAD1", hash_generated_method = "A1EDDF3811A1F9D28CCD28C93269FAD1")
    
void superNotifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.838 -0500", hash_original_method = "96758E0B3254F3B4A777FC060A49CC59", hash_generated_method = "5EEBB680A09C38B8B19ECFA468C375E0")
    
@Override
    public boolean handleMessage(Message msg) {
        boolean result = false;
        switch (msg.what) {
        case sUnbindServiceMessageType:
            if (mServiceConnection.isConnected()) {
                mServiceConnection.unbind(mContext, mAppWidgetId, mIntent);
            }
            result = true;
            break;
        default:
            break;
        }
        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.840 -0500", hash_original_method = "D880D88722499DDF7E3D229A00764CBB", hash_generated_method = "DB4A17D1F23846134055B3E2AB23F377")
    
private void enqueueDeferredUnbindServiceMessage() {
        // Remove any existing deferred-unbind messages
        mMainQueue.removeMessages(sUnbindServiceMessageType);
        mMainQueue.sendEmptyMessageDelayed(sUnbindServiceMessageType, sUnbindServiceDelay);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:57.842 -0500", hash_original_method = "FD0BDD14354B6205FD4E5E773D9BDB6D", hash_generated_method = "0C92A40ACFEF5CC4C3A631F85F9C5C83")
    
private boolean requestBindService() {
        // Try binding the service (which will start it if it's not already running)
        if (!mServiceConnection.isConnected()) {
            mServiceConnection.bind(mContext, mAppWidgetId, mIntent);
        }

        // Remove any existing deferred-unbind messages
        mMainQueue.removeMessages(sUnbindServiceMessageType);
        return mServiceConnection.isConnected();
    }
}

