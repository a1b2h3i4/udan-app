package udan.app

class Submission {
    static belongsTo = [
            quiz: Quiz
    ]
    static hasMany = [
            responses: Response
    ]
    static constraints = {
    }
}
