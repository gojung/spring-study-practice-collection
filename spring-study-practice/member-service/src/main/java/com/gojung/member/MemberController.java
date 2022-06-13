package com.gojung.member;

import com.gojung.member.application.dto.SaveMemberDto;
import com.gojung.member.application.dto.SaveMemberResponseDto;
import com.gojung.member.application.service.MemberService;
import com.gojung.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
@RestController
public class MemberController {

  private final MemberService memberService;

  @PostMapping
  public ResponseEntity<SaveMemberResponseDto> saveMember(@RequestBody SaveMemberDto dto) {
    SaveMemberResponseDto responseDto = memberService.create(dto.getUserName(), dto.getAge());
    return ResponseEntity.status(200).body(responseDto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Member> saveMember(@PathVariable Long id) {
    Member member = memberService.findById(id);
    return ResponseEntity.status(200).body(member);
  }

}
