package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.TimeUtils;

public final class Message implements Parcelable {
    public int what;
    public int arg1;
    public int arg2;
    public Object obj;
    public Messenger replyTo;
    int flags;
    long when;
    Bundle data;
    Handler target;
    Runnable callback;
    Message next;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.788 -0400", hash_original_method = "07161C5E5BFC528DA3FC2F6017B16172", hash_generated_method = "95F5AD60FAEEEF50B67BC5FEEDEC5F61")
    @DSModeled(DSC.SAFE)
    public Message() {
        // ---------- Original Method ----------
    }

    
        public static Message obtain() {
        synchronized (sPoolSync) {
            if (sPool != null) {
                Message m = sPool;
                sPool = m.next;
                m.next = null;
                sPoolSize--;
                return m;
            }
        }
        return new Message();
    }

    
        public static Message obtain(Message orig) {
        Message m = obtain();
        m.what = orig.what;
        m.arg1 = orig.arg1;
        m.arg2 = orig.arg2;
        m.obj = orig.obj;
        m.replyTo = orig.replyTo;
        if (orig.data != null) {
            m.data = new Bundle(orig.data);
        }
        m.target = orig.target;
        m.callback = orig.callback;
        return m;
    }

    
        public static Message obtain(Handler h) {
        Message m = obtain();
        m.target = h;
        return m;
    }

    
        public static Message obtain(Handler h, Runnable callback) {
        Message m = obtain();
        m.target = h;
        m.callback = callback;
        return m;
    }

    
        public static Message obtain(Handler h, int what) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        return m;
    }

    
        public static Message obtain(Handler h, int what, Object obj) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.obj = obj;
        return m;
    }

    
        public static Message obtain(Handler h, int what, int arg1, int arg2) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.arg1 = arg1;
        m.arg2 = arg2;
        return m;
    }

    
        public static Message obtain(Handler h, int what, 
            int arg1, int arg2, Object obj) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.arg1 = arg1;
        m.arg2 = arg2;
        m.obj = obj;
        return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.798 -0400", hash_original_method = "0036C7E97F14F697C30BFE1437947C9D", hash_generated_method = "8AA523264671A583435FF7781AA08DE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void recycle() {
        clearForRecycle();
        {
            {
                next = sPool;
                sPool = this;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //clearForRecycle();
        //synchronized (sPoolSync) {
            //if (sPoolSize < MAX_POOL_SIZE) {
                //next = sPool;
                //sPool = this;
                //sPoolSize++;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.799 -0400", hash_original_method = "964842F017E82BDA48950DE2BC18315A", hash_generated_method = "5553C1B1854362B6C3327A935BDC9AA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void copyFrom(Message o) {
        dsTaint.addTaint(o.dsTaint);
        this.flags = o.flags & ~FLAGS_TO_CLEAR_ON_COPY_FROM;
        this.what = o.what;
        this.arg1 = o.arg1;
        this.arg2 = o.arg2;
        this.obj = o.obj;
        this.replyTo = o.replyTo;
        {
            this.data = (Bundle) o.data.clone();
        } //End block
        {
            this.data = null;
        } //End block
        // ---------- Original Method ----------
        //this.flags = o.flags & ~FLAGS_TO_CLEAR_ON_COPY_FROM;
        //this.what = o.what;
        //this.arg1 = o.arg1;
        //this.arg2 = o.arg2;
        //this.obj = o.obj;
        //this.replyTo = o.replyTo;
        //if (o.data != null) {
            //this.data = (Bundle) o.data.clone();
        //} else {
            //this.data = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.800 -0400", hash_original_method = "003296F505672677447BEB837B373395", hash_generated_method = "16B2A8BE7098FBADECA404064A645F5B")
    @DSModeled(DSC.SAFE)
    public long getWhen() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return when;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.800 -0400", hash_original_method = "4206C8A14E5D790EB7EB282A0235F495", hash_generated_method = "C28A865F50BF8437026C048333DEF90E")
    @DSModeled(DSC.SAFE)
    public void setTarget(Handler target) {
        dsTaint.addTaint(target.dsTaint);
        // ---------- Original Method ----------
        //this.target = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.800 -0400", hash_original_method = "71A342D68A16A50B25BC4BF2093BFF62", hash_generated_method = "05897A33A893EC2CE409361A5ADB7C2F")
    @DSModeled(DSC.SAFE)
    public Handler getTarget() {
        return (Handler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.802 -0400", hash_original_method = "BE120AA50B796443E57F262EC015813E", hash_generated_method = "AE198F021C706F8EFF6629F0E2717864")
    @DSModeled(DSC.SAFE)
    public Runnable getCallback() {
        return (Runnable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.804 -0400", hash_original_method = "1D2563192E30736CE7AB1C4867F66034", hash_generated_method = "8E5FB55531C1F769B6D28C4EDC042514")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle getData() {
        {
            data = new Bundle();
        } //End block
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (data == null) {
            //data = new Bundle();
        //}
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.804 -0400", hash_original_method = "82F96E5D1D9A678E87ADC3DA47E10262", hash_generated_method = "D81FBD7A2FD48B415EE37F0C20C520CF")
    @DSModeled(DSC.SAFE)
    public Bundle peekData() {
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.805 -0400", hash_original_method = "2A3AF1BEE5D39047FC40D7968EE3828B", hash_generated_method = "312D611C2C275E11281A6A3A272DA8BC")
    @DSModeled(DSC.SAFE)
    public void setData(Bundle data) {
        dsTaint.addTaint(data.dsTaint);
        // ---------- Original Method ----------
        //this.data = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.806 -0400", hash_original_method = "2D3F3759D60A7A1CBA79B8F487061097", hash_generated_method = "3B7F287400275060A2AE0E3943AFE99E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendToTarget() {
        target.sendMessage(this);
        // ---------- Original Method ----------
        //target.sendMessage(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.807 -0400", hash_original_method = "9CE194651C6176A08C0A91B012A85C32", hash_generated_method = "11A13B0F3660F78F0D526315F89EA24B")
    @DSModeled(DSC.SAFE)
     void clearForRecycle() {
        flags = 0;
        what = 0;
        arg1 = 0;
        arg2 = 0;
        obj = null;
        replyTo = null;
        when = 0;
        target = null;
        callback = null;
        data = null;
        // ---------- Original Method ----------
        //flags = 0;
        //what = 0;
        //arg1 = 0;
        //arg2 = 0;
        //obj = null;
        //replyTo = null;
        //when = 0;
        //target = null;
        //callback = null;
        //data = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.808 -0400", hash_original_method = "2F71B67A0204C39D3FE8504F70842AAF", hash_generated_method = "CB8F6765F4F8C8D755A4F3C3A9659FF4")
    @DSModeled(DSC.SAFE)
     boolean isInUse() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((flags & FLAG_IN_USE) == FLAG_IN_USE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.809 -0400", hash_original_method = "05D8812E72ABC796A0F0FB73D8BB23FD", hash_generated_method = "2406C8342B30A3F95EC80EECA1F8197F")
    @DSModeled(DSC.SAFE)
     void markInUse() {
        flags |= FLAG_IN_USE;
        // ---------- Original Method ----------
        //flags |= FLAG_IN_USE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.809 -0400", hash_original_method = "F5F2ADD77ACF5EFEB7E2DD825A11C06D", hash_generated_method = "F4DA65ECDEE1880AE635A6066FD056BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varC16E468DA290B807566E9DF10D91E52D_173310992 = (toString(SystemClock.uptimeMillis()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toString(SystemClock.uptimeMillis());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.809 -0400", hash_original_method = "94FE68A35FA2D79CB6E07D112DBAE9F2", hash_generated_method = "2B028718E2D41B27B7949D94F1091B27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String toString(long now) {
        dsTaint.addTaint(now);
        StringBuilder b;
        b = new StringBuilder();
        b.append("{ what=");
        b.append(what);
        b.append(" when=");
        TimeUtils.formatDuration(when-now, b);
        {
            b.append(" arg1=");
            b.append(arg1);
        } //End block
        {
            b.append(" arg2=");
            b.append(arg2);
        } //End block
        {
            b.append(" obj=");
            b.append(obj);
        } //End block
        b.append(" }");
        String varAFA387FFE5FA21CB2784F303FB8FD58D_1824480180 = (b.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder   b = new StringBuilder();
        //b.append("{ what=");
        //b.append(what);
        //b.append(" when=");
        //TimeUtils.formatDuration(when-now, b);
        //if (arg1 != 0) {
            //b.append(" arg1=");
            //b.append(arg1);
        //}
        //if (arg2 != 0) {
            //b.append(" arg2=");
            //b.append(arg2);
        //}
        //if (obj != null) {
            //b.append(" obj=");
            //b.append(obj);
        //}
        //b.append(" }");
        //return b.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.810 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.810 -0400", hash_original_method = "FA929F9306B89098CA5E11E46F85B0F7", hash_generated_method = "BF1BAF46F49748B0EEEC40EDB05098D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                "Can't marshal callbacks across processes.");
        } //End block
        dest.writeInt(what);
        dest.writeInt(arg1);
        dest.writeInt(arg2);
        {
            try 
            {
                Parcelable p;
                p = (Parcelable)obj;
                dest.writeInt(1);
                dest.writeParcelable(p, flags);
            } //End block
            catch (ClassCastException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Can't marshal non-Parcelable objects across processes.");
            } //End block
        } //End block
        {
            dest.writeInt(0);
        } //End block
        dest.writeLong(when);
        dest.writeBundle(data);
        Messenger.writeMessengerOrNullToParcel(replyTo, dest);
        // ---------- Original Method ----------
        //if (callback != null) {
            //throw new RuntimeException(
                //"Can't marshal callbacks across processes.");
        //}
        //dest.writeInt(what);
        //dest.writeInt(arg1);
        //dest.writeInt(arg2);
        //if (obj != null) {
            //try {
                //Parcelable p = (Parcelable)obj;
                //dest.writeInt(1);
                //dest.writeParcelable(p, flags);
            //} catch (ClassCastException e) {
                //throw new RuntimeException(
                    //"Can't marshal non-Parcelable objects across processes.");
            //}
        //} else {
            //dest.writeInt(0);
        //}
        //dest.writeLong(when);
        //dest.writeBundle(data);
        //Messenger.writeMessengerOrNullToParcel(replyTo, dest);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.811 -0400", hash_original_method = "95144FD69C7B3357510BFAF1773BB579", hash_generated_method = "B07BC4362466AF7A8E3D5991FE1CB0DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void readFromParcel(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        what = source.readInt();
        arg1 = source.readInt();
        arg2 = source.readInt();
        {
            boolean varFD16828A378FD83700BE97539951F787_24131566 = (source.readInt() != 0);
            {
                obj = source.readParcelable(getClass().getClassLoader());
            } //End block
        } //End collapsed parenthetic
        when = source.readLong();
        data = source.readBundle();
        replyTo = Messenger.readMessengerOrNullFromParcel(source);
        // ---------- Original Method ----------
        //what = source.readInt();
        //arg1 = source.readInt();
        //arg2 = source.readInt();
        //if (source.readInt() != 0) {
            //obj = source.readParcelable(getClass().getClassLoader());
        //}
        //when = source.readLong();
        //data = source.readBundle();
        //replyTo = Messenger.readMessengerOrNullFromParcel(source);
    }

    
    static final int FLAG_IN_USE = 1;
    static final int FLAGS_RESERVED = ~FLAG_IN_USE;
    static final int FLAGS_TO_CLEAR_ON_COPY_FROM = FLAGS_RESERVED | FLAG_IN_USE;
    private static final Object sPoolSync = new Object();
    private static Message sPool;
    private static int sPoolSize = 0;
    private static final int MAX_POOL_SIZE = 10;
    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.811 -0400", hash_original_method = "C469647B7E7B16486A85AB4B8FE1AC44", hash_generated_method = "4C5C415952525003E643970BB94FF8A4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Message createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            Message msg;
            msg = Message.obtain();
            msg.readFromParcel(source);
            return (Message)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Message msg = Message.obtain();
            //msg.readFromParcel(source);
            //return msg;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.817 -0400", hash_original_method = "84E6F9E4CA0DE670DE1B09305CE190D8", hash_generated_method = "E99564DE7752F48D7284E6EAD22CC877")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Message[] newArray(int size) {
            dsTaint.addTaint(size);
            Message[] var0963AE9FC60693F4BCEFC5332FFB14D8_171795331 = (new Message[size]);
            return (Message[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Message[size];
        }

        
}; //Transformed anonymous class
}

