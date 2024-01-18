package testing.demo.business.sample.repository;

import static testing.demo.business.sample.entity.QSampleMemberEntity.sampleMemberEntity;
import static testing.demo.business.sample.entity.QSampleTeamEnity.sampleTeamEnity;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import testing.demo.business.sample.entity.SampleMemberEntity;
import testing.demo.business.sample.entity.SampleTeamEnity;

@Repository
public class SampleMemberRepository {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    
    public SampleMemberRepository(EntityManager em){
        this.em = em;
        queryFactory = new JPAQueryFactory(em);
    }

    public void test1(){
        SampleMemberEntity sme = new SampleMemberEntity();
        sme.setName("맴버1");
        em.persist(sme);

        SampleTeamEnity ste = new SampleTeamEnity();
        ste.setName("팀1");
        em.persist(ste);

        List<SampleMemberEntity> resultMember = queryFactory
                                                .selectFrom(sampleMemberEntity)
                                                .fetch();

        List<SampleTeamEnity> resultTeam = queryFactory
                                            .selectFrom(sampleTeamEnity)
                                            .fetch();

        System.out.println(resultMember);
        System.out.println(resultTeam);
    }
}
