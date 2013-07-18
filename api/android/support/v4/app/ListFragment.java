package android.support.v4.app;

// Droidsafe Imports
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ListFragment extends Fragment {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.474 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "ED5BAD7C7A1EC83F341419B29A267C9F")

    final private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.048 -0400", hash_original_field = "F487762B42FCD79D908F11802425F9AE", hash_generated_field = "2191C8C7F9D27D78D192D12C39499CAC")

    final private Runnable mRequestFocus = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.048 -0400", hash_original_method = "4F290F2508C3F0B44E09591C5B0749BC", hash_generated_method = "203642A5324F5F18B21A0D020E65FD5C")
        public void run() {
            mList.focusableViewAvailable(mList);
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.049 -0400", hash_original_field = "9B3F30A71979D6623D111E114AFFBE5E", hash_generated_field = "11A57FDB212BDD905BF1B62417E937BB")

    final private AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.049 -0400", hash_original_method = "FBAC6E1DF4BED6C0A21E33622DB577EE", hash_generated_method = "D00BEF8ABA88B27607955BB6270FA24E")
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            
            onListItemClick((ListView)parent, v, position, id);
            addTaint(parent.getTaint());
            addTaint(v.getTaint());
            addTaint(position);
            addTaint(id);
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.474 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "CBDD62EF585589E92C0E00AE9F4F22E2")

    ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.474 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "A5B73AC2B922200A8C47FEAA8C3EB07A")

    ListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.474 -0400", hash_original_field = "70C77B82E1F7307619839CA84E110E30", hash_generated_field = "7791203818A2C8C23F9ABF8545C329FB")

    View mEmptyView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.474 -0400", hash_original_field = "55016CBFD3CE49ADBAB505CE2082E915", hash_generated_field = "1BF76B462D7F24436F14F7F745BB541C")

    TextView mStandardEmptyView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.474 -0400", hash_original_field = "56720DB5DBB6738225C3A90D862F1AB2", hash_generated_field = "5A35A3CD88A2CD2FFD5E60C83A9EA805")

    View mProgressContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.474 -0400", hash_original_field = "45A98EEED29C789395ED1681F7616E63", hash_generated_field = "4BEB12F6053492A04536FE88CDB7F3C9")

    View mListContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.474 -0400", hash_original_field = "7AE2AFD490CFC5D0B1BA25431F78642B", hash_generated_field = "D3680587F795E32338C0D453701D98D2")

    CharSequence mEmptyText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.474 -0400", hash_original_field = "EEBC082FD5621811F12260D0FCF8CF84", hash_generated_field = "DED3E45D8C8FC4CDC3B9DE2C2A90BA30")

    boolean mListShown;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.474 -0400", hash_original_method = "EF57861318B397409B17ABF77AE47B37", hash_generated_method = "D5B2EF6298161BB1BE7DCF257A07817C")
    public  ListFragment() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.476 -0400", hash_original_method = "92DD87AA93E8A92E60115765257469F5", hash_generated_method = "A0001B7116B7AF93DEEB0D1EB730C073")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        addTaint(container.getTaint());
        addTaint(inflater.getTaint());
        final Context context = getActivity();
        FrameLayout root = new FrameLayout(context);
        LinearLayout pframe = new LinearLayout(context);
        pframe.setId(INTERNAL_PROGRESS_CONTAINER_ID);
        pframe.setOrientation(LinearLayout.VERTICAL);
        pframe.setVisibility(View.GONE);
        pframe.setGravity(Gravity.CENTER);
        ProgressBar progress = new ProgressBar(context, null,
                android.R.attr.progressBarStyleLarge);
        pframe.addView(progress, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        root.addView(pframe, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        FrameLayout lframe = new FrameLayout(context);
        lframe.setId(INTERNAL_LIST_CONTAINER_ID);
        TextView tv = new TextView(getActivity());
        tv.setId(INTERNAL_EMPTY_ID);
        tv.setGravity(Gravity.CENTER);
        lframe.addView(tv, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        ListView lv = new ListView(getActivity());
        lv.setId(android.R.id.list);
        lv.setDrawSelectorOnTop(false);
        lframe.addView(lv, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        root.addView(lframe, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        root.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
View varE2FC54A1BB143D1D1A0E38EDF22F290D_466747361 =         root;
        varE2FC54A1BB143D1D1A0E38EDF22F290D_466747361.addTaint(taint);
        return varE2FC54A1BB143D1D1A0E38EDF22F290D_466747361;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.477 -0400", hash_original_method = "3AF156F2799514C47B044D45A77C4F43", hash_generated_method = "2BCE58E31FB785C574D5AEC6E88F358A")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        addTaint(view.getTaint());
        super.onViewCreated(view, savedInstanceState);
        ensureList();
        // ---------- Original Method ----------
        //super.onViewCreated(view, savedInstanceState);
        //ensureList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.478 -0400", hash_original_method = "4AE67C9B14400A0313E10E10FEB59F4C", hash_generated_method = "350457CE5B7B3348E789915760B51908")
    @Override
    public void onDestroyView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mHandler.removeCallbacks(mRequestFocus);
        mList = null;
        mListShown = false;
        mEmptyView = mProgressContainer = mListContainer = null;
        mStandardEmptyView = null;
        super.onDestroyView();
        // ---------- Original Method ----------
        //mHandler.removeCallbacks(mRequestFocus);
        //mList = null;
        //mListShown = false;
        //mEmptyView = mProgressContainer = mListContainer = null;
        //mStandardEmptyView = null;
        //super.onDestroyView();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.479 -0400", hash_original_method = "BF490B4BB4BD29ACC689E0297B614061", hash_generated_method = "88BEAA79114E29F33BC32B86B2051CD9")
    public void onListItemClick(ListView l, View v, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(id);
        addTaint(position);
        addTaint(v.getTaint());
        addTaint(l.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.479 -0400", hash_original_method = "B9F859547BD6410EA28F34027A6366BE", hash_generated_method = "603A4D55808103A90D851FF671C09445")
    public void setListAdapter(ListAdapter adapter) {
        boolean hadAdapter = mAdapter != null;
        mAdapter = adapter;
        if(mList != null)        
        {
            mList.setAdapter(adapter);
            if(!mListShown && !hadAdapter)            
            {
                setListShown(true, getView().getWindowToken() != null);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //boolean hadAdapter = mAdapter != null;
        //mAdapter = adapter;
        //if (mList != null) {
            //mList.setAdapter(adapter);
            //if (!mListShown && !hadAdapter) {
                //setListShown(true, getView().getWindowToken() != null);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.480 -0400", hash_original_method = "6FC4BB7AE2BE523C1207DDD3222220F6", hash_generated_method = "6D445B8D673D3639928814553952A446")
    public void setSelection(int position) {
        addTaint(position);
        ensureList();
        mList.setSelection(position);
        // ---------- Original Method ----------
        //ensureList();
        //mList.setSelection(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.480 -0400", hash_original_method = "602C73B7F7242D55D7B4B399409B7E51", hash_generated_method = "D72483B32AE33B66FCAEC9B123A42F5F")
    public int getSelectedItemPosition() {
        ensureList();
        int varB3259E78107540D8D68BCBB3E503CBA4_1727232750 = (mList.getSelectedItemPosition());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808543835 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808543835;
        // ---------- Original Method ----------
        //ensureList();
        //return mList.getSelectedItemPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.481 -0400", hash_original_method = "7FA8F631361DB814AF49E068AB6A3A01", hash_generated_method = "D9254F20C18A19FE0DAD0F619FE314B0")
    public long getSelectedItemId() {
        ensureList();
        long var9B989EB69692C97E4AB8970CCD694C25_198499156 = (mList.getSelectedItemId());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1023364754 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1023364754;
        // ---------- Original Method ----------
        //ensureList();
        //return mList.getSelectedItemId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.481 -0400", hash_original_method = "B9D8406BF510100833C8B83670824289", hash_generated_method = "0371E171DFD8E8E4B6BB30BA0FD41231")
    public ListView getListView() {
        ensureList();
ListView var344AE622895130273F3D062543816FEE_2017919155 =         mList;
        var344AE622895130273F3D062543816FEE_2017919155.addTaint(taint);
        return var344AE622895130273F3D062543816FEE_2017919155;
        // ---------- Original Method ----------
        //ensureList();
        //return mList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.482 -0400", hash_original_method = "BDE8F4E2DF99E8DBF624FF236090A0E2", hash_generated_method = "24747C899CE090BE21E00BD06DD90049")
    public void setEmptyText(CharSequence text) {
        ensureList();
        if(mStandardEmptyView == null)        
        {
            IllegalStateException varD4103A519630FF4520E774F631D45BAC_633430867 = new IllegalStateException("Can't be used with a custom content view");
            varD4103A519630FF4520E774F631D45BAC_633430867.addTaint(taint);
            throw varD4103A519630FF4520E774F631D45BAC_633430867;
        } //End block
        mStandardEmptyView.setText(text);
        if(mEmptyText == null)        
        {
            mList.setEmptyView(mStandardEmptyView);
        } //End block
        mEmptyText = text;
        // ---------- Original Method ----------
        //ensureList();
        //if (mStandardEmptyView == null) {
            //throw new IllegalStateException("Can't be used with a custom content view");
        //}
        //mStandardEmptyView.setText(text);
        //if (mEmptyText == null) {
            //mList.setEmptyView(mStandardEmptyView);
        //}
        //mEmptyText = text;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.483 -0400", hash_original_method = "58A7D31C5F755970E32BD1449250481A", hash_generated_method = "ECFA22EF7C67E65DE11CACB9B16B3B88")
    public void setListShown(boolean shown) {
        addTaint(shown);
        setListShown(shown, true);
        // ---------- Original Method ----------
        //setListShown(shown, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.484 -0400", hash_original_method = "9A20C5F20729EB8F1D1E26962B6A5257", hash_generated_method = "2204BE8E8F3D2EB7B29E24737821F7B6")
    public void setListShownNoAnimation(boolean shown) {
        addTaint(shown);
        setListShown(shown, false);
        // ---------- Original Method ----------
        //setListShown(shown, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.485 -0400", hash_original_method = "01D2A62CF5C9E9D8F31EAD95561BA6AA", hash_generated_method = "1739C7314D08B1BF28B91678AC6AB108")
    private void setListShown(boolean shown, boolean animate) {
        addTaint(animate);
        ensureList();
        if(mProgressContainer == null)        
        {
            IllegalStateException varD4103A519630FF4520E774F631D45BAC_1340290754 = new IllegalStateException("Can't be used with a custom content view");
            varD4103A519630FF4520E774F631D45BAC_1340290754.addTaint(taint);
            throw varD4103A519630FF4520E774F631D45BAC_1340290754;
        } //End block
        if(mListShown == shown)        
        {
            return;
        } //End block
        mListShown = shown;
        if(shown)        
        {
            if(animate)            
            {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_out));
                mListContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_in));
            } //End block
            else
            {
                mProgressContainer.clearAnimation();
                mListContainer.clearAnimation();
            } //End block
            mProgressContainer.setVisibility(View.GONE);
            mListContainer.setVisibility(View.VISIBLE);
        } //End block
        else
        {
            if(animate)            
            {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_in));
                mListContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_out));
            } //End block
            else
            {
                mProgressContainer.clearAnimation();
                mListContainer.clearAnimation();
            } //End block
            mProgressContainer.setVisibility(View.VISIBLE);
            mListContainer.setVisibility(View.GONE);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.486 -0400", hash_original_method = "6C199B6FBEC38BDF6D031387113C1DD5", hash_generated_method = "333C982E00BEAAE717CC48AC8EAE2E7A")
    public ListAdapter getListAdapter() {
ListAdapter varD72668EDE5E63ADF9340F3D8A19FD205_1863790382 =         mAdapter;
        varD72668EDE5E63ADF9340F3D8A19FD205_1863790382.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_1863790382;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.487 -0400", hash_original_method = "2BE3F41178D2C0D0A071A3B313BD8473", hash_generated_method = "2436B08C00EDD91C55A9F3C21F0766C7")
    private void ensureList() {
        if(mList != null)        
        {
            return;
        } //End block
        View root = getView();
        if(root == null)        
        {
            IllegalStateException var052948DC6923A855D5D68E1310933CAB_113641193 = new IllegalStateException("Content view not yet created");
            var052948DC6923A855D5D68E1310933CAB_113641193.addTaint(taint);
            throw var052948DC6923A855D5D68E1310933CAB_113641193;
        } //End block
        if(root instanceof ListView)        
        {
            mList = (ListView)root;
        } //End block
        else
        {
            mStandardEmptyView = (TextView)root.findViewById(INTERNAL_EMPTY_ID);
            if(mStandardEmptyView == null)            
            {
                mEmptyView = root.findViewById(android.R.id.empty);
            } //End block
            else
            {
                mStandardEmptyView.setVisibility(View.GONE);
            } //End block
            mProgressContainer = root.findViewById(INTERNAL_PROGRESS_CONTAINER_ID);
            mListContainer = root.findViewById(INTERNAL_LIST_CONTAINER_ID);
            View rawListView = root.findViewById(android.R.id.list);
            if(!(rawListView instanceof ListView))            
            {
                if(rawListView == null)                
                {
                    RuntimeException var814898E2A75124B230F991BD301E888E_1482924397 = new RuntimeException(
                            "Your content must have a ListView whose id attribute is " +
                            "'android.R.id.list'");
                    var814898E2A75124B230F991BD301E888E_1482924397.addTaint(taint);
                    throw var814898E2A75124B230F991BD301E888E_1482924397;
                } //End block
                RuntimeException var21587997F544C4FA9C985E7B90148739_1700899876 = new RuntimeException(
                        "Content has view with id attribute 'android.R.id.list' "
                        + "that is not a ListView class");
                var21587997F544C4FA9C985E7B90148739_1700899876.addTaint(taint);
                throw var21587997F544C4FA9C985E7B90148739_1700899876;
            } //End block
            mList = (ListView)rawListView;
            if(mEmptyView != null)            
            {
                mList.setEmptyView(mEmptyView);
            } //End block
            else
            if(mEmptyText != null)            
            {
                mStandardEmptyView.setText(mEmptyText);
                mList.setEmptyView(mStandardEmptyView);
            } //End block
        } //End block
        mListShown = true;
        mList.setOnItemClickListener(mOnClickListener);
        if(mAdapter != null)        
        {
            ListAdapter adapter = mAdapter;
            mAdapter = null;
            setListAdapter(adapter);
        } //End block
        else
        {
            if(mProgressContainer != null)            
            {
                setListShown(false, false);
            } //End block
        } //End block
        mHandler.post(mRequestFocus);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.488 -0400", hash_original_field = "6312AD4B3B1A2011BDFB6605521CFAC7", hash_generated_field = "D35812CB4DF51387A3967109DF8D7790")

    static final int INTERNAL_EMPTY_ID = 0x00ff0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.488 -0400", hash_original_field = "697E1C263B09A65174C303E08A05B77A", hash_generated_field = "758272559997956C9DC60EF2A82A42A2")

    static final int INTERNAL_PROGRESS_CONTAINER_ID = 0x00ff0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.488 -0400", hash_original_field = "226BFF2CC95CCF6E2DFE3224958E96E6", hash_generated_field = "0185783DBF741CB8ACAE8F393156A699")

    static final int INTERNAL_LIST_CONTAINER_ID = 0x00ff0003;
}

