package dk.brics.string.util;

public interface Indexer<E> {
	int getIndex(E object);
	int getHighestIndex();
}
