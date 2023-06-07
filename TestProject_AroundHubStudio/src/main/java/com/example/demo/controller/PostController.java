package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

	@PostMapping(value="/defualt")
	public String postMethod() {
		return "hello world PostMappingTest";
	}
	
	//http://localhost:8080/api/vi/post-api/member
	@PostMapping(value = "/member")
	public String postMember(@RequestBody Map<String, Object> postData) {
		StringBuilder sb = new StringBuilder();
		postData.entrySet().forEach(map->{
			sb.append(map.getKey() + " " + map.getValue()+"\n");
		});
		return sb.toString();
	}
	
	@PostMapping(value = "/member2")
	public String postMember2(@RequestBody MemberDTO memberDTO) {
		return memberDTO.toString();
	}
	
}
