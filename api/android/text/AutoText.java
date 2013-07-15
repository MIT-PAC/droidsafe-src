package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.android.internal.util.XmlUtils;
import android.view.View;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.util.Locale;

public class AutoText {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.736 -0400", hash_original_field = "5BDF724CD0456C44608769D876789E27", hash_generated_field = "88B4BB6C6C54F768FFBA5254BB72365D")

    private char[] mTrie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.736 -0400", hash_original_field = "A813945620FA1D05C4425C4C401B5023", hash_generated_field = "88631567A4C7FF89A1AFBFB0DA730CFF")

    private char mTrieUsed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.736 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.737 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.737 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.737 -0400", hash_original_method = "09AEE40B99596F23FD7F50F9A174308F", hash_generated_method = "8A758FB35DD76CF0024FB127BB02DD22")
    private  AutoText(Resources resources) {
        mLocale = resources.getConfiguration().locale;
        init(resources);
        // ---------- Original Method ----------
        //mLocale = resources.getConfiguration().locale;
        //init(resources);
    }

    
        @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.738 -0400", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "C0F27518FF1638119E035D4110C0A569")
    private int getSize() {
        int var27DFA0EFE73BCB065533443A05E9DEE4_1705298627 = (mSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328783317 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328783317;
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.740 -0400", hash_original_method = "A395619387E5FA987B6ED6EABB20C725", hash_generated_method = "AA8F8D8C7286D9C46337C4E515CFA918")
    private String lookup(CharSequence src, final int start, final int end) {
        addTaint(end);
        addTaint(start);
        addTaint(src.getTaint());
        int here = mTrie[TRIE_ROOT];
for(int i = start;i < end;i++)
        {
            char c = src.charAt(i);
for(;here != TRIE_NULL;here = mTrie[here + TRIE_NEXT])
            {
    if(c == mTrie[here + TRIE_C])                
                {
    if((i == end - 1) 
                            && (mTrie[here + TRIE_OFF] != TRIE_NULL))                    
                    {
                        int off = mTrie[here + TRIE_OFF];
                        int len = mText.charAt(off);
String varC4791C14A47CB79F698D052F2B83D1C7_474405655 =                         mText.substring(off + 1, off + 1 + len);
                        varC4791C14A47CB79F698D052F2B83D1C7_474405655.addTaint(taint);
                        return varC4791C14A47CB79F698D052F2B83D1C7_474405655;
                    } //End block
                    here = mTrie[here + TRIE_CHILD];
                    break;
                } //End block
            } //End block
    if(here == TRIE_NULL)            
            {
String var540C13E9E156B687226421B24F2DF178_1153554822 =                 null;
                var540C13E9E156B687226421B24F2DF178_1153554822.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1153554822;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_447434378 =         null;
        var540C13E9E156B687226421B24F2DF178_447434378.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_447434378;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.741 -0400", hash_original_method = "E19B6C2A17EB3626AF05ED9F48AE64FD", hash_generated_method = "D29B5C694201C7518617035F18F5C814")
    private void init(Resources r) {
        addTaint(r.getTaint());
        XmlResourceParser parser = r.getXml(com.android.internal.R.xml.autotext);
        StringBuilder right = new StringBuilder(RIGHT);
        mTrie = new char[DEFAULT];
        mTrie[TRIE_ROOT] = TRIE_NULL;
        mTrieUsed = TRIE_ROOT + 1;
        try 
        {
            XmlUtils.beginDocument(parser, "words");
            String odest = "";
            char ooff = 0;
            while
(true)            
            {
                XmlUtils.nextElement(parser);
                String element = parser.getName();
    if(element == null || !(element.equals("word")))                
                {
                    break;
                } //End block
                String src = parser.getAttributeValue(null, "src");
    if(parser.next() == XmlPullParser.TEXT)                
                {
                    String dest = parser.getText();
                    char off;
    if(dest.equals(odest))                    
                    {
                        off = ooff;
                    } //End block
                    else
                    {
                        off = (char) right.length();
                        right.append((char) dest.length());
                        right.append(dest);
                    } //End block
                    add(src, off);
                } //End block
            } //End block
            r.flushLayoutCache();
        } //End block
        catch (XmlPullParserException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1913193631 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1913193631.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1913193631;
        } //End block
        catch (IOException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_466125169 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_466125169.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_466125169;
        } //End block
        finally 
        {
            parser.close();
        } //End block
        mText = right.toString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.743 -0400", hash_original_method = "0D3B451571572F26E1C81E0825865666", hash_generated_method = "AB2F9F3CDA283B47A8F2E1BB5630ACF5")
    private void add(String src, char off) {
        addTaint(src.getTaint());
        int slen = src.length();
        int herep = TRIE_ROOT;
        mSize++;
for(int i = 0;i < slen;i++)
        {
            char c = src.charAt(i);
            boolean found = false;
for(;mTrie[herep] != TRIE_NULL;herep = mTrie[herep] + TRIE_NEXT)
            {
    if(c == mTrie[mTrie[herep] + TRIE_C])                
                {
    if(i == slen - 1)                    
                    {
                        mTrie[mTrie[herep] + TRIE_OFF] = off;
                        return;
                    } //End block
                    herep = mTrie[herep] + TRIE_CHILD;
                    found = true;
                    break;
                } //End block
            } //End block
    if(!found)            
            {
                char node = newTrieNode();
                mTrie[herep] = node;
                mTrie[mTrie[herep] + TRIE_C] = c;
                mTrie[mTrie[herep] + TRIE_OFF] = TRIE_NULL;
                mTrie[mTrie[herep] + TRIE_NEXT] = TRIE_NULL;
                mTrie[mTrie[herep] + TRIE_CHILD] = TRIE_NULL;
    if(i == slen - 1)                
                {
                    mTrie[mTrie[herep] + TRIE_OFF] = off;
                    return;
                } //End block
                herep = mTrie[herep] + TRIE_CHILD;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.744 -0400", hash_original_method = "6974F5A5A1101E98F9450C35EFEECA6C", hash_generated_method = "2170E0117BDDACCC3B22BE4300308E11")
    private char newTrieNode() {
    if(mTrieUsed + TRIE_SIZEOF > mTrie.length)        
        {
            char[] copy = new char[mTrie.length + INCREMENT];
            System.arraycopy(mTrie, 0, copy, 0, mTrie.length);
            mTrie = copy;
        } //End block
        char ret = mTrieUsed;
        mTrieUsed += TRIE_SIZEOF;
        char var2CB9DF9898E55FD0AD829DC202DDBD1C_1042075454 = (ret);
                char varA87DEB01C5F539E6BDA34829C8EF2368_229560023 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_229560023;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.744 -0400", hash_original_field = "F843573947761E50D4BED916D14D91A5", hash_generated_field = "3FE6508EBC729D0B912C75B1B3DE2E5D")

    private static final int TRIE_C = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.744 -0400", hash_original_field = "C819392AFBD8C1FF66A68290C2EEE191", hash_generated_field = "733F356794001EE1BAFE597C5874FCC6")

    private static final int TRIE_OFF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.745 -0400", hash_original_field = "B87E7BBF06AD287D2FE2F1B7A71D292F", hash_generated_field = "B7B2753F5EA07FFBDE831712F6D19202")

    private static final int TRIE_CHILD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.745 -0400", hash_original_field = "8117DEE9EC7EF4001D67E168A59EB4C0", hash_generated_field = "8867057A6192EFA48A711D904826054A")

    private static final int TRIE_NEXT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.745 -0400", hash_original_field = "72BF77CFA305DE86750F2C811D3ACC86", hash_generated_field = "1F844D101640222C3A1D40C43FB4C786")

    private static final int TRIE_SIZEOF = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.745 -0400", hash_original_field = "B5E768B7D87C45F5672F6BB7046642F9", hash_generated_field = "07E61E77484A4D134C2E87A238AFD5E0")

    private static final char TRIE_NULL = (char) -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.745 -0400", hash_original_field = "338CCA93F3F34751EDEB080061BE8417", hash_generated_field = "F4888766DAE4DA3FE4E89A8E419D79F3")

    private static final int TRIE_ROOT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.745 -0400", hash_original_field = "DE1C80478EF6CA3F4FD689ADB537A833", hash_generated_field = "AFE8F2ECAFDB9F5B221DBA3F6D2395CC")

    private static final int INCREMENT = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.745 -0400", hash_original_field = "F3DED0AF5C96C4380594CDEF534B2D67", hash_generated_field = "4962220A561069893B9B4182571E46EF")

    private static final int DEFAULT = 14337;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.745 -0400", hash_original_field = "CEB9B166F034367C50AD14B9DFF790F9", hash_generated_field = "A173C71035C72942C03904EBEB219845")

    private static final int RIGHT = 9300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.745 -0400", hash_original_field = "7740337A49D534D44BEE5DDBDE2FC6DD", hash_generated_field = "2193FE5B55F6D09F6E5BF7372AB38D87")

    private static AutoText sInstance = new AutoText(Resources.getSystem());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.745 -0400", hash_original_field = "6FBEC3E7BB69D1E09ECABF075E18871F", hash_generated_field = "E209496F9F2C9103A6260BCF69D3191B")

    private static Object sLock = new Object();
}

