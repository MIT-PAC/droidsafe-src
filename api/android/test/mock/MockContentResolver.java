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
//Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentProvider;
import android.database.ContentObserver;
import android.net.Uri;

import com.google.android.collect.Maps;



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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.010 -0500", hash_original_field = "552B7A966F5AC4BF1D378359AEC135FA", hash_generated_field = "552B7A966F5AC4BF1D378359AEC135FA")

    Map<String, ContentProvider> mProviders;

    /*
     * Creates a local map of providers. This map is used instead of the global map when an
     * API call tries to acquire a provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.013 -0500", hash_original_method = "A661690524C88F823732CD1198B81C7F", hash_generated_method = "69AC10086FD726A936B085DBF3B465C6")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.015 -0500", hash_original_method = "FA861A4F4A3AD51C69F90915108FDD56", hash_generated_method = "CF72EC6317D5D2FD71FF445EC7F8AA75")
    
public void addProvider(String name, ContentProvider provider) {

        /*
         * Maps the authority to the provider locally.
         */
        mProviders.put(name, provider);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.017 -0500", hash_original_method = "50EEEC9C29C7F8C00FF96EAB87299625", hash_generated_method = "7501BE01B2A3A50C57DC4C3B75E865E1")
    
@Override
    protected IContentProvider acquireProvider(Context context, String name) {
        return acquireExistingProvider(context, name);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.020 -0500", hash_original_method = "62AC33657D9355178DB566B04AB4A5F7", hash_generated_method = "F2351185E03BC113DE4789A75FEE332B")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.022 -0500", hash_original_method = "2BBC74854CB7DFF372BE1D3A080C6F9A", hash_generated_method = "34799AB26D3B43DCFD030443CD248A4F")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.025 -0500", hash_original_method = "0D07CE2954E4C9CEFA50CEA6EA0149DC", hash_generated_method = "A086E5523CC5A4E1BD40AD6DF29C6B52")
    
@Override
    public void notifyChange(Uri uri,
            ContentObserver observer,
            boolean syncToNetwork) {
    }
}
