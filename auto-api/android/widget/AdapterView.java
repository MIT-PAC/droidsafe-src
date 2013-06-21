package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public abstract class AdapterView<T extends Adapter> extends ViewGroup {
    @ViewDebug.ExportedProperty(category = "scrolling") int mFirstPosition = 0;
    int mSpecificTop;
    int mSyncPosition;
    long mSyncRowId = INVALID_ROW_ID;
    long mSyncHeight;
    boolean mNeedSync = false;
    int mSyncMode;
    private int mLayoutHeight;
    boolean mInLayout = false;
    OnItemSelectedListener mOnItemSelectedListener;
    OnItemClickListener mOnItemClickListener;
    OnItemLongClickListener mOnItemLongClickListener;
    boolean mDataChanged;
    @ViewDebug.ExportedProperty(category = "list") int mNextSelectedPosition = INVALID_POSITION;
    long mNextSelectedRowId = INVALID_ROW_ID;
    @ViewDebug.ExportedProperty(category = "list") int mSelectedPosition = INVALID_POSITION;
    long mSelectedRowId = INVALID_ROW_ID;
    private View mEmptyView;
    @ViewDebug.ExportedProperty(category = "list") int mItemCount;
    int mOldItemCount;
    int mOldSelectedPosition = INVALID_POSITION;
    long mOldSelectedRowId = INVALID_ROW_ID;
    private boolean mDesiredFocusableState;
    private boolean mDesiredFocusableInTouchModeState;
    private SelectionNotifier mSelectionNotifier;
    boolean mBlockLayoutRequests = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.131 -0400", hash_original_method = "57FCDFF67BC1DAFCD174DA15B87A1337", hash_generated_method = "76FA426266991BB79EADF66717D0F649")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AdapterView(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.131 -0400", hash_original_method = "A1536CC4437039F5CF27987414A5A415", hash_generated_method = "3B4D2DB6603C115DB677E384A5688A23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AdapterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.131 -0400", hash_original_method = "4DD39388BA45E8CBF534A54DFA59E3BD", hash_generated_method = "1327BDB1A899FA45BA5C8AC57CA46C56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AdapterView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.132 -0400", hash_original_method = "3AA164DD2030E1BF06F3CA1CD9427DA1", hash_generated_method = "2730E79E629D9CEF9B3699FAED65595C")
    @DSModeled(DSC.SAFE)
    public void setOnItemClickListener(OnItemClickListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnItemClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.132 -0400", hash_original_method = "53FBB33228561FD1F46130BA576FD131", hash_generated_method = "6DA04F5AE79793E5221D092CEFE27F74")
    @DSModeled(DSC.SAFE)
    public final OnItemClickListener getOnItemClickListener() {
        return (OnItemClickListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mOnItemClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.132 -0400", hash_original_method = "60B3F62567C83CF5181D16CCAFD621F4", hash_generated_method = "67B209799B4C12B319687EA82A8662EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performItemClick(View view, int position, long id) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(position);
        dsTaint.addTaint(view.dsTaint);
        {
            playSoundEffect(SoundEffectConstants.CLICK);
            {
                view.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
            } //End block
            mOnItemClickListener.onItemClick(this, view, position, id);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mOnItemClickListener != null) {
            //playSoundEffect(SoundEffectConstants.CLICK);
            //if (view != null) {
                //view.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
            //}
            //mOnItemClickListener.onItemClick(this, view, position, id);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.132 -0400", hash_original_method = "8890007B6750F9F3A0AF363421C33470", hash_generated_method = "0B1030237D91D012816DA838755791A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            boolean var4E9822764F29F607F332912995A375BC_1508457301 = (!isLongClickable());
            {
                setLongClickable(true);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isLongClickable()) {
            //setLongClickable(true);
        //}
        //mOnItemLongClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.132 -0400", hash_original_method = "450D7DEA9BB200CD772C171D001DF2F0", hash_generated_method = "537501AFA383BC0ACE4064761D878ADE")
    @DSModeled(DSC.SAFE)
    public final OnItemLongClickListener getOnItemLongClickListener() {
        return (OnItemLongClickListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mOnItemLongClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.132 -0400", hash_original_method = "9092AD2A5F83CE601E3913D803C386F2", hash_generated_method = "A2F01420A320F6D5C66EAE5F44861512")
    @DSModeled(DSC.SAFE)
    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnItemSelectedListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.133 -0400", hash_original_method = "C1B2E8F5BC8E80BA634AE326A645C328", hash_generated_method = "828AEEBAC57F93378E9F920501C45D34")
    @DSModeled(DSC.SAFE)
    public final OnItemSelectedListener getOnItemSelectedListener() {
        return (OnItemSelectedListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mOnItemSelectedListener;
    }

    
    public abstract T getAdapter();

    
    public abstract void setAdapter(T adapter);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.133 -0400", hash_original_method = "F16CCCAA9B27A0794F506D96FD601909", hash_generated_method = "80F6EC2010FE6FED549F619C945C9A3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addView(View child) {
        dsTaint.addTaint(child.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.133 -0400", hash_original_method = "A0B74413A848464618EA89DE3FE41FDC", hash_generated_method = "EA49271F0813B40CBAE762217965096A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addView(View child, int index) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.133 -0400", hash_original_method = "18B2907968F7312EE2BBDDA25EF143B2", hash_generated_method = "8220AC8DF942B85366A849BF6FB25DAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addView(View child, LayoutParams params) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("addView(View, LayoutParams) "
                + "is not supported in AdapterView");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("addView(View, LayoutParams) "
                //+ "is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.133 -0400", hash_original_method = "ECB319B81CB6A3F46E583210A29BAF16", hash_generated_method = "510596887D23CBE504287A3EBC3F37DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addView(View child, int index, LayoutParams params) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        dsTaint.addTaint(params.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("addView(View, int, LayoutParams) "
                + "is not supported in AdapterView");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("addView(View, int, LayoutParams) "
                //+ "is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.134 -0400", hash_original_method = "886BA97B45AC28A61B534339E77983B5", hash_generated_method = "087965F196D0D1CB8CC15D17C9E1FDCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void removeView(View child) {
        dsTaint.addTaint(child.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.134 -0400", hash_original_method = "EB15614617786EFEBA3A034D912AA71E", hash_generated_method = "FB2A87AF935E8AE6BCFA6DFD4F892EDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void removeViewAt(int index) {
        dsTaint.addTaint(index);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.134 -0400", hash_original_method = "F33294BE6C28FDF867EC6161A7E416F0", hash_generated_method = "7B3E7F45AB92E9FDE7B41CDFC06F8C22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void removeAllViews() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.134 -0400", hash_original_method = "5EA85597DECD951B7F4C51D999F17C5D", hash_generated_method = "D4FD16C06692F828F508D6AFE1E4B022")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        dsTaint.addTaint(changed);
        mLayoutHeight = getHeight();
        // ---------- Original Method ----------
        //mLayoutHeight = getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.134 -0400", hash_original_method = "40CA9E4E71293F3BC1D33E874AD305A1", hash_generated_method = "E5333976162F458A10BEE79FFD155B4C")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNextSelectedPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.134 -0400", hash_original_method = "52C80BDBAB2E8D6D945028E83F843260", hash_generated_method = "5560BC0E1FD344D5198585D1E6415203")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mNextSelectedRowId;
    }

    
    public abstract View getSelectedView();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.135 -0400", hash_original_method = "F45E40D646583F63F7A00B28C1D0B4AE", hash_generated_method = "8D0B48E5B51A77398B62FE43B5303205")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getSelectedItem() {
        T adapter;
        adapter = getAdapter();
        int selection;
        selection = getSelectedItemPosition();
        {
            boolean varC431EBC257F1DAB69F88175BCB5250FC_302689200 = (adapter != null && adapter.getCount() > 0 && selection >= 0);
            {
                Object varE8050918912787131FDE6ED7E0F431BB_1216239592 = (adapter.getItem(selection));
            } //End block
        } //End collapsed parenthetic
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //int selection = getSelectedItemPosition();
        //if (adapter != null && adapter.getCount() > 0 && selection >= 0) {
            //return adapter.getItem(selection);
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.135 -0400", hash_original_method = "C515244CDC30F9529A71B0CAA70231C3", hash_generated_method = "46FD6B5B047F56CEAD04646FBAFA928E")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mItemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.135 -0400", hash_original_method = "7F8A3609232C6E4C7447DF803294CB0C", hash_generated_method = "8255C97A26E6A4EF0E7840C340EB9612")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPositionForView(View view) {
        dsTaint.addTaint(view.dsTaint);
        View listItem;
        listItem = view;
        try 
        {
            View v;
            {
                boolean varE341D27A264F3482D6A76BDFDFF68A64_336931556 = (!(v = (View) listItem.getParent()).equals(this));
                {
                    listItem = v;
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ClassCastException e)
        { }
        int childCount;
        childCount = getChildCount();
        {
            int i;
            i = 0;
            {
                {
                    boolean varAB7E8859D0826E12EC53AD21DB274535_2027637006 = (getChildAt(i).equals(listItem));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //View listItem = view;
        //try {
            //View v;
            //while (!(v = (View) listItem.getParent()).equals(this)) {
                //listItem = v;
            //}
        //} catch (ClassCastException e) {
            //return INVALID_POSITION;
        //}
        //final int childCount = getChildCount();
        //for (int i = 0; i < childCount; i++) {
            //if (getChildAt(i).equals(listItem)) {
                //return mFirstPosition + i;
            //}
        //}
        //return INVALID_POSITION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.135 -0400", hash_original_method = "3F582E36FEB434C42F8F2A7A83CA506D", hash_generated_method = "1E7A95F318A20F3BD79D2EE55E203429")
    @DSModeled(DSC.SAFE)
    public int getFirstVisiblePosition() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFirstPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.135 -0400", hash_original_method = "E5B0A16A7A6C9870BA6F980F2DB39BC0", hash_generated_method = "CBAB9F918D922C92C9EFB2824488100B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLastVisiblePosition() {
        int var502BAFD3638A317DEFA14DE990B7A10C_1428952808 = (mFirstPosition + getChildCount() - 1);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFirstPosition + getChildCount() - 1;
    }

    
    public abstract void setSelection(int position);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.136 -0400", hash_original_method = "0D2B56D1373B44CFA7E95FC0E87B79DB", hash_generated_method = "C9A7DEF1D20FA139398778C0679C634E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void setEmptyView(View emptyView) {
        dsTaint.addTaint(emptyView.dsTaint);
        T adapter;
        adapter = getAdapter();
        boolean empty;
        empty = ((adapter == null) || adapter.isEmpty());
        updateEmptyStatus(empty);
        // ---------- Original Method ----------
        //mEmptyView = emptyView;
        //final T adapter = getAdapter();
        //final boolean empty = ((adapter == null) || adapter.isEmpty());
        //updateEmptyStatus(empty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.136 -0400", hash_original_method = "1914B98508B1C21B71F42F5D07F0BF47", hash_generated_method = "791F04EE90C32B180B35F64FC4D2FD36")
    @DSModeled(DSC.SAFE)
    public View getEmptyView() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mEmptyView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.136 -0400", hash_original_method = "FD285526E2677013E6DDAFB01C953F85", hash_generated_method = "CE87187DE585FF484FDDDE9355E82304")
    @DSModeled(DSC.SAFE)
     boolean isInFilterMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.136 -0400", hash_original_method = "2405FD914E83FFA9F0D8BC78F36E017E", hash_generated_method = "9FB84FBB8F741BCBD425BE540CB591EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setFocusable(boolean focusable) {
        dsTaint.addTaint(focusable);
        T adapter;
        adapter = getAdapter();
        boolean empty;
        empty = adapter == null || adapter.getCount() == 0;
        {
            mDesiredFocusableInTouchModeState = false;
        } //End block
        super.setFocusable(focusable && (!empty || isInFilterMode()));
        // ---------- Original Method ----------
        //final T adapter = getAdapter();
        //final boolean empty = adapter == null || adapter.getCount() == 0;
        //mDesiredFocusableState = focusable;
        //if (!focusable) {
            //mDesiredFocusableInTouchModeState = false;
        //}
        //super.setFocusable(focusable && (!empty || isInFilterMode()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.137 -0400", hash_original_method = "510CB97D998AEB67CD24BEC214B467D4", hash_generated_method = "AADD050321416F7579402634F23EA643")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setFocusableInTouchMode(boolean focusable) {
        dsTaint.addTaint(focusable);
        T adapter;
        adapter = getAdapter();
        boolean empty;
        empty = adapter == null || adapter.getCount() == 0;
        {
            mDesiredFocusableState = true;
        } //End block
        super.setFocusableInTouchMode(focusable && (!empty || isInFilterMode()));
        // ---------- Original Method ----------
        //final T adapter = getAdapter();
        //final boolean empty = adapter == null || adapter.getCount() == 0;
        //mDesiredFocusableInTouchModeState = focusable;
        //if (focusable) {
            //mDesiredFocusableState = true;
        //}
        //super.setFocusableInTouchMode(focusable && (!empty || isInFilterMode()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.137 -0400", hash_original_method = "247C1C860FE83D8C6969E8D7AD161A84", hash_generated_method = "34214D909D342D706EB49D1E32B9A23E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void checkFocus() {
        T adapter;
        adapter = getAdapter();
        boolean empty;
        empty = adapter == null || adapter.getCount() == 0;
        boolean focusable;
        focusable = !empty || isInFilterMode();
        super.setFocusableInTouchMode(focusable && mDesiredFocusableInTouchModeState);
        super.setFocusable(focusable && mDesiredFocusableState);
        {
            updateEmptyStatus((adapter == null) || adapter.isEmpty());
        } //End block
        // ---------- Original Method ----------
        //final T adapter = getAdapter();
        //final boolean empty = adapter == null || adapter.getCount() == 0;
        //final boolean focusable = !empty || isInFilterMode();
        //super.setFocusableInTouchMode(focusable && mDesiredFocusableInTouchModeState);
        //super.setFocusable(focusable && mDesiredFocusableState);
        //if (mEmptyView != null) {
            //updateEmptyStatus((adapter == null) || adapter.isEmpty());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.137 -0400", hash_original_method = "3E542C38250D34B64375C7B9ACE53374", hash_generated_method = "BEB1960374F41E671ED8AB9350873675")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateEmptyStatus(boolean empty) {
        dsTaint.addTaint(empty);
        {
            boolean varF35CB9186B7E386AC3090FFD7A78DB53_1684980326 = (isInFilterMode());
            {
                empty = false;
            } //End block
        } //End collapsed parenthetic
        {
            {
                mEmptyView.setVisibility(View.VISIBLE);
                setVisibility(View.GONE);
            } //End block
            {
                setVisibility(View.VISIBLE);
            } //End block
            {
                this.onLayout(false, mLeft, mTop, mRight, mBottom);
            } //End block
        } //End block
        {
            mEmptyView.setVisibility(View.GONE);
            setVisibility(View.VISIBLE);
        } //End block
        // ---------- Original Method ----------
        //if (isInFilterMode()) {
            //empty = false;
        //}
        //if (empty) {
            //if (mEmptyView != null) {
                //mEmptyView.setVisibility(View.VISIBLE);
                //setVisibility(View.GONE);
            //} else {
                //setVisibility(View.VISIBLE);
            //}
            //if (mDataChanged) {           
                //this.onLayout(false, mLeft, mTop, mRight, mBottom); 
            //}
        //} else {
            //if (mEmptyView != null) mEmptyView.setVisibility(View.GONE);
            //setVisibility(View.VISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.138 -0400", hash_original_method = "D3C6D351E34AE1C5D83960F098A550AE", hash_generated_method = "3DCD9BB2869BD58F859C44BE8CC76288")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getItemAtPosition(int position) {
        dsTaint.addTaint(position);
        T adapter;
        adapter = getAdapter();
        {
            Object var9E4BD85BFCA3C1ACF1685F0753798E30_859839057 = (adapter.getItem(position));
        } //End flattened ternary
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //return (adapter == null || position < 0) ? null : adapter.getItem(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.138 -0400", hash_original_method = "1B8B19ED8D728A74BB7DD4694FA31397", hash_generated_method = "696C2C904045089FF69FFF2D800873C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getItemIdAtPosition(int position) {
        dsTaint.addTaint(position);
        T adapter;
        adapter = getAdapter();
        {
            Object var97E149A12F4F82A568B3B77523943250_1327243556 = (adapter.getItemId(position));
        } //End flattened ternary
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //return (adapter == null || position < 0) ? INVALID_ROW_ID : adapter.getItemId(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.138 -0400", hash_original_method = "1A557FA8FE05A519D86B900EB24DF4D7", hash_generated_method = "9791FA6BE3B1879E87045DE8C291DD79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setOnClickListener(OnClickListener l) {
        dsTaint.addTaint(l.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Don't call setOnClickListener for an AdapterView. "
                + "You probably want setOnItemClickListener instead");
        // ---------- Original Method ----------
        //throw new RuntimeException("Don't call setOnClickListener for an AdapterView. "
                //+ "You probably want setOnItemClickListener instead");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.138 -0400", hash_original_method = "0F3E63187E008FDE1692E75AF7E8484F", hash_generated_method = "6B8831D37E64EA8DEB3135196CED0FC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        dispatchFreezeSelfOnly(container);
        // ---------- Original Method ----------
        //dispatchFreezeSelfOnly(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.138 -0400", hash_original_method = "3B9D7DC916535DA1F64238687579C1A4", hash_generated_method = "73C4D905A5C52E93115E715065730A26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        dispatchThawSelfOnly(container);
        // ---------- Original Method ----------
        //dispatchThawSelfOnly(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.139 -0400", hash_original_method = "8130EF0B42BA515F653DEDC83DE0BC01", hash_generated_method = "8B173CA825B846127BB6829734ADDC00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        removeCallbacks(mSelectionNotifier);
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //removeCallbacks(mSelectionNotifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.139 -0400", hash_original_method = "BC6042705725732210E15D64CD41C7D9", hash_generated_method = "2C994AB19E75247557B6A914A8CF444D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void selectionChanged() {
        {
            {
                {
                    mSelectionNotifier = new SelectionNotifier();
                } //End block
                post(mSelectionNotifier);
            } //End block
            {
                fireOnSelected();
            } //End block
        } //End block
        {
            boolean var5C1F0A052282BDFB4F8B56B7331CF594_513271059 = (mSelectedPosition != ListView.INVALID_POSITION && isShown() && !isInTouchMode());
            {
                sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mOnItemSelectedListener != null) {
            //if (mInLayout || mBlockLayoutRequests) {
                //if (mSelectionNotifier == null) {
                    //mSelectionNotifier = new SelectionNotifier();
                //}
                //post(mSelectionNotifier);
            //} else {
                //fireOnSelected();
            //}
        //}
        //if (mSelectedPosition != ListView.INVALID_POSITION && isShown() && !isInTouchMode()) {
            //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.139 -0400", hash_original_method = "02337B5D029912B3F89D3F5D70F11AFE", hash_generated_method = "5209C9FA757C7C3C94F7FDDD5A7801CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void fireOnSelected() {
        int selection;
        selection = this.getSelectedItemPosition();
        {
            View v;
            v = getSelectedView();
            mOnItemSelectedListener.onItemSelected(this, v, selection,
                    getAdapter().getItemId(selection));
        } //End block
        {
            mOnItemSelectedListener.onNothingSelected(this);
        } //End block
        // ---------- Original Method ----------
        //if (mOnItemSelectedListener == null)
            //return;
        //int selection = this.getSelectedItemPosition();
        //if (selection >= 0) {
            //View v = getSelectedView();
            //mOnItemSelectedListener.onItemSelected(this, v, selection,
                    //getAdapter().getItemId(selection));
        //} else {
            //mOnItemSelectedListener.onNothingSelected(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.139 -0400", hash_original_method = "2ECE900C628E5D932F56A2139561AD87", hash_generated_method = "542D1C460051F3EC53AD2C2099F9EB0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        View selectedView;
        selectedView = getSelectedView();
        {
            boolean varAB0D18640FD723634A00876A9A643B2A_1215442327 = (selectedView != null && selectedView.getVisibility() == VISIBLE
                && selectedView.dispatchPopulateAccessibilityEvent(event));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //View selectedView = getSelectedView();
        //if (selectedView != null && selectedView.getVisibility() == VISIBLE
                //&& selectedView.dispatchPopulateAccessibilityEvent(event)) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.140 -0400", hash_original_method = "6C132B6F44CAB6ECEF4D7E674DFB11BC", hash_generated_method = "06274750445774BB9EAB0BAE45E32F12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varFFC657A579ED797FAC38E2B4B1796721_1725812698 = (super.onRequestSendAccessibilityEvent(child, event));
            {
                AccessibilityEvent record;
                record = AccessibilityEvent.obtain();
                onInitializeAccessibilityEvent(record);
                child.dispatchPopulateAccessibilityEvent(record);
                event.appendRecord(record);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (super.onRequestSendAccessibilityEvent(child, event)) {
            //AccessibilityEvent record = AccessibilityEvent.obtain();
            //onInitializeAccessibilityEvent(record);
            //child.dispatchPopulateAccessibilityEvent(record);
            //event.appendRecord(record);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.140 -0400", hash_original_method = "A92D1861287ECAEDED59E2308FF3FC59", hash_generated_method = "4838EDBD1FE9D871BD9679D7FC9BEAF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(info.dsTaint);
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(isScrollableForAccessibility());
        View selectedView;
        selectedView = getSelectedView();
        {
            info.setEnabled(selectedView.isEnabled());
        } //End block
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //info.setScrollable(isScrollableForAccessibility());
        //View selectedView = getSelectedView();
        //if (selectedView != null) {
            //info.setEnabled(selectedView.isEnabled());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.140 -0400", hash_original_method = "73EE58FB2C3D5181C9EEF91D06B60047", hash_generated_method = "F5D4A81BE5EE8645E450906773BD507C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(isScrollableForAccessibility());
        View selectedView;
        selectedView = getSelectedView();
        {
            event.setEnabled(selectedView.isEnabled());
        } //End block
        event.setCurrentItemIndex(getSelectedItemPosition());
        event.setFromIndex(getFirstVisiblePosition());
        event.setToIndex(getLastVisiblePosition());
        event.setItemCount(getCount());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setScrollable(isScrollableForAccessibility());
        //View selectedView = getSelectedView();
        //if (selectedView != null) {
            //event.setEnabled(selectedView.isEnabled());
        //}
        //event.setCurrentItemIndex(getSelectedItemPosition());
        //event.setFromIndex(getFirstVisiblePosition());
        //event.setToIndex(getLastVisiblePosition());
        //event.setItemCount(getCount());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.141 -0400", hash_original_method = "1A6615688A72EC8D9F005EEFA4CD86A3", hash_generated_method = "8030F47C13BE2DD4A03802391BF09D7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isScrollableForAccessibility() {
        T adapter;
        adapter = getAdapter();
        {
            int itemCount;
            itemCount = adapter.getCount();
            boolean var0CADBBA3C9973A4C32A29A1A7D305AA3_1652085645 = (itemCount > 0
                && (getFirstVisiblePosition() > 0 || getLastVisiblePosition() < itemCount - 1));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //if (adapter != null) {
            //final int itemCount = adapter.getCount();
            //return itemCount > 0
                //&& (getFirstVisiblePosition() > 0 || getLastVisiblePosition() < itemCount - 1);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.141 -0400", hash_original_method = "F40AC428F4D570BD34339564A5B5BB04", hash_generated_method = "06BB5846F9FD8BBF87C4E4FFD40FD624")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean canAnimate() {
        boolean varDA480D2F8FF037BACA5DB54A8FBF9642_2138168514 = (super.canAnimate() && mItemCount > 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.canAnimate() && mItemCount > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.141 -0400", hash_original_method = "E1C2247A84AC5366AD699C7DB3F92349", hash_generated_method = "3793C88056766A8AEA525957AC559964")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void handleDataChanged() {
        int count;
        count = mItemCount;
        boolean found;
        found = false;
        {
            int newPos;
            {
                mNeedSync = false;
                newPos = findSyncPosition();
                {
                    int selectablePos;
                    selectablePos = lookForSelectablePosition(newPos, true);
                    {
                        setNextSelectedPositionInt(newPos);
                        found = true;
                    } //End block
                } //End block
            } //End block
            {
                newPos = getSelectedItemPosition();
                {
                    newPos = count - 1;
                } //End block
                {
                    newPos = 0;
                } //End block
                int selectablePos;
                selectablePos = lookForSelectablePosition(newPos, true);
                {
                    selectablePos = lookForSelectablePosition(newPos, false);
                } //End block
                {
                    setNextSelectedPositionInt(selectablePos);
                    checkSelectionChanged();
                    found = true;
                } //End block
            } //End block
        } //End block
        {
            mSelectedPosition = INVALID_POSITION;
            mSelectedRowId = INVALID_ROW_ID;
            mNextSelectedPosition = INVALID_POSITION;
            mNextSelectedRowId = INVALID_ROW_ID;
            mNeedSync = false;
            checkSelectionChanged();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.141 -0400", hash_original_method = "25705A5902194616A467B0383F1D3CBC", hash_generated_method = "C4F0AB53E38DFFA650B0899EA0C97EF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void checkSelectionChanged() {
        {
            selectionChanged();
            mOldSelectedPosition = mSelectedPosition;
            mOldSelectedRowId = mSelectedRowId;
        } //End block
        // ---------- Original Method ----------
        //if ((mSelectedPosition != mOldSelectedPosition) || (mSelectedRowId != mOldSelectedRowId)) {
            //selectionChanged();
            //mOldSelectedPosition = mSelectedPosition;
            //mOldSelectedRowId = mSelectedRowId;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.142 -0400", hash_original_method = "40C5EABEA31AF953B54DF3485AA93D4F", hash_generated_method = "0DBF8FDDE941B5DF1755AE1E61E73DFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int findSyncPosition() {
        int count;
        count = mItemCount;
        long idToMatch;
        idToMatch = mSyncRowId;
        int seed;
        seed = mSyncPosition;
        seed = Math.max(0, seed);
        seed = Math.min(count - 1, seed);
        long endTime;
        endTime = SystemClock.uptimeMillis() + SYNC_MAX_DURATION_MILLIS;
        long rowId;
        int first;
        first = seed;
        int last;
        last = seed;
        boolean next;
        next = false;
        boolean hitFirst;
        boolean hitLast;
        T adapter;
        adapter = getAdapter();
        {
            boolean var456DAD1228A2E995CDD3C7508B2D1BC6_376625046 = (SystemClock.uptimeMillis() <= endTime);
            {
                rowId = adapter.getItemId(seed);
                hitLast = last == count - 1;
                hitFirst = first == 0;
                {
                    seed = last;
                    next = false;
                } //End block
                {
                    seed = first;
                    next = true;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.142 -0400", hash_original_method = "63DA3BDCCF3458E05F2C2D5853C22A6D", hash_generated_method = "9C67BD4F98FF4E66B2696E61190A3F66")
    @DSModeled(DSC.SAFE)
     int lookForSelectablePosition(int position, boolean lookDown) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(lookDown);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.142 -0400", hash_original_method = "DDA5E37B089AD4C213077E832500B341", hash_generated_method = "54872F8945F75C6C9088BF45669F4DDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setSelectedPositionInt(int position) {
        dsTaint.addTaint(position);
        mSelectedRowId = getItemIdAtPosition(position);
        // ---------- Original Method ----------
        //mSelectedPosition = position;
        //mSelectedRowId = getItemIdAtPosition(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.142 -0400", hash_original_method = "8F63B2D5F340C4F249BDEC055C5E8E67", hash_generated_method = "58B5DE2A52C5E977DA77BB2126EF37AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setNextSelectedPositionInt(int position) {
        dsTaint.addTaint(position);
        mNextSelectedRowId = getItemIdAtPosition(position);
        {
            mSyncRowId = mNextSelectedRowId;
        } //End block
        // ---------- Original Method ----------
        //mNextSelectedPosition = position;
        //mNextSelectedRowId = getItemIdAtPosition(position);
        //if (mNeedSync && mSyncMode == SYNC_SELECTED_POSITION && position >= 0) {
            //mSyncPosition = position;
            //mSyncRowId = mNextSelectedRowId;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.143 -0400", hash_original_method = "1A0C0740A6F6610404D57CE1BAD32EA0", hash_generated_method = "25C51B22BDD694B7D39DEA8AF497CD1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void rememberSyncState() {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1198958955 = (getChildCount() > 0);
            {
                mNeedSync = true;
                mSyncHeight = mLayoutHeight;
                {
                    View v;
                    v = getChildAt(mSelectedPosition - mFirstPosition);
                    mSyncRowId = mNextSelectedRowId;
                    mSyncPosition = mNextSelectedPosition;
                    {
                        mSpecificTop = v.getTop();
                    } //End block
                    mSyncMode = SYNC_SELECTED_POSITION;
                } //End block
                {
                    View v;
                    v = getChildAt(0);
                    T adapter;
                    adapter = getAdapter();
                    {
                        boolean var4513742AC4398C98A59B8301E0BEEF78_1017525719 = (mFirstPosition >= 0 && mFirstPosition < adapter.getCount());
                        {
                            mSyncRowId = adapter.getItemId(mFirstPosition);
                        } //End block
                        {
                            mSyncRowId = NO_ID;
                        } //End block
                    } //End collapsed parenthetic
                    mSyncPosition = mFirstPosition;
                    {
                        mSpecificTop = v.getTop();
                    } //End block
                    mSyncMode = SYNC_FIRST_POSITION;
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class AdapterContextMenuInfo implements ContextMenu.ContextMenuInfo {
        public View targetView;
        public int position;
        public long id;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.143 -0400", hash_original_method = "4451CA35940742220E7BA55A02F436E7", hash_generated_method = "87F245F097FA0C5AD86B69E360AA2B47")
        @DSModeled(DSC.SAFE)
        public AdapterContextMenuInfo(View targetView, int position, long id) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(position);
            dsTaint.addTaint(targetView.dsTaint);
            // ---------- Original Method ----------
            //this.targetView = targetView;
            //this.position = position;
            //this.id = id;
        }

        
    }


    
    class AdapterDataSetObserver extends DataSetObserver {
        private Parcelable mInstanceState = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.144 -0400", hash_original_method = "273FED591BB98950FDD1BF5E03A12471", hash_generated_method = "273FED591BB98950FDD1BF5E03A12471")
                public AdapterDataSetObserver ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.144 -0400", hash_original_method = "26DD6C25DA2F390817D1ECC15F4F8536", hash_generated_method = "D42175F69880FCC541823A9FF3BED63F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDataChanged = true;
            mOldItemCount = mItemCount;
            mItemCount = getAdapter().getCount();
            {
                boolean var863BC7806B599EEA548F40281B88AA1A_1320033303 = (AdapterView.this.getAdapter().hasStableIds() && mInstanceState != null
                    && mOldItemCount == 0 && mItemCount > 0);
                {
                    AdapterView.this.onRestoreInstanceState(mInstanceState);
                    mInstanceState = null;
                } //End block
                {
                    rememberSyncState();
                } //End block
            } //End collapsed parenthetic
            checkFocus();
            requestLayout();
            // ---------- Original Method ----------
            //mDataChanged = true;
            //mOldItemCount = mItemCount;
            //mItemCount = getAdapter().getCount();
            //if (AdapterView.this.getAdapter().hasStableIds() && mInstanceState != null
                    //&& mOldItemCount == 0 && mItemCount > 0) {
                //AdapterView.this.onRestoreInstanceState(mInstanceState);
                //mInstanceState = null;
            //} else {
                //rememberSyncState();
            //}
            //checkFocus();
            //requestLayout();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.145 -0400", hash_original_method = "384362603CD3BC78F8E9701AA98D7AA3", hash_generated_method = "B905800A06D9127E403A240C2A665AA3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDataChanged = true;
            {
                boolean var7489B38452FA33CED2860E46905E6201_1024294996 = (AdapterView.this.getAdapter().hasStableIds());
                {
                    mInstanceState = AdapterView.this.onSaveInstanceState();
                } //End block
            } //End collapsed parenthetic
            mOldItemCount = mItemCount;
            mItemCount = 0;
            mSelectedPosition = INVALID_POSITION;
            mSelectedRowId = INVALID_ROW_ID;
            mNextSelectedPosition = INVALID_POSITION;
            mNextSelectedRowId = INVALID_ROW_ID;
            mNeedSync = false;
            checkFocus();
            requestLayout();
            // ---------- Original Method ----------
            //mDataChanged = true;
            //if (AdapterView.this.getAdapter().hasStableIds()) {
                //mInstanceState = AdapterView.this.onSaveInstanceState();
            //}
            //mOldItemCount = mItemCount;
            //mItemCount = 0;
            //mSelectedPosition = INVALID_POSITION;
            //mSelectedRowId = INVALID_ROW_ID;
            //mNextSelectedPosition = INVALID_POSITION;
            //mNextSelectedRowId = INVALID_ROW_ID;
            //mNeedSync = false;
            //checkFocus();
            //requestLayout();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.145 -0400", hash_original_method = "FEB1A2B1EE4CD2130FB08EC4E4CC489E", hash_generated_method = "45FAE979B6EF5255E98919F10948FE73")
        @DSModeled(DSC.SAFE)
        public void clearSavedState() {
            mInstanceState = null;
            // ---------- Original Method ----------
            //mInstanceState = null;
        }

        
    }


    
    private class SelectionNotifier implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.146 -0400", hash_original_method = "312D8E9DCD4DDE02E517740F17432542", hash_generated_method = "312D8E9DCD4DDE02E517740F17432542")
                public SelectionNotifier ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.146 -0400", hash_original_method = "D0BC3F1278F7B077D905A46BC661B1BD", hash_generated_method = "8893B58606098D462BC0C44FA2F859E9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                {
                    boolean var6E1AA78244E28A1874D7E5FE58FB0DD3_2139343085 = (getAdapter() != null);
                    {
                        post(this);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                fireOnSelected();
            } //End block
            // ---------- Original Method ----------
            //if (mDataChanged) {
                //if (getAdapter() != null) {
                    //post(this);
                //}
            //} else {
                //fireOnSelected();
            //}
        }

        
    }


    
    public interface OnItemClickListener {

        
        void onItemClick(AdapterView<?> parent, View view, int position, long id);
    }
    
    public interface OnItemLongClickListener {
        
        boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id);
    }
    
    public interface OnItemSelectedListener {
        
        void onItemSelected(AdapterView<?> parent, View view, int position, long id);

        
        void onNothingSelected(AdapterView<?> parent);
    }
    
    public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    static final int SYNC_SELECTED_POSITION = 0;
    static final int SYNC_FIRST_POSITION = 1;
    static final int SYNC_MAX_DURATION_MILLIS = 100;
    public static final int INVALID_POSITION = -1;
    public static final long INVALID_ROW_ID = Long.MIN_VALUE;
}

