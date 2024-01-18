package testing.demo.business.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import testing.demo.business.sample.service.SampleMemberService;

@Controller
@RequiredArgsConstructor
public class SampleController {
    final SampleMemberService sampleMemberService;

    @GetMapping("/")
    public String index(Model model){
        sampleMemberService.test1();

        model.addAttribute("message", "Hello Spring Security");
        return "index";
    }
}