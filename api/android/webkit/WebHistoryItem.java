package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import java.net.MalformedURLException;
import java.net.URL;

public class WebHistoryItem implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.369 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.369 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "F874AFA927FA7D19042AF93F53067D66")

    private String mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.369 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.369 -0400", hash_original_field = "C71E6F27982C162E3D48504B7CE95EEE", hash_generated_field = "568234C9B8DA241BFA5B09B8101F8B12")

    private String mOriginalUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.369 -0400", hash_original_field = "843363F5F6041C4ECC1A981FC9C66BED", hash_generated_field = "ED6250D5FE089F439BC082416C11D6F7")

    private Bitmap mFavicon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.369 -0400", hash_original_field = "A8A129D70F82763A119B83F5783BAB9E", hash_generated_field = "DEF71B2D6E0B00DC1C613EC0897296E0")

    private byte[] mFlattenedData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.369 -0400", hash_original_field = "568C07881403BF3322A5F7BD1AB2EFD3", hash_generated_field = "3DD445B470098443DADA7643577A0960")

    private String mTouchIconUrlFromLink;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.369 -0400", hash_original_field = "04235B23E6323F331097CF0471E37475", hash_generated_field = "DEAD2F7465DA29651B91611D8095F5BC")

    private String mTouchIconUrlServerDefault;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.369 -0400", hash_original_field = "8E37FAF5E90B13401E459C4529556E95", hash_generated_field = "FE3A371708FBF079BEA1CA06E98D8E05")

    private Object mCustomData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.369 -0400", hash_original_method = "93B50544C985FE4A97DF747EDD3ED058", hash_generated_method = "F381FDA6D5C42F873D7344B180AD3D99")
    private  WebHistoryItem() {
        synchronized
(WebHistoryItem.class)        {
            mId = sNextId++;
        } //End block
        // ---------- Original Method ----------
        //synchronized (WebHistoryItem.class) {
            //mId = sNextId++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.369 -0400", hash_original_method = "C4EA5DCF4A3C62F4A8277EC33D71D823", hash_generated_method = "D375845D4FF23C8EB6CEFF65E28FD8F2")
      WebHistoryItem(byte[] data) {
        mUrl = null;
        mFlattenedData = data;
        synchronized
(WebHistoryItem.class)        {
            mId = sNextId++;
        } //End block
        // ---------- Original Method ----------
        //mUrl = null;
        //mFlattenedData = data;
        //synchronized (WebHistoryItem.class) {
            //mId = sNextId++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.369 -0400", hash_original_method = "42CAAAC2E67437069EA69BA0A3B8DA56", hash_generated_method = "CC746A132F4814588D4EF034BFF933DB")
    private  WebHistoryItem(WebHistoryItem item) {
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.369 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "2EBFE32C959A6D37BDF0C1EA8BB198B8")
    @Deprecated
    public int getId() {
        int var6AC7F06B6413A1BE9C136DC7DF0D2B60_198061637 = (mId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_67347739 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_67347739;
        // ---------- Original Method ----------
        //return mId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.370 -0400", hash_original_method = "13CE30FBE362EA44FDCE282CA01E7BBC", hash_generated_method = "C63A92AC3436B14EF80D14DD914806A5")
    public String getUrl() {
String varF1E91891753CD7C4305CCDECB60B9DDF_1293316755 =         mUrl;
        varF1E91891753CD7C4305CCDECB60B9DDF_1293316755.addTaint(taint);
        return varF1E91891753CD7C4305CCDECB60B9DDF_1293316755;
        // ---------- Original Method ----------
        //return mUrl;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.370 -0400", hash_original_method = "DDE089EE8228BAF5D6A93FF1955EAFD7", hash_generated_method = "7063B26E39352A73F95E2B5BE3582941")
    public String getOriginalUrl() {
String var4DE70E97E870523D447117920A26D343_863982430 =         mOriginalUrl;
        var4DE70E97E870523D447117920A26D343_863982430.addTaint(taint);
        return var4DE70E97E870523D447117920A26D343_863982430;
        // ---------- Original Method ----------
        //return mOriginalUrl;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.370 -0400", hash_original_method = "B92C3DBC46CE7C1B39B851F67F02433E", hash_generated_method = "28AAAC8DC892835B9A550590C5600AFE")
    public String getTitle() {
String var4FE0D95ADE4B4BDFA36D55D8B62A6C49_2116820360 =         mTitle;
        var4FE0D95ADE4B4BDFA36D55D8B62A6C49_2116820360.addTaint(taint);
        return var4FE0D95ADE4B4BDFA36D55D8B62A6C49_2116820360;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.370 -0400", hash_original_method = "41724C0C6385C3C7BA168B7F37B3B669", hash_generated_method = "80E78CAA97E4814BA166294688C6315C")
    public Bitmap getFavicon() {
Bitmap var462CB6577AAAB158434445CB00AE6AE4_1832563295 =         mFavicon;
        var462CB6577AAAB158434445CB00AE6AE4_1832563295.addTaint(taint);
        return var462CB6577AAAB158434445CB00AE6AE4_1832563295;
        // ---------- Original Method ----------
        //return mFavicon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.370 -0400", hash_original_method = "886A530589EC671EA3EEBBE4BA956254", hash_generated_method = "3845FFAA9EE3960C09A8FCBDB1DBD6DA")
    public String getTouchIconUrl() {
        if(mTouchIconUrlFromLink != null)        
        {
String var58A40E6497D2BD3D410E2CED80CB90DB_803769618 =             mTouchIconUrlFromLink;
            var58A40E6497D2BD3D410E2CED80CB90DB_803769618.addTaint(taint);
            return var58A40E6497D2BD3D410E2CED80CB90DB_803769618;
        } //End block
        else
        if(mTouchIconUrlServerDefault != null)        
        {
String var66730157FF03C8AB569ADE01D2C3C7D1_1738877949 =             mTouchIconUrlServerDefault;
            var66730157FF03C8AB569ADE01D2C3C7D1_1738877949.addTaint(taint);
            return var66730157FF03C8AB569ADE01D2C3C7D1_1738877949;
        } //End block
        try 
        {
            URL url = new URL(mOriginalUrl);
            mTouchIconUrlServerDefault = new URL(url.getProtocol(), url.getHost(), url.getPort(),
                    "/apple-touch-icon.png").toString();
        } //End block
        catch (MalformedURLException e)
        {
String var540C13E9E156B687226421B24F2DF178_522208082 =             null;
            var540C13E9E156B687226421B24F2DF178_522208082.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_522208082;
        } //End block
String var66730157FF03C8AB569ADE01D2C3C7D1_1282134159 =         mTouchIconUrlServerDefault;
        var66730157FF03C8AB569ADE01D2C3C7D1_1282134159.addTaint(taint);
        return var66730157FF03C8AB569ADE01D2C3C7D1_1282134159;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.371 -0400", hash_original_method = "910685AC0FAB997B808A2261BF18CB41", hash_generated_method = "3AF036905CA03C2BA4C18CFBFADFB08C")
    public Object getCustomData() {
Object var59DC1B5337A5DFD5414CD638BE20A387_1813525463 =         mCustomData;
        var59DC1B5337A5DFD5414CD638BE20A387_1813525463.addTaint(taint);
        return var59DC1B5337A5DFD5414CD638BE20A387_1813525463;
        // ---------- Original Method ----------
        //return mCustomData;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.371 -0400", hash_original_method = "C3DB27902C6D683426C80DDC02D99EDF", hash_generated_method = "7B907F8F0821BBEC90CC8C8215767869")
    public void setCustomData(Object data) {
        mCustomData = data;
        // ---------- Original Method ----------
        //mCustomData = data;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.371 -0400", hash_original_method = "151983BF7C4C69CD96BA6E3E58A2C1A8", hash_generated_method = "0494E26BA7F51A745B44375FBAD2A06E")
     void setFavicon(Bitmap icon) {
        mFavicon = icon;
        // ---------- Original Method ----------
        //mFavicon = icon;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.371 -0400", hash_original_method = "6AEC6A0521F7371C54A3BE7086F783A3", hash_generated_method = "8DF9423CFC1034F21AD0595BB8A206BA")
     void setTouchIconUrl(String url, boolean precomposed) {
        addTaint(precomposed);
        if(precomposed || mTouchIconUrlFromLink == null)        
        {
            mTouchIconUrlFromLink = url;
        } //End block
        // ---------- Original Method ----------
        //if (precomposed || mTouchIconUrlFromLink == null) {
            //mTouchIconUrlFromLink = url;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.371 -0400", hash_original_method = "B1D43F529CC26FA65E203DF01CCD077E", hash_generated_method = "84654C97CDDFA8920215096364501C16")
     byte[] getFlattenedData() {
        byte[] varA8A129D70F82763A119B83F5783BAB9E_1861546924 = (mFlattenedData);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1810448717 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1810448717;
        // ---------- Original Method ----------
        //return mFlattenedData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.372 -0400", hash_original_method = "1A13EE8CB67080EC7270F23F0E09F3FC", hash_generated_method = "9EDC702B6E0FCF414E979B134107A9E3")
     void inflate(int nativeFrame) {
        addTaint(nativeFrame);
        inflate(nativeFrame, mFlattenedData);
        // ---------- Original Method ----------
        //inflate(nativeFrame, mFlattenedData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.372 -0400", hash_original_method = "F79252569D56DBC251BCABE120CFDF67", hash_generated_method = "415FCAC0E6431C9AA5C45691347499D4")
    protected synchronized WebHistoryItem clone() {
WebHistoryItem var2497720903CF073BD8C984E52DB0ECAF_1095959950 =         new WebHistoryItem(this);
        var2497720903CF073BD8C984E52DB0ECAF_1095959950.addTaint(taint);
        return var2497720903CF073BD8C984E52DB0ECAF_1095959950;
        // ---------- Original Method ----------
        //return new WebHistoryItem(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.372 -0400", hash_original_method = "546433AD896626257E1507E5593DD29B", hash_generated_method = "FEF51972CCD31A428DC3491EB29897E5")
    private void inflate(int nativeFrame, byte[] data) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.372 -0400", hash_original_method = "54E9940C94044B5E33255DF6DC9264D1", hash_generated_method = "7A1731F51705F4FE6D7F3BFC2429EDDD")
    private void update(String url, String originalUrl, String title, 
            Bitmap favicon, byte[] data) {
        mUrl = url;
        mOriginalUrl = originalUrl;
        mTitle = title;
        mFavicon = favicon;
        mFlattenedData = data;
        // ---------- Original Method ----------
        //mUrl = url;
        //mOriginalUrl = originalUrl;
        //mTitle = title;
        //mFavicon = favicon;
        //mFlattenedData = data;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.372 -0400", hash_original_field = "82F7C4459488095A884A3E8CC8FAA866", hash_generated_field = "28B46CAA21BCA317460A0F4BEDDA0B57")

    private static int sNextId = 0;
}

