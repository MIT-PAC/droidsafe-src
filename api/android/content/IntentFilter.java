package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PatternMatcher;
import android.util.AndroidException;
import android.util.Printer;

import com.android.internal.util.XmlUtils;

public class IntentFilter implements Parcelable {

    // These functions are the start of more optimized code for managing
    // the string sets...  not yet implemented.

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.751 -0500", hash_original_method = "DA21299454DC334FA5FD853D1BFD2D91", hash_generated_method = "0931E9784E87BD4E6C0385E8116E742F")
    
private static int findStringInSet(String[] set, String string,
            int[] lengths, int lenPos) {
        if (set == null) return -1;
        final int N = lengths[lenPos];
        for (int i=0; i<N; i++) {
            if (set[i].equals(string)) return i;
        }
        return -1;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.753 -0500", hash_original_method = "77C7ED281F73E32FAEAB4043A75B2222", hash_generated_method = "6E55CE27038C83CA2C9F4EF6BA6D0080")
    
private static String[] addStringToSet(String[] set, String string,
            int[] lengths, int lenPos) {
        if (findStringInSet(set, string, lengths, lenPos) >= 0) return set;
        if (set == null) {
            set = new String[2];
            set[0] = string;
            lengths[lenPos] = 1;
            return set;
        }
        final int N = lengths[lenPos];
        if (N < set.length) {
            set[N] = string;
            lengths[lenPos] = N+1;
            return set;
        }

        String[] newSet = new String[(N*3)/2 + 2];
        System.arraycopy(set, 0, newSet, 0, N);
        set = newSet;
        set[N] = string;
        lengths[lenPos] = N+1;
        return set;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.756 -0500", hash_original_method = "5DADFEE73D89E7689BB0B9FCBD7E5BBE", hash_generated_method = "3C1DD4EDF5A37BB60FCA2D86C2F478E6")
    
private static String[] removeStringFromSet(String[] set, String string,
            int[] lengths, int lenPos) {
        int pos = findStringInSet(set, string, lengths, lenPos);
        if (pos < 0) return set;
        final int N = lengths[lenPos];
        if (N > (set.length/4)) {
            int copyLen = N-(pos+1);
            if (copyLen > 0) {
                System.arraycopy(set, pos+1, set, pos, copyLen);
            }
            set[N-1] = null;
            lengths[lenPos] = N-1;
            return set;
        }

        String[] newSet = new String[set.length/3];
        if (pos > 0) System.arraycopy(set, 0, newSet, 0, pos);
        if ((pos+1) < N) System.arraycopy(set, pos+1, newSet, pos, N-(pos+1));
        return newSet;
    }

    /**
     * Create a new IntentFilter instance with a specified action and MIME
     * type, where you know the MIME type is correctly formatted.  This catches
     * the {@link MalformedMimeTypeException} exception that the constructor
     * can call and turns it into a runtime exception.
     *
     * @param action The action to match, i.e. Intent.ACTION_VIEW.
     * @param dataType The type to match, i.e. "vnd.android.cursor.dir/person".
     *
     * @return A new IntentFilter for the given action and type.
     *
     * @see #IntentFilter(String, String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.766 -0500", hash_original_method = "A1D1078D79ADBFCB876B04A67BE8587A", hash_generated_method = "64624900F48215366B67C691CCF1AFBA")
    
public static IntentFilter create(String action, String dataType) {
        try {
            return new IntentFilter(action, dataType);
        } catch (MalformedMimeTypeException e) {
            throw new RuntimeException("Bad MIME type", e);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.667 -0500", hash_original_field = "E55682C9C7FDAE9334A4C2C5AD3CD442", hash_generated_field = "C4BAA85D0E2D827D81D6FD077E15ADAB")

    private static final String SGLOB_STR = "sglob";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.669 -0500", hash_original_field = "4A4D165EEA212D2A7BB9F0F1C917DE49", hash_generated_field = "3FD2C7D31E487D70A6AA6204637B2899")

    private static final String PREFIX_STR = "prefix";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.671 -0500", hash_original_field = "BA5B28F042DADBD770D5F586A8C333ED", hash_generated_field = "6210DECFA06880B6974267C6646EE816")

    private static final String LITERAL_STR = "literal";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.674 -0500", hash_original_field = "708F1A574DCD2C63A43690A711A7ED78", hash_generated_field = "AE2B2A8BA02A502564CB5583944A3146")

    private static final String PATH_STR = "path";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.676 -0500", hash_original_field = "DDA6B5B9AB486686E2C5FAAB4E8116A9", hash_generated_field = "013F1A4753121A357F8D4078614DB5E9")

    private static final String PORT_STR = "port";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.679 -0500", hash_original_field = "7191E92A7D7A31CAE2EA6B3EB1696D1A", hash_generated_field = "D18646C1A58B5E7B6FA605CC5A4DC7F3")

    private static final String HOST_STR = "host";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.681 -0500", hash_original_field = "6C8808830D27DEA3D943ACFEB6760BDC", hash_generated_field = "1F480DB7C369FC6CBAE0E8C3FA3BF415")

    private static final String AUTH_STR = "auth";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.683 -0500", hash_original_field = "D6705445FD69B0E43ED6C4EE68CE19B6", hash_generated_field = "EA900D1EEAE42F3BD549A09336FAB017")

    private static final String SCHEME_STR = "scheme";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.685 -0500", hash_original_field = "E3A88F24BA754B6385E7C641901D52E3", hash_generated_field = "4B774CE7E444A55B1B5AD2184D9A15CA")

    private static final String TYPE_STR = "type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.688 -0500", hash_original_field = "770E9914CC2DCAE43087CDA95DB531E5", hash_generated_field = "C2ADBD80B18293A0640432B18AE1AF15")

    private static final String CAT_STR = "cat";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.691 -0500", hash_original_field = "D54E209A0D983CD7137E5FDAAB92AAC2", hash_generated_field = "21D10217770299F078A52DD982CBB332")

    private static final String NAME_STR = "name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.694 -0500", hash_original_field = "0CCE088BF52CED45B6CD503F877D1590", hash_generated_field = "35EF60995ACCB10C97AD2C3A5730D090")

    private static final String ACTION_STR = "action";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.696 -0500", hash_original_field = "2D220FB47666DD5B57700A3D18B133EE", hash_generated_field = "6027B3B34EF275EF0258CDA7F6C44B06")

    public static final int SYSTEM_HIGH_PRIORITY = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.699 -0500", hash_original_field = "A9A0BE979219D5175C8DABD4805245FB", hash_generated_field = "0B01181E7D37C91380237FEC68D6D2D3")

    public static final int SYSTEM_LOW_PRIORITY = -1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.701 -0500", hash_original_field = "28E44CED487A34B53C221C78B38E8D82", hash_generated_field = "29606CB5EA802A3FC60CBE3892A8C231")

    public static final int MATCH_CATEGORY_MASK = 0xfff0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.703 -0500", hash_original_field = "4F80A630752E52D0BAA88094250C3C4D", hash_generated_field = "B34195AB6941F69DE5EAC54045013E42")

    public static final int MATCH_ADJUSTMENT_MASK = 0x000ffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.706 -0500", hash_original_field = "5AEC1E044F6F67CAFADEDFD963F0885B", hash_generated_field = "C9832C97F6DA3DADA2A2565BDBACE888")

    public static final int MATCH_ADJUSTMENT_NORMAL = 0x8000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.708 -0500", hash_original_field = "2E511E7FB16D9BE2B50A1C3B36F88654", hash_generated_field = "A1B64111ED1BB3921E4D97B9744154C1")

    public static final int MATCH_CATEGORY_EMPTY = 0x0100000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.710 -0500", hash_original_field = "85153B36EB85C3348A87A9615B647A91", hash_generated_field = "C12E4AC6561BC99691B6248231FD861A")

    public static final int MATCH_CATEGORY_SCHEME = 0x0200000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.713 -0500", hash_original_field = "8B9E08894B2E4C4CC941103832175B81", hash_generated_field = "FE262DE457FD58C71A1505F0420E15FE")

    public static final int MATCH_CATEGORY_HOST = 0x0300000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.715 -0500", hash_original_field = "BD512053D4FCA7DDC92237FA6E88F225", hash_generated_field = "D10A1DB2D1A22224D638E95D16CE16B9")

    public static final int MATCH_CATEGORY_PORT = 0x0400000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.718 -0500", hash_original_field = "3CBC8C4615A73A8165B1484E82142A5E", hash_generated_field = "733A5B911AC6A408B5E5529505EC7DCE")

    public static final int MATCH_CATEGORY_PATH = 0x0500000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.720 -0500", hash_original_field = "82768DA9020CD35C1A7FECD580AC3338", hash_generated_field = "EF521D11C4B126106700F8F59796E3EC")

    public static final int MATCH_CATEGORY_TYPE = 0x0600000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.723 -0500", hash_original_field = "96A2264AB9CA90D609F1B40EF0492817", hash_generated_field = "77C0C8B7C43E88DB2627254044127D30")

    public static final int NO_MATCH_TYPE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.725 -0500", hash_original_field = "DC62F17710055D42F83B4CF67B82E9B4", hash_generated_field = "994792ED93AAD5E31FA521805925B110")

    public static final int NO_MATCH_DATA = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.728 -0500", hash_original_field = "1E05EE6794BA303BF7F30727BF2EE8BB", hash_generated_field = "E5BEBE595B019031029BE6CBC65E803A")

    public static final int NO_MATCH_ACTION = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.730 -0500", hash_original_field = "0DBBFA907CAF845CD798E2BE1DBB963D", hash_generated_field = "5B8788CD30AACDBD788AC513C1CD39AE")

    public static final int NO_MATCH_CATEGORY = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.564 -0400", hash_original_field = "DCD9426D45070A28AEA2BF645CBE4999", hash_generated_field = "665198F8F263BBC69C46C9D3C09D5B07")

    public static final Parcelable.Creator<IntentFilter> CREATOR
            = new Parcelable.Creator<IntentFilter>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.909 -0500", hash_original_method = "6AFABEC7B0F2CE7FB89EA092702B6037", hash_generated_method = "A4E611978E149742988D9CAA7F3D195D")
        
public IntentFilter createFromParcel(Parcel source) {
            return new IntentFilter(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.912 -0500", hash_original_method = "DE4837E283E52263DB6E87C79DDB9140", hash_generated_method = "AA90E990A64CA3A2F9CFB6D67737D299")
        
public IntentFilter[] newArray(int size) {
            return new IntentFilter[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.732 -0500", hash_original_field = "1D8CA7654CC48BAF402334392A1619BF", hash_generated_field = "032B46B6D9E42E1E80E269F8E583852A")

    private int mPriority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.734 -0500", hash_original_field = "1C01DCF3CAD6F1F8B4C99696F3E8A2C8", hash_generated_field = "B7B787904E751334D4C6C5E9190CBECB")

    @DSVAModeled
    private  String mActions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.737 -0500", hash_original_field = "3FA8ABFF8F3A29D5E46D1842F4E37CCD", hash_generated_field = "DF1B13D35CEEB5232DEB8422E072E169")

    private ArrayList<String> mCategories = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.739 -0500", hash_original_field = "C86BC44BB7486732DFCE4230CAE0D3E5", hash_generated_field = "D6C69DEDF341F4A4196AEA26E81D24A7")

    private ArrayList<String> mDataSchemes = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.741 -0500", hash_original_field = "49B33C9415691552BCB1FCE6D3901D6B", hash_generated_field = "C318D366A8228836F69A6B4BDDBFB506")

    private ArrayList<AuthorityEntry> mDataAuthorities = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.744 -0500", hash_original_field = "ED5161411B31CEB4187B897C71E9F686", hash_generated_field = "2207044C23DD28F016FBFC7451C9D66A")

    private ArrayList<PatternMatcher> mDataPaths = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.746 -0500", hash_original_field = "85E613F84E208E29787CF516CB1D2553", hash_generated_field = "06256A3E596C9EB087048F541BEAB278")

    private ArrayList<String> mDataTypes = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.748 -0500", hash_original_field = "4E9BB20DDD719BB7B01F0A2592C02543", hash_generated_field = "A768E3466CCFB1BF3BC36D8E0C71D999")

    private boolean mHasPartialTypes = false;

    /**
     * New empty IntentFilter.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.768 -0500", hash_original_method = "E570235BD10D63A46D952627D4823B55", hash_generated_method = "873E5D48980AE16EC4645A8878C78F5B")
    
public IntentFilter() {
        mPriority = 0;
    }

    /**
     * New IntentFilter that matches a single action with no data.  If
     * no data characteristics are subsequently specified, then the
     * filter will only match intents that contain no data.
     *
     * @param action The action to match, i.e. Intent.ACTION_MAIN.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.771 -0500", hash_original_method = "6BE32B941606799E1C4582399143D6DE", hash_generated_method = "9D26B14C7A6A2DAA4F9CFE07029C4107")
    
public IntentFilter(String action) {
        mPriority = 0;
        addAction(action);
    }

    /**
     * New IntentFilter that matches a single action and data type.
     *
     * <p><em>Note: MIME type matching in the Android framework is
     * case-sensitive, unlike formal RFC MIME types.  As a result,
     * you should always write your MIME types with lower case letters,
     * and any MIME types you receive from outside of Android should be
     * converted to lower case before supplying them here.</em></p>
     *
     * <p>Throws {@link MalformedMimeTypeException} if the given MIME type is
     * not syntactically correct.
     *
     * @param action The action to match, i.e. Intent.ACTION_VIEW.
     * @param dataType The type to match, i.e. "vnd.android.cursor.dir/person".
     *
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.773 -0500", hash_original_method = "6F03ACB8C3DEEE507BC72687512BE15B", hash_generated_method = "91B753132D963E5C5F3D2E690A4320DD")
    
public IntentFilter(String action, String dataType)
        throws MalformedMimeTypeException {
        mPriority = 0;
        addAction(action);
        addDataType(dataType);
    }

    /**
     * New IntentFilter containing a copy of an existing filter.
     *
     * @param o The original filter to copy.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.776 -0500", hash_original_method = "1836401D6B82BE6CCBD088E7B5026D41", hash_generated_method = "1E198A53AE5B2BE3C2A90D8BCF0759DF")
    
public IntentFilter(IntentFilter o) {
        mPriority = o.mPriority;
        mActions = o.mActions;
        if (o.mCategories != null) {
            mCategories = new ArrayList<String>(o.mCategories);
        }
        if (o.mDataTypes != null) {
            mDataTypes = new ArrayList<String>(o.mDataTypes);
        }
        if (o.mDataSchemes != null) {
            mDataSchemes = new ArrayList<String>(o.mDataSchemes);
        }
        if (o.mDataAuthorities != null) {
            mDataAuthorities = new ArrayList<AuthorityEntry>(o.mDataAuthorities);
        }
        if (o.mDataPaths != null) {
            mDataPaths = new ArrayList<PatternMatcher>(o.mDataPaths);
        }
        mHasPartialTypes = o.mHasPartialTypes;
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.924 -0500", hash_original_method = "0A18E8175DAFA9E0ECB5A7A15F664AD8", hash_generated_method = "6EE529B66EC18E565826F7115C1F962E")
    
private IntentFilter(Parcel source) {
        mActions = source.readString();
        if (source.readInt() != 0) {
            mCategories = new ArrayList<String>();
            source.readStringList(mCategories);
        }
        if (source.readInt() != 0) {
            mDataSchemes = new ArrayList<String>();
            source.readStringList(mDataSchemes);
        }
        if (source.readInt() != 0) {
            mDataTypes = new ArrayList<String>();
            source.readStringList(mDataTypes);
        }
        int N = source.readInt();
        if (N > 0) {
            mDataAuthorities = new ArrayList<AuthorityEntry>();
            for (int i=0; i<N; i++) {
                mDataAuthorities.add(new AuthorityEntry(source));
            }
        }
        N = source.readInt();
        if (N > 0) {
            mDataPaths = new ArrayList<PatternMatcher>();
            for (int i=0; i<N; i++) {
                mDataPaths.add(new PatternMatcher(source));
            }
        }
        mPriority = source.readInt();
        mHasPartialTypes = source.readInt() > 0;
    }
    /**
     * Modify priority of this filter.  The default priority is 0. Positive
     * values will be before the default, lower values will be after it.
     * Applications must use a value that is larger than
     * {@link #SYSTEM_LOW_PRIORITY} and smaller than
     * {@link #SYSTEM_HIGH_PRIORITY} .
     *
     * @param priority The new priority value.
     *
     * @see #getPriority
     * @see #SYSTEM_LOW_PRIORITY
     * @see #SYSTEM_HIGH_PRIORITY
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.779 -0500", hash_original_method = "1AF904ED06333BC0001A5A8D0FC8E3CC", hash_generated_method = "F821DA72088707AF3D4A2AB2E00A960A")
    
public final void setPriority(int priority) {
        mPriority = priority;
    }

    /**
     * Return the priority of this filter.
     *
     * @return The priority of the filter.
     *
     * @see #setPriority
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.781 -0500", hash_original_method = "4CF75B39A2F3F4074ED78E7B55CDB45C", hash_generated_method = "617FE6A07A964A96153B897AEDF65E42")
    
public final int getPriority() {
        return mPriority;
    }

    /**
     * Add a new Intent action to match against.  If any actions are included
     * in the filter, then an Intent's action must be one of those values for
     * it to match.  If no actions are included, the Intent action is ignored.
     *
     * @param action Name of the action to match, i.e. Intent.ACTION_VIEW.
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.784 -0500", hash_original_method = "FFF5B803FCB58F324812D605B6C9CE62", hash_generated_method = "3CBB35A7E6A8533169E7E4AFDAFF741D")
    
public final void addAction(String action) {
        mActions = action;
    }

    /**
     * Return the number of actions in the filter.
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.786 -0500", hash_original_method = "77921182B442B1D522A9772E07DC4CA3", hash_generated_method = "0D6591890E76CE60B3E65B000F6BC744")
    
public final int countActions() {
        return 1;
    }

    /**
     * Return an action in the filter.
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.788 -0500", hash_original_method = "50CEFE8EA652B37B9EBFC8EA367BBC71", hash_generated_method = "CCCD1EB514435FFA0F2B8D27E682ABE9")
    
public final String getAction(int index) {
        return mActions;
    }

    /**
     * Is the given action included in the filter?  Note that if the filter
     * does not include any actions, false will <em>always</em> be returned.
     *
     * @param action The action to look for.
     *
     * @return True if the action is explicitly mentioned in the filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.790 -0500", hash_original_method = "9D48CC1056269867443B9FC005D01764", hash_generated_method = "E11D4D17B078E86A23C0ADE548B9A036")
    
public final boolean hasAction(String action) {
        return true;
    }

    /**
     * Match this filter against an Intent's action.  If the filter does not
     * specify any actions, the match will always fail.
     *
     * @param action The desired action to look for.
     *
     * @return True if the action is listed in the filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.792 -0500", hash_original_method = "984560EB63068E6413989919BB90D187", hash_generated_method = "00E0F0DA4A4EC476E43189431359F691")
    
public final boolean matchAction(String action) {
        return hasAction(action);
    }

    /**
     * Return an iterator over the filter's actions.  If there are no actions,
     * returns null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.795 -0500", hash_original_method = "91B40E19A4EE68D85BFA3F1F256EBA72", hash_generated_method = "C97A7DCA62EDED3DB3829661D6065AF8")
    
public final Iterator<String> actionsIterator() {
        ArrayList<String> actions = new ArrayList<String>();
        actions.add(mActions);
        return mActions != null ? actions.iterator() : null;
    }

    /**
     * Add a new Intent data type to match against.  If any types are
     * included in the filter, then an Intent's data must be <em>either</em>
     * one of these types <em>or</em> a matching scheme.  If no data types
     * are included, then an Intent will only match if it specifies no data.
     *
     * <p><em>Note: MIME type matching in the Android framework is
     * case-sensitive, unlike formal RFC MIME types.  As a result,
     * you should always write your MIME types with lower case letters,
     * and any MIME types you receive from outside of Android should be
     * converted to lower case before supplying them here.</em></p>
     *
     * <p>Throws {@link MalformedMimeTypeException} if the given MIME type is
     * not syntactically correct.
     *
     * @param type Name of the data type to match, i.e. "vnd.android.cursor.dir/person".
     *
     * @see #matchData
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.798 -0500", hash_original_method = "B72DE1FACB480BB8E2AD802A23898A2F", hash_generated_method = "F9B59F41521F6B52295E07D850A64989")
    
public final void addDataType(String type)
        throws MalformedMimeTypeException {
        final int slashpos = type.indexOf('/');
        final int typelen = type.length();
        if (slashpos > 0 && typelen >= slashpos+2) {
            if (mDataTypes == null) mDataTypes = new ArrayList<String>();
            if (typelen == slashpos+2 && type.charAt(slashpos+1) == '*') {
                String str = type.substring(0, slashpos);
                if (!mDataTypes.contains(str)) {
                    mDataTypes.add(str.intern());
                }
                mHasPartialTypes = true;
            } else {
                if (!mDataTypes.contains(type)) {
                    mDataTypes.add(type.intern());
                }
            }
            return;
        }

        throw new MalformedMimeTypeException(type);
    }

    /**
     * Is the given data type included in the filter?  Note that if the filter
     * does not include any type, false will <em>always</em> be returned.
     *
     * @param type The data type to look for.
     *
     * @return True if the type is explicitly mentioned in the filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.800 -0500", hash_original_method = "9AF334B8B7AF494EC1E65710EFD1F300", hash_generated_method = "20811D01627BCC2F4CB093CF77E0D3FB")
    
public final boolean hasDataType(String type) {
        return mDataTypes != null && findMimeType(type);
    }

    /**
     * Return the number of data types in the filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.802 -0500", hash_original_method = "9C43102AEBDE030DD3A73C704DCFC758", hash_generated_method = "ED738DDC5DCEE837AA72AA1B9C5B8A26")
    
public final int countDataTypes() {
        return mDataTypes != null ? mDataTypes.size() : 0;
    }

    /**
     * Return a data type in the filter.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.804 -0500", hash_original_method = "1020E9310C4CEB3D9A899FFC3406F498", hash_generated_method = "AEB722B002E6D0EA415047FB37870532")
    
public final String getDataType(int index) {
        return mDataTypes.get(index);
    }

    /**
     * Return an iterator over the filter's data types.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.806 -0500", hash_original_method = "E14DF72F5869874CC38AD67447F5264E", hash_generated_method = "127365361841BB38033FE96228DFD635")
    
public final Iterator<String> typesIterator() {
        return mDataTypes != null ? mDataTypes.iterator() : null;
    }

    /**
     * Add a new Intent data scheme to match against.  If any schemes are
     * included in the filter, then an Intent's data must be <em>either</em>
     * one of these schemes <em>or</em> a matching data type.  If no schemes
     * are included, then an Intent will match only if it includes no data.
     *
     * <p><em>Note: scheme matching in the Android framework is
     * case-sensitive, unlike formal RFC schemes.  As a result,
     * you should always write your schemes with lower case letters,
     * and any schemes you receive from outside of Android should be
     * converted to lower case before supplying them here.</em></p>
     *
     * @param scheme Name of the scheme to match, i.e. "http".
     *
     * @see #matchData
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.808 -0500", hash_original_method = "5610D5819C8C8974F702B3F76798B195", hash_generated_method = "1F9003E68C7D13469DB1AA0AEBE99964")
    
public final void addDataScheme(String scheme) {
        if (mDataSchemes == null) mDataSchemes = new ArrayList<String>();
        if (!mDataSchemes.contains(scheme)) {
            mDataSchemes.add(scheme.intern());
        }
    }

    /**
     * Return the number of data schemes in the filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.811 -0500", hash_original_method = "23DC2F7DC5C53386402D5B95D046A59E", hash_generated_method = "7F8E015CCB62475EF679AD9556264DF4")
    
public final int countDataSchemes() {
        return mDataSchemes != null ? mDataSchemes.size() : 0;
    }

    /**
     * Return a data scheme in the filter.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.813 -0500", hash_original_method = "F55C42908F22C2BF6411521C019E1E71", hash_generated_method = "0C095C026EADCB33101C551367EFC85D")
    
public final String getDataScheme(int index) {
        return mDataSchemes.get(index);
    }

    /**
     * Is the given data scheme included in the filter?  Note that if the
     * filter does not include any scheme, false will <em>always</em> be
     * returned.
     *
     * @param scheme The data scheme to look for.
     *
     * @return True if the scheme is explicitly mentioned in the filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.816 -0500", hash_original_method = "6D8F15A80747973FB96EA7F310404F85", hash_generated_method = "49AF324792395883FF96E46A0C77B49B")
    
public final boolean hasDataScheme(String scheme) {
        return mDataSchemes != null && mDataSchemes.contains(scheme);
    }
    
    public static class MalformedMimeTypeException extends AndroidException {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.759 -0500", hash_original_method = "8500983E91FE33F50F26D266A654E6C8", hash_generated_method = "3EC5ABD340A3F165372D697F56D65E01")
        
public MalformedMimeTypeException() {
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.761 -0500", hash_original_method = "E06B6BA43D42AE50E4C9A14EEBF56FAC", hash_generated_method = "CD5BFD771B660603FE97A9CDE715BD08")
        
public MalformedMimeTypeException(String name) {
            super(name);
        }
        
    }
    
    public final static class AuthorityEntry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.822 -0500", hash_original_field = "32DD8703A5318DFB0F5E91580364D0C6", hash_generated_field = "0C08F8EAA89B66A92AA182AAF7101D01")

        private  String mOrigHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.824 -0500", hash_original_field = "608081BE7A68D9B383C7D78BD9FDC0E8", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

        private  String mHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.826 -0500", hash_original_field = "D663BFB24DCD93A5CE79A54831D212E5", hash_generated_field = "4775283DB55281CD651400D583AD7181")

        private  boolean mWild;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.829 -0500", hash_original_field = "AAAF8A3C293EA5711E38C28140852BDE", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

        private  int mPort;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.832 -0500", hash_original_method = "FAC1F38311ACA5CF1D84B9DFACCAD236", hash_generated_method = "9FBC64376477B30D865D376ED012A292")
        
public AuthorityEntry(String host, String port) {
            mOrigHost = host;
            mWild = host.length() > 0 && host.charAt(0) == '*';
            mHost = mWild ? host.substring(1).intern() : host;
            mPort = port != null ? Integer.parseInt(port) : -1;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.834 -0500", hash_original_method = "9AA41EA6C96E16AD56B52F388CEAC244", hash_generated_method = "9AA41EA6C96E16AD56B52F388CEAC244")
        
AuthorityEntry(Parcel src) {
            mOrigHost = src.readString();
            mHost = src.readString();
            mWild = src.readInt() != 0;
            mPort = src.readInt();
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.836 -0500", hash_original_method = "3FD27104A5CDDCA498D8F62DC306DFFB", hash_generated_method = "3FD27104A5CDDCA498D8F62DC306DFFB")
        
void writeToParcel(Parcel dest) {
            dest.writeString(mOrigHost);
            dest.writeString(mHost);
            dest.writeInt(mWild ? 1 : 0);
            dest.writeInt(mPort);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.838 -0500", hash_original_method = "56B964ED44110D4A8630C57ED8411A1C", hash_generated_method = "E3F78F3C1EFF67D365EA4D5381C38F05")
        
public String getHost() {
            return mOrigHost;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.841 -0500", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "33B8E8C1C43AC396F100852932189626")
        
public int getPort() {
            return mPort;
        }

        /**
         * Determine whether this AuthorityEntry matches the given data Uri.
         * <em>Note that this comparison is case-sensitive, unlike formal
         * RFC host names.  You thus should always normalize to lower-case.</em>
         * 
         * @param data The Uri to match.
         * @return Returns either {@link IntentFilter#NO_MATCH_DATA},
         * {@link IntentFilter#MATCH_CATEGORY_PORT}, or
         * {@link IntentFilter#MATCH_CATEGORY_HOST}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.843 -0500", hash_original_method = "FC31CC7FA89B702CE4ED1283F0D70C24", hash_generated_method = "462576926F46335C8BC9D3C56B690F44")
        
public int match(Uri data) {
            String host = data.getHost();
            if (host == null) {
                return NO_MATCH_DATA;
            }
            if (false) Log.v("IntentFilter",
                    "Match host " + host + ": " + mHost);
            if (mWild) {
                if (host.length() < mHost.length()) {
                    return NO_MATCH_DATA;
                }
                host = host.substring(host.length()-mHost.length());
            }
            if (host.compareToIgnoreCase(mHost) != 0) {
                return NO_MATCH_DATA;
            }
            if (mPort >= 0) {
                if (mPort != data.getPort()) {
                    return NO_MATCH_DATA;
                }
                return MATCH_CATEGORY_PORT;
            }
            return MATCH_CATEGORY_HOST;
        }
        
    }

    /**
     * Return an iterator over the filter's data schemes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.819 -0500", hash_original_method = "B57BF7E15AE8E364684A85B4AA7D0368", hash_generated_method = "C8D831E247FC418CD7C5BC57D1431AF9")
    
public final Iterator<String> schemesIterator() {
        return mDataSchemes != null ? mDataSchemes.iterator() : null;
    }

    /**
     * Add a new Intent data authority to match against.  The filter must
     * include one or more schemes (via {@link #addDataScheme}) for the
     * authority to be considered.  If any authorities are
     * included in the filter, then an Intent's data must match one of
     * them.  If no authorities are included, then only the scheme must match.
     *
     * <p><em>Note: host name in the Android framework is
     * case-sensitive, unlike formal RFC host names.  As a result,
     * you should always write your host names with lower case letters,
     * and any host names you receive from outside of Android should be
     * converted to lower case before supplying them here.</em></p>
     *
     * @param host The host part of the authority to match.  May start with a
     *             single '*' to wildcard the front of the host name.
     * @param port Optional port part of the authority to match.  If null, any
     *             port is allowed.
     *
     * @see #matchData
     * @see #addDataScheme
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.848 -0500", hash_original_method = "617831DFB49DD0B093CE5F322F324A18", hash_generated_method = "2C370B2480BD212E79C7ACBDA1068CB6")
    
public final void addDataAuthority(String host, String port) {
        if (mDataAuthorities == null) mDataAuthorities =
                new ArrayList<AuthorityEntry>();
        if (port != null) port = port.intern();
        mDataAuthorities.add(new AuthorityEntry(host.intern(), port));
    }

    /**
     * Return the number of data authorities in the filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.850 -0500", hash_original_method = "B59B7F6BD479782A00EECCEFFFB6C78B", hash_generated_method = "ACBF3CE7C2065A833780F667868D8FA6")
    
public final int countDataAuthorities() {
        return mDataAuthorities != null ? mDataAuthorities.size() : 0;
    }

    /**
     * Return a data authority in the filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.852 -0500", hash_original_method = "5C821D7ECF8B0A79E64F1031BF4C37BB", hash_generated_method = "E5B3C6C568EFD60A7DC37318E765CF23")
    
public final AuthorityEntry getDataAuthority(int index) {
        return mDataAuthorities.get(index);
    }

    /**
     * Is the given data authority included in the filter?  Note that if the
     * filter does not include any authorities, false will <em>always</em> be
     * returned.
     *
     * @param data The data whose authority is being looked for.
     *
     * @return Returns true if the data string matches an authority listed in the
     *         filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.854 -0500", hash_original_method = "04C5A3803469FEAEE8E315143FC0F6BE", hash_generated_method = "482341E6171E37182C148839FF0D7626")
    
public final boolean hasDataAuthority(Uri data) {
        return matchDataAuthority(data) >= 0;
    }

    /**
     * Return an iterator over the filter's data authorities.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.857 -0500", hash_original_method = "104889BB491104C94E7C1142A3F4BAAD", hash_generated_method = "EF0F2A8C9CCE210ADFD5AE4DB7B49EE8")
    
public final Iterator<AuthorityEntry> authoritiesIterator() {
        return mDataAuthorities != null ? mDataAuthorities.iterator() : null;
    }

    /**
     * Add a new Intent data path to match against.  The filter must
     * include one or more schemes (via {@link #addDataScheme}) <em>and</em>
     * one or more authorities (via {@link #addDataAuthority}) for the
     * path to be considered.  If any paths are
     * included in the filter, then an Intent's data must match one of
     * them.  If no paths are included, then only the scheme/authority must
     * match.
     *
     * <p>The path given here can either be a literal that must directly
     * match or match against a prefix, or it can be a simple globbing pattern.
     * If the latter, you can use '*' anywhere in the pattern to match zero
     * or more instances of the previous character, '.' as a wildcard to match
     * any character, and '\' to escape the next character.
     *
     * @param path Either a raw string that must exactly match the file
     * path, or a simple pattern, depending on <var>type</var>.
     * @param type Determines how <var>path</var> will be compared to
     * determine a match: either {@link PatternMatcher#PATTERN_LITERAL},
     * {@link PatternMatcher#PATTERN_PREFIX}, or
     * {@link PatternMatcher#PATTERN_SIMPLE_GLOB}.
     *
     * @see #matchData
     * @see #addDataScheme
     * @see #addDataAuthority
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.859 -0500", hash_original_method = "F30E00ACF0BA9FCEBC6CDD2BDA55B075", hash_generated_method = "003139D535B527A214FE25676DB3DE3D")
    
public final void addDataPath(String path, int type) {
        if (mDataPaths == null) mDataPaths = new ArrayList<PatternMatcher>();
        mDataPaths.add(new PatternMatcher(path.intern(), type));
    }

    /**
     * Return the number of data paths in the filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.862 -0500", hash_original_method = "60FAB9592DF6A1D398A3997EC9565FA6", hash_generated_method = "FAE26D84A1A415F192AC1D3B16BA7F0C")
    
public final int countDataPaths() {
        return mDataPaths != null ? mDataPaths.size() : 0;
    }

    /**
     * Return a data path in the filter.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.864 -0500", hash_original_method = "C7BC21A1B57BD5F3F08A1F8B8EBDB051", hash_generated_method = "9A44E84570673F2642B98CEA85FAB34B")
    
public final PatternMatcher getDataPath(int index) {
        return mDataPaths.get(index);
    }

    /**
     * Is the given data path included in the filter?  Note that if the
     * filter does not include any paths, false will <em>always</em> be
     * returned.
     *
     * @param data The data path to look for.  This is without the scheme
     *             prefix.
     *
     * @return True if the data string matches a path listed in the
     *         filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.866 -0500", hash_original_method = "8A8BB0EA1E4D89E1A8E627888FCA29D4", hash_generated_method = "3CE6EFFEB5226F9323C3D89F04BAE13E")
    
public final boolean hasDataPath(String data) {
        if (mDataPaths == null) {
            return false;
        }
        final int numDataPaths = mDataPaths.size();
        for (int i = 0; i < numDataPaths; i++) {
            final PatternMatcher pe = mDataPaths.get(i);
            if (pe.match(data)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return an iterator over the filter's data paths.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.869 -0500", hash_original_method = "DFBFAEBB83F5AF41A1E2404555B650EF", hash_generated_method = "1F8065DFF7079B0FB9B0EBE12A159F62")
    
public final Iterator<PatternMatcher> pathsIterator() {
        return mDataPaths != null ? mDataPaths.iterator() : null;
    }

    /**
     * Match this intent filter against the given Intent data.  This ignores
     * the data scheme -- unlike {@link #matchData}, the authority will match
     * regardless of whether there is a matching scheme.
     *
     * @param data The data whose authority is being looked for.
     *
     * @return Returns either {@link #MATCH_CATEGORY_HOST},
     * {@link #MATCH_CATEGORY_PORT}, {@link #NO_MATCH_DATA}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.871 -0500", hash_original_method = "BBE034684833DCE31C3A8387BD50FAB0", hash_generated_method = "31951D09B247C552CCCBD41930B9B729")
    
public final int matchDataAuthority(Uri data) {
        if (mDataAuthorities == null) {
            return NO_MATCH_DATA;
        }
        final int numDataAuthorities = mDataAuthorities.size();
        for (int i = 0; i < numDataAuthorities; i++) {
            final AuthorityEntry ae = mDataAuthorities.get(i);
            int match = ae.match(data);
            if (match >= 0) {
                return match;
            }
        }
        return NO_MATCH_DATA;
    }

    /**
     * Match this filter against an Intent's data (type, scheme and path). If
     * the filter does not specify any types and does not specify any
     * schemes/paths, the match will only succeed if the intent does not
     * also specify a type or data.
     *
     * <p>Be aware that to match against an authority, you must also specify a base
     * scheme the authority is in.  To match against a data path, both a scheme
     * and authority must be specified.  If the filter does not specify any
     * types or schemes that it matches against, it is considered to be empty
     * (any authority or data path given is ignored, as if it were empty as
     * well).
     *
     * <p><em>Note: MIME type, Uri scheme, and host name matching in the
     * Android framework is case-sensitive, unlike the formal RFC definitions.
     * As a result, you should always write these elements with lower case letters,
     * and normalize any MIME types or Uris you receive from
     * outside of Android to ensure these elements are lower case before
     * supplying them here.</em></p>
     *
     * @param type The desired data type to look for, as returned by
     *             Intent.resolveType().
     * @param scheme The desired data scheme to look for, as returned by
     *               Intent.getScheme().
     * @param data The full data string to match against, as supplied in
     *             Intent.data.
     *
     * @return Returns either a valid match constant (a combination of
     * {@link #MATCH_CATEGORY_MASK} and {@link #MATCH_ADJUSTMENT_MASK}),
     * or one of the error codes {@link #NO_MATCH_TYPE} if the type didn't match
     * or {@link #NO_MATCH_DATA} if the scheme/path didn't match.
     *
     * @see #match
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.874 -0500", hash_original_method = "6458C2A82CD5BFA5489DF067AE915D84", hash_generated_method = "61FDB7FB1F0A162C276160E6FF54B255")
    
public final int matchData(String type, String scheme, Uri data) {
        final ArrayList<String> types = mDataTypes;
        final ArrayList<String> schemes = mDataSchemes;
        final ArrayList<AuthorityEntry> authorities = mDataAuthorities;
        final ArrayList<PatternMatcher> paths = mDataPaths;

        int match = MATCH_CATEGORY_EMPTY;

        if (types == null && schemes == null) {
            return ((type == null && data == null)
                ? (MATCH_CATEGORY_EMPTY+MATCH_ADJUSTMENT_NORMAL) : NO_MATCH_DATA);
        }

        if (schemes != null) {
            if (schemes.contains(scheme != null ? scheme : "")) {
                match = MATCH_CATEGORY_SCHEME;
            } else {
                return NO_MATCH_DATA;
            }

            if (authorities != null) {
                int authMatch = matchDataAuthority(data);
                if (authMatch >= 0) {
                    if (paths == null) {
                        match = authMatch;
                    } else if (hasDataPath(data.getPath())) {
                        match = MATCH_CATEGORY_PATH;
                    } else {
                        return NO_MATCH_DATA;
                    }
                } else {
                    return NO_MATCH_DATA;
                }
            }
        } else {
            // Special case: match either an Intent with no data URI,
            // or with a scheme: URI.  This is to give a convenience for
            // the common case where you want to deal with data in a
            // content provider, which is done by type, and we don't want
            // to force everyone to say they handle content: or file: URIs.
            if (scheme != null && !"".equals(scheme)
                    && !"content".equals(scheme)
                    && !"file".equals(scheme)) {
                return NO_MATCH_DATA;
            }
        }

        if (types != null) {
            if (findMimeType(type)) {
                match = MATCH_CATEGORY_TYPE;
            } else {
                return NO_MATCH_TYPE;
            }
        } else {
            // If no MIME types are specified, then we will only match against
            // an Intent that does not have a MIME type.
            if (type != null) {
                return NO_MATCH_TYPE;
            }
        }

        return match + MATCH_ADJUSTMENT_NORMAL;
    }

    /**
     * Add a new Intent category to match against.  The semantics of
     * categories is the opposite of actions -- an Intent includes the
     * categories that it requires, all of which must be included in the
     * filter in order to match.  In other words, adding a category to the
     * filter has no impact on matching unless that category is specified in
     * the intent.
     *
     * @param category Name of category to match, i.e. Intent.CATEGORY_EMBED.
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.877 -0500", hash_original_method = "740A58E186A747CF3BBDAB4A3568B004", hash_generated_method = "D6155558240F18D428AF03627444830B")
    
public final void addCategory(String category) {
        if (mCategories == null) mCategories = new ArrayList<String>();
        if (!mCategories.contains(category)) {
            mCategories.add(category.intern());
        }
    }

    /**
     * Return the number of categories in the filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.880 -0500", hash_original_method = "D5AF5503C90FCC35F15F05FB572F3FAB", hash_generated_method = "134E4FBB2BB202128B0067BCEDC4F6B5")
    
public final int countCategories() {
        return mCategories != null ? mCategories.size() : 0;
    }

    /**
     * Return a category in the filter.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.882 -0500", hash_original_method = "9221063C5ACD71C55B9DBC6F8D5B18B1", hash_generated_method = "EF4B1E71A6ECADCDD9F9EFFA609D8B9E")
    
public final String getCategory(int index) {
        return mCategories.get(index);
    }

    /**
     * Is the given category included in the filter?
     *
     * @param category The category that the filter supports.
     *
     * @return True if the category is explicitly mentioned in the filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.884 -0500", hash_original_method = "3612221F73372432993CCD6954A20D1D", hash_generated_method = "83DCDFD75F880CF8148E4913B2FEBDD5")
    
public final boolean hasCategory(String category) {
        return mCategories != null && mCategories.contains(category);
    }

    /**
     * Return an iterator over the filter's categories.
     *
     * @return Iterator if this filter has categories or {@code null} if none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.887 -0500", hash_original_method = "A1CBC473D8947BEFDC4AD1E1869906E2", hash_generated_method = "DE07BE4A3EDC9BA8DE2984613851382F")
    
public final Iterator<String> categoriesIterator() {
        return mCategories != null ? mCategories.iterator() : null;
    }

    /**
     * Match this filter against an Intent's categories.  Each category in
     * the Intent must be specified by the filter; if any are not in the
     * filter, the match fails.
     *
     * @param categories The categories included in the intent, as returned by
     *                   Intent.getCategories().
     *
     * @return If all categories match (success), null; else the name of the
     *         first category that didn't match.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.889 -0500", hash_original_method = "64ACE3DFA3E244FA74278C4A66D2BC47", hash_generated_method = "57E1DC3A4D7705403B090790BEF7E5E8")
    
public final String matchCategories(Set<String> categories) {
        if (categories == null) {
            return null;
        }

        Iterator<String> it = categories.iterator();

        if (mCategories == null) {
            return it.hasNext() ? it.next() : null;
        }

        while (it.hasNext()) {
            final String category = it.next();
            if (!mCategories.contains(category)) {
                return category;
            }
        }

        return null;
    }

    /**
     * Test whether this filter matches the given <var>intent</var>.
     *
     * @param intent The Intent to compare against.
     * @param resolve If true, the intent's type will be resolved by calling
     *                Intent.resolveType(); otherwise a simple match against
     *                Intent.type will be performed.
     * @param logTag Tag to use in debugging messages.
     *
     * @return Returns either a valid match constant (a combination of
     * {@link #MATCH_CATEGORY_MASK} and {@link #MATCH_ADJUSTMENT_MASK}),
     * or one of the error codes {@link #NO_MATCH_TYPE} if the type didn't match,
     * {@link #NO_MATCH_DATA} if the scheme/path didn't match,
     * {@link #NO_MATCH_ACTION if the action didn't match, or
     * {@link #NO_MATCH_CATEGORY} if one or more categories didn't match.
     *
     * @return How well the filter matches.  Negative if it doesn't match,
     *         zero or positive positive value if it does with a higher
     *         value representing a better match.
     *
     * @see #match(String, String, String, android.net.Uri , Set, String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.891 -0500", hash_original_method = "4ACC3B62E54BFBE055D3653A9CF49AD3", hash_generated_method = "63E7295D71AB9F4404861D24D95AEA79")
    
public final int match(ContentResolver resolver, Intent intent,
            boolean resolve, String logTag) {
        String type = resolve ? intent.resolveType(resolver) : intent.getType();
        return match(intent.getAction(), type, intent.getScheme(),
                     intent.getData(), intent.getCategories(), logTag);
    }

    /**
     * Test whether this filter matches the given intent data.  A match is
     * only successful if the actions and categories in the Intent match
     * against the filter, as described in {@link IntentFilter}; in that case,
     * the match result returned will be as per {@link #matchData}.
     *
     * @param action The intent action to match against (Intent.getAction).
     * @param type The intent type to match against (Intent.resolveType()).
     * @param scheme The data scheme to match against (Intent.getScheme()).
     * @param data The data URI to match against (Intent.getData()).
     * @param categories The categories to match against
     *                   (Intent.getCategories()).
     * @param logTag Tag to use in debugging messages.
     *
     * @return Returns either a valid match constant (a combination of
     * {@link #MATCH_CATEGORY_MASK} and {@link #MATCH_ADJUSTMENT_MASK}),
     * or one of the error codes {@link #NO_MATCH_TYPE} if the type didn't match,
     * {@link #NO_MATCH_DATA} if the scheme/path didn't match,
     * {@link #NO_MATCH_ACTION if the action didn't match, or
     * {@link #NO_MATCH_CATEGORY} if one or more categories didn't match.
     *
     * @see #matchData
     * @see Intent#getAction
     * @see Intent#resolveType
     * @see Intent#getScheme
     * @see Intent#getData
     * @see Intent#getCategories
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.894 -0500", hash_original_method = "80E2BB7D6EA3B343C7B82810FBA9B369", hash_generated_method = "8C8258AC41C91D5DE5470DD30A2BC4DD")
    
public final int match(String action, String type, String scheme,
            Uri data, Set<String> categories, String logTag) {
        if (action != null && !matchAction(action)) {
            if (false) Log.v(
                logTag, "No matching action " + action + " for " + this);
            return NO_MATCH_ACTION;
        }

        int dataMatch = matchData(type, scheme, data);
        if (dataMatch < 0) {
            if (false) {
                if (dataMatch == NO_MATCH_TYPE) {
                    Log.v(logTag, "No matching type " + type
                          + " for " + this);
                }
                if (dataMatch == NO_MATCH_DATA) {
                    Log.v(logTag, "No matching scheme/path " + data
                          + " for " + this);
                }
            }
            return dataMatch;
        }

        String categoryMismatch = matchCategories(categories);
        if (categoryMismatch != null) {
            if (false) {
                Log.v(logTag, "No matching category " + categoryMismatch + " for " + this);
            }
            return NO_MATCH_CATEGORY;
        }

        // It would be nice to treat container activities as more
        // important than ones that can be embedded, but this is not the way...
        if (false) {
            if (categories != null) {
                dataMatch -= mCategories.size() - categories.size();
            }
        }

        return dataMatch;
    }

    /**
     * Write the contents of the IntentFilter as an XML stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.898 -0500", hash_original_method = "B6C33F6C9AFBFD4465A32F9300C74AFB", hash_generated_method = "5E9890F60800B6FE556CD91BC5206B40")
    
public void writeToXml(XmlSerializer serializer) throws IOException {
        int N = countActions();
        for (int i=0; i<N; i++) {
            serializer.startTag(null, ACTION_STR);
            serializer.attribute(null, NAME_STR, mActions);
            serializer.endTag(null, ACTION_STR);
        }
        N = countCategories();
        for (int i=0; i<N; i++) {
            serializer.startTag(null, CAT_STR);
            serializer.attribute(null, NAME_STR, mCategories.get(i));
            serializer.endTag(null, CAT_STR);
        }
        N = countDataTypes();
        for (int i=0; i<N; i++) {
            serializer.startTag(null, TYPE_STR);
            String type = mDataTypes.get(i);
            if (type.indexOf('/') < 0) type = type + "/*";
            serializer.attribute(null, NAME_STR, type);
            serializer.endTag(null, TYPE_STR);
        }
        N = countDataSchemes();
        for (int i=0; i<N; i++) {
            serializer.startTag(null, SCHEME_STR);
            serializer.attribute(null, NAME_STR, mDataSchemes.get(i));
            serializer.endTag(null, SCHEME_STR);
        }
        N = countDataAuthorities();
        for (int i=0; i<N; i++) {
            serializer.startTag(null, AUTH_STR);
            AuthorityEntry ae = mDataAuthorities.get(i);
            serializer.attribute(null, HOST_STR, ae.getHost());
            if (ae.getPort() >= 0) {
                serializer.attribute(null, PORT_STR, Integer.toString(ae.getPort()));
            }
            serializer.endTag(null, AUTH_STR);
        }
        N = countDataPaths();
        for (int i=0; i<N; i++) {
            serializer.startTag(null, PATH_STR);
            PatternMatcher pe = mDataPaths.get(i);
            switch (pe.getType()) {
                case PatternMatcher.PATTERN_LITERAL:
                    serializer.attribute(null, LITERAL_STR, pe.getPath());
                    break;
                case PatternMatcher.PATTERN_PREFIX:
                    serializer.attribute(null, PREFIX_STR, pe.getPath());
                    break;
                case PatternMatcher.PATTERN_SIMPLE_GLOB:
                    serializer.attribute(null, SGLOB_STR, pe.getPath());
                    break;
            }
            serializer.endTag(null, PATH_STR);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.902 -0500", hash_original_method = "276CC8B213E249CE42650F70E7C4B53B", hash_generated_method = "80103C4131885BEE320DF26879194C9B")
    
public void readFromXml(XmlPullParser parser) throws XmlPullParserException,
            IOException {
        int outerDepth = parser.getDepth();
        int type;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth)) {
            if (type == XmlPullParser.END_TAG
                    || type == XmlPullParser.TEXT) {
                continue;
            }

            String tagName = parser.getName();
            if (tagName.equals(ACTION_STR)) {
                String name = parser.getAttributeValue(null, NAME_STR);
                if (name != null) {
                    addAction(name);
                }
            } else if (tagName.equals(CAT_STR)) {
                String name = parser.getAttributeValue(null, NAME_STR);
                if (name != null) {
                    addCategory(name);
                }
            } else if (tagName.equals(TYPE_STR)) {
                String name = parser.getAttributeValue(null, NAME_STR);
                if (name != null) {
                    try {
                        addDataType(name);
                    } catch (MalformedMimeTypeException e) {
                    }
                }
            } else if (tagName.equals(SCHEME_STR)) {
                String name = parser.getAttributeValue(null, NAME_STR);
                if (name != null) {
                    addDataScheme(name);
                }
            } else if (tagName.equals(AUTH_STR)) {
                String host = parser.getAttributeValue(null, HOST_STR);
                String port = parser.getAttributeValue(null, PORT_STR);
                if (host != null) {
                    addDataAuthority(host, port);
                }
            } else if (tagName.equals(PATH_STR)) {
                String path = parser.getAttributeValue(null, LITERAL_STR);
                if (path != null) {
                    addDataPath(path, PatternMatcher.PATTERN_LITERAL);
                } else if ((path=parser.getAttributeValue(null, PREFIX_STR)) != null) {
                    addDataPath(path, PatternMatcher.PATTERN_PREFIX);
                } else if ((path=parser.getAttributeValue(null, SGLOB_STR)) != null) {
                    addDataPath(path, PatternMatcher.PATTERN_SIMPLE_GLOB);
                }
            } else {
                Log.w("IntentFilter", "Unknown tag parsing IntentFilter: " + tagName);
            }
            XmlUtils.skipCurrentTag(parser);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.905 -0500", hash_original_method = "75FFB292CCD000E47FA0C7D0BE596A36", hash_generated_method = "A9A40E6BE71C566E4C8623C0F2D8F9A8")
    
public void dump(Printer du, String prefix) {
        StringBuilder sb = new StringBuilder(256);
        if (countActions() > 0) {
            Iterator<String> it = actionsIterator();
            while (it.hasNext()) {
                sb.setLength(0);
                sb.append(prefix); sb.append("Action: \"");
                        sb.append(it.next()); sb.append("\"");
                du.println(sb.toString());
            }
        }
        if (mCategories != null) {
            Iterator<String> it = mCategories.iterator();
            while (it.hasNext()) {
                sb.setLength(0);
                sb.append(prefix); sb.append("Category: \"");
                        sb.append(it.next()); sb.append("\"");
                du.println(sb.toString());
            }
        }
        if (mDataSchemes != null) {
            Iterator<String> it = mDataSchemes.iterator();
            while (it.hasNext()) {
                sb.setLength(0);
                sb.append(prefix); sb.append("Scheme: \"");
                        sb.append(it.next()); sb.append("\"");
                du.println(sb.toString());
            }
        }
        if (mDataAuthorities != null) {
            Iterator<AuthorityEntry> it = mDataAuthorities.iterator();
            while (it.hasNext()) {
                AuthorityEntry ae = it.next();
                sb.setLength(0);
                sb.append(prefix); sb.append("Authority: \"");
                        sb.append(ae.mHost); sb.append("\": ");
                        sb.append(ae.mPort);
                if (ae.mWild) sb.append(" WILD");
                du.println(sb.toString());
            }
        }
        if (mDataPaths != null) {
            Iterator<PatternMatcher> it = mDataPaths.iterator();
            while (it.hasNext()) {
                PatternMatcher pe = it.next();
                sb.setLength(0);
                sb.append(prefix); sb.append("Path: \"");
                        sb.append(pe); sb.append("\"");
                du.println(sb.toString());
            }
        }
        if (mDataTypes != null) {
            Iterator<String> it = mDataTypes.iterator();
            while (it.hasNext()) {
                sb.setLength(0);
                sb.append(prefix); sb.append("Type: \"");
                        sb.append(it.next()); sb.append("\"");
                du.println(sb.toString());
            }
        }
        if (mPriority != 0 || mHasPartialTypes) {
            sb.setLength(0);
            sb.append(prefix); sb.append("mPriority="); sb.append(mPriority);
                    sb.append(", mHasPartialTypes="); sb.append(mHasPartialTypes);
            du.println(sb.toString());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.916 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7F5A2F80DDBC16C1ED277027A32E4DE5")
    
public final int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.919 -0500", hash_original_method = "2C734948869786E017228B90D172BE24", hash_generated_method = "4F147E1D1C84E2F200DCFB5C2C125F60")
    
public final void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mActions);
        if (mCategories != null) {
            dest.writeInt(1);
            dest.writeStringList(mCategories);
        } else {
            dest.writeInt(0);
        }
        if (mDataSchemes != null) {
            dest.writeInt(1);
            dest.writeStringList(mDataSchemes);
        } else {
            dest.writeInt(0);
        }
        if (mDataTypes != null) {
            dest.writeInt(1);
            dest.writeStringList(mDataTypes);
        } else {
            dest.writeInt(0);
        }
        if (mDataAuthorities != null) {
            final int N = mDataAuthorities.size();
            dest.writeInt(N);
            for (int i=0; i<N; i++) {
                mDataAuthorities.get(i).writeToParcel(dest);
            }
        } else {
            dest.writeInt(0);
        }
        if (mDataPaths != null) {
            final int N = mDataPaths.size();
            dest.writeInt(N);
            for (int i=0; i<N; i++) {
                mDataPaths.get(i).writeToParcel(dest, 0);
            }
        } else {
            dest.writeInt(0);
        }
        dest.writeInt(mPriority);
        dest.writeInt(mHasPartialTypes ? 1 : 0);
    }

    /**
     * For debugging -- perform a check on the filter, return true if it passed
     * or false if it failed.
     *
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.921 -0500", hash_original_method = "FBEEEBAC37A62143C058604C825166BE", hash_generated_method = "9948192199B3A8A0964F819E3E060935")
    
public boolean debugCheck() {
        return true;

        // This code looks for intent filters that do not specify data.
        /*
        if (mActions != null && mActions.size() == 1
                && mActions.contains(Intent.ACTION_MAIN)) {
            return true;
        }

        if (mDataTypes == null && mDataSchemes == null) {
            Log.w("IntentFilter", "QUESTIONABLE INTENT FILTER:");
            dump(Log.WARN, "IntentFilter", "  ");
            return false;
        }

        return true;
        */
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:35.927 -0500", hash_original_method = "742383A5720F36FAAE26E247984D38D1", hash_generated_method = "7602D17575FA8737C2A348002BCBA396")
    
private final boolean findMimeType(String type) {
        final ArrayList<String> t = mDataTypes;

        if (type == null) {
            return false;
        }

        if (t.contains(type)) {
            return true;
        }

        // Deal with an Intent wanting to match every type in the IntentFilter.
        final int typeLength = type.length();
        if (typeLength == 3 && type.equals("*/*")) {
            return !t.isEmpty();
        }

        // Deal with this IntentFilter wanting to match every Intent type.
        if (mHasPartialTypes && t.contains("*")) {
            return true;
        }

        final int slashpos = type.indexOf('/');
        if (slashpos > 0) {
            if (mHasPartialTypes && t.contains(type.substring(0, slashpos))) {
                return true;
            }
            if (typeLength == slashpos+2 && type.charAt(slashpos+1) == '*') {
                // Need to look through all types for one that matches
                // our base...
                final int numTypes = t.size();
                for (int i = 0; i < numTypes; i++) {
                    final String v = t.get(i);
                    if (type.regionMatches(0, v, 0, slashpos+1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    // orphaned legacy method
    public IntentFilter createFromParcel(Parcel source) {
            return new IntentFilter(source);
        }
    
    // orphaned legacy method
    public IntentFilter[] newArray(int size) {
            return new IntentFilter[size];
        }

    Uri dataUri;
    
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafeSetDataUri(String data) {
        try {
            dataUri = new Uri(data);
        }
        catch (Exception ex) {
            
        }
    }
   
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public Uri droidsafeGetDataUri() {
        return dataUri;
    }
    
}

