package com.mysite.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionServer questionServer;
    @GetMapping("/question/list")
    public String list(Model model){
        List<Question> questionList = this.questionServer.getList();
        model.addAttribute("questionList",questionList);
        return "question_list";
    }


    @GetMapping(value = "/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Question question = this.questionServer.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }


}
