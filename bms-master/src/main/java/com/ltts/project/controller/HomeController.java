package com.ltts.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ltts.project.Dao.BookingDao;
import com.ltts.project.Dao.CheckoutDao;
import com.ltts.project.Dao.MemberDao;
import com.ltts.project.Dao.MovieDao;
import com.ltts.project.model.Booking;
import com.ltts.project.model.Checkout;
import com.ltts.project.model.Member;
import com.ltts.project.model.Movie;

import com.ltts.project.model.Screen;




@RestController

@SessionAttributes({"mid"})
public class HomeController {

	
	@Autowired
	MemberDao md;
	
	@Autowired
	MovieDao mod;
	
	@Autowired
	BookingDao bod;
	
	@Autowired
	CheckoutDao cod;
	
	
	@RequestMapping("")
	public ModelAndView secondMethod() {
		return new ModelAndView("index");
	}
	
	
	/*
	 * @GetMapping(value = "") public String secondMethod() {
	 * 
	 * return "index-4"; }
	 */
	@RequestMapping("/registration")
	public ModelAndView registerUser() {
		return new ModelAndView("registration");
	}
	
	
	@RequestMapping("/login")
	public ModelAndView loginuser() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("/addbook")
	public ModelAndView book(HttpServletRequest req, Model m,HttpSession httpSession) {
		
		//int rem= (int) httpSession.getAttribute("rs");
	//	m.addAttribute("remseats",rem);
		return new ModelAndView("booking");
		 
	}
	
	@RequestMapping(value="/complete", method=RequestMethod.POST)
	public ModelAndView addcheck(HttpServletRequest req, Model model) {
		ModelAndView mv=null;
		String FName=req.getParameter("firstname");
		String Email=req.getParameter("email");
		String UName=req.getParameter("address");
		String city=req.getParameter("city");
		int Zip = Integer.parseInt(req.getParameter("zip"));
		String Cname=req.getParameter("cardname");
		int Cnumber = Integer.parseInt(req.getParameter("cardnumber"));
		int month = Integer.parseInt(req.getParameter("expmonth"));
		int year = Integer.parseInt(req.getParameter("expyear"));
		int CVV = Integer.parseInt(req.getParameter("cvv"));
		String Total =req.getParameter("total");
	//	ApplicationContext ac=new ClassPathXmlApplicationContext();
		Checkout m=new Checkout(FName,Email,UName,city,Zip,Cname,Cnumber,month,year,CVV,Total);
		System.out.println("***** INSIDE CONTROLLER ****"+m);
		boolean b=cod.InsertCheck(m);
		
		if(b==false) {
			mv=new ModelAndView("invoice");
			model.addAttribute("message","Movie Addes Successfully");
		}
		else {
			String message = "New user created successfully";
			mv=new ModelAndView("checkout");
			model.addAttribute("msg",message );
			
		}
		return mv;
	}
	@RequestMapping(value="adduser", method=RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest req, Model model) {
		ModelAndView mv=null;
		String name=req.getParameter("uname");
		String pass=req.getParameter("pass");
		String email=req.getParameter("email");
		
		
		
		String mobile=req.getParameter("mobile");
		
	//	ApplicationContext ac=new ClassPathXmlApplicationContext();
		Member m=new Member(name,pass,email,mobile);
		System.out.println("***** INSIDE CONTROLLER ****"+m);
		boolean b=md.InsertMember(m);
		
		if(b==false) {
			mv=new ModelAndView("login");
			model.addAttribute("");
		}
		else {
			String message = "New user created successfully";
			mv=new ModelAndView("error");
			model.addAttribute("msg",message );
			
		}
		/*
		 * try { b=md.InsertMember(m); mv=new ModelAndView("success"); } catch(Exception
		 * e) {
		 * 
		 * mv=new ModelAndView("error"); }
		 */
		
		
		return mv;
	}
	

	
	@RequestMapping(value="/addbooking", method=RequestMethod.POST )
	public ModelAndView booking(HttpServletRequest req, Model model,HttpSession httpSession) {
		ModelAndView mv=null;
		//int bid=Integer.parseInt(req.getParameter("Bid"));
		
		
		int miid= (int) httpSession.getAttribute("mid");
		
		
		
		int bseats=Integer.parseInt(req.getParameter("bseats"));
		
		 int TotalSeats = 300;
			
	    int remainingSeats = TotalSeats-bseats;
	    
		httpSession.setAttribute("rs", remainingSeats);
	     
	    
		//model.addAttribute("rs", remainingSeats);-
		
		String date = req.getParameter("date");
		String time = req.getParameter("time");
	
		
		 
		  Movie m = (Movie) mod.getMovieByID(miid); 
		  
		  double p= m.getPrice();
		  String name=m.getMovieName();
		  
		  
		  
		  double pr= p*bseats;
		  
		  System.out.println(pr);
		  
		  
		  
		  //int tprice=Integer.parseInt(req.getParameter("price"));
		 // model.addAttribute("tprice", pr);
		 
		
		//  Movie mid = new Movie();
		 // mid.setMovieId(Integer.parseInt(req.getParameter("mid")));
		  
		  
		  
		 // Screen sc = new Screen();
		 // sc.setScreenId(Integer.parseInt(req.getParameter("sid")));
		  
		 // Member m = new Member(); m.setEmail(req.getParameter("uid"));
		  
		  
		  
		 
//		Screen sid=Integer.parseInt(req.getParameter("sid"));
//		Member uid=req.getParameter("uid");
		
	//	ApplicationContext ac=new ClassPathXmlApplicationContext();
		
		Booking book=new Booking(0,miid,bseats,date,time,remainingSeats,null,null,null);
		System.out.println("***** INSIDE CONTROLLER ****"+book);
		boolean b=bod.InsertBooking(book);
		
		if(b==false) {
			mv=new ModelAndView("checkout");
			model.addAttribute("tp", pr);
			model.addAttribute("name", name);
			model.addAttribute("seats", bseats);
			model.addAttribute("p", p);
			
			
			
			
			//model.addAttribute("tprice", p);
		}
		else {
			String message = "booking done";
			//mv=new ModelAndView("login");
			model.addAttribute("msg",message );
			
		}
		/*
		 * try { b=md.InsertMember(m); mv=new ModelAndView("success"); } catch(Exception
		 * e) {
		 * 
		 * mv=new ModelAndView("error"); }
		 */
		
		
		return mv;
	}


	
	@RequestMapping(value="checkuser", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req, Model model,HttpSession httpSession ) {
		ModelAndView mv=null;
		
		
		
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		Member m =md.checkMember(email);
	//	Movie mov= mod.getAllMovies()
        List<Movie> li =mod.getAllMovies();
		
		model.addAttribute("list", li);
		
		//return mv;
	
		
		
		if(m.getPassword().equals(pass)){
			model.addAttribute("name",m.getUserName());
			
			httpSession.setAttribute("email", m.getEmail());
			mv=new ModelAndView("addMovie");
			 //List<Movie> li =mod.getAllMovies();
				
			
				model.addAttribute("list", li);
				
				//return mv;
			
			
		}
			else {
				mv=new ModelAndView("error");
				model.addAttribute("msg", "Incorrect credentials");
				
			}
		
		return mv;
			
		}
	@GetMapping("/viewMovies")
	public List<Movie> viewAllMovies() {
		//ModelAndView mv=new ModelAndView("viewplayers");
		List<Movie> li=mod.getAllMovies();
		
		//model.addAttribute("list", li);
		
		return li;
}
		
	 @PostMapping("/invalidate")
	    public ModelAndView destroySession(HttpServletRequest request) {
		 ModelAndView mv=null;
	        //invalidate the session , this will clear the data from configured database (Mysql/redis/hazelcast)
	        request.getSession().invalidate();
	    	mv=new ModelAndView("index");
	    	return mv;
	    }
	
}
