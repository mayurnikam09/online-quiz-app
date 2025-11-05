package com.exam.examportal.service;

import java.util.Set;

import com.exam.examportal.entity.exam.Question;
import com.exam.examportal.entity.exam.Quiz;

public interface QuestionService {

	public Question addQuetion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getQuestions();
	
	public Question getQuestion(Long questionId);
	
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	
	public void deleteQuestion(Long quesId);
}
