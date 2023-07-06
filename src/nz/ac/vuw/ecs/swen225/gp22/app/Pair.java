package nz.ac.vuw.ecs.swen225.gp22.app;

public class Pair<K, V> {
    private K key;
    private V value;

    public K key() { return key; }
    public V value() { return value; }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
