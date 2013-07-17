package android.test.mock;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentProvider;
import android.database.ContentObserver;
import android.net.Uri;
import com.google.android.collect.Maps;
import java.util.Map;

public class MockContentResolver extends ContentResolver {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.061 -0400", hash_original_field = "696CD650CBB852D5ADE3291A34CE1C11", hash_generated_field = "552B7A966F5AC4BF1D378359AEC135FA")

    Map<String, ContentProvider> mProviders;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.061 -0400", hash_original_method = "A661690524C88F823732CD1198B81C7F", hash_generated_method = "B17FC16E184C8A2EFC35309CB71781FA")
    public  MockContentResolver() {
        super(null);
        mProviders = Maps.newHashMap();
        // ---------- Original Method ----------
        //mProviders = Maps.newHashMap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.062 -0400", hash_original_method = "FA861A4F4A3AD51C69F90915108FDD56", hash_generated_method = "1C271BAC10B2A6E6127CE8B050B9E491")
    public void addProvider(String name, ContentProvider provider) {
        addTaint(provider.getTaint());
        addTaint(name.getTaint());
        mProviders.put(name, provider);
        // ---------- Original Method ----------
        //mProviders.put(name, provider);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.062 -0400", hash_original_method = "50EEEC9C29C7F8C00FF96EAB87299625", hash_generated_method = "747167D46D8785987616C5BA19924439")
    @Override
    protected IContentProvider acquireProvider(Context context, String name) {
        addTaint(name.getTaint());
        addTaint(context.getTaint());
IContentProvider var4587CC2A16EFF281D550F253EE3BECF0_1773954450 =         acquireExistingProvider(context, name);
        var4587CC2A16EFF281D550F253EE3BECF0_1773954450.addTaint(taint);
        return var4587CC2A16EFF281D550F253EE3BECF0_1773954450;
        // ---------- Original Method ----------
        //return acquireExistingProvider(context, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.064 -0400", hash_original_method = "62AC33657D9355178DB566B04AB4A5F7", hash_generated_method = "B47F76378900D7B0070F51958ABD55FB")
    @Override
    protected IContentProvider acquireExistingProvider(Context context, String name) {
        addTaint(name.getTaint());
        addTaint(context.getTaint());
        final ContentProvider provider = mProviders.get(name);
        if(provider != null)        
        {
IContentProvider varEE6B47291026E939B6D336459CD29C3A_1024800219 =             provider.getIContentProvider();
            varEE6B47291026E939B6D336459CD29C3A_1024800219.addTaint(taint);
            return varEE6B47291026E939B6D336459CD29C3A_1024800219;
        } //End block
        else
        {
IContentProvider var540C13E9E156B687226421B24F2DF178_1587267185 =             null;
            var540C13E9E156B687226421B24F2DF178_1587267185.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1587267185;
        } //End block
        // ---------- Original Method ----------
        //final ContentProvider provider = mProviders.get(name);
        //if (provider != null) {
            //return provider.getIContentProvider();
        //} else {
            //return null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.064 -0400", hash_original_method = "2BBC74854CB7DFF372BE1D3A080C6F9A", hash_generated_method = "B4E0DCD0EA6BBD2492C8D3E94AA6C718")
    @Override
    public boolean releaseProvider(IContentProvider provider) {
        addTaint(provider.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1438315975 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1775743944 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1775743944;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.065 -0400", hash_original_method = "0D07CE2954E4C9CEFA50CEA6EA0149DC", hash_generated_method = "86F47FE5568F7BDABA7747D466F67FB7")
    @Override
    public void notifyChange(Uri uri,
            ContentObserver observer,
            boolean syncToNetwork) {
        addTaint(syncToNetwork);
        addTaint(observer.getTaint());
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
    }

    
}

