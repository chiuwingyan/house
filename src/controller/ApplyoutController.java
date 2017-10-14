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

import Pojo.Applyout;
import Pojo.Houselist;
import Pojo.User;
import Pojo.Userlist;
import Pojo.Zulist;
import service.ApplyoutService;
import service.UserlistService;
import service.ZulistService;

@Controller
@RequestMapping("/applyout")
public class ApplyoutController {
	@Autowired
	private ZulistService zulistService;
	@Autowired
	private ApplyoutService applyoutService;
	@Autowired
	private UserlistService userlistService;
	//插入退租信息
	@RequestMapping("/insertapplyout")
	public String insertapplyout(String house_id,Model model){
		Zulist zulist=zulistService.findzulist(house_id);
		applyoutService.insertapplyout(zulist);
		model.addAttribute("error", "applysuccess");
		return "redirect:/zulist/myzulist.action";
	}
	//查看退租申请
	@RequestMapping("/findallapplyout")
	public String findallapplyout(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="2") Integer pageSize){
		PageHelper.startPage(page, pageSize);
		List<Applyout> applyout=applyoutService.findallapplyout();
		PageInfo<Applyout> p=new PageInfo<Applyout>(applyout);
		model.addAttribute("applyout", applyout);
		model.addAttribute("p", p);
		model.addAttribute("mainPage", "applyout.jsp");
		return "admin/main1";
	}
	//管理员拒绝退租申请
	@RequestMapping("/refuseapplyout")
	public String refuseapplyout(Model model,Integer id){
		Applyout applyout=new Applyout();
		applyout.setId(id);
		applyout.setStatus("已拒绝");
		applyoutService.updateapplyout(applyout);
		model.addAttribute("mainPage", "applyout.jsp");
		return "redirect:findallapplyout.action";
	}
	//管理员同意退租申请
	@RequestMapping("/agreeapplyout")
	public String agreeapplyout(Model model,Integer id){
		applyoutService.agreeapplyout(id);
		model.addAttribute("error", "applyoutsucess");
		return "redirect:findallapplyout.action";
	}
	//删除申请退租列表
		@RequestMapping("/deleteapplyout")
		public String deleteapplyout(Model model,Integer id){
			applyoutService.deleteapplyout(id);
			model.addAttribute("error", "deletesucess");
			return "redirect:findallapplyout.action";
		}
		//租客查看自己的 退房申请
		@RequestMapping("/getmyapplyout")
		public String getmyapplyout(Model model,HttpSession httpSession,@RequestParam(required=false,defaultValue="1") Integer page,
	            @RequestParam(required=false,defaultValue="2") Integer pageSize){
			User user1= (User) httpSession.getAttribute("user");
			Userlist userlist=userlistService.findhasuserlist(user1.getId());
			PageHelper.startPage(page, pageSize);
			List<Userlist> list=userlistService.getmyapplyout(userlist.getId());
			PageInfo<Userlist> p=new PageInfo<Userlist>(list);
			model.addAttribute("userlist", list);
			model.addAttribute("p", p);
			model.addAttribute("mainPage", "myapplyout.jsp");
			return "zuke/main";
		}
}
