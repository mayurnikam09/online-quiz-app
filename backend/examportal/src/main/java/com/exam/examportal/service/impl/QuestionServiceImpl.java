package com.exam.examportal.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examportal.entity.exam.Question;
import com.exam.examportal.entity.exam.Quiz;
import com.exam.examportal.repo.QuestionRepository;
import com.exam.examportal.repo.QuizRepository;
import com.exam.examportal.service.QuestionService;

import io.jsonwebtoken.lang.Objects;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question addQuetion(Question question) {

		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {

		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {

		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) {

		return this.questionRepository.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {

		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long quesId) {
		Question question=new Question();
		question.setQuesid(quesId);
		this.questionRepository.delete(question);
	}

}
