import com.luisenricke.service.SpeakerService;
import com.luisenricke.service.SpeakerServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "speakerService")
    public SpeakerService getSpeakerService(){
        return new SpeakerServiceImp();
    }
}
