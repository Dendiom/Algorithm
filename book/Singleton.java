package LeetCode.book;

/**
 * 多种单例模式的写法
 */

/**
 * Approach 1: 最典型的写法，懒汉式-线程不安全
 */
public class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}

/**
 * Approach 2: 饿汉式-线程安全
 */
class SingletonTwo {
    private static SingletonTwo instance = new SingletonTwo();

    private SingletonTwo(){}

    public static SingletonTwo getInstance() {
        return instance;
    }
}

/**
 * Approach 3: 懒汉式-线程安全，但是性能差，不推荐
 */
class SingletonThree {
    private static SingletonThree instance;

    private SingletonThree() {}

    public synchronized static SingletonThree getInstance() {
        if (instance == null) {
            instance = new SingletonThree();
        }

        return instance;
    }
}

/**
 * Approach 4: 双重校验锁，懒汉式-线程安全，使用volatile变量来保证有序性
 */
class SingletonFour {
    private volatile static SingletonFour instance;

    private SingletonFour() {}

    public static SingletonFour getInstance() {
        if (instance == null) {
            synchronized (SingletonFour.class) {
                if (instance == null) {
                    instance = new SingletonFour();
                }
            }
        }

        return instance;
    }
}

/**
 * Approach 5: 静态内部类实现，懒汉式-线程安全，推荐的一种写法
 */
class SingletonFive {

    private SingletonFive() {}

    public static SingletonFive getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final SingletonFive instance = new SingletonFive();
    }
}

/**
 * Approach 6: 使用枚举类型，懒汉-线程安全 Effect Java推荐的一种写法, SingletonHelper.INSTANCE.getInstance()
 */
class SingletonSix {

}

enum SingletonHelper{
    INSTANCE;  // default static final

    private SingletonSix singletonSix;

    SingletonHelper() {  // default private
        singletonSix = new SingletonSix();
    }

    public SingletonSix getInstance() {
        return singletonSix;
    }
}