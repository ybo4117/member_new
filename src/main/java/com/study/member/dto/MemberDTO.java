package com.study.member.dto;


import com.study.member.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor // 필드의 기본생성자를 만듬
@AllArgsConstructor // 필드를 매개변수로하는 생성자를 만듬
@ToString
public class MemberDTO { // 회원정보의 필요한 데이터들을 필드로 정의 후 간접적으로 사용하기위해
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());
        return memberDTO;
    }
}
