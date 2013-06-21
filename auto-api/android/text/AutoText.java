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
    private char[] mTrie;
    private char mTrieUsed;
    private String mText;
    private Locale mLocale;
    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.970 -0400", hash_original_method = "09AEE40B99596F23FD7F50F9A174308F", hash_generated_method = "F81928E74521A5140C5FE9D1CFE76DD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AutoText(Resources resources) {
        dsTaint.addTaint(resources.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.970 -0400", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "2AB81C377AFED9D1E212AD6D2B23A6D9")
    @DSModeled(DSC.SAFE)
    private int getSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.971 -0400", hash_original_method = "A395619387E5FA987B6ED6EABB20C725", hash_generated_method = "BF18BC593757F294324DBE5BCD1B22C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String lookup(CharSequence src, final int start, final int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(src);
        dsTaint.addTaint(end);
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
                                String varC331E6B26157BE5686B0948F52B40E9E_933765444 = (mText.substring(off + 1, off + 1 + len));
                            } //End block
                            here = mTrie[here + TRIE_CHILD];
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.971 -0400", hash_original_method = "E19B6C2A17EB3626AF05ED9F48AE64FD", hash_generated_method = "5ABDB4710F28973A60AD9884764C0BE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(Resources r) {
        dsTaint.addTaint(r.dsTaint);
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
                    boolean var2D95B92CEF5A452FD7925DF9FBF92370_904611961 = (element == null || !(element.equals("word")));
                } //End collapsed parenthetic
                String src;
                src = parser.getAttributeValue(null, "src");
                {
                    boolean varD9C33DAEA9F0FA8AA020A07656F3B790_1515643782 = (parser.next() == XmlPullParser.TEXT);
                    {
                        String dest;
                        dest = parser.getText();
                        char off;
                        {
                            boolean varDF0A86F34F54C11F6A06F06A2C96505D_720643111 = (dest.equals(odest));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.972 -0400", hash_original_method = "0D3B451571572F26E1C81E0825865666", hash_generated_method = "7D247371EBB004E530F56316DEEA0B59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void add(String src, char off) {
        dsTaint.addTaint(off);
        dsTaint.addTaint(src);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.973 -0400", hash_original_method = "6974F5A5A1101E98F9450C35EFEECA6C", hash_generated_method = "339DAB58E8F9E39589A2E9CDC91E37AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintChar();
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

    
    private static final int TRIE_C = 0;
    private static final int TRIE_OFF = 1;
    private static final int TRIE_CHILD = 2;
    private static final int TRIE_NEXT = 3;
    private static final int TRIE_SIZEOF = 4;
    private static final char TRIE_NULL = (char) -1;
    private static final int TRIE_ROOT = 0;
    private static final int INCREMENT = 1024;
    private static final int DEFAULT = 14337;
    private static final int RIGHT = 9300;
    private static AutoText sInstance = new AutoText(Resources.getSystem());
    private static Object sLock = new Object();
}

