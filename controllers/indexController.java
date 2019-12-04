package controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.EcommerceBackendSpring.dao.ProductDao;
import com.niit.EcommerceBackendSpring.dao.UserDao;
import com.niit.EcommerceBackendSpring.model.Category;
import com.niit.EcommerceBackendSpring.model.Product;

import bill.calculate;

@Controller
public class indexController {
	
	
		@Autowired 
		Calculate calculate;
		
		@Autowired
		Appliances app;
		
		
		
		@RequestMapping(value="/index")
		public String showIndexPage(Model m,HttpSession session)
		{
			m.addAttribute("pageinfo", "Appliances");
			List<Appliances> listApp=Calculate.listApp();
			m.addAttribute("index", listApp);
			
			return "index";
		}
		
		@RequestMapping("AddReading")
		public ModelAndView addProcts(@ModelAttribute("appliances") Appliances app) {

			ModelAndView mv = new ModelAndView("addReading");

			mv.addObject("app", new Appliances());
			return mv;
		}
		
		@RequestMapping("showallReading")
		public ModelAndView displayAllProList() {
			ModelAndView mv = new ModelAndView("showAllReading");
			List<Appliances> applist = Calculate.listApp();
			mv.addObject("appList",applist);
			System.out.println(applist.size());
			mv.addObject("msg", "Hello world");
			return mv;
		}
		
		@RequestMapping("/saveReading")
		public String addRead(@ModelAttribute("Appliances") Appliances app, final RedirectAttributes redirects) {
			ModelAndView mv = new ModelAndView("addReading");
			return "redirect:/showallReading";
		}
		
		@RequestMapping("/deleteApp")
		public String deleteApp(@RequestParam(value = "Id", required = true) int Id,
				final RedirectAttributes redirects) {
			ModelAndView mv = new ModelAndView("showallReading");
			Appliances app = Calculate.getApp(Id);
			Calculate.deleteApp(app);
			return "redirect:/showallReading";	}

}
