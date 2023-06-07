package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/put-api")
public class putContoller {
	
	@PutMapping(value = "/default")
	public String putDefault() {
		return "default";
	}
	
	@PutMapping(value = "/member")
	public String postMember(@RequestBody Map<String,Object> putData) {
		StringBuilder sb = new StringBuilder();
		putData.entrySet().forEach(map->{
			sb.append(map.getKey() + " " + map.getValue() + "\n");
		});
		return sb.toString();
	}
	
	@PutMapping(value = "/member2")
	public String postMemberDTO2(@RequestBody MemberDTO memberDTO) {
		return memberDTO.toString();
	}
	
	@PutMapping(value = "/member3")
	public MemberDTO postMemberDTO3(@RequestBody MemberDTO memberDTO) {
		return memberDTO;
	}
	
	@PutMapping(value = "/member4")
	public ResponseEntity<MemberDTO> postMember4(@RequestBody MemberDTO memberDTO){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
	}
}
