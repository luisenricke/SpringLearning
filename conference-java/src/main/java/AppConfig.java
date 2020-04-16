import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.luisenricke"})
public class AppConfig {

    /*
    @Bean(name = "speakerService")
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    //@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public SpeakerService getSpeakerService() {
        //SpeakerServiceImp service = new SpeakerServiceImp(getSpeakerRepository());
        //service.setRepository(getSpeakerRepository());
        SpeakerServiceImp service = new SpeakerServiceImp();
        return service;
    }

    @Bean(name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository() {
        return new HibernateSpeakerRepositoryImp();
    }
    */
}
