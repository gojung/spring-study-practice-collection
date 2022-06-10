package com.gojung.springjpa;

import com.gojung.springjpa.dto.SaveMemberResponseDto;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class MemberService {

  private final MemberRepository memberRepository;

  public SaveMemberResponseDto create(String username, Integer age) {
    Member member = Member.builder().username(username).age(age).build();
    Member savedMember = memberRepository.save(member);
    return new SaveMemberResponseDto(savedMember.getId());
  }

  public void update(Long id, String name) {
    Member member = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("id없음"));
    member.updateUsername(name);
  }

  public Member findById(Long id) {
    Member member = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("id없음"));
    return member;
  }

  public void deleteById(Long id) {
    memberRepository.deleteById(id);
  }
}
