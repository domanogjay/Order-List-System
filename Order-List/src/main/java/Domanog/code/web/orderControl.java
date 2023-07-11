package Domanog.code.web;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.JavaInfo.JavaRuntimeEnvironmentInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Domanog.code.model.Order;
import Domanog.code.model.OrderHistory;
import Domanog.code.model.repositoryUser.OrderHistoryRepo;
import Domanog.code.model.repositoryUser.orderRepo;



@Controller
public class orderControl {
	
	@Autowired
	private orderRepo ordRepo;
	
	@Autowired
	private  OrderHistoryRepo historyRepo;
	
	@GetMapping("/")
	public ModelAndView displayList() {
		ModelAndView mav = new ModelAndView("display-order");
		List<Order> list = ordRepo.findAll();
		mav.addObject("order", list);
		return mav;
		}
	
	@GetMapping("/add-order")
	public ModelAndView addOrder() {
		ModelAndView mav = new ModelAndView("add-order");
		Order newOrder = new Order();
		mav.addObject("order", newOrder);
		return mav;
	}
	
	@PostMapping("/save-order")  
	public String saveOrder(Model model, @ModelAttribute Order order, @ModelAttribute OrderHistory orderHistory) {	
		ordRepo.save(order);
		historyRepo.save(orderHistory);
		System.out.println("Saved success ");
		return "redirect:/";
	}
	
//	@PostMapping("/save-order")  
//	public String saveHistoryOrder(Model model, @ModelAttribute OrderHistory order) {	
//		historyRepo.save(order);
//		return "redirect:/";
//	}
	
//	@GetMapping("/display-form")
//	public ModelAndView displayForm(@RequestParam Long orderId) {
//		ModelAndView mav = new ModelAndView("add-order");
//		Order order = ordRepo.findById(orderId).get();
//		mav.addObject("order", order);
//		return mav;
//	}
	@GetMapping("/delete-order")
	public String deleteOrder(@RequestParam Long orderId) {
		ordRepo.deleteById(orderId);
		return "redirect:/";
	}
	
	@GetMapping("/cancel-order")
	public String cancelOrder(@RequestParam Long orderId) {
		ordRepo.deleteById(orderId);
		historyRepo.deleteById(orderId);
		return "redirect:/";
	}
	
//	@GetMapping("/order-status")
//	public String orderStatus(@RequestParam Long orderId) {
//		if(ordRepo.findById(orderId) == null)
//			return	"true";
//		return "redirect:/";
//	
//	}
	
	
	@GetMapping("/login")
	public String login() {
		return"login";
	}
	
	@GetMapping("/order-history")
	public ModelAndView displayHistory() {
		ModelAndView mav = new ModelAndView("/order-history");
		List<OrderHistory> list = historyRepo.findAll();
		mav.addObject("order", list);
		return mav;
		}
	
}
