package com.udan

import grails.gorm.transactions.Transactional
import udan.app.Answer

@Transactional
class AnswerService {

    def save(Answer answer) {
        if (answer.validate()) {
            answer.save()
        }
    }
}
