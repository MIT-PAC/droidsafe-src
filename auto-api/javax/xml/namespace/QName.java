package javax.xml.namespace;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.security.AccessController;
import java.security.PrivilegedAction;
import javax.xml.XMLConstants;

public class QName implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.519 -0400", hash_original_field = "5295F3E9C46315AF1C2132265086FA24", hash_generated_field = "CCE51D9450F9AA53957D024DB76AA394")

    private String namespaceURI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.519 -0400", hash_original_field = "D0C143FE297B0E7007B1500CA456F91A", hash_generated_field = "BD4655D30926984A9436717671561554")

    private String localPart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.519 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

    private String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.519 -0400", hash_original_field = "9533F77F9BE25E0990AF8FC3CA64C259", hash_generated_field = "B78D2FE89B5FD5EFEBEAC57063EE018D")

    private transient String qNameAsString;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.520 -0400", hash_original_method = "60C18FFA0999928F4EF4CE38330EEA9C", hash_generated_method = "51B8E8BDEB0E271022481A9B0EF5D037")
    public  QName(final String namespaceURI, final String localPart) {
        this(namespaceURI, localPart, XMLConstants.DEFAULT_NS_PREFIX);
        addTaint(namespaceURI.getTaint());
        addTaint(localPart.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.520 -0400", hash_original_method = "87290A11E663766C5D730268BE60DA33", hash_generated_method = "2B6D61295B60BA177D4C50EA42A16290")
    public  QName(String namespaceURI, String localPart, String prefix) {
        {
            this.namespaceURI = XMLConstants.NULL_NS_URI;
        } 
        {
            this.namespaceURI = namespaceURI;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("local part cannot be \"null\" when creating a QName");
        } 
        this.localPart = localPart;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("prefix cannot be \"null\" when creating a QName");
        } 
        this.prefix = prefix;
        
        
            
        
            
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.521 -0400", hash_original_method = "FB37276CA76194E00C121CCB514173FF", hash_generated_method = "D50DCD112C81B0CA312988143BD26BE7")
    public  QName(String localPart) {
        this(
            XMLConstants.NULL_NS_URI,
            localPart,
            XMLConstants.DEFAULT_NS_PREFIX);
        addTaint(localPart.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.521 -0400", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "23CAEB1E2A2DD99A7EC7AB784C9E2815")
    public String getNamespaceURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_999716980 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_999716980 = namespaceURI;
        varB4EAC82CA7396A68D541C85D26508E83_999716980.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_999716980;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.521 -0400", hash_original_method = "859D888619C719D6166AE581FCA9B720", hash_generated_method = "3E57DE9F4513D5A29907BE8B998ED51E")
    public String getLocalPart() {
        String varB4EAC82CA7396A68D541C85D26508E83_642960122 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_642960122 = localPart;
        varB4EAC82CA7396A68D541C85D26508E83_642960122.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_642960122;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.522 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "1D2F9DA0EED4DA1E405CCF619237C8EA")
    public String getPrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_498838324 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_498838324 = prefix;
        varB4EAC82CA7396A68D541C85D26508E83_498838324.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_498838324;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.522 -0400", hash_original_method = "BFBDC6DCA93063BC73A64B69D67A34C1", hash_generated_method = "55EC83ABD8521B07E7C0C89EA3C2C38F")
    public final boolean equals(Object objectToTest) {
        {
            boolean var1738C43110B80B68809A374A2DE0B400_1100554322 = (objectToTest == this);
        } 
        {
            QName qName = (QName) objectToTest;
            boolean var0F7F156F09F7E96CBB489EE5EBBF4A09_1586208474 = (localPart.equals(qName.localPart) && namespaceURI.equals(qName.namespaceURI));
        } 
        addTaint(objectToTest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1066869793 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1066869793;
        
        
            
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.523 -0400", hash_original_method = "DDE43EBD2CC957CB57AF503B05996F38", hash_generated_method = "F7F6E770734E4E85463D19EA1B63379E")
    public final int hashCode() {
        int varAE3A2D4E13A297882A9F0F7DFEDC82B1_1152939081 = (namespaceURI.hashCode() ^ localPart.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067913033 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067913033;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.523 -0400", hash_original_method = "140023602587BA12FA2AD0493531CEF5", hash_generated_method = "D6D1CE4FA69B6CD2916929E6E15EFF04")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_525400978 = null; 
        String _qNameAsString = qNameAsString;
        {
            final int nsLength = namespaceURI.length();
            {
                _qNameAsString = localPart;
            } 
            {
                StringBuilder buffer = new StringBuilder(nsLength + localPart.length() + 2);
                buffer.append('{');
                buffer.append(namespaceURI);
                buffer.append('}');
                buffer.append(localPart);
                _qNameAsString = buffer.toString();
            } 
            qNameAsString = _qNameAsString;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_525400978 = _qNameAsString;
        varB4EAC82CA7396A68D541C85D26508E83_525400978.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_525400978;
        
        
        
            
            
                
            
            
                
                
                
                
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static QName valueOf(String qNameAsString) {
        if (qNameAsString == null) {
            throw new IllegalArgumentException("cannot create QName from \"null\" or \"\" String");
        }
        if (qNameAsString.length() == 0) {
            return new QName(
                XMLConstants.NULL_NS_URI,
                qNameAsString,
                XMLConstants.DEFAULT_NS_PREFIX);
        }
        if (qNameAsString.charAt(0) != '{') {
            return new QName(
                XMLConstants.NULL_NS_URI,
                qNameAsString,
                XMLConstants.DEFAULT_NS_PREFIX);
        }
        if (qNameAsString.startsWith("{" + XMLConstants.NULL_NS_URI + "}")) {
            throw new IllegalArgumentException(
                "Namespace URI .equals(XMLConstants.NULL_NS_URI), "
                + ".equals(\"" + XMLConstants.NULL_NS_URI + "\"), "
                + "only the local part, "
                + "\"" + qNameAsString.substring(2 + XMLConstants.NULL_NS_URI.length()) + "\", "
                + "should be provided.");
        }
        int endOfNamespaceURI = qNameAsString.indexOf('}');
        if (endOfNamespaceURI == -1) {
            throw new IllegalArgumentException(
                "cannot create QName from \""
                    + qNameAsString
                    + "\", missing closing \"}\"");
        }
        return new QName(
            qNameAsString.substring(1, endOfNamespaceURI),
            qNameAsString.substring(endOfNamespaceURI + 1),
            XMLConstants.DEFAULT_NS_PREFIX);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.524 -0400", hash_original_method = "3A49E665D16E7BB62A75B8A236B62D06", hash_generated_method = "5165934C033A089A52E4D2327AA18185")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        {
            prefix = XMLConstants.DEFAULT_NS_PREFIX;
        } 
        addTaint(in.getTaint());
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.524 -0400", hash_original_field = "C6E1E520055C2B7E9948B6F1429B8974", hash_generated_field = "4D3F16E7238D756057D868633B8EE915")

    private static long serialVersionUID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.524 -0400", hash_original_field = "EDD176DF6676514CA32D772644C30474", hash_generated_field = "130E34B944FFEBC5E1898FE7D31939DA")

    private static final long defaultSerialVersionUID = -9120448754896609940L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.524 -0400", hash_original_field = "8717FC749EB098E6911ED18242327B60", hash_generated_field = "9FE064B69D49CFE58884AF45C86B4086")

    private static final long compatibilitySerialVersionUID = 4418622981026545151L;
    static {
        String compatPropValue = System.getProperty("org.apache.xml.namespace.QName.useCompatibleSerialVersionUID");
        serialVersionUID = !"1.0".equals(compatPropValue) ? defaultSerialVersionUID : compatibilitySerialVersionUID;
    }
    
}

