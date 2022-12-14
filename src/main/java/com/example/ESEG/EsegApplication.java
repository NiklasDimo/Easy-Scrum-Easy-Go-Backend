package com.example.ESEG;

import com.example.ESEG.model.Address;
import com.example.ESEG.model.Impressum;
import com.example.ESEG.model.Product;
import com.example.ESEG.model.User;
import com.example.ESEG.repository.AddressRepository;
import com.example.ESEG.repository.ImpressumRepository;
import com.example.ESEG.repository.ProductRepository;
import com.example.ESEG.repository.UserRepository;
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
	CommandLineRunner commandLineRunner(ProductRepository repository, ImpressumRepository impressumRepository, UserRepository userRepository, AddressRepository addressRepository) {
		return args -> {
			//add some data
			//add Product
			impressumRepository.save(new Impressum(null, "Easy Scrum Easy Go", "Beethovenstraße 1", "73430 Aalen", "Telefon: +49 7361 576-0", "Telefax: +49 7361 576-2250", "E-Mail: info@hs-aalen.de"));
			repository.save(new Product("Playstation 5", "€ EUR", 10.50, "Von Haus aus steckt in der PS5 eine SSD-Festplatte mit 825 Gigabyte Speicher. Sollte euch das nicht reichen, könnt ihr die Konsole per NVMe SSD Slot durch eine weitere Festplatte erweitern.", "Maße: 10x20", "Konsole"));
			repository.save(new Product("Nintendo Switch", "€ EUR", 5.99, "Das neue Modell ist in etwa so breit und so hoch wie die Nintendo Switch-Konsole, besitzt aber einen größeren 7-Zoll-OLED-Bildschirm mit intensiver Farbdarstellung und hohem Kontrast.", "Maße: 10x20 : Gewicht: 10kg", "Konsole"));
			userRepository.save(new User( "admin", "password", "Admin", "0"/*, "Hans","Müller"*/));
			userRepository.save(new User( "user1", "1", "Standard Customer", "0"/*, "Mahir", "Berkcan"*/));
			userRepository.save(new User( "user2", "1", "Premium Customer", "10"/*, "Tim", "Grunwald"*/));
			addressRepository.save(new Address(4L,"Dr.",  "Grau", "Peter", "Hohenbacher Strasse", 34, 73261, "Karlsruhe"));
		};
	}
}
