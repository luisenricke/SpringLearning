import com.luisenricke.service.SpeakerService;
import com.luisenricke.service.SpeakerServiceImp;

public class Application {
    public static void main(String[] args) {
        SpeakerService service = new SpeakerServiceImp();
        System.out.println(service.findAll().get(0).getFirstName());
    }
}
