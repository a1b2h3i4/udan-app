package udan.app

class Response {
    Answer answer
    static belongsTo = [
            question: Question,
    ]
    static constraints = {
        answer nullable: true
    }
}
