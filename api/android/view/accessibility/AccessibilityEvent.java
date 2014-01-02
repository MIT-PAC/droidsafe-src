package android.view.accessibility;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;





public final class AccessibilityEvent extends AccessibilityRecord implements Parcelable {

    @DSModeled(DSC.BAN)
    public static AccessibilityEvent droidsafeGetEvent() {
        return new AccessibilityEvent(); 
    }

    /**
     * Returns a cached instance if such is available or a new one is
     * instantiated with its type property set.
     *
     * @param eventType The event type.
     * @return An instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.461 -0500", hash_original_method = "A7145B8906EC48103C63737E7936B464", hash_generated_method = "DECD9BD2A2F1267D265C497B5EE21ED5")
    
public static AccessibilityEvent obtain(int eventType) {
        AccessibilityEvent event = AccessibilityEvent.obtain();
        event.setEventType(eventType);
        return event;
    }

    /**
     * Returns a cached instance if such is available or a new one is
     * created. The returned instance is initialized from the given
     * <code>event</code>.
     *
     * @param event The other event.
     * @return An instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.464 -0500", hash_original_method = "266DCFFE6CD24F344E992D02CFAE713D", hash_generated_method = "772844F881FE1E9374A34ADF6AA14620")
    
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

    /**
     * Returns a cached instance if such is available or a new one is
     * instantiated.
     *
     * @return An instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.467 -0500", hash_original_method = "10F3069F21F3E55AED4FC89118BF5C5A", hash_generated_method = "E3D01B2B9125EFEB96BBDB3B34AEDE01")
    
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

    /**
     * Returns the string representation of an event type. For example,
     * {@link #TYPE_VIEW_CLICKED} is represented by the string TYPE_VIEW_CLICKED.
     *
     * @param eventType The event type
     * @return The string representation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.492 -0500", hash_original_method = "490432459D79C412953D9D40ADA5D091", hash_generated_method = "BFC6A521D54C909AB0C30F076BABAEF0")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.364 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.367 -0500", hash_original_field = "08744EB4FDECE919536D545565C93AB6", hash_generated_field = "74326D0EB2E635FB68B20B0C678CCDFD")

    public static final int INVALID_POSITION = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.370 -0500", hash_original_field = "83E1A010620A23DE83EC4728F0028C84", hash_generated_field = "880D1B688B5762A43EC3293825ABD226")

    @Deprecated
    public static final int MAX_TEXT_LENGTH = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.372 -0500", hash_original_field = "7BB5DEB3C7D320099B567E38F9907ADD", hash_generated_field = "0759BD31D78B12C33E9596E5D1F65440")

    public static final int TYPE_VIEW_CLICKED = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.376 -0500", hash_original_field = "06FAD488B0C93DDE1CC43A33F65AC72D", hash_generated_field = "DCE2DBDC682FDC7CC6F091D5CFC428AF")

    public static final int TYPE_VIEW_LONG_CLICKED = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.378 -0500", hash_original_field = "0249609B0CE3F0EDA7A134C3B6AF0856", hash_generated_field = "C42CF73439134B7BB633C91694F9321F")

    public static final int TYPE_VIEW_SELECTED = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.380 -0500", hash_original_field = "0C6C73D726CB2EA7AE4C58B20229EFBA", hash_generated_field = "0F0F6680889099CF5B4EF4A9D2CC5624")

    public static final int TYPE_VIEW_FOCUSED = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.383 -0500", hash_original_field = "FD13962B289C40CE0A84794E4C1A593A", hash_generated_field = "A27F6C2038905BC4DAC0DFF0CD4E44D1")

    public static final int TYPE_VIEW_TEXT_CHANGED = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.385 -0500", hash_original_field = "5EE27687E1E7D938708E916E82B1F7E8", hash_generated_field = "6D3C03EB7BFACD14F8E8B05C1BEFE36E")

    public static final int TYPE_WINDOW_STATE_CHANGED = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.388 -0500", hash_original_field = "E5150EC28A3376CA2208FDF9E689D2BC", hash_generated_field = "574850F31ABBBEBF562B6A937BFE0F83")

    public static final int TYPE_NOTIFICATION_STATE_CHANGED = 0x00000040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.390 -0500", hash_original_field = "31FCC99F3B99C6497BF7D1A2B75DA224", hash_generated_field = "FE950ACD1EB76F522B84E4AF57C8EB4E")

    public static final int TYPE_VIEW_HOVER_ENTER = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.393 -0500", hash_original_field = "CF3E5481B9FA8CE5B340F2D0CC6D61CA", hash_generated_field = "18FE8FEEC4DFCC299D1871533484029C")

    public static final int TYPE_VIEW_HOVER_EXIT = 0x00000100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.395 -0500", hash_original_field = "56B5D701F452B1B8A0D56F5A7C4B733D", hash_generated_field = "241CE14D36798EBC2A23586E200A67F4")

    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 0x00000200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.398 -0500", hash_original_field = "C00F69FFB6F4A7790B31945CE3530040", hash_generated_field = "BA83447C09FF159FA67B3574E6C27B8C")

    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 0x00000400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.400 -0500", hash_original_field = "C232F9CCDAC306AE1B74987DE402183E", hash_generated_field = "78AE73D6DF96970386315118ADB13502")

    public static final int TYPE_WINDOW_CONTENT_CHANGED = 0x00000800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.402 -0500", hash_original_field = "8A142E4662D2340E134C2E8E3D4F939A", hash_generated_field = "4CA347468789B2191C2D5030F3F1C887")

    public static final int TYPE_VIEW_SCROLLED = 0x00001000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.405 -0500", hash_original_field = "7F48D63C013E10014BB3BF5669F90B70", hash_generated_field = "FD261FCAF58AFDA7AA95FBDB48245FF4")

    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 0x00002000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.407 -0500", hash_original_field = "0D3369ECD5A8889BF049FB6C016F57F9", hash_generated_field = "5BAD57F63E5D649A21D00BA11B6FBBFC")

    public static final int TYPES_ALL_MASK = 0xFFFFFFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.409 -0500", hash_original_field = "3257F81BBFE679E3360141AA5EA9D518", hash_generated_field = "FB8E412EAB46029C42E8E38ED918C6D9")


    private static final int MAX_POOL_SIZE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.412 -0500", hash_original_field = "80BD8A730C8BC829BD11E3A3CFC39CA3", hash_generated_field = "515CCCD8D6622177DD93BECF774D048D")

    private static final Object sPoolLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.415 -0500", hash_original_field = "17D2605D29536A7FAA7C938B5ACE7AAC", hash_generated_field = "2B8352CB27E22D691B0DA6825DBE20F3")

    private static AccessibilityEvent sPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.417 -0500", hash_original_field = "4147A9532CCAB604E1A40F8F844CAE62", hash_generated_field = "D185458A63BD443FF8514FC9B9E5705B")

    private static int sPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.231 -0400", hash_original_field = "3C0501D56201E3E114FB23A141ABA0A4", hash_generated_field = "3F489DF2668FE829B750D41EBCAF8FD5")

    public static final Parcelable.Creator<AccessibilityEvent> CREATOR =
            new Parcelable.Creator<AccessibilityEvent>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.495 -0500", hash_original_method = "0503BE1AE69FE692C001D30E3726C729", hash_generated_method = "49DCB7243BF2141A3159282BBE55D397")
        
public AccessibilityEvent createFromParcel(Parcel parcel) {
            AccessibilityEvent event = AccessibilityEvent.obtain();
            event.initFromParcel(parcel);
            return event;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.498 -0500", hash_original_method = "86402C622E8C39689564A835CE0C5BD1", hash_generated_method = "A8ED17D727E494833DE9916EBB61346D")
        
public AccessibilityEvent[] newArray(int size) {
            return new AccessibilityEvent[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.419 -0500", hash_original_field = "E4E98BF1C37FE217382E4B7CDE4198DA", hash_generated_field = "B87C181D2445875B036BCB5CFE684884")

    private AccessibilityEvent mNext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.422 -0500", hash_original_field = "2CE23EB289B3963F8F89CE4E1DF951CB", hash_generated_field = "12FC58788D16ADAE0F5394F898FD4D99")

    private boolean mIsInPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.424 -0500", hash_original_field = "60513C71507B6FB4E4F9D7F335ECB484", hash_generated_field = "8DFF2F7D6614CCA19DAAC549D23778BF")


    private int mEventType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.426 -0500", hash_original_field = "70581C252521204037775F3EA9D8E9F2", hash_generated_field = "6A9DFBEC5628781E76307C090C363D49")

    private CharSequence mPackageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.429 -0500", hash_original_field = "235018A2B2200C1EFF286CCDC9DEE735", hash_generated_field = "D6C2226ACD561C7062177E3F0AB4BB2A")

    private long mEventTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.431 -0500", hash_original_field = "13483AE0B0468BA4337EA080FAA63C94", hash_generated_field = "22A74F87FC449BC3B93E8BB2B11BA02D")


    private final ArrayList<AccessibilityRecord> mRecords = new ArrayList<AccessibilityRecord>();

    /*
     * Hide constructor from clients.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.433 -0500", hash_original_method = "851763ED22FDC1F823C000B96565E393", hash_generated_method = "DB12C3159964370003B409964B096C0C")
    
private AccessibilityEvent() {
    }

    /**
     * Initialize an event from another one.
     *
     * @param event The event to initialize from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.436 -0500", hash_original_method = "EF53A9AEF549006E04C5A25F56401EE0", hash_generated_method = "EF53A9AEF549006E04C5A25F56401EE0")
    
void init(AccessibilityEvent event) {
        super.init(event);
        mEventType = event.mEventType;
        mEventTime = event.mEventTime;
        mPackageName = event.mPackageName;
    }

    /**
     * Sets if this instance is sealed.
     *
     * @param sealed Whether is sealed.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.438 -0500", hash_original_method = "86DBA4ADDEC94CD24AE35AA90BF3A59E", hash_generated_method = "D50929EA929BCFE290769089BEBD4ACA")
    
@Override
    public void setSealed(boolean sealed) {
        super.setSealed(sealed);
        List<AccessibilityRecord> records = mRecords;
        final int recordCount = records.size();
        for (int i = 0; i < recordCount; i++) {
            AccessibilityRecord record = records.get(i);
            record.setSealed(sealed);
        }
    }

    /**
     * Gets the number of records contained in the event.
     *
     * @return The number of records.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.441 -0500", hash_original_method = "E3578B8B8EBF3C6DE3B4CEB5DF2FD3A0", hash_generated_method = "45AE797C926A97FF4238FE89EE498366")
    
public int getRecordCount() {
        return mRecords.size();
    }

    /**
     * Appends an {@link AccessibilityRecord} to the end of event records.
     *
     * @param record The record to append.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.443 -0500", hash_original_method = "65BE24FB8BF3EB0B7B54A7C4AA9FE110", hash_generated_method = "A9E8D5291D5D0B74598ADA13EEC3447F")
    
public void appendRecord(AccessibilityRecord record) {
        enforceNotSealed();
        mRecords.add(record);
    }

    /**
     * Gets the record at a given index.
     *
     * @param index The index.
     * @return The record at the specified index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.445 -0500", hash_original_method = "9E2314A76EC6019735F4372CBF34D41F", hash_generated_method = "16B8C87E554CC89ED26CAC1F3B820131")
    
public AccessibilityRecord getRecord(int index) {
        return mRecords.get(index);
    }

    /**
     * Gets the event type.
     *
     * @return The event type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.447 -0500", hash_original_method = "4F017DE4F3DB5F93E271E04CA9550DB1", hash_generated_method = "01F97DA7B4B424BFB276760D3ABE3C6A")
    
public int getEventType() {
        return mEventType;
    }

    /**
     * Sets the event type.
     *
     * @param eventType The event type.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.450 -0500", hash_original_method = "5683B1405AEA65ED0491BE91FD34C2FA", hash_generated_method = "032A4ACCD40C2518E1A2CBF335AEA16E")
    
public void setEventType(int eventType) {
        enforceNotSealed();
        mEventType = eventType;
    }

    /**
     * Gets the time in which this event was sent.
     *
     * @return The event time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.452 -0500", hash_original_method = "9909149D86C7172035BFD4D31C880F99", hash_generated_method = "F653F6EE78E4EF60FE34AEBC3CD5060E")
    
public long getEventTime() {
        return mEventTime;
    }

    /**
     * Sets the time in which this event was sent.
     *
     * @param eventTime The event time.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.454 -0500", hash_original_method = "D3F4C692FA45FB670DB263BA6C6ECFB3", hash_generated_method = "6C3B2C57176306A98018D3852C31021B")
    
public void setEventTime(long eventTime) {
        enforceNotSealed();
        mEventTime = eventTime;
    }

    /**
     * Gets the package name of the source.
     *
     * @return The package name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.457 -0500", hash_original_method = "6D18CADAD3BE855C953B6A82043EA347", hash_generated_method = "62E16594ED1E4D773FC387EB5B07A489")
    
public CharSequence getPackageName() {
        return mPackageName;
    }

    /**
     * Sets the package name of the source.
     *
     * @param packageName The package name.
     *
     * @throws IllegalStateException If called from an AccessibilityService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.459 -0500", hash_original_method = "D35D1C42C7BD5A2BDF03FC6BDBDF64EE", hash_generated_method = "194D21D70E7FE29679C690B456C3D46C")
    
public void setPackageName(CharSequence packageName) {
        enforceNotSealed();
        mPackageName = packageName;
    }

    /**
     * Recycles an instance back to be reused.
     * <p>
     *   <b>Note: You must not touch the object after calling this function.</b>
     * </p>
     *
     * @throws IllegalStateException If the event is already recycled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.470 -0500", hash_original_method = "74951363C7DF24AC8EB3BEFEC94F56A2", hash_generated_method = "9CA234BE13AFD4B45A70AF1A12C4FC57")
    
@Override
    public void recycle() {
        if (mIsInPool) {
            throw new IllegalStateException("Event already recycled!");
        }
        clear();
        synchronized (sPoolLock) {
            if (sPoolSize <= MAX_POOL_SIZE) {
                mNext = sPool;
                sPool = this;
                mIsInPool = true;
                sPoolSize++;
            }
        }
    }

    /**
     * Clears the state of this instance.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.472 -0500", hash_original_method = "4C3D5B3E8C94F161E20327652A28CA9F", hash_generated_method = "6A063ED1944AD2178AE45E09CFBB516B")
    
@Override
    protected void clear() {
        super.clear();
        mEventType = 0;
        mPackageName = null;
        mEventTime = 0;
        while (!mRecords.isEmpty()) {
            AccessibilityRecord record = mRecords.remove(0);
            record.recycle();
        }
    }

    /**
     * Creates a new instance from a {@link Parcel}.
     *
     * @param parcel A parcel containing the state of a {@link AccessibilityEvent}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.475 -0500", hash_original_method = "CC515C973E1D9B9FD950B4FE399F0E5E", hash_generated_method = "3D66A17A7E3D2865DAC66A460D80705C")
    
public void initFromParcel(Parcel parcel) {
        mSealed = (parcel.readInt() == 1);
        mEventType = parcel.readInt();
        mPackageName = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mEventTime = parcel.readLong();
        mConnectionId = parcel.readInt();
        readAccessibilityRecordFromParcel(this, parcel);

        // Read the records.
        final int recordCount = parcel.readInt();
        for (int i = 0; i < recordCount; i++) {
            AccessibilityRecord record = AccessibilityRecord.obtain();
            readAccessibilityRecordFromParcel(record, parcel);
            record.mConnectionId = mConnectionId;
            mRecords.add(record);
        }
    }

    /**
     * Reads an {@link AccessibilityRecord} from a parcel.
     *
     * @param record The record to initialize.
     * @param parcel The parcel to read from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.477 -0500", hash_original_method = "B088070677D65811E863E6E48DBE8540", hash_generated_method = "60C42CB458D1A2FC6C1EC72B64B0EB2F")
    
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
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.480 -0500", hash_original_method = "B3703ED8E89F0F725D62C7A182783343", hash_generated_method = "BCC25B3EEEEC0FB4DC4379EC2C8F6FEC")
    
public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(isSealed() ? 1 : 0);
        parcel.writeInt(mEventType);
        TextUtils.writeToParcel(mPackageName, parcel, 0);
        parcel.writeLong(mEventTime);
        parcel.writeInt(mConnectionId);
        writeAccessibilityRecordToParcel(this, parcel, flags);

        // Write the records.
        final int recordCount = getRecordCount();
        parcel.writeInt(recordCount);
        for (int i = 0; i < recordCount; i++) {
            AccessibilityRecord record = mRecords.get(i);
            writeAccessibilityRecordToParcel(record, parcel, flags);
        }
    }

    /**
     * Writes an {@link AccessibilityRecord} to a parcel.
     *
     * @param record The record to write.
     * @param parcel The parcel to which to write.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.483 -0500", hash_original_method = "BBBE1FBBDEA55D1C2908EC0443C0F1D0", hash_generated_method = "46ADF76686243899D40AF6739251DB9C")
    
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
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.486 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:51.489 -0500", hash_original_method = "B03E1856B5738C7353427D3738596016", hash_generated_method = "3F9A44006A65A001136F2CD9A3AE9923")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EventType: ").append(eventTypeToString(mEventType));
        builder.append("; EventTime: ").append(mEventTime);
        builder.append("; PackageName: ").append(mPackageName);
        builder.append(super.toString());
        if (DEBUG) {
            builder.append("\n");
            builder.append("; sourceWindowId: ").append(mSourceWindowId);
            builder.append("; sourceViewId: ").append(mSourceViewId);
            for (int i = 0; i < mRecords.size(); i++) {
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
        } else {
            builder.append("; recordCount: ").append(getRecordCount());
        }
        return builder.toString();
    }
    // orphaned legacy method
    public AccessibilityEvent createFromParcel(Parcel parcel) {
            AccessibilityEvent event = AccessibilityEvent.obtain();
            event.initFromParcel(parcel);
            return event;
        }
    
    // orphaned legacy method
    public AccessibilityEvent[] newArray(int size) {
            return new AccessibilityEvent[size];
        }
    
}

