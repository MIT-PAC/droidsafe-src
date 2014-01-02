package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;





public class WebHistoryItem implements Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.413 -0500", hash_original_field = "7D9BA8971037273938C6D6A780D8A05D", hash_generated_field = "28B46CAA21BCA317460A0F4BEDDA0B57")

    private static int sNextId = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.415 -0500", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private  int mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.417 -0500", hash_original_field = "16E0C5A3FE98D2D22AD69EC7A123442F", hash_generated_field = "F874AFA927FA7D19042AF93F53067D66")

    private String mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.419 -0500", hash_original_field = "CA88DB4A75B79130313A74537195706C", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.421 -0500", hash_original_field = "9D579EBEEA247F7CBFFCE18F65EEE6DC", hash_generated_field = "568234C9B8DA241BFA5B09B8101F8B12")

    private String mOriginalUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.423 -0500", hash_original_field = "EAA9E82166E8FB5F7572389B5C281776", hash_generated_field = "ED6250D5FE089F439BC082416C11D6F7")

    private Bitmap mFavicon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.425 -0500", hash_original_field = "FC6D9B4D06D76304DF7303F436FF9020", hash_generated_field = "DEF71B2D6E0B00DC1C613EC0897296E0")

    private byte[] mFlattenedData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.427 -0500", hash_original_field = "CE7BE8CCE8A2BA0A040338FC0279B2C9", hash_generated_field = "E8913BB914503AF87351933649AD3A85")

    // as obtained from a <link> element in the page.
    private String mTouchIconUrlFromLink;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.430 -0500", hash_original_field = "1771D5CCAA7261846016F7C46F511C66", hash_generated_field = "E4D3AAA425C5F1EA00BD2DCBF6C18E76")

    // apple-touch-icon.
    private String mTouchIconUrlServerDefault;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.432 -0500", hash_original_field = "4B44181EB868194E43F4AE8923F6F581", hash_generated_field = "FE3A371708FBF079BEA1CA06E98D8E05")

    private Object mCustomData;

    /**
     * Basic constructor that assigns a unique id to the item. Called by JNI
     * only.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.434 -0500", hash_original_method = "93B50544C985FE4A97DF747EDD3ED058", hash_generated_method = "610E7FDFD7F804EC3D2C981A4F6D5277")
    
private WebHistoryItem() {
        synchronized (WebHistoryItem.class) {
            mId = sNextId++;
        }
    }

    /**
     * Construct a new WebHistoryItem with initial flattened data.
     * @param data The pre-flattened data coming from restoreState.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.437 -0500", hash_original_method = "C4EA5DCF4A3C62F4A8277EC33D71D823", hash_generated_method = "881CA721F8739CA30DE597C7F8A1024A")
    
WebHistoryItem(byte[] data) {
        mUrl = null; // This will be updated natively
        mFlattenedData = data;
        synchronized (WebHistoryItem.class) {
            mId = sNextId++;
        }
    }

    /**
     * Construct a clone of a WebHistoryItem from the given item.
     * @param item The history item to clone.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.439 -0500", hash_original_method = "42CAAAC2E67437069EA69BA0A3B8DA56", hash_generated_method = "76E424DC49D42A2D893E882C0F5ED6C6")
    
private WebHistoryItem(WebHistoryItem item) {
        mUrl = item.mUrl;
        mTitle = item.mTitle;
        mFlattenedData = item.mFlattenedData;
        mFavicon = item.mFavicon;
        mId = item.mId;
}

    /**
     * Return an identifier for this history item. If an item is a copy of
     * another item, the identifiers will be the same even if they are not the
     * same object.
     * @return The id for this item.
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.441 -0500", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "A076F4C3B25084C6852596EF6A184811")
    
@Deprecated
    public int getId() {
        return mId;
    }

    /**
     * Return the url of this history item. The url is the base url of this
     * history item. See getTargetUrl() for the url that is the actual target of
     * this history item.
     * @return The base url of this history item.
     * Note: The VM ensures 32-bit atomic read/write operations so we don't have
     * to synchronize this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.444 -0500", hash_original_method = "13CE30FBE362EA44FDCE282CA01E7BBC", hash_generated_method = "B64A7CF604F22C84E5CFF07E83B9389F")
    
public String getUrl() {
        return mUrl;
    }

    /**
     * Return the original url of this history item. This was the requested
     * url, the final url may be different as there might have been 
     * redirects while loading the site.
     * @return The original url of this history item.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.446 -0500", hash_original_method = "DDE089EE8228BAF5D6A93FF1955EAFD7", hash_generated_method = "3D97A37CD60FAA89B245FDA02B14AE2C")
    
public String getOriginalUrl() {
        return mOriginalUrl;
    }
    
    /**
     * Return the document title of this history item.
     * @return The document title of this history item.
     * Note: The VM ensures 32-bit atomic read/write operations so we don't have
     * to synchronize this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.448 -0500", hash_original_method = "B92C3DBC46CE7C1B39B851F67F02433E", hash_generated_method = "7A49241FF95B67AE902DCB5B5FAF0F39")
    
public String getTitle() {
        return mTitle;
    }

    /**
     * Return the favicon of this history item or null if no favicon was found.
     * @return A Bitmap containing the favicon for this history item or null.
     * Note: The VM ensures 32-bit atomic read/write operations so we don't have
     * to synchronize this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.450 -0500", hash_original_method = "41724C0C6385C3C7BA168B7F37B3B669", hash_generated_method = "B59DA24A0FBB414B4F54FF834260230B")
    
public Bitmap getFavicon() {
        return mFavicon;
    }

    /**
     * Return the touch icon url.
     * If no touch icon <link> tag was specified, returns
     * <host>/apple-touch-icon.png. The DownloadTouchIcon class that
     * attempts to retrieve the touch icon will handle the case where
     * that file does not exist. An icon set by a <link> tag is always
     * used in preference to an icon saved on the server.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.452 -0500", hash_original_method = "886A530589EC671EA3EEBBE4BA956254", hash_generated_method = "3189802A28A45E4273901E9AB3E26557")
    
public String getTouchIconUrl() {
        if (mTouchIconUrlFromLink != null) {
            return mTouchIconUrlFromLink;
        } else if (mTouchIconUrlServerDefault != null) {
            return mTouchIconUrlServerDefault;
        }

        try {
            URL url = new URL(mOriginalUrl);
            mTouchIconUrlServerDefault = new URL(url.getProtocol(), url.getHost(), url.getPort(),
                    "/apple-touch-icon.png").toString();
        } catch (MalformedURLException e) {
            return null;
        }
        return mTouchIconUrlServerDefault;
    }

    /**
     * Return the custom data provided by the client.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.455 -0500", hash_original_method = "910685AC0FAB997B808A2261BF18CB41", hash_generated_method = "6336A9FB4CF4940FB553CA4BC4716D5A")
    
public Object getCustomData() {
        return mCustomData;
    }

    /**
     * Set the custom data field.
     * @param data An Object containing any data the client wishes to associate
     *             with the item.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.457 -0500", hash_original_method = "C3DB27902C6D683426C80DDC02D99EDF", hash_generated_method = "92A334A34E14B5942CF77160727656EE")
    
public void setCustomData(Object data) {
        // NOTE: WebHistoryItems are used in multiple threads. However, the
        // public facing apis are all getters with the exception of this one
        // api. Since this api is exclusive to clients, we don't make any
        // promises about thread safety.
        mCustomData = data;
    }

    /**
     * Set the favicon.
     * @param icon A Bitmap containing the favicon for this history item.
     * Note: The VM ensures 32-bit atomic read/write operations so we don't have
     * to synchronize this method.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.459 -0500", hash_original_method = "151983BF7C4C69CD96BA6E3E58A2C1A8", hash_generated_method = "151983BF7C4C69CD96BA6E3E58A2C1A8")
    
void setFavicon(Bitmap icon) {
        mFavicon = icon;
    }

    /**
     * Set the touch icon url. Will not overwrite an icon that has been
     * set already from a <link> tag, unless the new icon is precomposed.
     * @hide
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.462 -0500", hash_original_method = "6AEC6A0521F7371C54A3BE7086F783A3", hash_generated_method = "6AEC6A0521F7371C54A3BE7086F783A3")
    
void setTouchIconUrl(String url, boolean precomposed) {
        if (precomposed || mTouchIconUrlFromLink == null) {
            mTouchIconUrlFromLink = url;
        }
    }

    /**
     * Get the pre-flattened data.
     * Note: The VM ensures 32-bit atomic read/write operations so we don't have
     * to synchronize this method.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.464 -0500", hash_original_method = "B1D43F529CC26FA65E203DF01CCD077E", hash_generated_method = "B1D43F529CC26FA65E203DF01CCD077E")
    
byte[] getFlattenedData() {
        return mFlattenedData;
    }

    /**
     * Inflate this item.
     * Note: The VM ensures 32-bit atomic read/write operations so we don't have
     * to synchronize this method.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.466 -0500", hash_original_method = "1A13EE8CB67080EC7270F23F0E09F3FC", hash_generated_method = "1A13EE8CB67080EC7270F23F0E09F3FC")
    
void inflate(int nativeFrame) {
        inflate(nativeFrame, mFlattenedData);
    }

    /**
     * Clone the history item for use by clients of WebView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.468 -0500", hash_original_method = "F79252569D56DBC251BCABE120CFDF67", hash_generated_method = "27F535B0484E36F77F11DB98C117FE82")
    
protected synchronized WebHistoryItem clone() {
        return new WebHistoryItem(this);
    }

    /* Natively inflate this item, this method is called in the WebCore thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.472 -0500", hash_original_method = "546433AD896626257E1507E5593DD29B", hash_generated_method = "4C044559F7AEEF4BC84D17B1D70CC2D7")
    
    private void inflate(int nativeFrame, byte[] data){
    	//Formerly a native method
    	addTaint(nativeFrame);
    	addTaint(data[0]);
    }


    /* Called by jni when the item is updated */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.474 -0500", hash_original_method = "54E9940C94044B5E33255DF6DC9264D1", hash_generated_method = "3AE23423858EC3A5755AC72248F0B78A")
    
private void update(String url, String originalUrl, String title, 
            Bitmap favicon, byte[] data) {
        mUrl = url;
        mOriginalUrl = originalUrl;
        mTitle = title;
        mFavicon = favicon;
        mFlattenedData = data;
    }
}

