package controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import Pojo.Paid;
import Pojo.QueryVo;
import Pojo.Solve;
import Pojo.Topaid;
import Pojo.User;
import Pojo.Userlist;
import Pojo.Wrong;
import Pojo.Zulist;
import service.PaidService;
import service.SolveService;
import service.UserlistService;
import service.ZulistService;

@Controller
@RequestMapping("/wrong")
public class WrongController {
  @Autowired
  private SolveService solveService;
  @Autowired
  private UserlistService userlistService;
  @Autowired
  private PaidService paidService;
  @Autowired
  private ZulistService zulistService;
  //管理员查找所有已处理的报障
  @RequestMapping("/selectall")
  public String selectall(Model model,QueryVo vo,@RequestParam(required=false,defaultValue="1") Integer page,
          @RequestParam(required=false,defaultValue="2") Integer pageSize){
		PageHelper.startPage(page, pageSize);
		List<Solve> list=solveService.selectall(vo);
		PageInfo<Solve> p=new PageInfo<Solve>(list);
		Integer count=solveService.selectcount(vo);
		model.addAttribute("solve", list);
		model.addAttribute("count", count);
		model.addAttribute("p", p);
		model.addAttribute("mainPage", "solve.jsp");
		model.addAttribute("vo", vo);
		return "admin/main1";
	}
//租客查找自己已处理的报障
		@RequestMapping("/findmysolve")
		public String findmysolve(HttpSession httpSession,Model model,QueryVo vo,@RequestParam(required=false,defaultValue="1") Integer page,
	            @RequestParam(required=false,defaultValue="2") Integer pageSize){
			User user1= (User) httpSession.getAttribute("user");
			Userlist userlist=userlistService.findhasuserlist(user1.getId());
			
			vo.setUserlist_id(userlist.getId());
			PageHelper.startPage(page, pageSize);
			List<Solve> list=solveService.selectall(vo);
			PageInfo<Solve> p=new PageInfo<Solve>(list);
			Integer count=solveService.selectcount(vo);
			model.addAttribute("solve", list);
			model.addAttribute("count", count);
			model.addAttribute("p", p);
			model.addAttribute("mainPage", "mysolve.jsp");
			model.addAttribute("vo", vo);
			return "zuke/main";
		}
		//管理员删除已处理报障记录
		@RequestMapping("/deletesolve")
		public String deletesolve(Integer id){
			solveService.deletesolve(id);
			return "redirect:selectall.action";
		}
		//zuke删除自己的已处理报障记录
			@RequestMapping("/zukedeletesolve")
			public String zukedeletesolve(Integer id){
				solveService.deletesolve(id);
				return "redirect:findmypaid.action";
			}
			//租客跳到我要报障页面
			@RequestMapping("/showaddwrong")
			public String showaddwrong(HttpSession httpSession,Model model,@RequestParam(required=false,defaultValue="1") Integer page,
		            @RequestParam(required=false,defaultValue="2") Integer pageSize)throws Exception{
				User user1= (User) httpSession.getAttribute("user");
				Userlist userlist=userlistService.findhasuserlist(user1.getId());
				PageHelper.startPage(page, pageSize);
				List<Zulist> list=zulistService.findzulistbyuid(userlist.getId());
				PageInfo<Zulist> p=new PageInfo<Zulist>(list);
				model.addAttribute("zulist", list);
				model.addAttribute("p", p);
				model.addAttribute("mainPage", "showaddwrong.jsp");
				return "zuke/main";
			}
			//点击报障后跳转到添加报障信息页面
			@RequestMapping("/addwrong")
			public String addwrong(Integer id,Model model){
				Zulist zulist=paidService.findzukezulist(id);
				model.addAttribute("zulist", zulist);
				model.addAttribute("mainPage", "addwrong.jsp");
				return "zuke/main";
			}
			//添加报障信息到wrong表
			@RequestMapping("/insertwrong")
			public String insertwrong(Wrong wrong,Model model){
				solveService.insertwrong(wrong);
				model.addAttribute("error","insertwrong");
				
				return "redirect:showaddwrong.action";
			}
			//管理员查看所有未处理报障
			@RequestMapping("/wronglist")
			public String wronglist(Model model,@RequestParam(required=false,defaultValue="1") Integer page,
		            @RequestParam(required=false,defaultValue="2") Integer pageSize){
				QueryVo vo=new QueryVo();
				PageHelper.startPage(page, pageSize);
				List<Wrong> list=solveService.findwrong(vo);
				PageInfo<Wrong> p=new PageInfo<Wrong>(list);
				model.addAttribute("wrong", list);
				model.addAttribute("p", p);
				model.addAttribute("mainPage", "wrong.jsp");
				return "admin/main1";
			}
			//租客查看自己的未处理报障
			@RequestMapping("/mywronglist")
			public String mywronglist(Model model,HttpSession httpSession,@RequestParam(required=false,defaultValue="1") Integer page,
		            @RequestParam(required=false,defaultValue="2") Integer pageSize){
				User user1= (User) httpSession.getAttribute("user");
				Userlist userlist=userlistService.findhasuserlist(user1.getId());
				QueryVo vo=new QueryVo();
				vo.setUserlist_id(userlist.getId());
				PageHelper.startPage(page, pageSize);
				List<Wrong> list=solveService.findwrong(vo);
				PageInfo<Wrong> p=new PageInfo<Wrong>(list);
				model.addAttribute("p", p);
				model.addAttribute("wrong",list);
				model.addAttribute("mainPage", "mywrong.jsp");
				return "zuke/main";
			}
			//管理员处理报障
			@RequestMapping("/gotosolve")
			public String gotosolve(Integer id,Model model){
				
				Wrong wrong=solveService.findbyid(id);
				Solve solve=new Solve();
				solve.setHouse_id(wrong.getHouse_id());
				solve.setAddress(wrong.getAddress());
				solve.setDate(wrong.getDate());
				solve.setDetail(wrong.getDetail());
				solve.setName(wrong.getName());
				solve.setUserlist_id(wrong.getUserlist_id());
				solve.setStatus("已处理");
				solveService.gotosolve(id, solve);
				model.addAttribute("error", "duesucess");
				return "redirect:selectall.action";
			}
}
