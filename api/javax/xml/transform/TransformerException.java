package javax.xml.transform;

// Droidsafe Imports
import droidsafe.annotations.*;





public class TransformerException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.082 -0400", hash_original_field = "AB1E07F86CA37C6521CC1969EE2AC6C9", hash_generated_field = "242C14456A521485BE94EFFE33D8EF15")

    SourceLocator locator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.082 -0400", hash_original_field = "666707D818022CC67C8A24390966B951", hash_generated_field = "FB75E61C44B34E5DCDC79855DF4646BE")

    Throwable containedException;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.082 -0400", hash_original_method = "ABE089B555C0BBE77A7ADBD2839474AC", hash_generated_method = "2B350626ACE88F11560D0D8824671729")
    public  TransformerException(String message) {
        super(message);
        addTaint(message.getTaint());
        this.containedException = null;
        this.locator            = null;
        // ---------- Original Method ----------
        //this.containedException = null;
        //this.locator            = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.083 -0400", hash_original_method = "BCE7B8322CC2320F24F40E1C57B1D6A6", hash_generated_method = "6B6F250FA67E31550203926FF836ECDC")
    public  TransformerException(Throwable e) {
        super(e.toString());
        this.containedException = e;
        this.locator            = null;
        // ---------- Original Method ----------
        //this.containedException = e;
        //this.locator            = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.084 -0400", hash_original_method = "D45FC511BA6A923B19FFB66FC049AAEB", hash_generated_method = "43BA7BE70D6F7434E28246E7A0ED9534")
    public  TransformerException(String message, Throwable e) {
        super(((message == null) || (message.length() == 0))
              ? e.toString()
              : message);
        addTaint(message.getTaint());
        this.containedException = e;
        this.locator            = null;
        // ---------- Original Method ----------
        //this.containedException = e;
        //this.locator            = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.085 -0400", hash_original_method = "DD07B7FCC3EF7EDD2CCAD748CE266263", hash_generated_method = "7297AB3FA9F370CE449C62251261B4FE")
    public  TransformerException(String message, SourceLocator locator) {
        super(message);
        addTaint(message.getTaint());
        this.containedException = null;
        this.locator            = locator;
        // ---------- Original Method ----------
        //this.containedException = null;
        //this.locator            = locator;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.086 -0400", hash_original_method = "48CCF75E307E890A227C0CAEA85C6D48", hash_generated_method = "D1660D35E82666749AAC5F28B3458DC8")
    public  TransformerException(String message, SourceLocator locator,
                                Throwable e) {
        super(message);
        addTaint(message.getTaint());
        this.containedException = e;
        this.locator            = locator;
        // ---------- Original Method ----------
        //this.containedException = e;
        //this.locator            = locator;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.086 -0400", hash_original_method = "78CCEDF93B9D36FA2F4D6EE8483F521D", hash_generated_method = "B18312B3193D91A1A34FA047E35C42A0")
    public SourceLocator getLocator() {
SourceLocator var33D67455F55B75787251435F488B9C18_977784636 =         locator;
        var33D67455F55B75787251435F488B9C18_977784636.addTaint(taint);
        return var33D67455F55B75787251435F488B9C18_977784636;
        // ---------- Original Method ----------
        //return locator;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.086 -0400", hash_original_method = "2730D26302DDFE02DFC9B94C57BA2229", hash_generated_method = "3A60D6D9C48F9C8CC784DDE0EBAB1BA2")
    public void setLocator(SourceLocator location) {
        locator = location;
        // ---------- Original Method ----------
        //locator = location;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.087 -0400", hash_original_method = "4E3501B9804FC98D0826FF297E292112", hash_generated_method = "AE84F0E45258A862467E81A0FF11BE50")
    public Throwable getException() {
Throwable varF2A110AF41FD2A1760878EFAF72F9E9A_1868111703 =         containedException;
        varF2A110AF41FD2A1760878EFAF72F9E9A_1868111703.addTaint(taint);
        return varF2A110AF41FD2A1760878EFAF72F9E9A_1868111703;
        // ---------- Original Method ----------
        //return containedException;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.087 -0400", hash_original_method = "CFB99AF15EF81FE883309E381BCDFD32", hash_generated_method = "CB8843F25283B9DEE95131DB7578CFBA")
    public Throwable getCause() {
Throwable var7AD5C7EA160E04D21F46409BCB89DECC_652590788 =         ((containedException == this)
                ? null
                : containedException);
        var7AD5C7EA160E04D21F46409BCB89DECC_652590788.addTaint(taint);
        return var7AD5C7EA160E04D21F46409BCB89DECC_652590788;
        // ---------- Original Method ----------
        //return ((containedException == this)
                //? null
                //: containedException);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.087 -0400", hash_original_method = "480EED18E1765067FE991AF0B4A8D2D9", hash_generated_method = "C4195EB43FE76A81EF68F2AA4A72C04F")
    public synchronized Throwable initCause(Throwable cause) {
        if(this.containedException != null)        
        {
            IllegalStateException varE9003A1100706138F1345FD3B3B905A3_1230251318 = new IllegalStateException("Can't overwrite cause");
            varE9003A1100706138F1345FD3B3B905A3_1230251318.addTaint(taint);
            throw varE9003A1100706138F1345FD3B3B905A3_1230251318;
        } //End block
        if(cause == this)        
        {
            IllegalArgumentException var3A4BD4026EBDC61CB9C770B3ED542F24_1627370964 = new IllegalArgumentException(
                "Self-causation not permitted");
            var3A4BD4026EBDC61CB9C770B3ED542F24_1627370964.addTaint(taint);
            throw var3A4BD4026EBDC61CB9C770B3ED542F24_1627370964;
        } //End block
        this.containedException = cause;
Throwable var72A74007B2BE62B849F475C7BDA4658B_627807708 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_627807708.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_627807708;
        // ---------- Original Method ----------
        //if (this.containedException != null) {
            //throw new IllegalStateException("Can't overwrite cause");
        //}
        //if (cause == this) {
            //throw new IllegalArgumentException(
                //"Self-causation not permitted");
        //}
        //this.containedException = cause;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.088 -0400", hash_original_method = "5F0314D1FF4AABD6580ED0D63B1DE248", hash_generated_method = "733E5845110A4B34D0B3AADC19245B9B")
    public String getMessageAndLocation() {
        StringBuilder sbuffer = new StringBuilder();
        String message = super.getMessage();
        if(null != message)        
        {
            sbuffer.append(message);
        } //End block
        if(null != locator)        
        {
            String systemID = locator.getSystemId();
            int line = locator.getLineNumber();
            int column = locator.getColumnNumber();
            if(null != systemID)            
            {
                sbuffer.append("; SystemID: ");
                sbuffer.append(systemID);
            } //End block
            if(0 != line)            
            {
                sbuffer.append("; Line#: ");
                sbuffer.append(line);
            } //End block
            if(0 != column)            
            {
                sbuffer.append("; Column#: ");
                sbuffer.append(column);
            } //End block
        } //End block
String varEFC2B84A819C9F41414BE54046FF2802_702764779 =         sbuffer.toString();
        varEFC2B84A819C9F41414BE54046FF2802_702764779.addTaint(taint);
        return varEFC2B84A819C9F41414BE54046FF2802_702764779;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.089 -0400", hash_original_method = "066E0A6F600039820661DC1AB443CC5D", hash_generated_method = "1790BD6611973ABBD0EBEBC6204EF9E6")
    public String getLocationAsString() {
        if(null != locator)        
        {
            StringBuilder sbuffer = new StringBuilder();
            String systemID = locator.getSystemId();
            int line = locator.getLineNumber();
            int column = locator.getColumnNumber();
            if(null != systemID)            
            {
                sbuffer.append("; SystemID: ");
                sbuffer.append(systemID);
            } //End block
            if(0 != line)            
            {
                sbuffer.append("; Line#: ");
                sbuffer.append(line);
            } //End block
            if(0 != column)            
            {
                sbuffer.append("; Column#: ");
                sbuffer.append(column);
            } //End block
String varEFC2B84A819C9F41414BE54046FF2802_2106477537 =             sbuffer.toString();
            varEFC2B84A819C9F41414BE54046FF2802_2106477537.addTaint(taint);
            return varEFC2B84A819C9F41414BE54046FF2802_2106477537;
        } //End block
        else
        {
String var540C13E9E156B687226421B24F2DF178_1007161776 =             null;
            var540C13E9E156B687226421B24F2DF178_1007161776.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1007161776;
        } //End block
        // ---------- Original Method ----------
        //if (null != locator) {
            //StringBuilder sbuffer  = new StringBuilder();
            //String       systemID = locator.getSystemId();
            //int          line     = locator.getLineNumber();
            //int          column   = locator.getColumnNumber();
            //if (null != systemID) {
                //sbuffer.append("; SystemID: ");
                //sbuffer.append(systemID);
            //}
            //if (0 != line) {
                //sbuffer.append("; Line#: ");
                //sbuffer.append(line);
            //}
            //if (0 != column) {
                //sbuffer.append("; Column#: ");
                //sbuffer.append(column);
            //}
            //return sbuffer.toString();
        //} else {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.089 -0400", hash_original_method = "BFEE5D773C8C1A637BA8549A5548CE5E", hash_generated_method = "5DE43A2AD9D57F579CB99E2DD2DEBB6F")
    public void printStackTrace() {
        printStackTrace(new java.io.PrintWriter(System.err, true));
        // ---------- Original Method ----------
        //printStackTrace(new java.io.PrintWriter(System.err, true));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.090 -0400", hash_original_method = "396FE4FDBD72A1A44CDA1D64A960A2B6", hash_generated_method = "FC5B9AD021B95237BD477BDDB89C5770")
    public void printStackTrace(java.io.PrintStream s) {
        addTaint(s.getTaint());
        printStackTrace(new java.io.PrintWriter(s));
        // ---------- Original Method ----------
        //printStackTrace(new java.io.PrintWriter(s));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.091 -0400", hash_original_method = "A67ED2D6F45381C31C2891A6F92AFBC4", hash_generated_method = "0830A5AB41CC9A63A06EA2C84FB9B3F4")
    public void printStackTrace(java.io.PrintWriter s) {
        addTaint(s.getTaint());
        if(s == null)        
        {
            s = new java.io.PrintWriter(System.err, true);
        } //End block
        try 
        {
            String locInfo = getLocationAsString();
            if(null != locInfo)            
            {
                s.println(locInfo);
            } //End block
            super.printStackTrace(s);
        } //End block
        catch (Throwable e)
        {
        } //End block
        // ---------- Original Method ----------
        //if (s == null) {
            //s = new java.io.PrintWriter(System.err, true);
        //}
        //try {
            //String locInfo = getLocationAsString();
            //if (null != locInfo) {
                //s.println(locInfo);
            //}
            //super.printStackTrace(s);
        //} catch (Throwable e) {}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.091 -0400", hash_original_field = "CF11F5DB9FDEA42A11ADE0EBA3C62E0F", hash_generated_field = "FAB3AA9E21148B68815314C0C638BF27")

    private static final long serialVersionUID = 975798773772956428L;
}

