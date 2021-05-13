package udan.app

class Question {
    String title
    Answer answer
    static hasMany = [
            options: Option
    ]
    static constraints = {
        options maxSize: 4
        answer nullable: true
    }
}
