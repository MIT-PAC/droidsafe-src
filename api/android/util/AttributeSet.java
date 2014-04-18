package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface AttributeSet {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public int getAttributeCount();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getAttributeName(int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getAttributeValue(int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getAttributeValue(String namespace, String name);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getPositionDescription();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeNameResource(int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeListValue(String namespace, String attribute,
                                     String[] options, int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean getAttributeBooleanValue(String namespace, String attribute,
                                            boolean defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeResourceValue(String namespace, String attribute,
                                         int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeIntValue(String namespace, String attribute,
                                    int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeUnsignedIntValue(String namespace, String attribute,
                                            int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public float getAttributeFloatValue(String namespace, String attribute,
                                        float defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeListValue(int index, String[] options, int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean getAttributeBooleanValue(int index, boolean defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeResourceValue(int index, int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeIntValue(int index, int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getAttributeUnsignedIntValue(int index, int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public float getAttributeFloatValue(int index, float defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getIdAttribute();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getClassAttribute();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getIdAttributeResourceValue(int defaultValue);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getStyleAttribute();

    public static class EmptyAttributeSet implements AttributeSet {

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeCount() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public String getAttributeName(int index) {
            // TODO Auto-generated method stub
            addTaint(index);
            String str = new String();
            str.addTaint(getTaint());
            return str;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public String getAttributeValue(int index) {
            // TODO Auto-generated method stub
            addTaint(index);
            String str = new String();
            str.addTaint(getTaint());
            return str;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public String getAttributeValue(String namespace, String name) {
            // TODO Auto-generated method stub
            addTaint(name.getTaint());
            addTaint(namespace.getTaint());
            String str = new String();
            str.addTaint(getTaint());
            return str;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public String getPositionDescription() {
            // TODO Auto-generated method stub
            String str = new String();
            str.addTaint(getTaint());
            return str;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeNameResource(int index) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeListValue(String namespace, String attribute,
                String[] options, int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public boolean getAttributeBooleanValue(String namespace,
                String attribute, boolean defaultValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeResourceValue(String namespace,
                String attribute, int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeIntValue(String namespace, String attribute,
                int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeUnsignedIntValue(String namespace,
                String attribute, int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public float getAttributeFloatValue(String namespace, String attribute,
                float defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeListValue(int index, String[] options,
                int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public boolean getAttributeBooleanValue(int index, boolean defaultValue) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeResourceValue(int index, int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeIntValue(int index, int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getAttributeUnsignedIntValue(int index, int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public float getAttributeFloatValue(int index, float defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public String getIdAttribute() {
            // TODO Auto-generated method stub
            String str = new String();
            str.addTaint(getTaint());
            return str; 
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public String getClassAttribute() {
            // TODO Auto-generated method stub
            String str = new String();
            str.addTaint(getTaint());
            return str; 
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getIdAttributeResourceValue(int defaultValue) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public int getStyleAttribute() {
            // TODO Auto-generated method stub
            return 0;
        }
    }
}
