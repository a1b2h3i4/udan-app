package com.udan

import grails.gorm.transactions.Transactional
import udan.app.Response

@Transactional
class ResponseService {

    def save(Response response) {
        if (response.validate()) {
            response.save()
        }
    }
}
