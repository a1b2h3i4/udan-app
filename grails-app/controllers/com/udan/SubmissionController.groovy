package com.udan

import grails.converters.JSON
import udan.app.Option
import udan.app.Question
import udan.app.Quiz
import udan.app.Response
import udan.app.Submission

class SubmissionController {
    def submissionService
    def responseService

    def save(Quiz quiz) {
        Map data = [:]
        if (quiz) {
            String questionIds = params.questionIds
            List<String> questionList = questionIds.split(",")
            String optionIds = params.optionIds
            List<String> optionIdList = optionIds.split(",")
//            if (questionList.size() != optionIdList.size()) {
            List<Response> responseArrayList = []
            for (int i = 0; i < questionList.size(); i++) {
                Integer questionId = Integer.parseInt(questionList[i])
                Integer optionId = Integer.parseInt(optionIdList[i])
                Question question = Question.findById(questionId)
                Option option = Option.findById(optionId)
                Response response = new Response(question: question, option: option)
                responseService.save(response)
                responseArrayList.add(response)
            }
            Submission submission = new Submission(quiz: quiz)
            submissionService.save(submission)
            responseArrayList.each { Response response ->
                submission.addToResponses(response)
            }
            response.status = 201
            data.msg = "Submission has been successfully saved"
        } else {
            response.status = 422
            data.msg = "Quiz does not exists"
        }
        render data as JSON
    }
}
