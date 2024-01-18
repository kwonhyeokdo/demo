package testing.demo.business.sample.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import testing.demo.business.sample.entity.QSampleMemberEntity;
import testing.demo.business.sample.entity.SampleMemberEntity;

@Repository
public class SampleMemberRepository {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    
    public SampleMemberRepository(EntityManager em){
        this.em = em;
        queryFactory = new JPAQueryFactory(em);
    }

    public void test1(){
        SampleMemberEntity sampleMemberEntity = new SampleMemberEntity();
        sampleMemberEntity.setName("하이");
        em.persist(sampleMemberEntity);

        QSampleMemberEntity a = QSampleMemberEntity.sampleMemberEntity;
        List<SampleMemberEntity> result = queryFactory
                                            .selectFrom(a)
                                            .fetch();
        System.out.println(result);
    }
}
