package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import static android.util.Patterns.GOOD_IRI_CHAR;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.676 -0400", hash_original_field = "51CA147512905722A26C3D219A583C78", hash_generated_field = "CE8AB436FE82236B0FB9A3B1339DC56F")

    private String mScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.676 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

    private String mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.676 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

    private int mPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.676 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.676 -0400", hash_original_field = "A8B1F7BA82BC1F145F3409F6F8441616", hash_generated_field = "166A9A198632C99EE75D5EEF2F750EAC")

    private String mAuthInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.678 -0400", hash_original_method = "487816E9D6EC142D6B04FB79F32D074F", hash_generated_method = "9F88C7AE3F7DF41230532E056EA63A01")
    public  WebAddress(String address) throws ParseException {
        addTaint(address.getTaint());
        if(address == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1783130439 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1783130439.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1783130439;
        } //End block
        mScheme = "";
        mHost = "";
        mPort = -1;
        mPath = "/";
        mAuthInfo = "";
        Matcher m = sAddressPattern.matcher(address);
        String t;
        if(m.matches())        
        {
            t = m.group(MATCH_GROUP_SCHEME);
            if(t != null)            
            mScheme = t.toLowerCase();
            t = m.group(MATCH_GROUP_AUTHORITY);
            if(t != null)            
            mAuthInfo = t;
            t = m.group(MATCH_GROUP_HOST);
            if(t != null)            
            mHost = t;
            t = m.group(MATCH_GROUP_PORT);
            if(t != null && t.length() > 0)            
            {
                try 
                {
                    mPort = Integer.parseInt(t);
                } //End block
                catch (NumberFormatException ex)
                {
                    ParseException var3BE0FB7EB6435194286D60D2D2780DA3_953709119 = new ParseException("Bad port");
                    var3BE0FB7EB6435194286D60D2D2780DA3_953709119.addTaint(taint);
                    throw var3BE0FB7EB6435194286D60D2D2780DA3_953709119;
                } //End block
            } //End block
            t = m.group(MATCH_GROUP_PATH);
            if(t != null && t.length() > 0)            
            {
                if(t.charAt(0) == '/')                
                {
                    mPath = t;
                } //End block
                else
                {
                    mPath = "/" + t;
                } //End block
            } //End block
        } //End block
        else
        {
            ParseException var87B6381186764976ABD76A65225238B7_781431123 = new ParseException("Bad address");
            var87B6381186764976ABD76A65225238B7_781431123.addTaint(taint);
            throw var87B6381186764976ABD76A65225238B7_781431123;
        } //End block
        if(mPort == 443 && mScheme.equals(""))        
        {
            mScheme = "https";
        } //End block
        else
        if(mPort == -1)        
        {
            if(mScheme.equals("https"))            
            mPort = 443;
            else
            mPort = 80;
        } //End block
        if(mScheme.equals(""))        
        mScheme = "http";
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.678 -0400", hash_original_method = "1D4EF43F2688F01255D5CEBFE17AB398", hash_generated_method = "0FF9D7E37A3F9F648312ADE43AF69DA6")
    @Override
    public String toString() {
        String port = "";
        if((mPort != 443 && mScheme.equals("https")) ||
            (mPort != 80 && mScheme.equals("http")))        
        {
            port = ":" + Integer.toString(mPort);
        } //End block
        String authInfo = "";
        if(mAuthInfo.length() > 0)        
        {
            authInfo = mAuthInfo + "@";
        } //End block
String varD260FE9771F1CDCAFC02A5BB565B207F_664591555 =         mScheme + "://" + authInfo + mHost + port + mPath;
        varD260FE9771F1CDCAFC02A5BB565B207F_664591555.addTaint(taint);
        return varD260FE9771F1CDCAFC02A5BB565B207F_664591555;
        // ---------- Original Method ----------
        //String port = "";
        //if ((mPort != 443 && mScheme.equals("https")) ||
            //(mPort != 80 && mScheme.equals("http"))) {
            //port = ":" + Integer.toString(mPort);
        //}
        //String authInfo = "";
        //if (mAuthInfo.length() > 0) {
            //authInfo = mAuthInfo + "@";
        //}
        //return mScheme + "://" + authInfo + mHost + port + mPath;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.678 -0400", hash_original_method = "67DD4047E44F32E39FC9F9A2588A82A9", hash_generated_method = "9EF399851C0503F706319A3887847965")
    public void setScheme(String scheme) {
        mScheme = scheme;
        // ---------- Original Method ----------
        //mScheme = scheme;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.678 -0400", hash_original_method = "631B0276BE6088C8DB198A5E8698D898", hash_generated_method = "B6220E3A08E5780E36A54357FCD01225")
    public String getScheme() {
String var576940BCD623051B29CEF1E9A8912CDF_1893568404 =         mScheme;
        var576940BCD623051B29CEF1E9A8912CDF_1893568404.addTaint(taint);
        return var576940BCD623051B29CEF1E9A8912CDF_1893568404;
        // ---------- Original Method ----------
        //return mScheme;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.679 -0400", hash_original_method = "5915AC219B5071991752C386758578AC", hash_generated_method = "F8431D59CF529A7CBE808EEE2BEF2AA2")
    public void setHost(String host) {
        mHost = host;
        // ---------- Original Method ----------
        //mHost = host;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.679 -0400", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "A4584DDEAE9B1C5E0782F58F02A4B417")
    public String getHost() {
String varE57614B151242FB69B92E61EEA287D33_1993056510 =         mHost;
        varE57614B151242FB69B92E61EEA287D33_1993056510.addTaint(taint);
        return varE57614B151242FB69B92E61EEA287D33_1993056510;
        // ---------- Original Method ----------
        //return mHost;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.680 -0400", hash_original_method = "0F13114466AF9A53F82890B2842E5497", hash_generated_method = "CECD3BF3EBF2D08F8055D744DC0ADDA2")
    public void setPort(int port) {
        mPort = port;
        // ---------- Original Method ----------
        //mPort = port;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.680 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "31407D01B4B06AB96F151CF91E2D3960")
    public int getPort() {
        int var5EFA61C4FCA92CA992BE37C2BAF4D350_435157829 = (mPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_656796296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_656796296;
        // ---------- Original Method ----------
        //return mPort;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.680 -0400", hash_original_method = "33BABAA311E3F3938C433EAC08EFC3BD", hash_generated_method = "B815314BD25E18C6E7FAC198128A0270")
    public void setPath(String path) {
        mPath = path;
        // ---------- Original Method ----------
        //mPath = path;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.680 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "CFF575B83A8AAA917FF382EFC78350A2")
    public String getPath() {
String var6AF672BCA4D9DB76D759DE4D6BEB1D5F_194361221 =         mPath;
        var6AF672BCA4D9DB76D759DE4D6BEB1D5F_194361221.addTaint(taint);
        return var6AF672BCA4D9DB76D759DE4D6BEB1D5F_194361221;
        // ---------- Original Method ----------
        //return mPath;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.680 -0400", hash_original_method = "F675A31B49A9379F049E4826FB854FCA", hash_generated_method = "50CF9B7BCF54D8FB72CC4A5C85F0D2A2")
    public void setAuthInfo(String authInfo) {
        mAuthInfo = authInfo;
        // ---------- Original Method ----------
        //mAuthInfo = authInfo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.680 -0400", hash_original_method = "C7467B6BC58B66FEF459E374D8052C25", hash_generated_method = "CFA11E577846FB031561041E4354B9B6")
    public String getAuthInfo() {
String varBAF484487075DFF7985264CE91094785_1757905262 =         mAuthInfo;
        varBAF484487075DFF7985264CE91094785_1757905262.addTaint(taint);
        return varBAF484487075DFF7985264CE91094785_1757905262;
        // ---------- Original Method ----------
        //return mAuthInfo;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.680 -0400", hash_original_field = "D67D74868A5CDA647B82BC3C2D16ABEC", hash_generated_field = "F2DACDBF83E78AD7FAE92AE4D475B900")

    static final int MATCH_GROUP_SCHEME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.680 -0400", hash_original_field = "86895D32D0016AF1D325D568DAA1ECCD", hash_generated_field = "B6049B8DB87D90B70E15EC31A3A0FC25")

    static final int MATCH_GROUP_AUTHORITY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.681 -0400", hash_original_field = "D8E080AB6664384EEFC104DD52487E50", hash_generated_field = "E88F95790B2E8DD5058A7D334BD63CF8")

    static final int MATCH_GROUP_HOST = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.681 -0400", hash_original_field = "D47652CA0897CD361E75AF4F154636C9", hash_generated_field = "EAEB4F89D944D285C71E4BF6273E0E19")

    static final int MATCH_GROUP_PORT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.681 -0400", hash_original_field = "C1E1582CC9A9848DAE5CB2F3A0BF0F8F", hash_generated_field = "5EB5C556D18FAD50FF50A2186527D4A8")

    static final int MATCH_GROUP_PATH = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.681 -0400", hash_original_field = "327576B783221654E8063A54534A76C5", hash_generated_field = "3925DB45917641BD4583B418B7004D31")

    static Pattern sAddressPattern = Pattern.compile(
             "(?:(http|https|file)\\:\\/\\/)?" +
             "(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?" +
             "([" + GOOD_IRI_CHAR + "%_-][" + GOOD_IRI_CHAR + "%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?" +
             "(?:\\:([0-9]*))?" +
             "(\\/?[^#]*)?" +
             ".*", Pattern.CASE_INSENSITIVE);
}

