package com.gojung.jpashop.service;

import com.gojung.jpashop.domain.Member;
import com.gojung.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
  
  private final MemberRepository memberRepository;
  
  public Long join(Member member){
    return memberRepository.save(member).getId();
  }

}
