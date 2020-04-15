import com.luisenricke.repository.HibernateSpeakerRepositoryImp;
import com.luisenricke.repository.SpeakerRepository;
import com.luisenricke.service.SpeakerService;
import com.luisenricke.service.SpeakerServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "speakerService")
    public SpeakerService getSpeakerService() {
        SpeakerServiceImp service = new SpeakerServiceImp();
        service.setRepository(getSpeakerRepository());
        return service;
    }

    @Bean(name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository() {
        return new HibernateSpeakerRepositoryImp();
    }
}
