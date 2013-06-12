package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    static final int FLAG_IN_USE = 1;
    static final int FLAGS_RESERVED = ~FLAG_IN_USE;
    static final int FLAGS_TO_CLEAR_ON_COPY_FROM = FLAGS_RESERVED | FLAG_IN_USE;
    int flags;
    long when;
    Bundle data;
    Handler target;
    Runnable callback;
    Message next;
    private static final Object sPoolSync = new Object();
    private static Message sPool;
    private static int sPoolSize = 0;
    private static final int MAX_POOL_SIZE = 10;
    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.671 -0400", hash_original_method = "C469647B7E7B16486A85AB4B8FE1AC44", hash_generated_method = "BD04575E804C372E87D2F1177050E010")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.671 -0400", hash_original_method = "84E6F9E4CA0DE670DE1B09305CE190D8", hash_generated_method = "865499F20FD894069ED915EE981F3554")
        @DSModeled(DSC.SAFE)
        public Message[] newArray(int size) {
            dsTaint.addTaint(size);
            return (Message[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Message[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.672 -0400", hash_original_method = "07161C5E5BFC528DA3FC2F6017B16172", hash_generated_method = "B808CBA42F4CD07A6C71C8F48C6CC3A9")
    @DSModeled(DSC.SAFE)
    public Message() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.672 -0400", hash_original_method = "94A2278DA1626A7BD539E3DA32454F0B", hash_generated_method = "94D66F64A460AFC9E1A54B5C3B495277")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.672 -0400", hash_original_method = "3DDDC922E39D84127A2DC1786D3B33D2", hash_generated_method = "FB481C3AFDFA8C19EBE869A80159C902")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.672 -0400", hash_original_method = "F1E1A90C9FE0056DE27D4BDD6B0CFE0C", hash_generated_method = "D9647A6DA04D00CC1B48559ADDC91104")
    public static Message obtain(Handler h) {
        Message m = obtain();
        m.target = h;
        return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.672 -0400", hash_original_method = "073C1A8A82742334214D17BA541D97D4", hash_generated_method = "4A3DA3C99DDA22F9E99EA5853834959A")
    public static Message obtain(Handler h, Runnable callback) {
        Message m = obtain();
        m.target = h;
        m.callback = callback;
        return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.672 -0400", hash_original_method = "E26B7D4E6B35F5234F7DF4974522919A", hash_generated_method = "735878BCF4D4D13F8EC3A8CC8DF1B845")
    public static Message obtain(Handler h, int what) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.672 -0400", hash_original_method = "DD09B29D12E38FF7883BAB5D6B58243F", hash_generated_method = "48467203DADCBADA8EFADA7691CEBF70")
    public static Message obtain(Handler h, int what, Object obj) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.obj = obj;
        return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.672 -0400", hash_original_method = "4DCC15A1D3B41D0AD35502FBE5B811FF", hash_generated_method = "F3CC485A508121FCA56CF2574BB30B5D")
    public static Message obtain(Handler h, int what, int arg1, int arg2) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.arg1 = arg1;
        m.arg2 = arg2;
        return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.672 -0400", hash_original_method = "04CC709854703F83EA59D0BD74C33885", hash_generated_method = "900BB399E0A016B25649CF4515DA3106")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.673 -0400", hash_original_method = "0036C7E97F14F697C30BFE1437947C9D", hash_generated_method = "F6CC47C0270BC04341C7316C31ED02FD")
    @DSModeled(DSC.SAFE)
    public void recycle() {
        clearForRecycle();
        {
            {
                next = sPool;
                sPool = this;
                sPoolSize++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.673 -0400", hash_original_method = "964842F017E82BDA48950DE2BC18315A", hash_generated_method = "6093D7B3005EA521C7AFDF255A5412D2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.673 -0400", hash_original_method = "003296F505672677447BEB837B373395", hash_generated_method = "5639B79A740633B5CB91914995A57937")
    @DSModeled(DSC.SAFE)
    public long getWhen() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return when;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.673 -0400", hash_original_method = "4206C8A14E5D790EB7EB282A0235F495", hash_generated_method = "8960BC978E25FCB4643B636E5EEA1C6D")
    @DSModeled(DSC.SAFE)
    public void setTarget(Handler target) {
        dsTaint.addTaint(target.dsTaint);
        // ---------- Original Method ----------
        //this.target = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.673 -0400", hash_original_method = "71A342D68A16A50B25BC4BF2093BFF62", hash_generated_method = "D16C019996E00BC72A3797FC7FA74BA9")
    @DSModeled(DSC.SAFE)
    public Handler getTarget() {
        return (Handler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.673 -0400", hash_original_method = "BE120AA50B796443E57F262EC015813E", hash_generated_method = "1029C3B078A478854C78D79BCA02B086")
    @DSModeled(DSC.SAFE)
    public Runnable getCallback() {
        return (Runnable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.673 -0400", hash_original_method = "1D2563192E30736CE7AB1C4867F66034", hash_generated_method = "E4531A4408F577E07244AB3A7ED0C01F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.673 -0400", hash_original_method = "82F96E5D1D9A678E87ADC3DA47E10262", hash_generated_method = "371CF8B9F90E34C0280AE7B04E9514A4")
    @DSModeled(DSC.SAFE)
    public Bundle peekData() {
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.673 -0400", hash_original_method = "2A3AF1BEE5D39047FC40D7968EE3828B", hash_generated_method = "74C959061D2F8F91FDC725EDDB6AA127")
    @DSModeled(DSC.SAFE)
    public void setData(Bundle data) {
        dsTaint.addTaint(data.dsTaint);
        // ---------- Original Method ----------
        //this.data = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.674 -0400", hash_original_method = "2D3F3759D60A7A1CBA79B8F487061097", hash_generated_method = "BA35E3C0C3DC1744C71FD12EE86077E7")
    @DSModeled(DSC.SAFE)
    public void sendToTarget() {
        target.sendMessage(this);
        // ---------- Original Method ----------
        //target.sendMessage(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.674 -0400", hash_original_method = "9CE194651C6176A08C0A91B012A85C32", hash_generated_method = "395E5B8BCA13177322BD765DD6911B53")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.674 -0400", hash_original_method = "2F71B67A0204C39D3FE8504F70842AAF", hash_generated_method = "D18AC6EEAE99C4C1D6120D5B19BD8B44")
    @DSModeled(DSC.SAFE)
     boolean isInUse() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((flags & FLAG_IN_USE) == FLAG_IN_USE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.674 -0400", hash_original_method = "05D8812E72ABC796A0F0FB73D8BB23FD", hash_generated_method = "8667B0D0A374B39EC685B3480F3301B1")
    @DSModeled(DSC.SAFE)
     void markInUse() {
        flags |= FLAG_IN_USE;
        // ---------- Original Method ----------
        //flags |= FLAG_IN_USE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.674 -0400", hash_original_method = "F5F2ADD77ACF5EFEB7E2DD825A11C06D", hash_generated_method = "AE2C7BACE08CE9A5BFA6185976B823FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varC16E468DA290B807566E9DF10D91E52D_1323884893 = (toString(SystemClock.uptimeMillis()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toString(SystemClock.uptimeMillis());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.674 -0400", hash_original_method = "94FE68A35FA2D79CB6E07D112DBAE9F2", hash_generated_method = "6496FF17B423E8D5BA7DAD56F8CD42AC")
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
        String varAFA387FFE5FA21CB2784F303FB8FD58D_1833043989 = (b.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.674 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.675 -0400", hash_original_method = "FA929F9306B89098CA5E11E46F85B0F7", hash_generated_method = "296036B5AE2978EF0B5612A183A20F06")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        {
            throw new RuntimeException(
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
                throw new RuntimeException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.675 -0400", hash_original_method = "95144FD69C7B3357510BFAF1773BB579", hash_generated_method = "B8C86E7BE742DDB9C7981D69C89FCF08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void readFromParcel(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        what = source.readInt();
        arg1 = source.readInt();
        arg2 = source.readInt();
        {
            boolean varFD16828A378FD83700BE97539951F787_127798623 = (source.readInt() != 0);
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

    
}


