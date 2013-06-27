package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UriMatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.659 -0400", hash_original_field = "8D867CBFB20E1BFF428C0F34B70EC406", hash_generated_field = "814428A5309A583B3B018643DB7956B1")

    private int mCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.659 -0400", hash_original_field = "0897AC215ECF8155758EFD206F32E8DB", hash_generated_field = "D99A25611C9835F538CE42B4D7286035")

    private int mWhich;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.660 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.660 -0400", hash_original_field = "6699FE97ED54C04992AEDA784C483D4D", hash_generated_field = "EB732DCEC890E5DB40D18C782CD31559")

    private ArrayList<UriMatcher> mChildren;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.661 -0400", hash_original_method = "3A2C7DFB4FC2B15E53BF2781D24B3722", hash_generated_method = "ADB90D56817187EC14E399B483620996")
    public  UriMatcher(int code) {
        mCode = code;
        mWhich = -1;
        mChildren = new ArrayList<UriMatcher>();
        mText = null;
        // ---------- Original Method ----------
        //mCode = code;
        //mWhich = -1;
        //mChildren = new ArrayList<UriMatcher>();
        //mText = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.692 -0400", hash_original_method = "02B7CF0C93AE1B23BA80DE9D9DFF6FFA", hash_generated_method = "961CCE42CAD03B4C745729506ACEF774")
    private  UriMatcher() {
        mCode = NO_MATCH;
        mWhich = -1;
        mChildren = new ArrayList<UriMatcher>();
        mText = null;
        // ---------- Original Method ----------
        //mCode = NO_MATCH;
        //mWhich = -1;
        //mChildren = new ArrayList<UriMatcher>();
        //mText = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.704 -0400", hash_original_method = "2E3898492678127443A40FFAA44913F1", hash_generated_method = "2DF70E083E6B43A6F53A48050497D100")
    public void addURI(String authority, String path, int code) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("code " + code + " is invalid: it must be positive");
        } //End block
        String[] tokens;
        tokens = PATH_SPLIT_PATTERN.split(path);
        tokens = null;
        int numTokens;
        numTokens = tokens.length;
        numTokens = 0;
        UriMatcher node;
        node = this;
        {
            int i;
            i = -1;
            {
                String token;
                token = authority;
                token = tokens[i];
                ArrayList<UriMatcher> children;
                children = node.mChildren;
                int numChildren;
                numChildren = children.size();
                UriMatcher child;
                int j;
                {
                    j = 0;
                    {
                        child = children.get(j);
                        {
                            boolean varAF69555A47401354DB698CF192B24B8D_986003417 = (token.equals(child.mText));
                            {
                                node = child;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    child = new UriMatcher();
                    {
                        boolean varDF8BE0FB621795E83272C57320469194_224528874 = (token.equals("#"));
                        {
                            child.mWhich = NUMBER;
                        } //End block
                        {
                            boolean var3128E3E855036724C83E0031F6A280BF_136794550 = (token.equals("*"));
                            {
                                child.mWhich = TEXT;
                            } //End block
                            {
                                child.mWhich = EXACT;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    child.mText = token;
                    node.mChildren.add(child);
                    node = child;
                } //End block
            } //End block
        } //End collapsed parenthetic
        node.mCode = code;
        addTaint(authority.getTaint());
        addTaint(path.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.719 -0400", hash_original_method = "4993091A11603906CAD34405800B45EB", hash_generated_method = "B8BD0E53F30ACC797895CB22704C6C7D")
    public int match(Uri uri) {
        List<String> pathSegments;
        pathSegments = uri.getPathSegments();
        int li;
        li = pathSegments.size();
        UriMatcher node;
        node = this;
        {
            boolean var6CFBCB60140A82718A01256C3BAC9FED_463367310 = (li == 0 && uri.getAuthority() == null);
        } //End collapsed parenthetic
        {
            int i;
            i = -1;
            {
                String u;
                u = uri.getAuthority();
                u = pathSegments.get(i);
                ArrayList<UriMatcher> list;
                list = node.mChildren;
                node = null;
                int lj;
                lj = list.size();
                {
                    int j;
                    j = 0;
                    {
                        UriMatcher n;
                        n = list.get(j);
                        //Begin case EXACT 
                        {
                            boolean varF3943A9C2F70AEA6806D132200507AF3_1375554261 = (n.mText.equals(u));
                            {
                                node = n;
                            } //End block
                        } //End collapsed parenthetic
                        //End case EXACT 
                        //Begin case NUMBER 
                        int lk;
                        lk = u.length();
                        //End case NUMBER 
                        //Begin case NUMBER 
                        {
                            int k;
                            k = 0;
                            {
                                char c;
                                c = u.charAt(k);
                            } //End block
                        } //End collapsed parenthetic
                        //End case NUMBER 
                        //Begin case NUMBER 
                        node = n;
                        //End case NUMBER 
                        //Begin case TEXT 
                        node = n;
                        //End case TEXT 
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(uri.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827586786 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827586786;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.719 -0400", hash_original_field = "94F36874C5D55F4A52687DE2167E8E9C", hash_generated_field = "EC83DD3596C16D8C7F528F9C8BD122E7")

    public static final int NO_MATCH = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.719 -0400", hash_original_field = "637D8D350C28FD91CCC86A2D9F75FD3F", hash_generated_field = "68A889663414BB738D8FD0F3D0124E94")

    static Pattern PATH_SPLIT_PATTERN = Pattern.compile("/");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.719 -0400", hash_original_field = "F8C49111424DFDBC8B840505E8F56076", hash_generated_field = "7CF2356C6B58AB64FB1951B2AA815AAD")

    private static int EXACT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.731 -0400", hash_original_field = "8EBF1B465BEA05EAA3866C94BE48BA46", hash_generated_field = "CC82E8C6EB6AA8AA022AB8818EF06A59")

    private static int NUMBER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.731 -0400", hash_original_field = "19A352E1EB96A3718FB1818AAEACEF30", hash_generated_field = "346BC84D82F8641A586A9FF1E4BCC93E")

    private static int TEXT = 2;
}

