package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListFragment extends Fragment {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.724 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "ED5BAD7C7A1EC83F341419B29A267C9F")

    final private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.105 -0400", hash_original_field = "F487762B42FCD79D908F11802425F9AE", hash_generated_field = "1DE73C7158094283DF2E07B61B66A0F0")

    final private Runnable mRequestFocus = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.105 -0400", hash_original_method = "4F290F2508C3F0B44E09591C5B0749BC", hash_generated_method = "203642A5324F5F18B21A0D020E65FD5C")
        public void run() {
            mList.focusableViewAvailable(mList);
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.106 -0400", hash_original_field = "9B3F30A71979D6623D111E114AFFBE5E", hash_generated_field = "42C04E77E3D60E8D569E30C744D85151")

    final private AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.105 -0400", hash_original_method = "FBAC6E1DF4BED6C0A21E33622DB577EE", hash_generated_method = "D00BEF8ABA88B27607955BB6270FA24E")
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            
            onListItemClick((ListView)parent, v, position, id);
            addTaint(parent.getTaint());
            addTaint(v.getTaint());
            addTaint(position);
            addTaint(id);
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.724 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "CBDD62EF585589E92C0E00AE9F4F22E2")

    ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.724 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "A5B73AC2B922200A8C47FEAA8C3EB07A")

    ListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.724 -0400", hash_original_field = "70C77B82E1F7307619839CA84E110E30", hash_generated_field = "7791203818A2C8C23F9ABF8545C329FB")

    View mEmptyView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.724 -0400", hash_original_field = "55016CBFD3CE49ADBAB505CE2082E915", hash_generated_field = "1BF76B462D7F24436F14F7F745BB541C")

    TextView mStandardEmptyView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.724 -0400", hash_original_field = "56720DB5DBB6738225C3A90D862F1AB2", hash_generated_field = "5A35A3CD88A2CD2FFD5E60C83A9EA805")

    View mProgressContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.724 -0400", hash_original_field = "45A98EEED29C789395ED1681F7616E63", hash_generated_field = "4BEB12F6053492A04536FE88CDB7F3C9")

    View mListContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.724 -0400", hash_original_field = "7AE2AFD490CFC5D0B1BA25431F78642B", hash_generated_field = "D3680587F795E32338C0D453701D98D2")

    CharSequence mEmptyText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.724 -0400", hash_original_field = "EEBC082FD5621811F12260D0FCF8CF84", hash_generated_field = "DED3E45D8C8FC4CDC3B9DE2C2A90BA30")

    boolean mListShown;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.725 -0400", hash_original_method = "EF57861318B397409B17ABF77AE47B37", hash_generated_method = "D5B2EF6298161BB1BE7DCF257A07817C")
    public  ListFragment() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.725 -0400", hash_original_method = "BEDEF1303F07526C038707780C2D3CB6", hash_generated_method = "FF1A75852F85BB1A0E323BFD6939CA6B")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
        addTaint(savedInstanceState.getTaint());
        addTaint(container.getTaint());
        addTaint(inflater.getTaint());
View var1B87B9722589983B280E6A80193F3C07_1193759031 =         inflater.inflate(com.android.internal.R.layout.list_content,
                container, false);
        var1B87B9722589983B280E6A80193F3C07_1193759031.addTaint(taint);
        return var1B87B9722589983B280E6A80193F3C07_1193759031;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.725 -0400", hash_original_method = "3AF156F2799514C47B044D45A77C4F43", hash_generated_method = "2BCE58E31FB785C574D5AEC6E88F358A")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        
        addTaint(savedInstanceState.getTaint());
        addTaint(view.getTaint());
        super.onViewCreated(view, savedInstanceState);
        ensureList();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.725 -0400", hash_original_method = "4AE67C9B14400A0313E10E10FEB59F4C", hash_generated_method = "350457CE5B7B3348E789915760B51908")
    @Override
    public void onDestroyView() {
        
        mHandler.removeCallbacks(mRequestFocus);
        mList = null;
        mListShown = false;
        mEmptyView = mProgressContainer = mListContainer = null;
        mStandardEmptyView = null;
        super.onDestroyView();
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.726 -0400", hash_original_method = "BF490B4BB4BD29ACC689E0297B614061", hash_generated_method = "88BEAA79114E29F33BC32B86B2051CD9")
    public void onListItemClick(ListView l, View v, int position, long id) {
        
        addTaint(id);
        addTaint(position);
        addTaint(v.getTaint());
        addTaint(l.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.726 -0400", hash_original_method = "B9F859547BD6410EA28F34027A6366BE", hash_generated_method = "603A4D55808103A90D851FF671C09445")
    public void setListAdapter(ListAdapter adapter) {
        boolean hadAdapter = mAdapter != null;
        mAdapter = adapter;
    if(mList != null)        
        {
            mList.setAdapter(adapter);
    if(!mListShown && !hadAdapter)            
            {
                setListShown(true, getView().getWindowToken() != null);
            } 
        } 
        
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.726 -0400", hash_original_method = "6FC4BB7AE2BE523C1207DDD3222220F6", hash_generated_method = "6D445B8D673D3639928814553952A446")
    public void setSelection(int position) {
        addTaint(position);
        ensureList();
        mList.setSelection(position);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.727 -0400", hash_original_method = "602C73B7F7242D55D7B4B399409B7E51", hash_generated_method = "F13A0A8B1D45504BF55ED7F602653A78")
    public int getSelectedItemPosition() {
        ensureList();
        int varB3259E78107540D8D68BCBB3E503CBA4_1231416530 = (mList.getSelectedItemPosition());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2055640769 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2055640769;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.727 -0400", hash_original_method = "7FA8F631361DB814AF49E068AB6A3A01", hash_generated_method = "8DEFD0B439EA8E1730C7D158A1EEE180")
    public long getSelectedItemId() {
        ensureList();
        long var9B989EB69692C97E4AB8970CCD694C25_1913681698 = (mList.getSelectedItemId());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_291489060 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_291489060;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.727 -0400", hash_original_method = "B9D8406BF510100833C8B83670824289", hash_generated_method = "23503DED408310362DBB9D4838353C29")
    public ListView getListView() {
        ensureList();
ListView var344AE622895130273F3D062543816FEE_1308925 =         mList;
        var344AE622895130273F3D062543816FEE_1308925.addTaint(taint);
        return var344AE622895130273F3D062543816FEE_1308925;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.728 -0400", hash_original_method = "BDE8F4E2DF99E8DBF624FF236090A0E2", hash_generated_method = "AB37D187D2FE482A9A30BAB150AC7B81")
    public void setEmptyText(CharSequence text) {
        ensureList();
    if(mStandardEmptyView == null)        
        {
            IllegalStateException varD4103A519630FF4520E774F631D45BAC_1382480700 = new IllegalStateException("Can't be used with a custom content view");
            varD4103A519630FF4520E774F631D45BAC_1382480700.addTaint(taint);
            throw varD4103A519630FF4520E774F631D45BAC_1382480700;
        } 
        mStandardEmptyView.setText(text);
    if(mEmptyText == null)        
        {
            mList.setEmptyView(mStandardEmptyView);
        } 
        mEmptyText = text;
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.728 -0400", hash_original_method = "58A7D31C5F755970E32BD1449250481A", hash_generated_method = "ECFA22EF7C67E65DE11CACB9B16B3B88")
    public void setListShown(boolean shown) {
        addTaint(shown);
        setListShown(shown, true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.728 -0400", hash_original_method = "9A20C5F20729EB8F1D1E26962B6A5257", hash_generated_method = "2204BE8E8F3D2EB7B29E24737821F7B6")
    public void setListShownNoAnimation(boolean shown) {
        addTaint(shown);
        setListShown(shown, false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.729 -0400", hash_original_method = "01D2A62CF5C9E9D8F31EAD95561BA6AA", hash_generated_method = "595E859D817767D558A33B1598F38E1F")
    private void setListShown(boolean shown, boolean animate) {
        addTaint(animate);
        ensureList();
    if(mProgressContainer == null)        
        {
            IllegalStateException varD4103A519630FF4520E774F631D45BAC_1228636403 = new IllegalStateException("Can't be used with a custom content view");
            varD4103A519630FF4520E774F631D45BAC_1228636403.addTaint(taint);
            throw varD4103A519630FF4520E774F631D45BAC_1228636403;
        } 
    if(mListShown == shown)        
        {
            return;
        } 
        mListShown = shown;
    if(shown)        
        {
    if(animate)            
            {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_out));
                mListContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_in));
            } 
            else
            {
                mProgressContainer.clearAnimation();
                mListContainer.clearAnimation();
            } 
            mProgressContainer.setVisibility(View.GONE);
            mListContainer.setVisibility(View.VISIBLE);
        } 
        else
        {
    if(animate)            
            {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_in));
                mListContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_out));
            } 
            else
            {
                mProgressContainer.clearAnimation();
                mListContainer.clearAnimation();
            } 
            mProgressContainer.setVisibility(View.VISIBLE);
            mListContainer.setVisibility(View.GONE);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.729 -0400", hash_original_method = "6C199B6FBEC38BDF6D031387113C1DD5", hash_generated_method = "5BCEA0270FA449E23A1F7FEE5B0F47A7")
    public ListAdapter getListAdapter() {
ListAdapter varD72668EDE5E63ADF9340F3D8A19FD205_451481418 =         mAdapter;
        varD72668EDE5E63ADF9340F3D8A19FD205_451481418.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_451481418;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:03.732 -0400", hash_original_method = "E4157ED141058B6B94474E0556BB8B74", hash_generated_method = "89D2458634B0B9A86BE10E121F5AB9E5")
    private void ensureList() {
    if(mList != null)        
        {
            return;
        } 
        View root = getView();
    if(root == null)        
        {
            IllegalStateException var052948DC6923A855D5D68E1310933CAB_1649119201 = new IllegalStateException("Content view not yet created");
            var052948DC6923A855D5D68E1310933CAB_1649119201.addTaint(taint);
            throw var052948DC6923A855D5D68E1310933CAB_1649119201;
        } 
    if(root instanceof ListView)        
        {
            mList = (ListView)root;
        } 
        else
        {
            mStandardEmptyView = (TextView)root.findViewById(
                    com.android.internal.R.id.internalEmpty);
    if(mStandardEmptyView == null)            
            {
                mEmptyView = root.findViewById(android.R.id.empty);
            } 
            else
            {
                mStandardEmptyView.setVisibility(View.GONE);
            } 
            mProgressContainer = root.findViewById(com.android.internal.R.id.progressContainer);
            mListContainer = root.findViewById(com.android.internal.R.id.listContainer);
            View rawListView = root.findViewById(android.R.id.list);
    if(!(rawListView instanceof ListView))            
            {
                RuntimeException var21587997F544C4FA9C985E7B90148739_1452708923 = new RuntimeException(
                        "Content has view with id attribute 'android.R.id.list' "
                        + "that is not a ListView class");
                var21587997F544C4FA9C985E7B90148739_1452708923.addTaint(taint);
                throw var21587997F544C4FA9C985E7B90148739_1452708923;
            } 
            mList = (ListView)rawListView;
    if(mList == null)            
            {
                RuntimeException var814898E2A75124B230F991BD301E888E_976496225 = new RuntimeException(
                        "Your content must have a ListView whose id attribute is " +
                        "'android.R.id.list'");
                var814898E2A75124B230F991BD301E888E_976496225.addTaint(taint);
                throw var814898E2A75124B230F991BD301E888E_976496225;
            } 
    if(mEmptyView != null)            
            {
                mList.setEmptyView(mEmptyView);
            } 
            else
    if(mEmptyText != null)            
            {
                mStandardEmptyView.setText(mEmptyText);
                mList.setEmptyView(mStandardEmptyView);
            } 
        } 
        mListShown = true;
        mList.setOnItemClickListener(mOnClickListener);
    if(mAdapter != null)        
        {
            ListAdapter adapter = mAdapter;
            mAdapter = null;
            setListAdapter(adapter);
        } 
        else
        {
    if(mProgressContainer != null)            
            {
                setListShown(false, false);
            } 
        } 
        mHandler.post(mRequestFocus);
        
        
    }

    
}

