package knights;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaoyang on 2018/7/12/0012.
 */
public class KnightMain {
    public static void main(String[] args) {
        // 使用Xml文件进行bean的配置，所以选用ClassPathXmlApplicationContext作为应用上下文;
        // 如果使用注解来配置bean，选用AnnotationConfigApplicationContext
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();

    }
}
