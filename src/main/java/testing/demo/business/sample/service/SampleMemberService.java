package testing.demo.business.sample.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import testing.demo.business.sample.repository.SampleMemberRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SampleMemberService {
    final SampleMemberRepository sampleMemberRepository;

    @Transactional
    public void test1(){
        sampleMemberRepository.test1();
    }
}
