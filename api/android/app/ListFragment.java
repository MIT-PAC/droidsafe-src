package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.044 -0500", hash_original_field = "AD9C3D1E48D73BF1547D53C4C62401B2", hash_generated_field = "ED5BAD7C7A1EC83F341419B29A267C9F")

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.055 -0500", hash_original_field = "CBDD62EF585589E92C0E00AE9F4F22E2", hash_generated_field = "CBDD62EF585589E92C0E00AE9F4F22E2")

    ListAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.057 -0500", hash_original_field = "A5B73AC2B922200A8C47FEAA8C3EB07A", hash_generated_field = "A5B73AC2B922200A8C47FEAA8C3EB07A")

    ListView mList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.060 -0500", hash_original_field = "7791203818A2C8C23F9ABF8545C329FB", hash_generated_field = "7791203818A2C8C23F9ABF8545C329FB")

    View mEmptyView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.062 -0500", hash_original_field = "1BF76B462D7F24436F14F7F745BB541C", hash_generated_field = "1BF76B462D7F24436F14F7F745BB541C")

    TextView mStandardEmptyView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.064 -0500", hash_original_field = "5A35A3CD88A2CD2FFD5E60C83A9EA805", hash_generated_field = "5A35A3CD88A2CD2FFD5E60C83A9EA805")

    View mProgressContainer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.066 -0500", hash_original_field = "4BEB12F6053492A04536FE88CDB7F3C9", hash_generated_field = "4BEB12F6053492A04536FE88CDB7F3C9")

    View mListContainer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.068 -0500", hash_original_field = "D3680587F795E32338C0D453701D98D2", hash_generated_field = "D3680587F795E32338C0D453701D98D2")

    CharSequence mEmptyText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.070 -0500", hash_original_field = "DED3E45D8C8FC4CDC3B9DE2C2A90BA30", hash_generated_field = "DED3E45D8C8FC4CDC3B9DE2C2A90BA30")

    boolean mListShown;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.072 -0500", hash_original_method = "EF57861318B397409B17ABF77AE47B37", hash_generated_method = "B81266A0FA43BBE0A70682BF3A3618B6")
    
public ListFragment() {
    }

    /**
     * Provide default implementation to return a simple list view.  Subclasses
     * can override to replace with their own layout.  If doing so, the
     * returned view hierarchy <em>must</em> have a ListView whose id
     * is {@link android.R.id#list android.R.id.list} and can optionally
     * have a sibling view id {@link android.R.id#empty android.R.id.empty}
     * that is to be shown when the list is empty.
     * 
     * <p>If you are overriding this method with your own custom content,
     * consider including the standard layout {@link android.R.layout#list_content}
     * in your layout file, so that you continue to retain all of the standard
     * behavior of ListFragment.  In particular, this is currently the only
     * way to have the built-in indeterminant progress state be shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.075 -0500", hash_original_method = "BEDEF1303F07526C038707780C2D3CB6", hash_generated_method = "32569A28687D4A3C8ED5E30F4B91B64A")
    
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(com.android.internal.R.layout.list_content,
                container, false);
    }

    /**
     * Attach to list view once the view hierarchy has been created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.077 -0500", hash_original_method = "3AF156F2799514C47B044D45A77C4F43", hash_generated_method = "87FA002C4A38DB8B9913B90D43B60586")
    
@Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ensureList();
    }

    /**
     * Detach from list view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.079 -0500", hash_original_method = "4AE67C9B14400A0313E10E10FEB59F4C", hash_generated_method = "FDE84136AAB0B0938E6DA23A8AEBA619")
    
@Override
    public void onDestroyView() {
        mHandler.removeCallbacks(mRequestFocus);
        mList = null;
        mListShown = false;
        mEmptyView = mProgressContainer = mListContainer = null;
        mStandardEmptyView = null;
        super.onDestroyView();
    }

    /**
     * This method will be called when an item in the list is selected.
     * Subclasses should override. Subclasses can call
     * getListView().getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param l The ListView where the click happened
     * @param v The view that was clicked within the ListView
     * @param position The position of the view in the list
     * @param id The row id of the item that was clicked
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.081 -0500", hash_original_method = "BF490B4BB4BD29ACC689E0297B614061", hash_generated_method = "CB4D791D7A70B359EC627916815866E7")
    
public void onListItemClick(ListView l, View v, int position, long id) {
    }

    /**
     * Provide the cursor for the list view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.083 -0500", hash_original_method = "B9F859547BD6410EA28F34027A6366BE", hash_generated_method = "24360340D52FA8A6C6E50D86154E3782")
    
public void setListAdapter(ListAdapter adapter) {
        boolean hadAdapter = mAdapter != null;
        mAdapter = adapter;
        if (mList != null) {
            mList.setAdapter(adapter);
            if (!mListShown && !hadAdapter) {
                // The list was hidden, and previously didn't have an
                // adapter.  It is now time to show it.
                setListShown(true, getView().getWindowToken() != null);
            }
        }
    }

    /**
     * Set the currently selected list item to the specified
     * position with the adapter's data
     *
     * @param position
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.085 -0500", hash_original_method = "6FC4BB7AE2BE523C1207DDD3222220F6", hash_generated_method = "A599FCBC7D48F26EB5D7B2F3DE51785A")
    
public void setSelection(int position) {
        ensureList();
        mList.setSelection(position);
    }

    /**
     * Get the position of the currently selected list item.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.087 -0500", hash_original_method = "602C73B7F7242D55D7B4B399409B7E51", hash_generated_method = "EF2F15FACD5AFD8A602B2895872995B7")
    
public int getSelectedItemPosition() {
        ensureList();
        return mList.getSelectedItemPosition();
    }

    /**
     * Get the cursor row ID of the currently selected list item.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.089 -0500", hash_original_method = "7FA8F631361DB814AF49E068AB6A3A01", hash_generated_method = "B331E878633D89AE3581D2EE05D8FA23")
    
public long getSelectedItemId() {
        ensureList();
        return mList.getSelectedItemId();
    }

    /**
     * Get the activity's list view widget.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.092 -0500", hash_original_method = "B9D8406BF510100833C8B83670824289", hash_generated_method = "F390A30877A55CE39C88D546BF9EAE07")
    
public ListView getListView() {
        ensureList();
        return mList;
    }

    /**
     * The default content for a ListFragment has a TextView that can
     * be shown when the list is empty.  If you would like to have it
     * shown, call this method to supply the text it should use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.095 -0500", hash_original_method = "BDE8F4E2DF99E8DBF624FF236090A0E2", hash_generated_method = "5E065A93894B457E8400200A9E3EEBAD")
    
public void setEmptyText(CharSequence text) {
        ensureList();
        if (mStandardEmptyView == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        mStandardEmptyView.setText(text);
        if (mEmptyText == null) {
            mList.setEmptyView(mStandardEmptyView);
        }
        mEmptyText = text;
    }
    
    /**
     * Control whether the list is being displayed.  You can make it not
     * displayed if you are waiting for the initial data to show in it.  During
     * this time an indeterminant progress indicator will be shown instead.
     * 
     * <p>Applications do not normally need to use this themselves.  The default
     * behavior of ListFragment is to start with the list not being shown, only
     * showing it once an adapter is given with {@link #setListAdapter(ListAdapter)}.
     * If the list at that point had not been shown, when it does get shown
     * it will be do without the user ever seeing the hidden state.
     * 
     * @param shown If true, the list view is shown; if false, the progress
     * indicator.  The initial value is true.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.097 -0500", hash_original_method = "58A7D31C5F755970E32BD1449250481A", hash_generated_method = "4472EC2324E425D9EB5857C25B77A122")
    
public void setListShown(boolean shown) {
        setListShown(shown, true);
    }
    
    /**
     * Like {@link #setListShown(boolean)}, but no animation is used when
     * transitioning from the previous state.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.099 -0500", hash_original_method = "9A20C5F20729EB8F1D1E26962B6A5257", hash_generated_method = "DB7E0C9414E9CD473D33ECCDC493220B")
    
public void setListShownNoAnimation(boolean shown) {
        setListShown(shown, false);
    }
    
    /**
     * Control whether the list is being displayed.  You can make it not
     * displayed if you are waiting for the initial data to show in it.  During
     * this time an indeterminant progress indicator will be shown instead.
     * 
     * @param shown If true, the list view is shown; if false, the progress
     * indicator.  The initial value is true.
     * @param animate If true, an animation will be used to transition to the
     * new state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.102 -0500", hash_original_method = "01D2A62CF5C9E9D8F31EAD95561BA6AA", hash_generated_method = "FED296308C6FFDA511333418D12AFB73")
    
private void setListShown(boolean shown, boolean animate) {
        ensureList();
        if (mProgressContainer == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (mListShown == shown) {
            return;
        }
        mListShown = shown;
        if (shown) {
            if (animate) {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_out));
                mListContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_in));
            } else {
                mProgressContainer.clearAnimation();
                mListContainer.clearAnimation();
            }
            mProgressContainer.setVisibility(View.GONE);
            mListContainer.setVisibility(View.VISIBLE);
        } else {
            if (animate) {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_in));
                mListContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_out));
            } else {
                mProgressContainer.clearAnimation();
                mListContainer.clearAnimation();
            }
            mProgressContainer.setVisibility(View.VISIBLE);
            mListContainer.setVisibility(View.GONE);
        }
    }
    
    /**
     * Get the ListAdapter associated with this activity's ListView.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.104 -0500", hash_original_method = "6C199B6FBEC38BDF6D031387113C1DD5", hash_generated_method = "F0392D746E5256DD5E352F87E4AB1051")
    
public ListAdapter getListAdapter() {
        return mAdapter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:35.107 -0500", hash_original_method = "E4157ED141058B6B94474E0556BB8B74", hash_generated_method = "E72A4503B14DFCDFF883C80D15414C67")
    
private void ensureList() {
        if (mList != null) {
            return;
        }
        View root = getView();
        if (root == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (root instanceof ListView) {
            mList = (ListView)root;
        } else {
            mStandardEmptyView = (TextView)root.findViewById(
                    com.android.internal.R.id.internalEmpty);
            if (mStandardEmptyView == null) {
                mEmptyView = root.findViewById(android.R.id.empty);
            } else {
                mStandardEmptyView.setVisibility(View.GONE);
            }
            mProgressContainer = root.findViewById(com.android.internal.R.id.progressContainer);
            mListContainer = root.findViewById(com.android.internal.R.id.listContainer);
            View rawListView = root.findViewById(android.R.id.list);
            if (!(rawListView instanceof ListView)) {
                throw new RuntimeException(
                        "Content has view with id attribute 'android.R.id.list' "
                        + "that is not a ListView class");
            }
            mList = (ListView)rawListView;
            if (mList == null) {
                throw new RuntimeException(
                        "Your content must have a ListView whose id attribute is " +
                        "'android.R.id.list'");
            }
            if (mEmptyView != null) {
                mList.setEmptyView(mEmptyView);
            } else if (mEmptyText != null) {
                mStandardEmptyView.setText(mEmptyText);
                mList.setEmptyView(mStandardEmptyView);
            }
        }
        mListShown = true;
        mList.setOnItemClickListener(mOnClickListener);
        if (mAdapter != null) {
            ListAdapter adapter = mAdapter;
            mAdapter = null;
            setListAdapter(adapter);
        } else {
            // We are starting without an adapter, so assume we won't
            // have our data right away and start with the progress indicator.
            if (mProgressContainer != null) {
                setListShown(false, false);
            }
        }
        mHandler.post(mRequestFocus);
    }
    
}

