package android.support.v4.app;


import java.util.ArrayList;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;


public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.994 -0400", hash_original_field = "7D2A9E7103D695106505452E5AB8F67C", hash_generated_field = "F8BD8E8005099844A113591459546070")

    private FragmentManager mFragmentManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.994 -0400", hash_original_field = "F059B80392FC866852597EAF19CC7B60", hash_generated_field = "45681C0640ABED8BB32E7E47A23478AF")

    private FragmentTransaction mCurTransaction = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.994 -0400", hash_original_field = "523EF184A1F0C6BCE0541D0D0C707AFE", hash_generated_field = "CDC8F8852D870F8FEA0C86CD6810CCC2")

    private ArrayList<Fragment.SavedState> mSavedState = new ArrayList<Fragment.SavedState>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.994 -0400", hash_original_field = "43D310D7FF156A0E4034AA33B303A13E", hash_generated_field = "163196A7E9407ED0942AC9B3574F16B2")

    private ArrayList<Fragment> mFragments = new ArrayList<Fragment>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.994 -0400", hash_original_field = "49FB18B1876842494DD756909F545BE4", hash_generated_field = "3FD1F349465E20607A1ACB2506873721")

    private Fragment mCurrentPrimaryItem = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.994 -0400", hash_original_method = "EE48EE9088057B7790D43246967DC373", hash_generated_method = "53CD49E0865EB681A99E124A06DA9CE4")
    public  FragmentStatePagerAdapter(FragmentManager fm) {
        mFragmentManager = fm;
        
        
    }

    
    public abstract Fragment getItem(int position);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.996 -0400", hash_original_method = "40E78EFA38F0994EA71F26DADE781C52", hash_generated_method = "369CD737611E25F82302A46324A3B366")
    @Override
    public void startUpdate(ViewGroup container) {
        addTaint(container.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.997 -0400", hash_original_method = "A9E8B65E23BADC9CC95581215460751D", hash_generated_method = "86271097C2F40011AFDF28EB83C6CE40")
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1747532395 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1036773276 = null; 
        {
            boolean varB4074D34C1025AA391EBC85C09248B83_1650582219 = (mFragments.size() > position);
            {
                Fragment f = mFragments.get(position);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1747532395 = f;
                } 
            } 
        } 
        {
            mCurTransaction = mFragmentManager.beginTransaction();
        } 
        Fragment fragment = getItem(position);
        {
            boolean var4AE0823620EE80F5CD6D886BCFC47C41_187589104 = (mSavedState.size() > position);
            {
                Fragment.SavedState fss = mSavedState.get(position);
                {
                    fragment.setInitialSavedState(fss);
                } 
            } 
        } 
        {
            boolean var215DA5D801599CA7F5B6FA6DBC68F8A6_1977347476 = (mFragments.size() <= position);
            {
                mFragments.add(null);
            } 
        } 
        fragment.setMenuVisibility(false);
        fragment.setUserVisibleHint(false);
        mFragments.set(position, fragment);
        mCurTransaction.add(container.getId(), fragment);
        varB4EAC82CA7396A68D541C85D26508E83_1036773276 = fragment;
        addTaint(container.getTaint());
        addTaint(position);
        Object varA7E53CE21691AB073D9660D615818899_611547595; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_611547595 = varB4EAC82CA7396A68D541C85D26508E83_1747532395;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_611547595 = varB4EAC82CA7396A68D541C85D26508E83_1036773276;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_611547595.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_611547595;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.998 -0400", hash_original_method = "755EB6CA7B109EC556DEC84EC15F7654", hash_generated_method = "269FAD242FBC273D21380D188DBC6D9C")
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Fragment fragment = (Fragment)object;
        {
            mCurTransaction = mFragmentManager.beginTransaction();
        } 
        {
            boolean varC2FAF9BB13565371CBC7E749D60BE815_1409992847 = (mSavedState.size() <= position);
            {
                mSavedState.add(null);
            } 
        } 
        mSavedState.set(position, mFragmentManager.saveFragmentInstanceState(fragment));
        mFragments.set(position, null);
        mCurTransaction.remove(fragment);
        addTaint(container.getTaint());
        addTaint(position);
        addTaint(object.getTaint());
        
        
        
            
        
        
                
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.998 -0400", hash_original_method = "C523B4C098494E2FCA3311FDB475454B", hash_generated_method = "C20525D3EEA39CC49C821323CEC33BAF")
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        Fragment fragment = (Fragment)object;
        {
            {
                mCurrentPrimaryItem.setMenuVisibility(false);
                mCurrentPrimaryItem.setUserVisibleHint(false);
            } 
            {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            } 
            mCurrentPrimaryItem = fragment;
        } 
        addTaint(container.getTaint());
        addTaint(position);
        addTaint(object.getTaint());
        
        
        
            
                
                
            
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.999 -0400", hash_original_method = "82B7432FA4441721C4132291867EEFCE", hash_generated_method = "15FE14EC160C5F3BA84D03661684293C")
    @Override
    public void finishUpdate(ViewGroup container) {
        {
            mCurTransaction.commitAllowingStateLoss();
            mCurTransaction = null;
            mFragmentManager.executePendingTransactions();
        } 
        addTaint(container.getTaint());
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.999 -0400", hash_original_method = "326A6E6DDD52502D387B1D32B8739E1F", hash_generated_method = "1A876384CD8B4FFA6FA638D62A1A938C")
    @Override
    public boolean isViewFromObject(View view, Object object) {
        boolean var779CA2DF34F5491A810C0B90DD7A88C3_894064159 = (((Fragment)object).getView() == view);
        addTaint(view.getTaint());
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1708823762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1708823762;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.000 -0400", hash_original_method = "B988CD8342A7322440FF2844127CCD46", hash_generated_method = "DB8D844D014E580487D9AD2F2895C222")
    @Override
    public Parcelable saveState() {
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_971178879 = null; 
        Bundle state = null;
        {
            boolean varA9184B00060830F15C86237890F5EC79_1069373565 = (mSavedState.size() > 0);
            {
                state = new Bundle();
                Fragment.SavedState[] fss = new Fragment.SavedState[mSavedState.size()];
                mSavedState.toArray(fss);
                state.putParcelableArray("states", fss);
            } 
        } 
        {
            int i = 0;
            boolean var5F1822902745C364FAFC77FB679FF68F_921664459 = (i<mFragments.size());
            {
                Fragment f = mFragments.get(i);
                {
                    {
                        state = new Bundle();
                    } 
                    String key = "f" + i;
                    mFragmentManager.putFragment(state, key, f);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_971178879 = state;
        varB4EAC82CA7396A68D541C85D26508E83_971178879.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_971178879;
        
        
        
            
            
            
            
        
        
            
            
                
                    
                
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.007 -0400", hash_original_method = "25FE30AF757A8A2C6A4CB7F31C78F0A7", hash_generated_method = "92D7B83925FDFAE59099216CA180E2CD")
    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        {
            Bundle bundle = (Bundle)state;
            bundle.setClassLoader(loader);
            Parcelable[] fss = bundle.getParcelableArray("states");
            mSavedState.clear();
            mFragments.clear();
            {
                {
                    int i = 0;
                    {
                        mSavedState.add((Fragment.SavedState)fss[i]);
                    } 
                } 
            } 
            Iterable<String> keys = bundle.keySet();
            {
                String key = keys.iterator().next();
                {
                    {
                        boolean var438EA0C07332A92EACC3F9E3A9BA678E_57809883 = (key.startsWith("f"));
                        {
                            int index = Integer.parseInt(key.substring(1));
                            Fragment f = mFragmentManager.getFragment(bundle, key);
                            {
                                {
                                    boolean var7DCBE80AC930E07F9E5F4B6571152656_2122021522 = (mFragments.size() <= index);
                                    {
                                        mFragments.add(null);
                                    } 
                                } 
                                f.setMenuVisibility(false);
                                mFragments.set(index, f);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(state.getTaint());
        addTaint(loader.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.007 -0400", hash_original_field = "71E918188668590487FFB691ECDE7B30", hash_generated_field = "3D3955276B61BDF25576BE3CF5006FA7")

    private static final String TAG = "FragmentStatePagerAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.007 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
}

