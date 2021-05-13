package udan.app

class Quiz {
    String name
    static constraints = {
        name nullable: true
    }
    static hasMany = [
            questions: Question
    ]
}
