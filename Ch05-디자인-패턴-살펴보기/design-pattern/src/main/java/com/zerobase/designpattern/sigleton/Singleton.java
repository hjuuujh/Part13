package com.zerobase.designpattern.sigleton;

public class Singleton {
//    // volatile 캐시메모리를 사용하지않고 메인 메모리를 사용하도록
//    private static volatile Singleton instance;
//
//    private Singleton() {}
//
//    // 언제든지 인스턴스가져오기위해 static
//    public static Singleton getInstance() {
//        // 초기화 늦추기
//        if(instance == null) { // thread safe 하지 않음 -> 함수에 synchronized -> 느림 더블 체크 이용
//            synchronized (Singleton.class) {
//                if(instance == null) {
//
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    private Singleton() {

    }

    // 지연된 방식
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
