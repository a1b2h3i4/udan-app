package com.udan

import grails.gorm.transactions.Transactional
import udan.app.Option
import udan.app.Question

@Transactional
class OptionService {

    def save(Option option) {
        if (option.validate()) {
            option.save()
            if (!option.hasErrors()) {
                Question question = option.question
                question.options.add(option)
                question.save()
            }
        }
    }
}
