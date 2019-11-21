package com.bhhc.myapp;

import com.bhhc.myapp.model.Reason;
import com.bhhc.myapp.repository.ReasonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyappApplication {

	private static final Logger log = LoggerFactory.getLogger(MyappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ReasonRepository repository) {
		return (args) -> {
			// save the reasons for BHHC
			repository.save(new Reason("BHHC is a well-established company with a long history of providing excellent customer service.", "bhhc"));
			repository.save(new Reason("I've enjoyed speaking with all of the team members.", "bhhc"));
			repository.save(new Reason("There is an opportunity to use cutting edge technology to lead the company into the future.", "bhhc"));
			repository.save(new Reason("I'm excited for the opportunity to learn .NET technologies.", "bhhc"));

			log.info("Saved reasons for BHHC");

			// fetch all reasons
			log.info("Reasons found for company BHHC");
			log.info("-------------------------------");
			for (Reason reason : repository.findByCompany("bhhc")) {
				log.info(reason.toString());
			}
		};
	}

}
