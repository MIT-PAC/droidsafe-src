package org.apache.http.conn;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public class BasicManagedEntity extends HttpEntityWrapper implements ConnectionReleaseTrigger, EofSensorWatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.007 -0400", hash_original_field = "58ED85B7F214AB5BB7A822D300274AA0", hash_generated_field = "A39C84F92F3A7EA4C05EE395EC188DAE")

    protected ManagedClientConnection managedConn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.007 -0400", hash_original_field = "BC1D8257E471E8A2ADFDE56CC9E36679", hash_generated_field = "E3C3E883F50FA4994DDE044495909683")

    protected boolean attemptReuse;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.008 -0400", hash_original_method = "75E41BB014942CF37AED72804C2A632B", hash_generated_method = "5FE8F35F235BFE02809DC1D5FD98EEB8")
    public  BasicManagedEntity(HttpEntity entity,
                              ManagedClientConnection conn,
                              boolean reuse) {
        super(entity);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection may not be null.");
        this.managedConn = conn;
        this.attemptReuse = reuse;
        addTaint(entity.getTaint());
        
        
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.008 -0400", hash_original_method = "731D88F5D8865617BA362DCED4C30896", hash_generated_method = "E954215285806BD366979978D50187EB")
    @Override
    public boolean isRepeatable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_159910725 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_159910725;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.008 -0400", hash_original_method = "5A535D8BC3EB290E639D312782FBEB37", hash_generated_method = "1B74188ED2D141F52305466882CAAED5")
    @Override
    public InputStream getContent() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1189396849 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1189396849 = new EofSensorInputStream(wrappedEntity.getContent(), this);
        varB4EAC82CA7396A68D541C85D26508E83_1189396849.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1189396849;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.008 -0400", hash_original_method = "58D11A845FE872643BE2CB7CB3DAF1D5", hash_generated_method = "72E886F91EF026DA2DB45EF595418C21")
    @Override
    public void consumeContent() throws IOException {
        try 
        {
            {
                wrappedEntity.consumeContent();
                managedConn.markReusable();
            } 
        } 
        finally 
        {
            releaseManagedConnection();
        } 
        
        
            
        
            
                
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.009 -0400", hash_original_method = "7A0C9BF6AEBE62A6A7FD18951D7BE860", hash_generated_method = "1557AF982913249661B38B43D662A506")
    @Override
    public void writeTo(final OutputStream outstream) throws IOException {
        super.writeTo(outstream);
        consumeContent();
        addTaint(outstream.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.009 -0400", hash_original_method = "4116E5CDB1EF6E698D2E6ADBA9E28033", hash_generated_method = "CCEB45ABA7930FB8F4049A36679817EB")
    public void releaseConnection() throws IOException {
        this.consumeContent();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.009 -0400", hash_original_method = "09E9D1BA9D6B3D57F6131522158659B5", hash_generated_method = "3DB924759B0262B66D83F05661836FE4")
    public void abortConnection() throws IOException {
        {
            try 
            {
                managedConn.abortConnection();
            } 
            finally 
            {
                managedConn = null;
            } 
        } 
        
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.009 -0400", hash_original_method = "5A64D16D6F2B869D7FBA53B05FD87C82", hash_generated_method = "94DD930F0347EA847863F3E1BA21835D")
    public boolean eofDetected(InputStream wrapped) throws IOException {
        try 
        {
            {
                wrapped.close();
                managedConn.markReusable();
            } 
        } 
        finally 
        {
            releaseManagedConnection();
        } 
        addTaint(wrapped.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1353103426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1353103426;
        
        
            
                
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.010 -0400", hash_original_method = "317830EACA4241C6C1785BE58FAD1AFA", hash_generated_method = "0832D3231E70D1FA26A3E4BBC1EC7B89")
    public boolean streamClosed(InputStream wrapped) throws IOException {
        try 
        {
            {
                wrapped.close();
                managedConn.markReusable();
            } 
        } 
        finally 
        {
            releaseManagedConnection();
        } 
        addTaint(wrapped.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_602197366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_602197366;
        
        
            
                
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.010 -0400", hash_original_method = "BAB258C2D5F3651DF9A25667D27EF99D", hash_generated_method = "71B286E47EE3C94C7CFCF0405ACF60EE")
    public boolean streamAbort(InputStream wrapped) throws IOException {
        {
            managedConn.abortConnection();
        } 
        addTaint(wrapped.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065484575 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065484575;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.010 -0400", hash_original_method = "713B19D560033B1B50E26BAD17DD5FF2", hash_generated_method = "AAC065C27304F895FEA48B70FB406405")
    protected void releaseManagedConnection() throws IOException {
        {
            try 
            {
                managedConn.releaseConnection();
            } 
            finally 
            {
                managedConn = null;
            } 
        } 
        
        
            
                
            
                
            
        
    }

    
}

