package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.net.http.Headers;
import android.text.TextUtils;



class CacheLoader extends StreamLoader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:22.467 -0500", hash_original_field = "B8E944361CAE1A88801CDDF7F334AC6D", hash_generated_field = "B8E944361CAE1A88801CDDF7F334AC6D")


    CacheManager.CacheResult mCacheResult;  // Content source

    /**
     * Constructs a CacheLoader for use when loading content from the cache.
     *
     * @param loadListener LoadListener to pass the content to
     * @param result CacheResult used as the source for the content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:22.468 -0500", hash_original_method = "5AF96706DF9FEED69E5A85053239A8E2", hash_generated_method = "5AF96706DF9FEED69E5A85053239A8E2")
    CacheLoader(LoadListener loadListener, CacheManager.CacheResult result) {
        super(loadListener);

        assert !JniUtil.useChromiumHttpStack();

        mCacheResult = result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:22.469 -0500", hash_original_method = "5DFC3C12C1D0EBA5023FB5F302EE8813", hash_generated_method = "8155A4832295A69A873F3610F7996631")
    @Override
protected boolean setupStreamAndSendStatus() {
        mDataStream = mCacheResult.inStream;
        mContentLength = mCacheResult.contentLength;
        mLoadListener.status(1, 1, mCacheResult.httpStatusCode, "OK");
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:22.470 -0500", hash_original_method = "09EA95975DEA7D7D43A5B322B32B5DDD", hash_generated_method = "FB0CEC1ED244CF61E2F346A01E142DCD")
    @Override
protected void buildHeaders(Headers headers) {
        StringBuilder sb = new StringBuilder(mCacheResult.mimeType);
        if (!TextUtils.isEmpty(mCacheResult.encoding)) {
            sb.append(';');
            sb.append(mCacheResult.encoding);
        }
        headers.setContentType(sb.toString());

        if (!TextUtils.isEmpty(mCacheResult.location)) {
            headers.setLocation(mCacheResult.location);
        }

        if (!TextUtils.isEmpty(mCacheResult.expiresString)) {
            headers.setExpires(mCacheResult.expiresString);
        }

        if (!TextUtils.isEmpty(mCacheResult.contentdisposition)) {
            headers.setContentDisposition(mCacheResult.contentdisposition);
        }

        if (!TextUtils.isEmpty(mCacheResult.crossDomain)) {
            headers.setXPermittedCrossDomainPolicies(mCacheResult.crossDomain);
        }
    }

    
}

