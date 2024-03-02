package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)//스프링관련된거 테스트할거다 라고 알려줌
@SpringBootTest
public class MemberRepositoryTest {

    //MemberRepository와 관련된거 테스트할거니까 인젝션도 얘로
    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)//이거없으면 test데이터는 테이블에서 삭제됨
    public void testMember() throws Exception{
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
        Assertions.assertThat(member.getUsername()).isEqualTo(findMember.getUsername());
    }

    @Test
    public void save() {
        //given

        //when

        //then


    }

    @Test
    public void find() {
        //when

        //given

        //then
    }
}