package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PriorityQueue<E> extends AbstractQueue<E> implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.667 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.667 -0400", hash_original_field = "4092F21BD0E2CC3C9CA971DF59AA8608", hash_generated_field = "0E313AD6D66C4F0B00F12D6B16E96047")

    private Comparator<? super E> comparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.667 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "777D1E33E50D4CDEA795A5FBEBE9B75E")

    private transient E[] elements;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.667 -0400", hash_original_method = "58E13E76C10508B840C89750DBA2F694", hash_generated_method = "E9B04ED5345B292AB2449CD20B00601E")
    public  PriorityQueue() {
        this(DEFAULT_CAPACITY);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.668 -0400", hash_original_method = "911F14A3F7F22EFA3B185959CB78D2B3", hash_generated_method = "ACF5EE27996EEA2E09D5472C34B00B28")
    public  PriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
        addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.668 -0400", hash_original_method = "8DDCD911658428EEC7F53C9270972E95", hash_generated_method = "2D885A182777F261205D361EA73AADAA")
    public  PriorityQueue(int initialCapacity, Comparator<? super E> comparator) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        elements = newElementArray(initialCapacity);
        this.comparator = comparator;
        // ---------- Original Method ----------
        //if (initialCapacity < 1) {
            //throw new IllegalArgumentException();
        //}
        //elements = newElementArray(initialCapacity);
        //this.comparator = comparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.668 -0400", hash_original_method = "C29AE678CCE898A5EAC5F93683C50E53", hash_generated_method = "8256F0D9F24915C551496FD016A950B7")
    public  PriorityQueue(Collection<? extends E> c) {
        {
            getFromPriorityQueue((PriorityQueue<? extends E>) c);
        } //End block
        {
            getFromSortedSet((SortedSet<? extends E>) c);
        } //End block
        {
            initSize(c);
            addAll(c);
        } //End block
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //if (c instanceof PriorityQueue) {
            //getFromPriorityQueue((PriorityQueue<? extends E>) c);
        //} else if (c instanceof SortedSet) {
            //getFromSortedSet((SortedSet<? extends E>) c);
        //} else {
            //initSize(c);
            //addAll(c);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.669 -0400", hash_original_method = "DE95FDD082B572F7824AA76C4D6C59F3", hash_generated_method = "6C27BC807D16E35A1B59FBE7A015FC0E")
    public  PriorityQueue(PriorityQueue<? extends E> c) {
        getFromPriorityQueue(c);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //getFromPriorityQueue(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.669 -0400", hash_original_method = "2B1757BB83768A507629744C75B61CCF", hash_generated_method = "42979B879C4FD51A50B4D214039D47DA")
    public  PriorityQueue(SortedSet<? extends E> c) {
        getFromSortedSet(c);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //getFromSortedSet(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.670 -0400", hash_original_method = "29E42406182AF866EF1235165AD5E16B", hash_generated_method = "731FF4F59D744AA1E350A48270048058")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1515060877 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1515060877 = new PriorityIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1515060877.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1515060877;
        // ---------- Original Method ----------
        //return new PriorityIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.673 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "8DA4E93D924E815335FFFCB567240C8C")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504842770 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504842770;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.674 -0400", hash_original_method = "B6F04CCC5A967411777D1204AE8409FD", hash_generated_method = "88680BC391D87D89DDEAB30C7B19D82A")
    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
        // ---------- Original Method ----------
        //Arrays.fill(elements, null);
        //size = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.674 -0400", hash_original_method = "0719F1496073B58B1DCD9EB6FF49B15B", hash_generated_method = "D65247DA8A6F58962BD0DCAC8C383064")
    public boolean offer(E o) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        growToSize(size + 1);
        elements[size] = o;
        siftUp(size++);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1832501975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1832501975;
        // ---------- Original Method ----------
        //if (o == null) {
            //throw new NullPointerException();
        //}
        //growToSize(size + 1);
        //elements[size] = o;
        //siftUp(size++);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.675 -0400", hash_original_method = "A38C03A45CA3873EDA3CC27F4EA1E154", hash_generated_method = "00C4BC9050A8956B28FDD318E4E96D60")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_551573173 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_17934901 = null; //Variable for return #2
        {
            boolean var8697D8FD88387502770F7E34BAFBCF5A_369661803 = (isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_551573173 = null;
            } //End block
        } //End collapsed parenthetic
        E result;
        result = elements[0];
        removeAt(0);
        varB4EAC82CA7396A68D541C85D26508E83_17934901 = result;
        E varA7E53CE21691AB073D9660D615818899_1214912984; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1214912984 = varB4EAC82CA7396A68D541C85D26508E83_551573173;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1214912984 = varB4EAC82CA7396A68D541C85D26508E83_17934901;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1214912984.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1214912984;
        // ---------- Original Method ----------
        //if (isEmpty()) {
            //return null;
        //}
        //E result = elements[0];
        //removeAt(0);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.676 -0400", hash_original_method = "E20ADCFD9D589330A90956929B5E43AA", hash_generated_method = "34AD65AAEE8B941FF22980083EB791FD")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_1192785943 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_1083455177 = null; //Variable for return #2
        {
            boolean var8697D8FD88387502770F7E34BAFBCF5A_688372947 = (isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1192785943 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1083455177 = elements[0];
        E varA7E53CE21691AB073D9660D615818899_1277535371; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1277535371 = varB4EAC82CA7396A68D541C85D26508E83_1192785943;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1277535371 = varB4EAC82CA7396A68D541C85D26508E83_1083455177;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1277535371.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1277535371;
        // ---------- Original Method ----------
        //if (isEmpty()) {
            //return null;
        //}
        //return elements[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.690 -0400", hash_original_method = "83ACC201A16F2FDDF97B6B07FFFB2168", hash_generated_method = "430B4B4C78D8D4538255609CBE830748")
    public Comparator<? super E> comparator() {
        Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_1048665986 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1048665986 = comparator;
        varB4EAC82CA7396A68D541C85D26508E83_1048665986.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1048665986;
        // ---------- Original Method ----------
        //return comparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.690 -0400", hash_original_method = "688475050D9EB13B173156735A8487EC", hash_generated_method = "DE9B49939741F0B6A70DD700EF6D0E94")
    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        {
            int targetIndex;
            targetIndex = 0;
            {
                {
                    boolean var14BEDC89BBCC9A2F0435768C7E2596C0_824886902 = (o.equals(elements[targetIndex]));
                    {
                        removeAt(targetIndex);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1939777728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1939777728;
        // ---------- Original Method ----------
        //if (o == null) {
            //return false;
        //}
        //for (int targetIndex = 0; targetIndex < size; targetIndex++) {
            //if (o.equals(elements[targetIndex])) {
                //removeAt(targetIndex);
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.693 -0400", hash_original_method = "B47D74753BC2900138E758F55799A6CE", hash_generated_method = "4D3D08D672813DCDCC9CCE797BFF80D4")
    @Override
    public boolean add(E o) {
        boolean var64BBDD044E2016C4CCF9BF6F99B3CA5E_871308835 = (offer(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_479534335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_479534335;
        // ---------- Original Method ----------
        //return offer(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.702 -0400", hash_original_method = "21BC9CFA0DCB43D7F88609A00A8387EA", hash_generated_method = "CE3C995B15F3A973FA3C131467E63329")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        int capacity;
        capacity = in.readInt();
        elements = newElementArray(capacity);
        {
            int i;
            i = 0;
            {
                elements[i] = (E) in.readObject();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //int capacity = in.readInt();
        //elements = newElementArray(capacity);
        //for (int i = 0; i < size; i++) {
            //elements[i] = (E) in.readObject();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.702 -0400", hash_original_method = "AD595EBD68A8B9AE564B2F0FB242243F", hash_generated_method = "6ED61D1784DA74237674E197C33F4211")
    @SuppressWarnings("unchecked")
    private E[] newElementArray(int capacity) {
        E[] varB4EAC82CA7396A68D541C85D26508E83_1804430570 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1804430570 = (E[]) new Object[capacity];
        addTaint(capacity);
        varB4EAC82CA7396A68D541C85D26508E83_1804430570.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1804430570;
        // ---------- Original Method ----------
        //return (E[]) new Object[capacity];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.703 -0400", hash_original_method = "B9F4F56172F737D7C7C85B3EBC28F8E6", hash_generated_method = "BFCE3FB0914E816F3D05FADEAB11DE9A")
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(elements.length);
        {
            int i;
            i = 0;
            {
                out.writeObject(elements[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.defaultWriteObject();
        //out.writeInt(elements.length);
        //for (int i = 0; i < size; i++) {
            //out.writeObject(elements[i]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.703 -0400", hash_original_method = "D14ABECCFCD1D91F89D634472CAA5A57", hash_generated_method = "A964D74645D797898043F81B6EEC66B2")
    @SuppressWarnings("unchecked")
    private void getFromPriorityQueue(PriorityQueue<? extends E> c) {
        initSize(c);
        comparator = (Comparator<? super E>) c.comparator();
        System.arraycopy(c.elements, 0, elements, 0, c.size());
        size = c.size();
        // ---------- Original Method ----------
        //initSize(c);
        //comparator = (Comparator<? super E>) c.comparator();
        //System.arraycopy(c.elements, 0, elements, 0, c.size());
        //size = c.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.704 -0400", hash_original_method = "4C352FE9F3E754E26A0F4A78FD0E430D", hash_generated_method = "C65F43CC1BD36CCA7FC5D5A4E380EC81")
    @SuppressWarnings("unchecked")
    private void getFromSortedSet(SortedSet<? extends E> c) {
        initSize(c);
        comparator = (Comparator<? super E>) c.comparator();
        Iterator<? extends E> iter;
        iter = c.iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1556263192 = (iter.hasNext());
            {
                elements[size++] = iter.next();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //initSize(c);
        //comparator = (Comparator<? super E>) c.comparator();
        //Iterator<? extends E> iter = c.iterator();
        //while (iter.hasNext()) {
            //elements[size++] = iter.next();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.704 -0400", hash_original_method = "13EA6CC04750FAC13EC27ED999F2AF83", hash_generated_method = "91FB57E0438A27000EA5AC33112B8E90")
    private void removeAt(int index) {
        elements[index] = elements[size];
        siftDown(index);
        elements[size] = null;
        // ---------- Original Method ----------
        //size--;
        //elements[index] = elements[size];
        //siftDown(index);
        //elements[size] = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.704 -0400", hash_original_method = "A0927ACC17EA40D5CE28A0E243882DFA", hash_generated_method = "5B1C6FD3957AAB212D2F268977393E46")
    private int compare(E o1, E o2) {
        {
            int var8E6857C2AA67AFE2E02DAFE705F5A103_1458133732 = (comparator.compare(o1, o2));
        } //End block
        int var003A3D2E3C76D1E7F67F3C0717E9BFEE_836856343 = (((Comparable<? super E>) o1).compareTo(o2));
        addTaint(o1.getTaint());
        addTaint(o2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1216148663 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1216148663;
        // ---------- Original Method ----------
        //if (comparator != null) {
            //return comparator.compare(o1, o2);
        //}
        //return ((Comparable<? super E>) o1).compareTo(o2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.705 -0400", hash_original_method = "800D9111DE2C548E56C8C7DBADDE1532", hash_generated_method = "4394C2AEE8621FCC1756F9918CB6331B")
    private void siftUp(int childIndex) {
        E target;
        target = elements[childIndex];
        int parentIndex;
        {
            parentIndex = (childIndex - 1) / 2;
            E parent;
            parent = elements[parentIndex];
            {
                boolean var23A6EC4002301EE935E150767260E50F_604251899 = (compare(parent, target) <= 0);
            } //End collapsed parenthetic
            elements[childIndex] = parent;
            childIndex = parentIndex;
        } //End block
        elements[childIndex] = target;
        // ---------- Original Method ----------
        //E target = elements[childIndex];
        //int parentIndex;
        //while (childIndex > 0) {
            //parentIndex = (childIndex - 1) / 2;
            //E parent = elements[parentIndex];
            //if (compare(parent, target) <= 0) {
                //break;
            //}
            //elements[childIndex] = parent;
            //childIndex = parentIndex;
        //}
        //elements[childIndex] = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.706 -0400", hash_original_method = "1734F3496FF56F66F4EE0A19F9B9DAC6", hash_generated_method = "F501DEB058DDDBBD9ADE0FA0C2BEF098")
    private void siftDown(int rootIndex) {
        E target;
        target = elements[rootIndex];
        int childIndex;
        {
            boolean var2BE9875CC5BE2A3B1EB426DF1CD26854_357666523 = ((childIndex = rootIndex * 2 + 1) < size);
            {
                {
                    boolean var5A0855C6AD3F11E6528C84B7FB574B75_1255905142 = (childIndex + 1 < size
                    && compare(elements[childIndex + 1], elements[childIndex]) < 0);
                } //End collapsed parenthetic
                {
                    boolean var2D362E3D6324559A45021D01616493EC_391829879 = (compare(target, elements[childIndex]) <= 0);
                } //End collapsed parenthetic
                elements[rootIndex] = elements[childIndex];
                rootIndex = childIndex;
            } //End block
        } //End collapsed parenthetic
        elements[rootIndex] = target;
        // ---------- Original Method ----------
        //E target = elements[rootIndex];
        //int childIndex;
        //while ((childIndex = rootIndex * 2 + 1) < size) {
            //if (childIndex + 1 < size
                    //&& compare(elements[childIndex + 1], elements[childIndex]) < 0) {
                //childIndex++;
            //}
            //if (compare(target, elements[childIndex]) <= 0) {
                //break;
            //}
            //elements[rootIndex] = elements[childIndex];
            //rootIndex = childIndex;
        //}
        //elements[rootIndex] = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.706 -0400", hash_original_method = "EB006E653F2B1C142E2B4E925ED799D5", hash_generated_method = "31E2BE49AA694726AA40B1A0047FD047")
    private void initSize(Collection<? extends E> c) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var528EAD02A70F822F393BB0C54FBB923C_1269794956 = (c.isEmpty());
            {
                elements = newElementArray(1);
            } //End block
            {
                int capacity;
                capacity = (int) Math.ceil(c.size()
                    * DEFAULT_INIT_CAPACITY_RATIO);
                elements = newElementArray(capacity);
            } //End block
        } //End collapsed parenthetic
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //if (c == null) {
            //throw new NullPointerException();
        //}
        //if (c.isEmpty()) {
            //elements = newElementArray(1);
        //} else {
            //int capacity = (int) Math.ceil(c.size()
                    //* DEFAULT_INIT_CAPACITY_RATIO);
            //elements = newElementArray(capacity);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.712 -0400", hash_original_method = "69C661AD3CEEB8E6AEE784D427C4FE57", hash_generated_method = "DCFC4455E972F2E30CD6333E158E8BBA")
    private void growToSize(int size) {
        {
            E[] newElements;
            newElements = newElementArray(size * DEFAULT_CAPACITY_RATIO);
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        } //End block
        addTaint(size);
        // ---------- Original Method ----------
        //if (size > elements.length) {
            //E[] newElements = newElementArray(size * DEFAULT_CAPACITY_RATIO);
            //System.arraycopy(elements, 0, newElements, 0, elements.length);
            //elements = newElements;
        //}
    }

    
    private class PriorityIterator implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.712 -0400", hash_original_field = "0FDC7B8AD151A087959E8267B1003E57", hash_generated_field = "930A7091E390C9A7E80CCAF83CF059FC")

        private int currentIndex = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.712 -0400", hash_original_field = "C8CBC8273C760FD4AFB07C11B42120E4", hash_generated_field = "46337D80FA4CAC78540F7C8D494816D7")

        private boolean allowRemove = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.712 -0400", hash_original_method = "2E6FB10AA8F6C05F40E19220FCEB4F6A", hash_generated_method = "2E6FB10AA8F6C05F40E19220FCEB4F6A")
        public PriorityIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.713 -0400", hash_original_method = "0FB46E9366D1118FDBE303EE479D4896", hash_generated_method = "16BBAD6590FBB81CCF2FB243D9BEB3BD")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1273469834 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1273469834;
            // ---------- Original Method ----------
            //return currentIndex < size - 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.713 -0400", hash_original_method = "23667DB5E37E55798D44E0D3057B4835", hash_generated_method = "549CC5649405B0DC9D088FD649A021DD")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_897350658 = null; //Variable for return #1
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_375017212 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End collapsed parenthetic
            allowRemove = true;
            varB4EAC82CA7396A68D541C85D26508E83_897350658 = elements[++currentIndex];
            varB4EAC82CA7396A68D541C85D26508E83_897350658.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_897350658;
            // ---------- Original Method ----------
            //if (!hasNext()) {
                //throw new NoSuchElementException();
            //}
            //allowRemove = true;
            //return elements[++currentIndex];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.714 -0400", hash_original_method = "DB2903D95C50C28D70F9F205A7F7C8FE", hash_generated_method = "4654C17AF11C21C01E664DAF5AF1C650")
        public void remove() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } //End block
            allowRemove = false;
            removeAt(currentIndex--);
            // ---------- Original Method ----------
            //if (!allowRemove) {
                //throw new IllegalStateException();
            //}
            //allowRemove = false;
            //removeAt(currentIndex--);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.714 -0400", hash_original_field = "A8CEBCDC9E5A376437C3BCDBEE826CAD", hash_generated_field = "52F427A069B898723B3E22594AB919D0")

    private static long serialVersionUID = -7720805057305804111L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.714 -0400", hash_original_field = "C6D4C85929CA1814E8D05E351A264EE9", hash_generated_field = "495E2A05E8A966805BC085151170753A")

    private static int DEFAULT_CAPACITY = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.714 -0400", hash_original_field = "47A5B89B204E4D35D409724169D22E2B", hash_generated_field = "D43D39D9E87ACDB1254193E76AC7740C")

    private static double DEFAULT_INIT_CAPACITY_RATIO = 1.1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.714 -0400", hash_original_field = "6B51169B7E5BF711B9FF1384EA7CF00E", hash_generated_field = "0A597FD750962A106225365CDD9A05F0")

    private static int DEFAULT_CAPACITY_RATIO = 2;
}

