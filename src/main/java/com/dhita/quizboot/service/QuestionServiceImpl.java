package com.dhita.quizboot.service;

import com.dhita.quizboot.model.Question;
import com.dhita.quizboot.repository.QuestionRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

  @Autowired QuestionRepository questionRepository;

  @Override
  public List<Question> saveAll(List<Question> questions) {
    return questionRepository.saveAll(questions);
  }

  @Override
  public Page<Question> findAll(int pageNumber, int size) {
    Pageable page = PageRequest.of(pageNumber, size);
    return questionRepository.findAll(page);
  }

  @Override
  public List<Question> findAll(Long categoryId) {
    return questionRepository.findAllByCategoryId(categoryId);
  }

  @Override
  public Page<Question> findAll(Long categoryId, int pageNumber, int size) {
    Pageable pageable = PageRequest.of(pageNumber, size);
    return questionRepository.findAllByCategoryId(categoryId,pageable);
  }

  @Override
  public List<Question> findAll() {
    return questionRepository.findAll();
  }

  @Override
  public Optional<Question> findById(Long questionId) {
    return questionRepository.findById(questionId);
  }

  @Override
  public Question save(Question question) {
    return questionRepository.saveAndFlush(question);
  }

  @Override
  public Map<Integer, Question> findAllByCategory(Long category, Integer size) {
    List<Question> questionList = questionRepository.findAllByCategoryId(category);
    Map<Integer,Question> questionMap = new HashMap<>();
    int listSize = Math.min(questionList.size(), size);
    if(listSize > 0){
      for(int i=1;i<=listSize;i++){
        questionMap.put(i, questionList.get(i-1));
      }
    }
    return questionMap;
  }

  @Override
  public Question update(Question question){
    Question existingQuestion = questionRepository.findById(question.getId()).orElseThrow(()->new IllegalArgumentException("Question not found"));
    existingQuestion.setText(question.getText());
    existingQuestion.setOptions(question.getOptions());
    existingQuestion.setCategory(question.getCategory());
    return questionRepository.save(existingQuestion);
  }

  @Override
  public void delete(Long questionId) {
    questionRepository.deleteById(questionId);
  }
}