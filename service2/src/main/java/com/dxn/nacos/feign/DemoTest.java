package com.dxn.nacos.feign;

import feign.CollectionFormat;
import feign.Param;
import feign.RequestLine;
import feign.template.QueryTemplate;
import feign.template.UriTemplate;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DemoTest {


    @Test
    public void testClient() {
        DemoClient client = null;
        try {
            client = FeignClientFactory.create(DemoClient.class);
            String result = client.getDemo1();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void textUir() {
        UriTemplate template = UriTemplate.create("http://example.com/{foo}", StandardCharsets.UTF_8);
        Map<String, Object> params = new HashMap<>();
        params.put("foo", "bar");
        String result = template.expand(params);
        System.out.println(result);

        System.out.println("=======================================");

        // 对斜杠不要转义
        template = UriTemplate.create("http://example.com/{empty}{foo}index.html{frag}", false, StandardCharsets.UTF_8);

        params.clear();
        // params.put("empty",null);
        params.put("foo", "houses/");
        params.put("frag", "?g=sec1.2");
        result = template.expand(params);
        System.out.println(result);
    }

    @Test
    public void fun2() {
        // 可以看到key也是可以使用模版的。当然你也可以直接使用字符串即可，也可以混合使用
        QueryTemplate template = QueryTemplate.create("hobby-{arg}", Arrays.asList("basket", "foot"), StandardCharsets.UTF_8);
        Map<String, Object> params = new HashMap<>();
        params.put("arg", "1");

        String result = template.expand(params);
        System.out.println(result);

        template = QueryTemplate.create("grade", Arrays.asList("1", "2"), StandardCharsets.UTF_8, CollectionFormat.SSV);
        System.out.println(template);
    }

    @Test
    public void fun1(){
        EncoderClient client = FeignClientFactory.create(EncoderClient.class);

//        client.encoderDemo1("YourBatman1", 18);
//        System.err.println(" ------------------------- ");

//        try { client.encoderDemo2("YourBatman2", 18); }catch (Exception e) {e.printStackTrace();}
//        System.err.println(" ------------------------- ");
//
//        try { client.encoderDemo3("YourBatman3", 18); }catch (Exception e) {e.printStackTrace();}
//        System.err.println(" ------------------------- ");
//
//        try { client.encoderDemo4("YourBatman4"); }catch (Exception e) {e.printStackTrace();}
//        System.err.println(" ------------------------- ");
//
//        try { client.encoderDemo5("YourBatman5"); }catch (Exception e) {e.printStackTrace();}
//        System.err.println(" ------------------------- ");

        try { client.encoderDemo6(new Person()); }catch (Exception e) {e.printStackTrace();}
        System.err.println(" ------------------------- ");

        try { client.encoderDemo7(new Person()); }catch (Exception e) {e.printStackTrace();}
    }
}
 interface EncoderClient {

    // 1、都标注有@Param注解，并且并且并且都被模版使用了
    @RequestLine("POST /{name}/{age}")
    String encoderDemo1(@Param("name") String name, @Param("age") Integer age);

    // 2、都标注有@Param注解，但模版只使用一个
    @RequestLine("POST /{name}")
    String encoderDemo2(@Param("name") String name, @Param("age") Integer age);

    // 3、都标注有@Param注解，但模版都没有使用
    @RequestLine("POST /")
    String encoderDemo3(@Param("name") String name, @Param("age") Integer age);

    // 4、不标注@Pram注解，是String类型
    @RequestLine("POST /")
    String encoderDemo4(String name);

    // 5、不标注@Pram注解，是Object类型，但实际传String类型
    @RequestLine("POST /")
    String encoderDemo5(Object name);

    // 6、不标注@Pram注解，是POJO
    @RequestLine("POST /")
    String encoderDemo6(Person person);

    // 6、标注@Pram注解，是POJO
    @RequestLine("POST /")
    String encoderDemo7(@Param("person") Person person);

}