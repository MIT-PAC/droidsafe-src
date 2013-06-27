package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.408 -0400", hash_original_field = "7D2A9E7103D695106505452E5AB8F67C", hash_generated_field = "F8BD8E8005099844A113591459546070")

    private FragmentManager mFragmentManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.408 -0400", hash_original_field = "F059B80392FC866852597EAF19CC7B60", hash_generated_field = "45681C0640ABED8BB32E7E47A23478AF")

    private FragmentTransaction mCurTransaction = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.408 -0400", hash_original_field = "523EF184A1F0C6BCE0541D0D0C707AFE", hash_generated_field = "CDC8F8852D870F8FEA0C86CD6810CCC2")

    private ArrayList<Fragment.SavedState> mSavedState = new ArrayList<Fragment.SavedState>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.408 -0400", hash_original_field = "43D310D7FF156A0E4034AA33B303A13E", hash_generated_field = "163196A7E9407ED0942AC9B3574F16B2")

    private ArrayList<Fragment> mFragments = new ArrayList<Fragment>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.408 -0400", hash_original_field = "49FB18B1876842494DD756909F545BE4", hash_generated_field = "3FD1F349465E20607A1ACB2506873721")

    private Fragment mCurrentPrimaryItem = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.424 -0400", hash_original_method = "EE48EE9088057B7790D43246967DC373", hash_generated_method = "53CD49E0865EB681A99E124A06DA9CE4")
    public  FragmentStatePagerAdapter(FragmentManager fm) {
        mFragmentManager = fm;
        // ---------- Original Method ----------
        //mFragmentManager = fm;
    }

    
    public abstract Fragment getItem(int position);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.427 -0400", hash_original_method = "40E78EFA38F0994EA71F26DADE781C52", hash_generated_method = "369CD737611E25F82302A46324A3B366")
    @Override
    public void startUpdate(ViewGroup container) {
        addTaint(container.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.429 -0400", hash_original_method = "A9E8B65E23BADC9CC95581215460751D", hash_generated_method = "F5308D518473021011D19AD7990DED5C")
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_960137956 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_449244529 = null; //Variable for return #2
        {
            boolean varB4074D34C1025AA391EBC85C09248B83_362882142 = (mFragments.size() > position);
            {
                Fragment f;
                f = mFragments.get(position);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_960137956 = f;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            mCurTransaction = mFragmentManager.beginTransaction();
        } //End block
        Fragment fragment;
        fragment = getItem(position);
        {
            boolean var4AE0823620EE80F5CD6D886BCFC47C41_985585823 = (mSavedState.size() > position);
            {
                Fragment.SavedState fss;
                fss = mSavedState.get(position);
                {
                    fragment.setInitialSavedState(fss);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var215DA5D801599CA7F5B6FA6DBC68F8A6_223007203 = (mFragments.size() <= position);
            {
                mFragments.add(null);
            } //End block
        } //End collapsed parenthetic
        fragment.setMenuVisibility(false);
        fragment.setUserVisibleHint(false);
        mFragments.set(position, fragment);
        mCurTransaction.add(container.getId(), fragment);
        varB4EAC82CA7396A68D541C85D26508E83_449244529 = fragment;
        addTaint(container.getTaint());
        addTaint(position);
        Object varA7E53CE21691AB073D9660D615818899_417174183; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_417174183 = varB4EAC82CA7396A68D541C85D26508E83_960137956;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_417174183 = varB4EAC82CA7396A68D541C85D26508E83_449244529;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_417174183.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_417174183;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.430 -0400", hash_original_method = "755EB6CA7B109EC556DEC84EC15F7654", hash_generated_method = "D4996E8F04DB20B27F069B128AF06BDB")
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Fragment fragment;
        fragment = (Fragment)object;
        {
            mCurTransaction = mFragmentManager.beginTransaction();
        } //End block
        {
            boolean varC2FAF9BB13565371CBC7E749D60BE815_284489827 = (mSavedState.size() <= position);
            {
                mSavedState.add(null);
            } //End block
        } //End collapsed parenthetic
        mSavedState.set(position, mFragmentManager.saveFragmentInstanceState(fragment));
        mFragments.set(position, null);
        mCurTransaction.remove(fragment);
        addTaint(container.getTaint());
        addTaint(position);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //Fragment fragment = (Fragment)object;
        //if (mCurTransaction == null) {
            //mCurTransaction = mFragmentManager.beginTransaction();
        //}
        //if (DEBUG) Log.v(TAG, "Removing item #" + position + ": f=" + object
                //+ " v=" + ((Fragment)object).getView());
        //while (mSavedState.size() <= position) {
            //mSavedState.add(null);
        //}
        //mSavedState.set(position, mFragmentManager.saveFragmentInstanceState(fragment));
        //mFragments.set(position, null);
        //mCurTransaction.remove(fragment);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.453 -0400", hash_original_method = "C523B4C098494E2FCA3311FDB475454B", hash_generated_method = "44818FB3AD150694500DADC328AABDB4")
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        Fragment fragment;
        fragment = (Fragment)object;
        {
            {
                mCurrentPrimaryItem.setMenuVisibility(false);
                mCurrentPrimaryItem.setUserVisibleHint(false);
            } //End block
            {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            } //End block
            mCurrentPrimaryItem = fragment;
        } //End block
        addTaint(container.getTaint());
        addTaint(position);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //Fragment fragment = (Fragment)object;
        //if (fragment != mCurrentPrimaryItem) {
            //if (mCurrentPrimaryItem != null) {
                //mCurrentPrimaryItem.setMenuVisibility(false);
                //mCurrentPrimaryItem.setUserVisibleHint(false);
            //}
            //if (fragment != null) {
                //fragment.setMenuVisibility(true);
                //fragment.setUserVisibleHint(true);
            //}
            //mCurrentPrimaryItem = fragment;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.454 -0400", hash_original_method = "82B7432FA4441721C4132291867EEFCE", hash_generated_method = "15FE14EC160C5F3BA84D03661684293C")
    @Override
    public void finishUpdate(ViewGroup container) {
        {
            mCurTransaction.commitAllowingStateLoss();
            mCurTransaction = null;
            mFragmentManager.executePendingTransactions();
        } //End block
        addTaint(container.getTaint());
        // ---------- Original Method ----------
        //if (mCurTransaction != null) {
            //mCurTransaction.commitAllowingStateLoss();
            //mCurTransaction = null;
            //mFragmentManager.executePendingTransactions();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.454 -0400", hash_original_method = "326A6E6DDD52502D387B1D32B8739E1F", hash_generated_method = "827CC0279CEAC441E0F50B3942EE0D9A")
    @Override
    public boolean isViewFromObject(View view, Object object) {
        boolean var779CA2DF34F5491A810C0B90DD7A88C3_2109218663 = (((Fragment)object).getView() == view);
        addTaint(view.getTaint());
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1344102117 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1344102117;
        // ---------- Original Method ----------
        //return ((Fragment)object).getView() == view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.456 -0400", hash_original_method = "B988CD8342A7322440FF2844127CCD46", hash_generated_method = "7A4B4183062AAB28F925588BE42AF89C")
    @Override
    public Parcelable saveState() {
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_23785325 = null; //Variable for return #1
        Bundle state;
        state = null;
        {
            boolean varA9184B00060830F15C86237890F5EC79_1895025443 = (mSavedState.size() > 0);
            {
                state = new Bundle();
                Fragment.SavedState[] fss;
                fss = new Fragment.SavedState[mSavedState.size()];
                mSavedState.toArray(fss);
                state.putParcelableArray("states", fss);
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            boolean var5F1822902745C364FAFC77FB679FF68F_665683597 = (i<mFragments.size());
            {
                Fragment f;
                f = mFragments.get(i);
                {
                    {
                        state = new Bundle();
                    } //End block
                    String key;
                    key = "f" + i;
                    mFragmentManager.putFragment(state, key, f);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_23785325 = state;
        varB4EAC82CA7396A68D541C85D26508E83_23785325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_23785325;
        // ---------- Original Method ----------
        //Bundle state = null;
        //if (mSavedState.size() > 0) {
            //state = new Bundle();
            //Fragment.SavedState[] fss = new Fragment.SavedState[mSavedState.size()];
            //mSavedState.toArray(fss);
            //state.putParcelableArray("states", fss);
        //}
        //for (int i=0; i<mFragments.size(); i++) {
            //Fragment f = mFragments.get(i);
            //if (f != null) {
                //if (state == null) {
                    //state = new Bundle();
                //}
                //String key = "f" + i;
                //mFragmentManager.putFragment(state, key, f);
            //}
        //}
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.614 -0400", hash_original_method = "25FE30AF757A8A2C6A4CB7F31C78F0A7", hash_generated_method = "47C454177879B01F92288D490E806E7E")
    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        {
            Bundle bundle;
            bundle = (Bundle)state;
            bundle.setClassLoader(loader);
            Parcelable[] fss;
            fss = bundle.getParcelableArray("states");
            mSavedState.clear();
            mFragments.clear();
            {
                {
                    int i;
                    i = 0;
                    {
                        mSavedState.add((Fragment.SavedState)fss[i]);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            Iterable<String> keys;
            keys = bundle.keySet();
            {
                Iterator<String> varD994FB31D100DF03FACE33D44B4081C0_13642585 = (keys).iterator();
                varD994FB31D100DF03FACE33D44B4081C0_13642585.hasNext();
                String key = varD994FB31D100DF03FACE33D44B4081C0_13642585.next();
                {
                    {
                        boolean var438EA0C07332A92EACC3F9E3A9BA678E_1028640697 = (key.startsWith("f"));
                        {
                            int index;
                            index = Integer.parseInt(key.substring(1));
                            Fragment f;
                            f = mFragmentManager.getFragment(bundle, key);
                            {
                                {
                                    boolean var7DCBE80AC930E07F9E5F4B6571152656_1570056970 = (mFragments.size() <= index);
                                    {
                                        mFragments.add(null);
                                    } //End block
                                } //End collapsed parenthetic
                                f.setMenuVisibility(false);
                                mFragments.set(index, f);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(state.getTaint());
        addTaint(loader.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.628 -0400", hash_original_field = "71E918188668590487FFB691ECDE7B30", hash_generated_field = "A563E66FBDDA116CACD9EA37D54AC88C")

    private static String TAG = "FragmentStatePagerAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.629 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
}

