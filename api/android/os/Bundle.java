package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import android.util.Log;
import java.util.Collections;
import java.util.Set;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.HashMap;
public final class Bundle implements Parcelable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:54.857 -0400", hash_original_field = "6C9D7AEB7CF5AE9F2141CB23F95F4D45", hash_generated_field = "6C79F547522536A208CAFCE9016DC05F")

    @DSVAModeled
    Map<String, Object> mMap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:54.865 -0400", hash_original_field = "6F0688E91A01AD80018225C89D147561", hash_generated_field = "E5162DF86C59E17EA59FEBB7EF559274")

    Parcel mParcelledData = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:54.866 -0400", hash_original_field = "9BDF733D1D0EFCF06F719222F55E0B82", hash_generated_field = "118C47CE2184B36A84368A2523875D08")

    private boolean mHasFds = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:54.868 -0400", hash_original_field = "93BA40E6351E40670C537B5E15D7DF94", hash_generated_field = "9003EC392C88BA1EADB5D26698887EBB")

    private boolean mFdsKnown = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:54.870 -0400", hash_original_field = "C459D1B5B4B22FFBFAEDCC421A1613ED", hash_generated_field = "C91DCF8BDF06F4CA952EC1031BBDC33F")

    private boolean mAllowFds = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:54.979 -0400", hash_original_field = "334890635C1887AB66991B9374637EE6", hash_generated_field = "ABE17DFC947454E8F85FE66E61741F7A")

    private ClassLoader mClassLoader;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.014 -0400", hash_original_method = "40BE022BD5AEEE3B1F4C24A599FDBBB4", hash_generated_method = "D0B412F9D9C998F60A5827E098F54A80")
    public  Bundle() {
        mMap = new HashMap<String, Object>();
        mClassLoader = getClass().getClassLoader();
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>();
        //mClassLoader = getClass().getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.019 -0400", hash_original_method = "DB07395F523937B25016D60988A66D69", hash_generated_method = "84401EF7C5E724C9A0A8712DD56C891C")
      Bundle(Parcel parcelledData) {
        addTaint(parcelledData.getTaint());
        readFromParcel(parcelledData);
        // ---------- Original Method ----------
        //readFromParcel(parcelledData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.023 -0400", hash_original_method = "4CBA8A75160127E76B9D77B8452C524A", hash_generated_method = "5325D673E1E11CEF8833CE6FAD5B0719")
      Bundle(Parcel parcelledData, int length) {
        addTaint(length);
        addTaint(parcelledData.getTaint());
        readFromParcelInner(parcelledData, length);
        // ---------- Original Method ----------
        //readFromParcelInner(parcelledData, length);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.032 -0400", hash_original_method = "ED19BD28A9BE16566DAB3F7BC8440A20", hash_generated_method = "54C66743395BE4AB6BAD14CE7AE27455")
    public  Bundle(ClassLoader loader) {
        mMap = new HashMap<String, Object>();
        mClassLoader = loader;
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>();
        //mClassLoader = loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.042 -0400", hash_original_method = "1CEDEB07DCD1E2A2BE2C52C76F89017C", hash_generated_method = "2B27A067BF7B2EDAA4C66221F6D6260E")
    public  Bundle(int capacity) {
        mMap = new HashMap<String, Object>(capacity);
        mClassLoader = getClass().getClassLoader();
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>(capacity);
        //mClassLoader = getClass().getClassLoader();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.074 -0400", hash_original_method = "418D42BD4A8F16B387F3064B9218EE53", hash_generated_method = "11F544B121F75AF0D84F3AB92D420B7B")
    public  Bundle(Bundle b) {
        if(b.mParcelledData != null)        
        {
            mParcelledData = Parcel.obtain();
            mParcelledData.appendFrom(b.mParcelledData, 0, b.mParcelledData.dataSize());
            mParcelledData.setDataPosition(0);
        } //End block
        else
        {
            mParcelledData = null;
        } //End block
        if(b.mMap != null)        
        {
            mMap = new HashMap<String, Object>(b.mMap);
        } //End block
        else
        {
            mMap = null;
        } //End block
        mHasFds = b.mHasFds;
        mFdsKnown = b.mFdsKnown;
        mClassLoader = b.mClassLoader;
        // ---------- Original Method ----------
        //if (b.mParcelledData != null) {
            //mParcelledData = Parcel.obtain();
            //mParcelledData.appendFrom(b.mParcelledData, 0, b.mParcelledData.dataSize());
            //mParcelledData.setDataPosition(0);
        //} else {
            //mParcelledData = null;
        //}
        //if (b.mMap != null) {
            //mMap = new HashMap<String, Object>(b.mMap);
        //} else {
            //mMap = null;
        //}
        //mHasFds = b.mHasFds;
        //mFdsKnown = b.mFdsKnown;
        //mClassLoader = b.mClassLoader;
    }

    
        @DSModeled(DSC.BAN)
    public static Bundle forPair(String key, String value) {
        Bundle b = new Bundle(1);
        b.putString(key, value);
        return b;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.101 -0400", hash_original_method = "B3609B2F52C0BA6BE21E26730F76FD99", hash_generated_method = "9C90301FB89A3A9EB402F91B96770480")
    public String getPairValue() {
        unparcel();
        int size = mMap.size();
        if(size > 1)        
        {
        } //End block
        if(size == 0)        
        {
String var540C13E9E156B687226421B24F2DF178_179915264 =             null;
            var540C13E9E156B687226421B24F2DF178_179915264.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_179915264;
        } //End block
        Object o = mMap.values().iterator().next();
        try 
        {
String var05F8BA7898C830EEFB724B7656469F9E_30704574 =             (String) o;
            var05F8BA7898C830EEFB724B7656469F9E_30704574.addTaint(taint);
            return var05F8BA7898C830EEFB724B7656469F9E_30704574;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning("getPairValue()", o, "String", e);
String var540C13E9E156B687226421B24F2DF178_543008190 =             null;
            var540C13E9E156B687226421B24F2DF178_543008190.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_543008190;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //int size = mMap.size();
        //if (size > 1) {
            //Log.w(LOG_TAG, "getPairValue() used on Bundle with multiple pairs.");
        //}
        //if (size == 0) {
            //return null;
        //}
        //Object o = mMap.values().iterator().next();
        //try {
            //return (String) o;
        //} catch (ClassCastException e) {
            //typeWarning("getPairValue()", o, "String", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.110 -0400", hash_original_method = "98C9A117007F79899B5BBD029ABFD6B8", hash_generated_method = "1DFA79725EDD590714D0602080EA4C5B")
    public void setClassLoader(ClassLoader loader) {
        mClassLoader = loader;
        // ---------- Original Method ----------
        //mClassLoader = loader;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.114 -0400", hash_original_method = "DF35DB07DA97BBA7096331B39E871560", hash_generated_method = "62C8F52BAD08A79175D3875EC690E99B")
    public ClassLoader getClassLoader() {
ClassLoader var03260047576FFCA5A37C413ABA8D1CD1_431669795 =         mClassLoader;
        var03260047576FFCA5A37C413ABA8D1CD1_431669795.addTaint(taint);
        return var03260047576FFCA5A37C413ABA8D1CD1_431669795;
        // ---------- Original Method ----------
        //return mClassLoader;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.122 -0400", hash_original_method = "3A854A40DC72470BF5CA49CF20D41873", hash_generated_method = "091591AA36EE67155873DDBC7C2F6F04")
    public boolean setAllowFds(boolean allowFds) {
        boolean orig = mAllowFds;
        mAllowFds = allowFds;
        boolean var025F253325B46929CD34F2A7C3C55E7C_657424141 = (orig);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1839057912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1839057912;
        // ---------- Original Method ----------
        //boolean orig = mAllowFds;
        //mAllowFds = allowFds;
        //return orig;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.127 -0400", hash_original_method = "8ED269C57B5B4F834AF78EEAE05F20CC", hash_generated_method = "F588CA2BECD4DDA189F7971BCE67E136")
    @Override
    public Object clone() {
Object var4CCA019CFB07D192DF8D7237E7F0B00E_1469191763 =         new Bundle(this);
        var4CCA019CFB07D192DF8D7237E7F0B00E_1469191763.addTaint(taint);
        return var4CCA019CFB07D192DF8D7237E7F0B00E_1469191763;
        // ---------- Original Method ----------
        //return new Bundle(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.138 -0400", hash_original_method = "C84307F15A2AB40D2A9CA51D74C5FD0F", hash_generated_method = "FF841A661A20106D58F8562D36CF0EA2")
    synchronized void unparcel() {
        if(mParcelledData == null)        
        {
            return;
        } //End block
        int N = mParcelledData.readInt();
        if(N < 0)        
        {
            return;
        } //End block
        if(mMap == null)        
        {
            mMap = new HashMap<String, Object>();
        } //End block
        mParcelledData.readMapInternal(mMap, N, mClassLoader);
        mParcelledData.recycle();
        mParcelledData = null;
        // ---------- Original Method ----------
        //if (mParcelledData == null) {
            //return;
        //}
        //int N = mParcelledData.readInt();
        //if (N < 0) {
            //return;
        //}
        //if (mMap == null) {
            //mMap = new HashMap<String, Object>();
        //}
        //mParcelledData.readMapInternal(mMap, N, mClassLoader);
        //mParcelledData.recycle();
        //mParcelledData = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.146 -0400", hash_original_method = "89E974D778C485ED4A98439CDF5961E3", hash_generated_method = "2589B20E3DA759F2944F86B92C96601F")
    public int size() {
        unparcel();
        int varAAAF4724B0913947E2ED6094A113A891_951771865 = (mMap.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_722182444 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_722182444;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.size();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.152 -0400", hash_original_method = "8B93AFDE665AAAFE98B5EE9FD5355D4B", hash_generated_method = "3DE10A26149EEB2E3D91D31D57ADFD12")
    public boolean isEmpty() {
        unparcel();
        boolean varCEA0A99A912E069D03233564B3C4197B_2078121140 = (mMap.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436061990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436061990;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.168 -0400", hash_original_method = "9DC77B5F54151FE5CD815F7C8172B2ED", hash_generated_method = "E511022D09E81C4678253AC729CF8B7F")
    public void clear() {
        unparcel();
        mMap.clear();
        mHasFds = false;
        mFdsKnown = true;
        // ---------- Original Method ----------
        //unparcel();
        //mMap.clear();
        //mHasFds = false;
        //mFdsKnown = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.175 -0400", hash_original_method = "F5C0B952F7E6EDB282A82D73FA397DBD", hash_generated_method = "E6F890920065CFAA3B575715C7F86935")
    public boolean containsKey(String key) {
        addTaint(key.getTaint());
        unparcel();
        boolean var5BEEF4E2131DD3C69603DDE982CF106F_1833945091 = (mMap.containsKey(key));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1093463768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1093463768;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.183 -0400", hash_original_method = "E6C9158A697ED4C4296ED4A1595BA584", hash_generated_method = "AFE89B72F1690F1A63221BE4E89CB501")
    public Object get(String key) {
        addTaint(key.getTaint());
        unparcel();
Object var854B7A61C03CF753466A11AD5A6F683C_2142006971 =         mMap.get(key);
        var854B7A61C03CF753466A11AD5A6F683C_2142006971.addTaint(taint);
        return var854B7A61C03CF753466A11AD5A6F683C_2142006971;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.190 -0400", hash_original_method = "717A16AB4D98DDB60DEBCEA5CDF9B0B2", hash_generated_method = "1141D5516355B422B713906ADDE3884C")
    public void remove(String key) {
        addTaint(key.getTaint());
        unparcel();
        mMap.remove(key);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.remove(key);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.203 -0400", hash_original_method = "F30E47B42E381C2413B1100E1A47D1F8", hash_generated_method = "19C8D719C8CECA801C0058973A2CCB2F")
    public void putAll(Bundle map) {
        unparcel();
        map.unparcel();
        mMap.putAll(map.mMap);
        mHasFds |= map.mHasFds;
        mFdsKnown = mFdsKnown && map.mFdsKnown;
        // ---------- Original Method ----------
        //unparcel();
        //map.unparcel();
        //mMap.putAll(map.mMap);
        //mHasFds |= map.mHasFds;
        //mFdsKnown = mFdsKnown && map.mFdsKnown;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.211 -0400", hash_original_method = "00E2D8861948F8DB601BFD39768039D0", hash_generated_method = "EFE9837B21DD8E2A2A1FD4C36ABF5AE2")
    public Set<String> keySet() {
        unparcel();
Set<String> var7A82B7B57B6F40AC93309FDE8103AFB9_1026892867 =         mMap.keySet();
        var7A82B7B57B6F40AC93309FDE8103AFB9_1026892867.addTaint(taint);
        return var7A82B7B57B6F40AC93309FDE8103AFB9_1026892867;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.keySet();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.242 -0400", hash_original_method = "4B0480B2866CB29DA37F7AEC68A5E217", hash_generated_method = "5DEF87C3126270DC5B9ED343C95E52E8")
    public boolean hasFileDescriptors() {
        if(!mFdsKnown)        
        {
            boolean fdFound = false;
            if(mParcelledData != null)            
            {
                if(mParcelledData.hasFileDescriptors())                
                {
                    fdFound = true;
                } //End block
            } //End block
            else
            {
                Iterator<Map.Entry<String, Object>> iter = mMap.entrySet().iterator();
                while
(!fdFound && iter.hasNext())                
                {
                    Object obj = iter.next().getValue();
                    if(obj instanceof Parcelable)                    
                    {
                        if((((Parcelable)obj).describeContents()
                                & Parcelable.CONTENTS_FILE_DESCRIPTOR) != 0)                        
                        {
                            fdFound = true;
                            break;
                        } //End block
                    } //End block
                    else
                    if(obj instanceof Parcelable[])                    
                    {
                        Parcelable[] array = (Parcelable[]) obj;
for(int n = array.length - 1;n >= 0;n--)
                        {
                            if((array[n].describeContents()
                                    & Parcelable.CONTENTS_FILE_DESCRIPTOR) != 0)                            
                            {
                                fdFound = true;
                                break;
                            } //End block
                        } //End block
                    } //End block
                    else
                    if(obj instanceof SparseArray)                    
                    {
                        SparseArray<? extends Parcelable> array = (SparseArray<? extends Parcelable>) obj;
for(int n = array.size() - 1;n >= 0;n--)
                        {
                            if((array.get(n).describeContents()
                                    & Parcelable.CONTENTS_FILE_DESCRIPTOR) != 0)                            
                            {
                                fdFound = true;
                                break;
                            } //End block
                        } //End block
                    } //End block
                    else
                    if(obj instanceof ArrayList)                    
                    {
                        ArrayList array = (ArrayList) obj;
                        if((array.size() > 0)
                                && (array.get(0) instanceof Parcelable))                        
                        {
for(int n = array.size() - 1;n >= 0;n--)
                            {
                                Parcelable p = (Parcelable) array.get(n);
                                if(p != null && ((p.describeContents()
                                        & Parcelable.CONTENTS_FILE_DESCRIPTOR) != 0))                                
                                {
                                    fdFound = true;
                                    break;
                                } //End block
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
            mHasFds = fdFound;
            mFdsKnown = true;
        } //End block
        boolean var2250F3E2C27D5FBDB1DA94D9DB9ED089_1196604162 = (mHasFds);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1750962101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1750962101;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.262 -0400", hash_original_method = "94490DFEC498722DA435B9597CF0EDDE", hash_generated_method = "AA0232F6D518DCA833F071F38CF1937A")
    public void putBoolean(String key, boolean value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.267 -0400", hash_original_method = "60D945D31D7D04981E268C4CC855B009", hash_generated_method = "6BB88309DEA94D43AAF97E07C329172E")
    public void putByte(String key, byte value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.272 -0400", hash_original_method = "C6C3CAC58AEE8EB92E7D233D1233B510", hash_generated_method = "87E15F5F33271346FE1A7737456D4587")
    public void putChar(String key, char value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.277 -0400", hash_original_method = "48338BC49C4A94D5C3F73368CEF11822", hash_generated_method = "B08056C1BA8ED71F1F7CB1755B1C3DCD")
    public void putShort(String key, short value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.282 -0400", hash_original_method = "C2DD503B984E96C46288CB6F7C364E09", hash_generated_method = "75717305E5DC5CBB1C23249C31B0B731")
    public void putInt(String key, int value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.287 -0400", hash_original_method = "32D4E331D0F655A9205640C19ABF2B58", hash_generated_method = "380947CE9008B515597665A1F21EFAD9")
    public void putLong(String key, long value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.292 -0400", hash_original_method = "292C24CEC676EE3F6A373A1AE7371B82", hash_generated_method = "22B491D84FD27D572913A7624349E839")
    public void putFloat(String key, float value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.297 -0400", hash_original_method = "1F6C5CEB9374270482ED4835594D6EF1", hash_generated_method = "9871782FE26AB748D515061EFFB96781")
    public void putDouble(String key, double value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.302 -0400", hash_original_method = "E7336EB9055C9F862A0B8D336BB5AE0F", hash_generated_method = "FB618D2195B1DE7959F738C2433A3309")
    public void putString(String key, String value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.308 -0400", hash_original_method = "23A8E01E039C76712F2C134222EAC45B", hash_generated_method = "9FEC25DABD5FDC79C27E36673337DF25")
    public void putCharSequence(String key, CharSequence value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.315 -0400", hash_original_method = "F17082A305780CE778B93F20A20D0318", hash_generated_method = "B825AFB40717D029FF00DE37201693D6")
    public void putParcelable(String key, Parcelable value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
        //mFdsKnown = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.323 -0400", hash_original_method = "1666E21FDEAC3D0C57D8E38C022A7AD2", hash_generated_method = "580D4638CF5D0C7A5BA38455C1D06A54")
    public void putParcelableArray(String key, Parcelable[] value) {
        addTaint(value[0].getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
        //mFdsKnown = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.332 -0400", hash_original_method = "C07428EAC6D62CA3DF6F67489B512A7E", hash_generated_method = "C69B2B9F8E6A634EE595EF4A1E1B7114")
    public void putParcelableArrayList(String key,
        ArrayList<? extends Parcelable> value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
        //mFdsKnown = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.341 -0400", hash_original_method = "93FD4CBDA1682EAF0E9F2535BF397F65", hash_generated_method = "451996BF97545F96A4EEF3FFA82A5164")
    public void putSparseParcelableArray(String key,
            SparseArray<? extends Parcelable> value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
        //mFdsKnown = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.346 -0400", hash_original_method = "6C90B1571D2A36769CB59FB958C842F7", hash_generated_method = "BFF84763B105CAF23DC060A49B801701")
    public void putIntegerArrayList(String key, ArrayList<Integer> value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.351 -0400", hash_original_method = "ABD9DF23A5A8A0A83F11C474E2CAFB17", hash_generated_method = "37F9146356DBDB6648C38BEAC5313EE3")
    public void putStringArrayList(String key, ArrayList<String> value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.357 -0400", hash_original_method = "C0F2E9DF48888A828D6640DBBB8ADDE5", hash_generated_method = "6C01F67F412405F7DDDFCAEE4EFB7307")
    public void putCharSequenceArrayList(String key, ArrayList<CharSequence> value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.363 -0400", hash_original_method = "C647C81034119067E2383CA02CF65D5F", hash_generated_method = "2A4FB1229722946DE91D4EF0E38C280D")
    public void putSerializable(String key, Serializable value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.367 -0400", hash_original_method = "8E721A4E4DD3EA40820BFACA50BE3D1C", hash_generated_method = "ACACC06951724C44CEB31C2C666267E0")
    public void putBooleanArray(String key, boolean[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.371 -0400", hash_original_method = "1C56E40FECAB1AC7C31C1D64DCBF74F0", hash_generated_method = "5213B1E070335D9401528254C481E52C")
    public void putByteArray(String key, byte[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.376 -0400", hash_original_method = "2FF709A9E88600F14AEB34FA372FB7A3", hash_generated_method = "3104E0304351AB9D6E24A13D4518EEE0")
    public void putShortArray(String key, short[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.382 -0400", hash_original_method = "5BBE3077A529F887080D848A31F1E40F", hash_generated_method = "20FA95EC5112A909F98F512F04084DA0")
    public void putCharArray(String key, char[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.387 -0400", hash_original_method = "6E03156089AB80D54004D251F8CBA9A8", hash_generated_method = "AA0D743CF2BF08A40853D73E8355A710")
    public void putIntArray(String key, int[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.392 -0400", hash_original_method = "749D6A41C446C63F668941511653896B", hash_generated_method = "6F5922EC0EE0EA20F9531881ECEA0CEC")
    public void putLongArray(String key, long[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.396 -0400", hash_original_method = "6C49285A06086C4B176330EBC83C2D3B", hash_generated_method = "33F0CA57AA79BA462FC96478C4B6BBF1")
    public void putFloatArray(String key, float[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.401 -0400", hash_original_method = "BF0DED73B6BC272CA81A76D665AF3892", hash_generated_method = "B5D1C3A1B8E6873420787987F25DD229")
    public void putDoubleArray(String key, double[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.405 -0400", hash_original_method = "3F318C6E0F37B53192FF4A33987FF921", hash_generated_method = "1AC9029516C13EAFD5FB46257A07E20E")
    public void putStringArray(String key, String[] value) {
        addTaint(value[0].getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.410 -0400", hash_original_method = "D442CACA5F4C37E249E32A5FC3EA1B00", hash_generated_method = "908F70222D570FC2AD602F222D7078F4")
    public void putCharSequenceArray(String key, CharSequence[] value) {
        addTaint(value[0].getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.414 -0400", hash_original_method = "8FC0D5E8787A84A268AF6F8743FC18A2", hash_generated_method = "F313ED86E5BFEA7548458BE72E8636BD")
    public void putBundle(String key, Bundle value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.418 -0400", hash_original_method = "0DA9D5A0C7EE7D2AFD4BCC53AD3802F3", hash_generated_method = "1B458E4D89C58743C30A00821425F3A4")
    @Deprecated
    public void putIBinder(String key, IBinder value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.424 -0400", hash_original_method = "44491868325766EC5AED04910C3A4D05", hash_generated_method = "0792A4C510348927DE175D15C43AFEDA")
    public boolean getBoolean(String key) {
        addTaint(key.getTaint());
        unparcel();
        boolean var28350F5318FFB4968F4B0B8FBE8208DE_192671122 = (getBoolean(key, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_297101267 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_297101267;
        // ---------- Original Method ----------
        //unparcel();
        //return getBoolean(key, false);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.432 -0400", hash_original_method = "017EA18B11E7843C44A73EB9482CE841", hash_generated_method = "01C88019C3CC5BB108D962E4B5A39588")
    private void typeWarning(String key, Object value, String className,
        Object defaultValue, ClassCastException e) {
        addTaint(e.getTaint());
        addTaint(defaultValue.getTaint());
        addTaint(className.getTaint());
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        StringBuilder sb = new StringBuilder();
        sb.append("Key ");
        sb.append(key);
        sb.append(" expected ");
        sb.append(className);
        sb.append(" but value was a ");
        sb.append(value.getClass().getName());
        sb.append(".  The default value ");
        sb.append(defaultValue);
        sb.append(" was returned.");
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append("Key ");
        //sb.append(key);
        //sb.append(" expected ");
        //sb.append(className);
        //sb.append(" but value was a ");
        //sb.append(value.getClass().getName());
        //sb.append(".  The default value ");
        //sb.append(defaultValue);
        //sb.append(" was returned.");
        //Log.w(LOG_TAG, sb.toString());
        //Log.w(LOG_TAG, "Attempt to cast generated internal exception:", e);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.438 -0400", hash_original_method = "AA5C4C6D2863DB47E466486DB4471393", hash_generated_method = "0FAD8CB279163B0AEAFBED03688B0061")
    private void typeWarning(String key, Object value, String className,
        ClassCastException e) {
        addTaint(e.getTaint());
        addTaint(className.getTaint());
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        typeWarning(key, value, className, "<null>", e);
        // ---------- Original Method ----------
        //typeWarning(key, value, className, "<null>", e);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.445 -0400", hash_original_method = "62E0EA051DB8CF7BEF8CA2ACB88171F1", hash_generated_method = "85B0E924776CDCBCD46F75FE8DDED70C")
    public boolean getBoolean(String key, boolean defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            boolean var16830A58E1E33A4163524366BA7B701B_1846025398 = (defaultValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147435859 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147435859;
        } //End block
        try 
        {
            boolean varC0A59981B6A9A74E185A6995D9EB5B72_360433757 = ((Boolean) o);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1999414534 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1999414534;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Boolean", defaultValue, e);
            boolean var16830A58E1E33A4163524366BA7B701B_360688925 = (defaultValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_225003096 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_225003096;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Boolean) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Boolean", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.453 -0400", hash_original_method = "E9711B4A318F78DD358F0F07FAB02724", hash_generated_method = "7CDE4B3DA7CC5151B6E1EE322F54DDC4")
    public byte getByte(String key) {
        addTaint(key.getTaint());
        unparcel();
        byte var5B0A48E0E31913CC901DB451A84568F5_1127880515 = (getByte(key, (byte) 0));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_69905918 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_69905918;
        // ---------- Original Method ----------
        //unparcel();
        //return getByte(key, (byte) 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.459 -0400", hash_original_method = "44660F005C21F1E59A8F3EDCC4F5A0ED", hash_generated_method = "8AC1CB1AEF35009035F9F39AE8DF8133")
    public Byte getByte(String key, byte defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
Byte var6042003835E71BD302E1524BA5D2EC10_1708796667 =             defaultValue;
            var6042003835E71BD302E1524BA5D2EC10_1708796667.addTaint(taint);
            return var6042003835E71BD302E1524BA5D2EC10_1708796667;
        } //End block
        try 
        {
Byte varC54AA9AB5858E046700E70C354EEF0AA_1765899042 =             (Byte) o;
            varC54AA9AB5858E046700E70C354EEF0AA_1765899042.addTaint(taint);
            return varC54AA9AB5858E046700E70C354EEF0AA_1765899042;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Byte", defaultValue, e);
Byte var6042003835E71BD302E1524BA5D2EC10_2107873956 =             defaultValue;
            var6042003835E71BD302E1524BA5D2EC10_2107873956.addTaint(taint);
            return var6042003835E71BD302E1524BA5D2EC10_2107873956;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Byte) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Byte", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.466 -0400", hash_original_method = "82E77139364787BB6587747BA780C45B", hash_generated_method = "F494331CB0DEE0D6602E45E444A2F6C1")
    public char getChar(String key) {
        addTaint(key.getTaint());
        unparcel();
        char var73806458D5069BFA70A3B5BD5CCA2A2F_2036948877 = (getChar(key, (char) 0));
                char varA87DEB01C5F539E6BDA34829C8EF2368_927807264 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_927807264;
        // ---------- Original Method ----------
        //unparcel();
        //return getChar(key, (char) 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.474 -0400", hash_original_method = "1B86701C5E776F178851B3C57F1F092F", hash_generated_method = "65C4E1D1A209AB23EC7B86597AB5F345")
    public char getChar(String key, char defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            char var16830A58E1E33A4163524366BA7B701B_820807270 = (defaultValue);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_170910553 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_170910553;
        } //End block
        try 
        {
            char var37564EA23825AA037265BAD3230BA4E6_1728468932 = ((Character) o);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1166671927 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1166671927;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Character", defaultValue, e);
            char var16830A58E1E33A4163524366BA7B701B_1645698315 = (defaultValue);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_83451759 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_83451759;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Character) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Character", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.481 -0400", hash_original_method = "949AF94B781EE8B084883F15F1BA2BF2", hash_generated_method = "65F69A51FE9CF3BEFB6157670846D9BE")
    public short getShort(String key) {
        addTaint(key.getTaint());
        unparcel();
        short varF65C145A4B6788A86B59A1D71FA2611A_840817548 = (getShort(key, (short) 0));
                short var4F09DAA9D95BCB166A302407A0E0BABE_402668918 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_402668918;
        // ---------- Original Method ----------
        //unparcel();
        //return getShort(key, (short) 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.488 -0400", hash_original_method = "CB97516320C4B19AFFFFC9855DAD2391", hash_generated_method = "3667B18570EB4C50BCE806EE48E25502")
    public short getShort(String key, short defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            short var16830A58E1E33A4163524366BA7B701B_1784783866 = (defaultValue);
                        short var4F09DAA9D95BCB166A302407A0E0BABE_679156394 = getTaintShort();
            return var4F09DAA9D95BCB166A302407A0E0BABE_679156394;
        } //End block
        try 
        {
            short var1E09BB19CC3789BCDC69F4BC5428A6ED_839253212 = ((Short) o);
                        short var4F09DAA9D95BCB166A302407A0E0BABE_1125317520 = getTaintShort();
            return var4F09DAA9D95BCB166A302407A0E0BABE_1125317520;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Short", defaultValue, e);
            short var16830A58E1E33A4163524366BA7B701B_1106200287 = (defaultValue);
                        short var4F09DAA9D95BCB166A302407A0E0BABE_1910888809 = getTaintShort();
            return var4F09DAA9D95BCB166A302407A0E0BABE_1910888809;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Short) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Short", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.495 -0400", hash_original_method = "E147114FE6EABC6FAB98EAC3907FD421", hash_generated_method = "042DA4E9C85BB550A632A8197D86F34C")
    public int getInt(String key) {
        addTaint(key.getTaint());
        unparcel();
        int var320E08F6784C27152A618018E9775889_818751612 = (getInt(key, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1066825651 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1066825651;
        // ---------- Original Method ----------
        //unparcel();
        //return getInt(key, 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.502 -0400", hash_original_method = "83073F806AC00C1E2EC4E710A5472BFA", hash_generated_method = "295D9DC365BAE4D611C8230D604E0364")
    public int getInt(String key, int defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            int var16830A58E1E33A4163524366BA7B701B_709778982 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445400952 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445400952;
        } //End block
        try 
        {
            int var26AB24744252AEB94A58D664AB3E9D05_267144146 = ((Integer) o);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517884466 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517884466;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Integer", defaultValue, e);
            int var16830A58E1E33A4163524366BA7B701B_917435546 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_486044223 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_486044223;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Integer) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Integer", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.509 -0400", hash_original_method = "0CFFDE7713416A17E206C69E138AC0FF", hash_generated_method = "119BA7032AF4EEB37855DB273261568F")
    public long getLong(String key) {
        addTaint(key.getTaint());
        unparcel();
        long var0FDBB13DE0DC3D40CB711364CF60C85E_1568876848 = (getLong(key, 0L));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_838302104 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_838302104;
        // ---------- Original Method ----------
        //unparcel();
        //return getLong(key, 0L);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.516 -0400", hash_original_method = "84BBB1371E3F4460B78F31822950EAAA", hash_generated_method = "8F4BBFCF9A536F133843E412C34B727C")
    public long getLong(String key, long defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            long var16830A58E1E33A4163524366BA7B701B_194852498 = (defaultValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2056797913 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2056797913;
        } //End block
        try 
        {
            long varB5E7A03E9D897C58684C61698AA7DC1A_1550515319 = ((Long) o);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2100552365 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2100552365;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Long", defaultValue, e);
            long var16830A58E1E33A4163524366BA7B701B_278125659 = (defaultValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_116841076 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_116841076;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Long) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Long", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.524 -0400", hash_original_method = "0D69D7EB25C8E886B27D28B7A30E217C", hash_generated_method = "1E6386AB058BA73C623E3E88AEF4566A")
    public float getFloat(String key) {
        addTaint(key.getTaint());
        unparcel();
        float varBF23D61A5DA1AFA2DE55AB53E87ED61D_855965670 = (getFloat(key, 0.0f));
                float var546ADE640B6EDFBC8A086EF31347E768_794839248 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_794839248;
        // ---------- Original Method ----------
        //unparcel();
        //return getFloat(key, 0.0f);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.531 -0400", hash_original_method = "8162EC4F2AE30557D489C5C6263EB256", hash_generated_method = "E83BA13BA52A97030B60C9AD3464E33C")
    public float getFloat(String key, float defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            float var16830A58E1E33A4163524366BA7B701B_1973094986 = (defaultValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_1098147408 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1098147408;
        } //End block
        try 
        {
            float var8331AB1421C1C7163CDC80514402CB41_856792302 = ((Float) o);
                        float var546ADE640B6EDFBC8A086EF31347E768_1111563874 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1111563874;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Float", defaultValue, e);
            float var16830A58E1E33A4163524366BA7B701B_766178724 = (defaultValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_1873101810 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1873101810;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Float) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Float", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.538 -0400", hash_original_method = "F5086ED2941BC7C3CB9930D22842FA44", hash_generated_method = "35529E9F01293922D589B60AB425FFBF")
    public double getDouble(String key) {
        addTaint(key.getTaint());
        unparcel();
        double var0199B64F0100C891378130CE2B2D301A_1345678707 = (getDouble(key, 0.0));
                double varE8CD7DA078A86726031AD64F35F5A6C0_5523153 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_5523153;
        // ---------- Original Method ----------
        //unparcel();
        //return getDouble(key, 0.0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.545 -0400", hash_original_method = "172C416958EF64BBE0F98CDA39B416EB", hash_generated_method = "97E153379084C475F49B6D8DF5272DE3")
    public double getDouble(String key, double defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            double var16830A58E1E33A4163524366BA7B701B_974266455 = (defaultValue);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1377110657 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1377110657;
        } //End block
        try 
        {
            double var4A68A9E2AB417E2A6A41A28F465C1612_258936234 = ((Double) o);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_759759138 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_759759138;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Double", defaultValue, e);
            double var16830A58E1E33A4163524366BA7B701B_927766609 = (defaultValue);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1234291751 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1234291751;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Double) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Double", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.552 -0400", hash_original_method = "51BC83F6E10D252B7C417A14343A53BE", hash_generated_method = "F1C259503E73012EBC6F27D26112F616")
    public String getString(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
String var540C13E9E156B687226421B24F2DF178_411840514 =             null;
            var540C13E9E156B687226421B24F2DF178_411840514.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_411840514;
        } //End block
        try 
        {
String var05F8BA7898C830EEFB724B7656469F9E_1920512461 =             (String) o;
            var05F8BA7898C830EEFB724B7656469F9E_1920512461.addTaint(taint);
            return var05F8BA7898C830EEFB724B7656469F9E_1920512461;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "String", e);
String var540C13E9E156B687226421B24F2DF178_867041943 =             null;
            var540C13E9E156B687226421B24F2DF178_867041943.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_867041943;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (String) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "String", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.560 -0400", hash_original_method = "BC80281EBAB10986EFB226B5D89A6368", hash_generated_method = "EF24E87D49A89EAE509B31FE379B7FB0")
    public String getString(String key, String defaultValue) {
        addTaint(defaultValue.getTaint());
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
String var6042003835E71BD302E1524BA5D2EC10_1908642849 =             defaultValue;
            var6042003835E71BD302E1524BA5D2EC10_1908642849.addTaint(taint);
            return var6042003835E71BD302E1524BA5D2EC10_1908642849;
        } //End block
        try 
        {
String var05F8BA7898C830EEFB724B7656469F9E_73407712 =             (String) o;
            var05F8BA7898C830EEFB724B7656469F9E_73407712.addTaint(taint);
            return var05F8BA7898C830EEFB724B7656469F9E_73407712;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "String", e);
String var6042003835E71BD302E1524BA5D2EC10_859841178 =             defaultValue;
            var6042003835E71BD302E1524BA5D2EC10_859841178.addTaint(taint);
            return var6042003835E71BD302E1524BA5D2EC10_859841178;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (String) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "String", e);
            //return defaultValue;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.567 -0400", hash_original_method = "4D51A99620432005EDE9794C44D49E24", hash_generated_method = "9C34F2236BB9D8ABE915578B2AC07B5D")
    public CharSequence getCharSequence(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
CharSequence var540C13E9E156B687226421B24F2DF178_660388080 =             null;
            var540C13E9E156B687226421B24F2DF178_660388080.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_660388080;
        } //End block
        try 
        {
CharSequence var222AA52E30E95872ADF5687FA74CE561_1197165149 =             (CharSequence) o;
            var222AA52E30E95872ADF5687FA74CE561_1197165149.addTaint(taint);
            return var222AA52E30E95872ADF5687FA74CE561_1197165149;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "CharSequence", e);
CharSequence var540C13E9E156B687226421B24F2DF178_2071610722 =             null;
            var540C13E9E156B687226421B24F2DF178_2071610722.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2071610722;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (CharSequence) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "CharSequence", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.575 -0400", hash_original_method = "C5E593A01F019636F8A087C171F20745", hash_generated_method = "0488F0FE84DBC2918A37785DE369B7AA")
    public CharSequence getCharSequence(String key, CharSequence defaultValue) {
        addTaint(defaultValue.getTaint());
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
CharSequence var6042003835E71BD302E1524BA5D2EC10_734228447 =             defaultValue;
            var6042003835E71BD302E1524BA5D2EC10_734228447.addTaint(taint);
            return var6042003835E71BD302E1524BA5D2EC10_734228447;
        } //End block
        try 
        {
CharSequence var222AA52E30E95872ADF5687FA74CE561_186922720 =             (CharSequence) o;
            var222AA52E30E95872ADF5687FA74CE561_186922720.addTaint(taint);
            return var222AA52E30E95872ADF5687FA74CE561_186922720;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "CharSequence", e);
CharSequence var6042003835E71BD302E1524BA5D2EC10_593000970 =             defaultValue;
            var6042003835E71BD302E1524BA5D2EC10_593000970.addTaint(taint);
            return var6042003835E71BD302E1524BA5D2EC10_593000970;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (CharSequence) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "CharSequence", e);
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.582 -0400", hash_original_method = "7BDB21170493B124DD321ED35C766BAB", hash_generated_method = "44EC067D722EFA56D090F8A36F1CCED4")
    public Bundle getBundle(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
Bundle var540C13E9E156B687226421B24F2DF178_801892027 =             null;
            var540C13E9E156B687226421B24F2DF178_801892027.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_801892027;
        } //End block
        try 
        {
Bundle var45D34033B5203615BB9EF66A070A8AAD_1531579766 =             (Bundle) o;
            var45D34033B5203615BB9EF66A070A8AAD_1531579766.addTaint(taint);
            return var45D34033B5203615BB9EF66A070A8AAD_1531579766;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Bundle", e);
Bundle var540C13E9E156B687226421B24F2DF178_16548805 =             null;
            var540C13E9E156B687226421B24F2DF178_16548805.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_16548805;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (Bundle) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Bundle", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.589 -0400", hash_original_method = "3B646958426B4FA703D61CD64DB4127C", hash_generated_method = "572C7E2ACF1B7DC166C7E159C488DD53")
    public <T extends Parcelable> T getParcelable(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
T var540C13E9E156B687226421B24F2DF178_321169882 =             null;
            var540C13E9E156B687226421B24F2DF178_321169882.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_321169882;
        } //End block
        try 
        {
T varDD72649790B0E769482C6AFD3C9BD666_938487632 =             (T) o;
            varDD72649790B0E769482C6AFD3C9BD666_938487632.addTaint(taint);
            return varDD72649790B0E769482C6AFD3C9BD666_938487632;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Parcelable", e);
T var540C13E9E156B687226421B24F2DF178_1182490752 =             null;
            var540C13E9E156B687226421B24F2DF178_1182490752.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1182490752;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (T) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Parcelable", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.596 -0400", hash_original_method = "ACB5B2AD81C8600B2F6954C0DE15936B", hash_generated_method = "4EE1A266D62055F3131EC9068A21282E")
    public Parcelable[] getParcelableArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
Parcelable[] var540C13E9E156B687226421B24F2DF178_305690966 =             null;
            var540C13E9E156B687226421B24F2DF178_305690966.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_305690966;
        } //End block
        try 
        {
Parcelable[] var0A41EE4FAE6003B4C09B9A204979D444_283092909 =             (Parcelable[]) o;
            var0A41EE4FAE6003B4C09B9A204979D444_283092909.addTaint(taint);
            return var0A41EE4FAE6003B4C09B9A204979D444_283092909;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Parcelable[]", e);
Parcelable[] var540C13E9E156B687226421B24F2DF178_568796894 =             null;
            var540C13E9E156B687226421B24F2DF178_568796894.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_568796894;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (Parcelable[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Parcelable[]", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.604 -0400", hash_original_method = "4066E862ACF29CBEB786556AAFBFC58D", hash_generated_method = "000888949C0E1171C26D37E7DD90846A")
    public <T extends Parcelable> ArrayList<T> getParcelableArrayList(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
ArrayList<T> var540C13E9E156B687226421B24F2DF178_806477092 =             null;
            var540C13E9E156B687226421B24F2DF178_806477092.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_806477092;
        } //End block
        try 
        {
ArrayList<T> var8C4736B669D2FF87EF2D545A6CBB1081_558148862 =             (ArrayList<T>) o;
            var8C4736B669D2FF87EF2D545A6CBB1081_558148862.addTaint(taint);
            return var8C4736B669D2FF87EF2D545A6CBB1081_558148862;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList", e);
ArrayList<T> var540C13E9E156B687226421B24F2DF178_763858156 =             null;
            var540C13E9E156B687226421B24F2DF178_763858156.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_763858156;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (ArrayList<T>) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "ArrayList", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.611 -0400", hash_original_method = "F3D4EB475C3465E3892E6091F83F5D92", hash_generated_method = "BCE849B03B3DED85ECE99E857AB69DEB")
    public <T extends Parcelable> SparseArray<T> getSparseParcelableArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
SparseArray<T> var540C13E9E156B687226421B24F2DF178_438871606 =             null;
            var540C13E9E156B687226421B24F2DF178_438871606.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_438871606;
        } //End block
        try 
        {
SparseArray<T> varDF1763F4CB2B8A56FADAF6645F7D7547_1869242010 =             (SparseArray<T>) o;
            varDF1763F4CB2B8A56FADAF6645F7D7547_1869242010.addTaint(taint);
            return varDF1763F4CB2B8A56FADAF6645F7D7547_1869242010;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "SparseArray", e);
SparseArray<T> var540C13E9E156B687226421B24F2DF178_1931449992 =             null;
            var540C13E9E156B687226421B24F2DF178_1931449992.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1931449992;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (SparseArray<T>) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "SparseArray", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.619 -0400", hash_original_method = "3E1FB271E8FDF7CD375ECA97D496DB8C", hash_generated_method = "BCF1D0F94CE0C414FF86D7B0B3E679D1")
    @DSModeled(DSC.SAFE)
    public Serializable getSerializable(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
Serializable var540C13E9E156B687226421B24F2DF178_841498197 =             null;
            var540C13E9E156B687226421B24F2DF178_841498197.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_841498197;
        } //End block
        try 
        {
Serializable var7B8912D0D65C721E62169791E036D2E4_920549546 =             (Serializable) o;
            var7B8912D0D65C721E62169791E036D2E4_920549546.addTaint(taint);
            return var7B8912D0D65C721E62169791E036D2E4_920549546;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Serializable", e);
Serializable var540C13E9E156B687226421B24F2DF178_1370844656 =             null;
            var540C13E9E156B687226421B24F2DF178_1370844656.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1370844656;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (Serializable) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Serializable", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.626 -0400", hash_original_method = "129B869D98875CE72FDC17E4CC2A1579", hash_generated_method = "95C12CD88D5B5DE07C21B9AF78FC4E44")
    public ArrayList<Integer> getIntegerArrayList(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
ArrayList<Integer> var540C13E9E156B687226421B24F2DF178_1964908972 =             null;
            var540C13E9E156B687226421B24F2DF178_1964908972.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1964908972;
        } //End block
        try 
        {
ArrayList<Integer> varB8F385EFF336E304845C55B19DEFED99_1857354362 =             (ArrayList<Integer>) o;
            varB8F385EFF336E304845C55B19DEFED99_1857354362.addTaint(taint);
            return varB8F385EFF336E304845C55B19DEFED99_1857354362;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList<Integer>", e);
ArrayList<Integer> var540C13E9E156B687226421B24F2DF178_1225224617 =             null;
            var540C13E9E156B687226421B24F2DF178_1225224617.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1225224617;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (ArrayList<Integer>) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "ArrayList<Integer>", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.634 -0400", hash_original_method = "2869BDF5623DD5162F6A69DFD2D1F8AB", hash_generated_method = "62E3EC321F9218194D1AE92ADCF08D7A")
    public ArrayList<String> getStringArrayList(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
ArrayList<String> var540C13E9E156B687226421B24F2DF178_357606402 =             null;
            var540C13E9E156B687226421B24F2DF178_357606402.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_357606402;
        } //End block
        try 
        {
ArrayList<String> var6CB978612A32DB65E9747B2CE440DBD9_1533796135 =             (ArrayList<String>) o;
            var6CB978612A32DB65E9747B2CE440DBD9_1533796135.addTaint(taint);
            return var6CB978612A32DB65E9747B2CE440DBD9_1533796135;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList<String>", e);
ArrayList<String> var540C13E9E156B687226421B24F2DF178_908077852 =             null;
            var540C13E9E156B687226421B24F2DF178_908077852.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_908077852;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (ArrayList<String>) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "ArrayList<String>", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.673 -0400", hash_original_method = "9A13BDFEA4BB8512D10DFA31FFDE883A", hash_generated_method = "4D5FF7EF8EB3E0911CDF7EDA198FF55D")
    public ArrayList<CharSequence> getCharSequenceArrayList(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
ArrayList<CharSequence> var540C13E9E156B687226421B24F2DF178_1815356050 =             null;
            var540C13E9E156B687226421B24F2DF178_1815356050.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1815356050;
        } //End block
        try 
        {
ArrayList<CharSequence> var1B0D8FC24E767E0352471E3AC3D561A2_358573905 =             (ArrayList<CharSequence>) o;
            var1B0D8FC24E767E0352471E3AC3D561A2_358573905.addTaint(taint);
            return var1B0D8FC24E767E0352471E3AC3D561A2_358573905;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList<CharSequence>", e);
ArrayList<CharSequence> var540C13E9E156B687226421B24F2DF178_276212002 =             null;
            var540C13E9E156B687226421B24F2DF178_276212002.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_276212002;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (ArrayList<CharSequence>) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "ArrayList<CharSequence>", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.708 -0400", hash_original_method = "2242EDC01DC8898E91E207F436901294", hash_generated_method = "15189C2AB4185D5D44B23ED40C592370")
    public boolean[] getBooleanArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            boolean[] var37A6259CC0C1DAE299A7866489DFF0BD_807167422 = (null);
                        boolean[] var503EB2F420079C4024483971CE5EDEA8_2083638041 = {getTaintBoolean()};
            return var503EB2F420079C4024483971CE5EDEA8_2083638041;
        } //End block
        try 
        {
            boolean[] varE2BA3674FD9266CFB01DBFA76FCA616D_194911999 = ((boolean[]) o);
                        boolean[] var503EB2F420079C4024483971CE5EDEA8_402748073 = {getTaintBoolean()};
            return var503EB2F420079C4024483971CE5EDEA8_402748073;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "byte[]", e);
            boolean[] var37A6259CC0C1DAE299A7866489DFF0BD_89353039 = (null);
                        boolean[] var503EB2F420079C4024483971CE5EDEA8_97324517 = {getTaintBoolean()};
            return var503EB2F420079C4024483971CE5EDEA8_97324517;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (boolean[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "byte[]", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.719 -0400", hash_original_method = "61BA553FC99180BEC5D34878EFD2124D", hash_generated_method = "A327C0505A1320D65B68BB35E746DB2A")
    public byte[] getByteArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_275011432 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1305418136 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1305418136;
        } //End block
        try 
        {
            byte[] var9FE822C0B0667ABCB28F8576DB481C08_1919000653 = ((byte[]) o);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1445427224 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1445427224;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "byte[]", e);
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1041875256 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_609747152 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_609747152;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (byte[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "byte[]", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.729 -0400", hash_original_method = "7BB50DA07B268F9685287E0D939131D4", hash_generated_method = "113F00766841A817D296D6C30C898190")
    public short[] getShortArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            short[] var37A6259CC0C1DAE299A7866489DFF0BD_625225208 = (null);
                        short[] var48EE7E2DDF8A83602BC526873BD0F875_402490443 = {getTaintShort()};
            return var48EE7E2DDF8A83602BC526873BD0F875_402490443;
        } //End block
        try 
        {
            short[] var12B9A95732292904819C1404E2CBA6AB_1074360355 = ((short[]) o);
                        short[] var48EE7E2DDF8A83602BC526873BD0F875_2121380683 = {getTaintShort()};
            return var48EE7E2DDF8A83602BC526873BD0F875_2121380683;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "short[]", e);
            short[] var37A6259CC0C1DAE299A7866489DFF0BD_842581742 = (null);
                        short[] var48EE7E2DDF8A83602BC526873BD0F875_1067733254 = {getTaintShort()};
            return var48EE7E2DDF8A83602BC526873BD0F875_1067733254;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (short[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "short[]", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.737 -0400", hash_original_method = "E77DD9D06089068562F2943DA73C8461", hash_generated_method = "1F1FB875B4676ABC1495EAFA056048E3")
    public char[] getCharArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            char[] var37A6259CC0C1DAE299A7866489DFF0BD_1787543551 = (null);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1566260927 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_1566260927;
        } //End block
        try 
        {
            char[] var84081F0F01B25F1ACF8564E92E3D7FB9_1779978329 = ((char[]) o);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_488832271 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_488832271;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "char[]", e);
            char[] var37A6259CC0C1DAE299A7866489DFF0BD_1416024884 = (null);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1661256254 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_1661256254;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (char[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "char[]", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.745 -0400", hash_original_method = "85622F3A5EF64119863AB7B7CCBF9703", hash_generated_method = "E2484F84F5C1BE05F35CD09C90F6A757")
    public int[] getIntArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            int[] var37A6259CC0C1DAE299A7866489DFF0BD_1737767537 = (null);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_735871208 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_735871208;
        } //End block
        try 
        {
            int[] var1C8435EA995977647E605AA4DB8D057D_1922677515 = ((int[]) o);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1942055176 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_1942055176;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "int[]", e);
            int[] var37A6259CC0C1DAE299A7866489DFF0BD_1776923482 = (null);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_35632234 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_35632234;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (int[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "int[]", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.754 -0400", hash_original_method = "27B2CD54F5F69E8E74D59A821000C81A", hash_generated_method = "501DCC3B4C16516BBE1DE0E399CDD060")
    public long[] getLongArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            long[] var37A6259CC0C1DAE299A7866489DFF0BD_2125071402 = (null);
                        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1266039852 = {getTaintLong()};
            return var3908C7C3AF5171CEE1F112DAE77A5C4D_1266039852;
        } //End block
        try 
        {
            long[] var324FBE7B770A1FB7F944234CDD8D8302_1489698154 = ((long[]) o);
                        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_12853156 = {getTaintLong()};
            return var3908C7C3AF5171CEE1F112DAE77A5C4D_12853156;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "long[]", e);
            long[] var37A6259CC0C1DAE299A7866489DFF0BD_1365254270 = (null);
                        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_282116229 = {getTaintLong()};
            return var3908C7C3AF5171CEE1F112DAE77A5C4D_282116229;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (long[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "long[]", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.762 -0400", hash_original_method = "CF7D6838E0F23E6456879FF35A2AC714", hash_generated_method = "9004E2FF28ED4D52C129ED16B9065D66")
    public float[] getFloatArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            float[] var37A6259CC0C1DAE299A7866489DFF0BD_629386976 = (null);
                        float[] varB2C245003BAB9224CFB496218F7DAFE0_1002429199 = {getTaintFloat()};
            return varB2C245003BAB9224CFB496218F7DAFE0_1002429199;
        } //End block
        try 
        {
            float[] varB6BC16331AA469D6884123613ABE79E7_866254005 = ((float[]) o);
                        float[] varB2C245003BAB9224CFB496218F7DAFE0_1166688436 = {getTaintFloat()};
            return varB2C245003BAB9224CFB496218F7DAFE0_1166688436;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "float[]", e);
            float[] var37A6259CC0C1DAE299A7866489DFF0BD_188065042 = (null);
                        float[] varB2C245003BAB9224CFB496218F7DAFE0_316475482 = {getTaintFloat()};
            return varB2C245003BAB9224CFB496218F7DAFE0_316475482;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (float[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "float[]", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.771 -0400", hash_original_method = "3231DDBB4D17868FEAA7FF4365CACCDA", hash_generated_method = "2144C95B7DB011D2E71A07AE5E323CBF")
    public double[] getDoubleArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
            double[] var37A6259CC0C1DAE299A7866489DFF0BD_223649728 = (null);
                        double[] var74D44D7D9EE6FE6C3433D694F869E521_766264446 = {getTaintDouble()};
            return var74D44D7D9EE6FE6C3433D694F869E521_766264446;
        } //End block
        try 
        {
            double[] var799D16D1B5D5DF2402D4DA39D4423C0D_484285510 = ((double[]) o);
                        double[] var74D44D7D9EE6FE6C3433D694F869E521_813902414 = {getTaintDouble()};
            return var74D44D7D9EE6FE6C3433D694F869E521_813902414;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "double[]", e);
            double[] var37A6259CC0C1DAE299A7866489DFF0BD_1116038045 = (null);
                        double[] var74D44D7D9EE6FE6C3433D694F869E521_25589592 = {getTaintDouble()};
            return var74D44D7D9EE6FE6C3433D694F869E521_25589592;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (double[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "double[]", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.778 -0400", hash_original_method = "00D6B9CB5DC261567748885D1CE89780", hash_generated_method = "816F9DB42925B99B97B83FCCF687B7E9")
    public String[] getStringArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
String[] var540C13E9E156B687226421B24F2DF178_1284066183 =             null;
            var540C13E9E156B687226421B24F2DF178_1284066183.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1284066183;
        } //End block
        try 
        {
String[] var16C153FE5E6565C51E3D998C42B91976_1601581206 =             (String[]) o;
            var16C153FE5E6565C51E3D998C42B91976_1601581206.addTaint(taint);
            return var16C153FE5E6565C51E3D998C42B91976_1601581206;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "String[]", e);
String[] var540C13E9E156B687226421B24F2DF178_272511910 =             null;
            var540C13E9E156B687226421B24F2DF178_272511910.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_272511910;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (String[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "String[]", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.785 -0400", hash_original_method = "E55D822FE040164347A1371A3EEFE758", hash_generated_method = "E7391010DB508FE42E45C8A536AA6509")
    public CharSequence[] getCharSequenceArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
CharSequence[] var540C13E9E156B687226421B24F2DF178_924634234 =             null;
            var540C13E9E156B687226421B24F2DF178_924634234.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_924634234;
        } //End block
        try 
        {
CharSequence[] varE0F35EE7132543529B2EBACAA10305AF_1908050922 =             (CharSequence[]) o;
            varE0F35EE7132543529B2EBACAA10305AF_1908050922.addTaint(taint);
            return varE0F35EE7132543529B2EBACAA10305AF_1908050922;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "CharSequence[]", e);
CharSequence[] var540C13E9E156B687226421B24F2DF178_404066238 =             null;
            var540C13E9E156B687226421B24F2DF178_404066238.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_404066238;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (CharSequence[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "CharSequence[]", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.791 -0400", hash_original_method = "D295BFB1D3C25A7A56AF1D8267856D3B", hash_generated_method = "889610D9A60F746FC1D8A1C139ADCEA1")
    @Deprecated
    public IBinder getIBinder(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
IBinder var540C13E9E156B687226421B24F2DF178_1528512988 =             null;
            var540C13E9E156B687226421B24F2DF178_1528512988.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1528512988;
        } //End block
        try 
        {
IBinder varF1CBEA30581462C8D282C5AF2BF1C748_1926244210 =             (IBinder) o;
            varF1CBEA30581462C8D282C5AF2BF1C748_1926244210.addTaint(taint);
            return varF1CBEA30581462C8D282C5AF2BF1C748_1926244210;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "IBinder", e);
IBinder var540C13E9E156B687226421B24F2DF178_2690998 =             null;
            var540C13E9E156B687226421B24F2DF178_2690998.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2690998;
        } //End block
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (IBinder) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "IBinder", e);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.798 -0400", hash_original_method = "E95F1FE0EF3EE3193ED648BBE2C98991", hash_generated_method = "094BB75C6AE3C7BC5B767F656449F189")
    public int describeContents() {
        int mask = 0;
        if(hasFileDescriptors())        
        {
            mask |= Parcelable.CONTENTS_FILE_DESCRIPTOR;
        } //End block
        int varF2CE11EBF110993621BEDD8E747D7B1B_281888032 = (mask);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923342432 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923342432;
        // ---------- Original Method ----------
        //int mask = 0;
        //if (hasFileDescriptors()) {
            //mask |= Parcelable.CONTENTS_FILE_DESCRIPTOR;
        //}
        //return mask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.804 -0400", hash_original_method = "90A94F467F11AD2B1AEECA4B5BC07A1D", hash_generated_method = "8B5FF5BA32445196D63B4BEEC0C2DC54")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        final boolean oldAllowFds = parcel.pushAllowFds(mAllowFds);
        try 
        {
            if(mParcelledData != null)            
            {
                int length = mParcelledData.dataSize();
                parcel.writeInt(length);
                parcel.writeInt(0x4C444E42);
                parcel.appendFrom(mParcelledData, 0, length);
            } //End block
            else
            {
                parcel.writeInt(-1);
                parcel.writeInt(0x4C444E42);
                int oldPos = parcel.dataPosition();
                parcel.writeMapInternal(mMap);
                int newPos = parcel.dataPosition();
                parcel.setDataPosition(oldPos - 8);
                int length = newPos - oldPos;
                parcel.writeInt(length);
                parcel.setDataPosition(newPos);
            } //End block
        } //End block
        finally 
        {
            parcel.restoreAllowFds(oldAllowFds);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.810 -0400", hash_original_method = "046D2D4D1B8612C0E98B2174C0C88DC5", hash_generated_method = "D8013CB2A7D78E371DDA67A65A8C57CA")
    public void readFromParcel(Parcel parcel) {
        addTaint(parcel.getTaint());
        int length = parcel.readInt();
        if(length < 0)        
        {
            RuntimeException var84B5513F50EA60D710D121E42982F402_1554248883 = new RuntimeException("Bad length in parcel: " + length);
            var84B5513F50EA60D710D121E42982F402_1554248883.addTaint(taint);
            throw var84B5513F50EA60D710D121E42982F402_1554248883;
        } //End block
        readFromParcelInner(parcel, length);
        // ---------- Original Method ----------
        //int length = parcel.readInt();
        //if (length < 0) {
            //throw new RuntimeException("Bad length in parcel: " + length);
        //}
        //readFromParcelInner(parcel, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.820 -0400", hash_original_method = "BA7474E49C1BD74E29BF5B4706535141", hash_generated_method = "3E86D5953AE1E1E145CDC43602BF739E")
     void readFromParcelInner(Parcel parcel, int length) {
        addTaint(length);
        addTaint(parcel.getTaint());
        int magic = parcel.readInt();
        if(magic != 0x4C444E42)        
        {
            String st = Log.getStackTraceString(new RuntimeException());
        } //End block
        int offset = parcel.dataPosition();
        parcel.setDataPosition(offset + length);
        Parcel p = Parcel.obtain();
        p.setDataPosition(0);
        p.appendFrom(parcel, offset, length);
        p.setDataPosition(0);
        mParcelledData = p;
        mHasFds = p.hasFileDescriptors();
        mFdsKnown = true;
        // ---------- Original Method ----------
        //int magic = parcel.readInt();
        //if (magic != 0x4C444E42) {
            //String st = Log.getStackTraceString(new RuntimeException());
            //Log.e("Bundle", "readBundle: bad magic number");
            //Log.e("Bundle", "readBundle: trace = " + st);
        //}
        //int offset = parcel.dataPosition();
        //parcel.setDataPosition(offset + length);
        //Parcel p = Parcel.obtain();
        //p.setDataPosition(0);
        //p.appendFrom(parcel, offset, length);
        //p.setDataPosition(0);
        //mParcelledData = p;
        //mHasFds = p.hasFileDescriptors();
        //mFdsKnown = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.825 -0400", hash_original_method = "6D3D0FD7A771D9A5F3ECAE6DEB73615C", hash_generated_method = "797D61F7D8AC8611435844CB1D0F8120")
    @Override
    public synchronized String toString() {
        if(mParcelledData != null)        
        {
String varFF08288414AE5DAA590BBD75B1F9D1A6_485575690 =             "Bundle[mParcelledData.dataSize=" +
                    mParcelledData.dataSize() + "]";
            varFF08288414AE5DAA590BBD75B1F9D1A6_485575690.addTaint(taint);
            return varFF08288414AE5DAA590BBD75B1F9D1A6_485575690;
        } //End block
String var7912B2DCBC9E314551464676F1365845_364843374 =         "Bundle[" + mMap.toString() + "]";
        var7912B2DCBC9E314551464676F1365845_364843374.addTaint(taint);
        return var7912B2DCBC9E314551464676F1365845_364843374;
        // ---------- Original Method ----------
        //if (mParcelledData != null) {
            //return "Bundle[mParcelledData.dataSize=" +
                    //mParcelledData.dataSize() + "]";
        //}
        //return "Bundle[" + mMap.toString() + "]";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.828 -0400", hash_original_field = "9D5F877D7AA7E8D8702157333DF2C046", hash_generated_field = "B4A59EF1F4C419B90A176C13462BE720")

    private static final String LOG_TAG = "Bundle";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.830 -0400", hash_original_field = "BA2B45BDC11E2A4A6E86AAB2AC693CBB", hash_generated_field = "801351E620DCAB87B984F712F19DA2C3")

    public static final Bundle EMPTY;
    static {
        EMPTY = new Bundle();
        EMPTY.mMap = Collections.unmodifiableMap(new HashMap<String, Object>());
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.831 -0400", hash_original_field = "B4FE070174283716AFC584FD34F1BAE3", hash_generated_field = "C6D8CFB9909EC6A413DB28D9E9FEC6F2")

    public static final Parcelable.Creator<Bundle> CREATOR =
        new Parcelable.Creator<Bundle>() {
        @DSModeled(DSC.SAFE)
        public Bundle createFromParcel(Parcel in) {
            return in.readBundle();
        }

        @DSModeled(DSC.SAFE)
        public Bundle[] newArray(int size) {
            return new Bundle[size];
        }
    };
}

