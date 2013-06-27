package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCursor implements CrossProcessCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.245 -0400", hash_original_field = "DEB4CF927428CCF05DDA4EF4FEB1005E", hash_generated_field = "6D0681B9CC29887CCBA4001347A5783B")

    DataSetObservable mDataSetObservable = new DataSetObservable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.271 -0400", hash_original_field = "4EE77521C699348F360614CCB598F0DA", hash_generated_field = "6BF9678DA09BCADC073486531F473877")

    ContentObservable mContentObservable = new ContentObservable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.272 -0400", hash_original_field = "A883CF36228E5D5BEE104578CFD98D1A", hash_generated_field = "C259FC89DCF7616DD34FCE80BA674482")

    Bundle mExtras = Bundle.EMPTY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.272 -0400", hash_original_field = "FF57DF1F147EFE36452B72FECC7EA001", hash_generated_field = "3262CD6FF716DCC93EF350DE915E82F7")

    @Deprecated protected HashMap<Long, Map<String, Object>> mUpdatedRows;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.272 -0400", hash_original_field = "8F16E846503942495A4C2CEC2ACC3981", hash_generated_field = "CAA7A11E9EDD8A3053C8B09C2CE51748")

    protected int mRowIdColumnIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.272 -0400", hash_original_field = "A8470CE6E0050B0E832FDE52720C7250", hash_generated_field = "2D6A6141DF728852DF640B9043726CFE")

    protected int mPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.272 -0400", hash_original_field = "A1AA4D3A92944F498D58CCE725E457D2", hash_generated_field = "E8ADE6CE335E3FD73301A59B91CA2D26")

    protected Long mCurrentRowID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.272 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "2EC8D863DD9B1C7F06ECE8C6EB85D0AC")

    protected ContentResolver mContentResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.272 -0400", hash_original_field = "D72871D5CE2EB17105099280224B0CCD", hash_generated_field = "8DFE2F79489A890EB2125D534844CFA4")

    protected boolean mClosed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.273 -0400", hash_original_field = "B5B1B3CC4B02696F21C074282A970F7B", hash_generated_field = "03B2ABC109B716AB445FFCE8068B3A63")

    private Uri mNotifyUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.273 -0400", hash_original_field = "9E8762D4BFD04D3E9CD66C55B4E9A39B", hash_generated_field = "9F5E7AC4133D8487455601C9F96E1A3C")

    private ContentObserver mSelfObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.273 -0400", hash_original_field = "87455A359B1A9ED854BD5AE788E48D3E", hash_generated_field = "4C02160A90BA5155F5F62D4DB964E4F3")

    private Object mSelfObserverLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.273 -0400", hash_original_field = "01A6D38D51886A1F7EA04036058C5E65", hash_generated_field = "4ADE0DF6292D7C36DC52F0723F9E0950")

    private boolean mSelfObserverRegistered;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.285 -0400", hash_original_method = "F60281D0CC7516E8B7AB1E4DD5850BC4", hash_generated_method = "3B5E09C25C600EDC4F66CDCD37507170")
    public  AbstractCursor() {
        mPos = -1;
        mRowIdColumnIndex = -1;
        mCurrentRowID = null;
        mUpdatedRows = new HashMap<Long, Map<String, Object>>();
        // ---------- Original Method ----------
        //mPos = -1;
        //mRowIdColumnIndex = -1;
        //mCurrentRowID = null;
        //mUpdatedRows = new HashMap<Long, Map<String, Object>>();
    }

    
    abstract public int getCount();

    
    abstract public String[] getColumnNames();

    
    abstract public String getString(int column);

    
    abstract public short getShort(int column);

    
    abstract public int getInt(int column);

    
    abstract public long getLong(int column);

    
    abstract public float getFloat(int column);

    
    abstract public double getDouble(int column);

    
    abstract public boolean isNull(int column);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.289 -0400", hash_original_method = "DA5F8C1E79CBE35B90A3C92DA2B8F28D", hash_generated_method = "A631DD69EB0CB8A881DC232045E3AF05")
    public int getType(int column) {
        addTaint(column);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1660868845 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1660868845;
        // ---------- Original Method ----------
        //return FIELD_TYPE_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.312 -0400", hash_original_method = "5BC3F93BAD50F14F34AFA39612F89CC6", hash_generated_method = "D8436567243F81E5D70DE03952D4EB78")
    public byte[] getBlob(int column) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("getBlob is not supported");
        addTaint(column);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_545160356 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_545160356;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("getBlob is not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.313 -0400", hash_original_method = "DD0E28415E6C930BA9DBA04095F3A7EA", hash_generated_method = "DB01969E071A68623AFC1534F3618B35")
    public CursorWindow getWindow() {
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_1489606714 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1489606714 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1489606714.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1489606714;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.313 -0400", hash_original_method = "97CA757ED7462ACFFD2DF70EB3327BE9", hash_generated_method = "8F9D8C0D0C9E0BA9795C18BD56C0CE2A")
    public int getColumnCount() {
        int varE598DA0DE038A65D9C059A044E9E4C36_1123456081 = (getColumnNames().length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747540706 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747540706;
        // ---------- Original Method ----------
        //return getColumnNames().length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.332 -0400", hash_original_method = "FE85B15F7B4AB77AD59F907B33A4DE11", hash_generated_method = "17FE726C99E84E75E28F21C8A3D0BF8F")
    public void deactivate() {
        onDeactivateOrClose();
        // ---------- Original Method ----------
        //onDeactivateOrClose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.333 -0400", hash_original_method = "5696E4CEEE521AD3C05FDA1D1F1B30F5", hash_generated_method = "1A88E5AE7EDDB03D758D160469F2BE50")
    protected void onDeactivateOrClose() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mContentResolver.unregisterContentObserver(mSelfObserver);
            mSelfObserverRegistered = false;
        } //End block
        mDataSetObservable.notifyInvalidated();
        // ---------- Original Method ----------
        //if (mSelfObserver != null) {
            //mContentResolver.unregisterContentObserver(mSelfObserver);
            //mSelfObserverRegistered = false;
        //}
        //mDataSetObservable.notifyInvalidated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.336 -0400", hash_original_method = "6C342ADEDDD7EC7E0C1CE765BD80D8D1", hash_generated_method = "6C63F549F9ECCDB3E0CB405455EC0026")
    public boolean requery() {
        {
            mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            mSelfObserverRegistered = true;
        } //End block
        mDataSetObservable.notifyChanged();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_260211284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_260211284;
        // ---------- Original Method ----------
        //if (mSelfObserver != null && mSelfObserverRegistered == false) {
            //mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            //mSelfObserverRegistered = true;
        //}
        //mDataSetObservable.notifyChanged();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.337 -0400", hash_original_method = "B825EEA007B34E9E28068D61BE8C7018", hash_generated_method = "5084DFB68DAA0D031C359C67F17F7F4E")
    public boolean isClosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1525594277 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1525594277;
        // ---------- Original Method ----------
        //return mClosed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.356 -0400", hash_original_method = "75E7685835D22353FA19EABDEF4435E7", hash_generated_method = "2BF4E0E42FFFCB99FDCE632E9C0D4D96")
    public void close() {
        mClosed = true;
        mContentObservable.unregisterAll();
        onDeactivateOrClose();
        // ---------- Original Method ----------
        //mClosed = true;
        //mContentObservable.unregisterAll();
        //onDeactivateOrClose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.357 -0400", hash_original_method = "316C43B210EB72CE31C6D4E542FB15C5", hash_generated_method = "4A1C622DA9B7C4A998388303BF2F1A56")
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldPosition);
        addTaint(newPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_771772109 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_771772109;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.360 -0400", hash_original_method = "8CF2CB9941A08AAA09DBF5869325E31C", hash_generated_method = "850761B522620810BD65B3923E18848B")
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        String result;
        result = getString(columnIndex);
        {
            char[] data;
            data = buffer.data;
            {
                boolean varB3C493CCA0A5FEEBFBA4E5B6E1AC0832_621533801 = (data == null || data.length < result.length());
                {
                    buffer.data = result.toCharArray();
                } //End block
                {
                    result.getChars(0, result.length(), data, 0);
                } //End block
            } //End collapsed parenthetic
            buffer.sizeCopied = result.length();
        } //End block
        {
            buffer.sizeCopied = 0;
        } //End block
        addTaint(columnIndex);
        addTaint(buffer.getTaint());
        // ---------- Original Method ----------
        //String result = getString(columnIndex);
        //if (result != null) {
            //char[] data = buffer.data;
            //if (data == null || data.length < result.length()) {
                //buffer.data = result.toCharArray();
            //} else {
                //result.getChars(0, result.length(), data, 0);
            //}
            //buffer.sizeCopied = result.length();
        //} else {
            //buffer.sizeCopied = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.373 -0400", hash_original_method = "EC88CAE72DCB37222F19A173793DEE6F", hash_generated_method = "3D817C6093EFD1D00730C3442927FDDF")
    public final int getPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2018556137 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2018556137;
        // ---------- Original Method ----------
        //return mPos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.389 -0400", hash_original_method = "65BBCEF155E9F61984647ADC3CD9D8D5", hash_generated_method = "A4FB7A39DDD44254BC95B537E550C528")
    public final boolean moveToPosition(int position) {
        int count;
        count = getCount();
        {
            mPos = count;
        } //End block
        {
            mPos = -1;
        } //End block
        boolean result;
        result = onMove(mPos, position);
        {
            mPos = -1;
        } //End block
        {
            mPos = position;
            {
                mCurrentRowID = Long.valueOf(getLong(mRowIdColumnIndex));
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1454075341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1454075341;
        // ---------- Original Method ----------
        //final int count = getCount();
        //if (position >= count) {
            //mPos = count;
            //return false;
        //}
        //if (position < 0) {
            //mPos = -1;
            //return false;
        //}
        //if (position == mPos) {
            //return true;
        //}
        //boolean result = onMove(mPos, position);
        //if (result == false) {
            //mPos = -1;
        //} else {
            //mPos = position;
            //if (mRowIdColumnIndex != -1) {
                //mCurrentRowID = Long.valueOf(getLong(mRowIdColumnIndex));
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.402 -0400", hash_original_method = "6FC66EDC6A2293E690F6FEA8028519D4", hash_generated_method = "F3F1A8E4F0039670932F69218A3019CF")
    @Override
    public void fillWindow(int position, CursorWindow window) {
        DatabaseUtils.cursorFillWindow(this, position, window);
        addTaint(position);
        addTaint(window.getTaint());
        // ---------- Original Method ----------
        //DatabaseUtils.cursorFillWindow(this, position, window);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.403 -0400", hash_original_method = "389B6720AF899474C54E777E5A800C06", hash_generated_method = "F5B2ED1ADEF902A3F1B0973DB4A5249D")
    public final boolean move(int offset) {
        boolean varA63C7CEC1F816BE1838C38173C94CB20_171227681 = (moveToPosition(mPos + offset));
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1193826354 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1193826354;
        // ---------- Original Method ----------
        //return moveToPosition(mPos + offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.403 -0400", hash_original_method = "B3EA5CAC0D9EF5BCE0C71FFF26BBF7DF", hash_generated_method = "5C83DAE330D3969DBD4A93F983F59C4E")
    public final boolean moveToFirst() {
        boolean var7169217BA523AE68C1F7B0C7563B6D2F_2004989215 = (moveToPosition(0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_468720644 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_468720644;
        // ---------- Original Method ----------
        //return moveToPosition(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.404 -0400", hash_original_method = "A0FD9DA9666B94596708F3F8CB94A387", hash_generated_method = "7344A0C06D1F57EED8417BA02374E8E8")
    public final boolean moveToLast() {
        boolean var883322E63C74EFF5BA3E9BBFA1EB0817_666061045 = (moveToPosition(getCount() - 1));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1068831041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1068831041;
        // ---------- Original Method ----------
        //return moveToPosition(getCount() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.405 -0400", hash_original_method = "44D940C3A0E42253110DBD8C1211FDCC", hash_generated_method = "238EB2F4F4D6C060D230203E06A3F9CC")
    public final boolean moveToNext() {
        boolean var6557A178A7D0E5B123127618582893AA_1479774300 = (moveToPosition(mPos + 1));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1799932246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1799932246;
        // ---------- Original Method ----------
        //return moveToPosition(mPos + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.424 -0400", hash_original_method = "70B7D1CBA52F6D8A8ABC528A78C51C39", hash_generated_method = "C965B9018A508907C389E5DDEF401F04")
    public final boolean moveToPrevious() {
        boolean var62DFA72D2B670D9088C02CC6B3B7A7B4_141282098 = (moveToPosition(mPos - 1));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_500527097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_500527097;
        // ---------- Original Method ----------
        //return moveToPosition(mPos - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.430 -0400", hash_original_method = "9906FDA9BB1856CC0A1F7D5381F7AEF7", hash_generated_method = "2CAFC2ADBF6DFA80552730CF5708968F")
    public final boolean isFirst() {
        boolean varADB2B3DA6A35A98BE1B5E66B40FE6B61_31436495 = (mPos == 0 && getCount() != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1791499665 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1791499665;
        // ---------- Original Method ----------
        //return mPos == 0 && getCount() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.446 -0400", hash_original_method = "5D098944D57453F70DEC79DF938E50E8", hash_generated_method = "06E0AFD452BB068A9F8918EFABE0E1BA")
    public final boolean isLast() {
        int cnt;
        cnt = getCount();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_495890490 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_495890490;
        // ---------- Original Method ----------
        //int cnt = getCount();
        //return mPos == (cnt - 1) && cnt != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.448 -0400", hash_original_method = "BEAF42FFABF4F6277016BED9CE1900CE", hash_generated_method = "8FBC21BA81188154BF54E6B48D758BF4")
    public final boolean isBeforeFirst() {
        {
            boolean var1E308F1B2924DF35832B0C6653D5399D_2036819363 = (getCount() == 0);
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1472536461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1472536461;
        // ---------- Original Method ----------
        //if (getCount() == 0) {
            //return true;
        //}
        //return mPos == -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.452 -0400", hash_original_method = "EBC209D2038AD2122CD62927CB78B2F3", hash_generated_method = "989D393C12C495BA08D5BEFD38E8866A")
    public final boolean isAfterLast() {
        {
            boolean var1E308F1B2924DF35832B0C6653D5399D_1617249633 = (getCount() == 0);
        } //End collapsed parenthetic
        boolean var0FABA7953C222ACDE339B5487276FBD9_1950926617 = (mPos == getCount());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1183204045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1183204045;
        // ---------- Original Method ----------
        //if (getCount() == 0) {
            //return true;
        //}
        //return mPos == getCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.468 -0400", hash_original_method = "1BC2DDCF2F027B280B5593E829676223", hash_generated_method = "2D06F2B59A82B8257FC20025C43343C9")
    public int getColumnIndex(String columnName) {
        int periodIndex;
        periodIndex = columnName.lastIndexOf('.');
        {
            Exception e;
            e = new Exception();
            columnName = columnName.substring(periodIndex + 1);
        } //End block
        String columnNames[];
        columnNames = getColumnNames();
        int length;
        length = columnNames.length;
        {
            int i;
            i = 0;
            {
                {
                    boolean var8A92D03C059C3C4A74106A947683F96E_2021296347 = (columnNames[i].equalsIgnoreCase(columnName));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varFC53D64D8090E12EDE66C4B1525878D8_1154202823 = (getCount() > 0);
            } //End collapsed parenthetic
        } //End block
        addTaint(columnName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068680269 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068680269;
        // ---------- Original Method ----------
        //final int periodIndex = columnName.lastIndexOf('.');
        //if (periodIndex != -1) {
            //Exception e = new Exception();
            //Log.e(TAG, "requesting column name with table name -- " + columnName, e);
            //columnName = columnName.substring(periodIndex + 1);
        //}
        //String columnNames[] = getColumnNames();
        //int length = columnNames.length;
        //for (int i = 0; i < length; i++) {
            //if (columnNames[i].equalsIgnoreCase(columnName)) {
                //return i;
            //}
        //}
        //if (false) {
            //if (getCount() > 0) {
                //Log.w("AbstractCursor", "Unknown column " + columnName);
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.479 -0400", hash_original_method = "7BAA81DCDF7699C82AB2A31918E9C0C1", hash_generated_method = "71E98BF4C4FB3D4CDD733A89CDF2B359")
    public int getColumnIndexOrThrow(String columnName) {
        int index;
        index = getColumnIndex(columnName);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("column '" + columnName + "' does not exist");
        } //End block
        addTaint(columnName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828430464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828430464;
        // ---------- Original Method ----------
        //final int index = getColumnIndex(columnName);
        //if (index < 0) {
            //throw new IllegalArgumentException("column '" + columnName + "' does not exist");
        //}
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.480 -0400", hash_original_method = "2C8B9F57D7BABEC67595057D4A416343", hash_generated_method = "F409DADCA6606EA7E2DCF6556970E04E")
    public String getColumnName(int columnIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_1152964283 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1152964283 = getColumnNames()[columnIndex];
        addTaint(columnIndex);
        varB4EAC82CA7396A68D541C85D26508E83_1152964283.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1152964283;
        // ---------- Original Method ----------
        //return getColumnNames()[columnIndex];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.484 -0400", hash_original_method = "969C8D7FAD299958455EEA8274658457", hash_generated_method = "AEFA561A03BB5A433531253EF2321E96")
    public void registerContentObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mContentObservable.registerObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mContentObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.493 -0400", hash_original_method = "0986E51B80B8DF6AE5336EB6410DC9C5", hash_generated_method = "81BB786F388406F395DE8392F002749E")
    public void unregisterContentObserver(ContentObserver observer) {
        {
            mContentObservable.unregisterObserver(observer);
        } //End block
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //if (!mClosed) {
            //mContentObservable.unregisterObserver(observer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.493 -0400", hash_original_method = "C09BE1AB0F1EB5BF63EC2A314B1EC0E8", hash_generated_method = "362A8921CADC3161CC20FD83BD5E4602")
    protected void notifyDataSetChange() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.513 -0400", hash_original_method = "9CE71984FA039D61518575C1361CCA79", hash_generated_method = "026423F21B0222D7CC743A40D608E112")
    protected DataSetObservable getDataSetObservable() {
        DataSetObservable varB4EAC82CA7396A68D541C85D26508E83_1809606363 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1809606363 = mDataSetObservable;
        varB4EAC82CA7396A68D541C85D26508E83_1809606363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1809606363;
        // ---------- Original Method ----------
        //return mDataSetObservable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.514 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "D80BACDB53770E495497918A52F212CE")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mDataSetObservable.registerObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.515 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "18957645919BC1B25C95D955828DA072")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.522 -0400", hash_original_method = "46E00F9025A0D5563AEDF0BD12648840", hash_generated_method = "C9F66A0A4C719B0A7060BD7592750D7C")
    protected void onChange(boolean selfChange) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mContentObservable.dispatchChange(selfChange);
            {
                mContentResolver.notifyChange(mNotifyUri, mSelfObserver);
            } //End block
        } //End block
        addTaint(selfChange);
        // ---------- Original Method ----------
        //synchronized (mSelfObserverLock) {
            //mContentObservable.dispatchChange(selfChange);
            //if (mNotifyUri != null && selfChange) {
                //mContentResolver.notifyChange(mNotifyUri, mSelfObserver);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.525 -0400", hash_original_method = "265F32C67EE2A711D5C4BAD496137660", hash_generated_method = "E3AB4642C1A122863411A22FBA701D35")
    public void setNotificationUri(ContentResolver cr, Uri notifyUri) {
        {
            mNotifyUri = notifyUri;
            mContentResolver = cr;
            {
                mContentResolver.unregisterContentObserver(mSelfObserver);
            } //End block
            mSelfObserver = new SelfContentObserver(this);
            mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            mSelfObserverRegistered = true;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSelfObserverLock) {
            //mNotifyUri = notifyUri;
            //mContentResolver = cr;
            //if (mSelfObserver != null) {
                //mContentResolver.unregisterContentObserver(mSelfObserver);
            //}
            //mSelfObserver = new SelfContentObserver(this);
            //mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            //mSelfObserverRegistered = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.545 -0400", hash_original_method = "DDB9421669E815EA51C0F68469B23471", hash_generated_method = "8304FF525554EE347730992CA1105D18")
    public Uri getNotificationUri() {
        Uri varB4EAC82CA7396A68D541C85D26508E83_97653781 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_97653781 = mNotifyUri;
        varB4EAC82CA7396A68D541C85D26508E83_97653781.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_97653781;
        // ---------- Original Method ----------
        //return mNotifyUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.546 -0400", hash_original_method = "95EB5F956072F4428350A5713DB4F16C", hash_generated_method = "85773C4C92103CD3A74870BD16FBDF02")
    public boolean getWantsAllOnMoveCalls() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1622444294 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1622444294;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.547 -0400", hash_original_method = "FFD927D835EC033CA0D5789154520D3B", hash_generated_method = "598746C945848452E29BDC82DB3737FA")
    public void setExtras(Bundle extras) {
        mExtras = (extras == null) ? Bundle.EMPTY : extras;
        // ---------- Original Method ----------
        //mExtras = (extras == null) ? Bundle.EMPTY : extras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.570 -0400", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "8B882EF9D5EF1A68DE3F623B44876F45")
    public Bundle getExtras() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_957152209 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_957152209 = mExtras;
        varB4EAC82CA7396A68D541C85D26508E83_957152209.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_957152209;
        // ---------- Original Method ----------
        //return mExtras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.571 -0400", hash_original_method = "0DCA3EA5579BB07DA7E61D916C230104", hash_generated_method = "474DC5B52907AA5AC2043FB09CF9E224")
    public Bundle respond(Bundle extras) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_114169091 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_114169091 = Bundle.EMPTY;
        addTaint(extras.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_114169091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_114169091;
        // ---------- Original Method ----------
        //return Bundle.EMPTY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.573 -0400", hash_original_method = "038210FB7F6D7350A83F25D9DA43B6B8", hash_generated_method = "04FD1A616CA8C8F55DE4D011CF557750")
    @Deprecated
    protected boolean isFieldUpdated(int columnIndex) {
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_756770645 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_756770645;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.574 -0400", hash_original_method = "C12342D6451FF7A0A51B2EFC9932FDFD", hash_generated_method = "8A428E3915120829374695DA050229C6")
    @Deprecated
    protected Object getUpdatedField(int columnIndex) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1949325819 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1949325819 = null;
        addTaint(columnIndex);
        varB4EAC82CA7396A68D541C85D26508E83_1949325819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1949325819;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.574 -0400", hash_original_method = "D69CAFAFBC9C61DD3802AD1DC7C32FD3", hash_generated_method = "0C4AC6F78BCE7FD1B091FF678E1CA06C")
    protected void checkPosition() {
        {
            boolean var63B4E4AC12944E47003AF0905D5ED5FF_983105177 = (-1 == mPos || getCount() == mPos);
            {
                if (DroidSafeAndroidRuntime.control) throw new CursorIndexOutOfBoundsException(mPos, getCount());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (-1 == mPos || getCount() == mPos) {
            //throw new CursorIndexOutOfBoundsException(mPos, getCount());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.575 -0400", hash_original_method = "F26D041066C4F03E188153BABFEE500A", hash_generated_method = "527FAC0CAA846B70BB6AE3177A20EE40")
    @Override
    protected void finalize() {
        {
            mContentResolver.unregisterContentObserver(mSelfObserver);
        } //End block
        // ---------- Original Method ----------
        //if (mSelfObserver != null && mSelfObserverRegistered == true) {
            //mContentResolver.unregisterContentObserver(mSelfObserver);
        //}
    }

    
    protected static class SelfContentObserver extends ContentObserver {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.589 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "703A671C4ACC07BD23149F0A5FD18BB7")

        WeakReference<AbstractCursor> mCursor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.590 -0400", hash_original_method = "F9E51D895511CEE60B782983BAF87140", hash_generated_method = "1C8FE0B53CDA67BB2D5E07BFD3F83569")
        public  SelfContentObserver(AbstractCursor cursor) {
            super(null);
            mCursor = new WeakReference<AbstractCursor>(cursor);
            // ---------- Original Method ----------
            //mCursor = new WeakReference<AbstractCursor>(cursor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.590 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "60CA90DC09DF631C9928EDC63CA350CE")
        @Override
        public boolean deliverSelfNotifications() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_732272198 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_732272198;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.611 -0400", hash_original_method = "DA6E4383047955D7231484890E1F062B", hash_generated_method = "B107DC03B792C67C9F5DF156F68CB3C5")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            AbstractCursor cursor;
            cursor = mCursor.get();
            {
                cursor.onChange(false);
            } //End block
            addTaint(selfChange);
            // ---------- Original Method ----------
            //AbstractCursor cursor = mCursor.get();
            //if (cursor != null) {
                //cursor.onChange(false);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.611 -0400", hash_original_field = "DC537D9C80C940A5B4FF394A8B2339AB", hash_generated_field = "83D8F62B166FF393281884A03CF64D6D")

    private static String TAG = "Cursor";
}

