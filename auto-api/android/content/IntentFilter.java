package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PatternMatcher;
import android.util.AndroidException;
import android.util.Log;
import android.util.Printer;
import com.android.internal.util.XmlUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class IntentFilter implements Parcelable {
    private static final String SGLOB_STR = "sglob";
    private static final String PREFIX_STR = "prefix";
    private static final String LITERAL_STR = "literal";
    private static final String PATH_STR = "path";
    private static final String PORT_STR = "port";
    private static final String HOST_STR = "host";
    private static final String AUTH_STR = "auth";
    private static final String SCHEME_STR = "scheme";
    private static final String TYPE_STR = "type";
    private static final String CAT_STR = "cat";
    private static final String NAME_STR = "name";
    private static final String ACTION_STR = "action";
    public static final int SYSTEM_HIGH_PRIORITY = 1000;
    public static final int SYSTEM_LOW_PRIORITY = -1000;
    public static final int MATCH_CATEGORY_MASK = 0xfff0000;
    public static final int MATCH_ADJUSTMENT_MASK = 0x000ffff;
    public static final int MATCH_ADJUSTMENT_NORMAL = 0x8000;
    public static final int MATCH_CATEGORY_EMPTY = 0x0100000;
    public static final int MATCH_CATEGORY_SCHEME = 0x0200000;
    public static final int MATCH_CATEGORY_HOST = 0x0300000;
    public static final int MATCH_CATEGORY_PORT = 0x0400000;
    public static final int MATCH_CATEGORY_PATH = 0x0500000;
    public static final int MATCH_CATEGORY_TYPE = 0x0600000;
    public static final int NO_MATCH_TYPE = -1;
    public static final int NO_MATCH_DATA = -2;
    public static final int NO_MATCH_ACTION = -3;
    public static final int NO_MATCH_CATEGORY = -4;
    private int mPriority;
    private final ArrayList<String> mActions;
    private ArrayList<String> mCategories = null;
    private ArrayList<String> mDataSchemes = null;
    private ArrayList<AuthorityEntry> mDataAuthorities = null;
    private ArrayList<PatternMatcher> mDataPaths = null;
    private ArrayList<String> mDataTypes = null;
    private boolean mHasPartialTypes = false;
    public static final Parcelable.Creator<IntentFilter> CREATOR = new Parcelable.Creator<IntentFilter>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.759 -0400", hash_original_method = "6AFABEC7B0F2CE7FB89EA092702B6037", hash_generated_method = "0B9DFC2FA8CCBC6BDBC15FB40055BB30")
        @DSModeled(DSC.SAFE)
        public IntentFilter createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (IntentFilter)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new IntentFilter(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.759 -0400", hash_original_method = "DE4837E283E52263DB6E87C79DDB9140", hash_generated_method = "A7688AC7AAB3EC5AE8A4816B7B8DBD1A")
        @DSModeled(DSC.SAFE)
        public IntentFilter[] newArray(int size) {
            dsTaint.addTaint(size);
            return (IntentFilter[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new IntentFilter[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.759 -0400", hash_original_method = "E570235BD10D63A46D952627D4823B55", hash_generated_method = "559CDF5EAA960FB46CCAB7D4FA07E8CC")
    @DSModeled(DSC.SAFE)
    public IntentFilter() {
        mPriority = 0;
        mActions = new ArrayList<String>();
        // ---------- Original Method ----------
        //mPriority = 0;
        //mActions = new ArrayList<String>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.760 -0400", hash_original_method = "6BE32B941606799E1C4582399143D6DE", hash_generated_method = "94AE089CD2A5D532FC45B117D0BCC2EE")
    @DSModeled(DSC.SAFE)
    public IntentFilter(String action) {
        dsTaint.addTaint(action);
        mPriority = 0;
        mActions = new ArrayList<String>();
        addAction(action);
        // ---------- Original Method ----------
        //mPriority = 0;
        //mActions = new ArrayList<String>();
        //addAction(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.760 -0400", hash_original_method = "6F03ACB8C3DEEE507BC72687512BE15B", hash_generated_method = "CDD92C373E9FB77557D5727CF9346B31")
    @DSModeled(DSC.SAFE)
    public IntentFilter(String action, String dataType) throws MalformedMimeTypeException {
        dsTaint.addTaint(dataType);
        dsTaint.addTaint(action);
        mPriority = 0;
        mActions = new ArrayList<String>();
        addAction(action);
        addDataType(dataType);
        // ---------- Original Method ----------
        //mPriority = 0;
        //mActions = new ArrayList<String>();
        //addAction(action);
        //addDataType(dataType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.760 -0400", hash_original_method = "1836401D6B82BE6CCBD088E7B5026D41", hash_generated_method = "B6DA1E9D62243595DF8C71B54A7514A8")
    @DSModeled(DSC.SAFE)
    public IntentFilter(IntentFilter o) {
        dsTaint.addTaint(o.dsTaint);
        mPriority = o.mPriority;
        mActions = new ArrayList<String>(o.mActions);
        {
            mCategories = new ArrayList<String>(o.mCategories);
        } //End block
        {
            mDataTypes = new ArrayList<String>(o.mDataTypes);
        } //End block
        {
            mDataSchemes = new ArrayList<String>(o.mDataSchemes);
        } //End block
        {
            mDataAuthorities = new ArrayList<AuthorityEntry>(o.mDataAuthorities);
        } //End block
        {
            mDataPaths = new ArrayList<PatternMatcher>(o.mDataPaths);
        } //End block
        mHasPartialTypes = o.mHasPartialTypes;
        // ---------- Original Method ----------
        //mPriority = o.mPriority;
        //mActions = new ArrayList<String>(o.mActions);
        //if (o.mCategories != null) {
            //mCategories = new ArrayList<String>(o.mCategories);
        //}
        //if (o.mDataTypes != null) {
            //mDataTypes = new ArrayList<String>(o.mDataTypes);
        //}
        //if (o.mDataSchemes != null) {
            //mDataSchemes = new ArrayList<String>(o.mDataSchemes);
        //}
        //if (o.mDataAuthorities != null) {
            //mDataAuthorities = new ArrayList<AuthorityEntry>(o.mDataAuthorities);
        //}
        //if (o.mDataPaths != null) {
            //mDataPaths = new ArrayList<PatternMatcher>(o.mDataPaths);
        //}
        //mHasPartialTypes = o.mHasPartialTypes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.761 -0400", hash_original_method = "0A18E8175DAFA9E0ECB5A7A15F664AD8", hash_generated_method = "5C6020B933E129C0FC231920FC8230D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private IntentFilter(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        mActions = new ArrayList<String>();
        source.readStringList(mActions);
        {
            boolean varFD16828A378FD83700BE97539951F787_134134566 = (source.readInt() != 0);
            {
                mCategories = new ArrayList<String>();
                source.readStringList(mCategories);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFD16828A378FD83700BE97539951F787_1236339424 = (source.readInt() != 0);
            {
                mDataSchemes = new ArrayList<String>();
                source.readStringList(mDataSchemes);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFD16828A378FD83700BE97539951F787_28275116 = (source.readInt() != 0);
            {
                mDataTypes = new ArrayList<String>();
                source.readStringList(mDataTypes);
            } //End block
        } //End collapsed parenthetic
        int N;
        N = source.readInt();
        {
            mDataAuthorities = new ArrayList<AuthorityEntry>();
            {
                int i;
                i = 0;
                {
                    mDataAuthorities.add(new AuthorityEntry(source));
                } //End block
            } //End collapsed parenthetic
        } //End block
        N = source.readInt();
        {
            mDataPaths = new ArrayList<PatternMatcher>();
            {
                int i;
                i = 0;
                {
                    mDataPaths.add(new PatternMatcher(source));
                } //End block
            } //End collapsed parenthetic
        } //End block
        mPriority = source.readInt();
        mHasPartialTypes = source.readInt() > 0;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.761 -0400", hash_original_method = "DA21299454DC334FA5FD853D1BFD2D91", hash_generated_method = "0931E9784E87BD4E6C0385E8116E742F")
    private static int findStringInSet(String[] set, String string,
            int[] lengths, int lenPos) {
        if (set == null) return -1;
        final int N = lengths[lenPos];
        for (int i=0; i<N; i++) {
            if (set[i].equals(string)) return i;
        }
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.762 -0400", hash_original_method = "77C7ED281F73E32FAEAB4043A75B2222", hash_generated_method = "6E55CE27038C83CA2C9F4EF6BA6D0080")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.762 -0400", hash_original_method = "5DADFEE73D89E7689BB0B9FCBD7E5BBE", hash_generated_method = "3C1DD4EDF5A37BB60FCA2D86C2F478E6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.762 -0400", hash_original_method = "A1D1078D79ADBFCB876B04A67BE8587A", hash_generated_method = "64624900F48215366B67C691CCF1AFBA")
    public static IntentFilter create(String action, String dataType) {
        try {
            return new IntentFilter(action, dataType);
        } catch (MalformedMimeTypeException e) {
            throw new RuntimeException("Bad MIME type", e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.762 -0400", hash_original_method = "1AF904ED06333BC0001A5A8D0FC8E3CC", hash_generated_method = "C2CF8EC8D7495A647105F136F9859C25")
    @DSModeled(DSC.SAFE)
    public final void setPriority(int priority) {
        dsTaint.addTaint(priority);
        // ---------- Original Method ----------
        //mPriority = priority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.762 -0400", hash_original_method = "4CF75B39A2F3F4074ED78E7B55CDB45C", hash_generated_method = "8B1099D32C421D24C91A522D607CC2F7")
    @DSModeled(DSC.SAFE)
    public final int getPriority() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPriority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.763 -0400", hash_original_method = "FFF5B803FCB58F324812D605B6C9CE62", hash_generated_method = "D1DC5CE9FBD38B026912C764117A3FA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void addAction(String action) {
        dsTaint.addTaint(action);
        {
            boolean varDA3436D9D4672C232973BD25181DC765_744997564 = (!mActions.contains(action));
            {
                mActions.add(action.intern());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!mActions.contains(action)) {
            //mActions.add(action.intern());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.763 -0400", hash_original_method = "77921182B442B1D522A9772E07DC4CA3", hash_generated_method = "4C80CEFFD5B04DF701D38897BB582FD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int countActions() {
        int var19FD9BE92ED9235C35782B147251E19B_557153281 = (mActions.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActions.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.763 -0400", hash_original_method = "50CEFE8EA652B37B9EBFC8EA367BBC71", hash_generated_method = "1EAF245E9D0E7AEAB180B9303D85CB60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getAction(int index) {
        dsTaint.addTaint(index);
        String varBF04BD3B361347BD6F62D607387F7563_1177596092 = (mActions.get(index));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActions.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.763 -0400", hash_original_method = "9D48CC1056269867443B9FC005D01764", hash_generated_method = "3C11CBBB4FCC2B1F7DB1DBB3D4FBDD23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasAction(String action) {
        dsTaint.addTaint(action);
        boolean varDF0CCFFC7BDE2E2A2BCDBD16345F594C_343203250 = (action != null && mActions.contains(action));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return action != null && mActions.contains(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.763 -0400", hash_original_method = "984560EB63068E6413989919BB90D187", hash_generated_method = "7A55B9D7840192F1B2B3243204AC1AC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean matchAction(String action) {
        dsTaint.addTaint(action);
        boolean var9B5661F26B968C4AAD3608BADBD8A775_1913607457 = (hasAction(action));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasAction(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.764 -0400", hash_original_method = "91B40E19A4EE68D85BFA3F1F256EBA72", hash_generated_method = "AF52978A64E0E8F81C49BA8A6E0430BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Iterator<String> actionsIterator() {
        {
            Object var179B99187F77CA74E04A9854925FF180_467067535 = (mActions.iterator());
        } //End flattened ternary
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActions != null ? mActions.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.764 -0400", hash_original_method = "B72DE1FACB480BB8E2AD802A23898A2F", hash_generated_method = "803CA73022244BD680B6646A6B741A70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void addDataType(String type) throws MalformedMimeTypeException {
        dsTaint.addTaint(type);
        final int slashpos;
        slashpos = type.indexOf('/');
        final int typelen;
        typelen = type.length();
        {
            mDataTypes = new ArrayList<String>();
            {
                boolean var38C7C9D7B7DBF9B40D4D0FBD0F6AD99E_1308290266 = (typelen == slashpos+2 && type.charAt(slashpos+1) == '*');
                {
                    String str;
                    str = type.substring(0, slashpos);
                    {
                        boolean varD49CE2200355496BB92B3C202D8BDEE3_1691862898 = (!mDataTypes.contains(str));
                        {
                            mDataTypes.add(str.intern());
                        } //End block
                    } //End collapsed parenthetic
                    mHasPartialTypes = true;
                } //End block
                {
                    {
                        boolean var14F656F6D90E73ACD7CC37F6B5F05D46_315165051 = (!mDataTypes.contains(type));
                        {
                            mDataTypes.add(type.intern());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        throw new MalformedMimeTypeException(type);
        // ---------- Original Method ----------
        //final int slashpos = type.indexOf('/');
        //final int typelen = type.length();
        //if (slashpos > 0 && typelen >= slashpos+2) {
            //if (mDataTypes == null) mDataTypes = new ArrayList<String>();
            //if (typelen == slashpos+2 && type.charAt(slashpos+1) == '*') {
                //String str = type.substring(0, slashpos);
                //if (!mDataTypes.contains(str)) {
                    //mDataTypes.add(str.intern());
                //}
                //mHasPartialTypes = true;
            //} else {
                //if (!mDataTypes.contains(type)) {
                    //mDataTypes.add(type.intern());
                //}
            //}
            //return;
        //}
        //throw new MalformedMimeTypeException(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.765 -0400", hash_original_method = "9AF334B8B7AF494EC1E65710EFD1F300", hash_generated_method = "0823C86A723FCB62DADE404DD9055940")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasDataType(String type) {
        dsTaint.addTaint(type);
        boolean var0425380B65E8B08CE43D132BFE5C72CF_607790474 = (mDataTypes != null && findMimeType(type));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDataTypes != null && findMimeType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.765 -0400", hash_original_method = "9C43102AEBDE030DD3A73C704DCFC758", hash_generated_method = "F03E8C5B5C09A623867A355E91A47585")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int countDataTypes() {
        {
            Object var5CD61D88055F6C456A17888CA437F389_1152518910 = (mDataTypes.size());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDataTypes != null ? mDataTypes.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.765 -0400", hash_original_method = "1020E9310C4CEB3D9A899FFC3406F498", hash_generated_method = "FAA4BE278D4B75B081114CF9EF0E5492")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDataType(int index) {
        dsTaint.addTaint(index);
        String varAC1AEF9A8D7F226A48DD5415C682A795_126041165 = (mDataTypes.get(index));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDataTypes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.765 -0400", hash_original_method = "E14DF72F5869874CC38AD67447F5264E", hash_generated_method = "01E618F24C84A604C97F8C6E2F617A1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Iterator<String> typesIterator() {
        {
            Object var657593258184CA4A92B436289641DF6D_1864726584 = (mDataTypes.iterator());
        } //End flattened ternary
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataTypes != null ? mDataTypes.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.766 -0400", hash_original_method = "5610D5819C8C8974F702B3F76798B195", hash_generated_method = "6430EFF9DC31200234E0031DDC0217D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void addDataScheme(String scheme) {
        dsTaint.addTaint(scheme);
        mDataSchemes = new ArrayList<String>();
        {
            boolean varB4AC16761D5AE1DBD4D7BE4F78F9BCD5_1205196680 = (!mDataSchemes.contains(scheme));
            {
                mDataSchemes.add(scheme.intern());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mDataSchemes == null) mDataSchemes = new ArrayList<String>();
        //if (!mDataSchemes.contains(scheme)) {
            //mDataSchemes.add(scheme.intern());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.766 -0400", hash_original_method = "23DC2F7DC5C53386402D5B95D046A59E", hash_generated_method = "49ECA3C44E56761AF716A23436D5FFAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int countDataSchemes() {
        {
            Object var5DA05131A061F74B7E86F57B0DA2F51D_1067009912 = (mDataSchemes.size());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDataSchemes != null ? mDataSchemes.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.766 -0400", hash_original_method = "F55C42908F22C2BF6411521C019E1E71", hash_generated_method = "E24953086A0DFBF9EA337762A33A524D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDataScheme(int index) {
        dsTaint.addTaint(index);
        String varFC74C0B2C481CD01B0196F0DF955F0A6_1574593992 = (mDataSchemes.get(index));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDataSchemes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.766 -0400", hash_original_method = "6D8F15A80747973FB96EA7F310404F85", hash_generated_method = "D7D8B35A1C2EF1FC346B9A443C172A27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasDataScheme(String scheme) {
        dsTaint.addTaint(scheme);
        boolean var512C6A99EF7116D0DF5B8D796BB2F028_1291024832 = (mDataSchemes != null && mDataSchemes.contains(scheme));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDataSchemes != null && mDataSchemes.contains(scheme);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.767 -0400", hash_original_method = "B57BF7E15AE8E364684A85B4AA7D0368", hash_generated_method = "CCBCDE457A23FA1FB5CE21EBFAA14C2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Iterator<String> schemesIterator() {
        {
            Object var63A4EF5D8779B3AD25A54B35474D2B8F_520131538 = (mDataSchemes.iterator());
        } //End flattened ternary
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataSchemes != null ? mDataSchemes.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.767 -0400", hash_original_method = "617831DFB49DD0B093CE5F322F324A18", hash_generated_method = "701F020E4A4E1EF24D2D2AF235A4E2A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void addDataAuthority(String host, String port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        mDataAuthorities =
                new ArrayList<AuthorityEntry>();
        port = port.intern();
        mDataAuthorities.add(new AuthorityEntry(host.intern(), port));
        // ---------- Original Method ----------
        //if (mDataAuthorities == null) mDataAuthorities =
                //new ArrayList<AuthorityEntry>();
        //if (port != null) port = port.intern();
        //mDataAuthorities.add(new AuthorityEntry(host.intern(), port));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.767 -0400", hash_original_method = "B59B7F6BD479782A00EECCEFFFB6C78B", hash_generated_method = "896E17CCDB61363C87CA254F15C98978")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int countDataAuthorities() {
        {
            Object var7F3DBF7B704BD2D53B067BCF2DC53B65_1808985365 = (mDataAuthorities.size());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDataAuthorities != null ? mDataAuthorities.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.767 -0400", hash_original_method = "5C821D7ECF8B0A79E64F1031BF4C37BB", hash_generated_method = "1347D930786C29D0C91DF2C29DD76FDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final AuthorityEntry getDataAuthority(int index) {
        dsTaint.addTaint(index);
        AuthorityEntry varD4E9505107E18856D8C83045272D8967_783376815 = (mDataAuthorities.get(index));
        return (AuthorityEntry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataAuthorities.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.768 -0400", hash_original_method = "04C5A3803469FEAEE8E315143FC0F6BE", hash_generated_method = "77C747E1DB472A3B6EE6130434284205")
    @DSModeled(DSC.SPEC)
    public final boolean hasDataAuthority(Uri data) {
        dsTaint.addTaint(data.dsTaint);
        boolean var1270E27AB98815A5880DC4887D568CF5_1216452585 = (matchDataAuthority(data) >= 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return matchDataAuthority(data) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.768 -0400", hash_original_method = "104889BB491104C94E7C1142A3F4BAAD", hash_generated_method = "F0F0B3964750987CE6AF449D36E53825")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Iterator<AuthorityEntry> authoritiesIterator() {
        {
            Object var6FBCD587AB239B94751032DF5B6180BC_1690888800 = (mDataAuthorities.iterator());
        } //End flattened ternary
        return (Iterator<AuthorityEntry>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataAuthorities != null ? mDataAuthorities.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.768 -0400", hash_original_method = "F30E00ACF0BA9FCEBC6CDD2BDA55B075", hash_generated_method = "9D58704D3E7E530B9113DA651938FB80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void addDataPath(String path, int type) {
        dsTaint.addTaint(path);
        dsTaint.addTaint(type);
        mDataPaths = new ArrayList<PatternMatcher>();
        mDataPaths.add(new PatternMatcher(path.intern(), type));
        // ---------- Original Method ----------
        //if (mDataPaths == null) mDataPaths = new ArrayList<PatternMatcher>();
        //mDataPaths.add(new PatternMatcher(path.intern(), type));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.768 -0400", hash_original_method = "60FAB9592DF6A1D398A3997EC9565FA6", hash_generated_method = "C3EDB2E15F7F7582B507135243B56CAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int countDataPaths() {
        {
            Object var8D28E0B37D5A9D79155F890739E07533_1515211467 = (mDataPaths.size());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDataPaths != null ? mDataPaths.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.769 -0400", hash_original_method = "C7BC21A1B57BD5F3F08A1F8B8EBDB051", hash_generated_method = "311614D5EEEC4B28AF099472D4687C7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final PatternMatcher getDataPath(int index) {
        dsTaint.addTaint(index);
        PatternMatcher varC6916575DA0706623B896E116A3722A0_89916990 = (mDataPaths.get(index));
        return (PatternMatcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataPaths.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.769 -0400", hash_original_method = "8A8BB0EA1E4D89E1A8E627888FCA29D4", hash_generated_method = "ABCD3B0B37F75490D4FC5715463A524B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasDataPath(String data) {
        dsTaint.addTaint(data);
        final int numDataPaths;
        numDataPaths = mDataPaths.size();
        {
            int i;
            i = 0;
            {
                final PatternMatcher pe;
                pe = mDataPaths.get(i);
                {
                    boolean varFE731D0FCEDE70D75173DC4C2EBABD75_578951581 = (pe.match(data));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mDataPaths == null) {
            //return false;
        //}
        //final int numDataPaths = mDataPaths.size();
        //for (int i = 0; i < numDataPaths; i++) {
            //final PatternMatcher pe = mDataPaths.get(i);
            //if (pe.match(data)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.769 -0400", hash_original_method = "DFBFAEBB83F5AF41A1E2404555B650EF", hash_generated_method = "9997F4194106062D92AAF9F908525055")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Iterator<PatternMatcher> pathsIterator() {
        {
            Object var4ACC285F2B6FD8905ED7B90A679FDB5E_1352925086 = (mDataPaths.iterator());
        } //End flattened ternary
        return (Iterator<PatternMatcher>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataPaths != null ? mDataPaths.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.770 -0400", hash_original_method = "BBE034684833DCE31C3A8387BD50FAB0", hash_generated_method = "9C49FFE4C515E22072DF9DAF02349DE2")
    @DSModeled(DSC.SPEC)
    public final int matchDataAuthority(Uri data) {
        dsTaint.addTaint(data.dsTaint);
        final int numDataAuthorities;
        numDataAuthorities = mDataAuthorities.size();
        {
            int i;
            i = 0;
            {
                final AuthorityEntry ae;
                ae = mDataAuthorities.get(i);
                int match;
                match = ae.match(data);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mDataAuthorities == null) {
            //return NO_MATCH_DATA;
        //}
        //final int numDataAuthorities = mDataAuthorities.size();
        //for (int i = 0; i < numDataAuthorities; i++) {
            //final AuthorityEntry ae = mDataAuthorities.get(i);
            //int match = ae.match(data);
            //if (match >= 0) {
                //return match;
            //}
        //}
        //return NO_MATCH_DATA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.770 -0400", hash_original_method = "6458C2A82CD5BFA5489DF067AE915D84", hash_generated_method = "BF665097C79051B3ADB686CC43C134FB")
    @DSModeled(DSC.SPEC)
    public final int matchData(String type, String scheme, Uri data) {
        dsTaint.addTaint(scheme);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(type);
        final ArrayList<String> types;
        types = mDataTypes;
        final ArrayList<String> schemes;
        schemes = mDataSchemes;
        final ArrayList<AuthorityEntry> authorities;
        authorities = mDataAuthorities;
        final ArrayList<PatternMatcher> paths;
        paths = mDataPaths;
        int match;
        match = MATCH_CATEGORY_EMPTY;
        {
            {
                boolean var5E7A05A835B5CF4FFB8629732729276E_1884890727 = (schemes.contains(scheme != null ? scheme : "")); //DSFIXME:  CODE0008: Nested ternary operator in expression
                {
                    match = MATCH_CATEGORY_SCHEME;
                } //End block
            } //End collapsed parenthetic
            {
                int authMatch;
                authMatch = matchDataAuthority(data);
                {
                    {
                        match = authMatch;
                    } //End block
                    {
                        boolean varEAAE2E15E6A7D5BAE2309C583FB4447C_965772127 = (hasDataPath(data.getPath()));
                        {
                            match = MATCH_CATEGORY_PATH;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End block
        {
            {
                boolean var406CA28FF8859711A6231B15267E09A4_669272752 = (scheme != null && !"".equals(scheme)
                    && !"content".equals(scheme)
                    && !"file".equals(scheme));
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var98FC73A23AE0FAF08A0BE1B405D035C8_998804428 = (findMimeType(type));
                {
                    match = MATCH_CATEGORY_TYPE;
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.771 -0400", hash_original_method = "740A58E186A747CF3BBDAB4A3568B004", hash_generated_method = "C150EA8D890E7CD4106DAAA8FD44016D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void addCategory(String category) {
        dsTaint.addTaint(category);
        mCategories = new ArrayList<String>();
        {
            boolean var86C5C5511E5C2EED812BD9D1EEE4ACD6_756679370 = (!mCategories.contains(category));
            {
                mCategories.add(category.intern());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mCategories == null) mCategories = new ArrayList<String>();
        //if (!mCategories.contains(category)) {
            //mCategories.add(category.intern());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.771 -0400", hash_original_method = "D5AF5503C90FCC35F15F05FB572F3FAB", hash_generated_method = "99FB3C003EA638C5832409E92896F5B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int countCategories() {
        {
            Object var7750EA1BB615B3E22F7111A8C74A2076_1009430182 = (mCategories.size());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCategories != null ? mCategories.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.772 -0400", hash_original_method = "9221063C5ACD71C55B9DBC6F8D5B18B1", hash_generated_method = "328C7854F1620135C55C93F90D462CD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getCategory(int index) {
        dsTaint.addTaint(index);
        String varD15789259910CC2281EC569E0090A8F6_1094146361 = (mCategories.get(index));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCategories.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.772 -0400", hash_original_method = "3612221F73372432993CCD6954A20D1D", hash_generated_method = "BCD654C07B9D3FE96584DB4FBCDC2E9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasCategory(String category) {
        dsTaint.addTaint(category);
        boolean varC2460535E11742A1B298C090C684A3C7_1892190676 = (mCategories != null && mCategories.contains(category));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCategories != null && mCategories.contains(category);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.772 -0400", hash_original_method = "A1CBC473D8947BEFDC4AD1E1869906E2", hash_generated_method = "7A5BD857F513B22463958904374C4104")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Iterator<String> categoriesIterator() {
        {
            Object var70038AA5B05CDCC7BB0C1C80AEA6D5F6_1781066636 = (mCategories.iterator());
        } //End flattened ternary
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCategories != null ? mCategories.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.773 -0400", hash_original_method = "64ACE3DFA3E244FA74278C4A66D2BC47", hash_generated_method = "7A932A173629AF60EE52850716A757A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String matchCategories(Set<String> categories) {
        dsTaint.addTaint(categories.dsTaint);
        Iterator<String> it;
        it = categories.iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_2038105729 = (it.hasNext());
                Object var4E619BF14CFDF2F1FA575F312C1BD2EB_309513175 = (it.next());
            } //End flattened ternary
        } //End block
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1514431994 = (it.hasNext());
            {
                final String category;
                category = it.next();
                {
                    boolean var75948F6460E0068B561F42314379BAEB_1100952048 = (!mCategories.contains(category));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (categories == null) {
            //return null;
        //}
        //Iterator<String> it = categories.iterator();
        //if (mCategories == null) {
            //return it.hasNext() ? it.next() : null;
        //}
        //while (it.hasNext()) {
            //final String category = it.next();
            //if (!mCategories.contains(category)) {
                //return category;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.773 -0400", hash_original_method = "4ACC3B62E54BFBE055D3653A9CF49AD3", hash_generated_method = "B75B8D890B0ECF86E526D1A2621E7B7A")
    @DSModeled(DSC.SPEC)
    public final int match(ContentResolver resolver, Intent intent,
            boolean resolve, String logTag) {
        dsTaint.addTaint(resolve);
        dsTaint.addTaint(logTag);
        dsTaint.addTaint(resolver.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        String type;
        type = intent.resolveType(resolver);
        type = intent.getType();
        int varF65E2DDA6A4336395790B440F79EF0DA_511185692 = (match(intent.getAction(), type, intent.getScheme(),
                     intent.getData(), intent.getCategories(), logTag));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //String type = resolve ? intent.resolveType(resolver) : intent.getType();
        //return match(intent.getAction(), type, intent.getScheme(),
                     //intent.getData(), intent.getCategories(), logTag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.773 -0400", hash_original_method = "80E2BB7D6EA3B343C7B82810FBA9B369", hash_generated_method = "DD01A65C52C4F7FFA40EF523C8DC2E6C")
    @DSModeled(DSC.SPEC)
    public final int match(String action, String type, String scheme,
            Uri data, Set<String> categories, String logTag) {
        dsTaint.addTaint(scheme);
        dsTaint.addTaint(action);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(logTag);
        dsTaint.addTaint(categories.dsTaint);
        dsTaint.addTaint(type);
        {
            boolean varAB4B3F206E562062AB2373108EDF62A0_518653605 = (action != null && !matchAction(action));
        } //End collapsed parenthetic
        int dataMatch;
        dataMatch = matchData(type, scheme, data);
        String categoryMismatch;
        categoryMismatch = matchCategories(categories);
        {
            {
                dataMatch -= mCategories.size() - categories.size();
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.775 -0400", hash_original_method = "B6C33F6C9AFBFD4465A32F9300C74AFB", hash_generated_method = "401209B9AA1C5726AE9AF98C76C74FF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToXml(XmlSerializer serializer) throws IOException {
        dsTaint.addTaint(serializer.dsTaint);
        int N;
        N = countActions();
        {
            int i;
            i = 0;
            {
                serializer.startTag(null, ACTION_STR);
                serializer.attribute(null, NAME_STR, mActions.get(i));
                serializer.endTag(null, ACTION_STR);
            } //End block
        } //End collapsed parenthetic
        N = countCategories();
        {
            int i;
            i = 0;
            {
                serializer.startTag(null, CAT_STR);
                serializer.attribute(null, NAME_STR, mCategories.get(i));
                serializer.endTag(null, CAT_STR);
            } //End block
        } //End collapsed parenthetic
        N = countDataTypes();
        {
            int i;
            i = 0;
            {
                serializer.startTag(null, TYPE_STR);
                String type;
                type = mDataTypes.get(i);
                {
                    boolean varF5C6D5EBEA0A2A1C0C5B585B8E141902_1782522371 = (type.indexOf('/') < 0);
                    type = type + "/*";
                } //End collapsed parenthetic
                serializer.attribute(null, NAME_STR, type);
                serializer.endTag(null, TYPE_STR);
            } //End block
        } //End collapsed parenthetic
        N = countDataSchemes();
        {
            int i;
            i = 0;
            {
                serializer.startTag(null, SCHEME_STR);
                serializer.attribute(null, NAME_STR, mDataSchemes.get(i));
                serializer.endTag(null, SCHEME_STR);
            } //End block
        } //End collapsed parenthetic
        N = countDataAuthorities();
        {
            int i;
            i = 0;
            {
                serializer.startTag(null, AUTH_STR);
                AuthorityEntry ae;
                ae = mDataAuthorities.get(i);
                serializer.attribute(null, HOST_STR, ae.getHost());
                {
                    boolean varD52B50DE393A2B2F765AF58DB2789B84_1266022364 = (ae.getPort() >= 0);
                    {
                        serializer.attribute(null, PORT_STR, Integer.toString(ae.getPort()));
                    } //End block
                } //End collapsed parenthetic
                serializer.endTag(null, AUTH_STR);
            } //End block
        } //End collapsed parenthetic
        N = countDataPaths();
        {
            int i;
            i = 0;
            {
                serializer.startTag(null, PATH_STR);
                PatternMatcher pe;
                pe = mDataPaths.get(i);
                {
                    Object var3F55985824039D507E9B86622028DD13_131831637 = (pe.getType());
                    //Begin case PatternMatcher.PATTERN_LITERAL 
                    serializer.attribute(null, LITERAL_STR, pe.getPath());
                    //End case PatternMatcher.PATTERN_LITERAL 
                    //Begin case PatternMatcher.PATTERN_PREFIX 
                    serializer.attribute(null, PREFIX_STR, pe.getPath());
                    //End case PatternMatcher.PATTERN_PREFIX 
                    //Begin case PatternMatcher.PATTERN_SIMPLE_GLOB 
                    serializer.attribute(null, SGLOB_STR, pe.getPath());
                    //End case PatternMatcher.PATTERN_SIMPLE_GLOB 
                } //End collapsed parenthetic
                serializer.endTag(null, PATH_STR);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.776 -0400", hash_original_method = "276CC8B213E249CE42650F70E7C4B53B", hash_generated_method = "2952C76F908D61699437E9491A643493")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromXml(XmlPullParser parser) throws XmlPullParserException,
            IOException {
        dsTaint.addTaint(parser.dsTaint);
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var003C1B2273232C3B7B27A28F0A982195_2033565922 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth));
            {
                String tagName;
                tagName = parser.getName();
                {
                    boolean varFCDCA384B5AE04B7C812E6C97E646171_963295501 = (tagName.equals(ACTION_STR));
                    {
                        String name;
                        name = parser.getAttributeValue(null, NAME_STR);
                        {
                            addAction(name);
                        } //End block
                    } //End block
                    {
                        boolean varA79B623DA4F2C04CCACF87A377409319_435474309 = (tagName.equals(CAT_STR));
                        {
                            String name;
                            name = parser.getAttributeValue(null, NAME_STR);
                            {
                                addCategory(name);
                            } //End block
                        } //End block
                        {
                            boolean var977A45C559BECBE43F4912D2273DF0C8_1909378990 = (tagName.equals(TYPE_STR));
                            {
                                String name;
                                name = parser.getAttributeValue(null, NAME_STR);
                                {
                                    try 
                                    {
                                        addDataType(name);
                                    } //End block
                                    catch (MalformedMimeTypeException e)
                                    { }
                                } //End block
                            } //End block
                            {
                                boolean var6DC38F2E64C783805E18B68A201E5478_1913529701 = (tagName.equals(SCHEME_STR));
                                {
                                    String name;
                                    name = parser.getAttributeValue(null, NAME_STR);
                                    {
                                        addDataScheme(name);
                                    } //End block
                                } //End block
                                {
                                    boolean var8853BBB6CFA09C0887644DF8808FF11A_1945818337 = (tagName.equals(AUTH_STR));
                                    {
                                        String host;
                                        host = parser.getAttributeValue(null, HOST_STR);
                                        String port;
                                        port = parser.getAttributeValue(null, PORT_STR);
                                        {
                                            addDataAuthority(host, port);
                                        } //End block
                                    } //End block
                                    {
                                        boolean var22FFAE6F647F1E2186452AB348DF879B_1134124772 = (tagName.equals(PATH_STR));
                                        {
                                            String path;
                                            path = parser.getAttributeValue(null, LITERAL_STR);
                                            {
                                                addDataPath(path, PatternMatcher.PATTERN_LITERAL);
                                            } //End block
                                            {
                                                boolean varFD9E988BC7BA6C67FA0846D5B6BA2EAE_994542303 = ((path=parser.getAttributeValue(null, PREFIX_STR)) != null);
                                                {
                                                    addDataPath(path, PatternMatcher.PATTERN_PREFIX);
                                                } //End block
                                                {
                                                    boolean var65A46A0D515CAD733F17FA4060913973_268383907 = ((path=parser.getAttributeValue(null, SGLOB_STR)) != null);
                                                    {
                                                        addDataPath(path, PatternMatcher.PATTERN_SIMPLE_GLOB);
                                                    } //End block
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                XmlUtils.skipCurrentTag(parser);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.778 -0400", hash_original_method = "75FFB292CCD000E47FA0C7D0BE596A36", hash_generated_method = "AE5F836F5534CC251022615A5479159C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(Printer du, String prefix) {
        dsTaint.addTaint(du.dsTaint);
        dsTaint.addTaint(prefix);
        StringBuilder sb;
        sb = new StringBuilder(256);
        {
            boolean var71B9BA72BB6B517DA479CF3A88B95269_179519517 = (mActions.size() > 0);
            {
                Iterator<String> it;
                it = mActions.iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1614505558 = (it.hasNext());
                    {
                        sb.setLength(0);
                        sb.append(prefix);
                        sb.append("Action: \"");
                        sb.append(it.next());
                        sb.append("\"");
                        du.println(sb.toString());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<String> it;
            it = mCategories.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_476169859 = (it.hasNext());
                {
                    sb.setLength(0);
                    sb.append(prefix);
                    sb.append("Category: \"");
                    sb.append(it.next());
                    sb.append("\"");
                    du.println(sb.toString());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            Iterator<String> it;
            it = mDataSchemes.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1353537295 = (it.hasNext());
                {
                    sb.setLength(0);
                    sb.append(prefix);
                    sb.append("Scheme: \"");
                    sb.append(it.next());
                    sb.append("\"");
                    du.println(sb.toString());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            Iterator<AuthorityEntry> it;
            it = mDataAuthorities.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_4645988 = (it.hasNext());
                {
                    AuthorityEntry ae;
                    ae = it.next();
                    sb.setLength(0);
                    sb.append(prefix);
                    sb.append("Authority: \"");
                    sb.append(ae.mHost);
                    sb.append("\": ");
                    sb.append(ae.mPort);
                    sb.append(" WILD");
                    du.println(sb.toString());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            Iterator<PatternMatcher> it;
            it = mDataPaths.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_2087547415 = (it.hasNext());
                {
                    PatternMatcher pe;
                    pe = it.next();
                    sb.setLength(0);
                    sb.append(prefix);
                    sb.append("Path: \"");
                    sb.append(pe);
                    sb.append("\"");
                    du.println(sb.toString());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            Iterator<String> it;
            it = mDataTypes.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1291684177 = (it.hasNext());
                {
                    sb.setLength(0);
                    sb.append(prefix);
                    sb.append("Type: \"");
                    sb.append(it.next());
                    sb.append("\"");
                    du.println(sb.toString());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            sb.setLength(0);
            sb.append(prefix);
            sb.append("mPriority=");
            sb.append(mPriority);
            sb.append(", mHasPartialTypes=");
            sb.append(mHasPartialTypes);
            du.println(sb.toString());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.778 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "30BCFFA9B1C480838D68247F85D05CD2")
    @DSModeled(DSC.SAFE)
    public final int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.779 -0400", hash_original_method = "2C734948869786E017228B90D172BE24", hash_generated_method = "17D86D085BBBC5264E1785C3D2DD6091")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeStringList(mActions);
        {
            dest.writeInt(1);
            dest.writeStringList(mCategories);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        {
            dest.writeInt(1);
            dest.writeStringList(mDataSchemes);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        {
            dest.writeInt(1);
            dest.writeStringList(mDataTypes);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        {
            final int N;
            N = mDataAuthorities.size();
            dest.writeInt(N);
            {
                int i;
                i = 0;
                {
                    mDataAuthorities.get(i).writeToParcel(dest);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            dest.writeInt(0);
        } //End block
        {
            final int N;
            N = mDataPaths.size();
            dest.writeInt(N);
            {
                int i;
                i = 0;
                {
                    mDataPaths.get(i).writeToParcel(dest, 0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            dest.writeInt(0);
        } //End block
        dest.writeInt(mPriority);
        dest.writeInt(mHasPartialTypes ? 1 : 0);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.779 -0400", hash_original_method = "FBEEEBAC37A62143C058604C825166BE", hash_generated_method = "965DBE4E0B0F342DBC977F8963CFCC99")
    @DSModeled(DSC.SAFE)
    public boolean debugCheck() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.780 -0400", hash_original_method = "742383A5720F36FAAE26E247984D38D1", hash_generated_method = "A041A438BEBBC7743B5E64A119CDD86F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final boolean findMimeType(String type) {
        dsTaint.addTaint(type);
        final ArrayList<String> t;
        t = mDataTypes;
        {
            boolean var94BA75702969E64AAFAD0932F9F19FE6_1606139576 = (t.contains(type));
        } //End collapsed parenthetic
        final int typeLength;
        typeLength = type.length();
        {
            boolean varC0B1C251D972DB5100663171FE0ED803_1803536965 = (typeLength == 3 && type.equals("*/*"));
            {
                boolean var207FD69B8C4084DC550BC184B4637898_1798772500 = (!t.isEmpty());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDD39D56D1526DF18BC77C0B3DD038B55_1748039818 = (mHasPartialTypes && t.contains("*"));
        } //End collapsed parenthetic
        final int slashpos;
        slashpos = type.indexOf('/');
        {
            {
                boolean var6B9A6E4432B816B7E7FEA6713DF1EE03_1504968905 = (mHasPartialTypes && t.contains(type.substring(0, slashpos)));
            } //End collapsed parenthetic
            {
                boolean varAF563929C59A468F116FAF629096DE41_724818170 = (typeLength == slashpos+2 && type.charAt(slashpos+1) == '*');
                {
                    final int numTypes;
                    numTypes = t.size();
                    {
                        int i;
                        i = 0;
                        {
                            final String v;
                            v = t.get(i);
                            {
                                boolean var11CCA35FDF5142E21DA9AFB5AAC19B77_2114375521 = (type.regionMatches(0, v, 0, slashpos+1));
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class MalformedMimeTypeException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.780 -0400", hash_original_method = "8500983E91FE33F50F26D266A654E6C8", hash_generated_method = "D1C5E446F628C7877FF5BEDB606210C7")
        @DSModeled(DSC.SAFE)
        public MalformedMimeTypeException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.780 -0400", hash_original_method = "E06B6BA43D42AE50E4C9A14EEBF56FAC", hash_generated_method = "FB69DDB114C18E3EE21E902924B63A8B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MalformedMimeTypeException(String name) {
            super(name);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
        }

        
    }


    
    public final static class AuthorityEntry {
        private final String mOrigHost;
        private final String mHost;
        private final boolean mWild;
        private final int mPort;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.781 -0400", hash_original_method = "FAC1F38311ACA5CF1D84B9DFACCAD236", hash_generated_method = "9D1CC3A5279DD653EC6BECB415F36C5E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AuthorityEntry(String host, String port) {
            dsTaint.addTaint(port);
            dsTaint.addTaint(host);
            mWild = host.length() > 0 && host.charAt(0) == '*';
            mHost = mWild ? host.substring(1).intern() : host;
            mPort = port != null ? Integer.parseInt(port) : -1;
            // ---------- Original Method ----------
            //mOrigHost = host;
            //mWild = host.length() > 0 && host.charAt(0) == '*';
            //mHost = mWild ? host.substring(1).intern() : host;
            //mPort = port != null ? Integer.parseInt(port) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.781 -0400", hash_original_method = "9AA41EA6C96E16AD56B52F388CEAC244", hash_generated_method = "FA556252563A77F0601A13415B29F00E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         AuthorityEntry(Parcel src) {
            dsTaint.addTaint(src.dsTaint);
            mOrigHost = src.readString();
            mHost = src.readString();
            mWild = src.readInt() != 0;
            mPort = src.readInt();
            // ---------- Original Method ----------
            //mOrigHost = src.readString();
            //mHost = src.readString();
            //mWild = src.readInt() != 0;
            //mPort = src.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.781 -0400", hash_original_method = "3FD27104A5CDDCA498D8F62DC306DFFB", hash_generated_method = "725D7A1814F7E379FF3790218EE89EC1")
        @DSModeled(DSC.SAFE)
         void writeToParcel(Parcel dest) {
            dsTaint.addTaint(dest.dsTaint);
            dest.writeString(mOrigHost);
            dest.writeString(mHost);
            dest.writeInt(mWild ? 1 : 0);
            dest.writeInt(mPort);
            // ---------- Original Method ----------
            //dest.writeString(mOrigHost);
            //dest.writeString(mHost);
            //dest.writeInt(mWild ? 1 : 0);
            //dest.writeInt(mPort);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.781 -0400", hash_original_method = "56B964ED44110D4A8630C57ED8411A1C", hash_generated_method = "74D81BB704FADA055F3260FE8B2007AC")
        @DSModeled(DSC.SAFE)
        public String getHost() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mOrigHost;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.781 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "15B913872630FEC82C8C724DE4684D9A")
        @DSModeled(DSC.SAFE)
        public int getPort() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mPort;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.782 -0400", hash_original_method = "FC31CC7FA89B702CE4ED1283F0D70C24", hash_generated_method = "172A776973DD2C927FF3D47F19298748")
        @DSModeled(DSC.SPEC)
        public int match(Uri data) {
            dsTaint.addTaint(data.dsTaint);
            String host;
            host = data.getHost();
            {
                {
                    boolean var1B71F291A87433E0716DC39D697C7F3A_942843594 = (host.length() < mHost.length());
                } //End collapsed parenthetic
                host = host.substring(host.length()-mHost.length());
            } //End block
            {
                boolean var7D1AEF3A34E8E1E90AF70D1486121E66_944128759 = (host.compareToIgnoreCase(mHost) != 0);
            } //End collapsed parenthetic
            {
                {
                    boolean var9F3060E6F5D255CBEEDF2919EC07ED98_1031479703 = (mPort != data.getPort());
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //String host = data.getHost();
            //if (host == null) {
                //return NO_MATCH_DATA;
            //}
            //if (false) Log.v("IntentFilter",
                    //"Match host " + host + ": " + mHost);
            //if (mWild) {
                //if (host.length() < mHost.length()) {
                    //return NO_MATCH_DATA;
                //}
                //host = host.substring(host.length()-mHost.length());
            //}
            //if (host.compareToIgnoreCase(mHost) != 0) {
                //return NO_MATCH_DATA;
            //}
            //if (mPort >= 0) {
                //if (mPort != data.getPort()) {
                    //return NO_MATCH_DATA;
                //}
                //return MATCH_CATEGORY_PORT;
            //}
            //return MATCH_CATEGORY_HOST;
        }

        
    }


    
}


