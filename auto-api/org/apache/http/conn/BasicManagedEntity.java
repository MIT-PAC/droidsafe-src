package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public class BasicManagedEntity extends HttpEntityWrapper implements ConnectionReleaseTrigger, EofSensorWatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.186 -0400", hash_original_field = "58ED85B7F214AB5BB7A822D300274AA0", hash_generated_field = "A39C84F92F3A7EA4C05EE395EC188DAE")

    protected ManagedClientConnection managedConn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.186 -0400", hash_original_field = "BC1D8257E471E8A2ADFDE56CC9E36679", hash_generated_field = "E3C3E883F50FA4994DDE044495909683")

    protected boolean attemptReuse;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.193 -0400", hash_original_method = "75E41BB014942CF37AED72804C2A632B", hash_generated_method = "5FE8F35F235BFE02809DC1D5FD98EEB8")
    public  BasicManagedEntity(HttpEntity entity,
                              ManagedClientConnection conn,
                              boolean reuse) {
        super(entity);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection may not be null.");
        this.managedConn = conn;
        this.attemptReuse = reuse;
        addTaint(entity.getTaint());
        // ---------- Original Method ----------
        //if (conn == null)
            //throw new IllegalArgumentException
                //("Connection may not be null.");
        //this.managedConn = conn;
        //this.attemptReuse = reuse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.193 -0400", hash_original_method = "731D88F5D8865617BA362DCED4C30896", hash_generated_method = "1BEBF511A3E32AEE5D0423FB1C48121E")
    @Override
    public boolean isRepeatable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136914107 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_136914107;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.194 -0400", hash_original_method = "5A535D8BC3EB290E639D312782FBEB37", hash_generated_method = "1C9AFBBDE67593DDE863F263CF86063B")
    @Override
    public InputStream getContent() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_613770985 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_613770985 = new EofSensorInputStream(wrappedEntity.getContent(), this);
        varB4EAC82CA7396A68D541C85D26508E83_613770985.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_613770985;
        // ---------- Original Method ----------
        //return new EofSensorInputStream(wrappedEntity.getContent(), this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.194 -0400", hash_original_method = "58D11A845FE872643BE2CB7CB3DAF1D5", hash_generated_method = "72E886F91EF026DA2DB45EF595418C21")
    @Override
    public void consumeContent() throws IOException {
        try 
        {
            {
                wrappedEntity.consumeContent();
                managedConn.markReusable();
            } //End block
        } //End block
        finally 
        {
            releaseManagedConnection();
        } //End block
        // ---------- Original Method ----------
        //if (managedConn == null)
            //return;
        //try {
            //if (attemptReuse) {
                //wrappedEntity.consumeContent();
                //managedConn.markReusable();
            //}
        //} finally {
            //releaseManagedConnection();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.194 -0400", hash_original_method = "7A0C9BF6AEBE62A6A7FD18951D7BE860", hash_generated_method = "1557AF982913249661B38B43D662A506")
    @Override
    public void writeTo(final OutputStream outstream) throws IOException {
        super.writeTo(outstream);
        consumeContent();
        addTaint(outstream.getTaint());
        // ---------- Original Method ----------
        //super.writeTo(outstream);
        //consumeContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.198 -0400", hash_original_method = "4116E5CDB1EF6E698D2E6ADBA9E28033", hash_generated_method = "CCEB45ABA7930FB8F4049A36679817EB")
    public void releaseConnection() throws IOException {
        this.consumeContent();
        // ---------- Original Method ----------
        //this.consumeContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.198 -0400", hash_original_method = "09E9D1BA9D6B3D57F6131522158659B5", hash_generated_method = "3DB924759B0262B66D83F05661836FE4")
    public void abortConnection() throws IOException {
        {
            try 
            {
                managedConn.abortConnection();
            } //End block
            finally 
            {
                managedConn = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (managedConn != null) {
            //try {
                //managedConn.abortConnection();
            //} finally {
                //managedConn = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.198 -0400", hash_original_method = "5A64D16D6F2B869D7FBA53B05FD87C82", hash_generated_method = "B818759F09A39EF439AF6D8F45CC3BDE")
    public boolean eofDetected(InputStream wrapped) throws IOException {
        try 
        {
            {
                wrapped.close();
                managedConn.markReusable();
            } //End block
        } //End block
        finally 
        {
            releaseManagedConnection();
        } //End block
        addTaint(wrapped.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_584585188 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_584585188;
        // ---------- Original Method ----------
        //try {
            //if (attemptReuse && (managedConn != null)) {
                //wrapped.close();
                //managedConn.markReusable();
            //}
        //} finally {
            //releaseManagedConnection();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.199 -0400", hash_original_method = "317830EACA4241C6C1785BE58FAD1AFA", hash_generated_method = "DF70168AA043BD1C696EC3C608ABBCE5")
    public boolean streamClosed(InputStream wrapped) throws IOException {
        try 
        {
            {
                wrapped.close();
                managedConn.markReusable();
            } //End block
        } //End block
        finally 
        {
            releaseManagedConnection();
        } //End block
        addTaint(wrapped.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_503072599 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_503072599;
        // ---------- Original Method ----------
        //try {
            //if (attemptReuse && (managedConn != null)) {
                //wrapped.close();
                //managedConn.markReusable();
            //}
        //} finally {
            //releaseManagedConnection();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.200 -0400", hash_original_method = "BAB258C2D5F3651DF9A25667D27EF99D", hash_generated_method = "9CC16091664DF2C3F8F31D5309E14C7A")
    public boolean streamAbort(InputStream wrapped) throws IOException {
        {
            managedConn.abortConnection();
        } //End block
        addTaint(wrapped.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1189657108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1189657108;
        // ---------- Original Method ----------
        //if (managedConn != null) {
            //managedConn.abortConnection();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.200 -0400", hash_original_method = "713B19D560033B1B50E26BAD17DD5FF2", hash_generated_method = "AAC065C27304F895FEA48B70FB406405")
    protected void releaseManagedConnection() throws IOException {
        {
            try 
            {
                managedConn.releaseConnection();
            } //End block
            finally 
            {
                managedConn = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (managedConn != null) {
            //try {
                //managedConn.releaseConnection();
            //} finally {
                //managedConn = null;
            //}
        //}
    }

    
}

