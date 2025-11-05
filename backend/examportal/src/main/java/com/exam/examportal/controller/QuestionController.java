package com.exam.examportal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.entity.exam.Question;
import com.exam.examportal.entity.exam.Quiz;
import com.exam.examportal.service.QuestionService;
import com.exam.examportal.service.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	public QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	//add question
	@PostMapping("/")
	public ResponseEntity<Question> add(@RequestBody Question question)
	{
		return ResponseEntity.ok(this.questionService.addQuetion(question));
	}
	
	//update question
	@PutMapping("/")
	public ResponseEntity<Question> update(@RequestBody Question question)
	{
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	
	//get all question of any quiz 
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionQuiz(@PathVariable("qid") long qid)
	{
		//Quiz quiz=new Quiz();
		//quiz.setQid(qid);
		//Set<Question> questionsOfQuiz=this.questionService.getQuestionsOfQuiz(quiz);
		//return ResponseEntity.ok(questionsOfQuiz);
		
		Quiz quiz=this.quizService.getQuiz(qid);
		Set<Question> questions=quiz.getQuestions();
		
		ArrayList list=new ArrayList(questions);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuetions()))
		{
			list=(ArrayList) list.subList(0,Integer.parseInt(quiz.getNumberOfQuetions()+1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionQuizAdmin(@PathVariable("qid") long qid)
	{
		Quiz quiz=new Quiz();
		quiz.setQid(qid);
		Set<Question> questionsOfQuiz=this.questionService.getQuestionsOfQuiz(quiz);
		return ResponseEntity.ok(questionsOfQuiz);
		
	}
	
	
	//get single quetion
	@GetMapping("/{quesId}")
	public Question get(@PathVariable("quesId") Long quesId)
	{
		return this.questionService.getQuestion(quesId);
	}
	
	
	//delete question
	@DeleteMapping("/{quesId}")
	public void delete(@PathVariable("quesId") long quesId)
	{
		this.questionService.deleteQuestion(quesId);
	}
}
