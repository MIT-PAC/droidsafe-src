package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface AttributeSet {
    
    public int getAttributeCount();

    
    public String getAttributeName(int index);

    
    public String getAttributeValue(int index);

    
    public String getAttributeValue(String namespace, String name);

    
    public String getPositionDescription();

    
    public int getAttributeNameResource(int index);

    
    public int getAttributeListValue(String namespace, String attribute,
                                     String[] options, int defaultValue);

    
    public boolean getAttributeBooleanValue(String namespace, String attribute,
                                            boolean defaultValue);

    
    public int getAttributeResourceValue(String namespace, String attribute,
                                         int defaultValue);

    
    public int getAttributeIntValue(String namespace, String attribute,
                                    int defaultValue);

    
    public int getAttributeUnsignedIntValue(String namespace, String attribute,
                                            int defaultValue);

    
    public float getAttributeFloatValue(String namespace, String attribute,
                                        float defaultValue);

    
    public int getAttributeListValue(int index, String[] options, int defaultValue);

    
    public boolean getAttributeBooleanValue(int index, boolean defaultValue);

    
    public int getAttributeResourceValue(int index, int defaultValue);

    
    public int getAttributeIntValue(int index, int defaultValue);

    
    public int getAttributeUnsignedIntValue(int index, int defaultValue);

    
    public float getAttributeFloatValue(int index, float defaultValue);

    
    public String getIdAttribute();

    
    public String getClassAttribute();

    
    public int getIdAttributeResourceValue(int defaultValue);

    
    public int getStyleAttribute();
}
