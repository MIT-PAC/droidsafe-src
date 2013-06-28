package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.104 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "ED5BAD7C7A1EC83F341419B29A267C9F")

    final private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.105 -0400", hash_original_field = "F487762B42FCD79D908F11802425F9AE", hash_generated_field = "1DE73C7158094283DF2E07B61B66A0F0")

    final private Runnable mRequestFocus = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.105 -0400", hash_original_method = "4F290F2508C3F0B44E09591C5B0749BC", hash_generated_method = "203642A5324F5F18B21A0D020E65FD5C")
        public void run() {
            mList.focusableViewAvailable(mList);
            // ---------- Original Method ----------
            //mList.focusableViewAvailable(mList);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.106 -0400", hash_original_field = "9B3F30A71979D6623D111E114AFFBE5E", hash_generated_field = "42C04E77E3D60E8D569E30C744D85151")

    final private AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.105 -0400", hash_original_method = "FBAC6E1DF4BED6C0A21E33622DB577EE", hash_generated_method = "D00BEF8ABA88B27607955BB6270FA24E")
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onListItemClick((ListView)parent, v, position, id);
            addTaint(parent.getTaint());
            addTaint(v.getTaint());
            addTaint(position);
            addTaint(id);
            // ---------- Original Method ----------
            //onListItemClick((ListView)parent, v, position, id);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.106 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "CBDD62EF585589E92C0E00AE9F4F22E2")

    ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.106 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "A5B73AC2B922200A8C47FEAA8C3EB07A")

    ListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.106 -0400", hash_original_field = "70C77B82E1F7307619839CA84E110E30", hash_generated_field = "7791203818A2C8C23F9ABF8545C329FB")

    View mEmptyView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.106 -0400", hash_original_field = "55016CBFD3CE49ADBAB505CE2082E915", hash_generated_field = "1BF76B462D7F24436F14F7F745BB541C")

    TextView mStandardEmptyView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.106 -0400", hash_original_field = "56720DB5DBB6738225C3A90D862F1AB2", hash_generated_field = "5A35A3CD88A2CD2FFD5E60C83A9EA805")

    View mProgressContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.106 -0400", hash_original_field = "45A98EEED29C789395ED1681F7616E63", hash_generated_field = "4BEB12F6053492A04536FE88CDB7F3C9")

    View mListContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.106 -0400", hash_original_field = "7AE2AFD490CFC5D0B1BA25431F78642B", hash_generated_field = "D3680587F795E32338C0D453701D98D2")

    CharSequence mEmptyText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.106 -0400", hash_original_field = "EEBC082FD5621811F12260D0FCF8CF84", hash_generated_field = "DED3E45D8C8FC4CDC3B9DE2C2A90BA30")

    boolean mListShown;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.106 -0400", hash_original_method = "EF57861318B397409B17ABF77AE47B37", hash_generated_method = "D5B2EF6298161BB1BE7DCF257A07817C")
    public  ListFragment() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.107 -0400", hash_original_method = "BEDEF1303F07526C038707780C2D3CB6", hash_generated_method = "570654D078B2FA59F6819DCA70D55CFE")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_1775762050 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1775762050 = inflater.inflate(com.android.internal.R.layout.list_content,
                container, false);
        addTaint(inflater.getTaint());
        addTaint(container.getTaint());
        addTaint(savedInstanceState.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1775762050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1775762050;
        // ---------- Original Method ----------
        //return inflater.inflate(com.android.internal.R.layout.list_content,
                //container, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.108 -0400", hash_original_method = "3AF156F2799514C47B044D45A77C4F43", hash_generated_method = "74501A1834F8793F5C8EF071BCD20061")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onViewCreated(view, savedInstanceState);
        ensureList();
        addTaint(view.getTaint());
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        //super.onViewCreated(view, savedInstanceState);
        //ensureList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.108 -0400", hash_original_method = "4AE67C9B14400A0313E10E10FEB59F4C", hash_generated_method = "350457CE5B7B3348E789915760B51908")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.109 -0400", hash_original_method = "BF490B4BB4BD29ACC689E0297B614061", hash_generated_method = "EF64D58407ED8252E2CE18DD4AFFAEF4")
    public void onListItemClick(ListView l, View v, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(l.getTaint());
        addTaint(v.getTaint());
        addTaint(position);
        addTaint(id);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.110 -0400", hash_original_method = "B9F859547BD6410EA28F34027A6366BE", hash_generated_method = "1F0929FABCAD46BD9C27FFDAF70AD071")
    public void setListAdapter(ListAdapter adapter) {
        boolean hadAdapter = mAdapter != null;
        mAdapter = adapter;
        {
            mList.setAdapter(adapter);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.110 -0400", hash_original_method = "6FC4BB7AE2BE523C1207DDD3222220F6", hash_generated_method = "4EABBAADD2097BA5BF04A6EF19B80786")
    public void setSelection(int position) {
        ensureList();
        mList.setSelection(position);
        addTaint(position);
        // ---------- Original Method ----------
        //ensureList();
        //mList.setSelection(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.111 -0400", hash_original_method = "602C73B7F7242D55D7B4B399409B7E51", hash_generated_method = "7CEC210D18DE34837BFD8AB4D8F82179")
    public int getSelectedItemPosition() {
        ensureList();
        int varA719D7AB33A194F7536365FE9FEAD214_288289307 = (mList.getSelectedItemPosition());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342264659 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342264659;
        // ---------- Original Method ----------
        //ensureList();
        //return mList.getSelectedItemPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.112 -0400", hash_original_method = "7FA8F631361DB814AF49E068AB6A3A01", hash_generated_method = "850F8536222999B09B049094950F0751")
    public long getSelectedItemId() {
        ensureList();
        long var182667D91D2A4233A45F2A88B322602D_1222421807 = (mList.getSelectedItemId());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2137468624 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2137468624;
        // ---------- Original Method ----------
        //ensureList();
        //return mList.getSelectedItemId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.113 -0400", hash_original_method = "B9D8406BF510100833C8B83670824289", hash_generated_method = "72969C80034A0A2D08E562CB60852344")
    public ListView getListView() {
        ListView varB4EAC82CA7396A68D541C85D26508E83_2124823455 = null; //Variable for return #1
        ensureList();
        varB4EAC82CA7396A68D541C85D26508E83_2124823455 = mList;
        varB4EAC82CA7396A68D541C85D26508E83_2124823455.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2124823455;
        // ---------- Original Method ----------
        //ensureList();
        //return mList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.114 -0400", hash_original_method = "BDE8F4E2DF99E8DBF624FF236090A0E2", hash_generated_method = "5F708231B8C2803171A41E2A5B2F632F")
    public void setEmptyText(CharSequence text) {
        ensureList();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Can't be used with a custom content view");
        } //End block
        mStandardEmptyView.setText(text);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.115 -0400", hash_original_method = "58A7D31C5F755970E32BD1449250481A", hash_generated_method = "576224D18FD9380984898F41933212F2")
    public void setListShown(boolean shown) {
        setListShown(shown, true);
        addTaint(shown);
        // ---------- Original Method ----------
        //setListShown(shown, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.115 -0400", hash_original_method = "9A20C5F20729EB8F1D1E26962B6A5257", hash_generated_method = "0C1A33C416860E4DAE1118BF4D947724")
    public void setListShownNoAnimation(boolean shown) {
        setListShown(shown, false);
        addTaint(shown);
        // ---------- Original Method ----------
        //setListShown(shown, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.117 -0400", hash_original_method = "01D2A62CF5C9E9D8F31EAD95561BA6AA", hash_generated_method = "1015EF4FDF0FFE98688E48D7E7EEDA51")
    private void setListShown(boolean shown, boolean animate) {
        ensureList();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Can't be used with a custom content view");
        } //End block
        mListShown = shown;
        {
            {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_out));
                mListContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_in));
            } //End block
            {
                mProgressContainer.clearAnimation();
                mListContainer.clearAnimation();
            } //End block
            mProgressContainer.setVisibility(View.GONE);
            mListContainer.setVisibility(View.VISIBLE);
        } //End block
        {
            {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_in));
                mListContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_out));
            } //End block
            {
                mProgressContainer.clearAnimation();
                mListContainer.clearAnimation();
            } //End block
            mProgressContainer.setVisibility(View.VISIBLE);
            mListContainer.setVisibility(View.GONE);
        } //End block
        addTaint(animate);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.118 -0400", hash_original_method = "6C199B6FBEC38BDF6D031387113C1DD5", hash_generated_method = "7573F662E6BF79F7BD5BE5F5EED6EE77")
    public ListAdapter getListAdapter() {
        ListAdapter varB4EAC82CA7396A68D541C85D26508E83_1540230223 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1540230223 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_1540230223.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1540230223;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.120 -0400", hash_original_method = "E4157ED141058B6B94474E0556BB8B74", hash_generated_method = "B4927DE87C05AF9A5400CA08BF0E578A")
    private void ensureList() {
        View root = getView();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Content view not yet created");
        } //End block
        {
            mList = (ListView)root;
        } //End block
        {
            mStandardEmptyView = (TextView)root.findViewById(
                    com.android.internal.R.id.internalEmpty);
            {
                mEmptyView = root.findViewById(android.R.id.empty);
            } //End block
            {
                mStandardEmptyView.setVisibility(View.GONE);
            } //End block
            mProgressContainer = root.findViewById(com.android.internal.R.id.progressContainer);
            mListContainer = root.findViewById(com.android.internal.R.id.listContainer);
            View rawListView = root.findViewById(android.R.id.list);
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Content has view with id attribute 'android.R.id.list' "
                        + "that is not a ListView class");
            } //End block
            mList = (ListView)rawListView;
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Your content must have a ListView whose id attribute is " +
                        "'android.R.id.list'");
            } //End block
            {
                mList.setEmptyView(mEmptyView);
            } //End block
            {
                mStandardEmptyView.setText(mEmptyText);
                mList.setEmptyView(mStandardEmptyView);
            } //End block
        } //End block
        mListShown = true;
        mList.setOnItemClickListener(mOnClickListener);
        {
            ListAdapter adapter = mAdapter;
            mAdapter = null;
            setListAdapter(adapter);
        } //End block
        {
            {
                setListShown(false, false);
            } //End block
        } //End block
        mHandler.post(mRequestFocus);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

