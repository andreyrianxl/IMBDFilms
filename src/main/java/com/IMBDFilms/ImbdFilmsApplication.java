package com.IMBDFilms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.IMBDFilms.application.MenuPrincipal;

@SpringBootApplication
public class ImbdFilmsApplication implements CommandLineRunner{
	@Autowired
	private MenuPrincipal menuPrincipal;

	public static void main(String[] args) {
		SpringApplication.run(ImbdFilmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		menuPrincipal.exibeMenuPrincipal();
	}
}
