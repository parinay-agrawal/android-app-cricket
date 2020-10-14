package com.example.helloworld.data

data class Comment(val name: String, val message: String, val votes: Int, val level: Int) {

    companion object {
        fun createMessages(numMessages: Int): ArrayList<Comment> {
            val genericMessage = "This is some arbitary comment used to test in message flow in comments section... And this is a copy of the previous message: This is some arbitary comment used to test in message flow in comments section";
            val comments = ArrayList<Comment>()
            for (i in 1..numMessages) {
                comments.add(Comment("Person" + i, message = genericMessage + i, votes = i, level = i ))
            }
            return comments
        }
    }
}