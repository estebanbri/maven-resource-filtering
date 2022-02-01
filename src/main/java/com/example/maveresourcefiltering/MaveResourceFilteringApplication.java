package com.example.maveresourcefiltering;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaveResourceFilteringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MaveResourceFilteringApplication.class, args);
	}

	@Value("${proyecto.nombre}")
	private String nombreProyecto;

	@Value("${proyecto.version}")
	private String versionProyecto;

	@Value("${mi.property.copada}")
	private String miPropertyCustom;

	@Value("${mi.property.via.args:not_found}")
	private String miPropertyViaArgs;

	@Value("${mi.property.via.settings:not_found}")
	private String miPropertyViaSettings;


	@Override
	public void run(String... args) throws Exception {
		System.out.println(nombreProyecto);
		System.out.println(versionProyecto);
		System.out.println(miPropertyCustom);
		System.out.println(miPropertyViaArgs);
		System.out.println(miPropertyViaSettings);
	}
}
