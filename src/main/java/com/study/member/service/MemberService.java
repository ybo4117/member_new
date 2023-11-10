package com.study.member.service;

import com.study.member.dto.MemberDTO;
import com.study.member.entity.MemberEntity;
import com.study.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    //생성자 주입
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        // 1. dto -> entity 로 변환
        // 2. repository의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity); // jpa가 제공해주는 save메서드 호출

        // repository의 save메서드 호출 (조건 . entity의 객체를 넘겨줘야 함)
    }

    public MemberDTO login(MemberDTO memberDTO) {
        /*
            1. 회원 입력한 메일로 DB에서 조회
            2. DB에서 비밀번호가 일치하는지 판단
         */
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if(byMemberEmail.isPresent()){ // 조회 결과가 있다(해당 이메일을 가진 회원 정보가 있다)
            MemberEntity memberEntity = byMemberEmail.get();

            // 비밀번호 일치 여부
            if(memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())){
                // entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            }
            else{ return null; }
        }else{ // 조회 결과가 없다
            return null;
        }
    }
}
