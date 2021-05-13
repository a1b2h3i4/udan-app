package com.udan

import grails.converters.JSON
import udan.app.Question

class QuestionController {
    def questionService

    def create() {
        Map data = [:]
        String title = params.title
        if (!(title == null || title.equals(""))) {
            Question question = new Question()
            bindData(question, params)
            questionService.save(question)
            response.status = 201
            data.msg = "Question has been successfully saved"
        } else {
            response.status = 422
            data.msg = "Input format is not valid"
        }
        render data as JSON
    }
}
