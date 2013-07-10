package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UriMatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.910 -0400", hash_original_field = "8D867CBFB20E1BFF428C0F34B70EC406", hash_generated_field = "814428A5309A583B3B018643DB7956B1")

    private int mCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.910 -0400", hash_original_field = "0897AC215ECF8155758EFD206F32E8DB", hash_generated_field = "D99A25611C9835F538CE42B4D7286035")

    private int mWhich;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.910 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.910 -0400", hash_original_field = "6699FE97ED54C04992AEDA784C483D4D", hash_generated_field = "EB732DCEC890E5DB40D18C782CD31559")

    private ArrayList<UriMatcher> mChildren;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.911 -0400", hash_original_method = "3A2C7DFB4FC2B15E53BF2781D24B3722", hash_generated_method = "ADB90D56817187EC14E399B483620996")
    public  UriMatcher(int code) {
        mCode = code;
        mWhich = -1;
        mChildren = new ArrayList<UriMatcher>();
        mText = null;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.911 -0400", hash_original_method = "02B7CF0C93AE1B23BA80DE9D9DFF6FFA", hash_generated_method = "961CCE42CAD03B4C745729506ACEF774")
    private  UriMatcher() {
        mCode = NO_MATCH;
        mWhich = -1;
        mChildren = new ArrayList<UriMatcher>();
        mText = null;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.912 -0400", hash_original_method = "2E3898492678127443A40FFAA44913F1", hash_generated_method = "DB6F7935329213F2ACEB0E844A99C033")
    public void addURI(String authority, String path, int code) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("code " + code + " is invalid: it must be positive");
        } 
        String[] tokens;
        tokens = PATH_SPLIT_PATTERN.split(path);
        tokens = null;
        int numTokens;
        numTokens = tokens.length;
        numTokens = 0;
        UriMatcher node = this;
        {
            int i = -1;
            {
                String token;
                token = authority;
                token = tokens[i];
                ArrayList<UriMatcher> children = node.mChildren;
                int numChildren = children.size();
                UriMatcher child;
                int j;
                {
                    j = 0;
                    {
                        child = children.get(j);
                        {
                            boolean varAF69555A47401354DB698CF192B24B8D_1896232397 = (token.equals(child.mText));
                            {
                                node = child;
                            } 
                        } 
                    } 
                } 
                {
                    child = new UriMatcher();
                    {
                        boolean varDF8BE0FB621795E83272C57320469194_1631031564 = (token.equals("#"));
                        {
                            child.mWhich = NUMBER;
                        } 
                        {
                            boolean var3128E3E855036724C83E0031F6A280BF_854332878 = (token.equals("*"));
                            {
                                child.mWhich = TEXT;
                            } 
                            {
                                child.mWhich = EXACT;
                            } 
                        } 
                    } 
                    child.mText = token;
                    node.mChildren.add(child);
                    node = child;
                } 
            } 
        } 
        node.mCode = code;
        addTaint(authority.getTaint());
        addTaint(path.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.913 -0400", hash_original_method = "4993091A11603906CAD34405800B45EB", hash_generated_method = "59ADFEABDCF0B044DFADA2594577099D")
    public int match(Uri uri) {
        final List<String> pathSegments = uri.getPathSegments();
        final int li = pathSegments.size();
        UriMatcher node = this;
        {
            boolean var6CFBCB60140A82718A01256C3BAC9FED_220548620 = (li == 0 && uri.getAuthority() == null);
        } 
        {
            int i = -1;
            {
                String u;
                u = uri.getAuthority();
                u = pathSegments.get(i);
                ArrayList<UriMatcher> list = node.mChildren;
                node = null;
                int lj = list.size();
                {
                    int j = 0;
                    {
                        UriMatcher n = list.get(j);
                        
                        {
                            boolean varF3943A9C2F70AEA6806D132200507AF3_954412933 = (n.mText.equals(u));
                            {
                                node = n;
                            } 
                        } 
                        
                        
                        int lk = u.length();
                        
                        
                        {
                            int k = 0;
                            {
                                char c = u.charAt(k);
                            } 
                        } 
                        
                        
                        node = n;
                        
                        
                        node = n;
                        
                    } 
                } 
            } 
        } 
        addTaint(uri.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_242587319 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_242587319;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.913 -0400", hash_original_field = "94F36874C5D55F4A52687DE2167E8E9C", hash_generated_field = "EC83DD3596C16D8C7F528F9C8BD122E7")

    public static final int NO_MATCH = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.913 -0400", hash_original_field = "637D8D350C28FD91CCC86A2D9F75FD3F", hash_generated_field = "74E03DBA734BDB2408CC928ABAC31EB9")

    static final Pattern PATH_SPLIT_PATTERN = Pattern.compile("/");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.913 -0400", hash_original_field = "F8C49111424DFDBC8B840505E8F56076", hash_generated_field = "B743019AE27D261938D2BCF0DA9454CE")

    private static final int EXACT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.913 -0400", hash_original_field = "8EBF1B465BEA05EAA3866C94BE48BA46", hash_generated_field = "4679523F8C31D64A95ADAB50A513AABD")

    private static final int NUMBER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.913 -0400", hash_original_field = "19A352E1EB96A3718FB1818AAEACEF30", hash_generated_field = "D2B29393494C9914D5426F6550D374DF")

    private static final int TEXT = 2;
}

