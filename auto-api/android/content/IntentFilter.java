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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.704 -0400", hash_original_field = "22FC7A378B4F7C5F90F70A47BE1E4FCD", hash_generated_field = "032B46B6D9E42E1E80E269F8E583852A")

    private int mPriority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.719 -0400", hash_original_field = "C268D719F2F67098628D1A8EEBB72B48", hash_generated_field = "B7B787904E751334D4C6C5E9190CBECB")

    private ArrayList<String> mActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.719 -0400", hash_original_field = "E5C591146E984CF70A027B756462CD3D", hash_generated_field = "DF1B13D35CEEB5232DEB8422E072E169")

    private ArrayList<String> mCategories = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.720 -0400", hash_original_field = "ACE6ED917BE479CC0451087F07844425", hash_generated_field = "D6C69DEDF341F4A4196AEA26E81D24A7")

    private ArrayList<String> mDataSchemes = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.720 -0400", hash_original_field = "B7BD82E78C46D9D79C64D1CD52A40D35", hash_generated_field = "C318D366A8228836F69A6B4BDDBFB506")

    private ArrayList<AuthorityEntry> mDataAuthorities = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.720 -0400", hash_original_field = "B61E65339F4663631A2F55699D0303D1", hash_generated_field = "2207044C23DD28F016FBFC7451C9D66A")

    private ArrayList<PatternMatcher> mDataPaths = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.720 -0400", hash_original_field = "606D718D7940DF43E42D0547DAABEADA", hash_generated_field = "06256A3E596C9EB087048F541BEAB278")

    private ArrayList<String> mDataTypes = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.721 -0400", hash_original_field = "9D8D79625D9E596046C5C52803A8BF48", hash_generated_field = "A768E3466CCFB1BF3BC36D8E0C71D999")

    private boolean mHasPartialTypes = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.721 -0400", hash_original_method = "E570235BD10D63A46D952627D4823B55", hash_generated_method = "7B0E4140638D2A4CB4A4CCA023BAD3B0")
    public  IntentFilter() {
        mPriority = 0;
        mActions = new ArrayList<String>();
        // ---------- Original Method ----------
        //mPriority = 0;
        //mActions = new ArrayList<String>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.728 -0400", hash_original_method = "6BE32B941606799E1C4582399143D6DE", hash_generated_method = "B976B6B42BC2F5D5D03C7855FFD6D5F1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.729 -0400", hash_original_method = "6F03ACB8C3DEEE507BC72687512BE15B", hash_generated_method = "C3DC77DE4FFE9C6A486D4413368FFCFC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.814 -0400", hash_original_method = "1836401D6B82BE6CCBD088E7B5026D41", hash_generated_method = "712920B6E34B5EF9B0CD0503E5C6E0DF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.821 -0400", hash_original_method = "0A18E8175DAFA9E0ECB5A7A15F664AD8", hash_generated_method = "1626985A06BEE6ED4D516F5BCFC27F5C")
    private  IntentFilter(Parcel source) {
        mActions = new ArrayList<String>();
        source.readStringList(mActions);
        {
            boolean varFD16828A378FD83700BE97539951F787_1557333994 = (source.readInt() != 0);
            {
                mCategories = new ArrayList<String>();
                source.readStringList(mCategories);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFD16828A378FD83700BE97539951F787_1364698229 = (source.readInt() != 0);
            {
                mDataSchemes = new ArrayList<String>();
                source.readStringList(mDataSchemes);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFD16828A378FD83700BE97539951F787_969820953 = (source.readInt() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.827 -0400", hash_original_method = "1AF904ED06333BC0001A5A8D0FC8E3CC", hash_generated_method = "839A047CDB79A7FD6A97DD19F37CB628")
    public final void setPriority(int priority) {
        mPriority = priority;
        // ---------- Original Method ----------
        //mPriority = priority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.827 -0400", hash_original_method = "4CF75B39A2F3F4074ED78E7B55CDB45C", hash_generated_method = "77A86997C536A2F0FDF8E0A18CDD576F")
    public final int getPriority() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1874001394 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1874001394;
        // ---------- Original Method ----------
        //return mPriority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.853 -0400", hash_original_method = "FFF5B803FCB58F324812D605B6C9CE62", hash_generated_method = "DE4D4A320193C75FEA1D2C43CAC11D29")
    public final void addAction(String action) {
        {
            boolean varDA3436D9D4672C232973BD25181DC765_566683969 = (!mActions.contains(action));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.854 -0400", hash_original_method = "77921182B442B1D522A9772E07DC4CA3", hash_generated_method = "7E4E0230B24F3F8AD3B4FDBBC540E54A")
    public final int countActions() {
        int var19FD9BE92ED9235C35782B147251E19B_344207850 = (mActions.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459785254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459785254;
        // ---------- Original Method ----------
        //return mActions.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.855 -0400", hash_original_method = "50CEFE8EA652B37B9EBFC8EA367BBC71", hash_generated_method = "6A35F499517DA3B5B779C78F699D7A89")
    public final String getAction(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1900971850 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1900971850 = mActions.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1900971850.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1900971850;
        // ---------- Original Method ----------
        //return mActions.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.856 -0400", hash_original_method = "9D48CC1056269867443B9FC005D01764", hash_generated_method = "B55E3EDFBA82FB300DDE18E01E099420")
    public final boolean hasAction(String action) {
        boolean varDF0CCFFC7BDE2E2A2BCDBD16345F594C_159477618 = (action != null && mActions.contains(action));
        addTaint(action.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_576368445 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_576368445;
        // ---------- Original Method ----------
        //return action != null && mActions.contains(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.857 -0400", hash_original_method = "984560EB63068E6413989919BB90D187", hash_generated_method = "5A38C6BC6DBBB138726246F5DCF1A825")
    public final boolean matchAction(String action) {
        boolean var9B5661F26B968C4AAD3608BADBD8A775_1265711150 = (hasAction(action));
        addTaint(action.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_98932921 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_98932921;
        // ---------- Original Method ----------
        //return hasAction(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.882 -0400", hash_original_method = "91B40E19A4EE68D85BFA3F1F256EBA72", hash_generated_method = "54A175ABBDF0612AD1E6EC421497ED95")
    public final Iterator<String> actionsIterator() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1987557153 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1987557153 = mActions != null ? mActions.iterator() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1987557153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1987557153;
        // ---------- Original Method ----------
        //return mActions != null ? mActions.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.884 -0400", hash_original_method = "B72DE1FACB480BB8E2AD802A23898A2F", hash_generated_method = "C93D5C61958004A703955CD76E62BD77")
    public final void addDataType(String type) throws MalformedMimeTypeException {
        int slashpos;
        slashpos = type.indexOf('/');
        int typelen;
        typelen = type.length();
        {
            mDataTypes = new ArrayList<String>();
            {
                boolean var38C7C9D7B7DBF9B40D4D0FBD0F6AD99E_551594703 = (typelen == slashpos+2 && type.charAt(slashpos+1) == '*');
                {
                    String str;
                    str = type.substring(0, slashpos);
                    {
                        boolean varD49CE2200355496BB92B3C202D8BDEE3_498602366 = (!mDataTypes.contains(str));
                        {
                            mDataTypes.add(str.intern());
                        } //End block
                    } //End collapsed parenthetic
                    mHasPartialTypes = true;
                } //End block
                {
                    {
                        boolean var14F656F6D90E73ACD7CC37F6B5F05D46_791687258 = (!mDataTypes.contains(type));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.894 -0400", hash_original_method = "9AF334B8B7AF494EC1E65710EFD1F300", hash_generated_method = "64FBCF74DD77E808B6567B3772B29CF5")
    public final boolean hasDataType(String type) {
        boolean var0425380B65E8B08CE43D132BFE5C72CF_689535608 = (mDataTypes != null && findMimeType(type));
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1022480944 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1022480944;
        // ---------- Original Method ----------
        //return mDataTypes != null && findMimeType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.899 -0400", hash_original_method = "9C43102AEBDE030DD3A73C704DCFC758", hash_generated_method = "5FA3BA6795ED467524552FA0580DACD7")
    public final int countDataTypes() {
        {
            Object var5CD61D88055F6C456A17888CA437F389_682739330 = (mDataTypes.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834848064 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834848064;
        // ---------- Original Method ----------
        //return mDataTypes != null ? mDataTypes.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.919 -0400", hash_original_method = "1020E9310C4CEB3D9A899FFC3406F498", hash_generated_method = "4CCBAFFF99DE1C299D894F9B67443727")
    public final String getDataType(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1145366927 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1145366927 = mDataTypes.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1145366927.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1145366927;
        // ---------- Original Method ----------
        //return mDataTypes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.922 -0400", hash_original_method = "E14DF72F5869874CC38AD67447F5264E", hash_generated_method = "B236ED9C83258D622B44F580A8631D12")
    public final Iterator<String> typesIterator() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1986218697 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1986218697 = mDataTypes != null ? mDataTypes.iterator() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1986218697.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1986218697;
        // ---------- Original Method ----------
        //return mDataTypes != null ? mDataTypes.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.936 -0400", hash_original_method = "5610D5819C8C8974F702B3F76798B195", hash_generated_method = "637CC3EDE665E1C9180EAF9FF102C858")
    public final void addDataScheme(String scheme) {
        mDataSchemes = new ArrayList<String>();
        {
            boolean varB4AC16761D5AE1DBD4D7BE4F78F9BCD5_1869569949 = (!mDataSchemes.contains(scheme));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.938 -0400", hash_original_method = "23DC2F7DC5C53386402D5B95D046A59E", hash_generated_method = "605AA43E200F453B30A7F8F60C820E37")
    public final int countDataSchemes() {
        {
            Object var5DA05131A061F74B7E86F57B0DA2F51D_282662698 = (mDataSchemes.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1066611274 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1066611274;
        // ---------- Original Method ----------
        //return mDataSchemes != null ? mDataSchemes.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.961 -0400", hash_original_method = "F55C42908F22C2BF6411521C019E1E71", hash_generated_method = "B0CEA085E386C95A5A0C20327E8CAB1B")
    public final String getDataScheme(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_2057156545 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2057156545 = mDataSchemes.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_2057156545.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2057156545;
        // ---------- Original Method ----------
        //return mDataSchemes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.964 -0400", hash_original_method = "6D8F15A80747973FB96EA7F310404F85", hash_generated_method = "0B140B1541E2B566CFE8AA45492ED74B")
    public final boolean hasDataScheme(String scheme) {
        boolean var512C6A99EF7116D0DF5B8D796BB2F028_1386446380 = (mDataSchemes != null && mDataSchemes.contains(scheme));
        addTaint(scheme.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_955520111 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_955520111;
        // ---------- Original Method ----------
        //return mDataSchemes != null && mDataSchemes.contains(scheme);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.969 -0400", hash_original_method = "B57BF7E15AE8E364684A85B4AA7D0368", hash_generated_method = "D513F13E2445A377FE05C44BC12406A6")
    public final Iterator<String> schemesIterator() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_945483216 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_945483216 = mDataSchemes != null ? mDataSchemes.iterator() : null;
        varB4EAC82CA7396A68D541C85D26508E83_945483216.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_945483216;
        // ---------- Original Method ----------
        //return mDataSchemes != null ? mDataSchemes.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.984 -0400", hash_original_method = "617831DFB49DD0B093CE5F322F324A18", hash_generated_method = "89AF2CB20AEBF24655E2F775BF782B64")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.000 -0400", hash_original_method = "B59B7F6BD479782A00EECCEFFFB6C78B", hash_generated_method = "BA4C7A57D06C98ED48598D2BB9B2F955")
    public final int countDataAuthorities() {
        {
            Object var7F3DBF7B704BD2D53B067BCF2DC53B65_1048061798 = (mDataAuthorities.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88908943 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88908943;
        // ---------- Original Method ----------
        //return mDataAuthorities != null ? mDataAuthorities.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.010 -0400", hash_original_method = "5C821D7ECF8B0A79E64F1031BF4C37BB", hash_generated_method = "DE0FA4341EB073623E0A11CB15AEF32B")
    public final AuthorityEntry getDataAuthority(int index) {
        AuthorityEntry varB4EAC82CA7396A68D541C85D26508E83_1783298104 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1783298104 = mDataAuthorities.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1783298104.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1783298104;
        // ---------- Original Method ----------
        //return mDataAuthorities.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.011 -0400", hash_original_method = "04C5A3803469FEAEE8E315143FC0F6BE", hash_generated_method = "A45DB676E41DDBFFB6E366947718BF56")
    public final boolean hasDataAuthority(Uri data) {
        boolean var1270E27AB98815A5880DC4887D568CF5_1245843064 = (matchDataAuthority(data) >= 0);
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1315493734 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1315493734;
        // ---------- Original Method ----------
        //return matchDataAuthority(data) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.013 -0400", hash_original_method = "104889BB491104C94E7C1142A3F4BAAD", hash_generated_method = "B158DA7327B618CAF427C6C005380B8A")
    public final Iterator<AuthorityEntry> authoritiesIterator() {
        Iterator<AuthorityEntry> varB4EAC82CA7396A68D541C85D26508E83_668213562 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_668213562 = mDataAuthorities != null ? mDataAuthorities.iterator() : null;
        varB4EAC82CA7396A68D541C85D26508E83_668213562.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_668213562;
        // ---------- Original Method ----------
        //return mDataAuthorities != null ? mDataAuthorities.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.030 -0400", hash_original_method = "F30E00ACF0BA9FCEBC6CDD2BDA55B075", hash_generated_method = "2EF2319E1406271F8319FC082BEF491D")
    public final void addDataPath(String path, int type) {
        mDataPaths = new ArrayList<PatternMatcher>();
        mDataPaths.add(new PatternMatcher(path.intern(), type));
        addTaint(path.getTaint());
        addTaint(type);
        // ---------- Original Method ----------
        //if (mDataPaths == null) mDataPaths = new ArrayList<PatternMatcher>();
        //mDataPaths.add(new PatternMatcher(path.intern(), type));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.032 -0400", hash_original_method = "60FAB9592DF6A1D398A3997EC9565FA6", hash_generated_method = "1990FDE36D1E0C8F161C4256C6007ABE")
    public final int countDataPaths() {
        {
            Object var8D28E0B37D5A9D79155F890739E07533_753056270 = (mDataPaths.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645719275 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645719275;
        // ---------- Original Method ----------
        //return mDataPaths != null ? mDataPaths.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.047 -0400", hash_original_method = "C7BC21A1B57BD5F3F08A1F8B8EBDB051", hash_generated_method = "D75F0680E7784D9858434658E61A4246")
    public final PatternMatcher getDataPath(int index) {
        PatternMatcher varB4EAC82CA7396A68D541C85D26508E83_1425084681 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1425084681 = mDataPaths.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1425084681.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1425084681;
        // ---------- Original Method ----------
        //return mDataPaths.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.048 -0400", hash_original_method = "8A8BB0EA1E4D89E1A8E627888FCA29D4", hash_generated_method = "7872BBBC2ADA842BB105911B40257CC4")
    public final boolean hasDataPath(String data) {
        int numDataPaths;
        numDataPaths = mDataPaths.size();
        {
            int i;
            i = 0;
            {
                PatternMatcher pe;
                pe = mDataPaths.get(i);
                {
                    boolean varFE731D0FCEDE70D75173DC4C2EBABD75_1710812762 = (pe.match(data));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2139102892 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2139102892;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.062 -0400", hash_original_method = "DFBFAEBB83F5AF41A1E2404555B650EF", hash_generated_method = "DEE40F3ED045808819D5BB23FE1947E2")
    public final Iterator<PatternMatcher> pathsIterator() {
        Iterator<PatternMatcher> varB4EAC82CA7396A68D541C85D26508E83_370857567 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_370857567 = mDataPaths != null ? mDataPaths.iterator() : null;
        varB4EAC82CA7396A68D541C85D26508E83_370857567.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_370857567;
        // ---------- Original Method ----------
        //return mDataPaths != null ? mDataPaths.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.064 -0400", hash_original_method = "BBE034684833DCE31C3A8387BD50FAB0", hash_generated_method = "BAD41D94564BA98E1355FA754307F463")
    public final int matchDataAuthority(Uri data) {
        int numDataAuthorities;
        numDataAuthorities = mDataAuthorities.size();
        {
            int i;
            i = 0;
            {
                AuthorityEntry ae;
                ae = mDataAuthorities.get(i);
                int match;
                match = ae.match(data);
            } //End block
        } //End collapsed parenthetic
        addTaint(data.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585964276 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585964276;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.072 -0400", hash_original_method = "6458C2A82CD5BFA5489DF067AE915D84", hash_generated_method = "B152811A1E90A54F0224F76DB91FFAD6")
    public final int matchData(String type, String scheme, Uri data) {
        ArrayList<String> types;
        types = mDataTypes;
        ArrayList<String> schemes;
        schemes = mDataSchemes;
        ArrayList<AuthorityEntry> authorities;
        authorities = mDataAuthorities;
        ArrayList<PatternMatcher> paths;
        paths = mDataPaths;
        int match;
        match = MATCH_CATEGORY_EMPTY;
        {
            {
                boolean var5E7A05A835B5CF4FFB8629732729276E_1716136743 = (schemes.contains(scheme != null ? scheme : "")); //DSFIXME:  CODE0008: Nested ternary operator in expression
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
                        boolean varEAAE2E15E6A7D5BAE2309C583FB4447C_2050910819 = (hasDataPath(data.getPath()));
                        {
                            match = MATCH_CATEGORY_PATH;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End block
        {
            {
                boolean var406CA28FF8859711A6231B15267E09A4_1751081096 = (scheme != null && !"".equals(scheme)
                    && !"content".equals(scheme)
                    && !"file".equals(scheme));
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var98FC73A23AE0FAF08A0BE1B405D035C8_1342231434 = (findMimeType(type));
                {
                    match = MATCH_CATEGORY_TYPE;
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(type.getTaint());
        addTaint(scheme.getTaint());
        addTaint(data.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674066881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674066881;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.092 -0400", hash_original_method = "740A58E186A747CF3BBDAB4A3568B004", hash_generated_method = "E5B9F03E8B94E01B1066E32C38FE8388")
    public final void addCategory(String category) {
        mCategories = new ArrayList<String>();
        {
            boolean var86C5C5511E5C2EED812BD9D1EEE4ACD6_1642576491 = (!mCategories.contains(category));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.094 -0400", hash_original_method = "D5AF5503C90FCC35F15F05FB572F3FAB", hash_generated_method = "E91B56CF9F7B1DC05ECF926892012E77")
    public final int countCategories() {
        {
            Object var7750EA1BB615B3E22F7111A8C74A2076_739424618 = (mCategories.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665101782 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665101782;
        // ---------- Original Method ----------
        //return mCategories != null ? mCategories.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.095 -0400", hash_original_method = "9221063C5ACD71C55B9DBC6F8D5B18B1", hash_generated_method = "0AB5170BCFC549D07ABCB6D9B4CC8B87")
    public final String getCategory(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1184980024 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1184980024 = mCategories.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1184980024.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1184980024;
        // ---------- Original Method ----------
        //return mCategories.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.103 -0400", hash_original_method = "3612221F73372432993CCD6954A20D1D", hash_generated_method = "6E6A31398DEDAB6E89A5F6470157476E")
    public final boolean hasCategory(String category) {
        boolean varC2460535E11742A1B298C090C684A3C7_489011639 = (mCategories != null && mCategories.contains(category));
        addTaint(category.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1732681570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1732681570;
        // ---------- Original Method ----------
        //return mCategories != null && mCategories.contains(category);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.114 -0400", hash_original_method = "A1CBC473D8947BEFDC4AD1E1869906E2", hash_generated_method = "169071EC1481CB0A3EC7DC6EEB7421E8")
    public final Iterator<String> categoriesIterator() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_167904962 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_167904962 = mCategories != null ? mCategories.iterator() : null;
        varB4EAC82CA7396A68D541C85D26508E83_167904962.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_167904962;
        // ---------- Original Method ----------
        //return mCategories != null ? mCategories.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.139 -0400", hash_original_method = "64ACE3DFA3E244FA74278C4A66D2BC47", hash_generated_method = "E2A2DE365B33CC3043AD88068C8031B5")
    public final String matchCategories(Set<String> categories) {
        String varB4EAC82CA7396A68D541C85D26508E83_521699771 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1041448822 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_575747934 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_659801704 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_521699771 = null;
        } //End block
        Iterator<String> it;
        it = categories.iterator();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1041448822 = it.hasNext() ? it.next() : null;
        } //End block
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2019088997 = (it.hasNext());
            {
                String category;
                category = it.next();
                {
                    boolean var75948F6460E0068B561F42314379BAEB_1603306281 = (!mCategories.contains(category));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_575747934 = category;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_659801704 = null;
        addTaint(categories.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1548328848; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1548328848 = varB4EAC82CA7396A68D541C85D26508E83_521699771;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1548328848 = varB4EAC82CA7396A68D541C85D26508E83_1041448822;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1548328848 = varB4EAC82CA7396A68D541C85D26508E83_575747934;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1548328848 = varB4EAC82CA7396A68D541C85D26508E83_659801704;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1548328848.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1548328848;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.140 -0400", hash_original_method = "4ACC3B62E54BFBE055D3653A9CF49AD3", hash_generated_method = "E0CB6356810AEB7203F6AB241600552B")
    public final int match(ContentResolver resolver, Intent intent,
            boolean resolve, String logTag) {
        String type;
        type = intent.resolveType(resolver);
        type = intent.getType();
        int varF65E2DDA6A4336395790B440F79EF0DA_950944307 = (match(intent.getAction(), type, intent.getScheme(),
                     intent.getData(), intent.getCategories(), logTag));
        addTaint(resolver.getTaint());
        addTaint(intent.getTaint());
        addTaint(resolve);
        addTaint(logTag.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554169981 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554169981;
        // ---------- Original Method ----------
        //String type = resolve ? intent.resolveType(resolver) : intent.getType();
        //return match(intent.getAction(), type, intent.getScheme(),
                     //intent.getData(), intent.getCategories(), logTag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.144 -0400", hash_original_method = "80E2BB7D6EA3B343C7B82810FBA9B369", hash_generated_method = "D43BEDF4A6355B9662EDE7A93D70BB47")
    public final int match(String action, String type, String scheme,
            Uri data, Set<String> categories, String logTag) {
        {
            boolean varAB4B3F206E562062AB2373108EDF62A0_855970530 = (action != null && !matchAction(action));
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
        addTaint(action.getTaint());
        addTaint(type.getTaint());
        addTaint(scheme.getTaint());
        addTaint(data.getTaint());
        addTaint(categories.getTaint());
        addTaint(logTag.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1606179170 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1606179170;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.170 -0400", hash_original_method = "B6C33F6C9AFBFD4465A32F9300C74AFB", hash_generated_method = "8A09F22D26D067289A8C4D82F80D60D3")
    public void writeToXml(XmlSerializer serializer) throws IOException {
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
                    boolean varF5C6D5EBEA0A2A1C0C5B585B8E141902_878315207 = (type.indexOf('/') < 0);
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
                    boolean varD52B50DE393A2B2F765AF58DB2789B84_1438174587 = (ae.getPort() >= 0);
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
                    Object var3F55985824039D507E9B86622028DD13_704580164 = (pe.getType());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.180 -0400", hash_original_method = "276CC8B213E249CE42650F70E7C4B53B", hash_generated_method = "F1D9161C5AFDB4DD869FCEA54A11F1AF")
    public void readFromXml(XmlPullParser parser) throws XmlPullParserException,
            IOException {
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var003C1B2273232C3B7B27A28F0A982195_1760392203 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth));
            {
                String tagName;
                tagName = parser.getName();
                {
                    boolean varFCDCA384B5AE04B7C812E6C97E646171_30184502 = (tagName.equals(ACTION_STR));
                    {
                        String name;
                        name = parser.getAttributeValue(null, NAME_STR);
                        {
                            addAction(name);
                        } //End block
                    } //End block
                    {
                        boolean varA79B623DA4F2C04CCACF87A377409319_837236507 = (tagName.equals(CAT_STR));
                        {
                            String name;
                            name = parser.getAttributeValue(null, NAME_STR);
                            {
                                addCategory(name);
                            } //End block
                        } //End block
                        {
                            boolean var977A45C559BECBE43F4912D2273DF0C8_1587692777 = (tagName.equals(TYPE_STR));
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
                                boolean var6DC38F2E64C783805E18B68A201E5478_971747416 = (tagName.equals(SCHEME_STR));
                                {
                                    String name;
                                    name = parser.getAttributeValue(null, NAME_STR);
                                    {
                                        addDataScheme(name);
                                    } //End block
                                } //End block
                                {
                                    boolean var8853BBB6CFA09C0887644DF8808FF11A_293720994 = (tagName.equals(AUTH_STR));
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
                                        boolean var22FFAE6F647F1E2186452AB348DF879B_1135097615 = (tagName.equals(PATH_STR));
                                        {
                                            String path;
                                            path = parser.getAttributeValue(null, LITERAL_STR);
                                            {
                                                addDataPath(path, PatternMatcher.PATTERN_LITERAL);
                                            } //End block
                                            {
                                                boolean varFD9E988BC7BA6C67FA0846D5B6BA2EAE_871310357 = ((path=parser.getAttributeValue(null, PREFIX_STR)) != null);
                                                {
                                                    addDataPath(path, PatternMatcher.PATTERN_PREFIX);
                                                } //End block
                                                {
                                                    boolean var65A46A0D515CAD733F17FA4060913973_67734969 = ((path=parser.getAttributeValue(null, SGLOB_STR)) != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.213 -0400", hash_original_method = "75FFB292CCD000E47FA0C7D0BE596A36", hash_generated_method = "FB5E7F18D50080FB87FE79D8EB83AB7C")
    public void dump(Printer du, String prefix) {
        StringBuilder sb;
        sb = new StringBuilder(256);
        {
            boolean var71B9BA72BB6B517DA479CF3A88B95269_933372570 = (mActions.size() > 0);
            {
                Iterator<String> it;
                it = mActions.iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1667868577 = (it.hasNext());
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
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1764191111 = (it.hasNext());
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
                boolean varB2FF4435B274CC4BE01D264DEA08F957_261765789 = (it.hasNext());
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
                boolean varB2FF4435B274CC4BE01D264DEA08F957_2004784416 = (it.hasNext());
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
                boolean varB2FF4435B274CC4BE01D264DEA08F957_337696602 = (it.hasNext());
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
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1128208676 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.223 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F2637D616417306BF1BE88876E811385")
    public final int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301007726 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301007726;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.241 -0400", hash_original_method = "2C734948869786E017228B90D172BE24", hash_generated_method = "56CF02CCD5CCE78E36A95E1B4C4EE628")
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
            int N;
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
            int N;
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
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.243 -0400", hash_original_method = "FBEEEBAC37A62143C058604C825166BE", hash_generated_method = "2C3214A5542358475A8CF408C4A3B5FC")
    public boolean debugCheck() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115939869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115939869;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.245 -0400", hash_original_method = "742383A5720F36FAAE26E247984D38D1", hash_generated_method = "6F238033A93321C6094502952F6F5FCD")
    private final boolean findMimeType(String type) {
        ArrayList<String> t;
        t = mDataTypes;
        {
            boolean var94BA75702969E64AAFAD0932F9F19FE6_2141807995 = (t.contains(type));
        } //End collapsed parenthetic
        int typeLength;
        typeLength = type.length();
        {
            boolean varC0B1C251D972DB5100663171FE0ED803_1530885812 = (typeLength == 3 && type.equals("*/*"));
            {
                boolean var207FD69B8C4084DC550BC184B4637898_128856917 = (!t.isEmpty());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDD39D56D1526DF18BC77C0B3DD038B55_1015521189 = (mHasPartialTypes && t.contains("*"));
        } //End collapsed parenthetic
        int slashpos;
        slashpos = type.indexOf('/');
        {
            {
                boolean var6B9A6E4432B816B7E7FEA6713DF1EE03_1834676023 = (mHasPartialTypes && t.contains(type.substring(0, slashpos)));
            } //End collapsed parenthetic
            {
                boolean varAF563929C59A468F116FAF629096DE41_2087464429 = (typeLength == slashpos+2 && type.charAt(slashpos+1) == '*');
                {
                    int numTypes;
                    numTypes = t.size();
                    {
                        int i;
                        i = 0;
                        {
                            String v;
                            v = t.get(i);
                            {
                                boolean var11CCA35FDF5142E21DA9AFB5AAC19B77_108741240 = (type.regionMatches(0, v, 0, slashpos+1));
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2050158961 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2050158961;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class MalformedMimeTypeException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.262 -0400", hash_original_method = "8500983E91FE33F50F26D266A654E6C8", hash_generated_method = "76D07A54CDCC210EFF1FE4C037CB3505")
        public  MalformedMimeTypeException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.263 -0400", hash_original_method = "E06B6BA43D42AE50E4C9A14EEBF56FAC", hash_generated_method = "E089FA8DF2043AF9848D19DB7BA10CF1")
        public  MalformedMimeTypeException(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public final static class AuthorityEntry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.264 -0400", hash_original_field = "F8F65BB641A3EAB4D5CD871CD38B3B93", hash_generated_field = "0C08F8EAA89B66A92AA182AAF7101D01")

        private String mOrigHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.264 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

        private String mHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.264 -0400", hash_original_field = "F245AD4CEDF4FE31289C2C304D1D5975", hash_generated_field = "4775283DB55281CD651400D583AD7181")

        private boolean mWild;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.264 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

        private int mPort;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.265 -0400", hash_original_method = "FAC1F38311ACA5CF1D84B9DFACCAD236", hash_generated_method = "7BCC3206A85976AB9748D889DCD74284")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.291 -0400", hash_original_method = "9AA41EA6C96E16AD56B52F388CEAC244", hash_generated_method = "C25EE71C4F905DDEC436619875DD7883")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.292 -0400", hash_original_method = "3FD27104A5CDDCA498D8F62DC306DFFB", hash_generated_method = "4718A898E94235CE6895C6ECD81A811D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.293 -0400", hash_original_method = "56B964ED44110D4A8630C57ED8411A1C", hash_generated_method = "6BB62B3ADE4894CC3B0FFE8DDE156421")
        public String getHost() {
            String varB4EAC82CA7396A68D541C85D26508E83_1466680347 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1466680347 = mOrigHost;
            varB4EAC82CA7396A68D541C85D26508E83_1466680347.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1466680347;
            // ---------- Original Method ----------
            //return mOrigHost;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.297 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "B395A8D25DEAF3B5C3346E2CEF3CBD9C")
        public int getPort() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173451224 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173451224;
            // ---------- Original Method ----------
            //return mPort;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.327 -0400", hash_original_method = "FC31CC7FA89B702CE4ED1283F0D70C24", hash_generated_method = "E0CA7073040BDF3ADAE42A667C4B319D")
        public int match(Uri data) {
            String host;
            host = data.getHost();
            {
                {
                    boolean var1B71F291A87433E0716DC39D697C7F3A_722861435 = (host.length() < mHost.length());
                } //End collapsed parenthetic
                host = host.substring(host.length()-mHost.length());
            } //End block
            {
                boolean var7D1AEF3A34E8E1E90AF70D1486121E66_143804376 = (host.compareToIgnoreCase(mHost) != 0);
            } //End collapsed parenthetic
            {
                {
                    boolean var9F3060E6F5D255CBEEDF2919EC07ED98_1343344340 = (mPort != data.getPort());
                } //End collapsed parenthetic
            } //End block
            addTaint(data.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_397777251 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_397777251;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.328 -0400", hash_original_field = "1B14B190F8083606EAE9866EE2D8420A", hash_generated_field = "8464BA21ADD025E188812B640FC8701E")

    private static String SGLOB_STR = "sglob";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.328 -0400", hash_original_field = "86F097BF95F1AA716CCC9A63D2EB81AA", hash_generated_field = "22818F41D451785BFAD3423FDA64F0D7")

    private static String PREFIX_STR = "prefix";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.328 -0400", hash_original_field = "6A393441CAE2E6BA8661A2A790B9BD3A", hash_generated_field = "36ECD2ABAEB7436779026A069C34A900")

    private static String LITERAL_STR = "literal";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.328 -0400", hash_original_field = "04A3CE28FA3157C3CCB77E0071D396CD", hash_generated_field = "957C994B6D64576A62527E807C0068FF")

    private static String PATH_STR = "path";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.330 -0400", hash_original_field = "150FDD6F68BE978A88F86AD2873EDAFE", hash_generated_field = "372D98E37E517E1D9E73CBE93DE3ECF4")

    private static String PORT_STR = "port";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.330 -0400", hash_original_field = "019957BFE878AB3E79F639CC8FDC25D4", hash_generated_field = "195EC3381993D2E7D2A6143325F56B99")

    private static String HOST_STR = "host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.420 -0400", hash_original_field = "E62D8B7C04FCF1CD40D69F39C4B955D6", hash_generated_field = "E9AC770A23A161A8B12578A3ED4F8583")

    private static String AUTH_STR = "auth";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.420 -0400", hash_original_field = "30DF383648C6FAFE73F202B429E1FE37", hash_generated_field = "AF4731D2A4BF3953B448CA50C0AB83F3")

    private static String SCHEME_STR = "scheme";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.420 -0400", hash_original_field = "1C05FFE55AF62B33F675B76A1B6CCF6A", hash_generated_field = "3EB93F959E4A41682C27897CAB63C09C")

    private static String TYPE_STR = "type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.421 -0400", hash_original_field = "27410BA0FAE1A9A30C0179C2C752741E", hash_generated_field = "4D85A2504D5815A4BFAF4CEAB897ECE0")

    private static String CAT_STR = "cat";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.421 -0400", hash_original_field = "A661B8112FDD112F1875BC35CEA675F4", hash_generated_field = "C7E233A7B715702637A03296023F8A41")

    private static String NAME_STR = "name";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.421 -0400", hash_original_field = "F5C31232933C5E2ABE7280026D10B245", hash_generated_field = "BCF90FC2DC03BE1A93ED64CDB8C9E801")

    private static String ACTION_STR = "action";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.421 -0400", hash_original_field = "74637B437C78D88E3C7DCFACCF6E4980", hash_generated_field = "6027B3B34EF275EF0258CDA7F6C44B06")

    public static final int SYSTEM_HIGH_PRIORITY = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.421 -0400", hash_original_field = "353077210979C8C79343072728BF2D9A", hash_generated_field = "0B01181E7D37C91380237FEC68D6D2D3")

    public static final int SYSTEM_LOW_PRIORITY = -1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.422 -0400", hash_original_field = "058341A722955315E0E33E69124FEE19", hash_generated_field = "29606CB5EA802A3FC60CBE3892A8C231")

    public static final int MATCH_CATEGORY_MASK = 0xfff0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.422 -0400", hash_original_field = "CB979228755FD40F19E419AEA8107256", hash_generated_field = "B34195AB6941F69DE5EAC54045013E42")

    public static final int MATCH_ADJUSTMENT_MASK = 0x000ffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.422 -0400", hash_original_field = "A3255D675E31155A3001B8797C7B966D", hash_generated_field = "C9832C97F6DA3DADA2A2565BDBACE888")

    public static final int MATCH_ADJUSTMENT_NORMAL = 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.422 -0400", hash_original_field = "178B46F293C192C312ED4366D085CEC0", hash_generated_field = "A1B64111ED1BB3921E4D97B9744154C1")

    public static final int MATCH_CATEGORY_EMPTY = 0x0100000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.422 -0400", hash_original_field = "4BB39E3813E80D9621D0D1CC0FB99F84", hash_generated_field = "C12E4AC6561BC99691B6248231FD861A")

    public static final int MATCH_CATEGORY_SCHEME = 0x0200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.422 -0400", hash_original_field = "1692855581B57010A0ECDB3F5977972B", hash_generated_field = "FE262DE457FD58C71A1505F0420E15FE")

    public static final int MATCH_CATEGORY_HOST = 0x0300000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.423 -0400", hash_original_field = "1200D586A3667F023B4654A7B78253FE", hash_generated_field = "D10A1DB2D1A22224D638E95D16CE16B9")

    public static final int MATCH_CATEGORY_PORT = 0x0400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.423 -0400", hash_original_field = "C766E935F381FC06B2257F916BA02A21", hash_generated_field = "733A5B911AC6A408B5E5529505EC7DCE")

    public static final int MATCH_CATEGORY_PATH = 0x0500000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.423 -0400", hash_original_field = "19CA0A00F075EC4C3571BC37A8E25A1F", hash_generated_field = "EF521D11C4B126106700F8F59796E3EC")

    public static final int MATCH_CATEGORY_TYPE = 0x0600000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.423 -0400", hash_original_field = "FFC757B5E0F96115551506FAB5C3EE28", hash_generated_field = "77C0C8B7C43E88DB2627254044127D30")

    public static final int NO_MATCH_TYPE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.423 -0400", hash_original_field = "9E2C7CCA0536236D90B2117FD257B56D", hash_generated_field = "994792ED93AAD5E31FA521805925B110")

    public static final int NO_MATCH_DATA = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.424 -0400", hash_original_field = "977EE4FA01887F87DB89D32E63D447C0", hash_generated_field = "E5BEBE595B019031029BE6CBC65E803A")

    public static final int NO_MATCH_ACTION = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.424 -0400", hash_original_field = "97915C591435AF39A8AEC43737A59FC9", hash_generated_field = "5B8788CD30AACDBD788AC513C1CD39AE")

    public static final int NO_MATCH_CATEGORY = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.424 -0400", hash_original_field = "DCD9426D45070A28AEA2BF645CBE4999", hash_generated_field = "665198F8F263BBC69C46C9D3C09D5B07")

    public static final Parcelable.Creator<IntentFilter> CREATOR
            = new Parcelable.Creator<IntentFilter>() {
        public IntentFilter createFromParcel(Parcel source) {
            return new IntentFilter(source);
        }

        public IntentFilter[] newArray(int size) {
            return new IntentFilter[size];
        }
    };
}

