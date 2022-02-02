package com.example.maveresourcefiltering;

import com.example.maveresourcefiltering.config.EnvConfigProperties;
import com.example.maveresourcefiltering.config.GuruConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaveResourceFilteringApplication implements CommandLineRunner {

	@Autowired
	private GuruConfigProperties guruConfigProperties;

	@Autowired
	private EnvConfigProperties envConfigProperties;

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

	@Value("${mi-variable-entorno-path}")
	private String miVariableDeEntornoPath;

	public static void main(String[] args) {
		SpringApplication.run(MaveResourceFilteringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(nombreProyecto);
		System.out.println(versionProyecto);
		System.out.println(miPropertyCustom);
		System.out.println(miPropertyViaArgs);
		System.out.println(miPropertyViaSettings);
		System.out.println(miVariableDeEntornoPath);
		System.out.println(guruConfigProperties.getHilos());
		System.out.println(guruConfigProperties.getMesesAtras());
		System.out.println(guruConfigProperties.getPathArchivos());
		System.out.println(envConfigProperties.getUrl());
	}
}
