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
    private String mScheme;
    private String mHost;
    private int mPort;
    private String mPath;
    private String mAuthInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.659 -0400", hash_original_method = "487816E9D6EC142D6B04FB79F32D074F", hash_generated_method = "85FE7D8F58CAF9C37BCAC3386B00AE9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebAddress(String address) throws ParseException {
        dsTaint.addTaint(address);
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
            boolean varABB24D1E739E50018F60117A40FBB1EC_419458188 = (m.matches());
            {
                t = m.group(MATCH_GROUP_SCHEME);
                mScheme = t.toLowerCase();
                t = m.group(MATCH_GROUP_AUTHORITY);
                mAuthInfo = t;
                t = m.group(MATCH_GROUP_HOST);
                mHost = t;
                t = m.group(MATCH_GROUP_PORT);
                {
                    boolean varEA86416E71243B1D7495AA261D0492BB_888793279 = (t != null && t.length() > 0);
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
                    boolean varEA86416E71243B1D7495AA261D0492BB_2099836312 = (t != null && t.length() > 0);
                    {
                        {
                            boolean var417E218ACD2171E6AC979D71680E86ED_934556549 = (t.charAt(0) == '/');
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
            boolean var3F759615AE256FE53A6BA5A88213F8CB_1655452634 = (mPort == 443 && mScheme.equals(""));
            {
                mScheme = "https";
            } //End block
            {
                {
                    boolean varEE91DE53B1B60E2014FF264884CAFBC8_1677307308 = (mScheme.equals("https"));
                    mPort = 443;
                    mPort = 80;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA8CE4303EFEFE0A964E5C4C256C9BF66_1365628624 = (mScheme.equals(""));
            mScheme = "http";
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.660 -0400", hash_original_method = "1D4EF43F2688F01255D5CEBFE17AB398", hash_generated_method = "799219912A25C21B74CBEBE78B845B31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String port;
        port = "";
        {
            boolean varD58DB772B4EE315C2342D62198B5F0D3_385372042 = ((mPort != 443 && mScheme.equals("https")) ||
            (mPort != 80 && mScheme.equals("http")));
            {
                port = ":" + Integer.toString(mPort);
            } //End block
        } //End collapsed parenthetic
        String authInfo;
        authInfo = "";
        {
            boolean var4C8A5E4E6D516D199FEDEA7ED2860CAF_510524042 = (mAuthInfo.length() > 0);
            {
                authInfo = mAuthInfo + "@";
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.660 -0400", hash_original_method = "67DD4047E44F32E39FC9F9A2588A82A9", hash_generated_method = "D46226887166FA114D86CF4FCF31770F")
    @DSModeled(DSC.SAFE)
    public void setScheme(String scheme) {
        dsTaint.addTaint(scheme);
        // ---------- Original Method ----------
        //mScheme = scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.660 -0400", hash_original_method = "631B0276BE6088C8DB198A5E8698D898", hash_generated_method = "7B06B2D59914A28CEBA229C324D35AB7")
    @DSModeled(DSC.SAFE)
    public String getScheme() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.660 -0400", hash_original_method = "5915AC219B5071991752C386758578AC", hash_generated_method = "FF44E172F5A68C7649ABA10C07318E25")
    @DSModeled(DSC.SAFE)
    public void setHost(String host) {
        dsTaint.addTaint(host);
        // ---------- Original Method ----------
        //mHost = host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.660 -0400", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "68C433D1B5A102629AAF54FA94700A37")
    @DSModeled(DSC.SAFE)
    public String getHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.661 -0400", hash_original_method = "0F13114466AF9A53F82890B2842E5497", hash_generated_method = "814270C1404CE3C1440FC8961020281A")
    @DSModeled(DSC.SAFE)
    public void setPort(int port) {
        dsTaint.addTaint(port);
        // ---------- Original Method ----------
        //mPort = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.661 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "989B279AB861DC9FDC85B5020F096FDA")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.661 -0400", hash_original_method = "33BABAA311E3F3938C433EAC08EFC3BD", hash_generated_method = "CAF1811D053CFF7C63CA6F8FA171B5FA")
    @DSModeled(DSC.SAFE)
    public void setPath(String path) {
        dsTaint.addTaint(path);
        // ---------- Original Method ----------
        //mPath = path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.661 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "29CB1D5263B4158A2D31F23885A43F10")
    @DSModeled(DSC.SAFE)
    public String getPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.661 -0400", hash_original_method = "F675A31B49A9379F049E4826FB854FCA", hash_generated_method = "441B01961D5CD5C45B351C4CB976776A")
    @DSModeled(DSC.SAFE)
    public void setAuthInfo(String authInfo) {
        dsTaint.addTaint(authInfo);
        // ---------- Original Method ----------
        //mAuthInfo = authInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.662 -0400", hash_original_method = "C7467B6BC58B66FEF459E374D8052C25", hash_generated_method = "0819116C4795533A0D1F8717332E9D16")
    @DSModeled(DSC.SAFE)
    public String getAuthInfo() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mAuthInfo;
    }

    
    static final int MATCH_GROUP_SCHEME = 1;
    static final int MATCH_GROUP_AUTHORITY = 2;
    static final int MATCH_GROUP_HOST = 3;
    static final int MATCH_GROUP_PORT = 4;
    static final int MATCH_GROUP_PATH = 5;
    static Pattern sAddressPattern = Pattern.compile(
             "(?:(http|https|file)\\:\\/\\/)?" +
             "(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?" +
             "([" + GOOD_IRI_CHAR + "%_-][" + GOOD_IRI_CHAR + "%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?" +
             "(?:\\:([0-9]*))?" +
             "(\\/?[^#]*)?" +
             ".*", Pattern.CASE_INSENSITIVE);
}

