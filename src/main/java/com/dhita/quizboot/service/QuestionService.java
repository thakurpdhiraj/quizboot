package com.dhita.quizboot.service;

import com.dhita.quizboot.model.Question;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface QuestionService {

  /**
   * Find all by filter
   *
   * @param pageNumber pageNumber
   * @param size size
   * @return Page
   */
  Page<Question> findAll(int pageNumber, int size);

  /**
   * Find all
   *
   * @param categoryId category id
   * @return List
   */
  List<Question> findAll(Long categoryId);

  /**
   * Find by category
   *
   * @param category category
   * @param size size
   * @return Map
   */
  Map<Integer, Question> findAllByCategory(Long category, Integer size);

  /**
   * Find all by filter
   *
   * @param categoryId category id
   * @param pageNumber pageNumber
   * @param size size
   * @return Page
   */
  Page<Question> findAll(Long categoryId, int pageNumber, int size);

  /**
   * Find all
   *
   * @return List
   */
  List<Question> findAll();
  /**
   * Find questions by id
   *
   * @param questionId question id
   * @return Optional
   */
  Optional<Question> findById(Long questionId);

  /**
   * Save question
   *
   * @param question question
   * @return Question
   */
  Question save(Question question);

  /**
   * Save all questions
   *
   * @param questions questions
   * @return List
   */
  List<Question> saveAll(List<Question> questions);

  /**
   * Update question
   *
   * @param question question
   * @return Question
   */
  Question update(Question question);

  /**
   * Delete question
   *
   * @param questionId question id
   */
  void delete(Long questionId);
}