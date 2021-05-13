package com.udan

import grails.gorm.transactions.Transactional
import udan.app.Submission

@Transactional
class SubmissionService {

    def save(Submission submission) {
        if (submission.validate()) {
            submission.save()
        }
    }
}
