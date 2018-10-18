package concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * <p>Title: EncoreableIntroducer</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-18
 **/
@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "concert.Performance+", // "+"表示performance的所有子类型
            defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
