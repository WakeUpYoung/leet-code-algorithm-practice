package com.wakeupyoung;

@FunctionalInterface
public interface Solution<R, I> {
    public R resolve(I input);
}
