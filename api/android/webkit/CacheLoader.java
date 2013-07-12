package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.net.http.Headers;
import android.text.TextUtils;
import android.webkit.JniUtil;

class CacheLoader extends StreamLoader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.093 -0400", hash_original_field = "214CBCF3E2AD0D57BF05ACDE798A8E91", hash_generated_field = "B8E944361CAE1A88801CDDF7F334AC6D")

    CacheManager.CacheResult mCacheResult;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.094 -0400", hash_original_method = "5AF96706DF9FEED69E5A85053239A8E2", hash_generated_method = "FD7F62419736B8FBDC2784E53852262E")
      CacheLoader(LoadListener loadListener, CacheManager.CacheResult result) {
        super(loadListener);
        addTaint(loadListener.getTaint());
        mCacheResult = result;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.095 -0400", hash_original_method = "5DFC3C12C1D0EBA5023FB5F302EE8813", hash_generated_method = "7C48BE2671D31EB501E3868C2F9B3BC8")
    @Override
    protected boolean setupStreamAndSendStatus() {
        mDataStream = mCacheResult.inStream;
        mContentLength = mCacheResult.contentLength;
        mLoadListener.status(1, 1, mCacheResult.httpStatusCode, "OK");
        boolean varB326B5062B2F0E69046810717534CB09_1674725111 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_205510881 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_205510881;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.095 -0400", hash_original_method = "09EA95975DEA7D7D43A5B322B32B5DDD", hash_generated_method = "677AEE8BFB9C056C13BDBB60BA9F7A48")
    @Override
    protected void buildHeaders(Headers headers) {
        addTaint(headers.getTaint());
        StringBuilder sb = new StringBuilder(mCacheResult.mimeType);
    if(!TextUtils.isEmpty(mCacheResult.encoding))        
        {
            sb.append(';');
            sb.append(mCacheResult.encoding);
        } 
        headers.setContentType(sb.toString());
    if(!TextUtils.isEmpty(mCacheResult.location))        
        {
            headers.setLocation(mCacheResult.location);
        } 
    if(!TextUtils.isEmpty(mCacheResult.expiresString))        
        {
            headers.setExpires(mCacheResult.expiresString);
        } 
    if(!TextUtils.isEmpty(mCacheResult.contentdisposition))        
        {
            headers.setContentDisposition(mCacheResult.contentdisposition);
        } 
    if(!TextUtils.isEmpty(mCacheResult.crossDomain))        
        {
            headers.setXPermittedCrossDomainPolicies(mCacheResult.crossDomain);
        } 
        
        
        
            
            
        
        
        
            
        
        
            
        
        
            
        
        
            
        
    }

    
}

