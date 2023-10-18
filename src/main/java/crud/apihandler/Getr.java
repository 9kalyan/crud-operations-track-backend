package crud.apihandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Getr {
    @RequestMapping("/")
    public static  int ram(){
        return 9;
    }
    @RequestMapping("/k")
    public String ra(@RequestParam String name){
        return name;
    }
}
