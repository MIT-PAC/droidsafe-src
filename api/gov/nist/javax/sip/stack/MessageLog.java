package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.LogRecord;

class MessageLog implements LogRecord {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.736 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "B2821CE5540C52B19670BB2C4012F012")

    private String message;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.736 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "2D2DC69F3BF28B00B15BD37DFC141996")

    private String source;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.736 -0400", hash_original_field = "6990A54322D9232390A784C5C9247DD6", hash_generated_field = "8BC6EA56B5330B53673CB5DD16E8AC4E")

    private String destination;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.736 -0400", hash_original_field = "87A3CB5C3554B2D9D8A1A773AD0936BE", hash_generated_field = "8839F6F627CF1085C871938312AAE918")

    private long timeStamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.737 -0400", hash_original_field = "19473E77C4CC50B29F8FF43127858000", hash_generated_field = "BF031D181B175207CB4FAF9A21666838")

    private boolean isSender;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.737 -0400", hash_original_field = "71F67F8E91222F095406DD3AD8FD65B2", hash_generated_field = "2D552DD3A1F19C65B36565EE0106C9DB")

    private String firstLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.737 -0400", hash_original_field = "97BEAA21D4819A1131833B897504CE31", hash_generated_field = "6E3A8FD900779FBB9A4728967FE109EF")

    private String tid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.737 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "14745A902962E272FDA1DE862859D03C")

    private String callId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.737 -0400", hash_original_field = "61668CF17C5ADD0EF8C0484BCFFC50C7", hash_generated_field = "D3FCB03CE5B4F679C534C994BCE675D9")

    private long timeStampHeaderValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.742 -0400", hash_original_method = "4DF5C3B1D01E7222DCCDFE20C1B5824A", hash_generated_method = "C7C392B605B2FF034E06E1D7E6233505")
    public  MessageLog(
        String message,
        String source,
        String destination,
        String timeStamp,
        boolean isSender,
        String firstLine,
        String tid,
        String callId,
        long timeStampHeaderValue) {
    if(message == null || message.equals(""))        
        {
        IllegalArgumentException varE0F057551FD8F72BFAA562C7D02C0762_349993674 = new IllegalArgumentException("null msg");
        varE0F057551FD8F72BFAA562C7D02C0762_349993674.addTaint(taint);
        throw varE0F057551FD8F72BFAA562C7D02C0762_349993674;
        }
        this.message = message;
        this.source = source;
        this.destination = destination;
        try 
        {
            long ts = Long.parseLong(timeStamp);
    if(ts < 0)            
            {
            IllegalArgumentException var72A141E2207E3451703674B97CA15882_261621722 = new IllegalArgumentException("Bad time stamp ");
            var72A141E2207E3451703674B97CA15882_261621722.addTaint(taint);
            throw var72A141E2207E3451703674B97CA15882_261621722;
            }
            this.timeStamp = ts;
        } 
        catch (NumberFormatException ex)
        {
            IllegalArgumentException var3C433D34CA8D49524ED15D3900C1F930_2100264990 = new IllegalArgumentException(
                "Bad number format " + timeStamp);
            var3C433D34CA8D49524ED15D3900C1F930_2100264990.addTaint(taint);
            throw var3C433D34CA8D49524ED15D3900C1F930_2100264990;
        } 
        this.isSender = isSender;
        this.firstLine = firstLine;
        this.tid = tid;
        this.callId = callId;
        this.timeStampHeaderValue = timeStampHeaderValue;
        
        
            
        
        
        
        
            
            
                
            
        
            
                
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.746 -0400", hash_original_method = "C29CF89B26E4E43BB7B19BB7E4FDCA0D", hash_generated_method = "133E35FFA28E4B229CCA5CAB4DCC97FD")
    public  MessageLog(
        String message,
        String source,
        String destination,
        long timeStamp,
        boolean isSender,
        String firstLine,
        String tid,
        String callId,
        long timestampVal) {
    if(message == null || message.equals(""))        
        {
        IllegalArgumentException varE0F057551FD8F72BFAA562C7D02C0762_1762900773 = new IllegalArgumentException("null msg");
        varE0F057551FD8F72BFAA562C7D02C0762_1762900773.addTaint(taint);
        throw varE0F057551FD8F72BFAA562C7D02C0762_1762900773;
        }
        this.message = message;
        this.source = source;
        this.destination = destination;
    if(timeStamp < 0)        
        {
        IllegalArgumentException varD534D53790C388210E2581BC4453998F_1780098533 = new IllegalArgumentException("negative ts");
        varD534D53790C388210E2581BC4453998F_1780098533.addTaint(taint);
        throw varD534D53790C388210E2581BC4453998F_1780098533;
        }
        this.timeStamp = timeStamp;
        this.isSender = isSender;
        this.firstLine = firstLine;
        this.tid = tid;
        this.callId = callId;
        this.timeStampHeaderValue = timestampVal;
        
        
            
        
        
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.747 -0400", hash_original_method = "818407DE55CFD10CF1C5E889367D1C2C", hash_generated_method = "C97DDC1E16DD1F1B3599960216C51C4D")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!(other instanceof MessageLog))        
        {
            boolean var68934A3E9455FA72420237EB05902327_829693542 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_56080314 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_56080314;
        } 
        else
        {
            MessageLog otherLog = (MessageLog) other;
            boolean var4E9CCE1888D7FB527A13BE31585F07CE_609193174 = (otherLog.message.equals(message)
                && otherLog.timeStamp == timeStamp);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_264913925 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_264913925;
        } 
        
        
            
        
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.749 -0400", hash_original_method = "41C5D33A303365643BC91460F622FA81", hash_generated_method = "B4C3E1D399DAAF67E55F4853A75C2261")
    public String toString() {
        String log;
        log =
                "<message\nfrom=\""
                    + source
                    + "\" \nto=\""
                    + destination
                    + "\" \ntime=\""
                    + timeStamp
                    + "\"" +
                    (this.timeStampHeaderValue != 0 ? "\ntimeStamp = \"" + timeStampHeaderValue + "\"": "")
                    +"\nisSender=\""
                    + isSender
                    + "\" \ntransactionId=\""
                    + tid
                    + "\" \ncallId=\""
                    + callId
                    + "\" \nfirstLine=\""
                    + firstLine.trim() + "\"" +
                    " \n>\n";
        log += "<![CDATA[";
        log += message;
        log += "]]>\n";
        log += "</message>\n";
String varB735BC6DB913B856C485F8C0403CECB1_1298159751 =         log;
        varB735BC6DB913B856C485F8C0403CECB1_1298159751.addTaint(taint);
        return varB735BC6DB913B856C485F8C0403CECB1_1298159751;
        
        
    }

    
}

