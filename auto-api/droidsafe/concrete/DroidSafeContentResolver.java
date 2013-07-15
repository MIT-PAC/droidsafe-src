package droidsafe.concrete;

import java.util.Map;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentProvider;
import android.database.ContentObserver;
import android.net.Uri;
import droidsafe.annotations.DSModeled;


public class DroidSafeContentResolver extends ContentResolver {
    Map<String, ContentProvider> mProviders;
    private Context context;
    
    
    @DSModeled
    public DroidSafeContentResolver(Context context) {
    	super(context);
    	this.context = context;
    }

    
    public void addProvider(String name, ContentProvider provider) {

        
        mProviders.put(name, provider);
    }

    
    @Override
    protected IContentProvider acquireProvider(Context context, String name) {
        return acquireExistingProvider(context, name);
    }

    
    @Override
    protected IContentProvider acquireExistingProvider(Context context, String name) {

        
        final ContentProvider provider = mProviders.get(name);

        if (provider != null) {
            return provider.getIContentProvider();
        } else {
            return null;
        }
    }

    
    @Override
    public boolean releaseProvider(IContentProvider provider) {
        return true;
    }

    
    @Override
    public void notifyChange(Uri uri,
            ContentObserver observer,
            boolean syncToNetwork) {
    }
}
