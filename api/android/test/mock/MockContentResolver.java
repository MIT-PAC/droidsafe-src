<<<<<<< HEAD
package android.test.mock;

// Droidsafe Imports
import java.util.Map;
=======
/*
 * Copyright (C) 2008 The Android Open Source Project
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

package android.test.mock;
>>>>>>> 8fdd67c83362d24a856c797451a83e8b845ae472

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentProvider;
import android.database.ContentObserver;
import android.net.Uri;

import com.google.android.collect.Maps;

<<<<<<< HEAD
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

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
=======
import java.util.Map;

/**
 * <p>
 *      An extension of {@link android.content.ContentResolver} that is designed for
 *      testing.
 * </p>
 * <p>
 *      MockContentResolver overrides Android's normal way of resolving providers by
 *      authority. To have access to a provider based on its authority, users of
 *      MockContentResolver first instantiate the provider and
 *      use {@link MockContentResolver#addProvider(String, ContentProvider)}. Resolution of an
 *      authority occurs entirely within MockContentResolver.
 * </p>
 * <p>
 *      Users can also set an authority's entry in the map to null, so that a provider is completely
 *      mocked out.
 * </p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about application testing, read the
 * <a href="{@docRoot}guide/topics/testing/index.html">Testing</a> developer guide.</p>
 * </div>
 */

public class MockContentResolver extends ContentResolver {
    Map<String, ContentProvider> mProviders;

    /*
     * Creates a local map of providers. This map is used instead of the global map when an
     * API call tries to acquire a provider.
     */
    public MockContentResolver() {
        super(null);
        mProviders = Maps.newHashMap();
    }

    /**
     * Adds access to a provider based on its authority
     *
     * @param name The authority name associated with the provider.
     * @param provider An instance of {@link android.content.ContentProvider} or one of its
     * subclasses, or null.
     */
    public void addProvider(String name, ContentProvider provider) {

        /*
         * Maps the authority to the provider locally.
         */
        mProviders.put(name, provider);
    }

    /** @hide */
    @Override
    protected IContentProvider acquireProvider(Context context, String name) {
        return acquireExistingProvider(context, name);
    }

    /** @hide */
    @Override
    protected IContentProvider acquireExistingProvider(Context context, String name) {

        /*
         * Gets the content provider from the local map
         */
        final ContentProvider provider = mProviders.get(name);

        if (provider != null) {
            return provider.getIContentProvider();
        } else {
            return null;
        }
    }

    /** @hide */
    @Override
    public boolean releaseProvider(IContentProvider provider) {
        return true;
    }

    /**
     * Overrides {@link android.content.ContentResolver#notifyChange(Uri, ContentObserver, boolean)
     * ContentResolver.notifChange(Uri, ContentObserver, boolean)}. All parameters are ignored.
     * The method hides providers linked to MockContentResolver from other observers in the system.
     *
     * @param uri (Ignored) The uri of the content provider.
     * @param observer (Ignored) The observer that originated the change.
     * @param syncToNetwork (Ignored) If true, attempt to sync the change to the network.
     */
>>>>>>> 8fdd67c83362d24a856c797451a83e8b845ae472
    @Override
    public void notifyChange(Uri uri,
            ContentObserver observer,
            boolean syncToNetwork) {
<<<<<<< HEAD
        addTaint(syncToNetwork);
        addTaint(observer.getTaint());
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
    }

    
}

=======
    }
}
>>>>>>> 8fdd67c83362d24a856c797451a83e8b845ae472
