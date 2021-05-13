package com.udan

import grails.converters.JSON
import udan.app.Question
import udan.app.Quiz

class QuizController {
    def quizService

    def create() {
        Map data = [:]
        String questions = params.questions
        List<String> questionIdList = questions.split(",")
        Boolean flag = Boolean.FALSE
        List<Question> questionList = []
        for (String questionId : questionIdList) {
            Integer id = Integer.parseInt(questionId)
            Question question = Question.findById(id)
            if (!question) {
                flag = Boolean.TRUE
                break
            }
            questionList.add(question)
        }
        if (!flag) {
            Quiz quiz = new Quiz()
            quiz.name = params.name
            quizService.save(quiz)
            questionList.each { Question question ->
                quiz.addToQuestions(question)
            }
            quizService.save(quiz)
            response.status = 201
            data.msg = "Question has been successfully saved"
        } else {
            response.status = 422
            data.msg = "Some of the questions does not exists"
        }
        render data as JSON
    }

    def getAllQuizes() {
        Map data = [:]
        data.quizList = quizService.getAllQuizs(params)
        render data as JSON
    }
}
