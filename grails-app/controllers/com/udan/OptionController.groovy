package com.udan

import grails.converters.JSON
import udan.app.Option
import udan.app.Question

class OptionController {
    def optionService

    def create(Question question) {
        Map data = [:]
        String description = params.description
        if (question && description) {
            Option option = new Option(question: question)
            bindData(option, params)
            optionService.save(option)
            response.status = 201
            data.msg = "Option has been saved"
        } else {
            response.status = 404
            data.msg = "Question does not exists"
        }
        render data as JSON
    }
}
