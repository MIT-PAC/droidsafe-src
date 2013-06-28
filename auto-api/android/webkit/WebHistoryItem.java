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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.770 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.770 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "F874AFA927FA7D19042AF93F53067D66")

    private String mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.770 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.770 -0400", hash_original_field = "C71E6F27982C162E3D48504B7CE95EEE", hash_generated_field = "568234C9B8DA241BFA5B09B8101F8B12")

    private String mOriginalUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.770 -0400", hash_original_field = "843363F5F6041C4ECC1A981FC9C66BED", hash_generated_field = "ED6250D5FE089F439BC082416C11D6F7")

    private Bitmap mFavicon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.771 -0400", hash_original_field = "A8A129D70F82763A119B83F5783BAB9E", hash_generated_field = "DEF71B2D6E0B00DC1C613EC0897296E0")

    private byte[] mFlattenedData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.771 -0400", hash_original_field = "568C07881403BF3322A5F7BD1AB2EFD3", hash_generated_field = "3DD445B470098443DADA7643577A0960")

    private String mTouchIconUrlFromLink;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.771 -0400", hash_original_field = "04235B23E6323F331097CF0471E37475", hash_generated_field = "DEAD2F7465DA29651B91611D8095F5BC")

    private String mTouchIconUrlServerDefault;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.771 -0400", hash_original_field = "8E37FAF5E90B13401E459C4529556E95", hash_generated_field = "FE3A371708FBF079BEA1CA06E98D8E05")

    private Object mCustomData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.771 -0400", hash_original_method = "93B50544C985FE4A97DF747EDD3ED058", hash_generated_method = "A9E573D5571C2ADC8605866AB24A3AB8")
    private  WebHistoryItem() {
        {
            mId = sNextId++;
        } //End block
        // ---------- Original Method ----------
        //synchronized (WebHistoryItem.class) {
            //mId = sNextId++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.771 -0400", hash_original_method = "C4EA5DCF4A3C62F4A8277EC33D71D823", hash_generated_method = "80D4FBD7BCCF318DBECFA0E8D303CB4D")
      WebHistoryItem(byte[] data) {
        mUrl = null;
        mFlattenedData = data;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.772 -0400", hash_original_method = "42CAAAC2E67437069EA69BA0A3B8DA56", hash_generated_method = "CC746A132F4814588D4EF034BFF933DB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.772 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "6481B367B62AB0648EDBFFD76AFA6E7D")
    @Deprecated
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2087230751 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2087230751;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.773 -0400", hash_original_method = "13CE30FBE362EA44FDCE282CA01E7BBC", hash_generated_method = "58A0A33BA1AF923A4C1DD0D4A4C4BF7C")
    public String getUrl() {
        String varB4EAC82CA7396A68D541C85D26508E83_1455498106 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1455498106 = mUrl;
        varB4EAC82CA7396A68D541C85D26508E83_1455498106.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1455498106;
        // ---------- Original Method ----------
        //return mUrl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.773 -0400", hash_original_method = "DDE089EE8228BAF5D6A93FF1955EAFD7", hash_generated_method = "C4FFDF6AE43C6BCE3BDDAAECA0F928FD")
    public String getOriginalUrl() {
        String varB4EAC82CA7396A68D541C85D26508E83_564943595 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_564943595 = mOriginalUrl;
        varB4EAC82CA7396A68D541C85D26508E83_564943595.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_564943595;
        // ---------- Original Method ----------
        //return mOriginalUrl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.774 -0400", hash_original_method = "B92C3DBC46CE7C1B39B851F67F02433E", hash_generated_method = "E550F7FA9E629B68C58D4E1565292477")
    public String getTitle() {
        String varB4EAC82CA7396A68D541C85D26508E83_259155355 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_259155355 = mTitle;
        varB4EAC82CA7396A68D541C85D26508E83_259155355.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_259155355;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.774 -0400", hash_original_method = "41724C0C6385C3C7BA168B7F37B3B669", hash_generated_method = "7DB0E7326ACC0BF8E5C18CB55E2F9444")
    public Bitmap getFavicon() {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_880601183 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_880601183 = mFavicon;
        varB4EAC82CA7396A68D541C85D26508E83_880601183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_880601183;
        // ---------- Original Method ----------
        //return mFavicon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.776 -0400", hash_original_method = "886A530589EC671EA3EEBBE4BA956254", hash_generated_method = "E91F5F5E4612B10B162630E3114C7F84")
    public String getTouchIconUrl() {
        String varB4EAC82CA7396A68D541C85D26508E83_2054996733 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1918208130 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1652531451 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_380092502 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_2054996733 = mTouchIconUrlFromLink;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1918208130 = mTouchIconUrlServerDefault;
        } //End block
        try 
        {
            URL url = new URL(mOriginalUrl);
            mTouchIconUrlServerDefault = new URL(url.getProtocol(), url.getHost(), url.getPort(),
                    "/apple-touch-icon.png").toString();
        } //End block
        catch (MalformedURLException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1652531451 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_380092502 = mTouchIconUrlServerDefault;
        String varA7E53CE21691AB073D9660D615818899_598220855; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_598220855 = varB4EAC82CA7396A68D541C85D26508E83_2054996733;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_598220855 = varB4EAC82CA7396A68D541C85D26508E83_1918208130;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_598220855 = varB4EAC82CA7396A68D541C85D26508E83_1652531451;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_598220855 = varB4EAC82CA7396A68D541C85D26508E83_380092502;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_598220855.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_598220855;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.776 -0400", hash_original_method = "910685AC0FAB997B808A2261BF18CB41", hash_generated_method = "3F5F068884472E787AF572DEFBC7C957")
    public Object getCustomData() {
        Object varB4EAC82CA7396A68D541C85D26508E83_388985637 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_388985637 = mCustomData;
        varB4EAC82CA7396A68D541C85D26508E83_388985637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_388985637;
        // ---------- Original Method ----------
        //return mCustomData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.777 -0400", hash_original_method = "C3DB27902C6D683426C80DDC02D99EDF", hash_generated_method = "7B907F8F0821BBEC90CC8C8215767869")
    public void setCustomData(Object data) {
        mCustomData = data;
        // ---------- Original Method ----------
        //mCustomData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.777 -0400", hash_original_method = "151983BF7C4C69CD96BA6E3E58A2C1A8", hash_generated_method = "0494E26BA7F51A745B44375FBAD2A06E")
     void setFavicon(Bitmap icon) {
        mFavicon = icon;
        // ---------- Original Method ----------
        //mFavicon = icon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.777 -0400", hash_original_method = "6AEC6A0521F7371C54A3BE7086F783A3", hash_generated_method = "7B60D731396CB13026BA8562C58C80AD")
     void setTouchIconUrl(String url, boolean precomposed) {
        {
            mTouchIconUrlFromLink = url;
        } //End block
        addTaint(precomposed);
        // ---------- Original Method ----------
        //if (precomposed || mTouchIconUrlFromLink == null) {
            //mTouchIconUrlFromLink = url;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.778 -0400", hash_original_method = "B1D43F529CC26FA65E203DF01CCD077E", hash_generated_method = "D9112CF536296DECB1AE2F451478CA34")
     byte[] getFlattenedData() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_485831031 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_485831031;
        // ---------- Original Method ----------
        //return mFlattenedData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.778 -0400", hash_original_method = "1A13EE8CB67080EC7270F23F0E09F3FC", hash_generated_method = "E100F11559437A44166E6B20336E6E3E")
     void inflate(int nativeFrame) {
        inflate(nativeFrame, mFlattenedData);
        addTaint(nativeFrame);
        // ---------- Original Method ----------
        //inflate(nativeFrame, mFlattenedData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.778 -0400", hash_original_method = "F79252569D56DBC251BCABE120CFDF67", hash_generated_method = "2DACFFB180E619FD8E1BC9B9792568A3")
    protected synchronized WebHistoryItem clone() {
        WebHistoryItem varB4EAC82CA7396A68D541C85D26508E83_1823582554 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1823582554 = new WebHistoryItem(this);
        varB4EAC82CA7396A68D541C85D26508E83_1823582554.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1823582554;
        // ---------- Original Method ----------
        //return new WebHistoryItem(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.778 -0400", hash_original_method = "546433AD896626257E1507E5593DD29B", hash_generated_method = "FEF51972CCD31A428DC3491EB29897E5")
    private void inflate(int nativeFrame, byte[] data) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.779 -0400", hash_original_method = "54E9940C94044B5E33255DF6DC9264D1", hash_generated_method = "7A1731F51705F4FE6D7F3BFC2429EDDD")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.779 -0400", hash_original_field = "82F7C4459488095A884A3E8CC8FAA866", hash_generated_field = "28B46CAA21BCA317460A0F4BEDDA0B57")

    private static int sNextId = 0;
}

