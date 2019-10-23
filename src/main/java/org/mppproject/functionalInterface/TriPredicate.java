package org.mppproject.functionalInterface;

public interface TriPredicate<R,S,T> {
    boolean constraint(R r, S s, T t);
}
