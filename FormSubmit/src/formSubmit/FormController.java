package formSubmit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
	
	
	@RequestMapping("/")
	public String showInit()
	{
		System.out.println("hello");
		return "HomePage";
	}
	
	@RequestMapping("showForm")
	public String showForm(Model theModel)
	{
		theModel.addAttribute("formentry", new FormEntry());
		
		return "FormPage";
//		return "ïndex";
	}
	
	@RequestMapping("formsubmit")
	public String processForm(@ModelAttribute("formentry") FormEntry formentry)
	{
//		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(FormEntry.class).buildSessionFactory();
		
//		Session session = sf.getCurrentSession();
		
//		try
//		{
//			session.beginTransaction();
//			session.save(formentry);
//			session.getTransaction().commit();
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			sf.close();
//		}
		
		return "Confirmation";
	}
	
	
}
