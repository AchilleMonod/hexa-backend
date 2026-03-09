package vbm.common;

@SpringBootApplication(
        scanBasePackages = {
                "vbm.common"
        })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
