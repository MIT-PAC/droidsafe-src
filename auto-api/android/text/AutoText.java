package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.android.internal.util.XmlUtils;
import android.view.View;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.util.Locale;

public class AutoText {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.956 -0400", hash_original_field = "5BDF724CD0456C44608769D876789E27", hash_generated_field = "88B4BB6C6C54F768FFBA5254BB72365D")

    private char[] mTrie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.956 -0400", hash_original_field = "A813945620FA1D05C4425C4C401B5023", hash_generated_field = "88631567A4C7FF89A1AFBFB0DA730CFF")

    private char mTrieUsed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.956 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.956 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.956 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.967 -0400", hash_original_method = "09AEE40B99596F23FD7F50F9A174308F", hash_generated_method = "8A758FB35DD76CF0024FB127BB02DD22")
    private  AutoText(Resources resources) {
        mLocale = resources.getConfiguration().locale;
        init(resources);
        // ---------- Original Method ----------
        //mLocale = resources.getConfiguration().locale;
        //init(resources);
    }

    
        private static AutoText getInstance(View view) {
        Resources res = view.getContext().getResources();
        Locale locale = res.getConfiguration().locale;
        AutoText instance;
        synchronized (sLock) {
            instance = sInstance;
            if (!locale.equals(instance.mLocale)) {
                instance = new AutoText(res);
                sInstance = instance;
            }
        }
        return instance;
    }

    
        public static String get(CharSequence src, final int start, final int end,
                             View view) {
        return getInstance(view).lookup(src, start, end);
    }

    
        public static int getSize(View view) {
        return getInstance(view).getSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.968 -0400", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "AD62E653618AE7820C08168E8FF5028E")
    private int getSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_355290032 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_355290032;
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.974 -0400", hash_original_method = "A395619387E5FA987B6ED6EABB20C725", hash_generated_method = "789CCF268205E524BC1DD2C7D764D249")
    private String lookup(CharSequence src, final int start, final int end) {
        String varB4EAC82CA7396A68D541C85D26508E83_2012131524 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_471160222 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_128225654 = null; //Variable for return #3
        int here;
        here = mTrie[TRIE_ROOT];
        {
            int i;
            i = start;
            {
                char c;
                c = src.charAt(i);
                {
                    here = mTrie[here + TRIE_NEXT];
                    {
                        {
                            {
                                int off;
                                off = mTrie[here + TRIE_OFF];
                                int len;
                                len = mText.charAt(off);
                                varB4EAC82CA7396A68D541C85D26508E83_2012131524 = mText.substring(off + 1, off + 1 + len);
                            } //End block
                            here = mTrie[here + TRIE_CHILD];
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    varB4EAC82CA7396A68D541C85D26508E83_471160222 = null;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_128225654 = null;
        addTaint(src.getTaint());
        addTaint(start);
        addTaint(end);
        String varA7E53CE21691AB073D9660D615818899_1124612611; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1124612611 = varB4EAC82CA7396A68D541C85D26508E83_2012131524;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1124612611 = varB4EAC82CA7396A68D541C85D26508E83_471160222;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1124612611 = varB4EAC82CA7396A68D541C85D26508E83_128225654;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1124612611.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1124612611;
        // ---------- Original Method ----------
        //int here = mTrie[TRIE_ROOT];
        //for (int i = start; i < end; i++) {
            //char c = src.charAt(i);
            //for (; here != TRIE_NULL; here = mTrie[here + TRIE_NEXT]) {
                //if (c == mTrie[here + TRIE_C]) {
                    //if ((i == end - 1) 
                            //&& (mTrie[here + TRIE_OFF] != TRIE_NULL)) {
                        //int off = mTrie[here + TRIE_OFF];
                        //int len = mText.charAt(off);
                        //return mText.substring(off + 1, off + 1 + len);
                    //}
                    //here = mTrie[here + TRIE_CHILD];
                    //break;
                //}
            //}
            //if (here == TRIE_NULL) {
                //return null;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.984 -0400", hash_original_method = "E19B6C2A17EB3626AF05ED9F48AE64FD", hash_generated_method = "00169ABE9F3BE4F19D7D780BD720B91B")
    private void init(Resources r) {
        XmlResourceParser parser;
        parser = r.getXml(com.android.internal.R.xml.autotext);
        StringBuilder right;
        right = new StringBuilder(RIGHT);
        mTrie = new char[DEFAULT];
        mTrie[TRIE_ROOT] = TRIE_NULL;
        mTrieUsed = TRIE_ROOT + 1;
        try 
        {
            XmlUtils.beginDocument(parser, "words");
            String odest;
            odest = "";
            char ooff;
            ooff = 0;
            {
                XmlUtils.nextElement(parser);
                String element;
                element = parser.getName();
                {
                    boolean var2D95B92CEF5A452FD7925DF9FBF92370_448375640 = (element == null || !(element.equals("word")));
                } //End collapsed parenthetic
                String src;
                src = parser.getAttributeValue(null, "src");
                {
                    boolean varD9C33DAEA9F0FA8AA020A07656F3B790_1284727941 = (parser.next() == XmlPullParser.TEXT);
                    {
                        String dest;
                        dest = parser.getText();
                        char off;
                        {
                            boolean varDF0A86F34F54C11F6A06F06A2C96505D_195961376 = (dest.equals(odest));
                            {
                                off = ooff;
                            } //End block
                            {
                                off = (char) right.length();
                                right.append((char) dest.length());
                                right.append(dest);
                            } //End block
                        } //End collapsed parenthetic
                        add(src, off);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            r.flushLayoutCache();
        } //End block
        catch (XmlPullParserException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        finally 
        {
            parser.close();
        } //End block
        mText = right.toString();
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.990 -0400", hash_original_method = "0D3B451571572F26E1C81E0825865666", hash_generated_method = "170052E2F35AFCEC46C01C429A55F652")
    private void add(String src, char off) {
        int slen;
        slen = src.length();
        int herep;
        herep = TRIE_ROOT;
        {
            int i;
            i = 0;
            {
                char c;
                c = src.charAt(i);
                boolean found;
                found = false;
                {
                    herep = mTrie[herep] + TRIE_NEXT;
                    {
                        {
                            {
                                mTrie[mTrie[herep] + TRIE_OFF] = off;
                            } //End block
                            herep = mTrie[herep] + TRIE_CHILD;
                            found = true;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    char node;
                    node = newTrieNode();
                    mTrie[herep] = node;
                    mTrie[mTrie[herep] + TRIE_C] = c;
                    mTrie[mTrie[herep] + TRIE_OFF] = TRIE_NULL;
                    mTrie[mTrie[herep] + TRIE_NEXT] = TRIE_NULL;
                    mTrie[mTrie[herep] + TRIE_CHILD] = TRIE_NULL;
                    {
                        mTrie[mTrie[herep] + TRIE_OFF] = off;
                    } //End block
                    herep = mTrie[herep] + TRIE_CHILD;
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(src.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.991 -0400", hash_original_method = "6974F5A5A1101E98F9450C35EFEECA6C", hash_generated_method = "6726A3526EFF1C0252179FA789E17071")
    private char newTrieNode() {
        {
            char[] copy;
            copy = new char[mTrie.length + INCREMENT];
            System.arraycopy(mTrie, 0, copy, 0, mTrie.length);
            mTrie = copy;
        } //End block
        char ret;
        ret = mTrieUsed;
        mTrieUsed += TRIE_SIZEOF;
        char varA87DEB01C5F539E6BDA34829C8EF2368_115475428 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_115475428;
        // ---------- Original Method ----------
        //if (mTrieUsed + TRIE_SIZEOF > mTrie.length) {
            //char[] copy = new char[mTrie.length + INCREMENT];
            //System.arraycopy(mTrie, 0, copy, 0, mTrie.length);
            //mTrie = copy;
        //}
        //char ret = mTrieUsed;
        //mTrieUsed += TRIE_SIZEOF;
        //return ret;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.991 -0400", hash_original_field = "F843573947761E50D4BED916D14D91A5", hash_generated_field = "515861D57E36293D8DA215E6D46DD8D5")

    private static int TRIE_C = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.991 -0400", hash_original_field = "C819392AFBD8C1FF66A68290C2EEE191", hash_generated_field = "6CB1A6B3AD1B64370A219063D66B85D5")

    private static int TRIE_OFF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.991 -0400", hash_original_field = "B87E7BBF06AD287D2FE2F1B7A71D292F", hash_generated_field = "ECC51F70F3FD82E972538C87BB78ABB2")

    private static int TRIE_CHILD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.012 -0400", hash_original_field = "8117DEE9EC7EF4001D67E168A59EB4C0", hash_generated_field = "E3F811118D65787CB871022744BAA471")

    private static int TRIE_NEXT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.012 -0400", hash_original_field = "72BF77CFA305DE86750F2C811D3ACC86", hash_generated_field = "4E7A3C42ACD6590E308FA088CE9F087D")

    private static int TRIE_SIZEOF = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.012 -0400", hash_original_field = "B5E768B7D87C45F5672F6BB7046642F9", hash_generated_field = "4BD8B7851D5365776E2FCBAB9378D7A6")

    private static char TRIE_NULL = (char) -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.012 -0400", hash_original_field = "338CCA93F3F34751EDEB080061BE8417", hash_generated_field = "1DCA7BCD24E2894811B9A0CC8675F180")

    private static int TRIE_ROOT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.012 -0400", hash_original_field = "DE1C80478EF6CA3F4FD689ADB537A833", hash_generated_field = "0E61ECC09E1BE8DDB580F52DF9D60C36")

    private static int INCREMENT = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.012 -0400", hash_original_field = "F3DED0AF5C96C4380594CDEF534B2D67", hash_generated_field = "B86A8970E5C023D009BC7D5CFA035E51")

    private static int DEFAULT = 14337;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.012 -0400", hash_original_field = "CEB9B166F034367C50AD14B9DFF790F9", hash_generated_field = "8E587587CC895C07F59E50573F4C6F9F")

    private static int RIGHT = 9300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.012 -0400", hash_original_field = "7740337A49D534D44BEE5DDBDE2FC6DD", hash_generated_field = "2193FE5B55F6D09F6E5BF7372AB38D87")

    private static AutoText sInstance = new AutoText(Resources.getSystem());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:37.012 -0400", hash_original_field = "6FBEC3E7BB69D1E09ECABF075E18871F", hash_generated_field = "E209496F9F2C9103A6260BCF69D3191B")

    private static Object sLock = new Object();
}

