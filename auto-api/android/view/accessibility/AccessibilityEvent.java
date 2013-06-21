package android.view.accessibility;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class AccessibilityEvent extends AccessibilityRecord implements Parcelable {
    private AccessibilityEvent mNext;
    private boolean mIsInPool;
    private int mEventType;
    private CharSequence mPackageName;
    private long mEventTime;
    private ArrayList<AccessibilityRecord> mRecords = new ArrayList<AccessibilityRecord>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.790 -0400", hash_original_method = "851763ED22FDC1F823C000B96565E393", hash_generated_method = "6EADCF7C93B43CCEF55BB13CB1733BA7")
    @DSModeled(DSC.SAFE)
    private AccessibilityEvent() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.790 -0400", hash_original_method = "EF53A9AEF549006E04C5A25F56401EE0", hash_generated_method = "A32369B052A65EDB001FF9BA0326E46A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void init(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        super.init(event);
        mEventType = event.mEventType;
        mEventTime = event.mEventTime;
        mPackageName = event.mPackageName;
        // ---------- Original Method ----------
        //super.init(event);
        //mEventType = event.mEventType;
        //mEventTime = event.mEventTime;
        //mPackageName = event.mPackageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.791 -0400", hash_original_method = "86DBA4ADDEC94CD24AE35AA90BF3A59E", hash_generated_method = "E8F927074E376AF060CDEC42EDEEF0FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSealed(boolean sealed) {
        dsTaint.addTaint(sealed);
        super.setSealed(sealed);
        List<AccessibilityRecord> records;
        records = mRecords;
        int recordCount;
        recordCount = records.size();
        {
            int i;
            i = 0;
            {
                AccessibilityRecord record;
                record = records.get(i);
                record.setSealed(sealed);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.setSealed(sealed);
        //List<AccessibilityRecord> records = mRecords;
        //final int recordCount = records.size();
        //for (int i = 0; i < recordCount; i++) {
            //AccessibilityRecord record = records.get(i);
            //record.setSealed(sealed);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.791 -0400", hash_original_method = "E3578B8B8EBF3C6DE3B4CEB5DF2FD3A0", hash_generated_method = "FB88C83A4DC6226197588D6A0A11FF2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRecordCount() {
        int varCBF5629F1D9D3BD9F735EE647C7DA0D7_1535995817 = (mRecords.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRecords.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.791 -0400", hash_original_method = "65BE24FB8BF3EB0B7B54A7C4AA9FE110", hash_generated_method = "57B08C44B6DF0342DDA381B5A8A89EA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void appendRecord(AccessibilityRecord record) {
        dsTaint.addTaint(record.dsTaint);
        enforceNotSealed();
        mRecords.add(record);
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mRecords.add(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.792 -0400", hash_original_method = "9E2314A76EC6019735F4372CBF34D41F", hash_generated_method = "A24FEF1F3B37C33019F0B86CA6F1E00C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessibilityRecord getRecord(int index) {
        dsTaint.addTaint(index);
        AccessibilityRecord varC2690A3730A8AD28F42B34B5D68D2F89_1859835808 = (mRecords.get(index));
        return (AccessibilityRecord)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRecords.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.792 -0400", hash_original_method = "4F017DE4F3DB5F93E271E04CA9550DB1", hash_generated_method = "683BDA46D1DD3CA147673F61784CE2D5")
    @DSModeled(DSC.SAFE)
    public int getEventType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEventType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.792 -0400", hash_original_method = "5683B1405AEA65ED0491BE91FD34C2FA", hash_generated_method = "48EECDC561D17924FAAD71BBC81F9C94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEventType(int eventType) {
        dsTaint.addTaint(eventType);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mEventType = eventType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.792 -0400", hash_original_method = "9909149D86C7172035BFD4D31C880F99", hash_generated_method = "1DCC521E466C482483526F2D2DA1ED9F")
    @DSModeled(DSC.SAFE)
    public long getEventTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mEventTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.792 -0400", hash_original_method = "D3F4C692FA45FB670DB263BA6C6ECFB3", hash_generated_method = "7A0267F42AE3C08DDD81C8E738B745FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEventTime(long eventTime) {
        dsTaint.addTaint(eventTime);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mEventTime = eventTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.793 -0400", hash_original_method = "6D18CADAD3BE855C953B6A82043EA347", hash_generated_method = "CD722F946C542A3B895B3882B105FF9E")
    @DSModeled(DSC.SAFE)
    public CharSequence getPackageName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.793 -0400", hash_original_method = "D35D1C42C7BD5A2BDF03FC6BDBDF64EE", hash_generated_method = "94F40AC64FAB7A22E2507BB659B7B7D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPackageName(CharSequence packageName) {
        dsTaint.addTaint(packageName);
        enforceNotSealed();
        // ---------- Original Method ----------
        //enforceNotSealed();
        //mPackageName = packageName;
    }

    
        public static AccessibilityEvent obtain(int eventType) {
        AccessibilityEvent event = AccessibilityEvent.obtain();
        event.setEventType(eventType);
        return event;
    }

    
        public static AccessibilityEvent obtain(AccessibilityEvent event) {
        AccessibilityEvent eventClone = AccessibilityEvent.obtain();
        eventClone.init(event);
        final int recordCount = event.mRecords.size();
        for (int i = 0; i < recordCount; i++) {
            AccessibilityRecord record = event.mRecords.get(i);
            AccessibilityRecord recordClone = AccessibilityRecord.obtain(record);
            eventClone.mRecords.add(recordClone);
        }
        return eventClone;
    }

    
        public static AccessibilityEvent obtain() {
        synchronized (sPoolLock) {
            if (sPool != null) {
                AccessibilityEvent event = sPool;
                sPool = sPool.mNext;
                sPoolSize--;
                event.mNext = null;
                event.mIsInPool = false;
                return event;
            }
            return new AccessibilityEvent();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.795 -0400", hash_original_method = "74951363C7DF24AC8EB3BEFEC94F56A2", hash_generated_method = "F79FD03343689E2173CAEBFDE9B7B987")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void recycle() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Event already recycled!");
        } //End block
        clear();
        {
            {
                mNext = sPool;
                sPool = this;
                mIsInPool = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mIsInPool) {
            //throw new IllegalStateException("Event already recycled!");
        //}
        //clear();
        //synchronized (sPoolLock) {
            //if (sPoolSize <= MAX_POOL_SIZE) {
                //mNext = sPool;
                //sPool = this;
                //mIsInPool = true;
                //sPoolSize++;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.795 -0400", hash_original_method = "4C3D5B3E8C94F161E20327652A28CA9F", hash_generated_method = "B67AB83C3934FF2D8CA5EFBF9B5A2A28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void clear() {
        super.clear();
        mEventType = 0;
        mPackageName = null;
        mEventTime = 0;
        {
            boolean var1DB49D5E2B3547990067BB1F147D36FE_372000719 = (!mRecords.isEmpty());
            {
                AccessibilityRecord record;
                record = mRecords.remove(0);
                record.recycle();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.clear();
        //mEventType = 0;
        //mPackageName = null;
        //mEventTime = 0;
        //while (!mRecords.isEmpty()) {
            //AccessibilityRecord record = mRecords.remove(0);
            //record.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.796 -0400", hash_original_method = "CC515C973E1D9B9FD950B4FE399F0E5E", hash_generated_method = "79CA332611E700F8CB7365708D70A7A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void initFromParcel(Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
        mSealed = (parcel.readInt() == 1);
        mEventType = parcel.readInt();
        mPackageName = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mEventTime = parcel.readLong();
        mConnectionId = parcel.readInt();
        readAccessibilityRecordFromParcel(this, parcel);
        int recordCount;
        recordCount = parcel.readInt();
        {
            int i;
            i = 0;
            {
                AccessibilityRecord record;
                record = AccessibilityRecord.obtain();
                readAccessibilityRecordFromParcel(record, parcel);
                record.mConnectionId = mConnectionId;
                mRecords.add(record);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mSealed = (parcel.readInt() == 1);
        //mEventType = parcel.readInt();
        //mPackageName = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        //mEventTime = parcel.readLong();
        //mConnectionId = parcel.readInt();
        //readAccessibilityRecordFromParcel(this, parcel);
        //final int recordCount = parcel.readInt();
        //for (int i = 0; i < recordCount; i++) {
            //AccessibilityRecord record = AccessibilityRecord.obtain();
            //readAccessibilityRecordFromParcel(record, parcel);
            //record.mConnectionId = mConnectionId;
            //mRecords.add(record);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.796 -0400", hash_original_method = "B088070677D65811E863E6E48DBE8540", hash_generated_method = "EF98F759E5166BBDF67C9FCF92F2E060")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readAccessibilityRecordFromParcel(AccessibilityRecord record,
            Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(record.dsTaint);
        record.mBooleanProperties = parcel.readInt();
        record.mCurrentItemIndex = parcel.readInt();
        record.mItemCount = parcel.readInt();
        record.mFromIndex = parcel.readInt();
        record.mToIndex = parcel.readInt();
        record.mScrollX = parcel.readInt();
        record.mScrollY =  parcel.readInt();
        record.mMaxScrollX = parcel.readInt();
        record.mMaxScrollY =  parcel.readInt();
        record.mAddedCount = parcel.readInt();
        record.mRemovedCount = parcel.readInt();
        record.mClassName = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        record.mContentDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        record.mBeforeText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        record.mParcelableData = parcel.readParcelable(null);
        parcel.readList(record.mText, null);
        record.mSourceWindowId = parcel.readInt();
        record.mSourceViewId = parcel.readInt();
        record.mSealed = (parcel.readInt() == 1);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.796 -0400", hash_original_method = "B3703ED8E89F0F725D62C7A182783343", hash_generated_method = "C0752023C0ED1920CD2046975FE85855")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
        parcel.writeInt(isSealed() ? 1 : 0);
        parcel.writeInt(mEventType);
        TextUtils.writeToParcel(mPackageName, parcel, 0);
        parcel.writeLong(mEventTime);
        parcel.writeInt(mConnectionId);
        writeAccessibilityRecordToParcel(this, parcel, flags);
        int recordCount;
        recordCount = getRecordCount();
        parcel.writeInt(recordCount);
        {
            int i;
            i = 0;
            {
                AccessibilityRecord record;
                record = mRecords.get(i);
                writeAccessibilityRecordToParcel(record, parcel, flags);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //parcel.writeInt(isSealed() ? 1 : 0);
        //parcel.writeInt(mEventType);
        //TextUtils.writeToParcel(mPackageName, parcel, 0);
        //parcel.writeLong(mEventTime);
        //parcel.writeInt(mConnectionId);
        //writeAccessibilityRecordToParcel(this, parcel, flags);
        //final int recordCount = getRecordCount();
        //parcel.writeInt(recordCount);
        //for (int i = 0; i < recordCount; i++) {
            //AccessibilityRecord record = mRecords.get(i);
            //writeAccessibilityRecordToParcel(record, parcel, flags);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.797 -0400", hash_original_method = "BBBE1FBBDEA55D1C2908EC0443C0F1D0", hash_generated_method = "969EBD49FE209EDF4ACB3053487BC115")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeAccessibilityRecordToParcel(AccessibilityRecord record, Parcel parcel,
            int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(record.dsTaint);
        dsTaint.addTaint(flags);
        parcel.writeInt(record.mBooleanProperties);
        parcel.writeInt(record.mCurrentItemIndex);
        parcel.writeInt(record.mItemCount);
        parcel.writeInt(record.mFromIndex);
        parcel.writeInt(record.mToIndex);
        parcel.writeInt(record.mScrollX);
        parcel.writeInt(record.mScrollY);
        parcel.writeInt(record.mMaxScrollX);
        parcel.writeInt(record.mMaxScrollY);
        parcel.writeInt(record.mAddedCount);
        parcel.writeInt(record.mRemovedCount);
        TextUtils.writeToParcel(record.mClassName, parcel, flags);
        TextUtils.writeToParcel(record.mContentDescription, parcel, flags);
        TextUtils.writeToParcel(record.mBeforeText, parcel, flags);
        parcel.writeParcelable(record.mParcelableData, flags);
        parcel.writeList(record.mText);
        parcel.writeInt(record.mSourceWindowId);
        parcel.writeInt(record.mSourceViewId);
        parcel.writeInt(record.mSealed ? 1 : 0);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.797 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.798 -0400", hash_original_method = "B03E1856B5738C7353427D3738596016", hash_generated_method = "3F93D1327CCAC7DB685B9335174CBCBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append("EventType: ").append(eventTypeToString(mEventType));
        builder.append("; EventTime: ").append(mEventTime);
        builder.append("; PackageName: ").append(mPackageName);
        builder.append(super.toString());
        {
            builder.append("\n");
            builder.append("; sourceWindowId: ").append(mSourceWindowId);
            builder.append("; sourceViewId: ").append(mSourceViewId);
            {
                int i;
                i = 0;
                boolean var5C3739238BB0221F5CF52DB28780F721_1368794127 = (i < mRecords.size());
                {
                    AccessibilityRecord record;
                    record = mRecords.get(i);
                    builder.append("  Record ");
                    builder.append(i);
                    builder.append(":");
                    builder.append(" [ ClassName: " + record.mClassName);
                    builder.append("; Text: " + record.mText);
                    builder.append("; ContentDescription: " + record.mContentDescription);
                    builder.append("; ItemCount: " + record.mItemCount);
                    builder.append("; CurrentItemIndex: " + record.mCurrentItemIndex);
                    builder.append("; IsEnabled: " + record.isEnabled());
                    builder.append("; IsPassword: " + record.isPassword());
                    builder.append("; IsChecked: " + record.isChecked());
                    builder.append("; IsFullScreen: " + record.isFullScreen());
                    builder.append("; Scrollable: " + record.isScrollable());
                    builder.append("; BeforeText: " + record.mBeforeText);
                    builder.append("; FromIndex: " + record.mFromIndex);
                    builder.append("; ToIndex: " + record.mToIndex);
                    builder.append("; ScrollX: " + record.mScrollX);
                    builder.append("; ScrollY: " + record.mScrollY);
                    builder.append("; AddedCount: " + record.mAddedCount);
                    builder.append("; RemovedCount: " + record.mRemovedCount);
                    builder.append("; ParcelableData: " + record.mParcelableData);
                    builder.append(" ]");
                    builder.append("\n");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            builder.append("; recordCount: ").append(getRecordCount());
        } //End block
        String var687AAF24B90629C9BFCFE9608FDCE6E7_424116271 = (builder.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static String eventTypeToString(int eventType) {
        switch (eventType) {
            case TYPE_VIEW_CLICKED:
                return "TYPE_VIEW_CLICKED";
            case TYPE_VIEW_LONG_CLICKED:
                return "TYPE_VIEW_LONG_CLICKED";
            case TYPE_VIEW_SELECTED:
                return "TYPE_VIEW_SELECTED";
            case TYPE_VIEW_FOCUSED:
                return "TYPE_VIEW_FOCUSED";
            case TYPE_VIEW_TEXT_CHANGED:
                return "TYPE_VIEW_TEXT_CHANGED";
            case TYPE_WINDOW_STATE_CHANGED:
                return "TYPE_WINDOW_STATE_CHANGED";
            case TYPE_VIEW_HOVER_ENTER:
                return "TYPE_VIEW_HOVER_ENTER";
            case TYPE_VIEW_HOVER_EXIT:
                return "TYPE_VIEW_HOVER_EXIT";
            case TYPE_NOTIFICATION_STATE_CHANGED:
                return "TYPE_NOTIFICATION_STATE_CHANGED";  
            case TYPE_TOUCH_EXPLORATION_GESTURE_START:
                return "TYPE_TOUCH_EXPLORATION_GESTURE_START";
            case TYPE_TOUCH_EXPLORATION_GESTURE_END:
                return "TYPE_TOUCH_EXPLORATION_GESTURE_END";
            case TYPE_WINDOW_CONTENT_CHANGED:
                return "TYPE_WINDOW_CONTENT_CHANGED";
            case TYPE_VIEW_TEXT_SELECTION_CHANGED:
                return "TYPE_VIEW_TEXT_SELECTION_CHANGED";
            case TYPE_VIEW_SCROLLED:
                return "TYPE_VIEW_SCROLLED";
            default:
                return null;
        }
    }

    
    private static final boolean DEBUG = false;
    public static final int INVALID_POSITION = -1;
    @Deprecated public static final int MAX_TEXT_LENGTH = 500;
    public static final int TYPE_VIEW_CLICKED = 0x00000001;
    public static final int TYPE_VIEW_LONG_CLICKED = 0x00000002;
    public static final int TYPE_VIEW_SELECTED = 0x00000004;
    public static final int TYPE_VIEW_FOCUSED = 0x00000008;
    public static final int TYPE_VIEW_TEXT_CHANGED = 0x00000010;
    public static final int TYPE_WINDOW_STATE_CHANGED = 0x00000020;
    public static final int TYPE_NOTIFICATION_STATE_CHANGED = 0x00000040;
    public static final int TYPE_VIEW_HOVER_ENTER = 0x00000080;
    public static final int TYPE_VIEW_HOVER_EXIT = 0x00000100;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 0x00000200;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 0x00000400;
    public static final int TYPE_WINDOW_CONTENT_CHANGED = 0x00000800;
    public static final int TYPE_VIEW_SCROLLED = 0x00001000;
    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 0x00002000;
    public static final int TYPES_ALL_MASK = 0xFFFFFFFF;
    private static final int MAX_POOL_SIZE = 10;
    private static final Object sPoolLock = new Object();
    private static AccessibilityEvent sPool;
    private static int sPoolSize;
    public static final Parcelable.Creator<AccessibilityEvent> CREATOR = new Parcelable.Creator<AccessibilityEvent>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.798 -0400", hash_original_method = "0503BE1AE69FE692C001D30E3726C729", hash_generated_method = "53B26D1EF39320FE7D43A15FEF4D6E3A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AccessibilityEvent createFromParcel(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            AccessibilityEvent event;
            event = AccessibilityEvent.obtain();
            event.initFromParcel(parcel);
            return (AccessibilityEvent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //AccessibilityEvent event = AccessibilityEvent.obtain();
            //event.initFromParcel(parcel);
            //return event;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.799 -0400", hash_original_method = "86402C622E8C39689564A835CE0C5BD1", hash_generated_method = "8AB8F8D4A8B0C2449D67C56F340CF946")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AccessibilityEvent[] newArray(int size) {
            dsTaint.addTaint(size);
            AccessibilityEvent[] var108FC79D2302E1ABD86AE4DF9F3729A3_844008214 = (new AccessibilityEvent[size]);
            return (AccessibilityEvent[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AccessibilityEvent[size];
        }

        
}; //Transformed anonymous class
}

