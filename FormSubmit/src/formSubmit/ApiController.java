package formSubmit;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;

@RestController
public class ApiController {
	
	
	Content contentJson = new Content();
	
	private AtomicLong nextID = new AtomicLong();	
	private List<Content> ct  = new ArrayList<>();

	@GetMapping("/hello")
	public String getHelloMessage()
	{
		return "hello";
	}
	
	@GetMapping("/getjson")
	public Content getJson()
	{
		return contentJson;
	}
	
	@PostMapping("/pledges")
	public Content createX(@RequestBody Content pl)
	{
		//Set content to have next ID
		pl.setId(nextID.incrementAndGet());
		ct.add(pl);
		return pl;	 
	}
	
}
