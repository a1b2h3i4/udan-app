package com.udan

import grails.gorm.transactions.Transactional
import udan.app.Quiz

@Transactional
class QuizService {

    def save(Quiz quiz) {
        if (quiz.validate()) {
            quiz.save()
        }
    }

    def getAllQuizs(Map params) {
        Integer max = params.max ?: 10
        Integer offset = params.offset ?: 0
        List<Quiz> quizList = Quiz.findAll([max: max, offset: offset])
        return quizList
    }
}
