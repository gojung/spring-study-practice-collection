package com.gojung.jpashop.api;

import com.gojung.jpashop.domain.Member;
import com.gojung.jpashop.service.MemberService;
import javax.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberApiController {

  private final MemberService memberService;

  @PostMapping("/api/v1/members")
  public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member){
    Long id = memberService.join(member);
    return new CreateMemberResponse(id);
  }

  @PostMapping("/api/v2/members")
  public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request){
    Member member = new Member();
    member.setName(request.name);
    Long id = memberService.join(member);
    return new CreateMemberResponse(id);
  }

  @Data
  static class CreateMemberRequest{
    private String name;
  }

  @Data
  static class CreateMemberResponse{
    private Long id;

    public CreateMemberResponse(Long id){
      this.id = id;
    }
  }

}
