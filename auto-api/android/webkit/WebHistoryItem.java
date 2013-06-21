package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Bitmap;
import java.net.MalformedURLException;
import java.net.URL;

public class WebHistoryItem implements Cloneable {
    private int mId;
    private String mTitle;
    private String mUrl;
    private String mOriginalUrl;
    private Bitmap mFavicon;
    private byte[] mFlattenedData;
    private String mTouchIconUrlFromLink;
    private String mTouchIconUrlServerDefault;
    private Object mCustomData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.986 -0400", hash_original_method = "93B50544C985FE4A97DF747EDD3ED058", hash_generated_method = "A9E573D5571C2ADC8605866AB24A3AB8")
    @DSModeled(DSC.SAFE)
    private WebHistoryItem() {
        {
            mId = sNextId++;
        } //End block
        // ---------- Original Method ----------
        //synchronized (WebHistoryItem.class) {
            //mId = sNextId++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.987 -0400", hash_original_method = "C4EA5DCF4A3C62F4A8277EC33D71D823", hash_generated_method = "412AF2A2D2B1C6B318EB81D30C940D6E")
    @DSModeled(DSC.SAFE)
     WebHistoryItem(byte[] data) {
        dsTaint.addTaint(data[0]);
        mUrl = null;
        {
            mId = sNextId++;
        } //End block
        // ---------- Original Method ----------
        //mUrl = null;
        //mFlattenedData = data;
        //synchronized (WebHistoryItem.class) {
            //mId = sNextId++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.988 -0400", hash_original_method = "42CAAAC2E67437069EA69BA0A3B8DA56", hash_generated_method = "EC83C5E5B5FA6F029B93FAABF1620724")
    @DSModeled(DSC.SAFE)
    private WebHistoryItem(WebHistoryItem item) {
        dsTaint.addTaint(item.dsTaint);
        mUrl = item.mUrl;
        mTitle = item.mTitle;
        mFlattenedData = item.mFlattenedData;
        mFavicon = item.mFavicon;
        mId = item.mId;
        // ---------- Original Method ----------
        //mUrl = item.mUrl;
        //mTitle = item.mTitle;
        //mFlattenedData = item.mFlattenedData;
        //mFavicon = item.mFavicon;
        //mId = item.mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.988 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "1592F8F4CFF95847F0FD5DFC400CED52")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public int getId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.988 -0400", hash_original_method = "13CE30FBE362EA44FDCE282CA01E7BBC", hash_generated_method = "ACFE25042C24F54739138D52C59239EC")
    @DSModeled(DSC.SAFE)
    public String getUrl() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mUrl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.988 -0400", hash_original_method = "DDE089EE8228BAF5D6A93FF1955EAFD7", hash_generated_method = "805F4F3DAC084EEC52619239170A8DD5")
    @DSModeled(DSC.SAFE)
    public String getOriginalUrl() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mOriginalUrl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.988 -0400", hash_original_method = "B92C3DBC46CE7C1B39B851F67F02433E", hash_generated_method = "39B1DE7BC2281AE22034CF83635A8035")
    @DSModeled(DSC.SAFE)
    public String getTitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.988 -0400", hash_original_method = "41724C0C6385C3C7BA168B7F37B3B669", hash_generated_method = "56C66AB3BE8FC5586EE4867B64603746")
    @DSModeled(DSC.SAFE)
    public Bitmap getFavicon() {
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFavicon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.989 -0400", hash_original_method = "886A530589EC671EA3EEBBE4BA956254", hash_generated_method = "34C3EEE723DEFABFE923E9FC4C02C41F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTouchIconUrl() {
        try 
        {
            URL url;
            url = new URL(mOriginalUrl);
            mTouchIconUrlServerDefault = new URL(url.getProtocol(), url.getHost(), url.getPort(),
                    "/apple-touch-icon.png").toString();
        } //End block
        catch (MalformedURLException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mTouchIconUrlFromLink != null) {
            //return mTouchIconUrlFromLink;
        //} else if (mTouchIconUrlServerDefault != null) {
            //return mTouchIconUrlServerDefault;
        //}
        //try {
            //URL url = new URL(mOriginalUrl);
            //mTouchIconUrlServerDefault = new URL(url.getProtocol(), url.getHost(), url.getPort(),
                    //"/apple-touch-icon.png").toString();
        //} catch (MalformedURLException e) {
            //return null;
        //}
        //return mTouchIconUrlServerDefault;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.989 -0400", hash_original_method = "910685AC0FAB997B808A2261BF18CB41", hash_generated_method = "57B9212E61633CBFBB3C65D5055D9A57")
    @DSModeled(DSC.SAFE)
    public Object getCustomData() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCustomData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.989 -0400", hash_original_method = "C3DB27902C6D683426C80DDC02D99EDF", hash_generated_method = "6CE4D570D66AFA4AB4B5CC7FBF537B54")
    @DSModeled(DSC.SAFE)
    public void setCustomData(Object data) {
        dsTaint.addTaint(data.dsTaint);
        // ---------- Original Method ----------
        //mCustomData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.989 -0400", hash_original_method = "151983BF7C4C69CD96BA6E3E58A2C1A8", hash_generated_method = "7D16792D26529B824C807D2C828928F0")
    @DSModeled(DSC.SAFE)
     void setFavicon(Bitmap icon) {
        dsTaint.addTaint(icon.dsTaint);
        // ---------- Original Method ----------
        //mFavicon = icon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.989 -0400", hash_original_method = "6AEC6A0521F7371C54A3BE7086F783A3", hash_generated_method = "FF9733F679B1970787E18DF9BDB3EAB3")
    @DSModeled(DSC.SAFE)
     void setTouchIconUrl(String url, boolean precomposed) {
        dsTaint.addTaint(precomposed);
        dsTaint.addTaint(url);
        // ---------- Original Method ----------
        //if (precomposed || mTouchIconUrlFromLink == null) {
            //mTouchIconUrlFromLink = url;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.990 -0400", hash_original_method = "B1D43F529CC26FA65E203DF01CCD077E", hash_generated_method = "1C8E7F5D216E59C99497F3D6404C2F27")
    @DSModeled(DSC.SAFE)
     byte[] getFlattenedData() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mFlattenedData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.990 -0400", hash_original_method = "1A13EE8CB67080EC7270F23F0E09F3FC", hash_generated_method = "5A90A563A6D020609611529679860340")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void inflate(int nativeFrame) {
        dsTaint.addTaint(nativeFrame);
        inflate(nativeFrame, mFlattenedData);
        // ---------- Original Method ----------
        //inflate(nativeFrame, mFlattenedData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.998 -0400", hash_original_method = "F79252569D56DBC251BCABE120CFDF67", hash_generated_method = "F3B606BEF3C5D4B959C1165945E587CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected synchronized WebHistoryItem clone() {
        WebHistoryItem varCEBBDED003511137E68810BF1CE89032_575104319 = (new WebHistoryItem(this));
        return (WebHistoryItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new WebHistoryItem(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.998 -0400", hash_original_method = "546433AD896626257E1507E5593DD29B", hash_generated_method = "F22227F267AA59E6C170F5C41C4B05A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void inflate(int nativeFrame, byte[] data) {
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(nativeFrame);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.998 -0400", hash_original_method = "54E9940C94044B5E33255DF6DC9264D1", hash_generated_method = "3F041FF33520A9392A13FB76BB0148E3")
    @DSModeled(DSC.SAFE)
    private void update(String url, String originalUrl, String title, 
            Bitmap favicon, byte[] data) {
        dsTaint.addTaint(originalUrl);
        dsTaint.addTaint(title);
        dsTaint.addTaint(favicon.dsTaint);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(url);
        // ---------- Original Method ----------
        //mUrl = url;
        //mOriginalUrl = originalUrl;
        //mTitle = title;
        //mFavicon = favicon;
        //mFlattenedData = data;
    }

    
    private static int sNextId = 0;
}

