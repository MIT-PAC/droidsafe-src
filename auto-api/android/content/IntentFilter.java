package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.283 -0400", hash_original_field = "22FC7A378B4F7C5F90F70A47BE1E4FCD", hash_generated_field = "032B46B6D9E42E1E80E269F8E583852A")

    private int mPriority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.283 -0400", hash_original_field = "C268D719F2F67098628D1A8EEBB72B48", hash_generated_field = "B7B787904E751334D4C6C5E9190CBECB")

    private ArrayList<String> mActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.283 -0400", hash_original_field = "E5C591146E984CF70A027B756462CD3D", hash_generated_field = "DF1B13D35CEEB5232DEB8422E072E169")

    private ArrayList<String> mCategories = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.283 -0400", hash_original_field = "ACE6ED917BE479CC0451087F07844425", hash_generated_field = "D6C69DEDF341F4A4196AEA26E81D24A7")

    private ArrayList<String> mDataSchemes = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.283 -0400", hash_original_field = "B7BD82E78C46D9D79C64D1CD52A40D35", hash_generated_field = "C318D366A8228836F69A6B4BDDBFB506")

    private ArrayList<AuthorityEntry> mDataAuthorities = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.283 -0400", hash_original_field = "B61E65339F4663631A2F55699D0303D1", hash_generated_field = "2207044C23DD28F016FBFC7451C9D66A")

    private ArrayList<PatternMatcher> mDataPaths = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.283 -0400", hash_original_field = "606D718D7940DF43E42D0547DAABEADA", hash_generated_field = "06256A3E596C9EB087048F541BEAB278")

    private ArrayList<String> mDataTypes = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.283 -0400", hash_original_field = "9D8D79625D9E596046C5C52803A8BF48", hash_generated_field = "A768E3466CCFB1BF3BC36D8E0C71D999")

    private boolean mHasPartialTypes = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.284 -0400", hash_original_method = "E570235BD10D63A46D952627D4823B55", hash_generated_method = "7B0E4140638D2A4CB4A4CCA023BAD3B0")
    public  IntentFilter() {
        mPriority = 0;
        mActions = new ArrayList<String>();
        // ---------- Original Method ----------
        //mPriority = 0;
        //mActions = new ArrayList<String>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.285 -0400", hash_original_method = "6BE32B941606799E1C4582399143D6DE", hash_generated_method = "B976B6B42BC2F5D5D03C7855FFD6D5F1")
    public  IntentFilter(String action) {
        mPriority = 0;
        mActions = new ArrayList<String>();
        addAction(action);
        addTaint(action.getTaint());
        // ---------- Original Method ----------
        //mPriority = 0;
        //mActions = new ArrayList<String>();
        //addAction(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.286 -0400", hash_original_method = "6F03ACB8C3DEEE507BC72687512BE15B", hash_generated_method = "C3DC77DE4FFE9C6A486D4413368FFCFC")
    public  IntentFilter(String action, String dataType) throws MalformedMimeTypeException {
        mPriority = 0;
        mActions = new ArrayList<String>();
        addAction(action);
        addDataType(dataType);
        addTaint(action.getTaint());
        addTaint(dataType.getTaint());
        // ---------- Original Method ----------
        //mPriority = 0;
        //mActions = new ArrayList<String>();
        //addAction(action);
        //addDataType(dataType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.287 -0400", hash_original_method = "1836401D6B82BE6CCBD088E7B5026D41", hash_generated_method = "712920B6E34B5EF9B0CD0503E5C6E0DF")
    public  IntentFilter(IntentFilter o) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.288 -0400", hash_original_method = "0A18E8175DAFA9E0ECB5A7A15F664AD8", hash_generated_method = "8FB5AA208047194498C8132E975C79DE")
    private  IntentFilter(Parcel source) {
        mActions = new ArrayList<String>();
        source.readStringList(mActions);
        {
            boolean varFD16828A378FD83700BE97539951F787_1189280930 = (source.readInt() != 0);
            {
                mCategories = new ArrayList<String>();
                source.readStringList(mCategories);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFD16828A378FD83700BE97539951F787_1700774902 = (source.readInt() != 0);
            {
                mDataSchemes = new ArrayList<String>();
                source.readStringList(mDataSchemes);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFD16828A378FD83700BE97539951F787_1018321867 = (source.readInt() != 0);
            {
                mDataTypes = new ArrayList<String>();
                source.readStringList(mDataTypes);
            } //End block
        } //End collapsed parenthetic
        int N = source.readInt();
        {
            mDataAuthorities = new ArrayList<AuthorityEntry>();
            {
                int i = 0;
                {
                    mDataAuthorities.add(new AuthorityEntry(source));
                } //End block
            } //End collapsed parenthetic
        } //End block
        N = source.readInt();
        {
            mDataPaths = new ArrayList<PatternMatcher>();
            {
                int i = 0;
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

    
    private static int findStringInSet(String[] set, String string,
            int[] lengths, int lenPos) {
        if (set == null) return -1;
        final int N = lengths[lenPos];
        for (int i=0; i<N; i++) {
            if (set[i].equals(string)) return i;
        }
        return -1;
    }

    
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

    
    public static IntentFilter create(String action, String dataType) {
        try {
            return new IntentFilter(action, dataType);
        } catch (MalformedMimeTypeException e) {
            throw new RuntimeException("Bad MIME type", e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.290 -0400", hash_original_method = "1AF904ED06333BC0001A5A8D0FC8E3CC", hash_generated_method = "839A047CDB79A7FD6A97DD19F37CB628")
    public final void setPriority(int priority) {
        mPriority = priority;
        // ---------- Original Method ----------
        //mPriority = priority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.290 -0400", hash_original_method = "4CF75B39A2F3F4074ED78E7B55CDB45C", hash_generated_method = "6C92EA1D1EA1509EF5BCEF8FA93AD1B6")
    public final int getPriority() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_884625876 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_884625876;
        // ---------- Original Method ----------
        //return mPriority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.291 -0400", hash_original_method = "FFF5B803FCB58F324812D605B6C9CE62", hash_generated_method = "EF92918C50EBACB5B648300E11B47CB4")
    public final void addAction(String action) {
        {
            boolean varDA3436D9D4672C232973BD25181DC765_1077169180 = (!mActions.contains(action));
            {
                mActions.add(action.intern());
            } //End block
        } //End collapsed parenthetic
        addTaint(action.getTaint());
        // ---------- Original Method ----------
        //if (!mActions.contains(action)) {
            //mActions.add(action.intern());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.291 -0400", hash_original_method = "77921182B442B1D522A9772E07DC4CA3", hash_generated_method = "DDAB72CF0198AB472693FC82D64FFCC1")
    public final int countActions() {
        int var19FD9BE92ED9235C35782B147251E19B_548531672 = (mActions.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895907187 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895907187;
        // ---------- Original Method ----------
        //return mActions.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.292 -0400", hash_original_method = "50CEFE8EA652B37B9EBFC8EA367BBC71", hash_generated_method = "6FFD80170FBF8694C62324FB3BE2A194")
    public final String getAction(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_917085000 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_917085000 = mActions.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_917085000.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_917085000;
        // ---------- Original Method ----------
        //return mActions.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.292 -0400", hash_original_method = "9D48CC1056269867443B9FC005D01764", hash_generated_method = "A64F3D3F9ACD73E99BA480A16CE889E8")
    public final boolean hasAction(String action) {
        boolean varDF0CCFFC7BDE2E2A2BCDBD16345F594C_249415490 = (action != null && mActions.contains(action));
        addTaint(action.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1113312981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1113312981;
        // ---------- Original Method ----------
        //return action != null && mActions.contains(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.293 -0400", hash_original_method = "984560EB63068E6413989919BB90D187", hash_generated_method = "7739777BDE8305C89EF1D3A35BA72951")
    public final boolean matchAction(String action) {
        boolean var9B5661F26B968C4AAD3608BADBD8A775_1558160423 = (hasAction(action));
        addTaint(action.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1218002185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1218002185;
        // ---------- Original Method ----------
        //return hasAction(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.294 -0400", hash_original_method = "91B40E19A4EE68D85BFA3F1F256EBA72", hash_generated_method = "0F585348D832B7B9023C6273CEB7FBAB")
    public final Iterator<String> actionsIterator() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1170067784 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1170067784 = mActions != null ? mActions.iterator() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1170067784.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1170067784;
        // ---------- Original Method ----------
        //return mActions != null ? mActions.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.295 -0400", hash_original_method = "B72DE1FACB480BB8E2AD802A23898A2F", hash_generated_method = "DAD841251E694D3C3CC835077EEC71BD")
    public final void addDataType(String type) throws MalformedMimeTypeException {
        final int slashpos = type.indexOf('/');
        final int typelen = type.length();
        {
            mDataTypes = new ArrayList<String>();
            {
                boolean var38C7C9D7B7DBF9B40D4D0FBD0F6AD99E_1120658663 = (typelen == slashpos+2 && type.charAt(slashpos+1) == '*');
                {
                    String str = type.substring(0, slashpos);
                    {
                        boolean varD49CE2200355496BB92B3C202D8BDEE3_1877107710 = (!mDataTypes.contains(str));
                        {
                            mDataTypes.add(str.intern());
                        } //End block
                    } //End collapsed parenthetic
                    mHasPartialTypes = true;
                } //End block
                {
                    {
                        boolean var14F656F6D90E73ACD7CC37F6B5F05D46_1846734022 = (!mDataTypes.contains(type));
                        {
                            mDataTypes.add(type.intern());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new MalformedMimeTypeException(type);
        addTaint(type.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.295 -0400", hash_original_method = "9AF334B8B7AF494EC1E65710EFD1F300", hash_generated_method = "A39289F667E1F2B7F3E4A3FACD36B555")
    public final boolean hasDataType(String type) {
        boolean var0425380B65E8B08CE43D132BFE5C72CF_1088149547 = (mDataTypes != null && findMimeType(type));
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1600336108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1600336108;
        // ---------- Original Method ----------
        //return mDataTypes != null && findMimeType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.297 -0400", hash_original_method = "9C43102AEBDE030DD3A73C704DCFC758", hash_generated_method = "72105519388FB460DDFCC9A261EABCEF")
    public final int countDataTypes() {
        {
            Object var5CD61D88055F6C456A17888CA437F389_1964259196 = (mDataTypes.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798645064 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798645064;
        // ---------- Original Method ----------
        //return mDataTypes != null ? mDataTypes.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.300 -0400", hash_original_method = "1020E9310C4CEB3D9A899FFC3406F498", hash_generated_method = "150A6523827DF1BBA6FC7F8621551BAE")
    public final String getDataType(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_728382392 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_728382392 = mDataTypes.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_728382392.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_728382392;
        // ---------- Original Method ----------
        //return mDataTypes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.302 -0400", hash_original_method = "E14DF72F5869874CC38AD67447F5264E", hash_generated_method = "A5DB2017B7D35D7251D6A1E181ACAD9D")
    public final Iterator<String> typesIterator() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1131834269 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1131834269 = mDataTypes != null ? mDataTypes.iterator() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1131834269.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1131834269;
        // ---------- Original Method ----------
        //return mDataTypes != null ? mDataTypes.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.303 -0400", hash_original_method = "5610D5819C8C8974F702B3F76798B195", hash_generated_method = "5D694DD7A38F7713F2F2F22A69FE5976")
    public final void addDataScheme(String scheme) {
        mDataSchemes = new ArrayList<String>();
        {
            boolean varB4AC16761D5AE1DBD4D7BE4F78F9BCD5_1246753708 = (!mDataSchemes.contains(scheme));
            {
                mDataSchemes.add(scheme.intern());
            } //End block
        } //End collapsed parenthetic
        addTaint(scheme.getTaint());
        // ---------- Original Method ----------
        //if (mDataSchemes == null) mDataSchemes = new ArrayList<String>();
        //if (!mDataSchemes.contains(scheme)) {
            //mDataSchemes.add(scheme.intern());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.303 -0400", hash_original_method = "23DC2F7DC5C53386402D5B95D046A59E", hash_generated_method = "35E33AD20CB6FED7A766B41EB98DAD9D")
    public final int countDataSchemes() {
        {
            Object var5DA05131A061F74B7E86F57B0DA2F51D_1144343443 = (mDataSchemes.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_266824420 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_266824420;
        // ---------- Original Method ----------
        //return mDataSchemes != null ? mDataSchemes.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.304 -0400", hash_original_method = "F55C42908F22C2BF6411521C019E1E71", hash_generated_method = "E1A04871E922688CE1D8D182789BF7F7")
    public final String getDataScheme(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1627784538 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1627784538 = mDataSchemes.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1627784538.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1627784538;
        // ---------- Original Method ----------
        //return mDataSchemes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.305 -0400", hash_original_method = "6D8F15A80747973FB96EA7F310404F85", hash_generated_method = "8F9F58B759C13C7F5CA72A18AED8D108")
    public final boolean hasDataScheme(String scheme) {
        boolean var512C6A99EF7116D0DF5B8D796BB2F028_870690755 = (mDataSchemes != null && mDataSchemes.contains(scheme));
        addTaint(scheme.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_391835833 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_391835833;
        // ---------- Original Method ----------
        //return mDataSchemes != null && mDataSchemes.contains(scheme);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.307 -0400", hash_original_method = "B57BF7E15AE8E364684A85B4AA7D0368", hash_generated_method = "B5BD58E1CA15A532729E2D0475208662")
    public final Iterator<String> schemesIterator() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1365972365 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1365972365 = mDataSchemes != null ? mDataSchemes.iterator() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1365972365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1365972365;
        // ---------- Original Method ----------
        //return mDataSchemes != null ? mDataSchemes.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.308 -0400", hash_original_method = "617831DFB49DD0B093CE5F322F324A18", hash_generated_method = "89AF2CB20AEBF24655E2F775BF782B64")
    public final void addDataAuthority(String host, String port) {
        mDataAuthorities =
                new ArrayList<AuthorityEntry>();
        port = port.intern();
        mDataAuthorities.add(new AuthorityEntry(host.intern(), port));
        addTaint(host.getTaint());
        addTaint(port.getTaint());
        // ---------- Original Method ----------
        //if (mDataAuthorities == null) mDataAuthorities =
                //new ArrayList<AuthorityEntry>();
        //if (port != null) port = port.intern();
        //mDataAuthorities.add(new AuthorityEntry(host.intern(), port));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.311 -0400", hash_original_method = "B59B7F6BD479782A00EECCEFFFB6C78B", hash_generated_method = "9F36DBD7DA1BFAF03F444BAFCD30645E")
    public final int countDataAuthorities() {
        {
            Object var7F3DBF7B704BD2D53B067BCF2DC53B65_1806502509 = (mDataAuthorities.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888831794 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888831794;
        // ---------- Original Method ----------
        //return mDataAuthorities != null ? mDataAuthorities.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.312 -0400", hash_original_method = "5C821D7ECF8B0A79E64F1031BF4C37BB", hash_generated_method = "39B8FA46CF333FEA6528A105EB2AAF2C")
    public final AuthorityEntry getDataAuthority(int index) {
        AuthorityEntry varB4EAC82CA7396A68D541C85D26508E83_717205772 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_717205772 = mDataAuthorities.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_717205772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_717205772;
        // ---------- Original Method ----------
        //return mDataAuthorities.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.313 -0400", hash_original_method = "04C5A3803469FEAEE8E315143FC0F6BE", hash_generated_method = "531AAF5D9DDA2482F570D4EE97E1BD16")
    public final boolean hasDataAuthority(Uri data) {
        boolean var1270E27AB98815A5880DC4887D568CF5_1548330994 = (matchDataAuthority(data) >= 0);
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_928690023 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_928690023;
        // ---------- Original Method ----------
        //return matchDataAuthority(data) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.314 -0400", hash_original_method = "104889BB491104C94E7C1142A3F4BAAD", hash_generated_method = "439EC1477C1DBDA34B9B22BC76A5C17A")
    public final Iterator<AuthorityEntry> authoritiesIterator() {
        Iterator<AuthorityEntry> varB4EAC82CA7396A68D541C85D26508E83_401919911 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_401919911 = mDataAuthorities != null ? mDataAuthorities.iterator() : null;
        varB4EAC82CA7396A68D541C85D26508E83_401919911.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_401919911;
        // ---------- Original Method ----------
        //return mDataAuthorities != null ? mDataAuthorities.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.315 -0400", hash_original_method = "F30E00ACF0BA9FCEBC6CDD2BDA55B075", hash_generated_method = "2EF2319E1406271F8319FC082BEF491D")
    public final void addDataPath(String path, int type) {
        mDataPaths = new ArrayList<PatternMatcher>();
        mDataPaths.add(new PatternMatcher(path.intern(), type));
        addTaint(path.getTaint());
        addTaint(type);
        // ---------- Original Method ----------
        //if (mDataPaths == null) mDataPaths = new ArrayList<PatternMatcher>();
        //mDataPaths.add(new PatternMatcher(path.intern(), type));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.315 -0400", hash_original_method = "60FAB9592DF6A1D398A3997EC9565FA6", hash_generated_method = "4E1D401783E62E77702A8739CF815F56")
    public final int countDataPaths() {
        {
            Object var8D28E0B37D5A9D79155F890739E07533_84209942 = (mDataPaths.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_196935437 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_196935437;
        // ---------- Original Method ----------
        //return mDataPaths != null ? mDataPaths.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.316 -0400", hash_original_method = "C7BC21A1B57BD5F3F08A1F8B8EBDB051", hash_generated_method = "72640B357FE4E72B1A1CA95B467E488B")
    public final PatternMatcher getDataPath(int index) {
        PatternMatcher varB4EAC82CA7396A68D541C85D26508E83_1256405229 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1256405229 = mDataPaths.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1256405229.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1256405229;
        // ---------- Original Method ----------
        //return mDataPaths.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.317 -0400", hash_original_method = "8A8BB0EA1E4D89E1A8E627888FCA29D4", hash_generated_method = "7B97C19E1E444979F9BAD9F82D953EB9")
    public final boolean hasDataPath(String data) {
        final int numDataPaths = mDataPaths.size();
        {
            int i = 0;
            {
                final PatternMatcher pe = mDataPaths.get(i);
                {
                    boolean varFE731D0FCEDE70D75173DC4C2EBABD75_1229005456 = (pe.match(data));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_431906673 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_431906673;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.319 -0400", hash_original_method = "DFBFAEBB83F5AF41A1E2404555B650EF", hash_generated_method = "C9A30E4DD609B886F1FB956FB02AA0A4")
    public final Iterator<PatternMatcher> pathsIterator() {
        Iterator<PatternMatcher> varB4EAC82CA7396A68D541C85D26508E83_1388255708 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1388255708 = mDataPaths != null ? mDataPaths.iterator() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1388255708.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1388255708;
        // ---------- Original Method ----------
        //return mDataPaths != null ? mDataPaths.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.321 -0400", hash_original_method = "BBE034684833DCE31C3A8387BD50FAB0", hash_generated_method = "F1793F53A9FFCDF3311E4F90A01EC816")
    public final int matchDataAuthority(Uri data) {
        final int numDataAuthorities = mDataAuthorities.size();
        {
            int i = 0;
            {
                final AuthorityEntry ae = mDataAuthorities.get(i);
                int match = ae.match(data);
            } //End block
        } //End collapsed parenthetic
        addTaint(data.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_44237988 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_44237988;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.322 -0400", hash_original_method = "6458C2A82CD5BFA5489DF067AE915D84", hash_generated_method = "9154B41D3763B2D5A7FE4A5BD139B20B")
    public final int matchData(String type, String scheme, Uri data) {
        final ArrayList<String> types = mDataTypes;
        final ArrayList<String> schemes = mDataSchemes;
        final ArrayList<AuthorityEntry> authorities = mDataAuthorities;
        final ArrayList<PatternMatcher> paths = mDataPaths;
        int match = MATCH_CATEGORY_EMPTY;
        {
            {
                boolean var5E7A05A835B5CF4FFB8629732729276E_1497230149 = (schemes.contains(scheme != null ? scheme : "")); //DSFIXME:  CODE0008: Nested ternary operator in expression
                {
                    match = MATCH_CATEGORY_SCHEME;
                } //End block
            } //End collapsed parenthetic
            {
                int authMatch = matchDataAuthority(data);
                {
                    {
                        match = authMatch;
                    } //End block
                    {
                        boolean varEAAE2E15E6A7D5BAE2309C583FB4447C_209112948 = (hasDataPath(data.getPath()));
                        {
                            match = MATCH_CATEGORY_PATH;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End block
        {
            {
                boolean var406CA28FF8859711A6231B15267E09A4_847327454 = (scheme != null && !"".equals(scheme)
                    && !"content".equals(scheme)
                    && !"file".equals(scheme));
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var98FC73A23AE0FAF08A0BE1B405D035C8_1615568046 = (findMimeType(type));
                {
                    match = MATCH_CATEGORY_TYPE;
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(type.getTaint());
        addTaint(scheme.getTaint());
        addTaint(data.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838612096 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838612096;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.323 -0400", hash_original_method = "740A58E186A747CF3BBDAB4A3568B004", hash_generated_method = "F931A93F8FC603D7AB5821496E8E6C1F")
    public final void addCategory(String category) {
        mCategories = new ArrayList<String>();
        {
            boolean var86C5C5511E5C2EED812BD9D1EEE4ACD6_1372451092 = (!mCategories.contains(category));
            {
                mCategories.add(category.intern());
            } //End block
        } //End collapsed parenthetic
        addTaint(category.getTaint());
        // ---------- Original Method ----------
        //if (mCategories == null) mCategories = new ArrayList<String>();
        //if (!mCategories.contains(category)) {
            //mCategories.add(category.intern());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.324 -0400", hash_original_method = "D5AF5503C90FCC35F15F05FB572F3FAB", hash_generated_method = "F7D98BCB1EAF490EB5BB043417B41922")
    public final int countCategories() {
        {
            Object var7750EA1BB615B3E22F7111A8C74A2076_1491883962 = (mCategories.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_267318125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_267318125;
        // ---------- Original Method ----------
        //return mCategories != null ? mCategories.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.325 -0400", hash_original_method = "9221063C5ACD71C55B9DBC6F8D5B18B1", hash_generated_method = "4E43FE9350A1594F278B73F37DEDF969")
    public final String getCategory(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_2070550729 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2070550729 = mCategories.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_2070550729.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2070550729;
        // ---------- Original Method ----------
        //return mCategories.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.325 -0400", hash_original_method = "3612221F73372432993CCD6954A20D1D", hash_generated_method = "2C8CD8600796F9DCC25B0F8B8E032851")
    public final boolean hasCategory(String category) {
        boolean varC2460535E11742A1B298C090C684A3C7_1171789585 = (mCategories != null && mCategories.contains(category));
        addTaint(category.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_249316314 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_249316314;
        // ---------- Original Method ----------
        //return mCategories != null && mCategories.contains(category);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.326 -0400", hash_original_method = "A1CBC473D8947BEFDC4AD1E1869906E2", hash_generated_method = "951E0204CC455B5650DDB35BFB1349F2")
    public final Iterator<String> categoriesIterator() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_532682989 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_532682989 = mCategories != null ? mCategories.iterator() : null;
        varB4EAC82CA7396A68D541C85D26508E83_532682989.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_532682989;
        // ---------- Original Method ----------
        //return mCategories != null ? mCategories.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.328 -0400", hash_original_method = "64ACE3DFA3E244FA74278C4A66D2BC47", hash_generated_method = "372BA9AFE603B2DBBF96F1E47B9F658B")
    public final String matchCategories(Set<String> categories) {
        String varB4EAC82CA7396A68D541C85D26508E83_140706313 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_871599015 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_2013630857 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_881801771 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_140706313 = null;
        } //End block
        Iterator<String> it = categories.iterator();
        {
            varB4EAC82CA7396A68D541C85D26508E83_871599015 = it.hasNext() ? it.next() : null;
        } //End block
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_543880730 = (it.hasNext());
            {
                final String category = it.next();
                {
                    boolean var75948F6460E0068B561F42314379BAEB_990913464 = (!mCategories.contains(category));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2013630857 = category;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_881801771 = null;
        addTaint(categories.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1234287896; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1234287896 = varB4EAC82CA7396A68D541C85D26508E83_140706313;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1234287896 = varB4EAC82CA7396A68D541C85D26508E83_871599015;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1234287896 = varB4EAC82CA7396A68D541C85D26508E83_2013630857;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1234287896 = varB4EAC82CA7396A68D541C85D26508E83_881801771;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1234287896.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1234287896;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.330 -0400", hash_original_method = "4ACC3B62E54BFBE055D3653A9CF49AD3", hash_generated_method = "E954373A436596EB321902D269D383BA")
    public final int match(ContentResolver resolver, Intent intent,
            boolean resolve, String logTag) {
        String type;
        type = intent.resolveType(resolver);
        type = intent.getType();
        int varF65E2DDA6A4336395790B440F79EF0DA_601053200 = (match(intent.getAction(), type, intent.getScheme(),
                     intent.getData(), intent.getCategories(), logTag));
        addTaint(resolver.getTaint());
        addTaint(intent.getTaint());
        addTaint(resolve);
        addTaint(logTag.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1423420507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1423420507;
        // ---------- Original Method ----------
        //String type = resolve ? intent.resolveType(resolver) : intent.getType();
        //return match(intent.getAction(), type, intent.getScheme(),
                     //intent.getData(), intent.getCategories(), logTag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.332 -0400", hash_original_method = "80E2BB7D6EA3B343C7B82810FBA9B369", hash_generated_method = "EB1377E460966407D2E82B24C86173BE")
    public final int match(String action, String type, String scheme,
            Uri data, Set<String> categories, String logTag) {
        {
            boolean varAB4B3F206E562062AB2373108EDF62A0_486928560 = (action != null && !matchAction(action));
        } //End collapsed parenthetic
        int dataMatch = matchData(type, scheme, data);
        String categoryMismatch = matchCategories(categories);
        {
            {
                dataMatch -= mCategories.size() - categories.size();
            } //End block
        } //End block
        addTaint(action.getTaint());
        addTaint(type.getTaint());
        addTaint(scheme.getTaint());
        addTaint(data.getTaint());
        addTaint(categories.getTaint());
        addTaint(logTag.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798620983 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798620983;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.334 -0400", hash_original_method = "B6C33F6C9AFBFD4465A32F9300C74AFB", hash_generated_method = "0D881EC9F05FA3D2AF041F3D4B4B4E13")
    public void writeToXml(XmlSerializer serializer) throws IOException {
        int N = countActions();
        {
            int i = 0;
            {
                serializer.startTag(null, ACTION_STR);
                serializer.attribute(null, NAME_STR, mActions.get(i));
                serializer.endTag(null, ACTION_STR);
            } //End block
        } //End collapsed parenthetic
        N = countCategories();
        {
            int i = 0;
            {
                serializer.startTag(null, CAT_STR);
                serializer.attribute(null, NAME_STR, mCategories.get(i));
                serializer.endTag(null, CAT_STR);
            } //End block
        } //End collapsed parenthetic
        N = countDataTypes();
        {
            int i = 0;
            {
                serializer.startTag(null, TYPE_STR);
                String type = mDataTypes.get(i);
                {
                    boolean varF5C6D5EBEA0A2A1C0C5B585B8E141902_877444345 = (type.indexOf('/') < 0);
                    type = type + "/*";
                } //End collapsed parenthetic
                serializer.attribute(null, NAME_STR, type);
                serializer.endTag(null, TYPE_STR);
            } //End block
        } //End collapsed parenthetic
        N = countDataSchemes();
        {
            int i = 0;
            {
                serializer.startTag(null, SCHEME_STR);
                serializer.attribute(null, NAME_STR, mDataSchemes.get(i));
                serializer.endTag(null, SCHEME_STR);
            } //End block
        } //End collapsed parenthetic
        N = countDataAuthorities();
        {
            int i = 0;
            {
                serializer.startTag(null, AUTH_STR);
                AuthorityEntry ae = mDataAuthorities.get(i);
                serializer.attribute(null, HOST_STR, ae.getHost());
                {
                    boolean varD52B50DE393A2B2F765AF58DB2789B84_638135026 = (ae.getPort() >= 0);
                    {
                        serializer.attribute(null, PORT_STR, Integer.toString(ae.getPort()));
                    } //End block
                } //End collapsed parenthetic
                serializer.endTag(null, AUTH_STR);
            } //End block
        } //End collapsed parenthetic
        N = countDataPaths();
        {
            int i = 0;
            {
                serializer.startTag(null, PATH_STR);
                PatternMatcher pe = mDataPaths.get(i);
                {
                    Object var3F55985824039D507E9B86622028DD13_962901490 = (pe.getType());
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
        addTaint(serializer.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.336 -0400", hash_original_method = "276CC8B213E249CE42650F70E7C4B53B", hash_generated_method = "C8B46B4D0B856235C30DC1D9B16976F6")
    public void readFromXml(XmlPullParser parser) throws XmlPullParserException,
            IOException {
        int outerDepth = parser.getDepth();
        int type;
        {
            boolean var003C1B2273232C3B7B27A28F0A982195_1228057122 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth));
            {
                String tagName = parser.getName();
                {
                    boolean varFCDCA384B5AE04B7C812E6C97E646171_436599506 = (tagName.equals(ACTION_STR));
                    {
                        String name = parser.getAttributeValue(null, NAME_STR);
                        {
                            addAction(name);
                        } //End block
                    } //End block
                    {
                        boolean varA79B623DA4F2C04CCACF87A377409319_386390903 = (tagName.equals(CAT_STR));
                        {
                            String name = parser.getAttributeValue(null, NAME_STR);
                            {
                                addCategory(name);
                            } //End block
                        } //End block
                        {
                            boolean var977A45C559BECBE43F4912D2273DF0C8_1779265279 = (tagName.equals(TYPE_STR));
                            {
                                String name = parser.getAttributeValue(null, NAME_STR);
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
                                boolean var6DC38F2E64C783805E18B68A201E5478_1824888889 = (tagName.equals(SCHEME_STR));
                                {
                                    String name = parser.getAttributeValue(null, NAME_STR);
                                    {
                                        addDataScheme(name);
                                    } //End block
                                } //End block
                                {
                                    boolean var8853BBB6CFA09C0887644DF8808FF11A_2029953542 = (tagName.equals(AUTH_STR));
                                    {
                                        String host = parser.getAttributeValue(null, HOST_STR);
                                        String port = parser.getAttributeValue(null, PORT_STR);
                                        {
                                            addDataAuthority(host, port);
                                        } //End block
                                    } //End block
                                    {
                                        boolean var22FFAE6F647F1E2186452AB348DF879B_892594119 = (tagName.equals(PATH_STR));
                                        {
                                            String path = parser.getAttributeValue(null, LITERAL_STR);
                                            {
                                                addDataPath(path, PatternMatcher.PATTERN_LITERAL);
                                            } //End block
                                            {
                                                boolean varFD9E988BC7BA6C67FA0846D5B6BA2EAE_1129729778 = ((path=parser.getAttributeValue(null, PREFIX_STR)) != null);
                                                {
                                                    addDataPath(path, PatternMatcher.PATTERN_PREFIX);
                                                } //End block
                                                {
                                                    boolean var65A46A0D515CAD733F17FA4060913973_1501712383 = ((path=parser.getAttributeValue(null, SGLOB_STR)) != null);
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
        addTaint(parser.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.338 -0400", hash_original_method = "75FFB292CCD000E47FA0C7D0BE596A36", hash_generated_method = "11ADFB966BD1CDC06F581D2E66318E30")
    public void dump(Printer du, String prefix) {
        StringBuilder sb = new StringBuilder(256);
        {
            boolean var71B9BA72BB6B517DA479CF3A88B95269_435047034 = (mActions.size() > 0);
            {
                Iterator<String> it = mActions.iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_189036567 = (it.hasNext());
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
            Iterator<String> it = mCategories.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1573401629 = (it.hasNext());
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
            Iterator<String> it = mDataSchemes.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_435448685 = (it.hasNext());
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
            Iterator<AuthorityEntry> it = mDataAuthorities.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_794359230 = (it.hasNext());
                {
                    AuthorityEntry ae = it.next();
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
            Iterator<PatternMatcher> it = mDataPaths.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1055881404 = (it.hasNext());
                {
                    PatternMatcher pe = it.next();
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
            Iterator<String> it = mDataTypes.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1279418548 = (it.hasNext());
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
        addTaint(du.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.339 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F9AEE6764000C1A59FDAB86C73F205D4")
    public final int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618553820 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618553820;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.340 -0400", hash_original_method = "2C734948869786E017228B90D172BE24", hash_generated_method = "724CA31532EABBFFA3A831CBD3A42096")
    public final void writeToParcel(Parcel dest, int flags) {
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
            final int N = mDataAuthorities.size();
            dest.writeInt(N);
            {
                int i = 0;
                {
                    mDataAuthorities.get(i).writeToParcel(dest);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            dest.writeInt(0);
        } //End block
        {
            final int N = mDataPaths.size();
            dest.writeInt(N);
            {
                int i = 0;
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
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.341 -0400", hash_original_method = "FBEEEBAC37A62143C058604C825166BE", hash_generated_method = "FAA86961381098BE1F24D9CEF388576D")
    public boolean debugCheck() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_850689532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_850689532;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.342 -0400", hash_original_method = "742383A5720F36FAAE26E247984D38D1", hash_generated_method = "2176738AED67AAECFFE1FF3C90EE560A")
    private final boolean findMimeType(String type) {
        final ArrayList<String> t = mDataTypes;
        {
            boolean var94BA75702969E64AAFAD0932F9F19FE6_2091735960 = (t.contains(type));
        } //End collapsed parenthetic
        final int typeLength = type.length();
        {
            boolean varC0B1C251D972DB5100663171FE0ED803_469093208 = (typeLength == 3 && type.equals("*/*"));
            {
                boolean var207FD69B8C4084DC550BC184B4637898_1980885787 = (!t.isEmpty());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDD39D56D1526DF18BC77C0B3DD038B55_350854249 = (mHasPartialTypes && t.contains("*"));
        } //End collapsed parenthetic
        final int slashpos = type.indexOf('/');
        {
            {
                boolean var6B9A6E4432B816B7E7FEA6713DF1EE03_1393128996 = (mHasPartialTypes && t.contains(type.substring(0, slashpos)));
            } //End collapsed parenthetic
            {
                boolean varAF563929C59A468F116FAF629096DE41_984305971 = (typeLength == slashpos+2 && type.charAt(slashpos+1) == '*');
                {
                    final int numTypes = t.size();
                    {
                        int i = 0;
                        {
                            final String v = t.get(i);
                            {
                                boolean var11CCA35FDF5142E21DA9AFB5AAC19B77_1282629581 = (type.regionMatches(0, v, 0, slashpos+1));
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1396723905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1396723905;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class MalformedMimeTypeException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.343 -0400", hash_original_method = "8500983E91FE33F50F26D266A654E6C8", hash_generated_method = "76D07A54CDCC210EFF1FE4C037CB3505")
        public  MalformedMimeTypeException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.343 -0400", hash_original_method = "E06B6BA43D42AE50E4C9A14EEBF56FAC", hash_generated_method = "E089FA8DF2043AF9848D19DB7BA10CF1")
        public  MalformedMimeTypeException(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public final static class AuthorityEntry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.343 -0400", hash_original_field = "F8F65BB641A3EAB4D5CD871CD38B3B93", hash_generated_field = "0C08F8EAA89B66A92AA182AAF7101D01")

        private String mOrigHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.344 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

        private String mHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.344 -0400", hash_original_field = "F245AD4CEDF4FE31289C2C304D1D5975", hash_generated_field = "4775283DB55281CD651400D583AD7181")

        private boolean mWild;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.344 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

        private int mPort;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.344 -0400", hash_original_method = "FAC1F38311ACA5CF1D84B9DFACCAD236", hash_generated_method = "7BCC3206A85976AB9748D889DCD74284")
        public  AuthorityEntry(String host, String port) {
            mOrigHost = host;
            mWild = host.length() > 0 && host.charAt(0) == '*';
            mHost = mWild ? host.substring(1).intern() : host;
            mPort = port != null ? Integer.parseInt(port) : -1;
            // ---------- Original Method ----------
            //mOrigHost = host;
            //mWild = host.length() > 0 && host.charAt(0) == '*';
            //mHost = mWild ? host.substring(1).intern() : host;
            //mPort = port != null ? Integer.parseInt(port) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.345 -0400", hash_original_method = "9AA41EA6C96E16AD56B52F388CEAC244", hash_generated_method = "C25EE71C4F905DDEC436619875DD7883")
          AuthorityEntry(Parcel src) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.346 -0400", hash_original_method = "3FD27104A5CDDCA498D8F62DC306DFFB", hash_generated_method = "4718A898E94235CE6895C6ECD81A811D")
         void writeToParcel(Parcel dest) {
            dest.writeString(mOrigHost);
            dest.writeString(mHost);
            dest.writeInt(mWild ? 1 : 0);
            dest.writeInt(mPort);
            addTaint(dest.getTaint());
            // ---------- Original Method ----------
            //dest.writeString(mOrigHost);
            //dest.writeString(mHost);
            //dest.writeInt(mWild ? 1 : 0);
            //dest.writeInt(mPort);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.346 -0400", hash_original_method = "56B964ED44110D4A8630C57ED8411A1C", hash_generated_method = "144BFF9B3BF5E180BDCFE630D588AE8F")
        public String getHost() {
            String varB4EAC82CA7396A68D541C85D26508E83_733921036 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_733921036 = mOrigHost;
            varB4EAC82CA7396A68D541C85D26508E83_733921036.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_733921036;
            // ---------- Original Method ----------
            //return mOrigHost;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.347 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "F8B05C316200FE88D6F9766D5983F0F1")
        public int getPort() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_247537424 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_247537424;
            // ---------- Original Method ----------
            //return mPort;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.348 -0400", hash_original_method = "FC31CC7FA89B702CE4ED1283F0D70C24", hash_generated_method = "43F575151E87D8527AB5BCA62645D1AB")
        public int match(Uri data) {
            String host = data.getHost();
            {
                {
                    boolean var1B71F291A87433E0716DC39D697C7F3A_864432618 = (host.length() < mHost.length());
                } //End collapsed parenthetic
                host = host.substring(host.length()-mHost.length());
            } //End block
            {
                boolean var7D1AEF3A34E8E1E90AF70D1486121E66_1449887036 = (host.compareToIgnoreCase(mHost) != 0);
            } //End collapsed parenthetic
            {
                {
                    boolean var9F3060E6F5D255CBEEDF2919EC07ED98_1447535666 = (mPort != data.getPort());
                } //End collapsed parenthetic
            } //End block
            addTaint(data.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_483908377 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_483908377;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.349 -0400", hash_original_field = "1B14B190F8083606EAE9866EE2D8420A", hash_generated_field = "C4BAA85D0E2D827D81D6FD077E15ADAB")

    private static final String SGLOB_STR = "sglob";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.349 -0400", hash_original_field = "86F097BF95F1AA716CCC9A63D2EB81AA", hash_generated_field = "3FD2C7D31E487D70A6AA6204637B2899")

    private static final String PREFIX_STR = "prefix";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.349 -0400", hash_original_field = "6A393441CAE2E6BA8661A2A790B9BD3A", hash_generated_field = "6210DECFA06880B6974267C6646EE816")

    private static final String LITERAL_STR = "literal";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.349 -0400", hash_original_field = "04A3CE28FA3157C3CCB77E0071D396CD", hash_generated_field = "AE2B2A8BA02A502564CB5583944A3146")

    private static final String PATH_STR = "path";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.349 -0400", hash_original_field = "150FDD6F68BE978A88F86AD2873EDAFE", hash_generated_field = "013F1A4753121A357F8D4078614DB5E9")

    private static final String PORT_STR = "port";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.349 -0400", hash_original_field = "019957BFE878AB3E79F639CC8FDC25D4", hash_generated_field = "D18646C1A58B5E7B6FA605CC5A4DC7F3")

    private static final String HOST_STR = "host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.349 -0400", hash_original_field = "E62D8B7C04FCF1CD40D69F39C4B955D6", hash_generated_field = "1F480DB7C369FC6CBAE0E8C3FA3BF415")

    private static final String AUTH_STR = "auth";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.349 -0400", hash_original_field = "30DF383648C6FAFE73F202B429E1FE37", hash_generated_field = "EA900D1EEAE42F3BD549A09336FAB017")

    private static final String SCHEME_STR = "scheme";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.349 -0400", hash_original_field = "1C05FFE55AF62B33F675B76A1B6CCF6A", hash_generated_field = "4B774CE7E444A55B1B5AD2184D9A15CA")

    private static final String TYPE_STR = "type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.349 -0400", hash_original_field = "27410BA0FAE1A9A30C0179C2C752741E", hash_generated_field = "C2ADBD80B18293A0640432B18AE1AF15")

    private static final String CAT_STR = "cat";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.350 -0400", hash_original_field = "A661B8112FDD112F1875BC35CEA675F4", hash_generated_field = "21D10217770299F078A52DD982CBB332")

    private static final String NAME_STR = "name";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.350 -0400", hash_original_field = "F5C31232933C5E2ABE7280026D10B245", hash_generated_field = "35EF60995ACCB10C97AD2C3A5730D090")

    private static final String ACTION_STR = "action";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.350 -0400", hash_original_field = "74637B437C78D88E3C7DCFACCF6E4980", hash_generated_field = "6027B3B34EF275EF0258CDA7F6C44B06")

    public static final int SYSTEM_HIGH_PRIORITY = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.350 -0400", hash_original_field = "353077210979C8C79343072728BF2D9A", hash_generated_field = "0B01181E7D37C91380237FEC68D6D2D3")

    public static final int SYSTEM_LOW_PRIORITY = -1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.350 -0400", hash_original_field = "058341A722955315E0E33E69124FEE19", hash_generated_field = "29606CB5EA802A3FC60CBE3892A8C231")

    public static final int MATCH_CATEGORY_MASK = 0xfff0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.350 -0400", hash_original_field = "CB979228755FD40F19E419AEA8107256", hash_generated_field = "B34195AB6941F69DE5EAC54045013E42")

    public static final int MATCH_ADJUSTMENT_MASK = 0x000ffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.350 -0400", hash_original_field = "A3255D675E31155A3001B8797C7B966D", hash_generated_field = "C9832C97F6DA3DADA2A2565BDBACE888")

    public static final int MATCH_ADJUSTMENT_NORMAL = 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.350 -0400", hash_original_field = "178B46F293C192C312ED4366D085CEC0", hash_generated_field = "A1B64111ED1BB3921E4D97B9744154C1")

    public static final int MATCH_CATEGORY_EMPTY = 0x0100000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.350 -0400", hash_original_field = "4BB39E3813E80D9621D0D1CC0FB99F84", hash_generated_field = "C12E4AC6561BC99691B6248231FD861A")

    public static final int MATCH_CATEGORY_SCHEME = 0x0200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.350 -0400", hash_original_field = "1692855581B57010A0ECDB3F5977972B", hash_generated_field = "FE262DE457FD58C71A1505F0420E15FE")

    public static final int MATCH_CATEGORY_HOST = 0x0300000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.350 -0400", hash_original_field = "1200D586A3667F023B4654A7B78253FE", hash_generated_field = "D10A1DB2D1A22224D638E95D16CE16B9")

    public static final int MATCH_CATEGORY_PORT = 0x0400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.351 -0400", hash_original_field = "C766E935F381FC06B2257F916BA02A21", hash_generated_field = "733A5B911AC6A408B5E5529505EC7DCE")

    public static final int MATCH_CATEGORY_PATH = 0x0500000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.351 -0400", hash_original_field = "19CA0A00F075EC4C3571BC37A8E25A1F", hash_generated_field = "EF521D11C4B126106700F8F59796E3EC")

    public static final int MATCH_CATEGORY_TYPE = 0x0600000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.351 -0400", hash_original_field = "FFC757B5E0F96115551506FAB5C3EE28", hash_generated_field = "77C0C8B7C43E88DB2627254044127D30")

    public static final int NO_MATCH_TYPE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.351 -0400", hash_original_field = "9E2C7CCA0536236D90B2117FD257B56D", hash_generated_field = "994792ED93AAD5E31FA521805925B110")

    public static final int NO_MATCH_DATA = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.351 -0400", hash_original_field = "977EE4FA01887F87DB89D32E63D447C0", hash_generated_field = "E5BEBE595B019031029BE6CBC65E803A")

    public static final int NO_MATCH_ACTION = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.351 -0400", hash_original_field = "97915C591435AF39A8AEC43737A59FC9", hash_generated_field = "5B8788CD30AACDBD788AC513C1CD39AE")

    public static final int NO_MATCH_CATEGORY = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.351 -0400", hash_original_field = "DCD9426D45070A28AEA2BF645CBE4999", hash_generated_field = "665198F8F263BBC69C46C9D3C09D5B07")

    public static final Parcelable.Creator<IntentFilter> CREATOR
            = new Parcelable.Creator<IntentFilter>() {
        public IntentFilter createFromParcel(Parcel source) {
            return new IntentFilter(source);
        }

        public IntentFilter[] newArray(int size) {
            return new IntentFilter[size];
        }
    };
    // orphaned legacy method
    public IntentFilter createFromParcel(Parcel source) {
            return new IntentFilter(source);
        }
    
    // orphaned legacy method
    public IntentFilter[] newArray(int size) {
            return new IntentFilter[size];
        }
    
}

