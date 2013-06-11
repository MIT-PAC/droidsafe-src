package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class Registrant {
    WeakReference   refH;
    int             what;
    Object          userObj;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.859 -0400", hash_original_method = "5F497FB9D04E2FF153E80911709BB474", hash_generated_method = "30DD9AE2B7C78CDBC5C01A42EFC4F53C")
    @DSModeled(DSC.SAFE)
    public Registrant(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        refH = new WeakReference(h);
        // ---------- Original Method ----------
        //refH = new WeakReference(h);
        //this.what = what;
        //userObj = obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.859 -0400", hash_original_method = "AD65744D6793AC8F89861EE1586F2E60", hash_generated_method = "804F5D0950F6E8143A4322CD4AD314FD")
    @DSModeled(DSC.SAFE)
    public void clear() {
        refH = null;
        userObj = null;
        // ---------- Original Method ----------
        //refH = null;
        //userObj = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.859 -0400", hash_original_method = "4409C699F4CAB16C2D504E283EFD3CDE", hash_generated_method = "07820146FF2582ECD199330C6E43605F")
    @DSModeled(DSC.SAFE)
    public void notifyRegistrant() {
        internalNotifyRegistrant (null, null);
        // ---------- Original Method ----------
        //internalNotifyRegistrant (null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.859 -0400", hash_original_method = "64830107363F59A49C8D9CD8F53D1153", hash_generated_method = "B961ADF553EE8123A07536AFEB088A10")
    @DSModeled(DSC.SAFE)
    public void notifyResult(Object result) {
        dsTaint.addTaint(result.dsTaint);
        internalNotifyRegistrant (result, null);
        // ---------- Original Method ----------
        //internalNotifyRegistrant (result, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.859 -0400", hash_original_method = "3375894D9F21481D987FA847F34F65EF", hash_generated_method = "645E49876A3AA2B97FEAF36E845A25A1")
    @DSModeled(DSC.SAFE)
    public void notifyException(Throwable exception) {
        dsTaint.addTaint(exception.dsTaint);
        internalNotifyRegistrant (null, exception);
        // ---------- Original Method ----------
        //internalNotifyRegistrant (null, exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.859 -0400", hash_original_method = "5E7A4559085AA819B0F18D8B5740229E", hash_generated_method = "3E608E87A18B532C858200C7273E367D")
    @DSModeled(DSC.SAFE)
    public void notifyRegistrant(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        internalNotifyRegistrant (ar.result, ar.exception);
        // ---------- Original Method ----------
        //internalNotifyRegistrant (ar.result, ar.exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.859 -0400", hash_original_method = "8E93682DAE1125F8892DB75F842EE54A", hash_generated_method = "0EB00B6A8BF8C024178C1DE3849C49EF")
    @DSModeled(DSC.SAFE)
     void internalNotifyRegistrant(Object result, Throwable exception) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(exception.dsTaint);
        Handler h;
        h = getHandler();
        {
            clear();
        } //End block
        {
            Message msg;
            msg = Message.obtain();
            msg.what = what;
            msg.obj = new AsyncResult(userObj, result, exception);
            h.sendMessage(msg);
        } //End block
        // ---------- Original Method ----------
        //Handler h = getHandler();
        //if (h == null) {
            //clear();
        //} else {
            //Message msg = Message.obtain();
            //msg.what = what;
            //msg.obj = new AsyncResult(userObj, result, exception);
            //h.sendMessage(msg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.859 -0400", hash_original_method = "D348E31FC7F90016E841E35B51E50760", hash_generated_method = "05ED7D45104A30EDED62639745FF1BD5")
    @DSModeled(DSC.SAFE)
    public Message messageForRegistrant() {
        Handler h;
        h = getHandler();
        {
            clear();
        } //End block
        {
            Message msg;
            msg = h.obtainMessage();
            msg.what = what;
            msg.obj = userObj;
        } //End block
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Handler h = getHandler();
        //if (h == null) {
            //clear();
            //return null;
        //} else {
            //Message msg = h.obtainMessage();
            //msg.what = what;
            //msg.obj = userObj;
            //return msg;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.860 -0400", hash_original_method = "7FEDB520AB82A5F00001E1B2C02807FF", hash_generated_method = "549FC8797E2CFA03776AD2F4A64BFAB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Handler getHandler() {
        Handler var771D64C76F812E732ABA60743AEA56AE_1872254883 = ((Handler) refH.get());
        return (Handler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (refH == null)
            //return null;
        //return (Handler) refH.get();
    }

    
}


