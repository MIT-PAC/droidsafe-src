package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Locale;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.view.View;

import com.android.internal.util.XmlUtils;






public class AutoText {

    /**
     * Returns the instance of AutoText. If the locale has changed, it will create a new
     * instance of AutoText for the locale.
     * @param view to get the resources from
     * @return the single instance of AutoText
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.605 -0500", hash_original_method = "B963EC3FF6AF03FE47485769AA0F03D8", hash_generated_method = "532C51C8F51A590EC036E55B5360FFCE")
    
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
    
    /**
     * Retrieves a possible spelling correction for the specified range
     * of text.  Returns null if no correction can be found.
     * The View is used to get the current Locale and Resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.608 -0500", hash_original_method = "935BB3B6BD2904ECB9104D13E520B1D5", hash_generated_method = "1DF004E5C6C7237197C1BF14A887866E")
    
public static String get(CharSequence src, final int start, final int end,
                             View view) {
        return getInstance(view).lookup(src, start, end);
    }

    /**
     * Returns the size of the auto text dictionary. The return value can be zero if there is
     * no auto correction data available for the current locale.
     * @param view used to retrieve the current Locale and Resources.
     * @return the number of entries in the auto text dictionary
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.611 -0500", hash_original_method = "7AF3B8B864AEDF2653F262298A569C32", hash_generated_method = "02CCA7C4FE6C8D8101D828F51FC687EA")
    
public static int getSize(View view) {

        return getInstance(view).getSize(); 
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.550 -0500", hash_original_field = "7ACD966E718CD9FAE11DE97982CCD219", hash_generated_field = "2CEAA53A70CED92FC9849DB14E929503")

    //     char c;
    //     int off;
    //     struct trie *child;
    //     struct trie *next;
    // };

    private static final int TRIE_C = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.553 -0500", hash_original_field = "0B3DFC490D15798DF5116FEB9BC89C69", hash_generated_field = "733F356794001EE1BAFE597C5874FCC6")

    private static final int TRIE_OFF = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.556 -0500", hash_original_field = "0B4AFCDA0EB29737CAAAC10E11C80622", hash_generated_field = "B7B2753F5EA07FFBDE831712F6D19202")

    private static final int TRIE_CHILD = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.559 -0500", hash_original_field = "6F38100F993FD4DA56B3FC88A996BCC1", hash_generated_field = "8867057A6192EFA48A711D904826054A")

    private static final int TRIE_NEXT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.562 -0500", hash_original_field = "404EFA550AAC0DD93669441B94730B89", hash_generated_field = "1F844D101640222C3A1D40C43FB4C786")


    private static final int TRIE_SIZEOF = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.565 -0500", hash_original_field = "735CD36D1D3B61261EB9D9BAB8CB2423", hash_generated_field = "07E61E77484A4D134C2E87A238AFD5E0")

    private static final char TRIE_NULL = (char) -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.568 -0500", hash_original_field = "6C7AB0D9A31B79A3E06C5C3C7B61871A", hash_generated_field = "F4888766DAE4DA3FE4E89A8E419D79F3")

    private static final int TRIE_ROOT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.571 -0500", hash_original_field = "78E41A0FA92C32E4CF5FC0672065B3F4", hash_generated_field = "AFE8F2ECAFDB9F5B221DBA3F6D2395CC")


    private static final int INCREMENT = 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.574 -0500", hash_original_field = "DCF95085792D8BE9D2576CF23950BAEA", hash_generated_field = "4962220A561069893B9B4182571E46EF")


    private static final int DEFAULT = 14337;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.578 -0500", hash_original_field = "75675FCA6F7A137C0B5CEDEC64AA77EE", hash_generated_field = "A173C71035C72942C03904EBEB219845")


    private static final int RIGHT = 9300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.581 -0500", hash_original_field = "CE1EE35B21242B56128D6BE8E887DD28", hash_generated_field = "2193FE5B55F6D09F6E5BF7372AB38D87")


    private static AutoText sInstance = new AutoText(Resources.getSystem());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.584 -0500", hash_original_field = "3892ABA92B7F95295E8CFDAE8B79791E", hash_generated_field = "E209496F9F2C9103A6260BCF69D3191B")

    private static Object sLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.586 -0500", hash_original_field = "505694FB7B011922830C19CD0C55C329", hash_generated_field = "A4A1BE76C5F63385249F95F73443C63F")

    //
    // Note the assumption that the destination strings total less than
    // 64K characters and that the trie for the source side totals less
    // than 64K chars/offsets/child pointers/next pointers.
    //
    // This seems very safe for English (currently 7K of destination,
    // 14K of trie) but may need to be revisited.

    private char[] mTrie;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.589 -0500", hash_original_field = "737FB1082DA6E93D11E6F86ECB58CDF3", hash_generated_field = "88631567A4C7FF89A1AFBFB0DA730CFF")

    private char mTrieUsed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.592 -0500", hash_original_field = "5C1E1D7AA24FFCA320ADE83B66FB0AC4", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.595 -0500", hash_original_field = "D959780368C6CA232CF8C3906CDDEDF3", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.598 -0500", hash_original_field = "205262C28D2B190751535A4911B3B259", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.602 -0500", hash_original_method = "09AEE40B99596F23FD7F50F9A174308F", hash_generated_method = "BEFAB2CB575C283560FE48E6C86967A3")
    
private AutoText(Resources resources) {
        mLocale = resources.getConfiguration().locale;
        init(resources);
    }

    /**
     * Returns the size of the dictionary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.613 -0500", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "078FDE03C7E88FE97FCC849E1A4FF824")
    
private int getSize() {
        return mSize;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.616 -0500", hash_original_method = "A395619387E5FA987B6ED6EABB20C725", hash_generated_method = "05E793881A14CB18369F587898F9ED46")
    
private String lookup(CharSequence src, final int start, final int end) {
        int here = mTrie[TRIE_ROOT];

        for (int i = start; i < end; i++) {
            char c = src.charAt(i);

            for (; here != TRIE_NULL; here = mTrie[here + TRIE_NEXT]) {
                if (c == mTrie[here + TRIE_C]) {
                    if ((i == end - 1) 
                            && (mTrie[here + TRIE_OFF] != TRIE_NULL)) {
                        int off = mTrie[here + TRIE_OFF];
                        int len = mText.charAt(off);

                        return mText.substring(off + 1, off + 1 + len);
                    }

                    here = mTrie[here + TRIE_CHILD];
                    break;
                }
            }

            if (here == TRIE_NULL) {
                return null;
            }
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.620 -0500", hash_original_method = "E19B6C2A17EB3626AF05ED9F48AE64FD", hash_generated_method = "B5E6AFF462B11169A04E76BBB3111B8F")
    
private void init(Resources r) {
        XmlResourceParser parser = r.getXml(com.android.internal.R.xml.autotext);

        StringBuilder right = new StringBuilder(RIGHT);
        mTrie = new char[DEFAULT];
        mTrie[TRIE_ROOT] = TRIE_NULL;
        mTrieUsed = TRIE_ROOT + 1;

        try {
            XmlUtils.beginDocument(parser, "words");
            String odest = "";
            char ooff = 0;

            while (true) {
                XmlUtils.nextElement(parser);

                String element = parser.getName(); 
                if (element == null || !(element.equals("word"))) {
                    break;
                }

                String src = parser.getAttributeValue(null, "src");
                if (parser.next() == XmlPullParser.TEXT) {
                    String dest = parser.getText();
                    char off;

                    if (dest.equals(odest)) {
                        off = ooff;
                    } else {
                        off = (char) right.length();
                        right.append((char) dest.length());
                        right.append(dest);
                    }

                    add(src, off);
                }
            }

            // Don't let Resources cache a copy of all these strings.
            r.flushLayoutCache();
        } catch (XmlPullParserException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            parser.close();
        }

        mText = right.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.624 -0500", hash_original_method = "0D3B451571572F26E1C81E0825865666", hash_generated_method = "D354E0B76BC0B70613FD17D65D475832")
    
private void add(String src, char off) {
        int slen = src.length();
        int herep = TRIE_ROOT;
        // Keep track of the size of the dictionary
        mSize++;
        
        for (int i = 0; i < slen; i++) {
            char c = src.charAt(i);
            boolean found = false;

            for (; mTrie[herep] != TRIE_NULL;
                    herep = mTrie[herep] + TRIE_NEXT) {
                if (c == mTrie[mTrie[herep] + TRIE_C]) {
                    // There is a node for this letter, and this is the
                    // end, so fill in the right hand side fields.

                    if (i == slen - 1) {
                        mTrie[mTrie[herep] + TRIE_OFF] = off;
                        return;
                    }

                    // There is a node for this letter, and we need
                    // to go deeper into it to fill in the rest.

                    herep = mTrie[herep] + TRIE_CHILD;
                    found = true;
                    break;
                }
            }

            if (!found) {
                // No node for this letter yet.  Make one.

                char node = newTrieNode();
                mTrie[herep] = node;

                mTrie[mTrie[herep] + TRIE_C] = c;
                mTrie[mTrie[herep] + TRIE_OFF] = TRIE_NULL;
                mTrie[mTrie[herep] + TRIE_NEXT] = TRIE_NULL;
                mTrie[mTrie[herep] + TRIE_CHILD] = TRIE_NULL;

                // If this is the end of the word, fill in the offset.

                if (i == slen - 1) {
                    mTrie[mTrie[herep] + TRIE_OFF] = off;
                    return;
                }

                // Otherwise, step in deeper and go to the next letter.

                herep = mTrie[herep] + TRIE_CHILD;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.627 -0500", hash_original_method = "6974F5A5A1101E98F9450C35EFEECA6C", hash_generated_method = "7434CE68F8D446D88144B235481167CA")
    
private char newTrieNode() {
        if (mTrieUsed + TRIE_SIZEOF > mTrie.length) {
            char[] copy = new char[mTrie.length + INCREMENT];
            System.arraycopy(mTrie, 0, copy, 0, mTrie.length);
            mTrie = copy;
        }

        char ret = mTrieUsed;
        mTrieUsed += TRIE_SIZEOF;

        return ret;
    }
}

