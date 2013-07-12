package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class Registrant {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.427 -0400", hash_original_field = "619B2A081B6E7006662C823A3E45AA2E", hash_generated_field = "0D5560AD898CE7ED29D9B0190B0760A0")

    WeakReference refH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.428 -0400", hash_original_field = "4A2028ECEAC5E1F4D252EA13C71ECEC6", hash_generated_field = "6100FAC75E91CAC232945E82029A9682")

    int what;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.428 -0400", hash_original_field = "25C84ECB718C6159E9324F086F630B67", hash_generated_field = "F7E748C8E322C0020C08D9F5DB2D53B3")

    Object userObj;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.431 -0400", hash_original_method = "5F497FB9D04E2FF153E80911709BB474", hash_generated_method = "444AF8391A2EAFF305EC7E9002DF8C54")
    public  Registrant(Handler h, int what, Object obj) {
        refH = new WeakReference(h);
        this.what = what;
        userObj = obj;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.432 -0400", hash_original_method = "AD65744D6793AC8F89861EE1586F2E60", hash_generated_method = "0652DDD73EE83AEB0035EB645B57E65A")
    public void clear() {
        refH = null;
        userObj = null;
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.432 -0400", hash_original_method = "4409C699F4CAB16C2D504E283EFD3CDE", hash_generated_method = "28D035BF35B005A395534D365D96D57D")
    public void notifyRegistrant() {
        internalNotifyRegistrant (null, null);
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.432 -0400", hash_original_method = "64830107363F59A49C8D9CD8F53D1153", hash_generated_method = "EE1CD4AA79A03607A94F9EE115A6B472")
    public void notifyResult(Object result) {
        addTaint(result.getTaint());
        internalNotifyRegistrant (result, null);
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.433 -0400", hash_original_method = "3375894D9F21481D987FA847F34F65EF", hash_generated_method = "690CF7D49B68DF3F37F2A474174C0397")
    public void notifyException(Throwable exception) {
        addTaint(exception.getTaint());
        internalNotifyRegistrant (null, exception);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.433 -0400", hash_original_method = "5E7A4559085AA819B0F18D8B5740229E", hash_generated_method = "642E20AA10ACDEF838A2737F1B130CF5")
    public void notifyRegistrant(AsyncResult ar) {
        addTaint(ar.getTaint());
        internalNotifyRegistrant (ar.result, ar.exception);
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.434 -0400", hash_original_method = "8E93682DAE1125F8892DB75F842EE54A", hash_generated_method = "6BE42F4E4466874DF431DFBC36BB6F73")
     void internalNotifyRegistrant(Object result, Throwable exception) {
        addTaint(exception.getTaint());
        addTaint(result.getTaint());
        Handler h = getHandler();
    if(h == null)        
        {
            clear();
        } 
        else
        {
            Message msg = Message.obtain();
            msg.what = what;
            msg.obj = new AsyncResult(userObj, result, exception);
            h.sendMessage(msg);
        } 
        
        
        
            
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.435 -0400", hash_original_method = "D348E31FC7F90016E841E35B51E50760", hash_generated_method = "DE8AA9E955FB566E4C6DEE68F8EAF77B")
    public Message messageForRegistrant() {
        Handler h = getHandler();
    if(h == null)        
        {
            clear();
Message var540C13E9E156B687226421B24F2DF178_1780511197 =             null;
            var540C13E9E156B687226421B24F2DF178_1780511197.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1780511197;
        } 
        else
        {
            Message msg = h.obtainMessage();
            msg.what = what;
            msg.obj = userObj;
Message varEDC5B72465A7F0BEE288689BCB1DD141_67798529 =             msg;
            varEDC5B72465A7F0BEE288689BCB1DD141_67798529.addTaint(taint);
            return varEDC5B72465A7F0BEE288689BCB1DD141_67798529;
        } 
        
        
        
            
            
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.436 -0400", hash_original_method = "7FEDB520AB82A5F00001E1B2C02807FF", hash_generated_method = "8B43ADEDD03CF5703E1E9DA730F93E07")
    public Handler getHandler() {
    if(refH == null)        
        {
Handler var540C13E9E156B687226421B24F2DF178_1857672542 =         null;
        var540C13E9E156B687226421B24F2DF178_1857672542.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1857672542;
        }
Handler varEEB4D628C97FC203FD0112B40DDC1199_1650529545 =         (Handler) refH.get();
        varEEB4D628C97FC203FD0112B40DDC1199_1650529545.addTaint(taint);
        return varEEB4D628C97FC203FD0112B40DDC1199_1650529545;
        
        
            
        
    }

    
}

