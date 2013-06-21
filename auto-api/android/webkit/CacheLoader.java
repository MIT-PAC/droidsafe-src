package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.http.Headers;
import android.text.TextUtils;
import android.webkit.JniUtil;

class CacheLoader extends StreamLoader {
    CacheManager.CacheResult mCacheResult;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.742 -0400", hash_original_method = "5AF96706DF9FEED69E5A85053239A8E2", hash_generated_method = "EF5F95C02AA5863DA2CA2272B4EB31BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CacheLoader(LoadListener loadListener, CacheManager.CacheResult result) {
        super(loadListener);
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(loadListener.dsTaint);
        // ---------- Original Method ----------
        //assert !JniUtil.useChromiumHttpStack();
        //mCacheResult = result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.742 -0400", hash_original_method = "5DFC3C12C1D0EBA5023FB5F302EE8813", hash_generated_method = "DA769A2FC642DFFC942D3EEDC864B685")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean setupStreamAndSendStatus() {
        mDataStream = mCacheResult.inStream;
        mContentLength = mCacheResult.contentLength;
        mLoadListener.status(1, 1, mCacheResult.httpStatusCode, "OK");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mDataStream = mCacheResult.inStream;
        //mContentLength = mCacheResult.contentLength;
        //mLoadListener.status(1, 1, mCacheResult.httpStatusCode, "OK");
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.743 -0400", hash_original_method = "09EA95975DEA7D7D43A5B322B32B5DDD", hash_generated_method = "7AD94FE770DEBA190E3FB2B2C769FE77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void buildHeaders(Headers headers) {
        dsTaint.addTaint(headers.dsTaint);
        StringBuilder sb;
        sb = new StringBuilder(mCacheResult.mimeType);
        {
            boolean varAA9DD98176BC7E4C558C312499F0DC87_397757874 = (!TextUtils.isEmpty(mCacheResult.encoding));
            {
                sb.append(';');
                sb.append(mCacheResult.encoding);
            } //End block
        } //End collapsed parenthetic
        headers.setContentType(sb.toString());
        {
            boolean var2AB1B988E1A823180096207E3A1DD69B_954437664 = (!TextUtils.isEmpty(mCacheResult.location));
            {
                headers.setLocation(mCacheResult.location);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5A5B7E55E6141F5C77AA200692ADA201_701598898 = (!TextUtils.isEmpty(mCacheResult.expiresString));
            {
                headers.setExpires(mCacheResult.expiresString);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF419A7BAAB919C8802ABABFFAE8A7582_1612187540 = (!TextUtils.isEmpty(mCacheResult.contentdisposition));
            {
                headers.setContentDisposition(mCacheResult.contentdisposition);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA478B5521C4B854F39D54F90D5ED7D8B_644428074 = (!TextUtils.isEmpty(mCacheResult.crossDomain));
            {
                headers.setXPermittedCrossDomainPolicies(mCacheResult.crossDomain);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(mCacheResult.mimeType);
        //if (!TextUtils.isEmpty(mCacheResult.encoding)) {
            //sb.append(';');
            //sb.append(mCacheResult.encoding);
        //}
        //headers.setContentType(sb.toString());
        //if (!TextUtils.isEmpty(mCacheResult.location)) {
            //headers.setLocation(mCacheResult.location);
        //}
        //if (!TextUtils.isEmpty(mCacheResult.expiresString)) {
            //headers.setExpires(mCacheResult.expiresString);
        //}
        //if (!TextUtils.isEmpty(mCacheResult.contentdisposition)) {
            //headers.setContentDisposition(mCacheResult.contentdisposition);
        //}
        //if (!TextUtils.isEmpty(mCacheResult.crossDomain)) {
            //headers.setXPermittedCrossDomainPolicies(mCacheResult.crossDomain);
        //}
    }

    
}

