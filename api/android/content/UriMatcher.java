package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import android.net.Uri;





public class UriMatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.174 -0400", hash_original_field = "8D867CBFB20E1BFF428C0F34B70EC406", hash_generated_field = "814428A5309A583B3B018643DB7956B1")

    private int mCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.174 -0400", hash_original_field = "0897AC215ECF8155758EFD206F32E8DB", hash_generated_field = "D99A25611C9835F538CE42B4D7286035")

    private int mWhich;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.174 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.174 -0400", hash_original_field = "6699FE97ED54C04992AEDA784C483D4D", hash_generated_field = "EB732DCEC890E5DB40D18C782CD31559")

    private ArrayList<UriMatcher> mChildren;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.175 -0400", hash_original_method = "3A2C7DFB4FC2B15E53BF2781D24B3722", hash_generated_method = "ADB90D56817187EC14E399B483620996")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.175 -0400", hash_original_method = "02B7CF0C93AE1B23BA80DE9D9DFF6FFA", hash_generated_method = "961CCE42CAD03B4C745729506ACEF774")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.178 -0400", hash_original_method = "2E3898492678127443A40FFAA44913F1", hash_generated_method = "F4AC71F2F5FBED5AA2C4A72A49656E26")
    public void addURI(String authority, String path, int code) {
        addTaint(path.getTaint());
        addTaint(authority.getTaint());
        if(code < 0)        
        {
            IllegalArgumentException varB4F38DAA12C74B1DD5620356BBDA2579_306818681 = new IllegalArgumentException("code " + code + " is invalid: it must be positive");
            varB4F38DAA12C74B1DD5620356BBDA2579_306818681.addTaint(taint);
            throw varB4F38DAA12C74B1DD5620356BBDA2579_306818681;
        } //End block
        String[] tokens = path != null ? PATH_SPLIT_PATTERN.split(path) : null;
        int numTokens = tokens != null ? tokens.length : 0;
        UriMatcher node = this;
for(int i = -1;i < numTokens;i++)
        {
            String token = i < 0 ? authority : tokens[i];
            ArrayList<UriMatcher> children = node.mChildren;
            int numChildren = children.size();
            UriMatcher child;
            int j;
for(j = 0;j < numChildren;j++)
            {
                child = children.get(j);
                if(token.equals(child.mText))                
                {
                    node = child;
                    break;
                } //End block
            } //End block
            if(j == numChildren)            
            {
                child = new UriMatcher();
                if(token.equals("#"))                
                {
                    child.mWhich = NUMBER;
                } //End block
                else
                if(token.equals("*"))                
                {
                    child.mWhich = TEXT;
                } //End block
                else
                {
                    child.mWhich = EXACT;
                } //End block
                child.mText = token;
                node.mChildren.add(child);
                node = child;
            } //End block
        } //End block
        node.mCode = code;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.180 -0400", hash_original_method = "4993091A11603906CAD34405800B45EB", hash_generated_method = "3F7DACE138EE0AD53AC19647E07A9124")
    public int match(Uri uri) {
        addTaint(uri.getTaint());
        final List<String> pathSegments = uri.getPathSegments();
        final int li = pathSegments.size();
        UriMatcher node = this;
        if(li == 0 && uri.getAuthority() == null)        
        {
            int var5E65E465F08FEFCFD940E64EAC6F72FF_1185433011 = (this.mCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100768483 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100768483;
        } //End block
for(int i=-1;i<li;i++)
        {
            String u = i < 0 ? uri.getAuthority() : pathSegments.get(i);
            ArrayList<UriMatcher> list = node.mChildren;
            if(list == null)            
            {
                break;
            } //End block
            node = null;
            int lj = list.size();
for(int j=0;j<lj;j++)
            {
                UriMatcher n = list.get(j);
                which_switch                :
switch(n.mWhich){
                case EXACT:
                if(n.mText.equals(u))                
                {
                    node = n;
                } //End block
                break;
                case NUMBER:
                int lk = u.length();
for(int k=0;k<lk;k++)
                {
                    char c = u.charAt(k);
                    if(c < '0' || c > '9')                    
                    {
                        break which_switch;
                    } //End block
                } //End block
                node = n;
                break;
                case TEXT:
                node = n;
                break;
}                if(node != null)                
                {
                    break;
                } //End block
            } //End block
            if(node == null)            
            {
                int var94935CEF4046D086A88DC70DAE2086CA_190604189 = (NO_MATCH);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414397938 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414397938;
            } //End block
        } //End block
        int varB920D46657AFFF269950D156F8BCCDDB_1451374618 = (node.mCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_685118795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_685118795;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.180 -0400", hash_original_field = "94F36874C5D55F4A52687DE2167E8E9C", hash_generated_field = "EC83DD3596C16D8C7F528F9C8BD122E7")

    public static final int NO_MATCH = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.181 -0400", hash_original_field = "637D8D350C28FD91CCC86A2D9F75FD3F", hash_generated_field = "74E03DBA734BDB2408CC928ABAC31EB9")

    static final Pattern PATH_SPLIT_PATTERN = Pattern.compile("/");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.181 -0400", hash_original_field = "F8C49111424DFDBC8B840505E8F56076", hash_generated_field = "B743019AE27D261938D2BCF0DA9454CE")

    private static final int EXACT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.181 -0400", hash_original_field = "8EBF1B465BEA05EAA3866C94BE48BA46", hash_generated_field = "4679523F8C31D64A95ADAB50A513AABD")

    private static final int NUMBER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.181 -0400", hash_original_field = "19A352E1EB96A3718FB1818AAEACEF30", hash_generated_field = "D2B29393494C9914D5426F6550D374DF")

    private static final int TEXT = 2;
}

