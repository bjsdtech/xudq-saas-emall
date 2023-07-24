package com.xudq.emall.component.zklock;

public interface ZKLock {

    boolean lock(String lockpath);

    boolean unlock(String lockpath);

}
