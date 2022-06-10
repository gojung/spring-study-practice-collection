package com.gojung.springjpa;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gojung.springjpa.dto.SaveMemberDto;
import com.gojung.springjpa.dto.SaveMemberResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@WebMvcTest(controllers = MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class MemberControllerTest {

  @Autowired
  private MockMvc mockMvc;

  //얘가 있어야 MemberController를 끌어온다
  @MockBean
  private MemberService memberService;


  @DisplayName("Save Member")
  @Test
  void save_member() throws Exception {
    //given
    SaveMemberDto dto = new SaveMemberDto("gojung", 20);
    String content = new ObjectMapper().writeValueAsString(dto);
    final String url = "/api/v1/members";
    SaveMemberResponseDto dto1 = new SaveMemberResponseDto(0L);
    doReturn(dto1).when(memberService).create(any(), any());
    //when
    ResultActions res = mockMvc.perform(post(url)
            .content(content)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().isOk())

        .andDo(
            document("member-save",
                requestFields(
                    fieldWithPath("userName").description("Member Name"),
                    fieldWithPath("age").description("Member Age")
                ),
                responseFields( // response 필드 정보 입력
                    fieldWithPath("id").description("user ID")
                )
            )
        );
  }

}