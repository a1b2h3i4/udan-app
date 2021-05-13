package com.udan

import grails.converters.JSON
import udan.app.Answer
import udan.app.Option
import udan.app.Question

class AnswerController {
    def answerService

    def create(Question question) {
        Map data = [:]
        if (question) {
            Option option = Option.findById(params.optionId)
            if (option) {
                Answer answer = new Answer(question: question)
                answer.option = option
                answerService.save(answer)
                response.status = 201
                data.msg = "Answer has been saved"
            } else {
                response.status = 404
                data.msg = "Option does not exists"
            }
        } else {
            response.status = 404
            data.msg = "Question does not exists"
        }
        render data as JSON
    }
}
