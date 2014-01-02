package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import static android.util.Patterns.GOOD_IRI_CHAR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;






public class WebAddress {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.463 -0500", hash_original_field = "AEE90CC90EAE0E125CF546188F0DE6CA", hash_generated_field = "F2DACDBF83E78AD7FAE92AE4D475B900")


    static final int MATCH_GROUP_SCHEME = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.465 -0500", hash_original_field = "A8A77CBE3A2D8B8D743BA0D706D58B63", hash_generated_field = "B6049B8DB87D90B70E15EC31A3A0FC25")

    static final int MATCH_GROUP_AUTHORITY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.467 -0500", hash_original_field = "CDE76BA8219477C5C1F3165D7FF2456C", hash_generated_field = "E88F95790B2E8DD5058A7D334BD63CF8")

    static final int MATCH_GROUP_HOST = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.469 -0500", hash_original_field = "D470DB2673E7DEAD721803025B18D481", hash_generated_field = "EAEB4F89D944D285C71E4BF6273E0E19")

    static final int MATCH_GROUP_PORT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.472 -0500", hash_original_field = "AE103FF37A179FD1C59194FBF71CD7A4", hash_generated_field = "5EB5C556D18FAD50FF50A2186527D4A8")

    static final int MATCH_GROUP_PATH = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.474 -0500", hash_original_field = "30FF9F789862242DAD47769FDB50086C", hash_generated_field = "FBA32F17CDD294929710F529A7225650")


    static Pattern sAddressPattern = Pattern.compile(
            /* scheme    */ "(?:(http|https|file)\\:\\/\\/)?" +
            /* authority */ "(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?" +
            /* host      */ "([" + GOOD_IRI_CHAR + "%_-][" + GOOD_IRI_CHAR + "%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?" +
            /* port      */ "(?:\\:([0-9]*))?" +
            /* path      */ "(\\/?[^#]*)?" +
            /* anchor    */ ".*", Pattern.CASE_INSENSITIVE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.447 -0500", hash_original_field = "FF84573DD774BD103492BEC5B95FE660", hash_generated_field = "CE8AB436FE82236B0FB9A3B1339DC56F")


    private String mScheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.449 -0500", hash_original_field = "608081BE7A68D9B383C7D78BD9FDC0E8", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

    private String mHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.451 -0500", hash_original_field = "AAAF8A3C293EA5711E38C28140852BDE", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

    private int mPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.458 -0500", hash_original_field = "1D4D0FAE668EECF10ED75DDC284FFC16", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.460 -0500", hash_original_field = "26C1C7DC4AB2AF2008F6F3CBFB7F288D", hash_generated_field = "166A9A198632C99EE75D5EEF2F750EAC")

    private String mAuthInfo;

    /** parses given uriString. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.477 -0500", hash_original_method = "487816E9D6EC142D6B04FB79F32D074F", hash_generated_method = "48BCD8E0894270FA274604261A71A368")
    
public WebAddress(String address) throws ParseException {
        if (address == null) {
            throw new NullPointerException();
        }

        // android.util.Log.d(LOGTAG, "WebAddress: " + address);

        mScheme = "";
        mHost = "";
        mPort = -1;
        mPath = "/";
        mAuthInfo = "";

        Matcher m = sAddressPattern.matcher(address);
        String t;
        if (m.matches()) {
            t = m.group(MATCH_GROUP_SCHEME);
            if (t != null) mScheme = t.toLowerCase();
            t = m.group(MATCH_GROUP_AUTHORITY);
            if (t != null) mAuthInfo = t;
            t = m.group(MATCH_GROUP_HOST);
            if (t != null) mHost = t;
            t = m.group(MATCH_GROUP_PORT);
            if (t != null && t.length() > 0) {
                // The ':' character is not returned by the regex.
                try {
                    mPort = Integer.parseInt(t);
                } catch (NumberFormatException ex) {
                    throw new ParseException("Bad port");
                }
            }
            t = m.group(MATCH_GROUP_PATH);
            if (t != null && t.length() > 0) {
                /* handle busted myspace frontpage redirect with
                   missing initial "/" */
                if (t.charAt(0) == '/') {
                    mPath = t;
                } else {
                    mPath = "/" + t;
                }
            }

        } else {
            // nothing found... outa here
            throw new ParseException("Bad address");
        }

        /* Get port from scheme or scheme from port, if necessary and
           possible */
        if (mPort == 443 && mScheme.equals("")) {
            mScheme = "https";
        } else if (mPort == -1) {
            if (mScheme.equals("https"))
                mPort = 443;
            else
                mPort = 80; // default
        }
        if (mScheme.equals("")) mScheme = "http";
    }

    
    @DSModeled(DSC.BAN)
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.482 -0500", hash_original_method = "67DD4047E44F32E39FC9F9A2588A82A9", hash_generated_method = "01C54750A6CACB44FB8175579137C4AB")
    
public void setScheme(String scheme) {
      mScheme = scheme;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.484 -0500", hash_original_method = "631B0276BE6088C8DB198A5E8698D898", hash_generated_method = "D8EB606C83E382B42BD568ABEA134902")
    
public String getScheme() {
      return mScheme;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.486 -0500", hash_original_method = "5915AC219B5071991752C386758578AC", hash_generated_method = "EAED8272A4C94056B59A926A4691C66C")
    
public void setHost(String host) {
      mHost = host;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.488 -0500", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "6A355E9CFD8CF295DC08D3692B6B0773")
    
public String getHost() {
      return mHost;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.491 -0500", hash_original_method = "0F13114466AF9A53F82890B2842E5497", hash_generated_method = "6C7694E604CA2F68595EABE88440EE9A")
    
public void setPort(int port) {
      mPort = port;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.493 -0500", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "33B8E8C1C43AC396F100852932189626")
    
public int getPort() {
      return mPort;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.495 -0500", hash_original_method = "33BABAA311E3F3938C433EAC08EFC3BD", hash_generated_method = "A4FC0939CED4F82EC598207299ADD39F")
    
public void setPath(String path) {
      mPath = path;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.497 -0500", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "737CD89E9B5A7ABC855CEA2E5A098D56")
    
public String getPath() {
      return mPath;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.499 -0500", hash_original_method = "F675A31B49A9379F049E4826FB854FCA", hash_generated_method = "6C5D756E868C64C5AF116831359001C5")
    
public void setAuthInfo(String authInfo) {
      mAuthInfo = authInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.501 -0500", hash_original_method = "C7467B6BC58B66FEF459E374D8052C25", hash_generated_method = "43D3EDDE322033F0418552A916AA2A4F")
    
public String getAuthInfo() {
      return mAuthInfo;
    }
}

