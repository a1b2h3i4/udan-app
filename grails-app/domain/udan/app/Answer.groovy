package udan.app

class Answer {
    Option option
    static belongsTo = [
            question: Question
    ]
    static constraints = {
        option nullable: true
    }
}
