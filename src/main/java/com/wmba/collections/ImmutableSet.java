package com.wmba.collections;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ImmutableSet<T> implements Set<T>, Parcelable {
  private static final Set<Object> EMPTY = new ImmutableSet<>(new Object[0]);
  private static final ClassLoader CLASS_LOADER = ImmutableSet.class.getClassLoader();

  private final Set<T> set;

  public ImmutableSet(T[] array) {
    this(Arrays.asList(array));
  }

  public ImmutableSet(Collection<T> collection) {
    this.set = Collections.unmodifiableSet(new LinkedHashSet<>(collection));
  }

  public ImmutableSet(Iterable<T> iterable) {
    this(iterable, 0);
  }

  public ImmutableSet(Iterable<T> iterable, int initialCapacity) {
    List<T> list = new ArrayList<>(initialCapacity);
    for (T value : iterable)
      list.add(value);
    this.set = Collections.unmodifiableSet(new LinkedHashSet<>(list));
  }

  public static <T> ImmutableSet<T> empty() {
    //noinspection unchecked
    return (ImmutableSet<T>)EMPTY;
  }

  @Override public boolean contains(Object object) {
    return set.contains(object);
  }

  @Override public boolean containsAll(Collection<?> collection) {
    return set.containsAll(collection);
  }

  @Override public boolean isEmpty() {
    return set.isEmpty();
  }

  @Override public int size() {
    return set.size();
  }

  @Override public Object[] toArray() {
    return set.toArray();
  }

  @Override public <T1> T1[] toArray(T1[] array) {
    return set.toArray(array);
  }

  @Override public Iterator<T> iterator() {
    return set.iterator();
  }

  @Deprecated
  @Override public boolean add(T object) {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  @Override public boolean addAll(Collection<? extends T> collection) {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  @Override public void clear() {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  @Override public boolean remove(Object object) {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  @Override public boolean removeAll(Collection<?> collection) {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  @Override public boolean retainAll(Collection<?> collection) {
    throw new UnsupportedOperationException();
  }

  protected ImmutableSet(Parcel in) {
    set = new LinkedHashSet<>(in.readArrayList(CLASS_LOADER));
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeList(new ArrayList(set));
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<ImmutableSet> CREATOR = new Creator<ImmutableSet>() {
    @Override public ImmutableSet createFromParcel(Parcel in) {
      return new ImmutableSet(in);
    }

    @Override public ImmutableSet[] newArray(int size) {
      return new ImmutableSet[size];
    }
  };

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return set.equals(((ImmutableSet<?>)o).set);
  }

  @Override public int hashCode() {
    return set.hashCode();
  }

  @Override public String toString() {
    return "ImmutableSet{" +
        "set=" + set +
        '}';
  }
}
