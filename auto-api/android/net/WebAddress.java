package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import static android.util.Patterns.GOOD_IRI_CHAR;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.305 -0400", hash_original_field = "51CA147512905722A26C3D219A583C78", hash_generated_field = "CE8AB436FE82236B0FB9A3B1339DC56F")

    private String mScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.305 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

    private String mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.305 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

    private int mPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.305 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.305 -0400", hash_original_field = "A8B1F7BA82BC1F145F3409F6F8441616", hash_generated_field = "166A9A198632C99EE75D5EEF2F750EAC")

    private String mAuthInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.329 -0400", hash_original_method = "487816E9D6EC142D6B04FB79F32D074F", hash_generated_method = "21579E3DB34096F9BFDCA935EFE5A572")
    public  WebAddress(String address) throws ParseException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        mScheme = "";
        mHost = "";
        mPort = -1;
        mPath = "/";
        mAuthInfo = "";
        Matcher m;
        m = sAddressPattern.matcher(address);
        String t;
        {
            boolean varABB24D1E739E50018F60117A40FBB1EC_1133793994 = (m.matches());
            {
                t = m.group(MATCH_GROUP_SCHEME);
                mScheme = t.toLowerCase();
                t = m.group(MATCH_GROUP_AUTHORITY);
                mAuthInfo = t;
                t = m.group(MATCH_GROUP_HOST);
                mHost = t;
                t = m.group(MATCH_GROUP_PORT);
                {
                    boolean varEA86416E71243B1D7495AA261D0492BB_145826384 = (t != null && t.length() > 0);
                    {
                        try 
                        {
                            mPort = Integer.parseInt(t);
                        } //End block
                        catch (NumberFormatException ex)
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ParseException("Bad port");
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                t = m.group(MATCH_GROUP_PATH);
                {
                    boolean varEA86416E71243B1D7495AA261D0492BB_1652166158 = (t != null && t.length() > 0);
                    {
                        {
                            boolean var417E218ACD2171E6AC979D71680E86ED_713679464 = (t.charAt(0) == '/');
                            {
                                mPath = t;
                            } //End block
                            {
                                mPath = "/" + t;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Bad address");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3F759615AE256FE53A6BA5A88213F8CB_234947997 = (mPort == 443 && mScheme.equals(""));
            {
                mScheme = "https";
            } //End block
            {
                {
                    boolean varEE91DE53B1B60E2014FF264884CAFBC8_395401296 = (mScheme.equals("https"));
                    mPort = 443;
                    mPort = 80;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA8CE4303EFEFE0A964E5C4C256C9BF66_479810869 = (mScheme.equals(""));
            mScheme = "http";
        } //End collapsed parenthetic
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.340 -0400", hash_original_method = "1D4EF43F2688F01255D5CEBFE17AB398", hash_generated_method = "58B67FB64AB0738401BA7D88EA77DBCB")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1578350564 = null; //Variable for return #1
        String port;
        port = "";
        {
            boolean varD58DB772B4EE315C2342D62198B5F0D3_1028268448 = ((mPort != 443 && mScheme.equals("https")) ||
            (mPort != 80 && mScheme.equals("http")));
            {
                port = ":" + Integer.toString(mPort);
            } //End block
        } //End collapsed parenthetic
        String authInfo;
        authInfo = "";
        {
            boolean var4C8A5E4E6D516D199FEDEA7ED2860CAF_1356572566 = (mAuthInfo.length() > 0);
            {
                authInfo = mAuthInfo + "@";
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1578350564 = mScheme + "://" + authInfo + mHost + port + mPath;
        varB4EAC82CA7396A68D541C85D26508E83_1578350564.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1578350564;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.347 -0400", hash_original_method = "67DD4047E44F32E39FC9F9A2588A82A9", hash_generated_method = "9EF399851C0503F706319A3887847965")
    public void setScheme(String scheme) {
        mScheme = scheme;
        // ---------- Original Method ----------
        //mScheme = scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.349 -0400", hash_original_method = "631B0276BE6088C8DB198A5E8698D898", hash_generated_method = "EF6D2C486589A20B894CEB915464535E")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_705084065 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_705084065 = mScheme;
        varB4EAC82CA7396A68D541C85D26508E83_705084065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_705084065;
        // ---------- Original Method ----------
        //return mScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.362 -0400", hash_original_method = "5915AC219B5071991752C386758578AC", hash_generated_method = "F8431D59CF529A7CBE808EEE2BEF2AA2")
    public void setHost(String host) {
        mHost = host;
        // ---------- Original Method ----------
        //mHost = host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.363 -0400", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "2050B1695A4A9F5B0A9E6CC4A2126E11")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1559269208 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1559269208 = mHost;
        varB4EAC82CA7396A68D541C85D26508E83_1559269208.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1559269208;
        // ---------- Original Method ----------
        //return mHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.364 -0400", hash_original_method = "0F13114466AF9A53F82890B2842E5497", hash_generated_method = "CECD3BF3EBF2D08F8055D744DC0ADDA2")
    public void setPort(int port) {
        mPort = port;
        // ---------- Original Method ----------
        //mPort = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.364 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "C0FD2C679BC33582F71B9134153111C9")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1948280142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1948280142;
        // ---------- Original Method ----------
        //return mPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.365 -0400", hash_original_method = "33BABAA311E3F3938C433EAC08EFC3BD", hash_generated_method = "B815314BD25E18C6E7FAC198128A0270")
    public void setPath(String path) {
        mPath = path;
        // ---------- Original Method ----------
        //mPath = path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.366 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "F499F05F48D0BAC8971655E0824D4A2F")
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1611236062 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1611236062 = mPath;
        varB4EAC82CA7396A68D541C85D26508E83_1611236062.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1611236062;
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.366 -0400", hash_original_method = "F675A31B49A9379F049E4826FB854FCA", hash_generated_method = "50CF9B7BCF54D8FB72CC4A5C85F0D2A2")
    public void setAuthInfo(String authInfo) {
        mAuthInfo = authInfo;
        // ---------- Original Method ----------
        //mAuthInfo = authInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.383 -0400", hash_original_method = "C7467B6BC58B66FEF459E374D8052C25", hash_generated_method = "675A14CE36EA7560C33FED7B655A314B")
    public String getAuthInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_1216310074 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1216310074 = mAuthInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1216310074.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1216310074;
        // ---------- Original Method ----------
        //return mAuthInfo;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.383 -0400", hash_original_field = "D67D74868A5CDA647B82BC3C2D16ABEC", hash_generated_field = "F5C5A5C2851714E91D2780E9CC0D9233")

    static int MATCH_GROUP_SCHEME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.383 -0400", hash_original_field = "86895D32D0016AF1D325D568DAA1ECCD", hash_generated_field = "E9B4D1BE6B9B6E827E0FD02FD69CB00F")

    static int MATCH_GROUP_AUTHORITY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.384 -0400", hash_original_field = "D8E080AB6664384EEFC104DD52487E50", hash_generated_field = "9635C482D2B062B29E9ABA14EB484631")

    static int MATCH_GROUP_HOST = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.384 -0400", hash_original_field = "D47652CA0897CD361E75AF4F154636C9", hash_generated_field = "85A9E3FC47AA0DFFED33D66F6C69A3B4")

    static int MATCH_GROUP_PORT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.384 -0400", hash_original_field = "C1E1582CC9A9848DAE5CB2F3A0BF0F8F", hash_generated_field = "E63D7500C5CB5F2924D8B19328EA7EB6")

    static int MATCH_GROUP_PATH = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.384 -0400", hash_original_field = "327576B783221654E8063A54534A76C5", hash_generated_field = "3925DB45917641BD4583B418B7004D31")

    static Pattern sAddressPattern = Pattern.compile(
             "(?:(http|https|file)\\:\\/\\/)?" +
             "(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?" +
             "([" + GOOD_IRI_CHAR + "%_-][" + GOOD_IRI_CHAR + "%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?" +
             "(?:\\:([0-9]*))?" +
             "(\\/?[^#]*)?" +
             ".*", Pattern.CASE_INSENSITIVE);
}

