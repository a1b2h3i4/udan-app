package udan.app

class Option {
    String description
    static belongsTo = [
            question: Question
    ]
    static constraints = {
    }
}
