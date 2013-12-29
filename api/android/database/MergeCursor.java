package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class MergeCursor extends AbstractCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.034 -0400", hash_original_field = "FA2BE9015D45FC980588BB7AE26DD67B", hash_generated_field = "B973D0B16972B08EE0EC04C0BE89E3D7")

    private DataSetObserver mObserver = new DataSetObserver() {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.527 -0500", hash_original_method = "F00E20B7880C90825F84FA73002A8738", hash_generated_method = "AE1F091769F4914FA814B6CB3FCBC73F")
        @Override
public void onChanged() {
            // Reset our position so the optimizations in move-related code
            // don't screw us over
            mPos = -1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.528 -0500", hash_original_method = "4CD83AD480AFA6CEDD96BF4385EF1A22", hash_generated_method = "64D28911E57466DBCD10697DB3A6E99B")
        @Override
public void onInvalidated() {
            mPos = -1;
        }

        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.547 -0500", hash_original_field = "4A85E902ED72E65A9AF8F6ED265E4F89", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")


    private Cursor mCursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.548 -0500", hash_original_field = "BFC46F58E76AA74F65A9C26229E79F96", hash_generated_field = "0942DA24BE4E32B4E9FADB0B3647107E")

    private Cursor[] mCursors;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.530 -0500", hash_original_method = "2995FF0D63D655B99F24232D11D6842D", hash_generated_method = "928EDDB9AF01D8A13D365B7ACF9E0170")
    public MergeCursor(Cursor[] cursors)
    {
        mCursors = cursors;
        mCursor = cursors[0];
        
        for (int i = 0; i < mCursors.length; i++) {
            if (mCursors[i] == null) continue;
            
            mCursors[i].registerDataSetObserver(mObserver);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.531 -0500", hash_original_method = "C94247264BA1143A8EFEBC4EA367BD4C", hash_generated_method = "E2DA0373B706ED60B98BB7FB33055AE0")
    @Override
public int getCount()
    {
        int count = 0;
        int length = mCursors.length;
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] != null) {
                count += mCursors[i].getCount();
            }
        }
        return count;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.532 -0500", hash_original_method = "2E36F9108221D554FB6CCFC9204351EF", hash_generated_method = "471005C011B85B27DDCF95340D472B02")
    @Override
public boolean onMove(int oldPosition, int newPosition)
    {
        /* Find the right cursor */
        mCursor = null;
        int cursorStartPos = 0;
        int length = mCursors.length;
        for (int i = 0 ; i < length; i++) {
            if (mCursors[i] == null) {
                continue;
            }
            
            if (newPosition < (cursorStartPos + mCursors[i].getCount())) {
                mCursor = mCursors[i];
                break;
            }

            cursorStartPos += mCursors[i].getCount();
        }

        /* Move it to the right position */
        if (mCursor != null) {
            boolean ret = mCursor.moveToPosition(newPosition - cursorStartPos);
            return ret;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.533 -0500", hash_original_method = "3CE824B95C82F11BF58FC21A90C6596E", hash_generated_method = "ED07F326C66A892800FB63C8FCD37B48")
    @Override
public String getString(int column)
    {
        return mCursor.getString(column);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.533 -0500", hash_original_method = "E017157A16B41C5A1732268363B588AE", hash_generated_method = "7EEB726C0B341CEB5DDFEAB5EBA9B598")
    @Override
public short getShort(int column)
    {
        return mCursor.getShort(column);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.534 -0500", hash_original_method = "196BE6610F391149CB98C678C09840A9", hash_generated_method = "C28D8796BE04004FA31D5BCAE54426AF")
    @Override
public int getInt(int column)
    {
        return mCursor.getInt(column);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.535 -0500", hash_original_method = "F9F66E8E22111A5FD3479C47D664F15E", hash_generated_method = "9237FC8AD54C22425AC591AF532E0CF4")
    @Override
public long getLong(int column)
    {
        return mCursor.getLong(column);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.536 -0500", hash_original_method = "67B17E1A8809B30C69BA5C708B2EF661", hash_generated_method = "CA828043A5B9695000514DFE1A935D65")
    @Override
public float getFloat(int column)
    {
        return mCursor.getFloat(column);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.537 -0500", hash_original_method = "977D6BDEB2B1108A87BD2446DF855014", hash_generated_method = "9FE0CB8D8CA2F42105E397AC4001F939")
    @Override
public double getDouble(int column)
    {
        return mCursor.getDouble(column);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.537 -0500", hash_original_method = "EA5E8A29C1728085016D3A247FDA0EC9", hash_generated_method = "77FBE8C5B4CFC8958A0D479BC66DDA83")
    @Override
public int getType(int column) {
        return mCursor.getType(column);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.538 -0500", hash_original_method = "A230025A9AF792B73F7279DEAF8B2408", hash_generated_method = "0E700442205B809B3ED3313970769265")
    @Override
public boolean isNull(int column)
    {
        return mCursor.isNull(column);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.539 -0500", hash_original_method = "9D3EADEAB6620E0607DB05CBA4EF5895", hash_generated_method = "8C73EB5E7F8882B29B28A306EBBD8727")
    @Override
public byte[] getBlob(int column)
    {
        return mCursor.getBlob(column);   
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.540 -0500", hash_original_method = "EAE2D1400909F2A5DEAF3F19FC10B4CB", hash_generated_method = "5D70EF17D89E7233687402F804F6C7F8")
    @Override
public String[] getColumnNames()
    {
        if (mCursor != null) {
            return mCursor.getColumnNames();
        } else {
            return new String[0];
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.541 -0500", hash_original_method = "48B51AF9DDDB4824C213FEDC18251646", hash_generated_method = "9DFB64AF55E47A95C67357AC22A95BA5")
    @Override
public void deactivate()
    {
        int length = mCursors.length;
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] != null) {
                mCursors[i].deactivate();
            }
        }
        super.deactivate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.542 -0500", hash_original_method = "1ACEC7472EA47D5758C352132E064427", hash_generated_method = "5B8B15F7C3A35C64CDE6FC9BBD04DD80")
    @Override
public void close() {
        int length = mCursors.length;
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] == null) continue;
            mCursors[i].close();
        }
        super.close();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.542 -0500", hash_original_method = "9B33826E9FF931F2B698CFF4E2E845A6", hash_generated_method = "699A994693AD3652ABA85A62B8365551")
    @Override
public void registerContentObserver(ContentObserver observer) {
        int length = mCursors.length;
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] != null) {
                mCursors[i].registerContentObserver(observer);
            }
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.543 -0500", hash_original_method = "CAE2DD1D134D44BF9E6E60CE9B9708BE", hash_generated_method = "88B10E68A382567979235EB4623EA52C")
    @Override
public void unregisterContentObserver(ContentObserver observer) {
        int length = mCursors.length;
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] != null) {
                mCursors[i].unregisterContentObserver(observer);
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.544 -0500", hash_original_method = "3D4B0E24965017562B726DF84968F4EF", hash_generated_method = "9F371C5FA059F5D78543BB6E762EC5D8")
    @Override
public void registerDataSetObserver(DataSetObserver observer) {
        int length = mCursors.length;
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] != null) {
                mCursors[i].registerDataSetObserver(observer);
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.545 -0500", hash_original_method = "E4FB1F85847F60D07EB9DA8ACAD3FA45", hash_generated_method = "36BE971EF7BD55D636EF54D72E480F3A")
    @Override
public void unregisterDataSetObserver(DataSetObserver observer) {
        int length = mCursors.length;
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] != null) {
                mCursors[i].unregisterDataSetObserver(observer);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.546 -0500", hash_original_method = "9EE537B6DD7ADECF245A94C8CF7C44F2", hash_generated_method = "69AC42D770C580628E218E85029919CE")
    @Override
public boolean requery()
    {
        int length = mCursors.length;
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] == null) {
                continue;
            }

            if (mCursors[i].requery() == false) {
                return false;
            }
        }

        return true;
    }

    
}

