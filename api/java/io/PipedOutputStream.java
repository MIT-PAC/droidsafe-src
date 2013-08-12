package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;



public class PipedOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.172 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "FFCF22CBA6829D46F4F004A31261042A")

    private PipedInputStream target;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.172 -0400", hash_original_method = "E4156F592468799387F97AC767717CEE", hash_generated_method = "BD1FEBE339408C69819D3D0783F7B91C")
    public  PipedOutputStream() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.172 -0400", hash_original_method = "EDB6E26C0B783EE736D00B46ADBCAF6A", hash_generated_method = "77C06272AFA286BF65D275B452485EEA")
    public  PipedOutputStream(PipedInputStream target) throws IOException {
        addTaint(target.getTaint());
        connect(target);
        // ---------- Original Method ----------
        //connect(target);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.173 -0400", hash_original_method = "3142FC22E0231F063D6673F4E3EF281C", hash_generated_method = "71994E877727B45D90756043166DAD68")
    @Override
    public void close() throws IOException {
        PipedInputStream stream = target;
        if(stream != null)        
        {
            stream.done();
            target = null;
        } //End block
        // ---------- Original Method ----------
        //PipedInputStream stream = target;
        //if (stream != null) {
            //stream.done();
            //target = null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.174 -0400", hash_original_method = "962D17DAB77DCC2B5B99A6C84B8F4998", hash_generated_method = "1B4ED409737C7789ADA9052973C87E36")
    public void connect(PipedInputStream stream) throws IOException {
        if(stream == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_253349790 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_253349790.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_253349790;
        } //End block
        synchronized
(stream)        {
            if(this.target != null)            
            {
                IOException varADD8C8BE54C6A77AF4145D2157468E07_461087235 = new IOException("Already connected");
                varADD8C8BE54C6A77AF4145D2157468E07_461087235.addTaint(taint);
                throw varADD8C8BE54C6A77AF4145D2157468E07_461087235;
            } //End block
            if(stream.isConnected)            
            {
                IOException var59E3110525112AD12A0795267BCC8DC7_852915339 = new IOException("Pipe already connected");
                var59E3110525112AD12A0795267BCC8DC7_852915339.addTaint(taint);
                throw var59E3110525112AD12A0795267BCC8DC7_852915339;
            } //End block
            stream.establishConnection();
            this.target = stream;
        } //End block
        // ---------- Original Method ----------
        //if (stream == null) {
            //throw new NullPointerException();
        //}
        //synchronized (stream) {
            //if (this.target != null) {
                //throw new IOException("Already connected");
            //}
            //if (stream.isConnected) {
                //throw new IOException("Pipe already connected");
            //}
            //stream.establishConnection();
            //this.target = stream;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.175 -0400", hash_original_method = "4767B865A10590C82F9C2F7878251CCF", hash_generated_method = "4B988EA3F7294E6C84817261AE9011E9")
    @Override
    public void flush() throws IOException {
        PipedInputStream stream = target;
        if(stream == null)        
        {
            return;
        } //End block
        synchronized
(stream)        {
            stream.notifyAll();
        } //End block
        // ---------- Original Method ----------
        //PipedInputStream stream = target;
        //if (stream == null) {
            //return;
        //}
        //synchronized (stream) {
            //stream.notifyAll();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.176 -0400", hash_original_method = "2AED6D37E619AA85421BF0C9628FA8FE", hash_generated_method = "0947B3AC86EF7763EEA24B39991FB365")
    @Override
    public void write(byte[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        super.write(buffer, offset, count);
        // ---------- Original Method ----------
        //super.write(buffer, offset, count);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.176 -0400", hash_original_method = "BFD8A7C0A63758DDB744E4CC4F7CF855", hash_generated_method = "99944A48378686D2EE48D725FEB0652B")
    @Override
    public void write(int oneByte) throws IOException {
        addTaint(oneByte);
        PipedInputStream stream = target;
        if(stream == null)        
        {
            IOException varCCA92B31BAC776950A6EA30CF1B3AEE9_61608275 = new IOException("Pipe not connected");
            varCCA92B31BAC776950A6EA30CF1B3AEE9_61608275.addTaint(taint);
            throw varCCA92B31BAC776950A6EA30CF1B3AEE9_61608275;
        } //End block
        stream.receive(oneByte);
        // ---------- Original Method ----------
        //PipedInputStream stream = target;
        //if (stream == null) {
            //throw new IOException("Pipe not connected");
        //}
        //stream.receive(oneByte);
    }

    
}

