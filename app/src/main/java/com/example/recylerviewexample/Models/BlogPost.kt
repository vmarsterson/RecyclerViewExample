package com.example.recylerviewexample.Models

data class BlogPost(
    var title: String,
    var body: String,
    var image: String,
//    save the pointer to where the image lives, not just the image
    var username: String
) {
    override fun toString(): String {
        return "BlogPost(title='$title', image='$image', username='$username')"
    }
}