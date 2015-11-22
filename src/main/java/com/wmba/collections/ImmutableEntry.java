package com.wmba.collections;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Map;


/**
 * This is a Parcelable implementation of {@link Map.Entry} which can be used by
 * {@link ImmutableMap}.
 */
public class ImmutableEntry<K, V> implements Map.Entry<K, V>, Parcelable {
  private static final ClassLoader CLASS_LOADER = ImmutableEntry.class.getClassLoader();

  private final K key;
  private final V value;

  public ImmutableEntry(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public ImmutableEntry(Map.Entry<K, V> entry) {
    this.key = entry.getKey();
    this.value = entry.getValue();
  }

  @Override public K getKey() {
    return key;
  }

  @Override public V getValue() {
    return value;
  }

  @Deprecated
  @Override public V setValue(V object) {
    throw new UnsupportedOperationException();
  }

  protected ImmutableEntry(Parcel in) {
    key = (K)in.readValue(CLASS_LOADER);
    value = (V)in.readValue(CLASS_LOADER);
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(key);
    dest.writeValue(value);
  }

  public static final Creator<ImmutableEntry> CREATOR = new Creator<ImmutableEntry>() {
    @Override public ImmutableEntry createFromParcel(Parcel in) {
      return new ImmutableEntry(in);
    }

    @Override public ImmutableEntry[] newArray(int size) {
      return new ImmutableEntry[size];
    }
  };

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ImmutableEntry<?, ?> that = (ImmutableEntry<?, ?>)o;

    if (key != null ? !key.equals(that.key) : that.key != null) return false;
    return !(value != null ? !value.equals(that.value) : that.value != null);
  }

  @Override public int hashCode() {
    int result = key != null ? key.hashCode() : 0;
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }

  @Override public String toString() {
    return "ImmutableEntry{" +
        "key=" + key +
        ", value=" + value +
        '}';
  }
}
