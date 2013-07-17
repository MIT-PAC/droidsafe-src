package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.475 -0400", hash_original_field = "22FC7A378B4F7C5F90F70A47BE1E4FCD", hash_generated_field = "032B46B6D9E42E1E80E269F8E583852A")

    private int mPriority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.475 -0400", hash_original_field = "C268D719F2F67098628D1A8EEBB72B48", hash_generated_field = "B7B787904E751334D4C6C5E9190CBECB")

    private ArrayList<String> mActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.475 -0400", hash_original_field = "E5C591146E984CF70A027B756462CD3D", hash_generated_field = "DF1B13D35CEEB5232DEB8422E072E169")

    private ArrayList<String> mCategories = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.475 -0400", hash_original_field = "ACE6ED917BE479CC0451087F07844425", hash_generated_field = "D6C69DEDF341F4A4196AEA26E81D24A7")

    private ArrayList<String> mDataSchemes = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.475 -0400", hash_original_field = "B7BD82E78C46D9D79C64D1CD52A40D35", hash_generated_field = "C318D366A8228836F69A6B4BDDBFB506")

    private ArrayList<AuthorityEntry> mDataAuthorities = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.475 -0400", hash_original_field = "B61E65339F4663631A2F55699D0303D1", hash_generated_field = "2207044C23DD28F016FBFC7451C9D66A")

    private ArrayList<PatternMatcher> mDataPaths = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.476 -0400", hash_original_field = "606D718D7940DF43E42D0547DAABEADA", hash_generated_field = "06256A3E596C9EB087048F541BEAB278")

    private ArrayList<String> mDataTypes = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.476 -0400", hash_original_field = "9D8D79625D9E596046C5C52803A8BF48", hash_generated_field = "A768E3466CCFB1BF3BC36D8E0C71D999")

    private boolean mHasPartialTypes = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.476 -0400", hash_original_method = "E570235BD10D63A46D952627D4823B55", hash_generated_method = "7B0E4140638D2A4CB4A4CCA023BAD3B0")
    public  IntentFilter() {
        mPriority = 0;
        mActions = new ArrayList<String>();
        // ---------- Original Method ----------
        //mPriority = 0;
        //mActions = new ArrayList<String>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.478 -0400", hash_original_method = "6BE32B941606799E1C4582399143D6DE", hash_generated_method = "119ED66427480ABD6681C0AE70D3B5DC")
    public  IntentFilter(String action) {
        addTaint(action.getTaint());
        mPriority = 0;
        mActions = new ArrayList<String>();
        addAction(action);
        // ---------- Original Method ----------
        //mPriority = 0;
        //mActions = new ArrayList<String>();
        //addAction(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.479 -0400", hash_original_method = "6F03ACB8C3DEEE507BC72687512BE15B", hash_generated_method = "C3D142F3F9C2C1CA1CA74C295E4A2ECC")
    public  IntentFilter(String action, String dataType) throws MalformedMimeTypeException {
        addTaint(dataType.getTaint());
        addTaint(action.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.481 -0400", hash_original_method = "1836401D6B82BE6CCBD088E7B5026D41", hash_generated_method = "61977D9904BE38916976648771C9E2EA")
    public  IntentFilter(IntentFilter o) {
        mPriority = o.mPriority;
        mActions = new ArrayList<String>(o.mActions);
        if(o.mCategories != null)        
        {
            mCategories = new ArrayList<String>(o.mCategories);
        } //End block
        if(o.mDataTypes != null)        
        {
            mDataTypes = new ArrayList<String>(o.mDataTypes);
        } //End block
        if(o.mDataSchemes != null)        
        {
            mDataSchemes = new ArrayList<String>(o.mDataSchemes);
        } //End block
        if(o.mDataAuthorities != null)        
        {
            mDataAuthorities = new ArrayList<AuthorityEntry>(o.mDataAuthorities);
        } //End block
        if(o.mDataPaths != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.484 -0400", hash_original_method = "0A18E8175DAFA9E0ECB5A7A15F664AD8", hash_generated_method = "91C505C438C5A84AC801F398BF946E86")
    private  IntentFilter(Parcel source) {
        mActions = new ArrayList<String>();
        source.readStringList(mActions);
        if(source.readInt() != 0)        
        {
            mCategories = new ArrayList<String>();
            source.readStringList(mCategories);
        } //End block
        if(source.readInt() != 0)        
        {
            mDataSchemes = new ArrayList<String>();
            source.readStringList(mDataSchemes);
        } //End block
        if(source.readInt() != 0)        
        {
            mDataTypes = new ArrayList<String>();
            source.readStringList(mDataTypes);
        } //End block
        int N = source.readInt();
        if(N > 0)        
        {
            mDataAuthorities = new ArrayList<AuthorityEntry>();
for(int i=0;i<N;i++)
            {
                mDataAuthorities.add(new AuthorityEntry(source));
            } //End block
        } //End block
        N = source.readInt();
        if(N > 0)        
        {
            mDataPaths = new ArrayList<PatternMatcher>();
for(int i=0;i<N;i++)
            {
                mDataPaths.add(new PatternMatcher(source));
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.490 -0400", hash_original_method = "1AF904ED06333BC0001A5A8D0FC8E3CC", hash_generated_method = "839A047CDB79A7FD6A97DD19F37CB628")
    public final void setPriority(int priority) {
        mPriority = priority;
        // ---------- Original Method ----------
        //mPriority = priority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.491 -0400", hash_original_method = "4CF75B39A2F3F4074ED78E7B55CDB45C", hash_generated_method = "B9F3E5D4297F89C8B172095D75976721")
    public final int getPriority() {
        int var22FC7A378B4F7C5F90F70A47BE1E4FCD_666115498 = (mPriority);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053585663 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053585663;
        // ---------- Original Method ----------
        //return mPriority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.493 -0400", hash_original_method = "FFF5B803FCB58F324812D605B6C9CE62", hash_generated_method = "4231B743ACAAD337723CCDB30D43BD00")
    public final void addAction(String action) {
        addTaint(action.getTaint());
        if(!mActions.contains(action))        
        {
            mActions.add(action.intern());
        } //End block
        // ---------- Original Method ----------
        //if (!mActions.contains(action)) {
            //mActions.add(action.intern());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.494 -0400", hash_original_method = "77921182B442B1D522A9772E07DC4CA3", hash_generated_method = "11EEC18AEBC64E2693F15A2A86513040")
    public final int countActions() {
        int varF3EAFD377BEC9E11B182DEBEDFEF6633_92766387 = (mActions.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1065576417 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1065576417;
        // ---------- Original Method ----------
        //return mActions.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.495 -0400", hash_original_method = "50CEFE8EA652B37B9EBFC8EA367BBC71", hash_generated_method = "908A20CE79EC17D4E1A4AC9BF55CB7CB")
    public final String getAction(int index) {
        addTaint(index);
String varDCAE7AC319C94BC62A244B841685A798_142570053 =         mActions.get(index);
        varDCAE7AC319C94BC62A244B841685A798_142570053.addTaint(taint);
        return varDCAE7AC319C94BC62A244B841685A798_142570053;
        // ---------- Original Method ----------
        //return mActions.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.496 -0400", hash_original_method = "9D48CC1056269867443B9FC005D01764", hash_generated_method = "B03D2393E2334825653C18629179FB7E")
    public final boolean hasAction(String action) {
        addTaint(action.getTaint());
        boolean var9D6780AADD73BF3B9EC49BF69D6BD735_694597787 = (action != null && mActions.contains(action));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2127925041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2127925041;
        // ---------- Original Method ----------
        //return action != null && mActions.contains(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.498 -0400", hash_original_method = "984560EB63068E6413989919BB90D187", hash_generated_method = "A8F7DCAF67C1A0CC32EAA3A414990A03")
    public final boolean matchAction(String action) {
        addTaint(action.getTaint());
        boolean varE3D87BFBF16DA04313BCE892CD29B894_150741080 = (hasAction(action));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2061597124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2061597124;
        // ---------- Original Method ----------
        //return hasAction(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.500 -0400", hash_original_method = "91B40E19A4EE68D85BFA3F1F256EBA72", hash_generated_method = "B7D6889D6EC5191C05C1F0A8C19F2BA9")
    public final Iterator<String> actionsIterator() {
Iterator<String> varDF53DA29D707FBB390D9465F9E1D140D_2138402361 =         mActions != null ? mActions.iterator() : null;
        varDF53DA29D707FBB390D9465F9E1D140D_2138402361.addTaint(taint);
        return varDF53DA29D707FBB390D9465F9E1D140D_2138402361;
        // ---------- Original Method ----------
        //return mActions != null ? mActions.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.504 -0400", hash_original_method = "B72DE1FACB480BB8E2AD802A23898A2F", hash_generated_method = "8E3F0A98CF52F6EB93236E0412678AAA")
    public final void addDataType(String type) throws MalformedMimeTypeException {
        addTaint(type.getTaint());
        final int slashpos = type.indexOf('/');
        final int typelen = type.length();
        if(slashpos > 0 && typelen >= slashpos+2)        
        {
            if(mDataTypes == null)            
            mDataTypes = new ArrayList<String>();
            if(typelen == slashpos+2 && type.charAt(slashpos+1) == '*')            
            {
                String str = type.substring(0, slashpos);
                if(!mDataTypes.contains(str))                
                {
                    mDataTypes.add(str.intern());
                } //End block
                mHasPartialTypes = true;
            } //End block
            else
            {
                if(!mDataTypes.contains(type))                
                {
                    mDataTypes.add(type.intern());
                } //End block
            } //End block
            return;
        } //End block
        MalformedMimeTypeException varD77185C8A55F1543B335FA40F3445B64_1949155818 = new MalformedMimeTypeException(type);
        varD77185C8A55F1543B335FA40F3445B64_1949155818.addTaint(taint);
        throw varD77185C8A55F1543B335FA40F3445B64_1949155818;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.505 -0400", hash_original_method = "9AF334B8B7AF494EC1E65710EFD1F300", hash_generated_method = "4934438D8679C936362CA9D8BC4261D1")
    public final boolean hasDataType(String type) {
        addTaint(type.getTaint());
        boolean var3895ACE75A6B167292EF5A2BC3EA1213_1590559046 = (mDataTypes != null && findMimeType(type));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533876495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_533876495;
        // ---------- Original Method ----------
        //return mDataTypes != null && findMimeType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.507 -0400", hash_original_method = "9C43102AEBDE030DD3A73C704DCFC758", hash_generated_method = "34A96E5C677B5E69A8771D3EE6CDBD4C")
    public final int countDataTypes() {
        int var56A8DF0D47CC084390E9F59876688229_1194858815 = (mDataTypes != null ? mDataTypes.size() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510858766 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510858766;
        // ---------- Original Method ----------
        //return mDataTypes != null ? mDataTypes.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.508 -0400", hash_original_method = "1020E9310C4CEB3D9A899FFC3406F498", hash_generated_method = "763537BA348B52E9622F1E2EB7ED0D18")
    public final String getDataType(int index) {
        addTaint(index);
String var1DC252EE1E770B886A64950F7DFCD615_503826925 =         mDataTypes.get(index);
        var1DC252EE1E770B886A64950F7DFCD615_503826925.addTaint(taint);
        return var1DC252EE1E770B886A64950F7DFCD615_503826925;
        // ---------- Original Method ----------
        //return mDataTypes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.509 -0400", hash_original_method = "E14DF72F5869874CC38AD67447F5264E", hash_generated_method = "02D081D5834BF2C3B435A2197FAE8CEF")
    public final Iterator<String> typesIterator() {
Iterator<String> var96354E09389D28803D7828FF9EBA18A2_854719773 =         mDataTypes != null ? mDataTypes.iterator() : null;
        var96354E09389D28803D7828FF9EBA18A2_854719773.addTaint(taint);
        return var96354E09389D28803D7828FF9EBA18A2_854719773;
        // ---------- Original Method ----------
        //return mDataTypes != null ? mDataTypes.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.511 -0400", hash_original_method = "5610D5819C8C8974F702B3F76798B195", hash_generated_method = "6FA9F4BD3DF9B24F213A90CEC890633C")
    public final void addDataScheme(String scheme) {
        addTaint(scheme.getTaint());
        if(mDataSchemes == null)        
        mDataSchemes = new ArrayList<String>();
        if(!mDataSchemes.contains(scheme))        
        {
            mDataSchemes.add(scheme.intern());
        } //End block
        // ---------- Original Method ----------
        //if (mDataSchemes == null) mDataSchemes = new ArrayList<String>();
        //if (!mDataSchemes.contains(scheme)) {
            //mDataSchemes.add(scheme.intern());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.512 -0400", hash_original_method = "23DC2F7DC5C53386402D5B95D046A59E", hash_generated_method = "2B68A17EAB171CEDE48D0A365726CDB8")
    public final int countDataSchemes() {
        int varCAAFF0609ED93C8E3CA1A957452D8C2D_456406048 = (mDataSchemes != null ? mDataSchemes.size() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558040316 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558040316;
        // ---------- Original Method ----------
        //return mDataSchemes != null ? mDataSchemes.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.512 -0400", hash_original_method = "F55C42908F22C2BF6411521C019E1E71", hash_generated_method = "2A5597354AD09DC5D0AA7995673DA257")
    public final String getDataScheme(int index) {
        addTaint(index);
String var5F20608E7C30703FEA01C3CDD2745DC8_1710835313 =         mDataSchemes.get(index);
        var5F20608E7C30703FEA01C3CDD2745DC8_1710835313.addTaint(taint);
        return var5F20608E7C30703FEA01C3CDD2745DC8_1710835313;
        // ---------- Original Method ----------
        //return mDataSchemes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.513 -0400", hash_original_method = "6D8F15A80747973FB96EA7F310404F85", hash_generated_method = "7413279ADF9F3000786553B7CAE8BB90")
    public final boolean hasDataScheme(String scheme) {
        addTaint(scheme.getTaint());
        boolean var773939BB130784921FC83908D137768B_789451732 = (mDataSchemes != null && mDataSchemes.contains(scheme));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_199040723 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_199040723;
        // ---------- Original Method ----------
        //return mDataSchemes != null && mDataSchemes.contains(scheme);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.514 -0400", hash_original_method = "B57BF7E15AE8E364684A85B4AA7D0368", hash_generated_method = "5E74760AC2DF636D0E5077FE9F2B7334")
    public final Iterator<String> schemesIterator() {
Iterator<String> varCBC2BE663D2FF6EB9BE185207497F024_624935462 =         mDataSchemes != null ? mDataSchemes.iterator() : null;
        varCBC2BE663D2FF6EB9BE185207497F024_624935462.addTaint(taint);
        return varCBC2BE663D2FF6EB9BE185207497F024_624935462;
        // ---------- Original Method ----------
        //return mDataSchemes != null ? mDataSchemes.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.515 -0400", hash_original_method = "617831DFB49DD0B093CE5F322F324A18", hash_generated_method = "DACC351A295984A9DF3E8DAB7DCCFC38")
    public final void addDataAuthority(String host, String port) {
        addTaint(port.getTaint());
        addTaint(host.getTaint());
        if(mDataAuthorities == null)        
        mDataAuthorities =
                new ArrayList<AuthorityEntry>();
        if(port != null)        
        port = port.intern();
        mDataAuthorities.add(new AuthorityEntry(host.intern(), port));
        // ---------- Original Method ----------
        //if (mDataAuthorities == null) mDataAuthorities =
                //new ArrayList<AuthorityEntry>();
        //if (port != null) port = port.intern();
        //mDataAuthorities.add(new AuthorityEntry(host.intern(), port));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.516 -0400", hash_original_method = "B59B7F6BD479782A00EECCEFFFB6C78B", hash_generated_method = "FF38D9DFB2CF1D0B0FEBD70B80376751")
    public final int countDataAuthorities() {
        int var83CBE5F32A7EE64A9294B09DC76B540E_201175369 = (mDataAuthorities != null ? mDataAuthorities.size() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1853746341 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1853746341;
        // ---------- Original Method ----------
        //return mDataAuthorities != null ? mDataAuthorities.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.517 -0400", hash_original_method = "5C821D7ECF8B0A79E64F1031BF4C37BB", hash_generated_method = "953973CAA9C32507A022B561D7ADC19E")
    public final AuthorityEntry getDataAuthority(int index) {
        addTaint(index);
AuthorityEntry var076CFD4C7379FAFE5C8D80E40F849198_1595085958 =         mDataAuthorities.get(index);
        var076CFD4C7379FAFE5C8D80E40F849198_1595085958.addTaint(taint);
        return var076CFD4C7379FAFE5C8D80E40F849198_1595085958;
        // ---------- Original Method ----------
        //return mDataAuthorities.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.518 -0400", hash_original_method = "04C5A3803469FEAEE8E315143FC0F6BE", hash_generated_method = "1432842FB8DCA203EB3960927F5E476D")
    public final boolean hasDataAuthority(Uri data) {
        addTaint(data.getTaint());
        boolean var6A4471DEEB7FEEB41B7FED2E898EAC0F_586470975 = (matchDataAuthority(data) >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_403883262 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_403883262;
        // ---------- Original Method ----------
        //return matchDataAuthority(data) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.523 -0400", hash_original_method = "104889BB491104C94E7C1142A3F4BAAD", hash_generated_method = "CFEBCF15E589437143791A81BEF4B661")
    public final Iterator<AuthorityEntry> authoritiesIterator() {
Iterator<AuthorityEntry> varED18BAD1BD7A5FE27CC656E83062FEE5_1920459637 =         mDataAuthorities != null ? mDataAuthorities.iterator() : null;
        varED18BAD1BD7A5FE27CC656E83062FEE5_1920459637.addTaint(taint);
        return varED18BAD1BD7A5FE27CC656E83062FEE5_1920459637;
        // ---------- Original Method ----------
        //return mDataAuthorities != null ? mDataAuthorities.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.525 -0400", hash_original_method = "F30E00ACF0BA9FCEBC6CDD2BDA55B075", hash_generated_method = "61821D34270BB7BFEADF6F21367B1E5A")
    public final void addDataPath(String path, int type) {
        addTaint(type);
        addTaint(path.getTaint());
        if(mDataPaths == null)        
        mDataPaths = new ArrayList<PatternMatcher>();
        mDataPaths.add(new PatternMatcher(path.intern(), type));
        // ---------- Original Method ----------
        //if (mDataPaths == null) mDataPaths = new ArrayList<PatternMatcher>();
        //mDataPaths.add(new PatternMatcher(path.intern(), type));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.525 -0400", hash_original_method = "60FAB9592DF6A1D398A3997EC9565FA6", hash_generated_method = "AB9E9A31CB5721B4FB48AEDE46932263")
    public final int countDataPaths() {
        int var7B3E4CC9BA5A681ECCD51DFCB43EA696_1980358947 = (mDataPaths != null ? mDataPaths.size() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683583291 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683583291;
        // ---------- Original Method ----------
        //return mDataPaths != null ? mDataPaths.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.526 -0400", hash_original_method = "C7BC21A1B57BD5F3F08A1F8B8EBDB051", hash_generated_method = "B850703EB54091D3569CF21110E6AA43")
    public final PatternMatcher getDataPath(int index) {
        addTaint(index);
PatternMatcher varD20C4A93C9FDA178B6928DD8A0698977_1662105680 =         mDataPaths.get(index);
        varD20C4A93C9FDA178B6928DD8A0698977_1662105680.addTaint(taint);
        return varD20C4A93C9FDA178B6928DD8A0698977_1662105680;
        // ---------- Original Method ----------
        //return mDataPaths.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.528 -0400", hash_original_method = "8A8BB0EA1E4D89E1A8E627888FCA29D4", hash_generated_method = "56D48583DD80690264D202F0C36F69EB")
    public final boolean hasDataPath(String data) {
        addTaint(data.getTaint());
        if(mDataPaths == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_491507739 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1400682320 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1400682320;
        } //End block
        final int numDataPaths = mDataPaths.size();
for(int i = 0;i < numDataPaths;i++)
        {
            final PatternMatcher pe = mDataPaths.get(i);
            if(pe.match(data))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1988250922 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1236830482 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1236830482;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_650542012 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1150173507 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1150173507;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.529 -0400", hash_original_method = "DFBFAEBB83F5AF41A1E2404555B650EF", hash_generated_method = "7D985F2E11F441CA26BBD77B20C524D6")
    public final Iterator<PatternMatcher> pathsIterator() {
Iterator<PatternMatcher> varD3FE13F5E7C2A0579E6A6306CD71D764_450252788 =         mDataPaths != null ? mDataPaths.iterator() : null;
        varD3FE13F5E7C2A0579E6A6306CD71D764_450252788.addTaint(taint);
        return varD3FE13F5E7C2A0579E6A6306CD71D764_450252788;
        // ---------- Original Method ----------
        //return mDataPaths != null ? mDataPaths.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.530 -0400", hash_original_method = "BBE034684833DCE31C3A8387BD50FAB0", hash_generated_method = "546CAD333232B09EA5C1C43E7A727971")
    public final int matchDataAuthority(Uri data) {
        addTaint(data.getTaint());
        if(mDataAuthorities == null)        
        {
            int var6157FFE49CB0B5214FA490E963369DAC_1159359968 = (NO_MATCH_DATA);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356230683 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356230683;
        } //End block
        final int numDataAuthorities = mDataAuthorities.size();
for(int i = 0;i < numDataAuthorities;i++)
        {
            final AuthorityEntry ae = mDataAuthorities.get(i);
            int match = ae.match(data);
            if(match >= 0)            
            {
                int varE3CC92C14A5E6DD1A7D94B6FF634D7FC_264206727 = (match);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1473497217 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1473497217;
            } //End block
        } //End block
        int var6157FFE49CB0B5214FA490E963369DAC_2015497358 = (NO_MATCH_DATA);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_539876202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_539876202;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.533 -0400", hash_original_method = "6458C2A82CD5BFA5489DF067AE915D84", hash_generated_method = "5AF523574BB780DC8BEBA20E3985141F")
    public final int matchData(String type, String scheme, Uri data) {
        addTaint(data.getTaint());
        addTaint(scheme.getTaint());
        addTaint(type.getTaint());
        final ArrayList<String> types = mDataTypes;
        final ArrayList<String> schemes = mDataSchemes;
        final ArrayList<AuthorityEntry> authorities = mDataAuthorities;
        final ArrayList<PatternMatcher> paths = mDataPaths;
        int match = MATCH_CATEGORY_EMPTY;
        if(types == null && schemes == null)        
        {
            int var955C3AED17800B458356AED1FF4D3BAD_877647527 = (((type == null && data == null)
                ? (MATCH_CATEGORY_EMPTY+MATCH_ADJUSTMENT_NORMAL) : NO_MATCH_DATA));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_612780039 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_612780039;
        } //End block
        if(schemes != null)        
        {
            if(schemes.contains(scheme != null ? scheme : ""))            
            {
                match = MATCH_CATEGORY_SCHEME;
            } //End block
            else
            {
                int var6157FFE49CB0B5214FA490E963369DAC_632746020 = (NO_MATCH_DATA);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260540673 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260540673;
            } //End block
            if(authorities != null)            
            {
                int authMatch = matchDataAuthority(data);
                if(authMatch >= 0)                
                {
                    if(paths == null)                    
                    {
                        match = authMatch;
                    } //End block
                    else
                    if(hasDataPath(data.getPath()))                    
                    {
                        match = MATCH_CATEGORY_PATH;
                    } //End block
                    else
                    {
                        int var6157FFE49CB0B5214FA490E963369DAC_47613389 = (NO_MATCH_DATA);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1277377265 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1277377265;
                    } //End block
                } //End block
                else
                {
                    int var6157FFE49CB0B5214FA490E963369DAC_1689590006 = (NO_MATCH_DATA);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1086432157 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1086432157;
                } //End block
            } //End block
        } //End block
        else
        {
            if(scheme != null && !"".equals(scheme)
                    && !"content".equals(scheme)
                    && !"file".equals(scheme))            
            {
                int var6157FFE49CB0B5214FA490E963369DAC_1068070307 = (NO_MATCH_DATA);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_70766803 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_70766803;
            } //End block
        } //End block
        if(types != null)        
        {
            if(findMimeType(type))            
            {
                match = MATCH_CATEGORY_TYPE;
            } //End block
            else
            {
                int varB33B171AA5B6B4E7180A1E82AFB1586E_1790920895 = (NO_MATCH_TYPE);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094712180 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094712180;
            } //End block
        } //End block
        else
        {
            if(type != null)            
            {
                int varB33B171AA5B6B4E7180A1E82AFB1586E_718534354 = (NO_MATCH_TYPE);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1773986474 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1773986474;
            } //End block
        } //End block
        int var2ABF444DA3C5561122CD56E4DDAD6D32_1676496975 = (match + MATCH_ADJUSTMENT_NORMAL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249081521 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249081521;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.536 -0400", hash_original_method = "740A58E186A747CF3BBDAB4A3568B004", hash_generated_method = "E88B93F0E486B2124F7689C225D7A958")
    public final void addCategory(String category) {
        addTaint(category.getTaint());
        if(mCategories == null)        
        mCategories = new ArrayList<String>();
        if(!mCategories.contains(category))        
        {
            mCategories.add(category.intern());
        } //End block
        // ---------- Original Method ----------
        //if (mCategories == null) mCategories = new ArrayList<String>();
        //if (!mCategories.contains(category)) {
            //mCategories.add(category.intern());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.536 -0400", hash_original_method = "D5AF5503C90FCC35F15F05FB572F3FAB", hash_generated_method = "F22D839305C2D027D61B1E7D8E090888")
    public final int countCategories() {
        int var73EE7D12BF483094EF03E36D4B5EC7CB_76113934 = (mCategories != null ? mCategories.size() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218823616 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218823616;
        // ---------- Original Method ----------
        //return mCategories != null ? mCategories.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.537 -0400", hash_original_method = "9221063C5ACD71C55B9DBC6F8D5B18B1", hash_generated_method = "1CFABA709F7F0D3CACBE0E974DFCB945")
    public final String getCategory(int index) {
        addTaint(index);
String var5CFFBAE79CCBE33E2FF89927347E3947_138674629 =         mCategories.get(index);
        var5CFFBAE79CCBE33E2FF89927347E3947_138674629.addTaint(taint);
        return var5CFFBAE79CCBE33E2FF89927347E3947_138674629;
        // ---------- Original Method ----------
        //return mCategories.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.537 -0400", hash_original_method = "3612221F73372432993CCD6954A20D1D", hash_generated_method = "D858001B28E0070AB4C5C1CBB2599635")
    public final boolean hasCategory(String category) {
        addTaint(category.getTaint());
        boolean varEFA7F491986BF2EBD52565F05969A03E_1023811389 = (mCategories != null && mCategories.contains(category));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746001133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746001133;
        // ---------- Original Method ----------
        //return mCategories != null && mCategories.contains(category);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.538 -0400", hash_original_method = "A1CBC473D8947BEFDC4AD1E1869906E2", hash_generated_method = "E5FCA68FE9EC777C472FCB38DFF2FFCD")
    public final Iterator<String> categoriesIterator() {
Iterator<String> varD9F5E65171F1E2E2FC1CBC221EB9DF4E_658676261 =         mCategories != null ? mCategories.iterator() : null;
        varD9F5E65171F1E2E2FC1CBC221EB9DF4E_658676261.addTaint(taint);
        return varD9F5E65171F1E2E2FC1CBC221EB9DF4E_658676261;
        // ---------- Original Method ----------
        //return mCategories != null ? mCategories.iterator() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.539 -0400", hash_original_method = "64ACE3DFA3E244FA74278C4A66D2BC47", hash_generated_method = "13AF5B4F80A87C1DE037DBD210148519")
    public final String matchCategories(Set<String> categories) {
        addTaint(categories.getTaint());
        if(categories == null)        
        {
String var540C13E9E156B687226421B24F2DF178_744125149 =             null;
            var540C13E9E156B687226421B24F2DF178_744125149.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_744125149;
        } //End block
        Iterator<String> it = categories.iterator();
        if(mCategories == null)        
        {
String var70CE89BB39449072710912C7BDF8B7DD_39201494 =             it.hasNext() ? it.next() : null;
            var70CE89BB39449072710912C7BDF8B7DD_39201494.addTaint(taint);
            return var70CE89BB39449072710912C7BDF8B7DD_39201494;
        } //End block
        while
(it.hasNext())        
        {
            final String category = it.next();
            if(!mCategories.contains(category))            
            {
String var59A5A7DECF343E07840ADE677ED1ABB7_1310781931 =                 category;
                var59A5A7DECF343E07840ADE677ED1ABB7_1310781931.addTaint(taint);
                return var59A5A7DECF343E07840ADE677ED1ABB7_1310781931;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_2084218696 =         null;
        var540C13E9E156B687226421B24F2DF178_2084218696.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2084218696;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.539 -0400", hash_original_method = "4ACC3B62E54BFBE055D3653A9CF49AD3", hash_generated_method = "6087FD81DD5D850E05258FA89C9A29FA")
    public final int match(ContentResolver resolver, Intent intent,
            boolean resolve, String logTag) {
        addTaint(logTag.getTaint());
        addTaint(resolve);
        addTaint(intent.getTaint());
        addTaint(resolver.getTaint());
        String type = resolve ? intent.resolveType(resolver) : intent.getType();
        int varAA5A2198DA9BC15F4D228D952638E6D3_647064318 = (match(intent.getAction(), type, intent.getScheme(),
                     intent.getData(), intent.getCategories(), logTag));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712646888 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712646888;
        // ---------- Original Method ----------
        //String type = resolve ? intent.resolveType(resolver) : intent.getType();
        //return match(intent.getAction(), type, intent.getScheme(),
                     //intent.getData(), intent.getCategories(), logTag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.541 -0400", hash_original_method = "80E2BB7D6EA3B343C7B82810FBA9B369", hash_generated_method = "7BF7921059419F34088C383E1273D38D")
    public final int match(String action, String type, String scheme,
            Uri data, Set<String> categories, String logTag) {
        addTaint(logTag.getTaint());
        addTaint(categories.getTaint());
        addTaint(data.getTaint());
        addTaint(scheme.getTaint());
        addTaint(type.getTaint());
        addTaint(action.getTaint());
        if(action != null && !matchAction(action))        
        {
            if(false){ }            int varEABBAF31742AFB70C5E45F07A780551B_918330620 = (NO_MATCH_ACTION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325988058 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325988058;
        } //End block
        int dataMatch = matchData(type, scheme, data);
        if(dataMatch < 0)        
        {
            if(false)            
            {
                if(dataMatch == NO_MATCH_TYPE)                
                {
                } //End block
                if(dataMatch == NO_MATCH_DATA)                
                {
                } //End block
            } //End block
            int var3C853C5E19A1AB03318118AEBF80FE86_870674842 = (dataMatch);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_963998563 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_963998563;
        } //End block
        String categoryMismatch = matchCategories(categories);
        if(categoryMismatch != null)        
        {
            if(false)            
            {
            } //End block
            int var161BDC10ADC5900DB207302E71455752_2089124413 = (NO_MATCH_CATEGORY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537049103 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537049103;
        } //End block
        if(false)        
        {
            if(categories != null)            
            {
                dataMatch -= mCategories.size() - categories.size();
            } //End block
        } //End block
        int var3C853C5E19A1AB03318118AEBF80FE86_2140501850 = (dataMatch);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832652285 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832652285;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.543 -0400", hash_original_method = "B6C33F6C9AFBFD4465A32F9300C74AFB", hash_generated_method = "66058D4375B7673EBE65DEC5F5C7F21E")
    public void writeToXml(XmlSerializer serializer) throws IOException {
        addTaint(serializer.getTaint());
        int N = countActions();
for(int i=0;i<N;i++)
        {
            serializer.startTag(null, ACTION_STR);
            serializer.attribute(null, NAME_STR, mActions.get(i));
            serializer.endTag(null, ACTION_STR);
        } //End block
        N = countCategories();
for(int i=0;i<N;i++)
        {
            serializer.startTag(null, CAT_STR);
            serializer.attribute(null, NAME_STR, mCategories.get(i));
            serializer.endTag(null, CAT_STR);
        } //End block
        N = countDataTypes();
for(int i=0;i<N;i++)
        {
            serializer.startTag(null, TYPE_STR);
            String type = mDataTypes.get(i);
            if(type.indexOf('/') < 0)            
            type = type + "/*";
            serializer.attribute(null, NAME_STR, type);
            serializer.endTag(null, TYPE_STR);
        } //End block
        N = countDataSchemes();
for(int i=0;i<N;i++)
        {
            serializer.startTag(null, SCHEME_STR);
            serializer.attribute(null, NAME_STR, mDataSchemes.get(i));
            serializer.endTag(null, SCHEME_STR);
        } //End block
        N = countDataAuthorities();
for(int i=0;i<N;i++)
        {
            serializer.startTag(null, AUTH_STR);
            AuthorityEntry ae = mDataAuthorities.get(i);
            serializer.attribute(null, HOST_STR, ae.getHost());
            if(ae.getPort() >= 0)            
            {
                serializer.attribute(null, PORT_STR, Integer.toString(ae.getPort()));
            } //End block
            serializer.endTag(null, AUTH_STR);
        } //End block
        N = countDataPaths();
for(int i=0;i<N;i++)
        {
            serializer.startTag(null, PATH_STR);
            PatternMatcher pe = mDataPaths.get(i);
switch(pe.getType()){
            case PatternMatcher.PATTERN_LITERAL:
            serializer.attribute(null, LITERAL_STR, pe.getPath());
            break;
            case PatternMatcher.PATTERN_PREFIX:
            serializer.attribute(null, PREFIX_STR, pe.getPath());
            break;
            case PatternMatcher.PATTERN_SIMPLE_GLOB:
            serializer.attribute(null, SGLOB_STR, pe.getPath());
            break;
}            serializer.endTag(null, PATH_STR);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.545 -0400", hash_original_method = "276CC8B213E249CE42650F70E7C4B53B", hash_generated_method = "50DD31206EBE77F85C206701EC8F2FD8")
    public void readFromXml(XmlPullParser parser) throws XmlPullParserException,
            IOException {
        addTaint(parser.getTaint());
        int outerDepth = parser.getDepth();
        int type;
        while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth))        
        {
            if(type == XmlPullParser.END_TAG
                    || type == XmlPullParser.TEXT)            
            {
                continue;
            } //End block
            String tagName = parser.getName();
            if(tagName.equals(ACTION_STR))            
            {
                String name = parser.getAttributeValue(null, NAME_STR);
                if(name != null)                
                {
                    addAction(name);
                } //End block
            } //End block
            else
            if(tagName.equals(CAT_STR))            
            {
                String name = parser.getAttributeValue(null, NAME_STR);
                if(name != null)                
                {
                    addCategory(name);
                } //End block
            } //End block
            else
            if(tagName.equals(TYPE_STR))            
            {
                String name = parser.getAttributeValue(null, NAME_STR);
                if(name != null)                
                {
                    try 
                    {
                        addDataType(name);
                    } //End block
                    catch (MalformedMimeTypeException e)
                    {
                    } //End block
                } //End block
            } //End block
            else
            if(tagName.equals(SCHEME_STR))            
            {
                String name = parser.getAttributeValue(null, NAME_STR);
                if(name != null)                
                {
                    addDataScheme(name);
                } //End block
            } //End block
            else
            if(tagName.equals(AUTH_STR))            
            {
                String host = parser.getAttributeValue(null, HOST_STR);
                String port = parser.getAttributeValue(null, PORT_STR);
                if(host != null)                
                {
                    addDataAuthority(host, port);
                } //End block
            } //End block
            else
            if(tagName.equals(PATH_STR))            
            {
                String path = parser.getAttributeValue(null, LITERAL_STR);
                if(path != null)                
                {
                    addDataPath(path, PatternMatcher.PATTERN_LITERAL);
                } //End block
                else
                if((path=parser.getAttributeValue(null, PREFIX_STR)) != null)                
                {
                    addDataPath(path, PatternMatcher.PATTERN_PREFIX);
                } //End block
                else
                if((path=parser.getAttributeValue(null, SGLOB_STR)) != null)                
                {
                    addDataPath(path, PatternMatcher.PATTERN_SIMPLE_GLOB);
                } //End block
            } //End block
            else
            {
            } //End block
            XmlUtils.skipCurrentTag(parser);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.548 -0400", hash_original_method = "75FFB292CCD000E47FA0C7D0BE596A36", hash_generated_method = "2DC06AB31F964003F3B770E722500112")
    public void dump(Printer du, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(du.getTaint());
        StringBuilder sb = new StringBuilder(256);
        if(mActions.size() > 0)        
        {
            Iterator<String> it = mActions.iterator();
            while
(it.hasNext())            
            {
                sb.setLength(0);
                sb.append(prefix);
                sb.append("Action: \"");
                sb.append(it.next());
                sb.append("\"");
                du.println(sb.toString());
            } //End block
        } //End block
        if(mCategories != null)        
        {
            Iterator<String> it = mCategories.iterator();
            while
(it.hasNext())            
            {
                sb.setLength(0);
                sb.append(prefix);
                sb.append("Category: \"");
                sb.append(it.next());
                sb.append("\"");
                du.println(sb.toString());
            } //End block
        } //End block
        if(mDataSchemes != null)        
        {
            Iterator<String> it = mDataSchemes.iterator();
            while
(it.hasNext())            
            {
                sb.setLength(0);
                sb.append(prefix);
                sb.append("Scheme: \"");
                sb.append(it.next());
                sb.append("\"");
                du.println(sb.toString());
            } //End block
        } //End block
        if(mDataAuthorities != null)        
        {
            Iterator<AuthorityEntry> it = mDataAuthorities.iterator();
            while
(it.hasNext())            
            {
                AuthorityEntry ae = it.next();
                sb.setLength(0);
                sb.append(prefix);
                sb.append("Authority: \"");
                sb.append(ae.mHost);
                sb.append("\": ");
                sb.append(ae.mPort);
                if(ae.mWild)                
                sb.append(" WILD");
                du.println(sb.toString());
            } //End block
        } //End block
        if(mDataPaths != null)        
        {
            Iterator<PatternMatcher> it = mDataPaths.iterator();
            while
(it.hasNext())            
            {
                PatternMatcher pe = it.next();
                sb.setLength(0);
                sb.append(prefix);
                sb.append("Path: \"");
                sb.append(pe);
                sb.append("\"");
                du.println(sb.toString());
            } //End block
        } //End block
        if(mDataTypes != null)        
        {
            Iterator<String> it = mDataTypes.iterator();
            while
(it.hasNext())            
            {
                sb.setLength(0);
                sb.append(prefix);
                sb.append("Type: \"");
                sb.append(it.next());
                sb.append("\"");
                du.println(sb.toString());
            } //End block
        } //End block
        if(mPriority != 0 || mHasPartialTypes)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.550 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "833414D4BD2EB3D48301A803449BA659")
    public final int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_661724129 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977502245 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977502245;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.552 -0400", hash_original_method = "2C734948869786E017228B90D172BE24", hash_generated_method = "FA372C557558868C1D4140CF4FFAAD5D")
    public final void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeStringList(mActions);
        if(mCategories != null)        
        {
            dest.writeInt(1);
            dest.writeStringList(mCategories);
        } //End block
        else
        {
            dest.writeInt(0);
        } //End block
        if(mDataSchemes != null)        
        {
            dest.writeInt(1);
            dest.writeStringList(mDataSchemes);
        } //End block
        else
        {
            dest.writeInt(0);
        } //End block
        if(mDataTypes != null)        
        {
            dest.writeInt(1);
            dest.writeStringList(mDataTypes);
        } //End block
        else
        {
            dest.writeInt(0);
        } //End block
        if(mDataAuthorities != null)        
        {
            final int N = mDataAuthorities.size();
            dest.writeInt(N);
for(int i=0;i<N;i++)
            {
                mDataAuthorities.get(i).writeToParcel(dest);
            } //End block
        } //End block
        else
        {
            dest.writeInt(0);
        } //End block
        if(mDataPaths != null)        
        {
            final int N = mDataPaths.size();
            dest.writeInt(N);
for(int i=0;i<N;i++)
            {
                mDataPaths.get(i).writeToParcel(dest, 0);
            } //End block
        } //End block
        else
        {
            dest.writeInt(0);
        } //End block
        dest.writeInt(mPriority);
        dest.writeInt(mHasPartialTypes ? 1 : 0);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.553 -0400", hash_original_method = "FBEEEBAC37A62143C058604C825166BE", hash_generated_method = "096842513A13DA8F6E0F5ACC93C7D589")
    public boolean debugCheck() {
        boolean varB326B5062B2F0E69046810717534CB09_780211631 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_892516731 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_892516731;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.555 -0400", hash_original_method = "742383A5720F36FAAE26E247984D38D1", hash_generated_method = "13283704523FEF7D1186E8E96601646B")
    private final boolean findMimeType(String type) {
        addTaint(type.getTaint());
        final ArrayList<String> t = mDataTypes;
        if(type == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_543617058 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1111025499 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1111025499;
        } //End block
        if(t.contains(type))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1934119440 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_79762168 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_79762168;
        } //End block
        final int typeLength = type.length();
        if(typeLength == 3 && type.equals("*/*"))        
        {
            boolean var1D068B9D5C11C8999F460D870E71A719_18262934 = (!t.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1720530920 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1720530920;
        } //End block
        if(mHasPartialTypes && t.contains("*"))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_529504312 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1523693990 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1523693990;
        } //End block
        final int slashpos = type.indexOf('/');
        if(slashpos > 0)        
        {
            if(mHasPartialTypes && t.contains(type.substring(0, slashpos)))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1667958365 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_756056028 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_756056028;
            } //End block
            if(typeLength == slashpos+2 && type.charAt(slashpos+1) == '*')            
            {
                final int numTypes = t.size();
for(int i = 0;i < numTypes;i++)
                {
                    final String v = t.get(i);
                    if(type.regionMatches(0, v, 0, slashpos+1))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_612231038 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_206393905 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_206393905;
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_156805329 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1011430151 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1011430151;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class MalformedMimeTypeException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.556 -0400", hash_original_method = "8500983E91FE33F50F26D266A654E6C8", hash_generated_method = "76D07A54CDCC210EFF1FE4C037CB3505")
        public  MalformedMimeTypeException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.557 -0400", hash_original_method = "E06B6BA43D42AE50E4C9A14EEBF56FAC", hash_generated_method = "E089FA8DF2043AF9848D19DB7BA10CF1")
        public  MalformedMimeTypeException(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public final static class AuthorityEntry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.557 -0400", hash_original_field = "F8F65BB641A3EAB4D5CD871CD38B3B93", hash_generated_field = "0C08F8EAA89B66A92AA182AAF7101D01")

        private String mOrigHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.557 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

        private String mHost;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.557 -0400", hash_original_field = "F245AD4CEDF4FE31289C2C304D1D5975", hash_generated_field = "4775283DB55281CD651400D583AD7181")

        private boolean mWild;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.557 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

        private int mPort;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.559 -0400", hash_original_method = "FAC1F38311ACA5CF1D84B9DFACCAD236", hash_generated_method = "7BCC3206A85976AB9748D889DCD74284")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.559 -0400", hash_original_method = "9AA41EA6C96E16AD56B52F388CEAC244", hash_generated_method = "C25EE71C4F905DDEC436619875DD7883")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.560 -0400", hash_original_method = "3FD27104A5CDDCA498D8F62DC306DFFB", hash_generated_method = "7A3D8254F7D2D3E265A8165B8858586B")
         void writeToParcel(Parcel dest) {
            addTaint(dest.getTaint());
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.560 -0400", hash_original_method = "56B964ED44110D4A8630C57ED8411A1C", hash_generated_method = "DFC90C8FFDB202420F925F70B1C6C5A2")
        public String getHost() {
String var0F8BF6F5C2827A165225109D7A5D92E0_1845557654 =             mOrigHost;
            var0F8BF6F5C2827A165225109D7A5D92E0_1845557654.addTaint(taint);
            return var0F8BF6F5C2827A165225109D7A5D92E0_1845557654;
            // ---------- Original Method ----------
            //return mOrigHost;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.560 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "CC82E80F029EA607DA87186B7CA73732")
        public int getPort() {
            int var5EFA61C4FCA92CA992BE37C2BAF4D350_271823242 = (mPort);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844678667 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844678667;
            // ---------- Original Method ----------
            //return mPort;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.561 -0400", hash_original_method = "FC31CC7FA89B702CE4ED1283F0D70C24", hash_generated_method = "F0028D9398528010F6A184A5AB88230C")
        public int match(Uri data) {
            addTaint(data.getTaint());
            String host = data.getHost();
            if(host == null)            
            {
                int var6157FFE49CB0B5214FA490E963369DAC_163043380 = (NO_MATCH_DATA);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003383787 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003383787;
            } //End block
            if(false){ }            if(mWild)            
            {
                if(host.length() < mHost.length())                
                {
                    int var6157FFE49CB0B5214FA490E963369DAC_2003594564 = (NO_MATCH_DATA);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003887166 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003887166;
                } //End block
                host = host.substring(host.length()-mHost.length());
            } //End block
            if(host.compareToIgnoreCase(mHost) != 0)            
            {
                int var6157FFE49CB0B5214FA490E963369DAC_272220653 = (NO_MATCH_DATA);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_336421482 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_336421482;
            } //End block
            if(mPort >= 0)            
            {
                if(mPort != data.getPort())                
                {
                    int var6157FFE49CB0B5214FA490E963369DAC_1131351595 = (NO_MATCH_DATA);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011521515 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011521515;
                } //End block
                int varED0A19589EDB44860EAC512FA9866DC6_941588399 = (MATCH_CATEGORY_PORT);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618188353 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618188353;
            } //End block
            int varD5279D4913C4CE938457DF24BEA90CD8_1712799368 = (MATCH_CATEGORY_HOST);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796257345 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796257345;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.561 -0400", hash_original_field = "1B14B190F8083606EAE9866EE2D8420A", hash_generated_field = "C4BAA85D0E2D827D81D6FD077E15ADAB")

    private static final String SGLOB_STR = "sglob";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.561 -0400", hash_original_field = "86F097BF95F1AA716CCC9A63D2EB81AA", hash_generated_field = "3FD2C7D31E487D70A6AA6204637B2899")

    private static final String PREFIX_STR = "prefix";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.561 -0400", hash_original_field = "6A393441CAE2E6BA8661A2A790B9BD3A", hash_generated_field = "6210DECFA06880B6974267C6646EE816")

    private static final String LITERAL_STR = "literal";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.561 -0400", hash_original_field = "04A3CE28FA3157C3CCB77E0071D396CD", hash_generated_field = "AE2B2A8BA02A502564CB5583944A3146")

    private static final String PATH_STR = "path";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.562 -0400", hash_original_field = "150FDD6F68BE978A88F86AD2873EDAFE", hash_generated_field = "013F1A4753121A357F8D4078614DB5E9")

    private static final String PORT_STR = "port";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.562 -0400", hash_original_field = "019957BFE878AB3E79F639CC8FDC25D4", hash_generated_field = "D18646C1A58B5E7B6FA605CC5A4DC7F3")

    private static final String HOST_STR = "host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.562 -0400", hash_original_field = "E62D8B7C04FCF1CD40D69F39C4B955D6", hash_generated_field = "1F480DB7C369FC6CBAE0E8C3FA3BF415")

    private static final String AUTH_STR = "auth";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.562 -0400", hash_original_field = "30DF383648C6FAFE73F202B429E1FE37", hash_generated_field = "EA900D1EEAE42F3BD549A09336FAB017")

    private static final String SCHEME_STR = "scheme";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.562 -0400", hash_original_field = "1C05FFE55AF62B33F675B76A1B6CCF6A", hash_generated_field = "4B774CE7E444A55B1B5AD2184D9A15CA")

    private static final String TYPE_STR = "type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.562 -0400", hash_original_field = "27410BA0FAE1A9A30C0179C2C752741E", hash_generated_field = "C2ADBD80B18293A0640432B18AE1AF15")

    private static final String CAT_STR = "cat";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.562 -0400", hash_original_field = "A661B8112FDD112F1875BC35CEA675F4", hash_generated_field = "21D10217770299F078A52DD982CBB332")

    private static final String NAME_STR = "name";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.562 -0400", hash_original_field = "F5C31232933C5E2ABE7280026D10B245", hash_generated_field = "35EF60995ACCB10C97AD2C3A5730D090")

    private static final String ACTION_STR = "action";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.562 -0400", hash_original_field = "74637B437C78D88E3C7DCFACCF6E4980", hash_generated_field = "6027B3B34EF275EF0258CDA7F6C44B06")

    public static final int SYSTEM_HIGH_PRIORITY = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.562 -0400", hash_original_field = "353077210979C8C79343072728BF2D9A", hash_generated_field = "0B01181E7D37C91380237FEC68D6D2D3")

    public static final int SYSTEM_LOW_PRIORITY = -1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.563 -0400", hash_original_field = "058341A722955315E0E33E69124FEE19", hash_generated_field = "29606CB5EA802A3FC60CBE3892A8C231")

    public static final int MATCH_CATEGORY_MASK = 0xfff0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.563 -0400", hash_original_field = "CB979228755FD40F19E419AEA8107256", hash_generated_field = "B34195AB6941F69DE5EAC54045013E42")

    public static final int MATCH_ADJUSTMENT_MASK = 0x000ffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.563 -0400", hash_original_field = "A3255D675E31155A3001B8797C7B966D", hash_generated_field = "C9832C97F6DA3DADA2A2565BDBACE888")

    public static final int MATCH_ADJUSTMENT_NORMAL = 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.563 -0400", hash_original_field = "178B46F293C192C312ED4366D085CEC0", hash_generated_field = "A1B64111ED1BB3921E4D97B9744154C1")

    public static final int MATCH_CATEGORY_EMPTY = 0x0100000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.563 -0400", hash_original_field = "4BB39E3813E80D9621D0D1CC0FB99F84", hash_generated_field = "C12E4AC6561BC99691B6248231FD861A")

    public static final int MATCH_CATEGORY_SCHEME = 0x0200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.563 -0400", hash_original_field = "1692855581B57010A0ECDB3F5977972B", hash_generated_field = "FE262DE457FD58C71A1505F0420E15FE")

    public static final int MATCH_CATEGORY_HOST = 0x0300000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.563 -0400", hash_original_field = "1200D586A3667F023B4654A7B78253FE", hash_generated_field = "D10A1DB2D1A22224D638E95D16CE16B9")

    public static final int MATCH_CATEGORY_PORT = 0x0400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.563 -0400", hash_original_field = "C766E935F381FC06B2257F916BA02A21", hash_generated_field = "733A5B911AC6A408B5E5529505EC7DCE")

    public static final int MATCH_CATEGORY_PATH = 0x0500000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.563 -0400", hash_original_field = "19CA0A00F075EC4C3571BC37A8E25A1F", hash_generated_field = "EF521D11C4B126106700F8F59796E3EC")

    public static final int MATCH_CATEGORY_TYPE = 0x0600000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.564 -0400", hash_original_field = "FFC757B5E0F96115551506FAB5C3EE28", hash_generated_field = "77C0C8B7C43E88DB2627254044127D30")

    public static final int NO_MATCH_TYPE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.564 -0400", hash_original_field = "9E2C7CCA0536236D90B2117FD257B56D", hash_generated_field = "994792ED93AAD5E31FA521805925B110")

    public static final int NO_MATCH_DATA = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.564 -0400", hash_original_field = "977EE4FA01887F87DB89D32E63D447C0", hash_generated_field = "E5BEBE595B019031029BE6CBC65E803A")

    public static final int NO_MATCH_ACTION = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.564 -0400", hash_original_field = "97915C591435AF39A8AEC43737A59FC9", hash_generated_field = "5B8788CD30AACDBD788AC513C1CD39AE")

    public static final int NO_MATCH_CATEGORY = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.564 -0400", hash_original_field = "DCD9426D45070A28AEA2BF645CBE4999", hash_generated_field = "665198F8F263BBC69C46C9D3C09D5B07")

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

