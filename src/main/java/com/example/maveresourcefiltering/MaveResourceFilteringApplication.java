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

	@Value("${proyecto.version}")
	private String versionProyecto;

	@Value("${mi.property.copada}")
	private String miPropertyCustom;

	@Value("${mi-variable-entorno-path}")
	private String miVariableDeEntornoPath;

	@Value("${mi.property.via.settings}")
	private String miPropertyViaSettings;

	@Value("${mi.property.via.args}")
	private String miPropertyViaArgs;

	@Value("#{systemProperties['guru.config.path']}") // Estilo Java: Es lo mismo que directamente usar la clase System.getProperty("property1")
	private String guruConfigPath;

	@Value("#{environment.GURU_LOGIN}") // Estilo Java: Es lo mismo que directamente usar la clase System.getenv("ENV_VAR")
	private String guruLogin;

	public static void main(String[] args) {
		SpringApplication.run(MaveResourceFilteringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Recordando que toda property que referencies sea de pom.xml/settings el delimiter es @property1@ en appplication.properties

		// pom.xml(inbuild pom property) -> application.properties -> @Value
		System.out.println(versionProyecto);

		// pom.xml(custom property via <properties>) -> application.properties -> @Value
		System.out.println(miPropertyCustom);

		// pom.xml(custom property via <properties> usando en pom ${env.VAR}) -> application.properties -> @Value
		System.out.println(miVariableDeEntornoPath);

		// settings.xml(custom property via <properties>) -> application.properties -> @Value
		System.out.println(miPropertyViaSettings);

		// "mvn clean install -Dmi.property.via.args=Holanda" -> @Value
		System.out.println(miPropertyViaArgs);

		// application.properties (app.config....) -> @ConfigurationProperties(prefix = "app.config"))
		System.out.println(guruConfigProperties.getHilos());
		System.out.println(guruConfigProperties.getMesesAtras());
		System.out.println(guruConfigProperties.getPathArchivos());

		// application.properties (env.target=${ENV_TARGET}) -> @PropertySource("classpath:env/config-${env.target}.properties")
		System.out.println(envConfigProperties.getUrl());

		// System Property en spring-boot-maven-plugin <configuration> en pom.xml -> @Value("#{systemProperties['guru.config.path']}")
		System.out.println(guruConfigPath);

		// Variable Entorno en spring-boot-maven-plugin <configuration> en pom.xml -> @Value("#{environment.GURU_LOGIN}")
		System.out.println(guruLogin);
	}
}
