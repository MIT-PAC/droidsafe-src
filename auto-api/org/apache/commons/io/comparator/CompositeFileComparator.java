package org.apache.commons.io.comparator;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompositeFileComparator extends AbstractFileComparator implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.483 -0400", hash_original_field = "F6181D3345B223DC5FCAF31CEAAA79C3", hash_generated_field = "577A5DF0D229ECB4715636D7E1830F2D")

    private Comparator<File>[] delegates;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.483 -0400", hash_original_method = "5DBBCC36A1E40C37C83AB1F6C81AA43A", hash_generated_method = "5C4E5DB688F6636F2B0C20DC5E21A2EE")
    @SuppressWarnings("unchecked")
    public  CompositeFileComparator(Comparator<File>... delegates) {
        {
            this.delegates = (Comparator<File>[]) NO_COMPARATORS;
        } //End block
        {
            this.delegates = (Comparator<File>[]) new Comparator<?>[delegates.length];
            System.arraycopy(delegates, 0, this.delegates, 0, delegates.length);
        } //End block
        // ---------- Original Method ----------
        //if (delegates == null) {
            //this.delegates = (Comparator<File>[]) NO_COMPARATORS;
        //} else {
            //this.delegates = (Comparator<File>[]) new Comparator<?>[delegates.length];
            //System.arraycopy(delegates, 0, this.delegates, 0, delegates.length);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.503 -0400", hash_original_method = "CB873E20A34C1FCC65A288AB5E09AA6B", hash_generated_method = "4D114C0D907DF125A197562BBF7D8E67")
    @SuppressWarnings("unchecked")
    public  CompositeFileComparator(Iterable<Comparator<File>> delegates) {
        {
            this.delegates = (Comparator<File>[]) NO_COMPARATORS;
        } //End block
        {
            List<Comparator<File>> list;
            list = new ArrayList<Comparator<File>>();
            {
                Iterator<Comparator<File>> varF8FBF51AA024B7207DD7A0E3B6BF0197_1037753268 = (delegates).iterator();
                varF8FBF51AA024B7207DD7A0E3B6BF0197_1037753268.hasNext();
                Comparator<File> comparator = varF8FBF51AA024B7207DD7A0E3B6BF0197_1037753268.next();
                {
                    list.add(comparator);
                } //End block
            } //End collapsed parenthetic
            this.delegates = (Comparator<File>[]) list.toArray(new Comparator<?>[list.size()]);
        } //End block
        // ---------- Original Method ----------
        //if (delegates == null) {
            //this.delegates = (Comparator<File>[]) NO_COMPARATORS; 
        //} else {
            //List<Comparator<File>> list = new ArrayList<Comparator<File>>();
            //for (Comparator<File> comparator : delegates) {
                //list.add(comparator);
            //}
            //this.delegates = (Comparator<File>[]) list.toArray(new Comparator<?>[list.size()]); 
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.528 -0400", hash_original_method = "6BA921DFE406E4FB2E3ADDA69967D7F7", hash_generated_method = "097B6B59A92DF7323A9B448B8019FB8E")
    public int compare(File file1, File file2) {
        int result;
        result = 0;
        {
            Comparator<File> delegate = delegates[0];
            {
                result = delegate.compare(file1, file2);
            } //End block
        } //End collapsed parenthetic
        addTaint(file1.getTaint());
        addTaint(file2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720976630 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720976630;
        // ---------- Original Method ----------
        //int result = 0;
        //for (Comparator<File> delegate : delegates) {
            //result = delegate.compare(file1, file2);
            //if (result != 0) {
                //break;
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.529 -0400", hash_original_method = "47C1793FC370107B09B70CFDB1B2DA4E", hash_generated_method = "6DC20B5BC033060C9AC3816DD5CCC7C6")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_304645494 = null; //Variable for return #1
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append(super.toString());
        builder.append('{');
        {
            int i;
            i = 0;
            {
                {
                    builder.append(',');
                } //End block
                builder.append(delegates[i]);
            } //End block
        } //End collapsed parenthetic
        builder.append('}');
        varB4EAC82CA7396A68D541C85D26508E83_304645494 = builder.toString();
        varB4EAC82CA7396A68D541C85D26508E83_304645494.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_304645494;
        // ---------- Original Method ----------
        //StringBuilder builder = new StringBuilder();
        //builder.append(super.toString());
        //builder.append('{');
        //for (int i = 0; i < delegates.length; i++) {
            //if (i > 0) {
                //builder.append(',');
            //}
            //builder.append(delegates[i]);
        //}
        //builder.append('}');
        //return builder.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.529 -0400", hash_original_field = "6BAC6D83A98EE05A10CFB3D4F5EEF309", hash_generated_field = "DF291B55246DD240FDB6FDFD3968A41C")

    private static Comparator<?>[] NO_COMPARATORS = {};
}

