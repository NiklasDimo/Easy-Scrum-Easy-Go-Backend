package com.example.ESEG;

import com.example.ESEG.model.*;
import com.example.ESEG.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EsegApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsegApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(DetailsRepository detailsRepository, ProductRepository repository, ImpressumRepository impressumRepository, UserRepository userRepository, AddressRepository addressRepository) {
		return args -> {
			//add some data
			//add Product
			impressumRepository.save(new Impressum(null, "Easy Scrum Easy Go", "Beethovenstraße 1", "73430 Aalen", "Telefon: +49 7361 576-0", "Telefax: +49 7361 576-2250", "E-Mail: info@hs-aalen.de"));
			repository.save(new Product("Playstation 5", "€", 10.50, "Von Haus aus steckt in der PS5 eine SSD-Festplatte mit 825 Gigabyte Speicher. Sollte euch das nicht reichen, könnt ihr die Konsole per NVMe SSD Slot durch eine weitere Festplatte erweitern.", "Konsole"));
			repository.save(new Product("Nintendo Switch", "$", 5.99, "Das neue Modell ist in etwa so breit und so hoch wie die Nintendo Switch-Konsole, besitzt aber einen größeren 7-Zoll-OLED-Bildschirm mit intensiver Farbdarstellung und hohem Kontrast.",  "Konsole"));
			userRepository.save(new User( "admin", "password", "Admin", "0", "Hans","Müller"));
			userRepository.save(new User( "user1", "1", "Standard Customer", "0", "Mahir", "Berkcan"));
			userRepository.save(new User( "user2", "1", "Premium Customer", "10", "Tim", "Grunwald"));
			addressRepository.save(new Address(4L,"Dr.",  "Grau", "Peter", "Hohenbacher Strasse", 34, 73261, "Karlsruhe"));
			detailsRepository.save(new Details(2L, "Maße", "10x5x20 cm", "Playstation 5"));
			detailsRepository.save(new Details(2L, "Farbe", "violett", "Playstation 5"));
			detailsRepository.save(new Details(3L, "Gewicht", "2 Tonnen", "Nintendo Switch"));
		};
	}
}
