package universalcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "config")
@ComponentScan(basePackages = "controllers")
public class UniversalCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversalCalculatorApplication.class, args);
	}

}
