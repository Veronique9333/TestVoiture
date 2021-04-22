package test.java.voiture.commentaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import test.java.voiture.commentaire.services.UtilisateurService;
import test.java.voiture.commentaire.services.VoitureService;

import java.util.Collections;

@SpringBootApplication
public class CommentaireApplication implements CommandLineRunner {

    private final VoitureService voitureService;
    private final UtilisateurService utilisateurService;

    @Autowired
    public CommentaireApplication(VoitureService voitureService,
                                  UtilisateurService utilisateurService) {
        this.voitureService = voitureService;
        this.utilisateurService = utilisateurService;
    }

    public static void main(String[] args) {
        SpringApplication.run (CommentaireApplication.class, args);
    }

    /*@Bean
    public FilterRegistrationBean filterRegistration(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        source.registerCorsConfiguration("/**",configuration);
        FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter (source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }*/

    @Override
    public void run(String... args) {
        if (!utilisateurService.checkExistUser()){
           utilisateurService.initUser();
        }
        if (!voitureService.checkExistVoiture()){
            voitureService.initVoiture();
        }

    }

}
