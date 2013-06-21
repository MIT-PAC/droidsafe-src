package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import com.android.internal.os.IDropBoxManagerService;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class DropBoxManager {
    private IDropBoxManagerService mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.483 -0400", hash_original_method = "04B0A4DBB2EAE135AA112A8CAA9647B1", hash_generated_method = "FBD71771DFF717ADB1359F7C693A0579")
    @DSModeled(DSC.SAFE)
    public DropBoxManager(IDropBoxManagerService service) {
        dsTaint.addTaint(service.dsTaint);
        // ---------- Original Method ----------
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.483 -0400", hash_original_method = "E688A3A6CCC118BEDB51FAABD6872F4D", hash_generated_method = "1D2825C63C164429C45D67692FE8B561")
    @DSModeled(DSC.SAFE)
    protected DropBoxManager() {
        mService = null;
        // ---------- Original Method ----------
        //mService = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.483 -0400", hash_original_method = "B6329499D071F8AC982F0B19B7FB97DF", hash_generated_method = "022FCE16C3938214BF91620FC5D8D565")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addText(String tag, String data) {
        dsTaint.addTaint(tag);
        dsTaint.addTaint(data);
        try 
        {
            mService.add(new Entry(tag, 0, data));
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try { mService.add(new Entry(tag, 0, data)); } catch (RemoteException e) {}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.483 -0400", hash_original_method = "7BD48A32860AA6BD88FDC639FDB6D7D8", hash_generated_method = "FE629C9287DFF7A38C46789C96DD2AE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addData(String tag, byte[] data, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(data[0]);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("data == null");
        try 
        {
            mService.add(new Entry(tag, 0, data, flags));
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //if (data == null) throw new NullPointerException("data == null");
        //try { mService.add(new Entry(tag, 0, data, flags)); } catch (RemoteException e) {}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.484 -0400", hash_original_method = "BF97B72EB64F4DB129C9C48237659777", hash_generated_method = "657D50A1E39D6119AE417D4313DBFF97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addFile(String tag, File file, int flags) throws IOException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(tag);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("file == null");
        Entry entry;
        entry = new Entry(tag, 0, file, flags);
        try 
        {
            mService.add(entry);
        } //End block
        catch (RemoteException e)
        { }
        finally 
        {
            entry.close();
        } //End block
        // ---------- Original Method ----------
        //if (file == null) throw new NullPointerException("file == null");
        //Entry entry = new Entry(tag, 0, file, flags);
        //try {
            //mService.add(entry);
        //} catch (RemoteException e) {
        //} finally {
            //entry.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.484 -0400", hash_original_method = "0FE06F2CE6966672337D3755F0FF0CD0", hash_generated_method = "70BC752FEBBE10A684FE444AC134CD71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isTagEnabled(String tag) {
        dsTaint.addTaint(tag);
        try 
        {
            boolean var175D0364BFB4A88762C5ABCE62C258F0_1657298801 = (mService.isTagEnabled(tag));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try { return mService.isTagEnabled(tag); } catch (RemoteException e) { return false; }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.484 -0400", hash_original_method = "A691D94F864449A091C30E093C0F46CD", hash_generated_method = "4A0E2523E4056132208560C38B755EC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry getNextEntry(String tag, long msec) {
        dsTaint.addTaint(tag);
        dsTaint.addTaint(msec);
        try 
        {
            Entry varE20B09FFCDD386A34012797E11716AED_198802851 = (mService.getNextEntry(tag, msec));
        } //End block
        catch (RemoteException e)
        { }
        return (Entry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try { return mService.getNextEntry(tag, msec); } catch (RemoteException e) { return null; }
    }

    
    public static class Entry implements Parcelable, Closeable {
        private String mTag;
        private long mTimeMillis;
        private byte[] mData;
        private ParcelFileDescriptor mFileDescriptor;
        private int mFlags;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.485 -0400", hash_original_method = "59D4C7A828654550E9A00289F418A41B", hash_generated_method = "F6A56A6CE71D911FC7141BEAB9193A09")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry(String tag, long millis) {
            dsTaint.addTaint(tag);
            dsTaint.addTaint(millis);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("tag == null");
            mData = null;
            mFileDescriptor = null;
            mFlags = IS_EMPTY;
            // ---------- Original Method ----------
            //if (tag == null) throw new NullPointerException("tag == null");
            //mTag = tag;
            //mTimeMillis = millis;
            //mData = null;
            //mFileDescriptor = null;
            //mFlags = IS_EMPTY;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.485 -0400", hash_original_method = "3040DA05407F13E8561F02C468A7DEB4", hash_generated_method = "901FE752D126CD07C400737686A7F5F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry(String tag, long millis, String text) {
            dsTaint.addTaint(text);
            dsTaint.addTaint(tag);
            dsTaint.addTaint(millis);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("tag == null");
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("text == null");
            mData = text.getBytes();
            mFileDescriptor = null;
            mFlags = IS_TEXT;
            // ---------- Original Method ----------
            //if (tag == null) throw new NullPointerException("tag == null");
            //if (text == null) throw new NullPointerException("text == null");
            //mTag = tag;
            //mTimeMillis = millis;
            //mData = text.getBytes();
            //mFileDescriptor = null;
            //mFlags = IS_TEXT;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.486 -0400", hash_original_method = "182B4976A5D069A0C2E90B74F50A592D", hash_generated_method = "053922D1731B6463B488AF2F5A52263C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry(String tag, long millis, byte[] data, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(tag);
            dsTaint.addTaint(data[0]);
            dsTaint.addTaint(millis);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("tag == null");
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad flags: " + flags);
            } //End block
            mFileDescriptor = null;
            // ---------- Original Method ----------
            //if (tag == null) throw new NullPointerException("tag == null");
            //if (((flags & IS_EMPTY) != 0) != (data == null)) {
                //throw new IllegalArgumentException("Bad flags: " + flags);
            //}
            //mTag = tag;
            //mTimeMillis = millis;
            //mData = data;
            //mFileDescriptor = null;
            //mFlags = flags;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.486 -0400", hash_original_method = "98F6B6C49553AC4D3032798198FC694A", hash_generated_method = "DDCAF7CB97D93BF53864CED0042B1BEF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry(String tag, long millis, ParcelFileDescriptor data, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(tag);
            dsTaint.addTaint(data.dsTaint);
            dsTaint.addTaint(millis);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("tag == null");
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad flags: " + flags);
            } //End block
            mData = null;
            // ---------- Original Method ----------
            //if (tag == null) throw new NullPointerException("tag == null");
            //if (((flags & IS_EMPTY) != 0) != (data == null)) {
                //throw new IllegalArgumentException("Bad flags: " + flags);
            //}
            //mTag = tag;
            //mTimeMillis = millis;
            //mData = null;
            //mFileDescriptor = data;
            //mFlags = flags;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.487 -0400", hash_original_method = "102E401D4541F654441520BE506818C4", hash_generated_method = "7ADF7B3EE51538C293977086E01998B8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry(String tag, long millis, File data, int flags) throws IOException {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(tag);
            dsTaint.addTaint(data.dsTaint);
            dsTaint.addTaint(millis);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("tag == null");
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad flags: " + flags);
            mData = null;
            mFileDescriptor = ParcelFileDescriptor.open(data, ParcelFileDescriptor.MODE_READ_ONLY);
            // ---------- Original Method ----------
            //if (tag == null) throw new NullPointerException("tag == null");
            //if ((flags & IS_EMPTY) != 0) throw new IllegalArgumentException("Bad flags: " + flags);
            //mTag = tag;
            //mTimeMillis = millis;
            //mData = null;
            //mFileDescriptor = ParcelFileDescriptor.open(data, ParcelFileDescriptor.MODE_READ_ONLY);
            //mFlags = flags;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.487 -0400", hash_original_method = "377836285D1E96A0220618E9638425CD", hash_generated_method = "FE9BF441F4F88D70E70789299360E1CB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void close() {
            try 
            {
                mFileDescriptor.close();
            } //End block
            catch (IOException e)
            { }
            // ---------- Original Method ----------
            //try { if (mFileDescriptor != null) mFileDescriptor.close(); } catch (IOException e) { }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.487 -0400", hash_original_method = "ED26754F6A82B43F30EAE698B7941323", hash_generated_method = "1419DB16594EC41348962DFA434A1ACF")
        @DSModeled(DSC.SAFE)
        public String getTag() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mTag;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.487 -0400", hash_original_method = "6C399926D10F83AEDA9A5ADCC6A5D3A1", hash_generated_method = "3532B332B190432B07EEF8BD4C0254AF")
        @DSModeled(DSC.SAFE)
        public long getTimeMillis() {
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return mTimeMillis;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.488 -0400", hash_original_method = "DEBA147F1626153ABBF4AEA4FEEBC80F", hash_generated_method = "2611DFA6E9356D30253851384B5749AD")
        @DSModeled(DSC.SAFE)
        public int getFlags() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mFlags & ~IS_GZIPPED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.488 -0400", hash_original_method = "5115D4296A1E9A49B9B7627B57AD3F2E", hash_generated_method = "98CBCF6ADEF05AA33947758BFB4BED25")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getText(int maxBytes) {
            dsTaint.addTaint(maxBytes);
            String var54699EB5A757E3420F16F63D67EDA4B4_465787996 = (new String(mData, 0, Math.min(maxBytes, mData.length)));
            InputStream is;
            is = null;
            try 
            {
                is = getInputStream();
                byte[] buf;
                buf = new byte[maxBytes];
                int readBytes;
                readBytes = 0;
                int n;
                n = 0;
                {
                    boolean varF9720F5057F50303867139DD98C6B9EC_241925397 = (n >= 0 && (readBytes += n) < maxBytes);
                    {
                        n = is.read(buf, readBytes, maxBytes - readBytes);
                    } //End block
                } //End collapsed parenthetic
                String varE87550411D4C5272A791159EE9311000_2142145896 = (new String(buf, 0, readBytes));
            } //End block
            catch (IOException e)
            { }
            finally 
            {
                try 
                {
                    is.close();
                } //End block
                catch (IOException e)
                { }
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //if ((mFlags & IS_TEXT) == 0) return null;
            //if (mData != null) return new String(mData, 0, Math.min(maxBytes, mData.length));
            //InputStream is = null;
            //try {
                //is = getInputStream();
                //if (is == null) return null;
                //byte[] buf = new byte[maxBytes];
                //int readBytes = 0;
                //int n = 0;
                //while (n >= 0 && (readBytes += n) < maxBytes) {
                    //n = is.read(buf, readBytes, maxBytes - readBytes);
                //}
                //return new String(buf, 0, readBytes);
            //} catch (IOException e) {
                //return null;
            //} finally {
                //try { if (is != null) is.close(); } catch (IOException e) {}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.489 -0400", hash_original_method = "1138A2AC2CDA63F5FD2C1DAD635BB1B0", hash_generated_method = "4B18700FF792064B216B50773581C4F1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InputStream getInputStream() throws IOException {
            InputStream is;
            {
                is = new ByteArrayInputStream(mData);
            } //End block
            {
                is = new ParcelFileDescriptor.AutoCloseInputStream(mFileDescriptor);
            } //End block
            {
                Object var9642881956CE93B01A340183722749FC_1977933073 = (new GZIPInputStream(is));
            } //End flattened ternary
            return (InputStream)dsTaint.getTaint();
            // ---------- Original Method ----------
            //InputStream is;
            //if (mData != null) {
                //is = new ByteArrayInputStream(mData);
            //} else if (mFileDescriptor != null) {
                //is = new ParcelFileDescriptor.AutoCloseInputStream(mFileDescriptor);
            //} else {
                //return null;
            //}
            //return (mFlags & IS_GZIPPED) != 0 ? new GZIPInputStream(is) : is;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.489 -0400", hash_original_method = "CE12D992AD97C7CB4D92B660FD5831CC", hash_generated_method = "07E3974A1D2A118E299E279D2D10136C")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mFileDescriptor != null ? Parcelable.CONTENTS_FILE_DESCRIPTOR : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.489 -0400", hash_original_method = "651672D7808B55AEFC112D3455309C97", hash_generated_method = "FB48DDE1E3B578C98B7E168A89AEF263")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel out, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(out.dsTaint);
            out.writeString(mTag);
            out.writeLong(mTimeMillis);
            {
                out.writeInt(mFlags & ~HAS_BYTE_ARRAY);
                mFileDescriptor.writeToParcel(out, flags);
            } //End block
            {
                out.writeInt(mFlags | HAS_BYTE_ARRAY);
                out.writeByteArray(mData);
            } //End block
            // ---------- Original Method ----------
            //out.writeString(mTag);
            //out.writeLong(mTimeMillis);
            //if (mFileDescriptor != null) {
                //out.writeInt(mFlags & ~HAS_BYTE_ARRAY);  
                //mFileDescriptor.writeToParcel(out, flags);
            //} else {
                //out.writeInt(mFlags | HAS_BYTE_ARRAY);
                //out.writeByteArray(mData);
            //}
        }

        
        public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.489 -0400", hash_original_method = "A391752DBE5FDE90AB459A0FCBEFF4D2", hash_generated_method = "1EF3A62BA465D8DBC330010FD0D9121E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Entry[] newArray(int size) {
                dsTaint.addTaint(size);
                Entry[] var280DB17A152E5DABAB0236B42BAFBE52_1635793068 = (new Entry[size]);
                return (Entry[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new Entry[size];
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.490 -0400", hash_original_method = "946DD766314338FFDBA7B29D274BE59A", hash_generated_method = "CC34261FE04502AD6E05AA734AB3A713")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Entry createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                String tag;
                tag = in.readString();
                long millis;
                millis = in.readLong();
                int flags;
                flags = in.readInt();
                {
                    Entry var025A227C6F8E960A091C2028544CDAC6_1679082272 = (new Entry(tag, millis, in.createByteArray(), flags & ~HAS_BYTE_ARRAY));
                } //End block
                {
                    Entry var07809DD940529C66120528EFFFB7B9F9_875020770 = (new Entry(tag, millis, in.readFileDescriptor(), flags));
                } //End block
                return (Entry)dsTaint.getTaint();
                // ---------- Original Method ----------
                //String tag = in.readString();
                //long millis = in.readLong();
                //int flags = in.readInt();
                //if ((flags & HAS_BYTE_ARRAY) != 0) {
                    //return new Entry(tag, millis, in.createByteArray(), flags & ~HAS_BYTE_ARRAY);
                //} else {
                    //return new Entry(tag, millis, in.readFileDescriptor(), flags);
                //}
            }

            
}; //Transformed anonymous class
    }


    
    private static final String TAG = "DropBoxManager";
    public static final int IS_EMPTY = 1;
    public static final int IS_TEXT = 2;
    public static final int IS_GZIPPED = 4;
    private static final int HAS_BYTE_ARRAY = 8;
    public static final String ACTION_DROPBOX_ENTRY_ADDED =
        "android.intent.action.DROPBOX_ENTRY_ADDED";
    public static final String EXTRA_TAG = "tag";
    public static final String EXTRA_TIME = "time";
}

