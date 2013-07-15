package android.support.v4.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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

public class ListFragment extends Fragment {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.048 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "ED5BAD7C7A1EC83F341419B29A267C9F")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.049 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "CBDD62EF585589E92C0E00AE9F4F22E2")

    ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.049 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "A5B73AC2B922200A8C47FEAA8C3EB07A")

    ListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.049 -0400", hash_original_field = "70C77B82E1F7307619839CA84E110E30", hash_generated_field = "7791203818A2C8C23F9ABF8545C329FB")

    View mEmptyView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.049 -0400", hash_original_field = "55016CBFD3CE49ADBAB505CE2082E915", hash_generated_field = "1BF76B462D7F24436F14F7F745BB541C")

    TextView mStandardEmptyView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.049 -0400", hash_original_field = "56720DB5DBB6738225C3A90D862F1AB2", hash_generated_field = "5A35A3CD88A2CD2FFD5E60C83A9EA805")

    View mProgressContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.049 -0400", hash_original_field = "45A98EEED29C789395ED1681F7616E63", hash_generated_field = "4BEB12F6053492A04536FE88CDB7F3C9")

    View mListContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.049 -0400", hash_original_field = "7AE2AFD490CFC5D0B1BA25431F78642B", hash_generated_field = "D3680587F795E32338C0D453701D98D2")

    CharSequence mEmptyText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.049 -0400", hash_original_field = "EEBC082FD5621811F12260D0FCF8CF84", hash_generated_field = "DED3E45D8C8FC4CDC3B9DE2C2A90BA30")

    boolean mListShown;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.049 -0400", hash_original_method = "EF57861318B397409B17ABF77AE47B37", hash_generated_method = "D5B2EF6298161BB1BE7DCF257A07817C")
    public  ListFragment() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.050 -0400", hash_original_method = "92DD87AA93E8A92E60115765257469F5", hash_generated_method = "0FA1DD4B75CF8DD3DCC14FE6B8D47C46")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
        View varB4EAC82CA7396A68D541C85D26508E83_46519043 = null; 
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
        varB4EAC82CA7396A68D541C85D26508E83_46519043 = root;
        addTaint(inflater.getTaint());
        addTaint(container.getTaint());
        addTaint(savedInstanceState.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_46519043.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_46519043;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.051 -0400", hash_original_method = "3AF156F2799514C47B044D45A77C4F43", hash_generated_method = "74501A1834F8793F5C8EF071BCD20061")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        
        super.onViewCreated(view, savedInstanceState);
        ensureList();
        addTaint(view.getTaint());
        addTaint(savedInstanceState.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.051 -0400", hash_original_method = "4AE67C9B14400A0313E10E10FEB59F4C", hash_generated_method = "350457CE5B7B3348E789915760B51908")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.052 -0400", hash_original_method = "BF490B4BB4BD29ACC689E0297B614061", hash_generated_method = "EF64D58407ED8252E2CE18DD4AFFAEF4")
    public void onListItemClick(ListView l, View v, int position, long id) {
        
        addTaint(l.getTaint());
        addTaint(v.getTaint());
        addTaint(position);
        addTaint(id);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.052 -0400", hash_original_method = "B9F859547BD6410EA28F34027A6366BE", hash_generated_method = "1F0929FABCAD46BD9C27FFDAF70AD071")
    public void setListAdapter(ListAdapter adapter) {
        boolean hadAdapter = mAdapter != null;
        mAdapter = adapter;
        {
            mList.setAdapter(adapter);
            {
                setListShown(true, getView().getWindowToken() != null);
            } 
        } 
        
        
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.053 -0400", hash_original_method = "6FC4BB7AE2BE523C1207DDD3222220F6", hash_generated_method = "4EABBAADD2097BA5BF04A6EF19B80786")
    public void setSelection(int position) {
        ensureList();
        mList.setSelection(position);
        addTaint(position);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.053 -0400", hash_original_method = "602C73B7F7242D55D7B4B399409B7E51", hash_generated_method = "F02DA4F3601DC332E18D69FD8C97B8A8")
    public int getSelectedItemPosition() {
        ensureList();
        int varA719D7AB33A194F7536365FE9FEAD214_777326183 = (mList.getSelectedItemPosition());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113524907 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113524907;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.054 -0400", hash_original_method = "7FA8F631361DB814AF49E068AB6A3A01", hash_generated_method = "DC5CC997D7AC70D1B2D1878555C43F9D")
    public long getSelectedItemId() {
        ensureList();
        long var182667D91D2A4233A45F2A88B322602D_52187943 = (mList.getSelectedItemId());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1504117680 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1504117680;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.055 -0400", hash_original_method = "B9D8406BF510100833C8B83670824289", hash_generated_method = "B7DAF22FCD455D5DD6166C9E09B92F83")
    public ListView getListView() {
        ListView varB4EAC82CA7396A68D541C85D26508E83_1348333578 = null; 
        ensureList();
        varB4EAC82CA7396A68D541C85D26508E83_1348333578 = mList;
        varB4EAC82CA7396A68D541C85D26508E83_1348333578.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1348333578;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.056 -0400", hash_original_method = "BDE8F4E2DF99E8DBF624FF236090A0E2", hash_generated_method = "5F708231B8C2803171A41E2A5B2F632F")
    public void setEmptyText(CharSequence text) {
        ensureList();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Can't be used with a custom content view");
        } 
        mStandardEmptyView.setText(text);
        {
            mList.setEmptyView(mStandardEmptyView);
        } 
        mEmptyText = text;
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.056 -0400", hash_original_method = "58A7D31C5F755970E32BD1449250481A", hash_generated_method = "576224D18FD9380984898F41933212F2")
    public void setListShown(boolean shown) {
        setListShown(shown, true);
        addTaint(shown);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.057 -0400", hash_original_method = "9A20C5F20729EB8F1D1E26962B6A5257", hash_generated_method = "0C1A33C416860E4DAE1118BF4D947724")
    public void setListShownNoAnimation(boolean shown) {
        setListShown(shown, false);
        addTaint(shown);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.057 -0400", hash_original_method = "01D2A62CF5C9E9D8F31EAD95561BA6AA", hash_generated_method = "1015EF4FDF0FFE98688E48D7E7EEDA51")
    private void setListShown(boolean shown, boolean animate) {
        ensureList();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Can't be used with a custom content view");
        } 
        mListShown = shown;
        {
            {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_out));
                mListContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_in));
            } 
            {
                mProgressContainer.clearAnimation();
                mListContainer.clearAnimation();
            } 
            mProgressContainer.setVisibility(View.GONE);
            mListContainer.setVisibility(View.VISIBLE);
        } 
        {
            {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_in));
                mListContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_out));
            } 
            {
                mProgressContainer.clearAnimation();
                mListContainer.clearAnimation();
            } 
            mProgressContainer.setVisibility(View.VISIBLE);
            mListContainer.setVisibility(View.GONE);
        } 
        addTaint(animate);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.058 -0400", hash_original_method = "6C199B6FBEC38BDF6D031387113C1DD5", hash_generated_method = "51B92C107A5A08825FCE9FA135B388BE")
    public ListAdapter getListAdapter() {
        ListAdapter varB4EAC82CA7396A68D541C85D26508E83_197988307 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_197988307 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_197988307.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_197988307;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.059 -0400", hash_original_method = "2BE3F41178D2C0D0A071A3B313BD8473", hash_generated_method = "348FB20D06284C58588B559B357054AC")
    private void ensureList() {
        View root = getView();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Content view not yet created");
        } 
        {
            mList = (ListView)root;
        } 
        {
            mStandardEmptyView = (TextView)root.findViewById(INTERNAL_EMPTY_ID);
            {
                mEmptyView = root.findViewById(android.R.id.empty);
            } 
            {
                mStandardEmptyView.setVisibility(View.GONE);
            } 
            mProgressContainer = root.findViewById(INTERNAL_PROGRESS_CONTAINER_ID);
            mListContainer = root.findViewById(INTERNAL_LIST_CONTAINER_ID);
            View rawListView = root.findViewById(android.R.id.list);
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Your content must have a ListView whose id attribute is " +
                            "'android.R.id.list'");
                } 
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Content has view with id attribute 'android.R.id.list' "
                        + "that is not a ListView class");
            } 
            mList = (ListView)rawListView;
            {
                mList.setEmptyView(mEmptyView);
            } 
            {
                mStandardEmptyView.setText(mEmptyText);
                mList.setEmptyView(mStandardEmptyView);
            } 
        } 
        mListShown = true;
        mList.setOnItemClickListener(mOnClickListener);
        {
            ListAdapter adapter = mAdapter;
            mAdapter = null;
            setListAdapter(adapter);
        } 
        {
            {
                setListShown(false, false);
            } 
        } 
        mHandler.post(mRequestFocus);
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.059 -0400", hash_original_field = "6312AD4B3B1A2011BDFB6605521CFAC7", hash_generated_field = "D35812CB4DF51387A3967109DF8D7790")

    static final int INTERNAL_EMPTY_ID = 0x00ff0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.059 -0400", hash_original_field = "697E1C263B09A65174C303E08A05B77A", hash_generated_field = "758272559997956C9DC60EF2A82A42A2")

    static final int INTERNAL_PROGRESS_CONTAINER_ID = 0x00ff0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.059 -0400", hash_original_field = "226BFF2CC95CCF6E2DFE3224958E96E6", hash_generated_field = "0185783DBF741CB8ACAE8F393156A699")

    static final int INTERNAL_LIST_CONTAINER_ID = 0x00ff0003;
}

