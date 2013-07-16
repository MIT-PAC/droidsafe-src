package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class Bundle implements Parcelable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.004 -0400", hash_original_field = "6C9D7AEB7CF5AE9F2141CB23F95F4D45", hash_generated_field = "6C79F547522536A208CAFCE9016DC05F")

    Map<String, Object> mMap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.004 -0400", hash_original_field = "6F0688E91A01AD80018225C89D147561", hash_generated_field = "E5162DF86C59E17EA59FEBB7EF559274")

    Parcel mParcelledData = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.004 -0400", hash_original_field = "9BDF733D1D0EFCF06F719222F55E0B82", hash_generated_field = "118C47CE2184B36A84368A2523875D08")

    private boolean mHasFds = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.004 -0400", hash_original_field = "93BA40E6351E40670C537B5E15D7DF94", hash_generated_field = "9003EC392C88BA1EADB5D26698887EBB")

    private boolean mFdsKnown = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.004 -0400", hash_original_field = "C459D1B5B4B22FFBFAEDCC421A1613ED", hash_generated_field = "C91DCF8BDF06F4CA952EC1031BBDC33F")

    private boolean mAllowFds = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.004 -0400", hash_original_field = "334890635C1887AB66991B9374637EE6", hash_generated_field = "ABE17DFC947454E8F85FE66E61741F7A")

    private ClassLoader mClassLoader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.005 -0400", hash_original_method = "40BE022BD5AEEE3B1F4C24A599FDBBB4", hash_generated_method = "D0B412F9D9C998F60A5827E098F54A80")
    public  Bundle() {
        mMap = new HashMap<String, Object>();
        mClassLoader = getClass().getClassLoader();
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>();
        //mClassLoader = getClass().getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.005 -0400", hash_original_method = "DB07395F523937B25016D60988A66D69", hash_generated_method = "84401EF7C5E724C9A0A8712DD56C891C")
      Bundle(Parcel parcelledData) {
        addTaint(parcelledData.getTaint());
        readFromParcel(parcelledData);
        // ---------- Original Method ----------
        //readFromParcel(parcelledData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.005 -0400", hash_original_method = "4CBA8A75160127E76B9D77B8452C524A", hash_generated_method = "5325D673E1E11CEF8833CE6FAD5B0719")
      Bundle(Parcel parcelledData, int length) {
        addTaint(length);
        addTaint(parcelledData.getTaint());
        readFromParcelInner(parcelledData, length);
        // ---------- Original Method ----------
        //readFromParcelInner(parcelledData, length);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.006 -0400", hash_original_method = "ED19BD28A9BE16566DAB3F7BC8440A20", hash_generated_method = "54C66743395BE4AB6BAD14CE7AE27455")
    public  Bundle(ClassLoader loader) {
        mMap = new HashMap<String, Object>();
        mClassLoader = loader;
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>();
        //mClassLoader = loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.006 -0400", hash_original_method = "1CEDEB07DCD1E2A2BE2C52C76F89017C", hash_generated_method = "2B27A067BF7B2EDAA4C66221F6D6260E")
    public  Bundle(int capacity) {
        mMap = new HashMap<String, Object>(capacity);
        mClassLoader = getClass().getClassLoader();
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>(capacity);
        //mClassLoader = getClass().getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.008 -0400", hash_original_method = "418D42BD4A8F16B387F3064B9218EE53", hash_generated_method = "11F544B121F75AF0D84F3AB92D420B7B")
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

    
        public static Bundle forPair(String key, String value) {
        Bundle b = new Bundle(1);
        b.putString(key, value);
        return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.009 -0400", hash_original_method = "B3609B2F52C0BA6BE21E26730F76FD99", hash_generated_method = "41474EC4B56622ECD5599E7F0CD02275")
    public String getPairValue() {
        unparcel();
        int size = mMap.size();
    if(size > 1)        
        {
        } //End block
    if(size == 0)        
        {
String var540C13E9E156B687226421B24F2DF178_169341946 =             null;
            var540C13E9E156B687226421B24F2DF178_169341946.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_169341946;
        } //End block
        Object o = mMap.values().iterator().next();
        try 
        {
String var05F8BA7898C830EEFB724B7656469F9E_1262482023 =             (String) o;
            var05F8BA7898C830EEFB724B7656469F9E_1262482023.addTaint(taint);
            return var05F8BA7898C830EEFB724B7656469F9E_1262482023;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning("getPairValue()", o, "String", e);
String var540C13E9E156B687226421B24F2DF178_390403113 =             null;
            var540C13E9E156B687226421B24F2DF178_390403113.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_390403113;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.009 -0400", hash_original_method = "98C9A117007F79899B5BBD029ABFD6B8", hash_generated_method = "1DFA79725EDD590714D0602080EA4C5B")
    public void setClassLoader(ClassLoader loader) {
        mClassLoader = loader;
        // ---------- Original Method ----------
        //mClassLoader = loader;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.009 -0400", hash_original_method = "DF35DB07DA97BBA7096331B39E871560", hash_generated_method = "7F51CEA2DE6AA039F78E64D53CF48ADC")
    public ClassLoader getClassLoader() {
ClassLoader var03260047576FFCA5A37C413ABA8D1CD1_2064653161 =         mClassLoader;
        var03260047576FFCA5A37C413ABA8D1CD1_2064653161.addTaint(taint);
        return var03260047576FFCA5A37C413ABA8D1CD1_2064653161;
        // ---------- Original Method ----------
        //return mClassLoader;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.010 -0400", hash_original_method = "3A854A40DC72470BF5CA49CF20D41873", hash_generated_method = "FB4D11113E614632BC1E78610B9FB3EE")
    public boolean setAllowFds(boolean allowFds) {
        boolean orig = mAllowFds;
        mAllowFds = allowFds;
        boolean var025F253325B46929CD34F2A7C3C55E7C_2137318664 = (orig);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1232651754 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1232651754;
        // ---------- Original Method ----------
        //boolean orig = mAllowFds;
        //mAllowFds = allowFds;
        //return orig;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.010 -0400", hash_original_method = "8ED269C57B5B4F834AF78EEAE05F20CC", hash_generated_method = "05ED2997F3F827024CB55DE84DB522DE")
    @Override
    public Object clone() {
Object var4CCA019CFB07D192DF8D7237E7F0B00E_351829002 =         new Bundle(this);
        var4CCA019CFB07D192DF8D7237E7F0B00E_351829002.addTaint(taint);
        return var4CCA019CFB07D192DF8D7237E7F0B00E_351829002;
        // ---------- Original Method ----------
        //return new Bundle(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.011 -0400", hash_original_method = "C84307F15A2AB40D2A9CA51D74C5FD0F", hash_generated_method = "FF841A661A20106D58F8562D36CF0EA2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.011 -0400", hash_original_method = "89E974D778C485ED4A98439CDF5961E3", hash_generated_method = "944721D5ADD145C0FFD8FC5FBECCEA49")
    public int size() {
        unparcel();
        int varAAAF4724B0913947E2ED6094A113A891_1887860280 = (mMap.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1946616274 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1946616274;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.size();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.011 -0400", hash_original_method = "8B93AFDE665AAAFE98B5EE9FD5355D4B", hash_generated_method = "AFC1690A950666BE114524D2B5ADF3A4")
    public boolean isEmpty() {
        unparcel();
        boolean varCEA0A99A912E069D03233564B3C4197B_199366284 = (mMap.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_474601146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_474601146;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.012 -0400", hash_original_method = "9DC77B5F54151FE5CD815F7C8172B2ED", hash_generated_method = "E511022D09E81C4678253AC729CF8B7F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.012 -0400", hash_original_method = "F5C0B952F7E6EDB282A82D73FA397DBD", hash_generated_method = "D450A49EA516EEDC2944A04E460098C2")
    public boolean containsKey(String key) {
        addTaint(key.getTaint());
        unparcel();
        boolean var5BEEF4E2131DD3C69603DDE982CF106F_603138930 = (mMap.containsKey(key));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_339897582 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_339897582;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.012 -0400", hash_original_method = "E6C9158A697ED4C4296ED4A1595BA584", hash_generated_method = "D8FFFB9335B5D904DCE93BB9DED9C703")
    public Object get(String key) {
        addTaint(key.getTaint());
        unparcel();
Object var854B7A61C03CF753466A11AD5A6F683C_332597297 =         mMap.get(key);
        var854B7A61C03CF753466A11AD5A6F683C_332597297.addTaint(taint);
        return var854B7A61C03CF753466A11AD5A6F683C_332597297;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.013 -0400", hash_original_method = "717A16AB4D98DDB60DEBCEA5CDF9B0B2", hash_generated_method = "1141D5516355B422B713906ADDE3884C")
    public void remove(String key) {
        addTaint(key.getTaint());
        unparcel();
        mMap.remove(key);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.013 -0400", hash_original_method = "F30E47B42E381C2413B1100E1A47D1F8", hash_generated_method = "19C8D719C8CECA801C0058973A2CCB2F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.013 -0400", hash_original_method = "00E2D8861948F8DB601BFD39768039D0", hash_generated_method = "0704E59A720F1BD43A22B4413048651A")
    public Set<String> keySet() {
        unparcel();
Set<String> var7A82B7B57B6F40AC93309FDE8103AFB9_361472375 =         mMap.keySet();
        var7A82B7B57B6F40AC93309FDE8103AFB9_361472375.addTaint(taint);
        return var7A82B7B57B6F40AC93309FDE8103AFB9_361472375;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.keySet();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.015 -0400", hash_original_method = "4B0480B2866CB29DA37F7AEC68A5E217", hash_generated_method = "2E87EDA5C6DC49EE74A2E42629CEA4F5")
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
        boolean var2250F3E2C27D5FBDB1DA94D9DB9ED089_2032618593 = (mHasFds);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1842715545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1842715545;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.016 -0400", hash_original_method = "94490DFEC498722DA435B9597CF0EDDE", hash_generated_method = "AA0232F6D518DCA833F071F38CF1937A")
    public void putBoolean(String key, boolean value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.017 -0400", hash_original_method = "60D945D31D7D04981E268C4CC855B009", hash_generated_method = "6BB88309DEA94D43AAF97E07C329172E")
    public void putByte(String key, byte value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.017 -0400", hash_original_method = "C6C3CAC58AEE8EB92E7D233D1233B510", hash_generated_method = "87E15F5F33271346FE1A7737456D4587")
    public void putChar(String key, char value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.018 -0400", hash_original_method = "48338BC49C4A94D5C3F73368CEF11822", hash_generated_method = "B08056C1BA8ED71F1F7CB1755B1C3DCD")
    public void putShort(String key, short value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.018 -0400", hash_original_method = "C2DD503B984E96C46288CB6F7C364E09", hash_generated_method = "75717305E5DC5CBB1C23249C31B0B731")
    public void putInt(String key, int value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.018 -0400", hash_original_method = "32D4E331D0F655A9205640C19ABF2B58", hash_generated_method = "380947CE9008B515597665A1F21EFAD9")
    public void putLong(String key, long value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.019 -0400", hash_original_method = "292C24CEC676EE3F6A373A1AE7371B82", hash_generated_method = "22B491D84FD27D572913A7624349E839")
    public void putFloat(String key, float value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.019 -0400", hash_original_method = "1F6C5CEB9374270482ED4835594D6EF1", hash_generated_method = "9871782FE26AB748D515061EFFB96781")
    public void putDouble(String key, double value) {
        addTaint(value);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.020 -0400", hash_original_method = "E7336EB9055C9F862A0B8D336BB5AE0F", hash_generated_method = "FB618D2195B1DE7959F738C2433A3309")
    public void putString(String key, String value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.021 -0400", hash_original_method = "23A8E01E039C76712F2C134222EAC45B", hash_generated_method = "9FEC25DABD5FDC79C27E36673337DF25")
    public void putCharSequence(String key, CharSequence value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.021 -0400", hash_original_method = "F17082A305780CE778B93F20A20D0318", hash_generated_method = "B825AFB40717D029FF00DE37201693D6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.022 -0400", hash_original_method = "1666E21FDEAC3D0C57D8E38C022A7AD2", hash_generated_method = "580D4638CF5D0C7A5BA38455C1D06A54")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.023 -0400", hash_original_method = "C07428EAC6D62CA3DF6F67489B512A7E", hash_generated_method = "C69B2B9F8E6A634EE595EF4A1E1B7114")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.023 -0400", hash_original_method = "93FD4CBDA1682EAF0E9F2535BF397F65", hash_generated_method = "451996BF97545F96A4EEF3FFA82A5164")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.024 -0400", hash_original_method = "6C90B1571D2A36769CB59FB958C842F7", hash_generated_method = "BFF84763B105CAF23DC060A49B801701")
    public void putIntegerArrayList(String key, ArrayList<Integer> value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.024 -0400", hash_original_method = "ABD9DF23A5A8A0A83F11C474E2CAFB17", hash_generated_method = "37F9146356DBDB6648C38BEAC5313EE3")
    public void putStringArrayList(String key, ArrayList<String> value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.024 -0400", hash_original_method = "C0F2E9DF48888A828D6640DBBB8ADDE5", hash_generated_method = "6C01F67F412405F7DDDFCAEE4EFB7307")
    public void putCharSequenceArrayList(String key, ArrayList<CharSequence> value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.024 -0400", hash_original_method = "C647C81034119067E2383CA02CF65D5F", hash_generated_method = "2A4FB1229722946DE91D4EF0E38C280D")
    public void putSerializable(String key, Serializable value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.025 -0400", hash_original_method = "8E721A4E4DD3EA40820BFACA50BE3D1C", hash_generated_method = "ACACC06951724C44CEB31C2C666267E0")
    public void putBooleanArray(String key, boolean[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.025 -0400", hash_original_method = "1C56E40FECAB1AC7C31C1D64DCBF74F0", hash_generated_method = "5213B1E070335D9401528254C481E52C")
    public void putByteArray(String key, byte[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.026 -0400", hash_original_method = "2FF709A9E88600F14AEB34FA372FB7A3", hash_generated_method = "3104E0304351AB9D6E24A13D4518EEE0")
    public void putShortArray(String key, short[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.026 -0400", hash_original_method = "5BBE3077A529F887080D848A31F1E40F", hash_generated_method = "20FA95EC5112A909F98F512F04084DA0")
    public void putCharArray(String key, char[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.027 -0400", hash_original_method = "6E03156089AB80D54004D251F8CBA9A8", hash_generated_method = "AA0D743CF2BF08A40853D73E8355A710")
    public void putIntArray(String key, int[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.027 -0400", hash_original_method = "749D6A41C446C63F668941511653896B", hash_generated_method = "6F5922EC0EE0EA20F9531881ECEA0CEC")
    public void putLongArray(String key, long[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.028 -0400", hash_original_method = "6C49285A06086C4B176330EBC83C2D3B", hash_generated_method = "33F0CA57AA79BA462FC96478C4B6BBF1")
    public void putFloatArray(String key, float[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.028 -0400", hash_original_method = "BF0DED73B6BC272CA81A76D665AF3892", hash_generated_method = "B5D1C3A1B8E6873420787987F25DD229")
    public void putDoubleArray(String key, double[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.028 -0400", hash_original_method = "3F318C6E0F37B53192FF4A33987FF921", hash_generated_method = "1AC9029516C13EAFD5FB46257A07E20E")
    public void putStringArray(String key, String[] value) {
        addTaint(value[0].getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.029 -0400", hash_original_method = "D442CACA5F4C37E249E32A5FC3EA1B00", hash_generated_method = "908F70222D570FC2AD602F222D7078F4")
    public void putCharSequenceArray(String key, CharSequence[] value) {
        addTaint(value[0].getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.029 -0400", hash_original_method = "8FC0D5E8787A84A268AF6F8743FC18A2", hash_generated_method = "F313ED86E5BFEA7548458BE72E8636BD")
    public void putBundle(String key, Bundle value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.029 -0400", hash_original_method = "0DA9D5A0C7EE7D2AFD4BCC53AD3802F3", hash_generated_method = "1B458E4D89C58743C30A00821425F3A4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.030 -0400", hash_original_method = "44491868325766EC5AED04910C3A4D05", hash_generated_method = "E05A4C27053B53EABB7DDF5A64A8403B")
    public boolean getBoolean(String key) {
        addTaint(key.getTaint());
        unparcel();
        boolean var28350F5318FFB4968F4B0B8FBE8208DE_1231671814 = (getBoolean(key, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1854291635 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1854291635;
        // ---------- Original Method ----------
        //unparcel();
        //return getBoolean(key, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.030 -0400", hash_original_method = "017EA18B11E7843C44A73EB9482CE841", hash_generated_method = "01C88019C3CC5BB108D962E4B5A39588")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.030 -0400", hash_original_method = "AA5C4C6D2863DB47E466486DB4471393", hash_generated_method = "0FAD8CB279163B0AEAFBED03688B0061")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.031 -0400", hash_original_method = "62E0EA051DB8CF7BEF8CA2ACB88171F1", hash_generated_method = "00518BE5399398EBF397A6C5037C926D")
    public boolean getBoolean(String key, boolean defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            boolean var16830A58E1E33A4163524366BA7B701B_40776357 = (defaultValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842285332 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_842285332;
        } //End block
        try 
        {
            boolean varC0A59981B6A9A74E185A6995D9EB5B72_513373595 = ((Boolean) o);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1613165869 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1613165869;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Boolean", defaultValue, e);
            boolean var16830A58E1E33A4163524366BA7B701B_1189017570 = (defaultValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1452249641 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1452249641;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.031 -0400", hash_original_method = "E9711B4A318F78DD358F0F07FAB02724", hash_generated_method = "350BF90E6332CB89EE70434633C4C9D8")
    public byte getByte(String key) {
        addTaint(key.getTaint());
        unparcel();
        byte var5B0A48E0E31913CC901DB451A84568F5_1449543668 = (getByte(key, (byte) 0));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_657705624 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_657705624;
        // ---------- Original Method ----------
        //unparcel();
        //return getByte(key, (byte) 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.032 -0400", hash_original_method = "44660F005C21F1E59A8F3EDCC4F5A0ED", hash_generated_method = "48F442BD2EE2386789E84DF38EE32904")
    public Byte getByte(String key, byte defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
Byte var6042003835E71BD302E1524BA5D2EC10_1478728693 =             defaultValue;
            var6042003835E71BD302E1524BA5D2EC10_1478728693.addTaint(taint);
            return var6042003835E71BD302E1524BA5D2EC10_1478728693;
        } //End block
        try 
        {
Byte varC54AA9AB5858E046700E70C354EEF0AA_601033090 =             (Byte) o;
            varC54AA9AB5858E046700E70C354EEF0AA_601033090.addTaint(taint);
            return varC54AA9AB5858E046700E70C354EEF0AA_601033090;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Byte", defaultValue, e);
Byte var6042003835E71BD302E1524BA5D2EC10_443864096 =             defaultValue;
            var6042003835E71BD302E1524BA5D2EC10_443864096.addTaint(taint);
            return var6042003835E71BD302E1524BA5D2EC10_443864096;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.032 -0400", hash_original_method = "82E77139364787BB6587747BA780C45B", hash_generated_method = "E99E12EA38CED37543EF1F02A08D980B")
    public char getChar(String key) {
        addTaint(key.getTaint());
        unparcel();
        char var73806458D5069BFA70A3B5BD5CCA2A2F_326701486 = (getChar(key, (char) 0));
                char varA87DEB01C5F539E6BDA34829C8EF2368_745197767 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_745197767;
        // ---------- Original Method ----------
        //unparcel();
        //return getChar(key, (char) 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.032 -0400", hash_original_method = "1B86701C5E776F178851B3C57F1F092F", hash_generated_method = "485D62A21010AEF781096AE227CDFC60")
    public char getChar(String key, char defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            char var16830A58E1E33A4163524366BA7B701B_1404808391 = (defaultValue);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1046572733 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1046572733;
        } //End block
        try 
        {
            char var37564EA23825AA037265BAD3230BA4E6_1547141180 = ((Character) o);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_130034165 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_130034165;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Character", defaultValue, e);
            char var16830A58E1E33A4163524366BA7B701B_331840767 = (defaultValue);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1462481335 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1462481335;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.033 -0400", hash_original_method = "949AF94B781EE8B084883F15F1BA2BF2", hash_generated_method = "8CF78F2D035ADDA4F604DB1CDABF8025")
    public short getShort(String key) {
        addTaint(key.getTaint());
        unparcel();
        short varF65C145A4B6788A86B59A1D71FA2611A_1250386293 = (getShort(key, (short) 0));
                short var4F09DAA9D95BCB166A302407A0E0BABE_158201548 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_158201548;
        // ---------- Original Method ----------
        //unparcel();
        //return getShort(key, (short) 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.033 -0400", hash_original_method = "CB97516320C4B19AFFFFC9855DAD2391", hash_generated_method = "2C444B8CFC768A13DB7E00DDB4E3C466")
    public short getShort(String key, short defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            short var16830A58E1E33A4163524366BA7B701B_1708555534 = (defaultValue);
                        short var4F09DAA9D95BCB166A302407A0E0BABE_441023457 = getTaintShort();
            return var4F09DAA9D95BCB166A302407A0E0BABE_441023457;
        } //End block
        try 
        {
            short var1E09BB19CC3789BCDC69F4BC5428A6ED_9898555 = ((Short) o);
                        short var4F09DAA9D95BCB166A302407A0E0BABE_648024550 = getTaintShort();
            return var4F09DAA9D95BCB166A302407A0E0BABE_648024550;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Short", defaultValue, e);
            short var16830A58E1E33A4163524366BA7B701B_1970095148 = (defaultValue);
                        short var4F09DAA9D95BCB166A302407A0E0BABE_849362214 = getTaintShort();
            return var4F09DAA9D95BCB166A302407A0E0BABE_849362214;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.034 -0400", hash_original_method = "E147114FE6EABC6FAB98EAC3907FD421", hash_generated_method = "0B1BFD2BAFB8AFE4833EF1AD84F00AD8")
    public int getInt(String key) {
        addTaint(key.getTaint());
        unparcel();
        int var320E08F6784C27152A618018E9775889_754231660 = (getInt(key, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422479194 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422479194;
        // ---------- Original Method ----------
        //unparcel();
        //return getInt(key, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.034 -0400", hash_original_method = "83073F806AC00C1E2EC4E710A5472BFA", hash_generated_method = "534D2E51DC32DF4F904FAA8FF8329162")
    public int getInt(String key, int defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            int var16830A58E1E33A4163524366BA7B701B_1399452580 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1419652583 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1419652583;
        } //End block
        try 
        {
            int var26AB24744252AEB94A58D664AB3E9D05_1415841150 = ((Integer) o);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_903549753 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_903549753;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Integer", defaultValue, e);
            int var16830A58E1E33A4163524366BA7B701B_1855143804 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1112829866 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1112829866;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.035 -0400", hash_original_method = "0CFFDE7713416A17E206C69E138AC0FF", hash_generated_method = "F44E48827774E71E5AA371588656E349")
    public long getLong(String key) {
        addTaint(key.getTaint());
        unparcel();
        long var0FDBB13DE0DC3D40CB711364CF60C85E_1553884022 = (getLong(key, 0L));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_498635451 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_498635451;
        // ---------- Original Method ----------
        //unparcel();
        //return getLong(key, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.035 -0400", hash_original_method = "84BBB1371E3F4460B78F31822950EAAA", hash_generated_method = "824D168A9BC4C291141871187DFA5305")
    public long getLong(String key, long defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            long var16830A58E1E33A4163524366BA7B701B_785564223 = (defaultValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_652595814 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_652595814;
        } //End block
        try 
        {
            long varB5E7A03E9D897C58684C61698AA7DC1A_716406460 = ((Long) o);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_809060480 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_809060480;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Long", defaultValue, e);
            long var16830A58E1E33A4163524366BA7B701B_1903055898 = (defaultValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1011503225 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1011503225;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.035 -0400", hash_original_method = "0D69D7EB25C8E886B27D28B7A30E217C", hash_generated_method = "FF837B2D2A406E0EE0737A5E4AF81EC2")
    public float getFloat(String key) {
        addTaint(key.getTaint());
        unparcel();
        float varBF23D61A5DA1AFA2DE55AB53E87ED61D_1721428198 = (getFloat(key, 0.0f));
                float var546ADE640B6EDFBC8A086EF31347E768_1250827947 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1250827947;
        // ---------- Original Method ----------
        //unparcel();
        //return getFloat(key, 0.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.036 -0400", hash_original_method = "8162EC4F2AE30557D489C5C6263EB256", hash_generated_method = "7DFF36B2A8CA9D086065814A6170C5EF")
    public float getFloat(String key, float defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            float var16830A58E1E33A4163524366BA7B701B_364388166 = (defaultValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_825074930 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_825074930;
        } //End block
        try 
        {
            float var8331AB1421C1C7163CDC80514402CB41_1224187893 = ((Float) o);
                        float var546ADE640B6EDFBC8A086EF31347E768_1648401807 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1648401807;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Float", defaultValue, e);
            float var16830A58E1E33A4163524366BA7B701B_1130413569 = (defaultValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_217414725 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_217414725;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.036 -0400", hash_original_method = "F5086ED2941BC7C3CB9930D22842FA44", hash_generated_method = "3ED3895AA2AC49405DBB5C64BBFA28B6")
    public double getDouble(String key) {
        addTaint(key.getTaint());
        unparcel();
        double var0199B64F0100C891378130CE2B2D301A_723358458 = (getDouble(key, 0.0));
                double varE8CD7DA078A86726031AD64F35F5A6C0_323141321 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_323141321;
        // ---------- Original Method ----------
        //unparcel();
        //return getDouble(key, 0.0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.037 -0400", hash_original_method = "172C416958EF64BBE0F98CDA39B416EB", hash_generated_method = "E6F0803E0E506E51E638ECA7311B68D1")
    public double getDouble(String key, double defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            double var16830A58E1E33A4163524366BA7B701B_441658909 = (defaultValue);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1507081629 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1507081629;
        } //End block
        try 
        {
            double var4A68A9E2AB417E2A6A41A28F465C1612_137261577 = ((Double) o);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_2020969191 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_2020969191;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Double", defaultValue, e);
            double var16830A58E1E33A4163524366BA7B701B_1707989209 = (defaultValue);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1410454319 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1410454319;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.037 -0400", hash_original_method = "51BC83F6E10D252B7C417A14343A53BE", hash_generated_method = "B5DC804E04D9A1AF1E03CB87FF4BD6FB")
    public String getString(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
String var540C13E9E156B687226421B24F2DF178_489473938 =             null;
            var540C13E9E156B687226421B24F2DF178_489473938.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_489473938;
        } //End block
        try 
        {
String var05F8BA7898C830EEFB724B7656469F9E_1743216635 =             (String) o;
            var05F8BA7898C830EEFB724B7656469F9E_1743216635.addTaint(taint);
            return var05F8BA7898C830EEFB724B7656469F9E_1743216635;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "String", e);
String var540C13E9E156B687226421B24F2DF178_1123711738 =             null;
            var540C13E9E156B687226421B24F2DF178_1123711738.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1123711738;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.038 -0400", hash_original_method = "BC80281EBAB10986EFB226B5D89A6368", hash_generated_method = "C3E0EB32AE40738EEBB37278DB628DB5")
    public String getString(String key, String defaultValue) {
        addTaint(defaultValue.getTaint());
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
String var6042003835E71BD302E1524BA5D2EC10_830889366 =             defaultValue;
            var6042003835E71BD302E1524BA5D2EC10_830889366.addTaint(taint);
            return var6042003835E71BD302E1524BA5D2EC10_830889366;
        } //End block
        try 
        {
String var05F8BA7898C830EEFB724B7656469F9E_1976470052 =             (String) o;
            var05F8BA7898C830EEFB724B7656469F9E_1976470052.addTaint(taint);
            return var05F8BA7898C830EEFB724B7656469F9E_1976470052;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "String", e);
String var6042003835E71BD302E1524BA5D2EC10_854540756 =             defaultValue;
            var6042003835E71BD302E1524BA5D2EC10_854540756.addTaint(taint);
            return var6042003835E71BD302E1524BA5D2EC10_854540756;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.038 -0400", hash_original_method = "4D51A99620432005EDE9794C44D49E24", hash_generated_method = "8F39E81FD0674175093192C18C612B0D")
    public CharSequence getCharSequence(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
CharSequence var540C13E9E156B687226421B24F2DF178_829456570 =             null;
            var540C13E9E156B687226421B24F2DF178_829456570.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_829456570;
        } //End block
        try 
        {
CharSequence var222AA52E30E95872ADF5687FA74CE561_1814715437 =             (CharSequence) o;
            var222AA52E30E95872ADF5687FA74CE561_1814715437.addTaint(taint);
            return var222AA52E30E95872ADF5687FA74CE561_1814715437;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "CharSequence", e);
CharSequence var540C13E9E156B687226421B24F2DF178_254931142 =             null;
            var540C13E9E156B687226421B24F2DF178_254931142.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_254931142;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.039 -0400", hash_original_method = "C5E593A01F019636F8A087C171F20745", hash_generated_method = "FA171C33CC3659DB8DB7AFAFE3B6B535")
    public CharSequence getCharSequence(String key, CharSequence defaultValue) {
        addTaint(defaultValue.getTaint());
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
CharSequence var6042003835E71BD302E1524BA5D2EC10_1773409942 =             defaultValue;
            var6042003835E71BD302E1524BA5D2EC10_1773409942.addTaint(taint);
            return var6042003835E71BD302E1524BA5D2EC10_1773409942;
        } //End block
        try 
        {
CharSequence var222AA52E30E95872ADF5687FA74CE561_1988421081 =             (CharSequence) o;
            var222AA52E30E95872ADF5687FA74CE561_1988421081.addTaint(taint);
            return var222AA52E30E95872ADF5687FA74CE561_1988421081;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "CharSequence", e);
CharSequence var6042003835E71BD302E1524BA5D2EC10_568919058 =             defaultValue;
            var6042003835E71BD302E1524BA5D2EC10_568919058.addTaint(taint);
            return var6042003835E71BD302E1524BA5D2EC10_568919058;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.039 -0400", hash_original_method = "7BDB21170493B124DD321ED35C766BAB", hash_generated_method = "F45125CAB99041314564A764C1732987")
    public Bundle getBundle(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
Bundle var540C13E9E156B687226421B24F2DF178_609929864 =             null;
            var540C13E9E156B687226421B24F2DF178_609929864.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_609929864;
        } //End block
        try 
        {
Bundle var45D34033B5203615BB9EF66A070A8AAD_243664719 =             (Bundle) o;
            var45D34033B5203615BB9EF66A070A8AAD_243664719.addTaint(taint);
            return var45D34033B5203615BB9EF66A070A8AAD_243664719;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Bundle", e);
Bundle var540C13E9E156B687226421B24F2DF178_1644520589 =             null;
            var540C13E9E156B687226421B24F2DF178_1644520589.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1644520589;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.040 -0400", hash_original_method = "3B646958426B4FA703D61CD64DB4127C", hash_generated_method = "21960DFCAD61858391A44AF7A7E7F50F")
    public <T extends Parcelable> T getParcelable(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
T var540C13E9E156B687226421B24F2DF178_1346153340 =             null;
            var540C13E9E156B687226421B24F2DF178_1346153340.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1346153340;
        } //End block
        try 
        {
T varDD72649790B0E769482C6AFD3C9BD666_1620837411 =             (T) o;
            varDD72649790B0E769482C6AFD3C9BD666_1620837411.addTaint(taint);
            return varDD72649790B0E769482C6AFD3C9BD666_1620837411;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Parcelable", e);
T var540C13E9E156B687226421B24F2DF178_743087198 =             null;
            var540C13E9E156B687226421B24F2DF178_743087198.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_743087198;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.040 -0400", hash_original_method = "ACB5B2AD81C8600B2F6954C0DE15936B", hash_generated_method = "C8CFBBEE0B396C0DA9D2BBEA05700444")
    public Parcelable[] getParcelableArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
Parcelable[] var540C13E9E156B687226421B24F2DF178_1893913915 =             null;
            var540C13E9E156B687226421B24F2DF178_1893913915.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1893913915;
        } //End block
        try 
        {
Parcelable[] var0A41EE4FAE6003B4C09B9A204979D444_978796082 =             (Parcelable[]) o;
            var0A41EE4FAE6003B4C09B9A204979D444_978796082.addTaint(taint);
            return var0A41EE4FAE6003B4C09B9A204979D444_978796082;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Parcelable[]", e);
Parcelable[] var540C13E9E156B687226421B24F2DF178_1763881517 =             null;
            var540C13E9E156B687226421B24F2DF178_1763881517.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1763881517;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.040 -0400", hash_original_method = "4066E862ACF29CBEB786556AAFBFC58D", hash_generated_method = "EE1A237A6B56AFCC148A07C8A4882C41")
    public <T extends Parcelable> ArrayList<T> getParcelableArrayList(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
ArrayList<T> var540C13E9E156B687226421B24F2DF178_1331936274 =             null;
            var540C13E9E156B687226421B24F2DF178_1331936274.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1331936274;
        } //End block
        try 
        {
ArrayList<T> var8C4736B669D2FF87EF2D545A6CBB1081_1390373537 =             (ArrayList<T>) o;
            var8C4736B669D2FF87EF2D545A6CBB1081_1390373537.addTaint(taint);
            return var8C4736B669D2FF87EF2D545A6CBB1081_1390373537;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList", e);
ArrayList<T> var540C13E9E156B687226421B24F2DF178_1679513307 =             null;
            var540C13E9E156B687226421B24F2DF178_1679513307.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1679513307;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.041 -0400", hash_original_method = "F3D4EB475C3465E3892E6091F83F5D92", hash_generated_method = "AF93E1059A215342BE6904589C3C981C")
    public <T extends Parcelable> SparseArray<T> getSparseParcelableArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
SparseArray<T> var540C13E9E156B687226421B24F2DF178_551138713 =             null;
            var540C13E9E156B687226421B24F2DF178_551138713.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_551138713;
        } //End block
        try 
        {
SparseArray<T> varDF1763F4CB2B8A56FADAF6645F7D7547_1169518481 =             (SparseArray<T>) o;
            varDF1763F4CB2B8A56FADAF6645F7D7547_1169518481.addTaint(taint);
            return varDF1763F4CB2B8A56FADAF6645F7D7547_1169518481;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "SparseArray", e);
SparseArray<T> var540C13E9E156B687226421B24F2DF178_1090190139 =             null;
            var540C13E9E156B687226421B24F2DF178_1090190139.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1090190139;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.042 -0400", hash_original_method = "3E1FB271E8FDF7CD375ECA97D496DB8C", hash_generated_method = "DD06F3E516079CDC66129996CE373786")
    public Serializable getSerializable(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
Serializable var540C13E9E156B687226421B24F2DF178_2021904160 =             null;
            var540C13E9E156B687226421B24F2DF178_2021904160.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2021904160;
        } //End block
        try 
        {
Serializable var7B8912D0D65C721E62169791E036D2E4_394353720 =             (Serializable) o;
            var7B8912D0D65C721E62169791E036D2E4_394353720.addTaint(taint);
            return var7B8912D0D65C721E62169791E036D2E4_394353720;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Serializable", e);
Serializable var540C13E9E156B687226421B24F2DF178_699887110 =             null;
            var540C13E9E156B687226421B24F2DF178_699887110.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_699887110;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.042 -0400", hash_original_method = "129B869D98875CE72FDC17E4CC2A1579", hash_generated_method = "D63E48894C7234A5DD07D6379562AA56")
    public ArrayList<Integer> getIntegerArrayList(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
ArrayList<Integer> var540C13E9E156B687226421B24F2DF178_1825982113 =             null;
            var540C13E9E156B687226421B24F2DF178_1825982113.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1825982113;
        } //End block
        try 
        {
ArrayList<Integer> varB8F385EFF336E304845C55B19DEFED99_1131465778 =             (ArrayList<Integer>) o;
            varB8F385EFF336E304845C55B19DEFED99_1131465778.addTaint(taint);
            return varB8F385EFF336E304845C55B19DEFED99_1131465778;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList<Integer>", e);
ArrayList<Integer> var540C13E9E156B687226421B24F2DF178_1791718544 =             null;
            var540C13E9E156B687226421B24F2DF178_1791718544.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1791718544;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.043 -0400", hash_original_method = "2869BDF5623DD5162F6A69DFD2D1F8AB", hash_generated_method = "971D51AEC651ACE3A2ADC150836BC075")
    public ArrayList<String> getStringArrayList(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
ArrayList<String> var540C13E9E156B687226421B24F2DF178_675728846 =             null;
            var540C13E9E156B687226421B24F2DF178_675728846.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_675728846;
        } //End block
        try 
        {
ArrayList<String> var6CB978612A32DB65E9747B2CE440DBD9_2060723573 =             (ArrayList<String>) o;
            var6CB978612A32DB65E9747B2CE440DBD9_2060723573.addTaint(taint);
            return var6CB978612A32DB65E9747B2CE440DBD9_2060723573;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList<String>", e);
ArrayList<String> var540C13E9E156B687226421B24F2DF178_1017664559 =             null;
            var540C13E9E156B687226421B24F2DF178_1017664559.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1017664559;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.043 -0400", hash_original_method = "9A13BDFEA4BB8512D10DFA31FFDE883A", hash_generated_method = "37BC2E2BB73B87E386AE39EDF4C9AECD")
    public ArrayList<CharSequence> getCharSequenceArrayList(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
ArrayList<CharSequence> var540C13E9E156B687226421B24F2DF178_926495907 =             null;
            var540C13E9E156B687226421B24F2DF178_926495907.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_926495907;
        } //End block
        try 
        {
ArrayList<CharSequence> var1B0D8FC24E767E0352471E3AC3D561A2_636390539 =             (ArrayList<CharSequence>) o;
            var1B0D8FC24E767E0352471E3AC3D561A2_636390539.addTaint(taint);
            return var1B0D8FC24E767E0352471E3AC3D561A2_636390539;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList<CharSequence>", e);
ArrayList<CharSequence> var540C13E9E156B687226421B24F2DF178_869929318 =             null;
            var540C13E9E156B687226421B24F2DF178_869929318.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_869929318;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.044 -0400", hash_original_method = "2242EDC01DC8898E91E207F436901294", hash_generated_method = "92E1C8625EEA79999E85418757AB945D")
    public boolean[] getBooleanArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            boolean[] var37A6259CC0C1DAE299A7866489DFF0BD_8504792 = (null);
                        boolean[] var503EB2F420079C4024483971CE5EDEA8_276094497 = {getTaintBoolean()};
            return var503EB2F420079C4024483971CE5EDEA8_276094497;
        } //End block
        try 
        {
            boolean[] varE2BA3674FD9266CFB01DBFA76FCA616D_14924953 = ((boolean[]) o);
                        boolean[] var503EB2F420079C4024483971CE5EDEA8_1722693493 = {getTaintBoolean()};
            return var503EB2F420079C4024483971CE5EDEA8_1722693493;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "byte[]", e);
            boolean[] var37A6259CC0C1DAE299A7866489DFF0BD_94976942 = (null);
                        boolean[] var503EB2F420079C4024483971CE5EDEA8_2086868436 = {getTaintBoolean()};
            return var503EB2F420079C4024483971CE5EDEA8_2086868436;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.045 -0400", hash_original_method = "61BA553FC99180BEC5D34878EFD2124D", hash_generated_method = "70D7FBB71E00D7CA80BC5F7C378A1007")
    public byte[] getByteArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_198405782 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1003339148 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1003339148;
        } //End block
        try 
        {
            byte[] var9FE822C0B0667ABCB28F8576DB481C08_2133610272 = ((byte[]) o);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2029824499 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_2029824499;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "byte[]", e);
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1284005412 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1796186578 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1796186578;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.045 -0400", hash_original_method = "7BB50DA07B268F9685287E0D939131D4", hash_generated_method = "BC38AD5629A50A2672F74A3C4523939A")
    public short[] getShortArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            short[] var37A6259CC0C1DAE299A7866489DFF0BD_949286425 = (null);
                        short[] var48EE7E2DDF8A83602BC526873BD0F875_36290117 = {getTaintShort()};
            return var48EE7E2DDF8A83602BC526873BD0F875_36290117;
        } //End block
        try 
        {
            short[] var12B9A95732292904819C1404E2CBA6AB_1992619807 = ((short[]) o);
                        short[] var48EE7E2DDF8A83602BC526873BD0F875_1542301315 = {getTaintShort()};
            return var48EE7E2DDF8A83602BC526873BD0F875_1542301315;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "short[]", e);
            short[] var37A6259CC0C1DAE299A7866489DFF0BD_805521727 = (null);
                        short[] var48EE7E2DDF8A83602BC526873BD0F875_625567426 = {getTaintShort()};
            return var48EE7E2DDF8A83602BC526873BD0F875_625567426;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.046 -0400", hash_original_method = "E77DD9D06089068562F2943DA73C8461", hash_generated_method = "82777459F0D58FD1E125A83B796A19EF")
    public char[] getCharArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            char[] var37A6259CC0C1DAE299A7866489DFF0BD_1139643295 = (null);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1933178420 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_1933178420;
        } //End block
        try 
        {
            char[] var84081F0F01B25F1ACF8564E92E3D7FB9_318450718 = ((char[]) o);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_907978363 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_907978363;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "char[]", e);
            char[] var37A6259CC0C1DAE299A7866489DFF0BD_1505496670 = (null);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_478820315 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_478820315;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.046 -0400", hash_original_method = "85622F3A5EF64119863AB7B7CCBF9703", hash_generated_method = "C033808E33D55A578CCF2BFCDE289FC4")
    public int[] getIntArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            int[] var37A6259CC0C1DAE299A7866489DFF0BD_716505481 = (null);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_15098609 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_15098609;
        } //End block
        try 
        {
            int[] var1C8435EA995977647E605AA4DB8D057D_1232292953 = ((int[]) o);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_201493031 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_201493031;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "int[]", e);
            int[] var37A6259CC0C1DAE299A7866489DFF0BD_375524190 = (null);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_150024877 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_150024877;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.047 -0400", hash_original_method = "27B2CD54F5F69E8E74D59A821000C81A", hash_generated_method = "D7C51643386DC52AC68EBFCA6695CF22")
    public long[] getLongArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            long[] var37A6259CC0C1DAE299A7866489DFF0BD_2053714164 = (null);
                        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1738025496 = {getTaintLong()};
            return var3908C7C3AF5171CEE1F112DAE77A5C4D_1738025496;
        } //End block
        try 
        {
            long[] var324FBE7B770A1FB7F944234CDD8D8302_1273656847 = ((long[]) o);
                        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1522685485 = {getTaintLong()};
            return var3908C7C3AF5171CEE1F112DAE77A5C4D_1522685485;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "long[]", e);
            long[] var37A6259CC0C1DAE299A7866489DFF0BD_66978856 = (null);
                        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_150990867 = {getTaintLong()};
            return var3908C7C3AF5171CEE1F112DAE77A5C4D_150990867;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.047 -0400", hash_original_method = "CF7D6838E0F23E6456879FF35A2AC714", hash_generated_method = "72FAECB756A45EB399323F3B9C9F98D6")
    public float[] getFloatArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            float[] var37A6259CC0C1DAE299A7866489DFF0BD_145076060 = (null);
                        float[] varB2C245003BAB9224CFB496218F7DAFE0_959540104 = {getTaintFloat()};
            return varB2C245003BAB9224CFB496218F7DAFE0_959540104;
        } //End block
        try 
        {
            float[] varB6BC16331AA469D6884123613ABE79E7_964115496 = ((float[]) o);
                        float[] varB2C245003BAB9224CFB496218F7DAFE0_1276993177 = {getTaintFloat()};
            return varB2C245003BAB9224CFB496218F7DAFE0_1276993177;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "float[]", e);
            float[] var37A6259CC0C1DAE299A7866489DFF0BD_1581291425 = (null);
                        float[] varB2C245003BAB9224CFB496218F7DAFE0_481409716 = {getTaintFloat()};
            return varB2C245003BAB9224CFB496218F7DAFE0_481409716;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.048 -0400", hash_original_method = "3231DDBB4D17868FEAA7FF4365CACCDA", hash_generated_method = "F7B6C26743C26BC29622F85718E56EF3")
    public double[] getDoubleArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
            double[] var37A6259CC0C1DAE299A7866489DFF0BD_1383634774 = (null);
                        double[] var74D44D7D9EE6FE6C3433D694F869E521_409931576 = {getTaintDouble()};
            return var74D44D7D9EE6FE6C3433D694F869E521_409931576;
        } //End block
        try 
        {
            double[] var799D16D1B5D5DF2402D4DA39D4423C0D_1287943835 = ((double[]) o);
                        double[] var74D44D7D9EE6FE6C3433D694F869E521_533079414 = {getTaintDouble()};
            return var74D44D7D9EE6FE6C3433D694F869E521_533079414;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "double[]", e);
            double[] var37A6259CC0C1DAE299A7866489DFF0BD_728973595 = (null);
                        double[] var74D44D7D9EE6FE6C3433D694F869E521_1231002922 = {getTaintDouble()};
            return var74D44D7D9EE6FE6C3433D694F869E521_1231002922;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.049 -0400", hash_original_method = "00D6B9CB5DC261567748885D1CE89780", hash_generated_method = "1D9C7AD3442A095FE1AA90E473BC0225")
    public String[] getStringArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
String[] var540C13E9E156B687226421B24F2DF178_1283806527 =             null;
            var540C13E9E156B687226421B24F2DF178_1283806527.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1283806527;
        } //End block
        try 
        {
String[] var16C153FE5E6565C51E3D998C42B91976_298315060 =             (String[]) o;
            var16C153FE5E6565C51E3D998C42B91976_298315060.addTaint(taint);
            return var16C153FE5E6565C51E3D998C42B91976_298315060;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "String[]", e);
String[] var540C13E9E156B687226421B24F2DF178_205519313 =             null;
            var540C13E9E156B687226421B24F2DF178_205519313.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_205519313;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.049 -0400", hash_original_method = "E55D822FE040164347A1371A3EEFE758", hash_generated_method = "DC1736CD6D5ACD02078637497C98A828")
    public CharSequence[] getCharSequenceArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
CharSequence[] var540C13E9E156B687226421B24F2DF178_1385873679 =             null;
            var540C13E9E156B687226421B24F2DF178_1385873679.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1385873679;
        } //End block
        try 
        {
CharSequence[] varE0F35EE7132543529B2EBACAA10305AF_94707931 =             (CharSequence[]) o;
            varE0F35EE7132543529B2EBACAA10305AF_94707931.addTaint(taint);
            return varE0F35EE7132543529B2EBACAA10305AF_94707931;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "CharSequence[]", e);
CharSequence[] var540C13E9E156B687226421B24F2DF178_1294956282 =             null;
            var540C13E9E156B687226421B24F2DF178_1294956282.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1294956282;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.050 -0400", hash_original_method = "D295BFB1D3C25A7A56AF1D8267856D3B", hash_generated_method = "B696203FCCA801A46186D4947BF86279")
    @Deprecated
    public IBinder getIBinder(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
    if(o == null)        
        {
IBinder var540C13E9E156B687226421B24F2DF178_511520537 =             null;
            var540C13E9E156B687226421B24F2DF178_511520537.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_511520537;
        } //End block
        try 
        {
IBinder varF1CBEA30581462C8D282C5AF2BF1C748_51395476 =             (IBinder) o;
            varF1CBEA30581462C8D282C5AF2BF1C748_51395476.addTaint(taint);
            return varF1CBEA30581462C8D282C5AF2BF1C748_51395476;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "IBinder", e);
IBinder var540C13E9E156B687226421B24F2DF178_1786709062 =             null;
            var540C13E9E156B687226421B24F2DF178_1786709062.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1786709062;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.050 -0400", hash_original_method = "E95F1FE0EF3EE3193ED648BBE2C98991", hash_generated_method = "94233D92BF020564EAB139ED994C99BD")
    public int describeContents() {
        int mask = 0;
    if(hasFileDescriptors())        
        {
            mask |= Parcelable.CONTENTS_FILE_DESCRIPTOR;
        } //End block
        int varF2CE11EBF110993621BEDD8E747D7B1B_1042570824 = (mask);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1279200476 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1279200476;
        // ---------- Original Method ----------
        //int mask = 0;
        //if (hasFileDescriptors()) {
            //mask |= Parcelable.CONTENTS_FILE_DESCRIPTOR;
        //}
        //return mask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.050 -0400", hash_original_method = "90A94F467F11AD2B1AEECA4B5BC07A1D", hash_generated_method = "8B5FF5BA32445196D63B4BEEC0C2DC54")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.051 -0400", hash_original_method = "046D2D4D1B8612C0E98B2174C0C88DC5", hash_generated_method = "70534AC1E76CD01969A2208AAE3C4C8B")
    public void readFromParcel(Parcel parcel) {
        addTaint(parcel.getTaint());
        int length = parcel.readInt();
    if(length < 0)        
        {
            RuntimeException var84B5513F50EA60D710D121E42982F402_1121168155 = new RuntimeException("Bad length in parcel: " + length);
            var84B5513F50EA60D710D121E42982F402_1121168155.addTaint(taint);
            throw var84B5513F50EA60D710D121E42982F402_1121168155;
        } //End block
        readFromParcelInner(parcel, length);
        // ---------- Original Method ----------
        //int length = parcel.readInt();
        //if (length < 0) {
            //throw new RuntimeException("Bad length in parcel: " + length);
        //}
        //readFromParcelInner(parcel, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.052 -0400", hash_original_method = "BA7474E49C1BD74E29BF5B4706535141", hash_generated_method = "3E86D5953AE1E1E145CDC43602BF739E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.052 -0400", hash_original_method = "6D3D0FD7A771D9A5F3ECAE6DEB73615C", hash_generated_method = "64BA3C348EB78D61CF7444EFA066DE20")
    @Override
    public synchronized String toString() {
    if(mParcelledData != null)        
        {
String varFF08288414AE5DAA590BBD75B1F9D1A6_823030535 =             "Bundle[mParcelledData.dataSize=" +
                    mParcelledData.dataSize() + "]";
            varFF08288414AE5DAA590BBD75B1F9D1A6_823030535.addTaint(taint);
            return varFF08288414AE5DAA590BBD75B1F9D1A6_823030535;
        } //End block
String var7912B2DCBC9E314551464676F1365845_110144721 =         "Bundle[" + mMap.toString() + "]";
        var7912B2DCBC9E314551464676F1365845_110144721.addTaint(taint);
        return var7912B2DCBC9E314551464676F1365845_110144721;
        // ---------- Original Method ----------
        //if (mParcelledData != null) {
            //return "Bundle[mParcelledData.dataSize=" +
                    //mParcelledData.dataSize() + "]";
        //}
        //return "Bundle[" + mMap.toString() + "]";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.052 -0400", hash_original_field = "9D5F877D7AA7E8D8702157333DF2C046", hash_generated_field = "B4A59EF1F4C419B90A176C13462BE720")

    private static final String LOG_TAG = "Bundle";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.052 -0400", hash_original_field = "BA2B45BDC11E2A4A6E86AAB2AC693CBB", hash_generated_field = "801351E620DCAB87B984F712F19DA2C3")

    public static final Bundle EMPTY;
    static {
        EMPTY = new Bundle();
        EMPTY.mMap = Collections.unmodifiableMap(new HashMap<String, Object>());
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.052 -0400", hash_original_field = "B4FE070174283716AFC584FD34F1BAE3", hash_generated_field = "C6D8CFB9909EC6A413DB28D9E9FEC6F2")
    public static final Parcelable.Creator<Bundle> CREATOR =
        new Parcelable.Creator<Bundle>() {
        public Bundle createFromParcel(Parcel in) {
            return in.readBundle();
        }

        public Bundle[] newArray(int size) {
            return new Bundle[size];
        }
    };
}

