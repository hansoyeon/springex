package cafe.jjdev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.web.service.Member;
import cafe.jjdev.web.service.MemberDao;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value ="/memberList", method = RequestMethod.GET)
	public String memberList() {
		System.out.println("memberList 요청");
		// DB list get...
		return "memberList";
	}
	
	@RequestMapping(value ="/addMember", method = RequestMethod.POST)
	// command객체이용하는 방법
	public String addMemeber(MemberRequest memberRequest) {
		System.out.println(memberRequest);
		// DB입력
		return "redirect:/memberList"; // response.sendRedirect("/memberList")
	}
	
/*	@RequestParam 각각
    @RequestMapping(value ="/addMember", method = RequestMethod.POST)
	public String addMemeber(@RequestParam(value="memberId") String memberId
							, @RequestParam(value="memberId") String memberPw
							, @RequestParam(value="memberId") String memberName) {
			System.out.println("memberId:"+memberId);
			System.out.println("memberPw:"+memberPw);
			System.out.println("memberName:"+memberName);
		return "";
	}*/
	
	@RequestMapping(value ="/addMember", method = RequestMethod.GET)
	public String addMemeber() {
		return "addMember";
	}
	
	@RequestMapping("/getMember")
	public String getMember(Model model) {
		Member member = memberDao.selectMemberOne(1);
		model.addAttribute("member", member);
		return "getMember";
	}
}
