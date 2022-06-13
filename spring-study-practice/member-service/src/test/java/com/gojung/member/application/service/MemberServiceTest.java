package com.gojung.member.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import com.gojung.member.application.dto.SaveMemberResponseDto;
import com.gojung.member.domain.Member;
import com.gojung.member.domain.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

@Slf4j
@AutoConfigureRestDocs
@ExtendWith(SpringExtension.class)
public class MemberServiceTest {

  @Mock
  MemberRepository memberRepository;

  @InjectMocks
  private MemberService memberService;

  @BeforeEach
  void init() {
    memberRepository.deleteAll();
  }

  //  @Test
//  @DisplayName("회원 등록")
//  void createTest() {
//    String username = "test21423";
//    Integer age = 1;
//    Long userId = 0L;
//    Member member = Member.builder().username(username).age(age).build();
//    ReflectionTestUtils.setField(member, "id", userId);
////    given(memberRepository.save(any())).willReturn(member);
//    doReturn(member).when(memberRepository).save(any());
//    Long id = memberService.create(username, age);
//    assertThat(id).isEqualTo(userId);
//
//
//  }
  @Test
  @DisplayName("회원 등록")
  void createTest() {
    String username = "test21423";
    Integer age = 1;
    Long userId = 0L;
    Member member = Member.builder().username(username).age(age).build();
    ReflectionTestUtils.setField(member, "id", userId);
    doReturn(member).when(memberRepository).save(any());
    SaveMemberResponseDto dto = memberService.create(username, age);
    assertThat(dto.getId()).isEqualTo(userId);


  }

}
