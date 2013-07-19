package android.util;

// Droidsafe Imports

public interface Poolable<T> {
    void setNextPoolable(T element);
    T getNextPoolable();
    boolean isPooled();
    void setPooled(boolean isPooled);
}
