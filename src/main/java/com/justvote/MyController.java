package com.justvote;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.justvote.dao.IRegisterDao;
import com.justvote.dao.IVotePageDao;
import com.justvote.dto.RegisterDto;
import com.justvote.dto.VotePageDto;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MyController {

	@Autowired // dao �� ���
	IRegisterDao dao;
	@Autowired
	IVotePageDao dao2;

	@RequestMapping("/")
	public String root() throws Exception {

		return "";
	}

	@PostMapping("/register") // front���� back���� �ִ� ������̼�
	public String write(@RequestBody RegisterDto registerDto) { // @RequestBody�� �־�� ������ �ȴ�
		dao.registerDao(registerDto.getUserName(), registerDto.getSex(), registerDto.getAge(), registerDto.getMajor(),
				registerDto.getGrade(), registerDto.getNickName(), registerDto.getUserId(), registerDto.getUserPass());

		return registerDto.toString();
	}

	@PostMapping("/signin")
	public String login(@RequestBody RegisterDto loginDto) {
		dao.loginDao(loginDto.getUserId(), loginDto.getUserPass());

		return loginDto.toString();
	}

	@PostMapping("/registVote") // votepage(���̺�) �����
	public String registVote(@RequestBody VotePageDto votePageDto) {
		dao2.registeVoteDao(votePageDto.getUserID(), votePageDto.getVoteTitle(), votePageDto.getVoteContent(),
				votePageDto.getVoteEndDate());

		return votePageDto.toString();
	}

	@PostMapping("/deleteVote") // delete
	public String deleteVote(@RequestBody VotePageDto votePageDto) {
		dao2.deleteVoteDao(votePageDto.getVoteID());

		return votePageDto.toString();
	}
	
	@PostMapping("/registeSelecDao") // ���� �߰�
	public String registeSelec(@RequestBody VotePageDto votePageDto) {
		dao2.registeSelecDao(votePageDto.getVoteID(), votePageDto.getSelecContent());
		
		return votePageDto.toString();
	}
	
	@GetMapping("/justvote") // test
	public String test(@RequestBody VotePageDto votePageDto) {
		dao2.testDao(votePageDto.getVoteID());
		
		return votePageDto.toString();
	}
	
	
	// ���� Get �����ֱ�
	@GetMapping("/content/3")
	public List<VotePageDto> votePageGet(HttpServletRequest request) {
		
		// return ���� List
		List<VotePageDto> list = new ArrayList<>();
		
		// votePage�� selecList�� list�� �־��� ����
		VotePageDto votePage = dao2.voteGetDao("3");
		List<VotePageDto> selecList = dao2.selecGetDao("3");
		
		list.add(votePage);
		for (int i = 0; i < selecList.size(); i++) {
			list.add(selecList.get(i));
		}

		return list;
	}
	
//	@GetMapping("/content")
//	public List<VotePageDto> 

	
	
//	 // ���� ��ǥ�����
//	@PostMapping("/makeVote") // votepage(���̺�) �����
//	public void makevote(@RequestBody VotePageDto votePageDto) {
//		
//	}
	

	
	/*@GetMapping("/")
	public String list(@RequestBody VotePageDto votePageDto) {
		dao2.listDao();
		
		return votePageDto.toString();
	}*/
}
