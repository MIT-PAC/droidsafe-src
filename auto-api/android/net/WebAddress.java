package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import static android.util.Patterns.GOOD_IRI_CHAR;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.436 -0400", hash_original_field = "51CA147512905722A26C3D219A583C78", hash_generated_field = "CE8AB436FE82236B0FB9A3B1339DC56F")

    private String mScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.436 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

    private String mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.436 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

    private int mPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.436 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.436 -0400", hash_original_field = "A8B1F7BA82BC1F145F3409F6F8441616", hash_generated_field = "166A9A198632C99EE75D5EEF2F750EAC")

    private String mAuthInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.437 -0400", hash_original_method = "487816E9D6EC142D6B04FB79F32D074F", hash_generated_method = "0829C4D47C1FEC9C095ACEF724B3D15D")
    public  WebAddress(String address) throws ParseException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        mScheme = "";
        mHost = "";
        mPort = -1;
        mPath = "/";
        mAuthInfo = "";
        Matcher m = sAddressPattern.matcher(address);
        String t;
        {
            boolean varABB24D1E739E50018F60117A40FBB1EC_1217167815 = (m.matches());
            {
                t = m.group(MATCH_GROUP_SCHEME);
                mScheme = t.toLowerCase();
                t = m.group(MATCH_GROUP_AUTHORITY);
                mAuthInfo = t;
                t = m.group(MATCH_GROUP_HOST);
                mHost = t;
                t = m.group(MATCH_GROUP_PORT);
                {
                    boolean varEA86416E71243B1D7495AA261D0492BB_420807742 = (t != null && t.length() > 0);
                    {
                        try 
                        {
                            mPort = Integer.parseInt(t);
                        } 
                        catch (NumberFormatException ex)
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ParseException("Bad port");
                        } 
                    } 
                } 
                t = m.group(MATCH_GROUP_PATH);
                {
                    boolean varEA86416E71243B1D7495AA261D0492BB_1932779034 = (t != null && t.length() > 0);
                    {
                        {
                            boolean var417E218ACD2171E6AC979D71680E86ED_2035441213 = (t.charAt(0) == '/');
                            {
                                mPath = t;
                            } 
                            {
                                mPath = "/" + t;
                            } 
                        } 
                    } 
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Bad address");
            } 
        } 
        {
            boolean var3F759615AE256FE53A6BA5A88213F8CB_2014137525 = (mPort == 443 && mScheme.equals(""));
            {
                mScheme = "https";
            } 
            {
                {
                    boolean varEE91DE53B1B60E2014FF264884CAFBC8_1113674126 = (mScheme.equals("https"));
                    mPort = 443;
                    mPort = 80;
                } 
            } 
        } 
        {
            boolean varA8CE4303EFEFE0A964E5C4C256C9BF66_908631862 = (mScheme.equals(""));
            mScheme = "http";
        } 
        addTaint(address.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.438 -0400", hash_original_method = "1D4EF43F2688F01255D5CEBFE17AB398", hash_generated_method = "DC46428301E4CF42234FD2DDE4DD2700")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_510858977 = null; 
        String port = "";
        {
            boolean varD58DB772B4EE315C2342D62198B5F0D3_1974425230 = ((mPort != 443 && mScheme.equals("https")) ||
            (mPort != 80 && mScheme.equals("http")));
            {
                port = ":" + Integer.toString(mPort);
            } 
        } 
        String authInfo = "";
        {
            boolean var4C8A5E4E6D516D199FEDEA7ED2860CAF_1233707700 = (mAuthInfo.length() > 0);
            {
                authInfo = mAuthInfo + "@";
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_510858977 = mScheme + "://" + authInfo + mHost + port + mPath;
        varB4EAC82CA7396A68D541C85D26508E83_510858977.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_510858977;
        
        
        
            
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.438 -0400", hash_original_method = "67DD4047E44F32E39FC9F9A2588A82A9", hash_generated_method = "9EF399851C0503F706319A3887847965")
    public void setScheme(String scheme) {
        mScheme = scheme;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.439 -0400", hash_original_method = "631B0276BE6088C8DB198A5E8698D898", hash_generated_method = "7D45FFEB262F669EC98E3FFA3960F4B8")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_831580323 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_831580323 = mScheme;
        varB4EAC82CA7396A68D541C85D26508E83_831580323.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_831580323;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.440 -0400", hash_original_method = "5915AC219B5071991752C386758578AC", hash_generated_method = "F8431D59CF529A7CBE808EEE2BEF2AA2")
    public void setHost(String host) {
        mHost = host;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.440 -0400", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "4173BBC2FD8491617F9EE76914773EC5")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1569794387 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1569794387 = mHost;
        varB4EAC82CA7396A68D541C85D26508E83_1569794387.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1569794387;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.441 -0400", hash_original_method = "0F13114466AF9A53F82890B2842E5497", hash_generated_method = "CECD3BF3EBF2D08F8055D744DC0ADDA2")
    public void setPort(int port) {
        mPort = port;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.441 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "C26FA4B6AD68E78FE336795F02C70F1A")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883610660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883610660;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.441 -0400", hash_original_method = "33BABAA311E3F3938C433EAC08EFC3BD", hash_generated_method = "B815314BD25E18C6E7FAC198128A0270")
    public void setPath(String path) {
        mPath = path;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.442 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "FF791ABAA0618CAE10B931EB68B7E7DE")
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1719758735 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1719758735 = mPath;
        varB4EAC82CA7396A68D541C85D26508E83_1719758735.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1719758735;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.442 -0400", hash_original_method = "F675A31B49A9379F049E4826FB854FCA", hash_generated_method = "50CF9B7BCF54D8FB72CC4A5C85F0D2A2")
    public void setAuthInfo(String authInfo) {
        mAuthInfo = authInfo;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.442 -0400", hash_original_method = "C7467B6BC58B66FEF459E374D8052C25", hash_generated_method = "422A44C7C6B9B97E7D8D8FC18038F3B3")
    public String getAuthInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_1687497574 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1687497574 = mAuthInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1687497574.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1687497574;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.442 -0400", hash_original_field = "D67D74868A5CDA647B82BC3C2D16ABEC", hash_generated_field = "F2DACDBF83E78AD7FAE92AE4D475B900")

    static final int MATCH_GROUP_SCHEME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.442 -0400", hash_original_field = "86895D32D0016AF1D325D568DAA1ECCD", hash_generated_field = "B6049B8DB87D90B70E15EC31A3A0FC25")

    static final int MATCH_GROUP_AUTHORITY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.442 -0400", hash_original_field = "D8E080AB6664384EEFC104DD52487E50", hash_generated_field = "E88F95790B2E8DD5058A7D334BD63CF8")

    static final int MATCH_GROUP_HOST = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.443 -0400", hash_original_field = "D47652CA0897CD361E75AF4F154636C9", hash_generated_field = "EAEB4F89D944D285C71E4BF6273E0E19")

    static final int MATCH_GROUP_PORT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.443 -0400", hash_original_field = "C1E1582CC9A9848DAE5CB2F3A0BF0F8F", hash_generated_field = "5EB5C556D18FAD50FF50A2186527D4A8")

    static final int MATCH_GROUP_PATH = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.443 -0400", hash_original_field = "327576B783221654E8063A54534A76C5", hash_generated_field = "3925DB45917641BD4583B418B7004D31")

    static Pattern sAddressPattern = Pattern.compile(
             "(?:(http|https|file)\\:\\/\\/)?" +
             "(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?" +
             "([" + GOOD_IRI_CHAR + "%_-][" + GOOD_IRI_CHAR + "%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?" +
             "(?:\\:([0-9]*))?" +
             "(\\/?[^#]*)?" +
             ".*", Pattern.CASE_INSENSITIVE);
}

