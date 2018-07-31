package company.xiao20180731;

public class BitSetUtil {

    /**
     * 设置某个标签
     *
     * @param bits
     * @param pos
     * @return
     */
    public static long set(long bits, int pos) {
        return (pos > 0) ? (bits | 1L << pos - 1) : bits;
    }

    /**
     * 清理某个标签
     *
     * @param bits
     * @param pos
     * @return
     */
    public static long clear(long bits, int pos) {
        return (pos > 0) ? (bits & ~(1L << pos - 1)) : bits;
    }

    /**
     * 是否有某个标签
     *
     * @param bits
     * @param pos
     * @return
     */
    public static boolean has(long bits, int pos) {
        long mark = 1L << pos - 1;
        return (bits & mark) == mark;
    }


}
