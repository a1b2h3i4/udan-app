package com.udan

import grails.gorm.transactions.Transactional
import udan.app.Question

@Transactional
class QuestionService {

    def save(Question question) {
        if (question.validate()) {
            question.save()
        } else {

        }
    }
}
