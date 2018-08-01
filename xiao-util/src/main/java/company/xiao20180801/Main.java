package company.xiao20180801;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        int cycle = 60;
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);

                int delay = cycle - ((int) (System.currentTimeMillis() / 5000) % cycle); //计算出一个绝对时间，保证所有机器都在同一个周期加载
                log.info(delay + "");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
