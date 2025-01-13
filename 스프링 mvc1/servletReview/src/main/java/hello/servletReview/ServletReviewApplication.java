package hello.servletReview;

import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ServletReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletReviewApplication.class, args);
	}

}
