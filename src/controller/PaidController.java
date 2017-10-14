
package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import Pojo.Houselist;
import Pojo.Paid;
import Pojo.QueryVo;
import Pojo.Topaid;
import Pojo.User;
import Pojo.Userlist;
import Pojo.Zulist;
import service.PaidService;
import service.TopaidService;
import service.UserlistService;
import java.text.SimpleDateFormat;
import java.util.Date;;

@Controller
@RequestMapping("/paid")
public class PaidController {
	@Autowired
	private PaidService paidService;
	@Autowired
	private TopaidService topaidService;
	@Autowired
	private UserlistService userlistService;
	//管理员查找所有已缴租金列表
	@RequestMapping("/selectall")
	public String selectall(Model model,QueryVo vo,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="2") Integer pageSize){
		PageHelper.startPage(page, pageSize);
		List<Paid> list=paidService.selectall(vo);
		PageInfo<Paid> p=new PageInfo<Paid>(list);
		Double sum=paidService.selectsum(vo);
		model.addAttribute("paid", list);
		model.addAttribute("sum", sum);
		model.addAttribute("p", p);
		model.addAttribute("mainPage", "paid.jsp");
		model.addAttribute("vo", vo);
		return "admin/main1";
	}
	//租客查找自己已缴租金列表
		@RequestMapping("/findmypaid")
		public String findmypaid(HttpSession httpSession,Model model,QueryVo vo,@RequestParam(required=false,defaultValue="1") Integer page,
	            @RequestParam(required=false,defaultValue="2") Integer pageSize){
			User user1= (User) httpSession.getAttribute("user");
			Userlist userlist=userlistService.findhasuserlist(user1.getId());
			
			vo.setUserlist_id(userlist.getId());
			PageHelper.startPage(page, pageSize);
			List<Paid> list=paidService.selectall(vo);
			PageInfo<Paid> p=new PageInfo<Paid>(list);
			Double sum=paidService.selectsum(vo);
			model.addAttribute("paid", list);
			model.addAttribute("sum", sum);
			model.addAttribute("p", p);
			model.addAttribute("mainPage", "mypaid.jsp");
			model.addAttribute("vo", vo);
			return "zuke/main";
		}
	//管理员删除已缴租金记录
	@RequestMapping("/deletepaid")
	public String deletepaid(Integer id){
		paidService.deletepaid(id);
		return "redirect:selectall.action";
	}
	//zuke删除已缴租金记录
		@RequestMapping("/zukedeletepaid")
		public String zukedeletepaid(Integer id){
			paidService.deletepaid(id);
			return "redirect:findmypaid.action";
		}
	//跳到我要收租页面
	@RequestMapping("/showaddpaid")
	public String showaddpaid(Model model,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="2") Integer pageSize)throws Exception{
		PageHelper.startPage(page, pageSize);
		List<Zulist> list=paidService.findzuuserlist();
		PageInfo<Zulist> p=new PageInfo<Zulist>(list);
		model.addAttribute("zulist", list);
		model.addAttribute("p", p);
		model.addAttribute("mainPage", "showaddpaid.jsp");
		return "admin/main1";
	}
	//点击收租后跳转到添加租金信息页面
	@RequestMapping("/addpaid")
	public String addpaid(Integer id,Model model){
		Zulist zulist=paidService.findzukezulist(id);
		model.addAttribute("zulist", zulist);
		model.addAttribute("mainPage", "addpaid.jsp");
		return "admin/main1";
	}
	//添加租金信息到topaid表
		@RequestMapping("/inserttopaid")
		public String inserttopaid(Topaid topaid,Model model){
			topaidService.inserttopaid(topaid);
			model.addAttribute("error","inserttopaid");
			
			return "redirect:showaddpaid.action";
		}
		//管理员查看所有未缴租金信息
		@RequestMapping("/topaidlist")
		public String topaidlist(Model model,@RequestParam(required=false,defaultValue="1") Integer page,
	            @RequestParam(required=false,defaultValue="2") Integer pageSize){
			QueryVo vo=new QueryVo();
			PageHelper.startPage(page, pageSize);
			List<Topaid> list=topaidService.findtopaid(vo);
			PageInfo<Topaid> p=new PageInfo<Topaid>(list);
			model.addAttribute("topaid", list);
			model.addAttribute("p", p);
			model.addAttribute("mainPage", "topaid.jsp");
			return "admin/main1";
		}
		//租客查看自己的未缴租金
		@RequestMapping("/mytopaidlist")
		public String mytopaidlist(Model model,HttpSession httpSession,@RequestParam(required=false,defaultValue="1") Integer page,
	            @RequestParam(required=false,defaultValue="2") Integer pageSize){
			User user1= (User) httpSession.getAttribute("user");
			Userlist userlist=userlistService.findhasuserlist(user1.getId());
			QueryVo vo=new QueryVo();
			vo.setUserlist_id(userlist.getId());
			PageHelper.startPage(page, pageSize);
			List<Topaid> topaid=topaidService.findtopaid(vo);
			PageInfo<Topaid> p=new PageInfo<Topaid>(topaid);
			model.addAttribute("p", p);
			model.addAttribute("topaid",topaid);
			model.addAttribute("mainPage", "mytopaid.jsp");
			return "zuke/main";
		}
		//租客进行支付操作
		@RequestMapping("/gotopay")
		public String gotopay(Integer id,Model model){
			Date dt=new Date();
		    SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
		    String paydate=matter1.format(dt);
			Topaid topaid=topaidService.findbyid(id);
			Paid paid=new Paid();
			paid.setHouse_id(topaid.getHouse_id());
			paid.setAddress(topaid.getAddress());
			paid.setPrice(topaid.getPrice());
			paid.setDate(topaid.getDate());
			paid.setPaydate(paydate);
			paid.setName(topaid.getName());
			paid.setUserlist_id(topaid.getUserlist_id());
			paid.setStatus("租金已缴");
			topaidService.gotopay(id, paid);
			model.addAttribute("error", "paysucess");
			return "redirect:findmypaid.action";
		}
}
