package com.gojung.springjpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

@Slf4j
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

  @Test
  @DisplayName("회원 등록")
  void createTest() {
    String username = "test21423";
    Integer age = 1;
    Long userId = 0L;
    Member member = Member.builder().username(username).age(age).build();
    ReflectionTestUtils.setField(member, "id", userId);
//    given(memberRepository.save(any())).willReturn(member);
    doReturn(member).when(memberRepository).save(any());
    Long id = memberService.create(username, age);
    assertThat(id).isEqualTo(userId);
  }


}
