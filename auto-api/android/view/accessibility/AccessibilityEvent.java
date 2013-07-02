package android.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class AccessibilityEvent extends AccessibilityRecord implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.927 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "B87C181D2445875B036BCB5CFE684884")

    private AccessibilityEvent mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.927 -0400", hash_original_field = "B94200C48C7563C1FA86222302A87F95", hash_generated_field = "12FC58788D16ADAE0F5394F898FD4D99")

    private boolean mIsInPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.927 -0400", hash_original_field = "C7C43C278E8643FF27A9474560193A6F", hash_generated_field = "8DFF2F7D6614CCA19DAAC549D23778BF")

    private int mEventType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.927 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6A9DFBEC5628781E76307C090C363D49")

    private CharSequence mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.927 -0400", hash_original_field = "3EE1D0D0A7FA96B4DEE335E6458397C2", hash_generated_field = "D6C2226ACD561C7062177E3F0AB4BB2A")

    private long mEventTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.927 -0400", hash_original_field = "91925B941558FF213288DED4914F49AC", hash_generated_field = "22A74F87FC449BC3B93E8BB2B11BA02D")

    private final ArrayList<AccessibilityRecord> mRecords = new ArrayList<AccessibilityRecord>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.928 -0400", hash_original_method = "851763ED22FDC1F823C000B96565E393", hash_generated_method = "6EADCF7C93B43CCEF55BB13CB1733BA7")
    private  AccessibilityEvent() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.928 -0400", hash_original_method = "EF53A9AEF549006E04C5A25F56401EE0", hash_generated_method = "991762809BB6415C67A8EFF5F5C4AE51")
     void init(AccessibilityEvent event) {
        super.init(event);
        mEventType = event.mEventType;
        mEventTime = event.mEventTime;
        mPackageName = event.mPackageName;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.929 -0400", hash_original_method = "86DBA4ADDEC94CD24AE35AA90BF3A59E", hash_generated_method = "13AFB2B319309551AAB1E84CA94D3BE9")
    @Override
    public void setSealed(boolean sealed) {
        super.setSealed(sealed);
        List<AccessibilityRecord> records = mRecords;
        final int recordCount = records.size();
        {
            int i = 0;
            {
                AccessibilityRecord record = records.get(i);
                record.setSealed(sealed);
            } 
        } 
        addTaint(sealed);
        
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.929 -0400", hash_original_method = "E3578B8B8EBF3C6DE3B4CEB5DF2FD3A0", hash_generated_method = "6B777FBEB4038347140EFFAA45D9AC7F")
    public int getRecordCount() {
        int varCBF5629F1D9D3BD9F735EE647C7DA0D7_308580382 = (mRecords.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097884915 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097884915;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.929 -0400", hash_original_method = "65BE24FB8BF3EB0B7B54A7C4AA9FE110", hash_generated_method = "C874554E39D92B33572BB7B97A011142")
    public void appendRecord(AccessibilityRecord record) {
        enforceNotSealed();
        mRecords.add(record);
        addTaint(record.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.930 -0400", hash_original_method = "9E2314A76EC6019735F4372CBF34D41F", hash_generated_method = "5BC05C5522EA33D2E5FE4B84ECDAAEAD")
    public AccessibilityRecord getRecord(int index) {
        AccessibilityRecord varB4EAC82CA7396A68D541C85D26508E83_157857204 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_157857204 = mRecords.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_157857204.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_157857204;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.931 -0400", hash_original_method = "4F017DE4F3DB5F93E271E04CA9550DB1", hash_generated_method = "108A38C6FA6AFB94B67E1C2E2626035F")
    public int getEventType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432077052 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432077052;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.931 -0400", hash_original_method = "5683B1405AEA65ED0491BE91FD34C2FA", hash_generated_method = "0BD315ED80D5AFB7C378BBD13A819984")
    public void setEventType(int eventType) {
        enforceNotSealed();
        mEventType = eventType;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.932 -0400", hash_original_method = "9909149D86C7172035BFD4D31C880F99", hash_generated_method = "FD825AB0D05731BBA77177B6BECF80C2")
    public long getEventTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1858758736 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1858758736;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.932 -0400", hash_original_method = "D3F4C692FA45FB670DB263BA6C6ECFB3", hash_generated_method = "FC327D7F2E34494F25EDB067C1859DE6")
    public void setEventTime(long eventTime) {
        enforceNotSealed();
        mEventTime = eventTime;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.933 -0400", hash_original_method = "6D18CADAD3BE855C953B6A82043EA347", hash_generated_method = "A78C21011CC7012B60C966FD5104D048")
    public CharSequence getPackageName() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1364307638 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1364307638 = mPackageName;
        varB4EAC82CA7396A68D541C85D26508E83_1364307638.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1364307638;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.933 -0400", hash_original_method = "D35D1C42C7BD5A2BDF03FC6BDBDF64EE", hash_generated_method = "0EF63785D6B95ACB6D9D44BFD3B5249A")
    public void setPackageName(CharSequence packageName) {
        enforceNotSealed();
        mPackageName = packageName;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static AccessibilityEvent obtain(int eventType) {
        AccessibilityEvent event = AccessibilityEvent.obtain();
        event.setEventType(eventType);
        return event;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.934 -0400", hash_original_method = "74951363C7DF24AC8EB3BEFEC94F56A2", hash_generated_method = "F79FD03343689E2173CAEBFDE9B7B987")
    @Override
    public void recycle() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Event already recycled!");
        } 
        clear();
        {
            {
                mNext = sPool;
                sPool = this;
                mIsInPool = true;
            } 
        } 
        
        
            
        
        
        
            
                
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.935 -0400", hash_original_method = "4C3D5B3E8C94F161E20327652A28CA9F", hash_generated_method = "5233663B5138237EA2BF698A36398645")
    @Override
    protected void clear() {
        super.clear();
        mEventType = 0;
        mPackageName = null;
        mEventTime = 0;
        {
            boolean var1DB49D5E2B3547990067BB1F147D36FE_646113550 = (!mRecords.isEmpty());
            {
                AccessibilityRecord record = mRecords.remove(0);
                record.recycle();
            } 
        } 
        
        
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.935 -0400", hash_original_method = "CC515C973E1D9B9FD950B4FE399F0E5E", hash_generated_method = "3C1492104DFC782B6B623F79162D44B0")
    public void initFromParcel(Parcel parcel) {
        mSealed = (parcel.readInt() == 1);
        mEventType = parcel.readInt();
        mPackageName = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mEventTime = parcel.readLong();
        mConnectionId = parcel.readInt();
        readAccessibilityRecordFromParcel(this, parcel);
        final int recordCount = parcel.readInt();
        {
            int i = 0;
            {
                AccessibilityRecord record = AccessibilityRecord.obtain();
                readAccessibilityRecordFromParcel(record, parcel);
                record.mConnectionId = mConnectionId;
                mRecords.add(record);
            } 
        } 
        
        
        
        
        
        
        
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.936 -0400", hash_original_method = "B088070677D65811E863E6E48DBE8540", hash_generated_method = "03C728933FD4249FBB58393369EB79B0")
    private void readAccessibilityRecordFromParcel(AccessibilityRecord record,
            Parcel parcel) {
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
        addTaint(record.getTaint());
        addTaint(parcel.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.937 -0400", hash_original_method = "B3703ED8E89F0F725D62C7A182783343", hash_generated_method = "33CDA9479E5C112F2C09971E1B282BC2")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(isSealed() ? 1 : 0);
        parcel.writeInt(mEventType);
        TextUtils.writeToParcel(mPackageName, parcel, 0);
        parcel.writeLong(mEventTime);
        parcel.writeInt(mConnectionId);
        writeAccessibilityRecordToParcel(this, parcel, flags);
        final int recordCount = getRecordCount();
        parcel.writeInt(recordCount);
        {
            int i = 0;
            {
                AccessibilityRecord record = mRecords.get(i);
                writeAccessibilityRecordToParcel(record, parcel, flags);
            } 
        } 
        addTaint(parcel.getTaint());
        addTaint(flags);
        
        
        
        
        
        
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.937 -0400", hash_original_method = "BBBE1FBBDEA55D1C2908EC0443C0F1D0", hash_generated_method = "7E1CF0015D79EE789708060D9898A331")
    private void writeAccessibilityRecordToParcel(AccessibilityRecord record, Parcel parcel,
            int flags) {
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
        addTaint(record.getTaint());
        addTaint(parcel.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.937 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6920304E3BDB275214CDD4F7BCD45AA3")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_678539426 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_678539426;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_method = "B03E1856B5738C7353427D3738596016", hash_generated_method = "BE9BBA88B797D4AC9815CC6D6E9F5385")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1729971357 = null; 
        StringBuilder builder = new StringBuilder();
        builder.append("EventType: ").append(eventTypeToString(mEventType));
        builder.append("; EventTime: ").append(mEventTime);
        builder.append("; PackageName: ").append(mPackageName);
        builder.append(super.toString());
        {
            builder.append("\n");
            builder.append("; sourceWindowId: ").append(mSourceWindowId);
            builder.append("; sourceViewId: ").append(mSourceViewId);
            {
                int i = 0;
                boolean var5C3739238BB0221F5CF52DB28780F721_1499153979 = (i < mRecords.size());
                {
                    AccessibilityRecord record = mRecords.get(i);
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
                } 
            } 
        } 
        {
            builder.append("; recordCount: ").append(getRecordCount());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1729971357 = builder.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1729971357.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1729971357;
        
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "78D008574FF4877A72651C9D9100850E", hash_generated_field = "74326D0EB2E635FB68B20B0C678CCDFD")

    public static final int INVALID_POSITION = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "CEA7003EB90E302D0357ED14B1D0C4ED", hash_generated_field = "880D1B688B5762A43EC3293825ABD226")

    @Deprecated
    public static final int MAX_TEXT_LENGTH = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "2B6EAD57EE84F132079CC8C201569907", hash_generated_field = "0759BD31D78B12C33E9596E5D1F65440")

    public static final int TYPE_VIEW_CLICKED = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "DBCF4A597F762FFF2D1CD09C1B858495", hash_generated_field = "DCE2DBDC682FDC7CC6F091D5CFC428AF")

    public static final int TYPE_VIEW_LONG_CLICKED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "CE88C80C9EC929CF92CAEC29390EC3E3", hash_generated_field = "C42CF73439134B7BB633C91694F9321F")

    public static final int TYPE_VIEW_SELECTED = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "57DE8F3CF07E999559144D5A1C5C580E", hash_generated_field = "0F0F6680889099CF5B4EF4A9D2CC5624")

    public static final int TYPE_VIEW_FOCUSED = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "DD1A9675446B99CB070FB4C7C3ADECDD", hash_generated_field = "A27F6C2038905BC4DAC0DFF0CD4E44D1")

    public static final int TYPE_VIEW_TEXT_CHANGED = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "1150FBE3C62FC3EBC19F250617F9A4C6", hash_generated_field = "6D3C03EB7BFACD14F8E8B05C1BEFE36E")

    public static final int TYPE_WINDOW_STATE_CHANGED = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "67F1095CB3D5E5E06BA75482ED84B767", hash_generated_field = "574850F31ABBBEBF562B6A937BFE0F83")

    public static final int TYPE_NOTIFICATION_STATE_CHANGED = 0x00000040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "682B4667B2E14C813F6FB7E8685004E2", hash_generated_field = "FE950ACD1EB76F522B84E4AF57C8EB4E")

    public static final int TYPE_VIEW_HOVER_ENTER = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "8B3827358B19D07352F5E4B61B5E45FF", hash_generated_field = "18FE8FEEC4DFCC299D1871533484029C")

    public static final int TYPE_VIEW_HOVER_EXIT = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "27E59EDCB3387FEEF330602C38D225F7", hash_generated_field = "241CE14D36798EBC2A23586E200A67F4")

    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 0x00000200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "F10DE93AB695DD6D105E8B37EDEEDFF2", hash_generated_field = "BA83447C09FF159FA67B3574E6C27B8C")

    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 0x00000400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "F1901586F3217FA9270185C68DFCADFC", hash_generated_field = "78AE73D6DF96970386315118ADB13502")

    public static final int TYPE_WINDOW_CONTENT_CHANGED = 0x00000800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "7184B53D897BEEE90B38FBD41E529218", hash_generated_field = "4CA347468789B2191C2D5030F3F1C887")

    public static final int TYPE_VIEW_SCROLLED = 0x00001000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "CB33A23DB3E2726687F30510DC8ED665", hash_generated_field = "FD261FCAF58AFDA7AA95FBDB48245FF4")

    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 0x00002000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "6DCB32AA8EBE9BEB5FFDEC7994730CE7", hash_generated_field = "5BAD57F63E5D649A21D00BA11B6FBBFC")

    public static final int TYPES_ALL_MASK = 0xFFFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "EB2583C9A133F7C44A9BFAD1B17484D6", hash_generated_field = "FB8E412EAB46029C42E8E38ED918C6D9")

    private static final int MAX_POOL_SIZE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "0948632EF09E2DCA187883CC60BCD1E4", hash_generated_field = "515CCCD8D6622177DD93BECF774D048D")

    private static final Object sPoolLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.939 -0400", hash_original_field = "0DDC63886CD8DB777504574D2935937E", hash_generated_field = "2B8352CB27E22D691B0DA6825DBE20F3")

    private static AccessibilityEvent sPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.940 -0400", hash_original_field = "F402B52BA7964DFA741C4EF5BBB4414B", hash_generated_field = "D185458A63BD443FF8514FC9B9E5705B")

    private static int sPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.940 -0400", hash_original_field = "3C0501D56201E3E114FB23A141ABA0A4", hash_generated_field = "3F489DF2668FE829B750D41EBCAF8FD5")

    public static final Parcelable.Creator<AccessibilityEvent> CREATOR =
            new Parcelable.Creator<AccessibilityEvent>() {
        public AccessibilityEvent createFromParcel(Parcel parcel) {
            AccessibilityEvent event = AccessibilityEvent.obtain();
            event.initFromParcel(parcel);
            return event;
        }

        public AccessibilityEvent[] newArray(int size) {
            return new AccessibilityEvent[size];
        }
    };
    
    public AccessibilityEvent createFromParcel(Parcel parcel) {
            AccessibilityEvent event = AccessibilityEvent.obtain();
            event.initFromParcel(parcel);
            return event;
        }
    
    
    public AccessibilityEvent[] newArray(int size) {
            return new AccessibilityEvent[size];
        }
    
}

