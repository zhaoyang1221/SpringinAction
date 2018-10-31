package orders.config;

import com.mongodb.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

/**
 * @author zhaoyang on 2018/10/31/0031.
 */
@Configuration
@EnableMongoRepositories(basePackages = "orders.db")  // 启用spring data mongoDB的Repository功能
public class MongoConfig extends AbstractMongoConfiguration {

    // @Bean
    // public MongoClientFactoryBean mongo() {
    //     MongoClientFactoryBean mongo = new MongoClientFactoryBean();
    //     mongo.setHost("localhost");
    //     return mongo;
    // }
    //
    // @Bean
    // public MongoOperations mongoTemplate(MongoClient mongo) {
    //     return new MongoTemplate(mongo, "OrdersDB");
    // }

    /**
     * 扩展abstractMongoConfiguration,就不用显示的配置上述两个bean，
     * 只需实现下面两个方法而已，更加简洁
     *
     * @return
     */
    @Override
    public Mongo mongo() throws Exception {
        MongoCredential credential = MongoCredential.createCredential("order", "OrdersDB", "order123".toCharArray());

        return new MongoClient(new ServerAddress("192.168.0.186"), credential, MongoClientOptions.builder().build()); // 默认27017端口
    }

    @Override
    protected String getDatabaseName() {
        return "OrdersDB";
    }


}
