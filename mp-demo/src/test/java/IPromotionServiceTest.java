import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.dxn.config.PromotionApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 促销测试类
 *
 * @author: chenwenning
 * @created: 2021/01/04 16:12
 * @version: V1.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {PromotionApplication.class})
@RunWith(SpringRunner.class)
public class IPromotionServiceTest {


    @Test
    public void mPgenerator() {

        String projectPath = System.getProperty("user.dir");

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("D.xn")
                .setOutputDir(projectPath + "/src/main/java")
                .setFileOverride(true)
//                .setServiceName("BaseService")
                .setIdType(IdType.AUTO)
                .setBaseColumnList(true)
                .setEnableCache(false);

        // 2数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://192.168.100.212:13306/ark_promotion_dev?useUnicode=true&characterEncoding=utf-8")
                .setUsername("ark-dev")
                .setPassword("ark2rfv#TGB");

        // 3 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(new String[]{"pe_coupon", "pe_coupon_audit", "pe_coupon_scope", "pe_user_coupon"})
                .setTablePrefix("pe_");

        // 4 包名配置策略
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.iqihang.ark.promotion.coupon")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("domain");

        // 5 整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setDataSource(dsConfig)
                .setGlobalConfig(globalConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        ag.execute();
    }

}