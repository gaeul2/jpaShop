package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    // JPA 사용할때는 EntityManager사용하는데 이 어노테이션 있으면 스프링부트가 알아서 주입해줌
    @PersistenceContext
    EntityManager em;

    public Long save(Member member){
        em.persist(member); //이게 저장이래
        return member.getId();
    }

    public Member find(Long id){
        return em.find(Member.class ,id);
    }
}
