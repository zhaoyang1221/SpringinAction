package concert;

/**
 * <p>Title: DefaultEncoreable</p>
 *
 * @description: 默认实现类
 * @author: xiongzy
 * @date: 2018-10-18
 **/
public class DefaultEncoreable implements Encoreable {

    @Override
    public void performEncore() {
        System.out.println("返场表演！！");
    }
}